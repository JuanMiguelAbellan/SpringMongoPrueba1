package example.prueba.mongo.entities;

public class Genero {
    private String id;
    private String nombre;

    public Genero() {
    }

    public String getId() {
        return id;
    }

    public Genero setId(String id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Genero setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
}
