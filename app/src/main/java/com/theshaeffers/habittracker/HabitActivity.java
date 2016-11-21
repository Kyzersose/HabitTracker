package com.theshaeffers.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.theshaeffers.habittracker.data.HabitContract.Habit;
import com.theshaeffers.habittracker.data.HabitDbHelper;

public class HabitActivity extends AppCompatActivity {

    private HabitDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.habit_activity);
    }

    private void insertHabit() {
        // Creates a new DbHelper
        mDbHelper = new HabitDbHelper(this);

        //Creates a writable database obj
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(Habit.COLUMN_HABIT_NAME, "Walk the dog");
        values.put(Habit.COLUMN_HABIT_DAY, "Monday");
        values.put(Habit.COLUMN_HABIT_STATUS, 0);
    }

    public Cursor readAllHabits() {
        //Creates a new DbHelper
        mDbHelper = new HabitDbHelper(this);

        //Create a readable database obj
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        //Setup the columns needed in the database query
        String[] projection = {
                Habit.COLUMN_HABIT_NAME,
                Habit.COLUMN_HABIT_DAY,
                Habit.COLUMN_HABIT_STATUS};

        //Cursor used to show all contents of the Habit database
        Cursor cursor = db.query(
                Habit.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        return cursor;

    }
}
