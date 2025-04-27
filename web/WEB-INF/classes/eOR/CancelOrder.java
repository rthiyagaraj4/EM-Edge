/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------
Date       Edit History      Name        	Description
-----------------------------------------------------------------------
?             100            ?           	created
19/10/2012    IN033061      Chowminya G  System doesnt display menu cancel/discontinue if the orders are IV Fluid ,IV Fluid+Drug, IV Fluid+Drug(Frequency).		
07/08/2013	  IN042100      Chowminya G		Ph Category  -  Hold Order Option line level with MAR status P											
28/04/2017		IN063890	Vijayakumar  K	GHL-SCF-1177 [IN:063890]									
------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      		Name        		Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------------------------------
27/06/2017		IN061903			Krishna Gowtham J.	10/07/2017		Ramesh G		ML-MMOH-CRF-0555		
04/09/2017		IN007187			Raja				04/09/2017		Ramesh G		GHL-SCF-1235	
14/10/2019  	IN071315	    	Nijitha S   			14/10/2019  	Ramesh G		GHL-CRF-0607	
25/03/2020	IN072752		Nijitha S	25/03/2020	Ramesh G	ML-MMOH-CRF-1229/12
22/06/2020	IN073192 		SIVABAGYAM M		22/06/2020		RAMESH G	OR-Common-Task List-Not Done
27/08/2020	IN073809		Nijitha S			27/08/2020		Ramesh G	ML-MMOH-CRF-1229.2/05
03/05/2021	17091			Nijitha S		03/05/2021		Nijitha S		NMC-JD-SCF-0182-TF
------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
package eOR;

import java.io.* ;
import java.util.* ;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;
import eOR.Common.* ;
import eCommon.Common.*;
import javax.servlet.http.*;

import eOR.ORCancelDiscontinueOrder.*;


public class CancelOrder extends eOR.Common.OrAdapter implements java.io.Serializable 
{	
	protected Hashtable allValues = new Hashtable();
	protected String total_records = "";
	protected String cancel_desc = "";
	//protected String appt_ref_num = "";
	protected String cancel_type = "";
	protected String pract_id = "";
	protected String which_place = "";
	/*Added By Uma on 10/15/2009 for SRR20056-195*/
	public Hashtable print_report_values	= new Hashtable(); // Used for On Line Printing (Billing Refund Report)
	/* Ends Here*/
	StringBuffer traceVals = new StringBuffer();
	public void setTotalRecs(String total_records){	this.total_records = total_records;	}
	public void setCancelDesc(String cancel_desc){	this.cancel_desc = cancel_desc;	}
	public void setCancelType(String cancel_type){	this.cancel_type = cancel_type;	}
	public void setPractId(String pract_id){	this.pract_id = pract_id;	}
	//public void setApptRefNo(String appt_ref_num){	this.appt_ref_num = appt_ref_num;	}
	
	public void setWhichType(String which_place){	this.which_place = which_place;	}

	public String getTotalRecs(){					return total_records;	}
	public String getCancelDesc(){					return cancel_desc;	}
	public String getCancelType(){					return cancel_type;	}
	public String getPractId(){					return pract_id;	}
	public String getWhichType(){					return which_place;	}
	/*Added By Uma on 10/15/2009 for SRR20056-195*/
	public Hashtable getStoreReportPrintValues() { return this.print_report_values; }
	/*Ends Here*/

/**
	@return		:	ArrayList
*/

	public ArrayList getCancelReason(String order_cat) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList cancel_reason = new ArrayList();
		
		try 
		{
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ACTION_REASON") ) ;
			pstmt.setString(1, language_id);
			pstmt.setString(2, language_id);
			pstmt.setString(3, "CN");
			pstmt.setString(4, (String)order_cat.trim());
			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() ) 
			{
				String record[] = new String[3];
				record[0] = resultSet.getString("action_reason_code")  ;
				record[1] = resultSet.getString("action_reason_desc")  ;
				record[2] = resultSet.getString("action_description")  ;

				cancel_reason.add(record);
			}
		} 
		catch ( Exception e )	
		{
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
		}

		return cancel_reason;
	}

	public String getSysDate () throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String 	currentDate = "";
		
		try 
		{
			connection = getConnection() ;
			pstmt = connection.prepareStatement( CommonRepository.getCommonKeyValue("SQL_SYS_DATE_TIME") ) ;
			resultSet = pstmt.executeQuery() ;

			if( resultSet != null && resultSet.next() ) 
			{
				currentDate = resultSet.getString("sys_date_time")  ;
			}
		} 
		catch ( Exception e )	
		{
			e.printStackTrace() ;
			throw e ;
		}
		finally 
		{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
		}
		return currentDate ;


	}



/**

	@return		:	ArrayList
*/

	public ArrayList getDiscontinueReason(String order_cat) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList cancel_reason = new ArrayList();
		
		try 
		{
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ACTION_REASON") ) ;
			pstmt.setString(1, language_id);
			pstmt.setString(2, language_id);
			pstmt.setString(3, "HD");
			pstmt.setString(4, (String)order_cat.trim());
			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() ) 
			{
				String record[] = new String[3];
				record[0] = resultSet.getString("action_reason_code")  ;
				record[1] = resultSet.getString("action_reason_desc")  ;
				record[2] = resultSet.getString("action_description")  ;

				cancel_reason.add(record);
			}
		} 
		catch ( Exception e )	
		{
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
		}
		return cancel_reason;
	}



