package com.mcmarin21.schellar.viewholder;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mcmarin21.schellar.R;

public class MateriaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView nombre, profesor;
    public ImageView icProfesor;
    Button editar, eliminar;


    public MateriaViewHolder(@NonNull View itemView) {
        super(itemView);

        nombre = itemView.findViewById(R.id.layout_materia_tv_nombre);
        profesor = itemView.findViewById(R.id.layout_materia_tv_profesor);
        icProfesor = itemView.findViewById(R.id.layout_materia_ic_profesor);
        editar = itemView.findViewById(R.id.layout_materia_bt_editar);
        eliminar = itemView.findViewById(R.id.layout_materia_bt_eliminar);

        editar.setOnClickListener(this);
        eliminar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.layout_materia_bt_editar){
            Toast.makeText(itemView.getContext(), "Editar de " + nombre.getText().toString(), Toast.LENGTH_SHORT).show();
            return;
        }
        if(v.getId() == R.id.layout_materia_bt_eliminar){
            Toast.makeText(itemView.getContext(), "Eliminar de " + nombre.getText().toString(), Toast.LENGTH_SHORT).show();
            return;
        }

    }
}
