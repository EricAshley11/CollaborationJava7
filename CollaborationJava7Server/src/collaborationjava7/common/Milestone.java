package collaborationjava7.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


/**
 * This object contains milestone information to be used in projects
 */

public class Milestone implements Serializable{

    
    private long id;
    
    private ArrayList<UserStory> userStories;
    
    String name;
    String description;
    boolean isCompleted;
    
    
    Date startDate;
    
    
    Date endDate;

    public Milestone() {
    }

    public Milestone(String name) {
        this.name = name;
        userStories = new ArrayList<UserStory>();
        isCompleted = false;
        startDate = null;
        endDate = null;
    }

    public void setStartDate(Date date) {
        startDate = date;
    }

    public void setEndDate(Date date) {
        endDate = date;
    }

    public boolean isComplete() {
        return isCompleted;
    }

    public boolean setComplete() {
        isCompleted = true;
        return isCompleted;
    }

    public boolean isOnTime() {
        return (!endDate.after(startDate));
    }

    public String startDateToString() {
        return dateToString(startDate);
    }

    public String endDateToString() {
        return dateToString(endDate);
    }
    
    public static Date getDateFromString(String str){
        Date date = null;
        try{
            String[] strings = str.split("/");
            int month = Integer.parseInt(strings[0]);
            int day = Integer.parseInt(strings[1]);
            int year = Integer.parseInt(strings[2]);
            date = Calendar.getInstance().getTime();
            date.setMonth(month-1);
            date.setDate(day);
            date.setYear(year);
        }catch(Exception e){
            
        }
        return date;
    }
    private String dateToString(Date date){
        String retVal;
        if (date != null) {
            int month = date.getMonth()+1;
            int day = date.getDate();
            int year = date.getYear(); 
            String m = Integer.toString(month);
            String d = Integer.toString(day);
            String y = Integer.toString(year);
            if(month < 10){
                m = "0"+m;
            }
            if(day < 10){
                d = "0"+d;
            }
            retVal =  m+ "/"
                    + d+ "/"
                    + y;
        } else {
            retVal = "No Date Set!";
        }
        return retVal;
    }

    public String getMonth(int month) {
        String mon;
        switch (month) {
            case 0:
                mon = "January";
                break;
            case 1:
                mon = "February";
                break;
            case 2:
                mon = "March";
                break;
            case 3:
                mon = "April";
                break;
            case 4:
                mon = "May";
                break;
            case 5:
                mon = "June";
                break;
            case 6:
                mon = "July";
                break;
            case 7:
                mon = "August";
                break;
            case 8:
                mon = "September";
                break;
            case 9:
                mon = "October";
                break;
            case 10:
                mon = "November";
                break;
            case 11:
                mon = "December";
                break;
            default:
                mon = "Error";
                break;
        }

        return mon;
    }

    public ArrayList<UserStory> getUserStories(){
        return userStories;
    }
    public boolean addUserStory(UserStory us){
        if(userStories.add(us)){
            return true;//QueryManager.getInstance().updateObj(this);
        }
        return false;
    }
    public boolean remUserStory(UserStory us){
        if(userStories.remove(us)){
            return true;//QueryManager.getInstance().updateObjs(new Object[]{this,us});
        }
        return false;
    }
    
    public long getID() {
        return id;
    }
    public String getName(){
        return name;
    }
}
