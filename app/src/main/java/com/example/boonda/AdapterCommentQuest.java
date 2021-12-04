//package com.example.boonda;
//
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.bumptech.glide.Glide;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import de.hdodenhof.circleimageview.CircleImageView;
//
//public class AdapterCommentQuest extends RecyclerView.Adapter<AdapterCommentQuest.MyViewHolder> {
//
//   List<String> mList;
//   ArrayList<String> finalitem = new ArrayList<>();
//
//    public AdapterCommentQuest(List<String> mlist){
//        this.mList = mlist;
//
//    }
//
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_comment, parent,false);
//        return new MyViewHolder(v);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        final String list = mList.get(position);
//
//        holder.topic.setText(list);
//        holder.title.setText(list);
//        holder.name.setText(list);
//        holder.date.setText(list);
//        holder.question.setText(list);
//        holder.like.setText(list);
//        holder.reply.setText(list);
//
//        Glide.with(holder.imgProfile.getContext()).load(list.getAskerphoto()).placeholder(R.drawable.common_google_signin_btn_icon_dark).circleCrop().error(R.drawable.common_google_signin_btn_icon_dark_normal).into(holder.imgProfile);
//        Glide.with(holder.imgProfileUser.getContext()).load(list.getPhoto()).placeholder(R.drawable.common_google_signin_btn_icon_dark).circleCrop().error(R.drawable.common_google_signin_btn_icon_dark_normal).into(holder.imgProfileUser);
//
//    }
//
//
//    @Override
//    public int getItemCount() {
//        return mList.size();
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder{
//        CircleImageView imgProfile, imgProfileUser;
//        TextView topic, title, name, date, question, like, reply;
//        public MyViewHolder(View itemView){
//            super(itemView);
//            imgProfile = itemView.findViewById(R.id.img_profile);
//            imgProfileUser = itemView.findViewById(R.id.img_profileuser);
//            topic = itemView.findViewById(R.id.tv_theme);
//            title = itemView.findViewById(R.id.tv_question);
//            name = itemView.findViewById(R.id.tv_name);
//            date = itemView.findViewById(R.id.tv_posted);
//            question = itemView.findViewById(R.id.tv_detailquestion);
//            like = itemView.findViewById(R.id.tv_like);
//            reply = itemView.findViewById(R.id.et_replies);
//        }
//    }
//}
