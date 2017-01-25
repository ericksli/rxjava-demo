package com.example.rxjavademo.api;


import com.example.rxjavademo.model.Course;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface ApiService {
    @GET("course-offerings/{semester}/courses/{code}.json")
    Observable<Course> courseDetail(@Path("semester") String semester, @Path("code") String courseCode);
}
