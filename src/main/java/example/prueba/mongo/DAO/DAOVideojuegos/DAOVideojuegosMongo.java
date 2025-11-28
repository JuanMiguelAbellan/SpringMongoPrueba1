package example.prueba.mongo.DAO.DAOVideojuegos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import example.prueba.mongo.context.DBMongoConnection;
import example.prueba.mongo.entities.Genero;
import example.prueba.mongo.entities.Videojuego;
import org.bson.BsonObjectId;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;


public class DAOVideojuegosMongo implements DAOVideojuego {
    @Override
    public String save(Videojuego videojuego) {
        Document document = new Document();
        document.append("nombre", videojuego.getNombre());
        InsertOneResult insertOneResult = DBMongoConnection.getDatabase().getCollection("videojuegos").insertOne(document);
        return  ((BsonObjectId)insertOneResult.getInsertedId()).getValue().toHexString();
    }

    @Override
    public Videojuego get(String nombre) {
        MongoCollection<Document> collection = DBMongoConnection.getDatabase().getCollection("entrenadores");
        Document document = collection.find(eq("nombre", nombre)).first();
        Genero genero = new Genero().setId(document.getString("genero.nombre")).setNombre("nombreGenero");
        return new Videojuego().setNombre(document.getString("nombre")).setAño(document.getInteger("año")).setGenero(genero);
    }
}
