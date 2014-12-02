package com.noisyninja.abheda_droid.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.noisyninja.abheda_droid.R;

/**
 * Created by ir2pi on 11/30/2014.
 */
public class InfoFrag extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View windows = inflater.inflate(R.layout.info_frag, container, false);
        //((TextView)windows.findViewById(R.id.textView)).setText("Windows");
        return windows;
    }

}