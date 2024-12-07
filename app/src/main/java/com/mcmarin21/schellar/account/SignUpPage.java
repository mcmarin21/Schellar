package com.mcmarin21.schellar.account;

import android.content.ContentValues;
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

public class SignUpPage extends Fragment implements View.OnClickListener {

    EditText etUser, etEmail, etPassword, etPasswordConf;
    Button btSignUp, btLogin;
    TextInputLayout tiUser, tiEmail, tiPassword, tiPasswordConf;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etUser = view.findViewById(R.id.sign_up_et_user);
        etEmail = view.findViewById(R.id.sign_up_et_email);
        etPassword = view.findViewById(R.id.sign_up_et_password);
        etPasswordConf = view.findViewById(R.id.sign_up_et_password_conf);

        tiUser = view.findViewById(R.id.sign_up_ti_user);
        tiEmail = view.findViewById(R.id.sign_up_ti_email);
        tiPassword = view.findViewById(R.id.sign_up_ti_password);
        tiPasswordConf = view.findViewById(R.id.sign_up_ti_password_conf);

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

            String userName = etUser.getText().toString();
            String password = etPassword.getText().toString();
            String passwordConf = etPasswordConf.getText().toString();
            String email = etEmail.getText().toString();

            if(userName.isEmpty()){
                tiUser.setError("Ingrese un usuario");
                return;
            }
            else{
                tiUser.setError(null);
            }

            if(email.isEmpty()){
                tiEmail.setError("Ingrese un correo");
                return;
            }else{
                tiEmail.setError(null);
            }

            if(password.isEmpty()){
                tiPassword.setError("Ingrese un correo");
                return;
            }else{
                tiPassword.setError(null);
            }

            if(passwordConf.isEmpty()){
                tiPasswordConf.setError("Ingrese un correo");
                return;
            }else{
                tiPasswordConf.setError(null);
            }

            if(!password.equals(passwordConf)){
                tiPasswordConf.setError("Las contraseñas no coinciden");
                return;
            }else{
                tiPasswordConf.setError(null);
            }

            Base dBSchellar = new Base(getContext(), "schellar", null, 1);
            SQLiteDatabase base = dBSchellar.getReadableDatabase();
            Cursor existenteUserName = base.rawQuery("select count(*) from usuario where user = " + '"' + userName + '"', null);
            Cursor existenteEmail = base.rawQuery("select count(*) from usuario where email =  " + '"' + email + '"', null);

            existenteUserName.moveToFirst();
            existenteEmail.moveToFirst();

            base.close();

            if(Integer.parseInt(existenteUserName.getString(0)) == 0){

                tiUser.setError(null);
                if(Integer.parseInt(existenteEmail.getString(0)) == 0){

                    tiEmail.setError(null);

                    SQLiteDatabase baseW = dBSchellar.getWritableDatabase();

                    ContentValues registro = new ContentValues();

                    registro.put("user", userName);
                    registro.put("email", email);
                    registro.put("password", password);

                    baseW.insert("usuario", null, registro);

                    Toast.makeText(getContext(), "Registro agregado", Toast.LENGTH_SHORT).show();

                }else{
                    tiEmail.setError("El correo ya esta registrado");
                    return;
                }
            }else{
                tiUser.setError("El usuario ya existe");
                return;
            }

            return;
        }
        if (opc == R.id.sign_up_bt_login){
            Navigation.findNavController(v).navigate(R.id.action_signUpPage_to_login_page);
            return;
        }

    }
}