/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.dao;

import com.hrms.dbconnection.Dbconnection;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import com.hrms.beans.UpdateAddressFormBean;

/**
 *
 * @author srj
 */
public class UpdateAddressDao {

    Logger logger = Logger.getLogger(UpdateAddressDao.class.getName());

    public static boolean updateDone(UpdateAddressFormBean updateAddress) {

        boolean result = false;

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = Dbconnection.getCon();
            StringBuilder sb = new StringBuilder();
            sb.append(" UPDATE address SET  ");
            sb.append(" address=? , street=? , city=? , state=? , pincode=? , country=? ");
            sb.append(" FROM address ad, address_type at ");
            sb.append(" where ad.emp_id=? && ad.add_Type=at.add_type ");
            ps = con.prepareStatement(sb.toString());

            ps.setString(1, updateAddress.getAddress());
            ps.setString(2, updateAddress.getStreet());
            ps.setString(3, updateAddress.getCity());
            ps.setString(4, updateAddress.getState());
            ps.setInt(5, updateAddress.getPincode());
            ps.setString(6, updateAddress.getCountry());
            ps.setString(7, updateAddress.getEmployeeId());

            int count = ps.executeUpdate();

            if (count > 0) {
                result = true;
            } else {
                result = false;
            }
        } catch (Exception e) {
            System.out.println("sql exception occur" + e);
        } finally {
            Dbconnection.closeAll(rs, ps, con);
        }
        return result;
    }
}
