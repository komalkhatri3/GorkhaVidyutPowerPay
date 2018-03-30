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

import java.util.ArrayList;
import java.util.List;

public class PayBill extends AppCompatActivity {


    EditText K_NO;
    ListView listView;
    List<String> kno;
    List<String> name;
    List<String> prev_read;
    List<String> curr_read;
    List<String> generateddate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_bill);
    }

    public void pay(View v)
    {

        kno = new ArrayList<String>();
        name = new ArrayList<String>();
        prev_read = new ArrayList<String>();
        curr_read = new ArrayList<String>();
        generateddate = new ArrayList<String>();

        Bill_details bill_details=new Bill_details();
        K_NO = (EditText)findViewById(R.id.k_no);
        ListView listView;
        DaoSession daoSession = ((PowerApplication)getApplication()).getDaoSession();
        List <Bill_details> list= daoSession.getBill_detailsDao().loadAll();
        for(int i=0;i<list.size();i++)
        {
            if((list.get(i).getK_no().equals(K_NO.getText().toString())) && (list.get(i).getPaid_by())== null)
            {
                kno.add(list.get(i).getK_no());
                name.add(list.get(i).getK_no());
                prev_read.add(list.get(i).getPrevious_read());
                curr_read.add(list.get(i).getCurrent_read());
                generateddate.add(list.get(i).getGenerated_date().toString());
            }

        }
        //   QueryBuilder<bill_details> qb = Bill_detailsDao().queryBuilder();
        //   qb.where(Bill_detailsDao.Properties.K_no.eq(K_NO.getText().toString()), Bill_detailsDao.Properties.Status.eq("notpaid"));

        //   List<Bill_details> joes = Bill_detailsDao.queryBuilder()
        //           .where(Bill_detailsDao.Properties.K_no.eq("Joe")).list();
    }

}
