package com.noisyninja.abheda_droid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * Created by ir2pi on 11/30/2014.
 */
public class QuizFrag extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ios = inflater.inflate(R.layout.quiz_frag, container, false);
        //((TextView)ios.findViewById(R.id.textView)).setText("iOS");
        return ios;
    }

   /* public void onCreate(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {

        View quizFrag = inflater.inflate(R.layout.quiz_frag, container, false);

        final ProgressButton progressButton1 = (ProgressButton) quizFrag.findViewById(R.id.pin_progress_1);
        final ProgressButton progressButton2 = (ProgressButton) quizFrag.findViewById(R.id.pin_progress_2);
        final ProgressButton progressButton3 = (ProgressButton) quizFrag.findViewById(R.id.pin_progress_3);
        final ProgressButton progressButton4 = (ProgressButton) quizFrag.findViewById(R.id.pin_progress_4);

        final ProgressButton progressButton9 = (ProgressButton) quizFrag.findViewById(R.id.pin_progress_9);
        final ProgressButton progressButton10 = (ProgressButton) quizFrag.findViewById(R.id.pin_progress_10);

        final LinearLayout linearContainer = (LinearLayout) quizFrag.findViewById(R.id.container);

        *//**
         * Default implementation of the {@link ProgressButton}.
         * By default, the {@link ProgressButton} is not clickable, and is unpinned.
         *//*
        final ProgressButton progressButton5 = addProgressButton(linearContainer);

        *//**
         * A  {@link ProgressButton} that starts pinned, and is not clickable, so it
         * stays pinned.
         *
         * @see ProgressButton#setPinned(boolean)
         * @see View#setClickable(boolean)
         *//*
        final ProgressButton progressButton6 = addProgressButton(linearContainer);
        progressButton6.setPinned(true);

        *//**
         * A progress button that starts pinned, and is clickable, so it's
         * pinned state can be changed by the user.
         * @see ProgressButton#setPinned(boolean)
         * @see View#setClickable(boolean)
         *//*
        final ProgressButton progressButton7 = addProgressButton(linearContainer);
        progressButton7.setPinned(true);
        progressButton7.setClickable(true);
        progressButton7.setFocusable(true);

        *//**
         * An example of how to use style the button in code.
         * @see ProgressButton#setPinnedDrawable(android.graphics.drawable.Drawable)
         * @see ProgressButton#setUnpinnedDrawable(android.graphics.drawable.Drawable)
         * @see ProgressButton#setShadowDrawable(android.graphics.drawable.Drawable)
         * @see ProgressButton#setProgressColor(int)
         * @see ProgressButton#setCircleColor(int)
         *//*
        final ProgressButton progressButton8 = addProgressButton(linearContainer);
        progressButton8.setProgressColor(getResources().getColor(R.color.holo_green_light));
        progressButton8.setCircleColor(getResources().getColor(R.color.holo_green_dark));
        progressButton8.setClickable(true);
        progressButton8.setFocusable(true);

        CompoundButton.OnCheckedChangeListener checkedChangeListener =
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                        updatePinProgressContentDescription((ProgressButton) compoundButton);
                    }
                };

        progressButton1.setOnCheckedChangeListener(checkedChangeListener);
        progressButton2.setOnCheckedChangeListener(checkedChangeListener);
        progressButton3.setOnCheckedChangeListener(checkedChangeListener);
        progressButton4.setOnCheckedChangeListener(checkedChangeListener);
        progressButton5.setOnCheckedChangeListener(checkedChangeListener);
        progressButton6.setOnCheckedChangeListener(checkedChangeListener);
        progressButton7.setOnCheckedChangeListener(checkedChangeListener);
        progressButton8.setOnCheckedChangeListener(checkedChangeListener);

        SeekBar progressSeekBar = (SeekBar) quizFrag.findViewById(R.id.progress_seek_bar);
        progressSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateProgressButton(progressButton1, seekBar);
                updateProgressButton(progressButton2, seekBar);
                updateProgressButton(progressButton3, seekBar);
                updateProgressButton(progressButton4, seekBar);
                updateProgressButton(progressButton5, seekBar);
                updateProgressButton(progressButton6, seekBar);
                updateProgressButton(progressButton7, seekBar);
                updateProgressButton(progressButton8, seekBar);
                updateProgressButton(progressButton9, seekBar);
                updateProgressButton(progressButton10, seekBar);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        updateProgressButton(progressButton1, progressSeekBar);
        updateProgressButton(progressButton2, progressSeekBar);
        updateProgressButton(progressButton3, progressSeekBar);
        updateProgressButton(progressButton4, progressSeekBar);
        updateProgressButton(progressButton5, progressSeekBar);
        updateProgressButton(progressButton6, progressSeekBar);
        updateProgressButton(progressButton7, progressSeekBar);
        updateProgressButton(progressButton8, progressSeekBar);
        updateProgressButton(progressButton9, progressSeekBar);
        updateProgressButton(progressButton10, progressSeekBar);

        final ToggleButton toggleButton = (ToggleButton) quizFrag.findViewById(R.id.toggle_button);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Here, I explicitly call startAnimating
                    // If you want a  progress button that starts in an animating state,
                    // use the `animating` attribute via xml and set it to true
                    // You can control the animation speed, width of the strip that is displayed and
                    // animation delay
                    progressButton9.startAnimating();
                    progressButton10.startAnimating();
                } else {
                    progressButton9.stopAnimating();
                    progressButton10.stopAnimating();
                }
            }
        });
    }

    *//**
     * Helper method to update the progressButton's progress and it's
     * content description.
     *//*
    private void updateProgressButton(ProgressButton progressButton, SeekBar progressSeekBar) {
        progressButton.setProgress(progressSeekBar.getProgress());
        updatePinProgressContentDescription(progressButton);
    }

    *//**
     * Helper method to update the progressButton's content description.
     *//*
    private void updatePinProgressContentDescription(ProgressButton button) {
        int progress = button.getProgress();
        if (progress <= 0) {
            button.setContentDescription(getString(
                    button.isChecked() ? R.string.content_desc_pinned_not_downloaded
                            : R.string.content_desc_unpinned_not_downloaded));
        } else if (progress >= button.getMax()) {
            button.setContentDescription(getString(
                    button.isChecked() ? R.string.content_desc_pinned_downloaded
                            : R.string.content_desc_unpinned_downloaded));
        } else {
            button.setContentDescription(getString(
                    button.isChecked() ? R.string.content_desc_pinned_downloading
                            : R.string.content_desc_unpinned_downloading));
        }
    }

    *//**
     * Helper function that creates a new progress button, adds it to the given layout.
     * Returns a reference to the progress button for customization.
     *//*
    private ProgressButton addProgressButton(LinearLayout container) {
        final LinearLayout.LayoutParams layoutParams =
                new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f);
        final ProgressButton progressButton = new ProgressButton(getActivity());
        progressButton.setLayoutParams(layoutParams);
        container.addView(progressButton);
        return progressButton;
    }*/
}