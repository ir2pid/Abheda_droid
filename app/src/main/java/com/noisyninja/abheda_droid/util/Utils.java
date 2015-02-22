package com.noisyninja.abheda_droid.util;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.github.lzyzsd.circleprogress.ArcProgress;
import com.github.lzyzsd.circleprogress.CircleProgress;
import com.github.lzyzsd.circleprogress.DonutProgress;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.noisyninja.abheda_droid.R;
import com.noisyninja.abheda_droid.control.FlipAnimation;
import com.noisyninja.abheda_droid.control.quickaction.ActionItem;
import com.noisyninja.abheda_droid.control.quickaction.QuickAction;
import com.noisyninja.abheda_droid.fragment.FlashcardDetailFrag;
import com.noisyninja.abheda_droid.fragment.LessonDetailFrag;
import com.noisyninja.abheda_droid.fragment.MCQDetailFrag;
import com.noisyninja.abheda_droid.fragment.OrderGameDetailFrag;
import com.noisyninja.abheda_droid.fragment.PictureMatchDetailFrag;
import com.noisyninja.abheda_droid.util.Constants.MODULE_TYPE;
import com.noisyninja.abheda_droid.util.Constants.PROGRESS_STYLE;

import junit.framework.Assert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import at.markushi.ui.CircleButton;

/**
 * Created by ir2pi on 12/2/2014.
 */
public class Utils {

    private static String TAG = Utils.class.getSimpleName();
    private static ProgressDialog mProgressDialog;

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

    public static void handleError(Context context, Exception e){

        Log.e(Utils.class.getCanonicalName(), Constants.ERROR + e.getMessage());
        Toast.makeText(context, Constants.ERROR + e.getMessage(), Toast.LENGTH_SHORT).show();

    }

    public static void handleError(Context context, String e){

        Log.e(Utils.class.getCanonicalName(), Constants.ERROR + e);
        Toast.makeText(context, Constants.ERROR + e, Toast.LENGTH_SHORT).show();

    }

    public static void handleInfo(Context context, String e){

        Log.i(Utils.class.getCanonicalName(), Constants.INFO + e);
        Toast.makeText(context, Constants.INFO + e, Toast.LENGTH_SHORT).show();

    }

    public static void write(Context context, String data){
        write(context, Constants.LOCAL_STORE,  data);
    }

    public static void write(Context context, String fileName, String data){
        try {
            FileOutputStream fOut = context.openFileOutput(fileName, Context.MODE_WORLD_READABLE);
            fOut.write(data.getBytes());
            fOut.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            Utils.handleError(context, e);
            e.printStackTrace();
        }
    }

    public static Object getObject(Context context, String fileName, Class clazz)
    {
        GsonBuilder gsonBuilder = new GsonBuilder();
        //gsonBuilder.setDateFormat("M/d/yy hh:mm a");
        Gson gson = gsonBuilder.create();

        /*
        List<Post> posts = new ArrayList<Post>();
        posts = Arrays.asList(gson.fromJson(reader, Post[].class));
        */
        String json = Utils.read(context, fileName);
        if(json == null)
        {
            json = Utils.getStringFromAsset(context, fileName);
        }
        return gson.fromJson(json, clazz);
    }

    public static String read(Context context)
    {
        return read(context, Constants.LOCAL_STORE);
    }

    public static String read(Context context, String fileName){
        StringBuilder temp = new StringBuilder();
        FileInputStream fin = null;

        if(fileName == null)
            fileName = Constants.LOCAL_STORE;

        try{
            fin =  new FileInputStream (new File(fileName));
            int c;

            while( (c = fin.read()) != -1){
                temp = temp.append(Character.toString((char)c));
            }
            return temp.toString();
        }catch(Exception e){
            Utils.handleError(context, e);
        }
        finally {
                try {
                   if (fin != null) {
                       fin.close();
                   }
                } catch (IOException e) {
                    Log.e(TAG, "Error closing asset " + fileName);
                }
            }
        return null;
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

    public static void showProgress(Context context, PROGRESS_STYLE progress_style)
    {
        mProgressDialog = new ProgressDialog(context);
        int style = (progress_style == PROGRESS_STYLE.INDETERMINATE)?ProgressDialog.STYLE_SPINNER:ProgressDialog.STYLE_HORIZONTAL;

        mProgressDialog.setMessage(Constants.DOWNLOAD_TEXT);
        mProgressDialog.setProgressStyle(style);
        mProgressDialog.setCancelable(false);
        mProgressDialog.getWindow().getAttributes().windowAnimations = R.style.dialogAnimation_down_up;
        mProgressDialog.show();
    }

    public static void updateProgressDeterminate(int value)
    {
        mProgressDialog.setProgress(value);
    }

    public static void hideProgress()
    {
        mProgressDialog.dismiss();
    }


    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static void setPreference(Context context, String key, String value)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getPreference(Context context, String key)
    {
        return getPreference(context, key, null);
    }

    public static String getPreference(Context context, String key, String defaultValue)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String value = preferences.getString(key, defaultValue);
        return value;
    }

