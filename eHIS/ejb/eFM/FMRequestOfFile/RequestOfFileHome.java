/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// Generated file. Do not edit.
// Generated by org.xdoclet.plugin.ejb.interfaces.RemoteHomeInterfacePlugin from eFM.FMRequestOfFile.RequestOfFileManager
package eFM.FMRequestOfFile;

/**
 * Home interface for FMRequestOfFile
 */
public interface RequestOfFileHome
extends javax.ejb.EJBHome {
    public static final String COMP_NAME = "java:comp/env/ejb/FMRequestOfFileRemote";
    public static final String JNDI_NAME = "FMRequestOfFileRemote";

    eFM.FMRequestOfFile.RequestOfFileRemote create() throws javax.ejb.CreateException, java.rmi.RemoteException;
// ----------------------------------------------------------------
// Define your custom append code in a file called home-custom.vm
// and place it in your merge directory.
// ----------------------------------------------------------------
}
