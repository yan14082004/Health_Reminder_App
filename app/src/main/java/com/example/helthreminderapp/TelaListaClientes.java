package com.example.helthreminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class TelaListaClientes extends AppCompatActivity {

    DatabaseHelper helper;

    ArrayList <Pacientes> pacientesCadastrados;

    ListView listapacientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista_clientes);

        helper = new DatabaseHelper(this);

        pacientesCadastrados = new ArrayList<Pacientes>();

        listapacientes = (ListView) findViewById(R.id.ListViewListaPacientes);


        ArrayAdapter <String> listapacientesadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,lerPacientes());

        listapacientes.setAdapter(listapacientesadapter);

    }

    private String[] lerPacientes(){
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT _id,nome,historico,nome_medicamento,quantidade_medicamento,periodo_medicamento,intervalo_medicamento FROM paciente", null);
        cursor.moveToFirst();
        String [] pacienteslidos = new String[cursor.getCount()];
        for (int item = 0; item < cursor.getCount(); item++){
            pacientesCadastrados.add(new Pacientes(cursor.getLong(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getFloat(4),cursor.getInt(5),cursor.getInt(6)));
            pacienteslidos[item] = cursor.getString(1);
        }

        cursor.close();

        return pacienteslidos;

    }
}