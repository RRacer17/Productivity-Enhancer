package com.example.myapplicationx;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TimerActivity extends AppCompatActivity {
    SeekBar timer_sb;
    TextView timer_tv;
    Button start_btn;
    CountDownTimer countDownTimer;
    Boolean counterIsActive = false;
//    Button td_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeractivity);
        timer_sb = findViewById(R.id.timer_sb);
        timer_tv = findViewById(R.id.timer_tv);
        start_btn = findViewById(R.id.start_btn);
        Button td_btn = (Button) findViewById(R.id.td_btn);
//        td_btn = findViewById(R.id.td_btn);
        timer_sb.setMax(3600);
        timer_sb.setProgress(60);
        timer_sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                update(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        td_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tdls();
            }
        });
    }

    public void start_timer(View view) {
        if (!counterIsActive) {
            counterIsActive = (true);
            timer_sb.setEnabled(false);
            start_btn.setText("STOP");

            countDownTimer = new CountDownTimer(timer_sb.getProgress() * 1000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    update((int) millisUntilFinished / 1000);
                }

                @Override
                public void onFinish() {
                    reset();
                }
            }.start();
        } else {
            reset();
        }
    }

    private void reset() {
        timer_tv.setText("0:60");
        timer_sb.setProgress(60);
        countDownTimer.cancel();
        start_btn.setText("START");
        timer_sb.setEnabled(true);
        counterIsActive = false;
    }

    private void update(int progress) {
        int minutes = progress / 60;
        int seconds = progress % 60;
        String secondsFinal = "";
        if (seconds <= 9) {
            secondsFinal = "0" + seconds;
        } else {
            secondsFinal = "" + seconds;
        }
        // Update the SeekBar and TextView
        timer_sb.setProgress(progress);
        timer_tv.setText("" + minutes + ":" + secondsFinal);
    }

    // In onPause() and onDestroy(), if the counterIsActive flag is true,
    // cancel countDownTimer.
    @Override
    protected void onPause() {
        super.onPause();
        if (counterIsActive) {
            countDownTimer.cancel();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (counterIsActive) {
            countDownTimer.cancel();
        }
    }

    public void tdls() {
        Intent td = new Intent(this, AddLists.class);
        startActivity(td);
    }
}