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
 *https://github.com/idunnololz/AnimatedExpandableListView
 *
 *
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

    public enum Sound {
        CLICK,
        RIGHT,
        WRONG
    }
    public static int TAB_COUNT = 3;
    public static int PROGRESS = 31;
    public static long SLEEP_TIME_2000 = 2000;    // Sleep for some time
    public static long SLEEP_TIME_20 = 20;    // Sleep for some time
    public static String PROGRESS_TEXT = "Progress.. ";
    public static String PROGRESS_PERCENT = "%";

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
