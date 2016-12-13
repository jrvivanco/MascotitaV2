package org.jrvivanco.mascotitav2;

/**
 * Created by ernesto on 10/12/16.
 */

public class Mascota {
    private String nombre;
    private int foto;
    private int rating;

    public Mascota() {
    }

    public Mascota(String nombre, int foto) {
        this.nombre = nombre;
        this.foto = foto;
        this.rating = 0;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
