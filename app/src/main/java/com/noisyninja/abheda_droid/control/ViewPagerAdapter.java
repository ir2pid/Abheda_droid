package com.noisyninja.abheda_droid.control;

/**
 * Created by ir2pi on 2/17/2015.
 */

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.noisyninja.abheda_droid.R;
import com.noisyninja.abheda_droid.pojo.Page;
import com.noisyninja.abheda_droid.util.Utils;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {
    // Declare Variables
    Context context;
    List<Page> pageArrayList;
    LayoutInflater inflater;

    public ViewPagerAdapter(Context context, List<Page> pageArrayList) {
        this.context = context;
        this.pageArrayList = pageArrayList;
    }

    @Override
    public int getCount() {
        return pageArrayList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        // Declare Variables

        TextView name;
        TextView description;
        TextView text;
        ImageView image;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.item_view_pager, container,
                false);

        // Locate the TextViews in viewpager_item.xml
        name = (TextView) itemView.findViewById(R.id.name);
        description = (TextView) itemView.findViewById(R.id.description);
        text = (TextView) itemView.findViewById(R.id.text);

        // Capture position and set to the TextViews
        name.setText(pageArrayList.get(position).getName());
        description.setText(pageArrayList.get(position).getDescription());
        text.setText(pageArrayList.get(position).getText1());

        // Locate the ImageView in viewpager_item.xml
        image = (ImageView) itemView.findViewById(R.id.image);
        // Capture position and set to the ImageView
        Utils.lazyload(context, image, pageArrayList.get(position).getImage1());
        // Add viewpager_item.xml to ViewPager
        ((ViewPager) container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((LinearLayout) object);

    }
}