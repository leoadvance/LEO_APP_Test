package com.example.leo.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

public class DialogPage  extends Activity{

    // 重写onCreate
    @Override

    protected void onCreate(Bundle savedInstanceState){

        // 调用父类的onCreate()构造函数
        super.onCreate(savedInstanceState);

        //  屏蔽小标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Log.d("LEO", "进入SecondPage");

        // 用布局文件进行布局
        setContentView(R.layout.dialogpage);
    }
}
