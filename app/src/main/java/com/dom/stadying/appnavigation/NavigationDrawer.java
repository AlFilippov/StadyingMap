package com.dom.stadying.appnavigation;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.dom.stadying.R;
import com.dom.stadying.MainActivity;
import com.dom.stadying.choiceprofession.AskMe;
import com.dom.stadying.choiceprofession.ChoiceOfProfession;
import com.dom.stadying.choiceprofession.ProfessionDefinition;

public class NavigationDrawer extends MainActivity
        implements NavigationView.OnNavigationItemSelectedListener, AskMe.OnChangedFragment {
    private static final String YES_DECIDED = "ydecided";
    private static final String WANT_DEFENITION = "wdecided";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        AskMe askMe = new AskMe();
        ft.add(R.id.container, askMe);
        ft.commit();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//TODO:Значок конверта - переделать в Избранное
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
//TODO:Инициадизируется общий экран - подумать,что там может находится
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void ChangedFragment(String s) {
        if (s.equals(YES_DECIDED)) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ChoiceOfProfession ch = new ChoiceOfProfession();
            ft.replace(R.id.container, ch);
            ft.addToBackStack(null);
            ft.commit();
        } else if (s.equals(WANT_DEFENITION)) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ProfessionDefinition pd = new ProfessionDefinition();
            ft.replace(R.id.container, pd);
            ft.addToBackStack(null);
            ft.commit();
        }
    }


    //Проверяется открыта ли шторка , при нажатии кнопки назад

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

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


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_news) {
            // Handle the camera action
        } else if (id == R.id.nav_lessons) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            AskMe askMe = new AskMe();
            ft.add(R.id.container, askMe);
            ft.commit();
        } else if (id == R.id.nav_tasks) {

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        item.setChecked(true);
        setTitle(item.getTitle());
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
