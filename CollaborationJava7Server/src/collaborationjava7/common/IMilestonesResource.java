/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7.common;

import org.restlet.resource.Post;
import org.restlet.resource.Put;

/**
 *
 * @author Cam
 */
public interface IMilestonesResource {
    @Post
    public Milestone create(String name);
}
