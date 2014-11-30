package com.noisyninja.abheda_droid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ir2pi on 11/30/2014.
 */
public class QuizFrag extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ios = inflater.inflate(R.layout.quiz_frag, container, false);
        //((TextView)ios.findViewById(R.id.textView)).setText("iOS");
        return ios;
    }}