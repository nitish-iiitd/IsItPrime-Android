package com.nitish_srivastava.www.mathsprimequiz;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;


public class CheatActivity extends AppCompatActivity {

    static int cheatDisplayed=0;
    private final Integer primeNumbers[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cheat, menu);
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

    public void displayCheat(View view)
    {
//        Intent nextScreen = new Intent(getApplicationContext(), QuizActivity.class);
//        nextScreen.putExtra("flagHint","1");

        cheatDisplayed = 1;



        TextView cheatTextView = (TextView) findViewById(R.id.cheat);

        Bundle extras = getIntent().getExtras();
        String value="";
        if (extras != null) {
            value = extras.getString("num");
        }
        boolean check = Arrays.asList(primeNumbers).contains(Integer.parseInt(value));
        String cheatmsg="";
        if(check == true) {
             cheatmsg = value +" is prime.";
        }
        else
        {
            cheatmsg = value +" is not prime.";
        }
        cheatTextView.setText(cheatmsg);
    }

    public void backToQuiz(View view)
    {
        Intent nextScreen = new Intent(getApplicationContext(), QuizActivity.class);
        if(cheatDisplayed==1)
        {
            nextScreen.putExtra("flagCheat",cheatDisplayed);
        }
        else
        {
            nextScreen.putExtra("flagCheat",0);
        }
        setResult(RESULT_OK,nextScreen);
        finish();
    }

    @Override
    public void onBackPressed()
    {

    }

}
