/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaboration;

import java.util.Collection;
import javax.swing.DefaultRowSorter;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.jfree.chart.ChartPanel;

/**
 *
 */
public class mainEngine {

    public void filterTable(JTable table, String filterText) {
        TableModel model = table.getModel();
        DefaultRowSorter sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
        RowFilter<DefaultTableModel, Object> rf = null;
        try {
            rf = RowFilter.regexFilter("(?i)" + filterText, 0);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
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
        teamTable.setModel(new DefaultTableModel(Backend.getInstance().getUserTableData(), new String[]{"UserID", "Name", "Phone", "Email", "Tasks"}));
    }

    public boolean validCredentials() {
        boolean validCreds = false;
        //TODO: set validCreds to true given valid credentials are entered will need to
        //be added here for testing sake validCreds will be set to true until implemented
        validCreds = true;
        return validCreds;
    }

    public void populateProjectComboBox(JComboBox projectComboBox) {
        Collection<Project> projects = Backend.getInstance().retrieveProjects();
        for (Project project : projects) {
            projectComboBox.addItem(project);
        }
    }

    public void setCurrentProject(Project project) {
        Backend.getInstance().setCurrentProject(project);
    }

    public void createUser(String[] textFieldInputs) {
        //TODO: Cam integrate backend to create user in database
    }

    public void deleteUser() {
        //TODO: Cam integrate backend to delete user from database
    }
}
