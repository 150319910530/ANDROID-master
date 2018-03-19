package tcc.tanalista.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import tcc.tanalista.model.ListaCompras;
import tcc.tanalista.model.ListaProdutos;
import tcc.tanalista.model.Produtos;

/**
 * Created by jucel on 07/03/2017.
 */

public class ListaProdutosDAO {

    Context context;
    BancoSQL dao;

    private static final String NOMETABLE = "LISTAPRODUTO";

    public ListaProdutosDAO(Context context) {
        this.context = context;
    }

    public List<ListaProdutos> buscarProdutoMercado(ListaCompras listaCompras){
        String sql = "SELECT PRODUTO.IDPROD, PRODUTO.NOME, (SELECT COUNT(LISTAPRODUTO.IDPRODLIST)  " +
                "FROM LISTAPRODUTO " +
                "WHERE LISTAPRODUTO.IDPROD = PRODUTO.IDPROD " +
                "AND LISTAPRODUTO.LISTPROD = "+ listaCompras.getIdListaCompra() +") AS STATUS,(SELECT LISTAPRODUTO.IDPRODLIST " +
                "FROM LISTAPRODUTO  " +
                "WHERE LISTAPRODUTO.IDPROD = PRODUTO.IDPROD " +
                "AND LISTAPRODUTO.LISTPROD = "+ listaCompras.getIdListaCompra() +" ) AS CODLISTAPROD " +
                "fROM PRODUTO;";
        dao = new BancoSQL(context);
        SQLiteDatabase db = dao.getReadableDatabase();
        Cursor c = db.rawQuery(sql,null);
        List<ListaProdutos> listProdProdutos = new ArrayList<ListaProdutos>();
        while (c.moveToNext()){
            ListaProdutos listProdutos = new ListaProdutos();
            Produtos produtos = new Produtos();
            listProdutos.setIdListaProduto(c.getInt(c.getColumnIndex("CODLISTAPROD")));
            produtos.setNomeProd(c.getString(c.getColumnIndex("NOME")));
            produtos.setIdProd(c.getInt(c.getColumnIndex("IDPROD")));
            listProdutos.setProdutos(produtos);
            if (c.getInt(c.getColumnIndex("STATUS")) == 1){
                listProdutos.setItemAtivo(true);
            } else if (c.getInt(c.getColumnIndex("STATUS")) == 0){
                listProdutos.setItemAtivo(false);
            }

            listProdutos.setListacompras(listaCompras);



            listProdProdutos.add(listProdutos);
        }
        c.close();
        return listProdProdutos;
    }

    public void addProduto(ListaProdutos listaProdutos){
        //String sql = "INSERT INTO LISTAPRODUTO (LISTAPRODUTO.LISTPROD,LISTAPRODUTO.IDPROD) " +
                //"VALUES ("+ listaProdutos.getListacompras().getIdListaCompra() +", "+listaProdutos.getProdutos().getIdProd()+");";

        dao = new BancoSQL(context);
        SQLiteDatabase db = dao.getReadableDatabase();
        ContentValues dados = pegarDadosdaLista(listaProdutos);
        db.insert(NOMETABLE,null,dados);
        db.close();



    }

    private ContentValues pegarDadosdaLista(ListaProdutos listaProdutos) {
        ContentValues dados = new ContentValues();
        dados.put("LISTPROD",listaProdutos.getListacompras().getIdListaCompra());
        dados.put("IDPROD",listaProdutos.getProdutos().getIdProd());
        return dados;
    }

    public void removerProduto(ListaProdutos listaProdutos) {

        dao = new BancoSQL(context);
        SQLiteDatabase db = dao.getReadableDatabase();
        String[] params = {String.valueOf(listaProdutos.getIdListaProduto())};
        db.delete(NOMETABLE,"IDPRODLIST=?",params);
        db.close();

    }
}
