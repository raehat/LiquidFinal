package com.example.admin.HomePageFragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.admin.Adapters.ShareAdapter;
import com.example.admin.Models.ShareModel;
import com.example.admin.R;

import java.util.ArrayList;

public class Analysis extends Fragment {

    RecyclerView recyclerView;
    ArrayList<ShareModel> list;
    TextView textViewSearch;

    @Nullable
    @Override

    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_share, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);

        textViewSearch = view.findViewById(R.id.search);

        textViewSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                filter(textViewSearch.getText().toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(textViewSearch.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(textViewSearch.getText().toString());
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        list = new ArrayList<>();

        try {
            list.add(new ShareModel("TATA","Tata Steel Corp.",25));
            list.add(new ShareModel("TATA","Tata Steel Corp.",25));
            list.add(new ShareModel("TATA","Tata Steel Corp.",25));
            list.add(new ShareModel("TATA","Tata Steel Corp.",25));
            list.add(new ShareModel("TATA","Tata Steel Corp.",25));
            list.add(new ShareModel("TATA","Tata Steel Corp.",25));
        } catch (Exception e) {
            Toast.makeText(getContext(), "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        recyclerView.setAdapter(new ShareAdapter(list, getContext()));

        return view;
    }
    void filter(String text){
        ArrayList<ShareModel> temp = new ArrayList();
        for(ShareModel d: list){
            //or use .equal(text) with you want equal match
            //use .toLowerCase() for better matches
            if(d.getCompanyName().toLowerCase().contains(text)){
                temp.add(d);
            }
        }
        //update recyclerview
        recyclerView.setAdapter(new ShareAdapter(temp, getContext()));
    }
}