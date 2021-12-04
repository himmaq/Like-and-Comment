package com.example.boonda;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class HomeFragment extends Fragment {
    private FirebaseAuth mAuth;
    private TextView user;
    private EditText name, weight, height, head;
    private Button submit;

    DatabaseReference dbref;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        //get current user
        mAuth = FirebaseAuth.getInstance();

        FirebaseUser userr = mAuth.getCurrentUser();
        String curr= userr.getEmail();
        curr = curr.replace("@", "").replace(".", "");

        user = view.findViewById(R.id.curr_user);
        user.setText(curr);
//
//        //submit data
//        name = view.findViewById(R.id.coba_name);
//        weight = view.findViewById(R.id.coba_weight);
//        height = view.findViewById(R.id.coba_height);
//        head = view.findViewById(R.id.coba_head);
//
//        submit = view.findViewById(R.id.coba_submit);
//
//        String childName = name.getText().toString();
//
//
//        //database
//        dbref = FirebaseDatabase.getInstance().getReference().child(curr).child(childName);
//
//        //submit
//        submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String id = dbref.push().getKey();
//
//                String childName = name.getText().toString();
//                String childWeight = weight.getText().toString();
//                String childHeight = height.getText().toString();
//                String childHead = head.getText().toString();
//
//                CobaModel cobaModel = new CobaModel(childName, childWeight, childHeight,childHead);
//
//                dbref.child(id).setValue(cobaModel);
//
//            }
//        });

        return view;
    }
}