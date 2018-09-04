package com.mordechay.miluim270818;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Backendless.setUrl(Defaults.SERVER_URL);
        Backendless.initApp(getApplicationContext(),Defaults.APPLICATION_ID,Defaults.API_KEY);
//        AppBarLayout appBarLayout = new AppBarLayout(this);

//        setPointer();
//        saveData();
    }

//    private void setPointer() {
//    }
//
//    private void saveData() {
//        friends friends = new friends();
//       friends.setImagePerson(R.drawable.btn_facebook_bg);
//        friends.setName(txtEmail);
//        friends.setPhoneNumber(String.valueOf(R.id.password));
//
//        Backendless.Persistence.save(friends, new AsyncCallback<com.mordechay.miluim270818.friends>() {
//            @Override
//            public void handleResponse(com.mordechay.miluim270818.friends response) {
//                Toast.makeText(MainActivity.this,"data saved", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void handleFault(BackendlessFault fault) {
//                Toast.makeText(MainActivity.this,"data isnt saved",Toast.LENGTH_LONG).show();
//                Log.e("data","handleFault: " +fault.getMessage());
//            }
//        });
//    }



}

