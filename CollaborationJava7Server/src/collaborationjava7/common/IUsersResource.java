/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7.common;

import java.util.ArrayList;
import java.util.List;
import org.restlet.resource.Get;
import org.restlet.resource.Post;

/**
 *
 * @author Cam
 */
public interface IUsersResource {
    /**
     * Creates a new user
     * namePass[0]=userName, namePass[1]=password
     * @param namePass
     * @return created user
     */
    @Post
    public User create(String[] namePass);
    /**
     * Gets the users with the given name
     * @param name
     * @return 
     */
    @Get
    public ArrayList<User> retrieve(String name);
}
