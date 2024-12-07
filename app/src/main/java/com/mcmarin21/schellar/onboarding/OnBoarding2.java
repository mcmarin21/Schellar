package com.mcmarin21.schellar.onboarding;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mcmarin21.schellar.R;
import com.mcmarin21.schellar.activities.App;

public class OnBoarding2 extends Fragment implements View.OnClickListener {

    Button siguiente, anterior;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        siguiente = view.findViewById(R.id.on_boarding_2_siguiente);
        anterior = view.findViewById(R.id.on_boarding_2_anterior);

        siguiente.setOnClickListener(this);
        anterior.setOnClickListener(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_on_boarding2, container, false);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == siguiente.getId()){
            Intent intent = new Intent(getContext(), App.class);
            startActivity(intent);
            getActivity().finish();
            return;
        }
        if(v.getId() == anterior.getId()){
            Navigation.findNavController(v).navigate(R.id.action_onBoarding2_to_onBoarding1);
            return;
        }

    }
}