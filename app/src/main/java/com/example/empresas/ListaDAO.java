package com.example.empresas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ListaDAO {

    public static final void inserir(Lista empresa, Context context){
        Banco banco = new Banco(context);
        ContentValues valores = new ContentValues();
        valores.put("nome_empresa", empresa.getNome() );
        SQLiteDatabase db = banco.getWritableDatabase();
        db.insert("empresas", null, valores);
    }

    public static final void excluir(int idLista, Context context){
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();
        db.delete("empresas", "id_empresa = "+idLista, null);
        db.delete("Vagas", "id_empresa_FK = "+idLista, null);
    }

    public static final List<Lista> listar(Context context){
        List<Lista> lista = new ArrayList<>();
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getReadableDatabase();
        String sql = "SELECT * FROM empresas ORDER BY id_empresa DESC ";
        Cursor cursor = db.rawQuery(sql, null);
        if ( cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do{
                Lista empresa = new Lista();
                empresa.setId( cursor.getInt( 0 ) );
                empresa.setNome( cursor.getString( 1 ) );
                lista.add( empresa );
            }while ( cursor.moveToNext() );
        }
        return lista;
    }

}
