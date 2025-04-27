package eBL.ReceiptMaintenance;

import java.rmi.* ;

import javax.ejb.* ;
import java.sql.* ;


public interface ReceiptMaintenanceRemote extends EJBObject
{
	 public java.util.HashMap insertEncounterDetails(java.util.HashMap tabdata,java.util.Properties p) throws RemoteException;
	    
}
									 