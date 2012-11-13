/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7.common;

import org.restlet.resource.Post;

/**
 *
 * @author Cam
 */
public interface IUsersResource {
    @Post
    public User create(String[] namePass);
}
