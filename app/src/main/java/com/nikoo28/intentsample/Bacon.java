package com.nikoo28.intentsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class Bacon extends ActionBarActivity {

    private static TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bacon);

        mTextView = (TextView) findViewById(R.id.baconTextView);
        Bundle appleData = getIntent().getExtras();
        Log.d("BACON", "appleData = " + appleData);
        if (appleData == null)
            mTextView.setText("I got Nothing");
        else {
            String appleMessage = appleData.getString("appleMessage");
            if (appleMessage.isEmpty())
                mTextView.setText("No honey");
            else
                mTextView.setText(appleMessage);
        }

    }

    public void startApple(View view) {
        Intent mIntent = new Intent(this, Apples.class);
        startActivity(mIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bacon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
