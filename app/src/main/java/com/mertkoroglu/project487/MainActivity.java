package com.mertkoroglu.project487;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.mertkoroglu.project487.database.DatabaseHelper;
import com.mertkoroglu.project487.database.HighScoreTable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<Course>> {
    public static DatabaseHelper dbHelper;
    RecyclerView.LayoutManager layoutManager;
    private RecyclerView rv_courses;
    private CustomRecyclerViewAdapter adapter;
    Intent intent;
    boolean isJsonRead;

    LoaderManager loaderManager=null;
    private static int TASK_ID = 100;
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        intent = getIntent();
        isJsonRead = intent.getBooleanExtra("isJsonRead", false);
        rv_courses = findViewById(R.id.rv_courses);
        mProgressBar = findViewById(R.id.progressBar);

        if(isJsonRead){
            mProgressBar.setVisibility(View.INVISIBLE);
        }

        dbHelper = new DatabaseHelper(this);

        layoutManager = new GridLayoutManager(this, 2);

        rv_courses.setLayoutManager(layoutManager);
        adapter = new CustomRecyclerViewAdapter(this, CourseSys.mArrayList);
        rv_courses.setAdapter(adapter);

        if(!isJsonRead) {
            CourseSys.mArrayList = new ArrayList<Course>();
            if (loaderManager == null) {
                loaderManager = LoaderManager.getInstance(MainActivity.this);
                loaderManager.initLoader(TASK_ID, null, MainActivity.this).forceLoad();
            } else {
                loaderManager.restartLoader(TASK_ID, null, MainActivity.this).forceLoad();
                Log.d("ASYNTASKLODER", "Loader restarted");
            }
            Log.d("ASYNTASKLODER", "After initLoader PROCESS NOT FINISHED, BUT THE NEXT STATEMENT IS EXECUTED");
        }


    }


    @NonNull
    @Override
    public Loader<ArrayList<Course>> onCreateLoader(int id, @Nullable Bundle args) {
        Log.d("ASYNTASKLODER", "onCreateLoader");
        return new FetchData(this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList<Course>> loader, ArrayList<Course> data) {
        Log.d("ASYNTASKLODER", "onLoadFinished");
        CourseSys.mArrayList = data;
        adapter = new CustomRecyclerViewAdapter(this, CourseSys.mArrayList);
        rv_courses.setAdapter(adapter);
        Log.d("ASYNTASKLODER", "onLoadFinished, data array"+data.toString());
        Log.d("ASYNTASKLODER", "onLoadFinished, array"+CourseSys.mArrayList.toString());
        mProgressBar.setVisibility(View.INVISIBLE);
        isJsonRead = true;
        loader.stopLoading();
    }

    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList<Course>> loader) {
        Log.d("ASYNTASKLODER", "onLoaderReset");
        adapter = new CustomRecyclerViewAdapter(this, CourseSys.mArrayList);
        rv_courses.setAdapter(adapter);
        mProgressBar.setVisibility(View.INVISIBLE);
        isJsonRead = true;
    }

    private static class FetchData extends AsyncTaskLoader<ArrayList<Course>>{
        Context context;

        public FetchData(Context context) {
            super(context);
            this.context = context;
            Log.d("ASYNTASKLODER", "FetchData");
        }

        @Nullable
        @Override
        public ArrayList<Course> loadInBackground() {
            Log.d("ASYNTASKLODER", "loadInBackground");
            ArrayList<Course> tempList = new ArrayList<Course>();

            String jsonStr = loadFileFromAssets("courses.json");
            Log.d("ASYNTASKLODER", "jsonStr");


            if (jsonStr != null) {
                try {
                    JSONObject courseJSONObject = new JSONObject(jsonStr);
                    // Getting JSON Array
                    JSONArray courses = courseJSONObject.getJSONArray(CourseSys.TAG_COURSES);
                    Log.d("ASYNTASKLODER", courses.toString());

                    // looping through all courses
                    for (int i = 0; i < courses.length(); i++) {
                        Log.d("ASYNTASKLODER", "course object : "+i+" is read");

                        JSONObject jsonObj = courses.getJSONObject(i);

                        Thread.sleep(1000);//This is here only to simulate parsing json takes time so that ProgressBar execution can be displayed better

                        String name = jsonObj.getString(CourseSys.TAG_NAME);
                        String description = jsonObj.getString(CourseSys.TAG_DESCRIPTION);
                        String details = jsonObj.getString(CourseSys.TAG_DETAILS);
                        int id = jsonObj.getInt(CourseSys.TAG_ID);

                        Course course = null;

                        switch(id){
                            case 151:
                                course = new Course(name, description, details, R.drawable.ctis151, HighScoreTable.findHighscore(dbHelper, "CTIS151"), id);
                                break;
                            case 152:
                                course = new Course(name, description, details, R.drawable.ctis151, HighScoreTable.findHighscore(dbHelper, "CTIS152"), id);
                                break;
                            case 255:
                                course = new Course(name, description, details, R.drawable.ctis255, HighScoreTable.findHighscore(dbHelper, "CTIS255"), id);
                                break;
                            case 221:
                                course = new Course(name, description, details, R.drawable.ctis221, HighScoreTable.findHighscore(dbHelper, "CTIS221"), id);
                                break;
                        }

                        tempList.add(course);
                    }
                } catch (JSONException ee) {
                    ee.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Log.d("ASYNTASKLODER", "ArrayList: "+tempList.toString());
            return tempList;
        }

        private String loadFileFromAssets(String fileName) {
            String fileContent = null;
            try {
                InputStream is = context.getAssets().open(fileName);

                int size = is.available();
                byte[] buffer = new byte[size];

                is.read(buffer);
                is.close();

                fileContent = new String(buffer, "UTF-8");

            } catch (IOException ex) {
                ex.printStackTrace();
                return null;
            }
            return fileContent;
        }
    }
}