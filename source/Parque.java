package tppoao2018;

import java.io.Serializable;

public class Parque extends PontoInteresse implements Serializable {

    protected float custoExtra;

    public Parque(String nome, float custoEntrada, float custoTotalEntrada) {
        super(nome, custoEntrada, custoTotalEntrada);
    }

    public float getCustoExtra() {
        return custoExtra;
    }

    public void setCustoExtra(float custoExtra) {
        this.custoExtra = custoExtra;
    }

    @Override
    public String toString() {
        return "Parque{" + "custoExtra=" + custoExtra + '}';
    }

}
