/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;

import collaborationjava7.common.*;
import java.io.Serializable;
import java.rmi.RemoteException;
import javax.persistence.*;

/**
 *
 */
@Entity(name = "Task") //Entity name
public class Task implements Serializable, ITask {

    @Id
    private int TaskID;
    private int storyPointsEstimate, storyPointsActual;
    @OneToOne
    private IUser user;
    private String description, name;
    @OneToOne
    private IUserStory userStory;
    private State state;

    public Task() {
    }

    @Override
    public boolean removeUser(IUser user) throws RemoteException{
        if (user.equals(this.user)) {
            this.user = null;
            user.removeTask(this);
            return true;
        }
        return false;
    }

    @Override
    public boolean changeUser(IUser user) throws RemoteException{
        if (user != null && !user.equals(this.user)) {
            this.user.removeTask(this);
            this.user = user;
            user.addTask(this);
            return true;
        }
        return false;
    }

    @Override
    public boolean changeUserStory(IUserStory userStory) throws RemoteException{
        if (userStory != null && !userStory.equals(this.userStory)) {
            this.userStory.removeTask(this);
            this.userStory = userStory;
            userStory.addTask(this);
            return true;
        }
        return false;
    }

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return name;
    }

    public State getState() {
        return state;
    }

    @Override
    public int getStoryPointsActual() {
        return storyPointsActual;
    }

    @Override
    public int getStoryPointsEstimate() {
        return storyPointsEstimate;
    }

    @Override
    public IUser getUser() {
        return user;
    }

    @Override
    public IUserStory getUserStory() {
        return userStory;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public void setStoryPointsActual(int storyPointsActual) {
        this.storyPointsActual = storyPointsActual;
    }

    @Override
    public void setStoryPointsEstimate(int storyPointsEstimate) {
        this.storyPointsEstimate = storyPointsEstimate;
    }
    //</editor-fold>

    @Override
    public void delete() {
        //TODO: Not sure if this is the best way to do this
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
