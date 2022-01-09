package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText nmb;
    EditText num;
    ArrayList<String> lista = new ArrayList<String>();
    int result;
    private static final int REQUEST_IMAGE_CAPTURE = 1;


    static int getRandomNumber(int max, int min)
    {
        return (int)((Math.random()
                * (max - min)) + min);
    }

    public void makeToast(String str)
    {
        Toast.makeText(
                MainActivity.this,
                str,
                Toast.LENGTH_SHORT)
                .show();
    }

    public void clickFunction(View view)
    {
        int userGuessing;
        EditText variable
                = (EditText)findViewById(
                R.id.num);
        userGuessing
                = Integer.parseInt(
                variable
                        .getText()
                        .toString());
        if (userGuessing < result) {

            makeToast("prueba un numero mas grande");
        }
        else if (userGuessing > result) {
            makeToast("prueba un numero mas pequeño");
        }
        else {

            lista.add(nmb.getText().toString());
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putStringArrayListExtra("lista", lista);

            int min = 1;
            int max = 5;
            result = getRandomNumber(min, max);



            startActivity(intent);
            dispatchTakePictureIntent();
            
            makeToast(
                    "felicidades");

        }
    }




    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
            Toast.makeText(this, "no es pot obrir", Toast.LENGTH_LONG).show();

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        nmb = findViewById(R.id.nmb);
        num = findViewById(R.id.num);
        num= findViewById(R.id.num);



    }
}