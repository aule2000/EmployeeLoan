package Employee;


import static Employee.Tekstas.viso;
import graphs.NewFXMain;
import graphs.graphline;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.IOException;  // Import the IOException class to handle errors
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

/**
 *
 * @author Aukse Levonaite, 5 group
 */
public class loan extends javax.swing.JFrame {

    public static double loan;
    public static double interest;
    public static double month;
    public static double year;
    private int suma;
    public static double nuo;
    public static double iki;
   private  double kiek;
    private  double sumt;

    public loan() {
        initComponents();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtlamout = new javax.swing.JTextField();
        txtyear = new javax.swing.JTextField();
        txtirate = new javax.swing.JTextField();
        txttamount = new javax.swing.JTextField();
        jExit = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txttmonth = new javax.swing.JTextField();
        jLoanCalculate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jtxtmonth = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jnuo = new javax.swing.JTextField();
        jiki = new javax.swing.JTextField();
        jatideti = new javax.swing.JButton();
        jgraf = new javax.swing.JButton();
        jRadioButton_linear = new javax.swing.JRadioButton();
        jRadioButton_anuitity = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Employee Loan Calculator");

        jLabel4.setText("Loan Amount");

        jLabel5.setText("Number of years");

        jLabel6.setText("Interest Rate");

        jLabel7.setText("Total Loan Amount");

        txtyear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtyearActionPerformed(evt);
            }
        });

        jExit.setText("Exit");
        jExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExitActionPerformed(evt);
            }
        });

        jLabel8.setText("Monthly Payment ");

        jLoanCalculate.setText("Calculate");
        jLoanCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLoanCalculateActionPerformed(evt);
            }
        });

        jLabel2.setText("Number of months");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Period");

        jLabel9.setText("From");

        jLabel10.setText("to");

        jatideti.setText("Delay");
        jatideti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jatidetiActionPerformed(evt);
            }
        });

        jgraf.setText("Graph");
        jgraf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jgrafActionPerformed(evt);
            }
        });

        jRadioButton_linear.setText("Linear");

        jRadioButton_anuitity.setText("Anuitity");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLoanCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jatideti, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jgraf, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113)
                .addComponent(jExit, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel2))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtirate, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttamount, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttmonth, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtxtmonth, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(183, 183, 183)
                                        .addComponent(jRadioButton_linear)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jRadioButton_anuitity))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtyear, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(223, 223, 223)
                                        .addComponent(jLabel9)
                                        .addGap(34, 34, 34)
                                        .addComponent(jnuo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(58, 58, 58)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(jiki, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtlamout, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(186, 186, 186))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txttamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLoanCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jExit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jatideti)
                            .addComponent(jgraf))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtlamout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(jnuo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(jiki, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jtxtmonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jRadioButton_linear)
                                    .addComponent(jRadioButton_anuitity))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtirate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txttmonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(102, 102, 102))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jExitActionPerformed
    private void jLoanCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLoanCalculateActionPerformed
        int kiekis = 0;
        String Balance = String.format(txtlamout.getText());
        if (isNumeric(Balance) == false) {
            JOptionPane.showMessageDialog(null, "You must enter amount of loan to borrow", "Loan system", JOptionPane.INFORMATION_MESSAGE);
        } else if (txtlamout.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "You must enter amount of loan to borrow", "Loan system", JOptionPane.INFORMATION_MESSAGE);
        } else if (Double.parseDouble(txtlamout.getText()) < 0) {
            JOptionPane.showMessageDialog(null, "You must enter positive amount of loan to borrow", "Loan system", JOptionPane.INFORMATION_MESSAGE);
        } else {
            loan = Double.parseDouble(txtlamout.getText());
            suma++;
        }
        String iInterest = String.format(txtirate.getText());
        if (isNumeric(iInterest) == false) {
            JOptionPane.showMessageDialog(null, "You must enter loan rate", "Loan system", JOptionPane.INFORMATION_MESSAGE);
        } else if (txtirate.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "You must enter loan rate", "Loan system", JOptionPane.INFORMATION_MESSAGE);
        } else if (Double.parseDouble(txtirate.getText()) < 0) {
            JOptionPane.showMessageDialog(null, "You must enter positive loan rate", "Loan system", JOptionPane.INFORMATION_MESSAGE);
        } else {
            interest = Double.parseDouble(txtirate.getText());
            suma++;
        }
        String durationyear = String.format(txtyear.getText());
        if (isNumeric(durationyear) == false) {
            JOptionPane.showMessageDialog(null, "You must enter number of years", "Loan system", JOptionPane.INFORMATION_MESSAGE);
        } else if (txtyear.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "You must enter number of years ", "Loan system", JOptionPane.INFORMATION_MESSAGE);
        } else if (Double.parseDouble(txtyear.getText()) < 0) {
            JOptionPane.showMessageDialog(null, "You must enter positive number of years", "Loan system", JOptionPane.INFORMATION_MESSAGE);
        } else {
            year = Double.parseDouble(txtyear.getText());
            suma++;
        }
        String durationmonth = String.format(jtxtmonth.getText());
        if (isNumeric(durationmonth) == false) {
            JOptionPane.showMessageDialog(null, "You must enter number of months", "Loan system", JOptionPane.INFORMATION_MESSAGE);
        } else if (jtxtmonth.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "You must enter number of months ", "Loan system", JOptionPane.INFORMATION_MESSAGE);
        } else if (Double.parseDouble(jtxtmonth.getText()) < 0) {
            JOptionPane.showMessageDialog(null, "You must enter positive number of months", "Loan system", JOptionPane.INFORMATION_MESSAGE);
        } else {
            month = Double.parseDouble(jtxtmonth.getText());
            suma++;
        }
        String monthfrom = String.format(jnuo.getText());
        if (jnuo.getText().equals("")) {
            ;
        } else if (isNumeric(monthfrom) == false) {
            JOptionPane.showMessageDialog(null, "You must enter number of months from", "Loan system", JOptionPane.INFORMATION_MESSAGE);
            kiekis++;
        } else if (Double.parseDouble(jnuo.getText()) < 0) {
            JOptionPane.showMessageDialog(null, "You must enter positive number of months from", "Loan system", JOptionPane.INFORMATION_MESSAGE);
            kiekis++;
        } else {
            nuo = Double.parseDouble(jnuo.getText());
            suma++;
        }
        String monthto = String.format(jiki.getText());
        if (jiki.getText().equals("")) {
            ;
        } else if (isNumeric(monthto) == false) {
            JOptionPane.showMessageDialog(null, "You must enter number of months to", "Loan system", JOptionPane.INFORMATION_MESSAGE);
            kiekis++;
        } else if (Double.parseDouble(jiki.getText()) < 0) {
            JOptionPane.showMessageDialog(null, "You must enter positive number of months to", "Loan system", JOptionPane.INFORMATION_MESSAGE);
            kiekis++;
        } else {
            iki = Double.parseDouble(jiki.getText());
            suma++;
        }
        if (suma == 6 && jRadioButton_anuitity.isSelected() == true) {
            Tekstas z = new Tekstas();
            double monthlyPay = z.getMonthlyPayment(interest);
            String paymonth = String.format("%.2f", monthlyPay);
            txttmonth.setText(paymonth);
            double totpay = z.getTotalPayment();
            String paytot = String.format("%.2f", totpay);
            txttamount.setText(paytot);
            try {
                z.display();
            } catch (IOException ex) {
                Logger.getLogger(loan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (suma == 6 && jRadioButton_linear.isSelected() == true) {
            Tekstas y = new Tekstas();
            double monthlyPay = y.getMonthlyPayment(interest);
            String paymonth = String.format("%.2f", monthlyPay);
            txttmonth.setText(paymonth);
            linijinis ats = new linijinis();
            double atsakyt = 0;
            try {
                atsakyt = ats.spausdinti();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            String paytot1 = String.format("%.2f", atsakyt);
            txttamount.setText(paytot1);
             try {
                y.spausdintiintervalu();
            } catch (IOException ex) {
                Logger.getLogger(loan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (suma == 4 && kiekis == 0 && jRadioButton_anuitity.isSelected() == true) {
            Tekstas x = new Tekstas();
            NewClass at = new NewClass();
            double monthlyPay = x.getMonthlyPayment(interest);
            String paymonth = String.format("%.2f", monthlyPay);
            txttmonth.setText(paymonth);
            double totpay = x.getTotalPayment();
            String paytot = String.format("%.2f", totpay);
            txttamount.setText(paytot);   
            //kiek++;
           
            try {
                 
                x.spausdintigerasturetu();
            } catch (IOException ex) {
                Logger.getLogger(loan.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jLoanCalculateActionPerformed
       if (suma == 4 && kiekis == 0 && jRadioButton_linear.isSelected() == true) {
           Tekstas y = new Tekstas();
            double monthlyPay = y.getMonthlyPayment(interest);
            String paymonth = String.format("%.2f", monthlyPay);
            txttmonth.setText(paymonth);
            linijinis ats = new linijinis();
            double atsakyt = 0;
            try {
                atsakyt = ats.spausdinti();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            String paytot1 = String.format("%.2f", atsakyt);
            txttamount.setText(paytot1);
            try {
                y.spausdinti1();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } 
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    private void txtyearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtyearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtyearActionPerformed

  

    private void jatidetiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jatidetiActionPerformed
        Frame frame = new Frame();
        frame.setVisible(true);
    }//GEN-LAST:event_jatidetiActionPerformed

    private void jgrafActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jgrafActionPerformed
        if (suma == 4 && jRadioButton_anuitity.isSelected() == true) {
            EventQueue.invokeLater(() -> {
                NewFXMain ex = null;
                try {
                    ex = new NewFXMain();
                } catch (IOException ex1) {
                    Logger.getLogger(loan.class.getName()).log(Level.SEVERE, null, ex1);
                }
                ex.setVisible(true);
            });
            kiek++;
             Frame h = new Frame(kiek,sumt);
            
        } 
        else if (suma == 4 && jRadioButton_linear.isSelected() == true) {
            EventQueue.invokeLater(() -> {
                graphline ex = null;
                try {
                    ex = new graphline();
                } catch (IOException ex1) {
                    Logger.getLogger(loan.class.getName()).log(Level.SEVERE, null, ex1);
                }
                ex.setVisible(true);
            });
            sumt++;
            Frame h = new Frame(kiek,sumt);
        }
        else if (suma == 6 && jRadioButton_anuitity.isSelected()==true ) {
            EventQueue.invokeLater(() -> {

                NewFXMain ex = null;
                try {
                    ex = new NewFXMain();
                } catch (IOException ex1) {
                    Logger.getLogger(loan.class.getName()).log(Level.SEVERE, null, ex1);
                }
                ex.setVisible(true);
            });
            kiek++;
             Frame h = new Frame(kiek,sumt);
        }
        else {
            EventQueue.invokeLater(() -> {

                graphline ex = null;
                try {
                    ex = new graphline();
                } catch (IOException ex1) {
                    Logger.getLogger(loan.class.getName()).log(Level.SEVERE, null, ex1);
                }
                ex.setVisible(true);
            });
            kiek++;
             Frame h = new Frame(kiek,sumt);
        }
        
       
    }//GEN-LAST:event_jgrafActionPerformed

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String args[]) throws IOException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(loan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //String filename = "filename.txt";

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loan().setVisible(true);

            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JButton jLoanCalculate;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JRadioButton jRadioButton_anuitity;
    public javax.swing.JRadioButton jRadioButton_linear;
    private javax.swing.JButton jatideti;
    private javax.swing.JButton jgraf;
    public javax.swing.JTextField jiki;
    public javax.swing.JTextField jnuo;
    private javax.swing.JTextField jtxtmonth;
    private javax.swing.JTextField txtirate;
    private javax.swing.JTextField txtlamout;
    private javax.swing.JTextField txttamount;
    private javax.swing.JTextField txttmonth;
    private javax.swing.JTextField txtyear;
    // End of variables declaration//GEN-END:variables
}
