package com.example.boonda;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class HeightAddActivity extends AppCompatActivity {
    private EditText addHeight, addAges;
    private Button addButton;
    DatabaseReference dbref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_add_height);
        dbref = FirebaseDatabase.getInstance().getReference().child("fachriprtm24").child("david").child("dataheight");
        Date date = Calendar.getInstance().getTime();
        String FormatedDate = DateFormat.getDateInstance(DateFormat.SHORT).format(date);
        addAges = findViewById(R.id.et_ages);
        addHeight = findViewById(R.id.et_height);
        addButton = findViewById(R.id.btn_add);



        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = dbref.push().getKey();

                int age = Integer.parseInt(addAges.getText().toString());
                int measure = Integer.parseInt(addHeight.getText().toString());

                WeightModel weightModel = new WeightModel(FormatedDate, age, measure);

                dbref.child(id).setValue(weightModel);

//                String ages = addAges.getText().toString();
//                String Height = addHeight.getText().toString();
//                HashMap<String,String> heightData = new HashMap<>();
//                heightData.put("ages",ages);
//                heightData.put("date",FormatedDate);
//                heightData.put("height",Height);
//                dbref.push().setValue(heightData);

            }
        });

    }
}