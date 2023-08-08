package dev.android.monique.franca.app.lista.app_gerenciador_de_tarefas.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TarefaData extends SQLiteOpenHelper {

    private static final String DB_NAME = "tarefas.db";
    private static final int DB_VERSION =1;

    Cursor cursor;
    SQLiteDatabase db;


    public TarefaData(Context context) {
        super(context,DB_NAME,null,DB_VERSION);

        db=getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlTabelaTarefas
                = "CREATE TABLE Tarefas (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "titulo TEXT," +
                "conteudo TEXT, " +
                "data TEXT)";

        db.execSQL(sqlTabelaTarefas);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void salvarDados(String tabela, ContentValues dados){
        db.insert(tabela,null,dados);

    }

    //TODO: criar métodos para implementar um Crud
}