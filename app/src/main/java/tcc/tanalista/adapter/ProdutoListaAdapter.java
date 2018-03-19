package tcc.tanalista.adapter;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import tcc.tanalista.R;
import tcc.tanalista.model.ListaProdutos;

/**
 * Created by jucelio.jesus on 22/05/2017.
 */

public class ProdutoListaAdapter extends RecyclerView.Adapter<ProdutoListaAdapter.MyViewHolder> {

    private List<ListaProdutos> listaProdutoList;

    public ProdutoListaAdapter(List<ListaProdutos> listacompra) {
        this.listaProdutoList = listacompra;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_produto_add,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ListaProdutos listaProduto = listaProdutoList.get(position);
        holder.nomeProduto.setText(listaProduto.getProdutos().getNomeProd());

        if (listaProduto.getItemAtivo() == true){
            holder.imagemAtivo.setVisibility(View.VISIBLE);
            holder.imagemInativo.setVisibility(View.INVISIBLE);

        } else if (listaProduto.getItemAtivo() == false){
            holder.imagemAtivo.setVisibility(View.INVISIBLE);
            holder.imagemInativo.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return listaProdutoList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nomeProduto;
        public ImageView imagemAtivo, imagemInativo;

        public MyViewHolder(View itemView) {
            super(itemView);
            nomeProduto = (TextView) itemView.findViewById(R.id.nome_produto_row);
            imagemAtivo = (ImageView) itemView.findViewById(R.id.produto_ativo_row);
            imagemInativo = (ImageView) itemView.findViewById(R.id.produto_inativo_row);

        }
    }


}
