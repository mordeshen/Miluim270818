package com.mordechay.miluim270818.LoginRegister;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
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
public class LoginActivity extends AppCompatActivity {

    // UI references.
    private FragmentManager fm;
    private FragmentTransaction ft;
    RegisterFrag registerFrag;
    Button btnFLog,btnFReg;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Backendless.setUrl(Defaults.SERVER_URL);
        Backendless.initApp(getApplicationContext(),Defaults.APPLICATION_ID,Defaults.API_KEY);

        btnFLog = findViewById(R.id.btnToLogFrag);
        btnFReg = findViewById(R.id.btnToRegFrag);

        fm = getFragmentManager();
        ft = fm.beginTransaction();

        registerFrag=new RegisterFrag();

        setPointer();
       }

    @SuppressLint("CommitTransaction")
    private void setPointer() {
        btnFLog.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"flog pressed",Toast.LENGTH_LONG).show();
                setMyFrag(new LoginFrag());
            }
        });
        btnFReg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,"freg pressed",Toast.LENGTH_LONG).show();
                setMyFrag(new RegisterFrag());
            }
        });
        }

    public void setMyFrag(Fragment myFrag) {
        ft = fm.beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.replace(R.id.containerLogR,myFrag);
        ft.commit();
    }


//    @Override
//    public void onClick(View v) {
//        int id = v.getId();
//        switch (id){
//            case R.id.email_sign_in_button_to_signin:
//                Toast.makeText(LoginActivity.this,"sign pressed",Toast.LENGTH_LONG).show();
//                loginUser();
//                break;
//            case R.id.email_register_button_to_register:
//                register();
//                Toast.makeText(LoginActivity.this,"regis pressed",Toast.LENGTH_LONG).show();
//                break;
//            case R.id.email_sign_in_button_to_frag:
//                setMyFrag(new LoginFrag());
//                Toast.makeText(LoginActivity.this,"fragSign pressed",Toast.LENGTH_LONG).show();
//                break;
//            case R.id.email_register_button_to_frag:
//                setMyFrag(new RegisterFrag());
//                Toast.makeText(LoginActivity.this,"fragRegis pressed",Toast.LENGTH_LONG).show();
//                break;
//
//        }
//    }
}

