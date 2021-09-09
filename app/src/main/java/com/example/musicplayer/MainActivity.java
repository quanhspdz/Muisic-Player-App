package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvSongs;
    SongAdapter songAdapter;
    ArrayList<SongInfor> arraySongs;
    int currentSongIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvSongs = findViewById(R.id.lvSongs);

        addToArray();
        MusicControl.setArraySongs(arraySongs);

        songAdapter = new SongAdapter(MainActivity.this, R.layout.each_row_item, arraySongs);
        lvSongs.setAdapter(songAdapter);

        lvSongs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MusicControl.playSongList(i, MainActivity.this, arraySongs);
                currentSongIndex = i;

                SongInfor song = arraySongs.get(i);
                Intent intent = new Intent(MainActivity.this, Music_player_activity.class);
                intent.putExtra("currentSong", song);
                startActivity(intent);
            }
        });
    }

    private void addToArray() {
        arraySongs = new ArrayList<>();
        arraySongs.add(new SongInfor("Popstar", "K/DA - Riot games", "69:96", R.raw.kda_popstar));
        arraySongs.add(new SongInfor("More", "K/DA - Riot games", "69:96", R.raw.kda_more));
        arraySongs.add(new SongInfor("The Baddest", "K/DA - Riot games", "69:96", R.raw.kda_thebaddest));
        arraySongs.add(new SongInfor("Drum Go Dum", "K/DA - Riot games", "69:96", R.raw.kda_drumgodum));
        arraySongs.add(new SongInfor("Rise", "Riot games", "69:96", R.raw.rise));
        arraySongs.add(new SongInfor("Legend never die", "Riot games", "69:96", R.raw.legendneverdie));
        arraySongs.add(new SongInfor("Warriors", "Riot games", "69:96", R.raw.warriors_old));
        arraySongs.add(new SongInfor("Warriors - 2020", "Riot games", "69:96", R.raw.warriors_2020));
        arraySongs.add(new SongInfor("Phoenix", "Riot games", "69:96", R.raw.phoenix));
        arraySongs.add(new SongInfor("Take over", "Riot games", "69:96", R.raw.takeover));
        arraySongs.add(new SongInfor("Awaken", "Riot games", "69:96", R.raw.awaken));
        arraySongs.add(new SongInfor("Ignite", "Riot games", "69:96", R.raw.ignite));
        arraySongs.add(new SongInfor("Giants", "True damage - Riot games", "69:96", R.raw.truedamage_giants));
    }
}