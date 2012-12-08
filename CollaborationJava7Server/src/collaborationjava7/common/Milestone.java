package collaborationjava7.common;

import java.io.Serializable;
import java.util.ArrayList;
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
    
    
    Date estimatedCompDate;
    
    
    Date completeDate;

    public Milestone() {
    }

    public Milestone(String name) {
        this.name = name;
        userStories = new ArrayList<>();
        isCompleted = false;
        estimatedCompDate = null;
        completeDate = null;
    }

    public void setEstDate(int month, int day, int year) {
        estimatedCompDate = new Date(year, month, day);
    }

    public void setCompDate(int month, int day, int year) {
        completeDate = new Date(year, month, day);
    }

    public boolean isComplete() {
        return isCompleted;
    }

    public boolean setComplete() {
        isCompleted = true;
        return isCompleted;
    }

    public boolean isOnTime() {
        return (!completeDate.after(estimatedCompDate));
    }

    public String estDateToString() {
        String date;
        if (estimatedCompDate != null) {
            date = getMonth(estimatedCompDate.getMonth()) + " "
                    + estimatedCompDate.getDate() + " "
                    + estimatedCompDate.getYear();
        } else {
            date = "No Date Set!";
        }
        return date;
    }

    public String completeDateToString() {
        String date;
        if (completeDate != null) {
            date = getMonth(completeDate.getMonth()) + " "
                    + completeDate.getDate() + " "
                    + completeDate.getYear();
        } else {
            date = "No completion date!";
        }
        return date;
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
}
