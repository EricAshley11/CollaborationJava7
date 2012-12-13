/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UserStoryPanel.java
 *
 * Created on Dec 11, 2012, 1:35:43 AM
 */
package collaboration;

import collaborationjava7.common.Milestone;
import collaborationjava7.common.Task;
import collaborationjava7.common.UserStory;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Cam
 */
public class UserStoryPanel extends javax.swing.JPanel {
    
    /** Creates new form UserStoryPanel */
    public UserStoryPanel() {
        initComponents();
    }
    public UserStoryPanel(mainView parent){
        this.parent = parent;
        initComponents();
    }
    Task selectedTask=null;
    UserStory selectedUS=null;
    Milestone selectedMS=null;
    mainView parent = null;
    
    
    private ArrayList<Task> getTasks(){
        if(selectedUS != null){
            return selectedUS.getTasks();
        }
        return new ArrayList<Task>();
    }
    private ArrayList<Milestone> getMilestones(){
        ArrayList<Milestone> retVal = null;
        try{
            retVal = mainView.engine.getMilestones();
        }catch(Exception e){
            retVal = new ArrayList<Milestone>();
        }
        return retVal;
    }
    
    private ArrayList<UserStory> getUserStories() {
        ArrayList<UserStory> retVal = null;
        try{
            retVal = selectedMS.getUserStories();
        }
        catch(Exception e){
            retVal = new ArrayList<UserStory>();
        }
        return retVal;
    }
    public void updateComponents(boolean reset){
        if(reset){
            selectedMS = null;
            selectedUS = null;
            selectedTask = null;
        }
        this.userStoryList.removeAll();
        this.userStoryList.setModel(new USListModel());
        this.taskList.removeAll();
        this.taskList.setModel(new TaskListModel());
        this.milestoneList.removeAll();
        this.milestoneList.setModel(new MSListModel());
        //selectedMS = (Milestone)milestoneList.getSelectedValue();
        if(selectedMS != null){
            this.msStartTextBox.setText(selectedMS.startDateToString());
            this.msEndTextBox.setText(selectedMS.endDateToString());
        }else{
            this.msStartTextBox.setText("");
            this.msEndTextBox.setText("");
        }
        //selectedUS =(UserStory)userStoryList.getSelectedValue();
        if(selectedUS != null)
            this.userStoryTextBox.setText(selectedUS.getDescription());
        else
            this.userStoryTextBox.setText("");
        if(selectedTask != null)
            this.taskTextBox.setText(selectedTask.getDescription());
        else
            this.taskTextBox.setText("");
    }
    
    private class MSListModel extends AbstractListModel{
        ArrayList<Milestone> milestones = getMilestones();
        public int getSize() { return milestones.size(); }
        public Milestone getElementAt(int i) { return milestones.get(i); }
        public void update(){
            milestones = getMilestones();
        }
    }
    private class TaskListModel extends AbstractListModel{
        ArrayList<Task> tasks = getTasks();
        public int getSize() { return tasks.size(); }
        public Task getElementAt(int i) { return tasks.get(i); }
        public void update(){
            tasks = getTasks();
        }
    }
    private class USListModel extends AbstractListModel{
        ArrayList<UserStory> userStories = getUserStories();
        public int getSize() { return userStories.size(); }
        public UserStory getElementAt(int i) { return userStories.get(i); }
        public void update(){
            userStories = getUserStories();
        }
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        userStoryList = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        taskList = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        userStoryTextBox = new javax.swing.JEditorPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        taskTextBox = new javax.swing.JEditorPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        usDescriptSaveButton = new javax.swing.JButton();
        taskDescriptSaveButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        milestoneList = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        msStartTextBox = new javax.swing.JTextField();
        msEndTextBox = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        milestoneSaveButton = new javax.swing.JButton();

        userStoryList.setBackground(new java.awt.Color(204, 204, 204));
        userStoryList.setModel(new USListModel());
        userStoryList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        userStoryList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                userStoryListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(userStoryList);

