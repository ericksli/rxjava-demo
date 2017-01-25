package com.example.rxjavademo.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rxjavademo.R;

import java.util.List;


public class InstructorListRecyclerViewAdapter extends RecyclerView.Adapter<InstructorViewHolder> {
    private List<String> mInstructors;

    @Override
    public InstructorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_instructor, parent, false);
        return new InstructorViewHolder(v);
    }

    @Override
    public void onBindViewHolder(InstructorViewHolder holder, int position) {
        holder.bind(mInstructors.get(position));
    }


    @Override
    public int getItemCount() {
        if (mInstructors == null) {
            return 0;
        }
        return mInstructors.size();
    }

    public void setInstructors(List<String> instructors) {
        mInstructors = instructors;
    }
}
