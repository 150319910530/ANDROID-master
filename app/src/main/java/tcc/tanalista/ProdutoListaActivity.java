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
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import tcc.tanalista.adapter.ProdutoListaAdapter;
import tcc.tanalista.dao.ListaProdutosDAO;
import tcc.tanalista.model.ListaCompras;
import tcc.tanalista.model.ListaProdutos;
import tcc.tanalista.model.Mercados;

public class ProdutoListaActivity extends AppCompatActivity {


    private List<ListaProdutos> produtoList = new ArrayList<ListaProdutos>();
    private RecyclerView recyclerView;
    private ProdutoListaAdapter produtoListaAdapter;
    private ListaCompras listaCompras;



    private ListaProdutosDAO listaProdutosDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto_lista);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        Intent intent = getIntent();
        listaCompras = (ListaCompras) intent.getSerializableExtra("listacompra");

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        listaProdutosDAO = new ListaProdutosDAO(this);
        produtoList = listaProdutosDAO.buscarProdutoMercado(listaCompras);
        produtoListaAdapter = new ProdutoListaAdapter(produtoList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(produtoListaAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(),
                recyclerView,
                new RecyclerTouchListener.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        ListaProdutos listprod = produtoList.get(position);

                        if (listprod.getItemAtivo() == true){
                            listaProdutosDAO.removerProduto(listprod);
                            Toast.makeText(getApplicationContext(), "Produto: " + listprod.getProdutos().getNomeProd() + " excluído da lista com sucesso", Toast.LENGTH_SHORT)
                                    .show();
                            Intent intent = new Intent(getApplicationContext(), ProdutoListaActivity.class);
                            intent.putExtra("listacompra",listaCompras);
                            startActivity(intent);
                            finish();

                        } else if (listprod.getItemAtivo() == false){
                            listaProdutosDAO.addProduto(listprod);
                            Toast.makeText(getApplicationContext(), "Produto: " + listprod.getProdutos().getNomeProd() + " incluído na lista com sucesso", Toast.LENGTH_SHORT)
                                    .show();
                            Intent intent = new Intent(getApplicationContext(), ProdutoListaActivity.class);
                            intent.putExtra("listacompra",listaCompras);
                            startActivity(intent);
                            finish();
                        }

                    }

                    @Override
                    public void onLongClick(View view, int position) {
                        ListaProdutos listprod = produtoList.get(position);
                        Toast.makeText(getApplicationContext(), listprod.getListacompras().getNomeListaCompra(), Toast.LENGTH_LONG)
                                .show();
                    }
                }));
    }

}
