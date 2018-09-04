package com.mordechay.miluim270818.LoginRegister;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.backendless.Backendless;
import com.mordechay.miluim270818.Defaults;
import com.mordechay.miluim270818.R;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    // UI references.
    private FragmentManager fm;
    private FragmentTransaction ft;
    RegisterFrag registerFrag;
    Button btnFLog,btnFReg;


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

}

