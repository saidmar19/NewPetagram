package com.saidmar.petagram.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.saidmar.petagram.Dandy;
import com.saidmar.petagram.R;

import java.util.ArrayList;

/**
 * Created by saidmar on 7/7/2016.
 */
public class DandyAdapter extends RecyclerView.Adapter<DandyAdapter.DandyViewHolder> {

    ArrayList<Dandy> dandys;
    Activity activity;

    public DandyAdapter(ArrayList<Dandy> dandy,Activity activity) {

        this.dandys=dandy;
        this.activity=activity;

    }

    @Override
    public DandyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_dandy, parent, false);

        return new DandyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DandyViewHolder holder, int position) {

        final Dandy dandy = dandys.get(position);
        holder.fotoDandy.setImageResource(dandy.getFoto());
        holder.rankDandy.setText(dandy.getRank());


    }

    @Override
    public int getItemCount() {
        return dandys.size();
    }


    public static class DandyViewHolder extends RecyclerView.ViewHolder{

        private ImageView fotoDandy;
        private TextView rankDandy;

        public DandyViewHolder(View itemView) {
            super(itemView);

            fotoDandy = (ImageView)itemView.findViewById(R.id.fotoDandy);
            rankDandy = (TextView)itemView.findViewById(R.id.ranking_cardviewDandy);
        }
    }
}
