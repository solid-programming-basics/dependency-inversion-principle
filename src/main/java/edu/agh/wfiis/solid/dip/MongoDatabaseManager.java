package edu.agh.wfiis.solid.dip;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDatabaseManager {
    private MongoClient mongoClient;

    MongoDatabaseManager() {}

    public void initDatabase(String dbURI) {
        this.mongoClient = MongoClients.create(dbURI);
    }

    public MongoDatabase getDatabase(String dbName) {
        return mongoClient.getDatabase(dbName);
    }

}
