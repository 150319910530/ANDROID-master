package tcc.tanalista.model;

import java.io.Serializable;

/**
 * Created by jucel on 06/03/2017.
 */

public class Mercados implements Serializable {
    private long idMer;
    private String nomeMercado;
    private int qtProdLista;
    private double valorProd;
    private int idList;
    private int totalproduto;





    public Mercados() {
    }

    public Mercados(String nomeMercado) {
        this.nomeMercado = nomeMercado;
    }

    public long getIdMer() {
        return idMer;
    }

    public void setIdMer(long idMer) {
        this.idMer = idMer;
    }

    public String getNomeMercado() {
        return nomeMercado;
    }

    public void setNomeMercado(String nomeMercado) {
        this.nomeMercado = nomeMercado;
    }
    public int getQtProdLista() {
        return qtProdLista;
    }

    public void setQtProdLista(int qtProdLista) {
        this.qtProdLista = qtProdLista;
    }

    public double getValorProd() {
        return valorProd;
    }

    public void setValorProd(double valorProd) {
        this.valorProd = valorProd;
    }

    public int getIdList() {
        return idList;
    }

    public void setIdList(int idList) {
        this.idList = idList;
    }

    public int getTotalproduto() {
        return totalproduto;
    }

    public void setTotalproduto(int totalproduto) {
        this.totalproduto = totalproduto;
    }
}
