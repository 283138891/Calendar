package com.example.calendar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//日历第一天，完成layout。查询多方资料，选择CalendarView
public class MainActivity extends Activity {
    private  final String TAG = "Rate";
    private Context context;
    private CalendarView calendarView;
    Date today = Calendar.getInstance().getTime();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //"yyyyMMdd" 也行，小写的m表示分钟
    final String todayStr = sdf.format(today);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取系统当前时间
        Date today = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //"yyyyMMdd" 也行，小写的m表示分钟
        final String todayStr = sdf.format(today);

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
    public  void openOne(View btn){
        // Log.i("open","openOne: ");
        //Intent hello = new Intent(this , Homework3_2.class);
        // Intent web = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.jd.com"));
        //Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:17396227916"));
        // startActivity(intent);
        openConfig();
    }

    private void openConfig() {
        Intent config =  new Intent(this, Thing_Activity.class);
        config.putExtra("chooseday",todayStr);
        Log.i(TAG,"openOne: dollar_rate_key=" + todayStr);
        // startActivity(config);
        startActivityForResult(config,1);
    }
}

