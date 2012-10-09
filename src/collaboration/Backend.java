/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaboration;

import java.util.Collection;
import java.util.Vector;

/**
 * This is a singleton class that provides translation between the GUI and backend layers
 * @author Cam
 */
public final class Backend {
    Project currentProject = null;
    User    currentUser = null;
    private static Backend instance = null;
    
    private Backend(){
        //since this is a singleton, we don't want instantiation from outside the class
    }
    public static Backend getInstance(){
        if(instance == null){
            instance = new Backend();
        }
        return instance;
    }
    void setCurrentProject(Project project){
        currentProject = project;
    }
    
    void setCurrentUser(User user){
        this.currentUser = user;
    }
    Collection<Project> retrieveProjects(){
        //TODO: get projects from db
        //for now simulate it
        Project p1 = new Project("Project 1");
        Team t1 = new Team("Team 1");
        p1.addTeam(t1);
        User u1 = new User("User 1");
        u1.setEmail("user1@abc.com");
        u1.setPhoneNum(0000000001);
        t1.addMember(u1);
        User u2 = new User("User 2");
        u2.setEmail("user2@abc.com");
        u2.setPhoneNum(0000000002);
        t1.addMember(u2);
        
        Project p2 = new Project("Project 2");
        Team t2 = new Team("Team 2");
        p2.addTeam(t2);
        User u3 = new User("User 3");
        u3.setEmail("user3@abc.com");
        u3.setPhoneNum(0000000003);
        t2.addMember(u1);
        User u4 = new User("User 4");
        u4.setEmail("user4@abc.com");
        u4.setPhoneNum(0000000004);
        t2.addMember(u2);
        
        Vector<Project> projects = new Vector<Project>();
        projects.add(p1);
        projects.add(p2);
        return projects;
    }
    
    Collection<User> retrieveUsers(){
        Collection<Team> teams = this.currentProject.getTeams();
        Collection<User> users = new Vector<User>();
        for(Team team : teams){
            users.addAll(team.getTeamMembers());
        }
        return users;
    }
    Collection<Task> retrieveUserTasks(){
        return retrieveUserTasks(this.currentUser);
    }

    Collection<Task> retrieveUserTasks(User user) {
        return user.getTasks();
    }
    
    void removeUser(User user){
        user.delete();        
    }
    
}
