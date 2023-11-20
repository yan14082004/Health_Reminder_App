package com.example.helthreminderapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String BANCO_DADOS_NOME = "realth_reminder";
    private static int BANCO_DADOS_VERSAO = 1;

    public DatabaseHelper (Context context){
        super(context,BANCO_DADOS_NOME,null,BANCO_DADOS_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE paciente(_id INTEGER PRIMARY KEY, nome TEXT, historico TEXT, nome_medicamento TEXT, quantidade_medicamento FLOAT, periodo_medicamento INTEGER, intervalo_medicamento INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versaoAnterior, int versaoProxima){

    }


}
