package com.epicsoft.mybraintrainer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Ovidiu on 9/9/2017.
 */

public class ScoreActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        int time = getIntent().getIntExtra("TIME", 0);
        int score = getIntent().getIntExtra("SCORE", 0);
        int scoreMax = getIntent().getIntExtra("SCORE_MAX", 0);

        TextView resultsTv = (TextView) findViewById(R.id.tv_results);
        resultsTv.setText(score + " out of " + scoreMax + " in " + time + " seconds!");

    }

    public void playAgain(View view){
        Intent intent = new Intent(getApplicationContext(), GameActivity.class);
        startActivity(intent);
    }
}
