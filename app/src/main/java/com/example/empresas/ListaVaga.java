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

public class ListaVaga extends AppCompatActivity {

    ListView lvListaVaga;
    List<Vaga> vagas;
    AdapterListaVaga adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_vaga);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lvListaVaga = (ListView) findViewById(R.id.lvListaVaga);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(ListaVaga.this, ViewAddProduto.class);
                in.putExtra("idLista2", getIntent().getExtras().getInt("idLista1"));
                startActivity(in);
            }
        });


        lvListaVaga.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                final Vaga listaSelecionada = vagas.get(position);
                AlertDialog.Builder alerta =
                        new AlertDialog.Builder(ListaVaga.this);
                alerta.setTitle(R.string.deletarVaga);
                alerta.setMessage(listaSelecionada.getNomeVaga());
                alerta.setPositiveButton(R.string.sim, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        VagaDAO.excluir(listaSelecionada.getIdVaga(),
                                ListaVaga.this);

                        vagas.remove(position);
                        carregarVagaPorEmpresa();

                        adapter.notifyDataSetChanged();

                    }
                });
                alerta.setNeutralButton(R.string.nao, null);
                alerta.show();


                return true;
            }
        });
            lvListaVaga.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    AlertDialog.Builder alerta =
                            new AlertDialog.Builder(ListaVaga.this);
                    alerta.setTitle("VOCÊ SE CANDITADOU A VAGA!");
                    alerta.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }


                    });
                    alerta.show();
    }});}

    private void carregarVagaPorEmpresa(){
        vagas = VagaDAO.listar(this, getIntent().getExtras().getInt("idLista1"));
        adapter = new AdapterListaVaga(this, vagas);
        lvListaVaga.setAdapter(adapter);
    }



    @Override
    protected void onResume() {
        super.onResume();
        carregarVagaPorEmpresa();
    }


}