/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
-------------------------------------------------------------------------------------------------------
?             100            ?               created
28/10/2011    IN029395      Chowminya G      Incident No: IN029395 - <system default preferred surgery date issue> 
27/11/2011    IN029297      Chowminya G      OR Code Setup > OR Other Master Setup > Orders Tab
12/03/2013    IN029601      Chowminya G      Display Pregnancy details on place order - PH screen
07/06/2013    IN040516      Chowminya G      CRF-PH- RUT-CRF-0063/03 Actual Delivery Date
10/06/2013    IN040683      Chowminya G      PH- RUT-CRF-0063/05 No Pregnant Legend
18/06/2013    IN040685      Chowminya G      Display Pregnancy details on place order - PH screen Modification
13/08/2013	  IN042045		Chowminya G	     System should not allow to copy for the drugs for which Verbal Order Applicable is not selected
19/09/2013	  IN043095		Nijitha S		 Booking Priority field in not displayed for "System defined" order entry format item
11/02/2014	  IN045798		Chowminya		 The Original alignment of the Order format Items are getting changed in the Order format screen
--------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
21/02/2014    IN000000     Chowminya      Akbar			21/02/2014			Clinical event item link with order format not working for LB n RD(results)	 
18/03/2014	  IN047739     Chowminya							            SS-CRF-20038 - incorrect data while amending an RD Order 	
05/06/2014    IN049124 	   Chowminya										PH-Orderformat - Drug remarks
02/07/2014	  IN049133	   Chowminya										CRF:Disallow user to enter the future date in the LMP date field
19/08/2014    IN050610     Chowminya										CRF Link 2:dependency date validation differed in Order format 
28/05/2016	  IN051135		Karthi L		 									MO-CRF-20085 [IN051135] -IN060460
04/08/2016	IN061154		Karthi L											Duplicate exams in Group order
21/03/2017	  IN063310	   Raja S		25/03/2017		Ramesh G			GHL-CRF-0448
06/06/2017	  IN064491	   Raja S		06/06/2017		Ramesh G			CRF-OR-GHL-CRF-0448/02-System does not display '0' before decimal value in case if Lab results are done
07/07/2017	  IN064688	   Raja S		08/07/2017		RameshG				ML-MMOH-SCF-0753
12/02/2018	  IN066055	   Raja S		12/02/2018		Ramesh 				ML-MMOH-CRF-0891.2
07/06/2020	  IN072524	   Nijitha S     		07/06/2020		Ramesh G		ML-MMOH-CRF-1229.2
09/10/2023     51003           Krishna Pranay    10/10/2023       Ramesh Goli        COMMON-ICN-0178

-------------------------------------------------------------------------------------------------------
*/ 
package eOR;

import java.io.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.math.*;//IN064688 added

import eOR.Common.*;

//public class  OrderEntryQueryBean extends OrderEntryBean implements Serializable
public class  OrderEntryQueryBean extends OrAdapter implements Serializable
{
 public OrderEntryQueryBean(){
//  try{
    //doCommon();
 // }catch(Exception e) {}
		
 }

/************************METHOD TO Update****************************/
/* public HashMap modify(){
	HashMap map = new HashMap();
	map.put( "result", new Boolean( false ) ) ;
	map.put( "message", "success.." ) ;
	return map;
 }//end of modify
 */
 /********************* Till Here *****************************/
 /*********************METHOD TO Delete*************************/
/* public HashMap delete(){
	HashMap map = new HashMap();
	map.put( "result", new Boolean( false ) ) ;
	map.put( "message", "delete failure.." );
	return map;
 }//end of delete
*/
 /********************* Till Here *****************************/
// private void doCommon() throws Exception {
// }
// public void loadData() throws Exception {
// }

 // Get the values for the PreSelect
// public String getPreselSelectValues (Connection connection) throws Exception {
	 public String getPreselSelectValues (Properties properties) throws Exception {
 		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
 		ResultSet resultSet 		= null;
 		try
 		{
			//connection	= getConnection();
 			connection		= ConnectionManager.getConnection(properties) ;
 			pstmt			= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PRESEL_SELECT") ) ;
  			resultSet		= pstmt.executeQuery() ;
 			StringBuffer sb	= new StringBuffer();
 			if(resultSet!=null) // Only One Record
			{
 				while (resultSet.next() ) {
  					sb.append(checkForNull( resultSet.getString( "presel_order_category_yn" ), "N" ) + "~~" + checkForNull( resultSet.getString( "presel_order_type_code_yn" ), "N" ) + "~~"+ checkForNull( resultSet.getString( "order_privilege_level" ), "X" ) +"~~"+ checkForNull( resultSet.getString( "pin_ident_by_category_yn" ), "N" )+"~~");
				}
			}
			 String str =   sb.toString() ;
 			 sb.setLength(0);  // Clearing the string buffer
			 if(str.length() > 0)
				return str.substring(0, str.length()-1);
			 else // If no records founds
			  return "N"+"~~"+"N"+"~~"+"X"+"~~"+"N";
 		 }catch ( Exception e ){
 			e.printStackTrace() ;
 			return null;
 		 } finally {
  			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
 		}
	} // end of the getPreselSelectValues

public String getAttendPractitioner (Properties properties, String facility_id,String encounter_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		try{
			//connection	= getConnection();
			connection	= ConnectionManager.getConnection(properties) ;
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_ATTEND_PRACT") ) ;
			pstmt.setString(1, language_id);
			pstmt.setString(2, checkForNull( facility_id,""));
			pstmt.setString(3, checkForNull( encounter_id,""));
			resultSet	= pstmt.executeQuery() ;

			StringBuffer sb	= new StringBuffer();
			if ( resultSet != null )   // Only One Record
			{
				while(resultSet.next())
				{
					sb.append(checkForNull( resultSet.getString( "attend_practitioner_id" ), "N" ) + "~~" + checkForNull( resultSet.getString( "practitioner_name" ), "N" ) + "~~");
				}
			}
			String str	= sb.toString() ;
			sb.setLength(0);  // Clearing the string buffer
			if(str.length() > 0)
				return str.substring(0, str.length()-1);
			else // If no records founds
				return "N"+"~~"+"N"+"~~";

		}catch ( Exception e )	{
			e.printStackTrace() ;
			return null;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
	}	 // End of the getAttendPractitioner

 	public ArrayList getPREncounterDetails (Properties properties, String facility_id,String encounter_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String[] record				= null;
		ArrayList PREncounterDtls	= new ArrayList();
		try{
			connection			= ConnectionManager.getConnection(properties) ;
			pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_ATTEND_PRACT") ) ;
			pstmt.setString(1, language_id);
			pstmt.setString(2, checkForNull( facility_id,""));
			pstmt.setString(3, checkForNull( encounter_id,""));
			resultSet			= pstmt.executeQuery() ;
			if ( resultSet != null )   // Only One Record
			{
				while(resultSet.next())
				{
					record	= new String[8];
					record[0] = checkForNull( resultSet.getString( "attend_practitioner_id" ), "" );
					record[1] = checkForNull( resultSet.getString( "practitioner_name" ), "" );
					record[2] = checkForNull( resultSet.getString( "discharge_date_time" ), "" );
					record[3] = checkForNull( resultSet.getString( "episode_id" ), "" );
					record[4] = checkForNull( resultSet.getString( "op_episode_visit_num" ), "" );
					record[5] = checkForNull( resultSet.getString( "team_id" ), "" );
					record[6] = checkForNull( resultSet.getString( "service_code" ), "" );
					record[7] = checkForNull( resultSet.getString( "visit_adm_date_time" ), "" );
					
					PREncounterDtls.add(record) ;
				}
			}
		}catch ( Exception e )	{

			e.printStackTrace() ;
			return null;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
		return PREncounterDtls;
	}	 // End of the getPREncounterDetails

	public ArrayList getCPSTDPREncounterDetails (Properties properties, String facility_id,String encounter_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String[] record				= null;
		ArrayList PREncounterDtls	= new ArrayList();
		try{
			connection			= ConnectionManager.getConnection(properties) ;
			pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CP_STANDARD_SELECT") ) ;
			pstmt.setString(1,language_id);
			pstmt.setString(2, checkForNull( facility_id,""));
			pstmt.setString(3, checkForNull( encounter_id,""));
			resultSet			= pstmt.executeQuery() ;
			if ( resultSet != null )   // Only One Record
			{
				while(resultSet.next())
				{
					//record	= new String[14];  //IN036387
					record	= new String[15];		//IN036387
 					record[0] = checkForNull( resultSet.getString( "attend_practitioner_id" ), "" );
					record[1] = checkForNull( resultSet.getString( "practitioner_name" ), "" );
					record[2] = checkForNull( resultSet.getString( "discharge_date_time" ), "" );
					record[3] = checkForNull( resultSet.getString( "episode_id" ), "" );
					record[4] = checkForNull( resultSet.getString( "op_episode_visit_num" ), "" );
					record[5] = checkForNull( resultSet.getString( "team_id" ), "" );
					record[6] = checkForNull( resultSet.getString( "service_code" ), "" );
					record[7] = checkForNull( resultSet.getString( "visit_adm_date" ), "" );//dd/mm/yyy

					record[8] = checkForNull( resultSet.getString( "location_type" ), "" );
					record[9] = checkForNull( resultSet.getString( "location_code" ), "" );
					record[10] = checkForNull( resultSet.getString( "patient_class" ), "" );
					record[11] = checkForNull( resultSet.getString( "sex" ), "" );
					record[12] = checkForNull( resultSet.getString( "date_of_birth" ), "" );
					record[13] = checkForNull( resultSet.getString( "age" ), "" );
					record[14] = checkForNull( resultSet.getString( "visit_adm_date_time" ), "" ); //IN036387
 					PREncounterDtls.add(record) ;
				}
			}
		}catch ( Exception e )	{

			e.printStackTrace() ;
			return null;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
		return PREncounterDtls;
	}	 // End of the getCPSTDPREncounterDetails

	// To populate the Location, when the clinic_type is clinic
	public ArrayList getLocation(Properties properties) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		ArrayList Location = new ArrayList() ;
			try{
					//connection	= getConnection();
					connection	= ConnectionManager.getConnection(properties) ;
					pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_LOCATION_CLINIC") ) ;
					
					pstmt.setString(1,language_id);
					resultSet	= pstmt.executeQuery() ;
					if ( resultSet != null )
					{
						String[] record = null;
						while(resultSet.next())
						{
							record    = new String[3];
							record[0] = resultSet.getString( "code" )  ;
							record[1] = resultSet.getString( "description" )  ;
							record[2] = resultSet.getString( "open_to_all_pract_yn" )  ;
							Location.add(record) ;
						}
				}
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}
			return Location;
	}	 // End of the getLocation

	// To populate the order mode 
	public ArrayList getOrderMode(Properties properties) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		ArrayList OrderMode = new ArrayList() ;
			try{
				connection	= ConnectionManager.getConnection(properties) ;
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_MODE_OF_ORDER") ) ;
				pstmt.setString(1,language_id);
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())
					{
						record    = new String[3];
						record[0] = resultSet.getString( "action_reason_code" )  ;
						record[1] = resultSet.getString( "action_reason_desc" )  ;
						record[2] = resultSet.getString( "action_description" )  ;
						OrderMode.add(record) ;
					}
				}
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}
			return OrderMode;
	}	 // End of the getOrderMode

	// Get the Order_category description, passing the order_category
	public String getOrderCategoryDesc(Properties properties, String order_category) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String order_category_desc  = "";

		try{
				connection	= ConnectionManager.getConnection(properties) ;
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC6") ) ;
				pstmt.setString(1, language_id);
				pstmt.setString(2, order_category);
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					while(resultSet.next())	// Only one record
					{
						order_category_desc = resultSet.getString( "short_desc" )  ;
					}
				}
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}
			return order_category_desc;
	}	 // End of the getOrderCategoryDesc

	// Method to get the Tabs which is dynamically Painted(Addnl.Search,TickSheets, Image,OrderSet,Place Order,..)
	public ArrayList getTabs(Properties properties, String practitioner_id, String patient_class, String function_id, String ph_install_yn) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt1 	= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet1 		= null;
		ResultSet resultSet 		= null;
		ArrayList TabsHdg			= new ArrayList() ;
		String[] record				= null;
		String default_practitioner_id = practitioner_id;
		String default_patient_class = patient_class;
		try{
 				connection			= ConnectionManager.getConnection(properties) ;
			/************default Pactitioner id and patient class(used in case,no matching user_tab_name is found)********************************************/
			try {
				//pstmt1 = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_TABS_KEY"));
				pstmt1 = connection.prepareStatement("SELECT distinct practitioner_id, patient_class FROM  or_users_tab WHERE practitioner_id = OR_USER_TAB_FOR_PRACT_CLASS(?,?,?,?) AND patient_class  = OR_USER_TAB_FOR_PRACT_CLASS(?,?,?,?) AND sys_tab_name in ('existingOrders','newOrders') and (function_id= ? or function_id = '*A')"); //--[IN029297]
				pstmt1.setString(1,checkForNull(practitioner_id,""));
				pstmt1.setString(2,checkForNull(patient_class,""));
				pstmt1.setString(3,"P");//Practitioner
				pstmt1.setString(4,checkForNull(function_id,"ORDERS"));
				pstmt1.setString(5,checkForNull(practitioner_id,""));
				pstmt1.setString(6,checkForNull(patient_class,""));
				pstmt1.setString(7,"C");//Patient Class
				pstmt1.setString(8,checkForNull(function_id,"ORDERS"));
				pstmt1.setString(9,checkForNull(function_id,"ORDERS"));
				resultSet1 = pstmt1.executeQuery();
				if(resultSet1 != null){
					while(resultSet1.next()){
				default_practitioner_id = resultSet1.getString(1);
				default_patient_class = resultSet1.getString(2);
					}
				}
				

			}catch(Exception e){

				e.printStackTrace();
			}

			/********************************************************/


				//pstmt				= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_TABS")); Commentted --[IN029297]
				pstmt				= connection.prepareStatement("SELECT distinct sys_tab_name, user_tab_name, seq_no FROM  or_users_tab_lang_vw WHERE language_id=? and practitioner_id = ? AND patient_class  = ? AND sys_tab_name not in ('existingOrders','newOrders') AND function_id = ? ORDER BY SEQ_NO");//--[IN029297]
				
				pstmt.setString(1, language_id);
				/*pstmt.setString(2, language_id);
				pstmt.setString(3, checkForNull(practitioner_id,""));
				pstmt.setString(4, checkForNull(patient_class,""));
				pstmt.setString(5, "P"); // Practitioner
				pstmt.setString(6, checkForNull(function_id,"ORDERS"));
				pstmt.setString(7, checkForNull(practitioner_id,""));
				pstmt.setString(8, checkForNull(patient_class,""));
				pstmt.setString(9, "C"); // Patient Class
				pstmt.setString(10, checkForNull(function_id,"ORDERS")); // function_id*/
				pstmt.setString(2,checkForNull(default_practitioner_id,""));
				pstmt.setString(3,checkForNull(default_patient_class,""));
				pstmt.setString(4, checkForNull(function_id,"ORDERS")); // function_id
  				resultSet	= pstmt.executeQuery() ;
				//System.out.println("record[0]withoutnull=="+resultSet);
				if ( resultSet != null )
				{
					while(resultSet.next())
					{
						record 	  = new String[2];
						record[0] = checkForNull(resultSet.getString( "sys_tab_name" ),"")  ;
						//System.out.println("record[0]withoutnull=="+record[0]);
						record[1] = checkForNull(resultSet.getString( "user_tab_name" ),"")  ;
						TabsHdg.add(record) ;
					}
					//--[IN029297] this condition is commented as it was displaying default tab names even if the table has data for condition *A
					//if(TabsHdg.size()==1) //If only one record is there that by means only place order is there ,Then check for PH Install, if it is not installed, put the other tabs with default one Commented --[IN029297]
				//	{ 
						if(ph_install_yn.equals("N"))
						{
							//TabsHdg = buildDefaultTabs(properties); //build the default tabs//Commented for IN066055
							TabsHdg = buildDefaultTabs(properties,function_id); //build the default tabs //Modified for IN066055
							if(record != null)//Added for IN066055
							TabsHdg.add(record); // Since it is global it will have the value (One record)
							//Call a function which will build all the other tabs by default
						}
				//	} // End of TabsHdg.size()==1 
				} // else no record found Add it by default(5 tabs will be ther)
				//--[IN029297] - Start --above query will check if function specific names are available, then if not, check if *A condition is defined(Below), if not then display default
				 if (resultSet != null)resultSet.close();//15950
				 if (pstmt != null)pstmt.close();//15950
				if(TabsHdg.size()==0)
				{
					pstmt				= connection.prepareStatement("SELECT distinct sys_tab_name, user_tab_name, seq_no FROM  or_users_tab_lang_vw WHERE language_id=? and practitioner_id = ? AND patient_class  = ? AND sys_tab_name not in ('existingOrders','newOrders') AND function_id = ? ORDER BY SEQ_NO");
					pstmt.setString(1, language_id);
					pstmt.setString(2,checkForNull(default_practitioner_id,""));
					pstmt.setString(3,checkForNull(default_patient_class,""));
					pstmt.setString(4, "*A"); 
					resultSet	= pstmt.executeQuery() ;
					if ( resultSet != null )
					{
						while(resultSet.next())
						{
							record 	  = new String[2];
							record[0] = checkForNull(resultSet.getString( "sys_tab_name" ),"")  ;
							System.out.println("record[0]withoutnull=="+record[0]);
							record[1] = checkForNull(resultSet.getString( "user_tab_name" ),"")  ;
							TabsHdg.add(record) ;
						}
						if(ph_install_yn.equals("N"))
						{
							//TabsHdg = buildDefaultTabs(properties); //Commented for IN066055
							TabsHdg = buildDefaultTabs(properties,function_id); //Modified for IN066055
							TabsHdg.add(record); 		
						}
					}
				}
				//--[IN029297] - End
				if(resultSet==null || TabsHdg.size()==0)
				{
					String locale = properties.getProperty("LOCALE");
					locale = (locale == null || locale.equals(""))?"en":locale;

					java.util.Locale loc = new java.util.Locale(locale);
					java.util.ResourceBundle or_labels = java.util.ResourceBundle.getBundle( "eOR.resources.Labels",loc);

					//TabsHdg = buildDefaultTabs(properties); // call the function to build the default tabs//Commented for IN066055
					TabsHdg = buildDefaultTabs(properties,function_id); // call the function to build the default tabs//Modified for IN066055
					// Add the tab for Place Order
					record 	  = new String[2];
					record[0] = "placeOrder";		// System_defined Name
					//record[1] = "Place Order";		//User Defined Name
					record[1] = checkForNull(or_labels.getString("eOR.PlaceOrder.label"),"Place Order");		//User Defined Name
					TabsHdg.add(record);
				}
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet1 ) ;
				closeResultSet( resultSet ) ;
				closeStatement( pstmt1 ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}
			return TabsHdg;
 } // End of getTabs

