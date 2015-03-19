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

import com.hrms.dao.ShowAddressDao;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author srj
 */
public class ShowAddressAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SHOWADDRESS = "gotAddress";

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
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
            String actionId="";
            if(request.getParameter("actionId")!=null){
                actionId= request.getParameter("actionId");
            }
            
            if("delete".equals(actionId)){
             //do your work
                //return findForward
            }else if("update".equals(actionId)){
                //do your work
            }else if("".equals(actionId)){
            
            }
            String emp_id = request.getParameter("q");
            logger.log(Level.OFF, "inside Show Address Action" + emp_id);
            
            ArrayList showAddressLists = ShowAddressDao.showAddress(emp_id);
            
            request.setAttribute("showAddressList", showAddressLists);
        
        return mapping.findForward(SHOWADDRESS);
    }
}
