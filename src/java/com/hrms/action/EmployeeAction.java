/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.action;

import com.hrms.beans.EmployeeVO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrms.dao.EmployeeDao;
import com.hrms.dbconnection.Dbconnection;
import com.hrms.form.EmployeeForm;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author srj
 */
public class EmployeeAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";
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
    Logger logger = Logger.getLogger(EmployeeAction.class.getName());

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        logger.log(Level.OFF, "inside Employee Action");
        EmployeeForm forms = (EmployeeForm) form;
        //EmployeeDao ed = new EmployeeDao();
        boolean valid = false;
        try {
            EmployeeVO employee = new EmployeeVO();
            employee.setUsername(forms.getUsername());
            employee.setPassword(forms.getPassword());
            valid = EmployeeDao.empvalidate(forms);

            //String username = forms.getUsername();
            if (valid) {
                EmployeeVO empvo = EmployeeDao.empDetails(forms.getUsername());
                request.setAttribute("employeeObj", empvo);
                System.out.println("empvo.getEmpId()" + empvo.getEmpId());
                ArrayList addressList = EmployeeDao.getEmpAddressDetails(empvo.getEmpId());

                request.setAttribute("addressList", addressList);
            }
            //request.setAttribute("empUsername", username);

        } catch (Exception e) {
            System.out.println("my error at EmployeeAction" + e);
            logger.log(Level.OFF, "inside Employee Action exception " + e);
        }

        if (valid == true) {
            return mapping.findForward(SUCCESS);
        } else {
            return mapping.findForward(FAIL);
        }

    }
}
