package com.example.leo.myapplication;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;


// 创建一个BaseActivity继承于Activity
public class BaseActivity extends Activity{

    final String CurrentActivityTag = "BaseActivity";
    // 重写onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState){

        // 调用父类的onCreate()构造函数
        super.onCreate(savedInstanceState);

        // 获取当前Activity名称
        Log.d(CurrentActivityTag, getClass().getSimpleName() + " < onCreate >");
    }

    // 重写onDestroy方法
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(CurrentActivityTag,  getClass().getSimpleName() + " < onDestroy >");
    }

    // 重写onStart方法
    @Override
    protected void onStart(){
        super.onStart();
        Log.d(CurrentActivityTag, getClass().getSimpleName() + " < onStart >");
    }

    // 重写onStop方法
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(CurrentActivityTag, getClass().getSimpleName() + " < onStop >");
    }

    // 重写onResume方法
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(CurrentActivityTag, getClass().getSimpleName() + " < onResume >");
    }

    // 重写onPause方法
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(CurrentActivityTag, getClass().getSimpleName() + " < onPause >");
    }

    // 重写onRestart方法
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(CurrentActivityTag, getClass().getSimpleName() + " < onRestart >");
    }
}
