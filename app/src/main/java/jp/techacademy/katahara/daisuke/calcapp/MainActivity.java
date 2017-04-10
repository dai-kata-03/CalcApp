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
    EditText mEditText1; // 数値1
    EditText mEditText2; // 数値2
    TextView mTextView; // 第一画面のエラーメッセージ
    double Result; // 計算結果
    int CalcSign = 0; // 計算記号の保存
    String NumValue; // 計算に進む前のエラーチェック

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
        mEditText1.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_NUMBER_FLAG_DECIMAL); // マイナス、小数点入力あり

        mEditText2 = (EditText) findViewById(R.id.number2);
        mEditText2.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_NUMBER_FLAG_DECIMAL); // マイナス、小数点入力あり

        mTextView = (TextView) findViewById(R.id.message);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.addSign:
                CalcSign = v.getId();
                ((EditText)findViewById(R.id.number2)).requestFocus(); // 計算記号選択後、数値2へカーソルを移動させる
                break;

            case R.id.deductSign:
                CalcSign = v.getId();
                ((EditText)findViewById(R.id.number2)).requestFocus(); // 計算記号選択後、数値2へカーソルを移動させる
                break;

            case R.id.multipleSign:
                CalcSign = v.getId();
                ((EditText)findViewById(R.id.number2)).requestFocus(); // 計算記号選択後、数値2へカーソルを移動させる
                break;

            case R.id.divideSign:
                CalcSign = v.getId();
                ((EditText)findViewById(R.id.number2)).requestFocus(); // 計算記号選択後、数値2へカーソルを移動させる
                break;

            case R.id.CalcButton:

                String para1 = mEditText1.getText().toString();
                String para2 = mEditText2.getText().toString();

                if (CalcSign == 0) {
                    mTextView.setText("計算記号を指定してください。");
                } else {

                    NumValue = "";

                    if (para1 == null || para1.length() == 0 || para2 == null || para2.length() == 0) {
                        NumValue = "Error";
                    } else {
                        NumValue = "GoToNext";
                    }

                    // 数値フィールドがNULLでも空でもない場合のみ、処理を先に進める。

                    if (NumValue == "GoToNext") {


                        double pNumber1 = Double.valueOf(para1);
                        double pNumber2 = Double.valueOf(para2);

                        switch (CalcSign) {
                            case R.id.addSign:
                                Result = pNumber1 + pNumber2;
                                break;
                            case R.id.deductSign:
                                Result = pNumber1 - pNumber2;
                                break;
                            case R.id.multipleSign:
                                Result = pNumber1 * pNumber2;
                                break;
                            case R.id.divideSign:
                                Result = pNumber1 / pNumber2;
                                break;
                        }

                        Intent intent = new Intent(this, SecondActivity.class);
                        intent.putExtra("Result", Result);
                        startActivity(intent);
                    } else {
                        mTextView.setText("数字を入力してください。");
                    }
                    break;
                }
        }

    }
}