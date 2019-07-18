package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by delaroy on 3/18/17.
 */
public class Kategoriler extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

   public Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategoriler);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        btn1=(Button)findViewById(R.id.btnekle);
        btn2=(Button)findViewById(R.id.btnlistele);
        setSupportActionBar(toolbar);
        DrawerLayout drawer=(DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(
                this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close
        );
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView=(NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Kategoriler.this,ListeleActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer=(DrawerLayout)findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_drawer,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.action_setting)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.gallery)
        {
            Intent searchIntent=new Intent(Kategoriler.this, Kategoriler.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right,R.anim.push_out_left);
        }
        else if(id==R.id.fileimport)
        {
            Intent searchIntent=new Intent(Kategoriler.this, Urunler.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right,R.anim.push_out_left);
        }
        else if(id==R.id.slideshow)
        {
            Intent searchIntent=new Intent(Kategoriler.this, Yorumlar.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right,R.anim.push_out_left);
        }
        DrawerLayout drawer=(DrawerLayout)findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    }

