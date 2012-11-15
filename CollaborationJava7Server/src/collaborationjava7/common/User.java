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
@Entity(name = "User") //entity name
public class User implements Serializable {

    @Id @GeneratedValue //primary key
    @Column(nullable = false)
    private long id;
    private String name, email;
    private String phoneNum;
    @ManyToOne(cascade=CascadeType.ALL)
    private Team team;
    @OneToMany(cascade=CascadeType.ALL, mappedBy="user")
    private ArrayList<Task> tasks;

    public User() {}
    
    public User(String name) {
        this.name = name;
        tasks = new ArrayList<Task>();
    }

    public boolean addToTeam(Team team) {
        if (this.team != team) {
            if(this.team != null)
                this.team.removeMember(this);
            team.addMember(this);
            this.team = team;
            return true;//QueryManager.getInstance().updateObjs(new Object[]{team,this});
        }
        return false;
    }

    public void delete() {
        team.removeMember(this);
        for (Task task : tasks) {
            this.removeTask(task);
        }
    }

    public void removeFromTeam(Team team) {
        if(this.team == team){
            this.team = null;
        }
    }

    public boolean switchTeams(Team newTeam) {
        Team oldTeam = this.team;
        newTeam.addMember(this);
        oldTeam.removeMember(this);
        this.team = newTeam;
        return true;//QueryManager.getInstance().updateObjs(new Object[]{oldTeam, newTeam});//TODO: make sure we don't have to add "this"
    }

    public boolean addTask(Task task)  {
        if (!tasks.contains(task)) {
            tasks.add(task);
            task.changeUser(this);
            return true;//QueryManager.getInstance().updateObj(this);
        }
        return false;
    }

    public boolean removeTask(Task task)  {
        if (tasks.remove(task)) {
            task.removeUser(this);
            return true;
        }
        return false;
    }

    public String toString() {
        return String.format(" %s, %s, %s", this.name, this.phoneNum, this.email);
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

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public Team getTeam() {
        return team;
    }
    public long getID() {
        return id;
    }
    
    // </editor-fold>
}
