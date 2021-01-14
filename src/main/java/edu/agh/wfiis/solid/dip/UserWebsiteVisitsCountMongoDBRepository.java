package edu.agh.wfiis.solid.dip;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCollection;
import com.mongodb.MongoDatabase;
import com.mongodb.MongoException;

import org.bson.Document;
import static com.mongodb.client.model.Filters.*;


public class UserWebsiteVisitsCountMongoDBRepository implements UserWebsiteVisitsCountRepository {
    private MongoCollection<Document> userWebsiteVisitsCountCollection;

    public UserWebsiteVisitsCountMongoDBRepository() {
        try (MongoClient mongoClient = MongoClients.create(System.getProperty("mongodb.uri"))) {

            MongoDatabase db = mongoClient.getDatabase("solid_dependency_inversion");
            this.userWebsiteVisitsCountCollection = db.getCollection("user_website_visits_count");
        }
    }

    @Override
    public void save(UserWebsiteVisitsCount counts) throws OperationException {
        var userWebsiteVisitsCount = new Document()
            .append("username", counts.id.username)
            .append("url", counts.id.url)
            .append("date", counts.id.date)
            .append("count", counts.count);

        try {
            this.userWebsiteVisitsCountCollection.insertOne(userWebsiteVisitsCount);
        } catch(MongoException e) {
            throw new OperationException(e.getMessage());
        }
    }

    @Override
    public int read(UserWebsiteVisitsId id) throws OperationException {
        try {
            Document foundUserWebsiteVisitsCount = this.userWebsiteVisitsCountCollection.find(and(
                eq("username", id.username), 
                eq("url", id.url), 
                eq("date", id.date)
            )).first();

            return (int) foundUserWebsiteVisitsCount.get("count");
        } catch(MongoException e) {
            throw new OperationException(e.getMessage());
        }
    }
}
