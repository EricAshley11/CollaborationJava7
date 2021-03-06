package collaborationjava7.common;

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
import java.util.*;

/**
 *
 * @author vokesm
 */
public class Calendar {

    private static final String privateURL = "https://www.google.com/calendar/feeds/default/owncalendars/full";

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
        result = myService.query(myQuery, CalendarEventFeed.class);
        agenda = "Upcoming events: \n\n";
        for (int i = 0; i < result.getEntries().size(); i++) {
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
        URL feed = new URL(privateURL);
        CalendarFeed result = myService.getFeed(feed, CalendarFeed.class);
        for (int i = 0; i < result.getEntries().size(); i++) {
            CalendarEntry entry = result.getEntries().get(i);
            ownedCalendars += "\t" + entry.getTitle().getPlainText() + "\n";
        }
        return ownedCalendars;
    }

    public CalendarService getService() {
        return myService;
    }

    public boolean createNewCalendar(String title, String description, String location) {
        boolean flag = false;
        try {
            CalendarEntry newCal = new CalendarEntry();
            newCal.setTitle(new PlainTextConstruct(title));
            newCal.setSummary(new PlainTextConstruct(description));
            newCal.setTimeZone(new TimeZoneProperty("EST"));
            newCal.setHidden(HiddenProperty.FALSE);
            newCal.setColor(new ColorProperty("#2952A3"));
            newCal.addLocation(new Where("", "", location));

            URL postUrl = new URL(privateURL);
            CalendarEntry newCalendar = myService.insert(postUrl, newCal);
            flag = true;
        } catch (ServiceException | IOException e) {
        }

        return flag;
    }

    public String[][] getUserCalendars()
            throws ServiceException, IOException {

        URL feed = new URL(privateURL);
        CalendarFeed result = myService.getFeed(feed, CalendarFeed.class);
        String[][] calendars = new String[result.getEntries().size()][result.getEntries().size()];
        for (int i = 0; i < result.getEntries().size(); i++) {
            CalendarEntry entry = result.getEntries().get(i);
            calendars[i][0] = entry.getTitle().getPlainText();
        }

        return calendars;
    }

    public String[][] getEntryData(String calendarName)
            throws ServiceException, IOException {
        URL postURL = null;
        URL feed = new URL(privateURL);
        CalendarFeed result = myService.getFeed(feed, CalendarFeed.class);

        for (int i = 0; i < result.getEntries().size(); i++) {
            CalendarEntry calendarEntry = result.getEntries().get(i);
            if (calendarEntry.getTitle().getPlainText().equals(calendarName)) {
                postURL = new URL(calendarEntry.getLink(Link.Rel.ALTERNATE, Link.Type.ATOM).getHref());
            }
        }

        myQuery = new CalendarQuery(postURL);
        myQuery.setMinimumStartTime(DateTime.parseDateTime(googleDF.format(currentDate)));
        CalendarEventFeed entryResult = myService.query(myQuery, CalendarEventFeed.class);
        String[][] entries = new String[entryResult.getEntries().size()][entryResult.getEntries().size()];
        for (int i = 0; i < entryResult.getEntries().size(); i++) {
            CalendarEventEntry entry = entryResult.getEntries().get(i);
            entries[i][0] = entry.getTitle().getPlainText();
        }

        return entries;
    }

    public boolean deleteCalendar(String name)
            throws ServiceException, IOException {
        boolean flag = false;

        URL url = new URL(privateURL);
        CalendarFeed result = myService.getFeed(url, CalendarFeed.class);
        for (int i = 0; i < result.getEntries().size(); i++) {
            CalendarEntry entry = result.getEntries().get(i);
            if (entry.getTitle().getPlainText().equals(name)) {
                entry.delete();
                flag = true;
            }
        }

        return flag;
    }

    public boolean addEntryToCalendar(String calendarName,
            String eventTitle, String eventDescription, String startDate, 
            String endDate, String startTime, String endTime, String location)
            throws ServiceException, IOException {
        boolean flag = true;
        URL postURL = null;
        URL feed = new URL(privateURL);
        CalendarFeed result = myService.getFeed(feed, CalendarFeed.class);

        for (int i = 0; i < result.getEntries().size(); i++) {
            CalendarEntry calendarEntry = result.getEntries().get(i);
            if (calendarEntry.getTitle().getPlainText().equals(calendarName)) {
                postURL = new URL(calendarEntry.getLink(Link.Rel.ALTERNATE, Link.Type.ATOM).getHref());
            }
        }

        CalendarEventEntry myEntry = new CalendarEventEntry();

        String[] temp = user.split("@");
        Person author = new Person(temp[0], null, user);
        myEntry.getAuthors().add(author);
        
        Where location1 = new Where();
        location1.setValueString(location);
        myEntry.addLocation(location1);
        
        temp = startDate.split("/");
        int month = Integer.parseInt(temp[0]);
        int day = Integer.parseInt(temp[1]);
        int year = Integer.parseInt(temp[2]);
        String sDate = year + "-" + month + "-" + day;
        
        SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat parseFormat = new SimpleDateFormat("HH:mm a");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = parseFormat.parse(startTime);
            date2 = parseFormat.parse(endTime);
        } catch (java.text.ParseException e) {
        }
        
        temp = endDate.split("/");
        month = Integer.parseInt(temp[0]);
        day = Integer.parseInt(temp[1]);
        year = Integer.parseInt(temp[2]);
        String eDate = year + "-" + month + "-" + day;


