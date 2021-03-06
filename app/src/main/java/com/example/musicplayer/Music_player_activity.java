package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import java.text.SimpleDateFormat;

public class Music_player_activity extends AppCompatActivity {
    ImageButton btnPlay, btnPrev, btnNext;
    ImageView imgDisc;
    TextView txtCurrentPos, txtDuration, txtSongname, txtArtist;
    public static SeekBar seekbarMusic;
    Animation discAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        assignment();

        if (MusicControl.musicPlayer != null) {
            setSongText();
            if (MusicControl.musicPlayer.isPlaying()) btnPlay.setImageResource(R.drawable.pause_new_small);
            setSeekBarProgress(seekbarMusic);
        }



        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MusicControl.musicPlayer.isPlaying()) {
                    btnPlay.setImageResource(R.drawable.play_new_small);
                    SmallSongNameControl.btnSmallPlay.setImageResource(R.drawable.play);
                    MusicControl.musicPlayer.pause();
                }
                else {
                    btnPlay.setImageResource(R.drawable.pause_new_small);
                    SmallSongNameControl.btnSmallPlay.setImageResource(R.drawable.pause);
                    MusicControl.musicPlayer.start();
                    setSeekBarProgress(seekbarMusic);
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MusicControl.playNextSong(Music_player_activity.this);
                btnPlay.setImageResource(R.drawable.pause_new_small);
                SmallSongNameControl.btnSmallPlay.setImageResource(R.drawable.pause);
                setSongText();
                setSeekBarProgress(seekbarMusic);
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MusicControl.playPrevSong(Music_player_activity.this);
                btnPlay.setImageResource(R.drawable.pause_new_small);
                SmallSongNameControl.btnSmallPlay.setImageResource(R.drawable.pause);
                setSongText();
                setSeekBarProgress(seekbarMusic);
            }
        });

        seekbarMusic.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) MusicControl.musicPlayer.seekTo(i);

                int time = MusicControl.musicPlayer.getCurrentPosition();
                SimpleDateFormat timeFormat = new SimpleDateFormat("mm:ss");
                String strTime = timeFormat.format(time);
                txtCurrentPos.setText(strTime);
                txtDuration.setText(timeFormat.format(MusicControl.musicPlayer.getDuration()));
                setSongText();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public static void setSeekBarProgress(SeekBar seekbarMusic) {
        seekbarMusic.setMax(MusicControl.musicPlayer.getDuration());
        Handler videoHandler = new Handler();
        videoHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (MusicControl.musicPlayer != null) {
                    seekbarMusic.setProgress(MusicControl.musicPlayer.getCurrentPosition());
                    if (seekbarMusic.getProgress() != seekbarMusic.getMax())
                        setSeekBarProgress(seekbarMusic);
                }
            }
        }, 100);
    }

    private void setSongText() {
        SongInfor song = MusicControl.currentSong;
        txtSongname.setText(song.getName());
        txtArtist.setText(song.getArtist());
    }

    private void assignment() {
        txtSongname = findViewById(R.id.txtSongName);
        txtDuration = findViewById(R.id.txtDuration);
        txtCurrentPos = findViewById(R.id.txtCurrentPos);
        txtArtist = findViewById(R.id.txtFullArtist);

        btnNext = findViewById(R.id.btnNext);
        btnPlay = findViewById(R.id.btnPlay);
        btnPrev = findViewById(R.id.btnPrev);

        discAnimation = AnimationUtils.loadAnimation(Music_player_activity.this, R.anim.disc_anim);

        imgDisc = findViewById(R.id.imgDisc);

        seekbarMusic = findViewById(R.id.seekBar);
    }
}