package com.noisyninja.abheda_droid.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.noisyninja.abheda_droid.control.ListLessonDetailAdapter;
import com.noisyninja.abheda_droid.control.ListLessonDetailItem;
import com.noisyninja.abheda_droid.pojo.Lesson;
import com.noisyninja.abheda_droid.pojo.Page;
import com.noisyninja.abheda_droid.util.Constants;
import com.noisyninja.abheda_droid.util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ir2pi on 11/30/2014.
 */

public class LessonDetailFrag extends ListFragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    Lesson lesson;
    List<Page> pageList;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public LessonDetailFrag() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(Constants.FRAGMENT_DATA)) {

            String data = getArguments().getString(Constants.FRAGMENT_DATA);

            lesson = new Lesson();
            lesson = (Lesson)Utils.getFromJson(data, Lesson.class);

            pageList = Arrays.asList((Page[])  Utils.getObject(getActivity(),
                    lesson.getPages(), Page[].class));
            Utils.handleInfo(getActivity(), lesson.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        List<ListLessonDetailItem> items = new ArrayList<ListLessonDetailItem>();

        for(Page page : pageList)
        {
            items.add(new ListLessonDetailItem(page.getImage1(), page.getName(), page.getText1(),
                    page.getLtext1(), page.getRtext1(), page.getUtext1(), page.getDtext1(),page.getDescription()));
        }

        ListLessonDetailAdapter adapter = new ListLessonDetailAdapter(getActivity(), items);

        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

}