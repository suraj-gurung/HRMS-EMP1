/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.action;

import com.hrms.beans.ShowAddressBean;
import com.hrms.beans.UpdateAddressFormBean;
import com.hrms.dao.EmployeeUpdateDao;
import com.hrms.form.DeactivateEmpForm;

import com.hrms.dao.ShowAddressDao;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.hrms.dao.ShowAddressDao;
import java.io.PrintWriter;
import org.apache.struts.actions.DispatchAction;

/**
 *
 * @author srj
 */
public class UpdateAddressAction extends DispatchAction {

    /* forward name="success" path="" */
    private static final String GETADDRESS = "getAddress";
    private static final String UPDATED = "updated";
    private static final String DEACTIVATED = "deactivated";
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
    Logger logger = Logger.getLogger(ShowAddressAction.class.getName());

    public ActionForward getAddressDetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        int addType = 0;
        String emp_id = request.getParameter("q");
//            String addressType = request.getParameter("r");
//            
//            if(addressType=="local"){
//                addType=1;
//            } else if (addressType=="permanent"){
//                addType=2;
//            } else {
//                addType=3;
//            }

        logger.log(Level.OFF, "inside update Address Action :-" + emp_id);
        ArrayList showAddressLists = ShowAddressDao.showAddress(emp_id);

        request.setAttribute("showAddressList", showAddressLists);

        return mapping.findForward(GETADDRESS);
    }

    public ActionForward updateAddressDetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String addId = request.getParameter("addressId");

        logger.log(Level.OFF, "inside update Address Action :-" + addId);
        ArrayList showAddressLists = ShowAddressDao.showAddress(addId);

        for (int x = 0; showAddressLists.size() > x; x++) {
            ShowAddressBean showAddressBean = (ShowAddressBean) showAddressLists.get(x);
            if (showAddressBean.getAddressId() == (Integer.parseInt(addId))) {
                //request.setAttribute("showAddressBean", showAddressBean ); break;
                showAddressBean.setCountry(addId);
                showAddressBean.setAddress(addId);

                //Dao.upate(showAddressBean,addId);
            }
        }

        // request.setAttribute("showAddressList", showAddressLists);

        return mapping.findForward(GETADDRESS);
    }

    public ActionForward showAddressDetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String emp_id = request.getParameter("empId");
        String addId = request.getParameter("addressId");

        logger.log(Level.OFF, "inside update Address Action :-" + emp_id);
        ArrayList showAddressLists = ShowAddressDao.showAddress(emp_id);

        for (int x = 0; showAddressLists.size() > x; x++) {
            ShowAddressBean showAddressBean = (ShowAddressBean) showAddressLists.get(x);
            if (showAddressBean.getAddressId() == (Integer.parseInt(addId))) {
                request.setAttribute("showAddressBean", showAddressBean);
                break;
            }
        }

        // request.setAttribute("showAddressList", showAddressLists);

        //return mapping.findForward(GETADDRESS);
        return mapping.findForward("showAddress");
    }
    
    public ActionForward updateDone(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
    throws Exception{
        
        String emp_id = request.getParameter("empId");
        String addId = request.getParameter("addressId");
        logger.log(Level.OFF, "inside update Address Action :-" + emp_id);
        
        UpdateAddressFormBean forms = (UpdateAddressFormBean) form;
        
        String addressType = forms.getAddressType();
        request.setAttribute("addressType", addressType);
        
        logger.log(Level.OFF, "inside update Address FORM BEAN :-" + forms);
        boolean updated = ShowAddressDao.updateDone(forms);
        
        logger.log(Level.OFF, "RESULT :- " + updated);
        if(updated == true){
            return mapping.findForward(UPDATED);
        }
        return mapping.findForward(UPDATED);
    }
    
    public ActionForward deActivateEmployee(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
    throws Exception{
        logger.log(Level.OFF, " inside the deActivateEmployee method ");
        String empIds = "";
        
        DeactivateEmpForm deactivateEmpForm = (DeactivateEmpForm) form;
        logger.log(Level.OFF, " DeactivateEmpForm object created ");
        String[] employeeIds = deactivateEmpForm.getDeActivateEmp();
        logger.log(Level.OFF, "number of employeeIds check :-" + employeeIds.length);
        for(int i=0; i<employeeIds.length; i ++){
            if(employeeIds.length==i+1){
                empIds = empIds + employeeIds[i];
            }
            else{
                empIds = empIds + employeeIds[i] + ",";
            }
        }
            boolean updated = EmployeeUpdateDao.updateEmpDeactivationStatus(1, empIds);
            if(updated == true){
            return mapping.findForward(DEACTIVATED);
        }
        return mapping.findForward(DEACTIVATED);
    }
}
