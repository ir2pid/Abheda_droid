package com.noisyninja.abheda_droid.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.noisyninja.abheda_droid.R;
import com.noisyninja.abheda_droid.control.ListAdapter;
import com.noisyninja.abheda_droid.control.ListViewItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ir2pi on 11/30/2014.
 */

public class LessonFrag extends ListFragment {
    private List<ListViewItem> mItems;        // ListView items list

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // initialize the items list
        mItems = new ArrayList<ListViewItem>();
        Resources resources = getResources();

        mItems.add(new ListViewItem(resources.getDrawable(R.drawable.imageholder), getString(R.string.lessons), getString(R.string.lessons)));
        mItems.add(new ListViewItem(resources.getDrawable(R.drawable.imageholder), getString(R.string.quiz), getString(R.string.quiz)));
        mItems.add(new ListViewItem(resources.getDrawable(R.drawable.imageholder), getString(R.string.info), getString(R.string.info)));
        mItems.add(new ListViewItem(resources.getDrawable(R.drawable.imageholder), getString(R.string.lessons), getString(R.string.lessons)));
        mItems.add(new ListViewItem(resources.getDrawable(R.drawable.imageholder), getString(R.string.quiz), getString(R.string.quiz)));
        mItems.add(new ListViewItem(resources.getDrawable(R.drawable.imageholder), getString(R.string.info), getString(R.string.info)));
        mItems.add(new ListViewItem(resources.getDrawable(R.drawable.imageholder), getString(R.string.lessons), getString(R.string.lessons)));
        mItems.add(new ListViewItem(resources.getDrawable(R.drawable.imageholder), getString(R.string.quiz), getString(R.string.quiz)));
        mItems.add(new ListViewItem(resources.getDrawable(R.drawable.imageholder), getString(R.string.info), getString(R.string.info)));

        // initialize and set the list adapter
        setListAdapter(new ListAdapter(getActivity(), mItems));
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // remove the dividers from the ListView of the ListFragment
        getListView().setDivider(null);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // retrieve theListView item
        ListViewItem item = mItems.get(position);

        // do something
        Toast.makeText(getActivity(), item.title, Toast.LENGTH_SHORT).show();
    }

    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View android = inflater.inflate(R.layout.lesson_frag, container, false);
        ((TextView) android.findViewById(R.id.textView)).setText("Android");
        return android;
    }*/
}
