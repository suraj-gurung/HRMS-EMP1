/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.beans;

/**
 *
 * @author srj
 */
public class AllEmployeeBean {
    
    String username;
    String departName;
    String employeeId;
    int deactivate;

    public int getDeactivate() {
        return deactivate;
    }

    public void setDeactivate(int deactivate) {
        this.deactivate = deactivate;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }
    
}
