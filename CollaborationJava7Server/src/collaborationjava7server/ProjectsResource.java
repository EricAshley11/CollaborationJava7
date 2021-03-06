/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;

import collaborationjava7.common.IProjectsResource;
import collaborationjava7.common.Project;
import collaborationjava7.common.Team;
import collaborationjava7.common.User;
import java.util.ArrayList;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Cam
 */
public class ProjectsResource extends ServerResource implements IProjectsResource{
    @Override
    public ArrayList<Project> retrieve(long userID) {
        ArrayList<Project> retVal = new ArrayList<Project>();
        User u = QueryManager.getInstance().getUserByID(userID);
        Team t = u.getTeam();
        try{
            System.out.println("Got projects for user: "+u.getName());
            return u.getTeam().getProjects();
        }catch(Exception e){
            e.printStackTrace();
            return new ArrayList<Project>();
        }
    }

    @Override
    public Project create(String name) {
        return QueryManager.getInstance().createProject(name);
    }
    
}
