package com.example.boonda;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ParentingActivity extends AppCompatActivity {
    DatabaseReference dbref;
    Button btnAddQuestion;
    ArrayList<ModelActivity> list;
    RecyclerView recview;
    AdapterActivity adapter;
    Integer size;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parenting_discussion);

        btnAddQuestion = findViewById(R.id.btn_add_question);
//        btnAddQuestion.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openDialog();
//            }
//        });
        recview = (RecyclerView) findViewById(R.id.rv_parenting);
        recview.setLayoutManager( new LinearLayoutManager(this));
        list = new ArrayList<ModelActivity>();


        dbref = FirebaseDatabase.getInstance().getReference().child("topic").child("parenting");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for(DataSnapshot dataSnapshot1: snapshot.getChildren()){
                    ModelActivity mList = dataSnapshot1.getValue(ModelActivity.class);
                    list.add(0,mList);
                }
                adapter = new AdapterActivity(ParentingActivity.this,list, "parenting");
                recview.setAdapter(adapter);
                size = list.size();
                btnAddQuestion.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        openDialog(size);
                    }
                });

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ParentingActivity.this, "Belum ada pertanyaan", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void openDialog(Integer size){
        FragmentManager fm = getSupportFragmentManager();
        ParentingQuestionDialog dlg = ParentingQuestionDialog.newInstance(size);
        dlg.show(fm, "fragment");

//        InfantsQuestionDialog questionDialog = new InfantsQuestionDialog();
//        questionDialog.show(getSupportFragmentManager(),"question dialog");
    }
}
