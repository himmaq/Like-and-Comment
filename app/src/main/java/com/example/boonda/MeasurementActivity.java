package com.example.boonda;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MeasurementActivity extends AppCompatActivity {
    private TextView tvChildName;

        @StringRes
        private final int[] TAB_TITLES = new int[]{
                R.string.tab_text_1,
                R.string.tab_text_2,
                R.string.tab_text_3
        };

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_measurement);

            Toolbar toolbar = findViewById(R.id.toolbar_mea);
            setSupportActionBar(toolbar);
            PagerAdapter pagerAdapter = new PagerAdapter(this);
            ViewPager2 viewPager = findViewById(R.id.pager);
            viewPager.setAdapter(pagerAdapter);
            TabLayout tabs = findViewById(R.id.tab_layout);
            new TabLayoutMediator(tabs, viewPager, (tab, position) -> tab.setText(getResources().getString(TAB_TITLES[position]))).attach();
            if(getSupportActionBar() != null) {
                getSupportActionBar().setElevation(0);

            }
            tvChildName = findViewById(R.id.tv_child_name);
            tvChildName.setOnClickListener(view1-> {
                Intent i = new Intent(this, SelectChildActivity.class);
                startActivity(i);
            });
        }


    }

