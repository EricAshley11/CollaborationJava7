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
public interface IProjectsResource {
    @Get
    public Collection<Project> retrieve(User u);
    @Post
    public Project create(String name);
}
