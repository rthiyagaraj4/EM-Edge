package eBL.EnterReceiptRefund;


import javax.ejb.* ;
import java.sql.* ;

public interface EnterReceiptRefundLocal extends EJBLocalObject
{
    public java.util.HashMap insert(java.util.Properties p,java.util.HashMap support_data,java.util.HashMap mult_slmt_vals);
    public java.util.HashMap insertDepositData(java.util.Properties p,java.util.HashMap support_data,java.util.HashMap mult_slmt_vals);
    
}
