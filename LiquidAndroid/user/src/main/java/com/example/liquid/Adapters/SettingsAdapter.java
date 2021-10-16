package com.example.liquid.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.liquid.Appearance;
import com.example.liquid.Models.SettingsModel;
import com.example.liquid.R;
import com.example.liquid.ViewModels.SettingsViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.zip.Inflater;

public class SettingsAdapter extends RecyclerView.Adapter<SettingsViewModel> {

    ArrayList<SettingsModel> list;
    Context context;

    public SettingsAdapter(ArrayList<SettingsModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public SettingsViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.settings_card_view, parent, false);
        return new SettingsViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SettingsViewModel holder, int position) {
        holder.textViewTtile.setText(list.get(position).getTitle());
        holder.drawableLeftImage.setImageResource(list.get(position).getDrawableLeft());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.textViewTtile.getText()=="Appearance") {
                    context.startActivity(new Intent(context, Appearance.class));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
