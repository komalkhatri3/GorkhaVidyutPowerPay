package com.example.popla.gorkhavidyutpowerpay.activity.Employee_Data;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.popla.gorkhavidyutpowerpay.AppController;
import com.example.popla.gorkhavidyutpowerpay.R;
import com.example.popla.gorkhavidyutpowerpay.activity.Employee_Data.EmployeeAdapter;
import com.example.popla.gorkhavidyutpowerpay.activity.Employee_Data.EmployeeDataProvider;
import com.example.popla.gorkhavidyutpowerpay.db.DaoSession;
import com.example.popla.gorkhavidyutpowerpay.db.Employee;

import java.util.List;

public class ShowAllEmploye extends AppCompatActivity {

    ListView listView;
    String [] ename;
    String [] edesig;
    EmployeeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_employe);
        listView = (ListView) findViewById(R.id.list_view);
        get_name_desig();
      /*  int i=0;
        adapter = new EmployeeAdapter(getApplicationContext(),R.layout.all_employee_layout);
        listView.setAdapter(adapter);
        for(String names : ename)
        {
            EmployeeDataProvider dataProvider=new EmployeeDataProvider(names,edesig[i]);
            adapter.add(dataProvider);
            i++;
        }
        */
        //Toast.makeText(this,edesig[0],Toast.LENGTH_LONG).show();
    }
    private void get_name_desig()
    {
        DaoSession daoSession = ((AppController)getApplication()).getDaoSession();
        List <Employee> list= daoSession.getEmployeeDao().loadAll();
       /* for(int i=0;i<=list.size();i++)
        {
            ename[i]=list.get(i).getEmp_name();
           edesig[i]=list.get(i).getEmp_designation();
        }*/
       Toast.makeText(this,list.size(),Toast.LENGTH_LONG).show();

    }
}
