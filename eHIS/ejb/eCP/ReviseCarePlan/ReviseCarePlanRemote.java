/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This File is saved on 18/10/2005.
package eCP.ReviseCarePlan;

import java.rmi.RemoteException;
import javax.ejb.EJBObject;
import java.util.HashMap;
import java.util.Properties;

public interface ReviseCarePlanRemote extends EJBObject
{

	public abstract HashMap AddModify(Properties properties, HashMap hashmap)throws RemoteException;

}
	
