package com.noisyninja.abheda_droid.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.noisyninja.abheda_droid.R;
import com.noisyninja.abheda_droid.pojo.OrderGameQuiz;
import com.noisyninja.abheda_droid.util.Constants;
import com.noisyninja.abheda_droid.util.Utils;

import java.util.ArrayList;
import java.util.Map.Entry;

/**
 * Created by ir2pi on 11/30/2014.
 */
public class OrderGameDetailFrag extends Fragment {

    View window;
    Context context;
    ArrayList<String> words;
    ArrayList<Button> buttons;
    Button buttonNext;
    TextView textViewQuestionNo;
    LinearLayout linearLayout1;
    LinearLayout linearLayout2;
    OrderGameQuiz orderGameQuiz;
    int progress;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        progress = 0;
        if (getArguments().containsKey(Constants.FRAGMENT_DATA)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            /*mItem = DummyContent.ITEM_MAP.get(getArguments().getString(
                    ARG_ITEM_ID));*/
            String data = getArguments().getString(Constants.FRAGMENT_DATA);

            orderGameQuiz = new OrderGameQuiz();
            orderGameQuiz = (OrderGameQuiz)Utils.getFromJson(data, OrderGameQuiz.class);

            Utils.handleInfo(getActivity(), orderGameQuiz.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        window = inflater.inflate(R.layout.frag_order_game_detail, container, false);
        buttonNext = ((Button) window.findViewById(R.id.button));
        textViewQuestionNo  = ((TextView) window.findViewById(R.id.textView));
        linearLayout1 = ((LinearLayout) window.findViewById(R.id.linearlayout1));
        linearLayout2 = ((LinearLayout) window.findViewById(R.id.linearlayout2));
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(linearLayout2.getChildCount() == words.size())
                {
                    Utils.playSound(getActivity(), Constants.Sound.RIGHT);
                    Utils.showResult(context, true);
                    if(progress < orderGameQuiz.getOrderGameQuestions().size()-1)
                    {
                        progress++;
                    }
                    else
                    {
                        Utils.backPress(getActivity());
                    }
                    loadQuestions(getWords(progress), linearLayout1);
                }
            }
        });

        loadQuestions(getWords(progress), linearLayout1);

        return window;
    }

    public void loadQuestions(final ArrayList<String> words, LinearLayout linearLayout)
    {
        linearLayout2.removeAllViews();
        textViewQuestionNo.setText("Q: "+progress+"/"+orderGameQuiz.getOrderGameQuestions().size());
        for(String word:words)
        {
            Button button = new Button(getActivity());
            button.setText(word);
            button.setBackgroundResource(R.drawable.button_red);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Utils.playSound(getActivity(), Constants.Sound.CLICK);
                    LinearLayout linearLayout = (LinearLayout) view.getParent();
                    linearLayout.removeView(view);
                    if(linearLayout.getId() == linearLayout1.getId())
                    {
                        linearLayout2.addView(view);
                    }
                    else
                    {
                        linearLayout1.addView(view);
                    }

                }
            });
            linearLayout.addView(button);
        }
    }

    public ArrayList<String> getWords(int no)
    {
        words = new ArrayList<String>();
        for(Entry<Integer, String> entry : orderGameQuiz.getOrderGameQuestions().get(no).getWords().entrySet()) {
            int key = entry.getKey();
            String value = entry.getValue();
            words.add(value);
            // do what you have to do here
            // In your case, an other loop.
        }

        return words;
    }


}