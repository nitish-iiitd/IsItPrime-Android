package com.nitish_srivastava.www.mathsprimequiz;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class HintActivity extends AppCompatActivity {

    static int hintDisplayed=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hint, menu);
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

    public void displayHint(View view)
    {
//        Intent nextScreen = new Intent(getApplicationContext(), QuizActivity.class);
//        nextScreen.putExtra("flagHint","1");

        hintDisplayed = 1;

        TextView hintTextView = (TextView) findViewById(R.id.hint);

        Bundle extras = getIntent().getExtras();
        String value="";
        if (extras != null) {
             value = extras.getString("num");
        }
        //String hint = ""
        hintTextView.setText(value);
    }

    public void backToQuiz(View view)
    {
        Intent nextScreen = new Intent(getApplicationContext(), QuizActivity.class);
        Log.d("hintac", "onbackclick");
        if(hintDisplayed==1)
        {
            nextScreen.putExtra("flagHint",hintDisplayed);
            Log.d("hintac", "onbackclick");
        }
        else
        {
            nextScreen.putExtra("flagHint",0);
        }
        setResult(RESULT_OK,nextScreen);
        finish();
    }

    @Override
    public void onBackPressed()
    {

    }

}
