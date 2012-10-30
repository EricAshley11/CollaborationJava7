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
public class Project implements Serializable, IProject {

    private Collection<ITeam> teams;
    private Collection<IUserStory> userStories;
    private Collection<IMilestone> milestones;
    private String name;
    //Calendar is not yet implemented private GCal calendar;   

    Project(String name) {
        this.name = name;
        this.teams = new ArrayList<ITeam>();
        this.userStories = new ArrayList<IUserStory>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Collection<ITeam> getTeams() {
        return teams;
    }

    @Override
    public void reName(String newName) {
        this.name = newName;
    }

    public boolean removeTeam(ITeam team) throws RemoteException{
        if (teams.remove(team)) {
            team.removeProject(this);
            return true;
        }
        return false;
    }

    public boolean addTeam(ITeam team) throws RemoteException {
        if (!teams.contains(team)) {
            teams.add(team);
            team.addProject(this);
            return true;
        }
        return false;
    }

    public boolean removeUserStory(IUserStory userStory) throws RemoteException {
        if (userStories.remove(userStory)) {
            userStory.removeProject(this);
            return true;
        }
        return false;
    }

    public boolean addUserStory(IUserStory userStory) throws RemoteException {
        if (!userStories.contains(userStory)) {
            userStories.add(userStory);
            userStory.changeProject(this);
            return true;
        }
        return false;
    }

    public boolean createMilestone(IMilestone milestone) {
        if (!milestones.contains(milestone)) {
            milestones.add(milestone);
            return true;
        }
        return false;
    }

    public boolean removeMilestone(IMilestone milestone) {
        if (milestones.remove(milestone)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
