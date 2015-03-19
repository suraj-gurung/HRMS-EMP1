/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.dao;

import com.hrms.beans.AddressVo;
import com.hrms.beans.EmployeeVO;
import com.hrms.dbconnection.Dbconnection;
import java.sql.*;
import java.util.*;
import com.hrms.form.*;

/**
 *
 * @author srj
 */
public class EmployeeDao {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public static boolean empvalidate(EmployeeForm form) {
        System.out.println("inside in the empvalidate");
        boolean result = false;
        //boolean exist=true;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = Dbconnection.getCon();
            ps = con.prepareStatement(" select * from employee where username=? and password=? ");
            ps.setString(1, form.getUsername());
            ps.setString(2, form.getPassword());
            rs = ps.executeQuery();
            String users = form.getUsername();
            String pswd = form.getPassword();
            System.out.println("form user" + users);
            System.out.println("form password" + pswd);
            if(rs.next()) {
                
                String user = rs.getString("username");
                String pass = rs.getString("password");
                int employeeid = rs.getInt("emp_id");
                
                if ((users.equals(user) && pswd.equals(pass))) {
                    result = true;
                    //return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in EmployeeDao enpValidate method:" + e);
        } finally {
            System.out.println("inside the finally");
            Dbconnection.closeAll(rs, ps, con);
        }

        return result;
    }
    
    public static EmployeeVO empDetails(String username) throws Exception{
        
        ArrayList list = new ArrayList();
        
        System.out.println("inside in the empvalidate");
        boolean result = false;
        //boolean exist=true;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        EmployeeVO evo = null;
        try {
            con = Dbconnection.getCon();
            StringBuilder sb = new StringBuilder();
            sb.append(" select id , username, e.depart_id, emp_id, d.dept_name from employee e, department d ");
            sb.append(" where username=? and e.depart_id= d.depart_id ");
            
            /*
            sb.append(" select id , username, e.depart_id, emp_id, d.dept_name from employee e, department d ");
            sb.append(" where username= '");
            sb.append(username);
            sb.append("' and e.depart_id= d.depart_id  ");
            */
            System.out.println(" sql : "+ sb.toString());
            
            ps = con.prepareStatement(sb.toString());
            ps.setString(1, username);
            //ps.setString(2, form.getPassword());
            rs = ps.executeQuery();
            //String users = form.getUsername();
            //String pswd = form.getPassword();
            //System.out.println("form user" + users);
            //System.out.println("form password" + pswd);
            if(rs.next()) {
                System.out.println("inside the while loop");
                evo = new EmployeeVO();
                evo.setId(rs.getInt(1));
                evo.setUsername(rs.getString(2));
                evo.setId(rs.getInt(3));
                evo.setEmpId(rs.getString(4));
                evo.setDeptName(rs.getString(5));
                
            }
        } catch (Exception e) {
            System.out.println("Exception in EmployeeDao enpValidate method:" + e);
        } finally {
            System.out.println("inside the finally");
            Dbconnection.closeAll(rs, ps, con);
        }
 
        return evo;
    }


public static ArrayList getEmpAddressDetails(String empid) throws Exception{
        
        ArrayList addressList = new ArrayList();
        
        System.out.println("inside in the getEmpAddressDetails");
        boolean result = false;
        //boolean exist=true;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        EmployeeVO evo = null;
        try {
            con = Dbconnection.getCon();
            StringBuilder sb = new StringBuilder();
            sb.append(" select address , city , street , state , pincode , country , address_type_name ");
            sb.append(" from address a , address_type at   where a.add_type= at.add_type and emp_id='");
            sb.append(empid);
            sb.append("'");
            System.out.println(" sql : "+ sb.toString());
            
            ps = con.prepareStatement(sb.toString());
           // ps.setString(1, empid);
            //ps.setString(2, form.getPassword());
            rs = ps.executeQuery();
            //String users = form.getUsername();
            //String pswd = form.getPassword();
            //System.out.println("form user" + users);
            //System.out.println("form password" + pswd);
            while(rs.next()) {
                System.out.println("inside the while loop");
                AddressVo avo = new AddressVo();
                avo.setAddress(rs.getString(1));
                avo.setCity(rs.getString(2));
                avo.setStreet(rs.getString(3));
                avo.setState(rs.getString(4));
                avo.setPincode(rs.getInt(5));
                avo.setCountry(rs.getString(6));
                avo.setAddressTypeName(rs.getString(7));
                addressList.add(avo);
            }
        } catch (Exception e) {
            System.out.println("Exception in EmployeeDao getEmpAddressDetails method:" + e);
        } finally {
            System.out.println("inside the finally");
            Dbconnection.closeAll(rs, ps, con);
            System.out.println("close DB connection");
        } 
        return addressList;
    }
}
