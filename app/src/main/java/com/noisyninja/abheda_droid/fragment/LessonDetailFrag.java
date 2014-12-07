package com.noisyninja.abheda_droid.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.noisyninja.abheda_droid.control.ListLessonDetailAdapter;
import com.noisyninja.abheda_droid.control.ListLessonDetailItem;
import com.noisyninja.abheda_droid.pojo.DummyContent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ir2pi on 11/30/2014.
 */

public class LessonDetailFrag extends ListFragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public LessonDetailFrag() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(
                    ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        List<ListLessonDetailItem> items = new ArrayList<ListLessonDetailItem>();

        items.add(0,
                new ListLessonDetailItem(
                        getResources().getDrawable(DummyContent.ITEMS.get(0).resourceId),
                        DummyContent.ITEMS.get(0).id,
                        DummyContent.ITEMS.get(0).content));
        items.add(1,
                new ListLessonDetailItem(
                        getResources().getDrawable(DummyContent.ITEMS.get(1).resourceId),
                        DummyContent.ITEMS.get(1).id,
                        DummyContent.ITEMS.get(1).content));
        items.add(2,
                new ListLessonDetailItem(
                        getResources().getDrawable(DummyContent.ITEMS.get(2).resourceId),
                        DummyContent.ITEMS.get(2).id,
                        DummyContent.ITEMS.get(2).content));
        items.add(3,
                new ListLessonDetailItem(
                        getResources().getDrawable(DummyContent.ITEMS.get(3).resourceId),
                        DummyContent.ITEMS.get(3).id,
                        DummyContent.ITEMS.get(3).content));
        items.add(4,
                new ListLessonDetailItem(
                        getResources().getDrawable(DummyContent.ITEMS.get(0).resourceId),
                        DummyContent.ITEMS.get(0).id,
                        DummyContent.ITEMS.get(0).content));
        items.add(5,
                new ListLessonDetailItem(
                        getResources().getDrawable(DummyContent.ITEMS.get(1).resourceId),
                        DummyContent.ITEMS.get(1).id,
                        DummyContent.ITEMS.get(1).content));
        items.add(6,
                new ListLessonDetailItem(
                        getResources().getDrawable(DummyContent.ITEMS.get(2).resourceId),
                        DummyContent.ITEMS.get(2).id,
                        DummyContent.ITEMS.get(2).content));
        items.add(7,
                new ListLessonDetailItem(
                        getResources().getDrawable(DummyContent.ITEMS.get(3).resourceId),
                        DummyContent.ITEMS.get(3).id,
                        DummyContent.ITEMS.get(3).content));

        ListLessonDetailAdapter adapter = new ListLessonDetailAdapter(getActivity().getBaseContext(), items);

        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
        /*View rootView = inflater.inflate(R.layout.lesson_detail_frag,
                container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.lessonDetailText))
                    .setText(mItem.content);
            ((ImageView) rootView.findViewById(R.id.lessonDetailImage))
                    .setImageResource(mItem.resourceId);
        }

        return rootView;
    }*/
}