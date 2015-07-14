package com.noisyninja.abheda_droid.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;
import com.noisyninja.abheda_droid.R;
import com.noisyninja.abheda_droid.control.ReviewAdapter;
import com.noisyninja.abheda_droid.pojo.misc.ReviewItem;
import com.noisyninja.abheda_droid.util.ReviewUtil;
import com.noisyninja.abheda_droid.util.Utils;

import java.util.ArrayList;

/**
 * Created by sudipta.a.dutta on 14/06/15.
 */
public class QuizReviewFrag extends Fragment implements View.OnClickListener {

    View window;
    Button exit;
    TextView count;
    SwipeFlingAdapterView flingContainer;
    private ArrayList<ReviewItem> reviewItemArrayList;
    private ReviewAdapter reviewAdapter;
    private int i;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        window = inflater.inflate(R.layout.frag_review_detail, container, false);
        count = (TextView) window.findViewById(R.id.count);
        exit = (Button) window.findViewById(R.id.exit);
        exit.setOnClickListener(this);
        flingContainer = (SwipeFlingAdapterView) window.findViewById(R.id.swipeview);

        loadData();
        return window;
    }

        @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.exit:{
                Utils.backPress(getActivity());
                break;
            }
        }
    }

    public void loadData(){
        i = 1;
        reviewItemArrayList = ReviewUtil.getInstance().getReviewItemArrayList();
        count.setText("Q "+i+" of "+reviewItemArrayList.size());

        //choose your favorite adapter
        reviewAdapter = new ReviewAdapter(getActivity(), R.layout.item_review, reviewItemArrayList);

        //set the listener and the adapter
        flingContainer.setAdapter(reviewAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!");
                ReviewItem reviewItem = reviewItemArrayList.get(0);
                reviewItemArrayList.remove(0);
                reviewItemArrayList.add(reviewItem);
                reviewAdapter.notifyDataSetChanged();
                i++;
                if(i > reviewItemArrayList.size()){
                    i = 1;
                }
                count.setText("Q "+i+" of "+reviewItemArrayList.size());
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
                //Toast.makeText(getActivity(), "Left!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                //Toast.makeText(getActivity(), "Right!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                // Ask for more data here
                //reviewItemArrayList.add("XML ".concat(String.valueOf(i)));
                //reviewAdapter.notifyDataSetChanged();
                //Log.d("LIST", "notified");
                //i++;
            }
            @Override
            public void onScroll(float f){

            }
        });

        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
                //Utils.makeToast(getActivity(), "Clicked!");
            }
        });
    }
}
