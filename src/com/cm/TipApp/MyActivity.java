package com.cm.TipApp;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MyActivity extends Activity {
	Button b1, b2, b3;
	TextView input, ret;
	Spinner s;
	DecimalFormat df = new DecimalFormat("#.##");
	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		b1 = (Button) findViewById(R.id.button1);
		b2 = (Button) findViewById(R.id.button2);
		b3 = (Button) findViewById(R.id.button3);
		input = (TextView) findViewById(R.id.inputText);
		ret = (TextView) findViewById(R.id.textView2);
		s = (Spinner) findViewById(R.id.spinner1);
		
		setListener();
	}

	public void setListener() {

		b1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				double money = Double.parseDouble(input.getText().toString());
				ret.setText(df.format(money * 0.1) + "");
			}

		});

		b2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				double money = Double.parseDouble(input.getText().toString());
				ret.setText(df.format(money * 0.15) + "");
			}

		});

		b3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				double money = Double.parseDouble(input.getText().toString());
				ret.setText(df.format(money * 0.2) + "");
			}

		});
		
		
		s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				double money = Double.parseDouble(input.getText().toString());
				double percent = Double.parseDouble(s.getItemAtPosition(arg2).toString().split("%")[0])/100;
				ret.setText(df.format(money * percent));
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});

	}
}
