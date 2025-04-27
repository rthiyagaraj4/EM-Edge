package eBL.ReceiptMaintenance;

import javax.ejb.* ;

public interface ReceiptMaintenanceLocalHome extends EJBLocalHome {
    public ReceiptMaintenanceLocal create() throws CreateException ;
}