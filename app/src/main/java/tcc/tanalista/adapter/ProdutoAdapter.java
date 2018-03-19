package tcc.tanalista.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import tcc.tanalista.model.Produtos;
import tcc.tanalista.R;

/**
 * Created by jucel on 23/03/2017.
 */

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.MyViewHolder> {

    private List<Produtos> listaProduto;

    public ProdutoAdapter(List<Produtos> listaProduto) {
        this.listaProduto = listaProduto;
    }

    @Override
    public ProdutoAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_produto_row,parent,false);
        return new ProdutoAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Produtos produto = listaProduto.get(position);
        holder.nomeProduto.setText(produto.getNomeProd());
        holder.quantProduto.setText("Quantidade de Mercado(s): " +String.valueOf(produto.getTotalProd()));



    }

    @Override
    public int getItemCount() {
        return listaProduto.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nomeProduto, quantProduto;

        public MyViewHolder(View itemView) {
            super(itemView);
            nomeProduto = (TextView) itemView.findViewById(R.id.nome_produto_row);
            quantProduto = (TextView) itemView.findViewById(R.id.quant_produto_row);

        }
    }
}
