 
package com.hrms.dao;

import com.hrms.action.EmployeeAction;
import java.sql.*;
import javax.sql.*;
import com.hrms.dbconnection.Dbconnection;
import com.hrms.beans.EmployeeUpdateBean;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

//import java.util.*;
/**
 *
 * @author srj
 */
public class EmployeeUpdateDao {
    
    static Logger logger = Logger.getLogger(EmployeeUpdateDao.class.getName());
    
     

    public static EmployeeUpdateBean employeeUpdate( String emp_id) throws Exception{
        Connection con = null;
     PreparedStatement ps = null;
     ResultSet rs = null;
        ArrayList updateList = new ArrayList(); 
        EmployeeUpdateBean eubs = null;
        String emp_Id = emp_id;
        
        try{
            logger.log(Level.OFF, "employee update dao id : - " + emp_Id);
            con = Dbconnection.getCon();
            
            StringBuilder sb = new StringBuilder();
            sb.append(" select id , username, e.depart_id, emp_id, d.dept_name from employee e, department d where emp_id='"+emp_Id+"' and e.depart_id= d.depart_id ");
           // sb.append(" where emp_id=? and e.depart_id= d.depart_id ");
            
            logger.log(Level.OFF, "within a employeeUpdate try catch block :" + sb.toString());
            
            ps = con.prepareStatement(sb.toString());
           // ps.setString(1, emp_Id);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                eubs = new EmployeeUpdateBean();
                eubs.setEmp_id(rs.getString(1));
                eubs.setUsername(rs.getString(2));
                eubs.setDeptId(rs.getInt(3));
                eubs.setEmp_id(rs.getString(4));
                eubs.setDeptName(rs.getString(5));
            }
        }
        catch(SQLException e){
            logger.log(Level.OFF, "inside of EmployeeUpdateDao" + e);
        }
        finally{
            Dbconnection.closeAll(rs, ps, con);
        }
        
        return eubs;
    }
    
    public static boolean updateEmpDeactivationStatus(int deActivateStatus, String empIds){
        
        boolean result = false;
        int count = 0;
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            con = Dbconnection.getCon();
            logger.log(Level.OFF, "inside of updateEmpDeactivationStatus - try catch block.");
            StringBuilder sb = new StringBuilder();
            
            sb.append(" UPDATE employee SET deactivate ='");
            sb.append(deActivateStatus);
            sb.append("' WHERE emp_id in (");
            sb.append((empIds));
            sb.append(") ");
            
            logger.log(Level.OFF, "updateEmpDeactivationStatus - sql statement :- " + sb.toString());
            ps = con.prepareStatement(sb.toString());
            
            count = ps.executeUpdate();
            logger.log(Level.OFF, "number of rows effected :" + count);
            if (count > 0) {
                result = true;
            } else {
                result = false;
            }
        }
        catch(SQLException e){
            logger.log(Level.OFF, "inside of updateEmpDeactivationStatus :- " + e);
        }
        finally{
            Dbconnection.closeAll(rs, ps, con);
        }
        logger.log(Level.OFF, "inside of updateEmpDeactivationStatus :- " + result);
        return result;
    }
}
