package edu.agh.wfiis.solid.dip;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

public class UserWebsiteVisitsCountMongoDBRepository implements UserWebsiteVisitsCountRepository{

    public UserWebsiteVisitsCountMongoDBRepository() {
    }

    @Override
    public void save(UserWebsiteVisitsCount counts) throws OperationException {

    }

    @Override
    public int read(UserWebsiteVisitsId id) throws OperationException {
        return 0;
    }
}
