package com.mertkoroglu.project487.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;

public class HighScoreTable {
    public static String TABLE_NAME = "highscores";
    public static String FIELD_ID = "_id";
    public static String FIELD_COURSEID = "courseId";
    public static String FIELD_HIGHSCORE = "highscore";

    public static String CREATE_TABLE_SQL = "CREATE TABLE " + TABLE_NAME + " ( " + FIELD_ID + " number, " + FIELD_COURSEID + " text, " + FIELD_HIGHSCORE + " number)";
    public static String DROP_TABLE_SQL = "DROP TABLE if exists " + TABLE_NAME;

    public static boolean update(DatabaseHelper dbHelper, int id, int highscore) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(FIELD_ID, id);
        contentValues.put(FIELD_HIGHSCORE, highscore);

        String where = FIELD_ID + " = " + id;
        boolean res = dbHelper.update(TABLE_NAME, contentValues, where);
        return res;
    }

    public static int findHighscore(DatabaseHelper dbHelper, String key) {
        String where = FIELD_COURSEID +" like '%"+key+"%'";
        int hs = 0;
        Cursor cursor = dbHelper.getSomeRecords(TABLE_NAME, null, where);
        Log.d("DATABASE OPERATIONS",  where+", "+cursor.getCount()+",  "+cursor.getColumnCount());

        while(cursor.moveToNext()){
            hs = cursor.getInt(2);

        }

        return hs;
    }

    public static ArrayList<String> INSERT_RECORD_SQL_LIST = new ArrayList<String>() {
        {
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_HIGHSCORE +" ) values (151,'CTIS151',0)");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_HIGHSCORE +" ) values (152,'CTIS152',0)");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_HIGHSCORE +" ) values (221,'CTIS221',0)");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_HIGHSCORE +" ) values (255,'CTIS255',0)");

        }
    };
}