// private ArrayList buildDefaultTabs(Properties properties) throws Exception {//Commented for IN066055
 private ArrayList buildDefaultTabs(Properties properties,String function_id) throws Exception {//Modified for IN066055
	String[] record				= null;
	ArrayList TabsHdg			= new ArrayList();
	String locale = properties.getProperty("LOCALE");
	locale = (locale == null || locale.equals(""))?"en":locale;

	java.util.Locale loc = new java.util.Locale(locale);
	java.util.ResourceBundle or_labels = java.util.ResourceBundle.getBundle( "eOR.resources.Labels",loc);
		// Add the tab for Frequent Orders
		record 	  = new String[2];
		record[0] = "frequentOrders";		// System_defined Name
		//record[1] = "Frequent Orders";		// User Defined Name
		record[1] = checkForNull(or_labels.getString("eOR.FrequentOrders.label"),"Frequent Orders");		// User Defined Name
		TabsHdg.add(record);
/*		// Add the tab for Drawing Tools
		record 	  = new String[2];
		record[0] = "drawingTools";		// System_defined Name
		record[1] = "Drawing Tools";		// User Defined Name
		TabsHdg.add(record);
*/
		// Add the tab for Additional search
		record 	  = new String[2];
		record[0] = "additionalSearch";		// System_defined Name
		//record[1] = "Addl. Search";			// User Defined Name
		record[1] =checkForNull(or_labels.getString("eOR.AddlSearch.label"),"Addl. Search");			// User Defined Name
		TabsHdg.add(record);
		// Add the tab for TickSheets
		record 	  = new String[2];
		record[0] = "tickSheet";			// System_defined Name
		//record[1] = "Tick Sheet";			// User Defined Name
		record[1] = checkForNull(or_labels.getString("eOR.TickSheet.label"),"Tick Sheet");			// User Defined Name
		TabsHdg.add(record);
		// Add the tab for Image
		record 	  = new String[2];
		record[0] = "image";				// System_defined Name
		//record[1] = "Image";				// User Defined Name
		record[1] = checkForNull(or_labels.getString("eOR.Image.label"),"Image");					// User Defined Name
		TabsHdg.add(record);
		// Add the tab for Image
		record 	  = new String[2];
		record[0] = "careSet";				// System_defined Name
		//record[1] = "Order Set";			//User Defined Name
		record[1] = checkForNull(or_labels.getString("eOR.OrderSet.label"),"Order Set");		//User Defined Name
		TabsHdg.add(record);
		//IN066055 starts
		setSiteSpecific("EXTERNAL_PH");//IN066055
		boolean isExternalPHEnabled = isSiteSpecific("EXTERNAL_PH");
		if(isExternalPHEnabled && (function_id.equals("PH")||function_id.equals("OP"))){
			// Add the tab for Place Order
			record 	  = new String[2];
			record[0] = "placeOrder";				// System_defined Name
			record[1] = checkForNull(or_labels.getString("eOR.PlaceOrder.label"),"Place Order");		//User Defined Name
			TabsHdg.add(record);
		}
		//IN066055 ends
	return TabsHdg;
 } // End of buildDefaultTabs

// Method to get the Main tabs which is dynamically painted (Existing Order / New Order)
public ArrayList getMainTabs(Properties properties, String practitioner_id, String patient_class, String function_id) throws Exception {
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	PreparedStatement pstmt1 	= null;
	ResultSet resultSet 		= null;
	ResultSet resultSet1 		= null;
	ArrayList MainTabsHdg		= new ArrayList() ;
	String[] record				= null;
	String default_practitioner_id		= practitioner_id;
	String default_patient_class	= patient_class;
	try{
			connection			= ConnectionManager.getConnection(properties) ;
			/************default Pactitioner id and patient class(used in case,no matching user_tab_name is found)********************************************/
			
			try
			{
				//pstmt1 =connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_TABS_KEY"));
				pstmt1 = connection.prepareStatement("SELECT distinct practitioner_id, patient_class FROM  or_users_tab WHERE practitioner_id = OR_USER_TAB_FOR_PRACT_CLASS(?,?,?,?) AND patient_class  = OR_USER_TAB_FOR_PRACT_CLASS(?,?,?,?) AND sys_tab_name in ('existingOrders','newOrders') and (function_id= ? or function_id = '*A')"); //--[IN029297]
				pstmt1.setString(1,checkForNull(practitioner_id,""));
				pstmt1.setString(2,checkForNull(patient_class,""));
				pstmt1.setString(3,"P");//Practitioner
				pstmt1.setString(4,checkForNull(function_id,"ORDERS"));
				pstmt1.setString(5,checkForNull(practitioner_id,""));
				pstmt1.setString(6,checkForNull(patient_class,""));
				pstmt1.setString(7,"C");//Patient Class
				pstmt1.setString(8,checkForNull(function_id,"ORDERS"));
				pstmt1.setString(9,checkForNull(function_id,"ORDERS"));
				resultSet1 = pstmt1.executeQuery();
				if(resultSet1 != null)
				{
					while(resultSet1.next())
					{
					default_practitioner_id = resultSet1.getString(1);
					default_patient_class = resultSet1.getString(2);
					}
				}
			}catch(Exception e){

			e.printStackTrace();}

			/********************************************************/
			//pstmt				= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_MAIN_TABS"));//Commentted --[IN029297]
			pstmt				= connection.prepareStatement("SELECT distinct sys_tab_name, user_tab_name, seq_no FROM  or_users_tab_lang_vw WHERE language_id=? and practitioner_id = ? AND patient_class  = ? AND sys_tab_name in ('existingOrders','newOrders') and function_id = ? ORDER BY seq_no"); //--[IN029297]
			pstmt.setString(1, language_id);
			/*pstmt.setString(2, checkForNull(practitioner_id,""));
			pstmt.setString(3, checkForNull(practitioner_id,""));
			pstmt.setString(4, checkForNull(patient_class,""));
			pstmt.setString(5, "P"); // Practitioner
			pstmt.setString(6, checkForNull(function_id,"ORDERS"));
			pstmt.setString(7, checkForNull(practitioner_id,""));
			pstmt.setString(8, checkForNull(patient_class,""));
			pstmt.setString(9, "C"); // Patient Class
			pstmt.setString(10, checkForNull(function_id,"ORDERS"));  // function_id*/
			pstmt.setString(2,checkForNull(default_practitioner_id,""));
			pstmt.setString(3,checkForNull(default_patient_class,""));
			pstmt.setString(4, checkForNull(function_id,"ORDERS")); // function_id
  			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )
			{
				while(resultSet.next())
				{
					record 	  = new String[2];
					record[0] = checkForNull(resultSet.getString( "sys_tab_name" ),"")  ;
					record[1] = checkForNull(resultSet.getString( "user_tab_name" ),"")  ;
					MainTabsHdg.add(record) ;
				}
			} // else no record found Add it by default(2 tabs will be Existing Order/New Order)
			
			 if (resultSet != null)resultSet.close();//15950
			 if (pstmt != null)pstmt.close();//15950
			//--[IN029297] - Start
			if(MainTabsHdg.size()==0)
			{
				pstmt				= connection.prepareStatement("SELECT distinct sys_tab_name, user_tab_name, seq_no FROM  or_users_tab_lang_vw WHERE language_id=? and practitioner_id = ? AND patient_class  = ? AND sys_tab_name in ('existingOrders','newOrders') and function_id = ? ORDER BY seq_no"); 
				pstmt.setString(1, language_id);
				pstmt.setString(2,checkForNull(default_practitioner_id,""));
				pstmt.setString(3,checkForNull(default_patient_class,""));
				pstmt.setString(4, "*A"); 
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					while(resultSet.next())
					{
						record 	  = new String[2];
						record[0] = checkForNull(resultSet.getString( "sys_tab_name" ),"")  ;
						record[1] = checkForNull(resultSet.getString( "user_tab_name" ),"")  ;
						MainTabsHdg.add(record) ;
					}
				} 
			}
			//--[IN029297] - End
			if(resultSet==null || MainTabsHdg.size()==0)
			{
				// Add the tab for Place Order
				String locale = properties.getProperty("LOCALE");
				locale = (locale == null || locale.equals(""))?"en":locale;

				java.util.Locale loc = new java.util.Locale(locale);
				java.util.ResourceBundle or_labels = java.util.ResourceBundle.getBundle( "eOR.resources.Labels",loc);
				record 	  = new String[2];
				record[0] = "existingOrders";	// System_defined Name
				//record[1] = "Existing Orders";	//User Defined Name
				record[1] = checkForNull(or_labels.getString("eOR.ExistingOrders.label"),"Existing Orders");	//User Defined Name
				MainTabsHdg.add(record);
				record 	  = new String[2];
				record[0] = "newOrders";		// System_defined Name
				//record[1] = "New Orders";		// User Defined Name
				record[1] = checkForNull(or_labels.getString("eOR.NewOrders.label"),"New Orders");	//User Defined Name
				MainTabsHdg.add(record);
			}
		}catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet1 ) ;
			closeResultSet( resultSet ) ;
			closeStatement( pstmt1 ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
		return MainTabsHdg;
 } // End of getMainTabs
 
// Get the Header format_id and format_id_mandatory_yn
 public ArrayList getFormatID_YN(String format_id_val) throws Exception {
	 String[] record				= null;
	 String format_id_mandatory_yn	= "N";
	 String format_id				= "";
     ArrayList FormatIdVal			= new ArrayList();
	try{
			 // Get the Format Id Logic
			format_id = checkForNull(format_id_val,""); 
			if(!format_id.trim().equals("") )
			{
				StringTokenizer stFormat = new StringTokenizer(format_id,"~");
				while(stFormat.hasMoreTokens())
				{
					format_id_mandatory_yn	 	= stFormat.nextToken();
					format_id 	 	 			= stFormat.nextToken();
				}
				stFormat = null;
			} // End of format_id
			
	   }catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;  
		} finally {
			record 	  = new String[2];
			record[0] = format_id_mandatory_yn;			// format_id_mandatory_yn
			record[1] = format_id;						// format_id
			FormatIdVal.add(record);
		}
	return FormatIdVal;
 } // End of getFormatID_YN

// To populate the order mode 
	public ArrayList getAgeSexDtls(Properties properties, String patient_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		ArrayList PatientDetails    = new ArrayList() ;
		try{
				connection			= ConnectionManager.getConnection(properties) ;
				pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PATIENT_AGE_SEX_DTLS") ) ;
				pstmt.setString(1, patient_id);
				resultSet			= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())
					{
						record    = new String[3];
						record[0] = resultSet.getString( "sex" )  ;
						record[1] = resultSet.getString( "date_of_birth" )  ;
						record[2] = resultSet.getString( "age")  ;
						PatientDetails.add(record) ;
					}
				}
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}
			return PatientDetails;
	}	 // End of the getAgeSexDtls

	// To populate the Order Category
	public ArrayList getOrderCategory(Properties properties) throws Exception {
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;

	ArrayList OrderCategory = new ArrayList() ;
	try{
			connection	= ConnectionManager.getConnection(properties) ;
			
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST") ) ;
			pstmt.setString(1,language_id);
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )
			{
				String[] record	= null;
				while(resultSet.next())
				{
					record 	  = new String[2];
					record[0] = resultSet.getString( "order_category" )  ;
					record[1] = resultSet.getString( "short_desc" )  ;
					OrderCategory.add(record) ;
				}
			}
		}catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
		return OrderCategory;
	}	 // End of the getOrderCategory

public String [] getPractitionerDetails(Properties properties, String login_user) throws Exception {
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	String [] practitioner_details	= new String[2];
	try{
			connection	= ConnectionManager.getConnection(properties) ;
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PRACTITIONER_DETAILS"));
			pstmt.setString(1,checkForNull(language_id));
			pstmt.setString(2,checkForNull(login_user));
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )    // Only one record for the module_id
			{
				while(resultSet.next())
				{
					practitioner_details[0] = resultSet.getString(1);
					practitioner_details[1] = resultSet.getString(1);
					if (practitioner_details[0] == null) practitioner_details[0] = "";
					if (practitioner_details[1] == null) practitioner_details[1] = "";
                }
			}	// if there is no record, then also it should return as 'N'
		}catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
		return practitioner_details;
} // End of getPractitionerDetails

// Get the Specialty Code passing facility_id and encounter_id
public String getSpecialtyCode(Properties properties, String facility_id, String encounter_id) throws Exception {
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	String specialty_code	    = "";

	try{
			connection	= ConnectionManager.getConnection(properties) ;
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_SPECIALTY_SELECT") ) ;
			pstmt.setString(1, facility_id);
			pstmt.setString(2, encounter_id);
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )
			{
				while(resultSet.next())	// Only one record
				{
					specialty_code = resultSet.getString( "specialty_code" )  ;
				}
			}
		}catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
		return specialty_code;
	}	 // End of the getSpecialtyCode

	// To populate the Drug Details for the Phamarcy in the Order Set
	public ArrayList getDrugDetails(Properties properties, String catalog_code) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		ArrayList DrugDetails		 = new ArrayList() ;
		try{
				connection			= ConnectionManager.getConnection(properties) ;
 				pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PH_DRUG_DTLS") ) ;
 				pstmt.setString(1, catalog_code);
				resultSet			= pstmt.executeQuery() ;
	 
 					if ( resultSet != null )
					{
 						String[] record = null;
 						while (resultSet.next() ) 
						{
 							record		= new String[22];
							record[0]	= checkForNull(resultSet.getString( "generic_id" ),"")  ;
							record[1]	= checkForNull(resultSet.getString( "generic_name" ),"")  ;
							record[2]	= checkForNull(resultSet.getString( "form_code"),"")  ;
 							record[3]	= checkForNull(resultSet.getString( "form_desc") ,"")  ;
							record[4]   = checkForNull(resultSet.getString( "route_code"),"")  ;
							record[5]	= checkForNull(resultSet.getString( "route_desc") ,"")  ;
							record[6]	= checkForNull(resultSet.getString( "strength_value" ),"")  ;
							record[7]	= checkForNull(resultSet.getString( "strength_uom"),"")  ;
							record[8]	= checkForNull(resultSet.getString( "pres_base_uom"),"")  ;
							record[9]	= checkForNull(resultSet.getString( "pres_base_uom_desc") ,"")  ;
							record[10]	= checkForNull(resultSet.getString( "strength_uom_desc") ,"")  ;
							record[11]	= checkForNull(resultSet.getString( "calc_dosg_by_freq_durn_yn") ,"")  ;
							record[12]	= checkForNull(resultSet.getString( "disp_alt_form_yn"),"")  ;
							record[13]	= checkForNull(resultSet.getString( "drug_class" ),"")  ;
							record[14]	= checkForNull(resultSet.getString( "strength_per_pres_uom") ,"")  ;
							record[15]	= checkForNull(resultSet.getString( "strength_per_value_pres_uom") ,"")  ;
							record[16]	= checkForNull(resultSet.getString( "trade_name") ,"")  ;
							record[17]	= checkForNull(resultSet.getString( "in_formulary_yn"),"")  ;
							record[18]	= checkForNull(resultSet.getString( "fract_dose_round_up_yn"),"")  ;
							record[19]	= checkForNull(resultSet.getString( "content_in_pres_base_uom"),"")  ;
							record[20]	= checkForNull(resultSet.getString( "prn_doses_pres_prd_fill"),"")  ;
							record[21]	= checkForNull(resultSet.getString( "stock_uom"),"")  ;
							DrugDetails.add(record) ;
						}
					} 
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}
			return DrugDetails;
	}	 // End of the getDrugDetails

	// To populate the Drug Details for the Phamarcy in the Order Set
	public ArrayList getRouteDetails(Properties properties, String form_code) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		ArrayList RouteDetails    = new ArrayList() ;
		try{
				connection	= ConnectionManager.getConnection(properties) ;
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PH_ROUTE_DTLS") ) ;
				pstmt.setString(1, form_code);
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())
					{
						record    = new String[2];
						record[0] = checkForNull(resultSet.getString( "route_code" ),"")  ;
						record[1] = checkForNull(resultSet.getString( "route_desc" ),"")  ;
						 
						RouteDetails.add(record) ;
					}
				}
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}
			return RouteDetails;
	}	 // End of the getRouteDetails

	// To populate the Drug Details for the Phamarcy in the Order Set
	public String[] getDosage(String strength_value, String calc_dosg_by_freq_durn_yn) throws Exception {
	String [] dosageDetails	= new String[5];
	String dosage_type		= "", ori_dosage_type	= "";
	String dosage_legend	= "", dosage_option		= "", dosage = "";

		if(strength_value==null || strength_value.equals("") || strength_value.equals("0")){
			ori_dosage_type = "Q";
		}else{
			ori_dosage_type = "S";
		}
						
 		if( calc_dosg_by_freq_durn_yn.equals("") ||  calc_dosg_by_freq_durn_yn.equals("N")){
			dosage_type="A"; ori_dosage_type = "A";
		}else {
			if(strength_value.equals("0")) {
				dosage_type="Q";ori_dosage_type = "Q";	
			} else {
				dosage_type="S";ori_dosage_type = "S";
			}
		} // End of else 
		
		// Legend and dosage unit is controlled based on dosage type
		if(dosage_type.equals("A")){
			dosage_legend	= "Quantity";
			dosage_option	= "<option value='A' selected>Absolute</option>";
			dosage			= "";	
		}else if(dosage_type.equals("S")){
			dosage_legend	= "Strength";
			dosage_option	= "<option value='S' selected>Strength</option><option value='Q'>Quantity</option>";
			dosage			= strength_value;
		}else if(dosage_type.equals("Q")){
			dosage_legend	= "Dose";
			dosage			= "1"; // For quantity 
			if(ori_dosage_type.equals("S")){
				dosage_option	=	"<option value='S'>Strength</option><option value='Q' selected>Quantity</option>";
			}else{
				dosage_option	=	"<option value='Q' selected>Quantity</option>";
			}		
		} // End of dosage_type="Q"
		dosageDetails[0]	=  dosage_type;
		dosageDetails[1]	=  ori_dosage_type;
		dosageDetails[2]	=  dosage_legend;
		dosageDetails[3]	=  dosage_option;
		dosageDetails[4]	=  dosage;

		return dosageDetails;
	} // End of getDosage

