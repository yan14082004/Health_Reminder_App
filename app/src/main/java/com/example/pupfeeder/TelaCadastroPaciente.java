package com.example.pupfeeder;

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
    EditText nome_medicamento;
    Spinner periodo_medicamento;
    Spinner intervalo_medicamento;
    Button salvar;
    Button excluir;
    String paciente_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_paciente);
        paciente_id = getIntent().getStringExtra("paciente_id");

        nome = findViewById(R.id.editTextTelaCadstroRacoesMarca);
        nome_medicamento = findViewById(R.id.editTextTelaCadastroRacoesQuantidade);
        periodo_medicamento = findViewById(R.id.spinnerTelcCadastroRacoesTipo);
        intervalo_medicamento = findViewById(R.id.spinnerTelaCadastroRacoesPorte);
        salvar = findViewById(R.id.buttonTelaCadastroRacoesSalvar);
        excluir = findViewById(R.id.buttonTelaCadastroRacoesExcluir);
        helper = new DatabaseHelper(this);

        if(paciente_id!=null){
            prepararEdicao();
        }else{
            nome.setText("");
            nome_medicamento.setText("");
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
        Cursor cursor = db.rawQuery("SELECT nome, nome_medicamento, periodo_medicamento, intervalo_medicamento from paciente WHERE _id = ?",new String[]{paciente_id});
        cursor.moveToFirst();
        nome.setText(cursor.getString(0));
        nome_medicamento.setText(cursor.getString(1));
        String[] tipos = getResources().getStringArray(R.array.activity_tela_cadastro_paciente_periodo_lista);
        for(int item=0;item < tipos.length;item++){
            if(tipos[item].equals(cursor.getString(2))){
                periodo_medicamento.setSelection(item);
            }
        }
        String[] portes = getResources().getStringArray(R.array.activity_tela_cadastro_paciente_intervalo_lista);
        for(int item=0;item < portes.length;item++){
            if(portes[item].equals(cursor.getString(3)));
        }
    }


    public void salvarPaciente(View view) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        if (nome.getText().length() > 0 && nome_medicamento.getText().length() > 0) {
            valores.put("nome", nome.getText().toString());
            valores.put("nome_medicamento", nome_medicamento.getText().toString());
            valores.put("periodo_medicamento", periodo_medicamento.getSelectedItem().toString());
            valores.put("intervalo_medicamento", intervalo_medicamento.getSelectedItem().toString());
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

        startActivity(new Intent(TelaCadastroPaciente.this, TelaListaPaciente.class));

    }

    public void excluirPaciente(View view){
        SQLiteDatabase db = helper.getWritableDatabase();
        long resultado = db.delete("paciente","_id = ?",new String[]{paciente_id});
        if (resultado != -1) {
            Toast.makeText(this, "Paciente excluído com sucesso", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Falha ao excluir paciente", Toast.LENGTH_LONG).show();
        }
        startActivity(new Intent(TelaCadastroPaciente.this, TelaListaPaciente.class));
    }

}