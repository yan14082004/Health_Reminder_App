package com.example.pupfeeder;

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

public class TelaListaPaciente extends AppCompatActivity {

    DatabaseHelper helper;

    ArrayList<Pacientes> pacientescadastrados;

    ListView listarpacientes;

    Button novopaciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista_pacientes);

        helper = new DatabaseHelper(this);

        pacientescadastrados = new ArrayList<Pacientes>();

        listarpacientes = (ListView) findViewById(R.id.ListViewListaRacoes);

        novopaciente = (Button) findViewById(R.id.buttonListaNovaRacao);

        novopaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TelaListaPaciente.this, TelaCadastroPaciente.class));
            }
        });

        ArrayAdapter <String> listaracoesadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,lerRacoes());

        listarpacientes.setAdapter(listaracoesadapter);

        listarpacientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(TelaListaPaciente.this, TelaCadastroPaciente.class);
                intent.putExtra("paciente_id",pacientescadastrados.get(i).getId().toString());
                startActivity(intent);
            }
        });

        listarpacientes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                SQLiteDatabase db = helper.getWritableDatabase();
                db.delete("racoes","_id = ?",new String[]{pacientescadastrados.get(i).getId().toString()});

                return true;
            }
        });


    }

    private String [] lerRacoes(){
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT _id,nome,nome_medicamento,periodo_medicamento,intervalo_medicamento from paciente",null);
        cursor.moveToFirst();
        String [] racoeslidas = new String[cursor.getCount()];
        for(int item = 0; item <cursor.getCount();item++){
            pacientescadastrados.add(new Pacientes(cursor.getLong(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4)));
            racoeslidas[item] = cursor.getString(1);
            cursor.moveToNext();
        }
        cursor.close();

        return racoeslidas;
    }




}