        taskList.setBackground(new java.awt.Color(204, 204, 204));
        taskList.setModel(new TaskListModel());
        taskList.setCellRenderer(new ListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = new JLabel();
                label.setOpaque(true);
                if (isSelected) {
                    label.setBackground(list.getSelectionBackground());
                    label.setForeground(list.getSelectionForeground());
                }
                else {
                    label.setBackground(list.getBackground());
                    label.setForeground(list.getForeground());
                }
                label.setText(((Task)value).getName());
                Border border = null;
                if (cellHasFocus) {
                    if (isSelected) {
                        border = UIManager.getBorder("List.focusSelectedCellHighlightBorder");
                    }
                    if (border == null) {
                        border = UIManager.getBorder("List.focusCellHighlightBorder");
                    }
                } else {
                    border = new EmptyBorder(1, 1, 1, 1);
                }
                label.setBorder(border);
                return label;
            }
        });
        taskList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        taskList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taskListMouseClicked(evt);
            }
        });
        taskList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                taskListValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(taskList);

        jScrollPane2.setViewportView(userStoryTextBox);

        jScrollPane4.setViewportView(taskTextBox);

        jLabel1.setText("User Stories");

        jLabel2.setText("Description");

        jLabel3.setText("Tasks");

        jLabel4.setText("Description");

        usDescriptSaveButton.setText("Save");
        usDescriptSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usDescriptSaveButtonActionPerformed(evt);
            }
        });

        taskDescriptSaveButton.setText("Save");
        taskDescriptSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskDescriptSaveButtonActionPerformed(evt);
            }
        });

        milestoneList.setBackground(new java.awt.Color(204, 204, 204));
        milestoneList.setModel(new MSListModel());
        milestoneList.setCellRenderer(new ListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = new JLabel();
                label.setOpaque(true);
                if (isSelected) {
                    label.setBackground(list.getSelectionBackground());
                    label.setForeground(list.getSelectionForeground());
                }
                else {
                    label.setBackground(list.getBackground());
                    label.setForeground(list.getForeground());
                }
                label.setText(((Milestone)value).getName());
                Border border = null;
                if (cellHasFocus) {
                    if (isSelected) {
                        border = UIManager.getBorder("List.focusSelectedCellHighlightBorder");
                    }
                    if (border == null) {
                        border = UIManager.getBorder("List.focusCellHighlightBorder");
                    }
                } else {
                    border = new EmptyBorder(1, 1, 1, 1);
                }
                label.setBorder(border);
                return label;
            }
        });
        milestoneList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                milestoneListValueChanged(evt);
            }
        });
        jScrollPane5.setViewportView(milestoneList);

        jLabel5.setText("Milestones");

        jLabel6.setText("Start Date (MM/DD/YYYY)");

        jLabel7.setText("End Date (MM/DD/YYYY)");

        milestoneSaveButton.setText("Save");
        milestoneSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                milestoneSaveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(msStartTextBox, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(milestoneSaveButton, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(msEndTextBox, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(usDescriptSaveButton))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(taskDescriptSaveButton))
                            .addComponent(jLabel4))))
                .addContainerGap(213, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel6)
                        .addGap(5, 5, 5)
                        .addComponent(msStartTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(msEndTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(milestoneSaveButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(usDescriptSaveButton)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(taskDescriptSaveButton))
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void userStoryListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_userStoryListValueChanged
        UserStory newUS = (UserStory)this.userStoryList.getSelectedValue();
        if(newUS != null){
            selectedUS = newUS;
            this.userStoryTextBox.setText(selectedUS.getDescription());
            this.taskTextBox.setText("");
        }
        else
            this.userStoryTextBox.setText("");
        this.taskList.setModel(new TaskListModel());
    }//GEN-LAST:event_userStoryListValueChanged

    private void taskListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_taskListValueChanged
        Task newTask = (Task)this.taskList.getSelectedValue();
        if(newTask != null){
            selectedTask = newTask;
            this.taskTextBox.setText(selectedTask.getDescription());
        }
    }//GEN-LAST:event_taskListValueChanged

    private void taskDescriptSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taskDescriptSaveButtonActionPerformed
        if(selectedTask != null){
            String description = this.taskTextBox.getText();
            mainView.engine.updateTaskDescription(selectedTask, description);
        }
    }//GEN-LAST:event_taskDescriptSaveButtonActionPerformed

    private void usDescriptSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usDescriptSaveButtonActionPerformed
        if(selectedUS != null){
            String description = this.userStoryTextBox.getText();
            mainView.engine.updateUSDescription(selectedUS, description);
        }
    }//GEN-LAST:event_usDescriptSaveButtonActionPerformed

    private void milestoneListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_milestoneListValueChanged
        Milestone newMS =(Milestone)this.milestoneList.getSelectedValue();
        if(newMS != null && newMS != selectedMS){
            selectedMS = newMS;
            this.msStartTextBox.setText(selectedMS.startDateToString());
            this.msEndTextBox.setText(selectedMS.endDateToString());
            this.taskTextBox.setText("");
            this.userStoryTextBox.setText("");
            this.selectedTask = null;
            this.selectedUS = null;
            this.userStoryList.setModel(new USListModel());
            this.taskList.setModel(new TaskListModel());
        }else{
            
        }
    }//GEN-LAST:event_milestoneListValueChanged

    private void milestoneSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_milestoneSaveButtonActionPerformed
        if(this.selectedMS != null){
            if(mainView.engine.setMilestoneDates(this.selectedMS, this.msStartTextBox.getText(), this.msEndTextBox.getText())){
                this.updateComponents(false);
            }
            else{
                JOptionPane.showMessageDialog(this, "The dates that you entered are invalid.  Please follow the correct format and ensure the start date is before the end date.", "Invalid dates", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_milestoneSaveButtonActionPerformed

    private void taskListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taskListMouseClicked
        if(evt.getClickCount()==2){
            if(parent != null){
                parent.filterTasks(this.selectedTask.getName());
            }
        }
    }//GEN-LAST:event_taskListMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList milestoneList;
    private javax.swing.JButton milestoneSaveButton;
    private javax.swing.JTextField msEndTextBox;
    private javax.swing.JTextField msStartTextBox;
    private javax.swing.JButton taskDescriptSaveButton;
    private javax.swing.JList taskList;
    private javax.swing.JEditorPane taskTextBox;
    private javax.swing.JButton usDescriptSaveButton;
    private javax.swing.JList userStoryList;
    private javax.swing.JEditorPane userStoryTextBox;
    // End of variables declaration//GEN-END:variables
}
