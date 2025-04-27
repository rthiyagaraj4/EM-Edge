/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST.PhysicalInventoryEntry;

//import eCommon.Common.CommonEJBSessionAdapter;
import eST.Common.StEJBSessionAdapter;
//import java.rmi.RemoteException;
import java.sql.Connection;
import java.util.*;

/**
*
* @ejb.bean
*	name="PhysicalInventoryEntry"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="PhysicalInventoryEntry"
*	local-jndi-name="PhysicalInventoryEntry"
*	impl-class-name="eST.PhysicalInventoryEntry.PhysicalInventoryEntryManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eST.PhysicalInventoryEntry.PhysicalInventoryEntryLocal"
*	remote-class="eST.PhysicalInventoryEntry.PhysicalInventoryEntryRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eST.PhysicalInventoryEntry.PhysicalInventoryEntryLocalHome"
*	remote-class="eST.PhysicalInventoryEntry.PhysicalInventoryEntryHome"
*	generate= "local,remote"
*
*
*/


public class PhysicalInventoryEntryManager extends StEJBSessionAdapter
{

    public PhysicalInventoryEntryManager()
    {
    }

 /**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public HashMap delete(HashMap hashmap, HashMap hashmap1)
//        throws RemoteException
    {
         Connection connection = null;
        HashMap hashmap2 = new HashMap();
        HashMap hashmap3 = new HashMap();
        HashMap hashmap4 = new HashMap();
        ArrayList arraylist1 = new ArrayList();
    //    ArrayList arraylist3 = new ArrayList();
        Properties properties = null;
  //      Object obj = null;
        hashmap2.put("result", FALSE);
        try
        {
            properties = (Properties)hashmap.get("properties");
            connection = getConnection(properties);
            connection.setAutoCommit(false);
			{

				arraylist1 = (ArrayList)hashmap.get("DeleteData");
				String s = (String)hashmap1.get("DeleteDtlSQL");
				hashmap3.put("DATA", arraylist1);
				hashmap4.put("BATCH_SQL", s);
				hashmap2 = operateBatch(connection, hashmap3, hashmap4);

				throwExceptionWhenFailed(hashmap2);
			}
            {
				arraylist1 = (ArrayList)hashmap.get("InsertData");
				String s = (String)hashmap1.get("InsertDtlSQL");
				hashmap3.put("DATA", arraylist1);
				hashmap4.put("BATCH_SQL", s);
				hashmap2 = operateBatch(connection, hashmap3, hashmap4);
				throwExceptionWhenFailed(hashmap2);
			}
            {
				arraylist1 = (ArrayList)hashmap.get("ModifyData");
				String s = (String)hashmap1.get("ModifyDtlSQL");
				hashmap3.put("DATA", arraylist1);
				hashmap4.put("UPDATE_SQL", s);
				hashmap2 = update(connection, hashmap3, hashmap4);
	            throwExceptionWhenFailed(hashmap2);
			}
			// Added by Padmapriya for INC # 29976 on 31/08/2012
			{
				arraylist1 = (ArrayList)hashmap.get("ModifyHDRData"); 
				String s = (String)hashmap1.get("ModifyHDRSQL");
				if(arraylist1.size() > 0){
					hashmap3.put("DATA", arraylist1);
					hashmap4.put("BATCH_SQL", s);
					hashmap2 = operateBatch(connection, hashmap3, hashmap4);
					throwExceptionWhenFailed(hashmap2); 
				}	
			}
			// End by Padmapriya for INC # 29976 on 31/08/2012
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
            hashmap2.put("result", FALSE);
            hashmap2.put("msgid", exception.getMessage());
            hashmap2.put("message", exception.toString());
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
        return hashmap2;
    }

 /**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public HashMap insert(HashMap hashmap, HashMap hashmap1)
//        throws RemoteException
    {
        Connection connection = null;
        HashMap hashmap2 = new HashMap();
        HashMap hashmap3 = new HashMap();
        HashMap hashmap4 = new HashMap();
   //     ArrayList arraylist = new ArrayList();
     //   ArrayList arraylist3 = new ArrayList();
        Properties properties = null;
    //    Object obj = null;
        hashmap2.put("result", FALSE);
        try
        {
            properties = (Properties)hashmap.get("properties");
            connection = getConnection(properties);
            connection.setAutoCommit(false);
			{
            ArrayList arraylist1 = (ArrayList)hashmap.get("InsertData");
            String s = (String)hashmap1.get("InsertDtlSQL");
            hashmap3.put("DATA", arraylist1);
            hashmap4.put("BATCH_SQL", s);
            hashmap2 = operateBatch(connection, hashmap3, hashmap4);
            throwExceptionWhenFailed(hashmap2);
			}
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
            hashmap2.put("result", FALSE);
            hashmap2.put("msgid", exception.getMessage());
            hashmap2.put("message", exception.toString());
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
        return hashmap2;
    }
	
	 /**
	* @ejb.interface-method
	*	 view-type="both"
	*/

    public HashMap modify(HashMap hashmap, HashMap hashmap1)
    {
        return getMessageHashMap(false);
    }
}
