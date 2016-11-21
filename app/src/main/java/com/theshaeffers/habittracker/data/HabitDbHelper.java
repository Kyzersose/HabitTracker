package com.theshaeffers.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.theshaeffers.habittracker.data.HabitContract.Habit;

/**
 * Created by shaefferm on 11/21/2016.
 */

public class HabitDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "habit.db";
    //CREATE TABLE habit (_id INTEGER PRIMARY KEY AUTOINCREMENT,
    // Habit TEXT NOT NULL, Day TEXT NOT NULL, Status INTEGER NOT NULL DEFAULT 0);
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DATABASE_NAME + " (" +
                    Habit._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    Habit.COLUMN_HABIT_NAME + " TEXT NOT NULL, " +
                    Habit.COLUMN_HABIT_DAY + " TEXT NOT NULL, " +
                    Habit.COLUMN_HABIT_STATUS + " INTEGER NOT NULL DEFAULT 0);";
    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + Habit.TABLE_NAME;

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //Code does not yet call for database upgrades
    }

}
