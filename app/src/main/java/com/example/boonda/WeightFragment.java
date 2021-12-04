package com.example.boonda;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class WeightFragment extends Fragment {

    Button btnAdd;
    DatabaseReference dbRef;
    FirebaseDatabase mDatabase;
    RecyclerView recyclerView;
    ArrayList<WeightModel> list;
    WeightAdapter adapter;

    public WeightFragment() {
        mDatabase = FirebaseDatabase.getInstance();
        dbRef = mDatabase.getReference("fachriprtm24").child("david").child("dataweight");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View  v = inflater.inflate(R.layout.fragment_weight, container, false);

        btnAdd = v.findViewById(R.id.button);
        btnAdd.setOnClickListener(view1-> {
            Intent i = new Intent(getActivity(), WeightAddActivity.class);
            startActivity(i);
        });

        recyclerView = v.findViewById(R.id.rv_weight);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<WeightModel>();

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    WeightModel mList = dataSnapshot.getValue(WeightModel.class);
                    list.add(mList);
                }
                adapter = new WeightAdapter(getContext(), list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return v;
    }


        }


