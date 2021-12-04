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

public class ChildrenAdapter extends RecyclerView.Adapter<ChildrenAdapter.MyViewHolder>{
    ArrayList<ChildrenModel> mList;
    Context context;

    public ChildrenAdapter(Context context, ArrayList<ChildrenModel> mList) {
        this.context = context;
        this.mList = mList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_child, parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.childName.setText(mList.get(position).getChildName());

        Glide.with(holder.photoProfile.getContext()).load(mList.get(position).getPhotoProfile()).placeholder(R.drawable.common_google_signin_btn_icon_dark).circleCrop().error(R.drawable.common_google_signin_btn_icon_dark_normal).into(holder.photoProfile);
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView  childName;
        CircleImageView photoProfile;
        public MyViewHolder(View itemView){
            super(itemView);
            childName = itemView.findViewById(R.id.tv_child_name_select);
            photoProfile = itemView.findViewById(R.id.civ_child);
        }
    }
}
