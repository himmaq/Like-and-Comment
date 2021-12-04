package com.example.boonda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.MyViewHolder> {

    ArrayList<ModelComment> mList;
    Context context;

    public CommentAdapter(Context context, ArrayList<ModelComment> mList){
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_comment, parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        //holder.name.setText(mList.get(position).getName());
        holder.date.setText(mList.get(position).getDate());
        holder.comment.setText(mList.get(position).getComment());

        //Glide.with(holder.imgProfile.getContext()).load(mList.get(position).getAskerphoto()).placeholder(R.drawable.common_google_signin_btn_icon_dark).circleCrop().error(R.drawable.common_google_signin_btn_icon_dark_normal).into(holder.imgProfile);

    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        CircleImageView imgProfile;
        TextView name, date, comment;
        public MyViewHolder(View itemView){
            super(itemView);
            imgProfile = itemView.findViewById(R.id.img_profile);
            comment = itemView.findViewById(R.id.tv_comment);
            name = itemView.findViewById(R.id.tv_name);
            date = itemView.findViewById(R.id.tv_posted);
        }
    }
}