    public static Object getFromJson(String data, Class clazz)
    {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        return gson.fromJson(data, clazz);
    }

    public static void lazyload(Context context, ImageView fromview, ImageView toview, String url)
    {
        Glide.with(context)
                .load(url)
                .fitCenter()
                .placeholder(R.drawable.loading)
                .crossFade()
                .animate(new FlipAnimation(fromview, toview))
                .into(toview);
    }

    public static void lazyload(Context context, ImageView view, String url)
    {
        Glide.with(context)
                .load(url)
                .fitCenter()
                .placeholder(R.drawable.loading)
                .crossFade()
                .animate(new FlipAnimation(view, view))
                .into(view);
    }

    public static void animateFlip(View rootLayout, View cardFace, View cardBack)
    {
        FlipAnimation flipAnimation = new FlipAnimation(cardFace, cardBack);

        if (cardFace.getVisibility() == View.INVISIBLE)
        {
            flipAnimation.reverse();
        }
        rootLayout.startAnimation(flipAnimation);
    }

    public static void mail(Context context, String data)
    {
        mail(context, "ir2pid@gmail.com", data);
    }

    public static void mail(Context context, String to, String data)
    {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", to, null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "schema");
        emailIntent.putExtra(Intent.EXTRA_TEXT, data+"\n--------\n\n\n\n-------\n");
        context.startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }

    public static void backPress(Activity activity)
    {
        activity.onBackPressed();
    }

    public static void courseFacade(FragmentActivity activity, String data, MODULE_TYPE module_type)
    {
        //String data = activity.getIntent().getStringExtra(Constants.FRAGMENT_DATA);
        //Constants.MODULE_TYPE module_type = Constants.MODULE_TYPE.valueOf(activity.getIntent().getStringExtra(Constants.FRAGMENT_TYPE));
        Bundle arguments = new Bundle();
        arguments.putString(Constants.FRAGMENT_DATA, data);

        switch (module_type){

            case LESSON: {
                LessonDetailFrag fragment = new LessonDetailFrag();
                fragment.setArguments(arguments);
                activity.getSupportFragmentManager().beginTransaction()
                        .add(R.id.lesson_detail_container, fragment).commit();
                break;
            }case FLASHCARD: {
                FlashcardDetailFrag fragment = new FlashcardDetailFrag();
                fragment.setArguments(arguments);
                activity.getSupportFragmentManager().beginTransaction()
                        .add(R.id.lesson_detail_container, fragment).commit();
                break;
            }case MCQ_QUIZ: {
                MCQDetailFrag fragment = new MCQDetailFrag();
                fragment.setArguments(arguments);
                activity.getSupportFragmentManager().beginTransaction()
                        .add(R.id.lesson_detail_container, fragment).commit();
                break;
            }case ORDER_GAME_QUIZ: {
                OrderGameDetailFrag fragment = new OrderGameDetailFrag();
                fragment.setArguments(arguments);
                activity.getSupportFragmentManager().beginTransaction()
                        .add(R.id.lesson_detail_container, fragment).commit();
                break;
            }case PICTURE_MATCH_QUIZ: {
                PictureMatchDetailFrag fragment = new PictureMatchDetailFrag();
                fragment.setArguments(arguments);
                activity.getSupportFragmentManager().beginTransaction()
                        .add(R.id.lesson_detail_container, fragment).commit();
                break;
            }

        }
    }
}
