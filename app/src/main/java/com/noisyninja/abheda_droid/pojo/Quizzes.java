package com.noisyninja.abheda_droid.pojo;

import java.util.ArrayList;

/**
 * Created by ir2pi on 11/30/2014.
 */
public class Quizzes extends BasePojo{

    ArrayList<Lesson> quizzes;

    public ArrayList<Lesson> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(ArrayList<Lesson> quizzes) {
        this.quizzes = quizzes;
    }
}
