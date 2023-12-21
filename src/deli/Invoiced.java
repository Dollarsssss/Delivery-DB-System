/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package deli;

import com.formdev.flatlaf.FlatLightLaf;

import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dollars
 */
public class Invoiced extends javax.swing.JFrame {
public static  int sendI;

    DefaultTableModel model = new DefaultTableModel();
    int selected; //keep Row at press

    Color DefaultColor, ClickedColor;
   
    public Invoiced() {
        initComponents();
     
        DefaultColor = new Color(0, 0, 51);
        ClickedColor = new Color(153, 0, 102);

        tb.getTableHeader().setOpaque(false);
        tb.getTableHeader().setBackground(Color.WHITE);

       
        
        DB_Connect db = new DB_Connect();
        try{
            String sql = String.format("SELECT i.Invoice_ID,i.Order_ID,o.Status ,i.Invoice_Date,i.Shipping_Fee"
                    + " FROM `invoice` as i INNER JOIN orders as o on i.Order_ID = o.Order_ID WHERE o.Status ='Closed'");
            ResultSet rs = db.getResultSet(sql);
             DefaultTableModel m =  (DefaultTableModel)tb.getModel();
            while(rs.next()){
                    String Invoice_ID = rs.getString("Invoice_ID");
                    String Order_ID = rs.getString("Order_ID");
                    String Status = rs.getString("Status");
                    String Invoice_Date= rs.getString("Invoice_Date");
                    String Shipping_Fee = rs.getString("Shipping_Fee");
                    
                    Object[] data = new Object[]{Invoice_ID,Invoice_Date,Shipping_Fee,Order_ID,Status};
                    
                    m.addRow(data);
            }
            tb.setModel(m);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tb.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        tb.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tb.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tb.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
          tb.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        }
      catch(Exception e){
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
        OrderDetail = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Logout1 = new javax.swing.JLabel();
        Back = new javax.swing.JButton();
        Get_OrderID = new javax.swing.JTextField();
        m2 = new deli.M();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice_ID", "Invoice_Date", "Shipping_Fee", "Order_ID", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        OrderDetail.setText("OrderDetail");
        OrderDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderDetailActionPerformed(evt);
            }
        });
        getContentPane().add(OrderDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 50, -1, 30));

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dollars\\Desktop\\Icon\\Close Window Icon.png")); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 30, 36));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Invoice");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

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
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        Get_OrderID.setText("get");
        getContentPane().add(Get_OrderID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 0, -1));
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
        Get_OrderID.setText(model.getValueAt(selectedRowIndex, 3).toString());
      sendI = Integer.parseInt(Get_OrderID.getText());
        System.out.println("sendM: " + sendI);
         new OrderDetial().setVisible(true);

    }//GEN-LAST:event_OrderDetailActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        new Main().setVisible(true);
        dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
      System.exit(0);
    }//GEN-LAST:event_jLabel14MouseClicked
  
        
          
    private void tbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMouseClicked

    }//GEN-LAST:event_tbMouseClicked

    private void tbMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMousePressed
            int selectedRowIndex = tb.getSelectedRow();
    DefaultTableModel model = (DefaultTableModel) tb.getModel();
        Get_OrderID.setText(model.getValueAt(selectedRowIndex, 3).toString());
      
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
                new Invoiced().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JTextField Get_OrderID;
    private javax.swing.JLabel Logout1;
    private javax.swing.JButton OrderDetail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JScrollPane jScrollPane1;
    private deli.M m2;
    private javax.swing.JTable tb;
    // End of variables declaration//GEN-END:variables
}
