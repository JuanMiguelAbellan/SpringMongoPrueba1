package example.prueba.mongo.entities;

public class Videojuego {
    private String nombre;
    private int año;
    private Genero genero;

    public Videojuego() {
    }

    public String getNombre() {
        return nombre;
    }

    public Videojuego setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public int getAño() {
        return año;
    }

    public Videojuego setAño(int año) {
        this.año = año;
        return this;
    }

    public Genero getGenero() {
        return genero;
    }

    public Videojuego setGenero(Genero genero) {
        this.genero = genero;
        return this;
    }
}
