package com.example.boonda;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DiscussionFragment extends Fragment {

    ImageView ivInfants, ivPregnancy, ivEducation, ivBehaviour, ivToddlers, ivPreschool, ivParenting, ivTopic;

    RecyclerView recview;
    DiscussionAdapter adapter;
    ArrayList<ModelActivity> list;
    DatabaseReference dbref;

    public DiscussionFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discussion, container, false);

        recview = (RecyclerView) view.findViewById(R.id.rv_recent_discuss);
        recview.setLayoutManager(new LinearLayoutManager(getContext()));

        list = new ArrayList<ModelActivity>();
        dbref = FirebaseDatabase.getInstance().getReference().child("discussion");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for(DataSnapshot dataSnapshot1: snapshot.getChildren()){
                    ModelActivity mList = dataSnapshot1.getValue(ModelActivity.class);
                    list.add(0,mList);
                }
                adapter = new DiscussionAdapter(getContext(),list);
                recview.setAdapter(adapter);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ivInfants = view.findViewById(R.id.iv_infants);
        ivPregnancy = view.findViewById(R.id.iv_pregnancy);
        ivEducation = view.findViewById(R.id.iv_education);
        ivBehaviour = view.findViewById(R.id.iv_behavior);
        ivToddlers = view.findViewById(R.id.iv_toddlers);
        ivPreschool = view.findViewById(R.id.iv_preschool);
        ivParenting = view.findViewById(R.id.iv_parenting);
        ivTopic = view.findViewById(R.id.iv_topics);

        ivInfants.setOnClickListener(view1 -> {
            moveInfants();
        });

        ivPregnancy.setOnClickListener(view1 -> {
            movePregnancy();
        });

        ivEducation.setOnClickListener(view1 -> {
            moveEducation();
        });

        ivBehaviour.setOnClickListener(view1 -> {
            moveBehavior();
        });

        ivToddlers.setOnClickListener(view1 -> {
            moveToddlers();
        });

        ivPreschool.setOnClickListener(view1 -> {
            movePreschool();
        });

        ivParenting.setOnClickListener(view1 -> {
            moveParenting();
        });

        ivTopic.setOnClickListener(view1 -> {
            moveToughTopics();
        });


        return view;
    }

    public void moveInfants() {
        Intent i = new Intent(getActivity(), InfantsActivity.class);
        startActivity(i);
    }

    public void movePregnancy() {
        Intent i = new Intent(getActivity(), PregnancyActivity.class);
        startActivity(i);
    }

    public void moveEducation() {
        Intent i = new Intent(getActivity(), EducationActivity.class);
        startActivity(i);
    }

    public void moveBehavior() {
        Intent i = new Intent(getActivity(), BehaviorActivity.class);
        startActivity(i);
    }

    public void moveToddlers() {
        Intent i = new Intent(getActivity(), ToddlersActivity.class);
        startActivity(i);
    }

    public void movePreschool() {
        Intent i = new Intent(getActivity(), PreschoolActivity.class);
        startActivity(i);
    }

    public void moveParenting() {
        Intent i = new Intent(getActivity(), ParentingActivity.class);
        startActivity(i);
    }

    public void moveToughTopics() {
        Intent i = new Intent(getActivity(), ToughTopicsActivity.class);
        startActivity(i);
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        adapter.startListening();
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        adapter.stopListening();
//    }


}