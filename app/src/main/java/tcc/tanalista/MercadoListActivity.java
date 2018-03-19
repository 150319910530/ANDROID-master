package tcc.tanalista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import tcc.tanalista.adapter.MercadoListaAdapter;
import tcc.tanalista.dao.MercadoDAO;
import tcc.tanalista.model.ListaCompras;
import tcc.tanalista.model.Mercados;

public class MercadoListActivity extends AppCompatActivity {


    ListaCompras listaCompras;
    private List<Mercados> mercadoslist = new ArrayList<Mercados>();
    private RecyclerView recyclerView;
    private MercadoListaAdapter mercadoListaAdapter;
    private Mercados mercados;



    private MercadoDAO mercadoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercado_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.i("Log","Iniciar Lista Mercado");
        Intent intent = getIntent();
        listaCompras = (ListaCompras) intent.getSerializableExtra("listacompra");

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mercadoDAO = new MercadoDAO(this);
        mercadoslist = mercadoDAO.buscarMercadoListaCompra(listaCompras);
        mercadoListaAdapter = new MercadoListaAdapter(mercadoslist);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mercadoListaAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(),
                recyclerView,
                new RecyclerTouchListener.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        Mercados mercado = mercadoslist.get(position);
                        Intent intent = new Intent(getApplicationContext(), ListaProdMercadoActivity.class);
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

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Log","Start Lista Mercado");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Log","Parar Lista Mercado");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Log","Destroe Lista Mercado");
    }



    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Log","Resume Lista Mercado");

    }

}
