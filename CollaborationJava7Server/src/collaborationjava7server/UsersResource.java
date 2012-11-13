/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;

import org.restlet.resource.ServerResource;
import collaborationjava7.common.IUsersResource;
import collaborationjava7.common.User;

/**
 *
 * @author Cam
 */
public class UsersResource extends ServerResource implements IUsersResource{
    @Override
    public User create(String[] namePass) {
        return QueryManager.getInstance().createUser(namePass[0], namePass[1]);
    }
}
