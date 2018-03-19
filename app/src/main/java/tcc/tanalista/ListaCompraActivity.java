package tcc.tanalista;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

import tcc.tanalista.adapter.ListaComprasAdapter;
import tcc.tanalista.dao.ListaComprasDAO;
import tcc.tanalista.model.ListaCompras;

public class ListaCompraActivity extends AppCompatActivity {

    private List<ListaCompras> listaComprasList = new ArrayList<ListaCompras>();
    private RecyclerView recyclerView;
    private ListaComprasAdapter listaComprasAdapter;
    private ListaCompras listaCompras;
    private ListaComprasDAO listaComprasDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_compra);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),NovaListadeCompra.class));
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        listaComprasDAO = new ListaComprasDAO(this);
        listaComprasList = listaComprasDAO.buscarListaCompra();
        listaComprasAdapter = new ListaComprasAdapter(listaComprasList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(listaComprasAdapter);


        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(),
                recyclerView,
                new RecyclerTouchListener.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        ListaCompras listaCompra = listaComprasList.get(position);
                        Intent intent = new Intent(getApplicationContext(), MercadoListActivity.class);
                        intent.putExtra("listacompra",listaCompra);
                        startActivity(intent);

                    }

                    @Override
                    public void onLongClick(View view, int position) {
                        ListaCompras listaCompra = listaComprasList.get(position);
                        Intent intent = new Intent(getApplicationContext(), ProdutoListaActivity.class);
                        intent.putExtra("listacompra",listaCompra);
                        startActivity(intent);

                    }
                }));

        Log.i("Log","Iniciar Lista de Compra");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Log","Start Produto Mercado");

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        listaComprasDAO = new ListaComprasDAO(this);
        listaComprasList = listaComprasDAO.buscarListaCompra();
        listaComprasAdapter = new ListaComprasAdapter(listaComprasList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(listaComprasAdapter);


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

