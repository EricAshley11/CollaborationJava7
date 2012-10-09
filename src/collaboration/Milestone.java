package collaboration;

import java.util.Date;

/**
 * This object contains milestone information to be used in projects
 * 
 */
class Milestone {

    String description;
    int number;
    boolean isCompleted;
    Date estimatedCompDate;
    Date completeDate;
    
    public Milestone(int num, String desc) {
        description = desc;
        number = num;
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
    
    public boolean isComplete() {return isCompleted;}
    public void setComplete() {isCompleted = true;}
    
    public boolean isBeforeEstDate() {return completeDate.before(estimatedCompDate);}
    public boolean isAfterEstDate() {return completeDate.after(estimatedCompDate);}
    
    public String getMonth(int month) {
        String mon;
        switch(month) {
            case 0: mon = "January";
                    break;
            case 1: mon = "February";
                    break;
            case 2: mon = "March";
                    break;
            case 3: mon = "April";
                    break;
            case 4: mon = "May";
                    break;
            case 5: mon = "June";
                    break;
            case 6: mon = "July";
                    break;
            case 7: mon = "August";
                    break;
            case 8: mon = "September";
                    break;
            case 9: mon = "October";
                    break;
            case 10: mon = "November";
                    break;
            case 11: mon = "December";
                    break;
            default: mon = "Error";
                    break;
        }
        
        return mon;
    }
    
    public String estDateToString() {
        String date;
        if (estimatedCompDate != null) {
            date = getMonth(estimatedCompDate.getMonth()) + " " +
                   estimatedCompDate.getDate() + " " +
                   estimatedCompDate.getYear();
        } else {
            date = "No Date Set!";
        }
        return date;
    }
    
    public String completeDateToString() {
        String date;
        if (completeDate != null) {
            date = getMonth(completeDate.getMonth()) + " " +
                   completeDate.getDate() + " " +
                   completeDate.getYear();
        } else {
            date = "No completion date!";
        }
        return date;
    }   
}
