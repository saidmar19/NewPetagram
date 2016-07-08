package com.saidmar.petagram;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.saidmar.petagram.adapter.MascotasAdapter;
import com.saidmar.petagram.adapter.PageAdapter;
import com.saidmar.petagram.fragment.PerfilFragment;
import com.saidmar.petagram.fragment.RecyclerViewFragment;
import com.saidmar.petagram.menuOpciones.Menu_Acerca;
import com.saidmar.petagram.menuOpciones.Menu_Contacto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascotas> mascotas;
    private RecyclerView listaMascotas;
    public MascotasAdapter adaptador;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //agregarFAB();
        Toolbar miActionBarMain = (Toolbar)findViewById(R.id.miActionBarMain);
        setSupportActionBar(miActionBarMain);


        tabLayout = (TabLayout)findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();

        if(toolbar != null){
            setSupportActionBar(toolbar);
        }

/*
        listaMascotas = (RecyclerView) findViewById(R.id.rv_mascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);


        iniciarListaMascotas();


        inicializarAdapter();
*/
    }

    public void inicializarAdapter(){
        //creo un objeto del tipo contacto adaptador y tiene que recibir mi lista de contactos
        adaptador = new MascotasAdapter(mascotas,this);
        listaMascotas.setAdapter(adaptador); //el recycler view contiene el adaptador
    }

    public void agregarFAB(){
        FloatingActionButton miFAB = (FloatingActionButton)findViewById(R.id.fab_MiFAB);
        miFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //los toats ya no se usan
                Toast.makeText(getBaseContext(), getResources().getString(R.string.mensaje), Toast.LENGTH_SHORT).show();


            }
        });
    }

    public void irFavoritos (View v){

        Intent intent = new Intent(MainActivity.this,MascotasFavoritas.class);
        startActivity(intent);

    }

    public void iniciarListaMascotas(){

        //instancear mi arraylist para pdoer llenar la lista (ES NECESARIO)
        mascotas = new ArrayList<Mascotas>();



        //agrgamos las mascotas a la lista
        mascotas.add(new Mascotas(R.drawable.gatito,"Flufy","6"));
        mascotas.add(new Mascotas(R.drawable.perrito,"Spike","3"));
        mascotas.add(new Mascotas(R.drawable.pikachu,"Max","5"));
        mascotas.add(new Mascotas(R.drawable.sombrerogatito,"Suzy","10"));
        mascotas.add(new Mascotas(R.drawable.ratoncito,"Mickey","4"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.mContacto:
                Intent intent = new Intent(MainActivity.this,Menu_Contacto.class);
                startActivity(intent);
                break;
            case R.id.mAcerca:
                Intent i = new Intent(MainActivity.this,Menu_Acerca.class);
                startActivity(i);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment>  agregarFragments(){ //con este metodo estamos agregando los fragments a la lista
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_menu);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dog);
    }

}