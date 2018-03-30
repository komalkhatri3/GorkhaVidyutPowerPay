package com.example.popla.gorkhavidyutpowerpay.activity.Applier;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.popla.gorkhavidyutpowerpay.PowerApplication;
import com.example.popla.gorkhavidyutpowerpay.R;
import com.example.popla.gorkhavidyutpowerpay.db.DaoSession;
import com.example.popla.gorkhavidyutpowerpay.db.New_Connection;

import java.util.ArrayList;
import java.util.List;

public class Applier1 extends AppCompatActivity {
    ListView listView;
    List<Long> App_ID;
    List<String> App_name;
    List<String> App_area;
    String a;
    ApplierAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applier1);
        listView=(ListView)findViewById(R.id.list_view);
        App_ID = new ArrayList<>();
        App_name = new ArrayList<String>();
        App_area = new ArrayList<String>();
        get_details();
        adapter = new ApplierAdapter(getApplicationContext(),R.layout.verifier_layout);
        listView.setAdapter(adapter);
        for(int i=0;i<App_ID.size();i++)
        {
            ApplierDataProvider dataProvider = new ApplierDataProvider(App_ID.get(i), App_name.get(i),App_area.get(i));
            adapter.add(dataProvider);
            // i++;
        }
    }
    private void get_details() {
        DaoSession daoSession = ((PowerApplication) getApplication()).getDaoSession();
        List<New_Connection> list = daoSession.getNew_ConnectionDao().loadAll();
        for(int i=0;i<list.size();i++)
        {


            App_ID.add(list.get(i).getApplication_id());
            App_name.add(list.get(i).getApplicant_name());
            App_area.add(list.get(i).getApplicant_area());

        }
    }
}
