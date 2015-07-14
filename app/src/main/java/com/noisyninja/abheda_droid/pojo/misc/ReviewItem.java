package com.noisyninja.abheda_droid.pojo.misc;

/**
 * Created by ir2pi on 7/10/2015.
 */
public class ReviewItem {

    boolean isImage;
    String question;
    String correct;
    String wrong;

    public boolean isImage() {
        return isImage;
    }

    public void setImage(boolean isImage) {
        this.isImage = isImage;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public String getWrong() {
        return wrong;
    }

    public void setWrong(String wrong) {
        this.wrong = wrong;
    }
}
