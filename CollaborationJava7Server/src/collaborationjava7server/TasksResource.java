/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;

import collaborationjava7.common.ITasksResource;
import collaborationjava7.common.Task;
import collaborationjava7.common.User;
import collaborationjava7.common.UserStory;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Cam
 */
public class TasksResource extends ServerResource implements ITasksResource{

    @Override
    public Task create(Object[] params) {
        String name = (String)params[0];
        User user = (User)params[1];
        UserStory us = (UserStory)params[2];
        return QueryManager.getInstance().createTask(name,user,us);
    }
    
}
