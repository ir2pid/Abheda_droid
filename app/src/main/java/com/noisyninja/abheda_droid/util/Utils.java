package com.noisyninja.abheda_droid.util;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.noisyninja.abheda_droid.R;

import junit.framework.Assert;

import at.markushi.ui.CircleButton;

/**
 * Created by ir2pi on 12/2/2014.
 */
public class Utils {

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
}
