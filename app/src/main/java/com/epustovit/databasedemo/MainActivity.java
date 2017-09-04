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


//        try {
//
//            // create Database
//            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE,null);
//
//            // create a table for Database
//            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR, age INT(3))");
//
//            // insert some date into the table
//            myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Yevhenii', 31)");
//
//            myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Irina', 26)");
//
//            // get data out the database
//            Cursor c = myDatabase.rawQuery("SELECT * FROM users", null);
//
//            int nameIndex = c.getColumnIndex("name");
//            int ageIndex = c.getColumnIndex("age");
//
//            c.moveToFirst();
//            while (c != null){
//                Log.i("name", c.getString(nameIndex));
//                Log.i("age", Integer.toString(c.getInt(ageIndex)));
//
//                c.moveToNext();
//            }
//
//        }
//        catch (Exception e){
//
//            e.printStackTrace();
//        }

        try {
            SQLiteDatabase historicalEvents = this.openOrCreateDatabase("Events", MODE_PRIVATE, null);
            historicalEvents.execSQL("CREATE TABLE IF NOT EXISTS events (event VARCHAR, date INT(4))");
            historicalEvents.execSQL("INSERT INTO events (event, date) VALUES ('My birthday', 1986)");
            historicalEvents.execSQL("INSERT INTO events (event, date) VALUES ('Year when I go to school', 1993)");

            Cursor c = historicalEvents.rawQuery("SELECT * FROM events", null);

            int eventIndex = c.getColumnIndex("event");
            int dateIndex = c.getColumnIndex("date");

            c.moveToFirst();

            while (c != null){
                Log.i("event", c.getString(eventIndex));
                Log.i("date", Integer.toString (c.getInt(dateIndex)));

                c.moveToNext();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
