package com.example.myapplicationf;

import android.os.Bundle;
import android.content.Intent;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class Quiz1 extends AppCompatActivity {
 RadioGroup rg;
    RadioButton rb;
    Button next;
    int score;
    int time=30;
    private long startTime;
    TextView timerA;
    CountDownTimer timer;
    Long secondesrestantes=null;
        boolean answered = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);
        rg = findViewById(R.id.rg);
        next = findViewById(R.id.button);
        timerA = findViewById(R.id.timerA);
        startTimer();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rg.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(Quiz1.this, "Veuiller choisir une réponse", Toast.LENGTH_SHORT).show();
                }else {
                    if (timer != null) {
                        timer.cancel();
                    }
                    if (!answered) {
                        rb = findViewById(rg.getCheckedRadioButtonId());
                        if (rb.getId() == R.id.radioButton1) {
                            if (secondesrestantes <= 5) {
                                score += 2;
                                Intent i1 = new Intent(getApplicationContext(), Quiz2.class);
                                i1.putExtra("score", score);
                                startActivity(i1);
                                finish();
                                answered = true;
                            }
                            score += 1;
                            Intent i1 = new Intent(getApplicationContext(), Quiz2.class);
                            i1.putExtra("score", score);
                            startActivity(i1);
                            finish();
                            answered = true;
                        }
                    }
                }
            }
        });
    }
        private void startTimer() {
            timer = new CountDownTimer(30000, 1000) { // 60 secondes
                @Override
                public void onTick(long millisUntilFinished) {
                    // Update the timer TextView with remaining time
                    long secondsRemaining = millisUntilFinished / 1000;
                    timerA.setText("Il vous reste: 0:" + secondsRemaining + "sec");
                    if (secondsRemaining>=25){
                         secondesrestantes =secondsRemaining;
                    }
                }

                @Override
                public void onFinish() {
                    // Handle when the timer finishes (user didn't answer in time)
                    Toast.makeText(Quiz1.this, "Temps écoulé!", Toast.LENGTH_SHORT).show();
                    // Move to the next question even if the user didn't answer
                    Intent i2 = new Intent(getApplicationContext(), Score.class);
                    i2.putExtra("score", score);
                    startActivity(i2);
                    finish();
                }
            };
            timer.start();
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            if (timer != null) {
                timer.cancel();
            }
        }
    }