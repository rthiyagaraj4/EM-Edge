/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST.AssemblyDetail;
//import eCommon.Common.CommonEJBSessionAdapter;
import eST.Common.StEJBSessionAdapter;
//import java.rmi.RemoteException;
import java.sql.Connection;
import java.util.*;

/**
*
* @ejb.bean
*	name="AssemblyDetail"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="AssemblyDetail"
*	local-jndi-name="AssemblyDetail"
*	impl-class-name="eST.AssemblyDetail.AssemblyDetailManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eST.AssemblyDetail.AssemblyDetailLocal"
*	remote-class="eST.AssemblyDetail.AssemblyDetailRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eST.AssemblyDetail.AssemblyDetailLocalHome"
*	remote-class="eST.AssemblyDetail.AssemblyDetailHome"
*	generate= "local,remote"
*
*
*/

public class AssemblyDetailManager extends StEJBSessionAdapter
{
    public AssemblyDetailManager()
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

        Connection connection = null;
        HashMap hashmapHDrUpdData = new HashMap();
        HashMap hashmapHDrUpdDataQ = new HashMap();
        HashMap hashmapDtlUpdData = new HashMap();
        HashMap hashmapDtlUpdDataQ = new HashMap();
      //  HashMap hashmapDtlInsertData = new HashMap();
        HashMap hashmapResult = new HashMap();
        HashMap hashmapDtlDeletedata = new HashMap();
        HashMap hashmapDtlDeletedataQ = new HashMap();
       
		ArrayList arrHDrUpdData = new ArrayList();
        ArrayList arrDtlUpdData = new ArrayList();
        ArrayList arrDtlInsertData = new ArrayList();
        ArrayList arrDtlDeletedata = new ArrayList();

		String hdrUpdateSQL=(String)hashmapQuery.get("hdrUpdateSQL");
        String dtlUpdateSQL=(String)hashmapQuery.get("dtlUpdateSQL");
        String dtlInsertSQL=(String)hashmapQuery.get("dtlInsertSQL");
        String dtlDeleteSQL=(String)hashmapQuery.get("dtlDeleteSQL");

		
        Properties properties = null;
      //  Object obj = null;
        hashmapResult.put("result", FALSE);
        try
        {
            properties = (Properties)hashmap.get("properties");
            connection = getConnection(properties);
            connection.setAutoCommit(false);
		
			arrHDrUpdData = (ArrayList)hashmap.get("HdrUpdateData");
			

      		hashmapHDrUpdData.put("DATA",arrHDrUpdData);
			hashmapHDrUpdDataQ.put(BATCH_SQL,hdrUpdateSQL);
			hashmapResult =  operateBatch(connection, hashmapHDrUpdData, hashmapHDrUpdDataQ);
			throwExceptionWhenFailed(hashmapResult);

			arrDtlUpdData = (ArrayList)hashmap.get("DtlUpdateData");
      		hashmapDtlUpdData.put("DATA",arrDtlUpdData);
			hashmapDtlUpdDataQ.put(BATCH_SQL,dtlUpdateSQL);
			hashmapResult =  operateBatch(connection, hashmapDtlUpdData, hashmapDtlUpdDataQ);

			throwExceptionWhenFailed(hashmapResult);

			arrDtlInsertData = (ArrayList)hashmap.get("DtlInsertData");
			if(arrDtlInsertData.size()>0){
				hashmapHDrUpdData.put("DATA",arrDtlInsertData);
				hashmapHDrUpdDataQ.put(BATCH_SQL,dtlInsertSQL);
				hashmapResult =  operateBatch(connection, hashmapHDrUpdData, hashmapHDrUpdDataQ);
				throwExceptionWhenFailed(hashmapResult);
			}

			arrDtlDeletedata = (ArrayList)hashmap.get("DtlDeleteData");
			if(arrDtlDeletedata.size()>0){
				hashmapDtlDeletedata.put("DATA",arrDtlDeletedata);
				hashmapDtlDeletedataQ.put(BATCH_SQL,dtlDeleteSQL);
				hashmapResult =  operateBatch(connection, hashmapDtlDeletedata, hashmapDtlDeletedataQ);
				

				throwExceptionWhenFailed(hashmapResult);
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

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

    public HashMap insert(HashMap hashmap, HashMap hashmap1)
    {
        Connection connection = null;
        HashMap hashmapHDrdata = new HashMap();
        HashMap hashmapHDrquery = new HashMap();
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
			
            ArrayList arraylistHdrData = (ArrayList)hashmap.get("HdrInsertData");
            String HdrQuery = (String)hashmap1.get("hdrInsertSQL");
			hashmapHDrdata.put("DATA",arraylistHdrData);
			hashmapHDrquery.put(BATCH_SQL,HdrQuery);
			hashmapResult =  operateBatch(connection, hashmapHDrdata, hashmapHDrquery);
			throwExceptionWhenFailed(hashmapResult);

			ArrayList arraylistDtlData = (ArrayList)hashmap.get("DtlInsertData");
            String DtlQuery = (String)hashmap1.get("dtlInsertSQL");
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