// To populate the UOM Details for the Phamarcy in the Order Set
	public ArrayList getUOMDetails(Properties properties, String form_code) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		ArrayList UOMDetails    = new ArrayList() ;
		try{
				connection	= ConnectionManager.getConnection(properties) ;
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_UOM_DTLS") ) ;
				pstmt.setString(1, form_code);
 				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())
					{
						record    = new String[2];
						record[0] = checkForNull(resultSet.getString( "uom_code" ),"")  ;
						record[1] = checkForNull(resultSet.getString( "short_desc" ),"")  ;
						UOMDetails.add(record) ;
					}
				}
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}
			return UOMDetails;
	}	 // End of the getUOMDetails

	
 // To make the clinical comments mandatorily or not
 public String getClinicalCmtsYn(Properties properties, String order_category) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		String clinical_cmts_yn		= "N";
		try{
				connection		= ConnectionManager.getConnection(properties) ;
				pstmt			= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_ORDER_CLINICAL_CMTS_DTLS") ) ;
				pstmt.setString(1, order_category);
 				resultSet		= pstmt.executeQuery() ;
				if ( resultSet != null )    // Only one record
				{
 					while(resultSet.next())
					{
						clinical_cmts_yn = checkForNull(resultSet.getString( "clin_cmts_reqd_yn" ),"N")  ;
 					}
				}
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}
			return clinical_cmts_yn;
	}	 // End of the getClinicalCmtsYn


	public String getClinicalEvents(Properties properties, String event_code, String patient_id) {
	    Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String clinical_events		= "";
		try{
			  connection		= ConnectionManager.getConnection(properties) ;
			  //pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_SELECT_CLINICAL_EVENTS"));
			  //pstmt				= connection.prepareStatement("select  result_num  || '  ' || RESULT_NUM_UOM  ||  '<br>' || Result_Str || '<br>' || 'As on ' || to_char(EVENT_DATE,'dd/mm/yyyy hh24:mi')  event_result  , to_char(EVENT_DATE,'dd/mm/yyyy hh24:mi') event_date from cr_Encounter_detail A where patient_id = ? and event_code = ? and event_date in (select max(event_date) from cr_encounter_detail where patient_id = ? and event_code = ? )");//IN063310 //IN064491 commented for both
			  //pstmt				= connection.prepareStatement("select DECODE (NVL (RESULT_NUM_DEC, '0'),'0', TO_CHAR (RESULT_NUM),TO_CHAR (RESULT_NUM, DECODE (RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000',8,'99999999990.90000000',9,'99999999990.90000000')))|| '  ' || RESULT_NUM_UOM  ||  '<br>' || Result_Str || '<br>' || 'As on ' || to_char(EVENT_DATE,'dd/mm/yyyy hh24:mi')  event_result  , to_char(EVENT_DATE,'dd/mm/yyyy hh24:mi') event_date from cr_Encounter_detail A where patient_id = ? and event_code = ? and event_date in (select max(event_date) from cr_encounter_detail where patient_id = ? and event_code = ? )");//IN063310 //IN064491 Modified for both //commented for IN064688
			  pstmt				= connection.prepareStatement("select  result_num, RESULT_NUM_UOM  ||  '<br>' || Result_Str || '<br>' || 'As on ' || to_char(EVENT_DATE,'dd/mm/yyyy hh24:mi')  event_result  , to_char(EVENT_DATE,'dd/mm/yyyy hh24:mi') event_date from cr_Encounter_detail A where patient_id = ? and event_code = ? and event_date in (select max(event_date) from cr_encounter_detail where patient_id = ? and event_code = ? )");//Modfied for IN064688
			  pstmt.setString(1, patient_id);
			  pstmt.setString(2, checkForNull(event_code.trim(),""));
			  pstmt.setString(3, patient_id);
			  pstmt.setString(4, checkForNull(event_code.trim(),""));

			  resultSet	= pstmt.executeQuery() ;
			  //IN064688 Changed starts
			  /*
			  while(resultSet.next()) {
				clinical_events = resultSet.getString(1);
			  }
			   */
			  while(resultSet.next()) {
				String resultNum ="";
				BigDecimal rn =resultSet.getBigDecimal("result_num");
				if(rn!=null)
					resultNum=rn.toString();
				else
					resultNum="";
				clinical_events = resultNum+" "+resultSet.getString("event_result");
			  }
			  //IN064688 Changes ends
        }catch ( Exception e )	{

			e.printStackTrace() ;
			//throw e ;
		} finally {
		  try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		  } catch(Exception ex) {
			  ex.printStackTrace();
		  }
		}
		return clinical_events;
	} // End of getClinicalEvents

	// Used to build as HashTable with the values, and properties is used to pass to the getClinicalEvents() to get the connection.
	public Hashtable buildHashTable(Properties properties, int new_seq_num, String patient_id, String amend_order_id, String format_id, String order_type_code, String order_type_short_desc, String field_mnemonic, String[] records) throws Exception {
 	 	Hashtable template			= null;
		String clinical_events		= ""; int max_seq_num = 0;
		try{
  			  template				= new java.util.Hashtable();
			  template.put("field_mnemonic", checkForNull(records[0],""));
			  template.put("seq_num", checkForNull(records[1],"0"));
			  template.put("new_seq_num", new Integer(new_seq_num));
			  template.put("label_text", checkForNull(records[2],""));
			  template.put("accept_option", checkForNull(records[3],""));
			  template.put("field_type",checkForNull(records[5],""));
			  template.put("min_num_value",checkForNull(records[6],""));
			  template.put("max_num_value",checkForNull(records[7],""));
			  template.put("order_type_code",order_type_code);
			  template.put("order_type_short_desc",order_type_short_desc);
			  template.put("help_text",checkForNull(records[9],""));
			  template.put("discr_msr_id",checkForNull(records[10],""));
			  template.put("dependency_yn",checkForNull(records[11],"N"));
			  template.put("single_or_multi",checkForNull(records[12],""));
			  template.put("discr_msr_uom",checkForNull(records[13],""));
 			  template.put("parent_field_mnemonic", field_mnemonic); // willbe used to take it in the bean
			  if ((checkForNull(records[5],"")).equals("V")) {
				  clinical_events = getClinicalEvents(properties, checkForNull(records[10],""), patient_id);
				/*  if (clinical_events.length() > 50)
					clinical_events = clinical_events.substring(0,50);*///Commented for IN000000
				  template.put("dflt_value",checkForNull(clinical_events,""));
			  } else {
				  template.put("dflt_value",checkForNull(records[4],""));
			  }
			  if(!amend_order_id.equals(""))
			  {
			   	   template.put("field_values"	,checkForNull(records[8],""));
			  }
			  if(checkForNull(records[11],"N").equals("Y")) {
			    max_seq_num = getSeqNo(properties, format_id ,(Integer.parseInt(checkForNull(records[1],"0"))), checkForNull(records[0],"N")); 
				template.put("max_dependency_row", String.valueOf(max_seq_num)); 
			  } // End of dependency_yn
			  else 
			  {
				  template.put("max_dependency_row", "0"); 
			  }
			  template.put("field_mnemonic_action"	,""); //Will store it later 
			  template.put("field_action_msg"	,"");//Will store it later 
			  template.put("notify_yn"	,"N");//Will store it later, if dependency has the notification 
			  template.put("oth_dependency_yn","N");//IN050610
			  
 			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			}  
			return template;
	} // End of buildHashTable

	// For MultiSelect, If any field Mnemonic is MultiSelect and list item, internally
	// the system will expand itself with the list box values and the seq_num will be increased
 	public Hashtable buildMultiHashTable(int new_seq_num,String new_value, String new_description, String multi_last_record, Hashtable old_template) throws Exception {

		Hashtable template			= null;
 		try{
   			  template				= new java.util.Hashtable();
			  template.put("field_mnemonic", checkForNull((String)old_template.get("field_mnemonic"),""));
			  template.put("seq_num", checkForNull((String)old_template.get("seq_num"),"0"));
			  template.put("new_seq_num", new Integer(new_seq_num));
			  template.put("label_text", checkForNull(new_description,""));
			  template.put("accept_option", checkForNull((String)old_template.get("accept_option"),""));
			  template.put("field_type", "C");   // Make this as checkbox
			  template.put("min_num_value", checkForNull((String)old_template.get("min_num_value"),""));
			  template.put("max_num_value", checkForNull((String)old_template.get("max_num_value"),""));
			  template.put("order_type_code", checkForNull((String)old_template.get("order_type_code"),""));
			  template.put("order_type_short_desc", checkForNull((String)old_template.get("order_type_short_desc"),""));
			  template.put("help_text", checkForNull((String)old_template.get("help_text"),""));
			  template.put("discr_msr_id", checkForNull((String)old_template.get("discr_msr_id"),""));
			  template.put("dependency_yn", checkForNull((String)old_template.get("dependency_yn"),""));
			  template.put("single_or_multi", "M");  // Directly we can give as single
 			  template.put("parent_field_mnemonic", checkForNull((String)old_template.get("field_mnemonic"),"")); // willbe used to take it in the bean
 			  template.put("dflt_value"	, checkForNull(multi_last_record+"@@"+(String)old_template.get("dflt_value"),"")+"@@"+new_value);
   			  template.put("field_values"	, "");
 			  template.put("max_dependency_row", checkForNull((String)old_template.get("max_dependency_row"),"")); 
			  template.put("field_mnemonic_action"	,""); //Will store it later 
			  template.put("field_action_msg"	,""); //Will store it later 
			  template.put("notify_yn"	,"N");//Will store it later, if dependency has the notification 
 			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			}  
		return template;
	} // End of buildMultiHashTable

	// To get the Dependency Values.
	public ArrayList getDependencyValues(Properties properties, String format_id, int seq_num, String field_mnemonic, String field_value,String field_type) throws Exception 
	{




 		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList DependencyDtls    = new ArrayList() ;
 		try{
				connection			= ConnectionManager.getConnection(properties) ;
				if(field_type.equalsIgnoreCase("I")||field_type.equalsIgnoreCase("N"))
				{
					String strsql="SELECT format_id,seq_num,field_mnemonic,field_mnemonic_value,value_seq_num,field_mnemonic_value1,field_value_type,field_mnemonic_action,field_action_msg,oth_mnemonic_yn,notify_yn  FROM or_order_format_dtl1 WHERE format_id= ? AND seq_num= ? AND field_mnemonic=? AND (upper(to_number(field_mnemonic_value)) = upper(nvl(?, to_number(field_mnemonic_value))) or (to_number(field_mnemonic_value1) is not null and field_value_type in ('B') and ? between to_number(field_mnemonic_value) and to_number(field_mnemonic_value1)) or (to_number(field_mnemonic_value1) is null and field_value_type in ('L') and ? < to_number(field_mnemonic_value)) or (to_number(field_mnemonic_value1) is null and field_value_type in ('G') and ? > to_number(field_mnemonic_value) ))";
					pstmt				= connection.prepareStatement(strsql);

				}
				else
				{

  					pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_ORDER_FORMAT_DEPENDENCY"));

				}
  				pstmt.setString(1, format_id);   //FORMAT_ID
				pstmt.setString(2, String.valueOf(seq_num));	 //seq_num
				pstmt.setString(3, checkForNull(field_mnemonic,"")); //field_mnemonic,
				pstmt.setString(4, checkForNull(field_value,"")); //field_value
				pstmt.setString(5, checkForNull(field_value,"")); //field_value(for Lesser (L) than) 
				pstmt.setString(6, checkForNull(field_value,"")); //field_value(for Greater (G) than) 
				pstmt.setString(7, checkForNull(field_value,"")); //field_value(for Between (B) two values)
	
	 			resultSet	= pstmt.executeQuery() ;

				if(resultSet!=null){
					String[] record = null;
 				    while(resultSet.next()) { 
						record    = new String[8];
 						record[0] = checkForNull(resultSet.getString("field_mnemonic_value"),"");
						record[1] = checkForNull(resultSet.getString("value_seq_num"),"");
						record[2] = checkForNull(resultSet.getString("field_mnemonic_value1"),"");
						record[3] = checkForNull(resultSet.getString("field_value_type"),"");
						record[4] = checkForNull(resultSet.getString("field_mnemonic_action"),"");
						record[5] = checkForNull(resultSet.getString("field_action_msg"),"");
						record[6] = checkForNull(resultSet.getString("oth_mnemonic_yn"),"");
						record[7] = checkForNull(resultSet.getString("notify_yn"),"");
						DependencyDtls.add(record);

					}	
				}
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} 
			finally{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}
			return DependencyDtls;
	} // End of getDependencyValues
	
	// To get the Other Field Mnemonic values
 		public ArrayList getOthFieldMnemonicValues(Properties properties, String format_id, String seq_num, String field_mnemonic, String field_mnemonic_value ,String value_seq_num, String patient_id) throws Exception {
 		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String clinical_events		= "";

		ArrayList OthFieldMnemonic   = new ArrayList() ;
 		try{
				connection			= ConnectionManager.getConnection(properties) ;
  				pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_OTH_FIELD_MNEMONIC_SELECT"));
 				pstmt.setString(1, format_id);   //FORMAT_ID
				pstmt.setString(2, seq_num);	 //seq_num
				pstmt.setString(3, checkForNull(field_mnemonic,"")); //field_mnemonic,
				pstmt.setString(4, checkForNull(field_mnemonic_value,""));
  				pstmt.setString(5, checkForNull(value_seq_num,"")); //value_seq_num,
				resultSet	= pstmt.executeQuery() ;

				if(resultSet!=null){
					String[] record = null;
 				    while(resultSet.next()) { 
						record    = new String[17]; //IN049133 index chaged 16 to 17
   						record[0] = checkForNull(resultSet.getString("format_id"),"");
						record[1] = checkForNull(resultSet.getString("parent_seq_num"),"");
						record[2] = checkForNull(resultSet.getString("parent_field_mnemonic"),"");
						record[3] = checkForNull(resultSet.getString("field_mnemonic_value"),"");
						record[4] = checkForNull(resultSet.getString("value_seq_num"),"");
						record[5] = checkForNull(resultSet.getString("field_mnemonic"),"");
						record[6] = checkForNull(resultSet.getString("seq_num"),"");
						record[7] = checkForNull(resultSet.getString("label_text"),"");
						record[8] = checkForNull(resultSet.getString("accept_option"),"");
						record[9] = checkForNull(resultSet.getString("dflt_value"),"");
						record[10] = checkForNull(resultSet.getString("field_type"),"");
						record[11] = checkForNull(resultSet.getString("min_num_value"),"");
						record[12] = checkForNull(resultSet.getString("max_num_value"),"");
						record[13] = checkForNull(resultSet.getString("help_text"),"");
						record[14] = checkForNull(resultSet.getString("discr_msr_id"),"");
						record[15] = checkForNull(resultSet.getString("age_group_code"),"");
						record[16] = checkForNull(resultSet.getString("DEPENDENCY_YN"),"");//IN049133
 						if ((checkForNull(record[10],"")).equals("V")) {  // OverWrite it (if field_type=="V" (i.e) clinical Events)
							  clinical_events	= getClinicalEvents(properties, checkForNull(record[14],""), patient_id); //Pass the Discrete Measure Id and Patient_id
  							  if (clinical_events.length() > 50)
								clinical_events = clinical_events.substring(0,50);
								record[9]      =  clinical_events;
						 } 
 						OthFieldMnemonic.add(record);
					}	
				}
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} 
			finally{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}
			return OthFieldMnemonic;
	}	// End of getOthFieldMnemonicValues

	//IN049133 - Start
	// To get the other Dependency Values.
	public ArrayList getOthDependencyValues(Properties properties, String format_id, int seq_num, String field_mnemonic, String field_value,String field_type) throws Exception 
	{
 		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList DependencyDtls    = new ArrayList() ;
 		try{
				connection			= ConnectionManager.getConnection(properties) ;
				if(field_type.equalsIgnoreCase("I")||field_type.equalsIgnoreCase("N"))
				{
					pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_ORDER_FORMAT_OTH_DEPEND_NUM"));
				}
				else
				{

  					pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_ORDER_FORMAT_OTH_DEPENDENCY"));

				}
  				pstmt.setString(1, format_id);   //FORMAT_ID
				pstmt.setString(2, String.valueOf(seq_num));	 //oth_seq_num
				pstmt.setString(3, String.valueOf(seq_num));	//seq_num changed indexing and included seq_num condition in query IN050610
				pstmt.setString(4, checkForNull(field_mnemonic,"")); //field_mnemonic,
				pstmt.setString(5, checkForNull(field_value,"")); //field_value
				pstmt.setString(6, checkForNull(field_value,"")); //field_value(for Lesser (L) than) 
				pstmt.setString(7, checkForNull(field_value,"")); //field_value(for Greater (G) than) 
				pstmt.setString(8, checkForNull(field_value,"")); //field_value(for Between (B) two values)
	
	 			resultSet	= pstmt.executeQuery() ;

				if(resultSet!=null){
					String[] record = null;
 				    while(resultSet.next()) { 
						record    = new String[6];
 						record[0] = checkForNull(resultSet.getString("OTH_FLD_MNEMO_VAL"),"");
						record[1] = checkForNull(resultSet.getString("value_seq_num"),"");
						record[2] = checkForNull(resultSet.getString("field_value_type"),"");
						record[3] = checkForNull(resultSet.getString("field_mnemonic_action"),"");
						record[4] = checkForNull(resultSet.getString("field_action_msg"),"");
						record[5] = checkForNull(resultSet.getString("OTH_FLD_MNEMO_VAL1"),"");

						DependencyDtls.add(record);

					}	
				}
			}catch ( Exception e )	{

				e.printStackTrace() ;
			} 
			finally{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}
			return DependencyDtls;
	} // End of getDependencyValues
	//IN049133 - End
	// To get the count in the place order screen, to display the seconday orderable gif or not
	// and to get the order_catalog_type as 'O' or 'I'
	public String[] getSecondaryOrdersYN(Properties properties, String pri_order_catalog_code, String patient_class) throws Exception {
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	String[] secondaryOrders	= new String[2];
	secondaryOrders[0]			= "N"; // By default 1st Parameter count is "N" , to not to display the gif 
	secondaryOrders[1]			= "O"; // By default 2nd Parameter PRI_SEC_TASKS_TYPE is "O" , to display the catalog based 
	int count					= 0;
	try{
			connection	= ConnectionManager.getConnection(properties) ;
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_SECONDARY_ORDER_COUNT"));
			pstmt.setString(1, (checkForNull(pri_order_catalog_code,"")).trim());
			pstmt.setString(2, checkForNull(patient_class,""));
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )    // Only one record for the patient_class
			{
				while(resultSet.next())
				{
					count = resultSet.getInt(1);
					if (count > 0) {
                       secondaryOrders[0] =  "Y"; //To display the gif
                    } else  {
					   secondaryOrders[0] =  "N";
					}
					secondaryOrders[1] =  checkForNull(resultSet.getString("pri_sec_tasks_type"),"O"); 
				}
			}	// if there is no record, then also it should return as 'N'
		}catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
		return secondaryOrders;
	} // End of getSecondaryOrdersYN

