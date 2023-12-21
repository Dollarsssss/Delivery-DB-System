/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package deli;


import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Dollars
 */
public class OrderDetial extends javax.swing.JFrame {


    DB_Connect db = new DB_Connect();

    /**
     * Creates new form OrderDetial
     */
 

    public OrderDetial() {
        initComponents();
        


        DB_Connect db = new DB_Connect();
        ResultSet rs;
      
        try {
              int set = Manage.sendM;
            
            String sql = String.format("SELECT i.Invoice_ID,i.Invoice_Date,i.Order_ID,od.Product_Code,od.Quantity,od.Price,od.Attachment,e.E_fname,e.E_lname,c.cus_fname,c.cus_lname,s.Company,o.Shippers_Date,o.Status FROM `orders` as o "
                    + "INNER JOIN invoice as i on o.Order_ID = i.Order_ID INNER JOIN order_detail as od on o.Order_ID = od.Order_ID"
                    + " INNER JOIN employee as e on o.Employee_ID = e.E_ID INNER JOIN customers as c on o.Customer = c.cus_ID "
                    + "INNER JOIN shippers as s on o.Shippers_ID = s.ID WHERE o.Order_ID = '%s' ", set);
                    rs = db.getResultSet(sql);
                    
     
            while (rs.next()) {
                String invoce_id = rs.getString("Invoice_ID");
                String invoce_date = rs.getString("Invoice_Date");
                String order_id = rs.getString("Order_ID");
                String product_code = rs.getString("Product_Code");
                String Quantity = rs.getString("Quantity");
                String price = rs.getString("Price");
                String e_fname = rs.getString("E_fname");
                String e_lname = rs.getString("E_lname");
                String cus_fname = rs.getString("cus_fname");
                String cus_lname = rs.getString("cus_lname");
                String company = rs.getString("Company");
                String shippers_date = rs.getString("Shippers_Date");
                String status = rs.getString("Status");
       
         

                java.sql.Blob blob = rs.getBlob("Attachment");
                InputStream in = blob.getBinaryStream();
                BufferedImage image = ImageIO.read(in);
                ImageIcon aImage = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH));
                
                
                La_InvoiceID1.setText(invoce_id);
                La_InvoiceDate1.setText(invoce_date);
                La_OrderID1.setText(order_id);
                La_ProductCode1.setText(product_code);
                La_Quantity1.setText(Quantity);
                La_Price1.setText(price);
                La_Employee1.setText(e_fname + " " + e_lname);
                La_Customer1.setText(cus_fname + " " + cus_lname);
                La_Shipper1.setText(company);
                La_ShipperDate1.setText(shippers_date);
                La_Status.setText(status);
                La_Picture.setIcon(aImage);
              
                System.out.println("set: " + set);

            }

