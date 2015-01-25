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
import com.noisyninja.abheda_droid.pojo.MCQQuiz;
import com.noisyninja.abheda_droid.util.Constants;
import com.noisyninja.abheda_droid.util.Utils;

/**
 * Created by ir2pi on 11/30/2014.
 */
public class MCQDetailFrag extends Fragment {

    View window;
    MCQQuiz mcqQuiz;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(Constants.FRAGMENT_DATA)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            /*mItem = DummyContent.ITEM_MAP.get(getArguments().getString(
                    ARG_ITEM_ID));*/
            String data = getArguments().getString(Constants.FRAGMENT_DATA);

            mcqQuiz = new MCQQuiz();
            mcqQuiz = (MCQQuiz)Utils.getFromJson(data, MCQQuiz.class);

            Utils.handleInfo(getActivity(), mcqQuiz.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        window = inflater.inflate(R.layout.mcq_detail_frag, container, false);

        RadioButton radioButton1 = ((RadioButton) window.findViewById(R.id.radioButton1));
        radioButton1.setText(mcqQuiz.getOption1());
        RadioButton radioButton2 = ((RadioButton) window.findViewById(R.id.radioButton2));
        radioButton2.setText(mcqQuiz.getOption2());
        RadioButton radioButton3 = ((RadioButton) window.findViewById(R.id.radioButton3));
        radioButton3.setText(mcqQuiz.getOption3());
        RadioButton radioButton4 = ((RadioButton) window.findViewById(R.id.radioButton4));
        radioButton4.setText(mcqQuiz.getOption4());

        Button button = ((Button) window.findViewById(R.id.button));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RadioGroup radioGroup = ((RadioGroup) window.findViewById(R.id.radioGroup));
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) window.findViewById(selectedId);
                //Utils.makeToast(getActivity(), String.valueOf(idx));

                if(radioButton != null && Integer.valueOf(radioButton.getTag().toString()) == mcqQuiz.getCorrect())
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