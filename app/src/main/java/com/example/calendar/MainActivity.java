package com.example.calendar;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;
import android.widget.Toast;

//日历第一天，完成layout。查询多方资料，选择CalendarView
public class MainActivity extends Activity {

    private Context context;
    private CalendarView calendarView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        calendarView = (CalendarView)findViewById(R.id.calendarViewId);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                String content = year+"-"+(month+1)+"-"+dayOfMonth;
                Toast.makeText(context, "你选择了:\n"+content, Toast.LENGTH_SHORT).show();//setOnDateChangeListener设置点击事件，选中某个日期
            }
        });
    }

}

