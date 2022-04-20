package Employee;

import static Employee.NewClass.viso;
import static Employee.NewClass.viso1;
import static Employee.loan.interest;
import static Employee.loan.loan;
import static Employee.loan.month;
import static Employee.loan.year;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
/**
 *
 * @author Aukse
 */
public class atidejimaslinij {
        private static DecimalFormat df = new DecimalFormat("0.00");
        
    public void atidejimas2(double n1, double n2) throws IOException {
        Frame z = new Frame();
        atidejimas y = new atidejimas();
        NewClass kas = new NewClass();
        int i = 1;
        int j;
        double monthlyInterestRate = interest / 1200;
        double monthlyInterestRate1 = z.palukana / 1200;
        double c = kas.getMonthlyPayment(interest);
        double kreditas = loan / (year * 12 + month);
        viso = (((int) year * 12 + (int) month) + ((int) n2 - (int) n1));
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
        
        total[1] = as.spausdinti();
        kas1[1]=total[1]-payment[1];
        double total1[] = new double[viso+viso+viso];
        
       
        FileWriter fileWriter = new FileWriter("atidetilinij.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println("Month\t\t" + "Payment\t\t" + "Unpaid payment\t\t\n");
        while (endingbalance[i] >= 0) {
            if (i == 1 && i == (int) n1) {
                principal[i] =kreditas;
                endingbalance[i] =loan-kreditas; 
                palukanos1[i] = palukanos1[1];
                total[i] = total[1] - palukanos1[1];
                printWriter.println(+i + "\t\t" + df.format(palukanos1[i]) + "\t\t" + df.format(total[i]) + "\t\t\n");
                sum1++;
                viso1++;
            } else if (i == 1) {
                principal[i] = kreditas;
                endingbalance[i] = loan-kreditas;
                
                payment[i] = payment[1];
                total[i] = total[1] - payment[i];
                total1[1]=total[i];
                printWriter.println(+i + "\t\t" + df.format(payment[i]) + "\t\t" + df.format(total[i]) + "\t\t\n");;
                viso1++;
            } else if (sum1 == 1 && (i == 2)) {
                sum1++;
                for (j = 2; j <= (int) n2; j++) {
                    palukanos1[i] = palukanos1[i - 1] + palukanos1[1];
                    total[i] = total[i - 1] - palukanos1[1];
                    printWriter.println(+j + "\t\t" + df.format(palukanos1[i]) + "\t\t" + df.format(total[i]) + "\t\t\n");
                    
                    endingbalance[i]=endingbalance[i-1]-kreditas;
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
            } else if ((sum1 == 2 && i == n2 + 1)) {
                principal[i] = kreditas;

                
                endingbalance[i] =  loan - kreditas;
                payment[i] = palukanos1[i - 1] + payment[1];
                total[i] = total[i - 1] - payment[1];
                printWriter.println(+i + "\t\t" + df.format(payment[i]) + "\t\t" + df.format(total[i]) + "\t\t\n");
                viso1++;
            }
            else if(ats == 1 && i == n2 +1){
                principal[i] = kreditas;
                endingbalance[i] = loan - kreditas;
                payment[i]= palukanos1[i-1] + kreditas +(total1[1]*monthlyInterestRate);
                total[i]=total[i-1]-(kreditas +(total1[1]*monthlyInterestRate));
                 printWriter.println(+i + "\t\t" + df.format(payment[i]) + "\t\t" + df.format(total[i]) + "\t\t\n");
                viso1++;
            }
            else {
                principal[i] = kreditas;
                endingbalance[i] = (endingbalance[i - 1] - principal[i]);

                if (c > total[i - 1]) {
                    payment[i] = payment[i - 1] + total[i - 1];
                    total[i] = total[i - 1] - total[i - 1];
                    printWriter.println(+i + "\t\t" + df.format(payment[i]) + "\t\t" + df.format(total[i]) + "\t\t\n");
                    viso1++;
                    break;
                } else {
                    if(i == n2+2){
                        kas1[i]=kas1[1];
                        payment[i] = payment[i-1]+ kreditas + kas1[i]*monthlyInterestRate;
                        total[i] = total[i - 1] - (kreditas + kas1[i]*monthlyInterestRate);
                        viso1++;
                        printWriter.println(+i + "\t\t" + df.format(payment[i]) + "\t\t" + df.format(total[i]) + "\t\t\n");
                        kas1[i]= kas1[i]-(kreditas + kas1[i]*monthlyInterestRate);
                    }
                    else{
                    payment[i] = payment[i-1]+ kreditas + (kas1[i-1]*monthlyInterestRate);
                    total[i] = total[i - 1] - (kreditas + (kas1[i-1]*monthlyInterestRate));
                    viso1++;
                    printWriter.println(+i + "\t\t" + df.format(payment[i]) + "\t\t" + df.format(total[i]) + "\t\t\n");
                    kas1[i] = kas1[i-1] -(kreditas + kas1[i-1]*monthlyInterestRate);
                }}
            }
            i++;
        }
        printWriter.close();
}
}
