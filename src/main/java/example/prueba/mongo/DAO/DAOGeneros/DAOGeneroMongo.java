package example.prueba.mongo.DAO.DAOGeneros;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import example.prueba.mongo.context.DBMongoConnection;
import example.prueba.mongo.entities.Genero;
import example.prueba.mongo.entities.Videojuego;
import org.bson.BsonObjectId;
import org.bson.Document;

import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class DAOGeneroMongo implements DAOGenero{
    @Override
    public List<Genero> lista() {
        return List.of();
    }

    @Override
    public Genero get(String nombre) {
        MongoCollection<Document> collection = DBMongoConnection.getDatabase().getCollection("generos");
        Document document = collection.find(eq("nombre", nombre)).first();

        return new Genero().setId(document.getString("id")).setNombre(document.getString("nombre"));
    }

    @Override
    public String save(Genero genero) {
        Document document = new Document();
        document.append("id", genero.getId());
        document.append("nombre", genero.getNombre());
        InsertOneResult insertOneResult = DBMongoConnection.getDatabase().getCollection("generos").insertOne(document);
        return  ((BsonObjectId)insertOneResult.getInsertedId()).getValue().toHexString();
    }
}
