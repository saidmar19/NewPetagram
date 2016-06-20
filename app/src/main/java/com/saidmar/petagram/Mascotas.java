package com.saidmar.petagram;

/**
 * Created by saidmar on 20/6/2016.
 */
public class Mascotas {

    private String nombre;
    private String raking;
    private int foto;

    //constructor para instancear
    public Mascotas(int foto, String nombre, String raking) {
        this.foto = foto;
        this.nombre = nombre;
        this.raking = raking;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getRaking() {
        return raking;
    }

    public void setRaking(String raking) {
        this.raking = raking;
    }
}
