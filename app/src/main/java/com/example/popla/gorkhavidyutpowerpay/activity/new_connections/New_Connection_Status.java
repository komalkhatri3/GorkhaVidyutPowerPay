package com.example.popla.gorkhavidyutpowerpay.activity.new_connections;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.popla.gorkhavidyutpowerpay.PowerApplication;
import com.example.popla.gorkhavidyutpowerpay.R;
import com.example.popla.gorkhavidyutpowerpay.db.New_Connection;
import com.example.popla.gorkhavidyutpowerpay.db.DaoSession;


import java.util.ArrayList;
import java.util.List;


public class New_Connection_Status extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__connection__status);recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        List<String> input = new ArrayList<>();
        DaoSession daoSession = ((PowerApplication)getApplication()).getDaoSession();

        List<New_Connection> list= daoSession.getNew_ConnectionDao().loadAll();

        //Toast.makeText(this, list.get(0).getApplication_id(), Toast.LENGTH_LONG).show();






       /*
        for (int i = 0; i < 100; i++) {
            input.add("Test" + i);
        }// define an adapter

*/
        mAdapter = new MyAdapterNewConnection(list);
        recyclerView.setAdapter(mAdapter);
    }



}
