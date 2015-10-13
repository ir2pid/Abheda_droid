package com.noisyninja.abheda_droid.util;

import android.content.Context;
import android.speech.tts.TextToSpeech;

import java.util.Locale;

/**
 * Created by ir2pid on 13/10/15.
 */
public class TTSUtils {

    private static TextToSpeech mTts = null;
    private static boolean isLoaded = false;
    private static Context context;

    private static TTSUtils instance = null;
    private static TextToSpeech.OnInitListener onInitListener = new TextToSpeech.OnInitListener() {
        @Override
        public void onInit(int status) {
            if (status == TextToSpeech.SUCCESS) {
                int result = mTts.setLanguage(Locale.US);
                isLoaded = true;

                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Utils.makeToast(context, Constants.ERROR_LANGUAGE_NOT_FOUND);
                }
            } else {
                Utils.makeToast(context, Constants.ERROR_LANGUAGE_INIT_ERROR);
            }
        }
    };

    protected TTSUtils() {
        // Exists only to defeat instantiation.
    }

    public static TTSUtils getInstance(Context sContext) {//initiated in mainactivity onresume
        if (instance == null) {
            try {
                instance = new TTSUtils();
                context = sContext.getApplicationContext();
                mTts = new TextToSpeech(context, onInitListener);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public void shutDown() {//called in mainactivity onpause
        mTts.shutdown();
    }

    public void addQueue(String text) {
        if (isLoaded)
            mTts.speak(text, TextToSpeech.QUEUE_ADD, null);
        else
            Utils.makeToast(context, Constants.ERROR_LANGUAGE_INIT_ERROR);
    }

    public void initQueue(String text) {

        if (isLoaded)
            mTts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        else
            Utils.makeToast(context, Constants.ERROR_LANGUAGE_INIT_ERROR);
    }
}
