package tcc.tanalista.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import tcc.tanalista.model.Mercados;
import tcc.tanalista.R;

/**
 * Created by jucel on 22/03/2017.
 */

public class MercadoListaAdapter extends RecyclerView.Adapter<MercadoListaAdapter.MyViewHolder> {
    private List<Mercados> mercadosList;
    NumberFormat formato = new DecimalFormat("#0.00");

    public MercadoListaAdapter(List<Mercados> mercadosList) {
        this.mercadosList = mercadosList;
    }

    @Override

    public MercadoListaAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_mercados_list_row,parent,false);
        return new MercadoListaAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Mercados mercados = mercadosList.get(position);
        holder.nomeMercado.setText(mercados.getNomeMercado());
        holder.qtProd.setText("Quantidade de Produto: "+String.valueOf(mercados.getQtProdLista()));
        holder.valorTotal.setText("Valor Total: R$ "+String.valueOf(formato.format(mercados.getValorProd())));

    }

    @Override
    public int getItemCount() {
        return mercadosList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nomeMercado, qtProd, valorTotal;
        public MyViewHolder(View itemView) {
            super(itemView);
            nomeMercado = (TextView) itemView.findViewById(R.id.list_nomeMercado_row);
            qtProd = (TextView) itemView.findViewById(R.id.list_qtProdMer_row);
            valorTotal = (TextView) itemView.findViewById(R.id.list_Valor);



        }
    }
}