// To get the start_date_time and set it 
public String getSecondaryOrdersStartDateTime(Properties properties, String pri_order_catalog_code,String priority, String patient_class) throws Exception {
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	String start_date_time		= "";
	try{
			connection	= ConnectionManager.getConnection(properties) ;
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_SECONDARY_ORDER_START_DATE_TIME"));
			pstmt.setString(1, (checkForNull(priority,"")).trim());
            pstmt.setString(2, (checkForNull(pri_order_catalog_code,"")).trim());
			pstmt.setString(3, checkForNull(patient_class,""));
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )    // Only one record for the module_id
			{
				while(resultSet.next())
				{
					start_date_time = resultSet.getString(1);
                }
			}
		}catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
		return start_date_time;
	} // End of getSecondaryOrdersStartDateTime

 // Get the Secondary Orders Details
 public ArrayList getSecondaryOrders(Properties properties, String start_date_time,String pri_order_catalog_code,String priority, String patient_class, String sec_order_catalog_type) throws Exception {
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	ArrayList SecondaryOrders = new ArrayList() ;
	try{
			    connection			= ConnectionManager.getConnection(properties) ;
				if(sec_order_catalog_type.equals("O")) {  // Orderable
	                pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_SECONDARY_ORDER_SELECT"));
				} else  { // for intervention
		            pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_SECONDARY_ORDER_INTERVENTION_SELECT"));
				}
				pstmt.setString(1, checkForNull(priority,""));
				pstmt.setString(2, checkForNull(start_date_time,""));
				pstmt.setString(3, checkForNull(start_date_time,""));
				pstmt.setString(4, checkForNull(start_date_time,""));
				pstmt.setString(5, checkForNull(start_date_time,""));
				pstmt.setString(6, checkForNull(start_date_time,""));
				pstmt.setString(7, checkForNull(start_date_time,""));
				pstmt.setString(8, language_id);
				pstmt.setString(9, checkForNull(priority,""));
				pstmt.setString(10, checkForNull(pri_order_catalog_code,""));
				pstmt.setString(11, checkForNull(patient_class,""));		 //patient_class
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())
					{
						record 	  = new String[4];
						record[0] = checkForNull(resultSet.getString( "start_date_time" ),"")  ;
						record[1] = checkForNull(resultSet.getString( "short_desc" ),"");
						record[2] = checkForNull(resultSet.getString( "order_stage" ),"");
						record[3] = checkForNull(resultSet.getString( "sec_order_catalog_code" ),"");
						SecondaryOrders.add(record) ;
					}
				}
		}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
		return SecondaryOrders;
	} // End of getSecondaryOrders

	// Get the order category and the order_type_code if it is coming from CP module
	public String[] getCategoryDetails(Properties properties, String  order_catalog_code) throws Exception {
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	String[] catalog_details	= new String[2];
	catalog_details[0]			= ""; // By default 1st Parameter count is "order_category" 
	catalog_details[1]			= ""; // By default 2nd Parameter is order_type_code 
 	try{
			connection			= ConnectionManager.getConnection(properties) ;
			pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CP_ORDER_DETAILS"));
			pstmt.setString(1, (checkForNull(order_catalog_code,"")).trim());
 			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )    // Only one record for the patient_class
			{
				while(resultSet.next())
				{ 
					catalog_details[0] =  checkForNull(resultSet.getString("order_category"),""); 
					catalog_details[1] =  checkForNull(resultSet.getString("order_type_code"),""); 
				}
			}	// if there is no record, then also it should return as 'N'
		}catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
		return catalog_details;
	} // End of getCategoryDetails


		// To Populate the (Order Format) List Box Values in the Place Order Tab
	public ArrayList getOrderFormatList(Properties properties, String order_category,String field_mnemonic,String contr_msr_panel_id, String contr_msr_mod_id, String order_type_code, String discr_msr_id, String performing_facility_id, String login_facility_id, String sex, String lab_install_yn, String bt_install_yn, String rd_install_yn, String ot_install_yn,String catalog_code) throws Exception {

 		ArrayList OrderFormatList	= new ArrayList() ;
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
 		String[] record				= null;
	 	try{
				connection			= ConnectionManager.getConnection(properties) ;
                if(checkForNull(discr_msr_id,"").equals("") )
				{
                    if(((order_category.trim()).equalsIgnoreCase("LB")) && lab_install_yn.equalsIgnoreCase("Y") && ((field_mnemonic.trim()).equalsIgnoreCase("SPECIMEN_TYPE")))    // For Specimen Type
					{
                        if (checkForNull(contr_msr_mod_id,"").equals("BT")) {
                            pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_LAB_INSTAL_SPECIMEN_TYPE_BT"));
                        } else {
                            pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_LAB_INSTAL_SPECIMEN_TYPE"));
                        }

                        pstmt.setString(1, checkForNull(language_id.trim(),""));
                        pstmt.setString(2, checkForNull(contr_msr_panel_id.trim(),""));
						pstmt.setString(3, checkForNull(contr_msr_panel_id.trim(),""));

						resultSet	= pstmt.executeQuery() ;
						if ( resultSet != null )
						{
							while(resultSet.next())
							{
								record 	  = new String[4];
								record[0] = checkForNull(resultSet.getString( "specimen_type_code" ),"")  ;
								record[1] = checkForNull(resultSet.getString( "specimen_desc" ),"");
								record[2] = checkForNull(resultSet.getString( "dflt_value" ),"N");
								record[3] = lab_install_yn; // Lab is installed
								OrderFormatList.add(record) ;
							}
						}
					} // END OF SPECIMEN_TYPE -->LB
					else if(((order_category.trim()).equalsIgnoreCase("LB")) && lab_install_yn.equalsIgnoreCase("Y") && ((field_mnemonic.trim()).equalsIgnoreCase("REQUEST_COMMENT")))    // For REQUEST_COMMENT
					{  // Only For Header Level
						pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_LAB_INSTAL_REQUEST_COMMENT"));
						pstmt.setString(1, checkForNull(order_type_code.trim(),""));
						resultSet	= pstmt.executeQuery() ;
						if ( resultSet != null )
						{
						 	while(resultSet.next())
							{
								record 	  = new String[4];
								record[0] = checkForNull(resultSet.getString( "request_comment_code" ),"")  ;
								record[1] = checkForNull(resultSet.getString( "request_comment" ),"");
								record[2] = "N";
								record[3] = lab_install_yn; // Lab is installed
								OrderFormatList.add(record) ;
							}
						}
					} // END OF REQUEST_COMMENT -->LB
					else if(((order_category.trim()).equalsIgnoreCase("LB")) && ((field_mnemonic.trim()).equalsIgnoreCase("ANATOMY_SITE")))    // For ANATOMY_SITE, If it is an Lab Category
					{
                        if(lab_install_yn.equalsIgnoreCase("Y")) {// If lab is installed
							pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_LAB_INSTAL_ANATOMY_SITE"));
							pstmt.setString(1, language_id);
							pstmt.setString(2, checkForNull(contr_msr_panel_id.trim(),""));
						} else {// If lab is not installed
							pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_LAB_UNINSTAL_ANATOMY_SITE"));
							pstmt.setString(1, language_id);
						}

                        resultSet	= pstmt.executeQuery() ;
						if ( resultSet != null )
						{
						 	while(resultSet.next())
							{
								record 	  = new String[4];
								record[0] = checkForNull(resultSet.getString( "anatomy_site_code" ),"")  ;
								record[1] = checkForNull(resultSet.getString( "long_desc" ),"");
								record[2] = "N"; 			// Default Value 'N'
								record[3] = lab_install_yn; // LB is installed
								OrderFormatList.add(record) ;
							}
						}
					} // End of ANATOMY_SITE
					else if(((order_category.trim()).equalsIgnoreCase("LB") && lab_install_yn.equals("Y")) && ((field_mnemonic.trim()).equalsIgnoreCase("TISSUE_DESC")))    // For TISSUE_DESC, If it is an Lab Category and lab is installed
					{
                        pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_LAB_INSTAL_TISSUE_DESC"));
						resultSet	= pstmt.executeQuery() ;
						if ( resultSet != null )
						{
						 	while(resultSet.next())
							{
								record 	  = new String[4];
								record[0] = checkForNull(resultSet.getString( "tissue_desc_code" ),"")  ;
								record[1] = checkForNull(resultSet.getString( "long_desc" ),"");
								record[2] = "N"; 			// Default Value 'N'
								record[3] = lab_install_yn; // LB is installed
								OrderFormatList.add(record) ;
							}
						}
					} // End of TISSUE_DESC
					else if(((order_category.trim()).equalsIgnoreCase("LB")) && ((field_mnemonic.trim()).equalsIgnoreCase("FIXATIVE")))    // For FIXATIVE, If it is an Lab Category and lab is installed
					{
						pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_LAB_INSTAL_FIXATIVE"));
						resultSet	= pstmt.executeQuery() ;
						if ( resultSet != null )
						{
						 	while(resultSet.next())
							{
								record 	  = new String[4];
								record[0] = checkForNull(resultSet.getString( "fixative_code" ),"")  ;
								record[1] = checkForNull(resultSet.getString( "long_desc" ),"");
								record[2] = "N"; 			// Default Value 'N'
								record[3] = lab_install_yn; // LB is installed
								OrderFormatList.add(record) ;
							}
						}
					} // End of FIXATIVE
					else if(((order_category.trim()).equalsIgnoreCase("LB")) && bt_install_yn.equalsIgnoreCase("Y") && ((field_mnemonic.trim()).equalsIgnoreCase("BLOOD_CATEGORY_RQST")))    // For Blood Category Request
					{
						pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BT_INSTAL_BLOOD_CATEGORY_REQUEST"));
						resultSet	= pstmt.executeQuery() ;
						if ( resultSet != null )
						{
						 	while(resultSet.next())
							{
								record 	  = new String[4];
								record[0] = checkForNull(resultSet.getString( "category_code" ),"")  ;
								record[1] = checkForNull(resultSet.getString( "short_desc" ),"");
								record[2] = "N"; 			// Default Value 'N'
								record[3] = bt_install_yn; // BT is installed
								OrderFormatList.add(record) ;
							}
						}
					} // END OF BLOOD_CATEGORY_RQST -->BT
					else if(((order_category.trim()).equalsIgnoreCase("RD")) && rd_install_yn.equalsIgnoreCase("Y") && ((field_mnemonic.trim()).equalsIgnoreCase("TRANSPORT_MODE")))    // For Transport Mode
					{
						pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_RD_INSTAL_TRANSPORT_MODE"));
						resultSet	= pstmt.executeQuery() ;
						if ( resultSet != null )
						{
						 	while(resultSet.next())
							{
								record 	  = new String[4];
								record[0] = checkForNull(resultSet.getString( "trans_mode_code" ),"")  ;
								record[1] = checkForNull(resultSet.getString( "long_desc" ),"");
								record[2] = "N"; 			// Default Value 'N'
								record[3] = rd_install_yn; // RD is installed
								OrderFormatList.add(record) ;
							}
						}
					} // END OF TRANSPORT_MODE -->RD
					else if(((order_category.trim()).equalsIgnoreCase("RD")) && rd_install_yn.equalsIgnoreCase("Y") && ((field_mnemonic.trim()).equalsIgnoreCase("EXAM_VIEW_REQSTD")))    // For Exam View
					{
						pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_RD_INSTAL_EXAM_VIEW"));
						pstmt.setString(1, checkForNull(contr_msr_panel_id.trim(),""));
						resultSet	= pstmt.executeQuery() ;
						if ( resultSet != null )
						{
						 	while(resultSet.next())
							{
								record 	  = new String[4];
								record[0] = checkForNull(resultSet.getString( "view_code" ),"")  ;
								record[1] = checkForNull(resultSet.getString( "long_desc" ),"");
								record[2] = "N"; 			// Default Value 'N'
								record[3] = rd_install_yn; // RD is installed
								OrderFormatList.add(record) ;
							}
						}
					} // END OF EXAM_VIEW_REQSTD -->RD
					else if(((order_category.trim()).equalsIgnoreCase("RD")) && rd_install_yn.equalsIgnoreCase("Y") && ((field_mnemonic.trim()).equalsIgnoreCase("STUDY_LOC")))    // For Study Location
					{
						pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_RD_INSTAL_STUDY_LOC"));
						pstmt.setString(1, language_id);
						pstmt.setString(2, checkForNull(contr_msr_panel_id.trim(),""));
						pstmt.setString(3, sex);
						pstmt.setString(4, sex);
						pstmt.setString(5, checkForNull(performing_facility_id,""));
						pstmt.setString(6, "N"); //MOBILE_CLINIC_YN

						resultSet	= pstmt.executeQuery() ;
						if ( resultSet != null )
						{
 							while(resultSet.next())
							{
								record 	  = new String[4];
								record[0] = checkForNull(resultSet.getString( "clinic_code" ),"")  ;
								record[1] = checkForNull(resultSet.getString( "long_desc" ),"");
								record[2] = "N"; 			// Default Value 'N'
								record[3] = rd_install_yn; // RD is installed
								OrderFormatList.add(record) ;
							}
						}
					} // End of STUDY_LOC --> RD
					else if(((order_category.trim()).equalsIgnoreCase("RD")) && rd_install_yn.equalsIgnoreCase("Y") && ((field_mnemonic.trim()).equalsIgnoreCase("REQUEST_COMMENT")) )    // For Request Comment Radiology
					{
						pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_RD_INSTAL_REQUEST_COMMENT"));
 						pstmt.setString(1, checkForNull(order_type_code.trim(),""));
						resultSet	= pstmt.executeQuery() ;
						if ( resultSet != null )
						{
 							while(resultSet.next())
							{
								record 	  = new String[4];
								record[0] = checkForNull(resultSet.getString( "reason_code" ),"")  ;
								record[1] = checkForNull(resultSet.getString( "long_desc" ),"");
								record[2] = "N"; 			// Default Value 'N'
								record[3] = rd_install_yn; // RD is installed
								OrderFormatList.add(record) ;
							}
						}
					} // End of REQUEST_COMMENT --> RD
					else if(((order_category.trim()).equalsIgnoreCase("OT")) && ((field_mnemonic.trim()).equalsIgnoreCase("PERFORM_TEAM_SURGEON")) )    // For Perform Team Surgery if ot module is installed
					{
						if(ot_install_yn.equalsIgnoreCase("Y")) // If ot module is installed
						{
							pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_OT_INSTAL_PERFORM_TEAM_SURGEON"));
							pstmt.setString(1, language_id);
							pstmt.setString(2, checkForNull(performing_facility_id,""));
							pstmt.setString(3, checkForNull(order_type_code,""));
							pstmt.setString(4, checkForNull(order_type_code,""));
						}
						else  // Ot module is not installed
						{
							pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_OT_NOT_INSTAL_PERFORM_TEAM_SURGEON"));
							
							pstmt.setString(1, language_id);
						} // End of ot is not installed
						resultSet	= pstmt.executeQuery() ;
						if ( resultSet != null )
						{
 							while(resultSet.next())
							{
								record 	  = new String[4];
								record[0] = checkForNull(resultSet.getString( "team_id" ),"")  ;
								record[1] = checkForNull(resultSet.getString( "long_desc" ),"");
								record[2] = "N"; 			// Default Value 'N'
								record[3] = ot_install_yn;  // OT is installed
								OrderFormatList.add(record) ;
							}
						}
					} // End of PERFORM_TEAM_SURGEON
					else if(((order_category.trim()).equalsIgnoreCase("OT")) && ot_install_yn.equalsIgnoreCase("Y") && ((field_mnemonic.trim()).equalsIgnoreCase("PATIENT_POSITION")) )    // For Patient Position
					{
	                    pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_OT_INSTAL_PATIENT_POSITION"));
						resultSet	= pstmt.executeQuery() ;
						if ( resultSet != null )
						{
 							while(resultSet.next())
							{
								record 	  = new String[4];
								record[0] = checkForNull(resultSet.getString( "position_code" ),"")  ;
								record[1] = checkForNull(resultSet.getString( "long_desc" ),"");
								record[2] = "N"; 			// Default Value 'N'
								record[3] = ot_install_yn;  // OT is installed/not
								OrderFormatList.add(record) ;
							}
						}
					} // End of PATIENT_POSITION --> OT
					else if(((order_category.trim()).equalsIgnoreCase("OT")) && ot_install_yn.equalsIgnoreCase("Y") && ((field_mnemonic.trim()).equalsIgnoreCase("OPER_KEYWORD")) )    // For OT_OPER_KEYWORD
					{
						pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_OT_INSTAL_OT_OPER_KEYWORD"));
						resultSet	= pstmt.executeQuery() ;
						if ( resultSet != null )
						{
 							while(resultSet.next())
							{
								record 	  = new String[4];
								record[0] = checkForNull(resultSet.getString( "oper_keyword_code" ),"")  ;
								record[1] = checkForNull(resultSet.getString( "long_desc" ),"");
								record[2] = "N"; 			// Default Value 'N'
								record[3] = ot_install_yn;  // OT is installed/not
								OrderFormatList.add(record) ;
							}
						}
					} // End of OPER_KEYWORD_CODE --> OT
					else if(((order_category.trim()).equalsIgnoreCase("OT")) && ot_install_yn.equalsIgnoreCase("Y") && ((field_mnemonic.trim()).equalsIgnoreCase("SURGERY_TYPE")) )    // For OT SURGERY_TYPE
					{
						//Changes made for IN043095/Start
						pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_OT_INSTAL_SURGERY"));
						
						//pstmt		= connection.prepareStatement("SELECT nature_code, long_desc, short_desc, nature_type, status FROM ot_nature_of_surgery WHERE nvl(status,'E') = ? UNION  SELECT alphanum_value, alphanum_value, alphanum_value, 'EL', 'E'   FROM or_order_field_ref_values   WHERE order_category = ? AND field_mnemonic = ? ORDER BY 2");
						
						//pstmt.setString(1, "E");
						//pstmt.setString(2, "OT");
						//pstmt.setString(3, "SURGERY_TYPE");
						//Changes made for IN043095/End
						resultSet	= pstmt.executeQuery() ;
						if ( resultSet != null )
						{
 							while(resultSet.next())
							{
								record 	  = new String[4];
								record[0] = checkForNull(resultSet.getString( "nature_code" ),"")  ;
								record[1] = checkForNull(resultSet.getString( "short_desc" ),"");
								record[2] = "N"; 			// Default Value 'N'
								record[3] = ot_install_yn;  // OT is installed/not
								OrderFormatList.add(record) ;
							}
						}
					} // End of SURGERY --> OT
					else if(((order_category.trim()).equalsIgnoreCase("OT")) && ot_install_yn.equalsIgnoreCase("Y") && ((field_mnemonic.trim()).equalsIgnoreCase("ANAESTHETIST_CODE")) )    // For OT ANAESTHETIST_CODE
					{
						pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_OT_INSTAL_ANAESTHETIST_CODE"));
						pstmt.setString(1, login_facility_id);
						resultSet	= pstmt.executeQuery() ;
						if ( resultSet != null )
						{
 							while(resultSet.next())
							{
								record 	  = new String[4];
								record[0] = checkForNull(resultSet.getString( "physician_id" ),"")  ;
								record[1] = checkForNull(resultSet.getString( "short_name" ),"");
								record[2] = "N"; 			// Default Value 'N'
								record[3] = ot_install_yn;  // OT is installed/not
								OrderFormatList.add(record) ;
							}
						}
					} // End of ANAESTHETIST_CODE --> OT
					else if(((order_category.trim()).equalsIgnoreCase("OT")) && ot_install_yn.equalsIgnoreCase("Y") && ((field_mnemonic.trim()).equalsIgnoreCase("PROSTHESIS_IMPLANT")) )    // For OT PROSTHESIS_IMPLANT
					{
 						pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_OT_INSTAL_PROSTHESIS_IMPLANT"));
						resultSet	= pstmt.executeQuery() ;
						if ( resultSet != null )
						{
 							while(resultSet.next())
							{
								record 	  = new String[4];
								record[0] = checkForNull(resultSet.getString( "prosthesis_code" ),"")  ;
								record[1] = checkForNull(resultSet.getString( "short_desc" ),"");
								record[2] = "N"; 			// Default Value 'N'
								record[3] = ot_install_yn;  // OT is installed/not
								OrderFormatList.add(record) ;
							}
						}
					} // End of PROSTHESIS_IMPLANT --> OT
					else if(((order_category.trim()).equalsIgnoreCase("OT")) && ot_install_yn.equalsIgnoreCase("Y") && ((field_mnemonic.trim()).equalsIgnoreCase("CONSIGNMENT_IMPLANT")) )    // For OT CONSIGNMENT_IMPLANT
					{
 						pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_OT_INSTAL_PROSTHESIS_CONS_IMPLANT"));
						resultSet	= pstmt.executeQuery() ;
						if ( resultSet != null )
						{
 							while(resultSet.next())
							{
								record 	  = new String[4];
								record[0] = checkForNull(resultSet.getString( "prosthesis_code" ),"")  ;
								record[1] = checkForNull(resultSet.getString( "short_desc" ),"");
								record[2] = "N"; 			// Default Value 'N'
								record[3] = ot_install_yn;  // OT is installed/not
								OrderFormatList.add(record) ;
							}
						}
					} // End of CONSIGNMENT_IMPLANT --> OT
					/*Added by Uma on 2/22/2010 for IN017828 SRR20056-CRF-0587*/
					 else if(((order_category.trim()).equalsIgnoreCase("LB")) && lab_install_yn.equalsIgnoreCase("Y") && ((field_mnemonic.trim()).equalsIgnoreCase("BLOOD_PRODUCT_PROCESS")))    // For Blood Product Process
					{
                       
                        pstmt		= connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_BT_PROCESS_CODE_LANG_VW"));     pstmt.setString(1, language_id);
						resultSet	= pstmt.executeQuery() ;
						if ( resultSet != null )
						{
							while(resultSet.next())
							{
								record 	  = new String[4];
								record[0] = checkForNull(resultSet.getString( "code" ),"")  ;
								record[1] = checkForNull(resultSet.getString( "short_desc" ),"");
								record[2] = "";
								record[3] = lab_install_yn; // Lab is installed
								OrderFormatList.add(record) ;
							}
						}
					} // END OF BLOOD_PRODUCT_PROCESS Ends Here Uma for IN017828 -->LB
					else if((field_mnemonic.trim()).equalsIgnoreCase("SPECIMEN_TYPE"))
					{
						pstmt		= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_SPECIMEN_LIST_SELECT"));
						pstmt.setString(1, checkForNull(order_category.trim(),""));
						pstmt.setString(2, checkForNull(field_mnemonic.trim(),""));
						pstmt.setString(3, checkForNull(catalog_code.trim(),""));
						resultSet	= pstmt.executeQuery() ;
						if ( resultSet != null )
						{
 							while(resultSet.next())
							{	// For all the List Items, value and desc. will be same, except for field_mnemonic='SPECIMEN_TYPE' and lab is installed
								record 	  = new String[4];
								record[0] = checkForNull(resultSet.getString( "alphanum_value" ),"")  ;
								record[1] = record[0]; // Since the code and desc is same
								record[2] = checkForNull(resultSet.getString( "DEFAULT_YN" ),"")  ;
								record[3] = lab_install_yn; // Lab is not installed
								OrderFormatList.add(record) ;
							}
						}
					}
					else
					{
						pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_LIST_SELECT"));
						pstmt.setString(1, checkForNull(order_category.trim(),""));
						pstmt.setString(2, checkForNull(field_mnemonic.trim(),""));
						resultSet	= pstmt.executeQuery() ;
						if ( resultSet != null )
						{
 							while(resultSet.next())
							{	// For all the List Items, value and desc. will be same, except for field_mnemonic='SPECIMEN_TYPE' and lab is installed
								record 	  = new String[4];
								record[0] = checkForNull(resultSet.getString( "alphanum_value" ),"")  ;
								record[1] = record[0]; // Since the code and desc is same
								record[2] = "N";
								record[3] = lab_install_yn; // Lab is not installed
								OrderFormatList.add(record) ;
							}
						}
					}
					}
				else // if discrete measure id is there, then we have to take from am_discr_msr_ref_rng_list
				{
					pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_DISCR_MSR"));
					pstmt.setString(1, checkForNull(discr_msr_id.trim(),""));
					resultSet	= pstmt.executeQuery() ;
					if ( resultSet != null )
					{
 						while(resultSet.next())
						{	// For all the List Items, value and desc. will be same, except for field_mnemonic='SPECIMEN_TYPE' and lab is installed
							record 	  = new String[4];
							//record[0] = checkForNull(resultSet.getString( "discr_msr_id" ),"")  ;
							record[0] = checkForNull(resultSet.getString( "ref_rng_desc" ),"")  ; //Put the description for the code
							record[1] = checkForNull(resultSet.getString( "ref_rng_desc" ),"")  ;
							record[2] = "N";
							record[3] = lab_install_yn; // Lab is not installed
							OrderFormatList.add(record) ;
						} // End of while
					} // End of if
				}  // End of discr_msr_id
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			}
			finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}
			return OrderFormatList;
	}	 // End of the OrderFormatList


	// To make Mandatory or not for Exam Side Appl if radialogy is installed(over riding the master in OR)
	public String getExamSideApplMandYn(Properties properties, String catalog_code) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		String  exam_side_appl		= "O"; // It will be Optional
		try{
				connection			= ConnectionManager.getConnection(properties) ;
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_EXAM_SIDE_MAND"));
				pstmt.setString(1, catalog_code );
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					while(resultSet.next())	//Only One Record it will return
					{
						exam_side_appl = checkForNull(resultSet.getString( "exam_side_appl" ),"O")  ;
					}
				}
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}
			return exam_side_appl;
	}	 // End of the getExamSideApplMandYn

	// To Populate the (Order Format) Radio Button Values in the Place Order Tab
	public ArrayList getOrderFormatRadio(Properties properties, String order_category, String field_mnemonic,String catalog_code,String lab_install_yn,String contr_msr_panel_id, String contr_msr_mod_id) throws Exception {

 		ArrayList OrderFormatRadio	= new ArrayList() ;
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
 		String[] record				= null;
	 	try{
				connection			= ConnectionManager.getConnection(properties) ;
				if(((order_category.trim()).equalsIgnoreCase("LB")) && lab_install_yn.equalsIgnoreCase("Y") && ((field_mnemonic.trim()).equalsIgnoreCase("SPECIMEN_TYPE")))    // For Specimen Type
					{
                        if (checkForNull(contr_msr_mod_id,"").equals("BT")) {
                            pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_LAB_INSTAL_SPECIMEN_TYPE_BT"));
                        } else {
                            pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_LAB_INSTAL_SPECIMEN_TYPE"));
                        }

                        pstmt.setString(1, checkForNull(language_id.trim(),""));
                        pstmt.setString(2, checkForNull(contr_msr_panel_id.trim(),""));
						pstmt.setString(3, checkForNull(contr_msr_panel_id.trim(),""));

						resultSet	= pstmt.executeQuery() ;
						if ( resultSet != null )
						{
							while(resultSet.next())
							{
								record 	  = new String[2];
								record[0] = checkForNull(resultSet.getString( "specimen_type_code" ),"")  ;
								record[1] = checkForNull(resultSet.getString( "specimen_desc" ),"");
								OrderFormatRadio.add(record) ;
							}
						}
					}
					else if(((order_category.trim()).equalsIgnoreCase("LB")) && lab_install_yn.equalsIgnoreCase("N") && ((field_mnemonic.trim()).equalsIgnoreCase("SPECIMEN_TYPE")))
					{
						pstmt		= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_SPECIMEN_LIST_SELECT"));
						pstmt.setString(1, checkForNull(order_category.trim(),""));
						pstmt.setString(2, checkForNull(field_mnemonic.trim(),""));
						pstmt.setString(3, checkForNull(catalog_code.trim(),""));
						resultSet	= pstmt.executeQuery() ;
						if ( resultSet != null )
						{
 							while(resultSet.next())
							{	// For all the List Items, value and desc. will be same, except for field_mnemonic='SPECIMEN_TYPE' and lab is installed
								record 	  = new String[2];
								record[0] = checkForNull(resultSet.getString( "alphanum_value" ),"")  ;
								record[1] = record[0]; // Since the code and desc is same
								OrderFormatRadio.add(record) ;
							}
						}
					}
					else
					{
						pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_LIST_SELECT"));
						pstmt.setString(1, checkForNull(order_category.trim(),""));
						pstmt.setString(2, checkForNull(field_mnemonic.trim(),""));
						resultSet			= pstmt.executeQuery() ;
						if ( resultSet != null )
						{
							while(resultSet.next())
							{	// For all the Radio Box Items, value and desc. will be same
								record 	  = new String[2];
								record[0] = checkForNull(resultSet.getString( "alphanum_value" ),"")  ;
								record[1] = record[0];	// Since the code and desc is same
								OrderFormatRadio.add(record) ;
							} // End of while
						}  // End of if
					}
	  	}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			}
			finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}
			return OrderFormatRadio;
	} // End of the getOrderFormatRadio

	// Ot Default Pref_surg_date with the next day date
	public String getNextSysDate(Properties properties) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String next_sys_date		= "";
		try{
  			   
			    connection			= ConnectionManager.getConnection(properties) ;
  				pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SCHEDULE_TODAY_DAY_TIME"));
 				resultSet	= pstmt.executeQuery() ;
				if(resultSet!=null){ // only one record
  				    while(resultSet.next()) { 
    					next_sys_date = resultSet.getString("next_sys_date");
			 		}	
				}
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			}  finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}
			return next_sys_date;
	}	 // End of the getNextSysDate
	 
	// To get the Primary Order Type List item, if the Order category is OT (before placing an order)
	public String getPrimaryOrderType(Properties properties, String combined_order_type) throws Exception {
		Connection connection 		= null;
 		String sql					= "", select_str		= "";
		try{
				connection			= ConnectionManager.getConnection(properties) ;
				sql					= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PRIMARY_ORDER_TYPE"); 
				int  count 			= sql.lastIndexOf("?");
				sql  				= sql.substring(0,count) + combined_order_type.trim() + sql.substring(count+1) ;
 				select_str			= Populate.getComboOptions(sql, connection, "order_type_code","short_desc");
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
 				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}
			return select_str;
	}	 // End of the getPrimaryOrderType

 	// Population of the order catalogs in the Drawing Tab based upon the image_id
