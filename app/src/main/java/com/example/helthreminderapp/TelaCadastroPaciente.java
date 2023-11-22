package com.example.helthreminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class TelaCadastroPaciente extends AppCompatActivity {

    DatabaseHelper helper;

    EditText nome;
    EditText nome_remedio;
    Spinner periodo_remedio;
    Spinner intervalo_remedio;
    Button salvar;
    Button excluir;
    String paciente_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_paciente);
        paciente_id = getIntent().getStringExtra("paciente_id");

        nome = findViewById(R.id.editTextTelaCadastroPacienteNome);
        nome_remedio = findViewById(R.id.editTextTelaCadastroPacienteRemedio);
        periodo_remedio = findViewById(R.id.spinnerTelcCadastroPacietnePeriodo);
        intervalo_remedio = findViewById(R.id.spinnerTelaCadastroPaciente);
        salvar = findViewById(R.id.buttonTelaCadastroPacienteSalvar);
        excluir = findViewById(R.id.buttonTelaCadastroPacienteExcluir);
        helper = new DatabaseHelper(this);

        if(paciente_id!=null){
            prepararEdicao();
        }else{
            nome.setText("");
            nome_remedio.setText("");
        }

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarPaciente(view);
            }
        });

        excluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                excluirPaciente(view);
            }
        });

    }

    public void prepararEdicao(){
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT nome, nome_remedio, periodo_remedio, intervalo_remedio from racoes WHERE _id = ?",new String[]{paciente_id});
        cursor.moveToFirst();
        nome.setText(cursor.getString(0));
        nome_remedio.setText(cursor.getString(1));
        String[] periodo_remedio = getResources().getStringArray(R.array.activity_tela_cadastro_paciente_periodo_lista);
        for(int item=0;item < periodo_remedio.length;item++){
            if(periodo_remedio[item].equals(cursor.getString(2))){
                nome.setSelection(item);
            }
        }
        String[] intervalo_remedio = getResources().getStringArray(R.array.activity_tela_cadastro_paciente_intervalo_lista);
        for(int item=0;item < intervalo_remedio.length;item++){
            if(intervalo_remedio[item].equals(cursor.getString(3)));
        }
    }


    public void salvarPaciente(View view) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        if (nome.getText().length() > 0 && nome_remedio.getText().length() > 0) {
            valores.put("nome", nome.getText().toString());
            valores.put("nome_remedio", nome_remedio.getText().toString());
            valores.put("periodo_remedio", periodo_remedio.getSelectedItem().toString());
            valores.put("intervalo_remedio", intervalo_remedio.getSelectedItem().toString());
            long resultado;
            if(paciente_id == null) {
                resultado = db.insert("paciente", null, valores);
            }else{
                resultado = db.update("paciente",valores,"_id = ?",new String[]{paciente_id});
            }

            if (resultado != -1) {
                Toast.makeText(this, getString(R.string.activity_tela_cadastro_paciente_salvo_com_sucesso), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, getString(R.string.activity_tela_cadastro_paciente_erro_ao_salvar), Toast.LENGTH_LONG).show();
            }

        } else
        {
            Toast.makeText(this, getString(R.string.activity_tela_cadastro_paciente_campos_vazios),Toast.LENGTH_SHORT).show();
        }

        startActivity(new Intent(TelaCadastroPaciente.this, TelaListaPacientes.class));

    }

    public void excluirPaciente(View view){
        SQLiteDatabase db = helper.getWritableDatabase();
        long resultado = db.delete("paciente","_id = ?",new String[]{paciente_id});
        if (resultado != -1) {
            Toast.makeText(this, "Ração excluída com sucesso", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Falha ao excluir a ração", Toast.LENGTH_LONG).show();
        }
        startActivity(new Intent(TelaCadastroPaciente.this, TelaListaPacientes.class));
    }

}