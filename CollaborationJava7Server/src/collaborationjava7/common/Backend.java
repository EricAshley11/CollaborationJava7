/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7.common;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
            ArrayList<Project> retVal = pr.retrieve(u.getID());
            cr.release();
            return retVal;
    }

    
    public ArrayList<Project> getDummyProjects(User u)  {
        Project p1 = new Project("Project 1");
        Team t1 = new Team("Team 1","abc");
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
        Team t2 = new Team("Team 2","abc");
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
        //p = this.getProjectFromId(p.getID());
        ArrayList<User> users = retrieveUsers(p);
        int numUsers = users.size();
        int userFields = 5; 
        if(users.get(0) != null) {
            userFields = users.get(0).toString().split(",").length;
        }
        String[][] tableData = new String[numUsers][userFields];
        for (int i = 0; i < numUsers; i++) {
            User user = users.get(i);
            String userString = user.toString();
            userString = userString.trim();
            ArrayList<String> userInfo = new ArrayList<String>();
            userInfo.addAll(Arrays.asList(userString.split(", ")));
            int taskNum = 0;
            for(Task t : user.getTasks()){
                for(Milestone m : p.getSchedule().getMilestones()){
                    if(t.getUserStory().getMilestone() == m){
                        taskNum++;
                        break;
                    }
                }
            }
            userInfo.add(taskNum+ " tasks pending (click to view)");
            String[] strArray = new String[userFields];
            tableData[i] = userInfo.toArray(strArray);
        }
        return tableData;
    }
    
    public String[][] getTasksTableData(Project p) {
        //p = this.getProjectFromId(p.getID());
        ArrayList<UserStory> userStories = this.getUserStories(p);
        ArrayList<Task> tasks = new ArrayList<Task>();
        for(UserStory us : userStories){
            tasks.addAll(us.getTasks());
        }
        int numTasks = tasks.size();
        int taskFields = 5; 
        if(numTasks==0){
            return new String[0][5];
        }
        if(tasks.get(0) != null) {
            taskFields = tasks.get(0).toString().split(",").length;
        }
        String[][] tableData = new String[numTasks][taskFields];
        for (int i = 0; i < numTasks; i++) {
            Task task = tasks.get(i);
            String taskString = task.toString();
            String[] taskInfo = taskString.split(",");
            tableData[i] = taskInfo;
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
                    cr.release();
                }
            }
            
    }

    
    @Override
    public User getUserFromId(long id) {
            ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/user/"+id);  
            IUserResource ur = cr.wrap(IUserResource.class);
            User u = ur.retrieve();
            cr.release();
            return u;
    }
    
    //@Override
    public Project getProjectFromId(long id) {
            ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/project/"+id);  
            IProjectResource pr = cr.wrap(IProjectResource.class);
            Project p = pr.retrieve();
            cr.release();
            return p;
    }

    
    @Override
    public User createUser(String userName, String password, String phoneNum, String email)  {
            ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/user");  
            IUsersResource ur = cr.wrap(IUsersResource.class);
            User u = ur.create(new String[]{userName, password, phoneNum, email});
            cr.release();
            return u;
    }


    
    @Override
    public Project createProject(String projectName, User u)  {
        ClientResource cr = new ClientResource(  
           "http://"+serverAddr+":8182/collab/project");  
        IProjectsResource pr = cr.wrap(IProjectsResource.class);
        Project newProj = pr.create(projectName);
        newProj.changeTeam(u.getTeam());
        u.getTeam().addProject(newProj);
        ClientResource cr2 = new ClientResource(  
           "http://"+serverAddr+":8182/collab/project/"+newProj.getID());
        IProjectResource pr2 = cr2.wrap(IProjectResource.class);
        if(pr2.store(newProj)){
            this.saveEntity(u);
            this.saveEntity(u.getTeam());
            cr.release();
            cr2.release();
            return newProj;
        }else{
            System.err.println("Error creating Project: "+projectName);
            cr.release();
            cr2.release();
            return null;
        }
    }

    
    @Override
    public Team createTeam(String teamName, String password)  {
        ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/team");  
            ITeamsResource tr = cr.wrap(ITeamsResource.class);
            Team t =tr.create(new String[]{teamName, password});
            cr.release();
            return t;
    }

    
    @Override
    public UserStory createUserStory(String usName, Milestone ms)  {
            ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/userstory");  
            IUserStoriesResource ur = cr.wrap(IUserStoriesResource.class);
            UserStory us = ur.create(usName);
            cr.release();
            ms.addUserStory(us);
            us.changeMilestone(ms);
            this.saveEntity(ms);
            this.saveEntity(us);
            return us;
    }

    
    private Task createTask(String taskName)  {
        ClientResource cr = new ClientResource(  
            "http://"+serverAddr+":8182/collab/task");  
        ITasksResource ur = cr.wrap(ITasksResource.class);
        Task t =ur.create(taskName);
        cr.release();
        return t;
    }
    
    @Override
    public List<User> getUsersFromName(String name)  {
            ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/user");  
            IUsersResource ur = cr.wrap(IUsersResource.class);
            List<User> u = ur.retrieve(name);
            cr.release();
            return u;
    }

    @Override
    public User loginUser(String userName, String password) {
            ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/login/"+userName);  
            ILoginResource lr = cr.wrap(ILoginResource.class);
            User u =lr.login(password);
            cr.release();
            return u;
    }
    
    @Override
    public <T> boolean saveEntity(T entity){
        boolean flag = false;
        Class entityClass = entity.getClass();
        try {
            String name = entityClass.getSimpleName();
            Method saveMethod = this.getClass().getDeclaredMethod("save"+name,new Class[]{entityClass});
            flag = Boolean.parseBoolean(saveMethod.invoke(this, entity).toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        return flag;
    }
    
    
    private boolean saveMilestone(Milestone m){
        ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/milestone/"+m.getID());  
            IMilestoneResource mr = cr.wrap(IMilestoneResource.class);
            boolean flag = mr.store(m);
            cr.release();
            return flag;
    }
    private boolean saveProject(Project p){
        ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/project/"+p.getID());  
            IProjectResource pr = cr.wrap(IProjectResource.class);
            boolean flag = pr.store(p);
            cr.release();
            return flag;
    }
    private boolean saveSchedule(Schedule s){
        ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/schedule/"+s.getID());  
            IScheduleResource sr = cr.wrap(IScheduleResource.class);
            boolean flag = sr.store(s);
            cr.release();
            return flag;
    }
    private boolean saveTask(Task t){
        ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/task/"+t.getID());  
            ITaskResource tr = cr.wrap(ITaskResource.class);
            boolean flag = tr.store(t);
            cr.release();
            return flag;
    }
    private boolean saveTeam(Team t){
        ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/team/"+t.getID());  
            ITeamResource tr = cr.wrap(ITeamResource.class);
            boolean flag = tr.store(t);
            cr.release();
            return flag;
    }
    private boolean saveUser(User u){
        ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/user/"+u.getID());  
            IUserResource ur = cr.wrap(IUserResource.class);
            boolean flag = ur.store(u);
            cr.release();
            return flag;
    }
    private boolean saveUserStory(UserStory us){
        ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/userstory/"+us.getID());  
            IUserStoryResource ur = cr.wrap(IUserStoryResource.class);
            boolean flag = ur.store(us);
            cr.release();
            return flag;
    }

    public void editProjectName(Project proj, String editedProjectName) {
        proj.setName(editedProjectName);
        this.saveEntity(proj);
    }

    public void updateUser(User user, String newPhone, String newEmail) {
        user.setEmail(newEmail);
        user.setPhoneNum(newPhone);
        this.saveEntity(user);
    }

    @Override
    public ArrayList<Team> getAllTeams() {
            ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/team");  
            ITeamsResource tr = cr.wrap(ITeamsResource.class);
            ArrayList<Team> teams = tr.retrieve();
            cr.release();
            return teams;
    }

    @Override
    public boolean loginTeam(Team team, String password) {
        return team.validatePassword(password);
    }

    @Override
    public void addUserToTeam(User u, Team t) {
        t.addMember(u);
        this.saveEntity(t);
        this.saveEntity(u);
    }

    public UserStory getUserStoryFromName(String userStory) {
        ClientResource cr = new ClientResource(
                "http://"+serverAddr+":8182/collab/userstory");
        IUserStoriesResource ur = cr.wrap(IUserStoriesResource.class);
        ArrayList<UserStory> userStories = ur.retrieve();
        for(UserStory us : userStories){
            if(us.getName().equals(userStory)){
                cr.release();
                return us;
            }
        }
        cr.release();
        return null;
    }

    @Override
    public Task createTask(User lead, UserStory userStory, String taskName, double estimated, String description) {
        Task retVal = this.createTask(taskName);
        retVal.setTimeEstimate(estimated);
        retVal.setTimeActual(0.0);
        retVal.setDescription(description);
        lead.addTask(retVal);
        retVal.changeUser(lead);
        userStory.addTask(retVal);
        retVal.changeUserStory(userStory);
        this.saveEntity(lead);
        this.saveEntity(retVal);
        this.saveEntity(userStory);
        return retVal;    
    }

    public ArrayList<UserStory> getUserStories(Project project) {        
        ArrayList<Milestone> milestones = project.getSchedule().getMilestones();
        ArrayList<UserStory> retVal = new ArrayList<UserStory>();
        for(Milestone m : milestones){
            retVal.addAll(m.getUserStories());
        }
        return retVal;
    }

    @Override
    public Milestone createMilestone(String name, Schedule sched) {
        ClientResource cr = new ClientResource(  
            "http://"+serverAddr+":8182/collab/milestone");  
        IMilestonesResource mr = cr.wrap(IMilestonesResource.class);
        Milestone m = mr.create(name);
        cr.release();
        sched.addMilestone(m);
        this.saveEntity(sched);
        this.saveEntity(m);
        return m;
    }

    public Task editTask(Task task, String name, User u, UserStory us, Status.States state, double est, double actual, String description) {
        task.setName(name);
        User oldUser = task.getUser();
        UserStory oldUS = task.getUserStory();
        task.changeUser(u);
        task.changeUserStory(us);
        task.getStatus().setState(state);
        task.setTimeActual(actual);
        task.setTimeEstimate(est);
        task.setDescription(description);
        this.saveEntity(task);
        this.saveEntity(oldUser);
        this.saveEntity(oldUS);
        this.saveEntity(u);
        this.saveEntity(us);
        return task;
    }

    public void addTimeToTask(Task task, double time) {
        double oldTime = task.getTimeActual();
        oldTime += time;
        task.setTimeActual(oldTime);
        this.saveEntity(task);
    }

    public void updateTaskDescription(Task selectedTask, String description) {
        selectedTask.setDescription(description);
        this.saveEntity(selectedTask);
    }

    public void updateUSDescription(UserStory selectedUS, String description) {
        selectedUS.setDescription(description);
        this.saveEntity(selectedUS);
    }

    public boolean setMilestoneDates(Milestone ms, String startText, String endText) {
        Date start = Milestone.getDateFromString(startText);
        Date end = Milestone.getDateFromString(endText);
        if(start == null || end == null){
            return false;
        }
        if(start.after(end))
            return false;
        ms.setStartDate(start);
        ms.setEndDate(end);
        this.saveEntity(ms);
        return true;
    }
}
