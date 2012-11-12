/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7.common;

import collaborationjava7.common.ITeamResource;
import java.util.Collection;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.*;

/**
 *
 */
@Entity(name = "Team") //Entity name
public class Team implements Serializable{
    
    @Id @GeneratedValue
    private long id;
    private static int nextTeamID = 0;
    @OneToMany
    private Collection<User> users;
    private Collection<Project> projects;
    private String name;
    private Schedule sched;
    
    public Team(String name) {
        this.users = new ArrayList<User>();
        this.projects = new ArrayList<Project>();
        this.name = name;
        this.id = nextTeamID++;
    }

    public Team() {}
    
//    Team(String name) {
//        this.users = new ArrayList<User>();
//        this.projects = new ArrayList<Project>();
//        this.name = name;
//    }

    public boolean addProject(Project project) {
        if (!projects.contains(project)) {
            projects.add(project);
            project.addTeam(this);
            return true;
        }
        return false;
    }

    public boolean removeProject(Project project) {
        if (projects.remove(project)) {
            project.removeTeam(this);
            return true;
        }
        return false;
    }

    public boolean addMember(User user) {
        if (!users.contains(user)) {
            users.add(user);
            user.addToTeam(this);
            return true;
        }
        return false;
    }

    public boolean removeMember(User user) {
        if (users.remove(user)) {
            user.removeFromTeam(this);
            return true;
        }
        return false;
    }

    public boolean completeMilestone(Milestone milestone) {
        if (sched.completeMilestone(milestone)) {
            return true;
        }
        return false;
    }

    public boolean addMilestone(Milestone milestone) {
        if (sched.addMilestone(milestone)) {
            return true;
        }
        return false;
    }

    public Schedule getSched() {
        return this.sched;
    }

    public Collection<Project> getProjects() {
        return projects;
    }

    public Collection<User> getTeamMembers() {
        return users;
    }

    public String getName() {
        return this.name;
    }
    public long getID() {
        return id;
    }
}
