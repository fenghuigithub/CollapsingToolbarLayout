package com.example.collapsingtoolbarlayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MyAdapter mAdapter;
    private List<String> mData;
    private List<String> nData;
    private RecyclerView mrecyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar back = getSupportActionBar();
        back.setDisplayHomeAsUpEnabled(true);

        initData();


        CollapsingToolbarLayout mCollapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        mCollapsingToolbarLayout.setTitle("CollapsingTitle");
        mCollapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.GREEN);

        mrecyclerview = (RecyclerView)findViewById(R.id.list);
        LinearLayoutManager linearlayoutmanager = new LinearLayoutManager(getApplicationContext());
        linearlayoutmanager.setOrientation(LinearLayoutManager.VERTICAL);
        mrecyclerview.setLayoutManager(linearlayoutmanager);

        mAdapter = new MyAdapter(getApplicationContext(),mData,nData);
        mAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(View view,int position){
                Intent intent = new Intent(MainActivity.this,Advertise.class);
                startActivity(intent);
            }
        });
        mrecyclerview.setAdapter(mAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void initData(){
        mData=new ArrayList<>(Arrays.asList("L.Y.X","Title 2","L.Y.X","Title 2","L.Y.X","Title 2","L.Y.X","Title 2"));
        nData = new ArrayList<>(Arrays.asList("Carry on !","Content 2","Carry on !","Content 2","Carry on !","Content 2","Carry on !","Content 2"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
