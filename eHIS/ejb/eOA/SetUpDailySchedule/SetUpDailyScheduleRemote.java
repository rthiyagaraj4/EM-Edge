/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// Generated file. Do not edit.
// Generated by org.xdoclet.plugin.ejb.interfaces.RemoteInterfacePlugin from eOA.SetUpDailySchedule.SetUpDailyScheduleManager
package eOA.SetUpDailySchedule;

/**
 * Remote interface for SetUpDailySchedule
 */
public interface SetUpDailyScheduleRemote 
extends javax.ejb.EJBObject {
    java.util.HashMap insertSetUpDailySchedule(java.util.Properties p, java.util.HashMap tabdata) throws java.rmi.RemoteException;
    java.util.HashMap modifySetUpDailySchedule(java.util.Properties p, java.util.HashMap tabdata) throws java.rmi.RemoteException;
    java.util.HashMap deleteSetUpDailySchedule(java.util.Properties p, java.util.HashMap tabdata) throws java.rmi.RemoteException;
// ----------------------------------------------------------------
// Define your custom append code in a file called remote-custom.vm 
// and place it in your merge directory.
// ----------------------------------------------------------------
}
