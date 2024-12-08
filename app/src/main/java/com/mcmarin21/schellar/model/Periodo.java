package com.mcmarin21.schellar.model;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Date;

public class Periodo {

    public int id;
    public String nombre;
    Date inicio;
    Date fin;
    ArrayList<Materia> materias;

    public Periodo(int id, String nombre, Date inicio, Date fin) {
        this.id = id;
        this.nombre = nombre;
        this.inicio = inicio;
        this.fin = fin;
    }

    public Periodo(int id, String nombre, Date inicio, Date fin, ArrayList<Materia> materias) {
        this.id = id;
        this.nombre = nombre;
        this.inicio = inicio;
        this.fin = fin;
        this.materias = materias;
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(ArrayList<Materia> materias) {
        this.materias = materias;
    }

    @NonNull
    @Override
    public String toString() {
        return nombre;
    }
}
