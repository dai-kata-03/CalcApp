package jp.techacademy.katahara.daisuke.calcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.EditText;
import android.content.Intent;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // 変数
    EditText mEditText1;
    EditText mEditText2;
    TextView mTextView;
    double Result;
    int CalcSign = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.addSign);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.deductSign);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.multipleSign);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.divideSign);
        button4.setOnClickListener(this);

        Button button5 = (Button) findViewById(R.id.CalcButton);
        button5.setOnClickListener(this);

        mEditText1 = (EditText) findViewById(R.id.number1);
        mEditText1.setInputType(InputType.TYPE_CLASS_NUMBER);

        mEditText2 = (EditText) findViewById(R.id.number2);
        mEditText2.setInputType(InputType.TYPE_CLASS_NUMBER);

        mTextView = (TextView) findViewById(R.id.message);

    }

    @Override
    public void onClick(View v) {

        Log.d("GetID", String.valueOf(v.getId()));
        Log.d("CalcSign", String.valueOf(CalcSign));

       switch (v.getId()) {

            case R.id.addSign:
                CalcSign = v.getId();
                Log.d("Dispatch", "Add");
                break;

            case R.id.deductSign:
                CalcSign = v.getId();
                Log.d("Dispatch", "Deduct");
                break;

            case R.id.multipleSign:
                CalcSign = v.getId();
                Log.d("Dispatch", "Multiple");
                break;

            case R.id.divideSign:
                CalcSign = v.getId();
                Log.d("Dispatch", "Divide");
                break;

            case R.id.CalcButton:

                Log.d("Log","Error4");

                String para1 = mEditText1.getText().toString();
                String para2 = mEditText2.getText().toString();

                Log.d("Log",para1);
                Log.d("Log",para2);
                Log.d("Log","Error5");

                double pNumber1 = Double.valueOf(para1);
                double pNumber2 = Double.valueOf(para2);

                Log.d("Log",String.valueOf(pNumber1));
                Log.d("Log", String.valueOf(pNumber2));
                Log.d("Log","Error6");

                Log.d("Sign", String.valueOf(R.id.multipleSign));
                Log.d("pNumber1", String.valueOf(pNumber1));
                Log.d("pNumber2", String.valueOf(pNumber2));
                Log.d("Log","Error7");

                if (CalcSign == 0) {
                    Log.d("Log","Error1");
                    mTextView.setText("計算記号を指定してください。");
                } else if (pNumber1 >=0 && pNumber2 >=0) {

                    Log.d("Log","Error2");

                    switch (CalcSign) {
                        case R.id.addSign:
                            Result = pNumber1 + pNumber2;
                            Log.d("Dispatch", "Add2");
                            break;
                        case R.id.deductSign:
                            Result = pNumber1 - pNumber2;
                            Log.d("Dispatch", "Deduct2");
                            break;
                        case R.id.multipleSign:
                            Result = pNumber1 * pNumber2;
                            Log.d("Dispatch", "Multiple2");
                            break;
                        case R.id.divideSign:
                            Result = pNumber1 / pNumber2;
                            Log.d("Dispatch", "Divide2");

                            break;
                    }

                    Log.d("Result",String.valueOf(Result));

                    Intent intent = new Intent(this, SecondActivity.class);
                    intent.putExtra("Result", Result);
                    startActivity(intent);
                } else {

                    Log.d("Log","Error3");
                    mTextView.setText("数字を入力してください。");
                }

                break;
        }
    }
}
