

package eMR.MRPHoliday;

/**
 * Local interface for MRPHoliday
 */
public interface MRPHolidayManagerLocal 
extends javax.ejb.EJBLocalObject {
    java.util.HashMap insertMRPHoliday(java.util.Properties p, java.util.HashMap passObjects);    
    java.util.HashMap updateMRPHoliday(java.util.Properties p, java.util.HashMap passObjects);
    java.util.HashMap deleteMRPHoliday(java.util.Properties p, java.util.HashMap passObjects);
	java.util.HashMap deleteMultipleMRPHolidays(java.util.Properties p, java.util.HashMap passObjects); 
    
 
	
	
// ----------------------------------------------------------------
// Define your custom append code in a file called local-custom.vm 
// and place it in your merge directory.
// ----------------------------------------------------------------
}
