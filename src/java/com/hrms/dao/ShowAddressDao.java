/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.dao;

import java.sql.*;
import com.hrms.dbconnection.Dbconnection;
import com.hrms.beans.ShowAddressBean;
import com.hrms.beans.UpdateAddressFormBean;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;


/**
 *
 * @author srj
 */
public class ShowAddressDao {

    static Logger logger = Logger.getLogger(ShowAddressDao.class.getName());
    
    public static ArrayList showAddress(String emp_id){
        
        ArrayList showAddressList = new ArrayList();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            con = Dbconnection.getCon();
            StringBuilder sb = new StringBuilder();
            sb.append(" select address , street , city , state , pincode , country, emp_id, address_type_Name, add_id from address a , address_type at " );
            sb.append(" where a.add_type=at.add_type and emp_id='");
            sb.append(emp_id);
            sb.append("'");
            
            logger.log(Level.OFF, "within a ShowAddressDao try catch block :" + sb.toString());
            
            ps = con.prepareStatement(sb.toString());
            rs = ps.executeQuery();
            
            while(rs.next()){
                ShowAddressBean showAddressBean = new ShowAddressBean();
                showAddressBean.setAddress(rs.getString(1));
                showAddressBean.setStreet(rs.getString(2));
                showAddressBean.setCity(rs.getString(3));
                showAddressBean.setState(rs.getString(4));
                showAddressBean.setPincode(rs.getInt(5));
                showAddressBean.setCountry(rs.getString(6));
                showAddressBean.setEmployeeId(rs.getString(7));
                showAddressBean.setAddressTypeName(rs.getString(8));
                showAddressBean.setAddressId(rs.getInt(9));
                showAddressList.add(showAddressBean);
            }
        }
        catch(SQLException e){
            logger.log(Level.OFF, "within a ShowAddressDao catch block :" + e);
        }
        return showAddressList;
    }
    
    public static ArrayList showEditAddress(String emp_id, int addType){
        
        ArrayList showAddressList = new ArrayList();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            con = Dbconnection.getCon();
            StringBuilder sb = new StringBuilder();
            sb.append(" select address , street , city , state , pincode , country, emp_id, address_type_Name from address a , address_type at " );
            sb.append(" where a.add_type=' ");
            sb.append(addType);
            sb.append(" ' and emp_id=' ");
            sb.append(emp_id);
            sb.append("'");
            
            logger.log(Level.OFF, "within a ShowAddressDao try catch block :" + sb.toString());
            
            ps = con.prepareStatement(sb.toString());
            rs = ps.executeQuery();
            
            while(rs.next()){
                ShowAddressBean showAddressBean = new ShowAddressBean();
                showAddressBean.setAddress(rs.getString(1));
                showAddressBean.setStreet(rs.getString(2));
                showAddressBean.setCity(rs.getString(3));
                showAddressBean.setState(rs.getString(4));
                showAddressBean.setPincode(rs.getInt(5));
                showAddressBean.setCountry(rs.getString(6));
                showAddressBean.setEmployeeId(rs.getString(7));
                showAddressBean.setAddressTypeName(rs.getString(8));
                showAddressList.add(showAddressBean);
            }
        }
        catch(Exception e){
            logger.log(Level.OFF, "within a ShowAddressDao catch block :" + e);
        }
        return showAddressList;
    }
    
    public static boolean updateDone(UpdateAddressFormBean forms) {

        boolean result = false;
        int count = 0;
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = Dbconnection.getCon();
            
            String address = forms.getAddress();
            String street = forms.getStreet();
            String city = forms.getCity();
            String state = forms.getState();
            int pincode = forms.getPincode();
            String country = forms.getCountry();
            String employeeId = forms.getEmployeeId();
            int addressId = forms.getAddressId();
            System.out.println("address id : - " + addressId);
            
            StringBuilder sb = new StringBuilder();
            sb.append(" UPDATE address SET address= '");
            sb.append(address);
            sb.append("' , street='");
            sb.append(street);
            sb.append("' , city='");
            sb.append(city);
            sb.append("' , state='");
            sb.append(state);
            sb.append("' , pincode= ");
            sb.append(pincode);
            sb.append(" , country='");
            sb.append(country);
            sb.append("' where emp_id='");
            sb.append(employeeId);
            sb.append("' AND add_Type=");
            sb.append(addressId);
            sb.append(" ");
            
            logger.log(Level.OFF, "within a update Done try catch block :" + sb.toString());
            
            String testaddress = forms.getAddress();
            logger.log(Level.OFF, "within a testaddress :" + testaddress);
            
            ps = con.prepareStatement(sb.toString());
            
//            ps.setString(1, forms.getAddress());
//            ps.setString(2, forms.getStreet());
//            ps.setString(3, forms.getCity());
//            ps.setString(4, forms.getState());
//            ps.setInt(5, forms.getPincode());
//            ps.setString(6, forms.getCountry());
//            ps.setString(7, forms.getEmployeeId());
//            ps.setString(8, forms.getAddressId());
              
            logger.log(Level.OFF, "within a update Done after pstatement :" + sb.toString());
            
            count = ps.executeUpdate();
            logger.log(Level.OFF, "number of rows effected :" + count);
            if (count > 0) {
                result = true;
            } else {
                result = false;
            }
        } catch (SQLException e) {
            System.out.println("sql exception occur" + e);
        } finally {
            Dbconnection.closeAll(rs, ps, con);
        }
        return result;
    }
}

