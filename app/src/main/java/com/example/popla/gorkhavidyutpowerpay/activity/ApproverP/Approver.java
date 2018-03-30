package com.example.popla.gorkhavidyutpowerpay.activity.ApproverP;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.popla.gorkhavidyutpowerpay.R;
import com.example.popla.gorkhavidyutpowerpay.db.DaoSession;
import com.example.popla.gorkhavidyutpowerpay.db.New_Connection;

import java.util.ArrayList;
import java.util.List;

public class Approver extends AppCompatActivity {
    ListView listView;
    List<Long> App_ID;
    List<String> App_name;
    List<String> App_area;
    String a;
    ApproverAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approver);
        listView=(ListView)findViewById(R.id.List_view_approve);
        App_ID = new ArrayList<>();
        App_name = new ArrayList<String>();
        App_area = new ArrayList<String>();
        get_details();
        adapter = new ApproverAdapter(getApplicationContext(),R.layout.verifier_layout);
        listView.setAdapter(adapter);
        for(int i=0;i<App_name.size();i++)
        {
            ApproverDataProvider dataProvider = new ApproverDataProvider(App_ID.get(i), App_name.get(i),App_area.get(i));
            adapter.add(dataProvider);
            // i++;
        }
        //  for(String names : ename)
        //   {

//

    }
    private void get_details() {
        DaoSession daoSession = ((AppController) getApplication()).getDaoSession();
        List<New_Connection> list = daoSession.getNew_ConnectionDao().loadAll();
        for(int i=0;i<list.size();i++)
        {


            App_ID.add(list.get(i).getApplication_id());
            App_name.add(list.get(i).getApplicant_name());
            App_area.add(list.get(i).getApplicant_area());

        }
        //Toast.makeText(this, list.size(), Toast.LENGTH_LONG).show();
    }

}
