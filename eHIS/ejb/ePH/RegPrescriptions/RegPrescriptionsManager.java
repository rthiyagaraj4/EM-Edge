/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This file is saved on 29/10/2005.
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
04/13/2017      63877   		chithra      UnusedLocal variable
30/12/2020      8046   		Manickavasagam       PMG2020-ML-MMOH-CRF-0002
28/04/2021		17329 		Manickavasagam	 ML-MMOH-SCF-1791
---------------------------------------------------------------------------------------------------------------
*/
package ePH.RegPrescriptions ;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;
import javax.ejb.* ;
import ePH.Common.PhEJBSessionAdapter ;

/**
*
* @ejb.bean
*	name="RegPrescriptions"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="RegPrescriptions"
*	local-jndi-name="RegPrescriptions"
*	impl-class-name="ePH.RegPrescriptions.RegPrescriptionsManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.RegPrescriptions.RegPrescriptionsLocal"
*	remote-class="ePH.RegPrescriptions.RegPrescriptionsRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.RegPrescriptions.RegPrescriptionsLocalHome"
*	remote-class="ePH.RegPrescriptions.RegPrescriptionsHome"
*	generate= "local,remote"
*
*
*/ 

public class RegPrescriptionsManager extends PhEJBSessionAdapter {

	Properties prop=null;
	String SQL_PH_REG_PRESCRIPTIONS_SELECT14 = "";
	String SQL_PH_REG_PRESCRIPTIONS_SELECT15 = "";
	String SQL_PH_RELEASE_BATCHES_SELECT8  = "";
	String SQL_PH_REG_PRESCRIPTIONS_SELECT25=	 "";//added for Bru-HIMS-CRF-142 [IN:030195]
	// insert method starts here
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/    
	public HashMap insert( HashMap tabData, HashMap sqlMap )  {
		
	//	StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;			
		return map ;
	}
	// insert method ends here


