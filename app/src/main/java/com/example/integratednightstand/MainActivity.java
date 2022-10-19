package com.example.integratednightstand;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button alarmStart;
    int startHour, startMinute;
    Button alarmEnd;
    int endHour, endMinute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmStart = findViewById(R.id.alarmStart);
        alarmEnd = findViewById(R.id.alarmEnd);


    }


//    public void test(View view) {
//        MaterialTimePicker startAlarm = new MaterialTimePicker.Builder().setTimeFormat(TimeFormat.CLOCK_12H)
//                .setHour(12)
//                .setTitleText("Select Appointment time")
//                .build();
//        startAlarm.show(fragmentManager, "tag");
//    }
    public void alarmEndSetter(View view) {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = (timePicker, hr, mins) -> {
            endHour = hr;
            endMinute = mins;
            alarmEnd.setText(String.format(Locale.getDefault(), "%02d:%02d", endHour, endMinute));
        };
        int style = AlertDialog.THEME_DEVICE_DEFAULT_DARK;
        TimePickerDialog alarmDialog = new TimePickerDialog(this, style, onTimeSetListener, endHour, endMinute, true);
        alarmDialog.setTitle("Select Alarm End Time");
        alarmDialog.show();

    }
    public void alarmStartSetter(View view) {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = (timePicker, hr, mins) -> {
            startHour = hr;
            startMinute = mins;
            alarmStart.setText(String.format(Locale.getDefault(), "%02d:%02d", startHour, startMinute));
        };
        int style = AlertDialog.THEME_DEVICE_DEFAULT_DARK;
        TimePickerDialog alarmDialog = new TimePickerDialog(this, style, onTimeSetListener, startHour, startMinute, true);


        alarmDialog.setTitle("Select Alarm Start Time");
        alarmDialog.show();

    }
}