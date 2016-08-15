package com.nitish_srivastava.www.mathsprimequiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Nitish on 12/8/2016.
 */
public class StartActivity extends AppCompatActivity {

    /*
    * Waits for 1 second and then goes to next screen.
    * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        long startTime = 1000;
        long interval = 1000;
        CountDownTimer countDownTimer = new MyCountDownTimer(startTime, interval);
        countDownTimer.start();
    }


    /**
     * Extends CountDownTimer and starts next screen by overriding onFinish()
     */
    public class MyCountDownTimer extends CountDownTimer {
        public MyCountDownTimer(long startTime, long interval) {
            super(startTime, interval);
        }

        @Override
        public void onFinish() {
            Intent nextScreen = new Intent(getApplicationContext(), QuizActivity.class);
            startActivity(nextScreen);
        }

        @Override
        public void onTick(long millisUntilFinished) {

        }
    }

}