	//  modify method starts here
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap modify( HashMap tabData, HashMap sqlMap )  {

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		
		//final String SQL_PH_REG_PRESCRIPTIONS_UPDATE_OR_ORDER		= (String) sqlMap.get( "SQL_PH_REG_PRESCRIPTIONS_UPDATE_OR_ORDER" );


		final String SQL_PH_REG_PRESCRIPTIONS_UPDATE_OR_ORDER		= "UPDATE OR_ORDER SET ORDER_STATUS = ?,MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE ORDER_ID = ?" ;

		final String SQL_PH_REG_PRESCRIPTIONS_UPDATE_OR_ORDER_LINE  = (String) sqlMap.get( "SQL_PH_REG_PRESCRIPTIONS_UPDATE_OR_ORDER_LINE" );
					 SQL_PH_RELEASE_BATCHES_SELECT8				= (String) sqlMap.get( "SQL_PH_RELEASE_BATCHES_SELECT8" );
		String SQL_PH_REG_PRESCRIPTIONS_UPDATE_TOKEN_SERIES = "";
		String SQL_PH_REG_PRESCRIPTIONS_INSERT_DISP_QUEUE = "";
		String SQL_PH_REG_PRESCRIPTIONS_UPDATE_DISP_QUEUE_SUMM = "";
		String SQL_PH_REG_PRESCRIPTIONS_INSERT_DISP_QUEUE_SUMM = "";
		String SQL_PH_REG_PRESCRIPTIONS_INSERT_ORD_FOR_DISP_QUEUE = "";
		String SQL_PH_REG_PRESCRIPTIONS_SELECT24	="";
		String SQL_PH_REG_PRESCRIPTIONS_INSERT_DISP_QUEUE1 = "";//added for Bru-HIMS-CRF-142 [IN:030195]
		String SQL_PH_REG_PRESCRIPTIONS_INSERT_DISP_QUEUE2 = "";//added for Bru-HIMS-CRF-142 [IN:030195]

		//String SQL_PH_REG_PRESCRIPTIONS_UPDATE_DISP_QUEUE = "";
		
		if (((String)tabData.get("identity")).equals("issuetoken")){
			SQL_PH_REG_PRESCRIPTIONS_UPDATE_TOKEN_SERIES	= (String) sqlMap.get( "SQL_PH_REG_PRESCRIPTIONS_UPDATE_TOKEN_SERIES");
			SQL_PH_REG_PRESCRIPTIONS_SELECT15				= (String) sqlMap.get( "SQL_PH_REG_PRESCRIPTIONS_SELECT15" );
			SQL_PH_REG_PRESCRIPTIONS_INSERT_DISP_QUEUE		= (String) sqlMap.get( "SQL_PH_REG_PRESCRIPTIONS_INSERT_DISP_QUEUE");
			SQL_PH_REG_PRESCRIPTIONS_SELECT14				= (String) sqlMap.get( "SQL_PH_REG_PRESCRIPTIONS_SELECT14");
			SQL_PH_REG_PRESCRIPTIONS_UPDATE_DISP_QUEUE_SUMM = (String) sqlMap.get( "SQL_PH_REG_PRESCRIPTIONS_UPDATE_DISP_QUEUE_SUMM");
			SQL_PH_REG_PRESCRIPTIONS_INSERT_DISP_QUEUE_SUMM = (String) sqlMap.get( "SQL_PH_REG_PRESCRIPTIONS_INSERT_DISP_QUEUE_SUMM");
			SQL_PH_REG_PRESCRIPTIONS_INSERT_ORD_FOR_DISP_QUEUE = (String) sqlMap.get( "SQL_PH_REG_PRESCRIPTIONS_INSERT_ORD_FOR_DISP_QUEUE");
			SQL_PH_REG_PRESCRIPTIONS_SELECT24 = (String) sqlMap.get( "SQL_PH_REG_PRESCRIPTIONS_SELECT24");
			SQL_PH_REG_PRESCRIPTIONS_SELECT25				= (String) sqlMap.get( "SQL_PH_REG_PRESCRIPTIONS_SELECT25" );//added for Bru-HIMS-CRF-142 [IN:030195]
			SQL_PH_REG_PRESCRIPTIONS_INSERT_DISP_QUEUE1		= (String) sqlMap.get( "SQL_PH_REG_PRESCRIPTIONS_INSERT_DISP_QUEUE1");//added for Bru-HIMS-CRF-142 [IN:030195]
			SQL_PH_REG_PRESCRIPTIONS_INSERT_DISP_QUEUE2		= (String) sqlMap.get( "SQL_PH_REG_PRESCRIPTIONS_INSERT_DISP_QUEUE2");//added for Bru-HIMS-CRF-142 [IN:030195]
			//SQL_PH_REG_PRESCRIPTIONS_UPDATE_DISP_QUEUE="UPDATE ph_disp_queue set patient_id=? ,encounter_id =?,COLLECTOR_NAME=?, COLLECTOR_NATIONALITY=?,COLLECTOR_GENDER=? WHERE disp_locn_code=? AND facility_id=? AND queue_date =TRUNC(SYSDATE) and queue_shift='*ALL' AND token_series_code=? AND token_serial_no=?";
		}
							  prop      = (Properties)tabData.get( "properties" );			            
		String		login_by_id			= (String)tabData.get("login_by_id");
		String		login_at_ws_no		= (String)tabData.get("login_at_ws_no");
		String		login_facility_id	= (String)tabData.get("login_facility_id");
		Hashtable	modifyData			= (Hashtable)tabData.get("ModifyData");
		
		Connection connection = null ;
		PreparedStatement pstmt_update=null,pstmt_update1 = null,pstmt_update2 = null,pstmt_update2A = null,pstmt_update3 = null;//pstmt_update4 = null ; Unused local variable INC63877
		PreparedStatement pstmt_insert = null,pstmt_select=null;//pstmt_select_1=null,pstmt_select_2=null;
		ResultSet resultSet = null ;
		try {
			connection = getConnection( prop ) ;
			// Update the table OR_ORDER,OR_ORDER_LINE
			pstmt_update1 = connection.prepareStatement( SQL_PH_REG_PRESCRIPTIONS_UPDATE_OR_ORDER ) ;

			//int pendingPrecriptions=0;

			pstmt_update2  = connection.prepareStatement( SQL_PH_REG_PRESCRIPTIONS_UPDATE_OR_ORDER_LINE ) ;
			pstmt_update2A = connection.prepareStatement( SQL_PH_REG_PRESCRIPTIONS_UPDATE_OR_ORDER_LINE +" AND ORDER_LINE_NUM=?" ) ;
           // if (((String)tabData.get("identity")).equals("issuetoken")){
				//pstmt_update4  = connection.prepareStatement( SQL_PH_REG_PRESCRIPTIONS_UPDATE_DISP_QUEUE ) ;
			//}
			//or_order_line updation
			Enumeration v=modifyData.keys();
			String order_id ;
			ArrayList arrListOrderLine;
			while (v.hasMoreElements() ) {
				order_id				= (String)v.nextElement();
				arrListOrderLine  = (ArrayList)modifyData.get(order_id.trim());
				
				if (arrListOrderLine.contains("*ALL")){
					pstmt_update2.setString(1,login_by_id.trim());
					pstmt_update2.setString(2,login_at_ws_no.trim());
					pstmt_update2.setString(3,login_facility_id.trim());
					pstmt_update2.setString(4,order_id.trim());
					// add the statement to the batch to update OR_ORDER_LINE
					pstmt_update2.addBatch();				
				}
				else{
					
					int number_of_prescriptions=0;
					for (int i=0;i<arrListOrderLine.size() ; i++){
						pstmt_update2A.setString(1,login_by_id.trim());
						pstmt_update2A.setString(2,login_at_ws_no.trim());
						pstmt_update2A.setString(3,login_facility_id.trim());
						pstmt_update2A.setString(4,order_id.trim());
						pstmt_update2A.setString(5,((String)arrListOrderLine.get(i)).trim());
						// add the statement to the batch to update OR_ORDER_LINE
						pstmt_update2A.addBatch();
						number_of_prescriptions++;
					}					
				}
			}
			int result2[]= pstmt_update2.executeBatch();
			for (int i=0;i<result2.length ;i++ ){
				// A number greater than or equal to zero  indicates success
				// A number -2 indicates that command is successful but number of rows updated is unknow
				// If it won't satisfy any of the above cancel the statement and throw an exception
				if(result2[i]<0  && result2[i] != -2 ){
					pstmt_update2.cancel();
					throw new EJBException("Updation Failed");
				}			
	   		}
			int result2A[]= pstmt_update2A.executeBatch();
			for (int i=0;i<result2A.length ;i++ ){
				// A number greater than or equal to zero  indicates success
				// A number -2 indicates that command is successful but number of rows updated is unknow
				// If it won't satisfy any of the above cancel the statement and throw an exception
				if(result2A[i]<0  && result2A[i] != -2 ){
					pstmt_update2A.cancel();
					throw new EJBException("Updation Failed");
				}			
	   		}

			//or_order updation
            Enumeration e = modifyData.keys();
			while (e.hasMoreElements() ) {
				//pstmt_update1.setString(1,login_by_id.trim());
				//pstmt_update1.setString(2,login_at_ws_no.trim());
				//pstmt_update1.setString(3,login_facility_id.trim());
				order_id = (String)e.nextElement();
				pstmt_update1.setString(1,getNumberOfPrescriptions(connection,order_id.trim(),login_facility_id.trim())); 
				pstmt_update1.setString(2,login_by_id.trim());
				pstmt_update1.setString(3,login_at_ws_no.trim());
				pstmt_update1.setString(4,login_facility_id.trim());
				pstmt_update1.setString(5,order_id.trim());	
				// add the statement to the batch to update OR_ORDER ...
				pstmt_update1.addBatch();	
				
			}
			int result1[]= pstmt_update1.executeBatch();
			for (int i=0;i<result1.length ;i++ ){
			// A number greater than or equal to zero  indicates success
			// A number -2 indicates that command is successful but number of rows updated is unknow
			// If it won't satisfy any of the above cancel the statement and throw an exception
				if(result1[i]<0  && result1[i] != -2 ){
					pstmt_update1.cancel();
					throw new EJBException("Updation Failed");
				}			
			}
        	closeStatement(pstmt_update1);
			closeStatement(pstmt_update2);
			closeStatement(pstmt_update2A);
			String next_token_series_no ="";
			String temp_token_series_no="";//added for Bru-HIMS-CRF-142 [IN:030195]
            String dummy_series = "N";//added for Bru-HIMS-CRF-142 [IN:030195]
			String allow_yn				="Y";

			if (((String)tabData.get("identity")).equals("issuetoken")){

				String disp_locn_code	 = (String)tabData.get("disp_locn_code");
				String token_series_code = (String)tabData.get("token_series_code");
				String patient_id		 = (String)tabData.get("patient_id");
				String pat_coll_med		 = (String)tabData.get("pat_coll_med");
				String collector_name	 = (String)tabData.get("collector_name");
				if(collector_name.length()>40){
					collector_name = collector_name.substring(0,39);
				}
				String collector_nationality	= (String)tabData.get("collector_nationality");
				String collector_gender			= (String)tabData.get("collector_gender");
				String encounter_id				= (String)tabData.get("encounter_id");
				String no_of_selected_orders	= (String)tabData.get("no_of_selected_orders");
				String generatetoken_yn			= (String)tabData.get("generatetoken_yn");
				//added for Bru-HIMS-CRF-142 [IN:030195] -Start
				String patient_arrived			= (String)tabData.get("patient_arrived");
				String generate_actual_token_yn = (String)tabData.get("generate_actual_token_yn");

				if(generate_actual_token_yn.equals("N") && patient_arrived.equals("N")) {
					dummy_series = "Y";
					if(generatetoken_yn.equals("Y")){
						temp_token_series_no=getTempTokenSeriesNo(login_facility_id,disp_locn_code,token_series_code);
					}
					else{
						temp_token_series_no=(String)tabData.get("token_no");
					}
				}
				else{
					//adding end for Bru-HIMS-CRF-142 [IN:030195] -End		
					if(generatetoken_yn.equals("N")){
						next_token_series_no=(String)tabData.get("token_no");
						
						pstmt_select = connection.prepareStatement( SQL_PH_REG_PRESCRIPTIONS_SELECT24 );
						pstmt_select.setString(1,login_facility_id.trim());
						pstmt_select.setString(2,disp_locn_code.trim());
						pstmt_select.setString(3,token_series_code.trim());
						pstmt_select.setString(4,next_token_series_no+"");
						resultSet = pstmt_select.executeQuery() ;
						if ( resultSet != null && resultSet.next() ) {                        
						   if(resultSet.getInt("count") >0){
								allow_yn="N";
						   }
						   else{
								allow_yn="Y";
						   }
						}
					}
					else{
						allow_yn="Y";
					}
				}
				if(encounter_id==null || encounter_id.equals("null")){
					encounter_id	=	"11111";
				}
				if(allow_yn.equals("Y")) {   
					if(generatetoken_yn.equals("Y")){
						if(dummy_series.equals("N")){// if condition added for Bru-HIMS-CRF-142 [IN:030195] 
							next_token_series_no = getNextTokenSeriesNo(connection,login_facility_id,(String)tabData.get("disp_locn_code"),(String)tabData.get("token_series_code"),(String)tabData.get("language_id") );
							//Update Token Series...
							pstmt_update3 = connection.prepareStatement( SQL_PH_REG_PRESCRIPTIONS_UPDATE_TOKEN_SERIES ) ;
							pstmt_update3.setString(1,login_by_id.trim());
							pstmt_update3.setString(2,login_at_ws_no.trim());
							pstmt_update3.setString(3,login_facility_id.trim());
							pstmt_update3.setString(4,login_facility_id.trim());
							pstmt_update3.setString(5,disp_locn_code.trim());
							pstmt_update3.setString(6,token_series_code.trim());
							pstmt_update3.executeUpdate();
							closeStatement(pstmt_update3);
					   }
					}
					//insert into PH_DISP_QUEUE
					//added for Bru-HIMS-CRF-142 [IN:030195] -Start
					if(dummy_series.equals("Y")){
						pstmt_insert = connection.prepareStatement( SQL_PH_REG_PRESCRIPTIONS_INSERT_DISP_QUEUE ) ;
						pstmt_insert.setString(1,login_facility_id.trim());	
						pstmt_insert.setString(2,(disp_locn_code).trim());	
						pstmt_insert.setString(3,(token_series_code).trim());	
						pstmt_insert.setString(4,temp_token_series_no.trim());	
						pstmt_insert.setString(5,no_of_selected_orders);	
						pstmt_insert.setString(6,patient_id.trim());	
						pstmt_insert.setString(7,pat_coll_med.trim());	
						pstmt_insert.setString(8,collector_name.trim());
						pstmt_insert.setString(9,collector_nationality.trim());		
						pstmt_insert.setString(10,encounter_id.trim());	
						pstmt_insert.setString(11,login_by_id.trim());	
						pstmt_insert.setString(12,login_at_ws_no.trim());	
						pstmt_insert.setString(13,login_facility_id.trim());	
						pstmt_insert.setString(14,login_by_id.trim());			
						pstmt_insert.setString(15,login_at_ws_no.trim());			
						pstmt_insert.setString(16,login_facility_id.trim());
						pstmt_insert.setString(17,collector_gender.trim());	
						pstmt_insert.setString(18,"RG");
						pstmt_insert.setString(19,patient_arrived.trim());	
						pstmt_insert.setString(20,temp_token_series_no.trim());	
					}
					else{
						if(patient_arrived.equals("N"))
							pstmt_insert = connection.prepareStatement( SQL_PH_REG_PRESCRIPTIONS_INSERT_DISP_QUEUE1 ) ;
						else
							pstmt_insert = connection.prepareStatement( SQL_PH_REG_PRESCRIPTIONS_INSERT_DISP_QUEUE2 ) ;
						//added for Bru-HIMS-CRF-142 [IN:030195] -End
						pstmt_insert.setString(1,login_facility_id.trim());	
						pstmt_insert.setString(2,(disp_locn_code).trim());	
						pstmt_insert.setString(3,(token_series_code).trim());	
						pstmt_insert.setString(4,next_token_series_no.trim());	
						pstmt_insert.setString(5,no_of_selected_orders);	
						pstmt_insert.setString(6,patient_id.trim());	
						pstmt_insert.setString(7,pat_coll_med.trim());	
						pstmt_insert.setString(8,collector_name.trim());
						pstmt_insert.setString(9,collector_nationality.trim());		
						pstmt_insert.setString(10,encounter_id.trim());	
						pstmt_insert.setString(11,login_by_id.trim());	
						pstmt_insert.setString(12,login_at_ws_no.trim());	
						pstmt_insert.setString(13,login_facility_id.trim());	
						pstmt_insert.setString(14,login_by_id.trim());			
						pstmt_insert.setString(15,login_at_ws_no.trim());			
						pstmt_insert.setString(16,login_facility_id.trim());
						pstmt_insert.setString(17,collector_gender.trim());	
						//pstmt_insert.setString(18,"RG");	//Commented for Bru-HIMS-CRF-142 [IN:030195]
						pstmt_insert.setString(18,patient_arrived.trim());//added for Bru-HIMS-CRF-142 [IN:030195]
					}
					pstmt_insert.executeUpdate();
					closeStatement(pstmt_insert);

					//insert or update into PH_DISP_QUEUE_SUMM
					// if 0 - insert ,if 1 - update
				
					int insertUpdateFlag = validateForInsertUpdate(login_facility_id,(String)tabData.get("disp_locn_code"),(String)tabData.get("token_series_code"));
				
					if (insertUpdateFlag==0){
						pstmt_insert = connection.prepareStatement( SQL_PH_REG_PRESCRIPTIONS_INSERT_DISP_QUEUE_SUMM) ;
						pstmt_insert.setString(1,login_facility_id.trim());
						pstmt_insert.setString(2,disp_locn_code.trim());
						pstmt_insert.setString(3,token_series_code.trim());
						pstmt_insert.setString(4,login_by_id.trim());
						pstmt_insert.setString(5,login_at_ws_no.trim());
						pstmt_insert.setString(6,login_facility_id.trim());
						pstmt_insert.setString(7,login_by_id.trim());
						pstmt_insert.setString(8,login_at_ws_no.trim());
						pstmt_insert.setString(9,login_facility_id.trim());
						pstmt_insert.executeUpdate();
						closeStatement(pstmt_insert);
					}
					else {
						pstmt_update = connection.prepareStatement( SQL_PH_REG_PRESCRIPTIONS_UPDATE_DISP_QUEUE_SUMM ) ;
						pstmt_update.setString(1,login_by_id.trim());
						pstmt_update.setString(2,login_at_ws_no.trim());
						pstmt_update.setString(3,login_facility_id.trim());
						pstmt_update.setString(4,login_facility_id.trim());
						pstmt_update.setString(5,disp_locn_code.trim());
						pstmt_update.setString(6,token_series_code.trim());
						pstmt_update.executeUpdate();
						closeStatement(pstmt_update);
					}
					// insert into PH_ORD_FOR_DISP_QUEUE
					Enumeration v1=modifyData.keys();
					order_id = "";
					//String pat_id   = "";
					
					pstmt_insert = connection.prepareStatement( SQL_PH_REG_PRESCRIPTIONS_INSERT_ORD_FOR_DISP_QUEUE ) ;

					//pstmt_select_1 = connection.prepareStatement( "SELECT patient_id,encounter_id FROM or_order WHERE order_id=?" );
					//pstmt_select_2 = connection.prepareStatement( "SELECT country_code,PATIENT_NAME,a.SEX FROM mp_patient a,mp_country b WHERE patient_id=? AND a.NATIONALITY_CODE = b.COUNTRY_CODE(+)");
					while (v1.hasMoreElements() ) {
				//added for PMG2020-ML-MMOH-CRF-0002 - start
					order_id				= (String)v1.nextElement();
					arrListOrderLine  = (ArrayList)modifyData.get(order_id.trim());

					if (arrListOrderLine.contains("*ALL")){	
						arrListOrderLine = getOrderLineDetails(order_id);//added for ML-MMOH-SCF-1791.1
					}

					for (int i=0;i<arrListOrderLine.size() ; i++){
					//added for PMG2020-ML-MMOH-CRF-0002 - end
						pstmt_insert.setString(1,login_facility_id.trim());
						pstmt_insert.setString(2,disp_locn_code.trim());
						pstmt_insert.setString(3,token_series_code.trim());
						//pstmt_insert.setString(4,next_token_series_no.trim()); //Commented for Bru-HIMS-CRF-142 [IN:030195]
						
						if(dummy_series.equals("Y")) //if block and else condition added for Bru-HIMS-CRF-142 [IN:030195] 
							pstmt_insert.setString(4,temp_token_series_no.trim());
						else
							pstmt_insert.setString(4,next_token_series_no.trim());
						/*
						order_id	= ((String)v1.nextElement()).trim();

						pstmt_select_1.setString(1,order_id);
						resultSet   = pstmt_select_1.executeQuery();
						if ( resultSet != null && resultSet.next() ) { 
							patient_id   = resultSet.getString("patient_id");
							encounter_id = resultSet.getString("encounter_id");
							if(encounter_id==null || encounter_id.equals("")){
								encounter_id	=	"11111";
							}
						}
						resultSet=null;

						if(pat_coll_med.equals("Y")){
							  pstmt_select_2.setString(1,patient_id);
							  resultSet   = pstmt_select_2.executeQuery();
							  if ( resultSet != null && resultSet.next() ) { 
									collector_nationality   = resultSet.getString("country_code");
									collector_name			= resultSet.getString("PATIENT_NAME");
									collector_gender		= resultSet.getString("SEX");
									
							  }
							 
						}*/
						  
						pstmt_insert.setString(5,order_id.trim());
						pstmt_insert.setString(6,patient_id.trim());
						pstmt_insert.setString(7,login_by_id.trim());
						pstmt_insert.setString(8,login_at_ws_no.trim());
						pstmt_insert.setString(9,login_facility_id.trim());
						pstmt_insert.setString(10,login_by_id.trim());
						pstmt_insert.setString(11,login_at_ws_no.trim());
						pstmt_insert.setString(12,login_facility_id.trim());
						pstmt_insert.setString(13,((String)arrListOrderLine.get(i)).trim());//added for PMG2020-ML-MMOH-CRF-0003
						pstmt_insert.setString(14,"RG");//added for PMG2020-ML-MMOH-CRF-0003

						pstmt_insert.addBatch();
					}
					   /* pstmt_update4.setString(1,patient_id.trim());
						pstmt_update4.setString(2,encounter_id.trim());
						pstmt_update4.setString(3,collector_name.trim());
						pstmt_update4.setString(4,collector_nationality.trim());
						pstmt_update4.setString(5,collector_gender.trim());
						pstmt_update4.setString(6,disp_locn_code.trim());
						pstmt_update4.setString(7,login_facility_id.trim());
						pstmt_update4.setString(8,token_series_code.trim());
						pstmt_update4.setString(9,next_token_series_no.trim());
						pstmt_update4.executeUpdate();*/
					}

					int result[]= pstmt_insert.executeBatch();
					// A number greater than or equal to zero  indicates success
					// A number -2 indicates that command is successful but number of rows updated is unknow
					// If it won't satisfy any of the above cancel the statement and throw an exception
					for (int i=0;i<result.length ;i++ ){
						if(result[i]<0  && result[i] != -2 ){
							pstmt_insert.cancel();
							throw new EJBException("Insert Failed");
						}			
					}
					closeStatement(pstmt_insert);
				}
				else{
					connection.rollback();
				}
			}	
	
			if( allow_yn.equals("Y")){
				connection.commit();
				map.put( "result", new Boolean( true ) ) ;				
				map.put( "msgid","RECORD_MODIFIED&"+next_token_series_no);
				map.put( "flag","0");
			}
			else{
			   map.put( "result", new Boolean( false ) ) ;
			   map.put( "msgid","APP-PH00206 Token nunber "+ next_token_series_no +" is already alloted.");
			   connection.rollback();

			}
		}
		catch( Exception e ) {
			
			try{
//				System.err.println("ASRN::(TEST)(1):"+e.getMessage() ) ;
				map.put( "result", new Boolean( false ) ) ;
				connection.rollback();
				throw new EJBException( e.getMessage() ) ;
			}
			catch ( Exception ee ) {
//				System.err.println("ASRN::(TEST)(2):"+ee.getMessage() ) ;
				map.put( "result", new Boolean( false ) ) ;
				map.put( "msgid",ee.getMessage());
			}			
			map.put( "msgid",e.getMessage());
			e.printStackTrace() ;
		} 
		finally {
			try {
				closeStatement( pstmt_update1 ) ;
				closeStatement( pstmt_update2 ) ;
				closeStatement( pstmt_update2A );
				closeStatement( pstmt_update3 );
				closeStatement( pstmt_update );
				closeStatement( pstmt_insert );
				closeStatement( pstmt_select );
				//closeStatement( pstmt_select_1);
				//closeStatement( pstmt_select_2);
				//closeStatement(pstmt_update4);
				closeResultSet( resultSet ) ;
				closeConnection( connection,prop );
			} catch ( Exception fe ) {
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}	
		return map ;
	}
	
	/*public int getNumberOfPrescriptions(String order_id,String login_facility_id)throws Exception{

		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		int count=0;
		try {
			connection = getConnection(prop) ;
			pstmt = connection.prepareStatement( SQL_PH_REG_PRESCRIPTIONS_SELECT9 );
			pstmt.setString(1,order_id.trim());
			pstmt.setString(2,login_facility_id.trim());
			pstmt.setString(3,login_facility_id.trim());
			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next() ) {
				count ++;
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
		}
		catch ( Exception e ){
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection,prop );
			}catch(Exception es){ es.printStackTrace();
			}
		}
		return count;
	}*/

	public String getNumberOfPrescriptions(Connection connection,String order_id,String login_facility_id)throws Exception{

		//Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList arr_list=new ArrayList();
		String update_string="OS";
		try {
			
			pstmt = connection.prepareStatement( SQL_PH_RELEASE_BATCHES_SELECT8 );
			//pstmt = connection.prepareStatement("SELECT order_line_status FROM or_order_line WHERE order_id=?");
			pstmt.setString(1,order_id.trim());			
			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next() ) {
				arr_list.add(resultSet.getString("order_line_status"));
			}

			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			
				if(arr_list.contains("OS")){
					update_string="OS";
				}else if(arr_list.contains("RG")){
					update_string="RG";
				}else if(arr_list.contains("HD")){
					update_string="HD";
				}else if(arr_list.contains("VF")){
					update_string="VF";
				}else if(arr_list.contains("AL")){
					update_string="AL";
				}else if(arr_list.contains("IP")){
					update_string="IP";
				}else if(arr_list.contains("DP")){
					update_string="DP";
				}else if(arr_list.contains("DF")){
					update_string="DF";
				}
				

		}
		catch ( Exception e ){
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				//closeConnection( connection,prop );
			}catch(Exception es){ es.printStackTrace();
			}
		}
		return update_string;
	}

	public int validateForInsertUpdate(String facility_id,String disp_locn_code,String token_series_code)throws Exception{
		
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		int insertUpdate=0;
		try {
			connection = getConnection(prop) ;
			pstmt = connection.prepareStatement( SQL_PH_REG_PRESCRIPTIONS_SELECT14 );
			pstmt.setString(1,facility_id.trim());
			pstmt.setString(2,disp_locn_code.trim());
			pstmt.setString(3,token_series_code.trim());
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null && resultSet.next() ) {
				if (resultSet.getInt("COUNT" )>0){
					insertUpdate	= 1;
				}
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
		}
		catch ( Exception e ){
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection,prop );
			}catch(Exception es){es.printStackTrace();
			}
		}
		return insertUpdate;
	}

	public String getNextTokenSeriesNo(Connection connection ,String facility_id,String disp_locn_code,String token_series_code,String language_id)throws Exception{

		//Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String next_token_series_no="";
		try {
			//connection = getConnection(prop) ;
			pstmt = connection.prepareStatement( SQL_PH_REG_PRESCRIPTIONS_SELECT15 );
			pstmt.setString(1,facility_id.trim());
			pstmt.setString(2,disp_locn_code.trim());
			pstmt.setString(3,token_series_code.trim());
			pstmt.setString(4,language_id.trim());
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null && resultSet.next() ) {
				next_token_series_no=resultSet.getString("NEXT_SERIAL_NO" ) ;
			}
			closeResultSet( resultSet ) ;
    		closeStatement( pstmt ) ;
		}
		catch ( Exception e ){
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			//	closeConnection( connection,prop );
			}catch(Exception es){es.printStackTrace();
			}
		}
		return next_token_series_no;
	}


	// delete method starts here
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap delete( HashMap tabData, HashMap sqlMap )  {

		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		map.put( "msgid", messages.toString() ) ;
		return map ;
	}
	// delete method ends here
	// added for Bru-HIMS-CRF-142 [IN:030195] -Start
	public String getTempTokenSeriesNo(String facility_id,String disp_locn_code,String token_series_code){
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String temp_token_series_no="";
		try {
			connection = getConnection(prop) ;
			pstmt = connection.prepareStatement( SQL_PH_REG_PRESCRIPTIONS_SELECT25 );
			pstmt.setString(1,facility_id.trim());
			pstmt.setString(2,disp_locn_code.trim());
			pstmt.setString(3,token_series_code.trim());
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null && resultSet.next() ) {
				temp_token_series_no=resultSet.getString("TEMP_TOKEN_SERIES_NO") == null?"" :resultSet.getString("TEMP_TOKEN_SERIES_NO");

				if(temp_token_series_no.equals("")){
					temp_token_series_no	=	"900000";
				}
			}
			closeResultSet( resultSet ) ;
    		closeStatement( pstmt ) ;
		}
		catch ( Exception e ){
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection,prop );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return temp_token_series_no;
	}
	// added for Bru-HIMS-CRF-142 [IN:030195] -End

	//added for ML-MMOH-SCF-1791.1
	public ArrayList getOrderLineDetails(String order_id){
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList arr = null;
		String order_line_no="";
		try {
			arr = new ArrayList();
			connection = getConnection(prop) ;
			pstmt = connection.prepareStatement( "SELECT ORDER_LINE_NUM from OR_ORDER_LINE WHERE ORDER_ID=? AND ORDER_CATEGORY='PH' AND ORDER_LINE_STATUS NOT IN('DF','AL','IP','HD','DC','CN') ORDER BY ORDER_LINE_NUM ASC" );
			pstmt.setString(1,order_id);
			resultSet = pstmt.executeQuery() ;
			while( resultSet != null && resultSet.next() ) {
				order_line_no=resultSet.getString("ORDER_LINE_NUM");
				arr.add(order_line_no);
			}
			closeResultSet( resultSet ) ;
    		closeStatement( pstmt ) ;
		}
		catch ( Exception e ){
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection,prop );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return arr;
	}
}
