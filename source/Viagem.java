package tppoao2018;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Viagem implements Serializable {

    protected ArrayList<Local> locais = new ArrayList<>();
    protected float custoTotal;
    protected float dist;

    public Viagem(ArrayList<Local> locais, float custoTotal, float dist) {
        this.locais = locais;
        this.custoTotal = custoTotal;
        this.dist = dist;
    }

    public ArrayList<Local> getLocais() {
        return locais;
    }

    public void setLocais(ArrayList<Local> locais) {
        locais = locais;
    }

    public float getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(float custoTotal) {
        this.custoTotal = custoTotal;
    }

    public float getDist() {
        return dist;
    }

    public void setDist(float dist) {
        this.dist = dist;
    }

    @Override
    public String toString() {
        return "Viagem{" + "locais=" + locais + ", custoTotal=" + custoTotal + ", dist=" + dist + '}';
    }

}
