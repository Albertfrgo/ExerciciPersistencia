package com.example.exercicipersistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    EditText textGuardar;
    Button botoGuardar;

    String contingutText;
    File arxiuInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textGuardar=findViewById(R.id.textGuardar);

        botoGuardar=findViewById(R.id.botoGuardar);

        botoGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    contingutText=textGuardar.getText().toString();
                    this.getFilesDir();
                }catch(Exception e){
                    Log.i("INFO", "Error alhora de guardar el text");
                }
            }
        });
    }
}