/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
?             100            ?           created
20/01/2012	   IN030545		Ramesh			IN030545
11/09/2012    IN034785      Chowminya G 	Incident No: IN034785 - <In the multi-facility scenario -  Charge details display> 
05/02/2020	IN068314	Nijitha S	05/02/2020	Ramesh G	ML-MMOH-CRF-1229
--------------------------------------------------------------------------------------------------------
*/
/*************************************************************************
*  ClassName          	:  OrderEntryBillingQueryBean
*  Description          :  Used Like an DAO (Billing Information), In Order Entry(New Orders, Order Set, Amend Orders) ,
*  Methods            	:
*  Exception          	:
*  Authors            	:
*  Version            	: 1.0
*  Date            		:
*  Revision History     :
***************************************************************************
*   Version      Date    Name    Remarks
***************************************************************************/
package eOR;

import java.io.*;
import java.util.*;
import java.sql.*;
import javax.rmi.* ;
import webbeans.eCommon.*;
import javax.naming.* ;

import eOR.Common.* ;
import eCommon.Common.*;

public class  OrderEntryBillingQueryBean extends OrAdapter implements Serializable
{
	HashMap		hashOrdersfindetails		= new HashMap();
	protected Hashtable hashMap 			= new Hashtable();
	//String Future_order_yn="N";

	public OrderEntryBillingQueryBean(){
	 // try{
		//doCommon();
	  //}catch(Exception e) {}
	 }

// Method to get the Billing Info on load of the First Screen.....(Before Addnl. Search)
	public ArrayList getBillingInfo(Properties properties, String login_facility_id, String encounter_id, String patient_class, String patient_id) throws Exception {
		Connection connection 		= null;
		CallableStatement cstmt 	= null;
		ArrayList BillingInfo		= new ArrayList() ;
		String[]  billing_details	= new String[2];
		try{
			//connection	= getConnection();
			connection		= ConnectionManager.getConnection(properties);
  			cstmt			= connection.prepareCall("{ "+OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILLING_INFO")+" }");
			cstmt.setString(1, login_facility_id);						 // FACILITY_ID
			cstmt.setString(2, checkForNull(encounter_id,""));  							 // ENCOUNTER_ID
			cstmt.setString(3, patient_class); 							 // PATIENT_CLASS
			cstmt.registerOutParameter( 4,  Types.VARCHAR ) ;			 // WARNING_MSG
			cstmt.registerOutParameter( 5,  Types.VARCHAR ) ;			 // ERROR_MSG
 			cstmt.setString(6, patient_id);								 // PATIENT_ID

			cstmt.execute();
			billing_details[0] = checkForNull(cstmt.getString(4),"");
			billing_details[1] = checkForNull(cstmt.getString(5),"");
			BillingInfo.add(billing_details) ;
		}catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			try{
				closeStatement( cstmt);
			} catch(Exception exec){
				exec.printStackTrace();
			}
			if(connection!=null) ConnectionManager.returnConnection( connection, properties ) ;
		} // End of finally

