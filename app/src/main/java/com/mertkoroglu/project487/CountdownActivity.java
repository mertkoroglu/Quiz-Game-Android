package com.mertkoroglu.project487;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class CountdownActivity extends AppCompatActivity {
    Intent intentGet, intentSend;
    TextView tvCountdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_countdown);
        intentGet = getIntent();
        long maxCounter = 3000;
        long diff = 1000;
        intentSend = new Intent(CountdownActivity.this, QuizActivity.class);
        tvCountdown = findViewById(R.id.tvCountdown);

        new CountDownTimer(maxCounter , diff) {

            public void onTick(long millisUntilFinished) {

                tvCountdown.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                Course course = intentGet.getParcelableExtra("Course");
                intentSend.putExtra("Course", course);
                startActivity(intentSend);
            }

        }.start();


    }


}