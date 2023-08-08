package dev.android.monique.franca.app.lista.app_gerenciador_de_tarefas.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import dev.android.monique.franca.app.lista.app_gerenciador_de_tarefas.Controller.TarefaController;
import dev.android.monique.franca.app.lista.app_gerenciador_de_tarefas.Model.Tarefa;
import dev.android.monique.franca.app.lista.app_gerenciador_de_tarefas.R;

public class MainActivity extends AppCompatActivity {

    TarefaController controllerTarefa;
    Tarefa tarefa;


    EditText edittitulo;
    EditText editconteudo;
    EditText  editlembrete;
    TextView resultado;
    //ArrayList listatarefas;


    Button btnbuton_limpar;
    Button btnbuton_salvar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controllerTarefa= new TarefaController(MainActivity.this);
        controllerTarefa.toString();

        tarefa = new Tarefa();

        edittitulo = findViewById(R.id.txt_TituloTarefa);
        editconteudo = findViewById(R.id.text_descricaoTarefa);
        editlembrete =findViewById(R.id.txt_data);
        resultado = findViewById(R.id.textView);


        btnbuton_limpar = findViewById(R.id.button_excluir_Principal);
        btnbuton_salvar = findViewById(R.id.button_salvarPrincipal);



        btnbuton_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado.setText("");


                boolean dadosOk = true;

                if(TextUtils.isEmpty(edittitulo.getText())){
                    edittitulo.setError("Obrigatório");
                    edittitulo.requestFocus();
                    dadosOk = false;
                }
                if(TextUtils.isEmpty(editconteudo.getText())){
                    editconteudo.setError("Obrigatório");
                    editconteudo.requestFocus();
                    dadosOk = false;
                }
                if(TextUtils.isEmpty(editlembrete.getText())){
                    editlembrete.setError("Obrigatório");
                    editlembrete.requestFocus();
                    dadosOk = false;
                }

                if(dadosOk){
                    tarefa.setTitulo(String.valueOf(edittitulo.getText()));
                    tarefa.setConteudo(String.valueOf(editconteudo.getText()));
                    tarefa.setData(String.valueOf(editlembrete.getText()));


                    Toast.makeText(MainActivity.this, "Dados salvos com sucesso ", Toast.LENGTH_LONG).show();

                    controllerTarefa.salvar(tarefa);



                    resultado.setText(tarefa.getTitulo() +" - " + tarefa.getConteudo() +" - " +tarefa.getData() );
                    //listatarefas.add(resultado);



                }else{
                    Toast.makeText(MainActivity.this, "Digite os dados!", Toast.LENGTH_LONG).show();
                }



            }
        });


        btnbuton_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edittitulo.setText("");
                editconteudo.setText("");
                editlembrete.setText("");
                resultado.setText("");

                controllerTarefa.limpar(tarefa);




            }
        });

    }
}