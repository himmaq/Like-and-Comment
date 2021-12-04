package com.example.boonda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WeightAdapter extends RecyclerView.Adapter<WeightAdapter.MyViewHolder> {

    ArrayList<WeightModel> mList;
    Context context;

    public WeightAdapter(Context context, ArrayList<WeightModel> mList) {
        this.context = context;
        this.mList = mList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_weight, parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.ages.setText(mList.get(position).getAges());
        holder.date.setText(mList.get(position).getDate());
        holder.weight.setText(mList.get(position).getMeasure());
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
       TextView ages, date, weight;
        public MyViewHolder(View itemView){
            super(itemView);
            ages = itemView.findViewById(R.id.tv_count_months);
            date = itemView.findViewById(R.id.tv_date);
            weight = itemView.findViewById(R.id.tv_count_weight);

        }
    }


}
