package tppoao2018;

import java.util.Arrays;

public class Aquatico extends Parque {

    protected Boolean espetaculo;
    protected int piscinas;
    protected Equipamento[] equipamentos;

    public Aquatico(Boolean espetaculo, int piscinas, Equipamento[] equipamentos, String nome, float custoEntrada, float custoTotalEntrada) {
        super(nome, custoEntrada, custoTotalEntrada);
        this.espetaculo = espetaculo;
        this.piscinas = piscinas;
        this.equipamentos = equipamentos;
    }

    public int getPiscinas() {
        return piscinas;
    }

    public void setPiscinas(int piscinas) {
        this.piscinas = piscinas;
    }

    public Equipamento[] getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(Equipamento[] equipamentos) {
        this.equipamentos = equipamentos;
    }

    @Override
    public String toString() {
        return "||Aquatico " + " piscinas=" + piscinas + ", equipamentos=" + Arrays.toString(equipamentos) + "||" + "\n";
    }

}
