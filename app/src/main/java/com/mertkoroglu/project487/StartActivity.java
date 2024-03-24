package com.mertkoroglu.project487;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class StartActivity extends AppCompatActivity {
    Intent intentGet, intentSend;

    TextView start_lectureCode, start_lectureName, start_highscore, start_doubleClickText, start_details;
    ImageView start_lectureImg;
    Button start_buttonStart;
    LinearLayout start_doubleClickArea;
    FloatingActionButton floating_action_button;
    private GestureDetectorCompat gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_start);

        intentGet = getIntent();
        start_buttonStart = findViewById(R.id.start_buttonStart);
        Course course = intentGet.getParcelableExtra("Course");

        floating_action_button = findViewById(R.id.floating_action_button);

        start_lectureCode = findViewById(R.id.start_lectureCode);
        start_lectureCode.setText(course.getCourseName());

        start_lectureImg = findViewById(R.id.start_lectureImg);
        start_lectureImg.setImageResource(course.getImgId());

        start_lectureName = findViewById(R.id.start_lectureName);
        start_lectureName.setText(course.getDescription());

        start_highscore = findViewById(R.id.start_highscore);
        start_highscore.setText("Highscore = " + course.getHighscore());

        start_doubleClickArea = findViewById(R.id.start_doubleClickArea);
        start_doubleClickText = findViewById(R.id.start_doubleClickText);

        start_details = findViewById(R.id.start_details);
        start_details.setText(course.getDetails());

        gestureDetector = new GestureDetectorCompat(this, new CustomGestureListener());


        start_buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentSend = new Intent(StartActivity.this, CountdownActivity.class);
                intentSend.putExtra("Course", course);
                startActivity(intentSend);
            }
        });

        floating_action_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentGet = new Intent(StartActivity.this, MainActivity.class);
                intentGet.putExtra("isJsonRead", true);
                startActivity(intentGet);
            }
        });


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class CustomGestureListener extends  GestureDetector.SimpleOnGestureListener{

        @Override
        public boolean onDoubleTap(@NonNull MotionEvent e) {
            if(start_details.getVisibility() == View.INVISIBLE){
                start_details.setVisibility(View.VISIBLE);
                start_doubleClickText.setText("Double click for less details");
            }else{
                start_details.setVisibility(View.INVISIBLE);
                start_doubleClickText.setText("Double click for details");
            }

            return true;
        }
    }
}