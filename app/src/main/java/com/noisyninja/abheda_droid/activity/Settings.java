package com.noisyninja.abheda_droid.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;

import com.noisyninja.abheda_droid.R;
import com.noisyninja.abheda_droid.util.Constants;
import com.noisyninja.abheda_droid.util.Constants.FONT;
import com.noisyninja.abheda_droid.util.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Settings screen for app settings
 * Created by ir2pi on 12/3/2014.
 */
public class Settings extends BaseActivity implements AdapterView.OnItemSelectedListener {

    SeekBar seekBarSpeed;
    SeekBar seekBarPitch;
    Context context;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        context = this;
        seekBarSpeed = (SeekBar) findViewById(R.id.seekBar1);
        seekBarPitch = (SeekBar) findViewById(R.id.seekBar2);
        spinner = (Spinner) findViewById(R.id.font);

        setFontSpinner();

        seekBarPitch.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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

        seekBarSpeed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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

    private void setFontSpinner() {
        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add(FONT.FONT_SIYAMRUPALI.name());
        categories.add(FONT.FONT_KALPURUSH.name());
        categories.add(FONT.FONT_BENSENHANDWRITING.name());

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        Constants.font = FONT.valueOf(item);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
