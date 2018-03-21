package com.example.popla.gorkhavidyutpowerpay.activity.Verifier;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.popla.gorkhavidyutpowerpay.AppController;
import com.example.popla.gorkhavidyutpowerpay.R;
import com.example.popla.gorkhavidyutpowerpay.db.DaoSession;
import com.example.popla.gorkhavidyutpowerpay.db.New_Connection;

import java.util.List;

public class VerifierNewConnection extends AppCompatActivity {
    ListView listView;
    String [] app_name;
    String [] app_area;
    VerifierAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifier_new_connection);
        ListView listView=(ListView)findViewById(R.id.List_view_verify);
        get_details();
    }
    private void get_details() {
        DaoSession daoSession = ((AppController) getApplication()).getDaoSession();
        List<New_Connection> list = daoSession.getNew_ConnectionDao().loadAll();

        //Toast.makeText(this, list.size(), Toast.LENGTH_LONG).show();
    }

}
