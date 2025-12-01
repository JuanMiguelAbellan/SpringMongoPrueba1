package example.prueba.mongo.rest;

import example.prueba.mongo.entities.Genero;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class GeneroRestController {

    @GetMapping("/api/generos")
    public List<Genero>
}
