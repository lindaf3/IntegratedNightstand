package com.example.integratednightstand;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button alarmStart;
    int startHour, startMinute;
    Button alarmEnd;
    Button alarmSet;
    int endHour, endMinute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmStart = findViewById(R.id.alarmStart);
        alarmEnd = findViewById(R.id.alarmEnd);
        alarmSet = findViewById(R.id.alarmSetter);

        alarmSet.setOnClickListener(view -> Toast.makeText(getApplicationContext(), "Alarm Set!", Toast.LENGTH_SHORT).show());
        alarmStart.setOnClickListener(view -> {
            TimePickerDialog.OnTimeSetListener onTimeSetListener = (timePicker, hr, min) -> {
                startHour = hr;
                startMinute = min;
                alarmStart.setText(String.format(Locale.getDefault(), "%02d:%02d", startHour, startMinute));
            };
            int style = AlertDialog.THEME_DEVICE_DEFAULT_DARK;
            TimePickerDialog alarmDialog = new TimePickerDialog(view.getContext(), style, onTimeSetListener, startHour, startMinute, true);


            alarmDialog.setTitle("Select Alarm Start Time");
            alarmDialog.show();
        });
        alarmEnd.setOnClickListener(view -> {
            TimePickerDialog.OnTimeSetListener onTimeSetListener = (timePicker, hr, min) -> {
                endHour = hr;
                endMinute = min;
                alarmEnd.setText(String.format(Locale.getDefault(), "%02d:%02d", endHour, endMinute));
            };
            int style = AlertDialog.THEME_DEVICE_DEFAULT_DARK;
            TimePickerDialog alarmDialog = new TimePickerDialog(view.getContext(), style, onTimeSetListener, endHour, endMinute, true);
            alarmDialog.setTitle("Select Alarm End Time");
            alarmDialog.show();
        });


    }

}