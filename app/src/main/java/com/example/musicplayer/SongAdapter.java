package com.example.musicplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<SongInfor> arraySongs;

    public SongAdapter(Context context, int layout, ArrayList<SongInfor> arraySongs) {
        this.context = context;
        this.layout = layout;
        this.arraySongs = arraySongs;
    }

    @Override
    public int getCount() {
        return arraySongs.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = new ViewHolder();
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.txtName = view.findViewById(R.id.txtName);
            holder.txtArtist = view.findViewById(R.id.txtArtist);

            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }

        SongInfor song = arraySongs.get(i);
        holder.txtName.setText(song.getName());
        holder.txtArtist.setText(song.getArtist());

        return view;
    }
    private class ViewHolder {
        TextView txtName;
        TextView txtArtist;
    }
}
