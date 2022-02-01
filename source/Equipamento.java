package tppoao2018;

import java.io.Serializable;

public class Equipamento implements Serializable {

    protected String tipo;

    public Equipamento(String tipo) {
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
        return tipo;
    }

}
