package tcc.tanalista.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import tcc.tanalista.model.Mercados;
import tcc.tanalista.R;

/**
 * Created by jucel on 22/03/2017.
 */

public class   MercadoAdapter extends RecyclerView.Adapter<MercadoAdapter.MyViewHolder> {

    private List<Mercados> mercadosList;

    public MercadoAdapter(List<Mercados> mercadosList) {
        this.mercadosList = mercadosList;
    }

    @Override

    public MercadoAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_mercado_row,parent,false);
        return new MercadoAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Mercados mercados = mercadosList.get(position);
        holder.nomeMercado.setText(mercados.getNomeMercado());
        holder.qtProd.setText("Quantidade de produto: "+String.valueOf(mercados.getTotalproduto()));


    }

    @Override
    public int getItemCount() {
        return mercadosList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nomeMercado, qtProd;
        public MyViewHolder(View itemView) {
            super(itemView);
            nomeMercado = (TextView) itemView.findViewById(R.id.nomeMercado_row);
            qtProd = (TextView) itemView.findViewById(R.id.quantProd_row);




        }
    }
}