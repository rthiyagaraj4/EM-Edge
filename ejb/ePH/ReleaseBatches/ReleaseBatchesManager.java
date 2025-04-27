/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//saved on 08/11/2005 
/*
	Module		 : ePH
	Function	 : Release Batches
	Class Name	 : ReleaseBatchesManager
	Created By	 : Giri
	Created Date : 
	Modified By	 :
	Modified Date:
	Version		 :
	Description  :				  
*/
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
04/13/2017      63877   		chithra      UnusedLocal variable
22/07/2021      TFS-20859       Prabha       SKR-SCF-1614
---------------------------------------------------------------------------------------------------------------
*/

package ePH.ReleaseBatches ;

import java.rmi.* ;
import java.util.HashMap ;
import java.util.ArrayList;
import java.util.Properties;
//import java.util.Set;
//import java.util.Iterator;
import java.sql.* ;
import javax.ejb.* ;

import eCommon.Common.CommonBean;
import ePH.Common.PhEJBSessionAdapter ;

/**
*
* @ejb.bean
*	name="ReleaseBatches"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ReleaseBatches"
*	local-jndi-name="ReleaseBatches"
*	impl-class-name="ePH.ReleaseBatches.ReleaseBatchesManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.ReleaseBatches.ReleaseBatchesLocal"
*	remote-class="ePH.ReleaseBatches.ReleaseBatchesRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.ReleaseBatches.ReleaseBatchesLocalHome"
*	remote-class="ePH.ReleaseBatches.ReleaseBatchesHome"
*	generate= "local,remote"
*
*
*/ 

public class ReleaseBatchesManager extends PhEJBSessionAdapter {

	Properties prop=null;
	ArrayList disp_drugs		= new ArrayList();
	boolean releaseBMS = false;
	// insert method starts here
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public HashMap insert( HashMap tabData, HashMap sqlMap )  {
		
		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "msgid", messages.toString() ) ;
		map.put( "flag","0");
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
		
