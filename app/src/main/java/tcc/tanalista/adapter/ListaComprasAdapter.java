package tcc.tanalista.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import tcc.tanalista.model.ListaCompras;
import tcc.tanalista.R;

/**
 * Created by jucel on 10/03/2017.
 */

public class ListaComprasAdapter extends RecyclerView.Adapter<ListaComprasAdapter.MyViewHolder> {

    private List<ListaCompras> listaCompraList;

    public ListaComprasAdapter(List<ListaCompras> listacompra) {
        this.listaCompraList = listacompra;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_compra_list_row,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ListaCompras listaCompra = listaCompraList.get(position);
        holder.nomeLista.setText(listaCompra.getNomeListaCompra());
        holder.quantidade.setText("Quantidade de Produto(s):  " +String.valueOf(listaCompra.getQuantidadelista()));


    }

    @Override
    public int getItemCount() {
        return listaCompraList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nomeLista, quantidade;

        public MyViewHolder(View itemView) {
            super(itemView);
            nomeLista = (TextView) itemView.findViewById(R.id.nome_produto_row);
            quantidade = (TextView) itemView.findViewById(R.id.quant_produto_row);

        }
    }
}
