package collaboration;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

/**
 *
 */
public class progressJFreeChart {

    /**
     * Creates a chart
     */
    public JFreeChart createChart(String title, JTable tasksTable, ArrayList<String> teamMembers) throws IOException {
        JFreeChart chart = ChartFactory.createPieChart(title, // chart title
                createDataset(tasksTable, teamMembers), // data
                true, // include legend
                true,
                false);
//ChartFactory.createp
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setStartAngle(0);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        plot.setBackgroundAlpha(0.0f);
        return chart;

    }

    /**
     * Creates a sample dataset
     */
    private PieDataset createDataset(JTable tasksTable, ArrayList<String> teamMembers) {
        String lead;
        ArrayList<String> leads = teamMembers;
        double[] count = new double[leads.size()];
        for (int i = 0; i < tasksTable.getRowCount(); i++) {
            if (!tasksTable.getValueAt(i, 3).equals("Complete")) {
                lead = (String) tasksTable.getValueAt(i, 0);
                int indexOfValue = leads.indexOf((Object) lead);
//            if (indexOfValue == -1) { // IS NOT found in list of leads
//                leads.add(lead);
//                count.add(1);
//            } else { // IS found in list of leads
                count[i] = count[indexOfValue] + Double.parseDouble((String) tasksTable.getValueAt(i, 4)); //increase count of times found by 1
//            }
            }
        }
        DefaultPieDataset result = new DefaultPieDataset();
        for (int i = 0; i < leads.size(); i++) {
            result.setValue(leads.get(i), count[i]);
        }
//        result.setValue("test", 0);
//        result.setValue("Eric", 4);
//        result.setValue("Everyone else", 1);
        return result;
    }
//
//        DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();
//
//        //Enrollment in Bachelors level
//        categoryDataset.setValue(3, "Group 1", "9/12");
//        categoryDataset.setValue(7, "Group 1", "9/13");
//        categoryDataset.setValue(2, "Group 1", "9/14");
//        categoryDataset.setValue(10, "Group 1", "9/15");
//
//        //Enrollment in Masters level
//        categoryDataset.setValue(6, "Group 2", "9/12");
//        categoryDataset.setValue(5, "Group 2", "9/13");
//        categoryDataset.setValue(5, "Group 2", "9/14");
//        categoryDataset.setValue(14, "Group 2", "9/15");
//
//        //Enrollment in PhD level
//        categoryDataset.setValue(10, "Group 3", "9/12");
//        categoryDataset.setValue(11, "Group 3", "9/13");
//        categoryDataset.setValue(8, "Group 3", "9/14");
//        categoryDataset.setValue(9, "Group 3", "9/15");
//
//        JFreeChart chart = ChartFactory.createBarChart3D("Test Graph - Collaboration", // Title
//                "Date", // X-Axis label
//                "Tasks Completed",// Y-Axis label
//                categoryDataset, // Dataset
//                PlotOrientation.VERTICAL,
//                true, // Show legend
//                true,
//                false);
//
//        return chart;
//    }
//    public void saveChart(JFreeChart chart)
//    {
//        String fileName="C:/Users/Eric/Desktop/myCategoryChart.jpg";
//        try {
//            /**
//             * This utility saves the JFreeChart as a JPEG
//             * First Parameter: FileName
//             * Second Parameter: Chart To Save
//             * Third Parameter: Height Of <span id="IL_AD10" class="IL_AD">Picture</span>
//             * Fourth Parameter: Width Of Picture
//             */
//        ChartUtilities.saveChartAsJPEG(new File(fileName), chart, 800, 600);
//    } catch (IOException e) {
//        e.printStackTrace();
//        System.err.println("Problem occurred creating chart.");
//    }
//    }
}
