package eMR.HolidayForMedicalRecord;

/**
 * Local interface for HolidayForMedicalRecord
**/

public interface HolidayForMedicalRecordManagerLocal 
extends javax.ejb.EJBLocalObject {
    java.util.HashMap insertHolidayForMedicalRecord(java.util.Properties p, java.util.HashMap passObjects);    
    java.util.HashMap updateHolidayForMedicalRecord(java.util.Properties p, java.util.HashMap passObjects);
    java.util.HashMap deleteHolidayForMedicalRecord(java.util.Properties p, java.util.HashMap passObjects);
	java.util.HashMap deleteMultipleHolidayForMedicalRecords(java.util.Properties p, java.util.HashMap passObjects); 
// ----------------------------------------------------------------
// Define your custom append code in a file called local-custom.vm 
// and place it in your merge directory.
// ----------------------------------------------------------------
}