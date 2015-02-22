package com.noisyninja.abheda_droid.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.noisyninja.abheda_droid.R;
import com.noisyninja.abheda_droid.control.OnSwipeTouchListener;
import com.noisyninja.abheda_droid.pojo.Lesson;
import com.noisyninja.abheda_droid.pojo.Page;
import com.noisyninja.abheda_droid.util.Constants;
import com.noisyninja.abheda_droid.util.Utils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ir2pi on 1/26/2015.
 */
public class FlashcardDetailFrag extends Fragment{

    //ViewPager viewPager;
    //PagerAdapter adapter;
    //the ViewSwitcher
    private ViewFlipper viewFlipper;
    View windows;
    List<Page> pageList;
    private int position;
    private boolean isBackFace;
    public FlashcardDetailFrag() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = 0;
        isBackFace = false;
        if (getArguments().containsKey(Constants.FRAGMENT_DATA)) {

            String data = getArguments().getString(Constants.FRAGMENT_DATA);

            Lesson lesson = (Lesson) Utils.getFromJson(data, Lesson.class);

            pageList = Arrays.asList((Page[])  Utils.getObject(getActivity(),
                    lesson.getPages(), Page[].class));

            Utils.handleInfo(getActivity(), lesson.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        windows = inflater.inflate(R.layout.frag_screen_slide, container, false);

        // Locate the ViewPager in viewpager_main.xml
        viewFlipper = (ViewFlipper) windows.findViewById(R.id.viewflipper);


        for(int i=0;i<pageList.size();i++)
        {
            viewFlipper.addView(getCardView(true));
            position++;
        }
        Utils.makeToast(getActivity(), "added:"+position);
        position = 0;
        for(int i = position;i<pageList.size();i++)
        {
            viewFlipper.addView(getCardView(false));
            position++;
        }
        Utils.makeToast(getActivity(), "added:"+position);
        position = 0;
        // Pass results to ViewPagerAdapter Class
        windows.setOnTouchListener(new OnSwipeTouchListener(getActivity()) {
            @Override
            public void onSwipeLeft() {
                next();
            }
            @Override
             public void onSwipeRight() {
                previous();
            }
            @Override
             public void onClick() {
                flip();
            }
        });


        return windows;
    }

    public View getCardView(boolean isFront)
    {
        LayoutInflater layoutInflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.item_view_pager, null, false);

        ImageView imageView = (ImageView)view.findViewById(R.id.image1);
        TextView text = (TextView)view.findViewById(R.id.text1);
        TextView description = (TextView)view.findViewById(R.id.description1);
        TextView name = (TextView)view.findViewById(R.id.name1);
        if(isFront)
        {
            name.setText(pageList.get(position).getName());
            description.setText(pageList.get(position).getDescription());
            text.setText(pageList.get(position).getText1());
            Utils.lazyload(getActivity(), imageView, pageList.get(position).getImage1());
        }else {
            name.setText(pageList.get(position).getName());
            description.setText(pageList.get(position).getDescription());
            text.setText(pageList.get(position).getText2());
            Utils.lazyload(getActivity(), imageView, pageList.get(position).getImage2());
        }

        return view;
    }

    public void next()
    {
        if(position >= pageList.size()-1)
            return;
        isBackFace = false;
        // Next screen comes in from left.
        viewFlipper.setInAnimation(getActivity(), R.anim.push_left_out);
        // Current screen goes out from right.
        viewFlipper.setOutAnimation(getActivity(), R.anim.push_right_in);

        // Display next screen.
        position ++;
        viewFlipper.showNext();
    }

    public void previous()
    {
        if(position <= 0)
            return;
        isBackFace = false;
        // Next screen comes in from right.
        viewFlipper.setInAnimation(getActivity(), R.anim.push_left_in);
        // Current screen goes out from left.
        viewFlipper.setOutAnimation(getActivity(), R.anim.push_right_out);

        // Display previous screen.
        position --;
        viewFlipper.showPrevious();
    }

    public void flip(){

        Utils.makeToast(getActivity(), "Clicked: " + position + "opposite: "+(position+pageList.size()));
        View front;
        View back;
        if(!isBackFace) {
            isBackFace = !isBackFace;
            front = viewFlipper.getChildAt(position);
            back = viewFlipper.getChildAt(position + (pageList.size()));
        }else {
            return;
        }
        Utils.animateFlip(viewFlipper, front, back);

    }

    /*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View windows = inflater.inflate(R.layout.frag_screen_slide, container, false);

        // Locate the ViewPager in viewpager_main.xml
        viewPager = (ViewPager) windows.findViewById(R.id.pager);
        // Pass results to ViewPagerAdapter Class

        List<Page> pageList = Arrays.asList((Page[])  Utils.getObject(getActivity(),
                lesson.getPages(), Page[].class));

        //ArrayList<Page> pages =  (ArrayList<Page>)(ArrayList<?>) Arrays.asList(Utils.getObject(getActivity(), lesson.getPages(), Page[].class));

        adapter = new ViewPagerAdapter(getActivity(), pageList);
        // Binds the Adapter to the ViewPager
        viewPager.setAdapter(adapter);

        return windows;
    }*/
}