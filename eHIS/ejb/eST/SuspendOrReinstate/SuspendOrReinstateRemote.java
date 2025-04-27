/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST.SuspendOrReinstate;

import java.rmi.RemoteException;
import java.util.HashMap;
import javax.ejb.EJBObject;

public abstract interface SuspendOrReinstateRemote extends EJBObject
{
  public abstract HashMap modify(HashMap paramHashMap1, HashMap paramHashMap2)
    throws RemoteException;

  public abstract HashMap delete(HashMap paramHashMap1, HashMap paramHashMap2)
    throws RemoteException;

  public abstract HashMap insert(HashMap paramHashMap1, HashMap paramHashMap2)
    throws RemoteException;
}
