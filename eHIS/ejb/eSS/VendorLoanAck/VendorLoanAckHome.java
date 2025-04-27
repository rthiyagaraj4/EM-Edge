

package eSS.VendorLoanAck;

import eSS.Common.SsEJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface VendorLoanAckHome
    extends SsEJBHome
{

    public abstract VendorLoanAckRemote create()
        throws RemoteException, CreateException;
} 