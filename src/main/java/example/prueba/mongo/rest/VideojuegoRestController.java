package example.prueba.mongo.rest;

import example.prueba.mongo.entities.Videojuego;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VideojuegoRestController {

    private VideojuegoUsesCases videojuegoUsesCases;

    @GetMapping("/api/videojuegos")
    public List<Videojuego> lista(){

    }
}
