package com.example.helthreminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class TelaListaClientes extends AppCompatActivity {

    ListView listapacientes;

    Button novoPaciente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista_clientes);

        listapacientes = (ListView) findViewById(R.id.ListViewListaPacientes);

        novoPaciente = (Button) findViewById(R.id.buttonListaNovoPaciente);

        novoPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TelaListaClientes.this, AreaCadastroCliente.class));
            }
        });

        String [] pacientes = new String[]{"Yan Felipe","Marcos Aurélio","Felipe Sousa"};

        ArrayAdapter <String> listapacientesadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,pacientes);

        listapacientes.setAdapter(listapacientesadapter);

    }
}