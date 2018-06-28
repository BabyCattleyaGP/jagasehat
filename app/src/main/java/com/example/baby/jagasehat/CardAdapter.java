package com.example.baby.jagasehat;

import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class CardAdapter extends ArrayAdapter<Integer> {

    public CardAdapter (Context context, int resources){
        super(context, resources);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ImageView imgView = (ImageView)convertView.findViewById(R.id.image_content);
        imgView.setImageResource(getItem(position));
        return convertView;
    }

}
