package com.noisyninja.abheda_droid.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.noisyninja.abheda_droid.R;
import com.noisyninja.abheda_droid.fragment.LessonDetailFrag;
import com.noisyninja.abheda_droid.fragment.MCQDetailFrag;
import com.noisyninja.abheda_droid.fragment.MatchGameDetailFrag;
import com.noisyninja.abheda_droid.fragment.OrderGameDetailFrag;

/**
 * Created by ir2pi on 12/7/2014.
 */
public class QuizDetailActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_detail);

        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(LessonDetailFrag.ARG_ITEM_ID, getIntent()
                    .getStringExtra(LessonDetailFrag.ARG_ITEM_ID));

            if(Math.random() > 0.3) {
                MCQDetailFrag fragment = new MCQDetailFrag();
                fragment.setArguments(arguments);
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.quiz_detail_container, fragment).commit();
            }
            else  if(Math.random() > 0.3 && Math.random() < 0.6)
            {
                OrderGameDetailFrag fragment = new OrderGameDetailFrag();
                fragment.setArguments(arguments);
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.quiz_detail_container, fragment).commit();
            }
            else
            {
                MatchGameDetailFrag fragment = new MatchGameDetailFrag();
                fragment.setArguments(arguments);
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.quiz_detail_container, fragment).commit();
            }
        }
    }
}
