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
public interface ITeamResource{
    @Get
    public Team retrieve();

    @Put
    public boolean store(Team team);

    @Delete
    public void remove(int id);
}
