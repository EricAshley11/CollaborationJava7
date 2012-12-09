package collaboration;

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
    public JFreeChart createChart(String title) {
        JFreeChart chart = ChartFactory.createPieChart(title, // chart title
                createDataset(), // data
                true, // include legend
                true,
                false);
//ChartFactory.createp
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return chart;

    }

    /**
     * Creates a sample dataset
     */
    private PieDataset createDataset() {
        DefaultPieDataset result = new DefaultPieDataset();
        result.setValue("Cam", 95);
        result.setValue("Eric", 4);
        result.setValue("Everyone else", 1);
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
