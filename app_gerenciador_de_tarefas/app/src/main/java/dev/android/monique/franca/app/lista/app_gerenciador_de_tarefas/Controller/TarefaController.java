package dev.android.monique.franca.app.lista.app_gerenciador_de_tarefas.Controller;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import dev.android.monique.franca.app.lista.app_gerenciador_de_tarefas.Database.TarefaData;
import dev.android.monique.franca.app.lista.app_gerenciador_de_tarefas.Model.Tarefa;
import dev.android.monique.franca.app.lista.app_gerenciador_de_tarefas.View.MainActivity;

public class TarefaController extends TarefaData {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;

    public static final String NOME_PREFERENCES = "pref_listavip";

    public TarefaController(MainActivity activity) {
        super(activity);

        preferences = activity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();

    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "Controller iniciada....");
        return super.toString();
    }


    public void salvar(Tarefa tarefa) {
        Log.d("MVC_Controller", "Salvo: " + tarefa.toString());

        ContentValues dados = new ContentValues();
        dados.put("titulo", tarefa.getTitulo());
        dados.put("conteudo", tarefa.getConteudo());
        dados.put("data", tarefa.getData());
        salvarDados("Tarefas", dados);

    }


    public void limpar(Tarefa tarefa) {
        ContentValues dados = new ContentValues();
        dados.remove(tarefa.getTitulo());
        dados.remove(tarefa.getConteudo());
        dados.remove(tarefa.getData());

        salvarDados("Tarefas", dados);

    }
}


