package example.prueba.mongo.DAO.DAOVideojuegos;

import example.prueba.mongo.entities.Videojuego;

import java.util.List;

public interface DAOVideojuego {
    public String save(Videojuego videojuego);
    public Videojuego get(String nombre);
    public List<Videojuego> lista();
}
