/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd.model.util;

import java.sql.*;

/**
 *
 * @author Usuario
 */
public class ConectorBD {

    ResultSet rs;

    Connection con;
    PreparedStatement stmt;

    public Connection getConnection() throws SQLException {
        con = DriverManager.getConnection("jdbc:sqlserver://192.168.15.5:1433;databaseName=loja;encrypt=true;trustServerCertificate=true", "sa", "yRjSb2D4G39Z");
        System.out.println("conectou com sucesso!");
        return con;

    }

    public PreparedStatement getPrepared(String sql) throws SQLException {
        stmt = getConnection().prepareStatement(sql);
        return stmt;
    }

    public ResultSet getSelect(String sql) throws SQLException {
        rs = getPrepared(sql).executeQuery();

        return rs;
    }
    
    public int insert(String sql)  throws SQLException { 
            
            int primkey = 0 ;
            PreparedStatement ps = getConnection().prepareStatement(sql + "SELECT @@IDENTIFY");
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                primkey = rs.getInt(1); 
           } 
 
        rs.close();
        return primkey; 
    }

    public boolean update(String sql)  throws SQLException { 
        PreparedStatement ps = getConnection().prepareStatement(sql);
        ps.executeUpdate();
        boolean executed = ps.execute();
        rs.close();
        return executed; 
    }
    
    public void close() throws SQLException {
        rs.close();
        stmt.close();
        con.close();
    }

}
