package com.example.calendar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
    private String time;
    private String name;
    private String place;
    private String thing;
    private Context context;
    TextView show_out_name;
    TextView show_out_time;
    TextView show_out_place;
    TextView show_out_thing;
    TextView show;
    private CalendarView calendarView;
    Date today = Calendar.getInstance().getTime();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //"yyyyMMdd" 也行，小写的m表示分钟
    final String todayStr = sdf.format(today);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = findViewById(R.id.trans_yin);
        SharedPreferences sharedPreferences = getSharedPreferences("mything",Activity.MODE_PRIVATE);
        // SharedPreferences sp =  PreferenceManager.getDefaultSharedPreferences(this);      //22(24)版本以上。
        time =   sharedPreferences.getString("Time","append time");
        name =   sharedPreferences.getString("Name","append name");
        place =   sharedPreferences.getString("Place","append place");
        thing =   sharedPreferences.getString("Thing","append thing");
        show_out_name = findViewById(R.id.show_out_name);
        show_out_time = findViewById(R.id.show_out_time);
        show_out_place = findViewById(R.id.show_out_place);
        show_out_thing = findViewById(R.id.show_out_thing);
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
        show_out_name.setText(name);
        show_out_time.setText(time);
        show_out_place.setText(place);
        show_out_thing.setText(thing);
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode==1 && resultCode==2){
            Bundle bundle = data.getExtras();
            time = bundle.getString("key_Time");
            name = bundle.getString("key_Name");
            thing = bundle.getString("key_Thing");
            place = bundle.getString("key_Place");

            SharedPreferences sharedPreferences = getSharedPreferences("mything",Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("Time",time);
            editor.putString("Name",name);
            editor.putString("Thing",thing);
            editor.putString("Place",place);
            editor.commit();
            Log.i(TAG, "onActivityResult: 数据已保存到sharedPreference");
        }
        super.onActivityResult(requestCode,resultCode,data);
    }
    public  void today(){


    }
}



