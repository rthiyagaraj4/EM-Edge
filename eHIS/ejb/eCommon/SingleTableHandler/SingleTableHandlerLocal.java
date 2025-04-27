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
import java.util.Hashtable;
import java.util.Properties;
import java.util.*;
import javax.ejb.EJBLocalObject;
//import eCommon.CommonEJBAdapter.*;

public interface SingleTableHandlerLocal
    extends EJBLocalObject
{
//    public HashMap insertMultiple( HashMap tabData, HashMap sqlMap ) throws RemoteException;
    public HashMap singleBatchHandler( HashMap tabData, HashMap sqlMap );
	
	public HashMap insert( HashMap map, HashMap sqlMap ) ;
	public HashMap modify( HashMap map, HashMap sqlMap ) ;
	public HashMap delete( HashMap map, HashMap sqlMap ) ;
}
