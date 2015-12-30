package com.example.leo.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Formatter;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);  // 要求不显示标题
		setContentView(R.layout.activity_main);
		Log.d("LEO", "APP Start");

		EditText  EditText_In = (EditText) findViewById(R.id.EditText_In);

		EditText_In.addTextChangedListener(EditText_In_Watcher);

		Button Button_Press = (Button)findViewById(R.id.Button_Press);

		Button_Press.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(MainActivity.this, "You Press Button Press", Toast.LENGTH_SHORT).show();
				Log.d("LEO", "You Press Button Press");

			}
		});

		Button Button_Send  = (Button)findViewById(R.id.Button_Send);

		Button_Send.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(MainActivity.this, "You Press Button Send", Toast.LENGTH_SHORT).show();
				Log.d("LEO", "You Press Button Send");

			}
		});




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
