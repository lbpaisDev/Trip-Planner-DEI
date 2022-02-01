package tppoao2018;

import java.io.Serializable;

public class HorarioFuncionamento implements Serializable {

    protected Hora abertura;
    protected Hora fecho;
    protected Intervalo intervalos;

    public HorarioFuncionamento(Hora abertura, Hora fecho, Intervalo intervalos) {
        this.abertura = abertura;
        this.fecho = fecho;
        this.intervalos = intervalos;
    }

    public Hora getAbertura() {
        return abertura;
    }

    public void setAbertura(Hora abertura) {
        this.abertura = abertura;
    }

    public Hora getFecho() {
        return fecho;
    }

    public void setFecho(Hora fecho) {
        this.fecho = fecho;
    }

    public Intervalo getIntervalos() {
        return intervalos;
    }

    public void setIntervalos(Intervalo intervalos) {
        this.intervalos = intervalos;
    }

    @Override
    public String toString() {
        return "Horario:" + "A:" + abertura + " F:" + fecho + " I:" + intervalos + '}';
    }

}
