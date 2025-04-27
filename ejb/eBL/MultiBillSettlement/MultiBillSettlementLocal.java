/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL.MultiBillSettlement;
import java.util.HashMap;
import javax.ejb.EJBLocalObject;
import oracle.sql.ARRAY;

public interface MultiBillSettlementLocal extends EJBLocalObject {
	public HashMap<String,String> insertRecords(java.util.Properties p,HashMap<String,String> inputParameters,HashMap<String,ARRAY> arrayInputParameters);
}
