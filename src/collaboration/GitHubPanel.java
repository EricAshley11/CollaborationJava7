/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaboration;

import collaborationjava7.common.GitHubManager;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author akie
 */
public class GitHubPanel extends javax.swing.JPanel {

    /**
     * Creates new form GitHubPanel
     */
    public GitHubPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GitHubRepoName = new javax.swing.JTextField();
        GitHubRepoOwner = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        GitHubNewsFeed = new javax.swing.JButton();
        GitHubBranches = new javax.swing.JButton();
        GitHubContribute = new javax.swing.JButton();
        GitHubGetIssues = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        GitHubRepoName2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        GitHubRepoOwner2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        GitHubUsername = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        GitHubPassword = new javax.swing.JTextField();
        GitHubIssueTitle = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        GitHubIssueBody = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        GitHubResultPane = new javax.swing.JTextPane();
        GitHubIssueReport = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(805, 486));

        jLabel1.setText("Repo Name");

        jLabel2.setText("Repo Owner Name");

        GitHubNewsFeed.setText("News Feed");
        GitHubNewsFeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GitHubNewsFeedActionPerformed(evt);
            }
        });

        GitHubBranches.setText("List Branches");
        GitHubBranches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GitHubBranchesActionPerformed(evt);
            }
        });

        GitHubContribute.setText("List Contributors");
        GitHubContribute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GitHubContributeActionPerformed(evt);
            }
        });

        GitHubGetIssues.setText("Get Issues");
        GitHubGetIssues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GitHubGetIssuesActionPerformed(evt);
            }
        });

        jLabel3.setText("Repo Name");

        jLabel4.setText("Repo Owner Name");

        jLabel5.setText("Username");

        jLabel6.setText("Password");

        jLabel7.setText("Issue Title");

        jLabel8.setText("Issue Body");

        GitHubIssueBody.setColumns(20);
        GitHubIssueBody.setRows(5);
        jScrollPane1.setViewportView(GitHubIssueBody);

        jScrollPane2.setViewportView(GitHubResultPane);

        GitHubIssueReport.setText("Report Issue");
        GitHubIssueReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GitHubIssueReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GitHubRepoName2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(GitHubRepoOwner2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(GitHubNewsFeed)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(GitHubBranches)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(GitHubContribute)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(GitHubGetIssues))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GitHubRepoName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(GitHubRepoOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(GitHubIssueTitle, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(GitHubUsername, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(GitHubPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(GitHubIssueReport)))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GitHubRepoName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GitHubRepoOwner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GitHubNewsFeed)
                            .addComponent(GitHubBranches)
                            .addComponent(GitHubContribute)
                            .addComponent(GitHubGetIssues))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(GitHubRepoName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(GitHubRepoOwner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(GitHubUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(GitHubPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addGap(9, 9, 9)
                                .addComponent(GitHubIssueTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(GitHubIssueReport))
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void GitHubNewsFeedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GitHubNewsFeedActionPerformed
        GitHubManager GHM = new GitHubManager();
        try {
            GHM.newsFeed(GitHubRepoName.getText(),GitHubRepoOwner.getText());
        } catch (IOException ex) {
            Logger.getLogger(GitHubPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_GitHubNewsFeedActionPerformed

    private void GitHubBranchesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GitHubBranchesActionPerformed
        GitHubManager GHM = new GitHubManager();
        try {
            GHM.getBranches(GitHubRepoName.getText(),GitHubRepoOwner.getText());
        } catch (IOException ex) {
            Logger.getLogger(GitHubPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_GitHubBranchesActionPerformed

    private void GitHubContributeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GitHubContributeActionPerformed
        GitHubManager GHM = new GitHubManager();
        try {
            GHM.getContributors(GitHubRepoName.getText(),GitHubRepoOwner.getText());
        } catch (IOException ex) {
            Logger.getLogger(GitHubPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_GitHubContributeActionPerformed

    private void GitHubGetIssuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GitHubGetIssuesActionPerformed
        GitHubManager GHM = new GitHubManager();
        try {
            GHM.getIssues(GitHubRepoName.getText(),GitHubRepoOwner.getText());
        } catch (IOException ex) {
            Logger.getLogger(GitHubPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_GitHubGetIssuesActionPerformed

    private void GitHubIssueReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GitHubIssueReportActionPerformed
        GitHubManager GHM = new GitHubManager();
        try {
            GHM.createIssue(GitHubRepoName2.getText(),GitHubRepoOwner2.getText(),GitHubUsername.getText()
                    ,GitHubPassword.getText(),GitHubIssueTitle.getText(),GitHubIssueBody.getText());
        } catch (IOException ex) {
            Logger.getLogger(GitHubPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_GitHubIssueReportActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GitHubBranches;
    private javax.swing.JButton GitHubContribute;
    private javax.swing.JButton GitHubGetIssues;
    private javax.swing.JTextArea GitHubIssueBody;
    private javax.swing.JButton GitHubIssueReport;
    private javax.swing.JTextField GitHubIssueTitle;
    private javax.swing.JButton GitHubNewsFeed;
    private javax.swing.JTextField GitHubPassword;
    private javax.swing.JTextField GitHubRepoName;
    private javax.swing.JTextField GitHubRepoName2;
    private javax.swing.JTextField GitHubRepoOwner;
    private javax.swing.JTextField GitHubRepoOwner2;
    private javax.swing.JTextPane GitHubResultPane;
    private javax.swing.JTextField GitHubUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