/**

	@return		:	ArrayList
*/
	public ArrayList getResumeDtl(String order_id) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList resume_dtl = new ArrayList();
		
		try 
		{
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_RESUME_ORDER_DTL") ) ;
			pstmt.setString(1, language_id);
			pstmt.setString(2, (String)order_id.trim());
			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() ) 
			{
				String record[] = new String[2];
				record[0] = resultSet.getString("practitioner_name")  ;
				record[1] = resultSet.getString("hold_date")  ;
				resume_dtl.add(record);
			}
		} 
		catch ( Exception e )	
		{
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
		}

		return resume_dtl;
	}

	public String getApptRefNo(String order_id) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String appt_ref_no			= "";
 		
		try 
		{
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_APPT_REF_NO_SELECT") ) ;
			pstmt.setString(1, (String)order_id.trim());
			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() ) 
			{
 				appt_ref_no = resultSet.getString("appt_ref_num")  ;
				if(appt_ref_no==null) 
					appt_ref_no = "";
			}
		}
		catch ( Exception e )	
		{
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
		}
		return appt_ref_no;
	}


public HashMap insert()
{
		HashMap map = new HashMap() ;
		try
		{
			map.put( "result", new Boolean( false ) ) ;
			if(allValues.containsKey("from"))
			{
				map = cancelLineRecord();
				/*Added By Uma on 10/15/2009 for SRR20056-195*/
				print_report_values	= (Hashtable) map.get("print_report_values");  // Global HashTable used to stored the values(for Billing report)
				/*Ends Here*/

			}
			else if(which_place.trim().equals("discontinue_head_rec") || which_place.trim().equals("hold_head_rec") || which_place.trim().equals("cancel_line_rec") || which_place.trim().equals("discontinue_line_rec")|| which_place.trim().equals("hold_line_rec"))
			{ // this is given inthe case of line level record

				 
				map = cancelLineRecord();
				/*Added By Uma on 10/15/2009 for SRR20056-195*/
				print_report_values	= (Hashtable) map.get("print_report_values");  // Global HashTable used to stored the values(for Billing report)
				/*Ends Here*/

			}
			else if(which_place.trim().equals("resume_order"))
			{

				map = resumeRecord();
			}
			else
			{

				map = cancelOrder();
				/*Added By Uma on 10/15/2009 for SRR20056-195*/
				print_report_values	= (Hashtable) map.get("print_report_values");  // Global HashTable used to stored the values(for Billing report)
				/*Ends Here*/

			}
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
			map.put("traceVal", traceVals.toString());
		}
		map.put("traceVal", traceVals.toString());
		return map;
}



	public HashMap cancelLineRecord() throws Exception 
	{
		//Connection connection 		= null;
		HashMap sqlMap = new HashMap() ;
		StringBuffer tmpBuff	= new StringBuffer();
		HashMap updt_map = new HashMap();
		HashMap map = new HashMap() ;
		String cont_order_ind = "";String order_status ="";
		map.put( "result", new Boolean( false ) ) ;

		try
		{
			String currentDate = getSysDate ();
			String updt_data[] = new String[16];//IN072752
			if(allValues.containsKey("DefRefundOptDiscOrder"))
			{
				updt_data[13] = (String)allValues.get("DefRefundOptDiscOrder")==null?"N":(String)allValues.get("DefRefundOptDiscOrder");
			}
			else
			{
				updt_data[13] = "Y";
			}

			updt_data[0] = (String)allValues.get("reason_desc");
			updt_data[1] = (String)allValues.get("pract_id");
			updt_data[2] = (String)allValues.get("orderId");
			updt_data[3] = (String)allValues.get("order_line_num");


			updt_data[4] = login_by_id;
			updt_data[5] = login_at_ws_no;
			updt_data[6] = login_facility_id;
			updt_data[7] = (String)allValues.get("appt_ref_num");
			updt_data[8] = (String)allValues.get("ord_typ_code");
			updt_data[9] = (String)allValues.get("catalog_code");
			updt_data[10] = (String)allValues.get("ord_cat_id");
			updt_data[11] = (((String)getOrderSetId(updt_data[2]))==null?"":((String)getOrderSetId(updt_data[2])));
			updt_data[12] = (((String)getOrderSetDetails(updt_data[11]))==null?"N": ((String)getOrderSetDetails(updt_data[11])));
			updt_data[14] = (String)allValues.get("fpp_yn");//IN072752//IN073809
			updt_data[15] = (String)allValues.get("fpp_category");//IN072752//IN073809
			
			//connection = getConnection() ;
			try{
				sqlMap.put("SQL_OR_ORDER_ENTRY_CANCEL_HEADER1",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_HEADER1") );
				sqlMap.put("SQL_OR_ORDER_ENTRY_CANCEL_HEADER2",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_HEADER2") );
				sqlMap.put("SQL_OR_ORDER_ENTRY_CANCEL_LINE1",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_LINE1") );
				sqlMap.put("SQL_OR_ORDER_ENTRY_CANCEL_LINE_SELECT",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_LINE_SELECT") );
				sqlMap.put("SQL_OR_ORDER_ENTRY_CANCEL_LINE2",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_LINE2") );
				sqlMap.put("SQL_OR_ORDER_ENTRY_CANCEL_LINE3",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_LINE3") );
				sqlMap.put("SQL_OR_BL_WITHOUT_ORDER_CATALOG",OrRepository.getOrKeyValue("SQL_OR_BL_WITHOUT_ORDER_CATALOG") );
				sqlMap.put("SQL_OR_OA_CANCEL_APPOINTMENT",OrRepository.getOrKeyValue("SQL_OR_OA_CANCEL_APPOINTMENT") );

				sqlMap.put("SQL_OR_ORDER_ENTRY_CANCEL_HEADER1_FREQ_EXPLN",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_HEADER1_FREQ_EXPLN") );
				sqlMap.put("SQL_OR_ORDER_ENTRY_CANCEL_HEADER2_FREQ_EXPLN",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_HEADER2_FREQ_EXPLN") );
				sqlMap.put("SQL_OR_ORDER_ENTRY_CANCEL_LINE1_FREQ_EXPLN",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_LINE1_FREQ_EXPLN") );
				sqlMap.put("SQL_OR_ORDER_ENTRY_CANCEL_LINE2_FREQ_EXPLN",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_LINE2_FREQ_EXPLN") );
				sqlMap.put("SQL_OR_ORDER_ENTRY_CANCEL_LINE3_FREQ_EXPLN",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_LINE3_FREQ_EXPLN") );
				sqlMap.put("SQL_OR_DISCONTINUE_ORDER_PROC",OrRepository.getOrKeyValue("SQL_OR_DISCONTINUE_ORDER_PROC") );
				sqlMap.put("SQL_OR_PH_PATIENTDRUGPROFILEUPDATE_PROC",OrRepository.getOrKeyValue("SQL_OR_PH_PATIENTDRUGPROFILEUPDATE_PROC"));
				sqlMap.put("SQL_OR_ORDER_ENTRY_CANCEL_LINE_APPT_UPDATE",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_LINE_APPT_UPDATE"));
                sqlMap.put("SQL_OR_ORDER_ENTRY_CANCEL_LINE_APPT_UPDATE_FREQ_EXPLN",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_LINE_APPT_UPDATE_FREQ_EXPLN"));
                sqlMap.put("SQL_OR_DISCONTINUE_ORDER_RD_FUNC",OrRepository.getOrKeyValue("SQL_OR_DISCONTINUE_ORDER_RD_FUNC"));
				sqlMap.put("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN",OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN"));
				sqlMap.put("SQL_OR_SPECIMEN_ORDER_RL_NEONATES_SPEC_YN",OrRepositoryExt.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_RL_NEONATES_SPEC_YN"));
				sqlMap.put("SQL_OR_CANCEL_ORDER_RL_CANCEL_SPECIMEN",OrRepositoryExt.getOrKeyValue("SQL_OR_CANCEL_ORDER_RL_CANCEL_SPECIMEN"));
				sqlMap.put("SQL_OR_CANCEL_ORDER_RL_DISCONTINUE_REQUEST",OrRepositoryExt.getOrKeyValue("SQL_OR_CANCEL_ORDER_RL_DISCONTINUE_REQUEST"));

				sqlMap.put( "SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE", OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE") );
				sqlMap.put( "SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE_CODE", OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE_CODE") );
				sqlMap.put("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS") );
				sqlMap.put("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_LINE_STATUS",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_LINE_STATUS") );
			}
			catch(Exception e)
			{
				e.printStackTrace() ;
				throw e ;
			}
			cont_order_ind = (String)allValues.get("cont_order_ind");
			order_status = (String)allValues.get("order_status");
			if (order_status==null)
			order_status="";
			
			//cont_order_ind = "DO";
			
			updt_map.put("updt_line", updt_data);
			updt_map.put("cont_order_ind",cont_order_ind);
			updt_map.put("order_status",order_status);
			updt_map.put("which_place",which_place);
			updt_map.put("currentDate",currentDate);
			updt_map.put("p_called_from_ca",(String)allValues.get("p_called_from_ca"));//IN071315


//			ORCancelDiscontinueOrderHome home = null ;
//			ORCancelDiscontinueOrderRemote remote = null ;

			try {
/*				InitialContext context = new InitialContext() ;
				Object object = context.lookup( OrRepository.getOrKeyValue("OR_CANCEL_DISCONTINUE_JNDI") ) ;
				home  = (ORCancelDiscontinueOrderHome) PortableRemoteObject.narrow( object, ORCancelDiscontinueOrderHome.class ) ;
				updt_map.put( "properties", getProperties() );
				remote = home.create() ;
*/
				 updt_map.put( "properties", getProperties() );
				 Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("OR_CANCEL_DISCONTINUE_JNDI"), ORCancelDiscontinueOrderHome.class, getLocalEJB());
		    	 Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				 Object argArray[]		=  new Object[2];
				 Class [] paramArray	=  new Class[2];
		 

				//ORCancelDiscontinueOrderManager remote1 = new ORCancelDiscontinueOrderManager();

				try
				{
					if(allValues.containsKey("from"))
					{
						if(((String)allValues.get("from")).equals("header"))
						{

							updt_map.put("source", "discontinue_head_vals");
						// commented for conversions map = remote.insert( updt_map, sqlMap ) ;
						
 							argArray[0]		= updt_map;
							argArray[1]		= sqlMap;
 
							paramArray[0]	= updt_map.getClass();
							paramArray[1]	= sqlMap.getClass();
	 						map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

							//print_report_values	= (Hashtable) map.get("print_report_values");  // Global HashTable used to stored the values(for Billing report)

	 						//map  = discontinueHeadValues(connection, updt_map, sqlMap);
						}
						else
						{
							//Added if condition --[IN033061]
							if(allValues.containsKey("iv_prep_yn")) //IN042100 added if else to avoid null pointer exception
							{	
								if(((String)allValues.get("iv_prep_yn")).equals("1") || ((String)allValues.get("iv_prep_yn")).equals("2") || ((String)allValues.get("iv_prep_yn")).equals("3") || ((String)allValues.get("iv_prep_yn")).equals("4") || ((String)allValues.get("iv_prep_yn")).equals("5"))
								{
									updt_map.put("source", "discontinue_head_vals");
								}
								else
								{
									updt_map.put("source", "updt_line_vals");
								}
							}	
							else
							{
								updt_map.put("source", "updt_line_vals");
							}
							// Commented for conversions map = remote.insert( updt_map, sqlMap ) ;
 							argArray[0]		= updt_map;
							argArray[1]		= sqlMap;
		 					
 					 		paramArray[0]	= updt_map.getClass();
							paramArray[1]	= sqlMap.getClass();
							map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);	 						

	//						map  = updateLineValues(connection, updt_map, sqlMap);

							//print_report_values	= (Hashtable) map.get("print_report_values");  // Global HashTable used to stored the values(for Billing report)
						}
					}
					else
					{

						// Commented for conversions map = remote.insert( updt_map, sqlMap ) ;
 						argArray[0]		= updt_map;
						argArray[1]		= sqlMap;
 
						paramArray[0]	= updt_map.getClass();
						paramArray[1]	= sqlMap.getClass();
						map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

	//					map  = updateLineValues(connection, updt_map, sqlMap);

						//print_report_values	= (Hashtable) map.get("print_report_values");  // Global HashTable used to stored the values(for Billing report)
					}
				}
				catch(Exception e)
				{
					e.printStackTrace() ;
				}
			 
			   (busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
			   argArray		= null;
			   paramArray	= null;
				
				
				if( ((Boolean) map.get( "result" )).booleanValue() )
				{
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				}
				map.put("traceVal", (String)tmpBuff.toString());
				tmpBuff.setLength(0);
			}
			catch(Exception e) 
			{
				map.put( "message", e.getMessage() ) ;
				e.printStackTrace() ;
			}
			finally 
			{
				clear();
				/*try {
					if( remote != null )
						remote.remove() ;
				} catch( Exception ee ) {
					map.put( "message", ee.getMessage() ) ;
				}*/
			}

		 

		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		}
		map.put("traceVal", traceVals.toString());
		return map;
}


/**
	@return		:	HashMap
*/

	public HashMap cancelOrder() throws Exception {
		//Connection connection 		= null;
		//PreparedStatement pstmt 	= null;
		//ResultSet resultSet 			= null;
		HashMap map = new HashMap() ;
		StringBuffer tmpBuff	= new StringBuffer();
		HashMap updt_map1 = new HashMap();
		HashMap sqlMap = new HashMap() ;

		map.put( "result", new Boolean( false ) ) ;

		String order_id = "";
		String line_num = "";
		String line_status = "";
		String appt_ref_num	= "";
		String tmpStr = "";
		String cont_order_ind = "";
		String cancel_line_desc = "";
		String ord_typ_code = "";
		String p_called_from_ca=""; //IN071315
		int count = 0;
		

		String currentDate = getSysDate ();

		order_id= (String)allValues.get("ord_id");
		ord_typ_code= (String)allValues.get("ord_typ_code");
		p_called_from_ca = (String) allValues.get("p_called_from_ca"); //IN071315
		int int_total_records = Integer.parseInt(total_records);


		try{
			sqlMap.put("SQL_OR_ORDER_ENTRY_CANCEL_HEADER1",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_HEADER1") );
			sqlMap.put("SQL_OR_ORDER_ENTRY_CANCEL_HEADER2",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_HEADER2") );
			sqlMap.put("SQL_OR_ORDER_ENTRY_CANCEL_LINE1",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_LINE1") );
			sqlMap.put("SQL_OR_ORDER_ENTRY_CANCEL_LINE_SELECT",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_LINE_SELECT") );
			sqlMap.put("SQL_OR_ORDER_ENTRY_CANCEL_LINE2",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_LINE2") );
			sqlMap.put("SQL_OR_ORDER_ENTRY_CANCEL_LINE3",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_LINE3") );
			sqlMap.put("SQL_OR_BL_WITHOUT_ORDER_CATALOG",OrRepository.getOrKeyValue("SQL_OR_BL_WITHOUT_ORDER_CATALOG") );
			sqlMap.put("SQL_OR_OA_CANCEL_APPOINTMENT",OrRepository.getOrKeyValue("SQL_OR_OA_CANCEL_APPOINTMENT") );

			sqlMap.put("SQL_OR_ORDER_ENTRY_CANCEL_HEADER1_FREQ_EXPLN",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_HEADER1_FREQ_EXPLN") );
			sqlMap.put("SQL_OR_ORDER_ENTRY_CANCEL_HEADER2_FREQ_EXPLN",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_HEADER2_FREQ_EXPLN") );
			sqlMap.put("SQL_OR_ORDER_ENTRY_CANCEL_LINE1_FREQ_EXPLN",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_LINE1_FREQ_EXPLN") );
			sqlMap.put("SQL_OR_ORDER_ENTRY_CANCEL_LINE2_FREQ_EXPLN",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_LINE2_FREQ_EXPLN") );
			sqlMap.put("SQL_OR_ORDER_ENTRY_CANCEL_LINE3_FREQ_EXPLN",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_LINE3_FREQ_EXPLN") );
			sqlMap.put("SQL_OR_PH_PATIENTDRUGPROFILEUPDATE_PROC",OrRepository.getOrKeyValue("SQL_OR_PH_PATIENTDRUGPROFILEUPDATE_PROC"));
			sqlMap.put("SQL_OR_ORDER_ENTRY_CANCEL_LINE_APPT_UPDATE",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_LINE_APPT_UPDATE"));
			sqlMap.put("SQL_OR_ORDER_ENTRY_CANCEL_LINE_APPT_UPDATE_FREQ_EXPLN",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_LINE_APPT_UPDATE_FREQ_EXPLN"));
			sqlMap.put("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN",OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN"));
			sqlMap.put("SQL_OR_SPECIMEN_ORDER_RL_NEONATES_SPEC_YN",OrRepositoryExt.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_RL_NEONATES_SPEC_YN"));
			sqlMap.put("SQL_OR_CANCEL_ORDER_RL_CANCEL_SPECIMEN",OrRepositoryExt.getOrKeyValue("SQL_OR_CANCEL_ORDER_RL_CANCEL_SPECIMEN"));

			sqlMap.put( "SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE", OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE") );

			sqlMap.put( "SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE_CODE", OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE_CODE") );
			sqlMap.put("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS") );
			sqlMap.put("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_LINE_STATUS",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_LINE_STATUS") );
			

		}catch(Exception e){
			e.printStackTrace() ;
			throw e ;
		}

		try {
			for(int i=0; i<int_total_records; i++){
				if(allValues.containsKey("chk"+i)){
					if(((String)allValues.get("chk"+i)).equalsIgnoreCase("on")){
						order_id = order_id.trim();
						ord_typ_code = ord_typ_code.trim();
						String order_set_id = ((String)getOrderSetId(order_id))==null?"":((String)getOrderSetId(order_id));
						if((order_id.substring(0,2).equalsIgnoreCase("PH"))&&(!(order_set_id.equals(""))))
						{
							cancel_type = "H";
						}
						//connection = getConnection() ;

						String[] updt_data1 ;
						String[] updt_data2 ;

						if(cancel_type.equals("H")) {
							
							appt_ref_num= (String)allValues.get("Appt"+i);//17091
							if(appt_ref_num==null) appt_ref_num= "";//17091
							updt_data1 = new String[11];
							updt_data2 = new String[7];//IN072752

							

							updt_data1[0] = (String)order_id;
							updt_data1[1] = (String)cancel_desc;

							updt_data1[2] = login_by_id;
							updt_data1[3] = login_at_ws_no;
							updt_data1[4] = login_facility_id;
							updt_data1[5] = ord_typ_code;
							updt_data1[6] = (String)allValues.get("ord_category");
							updt_data1[7] = (String)allValues.get("ot_install");
							updt_data1[8] = (String)allValues.get("rd_install");
							updt_data1[9] = (((String)getOrderSetId(updt_data1[0]))==null?"":((String)getOrderSetId(updt_data1[0])));
							updt_data1[10] = (((String)getOrderSetDetails(updt_data1[9]))==null?"N":((String)getOrderSetDetails(updt_data1[9])));

							
							updt_data2[0] = (String)cancel_desc;
							updt_data2[1] = (String)pract_id;
							updt_data2[2] = (String)order_id;
							updt_data2[3] = (String)appt_ref_num;
							updt_data2[4] = (String)ord_typ_code;
							updt_data2[5] = (String)allValues.get("fpp_yn"+i);//IN072752
							updt_data2[6] = (String)allValues.get("fpp_category"+i);//IN072752

						
							

	
							updt_map1.put("head_data",updt_data1);
							updt_map1.put("line_data",updt_data2);
							count++;
						}else	{
							line_num= (String)allValues.get("line_num"+i);
							line_status= (String)allValues.get("line_stat_to_updt");
							appt_ref_num= (String)allValues.get("Appt"+i);
							if(appt_ref_num==null) appt_ref_num= "";

							cancel_line_desc = "";
							cancel_line_desc = (String)allValues.get("cancel_desc"+i);
							updt_data1 = new String[13];
							updt_data2 = new String[6];//IN072752





							

							updt_data1[0] = (String)cancel_line_desc;
							updt_data1[1] = (String)pract_id;
							updt_data1[2] = (String)order_id;
							updt_data1[3] = (String)line_num;

							updt_data1[4] = login_by_id;
							updt_data1[5] = login_at_ws_no;
							updt_data1[6] = login_facility_id;
							updt_data1[7] = (String)ord_typ_code;
							updt_data1[8] = (String)allValues.get("ord_category");
							updt_data1[9] = (String)allValues.get("ot_install");
							updt_data1[10] = (String)allValues.get("rd_install");
							updt_data1[11] = (((String)getOrderSetId(updt_data1[2]))==null?"":((String)getOrderSetId(updt_data1[2])));
							updt_data1[12] = (((String)getOrderSetDetails(updt_data1[11]))==null?"N":((String)getOrderSetDetails(updt_data1[11])));

							updt_data2[0] = (String)line_status;
							updt_data2[1] = (String)order_id;
							updt_data2[2] = (String)appt_ref_num;
							updt_data2[3] = (String)ord_typ_code;
							updt_data2[4] = (String)allValues.get("fpp_yn"+i);//IN072752
							updt_data2[5] = (String)allValues.get("fpp_category"+i);//IN072752
							

							updt_map1.put("head_data"+count,updt_data1);
							updt_map1.put("line_data",updt_data2);
							count++;
							tmpStr =tmpStr+line_num+",";

						}
					}//end of if condition
				}//end of chek for contains Key
			}//end of for loop


			if(!(tmpStr.equals("")))
				tmpStr = tmpStr.substring(0,(tmpStr.length()-1));

			cont_order_ind = (String)allValues.get("cont_order_ind");
			//cont_order_ind = "DO";

			updt_map1.put("totalCount",""+count);
			updt_map1.put("tmpStr",tmpStr);
			updt_map1.put("cancel_type",cancel_type);
			updt_map1.put("cont_order_ind",cont_order_ind);

			updt_map1.put("source","cancel_order");
			updt_map1.put("currentDate",currentDate);
			updt_map1.put("p_called_from_ca",p_called_from_ca); //IN071315

			//ORCancelDiscontinueOrderHome home = null ;
			//ORCancelDiscontinueOrderRemote remote = null ;

			try {
				/*InitialContext context = new InitialContext() ;
				Object object = context.lookup( OrRepository.getOrKeyValue("OR_CANCEL_DISCONTINUE_JNDI") ) ;
				home  = (ORCancelDiscontinueOrderHome) PortableRemoteObject.narrow( object, ORCancelDiscontinueOrderHome.class ) ;
				updt_map1.put( "properties", getProperties() );
				remote = home.create() ;
				*/

				 updt_map1.put( "properties", getProperties() );

				 Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("OR_CANCEL_DISCONTINUE_JNDI"), ORCancelDiscontinueOrderHome.class, getLocalEJB());
		    	 Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				 Object argArray[]		=  new Object[2];
				 Class [] paramArray	=  new Class[2];
				 argArray[0]		= updt_map1;
				 argArray[1]		= sqlMap;
 
				 paramArray[0]	= updt_map1.getClass();
				 paramArray[1]	= sqlMap.getClass();
	 			 map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				 (busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				  argArray		= null;
				  paramArray	= null;


					
				if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));

					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;

				}
				map.put("traceVal", (String)tmpBuff.toString());


				tmpBuff.setLength(0);
				//ORCancelDiscontinueOrderManager remote1 = new ORCancelDiscontinueOrderManager();

				// commented for conversion   map = remote.insert( updt_map1, sqlMap ) ;

			} catch(Exception e) {
				map.put( "message", e.getMessage() ) ;
				e.printStackTrace() ;
			} finally {
				clear();
				/*try {
					if( remote != null )
						remote.remove() ;
				} catch( Exception ee ) {
					map.put( "message", ee.getMessage() ) ;
				}*/
			}
			//map  = updateValues(connection, updt_map1, sqlMap);

		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} 
		map.put("traceVal", traceVals.toString());
		return map;
	}


/**
	@return		:	HashMap
*/

	public HashMap resumeRecord() throws Exception {
		//Connection connection 		= null;
		//PreparedStatement pstmt 	= null;
		//ResultSet resultSet 			= null;
		HashMap map = new HashMap() ;
		StringBuffer tmpBuff	= new StringBuffer();
		HashMap updt_map1 = new HashMap();
		HashMap sqlMap = new HashMap() ;

		map.put( "result", new Boolean( false ) ) ;

		String order_id = "";
		String order_line_num = "";
		
		order_id= (String)allValues.get("orderId");
		order_line_num= (String)allValues.get("order_line_num");


		try{
			sqlMap.put("SQL_OR_ORDER_ENTRY_RESUME_ORDER_LINE",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_RESUME_ORDER_LINE") );
			sqlMap.put("SQL_OR_ORDER_ENTRY_RESUME_ORDER_HEADER",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_RESUME_ORDER_HEADER") );
		}catch(Exception e){
			e.printStackTrace() ;
			throw e ;
		}

		try {

			updt_map1.put("source","resume_order");
			updt_map1.put("order_id",order_id);
			updt_map1.put("order_line_num",order_line_num);
			updt_map1.put("login_by_id",login_by_id);
			updt_map1.put("login_at_ws_no",login_at_ws_no);
			updt_map1.put("login_facility_id",login_facility_id);
			

			//ORCancelDiscontinueOrderHome home = null ;
			//ORCancelDiscontinueOrderRemote remote = null ;

			try {
				/*InitialContext context = new InitialContext() ;
				Object object = context.lookup( OrRepository.getOrKeyValue("OR_CANCEL_DISCONTINUE_JNDI") ) ;
				home  = (ORCancelDiscontinueOrderHome) PortableRemoteObject.narrow( object, ORCancelDiscontinueOrderHome.class ) ;
				updt_map1.put( "properties", getProperties() );
				remote = home.create() ;

				//ORCancelDiscontinueOrderManager remote1 = new ORCancelDiscontinueOrderManager();

				map = remote.insert( updt_map1, sqlMap ) ;
				*/

				 updt_map1.put( "properties", getProperties() );

				 Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("OR_CANCEL_DISCONTINUE_JNDI"), ORCancelDiscontinueOrderHome.class, getLocalEJB());
		    	 Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				 Object argArray[]		=  new Object[2];
				 Class [] paramArray	=  new Class[2];
				 argArray[0]		= updt_map1;
				 argArray[1]		= sqlMap;
 
				 paramArray[0]	= updt_map1.getClass();
				 paramArray[1]	= sqlMap.getClass();
	 			 map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				 (busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				  argArray		= null;
				  paramArray	= null;
				
				if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				}
				map.put("traceVal", (String)tmpBuff.toString());
				tmpBuff.setLength(0);
			} catch(Exception e) {
				map.put( "message", e.getMessage() ) ;
				e.printStackTrace() ;
			} finally {
				clear();
				/*try {
					if( remote != null )
						remote.remove() ;
				} catch( Exception ee ) {
					map.put( "message", ee.getMessage() ) ;
				}*/
			}
			//map  = updateValues(connection, updt_map1, sqlMap);

		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} 
		map.put("traceVal", traceVals.toString());
		return map;
	}


/**
	This will set all the values to set methods - persistant methods
	@param		:   recordSet-Hashtable
	@return		:	void
*/
	public void setAll( Hashtable recordSet ) {

			allValues = recordSet;

			if(recordSet.containsKey("total_recs")){		setTotalRecs((String)recordSet.get("total_recs"));}
			if(recordSet.containsKey("cancel_desc")){	setCancelDesc((String)recordSet.get("cancel_desc"));}
			if(recordSet.containsKey("cancel_type")){	setCancelType((String)recordSet.get("cancel_type"));}
			

			if(recordSet.containsKey("pract_id")){			setPractId((String)recordSet.get("pract_id"));}
			//if(recordSet.containsKey("appt_ref_num")){	setApptRefNo((String)recordSet.get("appt_ref_num"));}
			
			if(recordSet.containsKey("which_place")){	setWhichType(((String)recordSet.get("which_place")));}// this will have the value when line record is cancelled
			this.mode = (String)recordSet.get( "mode" );
	}

	public void clear() {
		which_place = "";
		super.clear() ;
	}
	
	public HashMap validate() throws Exception {
		
		HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "" ) ;
		String ord_type_code="";

		try{

			String perform_yn = "";

			if(allValues.containsKey("function_from")){
				perform_yn = getStatus( (String)allValues.get("ord_id"),(String)allValues.get("order_line_num") , (String)allValues.get("ord_typ_code"),(String)allValues.get("which_place"),"" );
			}else{
				
				if(allValues.containsKey("order_type_code")){
				ord_type_code = (String)allValues.get("order_type_code");

				}
				if(allValues.containsKey("ord_type_code")){
				ord_type_code = (String)allValues.get("ord_type_code");

				}

				String catalog_code = "";
				if(ord_type_code.equals("")){

					ord_type_code	= getStatus( (String)allValues.get("orderId"),"" , "" ,"ORDER_TYPE","");
				}

				if(!allValues.containsKey("catalog_code")){
					catalog_code	= "";
				}else	{
					catalog_code	= (String)allValues.get("catalog_code");
				}
				//IN063890 starts
				/* commended by Rajan/Uma to be reviewed and modifed later */
				//perform_yn = getStatus( (String)allValues.get("orderId"),(String)allValues.get("order_line_num") , ord_type_code ,(String)allValues.get("which_place"),catalog_code); //Commented IN007187
				//perform_yn="Y";
				//IN063890 ends
				//IN007187  starts
				String prevOrdStatus =(String)allValues.get("OldOrderStatus");
				if(prevOrdStatus==null)//IN073192
					prevOrdStatus="";//IN073192 
				
				//if(prevOrdStatus != null || !prevOrdStatus.equals(""))//IN073192
				if(prevOrdStatus != null && !prevOrdStatus.equals(""))//IN073192
				perform_yn	= getPerformFlag( (String)allValues.get("orderId"),(String)allValues.get("order_line_num") , prevOrdStatus);
				else
				perform_yn="Y";
				//IN007187 ends
			}

			if(perform_yn.equalsIgnoreCase("N")){
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message",getMessage(language_id, "OR_STATUS_CHANGED","OR") ) ;
			}				
		
		}catch(Exception e){

			e.printStackTrace();
		}

		 return map ;
	}
//IN007187 starts
	public String getPerformFlag(String order_id,String order_line_num,String prev_ord_status ) throws Exception {

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		String perform_yn			= "N";
		try{
			connection	= getConnection();
				if("".equals(order_line_num))
				pstmt		= connection.prepareStatement("SELECT 'Y' FROM OR_ORDER WHERE ORDER_ID= ? AND ORDER_STATUS = ?") ;
				else
				pstmt		= connection.prepareStatement("SELECT 'Y' FROM OR_ORDER_LINE WHERE ORDER_ID= ? AND ORDER_LINE_STATUS= ? AND ORDER_LINE_NUM = ?") ;

				pstmt.setString(1, order_id);
				pstmt.setString(2, prev_ord_status);
				if(!("".equals(order_line_num)))
					pstmt.setString(3, order_line_num);


				resultSet	= pstmt.executeQuery() ;
			
				while(resultSet != null && resultSet.next()) {
					perform_yn = checkForNull(resultSet.getString(1),"N") ;

				}
	
		}catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}

			return perform_yn;
	}	
//IN007187 Ends
	public String getStatus(String order_id,String order_line_num,String order_type_code,String perfm_func,String order_catalog_code ) throws Exception {

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		String perform_yn			= "";
		try{
			connection	= getConnection();
			
			if(perfm_func.equals("ORDER_TYPE")){
				pstmt		= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_TYPE_CODE")) ;
				pstmt.setString(1, order_id);

				resultSet	= pstmt.executeQuery() ;
			
				while(resultSet != null && resultSet.next()) {
					perform_yn = checkForNull(resultSet.getString( "order_type_code" ),"N") ;

				}

			}else{

				if(perfm_func.equals(""))
					perfm_func = "EXISTING_ORDER1";
				else if(perfm_func.equals("cancel_line_rec"))
					perfm_func = "EXISTING_ORDER_CANCEL";
				
								
				
				if(perfm_func.equals("discontinue_line_rec")){
					if(order_line_num.equals(""))
					{
						perfm_func = "DISCONTINUE";

					}
					else{
						perfm_func = "EXISTING_ORDER_DISCONTINUE";
					}
				}else if(perfm_func.equals("hold_head_rec") || perfm_func.equals("hold_line_rec"))
					perfm_func = "HOLD";
				else if(perfm_func.equals("resume_order"))
					perfm_func = "RESUME";
		
				if(order_line_num != null && !order_line_num.equals("")){

					pstmt		= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_LINE_STATUS_CHK")) ;
					pstmt.setString(1, perfm_func);
					pstmt.setString(2, order_id);
					pstmt.setString(3, order_type_code);
					pstmt.setString(4, order_catalog_code);
					pstmt.setString(5, order_line_num);
					
				}else{
				    
					pstmt		= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_STATUS_CHK")) ;
					pstmt.setString(1, perfm_func);
					pstmt.setString(2, order_id);
					pstmt.setString(3, order_type_code);
					
				}
				
				resultSet	= pstmt.executeQuery() ;
				
				while(resultSet != null && resultSet.next()) {
					perform_yn = checkForNull(resultSet.getString( "perform_yn" ),"") ;  
				}
		
			}
			
		}catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}

			return perform_yn;
	}	 
	public String getOrderSetId(String order_id) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String record = "";
		try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_ID") ) ;
				pstmt.setString( 1,order_id.trim());
				resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) 
			{
				record = resultSet.getString("order_set_id" )  ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}
		return record;
	}
	
	public String getOrderSetDetails(String order_id) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String record = "N" ;
		try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_BILL_DETAILS") ) ;
				pstmt.setString( 1,order_id.trim());
				resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) 
			{
				record = resultSet.getString("bill_yn")  ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return record;
	}

	/*Added By Uma on 10/15/2009 for SRR20056-195*/
	public void callOnLineCancelPrinting(Hashtable print_values,HttpServletRequest request , HttpServletResponse response) throws Exception 
	{
		//, Hashtable stored_print_values,
 		//OnLinePrinting online_print = new OnLinePrinting(request,response);
		OnLinePrinting online_print = new OnLinePrinting();

		//OnLinePrinting online_print = new OnLinePrinting();
		// one parameter is to print the order form , another paramater is to print the consent forms
		online_print.callCancelOrderPrint(print_values,request,response);//Pass the Hashtable print_values (Stored in generateUniqueIds() )
		//,stored_print_values ,

	} // End of callOnLinePrinting
	/*Ends Here*/


	public String getDiscontinueRefund() throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String param_refund = "";
		
		try 
		{
			connection = getConnection() ;
			pstmt = connection.prepareStatement("select NVL(def_refund_opt_disc_order,'N') def_refund_opt_disc_order from or_param_by_facility where OPERATING_FACILITY_ID=?") ;
			pstmt.setString(1, login_facility_id);
			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() ) 
			{
				param_refund = resultSet.getString("def_refund_opt_disc_order")  ;
			}
		} 
		catch ( Exception e )	
		{

			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
		}
		return param_refund;
	}
	//IN061903 start
	public ArrayList getNotDoneReason(String order_cat) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList cancel_reason = new ArrayList();
		
		try 
		{
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ACTION_REASON") ) ;
			pstmt.setString(1, language_id);
			pstmt.setString(2, language_id);
			pstmt.setString(3, "ND");
			pstmt.setString(4, (String)order_cat.trim());
			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() ) 
			{
				String record[] = new String[3];
				record[0] = resultSet.getString("action_reason_code")  ;
				record[1] = resultSet.getString("action_reason_desc")  ;
				record[2] = resultSet.getString("action_description")  ;

				cancel_reason.add(record);
			}
		} 
		catch ( Exception e )	
		{
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
		}
		return cancel_reason;
	}
	//IN061903 end
	//IN072752 Starts
	public ArrayList getFPPDetailsForOrder(String order_id,String order_line_no) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList fppDtls = new ArrayList();
		
		try 
		{
			connection = getConnection() ;
			pstmt = connection.prepareStatement( "SELECT FPP_YN,FPP_CATEGORY FROM OR_ORDER_LINE WHERE ORDER_ID=? AND ORDER_LINE_NUM=?" ) ;
			pstmt.setString(1, order_id);
			pstmt.setString(2, order_line_no);
			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() ) 
			{
				
				fppDtls.add(resultSet.getString("fpp_yn"))  ;
				fppDtls.add(resultSet.getString("fpp_category"))  ;
				
			}
		} 
		catch ( Exception e )	
		{
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
		}

		return fppDtls;
	}
	//IN072752 Ends
}
