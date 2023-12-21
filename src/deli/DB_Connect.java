package deli;

import java.sql.*;

public class DB_Connect{

    // <editor-fold defaultstate="collapsed" desc="Database Connection">
    // ----------------สร้าง Object ที่ใช้กับ Database---------------------
    private Connection conn = null;
    private Statement st = null;
    private ResultSet rs = null;
    // ---------------------------------------------------------------
    // ----------------URL สำหรับเชื่อมฐานข้อมูลบน Server-------------------
    private String url = "jdbc:mysql://localhost:3306/deli";
    // ---------------------------------------------------------------
    //----------------------User ที่ใช้ Database-------------------------
    private String username = "root";
    private String password = "";
    // ---------------------------------------------------------------
    // </editor-fold>


    // -------Method for connect Database--------
    public void connectDB() throws SQLException {
        try{
            
            conn = DriverManager.getConnection(url,username,password);
            System.out.println("Success");
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    // ----------------------------------------------


    // ------Method for disconnect database--------
    public void disconnect() throws SQLException {
        try {
            conn.close();
        }catch (SQLException ex){
            
        }
    }
    // -----------------------------------------------

    // -----------Method for execute Sql-----------------
    public boolean execute (String query) throws SQLException {
        boolean rs;
        try{
            connectDB();
            st = conn.createStatement();
            st.execute(query);
            rs = true;
            disconnect();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            rs = false;
        }
return rs;
    }
    // ------------------------------------------------------------

    // ----------Method get ResultSet from execute-------------
    public ResultSet getResultSet (String query) throws SQLException {
        try{
            connectDB();
            st = conn.createStatement();
            rs = st.executeQuery(query);

        }catch (SQLException ex){
            rs = null;
        }
        return rs;
    }
    // ---------------------------------------------------------------------



}
