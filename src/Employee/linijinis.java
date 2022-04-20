/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import static Employee.NewClass.viso;
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
public class linijinis {
    public static double kreditas;
    private static DecimalFormat df = new DecimalFormat("0.00");
    public double spausdinti() throws IOException{
                        loan g = new loan();
                        NewClass z = new NewClass();
                        double monthlyInterestRate = interest / 1200;
                        int viso =(int)year*12+(int)month;
                        double kreditas = loan/(year*12+month);
                        double payment[] = new double[viso+1];
                        //payment[0] = z.getMonthlyPayment(interest);
                        double total[] = new double[viso+1];
                        double sum = 0;
                        total[0]=loan;
                        double principal[] = new double[viso+viso];
                        principal[0]=(loan*monthlyInterestRate);
                        for(int i =0;i<viso;i++){
                            if(i == 0){
                                payment[i]=principal[i]+kreditas;
                                total[i] = (total[i]-kreditas);
                                 sum = sum +payment[i];
                            }
                            else{
                                payment[i] = kreditas +(total[i-1]*monthlyInterestRate);
                                total[i] = (total[i-1]-kreditas);
                               sum = sum +payment[i];
                            }
                        }
                        return sum;
                }
}
