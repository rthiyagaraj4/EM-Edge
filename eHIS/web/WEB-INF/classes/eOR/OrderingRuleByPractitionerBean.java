/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
*	Copyright © IBA Health India (P) Ltd. ALL RIGHTS RESERVED
*	Filename		:	DeptOnlyCatalogApplBean.java
*	Purpose 		:	This is used to set the vales to persistant methods
*						also to set the values to the hashtable which will further
*						passed as input to the EJB for insert/update/delete operations
*	Created By		:	HarichanDraReddy
*	Created On		:	05 Aug 2007
*/
/*

-----------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
-----------------------------------------------------------------------------------------------------------------------

15/08/2020		IN071361		Nijitha S			15/08/2020		Ramesh G		AAKH-CRF-0116
29/01/2021		13628			Nijitha S			29/01/2021		Nijitha S		ML-MMOH-SCF-1720
-----------------------------------------------------------------------------------------------------------------------
*/
package eOR;

import java.io.* ;
import java.util.* ;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;

import eOR.Common.* ;
import eCommon.Common.*;

//import eOR.ORDeptOnlyCatalogAppl.*;

public class OrderingRuleByPractitionerBean extends OrAdapter implements java.io.Serializable 
{
	StringBuffer traceVals = new StringBuffer();
	protected Hashtable hashMultiple;
	

	/*
		This method returns all the practitioner types
	*/
	public ArrayList getPractTypes() throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList practTypes		= new ArrayList();
		String[] practRecords		= null;
		
