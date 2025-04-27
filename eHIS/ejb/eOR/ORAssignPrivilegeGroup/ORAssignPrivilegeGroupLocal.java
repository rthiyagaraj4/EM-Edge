/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR.ORAssignPrivilegeGroup ;

import java.rmi.* ;
import javax.ejb.* ;
import java.util.* ;

import eOR.Common.* ;

public interface ORAssignPrivilegeGroupLocal extends EJBLocalObject{

	public HashMap insert( HashMap map, HashMap sqlMap ) ;
	public HashMap modify( HashMap map, HashMap sqlMap ) ;
	public HashMap delete( HashMap map, HashMap sqlMap );
	//Added By Anbarasi on 15/10/2024 for overcome this Exception APP-OR0397 Exception Occurred - Unable to complete the operation, Please Retry
	public String savePrevilegeGrpsForUser(ArrayList<String> previGrpLst, HashMap<String, String> map, Properties properties, String groupBy);

	 
}
