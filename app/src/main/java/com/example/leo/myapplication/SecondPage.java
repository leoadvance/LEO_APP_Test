package com.example.leo.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
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
    final String TAG_ACTIVITY = "ActivityTag";
    final String CurrentPage  = "SecondPage ";
    @Override
    protected void onCreate(Bundle savedInstanceState){

        // 调用父类的onCreate()构造函数
        super.onCreate(savedInstanceState);

        //  屏蔽小标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Log.d("LEO", "进入SecondPage");
        Log.d(TAG_ACTIVITY, CurrentPage + "onCreate");

        // 用布局文件进行布局
        setContentView(R.layout.secondpage);


        // 获取上层Activity传递的数值
        Intent IntentSecond = getIntent();
        String string = IntentSecond.getStringExtra("MaintoSecondpage");
        Log.d("LEO", string);


        // 声明Button监听程序
        ImageButton ButtonBackMain = (ImageButton)findViewById(R.id.imageButtonBackMain);
        Button ButtonDialog        = (Button)findViewById(R.id.buttonDialog);
        Button ButtonDialogActivity = (Button)findViewById(R.id.buttonDialogActivity);
        ButtonBackMain.setOnClickListener(new ButtonClick());
        ButtonDialog.setOnClickListener(new ButtonClick());		// 声明按键监听程序
        ButtonDialogActivity.setOnClickListener(new ButtonClick());		// 声明按键监听程序


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

                case R.id.buttonDialog:{
                    Toast.makeText(SecondPage.this, "You Press Button NextDialog", Toast.LENGTH_SHORT).show();
                    Log.d("LEO", "You Press Button NextDialog");

                    Dialog_1();


                }break;

                case R.id.buttonDialogActivity:{
                    Toast.makeText(SecondPage.this, "You Press Button Dialog Activity", Toast.LENGTH_SHORT).show();
                    Log.d("LEO", "You Press Button Dialog Activity");

                    Intent IntentDialog = new Intent(SecondPage.this, DialogPage.class);
                    startActivity(IntentDialog);


                }break;

                default:
                    break;
            }

        }

    }

    public void Dialog_1(){

        // new出一个监听器
        DialogInterface.OnClickListener DialogListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which){

                // 按键处理
                switch(which){

                    // 正面处理
                    case Dialog.BUTTON_POSITIVE:{
                        Toast.makeText(SecondPage.this, "You press Positive Dialog", Toast.LENGTH_SHORT).show();

                        // 显示dialog
                        dialog.dismiss();

                    }break;

                    // 反面处理
                    case Dialog.BUTTON_NEGATIVE:{

                        Toast.makeText(SecondPage.this, "You press Negative Dialog", Toast.LENGTH_SHORT).show();

                        dialog.dismiss();

                    }break;

                    // 第三种
                    case Dialog.BUTTON_NEUTRAL:{

                        Toast.makeText(SecondPage.this, "You press Neutral Dialog", Toast.LENGTH_SHORT).show();

                        dialog.dismiss();
                    }break;

                    default:
                        break;

                }

            }
        };
        // 声明新的Dialog 构造器
        AlertDialog.Builder BuliderMain = new AlertDialog.Builder(SecondPage.this);

        // Dialog标题 内容
        BuliderMain.setTitle("警告!");
        BuliderMain.setMessage("这不是在开玩笑!");

        // 不可被其他操作打断
        BuliderMain.setCancelable(false);
        BuliderMain.setPositiveButton("是", DialogListener);
        BuliderMain.setNegativeButton("否", DialogListener);
        BuliderMain.setNeutralButton("中立", DialogListener);

        // 显示构造器
        BuliderMain.create().show();


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

    // 重写onDestroy方法
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG_ACTIVITY, CurrentPage + "onDestroy");
    }

    // 重写onStart方法
    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG_ACTIVITY, CurrentPage + "onStart");
    }

    // 重写onStop方法
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG_ACTIVITY, CurrentPage + "onStop");
    }

    // 重写onResume方法
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG_ACTIVITY, CurrentPage + "onResume");
    }

    // 重写onPause方法
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG_ACTIVITY, CurrentPage + "onPause");
    }

    // 重写onRestart方法
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG_ACTIVITY, CurrentPage + "onRestart");
    }
}
