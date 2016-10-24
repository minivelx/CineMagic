package my.test.myapplication;

/**
 * Created by miguel on 23/10/16.
 */

public class Reserva {
    private String titulo;
    private String hora;

    public Reserva(String titulo, String hora) {
        this.titulo = titulo;
        this.hora = hora;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getHora() {
        return hora;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
