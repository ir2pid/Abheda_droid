package com.noisyninja.abheda_droid.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.noisyninja.abheda_droid.R;
import com.noisyninja.abheda_droid.fragment.TopicsGridFrag;
import com.noisyninja.abheda_droid.util.Constants;
import com.noisyninja.abheda_droid.util.Utils;


public class MainActivity extends FragmentActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        String font = Utils.getPreference(context, Constants.FONT_KEY);
        if (font != null) {
            Constants.font = Constants.FONT.valueOf(font);
        } else {
            Constants.font = Constants.FONT.FONT_BENSENHANDWRITING;
        }
        TopicsGridFrag fragment = new TopicsGridFrag();

        this.getFragmentManager().beginTransaction()
                .add(R.id.activity_main, fragment).commit();

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

}