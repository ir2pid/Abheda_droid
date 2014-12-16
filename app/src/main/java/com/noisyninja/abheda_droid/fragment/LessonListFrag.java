package com.noisyninja.abheda_droid.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.noisyninja.abheda_droid.R;
import com.noisyninja.abheda_droid.control.ListLessonAdapter;
import com.noisyninja.abheda_droid.control.ListLessonItem;
import com.noisyninja.abheda_droid.pojo.DummyContent;
import com.noisyninja.abheda_droid.util.Constants;
import com.noisyninja.abheda_droid.util.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ir2pi on 12/5/2014.
 */
public class LessonListFrag extends ListFragment {

    /**
     * The serialization (saved instance state) Bundle key representing the
     * activated item position. Only used on tablets.
     */
    private static final String STATE_ACTIVATED_POSITION = "activated_position";

    /**
     * The fragment's current callback object, which is notified of list item
     * clicks.
     */
    private Callbacks mCallbacks = sDummyCallbacks;

    /**
     * The current activated item position. Only used on tablets.
     */
    private int mActivatedPosition = ListView.INVALID_POSITION;

    /**
     * A callback interface that all activities containing this fragment must
     * implement. This mechanism allows activities to be notified of item
     * selections.
     */
    public interface Callbacks {
        /**
         * Callback for when an item has been selected.
         */
        public void onItemSelected(String id);
    }

    /**
     * A dummy implementation of the {@link Callbacks} interface that does
     * nothing. Used only when this fragment is not attached to an activity.
     */
    private static Callbacks sDummyCallbacks = new Callbacks() {
        @Override
        public void onItemSelected(String id) {
        }
    };

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public LessonListFrag() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Restore the previously serialized activated item position.
        if (savedInstanceState != null
                && savedInstanceState.containsKey(STATE_ACTIVATED_POSITION)) {
            setActivatedPosition(savedInstanceState
                    .getInt(STATE_ACTIVATED_POSITION));
        }

        List<ListLessonItem> items = new ArrayList<ListLessonItem>();
        ListLessonItem listLessonItem1 = new ListLessonItem(
                getResources().getDrawable(R.drawable.ic_disclosure2),
                Constants.itemTypes[0],
                Constants.itemTypes2[0]);
        ListLessonItem listLessonItem2 = new ListLessonItem(
                getResources().getDrawable(R.drawable.ic_disclosure2),
                Constants.itemTypes[1],
                Constants.itemTypes2[1]);
        ListLessonItem listLessonItem3 = new ListLessonItem(
                getResources().getDrawable(R.drawable.ic_disclosure2),
                Constants.itemTypes[2],
                Constants.itemTypes2[2]);

        items.add(listLessonItem1);
        items.add(listLessonItem2);
        items.add(listLessonItem3);
        items.add(listLessonItem1);
        items.add(listLessonItem2);
        items.add(listLessonItem3);
        items.add(listLessonItem1);
        items.add(listLessonItem2);
        items.add(listLessonItem3);
        items.add(listLessonItem1);
        items.add(listLessonItem2);
        items.add(listLessonItem3);
        items.add(listLessonItem1);
        items.add(listLessonItem2);
        items.add(listLessonItem3);
        // TODO: replace with a real list adapter.
        setListAdapter(new ListLessonAdapter(getActivity(), items));
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // Activities containing this fragment must implement its callbacks.
        if (!(activity instanceof Callbacks)) {
            throw new IllegalStateException(
                    "Activity must implement fragment's callbacks.");
        }

        mCallbacks = (Callbacks) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();

        // Reset the active callbacks interface to the dummy implementation.
        mCallbacks = sDummyCallbacks;
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position,
                                long id) {
        super.onListItemClick(listView, view, position, id);
        // Notify the active callbacks interface (the activity, if the
        // fragment is attached to one) that an item has been selected.
        mCallbacks.onItemSelected(DummyContent.ITEMS.get(position).id);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mActivatedPosition != ListView.INVALID_POSITION) {
            // Serialize and persist the activated item position.
            outState.putInt(STATE_ACTIVATED_POSITION, mActivatedPosition);
        }
    }

    /**
     * Turns on activate-on-click mode. When this mode is on, list items will be
     * given the 'activated' state when touched.
     */
    public void setActivateOnItemClick(boolean activateOnItemClick) {
        // When setting CHOICE_MODE_SINGLE, ListView will automatically
        // give items the 'activated' state when touched.
        getListView().setChoiceMode(
                activateOnItemClick ? ListView.CHOICE_MODE_SINGLE
                        : ListView.CHOICE_MODE_NONE);
    }

    private void setActivatedPosition(int position) {
        if (position == ListView.INVALID_POSITION) {
            getListView().setItemChecked(mActivatedPosition, false);
        } else {
            getListView().setItemChecked(position, true);
        }

        mActivatedPosition = position;
    }
}