package com.mcmarin21.schellar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class StartupPage extends Fragment implements View.OnClickListener {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button login = view.findViewById(R.id.mainBtnLogin);
        Button signUp = view.findViewById(R.id.mainBtnSignUp);
        login.setOnClickListener(this);
        signUp.setOnClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_startup_page, container, false);
    }

    @Override
    public void onClick(View v) {
        int opc = v.getId();
        if(opc == R.id.mainBtnLogin){
            Navigation.findNavController(v).navigate(R.id.action_sartupPage_to_login_page);
        }
        if(opc == R.id.mainBtnSignUp){
            Navigation.findNavController(v).navigate(R.id.action_sartupPage_to_signUpPage);
        }
    }
}