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
public class Project implements Serializable{
    private Collection<Team> teams;
    private Collection<UserStory> userStories;
    private Collection<Milestone> milestones;
    private String name;
    //Calendar is not yet implemented private GCal calendar;   
    Project(String name){
        this.name = name;
        this.teams = new ArrayList<Team>();
        this.userStories = new ArrayList<UserStory>();
    }
    
    String getName(){
        return name;
    }
    Collection<Team> getTeams(){
        return teams;
    }
    void reName(String newName){
        this.name = newName;
    }
    boolean removeTeam(Team team) {
        if(teams.remove(team)){
            team.removeProject(this);
            return true;
        }
        return false;
    }

    boolean addTeam(Team team) {
        if(!teams.contains(team)){
            teams.add(team);
            team.addProject(this);
            return true;
        }
        return false;
    }
    
    boolean removeUserStory(UserStory userStory) {
        if(userStories.remove(userStory)){
            userStory.removeProject(this);
            return true;
        }
        return false;
    }

    boolean addUserStory(UserStory userStory) {
        if(!userStories.contains(userStory)){
            userStories.add(userStory);
            userStory.changeProject(this);
            return true;
        }
        return false;
    }
    
    boolean createMilestone(Milestone milestone) {
        if (!milestones.contains(milestone)) {
            milestones.add(milestone);
            return true;
        }
        return false;
    }
    
    boolean removeMilestone(Milestone milestone) {
        if (milestones.remove(milestone)) {
            return true;
        }
        return false;
    }
}
