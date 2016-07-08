package com.saidmar.petagram.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.saidmar.petagram.Dandy;
import com.saidmar.petagram.Mascotas;
import com.saidmar.petagram.R;
import com.saidmar.petagram.adapter.DandyAdapter;
import com.saidmar.petagram.adapter.MascotasAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    ArrayList<Dandy> dandy;
    private RecyclerView listaDandy;
    public DandyAdapter adapter;


    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        //  agregarFAB();

        listaDandy = (RecyclerView)v.findViewById(R.id.rv_dandy);
        GridLayoutManager glm = new GridLayoutManager(getContext(),3);
        listaDandy.setLayoutManager(glm);

        iniciarListaDandy();
        inicializarAdaptador();




        return v;
    }

   private void inicializarAdaptador() {
        adapter = new DandyAdapter(dandy,getActivity());
        listaDandy.setAdapter(adapter);
    }


    public void iniciarListaDandy(){

        //instancear mi arraylist para pdoer llenar la lista (ES NECESARIO)
        dandy = new ArrayList<Dandy>();



        //agrgamos las mascotas a la lista
        dandy.add(new Dandy(R.drawable.dandy1,"6"));
        dandy.add(new Dandy(R.drawable.dandy2,"2"));
        dandy.add(new Dandy(R.drawable.dandy3,"7"));
        dandy.add(new Dandy(R.drawable.dandy4,"8"));
        dandy.add(new Dandy(R.drawable.dandy5,"4"));
        dandy.add(new Dandy(R.drawable.dandy6,"3"));
        dandy.add(new Dandy(R.drawable.dandy7,"9"));
        dandy.add(new Dandy(R.drawable.dandy8,"12"));

    }




}
