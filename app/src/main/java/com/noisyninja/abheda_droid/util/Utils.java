package com.noisyninja.abheda_droid.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.widget.Toast;

import com.noisyninja.abheda_droid.R;

import junit.framework.Assert;

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
}
