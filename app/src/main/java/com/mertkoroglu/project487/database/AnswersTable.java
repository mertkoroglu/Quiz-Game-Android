package com.mertkoroglu.project487.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;

public class AnswersTable {
    public static String TABLE_NAME = "answers";
    public static String FIELD_ID = "_id";
    public static String FIELD_COURSEID = "courseId";
    public static String FIELD_QUESTIONID = "questionId";
    public static String FIELD_CORRECT = "correct";
    public static String FIELD_DESCRIPTION = "description";

    public static String CREATE_TABLE_SQL="CREATE TABLE "+TABLE_NAME+" ( "+FIELD_ID+" number, "+FIELD_COURSEID+" number, "+ FIELD_QUESTIONID+" number, "+ FIELD_CORRECT+" number, "+FIELD_DESCRIPTION +" text)";
    public static String DROP_TABLE_SQL = "DROP TABLE if exists "+TABLE_NAME;

    public static ArrayList<Answers> getAllQuestions(DatabaseHelper dbHelper){
        Answers anItem;
        ArrayList<Answers> data = new ArrayList<>();
        Cursor cursor = dbHelper.getAllRecords(TABLE_NAME, null);
        Log.d("DATABASE OPERATIONS", cursor.getCount()+",  "+cursor.getColumnCount());
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            int courseId = cursor.getInt(1);
            int questionId = cursor.getInt(2);
            int correct = cursor.getInt(3);
            String description = cursor.getString(4);
            anItem = new Answers(id, courseId, questionId, correct, description);
            data.add(anItem);
        }
        Log.d("DATABASE OPERATIONS",data.toString());
        return data;
    }

    public static ArrayList<Answers> findAnswers(DatabaseHelper dbHelper, int key) {
        Answers anItem;
        ArrayList<Answers> data = new ArrayList<>();
        String where = FIELD_QUESTIONID +" like '%"+key+"%'";

        Cursor cursor = dbHelper.getSomeRecords(TABLE_NAME, null, where);
        Log.d("DATABASE OPERATIONS",  where+", "+cursor.getCount()+",  "+cursor.getColumnCount());
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            int courseId = cursor.getInt(1);
            int questionId = cursor.getInt(2);
            int correct = cursor.getInt(3);
            String description = cursor.getString(4);
            anItem = new Answers(id, courseId, questionId, correct, description);
            data.add(anItem);
        }
        Log.d("DATABASE OPERATIONS",data.toString());
        return data;
    }

    public static boolean insert(DatabaseHelper dbHelper, int id, int courseId, int questionId, int correct, String description) {
        ContentValues contentValues = new ContentValues( );
        contentValues.put(FIELD_ID, id);
        contentValues.put(FIELD_COURSEID, courseId);
        contentValues.put(FIELD_QUESTIONID, questionId);
        contentValues.put(FIELD_CORRECT, correct);
        contentValues.put(FIELD_DESCRIPTION, description);


        boolean res = dbHelper.insert(TABLE_NAME,contentValues);
        return res;
    }

    public static boolean update(DatabaseHelper dbHelper,int id, int courseId, int questionId, int correct, String description) {
        //ContentValues  allows to define key value pairs.
        //The key represents the table column identifier and the value represents the content for the table record in this column.
        //ContentVales can be used for insert and update operations over table

        ContentValues contentValues = new ContentValues( );
        contentValues.put(FIELD_ID, id);
        contentValues.put(FIELD_COURSEID, courseId);
        contentValues.put(FIELD_QUESTIONID, questionId);
        contentValues.put(FIELD_CORRECT, correct);
        contentValues.put(FIELD_DESCRIPTION, description);

        String where = FIELD_ID +" = "+id;
        boolean res = dbHelper.update(TABLE_NAME,contentValues,where );
        return res;
    }

    public static boolean delete(  DatabaseHelper dbHelper, String id){
        Log.d("DATABASE OPERATIONS", "DELETE DONE");
        String where = FIELD_ID + " = "+id;
        boolean res =  dbHelper.delete(TABLE_NAME, where);
        return  res;
    }

    public static ArrayList<String> INSERT_RECORD_SQL_LIST = new ArrayList<String>(){
        {

            //CTIS 255
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (1,255,1,1,'The World Wide Web Consortium')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (2,255,1,0,'Mozilla')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (3,255,1,0,'Google')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (4,255,1,0,'Microsoft')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (5,255,2,0,'<heading>')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (6,255,2,1,'<h1>')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (7,255,2,0,'<h6>')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (8,255,2,0,'<head>')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (9,255,3,0,'<important>')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (10,255,3,0,'<i>')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (11,255,3,1,'<strong>')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (12,255,3,0,'<b>')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (13,255,4,0,'<a>http://www.w3schools.com</a>')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (14,255,4,0,'<a name=\"http://www.w3schools.com\">W3Schools.com</a>')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (15,255,4,0,'<a url=\"http://www.w3schools.com\">W3Schools.com</a>')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (16,255,4,1,'<a href=\"http://www.w3schools.com\">W3Schools</a> ')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (17,255,5,1,'/')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (18,255,5,0,'<')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (19,255,5,0,'*')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (20,255,5,0,'.')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (21,255,6,0,'<thead><body><tr>')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (22,255,6,0,'<table><head><tfoot>')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (23,255,6,0,'<table><tr><tt>')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (24,255,6,1,'<table><tr><td>')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (25,255,7,0,'<ul>')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (26,255,7,1,'<ol>')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (27,255,7,0,'<dl>')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (28,255,7,0,'<list>')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (29,255,8,0,'<list>')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (30,255,8,1,'<ul>')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (31,255,8,0,'<dl>')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (32,255,8,0,'<ol>')");

            ///CTIS221
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (41,221,9,0,'To build a user interface.')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (42,221,9,0,'Free memory.')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (43,221,9,1,'Initialize a newly created object.')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (44,221,9,0,'To create a sub-class.')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (45,221,10,0,'Inheritance')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (46,221,10,0,'Interface')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (47,221,10,0,'Abstract class')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (48,221,10,1,'Polymorphism')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (49,221,11,1,'Dynamic binding')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (50,221,11,0,'Dynamic allocation')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (51,221,11,0,'Static typing')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (52,221,11,0,'Static allocation')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (53,221,12,1,'Super')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (54,221,12,0,'Using')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (55,221,12,0,'Is_a')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (56,221,12,0,'Has_a')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (57,221,13,1,'Method overriding')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (58,221,13,0,'Method overloading')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (59,221,13,0,'Operator overloading')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (60,221,13,0,'Operator overriding')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (61,221,14,0,'echo(\"Hello World\"); ')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (62,221,14,0,'print (\"Hello World\");')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (63,221,14,1,'System.out.println(\"Hello World\");')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (64,221,14,0,'Console.WriteLine(\"Hello World\");')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (65,221,15,0,'Txt')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (66,221,15,0,'myString')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (67,221,15,0,'string')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (68,221,15,1,'String')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (69,221,16,0,'x = 5;')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (70,221,16,1,'int x = 5;')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (71,221,16,0,'num x = 5')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (72,221,16,0,'float x = 5;')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (73,221,17,0,'byte x = 2.8f')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (74,221,17,1,'float x = 2.8f; ')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (75,221,17,0,'int x = 2.8f;')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (76,221,17,0,'x = 2.8f;')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (77,221,18,1,'length()')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (78,221,18,0,'len()')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (79,221,18,0,'getSize()')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (80,221,18,0,'getLength()')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (81,221,19,0,'tuc()')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (82,221,19,0,'touppercase()')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (83,221,19,0,'upperCase()')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (84,221,19,1,'toUpperCase()')");

            ///CTIS 151
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (85,151,20,0,'cout << \"Hello World\";')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (86,151,20,0,'System.out.printline(\"Hello World\");')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (87,151,20,0,'Console.WriteLine(\"Hello World\");')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (88,151,20,1,'printf(\"Hello World\"); ')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (89,151,21,0,'-- This is a comment')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (90,151,21,1,'// This is a comment  ')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (91,151,21,0,'# This is a comment\n')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (92,151,21,0,'* This is a comment')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (93,151,22,0,'val num = 5;  ')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (94,151,22,0,'num = 5 int;')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (95,151,22,0,'num = 5;')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (96,151,22,1,'int num = 5;  ')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (97,151,23,0,'val num = 2.8;')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (98,151,23,0,'num = 2.8 double;')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (99,151,23,0,'num = 2.8 float;')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (100,151,23,1,'float num = 2.8;  ')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (101,151,24,0,'The & sign ')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (102,151,24,1,'The + sign ')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (103,151,24,0,'The ADD keyword')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (104,151,24,0,'The * sign')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (105,151,25,0,'printword()')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (106,151,25,0,'write()')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (107,151,25,0,'output()')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (108,151,25,1,'printf() ')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (109,151,26,0,'%s')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (110,151,26,0,'%c')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (111,151,26,0,'%f')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (112,151,26,1,'%d')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (113,151,27,0,'<>')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (114,151,27,0,'=')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (115,151,27,0,'><')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (116,151,27,1,'==')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (117,151,28,0,'The sizer property')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (118,151,28,0,'The length property')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (119,151,28,0,'The len property')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (120,151,28,1,'The sizeof property')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (121,151,29,0,'readonly')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (122,151,29,0,'final')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (123,151,29,1,'const')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (124,151,29,0,'constant')");



            //add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (39,152,39,'Which of the following data structures can be used to implement queues?')");


            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (125,152,30,1,'Array')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (126,152,30,0,'AVL Trees')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (127,152,30,0,'Binary Trees')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (128,152,30,0,'Graphs ')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (129,152,31,0,'*a + 2')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (130,152,31,1,'*(a + 2)')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (131,152,31,0,'*(*a + 2)')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (132,152,31,0,'&(a + 2)')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (133,152,32,0,'Priority Queue')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (134,152,32,1,'Single Ended Queue')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (135,152,32,0,'Circular Queue')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (136,152,32,0,'Ordinary Queue')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (137,152,33,1,'Operations that manipulate data in some way')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (138,152,33,0,'Operations that perform a calculation')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (139,152,33,0,'Operations that check for syntax errors')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (140,152,33,0,'Operations that monitor an object for the occurrence of a controlling event')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (141,152,34,1,'The amount of memory to be allocated should be known beforehand')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (142,152,34,0,'Elements of an array can be accessed in constant time')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (143,152,34,0,'Elements are stored in contiguous memory blocks')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (144,152,34,0,'Multiple other data structures can be implemented using arrays')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (145,152,35,1,'An array of characters')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (146,152,35,0,'The object of some class')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (147,152,35,0,'Same as other primitive data types')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (148,152,35,0,'Linked List of characters')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (149,152,36,1,'push_back()')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (150,152,36,0,'append()')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (151,152,36,0,'push()')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (152,152,36,0,'insert()')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (153,152,37,0,'When a resource is shared among multiple consumers')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (154,152,37,0,'When data is transferred asynchronously')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (155,152,37,0,'Load balancing')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (156,152,37,1,'All of the above')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (157,152,38,0,'Overflow')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (158,152,38,1,'Underflow')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (159,152,38,0,'Syntax Error')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (160,152,38,0,'Garbage Value')");

            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (161,152,39,0,'Stack')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (162,152,39,0,'Arrays')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (163,152,39,0,'Linked List')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_CORRECT+" , "+FIELD_DESCRIPTION +" ) values (164,152,39,1,'All of the above')");




        }
    };

}
