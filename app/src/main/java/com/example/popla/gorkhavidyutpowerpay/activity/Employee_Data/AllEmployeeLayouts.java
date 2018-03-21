package com.example.popla.gorkhavidyutpowerpay.activity.Employee_Data;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.popla.gorkhavidyutpowerpay.R;

public class AllEmployeeLayouts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_employee_layouts);
    }
 /*public void showDetail(View view)
    {
      String s= "emp_id";
        Intent i e= nw Intent(this,ParticularEmployeeDetail.class);
        i.putExtra(s,temail.getText().toString());
        startActivity(i);

      //  ListView lvItems = ();
        //for (int i=0; i < lvItems.getChildCount(); i++)
       // {
         //   lvItems.getChildAt(i).setBackgroundColor(Color.BLUE);
        //}

        LinearLayout parentRow = (LinearLayout)view.getParent();
        TextView tename = (TextView)parentRow.getChildAt(0);
        TextView tedesig= (TextView)parentRow.getChildAt(2);
        TextView temail = (TextView)parentRow.getChildAt(1);
        Button edetail = (Button)parentRow.getChildAt(3);
        Toast.makeText(this, temail.getText().toString(), Toast.LENGTH_LONG).show();
    }*/
}
