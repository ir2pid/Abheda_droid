package com.noisyninja.abheda_droid.control;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.noisyninja.abheda_droid.R;
import com.noisyninja.abheda_droid.util.Utils;

import java.util.List;

import de.greenrobot.event.EventBus;
import events.OnPrintEvent;

/**
 * Created by ir2pi on 11/30/2014.
 */
public class ListLessonDetailAdapter extends ArrayAdapter<ListLessonDetailItem> {

    String data;
    Context context;

    public ListLessonDetailAdapter(Context context, List<ListLessonDetailItem> items, String data) {
        super(context, R.layout.list_lesson_detail_item, items);

        this.data = data;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ListLessonDetailItem item = getItem(position);

        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.list_lesson_detail_item, parent, false);
        ImageView image = (ImageView) convertView.findViewById(R.id.image);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView text = (TextView) convertView.findViewById(R.id.text);
        TextView ltext = (TextView) convertView.findViewById(R.id.ltext);
        TextView dtext = (TextView) convertView.findViewById(R.id.dtext);
        TextView utext = (TextView) convertView.findViewById(R.id.utext);
        TextView rtext = (TextView) convertView.findViewById(R.id.rtext);
        TextView description = (TextView) convertView.findViewById(R.id.description);
        Button pdfCreate = (Button) convertView.findViewById(R.id.pdfcreate);
        pdfCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new OnPrintEvent(data));
            }
        });
        //name.setMovementMethod(new ScrollingMovementMethod());
        //text.setMovementMethod(new ScrollingMovementMethod());
        //ltext.setMovementMethod(new ScrollingMovementMethod());
        //dtext.setMovementMethod(new ScrollingMovementMethod());
        //utext.setMovementMethod(new ScrollingMovementMethod());
        //rtext.setMovementMethod(new ScrollingMovementMethod());
        //description.setMovementMethod(new ScrollingMovementMethod());

        Utils.lazyload(context, image, item.image);

        Utils.setText(name, item.name);
        Utils.addSpeechClickListener(context, name, name.getText().toString());
        Utils.setText(text, item.text);
        Utils.addSpeechClickListener(context, text, text.getText().toString());
        Utils.setText(ltext, item.ltext);
        Utils.addSpeechClickListener(context, ltext, ltext.getText().toString());
        Utils.setText(rtext, item.rtext);
        Utils.addSpeechClickListener(context, rtext, rtext.getText().toString());
        Utils.setText(utext, item.utext);
        Utils.addSpeechClickListener(context, utext, utext.getText().toString());
        Utils.setText(dtext, item.dtext);
        Utils.addSpeechClickListener(context, dtext, dtext.getText().toString());
        Utils.setText(description, item.description);
        Utils.addSpeechClickListener(context, description, description.getText().toString());

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)image.getLayoutParams();
        if(item.ltext!=null && item.ltext.length()>1)
            params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        else if(item.rtext!=null && item.rtext.length()>1)
            params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        image.setLayoutParams(params);

        /*
        ListLessonDetailItem item = getItem(position);

        ViewHolder viewHolder;

        if(convertView == null) {
            // inflate the GridView item layout
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_lesson_detail_item, parent, false);

            // initialize the view holder
            viewHolder = new ViewHolder();
            viewHolder.image = (ImageView) convertView.findViewById(R.id.image);
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.text = (TextView) convertView.findViewById(R.id.text);
            viewHolder.description = (TextView) convertView.findViewById(R.id.description);
            convertView.setTag(viewHolder);
        } else {
            // recycle the already inflated view
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // update the item view


        //String img = "http://www.gambarphoto.com/wp-content/uploads/2014/05/android-wallpaper-640x480awesome-10-android-960x800-pixels-640x480-pixels-wallpapers-bbrdqbl1.jpg";

        Utils.lazyload(context, viewHolder.image, item.image);
        viewHolder.name.setText(item.name);
        viewHolder.text.setText(item.text);
        viewHolder.description.setText(item.description);
        */
        return convertView;
    }

    /**
     * The view holder design pattern prevents using findViewById()
     * repeatedly in the getView() method of the adapter.
     *
     * @see http://developer.android.com/training/improving-layouts/smooth-scrolling.html#ViewHolder
     *//*
    private static class ViewHolder {
        ImageView image;
        TextView name;
        TextView text;
        TextView description;
    }*/
}