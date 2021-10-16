package com.example.admin.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.admin.DetailsBuyShare;
import com.example.admin.Models.ShareModel;
import com.example.admin.R;
import com.example.admin.ViewModels.ShareViewModel;

import java.util.ArrayList;

public class ShareAdapter extends RecyclerView.Adapter<ShareViewModel> {

    ArrayList<ShareModel> list;
    Context context;

    public ShareAdapter(ArrayList<ShareModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ShareViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view= layoutInflater.inflate(R.layout.share_card_view, parent, false);
        return new ShareViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ShareViewModel holder, int position) {
        holder.corpName.setText(list.get(position).getCorpName());
        holder.companyName.setText(list.get(position).getCompanyName());
        holder.noOfPeople.setText(String.valueOf(list.get(position).getNoOfPeople()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsBuyShare.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
