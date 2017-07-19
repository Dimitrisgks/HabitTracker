package com.example.hell.habbittracker;

import android.provider.BaseColumns;


public class HabitGetter {
    public class HabitGet implements BaseColumns {
        public final static String TABLE_NAME = "Daily_Habits";
        public final static String COLUMN_SECTION = "Habit_Section";
        public final static String COLUMN_INFO = "Habit_Info";
        public final static String COLUMN_DATE = "date";
        public final static String _ID = BaseColumns._ID;
        public final static int Habit_0 = 0;
        public final static int Habit_1 = 1;
        public final static int Habit_2 = 2;
    }
}
