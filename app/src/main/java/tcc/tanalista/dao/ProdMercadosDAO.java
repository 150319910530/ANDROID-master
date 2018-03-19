package tcc.tanalista.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import tcc.tanalista.model.Mercados;
import tcc.tanalista.model.ProdMercados;
import tcc.tanalista.model.Produtos;

/**
 * Created by jucel on 07/03/2017.
 */

public class ProdMercadosDAO {

    Context context;
    BancoSQL dao;

    private static final String NOMETABLE = "PRODMERCADO";

    public ProdMercadosDAO(Context context) {
        this.context = context;
    }

    public List<ProdMercados> buscarProdutoMercado(Mercados mercadoActivity){
        String sql = "SELECT PRODUTO.NOME, PRODMERCADO.VALOR " +
                "FROM PRODMERCADO " +
                "INNER JOIN PRODUTO " +
                "ON PRODMERCADO.IDPRODUTO = PRODUTO.IDPROD " +
                "INNER JOIN LISTAPRODUTO " +
                "ON LISTAPRODUTO.IDPROD= PRODMERCADO.IDPRODUTO " +
                "WHERE PRODMERCADO.IDMERCADO =" +mercadoActivity.getIdMer() +
                " AND LISTAPRODUTO.LISTPROD =" +mercadoActivity.getIdList() +
                " ORDER BY NOME;";
        dao = new BancoSQL(context);
        SQLiteDatabase db = dao.getReadableDatabase();
        Cursor c = db.rawQuery(sql,null);
        List<ProdMercados> prodMercados = new ArrayList<ProdMercados>();
        while (c.moveToNext()){
            ProdMercados prodMercado = new ProdMercados();
            Produtos produtos = new Produtos();
            produtos.setNomeProd(c.getString(c.getColumnIndex("NOME")));
            prodMercado.setProdutos(produtos);
            prodMercado.setValorProd(c.getDouble(c.getColumnIndex("VALOR")));

            prodMercados.add(prodMercado);
        }
        c.close();
        return prodMercados;
    }

    public List<ProdMercados> buscarMercadoProduto(Mercados mercadoActivity){
        String sql = "SELECT MERCADO.NOMEMER, PRODUTO.NOME,PRODMERCADO.VALOR FROM PRODMERCADO  " +
                "INNER JOIN PRODUTO " +
                "ON PRODUTO.IDPROD = PRODMERCADO.IDPRODUTO " +
                "INNER JOIN MERCADO " +
                "ON MERCADO.IDMER = PRODMERCADO.IDMERCADO " +
                "WHERE PRODMERCADO.IDMERCADO = " +mercadoActivity.getIdMer();
        dao = new BancoSQL(context);
        SQLiteDatabase db = dao.getReadableDatabase();
        Cursor c = db.rawQuery(sql,null);
        List<ProdMercados> prodMercados = new ArrayList<ProdMercados>();
        while (c.moveToNext()){
            ProdMercados prodMercado = new ProdMercados();
            Produtos produtos = new Produtos();
            Mercados mercados = new Mercados();
            produtos.setNomeProd(c.getString(c.getColumnIndex("NOME")));
            prodMercado.setProdutos(produtos);
            prodMercado.setValorProd(c.getDouble(c.getColumnIndex("VALOR")));
            mercados.setNomeMercado(c.getString(c.getColumnIndex("NOMEMER")));
            prodMercado.setMercados(mercados);


            prodMercados.add(prodMercado);
        }
        c.close();
        return prodMercados;
    }

    public List<ProdMercados> buscarProdutoMercado(Produtos produtos){
        String sql = "SELECT PRODUTO.IDPROD, MERCADO.NOMEMER,PRODUTO.NOME, PRODMERCADO.VALOR  FROM PRODMERCADO " +
                "INNER JOIN MERCADO " +
                "ON MERCADO.IDMER= PRODMERCADO.IDMERCADO " +
                "INNER JOIN PRODUTO " +
                "ON PRODUTO.IDPROD = PRODMERCADO.IDPRODUTO " +
                "WHERE PRODMERCADO.IDPRODUTO=" +produtos.getIdProd() +
                " ORDER BY VALOR";
        dao = new BancoSQL(context);
        SQLiteDatabase db = dao.getReadableDatabase();
        Cursor c = db.rawQuery(sql,null);
        List<ProdMercados> prodMercados = new ArrayList<ProdMercados>();
        while (c.moveToNext()){
            ProdMercados prodMercado = new ProdMercados();
            Mercados mercado = new Mercados();
            Produtos prod = new Produtos();
            mercado.setNomeMercado(c.getString(c.getColumnIndex("NOMEMER")));
            prod.setNomeProd(c.getString(c.getColumnIndex("NOME")));
            prod.setIdProd(c.getInt(c.getColumnIndex("IDPROD")));
            prodMercado.setValorProd(c.getDouble(c.getColumnIndex("VALOR")));
            prodMercado.setMercados(mercado);
            prodMercado.setProdutos(produtos);


            prodMercados.add(prodMercado);
        }
        c.close();
        return prodMercados;
    }




}
