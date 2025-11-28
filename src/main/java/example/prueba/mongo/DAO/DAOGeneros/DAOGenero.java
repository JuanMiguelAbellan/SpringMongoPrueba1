package example.prueba.mongo.DAO.DAOGeneros;

import example.prueba.mongo.entities.Genero;

import java.util.List;

public interface DAOGenero {

    public List<Genero> lista();
    public Genero get(String nombre);
    public String save(Genero genero);
}
