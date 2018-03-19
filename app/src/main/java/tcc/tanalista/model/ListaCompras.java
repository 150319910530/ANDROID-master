package tcc.tanalista.model;

import java.io.Serializable;

/**
 * Created by jucel on 06/03/2017.
 */

public class ListaCompras implements Serializable {

    private long idListaCompra;
    private String nomeListaCompra;
    private int quantidadelista;

    public ListaCompras(String nomeListaCompra) {
        this.nomeListaCompra = nomeListaCompra;
    }

    public ListaCompras() {
    }

    public long getIdListaCompra() {
        return idListaCompra;
    }

    public void setIdListaCompra(long idListaCompra) {
        this.idListaCompra = idListaCompra;
    }

    public String getNomeListaCompra() {
        return nomeListaCompra;
    }

    public void setNomeListaCompra(String nomeListaCompra) {
        this.nomeListaCompra = nomeListaCompra;
    }

    public int getQuantidadelista() {
        return quantidadelista;
    }

    public void setQuantidadelista(int quantidadelista) {
        this.quantidadelista = quantidadelista;
    }
}
