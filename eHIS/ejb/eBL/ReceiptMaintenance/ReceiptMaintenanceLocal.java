package eBL.ReceiptMaintenance;

import javax.ejb.* ;
import java.sql.* ;

public interface ReceiptMaintenanceLocal extends EJBLocalObject
{
    public java.util.HashMap insertEncounterDetails(java.util.HashMap tabdata,java.util.Properties p);
    
}
