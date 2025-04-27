

package eMR.MRPHoliday;

/**
 * Remote interface for MRPHoliday
 */
public interface MRPHolidayManagerRemote 
extends javax.ejb.EJBObject {
    java.util.HashMap insertMRPHoliday(java.util.Properties p, java.util.HashMap passObjects) throws java.rmi.RemoteException;  
    java.util.HashMap updateMRPHoliday(java.util.Properties p, java.util.HashMap passObjects) throws java.rmi.RemoteException;
    java.util.HashMap deleteMRPHoliday(java.util.Properties p, java.util.HashMap passObjects) throws java.rmi.RemoteException;
	java.util.HashMap deleteMultipleMRPHolidays(java.util.Properties p, java.util.HashMap passObjects) throws java.rmi.RemoteException; 
   
    

// ----------------------------------------------------------------
// Define your custom append code in a file called remote-custom.vm 
// and place it in your merge directory.
// ----------------------------------------------------------------
}
