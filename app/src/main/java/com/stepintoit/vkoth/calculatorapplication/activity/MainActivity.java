package com.stepintoit.vkoth.calculatorapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.stepintoit.vkoth.calculatorapplication.data.MySharedPreference;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(MainActivity.this, ProductActivity.class));

//        Thread timer=new Thread()
//        {
//            public void run() {
//                try {
//                    sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                finally
//                {
//
//                   String token = MySharedPreference.getInstance(MainActivity.this).getValue(MySharedPreference.KEY_TOKEN);
//                  // String password = MySharedPreference.getInstance(MainActivity.this).getValue(MySharedPreference.KEY_PASSWORD);
//                    if(token.isEmpty())
//                    {
//                        startActivity(new Intent(MainActivity.this,LoginActivity.class));
//                    }
//
//                    else {
//                        startActivity(new Intent(MainActivity.this, ProductActivity.class));
//
//                    }
//                    finish();
//                }
//            }
//        };
//        timer.start();
        }
}