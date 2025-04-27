/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH.IVPrescription ;
import ePH.Common.PhEJBRemote ;
import java.rmi.RemoteException ;
import java.util.*;

public interface IVPrescriptionRemote extends PhEJBRemote {
//	public HashMap insertAmend( HashMap tabData, HashMap sqlMap ) throws RemoteException;
//	public HashMap amendmodify( HashMap tabData, HashMap sqlMap ) throws RemoteException;
	public HashMap insert( HashMap tabData, HashMap sqlMap )throws RemoteException;
	public HashMap modify( HashMap tabData, HashMap sqlMap )throws RemoteException;
	public HashMap ivFluidsInsert( HashMap tabData, HashMap sqlMap )throws RemoteException;
	public HashMap ivFluidsModify( HashMap tabData, HashMap sqlMap )throws RemoteException;
	public HashMap delete( HashMap tabData, HashMap sqlMap )throws RemoteException;

}