/*    public ArrayList getDrawingToolsItems(Properties properties, String image_id, String facility_id, String location_type, String location_code, String patient_id, String encounter_id, String patient_class, String episode_id, String episode_visit_num, String login_by_id, String responsibility_id, String practitioner_type, String sex, String dob, String visit_adm_date, String discharge_date_time) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList DrawingToolsItems	= new ArrayList() ;
		try{
				connection			= ConnectionManager.getConnection(properties) ;
				pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_DRAWING_TOOLS_SELECT"));
				pstmt.setString(1,   facility_id); // Facility_id
				pstmt.setString(2,   location_type); // source_type
				pstmt.setString(3,   location_code); // source_code(or_performing_facility_id)
				pstmt.setString(4,   facility_id);
				pstmt.setString(5,   patient_id);
				pstmt.setString(6,   encounter_id);
				pstmt.setString(7,   patient_class);	 //(or_bl_catalog_dtl)
				pstmt.setString(8,   episode_id);		//(or_bl_catalog_dtl)
				pstmt.setString(9,   episode_visit_num);  //(or_bl_catalog_dtl)
				pstmt.setString(10,  facility_id);   // FACILITY_ID
				pstmt.setString(11,  login_by_id);		// login_by_id
				pstmt.setString(12,  responsibility_id);  // P_RESP_ID   (OR_PRIVILEGE_BY_ORDER)
				pstmt.setString(13,  practitioner_type);
				pstmt.setString(14,  patient_class);
				pstmt.setString(15,  patient_id);
				pstmt.setString(16,  checkForNull(sex,""));
				pstmt.setString(17,  checkForNull(dob,"")) ;
				pstmt.setString(18,  patient_class);
 				pstmt.setString(19,  facility_id);
				pstmt.setString(20,  encounter_id);
				pstmt.setString(21,  patient_class);
				pstmt.setString(22,  checkForNull(visit_adm_date,"")) ;
				pstmt.setString(23,  checkForNull(discharge_date_time,"")) ;
 				pstmt.setString(24,  facility_id);
 				pstmt.setString(25,  image_id);	//image_id
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())
					{
						record 	  = new String[14];
						record[0] = checkForNull(resultSet.getString( "Group_Name" ),"")  ;
						record[1] = checkForNull(resultSet.getString( "order_catalog_code" ),"")  ;
						record[2] = checkForNull(resultSet.getString( "catalog_synonym" ),"")  ;
						record[3] = checkForNull(resultSet.getString( "order_catalog_nature" ),"")  ;
						record[4] = checkForNull(resultSet.getString( "discr_msr_panel_id" ),"")  ;
						record[5] = checkForNull(resultSet.getString( "prompt_alert_yn" ),"N")  ;
						record[6] = checkForNull(resultSet.getString( "prompt_alert_msg" ),"")  ;
						record[7] = checkForNull(resultSet.getString( "order_category" ),"")  ;
						record[8] = checkForNull(resultSet.getString( "order_type_code" ),"")  ;
						record[9] = checkForNull(resultSet.getString( "ord_auth_reqd_yn" ),"")  ;
						record[10] = checkForNull(resultSet.getString( "contr_msr_panel_id" ),"")  ;
						record[11] = checkForNull(resultSet.getString( "ord_spl_appr_reqd_yn" ),"N")  ;
						record[12] = checkForNull(resultSet.getString( "bill_message" ),"")  ;
						record[13] = checkForNull(resultSet.getString( "enable_yn" ),"")  ;
						DrawingToolsItems.add(record) ;
					}
				}
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				ConnectionManager.returnConnection(connection, properties);
			}
			return DrawingToolsItems;
	}	 // End of the getFrequentOrdersPractitionerItems
 	// Get the Image_ref for the Drawing tools
	public ArrayList getDrawingImage (Properties properties) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String[] record				= null;
		ArrayList DrawingImage		= new ArrayList();
		try{
				connection			= ConnectionManager.getConnection(properties) ;
				pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_DRAWING_TOOL_IMAGE_SELECT") ) ;
 				resultSet			= pstmt.executeQuery() ;
				if ( resultSet != null )   // Only One Record
				{
					while(resultSet.next())
					{
						record	= new String[2];
						record[0] = checkForNull( resultSet.getString( "image_ref" ), "" );
						record[1] = checkForNull( resultSet.getString( "image_ref_desc" ), "" );
						DrawingImage.add(record) ;
					}
				}
		}catch ( Exception e )	{

			e.printStackTrace() ;
			return null;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			ConnectionManager.returnConnection(connection, properties);
		}
		return DrawingImage;
	}	 // End of the getDrawingImage
*/
	// To get the Details for OT Booking related one, before opening the appointment window for the OT
	public ArrayList getOTBookingDetails(Properties properties, String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList OTBookingDtls		= new ArrayList(); 
		String[]  record			= null;	
		String flg                  = "1";//--[IN029395]
		try{
				connection			= ConnectionManager.getConnection(properties) ;
				pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_OT_BOOK_DETAILS"));
 				pstmt.setString(1, language_id);
				pstmt.setString(2, order_id);
 				resultSet			= pstmt.executeQuery() ;
  				if(resultSet!=null){ // only one record
   				    while(resultSet.next()) { 
						flg = "3";//--[IN029395]
						record	= new String[3];
 						record[0] = checkForNull( resultSet.getString( "pref_surg_date" ), "" );
						record[1] = checkForNull( resultSet.getString( "practitioner_id" ), "" );
						record[2] = checkForNull( resultSet.getString( "practitioner_name" ), "" );
						OTBookingDtls.add(record) ;
			 		}	//End of resultset
					//--[IN029395] - Start
					if(!resultSet.next() && flg.equals("1")) 
					flg = "2";
					//--[IN029395] - End
				}
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}
			//--[IN029395] - Start
			if(flg.equals("2"))
			{
			try{
				connection			= ConnectionManager.getConnection(properties) ;

				pstmt				= connection.prepareStatement("SELECT a.order_field_value pref_surg_date FROM or_order_field_values a, am_practitioner b, or_order_field_values c WHERE a.order_id = ? AND a.order_id = c.order_id AND a.order_field_mnemonic IN ('PREF_SURG_DATE') AND c.order_field_value IS NOT NULL AND ROWNUM <= 1");
 			
				pstmt.setString(1, order_id);
 				resultSet			= pstmt.executeQuery() ;
  				if(resultSet!=null){ // only one record
   				    while(resultSet.next()) { 
						record	= new String[3];
 						record[0] = checkForNull( resultSet.getString( "pref_surg_date" ), "" );
						record[1] = "";
						record[2] = "";
						OTBookingDtls.add(record) ;				
						}	//End of resultset
					}
				}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
				}
			}
			//--[IN029395] - End
			return OTBookingDtls;
	} // End of the getOTBookingDetails

	// For the Duplicate check, firing the query to display all the record details for the catalog and patient
	public ArrayList getDuplicateBehindCheckDetails(Properties properties, String patient_id, String catalog_code, String test_date_time, String activity_type, String chk_for_dupl_behind_unit, String chk_for_dupl_behind_period, String vb_status , String chk_for_dupl_status,String check_for_dupl_level) throws Exception 
	{
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			String dupeCheckQuery 		= ""; // MO-CRF-20085 [IN051135] - IN060460
			ArrayList DuplicateDetails	= new ArrayList() ;
			try
			{
				connection			= ConnectionManager.getConnection(properties) ;

				if(checkForNull(check_for_dupl_level,"").equals("O"))
				{
					if(!checkForNull(vb_status,"N").equals("N") && checkForNull(chk_for_dupl_status,"N").equals("Z")) 
					{
						
						pstmt				= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_DUPLICATE_CHECK_DUPL_STAT_BEHIND_DETAILS"));

					
					   pstmt.setString(1,language_id);
					   pstmt.setString(2,language_id);
					   pstmt.setString(3, patient_id);
					   if(checkForNull(check_for_dupl_level,"").equals("O"))
					   {  //pass the catalog_code
								pstmt.setString(4, catalog_code);
						} else 
						{ //pass the activity_type 
								pstmt.setString(4, activity_type);
						}	
						pstmt.setString(5, test_date_time);
						pstmt.setString(6, chk_for_dupl_behind_period);
						pstmt.setString(7, chk_for_dupl_behind_unit);
						pstmt.setString(8, test_date_time);
						pstmt.setString(9, test_date_time);
						pstmt.setString(10, chk_for_dupl_behind_period);
						pstmt.setString(11, chk_for_dupl_behind_unit);
						pstmt.setString(12, test_date_time);

						resultSet			= pstmt.executeQuery() ;

					
					} 
					else 
					{  // For Active
						// MO-CRF-20085 [IN051135] - IN060460 - Start
						if("C".equalsIgnoreCase(chk_for_dupl_status)){
							dupeCheckQuery = (OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_DUPLICATE_CHECK_DUPL_STAT_BEHIND_COMPLETED_DETAILS"));
						} 
						else {
							dupeCheckQuery = (OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_DUPLICATE_CHECK_DUPL_STAT_BEHIND_ACTIVE_DETAILS"));
						}	
						//pstmt				= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_DUPLICATE_CHECK_DUPL_STAT_BEHIND_ACTIVE_DETAILS"));
						pstmt				= connection.prepareStatement(dupeCheckQuery);
						// MO-CRF-20085 [IN051135] - IN060460 - End
						pstmt.setString(1,language_id);
						pstmt.setString(2,language_id);
						pstmt.setString(3, patient_id);
						if(checkForNull(check_for_dupl_level,"").equals("O"))
						{  //pass the catalog_code
							pstmt.setString(4, catalog_code);
						} else 
						{ //pass the activity_type 
							pstmt.setString(4, activity_type);
						}	
						pstmt.setString(5, test_date_time);
						pstmt.setString(6, chk_for_dupl_behind_period);
						pstmt.setString(7, chk_for_dupl_behind_unit);
						pstmt.setString(8, test_date_time);
						pstmt.setString(9, test_date_time);
						pstmt.setString(10, chk_for_dupl_behind_period);
						pstmt.setString(11, chk_for_dupl_behind_unit);
						pstmt.setString(12, test_date_time);

						resultSet			= pstmt.executeQuery() ;
					
					} 
				} 
				else 
				{  //if activity type is there 
					if(!checkForNull(vb_status,"N").equals("N") && checkForNull(chk_for_dupl_status,"N").equals("Z"))
					{
						pstmt				= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_DUPLICATE_ACTIVITY_CHECK_DUPL_STAT_BEHIND_DETAILS"));


						pstmt.setString(1,language_id);
						pstmt.setString(2,language_id);
						pstmt.setString(3, patient_id);
						if(checkForNull(check_for_dupl_level,"").equals("O"))
						{  //pass the catalog_code
							pstmt.setString(4, catalog_code);
						} else 
						{ //pass the activity_type 
							pstmt.setString(4, activity_type);
						}	
						pstmt.setString(5, test_date_time);
						pstmt.setString(6, chk_for_dupl_behind_period);
						pstmt.setString(7, chk_for_dupl_behind_unit);
						pstmt.setString(8, test_date_time);
						pstmt.setString(9, test_date_time);
						pstmt.setString(10, chk_for_dupl_behind_period);
						pstmt.setString(11, chk_for_dupl_behind_unit);
						pstmt.setString(12, test_date_time);

						resultSet			= pstmt.executeQuery() ;
					
					} 
					else 
					{  // For Active
						// MO-CRF-20085 [IN051135] - IN060460 - Start
						if("C".equalsIgnoreCase(chk_for_dupl_status)){
							dupeCheckQuery = (OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_DUPLICATE_ACTIVITY_CHECK_DUPL_STAT_BEHIND_COMPLETED_DETAILS"));
						}
						else {
							dupeCheckQuery = (OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_DUPLICATE_ACTIVITY_CHECK_DUPL_STAT_BEHIND_ACTIVE_DETAILS"));
						}
						//pstmt				= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_DUPLICATE_ACTIVITY_CHECK_DUPL_STAT_BEHIND_ACTIVE_DETAILS"));
						pstmt				= connection.prepareStatement(dupeCheckQuery);
						// MO-CRF-20085 [IN051135] - IN060460 - End
						pstmt.setString(1,language_id);
						pstmt.setString(2,language_id);
						pstmt.setString(3, patient_id);
						if(checkForNull(check_for_dupl_level,"").equals("O"))
						{  //pass the catalog_code
							pstmt.setString(4, catalog_code);
						} else 
						{ //pass the activity_type 
							pstmt.setString(4, activity_type);
						}	
						pstmt.setString(5, test_date_time);
						pstmt.setString(6, chk_for_dupl_behind_period);
						pstmt.setString(7, chk_for_dupl_behind_unit);
						pstmt.setString(8, test_date_time);
						pstmt.setString(9, test_date_time);
						pstmt.setString(10, chk_for_dupl_behind_period);
						pstmt.setString(11, chk_for_dupl_behind_unit);
						pstmt.setString(12, test_date_time);

						resultSet			= pstmt.executeQuery() ;
					
				} 
			}
			if ( resultSet != null )
			{
				String[] record = null;
				while(resultSet.next())
				{
					record 	  = new String[6];
					record[0] = checkForNull(resultSet.getString( "start_date_time" ),"")  ;
					record[1] = checkForNull(resultSet.getString( "order_id" ),"")  ;
					record[2] = checkForNull(resultSet.getString( "catalog_desc" ),"")  ;
					record[3] = checkForNull(resultSet.getString( "pract_name" ),"")  ;
					record[4] = checkForNull(resultSet.getString( "order_status_desc" ),"")  ;
					record[5] = checkForNull(resultSet.getString( "end_date_time" ),"")  ;
					DuplicateDetails.add(record) ;
				}
			}
		}catch ( Exception e )	
		{

			e.printStackTrace() ;
			throw e ;
		} finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
		return DuplicateDetails;
	}	 // End of the getDuplicateBehindCheckDetails

		// For the Duplicate check, firing the query to display all the record details for the catalog and patient
	public ArrayList getDuplicateAheadCheckDetails(Properties properties, String patient_id, String catalog_code, String test_date_time, String activity_type, String chk_for_dupl_ahead_unit, String chk_for_dupl_ahead_period, String va_status , String chk_for_dupl_status,String check_for_dupl_level) throws Exception 
	{
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			String dupeCheckQuery 		= ""; // MO-CRF-20085 [IN051135] - IN060460	
			ArrayList DuplicateDetails	= new ArrayList() ;
			try
			{
				connection			= ConnectionManager.getConnection(properties) ;
				if(checkForNull(check_for_dupl_level,"").equals("O"))
				{
					if(!checkForNull(va_status,"N").equals("N") && checkForNull(chk_for_dupl_status,"N").equals("Z")) 
					{
						pstmt				= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_DUPLICATE_CHECK_DUPL_STAT_AHEAD_DETAILS"));
					} 
					else 
					{  // For Active
						
						// MO-CRF-20085 [IN051135] - IN060460 - Start
						if("C".equalsIgnoreCase(chk_for_dupl_status)){
							dupeCheckQuery = (OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_DUPLICATE_CHECK_DUPL_STAT_AHEAD_COMPLETED_DETAILS"));
						}
						else {
							dupeCheckQuery = (OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_DUPLICATE_CHECK_DUPL_STAT_AHEAD_ACTIVE_DETAILS"));
						}	
						//pstmt				= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_DUPLICATE_CHECK_DUPL_STAT_AHEAD_ACTIVE_DETAILS"));
						pstmt				= connection.prepareStatement(dupeCheckQuery);
							// MO-CRF-20085 [IN051135] - IN060460 - End
					} 
				} 
				else 
				{  //if activity type is there 
					if(!checkForNull(va_status,"N").equals("N") && checkForNull(chk_for_dupl_status,"N").equals("Z")) 
					{
						pstmt				= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_DUPLICATE_ACTIVITY_CHECK_DUPL_STAT_AHEAD_DETAILS"));
					} 
					else 
					{  // For Active
						// MO-CRF-20085 [IN051135] - IN060460 - Start
						if("C".equalsIgnoreCase(chk_for_dupl_status)){
							dupeCheckQuery = (OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_DUPLICATE_ACTIVITY_CHECK_DUPL_STAT_AHEAD_COMPLETED_DETAILS"));
						}
						else {
							dupeCheckQuery = (OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_DUPLICATE_ACTIVITY_CHECK_DUPL_STAT_AHEAD_ACTIVE_DETAILS"));
						}	
						//pstmt				= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_DUPLICATE_ACTIVITY_CHECK_DUPL_STAT_AHEAD_ACTIVE_DETAILS"));
						pstmt				= connection.prepareStatement(dupeCheckQuery);
						// MO-CRF-20085 [IN051135] - IN060460 - End
					} 
				}
					
				pstmt.setString(1,language_id);
				pstmt.setString(2,language_id);
				pstmt.setString(3, patient_id);
				/*if(checkForNull(activity_type,"").equals("")){  //pass the catalog_code
				pstmt.setString(4, catalog_code);
				} else { //pass the activity_type 
				pstmt.setString(4, activity_type);
				}Modified by Uma on 6/6/2009 for IN11222*/	
				if(checkForNull(check_for_dupl_level,"").equals("O"))
				{
					pstmt.setString(4, catalog_code);
				}
				else
				{
					pstmt.setString(4, activity_type);
				}
				pstmt.setString(5, test_date_time);				
				pstmt.setString(6, test_date_time);
				pstmt.setString(7, chk_for_dupl_ahead_period);
				pstmt.setString(8, chk_for_dupl_ahead_unit);
				pstmt.setString(9, test_date_time);
				pstmt.setString(10, test_date_time);
				pstmt.setString(11, chk_for_dupl_ahead_period);
				pstmt.setString(12, chk_for_dupl_ahead_unit);
				resultSet			= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())
					{
						record 	  = new String[6];
						record[0] = checkForNull(resultSet.getString( "start_date_time" ),"")  ;
						record[1] = checkForNull(resultSet.getString( "order_id" ),"")  ;
						record[2] = checkForNull(resultSet.getString( "catalog_desc" ),"")  ;
						record[3] = checkForNull(resultSet.getString( "pract_name" ),"")  ;
						record[4] = checkForNull(resultSet.getString( "order_status_desc" ),"")  ;
						record[5] = checkForNull(resultSet.getString( "end_date_time" ),"")  ;
						DuplicateDetails.add(record) ;
					}
				}
			}catch ( Exception e )	
			{

				e.printStackTrace() ;
				throw e ;
			} finally 
			{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}
			return DuplicateDetails;
	}	 // End of the getDuplicateCheckDetails

	// Population of the Activity type List Box in the Order Entry
 	public ArrayList getActivityType(Properties properties,  String order_category , String order_type_code) throws Exception {
 		Connection connection 		= null;
 		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String[] record				= null;
		ArrayList ActivityType		= new ArrayList();
 		try{
				connection			= ConnectionManager.getConnection(properties) ;
  
 				pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_ACTIVITY_TYPE_SELECT") ) ;
				pstmt.setString(1, language_id);
				pstmt.setString(2, order_category);
				pstmt.setString(3, order_type_code);

				//pstmt.setString(4, language_id);
				//pstmt.setString(5, order_category);
 				resultSet			= pstmt.executeQuery() ;
				if ( resultSet != null )   // Only One Record
				{
					while(resultSet.next())
					{
 						record	= new String[2];
						record[0] = checkForNull( resultSet.getString( "activity_type" ), "" );
						record[1] = checkForNull( resultSet.getString( "short_desc" ), "" );
						ActivityType.add(record) ;
					}
				}
 		}catch ( Exception e )	{

			e.printStackTrace() ;
			return null;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
		return ActivityType;
	}	 // End of the getActivitytype
 
	// Calling a procedure,to get the database user_id and password
 	public String getUserIdPassword(Properties properties, String user_id) throws Exception {
 		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String user_password		= "";
 		try{
  			    connection			= ConnectionManager.getConnection(properties) ;
				pstmt				= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_USER_ID_PASSWORD"));
 				pstmt.setString(1, user_id);
 				resultSet			= pstmt.executeQuery() ;
				if ( resultSet != null )   // Only One Record
				{
					while(resultSet.next())
					{
  						user_password = checkForNull( resultSet.getString( "password" ), "" );
  					}
				}
 			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			}  finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}
			return user_password;
	} // End of getUserIdPassword

// Calling a procedure, if RD is installed, before calling the RD appointment function
 	public String getJ2fInterface(Properties properties, String ws_no , String function_id, String j2_parameter, String session_id, String user_id, String facility_id, String responsibility_id) throws Exception {
 		Connection connection 		= null;
		CallableStatement cstmt 	= null;
		String error_message		= "";
 		try{
			    connection			= ConnectionManager.getConnection(properties) ;
				cstmt				= connection.prepareCall(OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_OT_INSTALL_J2FINTERFACE_CHECK_SESSION"));
				cstmt.clearParameters();
 				cstmt.setString(1, ws_no);		 //P_WS_NO
				cstmt.setString(2, function_id);	 //P_FUNCTION_ID
				cstmt.setString(3, checkForNull(j2_parameter,"")); //P_PARAMETER
				cstmt.setString(4, checkForNull(session_id,"")); //P_SESSION_ID
				cstmt.setString(5, checkForNull(user_id,"")); //P_USER_ID
				cstmt.setString(6, checkForNull(facility_id,"")); //P_FACILITY_ID
				cstmt.setString(7, checkForNull(responsibility_id,"")); //P_RESPONSIBILITY_ID
				cstmt.registerOutParameter( 8,  Types.VARCHAR ) ;
 				cstmt.execute();
				error_message= checkForNull(cstmt.getString(8),"");
 			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			}  finally {
 				closeStatement( cstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}
			return error_message;
	} // End of getJ2fInterface

	// For the Care Set Tab, to paint the result Screen.
 	//IN042045 practitioner_type
 	//public ArrayList getCareSetMatrix(String order_set_code,String time_frame, Properties properties, String facility_id,String encounter_id,String patient_class,String admission_date,String discharge_date_time)
	public ArrayList getCareSetMatrix(String order_set_code,String time_frame, Properties properties, String facility_id,String encounter_id,String patient_class,String admission_date,String discharge_date_time,String practitioner_type) throws Exception {
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	ArrayList CareSetMatrix		= new ArrayList() ;
	try{
			time_frame			= checkForNull(time_frame,"");
			connection			= ConnectionManager.getConnection(properties) ;
			if(time_frame.equals("M")) // If Matrix Radio Button has been selected and searched
			{
				//pstmt			= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CARE_SET_MATRIX")); //IN042045
				pstmt			= connection.prepareStatement("SELECT a.order_catalog_code order_catalog_code,or_get_desc.or_order_catalog (a.order_catalog_code, ?, '2') order_catalog_desc, a.order_category order_category,or_get_desc.or_order_category (a.order_category, ?, '2') order_category_desc,a.rel_start_date_time rel_start_date_time, reqd_or_opt_ind,b.freq_code freq_code,am_get_desc.am_frequency (b.freq_code, ?, '1') freq_desc,case when b.freq_code is not null then a.durn_value end as durn_value,case when b.freq_code is not null then a.durn_type  end as durn_type,CEIL (DECODE (rel_start_date_time, 0, 1, rel_start_date_time) / 24) no_days FROM or_order_set_component a,(SELECT a.freq_code freq_code, b.order_catalog_code,c.OCURRANCE_NUM FROM am_frequency a,or_freq_catalog_scope b,or_order_set_component c WHERE a.freq_code = b.freq_code AND b.order_catalog_code = c.order_catalog_code AND c.order_set_code = ? AND a.eff_status = 'E' order by 1) b WHERE a.order_set_code = ? AND 'Y' = or_get_access_rule (?, ?, a.order_category, ?, ?, ?,'','','','','','',a.order_catalog_code,?)  and a.OCURRANCE_NUM =b.OCURRANCE_NUM(+) AND a.freq_code = b.freq_code(+) ORDER BY CEIL (DECODE (a.rel_start_date_time, 0, 1, a.rel_start_date_time) / 24), order_set_seq_num");//IN042045
				pstmt.setString(1, language_id);
				pstmt.setString(2, language_id);
				pstmt.setString(3, language_id);
				pstmt.setString(4, checkForNull(order_set_code,""));
				pstmt.setString(5, checkForNull(order_set_code,""));
				pstmt.setString(6, checkForNull(facility_id,""));
				pstmt.setString(7, checkForNull(encounter_id,""));
				pstmt.setString(8, checkForNull(patient_class,""));
				pstmt.setString(9, checkForNull(admission_date,""));
				pstmt.setString(10, checkForNull(discharge_date_time,""));
				pstmt.setString(11, checkForNull(practitioner_type,""));//IN042045
				
			}
			else	// Other than the Matrix for the other radio buttons
			{
				//pstmt			= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CARE_SET_CODE"));	//IN042045
				pstmt			= connection.prepareStatement("SELECT a.order_catalog_code order_catalog_code,or_get_desc.or_order_catalog (a.order_catalog_code, ?, '2') order_catalog_desc,a.order_category order_category,or_get_desc.or_order_category (a.order_category, ?, '2') order_category_desc,a.rel_start_date_time rel_start_date_time, reqd_or_opt_ind,b.freq_code freq_code,am_get_desc.am_frequency (b.freq_code, ?, '1') freq_desc,case when b.freq_code is not null then a.durn_value end as durn_value,case when b.freq_code is not null then a.durn_type  end as durn_type,CEIL (DECODE (rel_start_date_time, 0, 1, rel_start_date_time) / 24) no_days FROM or_order_set_component a,(SELECT a.freq_code freq_code, b.order_catalog_code,c.OCURRANCE_NUM FROM am_frequency a,or_freq_catalog_scope b,or_order_set_component c WHERE a.freq_code = b.freq_code AND b.order_catalog_code = c.order_catalog_code AND c.order_set_code = ? AND a.eff_status = 'E' order by 1) b WHERE order_set_code = ? AND 'Y' =  or_get_access_rule (?, ?, a.order_category, ?, ?, ?,'','','','','','',a.order_catalog_code,?) AND a.freq_code = b.freq_code(+) AND a.order_catalog_code = b.order_catalog_code(+) and a.OCURRANCE_NUM =b.OCURRANCE_NUM(+) ORDER BY decode(?,'T',to_char(a.rel_start_date_time),'C',order_category_desc),a.rel_start_date_time,ORDER_SET_SEQ_NUM");//IN042045
				pstmt.setString(1, language_id);
                pstmt.setString(2, language_id);
				pstmt.setString(3, language_id);
				pstmt.setString(4, checkForNull(order_set_code,""));
				pstmt.setString(5, checkForNull(order_set_code,""));
				pstmt.setString(6, checkForNull(facility_id,""));
				pstmt.setString(7, checkForNull(encounter_id,""));
				pstmt.setString(8, checkForNull(patient_class,""));
				pstmt.setString(9, checkForNull(admission_date,""));
				pstmt.setString(10, checkForNull(discharge_date_time,""));
				pstmt.setString(11, checkForNull(practitioner_type,""));//IN042045
            	pstmt.setString(12, checkForNull(time_frame,""));
			}
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )
			{
				String[] record = null;
				while(resultSet.next())
				{
					record 	  = new String[10];
					record[0] = checkForNull(resultSet.getString( "order_catalog_code" ),"")  ;
					record[1] = checkForNull(resultSet.getString( "order_catalog_desc" ),"")  ;
					record[2] = checkForNull(resultSet.getString( "order_category_desc" ),"");
					record[3] = checkForNull(resultSet.getString( "rel_start_date_time" ),"") ;
					record[4] = checkForNull(resultSet.getString( "reqd_or_opt_ind" ),"") ;
					record[5] = checkForNull(resultSet.getString( "freq_code" ),"") ;
					record[6] = checkForNull(resultSet.getString( "freq_desc" ),"") ;
					record[7] = checkForNull(resultSet.getString( "durn_value" ),"") ;
					record[8] = checkForNull(resultSet.getString( "durn_type" ),"") ;
					record[9] = checkForNull(resultSet.getString( "no_days" ),"") ;

					CareSetMatrix.add(record) ;
				}
			}
		}catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
		return CareSetMatrix;
	}	 // End of the getCareSetMatrix

		// For the Care Set Tabs, to get the days and no of days
	public ArrayList getCareSetHeading(String order_set_code, Properties properties) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList CareSetHdg		= new ArrayList() ;
		try{
				connection			= ConnectionManager.getConnection(properties) ;
				pstmt				= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CARE_SET_DAYS"));
				pstmt.setString(1, checkForNull(order_set_code,""));
				resultSet			= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())
					{
						record 	  = new String[2];
						record[0] = checkForNull(resultSet.getString( "days_no" ),"")  ;
						record[1] = checkForNull(resultSet.getString( "no_days" ),"")  ;
						CareSetHdg.add(record) ;
					}
				}
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}
			return CareSetHdg;
	}	 // End of the getCareSetHeading

	// To populate the TickSheet Items in the Tick Sheet frame
	// In the modal window, on click of the panels, it will display the items
	//public ArrayList getPanelItems(Properties properties,String discr_msr_panel_id,String order_catalog_nature,String contr_msr_panel_id,String order_category, String facility_id,String encounter_id,String patient_class,String admission_date,String discharge_date_time,String catalog_code)//IN042045 
	public ArrayList getPanelItems(Properties properties,String discr_msr_panel_id,String order_catalog_nature,String contr_msr_panel_id,String order_category, String facility_id,String encounter_id,String patient_class,String admission_date,String discharge_date_time,String catalog_code,String pract_type) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		//String lab_install_yn		= "N",changed on 7/10/2007 for lab_install_yn logic change by uma 
		String rd_install_yn = "N";
		String labchk="";

		ArrayList PanelItems = new ArrayList() ;
		try{
				connection			= ConnectionManager.getConnection(properties) ;

				if(order_category.equalsIgnoreCase("LB")) // If the order_category is lab
				{

					String[] record = null;
					pstmt			= connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_PRIVILEGE_GROUP_GET_ORDERTYPE_CODE"));
					pstmt.setString(1, checkForNull(catalog_code,""));
					resultSet			= pstmt.executeQuery() ;
					if ( resultSet != null )
					{
					
						while(resultSet.next())
						{
							record 	  = new String[1];
							record[0] = checkForNull(resultSet.getString( "ORDER_TYPE_CODE" ),"")  ;

						}
				}


				labchk=getmoduleRL(catalog_code,order_category,record[0],facility_id,properties);					//lab_install_yn	= checkForNull(getFacilityModuleInstallYn("RL", facility_id,properties ),"N");changed on 7/10/2007 for lab_install_yn by uma

			   if (labchk==null)
			   {
					labchk="";
			   }
				}
				else if(order_category.equalsIgnoreCase("RD"))
				{
					rd_install_yn	= checkForNull(getFacilityModuleInstallYn("RD",facility_id,properties),"N");
				}

				//if(order_catalog_nature.equalsIgnoreCase("P") && lab_install_yn.equalsIgnoreCase("Y") && order_category.equalsIgnoreCase("LB")) // For Panels and if lab is installed changed on 7/10/2007 for lab_install_yn by uma
				if(order_catalog_nature.equalsIgnoreCase("P") && (checkForNull(labchk,"").equalsIgnoreCase("IBARL")) && order_category.equalsIgnoreCase("LB")) // For Panels and if lab is installed
				{
					pstmt			= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PANEL_LB_INSTAL"));
					pstmt.setString(1, checkForNull(contr_msr_panel_id.trim(),"")); //Pass the contr_msr_panel_id
				}
				else if(order_catalog_nature.equalsIgnoreCase("P") && rd_install_yn.equalsIgnoreCase("Y") && order_category.equalsIgnoreCase("RD")) // For Panels and if Radialogy is installed
				{
					pstmt			= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PANEL_RD_INSTAL"));
					pstmt.setString(1, checkForNull(contr_msr_panel_id.trim(),""));
					pstmt.setString(2, language_id); // IN061154
				}
				else if(order_catalog_nature.equalsIgnoreCase("P") ) // For Panels
				{
					pstmt			= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PANEL"));
					pstmt.setString(1, checkForNull(discr_msr_panel_id.trim(),""));
				}
				else // For CareSets
				{
					//pstmt			= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_ORDER_SET_PANELS"));//IN042045
					pstmt			= connection.prepareStatement("SELECT a.order_catalog_code discr_msr_id , OR_GET_DESC.OR_ORDER_CATALOG(a.order_catalog_code,?,'2') short_desc FROM or_order_set_component a WHERE order_set_code = ? AND ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,'','','','','','',a.order_catalog_code,?) )   ORDER BY order_set_seq_num");//IN042045
					pstmt.setString(1, language_id);
					pstmt.setString(2, checkForNull(discr_msr_panel_id.trim(),""));
					pstmt.setString(3, checkForNull(facility_id.trim(),""));
					pstmt.setString(4, checkForNull(encounter_id.trim(),""));
					pstmt.setString(5, checkForNull(patient_class.trim(),""));
					pstmt.setString(6, checkForNull(admission_date.trim(),""));
					pstmt.setString(7, checkForNull(discharge_date_time.trim(),""));
					pstmt.setString(8, checkForNull(pract_type.trim(),""));//IN042045
				}

				resultSet			= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())
					{
						record 	  = new String[2];
						record[0] = checkForNull(resultSet.getString( "discr_msr_id" ),"")  ;
						record[1] = checkForNull(resultSet.getString( "short_desc" ),"")  ;
						PanelItems.add(record) ;
					}
				}
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}
			return PanelItems;
	}	 // End of the getPanelItems

	// ******************************** Image ***************************************
	// For the Painting of the Hot spot Image
	public ArrayList getHotSpot(Properties properties, String image_id, String image_link_id, String order_category,String fpp_patient_yn) throws Exception {//IN072524
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList HotSpot= new ArrayList() ;
		String sql = "SELECT hotspot_pos, hotspot_name,hotspot_id,image_id,hotspot_xpos,hotspot_ypos FROM or_image_hotspot_lang_vw WHERE language_id=? and image_id = nvl(?,image_id) AND (hotspot_id,image_id) IN (SELECT hotspot_id,image_id FROM or_image_hotspot_link a WHERE image_link_id= nvl(?,image_link_id) and exists (SELECT 1 FROM or_order_catalog WHERE eff_status ='E' AND order_category = ? and image_link_id = a.image_link_id)) ##FPP_APPLICABLEYN## ORDER BY hotspot_pos";//IN072524
		try{
				connection			= ConnectionManager.getConnection(properties) ;
				//IN072524 Starts
				//pstmt				= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_HOT_SPOT_SELECT"));
				if("Y".equals(fpp_patient_yn)){
					sql=sql.replace("##FPP_APPLICABLEYN##"," AND FPP_YN='Y' ");
					pstmt				= connection.prepareStatement(sql);
				}
				else{
					sql=sql.replace("##FPP_APPLICABLEYN##"," AND (FPP_YN IS NULL OR FPP_YN = 'N') ");
					pstmt				= connection.prepareStatement(sql);
				}//IN072524 Ends
				pstmt.setString(1, language_id);
				pstmt.setString(2, image_id.trim());
				pstmt.setString(3, image_link_id);
				pstmt.setString(4, order_category);
				
				resultSet			= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())
					{
						record 	  = new String[6];
						record[0] = checkForNull(resultSet.getString( "hotspot_pos" ),"")  ;
						record[1] = checkForNull(resultSet.getString( "hotspot_name" ),"")  ;
						record[2] = checkForNull(resultSet.getString( "hotspot_id" ),"")  ;
						record[3] = checkForNull(resultSet.getString( "image_id"),"")  ;
						record[4] = checkForNull(resultSet.getString( "hotspot_xpos" ),"")  ;
						record[5] = checkForNull(resultSet.getString( "hotspot_ypos"),"")  ;
						HotSpot.add(record) ;
					}
				}
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}
			return HotSpot;
	}	 // End of the getHotSpot


	// For the Image Url and the list to be populated in the list box
	public ArrayList getImageLink(Properties properties,String image_id,String order_category,String fpp_patient_yn) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String sql = "SELECT distinct image_link_id,a.image_id image_id, image_url FROM or_image_hotspot_link a,or_image b,or_image_hotspot c WHERE a.image_id = b.image_id AND b.image_id = c.image_id AND a.HOTSPOT_ID = c.HOTSPOT_ID AND EXISTS (SELECT 'X' FROM or_order_catalog WHERE order_category = ? AND image_link_id = a.image_link_id  ) AND a.image_id = nvl(?,a.image_id) ##FPP_APPLICABLEYN## ORDER BY image_link_id";//IN072524
		ArrayList ImageList			= new ArrayList() ;
		try{
				connection			= ConnectionManager.getConnection(properties) ;
				//IN072524 Starts
				//pstmt				= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_IMAGE_SELECT"));
				if("Y".equals(fpp_patient_yn)){
					sql=sql.replace("##FPP_APPLICABLEYN##"," AND c.FPP_YN='Y' ");
					pstmt				= connection.prepareStatement(sql);
				}
				else{ 
					sql=sql.replace("##FPP_APPLICABLEYN##"," AND (c.FPP_YN IS NULL OR c.FPP_YN = 'N') ");
					pstmt				= connection.prepareStatement(sql);
				}//IN072524 Ends
				pstmt.setString(1, order_category.trim());
				pstmt.setString(2, image_id.trim());
 				resultSet			= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())
					{
						record 	  = new String[3];
						record[0] = checkForNull(resultSet.getString( "image_id" ),"")  ;
						record[1] = checkForNull(resultSet.getString( "image_link_id" ),"")  ;
						record[2] = checkForNull(resultSet.getString( "image_url" ),"")  ;
 						ImageList.add(record) ;
					}
				}
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}
			return ImageList;
	}	 // End of the getImageLink

	// Field Mnenonic to get the mother patient_id and mother patient_name if field_mnenonic is
	// NM_MOTHER_PATIENT_ID and NM_MOTHER_PATIENT_NAME
	public ArrayList getNMMotherPatientDetails(Properties properties, String patient_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList PatientDetails	= new ArrayList() ;
		try{
				connection			= ConnectionManager.getConnection(properties) ;
				pstmt				= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_NM_MOTHER_PAT_DETAILS"));
				pstmt.setString(1, patient_id);
 				resultSet			= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())
					{
						record 		= new String[2];
						record[0]	= checkForNull(resultSet.getString( "patient_id" ),"")  ;
						record[1]	= checkForNull(resultSet.getString( "patient_name" ),"")  ;
  						PatientDetails.add(record) ;
					}
				}
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}
			return PatientDetails;
	}	 // End of the getNMMotherPatientDetails

	// Query to get the referal_code for the New Born Patients
	public ArrayList getNewBornReferralDetails(Properties properties, String facility_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		ArrayList PatientDetails	= new ArrayList() ;
		try{
				connection			= ConnectionManager.getConnection(properties) ;
				pstmt				= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_ORDER_REFERRAL_CODE_SELECT"));
				pstmt.setString(1, facility_id);
 				resultSet			= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())
					{
						record 		= new String[1];
						record[0]	= checkForNull(resultSet.getString( "referral_code" ),"")  ;
  						PatientDetails.add(record) ;
 					}
				}
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}
			return PatientDetails;
	}	 // End of the getNMMotherPatientDetails


	// Called for OT Waiting List, if it is successful, commit it otherwise rollback and come
 	public String  callOTWaitingList(Properties properties, String login_user, String login_ws_no, String order_id) throws Exception {
		Connection connection 		= null;
		CallableStatement cstmt 	= null;
		String error_message		= ""; String status = "";
		try{
  			    connection			= ConnectionManager.getConnection(properties) ;
				connection.setAutoCommit( false ) ;
				cstmt				= connection.prepareCall(OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_OT_WAITLIST_ORDER"));
				cstmt.clearParameters();

  				cstmt.setString(1, order_id);			//P_ORDER_ID
				cstmt.setString(2, login_user);			//P_USER_ID
				cstmt.setString(3, login_ws_no); //P_WS_NO
 				cstmt.registerOutParameter( 4,  Types.VARCHAR ) ;
				cstmt.registerOutParameter( 5,  Types.VARCHAR ) ;
				cstmt.registerOutParameter( 6,  Types.VARCHAR  );

 				cstmt.execute();
				status			= checkForNull(cstmt.getString(4),"");
				//P_STATUS

				error_message	= checkForNull(cstmt.getString(5),"");
				
				//P_ERR_MSG


				if(status.equals("S"))	{	// that means successful, can proceed further
					error_message = "";
					connection.commit();
				} else if(status.equals("E")) {
					connection.rollback();
				}

 			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			}  finally {
 				closeStatement( cstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}
			return error_message;
	} // End of callOTWaitingList

	public int getPreOpDays(Properties properties, String pref_surgical_date , String admission_date) throws Exception {
 		int pre_op_days				= 0;
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		try{
			    connection			= ConnectionManager.getConnection(properties) ;
  				pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CALC_PRE_OP_DAYS"));
 				pstmt.setString(1, pref_surgical_date);   //FORMAT_ID
				pstmt.setString(2, admission_date);   //FORMAT_ID
  				resultSet	= pstmt.executeQuery() ;
				if(resultSet!=null){ // only one record
  				    while(resultSet.next()) { 
    					pre_op_days = resultSet.getInt(1);
			 		}	
				}
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			}  finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}
			return pre_op_days;
	} // End of getPreOpDays

	public int getSeqNo(Properties properties, String format_id , int seq_num, String field_mnemonic) throws Exception {
 		int max_seq_no				= 0;
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		try{
			    connection			= ConnectionManager.getConnection(properties) ;
  				pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_MAX_SEQ_NO"));
 				pstmt.setString(1, format_id);   //FORMAT_ID
				pstmt.setString(2, String.valueOf(seq_num));	 //seq_num
				pstmt.setString(3, checkForNull(field_mnemonic,"")); //field_mnemonic,
				resultSet	= pstmt.executeQuery() ;

				if(resultSet!=null){ // only one record
  				    while(resultSet.next()) { 
    					max_seq_no = resultSet.getInt("max_seq_no");
			 		}	
				}
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			}  finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}
			return max_seq_no;
	} // End of getSeqNo

	public Hashtable buildDummyHashTable(int seq_num, String order_type_code, String order_type_short_desc, String field_mnemonic) throws Exception {
 	 	Hashtable template			= null;
 		try{
  			  template				= new java.util.Hashtable();
			  template.put("field_mnemonic", "");
			  template.put("seq_num", String.valueOf(seq_num));
			  template.put("new_seq_num", new Integer(seq_num));
			  template.put("label_text", "");
			  template.put("accept_option", "");
			  template.put("field_type", "");
			  template.put("min_num_value", "");
			  template.put("max_num_value", "");
			  template.put("order_type_code", order_type_code);
			  template.put("order_type_short_desc", order_type_short_desc);
			  template.put("help_text", "");
			  template.put("discr_msr_id", "");
			  template.put("dependency_yn", "N");
			  template.put("single_or_multi"	,"");
			  template.put("parent_field_mnemonic", checkForNull(field_mnemonic,"")); // willbe used to take it in the bean
			  template.put("dflt_value", "");
			  template.put("field_values"	,"");
			  template.put("max_dependency_row", "0"); 
  			  template.put("field_mnemonic_action"	,""); //Will be null always here
			  template.put("field_action_msg"	,"");	  //Will be null always here
			  template.put("notify_yn"	,"N");			 //Will store it later, if dependency has the notification 
			  template.put("oth_dependency_yn"	,"N");	 //Will store it later
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			}  
			return template;
	} // End of buildDummyHashTable
	

