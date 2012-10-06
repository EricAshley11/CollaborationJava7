/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaboration;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author EricA
 */
public class progressJFreeChart {

    public JFreeChart createChart() {

        DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();

        //Enrollment in Bachelors level
        categoryDataset.setValue(3, "Group 1", "9/12");
        categoryDataset.setValue(7, "Group 1", "9/13");
        categoryDataset.setValue(2, "Group 1", "9/14");
        categoryDataset.setValue(10, "Group 1", "9/15");

        //Enrollment in Masters level
        categoryDataset.setValue(6, "Group 2", "9/12");
        categoryDataset.setValue(5, "Group 2", "9/13");
        categoryDataset.setValue(5, "Group 2", "9/14");
        categoryDataset.setValue(14, "Group 2", "9/15");

        //Enrollment in PhD level
        categoryDataset.setValue(10, "Group 3", "9/12");
        categoryDataset.setValue(11, "Group 3", "9/13");
        categoryDataset.setValue(8, "Group 3", "9/14");
        categoryDataset.setValue(9, "Group 3", "9/15");

        JFreeChart chart = ChartFactory.createBarChart3D("Test Graph - Collaboration", // Title
                "Date", // X-Axis label
                "Tasks Completed",// Y-Axis label
                categoryDataset, // Dataset
                PlotOrientation.VERTICAL,
                true, // Show legend
                true,
                false);

        return chart;
    }
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
