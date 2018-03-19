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

import tcc.tanalista.adapter.ProdutoAdapter;
import tcc.tanalista.dao.ProdutosDAO;
import tcc.tanalista.model.Produtos;

public class ProdutoActivity extends AppCompatActivity {

    private List<Produtos> produtosList = new ArrayList<Produtos>();
    private RecyclerView recyclerView;
    private ProdutoAdapter produtoAdapter;
    private Produtos produtos;
    private ProdutosDAO produtosDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        produtosDAO = new ProdutosDAO(this);
        produtosList = produtosDAO.buscarProduto();
        produtoAdapter = new ProdutoAdapter(produtosList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(produtoAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(),
                recyclerView,
                new RecyclerTouchListener.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        Produtos produtos = produtosList.get(position);
                        Intent intent = new Intent(getApplicationContext(), ProdutoMercadoActivity.class);
                        intent.putExtra("produto",produtos);
                        startActivity(intent);
                    }

                    @Override
                    public void onLongClick(View view, int position) {
                        Produtos produtos = produtosList.get(position);
                        Toast.makeText(getApplicationContext(), produtos.getNomeProd(), Toast.LENGTH_LONG)
                                .show();
                    }
                }));



    }

    protected void onResume() {
        super.onResume();


    }

}
