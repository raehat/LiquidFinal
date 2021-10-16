package com.example.liquid.HomePageFragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liquid.Adapters.BuyShareAdapter;
import com.example.liquid.Models.BuyShareModel;
import com.example.liquid.R;

import java.util.ArrayList;

public class Buy extends Fragment {

    RecyclerView recyclerView;
    ArrayList<BuyShareModel> list;
    TextView textViewSearch;

    @Nullable
    @Override

    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_buy, container, false);

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
            list.add(new BuyShareModel("TATA","Tata Steel Corp.",25,3,0));
            list.add(new BuyShareModel("TATA","Tata Steel Corp.",25,3,0));
            list.add(new BuyShareModel("TATA","Tata Steel Corp.",25,3,0));
            list.add(new BuyShareModel("TATA","Bata Steel Corp.",25,3,0));
            list.add(new BuyShareModel("TATA","Tata Steel Corp.",25,-3,0));
            list.add(new BuyShareModel("TATA","Tata Steel Corp.",25,3,0));
            list.add(new BuyShareModel("TATA","Tata Steel Corp.",25,-3,0));
            list.add(new BuyShareModel("TATA","Tata Steel Corp.",25,-3,0));
            list.add(new BuyShareModel("TATA","Tata Steel Corp.",25,3,0));
        } catch (Exception e) {
            Toast.makeText(getContext(), "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        recyclerView.setAdapter(new BuyShareAdapter(list, getContext()));

        return view;
    }
    void filter(String text){
        ArrayList<BuyShareModel> temp = new ArrayList();
        for(BuyShareModel d: list){
            //or use .equal(text) with you want equal match
            //use .toLowerCase() for better matches
            if(d.getCompanyName().toLowerCase().contains(text)){
                temp.add(d);
            }
        }
        //update recyclerview
        recyclerView.setAdapter(new BuyShareAdapter(temp, getContext()));
    }
}