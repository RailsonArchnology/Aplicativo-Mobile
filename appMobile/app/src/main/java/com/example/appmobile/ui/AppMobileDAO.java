package com.example.appmobile.ui;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AppMobileDAO extends SQLiteOpenHelper {
    private final String TABELA_CLIENTE = "TB_CLIENTE";
    private final String TABELA_SOCIO = "TB_SOCIO";
    private final String TABELA_CARGO = "TB_LOGIN";
    private final String TABELA_SERVICO = "TB_SERVICO";
    private final String TABELA_CONTRATO = "TB_CONTRATO";
    private final String TABELA_ATIVIDADE = "TB_ATIVIDADE";
    private final String TABELA_ATIVIDADE_SOCIO = "TB_ATIVIDADE_SOCIO";

    public AppMobileDAO(@Nullable Context context){ super(context, "DB_AppArchnology", null, 1 );}
    @Override
    public void onCreate(SQLiteDatabase db) {
        String comandoCliente = "CREATE TABLE " + TABELA_CLIENTE + "(" +
                "COD_CLIENTE INTEGER PRIMARY KEY," +
                "NOME_CLIENTE VARCHAR(50),"+
                "TELEFONE_CLIENTE VARCHAR(20)," +
                "EMAIL_CLIENTE VARCHAR(50)," +
                "CPF_CLIENTE VARCHAR(14),"+
                "ENDERECO VARCHAR(50)," +
                "COMPLEMENTO VARCHAR(30)," +
                "BAIRRO VARCHAR(50), " +
                "CIDADE VARCHAR(40)," +
                "ESTADO VARCHAR(30),"+
                "UF_ESTADO CHAR(2))";
        db.execSQL(comandoCliente);

        String comandoSocio = "CREATE TABLE " + TABELA_SOCIO + "(" +
                "USUARIO_SOCIO INTEGER PRIMARY KEY, " +
                "NOME_SOCIO VARCHAR(50)," +
                "CARGO_SOCIO VARCHAR(30)," +
                "EMAIL_SOCIO VARCHAR(40)," +
                "TELEFONE_SOCIO VARCHAR(20)," +
                "SENHA_LOGIN VARCHAR(20))";
        db.execSQL(comandoSocio);

        String comandoServico = "CREATE TABLE " + TABELA_SERVICO + "(" +
                "COD_SERVICO INTEGER PRIMARY KEY, " +
                "TIPO_SERVICO VARCHAR(100))";
        db.execSQL(comandoServico);

        String comandoContrato = "CREATE TABLE " + TABELA_CONTRATO + "( "+
                "COD_CONTRATO INTEGER PRIMARY KEY," +
                "DESC_CONTRATO VARCHAR(100)," +
                "CODIGO_CLIENTE INTEGER," +
                "USUARIO_SOCIO VARCHAR(45)," +
                "COD_SERVICO INTEGER)";
        db.execSQL(comandoContrato);

        String comandoAtividade = "CREATE TABLE " + TABELA_ATIVIDADE + "( " +
                "COD_ATIVIDADE INTEGER PRIMARY KEY," +
                "DATA_INICIO DATE," +
                "DATA_FIM DATE," +
                "DESC_SERVICO INTEGER," +
                "COD_CLIENTE INTEGER," +
                "COD_SERVICO INTEGER," +
                "COD_CONTRATO INTEGER," +
                "COD_CARGO INTEGER," +
                "COD_SOCIO INTEGER," +
                "FOREIGN KEY (COD_CLIENTE) REFERENCES " + TABELA_CLIENTE + "(COD_CLIENTE)," +
                "FOREIGN KEY (COD_SERVICO) REFERENCES " + TABELA_SERVICO + "(CODIGO_SERVICO)," +
                "FOREIGN KEY (COD_CONTRATO) REFERENCES "+ TABELA_CONTRATO + "(CODIGO_CONTRATO)," +
                "FOREIGN KEY (COD_CARGO) REFERENCES "+ TABELA_CARGO + "(CODIGO_CARGO)," +
                "FOREIGN KEY (COD_SOCIO) REFERENCES "+ TABELA_SOCIO + "(CODIGO_SOCIO))";


        db.execSQL(comandoAtividade);

        String comandoAtividadeSocio = "CREATE TABLE " + TABELA_ATIVIDADE_SOCIO + "( " +
                "COD_ATIVIDADE INTEGER," +
                "COD_SOCIO INTEGER," +
                "HORA_TOTAL CHAR(8),"+
                "HORAS_ATIVIDADE CHAR(8)," +
                "COD_CARGO INTEGER," +
                "PRIMARY KEY(COD_ATIVIDADE, COD_SOCIO)," +
                "FOREIGN KEY (COD_ATIVIDADE) REFERENCES " + TABELA_ATIVIDADE + "(COD_ATIVIDADE)," +
                "FOREIGN KEY (COD_SOCIO) REFERENCES " + TABELA_SOCIO + "(COD_SOCIO)," +
                "FOREIGN KEY (COD_CARGO) REFERENCES " + TABELA_CARGO + "(COD_CARGO))";

        db.execSQL(comandoAtividadeSocio);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
