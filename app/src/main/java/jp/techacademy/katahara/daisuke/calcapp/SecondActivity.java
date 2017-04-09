package jp.techacademy.katahara.daisuke.calcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        int result =  intent.getIntExtra("Result", 0);

        TextView textView = (TextView) findViewById(R.id.textView3);
        textView.setText(String.valueOf(result));
     }
}