        myEntry.setTitle(new PlainTextConstruct(eventTitle));
        myEntry.setContent(new PlainTextConstruct(eventDescription));
        DateTime start = DateTime.parseDateTime(sDate + "T" + displayFormat.format(date1) + ":00-05:00");
        DateTime end = DateTime.parseDateTime(eDate + "T" + displayFormat.format(date2) + ":00-05:00");
        When eventTimes = new When();
        eventTimes.setStartTime(start);
        eventTimes.setEndTime(end);
        myEntry.addTime(eventTimes);
        
        
        CalendarEventEntry insertedEntry = myService.insert(postURL, myEntry);

        return flag;
    }
    
    public boolean shareCalendar(String calendarName, String user, String addedUser, int access) 
            throws ServiceException, IOException {
        boolean flag = true;

        Link link = new Link();
        AclRole role = new AclRole();
        if (access == 0) {
            role = CalendarAclRole.READ;
        } else if(access == 1) {
            role = CalendarAclRole.EDITOR;
        }
        
        URL postURL = null;
        URL feed = new URL(privateURL);
        CalendarFeed result = myService.getFeed(feed, CalendarFeed.class);

        for (int i = 0; i < result.getEntries().size(); i++) {
            CalendarEntry calendarEntry = result.getEntries().get(i);
            if (calendarEntry.getTitle().getPlainText().equals(calendarName)) {
                link = calendarEntry.getLink(
                        AclNamespace.LINK_REL_ACCESS_CONTROL_LIST, Link.Type.ATOM);  
            }
        }
        
        AclEntry entry = new AclEntry();
        entry.setScope(new AclScope(AclScope.Type.USER, addedUser));
        entry.setRole(role);
        URL aclUrl =  new URL(link.getHref());
        AclEntry insertedEntry = myService.insert(aclUrl, entry);
        
        return flag;
    }

    public boolean deleteEntryFromCalendar(String calendarName, String entryName)
            throws ServiceException, IOException {
        boolean flag = false;
        URL postURL = null;
        URL feed = new URL(privateURL);
        CalendarFeed result = myService.getFeed(feed, CalendarFeed.class);

        for (int i = 0; i < result.getEntries().size(); i++) {
            CalendarEntry calendarEntry = result.getEntries().get(i);
            if (calendarEntry.getTitle().getPlainText().equals(calendarName)) {
                postURL = new URL(calendarEntry.getLink(Link.Rel.ALTERNATE, Link.Type.ATOM).getHref());
            }
        }
        CalendarEventFeed temp = myService.getFeed(postURL, CalendarEventFeed.class);
        for (int i = 0; i < temp.getEntries().size(); i++) {
            CalendarEventEntry entry = temp.getEntries().get(i);
            if (entry.getTitle().getPlainText().equals(entryName)) {
                entry.delete();
                flag = true;
            }
        }
        return flag;
    }
    
    public String[] displayEntryInfo(String calendarName, String entryName)
            throws ServiceException, IOException {
        String[] resultInfo = new String[7];
        
        URL postURL = null;
        URL feed = new URL(privateURL);
        CalendarFeed result = myService.getFeed(feed, CalendarFeed.class);

        for (int i = 0; i < result.getEntries().size(); i++) {
            CalendarEntry calendarEntry = result.getEntries().get(i);
            if (calendarEntry.getTitle().getPlainText().equals(calendarName)) {
                postURL = new URL(calendarEntry.getLink(Link.Rel.ALTERNATE, Link.Type.ATOM).getHref());
            }
        }
        
        CalendarEventFeed temp = myService.getFeed(postURL, CalendarEventFeed.class);
        for (int i = 0; i < temp.getEntries().size(); i++) {
            CalendarEventEntry entry = temp.getEntries().get(i);
            if (entry.getTitle().getPlainText().equals(entryName)) {
                resultInfo[0] = entry.getTitle().getPlainText();
                resultInfo[1] = entry.getTextContent().getContent().getPlainText();
                List<Where> location = entry.getLocations();
                resultInfo[2] = location.get(0).getValueString();
                List<When> times = entry.getTimes();
                String[] startDates = times.get(0).getStartTime().toString().split("-");
                String sDate = startDates[1] + "/" + startDates[2].substring(0, 2) + "/" + startDates[0];
                String[] endDates = times.get(0).getEndTime().toString().split("-");
                String eDate = endDates[1] + "/" + endDates[2].substring(0, 2) + "/" + endDates[0];
                

                String startTime = startDates[2].substring(3, 8);
                String endTime = endDates[2].substring(3, 8);

                SimpleDateFormat parseFormat = new SimpleDateFormat("HH:mm");
                SimpleDateFormat displayFormat = new SimpleDateFormat("hh:mm a");
                Date date1 = null;
                Date date2 = null;
                try {
                    date1 = parseFormat.parse(startTime);
                    date2 = parseFormat.parse(endTime);
                } catch (java.text.ParseException e) {
                }
                
                resultInfo[3] = sDate;
                resultInfo[4] = displayFormat.format(date1);
                resultInfo[5] = displayFormat.format(date2);
                resultInfo[6] = eDate ;
            }
        }
        if (resultInfo.equals("")) {
             //error occurred
        }
        
        return resultInfo;
    }
    
    public String getUser() {
        return user;
    }
}
