package com.example.leo.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);  // 要求不显示标题
		setContentView(R.layout.activity_main);
		Log.d("LEO", "APP Start");
		Button Button_Press = (Button)findViewById(R.id.Button_Press);

		Button_Press.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(MainActivity.this, "You Press Button", Toast.LENGTH_SHORT).show();

			}
		});

	}
}
