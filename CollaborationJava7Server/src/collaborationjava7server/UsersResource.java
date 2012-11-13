/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;

import collaborationjava7.common.IUsersResource;
import collaborationjava7.common.User;
import java.util.ArrayList;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Cam
 */
public class UsersResource extends ServerResource implements IUsersResource{
    @Override
    public User create(String[] namePass) {
        User u = QueryManager.getInstance().createUser(namePass[0], namePass[1], namePass[2],namePass[3]);
        return u;
    }

    @Override
    public ArrayList<User> retrieve(String name) {
        ArrayList<User> ret = new ArrayList<User>();
        ret.addAll(QueryManager.getInstance().getUsersByName(name));
        return ret;
    }
}
