package com.example.calendar;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Thing_Activity extends AppCompatActivity {
    EditText timeText;
    EditText nameText;
    EditText placeText;
    EditText thingText;

    public  final  String TAG = " ConfigActivity ";
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thing_);
        Intent intent = getIntent();
        timeText = (EditText)findViewById(R.id.time);
        nameText = (EditText)findViewById(R.id.name);
        placeText = (EditText)findViewById(R.id.place);
        thingText = (EditText)findViewById(R.id.thing);
}
    public  void save(View btn){
        Log.i("cfg","save:");
        String newTime = timeText.getText().toString();
        String newName =  nameText.getText().toString();
        String newPlace = placeText.getText().toString();
        String newThing = thingText.getText().toString();
        Intent intent = getIntent();
        Bundle bdl = new Bundle();
        bdl.putString("key_Time",newTime);
        bdl.putString("key_Name",newName );
        bdl.putString("key_Place",newPlace);
        bdl.putString("key_Thing",newThing);
        intent.putExtras(bdl);
        setResult(2,intent);
        finish();
    }
}
