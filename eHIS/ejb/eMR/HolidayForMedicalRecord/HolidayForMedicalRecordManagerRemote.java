package eMR.HolidayForMedicalRecord;

/**
 * Remote interface for HolidayForMedicalRecord
**/

public interface HolidayForMedicalRecordManagerRemote 
extends javax.ejb.EJBObject {
    java.util.HashMap insertHolidayForMedicalRecord(java.util.Properties p, java.util.HashMap passObjects) throws java.rmi.RemoteException;  
    java.util.HashMap updateHolidayForMedicalRecord(java.util.Properties p, java.util.HashMap passObjects) throws java.rmi.RemoteException;
    java.util.HashMap deleteHolidayForMedicalRecord(java.util.Properties p, java.util.HashMap passObjects) throws java.rmi.RemoteException;
	java.util.HashMap deleteMultipleHolidayForMedicalRecords(java.util.Properties p, java.util.HashMap passObjects) throws java.rmi.RemoteException;
// ----------------------------------------------------------------
// Define your custom append code in a file called remote-custom.vm 
// and place it in your merge directory.
// ----------------------------------------------------------------
}