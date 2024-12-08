package com.mcmarin21.schellar.activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.mcmarin21.schellar.agenda.Agenda;
import com.mcmarin21.schellar.app.AppHome;
import com.mcmarin21.schellar.R;
import com.mcmarin21.schellar.app.Configuracion;
import com.mcmarin21.schellar.calificaciones.Calificaciones;
import com.mcmarin21.schellar.horario.Horario;
import com.mcmarin21.schellar.materias.Materias;

public class App extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;

    private static final int NAV_HOME = R.id.nav_home;
    private static final int NAV_HORARIO = R.id.nav_horario;
    private static final int NAV_AGENDA = R.id.nav_agenda;
    private static final int NAV_CALIFICACIONES = R.id.nav_calificaciones;
    private static final int NAV_MATERIAS = R.id.nav_materias;
    private static final int NAV_CONFIGURACION = R.id.nav_configuracion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_app);

        Toolbar toolbar = findViewById(R.id.topAppBar);
        setSupportActionBar(findViewById(R.id.topAppBar));

        drawerLayout = findViewById(R.id.app_main);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.app_navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        MenuItem menuItem = navigationView.getMenu().getItem(0);
        onNavigationItemSelected(menuItem);
        menuItem.setChecked(true);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int fragmentContainer = R.id.app_frame_layout;

        if(item.getItemId() == NAV_HOME){
            getSupportFragmentManager().beginTransaction().replace(fragmentContainer, new AppHome()).commit();
        } else if(item.getItemId() == NAV_HORARIO) {
            getSupportFragmentManager().beginTransaction().replace(fragmentContainer, new Horario()).commit();
        } else if(item.getItemId() == NAV_AGENDA){
            getSupportFragmentManager().beginTransaction().replace(fragmentContainer, new Agenda()).commit();
        } else if (item.getItemId() == NAV_CALIFICACIONES) {
            getSupportFragmentManager().beginTransaction().replace(fragmentContainer, new Calificaciones()).commit();
        } else if (item.getItemId() == NAV_MATERIAS){
            getSupportFragmentManager().beginTransaction().replace(fragmentContainer, new Materias()).commit();
        } else if (item.getItemId() == NAV_CONFIGURACION) {
            getSupportFragmentManager().beginTransaction().replace(fragmentContainer, new Configuracion()).commit();
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}