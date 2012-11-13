/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;

import collaborationjava7.common.IUserStoryResource;
import collaborationjava7.common.UserStory;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Cam
 */
public class UserStoryResource  extends ServerResource implements IUserStoryResource{
    private UserStory userStory;
    private long id;
    
    @Override
    public UserStory retrieve() {
        userStory = QueryManager.getInstance().getUserStoryByID(id);
        return userStory;
    }

    @Override
    public boolean store(UserStory userstory) {
        return QueryManager.getInstance().updateObj(userstory);
    }

    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
