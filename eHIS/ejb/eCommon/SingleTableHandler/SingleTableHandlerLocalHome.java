/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCommon.SingleTableHandler;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
//import eCommon.CommonEJBAdapter.*;
// Referenced classes of package eCommon.CommonEntityHandler:
//            CommonEntityHandlerManagerRemote

public interface SingleTableHandlerLocalHome extends EJBLocalHome
{

    public SingleTableHandlerLocal create() throws CreateException ;

}
