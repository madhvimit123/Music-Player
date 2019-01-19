package com.example.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button stop,play,pause;
    MediaPlayer mediaPlayer;
    int pauseposition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stop=findViewById(R.id.btn_stop);
        play=findViewById(R.id.btn_play);
        pause=findViewById(R.id.btn_pause);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.btn_play:
                if(mediaPlayer==null){
                mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.music);
                mediaPlayer.start();
                }
                else if(!mediaPlayer.isPlaying()){
                    mediaPlayer.seekTo(pauseposition);
                    mediaPlayer.start();
                }
                break;


            case R.id.btn_pause:
                if(mediaPlayer!=null){
                mediaPlayer.pause();
                pauseposition=mediaPlayer.getCurrentPosition();
                }
                break;

            case R.id.btn_stop:
                if(mediaPlayer!=null){
                mediaPlayer.stop();
                mediaPlayer=null;}
                break;
        }
    }
}
