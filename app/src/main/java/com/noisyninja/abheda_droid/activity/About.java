package com.noisyninja.abheda_droid.activity;

import android.app.Activity;
import android.os.Bundle;

import com.noisyninja.abheda_droid.R;
import com.noisyninja.abheda_droid.pojo.Course;
import com.noisyninja.abheda_droid.pojo.Courses;
import com.noisyninja.abheda_droid.pojo.Lesson;
import com.noisyninja.abheda_droid.pojo.Lessons;
import com.noisyninja.abheda_droid.pojo.Quiz;
import com.noisyninja.abheda_droid.pojo.Quizzes;

import java.util.ArrayList;

/**
 * Created by ir2pi on 12/3/2014.
 */
public class About extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        Courses courses = new Courses();
        ArrayList<Course> courseList = new ArrayList<Course>();

        Course course = new Course();
    }

    public Lessons getLessons()
    {
        Lessons lessons = new Lessons();

        ArrayList<Lesson> lessonsList = new ArrayList<Lesson>();

        lessons.setLessons(lessonsList);
        return lessons;
    }

    public Quizzes getQuizzes()
    {
        Quizzes quizzes = new Quizzes();
        ArrayList<Quiz> quizzesList = new ArrayList<Quiz>();

        return quizzes;
    }
}
