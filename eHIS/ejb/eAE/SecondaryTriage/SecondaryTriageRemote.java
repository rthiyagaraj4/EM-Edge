/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// Generated file. Do not edit.
// Generated by org.xdoclet.plugin.ejb.interfaces.RemoteInterfacePlugin from eAE.SecondaryTriage.SecondaryTriageManager
package eAE.SecondaryTriage;

/**
 * Remote interface for SecondaryTriage
 */
public interface SecondaryTriageRemote 
extends javax.ejb.EJBObject {
    java.util.HashMap insertSecondaryTriage(java.util.Properties p, java.util.HashMap ae_pr_encounter_add, java.util.HashMap ae_pr_encounter_oth_dtls, java.util.HashMap ae_pat_emergency_dtls, java.util.HashMap ae_pat_triage, java.util.HashMap session_details) throws java.rmi.RemoteException;
// ----------------------------------------------------------------
// Define your custom append code in a file called remote-custom.vm 
// and place it in your merge directory.
// ----------------------------------------------------------------
}
