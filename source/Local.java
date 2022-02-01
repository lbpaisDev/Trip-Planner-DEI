package tppoao2018;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Local implements Serializable {

    protected String local;
    private int distancia;
    private float custoTotal;
    private int popularidade;
    private ArrayList<PontoInteresse> listaPontos = new ArrayList<PontoInteresse>();

    public Local(String local, ArrayList<PontoInteresse> pontosInteresse, int distancia) {
        this.local = local;
        this.listaPontos = pontosInteresse;
        this.distancia = distancia;
        if (this.distancia <= 450) {
            this.custoTotal = 50 + this.distancia / 100;
        } else if (this.distancia > 450 && this.distancia <= 600) {
            this.custoTotal = 80 + this.distancia / 80;
        } else if (this.distancia > 600 && this.distancia < 3000) {
            this.custoTotal = 200 + this.distancia / 100;
        } else if (this.distancia >= 3000 && this.distancia < 8500) {
            this.custoTotal = 200 + this.distancia / 80;
        } else {
            this.custoTotal = 300 + this.distancia / 100;
        }
    }

    public String getLocal() {
        return local;
    }

    public float getCustoTotal() {
        return custoTotal;
    }

    public void setPopularidade(int pop) {
        this.popularidade = pop;
    }

    public int getPopularidade() {
        return popularidade;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getDistance() {
        return distancia;
    }

    public ArrayList<PontoInteresse> getListaPontos() {
        return listaPontos;
    }

    @Override
    public String toString() {
        return "Local{" + "local=" + local + " dist: " + distancia + " km   preço base: $" + custoTotal + "pop:  " + popularidade + "\n" + " POIs=" + listaPontos.toString() + '}';
    }

}
