package eSS.VendorLoanAck;

import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface VendorLoanAckLocalHome extends EJBLocalHome {
		public VendorLoanAckLocal create() throws CreateException ;
} 