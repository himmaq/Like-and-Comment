package com.example.boonda;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class GraphActivity extends AppCompatActivity {

    @StringRes
    private final int[] TAB_TITLES = new int[]{
            R.string.tab_text_1,
            R.string.tab_text_2,
            R.string.tab_text_3
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        Toolbar toolbar = findViewById(R.id.toolbar_graph);
        setSupportActionBar(toolbar);
        PagerAdapterGraph pagerAdapterGraph = new PagerAdapterGraph(this);
        ViewPager2 viewPager = findViewById(R.id.pager_graph);
        viewPager.setAdapter(pagerAdapterGraph);
        TabLayout tabs = findViewById(R.id.tab_layout_graph);
        new TabLayoutMediator(tabs, viewPager, (tab, position) -> tab.setText(getResources().getString(TAB_TITLES[position]))).attach();
        if(getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0);

        }

    }
}