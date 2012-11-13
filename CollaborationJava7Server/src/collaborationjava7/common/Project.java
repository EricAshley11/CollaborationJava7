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
@Entity
public class Project implements Serializable{
    @Id @GeneratedValue
    private long id;
    private ArrayList<Team> teams;
    private ArrayList<UserStory> userStories;
    private ArrayList<Milestone> milestones;
    private String name;
    //Calendar is not yet implemented private GCal calendar;   

    public Project() {
    }

    public Project(String name) {
        this.name = name;
        this.teams = new ArrayList<Team>();
        this.userStories = new ArrayList<UserStory>();
        this.milestones = new ArrayList<Milestone>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }


    public void reName(String newName) {
        this.name = newName;
    }

    public boolean removeTeam(Team team) {
        if (teams.remove(team)) {
            team.removeProject(this);
            return true;
        }
        return false;
    }

    public boolean addTeam(Team team)  {
        if (!teams.contains(team)) {
            teams.add(team);
            team.addProject(this);
            return true;
        }
        return false;
    }

    public boolean removeUserStory(UserStory userStory)  {
        if (userStories.remove(userStory)) {
            userStory.removeProject(this);
            return true;
        }
        return false;
    }

    public boolean addUserStory(UserStory userStory)  {
        if (!userStories.contains(userStory)) {
            userStories.add(userStory);
            userStory.changeProject(this);
            return true;
        }
        return false;
    }

    public boolean createMilestone(Milestone milestone) {
        if (!milestones.contains(milestone)) {
            milestones.add(milestone);
            return true;
        }
        return false;
    }

    public boolean removeMilestone(Milestone milestone) {
        if (milestones.remove(milestone)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.getName();
    }
    public long getID(){
        return id;
    }
}
