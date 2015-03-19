/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrms.dao.AllEmployeeDao;
import com.hrms.beans.AllEmployeeBean;
import java.util.ArrayList;

/**
 *
 * @author srj
 */
public class AllEmployeeAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String ALLEMPLOYEE = "allEmployee";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        //AllEmployeeDao AllEmployeeDao = null;
        //ArrayList AllEmployeeList = null;
        try{
            ArrayList AllEmployeeList = AllEmployeeDao.getEmployees();
         
            request.setAttribute("AllEmployee", AllEmployeeList);
        }
        catch(Exception e){
            System.out.println("AllEmployeeAction :- " + e);
        }
        return mapping.findForward(ALLEMPLOYEE);
    }
}
