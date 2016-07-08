package com.saidmar.petagram.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.saidmar.petagram.Mascotas;
import com.saidmar.petagram.R;
import com.saidmar.petagram.adapter.MascotasAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment {

    ArrayList<Mascotas> mascotas;
    private RecyclerView listaMascotas;
    public MascotasAdapter adaptador;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);
      //  agregarFAB();



        listaMascotas = (RecyclerView) v.findViewById(R.id.rv_mascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);


        iniciarListaMascotas();


        inicializarAdapter();

        return v;
    }

    public void inicializarAdapter(){
        //creo un objeto del tipo contacto adaptador y tiene que recibir mi lista de contactos
        adaptador = new MascotasAdapter(mascotas,getActivity());
        listaMascotas.setAdapter(adaptador); //el recycler view contiene el adaptador
    }

    public void agregarFAB(){;
       FloatingActionButton miFAB = null;
                miFAB.findViewById(R.id.fab_MiFAB);
        miFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //los toats ya no se usan
                Toast.makeText(getActivity(), getResources().getString(R.string.mensaje), Toast.LENGTH_SHORT).show();


            }
        });
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

}
