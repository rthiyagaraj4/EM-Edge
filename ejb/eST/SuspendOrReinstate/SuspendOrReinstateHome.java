/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------
06/04/2017				IN063878				Badmavathi B					        					 Unused variables
-------------------------------------------------------------------------------------------------------------------------------
*/
package eST.SuspendOrReinstate;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public abstract interface SuspendOrReinstateHome extends EJBHome
{
  /* Commented for Unused variables IN063878
  public static final String COMP_NAME = "java:comp/env/ejb/SuspendOrReinstateRemote";
  public static final String JNDI_NAME = "SuspendOrReinstateRemote";
*/
  public abstract SuspendOrReinstateRemote create()
    throws CreateException, RemoteException;
}
