package com.mordechay.miluim270818.LoginRegister;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.mordechay.miluim270818.Defaults;
import com.mordechay.miluim270818.MainActivity;
import com.mordechay.miluim270818.R;
import com.mordechay.miluim270818.Tank.TankFrag;
import com.mordechay.miluim270818.friends;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private String txtEmail,txtPass;
    private FragmentManager fm;
    private FragmentTransaction ft;
    LoginFrag loginFrag;
    RegisterFrag registerFrag;
    Button btnLog,btnReg,btnFLog,btnFReg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Backendless.setUrl(Defaults.SERVER_URL);
        Backendless.initApp(getApplicationContext(),Defaults.APPLICATION_ID,Defaults.API_KEY);

        setPointer();
       }

    @SuppressLint("CommitTransaction")
    private void setPointer() {
        mEmailView = findViewById(R.id.email);
        mPasswordView = findViewById(R.id.password);
        txtPass = String.valueOf(mPasswordView);
        txtEmail = String.valueOf(mEmailView);
        fm = getFragmentManager();
        ft = fm.beginTransaction();
    }
//        btnLog = findViewById(R.id.email_sign_in_button_to_signin);
//        btnLog.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(LoginActivity.this,"sign pressed",Toast.LENGTH_LONG).show();
//                loginUser();
//            }
//        });
//
//       btnReg = findViewById(R.id.email_register_button_to_register);
//       btnReg.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                register();
//                Toast.makeText(LoginActivity.this,"regis pressed",Toast.LENGTH_LONG).show();
//            }
//        });
//
//       btnFLog = findViewById(R.id.email_sign_in_button_to_signin);
//       btnFLog.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setMyFrag(new LoginFrag());
//                Toast.makeText(LoginActivity.this,"fragSign pressed",Toast.LENGTH_LONG).show();
//            }
//        });
//
//       btnFReg = findViewById(R.id.email_sign_in_button_to_signin);
//       btnFReg.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setMyFrag(new RegisterFrag());
//                Toast.makeText(LoginActivity.this,"fragRegis pressed",Toast.LENGTH_LONG).show();
//            }
//        });
//








    private void loginUser(){
        Backendless.UserService.login(txtEmail, txtPass, new AsyncCallback<BackendlessUser>() {
                    @Override
                    public void handleResponse(BackendlessUser response) {
                        Toast.makeText(LoginActivity.this,"login Succeed",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        Log.e("err","hsndleFault: "+ fault.getCode());
                        Toast.makeText(LoginActivity.this, "there's a problema",Toast.LENGTH_LONG).show();

                    }
                }
        );
    }
    private void register() {
        BackendlessUser user = new BackendlessUser();
        user.setProperty("email",String.valueOf(R.id.email));

        user.setPassword(String.valueOf(R.id.password));
        user.setProperty("age",Integer.valueOf(R.id.age));
        user.setProperty("gender",String.valueOf(R.id.gender));

        Backendless.UserService.register(user, new AsyncCallback<BackendlessUser>() {
            @Override
            public void handleResponse(BackendlessUser response) {
                Toast.makeText(LoginActivity.this,"user Registered",Toast.LENGTH_LONG).show();
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Toast.makeText(LoginActivity.this,"error in registration",Toast.LENGTH_LONG).show();
                Log.e("err","handleFault: " + fault.getCode());
            }
        });
    }
    public void setMyFrag(Fragment myFrag) {
        ft = fm.beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.replace(R.id.containerLogR,myFrag);
        ft.commit();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int v = view.getId();
        switch (v){
            case R.id.email_sign_in_button_to_signin:
                Toast.makeText(LoginActivity.this,"sign pressed",Toast.LENGTH_LONG).show();
                loginUser();
                break;
            case R.id.email_register_button_to_register:
                register();
                Toast.makeText(LoginActivity.this,"regis pressed",Toast.LENGTH_LONG).show();
                break;
            case R.id.email_sign_in_button_to_frag:
                setMyFrag(new LoginFrag());
                Toast.makeText(LoginActivity.this,"fragSign pressed",Toast.LENGTH_LONG).show();
                break;
            case R.id.email_register_button_to_frag:
                setMyFrag(new RegisterFrag());
                Toast.makeText(LoginActivity.this,"fragRegis pressed",Toast.LENGTH_LONG).show();
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