//added on 08/05/07 by Hari

public HashMap getConsentDtl(Properties properties,String order_catalog_code) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		HashMap consent				= new HashMap() ;
		boolean isFixed				= true;
		int count = 0;
		try
		{
			connection		= ConnectionManager.getConnection(properties) ;
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_CONSENT_FORM_LINK") ) ;
			pstmt.setString( 1, language_id) ;
			pstmt.setString( 2, "" ) ;
			pstmt.setString( 3, "" ) ;
			pstmt.setString( 4, "" ) ;
			pstmt.setString( 5, "" ) ;
			pstmt.setString( 6, order_catalog_code.trim() ) ;
			
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) 
			{
			//	if (checkForNull(resultSet.getString( "CONSENT_FORM_LIST" ),"" ).equals("F"))
			//	{
					consent.put("consent_chk"+count,	 "Y");
					consent.put("consent_form_id"+count, checkForNull(resultSet.getString( "CONSENT_FORM_ID" ),""));
					consent.put("consent_stage"+count,	 checkForNull(resultSet.getString( "CONSENT_STAGE" ),""));
					consent.put("consent_form_desc"+count,	 checkForNull(resultSet.getString( "CONSENT_FORM_LABEL" ),""));
					count++;
			//	}
				//else -- Commented by Murthy - 15-05-2007
				//{
				//	isFixed	= false;
				//}
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;

			if (count == 0 && isFixed)
			{
				pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_CONSENT_FIXED") ) ;
				
				pstmt.setString( 1, order_catalog_code.trim() ) ;
				pstmt.setString( 2, language_id) ;
				resultSet = pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ) {
					if (checkForNull(resultSet.getString( "CONSENT_FORM_LIST" ),"" ).equals("F"))
					{
						consent.put("consent_chk"+count,	 "Y");
						consent.put("consent_form_id"+count, checkForNull(resultSet.getString( "CONSENT_FORM_ID" ),""));
						consent.put("consent_stage"+count,	 checkForNull(resultSet.getString( "CONSENT_STAGE" ),""));
						consent.put("consent_form_desc"+count,	 checkForNull(resultSet.getString( "CONSENT_FORM_LABEL" ),""));
						count++;
					}
					
				}
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}
			consent.put("count",	 count+"");
		}
		catch(Exception e)
		{

			e.printStackTrace();
			throw e;
		}
		finally
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
		return consent;
	}
	
