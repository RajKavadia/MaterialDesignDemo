package com.example.kanvystudio.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kanvystudio.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class Splash_Screen extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Splash_Screen() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Splash_Screen.
     */
    // TODO: Rename and change types and number of parameters
    public static Splash_Screen newInstance(String param1, String param2) {
        Splash_Screen fragment = new Splash_Screen();
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
    MaterialButton login;
    TextInputEditText mobile_number;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_splash__screen, container, false);
        login= view.findViewById(R.id.login);
        mobile_number = view.findViewById(R.id.mobile_number);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireFragmentManager().beginTransaction().add(R.id.content_frame,OtpEnterFragment.newInstance("",""),"").addToBackStack("").commit();
            }
        });
        return view;
    }
}