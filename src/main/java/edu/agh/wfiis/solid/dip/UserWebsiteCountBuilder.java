package edu.agh.wfiis.solid.dip;

import java.util.Date;

public class UserWebsiteCountBuilder {

    private String username;
    private String url;
    private Date date;
    private int count;

    public UserWebsiteCountBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserWebsiteCountBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    public UserWebsiteCountBuilder setDate(Date date) {
        this.date = date;
        return this;
    }

    public UserWebsiteCountBuilder setCount(int count) {
        this.count = count;
        return this;
    }

    public UserWebsiteVisitsCount build() {
        UserWebsiteVisitsId visitsId = new UserWebsiteVisitsId();
        visitsId.date = this.date;
        visitsId.url = this.url;
        visitsId.username = this.username;
        UserWebsiteVisitsCount userWebsiteVisitsCount = new UserWebsiteVisitsCount();
        userWebsiteVisitsCount.id = visitsId;
        userWebsiteVisitsCount.count = this.count;
        return userWebsiteVisitsCount;
    }

}
