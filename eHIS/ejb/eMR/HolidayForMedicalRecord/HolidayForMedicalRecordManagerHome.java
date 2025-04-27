package eMR.HolidayForMedicalRecord;

/**
 * Home interface for HolidayForMedicalRecord
**/

public interface HolidayForMedicalRecordManagerHome
extends javax.ejb.EJBHome {
    public static final String COMP_NAME = "java:comp/env/ejb/HolidayForMedicalRecordManagerRemote";
    public static final String JNDI_NAME = "HolidayForMedicalRecordManagerRemote";  
	eMR.HolidayForMedicalRecord.HolidayForMedicalRecordManagerRemote create() throws javax.ejb.CreateException, java.rmi.RemoteException;
// ----------------------------------------------------------------
// Define your custom append code in a file called home-custom.vm
// and place it in your merge directory.
// ----------------------------------------------------------------
}