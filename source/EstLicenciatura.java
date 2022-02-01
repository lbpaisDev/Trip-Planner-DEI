package tppoao2018;

public class EstLicenciatura extends Utilizador {

    protected PontoInteresse pontoHot;

    public EstLicenciatura(String nome, String numeroEstudante, String password) {
        super(nome, numeroEstudante, password);
    }

    public PontoInteresse getPontoHot() {
        return pontoHot;
    }

    public void setPontoHot(PontoInteresse pontoHot) {
        this.pontoHot = pontoHot;
    }

    @Override
    public String toString() {
        return "EstLicenciatura{" + "pontoHot=" + pontoHot + '}';
    }

}
