package com.noisyninja.abheda_droid.pojo;

/**
 * Created by ir2pi on 12/2/2014.
 */
public class Course extends BasePojo {

    String name;
    String description;
    Lessons lessons;
    Quizzes quizzes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Lessons getLessons() {
        return lessons;
    }

    public void setLessons(Lessons lessons) {
        this.lessons = lessons;
    }

    public Quizzes getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(Quizzes quizzes) {
        this.quizzes = quizzes;
    }
}
