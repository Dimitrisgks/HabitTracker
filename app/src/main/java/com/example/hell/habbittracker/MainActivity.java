package com.example.hell.habbittracker;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HabitInfo habitinfo = new HabitInfo(this);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("DD/MM/YYYY");
        String dateString = formatter.format(date);
        int dateInt = Integer.parseInt(dateString);

        habitinfo.insertHabit(dateInt, HabitGetter.HabitGet.Habit_0,
                "Appointments");
        habitinfo.insertHabit(dateInt, HabitGetter.HabitGet.Habit_1,
                "Have to go to the gym");
        habitinfo.insertHabit(dateInt, HabitGetter.HabitGet.Habit_2,
                "Have to go to take my dog for a walk");
        Cursor cursor = habitinfo.readHabits();
        while (cursor.moveToNext()) {
            Log.v(TAG, "habit: " + cursor.getInt(0) + " " + cursor.getInt(1) +
                    " " + cursor.getInt(2) + " " + cursor.getString(3));
        }
    }
}