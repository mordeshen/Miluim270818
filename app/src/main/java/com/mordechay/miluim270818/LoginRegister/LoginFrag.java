package com.mordechay.miluim270818.LoginRegister;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.mordechay.miluim270818.Defaults;
import com.mordechay.miluim270818.MainActivity;
import com.mordechay.miluim270818.R;

public class LoginFrag extends Fragment implements View.OnClickListener {
    Button btnLog;
    EditText txtEmail,txtPass;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.login_frag, container, false);
        txtEmail = (EditText)v.findViewById(R.id.emailLog);
        txtPass = (EditText) v.findViewById(R.id.passwordLog);
        btnLog = (Button) v.findViewById(R.id.btnLogin);
        return v;
       }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        btnLog.setOnClickListener(this);

    }

    private void loginUser(){
        Backendless.UserService.login((txtEmail.getText().toString()),(txtPass.getText().toString()), new AsyncCallback<BackendlessUser>() {
                    @SuppressLint("ResourceType")
                    @Override
                    public void handleResponse(BackendlessUser response) {
                        Toast.makeText(getActivity(),"login Succeed",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getActivity(), MainActivity.class));
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        Toast.makeText(getActivity(),"login failed" + getFault(fault.getCode()),Toast.LENGTH_LONG).show();
//                        startActivity(new Intent(getActivity(), MainActivity.class));


                    }

                    private String getFault(String code) {
                        switch (code){
                            case "3003":
                                return "Invalid login or password";
                            case "3033":
                                return "Unable to register user. User already exists";
                            case "3040":
                                return "Provided email has wrong format";
                        }

                        return "Another Fault";
                    }
                }
        );
    }

    @Override
    public void onClick(View v) {
        Log.e("ButtonLogin", "onClick: buttonLogin");
        loginUser();
    }
}
