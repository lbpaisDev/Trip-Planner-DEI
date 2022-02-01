package tppoao2018;

import java.io.Serializable;

public class Bar extends PontoInteresse implements Serializable {

    public float custoExtra;

    public Bar(String nome, float custoEntrada, float custoTotalEntrada) {
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
        return "||Bar " + "nome=" + nome + " preço " + custoEntrada + "||" + "\n";
    }

}
