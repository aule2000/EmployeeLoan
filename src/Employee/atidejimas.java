package Employee;
/**
 *
 * @author Aukse
 */
public class atidejimas extends NewClass{
        loan g = new loan();
       @Override
  public double getTotalPayment(){
        Frame z = new Frame();
        double monthlyInterestRate1 =z.palukana / 1200;
        double totalPayment = ((getMonthlyPayment(g.interest) * (g.year * 12)+g.month)+((g.loan*monthlyInterestRate1)*(z.iki1-z.nuo1)));
        return totalPayment;
        }
    
}
