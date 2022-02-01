package tppoao2018;

import java.io.Serializable;
import java.util.Arrays;

public class Tematico extends Parque implements Serializable {

    protected String tema;
    protected Boolean espetaculos;
    protected Equipamento[] equipamentos;

    public Tematico(String tema, Boolean espetaculos, Equipamento[] equipamentos, String nome, float custoEntrada, float custoTotalEntrada) {
        super(nome, custoEntrada, custoTotalEntrada);
        this.tema = tema;
        this.espetaculos = espetaculos;
        this.equipamentos = equipamentos;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Boolean getEspetaculos() {
        return espetaculos;
    }

    public void setEspetaculos(Boolean espetaculos) {
        this.espetaculos = espetaculos;
    }

    public Equipamento[] getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(Equipamento[] equipamentos) {
        this.equipamentos = equipamentos;
    }

    @Override
    public String toString() {
        return "||Tematico " + "tema=" + tema + ", espetaculos=" + espetaculos + ", equipamentos=" + Arrays.toString(equipamentos) + "||" + "\n";

    }

}
