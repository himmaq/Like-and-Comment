package com.example.boonda;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SelectChildActivity extends AppCompatActivity {
    Button btnAddChild;
    DatabaseReference dbref;
    ArrayList<ChildrenModel> list;
    RecyclerView recview;
    ChildrenAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_child);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnAddChild = findViewById(R.id.btn_add_child);
        btnAddChild.setOnClickListener(view1-> {
            Intent i = new Intent(this, AddChildDataActivity.class);
            startActivity(i);
        });
        LinearLayoutManager layoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recview = (RecyclerView) findViewById(R.id.rv_child);
        recview.setLayoutManager(layoutManager);
        list = new ArrayList<ChildrenModel>();


        dbref = FirebaseDatabase.getInstance().getReference().child("User").child("children");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot1: snapshot.getChildren()){
                    ChildrenModel mList = dataSnapshot1.getValue(ChildrenModel.class);
                    list.add(mList);

                }
                adapter = new ChildrenAdapter(SelectChildActivity.this,list);
                recview.setAdapter(adapter);


            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(SelectChildActivity.this, "Belum ada Data Anak", Toast.LENGTH_SHORT).show();
            }
     });
    }
}