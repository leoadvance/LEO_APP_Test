package com.example.leo.myapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
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

import java.util.Formatter;

public class MainActivity extends Activity {
	EditText EditText_In;
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
		Button_Press.setOnClickListener(new ButtonClick());
		Button_Send.setOnClickListener(new ButtonClick());
		Button_SecondPage.setOnClickListener(new ButtonClick());





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
					startActivity(intent);
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

}
