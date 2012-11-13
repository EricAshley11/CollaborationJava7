/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;

import collaborationjava7.common.IUserResource;
import collaborationjava7.common.User;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Cam
 */
public class UserResource  extends ServerResource implements IUserResource{
    private User user;
    private long id;
    
    
    @Override
    public User retrieve() {
        id = Long.parseLong((String)this.getRequestAttributes().get("id"));
        user = QueryManager.getInstance().getUserByID(id);
        return user;
    }

    @Override
    public boolean store(User user) {
        return QueryManager.getInstance().updateObj(user);
    }

    @Override
    public void remove() {
        id = Long.parseLong((String)this.getRequestAttributes().get("id"));
        user = QueryManager.getInstance().getUserByID(id);
        user.delete();
        user = null;
    }    
}
