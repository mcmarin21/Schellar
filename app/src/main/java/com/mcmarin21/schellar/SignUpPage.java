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
import android.widget.EditText;

public class SignUpPage extends Fragment implements View.OnClickListener {

    EditText etUser, etEmail, etPassword, etPasswordConf;
    Button btSignUp, btLogin;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etUser = view.findViewById(R.id.sign_up_et_user);
        etEmail = view.findViewById(R.id.sign_up_et_email);
        etPassword = view.findViewById(R.id.sign_up_et_password);
        etPasswordConf = view.findViewById(R.id.sign_up_et_password_conf);

        btSignUp = view.findViewById(R.id.sign_up_bt_sign_up);
        btLogin = view.findViewById(R.id.sign_up_bt_login);

        btLogin.setOnClickListener(this);
        btSignUp.setOnClickListener(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up_page, container, false);
    }

    @Override
    public void onClick(View v) {
        int opc = v.getId();

        if(opc == R.id.sign_up_bt_sign_up){



            return;
        }
        if (opc == R.id.sign_up_bt_login){

            Navigation.findNavController(v).navigate(R.id.action_signUpPage_to_login_page);

            return;
        }

    }
}