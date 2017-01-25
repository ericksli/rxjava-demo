package com.example.rxjavademo.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.example.rxjavademo.R;
import com.example.rxjavademo.api.ApiService;
import com.example.rxjavademo.model.Course;
import com.example.rxjavademo.model.Group;
import com.example.rxjavademo.model.Section;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Shows the list of instructors for GE1501.
 *
 * Showing the use of Rx operators.
 *
 * API:
 * https://fir-test-197b2.firebaseapp.com/course-offerings/1516b/courses/ge1501.json
 */
public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";

    @Inject
    ApiService mApiService;

    private InstructorListRecyclerViewAdapter mRecyclerViewAdapter;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);

        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setTitle("GE1501");
        getSupportActionBar().setSubtitle("2015/16 Sem B");

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL, getResources().getDrawable(R.drawable.divider)));
        mRecyclerViewAdapter = new InstructorListRecyclerViewAdapter();
        recyclerView.setAdapter(mRecyclerViewAdapter);

        loadData();
    }

    /**
     * We load course detail, extract the name of instructors from sections and groups objects,
     * remove duplicated names, sort the names and finally get the list of names for rendering.
     */
    private void loadData() {
        Disposable disposable = mApiService.courseDetail("1516b", "ge1501")
                .subscribeOn(Schedulers.io())
                .flatMap(new Function<Course, ObservableSource<Section>>() {
                    @Override
                    public ObservableSource<Section> apply(Course course) throws Exception {
                        return Observable.fromIterable(course.getSections());
                    }
                })
                .flatMap(new Function<Section, ObservableSource<Group>>() {
                    @Override
                    public ObservableSource<Group> apply(Section section) throws Exception {
                        return Observable.fromIterable(section.getGroups());
                    }
                })
                .flatMap(new Function<Group, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(Group group) throws Exception {
                        Log.d(TAG, "apply: on thread " + Thread.currentThread().getName());
                        return Observable.fromIterable(group.getInstructors());
                    }
                })
                .distinct()
                .toSortedList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<String>>() {
                    @Override
                    public void onSuccess(List<String> instructors) {
                        Log.d(TAG, "onSuccess() called with: instructors = [" + instructors + "]");
                        Log.d(TAG, "onSuccess: on thread " + Thread.currentThread().getName());
                        mRecyclerViewAdapter.setInstructors(instructors);
                        mRecyclerViewAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError() called with: e = [" + e + "]");
                        Log.d(TAG, "onError: on thread " + Thread.currentThread().getName());
                        Toast.makeText(MainActivity.this, "Error occurred when loading course!", Toast.LENGTH_SHORT).show();
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCompositeDisposable.dispose();
    }
}
