package com.example.saludoactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtNombre, edtEdad;
    private Button btnSaludo;
    private static final int COD_LLAMADA_1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNombre = findViewById(R.id.edtNombre);
        edtEdad = findViewById(R.id.edtEdad);
        btnSaludo = findViewById(R.id.btnSaludo);

        btnSaludo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String nombre = edtNombre.getText().toString();
                    int edad = Integer.parseInt(edtEdad.getText().toString());
                    if(!nombre.isEmpty()){
                        Intent i = new Intent(MainActivity.this, SegundaActivity.class);
                        i.putExtra("nombre", nombre);
                        i.putExtra("edad", edad);
                        startActivityForResult(i, COD_LLAMADA_1);
                    } else {
                        Toast.makeText(MainActivity.this, "Debes escribir un nombre", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Debes escribir una edad", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == COD_LLAMADA_1 && resultCode == RESULT_OK) {
            String despedida = data.getStringExtra("despedida");
            if (!despedida.isEmpty()) {
                Toast.makeText(MainActivity.this, despedida, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
