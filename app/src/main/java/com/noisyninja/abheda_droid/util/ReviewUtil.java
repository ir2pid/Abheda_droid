package com.noisyninja.abheda_droid.util;

import com.noisyninja.abheda_droid.pojo.misc.ReviewItem;

import java.util.ArrayList;

/**
 * Created by ir2pi on 7/10/2015.
 */
public class ReviewUtil {
    static ReviewUtil instance;
    static ArrayList<ReviewItem> reviewItemArrayList = new ArrayList<ReviewItem>();
    ReviewItem reviewItem;

    private ReviewUtil() {

    }

    public static ReviewUtil getInstance() {


        if(instance == null) {
            instance = new ReviewUtil();
        }
        return instance;
    }

    public static void init(){
    //refresh list in basefragment constructor
        reviewItemArrayList = new ArrayList<ReviewItem>();
    }

    public void addOptions(String question, String wrong, String correct){
        reviewItem = new ReviewItem();
        reviewItem.setQuestion(question);
        reviewItem.setWrong(wrong);
        reviewItem.setCorrect(correct);
        reviewItemArrayList.add(reviewItem);
    }

    public void addOptions(String question, String wrong, String correct, boolean isImage) {
        reviewItem = new ReviewItem();
        reviewItem.setQuestion(question);
        reviewItem.setWrong(wrong);
        reviewItem.setCorrect(correct);
        reviewItem.setImage(isImage);
        reviewItemArrayList.add(reviewItem);
    }

    public ArrayList<ReviewItem> getReviewItemArrayList() {
        return reviewItemArrayList;
    }

    public void setReviewItemArrayList(ArrayList<ReviewItem> reviewItemArrayList) {
        ReviewUtil.reviewItemArrayList = reviewItemArrayList;
    }
}
