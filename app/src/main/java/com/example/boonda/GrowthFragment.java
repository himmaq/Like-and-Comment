package com.example.boonda;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

    public class GrowthFragment extends Fragment {
        CardView cvMeasurement, cvGraphs,cvHealth;

        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_growth, container, false);

            cvMeasurement = view.findViewById(R.id.cv_measurement);
            cvGraphs = view.findViewById(R.id.cv_graph);
            cvHealth = view.findViewById(R.id.cv_health);

            cvMeasurement.setOnClickListener(view1-> {
                Intent i = new Intent(getActivity(), MeasurementActivity.class);
                startActivity(i);
            });

            cvGraphs.setOnClickListener(view1-> {
                Intent i = new Intent(getActivity(), GraphActivity.class);
                startActivity(i);
            });

            cvHealth.setOnClickListener(view1-> {
                Intent i = new Intent(getActivity(), AddChildDataActivity.class);
                startActivity(i);
            });

            return view;
        }

    }