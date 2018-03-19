package tcc.tanalista.model;

import java.io.Serializable;

/**
 * Created by jucel on 06/03/2017.
 */

public class Produtos implements Serializable {

    private long idProd;
    private String nomeProd;
    private int totalProd;

    public Produtos() {
    }

    public Produtos(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public long getIdProd() {
        return idProd;
    }

    public void setIdProd(long idProd) {
        this.idProd = idProd;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public int getTotalProd() {
        return totalProd;
    }

    public void setTotalProd(int totalProd) {
        this.totalProd = totalProd;
    }
}
