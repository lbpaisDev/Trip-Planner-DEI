package tppoao2018;

import java.io.Serializable;

public class PontoInteresse implements Serializable {

    protected String nome;
    protected float custoEntrada;
    protected int Popularidade;
    protected HorarioFuncionamento horarioFunc;
    protected float custoTotalEntrada;

    public PontoInteresse(String nome, float custoEntrada, float custoTotalEntrada) {
        this.nome = nome;
        this.custoEntrada = custoEntrada;
        this.custoTotalEntrada = custoTotalEntrada;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getCustoEntrada() {
        return custoEntrada;
    }

    public void setCustoEntrada(float custoEntrada) {
        this.custoEntrada = custoEntrada;
    }

    public int getPopularidade() {
        return Popularidade;
    }

    public void setPopularidade(int Popularidade) {
        this.Popularidade = Popularidade;
    }

    public HorarioFuncionamento getHorarioFunc() {
        return horarioFunc;
    }

    public void setHorarioFunc(HorarioFuncionamento horarioFunc) {
        this.horarioFunc = horarioFunc;
    }

    public float getCustoTotalEntrada() {
        return custoTotalEntrada;
    }

    public void setCustoTotalEntrada(float custoTotalEntrada) {
        this.custoTotalEntrada = custoTotalEntrada;
    }

    @Override
    public String toString() {
        return "PontoInteresse{";
    }

}
