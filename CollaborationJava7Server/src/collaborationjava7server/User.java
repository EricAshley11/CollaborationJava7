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
@Entity(name = "User") //entity name
public class User implements Serializable, IUser {

    @Id //primary key
    @Column(nullable = false)
    private int UserID;
    
    private static int nextUID = 0;
    private String name, email;
    private String phoneNum;
    @OneToMany
    private Collection<ITeam> teams;
    @OneToMany
    private Collection<ITask> tasks;

    public User() {}
    
    public User(String name) {
        this.name = name;
        teams = new ArrayList<ITeam>();
        tasks = new ArrayList<ITask>();
        UserID = nextUID++;
    }

    public boolean addToTeam(ITeam team) throws RemoteException{
        if (!teams.contains(team)) {
            teams.add(team);
            team.addMember(this);
            return true;
        }
        return false;
    }

    @Override
    public void delete() throws RemoteException{
        for (ITeam team : teams) {
            this.removeFromTeam(team);
        }
        for (ITask task : tasks) {
            this.removeTask(task);
        }
    }

    @Override
    public boolean removeFromTeam(ITeam team) throws RemoteException{
        if (teams.remove(team)) {
            team.removeMember(this);
            return true;
        }
        return false;
    }

    @Override
    public boolean switchTeams(ITeam oldTeam, ITeam newTeam) throws RemoteException{
        boolean retVal = true;
        if (teams.remove(oldTeam)) {
            oldTeam.removeMember(this);
        } else {
            retVal = false;
        }
        if (!teams.contains(newTeam)) {
            teams.add(newTeam);
            newTeam.addMember(this);
        } else {
            retVal = false;
        }
        return retVal;

    }

    @Override
    public boolean addTask(ITask task) throws RemoteException {
        if (!tasks.contains(task)) {
            tasks.add(task);
            task.changeUser(this);
            return true;
        }
        return false;

    }

    @Override
    public boolean removeTask(ITask task)  throws RemoteException{
        if (tasks.remove(task)) {
            task.removeUser(this);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", this.UserID, this.name, this.phoneNum, this.email);
    }

    // <editor-fold desc="Getters/Setters">
    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPhoneNum() {
        return phoneNum;
    }

    @Override
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public Collection<ITask> getTasks() {
        return tasks;
    }

    @Override
    public Collection<ITeam> getTeams() {
        return teams;
    }
    // </editor-fold>
}
