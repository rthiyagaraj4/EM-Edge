package eBL.EnterReceiptRefund;

import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;

public interface EnterReceiptRefundRemote extends EJBObject
{
    public java.util.HashMap insert(java.util.Properties p,java.util.HashMap support_data,java.util.HashMap mult_slmt_vals) throws RemoteException;
    public java.util.HashMap insertDepositData(java.util.Properties p,java.util.HashMap support_data,java.util.HashMap mult_slmt_vals) throws RemoteException;
    
}
