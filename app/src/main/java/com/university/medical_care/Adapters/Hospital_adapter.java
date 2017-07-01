package com.university.medical_care.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.university.medical_care.R;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by waleed on 2015-08-16.
 */
public class Hospital_adapter extends ArrayAdapter<HashMap<String, String>> {

    ArrayList<HashMap<String, String>> Data;
    int resourceId;
    Context context;

    public Hospital_adapter(Context context, int resource, ArrayList<HashMap<String, String>> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resourceId = resource;
        this.Data = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if(convertView==null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.hospital_row, parent, false);
        }
        TextView name = (TextView) view.findViewById(R.id.hospital_name);
        TextView location = (TextView) view.findViewById(R.id.hospital_location);
        TextView address = (TextView) view.findViewById(R.id.hospital_address);
        TextView phone = (TextView) view.findViewById(R.id.hospital_phone);
        TextView fax = (TextView) view.findViewById(R.id.hospital_fax);
        TextView specialization  = (TextView) view.findViewById(R.id.hospital_specialization);


        name.setText( Data.get(position).get("name"));
        location.setText( Data.get(position).get("location"));
        address.setText(Data.get(position).get("address"));
        phone.setText(Data.get(position).get("phone"));
        fax.setText(Data.get(position).get("fax"));
        specialization.setText(Data.get(position).get("specialization"));

        return view;
    }
}
