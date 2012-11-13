/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7.common;

import org.restlet.resource.*;

/**
 *
 * @author Cam
 */
public interface IUserStoryResource{
    @Get
    public UserStory retrieve();

    @Put
    public boolean store(UserStory userstory);

    @Delete
    public void remove(int id);
}
