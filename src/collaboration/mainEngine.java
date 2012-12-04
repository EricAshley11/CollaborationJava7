/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaboration;

import collaborationjava7.common.*;
import com.google.gdata.util.ServiceException;
import java.io.IOException;
import java.util.ArrayList;
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

    private int[] selectedTeamColumns = {0, 1, 2, 3};
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
        if (checkedBoxes.length == 4) { //teamTable
            selectedTeamColumns = selectedColumns;
        } else {
            selectedTasksColumns = selectedColumns;
        }
    }

    public void updateChart(JPanel progressPanel) {
        progressJFreeChart progressChart = new progressJFreeChart();
        JPanel chartPanel = new ChartPanel(progressChart.createChart());
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
    }

    void loadTasksTable(JTable tasksTable) {
        tasksTable.setModel(new javax.swing.table.DefaultTableModel(
                ClientBackend.getInstance().getTasksTableData(selectedProj),
                new String[]{
                    "Lead", "User Story", "Task", "Status", "Estimated Completion", "Actual Completion"
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
        //textFields[3] is createUserNameTextField
        //textFields[4] is createUserPhoneTextField
        //textFields[5] is createUserEmailTextField
        if (textFields[1].getText().equals(textFields[2].getText())) {
            ClientBackend.getInstance().createUser(textFields[0].getText(), textFields[1].getText(),
                    textFields[4].getText(), textFields[5].getText());
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
                public boolean isCellEditable() {
                    return false;
                }
            });
        } catch (ServiceException | IOException e) {
        }
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

    Object[] getNewTaskRow(User lead, UserStory userStory, String taskName, String estimated, String actual) {
        Task task = ClientBackend.getInstance().createTask(lead, userStory, taskName, Integer.parseInt(estimated), Integer.parseInt(actual));
        return task.toString().split(",");
    }

    void createProjectUserStoriesComboBox(JComboBox newTaskUserStoryComboBox) {
        newTaskUserStoryComboBox.removeAllItems();
        for (UserStory us : ClientBackend.getInstance().getUserStories(selectedProj)) {
            newTaskUserStoryComboBox.addItem(us);
        }
    }

    UserStory createNewUserStory(String storyName) {
        //TODO: MAKE THIS WORK
        return null;
    }

    Milestone createMilestone(String milestoneName) {
        //TODO: MAKE THIS WORK
        return null;
    }

    boolean addNewEntry(String calendarName, String eventTitle, String eventDescription, int startTime, int endTime) {
        boolean flag = false;
        try {
            if (calendar.addEntryToCalendar(calendarName, eventTitle, eventDescription, startTime, endTime)) {
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
}
