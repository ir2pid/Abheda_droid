package com.noisyninja.abheda_droid.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.noisyninja.abheda_droid.R;
import com.noisyninja.abheda_droid.activity.MainActivity;
import com.noisyninja.abheda_droid.util.Constants;
import com.noisyninja.abheda_droid.control.SeekArc;

import java.util.TimerTask;

/**
 * Created by ir2pi on 11/30/2014.
 */
public class InfoFrag extends Fragment implements ISyncFrag{


    int progress;
    SeekArc seekArc;
    TextView progressText;
    Activity activity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View windows = inflater.inflate(R.layout.info_frag, container, false);
        seekArc = ((SeekArc)windows.findViewById(R.id.seekArc));
        progressText = ((TextView)windows.findViewById(R.id.progressText));
        seekArc.setTouchable(false);

        return windows;
    }

    @Override
    public void onAttach(Activity activity)
    {
        progress = 0;
        super.onAttach(activity);
        ProgressTask progressTask = new ProgressTask();
        progressTask.execute(new Activity[]{activity});

    }

    public void sync(int value){
        if(seekArc!=null)
        seekArc.setProgress(value);
    }


    private class ProgressTask extends AsyncTask<Activity, Integer, String> {
        Activity activity;
        @Override
        protected String doInBackground(Activity... params) {
            activity = params[0];
            while(progress < Constants.PROGRESS) {
                try {
                    Thread.sleep(Constants.SLEEP_TIME_20);
                    progress++;
                    onProgressUpdate(new Integer[]{progress});
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onProgressUpdate(final Integer... values) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    seekArc.setProgress(values[0]);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(Constants.PROGRESS_TEXT);
                    stringBuilder.append(values[0]);
                    stringBuilder.append(Constants.PROGRESS_PERCENT);
                    progressText.setText(stringBuilder.toString());
                }
            });
        }
    }
}