package com.example.popla.gorkhavidyutpowerpay.activity.Employee_Data;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.popla.gorkhavidyutpowerpay.AppController;
import com.example.popla.gorkhavidyutpowerpay.R;
import com.example.popla.gorkhavidyutpowerpay.db.DaoSession;
import com.example.popla.gorkhavidyutpowerpay.db.Employee;
import com.example.popla.gorkhavidyutpowerpay.db.EmployeeDao;

import java.util.List;

public class ParticularEmployeeDetail extends AppCompatActivity {

    String s,l;
    int point ;
    TextView headname;
    DaoSession daoSession;
    EditText editid, editname, editmail, editmobile,editage,editdesig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_particular_employee_detail);
        Intent intent = getIntent();
        s="emp_id";
         l = intent.getStringExtra(s);
        headname = (TextView)findViewById(R.id.heading_name);
        editid = (EditText)findViewById(R.id.edit_id);
        editname = (EditText)findViewById(R.id.edit_name);
        editmail = (EditText)findViewById(R.id.edit_mail);
        editmobile = (EditText)findViewById(R.id.edit_mobile);
        editage = (EditText)findViewById(R.id.edit_age);
        editdesig = (EditText)findViewById(R.id.edit_desig);
        daoSession = ((AppController)getApplication()).getDaoSession();
        List<Employee> list = daoSession.getEmployeeDao().loadAll();

        for(int i=0 ; i<list.size();i++)
        {
            if(l.equals(list.get(i).getEmp_email_id()))
            {
                point = i;
                break;
            }
        }
        Toast.makeText(this, list.get(point).getEmp_email_id().toString(), Toast.LENGTH_SHORT).show();

        headname.setText(list.get(point).getEmp_name());
        editid.setText(list.get(point).getEmp_id().toString());
        editname.setText(list.get(point).getEmp_name());
        editmail.setText(list.get(point).getEmp_email_id());
        editmobile.setText(list.get(point).getEmp_mobile());
        editage.setText(list.get(point).getEmp_age());
        editdesig.setText(list.get(point).getEmp_designation());


    }

    public void employeeRemove(View view)
    {
        EmployeeDao employeeDao = daoSession.getEmployeeDao();
        employeeDao.deleteByKey(Long.parseLong(editid.getText().toString()));
        Intent i = new Intent(this, ShowAllEmploye.class);
        startActivity(i);
    }
}
