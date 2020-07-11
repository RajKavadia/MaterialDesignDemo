package com.example.kanvystudio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kanvystudio.fragments.Step1;
import com.google.android.material.button.MaterialButton;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.viewholder> {
    Context context;
    FragmentManager fragmentManager;

    public OrderAdapter(Context context, FragmentManager fragmentManager) {
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public OrderAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.home_screen_row, parent, false);
        return new viewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.viewholder holder, int position) {
        holder.accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction().add(R.id.content_frame, Step1.newInstance("",""),"").addToBackStack("").commit();

            }
        });

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class viewholder extends RecyclerView.ViewHolder{
        MaterialButton accept;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            accept= itemView.findViewById(R.id.accept);

        }
    }
}
