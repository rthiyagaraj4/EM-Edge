/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT.DisplayMapping;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import javax.ejb.EJBObject;

public interface DisplayMappingRemote extends EJBObject {

	public String save(Map tabData, Properties prop) throws RemoteException;
}
