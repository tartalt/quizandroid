package com.example.myapplicationf;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Score extends AppCompatActivity {

    TextView tvscore;
    ProgressBar pb;
    Button rtry, logout;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        tvscore=findViewById(R.id.tvscore);
        pb=findViewById(R.id.pbar);
        rtry=findViewById(R.id.button2);
        logout=findViewById(R.id.button);
        Intent i1=getIntent();
        score=i1.getIntExtra("score",0);
        tvscore.setText(score*100/5 +"%");
        pb.setProgress(score*100/5);
        rtry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(getApplicationContext(),Quiz1.class);
                startActivity(i2);
                finish();
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3=new Intent(Score.this,MainActivity.class);
                startActivity(i3);
                finish();
            }
        });


    }
}