package tcc.tanalista.model;

import java.io.Serializable;

/**
 * Created by jucel on 07/03/2017.
 */

public class ProdMercados implements Serializable {

    private long idProdMercados;
    private Mercados mercados;
    private Produtos produtos;
    private String nomeProd;
    private double valorProd;

    public ProdMercados() {
    }

    public ProdMercados(Mercados mercados, Produtos produtos) {
        this.mercados = mercados;
        this.produtos = produtos;
    }

    public long getIdProdMercados() {
        return idProdMercados;
    }

    public void setIdProdMercados(long idProdMercados) {
        this.idProdMercados = idProdMercados;
    }

    public Mercados getMercados() {
        return mercados;
    }

    public void setMercados(Mercados mercados) {
        this.mercados = mercados;
    }

    public Produtos getProdutos() {
        return produtos;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }


    public double getValorProd() {
        return valorProd;
    }

    public void setValorProd(double valorProd) {
        this.valorProd = valorProd;
    }
}
