/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST.ManufacturingRequest;

//import eCommon.Common.CommonEJBSessionAdapter;
import eST.Common.StEJBSessionAdapter;
//import java.rmi.RemoteException;
import java.sql.Connection;
import java.util.*;

/**
*
* @ejb.bean
*	name="ManufacturingRequest"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ManufacturingRequest"
*	local-jndi-name="ManufacturingRequest"
*	impl-class-name="eST.ManufacturingRequest.ManufacturingRequestManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eST.ManufacturingRequest.ManufacturingRequestLocal"
*	remote-class="eST.ManufacturingRequest.ManufacturingRequestRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eST.ManufacturingRequest.ManufacturingRequestLocalHome"
*	remote-class="eST.ManufacturingRequest.ManufacturingRequestHome"
*	generate= "local,remote"
*
*
*/


public class ManufacturingRequestManager extends StEJBSessionAdapter
{

    public ManufacturingRequestManager()
    {
    }

    /**
	* @ejb.interface-method
	*	 view-type="both"
	*/

    public HashMap modify(HashMap hashmap, HashMap hashmap1)
//        throws RemoteException
    {
        return getMessageHashMap(false);
    }

  /**
	* @ejb.interface-method
	*	 view-type="both"
	*/

    public HashMap delete(HashMap hashmap, HashMap hashmapQuery)
//        throws RemoteException
    {
		return getMessageHashMap(false);
	}

  /**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	 public HashMap insert(HashMap hashmap, HashMap hashmapQuery) //throws RemoteException
    {
		HashMap hashmapResult = new HashMap();
		 Connection connection = null;
		 Properties properties = null;
//		 Object obj = null;
			hashmapResult.put("result", FALSE);
			try
			{
				properties = (Properties)hashmap.get("properties");
				connection = getConnection(properties);
				connection.setAutoCommit(false);
				eST.Common.ManufacturingRequest	manufacturingRequest	=	new eST.Common.ManufacturingRequest();
				hashmapResult=manufacturingRequest.insertManufacturingRequest(connection, hashmap);
				throwExceptionWhenFailed(hashmapResult);
				connection.commit();
			}
			catch(Exception exception)
			{
				try
				{
					connection.rollback();
					exception.printStackTrace();
				}
				catch(Exception exception1)
				{
					exception1.printStackTrace();
				}
				hashmapResult.put("result", FALSE);
				hashmapResult.put("msgid", exception.getMessage());
				hashmapResult.put("message", exception.toString());
			}
			finally
			{
				try
				{
					closeConnection(connection, properties);
				}
				catch(Exception exception3)
				{
					exception3.printStackTrace();
				}
			}
			return hashmapResult;
		}
}
