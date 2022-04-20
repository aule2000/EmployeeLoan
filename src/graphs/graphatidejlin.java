/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import Employee.Frame;
import Employee.NewClass;
import static Employee.NewClass.viso;
import static Employee.NewClass.viso1;
import Employee.atidejimas;
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
public class graphatidejlin extends JFrame {
    
    public graphatidejlin() throws IOException {

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
            private XYDataset createDataset()  {
                XYSeries series = new XYSeries("Linear Payment graph(Fixed amount paid each month");
                         Frame z = new Frame();
        atidejimas y = new atidejimas();
        NewClass kas = new NewClass();
        int i = 1;
        int j;
        double monthlyInterestRate = interest / 1200;
        double monthlyInterestRate1 = z.palukana / 1200;
        double c = kas.getMonthlyPayment(interest);
        double kreditas = loan / (year * 12 + month);
        int viso = (((int) year * 12 + (int) month) + ((int) z.iki1 - (int) z.nuo1));
        double endingbalance[] = new double[viso + viso];
        endingbalance[1] = (loan - kreditas);
        double palukanos1[] = new double[viso + viso];
        palukanos1[1] = loan * monthlyInterestRate1;
        double interestar[] = new double[viso + viso];
        interestar[1] = (loan * monthlyInterestRate);
        double sum1 = 0;
        double principal[] = new double[viso + viso];
        principal[1] = kreditas;
        double ats = 0;
        double payment[] = new double[viso + viso+viso];
        payment[1] = interestar[1]+kreditas;
        linijinis as = new linijinis();
        double kas1[] = new double[viso + viso+viso];
        
        double total[] = new double[viso+viso+viso];
        
        try {
            total[1] = as.spausdinti();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        kas1[1]=total[1]-payment[1];
        double total1[] = new double[viso+viso+viso];
        
        while (endingbalance[i] >= 0) {
            if (i == 1 && i == (int) z.nuo1) {
                principal[i] =kreditas;
                endingbalance[i] =loan-kreditas; 
                palukanos1[i] = palukanos1[1];
                total[i] = total[1] - palukanos1[1];
              series.add(i,total[i]); 
                sum1++;
                viso1++;
            } else if (i == 1) {
                principal[i] = kreditas;
                endingbalance[i] = loan-kreditas;
                
                payment[i] = payment[1];
                total[i] = total[1] - payment[i];
                total1[1]=total[i];
             series.add(i,total[i]); 
                viso1++;
            } else if (sum1 == 1 && (i == 2)) {
                sum1++;
                for (j = 2; j <= (int) z.iki1; j++) {
                    palukanos1[i] = palukanos1[i - 1] + palukanos1[1];
                    total[i] = total[i - 1] - palukanos1[1];
                    series.add(j,total[i]);
                    
                    endingbalance[i]=endingbalance[i-1]-kreditas;
                    i++;
                    
                    viso1++;
                }
                
                i--;
                
            } else if (i == (int) z.nuo1) {
                ats++;
                for (j = (int) z.nuo1; j <= (int)z.iki1; j++) {
                    if (j == z.nuo1) {
                        palukanos1[i] = payment[i - 1] + palukanos1[1];
                        total[i] = total[i - 1] - palukanos1[1];
                        series.add(j,total[i]);
                        viso1++;
                    } else {
                        palukanos1[i] = palukanos1[i - 1] + palukanos1[1];
                        total[i] = total[i - 1] - palukanos1[1];
                       series.add(j,total[i]);
                        viso1++;
                    }
                    i++;
                }
                i--;
            } else if ((sum1 == 2 && i == z.iki1 + 1)) {
                principal[i] = kreditas;

                
                endingbalance[i] =  loan - kreditas;
                payment[i] = palukanos1[i - 1] + payment[1];
                total[i] = total[i - 1] - payment[1];
                series.add(i,total[i]);
                viso1++;
            }
            else if(ats == 1 && i == z.iki1 +1){
                principal[i] = kreditas;
                endingbalance[i] = loan - kreditas;
                payment[i]= palukanos1[i-1] + kreditas +(total1[1]*monthlyInterestRate);
                total[i]=total[i-1]-(kreditas +(total1[1]*monthlyInterestRate));
                 series.add(i,total[i]);
                viso1++;
            }
            else {
                principal[i] = kreditas;
                endingbalance[i] = (endingbalance[i - 1] - principal[i]);

                if (c > total[i - 1]) {
                    payment[i] = payment[i - 1] + total[i - 1];
                    total[i] = total[i - 1] - total[i - 1];
                    series.add(i,total[i]);
                    viso1++;
                    break;
                } else {
                    if(i == z.iki1+2){
                        kas1[i]=kas1[1];
                        payment[i] = payment[i-1]+ kreditas + kas1[i]*monthlyInterestRate;
                        total[i] = total[i - 1] - (kreditas + kas1[i]*monthlyInterestRate);
                        viso1++;
                        series.add(i,total[i]);
                        kas1[i]= kas1[i]-(kreditas + kas1[i]*monthlyInterestRate);
                    }
                    else{
                    payment[i] = payment[i-1]+ kreditas + (kas1[i-1]*monthlyInterestRate);
                    total[i] = total[i - 1] - (kreditas + (kas1[i-1]*monthlyInterestRate));
                    viso1++;
                    series.add(i,total[i]);
                    kas1[i] = kas1[i-1] -(kreditas + kas1[i-1]*monthlyInterestRate);
                }}
            }
            i++;
        }
         
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        return dataset;
    }

    private JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Every month payment",
                "Month",
                "Payment",
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

            graph ex = null;
            try {
                ex = new graph();
            } catch (IOException ex1) {
                Logger.getLogger(graph.class.getName()).log(Level.SEVERE, null, ex1);
            }
            ex.setVisible(true);
        });
    }
}