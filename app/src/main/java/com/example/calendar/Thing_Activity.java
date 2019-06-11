package com.example.calendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Thing_Activity extends AppCompatActivity {
    EditText todayStrtext;
    public  final  String TAG = " ConfigActivity ";
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thing_);
        Intent intent = getIntent();
        String dateStr = intent.getStringExtra("chooseday");
        Log.i(TAG," onCreate: dollar2= "+dateStr);
        todayStrtext = (EditText)findViewById(R.id.things);
        todayStrtext.setText(String.valueOf(dateStr));

    }
}
