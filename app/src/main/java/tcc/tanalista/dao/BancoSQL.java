package tcc.tanalista.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jucel on 07/03/2017.
 */

public class BancoSQL extends SQLiteOpenHelper {
    private static final String NOMEBANCO = "TanaLista";
    private static final int VERSAOBANCO = 1;
    private static final String TABLEPRODURO ="CREATE TABLE PRODUTO (IDPROD INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,NOME TEXT NOT NULL);";
    private static final String TABLELISTAPRODUTO ="CREATE TABLE LISTAPRODUTO (IDPRODLIST INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,LISTPROD INTEGER NOT NULL,IDPROD INTEGER NOT NULL);";
    private static final String TABLEMERCADO ="CREATE TABLE MERCADO (IDMER INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, NOMEMER TEXT);";
    private static final String TABLEPRODMERCADO ="CREATE TABLE PRODMERCADO (IDPRODMERCADO INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,IDMERCADO INTEGER,IDPRODUTO INTEGER,VALOR REAL);";
    private static final String TABLELISTACOMPRA ="CREATE TABLE LISTACOMPRA (IDLISTCOM INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, NOMELISTCOM TEXT NOT NULL);";

    public BancoSQL(Context context) {
        super(context, NOMEBANCO, null, VERSAOBANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL(TABLEPRODURO);
        db.execSQL(TABLELISTAPRODUTO);
        db.execSQL(TABLEPRODMERCADO);
        db.execSQL(TABLELISTACOMPRA);
        db.execSQL(TABLEMERCADO);
        db.execSQL("INSERT INTO 'LISTACOMPRA' VALUES(1,'Aniversario');");
        db.execSQL("INSERT INTO 'LISTACOMPRA' VALUES(2,'Churrasco');");
        db.execSQL("INSERT INTO 'LISTACOMPRA' VALUES(3,'Compras do Mês');");
        db.execSQL("INSERT INTO 'LISTACOMPRA' VALUES(4,'Final de Semana');");
        db.execSQL("INSERT INTO 'LISTAPRODUTO' VALUES(1,1,12);");
        db.execSQL("INSERT INTO 'LISTAPRODUTO' VALUES(2,1,11);");
        db.execSQL("INSERT INTO 'LISTAPRODUTO' VALUES(3,2,13);");
        db.execSQL("INSERT INTO 'LISTAPRODUTO' VALUES(4,2,5);");
        db.execSQL("INSERT INTO 'LISTAPRODUTO' VALUES(5,1,3);");
        db.execSQL("INSERT INTO 'LISTAPRODUTO' VALUES(6,1,9);");
        db.execSQL("INSERT INTO 'LISTAPRODUTO' VALUES(7,2,6);");
        db.execSQL("INSERT INTO 'LISTAPRODUTO' VALUES(8,2,2);");
        db.execSQL("INSERT INTO 'LISTAPRODUTO' VALUES(9,2,1);");
        db.execSQL("INSERT INTO 'LISTAPRODUTO' VALUES(10,3,1);");
        db.execSQL("INSERT INTO 'LISTAPRODUTO' VALUES(11,3,2);");
        db.execSQL("INSERT INTO 'LISTAPRODUTO' VALUES(12,3,3);");
        db.execSQL("INSERT INTO 'LISTAPRODUTO' VALUES(13,3,4);");
        db.execSQL("INSERT INTO 'LISTAPRODUTO' VALUES(14,3,5);");
        db.execSQL("INSERT INTO 'LISTAPRODUTO' VALUES(15,3,6);");
        db.execSQL("INSERT INTO 'LISTAPRODUTO' VALUES(16,3,7);");
        db.execSQL("INSERT INTO 'LISTAPRODUTO' VALUES(17,3,8);");
        db.execSQL("INSERT INTO 'LISTAPRODUTO' VALUES(18,3,9);");
        db.execSQL("INSERT INTO 'LISTAPRODUTO' VALUES(19,3,10);");
        db.execSQL("INSERT INTO 'LISTAPRODUTO' VALUES(20,3,11);");
        db.execSQL("INSERT INTO 'LISTAPRODUTO' VALUES(21,3,12);");
        db.execSQL("INSERT INTO 'LISTAPRODUTO' VALUES(22,3,13);");
        db.execSQL("INSERT INTO 'LISTAPRODUTO' VALUES(23,4,1);");
        db.execSQL("INSERT INTO 'LISTAPRODUTO' VALUES(24,4,2);");
        db.execSQL("INSERT INTO 'LISTAPRODUTO' VALUES(25,4,4);");
        db.execSQL("INSERT INTO 'LISTAPRODUTO' VALUES(26,4,5);");
        db.execSQL("INSERT INTO 'LISTAPRODUTO' VALUES(27,4,6);");
        db.execSQL("INSERT INTO 'LISTAPRODUTO' VALUES(28,4,8);");
        db.execSQL("INSERT INTO 'LISTAPRODUTO' VALUES(29,4,13);");
        db.execSQL("INSERT INTO 'LISTAPRODUTO' VALUES(30,4,7);");
        db.execSQL("INSERT INTO 'MERCADO' VALUES(1,'Extra');");
        db.execSQL("INSERT INTO 'MERCADO' VALUES(2,'HIPER BOMPREÇO');");
        db.execSQL("INSERT INTO 'MERCADO' VALUES(3,'Rede Mix');");
        db.execSQL("INSERT INTO 'MERCADO' VALUES(4,'Mercantil Rodrigues');");
        db.execSQL("INSERT INTO 'MERCADO' VALUES(5,'Fort Supermercado');");
        db.execSQL("INSERT INTO 'MERCADO' VALUES(6,'Atacadão Centro Sul');");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(1,1,2,7.89);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(2,1,1,2.39);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(3,2,1,3.1);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(4,3,1,1.99);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(5,1,3,2.98);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(6,1,4,2.28);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(7,2,4,1.99);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(8,4,1,1.87);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(9,5,1,2.1);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(10,6,1,1.98);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(11,2,2,3.4);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(12,3,2,3.99);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(13,4,2,4.1);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(14,5,2,3.98);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(15,6,2,3.5);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(16,2,3,3.1);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(17,3,3,3.29);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(18,4,3,2.3);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(19,5,3,1.99);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(20,6,3,2.1);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(21,3,4,3.1);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(22,4,4,2.4);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(23,5,4,2.03);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(24,6,4,1.66);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(25,1,5,19.99);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(26,2,5,22.99);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(27,3,5,18.4);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(28,4,5,17.9);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(29,5,5,19.5);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(30,6,5,18.88);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(31,1,6,12.99);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(32,2,6,10.5);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(33,3,6,9.99);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(34,4,6,11.99);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(35,5,6,10.99);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(36,6,6,9.99);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(37,1,7,3.99);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(38,2,7,2.3);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(39,3,7,3.9);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(40,4,7,3.38);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(41,5,7,2.99);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(42,6,7,2.1);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(43,1,8,4.99);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(44,2,8,3.49);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(45,3,8,4.19);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(46,4,8,5.19);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(47,5,8,3.99);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(48,6,8,5.99);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(49,1,9,2.99);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(50,2,9,3.19);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(51,3,9,2.79);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(52,4,9,2.89);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(53,5,9,3.49);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(54,6,9,2.99);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(55,1,10,3.59);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(56,2,10,3.49);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(57,3,10,4.19);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(58,4,10,6.19);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(59,5,10,3.67);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(60,6,10,4.89);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(61,1,11,8.9);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(62,2,11,5.89);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(63,3,11,4.99);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(64,4,11,3.67);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(65,5,11,2.99);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(66,6,11,4.88);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(67,1,12,3.49);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(68,2,12,4.49);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(69,3,12,5.19);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(70,4,12,4.99);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(71,5,12,3.89);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(72,6,12,3.99);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(73,1,13,18.5);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(74,2,13,19.99);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(75,3,13,20.19);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(76,4,13,22.99);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(77,5,13,18.99);");
        db.execSQL("INSERT INTO 'PRODMERCADO' VALUES(78,6,13,23.99);");
        db.execSQL("INSERT INTO 'PRODUTO' VALUES(1,'Arroz Branco');");
        db.execSQL("INSERT INTO 'PRODUTO' VALUES(2,'Feijão Carioca');");
        db.execSQL("INSERT INTO 'PRODUTO' VALUES(3,'Açucar Cristal');");
        db.execSQL("INSERT INTO 'PRODUTO' VALUES(4,'Macarrão Espaguete');");
        db.execSQL("INSERT INTO 'PRODUTO' VALUES(5,'Carne Picanha');");
        db.execSQL("INSERT INTO 'PRODUTO' VALUES(6,'Calabresa de Churrasco');");
        db.execSQL("INSERT INTO 'PRODUTO' VALUES(7,'Oleo de Soja');");
        db.execSQL("INSERT INTO 'PRODUTO' VALUES(8,'Farinha');");
        db.execSQL("INSERT INTO 'PRODUTO' VALUES(9,'Farinha de Trigo com Fermento');");
        db.execSQL("INSERT INTO 'PRODUTO' VALUES(10,'Café');");
        db.execSQL("INSERT INTO 'PRODUTO' VALUES(11,'Leite 1L');");
        db.execSQL("INSERT INTO 'PRODUTO' VALUES(12,'Ovos (Duzia)');");
        db.execSQL("INSERT INTO 'PRODUTO' VALUES(13,'Carne Cupim');");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS PRODUTO;");
        db.execSQL("DROP TABLE IF EXISTS LISTAPRODUTO;");
        db.execSQL("DROP TABLE IF EXISTS PRODMERCADO;");
        db.execSQL("DROP TABLE IF EXISTS LISTACOMPRA;");
        db.execSQL("DROP TABLE IF EXISTS MERCADO;");

    }


}
