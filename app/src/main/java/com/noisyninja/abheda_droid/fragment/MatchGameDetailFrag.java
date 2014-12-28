package com.noisyninja.abheda_droid.fragment;

import android.content.ClipData;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.noisyninja.abheda_droid.R;
import com.noisyninja.abheda_droid.control.FlipAnimation;
import com.noisyninja.abheda_droid.util.Constants;
import com.noisyninja.abheda_droid.util.Utils;

import java.util.HashMap;

/**
 * Created by ir2pi on 11/30/2014.
 */
public class MatchGameDetailFrag extends Fragment implements View.OnTouchListener, View.OnDragListener  {

    View window;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;

    HashMap<String, String > map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        window = inflater.inflate(R.layout.match_game_detail_frag, container, false);
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

        button1.setOnTouchListener(this);
        button2.setOnTouchListener(this);
        button3.setOnTouchListener(this);
        button4.setOnTouchListener(this);

        imageView1 = ((ImageView) window.findViewById(R.id.imageView1));
        imageView2 = ((ImageView) window.findViewById(R.id.imageView2));
        imageView3 = ((ImageView) window.findViewById(R.id.imageView3));
        imageView4 = ((ImageView) window.findViewById(R.id.imageView4));

        imageView1.setOnDragListener(this);
        imageView2.setOnDragListener(this);
        imageView3.setOnDragListener(this);
        imageView4.setOnDragListener(this);

        return window;
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
                            doAnim(rootLayout, cardFace, cardBack);
                            break;
                        }
                        case R.id.imageView2: {
                            View rootLayout = (View) window.findViewById(R.id.frameLayout2);
                            View cardFace = (View) window.findViewById(R.id.imageView2);
                            View cardBack = (View) window.findViewById(R.id.circleButton21);
                            doAnim(rootLayout, cardFace, cardBack);
                            break;
                        }
                        case R.id.imageView3: {
                            View rootLayout = (View) window.findViewById(R.id.frameLayout3);
                            View cardFace = (View) window.findViewById(R.id.imageView3);
                            View cardBack = (View) window.findViewById(R.id.circleButton31);
                            doAnim(rootLayout, cardFace, cardBack);
                            break;
                        }
                        case R.id.imageView4: {
                            View rootLayout = (View) window.findViewById(R.id.frameLayout4);
                            View cardFace = (View) window.findViewById(R.id.imageView4);
                            View cardBack = (View) window.findViewById(R.id.circleButton41);
                            doAnim(rootLayout, cardFace, cardBack);
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
    public void doAnim(View rootLayout, View cardFace, View cardBack)
    {
        FlipAnimation flipAnimation = new FlipAnimation(cardFace, cardBack);

        if (cardFace.getVisibility() == View.INVISIBLE)
        {
            flipAnimation.reverse();
        }
        rootLayout.startAnimation(flipAnimation);
    }
/*
    @Override
    public void onClick(View v) {
        // Handle view click here
        switch(v.getId())
        {
            case R.id.button1: {
                handleButton(button1);
                break;
            }
            case R.id.button2: {
                handleButton(button2);
                break;
            }
            case R.id.button3: {
                handleButton(button3);
                break;
            }
            case R.id.button4: {
                handleButton(button4);
                break;
            }
            case R.id.imageView1: {
                handleImage(imageView1);
                break;
            }
            case R.id.imageView2: {
                handleImage(imageView2);
                break;
            }
            case R.id.imageView3: {
                handleImage(imageView3);
                break;
            }
            case R.id.imageView4: {
                handleImage(imageView4);
                break;
            }
        }
    }

    public void handleButton(Button button)
    {
        if(selectedImage != selectedText)
        {
            Toast.makeText(getActivity(), R.string.choose_image, Toast.LENGTH_SHORT).show();
            return;
        }
        switch (button.getId())
        {
            case R.id.button1:{

                if(!arrText.get(0)){
                    arrText.set(0,true);
                    selectButton(button);
                }
                else
                {
                    arrText.set(0,false);
                    deselectButton(button);
                }
                break;
            }
            case R.id.button2:{

                if(!arrText.get(1)){
                    arrText.set(1,true);
                    selectButton(button);
                }
                else
                {
                    arrText.set(1,false);
                    deselectButton(button);
                }
                break;
            }
            case R.id.button3:{

                if(!arrText.get(2)){
                    arrText.set(2,true);
                    selectButton(button);
                }
                else
                {
                    arrText.set(2,false);
                    deselectButton(button);
                }
                break;
            }
            case R.id.button4:{

                if(!arrText.get(3)){
                    arrText.set(3,true);
                    selectButton(button);
                }
                else
                {
                    arrText.set(3,false);
                    deselectButton(button);
                }
                break;
            }
        }

        *//*else
        {
            selectedId--;
            button.setBackgroundResource(R.drawable.button_white);
        }*//*
    }

    public void selectButton(Button button)
    {
        selectedText++;
        switch (selectedText)
        {
            case 1:button.setBackgroundResource(R.drawable.button_green_enabled);break;
            case 2:button.setBackgroundResource(R.drawable.button_blue_enabled);break;
            case 3:button.setBackgroundResource(R.drawable.button_red_enabled);break;
            case 4:button.setBackgroundResource(R.drawable.button_cyan_enabled);break;
        }
    }

    public void deselectButton(Button button)
    {
        button.setBackgroundResource(R.drawable.button_white_enabled);
        selectedText--;
    }

    public void handleImage(ImageView imageView)
    {

        if(selectedImage+1 != selectedText)
        {
            Toast.makeText(getActivity(), R.string.choose_text, Toast.LENGTH_SHORT).show();
            return;
        }
        switch (imageView.getId())
        {
            case R.id.imageView1:{

                if(!arrImage.get(0)){
                    arrImage.set(0,true);
                    selectImage(imageView);
                }
                else
                {
                    arrImage.set(0,false);
                    deselectImage(imageView);
                }
                break;
            }
            case R.id.imageView2:{

                if(!arrImage.get(1)){
                    arrImage.set(1,true);
                    selectImage(imageView);
                }
                else
                {
                    arrImage.set(1,false);
                    deselectImage(imageView);
                }
                break;
            }
            case R.id.imageView3:{

                if(!arrImage.get(2)){
                    arrImage.set(2,true);
                    selectImage(imageView);
                }
                else
                {
                    arrImage.set(2,false);
                    deselectImage(imageView);
                }
                break;
            }
            case R.id.imageView4:{

                if(!arrImage.get(3)){
                    arrImage.set(3,true);
                    selectImage(imageView);
                }
                else
                {
                    arrImage.set(3,false);
                    deselectImage(imageView);
                }
                break;
            }
        }

        if(selectedImage == 4)
        {
            Utils.showResult(getActivity(), true);
        }
    }

    public void selectImage(ImageView imageView)
    {
        selectedImage++;
        switch (selectedImage)
        {
            case 1:imageView.setBackgroundResource(R.drawable.button_green_enabled);break;
            case 2:imageView.setBackgroundResource(R.drawable.button_blue_enabled);break;
            case 3:imageView.setBackgroundResource(R.drawable.button_red_enabled);break;
            case 4:imageView.setBackgroundResource(R.drawable.button_cyan_enabled);break;
        }
    }

    public void deselectImage(ImageView imageView)
    {
        imageView.setBackgroundResource(R.drawable.button_white_enabled);
        selectedImage--;
    }*/
}