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

public class HeadFragment extends Fragment {

    Button btnAdd;
    DatabaseReference dbRef;
    FirebaseDatabase mDatabase;
    RecyclerView recyclerView;
    ArrayList<HeadModel> list;
    HeadAdapter adapter;

    public HeadFragment() {
        mDatabase = FirebaseDatabase.getInstance();
        dbRef = mDatabase.getReference("fachriprtm24").child("David").child("DataHead");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View  v = inflater.inflate(R.layout.fragment_head, container, false);

        btnAdd = v.findViewById(R.id.button);
        btnAdd.setOnClickListener(view1-> {
            Intent i = new Intent(getActivity(), HeadAddActivity.class);
            startActivity(i);
        });

//        recyclerView = v.findViewById(R.id.rv_head);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        list = new ArrayList<HeadModel>();
//
//        dbRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
//                    HeadModel mList = dataSnapshot.getValue(HeadModel.class);
//                    list.add(mList);
//                }
//                adapter = new HeadAdapter(getContext(), list);
//                recyclerView.setAdapter(adapter);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
        return v;
    }
}