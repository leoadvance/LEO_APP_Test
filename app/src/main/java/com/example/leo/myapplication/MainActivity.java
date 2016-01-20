package com.example.leo.myapplication;

import android.app.Activity;

import android.content.Intent;
import android.net.Uri;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends Activity {
	EditText EditText_In;
	final int MaintoSewcond = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// 要求不显示标题
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		Log.d("LEO", "APP Start");

		EditText_In = (EditText) findViewById(R.id.EditText_In);

		EditText_In.addTextChangedListener(EditText_In_Watcher);

		Button Button_Press 	 = (Button)findViewById(R.id.Button_Press);
		Button Button_Send  	 = (Button)findViewById(R.id.Button_Send);
		Button Button_SecondPage = (Button)findViewById(R.id.buttonSecondPage);
		Button ButtonBaidu 		 = (Button)findViewById(R.id.buttonBaidu);
		Button_Press.setOnClickListener(new ButtonClick());
		Button_Send.setOnClickListener(new ButtonClick());
		Button_SecondPage.setOnClickListener(new ButtonClick());
		ButtonBaidu.setOnClickListener(new ButtonClick());		// 声明按键监听程序





	}

	class ButtonClick implements View.OnClickListener {
		public void onClick(View v){
			switch(v.getId())
			{
				case R.id.Button_Press:{
					Toast.makeText(MainActivity.this, "You Press Button Press", Toast.LENGTH_SHORT).show();
					Log.d("LEO", "You Press Button Press");
				}break;

				case R.id.Button_Send:{
					Toast.makeText(MainActivity.this, "You Press Button Send", Toast.LENGTH_SHORT).show();
					Log.d("LEO", "You Press Button Send");

					Log.d("LEO", "当前文本框内容是 <" + EditText_In.getText().toString() + ">");

					Toast.makeText(MainActivity.this, "当前文本框内容是 <" + EditText_In.getText().toString() + ">", Toast.LENGTH_SHORT).show();


				}break;

				case R.id.buttonSecondPage:{
					Toast.makeText(MainActivity.this, "You Press Button SecondPage", Toast.LENGTH_SHORT).show();
					Log.d("LEO", "You Press Button SecondPage");

					Intent intent = new Intent(MainActivity.this, SecondPage.class);
					intent.putExtra("MaintoSecondpage", "we travel from Main to Second");
					startActivityForResult(intent, MaintoSewcond);

				}break;

				case R.id.buttonBaidu:{
					Toast.makeText(MainActivity.this, "You Press Button Baidu", Toast.LENGTH_SHORT).show();
					Log.d("LEO", "You Press Button Baidu");

					// 声明新Intent
					Intent IntentBaidu = new Intent(Intent.ACTION_VIEW);

					// uri解析网址
					IntentBaidu.setData(Uri.parse("http://www.baidu.com"));

					// 执行
					startActivity(IntentBaidu);

					finish();

				}break;

				default:
					break;
			}
		}

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu){

		Log.d("LEO", "创建Menu");
		menu.add(Menu.NONE, Menu.FIRST + 1, 5, "删除").setIcon(
				android.R.drawable.ic_menu_delete);
		getMenuInflater().inflate(R.menu.main, menu);
		return true;

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item){

		switch(item.getItemId()) {

			case R.id.add_item:
				Toast.makeText(this, "You clicked ADD", Toast.LENGTH_SHORT).show();
				break;

			case R.id.remove_item:
				Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
				break;
			default:

				break;

		}

		return true;

	}

	private TextWatcher EditText_In_Watcher = new TextWatcher() {

		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			// TODO Auto-generated method stub

			Log.d("LEO", "当前字符 = <" + s + "> 开始位置 = " + start + " 之前位置 = " + before + " 本次输入长度 = " + count);


		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
		                              int after) {
			// TODO Auto-generated method stub
			Log.d("LEO", "文本变化之前");

		}

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			Log.d("LEO", "文本变化之后");

		}
	};


	// 重写Activity结束接收方法
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data){

        // 判断返回值
		switch(requestCode){

            case MaintoSewcond:{

                String StringBack = data.getStringExtra("SecondBacktoMain");

//                if (resultCode == RESULT_OK)
//                {
//                    StringBack += "RESULT OK";
//                }
//                else
//                {
//                    StringBack += "RESULT FAILED";
//                }
                Toast.makeText(MainActivity.this, StringBack, Toast.LENGTH_SHORT).show();
                Log.d("LEO", StringBack);

            }break;

            default:
                break;

		}
	}

}
