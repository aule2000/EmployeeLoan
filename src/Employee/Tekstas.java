/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import static Employee.loan.interest;
import static Employee.loan.loan;
import static Employee.loan.month;
import static Employee.loan.year;
import graphs.NewFXMain;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

/**
 *
 * @author Aukse
 */
public class Tekstas extends NewClass {

    public static int viso;
    public double[] total;
    

    void display() throws IOException {
        super.spausdintigeras();
    }
    private static DecimalFormat df = new DecimalFormat("0.00");

    public void spausdintigerasturetu() throws IOException {
        loan g = new loan();
        FileWriter fileWriter = new FileWriter("filenamespausdintianuit.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println("Month\t\t" + "Payment\t\t" + "Total unpaid\t\t\n");
        viso = (int) year * 12 + (int) month;
        double payment[] = new double[viso + 1];
        payment[1] = getMonthlyPayment(interest);
        double total[] = new double[viso + 1];
        total[1] = getTotalPayment();
        for (int i = 1; i <= viso; i++) {
            if (i == 1) {
                printWriter.println(+i + "\t\t" + df.format(payment[i]) + "\t\t" + df.format(total[i] - payment[i]));
                total[i] = (total[i] - payment[i]);
            } else {
                payment[i] = payment[i - 1] + payment[1];
                total[i] = (total[i - 1] - payment[1]);
                printWriter.println(+i + "\t\t" + df.format(payment[i]) + "\t\t" + df.format(total[i]));
            }
        }
        printWriter.close();
      
        
        
    }

    public void spausdinti1() throws IOException {
        loan g = new loan();
        NewClass z = new NewClass();
        FileWriter fileWriter = new FileWriter("spausdintilinearpilnas.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println("Month\t\t" + "Payment\t\t" + "Total unpaid\t\t\n");
        double monthlyInterestRate = interest / 1200;
        int viso = (int) year * 12 + (int) month;
        double kreditas = loan / (year * 12 + month);
        double zero[] = new double[viso + 1];
        double total[] = new double[viso + 1];
        linijinis ats = new linijinis();
        double sum = 0;
        total[0] = ats.spausdinti();
        double principal[] = new double[viso + viso];
        principal[0] = (loan * monthlyInterestRate);
        for (int i = 0; i < viso; i++) {
            if (i == 0) {
                zero[i] = principal[i] + kreditas;
                printWriter.println(+i + 1 + "\t\t" + df.format(zero[i]) + "\t\t" + df.format(total[i] - zero[i]));
                total[i] = (total[i] - zero[i]);

            } else {
                zero[i] = kreditas + (total[i - 1] * monthlyInterestRate);
                total[i] = (total[i - 1] - zero[i]);
                if (total[i] < 0) {
                    printWriter.println(+i + 1 + "\t\t" + df.format(total[i - 1]) + "\t\t" + df.format(0));
                } else {

                    printWriter.println(+i + 1 + "\t\t" + df.format(zero[i]) + "\t\t" + df.format(total[i]));

                }

            }
        }
        printWriter.close();
    }

    void spausdintiintervalu() throws IOException {
        FileWriter fileWriter = new FileWriter("linearspausdinterv.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println("Month\t\t" + "Payment\t\t" + "Total unpaid\t\t\n");

        double monthlyInterestRate = interest / 1200;
        int viso = (int) year * 12 + (int) month;
        double kreditas = loan / (year * 12 + month);
        double zero[] = new double[viso + 1];
        double total[] = new double[viso + 1];
        linijinis ats = new linijinis();
        double sum = 0;
        total[1] = ats.spausdinti();
        double principal[] = new double[viso + viso];
        principal[1] = (loan * monthlyInterestRate);

        for (int i = 1; i <= viso; i++) {
            if (i == 1 && i == (int) g.nuo) {
                zero[i] = principal[i] + kreditas;
                printWriter.println(+i + 1 + "\t\t" + df.format(zero[i]) + "\t\t" + df.format(total[i] - zero[i]));
                total[i] = (total[i] - zero[i]);
                sum++;
            } else if (i == 1) {
                zero[i] = principal[i] + kreditas;
                total[i] = (total[i] - zero[i]);
            } else if (i == (int) g.nuo) {
                for (int j = (int) g.nuo; j <= (int) g.iki; j++) {
                    zero[j] = kreditas + total[j - 1] * monthlyInterestRate;
                    total[j] = (total[j - 1] - zero[j]);
                    printWriter.println(+j + "\t\t" + df.format(zero[j]) + "\t\t" + df.format(total[j]));
                }
                break;
            } else if (sum == 1) {
                for (int j = 2; j <= (int) g.iki; j++) {
                    zero[j] = kreditas + total[j - 1] * monthlyInterestRate;
                    total[j] = (total[j - 1] - zero[j]);
                    printWriter.println(+j + "\t\t" + df.format(zero[j]) + "\t\t" + df.format(total[j]));
                }
                break;
            } else {
                zero[i] = kreditas + total[i - 1] * monthlyInterestRate;
                total[i] = (total[i - 1] - zero[i]);
            }
        }

        printWriter.close();
    }

}
