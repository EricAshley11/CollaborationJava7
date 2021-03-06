/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7.common;

import java.io.Serializable;


/**
 *
 */
public class Task implements Serializable{

    
    private long id;
    private double timeEstimate, timeActual;
    
    private User user;
    private String description, name;
    
    private UserStory userStory;
    private Status doneStatus;

    public Task() {
    }
    public Task(String name){
        this.name = name;
        this.doneStatus = new Status();
    }
    public boolean removeUser(User user) {
        if (user.equals(this.user)) {
            this.user = null;
            user.removeTask(this);
            return true;
        }
        return false;
    }

    public boolean changeUser(User user) {
        if (user != null && !user.equals(this.user)) {
            User oldUser = this.user;
            if(this.user != null)
                this.user.removeTask(this);
            this.user = user;
            user.addTask(this);
            return true;//QueryManager.getInstance().updateObjs(new Object[]{this, oldUser, this.user});
        }
        return false;
    }

    public boolean changeUserStory(UserStory userStory) {
        if (userStory != null && !userStory.equals(this.userStory)) {
            UserStory oldUS = this.userStory;
            if(this.userStory != null)
                this.userStory.removeTask(this);
            this.userStory = userStory;
            this.userStory.addTask(this);
            return true;//QueryManager.getInstance().updateObjs(new Object[]{this, oldUS, this.userStory});
        }
        return false;
    }

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return doneStatus;
    }

    public double getTimeActual() {
        return timeActual;
    }

    public double getTimeEstimate() {
        return timeEstimate;
    }

    public User getUser() {
        return user;
    }

    public UserStory getUserStory() {
        return userStory;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(Status state) {
        this.doneStatus = state;
    }

    public void setTimeActual(double timeActual) {
        this.timeActual = timeActual;
    }

    public void setTimeEstimate(double timeEstimate) {
        this.timeEstimate = timeEstimate;
    }
    
    public long getID() {
        return id;
    }
    
    public String toString(){
        try{
            return user.getName()+","+this.userStory.getName()+","+this.getName()+
                ","+this.getStatus()+","+this.timeEstimate+","+this.timeActual;
        }catch(Exception e){
            System.err.println("User: "+user+"\n"+
                            "US: "+userStory+"\n"+
                            "Name :"+name+"\n"+
                            "Status :"+doneStatus+"\n"+
                            "Est: "+timeEstimate+"\n"+
                            "Act: "+timeActual+"\n"                
                    
                    );
            return "invalid task";
        }
    }
    //</editor-fold>
}
