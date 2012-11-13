/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7.common;
import collaborationjava7server.QueryManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import org.restlet.resource.ClientResource;

/**
 * This is a class that provides communication between the client and
 * server layers
 */
public class Backend implements Serializable{
    boolean testing = false; //Temporary bool to get dummy data if we are testing
    boolean createdDummyProjects = false;//used to ensure we aren't making dupe projects
    String serverAddr;
    ArrayList<Project> dummyProjects;

    public Backend(String serverAddr) {
        this.serverAddr = serverAddr;
        //retrieveProjects(testUser);//Used to test dummy data
    }

    
    public void removeProject(Project project) {    
        throw new UnsupportedOperationException("");
    }
    
    public ArrayList<Project> retrieveProjects(User u)  {
        if(testing){
            if (!this.createdDummyProjects) {
                dummyProjects = getDummyProjects(u);
                this.createdDummyProjects = true;
            }
            return dummyProjects;
        }
        ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/project");  
            IProjectsResource pr = cr.wrap(IProjectsResource.class);
            return pr.retrieve(u.getID());
    }

    
    public ArrayList<Project> getDummyProjects(User u)  {
        Project p1 = new Project("Project 1");
        Team t1 = new Team("Team 1");
        p1.addTeam(t1);
        User u1 = u;
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

    
    public ArrayList<User> retrieveUsers()  {
        //ArrayList<Team> teams = this.currentProject.getTeams();
        //ArrayList<User> users = new ArrayList<User>();
        //for (Team team : teams) {
          //  users.addAll(team.getTeamMembers());
        //}
        return null;
    }

    
    public String[][] getUserTableData() {
        //User[] users = retrieveUsers().toArray(new User[0]);
        //String[] userStrings = .toArray(new String[0]);
        ArrayList<User> users = retrieveUsers();
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
    
    public ArrayList<Task> retrieveUserTasks(User user) {
        return user.getTasks();
    }

    
    //public void removeUser(User user) {
    //     user.delete();
    //}

    
    public void removeUser(String name) {
            long id = -1;
            List<User> users = this.getUsersFromName(name);
            if(users!=null){
                if(users.size()==1){
                    User u = users.iterator().next();
                    id = u.getID();
                    ClientResource cr = new ClientResource(  
                        "http://"+serverAddr+":8182/collab/user/"+id);  
                    IUserResource ur = cr.wrap(IUserResource.class);
                    ur.remove();
                }
            }
            
    }

    
    public User getUserFromId(long id) {
            ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/user/"+id);  
            IUserResource ur = cr.wrap(IUserResource.class);
            return ur.retrieve();
    }

    
    public User createUser(String userName, String password, String phoneNum, String email)  {
            ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/user");  
            IUsersResource ur = cr.wrap(IUsersResource.class);
            return ur.create(new String[]{userName, password, phoneNum, email});
    }

    public boolean saveUser(User u){
        ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/user/"+u.getID());  
            IUserResource ur = cr.wrap(IUserResource.class);
            return ur.store(u);
    }
    
    public Project createProject(String projectName)  {
        ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/project");  
            IProjectsResource ur = cr.wrap(IProjectsResource.class);
            return ur.create(projectName);
    }

    
    public Team createTeam(String teamName)  {
        ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/team");  
            ITeamsResource tr = cr.wrap(ITeamsResource.class);
            return tr.create(teamName);
    }

    
    public UserStory createUserStory(String usName)  {
            ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/userstory");  
            IUserStoriesResource ur = cr.wrap(IUserStoriesResource.class);
            return ur.create(usName);
    }

    
    public List<User> getUsersFromName(String name)  {
            ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/user");  
            IUsersResource ur = cr.wrap(IUsersResource.class);
            return ur.retrieve(name);
    }

    public User loginUser(String userName, String password) {
            ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/login/"+userName+"/"+password);  
            ILoginResource lr = cr.wrap(ILoginResource.class);
            return lr.login();
    }
}
