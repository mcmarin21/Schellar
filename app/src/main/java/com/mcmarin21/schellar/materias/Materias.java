package com.mcmarin21.schellar.materias;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mcmarin21.schellar.R;
import com.mcmarin21.schellar.adapters.MateriaAdapter;
import com.mcmarin21.schellar.model.Base;
import com.mcmarin21.schellar.model.Materia;
import com.mcmarin21.schellar.model.Periodo;
import com.mcmarin21.schellar.model.enums.Colores;

import java.util.ArrayList;
import java.util.Date;

public class Materias extends Fragment implements AdapterView.OnItemClickListener, View.OnClickListener {

    RecyclerView recyclerView;
    ArrayList<Materia> materias;
    AutoCompleteTextView periodos;
    ArrayList<Periodo> periodosArray;
    ImageView noMateriasImg;
    LinearLayout noMaterias;
    ArrayAdapter<Periodo> adapter;
    MateriaAdapter materiaAdapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        noMateriasImg = view.findViewById(R.id.materias_imgv_empty);
        noMateriasImg.setImageResource(R.drawable.img_not_found);

        noMaterias = view.findViewById(R.id.materias_ll_no_materias);

        materias = new ArrayList<>();
        periodosArray = new ArrayList<>();

        Base dbSchellar = new Base(getContext(), "schellar", null, 1);



        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_dropdown_item_1line, periodosArray);
        periodos = view.findViewById(R.id.materias_atv_periodos);
        periodos.setAdapter(adapter);
        periodos.setOnItemClickListener(this);
        if(periodosArray.size() == 0){
            periodos.setOnClickListener(this);
        }

        recyclerView = view.findViewById(R.id.materias_rv_materias);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        materiaAdapter = new MateriaAdapter(getContext(), materias);
        recyclerView.setAdapter(materiaAdapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_materias, container, false);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Periodo periodo = periodosArray.get(position);
        materias.clear();
        materias.addAll(periodo.getMaterias());
        materiaAdapter.notifyDataSetChanged();
        if (materias.size() == 0) {
            recyclerView.setVisibility(View.GONE);
            noMaterias.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            noMaterias.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        if(periodosArray.size() == 0){
            Toast.makeText(getContext(), "Aun no ha agregado ningun periodo", Toast.LENGTH_SHORT).show();
        }
    }
}