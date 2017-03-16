package com.example.chegu.diethouse;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class Navigation_drawer_side_menu extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawer;
    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;
    Context mcontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer_side_menu);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView = (NavigationView)findViewById(R.id.navigation_view);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawerlayout);
        actionBarDrawer = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.setDrawerListener(actionBarDrawer);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_container,new Weight_Loss_Fragment());
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("Weight Loss or Gain");
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item1:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new HomeFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Home(Tips)");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.item2:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new ProfileFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("My Profile");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.item3:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new Weight_Loss_Fragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Weight Loss");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.item5:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new ChangePasswordFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Change Password");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.item6:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new AboutUsFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("My Profile");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
//                    case R.id.item7:
////                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
////                        fragmentTransaction.replace(R.id.main_container,new Details());
////                        fragmentTransaction.commit();
////                        getSupportActionBar().setTitle("Previous Data");
////                        item.setChecked(true);
////                        drawerLayout.closeDrawers();
//                        break;

                    case R.id.item8:
                      Intent intent = new Intent(Navigation_drawer_side_menu.this ,MainActivity.class);
                        startActivity(intent);
//                        item.setChecked(true);
                        break;



                }
                return true;
            }
        });

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawer.syncState();

    }

}
