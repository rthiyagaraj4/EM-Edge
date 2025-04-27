/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
 * OROrderablePerformingLocationRemote.java
 *
 * Created on September 4, 2003, 10:49 AM
 */

package eOR.OROrderablePeformLocn;

import java.rmi.*;
import javax.ejb.*;
import java.util.*;
import eOR.Common.*;

/**
 *
 * @author  sivakumar
 */
public interface OROrderablePeformLocnRemote extends OrEJBRemote {

    public HashMap insert( HashMap map, HashMap sqlMap ) throws RemoteException ;
	public HashMap modify( HashMap map, HashMap sqlMap ) throws RemoteException ;
	public HashMap delete( HashMap map, HashMap sqlMap ) throws RemoteException ;
}
