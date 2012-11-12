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
public interface IMilestoneResource{
    
    @Get
    public Milestone retrieve();

    @Put
    public void store(Milestone milestone);

    @Delete
    public void remove(int id);
}
