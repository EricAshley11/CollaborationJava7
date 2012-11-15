/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7.common;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import org.restlet.resource.ClientResource;

/**
 * This is a class that provides communication between the client and
 * server layers
 */
public class Backend implements Serializable, IBackend{
    boolean testing = false; //Temporary bool to get dummy data if we are testing
    boolean createdDummyProjects = false;//used to ensure we aren't making dupe projects
    String serverAddr;
    ArrayList<Project> dummyProjects;

    public Backend(String serverAddr) {
        this.serverAddr = serverAddr;
        //retrieveProjects(testUser);//Used to test dummy data
    }

    
    @Override
    public void removeProject(Project project) {    
        throw new UnsupportedOperationException("");
    }
    
    @Override
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
        p1.changeTeam(t1);
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
        p2.changeTeam(t2);
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

    
    @Override
    public ArrayList<User> retrieveUsers(Project p)  {
        Team team = p.getTeam();
        return team.getTeamMembers();
    }

    
    @Override
    public String[][] getUserTableData(Project p) {
        ArrayList<User> users = retrieveUsers(p);
        int numUsers = users.size();
        int userFields = 4; 
        if(users.get(0) != null)
            userFields = users.get(0).toString().split(",").length;
        String[][] tableData = new String[numUsers][userFields];
        for (int i = 0; i < numUsers; i++) {
            User user = users.get(i);
            String userString = user.toString();
            String[] userInfo = userString.split(", ");
            tableData[i] = userInfo;
        }
        return tableData;
    }
    
    @Override
    public ArrayList<Task> retrieveUserTasks(User user) {
        return user.getTasks();
    }

    
    //public void removeUser(User user) {
    //     user.delete();
    //}

    
    @Override
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

    
    @Override
    public User getUserFromId(long id) {
            ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/user/"+id);  
            IUserResource ur = cr.wrap(IUserResource.class);
            return ur.retrieve();
    }

    
    @Override
    public User createUser(String userName, String password, String phoneNum, String email)  {
            ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/user");  
            IUsersResource ur = cr.wrap(IUsersResource.class);
            return ur.create(new String[]{userName, password, phoneNum, email});
    }


    
    @Override
    public Project createProject(String projectName, User u)  {
        ClientResource cr = new ClientResource(  
           "http://"+serverAddr+":8182/collab/project");  
        IProjectsResource pr = cr.wrap(IProjectsResource.class);
        Project newProj = pr.create(projectName);
        newProj.changeTeam(u.getTeam());
        ClientResource cr2 = new ClientResource(  
           "http://"+serverAddr+":8182/collab/project/"+newProj.getID());
        IProjectResource pr2 = cr2.wrap(IProjectResource.class);
        if(pr2.store(newProj)){
            return newProj;
        }else{
            System.err.println("Error creating Project: "+projectName);
            return null;
        }
    }

    
    @Override
    public Team createTeam(String teamName)  {
        ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/team");  
            ITeamsResource tr = cr.wrap(ITeamsResource.class);
            return tr.create(teamName);
    }

    
    @Override
    public UserStory createUserStory(String usName)  {
            ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/userstory");  
            IUserStoriesResource ur = cr.wrap(IUserStoriesResource.class);
            return ur.create(usName);
    }

    
    @Override
    public Task createTask(String taskName)  {
        ClientResource cr = new ClientResource(  
            "http://"+serverAddr+":8182/collab/task");  
        ITasksResource ur = cr.wrap(ITasksResource.class);
        return ur.create(taskName);
    }


    @Override
    public Milestone createMilestone(String milestoneName)  {
        ClientResource cr = new ClientResource(  
            "http://"+serverAddr+":8182/collab/milestone");  
        IMilestonesResource ur = cr.wrap(IMilestonesResource.class);
        return ur.create(milestoneName);
    }
    
    @Override
    public List<User> getUsersFromName(String name)  {
            ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/user");  
            IUsersResource ur = cr.wrap(IUsersResource.class);
            return ur.retrieve(name);
    }

    @Override
    public User loginUser(String userName, String password) {
            ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/login/"+userName);  
            ILoginResource lr = cr.wrap(ILoginResource.class);
            return lr.login(password);
    }
    
    @Override
    public <T> boolean saveEntity(T entity){
        boolean flag = false;
        Class entityClass = entity.getClass();
        try {
            String name = entityClass.getSimpleName();
            Method saveMethod = this.getClass().getDeclaredMethod("save"+name,new Class[]{entityClass});
            flag = (boolean) saveMethod.invoke(this, entity);
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        return flag;
    }
    
    
    private boolean saveMilestone(Milestone m){
        ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/milestone/"+m.getID());  
            IMilestoneResource mr = cr.wrap(IMilestoneResource.class);
            return mr.store(m);
    }
    private boolean saveProject(Project p){
        ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/project/"+p.getID());  
            IProjectResource pr = cr.wrap(IProjectResource.class);
            return pr.store(p);
    }
    private boolean saveSchedule(Schedule s){
        ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/schedule/"+s.getID());  
            IScheduleResource sr = cr.wrap(IScheduleResource.class);
            return sr.store(s);
    }
    private boolean saveTask(Task t){
        ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/task/"+t.getID());  
            ITaskResource tr = cr.wrap(ITaskResource.class);
            return tr.store(t);
    }
    private boolean saveTeam(Team t){
        ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/team/"+t.getID());  
            ITeamResource tr = cr.wrap(ITeamResource.class);
            return tr.store(t);
    }
    private boolean saveUser(User u){
        ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/user/"+u.getID());  
            IUserResource ur = cr.wrap(IUserResource.class);
            return ur.store(u);
    }
    private boolean saveUserStory(UserStory us){
        ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/userstory/"+us.getID());  
            IUserStoryResource ur = cr.wrap(IUserStoryResource.class);
            return ur.store(us);
    }

    public void editProjectName(Project proj, String editedProjectName) {
        proj.setName(editedProjectName);
        this.saveEntity(proj);
    }

    public void updateUser(String newName, String newPhone, String newEmail) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
