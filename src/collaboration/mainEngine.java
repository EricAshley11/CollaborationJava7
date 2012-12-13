/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaboration;

import collaborationjava7.common.*;
import com.google.gdata.util.ServiceException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultRowSorter;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.jfree.chart.ChartPanel;

/**
 *
 */
public class mainEngine {

    private int[] selectedTeamColumns = {0, 1, 2};
    private int[] selectedTasksColumns = {0, 1, 2, 3, 4, 5};
    private Calendar calendar;
    private User user;
    private Project selectedProj;

    public void filterTable(JTable table, String filterText) {
        TableModel model = table.getModel();
        DefaultRowSorter sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
        RowFilter<DefaultTableModel, Object> rf = null;
        try {
            int[] selectedColumns;
            if (table.getColumnCount() == 4) { //teamTable
                selectedColumns = selectedTeamColumns;
            } else {
                selectedColumns = selectedTasksColumns;
            }
            rf = RowFilter.regexFilter("(?i)" + filterText, selectedColumns);
        } catch (java.util.regex.PatternSyntaxException e) {
        }
        sorter.setRowFilter(rf);
    }

    public void setFilterColumns(boolean[] checkedBoxes) {
        int[] selectedColumns = new int[checkedBoxes.length];
        for (int i = 0, place = 0; i < checkedBoxes.length; i++) {
            if (checkedBoxes[i] == true) {
                selectedColumns[place] = i;
                place++;
            }
        }
        if (checkedBoxes.length == 3) { //teamTable
            selectedTeamColumns = selectedColumns;
        } else {
            selectedTasksColumns = selectedColumns;
        }
    }

    public void updateChart(JPanel progressPanel, JTable tasksTable) {
        progressJFreeChart progressChart = new progressJFreeChart();
        JPanel chartPanel = new ChartPanel(progressChart.createChart("Tasks Count by Team Member", tasksTable));
        chartPanel.setSize(progressPanel.getSize());
        try {
            progressPanel.remove(progressPanel.getComponent(0));
        } catch (Exception e) { //if no graph on progressPanel do nothing
        }
        progressPanel.add(chartPanel);
        progressPanel.getParent().validate();
    }

