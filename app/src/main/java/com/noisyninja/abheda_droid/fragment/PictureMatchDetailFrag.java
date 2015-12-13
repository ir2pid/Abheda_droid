package com.noisyninja.abheda_droid.fragment;

import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
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

import com.noisyninja.abheda_droid.R;
import com.noisyninja.abheda_droid.pojo.PictureMatchQuestion;
import com.noisyninja.abheda_droid.pojo.PictureMatchQuiz;
import com.noisyninja.abheda_droid.pojo.misc.IntegerIntegerPair;
import com.noisyninja.abheda_droid.util.Constants;
import com.noisyninja.abheda_droid.util.IDialogCallback;
import com.noisyninja.abheda_droid.util.ReviewUtil;
import com.noisyninja.abheda_droid.util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ir2pi on 11/30/2014.
 */
public class PictureMatchDetailFrag extends Fragment implements View.OnTouchListener, View.OnDragListener, IDialogCallback {

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
    TextView imageViewText1;
    TextView imageViewText2;
    TextView imageViewText3;
    TextView imageViewText4;
    int progress;
    int correct;
    int wrong;
    int completedMatches;
    Fragment fragment;
    ArrayList<Button> buttonArrayList;
    ArrayList<ImageView> imageViewArrayList;
    List<PictureMatchQuestion> pictureMatchQuestions;
    HashMap<String, String> map;
    HashMap<IntegerIntegerPair, Boolean> answers;
    STATES states;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        fragment = this;
        progress = 0;
        correct = 0;
        wrong = 0;
        if (getArguments().containsKey(Constants.FRAGMENT_DATA)) {

            String data = getArguments().getString(Constants.FRAGMENT_DATA);

            PictureMatchQuiz pictureMatchQuiz = (PictureMatchQuiz) Utils.getFromJson(data, PictureMatchQuiz.class);
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
        for (int i = 0; i < 4; i++) {
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

        imageViewText1 = ((TextView) window.findViewById(R.id.imageViewText1));
        imageViewText2 = ((TextView) window.findViewById(R.id.imageViewText2));
        imageViewText3 = ((TextView) window.findViewById(R.id.imageViewText3));
        imageViewText4 = ((TextView) window.findViewById(R.id.imageViewText4));

        imageViewArrayList = new ArrayList<ImageView>();
        imageViewArrayList.add(imageView1);
        imageViewArrayList.add(imageView2);
        imageViewArrayList.add(imageView3);
        imageViewArrayList.add(imageView4);

        imageView1.setOnDragListener(this);
        imageView2.setOnDragListener(this);
        imageView3.setOnDragListener(this);
        imageView4.setOnDragListener(this);

        textViewQuestionNo = ((TextView) window.findViewById(R.id.textView));

        buttonNext = ((Button) window.findViewById(R.id.button5));
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (states == STATES.NORMAL && progress < pictureMatchQuestions.size() && completedMatches == 4) {
                    progress++;
                    states = STATES.RESULT;
                    Utils.setText(buttonNext, Utils.getStringResource(window.getContext(), R.string.next));
                    showResults();
                } else if (states == STATES.RESULT) {
                    if (progress == pictureMatchQuestions.size()) {
                        states = STATES.LAST;
                        Utils.showDialog(fragment, Constants.QUIZ_COMPLETED_TEXT, correct + " correct of " + (correct + wrong), true);
                    } else {
                        loadQuestions();

                    }
                } else if (completedMatches < 4) {
                    Utils.showDialog(fragment, Constants.ERROR, Constants.ERROR_INCOMPLETE, true);
                }
            }
        });
        loadQuestions();

        return window;
    }

    private void showResults() {

        for (Map.Entry<IntegerIntegerPair, Boolean> entry : answers.entrySet()) {
            IntegerIntegerPair integerIntegerPair = entry.getKey();
            if (entry.getValue()) {
                onCorrect(integerIntegerPair);
            } else {
                onWrong(integerIntegerPair);
            }
        }
    }

    void loadQuestions() {
        completedMatches = 0;
        answers = new HashMap<>();

        imageViewText1.setText("");
        imageViewText2.setText("");
        imageViewText3.setText("");
        imageViewText4.setText("");

        View correctIndicator11 = window.findViewById(R.id.circleButton11);
        View correctIndicator21 = window.findViewById(R.id.circleButton21);
        View correctIndicator31 = window.findViewById(R.id.circleButton31);
        View correctIndicator41 = window.findViewById(R.id.circleButton41);
        View correctIndicator12 = window.findViewById(R.id.circleButton12);
        View correctIndicator22 = window.findViewById(R.id.circleButton22);
        View correctIndicator32 = window.findViewById(R.id.circleButton32);
        View correctIndicator42 = window.findViewById(R.id.circleButton42);

        correctIndicator11.setVisibility(View.INVISIBLE);
        correctIndicator21.setVisibility(View.INVISIBLE);
        correctIndicator31.setVisibility(View.INVISIBLE);
        correctIndicator41.setVisibility(View.INVISIBLE);
        correctIndicator12.setVisibility(View.INVISIBLE);
        correctIndicator22.setVisibility(View.INVISIBLE);
        correctIndicator32.setVisibility(View.INVISIBLE);
        correctIndicator42.setVisibility(View.INVISIBLE);

        buttonNext.setEnabled(false);

        Utils.setText(buttonNext, Utils.getStringResource(window.getContext(), R.string.submit));

        Utils.setText(textViewQuestionNo, "Q: " + (progress + 1) + "/" + pictureMatchQuestions.size());
        int i = 0;
        for (Map.Entry<String, String> entry : pictureMatchQuestions.get(progress).getWords().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value == null || value.compareTo(Constants.BLANK) == 0) {
                completedMatches++;
                buttonArrayList.get(i).setVisibility(View.GONE);
            } else {

                Utils.setText(buttonArrayList.get(i), value);
                buttonArrayList.get(i).setVisibility(View.VISIBLE);
                buttonArrayList.get(i).setEnabled(true);
            }
            Utils.lazyload(getActivity(), imageViewArrayList.get(i), key);
            imageViewArrayList.get(i).setBackgroundResource(R.drawable.button_white_enabled);
            i++;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent arg1) {
        // TODO Auto-generated method stub
        ClipData data = ClipData.newPlainText(String.valueOf(v.getId()), String.valueOf(v.getId()));//map.get(String.valueOf(v.getId())));
        View.DragShadowBuilder shadow = new View.DragShadowBuilder(v);
        v.startDrag(data, shadow, null, 0);
        return false;
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        // TODO Auto-generated method stub
        ClipData data = event.getClipData();

        final int action = event.getAction();
        switch (action) {
            case DragEvent.ACTION_DRAG_STARTED:
                break;
            case DragEvent.ACTION_DRAG_EXITED:
                break;
            case DragEvent.ACTION_DRAG_ENTERED:
                break;
            case DragEvent.ACTION_DROP: {
                v.setBackgroundResource(R.drawable.button_green_enabled);
                String buttonStringId = data.getItemAt(0).getText().toString();
                int imageId = Integer.valueOf(map.get(buttonStringId));
                int buttonId = Integer.valueOf(buttonStringId);
                Button button = (Button) window.findViewById(buttonId);
                button.setEnabled(false);
                completedMatches++;
                if (v.getId() == Integer.valueOf(imageId)) {
                    answers.put(new IntegerIntegerPair(imageId, buttonId), true);
                } else {
                    answers.put(new IntegerIntegerPair(imageId, buttonId), false);
                }
                if (completedMatches == 4) {
                    states = STATES.NORMAL;
                    buttonNext.setEnabled(true);
                }

                return (true);
            }
            case DragEvent.ACTION_DRAG_ENDED: {
                break;
            }
            default:
                break;
        }
        return true;
    }

    private String answer(String imageKey) {
        String s = null;
        for (Map.Entry<String, String> entry : pictureMatchQuestions.get(progress).getWords().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value.compareTo(s) == 0) {

            }
        }
        return s;
    }

    private void onWrong(IntegerIntegerPair integerIntegerPair) {
        int buttonId = integerIntegerPair.getI2();
        View v = window.findViewById(integerIntegerPair.getI1());
        Button button = (Button) window.findViewById(buttonId);
        button.setEnabled(false);
        v.setBackgroundResource(R.drawable.button_green_enabled);
        wrong++;
        Utils.playSound(getActivity(), Constants.Sound.WRONG);

        String sImage = (String) v.getTag(); //images have tags set as url
        String sWrong = button.getText().toString();
        String sCorrect = null;
        if (progress < pictureMatchQuestions.size()) {
            sCorrect = pictureMatchQuestions.get(progress - 1).getWords().get(sImage);
            ReviewUtil.getInstance().addOptions(sImage, sWrong, sCorrect, true);
        } else Utils.logD("out of index" + (progress - 1));
        switch (v.getId()) {
            case R.id.imageView1: {
                completedMatches++;
                Utils.setText(imageViewText1, sCorrect);
                View rootLayout = window.findViewById(R.id.frameLayout1);
                View cardFace = window.findViewById(R.id.imageView1);
                View cardBack = window.findViewById(R.id.circleButton12);
                Utils.animateFlip(rootLayout, cardFace, cardBack);
                break;
            }
            case R.id.imageView2: {
                completedMatches++;
                Utils.setText(imageViewText2, sCorrect);
                View rootLayout = window.findViewById(R.id.frameLayout2);
                View cardFace = window.findViewById(R.id.imageView2);
                View cardBack = window.findViewById(R.id.circleButton22);
                Utils.animateFlip(rootLayout, cardFace, cardBack);
                break;
            }
            case R.id.imageView3: {
                completedMatches++;
                Utils.setText(imageViewText3, sCorrect);
                View rootLayout = window.findViewById(R.id.frameLayout3);
                View cardFace = window.findViewById(R.id.imageView3);
                View cardBack = window.findViewById(R.id.circleButton32);
                Utils.animateFlip(rootLayout, cardFace, cardBack);
                break;
            }
            case R.id.imageView4: {
                completedMatches++;
                Utils.setText(imageViewText4, sCorrect);
                View rootLayout = window.findViewById(R.id.frameLayout4);
                View cardFace = window.findViewById(R.id.imageView4);
                View cardBack = window.findViewById(R.id.circleButton42);
                Utils.animateFlip(rootLayout, cardFace, cardBack);
                break;
            }
        }

    }

    private void onCorrect(IntegerIntegerPair integerIntegerPair) {
        int buttonId = integerIntegerPair.getI2();
        View v = window.findViewById(integerIntegerPair.getI1());
        Button button = (Button) window.findViewById(buttonId);
        button.setEnabled(false);
        v.setBackgroundResource(R.drawable.button_green_enabled);
        correct++;
        Utils.playSound(getActivity(), Constants.Sound.RIGHT);

        String sImage = (String) v.getTag(); //images have tags set as url
        String sCorrect = button.getText().toString();
        ReviewUtil.getInstance().addOptions(sImage, null, sCorrect, true);

        switch (v.getId()) {
            case R.id.imageView1: {
                completedMatches++;
                Utils.setText(imageViewText1, sCorrect);
                View rootLayout = window.findViewById(R.id.frameLayout1);
                View cardFace = window.findViewById(R.id.imageView1);
                View cardBack = window.findViewById(R.id.circleButton11);
                Utils.animateFlip(rootLayout, cardFace, cardBack);
                break;
            }
            case R.id.imageView2: {
                completedMatches++;
                Utils.setText(imageViewText2, sCorrect);
                View rootLayout = window.findViewById(R.id.frameLayout2);
                View cardFace = window.findViewById(R.id.imageView2);
                View cardBack = window.findViewById(R.id.circleButton21);
                Utils.animateFlip(rootLayout, cardFace, cardBack);
                break;
            }
            case R.id.imageView3: {
                completedMatches++;
                Utils.setText(imageViewText3, sCorrect);
                View rootLayout = window.findViewById(R.id.frameLayout3);
                View cardFace = window.findViewById(R.id.imageView3);
                View cardBack = window.findViewById(R.id.circleButton31);
                Utils.animateFlip(rootLayout, cardFace, cardBack);
                break;
            }
            case R.id.imageView4: {
                completedMatches++;
                Utils.setText(imageViewText4, sCorrect);
                View rootLayout = window.findViewById(R.id.frameLayout4);
                View cardFace = window.findViewById(R.id.imageView4);
                View cardBack = window.findViewById(R.id.circleButton41);
                Utils.animateFlip(rootLayout, cardFace, cardBack);
                break;
            }

        }
    }

    @Override
    public void ok(DialogInterface dialog) {
        if (states.compareTo(STATES.LAST) == 0) {
            //Utils.backPress(getActivity());
            dialog.dismiss();
            Utils.showReview(getActivity());
        }
    }

    @Override
    public void cancel(DialogInterface dialog) {

    }

    enum STATES {
        NORMAL,
        RESULT,
        REVIEW,
        LAST
    }
}