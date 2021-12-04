package com.example.boonda;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class InfantsQuestionDialog extends DialogFragment {
    private EditText etQuestionTitle, etTitle;
    private TextView Topic, Name;
    private int i = 0, Comment, count = 0;
    DatabaseReference dbRef;
    DatabaseReference dbRef1;
    ValueEventListener db;

    static InfantsQuestionDialog newInstance(int size) {
        InfantsQuestionDialog f = new InfantsQuestionDialog();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("size", size);
        f.setArguments(args);

        return f;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        count = getArguments().getInt("size");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.card_question, null);
        View a = inflater.inflate(R.layout.activity_infants_discussion,null);
        Date date = Calendar.getInstance().getTime();
        String FormatedDate = DateFormat.getDateInstance(DateFormat.SHORT).format(date);
        etTitle = v.findViewById(R.id.et_title);
        etQuestionTitle = v.findViewById(R.id.et_question_content);
        Topic = a.findViewById(R.id.InfantsTitle);
        String like = String.valueOf(i);



        builder.setView(v)
                .setTitle("Question")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Post", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dbRef = FirebaseDatabase.getInstance().getReference().child("topic").child("infants");
                        dbRef1 = FirebaseDatabase.getInstance().getReference().child("discussion");

                        String title = etTitle.getText().toString();
                        String Quest = etQuestionTitle.getText().toString();
                        String topic = Topic.getText().toString();
                        String Like = like.toString();

                        HashMap<String,String> Question = new HashMap<>();
                        Question.put("id", String.valueOf(count + 1));
                        Question.put("topic",topic);
                        Question.put("question",Quest);
                        Question.put("date",FormatedDate);
                        Question.put("title",title);
                        Question.put("like",Like);
                        dbRef.push().setValue(Question);
                        dbRef1.push().setValue(Question);

                        Toast.makeText(getActivity(), "Successfully Posted!", Toast.LENGTH_SHORT).show();
                    }
                });
        return builder.create();
    }

    public static InfantsQuestionDialog dialog(){
        InfantsQuestionDialog dialog = new InfantsQuestionDialog();
        return dialog;
    }
}
