package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {


    ListView listita;
    ArrayList<String> lista = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listita = findViewById(R.id.listita);
        lista = getIntent().getStringArrayListExtra("lista");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity2.this, R.layout.support_simple_spinner_dropdown_item, lista );
        listita.setAdapter(adapter);

    }
}