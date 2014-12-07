package com.noisyninja.abheda_droid.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.noisyninja.abheda_droid.R;
import com.noisyninja.abheda_droid.fragment.LessonDetailFrag;
import com.noisyninja.abheda_droid.fragment.LessonListFrag;

/**
 * Created by ir2pi on 12/3/2014.
 */
public class LessonsActivity extends FragmentActivity implements
        LessonListFrag.Callbacks {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lessons);

        if (findViewById(R.id.lesson_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            ((LessonListFrag) getSupportFragmentManager().findFragmentById(
                    R.id.lesson_list_frag)).setActivateOnItemClick(true);
        }

        // TODO: If exposing deep links into your app, handle intents here.
    }

    /**
     * Callback method from {@link LessonListFrag.Callbacks} indicating that
     * the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(String id) {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(LessonDetailFrag.ARG_ITEM_ID, id);
            LessonDetailFrag fragment = new LessonDetailFrag();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.lesson_detail_container, fragment).commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, LessonDetailActivity.class);
            detailIntent.putExtra(LessonDetailFrag.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }
}