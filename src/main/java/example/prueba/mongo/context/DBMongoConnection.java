package example.prueba.mongo.context;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class DBMongoConnection {

    private static DBMongoConnection mongoConnection;
    private final MongoClient mongoClient;
    private final MongoDatabase database;

    private DBMongoConnection(){
        this.mongoClient = MongoClients.create("mongodb+srv://240023_db_user:Qzmpwxno1029.@cluster1.0thd0jq.mongodb.net");
        this.database = mongoClient.getDatabase("videojuegos");
    }

    public static MongoDatabase getDatabase() {
        if(mongoConnection == null){
            mongoConnection = new DBMongoConnection();
        }
        return mongoConnection.database;
    }
}
