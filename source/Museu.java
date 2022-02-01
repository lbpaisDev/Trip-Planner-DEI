package tppoao2018;

import java.io.Serializable;

public class Museu extends PontoInteresse implements Serializable {

    protected String desc;

    public Museu(String desc, String nome, float custoEntrada, float custoTotalEntrada) {
        super(nome, custoEntrada, custoTotalEntrada);
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "||Museu " + "desc=" + desc + "||" + "\n";
    }

}
