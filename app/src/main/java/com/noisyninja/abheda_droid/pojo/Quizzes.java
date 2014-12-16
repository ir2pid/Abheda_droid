package com.noisyninja.abheda_droid.pojo;

import java.util.ArrayList;

/**
 * Created by ir2pi on 11/30/2014.
 */
public class Quizzes extends BasePojo{

    ArrayList<MCQQuiz> mcqQuizs;
    ArrayList<OrderGameQuiz> orderGameQuizs;

    public ArrayList<MCQQuiz> getMcqQuizs() {
        return mcqQuizs;
    }

    public void setMcqQuizs(ArrayList<MCQQuiz> mcqQuizs) {
        this.mcqQuizs = mcqQuizs;
    }

    public ArrayList<OrderGameQuiz> getOrderGameQuizs() {
        return orderGameQuizs;
    }

    public void setOrderGameQuizs(ArrayList<OrderGameQuiz> orderGameQuizs) {
        this.orderGameQuizs = orderGameQuizs;
    }
}
