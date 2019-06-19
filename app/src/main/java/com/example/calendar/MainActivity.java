package com.example.calendar;

//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.view.View;
//import android.widget.CalendarView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//
////日历第一天，完成layout。查询多方资料，选择CalendarView
//public class MainActivity extends Activity {
//    private  final String TAG = "Rate";
//    private Context context;
//    TextView show;
//    private CalendarView calendarView;
//    Date today = Calendar.getInstance().getTime();
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //"yyyyMMdd" 也行，小写的m表示分钟
//    final String todayStr = sdf.format(today);
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        show = findViewById(R.id.trans_yin);
//        //获取系统当前时间
//        today = Calendar.getInstance().getTime();
//        Calendar cal=Calendar.getInstance();
//        cal.setTime(today);
////        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //"yyyyMMdd" 也行，小写的m表示分钟
////        final String todayStr = sdf.format(today);
//         Lunar lunar = new Lunar(cal);
//         String lunarStr = "";
//         lunarStr=lunar.animalsYear()+"年(";
//         lunarStr +=lunar.cyclical()+"年)";
//         lunarStr +=lunar.toString();
//         show.setText(lunarStr);
//        context = this;
//        calendarView = (CalendarView)findViewById(R.id.calendarViewId);
//
//        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            public void onSelectedDayChange(CalendarView view, int year, int month,
//                                            int dayOfMonth) {
//
//                String content = year+"-"+(month+1)+"-"+dayOfMonth;
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //"yyyyMMdd" 也行，小写的m表示分钟
//                Calendar calendar = Calendar.getInstance();
//                try{
//                    Date date =sdf.parse(content);
//                    calendar.setTime(date);
//
//                }catch (ParseException e){
//                    e.printStackTrace();
//                }
//                Lunar lunar = new Lunar(calendar);
//                String lunarStr = "";
//                lunarStr=lunar.animalsYear()+"年(";
//                lunarStr +=lunar.cyclical()+"年)";
//                lunarStr +=lunar.toString();
//                show.setText(lunarStr);//点击显示选中日期的农历
//                Toast.makeText(context, "你选择了:\n"+content, Toast.LENGTH_SHORT).show();//setOnDateChangeListener设置点击事件，选中某个日期
//
//            }
//        });
//    }
//    public  void openOne(View btn){
//        // Log.i("open","openOne: ");
//        //Intent hello = new Intent(this , Homework3_2.class);
//        // Intent web = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.jd.com"));
//        //Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:17396227916"));
//        // startActivity(intent);
//        openConfig();
//    }
//    private void openConfig() {
//        Intent config =  new Intent(this, Thing_Activity.class);
//        config.putExtra("chooseday",todayStr);
//        Log.i(TAG,"openOne: dollar_rate_key=" + todayStr);
//        // startActivity(config);
//        startActivityForResult(config,1);
//    }
//    //获取回传数据
//    protected void onActivityResult(int requestCode, int resultCode, Intent data){
//        if (requestCode==1 && resultCode==2){
//            Bundle bundle = data.getExtras();
//            dollarRate = bundle.getFloat("key_dollar",0.1f);
//            euroRate = bundle.getFloat("key_euro",0.1f);
//            wonRate = bundle.getFloat("key_won",0.1f);
//            Log.i(TAG,"onActivityResult:dollarRate"+ dollarRate);
//            Log.i(TAG,"onActivityResult:euroRate"+ euroRate);
//            Log.i(TAG,"onActivityResult:wonRate"+ wonRate);
//
//            //将新设置的汇率写到SP里
//            SharedPreferences sharedPreferences = getSharedPreferences("myrate",Activity.MODE_PRIVATE);
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//            editor.putFloat("dollar_rate",dollarRate);
//            editor.putFloat("euro_rate",euroRate);
//            editor.putFloat("won_rate",wonRate);
//            editor.commit();
//            Log.i(TAG, "onActivityResult: 数据已保存到sharedPreference");
//        }
//        super.onActivityResult(requestCode,resultCode,data);
//    }
//    public  void today(){
//
//
//    }
//}
//
////    单选时跳转到今天
////
////
////    nextMonth()
////    跳转到下个月
////
////
////    lastMonth()
////    跳转到上个月
////
////
////    nextYear()
////    跳转到下一年的当前月
////
////
////    lastYear()
////    跳转到上一年的当前月
////
////
////    toStart()
////    跳转到日历的开始年月
////
////
////    toEnd()

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.calendar.CalendarDate;
import com.example.calendar.CalendarViewFragment;
import com.example.calendar.CalendarViewPagerFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements
        CalendarViewPagerFragment.OnPageChangeListener,
        CalendarViewFragment.OnDateClickListener,
        CalendarViewFragment.OnDateCancelListener {

    private TextView tv_date;
    private boolean isChoiceModelSingle = false;
    private List<CalendarDate> mListDate = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_date = (TextView) findViewById(R.id.tv_date);
        initFragment();
    }

    private void initFragment(){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction tx = fm.beginTransaction();
        // Fragment fragment = new CalendarViewPagerFragment();
        Fragment fragment = CalendarViewPagerFragment.newInstance(isChoiceModelSingle);
        tx.replace(R.id.fl_content, fragment);
        tx.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_im, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_single:
                isChoiceModelSingle = true;
                initFragment();
                break;
            case R.id.menu_multi:
                isChoiceModelSingle = false;
                initFragment();
                break;
            default:
                break;
        }
        return true;
    }
    @Override
    public void onDateClick(CalendarDate calendarDate) {

        int year = calendarDate.getSolar().solarYear;
        int month = calendarDate.getSolar().solarMonth;
        int day = calendarDate.getSolar().solarDay;
        if (isChoiceModelSingle) {
            tv_date.setText(year + "-" + month + "-" + day);
        } else {
            //System.out.println(calendarDate.getSolar().solarDay);
            mListDate.add(calendarDate);
            tv_date.setText(listToString(mListDate));
        }

    }

    @Override
    public void onDateCancel(CalendarDate calendarDate) {
        int count = mListDate.size();
        for (int i = 0; i < count; i++) {
            CalendarDate date = mListDate.get(i);
            if (date.getSolar().solarDay == calendarDate.getSolar().solarDay) {
                mListDate.remove(i);
                break;
            }
        }
        tv_date.setText(listToString(mListDate));
    }

    @Override
    public void onPageChange(int year, int month) {
        tv_date.setText(year + "-" + month);
        mListDate.clear();
    }

    private static String listToString(List<CalendarDate> list) {
        StringBuffer stringBuffer = new StringBuffer();
        for (CalendarDate date : list) {
            stringBuffer.append(date.getSolar().solarYear + "-" + date.getSolar().solarMonth + "-" + date.getSolar().solarDay).append(" ");
        }
        return stringBuffer.toString();
    }

}
