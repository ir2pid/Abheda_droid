package com.noisyninja.abheda_droid.pojo;

import java.util.ArrayList;

/**
 * Created by ir2pi on 12/13/2014.
 */
public class Module extends BasePojo {

    String name;
    int level;
    Courses courses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }
}
