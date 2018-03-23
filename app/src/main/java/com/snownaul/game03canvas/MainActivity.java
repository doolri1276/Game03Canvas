package com.snownaul.game03canvas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));

//        getSupportActionBar().hide();
//
//        Window window=getWindow();
//        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


    }

}
