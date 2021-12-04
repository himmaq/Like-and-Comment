package com.example.boonda;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class AddChildDataActivity extends AppCompatActivity {
    private EditText etChildrensName, etChildrensBirthday, etChildrensKg, etChildrensCmhead, etChildrensCmheight, etChildrensPhoto;
    private RadioButton rbBoy, rbGirl, rbNo, rbYes;
    private Button btnSave;
    FirebaseAuth mAuth;
    DatabaseReference dbRef;

    ChildData childData;

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_child_data);

        mAuth = FirebaseAuth.getInstance();

        FirebaseUser userr = mAuth.getCurrentUser();
        String curr= userr.getEmail();
        curr = curr.replace("@", "").replace(".", "");

        etChildrensName = findViewById(R.id.et_childrens_name);
        etChildrensBirthday = findViewById(R.id.et_childrens_birthday);
        etChildrensKg = findViewById(R.id.et_childrens_kg);
        etChildrensCmhead = findViewById(R.id.et_childrens_cmhead);
        etChildrensCmheight = findViewById(R.id.et_childrens_cmheiht);
        etChildrensPhoto = findViewById(R.id.et_childrens_photo);

        childData = new ChildData();
        rbBoy = findViewById(R.id.rb_childrens_boy);
        rbGirl = findViewById(R.id.rb_childrens_girl);
        rbNo = findViewById(R.id.rb_childrens_no);
        rbYes = findViewById(R.id.rb_childrens_yes);
        btnSave = findViewById(R.id.bnt_save);

        dbRef = FirebaseDatabase.getInstance().getReference().child(curr).child("children");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    i = (int)snapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

        btnSave.setOnClickListener(view1-> {
            childData.setChildName(etChildrensName.getText().toString());
            childData.setBirthday(etChildrensBirthday.getText().toString());
            childData.setWeight(etChildrensKg.getText().toString());
            childData.setHead(etChildrensCmhead.getText().toString());
            childData.setHeight(etChildrensCmheight.getText().toString());
            childData.setPhotoProfile(etChildrensPhoto.getText().toString());
            insertData();

            String childBoy = rbBoy.getText().toString();
            String childGirl= rbGirl.getText().toString();
            String childNo = rbNo.getText().toString();
            String childYes = rbYes.getText().toString();

            //gender
            if(rbBoy.isChecked()){
                childData.setGender(childBoy);
                insertData();
            }else if(rbGirl.isChecked()){
                childData.setGender(childGirl);
                insertData();
            }

            //premature
            if(rbNo.isChecked()){
                childData.setPremature(childNo);
                insertData();
            }else if(rbYes.isChecked()) {
                childData.setPremature(childYes);
                insertData();
            }
            Toast.makeText(getApplicationContext(), "Successfully Added!", Toast.LENGTH_SHORT).show();

        });
    }
    public void insertData(){
        dbRef.child(String.valueOf(etChildrensName.getText().toString())).setValue(childData);
    }
}