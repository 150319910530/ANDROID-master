package tcc.tanalista.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import tcc.tanalista.model.Produtos;

/**
 * Created by jucel on 07/03/2017.
 */

public class ProdutosDAO {

    Context context;
    BancoSQL dao;

    private static final String NOMETABLE = "PRODUTO";

    public ProdutosDAO(Context context) {
        this.context = context;
    }

    public List<Produtos> buscarProduto(){
        String sql = "SELECT PRODUTO.IDPROD, " +
                "PRODUTO.NOME,  " +
                "(SELECT COUNT(*) FROM PRODMERCADO WHERE PRODMERCADO.IDPRODUTO=PRODUTO.IDPROD) AS TOTALPRODMERCADO " +
                "FROM PRODUTO; ";
        dao = new BancoSQL(context);
        SQLiteDatabase db = dao.getReadableDatabase();
        Cursor c = db.rawQuery(sql,null);
        List<Produtos> produtos = new ArrayList<Produtos>();
        while (c.moveToNext()){
            Produtos produto = new Produtos();
            produto.setIdProd(c.getInt(c.getColumnIndex("IDPROD")));
            produto.setNomeProd(c.getString(c.getColumnIndex("NOME")));
            produto.setTotalProd(c.getInt(c.getColumnIndex("TOTALPRODMERCADO")));

            produtos.add(produto);
        }
        c.close();
        return produtos;
    }
}
