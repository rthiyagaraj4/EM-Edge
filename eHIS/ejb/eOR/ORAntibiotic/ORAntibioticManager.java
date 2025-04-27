/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR.ORAntibiotic;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;

import javax.ejb.* ;
import javax.transaction.* ;

import eOR.Common.* ;
import eCommon.Common.*;
import java.io.*;

//import oracle.sql.CLOB;

/**
*
* @ejb.bean
*	name="ORAntibiotic"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ORAntibiotic"
*	local-jndi-name="ORAntibiotic"
*	impl-class-name="eOR.ORAntibiotic.ORAntibioticManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOR.ORAntibiotic.ORAntibioticLocal"
*	remote-class="eOR.ORAntibiotic.ORAntibioticRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.ORAntibiotic.ORAntibioticLocalHome"
*	remote-class="eOR.ORAntibiotic.ORAntibioticHome"
*	generate= "local,remote"
*
*
*/


public class ORAntibioticManager extends OrEJBSessionAdapter
{
	Connection connection = null;
	//PreparedStatement preparedStatement = null;
	//ResultSet resultSet = null;
	//SessionContext sessionContext = null;
	
	PreparedStatement pstmt_insert=null;
	PreparedStatement pstmt_update = null;
	PreparedStatement pstmt_duplicate = null;
	
	//ResultSet res_insert=null;
	//ResultSet res_update = null;
	ResultSet res_duplicate = null;
	
