package com.example.dell.jsondata;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


/**
 * Created by dell on 2/26/2017.
 */

public class CustomeArrayAdapter extends ArrayAdapter {
    private List<MovieModel> moviemodelList;
    private int resource;
    private Context context;

    public CustomeArrayAdapter(Context context, int resource, List<MovieModel> moviemodelList) {
        super(context, resource, moviemodelList);
        this.context = context;
        this.resource = resource;
        this.moviemodelList = moviemodelList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MovieModel detail = moviemodelList.get(position);
        View view = LayoutInflater.from(context).inflate(resource, parent, false);
        TextView movie_name = (TextView) view.findViewById(R.id.textView);
        ImageView image = (ImageView) view.findViewById(R.id.imageView);
        movie_name.setText(detail.getOriginal_title());
        Glide.with(context).load("https://image.tmdb.org/t/p/w500/" + detail.getPoster_path()).into(image);
        return view;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return moviemodelList.get(position);
    }
}
