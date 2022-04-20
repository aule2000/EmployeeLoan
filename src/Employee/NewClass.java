package Employee;

import static Employee.loan.interest;
import static Employee.loan.loan;
import static Employee.loan.month;
import static Employee.loan.year;
import graphs.NewFXMain;
import java.awt.datatransfer.SystemFlavorMap;
import java.io.BufferedWriter;
import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class NewClass {

    loan g = new loan();
    public static int viso;
    public static int viso1;
    private double monthlyInterestRate;

    public double getMonthlyPayment(double monthlyInterestRate) {
        this.monthlyInterestRate = monthlyInterestRate / 1200;
        double monthlyPayment = g.loan * this.monthlyInterestRate / (1 - (1 / Math.pow(1 + this.monthlyInterestRate, ((g.year * 12) + g.month))));
        return monthlyPayment;
    }

    public double getTotalPayment() {
        double totalPayment = getMonthlyPayment(g.interest) * ((g.year * 12) + g.month);
        return totalPayment;
    }

    private static DecimalFormat df = new DecimalFormat("0.00");
    public void spausdintigeras() throws IOException {
        FileWriter fileWriter = new FileWriter("spausdintiintervalasanuity.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println("Month\t\t" + "Payment\t\t" + "Total unpaid\t\t\n");
        viso = ((int) year * 12 + (int) month);
        double payment[] = new double[viso + 1];
        payment[1] = getMonthlyPayment(interest);
        double total[] = new double[viso + 1];
        total[1] = getTotalPayment();
        double sum = 0;
        for (int i = 1; i <= viso; i++) {
            if (i == 1 && i == (int) g.nuo) {
                printWriter.println(+i + "\t\t" + df.format(payment[i]) + "\t\t" + df.format(total[i] - payment[i]));
                total[i] = (total[i] - payment[i]);
                sum++;
            } else if (i == 1) {
                total[i] = (total[i] - payment[i]);
            } else if (i == (int) g.nuo) {
                for (int j = (int) g.nuo; j <= (int) g.iki; j++) {
                    payment[j] = payment[j - 1] + payment[1];
                    total[j] = (total[j - 1] - payment[1]);
                    printWriter.println(+j + "\t\t" + df.format(payment[j]) + "\t\t" + df.format(total[j]));
                }
                break;
            } else if (sum == 1) {
                for (int j = 2; j <= (int) g.iki; j++) {
                    payment[j] = payment[j - 1] + payment[1];
                    total[j] = (total[j - 1] - payment[1]);
                    printWriter.println(+j + "\t\t" + df.format(payment[j]) + "\t\t" + df.format(total[j]));
                }
                break;
            } else {
                payment[i] = payment[i - 1] + payment[1];
                total[i] = (total[i - 1] - payment[1]);
            }
        }
   
        printWriter.close();
    }

    public void atidejimas(double n1, double n2) throws IOException {
        Frame z = new Frame();
        atidejimas y = new atidejimas();
        int i = 1;
        int j;
        double monthlyInterestRate = interest / 1200;
        double monthlyInterestRate1 = z.palukana / 1200;
        double c = getMonthlyPayment(interest);
        viso = (((int) year * 12 + (int) month) + ((int) n2 - (int) n1));
        double endingbalance[] = new double[viso + viso];
        endingbalance[1] = (loan - (c - (loan * monthlyInterestRate)));
        double palukanos1[] = new double[viso + viso];
        palukanos1[1] = loan * monthlyInterestRate1;
        double interestar[] = new double[viso + viso];
        interestar[1] = (loan * monthlyInterestRate);
        double sum1 = 0;
        double principal[] = new double[viso + viso];
        principal[1] = (c - (loan * monthlyInterestRate));
        double ats = 0;
        double payment[] = new double[viso + viso];
        payment[1] = getMonthlyPayment(interest);
        double total[] = new double[viso + viso];
        total[1] = y.getTotalPayment();
        
        FileWriter fileWriter = new FileWriter("atideti.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        
        printWriter.println("Month\t\t" + "Payment\t\t" + "Unpaid payment\t\t\n");
        while (endingbalance[i] >= 0) {
            if (i == 1 && i == (int) n1) {
                principal[i] = (c - (loan * monthlyInterestRate));
                endingbalance[i] = (loan - (c - (loan * monthlyInterestRate)));
                palukanos1[i] = palukanos1[1];
                total[i] = total[1] - palukanos1[1];
                printWriter.println(+i + "\t\t" + df.format(palukanos1[i]) + "\t\t" + df.format(total[i]) + "\t\t\n");
                sum1++;
                viso1++;
            } else if (i == 1) {
                principal[i] = (c - (loan * monthlyInterestRate));
                endingbalance[i] = (loan - (c - (loan * monthlyInterestRate)));
                payment[i] = payment[1];
                total[i] = total[1] - payment[i];
                printWriter.println(+i + "\t\t" + df.format(payment[i]) + "\t\t" + df.format(total[i]) + "\t\t\n");;
                viso1++;
            } else if (sum1 == 1 && (i == 2)) {
                sum1++;
                for (j = 2; j <= (int) n2; j++) {
                    palukanos1[i] = palukanos1[i - 1] + palukanos1[1];
                    total[i] = total[i - 1] - palukanos1[1];
                    printWriter.println(+j + "\t\t" + df.format(palukanos1[i]) + "\t\t" + df.format(total[i]) + "\t\t\n");
                    i++;
                    viso1++;
                }
                i--;
            } else if (i == (int) n1) {
                ats++;
                for (j = (int) n1; j <= (int) n2; j++) {
                    if (j == n1) {
                        palukanos1[i] = payment[i - 1] + palukanos1[1];
                        total[i] = total[i - 1] - palukanos1[1];
                        printWriter.println(+j + "\t\t" + df.format(palukanos1[i]) + "\t\t" + df.format(total[i]) + "\t\t\n");
                        viso1++;
                    } else {
                        palukanos1[i] = palukanos1[i - 1] + palukanos1[1];
                        total[i] = total[i - 1] - palukanos1[1];
                        printWriter.println(+j + "\t\t" + df.format(palukanos1[i]) + "\t\t" + df.format(total[i]) + "\t\t\n");
                        viso1++;
                    }
                    i++;
                }
                i--;
            } else if ((sum1 == 2 && i == n2 + 1) || (ats == 1 && i == n2 + 1)) {
                principal[i] = (c - (loan * monthlyInterestRate));
                endingbalance[i] = (loan - (c - (loan * monthlyInterestRate)));
                payment[i] = palukanos1[i - 1] + payment[1];
                total[i] = total[i - 1] - payment[1];
                printWriter.println(+i + "\t\t" + df.format(payment[i]) + "\t\t" + df.format(total[i]) + "\t\t\n");
                viso1++;
            } else {
                principal[i] = (c - (endingbalance[i - 1] * monthlyInterestRate));
                endingbalance[i] = (endingbalance[i - 1] - principal[i]);

                if (c > total[i - 1]) {
                    payment[i] = payment[i - 1] + total[i - 1];
                    total[i] = total[i - 1] - total[i - 1];
                    printWriter.println(+i + "\t\t" + df.format(payment[i]) + "\t\t" + df.format(total[i]) + "\t\t\n");
                    viso1++;
                    break;
                } else {
                    payment[i] = payment[i - 1] + payment[1];
                    total[i] = total[i - 1] - payment[1];
                    viso1++;
                    printWriter.println(+i + "\t\t" + df.format(payment[i]) + "\t\t" + df.format(total[i]) + "\t\t\n");
                }
            }
            i++;
        }
        printWriter.close();
    }
}
