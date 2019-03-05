package com.example.mygame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

class My_pic{
    public String[] name = new String[17];
    public int[] pic = new int[17];
    public My_pic(){
        pic[0] = R.drawable.wolf;
        pic[1] = R.drawable.bee;
        pic[2] = R.drawable.cat;
        pic[3] = R.drawable.elephant;
        pic[4] = R.drawable.fish;
        pic[5] = R.drawable.flower;
        pic[6] = R.drawable.giraffe;
        pic[7] = R.drawable.house;
        pic[8] = R.drawable.hypo;
        pic[9] = R.drawable.kangaroo;
        pic[10] = R.drawable.leo;
        pic[11] = R.drawable.lion;
        pic[12] = R.drawable.pig;
        pic[13] = R.drawable.rhino;
        pic[14] = R.drawable.smile;
        pic[15] = R.drawable.sun;
        pic[16] = R.drawable.tiger;
        name[0] = "wolf";
        name[1] = "bee";
        name[2] = "cat";
        name[3] = "elephant";
        name[4] = "fish";
        name[5] = "flower";
        name[6] = "giraffe";
        name[7] = "house";
        name[8] = "hypo";
        name[9] = "kangaroo";
        name[10] = "leo";
        name[11] = "lion";
        name[12] = "pig";
        name[13] = "rhino";
        name[14] = "smile";
        name[15] = "sun";
        name[16] = "tiger";
    }
};

public class GameActivity extends AppCompatActivity {

    My_pic m_pic = new My_pic();
    public static int one,two,three,four;
    public static String correctname;
    public static int score = 0;
    public static int highestscore = 0;

    public void randbg(){
        ImageView bg_img = findViewById(R.id.gameBG);
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
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelayout);
        Intent i=getIntent();
        randbg();
        randnum();
        setpic();
        highestscore = 0;
        score = 0;
    }

    public void randnum() {
        int[] soursenum = new int[17];
        for(int i = 0;i<17;i++){
            soursenum[i] = i;
        }
        int[] resultnum = new int[4];
        for(int i = 0;i<4;i++) {
            int seed = (int)(Math.random()*(17));
            resultnum[i] = soursenum[seed];
            soursenum[seed] = soursenum[soursenum.length - i-1];
        }
        one = resultnum[0];
        two = resultnum[1];
        three = resultnum[2];
        four = resultnum[3];
    }

    public void setpic() {
        randnum();
        Button pic1 = findViewById(R.id.PIC1);
        Button pic2 = findViewById(R.id.PIC2);
        Button pic3 = findViewById(R.id.PIC3);
        Button pic4 = findViewById(R.id.PIC4);
        pic1.setBackgroundResource(m_pic.pic[one]);
        pic2.setBackgroundResource(m_pic.pic[two]);
        pic3.setBackgroundResource(m_pic.pic[three]);
        pic4.setBackgroundResource(m_pic.pic[four]);
        int correctnum = (int)(Math.random()*4);
        switch (correctnum){
            case 0:correctname = m_pic.name[one];break;
            case 1:correctname = m_pic.name[two];break;
            case 2:correctname = m_pic.name[three];break;
            case 3:correctname = m_pic.name[four];break;
        }
        ((TextView)findViewById(R.id.HINT)).setText(correctname);
    }

    public  void setHighestscore(){
        if(score>highestscore)
            highestscore = score;
    }

    public void choose1(View view){
        if(m_pic.name[one]==correctname){
            score += 1000;
            setHighestscore();
        }
        else{
            score -= 1500;
            if(score<0) {
                Intent intent = new Intent(GameActivity.this,GameOverActivity.class);
                intent.putExtra("score",highestscore);
                startActivity(intent);
                GameActivity.this.finish();
            }
        }
        randbg();
        String scoretext = "your score:" + score;
        ((TextView)findViewById(R.id.SCORE)).setText(scoretext);
        setpic();
    }

    public void choose2(View view){
        if(m_pic.name[two]==correctname){
            score += 1000;
            setHighestscore();
        }
        else{
            score -= 1500;
            if(score<0) {
                Intent intent = new Intent(GameActivity.this,GameOverActivity.class);
                intent.putExtra("score",highestscore);
                startActivity(intent);
                GameActivity.this.finish();
            }
        }
        randbg();
        String scoretext = "your score:" + score;
        ((TextView)findViewById(R.id.SCORE)).setText(scoretext);
        setpic();
    }

    public void choose3(View view){
        if(m_pic.name[three]==correctname){
            score += 1000;
            setHighestscore();
        }
        else{
            score -= 1500;
            if(score<0) {
                Intent intent = new Intent(GameActivity.this,GameOverActivity.class);
                intent.putExtra("score",highestscore);
                startActivity(intent);
                GameActivity.this.finish();
            }
        }
        randbg();
        String scoretext = "your score:" + score;
        ((TextView)findViewById(R.id.SCORE)).setText(scoretext);
        setpic();
    }

    public void choose4(View view){
        if(m_pic.name[four]==correctname){
            score += 1000;
            setHighestscore();
        }
        else{
            score -= 1500;
            if(score<0) {
                Intent intent = new Intent(GameActivity.this,GameOverActivity.class);
                intent.putExtra("score",highestscore);
                startActivity(intent);
                GameActivity.this.finish();
            }
        }
        randbg();
        String scoretext = "your score:" + score;
        ((TextView)findViewById(R.id.SCORE)).setText(scoretext);
        setpic();
    }
}
