/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
 * OROrderablePerformingLocationHome.java
 *
 * Created on September 4, 2003, 10:48 AM
 */

package eOR.OROrderablePeformLocn;

import javax.ejb.*;
import eOR.Common.*;

/**
 *
 * @author  sivakumar
 */
public interface OROrderablePeformLocnHome extends OrEJBHome {

    public OROrderablePeformLocnRemote create () throws java.rmi.RemoteException,CreateException;
}
