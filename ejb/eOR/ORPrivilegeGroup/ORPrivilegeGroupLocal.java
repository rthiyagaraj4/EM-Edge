/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR.ORPrivilegeGroup ;

import java.sql.Connection;
import java.util.HashMap;

import javax.ejb.EJBLocalObject;

public interface ORPrivilegeGroupLocal extends EJBLocalObject{
	public HashMap insert(HashMap tabDataParam , HashMap sqlMap )  ;
	public HashMap modify( HashMap tabDataParam, HashMap sqlMap )   ;
	public boolean delete( String arr[],Connection con ,String sql) throws Exception;
}
