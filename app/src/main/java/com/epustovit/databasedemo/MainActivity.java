package com.epustovit.databasedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {

            // create Database
            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE,null);

            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS newUsers (name VARCHAR, age INTEGER(3), id INTEGER PRIMARY KEY)");

            // create a table for Database
           // myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR, age INT(3))");

            // insert some date into the table
           // myDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Yevhenii', 31)");
           // myDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Irina', 26)");
           // myDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Nastya', 27)");
//            myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Roman', 27)");

            // deleting from database
            myDatabase.execSQL("DELETE FROM newUsers WHERE id = 4");

            // change in database
            //myDatabase.execSQL("UPDATE users SET age = 20 WHERE name = 'Irina'");

            // get data out the database
            Cursor c = myDatabase.rawQuery("SELECT * FROM newUsers", null);

            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");
            int idIndex = c.getColumnIndex("id");

            c.moveToFirst();
            while (c != null){
                Log.i("UsersResult - name", c.getString(nameIndex));
                Log.i("UsersResult - age", Integer.toString(c.getInt(ageIndex)));
                Log.i("UsersResult - id", Integer.toString(c.getInt(idIndex)));

                c.moveToNext();
            }

        }
        catch (Exception e){

            e.printStackTrace();
        }

//        try {
//            SQLiteDatabase historicalEvents = this.openOrCreateDatabase("Events", MODE_PRIVATE, null);
//            historicalEvents.execSQL("CREATE TABLE IF NOT EXISTS events (event VARCHAR, date INT(4))");
//            historicalEvents.execSQL("INSERT INTO events (event, date) VALUES ('My birthday', 1986)");
//            historicalEvents.execSQL("INSERT INTO events (event, date) VALUES ('Year when I go to school', 1993)");
//
//            Cursor c = historicalEvents.rawQuery("SELECT * FROM events", null);
//
//            int eventIndex = c.getColumnIndex("event");
//            int dateIndex = c.getColumnIndex("date");
//
//            c.moveToFirst();
//
//            while (c != null){
//                Log.i("event", c.getString(eventIndex));
//                Log.i("date", Integer.toString (c.getInt(dateIndex)));
//
//                c.moveToNext();
//            }
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
    }
}