	String added_by_id = "";
	String added_at_ws_no = "";
	String added_facility_id = "";
	String modified_by_id = "";
	String modified_at_ws_no = "";
	String modified_facility_id = "";
	String chart_result_type = "";

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap insert(HashMap tabData, HashMap sqlMap) 
	{
		Properties ppts = null;
		HashMap retMap = new HashMap();
		StringBuffer messages = new StringBuffer() ;
		try
		{
		HashMap recStore = (HashMap )tabData.get("recstorehandler");
		Vector codeVector = new Vector();
		chart_result_type = (String )tabData.get("chart_result_type");
		added_by_id = (String )tabData.get("added_by_id");
		added_at_ws_no = (String )tabData.get("added_at_ws_no");
		added_facility_id = (String )tabData.get("added_facility_id");
		modified_by_id = (String )tabData.get("modified_by_id");
		modified_at_ws_no = (String )tabData.get("modified_at_ws_no");
		modified_facility_id = (String )tabData.get("modified_facility_id");
		ppts = (Properties )tabData.get("properties");
			
		String SQL_OR_CHART_VERTICAL_INSERT = (String )sqlMap.get("SQL_OR_CHART_VERTICAL_INSERT");
		String SQL_OR_CHART_VERTICAL_DUPLICATE_CHK = (String )sqlMap.get("SQL_OR_CHART_VERTICAL_DUPLICATE_CHK");

		connection = getConnection(ppts);
		connection.setAutoCommit( false );
		HashMap map=null;
		
		for(int i=0;i<recStore.size();i++)
		{
			map = (HashMap) recStore.get(String.valueOf(i));
			if(map != null)
				codeVector.add(((String ) map.get("chart_vertical_code")).trim());
		}
		pstmt_insert=connection.prepareStatement(SQL_OR_CHART_VERTICAL_INSERT);
		
		
		String dupStr = "";
		int[] resCnt = null;
		for(int j=0;j<codeVector.size();j++)
		{
			
			if(codeVector.size() == 1)
			{
				dupStr = dupStr + "'" + ((String )codeVector.get(j)).trim() + "'";
			}
			else
			{
				if(j == codeVector.size()-1)
					dupStr = dupStr + "'" + ((String ) codeVector.get(j)).trim() + "'";
				else
					dupStr = dupStr + "'" + ((String ) codeVector.get(j)).trim() + "'" + ",";
			}
		}
			

		//duplicate check starts
		//pstmt_duplicate.setString(1,dupStr.trim());
		int t = SQL_OR_CHART_VERTICAL_DUPLICATE_CHK.lastIndexOf("?");
		SQL_OR_CHART_VERTICAL_DUPLICATE_CHK  = SQL_OR_CHART_VERTICAL_DUPLICATE_CHK.substring(0,t) + dupStr.trim() + SQL_OR_CHART_VERTICAL_DUPLICATE_CHK.substring(t+1)  ;
		
		pstmt_duplicate = connection.prepareStatement(SQL_OR_CHART_VERTICAL_DUPLICATE_CHK);
		pstmt_duplicate.setString(1,chart_result_type);
		res_duplicate = pstmt_duplicate.executeQuery();	
		
		int counter = 0;
		while(res_duplicate.next())
		{
			counter++;
		}
		if(counter > 0)
		{
			messages.append("DUPLICATE_CODE_EXISTS");
		}
		//duplicate check ends here...
		else
		{
			//System.err.println("duplicate code does not exists");
			HashMap tabDataTemp=null;
			
			for(int k=0;k<recStore.size();k++)
			{
				tabDataTemp = (HashMap )recStore.get(String.valueOf(k));
				pstmt_insert.setString(1,chart_result_type);
				pstmt_insert.setString(2,(String )tabDataTemp.get("chart_vertical_code"));
				pstmt_insert.setString(3,(String )tabDataTemp.get("long_desc"));
				pstmt_insert.setString(4,(String )tabDataTemp.get("short_desc"));
				pstmt_insert.setString(5,(String )tabDataTemp.get("seq_no"));
				pstmt_insert.setString(6,(String )tabDataTemp.get("discr_msr_id"));
				pstmt_insert.setString(7,(String )tabDataTemp.get("copy_prev"));
				pstmt_insert.setString(8,(String )tabDataTemp.get("eff_status"));
				pstmt_insert.setString(9,added_by_id);
				pstmt_insert.setString(10,added_at_ws_no);
				pstmt_insert.setString(11,added_facility_id);
				pstmt_insert.setString(12,modified_by_id);
				pstmt_insert.setString(13,modified_at_ws_no);
				pstmt_insert.setString(14,modified_facility_id);
				pstmt_insert.addBatch();
			}
			 resCnt = pstmt_insert.executeBatch();
			 if(resCnt != null)
			{
				connection.commit();
				retMap.put( "result", new Boolean( true ) ) ;
				retMap.put( "flag" , "" );
				messages.append( "RECORD_INSERTED" ) ;
			}
		}
		
		
	}catch(Exception e)
	{
		
		try{
			connection.rollback();
			retMap.put( "result", new Boolean( false ) ) ;
			retMap.put( "flag" , "" );
			messages.append( "Insert Failed" ) ;
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	finally
	{

		try{
		//closeResultSet(res_insert);
	//	closeResultSet(res_update);
		closeResultSet(res_duplicate);
		
		closeStatement(pstmt_insert);
		//closeStatement(pstmt_update);
		closeStatement(pstmt_duplicate);
	
		if(connection != null) {
			closeConnection( connection,ppts);
		}
		}catch(Exception ey)
		{
			ey.printStackTrace();
		}
	}
	
	retMap.put( "message", messages.toString() ) ;
	retMap.put( "traceVal","");
	retMap.put( "invalidCode" , "");
	
	
	return retMap;
	
	}// end of insert


	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap modify( HashMap tabData, HashMap sqlMap ) 
	{
		
		Properties ppts = null;
		HashMap retMap = new HashMap();
		StringBuffer messages = new StringBuffer() ;
		try
		{
			
		HashMap recStore = (HashMap )tabData.get("recstorehandler");
		chart_result_type = (String ) tabData.get("chart_result_type");
		added_by_id = (String )tabData.get("added_by_id");
		added_at_ws_no = (String )tabData.get("added_at_ws_no");
		added_facility_id = (String )tabData.get("added_facility_id");
		modified_by_id = (String )tabData.get("modified_by_id");
		modified_at_ws_no = (String )tabData.get("modified_at_ws_no");
		modified_facility_id = (String )tabData.get("modified_facility_id");
		ppts = (Properties )tabData.get("properties");
			
		String SQL_OR_CHART_VERTICAL_UPDATE = (String )sqlMap.get("SQL_OR_CHART_VERTICAL_UPDATE");
		
		connection = getConnection(ppts);
		connection.setAutoCommit( false ) ;
		
		pstmt_update=connection.prepareStatement(SQL_OR_CHART_VERTICAL_UPDATE);
			
				HashMap tabDataTemp = (HashMap )recStore.get(String.valueOf("0"));
				
				pstmt_update.setString(1, chart_result_type);
				pstmt_update.setString(2,(String )tabDataTemp.get("long_desc"));
				pstmt_update.setString(3,(String )tabDataTemp.get("short_desc"));
				pstmt_update.setString(4,(String )tabDataTemp.get("seq_no"));
				pstmt_update.setString(5,(String )tabDataTemp.get("eff_status"));
				pstmt_update.setString(6,modified_by_id);
				pstmt_update.setString(7,modified_at_ws_no);
				pstmt_update.setString(8,modified_facility_id);
				pstmt_update.setString(9,((String )tabDataTemp.get("chart_vertical_code")).trim());
				pstmt_update.setString(10, chart_result_type);
				int res_mod = pstmt_update.executeUpdate();
				
			if(res_mod > 0 )
			{
				
				connection.commit();
				retMap.put( "result", new Boolean( true ) ) ;
				messages.append( "RECORD_MODIFIED" ) ;
			}
			 
	}catch(Exception e)
	{
		
		try{
			connection.rollback();
			retMap.put( "result", new Boolean( false ) ) ;
			messages.append( "Modify Failed" ) ;
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	finally
	{
		
		try{
			
		closeStatement(pstmt_update);
			
		if(connection != null) {
			closeConnection( connection,ppts);
		}
		}catch(Exception ey)
		{
			ey.printStackTrace();
		}
	}

		retMap.put( "message", messages.toString() ) ;
		retMap.put( "traceVal","");
		retMap.put( "invalidCode" , "");
		
		return retMap;
	}// end of modify method...
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap delete( HashMap map, HashMap sqlMap ) 
	{
		return null;
	}
}
