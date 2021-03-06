/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;

import collaborationjava7.common.IUserStoriesResource;
import collaborationjava7.common.UserStory;
import java.util.ArrayList;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Cam
 */
public class UserStoriesResource extends ServerResource implements IUserStoriesResource{
    @Override
    public UserStory create(String name) {
        return QueryManager.getInstance().createUserStory(name);
    }

    @Override
    public ArrayList<UserStory> retrieve() {
        ArrayList<UserStory> us = QueryManager.getInstance().getAll(UserStory.class);
        return us;
    }
    
}
