package com.noisyninja.abheda_droid.pojo;

import com.google.gson.Gson;

/**
 * Created by ir2pi on 11/30/2014.
 */
public class Lesson extends BasePojo{
    String name;
    String description;
    String image;
    String text;

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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
