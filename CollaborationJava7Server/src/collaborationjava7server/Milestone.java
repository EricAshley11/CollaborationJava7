package collaborationjava7server;

import java.util.Date;

/**
 * This object contains milestone information to be used in projects
 */
class Milestone {

    int id;
    String description;
    boolean isCompleted;
    Date estimatedCompDate;
    Date completeDate;

    public Milestone(String desc, int id) {
        description = desc;
        isCompleted = false;
        estimatedCompDate = null;
        completeDate = null;
        this.id = id;
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

    public int getID() {
        return id;
    }
}
