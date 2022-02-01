package tppoao2018;

import java.io.Serializable;
import java.util.Arrays;

public class Universidade extends PontoInteresse implements Serializable {

    protected CursoEngInformatica[] cursos;

    public Universidade(CursoEngInformatica[] cursos, String nome, float custoEntrada, float custoTotalEntrada) {
        super(nome, custoEntrada, custoTotalEntrada);
        this.cursos = cursos;
    }

    public CursoEngInformatica[] getCurso() {
        return cursos;
    }

    public void setCurso(CursoEngInformatica curso) {
        this.cursos = cursos;
    }

    @Override
    public String toString() {
        return "||Universidade " + "curso=" + Arrays.toString(cursos) + "||" + "\n";
    }

}
