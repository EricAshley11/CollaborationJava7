/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7.common;

import java.util.Collection;
import org.restlet.resource.*;

/**
 *
 * @author Cam
 */
public interface ITeamsResource {
    @Get
    public Collection<Team> retrieve();
    
    @Post
    public Team create(String teamName);
}
