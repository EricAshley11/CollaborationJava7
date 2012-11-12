/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;

import collaborationjava7.common.IProjectResource;
import collaborationjava7.common.Project;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Cam
 */
public class ProjectResource extends ServerResource implements IProjectResource{
    private Project project;
    private long id;
    
    @Override
    public Project retrieve() {
        Project p = QueryManager.getInstance().createProject("abc");
        project = QueryManager.getInstance().getProjectByID(p.getID());
        return project;
    }

    @Override
    public void store(Project project) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
