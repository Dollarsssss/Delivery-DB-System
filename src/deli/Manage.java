/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package deli;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dollars
 */
public class Manage extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    int selected; //keep Row at press
    DB_Connect db = new DB_Connect();
    Color DefaultColor, ClickedColor;
    public static int sendM ;

    public Manage() {
        initComponents();
     
        DefaultColor = new Color(0, 0, 51);
        ClickedColor = new Color(153, 0, 102);

        tb.getTableHeader().setOpaque(false);
        tb.getTableHeader().setBackground(Color.WHITE);
        JX_Date.setVisible(false);

        try {
            String sql = "SELECT * FROM `shippers`";

            ResultSet rs = db.getResultSet(sql);
            while (rs.next()) {
                String name = rs.getString("Company");
                cbbShipper.addItem(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String sql = "SELECT * FROM `employee`";

            ResultSet rs = db.getResultSet(sql);
            while (rs.next()) {

                String name = rs.getString("E_fname");
                String lname = rs.getString("E_lname");
                cbbEmployee.addItem(name + " " + lname);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String sql = "SELECT o.Order_ID ,c.cus_fname,c.cus_lname ,e.E_fname,e.E_lname, o.Shippers_Date,s.Company ,o.Status FROM `orders` as o \n"
                    + "                 INNER JOIN customers as c on o.Customer = c.cus_ID INNER JOIN employee as e on o.Employee_ID = e.E_ID \n"
                    + "                INNER JOIN shippers as s on o.Shippers_ID = s.ID WHERE o.Status= 'Invoiced' OR o.Status= 'Shipped' AND o.Order_ID \n"
                    + "                ORDER BY o.Order_ID DESC;";

            ResultSet rs = db.getResultSet(sql);
            DefaultTableModel m = (DefaultTableModel) tb.getModel();
            while (rs.next()) {

                String orderid = rs.getString("Order_ID");

                String Customer_1 = rs.getString("cus_fname");
                String Customer_2 = rs.getString("cus_lname");

                String Employee_iD1 = rs.getString("E_fname");
                String Employee_iD2 = rs.getString("E_lname");

                String Shipper_Date = rs.getString("Shippers_Date");
                String Shipper_ID = rs.getString("Company");

                String Status = rs.getString("Status");
                Object[] data = new Object[]{orderid, Customer_1 + " " + Customer_2, Shipper_Date, Employee_iD1 + " " + Employee_iD2, Shipper_ID, Status};
//                 Object[] data = new Object[]{orderid, Customer_1 + " " + Customer_2," "," ", " ", Status};

                m.addRow(data);
                System.out.println(orderid);
            }

            tb.setModel(m);
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            tb.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        } catch (Exception e) {
            e.printStackTrace();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tb = new javax.swing.JTable();
        cbbEmployee = new javax.swing.JComboBox<>();
        cbbStatus = new javax.swing.JComboBox<>();
        cbbShipper = new javax.swing.JComboBox<>();
        JX_Date = new org.jdesktop.swingx.JXDatePicker();
        OrderDetail = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Logout1 = new javax.swing.JLabel();
        Back = new javax.swing.JButton();
        Save = new javax.swing.JButton();
        UpdateStatus = new javax.swing.JButton();
        Get_Status = new javax.swing.JTextField();
        Get_OrderID = new javax.swing.JTextField();
        Get_Employee = new javax.swing.JTextField();
        Get_ShippersID = new javax.swing.JTextField();
        m2 = new deli.M();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OrderID", "Customer", "Shipper_Date", "Employee", "Shipper", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb.setColumnSelectionAllowed(true);
        tb.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tb.setRowHeight(40);
        tb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tb);
        tb.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 790, 320));

        cbbEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbEmployeeActionPerformed(evt);
            }
        });
        getContentPane().add(cbbEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 130, 30));

        cbbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Invoiced", "Shipped", "Closed" }));
        getContentPane().add(cbbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, 130, 30));

        cbbShipper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbShipperActionPerformed(evt);
            }
        });
        getContentPane().add(cbbShipper, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 130, 30));

        JX_Date.setToolTipText("");
        JX_Date.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JX_Date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JX_DateActionPerformed(evt);
            }
        });
        getContentPane().add(JX_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, 30));

        OrderDetail.setText("OrderDetail");
        OrderDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderDetailActionPerformed(evt);
            }
        });
        getContentPane().add(OrderDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 440, -1, 30));

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dollars\\Desktop\\Icon\\Close Window Icon.png")); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 30, 36));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Manage");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, -1, -1));

        Logout1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        Logout1.setForeground(new java.awt.Color(255, 255, 255));
        Logout1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dollars\\Desktop\\Icon\\Logout.png")); // NOI18N
        Logout1.setText("Logout");
        Logout1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Logout1MousePressed(evt);
            }
        });
        getContentPane().add(Logout1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        getContentPane().add(Save, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 440, -1, 30));

        UpdateStatus.setText("Update");
        UpdateStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateStatusActionPerformed(evt);
            }
        });
        getContentPane().add(UpdateStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 60, 110, 30));

        Get_Status.setText("Status");
        getContentPane().add(Get_Status, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 430, 0, -1));

        Get_OrderID.setText("Get");
        getContentPane().add(Get_OrderID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 0, 20));

        Get_Employee.setText("Em");
        getContentPane().add(Get_Employee, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 0, -1));

        Get_ShippersID.setText("Shippers");
        getContentPane().add(Get_ShippersID, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, 0, -1));
        getContentPane().add(m2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 910, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Logout1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Logout1MousePressed
        new loginV().setVisible(true);
        dispose();
    }//GEN-LAST:event_Logout1MousePressed

    private void OrderDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderDetailActionPerformed

         int selectedRowIndex = tb.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tb.getModel();
        Get_OrderID.setText(model.getValueAt(selectedRowIndex, 0).toString());
      sendM = Integer.parseInt(Get_OrderID.getText());
        System.out.println("sendM: " + sendM);
         new OrderDetial().setVisible(true);

    }//GEN-LAST:event_OrderDetailActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        new Main().setVisible(true);
        dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void cbbEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbEmployeeActionPerformed

    }//GEN-LAST:event_cbbEmployeeActionPerformed

    private void cbbShipperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbShipperActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbShipperActionPerformed


    private void UpdateStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateStatusActionPerformed

        int i = tb.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tb.getModel();

        if (i > -1) {

            model.setValueAt(cbbEmployee.getSelectedItem(), i, 3);
            model.setValueAt(cbbShipper.getSelectedItem(), i, 4);
            model.setValueAt(cbbStatus.getSelectedItem(), i, 5);
            JOptionPane.showMessageDialog(null, "Success");
        } else {
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        
        Get_Employee.setText(model.getValueAt(i, 3).toString());
        Get_ShippersID.setText(model.getValueAt(i, 4).toString());
         Get_Status.setText(model.getValueAt(i, 5).toString());
    }//GEN-LAST:event_UpdateStatusActionPerformed

    private void tbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMouseClicked
     

    }//GEN-LAST:event_tbMouseClicked

    private void JX_DateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JX_DateActionPerformed


    }//GEN-LAST:event_JX_DateActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        int i = tb.getSelectedRow();

        int setOrder = Integer.parseInt(Get_OrderID.getText());
        String getEmployee =Get_Employee.getText();
        String getShippersID=Get_ShippersID.getText();
        String getStatus = Get_Status.getText();
        
        int c = 0;
      
        switch (getEmployee) {
            case "Nancy Freehafer":
                c = 1;
                break;
            case "Andrew Cencini":
                c = 2;
                break;
            case "Jan Kotas":
                c = 3;
                break;
            case "Mariya Sergienko":
                c = 4;
                break;
            case "Steven Thorpe":
                c = 5;
                break;
            case "Michael Neipper":
                c = 6;
                break;
            case "Aomsup Pongpan":
                c = 7;
                break;
            case "Admin Admin":
                c = 8;
                break;
               
           default: JOptionPane.showMessageDialog(this, "ERROR NOT FOUND");
        }
        int f = 0;
 switch (getShippersID) {
            case "Kerry Express":
                f = 1;
                break;
            case "Flash Express":
                f = 2;
                break;
            case "J&T Express":
                f = 3;
                break;
          
           default: JOptionPane.showMessageDialog(this, "ERROR NOT FOUND");
        }
   
        try {
            String Update = String.format("UPDATE `orders` SET Employee_ID ='%d',Shippers_ID= '%d',Status= '%s' WHERE Order_ID = '%d'", c,f,getStatus,setOrder);
                
            if (new DB_Connect().execute(Update)) {
                JOptionPane.showMessageDialog(this, "Complete");

            } else {
                JOptionPane.showMessageDialog(this, "Not Complete");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_SaveActionPerformed

    private void tbMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMousePressed
        int selectedRowIndex = tb.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tb.getModel();
        Get_OrderID.setText(model.getValueAt(selectedRowIndex, 0).toString());
        cbbEmployee.setSelectedItem(model.getValueAt(selectedRowIndex, 3).toString());
        cbbShipper.setSelectedItem(model.getValueAt(selectedRowIndex, 4).toString());
        cbbStatus.setSelectedItem(model.getValueAt(selectedRowIndex, 5).toString());
        
        Get_Employee.setText(model.getValueAt(selectedRowIndex, 3).toString());
        Get_ShippersID.setText(model.getValueAt(selectedRowIndex, 4).toString());
        Get_Status.setText(model.getValueAt(selectedRowIndex, 5).toString());
     
    }//GEN-LAST:event_tbMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        FlatLightLaf.setup();
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JTextField Get_Employee;
    private javax.swing.JTextField Get_OrderID;
    private javax.swing.JTextField Get_ShippersID;
    private javax.swing.JTextField Get_Status;
    private org.jdesktop.swingx.JXDatePicker JX_Date;
    private javax.swing.JLabel Logout1;
    private javax.swing.JButton OrderDetail;
    private javax.swing.JButton Save;
    private javax.swing.JButton UpdateStatus;
    private javax.swing.JComboBox<String> cbbEmployee;
    private javax.swing.JComboBox<String> cbbShipper;
    private javax.swing.JComboBox<String> cbbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JScrollPane jScrollPane1;
    private deli.M m2;
    private javax.swing.JTable tb;
    // End of variables declaration//GEN-END:variables
}
