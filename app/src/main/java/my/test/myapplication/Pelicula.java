package my.test.myapplication;

/**
 * Created by miguel on 2/10/16.
 */

public class Pelicula {

    public Pelicula() {
        nombre = null;
        duracion=0;
        puntuacion=0;
        sinopsis=null;
        genero=null;
        censura=0;
        director=null;
        reparto = null;
        formato = 2;


    }

    public Pelicula(String nombre, int puntuacion,int censura,int duracion, String director, String genero, String reparto, String sinopsis, int formato) {
        this.nombre = nombre;
        this.puntuacion = puntuacion;
        this.director = director;
        this.duracion = duracion;
        this.censura = censura;
        this.genero = genero;
        this.sinopsis = sinopsis;
        this.reparto = reparto;
        this.formato = formato;
    }

    private String nombre;
    private int duracion;
    private int puntuacion;
    private String sinopsis;
    private String genero;
    private int censura;
    private int formato;
    private String director;
    private String reparto;

    //getters
    public String getNombre() {
        return nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public String getGenero() {
        return genero;
    }

    public int getCensura() {
        return censura;
    }

    public String getDirector() {
        return director;
    }

    public String getReparto() {
        return reparto;
    }

    public int getFormato() {
        return formato;
    }

    //setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setCensura(int censura) {
        this.censura = censura;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setReparto(String reparto) {
        this.reparto = reparto;
    }

    public void setFormato(int formato) {
        this.formato = formato;
    }
}
