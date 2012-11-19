/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7.common;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cam
 */
public interface IBackend {

    Milestone createMilestone(String milestoneName);

    Project createProject(String projectName, User u);

    Task createTask(String taskName);

    Team createTeam(String teamName, String password);

    User createUser(String userName, String password, String phoneNum, String email);

    UserStory createUserStory(String usName);

    User getUserFromId(long id);

    String[][] getUserTableData(Project p);

    List<User> getUsersFromName(String name);

    User loginUser(String userName, String password);

    void removeProject(Project project);

    void removeUser(String name);

    ArrayList<Project> retrieveProjects(User u);

    ArrayList<Task> retrieveUserTasks(User user);

    ArrayList<User> retrieveUsers(Project p);

    <T> boolean saveEntity(T entity);
    
    void editProjectName(Project proj, String editedProjectName);
    
    ArrayList<Team> getAllTeams();
    
    boolean loginTeam(Team team, String password);
    
    void addUserToTeam(User u, Team t);
}
