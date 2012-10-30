/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;
import collaborationjava7.common.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;
import java.util.Vector;

/**
 * This is a class that provides communication between the client and
 * server layers
 */
public final class Backend extends UnicastRemoteObject implements IBackend{

    IProject currentProject = null;
    IUser currentUser = null;
    boolean createdDummyProjects = false;//used to ensure we aren't making dupe projects
    Collection<IProject> dummyProjects;

    public Backend() throws RemoteException{
        currentProject = (Project) retrieveProjects().toArray()[0];//Used to test dummy data
    }

    @Override
    public void setCurrentProject(IProject project) {
        currentProject = project;
    }

    @Override
    public void setCurrentUser(IUser user) {
        this.currentUser = user;
    }

    @Override
    public void removeProject(IProject project){    
        throw new UnsupportedOperationException("");
    }
    
    @Override
    public Collection<IProject> retrieveProjects() throws RemoteException {
        //TODO: Cam get projects from db
        //for now simulate it
        if (!this.createdDummyProjects) {
            dummyProjects = getDummyProjects();
            this.createdDummyProjects = true;
        }
        return dummyProjects;
    }

    @Override
    public Collection<IProject> getDummyProjects() throws RemoteException {
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

        Vector<IProject> projects = new Vector<IProject>();
        projects.add(p1);
        projects.add(p2);
        return projects;
    }

    @Override
    public Collection<IUser> retrieveUsers() throws RemoteException {
        Collection<ITeam> teams = this.currentProject.getTeams();
        Collection<IUser> users = new Vector<IUser>();
        for (ITeam team : teams) {
            users.addAll(team.getTeamMembers());
        }
        return users;
    }

    @Override
    public String[][] getUserTableData() throws RemoteException{
        //User[] users = retrieveUsers().toArray(new User[0]);
        //String[] userStrings = .toArray(new String[0]);
        Collection<IUser> users = retrieveUsers();
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

    @Override
    public Collection<ITask> retrieveUserTasks() throws RemoteException{
        return retrieveUserTasks(this.currentUser);
    }

    @Override
    public Collection<ITask> retrieveUserTasks(IUser user) throws RemoteException{
        return user.getTasks();
    }

    @Override
    public void removeUser(IUser user) throws RemoteException{
        user.delete();
    }

    @Override
    public void removeUser(String name) throws RemoteException{
        removeUser(getUserFromName(name));
    }

    @Override
    public IUser getUserFromName(String name) throws RemoteException{
        //TODO: Cam need a connection to the DB to query this
        for (IUser user : retrieveUsers()) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }
}
