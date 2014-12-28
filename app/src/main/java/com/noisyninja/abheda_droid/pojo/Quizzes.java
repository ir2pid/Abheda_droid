package com.noisyninja.abheda_droid.pojo;

import java.util.ArrayList;

/**
 * Created by ir2pi on 11/30/2014.
 */
public class Quizzes extends BasePojo{

    ArrayList<MCQQuiz> mcqQuizs;
    ArrayList<OrderGameQuiz> orderGameQuizs;
    ArrayList<PictureMatchQuiz> pictureMatchQuiz;

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

    public ArrayList<PictureMatchQuiz> getPictureMatchQuiz() {
        return pictureMatchQuiz;
    }

    public void setPictureMatchQuiz(ArrayList<PictureMatchQuiz> pictureMatchQuiz) {
        this.pictureMatchQuiz = pictureMatchQuiz;
    }
}
