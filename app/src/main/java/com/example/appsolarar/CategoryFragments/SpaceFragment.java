package com.example.appsolarar.CategoryFragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appsolarar.DataDetail;
import com.example.appsolarar.R;
import com.example.appsolarar.model.Data;
import com.example.appsolarar.model.DataVH;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;


public class SpaceFragment extends Fragment {
    View v;
    RecyclerView recyclerView;
    private DatabaseReference NatureRefs;
    RecyclerView.LayoutManager layoutManager;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.v = view;
        recyclerView = v.findViewById(R.id.nature_rv);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        NatureRefs = FirebaseDatabase.getInstance().getReference().child("Space");
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseRecyclerOptions<Data> options=new FirebaseRecyclerOptions.Builder<Data>()
                .setQuery(NatureRefs,Data.class)
                .build();
        FirebaseRecyclerAdapter<Data, DataVH> adapter=new FirebaseRecyclerAdapter<Data,DataVH>(options) {
            @Override
            protected void onBindViewHolder(@NonNull DataVH tutorVH, int i, @NonNull Data tutors) {
                tutorVH.textproductName.setText(tutors.getPName());
                tutorVH.textProductInfo.setText(tutors.getDescription());
                Picasso.get().load(tutors.getImage()).into(tutorVH.ProductImage);
                tutorVH.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent detintent=new Intent(getActivity(), DataDetail.class);
                        detintent.putExtra("pid",tutors.getPid());
                        detintent.putExtra("datarefs","Space");
                        startActivity(detintent);
                    }
                });

            }
            @NonNull
            @Override
            public DataVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
                DataVH holder=new DataVH(view);
                return holder;
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_space, container, false);
    }
}