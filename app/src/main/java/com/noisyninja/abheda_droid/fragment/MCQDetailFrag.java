package com.noisyninja.abheda_droid.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.noisyninja.abheda_droid.R;
import com.noisyninja.abheda_droid.util.Utils;

/**
 * Created by ir2pi on 11/30/2014.
 */
public class MCQDetailFrag extends Fragment {

    View window;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        window = inflater.inflate(R.layout.mcq_detail_frag, container, false);

        Button button = ((Button) window.findViewById(R.id.button));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RadioGroup radioGroup = ((RadioGroup) window.findViewById(R.id.radioGroup));
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) window.findViewById(selectedId);
                //Utils.makeToast(getActivity(), String.valueOf(idx));

                if(radioButton != null && radioButton.getTag().toString().compareTo("1") == 0)
                {
                    Utils.showResult(getActivity(), true);
                }
                else if(radioButton != null && selectedId != -1)
                {
                    Utils.showResult(getActivity(), false);
                }
            }
        });
        return window;
    }
}