/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaboration;

import java.rmi.Remote;
import java.util.Collection;

/**
 *
 * @author Cam
 */
public interface IBackend extends Remote {
    void setCurrentProject(Project project);

    void setCurrentUser(User user);

    void removeProject(Project project);
    
    Collection<Project> retrieveProjects();

    Collection<Project> getDummyProjects();

    Collection<User> retrieveUsers();

    String[][] getUserTableData();

    Collection<Task> retrieveUserTasks();

    Collection<Task> retrieveUserTasks(User user);

    void removeUser(User user);

    void removeUser(String name);

    User getUserFromName(String name);
}
