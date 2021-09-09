package com.example.musicplayer;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SmallSongNameControl {
    public static TextView txtSmallSongName;
    public static TextView txtSmallSongArtist;
    public static ImageView btnSmallPlay;
    public static boolean viewIsAssigned = false;
    public static boolean isPlaying = false;

    public static void assignView(View view, int idTxtName, int idTxtArtist, int idImagePlay) {
        txtSmallSongArtist = view.findViewById(idTxtArtist);
        txtSmallSongName = view.findViewById(idTxtName);
        btnSmallPlay = view.findViewById(idImagePlay);
        viewIsAssigned = true;
    }
    public static void setTextView(String songName, String artist) {
        if (viewIsAssigned) {
            txtSmallSongName.setText(songName);
            txtSmallSongArtist.setText(artist);
        }
    }
}
