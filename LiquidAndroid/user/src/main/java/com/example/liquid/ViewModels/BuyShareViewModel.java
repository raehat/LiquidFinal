package com.example.liquid.ViewModels;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.liquid.R;

public class BuyShareViewModel extends RecyclerView.ViewHolder {

    public TextView corpName, companyName, sharePrice, changeInPrice;

    public BuyShareViewModel(@NonNull View itemView) {
        super(itemView);
        corpName = itemView.findViewById(R.id.corp_name);
        companyName = itemView.findViewById(R.id.company_name);
        sharePrice = itemView.findViewById(R.id.share_price);
        changeInPrice = itemView.findViewById(R.id.change_in_price);
    }
}
