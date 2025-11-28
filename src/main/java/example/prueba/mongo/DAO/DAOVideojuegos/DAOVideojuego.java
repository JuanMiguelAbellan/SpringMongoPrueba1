package example.prueba.mongo.DAO.DAOVideojuegos;

import example.prueba.mongo.entities.Videojuego;

public interface DAOVideojuego {
    public String save(Videojuego videojuego);
    public Videojuego get(String nombre);
}
