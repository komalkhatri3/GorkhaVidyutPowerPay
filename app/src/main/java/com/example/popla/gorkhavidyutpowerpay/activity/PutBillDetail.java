package com.example.popla.gorkhavidyutpowerpay.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.example.popla.gorkhavidyutpowerpay.PowerApplication;
import com.example.popla.gorkhavidyutpowerpay.R;
import com.example.popla.gorkhavidyutpowerpay.db.Bill_details;
import com.example.popla.gorkhavidyutpowerpay.db.DaoSession;
import com.example.popla.gorkhavidyutpowerpay.db.New_Connection;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PutBillDetail extends AppCompatActivity {

    EditText kno,name,generateddate,prev_read,curr_read,status,date;

    ListView listView;
    List<String> Apname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_bill_detail);
        generateddate = (EditText)findViewById(R.id.edit5);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String d= dateFormat.format(date).toString();
        generateddate.setText(dateFormat.format(date));
    }

    public void check(View v)
    {
        kno=(EditText)findViewById(R.id.edit1);
        name=(EditText)findViewById(R.id.edit2);
        listView = (ListView) findViewById(R.id.list_view);
        Apname = new ArrayList<String>();
        DaoSession daoSession = ((PowerApplication)getApplication()).getDaoSession();
        List <New_Connection> list= daoSession.getNew_ConnectionDao().loadAll();
        for(int i=0;i<list.size();i++)
        {
            if((kno.getText().toString()).equals(list.get(i).getApplicant_aadhar()))
            {
                Apname.add(list.get(i).getApplicant_name());
                name.setText(list.get(i).getApplicant_name());

            }

            //  ename.add(list.get(i).getEmp_name());
            //eid.add(list.get(i).getEmp_email_id());
            // edesig.add(list.get(i).getEmp_designation());

        }






        // QueryBuilder<AddNewConnection> queryBuilder= New_ConnectionDao.queryBuilder();
        // queryBuilder.where((New_ConnectionDao.Properties.Applicant_aadhar).eq(kno.getText().toString());
    }
    public void Submit(View v)
    {
        kno = (EditText)findViewById(R.id.edit1);
        name = (EditText)findViewById(R.id.edit2);
        prev_read = (EditText)findViewById(R.id.edit3);
        curr_read = (EditText)findViewById(R.id.edit4);
        date=(EditText)findViewById(R.id.edit5);
        date.toString();


        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String d= dateFormat.format(date).toString();
        generateddate.setText(dateFormat.format(date));
        DaoSession daoSession =((AppController)getApplication()).getDaoSession();

        Bill_details bill_details=new Bill_details();

        bill_details.setK_no(kno.getText().toString());
        //bill_details.setK_no(name.getText().toString());
        bill_details.setPrevious_read(prev_read.getText().toString());
        bill_details.setCurrent_read(curr_read.getText().toString());
        bill_details.setGenerated_date(date);
        daoSession.getBill_detailsDao().insert(bill_details);

//        bill_details.setGenerated_date(date.getText().toString());


    }

        private String getDateTime(){
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            return dateFormat.format(date);
        }

}
