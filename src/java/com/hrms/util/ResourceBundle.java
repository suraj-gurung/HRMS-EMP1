/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.util;

import java.util.Locale;

/**
 *
 * @author bbhushan
 */
public class ResourceBundle {

    private static final java.util.ResourceBundle rb = java.util.ResourceBundle.getBundle("MessageResources", Locale.US);

    public static String getValue(String key) {
        return rb.getString(key);
    }

    public static int getIntValue(String key) {
        return Integer.parseInt(rb.getString(key));
    }
    
     public static long getLongValue(String key) {
        return Long.parseLong(rb.getString(key));
    }
}
