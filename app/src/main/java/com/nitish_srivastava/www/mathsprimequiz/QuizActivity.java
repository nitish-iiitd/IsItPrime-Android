package com.nitish_srivastava.www.mathsprimequiz;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;


public class QuizActivity extends AppCompatActivity {

    /**
     * Stores prime numbers till 1000
     */
    private final Integer primeNumbers[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        Button trueButton = (Button) findViewById(R.id.trueButton);
        trueButton.setVisibility(View.GONE);
        Button falseButton = (Button) findViewById(R.id.falseButton);
        falseButton.setVisibility(View.GONE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
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
    //********************* Added Variables and Methods  ***********************//


    /**
     * Generates a random number between 1 and 1000 (both inclusive)
     */
    private int randomNumber() {
        Random r = new Random();
        int max = 1000;
        int min = 1;
        return r.nextInt((max - min) + 1) + min;
    }

    /**
     * Displays next question by generating a random number.
     * Called when Start or Next button is clicked.
     */
    public void displayNextQuestion(View view) {
        TextView questionTextView = (TextView) findViewById(R.id.questionTextView);
        String question = "Is " + randomNumber() + " a prime number ?";
        questionTextView.setText(question);
        Button trueButton = (Button) findViewById(R.id.trueButton);
        trueButton.setClickable(true);
        trueButton.setTextColor(Color.WHITE);
        trueButton.setVisibility(View.VISIBLE);
        Button falseButton = (Button) findViewById(R.id.falseButton);
        falseButton.setClickable(true);
        falseButton.setTextColor(Color.WHITE);
        falseButton.setVisibility(View.VISIBLE);

        Button nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setText("Next");
        nextButton.setTextColor(Color.GRAY);
        nextButton.setClickable(false);
    }

    /**
     * Checks if the given statement is TRUE.
     * Called when TRUE button is clicked.
     */
    public void checkTrue(View view) {
        TextView questionTextView = (TextView) findViewById(R.id.questionTextView);
        String question = questionTextView.getText().toString();
        String questionSplit[] = question.split(" ");
        int number = Integer.parseInt(questionSplit[1]);
        boolean check = Arrays.asList(primeNumbers).contains(number);
        Button nextButton = (Button) findViewById(R.id.nextButton);
        if (check) {

            /* Creating the toast for CORRECT */
            Toast toast = Toast.makeText(this, Html.fromHtml("<font color='#57D8B8' ><b> Correct !</b></font>"), Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, toast.getXOffset(), 0);
            View toastView = toast.getView();
            toastView.setBackgroundResource(R.drawable.toast);
            toast.show();

            /* Setting the NEXT button to be clickable */
            nextButton.setClickable(true);
            nextButton.setTextColor(Color.BLACK);
            nextButton.setText("Next");
        } else {
            /* Creating the toast for INCORRECT */
            Toast toast = Toast.makeText(this, Html.fromHtml("<font color='#fc6c6c' > Incorrect !</font>"), Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, toast.getXOffset(), 0);
            View toastView = toast.getView();
            toastView.setBackgroundResource(R.drawable.toast);
            toast.show();

            /* Setting the NEXT button to be clickable */
            nextButton.setClickable(false);
            nextButton.setTextColor(Color.GRAY);
            nextButton.setText("Try Again");
        }
    }


    /**
     * Checks if the given statement is FALSE.
     * Called when FALSE button is clicked.
     */
    public void checkFalse(View view) {
        TextView questionTextView = (TextView) findViewById(R.id.questionTextView);
        String question = questionTextView.getText().toString();
        String questionSplit[] = question.split(" ");
        int number = Integer.parseInt(questionSplit[1]);
        boolean check = Arrays.asList(primeNumbers).contains(number);
        Button nextButton = (Button) findViewById(R.id.nextButton);
        if (check) {
            /* Creating the toast for INCORRECT */
            Toast toast = Toast.makeText(this, Html.fromHtml("<font color='#fc6c6c' > Incorrect !</font>"), Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, toast.getXOffset(), 0);
            View toastView = toast.getView();
            toastView.setBackgroundResource(R.drawable.toast);
            toast.show();

            /* Setting the NEXT button to be clickable */
            nextButton.setClickable(false);
            nextButton.setTextColor(Color.GRAY);
            nextButton.setText("Try Again");
        } else {
            /* Creating the toast for CORRECT */
            Toast toast = Toast.makeText(this, Html.fromHtml("<font color='#57D8B8' > Correct !</font>"), Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, toast.getXOffset(), 0);
            View toastView = toast.getView();
            toastView.setBackgroundResource(R.drawable.toast);
            toast.show();

            /* Setting the NEXT button to be clickable */
            nextButton.setClickable(true);
            nextButton.setTextColor(Color.BLACK);
            nextButton.setText("Next");

        }
    }

}
