package com.example.popla.gorkhavidyutpowerpay.activity.new_connections;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.popla.gorkhavidyutpowerpay.R;
import com.example.popla.gorkhavidyutpowerpay.db.New_Connection;

import java.util.List;

/**
 * Created by DELL on 3/30/2018.
 */

public class MyAdapterNewConnection extends  RecyclerView.Adapter<MyAdapterNewConnection.ViewHolder>{
    private List<New_Connection> values;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtAppId;
        public TextView txtUserName;
        public TextView txtStatus;

        public ViewHolder(View v) {
            super(v);
            txtAppId = (TextView) v.findViewById(R.id.Application_Id_S);
            txtUserName = (TextView) v.findViewById(R.id.UserName_S);
            txtStatus = (TextView) v.findViewById(R.id.Add_New_Status);
        }
    }

    public void add(int position, New_Connection item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapterNewConnection(List<New_Connection> myDataset) {
        values = myDataset;
    }

    // Create new views (invoked by the layout manager)




    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.nstatus_row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyAdapterNewConnection.ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final New_Connection new_connection = values.get(position);
        holder.txtAppId.setText(new_connection.getApplication_id().toString());
        holder.txtUserName.setText(new_connection.getApplicant_name());
        holder.txtStatus.setText(new_connection.getNew_Con_Req_S());


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }


}
