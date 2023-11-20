package com.example.helthreminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaSelecao extends AppCompatActivity {

    Button pacientes;

    Button novoPaciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_selecao);

        pacientes = (Button) findViewById(R.id.buttonSelecaoPaciente);

        pacientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TelaSelecao.this, TelaListaClientes.class));
            }
        });

        novoPaciente = (Button) findViewById(R.id.cadastroPaciente);

        novoPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TelaSelecao.this, TelaCadastroPaciente.class));
            }
        });





    }
}