package com.example.boonda;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class DiscussionAdapter extends RecyclerView.Adapter<DiscussionAdapter.ViewHolder> {
    ArrayList<ModelActivity> mList;
    Context context;
    Integer countlike = 0;
    String topic;
    ArrayList<ModelComment> listComment;
    private LayoutInflater mInflater;
    Integer id = 0;

    // data is passed into the constructor
    DiscussionAdapter(Context context, ArrayList<ModelActivity> mList) {
        this.mList = mList;
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.cardhome, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.topic.setText(mList.get(position).getTopic());
        holder.title.setText(mList.get(position).getTitle());
        holder.name.setText(mList.get(position).getName());
        holder.date.setText(mList.get(position).getDate());
        holder.question.setText(mList.get(position).getQuestion());
        holder.like.setText(mList.get(position).getLike() + " Likes");
if (mList.get(position).getTopic() != null){
    topic = mList.get(position).getTopic().toLowerCase(Locale.ROOT);
}
        if (mList.get(position).getLike() != null){
            countlike = Integer.parseInt(mList.get(position).getLike());
        }
        holder.rvComment.setLayoutManager(new LinearLayoutManager(this.context));

        Date date = Calendar.getInstance().getTime();
        String FormatedDate = DateFormat.getDateInstance(DateFormat.SHORT).format(date);
        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("discussion");
        dbRef.orderByChild("id").equalTo(mList.get(position).getId()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    listComment = new ArrayList<ModelComment>();
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.child("comment").getChildren()){
                        listComment.add(dataSnapshot1.getValue(ModelComment.class));
                    }
                }

                CommentAdapter adapter = new CommentAdapter(context, listComment);
                holder.rvComment.setAdapter(adapter);
                holder.countReply.setText(String.valueOf(listComment.size()) + " Replies");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (topic.equals("infants")){
                    Toast.makeText(context, topic, Toast.LENGTH_SHORT).show();
                    countlike += 1;
                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("topic").child("infants");
                    DatabaseReference dbRef1 = FirebaseDatabase.getInstance().getReference().child("discussion");
                    dbRef.orderByChild("id").equalTo(mList.get(position).getId()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                                dataSnapshot1.child("like").getRef().setValue(String.valueOf(countlike));
                            holder.like.setText(String.valueOf(countlike));
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(context, databaseError.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    dbRef1.orderByChild("id").equalTo(mList.get(position).getId()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                                dataSnapshot1.child("like").getRef().setValue(String.valueOf(countlike));
                            holder.like.setText(String.valueOf(countlike));
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(context, databaseError.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } else if (topic.equals("behavior")){
                    countlike += 1;
                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("topic").child("infants");
                    DatabaseReference dbRef1 = FirebaseDatabase.getInstance().getReference().child("discussion");
                    dbRef.orderByChild("id").equalTo(mList.get(position).getId()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                                dataSnapshot1.child("like").getRef().setValue(String.valueOf(countlike));
                            holder.like.setText(String.valueOf(countlike));
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(context, databaseError.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    dbRef1.orderByChild("id").equalTo(mList.get(position).getId()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                                dataSnapshot1.child("like").getRef().setValue(String.valueOf(countlike));
                            holder.like.setText(String.valueOf(countlike));
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(context, databaseError.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } else if (topic.equals("education")){
                    countlike += 1;
                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("topic").child("infants");
                    DatabaseReference dbRef1 = FirebaseDatabase.getInstance().getReference().child("discussion");
                    dbRef.orderByChild("id").equalTo(mList.get(position).getId()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                                dataSnapshot1.child("like").getRef().setValue(String.valueOf(countlike));
                            holder.like.setText(String.valueOf(countlike));
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(context, databaseError.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    dbRef1.orderByChild("id").equalTo(mList.get(position).getId()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                                dataSnapshot1.child("like").getRef().setValue(String.valueOf(countlike));
                            holder.like.setText(String.valueOf(countlike));
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(context, databaseError.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } else if (topic.equals("parenting")){
                    countlike += 1;
                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("topic").child("infants");
                    DatabaseReference dbRef1 = FirebaseDatabase.getInstance().getReference().child("discussion");
                    dbRef.orderByChild("id").equalTo(mList.get(position).getId()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                                dataSnapshot1.child("like").getRef().setValue(String.valueOf(countlike));
                            holder.like.setText(String.valueOf(countlike));
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(context, databaseError.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    dbRef1.orderByChild("id").equalTo(mList.get(position).getId()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                                dataSnapshot1.child("like").getRef().setValue(String.valueOf(countlike));
                            holder.like.setText(String.valueOf(countlike));
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(context, databaseError.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } else if (topic.equals("pregnancy")){
                    countlike += 1;
                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("topic").child("infants");
                    DatabaseReference dbRef1 = FirebaseDatabase.getInstance().getReference().child("discussion");
                    dbRef.orderByChild("id").equalTo(mList.get(position).getId()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                                dataSnapshot1.child("like").getRef().setValue(String.valueOf(countlike));
                            holder.like.setText(String.valueOf(countlike));
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(context, databaseError.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    dbRef1.orderByChild("id").equalTo(mList.get(position).getId()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                                dataSnapshot1.child("like").getRef().setValue(String.valueOf(countlike));
                            holder.like.setText(String.valueOf(countlike));
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(context, databaseError.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } else if (topic.equals("preschool")){
                    countlike += 1;
                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("topic").child("infants");
                    DatabaseReference dbRef1 = FirebaseDatabase.getInstance().getReference().child("discussion");
                    dbRef.orderByChild("id").equalTo(mList.get(position).getId()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                                dataSnapshot1.child("like").getRef().setValue(String.valueOf(countlike));
                            holder.like.setText(String.valueOf(countlike));
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(context, databaseError.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    dbRef1.orderByChild("id").equalTo(mList.get(position).getId()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                                dataSnapshot1.child("like").getRef().setValue(String.valueOf(countlike));
                            holder.like.setText(String.valueOf(countlike));
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(context, databaseError.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } else if (topic.equals("toodlers")){
                    countlike += 1;
                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("topic").child("infants");
                    DatabaseReference dbRef1 = FirebaseDatabase.getInstance().getReference().child("discussion");
                    dbRef.orderByChild("id").equalTo(mList.get(position).getId()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                                dataSnapshot1.child("like").getRef().setValue(String.valueOf(countlike));
                            holder.like.setText(String.valueOf(countlike));
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(context, databaseError.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    dbRef1.orderByChild("id").equalTo(mList.get(position).getId()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                                dataSnapshot1.child("like").getRef().setValue(String.valueOf(countlike));
                            holder.like.setText(String.valueOf(countlike));
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(context, databaseError.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } else if (topic.equals("toughtopics")){
                    countlike += 1;
                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("topic").child("infants");
                    DatabaseReference dbRef1 = FirebaseDatabase.getInstance().getReference().child("discussion");
                    dbRef.orderByChild("id").equalTo(mList.get(position).getId()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                                dataSnapshot1.child("like").getRef().setValue(String.valueOf(countlike));
                            holder.like.setText(String.valueOf(countlike));
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(context, databaseError.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    dbRef1.orderByChild("id").equalTo(mList.get(position).getId()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                                dataSnapshot1.child("like").getRef().setValue(String.valueOf(countlike));
                            holder.like.setText(String.valueOf(countlike));
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(context, databaseError.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
        holder.btnPost.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (topic.equals("infants")){
                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("topic").child("infants");
                    DatabaseReference dbRef1 = FirebaseDatabase.getInstance().getReference().child("discussion");
                    dbRef.orderByChild("id").equalTo(mList.get(position).getId()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                                HashMap<String, String> comment = new HashMap<>();
                                comment.put("comment", holder.comment.getEditableText().toString());
                                comment.put("date", FormatedDate);
                                comment.put("id", dataSnapshot1.getKey());
                                dbRef.child(dataSnapshot1.getKey()).child("comment").push().setValue(comment);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(context, databaseError.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    dbRef1.orderByChild("id").equalTo(mList.get(position).getId()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                                HashMap<String, String> comment = new HashMap<>();
                                comment.put("comment", holder.comment.getEditableText().toString());
                                comment.put("date", FormatedDate);
                                comment.put("id", dataSnapshot1.getKey());
                                dbRef1.child(dataSnapshot1.getKey()).child("comment").push().setValue(comment);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(context, databaseError.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } else if (topic.equals("behavior")){
                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("topic").child("behavior");
                    DatabaseReference dbRef1 = FirebaseDatabase.getInstance().getReference().child("discussion");
                    dbRef.orderByChild("id").equalTo(mList.get(position).getId()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                                HashMap<String, String> comment = new HashMap<>();
                                comment.put("comment", holder.comment.getEditableText().toString());
                                comment.put("date", FormatedDate);
                                comment.put("id", dataSnapshot1.getKey());
                                dbRef.child(dataSnapshot1.getKey()).child("comment").push().setValue(comment);
                                dbRef1.child(dataSnapshot1.getKey()).child("comment").push().setValue(comment);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(context, databaseError.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    dbRef1.orderByChild("id").equalTo(mList.get(position).getId()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                                HashMap<String, String> comment = new HashMap<>();
                                comment.put("comment", holder.comment.getEditableText().toString());
                                comment.put("date", FormatedDate);
                                comment.put("id", dataSnapshot1.getKey());
                                dbRef1.child(dataSnapshot1.getKey()).child("comment").push().setValue(comment);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(context, databaseError.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } else if (topic.equals("education")){
                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("topic").child("education");
                    DatabaseReference dbRef1 = FirebaseDatabase.getInstance().getReference().child("discussion");
                    dbRef.orderByChild("id").equalTo(mList.get(position).getId()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                                HashMap<String, String> comment = new HashMap<>();
                                comment.put("comment", holder.comment.getEditableText().toString());
                                comment.put("date", FormatedDate);
                                comment.put("id", dataSnapshot1.getKey());
                                dbRef.child(dataSnapshot1.getKey()).child("comment").push().setValue(comment);
                                dbRef1.child(dataSnapshot1.getKey()).child("comment").push().setValue(comment);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(context, databaseError.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    dbRef1.orderByChild("id").equalTo(mList.get(position).getId()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                                HashMap<String, String> comment = new HashMap<>();
                                comment.put("comment", holder.comment.getEditableText().toString());
                                comment.put("date", FormatedDate);
                                comment.put("id", dataSnapshot1.getKey());
                                dbRef1.child(dataSnapshot1.getKey()).child("comment").push().setValue(comment);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(context, databaseError.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } else if (topic.equals("parenting")){
                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("topic").child("parenting");
                    DatabaseReference dbRef1 = FirebaseDatabase.getInstance().getReference().child("discussion");
                    dbRef.orderByChild("id").equalTo(mList.get(position).getId()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                                HashMap<String, String> comment = new HashMap<>();
                                comment.put("comment", holder.comment.getEditableText().toString());
                                comment.put("date", FormatedDate);
                                comment.put("id", dataSnapshot1.getKey());
                                dbRef.child(dataSnapshot1.getKey()).child("comment").push().setValue(comment);
                                dbRef1.child(dataSnapshot1.getKey()).child("comment").push().setValue(comment);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(context, databaseError.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    dbRef1.orderByChild("id").equalTo(mList.get(position).getId()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                                HashMap<String, String> comment = new HashMap<>();
                                comment.put("comment", holder.comment.getEditableText().toString());
                                comment.put("date", FormatedDate);
                                comment.put("id", dataSnapshot1.getKey());
                                dbRef1.child(dataSnapshot1.getKey()).child("comment").push().setValue(comment);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(context, databaseError.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } else if (topic.equals("pregnancy")){
                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("topic").child("pregnancy");
                    DatabaseReference dbRef1 = FirebaseDatabase.getInstance().getReference().child("discussion");
                    dbRef.orderByChild("id").equalTo(mList.get(position).getId()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                                HashMap<String, String> comment = new HashMap<>();
                                comment.put("comment", holder.comment.getEditableText().toString());
                                comment.put("date", FormatedDate);
                                comment.put("id", dataSnapshot1.getKey());
                                dbRef.child(dataSnapshot1.getKey()).child("comment").push().setValue(comment);
                                dbRef1.child(dataSnapshot1.getKey()).child("comment").push().setValue(comment);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(context, databaseError.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    dbRef1.orderByChild("id").equalTo(mList.get(position).getId()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                                HashMap<String, String> comment = new HashMap<>();
                                comment.put("comment", holder.comment.getEditableText().toString());
                                comment.put("date", FormatedDate);
                                comment.put("id", dataSnapshot1.getKey());
                                dbRef1.child(dataSnapshot1.getKey()).child("comment").push().setValue(comment);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(context, databaseError.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } else if (topic.equals("preschool")){
                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("topic").child("preschool");
                    DatabaseReference dbRef1 = FirebaseDatabase.getInstance().getReference().child("discussion");
                    dbRef.orderByChild("id").equalTo(mList.get(position).getId()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                                HashMap<String, String> comment = new HashMap<>();
                                comment.put("comment", holder.comment.getEditableText().toString());
                                comment.put("date", FormatedDate);
                                comment.put("id", dataSnapshot1.getKey());
                                dbRef.child(dataSnapshot1.getKey()).child("comment").push().setValue(comment);
                                dbRef1.child(dataSnapshot1.getKey()).child("comment").push().setValue(comment);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(context, databaseError.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    dbRef1.orderByChild("id").equalTo(mList.get(position).getId()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                                HashMap<String, String> comment = new HashMap<>();
                                comment.put("comment", holder.comment.getEditableText().toString());
                                comment.put("date", FormatedDate);
                                comment.put("id", dataSnapshot1.getKey());
                                dbRef1.child(dataSnapshot1.getKey()).child("comment").push().setValue(comment);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(context, databaseError.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } else if (topic.equals("toddlers")){
                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("topic").child("toddlers");
                    DatabaseReference dbRef1 = FirebaseDatabase.getInstance().getReference().child("discussion");
                    dbRef.orderByChild("id").equalTo(mList.get(position).getId()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                                HashMap<String, String> comment = new HashMap<>();
                                comment.put("comment", holder.comment.getEditableText().toString());
                                comment.put("date", FormatedDate);
                                comment.put("id", dataSnapshot1.getKey());
                                dbRef.child(dataSnapshot1.getKey()).child("comment").push().setValue(comment);
                                dbRef1.child(dataSnapshot1.getKey()).child("comment").push().setValue(comment);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(context, databaseError.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    dbRef1.orderByChild("id").equalTo(mList.get(position).getId()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                                HashMap<String, String> comment = new HashMap<>();
                                comment.put("comment", holder.comment.getEditableText().toString());
                                comment.put("date", FormatedDate);
                                comment.put("id", dataSnapshot1.getKey());
                                dbRef1.child(dataSnapshot1.getKey()).child("comment").push().setValue(comment);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(context, databaseError.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } else if (topic.equals("toughtopics")){
                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("topic").child("toughtopics");
                    DatabaseReference dbRef1 = FirebaseDatabase.getInstance().getReference().child("discussion");
                    dbRef.orderByChild("id").equalTo(mList.get(position).getId()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                                HashMap<String, String> comment = new HashMap<>();
                                comment.put("comment", holder.comment.getEditableText().toString());
                                comment.put("date", FormatedDate);
                                comment.put("id", dataSnapshot1.getKey());
                                dbRef.child(dataSnapshot1.getKey()).child("comment").push().setValue(comment);
                                dbRef1.child(dataSnapshot1.getKey()).child("comment").push().setValue(comment);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(context, databaseError.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    dbRef1.orderByChild("id").equalTo(mList.get(position).getId()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                                HashMap<String, String> comment = new HashMap<>();
                                comment.put("comment", holder.comment.getEditableText().toString());
                                comment.put("date", FormatedDate);
                                comment.put("id", dataSnapshot1.getKey());
                                dbRef1.child(dataSnapshot1.getKey()).child("comment").push().setValue(comment);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(context, databaseError.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mList.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView btnLike;
        TextView topic, title, name, date, question, like, reply, countReply;
        RecyclerView rvComment;
        EditText comment;
        Button btnPost;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            topic = itemView.findViewById(R.id.tv_theme);
            title = itemView.findViewById(R.id.tv_question);
            name = itemView.findViewById(R.id.tv_name);
            date = itemView.findViewById(R.id.tv_posted);
            question = itemView.findViewById(R.id.tv_detailquestion);
            like = itemView.findViewById(R.id.tv_like);
            reply = itemView.findViewById(R.id.et_replies);
            btnLike = itemView.findViewById(R.id.img_love);
            rvComment = itemView.findViewById(R.id.rv_comment);
            btnPost = itemView.findViewById(R.id.btn_post);
            comment = itemView.findViewById(R.id.et_replies);
            countReply = itemView.findViewById(R.id.tv_comment);

        }
    }
}
