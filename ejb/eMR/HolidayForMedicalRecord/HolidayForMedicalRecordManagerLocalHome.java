package eMR.HolidayForMedicalRecord;

/**
 * Local-Home interface for HolidayForMedicalRecord
**/

public interface HolidayForMedicalRecordManagerLocalHome extends javax.ejb.EJBLocalHome {
    public static final String COMP_NAME = "java:comp/env/ejb/HolidayForMedicalRecordManagerLocal";
    public static final String JNDI_NAME = "HolidayForMedicalRecordManagerLocal";
    eMR.HolidayForMedicalRecord.HolidayForMedicalRecordManagerLocal create() throws javax.ejb.CreateException;
// ----------------------------------------------------------------
// Define your custom append code in a file called local-home-custom.vm
// and place it in your merge directory.
// ----------------------------------------------------------------
}