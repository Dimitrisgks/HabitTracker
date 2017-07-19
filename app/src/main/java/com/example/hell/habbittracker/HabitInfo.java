package com.example.hell.habbittracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class HabitInfo extends SQLiteOpenHelper {

    private static final String dataName = "HabitTracker";
    private static final int dataN = 1;

    public HabitInfo(Context context) {
        super(context, dataName, null, dataN);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Create/open a database
        String CREATE_TABLE_TRACKING_DIARY = "CREATE TABLE " + HabitGetter.HabitGet.TABLE_NAME +
                "(" + HabitGetter.HabitGet._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                HabitGetter.HabitGet.COLUMN_DATE + " INTEGER NOT NULL," +
                HabitGetter.HabitGet.COLUMN_INFO + " INTEGER NOT NULL," +
                HabitGetter.HabitGet.COLUMN_SECTION + " STRING);";
        Log.v("HabitInfo", "create table: " + CREATE_TABLE_TRACKING_DIARY);
        sqLiteDatabase.execSQL(CREATE_TABLE_TRACKING_DIARY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertHabit(int date, int habit, String comment) {
        // Gets the database by writing
        // Create a Values object where section names are the keys,
        // Android's attributes are the values.
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HabitGetter.HabitGet.COLUMN_DATE, date);
        values.put(HabitGetter.HabitGet.COLUMN_INFO, habit);
        values.put(HabitGetter.HabitGet.COLUMN_SECTION, comment);
        db.insert(HabitGetter.HabitGet.TABLE_NAME, null, values);
    }

    public Cursor readHabits() {
        //the database is returned by the cursor
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                HabitGetter.HabitGet._ID,
                HabitGetter.HabitGet.COLUMN_DATE,
                HabitGetter.HabitGet.COLUMN_INFO,
                HabitGetter.HabitGet.COLUMN_SECTION
        };
        Cursor cursor = db.query(
                HabitGetter.HabitGet.TABLE_NAME,
                projection,
                null, null, null, null, null);
        return cursor;
    }
}
