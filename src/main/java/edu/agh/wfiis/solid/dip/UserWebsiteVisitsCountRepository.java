package edu.agh.wfiis.solid.dip;

import java.net.URL;
import java.util.Date;

public interface UserWebsiteVisitsCountRepository {
    void save(UserWebsiteVisitsCount counts) throws OperationException;
    int read(UserWebsiteVisitsId id) throws OperationException;
}

class OperationException extends RuntimeException{
    public OperationException(String message) {
        super(message);
    }
}

class UserWebsiteVisitsId {
    String username;
    URL url;
    Date date;
}

////db.UserWebsiteVisitsCounts.insert({"username":"marcin", "url":"dummy", "count":1})

class UserWebsiteVisitsCount {
    UserWebsiteVisitsId id;
    int count;
}