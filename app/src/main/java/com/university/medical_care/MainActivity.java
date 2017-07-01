package com.university.medical_care;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.university.medical_care.Adapters.Pharmacy_adapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends Activity implements View.OnClickListener {



    Button login_button , about_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login_button = (Button) findViewById(R.id.login);
        login_button.setOnClickListener(this);

        about_button = (Button) findViewById(R.id.about);
        about_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){

          case R.id.login : Intent intent = new Intent(MainActivity.this ,SearchActivity.class);
                             startActivity(intent);
                             break;

         case R.id.about: Intent intent_1 = new Intent(MainActivity.this ,AboutActivity.class);
                          startActivity(intent_1);
                         break;
        }

    }
}