/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST.PhyInvForSpecificItem;

import java.rmi.RemoteException;
import eST.Common.StEJBRemote;
import java.util.*;

public interface PhyInvForSpecificItemRemote
    extends StEJBRemote
{
	public abstract HashMap insertYes(HashMap hashmap, HashMap hashmap1)
        throws RemoteException;
	public abstract HashMap modifyYes(HashMap hashmap, HashMap hashmap1)
        throws RemoteException;
}
