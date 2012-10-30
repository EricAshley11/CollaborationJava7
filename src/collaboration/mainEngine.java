/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaboration;

import java.util.ArrayList;
import java.util.Collection;
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
            DefaultTableModel model = (DefaultTableModel) teamTable.getModel();
            //User user = Backend.getInstance().getUserFromName(userString);
            //model.addRow(new Object[]{userString, user.getName(), user.getPhoneNum(), user.getEmail()});
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
            //Backend.getInstance().removeUser(model.getValueAt(teamTable.getSelectedRow(), 0).toString());
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
                Backend.getInstance().getUserTableData(),
                new String[]{
                    "Username", "Full Name", "Phone", "Email", "Tasks"
                }) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
    }

    public boolean validCredentials() {
        boolean validCreds = false;
        //TODO: set validCreds to true given valid credentials are entered will need to
        //be added here for testing sake validCreds will be set to true until implemented
        validCreds = true;
        return validCreds;
    }

//    public void populateProjectComboBox(JComboBox projectComboBox) {
//        Collection<Project> projects = Backend.getInstance().retrieveProjects();
//        for (Project project : projects) {
//            projectComboBox.addItem(project);
//        }
//    }
//
//    public void setCurrentProject(Project project) {
//        Backend.getInstance().setCurrentProject(project);
//    }
    public void createUser(JTextField[] textFields) {
        //TODO: Cam integrate backend to create user in database
    }

    public void deleteUser() {
        //TODO: Cam integrate backend to delete user from database
    }

    public boolean editUser(JTable teamTable, JTextField[] textFields) {
        boolean isAnyRowSelected = false;
        for (int i = 0; i < teamTable.getRowCount(); i++) {
            if (teamTable.isRowSelected(i)) {
                isAnyRowSelected = true;
            }
        }
        if (isAnyRowSelected) {
            textFields[0].setText(teamTable.getValueAt(teamTable.getSelectedRow(), 0).toString());
            textFields[1].setText(teamTable.getValueAt(teamTable.getSelectedRow(), 1).toString());
            textFields[2].setText(teamTable.getValueAt(teamTable.getSelectedRow(), 2).toString());
        }
        return isAnyRowSelected;
    }
}
