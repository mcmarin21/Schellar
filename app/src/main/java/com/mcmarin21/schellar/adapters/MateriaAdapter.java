package com.mcmarin21.schellar.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mcmarin21.schellar.R;
import com.mcmarin21.schellar.model.Materia;
import com.mcmarin21.schellar.viewholder.MateriaViewHolder;

import java.util.ArrayList;


public class MateriaAdapter extends RecyclerView.Adapter<MateriaViewHolder> {

    Context contexto;
    ArrayList<Materia> materias;

    public MateriaAdapter(Context contexto, ArrayList<Materia> materias) {
        this.contexto = contexto;
        this.materias = materias;
    }

    @NonNull
    @Override
    public MateriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MateriaViewHolder(LayoutInflater.from(contexto).inflate(R.layout.layout_materia, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MateriaViewHolder holder, int position) {
        holder.nombre.setText(materias.get(position).getNombre());
        holder.profesor.setText(materias.get(position).getProfesor());
        holder.icProfesor.setImageResource(R.drawable.ic_person_24);
    }

    @Override
    public int getItemCount() {
        return materias.size();
    }
}