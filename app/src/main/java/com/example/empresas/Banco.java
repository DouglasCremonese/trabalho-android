package com.example.empresas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Banco extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "empresas";
    private static final int VERSAO_BANCO = 1;

    public Banco(Context context){
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS empresas ( id_empresa INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, nome_empresa TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS Vagas ( id_vaga INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "id_empresa_FK INTEGER, nome_vaga TEXT, numero_camiseta INTEGER, FOREIGN KEY(id_empresa_FK) references empresas(id_empresa) )");
//

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
