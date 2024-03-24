package com.mertkoroglu.project487;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.mertkoroglu.project487.database.Answers;
import com.mertkoroglu.project487.database.AnswersTable;
import com.mertkoroglu.project487.database.DatabaseHelper;
import com.mertkoroglu.project487.database.Questions;
import com.mertkoroglu.project487.database.QuestionsTable;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {
    ArrayList<Questions> questionList=new ArrayList<>();
    ArrayList<Answers> answerList=new ArrayList<>();
    int currentQuestion = 0;
    Course course;
    DatabaseHelper dbHelper;
    Intent intentGet, intentSend;
    TextView quiz_lectureName, quiz_timer, quiz_score, quiz_highscore,
            question,answerA,answerB,answerC,answerD;
    int score;

    MediaPlayer mpR, mpW;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_quiz);
        dbHelper = new DatabaseHelper(this);
        intentGet = getIntent();
        intentSend = new Intent(QuizActivity.this, EndActivity.class);
        mpR = MediaPlayer.create(this, R.raw.right);
        mpW = MediaPlayer.create(this, R.raw.wrong);
        score = 0;

        quiz_lectureName = findViewById(R.id.quiz_lectureName);
        quiz_timer = findViewById(R.id.quiz_timer);
        quiz_score = findViewById(R.id.quiz_score);
        quiz_highscore = findViewById(R.id.quiz_highscore);
        question = findViewById(R.id.question);
        answerA = findViewById(R.id.answerA);
        answerB = findViewById(R.id.answerB);
        answerC = findViewById(R.id.answerC);
        answerD = findViewById(R.id.answerD);

        course = intentGet.getParcelableExtra("Course");
        questionList = QuestionsTable.findQuestion(dbHelper, course.getId());

        displayQuestions(currentQuestion);

        answerA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(answerList.get(0).getCorrect()==1){
                    score ++;
                    PlayRightSound(mpR, QuizActivity.this);
                } else{PlayWrongSound(mpW, QuizActivity.this);}
                currentQuestion++;
                displayQuestions(currentQuestion);
            }
        });
        answerB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(answerList.get(1).getCorrect()==1){
                    score ++;
                    PlayRightSound(mpR, QuizActivity.this);
                }else{PlayWrongSound(mpW, QuizActivity.this);}
                currentQuestion++;
                displayQuestions(currentQuestion);

            }
        });
        answerC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(answerList.get(2).getCorrect()==1){
                    score ++;
                    PlayRightSound(mpR, QuizActivity.this);
                }else{PlayWrongSound(mpW, QuizActivity.this);}
                currentQuestion++;
                displayQuestions(currentQuestion);
            }
        });
        answerD.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(answerList.get(3).getCorrect()==1){
                    score ++;
                    PlayRightSound(mpR, QuizActivity.this);
                }else{PlayWrongSound(mpW, QuizActivity.this);}
                currentQuestion++;
                displayQuestions(currentQuestion);
            }
        });



        long maxCounter = 15000;
        long diff = 1000;

        new CountDownTimer(maxCounter , diff ) {
            public void onTick(long millisUntilFinished) {
                quiz_timer.setText("" + millisUntilFinished / 1000);
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                intentSend.putExtra("Course", course);
                intentSend.putExtra("Score", score);
                startActivity(intentSend);
                //TextField.setText("done!");
            }

        }.start();
    }
    public void displayQuestions(int current){
        answerList = AnswersTable.findAnswers(dbHelper,questionList.get(current).getQuestionId());

        quiz_highscore.setText("Highscore: " + course.getHighscore());
        quiz_lectureName.setText(course.getCourseName());
        quiz_score.setText("Score: " + score);

        question.setText(questionList.get(current).getQuestion());
        answerA.setText(answerList.get(0).getDescription());
        answerB.setText(answerList.get(1).getDescription());
        answerC.setText(answerList.get(2).getDescription());
        answerD.setText(answerList.get(3).getDescription());
    }

    public void PlayRightSound(MediaPlayer mp, Context cont){
        try {
            if (mp.isPlaying()) {
                mp.stop();
                mp.release();
                mp = MediaPlayer.create(cont, R.raw.right);
            } mp.start();
        } catch(Exception e) { e.printStackTrace(); }
    }
    public void PlayWrongSound(MediaPlayer mp, Context cont){
        try {
            if (mp.isPlaying()) {
                mp.stop();
                mp.release();
                mp = MediaPlayer.create(cont, R.raw.wrong);
            } mp.start();
        } catch(Exception e) { e.printStackTrace(); }
    }
}