/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;

import collaborationjava7.common.ITasksResource;
import collaborationjava7.common.Task;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Cam
 */
public class TasksResource extends ServerResource implements ITasksResource{

    @Override
    public Task create(String name) {
        return QueryManager.getInstance().createTask(name);
    }
    
}