		try
		{
			connection = getConnection();
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDERING_RULE_BY_PRACTTYPE_GET_PRACT_TYPE")) ;
			resultSet = pstmt.executeQuery();

			while(resultSet !=null && resultSet.next())
			{
				practRecords	= new String[2];
				practRecords[0] = resultSet.getString("CODE");
				practRecords[1] = resultSet.getString("LONG_DESC");
				practTypes.add(practRecords);
			}
		}
		catch(Exception e)
		{
			System.err.println("Error loading values from database");
			e.printStackTrace();
			throw e;
		}
		finally
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		return practTypes;
	}

	/*
		This method returns all the Order Categories
	*/
	public ArrayList getOrderCategory (String pract_type) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;
		try 
		{
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_CATALOG_ORDER_CATEGORY") ) ;
			pstmt.setString(1,pract_type);
			resultSet = pstmt.executeQuery() ;
			String[] record=null;
			while ( resultSet != null && resultSet.next() ) 
			{
				//System.out.println("categoryyyyyyyyy==============");
				//record = new String[5];//IN071361
				record = new String[7];//IN071361
				record[0] = resultSet.getString( "ORDER_CATEGORY" )  ;
				record[1] = resultSet.getString( "SHORT_DESC" )  ;
				record[2] = resultSet.getString( "PLACE_DEPT_ONLY_YN" )  ;
				record[3] = resultSet.getString( "FORCE_AUTH_YN" )  ;
				record[4] = resultSet.getString( "FORCE_COSIGN_YN" )  ;
				record[5] = resultSet.getString( "PLACE_ORDER_EXPIRY_PERIOD" )  ;//IN071361
				record[6] = resultSet.getString( "PLACE_ORDER_EXPIRY_RULE" )  ;//IN071361

				OrderCat.add(record) ;
			}
		} 
		catch ( Exception e )	
		{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
		}
		return OrderCat;
	}
	
	/*
		This method is called on Clicking of Apply button and sets all the values
		hashMultiple
	*/
	public void setAll( Hashtable recordSetMultiple ) 
	{
		try
		{
			hashMultiple = recordSetMultiple ;
			setMode((String)recordSetMultiple.get("mode"));

			//System.out.println("hashMultiple============ in setall method"+hashMultiple );
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
		This method is called on Clicking of Apply button and validates before calling the appropriate
		method
	*/
	public HashMap validate() throws Exception 
	{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map ;
	}
	
	/*
		This method is called on Clicking of Apply button and it inserts/deletes the records
		in the database
	*/
	public HashMap insert()
	{
		
		HashMap map		 = new HashMap() ;
		map.put( "result", new Boolean(false));
		map.put( "flag", "true");
		
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		PreparedStatement pstmt_del = null ;
		StringBuffer traceVal = new StringBuffer() ;
		StringBuffer messages = new StringBuffer() ;
		ArrayList insertCatList = new ArrayList() ;
		try
		{
			String dept_only = "";
			String pract_type = "";
			String ord_category_code="";
			String force_auth_yn="";
			String force_cosign_yn="";
			String time_based_rule="";//IN071361
			String expiry_rule = "";//IN071361
			int tot_rec = 0;
			pract_type = (String) hashMultiple.get("pract_type");
			tot_rec = Integer.parseInt((String)hashMultiple.get("tot_count"));
		
			String SQL_OR_ORD_RULE_BY_PRACT_INSERT = (String)OrRepositoryExt.getOrKeyValue("SQL_OR_ORD_RULE_BY_PRACT_INSERT");
			String SQL_OR_ORD_RULE_BY_PRACT_DELETE = (String)OrRepositoryExt.getOrKeyValue("SQL_OR_ORD_RULE_BY_PRACT_DELETE");
			
			boolean	insert_flag = true;
			int [] insertCounts ;
			
			connection = getConnection() ;
			pstmt_del = connection.prepareStatement(SQL_OR_ORD_RULE_BY_PRACT_DELETE);
			pstmt_del.setString(1,pract_type);
			pstmt_del.executeUpdate();
			// Inserting the records
				
				pstmt = connection.prepareStatement(SQL_OR_ORD_RULE_BY_PRACT_INSERT);

				for(int i=0 ; i < tot_rec; i++)
				{
					ord_category_code = (String) hashMultiple.get("ord_category_code"+i);
					dept_only = (String) hashMultiple.get("dept_only"+i);
					dept_only = dept_only.equals("")?"N":dept_only;
				    force_auth_yn=(String) hashMultiple.get("force_auth"+i);
				    time_based_rule = (String) hashMultiple.get("time_based_rule"+i);//IN071361
				    expiry_rule = (String) hashMultiple.get("expiry_rule"+i);//IN071361
					force_auth_yn = force_auth_yn.equals("")?"N":force_auth_yn;
					force_cosign_yn=(String) hashMultiple.get("force_cosign"+i);
					force_cosign_yn = force_cosign_yn.equals("")?"N":force_cosign_yn;
					time_based_rule = time_based_rule==null?"":time_based_rule;//IN071361//13628
					expiry_rule = expiry_rule==null?"":expiry_rule;//IN071361//13628
					//System.out.println("inside insert============dept_only"+dept_only);
					//System.out.println("inside insert============force_auth_yn"+force_auth_yn);
					//System.out.println("inside insert============force_cosign_yn"+force_cosign_yn);
					pstmt.setString(1,pract_type);
					pstmt.setString(2 ,ord_category_code);
					pstmt.setString(3 ,dept_only);
					pstmt.setString(4 ,force_auth_yn);
					pstmt.setString(5 ,force_cosign_yn);
					pstmt.setString(6 ,login_by_id);
					pstmt.setString(7 ,login_at_ws_no);
					pstmt.setString(8 ,login_facility_id);
					pstmt.setString(9 ,login_by_id);
					pstmt.setString(10 ,login_at_ws_no);
					pstmt.setString(11 ,login_facility_id);
					pstmt.setString(12 ,expiry_rule);//IN071361
					pstmt.setString(13 ,time_based_rule);//IN071361
					pstmt.addBatch();
				}
				//tabData.clear();
				insertCounts = pstmt.executeBatch();
				if(insertCounts.length < 1)
				{
					insert_flag=false;
				}
			
			if(insert_flag)
			{
				connection.commit();
				map.put( "result", new Boolean( true ) ) ;
				messages.append(getMessage(language_id, "RECORD_INSERTED", "SM")  ) ;
			}
			else
			{
				connection.rollback();
				map.put( "result", new Boolean( false ) ) ;
				throw new Exception("Insert/Update Failed");
			}

		}
		catch (Exception e)
		{
			traceVal.append(e.getMessage());
			map.put( "traceVal", traceVal.toString() ) ;
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				closeStatement( pstmt ) ;
				closeStatement( pstmt_del ) ;
				closeConnection( connection );
				insertCatList.clear();
			}
			catch ( Exception fe ) 
			{
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
				traceVal.append(fe.getMessage());
				map.put( "traceVal", traceVal.toString() ) ;
			}
		}
		map.put( "message", messages.toString() ) ;
		map.put( "traceVal", traceVal.toString() ) ;
		return map ;
	}


	public HashMap modify()
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "success.." ) ;
		return map;
	}
 
	public HashMap delete()
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "delete failure.." );
		return map;
	 }
	
	//IN071361 Starts
	public String getPractTimeBasedRuleApplicableYN() throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String pract_time_based_rule_app_yn		= "N";
		String[] practRecords		= null;
		
		try
		{
			connection = getConnection();
			pstmt = connection.prepareStatement("SELECT pract_type_time_based_yn FROM or_param WHERE MODULE_ID = 'OR' ") ;
			resultSet = pstmt.executeQuery();

			while(resultSet !=null && resultSet.next())
			{
			
				pract_time_based_rule_app_yn = resultSet.getString("pract_type_time_based_yn");
				
			}
		}
		catch(Exception e)
		{
			System.err.println("Error loading values from database");
			e.printStackTrace();
			throw e;
		}
		finally
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		return pract_time_based_rule_app_yn;
	}
//	IN071361 Ends
}
