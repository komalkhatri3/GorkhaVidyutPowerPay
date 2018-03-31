package com.example.popla.gorkhavidyutpowerpay.activity.new_connections;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.popla.gorkhavidyutpowerpay.R;

public class Add_New_Connection_Clicks extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__new__connection__clicks);
    }
    public void AddNew(View view){
        Intent intent=new Intent(this,AddNewConnection.class);
        startActivity(intent);
    }
    public void chechStatus(View view) {

        Intent intent=new Intent(this,New_Connection_Status.class);
        startActivity(intent);
    }
}
