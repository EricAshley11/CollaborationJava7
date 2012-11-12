/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7.common;
import collaborationjava7server.QueryManager;
import java.io.Serializable;
import java.util.Collection;
import java.util.ArrayList;

/**
 * This is a class that provides communication between the client and
 * server layers
 */
public class Backend implements Serializable{

    Project currentProject = null;
    User currentUser = null;
    boolean createdDummyProjects = false;//used to ensure we aren't making dupe projects
    Collection<Project> dummyProjects;

    public Backend() {
        currentProject = (Project) retrieveProjects().toArray()[0];//Used to test dummy data
    }
    public Backend(String test){
        
    }

    public void setCurrentProject(Project project) {
        currentProject = project;
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    
    public void removeProject(Project project) {    
        throw new UnsupportedOperationException("");
    }
    
    public Collection<Project> retrieveProjects()  {
        //TODO: Cam get projects from db
        //for now simulate it
        if (!this.createdDummyProjects) {
            dummyProjects = getDummyProjects();
            this.createdDummyProjects = true;
        }
        return dummyProjects;
    }

    
    public Collection<Project> getDummyProjects()  {
        Project p1 = new Project("Project 1");
        Team t1 = new Team("Team 1");
        p1.addTeam(t1);
        User u1 = new User("User 1");
        u1.setEmail("user1@abc.com");
        u1.setPhoneNum("(000)000-0001");
        t1.addMember(u1);
        User u2 = new User("User 2");
        u2.setEmail("user2@abc.com");
        u2.setPhoneNum("(000)000-0002");
        t1.addMember(u2);

        Project p2 = new Project("Project 2");
        Team t2 = new Team("Team 2");
        p2.addTeam(t2);
        User u3 = new User("User 3");
        u3.setEmail("user3@abc.com");
        u3.setPhoneNum("(000)000-0003");
        t2.addMember(u3);
        User u4 = new User("User 4");
        u4.setEmail("user4@abc.com");
        u4.setPhoneNum("(000)000-0004");
        t2.addMember(u4);

        ArrayList<Project> projects = new ArrayList<Project>();
        projects.add(p1);
        projects.add(p2);
        return projects;
    }

    
    public Collection<User> retrieveUsers()  {
        Collection<Team> teams = this.currentProject.getTeams();
        Collection<User> users = new ArrayList<User>();
        for (Team team : teams) {
            users.addAll(team.getTeamMembers());
        }
        return users;
    }

    
    public String[][] getUserTableData() {
        //User[] users = retrieveUsers().toArray(new User[0]);
        //String[] userStrings = .toArray(new String[0]);
        Collection<User> users = retrieveUsers();
        int numUsers = users.size();
        int userFields = 4;
        String[][] tableData = new String[numUsers][userFields];
        for (int i = 0; i < numUsers; i++) {
            User user = (User) users.toArray()[i];
            String userString = user.toString();
            String[] userInfo = userString.split(", ");
            tableData[i] = userInfo;
        }
        return tableData;
    }

    
    public Collection<Task> retrieveUserTasks() {
        return retrieveUserTasks(this.currentUser);
    }

    
    public Collection<Task> retrieveUserTasks(User user) {
        return user.getTasks();
    }

    
    public void removeUser(User user) {
        user.delete();
    }

    
    public void removeUser(String name) {
        removeUser(getUserFromName(name));
    }

    
    public User getUserFromName(String name) {
        //TODO: Cam need a connection to the DB to query this
        for (User user : retrieveUsers()) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    
    public User createUser(String userName, String password)  {
        return QueryManager.getInstance().createUser(userName, password);
    }

    
    public Project createProject(String projectName)  {
        return QueryManager.getInstance().createProject(projectName);
    }

    
    public Team createTeam(String teamName)  {
        return QueryManager.getInstance().createTeam(teamName);
    }

    
    public UserStory createUserStory(String usName)  {
        return QueryManager.getInstance().createUserStory(usName);
    }

    
    public User getUser(String name)  {
        return QueryManager.getInstance().getUser(name);
    }
}
