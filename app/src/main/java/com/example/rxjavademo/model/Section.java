package com.example.rxjavademo.model;

import java.util.List;



public class Section {
    private String campus;

    public String getCampus() { return this.campus; }

    public void setCampus(String campus) { this.campus = campus; }

    private int capacity;

    public int getCapacity() { return this.capacity; }

    public void setCapacity(int capacity) { this.capacity = capacity; }

    private int credit;

    public int getCredit() { return this.credit; }

    public void setCredit(int credit) { this.credit = credit; }

    private int crn;

    public int getCrn() { return this.crn; }

    public void setCrn(int crn) { this.crn = crn; }

    private int enrolled;

    public int getEnrolled() { return this.enrolled; }

    public void setEnrolled(int enrolled) { this.enrolled = enrolled; }

    private List<Group> groups;

    public List<Group> getGroups() { return this.groups; }

    public void setGroups(List<Group> groups) { this.groups = groups; }

    private List<String> levels;

    public List<String> getLevels() { return this.levels; }

    public void setLevels(List<String> levels) { this.levels = levels; }

    private String section;

    public String getSection() { return this.section; }

    public void setSection(String section) { this.section = section; }

    private boolean webEnabled;

    public boolean getWebEnabled() { return this.webEnabled; }

    public void setWebEnabled(boolean webEnabled) { this.webEnabled = webEnabled; }
}
