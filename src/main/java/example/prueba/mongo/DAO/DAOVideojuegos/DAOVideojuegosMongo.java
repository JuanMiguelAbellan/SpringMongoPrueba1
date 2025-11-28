package example.prueba.mongo.DAO.DAOVideojuegos;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import example.prueba.mongo.context.DBMongoConnection;
import example.prueba.mongo.entities.Genero;
import example.prueba.mongo.entities.Videojuego;
import org.bson.BsonObjectId;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;


public class DAOVideojuegosMongo implements DAOVideojuego {
    @Override
    public String save(Videojuego videojuego) {
        Document document = new Document();
        Document document2 = new Document();
        document.append("nombre", videojuego.getNombre());
        document.append("año", videojuego.getAño());
        document.append("genero", document2.append("nombre", videojuego.getGenero().getNombre()).append("id", videojuego.getGenero().getId()));
        InsertOneResult insertOneResult = DBMongoConnection.getDatabase().getCollection("videojuegos").insertOne(document);
        return  ((BsonObjectId)insertOneResult.getInsertedId()).getValue().toHexString();
    }

    @Override
    public Videojuego get(String nombre) {
        MongoCollection<Document> collection = DBMongoConnection.getDatabase().getCollection("videojuegos");
        Document document = collection.find(eq("nombre", nombre)).first();
        Genero genero = new Genero().setId(document.getString("genero.id")).setNombre("genero.nombre");
        return new Videojuego().setNombre(document.getString("nombre")).setAño(document.getInteger("año")).setGenero(genero);
    }

    @Override
    public List<Videojuego> lista() {
        List<Videojuego> videojuegos = new ArrayList<>();

        MongoCollection<Document> collection = DBMongoConnection.getDatabase().getCollection("videojuegos");
        FindIterable<Document> document = collection.find();
        for (Document d : document){
            Videojuego videojuego = new Videojuego();
            videojuego.setNombre(d.getString("nombre"))
                            .setAño(d.getInteger("año"))
                                    .setGenero(new Genero().setNombre(d.getString("genero.nombre")).setId(d.getString("genero.id")));
            videojuegos.add(videojuego);
        }
        return videojuegos;
    }
}
