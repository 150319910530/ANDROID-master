package tcc.tanalista.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import tcc.tanalista.model.ListaCompras;

/**
 * Created by jucel on 07/03/2017.
 */

public class ListaComprasDAO {

    Context context;
    BancoSQL dao;

    private static final String NOMETABLE = "LISTACOMPRA";

    public ListaComprasDAO(Context context) {
        this.context = context;
    }


    public void insere(ListaCompras listaCompras){

        dao = new BancoSQL(context);
        SQLiteDatabase db = dao.getReadableDatabase();
        ContentValues dados = pegarDadosdaLista(listaCompras);
        long  inserir = db.insert(NOMETABLE,null,dados);
        db.close();
        Log.i(NOMETABLE,inserir + "");


    }

    private ContentValues pegarDadosdaLista(ListaCompras listaCompras) {
        ContentValues dados = new ContentValues();
        dados.put("NOMELISTCOM",listaCompras.getNomeListaCompra());
        return dados;
    }


    public List<ListaCompras> buscarListaCompra(){
        String sql = "SELECT LISTACOMPRA.IDLISTCOM, " +
                "LISTACOMPRA.NOMELISTCOM, " +
                "(SELECT COUNT(*) FROM LISTAPRODUTO " +
                "WHERE LISTAPRODUTO.LISTPROD=LISTACOMPRA.IDLISTCOM) AS QUANTIPROD " +
                "FROM LISTACOMPRA;";
        dao = new BancoSQL(context);
        SQLiteDatabase db = dao.getReadableDatabase();
        Cursor c = db.rawQuery(sql,null);
        List<ListaCompras> listaCompras = new ArrayList<ListaCompras>();
        while (c.moveToNext()){
            ListaCompras listacompra = new ListaCompras();
            listacompra.setIdListaCompra(c.getInt(c.getColumnIndex("IDLISTCOM")));
            listacompra.setNomeListaCompra(c.getString(c.getColumnIndex("NOMELISTCOM")));
            listacompra.setQuantidadelista(c.getInt(c.getColumnIndex("QUANTIPROD")));
            listaCompras.add(listacompra);
        }
        c.close();
        return listaCompras;
    }
}
