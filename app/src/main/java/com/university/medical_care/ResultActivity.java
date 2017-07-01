package com.university.medical_care;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.university.medical_care.Adapters.Doctor_adapter;
import com.university.medical_care.Adapters.Hospital_adapter;
import com.university.medical_care.Adapters.Pharmacy_adapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;


public class ResultActivity extends Activity {

   String key;
    Intent intent;
    ListView listView;
    String [] user_data;
    ArrayList list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

         intent = getIntent();
         key = intent.getStringExtra("key");
         listView= (ListView) findViewById(R.id.result_lv);
         user_data = new String[3];
         list = new ArrayList();

        switch (key) {

            case "p":  getPharmacy();   break;

            case "h":
                user_data[0] = intent.getStringExtra("name");
                user_data[1] = intent.getStringExtra("location");
                user_data[2] = intent.getStringExtra("specialization");
               getData();
                getHospital();

                break;

            case "d":
                user_data[0] = intent.getStringExtra("name");
                user_data[1] = intent.getStringExtra("location");
                user_data[2] = intent.getStringExtra("specialization");
                 getData();
                 getDoctor();

                break;
        }

    }

    //pharmacy method
    public void getPharmacy(){

        Pharmacy_adapter pharmacy_adapter;
        ArrayList<HashMap<String,String>> PharmacyData = new ArrayList<HashMap<String, String>>();

        InputStream is = getResources().openRawResource(R.raw.pharmacy);
        File_Reader file_reader = new File_Reader();

        try {
            String s = file_reader.Reader(is);
            JSONObject object = new JSONObject(s);
            JSONArray jsonArray = object.getJSONArray("pharmacy");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject c = (JSONObject) jsonArray.get(i);
                String name = c.getString("name");
                String location = c.getString("location");
                String address = c.getString("address");

                HashMap<String, String> map = new HashMap<String, String>();
                map.put("name", name);
                map.put("location", location);
                map.put("address", address);
                PharmacyData.add(map);

            }
            pharmacy_adapter = new Pharmacy_adapter(ResultActivity.this , R.layout.pharmacy_row ,PharmacyData);
            listView.setAdapter(pharmacy_adapter);
        } catch (Exception e) { e.printStackTrace(); }
    }

   //doctor method
    public void getDoctor(){

        Doctor_adapter doctor_adapter;
        ArrayList<HashMap<String,String>> DoctorData = new ArrayList<HashMap<String, String>>();

        InputStream is = getResources().openRawResource(R.raw.doctor);
        File_Reader file_reader = new File_Reader();
       int number = list.size();
        try {
            String s = file_reader.Reader(is);
            JSONObject object = new JSONObject(s);
            JSONArray jsonArray = object.getJSONArray("doctor");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject c = (JSONObject) jsonArray.get(i);
                String name = c.getString("name");
                String location = c.getString("location");
                String address = c.getString("address");
                String phone = c.getString("phone");
                String mobile = c.getString("mobile");
                String specialization= c.getString("specialization");

                switch (number) {

                    case 1:
                        String value = (String) list.get(0);
                        if (name.contains(value) || location.equals(value) || specialization.equals(value)) {
                            HashMap<String, String> map = new HashMap<String, String>();
                            map.put("name", name);
                            map.put("location", location);
                            map.put("address", address);
                            map.put("phone", phone);
                            map.put("mobile", mobile);
                            map.put("specialization", specialization);
                            DoctorData.add(map);
                        }
                        break;

                    case 2:
                        String v1 = (String) list.get(0);
                        String v2 = (String) list.get(1);
                        if ((name.contains(v1) && location.equals(v2)) || (name.contains(v2) && location.equals(v1))
                                || (name.contains(v1) && specialization.equals(v2)) || (name.contains(v2) && specialization.equals(v1))
                                || (location.equals(v1) && specialization.equals(v2)) || (location.equals(v2) && specialization.equals(v1))
                                ) {
                            HashMap<String, String> map = new HashMap<String, String>();
                            map.put("name", name);
                            map.put("location", location);
                            map.put("address", address);
                            map.put("phone", phone);
                            map.put("mobile", mobile);
                            map.put("specialization", specialization);
                            DoctorData.add(map);
                        }

                        break;

                    case 3:
                        String value1 = (String) list.get(0);
                        String value2 = (String) list.get(1);
                        String value3 = (String) list.get(2);

                        if (name.contains(value1) && location.equals(value2) && specialization.equals(value3)) {
                            HashMap<String, String> map = new HashMap<String, String>();
                            map.put("name", name);
                            map.put("location", location);
                            map.put("address", address);
                            map.put("phone", phone);
                            map.put("mobile", mobile);
                            map.put("specialization", specialization);
                            DoctorData.add(map);
                        }

                        break;
                }
            }
            if (DoctorData.isEmpty()){Toast.makeText(ResultActivity.this,"عذرا لا يوجد نتائج ",Toast.LENGTH_LONG).show();
             finish();}
            else {
                doctor_adapter = new Doctor_adapter(ResultActivity.this , R.layout.doctor_row ,DoctorData);
                listView.setAdapter(doctor_adapter);
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    //hospital method
    public void getHospital(){

        Hospital_adapter hospital_adapter;
        ArrayList<HashMap<String,String>> HospitalData = new ArrayList<HashMap<String, String>>();

        InputStream is = getResources().openRawResource(R.raw.hospital);
        File_Reader file_reader = new File_Reader();

         int number =  list.size();
        try {
            String s = file_reader.Reader(is);
            JSONObject object = new JSONObject(s);
            JSONArray jsonArray = object.getJSONArray("hospital");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject c = (JSONObject) jsonArray.get(i);
                String name = c.getString("name");
                String location = c.getString("location");
                String address = c.getString("address");
                String phone = c.getString("phone");
                String fax = c.getString("fax");
                String specialization= c.getString("specialization");

               switch (number){

                  case 1 :  String value = (String) list.get(0);
                          if (name.contains(value)||location.equals(value)||specialization.equals(value))
                        {
                            HashMap<String, String> map = new HashMap<String, String>();
                            map.put("name", name);
                            map.put("location", location);
                            map.put("address", address);
                            map.put("phone", phone);
                            map.put("fax", fax);
                            map.put("specialization", specialization);
                            HospitalData.add(map);
                       }
                        break;

                    case 2:
                         String v1 = (String) list.get(0);
                         String v2 = (String) list.get(1);
                        if ( (name.contains(v1)&&location.equals(v2)) ||(name.contains(v2)&&location.equals(v1))
                           || (name.contains(v1)&&specialization.equals(v2))||(name.contains(v2)&&specialization.equals(v1))
                           ||(location.equals(v1)&&specialization.equals(v2)) ||(location.equals(v2)&&specialization.equals(v1))
                           )
                        {
                            HashMap<String, String> map = new HashMap<String, String>();
                            map.put("name", name);
                            map.put("location", location);
                            map.put("address", address);
                            map.put("phone", phone);
                            map.put("fax", fax);
                            map.put("specialization", specialization);
                            HospitalData.add(map);
                        }

                        break;

                    case 3:  String value1 = (String)list.get(0);
                             String value2 = (String)list.get(1);
                             String value3 = (String)list.get(2);

                        if ( name.contains(value1)&&location.equals(value2)&&specialization.equals(value3))
                        {
                            HashMap<String, String> map = new HashMap<String, String>();
                            map.put("name", name);
                            map.put("location", location);
                            map.put("address", address);
                            map.put("phone", phone);
                            map.put("fax", fax);
                            map.put("specialization", specialization);
                            HospitalData.add(map);
                        }


                        break;
                }

            }
           if (HospitalData.isEmpty()){ Toast.makeText(ResultActivity.this,"عذرا لا يوجد نتائج ",Toast.LENGTH_LONG).show();
               finish();}
            else {
               hospital_adapter = new Hospital_adapter(ResultActivity.this , R.layout.hospital_row ,HospitalData);
               listView.setAdapter(hospital_adapter);
           }
        } catch (Exception e) { e.printStackTrace(); }
    }

    // get data
    private void getData() {

        for (int i = 0; i < user_data.length; i++) {
           if (user_data[i].isEmpty()|| user_data[i].equals("التخصص")||user_data[i].equals("الموقع")) {}
          else {list.add(user_data[i]);}
        } }


}




