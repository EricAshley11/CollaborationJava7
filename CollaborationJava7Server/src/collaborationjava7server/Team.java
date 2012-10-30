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
@Entity(name = "Team") //Entity name
public class Team implements Serializable, ITeam {
    
    @Id
    private int TeamID;
    private static int nextTeamID = 0;
    @OneToMany
    private Collection<IUser> users;
    private Collection<IProject> projects;
    private String name;
    private Schedule sched;
    
    public Team(String name) {
        this.users = new ArrayList<IUser>();
        this.projects = new ArrayList<IProject>();
        this.name = name;
        this.TeamID = nextTeamID++;
    }

    public Team() {}
    
//    Team(String name) {
//        this.users = new ArrayList<User>();
//        this.projects = new ArrayList<Project>();
//        this.name = name;
//    }

    @Override
    public boolean addProject(IProject project) throws RemoteException{
        if (!projects.contains(project)) {
            projects.add(project);
            project.addTeam(this);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeProject(IProject project) throws RemoteException{
        if (projects.remove(project)) {
            project.removeTeam(this);
            return true;
        }
        return false;
    }

    @Override
    public boolean addMember(IUser user) throws RemoteException{
        if (!users.contains(user)) {
            users.add(user);
            user.addToTeam(this);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeMember(IUser user) throws RemoteException{
        if (users.remove(user)) {
            user.removeFromTeam(this);
            return true;
        }
        return false;
    }

    @Override
    public boolean completeMilestone(IMilestone milestone) throws RemoteException{
        if (sched.completeMilestone(milestone)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean addMilestone(IMilestone milestone) {
        if (sched.addMilestone(milestone)) {
            return true;
        }
        return false;
    }

    @Override
    public ISchedule getSched() {
        return this.sched;
    }

    @Override
    public Collection<IProject> getProjects() {
        return projects;
    }

    @Override
    public Collection<IUser> getTeamMembers() {
        return users;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
