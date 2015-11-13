package com.noisyninja.abheda_droid.activity;

import android.app.Activity;

/**
 * Created by ir2pid on 14/10/15.
 */
public class BaseActivity extends Activity {

   /* EventBus eventBus;
    //TTS object
    private TextToSpeech textToSpeech;
    //status check code
    private int MY_DATA_CHECK_CODE = 0;

    //act on result of TTS data check
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == MY_DATA_CHECK_CODE) {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                //the user has the necessary data - create the TTS
                textToSpeech = new TextToSpeech(this, this);
            } else {
                //no data - install it now
                Intent installTTSIntent = new Intent();
                installTTSIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(installTTSIntent);
            }
        }
    }

    @Override
    protected void onDestroy() {
        textToSpeech.shutdown();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    //setup TTS
    @Override
    public void onInit(int initStatus) {

        //check for successful instantiation
        if (initStatus == TextToSpeech.SUCCESS) {
            if (textToSpeech.isLanguageAvailable(Locale.US) == TextToSpeech.LANG_AVAILABLE)
                textToSpeech.setLanguage(Locale.US);
        } else if (initStatus == TextToSpeech.ERROR) {
            Utils.makeToast(this, "Text To Speech failed.");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        eventBus = new EventBus();
        //eventBus.register(this);
        initTTS();
    }

    @Override
    protected void onPause() {
        super.onPause();
        eventBus.unregister(this);
    }

    private void initTTS() {

        //check for TTS data
        Intent checkTTSIntent = new Intent();
        checkTTSIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkTTSIntent, MY_DATA_CHECK_CODE);
    }

    public void onEvent(OnSpeechEvent event) {
        textToSpeech.speak(Utils.makeSpeechReady(event.getText()), TextToSpeech.QUEUE_FLUSH, null);
    }*/
}
