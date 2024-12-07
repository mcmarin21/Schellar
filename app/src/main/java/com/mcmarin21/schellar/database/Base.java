package com.mcmarin21.schellar.database;

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

        db.execSQL("create table usuario(idUsuario INTEGER primary key AUTOINCREMENT, user varchar(20), email varchar(50), password varchar(20));");

        db.execSQL("create table periodo(idPeriodo INTEGER primary key AUTOINCREMENT, nombrePeriodo varchar(100), inicioPeriodo date, finPeriodo date);");

        db.execSQL("create table materia(idMateria INTEGER primary key AUTOINCREMENT, nombreMateria varchar(100), colorMateria varchar(50), profesorMateria varchar(100), periodo INTEGER, FOREIGN KEY(periodo) REFERENCES periodo(idPeriodo));");

        db.execSQL("create table parcial(idParcial INTEGER primary key AUTOINCREMENT, nombreParical varchar(100), valorParcial real, materia INTEGER, FOREIGN KEY(materia) REFERENCES materia(idMateria));");

        db.execSQL("create table rubro(idRubro INTEGER primary key AUTOINCREMENT, nombreRubro varchar(100), valorRubro real, valorConseguido real, parcial INTEGER, FOREIGN KEY(parcial) REFERENCES parcial(idParcial));");

        db.execSQL("create table horario(idHorario INTEGER primary key AUTOINCREMENT, nombreHorario varchar(100), periodo INTEGER, FOREIGN KEY(periodo) REFERENCES periodo(idPeriodo));");

        db.execSQL("create table clase(idClase INTEGER primary key AUTOINCREMENT,  diaClase varchar(10), inicioClase time, finClase time, horario INTEGER, materia INTEGER, FOREIGN KEY(horario) REFERENCES horario(idHorario), FOREIGN KEY(materia) REFERENCES materia(idMateria));");

        db.execSQL("create table actividad(idActividad INTEGER primary key AUTOINCREMENT, inicioActividad datetime, finActividad datetime, tipo varchar(20));");

        db.execSQL("create table tarea(idTarea INTEGER primary key AUTOINCREMENT, nombreTarea varchar(40), descripcion text, fechaEntrega date, tareaCompletada boolean, materia INTEGER, usuario INTEGER, FOREIGN KEY(materia) REFERENCES materia(idMateria), FOREIGN KEY(usuario) REFERENCES usuario(idUsuario));");

        db.execSQL("create table tareaProgramada(idTareaProgramada INTEGER primary key AUTOINCREMENT, actividad INTEGER, tarea INTEGER, FOREIGN KEY(actividad) REFERENCES actividad(idActividad), FOREIGN KEY(tarea) REFERENCES tarea(idTarea));");

        db.execSQL("create table subTarea(idSubTarea INTEGER primary key AUTOINCREMENT, nombreSubtarea varchar(60), subTareaCompletada boolean, tarea INTEGER, FOREIGN KEY(tarea) REFERENCES tarea(idTarea));");

        db.execSQL("create table subTareaProgramada(idSubTareaProgramada INTEGER primary key AUTOINCREMENT, actividad INTEGER, subTarea INTEGER,  FOREIGN KEY(actividad) REFERENCES actividad(idActividad), FOREIGN KEY(subTarea) REFERENCES subTarea(idSubTarea));");

        db.execSQL("create table evento(idEvento INTEGER primary key AUTOINCREMENT, nombreEvento varchar(40), descripcion text);");

        db.execSQL("create table eventoProgramado(idEventoProgramado INTEGER primary key AUTOINCREMENT, actividad INTEGER, evento INTEGER, FOREIGN KEY(actividad) REFERENCES actividad(idActividad), FOREIGN KEY(evento) REFERENCES evento(idEvento));");

        db.execSQL("create table sesionEstudio(idSesionEstudio INTEGER primary key AUTOINCREMENT, nombreSesion varchar(60));");

        db.execSQL("create table sesionEstudioProgramada(idSesionEstudioProgramada INTEGER primary key AUTOINCREMENT, actividad INTEGER, sesionEstudio INTEGER, FOREIGN KEY(actividad) REFERENCES actividad(idActividad), FOREIGN KEY(sesionEstudio) REFERENCES sesionEstudio(idSesionEstudio));");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
