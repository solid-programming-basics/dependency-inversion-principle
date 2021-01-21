package edu.agh.wfiis.solid.dip;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoConnectionInitializer {
    //    private MongoClient mongoClient;
//    private MongoDatabase database;
    /* this.mongoClient = MongoClients.create(System.getProperty("mongodb.uri"));
        this.database = mongoClient.getDatabase("dipExample"); */
    public static MongoClient getMongoClient(){
        return MongoClients.create(System.getProperty("mongodb.uri"));
    }
}
