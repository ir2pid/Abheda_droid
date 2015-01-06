package com.noisyninja.abheda_droid.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.github.lzyzsd.circleprogress.ArcProgress;
import com.github.lzyzsd.circleprogress.CircleProgress;
import com.github.lzyzsd.circleprogress.DonutProgress;
import com.noisyninja.abheda_droid.R;
import com.noisyninja.abheda_droid.control.quickaction.ActionItem;
import com.noisyninja.abheda_droid.control.quickaction.QuickAction;

import junit.framework.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import at.markushi.ui.CircleButton;

/**
 * Created by ir2pi on 12/2/2014.
 */
public class Utils {

    private static String TAG = Utils.class.getSimpleName();

    public static int getDrawable(Context context, String name) {
        // use -> image.setImageResource(getDrawable(this,"image"));

        Assert.assertNotNull(context);
        Assert.assertNotNull(name);

        int id = context.getResources().getIdentifier(name,
                "drawable", context.getPackageName());

        return id != 0? id : context.getResources().getIdentifier("imageholder",
                "drawable", context.getPackageName());
    }

    public static String getTag(Class c)
    {
        return c.getSimpleName();
    }

    public static void startActivity(Context context, Class nextClass)
    {
        Intent intent = new Intent(context, nextClass);
        //myIntent.putExtra("key", value); //Optional parameters
        context.startActivity(intent);
    }

    public static void makeToast(Context context, String text)
    {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    public static void makeAnimation(View view, Techniques techniques)
    {
        YoYo.with(Techniques.RubberBand)
                .duration(Constants.ANIMATION_TIME_700)
                .playOn(view);
    }

    public static void makeAnimation(View view)
    {
        makeAnimation(view, Techniques.Bounce);
    }

    public static void playSound(Context context, Constants.Sound sound)
    {
        MediaPlayer mp;
        switch (sound) {
            case RIGHT: mp = MediaPlayer.create(context, R.raw.tethys);break;
            case WRONG: mp = MediaPlayer.create(context, R.raw.iapetus);break;
            case CLICK: mp = MediaPlayer.create(context, R.raw.unlock);break;
            default: mp = MediaPlayer.create(context, R.raw.elara);break;
        }
        mp.start();
    }

    public static void setBgGradient()
    {
        //View layout = findViewById(R.id.mainlayout);

        GradientDrawable gd = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                new int[] {0xFF616261,0xFF131313});
        gd.setCornerRadius(0f);

        //layout.setBackgroundDrawable(gd);
    }

    public static void showResult(Context context, boolean value)
    {
        // custom dialog
        final Dialog dialog = new Dialog(context);//, R.style.TransparentDialog
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(R.layout.dialog_quiz_result);
        dialog.getWindow().getAttributes().windowAnimations = R.style.dialogAnimation_down_up;

        // set the custom dialog components - button
        CircleButton buttonModule1 = (CircleButton) dialog.findViewById(R.id.circleButton1);
        CircleButton buttonModule2 = (CircleButton) dialog.findViewById(R.id.circleButton2);

        if(value)
        {
            Utils.playSound(context, Constants.Sound.RIGHT);
            buttonModule1.setVisibility(View.VISIBLE);
            buttonModule2.setVisibility(View.INVISIBLE);
        }
        else
        {
            Utils.playSound(context, Constants.Sound.WRONG);
            buttonModule1.setVisibility(View.INVISIBLE);
            buttonModule2.setVisibility(View.VISIBLE);
        }

        dialog.show();
    }

