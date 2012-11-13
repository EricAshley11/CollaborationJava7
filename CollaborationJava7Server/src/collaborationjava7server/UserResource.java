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
    public void store(User user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }    
}
