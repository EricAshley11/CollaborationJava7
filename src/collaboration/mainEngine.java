/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaboration;

import javax.swing.DefaultRowSorter;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author Eric
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

    public boolean deleteUser(JTable teamTable) {
        boolean isAnyRowSelected = false;
        for (int i = 0; i < teamTable.getRowCount(); i++) {
            if (teamTable.isRowSelected(i)) {
                isAnyRowSelected = true;
            }
        }
        if (isAnyRowSelected) {
            DefaultTableModel model = (DefaultTableModel) teamTable.getModel();
            model.removeRow(teamTable.getSelectedRow());
            model.getValueAt(teamTable.getSelectedRow(), 0);
            //do this in backend
            //Backend.getInstance().removeUser(model.getValueAt(teamTable.getSelectedRow(), 0).toString());
            return true;
        } else {
            return false;
        }
    }
}
