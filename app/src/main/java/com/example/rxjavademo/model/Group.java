package com.example.rxjavademo.model;

import java.util.List;



public class Group {
    private String building;

    public String getBuilding() {
        return this.building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    private String date;

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String day;

    public String getDay() {
        return this.day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    private List<String> instructors;

    public List<String> getInstructors() {
        return this.instructors;
    }

    public void setInstructors(List<String> instructors) {
        this.instructors = instructors;
    }

    private List<String> notes;

    public List<String> getNotes() {
        return this.notes;
    }

    public void setNotes(List<String> notes) {
        this.notes = notes;
    }

    private String room;

    public String getRoom() {
        return this.room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    private String time;

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
