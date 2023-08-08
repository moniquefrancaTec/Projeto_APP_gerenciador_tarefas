package dev.android.monique.franca.app.lista.app_gerenciador_de_tarefas.View;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import dev.android.monique.franca.app.lista.app_gerenciador_de_tarefas.Database.TarefaData;
import dev.android.monique.franca.app.lista.app_gerenciador_de_tarefas.R;


public class splashActivity extends AppCompatActivity {

    public static final int TIME_OUT_SPLASH =6000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TelaSplash();

    }

    private void TelaSplash(){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

               TarefaData db = new TarefaData(splashActivity.this);

                Intent telaPrincipal = new Intent(splashActivity.this,MainActivity.class);
                startActivity(telaPrincipal);
                finish();

            }
        },TIME_OUT_SPLASH);

    }
}