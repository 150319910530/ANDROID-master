package tcc.tanalista.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import tcc.tanalista.model.ProdMercados;
import tcc.tanalista.R;

/**
 * Created by jucel on 16/03/2017.
 */

public class ProdMercadoListaAdapter extends RecyclerView.Adapter<ProdMercadoListaAdapter.MyViewHolder> {

    private List<ProdMercados> prodMercados;
    NumberFormat formato = new DecimalFormat("#0.00");

    public ProdMercadoListaAdapter(List<ProdMercados> prodMercados) {
        this.prodMercados = prodMercados;
    }

    @Override

    public ProdMercadoListaAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_prodmercado_row,parent,false);
        return new ProdMercadoListaAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ProdMercados prodMercado = prodMercados.get(position);
        holder.nomeProduto.setText(prodMercado.getProdutos().getNomeProd());
        holder.valorProduto.setText("R$ "+String.valueOf(formato.format(prodMercado.getValorProd())));

    }

    @Override
    public int getItemCount() {
        return prodMercados.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nomeProduto, valorProduto;
        public MyViewHolder(View itemView) {
            super(itemView);
            nomeProduto = (TextView) itemView.findViewById(R.id.nome_prod_lista_row);
            valorProduto = (TextView) itemView.findViewById(R.id.valor_lista_row);



        }
    }
}
