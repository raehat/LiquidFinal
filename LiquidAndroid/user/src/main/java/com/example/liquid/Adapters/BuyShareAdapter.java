package com.example.liquid.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.liquid.DetailsBuyShare;
import com.example.liquid.Models.BuyShareModel;
import com.example.liquid.R;
import com.example.liquid.ViewModels.BuyShareViewModel;

import java.util.ArrayList;

public class BuyShareAdapter extends RecyclerView.Adapter<BuyShareViewModel> {

    ArrayList<BuyShareModel> list;
    Context context;

    public BuyShareAdapter(ArrayList<BuyShareModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public BuyShareViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view= layoutInflater.inflate(R.layout.buy_card_view, parent, false);
        return new BuyShareViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final BuyShareViewModel holder, int position) {
        holder.corpName.setText(list.get(position).getCorpName());
        holder.companyName.setText(list.get(position).getCompanyName());
        holder.sharePrice.setText(String.valueOf(list.get(position).getSharePrice()));
        holder.changeInPrice.setText("₹" + String.valueOf(list.get(position).getChangeInPrice()));
        if (list.get(position).getChangeInPrice()>0) {
            holder.changeInPrice.setTextColor(Color.parseColor("#00ed00"));
        } else {
            holder.changeInPrice.setTextColor(Color.parseColor("#e00000"));
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsBuyShare.class);
                intent.putExtra("BuyOrSell", "" + list.get(position).getBuyOrSell());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