    public boolean addMember(JTable teamTable, String userString) {
        try {
            User user = ClientBackend.getInstance().getUser(userString);
            ClientBackend.getInstance().addUserToTeam(user, this.user.getTeam());
            this.loadTeamTable(teamTable);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removeMember(JTable teamTable) {
        boolean isAnyRowSelected = false;
        for (int i = 0; i < teamTable.getRowCount(); i++) {
            if (teamTable.isRowSelected(i)) {
                isAnyRowSelected = true;
            }
        }
        if (isAnyRowSelected) {
            DefaultTableModel model = (DefaultTableModel) teamTable.getModel();
            model.removeRow(teamTable.getSelectedRow());
            //do this in backend
            ClientBackend.getInstance().removeUser(model.getValueAt(teamTable.getSelectedRow(), 0).toString());
        }
        return isAnyRowSelected;
    }

    public boolean removeTask(JTable tasksTable) {
        boolean isAnyRowSelected = false;
        for (int i = 0; i < tasksTable.getRowCount(); i++) {
            if (tasksTable.isRowSelected(i)) {
                isAnyRowSelected = true;
            }
        }
        if (isAnyRowSelected) {
            DefaultTableModel model = (DefaultTableModel) tasksTable.getModel();
            model.removeRow(tasksTable.getSelectedRow());
            //do this in backend
            //Backend.getInstance().removeTask(model.getValueAt(teamTable.getSelectedRow(), 0).toString());
        }
        return isAnyRowSelected;
    }

    public void loadTeamTable(JTable teamTable) {
        teamTable.setModel(new javax.swing.table.DefaultTableModel(
                ClientBackend.getInstance().getUserTableData(selectedProj),
                new String[]{
                    "Username", "Phone", "Email", "Tasks"
                }) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };
            
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        teamTable.getTableHeader().setReorderingAllowed(false);
    }

    void loadTasksTable(JTable tasksTable) {
        tasksTable.setModel(new javax.swing.table.DefaultTableModel(
                ClientBackend.getInstance().getTasksTableData(selectedProj),
                new String[]{
                    "Lead", "User Story", "Task", "Status", "Estimated Duration (hr)", "Actual Duration (hr)"
                }) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false
            };
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tasksTable.getTableHeader().setReorderingAllowed(false);
    }

    public boolean validCredentials(String userName, String password) {
        boolean validCreds = false;
        User u = ClientBackend.getInstance().loginUser(userName, password);
        if (u != null) {
            validCreds = true;
            user = u;
        }
        return validCreds;
    }

    public void populateProjectComboBox(JComboBox projectComboBox) {
        projectComboBox.removeAllItems();
        ArrayList<Project> projects = ClientBackend.getInstance().retrieveUserProjects(user);
        for (Project project : projects) {
            projectComboBox.addItem(project);
        }
    }

    public Project createProject(String name) {
        return ClientBackend.getInstance().createProject(name, this.user);
    }

    public boolean createUser(JTextField[] textFields) {
        //textFields[0] is createUserUsernameTextField
        //textFields[1] is firstPasswordField
        //textFields[2] is confirmPasswordField
        //textFields[3] is createUserPhoneTextField
        //textFields[4] is createUserEmailTextField
        if (textFields[1].getText().equals(textFields[2].getText())) {
            ClientBackend.getInstance().createUser(textFields[0].getText(), textFields[1].getText(),
                    textFields[3].getText(), textFields[4].getText());
            return true;
        }
        return false;
    }

    public void deleteUser() {
        //TODO: Cam integrate backend to delete user from database
    }

    public boolean populateEditUserFields(JTable teamTable, JTextField[] textFields) {
        boolean isAnyRowSelected = false;
        for (int i = 0; i < teamTable.getRowCount(); i++) {
            if (teamTable.isRowSelected(i)) {
                isAnyRowSelected = true;
                break;
            }
        }
        if (isAnyRowSelected) {
            textFields[0].setText(teamTable.getValueAt(teamTable.getSelectedRow(), 0).toString());//name
            textFields[0].setEditable(false);
            textFields[1].setText(teamTable.getValueAt(teamTable.getSelectedRow(), 1).toString());//phoneNum
            textFields[2].setText(teamTable.getValueAt(teamTable.getSelectedRow(), 2).toString());//email
        }
        return isAnyRowSelected;
    }

    public boolean calendarLogin(String username, String password) {
        calendar = new Calendar();
        return calendar.validate(username, password);

    }

    public String printCalendars() {
        try {
            return calendar.printUserCalendars();
        } catch (ServiceException | IOException e) {
            e.printStackTrace();
            return "Unable to print!\n";
        }
    }

    public String printWeeklyAgenda() {
        try {
            return calendar.printWeeklyAgenda();
        } catch (ServiceException | IOException e) {
            e.printStackTrace();
            return "Unable to print!\n";
        }
    }

    public boolean createNewCalendar(String title, String description, String location) {
        boolean flag = false;
        if (calendar.createNewCalendar(title, description, location)) {
            flag = true;
        }
        return flag;
    }

    public void loadCalendarTable(JTable calendarTable) {
        try {
            calendarTable.setModel(new javax.swing.table.DefaultTableModel(
                    calendar.getUserCalendars(),
                    new String[]{
                        "Calendars"
                    }) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
            });
        } catch (ServiceException | IOException e) {
        }
    }
    
    void clearTable(JTable table) {
        table.setModel(new javax.swing.table.DefaultTableModel(
                    new String[0][0],
                    new String[0]) {
                public boolean isCellEditable() {
                    return false;
                }
            });
    }

    public boolean deleteCalendar(String name) {
        boolean flag = false;
        try {
            flag = calendar.deleteCalendar(name);
        } catch (ServiceException | IOException e) {
        }
        return flag;
    }

    boolean deleteEntry(String calendarName, String entryName) {
        boolean flag = false;
        try {
            flag = calendar.deleteEntryFromCalendar(calendarName, entryName);
        } catch (ServiceException | IOException e) {
        }
        return flag;
    }
    
    String displayEntryInfo(String calName, String entryName) {
        String result = "";
        try {
            result = calendar.displayEntryInfo(calName, entryName);
        } catch(ServiceException | IOException e) {
        }
        return result;
    }

    void setSeletedProj(Project proj) {
        this.selectedProj = proj;
    }

    public void loadCalendarEntryTable(JTable entryTable, String name) {
        try {
            entryTable.setModel(new javax.swing.table.DefaultTableModel(
                    calendar.getEntryData(name),
                    new String[]{
                        "Entries"
                    }) {
                public boolean isCellEditable() {
                    return false;
                }
            });
        } catch (ServiceException | IOException e) {
        }
    }

    void processProjectNameChanged(JComboBox projComboBox, String editedProjectName) {
        Project proj = (Project) projComboBox.getSelectedItem();
        if (editedProjectName.equals("DELETE")) {
            this.deleteProject(proj);
            projComboBox.removeItemAt(projComboBox.getSelectedIndex());
            projComboBox.setSelectedIndex(0);
        } else {
            this.editProjectName(proj, editedProjectName);
            projComboBox.getModel().setSelectedItem(proj);
        }
    }

    private void deleteProject(Project proj) {
        ClientBackend.getInstance().removeProject(proj);
    }

    private void editProjectName(Project proj, String editedProjectName) {
        ClientBackend.getInstance().editProjectName(proj, editedProjectName);
    }

    boolean userHasTeam() {
        if (user.getTeam() != null) {
            return true;
        }
        return false;
    }

    JComboBox<Team> createTeamComboBox(JComboBox teamBox) {
        teamBox.removeAllItems();
        for (Team team : ClientBackend.getInstance().getAllTeams()) {
            teamBox.addItem(team);
        }
        return teamBox;
//        ArrayList<Team> teamList = ClientBackend.getInstance().getAllTeams();
//        String[] retVal = new String[ClientBackend.getInstance().getAllTeams().size()];
//        for (int i = 0; i < teamList.size(); i++) {
//            retVal[i] = teamList.get(i).getName();
//        }
//        return retVal;
    }

    boolean loginTeam(Team team, String password) {
        if (ClientBackend.getInstance().loginTeam(team, password)) {
            addUserToTeam(team);
            return true;
        }
        return false;
    }

    void addUserToTeam(User user, Team team) {
        ClientBackend.getInstance().addUserToTeam(user, team);
    }

    void addUserToTeam(Team team) {
        addUserToTeam(user, team);
    }

    Team createTeam(String teamName, String password) {
        return ClientBackend.getInstance().createTeam(teamName, password);
    }

    void createProjectUsersComboBox(JComboBox comboBox) {
        comboBox.removeAllItems();
        for (User u : ClientBackend.getInstance().retrieveUsers(selectedProj)) {
            comboBox.addItem(u);
        }
    }

    Object[] getNewTaskRow(User lead, UserStory userStory, String taskName, String estimated, String description) {
        Task task = ClientBackend.getInstance().createTask(lead, userStory, taskName, Double.parseDouble(estimated), description);
        return task.toString().split(",");
    }

    void createProjectUserStoriesComboBox(JComboBox newTaskUserStoryComboBox) {
        newTaskUserStoryComboBox.removeAllItems();
        for (UserStory us : ClientBackend.getInstance().getUserStories(selectedProj)) {
            newTaskUserStoryComboBox.addItem(us);
        }
        if(newTaskUserStoryComboBox.getItemCount()==0){
            newTaskUserStoryComboBox.addItem(new UserStory("No User Stories, please add one."));
        }
    }

    UserStory createNewUserStory(String newStoryName, Milestone milestone) {
        return ClientBackend.getInstance().createUserStory(newStoryName, milestone);
    }

    Milestone createMilestone(String newMilestoneName) {
        return ClientBackend.getInstance().createMilestone(newMilestoneName, this.selectedProj.getSchedule());
    }

    boolean addNewEntry(String calendarName, String eventTitle, String eventDescription, String startDate, String endDate, String startTime, String endTime) {
        boolean flag = false;
        try {
            if (calendar.addEntryToCalendar(calendarName, eventTitle, eventDescription, startDate, endDate, startTime, endTime)) {
                flag = true;
            }
        } catch (ServiceException | IOException e) {
        }
        return flag;
    }

    void editUser(String name, String phone, String email) {
        User u = ClientBackend.getInstance().getUser(name);
        ClientBackend.getInstance().updateUser(user, phone, email);
    }

    void populateMilestoneComboBox(JComboBox milestoneComboBox) {
        milestoneComboBox.removeAllItems();
        for(Milestone ms : ClientBackend.getInstance().getMilestones(selectedProj)){
            milestoneComboBox.addItem(ms);
        }
        if(milestoneComboBox.getItemCount()==0){
            milestoneComboBox.addItem(new Milestone("No Milestones, please add one."));
        }
    }

    void createProjectUsersComboBox(JComboBox editTaskLeadComboBox, Task task) {
        this.createProjectUsersComboBox(editTaskLeadComboBox);
        editTaskLeadComboBox.setSelectedItem(task.getUser());
    }

    void createProjectUserStoriesComboBox(JComboBox editTaskUserStoryComboBox, Task task) {
        this.createProjectUserStoriesComboBox(editTaskUserStoryComboBox);
        editTaskUserStoryComboBox.setSelectedItem(task.getUserStory());
    }

    void populateStatusComboBox(JComboBox editTaskStatusComboBox, Task task) {
        editTaskStatusComboBox.removeAllItems();
        editTaskStatusComboBox.setModel(new DefaultComboBoxModel(Status.States.values()));
        editTaskStatusComboBox.setSelectedItem(task.getStatus().getState());
    }

    Task getTask(String taskName) {
        return ClientBackend.getInstance().getTasksTableData(this.selectedProj, taskName);
    }

    Task editTask(Task task, String name, User u, UserStory us, Status.States state,  double est, double actual, String description) {
        return ClientBackend.getInstance().editTask(task, name, u, us, state, est, actual, description);
    }
    ArrayList<UserStory> getUserStories(){
        return ClientBackend.getInstance().getUserStories(selectedProj);
    }

    boolean setMilestoneDates(Milestone selectedMS, String startDate, String endDate) {
        return ClientBackend.getInstance().setMilestoneDates(selectedMS, startDate, endDate);
    }

    void updateUSDescription(UserStory selectedUS, String description) {
        ClientBackend.getInstance().updateUSDescription(selectedUS, description);
    }

    void updateTaskDescription(Task selectedTask, String description) {
        ClientBackend.getInstance().updateTaskDescription(selectedTask, description);
    }

    ArrayList<Milestone> getMilestones() {
        return ClientBackend.getInstance().getMilestones(selectedProj);
    }

    static void saveServerAddr(String text) {
        try{
            FileWriter fw = new FileWriter("serverAddr.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(text);
            bw.close();
            loadServerAddr();
        }catch(Exception e){
            
        }        
    }
    static boolean loadServerAddr(){
        boolean retVal = false;
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("serverAddr.txt")));
            String serverAddr = br.readLine();
            if(serverAddr != null && serverAddr.isEmpty())
                return false;
            ClientBackend.setServerAddr(serverAddr);
            br.close();
            retVal = true;
        }catch(Exception e){
            
        }
        return retVal;
    }
}