 		return BillingInfo;
	} // End of getBillingInfo

	
	/*
	 *  Setting the Order Order Billing Details Template
	 */
	public boolean setOrderBillDtls (String checkedKey, HashMap property_value ) throws Exception
	{	//.......The catalog_code-------has the value as (catalog_code+seq_num)
		//.......The property_value-----has the value of all financial details 
		boolean order_billdtls_status = false;
		try
		{
			if(property_value != null)
			{
				hashOrdersfindetails.put(checkedKey,(HashMap)property_value);
				
			}
			
			order_billdtls_status	= true;
		} // end of try
		catch(Exception e)
		{
			order_billdtls_status	= false;
			e.printStackTrace();
			throw new Exception("Exception when setting the billing values");
		
		} // end of catch
		return order_billdtls_status;
	} // end of setOrderBillDtls
	
	/*
	 *	Retrieving the Order Bill Details Template
	 */
	public HashMap getOrderBillDtls(String checkedKey) throws Exception
	{
		HashMap billdtls_value  =	null;
		try
		{
			billdtls_value = ((HashMap) hashOrdersfindetails.get(checkedKey));
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("When Retrieving from the Bean");
			
		}
			
		return	billdtls_value;
					
	} // end of getOrderBillDtls(java.lang.String)		 

	
	 /*
	 *    Removing  the OrderBillDtls (CANCEL)
	 */
	public boolean removeOrderBillDtls (String checkedKey )  throws Exception
	{
		boolean order_billdtls_status = false;
		try
		{
			if(checkedKey != null  && hashOrdersfindetails.containsKey(checkedKey)){
				hashOrdersfindetails.remove(checkedKey);
				order_billdtls_status	=	true;
			}
		
		} // end of try
		catch(Exception e)
		{
			order_billdtls_status	=	false;
			e.printStackTrace();
			throw new Exception("When Removing from the Bean");
		} // end of catch
		return order_billdtls_status;
	} // end of removeOrderFormats

	public void clearBean()
	{
		if( hashOrdersfindetails != null )
	 	{
	 		hashOrdersfindetails.clear();
	 	}else
			hashOrdersfindetails	= new java.util.HashMap();

	}

	 // Method to get the Billing Info on load of the First Screen.....(Before Addnl. Search)
	 public ArrayList getBillChargeDetails(String quantity,String catalog_code,String start_date_time,String language_id,String order_id,String order_line_no,String patient_id, String encounter_id,String patient_class,String practitioner_id) throws Exception {

		Connection connection 											= null;
		CallableStatement cstmt 										= null;
		PreparedStatement pstmt 										= null;
		PreparedStatement pstmt_floor_to_start_day	 					= null;
		PreparedStatement pstmt_mod_physician_id	 					= null;
		ResultSet resultSet 											= null;
		ResultSet resultSet_floor_to_start_day 							= null;
		ResultSet resultSet_mod_physician_id 							= null;
		PreparedStatement pstmt_bl 										= null;//--[IN034785]
		ResultSet rs													= null;//--[IN034785]
		String l_facility_id											= "";//--[IN034785]
		ArrayList BillChargeInfo										= new ArrayList() ;

		String[]  billing_details										= new String[21];
		String round_off_start_date										="N";
		String mod_physician_id											="";
		
		try
		{
		
				connection	= getConnection();
				//--[IN034785] - Start
				if (!order_id.equals("")) 
				{ 
					pstmt_bl = connection.prepareStatement("select a.ordering_facility_id from or_order a,or_order_line b where a.order_id=b.order_id and a.order_id =? and b.order_line_num=?");
					pstmt_bl.setString(1, order_id); 
					pstmt_bl.setString(2, order_line_no); 
					rs	= pstmt_bl.executeQuery() ;
					if ( rs != null )
					{
						while(rs.next())
						{
							l_facility_id = checkForNull(rs.getString( "ordering_facility_id" ),"")  ;
						}
					}
				}
				else 
				{
					l_facility_id = login_facility_id;
				}
				//--[IN034785] - End
				
				//Added Against ML-MMOH-SCF-2375 by Gaurav...Starts
				ArrayList fppList = new ArrayList(2);
				fppList = getFPPDetails(catalog_code);
				String str = fppList.toString().replaceAll("\\[|\\]", "").replaceAll(", ",", ");
				String[] fppDetails = str.split(",");
				String fpp_yn = fppDetails[0].trim();
				String fpp_category = fppDetails[1].trim();
				System.err.println("fpp_yn= "+fpp_yn);
				System.err.println("fpp_category= "+fpp_category);
				//Added Against ML-MMOH-SCF-2375 by Gaurav...Ends
				
				pstmt_mod_physician_id		= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_MOD_PHYSICIAN_ID"));				
				cstmt = connection.prepareCall("{ "+OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_GET_CHARGE_DETAILS")+" }");
				//cstmt.setString(1, login_facility_id);  					 // FACILITY_ID --[IN034785] - commented
				cstmt.setString(1, l_facility_id); //--[IN034785]
				cstmt.setString(2, encounter_id);  			  	   			 // ENCOUNTER_ID
				cstmt.setString(3, patient_class); 							 // PATIENT_CLASS
				cstmt.setString(4, patient_id); 							 // PATIENT_ID
				//---[IN030545]/start---
				//cstmt.setInt(5, Integer.parseInt(checkForNull(quantity,"0"))); 	 // QUANTITY FROM PLACE ORDER SCREEN
				cstmt.setDouble(5, Double.parseDouble(checkForNull(quantity,"0")));
				//---[IN030545]/ends---
				cstmt.setString(6, catalog_code); 					 		 // CATALOG_CODE
				cstmt.setString(7, start_date_time); 				 		 // START_DATE_TIME
				cstmt.setString(8, practitioner_id); 						 // PRACTITIONER_ID
				cstmt.setString(9, language_id); 							 // P_LANGUAGE_ID
				cstmt.registerOutParameter( 10,  Types.VARCHAR ) ;			 // P_STR
				cstmt.registerOutParameter( 11,  Types.VARCHAR ) ;			 // P_CHARGE_BASED_YN
				cstmt.registerOutParameter( 12,  Types.NUMERIC ) ;			 // P_TOT_AMT
				cstmt.registerOutParameter( 13,  Types.NUMERIC ) ;			 // P_PAT_PAYABLE_AMT
				cstmt.registerOutParameter( 14,  Types.VARCHAR ) ;			 // P_EXCL_INCL_IND
				cstmt.registerOutParameter( 15,  Types.VARCHAR ) ;			 // P_PREAPP_YN
				cstmt.registerOutParameter( 16,  Types.NUMERIC ) ;			 // P_PAT_PAID_AMT
				cstmt.registerOutParameter( 17,  Types.VARCHAR ) ;			 // P_CHARGED_YN
				cstmt.registerOutParameter( 18,  Types.VARCHAR ) ;			 // P_PAT_BILLED_YN
				cstmt.registerOutParameter( 19,  Types.VARCHAR ) ;			 // ERROR_TEXT
				cstmt.registerOutParameter( 20,  Types.VARCHAR ) ;			 // P_SERV_PANEL_IND
				cstmt.registerOutParameter( 21,  Types.VARCHAR ) ;			 // P_SERV_PANEL_CODE
				cstmt.registerOutParameter( 22,  Types.VARCHAR ) ;			 // P_SERVICE_PANEL_NAME
				cstmt.registerOutParameter( 23,  Types.VARCHAR ) ;			 // P_EPISODE_TYPE
				cstmt.registerOutParameter( 24,  Types.NUMERIC ) ;			 // P_EPISODE_ID
				cstmt.registerOutParameter( 25,  Types.NUMERIC ) ;			 // P_VISIT_ID
				cstmt.setString( 26,  order_id ) ;							 // P_ORDER_ID
				cstmt.setString( 27,  order_line_no ) ;						 // P_ORDER_LINE_NO
				
				//Added Against ML-MMOH-SCF-2375 by Gaurav...starts
				if(fpp_yn.equals("Y")){
				cstmt.setString( 28,  "Y"  ) ;						 
				cstmt.setString( 29,  fpp_category ) ;						 
				}else{
				cstmt.setString( 28,  null ) ;						 // fpp_yn IN068314
				cstmt.setString( 29,  null ) ;						 // fpp_category IN068314	
				}
				//Added Against ML-MMOH-SCF-2375 by Gaurav...Ends

				cstmt.execute();
				billing_details[0]  = checkForNull(cstmt.getString(10),"");
				billing_details[1]  = checkForNull(cstmt.getString(11),"");
				billing_details[2]  = checkForNull(String.valueOf(cstmt.getDouble(12)),"");				
				billing_details[3]  = checkForNull(String.valueOf(cstmt.getDouble(13)),"");				
				billing_details[4]  = checkForNull(cstmt.getString(14),""); 
				billing_details[5]  = checkForNull(cstmt.getString(15),""); 
				billing_details[6]  = checkForNull(String.valueOf(cstmt.getDouble(16)),"");
				billing_details[7]  = checkForNull(cstmt.getString(17),"");
				billing_details[8]  = checkForNull(cstmt.getString(18),"");
				billing_details[9]  = checkForNull(cstmt.getString(19),"");
				billing_details[10] = checkForNull(cstmt.getString(20),"");
				billing_details[11] = checkForNull(cstmt.getString(21),"");
				billing_details[12] = checkForNull(cstmt.getString(22),"");
				billing_details[13] = checkForNull(cstmt.getString(23),"");
				billing_details[14] = checkForNull(cstmt.getString(24),"");
				billing_details[15] = checkForNull(cstmt.getString(25),"");
				billing_details[16]  = checkForNull(cstmt.getString(14),""); // new P_EXCL_INCL_IND
			
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_FUTURE_ORDER_CHARGE_LATER_IND"));
				pstmt.setString(1, "OR");  					 // FACILITY_ID
				pstmt.setString(2, catalog_code);  			  	   			 // ENCOUNTER_ID
				pstmt.setString(3, billing_details[13]); 	
				pstmt.setString(4, catalog_code); 
				pstmt.setString(5, patient_class); 
				
				resultSet	= pstmt.executeQuery() ;
				String futureBillInd ="";
				String Future_date="";
		
				if ( resultSet != null )
				{
					while(resultSet.next())
					{
						
						futureBillInd =checkForNull(resultSet.getString( "Future_Bill_ind" ),"")  ;
				
						if (futureBillInd.equals("NOW"))
						{
							billing_details[17]="N";
						}
						else if (futureBillInd.equals("LATER") )
						{
							billing_details[17]="Y";
						}
						else
							billing_details[17]="";
						Future_date=checkForNull(resultSet.getString( "furure_order_date" ),"")  ;
					    billing_details[18]=Future_date;
					}
				}

				pstmt_floor_to_start_day		= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_FLOOR_TO_START_DAY_YN")); 
				pstmt_floor_to_start_day.setString(1, catalog_code);  			  	   			 // CATALOG_CODE
				pstmt_floor_to_start_day.setString(2, patient_class);                             // PATIENT_CLASS
				resultSet_floor_to_start_day	= pstmt_floor_to_start_day.executeQuery() ;
				

				if (resultSet_floor_to_start_day != null )
				{
					while(resultSet_floor_to_start_day.next())
					{
						round_off_start_date =checkForNull(resultSet_floor_to_start_day.getString( "floor_to_start_day_yn" ),"N")  ;	
					    billing_details[19]=round_off_start_date;
					}
				}
				
				if(!order_id.equalsIgnoreCase(""))
				{
				 
					pstmt_mod_physician_id.setString(1, "OR");  			  	   			   // module_id
					pstmt_mod_physician_id.setString(2, order_id);                             // order_id
					pstmt_mod_physician_id.setString(3, order_line_no);                        // order_line_no
					pstmt_mod_physician_id.setString(4, patient_id);                           // patient_id
					pstmt_mod_physician_id.setString(5, billing_details[13]==null?"":billing_details[13]);// episode_type				
					pstmt_mod_physician_id.setString(6, billing_details[15]==null?"":billing_details[15]);// visit_id
					pstmt_mod_physician_id.setString(7, billing_details[14]==null?"":billing_details[14]);// episode_id
					pstmt_mod_physician_id.setString(8, login_facility_id);// facility_id
					resultSet_mod_physician_id	= pstmt_mod_physician_id.executeQuery() ;
				

					if (resultSet_mod_physician_id != null )
					{
						while(resultSet_mod_physician_id.next())
						{							
							mod_physician_id = checkForNull(resultSet_mod_physician_id.getString( "PHYSICIAN_ID" ),"")  ;			
							billing_details[20] = mod_physician_id;
						}
					}
				}
				else
				{
					billing_details[20] = "";
				}
				BillChargeInfo.add(billing_details) ;

		   }
		   catch ( Exception e )	
			{
				e.printStackTrace() ;
			throw e ;
			} 
			finally 
			{
				closeResultSet( resultSet ) ;
				closeResultSet( resultSet_floor_to_start_day ) ;
				closeResultSet( resultSet_mod_physician_id ) ;
				closeResultSet( rs ) ;
				closeStatement( pstmt_bl);
				closeStatement( cstmt);
				closeStatement( pstmt);
				closeStatement( pstmt_floor_to_start_day);
				closeStatement( pstmt_mod_physician_id);
				closeConnection(connection);
			}
			return BillChargeInfo;
	 } // End of getBillChargeDetails
	
	// Method to get the Common Billing Info for the Order Ids passed...
	public ArrayList viewBillCatalogDetails(String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList billCatalogInfo		= new ArrayList() ;
		String[]  record			= null;
		 String bill_query="";
		try{

			connection	= getConnection();
			  			
  			//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("") ) ;
			bill_query=(String)OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_VIEW_BILL_CATALOG_DETAILS");
			
			pstmt = connection.prepareStatement(bill_query);
			pstmt.setString(1, language_id);						 // order_id
			pstmt.setString(2, order_id);						 // order_id
			
			resultSet = pstmt.executeQuery() ;
			while ( resultSet!=null && resultSet.next()) {

				record = new String[21];//IN068314
				record[0] = checkForNull(resultSet.getString( "order_line_num" ),"")  ;
				record[1] = checkForNull(resultSet.getString( "patient_id" ),"")  ;
				record[2] = checkForNull(resultSet.getString( "patient_class" ),"")  ;
				record[3] = checkForNull(resultSet.getString( "encounter_id" ),"")  ;
				record[4] = checkForNull(resultSet.getString( "bill_yn" ),"")  ;
				record[5] = checkForNull(resultSet.getString( "cont_order_ind" ),"")  ;
				record[6] = checkForNull(resultSet.getString( "performing_facility_id" ),"")  ;
				record[7] = checkForNull(resultSet.getString( "order_catalog_code" ),"")  ;
				record[8] = checkForNull(resultSet.getString( "catalog_desc" ),"")  ;
				record[9] = checkForNull(resultSet.getString( "order_qty" ),"")  ;
				record[10] = checkForNull(resultSet.getString( "start_date_time" ),"")  ;
				record[11] = checkForNull(resultSet.getString( "ord_auth_reqd_yn" ),"")  ;
				record[12] = checkForNull(resultSet.getString( "ord_auth_by_pract_id" ),"")  ;
				record[13] = checkForNull(resultSet.getString( "ord_appr_reqd_yn" ),"")  ;
				record[14] = checkForNull(resultSet.getString( "ord_appr_by_user_id" ),"")  ;
				record[15] = checkForNull(resultSet.getString( "ord_consent_reqd_yn" ),"")  ;
				record[16] = checkForNull(resultSet.getString( "ord_consent_by_id" ),"")  ;
				record[17] = checkForNull(resultSet.getString( "result_auth_reqd_yn" ),"")  ;
				record[18] = checkForNull(resultSet.getString( "contr_mod_id" ),"")  ;
				record[19] = checkForNull(resultSet.getString( "fpp_yn" ),"")  ;//IN068314
				record[20] = checkForNull(resultSet.getString( "fpp_category" ),"")  ;//IN068314
				
				
				billCatalogInfo.add(record) ;
			}
			
		}catch ( Exception e )	{
			e.printStackTrace() ;
			
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		} // End of finally
		
 		return billCatalogInfo;
	} // End of getBillingInfo

	 public String getBillingInterfaceYn() throws Exception {
		 Connection connection 		= null;
		 PreparedStatement pstmt 	= null;
		 ResultSet resultSet 		= null;
		 String billing_interface_yn= "N";
		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_PRINT_LOCATION"));
			pstmt.setString(1, getLoginFacilityId()); // pass the facility_id
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )    // Only one record for the module_id
			{
				while(resultSet.next())
				{
					billing_interface_yn = checkForNull(resultSet.getString( "bl_module_yn" ),"N")  ;
				}
			}	// if there is no record, then also it should return as 'N'
	 	} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
	 	} finally {
			closeResultSet( resultSet);
			closeStatement( pstmt);
			closeConnection(connection);
 		}

 		return billing_interface_yn;
	 } // End of getBillingInterfaceYn
	

	/**
	This will set all the values to set methods - persistant methods
	@param		:   recordSet-Hashtable
	@return		:	void
*/
 public String getSysDate() throws Exception {
	 Connection connection 		= null;
	 PreparedStatement pstmt 	= null;
	 ResultSet resultSet 		= null;
	 String sys_date			= "";
	 try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SCHEDULE_TODAY_DAY_TIME"));
		    resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )    // Only one record for the date
			{
				while(resultSet.next())
				{
					sys_date = checkForNull(resultSet.getString( "sys_date_time" ),"")  ;
				}
			}
	 	} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
	 	} finally {
			closeResultSet( resultSet);
			closeStatement( pstmt);
			closeConnection(connection);
 		}
 		return sys_date;
 } // End of getSysdate

	public void setAll( Hashtable recordSet ) {
		hashMap = recordSet;
		this.mode = (String)recordSet.get( "mode" );
		
	}

	public HashMap insert(){
		
		HashMap map						 = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		
		Connection connection			= null ;
		CallableStatement cstmt 		= null ;
		PreparedStatement pstmt 		= null ;
		ResultSet rs							=null;
		HashMap bill_dtls				= null ;
		boolean result					= true ;
		
		String auth_consent_approv_yn	= "N" ;
		String error_message			= "" ;
		String incl_excl_action			= "" ;
		String incl_excl_action_orginal			= "" ;
		String p_total_amt			= "" ;
		String Future_order_yn			= "" ;

		String incl_excl_action_reason	= "" ;
		String bl_panel_str				= "" ;
		int int_total_records			= Integer.parseInt(checkForNull((String)hashMap.get("total_rows"),"0"));
		String mod_physician_id			= "";
		String fpp_yn ="";//IN068314
		String fpp_category = "";//IN068314
		try {
			connection = getConnection() ;
			for(int i=0; i<int_total_records; i++){
		
				try{

					auth_consent_approv_yn = "N";
					if(checkForNull(((String)hashMap.get("order_set_bill_yn"+i)),"N").equalsIgnoreCase("N"))
					{
						if(checkForNull(((String)hashMap.get("ord_consent_reqd_yn"+i)),"N").equals("Y") ){
							if(checkForNull(((String)hashMap.get("ord_consent_by_id"+i)),"").equals("") )				 
							 auth_consent_approv_yn = "Y";
						}
						if(auth_consent_approv_yn=="N" && checkForNull(((String)hashMap.get("ord_auth_reqd_yn"+i)),"N").equals("Y") )
						{
							if(checkForNull(((String)hashMap.get("ord_auth_by_pract_id"+i)),"").equals(""))
							   auth_consent_approv_yn = "Y";
						}
						if(auth_consent_approv_yn=="N" && checkForNull(((String)hashMap.get("ord_spl_appr_reqd_yn"+i)),"N").equals("Y") )
						{
							if(checkForNull(((String)hashMap.get("ord_appr_by_user_id"+i)),"").equals("") )
								auth_consent_approv_yn = "Y";
						}  
					}
					else
					{
						String order_set_status_type="";
						String order_set_status_type_code="";

						String order_set_status_query=(String)OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE");
						String order_set_status_query_code=(String)OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE_CODE");

						pstmt=connection.prepareStatement(order_set_status_query);
						pstmt.setString(1,checkForNull((String)hashMap.get("order_id"+i),""));
						rs=pstmt.executeQuery();
						while(rs.next())
						{
							order_set_status_type=rs.getString("order_set_status");
						}
												
						closeStatement(pstmt);
						closeResultSet(rs);

						pstmt=connection.prepareStatement(order_set_status_query_code);
						pstmt.setString(1,order_set_status_type);
						rs=pstmt.executeQuery();
						while(rs.next())
						{
							order_set_status_type_code=rs.getString("order_status_type");
						}
					
						closeStatement(pstmt);
						closeResultSet(rs);
						if((order_set_status_type_code.equalsIgnoreCase("00"))||(order_set_status_type_code.equalsIgnoreCase("03"))||(order_set_status_type_code.equalsIgnoreCase("05")))
						{
							auth_consent_approv_yn = "Y";
							
						}
						else
						{
							auth_consent_approv_yn = "N";
							
						}
				   }
					//com.ehis.util.DateUtils.convertDate(checkForNull((String)hashMap.get("start_date_time"+i),""),"DMYHM",language_id,"en");

					cstmt = connection.prepareCall("{ "+OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_ORDER_CATALOG_LINE")+" }");
					cstmt.setString(1,  login_facility_id);													// LOGIN_FACILITY_ID
					cstmt.setString(2,  checkForNull((String)hashMap.get("patient_id"),""));				// PATIENT_ID
					cstmt.setString(3,  checkForNull((String)hashMap.get("encounter_id"),""));				// ENCOUNTER_ID
					cstmt.setString(4,  checkForNull((String)hashMap.get("patient_class"),""));				// PATIENT_CLASS
					//if((String)hashMap.get("called_from").equals("register_visit"))
					//{
						cstmt.setString(5,  checkForNull((String)hashMap.get("order_id"+i),""));	
					//}
					//else
					//{
						//cstmt.setString(5,  checkForNull((String)hashMap.get("orderId"),""));		
					//}// ORDER_ID
					
					cstmt.setString(6,  checkForNull((String)hashMap.get("order_line_num"+i),""));			// ORDER_LINE_NUM
					
					cstmt.setString(7,  checkForNull((String)hashMap.get("order_catalog_code"+i),""));		// CATALOG_CODE
					cstmt.setString(8,  checkForNull((String)hashMap.get("order_catalog_desc"+i),""));		// CATALOG_DESC
					cstmt.setString(9,  checkForNull((String)hashMap.get("start_date_time"+i),""));			// START_DATE_TIME
					cstmt.setString(10, checkForNull((String)hashMap.get("order_qty"+i),""));				// SERV_QTY
					// get the revise billing charges 
					
					bill_dtls = (HashMap)getOrderBillDtls(checkForNull((String)hashMap.get("order_id"+i),"")+checkForNull((String)hashMap.get("order_line_num"+i),""));
					
					if(bill_dtls != null){
						//p_total_amt		 = (String)bill_dtls.get("total_payable");
						p_total_amt		 = (String)bill_dtls.get("rate");
						incl_excl_action		 = (String)bill_dtls.get("incl_excl_action");
						incl_excl_action_orginal	 = (String)bill_dtls.get("incl_excl_action_orginal");
						Future_order_yn	 = (String)bill_dtls.get("Future_order_yn");
						fpp_category = (String)bill_dtls.get("fpp_category");//IN068314
						fpp_yn = (String)bill_dtls.get("fpp_yn");//IN068314
							if(incl_excl_action.equals(incl_excl_action_orginal))
							{
							incl_excl_action="";
							}
							else
							{
							incl_excl_action		 = (String)bill_dtls.get("incl_excl_action");
							}
							//incl_excl_action="";
							incl_excl_action_reason	 = (String)bill_dtls.get("incl_excl_action_reason");
							//incl_excl_action_reason="";
							bl_panel_str			 = (String)bill_dtls.get("bl_panel_str");
							mod_physician_id = bill_dtls.get("mod_physician_id")==null?"":(String)bill_dtls.get("mod_physician_id");
						}
					
					cstmt.setString(11, p_total_amt);																					// p_charge_based_amt
					/*Modified by Uma on 3/24/2010 for billing physician change*/
					if (mod_physician_id.equals(""))
					{
						cstmt.setString(12, checkForNull((String)hashMap.get("ordering_practitioner"),""));		// PRACTITIONER_ID
					}
					else
					{
						cstmt.setString(12, mod_physician_id);	
					}
					/*Ends Here by Uma*/
					cstmt.setString(13 ,  incl_excl_action);												// P_OVERRIDDEN_EXCL_INCL_IND 
					cstmt.setString(14 ,  incl_excl_action_reason);											// P_ACTION_REASON_CODE 	
					cstmt.setString(15 ,  bl_panel_str);													// P_STR 
					cstmt.setString(16 ,  Future_order_yn);															// P_FUTURE_ORDER_YN									// P_FUTURE_ORDER_YN
					cstmt.setString(17, getFutureOrderYn((String)hashMap.get("order_id"+i),(String)hashMap.get("order_line_num"+i),(String)hashMap.get("order_catalog_code"+i)));						// P_FUTURE_ORDER_CHARGE_LATER_YN
					
					cstmt.setString(18, auth_consent_approv_yn);											// AUTH_CONSENT_APPROV_YN

					cstmt.setString(19, "N");																// AUTO_REGISTER
					cstmt.setString(20, "N");																// COMPLETE_ON_ORDER_YN
					cstmt.setString(21, "N");																// CANCEL_ON_ORDER_YN
					cstmt.setString(22, "N");																// RESULT_ON_ORDER_YN
					cstmt.setString(23, "N");																// AMEND_ON_ORDER_YN
					
					cstmt.setString(24, "N");																// REGISTER_ON_ORDER_YN
					cstmt.setString(25, login_by_id);														// USER
					cstmt.setString(26, login_at_ws_no);													// WS_NO
					cstmt.registerOutParameter( 27,  Types.VARCHAR ) ;
					cstmt.registerOutParameter( 28,  Types.VARCHAR ) ;
					cstmt.setString(29, fpp_yn);//IN068314																// REGISTER_ON_ORDER_YN
					cstmt.setString(30, fpp_category);	//IN068314
					cstmt.execute();

					error_message 		= checkForNull(cstmt.getString(27),"");								// P_ERROR_MESSAGE
					//charge_type_code 	= checkForNull(cstmt.getString(25),"");								// P_charge_type_code
					if(error_message!=null && !error_message.equals(""))
					{
						result 			= false;	 // Any Error is there Come out Immediately
						map.put( "message", "ERROR_IN_UPDATING" ) ;						
						//break;													
					} // End of !err_message
					removeOrderBillDtls(checkForNull((String)hashMap.get("order_id"+i),"")+checkForNull((String)hashMap.get("order_line_num"+i),""));					

				}catch(Exception ex)
				{
					
					ex.printStackTrace();
						result 			= false;	 // Any Error is there Come out Immediately
						map.put( "message", "ERROR_IN_UPDATING" ) ;
						
					
					
				}finally{
					closeStatement( cstmt ) ;
				}
				
								
			}//end of for loop
			


			if(result){
				connection.commit();
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", "RECORD_MODIFIED") ;
				map.put( "flag", "" ) ;
			}
			else
			{
				connection.rollback();
			}
			
			/*
			
			try {
					updt_map1.put( "properties", getProperties() );

					//InitialContext context = new InitialContext() ;
					//Object object = context.lookup( OrRepository.getOrKeyValue("OR_REGISTER_ORDER_JNDI") ) ;
					//home  = (ORRegisterOrderHome) PortableRemoteObject.narrow( object, ORRegisterOrderHome.class ) ;
					
					//remote = home.create() ;
					//map = remote.insert( updt_map1, sqlMap ) ; 

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue(""), OROrderBillingDtlsHome.class, getLocalEJB());
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

					Object argArray[]	= new Object[2];
						argArray[0]		= updt_map1;
						argArray[1]		= sqlMap;
					Class [] paramArray = new Class[2];
						paramArray[0]	= updt_map1.getClass();
						paramArray[1]	= sqlMap.getClass();
					map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
							
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
					argArray	= null;
					paramArray	= null;
					if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
					}
					

			} catch(Exception e) {
				map.put( "message", e.getMessage() ) ;
				e.printStackTrace() ;
			} */
		

		} catch ( Exception e )	{
			
			map.put( "message", e.getMessage() ) ;
			e.printStackTrace() ;
			try {
						connection.rollback();
						
				} catch ( Exception ee ) {
						ee.printStackTrace() ;
				}
				
		} finally {
			try{
				
				closeConnection(connection) ;
				if(hashMap != null)
					hashMap.clear();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
			
		return map;
	}

	 public String getFutureOrderYn(String orderId,String order_line_num, String order_catalog_code) throws Exception {
	 Connection connection 		= null;
	 PreparedStatement pstmt 	= null;
	 ResultSet resultSet 		= null;
	 String FutureOrderYn			= "";
	 try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_FUTURE_ORDER_YN"));
			pstmt.setString(1, orderId); 
			pstmt.setString(2, order_line_num); 
			pstmt.setString(3, order_catalog_code); 
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )    // Only one record for the date
			{
				while(resultSet.next())
				{
					FutureOrderYn = checkForNull(resultSet.getString( "FUTURE_ORDER_CHARGE_LATER_YN" ),"N")  ;
				}
			}
	 	} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
	 	} finally {
			closeResultSet( resultSet);
			closeStatement( pstmt);
			closeConnection(connection);
 		}
 		return FutureOrderYn;
 } // End of getSysdate
	/************************METHOD TO Update****************************/
 public HashMap modify(){
	/*HashMap map = new HashMap(); 	map.put( "result", new Boolean( false ) ) ;
	map.put( "message", "success.." ) ; return map;
	*/
	return null;
 }//end of modify
 /********************* Till Here *****************************/
 /*********************METHOD TO Delete*************************/
 public HashMap delete(){
	/*HashMap map = new HashMap(); 	map.put( "result", new Boolean( false ) ) ;
	map.put( "message", "delete failure.." ); return map;
	*/
	return null;
 }//end of delete
 /********************* Till Here *****************************/
 public ArrayList viewBillMultiCatalogDetails(String patient_id,String encounter_id,String patient_class,String facility_id) throws Exception 
{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList MultibillCatalogInfo		= new ArrayList() ;
		String[]  record			= null;
		if(patient_id==null)patient_id="";
		if(encounter_id==null)encounter_id="";
		if(patient_class==null)patient_class="";
		if(facility_id==null)facility_id="";
		try{

			connection	= getConnection();
			  			
  			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_ORDER_BILL_DETAILS") ) ;
			pstmt.setString(1, patient_id.trim());						 // patient_id
			pstmt.setString(2, encounter_id.trim());						 // encounter_id
			pstmt.setString(3, patient_class.trim());						 // patient_class
			pstmt.setString(4, facility_id.trim());						 // facility_id
			
			resultSet = pstmt.executeQuery() ;
			while ( resultSet!=null && resultSet.next()) {

				record = new String[21];
				record[0] = checkForNull(resultSet.getString( "order_line_num" ),"")  ;
				record[1] = checkForNull(resultSet.getString( "patient_id" ),"")  ;
				record[2] = checkForNull(resultSet.getString( "patient_class" ),"")  ;
				record[3] = checkForNull(resultSet.getString( "encounter_id" ),"")  ;
				record[4] = checkForNull(resultSet.getString( "bill_yn" ),"")  ;
				record[5] = checkForNull(resultSet.getString( "cont_order_ind" ),"")  ;
				record[6] = checkForNull(resultSet.getString( "performing_facility_id" ),"")  ;
				record[7] = checkForNull(resultSet.getString( "order_catalog_code" ),"")  ;
				record[8] = checkForNull(resultSet.getString( "catalog_desc" ),"")  ;
				record[9] = checkForNull(resultSet.getString( "order_qty" ),"")  ;
				record[10] = checkForNull(resultSet.getString( "start_date_time" ),"")  ;
				record[11] = checkForNull(resultSet.getString( "ord_auth_reqd_yn" ),"")  ;
				record[12] = checkForNull(resultSet.getString( "ord_auth_by_pract_id" ),"")  ;
				record[13] = checkForNull(resultSet.getString( "ord_appr_reqd_yn" ),"")  ;
				record[14] = checkForNull(resultSet.getString( "ord_appr_by_user_id" ),"")  ;
				record[15] = checkForNull(resultSet.getString( "ord_consent_reqd_yn" ),"")  ;
				record[16] = checkForNull(resultSet.getString( "ord_consent_by_id" ),"")  ;
				record[17] = checkForNull(resultSet.getString( "result_auth_reqd_yn" ),"")  ;
				record[18] = checkForNull(resultSet.getString( "contr_mod_id" ),"")  ;
				record[19] = checkForNull(resultSet.getString( "order_id" ),"")  ;
				record[20] = checkForNull(resultSet.getString( "ORDER_CATEGORY" ),"")  ;
				
				MultibillCatalogInfo.add(record) ;
			}
			
		}catch ( Exception e )	{
			e.printStackTrace() ;
			
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		} // End of finally
		
 		return MultibillCatalogInfo;
	}
	public String[] getOrderSetDetails(String order_id) throws Exception 
{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String[] record = new String[11] ;//IN)72524
		try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_BILL_DETAILS") ) ;
				pstmt.setString( 1,order_id.trim());
				resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {

				record[0] = resultSet.getString( "order_id" )  ;
				record[1] = resultSet.getString( "order_line_num" )  ;
				record[2] = resultSet.getString( "start_date_time" )  ;
				record[3] = resultSet.getString( "order_catalog_code" )  ;
				record[4] = resultSet.getString( "order_qty" )  ;
				record[5] = resultSet.getString( "bill_yn" )  ;
				record[6] = resultSet.getString( "order_category" )  ;
				record[7] = resultSet.getString( "care_set_catalog_desc" )  ;
				record[8] = resultSet.getString( "charge_yn" )  ;
				record[9] = resultSet.getString( "fpp_yn" )  ;//IN)72524
				record[10] = resultSet.getString( "fpp_category" )  ;//IN)72524
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

	public ArrayList getOrderSetSearchDetails(String orderId) throws Exception 
	{
		
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;
		String order_set_details="";

		try {
				connection = getConnection() ;
				order_set_details=(String)OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_ORDER_SET_SEARCH_DETAILS");
				pstmt = connection.prepareStatement(order_set_details);
                
				pstmt.setString( 1,language_id);
				pstmt.setString( 2,language_id);
				pstmt.setString( 3,language_id);
				pstmt.setString( 4,language_id);
				pstmt.setString( 5,language_id);
				pstmt.setString( 6,orderId.trim() ) ;
			
				resultSet = pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ) 
				{
					String[] record;
					record = new String[6];
					record[0] = resultSet.getString("priority_desc")  ;
					record[1] = resultSet.getString("order_date_time")  ;
					record[2] = resultSet.getString("order_catalog_detail")  ;
					record[3] = resultSet.getString("order_type_short_desc")  ;
					record[4] = resultSet.getString("ordering_pract_name")  ;
					record[5] = resultSet.getString("order_status_short_desc")  ;
					OrderCat.add(record) ;
				}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
		}

		return OrderCat;
	}

	//[IN034785] - Start
	public String getOrderFacility(String order_id, String order_line_num) throws Exception 
{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String ordfacilityid = "";
		try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement("select a.ordering_facility_id from or_order a,or_order_line b where a.order_id=b.order_id and a.order_id =? and b.order_line_num=?");
				pstmt.setString(1, order_id); 
				pstmt.setString(2, order_line_num); 
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					while(resultSet.next())
					{
						ordfacilityid = checkForNull(resultSet.getString( "ordering_facility_id" ),"")  ;
					}
				}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}
		return ordfacilityid;
	}
	//[IN034785] - End

	public ArrayList getBillChargeDetailsfpp(String quantity,String catalog_code,String start_date_time,String language_id,String order_id,String order_line_no,String patient_id, String encounter_id,String patient_class,String practitioner_id,String fpp_yn,String fpp_category) throws Exception {

		Connection connection 											= null;
		CallableStatement cstmt 										= null;
		PreparedStatement pstmt 										= null;
		PreparedStatement pstmt_floor_to_start_day	 					= null;
		PreparedStatement pstmt_mod_physician_id	 					= null;
		ResultSet resultSet 											= null;
		ResultSet resultSet_floor_to_start_day 							= null;
		ResultSet resultSet_mod_physician_id 							= null;
		PreparedStatement pstmt_bl 										= null;//--[IN034785]
		ResultSet rs													= null;//--[IN034785]
		String l_facility_id											= "";//--[IN034785]
		ArrayList BillChargeInfo										= new ArrayList() ;

		String[]  billing_details										= new String[23];
		String round_off_start_date										="N";
		String mod_physician_id											="";
		
		try
		{
		
				connection	= getConnection();
				//--[IN034785] - Start
				if (!order_id.equals("")) 
				{ 
					pstmt_bl = connection.prepareStatement("select a.ordering_facility_id from or_order a,or_order_line b where a.order_id=b.order_id and a.order_id =? and b.order_line_num=?");
					pstmt_bl.setString(1, order_id); 
					pstmt_bl.setString(2, order_line_no); 
					rs	= pstmt_bl.executeQuery() ;
					if ( rs != null )
					{
						while(rs.next())
						{
							l_facility_id = checkForNull(rs.getString( "ordering_facility_id" ),"")  ;
						}
					}
				}
				else 
				{
					l_facility_id = login_facility_id;
				}
				//--[IN034785] - End
				pstmt_mod_physician_id		= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_MOD_PHYSICIAN_ID"));				
				cstmt = connection.prepareCall("{ "+OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_GET_CHARGE_DETAILS")+" }");
				//cstmt.setString(1, login_facility_id);  					 // FACILITY_ID --[IN034785] - commented
				cstmt.setString(1, l_facility_id); //--[IN034785]
				cstmt.setString(2, encounter_id);  			  	   			 // ENCOUNTER_ID
				cstmt.setString(3, patient_class); 							 // PATIENT_CLASS
				cstmt.setString(4, patient_id); 							 // PATIENT_ID
				//---[IN030545]/start---
				//cstmt.setInt(5, Integer.parseInt(checkForNull(quantity,"0"))); 	 // QUANTITY FROM PLACE ORDER SCREEN
				cstmt.setDouble(5, Double.parseDouble(checkForNull(quantity,"0"))); 
				//---[IN030545]/ends---
				cstmt.setString(6, catalog_code); 					 		 // CATALOG_CODE
				cstmt.setString(7, start_date_time); 				 		 // START_DATE_TIME
				cstmt.setString(8, practitioner_id); 						 // PRACTITIONER_ID
				cstmt.setString(9, language_id); 							 // P_LANGUAGE_ID
				cstmt.registerOutParameter( 10,  Types.VARCHAR ) ;			 // P_STR
				cstmt.registerOutParameter( 11,  Types.VARCHAR ) ;			 // P_CHARGE_BASED_YN
				cstmt.registerOutParameter( 12,  Types.NUMERIC ) ;			 // P_TOT_AMT
				cstmt.registerOutParameter( 13,  Types.NUMERIC ) ;			 // P_PAT_PAYABLE_AMT
				cstmt.registerOutParameter( 14,  Types.VARCHAR ) ;			 // P_EXCL_INCL_IND
				cstmt.registerOutParameter( 15,  Types.VARCHAR ) ;			 // P_PREAPP_YN
				cstmt.registerOutParameter( 16,  Types.NUMERIC ) ;			 // P_PAT_PAID_AMT
				cstmt.registerOutParameter( 17,  Types.VARCHAR ) ;			 // P_CHARGED_YN
				cstmt.registerOutParameter( 18,  Types.VARCHAR ) ;			 // P_PAT_BILLED_YN
				cstmt.registerOutParameter( 19,  Types.VARCHAR ) ;			 // ERROR_TEXT
				cstmt.registerOutParameter( 20,  Types.VARCHAR ) ;			 // P_SERV_PANEL_IND
				cstmt.registerOutParameter( 21,  Types.VARCHAR ) ;			 // P_SERV_PANEL_CODE
				cstmt.registerOutParameter( 22,  Types.VARCHAR ) ;			 // P_SERVICE_PANEL_NAME
				cstmt.registerOutParameter( 23,  Types.VARCHAR ) ;			 // P_EPISODE_TYPE
				cstmt.registerOutParameter( 24,  Types.NUMERIC ) ;			 // P_EPISODE_ID
				cstmt.registerOutParameter( 25,  Types.NUMERIC ) ;			 // P_VISIT_ID
				cstmt.setString( 26,  order_id ) ;							 // P_ORDER_ID
				cstmt.setString( 27,  order_line_no ) ;						 // P_ORDER_LINE_NO
				cstmt.setString( 28,  fpp_yn ) ;						 // P_ORDER_LINE_NO
				cstmt.setString( 29,  fpp_category ) ;						 // P_ORDER_LINE_NO
				 

				cstmt.execute();
				billing_details[0]  = checkForNull(cstmt.getString(10),"");
				billing_details[1]  = checkForNull(cstmt.getString(11),"");
				billing_details[2]  = checkForNull(String.valueOf(cstmt.getDouble(12)),"");				
				billing_details[3]  = checkForNull(String.valueOf(cstmt.getDouble(13)),"");				
				billing_details[4]  = checkForNull(cstmt.getString(14),""); 
				billing_details[5]  = checkForNull(cstmt.getString(15),""); 
				billing_details[6]  = checkForNull(String.valueOf(cstmt.getDouble(16)),"");
				billing_details[7]  = checkForNull(cstmt.getString(17),"");
				billing_details[8]  = checkForNull(cstmt.getString(18),"");
				billing_details[9]  = checkForNull(cstmt.getString(19),"");
				billing_details[10] = checkForNull(cstmt.getString(20),"");
				billing_details[11] = checkForNull(cstmt.getString(21),"");
				billing_details[12] = checkForNull(cstmt.getString(22),"");
				billing_details[13] = checkForNull(cstmt.getString(23),"");
				billing_details[14] = checkForNull(cstmt.getString(24),"");
				billing_details[15] = checkForNull(cstmt.getString(25),"");
				billing_details[16]  = checkForNull(cstmt.getString(14),""); // new P_EXCL_INCL_IND
			
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_FUTURE_ORDER_CHARGE_LATER_IND"));
				pstmt.setString(1, "OR");  					 // FACILITY_ID
				pstmt.setString(2, catalog_code);  			  	   			 // ENCOUNTER_ID
				pstmt.setString(3, billing_details[13]); 	
				pstmt.setString(4, catalog_code); 
				pstmt.setString(5, patient_class); 
				
				resultSet	= pstmt.executeQuery() ;
				String futureBillInd ="";
				String Future_date="";
		
				if ( resultSet != null )
				{
					while(resultSet.next())
					{
						
						futureBillInd =checkForNull(resultSet.getString( "Future_Bill_ind" ),"")  ;
				
						if (futureBillInd.equals("NOW"))
						{
							billing_details[17]="N";
						}
						else if (futureBillInd.equals("LATER") )
						{
							billing_details[17]="Y";
						}
						else
							billing_details[17]="";
						Future_date=checkForNull(resultSet.getString( "furure_order_date" ),"")  ;
					    billing_details[18]=Future_date;
					}
				}

				pstmt_floor_to_start_day		= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_FLOOR_TO_START_DAY_YN")); 
				pstmt_floor_to_start_day.setString(1, catalog_code);  			  	   			 // CATALOG_CODE
				pstmt_floor_to_start_day.setString(2, patient_class);                             // PATIENT_CLASS
				resultSet_floor_to_start_day	= pstmt_floor_to_start_day.executeQuery() ;
				

				if (resultSet_floor_to_start_day != null )
				{
					while(resultSet_floor_to_start_day.next())
					{
						round_off_start_date =checkForNull(resultSet_floor_to_start_day.getString( "floor_to_start_day_yn" ),"N")  ;	
					    billing_details[19]=round_off_start_date;
					}
				}
				
				if(!order_id.equalsIgnoreCase(""))
				{
				 
					pstmt_mod_physician_id.setString(1, "OR");  			  	   			   // module_id
					pstmt_mod_physician_id.setString(2, order_id);                             // order_id
					pstmt_mod_physician_id.setString(3, order_line_no);                        // order_line_no
					pstmt_mod_physician_id.setString(4, patient_id);                           // patient_id
					pstmt_mod_physician_id.setString(5, billing_details[13]==null?"":billing_details[13]);// episode_type				
					pstmt_mod_physician_id.setString(6, billing_details[15]==null?"":billing_details[15]);// visit_id
					pstmt_mod_physician_id.setString(7, billing_details[14]==null?"":billing_details[14]);// episode_id
					pstmt_mod_physician_id.setString(8, login_facility_id);// facility_id
					resultSet_mod_physician_id	= pstmt_mod_physician_id.executeQuery() ;
				

					if (resultSet_mod_physician_id != null )
					{
						while(resultSet_mod_physician_id.next())
						{							
							mod_physician_id = checkForNull(resultSet_mod_physician_id.getString( "PHYSICIAN_ID" ),"")  ;			
							billing_details[20] = mod_physician_id;
						}
					}
				}
				else
				{
					billing_details[20] = "";
				}
			
				BillChargeInfo.add(billing_details) ;

		   }
		   catch ( Exception e )	
			{
				e.printStackTrace() ;
			throw e ;
			} 
			finally 
			{
				closeResultSet( resultSet ) ;
				closeResultSet( resultSet_floor_to_start_day ) ;
				closeResultSet( resultSet_mod_physician_id ) ;
				closeResultSet( rs ) ;
				closeStatement( pstmt_bl);
				closeStatement( cstmt);
				closeStatement( pstmt);
				closeStatement( pstmt_floor_to_start_day);
				closeStatement( pstmt_mod_physician_id);
				closeConnection(connection);
			}
			return BillChargeInfo;
	 }

//Added Against ML-MMOH-SCF-2375 by Gaurav...starts
public ArrayList<String> getFPPDetails(String oper_code) //Added Against ML-MMOH-SCF-2008
{
	String SQL = "SELECT NVL (fpp_yn, 'N'), FPP_CATEGORY FROM or_order_catalog WHERE order_catalog_code=?";
	Connection connection  = null;
	PreparedStatement pstmt= null;
	ResultSet rst = null;
	String fpp_yn="";
	String fpp_category="";
	ArrayList fppList = new ArrayList(2);
	try{
		connection	= getConnection();
		pstmt=connection.prepareStatement(SQL);
		pstmt.setString(1,oper_code);
		rst = pstmt.executeQuery();
		while(rst.next()){
			fpp_yn = rst.getString(1);
			fpp_category = rst.getString(2);
		}
		fppList.add(fpp_yn);
		fppList.add(fpp_category);
	}catch ( Exception e ){
		e.printStackTrace();
	}finally {
		try{
			closeStatement( pstmt );
			closeConnection( connection );
			if(rst !=null) rst.close();
		 }catch(Exception es){
			 es.printStackTrace();
		}
	}

	return fppList;
}
//Added Against ML-MMOH-SCF-2375 by Gaurav...ends	 

}//end of class
