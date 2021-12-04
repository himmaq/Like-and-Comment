package com.example.boonda;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;

public class CommentActivity extends AppCompatActivity {
    DatabaseReference dbref;
    CommentAdapter comment;
    RecyclerView recview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        recview = findViewById(R.id.rv_comment);
//        Intent intent = this.getIntent();
//        Bundle bundle = intent.getExtras();
//        ModelActivity model = (ModelActivity)bundle.getSerializable("key");
//        recview.setLayoutManager(new LinearLayoutManager(this));
//        ArrayList<String> string = new ArrayList<>();
//        string.add(model.getName());
//        string.add(model.getTitle());
//        string.add(model.getQuestion());
//        string.add(model.getDate());
//        string.add(model.getLike() );
//        string.add(model.getAskerphoto() );
//
//        comment = new AdapterCommentQuest(string);
//
//
//
////

    }
}