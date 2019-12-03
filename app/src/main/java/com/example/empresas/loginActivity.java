package com.example.empresas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginActivity extends AppCompatActivity {
    private EditText tvEmail, tvPassword;
    private Button btnEntrar;
    private FirebaseAuth autenticacao;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        autenticacao = FirebaseAuth.getInstance();

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if ( user != null ){
                    Intent intent = new Intent( loginActivity.this,
                            MainActivity.class);
                    startActivity( intent );
                }

            }
        };

        tvEmail = (EditText) findViewById(R.id.tvEmail);
        tvPassword = (EditText) findViewById(R.id.tvPassword);
        btnEntrar = (Button) findViewById(R.id.btnEntrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                entrar();
            }
        });
    }

    private void entrar(){
        String email = tvEmail.getText().toString();
        String senha = tvPassword.getText().toString();
        if( !email.isEmpty() ){
            autenticacao.signInWithEmailAndPassword(email,senha)
                    .addOnCompleteListener(this,
                            new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if( !task.isSuccessful()){
                                        Toast.makeText(loginActivity.this,
                                                "Erro ao efetuar o login",
                                                Toast.LENGTH_LONG).show();
                                    }else {
                                        Toast.makeText(loginActivity.this,
                                                "Sucesso ao efetuar o login",
                                                Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(loginActivity.this, MainActivity.class);
                                        startActivity(intent);
                                    }
                                }
                            });
        }else{
            Toast.makeText(loginActivity.this,
                    "Errrroooouuu",
                    Toast.LENGTH_LONG).show();
        }
    }
}