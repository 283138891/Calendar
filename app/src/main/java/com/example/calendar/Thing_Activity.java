package com.example.calendar;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Thing_Activity extends AppCompatActivity {
    EditText todayStrtext;
    EditText dollarText;
    EditText euroText;
    EditText wonText;
    public  final  String TAG = " ConfigActivity ";
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        dollarText = (EditText)findViewById(R.id.dollar_rate);
        euroText = (EditText)findViewById(R.id.euro_rate);
        wonText = (EditText)findViewById(R.id.won_rate);
        setContentView(R.layout.activity_thing_);
        Intent intent = getIntent();
        String dateStr = intent.getStringExtra("chooseday");
        Log.i(TAG," onCreate: dollar2= "+dateStr);
        todayStrtext = (EditText)findViewById(R.id.dollar_rate);
        todayStrtext.setText(String.valueOf(dateStr));

    }
    public  void save(View btn){
        Log.i("cfg","save:");
        String dateStr = dollarText.getText().toString();
//        Date date = dollarText.getdate().todate
        String dateStr1 = dollarText.getText().toString();
        Log.i(TAG, "获取到新的值");
        Bundle bdl = new Bundle();
        bdl.putString("date",dateStr1);
        Intent intent = getIntent();
        intent.putExtras(bdl);
        setResult(2,intent);
        finish();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}


