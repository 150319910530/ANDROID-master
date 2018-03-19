package tcc.tanalista;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import tcc.tanalista.adapter.ProdutoMercadoAdapter;
import tcc.tanalista.dao.ProdMercadosDAO;
import tcc.tanalista.model.ProdMercados;
import tcc.tanalista.model.Produtos;

public class ProdutoMercadoActivity extends AppCompatActivity {

    Produtos produto;
    private List<ProdMercados> prodmercadolist = new ArrayList<ProdMercados>();
    private RecyclerView recyclerView;
    private ProdutoMercadoAdapter produtoMercadoAdapter;
    private ProdMercados prodMercados;
    private ProdMercadosDAO prodMercadosDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto_mercado);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        produto = (Produtos) intent.getSerializableExtra("produto");


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        prodMercadosDAO = new ProdMercadosDAO(this);
        prodmercadolist = prodMercadosDAO.buscarProdutoMercado(produto);
        produtoMercadoAdapter = new ProdutoMercadoAdapter(prodmercadolist);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(produtoMercadoAdapter);

    }

    protected void onResume() {
        super.onResume();



    }



}
