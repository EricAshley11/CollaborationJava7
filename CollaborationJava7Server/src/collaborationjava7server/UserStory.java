/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;

import collaborationjava7.common.*;
import java.util.Collection;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.persistence.*;

/**
 *
 */
@Entity(name = "UserStory")
public class UserStory implements Serializable, IUserStory {

    @Id
    private int UserStoryID;
    @OneToMany
    private Collection<ITask> tasks;
    private Project project;
    private State state;

    public UserStory() {
        tasks = new ArrayList<ITask>();
    }

    @Override
    public boolean removeTask(ITask task) throws RemoteException{
        if (tasks.remove(task)) {
            task.delete();//TODO: Not sure if this is the best way to do this
            return true;
        }
        return false;
    }

    @Override
    public boolean addTask(ITask task) throws RemoteException{
        if (tasks.contains(task)) {
            tasks.add(task);
            task.changeUserStory(this);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeProject(IProject project) throws RemoteException{
        if (project != null && project.equals(this.project)) {
            this.project = null;
            project.removeUserStory(this);
            return true;
        }
        return false;
    }

    @Override
    public boolean changeProject(IProject project) throws RemoteException{
        if (project != null && project.equals(this.project)) {
            this.project.removeUserStory(this);
           // this.project = project; TODO:Fix this somehow
            project.addUserStory(this);
            return true;
        }
        return false;
    }
}
