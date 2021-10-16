package com.example.admin.HomePageFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.admin.Adapters.SettingsAdapter;
import com.example.admin.Models.SettingsModel;
import com.example.admin.R;

import java.util.ArrayList;

public class Settings extends Fragment {

    RecyclerView recyclerViewGeneral, recyclerViewStayInTouch, recyclerViewOthers;
    ArrayList<SettingsModel> list;

    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_settings, container, false);

        recyclerViewGeneral = view.findViewById(R.id.general_recycler_view);
        recyclerViewStayInTouch = view.findViewById(R.id.recycler_view_stay_in_touch);
        recyclerViewOthers = view.findViewById(R.id.recycler_view_others);

        recyclerViewGeneral.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewStayInTouch.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewOthers.setLayoutManager(new LinearLayoutManager(getContext()));

        list = new ArrayList<>();

        list.add(new SettingsModel(R.drawable.appearance, "Appearance"));

        recyclerViewGeneral.setAdapter(new SettingsAdapter(list, getContext()));

        list = new ArrayList<>();

        list.add(new SettingsModel(R.drawable.contact_us, "Contact Us"));

        recyclerViewStayInTouch.setAdapter(new SettingsAdapter(list, getContext()));

        list = new ArrayList<>();

        list.add(new SettingsModel(R.drawable.about_us, "About Us"));
        list.add(new SettingsModel(R.drawable.privacy_policy, "Privacy Policy"));
        list.add(new SettingsModel(R.drawable.privacy_policy, "Log Out"));
        list.add(new SettingsModel(R.drawable.privacy_policy, "Delete Account"));

        recyclerViewOthers.setAdapter(new SettingsAdapter(list, getContext()));

        return view;
    }
}