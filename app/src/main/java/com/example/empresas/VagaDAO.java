package com.example.empresas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class VagaDAO {

    public static final void inserir(Vaga item, int idLista, Context context) {
        Banco banco = new Banco(context);
        ContentValues valores = new ContentValues();
        valores.put("nome_Vaga", item.getNomeVaga());
        valores.put("numero_camiseta", item.getNumeroCamisa());
        //valores.put("valorProduto", item.getValor());
        valores.put("id_empresa_FK", idLista);
        SQLiteDatabase db = banco.getWritableDatabase();
        db.insert("Vagas", null, valores);
    }

    public static final void excluir(int idVaga, Context context) {
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();
        db.delete("Vagas", "id_Vaga = " + idVaga, null);
    }

    public static final List<Vaga> listar(Context context, int idLista) {
        List<Vaga> listaVaga = new ArrayList<>();
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getReadableDatabase();

        String sql = "SELECT * FROM Vagas WHERE id_empresa_FK = " + idLista;
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                Vaga vaga = new Vaga();
                vaga.setIdVaga(cursor.getInt(0));
                vaga.setNomeVaga(cursor.getString(2));
                vaga.setNumeroCamisa(cursor.getInt(3));
                //vaga.setValor(cursor.getDouble(4));
                listaVaga.add(vaga);

            } while (cursor.moveToNext());
        }

        return listaVaga;
    } public static final List<Vaga> listarTudo(Context context) {
        List<Vaga> listaVaga = new ArrayList<>();
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getReadableDatabase();

        String sql = "SELECT * FROM Vagas";
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                Vaga item = new Vaga();
                item.setIdVaga(cursor.getInt(0));
                item.setNomeVaga(cursor.getString(2));
                item.setNumeroCamisa(cursor.getInt(3));
                //item.setValor(cursor.getDouble(4));
                //System.out.println("DAO: TODOS PRODUTOS - " + " IDITEM:" + cursor.getInt(0) + " IDLISTA:" + cursor.getInt(1) + " NOME:" + cursor.getString(2) + " QTD:" + cursor.getInt(3) + " PRECO:" + cursor.getDouble(4));
                listaVaga.add(item);

            } while (cursor.moveToNext());
        }

        return listaVaga;
    }

}
