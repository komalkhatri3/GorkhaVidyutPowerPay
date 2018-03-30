package com.example.popla.gorkhavidyutpowerpay.activity.Verifier;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.popla.gorkhavidyutpowerpay.PowerApplication;
import com.example.popla.gorkhavidyutpowerpay.R;
import com.example.popla.gorkhavidyutpowerpay.db.DaoSession;
import com.example.popla.gorkhavidyutpowerpay.db.New_Connection;

import java.util.ArrayList;
import java.util.List;

public class VerifierNewConnection extends AppCompatActivity {
    ListView listView;
    List<String> app_name;
    List<String> app_area;
    List<String> app_id;
    VerifierAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifier_new_connection);
        listView=(ListView)findViewById(R.id.List_view_verify);
        app_id = new ArrayList<String>();
        app_area = new ArrayList<String>();
        app_name = new ArrayList<String>();
        get_details();

        adapter = new VerifierAdapter(getApplicationContext(),R.layout.verifier_layout);
        listView.setAdapter(adapter);

        for(int i=0;i<app_name.size();i++)
        {
            VerifierDataProvider dataProvider = new VerifierDataProvider(app_id.get(i),app_name.get(i),app_area.get(i));
            adapter.add(dataProvider);
        }
    }
    private void get_details() {
        DaoSession daoSession = ((PowerApplication) getApplication()).getDaoSession();
        List<New_Connection> list = daoSession.getNew_ConnectionDao().loadAll();
        for(int i=0;i<list.size();i++)
        {
            app_id.add(list.get(i).getApplication_id().toString());
            app_name.add(list.get(i).getApplicant_name());
            app_area.add(list.get(i).getApplicant_area());

        }

        //Toast.makeText(this, list.size(), Toast.LENGTH_LONG).show();
    }

}
