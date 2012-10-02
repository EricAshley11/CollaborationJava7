/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaboration;

import java.util.Collection;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Cam
 */
@Entity
public class User implements Serializable{

	@ID
	private int UserID;
	
    private String name, email;
    private int phoneNum;
    private Collection<Team> teams;
    private Collection<Task> tasks;

    boolean addToTeam(Team team) {
        if (!teams.contains(team)) {
            teams.add(team);
            team.addMember(this);
            return true;
        }
        return false;
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

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
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
