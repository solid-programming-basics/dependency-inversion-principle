package edu.agh.wfiis.solid.dip;

import com.mongodb.Mongo;
import com.mongodb.MongoException;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import static com.mongodb.client.model.Filters.*;

public class UserWebsiteVisitsCountMongoDBRepository implements UserWebsiteVisitsCountRepository {
    private MongoCollection<Document> userWebsiteVisitsCountCollection;
    private MongoDatabase db;

    public UserWebsiteVisitsCountMongoDBRepository(MongoDatabase mongoDatabase) {
        this.db = mongoDatabase;
    }

    @Override
    public void save(UserWebsiteVisitsCount counts) throws OperationException {
        Document userWebsiteVisitsCount = new Document()
                .append("username", counts.id.username)
                .append("url", counts.id.url)
                .append("date", counts.id.date)
                .append("count", counts.count);

        try {
            this.userWebsiteVisitsCountCollection = db.getCollection("user_website_visits_count");
            this.userWebsiteVisitsCountCollection.insertOne(userWebsiteVisitsCount);
        } catch(MongoException e) {
            throw new OperationException(e.getMessage());
        }

//        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
//            MongoDatabase db = mongoClient.getDatabase("solid_dependency_inversion");
//            this.userWebsiteVisitsCountCollection = db.getCollection("user_website_visits_count");
//            try {
//                this.userWebsiteVisitsCountCollection.insertOne(userWebsiteVisitsCount);
//            } catch(MongoException e) {
//                throw new OperationException(e.getMessage());
//            }
//        }
    }

    @Override
    public int read(UserWebsiteVisitsId id) throws OperationException {
        try {
            this.userWebsiteVisitsCountCollection = db.getCollection("user_website_visits_count");
            Document foundUserWebsiteVisitsCount = this.userWebsiteVisitsCountCollection.find(and(
                    eq("username", id.username),
                    eq("url", id.url),
                    eq("date", id.date)
            )).first();
            // May produce NullPoinerException!
            return (int) foundUserWebsiteVisitsCount.get("count");
        } catch(MongoException e) {
            throw new OperationException(e.getMessage());
        }
    }
}
