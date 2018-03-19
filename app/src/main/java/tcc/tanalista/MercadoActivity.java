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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import tcc.tanalista.adapter.MercadoAdapter;
import tcc.tanalista.dao.MercadoDAO;
import tcc.tanalista.model.Mercados;

public class MercadoActivity extends AppCompatActivity {


    private List<Mercados> mercadoslist = new ArrayList<Mercados>();
    private RecyclerView recyclerView;
    private MercadoAdapter mercadoAdapter;
    private Mercados mercados;
    private MercadoDAO mercadoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercado);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mercadoDAO = new MercadoDAO(this);
        mercadoslist = mercadoDAO.buscarMercado();
        mercadoAdapter = new MercadoAdapter(mercadoslist);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mercadoAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(),
                recyclerView,
                new RecyclerTouchListener.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        Mercados mercado = mercadoslist.get(position);
                        Intent intent = new Intent(getApplicationContext(), MercadoProdutoActivity.class);
                        intent.putExtra("mercado",mercado);
                        startActivity(intent);
                    }

                    @Override
                    public void onLongClick(View view, int position) {
                        Mercados mercado = mercadoslist.get(position);
                        Toast.makeText(getApplicationContext(), mercado.getNomeMercado(), Toast.LENGTH_LONG)
                                .show();
                    }
                }));



    }


    protected void onResume() {
        super.onResume();







    }

}
