/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.dao;

import com.hrms.beans.AllEmployeeBean;
import java.sql.*;
import com.hrms.dbconnection.Dbconnection;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

public class AllEmployeeDao {

    static Logger logger = Logger.getLogger(AllEmployeeDao.class.getName());
    
    public static ArrayList getEmployees(){
        
        ArrayList employeeList = new ArrayList();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        AllEmployeeBean EmployeeBean = null;
        
        try{
            logger.log(Level.OFF, "AllEmployeeDao dao  : - " );
            con = Dbconnection.getCon();
            
            StringBuilder sb = new StringBuilder();
            
            sb.append(" SELECT username , dept_name, emp_id, deactivate FROM employee e, department d WHERE e.depart_id = d.depart_id ");
            logger.log(Level.OFF, "within a allemployeedao try catch block :" + sb.toString());
            
            ps = con.prepareStatement(sb.toString());
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                AllEmployeeBean allEmployeeBean = new AllEmployeeBean();
                
                allEmployeeBean.setUsername(rs.getString(1));
                allEmployeeBean.setDepartName(rs.getString(2));
                allEmployeeBean.setEmployeeId(rs.getString(3));
                allEmployeeBean.setDeactivate(rs.getInt(4));
                employeeList.add(allEmployeeBean);
            }
        }
        catch(Exception e){
            logger.log(Level.OFF, "AllEmployeeDao dao id : - " );
        }
        finally {
            System.out.println("inside the finally");
            Dbconnection.closeAll(rs, ps, con);
            System.out.println("close DB connection");
        } 
        return employeeList;
    }
}
