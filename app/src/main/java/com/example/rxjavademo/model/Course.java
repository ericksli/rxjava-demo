package com.example.rxjavademo.model;

import java.util.List;


public class Course {
    private String academicUnit;

    public String getAcademicUnit() {
        return this.academicUnit;
    }

    public void setAcademicUnit(String academicUnit) {
        this.academicUnit = academicUnit;
    }

    private String code;

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String exclusiveCourses;

    public String getExclusiveCourses() {
        return this.exclusiveCourses;
    }

    public void setExclusiveCourses(String exclusiveCourses) {
        this.exclusiveCourses = exclusiveCourses;
    }

    private String prerequisites;

    public String getPrerequisites() {
        return this.prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    private List<Section> sections;

    public List<Section> getSections() {
        return this.sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    private String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private List<Demand> demand;

    public List<Demand> getDemand() {
        return this.demand;
    }

    public void setDemand(List<Demand> demand) {
        this.demand = demand;
    }
}
