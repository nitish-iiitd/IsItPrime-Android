package com.nitish_srivastava.www.mathsprimequiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Nitish on 12/8/2016.
 */
public class StartActivity extends AppCompatActivity {

    private final long startTime = 1 * 1000;
    private final long interval = 1 * 1000;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getSupportActionBar().hide();
        countDownTimer = new MyCountDownTimer(startTime, interval);
        countDownTimer.start();
    }


    //------------------- Timer class -------------------------------
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
    //---------------------------------------------------------------

}
