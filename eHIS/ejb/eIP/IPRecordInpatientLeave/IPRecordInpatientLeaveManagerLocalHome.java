/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// Generated file. Do not edit.
// Generated by org.xdoclet.plugin.ejb.interfaces.LocalHomeInterfacePlugin from eIP.IPRecordInpatientLeave.IPRecordInpatientLeaveManager
package eIP.IPRecordInpatientLeave;

/**
 * Local-Home interface for IPRecordInpatientLeave
 */
public interface IPRecordInpatientLeaveManagerLocalHome
extends javax.ejb.EJBLocalHome {
    public static final String COMP_NAME = "java:comp/env/ejb/IPRecordInpatientLeaveLocal";
    public static final String JNDI_NAME = "IPRecordInpatientLeaveLocal";

    eIP.IPRecordInpatientLeave.IPRecordInpatientLeaveManagerLocal create() throws javax.ejb.CreateException;
// ----------------------------------------------------------------
// Define your custom append code in a file called local-home-custom.vm
// and place it in your merge directory.
// ----------------------------------------------------------------
}
