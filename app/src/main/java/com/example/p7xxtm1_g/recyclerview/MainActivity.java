package com.example.p7xxtm1_g.recyclerview;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private int previousTotal = 0;
    private boolean loading = true;
    private RecyclerView mCycv;
    private ArrayList<Integer> integers = new ArrayList<>();
    private Adapter adapter;
    private SwipeRefreshLayout mSw;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mCycv = (RecyclerView) findViewById(R.id.cycv);
        initData();
        adapter = new Adapter(this, integers);
        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mCycv.setLayoutManager(linearLayoutManager);
        mCycv.setAdapter(adapter);
        mSw = (SwipeRefreshLayout) findViewById(R.id.sw);
        integers = new ArrayList();
        mSw.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                integers.clear();
                initData();
                adapter.setList(integers);
                adapter.notifyDataSetChanged();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {

                        mSw.setRefreshing(false);
                    }
                },3000);

            }
        });
        mCycv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
               /* boolean b = recyclerView.canScrollVertically(1);
                Log.e("xxx", "onScrolled: "+b);
                if (!b){
                    initData();
                    adapter.setList(integers);
                    adapter.notifyDataSetChanged();

                }*/

                int childCount = recyclerView.getChildCount();
                int itemCount = linearLayoutManager.getItemCount();
                int firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                if (firstVisibleItemPosition+childCount==itemCount){
                    initData();
                    adapter.setList(integers);
                    adapter.notifyDataSetChanged();

                }

            }
        });
    }

    public void initData() {



        integers.add(R.drawable.u);
        integers.add(R.drawable.v);
        integers.add(R.drawable.w);
        integers.add(R.drawable.a);
        integers.add(R.drawable.b);
        integers.add(R.drawable.c);
        integers.add(R.drawable.e);
        integers.add(R.drawable.f);
        integers.add(R.drawable.g);
        integers.add(R.drawable.h);
        integers.add(R.drawable.i);
        integers.add(R.drawable.j);
        integers.add(R.drawable.k);
        integers.add(R.drawable.l);
        integers.add(R.drawable.m);
        integers.add(R.drawable.o);
        integers.add(R.drawable.p);
        integers.add(R.drawable.q);
        integers.add(R.drawable.r);
        integers.add(R.drawable.t);
        integers.add(R.drawable.u);
        integers.add(R.drawable.v);
        integers.add(R.drawable.w);
        Log.e("xxx", "initData: "+integers.size() );
    }
}
