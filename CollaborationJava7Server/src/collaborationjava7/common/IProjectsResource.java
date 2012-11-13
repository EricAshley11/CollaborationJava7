/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7.common;

import java.util.ArrayList;
import org.restlet.resource.*;

/**
 *
 * @author Cam
 */
public interface IProjectsResource {
    @Get
    public ArrayList<Project> retrieve(long userID);
    @Post
    public Project create(String name);
}
