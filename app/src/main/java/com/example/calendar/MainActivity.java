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
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//日历第一天，完成layout。查询多方资料，选择CalendarView
public class MainActivity extends Activity {
    private  final String TAG = "Rate";
    private Context context;
    TextView show;
    private CalendarView calendarView;
    Date today = Calendar.getInstance().getTime();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //"yyyyMMdd" 也行，小写的m表示分钟
    final String todayStr = sdf.format(today);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = findViewById(R.id.trans_yin);
        //获取系统当前时间
        today = Calendar.getInstance().getTime();
        Calendar cal=Calendar.getInstance();
        cal.setTime(today);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //"yyyyMMdd" 也行，小写的m表示分钟
//        final String todayStr = sdf.format(today);
         Lunar lunar = new Lunar(cal);
         String lunarStr = "";
         lunarStr=lunar.animalsYear()+"年(";
         lunarStr +=lunar.cyclical()+"年)";
         lunarStr +=lunar.toString();
         show.setText(lunarStr);
        context = this;
        calendarView = (CalendarView)findViewById(R.id.calendarViewId);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {

                String content = year+"-"+(month+1)+"-"+dayOfMonth;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //"yyyyMMdd" 也行，小写的m表示分钟
                Calendar calendar = Calendar.getInstance();
                try{
                    Date date =sdf.parse(content);
                    calendar.setTime(date);

                }catch (ParseException e){
                    e.printStackTrace();
                }
                Lunar lunar = new Lunar(calendar);
                String lunarStr = "";
                lunarStr=lunar.animalsYear()+"年(";
                lunarStr +=lunar.cyclical()+"年)";
                lunarStr +=lunar.toString();
                show.setText(lunarStr);//点击显示选中日期的农历
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
    //获取回传数据
    public  void today(){


    }
}

//    单选时跳转到今天
//
//
//    nextMonth()
//    跳转到下个月
//
//
//    lastMonth()
//    跳转到上个月
//
//
//    nextYear()
//    跳转到下一年的当前月
//
//
//    lastYear()
//    跳转到上一年的当前月
//
//
//    toStart()
//    跳转到日历的开始年月
//
//
//    toEnd()


