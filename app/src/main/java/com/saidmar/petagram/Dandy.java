package com.saidmar.petagram;

/**
 * Created by saidmar on 7/7/2016.
 */
public class Dandy {

    private String rank;
    private int foto;

    public Dandy(int foto, String rank) {
        this.foto = foto;
        this.rank = rank;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
