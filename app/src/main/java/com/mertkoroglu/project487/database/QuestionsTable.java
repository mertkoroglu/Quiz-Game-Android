package com.mertkoroglu.project487.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;

public class QuestionsTable {
    public static String TABLE_NAME = "questions";
    public static String FIELD_ID = "_id";
    public static String FIELD_COURSEID = "courseId";
    public static String FIELD_QUESTIONID = "questionId";
    public static String FIELD_QUESTION = "question";

    //public static String CREATE_TABLE_SQL="CREATE TABLE "+TABLE_NAME+" ( "+FIELD_ID+" number, "+FIELD_QUESTION+" text, "+ FIELD_COURSEID +" number, "+FIELD_CORRECT +" text)";
    public static String CREATE_TABLE_SQL="CREATE TABLE "+TABLE_NAME+" ( "+FIELD_ID+" number, "+FIELD_COURSEID+" number, "+ FIELD_QUESTIONID+" number, "+ FIELD_QUESTION +" text)";
    public static String DROP_TABLE_SQL = "DROP TABLE if exists "+TABLE_NAME;

    public static ArrayList<Questions> getAllQuestions(DatabaseHelper dbHelper){
        Questions anItem;
        ArrayList<Questions> data = new ArrayList<>();
        Cursor cursor = dbHelper.getAllRecords(TABLE_NAME, null);
        Log.d("DATABASE OPERATIONS", cursor.getCount()+",  "+cursor.getColumnCount());
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            int courseId = cursor.getInt(1);
            int questionId = cursor.getInt(2);
            String question = cursor.getString(3);

            anItem = new Questions(id, courseId, questionId, question);
            data.add(anItem);
        }
        Log.d("DATABASE OPERATIONS",data.toString());
        return data;
    }

    public static ArrayList<Questions> findQuestion(DatabaseHelper dbHelper, int key) {
        Questions anItem;
        ArrayList<Questions> data = new ArrayList<>();
        String where = FIELD_COURSEID +" like '%"+key+"%'";

        Cursor cursor = dbHelper.getSomeRecords(TABLE_NAME, null, where);
        Log.d("DATABASE OPERATIONS",  where+", "+cursor.getCount()+",  "+cursor.getColumnCount());
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            int courseId = cursor.getInt(1);
            int questionId = cursor.getInt(2);
            String question = cursor.getString(3);

            anItem = new Questions(id, courseId, questionId, question);
            data.add(anItem);
        }
        Log.d("DATABASE OPERATIONS",data.toString());
        return data;
    }

    public static boolean insert(DatabaseHelper dbHelper, int id, int courseId, int questionId, String question) {
        ContentValues contentValues = new ContentValues( );
        contentValues.put(FIELD_ID, id);
        contentValues.put(FIELD_COURSEID, courseId);
        contentValues.put(FIELD_QUESTIONID, questionId);
        contentValues.put(FIELD_QUESTION, question);

        boolean res = dbHelper.insert(TABLE_NAME,contentValues);
        return res;
    }

    public static boolean update(DatabaseHelper dbHelper,int id, int courseId, int questionId, String question) {
        //ContentValues  allows to define key value pairs.
        //The key represents the table column identifier and the value represents the content for the table record in this column.
        //ContentVales can be used for insert and update operations over table

        ContentValues contentValues = new ContentValues( );
        contentValues.put(FIELD_ID, id);
        contentValues.put(FIELD_COURSEID, courseId);
        contentValues.put(FIELD_QUESTIONID, questionId);
        contentValues.put(FIELD_QUESTION, question);

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
            ///CTIS255
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (1,255,1,'Who is making the Web standards?')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (2,255,2,'Choose the correct HTML element for the largest heading:')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (3,255,3,'Choose the correct HTML element to define important text')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (4,255,4,'What is the correct HTML for creating a hyperlink?')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (5,255,5,'Which character is used to indicate an end tag?')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (6,255,6,'Which of these elements are all <table> elements?')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (7,255,7,'How can you make a numbered list?')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (8,255,8,'How can you make a bulleted list?')");


            ///CTIS221
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (9,221,9,'Constructors are used to:')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (10,221,10,'An object that has more than one form is referred to as:')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (11,221,11, ' Pick the term that relates to polymorphism:')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (12,221,12,'The keyword which is used to access the method or member variables from the superclass:')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (13,221,13,'When sub class declares a method that has the same type of arguments as a method declared by one of its superclasses, it is termed as:')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (14,221,14,'What is a correct syntax to output \"Hello World\" in Java?')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (15,221,15,'Which data type is used to create a variable that should store text?')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (16,221,16,'How do you create a variable with the numeric value 5?')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (17,221,17,'How do you create a variable with the floating number 2.8?')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (18,221,18,'Which method can be used to find the length of a string?')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (19,221,19,'Which method can be used to return a string in upper case letters?')");


            ///CTIS151
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (20,151,20,'What is a correct syntax to output \"Hello World\" in C?')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (21,151,21, 'How do you insert COMMENTS in C code?')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (22,151,22,'How can you create a variable with the numeric value 5?')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (23,151,23,'How can you create a variable with the floating number 2.8?')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (24,151,24,'Which operator is used to add together two values?')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (25,151,25,'Which function is often used to output values and print text?')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (26,151,26,'Which format specifier is often used to print integers?')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (27,151,27,'Which operator can be used to compare two values?')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (28,151,28,'Which operator can be used to find the memory size (in bytes) of a data type or variable?')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (29,151,29,'Which keyword can be used to make a variable unchangeable/read-only?')");

            ///CTIS152
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (30,152,30,'Which of the following is a linear data structure?')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (31,152,31, 'How is the 2nd element in an array accessed based on pointer notation?')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (32,152,32,'Which of the following is not the type of queue?')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (33,152,33,'From following which is not the operation of data structure?')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (34,152,34,'What is the disadvantage of array data structure?')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (35,152,35,'How are String represented in memory in C?')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (36,152,36,'What function is used to append a character at the back of a string in C?')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (37,152,37,'Which one of the following is an application of queue data structure')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (38,152,38,'When a pop() operation is called on an empty queue, what is the condition called?')");
            add("INSERT INTO "+TABLE_NAME+" ( "+FIELD_ID+" , "+FIELD_COURSEID+" , "+ FIELD_QUESTIONID+" , "+ FIELD_QUESTION +" ) values (39,152,39,'Which of the following data structures can be used to implement queues?')");

        }
    };
}
