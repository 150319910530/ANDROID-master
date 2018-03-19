package tcc.tanalista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import tcc.tanalista.dao.ListaComprasDAO;
import tcc.tanalista.model.ListaCompras;

public class NovaListadeCompra extends AppCompatActivity {

    private EditText lista_edtNome;
    private Button lista_btnSalvar;
    private ProgressBar lista_progressBar;
    private String nome;
    private ListaComprasDAO daoLista;
    private ListaCompras listaCompras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_listade_compra);

        lista_edtNome = (EditText) findViewById(R.id.lista_edtNome);
        lista_btnSalvar = (Button) findViewById(R.id.lista_btnSalvar);
        listaCompras = new ListaCompras();

        lista_btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nome = lista_edtNome.getText().toString();

                listaCompras.setNomeListaCompra(nome);

                daoLista = new ListaComprasDAO(getApplicationContext());

                daoLista.insere(listaCompras);

                finish();

                startActivity(new Intent(getApplicationContext(),ListaCompraActivity.class));

            }
        });





    }
}
