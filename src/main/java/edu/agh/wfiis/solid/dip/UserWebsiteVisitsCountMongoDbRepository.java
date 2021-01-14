package edu.agh.wfiis.solid.dip;

import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Date;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class UserWebsiteVisitsCountMongoDbRepository implements UserWebsiteVisitsCountRepository{

    @Override
    public int read(String username, Date visitDate) {
        try (MongoClient mongoClient = MongoClients.create(System.getProperty("mongodb.uri"))) {
            MongoDatabase database = mongoClient.getDatabase("dipExample");
            MongoCollection<Document> userWebsiteVisitsCounts = database.getCollection("userWebsiteVisitsCounts");
            FindIterable<Document> documents = userWebsiteVisitsCounts.find(and(eq("username", username), eq("username", username)));
            Document first = documents.first();
            return (int) first.get("visitsCount");
        }
    }

    @Override
    public void save(String username, Date visitDate, int visitsCount) {
        try (MongoClient mongoClient = MongoClients.create(System.getProperty("mongodb.uri"))) {
            MongoDatabase database = mongoClient.getDatabase("dipExample");
            MongoCollection<Document> userWebsiteVisitsCounts = database.getCollection("userWebsiteVisitsCounts");
            Document userWebsiteVisitsCount = new Document("_id", new ObjectId());
            userWebsiteVisitsCount.append("username", username)
                    .append("visitDate", visitDate)
                    .append("visitsCount", visitsCount);
            userWebsiteVisitsCounts.insertOne(userWebsiteVisitsCount);
        }
    }

}
