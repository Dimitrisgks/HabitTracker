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
        String CREATE_TABLE_TRACKING_DIARY = "CREATE TABLE " + HabitGetter.HabitGet.Panel_name +
                "(" + HabitGetter.HabitGet._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                HabitGetter.HabitGet.Date + " INTEGER NOT NULL," +
                HabitGetter.HabitGet.HabitSection + " INTEGER NOT NULL," +
                HabitGetter.HabitGet.SectionInfo + " STRING);";
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
        values.put(HabitGetter.HabitGet.Date, date);
        values.put(HabitGetter.HabitGet.HabitSection, habit);
        values.put(HabitGetter.HabitGet.SectionInfo, comment);
        db.insert(HabitGetter.HabitGet.Panel_name, null, values);
    }

    public Cursor readHabits() {
        //the database is returned by the cursor
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                HabitGetter.HabitGet._ID,
                HabitGetter.HabitGet.Date,
                HabitGetter.HabitGet.HabitSection,
                HabitGetter.HabitGet.SectionInfo
        };
        Cursor cursor = db.query(
                HabitGetter.HabitGet.Panel_name,
                projection,
                null, null, null, null, null);
        return cursor;
    }
}