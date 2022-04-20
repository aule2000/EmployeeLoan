package graphs;

import Employee.NewClass;
import Employee.Tekstas;

import static Employee.Tekstas.viso;
import Employee.loan;
import static Employee.loan.interest;
import static Employee.loan.month;
import static Employee.loan.year;
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

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.IOException;
import static java.lang.Math.abs;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewFXMain extends JFrame {

    public NewFXMain() throws IOException {

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

    public XYDataset createDataset() throws IOException {
        XYSeries series = new XYSeries("Linear Payment graph(Fixed amount paid each month");
        viso = (int) year * 12 + (int) month;
        NewClass y = new NewClass();
       double payment[] = new double[viso + 1];
        payment[1] = y.getMonthlyPayment(interest);
        double total[] = new double[viso + 1];
      
        total[1] = y.getTotalPayment();
        
        for (int i = 1; i <= viso; i++) {
            if (i == 1) {
                series.add(i, total[i] - payment[1]);
                total[i] = (total[i] - payment[1]);
            } else {
                payment[i] = payment[i - 1] + payment[1];

                total[i] = (total[i - 1] - payment[1]);
                series.add(i, total[i]);
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

            NewFXMain ex = null;
            try {
                ex = new NewFXMain();
            } catch (IOException ex1) {
                Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex1);
            }
            ex.setVisible(true);

        });
    }
}