public String getvalidDays(Properties properties, String start_date_value, String expected__transfuse_date_value) throws Exception {
			
		Connection connection 		= null;
		java.sql.CallableStatement cstmt 	= null;
		//ResultSet resultSet 		= null;
		String validdays_chk_yn	= "N";
		try{



				start_date_value 	= (start_date_value == null) ? "":start_date_value;
				expected__transfuse_date_value 	= (expected__transfuse_date_value == null) ? "":expected__transfuse_date_value;
				connection	= ConnectionManager.getConnection(properties) ;
				cstmt = connection.prepareCall( OrRepositoryExt.getOrKeyValue("SQL_OR_BT_CHECK_SPECIMEN_VALIDITY") ) ;
				cstmt.setString(1, start_date_value);
				cstmt.setString(2, expected__transfuse_date_value);
				cstmt.registerOutParameter(3, Types.VARCHAR );//valid
				cstmt.execute() ;
				validdays_chk_yn= checkForNull(cstmt.getString(3),"N"); 
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeStatement( cstmt ) ;
				closeConnection(connection);
			}

			return validdays_chk_yn;
} // End of valid days
public ArrayList getdonorrhesus() throws Exception 
{
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		ArrayList donorrhesus = new ArrayList();
		try
		  {
			connection  = getConnection();
			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_DONOR_RHESUS"));
			rs	  =pstmt.executeQuery();
			while(rs != null && rs.next())
			{
				String record[] = new String[2];
				record[0] = rs.getString("rhcode");
			    record[1] = rs.getString("rhdesc");
				donorrhesus.add(record);
			}
		}
		catch(Exception e){
				e.printStackTrace() ;
				throw e ;
				}finally { 
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}

		return donorrhesus;
		
}
public ArrayList getdonorblood() throws Exception 
{
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		ArrayList donorblood = new ArrayList();
		try
		  {
			connection  = getConnection();
			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_DONOR_BLOOD_GROUP"));
			rs	  =pstmt.executeQuery();
			while(rs != null && rs.next())
			{
				String record[] = new String[2];
				record[0] = rs.getString("bloodcode");
			    record[1] = rs.getString("blooddesc");
				donorblood.add(record);
			}
		}
		catch(Exception e){
				e.printStackTrace() ;
				throw e ;
				}finally { 
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}

		return donorblood;
		
}
public ArrayList getprescriptionremarks(String p_drug_code,String p_form_code,String  p_route_code,Properties properties) throws Exception 
{




		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		ArrayList prescriptionremarks = new ArrayList();
		try
		  {
			connection	= ConnectionManager.getConnection(properties) ;
			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_ORDER_ENTRY_FORMAT_PRESCRIPTION_REMARKS"));
			pstmt.setString(1,(String)p_drug_code.trim());
			pstmt.setString(2,(String)p_form_code.trim());
			pstmt.setString(3,(String)p_route_code.trim());
			pstmt.setString(4,language_id);
			rs	  =pstmt.executeQuery();
			while(rs != null && rs.next())
			{
				String record[] = new String[3];
				record[0] = rs.getString("REMARK_CODE");

			    record[1] = rs.getString("REMARK_DESC");

			    record[2] = rs.getString("REMARK_YN");

				prescriptionremarks.add(record);
			}
		}
		catch(Exception e){
				e.printStackTrace() ;
				throw e ;
				}finally { 
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}


		return prescriptionremarks;
		
}

