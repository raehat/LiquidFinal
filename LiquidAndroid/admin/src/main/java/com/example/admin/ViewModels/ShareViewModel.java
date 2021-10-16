package com.example.admin.ViewModels;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.admin.R;

public class ShareViewModel extends RecyclerView.ViewHolder {

    public TextView corpName, companyName, noOfPeople , changeInPrice;

    public ShareViewModel(@NonNull View itemView) {
        super(itemView);
        corpName = itemView.findViewById(R.id.corp_name);
        companyName = itemView.findViewById(R.id.company_name);
        noOfPeople = itemView.findViewById(R.id.no_of_people);
    }
}
