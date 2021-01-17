package edu.agh.wfiis.solid.dip;

import com.mongodb.client.MongoDatabase;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        MongoDatabaseManager mongoDatabaseManager = new MongoDatabaseManager();
        mongoDatabaseManager.initDatabase("mongodb://localhost:27017");
        MongoDatabase db = mongoDatabaseManager.getDatabase("solid_dependency_inversion");

        UserWebsiteCountBuilder userWebsiteCountBuilder = new UserWebsiteCountBuilder();
        UserWebsiteVisitsCount userWebsiteVisitsCount = userWebsiteCountBuilder
                .setUsername("Andrzej")
                .setUrl("http://google.com")
                .setDate(new Date())
                .setCount(5)
                .build();

        UserWebsiteVisitsCountMongoDBRepository mongoRepo = new UserWebsiteVisitsCountMongoDBRepository(db);
        mongoRepo.save(userWebsiteVisitsCount);

        int count = mongoRepo.read(userWebsiteVisitsCount.id);
        System.out.println(count);
    }

}
