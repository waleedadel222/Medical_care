package com.university.medical_care;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by waleed on 2015-09-06.
 */
public class File_Reader  {

    public static String Reader (InputStream is) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) { sb.append(line).append("\n"); }
        reader.close();


    return sb.toString();
    }


    }


