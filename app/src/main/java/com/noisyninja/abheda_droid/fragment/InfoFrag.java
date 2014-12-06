package com.noisyninja.abheda_droid.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.noisyninja.abheda_droid.R;
import com.noisyninja.abheda_droid.util.Constants;
import com.triggertrap.seekarc.SeekArc;

/**
 * Created by ir2pi on 11/30/2014.
 */
public class InfoFrag extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View windows = inflater.inflate(R.layout.info_frag, container, false);
        SeekArc seekArc = ((SeekArc)windows.findViewById(R.id.seekArc));
        seekArc.setProgress(Constants.PROGRESS);
        seekArc.setClickable(false);
        return windows;
    }
}