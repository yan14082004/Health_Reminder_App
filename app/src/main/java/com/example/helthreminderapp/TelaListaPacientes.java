package com.example.helthreminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class TelaListaPacientes extends AppCompatActivity {

    DatabaseHelper helper;

    ArrayList<Pacientes> pacientecadastrados;

    ListView listarpacientes;

    Button novopaciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista_pacientes);

        helper = new DatabaseHelper(this);

        pacientecadastrados = new ArrayList<Pacientes>();

        novopaciente = (Button) findViewById(R.id.buttonListaNovoPaciente);

        novopaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TelaListaPacientes.this, TelaCadastroPaciente.class));
            }
        });

        ArrayAdapter <String> listarpacientesadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,lerPaciente());

        listarpacientes.setAdapter(listarpacientesadapter);

        listarpacientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(TelaListaPacientes.this, TelaCadastroPaciente.class);
                intent.putExtra("paciente_id",pacientecadastrados.get(i).getId().toString());
                startActivity(intent);
            }
        });

        listarpacientes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                SQLiteDatabase db = helper.getWritableDatabase();
                db.delete("paciente","_id = ?",new String[]{pacientecadastrados.get(i).getId().toString()});

                return true;
            }
        });


    }

    private String [] lerPaciente(){
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT _id,nome,nome_remedio,periodo_remedio,intervalo_remedio from paciente",null);
        cursor.moveToFirst();
        String [] pacienteslidos = new String[cursor.getCount()];
        for(int item = 0; item <cursor.getCount();item++){
            pacientecadastrados.add(new Pacientes(cursor.getLong(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4)));
            pacienteslidos[item] = cursor.getString(1);
            cursor.moveToNext();
        }
        cursor.close();

        return pacienteslidos;
    }




}