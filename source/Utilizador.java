package tppoao2018;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Utilizador implements Serializable {

    protected String nome;
    protected String numeroEstudante;
    protected String password;
    protected float montanteMax;
    protected ArrayList<Local> localPref = new ArrayList<>();
    protected ArrayList<PontoInteresse> pontoPref = new ArrayList<>();
    protected PontoInteresse[] pontosInteresse;
    protected Viagem viagemPlano;

    public Utilizador(String nome, String numeroEstudante, String password) {
        this.nome = nome;
        this.password = password;
        this.numeroEstudante = numeroEstudante;
        this.montanteMax = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getPassword() {
        return password;
    }

    public float getMontanteMax() {
        return montanteMax;
    }

    public ArrayList<Local> getLocaisPref() {
        return localPref;
    }

    public PontoInteresse[] getPontosInteresse() {
        return pontosInteresse;
    }

    public Viagem getViagemPlano() {
        return viagemPlano;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMontanteMax(float montanteMax) {
        this.montanteMax = montanteMax;
    }

    public void adcLocalPref(Local local) {
        localPref.add(local);
    }

    public void adcPontoPref(PontoInteresse p) {
        pontoPref.add(p);
    }

    public ArrayList<PontoInteresse> getPontosPref() {
        return pontoPref;
    }

    @Override
    public String toString() {
        return "Utilizador{" + "nome=" + nome + ", password=" + password + ", montanteMax=" + montanteMax + ", locaisPref=" + localPref + ", pontosInteresse=" + pontosInteresse + ", viagemPlano=" + viagemPlano + '}';
    }

}
