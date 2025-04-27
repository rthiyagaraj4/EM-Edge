

package eMR.MRPHoliday;

/**
 * Home interface for MRPHoliday
 */
public interface MRPHolidayManagerHome
extends javax.ejb.EJBHome {
    public static final String COMP_NAME = "java:comp/env/ejb/MRPHolidayManagerRemote";
    public static final String JNDI_NAME = "MRPHolidayManagerRemote";  

	 

    eMR.MRPHoliday.MRPHolidayManagerRemote create() throws javax.ejb.CreateException, java.rmi.RemoteException;
// ----------------------------------------------------------------
// Define your custom append code in a file called home-custom.vm
// and place it in your merge directory.
// ----------------------------------------------------------------
}
