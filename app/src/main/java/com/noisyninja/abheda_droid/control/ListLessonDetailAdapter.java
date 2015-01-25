package com.noisyninja.abheda_droid.control;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.noisyninja.abheda_droid.R;
import com.noisyninja.abheda_droid.util.Utils;

import java.util.List;

/**
 * Created by ir2pi on 11/30/2014.
 */
public class ListLessonDetailAdapter extends ArrayAdapter<ListLessonDetailItem> {

    Context context;
    public ListLessonDetailAdapter(Context context, List<ListLessonDetailItem> items) {
        super(context, R.layout.list_lesson_detail_item, items);

        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null) {
            // inflate the GridView item layout
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_lesson_detail_item, parent, false);

            // initialize the view holder
            viewHolder = new ViewHolder();
            viewHolder.ivIcon = (ImageView) convertView.findViewById(R.id.ivIcon);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.tvDescription = (TextView) convertView.findViewById(R.id.tvDescription);
            convertView.setTag(viewHolder);
        } else {
            // recycle the already inflated view
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // update the item view
        ListLessonDetailItem item = getItem(position);
        /*Picasso.with(context)
                .load(item.icon)
                .placeholder(R.drawable.imageholder)
                .error(R.drawable.user_placeholder_error)
                .into(imageView);*/
        //String img = "http://www.gambarphoto.com/wp-content/uploads/2014/05/android-wallpaper-640x480awesome-10-android-960x800-pixels-640x480-pixels-wallpapers-bbrdqbl1.jpg";

        Utils.lazyload(context, viewHolder.ivIcon, item.icon);
        viewHolder.tvTitle.setText(item.title);
        viewHolder.tvDescription.setText(item.description);

        return convertView;
    }

    /**
     * The view holder design pattern prevents using findViewById()
     * repeatedly in the getView() method of the adapter.
     *
     * @see http://developer.android.com/training/improving-layouts/smooth-scrolling.html#ViewHolder
     */
    private static class ViewHolder {
        ImageView ivIcon;
        TextView tvTitle;
        TextView tvDescription;
    }
}