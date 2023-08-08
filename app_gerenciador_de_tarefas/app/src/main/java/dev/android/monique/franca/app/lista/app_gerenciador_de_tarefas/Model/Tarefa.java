package dev.android.monique.franca.app.lista.app_gerenciador_de_tarefas.Model;

public class Tarefa {
    private String  titulo;
    private String  conteudo;
    private String  data;


    public Tarefa() {

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
