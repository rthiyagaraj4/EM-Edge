
// Generated file. Do not edit.
// Generated by org.xdoclet.plugin.ejb.interfaces.RemoteHomeInterfacePlugin from eCP.AssessmentBasedTerminologyCode.AssessmentBasedTerminologyCodeManager
package eCP.AssessmentBasedTerminologyCode;

/**
 * Home interface for AssessmentBasedTerminologyCode
 */
public interface AssessmentBasedTerminologyCodeHome
extends javax.ejb.EJBHome {
    public static final String COMP_NAME = "java:comp/env/ejb/AssessmentBasedTerminologyCodeRemote";
    public static final String JNDI_NAME = "AssessmentBasedTerminologyCodeRemote";

    eCP.AssessmentBasedTerminologyCode.AssessmentBasedTerminologyCodeRemote create() throws javax.ejb.CreateException, java.rmi.RemoteException;
// ----------------------------------------------------------------
// Define your custom append code in a file called home-custom.vm
// and place it in your merge directory.
// ----------------------------------------------------------------
}
