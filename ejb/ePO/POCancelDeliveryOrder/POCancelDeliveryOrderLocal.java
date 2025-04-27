/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
  package ePO.POCancelDeliveryOrder;


import javax.ejb.EJBLocalObject;
import java.util.HashMap;

public interface POCancelDeliveryOrderLocal extends EJBLocalObject {
		public abstract HashMap insert(HashMap hashmap, HashMap hashmap1);
		public abstract HashMap modify(HashMap hashmap, HashMap hashmap1);
		public abstract HashMap delete(HashMap hashmap, HashMap hashmap1);
}


 
