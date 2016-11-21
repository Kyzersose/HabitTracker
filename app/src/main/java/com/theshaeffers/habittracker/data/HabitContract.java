package com.theshaeffers.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by shaefferm on 11/21/2016.
 */

public final class HabitContract {

    //Prevent accidental instantiation
    private HabitContract() {}

    //Inner class, defines habits table
    public static final class Habit implements BaseColumns{

        //Table name
        public static final String TABLE_NAME = "habits";

        //Habits table, column names
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_HABIT_NAME = "Habit";
        public static final String COLUMN_HABIT_DAY = "Day";
        public static final String COLUMN_HABIT_STATUS = "Status";

        //Options for Status
        public final static int STATUS_SCHEDULED = 0;
        public final static int STATUS_INCOMPLETE = 1;
        public final static int STAUS_COMPLETE = 2;

}

}