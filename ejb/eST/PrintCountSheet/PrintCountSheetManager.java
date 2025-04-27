/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST.PrintCountSheet;

//import eCommon.Common.CommonEJBSessionAdapter;
import eST.Common.StEJBSessionAdapter;
//import java.rmi.RemoteException;
import java.sql.Connection;
import java.util.*;

/**
*
* @ejb.bean
*	name="PrintCountSheet"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="PrintCountSheet"
*	local-jndi-name="PrintCountSheet"
*	impl-class-name="eST.PrintCountSheet.PrintCountSheetManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eST.PrintCountSheet.PrintCountSheetLocal"
*	remote-class="eST.PrintCountSheet.PrintCountSheetRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eST.PrintCountSheet.PrintCountSheetLocalHome"
*	remote-class="eST.PrintCountSheet.PrintCountSheetHome"
*	generate= "local,remote"
*
*
*/

public class PrintCountSheetManager extends StEJBSessionAdapter
{

    public PrintCountSheetManager()
    {
    }

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

    public HashMap delete(HashMap hashmap, HashMap hashmap1)
//        throws RemoteException
    {
        return getMessageHashMap(false);
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
    //    ArrayList arraylist = new ArrayList();
     //  ArrayList arraylist3 = new ArrayList();
        Properties properties = null;
     //   Object obj = null;
        hashmap2.put("result", FALSE);
        try
        {
            properties = (Properties)hashmap.get("properties");
            connection = getConnection(properties);
            connection.setAutoCommit(false);
			if(hashmap1.containsKey("InsertParamSQL"))
            {
			ArrayList arraylist1 = (ArrayList)hashmap.get("InsertData");
            String s = (String)hashmap1.get("InsertParamSQL");
            hashmap3.put("DATA", arraylist1);
            hashmap4.put("INSERT_SQL", s);
            hashmap2 = insert(connection, hashmap3, hashmap4);
            throwExceptionWhenFailed(hashmap2);
			}
			if(hashmap1.containsKey("InsertHdrSQL"))
			{
            ArrayList arraylist1 = (ArrayList)hashmap.get("param_hdr");
            String s = (String)hashmap1.get("InsertHdrSQL");
            hashmap3.put("DATA", arraylist1);
            hashmap4.put("BATCH_SQL", s);
            hashmap2 = operateBatch(connection, hashmap3, hashmap4);
            throwExceptionWhenFailed(hashmap2);
			}
			if(hashmap1.containsKey("Updatestbatch"))
			{
            ArrayList arraylist1 = (ArrayList)hashmap.get("UpdateData");
            String s = (String)hashmap1.get("Updatestbatch");
            hashmap3.put("DATA", arraylist1);
            hashmap4.put("UPDATE_SQL", s);
            hashmap2 = update(connection, hashmap3, hashmap4);
//            throwExceptionWhenFailed(hashmap2);
			}
			if(hashmap1.containsKey("Updatestitem"))
			{
            ArrayList arraylist1 = (ArrayList)hashmap.get("UpdateData");
            String s = (String)hashmap1.get("Updatestitem");
            hashmap3.put("DATA", arraylist1);
            hashmap4.put("UPDATE_SQL", s);
            hashmap2 = update(connection, hashmap3, hashmap4);
 //           throwExceptionWhenFailed(hashmap2);
			}
			if(hashmap1.containsKey("UpdateParam"))
			{
            ArrayList arraylist1 = (ArrayList)hashmap.get("UpdateParamData");
            String s = (String)hashmap1.get("UpdateParam");
            hashmap3.put("DATA", arraylist1);
            hashmap4.put("UPDATE_SQL", s);
            hashmap2 = update(connection, hashmap3, hashmap4);
            throwExceptionWhenFailed(hashmap2);
			}


/*
	        hashmap3.put("DATA", arraylist1);
            hashmap4.put("UPDATE_SQL", s);
            hashmap2 = update(connection, hashmap3, hashmap4);
            throwExceptionWhenFailed(hashmap2);

            hashmap3.put("DATA", arraylist1);
            hashmap4.put("DELETE_SQL", s);
            hashmap2 = update(connection, hashmap3, hashmap4);
            throwExceptionWhenFailed(hashmap2);

*/
			
			///s = (String)hashmap1.get("InsertHdrSQL");
            //arraylist3 = (ArrayList)hashmap.get("InsertData");
            //hashmap3.put("DATA", arraylist3);
            //hashmap4.put("INSERT_SQL", s);
            //hashmap2 = insert(connection, hashmap3, hashmap4);
            //throwExceptionWhenFailed(hashmap2);
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
