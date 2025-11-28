package example.prueba.mongo.DAO;

import example.prueba.mongo.DAO.DAOGeneros.DAOGenero;
import example.prueba.mongo.DAO.DAOGeneros.DAOGeneroMongo;
import example.prueba.mongo.DAO.DAOVideojuegos.DAOVideojuego;
import example.prueba.mongo.DAO.DAOVideojuegos.DAOVideojuegosMongo;

public class DAOFactory {
    private static final DAOFactory daoFactory = new DAOFactory();
    private DAOGenero daoGenero;
    private DAOVideojuego daoVideojuego;

    private DAOFactory(){}

    public static DAOFactory getInstance() {
        return daoFactory;
    }

    public DAOGenero getDaoGenero(){
        if(daoGenero == null){
            daoGenero= new DAOGeneroMongo();
        }
        return daoGenero;
    }

    public DAOVideojuego getDaoVideojuego(){
        if(daoVideojuego == null){
            daoVideojuego = new DAOVideojuegosMongo();
        }
        return daoVideojuego;
    }
}
