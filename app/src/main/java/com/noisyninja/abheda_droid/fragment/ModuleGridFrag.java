package com.noisyninja.abheda_droid.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.noisyninja.abheda_droid.R;
import com.noisyninja.abheda_droid.activity.LessonsActivity;
import com.noisyninja.abheda_droid.util.Utils;

/**
 * Created by ir2pi on 12/5/2014.
 */
public class ModuleGridFrag extends Fragment {


    GridView gridView;

    static final String[] topics = new String[]{

            "Noun", "Verb", "Preposition", "Tense", "Adjective",
            "Gerund"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View windows = inflater.inflate(R.layout.module_grid_frag, container, false);
        gridView = (GridView) windows.findViewById(R.id.gridview1);

        // Create adapter to set value for grid view
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, topics);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                Toast.makeText(getActivity(),
                        ((TextView) v).getText(), Toast.LENGTH_SHORT).show();

                Utils.startActivity(getActivity(), LessonsActivity.class);

            }
        });

        return windows;
    }
}



