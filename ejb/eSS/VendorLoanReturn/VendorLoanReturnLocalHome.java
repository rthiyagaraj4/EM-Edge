package eSS.VendorLoanReturn;

import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface VendorLoanReturnLocalHome extends EJBLocalHome {
	public VendorLoanReturnLocal create() throws CreateException;
}