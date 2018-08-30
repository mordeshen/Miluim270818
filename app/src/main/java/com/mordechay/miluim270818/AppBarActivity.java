package com.mordechay.miluim270818;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.mordechay.miluim270818.Friend.FriendFrag;
import com.mordechay.miluim270818.Tank.TankFrag;

public class AppBarActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentManager fm;
    FragmentTransaction ft;
    TankFrag tankFrag;
    FriendFrag friendFrag;
    Button btnNavTank;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        setPointer();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                            .setAction("Action", null).show();
//                }
//        });

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    private void setPointer() {
        fm = getFragmentManager();
        ft = fm.beginTransaction();
        tankFrag = new TankFrag();
        friendFrag = new FriendFrag();


   }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id){
            case R.id.nav_tank:
                setMyFrag(new TankFrag());
                Toast.makeText(this,"Tank pressed",Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_friend:
                setMyFrag(new FriendFrag());
                Toast.makeText(this,"friend pressed",Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_kishur:
                setMyFrag(new TankFrag());
                Toast.makeText(this,"Kishur pressed",Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_proMaterial:
                setMyFrag(new TankFrag());
                Toast.makeText(this,"ProMateria pressed",Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_share:
                setMyFrag(new TankFrag());
                Toast.makeText(this,"Share pressed",Toast.LENGTH_LONG).show();
                break;

           default: setMyFrag(new TankFrag());
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setMyFrag(Fragment myFrag) {
        ft = fm.beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.replace(R.id.container,myFrag);
        ft.commit();
    }
}