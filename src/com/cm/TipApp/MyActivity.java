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
	TextView input, ret, total, each, eTip;
	Spinner more, split;
	DecimalFormat df = new DecimalFormat("#.##");
	int numOfPerson = 1;
	double sum = 0;

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
		total = (TextView) findViewById(R.id.textView4);
		each = (TextView) findViewById(R.id.TextView02);
		eTip = (TextView) findViewById(R.id.TextView04);
		more = (Spinner) findViewById(R.id.spinner1);
		split = (Spinner) findViewById(R.id.spinner2);

		setListener();
	}

	public void setListener() {

		b1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!input.getText().toString().isEmpty()) {
					double money = Double.parseDouble(input.getText()
							.toString());
					sum = money * 1.1;
					ret.setText(df.format(money * 0.1) + "");
					total.setText(df.format(money * 1.1) + "");
					each.setText(df.format(money * 1.1 / numOfPerson));
					eTip.setText(df.format(money * 0.1 / numOfPerson));
				}
			}

		});

		b2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!input.getText().toString().isEmpty()) {
					double money = Double.parseDouble(input.getText()
							.toString());
					sum = money * 1.15;
					ret.setText(df.format(money * 0.15) + "");
					total.setText(df.format(money * 1.15) + "");
					each.setText(df.format(money * 1.15 / numOfPerson));
					eTip.setText(df.format(money * 0.15 / numOfPerson));
				}
			}

		});

		b3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!input.getText().toString().isEmpty()) {
					double money = Double.parseDouble(input.getText()
							.toString());
					sum = money * 1.2;
					ret.setText(df.format(money * 0.2) + "");
					total.setText(df.format(money * 1.2) + "");
					each.setText(df.format(money * 1.2 / numOfPerson));
					eTip.setText(df.format(money * 0.2 / numOfPerson));
				}
			}

		});

		more.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				if (!input.getText().toString().isEmpty()) {
					double money = Double.parseDouble(input.getText()
							.toString());
					double percent = Double.parseDouble(more
							.getItemAtPosition(arg2).toString().split("%")[0]) / 100;
					sum = money * (1 + percent);
					ret.setText(df.format(money * percent));
					total.setText(df.format(sum) + "");
					each.setText(df.format(sum / numOfPerson));
					eTip.setText(df.format(money * percent / numOfPerson));
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

		split.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				numOfPerson = Integer.parseInt(split.getItemAtPosition(arg2)
						.toString());
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

	}
}
