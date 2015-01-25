package com.noisyninja.abheda_droid.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.noisyninja.abheda_droid.control.ListLessonDetailAdapter;
import com.noisyninja.abheda_droid.control.ListLessonDetailItem;
import com.noisyninja.abheda_droid.pojo.Chapter;
import com.noisyninja.abheda_droid.pojo.Lesson;
import com.noisyninja.abheda_droid.util.Constants;
import com.noisyninja.abheda_droid.util.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ir2pi on 1/26/2015.
 */
public class FlashcardDetailFrag extends ListFragment {

    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    //public static final String ARG_ITEM_ID = "item_id";
    Lesson lesson;
    /**
     * The dummy content this fragment is presenting.
     */


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FlashcardDetailFrag() {
    }

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

            lesson = new Lesson();
            lesson = (Lesson) Utils.getFromJson(data, Lesson.class);

            Utils.handleInfo(getActivity(), lesson.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        List<ListLessonDetailItem> items = new ArrayList<ListLessonDetailItem>();

        for(Chapter chapter : lesson.getChapters())
        {
            //String icon = getResources().getDrawable(R.drawable.imageholder);
            items.add(new ListLessonDetailItem(chapter.getImage1(), chapter.getText1(), chapter.getDescription()));
            items.add(new ListLessonDetailItem(chapter.getImage2(), chapter.getText2(), chapter.getDescription()));
        }

        ListLessonDetailAdapter adapter = new ListLessonDetailAdapter(getActivity().getBaseContext(), items);

        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
