/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH.PHRegimenService ;

import ePH.Common.PhEJBRemote ;

import java.rmi.RemoteException ;
import java.util.*;

public interface PHRegimenServiceRemote extends PhEJBRemote {

	public HashMap insert( HashMap tabData, HashMap sqlMap ) throws RemoteException;
	public HashMap modify( HashMap tabData, HashMap sqlMap ) throws RemoteException;
	public HashMap delete( HashMap tabData, HashMap sqlMap ) throws RemoteException;



}
