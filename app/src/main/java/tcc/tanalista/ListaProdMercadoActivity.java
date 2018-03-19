package tcc.tanalista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import tcc.tanalista.adapter.ProdMercadoListaAdapter;
import tcc.tanalista.dao.ProdMercadosDAO;
import tcc.tanalista.model.Mercados;
import tcc.tanalista.model.ProdMercados;

public class ListaProdMercadoActivity extends AppCompatActivity {

    Mercados mercado;
    private List<ProdMercados> prodmercadolist = new ArrayList<ProdMercados>();
    private RecyclerView recyclerView;
    private ProdMercadoListaAdapter prodMercadoListaAdapter;
    private ProdMercados prodMercados;
    private ProdMercadosDAO prodMercadosDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_prod_mercado);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.i("Log","Iniciar Produto Mercado");
        Intent intent = getIntent();
        mercado = (Mercados) intent.getSerializableExtra("mercado");


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        prodMercadosDAO = new ProdMercadosDAO(this);
        prodmercadolist = prodMercadosDAO.buscarProdutoMercado(mercado);
        prodMercadoListaAdapter = new ProdMercadoListaAdapter(prodmercadolist);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(prodMercadoListaAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Log","Start Produto Mercado");


    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Log","Pause Produto Mercado");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Log","Parar Produto Mercado");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Log","Destroe Produto Mercado");
    }

    protected void onResume() {
        super.onResume();

        Log.i("Log","Resume Produto Mercado");


    }

}
