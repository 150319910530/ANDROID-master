package tcc.tanalista.model;

import java.io.Serializable;

/**
 * Created by jucel on 06/03/2017.
 */

public class ListaProdutos implements Serializable {

    private long idListaProduto;
    private Produtos produtos;
    private ListaCompras listacompras;
    private boolean itemAtivo;

    public ListaProdutos() {
    }

    public ListaProdutos(Produtos produtos, ListaCompras listacompras) {
        this.produtos = produtos;
        this.listacompras = listacompras;
    }

    public long getIdListaProduto() {
        return idListaProduto;
    }

    public void setIdListaProduto(long idListaProduto) {
        this.idListaProduto = idListaProduto;
    }

    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }

    public ListaCompras getListacompras() {
        return listacompras;
    }

    public void setListacompras(ListaCompras listacompras) {
        this.listacompras = listacompras;
    }

    public boolean getItemAtivo() {
        return itemAtivo;
    }

    public void setItemAtivo(boolean itemAtivo) {
        this.itemAtivo = itemAtivo;
    }
}
