package com.example.helthreminderapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String BANCO_DADOS_NOME = "health_reminder";
    private static int BANCO_DADOS_VERSAO = 1;

    public DatabaseHelper(Context context){
        super(context,BANCO_DADOS_NOME,null,BANCO_DADOS_VERSAO);
    }

    @Override
    public void oncreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE paciente(_id INTEGER PRIMARY KEY, nome TEXT, telefone INTEGER, " +
                "cpf TEXT(11) UNIQUE, endereco TEXT, data_nasc DATE, historico TEXT, " +
                "medicamento TEXT, quantidade_medicamento TEXT, intervalo_medicamento INTEGER, periodo_medicamento INTEGER);");
    }

    @Override
    public void onUpdate(SQLiteDatabase db, int versaoAnterior, int versaoProxima){

    }

}
