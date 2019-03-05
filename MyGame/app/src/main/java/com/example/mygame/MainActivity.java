package com.example.mygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.view.View;
import android.support.v7.app.AlertDialog;
import android.content.DialogInterface;




public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView bg_img = findViewById(R.id.BG);
        int r = (int)(Math.random()*(10));
        if(r<=3){
            bg_img.setImageResource(R.drawable.bg_green_game);
        }
        else if(r>3&&r<=6) {
            bg_img.setImageResource(R.drawable.bg_blue_game);
        }
        else if(r>=7) {
            bg_img.setImageResource(R.drawable.bg_grey_game);
        }
    }


    public void onStart(View view) {
        Intent intent = new Intent(MainActivity.this,GameActivity.class);
        startActivity(intent);
        MainActivity.this.finish();
    }

    public void onExit(View view) {
        AlertDialog.Builder alertdialogbuilder=new AlertDialog.Builder(this);
        alertdialogbuilder.setMessage("您确认要退出程序");
        alertdialogbuilder.setPositiveButton("确定", click1);
        alertdialogbuilder.setNegativeButton("取消", click2);
        AlertDialog alertdialog1=alertdialogbuilder.create();
        alertdialog1.show();
    }

    private DialogInterface.OnClickListener click1=new DialogInterface.OnClickListener()
    {
        @Override
        public void onClick(DialogInterface arg0,int arg1)
        { android.os.Process.killProcess(android.os.Process.myPid()); }
    };

    private DialogInterface.OnClickListener click2=new DialogInterface.OnClickListener()
    {
        @Override
        public void onClick(DialogInterface arg0,int arg1)
        {
            arg0.cancel();
        }
    };

}
