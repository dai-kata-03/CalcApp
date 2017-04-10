package jp.techacademy.katahara.daisuke.calcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        double ResultNumber = intent.getDoubleExtra("Result", 0);

        Log.d("Result",String.valueOf(ResultNumber));

        TextView textView = (TextView) findViewById(R.id.textView3);
        textView.setText(String.valueOf(ResultNumber));
     }
}
