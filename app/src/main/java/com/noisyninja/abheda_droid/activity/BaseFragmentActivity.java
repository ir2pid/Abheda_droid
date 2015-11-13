package com.noisyninja.abheda_droid.activity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.noisyninja.abheda_droid.util.Constants;
import com.noisyninja.abheda_droid.util.Utils;

import de.greenrobot.event.EventBus;
import events.OnSpeechEvent;

/**
 * Base fragment for courses
 * Created by ir2pid on 14/10/15.
 */
public class BaseFragmentActivity extends FragmentActivity implements TextToSpeech.OnInitListener {

    //TTS object
    private TextToSpeech engine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        engine = new TextToSpeech(this, this);
    }

    @Override
    protected void onDestroy() {
        engine.shutdown();
        //EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public void onEvent(OnSpeechEvent event) {

        Log.d(Utils.class.getSimpleName(), "Speak: " + event.getText());
        engine.setPitch(Constants.PITCH);
        engine.setSpeechRate(Constants.SPEED);
        engine.speak(Utils.makeSpeechReady(event.getText()), TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    public void onInit(int status) {

    }
}
