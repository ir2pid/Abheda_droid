package com.noisyninja.abheda_droid.activity;

import android.content.Context;
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
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        context = this;
        seekBarSp = (SeekBar) findViewById(R.id.seekBar1);
        seekBarPi = (SeekBar) findViewById(R.id.seekBar2);

        seekBarPi.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Constants.PITCH_SPEECH = (float) progress / 100.0f;
                Utils.setPreference(context, Constants.PITCH_SPEECH_KEY, String.valueOf(Constants.PITCH_SPEECH));
                Log.d(Settings.class.getSimpleName(), "Pitch:" + Constants.PITCH_SPEECH);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Utils.makeToast(getBaseContext(), "Pitch:" + Constants.PITCH_SPEECH);
            }
        });

        seekBarSp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Constants.SPEED_SPEECH = (float) progress / 100.0f;
                Utils.setPreference(context, Constants.SPEED_SPEECH_KEY, String.valueOf(Constants.SPEED_SPEECH));
                Log.d(Settings.class.getSimpleName(), "Speed:" + Constants.SPEED_SPEECH);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Utils.makeToast(getBaseContext(), "Speed:" + Constants.SPEED_SPEECH);

            }
        });
    }
}
