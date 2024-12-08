package com.mcmarin21.schellar.model;

import com.mcmarin21.schellar.model.enums.Colores;

public class Materia {

    public int id;
    public String nombre;
    public Colores color;
    public String profesor;

    public Materia(int id, String nombre, Colores color, String profesor) {
        this.id = id;
        this.nombre = nombre;
        this.color = color;
        this.profesor = profesor;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Colores getColor() {
        return color;
    }

    public String getProfesor() {
        return profesor;
    }



}
