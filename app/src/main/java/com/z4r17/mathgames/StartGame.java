package com.z4r17.mathgames;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StartGame extends AppCompatActivity {

    int op1, op2 ,sum;
    TextView tvTimer, tvPoints, tvSum, tvResult;
    Button btn0,btn1,btn2,btn3;
    CountDownTimer countDownTimer;
    long millisUntilFinished;
    int points, numberofQuestions;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_game);

        op1 = 0;
        op2 = 0;
        sum= 0;

        tvTimer = findViewById(R.id.tvTimer);
        tvPoints = findViewById(R.id.tvPoints);
        tvSum = findViewById(R.id.tvSum);
        tvResult = findViewById(R.id.tvResult);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        millisUntilFinished = 30100;
        points = 0;
        numberofQuestions =0;
        startGame();
    }

    private void startGame() {

        tvTimer.setText(""+ (millisUntilFinished/ 1000) + "s");
        tvPoints.setText(""+points+"/"+ numberofQuestions);
        countDownTimer = new CountDownTimer(millisUntilFinished,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvTimer.setText("" + (millisUntilFinished/ 1000) + "s");
            }

            @Override
            public void onFinish() {
                btn0.setClickable(false);
                btn1.setClickable(false);
                btn2.setClickable(false);
                btn3.setClickable(false);

            }
        }.start();


    }
}


