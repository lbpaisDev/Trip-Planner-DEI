package tppoao2018;

import java.io.Serializable;

public class Cultural extends Parque implements Serializable {

    protected String tipo;

    public Cultural(String tipo, String nome, float custoEntrada, float custoTotalEntrada) {
        super(nome, custoEntrada, custoTotalEntrada);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "||Cultural{" + "tipo=" + tipo + "||" + "\n";
    }

}
