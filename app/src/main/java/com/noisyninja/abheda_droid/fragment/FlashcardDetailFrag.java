package com.noisyninja.abheda_droid.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.noisyninja.abheda_droid.R;
import com.noisyninja.abheda_droid.control.ViewPagerAdapter;
import com.noisyninja.abheda_droid.pojo.Lesson;
import com.noisyninja.abheda_droid.pojo.Page;
import com.noisyninja.abheda_droid.util.Constants;
import com.noisyninja.abheda_droid.util.Utils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ir2pi on 1/26/2015.
 */
public class FlashcardDetailFrag extends Fragment {

    Lesson lesson;
    ViewPager viewPager;
    PagerAdapter adapter;

    public FlashcardDetailFrag() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(Constants.FRAGMENT_DATA)) {

            String data = getArguments().getString(Constants.FRAGMENT_DATA);

            lesson = new Lesson();
            lesson = (Lesson) Utils.getFromJson(data, Lesson.class);

            Utils.handleInfo(getActivity(), lesson.toString());
        }
    }

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
    }
}
