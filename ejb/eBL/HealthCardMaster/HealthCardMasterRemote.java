/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL.HealthCardMaster;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.ejb.EJBObject;


public interface HealthCardMasterRemote extends EJBObject {
	public HashMap insertRecords(java.util.Properties p,
			HashMap inputParameters,
			HashMap listParam) throws RemoteException;
	public HashMap updateRecords(java.util.Properties p,
			HashMap inputParameters,
			HashMap listParam) throws RemoteException;

}


