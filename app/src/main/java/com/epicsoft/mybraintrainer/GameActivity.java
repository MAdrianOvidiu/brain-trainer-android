package com.epicsoft.mybraintrainer;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ovidiu on 9/7/2017.
 */

public class GameActivity extends AppCompatActivity {
    ArrayList<Integer> answersList = new ArrayList<>();
    int correctIndex;
    int score = 0;
    int scoreMax = 0;
    long time = 30100;
    TextView resultTv;
    TextView pointsTv;
    TextView sumTv;
    TextView timerTv;
    Button button0;
    Button button1;
    Button button2;
    Button button3;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        sumTv = (TextView) findViewById(R.id.tv_sum);
        resultTv = (TextView) findViewById(R.id.tv_result);
        pointsTv = (TextView) findViewById(R.id.tv_points);
        timerTv = (TextView) findViewById(R.id.tv_timer);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        generateQuestion();
        new CountDownTimer(time, 1000){
            @Override
            public void onTick(long l) {
                timerTv.setText(String.valueOf(l/1000) + "s");
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(getApplicationContext(), ScoreActivity.class);
                intent.putExtra("TIME", (int) time / 1000);
                intent.putExtra("SCORE", score);
                intent.putExtra("SCORE_MAX", scoreMax);
                startActivity(intent);
                //resultTv.setText("Your score is: " + score + "/" + scoreMax);

            }
        }.start();


    }

    public void answer(View view){
        if(view.getTag().toString().equals(Integer.toString(correctIndex))){
            score++;
            resultTv.setText("Correct");
        }else {

            resultTv.setText("Incorrect");
        }
        scoreMax++;
        pointsTv.setText(score + "/" + scoreMax);
        generateQuestion();


    }

    public void generateQuestion(){
        answersList.clear();
        Random rand = new Random();
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);
        int incorrectAnswer;
        sumTv.setText(a + " + " + b);

        correctIndex = rand.nextInt(4);
        for (int i = 0; i < 4; i++){
            if (i == correctIndex){
                answersList.add(a + b);
            }else {
                incorrectAnswer = rand.nextInt(41);
                while(incorrectAnswer == a + b){
                    incorrectAnswer = rand.nextInt(41);
                }
                answersList.add(incorrectAnswer);
            }
        }

        button0.setText(Integer.toString(answersList.get(0)));
        button1.setText(Integer.toString(answersList.get(1)));
        button2.setText(Integer.toString(answersList.get(2)));
        button3.setText(Integer.toString(answersList.get(3)));
    }
}
