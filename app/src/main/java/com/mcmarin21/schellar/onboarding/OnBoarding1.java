package com.mcmarin21.schellar.onboarding;

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

public class OnBoarding1 extends Fragment implements View.OnClickListener {

    Button siguiente;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_on_boarding1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        siguiente = view.findViewById(R.id.on_boarding_1_siguiente);
        siguiente.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Navigation.findNavController(v).navigate(R.id.action_onBoarding1_to_onBoarding2);
    }
}