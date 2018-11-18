package com.stepintoit.vkoth.calculatorapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.stepintoit.vkoth.calculatorapplication.data.MySharedPreference;
import com.stepintoit.vkoth.calculatorapplication.R;

public class CalculatorActivity extends AppCompatActivity {

    public static final int ADDITION = 1;
    public static final int MINUS = 2;
    public static final int MULTIPLY = 3;
    public static final int DIVISION = 4;

    Button btnPlus, btnMinus, btnDivision, btnMultiply;
    EditText edtResult;

    EditText edtValue1, edtValue2;

    private static double mValue1, mValue2;
    private static double mResult = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);


        btnPlus = (Button) findViewById(R.id.btn_plus);
        btnMinus = (Button) findViewById(R.id.btn_minus);
        btnMultiply = (Button) findViewById(R.id.btn_multiply);
        btnDivision = (Button) findViewById(R.id.btn_division);

        edtValue1 = (EditText) findViewById(R.id.edt_value1);
        edtValue2 = (EditText) findViewById(R.id.edt_value2);

        edtResult = (EditText) findViewById(R.id.edt_result);

        String valueX = MySharedPreference.getInstance(CalculatorActivity.this).getValue(MySharedPreference.KEY_X);
        String valueY = MySharedPreference.getInstance(CalculatorActivity.this).getValue(MySharedPreference.KEY_Y);

        edtValue1.setText(valueX);
        edtValue2.setText(valueY);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getResult(ADDITION);

            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getResult(MINUS);
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getResult(MULTIPLY);
            }
        });
        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getResult(DIVISION);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        MySharedPreference.getInstance(CalculatorActivity.this).putValue(MySharedPreference.KEY_X, edtValue1.getText().toString());
        MySharedPreference.getInstance(CalculatorActivity.this).putValue(MySharedPreference.KEY_Y, edtValue2.getText().toString());

    }

    public void getResult(int operation) {


        if ((edtValue1.getText().toString()).isEmpty() && (edtValue2.getText().toString()).isEmpty()) {
            Toast.makeText(getApplicationContext(), "Value of x and y can not be empty", Toast.LENGTH_SHORT).show();

        } else if ((edtValue1.getText().toString()).isEmpty()) {
            Toast.makeText(getApplicationContext(), "Value of x can not be empty", Toast.LENGTH_SHORT).show();

        } else if ((edtValue2.getText().toString()).isEmpty()) {
            Toast.makeText(getApplicationContext(), "Value of y can not be empty", Toast.LENGTH_SHORT).show();

        } else {

            mValue1 = Double.parseDouble(edtValue1.getText().toString());
            mValue2 = Double.parseDouble(edtValue2.getText().toString());

            if (operation == ADDITION)
                mResult = mValue1 + mValue2;
            else if (operation == MINUS)
                mResult = mValue1 - mValue2;
            else if (operation == MULTIPLY)
                mResult = mValue1 * mValue2;
            else if (operation == DIVISION)
                mResult = mValue1 / mValue2;

            edtResult.setText(Double.toString(mResult));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itm_logout:


                MySharedPreference.getInstance(CalculatorActivity.this).deleteValue(MySharedPreference.KEY_TOKEN);
                //MySharedPreference.getInstance(CalculatorActivity.this).deleteValue(MySharedPreference.KEY_PASSWORD);
                startActivity(new Intent(CalculatorActivity.this, LoginActivity.class));
                finish();
                return true;
        }
        return (super.onOptionsItemSelected(item));
    }
}