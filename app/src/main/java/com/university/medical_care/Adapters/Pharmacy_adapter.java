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
public class Pharmacy_adapter extends ArrayAdapter<HashMap<String, String>> {

    ArrayList<HashMap<String, String>> Data;
    int resourceId;
    Context context;

    public Pharmacy_adapter(Context context, int resource, ArrayList<HashMap<String, String>> objects) {
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
            view = inflater.inflate(R.layout.pharmacy_row, parent, false);
        }
        TextView name = (TextView) view.findViewById(R.id.pharmacy_name);
        TextView location = (TextView) view.findViewById(R.id.pharmacy_location);
        TextView address = (TextView) view.findViewById(R.id.pharmacy_address);



        name.setText( Data.get(position).get("name"));
        location.setText( Data.get(position).get("location"));
        address.setText(Data.get(position).get("address"));


        return view;
    }
}
