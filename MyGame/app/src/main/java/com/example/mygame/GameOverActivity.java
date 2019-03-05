package com.example.mygame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelayout);
        Intent i=getIntent();
        this.setContentView(R.layout.gameover);
        ImageView bg_img = findViewById(R.id.overbg);
        int r = (int)(Math.random()*(10));
        if(r<=3){
            bg_img.setImageResource(R.drawable.bg_green);
        }
        else if(r>3&&r<=6) {
            bg_img.setImageResource(R.drawable.bg_blue);
        }
        else if(r>=7) {
            bg_img.setImageResource(R.drawable.bg_grey);
        }
        int score = i.getIntExtra("score",0);
        String finalscore = "your highest score:" + score;
        ((TextView)findViewById(R.id.FINALSCORE)).setText(finalscore);
    }

    public  void restart(View view){
        Intent intent = new Intent(GameOverActivity.this,GameActivity.class);
        startActivity(intent);
        GameOverActivity.this.finish();
    }

    public void returntomenu(View view) {
        Intent intent = new Intent(GameOverActivity.this,MainActivity.class);
        startActivity(intent);
        GameOverActivity.this.finish();
    }
}
