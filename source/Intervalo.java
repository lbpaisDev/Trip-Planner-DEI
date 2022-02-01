package tppoao2018;

import java.io.Serializable;

public class Intervalo implements Serializable {

    protected Hora começo;
    protected Hora fim;

    public Intervalo(Hora começo, Hora fim) {
        this.começo = começo;
        this.fim = fim;
    }

    public Hora getComeço() {
        return começo;
    }

    public void setComeço(Hora começo) {
        this.começo = começo;
    }

    public Hora getFim() {
        return fim;
    }

    public void setFim(Hora fim) {
        this.fim = fim;
    }

    @Override
    public String toString() {
        return começo + ":" + fim + '}';
    }

}
