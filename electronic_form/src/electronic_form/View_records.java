/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electronic_form;

import java.awt.Button;
import java.awt.Event;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author neville
 */
public class View_records extends javax.swing.JFrame {

    /**
     * Creates new form View_records
     */
    public View_records() {
        initComponents();
        this.setLocationRelativeTo(null);
        mPopulatetableUserInformation() ;
    }
    boolean boolRecordExists = false;

    private void mcheckIfUserExistInTable() {
        String strDBConnectionString = "jdbc:mysql://localhost:3306/tracking_register_db";
        String strDBUser = "root";
        String strDBPassword = " ";

        Connection conMySQLConnectionString;
        Statement stStatement = null;
        ResultSet rs = null;

        try {
            conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString, strDBUser, strDBPassword);
            stStatement = conMySQLConnectionString.createStatement();

            String strQuery = "Select *from event_participants where ID ='" + txtID.getText()+ "'";
            stStatement.execute(strQuery);
            rs = stStatement.getResultSet();
            boolRecordExists = rs.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                stStatement.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "  CONNECTION STRING NOT CLOSED     \n" + e);
            }
        }
    }
    
    private void mDeleteUser() {
        String strDBConnectionString = "jdbc:mysql://localhost:3306/tracking_register_db";
        String strDBUser = "root";
        String strDBPassword = " ";

        Connection conMySQLConnectionString;
        Statement stStatement = null;
        ResultSet rs = null;

        try {
          int  ID =   Integer.parseInt(String.valueOf(txtID.getText().toString()));
            conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString, strDBUser, strDBPassword);
            String strQuery = " Delete from event_participants  where ID='" + ID + "'";
            stStatement = conMySQLConnectionString.prepareStatement(strQuery);
            stStatement.execute(strQuery);
        } 
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "please enter an intager in the id field  \n"+e);
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                stStatement.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, " CONNECTION STRING NOT CLOSED    \n" + e);
            }
        }
    }

    
private void mPopulatetableUserInformation() {
        db_controller.MyQuery mq = new db_controller.MyQuery();
        ArrayList<db_controller.Product2> list = mq.BindTable();
        String[] columnName = {"ID","FIRST NAME", "LAST NAME", "CONTACT", "AGE", "ADDRESS","EMAIL","TEMPERATURE","QUESTION 1" ,"QUESTION 2" };
        Object[][] rows = new Object[list.size()][10];
        for (int i = 0; i < list.size(); i++) {
            rows[i][0] = list.get(i).getID();
            rows[i][1] = list.get(i).getLastName();
            rows[i][2] = list.get(i).getLastName();
            rows[i][3] = "0"+list.get(i).getContact();
            rows[i][4] = list.get(i).getAge();
            rows[i][5] = list.get(i).getAddress();
            rows[i][6] = list.get(i).getEmail();
            rows[i][7] = list.get(i).getTemperature();
            rows[i][8] = list.get(i).getQ1();
            rows[i][9] = list.get(i).getQ2();
            
          }
        db_controller.TheModel model = new db_controller.TheModel(rows, columnName);
        tblUserInformation.setModel(model);
        tblUserInformation.setRowHeight(30);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUserInformation = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnDelete = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setBackground(java.awt.Color.black);
        jInternalFrame1.setTitle("MANAGE PARTICIPANTS");
        jInternalFrame1.setVisible(true);
        jInternalFrame1.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                jInternalFrame1AncestorResized(evt);
            }
        });

        tblUserInformation.setBackground(new java.awt.Color(51, 51, 51));
        tblUserInformation.setForeground(java.awt.Color.white);
        tblUserInformation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblUserInformation.setFillsViewportHeight(true);
        jScrollPane1.setViewportView(tblUserInformation);

        jLabel11.setBackground(java.awt.Color.black);
        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel11.setForeground(java.awt.Color.white);
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("MANAGE PARTICIPANTS");

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(new javax.swing.border.LineBorder(java.awt.Color.red, 1, true));
        jPanel1.setForeground(java.awt.Color.white);

        btnDelete.setBackground(java.awt.Color.red);
        btnDelete.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel12.setBackground(java.awt.Color.black);
        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setForeground(java.awt.Color.white);
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("DELETE PARTICIPANT");

        txtID.setBackground(java.awt.Color.white);
        txtID.setColumns(2);
        txtID.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        txtID.setForeground(java.awt.Color.black);
        txtID.setToolTipText("ENTER PERTICIPANT ID");
        txtID.setBorder(new javax.swing.border.LineBorder(java.awt.Color.white, 1, true));

        jLabel13.setBackground(java.awt.Color.black);
        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setForeground(java.awt.Color.white);
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("ENTER PARTICIPANT ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(64, 64, 64))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        jLabel10.setForeground(java.awt.Color.white);
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Q 2 --->>> Have you been exposed to anyone with COVID-19  OR someone who has symptoms in th last for weeks ? ");

        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Q 1 --->>>  Have you had any COVID-19 symptoms: Fever (over 38 degrees) , dry cough or shortness of breath ?");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addContainerGap(522, Short.MAX_VALUE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 827, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jInternalFrame1AncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jInternalFrame1AncestorResized
        // TODO add your handling code here:
    }//GEN-LAST:event_jInternalFrame1AncestorResized

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
if (txtID.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "PLEASE ENTER USER ID OF THE USER YOU WANT TO DELETE");
            txtID.requestFocusInWindow();
        } else {
            mcheckIfUserExistInTable();
            if (boolRecordExists == true) {
                mDeleteUser();
                JOptionPane.showMessageDialog(null, "\n USER DELETED SUCCESFULL !!!! ");
            } else {
                JOptionPane.showMessageDialog(null, "\n PLEASE ENTER A VALID "
                        + "\n USER ID TO DELETE USER ");

            }
        } 
mPopulatetableUserInformation();
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(View_records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_records().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUserInformation;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
