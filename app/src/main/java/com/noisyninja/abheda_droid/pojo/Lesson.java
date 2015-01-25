package com.noisyninja.abheda_droid.pojo;

import com.noisyninja.abheda_droid.util.Constants;

import java.util.ArrayList;

/**
 * Created by ir2pi on 11/30/2014.
 */
public class Lesson extends BaseLesson{
    String name;
    String description;
    String image;
    ArrayList<Chapter> chapters;
    boolean isFlashCard;

    public Lesson()
    {
        module_type = Constants.MODULE_TYPE.LESSON;
    }

    public boolean isFlashCard() {
        return isFlashCard;
    }

    public void setFlashCard(boolean isFlashCard) {
        this.isFlashCard = isFlashCard;
    }

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(ArrayList<Chapter> chapters) {
        this.chapters = chapters;
    }
}
