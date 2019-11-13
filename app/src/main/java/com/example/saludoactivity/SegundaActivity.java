package com.example.saludoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    private TextView txtNombre, txtEdad, txtElige;
    private CheckBox chkDespedida;
    private RadioGroup rgDespedida;
    private RadioButton rbAdios, rbHastaluego;
    private Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        txtNombre = findViewById(R.id.txtNombre);
        txtEdad = findViewById(R.id.txtEdad);
        chkDespedida = findViewById(R.id.chkDespedida);
        txtElige = findViewById(R.id.txtElige);
        rgDespedida = findViewById(R.id.rgDespedida);
        rbAdios = findViewById(R.id.rbAdios);
        rbHastaluego = findViewById(R.id.rbHastaluego);
        btnVolver = findViewById(R.id.btnVolver);

        Intent i = getIntent();

        txtNombre.setText("Hola, " + i.getStringExtra("nombre") + "!!!");
        int edad = i.getIntExtra("edad", 0);
        if (edad >= 18) {
            txtEdad.setText("Eres mayor de edad");
        } else {
            txtEdad.setText("Eres menor de edad");
        }

        chkDespedida.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    txtElige.setVisibility(View.VISIBLE);
                    rgDespedida.setVisibility(View.VISIBLE);
                } else {
                    txtElige.setVisibility(View.GONE);
                    rgDespedida.setVisibility(View.GONE);
                }
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String despedida;
                Intent i = new Intent();
                if (chkDespedida.isChecked()) {
                    if (rbAdios.isChecked()) {
                        despedida = "Adiós";
                    } else {
                        despedida = "Hasta luego";
                    }
                    i.putExtra("despedida", despedida);
                }
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}
