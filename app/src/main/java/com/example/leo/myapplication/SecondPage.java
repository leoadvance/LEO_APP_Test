package com.example.leo.myapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class SecondPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){

        // 调用父类的onCreate()构造函数
        super.onCreate(savedInstanceState);

        //  屏蔽小标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Log.d("LEO", "进入SecondPage");

        // 用布局文件进行布局
        setContentView(R.layout.secondpage);


        // 获取上层Activity传递的数值
        Intent IntentSecond = getIntent();
        String string = IntentSecond.getStringExtra("MaintoSecondpage");
        Log.d("LEO", string);


        // 声明Button监听程序
        ImageButton ButtonBackMain = (ImageButton)findViewById(R.id.imageButtonBackMain);
        ButtonBackMain.setOnClickListener(new ButtonClick());


    }

    // 按键处理类
    class ButtonClick implements View.OnClickListener{

        public void onClick(View v){

            switch(v.getId())
            {
                case R.id.imageButtonBackMain:{
                    Toast.makeText(SecondPage.this, "You Press Button BackMain", Toast.LENGTH_SHORT).show();
                    Log.d("LEO", "You Press Button BackMain");

                    SecondPageBack();


                }break;

                default:
                    break;
            }

        }

    }

    public void SecondPageBack(){

        // 声明新的Intent
        Intent intent = new Intent();

        intent.putExtra("SecondBacktoMain", "Back to Main Page");

        // 发送返回值
        setResult(RESULT_OK, intent);

        finish();
    }

    // 重写后退按键方法
    @Override
    public void onBackPressed(){

        Toast.makeText(SecondPage.this, "You Press Button BackPressed", Toast.LENGTH_SHORT).show();
        Log.d("LEO", "You Press Button BackPressed");

        SecondPageBack();


    }
}
