package tppoao2018;

import java.io.Serializable;

public class CursoEngInformatica implements Serializable {

    protected String nome;

    public CursoEngInformatica(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

}
