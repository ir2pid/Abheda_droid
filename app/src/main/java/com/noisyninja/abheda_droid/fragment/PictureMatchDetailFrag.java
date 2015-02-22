package com.noisyninja.abheda_droid.fragment;

import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.noisyninja.abheda_droid.R;
import com.noisyninja.abheda_droid.pojo.PictureMatchQuestion;
import com.noisyninja.abheda_droid.pojo.PictureMatchQuiz;
import com.noisyninja.abheda_droid.util.Constants;
import com.noisyninja.abheda_droid.util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ir2pi on 11/30/2014.
 */
public class PictureMatchDetailFrag extends Fragment implements View.OnTouchListener, View.OnDragListener  {

    View window;
    Context context;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button buttonNext;
    TextView textViewQuestionNo;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    int progress;

    ArrayList<Button> buttonArrayList;
    ArrayList<ImageView> imageViewArrayList;
    List<PictureMatchQuestion> pictureMatchQuestions;
    HashMap<String, String> map;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        progress = 0;
        if (getArguments().containsKey(Constants.FRAGMENT_DATA)) {

            String data = getArguments().getString(Constants.FRAGMENT_DATA);

            PictureMatchQuiz pictureMatchQuiz = (PictureMatchQuiz)Utils.getFromJson(data, PictureMatchQuiz.class);
            pictureMatchQuestions = Arrays.asList((PictureMatchQuestion[]) Utils.getObject(getActivity(),
                    pictureMatchQuiz.getPictureMatchQuestions(), PictureMatchQuestion[].class));

            Utils.handleInfo(getActivity(), pictureMatchQuiz.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        window = inflater.inflate(R.layout.frag_picture_match_detail, container, false);
        map = new HashMap<String, String>();
        for(int i=0;i<4;i++)
        {
            map.put(String.valueOf(R.id.button1), String.valueOf(R.id.imageView1));
            map.put(String.valueOf(R.id.button2), String.valueOf(R.id.imageView2));
            map.put(String.valueOf(R.id.button3), String.valueOf(R.id.imageView3));
            map.put(String.valueOf(R.id.button4), String.valueOf(R.id.imageView4));
        }

        button1 = ((Button) window.findViewById(R.id.button1));
        button2 = ((Button) window.findViewById(R.id.button2));
        button3 = ((Button) window.findViewById(R.id.button3));
        button4 = ((Button) window.findViewById(R.id.button4));

        buttonArrayList = new ArrayList<Button>();
        buttonArrayList.add(button1);
        buttonArrayList.add(button2);
        buttonArrayList.add(button3);
        buttonArrayList.add(button4);

        button1.setOnTouchListener(this);
        button2.setOnTouchListener(this);
        button3.setOnTouchListener(this);
        button4.setOnTouchListener(this);

        imageView1 = ((ImageView) window.findViewById(R.id.imageView1));
        imageView2 = ((ImageView) window.findViewById(R.id.imageView2));
        imageView3 = ((ImageView) window.findViewById(R.id.imageView3));
        imageView4 = ((ImageView) window.findViewById(R.id.imageView4));

        imageViewArrayList = new ArrayList<ImageView>();
        imageViewArrayList.add(imageView1);
        imageViewArrayList.add(imageView2);
        imageViewArrayList.add(imageView3);
        imageViewArrayList.add(imageView4);

        imageView1.setOnDragListener(this);
        imageView2.setOnDragListener(this);
        imageView3.setOnDragListener(this);
        imageView4.setOnDragListener(this);

        textViewQuestionNo  = ((TextView) window.findViewById(R.id.textView));

        buttonNext  = ((Button) window.findViewById(R.id.button5));
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(progress < pictureMatchQuestions.size()-1)
                {
                    progress++;
                }
                else
                {
                    Utils.backPress(getActivity());
                }
                loadQuestions();
            }
        });
        loadQuestions();

        return window;
    }

    void loadQuestions()
    {
        textViewQuestionNo.setText("Q: "+progress+"/"+pictureMatchQuestions.size());
        int i = 0;
        for(Map.Entry<String, String> entry : pictureMatchQuestions.get(progress).getWords().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            buttonArrayList.get(i).setText(value);
            Utils.lazyload(getActivity(), imageViewArrayList.get(i), key);
            i++;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent arg1) {
        // TODO Auto-generated method stub
        ClipData data = ClipData.newPlainText(String.valueOf(v.getId()), map.get(String.valueOf(v.getId())));
        View.DragShadowBuilder shadow = new View.DragShadowBuilder(button1);
        v.startDrag(data, shadow, null, 0);
        return false;
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        // TODO Auto-generated method stub
        ClipData data = event.getClipData();

        final int action = event.getAction();
        switch(action) {
            case DragEvent.ACTION_DRAG_STARTED:
                break;
            case DragEvent.ACTION_DRAG_EXITED:
                break;
            case DragEvent.ACTION_DRAG_ENTERED:
                break;
            case DragEvent.ACTION_DROP:{
                if(v.getId() == Integer.valueOf(data.getItemAt(0).getText().toString())) {

                    Toast.makeText(getActivity(), "success", Toast.LENGTH_SHORT).show();
                    Utils.playSound(getActivity(), Constants.Sound.RIGHT);
                    switch (v.getId()) {
                        case R.id.imageView1: {
                            View rootLayout = (View) window.findViewById(R.id.frameLayout1);
                            View cardFace = (View) window.findViewById(R.id.imageView1);
                            View cardBack = (View) window.findViewById(R.id.circleButton11);
                            Utils.animateFlip(rootLayout, cardFace, cardBack);
                            break;
                        }
                        case R.id.imageView2: {
                            View rootLayout = (View) window.findViewById(R.id.frameLayout2);
                            View cardFace = (View) window.findViewById(R.id.imageView2);
                            View cardBack = (View) window.findViewById(R.id.circleButton21);
                            Utils.animateFlip(rootLayout, cardFace, cardBack);
                            break;
                        }
                        case R.id.imageView3: {
                            View rootLayout = (View) window.findViewById(R.id.frameLayout3);
                            View cardFace = (View) window.findViewById(R.id.imageView3);
                            View cardBack = (View) window.findViewById(R.id.circleButton31);
                            Utils.animateFlip(rootLayout, cardFace, cardBack);
                            break;
                        }
                        case R.id.imageView4: {
                            View rootLayout = (View) window.findViewById(R.id.frameLayout4);
                            View cardFace = (View) window.findViewById(R.id.imageView4);
                            View cardBack = (View) window.findViewById(R.id.circleButton41);
                            Utils.animateFlip(rootLayout, cardFace, cardBack);
                            break;
                        }
                    }
                }
                else {
                    Utils.showResult(getActivity(), false);
                }


                return(true);
            }
            case DragEvent.ACTION_DRAG_ENDED:{
                break;
            }
            default:
                break;
        }
        return true;
    }


}