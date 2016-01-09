package com.noisyninja.abheda_droid.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.noisyninja.abheda_droid.R;
import com.noisyninja.abheda_droid.control.ListLessonDetailItem;
import com.noisyninja.abheda_droid.pojo.Lesson;
import com.noisyninja.abheda_droid.pojo.Page;
import com.noisyninja.abheda_droid.util.Constants;
import com.noisyninja.abheda_droid.util.IDialogCallback;
import com.noisyninja.abheda_droid.util.PDFUtil;
import com.noisyninja.abheda_droid.util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ir2pid on 02/01/16.
 */
public class PDFContentActivity extends BaseActivity implements IDialogCallback {

    Context context;
    Activity activity;
    Lesson lesson;
    List<Page> pageList;

    private static View getPDFView(Context context, ListLessonDetailItem item) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        RelativeLayout relativeLayout = (RelativeLayout) inflater.inflate(R.layout.list_lesson_detail_item, null);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(width, height));
        ImageView image = (ImageView) relativeLayout.findViewById(R.id.image);
        ImageView watermark = (ImageView) relativeLayout.findViewById(R.id.watermark);
        TextView name = (TextView) relativeLayout.findViewById(R.id.name);
        TextView text = (TextView) relativeLayout.findViewById(R.id.text);
        TextView text2 = (TextView) relativeLayout.findViewById(R.id.text2);
        TextView ltext = (TextView) relativeLayout.findViewById(R.id.ltext);
        TextView dtext = (TextView) relativeLayout.findViewById(R.id.dtext);
        TextView utext = (TextView) relativeLayout.findViewById(R.id.utext);
        TextView rtext = (TextView) relativeLayout.findViewById(R.id.rtext);
        TextView description = (TextView) relativeLayout.findViewById(R.id.description);
        Button pdfCreate = (Button) relativeLayout.findViewById(R.id.pdfcreate);
        pdfCreate.setVisibility(View.GONE);
        watermark.setVisibility(View.VISIBLE);
        watermark.setAlpha(0.1f);
        Utils.lazyload(context, image, item.image);

        Utils.setText(name, item.name);
        Utils.setText(text, item.text);
        Utils.setText(text2, item.text2);
        Utils.setText(ltext, item.ltext);
        Utils.setText(rtext, item.rtext);
        Utils.setText(utext, item.utext);
        Utils.setText(dtext, item.dtext);
        Utils.setText(description, item.description);

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) image.getLayoutParams();
        if (item.ltext != null && item.ltext.length() > 1)
            params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        else if (item.rtext != null && item.rtext.length() > 1)
            params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        image.setLayoutParams(params);

        return relativeLayout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_content);
        context = this;
        activity = this;
        final LinearLayout linearLayoutV = (LinearLayout) findViewById(R.id.base);
        Bundle extras = getIntent().getExtras();
        String data = null;

        if (extras != null) {
            data = extras.getString(Constants.FRAGMENT_DATA);
        }
        if (data != null) {

            lesson = new Lesson();
            lesson = (Lesson) Utils.getFromJson(data, Lesson.class);

            pageList = Arrays.asList((Page[]) Utils.getObject(this,
                    lesson.getPages(), Page[].class));
            Utils.handleInfo(this, lesson.toString());


            final List<ListLessonDetailItem> items = new ArrayList<ListLessonDetailItem>();
            LinearLayout linearLayoutH = null;
            int i = 0;
            int total = 0;
            for (Page page : pageList) {
                total++;
                if (i % 3 == 0) {
                    linearLayoutH = new LinearLayout(this);
                    linearLayoutH.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.FILL_PARENT));
                }
                ListLessonDetailItem listLessonDetailItem = new ListLessonDetailItem(page.getImage1(), page.getName(), page.getText1(),
                        page.getText2(), page.getLtext1(), page.getRtext1(), page.getUtext1(), page.getDtext1(), page.getDescription());
                items.add(listLessonDetailItem);
                View view = getPDFView(this, listLessonDetailItem);
                if (view != null) {
                    //linearLayoutH.addView(view);
                    linearLayoutH.addView(view);
                }
                if (linearLayoutH.getChildCount() == 3 || total == pageList.size()) {
                    linearLayoutV.addView(linearLayoutH);
                }
                i++;
            }

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after n sec = nx1000ms
                    String pdfName = PDFUtil.dump(context, linearLayoutV, pageList.get(0).getName());
                    if (pdfName != null) {
                        Utils.showDialog(activity, lesson.getName(), pdfName + " created! ", true);
                    } else {
                        Utils.showDialog(activity, lesson.getName(), Utils.getStringResource(context, R.string.pdf_not_supported), true);
                    }
                }
            }, 3000);
        }
    }

    @Override
    public void ok(DialogInterface dialog) {
        Utils.backPress(activity);
    }

    @Override
    public void cancel(DialogInterface dialog) {

    }
}