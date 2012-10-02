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
public class Project implements Serializable{
    private Collection<Team> teams;
    private Collection<UserStory> userStories;
    //Calendar is not yet implemented private GCal calendar;
    
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
}