            int set2 = Invoiced.sendI;
            String sql1 = String.format("SELECT i.Invoice_ID,i.Invoice_Date,i.Order_ID,od.Product_Code,od.Quantity,od.Price,od.Attachment,e.E_fname,e.E_lname,c.cus_fname,c.cus_lname,s.Company,o.Shippers_Date,o.Status FROM `orders` as o "
                    + "INNER JOIN invoice as i on o.Order_ID = i.Order_ID INNER JOIN order_detail as od on o.Order_ID = od.Order_ID"
                    + " INNER JOIN employee as e on o.Employee_ID = e.E_ID INNER JOIN customers as c on o.Customer = c.cus_ID "
                    + "INNER JOIN shippers as s on o.Shippers_ID = s.ID WHERE o.Order_ID = '%s' ", set2);
            rs = db.getResultSet(sql1);
            while (rs.next()) {
                String invoce_id = rs.getString("Invoice_ID");
                String invoce_date = rs.getString("Invoice_Date");
                String order_id = rs.getString("Order_ID");
                String product_code = rs.getString("Product_Code");
                String Quantity = rs.getString("Quantity");
                String price = rs.getString("Price");
                String e_fname = rs.getString("E_fname");
                String e_lname = rs.getString("E_lname");
                String cus_fname = rs.getString("cus_fname");
                String cus_lname = rs.getString("cus_lname");
                String company = rs.getString("Company");
                String shippers_date = rs.getString("Shippers_Date");
                String status = rs.getString("Status");
                
                
                java.sql.Blob blob = rs.getBlob("Attachment");
                InputStream in = blob.getBinaryStream();
                BufferedImage image = ImageIO.read(in);
                ImageIcon aImage = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH));
                
                
                
                La_InvoiceID1.setText(invoce_id);
                La_InvoiceDate1.setText(invoce_date);
                La_OrderID1.setText(order_id);
                La_ProductCode1.setText(product_code);
                La_Quantity1.setText(Quantity);
                La_Price1.setText(price);
                La_Employee1.setText(e_fname + " " + e_lname);
                La_Customer1.setText(cus_fname + " " + cus_lname);
                La_Shipper1.setText(company);
                La_ShipperDate1.setText(shippers_date);
                La_Status.setText(status);
                La_Picture.setIcon(aImage);
                System.out.println("set2: " + set2);

            }

            int set3 = CheckTrack.sendC;
           
            String sql2 = String.format("SELECT i.Invoice_ID,i.Invoice_Date,i.Order_ID,od.Product_Code,od.Quantity,od.Price,od.Attachment,e.E_fname,e.E_lname,c.cus_fname,"
                    + "c.cus_lname,s.Company,o.Shippers_Date,o.Status FROM `orders` as o "
                    + "INNER JOIN invoice as i on o.Order_ID = i.Order_ID INNER JOIN order_detail as od on o.Order_ID = od.Order_ID "
                    + "INNER JOIN employee as e on o.Employee_ID = e.E_ID INNER JOIN customers as c on o.Customer = c.cus_ID"
                    + " INNER JOIN shippers as s on o.Shippers_ID = s.ID WHERE od.Product_Code  ='%d' ", set3);
            rs = db.getResultSet(sql2);
            while (rs.next()) {
                String invoce_id = rs.getString("Invoice_ID");
                String invoce_date = rs.getString("Invoice_Date");
                String order_id = rs.getString("Order_ID");
                String product_code = rs.getString("Product_Code");
                String Quantity = rs.getString("Quantity");
                String price = rs.getString("Price");
                String e_fname = rs.getString("E_fname");
                String e_lname = rs.getString("E_lname");
                String cus_fname = rs.getString("cus_fname");
                String cus_lname = rs.getString("cus_lname");
                String company = rs.getString("Company");
                String shippers_date = rs.getString("Shippers_Date");
                String status = rs.getString("Status");
                
                java.sql.Blob blob = rs.getBlob("Attachment");
                InputStream in = blob.getBinaryStream();
                BufferedImage image = ImageIO.read(in);
                ImageIcon aImage = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH));
                


                La_InvoiceID1.setText(invoce_id);
                La_InvoiceDate1.setText(invoce_date);
                La_OrderID1.setText(order_id);
                La_ProductCode1.setText(product_code);
                La_Quantity1.setText(Quantity);
                La_Price1.setText(price);
                La_Employee1.setText(e_fname + " " + e_lname);
                La_Customer1.setText(cus_fname + " " + cus_lname);
                La_Shipper1.setText(company);
                La_ShipperDate1.setText(shippers_date);
                La_Status.setText(status);
               La_Picture.setIcon(aImage);
                System.out.println("set3: " + set3);

       
            }
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

        m1 = new deli.M();
        m2 = new deli.M();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        La_Picture = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        La_Status = new javax.swing.JLabel();
        La_InvoiceID1 = new javax.swing.JLabel();
        La_InvoiceDate1 = new javax.swing.JLabel();
        La_OrderID1 = new javax.swing.JLabel();
        La_ProductCode1 = new javax.swing.JLabel();
        La_Quantity1 = new javax.swing.JLabel();
        La_Price1 = new javax.swing.JLabel();
        La_Employee1 = new javax.swing.JLabel();
        La_Customer1 = new javax.swing.JLabel();
        La_Shipper1 = new javax.swing.JLabel();
        La_ShipperDate1 = new javax.swing.JLabel();
        m3 = new deli.M();
        GetSetOrder = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dollars\\Desktop\\Icon\\Invoice.png")); // NOI18N
        jLabel1.setText("Invoice ID :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dollars\\Desktop\\Icon\\Date.png")); // NOI18N
        jLabel2.setText("Invoice Date :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 130, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dollars\\Desktop\\Icon\\Order.png")); // NOI18N
        jLabel3.setText("Order ID :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 100, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dollars\\Desktop\\Icon\\Product.png")); // NOI18N
        jLabel4.setText("Product Code :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dollars\\Desktop\\Icon\\Quantity.png")); // NOI18N
        jLabel5.setText("Quantity :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 110, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dollars\\Desktop\\Icon\\Price.png")); // NOI18N
        jLabel6.setText("Price :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 78, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dollars\\Desktop\\Icon\\Customer Icon.png")); // NOI18N
        jLabel7.setText("Customer :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 110, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dollars\\Desktop\\Icon\\Employee.png")); // NOI18N
        jLabel8.setText("Employee :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 100, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dollars\\Desktop\\Icon\\Ship.png")); // NOI18N
        jLabel9.setText("Shippers :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 100, -1));

        La_Picture.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        La_Picture.setForeground(new java.awt.Color(255, 255, 255));
        La_Picture.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dollars\\Desktop\\Icon\\Picture.png")); // NOI18N
        getContentPane().add(La_Picture, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 610, 170, 70));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dollars\\Desktop\\Icon\\Status.png")); // NOI18N
        jLabel11.setText("Status :");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, 78, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dollars\\Desktop\\Icon\\Date.png")); // NOI18N
        jLabel12.setText("Shippers Date :");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 140, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Order Detail");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dollars\\Desktop\\Icon\\Close Window Icon.png")); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 30, 36));

        La_Status.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        La_Status.setForeground(new java.awt.Color(255, 255, 255));
        La_Status.setText("jLabel15");
        getContentPane().add(La_Status, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 570, -1, 20));

        La_InvoiceID1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        La_InvoiceID1.setForeground(new java.awt.Color(255, 255, 255));
        La_InvoiceID1.setText("jLabel15");
        getContentPane().add(La_InvoiceID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, -1, 20));

        La_InvoiceDate1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        La_InvoiceDate1.setForeground(new java.awt.Color(255, 255, 255));
        La_InvoiceDate1.setText("jLabel15");
        getContentPane().add(La_InvoiceDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, 20));

        La_OrderID1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        La_OrderID1.setForeground(new java.awt.Color(255, 255, 255));
        La_OrderID1.setText("jLabel15");
        getContentPane().add(La_OrderID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, -1, 20));

        La_ProductCode1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        La_ProductCode1.setForeground(new java.awt.Color(255, 255, 255));
        La_ProductCode1.setText("jLabel15");
        getContentPane().add(La_ProductCode1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, -1, 20));

        La_Quantity1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        La_Quantity1.setForeground(new java.awt.Color(255, 255, 255));
        La_Quantity1.setText("jLabel15");
        getContentPane().add(La_Quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 270, 60, 20));

        La_Price1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        La_Price1.setForeground(new java.awt.Color(255, 255, 255));
        La_Price1.setText("jLabel15");
        getContentPane().add(La_Price1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, -1, 30));

        La_Employee1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        La_Employee1.setForeground(new java.awt.Color(255, 255, 255));
        La_Employee1.setText("jLabel15");
        getContentPane().add(La_Employee1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, -1, 40));

        La_Customer1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        La_Customer1.setForeground(new java.awt.Color(255, 255, 255));
        La_Customer1.setText("jLabel15");
        getContentPane().add(La_Customer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, -1, 40));

        La_Shipper1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        La_Shipper1.setForeground(new java.awt.Color(255, 255, 255));
        La_Shipper1.setText("jLabel15");
        getContentPane().add(La_Shipper1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, -1, 40));

        La_ShipperDate1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        La_ShipperDate1.setForeground(new java.awt.Color(255, 255, 255));
        La_ShipperDate1.setText("jLabel15");
        getContentPane().add(La_ShipperDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 510, -1, 40));

        m3.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(m3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 740));

        GetSetOrder.setText("jLabel15");
        getContentPane().add(GetSetOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

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
            java.util.logging.Logger.getLogger(OrderDetial.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderDetial.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderDetial.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderDetial.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderDetial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GetSetOrder;
    private javax.swing.JLabel La_Customer1;
    private javax.swing.JLabel La_Employee1;
    private javax.swing.JLabel La_InvoiceDate1;
    private javax.swing.JLabel La_InvoiceID1;
    private javax.swing.JLabel La_OrderID1;
    private javax.swing.JLabel La_Picture;
    private javax.swing.JLabel La_Price1;
    private javax.swing.JLabel La_ProductCode1;
    private javax.swing.JLabel La_Quantity1;
    private javax.swing.JLabel La_Shipper1;
    private javax.swing.JLabel La_ShipperDate1;
    private javax.swing.JLabel La_Status;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private deli.M m1;
    private deli.M m2;
    private deli.M m3;
    // End of variables declaration//GEN-END:variables
}
