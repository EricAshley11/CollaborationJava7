/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaboration;

import java.util.Collection;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.*;

/**
 *
 * @author Cam
 */
@Entity
public class Team implements Serializable {

    @Id
    private int TeamID;
    private Collection<User> users;
    private Collection<Project> projects;
    private String name;
    private Schedule sched;

    public Team(String name) {
        this.users = new ArrayList<User>();
        this.projects = new ArrayList<Project>();
        this.name = name;
    }

//    Team(String name) {
//        this.users = new ArrayList<User>();
//        this.projects = new ArrayList<Project>();
//        this.name = name;
//    }

    boolean addProject(Project project) {
        if (!projects.contains(project)) {
            projects.add(project);
            project.addTeam(this);
            return true;
        }
        return false;
    }

    boolean removeProject(Project project) {
        if (projects.remove(project)) {
            project.removeTeam(this);
            return true;
        }
        return false;
    }

    boolean addMember(User user) {
        if (!users.contains(user)) {
            users.add(user);
            user.addToTeam(this);
            return true;
        }
        return false;
    }

    boolean removeMember(User user) {
        if (users.remove(user)) {
            user.removeFromTeam(this);
            return true;
        }
        return false;
    }

    boolean completeMilestone(Milestone milestone) {
        if (sched.completeMilestone(milestone)) {
            return true;
        }
        return false;
    }

    boolean addMilestone(Milestone milestone) {
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

    Collection<User> getTeamMembers() {
        return users;
    }

    public String getName() {
        return this.name;
    }
}
