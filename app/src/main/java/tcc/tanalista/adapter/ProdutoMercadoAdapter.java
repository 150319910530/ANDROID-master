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
 * Created by jucel on 23/03/2017.
 */

public class ProdutoMercadoAdapter extends RecyclerView.Adapter<ProdutoMercadoAdapter.MyViewHolder> {

    private List<ProdMercados> prodMercados;
    NumberFormat formato = new DecimalFormat("#0.00");

    public ProdutoMercadoAdapter(List<ProdMercados> prodMercados) {
        this.prodMercados = prodMercados;
    }

    @Override

    public ProdutoMercadoAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.produto_mercado_row,parent,false);
        return new ProdutoMercadoAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ProdMercados prodMercado = prodMercados.get(position);
        holder.nomeProduto.setText(prodMercado.getProdutos().getNomeProd());
        holder.valorProduto.setText("R$"+String.valueOf(formato.format(prodMercado.getValorProd())));
        holder.nomeMercado.setText(prodMercado.getMercados().getNomeMercado());

    }

    @Override
    public int getItemCount() {
        return prodMercados.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nomeProduto, valorProduto, nomeMercado;
        public MyViewHolder(View itemView) {
            super(itemView);
            nomeProduto = (TextView) itemView.findViewById(R.id.nome_produtomercado_row);
            valorProduto = (TextView) itemView.findViewById(R.id.valor_produto_mercado_row);
            nomeMercado = (TextView) itemView.findViewById(R.id.nome_produto_mercado_row);



        }
    }
}
