/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import Employee.NewClass;
import static Employee.NewClass.viso;
import Employee.Tekstas;
import Employee.linijinis;
import static Employee.loan.interest;
import static Employee.loan.loan;
import static Employee.loan.month;
import static Employee.loan.year;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Aukse
 */
    public class graphline extends JFrame {
    
    public graphline() throws IOException {

        initUI();
    }

    private void initUI() throws IOException {

        XYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Line chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
        private static DecimalFormat df = new DecimalFormat("0.00");
        private XYDataset createDataset() throws IOException{
                        XYSeries series = new XYSeries("Linear Payment graph(Fixed amount paid each month");
                        double monthlyInterestRate = interest / 1200;
        int viso = (int) year * 12 + (int) month;
        double kreditas = loan / (year * 12 + month);
        double zero[] = new double[viso + 1];
        double total[] = new double[viso + 1];
        linijinis ats = new linijinis();
        total[0] = ats.spausdinti();
        double principal[] = new double[viso + viso];
        principal[0] = (loan * monthlyInterestRate);
        for (int i = 0; i < viso; i++) {
            if (i == 0) {
                zero[i] = principal[i] + kreditas;
                series.add(i+1,total[i]-zero[i]);
                total[i] = (total[i] - zero[i]);
            } else {
                zero[i] = kreditas + (total[i - 1] * monthlyInterestRate);
                total[i] = (total[i - 1] - zero[i]);
                if(total[i]<0){
                    series.add(i,0);
                }
                else{
                series.add(i+1,total[i]);
                } 
            }
        }               
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        return dataset;
    }
    private JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Every month payment",
                "Month",
                "Monthly Payment",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle("Every month payment",
                        new Font("Serif", java.awt.Font.BOLD, 18)
                )
        );

        return chart;
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            graphline ex = null;
            try {
                ex = new graphline();
            } catch (IOException ex1) {
                Logger.getLogger(graphline.class.getName()).log(Level.SEVERE, null, ex1);
            }
            ex.setVisible(true);
            
        });
    }
}

