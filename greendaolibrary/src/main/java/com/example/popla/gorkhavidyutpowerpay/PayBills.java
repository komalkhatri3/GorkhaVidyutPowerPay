package com.example.popla.gorkhavidyutpowerpay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.greendaolibrary.R;

public class PayBills extends AppCompatActivity {


    EditText k_no;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_bills);



    }

    public void pabill(View v)
    {
        k_no=(EditText)findViewById(R.id.k_no);
        k_no.getText().toString();

    }
}
