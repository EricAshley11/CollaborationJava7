/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7.common;

import java.util.Collection;
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
    @OneToMany
    private Collection<Task> tasks;
    private Project project;
    private State state;
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
            return true;
        }
        return false;
    }

    public boolean addTask(Task task) {
        if (tasks.contains(task)) {
            tasks.add(task);
            task.changeUserStory(this);
            return true;
        }
        return false;
    }

    public boolean removeProject(Project project) {
        if (project != null && project.equals(this.project)) {
            this.project = null;
            project.removeUserStory(this);
            return true;
        }
        return false;
    }
    
    public boolean changeProject(Project project) {
        if (project != null && project.equals(this.project)) {
            this.project.removeUserStory(this);
           // this.project = project; TODO:Fix this somehow
            project.addUserStory(this);
            return true;
        }
        return false;
    }
    public long getID() {
        return id;
    }
}
