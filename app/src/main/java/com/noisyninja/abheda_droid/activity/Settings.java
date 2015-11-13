package com.noisyninja.abheda_droid.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;

import com.noisyninja.abheda_droid.R;
import com.noisyninja.abheda_droid.util.Constants;
import com.noisyninja.abheda_droid.util.Utils;

/**
 * Settings screen for app settings
 * Created by ir2pi on 12/3/2014.
 */
public class Settings extends BaseActivity {

    SeekBar seekBarSp;
    SeekBar seekBarPi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        seekBarSp = (SeekBar) findViewById(R.id.seekBar1);
        seekBarPi = (SeekBar) findViewById(R.id.seekBar2);

        seekBarPi.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Constants.PITCH = (float) progress / 100.0f;
                Log.d(Settings.class.getSimpleName(), "Pitch:" + Constants.PITCH);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Utils.makeToast(getBaseContext(), "Pitch:" + Constants.PITCH);
            }
        });

        seekBarSp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Constants.SPEED = (float) progress / 100.0f;
                Log.d(Settings.class.getSimpleName(), "Speed:" + Constants.SPEED);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Utils.makeToast(getBaseContext(), "Speed:" + Constants.SPEED);

            }
        });
    }
}
