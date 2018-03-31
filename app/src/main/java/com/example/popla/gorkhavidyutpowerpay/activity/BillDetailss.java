package com.example.popla.gorkhavidyutpowerpay.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.popla.gorkhavidyutpowerpay.PowerApplication;
import com.example.popla.gorkhavidyutpowerpay.R;
import com.example.popla.gorkhavidyutpowerpay.db.Bill_details;
import com.example.popla.gorkhavidyutpowerpay.db.DaoSession;
import com.example.popla.gorkhavidyutpowerpay.db.New_Connection;
import com.example.popla.gorkhavidyutpowerpay.db.New_ConnectionDao;

import java.util.ArrayList;
import java.util.List;

public class BillDetailss extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    String name1;
    public TextView BillId,KNo,UserName,UserAddress,Reading,units,Amount;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_detailss);
        TextView BillId=(TextView) findViewById(R.id.Bill_Id);
        TextView KNo=(TextView) findViewById(R.id.K_No);
        TextView UserName=(TextView)findViewById(R.id.UserName);
        TextView UserAddress=(TextView)findViewById(R.id.User_Address);
        TextView Reading=(TextView)findViewById(R.id.Reading);
        TextView units=(TextView) findViewById(R.id.Units);
        TextView Amount=(TextView)findViewById(R.id.Amount);
        Intent K_NO = getIntent();
        String Kno = K_NO.getStringExtra("knumber");

        List<String> input = new ArrayList<>();
        DaoSession daoSession = ((PowerApplication) getApplication()).getDaoSession();


        Bill_details bill_details = daoSession.getBill_detailsDao().load(Long.parseLong(Kno));

        New_Connection new_connection = daoSession.getNew_ConnectionDao().queryBuilder().where(New_ConnectionDao.Properties.K_no.eq(Long.parseLong(Kno))).build().unique();

        Toast.makeText(this, bill_details.getCurrent_read(), Toast.LENGTH_LONG).show();
        BillId.setText(bill_details.getBill_id().toString());
        KNo.setText(Kno);
        UserName.setText(new_connection.getApplicant_name());
        UserAddress.setText(new_connection.getApplicant_area()+new_connection.getApplicant_city());
        Reading.setText(bill_details.getCurrent_read());
        units.setText("");
        Amount.setText("1000");


    }
    public void PayAmount(View view){
        Intent intent=new Intent(this,PaymentGateway.class);
        startActivity(intent);

    }

}





