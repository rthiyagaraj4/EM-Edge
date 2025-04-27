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
import javax.ejb.CreateException;
import javax.ejb.EJBHome;

// Referenced classes of package common.SingleTabHandler:
//            SingleTabHandlerManagerRemote

public interface SingleTabHandlerManagerLocalHome
    extends javax.ejb.EJBLocalHome
{

    public abstract eCommon.SingleTabHandler.SingleTabHandlerManagerLocal create()
        throws javax.ejb.CreateException;
}
