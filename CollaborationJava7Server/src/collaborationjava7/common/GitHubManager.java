/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7.common;

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

    


    public String getBranches(String reponame, String ownerUsername) throws IOException {
        RepositoryService rServ = new RepositoryService();
        RepositoryId rID = new RepositoryId(ownerUsername, reponame);
        String results ="";
        List<RepositoryBranch> l = rServ.getBranches(rID);
        for (int i = 0; i < l.size(); i++) {
            results+=rServ.getBranches(rID).get(i).getName()+ "\n";
        }
        return results;
    }

    public String getContributors(String reponame, String ownerUsername) throws IOException {
        RepositoryService rServ = new RepositoryService();
        RepositoryId rID = new RepositoryId(ownerUsername, reponame);
        String results="";
        List<Contributor> l = rServ.getContributors(rID, false);
        for (int i = 0; i < l.size(); i++) {
            results += rServ.getContributors(rID, false).get(i).getLogin()+"\n";
        }
        return results;
    }

    public String getIssues(String reponame, String ownerUsername) throws IOException {
        IssueService iServ = new IssueService();
        RepositoryId rID = new RepositoryId(ownerUsername, reponame);
        String results = "";
        List<Issue> l = iServ.getIssues(rID, null);
        for (int i = 0; i < l.size(); i++) {
            Issue issue = iServ.getIssues(rID, null).get(i);
            results += "Issue Title: " + issue.getTitle()+"\n";
            results +="Issue Body: " + issue.getBody()+"\n";
            results +="Submitted By: "+issue.getUser().getLogin()+"\n \n";
        }
        return results;
    }

    public void createIssue(String username, String password, String reponame, String repoOwner, String title, String body) throws IOException {
        GitHubClient client = new GitHubClient();
        client.setCredentials(username, password);
        IssueService iServ = new IssueService(client);
        RepositoryId rID = new RepositoryId(repoOwner, reponame);
        Issue issue = new Issue();
        issue.setTitle(title);
        issue.setBody(body);
        iServ.createIssue(rID, issue);
    }

    public String newsFeed(String reponame, String ownerUsername) throws IOException{
        CommitService cServ = new CommitService();
        RepositoryId rID = new RepositoryId(ownerUsername,reponame);
        String results ="";
        List<RepositoryCommit> commit = cServ.getCommits(rID);
        for (int i = 0; i < commit.size();i++){
        results +=commit.get(i).getCommit().getCommitter().getName()+ " commited" + "\n" + commit.get(i).getCommit().getMessage() 
                + " on \n" + commit.get(i).getCommit().getCommitter().getDate() + "\n \n";
        }
        return results;
    }
    public static void main(String[] args) throws IOException {
        
    }
}