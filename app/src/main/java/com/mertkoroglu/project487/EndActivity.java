package com.mertkoroglu.project487;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mertkoroglu.project487.database.DatabaseHelper;
import com.mertkoroglu.project487.database.HighScoreTable;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import nl.dionsegijn.konfetti.core.Angle;
import nl.dionsegijn.konfetti.core.Party;
import nl.dionsegijn.konfetti.core.PartyFactory;
import nl.dionsegijn.konfetti.core.Position;
import nl.dionsegijn.konfetti.core.Spread;
import nl.dionsegijn.konfetti.core.emitter.Emitter;
import nl.dionsegijn.konfetti.core.emitter.EmitterConfig;
import nl.dionsegijn.konfetti.core.models.Shape;
import nl.dionsegijn.konfetti.core.models.Size;
import nl.dionsegijn.konfetti.xml.KonfettiView;

public class EndActivity extends AppCompatActivity {
    Intent intentGet;
    DatabaseHelper dbHelper;
    TextView end_score, end_highscore, end_lectureName;
    Button end_button;
    private KonfettiView konfettiView = null;
    private Shape.DrawableShape drawableShape = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_end);

        dbHelper = new DatabaseHelper(this);

        end_score = findViewById(R.id.end_score);
        end_highscore = findViewById(R.id.end_highscore);
        end_button = findViewById(R.id.end_button);
        end_lectureName = findViewById(R.id.end_lectureName);

        final Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_heart);
        drawableShape = new Shape.DrawableShape(drawable, true);

        intentGet = getIntent();
        Course course = intentGet.getParcelableExtra("Course");
        int score = intentGet.getIntExtra("Score", 0);

        if(score > course.getHighscore()){
            int index = findCourse(course);
            CourseSys.mArrayList.get(index).setHighscore(score);
            course.setHighscore(score);

            HighScoreTable.update(dbHelper, course.getId(), score);

            konfettiView = findViewById(R.id.konfettiView);
            EmitterConfig emitterConfig = new Emitter(5L, TimeUnit.SECONDS).perSecond(50);

            createKonfetti(emitterConfig);
            parade();


        }

        end_lectureName.setText("" + course.getCourseName());
        end_highscore.setText("" + course.getHighscore());
        end_score.setText("" + score);

        end_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent;
                returnIntent = new Intent(EndActivity.this, MainActivity.class);
                returnIntent.putExtra("isJsonRead", true);
                startActivity(returnIntent);
            }
        });
    }

    public void createKonfetti(EmitterConfig emitterConfig){
        Party party = new PartyFactory(emitterConfig)
                .angle(270)
                .spread(90)
                .setSpeedBetween(1f, 5f)
                .timeToLive(2000L)
                .shapes(new Shape.Rectangle(0.2f), drawableShape)
                .sizes(new Size(12, 5f, 0.2f))
                .position(0.0, 0.0, 1.0, 0.0)
                .build();
        konfettiView.setOnClickListener(view ->
                konfettiView.start(party)
        );
    }

    public void parade(){
        EmitterConfig emitterConfig = new Emitter(5, TimeUnit.SECONDS).perSecond(30);
        konfettiView.start(
                new PartyFactory(emitterConfig)
                        .angle(Angle.RIGHT - 45)
                        .spread(Spread.SMALL)
                        .shapes(Arrays.asList(Shape.Square.INSTANCE, Shape.Circle.INSTANCE, drawableShape))
                        .colors(Arrays.asList(0xfce18a, 0xff726d, 0xf4306d, 0xb48def))
                        .setSpeedBetween(10f, 30f)
                        .position(new Position.Relative(0.0, 0.5))
                        .build(),
                new PartyFactory(emitterConfig)
                        .angle(Angle.LEFT + 45)
                        .spread(Spread.SMALL)
                        .shapes(Arrays.asList(Shape.Square.INSTANCE, Shape.Circle.INSTANCE, drawableShape))
                        .colors(Arrays.asList(0xfce18a, 0xff726d, 0xf4306d, 0xb48def))
                        .setSpeedBetween(10f, 30f)
                        .position(new Position.Relative(1.0, 0.5))
                        .build()
        );
    }

    public int findCourse(Course course){
        for (int i = 0; i < CourseSys.mArrayList.size(); i++)
            if (CourseSys.mArrayList.get(i).getId() == course.getId())
                return i;
        return -1;
    }


}