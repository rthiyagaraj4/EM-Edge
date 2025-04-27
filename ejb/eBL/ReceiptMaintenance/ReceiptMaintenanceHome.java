package eBL.ReceiptMaintenance;

import java.rmi.* ;
import javax.ejb.* ;


public interface ReceiptMaintenanceHome extends EJBHome {
    public ReceiptMaintenanceRemote create() throws RemoteException, CreateException ;
}