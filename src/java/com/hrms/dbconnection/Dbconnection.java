/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.dbconnection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author srj
 */
public class Dbconnection {
    
//    static String DRIVER="com.mysql.jdbc.Driver";  
//    static String CONNECTION_URL="'jdbc:mysql://localhost/hrms'";  
//    static String USERNAME="root";  
//    static String PASSWORD="admin";  
    
    
    
  
    
    public static Connection getCon(){  
          Connection conn = null;
        if(conn==null){
             try {
//                Class.forName(DRIVER);
//                conn=DriverManager.getConnection(CONNECTION_URL,USERNAME,PASSWORD);
                Class.forName("com.mysql.jdbc.Driver"); 
		conn = DriverManager.getConnection("jdbc:mysql://localhost/hrms", "root", "admin");
            } catch (Exception ex) {
                Logger.getLogger(Dbconnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conn;  
}  
    public static void closeConnection(Connection connectionObj){
        try{
            if(connectionObj!=null){
            connectionObj.close();
            }
        }catch(SQLException e){
        System.out.println("error while cloding connection");
        }
        
    }
     public static void closePreparedStatement(PreparedStatement preparedObj){
        try{
            if(preparedObj!=null){
            preparedObj.close();
            }
        }catch(SQLException e){
        System.out.println("error while closing connection"+e);
        }
        
    }
      public static void closeResultSet(ResultSet rsObj){
        try{
            if(rsObj!=null){
            rsObj.close();
            }
        }catch(SQLException e){
        System.out.println("error while closing resultSet"+e);
        }
        
    }
      
      public static void closeAll(ResultSet rs, PreparedStatement ps, Connection  con){
            Dbconnection.closeResultSet(rs);
            Dbconnection.closePreparedStatement(ps);
            Dbconnection.closeConnection(con);
      }
}


