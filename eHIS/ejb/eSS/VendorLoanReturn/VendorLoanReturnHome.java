package eSS.VendorLoanReturn;

import javax.ejb.CreateException;
import eSS.Common.SsEJBHome;
import java.rmi.RemoteException;

public interface VendorLoanReturnHome extends SsEJBHome {
	public VendorLoanReturnRemote create() throws RemoteException, CreateException;
} 