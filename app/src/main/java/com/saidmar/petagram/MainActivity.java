package com.saidmar.petagram;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascotas> mascotas;
    private RecyclerView listaMascotas;
    public MascotasAdapter adaptador;
    private static int ranking;
    private static String sRanking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ranking=0;

        agregarFAB();
        Toolbar miActionBarMain = (Toolbar)findViewById(R.id.miActionBarMain);
        setSupportActionBar(miActionBarMain);

        listaMascotas = (RecyclerView) findViewById(R.id.rv_mascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);


        iniciarListaMascotas();


        inicializarAdapter();

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

        sRanking = String.valueOf(ranking);

        //agrgamos las mascotas a la lista
        mascotas.add(new Mascotas(R.drawable.gatito,"Flufy",sRanking));
        mascotas.add(new Mascotas(R.drawable.perrito,"Spike",sRanking));
        mascotas.add(new Mascotas(R.drawable.pikachu,"Max",sRanking));
        mascotas.add(new Mascotas(R.drawable.sombrerogatito,"Suzy",sRanking));
        mascotas.add(new Mascotas(R.drawable.ratoncito,"Mickey",sRanking));
    }
}