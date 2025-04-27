/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST.ParentStoreForStore;
//import eCommon.Common.CommonEJBSessionAdapter;
import eST.Common.StEJBSessionAdapter;
//import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.*;
import java.util.*;

/**
*
* @ejb.bean
*	name="ParentStoreForStore"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ParentStoreForStore"
*	local-jndi-name="ParentStoreForStore"
*	impl-class-name="eST.ParentStoreForStore.ParentStoreForStoreManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eST.ParentStoreForStore.ParentStoreForStoreLocal"
*	remote-class="eST.ParentStoreForStore.ParentStoreForStoreRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eST.ParentStoreForStore.ParentStoreForStoreLocalHome"
*	remote-class="eST.ParentStoreForStore.ParentStoreForStoreHome"
*	generate= "local,remote"
*
*
*/

public class ParentStoreForStoreManager extends StEJBSessionAdapter
{
    public ParentStoreForStoreManager()
    {
    }
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public HashMap delete(HashMap hashmap, HashMap hashmap1)
    {
        return getMessageHashMap(false);
    }
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public HashMap modify(HashMap hashmap, HashMap hashmapQuery)
    {
        HashMap hashmapResult = new HashMap();
        return hashmapResult;
    }

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

    public HashMap insert(HashMap hashmap, HashMap hmSQL)
    {
        Connection connection = null;
        HashMap hmDeldata = new HashMap();
        HashMap hmDelQuery = new HashMap();
        HashMap hashmapResult = new HashMap();
        HashMap hashmapDtldata = new HashMap();
        HashMap hashmapDtlquery = new HashMap();
       // ArrayList arraylist = new ArrayList();
       // ArrayList arraylist2 = new ArrayList();
        Properties properties = null;
       // Object obj = null;
        hashmapResult.put("result", FALSE);
        try
        {
            properties = (Properties)hashmap.get("properties");
            connection = getConnection(properties);
            connection.setAutoCommit(false);
			if(hmSQL.containsKey("deleteSQL")){
				ArrayList alDelData = (ArrayList)hashmap.get("DelData");
				String DelQuery = (String)hmSQL.get("deleteSQL");
				hmDeldata.put("DATA",alDelData);
				hmDelQuery.put(DELETE_SQL,DelQuery);
				hashmapResult =  delete(connection, hmDeldata, hmDelQuery);
				throwExceptionWhenFailed(hashmapResult);
			}

			ArrayList arraylistDtlData = (ArrayList)hashmap.get("DtlInsertData");
            String DtlQuery = (String)hmSQL.get("dtlInsertSQL");
			hashmapDtldata.put("DATA",arraylistDtlData);
			hashmapDtlquery.put(BATCH_SQL,DtlQuery);
			hashmapResult =  operateBatch(connection, hashmapDtldata, hashmapDtlquery);
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
