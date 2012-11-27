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
        id = Long.parseLong((String)this.getRequestAttributes().get("id"));
        project = QueryManager.getInstance().getProjectByID(id);
        return project;
    }

    @Override
    public boolean store(Project project) {
        return QueryManager.getInstance().updateObj(project);
    }

    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
