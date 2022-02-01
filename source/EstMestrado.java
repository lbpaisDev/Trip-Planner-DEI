package tppoao2018;

public class EstMestrado extends Utilizador {

    protected PontoInteresse pontoEvitar;

    public EstMestrado(String nome, String numeroEstudante, String password) {
        super(nome, numeroEstudante, password);
    }

    public PontoInteresse getPontoEvitar() {
        return pontoEvitar;
    }

    public void setPontoEvitar(PontoInteresse pontoEvitar) {
        this.pontoEvitar = pontoEvitar;
    }

    @Override
    public String toString() {
        return "EstMestrado{" + "pontoEvitar=" + pontoEvitar + '}';
    }

}
