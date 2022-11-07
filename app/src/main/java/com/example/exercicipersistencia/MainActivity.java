package com.example.exercicipersistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText textGuardar;
    Button botoGuardar;

    String contingutText;
    File directori;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this.context;

        textGuardar=findViewById(R.id.textGuardar);

        botoGuardar=findViewById(R.id.botoGuardar);

        directori=this.getFilesDir();

        botoGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    contingutText="\n"+textGuardar.getText().toString();
                    FileOutputStream fou = openFileOutput("dades.txt", MODE_APPEND);
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fou);
                    outputStreamWriter.write(contingutText);
                    outputStreamWriter.close();

                    Log.i("INFO_II", "S'ha desat el text a "+directori.toString());
                }catch(Exception e){
                    Log.i("INFO_II", "Error alhora de desar el text");
                    Log.i("INFO_II", e.getStackTrace().toString());
                }
            }

        });


    }
}