package eBL.ChargePatientNewOrder;

import java.rmi.* ;
import javax.ejb.* ;


public interface ChargePatientNewOrderHome extends EJBHome {
    public ChargePatientNewOrderRemote create() throws RemoteException, CreateException ;
}