package com.example.kanvystudio.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kanvystudio.OrderAdapter;
import com.example.kanvystudio.R;
public class HomeScreen extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public HomeScreen() {
    }


    public static HomeScreen newInstance(String param1, String param2) {
        HomeScreen fragment = new HomeScreen();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    com.example.kanvystudio.OrderAdapter orderAdapter;
    RecyclerView order_recyclerview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_screen, container, false);
        order_recyclerview = view.findViewById(R.id.order_recyclerview);
        orderAdapter  = new OrderAdapter(getActivity(),getFragmentManager());
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        order_recyclerview.setLayoutManager(manager);
        order_recyclerview.setAdapter(orderAdapter);
        orderAdapter.notifyDataSetChanged();
        return view;
    }
}