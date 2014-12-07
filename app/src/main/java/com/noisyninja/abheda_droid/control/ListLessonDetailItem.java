package com.noisyninja.abheda_droid.control;

import android.graphics.drawable.Drawable;

/**
 * Created by ir2pi on 11/30/2014.
 */
public class ListLessonDetailItem {
    public final Drawable icon;       // the drawable for the ListView item ImageView
    public final String title;        // the text for the ListView item title
    public final String description;  // the text for the ListView item description

    public ListLessonDetailItem(Drawable icon, String title, String description) {
        this.icon = icon;
        this.title = title;
        this.description = description;
    }
}