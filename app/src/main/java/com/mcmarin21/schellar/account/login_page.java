package com.mcmarin21.schellar.account;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.mcmarin21.schellar.database.Base;
import com.mcmarin21.schellar.R;

public class login_page extends Fragment implements View.OnClickListener {

    EditText etUser, etPassword;
    Button btLogin, btNewAccount;
    TextInputLayout tiUser, tiPassword;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etUser = view.findViewById(R.id.login_et_user);
        etPassword = view.findViewById(R.id.login_et_password);

        btLogin = view.findViewById(R.id.login_bt_login);
        btNewAccount = view.findViewById(R.id.login_bt_new_account);

        tiPassword = view.findViewById(R.id.login_ti_password);
        tiUser = view.findViewById(R.id.login_ti_user);

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

            String userName = etUser.getText().toString();
            String password = etPassword.getText().toString();

            if( userName.isEmpty() ){
                tiUser.setError("Ingrese un usuario");
                return;
            }else{
                tiUser.setError(null);
            }
            if (password.isEmpty()){
                tiPassword.setError("Ingrese una contraseña");
                return;
            }else{
                tiPassword.setError(null);
            }

            Base dBSchellar = new Base(getContext(), "schellar", null, 1);
            SQLiteDatabase baseR = dBSchellar.getReadableDatabase();

            Cursor existenteUserName = baseR.rawQuery("select count(*) from usuario where user = " + '"' + userName + '"', null);

            existenteUserName.moveToFirst();

            if(Integer.parseInt(existenteUserName.getString(0)) > 0){

                Cursor usuario = baseR.rawQuery("select * from usuario where user = " + '"' + userName + '"' + " AND password = " + '"' + password + '"', null);

                if(usuario.moveToFirst()){

                    Toast.makeText(getContext(), "Usuario encontrdo", Toast.LENGTH_SHORT).show();

                }else{
                    tiPassword.setError("Contaseña incorrecta");
                }
            }else{
                tiUser.setError("El usuario no existe");

            }

            baseR.close();


            return;
        }
        if( opc == R.id.login_bt_new_account ){
            Navigation.findNavController(v).navigate(R.id.action_login_page_to_signUpPage);
            return;
        }
    }
}