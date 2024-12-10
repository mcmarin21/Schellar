package com.mcmarin21.schellar.model;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Periodo {

    public int id;
    public String nombre;
    Date inicio;
    Date fin;
    ArrayList<Materia> materias;

    public Periodo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Periodo(int id, String nombre, ArrayList<Materia> materias) {
        this.id = id;
        this.nombre = nombre;
        this.materias = materias;
    }

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

    public static Date convertDate(String date){
        Date resultado = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            resultado = sdf.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

}
