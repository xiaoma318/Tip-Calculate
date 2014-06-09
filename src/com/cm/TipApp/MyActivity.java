package com.cm.TipApp;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class MyActivity extends Activity {
    Button b1, b2, b3;
    TextView input, ret, total, each, eTip, num;
    Spinner more;
    SeekBar split;
    DecimalFormat df = new DecimalFormat("#.##");
    int numOfPerson = 1;
    double sum = 0, tip = 0;

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
        num = (TextView) findViewById(R.id.textView7);
        more = (Spinner) findViewById(R.id.spinner1);
        split = (SeekBar) findViewById(R.id.seekBar);

        setListener();
    }

    public void setListener() {

        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!input.getText().toString().isEmpty()) {
                    tip = Double.parseDouble(input.getText().toString());
                    sum = tip * 1.1;
                    refresh(sum, tip * 0.1, numOfPerson);
                }
            }

        });

        b2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!input.getText().toString().isEmpty()) {
                    tip = Double.parseDouble(input.getText().toString());
                    sum = tip * 1.15;
                    refresh(sum, tip * 0.15, numOfPerson);
                }
            }

        });

        b3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!input.getText().toString().isEmpty()) {
                    tip = Double.parseDouble(input.getText().toString());
                    sum = tip * 1.2;
                    refresh(sum, tip * 0.2, numOfPerson);
                }
            }

        });

        more.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                if (!input.getText().toString().isEmpty()) {
                    tip = Double.parseDouble(input.getText().toString());
                    double percent = Double.parseDouble(more.getItemAtPosition(arg2).toString().split("%")[0]) / 100;
                    sum = tip * (1 + percent);
                    refresh(sum, tip * percent, numOfPerson);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        });

        split.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.e("SeeBar Value: ", progress + "");
                num.setText((progress + 1) + "");
                numOfPerson = progress + 1;
                refresh(sum, tip, numOfPerson);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    public void refresh(double sum, double tip, int n) {
        ret.setText(df.format(tip));
        total.setText(df.format(sum));
        each.setText(df.format(sum / n));
        eTip.setText(df.format(tip / n));
    }
}
