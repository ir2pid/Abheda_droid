package com.noisyninja.abheda_droid.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.noisyninja.abheda_droid.R;
import com.noisyninja.abheda_droid.fragment.CourseTree;
import com.noisyninja.abheda_droid.fragment.InfoFrag;
import com.noisyninja.abheda_droid.fragment.MotherModuleFrag;
import com.noisyninja.abheda_droid.fragment.TopicsGridFrag;
import com.noisyninja.abheda_droid.util.Constants;
import com.noisyninja.abheda_droid.util.Utils;

import java.util.Locale;


public class MainActivity extends ActionBarActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;
    Context context;
    InfoFrag infoFrag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(1);


        /*Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", "ir2pid@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "schema");
        emailIntent.putExtra(Intent.EXTRA_TEXT, DataStore.getInstance(context).getMockTopics().toString()+"\n--------\n\n\n\n-------\n");
        startActivity(Intent.createChooser(emailIntent, "Send email..."));*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings: {
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                Utils.startActivity(this, Settings.class);
                return true;
            }
            case R.id.action_about: {
                Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
                Utils.startActivity(this, About.class);
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void switchTab(int tabId) {

        mViewPager.setCurrentItem(tabId, true);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                if(mViewPager.getCurrentItem()!=1)
                {
                    mViewPager.setCurrentItem(1, true);
                    return true;
                }
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch(position)
            {
                case 0: return new CourseTree();
                case 1: return new TopicsGridFrag();
                case 2: return  new InfoFrag();
                default: return new MotherModuleFrag();
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return Constants.TAB_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.lessons).toUpperCase(l);
                case 1:
                    return getString(R.string.info).toUpperCase(l);
                case 2:
                    return getString(R.string.quiz).toUpperCase(l);
            }
            return null;
        }
    }


}