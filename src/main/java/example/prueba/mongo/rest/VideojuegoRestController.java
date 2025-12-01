package example.prueba.mongo.rest;

import example.prueba.mongo.DAO.DAOFactory;
import example.prueba.mongo.entities.Videojuego;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VideojuegoRestController {

    @GetMapping("/api/videojuegos")
    public List<Videojuego> lista(){
        return DAOFactory.getInstance().getDaoVideojuego().lista();
    }

    @PostMapping("/api/videojuegos")
    public List<Videojuego> save(@RequestBody Videojuego videojuego){
        DAOFactory.getInstance().getDaoVideojuego().save(videojuego);
        return DAOFactory.getInstance().getDaoVideojuego().lista();
    }
    
}
