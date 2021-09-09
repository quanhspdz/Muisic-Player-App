package com.example.musicplayer;

import java.io.Serializable;

public class SongInfor implements Serializable {
    private String name;
    private String artist;
    private String duration;
    private int resource;

    public SongInfor(String name, String artist, String duration, int resource) {
        this.name = name;
        this.artist = artist;
        this.duration = duration;
        this.resource = resource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }
}
