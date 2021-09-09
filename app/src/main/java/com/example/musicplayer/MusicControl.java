package com.example.musicplayer;

import android.content.Context;
import android.media.MediaPlayer;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MusicControl {
    public static MediaPlayer musicPlayer;
    public static int currentSongIndex;
    public static int nextSongIndex;
    public static ArrayList<SongInfor> arraySongs;
    public static SongInfor currentSong;
    public static TextView txtSongName;

    public static void setTxtSongName(TextView txtSongName) {
        MusicControl.txtSongName = txtSongName;
    }

    public static void setArraySongs(ArrayList<SongInfor> arraySongs) {
        MusicControl.arraySongs = arraySongs;
    }

    public static void setMusicPlayer(Context context, int resource) {
        if (musicPlayer.isPlaying()) musicPlayer.stop();
        musicPlayer = MediaPlayer.create(context, resource);
    }

    public static void playSongList(int currentIndex, Context context, ArrayList<SongInfor> arraySongs) {
        if (musicPlayer != null)
            musicPlayer.reset();

        MusicControl.currentSongIndex = currentIndex;

        SongInfor song = arraySongs.get(currentSongIndex);
        currentSong = song;
        musicPlayer = MediaPlayer.create(context, song.getResource());
        musicPlayer.start();

        if (currentSongIndex + 1 < arraySongs.size()) nextSongIndex = currentSongIndex + 1;
        else nextSongIndex = 0;

        musicPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                playSongList(nextSongIndex, context, arraySongs);
            }
        });
    }

    public static void playNextSong(Context context) {
        if (currentSongIndex + 1 < arraySongs.size()) nextSongIndex = currentSongIndex + 1;
        else nextSongIndex = 0;

        playSongList(nextSongIndex, context, arraySongs);
    }

    public static void playPrevSong(Context context) {
        if (currentSongIndex - 1 >= 0) nextSongIndex = currentSongIndex  - 1;
        else nextSongIndex = arraySongs.size() - 1;

        playSongList(nextSongIndex, context, MusicControl.arraySongs);
    }
}
