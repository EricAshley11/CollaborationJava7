/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7.common;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.*;

/**
 *
 */
@Entity(name = "UserStory")
public class UserStory implements Serializable {

    @Id @GeneratedValue
    private long id;
    @OneToMany(cascade=CascadeType.ALL, mappedBy="userStory")
    private ArrayList<Task> tasks;
    @ManyToOne
    private Milestone milestone;
    private Status state;
    private String name;

    public UserStory() {
        tasks = new ArrayList<Task>();
    }
    
    public UserStory(String name) {
        tasks = new ArrayList<Task>();
        this.name = name;
    }

    public boolean removeTask(Task task) {
        if (tasks.remove(task)) {
            //task.delete();//TODO: Not sure if this is the best way to do this
            //QueryManager.getInstance().updateObj(this);
            return true;
        }
        return false;
    }

    public boolean addTask(Task task) {
        if (!tasks.contains(task)) {
            tasks.add(task);
            task.changeUserStory(this);
            //QueryManager.getInstance().updateObj(this);
            return true;
        }
        return false;
    }

    public boolean removeMilestone(Milestone milestone) {
        if (milestone != null && milestone.equals(this.milestone)) {
            Milestone oldMilestone = this.milestone;
            this.milestone = null;
            return true;// QueryManager.getInstance().updateObjs(new Object[]{milestone, this, oldMilestone});
        }
        return false;
    }
    
    public boolean changeMilestone(Milestone milestone) {
        if (milestone != null && !milestone.equals(this.milestone)) {
            this.milestone.remUserStory(this);
            Milestone oldMilestone = this.milestone;
            this.milestone = milestone;
            milestone.addUserStory(this);
            return true;//QueryManager.getInstance().updateObjs(new Object[]{this, oldMilestone, milestone});
        }
        return false;
    }
    public long getID() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String toString(){
        return this.getName();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}
