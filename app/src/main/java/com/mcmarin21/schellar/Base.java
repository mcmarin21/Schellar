package com.mcmarin21.schellar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Base extends SQLiteOpenHelper {


    public Base(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table usuario(idUsuario int primary key autoincrement, user varchar(20), email varchar(50), password varchar(20))");

        db.execSQL("create table periodo(idPeriodo int primary key autoincrement, nombrePeriodo varchar(100), inicioPeriodo date, finPeriodo date)");

        db.execSQL("create table materia(idMateria int primary key autoincrement, nombreMateria varchar(100), colorMateria varchar(50), " +
                "profesorMateria varchar(100), FOREIGN KEY(periodo) REFERENCES periodo(idPeriodo))");

        db.execSQL("create table parcial(idParcial int primary key autoincrement, nombreParical varchar(100), valorParcial real, " +
                "FOREIGN KEY(materia) REFERENCES materia(idMateria))");

        db.execSQL("create table rubro(idRubro int primary key autoincrement, nombreRubro varchar(100), valorRubro real, " +
                "valorConseguido real, FOREIGN KEY(parcial) REFERENCES parcial(idParcial))");

        db.execSQL("create table horario(idHorario int primary key autoincrement, nombreHorario varchar(100), FOREIGN KEY(periodo) REFERENCES periodo(idPeriodo))");

        db.execSQL("create table clase(idClase int primary key autoincrement,  diaClase varchar(10), inicioClase time, finClase time, " +
                "FOREIGN KEY(horario) REFERENCES horario(idHorario), FOREIGN KEY(materia) REFERENCES materia(idMateria))");

        db.execSQL("create table tarea(idTarea int primary key autoincrement, nombreTarea varchar(40), descripcion text, fechaEntrega date, " +
                "tareaCompletada boolean, FOREIGN KEY(materia) REFERENCES materia(idMateria))");

        db.execSQL("create table subTarea(idSubTarea int primary key autoincrement, nombreSubtarea varchar(60), FOREIGN KEY(tarea) REFERENCES tarea(idTarea))");

        db.execSQL("create table evento(idEvento int primary key autoincrement, nombreEvento varchar(40), descripcion text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
