package com.mcmarin21.schellar.account;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class StartupPage extends Fragment implements View.OnClickListener {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button login = view.findViewById(R.id.mainBtnLogin);
        Button signUp = view.findViewById(R.id.mainBtnSignUp);
        login.setOnClickListener(this);
        signUp.setOnClickListener(this);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("session", Context.MODE_PRIVATE);

        String userName = sharedPreferences.getString("user_name_key", null);

        if(userName != null){
            Intent intent = new Intent(getContext(), App.class);
            startActivity(intent);
            getActivity().finish();
        }

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