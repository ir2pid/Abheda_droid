package com.noisyninja.abheda_droid.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.noisyninja.abheda_droid.R;
import com.noisyninja.abheda_droid.fragment.CourseTree;

/**
 * Created by ir2pi on 2/22/2015.
 */
public class CourseActivity extends FragmentActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        context = this;

        CourseTree fragment = new CourseTree();

        this.getSupportFragmentManager().beginTransaction().add(R.id.activity_course, fragment).commit();

    }
}
