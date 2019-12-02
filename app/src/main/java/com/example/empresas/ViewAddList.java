package com.example.empresas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ViewAddList extends AppCompatActivity {

    private EditText edtNome;
    private Button btnSalvar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_add_empresa);

        edtNome = (EditText)findViewById(R.id.edtNome);
        btnSalvar = (Button)findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });
    }
    private void salvar(){
        Lista compra = new Lista();
        compra.setNome( edtNome.getText().toString() );
        ListaDAO.inserir(compra, this);
        this.finish();

    }
}

