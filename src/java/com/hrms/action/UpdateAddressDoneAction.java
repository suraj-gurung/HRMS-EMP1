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

import java.util.logging.Level;
import java.util.logging.Logger;
import com.hrms.dao.UpdateAddressDao;
import com.hrms.beans.UpdateAddressFormBean;
import com.hrms.dao.ShowAddressDao;

/**
 *
 * @author srj
 */
public class UpdateAddressDoneAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String UPDATEDADDRESS = "UpdatedAddress";
    private static final String UPDATED = "updated";
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
    
    Logger logger = Logger.getLogger(UpdateAddressDoneAction.class.getName());
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
            
            String emp_id = request.getParameter("empId");
        String addId = request.getParameter("addressId");
        logger.log(Level.OFF, "inside update Address Action :-" + emp_id);
        
        UpdateAddressFormBean updateAddressFormBean = (UpdateAddressFormBean) form;
        logger.log(Level.OFF, "inside update Address FORM BEAN :-" + updateAddressFormBean);
        boolean updated = ShowAddressDao.updateDone(updateAddressFormBean);
        
        logger.log(Level.OFF, "RESULT :- " + updated);
        if(updated == true){
            return mapping.findForward(UPDATED);
        }
        return mapping.findForward(UPDATED);
}
}
