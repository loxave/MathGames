package com.z4r17.mathgames;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GameOver extends AppCompatActivity {

    TextView tvPoints;
    SharedPreferences sharedPreferences;
    ImageView ivHighScore;
    TextView tvHighScore;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);
        getSupportActionBar().hide();
        int points = getIntent().getExtras().getInt("points");
        tvHighScore = findViewById(R.id.tvHighScore);
        ivHighScore = findViewById(R.id.ivHighScore);
        tvPoints = findViewById(R.id.tvPoints);
        sharedPreferences = getSharedPreferences("pref",0);
        int pointsSP = sharedPreferences.getInt("pointsSP",0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (points > pointsSP){
            points =  points;
            editor.putInt("pointsSP",pointsSP);
            editor.commit();

        }
        tvPoints.setText("" + points);
        tvHighScore.setText(""  + pointsSP);
    }

    public void restart(View view) {
        Intent intent = new Intent(GameOver.this, StartGame.class);
        startActivity(intent);
        finish();
    }

    public void exit(View view) {

        finish();

    }
}
