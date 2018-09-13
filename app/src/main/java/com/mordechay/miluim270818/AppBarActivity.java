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
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.mordechay.miluim270818.Chat.ChatFragRec;
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
        setPointer();
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

    /**
     * to bom:
     * menu - set account/
     */
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
        int id = item.getItemId();

        switch (id){
            case R.id.nav_tank:
                Log.e("err", "onNavigationItemSelected: tamk pressed");
                setMyFrag(new TankFrag());
                Toast.makeText(this,"Tank pressed",Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_friend:
                Toast.makeText(this,"friend pressed",Toast.LENGTH_LONG).show();
                ft = fm.beginTransaction();
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.replace(R.id.containerMain,new FriendFrag());
                ft.add(R.id.LLFragChat,new ChatFragRec());
                ft.commit();
                break;
            case R.id.nav_kishur:
                setMyFrag(new ChatFragRec());
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
//                camera for catch problem or for save data for the soldier in his private folder
//                case R.id.nav_share:
//                setMyFrag(new TankFrag());
//                Toast.makeText(this,"Share pressed",Toast.LENGTH_LONG).show();
//                break;

           default: setMyFrag(new TankFrag());
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setMyFrag(Fragment myFrag) {
        ft = fm.beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.replace(R.id.containerMain,myFrag);
        ft.commit();
    }
}
