/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7.common;

import java.util.ArrayList;
import org.restlet.resource.Get;
import org.restlet.resource.Post;

/**
 *
 * @author Cam
 */
public interface IUserStoriesResource {
    @Post
    public UserStory create(String name);
    @Get
    public ArrayList<UserStory> retrieve();
}
