package eSS.VendorLoanAck;


import javax.ejb.EJBLocalObject;
import java.util.HashMap;

public interface VendorLoanAckLocal extends EJBLocalObject {
		public abstract HashMap insert(HashMap hashmap, HashMap hashmap1);
		public abstract HashMap modify(HashMap hashmap, HashMap hashmap1);
		public abstract HashMap delete(HashMap hashmap, HashMap hashmap1);
} 