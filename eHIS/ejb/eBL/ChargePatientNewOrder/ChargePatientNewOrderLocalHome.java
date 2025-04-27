package eBL.ChargePatientNewOrder;

import javax.ejb.* ;

public interface ChargePatientNewOrderLocalHome extends EJBLocalHome {
    public ChargePatientNewOrderLocal create() throws CreateException ;
}