package edu.agh.wfiis.solid.dip;
import java.util.Date;

public interface UserWebsiteVisitsCountRepository {

    int read(String username, Date visitDate);

    void save(String username, Date visitDate, int visitsCount);

}
