/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;
import java.io.IOException;
import org.eclipse.egit.github.core.*;
import org.eclipse.egit.github.core.client.*;
import org.eclipse.egit.github.core.event.*;
import org.eclipse.egit.github.core.service.*;
import org.eclipse.egit.github.core.util.*;

/**
 *
 * @author burnsidz
 */
public class GitHubManager {
    String userName;
    String repoName;

    
    private void commit(){
        
    }
    private void pull(){
        
    }
    private void push(){
        
    }
    private void reportIssue(){
        
    }
    public static void main(String[] args) throws IOException  {
        GitHubClient client = new GitHubClient();
        client.setCredentials("akie311", "bd349557");
    }
}