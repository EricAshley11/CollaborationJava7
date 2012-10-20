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
 */
@Entity(name = "User") //entity name
public class User implements Serializable {

    @Id //primary key
    @Column(nullable = false)
    private int UserID;
    
    private static int nextUID = 0;
    private String name, email;
    private String phoneNum;
    @OneToMany
    private Collection<Team> teams;
    @OneToMany
    private Collection<Task> tasks;

    public User() {}
    
    public User(String name) {
        this.name = name;
        teams = new ArrayList<Team>();
        tasks = new ArrayList<Task>();
        UserID = nextUID++;
    }

    boolean addToTeam(Team team) {
        if (!teams.contains(team)) {
            teams.add(team);
            team.addMember(this);
            return true;
        }
        return false;
    }

    void delete() {
        for (Team team : teams) {
            this.removeFromTeam(team);
        }
        for (Task task : tasks) {
            this.removeTask(task);
        }
    }

    boolean removeFromTeam(Team team) {
        if (teams.remove(team)) {
            team.removeMember(this);
            return true;
        }
        return false;
    }

    boolean switchTeams(Team oldTeam, Team newTeam) {
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

    boolean addTask(Task task) {
        if (!tasks.contains(task)) {
            tasks.add(task);
            task.changeUser(this);
            return true;
        }
        return false;

    }

    boolean removeTask(Task task) {
        if (tasks.remove(task)) {
            task.removeUser(this);
            return true;
        }
        return false;
    }

    public String toString() {
        return String.format("%s, %s, %s, %s", this.UserID, this.name, this.phoneNum, this.email);
    }

    // <editor-fold desc="Getters/Setters">
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Collection<Task> getTasks() {
        return tasks;
    }

    public Collection<Team> getTeams() {
        return teams;
    }
    // </editor-fold>
}
