package edu.agh.wfiis.solid.dip;

import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Date;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class UserWebsiteVisitsCountMongoDbRepository implements UserWebsiteVisitsCountRepository{
    private static final String USERNAME_FIELD = "username";
    private static final String VISITS_COUNT_FIELD = "visitsCount";
    private static final String VISITS_DATE_FIELD = "visitDate";
    private static final String ID_FIELD = "_id";
    private static final String COLLECTION_NAME = "userWebsiteVisitsCounts";

    private final MongoCollection<Document> userWebsiteVisitsCounts;
            
    public UserWebsiteVisitsCountMongoDbRepository(MongoDatabase database) {
        this.userWebsiteVisitsCounts = database.getCollection(COLLECTION_NAME);
    }

    @Override
    public int read(String username, Date visitDate) {
        FindIterable<Document> documents = userWebsiteVisitsCounts.
                find(and(eq(USERNAME_FIELD, username), eq(USERNAME_FIELD, username)));
        Document first = documents.first();
        return (int) first.get(VISITS_COUNT_FIELD);
    }

    @Override
    public void save(String username, Date visitDate, int visitsCount) {
        Document userWebsiteVisitsCount = new Document(ID_FIELD, new ObjectId());
        userWebsiteVisitsCount.append(USERNAME_FIELD, username)
                .append(VISITS_DATE_FIELD, visitDate)
                .append(VISITS_COUNT_FIELD, visitsCount);
        userWebsiteVisitsCounts.insertOne(userWebsiteVisitsCount);
    }

}
