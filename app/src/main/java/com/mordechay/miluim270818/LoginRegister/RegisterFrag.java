package com.mordechay.miluim270818.LoginRegister;

import android.app.Activity;
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

public class RegisterFrag extends Fragment {
    private AutoCompleteTextView mEmailView;
    Button btnLog,btnReg,btnFLog,btnFReg;
    EditText mPasswordView;
    EditText txtEmail,txtPass,txtAge,txtGender;
    Activity activity;
    View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.register, container, false);
        txtEmail = v.findViewById(R.id.email);
        txtAge = v.findViewById(R.id.age);
        txtGender = v.findViewById(R.id.gender);
        txtPass = v.findViewById(R.id.password);
        btnReg = v.findViewById(R.id.btnRegister);
//        Backendless.setUrl(Defaults.SERVER_URL);
//        Backendless.initApp(getActivity(),Defaults.APPLICATION_ID,Defaults.API_KEY);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("regisone", "onClick: ");
                register();
            }
        });

    }


    private void register() {
        BackendlessUser user = new BackendlessUser();
        user.setProperty("email",txtEmail.getText().toString());
        user.setPassword(txtPass.getText().toString());
        user.setProperty("age",Integer.valueOf(txtAge.getText().toString()));
        user.setProperty("gender",txtGender.getText().toString());

        Backendless.UserService.register(user, new AsyncCallback<BackendlessUser>() {
            @Override
            public void handleResponse(BackendlessUser response) {
                Log.e("","REGISTER Succeed: ");
        // Toast.makeText(LoginActivity.this,"user Registered",Toast.LENGTH_LONG).show();
                //intent to MainActivity
                startActivity(new Intent(getActivity(), MainActivity.class));
            }

            @Override
            public void handleFault(BackendlessFault fault) {
          Toast.makeText(getActivity(),"error in registration"+ getFault(fault.getCode()),Toast.LENGTH_LONG).show();
                Log.e("err","handleFault: " + fault.getCode());
            }

            private String getFault(String code) {
                switch (code){
                    case "3003":
                        return "Invalid login or password";
                    case "3033":
                        startActivity(new Intent(getActivity(), MainActivity.class));
                        return "Unable to register user. User already exists";
                    case "3040":
                        return "Provided email has wrong format";
                }

                return "registratin failed. try again";
            }

        });
    }
}
