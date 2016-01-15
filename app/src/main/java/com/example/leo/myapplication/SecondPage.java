package com.example.leo.myapplication;

import android.app.Activity;
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


        ImageButton ButtonBackMain = (ImageButton)findViewById(R.id.imageButtonBackMain);

        ButtonBackMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondPage.this, "You Press Button BackMain", Toast.LENGTH_SHORT).show();
                Log.d("LEO", "You Press Button BackMain");

                finish();

            }
        });

    }
}
