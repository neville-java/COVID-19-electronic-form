/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electronic_form;

import java.security.MessageDigest;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author neville
 */
public class Add_record extends javax.swing.JFrame {

    /**
     * Creates new form Add_record
     */
    public Add_record() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    private int ID = 0;
    private String first_name;
    private String surname;
    private String Contact;
    private int Age=0;
    private String H_Address;
    private String Email;
    private double Temperature=0;
    String Q1_answer;
    String Q2_answer;
    String Message = "ERROR";

    void getValues() {

        try {
            ID = 0;
            first_name = txtName.getText();
            surname = txtSurname.getText();
            Contact = txtContact.getText();
            Age = Integer.parseInt(txtAge.getText());
            H_Address = txtAddress.getText();
            Email = txtEmail.getText();
            Temperature = Double.parseDouble(txtTemperature.getText());

            if (y1.isSelected() == true) {
                Q1_answer = "YES";
            }
            if (n1.isSelected() == true) {
                Q1_answer = "NO";
            }
            if (y2.isSelected() == true) {
                Q2_answer = "YES";
            }
            if (n2.isSelected() == true) {
                Q2_answer = "NO";
            }
            
            
          

        } catch (NumberFormatException e) {
            Message = Message + " ONLY NUMBER ALLOW FOR AGE AND TEMPERATURE "+e;
        }  catch (Exception e) {
            Message = Message + "  \n " + e;
        }

    }

    void clearFields() {
        ID = 0;
        first_name = "";
        surname = "";
        Contact = "";
        Age = 0;
        H_Address = "";
        Email = "";
        Temperature = 0;

        ID = 0;
        txtName.setText(first_name);
        txtSurname.setText(surname);
        txtContact.setText(Contact);
        txtAge.setText("" + Age);
        txtAddress.setText(H_Address);
        txtEmail.setText(Email);
        txtTemperature.setText("" + Temperature);

        y1.setSelected(false);
        n1.setSelected(false);
        y2.setSelected(false);
        n2.setSelected(false);
    }

    void mSaveToDatabase() {

        Connection conMySQLConnectionString;
        String URL = "jdbc:mysql://localhost:3306/tracking_register_db";
        String User = "root";
        String Password = " ";

        try {
            conMySQLConnectionString = DriverManager.getConnection(URL, User, Password);
            Statement myStatement = conMySQLConnectionString.createStatement();

            String sqlinsert = "insert into event_participants  "
                    + "(FirstName,LastName,Contact,Age,Address,Email,Temperature,Answer1,Answer2)"
                    + "values('" + first_name
                    + "','" + surname
                    + "','" + Contact
                    + "','" + Age
                    + "','" + H_Address
                    + "','" + Email
                    + "','" + Temperature
                    + "','" + Q1_answer
                    + "','" + Q2_answer
                    + "')";

            myStatement.executeUpdate(sqlinsert);
            myStatement.close();
            JOptionPane.showMessageDialog(null, "\n COMPLETE!!!   \n  USER  INFORMATION ADDED SUCCESFULL");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel6 = new javax.swing.JLabel();
        txtTemperature = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        y1 = new javax.swing.JRadioButton();
        n1 = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        y2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        n2 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSurname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtContact = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setBackground(new java.awt.Color(0, 0, 0));
        jInternalFrame1.setVisible(true);

        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setText("Address (Place/Area)");

        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setText("Email");

        jLabel8.setForeground(java.awt.Color.white);
        jLabel8.setText("Temperature");

        y1.setBackground(java.awt.Color.black);
        y1.setForeground(java.awt.Color.white);
        y1.setText("Yes");
        y1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                y1ActionPerformed(evt);
            }
        });

        n1.setBackground(java.awt.Color.black);
        n1.setForeground(java.awt.Color.white);
        n1.setText("No");
        n1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n1ActionPerformed(evt);
            }
        });

        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Have you had any COVID-19 symptoms: Fever (over 38 degrees) , dry cough or shortness of breath ?");

        y2.setBackground(java.awt.Color.black);
        y2.setForeground(java.awt.Color.white);
        y2.setText("Yes");
        y2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                y2ActionPerformed(evt);
            }
        });

        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Please complete this form when you enter the venue and wash your hands with hand sanitiser");

        jLabel10.setForeground(java.awt.Color.white);
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Have you been exposed to anyone with COVID-19  OR someone who has symptoms in th last for weeks ? ");

        n2.setBackground(java.awt.Color.black);
        n2.setForeground(java.awt.Color.white);
        n2.setText("No");
        n2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n2ActionPerformed(evt);
            }
        });

        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Name");

        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Surname");

        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("Contact number");

        jLabel5.setForeground(java.awt.Color.white);
        jLabel5.setText("Age");

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel11.setForeground(java.awt.Color.white);
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("ADD RECORD");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161))
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(y1)
                            .addComponent(n1)
                            .addComponent(y2)
                            .addComponent(n2)))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(btnClear)
                        .addGap(55, 55, 55)
                        .addComponent(btnSubmit)
                        .addGap(91, 91, 91)
                        .addComponent(btnCancel))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(39, 39, 39)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTemperature, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jInternalFrame1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtAddress, txtAge, txtContact, txtEmail, txtName, txtSurname, txtTemperature});

        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTemperature, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(y1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(n1)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(y2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(n2))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSubmit)
                            .addComponent(btnCancel)
                            .addComponent(btnClear))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void y1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_y1ActionPerformed
        if (n1.isSelected() == true) {
            n1.setSelected(false);
        }
    }//GEN-LAST:event_y1ActionPerformed

    private void n1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n1ActionPerformed
        if (y1.isSelected() == true) {
            y1.setSelected(false);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_n1ActionPerformed

    private void y2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_y2ActionPerformed
        if (n2.isSelected() == true) {
            n2.setSelected(false);
        }
    }//GEN-LAST:event_y2ActionPerformed

    private void n2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n2ActionPerformed
        if (y2.isSelected() == true) {
            y2.setSelected(false);
        }
    }//GEN-LAST:event_n2ActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
       getValues();
        if ("".equals(first_name)) {
                Message += "\n Enter first name";
            }
            if (surname.isEmpty()) {
                Message += "\n Enter Lastname";
            }
            if (Contact.isEmpty()) {
                Message += "\n Enter your number";
            }
            if (Age == 0) {
                Message += "\n Enter your age";
            }
            if (H_Address.isEmpty()) {
                Message += "\n Enter enter yoour home address";
            }
            if (Email.isEmpty()) {
                Message = Message + "\nEnter your email";
            }
            if (Temperature == 0) {
                Message = Message + "\n Enter your temperature";
            }
            if (Q1_answer.equals("")) {
                Message = Message + "\n \n please select yes or no :Have you had any COVID-19 symptoms: Fever (over 38 degrees) , dry cough or shortness of breath ?";
            }
            if (Q2_answer.equals("")) {
                Message = Message + "\n Have you been exposed to anyone with COVID-19  OR someone who has symptoms in th last for weeks ? ";
            }
        
        if(Message.equals("ERROR")){
          mSaveToDatabase();   
        clearFields();  
    }else{
    JOptionPane.showMessageDialog(this, Message);
        
}// TODO add your handling code here:
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearFields();        // TODO add your handling code here:
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.show(false);        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Add_record.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_record.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_record.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_record.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_record().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton n1;
    private javax.swing.JRadioButton n2;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSurname;
    private javax.swing.JTextField txtTemperature;
    private javax.swing.JRadioButton y1;
    private javax.swing.JRadioButton y2;
    // End of variables declaration//GEN-END:variables
}
