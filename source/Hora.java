package tppoao2018;

import java.io.Serializable;

public class Hora implements Serializable {

    protected int hora;
    protected int min;

    public Hora(int hora, int min) {
        this.hora = hora;
        this.min = min;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    @Override
    public String toString() {
        return "H:" + hora + " m:" + min;
    }

}
