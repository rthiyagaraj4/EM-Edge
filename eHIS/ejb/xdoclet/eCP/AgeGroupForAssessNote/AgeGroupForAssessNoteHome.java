
// Generated file. Do not edit.
// Generated by org.xdoclet.plugin.ejb.interfaces.RemoteHomeInterfacePlugin from eCP.AgeGroupForAssessNote.AgeGroupForAssessNoteManager
package eCP.AgeGroupForAssessNote;

/**
 * Home interface for AgeGroupForAssessNote
 */
public interface AgeGroupForAssessNoteHome
extends javax.ejb.EJBHome {
    public static final String COMP_NAME = "java:comp/env/ejb/AgeGroupForAssessNoteRemote";
    public static final String JNDI_NAME = "AgeGroupForAssessNoteRemote";

    eCP.AgeGroupForAssessNote.AgeGroupForAssessNoteRemote create() throws javax.ejb.CreateException, java.rmi.RemoteException;
// ----------------------------------------------------------------
// Define your custom append code in a file called home-custom.vm
// and place it in your merge directory.
// ----------------------------------------------------------------
}
