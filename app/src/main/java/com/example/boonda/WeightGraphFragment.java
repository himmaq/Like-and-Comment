package com.example.boonda;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class WeightGraphFragment extends Fragment {
    FirebaseDatabase db;
    DatabaseReference rf;

    GraphView graphView;
    LineGraphSeries series;

    public WeightGraphFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fragment_weight_graph, container, false);

        graphView = (GraphView) v.findViewById(R.id.graph);
        series = new LineGraphSeries();
        graphView.addSeries(series);

        db = FirebaseDatabase.getInstance();
        rf = db.getReference().child("fachriprtm24").child("david").child("dataweight");

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();

        rf.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DataPoint[] dp = new DataPoint[(int) dataSnapshot.getChildrenCount()];
                int index = 0;

                for(DataSnapshot myDataSnapshot : dataSnapshot.getChildren()){
                    ChartModel chartModel = myDataSnapshot.getValue(ChartModel.class);
                    dp[index] = new DataPoint(chartModel.getAges(), chartModel.getMeasure());
                    index++;
                }
                series.resetData(dp);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}