/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaboration;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 */
@Entity(name = "Task") //Entity name
public class Task implements Serializable {

    @Id
    private int TaskID;
    private int storyPointsEstimate, storyPointsActual;
    @OneToOne
    private User user;
    private String description, name;
    @OneToOne
    private UserStory userStory;
    private State state;

    public Task() {
    }

    boolean removeUser(User user) {
        if (user.equals(this.user)) {
            this.user = null;
            user.removeTask(this);
            return true;
        }
        return false;
    }

    boolean changeUser(User user) {
        if (user != null && !user.equals(this.user)) {
            this.user.removeTask(this);
            this.user = user;
            user.addTask(this);
            return true;
        }
        return false;
    }

    boolean changeUserStory(UserStory userStory) {
        if (userStory != null && !userStory.equals(this.userStory)) {
            this.userStory.removeTask(this);
            this.userStory = userStory;
            userStory.addTask(this);
            return true;
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

    public State getState() {
        return state;
    }

    public int getStoryPointsActual() {
        return storyPointsActual;
    }

    public int getStoryPointsEstimate() {
        return storyPointsEstimate;
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

    public void setState(State state) {
        this.state = state;
    }

    public void setStoryPointsActual(int storyPointsActual) {
        this.storyPointsActual = storyPointsActual;
    }

    public void setStoryPointsEstimate(int storyPointsEstimate) {
        this.storyPointsEstimate = storyPointsEstimate;
    }
    //</editor-fold>

    void delete() {
        //TODO: Not sure if this is the best way to do this
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
