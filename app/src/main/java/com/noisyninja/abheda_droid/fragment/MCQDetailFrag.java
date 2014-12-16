package com.noisyninja.abheda_droid.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.noisyninja.abheda_droid.R;
import com.noisyninja.abheda_droid.util.Constants;
import com.noisyninja.abheda_droid.util.Utils;

import at.markushi.ui.CircleButton;

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
                    Utils.playSound(getActivity(), Constants.Sound.RIGHT);
                    getResult(true);
                }
                else if(radioButton != null && selectedId != -1)
                {
                    Utils.playSound(getActivity(), Constants.Sound.WRONG);
                    getResult(false);
                }
            }
        });
        return window;
    }

    public void getResult(boolean value)
    {
        // custom dialog
        final Dialog dialog = new Dialog(getActivity());//, R.style.TransparentDialog
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(R.layout.dialog_quiz_result);
        dialog.getWindow().getAttributes().windowAnimations = R.style.dialogAnimation_down_up;

        // set the custom dialog components - button
        CircleButton buttonModule1 = (CircleButton) dialog.findViewById(R.id.circleButton1);
        CircleButton buttonModule2 = (CircleButton) dialog.findViewById(R.id.circleButton2);

        if(value)
        {
            buttonModule1.setVisibility(View.VISIBLE);
            buttonModule2.setVisibility(View.INVISIBLE);
        }
        else
        {
            buttonModule1.setVisibility(View.INVISIBLE);
            buttonModule2.setVisibility(View.VISIBLE);
        }

        dialog.show();
    }
}