package com.example.liquid.ViewModels;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.liquid.R;

public class SettingsViewModel extends RecyclerView.ViewHolder {

    public ImageView drawableLeftImage;
    public TextView textViewTtile;

    public SettingsViewModel(@NonNull View itemView) {
        super(itemView);
        drawableLeftImage = itemView.findViewById(R.id.drawableLeft_image);
        textViewTtile = itemView.findViewById(R.id.text_view_title);
    }
}
