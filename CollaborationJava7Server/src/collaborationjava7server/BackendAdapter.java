/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;

import collaborationjava7.common.IBackend;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Cam
 */
class BackendAdapter extends UnicastRemoteObject implements IBackend{
    private Backend backend;
    public BackendAdapter() throws RemoteException{
        backend = new Backend();
    }
    
    @Override
    public void setCurrentProject(String project) throws RemoteException {
        Project proj = QueryManager.getInstance().getProject(project);
        backend.setCurrentProject(proj);
    }

    @Override
    public void setCurrentUser(String user) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeProject(String project) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String[] createProject(String projectName) throws RemoteException {
        Project proj = QueryManager.getInstance().createProject(projectName);
        proj.toString();
        return null;
    }

    @Override
    public String[] createTeam(String teamName) throws RemoteException {
        Team team = QueryManager.getInstance().createTeam(teamName);
        return team.toString().split(",");
    }

    @Override
    public String[] createUserStory(String usName) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<String[]> retrieveProjects() throws RemoteException {
        Collection<Project> projects = QueryManager.getInstance().getAllProjects();
        Collection<String[]> retVal = new ArrayList<String[]>();
        for(Project proj : projects){
            retVal.add(proj.toString().split(","));
        }
        return retVal;
    }

    @Override
    public Collection<String[]> retrieveUsers() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String[][] getUserTableData() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<String[]> retrieveUserTasks() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<String[]> retrieveUserTasks(String userName) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeUser(String userName) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String[] getUserFromName(String name) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String[] createUser(String user, String password) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String[] getUser(String name) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setUserName(String userName, String name) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setUserPhoneNum(String userName, String phoneNum) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setUserEmail(String userName, String email) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