public String getApptReqdYN(Properties properties, String order_catalog_code, String perf_dept_loc_code) throws Exception {
			
		Connection connection 		= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		
		String apptReqdYN	= "";
		try{

				order_catalog_code 	= (order_catalog_code == null) ? "":order_catalog_code;
				perf_dept_loc_code 	= (perf_dept_loc_code == null) ? "":perf_dept_loc_code;
				connection	= ConnectionManager.getConnection(properties) ;
				pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_PERFORMING_LOC_APPT_REQ_YN") ) ;
				pstmt.setString(1, order_catalog_code);
				pstmt.setString(2, perf_dept_loc_code);
				rs	  =pstmt.executeQuery();
				while(rs != null && rs.next())
				{
					apptReqdYN	=rs.getString("appt_yn");
				}
			}catch ( Exception e )	
			{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( rs ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			
			return apptReqdYN;
}//End Of getApptReqdYN

public String getRequestCommentDesc(Properties properties, String request_comment_code) throws Exception {
			
		Connection connection 		= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		
		String request_comment_desc	= "";
		try{

				request_comment_code 	= (request_comment_code == null) ? "":request_comment_code;
				connection	= ConnectionManager.getConnection(properties) ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_REQ_COMMENT_DETAILS") ) ;
				pstmt.setString(1, request_comment_code);
				rs	  =pstmt.executeQuery();
				while(rs != null && rs.next())
				{
					request_comment_desc	=rs.getString("description");
				}
			}catch ( Exception e )	
			{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( rs ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			
			return request_comment_desc;
}//End Of request_comment_desc

public ArrayList getExistingSecondaryOrders(Properties properties, String order_id) throws Exception {
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	ArrayList ExistingSecondaryOrders = new ArrayList() ;
	try{
			    connection			= ConnectionManager.getConnection(properties) ;
				pstmt				= connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_EXISTING_ORDER_SECONDARY_ORDER_SELECT"));
				
				pstmt.setString(1, language_id);
				pstmt.setString(2, order_id);
				pstmt.setString(3,language_id);
				pstmt.setString(4, order_id);
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())
					{
						record 	  = new String[4];
						record[0] = resultSet.getString( "start_date_time" )  ;
						record[1] = resultSet.getString( "description" );
						record[2] = resultSet.getString( "order_stage" );
						record[3] = resultSet.getString( "pri_sec_tasks_type" );
						ExistingSecondaryOrders.add(record) ;
					}
				}
		}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
		return ExistingSecondaryOrders;
	} // End of getExistingSecondaryOrders
	public String getDonorBloodDesc(Properties properties, String code, String field_mnemonic) throws Exception 
	{
			
		Connection connection 		= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		
		String BloodDesc	= "";
		try{

				code 	= (code == null) ? "":code;
				field_mnemonic 	= (field_mnemonic == null) ? "":field_mnemonic;
				
				connection	= ConnectionManager.getConnection(properties) ;
				if(field_mnemonic.equalsIgnoreCase("DONOR_BLOOD_GROUP"))
				{
					pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_TRANSPLANT_DONOR_BLOOD_GROUP_DESC") ) ;
				}
				else if(field_mnemonic.equalsIgnoreCase("DONOR_RHESUS"))
				{
					pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_TRANSPLANT_DONOR_RHESUS_DESC") ) ;
				}
				pstmt.setString(1, code);
				rs	  =pstmt.executeQuery();
				while(rs != null && rs.next())
				{
					BloodDesc	=rs.getString("description");
				}
			}catch ( Exception e )	
			{
				e.printStackTrace() ;
				throw e ;
			} finally 
			{
				closeResultSet( rs ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			
			return BloodDesc;
}//End Of request_comment_desc
public String getmoduleRL(String catalogcode,String categorycode,String ordertypecode,String facility_id,Properties properties) throws Exception 
	{
		
		Connection connection 		= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		String modname="";
		try
		  {
			connection			= ConnectionManager.getConnection(properties) ;
			if (connection != null)	
			{
			}
			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("OR_GET_INTERFACED_APPL"));
			pstmt.setString(1,(String)catalogcode.trim());
			pstmt.setString(2,(String)categorycode.trim());
			pstmt.setString(3,(String)ordertypecode.trim());
			pstmt.setString(4,(String)facility_id.trim());
			rs	  =pstmt.executeQuery();
			while(rs != null && rs.next())
			{	
				modname = rs.getString("modname");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e ;
		}finally 
		{ 
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return modname;		
	}
/*Added by Uma on 2/26/2010 for IN017828 PMG-CRF-587*/
	// To make Enable the Blood Product process if laboratory is installed(over riding the master in OR)
	public String getBloodProductProcessYn(Properties properties, String catalog_code) throws Exception 
	{
		Connection connection 		= null;
		CallableStatement cstmt 	= null;
		ResultSet resultSet 		= null;

		String  blood_product_process_yn		= ""; // It will be Optional
		try
		{
			connection			= ConnectionManager.getConnection(properties) ;
			String sql = (String)OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_BLOOD_PRODUCT_PROCESS_STATUS_YN");
			cstmt		= connection.prepareCall("{"+sql+"}");
			cstmt.setString(1, catalog_code );
			cstmt.registerOutParameter( 2,  Types.VARCHAR ) ; 
			cstmt.execute() ;
			blood_product_process_yn = cstmt.getString(2);
		}
		catch ( Exception e )	
		{

			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( cstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
			return blood_product_process_yn;
	}	 // End of the getBloodProductProcessYn
	/*Ends Here by Uma on 2/26/2010 for IN017828 PMG-CRF-587*/
	/*Added by Uma on 3/25/2010 for IN020184 to get the valid mother patient name*/
	public String getMotherPatientName(Properties properties,String mother_patient_id) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String mother_patient_name  = "";

		//String  blood_product_process_yn		= ""; // It will be Optional
		try
		{
			connection			= ConnectionManager.getConnection(properties) ;
			String sql = (String)OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_NM_MOTHER_PAT_DETAILS");
			pstmt		= connection.prepareStatement(sql);
			pstmt.setString(1 , mother_patient_id );
			resultSet = pstmt.executeQuery() ;
			while(resultSet!=null&&resultSet.next())
			{
				mother_patient_name = resultSet.getString("mother_patient_name")==null?"":resultSet.getString("mother_patient_name");
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
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
			return mother_patient_name;
	}	 // End of the getMotherPatientName
	/*Ends Here by Uma on 3/25/2010 for IN020184*/

	/*Added by Uma on 7/9/2010 for IN022474 to find whether the patient is discharged*/
	public String getAdtStatus(Properties properties,String encounter_id,String facility_id) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String adt_status  = "";
		
		try
		{
			connection			= ConnectionManager.getConnection(properties) ;
			String sql = (String)OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_PATIENT_DISCHARGED");
			pstmt		= connection.prepareStatement(sql);
			pstmt.setString(1 , encounter_id );
			pstmt.setString(2 , facility_id );
			resultSet = pstmt.executeQuery() ;
			while(resultSet!=null&&resultSet.next())
			{
				adt_status = resultSet.getString("adt_status")==null?"":resultSet.getString("adt_status");
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
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
			return adt_status;
	}	 // End of the getAdtStatus
	/*Ends Here by Uma on 7/9/2010 for IN022474*/
	
	/*Added by Uma on 12/17/2010*/
	public String getApptPromptYN(Properties properties,String order_category) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String prmpt_status  = "";
		
		try
		{
			connection			= ConnectionManager.getConnection(properties) ;
			String sql = "select prompt_for_appt_on_ord_yn from or_order_category where order_category=?";
			pstmt		= connection.prepareStatement(sql);
			pstmt.setString(1 , order_category );
			resultSet = pstmt.executeQuery() ;
			while(resultSet!=null&&resultSet.next())
			{
				prmpt_status = resultSet.getString("prompt_for_appt_on_ord_yn")==null?"N":resultSet.getString("prompt_for_appt_on_ord_yn");
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
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
			return prmpt_status;
	}	 // End of the getApptPromptYN
	/*Ends Here by Uma on 7/9/2010 for IN022474*/
	//--[IN029395] - Start
	public String getSurgDate(Properties properties) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String surg_date		= "";
		try{
  			   
			    connection			= ConnectionManager.getConnection(properties) ;
  				pstmt				= connection.prepareStatement( "select  TO_CHAR (SYSDATE + PREF_SURGERY_DATE_AHEAD, 'dd/mm/yyyy') surgery_date from or_param");
 				resultSet	= pstmt.executeQuery() ;
				if(resultSet!=null){ // only one record
  				    while(resultSet.next()) { 
    					surg_date = resultSet.getString("surgery_date");
			 		}	
				}
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			}  finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}
			return surg_date;
	}	 
	//--[IN029395] - End
	//Code Start for IN036351 - CRF160 
	
	public ArrayList getAllOrderCategoryCode(Properties properties) throws Exception {
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;

	ArrayList OrderCategory = new ArrayList() ;
	try{
			connection	= ConnectionManager.getConnection(properties) ;
			String sqlQry = "SELECT order_category, short_desc FROM or_order_category_lang_vw  WHERE language_id=?   ORDER BY short_desc";
			pstmt		= connection.prepareStatement( sqlQry) ; 
			pstmt.setString(1,language_id);
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )
			{
				String[] record	= null;
				while(resultSet.next())
				{
					record 	  = new String[2];
					record[0] = resultSet.getString( "order_category" )  ;
					record[1] = resultSet.getString( "short_desc" )  ;
					OrderCategory.add(record) ;
				}
			}
		}catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
		return OrderCategory;
	}	 // End of the getOrderCategory
	//IN029601 - Start
	public ArrayList getPHPregDtls(Properties properties,String patient_id, String encounter_id ) throws Exception {
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;

	ArrayList PregDtls = new ArrayList() ;
	try{
			connection	= ConnectionManager.getConnection(properties) ;
			//String sqlQry = "Select  PREGENANT_YN,LMP_DATE, ceil((to_date(SYSDATE,'dd/mm/yyyy') - to_date(LMP_DATE,'dd/mm/yyyy'))/7) WEEK from ca_patient_pregn_dtls where patient_id = ? and pregn_status_ind = 'A' ";
			//String sqlQry = "Select  PREGENANT_YN,LMP_DATE, ceil((to_date(SYSDATE,'dd/mm/yyyy') - to_date(LMP_DATE,'dd/mm/yyyy'))/7) WEEK from ca_patient_pregn_dtls where patient_id = ? and pregn_status_ind = 'A'   AND NVL (actu_delv_date, expd_delv_date) >= SYSDATE ";//IN040516
			String sqlQry = "Select  PREGENANT_YN,LMP_DATE, ceil((to_date(SYSDATE,'dd/mm/yyyy') - to_date(LMP_DATE,'dd/mm/yyyy'))/7) WEEK from ca_patient_pregn_dtls where patient_id = ? and pregn_status_ind = 'A'  ";//IN040683 //IN040685 
			pstmt		= connection.prepareStatement( sqlQry) ; 
			pstmt.setString(1,patient_id);
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )
			{
				String[] record	= null;
				while(resultSet.next())
				{
					record 	  = new String[3];
					record[0] = resultSet.getString( "PREGENANT_YN" )  ;
					record[1] = resultSet.getString( "LMP_DATE" )  ;
					record[2] = resultSet.getString( "WEEK" )  ;
					PregDtls.add(record) ;
				}
			}
		}catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
		return PregDtls;
	}	 // End of the getPHPregDtls
	public String getPHTrimDtls(Properties properties,String preg_stage ) throws Exception {
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	String TrimDtls = "";
	try{
			connection	= ConnectionManager.getConnection(properties) ;
			String sqlQry = "SELECT CASE  WHEN ? BETWEEN FIRST_TRIMSTER_START AND FIRST_TRIMSTER_END THEN '1'  WHEN  ? BETWEEN second_trimster_start AND second_trimster_end THEN '2' WHEN  ? BETWEEN third_trimster_start AND third_trimster_end THEN '3' else '0' END trimster FROM ph_param ";//IN040685 replace ' ' to '0'
			pstmt		= connection.prepareStatement( sqlQry) ; 
			pstmt.setString(1,preg_stage);
			pstmt.setString(2,preg_stage);
			pstmt.setString(3,preg_stage);
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )
			{
				while(resultSet.next())
				{
					TrimDtls 	  = resultSet.getString( "trimster" )  ;
				}
			}
		}catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
		return TrimDtls;
	}	 // End of the getPHTrimDtls
	public String getPHagechk(Properties properties,String patient_id ) throws Exception {
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	String AgeChk = "N";
	try{
			connection	= ConnectionManager.getConnection(properties) ;
			String sqlQry = "select 'Y' val from mp_param a,mp_patient b where b.patient_id = ? and b.sex = 'F' and (TO_CHAR (TRUNC (MONTHS_BETWEEN (sysdate, b.date_of_birth)/ 12))) between '12' and '65'";
			pstmt		= connection.prepareStatement( sqlQry) ; 
			pstmt.setString(1,patient_id);
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )
			{
				while(resultSet.next())
				{
					AgeChk 	  = resultSet.getString( "val" )  ;
				}
			}
		}catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
		return AgeChk;
	}	 // End of the getPHagechk
	public String getPHparamchk(Properties properties) throws Exception {
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	String ParamChk = "N";
	try{
			connection	= ConnectionManager.getConnection(properties) ;
			String sqlQry = "Select DISP_NO_PREG_DTL_YN from ph_param";
			pstmt		= connection.prepareStatement( sqlQry) ; 
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )
			{
				while(resultSet.next())
				{
					ParamChk 	  = resultSet.getString( "DISP_NO_PREG_DTL_YN" )  ;
				}
			}
		}catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
		return ParamChk;
	}	 // End of the getPHparamchk	
	//IN029601 - End
	//IN045798 - Start modified for IN047739   
	public ArrayList getMaxlistseq(String order_id, String field_mnemonic) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList seq_data = new ArrayList() ;

		try{
				connection	= ConnectionManager.getConnection(properties) ;
				String sqlQry = "select count(*) count, max(order_line_seq_num) seq from or_order_line_field_values where order_id = ? and order_line_field_mnemonic = ? ";
				pstmt		= connection.prepareStatement( sqlQry) ; 
				pstmt.setString(1,order_id);
				pstmt.setString(2,field_mnemonic);
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record	= null;
					while(resultSet.next())
					{
						record = new String[2];
						record[0] 	 = resultSet.getString( "count" )  ;
						record[1] 	 = resultSet.getString( "seq" )  ;	
						seq_data.add(record) ;
					}
				}
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}
			return seq_data;
		}		
	//IN045798//IN047739 - End
	//IN049124 - Start	
	public ArrayList getMaxlistseqH(String order_id, String field_mnemonic) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList seq_data = new ArrayList() ;

		try
		{
			connection	= ConnectionManager.getConnection(properties) ;
			String sqlQry = "select count(*) count, max(order_seq_num) seq from or_order_field_values where order_id = ? and ORDER_FIELD_MNEMONIC = ? ";
			pstmt		= connection.prepareStatement( sqlQry) ; 
			pstmt.setString(1,order_id);
			pstmt.setString(2,field_mnemonic);
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )
			{
				String[] record	= null;
				while(resultSet.next())
				{
					record = new String[2];
					record[0] 	 = resultSet.getString( "count" )  ;
					record[1] 	 = resultSet.getString( "seq" )  ;	
					seq_data.add(record) ;
				}
			}
		}catch ( Exception e )	
		{
			e.printStackTrace() ;
		} finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
		return seq_data;
	}
	//IN049124 - End	
//IN066055 starts
public HashMap getExtPHValidation(Properties properties,String patid,String encid,String user_id,String fac_id) throws Exception {
	Connection connection 		= null;
	PreparedStatement pstmt 	= null; 
	ResultSet resultSet 		= null;
//	String phExtUrl = "N";//51003
	int diag_count = 0;
	//String extFuncCalledFrom = "";//51003
	String discharge_status = "0";
	HashMap mapValues				= new HashMap();
	try{
			connection	= ConnectionManager.getConnection(properties) ;
			String diag_count_sql ="SELECT COUNT(1) DIAG_COUNT FROM   pr_diagnosis_enc_dtl a WHERE a.patient_Id = ? AND a.encounter_id = ? AND a.facility_id = ? AND a.status in ('A','R')";
			String discharge_count ="select oth_adt_status from pr_encounter where patient_id=? and encounter_id=? and facility_id = ?";
			pstmt		= connection.prepareStatement(diag_count_sql) ; 
			pstmt.setString(1,patid);
			pstmt.setString(2,encid);
			pstmt.setString(3,fac_id);

			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )
			{
				while(resultSet.next())
				{
					diag_count 	  =  Integer.parseInt(resultSet.getString( "DIAG_COUNT"));
				}
			}
			 if (resultSet != null)resultSet.close();//15950
			 if (pstmt != null)pstmt.close();//15950
			 
			if(diag_count> 0)
			{
				
					pstmt		= connection.prepareStatement(discharge_count) ; 
					pstmt.setString(1,patid);
					pstmt.setString(2,encid);
					pstmt.setString(3,fac_id);

					resultSet	= pstmt.executeQuery() ;
					if ( resultSet != null )
					{
						while(resultSet.next())
						{
							discharge_status 	  = resultSet.getString( "oth_adt_status" )==null ? "0" : resultSet.getString( "oth_adt_status" );
						}
					}
				
					mapValues.put("DISCHARGESTATUS",discharge_status);


			}else{
				mapValues.put("ERROR","Atleast one Diagnosis should be recorded");
			}

		}catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
		return mapValues;
	}	 // End of the getExtPHUrl	
public String getExtPHLink(Properties properties,String extFuncCalledFrom,String patid,String encid,String user_id) throws Exception{
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	String phExtLink = "";
	String l_req ="";
	try{
	connection	= ConnectionManager.getConnection(properties) ;

	if("PHIS_MEDICATION_ORDER".equals(extFuncCalledFrom))
		 l_req = "<FUNCTION_ID>"+extFuncCalledFrom+"$!^<PATIENT_ID>"+patid+"$!^<ENCOUNTER_ID>"+encid+"$!^<USER_ID>"+user_id+"$!^";
	else if("PHIS_DISCHARGE_MEDICATION".equals(extFuncCalledFrom))
		 l_req = "<FUNCTION_ID>"+extFuncCalledFrom+"$!^<PATIENT_ID>"+patid+"$!^<ENCOUNTER_ID>"+encid+"$!^<USER_ID>"+user_id+"$!^";
	else if("PHIS_DISPENSING".equals(extFuncCalledFrom))
		 l_req = "<FUNCTION_ID>"+extFuncCalledFrom+"$!^<USER_ID>"+user_id+"$!^";
	else if("PHIS_CLINICAL_SUMMARY".equals(extFuncCalledFrom))
		 l_req = "<FUNCTION_ID>"+extFuncCalledFrom+"$!^<PATIENT_ID>"+patid+"$!^<USER_ID>"+user_id+"$!^";
	else if("PHIS_MAR_GENERAL".equals(extFuncCalledFrom))
		 l_req = "<FUNCTION_ID>"+extFuncCalledFrom+"$!^<PATIENT_ID>"+patid+"$!^<ENCOUNTER_ID>"+encid+"$!^<USER_ID>"+user_id+"$!^";
	else if("PHIS_MAR".equals(extFuncCalledFrom))
		 l_req = "<FUNCTION_ID>"+extFuncCalledFrom+"$!^<PATIENT_ID>"+patid+"$!^<ENCOUNTER_ID>"+encid+"$!^<USER_ID>"+user_id+"$!^";

			String sqlQry = "select XHSELPHISURL.GET_PHIS_URL(?) exturl from dual";
			pstmt		= connection.prepareStatement(sqlQry) ; 
			pstmt.setString(1,l_req);
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )
			{
				while(resultSet.next())
				{
					phExtLink 	  = resultSet.getString( "exturl" )  ;
					
				}
			}
	}catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}
	return phExtLink;
}
//IN066055 ends
}// End of the class
