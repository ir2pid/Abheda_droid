package com.noisyninja.abheda_droid.util;

import com.noisyninja.abheda_droid.R;

/**
 * Created by ir2pi on 11/30/2014.
 *
 * apache 2.0 libraries used:
 * android-circlebutton https://github.com/markushi/android-circlebutton
 * android-HoloCircularProgressBar https://github.com/passsy/android-HoloCircularProgressBar
 * progressbutton https://github.com/f2prateek/progressbutton
 * CircleProgress https://github.com/lzyzsd/CircleProgress
 * https://github.com/idunnololz/AnimatedExpandableListView
 * Picassohttps://github.com/square/picasso/
 * glide https://github.com/bumptech/glide
 * MIT libraries
 * AndroidImageSlider
 * https://github.com/daimajia/AndroidImageSlider
 * SeekArc https://github.com/TriggerTrap/SeekArc
 *         https://github.com/SemonCat/SeekArc
 * swipelistview
 *         https://github.com/47deg/android-swipelistview#license
 * DraggableGridView
 *         https://github.com/thquinn/DraggableGridView
 * NumberProgressBar
 *         https://github.com/daimajia/NumberProgressBar
 * LoadIndicators
 *         https://github.com/adrian110288/LoadIndicators
 * AndroidViewAnimations
 *         https://github.com/daimajia/AndroidViewAnimations
 */
public class Constants {

    public static int TOPIC_ID = 0;//english
    public static int COURSE_ID = 0;//BCP
    public static int MODULE_ID = 0;//BCP 1
    public static int LESSON_QUIZ_ID = 0; //Lesson 1
    public static String DATA_FILE = "data.json";
    public static String URL_STORE = "https://drive.google.com/uc?export=download&id=0B3-WqXENqs7dWEJtTURZNWtDTmc";
    public static String URL_STORE_KEY = "URL_STORE_KEY";
    public static String LOCAL_STORE = "/sdcard/abheda.json";

    public enum Sound {
        CLICK,
        RIGHT,
        WRONG
    }
    public enum MODULE_TYPE {
        LESSON,
        FLASHCARD,
        MCQ_QUIZ,
        PICTURE_MATCH_QUIZ,
        ORDER_GAME_QUIZ
    }
    public enum PROGRESS_STYLE {
        DETERMINATE,
        INDETERMINATE
    }


    public static String FRAGMENT_DATA = "FRAGMENT_DATA";
    public static String FRAGMENT_TYPE = "FRAGMENT_TYPE";

    public static int TAB_COUNT = 3;
    public static int PROGRESS = 31;
    public static long SLEEP_TIME_2000 = 2000;    // Sleep for some time
    public static long SLEEP_TIME_20 = 20;    // Sleep for some time
    public static long ANIMATION_TIME_700 = 700;    // Sleep for some time
    public static String PROGRESS_TEXT = "Progress.. ";
    public static String PROGRESS_PERCENT = "%";
    public static String DOWNLOAD_TEXT = "Downloading file..";
    //error
    public static String ERROR = "ERROR:";
    public static String ERROR_NO_NETWORK = "NO_NETWORK";
    //info
    public static String INFO = "INFO:";
    public static String INFO_SUCCESS_DOWNLOAD = "Download success";
    public static String INFO_NO_LESSON = "ERROR_NO_LESSON";

    // Array of strings storing country names
    public static String[] itemTypes = new String[] {
            "Tick",
            "Cross",
            "Left",
            "Right"
    };

    // Array of integers points to images stored in /res/drawable/
    public static int[] flags = new int[]{
            R.drawable.ic_action_tick,
            R.drawable.ic_action_cross,
            R.drawable.ic_action_left,
            R.drawable.ic_action_right
    };

    // Array of strings to store currencies
    public static String[] itemTypes2 = new String[]{
            "ic_action_tick",
            "ic_action_cross",
            "ic_action_left",
            "ic_action_right"
    };
}
