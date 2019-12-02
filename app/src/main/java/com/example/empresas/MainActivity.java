package com.example.empresas;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvLista;
    List<Lista> lista;
    AdapterNomeEmpresa adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lvLista = (ListView) findViewById(R.id.lvNomeEmpresa);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, ViewAddList.class);
                startActivity(in);
            }

        });

        lvLista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                final Lista listaSelecionada = lista.get(position);
                AlertDialog.Builder alerta =
                        new AlertDialog.Builder(MainActivity.this);
                alerta.setTitle(R.string.deletar);
                alerta.setMessage(listaSelecionada.getNome());
                alerta.setPositiveButton(R.string.sim, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ListaDAO.excluir(listaSelecionada.getId(),
                                MainActivity.this);

                        lista.remove( position);
                        carregarLista();

                        adapter.notifyDataSetChanged();

                    }
                });
                alerta.setNeutralButton(R.string.nao, null);
                alerta.show();


                return true;
            }
        });

        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Lista listaSelecionada = lista.get(position);
                Intent in = new Intent(MainActivity.this, ListaVaga.class);
                in.putExtra("idLista1",listaSelecionada.getId());
                //in.putExtra("nomeLista",listaSelecionada.getTitulo());
                startActivity(in);
            }
        });
    }

    private void carregarLista(){

        lista = ListaDAO.listar(this);
        adapter = new AdapterNomeEmpresa(this, lista);
        lvLista.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarLista();
    }

}






