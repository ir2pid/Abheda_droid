package com.noisyninja.abheda_droid.activity;

import android.support.v4.app.FragmentActivity;

import com.noisyninja.abheda_droid.util.TTSUtils;

/**
 * Created by ir2pid on 14/10/15.
 */
public class BaseFragmentActivity extends FragmentActivity {

    TTSUtils ttsUtils;

    @Override
    protected void onStart() {
        super.onStart();
        TTSUtils.getInstance(this);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        TTSUtils.getInstance(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        TTSUtils.getInstance(this).shutDown();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
