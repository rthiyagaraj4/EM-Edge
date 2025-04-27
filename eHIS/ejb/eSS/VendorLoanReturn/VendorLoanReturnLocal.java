package eSS.VendorLoanReturn;

import javax.ejb.EJBLocalObject;
import java.util.HashMap;


public interface VendorLoanReturnLocal extends EJBLocalObject {
		public abstract HashMap insert(HashMap hashmap, HashMap hashmap1);
		public abstract HashMap modify(HashMap hashmap, HashMap hashmap1);
		public abstract HashMap delete(HashMap hashmap, HashMap hashmap1);
}