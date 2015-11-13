package com.noisyninja.abheda_droid.control;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.noisyninja.abheda_droid.R;
import com.noisyninja.abheda_droid.pojo.misc.ReviewItem;
import com.noisyninja.abheda_droid.util.Utils;

import java.util.ArrayList;

/**
 * adapter for courses review
 * Created by ir2pi on 4/23/2015.
 */
public class ReviewAdapter extends ArrayAdapter {
    private Context context;
    private ArrayList<ReviewItem> reviewItemArrayList;

    public ReviewAdapter(Context context, int resourceId, ArrayList<ReviewItem> reviewItemArrayList) {
        super(context, resourceId, reviewItemArrayList);
        this.context = context;
        this.reviewItemArrayList = reviewItemArrayList;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_review, parent, false);

            holder = new ViewHolder();
            holder.question = (TextView) convertView.findViewById(R.id.question);
            holder.wrong = (TextView) convertView.findViewById(R.id.wrong);
            holder.correct = (TextView) convertView.findViewById(R.id.correct);

            holder.question.setText(reviewItemArrayList.get(position).getQuestion());

            holder.wrong.setText(reviewItemArrayList.get(position).getWrong());
            Utils.addSpeechClickListener(context, holder.wrong, holder.wrong.getText().toString());

            holder.correct.setText(reviewItemArrayList.get(position).getCorrect());
            Utils.addSpeechClickListener(context, holder.wrong, holder.correct.getText().toString());

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        return convertView;
    }

    /*private void speak(String text) {
        TTSUtils.getInstance(getContext()).initQueue(text);
    }*/

    @Override
    public int getCount() {
        return reviewItemArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return reviewItemArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    public static class ViewHolder {
        TextView question;
        TextView wrong;
        TextView correct;
    }
}
