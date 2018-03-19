package tcc.tanalista.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import tcc.tanalista.model.ListaCompras;
import tcc.tanalista.model.Mercados;

/**
 * Created by jucel on 07/03/2017.
 */

public class MercadoDAO {

    Context context;
    BancoSQL dao;

    private static final String NOMETABLE = "MERCADO";

    public MercadoDAO(Context context) {
        this.context = context;
    }

    public List<Mercados> buscarMercadoListaCompra(ListaCompras idlistacompra){
        String sql = "SELECT MERCADO.IDMER,LISTAPRODUTO.LISTPROD,MERCADO.NOMEMER, COUNT(LISTAPRODUTO.IDPROD) AS PRODUTOS, SUM(PRODMERCADO.VALOR) AS VALORTOTAL\n" +
                "FROM PRODMERCADO " +
                "INNER JOIN MERCADO " +
                "ON MERCADO.IDMER = PRODMERCADO.IDMERCADO " +
                "INNER JOIN LISTAPRODUTO " +
                "ON LISTAPRODUTO.IDPROD = PRODMERCADO.IDPRODUTO " +
                "WHERE LISTAPRODUTO.LISTPROD=" +idlistacompra.getIdListaCompra() +
                " GROUP BY " +
                "MERCADO.NOMEMER " +
                " ORDER BY  " +
                "PRODUTOS DESC, " +
                "VALORTOTAL; ";
        dao = new BancoSQL(context);
        SQLiteDatabase db = dao.getReadableDatabase();
        Cursor c = db.rawQuery(sql,null);
        List<Mercados> mercados = new ArrayList<Mercados>();
        while (c.moveToNext()){
            Mercados mercado = new Mercados();
            mercado.setIdMer(c.getInt(c.getColumnIndex("IDMER")));
            mercado.setNomeMercado(c.getString(c.getColumnIndex("NOMEMER")));
            mercado.setQtProdLista(c.getInt(c.getColumnIndex("PRODUTOS")));
            mercado.setIdList(c.getInt(c.getColumnIndex("LISTPROD")));
            mercado.setValorProd(c.getDouble(c.getColumnIndex("VALORTOTAL")));
            mercados.add(mercado);
        }
        c.close();
        return mercados;
    }

    public List<Mercados> buscarMercado(){
        String sql = "SELECT MERCADO.IDMER, " +
                "MERCADO.NOMEMER, " +
                "(SELECT COUNT(*) FROM PRODMERCADO WHERE PRODMERCADO.IDMERCADO = MERCADO.IDMER) AS TOTAL  " +
                "FROM MERCADO " +
                "ORDER BY  " +
                "TOTAL DESC";
        dao = new BancoSQL(context);
        SQLiteDatabase db = dao.getReadableDatabase();
        Cursor c = db.rawQuery(sql,null);
        List<Mercados> mercados = new ArrayList<Mercados>();
        while (c.moveToNext()){
            Mercados mercado = new Mercados();
            mercado.setIdMer(c.getInt(c.getColumnIndex("IDMER")));
            mercado.setNomeMercado(c.getString(c.getColumnIndex("NOMEMER")));
            mercado.setTotalproduto(c.getInt(c.getColumnIndex("TOTAL")));
            mercados.add(mercado);
        }
        c.close();
        return mercados;
    }
}
