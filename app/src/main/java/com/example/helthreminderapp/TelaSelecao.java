package com.example.helthreminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaSelecao extends AppCompatActivity {

    Button Pacientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_selecao);

        Pacientes = (Button) findViewById(R.id.buttonSelecaoPaciente);

        Pacientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TelaSelecao.this, TelaListaPacientes.class));
            }
        });

    }
}