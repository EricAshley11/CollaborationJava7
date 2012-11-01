package collaboration;
import com.google.gdata.client.*;
import com.google.gdata.client.calendar.*;
import com.google.gdata.data.*;
import com.google.gdata.data.acl.*;
import com.google.gdata.data.calendar.*;
import com.google.gdata.data.extensions.*;
import com.google.gdata.util.*;
import java.net.*;
import java.text.*;

/**
 *
 * @author vokesm
 */
public class Calendar {
    
    String ownedURL = "https://www.google.com/calendar/feeds/default/owncalendars/full";
    DateFormat googleDF;
    java.util.Date currentDate;
    java.util.Date weekAheadDate;
    java.util.Calendar cal;
    CalendarQuery myQuery;
    long time;
    
    public Calendar() {
        googleDF = new SimpleDateFormat("yyyy-MM-dd'T00:00:00'");
        currentDate = java.util.Calendar.getInstance().getTime();
        cal = java.util.Calendar.getInstance();
        cal.add(java.util.Calendar.DATE, 7);
        time = System.currentTimeMillis() + (86400 * 7 * 1000);
        weekAheadDate = new java.util.Date(time);
    }
    
    public CalendarService validate(String user, String pass) {
        try {
            CalendarService myService = new CalendarService("My Calendar");
            myService.setUserCredentials(user, pass);
            return myService;
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.err.println("Sorry: Could Not Validate Credentials!");
            return null;
        }    
    }
    
     public String printWeeklyAgenda(CalendarService service) {
        String agenda = null;
        CalendarEventFeed result;
        CalendarService myService = service;
        try {
            URL feed = new URL("https://www.google.com/calendar/feeds/default/private/full");
            myQuery = new CalendarQuery(feed);
            myQuery.setMinimumStartTime(DateTime.parseDateTime(googleDF.format(currentDate)));
            myQuery.setMaximumStartTime(DateTime.parseDateTime(googleDF.format(weekAheadDate)));
            result = myService.query(myQuery, CalendarEventFeed.class);
            agenda = "Upcoming events: \n\n";
            for (int i = 0; i< result.getEntries().size(); i++) {
                CalendarEventEntry entry = result.getEntries().get(i);
                agenda += "\t" + entry.getTitle().getPlainText() + "\n";
            }
        } catch (java.io.IOException | ServiceException e) {
            e.printStackTrace();
            System.err.println("Sorry: Could Not Print Schedule!");
        }
        
        return agenda;
    }
    
}