		Connection connection		= null ;
		try{
			prop		= (Properties)tabData.get( "properties" );	
			connection	= getConnection( prop ) ;
			//boolean canProceed = false;  Unused local variable INC63877
			if(takeDrugBatchDetails(connection,tabData,sqlMap)) {// Condition based for SRR20056-SCF-7628
				 deleteTMPTables(connection,tabData,sqlMap);
				if(insertBatchLog(connection,tabData,sqlMap) || releaseBMS){// insert into release batch log table // Condition based for SRR20056-SCF-7628
					//updateOrderTables(connection,tabData,sqlMap);// update OR_ORDER & OR_ORDER_LINE
					//updateStockTables(connection,tabData,sqlMap);//delete Sales Details
					connection.commit();
					map.put( "result", new Boolean( true) ) ;
					map.put("msgid","RECORD_MODIFIED");
				 }
				 else{
					connection.rollback();
   				    throw new Exception("The drug/item has been updated by different user,please refresh and try again later..."); 
				}
			}
			else{
				connection.rollback();
				 throw new Exception("The drug/item has been updated by different user,please refresh and try again later"); 
			}
		}
		catch(Exception e){
			System.err.println("modify EJB tabData="+tabData);
			e.printStackTrace();
			try{
				connection.rollback();
				map.put("msgid",e.getMessage().toString()); // changed e.toString() to e.getMessage().toString()  for ML-BRU-SCF-0603 [IN:036245]
				map.put("flag",e.toString());
				map.put("result",  new Boolean( false)); 
			} 
			catch(Exception ess) {
				ess.printStackTrace();
			}
		}
		finally{	
			try {
				closeConnection( connection,prop );
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
		return map;
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


	private void deleteTMPTables(Connection connection,HashMap tabData,HashMap sqlMap) throws Exception {

		String order_id			=	null;
		String order_line_no	=	null;	
		//String disp_drug_code	=	null;  Unused local variable INC63877
		String doc_srl_no		=	null;
		String disp_qty, bms_qty; //Added for ML-BRU-SCF-0674 [IN:037567]
	//	System.err.println("tabData===>" + tabData);
		
		//Added for SKR-SCF-1614
		String language_id								= (String)tabData.get("LanguageId"); 
		String encounter_id				= "";
		String curr_locn				= "";
		String patient_id = "";
		String patient_class = "";
		String locn_code =  "";
		//Added for SKR-SCF-1614
		
		PreparedStatement pstmt_disp_dtl_count		=	null;
		PreparedStatement pstmt_disp_hdr_delete		=	null;
		PreparedStatement pstmt_disp_dtl_delete		=	null;
		PreparedStatement pstmt_disp_batch_delete	=	null;
		PreparedStatement pstmt_disp_batch_count	=	null;
		PreparedStatement pstmt_disp_label_delete	=	null; // Added for Bru-HIMS-CRF-414 [IN:045554]
		PreparedStatement pstmt_med_plan_delete		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_MED_PLAN_DELETE") ) ; //Added for Bru-HIMS-CRF-072.1[IN 049144]
		PreparedStatement pstmt_med_plan_del_all = connection.prepareStatement( (String)sqlMap.get("SQL_PH_MED_PLAN_DELETE_ALL") ) ; //Added for Bru-HIMS-CRF-072.1[IN 049144]
		PreparedStatement pstmt_med_plan_sel = connection.prepareStatement( (String)sqlMap.get("SQL_PH_MED_PLAN_SELECT_ID") ) ; //Added for Bru-HIMS-CRF-072.1[IN 049144]
		PreparedStatement pstmt_med_plan_select = connection.prepareStatement( (String)sqlMap.get("SQL_PH_MED_PLAN_SELECT_CURR_DRUG") ) ;//Added for Bru-HIMS-CRF-072.1[IN 049144]
		ResultSet resultSet							=	null;
		int tot_count								=	0;
		int result=0;//Added for GHL issue
		
		try{
			pstmt_disp_dtl_count		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_RELEASE_BATCHES_SELECT2") ) ;
			pstmt_disp_hdr_delete		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_RELEASE_BATCHES_DELETE3") ) ;
			pstmt_disp_dtl_delete		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_RELEASE_BATCHES_DELETE2") ) ;
			pstmt_disp_batch_delete		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_RELEASE_BATCHES_DELETE1") ) ;
			pstmt_disp_batch_count		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_RELEASE_BATCHES_SELECT6") ) ;
			pstmt_disp_label_delete		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_LABEL_DELETE") ) ; // Added for Bru-HIMS-CRF-414 [IN:045554]

			String med_plan_id="",count="0";//Added for Bru-HIMS-CRF-072.1[IN 049144]
			ArrayList all_records	=	(ArrayList)tabData.get("all_records");
			HashMap record_status	=	(HashMap)tabData.get("record_status");
			HashMap hmBatchDtlExists	=	(HashMap)tabData.get("BatchDtlExists"); //Added for MMS-SCF-0356 [IN:049289]
			String batchExists = ""; //Added for MMS-SCF-0356 [IN:049289]

			for(int i=0; i<all_records.size(); i+=16) { //Changed from 7 --> 9 for ML-BRU-SCF-0674 [IN:037567] //changed 9 --> 12 for Bru-HIMS-CRF-414 [IN:045554]//changed 12 to 16 for SKR-SCF-1614
				order_id		=	(String)all_records.get(i);
				order_line_no	=	(String)all_records.get(i+1);
				doc_srl_no		=	(String)all_records.get(i+5);
				disp_qty		=	(String)all_records.get(i+7); //Added for ML-BRU-SCF-0674 [IN:037567]
				bms_qty		=	(String)all_records.get(i+8);//Added for ML-BRU-SCF-0674 [IN:037567]
				
				//Added for SKR-SCF-1614
				encounter_id			 = (String)all_records.get(i+12);
				patient_class			 = (String)all_records.get(i+13);
				patient_id				 = (String)all_records.get(i+14);
				locn_code				 = (String)all_records.get(i+15);
				//Added for SKR-SCF-1614
				
				batchExists = hmBatchDtlExists.get(order_id+order_line_no+doc_srl_no)==null?"":(String)hmBatchDtlExists.get(order_id+order_line_no+doc_srl_no); //Added for MMS-SCF-0356 [IN:049289]
				if(((String)record_status.get(order_id+order_line_no+doc_srl_no)).equals("Y")) {
					if(!disp_qty.equals("") && Integer.parseInt(disp_qty)>0 && !batchExists.equals("N")){ //if condition added for ML-BRU-SCF-0674 [IN:037567] // batchExists Added for MMS-SCF-0356 [IN:049289]
						pstmt_disp_batch_delete.setString(1,order_id);
						pstmt_disp_batch_delete.setString(2,order_line_no);
						pstmt_disp_batch_delete.setString(3,doc_srl_no);
						pstmt_disp_batch_delete.executeUpdate();
						pstmt_disp_batch_count.setString(1,order_id);
						pstmt_disp_batch_count.setString(2,order_line_no);
						pstmt_disp_batch_count.setString(3,doc_srl_no);
						resultSet	=	pstmt_disp_batch_count.executeQuery();
						tot_count	=	0;
				
						if ( resultSet.next() ) {
							tot_count	=	Integer.parseInt(resultSet.getString("TOTAL_BATCH"));
						}
						closeResultSet( resultSet ) ;
					}
					if(tot_count==0 || (!bms_qty.equals("") && Integer.parseInt(bms_qty)>0)) { // || (!bms_qty.equals("") && Integer.parseInt(bms_qty)>0) Added for ML-BRU-SCF-0674 [IN:037567]
						pstmt_disp_dtl_delete.setString(1,order_id);
						pstmt_disp_dtl_delete.setString(2,order_line_no);
						pstmt_disp_dtl_delete.setString(3,doc_srl_no);
						pstmt_disp_dtl_delete.executeUpdate();
					}

					pstmt_disp_dtl_count.setString(1,order_id);
					resultSet	=	pstmt_disp_dtl_count.executeQuery();
					tot_count	=	0;

					if ( resultSet.next() ) {
						tot_count	=	Integer.parseInt(resultSet.getString("TOTAL"));
					}
					closeResultSet( resultSet ) ;
					
				    if(tot_count==0) {
						pstmt_disp_hdr_delete.setString(1,order_id);
						pstmt_disp_hdr_delete.executeUpdate();
					}

					pstmt_disp_label_delete.setString(1,(String)all_records.get(i+11)); // Added for Bru-HIMS-CRF-414 [IN:045554] -start
					pstmt_disp_label_delete.setString(2,(String)all_records.get(i+9));
					pstmt_disp_label_delete.setString(3,(String)all_records.get(i+10));
					pstmt_disp_label_delete.executeUpdate();  // Added for Bru-HIMS-CRF-414 [IN:045554] -end
					
					pstmt_med_plan_sel.setString(1,(String)all_records.get(i+11)); //Added for Bru-HIMS-CRF-072.1[IN 049144] start
					pstmt_med_plan_sel.setString(2,(String)all_records.get(i+9));	
					pstmt_med_plan_sel.setString(3,(String)all_records.get(i+10));
					resultSet	=	pstmt_med_plan_sel.executeQuery();
					if ( resultSet.next() ) {
						med_plan_id = resultSet.getString("MED_PLAN_ID")==null?"":resultSet.getString("MED_PLAN_ID");
					}
					closeResultSet( resultSet ) ;
					pstmt_med_plan_delete.setString(1,(String)all_records.get(i+11)); 
					pstmt_med_plan_delete.setString(2,(String)all_records.get(i+9));	
					pstmt_med_plan_delete.setString(3,(String)all_records.get(i+10));	
					pstmt_med_plan_delete.executeUpdate();
					if(!med_plan_id.equals("")){
						pstmt_med_plan_select.setString(1,med_plan_id);
						pstmt_med_plan_select.setString(2,(String)all_records.get(i+9));	
						pstmt_med_plan_select.setString(3,(String)all_records.get(i+10));
						resultSet	=	pstmt_med_plan_select.executeQuery();
						if ( resultSet.next() ) {
							count = resultSet.getString("COUNT");
						}
						if(Integer.parseInt(count)==0){
							pstmt_med_plan_del_all.setString(1,med_plan_id);
							pstmt_med_plan_del_all.executeUpdate();
						}
					}  //Added for Bru-HIMS-CRF-072.1[IN 049144] end

					result=1;
				}
	if(result>0){
				resultSet								=	null;
				PreparedStatement pstmt_or_update				=	null;
				PreparedStatement pstmt_or_order_line_update	=	null;
				PreparedStatement pstmt_disp_dtl_tmp_count		=	null;
				try{

					String login_by_id		=	(String)tabData.get("login_by_id");
					String login_at_ws_no	=	(String)tabData.get("login_at_ws_no");
					String facility_id		=	(String)tabData.get("facility_id");
					String batches			=	(String)tabData.get("batches");
					
					pstmt_or_update				= connection.prepareStatement( (String)sqlMap.get("SQL_PH_RELEASE_BATCHES_UPDATE2") ) ;
					pstmt_disp_dtl_tmp_count	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_RELEASE_BATCHES_SELECT7") ) ;
					if(batches.equals("H")){
						pstmt_or_order_line_update	= connection.prepareStatement("UPDATE OR_ORDER_LINE SET ORDER_LINE_STATUS='UC',MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ? , MODIFIED_FACILITY_ID = ? ,RESULT_LINE_STATUS ='UC' WHERE ORDER_ID=? AND ORDER_LINE_NUM=?");
					}
					else{
						//pstmt_or_order_line_update	= connection.prepareStatement((String)sqlMap.get("SQL_PH_RELEASE_BATCHES_UPDATE1")) ;
						pstmt_or_order_line_update	= connection.prepareStatement("UPDATE OR_ORDER_LINE SET ORDER_LINE_STATUS=?,MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ? , MODIFIED_FACILITY_ID = ? WHERE ORDER_ID=? AND ORDER_LINE_NUM=?"); 
						//modified added for SKR-SCF-1552 
					}			
		// or_order_line updations
					if(!batches.equals("D")){
						//for(int i=0; i<all_records.size(); i+=12) { //Changed from 7 --> 9 for ML-BRU-SCF-0674 [IN:037567]//changed 9 --> 12 for Bru-HIMS-CRF-414 [IN:045554]
							///order_id		=	(String)all_records.get(i);
							//order_line_no	=	(String)all_records.get(i+1);
							//doc_srl_no		=	(String)all_records.get(i+5);
							if(((String)record_status.get(order_id+order_line_no+doc_srl_no)).equals("Y")){
								pstmt_disp_dtl_tmp_count.setString(1,order_id);
								pstmt_disp_dtl_tmp_count.setString(2,order_line_no);
								resultSet = pstmt_disp_dtl_tmp_count.executeQuery();
								tot_count = 0;
								if ( resultSet.next() ) {
									tot_count	=	Integer.parseInt(resultSet.getString("TOTAL"));
								}
									closeResultSet( resultSet ) ;
								if(tot_count == 0){
									if(batches.equals("H")){
										pstmt_or_order_line_update.setString(1,login_by_id);
										pstmt_or_order_line_update.setString(2,login_at_ws_no);
										pstmt_or_order_line_update.setString(3,facility_id);
										pstmt_or_order_line_update.setString(4,order_id);
										pstmt_or_order_line_update.setString(5,order_line_no);
										pstmt_or_order_line_update.addBatch();
									}
									else{
										//added for SKR-SCF-1552 - start
										String status =getNumberOfPrescriptions(connection,order_id,facility_id,sqlMap);

									
										if(status!=null && status.equals("DC")){
										pstmt_or_order_line_update.setString(1,"DC");
										}else{
										pstmt_or_order_line_update.setString(1,"UC");
										}
										//added for SKR-SCF-1552 - end
										pstmt_or_order_line_update.setString(2,login_by_id);
										pstmt_or_order_line_update.setString(3,login_at_ws_no);
										pstmt_or_order_line_update.setString(4,facility_id);
										pstmt_or_order_line_update.setString(5,order_id);
										pstmt_or_order_line_update.setString(6,order_line_no);
										pstmt_or_order_line_update.addBatch();
									}
								}
							}
						//}
						int[] result1	=	pstmt_or_order_line_update.executeBatch();
						for (int j=0;j<result1.length ;j++ ){
							if(result1[j]<0  && result1[j] != -2 ){
								pstmt_or_order_line_update.cancel();
								connection.rollback();
								throw new Exception("Order Line Update Failed");
							}else{
						        result=1;
					        }		
						}
					}
		// or_order updations.

					if(batches.equals("A")){			
						//for(int i=0; i<all_records.size(); i+=12) { //Changed from 7 --> 9 for  ML-BRU-SCF-0674 [IN:037567]//changed 9 --> 12 for Bru-HIMS-CRF-414 [IN:045554]
						//	order_id		=	(String)all_records.get(i);
						//	order_line_no	=	(String)all_records.get(i+1);
						//	doc_srl_no		=	(String)all_records.get(i+5);
							if(((String)record_status.get(order_id+order_line_no+doc_srl_no)).equals("Y")) {
								pstmt_or_update.setString(1,getNumberOfPrescriptions(connection,order_id,facility_id,sqlMap));
								pstmt_or_update.setString(2,login_by_id);
								pstmt_or_update.setString(3,login_at_ws_no);
								pstmt_or_update.setString(4,facility_id);
								pstmt_or_update.setString(5,order_id);
								pstmt_or_update.addBatch();
							}
					//	}

						int[] result2	=	pstmt_or_update.executeBatch();
						for (int k=0;k<result2.length ;k++ ){
							if(result2[k]<0  && result2[k] != -2 ){
							pstmt_or_update.cancel();
							connection.rollback();
							throw new Exception("Order Update Failed");
							}else{
						          result=1;
					             }		
						}
					}
					//Added for SKR-SCF-1614 
					if(patient_class.equals("IP") && ((String)record_status.get(order_id+order_line_no+doc_srl_no)).equals("Y")){ //record_status added for SKR-SCF-1614.1
						boolean allow_locn_update = new CommonBean().isSiteSpecific(connection, "PH","PATIENT_TRANSFER_LOCN_UPD");

						if(allow_locn_update){
						  curr_locn = getCurrentLocn(connection,patient_id,encounter_id);
						  if(locn_code!=null && !locn_code.equals("") && !locn_code.equals(curr_locn)){
							updateOrOrdersLocn(connection,patient_id,order_id,encounter_id,curr_locn,patient_class,facility_id.trim(),language_id);
						  }
						}
					}
					//Added for SKR-SCF-1614 
					
				}
				catch(Exception e) {
					System.err.println("updateOrderTables EJB tabData="+tabData);
					e.printStackTrace();
					throw e;
				}
				finally{	
					try {
						closeStatement( pstmt_or_update ) ;
						closeStatement( pstmt_or_order_line_update ) ;
						closeStatement( pstmt_disp_dtl_tmp_count ) ;
					}
					catch(Exception es) { 
						es.printStackTrace();
					}
				  }
			  }//Result close
if(result>0){
		HashMap hmPKData	=	new HashMap();
		HashMap hmCommon	=	new HashMap();
		HashMap hmData		=	new HashMap();
//		ArrayList uniq_records	=	new ArrayList();
		ArrayList itemList	=	new ArrayList();
		ArrayList language_data =  new ArrayList();
		try{

			//ArrayList all_records			=	(ArrayList)tabData.get("all_records");
			//HashMap record_status			=	(HashMap)tabData.get("record_status");
			HashMap order_and_ord_facility	=	(HashMap)tabData.get("ORDER_AND_ORD_FACILITY");
			String LanguageId				=   (String)tabData.get("LanguageId");
			//HashMap hmBatchDtlExists			=	(HashMap)tabData.get("BatchDtlExists"); //Added for MMS-SCF-0356 [IN:049289]
			//String batchExists = "";//Added for MMS-SCF-0356 [IN:049289]

			hmCommon.put("login_by_id",(String)tabData.get("login_by_id"));
			hmCommon.put("login_at_ws_no",(String)tabData.get("login_at_ws_no"));
			hmCommon.put("login_facility_id",(String)tabData.get("facility_id"));

			language_data.add(LanguageId);

			/*for(int i=0; i<all_records.size(); i+=6) {
						if(!uniq_records.contains((String)all_records.get(i+2))) {
							uniq_records.add( (String)all_records.get(i) );
							uniq_records.add( (String)all_records.get(i+1) );
							uniq_records.add( (String)all_records.get(i+2) );
							uniq_records.add( (String)all_records.get(i+3) );
							uniq_records.add( (String)all_records.get(i+4) );
							uniq_records.add( (String)all_records.get(i+5) );
						}
			}*/

			//for(int i=0; i<all_records.size(); i+=12) { //Changed from 7 --> 9 for ML-BRU-SCF-0674 [IN:037567]//changed 9 --> 12 for Bru-HIMS-CRF-414 [IN:045554]
				//order_id		=	(String)all_records.get(i);
				//order_line_no	=	(String)all_records.get(i+1);
				//doc_srl_no		=	(String)all_records.get(i+5);
				//disp_qty		=	(String)all_records.get(i+7);//Added for ML-BRU-SCF-0674 [IN:037567]
				//batchExists = hmBatchDtlExists.get(order_id+order_line_no+doc_srl_no)==null?"":(String)hmBatchDtlExists.get(order_id+order_line_no+doc_srl_no); //Added for MMS-SCF-0356 [IN:049289]
				if(((String)record_status.get(order_id+order_line_no+doc_srl_no)).equals("Y") && (!disp_qty.equals("") && Integer.parseInt(disp_qty)>0) && !batchExists.equals("N")) { // && (!disp_qty.equals("") && Integer.parseInt(disp_qty)>0) - added for ML-BRU-SCF-0674 [IN:037567] // batchExists Added for MMS-SCF-0356 [IN:049289]
					hmPKData	=	new HashMap();
					itemList	=   new ArrayList();
					hmPKData.put("facility_id",(String)tabData.get("facility_id"));
					hmPKData.put("doc_no",(String)all_records.get(i+2));
					hmPKData.put("doc_type_code",(String)all_records.get(i+3));
					
					
					hmCommon.put("facility_id",(String)tabData.get("facility_id"));
					hmCommon.put("doc_no",(String)all_records.get(i+2));
					hmCommon.put("doc_type_code",(String)all_records.get(i+3));
					//hmCommon.put("DispBillingStage",(String)tabData.get("DispBillingStage"));
					hmCommon.put("DispBillingStage",(String)all_records.get(i+6)); //changed for SRR20056-SCF-7639 ICN 27720
					System.err.println("==RelaseBAtch EJB==hmCommon=="+hmCommon+" disp_qty="+disp_qty);
					hmCommon.put("FACILITY_STR_FOR_BL",(String)order_and_ord_facility.get(order_id)+"|"+(String)tabData.get( "facility_id" ));
					hmPKData.put("doc_srl_no",doc_srl_no);					
					itemList.add((String)all_records.get(i+4));
					hmData.put("ITEM_CODE",itemList);

					hmData.put("COMMON_DATA",hmCommon);			
					hmData.put("DATA",hmPKData);
					hmData.put("LANGUAGE_DATA",language_data);
					eST.Common.StSales	stSales	=	new eST.Common.StSales();

					//HashMap map					=	stSales.deleteSales(connection,hmData);
					HashMap map					=	stSales.deleteSalesItemDetailsForPH(connection,hmData);
					if( !(((Boolean) map.get( "result" )).booleanValue()) )	{
						String msg1 = "Invalid/Finalized record found";  
						connection.rollback();
						if (map.get("message").toString().equals(msg1)) {
							throw new Exception("Invalid/Finalized record found"); 
						}
						else{
							throw new Exception(map.get("message").toString());
						}
					//}				
				}
			  }
			}
			catch(Exception e) {
				System.err.println("updateStockTables EJB tabData="+tabData);
				e.printStackTrace();
				throw e;
			}
		  }
		}
	}
		catch(Exception e) {
			System.err.println("deleteTMPTables EJB tabData="+tabData);
			e.printStackTrace();
			throw e;
		}
		finally{	
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt_disp_dtl_count ) ;
				closeStatement( pstmt_disp_hdr_delete ) ;
				closeStatement( pstmt_disp_dtl_delete ) ;
				closeStatement( pstmt_disp_batch_delete ) ;
				closeStatement( pstmt_disp_batch_count ) ;
				closeStatement( pstmt_disp_label_delete ) ; // Added for Bru-HIMS-CRF-414 [IN:045554]
				closeStatement( pstmt_med_plan_delete ); //Added for Bru-HIMS-CRF-072.1[IN 049144]
				closeStatement( pstmt_med_plan_sel ); //Added for Bru-HIMS-CRF-072.1[IN 049144]
				closeStatement( pstmt_med_plan_select ); //Added for Bru-HIMS-CRF-072.1[IN 049144]
				closeStatement( pstmt_med_plan_del_all ); //Added for Bru-HIMS-CRF-072.1[IN 049144]
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
	}

	private void updateOrderTables(Connection connection,HashMap tabData,HashMap sqlMap) throws Exception {
		String order_id				=	null;
		String order_line_no		=	null;	
		//String disp_drug_code		=	null;  Unused local variable INC63877
		String doc_srl_no			=	null;

		PreparedStatement pstmt_or_update				=	null;
		PreparedStatement pstmt_or_order_line_update	=	null;
		PreparedStatement pstmt_disp_dtl_tmp_count		=	null;
		ResultSet resultSet								=	null;
		int tot_count									=	0;
		try{

            ArrayList all_records	=	(ArrayList)tabData.get("all_records");
			HashMap record_status	=	(HashMap)tabData.get("record_status");			
			String login_by_id		=	(String)tabData.get("login_by_id");
			String login_at_ws_no	=	(String)tabData.get("login_at_ws_no");
			String facility_id		=	(String)tabData.get("facility_id");
			String batches			=	(String)tabData.get("batches");
			
			pstmt_or_update				= connection.prepareStatement( (String)sqlMap.get("SQL_PH_RELEASE_BATCHES_UPDATE2") ) ;
			pstmt_disp_dtl_tmp_count	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_RELEASE_BATCHES_SELECT7") ) ;
			if(batches.equals("H")){
			    pstmt_or_order_line_update	= connection.prepareStatement("UPDATE OR_ORDER_LINE SET ORDER_LINE_STATUS='UC',MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ? , MODIFIED_FACILITY_ID = ? ,RESULT_LINE_STATUS ='UC' WHERE ORDER_ID=? AND ORDER_LINE_NUM=?");
			}
			else{
				pstmt_or_order_line_update	= connection.prepareStatement((String)sqlMap.get("SQL_PH_RELEASE_BATCHES_UPDATE1")) ;

			}			
// or_order_line updations
			if(!batches.equals("D")){
				for(int i=0; i<all_records.size(); i+=16) { //Changed from 7 --> 9 for ML-BRU-SCF-0674 [IN:037567]//changed 9 --> 12 for Bru-HIMS-CRF-414 [IN:045554] //Changed 12 --> 16 for SKR-SCF-1614
					order_id		=	(String)all_records.get(i);
					order_line_no	=	(String)all_records.get(i+1);
					doc_srl_no		=	(String)all_records.get(i+5);
					if(((String)record_status.get(order_id+order_line_no+doc_srl_no)).equals("Y")){
						pstmt_disp_dtl_tmp_count.setString(1,order_id);
						pstmt_disp_dtl_tmp_count.setString(2,order_line_no);
						resultSet = pstmt_disp_dtl_tmp_count.executeQuery();
						tot_count = 0;
						if ( resultSet.next() ) {
							tot_count	=	Integer.parseInt(resultSet.getString("TOTAL"));
						}
							closeResultSet( resultSet ) ;
						if(tot_count == 0){
							if(batches.equals("H")){
								pstmt_or_order_line_update.setString(1,login_by_id);
								pstmt_or_order_line_update.setString(2,login_at_ws_no);
								pstmt_or_order_line_update.setString(3,facility_id);
								pstmt_or_order_line_update.setString(4,order_id);
								pstmt_or_order_line_update.setString(5,order_line_no);
								pstmt_or_order_line_update.addBatch();
							}
							else{
								pstmt_or_order_line_update.setString(1,login_by_id);
								pstmt_or_order_line_update.setString(2,login_at_ws_no);
								pstmt_or_order_line_update.setString(3,facility_id);
								pstmt_or_order_line_update.setString(4,order_id);
								pstmt_or_order_line_update.setString(5,order_line_no);
								pstmt_or_order_line_update.addBatch();
							}
						}
					}
				}
				int[] result1	=	pstmt_or_order_line_update.executeBatch();
				for (int i=0;i<result1.length ;i++ ){
					if(result1[i]<0  && result1[i] != -2 ){
						pstmt_or_order_line_update.cancel();
						connection.rollback();
						throw new Exception("Order Line Update Failed");
					}		
				}
			}
// or_order updations.

			if(batches.equals("A")){			
				for(int i=0; i<all_records.size(); i+=16) { //Changed from 7 --> 9 for  ML-BRU-SCF-0674 [IN:037567]//changed 9 --> 12 for Bru-HIMS-CRF-414 [IN:045554] //Changed 12 --> 16 for SKR-SCF-1614
					order_id		=	(String)all_records.get(i);
					order_line_no	=	(String)all_records.get(i+1);
					doc_srl_no		=	(String)all_records.get(i+5);
					if(((String)record_status.get(order_id+order_line_no+doc_srl_no)).equals("Y")) {
						pstmt_or_update.setString(1,getNumberOfPrescriptions(connection,order_id,facility_id,sqlMap));
						pstmt_or_update.setString(2,login_by_id);
						pstmt_or_update.setString(3,login_at_ws_no);
						pstmt_or_update.setString(4,facility_id);
						pstmt_or_update.setString(5,order_id);
						pstmt_or_update.addBatch();
					}
				}

				int[] result2	=	pstmt_or_update.executeBatch();
				for (int i=0;i<result2.length ;i++ ){
					if(result2[i]<0  && result2[i] != -2 ){
					pstmt_or_update.cancel();
					connection.rollback();
					throw new Exception("Order Update Failed");
					}		
				}
			}
		}
		catch(Exception e) {
			System.err.println("updateOrderTables EJB tabData="+tabData);
			e.printStackTrace();
			throw e;
		}
		finally{	
			try {
				closeStatement( pstmt_or_update ) ;
				closeStatement( pstmt_or_order_line_update ) ;
				closeStatement( pstmt_disp_dtl_tmp_count ) ;
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
	}

	private void updateStockTables(Connection connection,HashMap tabData,HashMap sqlMap) throws Exception {
		String order_id				=	null;
		String order_line_no		=	null;
		//String disp_drug_code		=	null;  Unused local variable INC63877
		String doc_srl_no			=	null;
		String disp_qty; //Added for || (!bms_qty.equals("") && Integer.parseInt(bms_qty)>0)

		HashMap hmPKData	=	new HashMap();
		HashMap hmCommon	=	new HashMap();
		HashMap hmData		=	new HashMap();
//		ArrayList uniq_records	=	new ArrayList();
		ArrayList itemList	=	new ArrayList();
		ArrayList language_data =  new ArrayList();
		try{

			ArrayList all_records			=	(ArrayList)tabData.get("all_records");
			HashMap record_status			=	(HashMap)tabData.get("record_status");
			HashMap order_and_ord_facility	=	(HashMap)tabData.get("ORDER_AND_ORD_FACILITY");
			String LanguageId				=   (String)tabData.get("LanguageId");
			HashMap hmBatchDtlExists			=	(HashMap)tabData.get("BatchDtlExists"); //Added for MMS-SCF-0356 [IN:049289]
			String batchExists = "";//Added for MMS-SCF-0356 [IN:049289]

			hmCommon.put("login_by_id",(String)tabData.get("login_by_id"));
			hmCommon.put("login_at_ws_no",(String)tabData.get("login_at_ws_no"));
			hmCommon.put("login_facility_id",(String)tabData.get("facility_id"));

			language_data.add(LanguageId);

			/*for(int i=0; i<all_records.size(); i+=6) {
						if(!uniq_records.contains((String)all_records.get(i+2))) {
							uniq_records.add( (String)all_records.get(i) );
							uniq_records.add( (String)all_records.get(i+1) );
							uniq_records.add( (String)all_records.get(i+2) );
							uniq_records.add( (String)all_records.get(i+3) );
							uniq_records.add( (String)all_records.get(i+4) );
							uniq_records.add( (String)all_records.get(i+5) );
						}
			}*/

			for(int i=0; i<all_records.size(); i+=16) { //Changed from 7 --> 9 for ML-BRU-SCF-0674 [IN:037567]//changed 9 --> 12 for Bru-HIMS-CRF-414 [IN:045554] //Changed 12 --> 16 for SKR-SCF-1614
				order_id		=	(String)all_records.get(i);
				order_line_no	=	(String)all_records.get(i+1);
				doc_srl_no		=	(String)all_records.get(i+5);
				disp_qty		=	(String)all_records.get(i+7);//Added for ML-BRU-SCF-0674 [IN:037567]
				batchExists = hmBatchDtlExists.get(order_id+order_line_no+doc_srl_no)==null?"":(String)hmBatchDtlExists.get(order_id+order_line_no+doc_srl_no); //Added for MMS-SCF-0356 [IN:049289]
				if(((String)record_status.get(order_id+order_line_no+doc_srl_no)).equals("Y") && (!disp_qty.equals("") && Integer.parseInt(disp_qty)>0) && !batchExists.equals("N")) { // && (!disp_qty.equals("") && Integer.parseInt(disp_qty)>0) - added for ML-BRU-SCF-0674 [IN:037567] // batchExists Added for MMS-SCF-0356 [IN:049289]
					hmPKData	=	new HashMap();
					itemList	=   new ArrayList();
					hmPKData.put("facility_id",(String)tabData.get("facility_id"));
					hmPKData.put("doc_no",(String)all_records.get(i+2));
					hmPKData.put("doc_type_code",(String)all_records.get(i+3));
					
					
					hmCommon.put("facility_id",(String)tabData.get("facility_id"));
					hmCommon.put("doc_no",(String)all_records.get(i+2));
					hmCommon.put("doc_type_code",(String)all_records.get(i+3));
					//hmCommon.put("DispBillingStage",(String)tabData.get("DispBillingStage"));
					hmCommon.put("DispBillingStage",(String)all_records.get(i+6)); //changed for SRR20056-SCF-7639 ICN 27720
					System.err.println("==RelaseBAtch EJB==hmCommon=="+hmCommon+" disp_qty="+disp_qty);
					hmCommon.put("FACILITY_STR_FOR_BL",(String)order_and_ord_facility.get(order_id)+"|"+(String)tabData.get( "facility_id" ));
					hmPKData.put("doc_srl_no",doc_srl_no);					
					itemList.add((String)all_records.get(i+4));
					hmData.put("ITEM_CODE",itemList);

					hmData.put("COMMON_DATA",hmCommon);			
					hmData.put("DATA",hmPKData);
					hmData.put("LANGUAGE_DATA",language_data);
					eST.Common.StSales	stSales	=	new eST.Common.StSales();

					//HashMap map					=	stSales.deleteSales(connection,hmData);
					HashMap map					=	stSales.deleteSalesItemDetailsForPH(connection,hmData);
					if( !(((Boolean) map.get( "result" )).booleanValue()) )	{
						String msg1 = "Invalid/Finalized record found";  
						connection.rollback();
						if (map.get("message").toString().equals(msg1)) {
							throw new Exception("Invalid/Finalized record found"); 
						}
						else{
							throw new Exception(map.get("message").toString());
						}
					}				
				}
			}
		}
		catch(Exception e) {
			System.err.println("updateStockTables EJB tabData="+tabData);
			e.printStackTrace();
			throw e;
		}
	}

	private boolean takeDrugBatchDetails(Connection connection,HashMap tabData,HashMap sqlMap) throws Exception {
		String order_id			=	"";
		String order_line_no	=	"";	
		//String disp_drug_code	=	null;  Unused local variable INC63877
		String doc_srl_no		=	null;
		String rcTypeCode		=   "";
		String rType			=	"";
		String rCode			=	"";
		String disp_qty, bms_qty; //Added for ML-BRU-SCF-0674 [IN:037567]
		
		PreparedStatement pstmt_disp_drug_batch		=	null;
		PreparedStatement pstmt_disp_dtl_tmp		=	null;
		ResultSet resultSet							=	null;
		HashMap	disp_drug_dtl	= null;
		//int tot_count			= 0; 512 Unused local variable 'tot_count'. 
		boolean canProceed = false;
		boolean canProceed_tmp = false;
		try{

			pstmt_disp_drug_batch		= connection.prepareStatement((String)sqlMap.get("SQL_PH_RELEASE_BATCHES_SELECT4"));
			pstmt_disp_dtl_tmp			= connection.prepareStatement((String)sqlMap.get("SQL_PH_RELEASE_BATCHES_SELECT5"));

			ArrayList all_records	=	(ArrayList)tabData.get("all_records");
			HashMap record_status	=	(HashMap)tabData.get("record_status");
			HashMap rsn_type_code	=	(HashMap)tabData.get("rsn_type_code");
			HashMap hmBatchDtlExists = new HashMap(); //Added for MMS-SCF-0356 [IN:049289]
			for(int i=0; i<all_records.size(); i+=16) {//Changed from 7 --> 9 for ML-BRU-SCF-0674 [IN:037567]//changed 9 --> 12 for Bru-HIMS-CRF-414 [IN:045554] //changed 12 to 16 for SKR-SCF-1614
				disp_drug_dtl	= new HashMap();				
				order_id		=	(String)all_records.get(i);
				order_line_no	=	(String)all_records.get(i+1);
				doc_srl_no		=	(String)all_records.get(i+5);
				disp_qty		=	(String)all_records.get(i+7);//Added for ML-BRU-SCF-0674 [IN:037567]
				bms_qty		=	(String)all_records.get(i+8);//Added for ML-BRU-SCF-0674 [IN:037567]
				if(((String)record_status.get(order_id+order_line_no+doc_srl_no)).equals("Y")){
					if(!disp_qty.equals("") && Integer.parseInt(disp_qty)>0 ) { //if condition Added for ML-BRU-SCF-0674 [IN:037567]
						rcTypeCode		= (String)rsn_type_code.get(order_id+order_line_no+doc_srl_no);
						rType			= rcTypeCode.substring(0,2);
						rCode			= rcTypeCode.substring(2,rcTypeCode.length());

						disp_drug_dtl.put("RELEASE_REASON_TYPE",rType);
						disp_drug_dtl.put("RELEASE_REASON_CODE",rCode);

						pstmt_disp_drug_batch.setString(1,order_id);
						pstmt_disp_drug_batch.setString(2,order_line_no);
						resultSet	=	pstmt_disp_drug_batch.executeQuery();
						while(resultSet.next()){
							disp_drug_dtl.put("FACILITY_ID",resultSet.getString("FACILITY_ID"));
							disp_drug_dtl.put("DISP_LOCN_CODE",resultSet.getString("DISP_LOCN_CODE"));
							disp_drug_dtl.put("ORDER_ID",resultSet.getString("ORDER_ID"));
							disp_drug_dtl.put("ORDER_LINE_NUM",resultSet.getString("ORDER_LINE_NUM"));
							disp_drug_dtl.put("BIN_LOCATION_CODE",resultSet.getString("BIN_LOCATION_CODE"));
							disp_drug_dtl.put("ITEM_CODE",resultSet.getString("ITEM_CODE"));
							disp_drug_dtl.put("BATCH_ID",resultSet.getString("BATCH_ID"));
							disp_drug_dtl.put("EXPIRY_DATE",resultSet.getString("EXPIRY_DATE"));
							disp_drug_dtl.put("STORE_CODE",resultSet.getString("STORE_CODE"));
							disp_drug_dtl.put("DISP_QTY",resultSet.getString("DISP_QTY"));
							disp_drug_dtl.put("DISP_QTY_UOM",resultSet.getString("DISP_QTY_UOM"));
							disp_drug_dtl.put("DRUG_CODE",resultSet.getString("DRUG_CODE"));
							disp_drug_dtl.put("DOC_SRL_NO",resultSet.getString("DOC_SRL_NO"));
							disp_drug_dtl.put("TRADE_ID",resultSet.getString("TRADE_ID"));
							// SRR20056-SCF-7628
							canProceed = true;
						}	
						closeResultSet( resultSet ) ; //ADDED FOR COMMON-ICN-0048
						pstmt_disp_dtl_tmp.setString(1,order_id);
						pstmt_disp_dtl_tmp.setString(2,order_line_no);
						resultSet	=	pstmt_disp_dtl_tmp.executeQuery();

						if(canProceed) {
							while(resultSet.next()){
								disp_drug_dtl.put("DISP_TMP_NO",resultSet.getString("DISP_TMP_NO"));
								disp_drug_dtl.put("DTL_SERIAL_NUM",resultSet.getString("DTL_SERIAL_NUM"));
								disp_drug_dtl.put("RECORD_DATE_TIME",resultSet.getString("RECORD_DATE_TIME"));
								// SRR20056-SCF-7628
								canProceed_tmp=true;
							}
						}
						else{ //else block added for MMS-SCF-0356 [IN:049289]
							canProceed_tmp=true;
							releaseBMS = true;
							hmBatchDtlExists.put(order_id+order_line_no+doc_srl_no, "N");
						}
						
						closeResultSet( resultSet ) ; //ADDED FOR COMMON-ICN-0060
						
						if(disp_drug_dtl != null && disp_drug_dtl.size()>0){
							disp_drugs.add(disp_drug_dtl);
						}
					}
					else{// if(!bms_qty.equals("") && Integer.parseInt(bms_qty)>0){ //else block added for ML-BRU-SCF-0674 [IN:037567]  //if condition commented for ML-BRU-SCF-1239 [IN:046910]
						canProceed_tmp = true;
						releaseBMS = true;
					}
				}
			}
			tabData.put("BatchDtlExists", hmBatchDtlExists); //Added for MMS-SCF-0356 [IN:049289]
		}
		catch(Exception e) {
			System.err.println("batch log insertion failed in EJB tabData="+tabData);
			e.printStackTrace();
			//SRR20056-SCF-7628 
			throw new Exception(" Release Batches Log insertion failed - takeDrugBatchDetails");
		}
		finally{	
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt_disp_drug_batch ) ;
				closeStatement( pstmt_disp_dtl_tmp ) ;
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
		return canProceed_tmp;		 // SRR20056-SCF-7628
	}

	private boolean insertBatchLog(Connection connection,HashMap tabData,HashMap sqlMap) throws Exception {

		String login_by_id		=	(String)tabData.get("login_by_id");
		String login_at_ws_no	=	(String)tabData.get("login_at_ws_no");
		String facility_id		=	(String)tabData.get("facility_id");
		PreparedStatement pstmt_batch_log_insert	=	null;
		HashMap	disp_drug_dtl	= new HashMap();
		boolean insert_rec_2		= false;

		try{
			pstmt_batch_log_insert		= connection.prepareStatement((String)sqlMap.get("SQL_PH_RELEASE_BATCHES_INSERT1"));
			if(disp_drugs.size() > 0){
				for(int i=0; i<disp_drugs.size(); i++) {
					disp_drug_dtl	= (HashMap)disp_drugs.get(i);
					if(disp_drug_dtl.size() > 0){
					    //SRR20056-SCF-7628  
						if((String)disp_drug_dtl.get("FACILITY_ID")== null ||(String)disp_drug_dtl.get("DISP_LOCN_CODE")== null || (String)disp_drug_dtl.get("DISP_TMP_NO")== null || (String)disp_drug_dtl.get("DTL_SERIAL_NUM")== null) {
							 insert_rec_2	  = false;
                            // throw new Exception("The drug/item has been updated by different user,please refresh and try again later"); 
						 }
						 else { 
						 // Till here added for SRR20056-SCF-7628
							pstmt_batch_log_insert.setString(1,(String)disp_drug_dtl.get("FACILITY_ID"));
							pstmt_batch_log_insert.setString(2,(String)disp_drug_dtl.get("DISP_LOCN_CODE"));
							pstmt_batch_log_insert.setString(3,(String)disp_drug_dtl.get("DISP_TMP_NO"));
							pstmt_batch_log_insert.setString(4,(String)disp_drug_dtl.get("DTL_SERIAL_NUM"));
							pstmt_batch_log_insert.setString(5,(String)disp_drug_dtl.get("RECORD_DATE_TIME"));
							pstmt_batch_log_insert.setString(6,(String)disp_drug_dtl.get("ORDER_ID"));
							pstmt_batch_log_insert.setString(7,(String)disp_drug_dtl.get("ORDER_LINE_NUM"));
							pstmt_batch_log_insert.setString(8,(String)disp_drug_dtl.get("DRUG_CODE"));
							pstmt_batch_log_insert.setString(9,(String)disp_drug_dtl.get("ITEM_CODE"));
							pstmt_batch_log_insert.setString(10,(String)disp_drug_dtl.get("BATCH_ID"));
							pstmt_batch_log_insert.setString(11,(String)disp_drug_dtl.get("EXPIRY_DATE"));
							pstmt_batch_log_insert.setString(12,(String)disp_drug_dtl.get("STORE_CODE"));
							pstmt_batch_log_insert.setString(13,(String)disp_drug_dtl.get("DISP_QTY"));
							pstmt_batch_log_insert.setString(14,(String)disp_drug_dtl.get("DISP_QTY_UOM"));
							pstmt_batch_log_insert.setString(15,(String)disp_drug_dtl.get("RELEASE_REASON_TYPE"));
							pstmt_batch_log_insert.setString(16,(String)disp_drug_dtl.get("RELEASE_REASON_CODE"));
							pstmt_batch_log_insert.setString(17,login_by_id);
							pstmt_batch_log_insert.setString(18,login_at_ws_no);
							pstmt_batch_log_insert.setString(19,facility_id);
							pstmt_batch_log_insert.setString(20,login_by_id);
							pstmt_batch_log_insert.setString(21,login_at_ws_no);
							pstmt_batch_log_insert.setString(22,facility_id);
							pstmt_batch_log_insert.setString(23,(String)disp_drug_dtl.get("TRADE_ID"));
							pstmt_batch_log_insert.addBatch();
						} 
					}
				}
				int[] result_insert_1= pstmt_batch_log_insert.executeBatch();

				for (int i=0;i<result_insert_1.length ;i++ ){
					if(result_insert_1[i]<0  && result_insert_1[i] != -2 ){
				 		insert_rec_2=false;
						System.err.println("batch log insertion failed in EJB tabData="+tabData);
						break;
					}
					else {
				 		insert_rec_2=true;
					}
				}
			}
		}
		catch(Exception e) {
			//connection.rollback();
			System.err.println("Exception EJB insertBatchLog tabData"+tabData);
			e.printStackTrace();
			//SRR20056-SCF-7628
			throw new Exception(" Release Batches Log insertion failed - insertBatchLog");
		}
		finally{	
			try {
				closeStatement( pstmt_batch_log_insert ) ;
			}
			catch(Exception es) { es.printStackTrace();}
		}
		return insert_rec_2;
	}

	public String getNumberOfPrescriptions(Connection connection,String order_id,String login_facility_id,HashMap sqlMap)throws Exception{

		//Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList arr_list=new ArrayList();
		String update_string="OS";
		try {
			//connection = getConnection(prop) ;
			pstmt = connection.prepareStatement((String)sqlMap.get("SQL_PH_RELEASE_BATCHES_SELECT8"));
//			pstmt = connection.prepareStatement("SELECT ORDER_LINE_STATUS FROM OR_ORDER_LINE WHERE ORDER_ID=?");
			pstmt.setString(1,order_id.trim());
			//pstmt.setString(2,login_facility_id.trim());
			//pstmt.setString(3,login_facility_id.trim());
			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next() ) {
				arr_list.add(resultSet.getString("ORDER_LINE_STATUS"));
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
			}else if(arr_list.contains("HC")){
				update_string="HC";
			}else if(arr_list.contains("DP")){
				update_string="DP";
			}else if(arr_list.contains("DF")){
				update_string="DF";
			}else if(arr_list.contains("UC")){
				update_string="UC";
			}else if(arr_list.contains("DC")){ //added for SKR-SCF-1552
				update_string="DC";
			}
		}
		catch ( Exception e ){
			System.err.println("Error while getNumberOfPrescriptions...order_id= "+order_id+" login_facility_id="+login_facility_id);
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				//closeConnection( connection,prop );
			}catch(Exception es){ 
				es.printStackTrace();
			}
		}
		return update_string;
	}
	//Added for SKR-SCF-1614 -Start
	
	private void updateOrOrdersLocn(Connection connection,String patient_id,String order_id,String encounter_id,String locn_code,String patient_class,String login_facility_id,String language_id) throws Exception {
		PreparedStatement pstmt_update	=	null;
		String disp_locn_code = "";
		boolean flag = false;

		try{
			pstmt_update	= connection.prepareStatement("UPDATE OR_ORDER SET SOURCE_CODE =?,PERFORMING_DEPTLOC_CODE = ? WHERE ORDER_ID = ?") ;
			
 				     disp_locn_code= getDispLocn(connection, patient_class, locn_code,patient_id,encounter_id,order_id,login_facility_id,language_id);
					if(disp_locn_code!=null && !disp_locn_code.equals("")){
						disp_locn_code = disp_locn_code.substring(0,disp_locn_code.indexOf("|"));
					}
//					System.err.println("disp_locn_code=====>"+disp_locn_code);
					if(disp_locn_code!=null && !disp_locn_code.equals("")){
						pstmt_update.setString(1,locn_code);
						pstmt_update.setString(2,disp_locn_code);
						pstmt_update.setString(3,order_id);
						pstmt_update.addBatch();
						flag = true;
					}
			if(flag){
				//int result[] = pstmt_update.executeBatch();
				pstmt_update.executeBatch(); //MODIFIED FOR COMMON-ICN-0048
			}

			
		}
		catch(Exception e ) {
			e.printStackTrace();
		}
		finally{	
			try {
				closeStatement( pstmt_update ) ;
				pstmt_update=null;
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
	}
	
	public String getCurrentLocn(Connection connection,String patient_id,String encounter_id){

		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String curr_locn		= "";

		try {
			
			pstmt				= connection.prepareStatement("select NURSING_UNIT_CODE from ip_open_encounter where  patient_class='IP' and patient_id=? and ENCOUNTER_ID=? ");
			pstmt.setString(1, patient_id);
			pstmt.setString(2, encounter_id);
			resultSet	= pstmt.executeQuery();
			if (resultSet != null && resultSet.next()) {
			 curr_locn = resultSet.getString("NURSING_UNIT_CODE")==null?"":resultSet.getString("NURSING_UNIT_CODE");
			 			 
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);

			}
			catch(Exception es){ 
				es.printStackTrace();
			}
		}
		
		return curr_locn;
}

	
public String getDispLocn(Connection connection,String patient_class, String locn_code,String patient_id,String encounter_id,String order_id,String login_facility_id,String language_id) {
		PreparedStatement pstmt_select		= null;
		ResultSet resultSet					= null;

		String perf_deptloc_code ="";
		
		PreparedStatement pstmt_select1		= null;
		ResultSet resultSet1				= null;
		String order_type_code="", drug_class="", drug_code="", priority="", home_leave_medn_yn="", take_home = "";
		
		try {

			pstmt_select1 = connection.prepareStatement("SELECT a.order_type_code, c.drug_class, b.order_catalog_code, a.priority, home_leave_medn_yn, discharge_ind FROM or_order a, or_order_line b, ph_drug c WHERE a.order_id = b.order_id AND b.order_catalog_code = c.drug_code  AND a.patient_id = ? AND a.encounter_id = ? AND a.order_id = ? AND a.order_category = 'PH'");

			pstmt_select1.setString(1,patient_id);
			pstmt_select1.setString(2,encounter_id);
			pstmt_select1.setString(3,order_id);
			
			resultSet1 = pstmt_select1.executeQuery() ;

			if(resultSet1!=null && resultSet1.next()){
				order_type_code =resultSet1.getString("order_type_code");
				drug_class =resultSet1.getString("drug_class");
				drug_code =resultSet1.getString("order_catalog_code");
			    priority=resultSet1.getString("priority");
				home_leave_medn_yn = resultSet1.getString("home_leave_medn_yn");
				take_home = resultSet1.getString("discharge_ind")==null?"":resultSet1.getString("discharge_ind");
			}
//System.err.println("===getDispLocn========formulary=========patient_class="+patient_class+" priority="+priority+" drug_code="+drug_code+" locn_type= take_home="+take_home+" order_type="+order_type_code+" drug_class="+drug_class+" home_leave_yn_val="+home_leave_medn_yn+" patient_id="+patient_id+" encounter_id="+encounter_id);

			if(patient_class.equals("I"))
				patient_class = "IP";
			
			if(take_home.equals(""))
				take_home = "N";

			pstmt_select = connection.prepareStatement( "SELECT PH_DISP_STOCK_LOCN(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) DISP_LOCN from dual");
			pstmt_select.setString(1,"N");
			pstmt_select.setString(2,locn_code);
			pstmt_select.setString(3,login_facility_id);
			pstmt_select.setString(4,login_facility_id);
			pstmt_select.setString(5,drug_class);
			pstmt_select.setString(6,drug_code);
			pstmt_select.setString(7,order_type_code);
			pstmt_select.setString(8,patient_class);
			pstmt_select.setString(9,take_home);
			pstmt_select.setString(10,priority);
			pstmt_select.setString(11,language_id);
			pstmt_select.setString(12,"D");
			pstmt_select.setString(13,home_leave_medn_yn);
			pstmt_select.setString(14,patient_id);
			pstmt_select.setString(15,encounter_id);
			pstmt_select.setString(16,"Y");

			resultSet = pstmt_select.executeQuery() ;
						
			if(resultSet!=null && resultSet.next()){
				perf_deptloc_code =resultSet.getString("DISP_LOCN");
			}
System.err.println("=perf_deptloc_code============>"+perf_deptloc_code);
			closeStatement(pstmt_select);
			closeStatement(pstmt_select1);
			closeResultSet(resultSet);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt_select);
				closeStatement(pstmt_select1);
				closeResultSet(resultSet1);
			}
			catch(Exception es) {
				es.printStackTrace() ;
			}
		}
		return perf_deptloc_code;
	}

	//Added for SKR-SCF-1614 -End
}
