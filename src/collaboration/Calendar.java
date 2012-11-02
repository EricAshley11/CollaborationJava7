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
import java.io.*;

/**
 *
 * @author vokesm
 */
public class Calendar {
    
    private static final String privateURL = "https://www.google.com/calendar/feeds/default/owncalendars/full";
    //private static final String baseFeed_URL = "https://www.google.com/calendar/feeds/";
    //private static final String eventFeed_URL = "/private/full";
    //private static final String calendarFeed_URL = "/owncalendars/full";
    String user = "";
    DateFormat googleDF;
    java.util.Date currentDate;
    java.util.Date weekAheadDate;
    java.util.Calendar cal;
    CalendarQuery myQuery;
    CalendarService myService;
    long time;
    
    public Calendar() {
        googleDF = new SimpleDateFormat("yyyy-MM-dd'T00:00:00'");
        currentDate = java.util.Calendar.getInstance().getTime();
        cal = java.util.Calendar.getInstance();
        cal.add(java.util.Calendar.DATE, 7);
        time = System.currentTimeMillis() + (86400 * 7 * 1000);
        weekAheadDate = new java.util.Date(time);
    }
    
    public boolean validate(String user, String pass) {
        boolean flag = false;
        try {
            myService = new CalendarService("My Calendar");
            myService.setUserCredentials(user, pass);
            this.user = user;
            flag = true;
            return flag;
        } catch (AuthenticationException e) {
            return flag;
        }    
    }
    
     public String printWeeklyAgenda()
            throws ServiceException, IOException {
        String agenda;
        CalendarEventFeed result;

        URL feed = new URL("https://www.google.com/calendar/feeds/default/private/full");
        myQuery = new CalendarQuery(feed);
        myQuery.setMinimumStartTime(DateTime.parseDateTime(googleDF.format(currentDate)));
        myQuery.setMaximumStartTime(DateTime.parseDateTime(googleDF.format(weekAheadDate)));
        result = myService.query(myQuery, CalendarEventFeed.class); //Bringing up exception
        agenda = "Upcoming events: \n\n";
        for (int i = 0; i< result.getEntries().size(); i++) {
            CalendarEventEntry entry = result.getEntries().get(i);
            agenda += "\t" + entry.getTitle().getPlainText() + "\n";
        }   
        return agenda;
    }
    
    public boolean LoginSuccess(CalendarService service) {
        boolean flag = false;
        if (service != null) {
            flag = true;
        }
        return flag;
    }
    
    public String printUserCalendars() 
           throws ServiceException, IOException {

        String ownedCalendars = "Your Calendars:\n\n";
        URL feed = new URL("https://www.google.com/calendar/feeds/default/owncalendars/full");
        CalendarFeed result = myService.getFeed(feed, CalendarFeed.class); //Bringing up exception
        for (int i = 0; i < result.getEntries().size(); i++) {
            CalendarEntry entry = result.getEntries().get(i);
            ownedCalendars += "\t" + entry.getTitle().getPlainText() + "\n";
        }
        return ownedCalendars;
    }
    
    public CalendarService getService() {
        return myService;
    }
}

