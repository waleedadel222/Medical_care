package com.university.medical_care;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class SearchActivity extends Activity {

    Button search_btn;
    EditText name;
    Spinner search_type_spinner , specialization_spinner ,location_spinner;
    ArrayAdapter search_type_adapter, specialization_adapter, location_adapter;
    String name_str, location_str, specialization_str;
    char type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        specialization_spinner = (Spinner) findViewById(R.id.specialization_spinner);
        name = (EditText) findViewById(R.id.name_editText);

        //location
        location_spinner = (Spinner) findViewById(R.id.location_spinner);
        location_adapter = ArrayAdapter.createFromResource(this, R.array.locations,
                android.R.layout.simple_spinner_dropdown_item);
        location_spinner.setAdapter(location_adapter);
        //end location

        search_btn = (Button) findViewById(R.id.search_btn);
        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search();
            }
        });

        //Main Spinner
        search_type_spinner = (Spinner) findViewById(R.id.type_spinner);
        search_type_adapter = ArrayAdapter.createFromResource(this, R.array.type,
                android.R.layout.simple_spinner_dropdown_item);
        search_type_spinner.setAdapter(search_type_adapter);

        search_type_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                   case 1:
                        hospitalSelected();
                        type = 'h';   break;
                  case 2:
                        pharmacySelected();
                      type = 'p';  break;
                case 3:    doctorSelected();
                      type = 'd';
                      break;
}
}

        @Override
    public void onNothingSelected(AdapterView<?> parent) {

        }
        });
        //end Main Spinner
        }

        void search() {

        name_str = name.getText().toString();
        location_str = location_spinner.getSelectedItem().toString(); //location

        switch (type) {
        case 'h':
        specialization_str = specialization_spinner.getSelectedItem().toString();
        if (name_str.equals("")&& location_str.equals("الموقع")&& specialization_str.equals("التخصص")) {

        Toast.makeText(SearchActivity.this,"اختر واحد على الاقل", Toast.LENGTH_LONG).show();
        } else  {

        Intent intent = new Intent(SearchActivity.this ,ResultActivity.class);
        intent.putExtra("key","h");
        intent.putExtra("name" ,name_str);
        intent.putExtra("location" , location_str);
        intent.putExtra("specialization", specialization_str);
        startActivity(intent);
        }
        break;

        case 'd':
        specialization_str = specialization_spinner.getSelectedItem().toString();
        if (name_str.equals("") && location_str.equals("الموقع") && specialization_str.equals("التخصص")) {
        Toast.makeText(SearchActivity.this,"اختر واحد على الاقل", Toast.LENGTH_LONG).show();
        } else {

        Intent intent = new Intent(SearchActivity.this ,ResultActivity.class);
        intent.putExtra("key","d");
        intent.putExtra("name" ,name_str);
        intent.putExtra("location" , location_str);
        intent.putExtra("specialization", specialization_str);
        startActivity(intent);
        }
        break;

        case 'p':

        Intent intent  = new Intent(SearchActivity.this ,ResultActivity.class);
        intent.putExtra("key" ,"p");
        startActivity(intent);

        break;
        }
        }


        //Visible
    void hospitalSelected () {

        specialization_adapter = ArrayAdapter.createFromResource(this, R.array.hospital_specialization,
                android.R.layout.simple_spinner_dropdown_item);
        specialization_spinner.setAdapter(specialization_adapter);

        specialization_spinner.setVisibility(View.VISIBLE);

        name.setVisibility(View.VISIBLE);
        location_spinner.setVisibility(View.VISIBLE);
    }

    void doctorSelected () {
        specialization_adapter = ArrayAdapter.createFromResource(this, R.array.doctors_specialization,
                android.R.layout.simple_spinner_dropdown_item);
        specialization_spinner.setAdapter(specialization_adapter);

        specialization_spinner.setVisibility(View.VISIBLE);
        name.setVisibility(View.VISIBLE);
        location_spinner.setVisibility(View.VISIBLE);

    }

    void pharmacySelected () {
        specialization_spinner.setVisibility(View.INVISIBLE);
        name.setVisibility(View.INVISIBLE);
        location_spinner.setVisibility(View.INVISIBLE);
    }


}
