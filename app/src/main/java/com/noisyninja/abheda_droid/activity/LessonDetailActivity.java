package com.noisyninja.abheda_droid.activity;

import android.os.Bundle;

import com.noisyninja.abheda_droid.R;
import com.noisyninja.abheda_droid.util.Constants;
import com.noisyninja.abheda_droid.util.Constants.MODULE_TYPE;
import com.noisyninja.abheda_droid.util.Utils;

/**
 * Lesson detail activity
 * Created by ir2pi on 12/6/2014.
 */
public class LessonDetailActivity extends BaseFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_detail);

        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            String data = getIntent().getStringExtra(Constants.FRAGMENT_DATA);
            MODULE_TYPE module_type = MODULE_TYPE.valueOf(getIntent().getStringExtra(Constants.FRAGMENT_TYPE));

            Utils.courseFacade(this, data, module_type);

        }
    }


}