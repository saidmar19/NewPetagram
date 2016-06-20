package com.saidmar.petagram;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by saidmar on 20/6/2016.
 */
public class MascotasAdapter extends RecyclerView.Adapter<MascotasAdapter.MascotaViewHolder>{

    ArrayList<Mascotas> mascotas;
    Activity activity;
    public int ranking;
    public String sRanking;
    MainActivity main;


    public MascotasAdapter(ArrayList<Mascotas> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas,parent,false);

        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, int position) {

        final Mascotas mascota = mascotas.get(position);

        holder.foto.setImageResource(mascota.getFoto());
        holder.nombreCard.setText(mascota.getNombre());
        holder.rankingCard.setText(mascota.getRaking());

        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a" + mascota.getNombre(), Toast.LENGTH_SHORT).show();

                ranking = Integer.parseInt(mascota.getRaking());
                ranking ++;

                sRanking = String.valueOf(ranking);
                mascota.setRaking(sRanking);

                Toast.makeText(activity, "Ranking es: " + mascota.getRaking(), Toast.LENGTH_SHORT).show();



            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView foto;
        private TextView nombreCard;
        private TextView rankingCard;
        private ImageButton btnLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            foto = (ImageView) itemView.findViewById(R.id.fotoMascota);
            nombreCard = (TextView) itemView.findViewById(R.id.nombreMascota_cardview);
            rankingCard = (TextView)itemView.findViewById(R.id.ranking_cardview);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }

}