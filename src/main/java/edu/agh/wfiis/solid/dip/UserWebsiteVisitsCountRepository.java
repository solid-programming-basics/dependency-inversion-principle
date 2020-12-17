package edu.agh.wfiis.solid.dip;

import java.net.URL;
import java.util.Date;

public interface UserWebsiteVisitsCountRepository {
    OperationResult save(UserWebsiteVisitsCount counts);
    int read(String username, URL url, Date date);
}

class UserWebsiteVisitsCount {
    String username;
    URL url;
    Date date;
    int count;
}

class OperationResult {
    public final String result;
    public final boolean isSuccessful;

    public OperationResult(String result, boolean isSuccessful) {
        this.result = result;
        this.isSuccessful = isSuccessful;
    }
}