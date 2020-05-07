package com.example.stopwatchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchAct extends AppCompatActivity {

    Button btnstart;
    Button btnstop;
    ImageView icanchor;
    Animation roundingalone;
    Chronometer timerhere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        btnstart = findViewById(R.id.btnstart);
        btnstop = findViewById(R.id.btnstop);
        icanchor = findViewById(R.id.icanchor);
        timerhere = findViewById(R.id.timerHere);

        btnstop.setAlpha(0);

        //import animation
        roundingalone = AnimationUtils.loadAnimation(this, R.anim.roundingalone);

        //import font chứ
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");

        //custom font chữ
        btnstart.setTypeface(MMedium);
        btnstop.setTypeface(MMedium);

        //event btnstart
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start animation
                icanchor.startAnimation(roundingalone);
                btnstop.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnstart.animate().alpha(0).setDuration(300).start();
                //start time
                timerhere.setBase(SystemClock.elapsedRealtime());
                timerhere.start();
            }
        });

        //event btnstop
        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icanchor.clearAnimation();
                timerhere.stop();
            }
        });

    }
}


