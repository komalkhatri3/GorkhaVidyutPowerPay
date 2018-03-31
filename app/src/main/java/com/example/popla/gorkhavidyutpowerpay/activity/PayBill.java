package com.example.popla.gorkhavidyutpowerpay.activity;

import android.content.Intent;
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
    String aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_bill);

        /*
        int i;
        Button btn1;
        for ( i = 1; i <= 5; i++) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            Button btn = new Button(this);
            btn.setId(i);
            final int id_ = btn.getId();
            btn.setText("button " + id_);
            btn.setBackgroundColor(Color.rgb(70, 80, 90));
            linear.addView(btn, params);
            btn1 = ((Button) findViewById(id_));
            btn1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),
                            "Button clicked index = " + id_, Toast.LENGTH_SHORT)
                            .show();
                }
            });
        }
        */
/*
        LinearLayout ll = (LinearLayout)findViewById(R.id.layout);

        Button btn = new Button(this);
        btn.setText("Manual Add");
        btn.setLayoutParams(new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT));
        ll.addView(btn);
    }

*/
    }
    public void pay(View v)
    {
        K_NO = (EditText)findViewById(R.id.k_no);
        aa=K_NO.getText().toString();

        Intent i1=new Intent(this, BillDetailss.class).putExtra("knumber",K_NO.getText().toString());
        startActivity(i1);
        //   QueryBuilder<bill_details> qb = Bill_detailsDao().queryBuilder();
        //   qb.where(Bill_detailsDao.Properties.K_no.eq(K_NO.getText().toString()), Bill_detailsDao.Properties.Status.eq("notpaid"));

        //   List<Bill_details> joes = Bill_detailsDao.queryBuilder()
        //           .where(Bill_detailsDao.Properties.K_no.eq("Joe")).list();
    }

}
