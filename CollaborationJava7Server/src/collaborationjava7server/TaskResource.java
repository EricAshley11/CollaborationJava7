/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;

import collaborationjava7.common.ITaskResource;
import collaborationjava7.common.Task;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Cam
 */
public class TaskResource extends ServerResource implements ITaskResource{
    private Task task;
    private long id;
    
    @Override
    public Task retrieve() {
        id = Long.parseLong((String)this.getRequestAttributes().get("id"));
        task = QueryManager.getInstance().getTaskByID(id);
        return task;
    }

    @Override
    public boolean store(Task task) {
        return QueryManager.getInstance().updateObj(task);
    }

    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
