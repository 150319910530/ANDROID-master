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

import tcc.tanalista.adapter.MercadoProdutoAdapter;
import tcc.tanalista.dao.ProdMercadosDAO;
import tcc.tanalista.model.Mercados;
import tcc.tanalista.model.ProdMercados;

public class MercadoProdutoActivity extends AppCompatActivity {

    Mercados mercado;
    private List<ProdMercados> prodmercadolist = new ArrayList<ProdMercados>();
    private RecyclerView recyclerView;
    private MercadoProdutoAdapter mercadoProdutoAdapter;
    private ProdMercados prodMercados;
    private ProdMercadosDAO prodMercadosDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercado_produto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        mercado = (Mercados) intent.getSerializableExtra("mercado");


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        prodMercadosDAO = new ProdMercadosDAO(this);
        prodmercadolist = prodMercadosDAO.buscarMercadoProduto(mercado);
        mercadoProdutoAdapter = new MercadoProdutoAdapter(prodmercadolist);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mercadoProdutoAdapter);

    }

    protected void onResume() {
        super.onResume();



    }

}
