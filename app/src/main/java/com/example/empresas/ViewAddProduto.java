package com.example.empresas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ViewAddProduto extends AppCompatActivity {

    private EditText edtNomeVaga;
    //private EditText edtQntdProduto;
    private EditText edtNumeroCamisa;
    private Button btnCadastrarVaga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_add_vaga);

        edtNomeVaga = (EditText)findViewById(R.id.edtNomeVaga);
        //edtQntdProduto = (EditText)findViewById(R.id.edtQntdProduto);
        edtNumeroCamisa = (EditText)findViewById(R.id.edtNumeroCamisa);
        btnCadastrarVaga = (Button)findViewById(R.id.btnCadastrarVaga);

        btnCadastrarVaga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });

    }

    public void salvar(){
        Vaga j = new Vaga();
        j.setNomeVaga( edtNomeVaga.getText().toString() );
        //p.setQtdProduto(Integer.parseInt(edtQntdProduto.getText().toString()));
        j.setNumeroCamisa(Integer.parseInt(edtNumeroCamisa.getText().toString()));
        VagaDAO.inserir( j, getIntent().getExtras().getInt("idLista2"), this );
        this.finish();
    }
}
