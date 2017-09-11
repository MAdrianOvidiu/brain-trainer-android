package com.epicsoft.mybraintrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button goBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goBtn = (Button) findViewById(R.id.btn_go);
    }

    public void go(View view){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}
