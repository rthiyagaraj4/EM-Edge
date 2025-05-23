/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// Generated file. Do not edit.
// Generated by org.xdoclet.plugin.ejb.interfaces.LocalHomeInterfacePlugin from eMP.PatientRegistration.PatientRegistrationManager
package eMP.PatientRegistration;

/**
 * Local-Home interface for PatientRegistration
 */
public interface PatientRegistrationLocalHome
extends javax.ejb.EJBLocalHome {
    public static final String COMP_NAME = "java:comp/env/ejb/PatientRegistrationLocal";
    public static final String JNDI_NAME = "PatientRegistrationLocal";

    eMP.PatientRegistration.PatientRegistrationLocal create() throws javax.ejb.CreateException;
// ----------------------------------------------------------------
// Define your custom append code in a file called local-home-custom.vm
// and place it in your merge directory.
// ----------------------------------------------------------------
}
