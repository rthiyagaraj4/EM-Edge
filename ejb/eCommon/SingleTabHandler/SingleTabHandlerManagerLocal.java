/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCommon.SingleTabHandler;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Properties;
import javax.ejb.EJBObject;

public interface SingleTabHandlerManagerLocal
    extends javax.ejb.EJBLocalObject
{

    public abstract java.util.HashMap insert(java.util.Properties properties, java.util.HashMap hashMap, java.lang.String as[], java.lang.String s);
        //throws java.rmi.RemoteException;

    public abstract java.util.HashMap update(java.util.Properties properties, java.util.HashMap hashMap, java.util.HashMap hashMap1, java.lang.String s);
        //throws java.rmi.RemoteException;

    public abstract java.util.HashMap delete(java.util.Properties properties, java.util.HashMap hashMap, java.lang.String s);
        //throws java.rmi.RemoteException;
}
