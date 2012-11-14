/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;

import collaborationjava7.common.ILoginResource;
import collaborationjava7.common.User;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Cam
 */
public class LoginResource extends ServerResource implements ILoginResource{

    @Override
    public User login(String password) {
        String userName = (String)this.getRequestAttributes().get("userName");
        return QueryManager.getInstance().checkPassword(userName, password);
    }
    
}
