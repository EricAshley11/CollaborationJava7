/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7.common;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.ArrayList;



/**
 *
 */

public class Project implements Serializable{
    
    private long id;
    
    private Team team;
    
    private Schedule schedule;
    
    private String name;

    public Project() {
    }

    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
        //QueryManager.getInstance().updateObj(this);
    }
    public void setSchedule(Schedule s){
        this.schedule = s;
    }
    public Schedule getSchedule(){
        return this.schedule;
    }

    public Team getTeam() {
        return team;
    }


    public void reName(String newName) {
        this.name = newName;
    }

    public boolean changeTeam(Team team)  {
        if (this.team != team) {
            if(this.team != null)
                this.team.removeProject(this);
            team.addProject(this);
            this.team = team;
            return true;//QueryManager.getInstance().updateObjs(new Object[]{this, oldTeam, team});
        }
        return false;
    }
/*
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
*/
    public String toString() {
        return this.getName();
    }
    public long getID(){
        return id;
    }
}
