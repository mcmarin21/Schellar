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

public class login_page extends Fragment implements View.OnClickListener {

    EditText etUser, etPassword;
    Button btLogin, btNewAccount;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etUser = view.findViewById(R.id.login_et_user);
        etPassword = view.findViewById(R.id.login_et_password);

        btLogin = view.findViewById(R.id.login_bt_login);
        btNewAccount = view.findViewById(R.id.login_bt_new_account);

        btLogin.setOnClickListener(this);
        btNewAccount.setOnClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login_page, container, false);
    }

    @Override
    public void onClick(View v) {

        int opc = v.getId();

        if( opc == R.id.login_bt_login ){

            String strUser = etUser.getText().toString();
            String strPassword = etPassword.getText().toString();

            if( strUser.isEmpty() ){
                etUser.setError("Ingrese un usuario");
                return;
            }
            if (strPassword.isEmpty()){
                etPassword.setError("Ingrese una contraseña");
                return;
            }

            etUser.setError(null);
            etPassword.setError(null);



            return;
        }
        if( opc == R.id.login_bt_new_account ){
            Navigation.findNavController(v).navigate(R.id.action_login_page_to_signUpPage);
            return;
        }
    }
}