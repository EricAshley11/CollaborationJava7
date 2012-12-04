/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;

import java.io.IOException;
import java.util.List;
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

    private void reportIssue() {
    }

    private void getBranches(String ownerUsername, String reponame) throws IOException {
        RepositoryService rServ = new RepositoryService();
        RepositoryId rID = new RepositoryId(ownerUsername, reponame);
        List<RepositoryBranch> l = rServ.getBranches(rID);
        for (int i = 0; i < l.size(); i++) {
            System.out.println(rServ.getBranches(rID).get(i).getName());
        }
    }

    private void getContributors(String ownerUsername, String reponame) throws IOException {
        RepositoryService rServ = new RepositoryService();
        RepositoryId rID = new RepositoryId(ownerUsername, reponame);
        List<Contributor> l = rServ.getContributors(rID, false);
        for (int i = 0; i < l.size(); i++) {
            rServ.getContributors(rID, false).get(i).getLogin();
        }

    }

    private void getIssues(String ownerUsername, String reponame) throws IOException {
        IssueService iServ = new IssueService();
        RepositoryId rID = new RepositoryId(ownerUsername, reponame);
        List<Issue> l = iServ.getIssues(rID, null);
        for (int i = 0; i < l.size(); i++) {
            Issue issue = iServ.getIssues(rID, null).get(i);
            issue.getTitle();
            issue.getBody();
            issue.getUser().getLogin();
        }
    }

    private void createIssue(String username, String password, String reponame, String title, String body) throws IOException {
        GitHubClient client = new GitHubClient();
        client.setCredentials(username, password);
        IssueService iServ = new IssueService(client);
        RepositoryId rID = new RepositoryId(username, reponame);
        Issue issue = new Issue();
        issue.setTitle(title);
        issue.setBody(body);
        iServ.createIssue(rID, issue);
    }

    public static void main(String[] args) throws IOException {
        
    }
}