    public static void showQuickAction(Activity activity, View view)
    {

        ActionItem nextItem 	= new ActionItem(1, "Next", activity.getResources().getDrawable(R.drawable.bulb2));
        ActionItem prevItem 	= new ActionItem(2, "Prev", activity.getResources().getDrawable(R.drawable.check_book));
        ActionItem searchItem 	= new ActionItem(3, "Find", activity.getResources().getDrawable(R.drawable.bookmark_add));
        ActionItem infoItem 	= new ActionItem(4, "Info", activity.getResources().getDrawable(R.drawable.check_book));
        ActionItem eraseItem 	= new ActionItem(5, "Clear", activity.getResources().getDrawable(R.drawable.bookmark_remove));
        ActionItem okItem 		= new ActionItem(6, "OK", activity.getResources().getDrawable(R.drawable.book4));

        //use setSticky(true) to disable QuickAction dialog being dismissed after an item is clicked
        prevItem.setSticky(true);
        nextItem.setSticky(true);

        //create QuickAction. Use QuickAction.VERTICAL or QuickAction.HORIZONTAL param to define layout
        //orientation
        final QuickAction quickAction = new QuickAction(activity, QuickAction.VERTICAL);

        //add action items into QuickAction
        quickAction.addActionItem(nextItem);
        quickAction.addActionItem(prevItem);
        quickAction.addActionItem(searchItem);
        quickAction.addActionItem(infoItem);
        quickAction.addActionItem(eraseItem);
        quickAction.addActionItem(okItem);

        //Set listener for action item clicked
        quickAction.setOnActionItemClickListener(new QuickAction.OnActionItemClickListener() {
            @Override
            public void onItemClick(QuickAction source, int pos, int actionId) {
                ActionItem actionItem = quickAction.getActionItem(pos);

                //here we can filter which action item was clicked with pos or actionId parameter
                if (actionId == 1) {
                    //Toast.makeText(activity, "Let's do some search action", Toast.LENGTH_SHORT).show();
                } else if (actionId == 2) {
                    //Toast.makeText(getApplicationContext(), "I have no info this time", Toast.LENGTH_SHORT).show();
                } else {
                    //Toast.makeText(getApplicationContext(), actionItem.getTitle() + " selected", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //set listnener for on dismiss event, this listener will be called only if QuickAction dialog was dismissed
        //by clicking the area outside the dialog.
        quickAction.setOnDismissListener(new QuickAction.OnDismissListener() {
            @Override
            public void onDismiss() {
               // Toast.makeText(getApplicationContext(), "Dismissed", Toast.LENGTH_SHORT).show();
            }
        });

        quickAction.show(view);
    }

    public static String getStringFromAsset(Context context, String fileName) {
        BufferedReader in = null;
        try {
            StringBuilder buf = new StringBuilder();
            InputStream is = context.getAssets().open(fileName);
            in = new BufferedReader(new InputStreamReader(is));

            String str;
            boolean isFirst = true;
            while ( (str = in.readLine()) != null ) {
                if (isFirst)
                    isFirst = false;
                else
                    buf.append('\n');
                buf.append(str);
            }

            return buf.toString();
        } catch (IOException e) {
            Log.e(TAG, "Error opening asset " + fileName);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    Log.e(TAG, "Error closing asset " + fileName);
                }
            }
        }
        return null;
    }

    public static void styleCircle(CircleProgress cProgress, Context context)
    {
        cProgress.setUnfinishedColor(context.getResources().getColor(R.color.button_transparent_white));
        cProgress.setFinishedColor(context.getResources().getColor(R.color.button_off_white));
        cProgress.setTextColor(context.getResources().getColor(R.color.button_gray));
        //cProgress.setTextSize(8);
        /*arcProgress.setBottomText(context.getString(R.string.progress));
        arcProgress.setFinishedStrokeColor(context.getResources().getColor(R.color.button_off_white));
        arcProgress.setTextColor(context.getResources().getColor(R.color.button_off_white));
        arcProgress.setStrokeWidth(15);
        arcProgress.setUnfinishedStrokeColor(context.getResources().getColor(R.color.button_transparent_white));*/
    }

    public static void styleDonut(DonutProgress dProgress, Context context)
    {
        dProgress.setUnfinishedStrokeWidth(2);
        dProgress.setFinishedStrokeWidth(10);
        dProgress.setTextColor(context.getResources().getColor(R.color.button_off_white));
        dProgress.setFinishedStrokeColor(context.getResources().getColor(R.color.button_off_white));
        dProgress.setUnfinishedStrokeColor(context.getResources().getColor(R.color.button_transparent_white));
        dProgress.setInnerBackgroundColor(context.getResources().getColor(R.color.button_transparent));
        //cProgress.setTextSize(8);
        /*arcProgress.setBottomText(context.getString(R.string.progress));
        arcProgress.setFinishedStrokeColor(context.getResources().getColor(R.color.button_off_white));
        arcProgress.setTextColor(context.getResources().getColor(R.color.button_off_white));
        arcProgress.setStrokeWidth(15);
        arcProgress.setUnfinishedStrokeColor(context.getResources().getColor(R.color.button_transparent_white));*/
    }

    public static void styleArc(ArcProgress arcProgress, Context context)
    {
        arcProgress.setBottomText(context.getString(R.string.progress));
        arcProgress.setFinishedStrokeColor(context.getResources().getColor(R.color.button_off_white));
        arcProgress.setTextColor(context.getResources().getColor(R.color.button_off_white));
        arcProgress.setStrokeWidth(15);
        arcProgress.setUnfinishedStrokeColor(context.getResources().getColor(R.color.button_transparent_white));
    }
}
