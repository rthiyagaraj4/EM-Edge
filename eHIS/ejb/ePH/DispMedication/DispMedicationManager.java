 /*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer  program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
04/13/2017      63877   		chithra      UnusedLocal variable
13/08/2019      IN070987   		Manickavasagam J      SKR-SCF-1254
24/12/2019		IN070059        Shazana					ML-BRU-SCF-1927
06/02/2020		IN071362        Manickavasagam J        AAKH-CRF-0117
7/02/2020		IN072145		Shazana					SKR-SCF-1305   
12/2/2020		72188			Shazana 					SKR-SCF-1310 
9/4/2020		IN072656		Shazana					SKR-SCF-1319
7/5/2020		IN072353		Shazana					SKR-SCF-1315
09/10/2020    	IN74181        Manickavasagam J		  GHL-SCF-1514
29/11/2020    	TFS:6524        Manickavasagam J		  ML-BRU-SCF-2034
30/12/2020    	TFS:8046        Manickavasagam J		  PMG2020-ML-MMOH-CRF-0002
03/02/2021      TFS-13523	     Manickavasagam J         MOHE-CRF-0060
05/07/2021		TFS-19018        Prabha			          AMS-CRF-0258
21/07/2021		TFS-20859        Prabha			          SKR-SCF-1614
17/08/2021		TFS-21989        Manickavasagam J		   KAUH-SCF-0344
24/8/2021		TFS21019		Shazana						MOHE-CRF-0026.1 - US007
28/02/2022		29022			Shazana						Common-ICN-0090
11/4/2022		25961			Shazana						SKR-SCF-1652
08/09/2023		42882			Sushant Tambe				ML-MMOH-SCF-2401
---------------------------------------------------------------------------------------------------------------
*/
package ePH.DispMedication ;     
import java.rmi.* ;
import java.util.HashMap ;
import java.util.List ;    
import java.util.HashSet;
import java.util.Hashtable ;
import java.util.Enumeration ;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;
import java.util.Iterator;
import java.text.DecimalFormat;
import java.sql.* ;
import javax.ejb.* ;

import ePH.DispMedicationAllStages;//ADDED FOR ML-BRU-1799
import ePH.Common.PhEJBSessionAdapter ; 
import eCommon.Common.CommonBean ; //ADDED FOR ML-MMOH-CRF-1089

/**
*
* @ejb.bean
*	name="DispMedication"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="DispMedication"
*	local-jndi-name="DispMedication"
*	impl-class-name="ePH.DispMedication.DispMedicationManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.DispMedication.DispMedicationLocal"
*	remote-class="ePH.DispMedication.DispMedicationRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.DispMedication.DispMedicationLocalHome"
*	remote-class="ePH.DispMedication.DispMedicationHome"
*	generate= "local,remote" 
*
*
*/

public class DispMedicationManager extends PhEJBSessionAdapter {

	Properties prop         =   null;
	HashMap	 IR_FLAG		=	new HashMap();
	String   billing_det	=	"";
	ArrayList alSalDocDtls = null; //Added for AMS-CRF-0079 [IN:050762]
	HashMap hmBLDocSrlNo = new HashMap(); //Added for  [IN:043100]
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	// insert method starts here
    public HashMap insert( HashMap tabData, HashMap sqlMap )  {
		
		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "msgid", messages.toString() ) ;
		map.put( "flag","0");
		hmBLDocSrlNo = new HashMap(); //Added for  [IN:043100]
		alSalDocDtls = new ArrayList(); //Added for AMS-CRF-0079 [IN:050762]

		String query	=	(String)sqlMap.get("SQL_PH_DISP_MEDICATION_UPDATE1");
		String sql_2	=	(String)sqlMap.get("SQL_PH_DISP_MEDICATION_OR_ORDER_UPDATE");
		String sql_3	=	(String)sqlMap.get("SQL_PH_DISP_MEDICATION_DTL_UPDATE"); 
		String sql_4	=	(String)sqlMap.get("SQL_PH_DISP_MEDICATION_REFERRAL_ORDER_UPDATE"); 
		//String sql_5	=	(String)sqlMap.get("SQL_PH_DISP_MEDICATION_REFERRAL_ORDER_LINE_UPDATE1"); 
		String sql_5	=   "UPDATE OR_ORDER_LINE SET REFERRAL_YN ='Y',ORDER_LINE_STATUS='DF',REF_FACILITY_ID=? WHERE ORDER_ID = ? "; //REF_FACILITY_ID added for MOHE-SCF-0049
		Connection connection									= null ;
		PreparedStatement pstmt_insert_collection_date			= null;
		try{
		
			prop		= (Properties)tabData.get( "properties" );	
			connection	= getConnection( prop ) ;
			
			String flag=(String)tabData.get("flag");
			HashMap ir_flag=(HashMap)tabData.get("ORDER_DET");
			ArrayList order_details =(ArrayList)ir_flag.get("ORDER_DETAILS");
			if(order_details.size()>0){
				for(int i=0;i<order_details.size();i=i+2){
			
					pstmt_insert_collection_date = connection.prepareStatement(query);
					pstmt_insert_collection_date.setString(1,(String)tabData.get("next_collection_date"));
					pstmt_insert_collection_date.setString(2,(String)tabData.get("bmsReasonCode"));
					pstmt_insert_collection_date.setString(3,(String)tabData.get("login_by_id"));
					pstmt_insert_collection_date.setString(4,(String)tabData.get("facility_id"));
					pstmt_insert_collection_date.setString(5,(String)tabData.get("login_at_ws_no"));
					//pstmt_insert_collection_date.setString(5,(String)tabData.get("order_id"));
					//pstmt_insert_collection_date.setString(6,(String)tabData.get("order_id"));
					pstmt_insert_collection_date.setString(6,((String)order_details.get(i)).trim());
					pstmt_insert_collection_date.setString(7,((String)order_details.get(i)).trim());
					pstmt_insert_collection_date.executeUpdate();
					closeStatement( pstmt_insert_collection_date);

					if(flag.equals("C")){
						pstmt_insert_collection_date	=	connection.prepareStatement(sql_2);

						pstmt_insert_collection_date.setString(1,(String)tabData.get("ReRtdDispLocnCode"));
						pstmt_insert_collection_date.setString(2,(String)tabData.get("login_by_id"));
						pstmt_insert_collection_date.setString(3,(String)tabData.get("login_at_ws_no"));
						pstmt_insert_collection_date.setString(4,(String)tabData.get("facility_id"));
						//pstmt_insert_collection_date.setString(5,(String)tabData.get("order_id"));
						pstmt_insert_collection_date.setString(5,((String)order_details.get(i)).trim());
						pstmt_insert_collection_date.executeUpdate();
						closeStatement( pstmt_insert_collection_date);
						
						pstmt_insert_collection_date	=	connection.prepareStatement(sql_3);
						pstmt_insert_collection_date.setString(1,(String)tabData.get("ReRtdDispLocnCode"));
						pstmt_insert_collection_date.setString(2,(String)tabData.get("facility_id"));
						pstmt_insert_collection_date.setString(3,(String)tabData.get("disp_no"));		
						pstmt_insert_collection_date.executeUpdate();
						closeStatement( pstmt_insert_collection_date);
					}
					if(flag.equals("E")){
						pstmt_insert_collection_date	=	connection.prepareStatement(sql_4);
						pstmt_insert_collection_date.setString(1,(String)tabData.get("referral_facility"));
						pstmt_insert_collection_date.setString(2,(String)tabData.get("practioner_id"));
						pstmt_insert_collection_date.setString(3,(String)tabData.get("referral_remarks"));
						pstmt_insert_collection_date.setString(4,(String)tabData.get("login_by_id"));
						pstmt_insert_collection_date.setString(5,(String)tabData.get("login_at_ws_no"));
						pstmt_insert_collection_date.setString(6,(String)tabData.get("facility_id"));
						//pstmt_insert_collection_date.setString(7,(String)tabData.get("order_id"));
						pstmt_insert_collection_date.setString(7,((String)order_details.get(i)).trim());
						pstmt_insert_collection_date.executeUpdate();
						closeStatement( pstmt_insert_collection_date);
						
						pstmt_insert_collection_date	=	connection.prepareStatement(sql_5);
						//pstmt_insert_collection_date.setString(1,(String)tabData.get("order_id"));
						pstmt_insert_collection_date.setString(1,(String)tabData.get("referral_facility"));//added for MOHE-SCF-0049
						pstmt_insert_collection_date.setString(2,((String)order_details.get(i)).trim());
						pstmt_insert_collection_date.executeUpdate();
						closeStatement( pstmt_insert_collection_date);
					}
				}
			}
			connection.commit();
		}
		catch(Exception e){
			System.err.println("Error at 155 tabData"+tabData);
			e.printStackTrace();
			//connection.rollback();
			map.put( "result", new Boolean( false) ) ;
			map.put("msgid",e.toString());
			map.put("flag","0");//e.toString()
		}
		finally{
			try{
				connection.rollback();
				closeStatement( pstmt_insert_collection_date );
				pstmt_insert_collection_date=null;
				closeConnection( connection,prop );
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return map ;
	}
// insert method ends here

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
//  modify method starts here

	public HashMap modify( HashMap tabData, HashMap sqlMap ){
//		StringBuffer messages = new StringBuffer() ;
		
		HashMap map = new HashMap() ;
		hmBLDocSrlNo = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;	
		alSalDocDtls = new ArrayList(); //Added for AMS-CRF-0079 [IN:050762]

		if(tabData.get("updateNextCollDate")!=null){
			try{
				updateNextCollDate(tabData,sqlMap);
			}
			catch(Exception e){
				e.printStackTrace();

			}
		}
		else if(tabData.get("updateDTLValues")!=null){
			try{
				updateDTLValues(tabData,sqlMap);
				//Added for jd-crf-0221
				Connection oConnection					= null ;
				try{
						prop		= (Properties)tabData.get("properties");	
						oConnection	= getConnection( prop ) ;
						boolean siteEditTpn = new CommonBean().isSiteSpecific(oConnection, "PH","BMS_REMAEKS_APP");
						if(siteEditTpn)
						updateEditValues(tabData,sqlMap);
				}
					finally{
						try{
							closeConnection( oConnection,prop );
						}
						catch(Exception es){
							es.printStackTrace();
						}
					}
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}else if(tabData.get("PRINT_YN")!=null){ //added for GHL-CRF-453
			try{
				updatePrintValue(tabData,sqlMap);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}else{
			String disp_stage = (String)tabData.get("disp_stage");  
			String fill_list  = (String)tabData.get("fill_list");
			String filling_status ="";
			String disp_locn_catg  = (String)tabData.get("patient_class");
			try{
				if(disp_stage.equals("V")){
					map = completeVerification(tabData,sqlMap);
				}
				else if(disp_stage.equals("A")){
					filling_status = (String)tabData.get("filling_status");
					if(filling_status.equals("B")){
						if(tabData.get("Editable")!= null && tabData.get("Editable").toString().equals("true"))
							 map = completeAllocation(tabData,sqlMap);
						else
							map = completeAllocation1(tabData,sqlMap);
					}
					else{
						  map = completeAllocation(tabData,sqlMap);
					}
				}
				else if(disp_stage.equals("F")){
				   filling_status = (String)tabData.get("filling_status");
					if(filling_status.equals("A") &&(disp_locn_catg.equals("O")) ){
						if(tabData.get("Editable")!= null && tabData.get("Editable").toString().equals("true"))
							 map = completeFilling(tabData,sqlMap);
						else
							map = completeAllocation1(tabData,sqlMap);
					}
					else{
						  map = completeFilling(tabData,sqlMap);
					}
				}
				else if(disp_stage.equals("D")){
					if(fill_list != null && fill_list.equals("DWF") ){
						map = completeFillDelivery(tabData,sqlMap);	
					}
					else{
						map = completeDelivery(tabData,sqlMap);	
					}
				}
				else if(disp_stage.equals("AS")){
					map = completeDispensing(tabData,sqlMap);
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		map.put("SAL_DOC_DTLS", alSalDocDtls); //Added for AMS-CRF-0079 [IN:050762]
		return map;
	}
	/**	* @ejb.interface-method
	*	 view-type="both"
	*/
	// delete method starts here
	public HashMap delete( HashMap tabData, HashMap sqlMap )  {

		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		map.put( "msgid", messages.toString() ) ;
		return map ;
	}
	// delete method ends here

	public HashMap completeVerification(HashMap tabData,HashMap sqlMap ) throws Exception{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		Connection connection = null ;
		ArrayList patientDrugProfileData = (ArrayList)tabData.get("patientDrugProfileData");
		ArrayList orderLineData			 = (ArrayList)tabData.get("orderLineData");
		ArrayList orderLineData1			 = (ArrayList)tabData.get("orderLineData1");
		prop = (Properties)tabData.get( "properties" );		
		HashMap orderUpdate				 =	new HashMap();
		HashMap complte_order_status     =  new HashMap();
		String token_yn					 = (String)tabData.get("token_yn");
		try{
			connection = getConnection( prop ) ;
			
			// Update the table or_order_line
			orderUpdate	=	updateOrOrderLine(connection, sqlMap,orderLineData,tabData,"VF" );
			 insertVerifyRemarks(connection,sqlMap,tabData,orderLineData );
			// Get the line status
			//ord_line_status	=	getOrderLineStatus(connection,sqlMap,orderLineData,tabData);
			// Update the ph_patient_drug_profile
			updatePatientDrugProfile(connection,sqlMap,tabData,patientDrugProfileData);
			// Update or_order
			updateOrOrder(connection,sqlMap,tabData,orderLineData,orderUpdate,"VF");
			// Update or_order_line_ph
			updateOrOrderLinePh(connection,sqlMap,tabData,orderLineData,orderLineData1,complte_order_status);
			//Update Dispense Queue
			if(token_yn.equals("Y")) {
				updateDispQueue(connection, sqlMap, tabData,orderLineData,"V");
			}
			connection.commit();
			map.put( "result", new Boolean( true) ) ;
			map.put("msgid","RECORD_MODIFIED");
		}
		catch(Exception e){
			System.err.println("Error: Error while verification.tabData="+tabData);
			e.printStackTrace();
			connection.rollback();
			map.put( "result", new Boolean( false) ) ;
			map.put("msgid",e.toString());
			return map;
			//throw new EJBException("Error: Error while verification.");
		}
		finally{
			try{
				closeConnection( connection,prop );
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return map;
	}

	/*	Update OR_ORDER,OR_ORDER_LINE,PATIENT DRUG PROFILE
		If delivery stage is applicable 
			insert into TMP tables  (PH_DISP_DTL_TMP, PH_DISP_HDR_TMP,PH_DISP_DRUG_BATCH_TMP)
		else
			insert into Main tables (PH_DISP_DTL, PH_DISP_HDR, PH_DISP_DRUG_BATCH)*/

	public HashMap completeAllocation(HashMap tabData,HashMap sqlMap ) throws Exception{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		prop								= (Properties)tabData.get( "properties" );		
		Connection connection				= null ;
		String delivery_applicable			= (String)tabData.get("delivery_applicable");
		ArrayList orderLineData				= (ArrayList)tabData.get("orderLineData");
		ArrayList orderLineData1			= (ArrayList)tabData.get("orderLineData1");
		ArrayList patientDrugProfileData	= (ArrayList)tabData.get("patientDrugProfileData");
		ArrayList dispTMP					= (ArrayList)tabData.get("dispTMP");
		ArrayList alDispTMPForDeleteSales	= (ArrayList)tabData.get("DispTMPForDeleteSales");
		String patient_class				= (String)tabData.get("patient_class");
		String facility_id					= (String)tabData.get("facility_id");
		ArrayList<String> arrMedPlanSeqNo	= (ArrayList)tabData.get("arrMedPlanSeqNo");// Added for  Bru-HIMS-CRF-072.1[IN 049144]
		String isMedValuesChanged			= (String)tabData.get("isMedValuesChanged");// Added for  Bru-HIMS-CRF-072.1[IN 049144]
		//ArrayList arrInterfaceDet  = new ArrayList(); //MOHE-CRF-0026.1  //Commented for COMMON-ICN-0048
		if(patient_class.equals("XT")) {
			tabData.put("encounter_id","11111");
		}

		String update_string				= "";
		String st_doc_type					= "";
		HashMap	stock_srl					=	new HashMap();
		HashMap prev_doc_no					=	new HashMap();
		HashMap orderUpdate					=	new HashMap();
		//ArrayList details					=   new ArrayList();
		String disp_stage					=   (String)tabData.get("disp_stage");  
		String token_yn						=   (String)tabData.get("token_yn"); 
		//String fill_list				    =   (String)tabData.get("fill_list");
		HashMap complte_order_reason		=   (HashMap)tabData.get("complte_order_reason");
		String valuesChanged = (String)tabData.get("ValuesChanged")==null?"":(String)tabData.get("ValuesChanged"); 
		String fill_list = (String)tabData.get("fill_list")==null?"":(String)tabData.get("fill_list"); 
		ArrayList dispMedStages	= (ArrayList)tabData.get("dispMedStages");
		ArrayList tot_cons_dtl = (ArrayList)tabData.get("CONSUMABLES_DET");//added  for AMS-SCF-0224[IN036937]

		PreparedStatement pstmt_print_seq_no	= null;//Added for RUT-CRF-0061
		ResultSet resultSet1					= null;//Added for RUT-CRF-0061
		String print_seq_no						=	"";//Added for RUT-CRF-0061
		String mediplan_seq_no ="";//Added for Bru-HIMS-CRF-072.1[IN 049144]
		HashMap editableLabel			= tabData.get("editableLabel")!=null?(HashMap)tabData.get("editableLabel"):null; // Added for Bru-HIMS-CRF-414 [IN:045554]
		String allow_edit_disp_label	= tabData.get("allow_edit_disp_label")!=null?(String)tabData.get("allow_edit_disp_label"):""; // Added for Bru-HIMS-CRF-414 [IN:045554]
		if(dispMedStages ==null || dispMedStages.size()==0)
			dispMedStages.add(disp_stage);
		if(!((disp_stage.equals("F")&&patient_class.equals("O") )|| fill_list.equals("AF")))
			valuesChanged = "true";

		if(disp_stage.equals("A"))
			update_string	=	"AL";
		else if(disp_stage.equals("F"))
			update_string	=	"IP";
		try{
			connection = getConnection( prop ) ;
			
			// Get the Stock Doc Type 
			st_doc_type	=	getStockDocType(connection,sqlMap,patient_class,facility_id);
			if(st_doc_type==null || st_doc_type.equals("")){
				  throw new Exception("APP-PH0902 Document Type is not defined for the Current facility ");
			}
			// Update the table or_order_line
			orderUpdate	=	updateOrOrderLine(connection, sqlMap,orderLineData,tabData,update_string );
			updateOrOrderLinePh(connection,sqlMap,tabData,orderLineData,orderLineData1,complte_order_reason);
			// Get the line status
			//ord_line_status	=	getOrderLineStatus(connection,sqlMap,orderLineData,tabData);

			HashMap stock_vals		= new HashMap();

			if(tabData.get("fill_list")!= null && tabData.get("fill_list").toString().equals("AF") && alDispTMPForDeleteSales != null)
				stock_vals		=	getDocValues(connection,sqlMap,orderLineData,alDispTMPForDeleteSales,tabData);
			else
				stock_vals		=	getDocValues(connection,sqlMap,orderLineData,dispTMP,tabData);
			//if((disp_stage.equals("F") && (filling_status.equals("A")  ))|| (disp_stage.equals("A") && (filling_status.equals("B")  )) ){

			// Get the previous docno and doctype
			if(stock_vals.size() > 1 ) {
				prev_doc_no		= (HashMap)stock_vals.get("doc_no");
				//prev_doc_type	= (HashMap)stock_vals.get("doc_type");
				stock_srl		= (HashMap)stock_vals.get("srl_no");
			}
			//To generate Daily SEQ Number
			tabData.put("DailySeqNo",getSeqNumber(connection,tabData.get("facility_id").toString(),tabData.get("store_code").toString()));
			//To save the daily sequence numbers set by IPFill before delete of the tmp tables
			HashMap hmDailySeqNumbers = null;
			if(tabData.get("fill_list")!= null && tabData.get("fill_list").toString().equals("AF")){
				hmDailySeqNumbers = getDailySquNumbersBackUp(orderLineData,sqlMap.get("SQL_PH_SEQ_NO_FOR_IP_FILL_SELECT").toString());
				tabData.put("hmDailySeqNumbers",hmDailySeqNumbers);
			}
			
			pstmt_print_seq_no = connection.prepareStatement("SELECT OFFLINE_PRINT_SEQ.NEXTVAL PRINT_SEQ_NO FROM DUAL");//PRINT_SEQ_NO Added for RUT-CRF-0061 - Start
			resultSet1 = pstmt_print_seq_no.executeQuery() ;
			if( resultSet1!=null && resultSet1.next() ) {
				print_seq_no = resultSet1.getString("PRINT_SEQ_NO");
			}
			closeStatement(pstmt_print_seq_no);
			closeResultSet( resultSet1 ) ;
			tabData.put("print_seq_no_tmp",print_seq_no);//PRINT_SEQ_NO Added for RUT-CRF-0061 - End
				
			// Delete tmp tables
			//if(fill_list.equals("AF")){
			if(valuesChanged.equals("true")){
				if(!patient_class.equals("I") && ((String)tabData.get("strMedPlanYN")).equals("Y")){
					HashMap hshdispno = new HashMap();
					pstmt_print_seq_no = connection.prepareStatement("SELECT DISP_TMP_NO,DTL_SERIAL_NUM FROM PH_DISP_DTL_TMP WHERE ORDER_ID=? AND ORDER_LINE_NO=?") ;
					for(int i=0;i<dispTMP.size();i=i+7){
						pstmt_print_seq_no.setString(1,(String)dispTMP.get(i));
						pstmt_print_seq_no.setString(2,(String)dispTMP.get(i+1));
						resultSet1 = pstmt_print_seq_no.executeQuery() ;
						if( resultSet1.next() ) {
							hshdispno.put((String)dispTMP.get(i)+"~"+(String)dispTMP.get(i+1), resultSet1.getString("DISP_TMP_NO")+"~"+resultSet1.getString("DTL_SERIAL_NUM"));
						}
					}
					tabData.put("hshdispno_old", hshdispno);
				}
				closeStatement(pstmt_print_seq_no);//connection closed  -based on Checkstyle
				deleteTMPTables(connection,sqlMap,orderLineData,tabData);
				if(tabData.get("fill_list")!= null && tabData.get("fill_list").toString().equals("AF") && alDispTMPForDeleteSales != null)
					deletesales(connection,tabData,alDispTMPForDeleteSales,prev_doc_no,st_doc_type,sqlMap,stock_srl);
				else
					deletesales(connection,tabData,dispTMP,prev_doc_no,st_doc_type,sqlMap,stock_srl);
			}
			//}
			// Update the ph_patient_drug_profile
			updatePatientDrugProfile(connection,sqlMap,tabData,patientDrugProfileData);
			// Update or_order
			updateOrOrder(connection,sqlMap,tabData,orderLineData,orderUpdate,update_string);
			//Update Dispense Queue
			if(token_yn.equals("Y")) {
				updateDispQueue(connection, sqlMap, tabData,orderLineData,disp_stage);
			}
			if(valuesChanged.equals("true") ||  !delivery_applicable.equals("Y")){
				if(  delivery_applicable.equals("Y") || !((String)dispMedStages.get(dispMedStages.size()-1)).equals(disp_stage) ){
					// Insert into PH_DISP_HDR_TMP
					HashMap seq_no	=	insertHeaderTMP(connection,sqlMap,tabData,dispTMP);
					// Insert in to PH_DISP_DTL_TMP
					stock_srl	    = new HashMap();
					stock_srl		=	insertDetailTMP(connection, sqlMap,tabData,dispTMP,seq_no,stock_srl);
					if(!patient_class.equals("I") && ((String)tabData.get("strMedPlanYN")).equals("Y")){// AniT code Added for  Bru-HIMS-CRF-072.1[IN 049144] start
						if(valuesChanged.equals("true")){
							tabData.put("hshdispno_new", stock_srl);
							updateMedPlanDispNo(connection,sqlMap,tabData,dispTMP);
						}
						if(isMedValuesChanged.equals("true")){
							if(arrMedPlanSeqNo.size()==0)
								mediplan_seq_no = insertMedicationPlan(connection, sqlMap,tabData,stock_srl);// If there is no medication plan id, generate plan id and insert the values
							else if(arrMedPlanSeqNo.size()==1){
								tabData.put("mediplan_seq_no",(String)arrMedPlanSeqNo.get(0));
								mediplan_seq_no = updateMedicationPlan(connection, sqlMap,tabData);// If there is one medication plan id, update the values
							}
							else{// If there is more than one medication plan id, generate new plan id and insert the values. Delete old plan id records along with order id and order line number 
								mediplan_seq_no = insertMedicationPlan(connection, sqlMap,tabData,stock_srl);
								deleteMedicationPlan(connection,sqlMap,tabData);
							}
						}
						else
							updateMediPlan_DispStage(connection, sqlMap, tabData);
					}// Added for  Bru-HIMS-CRF-072.1[IN 049144] end
					if(tabData.get("ordType")!=null && tabData.get("hmPPNValues")!=null){
						insertToPPNOrders(connection,(String)sqlMap.get("SQL_PH_PPN_ORDERS_INSERT"),tabData,seq_no);
					}
					// Update Daily Seq Numbers
					//if(hmDailySquNumbers != null)
					//	updateDailySquNosInTmpTables(hmDailySquNumbers);

					// Insert in to PH_DISP_DRUG_BATCH_TMP
					insertBatchTMP(connection,sqlMap,tabData,dispTMP,seq_no,stock_srl);
					//code for inserting PH_DISP_CONS_DTL
					if(tot_cons_dtl!=null && tot_cons_dtl.size()>0){ //added if condition for AMS-SCF-0224[IN036937]
						insertConsumableDeatil(connection,sqlMap,tabData);
						//code for inserting PH_DISP_CONS_BATCH
						insertConsumableBatch(connection,sqlMap,tabData);
					}
					
					tabData.put("seq_no",seq_no);
					//this part of code is used for preparing disp_tmp details on following conditions
					//1.if order contains three drugs and each order line is filled/allocated separately then  following    code is used
					//2.old data in disp_tmp tables will remain same
					//3.stock blocked for these order will be released and blocked again.
					/*(disp_stage.equals("A")){
						deletesales(connection,tabData,dispTMP,prev_doc_no,st_doc_type);
						details		= prepareDispTMPDeatils(connection,sqlMap,tabData);
						dispTMP		= new ArrayList();
						stock_srl	= new HashMap();
						stock_srl	= (HashMap)details.get(0);
						dispTMP		= (ArrayList)details.get(1);
					}*/
					//end here
					//	Stock Insertion starts
					if(dispTMP.size()>0){
						callStockUpdate(connection,tabData,sqlMap,dispTMP,prev_doc_no,st_doc_type,stock_srl);
					}
				}
				else{
					HashMap seq_no	=	insertHeader( connection,sqlMap,tabData,dispTMP );
					stock_srl	    =   new HashMap();
					stock_srl		=	insertDetail(connection,sqlMap,tabData,dispTMP,seq_no,stock_srl);
					if(!patient_class.equals("I") && ((String)tabData.get("strMedPlanYN")).equals("Y")){// AniT code Added for  Bru-HIMS-CRF-072.1[IN 049144] start
						if(isMedValuesChanged.equals("true")){
							if(arrMedPlanSeqNo.size()==0)
								mediplan_seq_no = insertMedicationPlan(connection, sqlMap,tabData,stock_srl);
							else if(arrMedPlanSeqNo.size()==1){
								tabData.put("mediplan_seq_no",(String)arrMedPlanSeqNo.get(0));
								mediplan_seq_no = updateMedicationPlan(connection, sqlMap,tabData);
							}
							else{
								mediplan_seq_no = insertMedicationPlan(connection, sqlMap,tabData,stock_srl);
								deleteMedicationPlan(connection,sqlMap,tabData);
							}
						}
						else
							updateMediPlan_DispStage(connection, sqlMap, tabData);
					}// Added for  Bru-HIMS-CRF-072.1[IN 049144] end
					insertBatch(connection, sqlMap,tabData,dispTMP,seq_no);
					//code for inserting PH_DISP_CONS_DTL
					if(tot_cons_dtl!=null && tot_cons_dtl.size()>0){ //added if condition for AMS-SCF-0224[IN036937]
						insertConsumableDeatil(connection,sqlMap,tabData);
						//code for inserting PH_DISP_CONS_BATCH
						insertConsumableBatch(connection,sqlMap,tabData);
					}

					tabData.put("disp_stage","D");
					tabData.put("seq_no",seq_no);
					//	Stock Insertion starts
					if(dispTMP.size()>0){
					   callStockUpdate(connection,tabData,sqlMap,dispTMP,prev_doc_no,st_doc_type,stock_srl);
					}
					if(allow_edit_disp_label.equals("Y") && editableLabel!=null && editableLabel.size()>0 ){ //if block Added for Bru-HIMS-CRF-414 [IN:045554]
						insertUpdateDispLabelDtl(connection, sqlMap,tabData, dispTMP);
					}
				}	
			}
			else{
				updateHeaderTMP(connection,tabData,sqlMap,dispTMP);
				if(((String)dispMedStages.get(dispMedStages.size()-2)).equals(disp_stage) ){
					updateDetailTmp(connection,tabData,sqlMap,dispTMP);//code added for ML-BRU-SCF-0971[IN042220]
					if(!patient_class.equals("I") && ((String)tabData.get("strMedPlanYN")).equals("Y")){// AniT code Added for  Bru-HIMS-CRF-072.1[IN 049144] start
						if(isMedValuesChanged.equals("true")){
							if(arrMedPlanSeqNo.size()==0)
								mediplan_seq_no = insertMedicationPlan(connection, sqlMap,tabData,stock_srl);
							else if(arrMedPlanSeqNo.size()==1){
								tabData.put("mediplan_seq_no",(String)arrMedPlanSeqNo.get(0));
								mediplan_seq_no = updateMedicationPlan(connection, sqlMap,tabData);
							}
							else{
								mediplan_seq_no = insertMedicationPlan(connection, sqlMap,tabData,stock_srl);
								deleteMedicationPlan(connection,sqlMap,tabData);
							}
						}
						else
							updateMediPlan_DispStage(connection, sqlMap, tabData);
					}// Added for  Bru-HIMS-CRF-072.1[IN 049144] end
					if(allow_edit_disp_label.equals("Y") && editableLabel!=null && editableLabel.size()>0 ){ //if block Added for Bru-HIMS-CRF-414 [IN:045554]
						insertUpdateDispLabelDtl(connection, sqlMap,tabData, dispTMP);
					}
				}
			}
			 ArrayList barcode_remarks= (ArrayList)tabData.get("barcode_remarks");
			if(barcode_remarks!=null && barcode_remarks.size()>0)
			insertBarcodeScanCount(connection,tabData);//Added for MMS-DM-CRF-0157.1
			connection.commit();
			if(!mediplan_seq_no.equals(""))//Added for Bru-HIMS-CRF-072.1[IN 049144]
				map.put( "mediplan_seq_no", mediplan_seq_no ) ;
			map.put( "print_seq_no_tmp", print_seq_no ) ;//Added for RUT-CRF-0061
			map.put( "result", new Boolean( true) ) ;
			map.put("msgid","RECORD_MODIFIED");
		}
		catch(Exception e){
			e.printStackTrace();
			connection.rollback();
			map.put( "result", new Boolean( false) ) ;
			map.put("msgid",e.toString());
			map.put("flag",e.toString());
			System.err.println("Error: Error while allocation. tabData="+tabData+" ==========map="+map);
			return map;
			//throw new EJBException("Error: Error while allocation.");
		}
		finally{
			closeConnection( connection,prop );
		}
		return map;
	}

	public HashMap completeFilling(HashMap tabData,HashMap sqlMap ) throws Exception{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		map = completeAllocation(tabData,sqlMap);
		return map;
	}

	public HashMap completeAllocation1(HashMap tabData,HashMap sqlMap ) throws Exception{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		prop								= (Properties)tabData.get( "properties" );		
		Connection connection				= null ;
		ArrayList orderLineData				= (ArrayList)tabData.get("orderLineData");
		ArrayList orderLineData1			= (ArrayList)tabData.get("orderLineData1");
		ArrayList patientDrugProfileData	= (ArrayList)tabData.get("patientDrugProfileData");
		//ArrayList dispTMP					= (ArrayList)tabData.get("dispTMP");
		String patient_class				= (String)tabData.get("patient_class");
		//String facility_id					= (String)tabData.get("facility_id");
		ArrayList<String> arrMedPlanSeqNo	= (ArrayList)tabData.get("arrMedPlanSeqNo");// Added for  Bru-HIMS-CRF-072.1[IN 049144]
		String isMedValuesChanged			= (String)tabData.get("isMedValuesChanged");// Added for  Bru-HIMS-CRF-072.1[IN 049144]
		String mediplan_seq_no="";// Added for  Bru-HIMS-CRF-072.1[IN 049144]
		HashMap	stock_srl =	new HashMap();// Added for  Bru-HIMS-CRF-072.1[IN 049144]
		if(patient_class.equals("XT")) {
			tabData.put("encounter_id","11111");
		}

		String update_string				= "";		
		HashMap orderUpdate					=	new HashMap();
		String disp_stage					=   (String)tabData.get("disp_stage");  
		String token_yn						=   (String)tabData.get("token_yn"); 
		HashMap complte_order_reason		=   (HashMap)tabData.get("complte_order_reason");

		if(disp_stage.equals("A"))
			update_string	=	"AL";
		else if(disp_stage.equals("F"))
			update_string	=	"IP";
		try{
			connection = getConnection( prop ) ;
			// Get the Stock Doc Type 
			//st_doc_type	=	getStockDocType(connection,sqlMap,patient_class,facility_id);
			// Update the table or_order_line
			orderUpdate	=	updateOrOrderLine(connection, sqlMap,orderLineData,tabData,update_string );
			updateOrOrderLinePh(connection,sqlMap,tabData,orderLineData,orderLineData1,complte_order_reason);
			// Update the ph_patient_drug_profile
			updatePatientDrugProfile(connection,sqlMap,tabData,patientDrugProfileData);
			// Update or_order
			updateOrOrder(connection,sqlMap,tabData,orderLineData,orderUpdate,update_string);
			//Update Dispense Queue
			if(token_yn.equals("Y")) {
				updateDispQueue(connection, sqlMap, tabData,orderLineData,disp_stage);
			}
			if(!patient_class.equals("I") && ((String)tabData.get("strMedPlanYN")).equals("Y")){// AniT code Added for  Bru-HIMS-CRF-072.1[IN 049144] start
				if(isMedValuesChanged.equals("true")){
					if(arrMedPlanSeqNo.size()==0)
						mediplan_seq_no = insertMedicationPlan(connection, sqlMap,tabData,stock_srl);
					else if(arrMedPlanSeqNo.size()==1){
						tabData.put("mediplan_seq_no",(String)arrMedPlanSeqNo.get(0));
						mediplan_seq_no = updateMedicationPlan(connection, sqlMap,tabData);
					}
					else{
						mediplan_seq_no = insertMedicationPlan(connection, sqlMap,tabData,stock_srl);
						deleteMedicationPlan(connection,sqlMap,tabData);
					}
				}
				else
					updateMediPlan_DispStage(connection, sqlMap, tabData);
			}// Added for  Bru-HIMS-CRF-072.1[IN 049144] end
			connection.commit();
			if(!mediplan_seq_no.equals(""))//Added for Bru-HIMS-CRF-072.1[IN 049144]
				map.put( "mediplan_seq_no", mediplan_seq_no ) ;
			map.put( "result", new Boolean( true) ) ;
			map.put("msgid","RECORD_MODIFIED");
		}
		catch(Exception e){
			e.printStackTrace();
			connection.rollback();
			map.put( "result", new Boolean( false) ) ;
			map.put("msgid",e.toString());
			map.put("flag",e.toString());
			System.err.println("Error: Error while allocation(completeAllocation1).tabData="+tabData+" ==========map="+map);
			return map;
			//throw new EJBException("Error: Error while allocation.");
		}
		finally{
			closeConnection( connection,prop );
		}
		return map;
	}
	
	public HashMap completeFillDelivery(HashMap tabData,HashMap sqlMap ) throws Exception{
		Connection connection									= null;
		CallableStatement cstmt									= null;
		PreparedStatement pstmt_update_order_line_ph			= null;
		PreparedStatement pstmt_update_ph_patient_drug_profile	= null;
		PreparedStatement pstmt_select_order_line_ph			= null;
		PreparedStatement pstmt_select_order_line_ph1			= null;
		PreparedStatement pstmt_select_order_line_ph2			= null;
		ResultSet		  resultSet								= null;
		PreparedStatement pstmt_select							= null;
		ResultSet		  resultSet1							= null;
		PreparedStatement pstmt_select1							= null;
		PreparedStatement pstmt_update_disp_dtl_tmp				= null;
		HashMap map												= new HashMap() ;

		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		
		prop						= (Properties)tabData.get( "properties" );
		String login_by_id			= (String)tabData.get("login_by_id");
		String login_at_ws_no		= (String)tabData.get("login_at_ws_no");
		String facility_id			= (String)tabData.get("facility_id");
		String dateTime				= (String)tabData.get("dateTime");
		//String today				= (String)tabData.get("today");
		//String strFill_List			= (String)tabData.get("fill_list");
		String strFillProcId		= (String)tabData.get( "fill_proc_id");
		//String strDispLocnCode		= (String)tabData.get( "disp_locn_code");
		String strPatientClass		= (String)tabData.get( "patient_class");		
		HashMap mpDispTmp		    = (HashMap) tabData.get( "dispTmp" );
		Hashtable pa_ord_sel_ht		= (Hashtable)tabData.get("pat_ord_sel");
		HashMap hmOrderLineNumbers	= (HashMap)tabData.get("hmOrderLineNumbers");
		String st_doc_type			=	"";
		String sFreqNature			=	"";
		String LanguageId			= (String)tabData.get("LanguageId");
		HashMap trn_rx_ids_patientwise	= (HashMap)tabData.get("TRN_RX_IDS_PATIENTWISE");
		//ArrayList arrInterfaceDet = new ArrayList();//added for MOHE-CRF-0026.1  //Commented for COMMON-ICN-0048
		try{
			connection			    = getConnection(prop) ;
			if(strPatientClass.equals("I")){
				pstmt_update_order_line_ph				= connection.prepareStatement( (String) sqlMap.get("SQL_PH_DISP_IP_ORDER_LINE_PH_UPDATE") ); 
				//pstmt_select_order_line_ph			= connection.prepareStatement( (String) sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT111") );
				pstmt_select_order_line_ph				= connection.prepareStatement("SELECT PRESCRIBED_MODE,TO_CHAR(SYSDATE+DURATION,'DD/MM/YYYY HH24:MI') NEXT_FILL_DATE, (select freq_nature from am_frequency where freq_code = PH_PATIENT_DRUG_PROFILE.freq_code) FREQ_NATURE FROM PH_PATIENT_DRUG_PROFILE WHERE ORIG_ORDER_ID=? AND ORIG_ORDER_LINE_NO=?");
				pstmt_select_order_line_ph1				= connection.prepareStatement( (String) sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT112") );
				pstmt_select_order_line_ph2				= connection.prepareStatement( (String) sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT108" )) ;
				pstmt_update_ph_patient_drug_profile	= connection.prepareStatement( (String) sqlMap.get("SQL_PH_DISP_MEDICATION_PATIENT_DRUG_PROFILE_UPDATE_FOR_DEL_AF" )) ;
				pstmt_select							= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT134"));
				pstmt_select1							= connection.prepareStatement( "select content_in_pres_base_uom from ph_drug a,ph_patient_drug_profile b where a. drug_code=b.drug_code 	and orig_order_id =? AND b.orig_ORDER_LINE_No=?");
				pstmt_update_disp_dtl_tmp	= connection.prepareStatement(  (String)sqlMap.get("SQL_PH_DISP_MEDICATION_DTL_TMP_UPDATE_ALT_DRUG_REMARKS"));

				ArrayList alPaOrdTmp	=   new ArrayList();
				String strPatIdTmp		=	"";
				String next_date		=	"";
				String ord_id			=	"";
				String order_line		=	"";
				String pres_mode		=	"";
				String drug_desc		=   null;	
				StringBuffer disp_drugs	=	new StringBuffer();
				//ArrayList order_det		=	new ArrayList();
				String content_in_pres_base_uom = "";
				Enumeration enPatOrd	= pa_ord_sel_ht.keys();
				ArrayList alOrderLineNos = null;
				HashMap hmAltDrugRemarks	=  (HashMap)tabData.get("ALTDRUGREMARKS");
				String alt_drug_remarks="";
				while(enPatOrd.hasMoreElements() ){
					strPatIdTmp			= (String) enPatOrd.nextElement();
					alPaOrdTmp			= (ArrayList) pa_ord_sel_ht.get(strPatIdTmp);
					int nAlOrdsize		= alPaOrdTmp.size();
					for(int nCtr = 0; nCtr < nAlOrdsize; nCtr++){
						ord_id					 = (String) alPaOrdTmp.get(nCtr);
						alOrderLineNos = (ArrayList)hmOrderLineNumbers.get(ord_id);
						for(int p=0;p<alOrderLineNos.size();p++){
							order_line			 = (String)alOrderLineNos.get(p);
							pstmt_select_order_line_ph.setString(1,ord_id);
							pstmt_select_order_line_ph.setString(2,order_line);
							//SELECT PRESCRIBED_MODE,TO_CHAR(SYSDATE+DURATION,'DD/MM/YYYY HH24:MI') NEXT_FILL_DATE,
							//(select freq_nature from am_frequency where freq_code = PH_PATIENT_DRUG_PROFILE.freq_code)  freq_nature 
							//FROM PH_PATIENT_DRUG_PROFILE WHERE ORIG_ORDER_ID='PHIP00000044514' AND ORIG_ORDER_LINE_NO=1
							resultSet = pstmt_select_order_line_ph.executeQuery();

							if(resultSet.next()) {
								pres_mode    = resultSet.getString("PRESCRIBED_MODE");
								next_date    = resultSet.getString("NEXT_FILL_DATE");
								sFreqNature  = resultSet.getString("FREQ_NATURE");
							}
		
							//select freq_nature from am_frequency where freq_code = ?
							if(!pres_mode.equals("A") || sFreqNature.equals("P")) {				
								closeResultSet( resultSet );
								pstmt_select_order_line_ph1.setString(1,strFillProcId);
								resultSet	=	pstmt_select_order_line_ph1.executeQuery();

								if(resultSet.next()) {
									next_date	=	resultSet.getString("FILL_INT_END_DATE_TIME");
								}
							}
						
							closeResultSet( resultSet );
							disp_drugs	=	new StringBuffer();
							
							pstmt_select.setString(1,facility_id);
							pstmt_select.setString(2,ord_id);
							pstmt_select.setString(3,order_line);
							pstmt_select.setString(4,LanguageId);

							resultSet	=	pstmt_select.executeQuery();
							while(resultSet.next()) {
								drug_desc	=	resultSet.getString("DRUG_DESC");
								disp_drugs.append(","+drug_desc);
							}	
							
							closeResultSet( resultSet );
							content_in_pres_base_uom ="";
							
							pstmt_select1.setString(1,ord_id);
							pstmt_select1.setString(2,order_line);

							resultSet1	=	pstmt_select1.executeQuery();
							if(resultSet1.next()) {
								content_in_pres_base_uom	=	resultSet1.getString("content_in_pres_base_uom");
							}
							pstmt_update_order_line_ph.setString(1,next_date);	
							pstmt_update_order_line_ph.setString(2,dateTime);	
							pstmt_update_order_line_ph.setString(3,login_by_id);		// modified id
							pstmt_update_order_line_ph.setString(4,facility_id);		// modified facility
							pstmt_update_order_line_ph.setString(5,login_at_ws_no);		// modified work station
							pstmt_update_order_line_ph.setString(6,ord_id);
							pstmt_update_order_line_ph.setString(7,order_line);
							pstmt_update_order_line_ph.addBatch();

							alt_drug_remarks = ""; // Added for Bru-HIMS-CRF-082 [IN:029948]-start
							if(hmAltDrugRemarks!=null && hmAltDrugRemarks.containsKey(ord_id+"~"+order_line)){
								alt_drug_remarks = (String)hmAltDrugRemarks.get(ord_id+"~"+order_line);
							} // Added for Bru-HIMS-CRF-082 [IN:029948]-end
							if(sFreqNature.equals("P")||pres_mode.equals("A")){
								pstmt_update_ph_patient_drug_profile.setString(1,"1"); 
							}
							else{
								pstmt_update_ph_patient_drug_profile.setString(1,content_in_pres_base_uom); 
							}
							pstmt_update_ph_patient_drug_profile.setString(2,ord_id); //ORDER_ID
							pstmt_update_ph_patient_drug_profile.setString(3,order_line);//ORDER_LINE_NUM
							pstmt_update_ph_patient_drug_profile.setString(4,disp_drugs.toString());//ORDER_ID
							//pstmt_update_ph_patient_drug_profile.setString(4,order_line);//ORDER_LINE_NUM
							pstmt_update_ph_patient_drug_profile.setString(5,login_by_id);	// modified id
							pstmt_update_ph_patient_drug_profile.setString(6,login_at_ws_no);	// modified work station
							pstmt_update_ph_patient_drug_profile.setString(7,facility_id);	// modified facility
							pstmt_update_ph_patient_drug_profile.setString(8,alt_drug_remarks);	// Added for Bru-HIMS-CRF-082 [IN:029948]-start
							pstmt_update_ph_patient_drug_profile.setString(9,ord_id);//ORDER_ID
							pstmt_update_ph_patient_drug_profile.setString(10,order_line);//ORDER_LINE_NUM
							pstmt_update_ph_patient_drug_profile.addBatch();

							if(alt_drug_remarks!=null && !alt_drug_remarks.equals("")){ // if block Added for Bru-HIMS-CRF-082 [IN:029948]
								pstmt_update_disp_dtl_tmp.setString(1,alt_drug_remarks);
								pstmt_update_disp_dtl_tmp.setString(2,login_by_id);
								pstmt_update_disp_dtl_tmp.setString(3,login_at_ws_no);
								pstmt_update_disp_dtl_tmp.setString(4,facility_id);
								pstmt_update_disp_dtl_tmp.setString(5,ord_id);
								pstmt_update_disp_dtl_tmp.setString(6,order_line);
								pstmt_update_disp_dtl_tmp.addBatch();
							}
						}
					}
				}

				if(pstmt_update_order_line_ph != null){
					int result[] = pstmt_update_order_line_ph.executeBatch();

					for (int i=0;i<result.length ;i++ ){
							// A number greater than or equal to zero  indicates success
							// A number -2 indicates that command is successful but number of rows updated is unknow
							// If it won't satisfy any of the above cancel the statement and throw an exception
						if(result[i]<0  && result[i] != -2 ){
							pstmt_update_order_line_ph.cancel();
							connection.rollback();
							throw new EJBException("Update OR_ORDER_LINE_PH failed");
						}		
					}
				}

				if(pstmt_update_ph_patient_drug_profile != null){
					int result[] = pstmt_update_ph_patient_drug_profile.executeBatch();

					for (int i=0;i<result.length ;i++ ){
							// A number greater than or equal to zero  indicates success
							// A number -2 indicates that command is successful but number of rows updated is unknow
							// If it won't satisfy any of the above cancel the statement and throw an exception
						if(result[i]<0  && result[i] != -2 ){
							pstmt_update_ph_patient_drug_profile.cancel();
							connection.rollback();
							throw new EJBException("Update PH_PATIENT_DRUG_PROFILE failed");
						}		
					}
				}
				if(pstmt_update_disp_dtl_tmp != null){ // Added for Bru-HIMS-CRF-082 [IN:029948]
					int result[] = pstmt_update_disp_dtl_tmp.executeBatch();
					for (int i=0;i<result.length ;i++ ){
						if(result[i]<0  && result[i] != -2 ){
							pstmt_update_disp_dtl_tmp.cancel();
							connection.rollback();
							throw new EJBException("Update PH_DISP_DTL_TMP failed");
						}		
					}
				}
			}

			st_doc_type					=   getStockDocType(connection,sqlMap,"I",(String)tabData.get("facility_id"));
			HashMap seq_no				=	new HashMap();
			ArrayList alDispTmp			=	new ArrayList();
			ArrayList alOrdTmp			=	new ArrayList();
			HashMap prev_doc_no		=	new HashMap();
			HashMap stock_srl		=	new HashMap();
			HashMap stock_vals		=	new HashMap();
			String strPatId	=null;
			Enumeration enPatient		=   pa_ord_sel_ht.keys();
			ArrayList alOrderLineNos = null;
			while (enPatient.hasMoreElements()){
				strPatId			=   (String) enPatient.nextElement();					
				alOrdTmp				=   (ArrayList) pa_ord_sel_ht.get(strPatId);
				alDispTmp				=   (ArrayList) mpDispTmp.get(strPatId);
				prev_doc_no		=	new HashMap();
				stock_srl		=	new HashMap();
				stock_vals		=	new HashMap();
				stock_vals				=   getDocValuesForFillDelivery(connection,sqlMap,strPatId,alDispTmp,alOrdTmp,hmOrderLineNumbers,tabData); // new parameter , HashMap hmOrderLineNumbers added for [IN:035186] & [IN:035236]

				seq_no = (HashMap) stock_vals.get("srl_no");
				tabData.put("seq_no", seq_no);
				tabData.put("patient_id", strPatId);

				if(stock_vals.size() > 1 ){
					prev_doc_no			= (HashMap)stock_vals.get("doc_no");
					stock_srl			= (HashMap)stock_vals.get("srl_no");
				}			
				cstmt					= connection.prepareCall("{call Ph_deliverorders(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				int PatOrdArSize = 0;
				PatOrdArSize	 = alOrdTmp.size();
				for(int i=0;i<PatOrdArSize;i++){
					alOrderLineNos = (ArrayList)hmOrderLineNumbers.get(((String)alOrdTmp.get(i)).trim());
					for(int p=0;p<alOrderLineNos.size();p++){
						int count =1;
						cstmt.setString( count,  ((String)alOrdTmp.get(i)).trim());		// ORDER_ID
						cstmt.setString( ++count, (String) alOrderLineNos.get(p));		// ORDER_LINE_NUM
						cstmt.setString( ++count, login_by_id.trim());					// ADDED_BY_ID
						cstmt.setString( ++count, login_at_ws_no.trim());				// ADDED_AT_WS_NO
						cstmt.setString( ++count, facility_id.trim());					// ADDED_FACILITY_ID
						cstmt.setString( ++count, login_by_id.trim());					// DELIVERED_BY
						cstmt.setString( ++count, dateTime.trim());						// DELIVERED_DATE_TIME
						cstmt.setString( ++count, "");									// COLLECTED_BY
						cstmt.setString( ++count, "");									// RECEIVED_BY
						cstmt.setString( ++count, "");									// Delivery remarks code
						cstmt.setString( ++count, "");									// Delivery remarks
						cstmt.setString( ++count, "P");
						cstmt.setString( ++count, "");
						cstmt.setString( ++count, "N");	
						cstmt.setString( ++count, "N");									//new_order_yn
						cstmt.setString( ++count, (String)tabData.get("encounter_id"));
						cstmt.execute();
					}
				}
				if(tabData.containsKey("CONSUMABLES_DET_ALL")){
					if(((HashMap)tabData.get("CONSUMABLES_DET_ALL")).containsKey(strPatId)){
						tabData.put("CONSUMABLES_DET",((HashMap)tabData.get("CONSUMABLES_DET_ALL")).get(strPatId));
					}
					else{
						tabData.remove("CONSUMABLES_DET");
					}
				}
				callStockUpdate(connection,tabData,sqlMap,alDispTmp,prev_doc_no,st_doc_type,stock_srl);
				//code added for medical item
				if(trn_rx_ids_patientwise.size()>0&&trn_rx_ids_patientwise.containsKey(strPatId)){
					UpdateConsumableDetails(connection,(ArrayList)trn_rx_ids_patientwise.get(strPatId));
				}
				closeStatement( cstmt ); //3/21/2021
			}
			connection.commit();	
			map.put( "result", new Boolean( true) ) ;
			map.put("msgid","RECORD_MODIFIED");
		}		
		catch(Exception e){
			e.printStackTrace();
			connection.rollback();
			map.put( "result", new Boolean( false) ) ;
			map.put("msgid",e.toString());
			map.put("flag",e.toString());
			System.err.println("Error: During FillDelivery(completeFillDelivery) tabData="+tabData+" ======map="+map);
			return map;
			//throw new EJBException("Error: During Delivery");
		}
		finally{
			try{
				closeResultSet( resultSet );
				closeResultSet( resultSet1 );
				closeStatement( cstmt );
				closeStatement (pstmt_update_order_line_ph);
				closeStatement (pstmt_select_order_line_ph);
				closeStatement (pstmt_select_order_line_ph1);
				closeStatement (pstmt_select_order_line_ph2);
				closeStatement (pstmt_update_ph_patient_drug_profile);
				closeStatement (pstmt_select);
				closeStatement (pstmt_select1);
				closeStatement(pstmt_update_disp_dtl_tmp);//The PreparedStatement object "pstmt_update_disp_dtl_tmp" is not closed.--checkstyle
				closeConnection( connection,prop );
			}
			catch(Exception es){
				es.printStackTrace();
				connection.rollback();
			}
		}
		return map;
	}

	public HashMap completeDelivery(HashMap tabData,HashMap sqlMap ) throws Exception{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;

		Connection connection								= null;

		ArrayList delivery_details							= new ArrayList();
		ArrayList holding_details							= new ArrayList();
		CallableStatement cstmt								= null;
		PreparedStatement pstmt_update_order_line			= null;
		PreparedStatement pstmt_select_order_line_ph		= null;
		PreparedStatement pstmt_update_order_line_ph		= null;
		PreparedStatement pstmt_update_patient_drug_profile = null;
		PreparedStatement pstmt_update_disp_hdr				= null;
		PreparedStatement pstmt_select_disp_tmp				= null;
		PreparedStatement pstmt_update_disp_dtl				= null;
		PreparedStatement pstmt_or_order_line_select1		= null;
        PreparedStatement pstmt_update_order_line_ph_2		= null;
		PreparedStatement pstmt_or_order_select_1			= null;
		//PreparedStatement pstmt_update_order_line_ph_disp_prd =  null;
		//PreparedStatement pstmt_select_order_line_ph_disp_prd =  null; //Commented b'z unused
		PreparedStatement pstmtUpdateDispDtlTmp				= null;
		ResultSet resultSet1								= null;
		ResultSet resultSet2								= null;
		ResultSet resultSet3								= null;
		PreparedStatement pstmt_print_seq_no	= null;
		String print_seq_no="";
		
		prop							= (Properties)tabData.get( "properties" );	
		String login_by_id				= (String)tabData.get("login_by_id");
		String login_at_ws_no			= (String)tabData.get("login_at_ws_no");
		String facility_id				= (String)tabData.get("facility_id");
		String dateTime					= (String)tabData.get("dateTime");
		String patient_id				= (String)tabData.get("patient_id");
		ArrayList dispTMP				= (ArrayList)tabData.get("dispTMP");
		ArrayList orderLineData			= (ArrayList)tabData.get("orderLineData");
		ArrayList orderLineData1		= (ArrayList)tabData.get("orderLineData1");
		String patient_class			= (String)tabData.get("patient_class");
		HashMap editLabel				= tabData.get("editLabel")!=null?(HashMap)tabData.get("editLabel"):null;
		HashMap editableLabel			= tabData.get("editableLabel")!=null?(HashMap)tabData.get("editableLabel"):null; // Added for Bru-HIMS-CRF-414 [IN:045554]
		String allow_edit_disp_label	= tabData.get("allow_edit_disp_label")!=null?(String)tabData.get("allow_edit_disp_label"):""; // Added for Bru-HIMS-CRF-414 [IN:045554]
		String encounter_id				= "";// SKR-SCF-1239
		String curr_locn				= "";// SKR-SCF-1239
		String locn_code				= (String)tabData.get("source_code")==null?"":(String)tabData.get("source_code");
		String IV_PREP_YN				=(String)tabData.get("IV_PREP_YN");//moved from down to up for SKR-SCF-1239
		String LanguageId								= (String)tabData.get("LanguageId"); // SKR-SCF-1239
		String settlement_id = "";//MOHE-CRF-0026.1 START
		ArrayList arrInterfaceDet = new ArrayList(); 
		String authStatusCompleted_yn = ""; 
		String ivPrep_yn = ""; 
		String  postAuthStatusData				= "";
		String iqviaIntegrationFlag= ""; 
		authStatusCompleted_yn = (String)tabData.get("authStatusCompleted_yn"); 
		iqviaIntegrationFlag = (String)tabData.get("iqviaIntegrationFlag"); 
		settlement_id= (String)tabData.get("settlement_id");
		ivPrep_yn = (String)tabData.get("IV_PREP_YN"); 
		postAuthStatusData = (String)tabData.get("postAuthStatusData"); //MOHE-CRF-0026.1 END 
		/*System.out.println("settlement_id: "+settlement_id);  
		System.out.println("patient_class: "+patient_class);
		System.out.println("postAuthStatusData: "+postAuthStatusData); 
		System.out.println("iqviaIntegrationFlag: "+iqviaIntegrationFlag); */ 
		
		if(patient_class.equals("XT")) {
			tabData.put("encounter_id","11111");
		}
		encounter_id = (String)tabData.get("encounter_id");//Added for TH-KW-CRF-21.9

		String token_yn					= (String)tabData.get("token_yn");	
		String disp_locn_code			= (String)tabData.get("disp_locn_code");		
		HashMap deliveryRemarks			= (HashMap)tabData.get("deliveryRemarks");
		ArrayList<String> arrMedPlanSeqNo	= (ArrayList)tabData.get("arrMedPlanSeqNo");// Added for  Bru-HIMS-CRF-072.1[IN 049144]
		String isMedValuesChanged			= (String)tabData.get("isMedValuesChanged");// Added for  Bru-HIMS-CRF-072.1[IN 049144]
		final String SQL_PH_DISP_MEDICATION_ORDER_LINE_UPDATE			= (String)sqlMap.get("SQL_PH_DISP_MEDICATION_ORDER_LINE_UPDATE");
		final String SQL_PH_DISP_MEDICATION_ORDER_LINE_PH_UPDATE		= (String)sqlMap.get("SQL_PH_DISP_MEDICATION_ORDER_LINE_PH_UPDATE");
		final String SQL_PH_DISP_MEDICATION_PATIENT_DRUG_PROFILE_UPDATE	= (String)sqlMap.get("SQL_PH_DISP_MEDICATION_PATIENT_DRUG_PROFILE_UPDATE");
		final String SQL_PH_DISP_MEDICATION_SELECT108			= (String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT108");	
		final String SQL_PH_DISP_MEDICATION_SELECT111			= (String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT111");	
		//final String SQL_PH_DISP_MEDICATION_OR_ORDER_LINE_SELECT1 = (String)sqlMap.get("SQL_PH_DISP_MEDICATION_OR_ORDER_LINE_SELECT1");
		final String SQL_PH_DISP_DTL_TMP_UPDATE = (String)sqlMap.get("SQL_PH_DISP_DTL_TMP_UPDATE");
		final String SQL_PH_DISP_DTL_TMP_UPDATE_ALT_REMARKS = (String)sqlMap.get("SQL_PH_DISP_DTL_TMP_UPDATE_ALT_REMARKS");
		final String SQL_PH_IP_FILL_PROCESS_UPDATE_DRUG_PROFILE = (String)sqlMap.get("SQL_PH_IP_FILL_PROCESS_UPDATE_DRUG_PROFILE");
	
		delivery_details				=  (ArrayList)tabData.get( "delivery_details" );	
		holding_details					=  (ArrayList)tabData.get( "holding_details" );
		IR_FLAG							=   new HashMap();
		HashMap complte_order_reasons	=  (HashMap)tabData.get("complte_order_reason");			
		String collected_by				=	"";
		String dispensed_by				=	"";
		String date_time				=	"";
		String st_doc_type				=	"";
		String received_at				=	"";
		String cntr_chkd_by				=	"";
		String recived_by				=	"";
		ResultSet	resultSet			=	null;
		//int rec_count                   =	0;
		HashMap	stock_srl				=	new HashMap();
		HashMap prev_doc_no				=	new HashMap();
//		String IV_PREP_YN=(String)tabData.get("IV_PREP_YN");//commented and moved to up 
		hmBLDocSrlNo = new HashMap(); //Added for  [IN:043100]
		if(delivery_details.size()>0 && token_yn.equals("Y")){
			collected_by		 = (String)delivery_details.get(0);
			//gender				 = (String)delivery_details.get(1);
			//nationality			 = (String)delivery_details.get(2);
			dispensed_by		 = (String)delivery_details.get(3);
			date_time			 = (String)delivery_details.get(4);
			//token_series_code	 = (String)delivery_details.get(5);
			//token_no			 = (String)delivery_details.get(6);
			received_at			 = (String)delivery_details.get(6);
			cntr_chkd_by		 = (String)delivery_details.get(7);	
		} 
		else if(delivery_details.size()>0){
			collected_by		= (String)delivery_details.get(0);
			dispensed_by		= (String)delivery_details.get(3);
			date_time			= (String)delivery_details.get(4);
			received_at			= (String)delivery_details.get(5);
			cntr_chkd_by		= (String)delivery_details.get(6);
		} 

		try{
			connection = getConnection(prop) ;	

			pstmt_print_seq_no = connection.prepareStatement("SELECT OFFLINE_PRINT_SEQ.NEXTVAL PRINT_SEQ_NO FROM DUAL");
            resultSet1 = pstmt_print_seq_no.executeQuery() ;
            while ( resultSet1.next() ) {
				print_seq_no = resultSet1.getString("PRINT_SEQ_NO");
			}
			closeStatement(pstmt_print_seq_no);
			closeResultSet( resultSet1 ) ;

			// pstmt_or_order_select_1 =connection.prepareStatement("select count(*) count from or_order where order_id=? AND TO_CHAR(MODIFIED_DATE,'DDMMYYYYHH24MISS') = ?");
			pstmt_or_order_select_1 =connection.prepareStatement("select TO_CHAR(MODIFIED_DATE,'DDMMYYYYHH24MISS')MODIFIED_DATE_TIME from or_order where order_id=? ");

			if(patient_class.equals("I")) {
				pstmt_update_order_line_ph	=	connection.prepareStatement( SQL_PH_DISP_MEDICATION_ORDER_LINE_PH_UPDATE ) ;
				pstmt_or_order_line_select1 =	connection.prepareStatement( SQL_PH_DISP_MEDICATION_SELECT108 ) ;
				pstmt_select_order_line_ph	=	connection.prepareStatement( SQL_PH_DISP_MEDICATION_SELECT111 ) ;
				//pstmt_update_order_line_ph_2=   connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_LINE_PH_UPDATE2") ) ;//Code commented for ML-BRU-SCF-0971[IN042220] --Start
				pstmt_update_order_line_ph_2=   connection.prepareStatement( "UPDATE OR_ORDER_LINE_PH SET complete_order_reason = ? , MODIFIED_DATE=SYSDATE, DELIVERY_REMARKS_CODE=?, DELIVERY_TASK_FINDING=? WHERE ORDER_ID=? AND ORDER_LINE_NUM=?" ) ;//Code added for ML-BRU-SCF-0971[IN042220] 				
				//pstmt_select_order_line_ph_disp_prd=   connection.prepareStatement( "SELECT IP_FILL_PROCESS, IP_FILL_PRD_AHEAD FROM OR_ORDER_LINE_PH WHERE ORDER_ID=? AND  ORDER_LINE_NUM=? " ) ; //Commented b'z unused
			
				String next_date				=	"";
				String ord_id					=	"";
				String order_line				=	"";
				String pres_mode				=	"";
				String complete_order_reason	=	"";
				String finding_code	="", finding_remarks ="" ,keys="";//Code added for ML-BRU-SCF-0971[IN042220]
				ArrayList find_result = null;//Code added for ML-BRU-SCF-0971[IN042220] 
				for(int i=0;i<orderLineData.size();i=i+6){	 //Modified for RUT-CRF-0088 [IN036978] 7->6
					if(!((String)orderLineData.get(i)).equals("NN") ) { // Not Hold & Not Allocated
						//period		=	"";
						ord_id			= ((String)orderLineData.get(i+3)).trim();
						order_line		= ((String)orderLineData.get(i+4)).trim();
						/*if(order_qty.containsKey(ord_id+order_line)) {		

						  String ord_qty	= (String)order_qty.get(ord_id+order_line);
						  String duration	= (String)durn_val.get(ord_id+order_line);
						  //period		= new Float(Math.ceil(Integer.parseInt(ord_qty)/Integer.parseInt(duration))).intValue() + "";
						}*/

						//pstmt_select_order_line_ph	=	connection.prepareStatement( SQL_PH_DISP_MEDICATION_SELECT111 ) ;
						pstmt_select_order_line_ph.setString(1,ord_id);
						pstmt_select_order_line_ph.setString(2,order_line);
						resultSet	=	pstmt_select_order_line_ph.executeQuery();

						if(resultSet.next()) {
							pres_mode		=	resultSet.getString("PRESCRIBED_MODE")==null?"A":resultSet.getString("PRESCRIBED_MODE");
							next_date		=	resultSet.getString("NEXT_FILL_DATE");
						}
					closeResultSet(	resultSet);	//common-icn-0029
						if(!pres_mode.equals("A")) {
							//pstmt_select_order_line_ph	=	null;
							//pstmt_select_order_line_ph	=	connection.prepareStatement( SQL_PH_DISP_MEDICATION_SELECT108 ) ;
							resultSet		=	null;
							pstmt_or_order_line_select1.setString(1,disp_locn_code);
							pstmt_or_order_line_select1.setString(2,facility_id);
							resultSet	=	pstmt_or_order_line_select1.executeQuery();
							if(resultSet.next()) {
								next_date	=	resultSet.getString("NEXT_DATE");
							}
						closeResultSet(	resultSet);	//3/21/2021
						}	
						if(next_date!=null && (!next_date.equals(""))){
							/*pstmt_update_order_line_ph.setString(1,next_date);	
							pstmt_update_order_line_ph.setString(2,dateTime);	
							pstmt_update_order_line_ph.setString(3,login_by_id);		// modified id
							pstmt_update_order_line_ph.setString(4,facility_id);		// modified facility
							pstmt_update_order_line_ph.setString(5,login_at_ws_no);		// modified work station
							pstmt_update_order_line_ph.setString(6,((String)orderLineData.get(i+3)).trim());
							pstmt_update_order_line_ph.setString(7,((String)orderLineData.get(i+4)).trim());
							pstmt_update_order_line_ph.addBatch();*/
							
							/*if(dispTMP!=null && dispTMP.size() > 0 ){
								//pstmt_update_order_line_ph_disp_prd = connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_OR_ORDER_LINE_PH_UPDATE3") ) ;	
							   pstmt_select_order_line_ph_disp_prd.setString(1,ord_id);
							   pstmt_select_order_line_ph_disp_prd.setString(2,order_line);
							   resultSet3 = pstmt_select_order_line_ph_disp_prd.executeQuery();

							   if(resultSet3 != null && resultSet3.next()){
									pstmt_update_order_line_ph_disp_prd = connection.prepareStatement("UPDATE OR_ORDER_LINE_PH SET IP_FILL_PROCESS = ?, IP_FILL_PRD_AHEAD = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?,MODIFIED_FACILITY_ID = ? WHERE ORDER_ID = ? AND ORDER_LINE_NUM = ?");	
									for(int m=0;m<dispTMP.size();m=m+7){
										if(ord_id.equals((String)dispTMP.get(m))){
											pstmt_update_order_line_ph_disp_prd.setString(1,(String)resultSet3.getString("IP_FILL_PROCESS"));	
											pstmt_update_order_line_ph_disp_prd.setString(2,(String)resultSet3.getString("IP_FILL_PRD_AHEAD"));	
											pstmt_update_order_line_ph_disp_prd.setString(3,((String)tabData.get("login_by_id")).trim());
											pstmt_update_order_line_ph_disp_prd.setString(4,((String)tabData.get("login_at_ws_no")).trim());	
											pstmt_update_order_line_ph_disp_prd.setString(5,((String)tabData.get("facility_id")).trim());	
											pstmt_update_order_line_ph_disp_prd.setString(6,((String)dispTMP.get(m)).trim());
											pstmt_update_order_line_ph_disp_prd.setString(7,((String)dispTMP.get(m+1)).trim());

											pstmt_update_order_line_ph_disp_prd.addBatch();	
										}
									}
									int result[] = pstmt_update_order_line_ph_disp_prd.executeBatch();
									for (int m=0;m<result.length ;m++ ){		// A number greater than or equal to zero  indicates success
											// A number -2 indicates that command is successful but number of rows updated is unknow
											// If it won't satisfy any of the above cancel the statement and throw an exception
										if(result[m]<0  && result[m] != -2 ){												
											pstmt_update_order_line_ph_disp_prd.cancel();
											connection.rollback();
											throw new EJBException("OR_ORDER_LINE_PH FAILED While Updating dispense period");
										}		
									}
								}
							}*/
						} 
						else {
							pstmt_update_order_line_ph.setString(1,next_date);	
							pstmt_update_order_line_ph.setString(2,dateTime);	
							pstmt_update_order_line_ph.setString(3,login_by_id);		// modified id
							pstmt_update_order_line_ph.setString(4,facility_id);		// modified facility
							pstmt_update_order_line_ph.setString(5,login_at_ws_no);		// modified work station
							pstmt_update_order_line_ph.setString(6,((String)orderLineData.get(i+3)).trim());
							pstmt_update_order_line_ph.setString(7,((String)orderLineData.get(i+4)).trim());
							pstmt_update_order_line_ph.addBatch();
						}
					}
					
				//	if(complte_order_reasons.size()>0){ //Code commented for ML-BRU-SCF-0971[IN042220]
						String key = ((String)orderLineData.get(i+3)).trim()+((String)orderLineData.get(i+4)).trim();
						if( complte_order_reasons.containsKey(key)){
							complete_order_reason   =  (String) complte_order_reasons.get(key);
						}
						else{
							complete_order_reason   =  "";
						}
						keys = 	((String)orderLineData.get(i+3)).trim()+"_"+((String)orderLineData.get(i+4)).trim();//Code added for ML-BRU-SCF-0971[IN042220] --Start						
						if(deliveryRemarks!=null && deliveryRemarks.containsKey(keys)) {
							find_result	= (ArrayList)deliveryRemarks.get(keys);
							finding_code	= (String)find_result.get(1);
							finding_remarks	= (String)find_result.get(2);
						}//Code added for ML-BRU-SCF-0971[IN042220] --End
						
            else{//added for ML-MMOH-SCF-1008
							finding_code	=""; finding_remarks ="";
						}
						pstmt_update_order_line_ph_2.setString(1,complete_order_reason);	
						pstmt_update_order_line_ph_2.setString(2,finding_code);	//Code added for ML-BRU-SCF-0971[IN042220] 
						pstmt_update_order_line_ph_2.setString(3,finding_remarks);	//Code added for ML-BRU-SCF-0971[IN042220]
						pstmt_update_order_line_ph_2.setString(4,((String)orderLineData.get(i+3)).trim());	
						pstmt_update_order_line_ph_2.setString(5,((String)orderLineData.get(i+4)).trim());	
						pstmt_update_order_line_ph_2.addBatch();

						if(pstmt_update_order_line_ph_2 != null){
							int result2[] = pstmt_update_order_line_ph_2.executeBatch();
							for (int m=0;m<result2.length ;m++ ){		
								if(result2[m]<0  && result2[m] != -2 ){
									pstmt_update_order_line_ph_2.cancel();
									connection.rollback();
									throw new EJBException("Update completeorder reason  :OR_ORDER_LINE_PH failed");
								}		
							}
						}
					//}//Code added for ML-BRU-SCF-0971[IN042220]
				} //orderLineData for loop -end

				if(pstmt_select_order_line_ph!=null){
					closeStatement(	pstmt_select_order_line_ph	);	
					pstmt_select_order_line_ph=null;
				}
				if(pstmt_update_order_line_ph_2!=null){
					closeStatement(	pstmt_update_order_line_ph_2	);	
				}
				if(pstmt_or_order_line_select1!=null){
					closeStatement(	pstmt_or_order_line_select1	);
					pstmt_or_order_line_select1=null;
				}
				if(resultSet!=null){
					closeResultSet(	resultSet);	
					resultSet=null;
				}
			
				if(pstmt_update_order_line_ph != null){
					int result[]=pstmt_update_order_line_ph.executeBatch();
					
					for (int i=0;i<result.length ;i++ ){
						// A number greater than or equal to zero  indicates success
						// A number -2 indicates that command is successful but number of rows updated is unknow
						// If it won't satisfy any of the above cancel the statement and throw an exception
						if(result[i]<0  && result[i] != -2 ){
							pstmt_update_order_line_ph.cancel();
							connection.rollback();
							throw new EJBException("Update OR_ORDER_LINE_PH failed");
						}		
					}
				}// Order line PH update over
			}
			else{
				updateOrOrderLinePh(connection,sqlMap,tabData,orderLineData,orderLineData1,complte_order_reasons);
			}

			pstmt_update_order_line				= connection.prepareStatement( SQL_PH_DISP_MEDICATION_ORDER_LINE_UPDATE ) ;
			pstmt_update_patient_drug_profile	= connection.prepareStatement( SQL_PH_DISP_MEDICATION_PATIENT_DRUG_PROFILE_UPDATE ) ;
			int count=1;
			String alt_drug_remarks="",key;
			HashMap hmAltDrugRemarks	=  (HashMap)tabData.get("ALTDRUGREMARKS");
			for(int i=0;i<holding_details.size();i++){// Update the table or_order_line
				key = ((String)holding_details.get(i+3)).trim()+"~"+((String)holding_details.get(i+4)).trim();
				if(hmAltDrugRemarks !=null && hmAltDrugRemarks.containsKey(key))
					alt_drug_remarks = (String)hmAltDrugRemarks.get(key);
				else
					alt_drug_remarks="";
				count=1;
				pstmt_update_order_line.setString(count,"HD");											//ORDER_LINE_STATUS
				pstmt_update_order_line.setString(++count,(String)holding_details.get(i));				//HOLD_PRACT_ID
				pstmt_update_order_line.setString(++count,dateTime.trim());								//HOLD_DATE_TIME
				pstmt_update_order_line.setString(++count,((String)holding_details.get(i+1)).trim());		//LAST_ACTION_TYPE
				pstmt_update_order_line.setString(++count,((String)holding_details.get(i+2)).trim());		//LAST_ACTION_REASON_DESC
				pstmt_update_order_line.setString(++count,((String)holding_details.get(i+2)).trim());//CAN_LINE_REASON added newly for the ML-BRU-SCF-0184 by SureshKumar T on 07/06/2012
				pstmt_update_order_line.setString(++count,login_by_id);		// modified id
				pstmt_update_order_line.setString(++count,facility_id);		// modified facility
				pstmt_update_order_line.setString(++count,login_at_ws_no);		// modified work station
				pstmt_update_order_line.setString(++count,((String)holding_details.get(i+3)).trim());		//ORDER_ID
				pstmt_update_order_line.setString(++count,((String)holding_details.get(i+4)).trim());		//ORDER_LINE_NUM
				pstmt_update_order_line.addBatch();

				// Update the ph_patient_drug_profile
				count=1;
				pstmt_update_patient_drug_profile.setString(count,dateTime.trim());								// ON_HOLD_DATE_TIME
				pstmt_update_patient_drug_profile.setString(++count,login_by_id.trim());							// ON_HOLD_BY_ID
				pstmt_update_patient_drug_profile.setString(++count,((String)holding_details.get(i+1)).trim());	// ON_HOLD_REASON_CODE
				pstmt_update_patient_drug_profile.setString(++count,login_by_id);		// modified id
				pstmt_update_patient_drug_profile.setString(++count,facility_id);		// modified facility
				pstmt_update_patient_drug_profile.setString(++count,login_at_ws_no);		// modified work station
				pstmt_update_patient_drug_profile.setString(++count,alt_drug_remarks);		// alt_drug_remarks 
				pstmt_update_patient_drug_profile.setString(++count,patient_id.trim());							// PATIENT_ID
				pstmt_update_patient_drug_profile.setString(++count,((String)holding_details.get(i+3)).trim());	// ORIG_ORDER_ID
				pstmt_update_patient_drug_profile.setString(++count,((String)holding_details.get(i+4)).trim());	// ORIG_ORDER_LINE_NO
				pstmt_update_patient_drug_profile.setString(++count,facility_id.trim());							// FACILITY_ID
				pstmt_update_patient_drug_profile.addBatch();
			}	
			if(pstmt_update_order_line != null){
				int result1[]=pstmt_update_order_line.executeBatch();

				for (int i=0;i<result1.length ;i++ ){
					// A number greater than or equal to zero  indicates success
					// A number -2 indicates that command is successful but number of rows updated is unknow
					// If it won't satisfy any of the above cancel the statement and throw an exception
					if(result1[i]<0  && result1[i] != -2 ){
						pstmt_update_order_line.cancel();
						connection.rollback();
						throw new EJBException("Update OR_ORDER_LINE failed"); //Delete Failed
					}		
				}
			}
			if(pstmt_update_patient_drug_profile != null){
				int[] result2=pstmt_update_patient_drug_profile.executeBatch();
				for (int i=0;i<result2.length ;i++ ){
					if(result2[i]<0  && result2[i] != -2 ){
						pstmt_update_patient_drug_profile.cancel();
						connection.rollback();
						throw new EJBException("Update patient drug profile Failed");
					}		
				}	
			}

			String order_id1=(String)orderLineData.get(3);
/*
			pstmt_or_order_line_select1	= connection.prepareStatement( SQL_PH_DISP_MEDICATION_OR_ORDER_LINE_SELECT1 ) ;
			pstmt_or_order_line_select1.setString(1,order_id1);
			resultSet1=pstmt_or_order_line_select1.executeQuery();
			if(resultSet1.next()){
			IV_PREP_YN=resultSet1.getString(1);
			}
			if(IV_PREP_YN==null) IV_PREP_YN="";
*/
			if(IV_PREP_YN!=null && (IV_PREP_YN.equals("4") || IV_PREP_YN.equals("0")|| IV_PREP_YN.equals("2")|| IV_PREP_YN.equals("6"))){
				callUpdatePhMednAdmin(connection,sqlMap,tabData,orderLineData,patient_id,order_id1,IV_PREP_YN);
			}
			
			// Get the Stock Doc Type 
			st_doc_type	=	getStockDocType(connection,sqlMap,patient_class,facility_id);
			// Get the previous docno and doctype
			HashMap stock_vals		=	getDocValues(connection,sqlMap,orderLineData,dispTMP,tabData);
			if(stock_vals.size() > 1 ) {
				prev_doc_no		= (HashMap)stock_vals.get("doc_no");
				//prev_doc_type	= (HashMap)stock_vals.get("doc_type");
				stock_srl		= (HashMap)stock_vals.get("srl_no");
			}
			tabData.put("disp_stage","D");
			HashMap order_id_order_date = (HashMap)tabData.get("ORDER_ID_ORDER_DATE");
			String modified_date_time   =  "";

			 for(int i=0;i<orderLineData.size();i=i+6){ //Modified for RUT-CRF-0088 [IN036978] 7->6
				pstmt_or_order_select_1.setString(1,((String)orderLineData.get(i+3)).trim());
				resultSet2=pstmt_or_order_select_1.executeQuery();

				if(resultSet2.next()){
				   modified_date_time=resultSet2.getString("MODIFIED_DATE_TIME");
				   if(!modified_date_time.equals((String)order_id_order_date.get(((String)orderLineData.get(i+3)).trim()))){                 
						connection.rollback();
						closeStatement( pstmt_or_order_select_1 ) ;
						closeResultSet( resultSet2 ) ;
						throw new EJBException("APP-PH0902 Record Already In Use - It is used by Other User.Please Try again...");//ORDER_PROC_BY_OTHER_USER
					}
				}  
			}
			closeResultSet( resultSet2 ) ;
			//	Stock Insertion starts
			//callStockUpdate(connection,tabData,sqlMap,dispTMP,prev_doc_no,st_doc_type,stock_srl);
			if(collected_by.length()>99)
				collected_by = collected_by.substring(0,99);

			if(collected_by.length()>29)
				recived_by = collected_by.substring(0,29);

			ArrayList edit_result	= null;
			String sKey = "", sKey1;
			if(editLabel!=null && editLabel.size()>0){
				pstmtUpdateDispDtlTmp		= connection.prepareStatement(SQL_PH_DISP_DTL_TMP_UPDATE);
				int iCount = 0;
				
				//for(int i=0;i<orderLineData.size();i=i+7){ //Commented for [IN:039525]
					//sKey = ((String)orderLineData.get(i+3)).trim()+"_"+((String)orderLineData.get(i+4)).trim();//Commented for [IN:039525]
				for(int i=0;i<dispTMP.size();i=i+7){ //Added for [IN:039525]
					sKey1 =	((String)dispTMP.get(i)).trim()+"_"+((String)dispTMP.get(i+3)).trim()+"_"+((String)dispTMP.get(i+1)).trim(); //Added for [IN:039525]
					iCount	=	0;
					if(editLabel!=null && editLabel.containsKey(sKey1)){
						edit_result =(ArrayList)editLabel.get(sKey1);
						if(edit_result!=null && edit_result.size()!=0){
							pstmtUpdateDispDtlTmp.setString(++iCount,(String)edit_result.get(0));
							pstmtUpdateDispDtlTmp.setString(++iCount,(String)edit_result.get(1));
							pstmtUpdateDispDtlTmp.setString(++iCount,(String)edit_result.get(2));
							pstmtUpdateDispDtlTmp.setString(++iCount,(String)edit_result.get(3));
							pstmtUpdateDispDtlTmp.setString(++iCount,(String)edit_result.get(4));
							pstmtUpdateDispDtlTmp.setString(++iCount,(String)edit_result.get(5));
							pstmtUpdateDispDtlTmp.setString(++iCount,(String)edit_result.get(6));
							pstmtUpdateDispDtlTmp.setString(++iCount,(String)edit_result.get(7));
							pstmtUpdateDispDtlTmp.setString(++iCount,(String)edit_result.get(8));
							pstmtUpdateDispDtlTmp.setString(++iCount,(String)edit_result.get(9));
							pstmtUpdateDispDtlTmp.setString(++iCount,(String)edit_result.get(10));
							pstmtUpdateDispDtlTmp.setString(++iCount,(String)edit_result.get(11));//Added for ML-BRU-CRF-072[Inc:29938]
							pstmtUpdateDispDtlTmp.setString(++iCount,(String)tabData.get("facility_id"));
							pstmtUpdateDispDtlTmp.setString(++iCount, ((String)dispTMP.get(i)).trim()); //(String)orderLineData.get(i+3));
							pstmtUpdateDispDtlTmp.setString(++iCount,((String)dispTMP.get(i+1)).trim());//orderLineData.get(i+4).toString().trim());
							pstmtUpdateDispDtlTmp.setString(++iCount,(String)edit_result.get(12));
							pstmtUpdateDispDtlTmp.addBatch();
						}
					}
				}
				if(pstmtUpdateDispDtlTmp != null){
					int result[] = pstmtUpdateDispDtlTmp.executeBatch();

					for (int i=0;i<result.length ;i++ ){
							// A number greater than or equal to zero  indicates success
							// A number -2 indicates that command is successful but number of rows updated is unknow
							// If it won't satisfy any of the above cancel the statement and throw an exception
						if(result[i]<0  && result[i] != -2 ){
							pstmtUpdateDispDtlTmp.cancel();
							closeStatement(pstmtUpdateDispDtlTmp);
							connection.rollback();
							throw new EJBException("Update PH_DISP_DTL_TMP (Edit label values) failed... ");
						}		
					}
				}
			closeStatement(pstmtUpdateDispDtlTmp);//common-icn-0029
			}
			if(allow_edit_disp_label.equals("Y") && editableLabel!=null && editableLabel.size()>0 && dispTMP!=null && dispTMP.size()>0){ //if block Added for Bru-HIMS-CRF-414 [IN:045554]
				insertUpdateDispLabelDtl(connection, sqlMap,tabData, dispTMP);
			}
			String mediplan_seq_no ="";ArrayList<String> arrTempMedseqno = new ArrayList<String>();//Added for Bru-HIMS-CRF-072.1[IN 049144]
			if(!patient_class.equals("I") && ((String)tabData.get("strMedPlanYN")).equals("Y")){// AniT code Added for  Bru-HIMS-CRF-072.1[IN 049144] start
				if(isMedValuesChanged.equals("true")){
					if(arrMedPlanSeqNo.size()==0)
						mediplan_seq_no = insertMedicationPlan(connection, sqlMap,tabData,stock_srl);
					else if(arrMedPlanSeqNo.size()==1){
						tabData.put("mediplan_seq_no",(String)arrMedPlanSeqNo.get(0));
						mediplan_seq_no = updateMedicationPlan(connection, sqlMap,tabData);
					}
					else{
						mediplan_seq_no = insertMedicationPlan(connection, sqlMap,tabData,stock_srl);
						deleteMedicationPlan(connection,sqlMap,tabData);
					}
				}
				else
					arrTempMedseqno = updateMediPlan_DispStage(connection, sqlMap, tabData);
			}// Added for  Bru-HIMS-CRF-072.1[IN 049144] end
			if(hmAltDrugRemarks!=null && hmAltDrugRemarks.size()>0){
				closeStatement( pstmt_update_patient_drug_profile );
				pstmtUpdateDispDtlTmp	   = connection.prepareStatement(SQL_PH_DISP_DTL_TMP_UPDATE_ALT_REMARKS);;
				pstmt_update_patient_drug_profile	   = connection.prepareStatement(SQL_PH_IP_FILL_PROCESS_UPDATE_DRUG_PROFILE);;
				for(int i=0;i<dispTMP.size();i=i+7){ 
					sKey =	((String)dispTMP.get(i)).trim()+"~"+((String)dispTMP.get(i+1)).trim(); 
					if(hmAltDrugRemarks.containsKey(sKey)){
						alt_drug_remarks = (String)hmAltDrugRemarks.get(sKey);
						if(alt_drug_remarks!=null && !alt_drug_remarks.equals("")){
							pstmtUpdateDispDtlTmp.setString(1,alt_drug_remarks);
							pstmtUpdateDispDtlTmp.setString(2,(String)tabData.get("login_by_id"));			 // MODIFIED_BY_ID
							pstmtUpdateDispDtlTmp.setString(3,(String)tabData.get("login_at_ws_no"));	 // MODIFIED_AT_WS_NO
							pstmtUpdateDispDtlTmp.setString(4,(String)tabData.get("facility_id")); // MODIFIED_FACILITY_ID
							pstmtUpdateDispDtlTmp.setString(5,((String)dispTMP.get(i)).trim());			// order_id
							pstmtUpdateDispDtlTmp.setString(6,((String)dispTMP.get(i+1)).trim());		// order_line_no				
							pstmtUpdateDispDtlTmp.addBatch();

							pstmt_update_patient_drug_profile.setString(1,alt_drug_remarks);
							pstmt_update_patient_drug_profile.setString(2,(String)tabData.get("login_by_id"));			 // MODIFIED_BY_ID
							pstmt_update_patient_drug_profile.setString(3,(String)tabData.get("login_at_ws_no"));	 // MODIFIED_AT_WS_NO
							pstmt_update_patient_drug_profile.setString(4,(String)tabData.get("facility_id")); // MODIFIED_FACILITY_ID
							pstmt_update_patient_drug_profile.setString(5,((String)dispTMP.get(i)).trim());			// order_id
							pstmt_update_patient_drug_profile.setString(6,((String)dispTMP.get(i+1)).trim());		// order_line_no				
							pstmt_update_patient_drug_profile.addBatch();
						}
					}
				}
				if(pstmtUpdateDispDtlTmp != null){
					int result[] = pstmtUpdateDispDtlTmp.executeBatch();
					for (int i=0;i<result.length ;i++ ){
						if(result[i]<0  && result[i] != -2 ){
							pstmtUpdateDispDtlTmp.cancel();
							closeStatement(pstmtUpdateDispDtlTmp);
							connection.rollback();
							throw new EJBException("Update PH_DISP_DTL_TMP (Alternate Drug Remarks) failed... ");
						}		
					}
				}
				if(pstmt_update_patient_drug_profile != null){
					int result[] = pstmt_update_patient_drug_profile.executeBatch();
					for (int i=0;i<result.length ;i++ ){
						if(result[i]<0  && result[i] != -2 ){
							pstmt_update_patient_drug_profile.cancel();
							closeStatement(pstmt_update_patient_drug_profile);
							connection.rollback();
							throw new EJBException("Update PH_PATIENT_DRUG_PROFILE (Alternate Drug Remarks) failed... ");
						}		
					}
				}
			}
//write interface method here MOHE-CRF-0026.1 
			
			if(patient_class.equals("O") && iqviaIntegrationFlag.equals("Y") && settlement_id.equals("X")){  
				System.out.println("set billing interface details");  
				if((ivPrep_yn==null || ivPrep_yn.equals("") || ivPrep_yn.equals("null")) ){  
					if(authStatusCompleted_yn!= null && !authStatusCompleted_yn.equals("") && authStatusCompleted_yn.equals("Y")){
						arrInterfaceDet =  setBillingInterfaceDetails( connection, sqlMap, tabData, postAuthStatusData);  
						tabData.put("arrInterfaceDet", arrInterfaceDet);  
					}
					
				}
			}
			cstmt					=	connection.prepareCall("{call Ph_deliverorders(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");//SCF-207.1
			int cnt						= 0;
			key				= "";
			String delivery_code		= "";
			String delivery_remarks		= "";
			String new_order_id			= "";
			String old_order_id			= "";
			String new_order_yn			= "N";
			boolean comp_order_found	=	false;	
			ArrayList result = null;
			String approval_no = "";
			HashMap approvalNo	=  (HashMap)tabData.get("approvalNo");//AAKH-CRF-0117
			System.err.println("approvalNo====>"+approvalNo);
			for(int i=0;i<orderLineData.size();i=i+6){	//Modified for RUT-CRF-0088 [IN036978] 7->6 
				 if(!((String)orderLineData.get(i)).equals("NN")  || ( ( ((String)orderLineData.get(i+5)).trim()).equals("Y"))) {
					count = 1;
					approval_no = "";
					new_order_id=((String)orderLineData.get(i+3)).trim();

					if(!new_order_id.equals(old_order_id)|| old_order_id.equals("")){
						new_order_yn	=	"Y";
					}

					try{
						cstmt.setString( count,  ((String)orderLineData.get(i+3)).trim());		// ORDER_ID
						cstmt.setString( ++count, ((String)orderLineData.get(i+4)).trim());	   // ORDER_LINE_NUM
						cstmt.setString( ++count, login_by_id.trim());							// ADDED_BY_ID
						cstmt.setString( ++count, login_at_ws_no.trim());						// ADDED_AT_WS_NO
						cstmt.setString( ++count, facility_id.trim());							// ADDED_FACILITY_ID
						cstmt.setString( ++count, dispensed_by.trim());							// DELIVERED_BY
						cstmt.setString( ++count, date_time.trim());							// DELIVERED_DATE_TIME
						cstmt.setString( ++count, collected_by.trim());							// COLLECTED_BY
						cstmt.setString( ++count, recived_by.trim());							// RECEIVED_BY
						key = ((String)orderLineData.get(i+3)).trim()+"_"+((String)orderLineData.get(i+4)).trim();
						delivery_code		= "";
						delivery_remarks	= "";
						if(deliveryRemarks!=null && deliveryRemarks.containsKey(key)) {
							result	= (ArrayList)deliveryRemarks.get(key);
							delivery_code		= (String)result.get(1);
							delivery_remarks	= (String)result.get(2);
						}
			
						cstmt.setString( ++count, delivery_code);	// Delivery remarks code
						cstmt.setString( ++count, delivery_remarks);	// Delivery remarks
						cstmt.setString( ++count, received_at);
						cstmt.setString( ++count, cntr_chkd_by);
						cstmt.setString( ++count, ((String)orderLineData.get(i+5)).trim());	//CompleteOrderYN
						cstmt.setString( ++count, new_order_yn);	//new_order_yn
						cstmt.setString( ++count, print_seq_no);	//new_order_yn
						cstmt.setString( ++count, (String)tabData.get("encounter_id"));
						//added for AAKH-CRF-0117
						if(approvalNo!=null && approvalNo.size()>0)
						approval_no = (String)approvalNo.get(((String)orderLineData.get(i+3)).trim()+((String)orderLineData.get(i+4)).trim());

						if(approval_no==null)
						approval_no = "";

						cstmt.setString( ++count, approval_no);	//added for AAKH-CRF-0117
						if( ( ((String)orderLineData.get(i+5)).trim()).equals("Y")) {
							comp_order_found	=	true;
						}
						cstmt.execute();
					}
					catch(Exception ess){
						 System.err.println("Error at 1311 tabData="+tabData);
						 ess.printStackTrace();
						 connection.rollback();
						 throw new EJBException("Error: Deliver orders Failed");//ORDER_PROC_BY_OTHER_USER
					}
					old_order_id	=	new_order_id;
					new_order_yn	=	"N";
					new_order_id	=   "";
				 }
				cnt++;
			}
			// Update the dispensing queue if token series is applicable - updateDispQueue moved before "callStockUpdate" for Locking issue from SKR(07-Nov-2011) 
			if(token_yn.equals("Y")) {
				updateDispQueue(connection, sqlMap, tabData,orderLineData,"D");
			}
			//Adding start for TH-KW-CRF-0020.9
			boolean display_delivery_bin = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","DISPLAY_DELIVERY_BIN");
			
			if(display_delivery_bin && token_yn.equals("N")){
				updateStorageLocation(connection,patient_id,encounter_id,disp_locn_code);
			}
            //Adding end for TH-KW-CRF-0020.9
			//Stock Insertion starts
			if(dispTMP.size()>0){
				callStockUpdate(connection,tabData,sqlMap,dispTMP,prev_doc_no,st_doc_type,stock_srl);
			}
			// update or_order if complete order status found in line level
			if(comp_order_found) {
				updateOrOrderNew(connection, sqlMap, tabData,orderLineData);
			}
			updateDispensedDetail(connection, sqlMap, tabData,dispTMP,"D");

			if(!patient_class.equals("I")) {
				checkBMS(connection, sqlMap,orderLineData);
			}
			
			//SKR-SCF-1239 - start

				if(patient_class.equals("I") ){ // IV_PREP_YN removed for SKR-SCF-1254
					boolean allow_locn_update = new CommonBean().isSiteSpecific(connection, "PH","PATIENT_TRANSFER_LOCN_UPD");

					if(allow_locn_update){
				  encounter_id = (String)tabData.get("encounter_id")==null?"":(String)tabData.get("encounter_id");
				  curr_locn = getCurrentLocn(connection,patient_id,encounter_id);
				  if(locn_code!=null && !locn_code.equals("") && !locn_code.equals(curr_locn)){
					updateOrOrdersLocn(connection,orderLineData,patient_id,encounter_id,curr_locn,patient_class,facility_id.trim(),LanguageId);
				  }
				  }
			}
			//SKR-SCF-1239 - end
			//IV_PREP_YN="";
			connection.commit();
			//connection.rollback();
			if(!patient_class.equals("I") && ((String)tabData.get("strMedPlanYN")).equals("Y")){//Added for Bru-HIMS-CRF-072.1[IN 051382]
				if(isMedValuesChanged.equals("true") && !mediplan_seq_no.equals(""))
					map.put( "mediplan_seq_no", mediplan_seq_no ) ;
				else 
					map.put( "arr_mediplan_seq_no", arrTempMedseqno ) ;
			}
				
			map.put( "result", new Boolean( true) ) ;
			map.put("msgid","RECORD_MODIFIED");
			map.put("IR_FLAG",IR_FLAG); 
			String doc_no; //Added for  [IN:043100] -Start
			StringBuffer stBLDocSrlNo = new StringBuffer();
			if(hmBLDocSrlNo!=null && hmBLDocSrlNo.size()>0){
				ArrayList alBLSrlNo = new ArrayList( hmBLDocSrlNo.keySet());
				for(int i=0; i<alBLSrlNo.size(); i++){
					doc_no = (String)alBLSrlNo.get(i);
					stBLDocSrlNo.append(doc_no+","+ (String)hmBLDocSrlNo.get(doc_no)+";") ;
				}
			} //Added for  [IN:043100]-End
			map.put("BILLING_DET",billing_det);
			map.put("BLDocSrlNo",stBLDocSrlNo.toString()); //Added for  [IN:043100]
			map.put("print_seq_no",print_seq_no); 
		
			IR_FLAG     = new HashMap();
			billing_det = "";
		}
		catch(Exception e){
			e.printStackTrace();
			connection.rollback();
			map.put( "result", new Boolean( false) ) ;
			map.put("msgid",e.toString());
			map.put("flag","0");//e.toString()
			System.err.println("Error: During Delivery (completeDelivery) tabData="+tabData+"====map="+map);
			return map;
			//throw new EJBException("Error: During Delivery");
		}
		finally{
			try{
				closeResultSet( resultSet ) ;
				closeResultSet( resultSet1 ) ;
				closeResultSet( resultSet2 ) ;
				closeResultSet( resultSet3 ) ;
				closeStatement( cstmt );
				closeStatement( pstmt_update_order_line );
				closeStatement( pstmt_update_patient_drug_profile );
				closeStatement(	pstmt_select_order_line_ph	);	
				closeStatement(	pstmt_update_disp_hdr );				
				closeStatement(	pstmt_select_disp_tmp );	
				closeStatement( pstmt_update_disp_dtl );
				closeStatement( pstmt_update_order_line_ph );
				closeStatement( pstmt_or_order_line_select1 );
				//closeStatement( pstmt_update_order_line_ph_disp_prd );
				//closeStatement( pstmt_select_order_line_ph_disp_prd ); //Commented b'z unused
				closeStatement( pstmt_or_order_select_1 ) ;
				closeConnection( connection,prop );
			}
			catch(Exception es){
				es.printStackTrace();
				connection.rollback();
			}
		}
		return map;
	}

	public void callUpdatePhMednAdmin(Connection connection, HashMap sqlMap, HashMap tabData,ArrayList orderLineData,String patient_id,String order_id1,String IV_PREP_YN) throws Exception{
	
		String encounter_id="",SCH_ROOUTE_CODE= "",PRACT_ID="";
		String SCH_INFUSION_RATE="",SCH_INFUSION_VOL_STR_UNIT="",SCH_INFUSION_PER_UNIT="", durations="", SCH_INFUSION_PERIOD="",IV_INGREDIENTS="", SCH_INFUSION_PERIOD_UNIT="", SCH_DOSAGE_QTY="",dosage_uom_code="", strength="", strength_uom_code="";
		int duration				 = 0;
		String SCH_DATE_TIME		 = "";
		String start_date_time		 = "";
		String build_mar_yn			 = "";	
		String freq_nature           = "";
		//String Start_date_time       = "";
		PreparedStatement pstmt5	 = null ;
		PreparedStatement pstmt1	 = null ;
		PreparedStatement pstmt2	 = null ;
		PreparedStatement pstmt3	 = null ;
		PreparedStatement pstmt4	 = null ;
		//PreparedStatement pstmt5	 = null ;
		PreparedStatement pstmt		 = null ;
		ResultSet resultSet			 = null;
		ResultSet resultSet1		 = null;
		ResultSet resultSet2		 = null;
		ResultSet resultSet3		 = null;
		ResultSet resultSet4		 = null;
		ResultSet resultSet5		 = null;
		//ResultSet resultSet6		 = null;
		String login_by_id			 = (String)tabData.get("login_by_id");
		String login_at_ws_no		 = (String)tabData.get("login_at_ws_no");
		String FACILITY_ID			 = "";
		String curr_date             ="";
		String old_date              ="";
		int count					 =0;
		final String SQL_PH_IVPRESCRIPTION_INSERT2					= (String)sqlMap.get("SQL_PH_IVPRESCRIPTION_INSERT2");
		final String SQL_PH_DISP_MEDICATION_OR_ORDER_LINE_SELECT2	= (String)sqlMap.get("SQL_PH_DISP_MEDICATION_OR_ORDER_LINE_SELECT2");
		//final String SQL_PH_DISP_MEDICATION_PH_PATIENT_DRUG_PROFILE_SELECT1		= (String)sqlMap.get("SQL_PH_DISP_MEDICATION_PH_PATIENT_DRUG_PROFILE_SELECT1");
		final String SQL_PH_DISP_MEDICATION_OR_ORDER_LINE_FIELD_VALUES_SELECT2	= (String)sqlMap.get("SQL_PH_DISP_MEDICATION_OR_ORDER_LINE_FIELD_VALUES_SELECT2");
		final String SQL_PH_DISP_MEDICATION_PH_MEDN_ADMIN_DELETE	= (String)sqlMap.get("SQL_PH_DISP_MEDICATION_PH_MEDN_ADMIN_DELETE");
		final String SQL_PH_DISP_MEDICATION_SELECT148	= (String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT148");
		try {
            pstmt5   =   connection.prepareStatement(SQL_PH_DISP_MEDICATION_SELECT148); 
			pstmt5.setString(1,order_id1);
			pstmt5.setString(2,"1");
			resultSet5 = pstmt5.executeQuery() ;
			while ( resultSet5 != null && resultSet5.next() ) {
				build_mar_yn	= resultSet5.getString("BUILD_MAR_YN");
			}
			closeResultSet( resultSet5 ) ;
            closeStatement( pstmt5 ) ; 
            if(build_mar_yn.equals("Y")){
				pstmt = connection.prepareStatement(SQL_PH_DISP_MEDICATION_PH_MEDN_ADMIN_DELETE); 
				pstmt.setString(1,order_id1);
				pstmt.executeUpdate() ;
				pstmt1 = connection.prepareStatement(SQL_PH_DISP_MEDICATION_OR_ORDER_LINE_SELECT2); 
				pstmt1.setString(1,order_id1);
				resultSet1 = pstmt1.executeQuery() ;
				while ( resultSet1 != null && resultSet1.next() ) {
					encounter_id	= resultSet1.getString("encounter_id");
					SCH_ROOUTE_CODE = resultSet1.getString("SCH_ROOUTE_CODE");
					PRACT_ID = resultSet1.getString("PRACT_ID");
					start_date_time = resultSet1.getString("start_date_time");
				}
				closeStatement( pstmt1 ) ;

				if(!IV_PREP_YN.equals("0")){
				   //pstmt2 = connection.prepareStatement(SQL_PH_DISP_MEDICATION_PH_PATIENT_DRUG_PROFILE_SELECT1+"and a.order_line_num =2"); 
				   pstmt2 = connection.prepareStatement("select c.FREQ_NATURE,b.FACILITY_ID,a.infusion_rate SCH_INFUSION_RATE,a.infusion_vol_str_unit SCH_INFUSION_VOL_STR_UNIT,   a.infusion_per_unit SCH_INFUSION_PER_UNIT, a.infuse_over_unit SCH_INFUSION_PERIOD_UNIT, b.duration durations,    b.IV_INGREDIENTS IV_INGREDIENTS, a.infuse_over SCH_INFUSION_PERIOD, b.dosage SCH_DOSAGE_QTY, b.dosage_uom_code,    b.strength, b.strength_uom_code from or_order_line_ph a, ph_patient_drug_profile b ,am_frequency  c where a.order_id = b.orig_order_id 	and a.order_line_num = b.orig_order_line_no and b.freq_code=c.freq_code and a.order_id = ?"+"and a.order_line_num =1"); 
				}
				else{
					//pstmt2 = connection.prepareStatement(SQL_PH_DISP_MEDICATION_PH_PATIENT_DRUG_PROFILE_SELECT1+"and a.order_line_num =1");  
					pstmt2 = connection.prepareStatement("select c.FREQ_NATURE,b.FACILITY_ID,a.infusion_rate SCH_INFUSION_RATE,a.infusion_vol_str_unit SCH_INFUSION_VOL_STR_UNIT,   a.infusion_per_unit SCH_INFUSION_PER_UNIT, a.infuse_over_unit SCH_INFUSION_PERIOD_UNIT, b.duration durations,    b.IV_INGREDIENTS IV_INGREDIENTS, a.infuse_over SCH_INFUSION_PERIOD, b.dosage SCH_DOSAGE_QTY, b.dosage_uom_code,    b.strength, b.strength_uom_code from or_order_line_ph a, ph_patient_drug_profile b ,am_frequency  c where a.order_id = b.orig_order_id 	and a.order_line_num = b.orig_order_line_no and b.freq_code=c.freq_code and a.order_id = ?"+"and a.order_line_num =1"); 
				}
				pstmt2.setString(1,order_id1);
				resultSet2 = pstmt2.executeQuery() ;
				while ( resultSet2 != null && resultSet2.next() ) {
					FACILITY_ID				  = resultSet2.getString("FACILITY_ID");
					SCH_INFUSION_RATE		  = resultSet2.getString("SCH_INFUSION_RATE");
					SCH_INFUSION_VOL_STR_UNIT = resultSet2.getString("SCH_INFUSION_VOL_STR_UNIT");
					SCH_INFUSION_PER_UNIT	  = resultSet2.getString("SCH_INFUSION_PER_UNIT");
					SCH_INFUSION_PERIOD		  = resultSet2.getString("SCH_INFUSION_PERIOD");
					durations				  = resultSet2.getString("durations");				
					IV_INGREDIENTS			  = resultSet2.getString("IV_INGREDIENTS");
					SCH_INFUSION_PERIOD_UNIT  = resultSet2.getString("SCH_INFUSION_PERIOD_UNIT");
					SCH_DOSAGE_QTY			  = resultSet2.getString("SCH_DOSAGE_QTY");
					dosage_uom_code			  = resultSet2.getString("dosage_uom_code");
					strength				  = resultSet2.getString("strength");
					strength_uom_code		  = resultSet2.getString("strength_uom_code");	
					freq_nature               = resultSet2.getString("FREQ_NATURE"); 
				}
				if(!durations.equals("")){
					//duration=Integer.parseInt(durations);
					duration=(int)Math.ceil(Float.parseFloat(durations));
				}
				else{
					duration=0;
				}     
				pstmt4 = connection.prepareStatement(SQL_PH_DISP_MEDICATION_OR_ORDER_LINE_FIELD_VALUES_SELECT2); 
				pstmt5 = connection.prepareStatement(SQL_PH_IVPRESCRIPTION_INSERT2);

				// For compunding RX the SCH_DOSAGE_QTY, SCH_DOSAGE_UOM_CODE should be equal to 
				// or_order_line's QTY_VALUE, QTY_UNIT
				if(IV_PREP_YN.equals("6")) {
					pstmt1 = connection.prepareStatement("select QTY_VALUE, QTY_UNIT from OR_ORDER_LINE where order_id = ? and order_line_num = '1'"); 
					pstmt1.setString(1,order_id1);
					resultSet = pstmt1.executeQuery();
					if(resultSet!=null && resultSet.next()){
						SCH_DOSAGE_QTY = resultSet.getString("QTY_VALUE");
						dosage_uom_code = resultSet.getString("QTY_UNIT");
					}
				}

				if(!IV_PREP_YN.equals("2")){	
					if(!freq_nature.equals("O")&&!freq_nature.equals("P")){
						for(int i=0;i<=duration;i++){				
							pstmt4.setString(1,i+" ");
							pstmt4.setString(2,order_id1);
							pstmt4.setString(3,i+" ");
							pstmt4.setString(4,i+" ");
							resultSet4 = pstmt4.executeQuery() ;
							while ( resultSet4 != null && resultSet4.next() ) {
								if(!SCH_DATE_TIME.equals("")){
									old_date      = SCH_DATE_TIME.substring(0,SCH_DATE_TIME.length()-5) ;
								}
								SCH_DATE_TIME = resultSet4.getString("SCH_DATE_TIME");
								curr_date     = SCH_DATE_TIME.substring(0,SCH_DATE_TIME.length()-5) ;
								
								if(old_date.equals(curr_date)||old_date.equals("")){
									count=count+1;
								}
								else{
									count=1;
								}
								//pstmt5 = connection.prepareStatement(SQL_PH_IVPRESCRIPTION_INSERT2); 
								pstmt5.setString(1,FACILITY_ID);
								pstmt5.setString(2,encounter_id);
								pstmt5.setString(3,SCH_DATE_TIME);
								pstmt5.setString(4,"FINAL PRODUCT");
								pstmt5.setString(5,count+"");
								pstmt5.setString(6,order_id1);
								pstmt5.setString(7,"1");
								pstmt5.setString(8,patient_id);
								pstmt5.setString(9,PRACT_ID);
								pstmt5.setString(10,"N");//IV_ADMIN_YN="N"
								pstmt5.setString(11,IV_INGREDIENTS);
								pstmt5.setString(12,SCH_DOSAGE_QTY);
								pstmt5.setString(13,dosage_uom_code);
								pstmt5.setString(14,strength);
								pstmt5.setString(15,strength_uom_code);
								pstmt5.setString(16,SCH_ROOUTE_CODE);
								pstmt5.setString(17,SCH_INFUSION_RATE);
								pstmt5.setString(18,SCH_INFUSION_VOL_STR_UNIT);
								pstmt5.setString(19,SCH_INFUSION_PER_UNIT);
								pstmt5.setString(20,"N");//VERIFY_REQD_YN="N"
								pstmt5.setString(21,login_by_id);
								pstmt5.setString(22,login_at_ws_no);
								pstmt5.setString(23,FACILITY_ID);
								pstmt5.setString(24,login_by_id);
								pstmt5.setString(25,login_at_ws_no);
								pstmt5.setString(26,FACILITY_ID);
								pstmt5.setString(27,SCH_INFUSION_PERIOD);
								pstmt5.setString(28,SCH_INFUSION_PERIOD_UNIT);
								pstmt5.setString(29,""); //MAR_BARCODE_ID MMS-QH-CRF-0080 [IN:038064]
								//pstmt5.executeUpdate() ;
								pstmt5.addBatch();
							}				
						}	
					}
					else{
					
						//pstmt5 = connection.prepareStatement(SQL_PH_IVPRESCRIPTION_INSERT2); 
						pstmt5.setString(1,FACILITY_ID);
						pstmt5.setString(2,encounter_id);
						pstmt5.setString(3,start_date_time);
						pstmt5.setString(4,"FINAL PRODUCT");
						pstmt5.setString(5,"1");
						pstmt5.setString(6,order_id1);
						pstmt5.setString(7,"1");
						pstmt5.setString(8,patient_id);
						pstmt5.setString(9,PRACT_ID);
						pstmt5.setString(10,"N");//IV_ADMIN_YN="N"
						pstmt5.setString(11,IV_INGREDIENTS);
						pstmt5.setString(12,SCH_DOSAGE_QTY);
						pstmt5.setString(13,dosage_uom_code);
						pstmt5.setString(14,strength);
						pstmt5.setString(15,strength_uom_code);
						pstmt5.setString(16,SCH_ROOUTE_CODE);
						pstmt5.setString(17,SCH_INFUSION_RATE);
						pstmt5.setString(18,SCH_INFUSION_VOL_STR_UNIT);
						pstmt5.setString(19,SCH_INFUSION_PER_UNIT);
						pstmt5.setString(20,"N");//VERIFY_REQD_YN="N"
						pstmt5.setString(21,login_by_id);
						pstmt5.setString(22,login_at_ws_no);
						pstmt5.setString(23,FACILITY_ID);
						pstmt5.setString(24,login_by_id);
						pstmt5.setString(25,login_at_ws_no);
						pstmt5.setString(26,FACILITY_ID);
						pstmt5.setString(27,SCH_INFUSION_PERIOD);
						pstmt5.setString(28,SCH_INFUSION_PERIOD_UNIT);
						pstmt5.setString(29,""); //MAR_BARCODE_ID MMS-QH-CRF-0080 [IN:038064]
						//pstmt5.executeUpdate() ;
						pstmt5.addBatch();
					}
					closeResultSet( resultSet4 ) ;
					if(pstmt5 != null){
						int result[] = pstmt5.executeBatch();
						for (int i=0;i<result.length ;i++ ){
								// A number greater than or equal to zero  indicates success
								// A number -2 indicates that command is successful but number of rows updated is unknow
								// If it won't satisfy any of the above cancel the statement and throw an exception
							if(result[i]<0  && result[i] != -2 ){
								pstmt5.cancel();
								connection.rollback();
								throw new EJBException("Update OR_ORDER_LINE_PH failed");
							}		
						}
					}
				}
				else{			
					//pstmt5 = connection.prepareStatement(SQL_PH_IVPRESCRIPTION_INSERT2); 
					
					pstmt5.setString(1,FACILITY_ID);
					pstmt5.setString(2,encounter_id);
					pstmt5.setString(3,start_date_time);
					pstmt5.setString(4,"FINAL PRODUCT");
					pstmt5.setString(5,"1");
					pstmt5.setString(6,order_id1);
					pstmt5.setString(7,"1");
					pstmt5.setString(8,patient_id);
					pstmt5.setString(9,PRACT_ID);
					pstmt5.setString(10,"N");//IV_ADMIN_YN="N"
					pstmt5.setString(11,IV_INGREDIENTS);
					pstmt5.setString(12,SCH_DOSAGE_QTY);
					pstmt5.setString(13,dosage_uom_code);
					pstmt5.setString(14,strength);
					pstmt5.setString(15,strength_uom_code);
					pstmt5.setString(16,SCH_ROOUTE_CODE);
					pstmt5.setString(17,SCH_INFUSION_RATE);
					pstmt5.setString(18,SCH_INFUSION_VOL_STR_UNIT);
					pstmt5.setString(19,SCH_INFUSION_PER_UNIT);
					pstmt5.setString(20,"N");//VERIFY_REQD_YN="N"
					pstmt5.setString(21,login_by_id);
					pstmt5.setString(22,login_at_ws_no);
					pstmt5.setString(23,FACILITY_ID);
					pstmt5.setString(24,login_by_id);
					pstmt5.setString(25,login_at_ws_no);
					pstmt5.setString(26,FACILITY_ID);
					pstmt5.setString(27,SCH_INFUSION_PERIOD);
					pstmt5.setString(28,SCH_INFUSION_PERIOD_UNIT);                
					pstmt5.setString(29,"");   //MAR_BARCODE_ID MMS-QH-CRF-0080 [IN:038064]             

					pstmt5.executeUpdate() ;						
				}
			}
		}
		catch ( Exception e ) {
			System.err.println( "Error while inserting record into PH_MEDN_ADMIN (callUpdatePhMednAdmin) tabData="+tabData+ "===orderLineData="+orderLineData +" ==patient_id="+patient_id+" ===order_id1="+order_id1+" IV_PREP_YN="+IV_PREP_YN);
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try {
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt1 ) ;
				closeResultSet( resultSet2 ) ;
				closeStatement( pstmt2 ) ;
				closeResultSet( resultSet3 ) ;
				closeStatement( pstmt3 ) ;
				closeResultSet( resultSet4 ) ;
				closeStatement( pstmt4 ) ;
				closeResultSet( resultSet5 ) ;
				closeStatement( pstmt5 ) ;
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
	}	

	// This method will give the sequence number
	public String getSequenceNo(String sql_ph_disp_medication_select33)throws Exception{
		String result = "";
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null;
		try {
			connection = getConnection(prop) ;
			pstmt = connection.prepareStatement( sql_ph_disp_medication_select33 ) ;
			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next() ) {
				result = resultSet.getString("NEXTVAL");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			throw new EJBException("Error while getting sequence no");
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				resultSet=null;
				pstmt=null;
				closeConnection( connection,prop );
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
		return result;
	}	

	
	// All Stages Dispensing ...........
	public HashMap completeDispensing(HashMap tabData,HashMap sqlMap ) throws Exception{
	
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		IR_FLAG		= new HashMap();	
		prop		= (Properties)tabData.get( "properties" );	
		
		String facility_id				= (String)tabData.get("facility_id");
		String login_by_id				= (String)tabData.get("login_by_id");
		String login_at_ws_no			= (String)tabData.get("login_at_ws_no");
		String patient_class			= (String)tabData.get("patient_class");
		if(patient_class.equals("XT")) {
			tabData.put("encounter_id","11111");
		}
		String patient_id				 = (String)tabData.get("patient_id");
		String filling_status			 = (String)tabData.get("filling_status");
		String token_yn					 = (String)tabData.get("token_yn");
		ArrayList orderLineData			 = (ArrayList)tabData.get("orderLineData");
		ArrayList orderLineData1		 = (ArrayList)tabData.get("orderLineData1");
		ArrayList patientDrugProfileData = (ArrayList)tabData.get("patientDrugProfileData");
		ArrayList dispAllocTMP			 = (ArrayList)tabData.get("dispAllocTMP");
		ArrayList dispFillTMP			 = (ArrayList)tabData.get("dispFillTMP");
		ArrayList dispAlloc				 = (ArrayList)tabData.get("dispAlloc");
		ArrayList dispFill				 = (ArrayList)tabData.get("dispFill");
		ArrayList dispDel				 = (ArrayList)tabData.get("dispDel");
		ArrayList delivery_details		 = (ArrayList)tabData.get("delivery_details");
		String delivery_applicable		 = (String)tabData.get("delivery_applicable");//Added for MO-GN-5434 [IN:043669]
		String disp_stage		 		 = (String)tabData.get("disp_stage");//Added for MO-GN-5434 [IN:043669]
		String fill_list		 		 = (String)tabData.get("fill_list");//Added for MO-GN-5434 [IN:043669]
		ArrayList<String> arrMedPlanSeqNo	= (ArrayList)tabData.get("arrMedPlanSeqNo");// Added for  Bru-HIMS-CRF-072.1[IN 049144]
		String isMedValuesChanged			= (String)tabData.get("isMedValuesChanged");// Added for  Bru-HIMS-CRF-072.1[IN 049144]
		String mediplan_seq_no ="";//Added for Bru-HIMS-CRF-072.1[IN 049144]
		String valuesChanged = (String)tabData.get("ValuesChanged")==null?"":(String)tabData.get("ValuesChanged");//Added for MO-GN-5434 [IN:043669]
		HashMap editableLabel			= tabData.get("editableLabel")!=null?(HashMap)tabData.get("editableLabel"):null; // added for Ml-BRU-SCF-1944
		String allow_edit_disp_label	= tabData.get("allow_edit_disp_label")!=null?(String)tabData.get("allow_edit_disp_label"):""; // added for Ml-BRU-SCF-1944
		if(!((disp_stage.equals("F")&&patient_class.equals("O") )|| fill_list.equals("AF")))
			valuesChanged = "true";
		String dispensed_by				 =	"";
		String st_doc_type				 =	"";
		String encounter_id              =  (String)tabData.get("encounter_id");//Added for TH-KW-CRF-0020.9
		String disp_locn_code              =  (String)tabData.get("disp_locn_code");//Added for TH-KW-CRF-0020.9

		if(delivery_details.size()>0 && token_yn.equals("Y")){
			//collected_by		 = (String)delivery_details.get(0);
			//gender				 = (String)delivery_details.get(1);
			//nationality			 = (String)delivery_details.get(2);
			dispensed_by		 = (String)delivery_details.get(3);
			//date_time			 = (String)delivery_details.get(4);
			//token_series_code	 = (String)delivery_details.get(5);
			//token_no			 = (String)delivery_details.get(6);
		} 
		else if(delivery_details.size()>0){
			//collected_by = (String)delivery_details.get(0);
			dispensed_by = (String)delivery_details.get(3);
			//date_time	 = (String)delivery_details.get(4);
		}
		Connection connection								= null ;
		CallableStatement cstmtDispenseStat					= null;			
		//PreparedStatement pstmt_update_order_line			= null;
		//PreparedStatement pstmt_update_patient_drug_profile	= null;
		//PreparedStatement pstmt_update_order				= null ;

		HashMap orderUpdate				=	new HashMap();;
		HashMap	prev_doc_no				=	new HashMap();
		HashMap	stock_srl				=	new HashMap();
		String update_string			=   "";
		ArrayList tmp					=	new ArrayList();
		HashMap stock_vals				=	null;
		HashMap seq_no					=	null;
		HashMap complte_order_reason	=   (HashMap)tabData.get("complte_order_reason");
		PreparedStatement pstmt_print_seq_no	= null;//Added for RUT-CRF-0061
		ResultSet resultSet1					= null;//Added for RUT-CRF-0061
		String print_seq_no						=	"";//Added for RUT-CRF-0061
		String settlement_id = "";//MOHE-CRF-0026.1 START
		ArrayList arrInterfaceDet = new ArrayList(); 
		String authStatusCompleted_yn = ""; 
		String ivPrep_yn = ""; 
		String  postAuthStatusData				= "";
		String iqviaIntegrationFlag= ""; 
		authStatusCompleted_yn = (String)tabData.get("authStatusCompleted_yn"); 
		iqviaIntegrationFlag = (String)tabData.get("iqviaIntegrationFlag"); 
		settlement_id= (String)tabData.get("settlement_id");
		ivPrep_yn = (String)tabData.get("IV_PREP_YN"); 
		postAuthStatusData = (String)tabData.get("postAuthStatusData"); //MOHE-CRF-0026.1 END 
	
		tabData.put("curr_disp_stage","AS");
 
		try{
			connection = getConnection(prop) ;
			//PRINT_SEQ_NO Added for RUT-CRF-0061 - Start
			pstmt_print_seq_no = connection.prepareStatement("SELECT OFFLINE_PRINT_SEQ.NEXTVAL PRINT_SEQ_NO FROM DUAL");
            resultSet1 = pstmt_print_seq_no.executeQuery() ;
            while ( resultSet1.next() ) {
				print_seq_no = resultSet1.getString("PRINT_SEQ_NO");
			}
            tabData.put("print_seq_no_tmp",print_seq_no);
			closeStatement(pstmt_print_seq_no);
			closeResultSet( resultSet1 ) ;
			//PRINT_SEQ_NO Added for RUT-CRF-0061 - End
			// Get the Stock Doc Type 
			st_doc_type	=	getStockDocType(connection,sqlMap,patient_class,facility_id);
			// Update the table or_order_line
			orderUpdate	=	updateOrOrderLine(connection, sqlMap,orderLineData,tabData,update_string );
			updateOrOrderLinePh(connection,sqlMap,tabData,orderLineData,orderLineData1,complte_order_reason);           
	
			// Get the line status
			//ord_line_status	=	getOrderLineStatus(connection,sqlMap,orderLineData,tabData);

			if(dispAllocTMP.size() !=0 || dispFillTMP.size() != 0)	{
				if(dispFillTMP.size()!=0)
					tmp	=	dispFillTMP;
			}

			if(dispDel.size()!=0) {
				if(filling_status.equals("A")) {
					dispAlloc	=	dispFill;
					if(tmp.size()!=0) {
						for(int j=0; j<dispAlloc.size(); j++)
							tmp.add(dispAlloc.get(j));
					}
				} 
				else {
					if(tmp.size()!=0) {
						for(int j=0; j<dispFill.size(); j++)
							tmp.add(dispFill.get(j));
					}
				}				
			}

			if(tmp.size()==0) {
				if(filling_status.equals("A"))//||filling_status.equals("X"))//filling_status.equals("X") added for MMS_ADHOC_0051[48484] //Commented b'z Allocated/filled restriced in All Stages for TTM-SCF-0097
					tmp	=	dispAlloc;
				else 
					tmp	=	dispFill;
			}
			// Get the previous docno and doctype
			stock_vals		=	getDocValues(connection,sqlMap,orderLineData,tmp,tabData);
			if(stock_vals.size() > 1 ) {
				prev_doc_no		= (HashMap)stock_vals.get("doc_no");
				//prev_doc_type	= (HashMap)stock_vals.get("doc_type");
				stock_srl		= (HashMap)stock_vals.get("srl_no");
			}

			/******* Disp Queue Updation starts****/
			if(token_yn.equals("Y")) {
				updateDispQueue(connection, sqlMap, tabData,orderLineData,"AS");
			}
			/******* Disp Queue updation ends*****/
			//Adding start for TH-KW-CRF-0020.9
			boolean display_delivery_bin = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","DISPLAY_DELIVERY_BIN");
			if(display_delivery_bin && token_yn.equals("N")){
				updateStorageLocation(connection,patient_id,encounter_id,disp_locn_code);
			}
            //Adding end for TH-KW-CRF-0020.9
			/*******Work Load Status*********/
			for(int i=0;i<orderLineData.size();i=i+9){
				cstmtDispenseStat = connection.prepareCall("{call Ph_Create_Work_Stats_Dispense(?,?,?,?,?,?,?,?,?,?,?,?)}");
				int count=1;
				cstmtDispenseStat.setString(   count, dispensed_by.trim());			// Dispenser ID
				cstmtDispenseStat.setString( ++count, facility_id.trim());			// Facility ID
				cstmtDispenseStat.setString( ++count, patient_id.trim());			// Patient ID
				cstmtDispenseStat.setString( ++count, ((String)orderLineData.get(i+3)).trim());	// Order ID
				cstmtDispenseStat.setString( ++count, ((String)orderLineData.get(i+4)).trim());	 //Order line num
				cstmtDispenseStat.setString( ++count, "1");							// total number of orders dispensed
				cstmtDispenseStat.setInt( ++count, 0);					
				cstmtDispenseStat.setInt( ++count, 0);
				cstmtDispenseStat.setString( ++count, login_by_id.trim());			// Login ID
				cstmtDispenseStat.setString( ++count, login_at_ws_no.trim());		// Work station 
				cstmtDispenseStat.registerOutParameter(++count,Types.VARCHAR );
				cstmtDispenseStat.registerOutParameter(++count,Types.VARCHAR );
				int cstmtResult = cstmtDispenseStat.executeUpdate() ;
				if(cstmtResult < 0 ){
					throw new EJBException("Error: Work Load Status Insert Failed");
				}
			}
			if(cstmtDispenseStat !=null){
				int[] result6=cstmtDispenseStat.executeBatch();
				
				for (int k=0;k<result6.length ;k++ ){
					if(result6[k]<0  && result6[k] != -2 ){
						cstmtDispenseStat.cancel();
						closeStatement(cstmtDispenseStat);
						connection.rollback();
						throw new EJBException("Error: Work Load Procedure Failed");
					}		
				}
			}  
			//MOHE-CRF-0026.1
			if(patient_class.equals("O") && iqviaIntegrationFlag!=null && iqviaIntegrationFlag.equals("Y") && settlement_id!=null && settlement_id.equals("X")){  //modified for MOHE-SCF-0166
			
				if((ivPrep_yn==null || ivPrep_yn.equals("") || ivPrep_yn.equals("null")) ){  
					if(authStatusCompleted_yn!= null && !authStatusCompleted_yn.equals("") && authStatusCompleted_yn.equals("Y")){
						arrInterfaceDet =  setBillingInterfaceDetails( connection, sqlMap, tabData, postAuthStatusData);  
						tabData.put("arrInterfaceDet", arrInterfaceDet);  
					}
					
				}
			}
			 
			/******Work Load Status ends************************/
			/******* Disp Queue updation ends ****/
			// Delete tmp tables
			deleteTMPTables(connection,sqlMap,orderLineData,tabData);
			//deletesales(connection,tabData,dispAlloc,prev_doc_no,st_doc_type,sqlMap,stock_srl);//deletesales method added for MMS_ADHOC_0051[48484] Commented b'z Allocated/filled restriced in All Stages for TTM-SCF-0097
			// Update the ph_patient_drug_profile
			updatePatientDrugProfile(connection,sqlMap,tabData,patientDrugProfileData);
			// Update or_order
			updateOrOrder(connection,sqlMap,tabData,orderLineData,orderUpdate,update_string);
			if(dispDel.size()!=0 || valuesChanged.equals("true") ||  !delivery_applicable.equals("Y") ) {//Added || valuesChanged.equals("true") ||  !delivery_applicable.equals("Y") for MO-GN-5434 [IN:043669]  
				if(filling_status.equals("A"))
					dispAlloc		=	dispFill;
				seq_no			=	insertHeader( connection,sqlMap,tabData,dispAlloc );		
				stock_srl		=	insertDetail(connection,sqlMap,tabData,dispAlloc,seq_no,stock_srl);
				if(((String)tabData.get("strMedPlanYN")).equals("Y")){// AniT code Added for  Bru-HIMS-CRF-072.1[IN 049144] start
					if(isMedValuesChanged.equals("true")){
						if(arrMedPlanSeqNo.size()==0)
							mediplan_seq_no = insertMedicationPlan(connection, sqlMap,tabData,stock_srl);// If there is no medication plan id, generate plan id and insert the values
						else if(arrMedPlanSeqNo.size()==1){
							tabData.put("mediplan_seq_no",(String)arrMedPlanSeqNo.get(0));
							mediplan_seq_no = updateMedicationPlan(connection, sqlMap,tabData);// If there is one medication plan id, update the values
						}
						else{// If there is more than one medication plan id, generate new plan id and insert the values. Delete old plan id records along with order id and order line number 
							mediplan_seq_no = insertMedicationPlan(connection, sqlMap,tabData,stock_srl);
							deleteMedicationPlan(connection,sqlMap,tabData);
						}
					}
				}// Added for  Bru-HIMS-CRF-072.1[IN 049144] end
				ArrayList tot_cons_dtl = (ArrayList)tabData.get("CONSUMABLES_DET");
				insertBatch(connection, sqlMap,tabData,dispAlloc,seq_no);
				if(tot_cons_dtl!=null && tot_cons_dtl.size()>0){ //added if condition for AMS-SCF-0224[IN036937]
					//code for inserting PH_DISP_CONS_DTL
					insertConsumableDeatil(connection,sqlMap,tabData);
					//code for inserting PH_DISP_CONS_BATCH
					insertConsumableBatch(connection,sqlMap,tabData);
				}

				tabData.put("disp_stage","D");
				tabData.put("seq_no",seq_no);
				//	Stock Insertion starts
				if(dispDel.size()!=0){ // if condition added for MO-GN-5434 [IN:043669]  
					callStockUpdate(connection,tabData,sqlMap,dispAlloc,prev_doc_no,st_doc_type,stock_srl);
					updateDispensedDetail(connection, sqlMap, tabData,dispAlloc,"AS");
				}

				if(allow_edit_disp_label.equals("Y") && editableLabel!=null && editableLabel.size()>0 ){ //if block added for ML-BRu-SCF-1944
						insertUpdateDispLabelDtl(connection, sqlMap,tabData, dispAlloc);
					}
			}
			/***** Main Table Insertion Over****/
			/*** TMP table insertion starts****/
			/*if(dispAllocTMP.size() !=0 || dispFillTMP.size() != 0)	{
				if(dispFillTMP.size()!=0)
					dispAllocTMP	=	dispFillTMP;
				// Insert into PH_DISP_HDR_TMP
				seq_no	=	insertHeaderTMP(connection,sqlMap,tabData,dispAllocTMP);
				// Insert in to PH_DISP_DTL_TMP
				stock_srl		=	insertDetailTMP(connection, sqlMap,tabData,dispAllocTMP,seq_no,stock_srl);
				// Insert in to PH_DISP_DRUG_BATCH_TMP
				insertBatchTMP(connection,sqlMap,tabData,dispAllocTMP,seq_no,stock_srl);
				tabData.put("seq_no",seq_no);
				//	Stock Insertion starts
				callStockUpdate(connection,tabData,sqlMap,dispAllocTMP,prev_doc_no,st_doc_type,stock_srl);
			}*/
		String doc_no= ""; //Added for  [IN:043100] -Start
			StringBuffer stBLDocSrlNo = new StringBuffer();
			if(hmBLDocSrlNo!=null && hmBLDocSrlNo.size()>0){
				ArrayList alBLSrlNo = new ArrayList( hmBLDocSrlNo.keySet());
				for(int i=0; i<alBLSrlNo.size(); i++){
					doc_no = (String)alBLSrlNo.get(i);
					stBLDocSrlNo.append(doc_no+","+ (String)hmBLDocSrlNo.get(doc_no)+";") ;
				}
			} //Added for  [IN:043100]-End
			 ArrayList barcode_remarks= (ArrayList)tabData.get("barcode_remarks");

			if(barcode_remarks!=null && barcode_remarks.size()>0)
			insertBarcodeScanCount(connection,tabData);//Added for MMS-DM-CRF-0157.1
			connection.commit();
			if(!mediplan_seq_no.equals(""))//Added for Bru-HIMS-CRF-072.1[IN 049144]
				map.put( "mediplan_seq_no", mediplan_seq_no ) ;
			map.put( "result", new Boolean( true) ) ;
			map.put("msgid","RECORD_MODIFIED");
			map.put("IR_FLAG",IR_FLAG);
			map.put("BILLING_DET",billing_det);
			map.put("BLDocSrlNo",stBLDocSrlNo.toString()); //Added for  [IN:043100] //added for mms-dm-scf-0575
			map.put( "print_seq_no", print_seq_no ) ;//Added for RUT-CRF-0061
			IR_FLAG     =  new HashMap();
			billing_det =  "";
		}
		catch(Exception e){
			e.printStackTrace();
			map.put("flag","0");//e.toString()
			map.put("result", new Boolean( false) ) ;
			map.put("msgid",e.toString());
			connection.rollback();
			System.err.println("Error: During AllStages tabData="+tabData);
			return map;
			//throw new EJBException("Error: During AllStages");
		}
		finally{
			try{
				//closeStatement( pstmt_update_order_line ) ;
				//closeStatement( pstmt_update_patient_drug_profile ) ;
				//closeStatement( pstmt_update_order );
				closeStatement( cstmtDispenseStat );
				closeConnection( connection,prop );
				// objects are nullified after usage
				orderLineData				=	null;
				patientDrugProfileData		=	null;
				dispAllocTMP				=	null;
				dispFillTMP					=	null;
				dispAlloc					=	null;
				dispFill					=	null;
				dispDel						=	null;
				delivery_details			=	null;
				orderUpdate					=	null;
				prev_doc_no					=	null;
				stock_srl					=	null;
				tmp							=	null;
				stock_vals					=	null;
				seq_no						=	null;	
				tabData						=	null;
				sqlMap						=	null;

			}
			catch(Exception es){
				map.put("flag","0");//es.toString()
				es.printStackTrace();
				connection.rollback();
				map.put( "result", new Boolean( false) ) ;
				map.put("msgid",es.toString());			
			}
		}
		return map;
	}
	
	private String getStockDocType(Connection conn, HashMap sqlMap,String patient_class,String facility_id) {
		String st_doc_type							=	"";
		PreparedStatement pstmt_st_doc_type			=	null;
		ResultSet resSet							=	null;
		
		try {
			pstmt_st_doc_type	= conn.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT56") ) ;

			if(patient_class.equals("I")) {
				pstmt_st_doc_type.setString(1,"DIIP");
			}
			else {
				pstmt_st_doc_type.setString(1,"DIOP");
			}
			pstmt_st_doc_type.setString(2,facility_id);
			pstmt_st_doc_type.setString(3,facility_id);

			resSet				= pstmt_st_doc_type.executeQuery() ;
			
			if(resSet.next()) {
				st_doc_type	=	(String)resSet.getString("ST_DOC_TYPE_CODE");
			}

		}catch(Exception e){
				e.printStackTrace();
		}finally{	
				try {
				closeResultSet( resSet ) ;
				closeStatement( pstmt_st_doc_type ) ;
				pstmt_st_doc_type=null;
				resSet=null;
				}
				catch(Exception es) { 
					es.printStackTrace();
				}
		}

		return st_doc_type;
	}

//update or_order_line_ph
	private void updateOrOrderLinePh(Connection connection, HashMap sqlMap, HashMap tabData,ArrayList orderLineData, ArrayList orderLineData1,HashMap complte_order_reasons) throws Exception {
		PreparedStatement pstmt_update_order_line_ph	=	null;
		PreparedStatement pstmt_update_order_line_ph_1	=	null;
		PreparedStatement pstmt_update_order_line_ph_2	=	null;
		PreparedStatement pstmt_select_order_line_ph	=	null;
		PreparedStatement pstmt_update_order_line_ph_disp_prd =  null;
		ResultSet resSet								=	null;
		String fill_list								= tabData.get("fill_list")==null?"":(String)tabData.get("fill_list");
		String disp_stage = tabData.get("disp_stage")==null?"":(String)tabData.get("disp_stage");  
		String filling_status = tabData.get("filling_status")==null?"":(String)tabData.get("filling_status");
		HashMap hmalloc_bms_chk_val		= (HashMap)tabData.get("alloc_bms_chk_val");  // Added for ML-BRU-SCF-1187 [IN:045600]
		String autoCompletePartialDisp   =  (String)tabData.get("autoCompletePartialDisp"); 	// Added for JD-CRF-0179 [IN:41211]
		
		ArrayList dispensePeriod	=  new ArrayList();
		dispensePeriod.add(tabData.get("IPFillProcess")==null?"":tabData.get("IPFillProcess").toString());
		dispensePeriod.add(tabData.get("IPFillPeriodAhead")==null?"":tabData.get("IPFillPeriodAhead").toString());
		ArrayList dispTMP			= (ArrayList)tabData.get("dispTMP");		
		String code="",remarks="",keys="";//Code added for ML-BRU-SCF-0971[IN042220] --Start
		ArrayList find_result	= null;
		HashMap allocateRemarks = null;
		HashMap fillingRemarks = null;
		HashMap deliveryRemarks = null;//Code added for ML-BRU-SCF-0971[IN042220] --End
		HashMap hmFillReasons   = (HashMap)tabData.get("hmFillReasons")==null?new HashMap():(HashMap)tabData.get("hmFillReasons");//added for ML-MMOH-SCF-0465 
		//System.err.println("DispMedicationManager.java====hmFillReasons====2330=>"+hmFillReasons);
		ArrayList fill_remarks	= null;
		String curr_disp_stage    =	(String)tabData.get("curr_disp_stage");//Code added for ML-BRU-SCF-0971[IN042220] --End		 
		try {
			String pat_couns_ord_pract_id		=	 "";
			String complete_order_reason		=    "", key;
			pstmt_update_order_line_ph = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_LINE_PH_UPDATE") ) ;
			pstmt_update_order_line_ph_1=connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_LINE_PH_UPDATE1") ) ;
			if(curr_disp_stage != null && curr_disp_stage.equals("AS")) {//Code disp_stage is replaced by 'curr_disp_stage' for ML-BRU-SCF-0971[IN042220]
			  // pstmt_update_order_line_ph_2=connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_LINE_PH_UPDATE2A") ) ;
			   pstmt_update_order_line_ph_2=connection.prepareStatement( "UPDATE OR_ORDER_LINE_PH SET complete_order_reason = ? , MODIFIED_DATE=SYSDATE ,LAST_DISPENSED_DATE=TO_DATE(?,'DD/MM/YYYY HH24:MI'), DELIVERY_REMARKS_CODE=?, DELIVERY_TASK_FINDING=?,BMS_INCLUDE_YN=? WHERE ORDER_ID=? AND ORDER_LINE_NUM=? ") ;//Code added for ML-BRU-SCF-0971[IN042220]// Added BMS_INCLUDE_YN for ML-BRU-SCF-1187 [IN:045600]
			}
			else{
			  // pstmt_update_order_line_ph_2=connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_LINE_PH_UPDATE2") ) ;//Code commeted and added for ML-BRU-SCF-0971[IN042220] --Start
			  if(disp_stage.equals("V")){
					pstmt_update_order_line_ph_2=connection.prepareStatement( "UPDATE OR_ORDER_LINE_PH SET complete_order_reason = ? , MODIFIED_DATE=SYSDATE,BMS_INCLUDE_YN=? WHERE ORDER_ID=? AND ORDER_LINE_NUM=?" ) ;// Added BMS_INCLUDE_YN for ML-BRU-SCF-1187 [IN:045600]
			   }
			  else if(disp_stage.equals("A")){
					pstmt_update_order_line_ph_2=connection.prepareStatement( "UPDATE OR_ORDER_LINE_PH SET complete_order_reason = ? , MODIFIED_DATE=SYSDATE ,ALLOCATE_REMARKS_CODE=?, ALLOCATE_TASK_FINDING =?,BMS_INCLUDE_YN=?  WHERE ORDER_ID=? AND ORDER_LINE_NUM=?" ) ;// Added BMS_INCLUDE_YN for ML-BRU-SCF-1187 [IN:045600]
			   }
			   else if(disp_stage.equals("F")){
					pstmt_update_order_line_ph_2=connection.prepareStatement( "UPDATE OR_ORDER_LINE_PH SET complete_order_reason = ? , MODIFIED_DATE=SYSDATE ,FILL_REMARKS_CODE=?, FILL_TASK_FINDING=?,BMS_INCLUDE_YN=? WHERE ORDER_ID=? AND ORDER_LINE_NUM=?" ) ;// Added BMS_INCLUDE_YN for ML-BRU-SCF-1187 [IN:045600]
			   } 
			   else if(disp_stage.equals("D")){
					pstmt_update_order_line_ph_2=connection.prepareStatement( " UPDATE OR_ORDER_LINE_PH SET complete_order_reason = ? , MODIFIED_DATE=SYSDATE , DELIVERY_REMARKS_CODE=?, DELIVERY_TASK_FINDING=? WHERE ORDER_ID=? AND ORDER_LINE_NUM=? " ) ;
			   }//Code added for ML-BRU-SCF-0971[IN042220] --End
			}

			// pstmt_update_order_line_ph_2 = connection.prepareStatement("UPDATE OR_ORDER_LINE_PH SET complete_order_reason = ? , MODIFIED_DATE=SYSDATE  WHERE ORDER_ID=? AND ORDER_LINE_NUM=?");
			pstmt_select_order_line_ph =connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT145") ) ;

			for(int i=0;i<orderLineData1.size();i=i+3){

			   pstmt_select_order_line_ph.setString(1,((String)orderLineData1.get(i+1)).trim());
			   pstmt_select_order_line_ph.setString(2,((String)orderLineData1.get(i+2)).trim());
			   resSet				= pstmt_select_order_line_ph.executeQuery() ;
			   if(resSet.next()) {
					pat_couns_ord_pract_id=resSet.getString("pat_couns_ord_pract_id") == null ? "":resSet.getString("pat_couns_ord_pract_id");
				}
			  
				if(pat_couns_ord_pract_id.equals("")){
					pstmt_update_order_line_ph_1.setString(1,(String)orderLineData1.get(i)==""?null:(String)orderLineData1.get(i));
					pstmt_update_order_line_ph_1.setString(2,(String)tabData.get("funct_role_id"));
					pstmt_update_order_line_ph_1.setString(3,((String)orderLineData1.get(i+1)).trim());	
					pstmt_update_order_line_ph_1.setString(4,((String)orderLineData1.get(i+2)).trim());	
					pstmt_update_order_line_ph_1.addBatch();

				}
				else{
					pstmt_update_order_line_ph.setString(1,(String)orderLineData1.get(i)==""?null:(String)orderLineData1.get(i));	
					pstmt_update_order_line_ph.setString(2,((String)orderLineData1.get(i+1)).trim());	
					pstmt_update_order_line_ph.setString(3,((String)orderLineData1.get(i+2)).trim());	
					pstmt_update_order_line_ph.addBatch();					
				}
			}
			// if(complte_order_reasons.size()>0){
				for(int i=0;i<orderLineData.size();i=i+6){	//Modified for RUT-CRF-0088 [IN036978] 7->6
					key = ((String)orderLineData.get(i+3)).trim()+((String)orderLineData.get(i+4)).trim();
					if( complte_order_reasons.containsKey(key)){
						complete_order_reason   =  (String) complte_order_reasons.get(key);
					}
					else{
						complete_order_reason   =  "";
					}
					keys = ((String)orderLineData.get(i+3)).trim()+"_"+((String)orderLineData.get(i+4)).trim();//Code added for ML-BRU-SCF-0971[IN042220] --Start									
					if(disp_stage.equals("A")){
						allocateRemarks			=   (HashMap)tabData.get("allocatefill_remarks");
						if(allocateRemarks.containsKey(keys)) {
							find_result	= (ArrayList)allocateRemarks.get(keys);
							code	= (String)find_result.get(1);
							remarks	= (String)find_result.get(2);
						}
						else{
							if(hmFillReasons.containsKey(keys)){//added for ML-MMOH-SCF-0465
							fill_remarks = (ArrayList)hmFillReasons.get(keys);
		//					System.err.println("DispMedicationManager.java===2404=fill_remarks=====>"+fill_remarks);
								if(fill_remarks!=null && fill_remarks.size()>0){
								code		= (String)fill_remarks.get(0);
								remarks		= (String)fill_remarks.get(1);
								}else{
									code		= "";
									remarks		= "";
								}

							}//end
							else{
								code		= "";
								remarks		= "";
							}
						}
					}
					else if(disp_stage.equals("F")){
						fillingRemarks			=   (HashMap)tabData.get("fillingRemarks");
						if(fillingRemarks.containsKey(keys)) {
							find_result	= (ArrayList)fillingRemarks.get(keys);							
							code	= (String)find_result.get(1);
							remarks	= (String)find_result.get(2);
						}
						else{
							if(hmFillReasons.containsKey(keys)){//added for ML-MMOH-SCF-0465
									fill_remarks = (ArrayList)hmFillReasons.get(keys);
					//		System.err.println("DispMedicationManager.java===2431====fill_remarks=====>"+fill_remarks);
								if(fill_remarks!=null && fill_remarks.size()>0){
								code		= (String)fill_remarks.get(0);
								remarks		= (String)fill_remarks.get(1);
								}else{
									code		= "";
									remarks		= "";
								}
							}//end
							else{
								code			= "";
								remarks			= "";
							}
						}
					}										
					else if(disp_stage.equals("D") || disp_stage.equals("AS")){
						deliveryRemarks			=   (HashMap)tabData.get("deliveryRemarks");
						if(deliveryRemarks.containsKey(keys)) {	
							find_result	= (ArrayList)deliveryRemarks.get(keys);
							code	= (String)find_result.get(1);
							remarks	= (String)find_result.get(2);
						}	
						else{
							if(hmFillReasons.containsKey(keys)){//added for ML-MMOH-SCF-0465
								fill_remarks = (ArrayList)hmFillReasons.get(keys);
					//		System.err.println("DispMedicationManager.java===2455=fill_remarks=====>"+fill_remarks);
								if(fill_remarks!=null && fill_remarks.size()>0){
								code		= (String)fill_remarks.get(0);
								remarks		= (String)fill_remarks.get(1);
								}else{
									code		= "";
									remarks		= "";
								}
							}//end
							else{
								code		= "";
								remarks		= "";
							}
						}
					}//Code added for ML-BRU-SCF-0971[IN042220] --End
					pstmt_update_order_line_ph_2.setString(1,complete_order_reason);
					if(curr_disp_stage != null && curr_disp_stage.equals("AS")) { //Code disp_stage is replaced by 'curr_disp_stage' for ML-BRU-SCF-0971[IN042220]					
						pstmt_update_order_line_ph_2.setString(2,(String)tabData.get("dateTime"));
						pstmt_update_order_line_ph_2.setString(3,code);//Code added for ML-BRU-SCF-0971[IN042220]
						pstmt_update_order_line_ph_2.setString(4,remarks);//Code added for ML-BRU-SCF-0971[IN042220]
						if(autoCompletePartialDisp.equals("Y")){	// Added for JD-CRF-0179 [IN:41211]
							if(hmalloc_bms_chk_val!=null && hmalloc_bms_chk_val.get(key)!=null)// Added for ML-BRU-SCF-1187 [IN:045600] start
								pstmt_update_order_line_ph_2.setString(5,(String)hmalloc_bms_chk_val.get(key));
							else	
								pstmt_update_order_line_ph_2.setString(5,"N");// Added for ML-BRU-SCF-1187 [IN:045600] end
						}	
						else 	// Added for JD-CRF-0179 [IN:41211]
							pstmt_update_order_line_ph_2.setString(5,"");
						pstmt_update_order_line_ph_2.setString(6,((String)orderLineData.get(i+3)).trim());	
						pstmt_update_order_line_ph_2.setString(7,((String)orderLineData.get(i+4)).trim());	
					}
					else if(disp_stage.equals("V")){//Code added for ML-BRU-SCF-0971[IN042220] --Start	
						pstmt_update_order_line_ph_2.setString(2,null); // Added for ML-BRU-SCF-1187 [IN:045600]
						pstmt_update_order_line_ph_2.setString(3,((String)orderLineData.get(i+3)).trim());	
						pstmt_update_order_line_ph_2.setString(4,((String)orderLineData.get(i+4)).trim());	
					}
					else{
						pstmt_update_order_line_ph_2.setString(2,code);
						pstmt_update_order_line_ph_2.setString(3,remarks);//Code added for ML-BRU-SCF-0971[IN042220] --End
						if(!disp_stage.equals("D")){// Added for ML-BRU-SCF-1187 [IN:045600] start
							//if(autoCompletePartialDisp.equals("Y")){	// Added for JD-CRF-0179 [IN:41211]
							//if(autoCompletePartialDisp.equals("Y") && ((String)tabData.get("patient_class")).equals("OP")){	// Added for JD-CRF-0179 [IN:41211] // patient_class Added for [IN:048063]
							if(autoCompletePartialDisp.equals("Y") && (((String)tabData.get("patient_class")).equals("OP") || ((String)tabData.get("patient_class")).equals("O"))){	// Added for JD-CRF-0179 [IN:41211] // patient_class Added for [IN:048063]
								if(hmalloc_bms_chk_val!=null && hmalloc_bms_chk_val.get(key)!=null)
									pstmt_update_order_line_ph_2.setString(4,(String)hmalloc_bms_chk_val.get(key));
								else	
									pstmt_update_order_line_ph_2.setString(4,"N");
							}
							else 	// Added for JD-CRF-0179 [IN:41211]
								pstmt_update_order_line_ph_2.setString(4,"");
							pstmt_update_order_line_ph_2.setString(5,((String)orderLineData.get(i+3)).trim());	
							pstmt_update_order_line_ph_2.setString(6,((String)orderLineData.get(i+4)).trim());
						}
						else{
							pstmt_update_order_line_ph_2.setString(4,((String)orderLineData.get(i+3)).trim());	
							pstmt_update_order_line_ph_2.setString(5,((String)orderLineData.get(i+4)).trim());	
						}// Added for ML-BRU-SCF-1187 [IN:045600] end
					}
					pstmt_update_order_line_ph_2.addBatch();  
					if(curr_disp_stage != null && curr_disp_stage.equals("AS")) {//Code disp_stage is replaced by 'curr_disp_stage' for ML-BRU-SCF-0971[IN042220]					
						i	=	i+3;
					}
				}
				if(pstmt_update_order_line_ph_2 != null){
					int result[] = pstmt_update_order_line_ph_2.executeBatch();
					for (int i=0;i<result.length ;i++ ){		// A number greater than or equal to zero  indicates success
							// A number -2 indicates that command is successful but number of rows updated is unknow
							// If it won't satisfy any of the above cancel the statement and throw an exception
						if(result[i]<0  && result[i] != -2 ){
							pstmt_update_order_line_ph_2.cancel();
							connection.rollback();
							throw new EJBException("Update completeorder reason  :OR_ORDER_LINE_PH failed");
						}		
					}
				}
		//	}
			
			if(pstmt_update_order_line_ph != null){
				int result[] = pstmt_update_order_line_ph.executeBatch();
				for (int i=0;i<result.length ;i++ ){		// A number greater than or equal to zero  indicates success
						// A number -2 indicates that command is successful but number of rows updated is unknow
						// If it won't satisfy any of the above cancel the statement and throw an exception
					if(result[i]<0  && result[i] != -2 ){
						pstmt_update_order_line_ph.cancel();
						connection.rollback();
						throw new EJBException("Error: Update Patient Counseling- OR_ORDER_LINE_PH failed");
					}		
				}
			}
			if(pstmt_update_order_line_ph_1 != null){
				int result[] = pstmt_update_order_line_ph_1.executeBatch();
				for (int i=0;i<result.length ;i++ ){		// A number greater than or equal to zero  indicates success
						// A number -2 indicates that command is successful but number of rows updated is unknow
						// If it won't satisfy any of the above cancel the statement and throw an exception
					if(result[i]<0  && result[i] != -2 ){
						pstmt_update_order_line_ph_1.cancel();
						connection.rollback();
						throw new EJBException("Error:1 Update Patient Counseling- Update OR_ORDER_LINE_PH failed");
					}		
				}
			}
			try{			
				for(int i=0;i<orderLineData1.size();i=i+3){
					if(orderLineData1.get(i)!=null && ((String)orderLineData1.get(i)).equals("C")) {
						generatePDCOrder(connection, sqlMap, tabData,((String)orderLineData1.get(i+1)), ((String)orderLineData1.get(i+2)));
					}
				}
			}
			catch(Exception e){
				e.printStackTrace();
				throw new EJBException("Error: ORDER GENERATION FAILED");
			}

			if(((disp_stage.equals("F") && !filling_status.equals("A")) || (disp_stage.equals("A") && !filling_status.equals("B"))  || (disp_stage.equals("F") && ((String)tabData.get("patient_class")).equals("I"))) && !fill_list.equals("AF")){ // For updating the next collection date  //code  '|| (disp_stage.equals("F") && ((String)tabData.get("patient_class")).equals("I")' added for ML-BRU-SCF-0921[IN041388]//code  '|| (disp_stage.equals("F") && ((String)tabData.get("patient_class")).equals("I")' removed  for ML-BRU-SCF-1147[IN:045177] 
				// For updating the next collection date
				if(!dispensePeriod.get(0).toString().equals("") && !dispensePeriod.get(1).toString().equals("") && dispTMP!=null && dispTMP.size() > 0 ){
					//pstmt_update_order_line_ph_disp_prd = connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_OR_ORDER_LINE_PH_UPDATE3") ) ;	
					pstmt_update_order_line_ph_disp_prd = connection.prepareStatement("UPDATE OR_ORDER_LINE_PH SET IP_FILL_PROCESS = ?, IP_FILL_PRD_AHEAD = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?,MODIFIED_FACILITY_ID = ?  WHERE ORDER_ID = ? AND ORDER_LINE_NUM = ?");	 //code ',NEXT_FILL_DATE = SYSDATE+?' added for ML-BRU-SCF-0921[IN041388]//code ',NEXT_FILL_DATE = SYSDATE+?' removed for ML-BRU-SCF-1147[IN:045177]
					for(int i=0;i<dispTMP.size();i=i+7){
						pstmt_update_order_line_ph_disp_prd.setString(1,((String)dispensePeriod.get(0)).trim());	
						pstmt_update_order_line_ph_disp_prd.setString(2,((String)dispensePeriod.get(1)).trim());	
						pstmt_update_order_line_ph_disp_prd.setString(3,((String)tabData.get("login_by_id")).trim());
						pstmt_update_order_line_ph_disp_prd.setString(4,((String)tabData.get("login_at_ws_no")).trim());	
						pstmt_update_order_line_ph_disp_prd.setString(5,((String)tabData.get("facility_id")).trim());	
						//pstmt_update_order_line_ph_disp_prd.setString(6,((String)dispensePeriod.get(1)).trim() );//code  added for ML-BRU-SCF-0921[IN041388]	 //commented for ML-BRU-SCF-1147[IN:045177] 
						pstmt_update_order_line_ph_disp_prd.setString(6,((String)dispTMP.get(i)).trim());
						pstmt_update_order_line_ph_disp_prd.setString(7,((String)dispTMP.get(i+1)).trim());

						pstmt_update_order_line_ph_disp_prd.addBatch();					
					}
					int result[] = pstmt_update_order_line_ph_disp_prd.executeBatch();
					for (int i=0;i<result.length ;i++ ){
						// A number greater than or equal to zero  indicates success
						// A number -2 indicates that command is successful but number of rows updated is unknow
						// If it won't satisfy any of the above cancel the statement and throw an exception
						if(result[i]<0  && result[i] != -2 ){
							pstmt_update_order_line_ph_disp_prd.cancel();
							closeStatement(pstmt_update_order_line_ph_disp_prd);
							connection.rollback();
							throw new EJBException("OR_ORDER_LINE_PH FAILED While Updating dispense period");
						}		
					}
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
			throw new EJBException("Error: OR_ORDER_LINE_PH FAILED");
		}
		finally{	
			try {
			closeStatement( pstmt_update_order_line_ph) ;
			closeStatement( pstmt_update_order_line_ph_1 ) ;
			closeStatement( pstmt_update_order_line_ph_2);
			closeStatement( pstmt_update_order_line_ph_disp_prd);
			closeStatement( pstmt_select_order_line_ph);
			closeResultSet( resSet) ;
			pstmt_update_order_line_ph=null;
			pstmt_update_order_line_ph_1=null;
			resSet=null;

			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
	}

	private void insertVerifyRemarks(Connection connection, HashMap sqlMap, HashMap tabData,ArrayList orderLineData ) throws Exception {
		PreparedStatement sql_ph_disp_medication_update_verify_remarks		=	null;	
		PreparedStatement sql_ph_disp_medication_select148					=	null;
		ResultSet resSet													=	null;
		String remarks					=	"";
		HashMap verify_remarks			=	null;
		String verify_remark			=	"";
		String order_id					=	"";
		String order_line_num			=	"";
		String patient_id				=	(String)tabData.get("patient_id");
		HashMap bl_det					=	new HashMap();
		String bl_override_rason		=	"";	
		String bl_inc_exec				=	"";	
		String billing_interface_yn	    =	(String)tabData.get("billing_interface_yn");
		
		try {

			HashMap bl_reasons =(HashMap)tabData.get("BL_REASONS");
			
			sql_ph_disp_medication_update_verify_remarks = connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_UPDATE_VERIFY_REMARKS") ) ;

			//sql_ph_disp_medication_update_verify_remarks = connection.prepareStatement("UPDATE or_order_line_ph SET  verify_remarks=? , BL_INCL_EXCL_OVERRIDE_VALUE =? , BL_INCL_EXCL_OVERRIDE_REASON =?  WHERE order_id = ? AND order_line_num =? ");
			
			sql_ph_disp_medication_select148 =	connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT148") ) ;
			verify_remarks	=(HashMap)tabData.get("verify_remarks");
			for(int i=0;i<orderLineData.size();i=i+6){	//Modified for RUT-CRF-0088 [IN036978] 7->6
				sql_ph_disp_medication_select148.setString(1,((String)orderLineData.get(i+3)).trim());
				sql_ph_disp_medication_select148.setString(2,((String)orderLineData.get(i+4)).trim());
				resSet				= sql_ph_disp_medication_select148.executeQuery() ;
				if(resSet.next()) {
					remarks           =   resSet.getString("verify_remarks");
				}					 
				order_id		=(String)orderLineData.get(i+3);
				order_line_num	=(String)orderLineData.get(i+4);
				if(bl_reasons.containsKey(patient_id+order_id+order_line_num)){
					bl_det           = (HashMap)bl_reasons.get(patient_id+order_id+order_line_num);
				}
				else{
					bl_det           = new HashMap();	
				}

				verify_remark    = (String)verify_remarks.get(order_id+order_line_num);
				bl_override_rason ="";
				bl_inc_exec	      ="";
				if((verify_remark!=null&& !verify_remark.equals(""))|| (bl_det.size()>0)){

					if(verify_remark!=null&& !verify_remark.equals("")){
						if(remarks!=null&& !remarks.equals("")){						

							remarks	=	"("+(String)tabData.get("dateTime") +" -BMS -By "+(String)tabData.get("p_user_name")+" ) : "+verify_remark+"@@"+remarks;
						}
						else{
							remarks	=	"("+(String)tabData.get("dateTime")+" - By "+(String)tabData.get("p_user_name")+" ) : "+verify_remark;
						}
					}
					else{
						remarks					=	"";
					}
					if(billing_interface_yn.equals("Y")){
						if(bl_det.size()>0){
							bl_override_rason =(String)bl_det.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE");
							bl_inc_exec	      =(String)bl_det.get("BL_EXCL_INCL_IND");
						}
					}
					sql_ph_disp_medication_update_verify_remarks.setString(1,remarks);
					sql_ph_disp_medication_update_verify_remarks.setString(2,bl_inc_exec);
					sql_ph_disp_medication_update_verify_remarks.setString(3,bl_override_rason);
					sql_ph_disp_medication_update_verify_remarks.setString(4,order_id);	
					sql_ph_disp_medication_update_verify_remarks.setString(5,order_line_num);	
					sql_ph_disp_medication_update_verify_remarks.addBatch();	
				}					
			}

			if(sql_ph_disp_medication_update_verify_remarks != null)
			{
				int result[] = sql_ph_disp_medication_update_verify_remarks.executeBatch();
				for (int i=0;i<result.length ;i++ )
				{		// A number greater than or equal to zero  indicates success
						// A number -2 indicates that command is successful but number of rows updated is unknow
						// If it won't satisfy any of the above cancel the statement and throw an exception
					if(result[i]<0  && result[i] != -2 )
					{
						sql_ph_disp_medication_update_verify_remarks.cancel();
						connection.rollback();
						throw new EJBException("Error: remarks insertionin verification FAILED");
					}		
				}
			}				
		}catch(Exception e){
			e.printStackTrace();
			throw new EJBException("Error: remarks insertionin verification FAILED");
		}
		finally{	
			try {
				closeStatement( sql_ph_disp_medication_update_verify_remarks ) ;	
				closeStatement(sql_ph_disp_medication_select148);
				closeResultSet( resSet) ;
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
	}

	private void generatePDCOrder(Connection connection, HashMap sqlMap, HashMap tabData,String old_order_id, String old_line_no) throws Exception{

		PreparedStatement pstmt_select					=	null;
		PreparedStatement pstmt_select_order_line_ph	=	null;
		PreparedStatement pstmt_insert					=	null;
		ResultSet resultSet								=	null;

		String verify_yn								=	"";
		String regn_reqd_yn								=	"";
		String order_status								=	"";
		String episode_id								=	"";
		String episode_num								=	"";
		String pat_couns_ord_pract_id					=	"";
		String LanguageId								= (String)tabData.get("LanguageId");
		try {
			// derive the order status
			pstmt_select	=	connection.prepareStatement((String)sqlMap.get("SQL_PH_TDM_PRES_SELECT3"));
			pstmt_select.setString(1,(String)tabData.get("facility_id"));
			resultSet	=	pstmt_select.executeQuery();

			if(resultSet!=null && resultSet.next()){
				verify_yn	=	resultSet.getString("VERIFY_TDM_ORDER_YN");
			}
			try {
				closeResultSet( resultSet) ;
				closeStatement( pstmt_select) ;
				resultSet=null;
				pstmt_select=null;

			}catch(Exception es) {
				es.printStackTrace();
			}

			if(verify_yn!=null && verify_yn.equals("N")) {
				pstmt_select	=	connection.prepareStatement((String)sqlMap.get("SQL_PH_TDM_PRES_SELECT4"));
				resultSet	=	pstmt_select.executeQuery();
				if(resultSet!=null && resultSet.next()){
					regn_reqd_yn	= resultSet.getString("REGN_REQD_YN");
				}

				try {
					closeResultSet( resultSet) ;
					closeStatement( pstmt_select) ;
					resultSet=null;
					pstmt_select=null;

				}catch(Exception es) {
					es.printStackTrace();
				}

				if(regn_reqd_yn!=null && regn_reqd_yn.equals("Y")) {
					order_status	=	"RG";
				} 
			} else {
				order_status	=	"PO";
			}

			// get the episode id & episode num
			if(tabData.get("encounter_id")==null || ((String)tabData.get("encounter_id")).equals("null"))
				tabData.put("encounter_id","11111");

			pstmt_select	=	connection.prepareStatement((String)sqlMap.get("SQL_PH_TDM_PRES_SELECT5"));
			pstmt_select.setString(1,(String)tabData.get("encounter_id"));
			pstmt_select.setString(2,(String)tabData.get("facility_id"));
			resultSet	    =	pstmt_select.executeQuery();
			if(resultSet!=null && resultSet.next()){
				episode_id	= resultSet.getString("EPISODE_ID");
				episode_num = resultSet.getString("OP_EPISODE_VISIT_NUM");
			}
			
			closeResultSet( resultSet) ;
			 pstmt_select_order_line_ph =connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT145") ) ;
			 pstmt_select_order_line_ph.setString(1,old_order_id);
			 pstmt_select_order_line_ph.setString(2,old_line_no);
			 resultSet				= pstmt_select_order_line_ph.executeQuery() ;
			 if(resultSet.next()) {
				pat_couns_ord_pract_id=resultSet.getString("pat_couns_ord_pract_id") == null ? "":resultSet.getString("pat_couns_ord_pract_id");
			 }
			 closeResultSet( resultSet) ;
			// OR_ORDER 
			int count				=	0;
			String order_id			=	"";
			String patient_class	=	"";
			String ord_auth_reqd_yn	=   "N";

			if( ((String)tabData.get("patient_class")).equals("O")) {
				patient_class		=	"OP";
			} 
			else {
				patient_class		=	"IP";
			}

			pstmt_insert	= connection.prepareStatement((String)sqlMap.get("SQL_PH_IVPRESCRIPTION_INSERT1"));

			order_id		= genOrderID(connection,(String)tabData.get("patient_class"), ((String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT37")), (String)tabData.get("facility_id") ); //thrid parameter for facility added for IN[032925]

			pstmt_insert.setString(++count, order_id);				// ORDER_ID
			pstmt_insert.setString(++count, "PDC");			// ORDER_TYPE_CODE
			pstmt_insert.setString(++count, "PH");					//ORDER_CATEGORY
			pstmt_insert.setString(++count, "PH");					//CONTR_SYS_ID
			pstmt_insert.setString(++count, (String)tabData.get("patient_id"));			//PATIENT_ID
			pstmt_insert.setString(++count, patient_class);			//PATIENT_CLASS
			pstmt_insert.setString(++count, (String)tabData.get("ordering_facility_id"));		//ORDERING_FACILITY_ID
			pstmt_insert.setString(++count, (String)tabData.get("encounter_id"));			//ENCOUNTER_ID
			pstmt_insert.setString(++count, episode_id);			//EPISODE_ID
			pstmt_insert.setString(++count, episode_num);					//EPISODE_VISIT_NUM
			pstmt_insert.setString(++count, (String)tabData.get("source_type"));			//SOURCE_TYPE
			pstmt_insert.setString(++count, (String)tabData.get("source_code"));			//SOURCE_CODE
			pstmt_insert.setString(++count, "");					//DISCHARGE_IND
			pstmt_insert.setString(++count, (String)tabData.get("dateTime"));			//ORD_DATE_TIME
			//pstmt_insert.setString(++count, (String)tabData.get("performing_pract_id"));			//ORD_PRACT_ID
			pstmt_insert.setString(++count, pat_couns_ord_pract_id);			//ORD_PRACT_ID
			pstmt_insert.setString(++count, "R");		//PRIORITY
			if(order_status.equals("PO")){
				ord_auth_reqd_yn="Y";
			}else{
				ord_auth_reqd_yn="N";
			}
			pstmt_insert.setString(++count, ord_auth_reqd_yn);				//ORD_AUTH_REQD_YN
			pstmt_insert.setString(++count, "");					//ORD_AUTH_LEVEL
			//pstmt_insert.setString(++count, (String)tabData.get("performing_pract_id"));			//ORD_AUTH_BY_PRACT_ID
			pstmt_insert.setString(++count, pat_couns_ord_pract_id);
			pstmt_insert.setString(++count, (String)tabData.get("dateTime"));			//ORD_AUTH_DATE_TIME
			pstmt_insert.setString(++count, "N");				//ORD_APPR_REQD_YN
			pstmt_insert.setString(++count, "");					//ORD_APPR_BY_USER_ID
			pstmt_insert.setString(++count, null);				//ORD_APPR_DATE_TIME
			pstmt_insert.setString(++count, "N");				//ORD_COSIGN_REQD_YN
			pstmt_insert.setString(++count, "");					//ORD_COSIGN_LEVEL
			pstmt_insert.setString(++count, "");					//ORD_COSIGN_BY_PRACT_ID
			pstmt_insert.setString(++count, null);				//ORD_COSIGN_DATE_TIME
			pstmt_insert.setString(++count, null);				//ORD_PRINT_DATE_TIME
			pstmt_insert.setString(++count, "N");				//BILL_YN
			pstmt_insert.setString(++count, "CO");				//CONT_ORDER_IND
			pstmt_insert.setString(++count, (String)tabData.get("facility_id"));	//PERFORMING_FACILITY_ID
			pstmt_insert.setString(++count, "PH");				//PERFORMING_SYS_ID
			pstmt_insert.setString(++count, "");		//PERFORMING_DEPTLOC_TYPE
			pstmt_insert.setString(++count, "");		//PERFORMING_DEPTLOC_CODE
			pstmt_insert.setString(++count, "");			//PERFORMING_PRACT_ID
			pstmt_insert.setString(++count, "N");				//RESULT_AUTH_REQD_YN
			pstmt_insert.setString(++count, "Y");				//CHILD_ORDER_YN
			pstmt_insert.setString(++count, old_order_id);					//PARENT_ORDER_ID
			pstmt_insert.setString(++count, "N");				//ORDER_SET_YN
			pstmt_insert.setString(++count, "");					//ORDER_SET_ID
			pstmt_insert.setString(++count, "");					//IV_PREP_YN (continuous)
			pstmt_insert.setString(++count, "");					//ORDER_FIELDS_DISPLAY_TEXT
			pstmt_insert.setString(++count, order_status);				//ORDER_STATUS
			pstmt_insert.setString(++count, "");					//RESULT_STATUS
			pstmt_insert.setString(++count, (String)tabData.get("login_by_id"));		//ADDED_BY_ID
			pstmt_insert.setString(++count, (String)tabData.get("login_at_ws_no"));		//ADDED_AT_WS_NO
			pstmt_insert.setString(++count, (String)tabData.get("facility_id"));	//ADDED_FACILITY_ID
			pstmt_insert.setString(++count, (String)tabData.get("login_by_id"));		//MODIFIED_BY_ID
			pstmt_insert.setString(++count, (String)tabData.get("login_at_ws_no"));		//MODIFIED_AT_WS_NO
			pstmt_insert.setString(++count, (String)tabData.get("facility_id"));	//MODIFIED_FACILITY_ID
			pstmt_insert.setString(++count, "N");				//ORD_CONSENT_REQD_YN
			pstmt_insert.setString(++count, "");					//ORD_CONSENT_BY_ID
			pstmt_insert.setString(++count, null);				//ORD_CONSENT_BY_DATE_TIME
			pstmt_insert.setString(++count, "");				//CAN_REASON
			pstmt_insert.setString(++count, "");                 //trn_ref_id
			pstmt_insert.executeUpdate();
			closeStatement(pstmt_insert);

			String drug_desc	=	"";
			String drug_code	=	"";

			pstmt_select		= connection.prepareStatement((String)sqlMap.get("SQL_PH_TDM_PRES_SELECT6"));
			pstmt_select.setString(1,old_order_id);
			pstmt_select.setString(2,old_line_no);
			pstmt_select.setString(3,LanguageId);
			
			resultSet	=	pstmt_select.executeQuery();
			if(resultSet!=null && resultSet.next()){
				drug_code	= resultSet.getString("ORDER_CATALOG_CODE");
				drug_desc	= resultSet.getString("DRUG_DESC");
			}

		// OR_ORDER_LINE 
			String short_desc	=	"";
			//drug_desc			=	"PDC for "+drug_desc;
			drug_desc			=	drug_desc;
			pstmt_insert		= connection.prepareStatement((String)sqlMap.get("SQL_PH_PRESCRIPTION_INSERT2"));

			if( (drug_desc).length() > 39) {
				short_desc	=	(drug_desc).substring(0,39);
			} 
			else {
				short_desc	=	drug_desc;
			}
			pstmt_insert.setString(1, order_id);
			pstmt_insert.setString(2, "1");
			pstmt_insert.setString(3, drug_code);
			pstmt_insert.setString(4, short_desc);
			pstmt_insert.setString(5, short_desc);
			pstmt_insert.setString(6, "A");
			pstmt_insert.setString(7, "PDC");
			pstmt_insert.setString(8, "PH");
			pstmt_insert.setString(9, (String)tabData.get("dateTime") );
			pstmt_insert.setString(10, "R");
			pstmt_insert.setString(11, "N");
			pstmt_insert.setString(12, "");
			pstmt_insert.setString(13, "N");
			pstmt_insert.setString(14, "N");
			pstmt_insert.setString(15,(String)tabData.get("dateTime") );
			pstmt_insert.setString(16, "");
			pstmt_insert.setString(17, "");
			pstmt_insert.setString(18, "");
			pstmt_insert.setString(19, "");
			pstmt_insert.setString(20, "");
			pstmt_insert.setString(21, "");
			pstmt_insert.setString(22, "");
			pstmt_insert.setString(23, "");
			pstmt_insert.setString(24, "");
			pstmt_insert.setString(25, null);
			pstmt_insert.setString(26, "");
			pstmt_insert.setString(27, null);
			pstmt_insert.setString(28, "");
			pstmt_insert.setString(29, "");
			pstmt_insert.setString(30, "N");
			pstmt_insert.setString(31, null);
			pstmt_insert.setString(32, "");
			pstmt_insert.setString(33, "Y");
			pstmt_insert.setString(34, "N");
			pstmt_insert.setString(35, "N");
			pstmt_insert.setString(36, "CO");
			pstmt_insert.setString(37, "N");
			pstmt_insert.setString(38, "");
			pstmt_insert.setString(39, "N");
			pstmt_insert.setString(40, "");
			pstmt_insert.setString(41, "");
			pstmt_insert.setString(42, "");
			pstmt_insert.setString(43, "");
			//pstmt_insert.setString(44, (String)tabData.get("performing_pract_id"));
			pstmt_insert.setString(44,pat_couns_ord_pract_id);
			pstmt_insert.setString(45, null);
			pstmt_insert.setString(46, "");
			pstmt_insert.setString(47, null);
			pstmt_insert.setString(48, "");
			pstmt_insert.setString(49, null);
			pstmt_insert.setString(50, "");
			pstmt_insert.setString(51, null);
			pstmt_insert.setString(52, "");
			pstmt_insert.setString(53, null);
			pstmt_insert.setString(54, "");
			pstmt_insert.setString(55, null);
			pstmt_insert.setString(56, "");
			pstmt_insert.setString(57, "");
			pstmt_insert.setString(58, order_status); // line status
			pstmt_insert.setString(59, "");
			pstmt_insert.setString(60, (String)tabData.get("login_by_id"));
			pstmt_insert.setString(61, (String)tabData.get("login_at_ws_no"));
			pstmt_insert.setString(62, (String)tabData.get("facility_id"));
			pstmt_insert.setString(63, (String)tabData.get("login_by_id"));
			pstmt_insert.setString(64, (String)tabData.get("login_at_ws_no"));
			pstmt_insert.setString(65, (String)tabData.get("facility_id"));
			pstmt_insert.setString(66, "N");
			pstmt_insert.setString(67, "");
			pstmt_insert.setString(68, short_desc);
			pstmt_insert.setString(69, short_desc);
			pstmt_insert.setString(70, "N");
			pstmt_insert.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
			throw new EJBException("Error: PDC generation FAILED");
		}finally{	
			try {
				closeStatement( pstmt_select ) ;
				closeStatement( pstmt_insert ) ;
				closeStatement( pstmt_select_order_line_ph ) ;
				closeResultSet( resultSet );
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
	}

	private String genOrderID(Connection connection, String patient_class, String SQL_PH_PRESCRIPTION_SELECT37, String login_facility_id) { //thrid parameter for facility added for IN[032925]
		if(patient_class.equals("O")) {
			patient_class	=	"OP";
		} else {
			patient_class	=	"IP";
		}

		if(!patient_class.trim().equals("IP") && patient_class.trim().equals("EM")) {
			patient_class = "OP";
		}

		String order_id				= "";
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		try{
			sql_query           = SQL_PH_PRESCRIPTION_SELECT37;
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,"PH");
			pstmt.setString(2,patient_class);
			pstmt.setString(3, login_facility_id); //thrid parameter for facility added for IN[032925]
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next())	{
				order_id	=((String)resultSet.getString("order_id"));
			}
		}catch ( Exception e ) {
                e.printStackTrace() ;
		} finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
					resultSet=null;
					pstmt	 =null;


                    }catch(Exception es){
						es.printStackTrace();
					}
           }
		return order_id;
	}
	// Order line update 
	private HashMap updateOrOrderLine(Connection connection, HashMap sqlMap,ArrayList orderLineData, HashMap tabData, String update_string) throws Exception{
		HashMap orderUpdate						=	new HashMap();
		ArrayList  ord_det						=	new ArrayList();
	//	String result_status					=	"";
		PreparedStatement pstmt_res_status		=	null;
		PreparedStatement pstmt_res_status1		=	null;
		ResultSet resSet						=	null;
		ResultSet resSet1						=	null;
		String result_line_status				=   "";
		String result_Status_Flag				=	"";
		String tmp_update_string				=	"";
		String hold_reason_desc					=   "";
		int j									=   0;  
		ArrayList resultStatusFlags				= (ArrayList)tabData.get("resultStatusFlags");	
		HashMap alloc_bms_chk					= (HashMap)tabData.get("alloc_bms_chk");
		PreparedStatement pstmt_update_order_line	= null;
		PreparedStatement brought_by_pat_sql =null;
		String patient_brought_medn_yn ="";
		try {
			pstmt_update_order_line = connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_ORDER_LINE_UPDATE") ) ;	
			ArrayList arr_list_values = null;
			//RESULT_LINE_STATUS
			pstmt_res_status	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_ORDER_LINE_SELECT") ) ;
			pstmt_res_status1	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_ORDER_LINE_SELECT1") ) ;
			brought_by_pat_sql  =connection.prepareStatement("SELECT PATIENT_BROUGHT_MEDICATION_YN FROM OR_ORDER_LINE_PH WHERE ORDER_ID=? AND ORDER_LINE_NUM=?");//added for TH-KW-CRF-0002
			boolean verify_pat_brought_medn = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","VERIFY_PAT_BROUGHT_MEDN");//added for TH-KW-CRF-0002

			
			for(int i=0;i<orderLineData.size();i=i+6){	//Modified for RUT-CRF-0088 [IN036978] 7->6
				if(!orderUpdate.containsKey((String)orderLineData.get(i+3))){
					arr_list_values = new ArrayList();
				}
				tmp_update_string	=	update_string;

				//pstmt_res_status	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_ORDER_LINE_SELECT") ) ;
				pstmt_res_status.setString(1,((String)orderLineData.get(i+3)).trim());				//OR_ORDER
				pstmt_res_status.setString(2,((String)orderLineData.get(i+4)).trim());

				/*==CODE ADDED TO COMPLETE ORDER WHEN COMPLETE ORDER CHECK BOX IS SELECTED==on 11/27/2004=*/
					
				if(((String)tabData.get("disp_stage")).equals("AS")) {					     
					if(((String)orderLineData.get(i+8)).trim().equals("Y")) {	
						tmp_update_string	=	"DF"; 
					} 
				}
				else {
					if(((String)orderLineData.get(i+5))!=null){
						if(((String)orderLineData.get(i+5)).trim().equals("Y"))	 {	
							  tmp_update_string	=	"DF"; 
						 } 
					}
				}

			System.err.println("disp_stage@@@==="+tabData.get("disp_stage")+"verify_pat_brought_medn===="+verify_pat_brought_medn);
	if(tabData.get("disp_stage").toString().equals("V")){//Adding start for TH-KW-CRF-0002
	            if(verify_pat_brought_medn){
		                 brought_by_pat_sql.setString(1,((String)orderLineData.get(i+3)).trim());//OR_ORDER					
						 brought_by_pat_sql.setString(2,((String)orderLineData.get(i+4)).trim()); //OR_ORDER_LINE
						 resSet		= brought_by_pat_sql.executeQuery() ;
						 if(resSet.next()) {
							  patient_brought_medn_yn =(String)resSet.getString("PATIENT_BROUGHT_MEDICATION_YN")==null?"N":(String)resSet.getString("PATIENT_BROUGHT_MEDICATION_YN");
						 }
               System.err.println("patient_brought_medn_yn@@@@===="+patient_brought_medn_yn);
						 if(patient_brought_medn_yn.equals("Y"))
							 tmp_update_string = "DF";
					 arr_list_values.add(tmp_update_string);
	             }
				// closeResultSet( resSet ) ;
				// closeStatement( brought_by_pat_sql );
	}//Adding end for TH-KW-CRF-0002
	System.err.println("tmp_update_string@@@==="+tmp_update_string);
			   /*==================endshere=================================================*/

				if(((String)orderLineData.get(i)).equals("Y")){				// If prescription is on hold.
				System.err.println("=======inside@@@hold=======");
					hold_reason_desc    ="";
					pstmt_update_order_line.setString(1,"HD");							//ORDER_LINE_STATUS       
					pstmt_update_order_line.setString(2,(String)orderLineData.get(i+1));			//HOLD_PRACT_ID           
					pstmt_update_order_line.setString(3,((String)tabData.get("dateTime")).trim());	//HOLD_DATE_TIME          
					pstmt_update_order_line.setString(4,"HD");							//LAST_ACTION_TYPE  
					arr_list_values.add("HD");
					pstmt_res_status.setString(1,((String)orderLineData.get(i+3)).trim());//OR_ORDER					
					pstmt_res_status.setString(2,((String)orderLineData.get(i+4)).trim()); //OR_ORDER_LINE
					resSet		= pstmt_res_status.executeQuery() ;		
					
					if(resSet.next()) {
						result_line_status	=	(String)resSet.getString("ORDER_LINE_STATUS");
						hold_reason_desc    =   (String)resSet.getString("LAST_ACTION_REASON_DESC");
					}
					closeResultSet( resSet ) ;

					if(result_line_status.equals("HD")){
						 pstmt_res_status1.setString(1,((String)orderLineData.get(i+3)).trim());//OR_ORDER					
						 pstmt_res_status1.setString(2,((String)orderLineData.get(i+4)).trim()); //OR_ORDER_LINE
						 resSet1		= pstmt_res_status1.executeQuery() ;		
						
						if(resSet1.next()) {
							result_line_status =(String)resSet1.getString("RESULT_LINE_STATUS");
						}
						closeResultSet( resSet1 ) ; //common-icn-0029
					}
					else{
						hold_reason_desc   =((String)orderLineData.get(i+2)).trim();
					}

				 // pstmt_update_order_line.setString(5,((String)orderLineData.get(i+2)).trim());			//LAST_ACTION_REASON_DESC 
					pstmt_update_order_line.setString(5,hold_reason_desc);			//LAST_ACTION_REASON_DESC 
					pstmt_update_order_line.setString(6,hold_reason_desc);			//CAN_LINE_REASON added newly for the ML-BRU-SCF-0184 by SureshKumar T on 07/06/2012
				}
				else if(((String)orderLineData.get(i)).equals("N")){		// If prescription is Allocated.
					if(((String)tabData.get("disp_stage")).equals("AS")) {
					   if(((String)orderLineData.get(i+8)).trim().equals("N")) {
							tmp_update_string	=	((String)orderLineData.get(i+5));
							if(tmp_update_string.equals("DP")){
								IR_FLAG.put("IR_FLAG_VALUE","TRUE");
								IR_FLAG.put("order_id",((String)orderLineData.get(i+3)));
								IR_FLAG.put("order_line_no",((String)orderLineData.get(i+4)));
								ord_det.add(((String)orderLineData.get(i+3)).trim());
								ord_det.add(((String)orderLineData.get(i+4)).trim());
							}	
						}
						else{
							tmp_update_string	=	"DF";
						}	
					} 

					pstmt_update_order_line.setString(1,tmp_update_string);			//ORDER_LINE_STATUS
					pstmt_update_order_line.setString(2,"");						//HOLD_PRACT_ID
					pstmt_update_order_line.setString(3,"");						//HOLD_DATE_TIME
					pstmt_update_order_line.setString(4,"");						//LAST_ACTION_TYPE
					pstmt_update_order_line.setString(5,"");						//LAST_ACTION_REASON_DESC 
					pstmt_update_order_line.setString(6,"");						//CAN_LINE_REASON added newly for the ML-BRU-SCF-0184 by SureshKumar T on 07/06/2012
					arr_list_values.add(tmp_update_string);
				}
				else if(((String)orderLineData.get(i)).equals("NN")){		// If prescription is not on hold,allocated.
				System.out.println("3308"+(String)orderLineData.get(i));
				if(resultStatusFlags!=null) {
					System.out.println("3310");
						if(j<resultStatusFlags.size()) { System.out.println("3311");
							result_Status_Flag= (String)resultStatusFlags.get(j);
							if(result_Status_Flag.equals("N")) {
								System.out.println("3314");
								if(((String)tabData.get("disp_stage")).equals("AS")) {	
									System.out.println("3316");
									if(((String)orderLineData.get(i+8)).trim().equals("Y")) {   
										System.out.println("3318");
										tmp_update_string	=	"DF";
									} 
									else {	
										System.out.println("3322");
										pstmt_res_status.setString(1,((String)orderLineData.get(i+3)).trim());//OR_ORDER		
										pstmt_res_status.setString(2,((String)orderLineData.get(i+4)).trim()); //OR_ORDER_LINE
										resSet		= pstmt_res_status.executeQuery() ;		
					
										if(resSet.next()) {
											tmp_update_string	=	(String)resSet.getString("ORDER_LINE_STATUS");
											System.out.println("3329"+tmp_update_string);
										}
										closeResultSet(resSet);
										//tmp_update_string	=	"OS";
										System.out.println("3332"+tmp_update_string);
									}
								}
								else{
									System.out.println("3337");
									if(((String)orderLineData.get(i+5))!=null){System.out.println("3337"+(String)orderLineData.get(i+5));
									   if(((String)orderLineData.get(i+5)).trim().equals("Y")) {		  
										   System.out.println("3340");
										   tmp_update_string	=	"DF";
									   } 
									   else {
										  /* //SKR-SCF-1652
										   pstmt_res_status1.setString(1,((String)orderLineData.get(i+3)).trim());//OR_ORDER
										   System.out.println("3337 or_order"+(String)orderLineData.get(i+3));					
											 pstmt_res_status1.setString(2,((String)orderLineData.get(i+4)).trim()); //OR_ORDER_LINE
											 System.out.println("3339 or_order"+(String)orderLineData.get(i+4));
											 resSet1		= pstmt_res_status1.executeQuery() ;		
											
											if(resSet1.next()) {
												result_line_status =(String)resSet1.getString("RESULT_LINE_STATUS");
												System.out.println(tmp_update_string+"3344"+result_line_status);
											}
											closeResultSet( resSet1 ) ; //SKR-SCF-1652*/
											
											//tmp_update_string	=	"OS";
											pstmt_res_status.setString(1,((String)orderLineData.get(i+3)).trim());//OR_ORDER					
											pstmt_res_status.setString(2,((String)orderLineData.get(i+4)).trim()); //OR_ORDER_LINE
											resSet		= pstmt_res_status.executeQuery() ;		

											if(resSet.next()) {
												tmp_update_string	=	resSet.getString("ORDER_LINE_STATUS")==null?"":(String)resSet.getString("ORDER_LINE_STATUS");//commented for SKR-SCF-1310 and uncommented for MMS-KH-SCF-0067
												System.out.println("before"+tmp_update_string+"3355"+result_line_status);
												if(tmp_update_string.equals("HD"))  // added for MMS-KH-SCF-0067
												tmp_update_string	=	"OS";//added for SKR-SCF-1310
                        //tmp_update_string	=	result_line_status;//added for SKR-SCF-1310	, modified for SKR-SCF-1652 												
												System.out.println(tmp_update_string+"3352"+result_line_status);
											}
											closeResultSet(resSet);
										}
									}
								}
							}
							else{  System.out.println("3371");
								 pstmt_res_status1.setString(1,((String)orderLineData.get(i+3)).trim());//OR_ORDER					
								 pstmt_res_status1.setString(2,((String)orderLineData.get(i+4)).trim()); //OR_ORDER_LINE
								 resSet1		= pstmt_res_status1.executeQuery() ;		
							
								if(resSet1.next()) {
									tmp_update_string =(String)resSet1.getString("RESULT_LINE_STATUS");
									  System.out.println("3378"+tmp_update_string);
								}
								closeResultSet( resSet1 ) ; //common-icn-0029
								result_line_status=tmp_update_string;//added for skr-scf-1687
								System.out.println("3368"+result_line_status);
							}					 
							j=j+1;
						}
					 }

	// FOR alloc_bms_chk ---  to set order line status  ------- charles
					if(alloc_bms_chk!= null && alloc_bms_chk.size()>0){
						  System.out.println("3389");
						if(alloc_bms_chk.get((String)orderLineData.get(i+3)+(String)orderLineData.get(i+4)).equals("Y")){
							if(tabData.get("disp_stage")!=null){
								if(tabData.get("disp_stage").toString().equals("AS"))//if block Added for MO-GN-5434 [IN:043669]
									tmp_update_string = "DP";						//Added for MO-GN-5434 [IN:043669]
								else if(tabData.get("disp_stage").toString().equals("F"))
									tmp_update_string = "IP";
								else
									tmp_update_string = "AL";
							}
							  System.out.println("3399"+tmp_update_string);
						}
					}
	// --- end -----------
					arr_list_values.add(tmp_update_string);
					pstmt_update_order_line.setString(1,tmp_update_string);												//ORDER_LINE_STATUS       
					pstmt_update_order_line.setString(2,"");												//HOLD_PRACT_ID           
					pstmt_update_order_line.setString(3,"");												//HOLD_DATE_TIME          
					pstmt_update_order_line.setString(4,"");												//LAST_ACTION_TYPE        
					pstmt_update_order_line.setString(5,"");
					pstmt_update_order_line.setString(6,"");                // CAN_LINE_REASON added newly for the ML-BRU-SCF-0184 by SureshKumar T on 07/06/2012
				
					//continue;
				}
				pstmt_update_order_line.setString(7,(String)tabData.get("login_by_id"));		// modified id
				pstmt_update_order_line.setString(8,(String)tabData.get("facility_id"));		// modified facility
				pstmt_update_order_line.setString(9,(String)tabData.get("login_at_ws_no"));		// modified work station
				pstmt_update_order_line.setString(10,result_line_status.trim());
				pstmt_update_order_line.setString(11,((String)orderLineData.get(i+3)).trim());	//ORDER_ID
				pstmt_update_order_line.setString(12,((String)orderLineData.get(i+4)).trim());	//ORDER_LINE_NUM
				pstmt_update_order_line.addBatch();
				if(((String)tabData.get("disp_stage")).equals("AS")) {
					i	=	i+3;
					orderUpdate.put((String)orderLineData.get(i),arr_list_values);
				}
				else{
					orderUpdate.put((String)orderLineData.get(i+3),arr_list_values);
				}
			}
			if(((String)tabData.get("disp_stage")).equals("AS")) { 
				if(ord_det.size()>0 ){				
					IR_FLAG.put("ORDER_DETAILS",ord_det);
				}
			}
			int result1[]=pstmt_update_order_line.executeBatch();	
			
			for (int i=0;i<result1.length ;i++ ){
				if(result1[i]<0  && result1[i] != -2 ){
					pstmt_update_order_line.cancel();
					connection.rollback();
					throw new EJBException("Order Line Update Failed");
				}		
			}
		}
		catch(Exception e){
			e.printStackTrace();
			throw new EJBException("Error: OR_ORDER_LINE UPDATION");
		}
		finally{	
			try {
				closeStatement( pstmt_update_order_line ) ;
				closeStatement( pstmt_res_status ) ;
				closeStatement( pstmt_res_status1 );
				closeResultSet( resSet ) ;
				closeResultSet( resSet1 ) ;
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
		return orderUpdate;
	}

// check the order line status
	private HashMap getOrderLineStatus(Connection connection, HashMap sqlMap,ArrayList orderLineData,HashMap tabData) throws Exception{
		PreparedStatement pstmt_ord_line_status		=	null;
		ResultSet resultSet							=	null;
		HashMap line_status							=	new HashMap();
		try {
			pstmt_ord_line_status		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT57") ) ;
			
			for(int i=0;i<orderLineData.size();i=i+6){	//Modified for RUT-CRF-0088 [IN036978] 7->6
				pstmt_ord_line_status.setString(1,((String)orderLineData.get(i+3)).trim());
				pstmt_ord_line_status.setString(2,((String)orderLineData.get(i+4)).trim());
				resultSet = pstmt_ord_line_status.executeQuery() ;
				if ( resultSet != null && resultSet.next() ) {
					line_status.put(((String)orderLineData.get(i+3)).trim()+((String)orderLineData.get(i+4)).trim(),resultSet.getString("ORDER_LINE_STATUS"));
				}
				
				if(((String)tabData.get("disp_stage")).equals("AS")) {
						i	=	i+3;
				}

			}
		}catch(Exception e){
				e.printStackTrace();
				throw new EJBException("Error: OR_ORDER_LINE_STATUS UPDATION");
		}finally{	
				try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt_ord_line_status ) ;
				pstmt_ord_line_status=null;
				resultSet=null;
				}
				catch(Exception es) { 
					es.printStackTrace();
				}
		}
	return line_status;
	}

// Previous Doc No, Doc Type, Srl No
	private HashMap getDocValues(Connection connection, HashMap sqlMap,ArrayList orderLineData,ArrayList dispTMP,HashMap tabData) throws Exception{
		HashMap st_doc_vals								=	new HashMap();
		PreparedStatement pstmt_disp_hdr_tmp_docno		=	null;
		PreparedStatement pstmt_select_disp_tmp			=	null;
		ResultSet resultSet								=	null;
		HashMap	prev_doc_no								=	new HashMap();
		HashMap prev_doc_type							=	new HashMap();
		HashMap srl_no									=	new HashMap();
		String tmp_srl_no								=	"";
		String tmp_disp_drug_code						=	"";
		String order_id="", order_line_num = "", bl_doc_no="", bl_doc_srl_no="", deliver_checked="", bl_doc_type_code="", bl_doc_key=""; // bl variables Added for  [IN:043100], MMS-SCF-0251 [IN:046741]
		HashMap deliverbox_checked = new HashMap();  //Added for  [IN:043100]
		String fill_list = tabData.get("fill_list")==null?"":(String)tabData.get("fill_list");
		String IV_PREP_YN = (String)tabData.get("IV_PREP");//added for SKR-SCF-1319 
		try {
				if(((String)tabData.get("patient_class")).equals("O")){
					pstmt_disp_hdr_tmp_docno	=	connection.prepareStatement( "SELECT DOC_NO,DOC_TYPE FROM  PH_DISP_HDR_TMP a, PH_DISP_dtl_TMP  b  WHERE b.order_id = a.order_id and a.disp_tmp_no = b.disp_tmp_no and b.ORDER_ID=? and b.order_line_no = ?") ;
				}
					//added for SKR-SCF-1319 
				else{
					if(IV_PREP_YN!=null && (IV_PREP_YN.equals("1") || IV_PREP_YN.equals("3")) ){ 
						
						pstmt_disp_hdr_tmp_docno	=	connection.prepareStatement( "SELECT DOC_NO,DOC_TYPE FROM  PH_DISP_HDR_TMP a, PH_DISP_dtl_TMP  b  WHERE b.order_id = a.order_id and a.disp_tmp_no = b.disp_tmp_no and b.ORDER_ID=? and b.order_line_no = ?") ;
					}else{
						pstmt_disp_hdr_tmp_docno	=	connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT58") ) ;
					}
					
				}//added for SKR-SCF-1319 END
					
				//pstmt_select_disp_tmp		=	connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT67") );
				pstmt_select_disp_tmp		=	connection.prepareStatement("SELECT DOC_SRL_NO,DISP_DRUG_CODE FROM PH_DISP_DTL_TMP WHERE ORDER_ID=? AND ORDER_LINE_NO=?" );
			
				//previous doc no and doc type
				for(int i=0;i<orderLineData.size();i=i+6){	//Modified for RUT-CRF-0088 [IN036978] 7->6
					deliverbox_checked.put(orderLineData.get(i+3)+"_"+orderLineData.get(i+4),(String)orderLineData.get(i)); //Added for  [IN:043100]
					order_id = ((String)orderLineData.get(i+3)).trim();
					order_line_num = ((String)orderLineData.get(i+4)).trim();
					pstmt_disp_hdr_tmp_docno.setString(1,order_id);
					if(((String)tabData.get("patient_class")).equals("O"))
						pstmt_disp_hdr_tmp_docno.setString(2,order_line_num);
					//added for SKR-SCF-1319 START
					if(((String)tabData.get("patient_class")).equals("I")){
						if(IV_PREP_YN!=null && (IV_PREP_YN.equals("1") || IV_PREP_YN.equals("3"))){
							pstmt_disp_hdr_tmp_docno.setString(2,order_line_num);
						}
					}
					//added for SKR-SCF-1319 END
					
					resultSet	= pstmt_disp_hdr_tmp_docno.executeQuery() ;
					if (resultSet.next() ) {
						if(resultSet.getString("DOC_NO")!=null){
							prev_doc_no.put(order_id+order_line_num,resultSet.getString("DOC_NO"));
						}
						if(resultSet.getString("DOC_TYPE")!=null){
							prev_doc_type.put(order_id,resultSet.getString("DOC_TYPE"));
						}
					}

					if(((String)tabData.get("disp_stage")).equals("AS")) {
						i	=	i+3;
					}
				}
				try {
					closeResultSet( resultSet) ;
					closeStatement( pstmt_disp_hdr_tmp_docno) ;
					pstmt_disp_hdr_tmp_docno=null;
					resultSet=null;
				}
				catch(Exception es) {
					es.printStackTrace();
				}
				// previous srl no
				resultSet	=	null;
				for(int i=0;i<dispTMP.size();i+=7){
					pstmt_select_disp_tmp.setString(1,((String)dispTMP.get(i)).trim());
					//pstmt_select_disp_tmp.setString(2,((String)dispTMP.get(i+3)).trim()); //charles
					pstmt_select_disp_tmp.setString(2,((String)dispTMP.get(i+1)).trim());
					resultSet	=	pstmt_select_disp_tmp.executeQuery();
					if(resultSet!=null && resultSet.next()){
						while(true){
							if(resultSet.getString("DOC_SRL_NO")!=null && !(resultSet.getString("DOC_SRL_NO").equals(""))){
								tmp_srl_no			=	resultSet.getString("DOC_SRL_NO");
								tmp_disp_drug_code	=	resultSet.getString("DISP_DRUG_CODE");
								srl_no.put(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim(),tmp_srl_no);
								srl_no.put(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim()+"_drug",tmp_disp_drug_code);
								deliver_checked = (String)deliverbox_checked.get(dispTMP.get(i)+"_"+dispTMP.get(i+1));//Added for  [IN:043100] -Start 
								if(deliver_checked==null || deliver_checked.equals(""))
									deliver_checked = "NN";
								if(!deliver_checked.equals("NN") || fill_list.equals("DWF")){
									bl_doc_type_code =(String) prev_doc_type.get(((String)dispTMP.get(i)).trim()) ; //Added for MMS-SCF-0251 [IN:046741]
									bl_doc_no =(String) prev_doc_no.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim());
									bl_doc_key = bl_doc_type_code +"-"+bl_doc_no; //added for MMS-SCF-0251 [IN:046741]
									if(hmBLDocSrlNo.containsKey(bl_doc_key)){
										bl_doc_srl_no = (String) hmBLDocSrlNo.get(bl_doc_key);
										if(!bl_doc_srl_no .equals(""))
											bl_doc_srl_no+=","+tmp_srl_no;
									}
									else
										bl_doc_srl_no = tmp_srl_no;
									hmBLDocSrlNo.put(bl_doc_key , bl_doc_srl_no);
								} //Added for  [IN:043100] -End
								if(resultSet.next())
									i+=7;
								else
									break;
							}
						}
					}
				}
				try {
					closeResultSet( resultSet) ;
					closeStatement( pstmt_select_disp_tmp) ;
					pstmt_select_disp_tmp=null;
					resultSet=null;
				}
				catch(Exception es) {
					es.printStackTrace();
				}
				st_doc_vals.put("doc_no",prev_doc_no);
				st_doc_vals.put("doc_type",prev_doc_type);
				st_doc_vals.put("srl_no",srl_no);
		}
		catch(Exception e){
			e.printStackTrace();
			throw new EJBException(e);			
		}
		finally{	
				try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt_disp_hdr_tmp_docno ) ;
				closeStatement( pstmt_select_disp_tmp ) ;
				resultSet=null;
				pstmt_disp_hdr_tmp_docno=null;
				pstmt_select_disp_tmp=null;
				}
				catch(Exception es) { 
					es.printStackTrace();
				}
		}
		return st_doc_vals;
	}
	// delete tmp tables
	private void deleteTMPTables(Connection connection, HashMap sqlMap,ArrayList orderLineData,HashMap tabData) throws Exception{
		PreparedStatement pstmt_disp_hdr_count		=	null;
		PreparedStatement pstmt_disp_dtl_count		=	null; //Added for AAKH-SCF-0504
		PreparedStatement pstmt_disp_hdr_delete		=	null;
		PreparedStatement pstmt_disp_dtl_delete		=	null;
		PreparedStatement pstmt_disp_batch_delete	=	null;
		//PreparedStatement pstmt_disp_label_delete	=	null; // Added for Bru-HIMS-CRF-414 [IN:045554] Unused local variable INC63877 
		//PreparedStatement pstmt_disp_dtl_select	=	null; // Added for Bru-HIMS-CRF-414 [IN:045554] Unused local variable INC63877 
		ResultSet resultSet							=	null;
		//ResultSet resultSetDispDtl							=	null;Unused local variable INC63877 
		//String allow_edit_disp_label	= tabData.get("allow_edit_disp_label")!=null?(String)tabData.get("allow_edit_disp_label"):"";  //Commented for COMMON-ICN-0048
		int tot_count								=	0;
		int tot_dtl_count=0; //Added for AAKH-SCF-0504
		String IV_PREP_YN = (String)tabData.get("IV_PREP");//added for SKR-SCF-1319 
		boolean bIncludeToBMS = false;
		try {
			if(((String)tabData.get("patient_class")).equals("O")){
				pstmt_disp_hdr_count		= connection.prepareStatement("SELECT COUNT(*) COUNT FROM PH_DISP_HDR_TMP a WHERE ORDER_ID=? and disp_locn_code = ? and facility_id = ? and exists (select 'Y' from ph_disp_dtl_tmp b where b.ORDER_ID=a.order_id and b.disp_qty > 0  and b.order_line_no = ? and not exists (select 'Y' from or_ordeR_line c where c.order_id = b.ordeR_id and order_line_num = b.order_line_no and order_line_status in ('DC', 'HC', 'HD')))") ; //and exists (select 'Y' from ph_disp_dtl_tmp b where b.ORDER_ID=a.order_id and b.disp_qty > 0  and not exists (select 'Y' from or_ordeR_line c where c.order_id = b.ordeR_id and order_line_num = b.order_line_no))
			}
			else{
				//added for SKR-SCF-1319 START 
				if(IV_PREP_YN!=null && (IV_PREP_YN.equals("1") || IV_PREP_YN.equals("3"))){ 
					pstmt_disp_hdr_count		= connection.prepareStatement("SELECT COUNT(*) COUNT FROM PH_DISP_HDR_TMP a WHERE ORDER_ID=? and disp_locn_code = ? and facility_id = ? and exists (select 'Y' from ph_disp_dtl_tmp b where b.ORDER_ID=a.order_id and b.disp_qty > 0  and b.order_line_no = ? and not exists (select 'Y' from or_ordeR_line c where c.order_id = b.ordeR_id and order_line_num = b.order_line_no and order_line_status in ('DC', 'HC', 'HD')))") ; 
					
				}else{
					pstmt_disp_hdr_count		= connection.prepareStatement((String)sqlMap.get("SQL_PH_DISP_MEDICATION_HDR_COUNT")) ;
				}  
				//added for SKR-SCF-1319 end 
			}
			pstmt_disp_hdr_delete		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_HDR_DELETE") ) ;
			//pstmt_disp_dtl_delete		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_DTL_DELETE") ) ;
			//pstmt_disp_batch_delete		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_BATCH_DELETE") ) ;
			pstmt_disp_dtl_delete		= connection.prepareStatement("DELETE FROM PH_DISP_DTL_TMP WHERE ORDER_ID=? AND ORDER_LINE_NO=?") ; //Added AND ORDER_LINE_NO=? for SKR-SCF-0105 ICN 29078
			pstmt_disp_dtl_count		= connection.prepareStatement("SELECT COUNT(*) count FROM PH_DISP_DTL_TMP WHERE ORDER_ID=? and ORDER_LINE_NO=? AND disp_locn_code=? and FACILITY_ID=? ") ; //Added for AAKH-SCF-0504
			pstmt_disp_batch_delete		= connection.prepareStatement("DELETE FROM PH_DISP_DRUG_BATCH_TMP WHERE ORDER_ID=? AND ORDER_LINE_NUM=?") ; //Added AND ORDER_LINE_NO=? for SKR-SCF-0105 ICN 29078

			HashMap hmAllocBMSCheck = null;
			if(tabData.get("alloc_bms_chk")!= null)
				hmAllocBMSCheck = (HashMap)tabData.get("alloc_bms_chk");
			String sOrderId = "";
			String sOrderIdLineNo = "";
			for(int i=0;i<orderLineData.size();i=i+6){	//Modified for RUT-CRF-0088 [IN036978] 7->6
				bIncludeToBMS = false;
				sOrderId=  orderLineData.get(i+3).toString().trim();
				sOrderIdLineNo = sOrderId+""+orderLineData.get(i+4).toString().trim();
				if(hmAllocBMSCheck!=null)
					if(hmAllocBMSCheck.get(sOrderIdLineNo)!= null && hmAllocBMSCheck.get(sOrderIdLineNo).toString().equals("Y"))
						bIncludeToBMS = true;
				 if(((String)orderLineData.get(i)).trim().equals("N") || bIncludeToBMS){
				
					pstmt_disp_hdr_count.setString(1,sOrderId);
					pstmt_disp_hdr_count.setString(2,((String)tabData.get("disp_locn_code")).trim());
					pstmt_disp_hdr_count.setString(3,((String)tabData.get("facility_id")).trim());
					//Added for AAKH-SCF-0504---Start
					pstmt_disp_dtl_count.setString(1,sOrderId);
					pstmt_disp_dtl_count.setString(2,orderLineData.get(i+4).toString().trim());
					pstmt_disp_dtl_count.setString(3,((String)tabData.get("disp_locn_code")).trim());
					pstmt_disp_dtl_count.setString(4,((String)tabData.get("facility_id")).trim());
					resultSet = pstmt_disp_dtl_count.executeQuery() ;
					
					tot_dtl_count	=	0;
					if ( resultSet.next() ) {
						tot_dtl_count	=	Integer.parseInt(resultSet.getString("COUNT"));
					}
					System.err.println("tot_dtl_count=====3625==>"+tot_dtl_count);
					if(resultSet != null)
					{
						closeResultSet( resultSet ) ;
					}
					//Added for AAKH-SCF-0504---End
					//ADDED FOR SKR-SCF-1319 START
					if(((String)tabData.get("patient_class")).equals("I")){
						if(IV_PREP_YN!=null && (IV_PREP_YN.equals("1") || IV_PREP_YN.equals("3")))
							pstmt_disp_hdr_count.setString(4,orderLineData.get(i+4).toString());
					}
					//ADDED FOR SKR-SCF-1319 END 
		            if(((String)tabData.get("patient_class")).equals("O"))
						pstmt_disp_hdr_count.setString(4,orderLineData.get(i+4).toString());
					resultSet = pstmt_disp_hdr_count.executeQuery() ;
					tot_count	=	0;
					if ( resultSet.next() ) {
						tot_count	=	Integer.parseInt(resultSet.getString("COUNT"));
					}
					
					
					if(tot_count > 0 ) { //Added for AAKH-SCF-0504---Start
						boolean flag=true;
						if(((String)tabData.get("patient_class")).equals("I") && (IV_PREP_YN==null  || IV_PREP_YN.equals(""))){
							if(tot_dtl_count>0)
								flag=true;
							else
								flag =false;
						}

						if(flag){ //Added for AAKH-SCF-0504---End
						pstmt_disp_hdr_delete.setString(1,sOrderId);
						pstmt_disp_hdr_delete.executeUpdate();
						}  //Added for AAKH-SCF-0504
					}
					pstmt_disp_dtl_delete.setString(1,sOrderId);//bellow staements are removed from if(tot_count > 0 ) { block for ICN 31589 -Start
					pstmt_disp_dtl_delete.setString(2,(String)orderLineData.get(i+4));
					pstmt_disp_dtl_delete.executeUpdate();
					pstmt_disp_batch_delete.setString(1,sOrderId);
					pstmt_disp_batch_delete.setString(2,(String)orderLineData.get(i+4));
					pstmt_disp_batch_delete.executeUpdate(); //bellow staements are removed from if(tot_count > 0 ) { block for ICN 31589  -End
				}
				if(((String)tabData.get("disp_stage")).equals("AS")) {
					i	=	i+3;
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
			throw new EJBException("Error: DELETING TMP TABLES");
		}
		finally{	
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt_disp_hdr_count ) ;
				closeStatement( pstmt_disp_hdr_delete ) ;
				closeStatement( pstmt_disp_dtl_delete ) ;
				closeStatement( pstmt_disp_batch_delete ) ;
				closeStatement( pstmt_disp_dtl_count ) ; //Added for AAKH-SCF-0504
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
	}

	private void deletesales(Connection connection,HashMap tabData,ArrayList dispTMP,HashMap prev_doc_no,String st_doc_type, HashMap sqlMap,HashMap stock_srl) throws Exception{
		String error_id1 ="";						
		try {
			HashMap hmPKData		         =	new HashMap();
			HashMap hmCommon		          =	new HashMap();
			HashMap hmData			          =	new HashMap();
			HashMap bl_Detail		          =	new HashMap();
			String order_id			          =	null;
			String order_line_num	          =	null;
			String docno					  =	null;
			//String old_oreder_id			  =	"";	
			String p_overridden_det			  = "";
			String p_overridden_excl_incl_ind = "";
			String p_overridden_action_reason = "";
			HashMap order_id_attended_pract_id  =  (HashMap)tabData.get("ORDER_ID_ATTENDED_PRACT_ID"); // added for SRR20056-SCF-7373

			hmCommon.put("login_by_id",(String)tabData.get("login_by_id"));
			hmCommon.put("login_at_ws_no",(String)tabData.get("login_at_ws_no"));
			hmCommon.put("login_facility_id",(String)tabData.get("facility_id"));
			hmCommon.put("FACILITY_STR_FOR_BL",(String)tabData.get("ordering_facility_id")+"|"+(String)tabData.get("facility_id"));

			HashMap token_vals                = (HashMap)tabData.get("token_vals");
			String[] strTokenTemp					  = new String[2];//Added for HSA-CRF-0136 [IN:048412]
			//HashMap al_bl_tot_data            = new HashMap ();
			Hashtable al_bl_data		      =	new Hashtable();	
			HashMap al_bl_tot_data_tmp        =	new HashMap();	
			String doc_srl_no		          =	"";
			for(int i=0;i<dispTMP.size();i=i+7){
				p_overridden_excl_incl_ind	=	"";
				p_overridden_action_reason	=	"";
				order_id					=	(String)dispTMP.get(i);	
				order_line_num				=	(String)dispTMP.get(i+1);
				p_overridden_det = getBlInclExclDetail(connection, order_id, order_line_num,sqlMap);
				if(p_overridden_det!=null && !p_overridden_det.equals("")){
					p_overridden_excl_incl_ind = p_overridden_det.substring(0,1);
					p_overridden_action_reason = p_overridden_det.substring(p_overridden_det.indexOf(":")+1);
				}                
				hmCommon.put("p_ord_practitioner_id",(String)(order_id_attended_pract_id.get(((String)dispTMP.get(i)).trim()))); // added for SRR20056-SCF-7373

				ArrayList batchDetails = (ArrayList)dispTMP.get(i+6);
				if(batchDetails.size()>0){		
					if(prev_doc_no.containsKey(order_id+order_line_num)){
						docno		=	(String)prev_doc_no.get(order_id+order_line_num);
						bl_Detail	=	new HashMap();							   
					  //  bl_Detail.put("disp_item_code",(String)dispTMP.get(i+3));
						bl_Detail.put("disp_item_code",stock_srl.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim()+"_drug"));
						bl_Detail.put("p_overridden_excl_incl_ind",p_overridden_excl_incl_ind);
						bl_Detail.put("p_overridden_action_reason",p_overridden_action_reason);
						//bl_Detail.put("token_series_code",(String)tabData.get("token_series_code"));
						//bl_Detail.put("token_serial_no",(String)token_vals.get((order_id).trim()));	
						if(token_vals!=null && token_vals.size()>0 && token_vals.get(order_id)!=null){ //Added if condition and else block for [IN:049206]
							strTokenTemp = ((String)token_vals.get(order_id)).split("_");//Added for HSA-CRF-0136 [IN:048412]
							bl_Detail.put("token_series_code",strTokenTemp[0]);//Changed for HSA-CRF-0136 [IN:048412]
							bl_Detail.put("token_serial_no",strTokenTemp[1]);	//Changed for HSA-CRF-0136 [IN:048412]
						}
						else{ //else block Added for [IN:049206]
							bl_Detail.put("token_series_code","");
							bl_Detail.put("token_serial_no","");
						}
						bl_Detail.put("doc_srl_no",stock_srl.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim()));	
						//al_bl_data.put(docno+stock_srl.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim()),bl_Detail);
						if(al_bl_data.containsKey(docno)) {
							 al_bl_tot_data_tmp   =(HashMap) al_bl_data.get(docno);
							if(stock_srl.containsKey(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim()+"_drug")){    
								al_bl_tot_data_tmp.put(docno+stock_srl.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim()), bl_Detail);
							}

							 al_bl_data.put(docno,al_bl_tot_data_tmp);
						}
						else{
							  al_bl_tot_data_tmp =new HashMap();
							if(stock_srl.containsKey(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim()+"_drug")){  
								al_bl_tot_data_tmp.put(docno+stock_srl.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim()), bl_Detail);
							}
							 al_bl_data.put(docno,al_bl_tot_data_tmp);
						}
					}
				}					
			}

		  if(tabData.containsKey("CONSUMABLES_DET")){
			  HashMap cons_dtl       =   new HashMap();
			  doc_srl_no             =  "";
 
			  ArrayList  tot_consumables_det =(ArrayList)tabData.get("CONSUMABLES_DET");
			   for (int h=0;h<tot_consumables_det.size() ;h++ )  { 
				   cons_dtl = (HashMap)tot_consumables_det.get(h);
				  if(cons_dtl.get("SELECTED_FROM_DISP_DAT_YN").equals("Y")){ 
						docno		=	(String)cons_dtl.get("DOC_NO");
						doc_srl_no  =   (String)cons_dtl.get("BATCH_SRL_NO");
						 bl_Detail	=	new HashMap();
							   
						bl_Detail.put("disp_item_code",(String)cons_dtl.get("ORDER_CATALOG_CODE"));
						bl_Detail.put("p_overridden_excl_incl_ind","");
						bl_Detail.put("p_overridden_action_reason","");
						bl_Detail.put("token_series_code","");
						bl_Detail.put("token_serial_no","");	
						bl_Detail.put("doc_srl_no",doc_srl_no);

						if(al_bl_data.containsKey(docno)) {
							 al_bl_tot_data_tmp   =(HashMap) al_bl_data.get(docno);
							 al_bl_tot_data_tmp.put(docno+doc_srl_no, bl_Detail);
							 al_bl_data.put(docno,al_bl_tot_data_tmp);
						}
						else{
							 al_bl_tot_data_tmp =new HashMap();
							 al_bl_tot_data_tmp.put(docno+doc_srl_no, bl_Detail);
							 al_bl_data.put(docno,al_bl_tot_data_tmp);
						}
					}
				}
			}
			Enumeration v1=al_bl_data.keys();
			ArrayList itemList	=   new ArrayList();
			
		   /* while (v1.hasMoreElements() ) {
				docno		=	((String)v1.nextElement()).trim();
				hmPKData	=	new HashMap();
				al_bl_tot_data_tmp =(HashMap)al_bl_data.get(docno);

				if( al_bl_tot_data_tmp.size()>0){
					hmPKData.put("facility_id",(String)tabData.get("facility_id"));
					hmPKData.put("doc_no",docno);
					hmPKData.put("doc_type_code",st_doc_type);
					hmData.put("COMMON_DATA",hmCommon);			
					hmData.put("DATA",hmPKData);
					hmData.put("BL_DETAIL",al_bl_tot_data_tmp);
					eST.Common.StSales	stSales	=	new eST.Common.StSales();
					HashMap map					=	stSales.deleteSales(connection,hmData);
					if( !(((Boolean) map.get( "result" )).booleanValue()) )	{
					   connection.rollback();
					   throw new Exception("delete Sales failed");
					}
				}
			}*/
			String key ="";
			while (v1.hasMoreElements() ) {
				docno		=	((String)v1.nextElement()).trim();
				hmPKData	=	new HashMap();
				al_bl_tot_data_tmp =(HashMap)al_bl_data.get(docno);

				if( al_bl_tot_data_tmp.size()>0){
					 //Enumeration v2=al_bl_tot_data_tmp.keySet();
					 Set keyset     	= al_bl_tot_data_tmp.keySet();
					 Iterator   Ite2	= keyset.iterator();

					while (Ite2.hasNext() ) {
					//for(int i=0;i<al_bl_tot_data_tmp.size();i++){
						key         = 	(String)Ite2.next();
						itemList	=   new ArrayList();
						bl_Detail =  (HashMap)al_bl_tot_data_tmp.get(key);
						itemList.add((String)bl_Detail.get("disp_item_code"));
						hmPKData.put("facility_id",(String)tabData.get("facility_id"));
						hmPKData.put("doc_no",docno);
						hmPKData.put("doc_type_code",st_doc_type);
						hmPKData.put("doc_srl_no",(String)bl_Detail.get("doc_srl_no"));

						hmCommon.put("doc_no",docno);
						hmCommon.put("doc_type_code",st_doc_type);
						hmCommon.put("facility_id",(String)tabData.get("facility_id"));
						hmCommon.put("DispBillingStage",(String)tabData.get("DispBillingStage"));
						//hmCommon.put("DispBillingStage",(String)tabData.get("DispBillingStage"));
						
						hmData.put("ITEM_CODE",itemList);
						hmData.put("COMMON_DATA",hmCommon);			
						hmData.put("DATA",hmPKData);
						hmData.put("BL_DETAIL",bl_Detail);
					   
						eST.Common.StSales	stSales	=	new eST.Common.StSales();
						//HashMap map					=	stSales.deleteSales(connection,hmData);
						HashMap map					=	stSales.deleteSalesItemDetailsForPH(connection,hmData);
						if( !(((Boolean) map.get( "result" )).booleanValue()) )	{
						   connection.rollback();
							//SRR20056-SCF-7584 , rawther
							if(map.get("message").toString().contains("ORA-00054")){
								//ORA-00054
								error_id1 ="Sales Error: Record Already In Use - It is used by Other User.Please Try again...";//RECORD_UPDATED_BY_OTH_USER
							}
							else{  
								error_id1="Sales Error: " + map.get("message");
							}
							throw new Exception(error_id1);
						}
					}
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
			throw new EJBException("Exception Delete Sales- "+error_id1);
		}
	}

// Patient drug profile update
	private void updatePatientDrugProfile(Connection connection, HashMap sqlMap,HashMap tabData,ArrayList patientDrugProfileData) throws Exception{
		PreparedStatement pstmt_update_patient_drug_profile		=	null;
	//	PreparedStatement pstmt_res_status						=	null;
		PreparedStatement pstmt_hold_reason						=	null;
	//	ResultSet		   resSet                               =	null;
		ResultSet		   resSet1                              =	null;
		String result_line_status								=   "";
		String hold_reason_code									=   "";	
		HashMap hmAltDrugRemarks	=  (HashMap)tabData.get("ALTDRUGREMARKS");
		try {
			pstmt_update_patient_drug_profile = connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_PATIENT_DRUG_PROFILE_UPDATE") ) ;
			//pstmt_res_status	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_ORDER_LINE_SELECT") ) ;
			pstmt_hold_reason	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT152") ) ;
			String alt_drug_remarks="",key;

			for(int i=0;i<patientDrugProfileData.size();i=i+6){	// If prescription is on hold
				key = ((String)patientDrugProfileData.get(i+4)).trim()+"~"+((String)patientDrugProfileData.get(i+5)).trim();
				if(hmAltDrugRemarks !=null && hmAltDrugRemarks.containsKey(key))
					alt_drug_remarks = (String)hmAltDrugRemarks.get(key);
				else
					alt_drug_remarks="";
				if(((String)patientDrugProfileData.get(i)).equals("Y")){
					result_line_status	=   "";
					hold_reason_code    =   "";
					pstmt_update_patient_drug_profile.setString(1,((String)tabData.get("dateTime")).trim());	// ON_HOLD_DATE_TIME    
					pstmt_update_patient_drug_profile.setString(2,(String)patientDrugProfileData.get(i+1));		// ON_HOLD_BY_ID    
					
					pstmt_hold_reason.setString(1,((String)patientDrugProfileData.get(i+4)).trim());//OR_ORDER					
					pstmt_hold_reason.setString(2,((String)patientDrugProfileData.get(i+5)).trim()); //OR_ORDER_LINE
					resSet1		= pstmt_hold_reason.executeQuery() ;		
							
					if(resSet1.next()) {
						hold_reason_code =(String)resSet1.getString("ON_HOLD_REASON_CODE");
						if(hold_reason_code ==null) 
							hold_reason_code ="";
					}
					closeResultSet( resSet1 ) ; //common-icn-0029
					if(hold_reason_code.equals("")){				
						hold_reason_code  =(String)patientDrugProfileData.get(i+2);
					}
					//pstmt_update_patient_drug_profile.setString(3,(String)patientDrugProfileData.get(i+2));			// ON_HOLD_REASON_CODE  
					pstmt_update_patient_drug_profile.setString(3,hold_reason_code);			// ON_HOLD_REASON_CODE  
				}
				else if(((String)patientDrugProfileData.get(i)).equals("N")){	// If prescription is allocated
					pstmt_update_patient_drug_profile.setString(1,"");		// ON_HOLD_DATE_TIME    
					pstmt_update_patient_drug_profile.setString(2,"");		// ON_HOLD_BY_ID        
					pstmt_update_patient_drug_profile.setString(3,"");		// ON_HOLD_REASON_CODE  
				}
				else if(((String)patientDrugProfileData.get(i)).equals("NN")){	// If prescription is not on hold and not allocated 
					pstmt_update_patient_drug_profile.setString(1,"");			// ON_HOLD_DATE_TIME    
					pstmt_update_patient_drug_profile.setString(2,"");			// ON_HOLD_BY_ID        
					pstmt_update_patient_drug_profile.setString(3,"");            // ON_HOLD_REASON_CODE  
					
				}
				pstmt_update_patient_drug_profile.setString(4,(String)tabData.get("login_by_id"));		// modified id
				pstmt_update_patient_drug_profile.setString(5,(String)tabData.get("facility_id"));		// modified facility
				pstmt_update_patient_drug_profile.setString(6,(String)tabData.get("login_at_ws_no"));		// modified work station
				pstmt_update_patient_drug_profile.setString(7,alt_drug_remarks);		// modified work station
				pstmt_update_patient_drug_profile.setString(8,((String)patientDrugProfileData.get(i+3)).trim());// PATIENT_ID          
				pstmt_update_patient_drug_profile.setString(9,((String)patientDrugProfileData.get(i+4)).trim());// ORIG_ORDER_ID       
				pstmt_update_patient_drug_profile.setString(10,((String)patientDrugProfileData.get(i+5)).trim());// ORIG_ORDER_LINE_NO  
				pstmt_update_patient_drug_profile.setString(11,(String)tabData.get("ordering_facility_id"));	// FACILITY_ID//Changed from 'FACILITY_ID' to 'ORDERING_FACILITY_ID' for ML-BRU-SCF-1171 [IN:045380]           
				pstmt_update_patient_drug_profile.addBatch();
				//j=j+1;
			}
			int[] result2=pstmt_update_patient_drug_profile.executeBatch();
			for (int i=0;i<result2.length ;i++ ){
				if(result2[i]<0  && result2[i] != -2 ){
					pstmt_update_patient_drug_profile.cancel();
					connection.rollback();
					throw new EJBException("Ph patient Drug Profile Failed");
				}		
			}
		}
		catch(Exception e){
			e.printStackTrace();
			throw new EJBException("Error: PH_PATIENT_DRUG_PROFILE FAILED");
		}
		finally{	
			try {
				closeStatement( pstmt_update_patient_drug_profile ) ;
				closeStatement( pstmt_hold_reason ) ;
				closeResultSet( resSet1 );
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
	}

// Or order update
	private void updateOrOrder(Connection connection, HashMap sqlMap, HashMap tabData,ArrayList orderLineData, HashMap  orderUpdate, String update_string) throws Exception {
		PreparedStatement pstmt_update_order		= null;
		PreparedStatement pstmt_update_disp_queue	= null;
		PreparedStatement pstmt_update_ord_for_disp_queue	= null;
		ArrayList order_id_to_update	=	new ArrayList();
		ArrayList all_order_status		=	new ArrayList();	
		//String sql_qry = ""; //Commented for COMMON-ICN-0048
		int ord_update					= 0;

		try {
			pstmt_update_order	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_ORDER_UPDATE1") ) ;
			Set set				= orderUpdate.keySet();
			Iterator iterator	= set.iterator();

			HashMap order_id_order_date = (HashMap)tabData.get("ORDER_ID_ORDER_DATE");
			while (iterator.hasNext()){
				String order_id			= (String)iterator.next();
				ArrayList arr_list		= (ArrayList)orderUpdate.get(order_id);
				String us				= getUpdateString(arr_list);

				if(tabData.get("token_yn")!=null && tabData.get("token_yn").equals("Y")) {
					all_order_status.add(us);
				}
				order_id_to_update.add(order_id);
				order_id_to_update.add(us);	
				order_id_to_update.add(order_id_order_date.get(order_id));	
			}
		}
		catch(Exception e){
			e.printStackTrace();
			throw new EJBException("Error: OR_ORDER UPDATE FAILED AT FIRST PART");
		}
		for(int i=0;i<order_id_to_update.size();i=i+3){
			try{
				pstmt_update_order.setString(1,((String)order_id_to_update.get(i+1)).trim()); // order_Status
				pstmt_update_order.setString(2,(String)tabData.get("login_by_id"));		// modified id
				pstmt_update_order.setString(3,(String)tabData.get("facility_id"));		// modified facility
				pstmt_update_order.setString(4,(String)tabData.get("login_at_ws_no"));	// modified work station		  			
				pstmt_update_order.setString(5,((String)order_id_to_update.get(i)).trim());
				pstmt_update_order.setString(6,((String)order_id_to_update.get(i+2)).trim());// or order's modified date
				ord_update = pstmt_update_order.executeUpdate();
			}
			catch(Exception e){
				e.printStackTrace();
				throw new EJBException("Error: OR_ORDER executing update query");
			}	
			
			if(ord_update < 0){
				connection.rollback();
				throw new EJBException("Error: update OR_ORDER");				
			}
			else if( ord_update == 0){
				connection.rollback();
				throw new EJBException("Error: update OR_ORDER - Record Already In Use - It is used by Other User.Please Try again...");//ORDER_PROC_BY_OTHER_USER
			}

			try{ 
				if(tabData.get("token_yn")!=null && tabData.get("token_yn").equals("Y")) {
					int count					=	1;
					String token_no				=	"",token_series_code="";//Added token_series_code for HSA-CRF-0136 [IN:048412]
					String token_status			= ((String)order_id_to_update.get(i+1)).trim();
					pstmt_update_disp_queue		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_UPDATE14") ) ;
                    				
					pstmt_update_ord_for_disp_queue = connection.prepareStatement("UPDATE PH_ORD_FOR_DISP_QUEUE SET TOKEN_LINE_STATUS= ? WHERE FACILITY_ID=? AND  DISP_LOCN_CODE =? AND  QUEUE_DATE=TO_DATE(?,'DD/MM/YYYY') AND QUEUE_SHIFT='*ALL' AND TOKEN_SERIES_CODE=? AND TOKEN_SERIAL_NO=? AND ORDER_ID=? AND ORDER_LINE_NUM=?");
					HashMap token_vals			= (HashMap)tabData.get("token_vals");
					String[] strTokenTemp		= new String[2];//Added for HSA-CRF-0136 [IN:048412]
					// Added for alloc_bms_chk for update the token status by charles.
					HashMap alloc_bms_chk	=  tabData.get("alloc_bms_chk")!=null?(HashMap)tabData.get("alloc_bms_chk"):new HashMap();
					for(int j=0; j<orderLineData.size(); j+=6) {
						if((token_vals.containsKey(((String)orderLineData.get(j+3)).trim()) && (((String)order_id_to_update.get(i)).trim().equals(((String)orderLineData.get(j+3)).trim())) &&(((String)orderLineData.get(j)).trim().equals("N"))) || (alloc_bms_chk.containsKey(((String)orderLineData.get(i+3)+(String)orderLineData.get(i+4))))) {
							//token_no	=	(String)token_vals.get(((String)orderLineData.get(j+3)).trim());
							if(token_vals.get(((String)orderLineData.get(j+3)).trim()) !=null ){
								strTokenTemp = ((String)token_vals.get(((String)orderLineData.get(j+3)).trim())).split("_");//Added for HSA-CRF-0136 [IN:048412]
								token_series_code = strTokenTemp[0];//Added for HSA-CRF-0136 [IN:048412]
								token_no	=	strTokenTemp[1];//Added for HSA-CRF-0136 [IN:048412]
								if(token_no!=null && !token_no.equals("")) {
									 break;
								}
							}
						}
						else{
							token_no	="";
						}				
						if(((String)tabData.get("disp_stage")).equals("AS")) {
							j	=	j	+	3;
						}
					}

					if(!token_status.equals("HD")){
					   if(((String)tabData.get("disp_stage")).equals("AS")){
						   token_status ="DF";
					   }
					   else  if(((String)tabData.get("disp_stage")).equals("A")){
						   token_status ="AL";     
					   }
					   else  if(((String)tabData.get("disp_stage")).equals("F")){
						   token_status ="IP";
					   }
					   else  if(((String)tabData.get("disp_stage")).equals("D")){
						   token_status ="DP";
					   }
					   if(((String)tabData.get("disp_stage")).equals("V")){
						   token_status ="VF";
					   }
				   }
//added for PMG2020-ML-MMOH-CRF-0002-start
				if(token_no!=null && !token_no.equals("")) {

					boolean update_flag = false;
					String alloc_bms_chk_val_temp	="";
					for(int j=0; j<orderLineData.size(); j+=6) {
						
					if(token_status!=null && token_status.equals("DP"))
					  token_status = "DF";
					

					
					int count1					=	1;
					if(alloc_bms_chk.containsKey(((String)orderLineData.get(j+3)+(String)orderLineData.get(j+4)))){
						alloc_bms_chk_val_temp = (String)alloc_bms_chk.get(((String)orderLineData.get(j+3)+(String)orderLineData.get(j+4)));
					}
					if(alloc_bms_chk_val_temp==null){
					 alloc_bms_chk_val_temp = "";
					}
						if((token_vals.containsKey(((String)orderLineData.get(j+3)).trim()) && (((String)order_id_to_update.get(i)).trim().equals(((String)orderLineData.get(j+3)).trim())) &&(((String)orderLineData.get(j)).trim().equals("N"))) || ((((String)order_id_to_update.get(i)).trim().equals(((String)orderLineData.get(j+3)).trim())) && alloc_bms_chk_val_temp!=null && alloc_bms_chk_val_temp.equals("Y"))) {

							pstmt_update_ord_for_disp_queue.setString(count1,token_status);
							pstmt_update_ord_for_disp_queue.setString(++count1,(String)tabData.get("facility_id"));
							pstmt_update_ord_for_disp_queue.setString(++count1,(String)tabData.get("disp_locn_code"));
							pstmt_update_ord_for_disp_queue.setString(++count1,(String)tabData.get("Token_Queue_date"));
					  	    pstmt_update_ord_for_disp_queue.setString(++count1,token_series_code);
							pstmt_update_ord_for_disp_queue.setString(++count1,token_no);
							pstmt_update_ord_for_disp_queue.setString(++count1,orderLineData.get(j+3).toString().trim());
							pstmt_update_ord_for_disp_queue.setString(++count1,orderLineData.get(j+4).toString().trim());
							pstmt_update_ord_for_disp_queue.addBatch();
							
							update_flag = true;
					 }
																
					if(((String)tabData.get("disp_stage")).equals("AS")) {
							j	=	j	+	3;
						}
					}
					if(update_flag){
						int[] result5	=pstmt_update_ord_for_disp_queue.executeBatch();
						for (int k=0;k<result5.length ;k++){
							if(result5[k]<0  && result5[k] != -2 ){
							pstmt_update_ord_for_disp_queue.cancel();
					
							throw new EJBException("Error: Update PH_ORD_FOR_DISP_QUEUE updation Failed");
							}		
						}
					}
				}
//added for PMG2020-ML-MMOH-CRF-0002-end

					if(token_no!=null && !token_no.equals("")) {
						pstmt_update_disp_queue.setString(count,token_status);
						pstmt_update_disp_queue.setString(++count,(String)tabData.get("facility_id"));
						pstmt_update_disp_queue.setString(++count,(String)tabData.get("disp_locn_code"));
						pstmt_update_disp_queue.setString(++count,(String)tabData.get("Token_Queue_date"));
						//pstmt_update_disp_queue.setString(++count,(String)tabData.get("token_series_code"));
						pstmt_update_disp_queue.setString(++count,token_series_code);//Changed token_series_code for HSA-CRF-0136 [IN:048412]
						pstmt_update_disp_queue.setString(++count,token_no);
						pstmt_update_disp_queue.executeUpdate();
					}
					closeStatement( pstmt_update_disp_queue ) ;//3/21/2021
					closeStatement(pstmt_update_ord_for_disp_queue);//3/21/2021

				 }	
			 }
			 catch(Exception e){
				System.err.println("  OR_ORDER UPDATE FAILED SECOND PART tabData="+tabData);
				e.printStackTrace();
				throw new EJBException("Error: OR_ORDER UPDATE FAILED SECOND PART");
			}
		}
		try {
			closeStatement( pstmt_update_disp_queue ) ;
			closeStatement(pstmt_update_ord_for_disp_queue);
			closeStatement( pstmt_update_order ) ;
		}
		catch(Exception es) { 
			es.printStackTrace();
		}
	}

// Header tmp table insert method
	private HashMap insertHeaderTMP(Connection connection, HashMap sqlMap, HashMap tabData,ArrayList dispTMP) throws Exception{

		PreparedStatement pstmt_insert_disp_hrd_tmp	 =  null;
		//PreparedStatement pstmt_select_order_line_ph =  null;
		PreparedStatement pstmt_select_disp_hdr_tmp  =  null;
		PreparedStatement pstmt_select_disp_hdr_tmp1  =  null;
		PreparedStatement pstmt_select_order_line_cunt = null; //AAKH-SCF-0504
		ResultSet resultSet							 =  null;	
		ResultSet resultSet1						 =  null;
		ResultSet resultSet2						 =  null;//AAKH-SCF-0504
		ArrayList unique_key						 =  new ArrayList();
		String patient_class						 =  "";
		String sequence_no							 =  "";
		String encounter_id							 =  "";
		String source_code							 =  "";
		String source_type							 =  "";
		//String disp_stage							 =  (String)tabData.get("disp_stage");
		String ip_fill_proc_id						 =  "";
		HashMap seq_no								 =	new HashMap();
		HashMap alloc_bms_chk						 = (HashMap)tabData.get("alloc_bms_chk");
		String  trx_seq_no							 =  "";	
		HashMap order_id_attended_pract_id           =  (HashMap)tabData.get("ORDER_ID_ATTENDED_PRACT_ID");
		//String order_line_num						 =  "";
		String sDailySeqNo							 =  "";
		//String sFacilityId							 =  tabData.get("facility_id")==null?"":(String)tabData.get("facility_id");
		//String sDispLocnCode						 =  tabData.get("disp_locn_code")==null?"":(String)tabData.get("disp_locn_code");
		HashMap hmTokenVals							 =  tabData.get("token_vals")==null?new HashMap():(HashMap)tabData.get("token_vals");
		String	sTokenSeriesCode					 =  "";//tabData.get("token_series_code")==null?"":(String)tabData.get("token_series_code");//Changed "" for HSA-CRF-0136 [IN:048412]
		String sTokenYN								 =  tabData.get("token_yn")==null?"N":(String)tabData.get("token_yn");
		String sTokenNo								 =  "";
		String  room_num                             ="";
        String  bed_num                              ="";
		String  bed_class_code                       ="";
	    String  bed_type_code                        ="";
	    String[] strTokenTemp						 = new String[2];//Added for HSA-CRF-0136 [IN:048412]
		HashMap FillProcIDForOrderID                 = new HashMap();
		
		if(tabData.containsKey("FillProcIDForOrderID")){
			FillProcIDForOrderID =(HashMap)tabData.get("FillProcIDForOrderID");
		}
		String IV_PREP_YN = (String)tabData.get("IV_PREP");//added for SKR-SCF-1319 
				
		try {
			pstmt_insert_disp_hrd_tmp	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_HRD_TMP_INSERT") ) ;

			pstmt_select_order_line_cunt = connection.prepareStatement("SELECT COUNT(*) COUNT FROM OR_ORDER_LINE WHERE ORDER_ID=? and order_line_num>1"); //added for AAKH-SCF-0504
			//AAKH-SCF-0504
            if(((String)tabData.get("patient_class")).equals("O")){
				pstmt_select_disp_hdr_tmp=  connection.prepareStatement("SELECT DISP_TMP_NO FROM PH_DISP_HDR_TMP a WHERE ORDER_ID=? AND DISP_LOCN_CODE = ? AND FACILITY_ID=? and exists (select 'Y' from ph_disp_dtl_tmp b where b.ORDER_ID=a.order_id and b.disp_qty > 0 and b.order_line_no = ?  and not exists (select 'Y' from or_ordeR_line c where c.order_id = b.ordeR_id and order_line_num = b.order_line_no  and order_line_status in ('DC', 'HC', 'HD')))"); //and exists (select 'Y' from ph_disp_dtl_tmp b where b.ORDER_ID=a.order_id and b.disp_qty > 0 )
			}
			else{
				//added for SKR-SCF-1319  start
				if(IV_PREP_YN!=null && (IV_PREP_YN.equals("1") || IV_PREP_YN.equals("3")) ){
					pstmt_select_disp_hdr_tmp=  connection.prepareStatement("SELECT DISP_TMP_NO FROM PH_DISP_HDR_TMP a WHERE ORDER_ID=? AND DISP_LOCN_CODE = ? AND FACILITY_ID=? and exists (select 'Y' from ph_disp_dtl_tmp b where b.ORDER_ID=a.order_id and b.disp_qty > 0 and b.order_line_no = ?  and not exists (select 'Y' from or_ordeR_line c where c.order_id = b.ordeR_id and order_line_num = b.order_line_no  and order_line_status in ('DC', 'HC', 'HD')))"); 
				}
				else{
					pstmt_select_disp_hdr_tmp	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT149") ) ;
				}
				//added for SKR-SCF-1319  end 
			}
			pstmt_select_disp_hdr_tmp1	= connection.prepareStatement("SELECT  IP_OPEN_ENCOUNTER.ROOM_NUM ROOM_NUM, IP_OPEN_ENCOUNTER.BED_NUM BED_NUM,IP_OPEN_ENCOUNTER.BED_CLASS_CODE BED_CLASS_CODE, IP_OPEN_ENCOUNTER.BED_TYPE_CODE BED_TYPE_CODE from IP_OPEN_ENCOUNTER WHERE PATIENT_ID=? "  ) ;
			//if(disp_stage.equals("F")){
				//pstmt_select_order_line_ph = connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT126") ) ;
			//}

			if(((String)tabData.get("patient_class")).equals("O")){
				patient_class = "OP";
			}
			else {
				patient_class = "IP";
			}

			if(patient_class.equals("IP")){
				if(tabData.get("fill_list")!= null && tabData.get("fill_list").toString().equals("AF")){
					HashMap hmDailySeqNos = tabData.get("hmDailySeqNumbers")!=null?(HashMap)tabData.get("hmDailySeqNumbers"):null;
					if(hmDailySeqNos!=null){
						Iterator iteKeys			= hmDailySeqNos.keySet().iterator();
						if (iteKeys.hasNext()){
							 String	sValue		= (String) hmDailySeqNos.get(iteKeys.next());
							sDailySeqNo = sValue.split("~")[0];
						}
					}
				}
				else{
					sDailySeqNo = (String)tabData.get("DailySeqNo");
				}
			}

			if(tabData.get("encounter_id")==null || ((String)tabData.get("encounter_id")).equals("") || ((String)tabData.get("encounter_id")).equals("11111") ) {
				encounter_id	=	"11111";
				source_code		=	(String)tabData.get("disp_locn_code");
				source_type		=	"C";
			}
			else {
				encounter_id	=	(String)tabData.get("encounter_id");
				source_code		=	(String)tabData.get("source_code");
				source_type		=	(String)tabData.get("source_type");
			}

			if(encounter_id==null || encounter_id.equals("null") || encounter_id.equals("11111")) {
				encounter_id	=	"11111";
				source_code		=	(String)tabData.get("disp_locn_code");
				source_type		=	"C";
			}

			if(dispTMP.size()>0){
				trx_seq_no =  getSequenceNo("SELECT PH_DISP_TRN_SEQ.NEXTVAL FROM DUAL");
			}
			tabData.put("TRX_SEQ_NO",trx_seq_no);
			for(int i=0;i<dispTMP.size();i+=7){
				sTokenNo		  =  "";
				int count		  = 1;
				ip_fill_proc_id   = "";
				sequence_no		  =	"";
				boolean insert_flag = true; //AAKH-SCF-0504
				int tot_dtl_count = 0; //AAKH-SCF-0504

				if(!unique_key.contains(((String)dispTMP.get(i)).trim())) {
					unique_key.add(((String)dispTMP.get(i)).trim());
//AAKH-SCF-0504 - start
					if(patient_class.equals("IP") && (IV_PREP_YN==null || IV_PREP_YN.equals("")) ){
					
					pstmt_select_order_line_cunt.setString(1,((String)dispTMP.get(i)).trim());
					
					 resultSet2	= pstmt_select_order_line_cunt.executeQuery() ;
						if(resultSet2!=null && resultSet2.next()){
							tot_dtl_count	=	Integer.parseInt(resultSet2.getString("COUNT"));
						}
					}


					closeResultSet(resultSet2);
//AAKH-SCF-0504 - end
					pstmt_select_disp_hdr_tmp.setString(1,((String)dispTMP.get(i)).trim());
					pstmt_select_disp_hdr_tmp.setString(2,(String)tabData.get("disp_locn_code"));
					pstmt_select_disp_hdr_tmp.setString(3,(String)tabData.get("facility_id"));
					//ADDED FOR SKR-SCF-1319 START
					if(((String)tabData.get("patient_class")).equals("I")){
						if(IV_PREP_YN!=null && (IV_PREP_YN.equals("1") || IV_PREP_YN.equals("3")))
							pstmt_select_disp_hdr_tmp.setString(4,((String)dispTMP.get(i+1)).trim()); 
					}
					//ADDED FOR SKR-SCF-1319 END 
					
		            if(((String)tabData.get("patient_class")).equals("O"))
						pstmt_select_disp_hdr_tmp.setString(4,((String)dispTMP.get(i+1)).trim());
					resultSet	= pstmt_select_disp_hdr_tmp.executeQuery() ;
					if(resultSet!=null && resultSet.next()){						
						sequence_no =   resultSet.getString("DISP_TMP_NO");	
						seq_no.put(((String)dispTMP.get(i)).trim(),sequence_no);
						insert_flag = false; //AAKH-SCF-0504
					}
					closeResultSet(resultSet);
					if(tot_dtl_count>1)  //AAKH-SCF-0504
						insert_flag = true;
					//else{
						if(insert_flag){
						sequence_no = getSequenceNo((String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT33"));

						seq_no.put(((String)dispTMP.get(i)).trim(),sequence_no);
						pstmt_insert_disp_hrd_tmp.setString(count,sequence_no);
						pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("facility_id"));
						pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("disp_locn_code"));
						pstmt_insert_disp_hrd_tmp.setString(++count,((String)dispTMP.get(i)).trim());
						if(patient_class.equals("IP")){
							if(tabData.get("fill_list")!= null && tabData.get("fill_list").toString().equals("AF")){					
								/*pstmt_select_order_line_ph.setString(1,((String)dispTMP.get(i)).trim());
								pstmt_select_order_line_ph.setString(2,((String)dispTMP.get(i+1)).trim());
								resultSet = pstmt_select_order_line_ph.executeQuery();
								if(resultSet.next()) {
									ip_fill_proc_id	=	resultSet.getString("FILL_PROC_ID");
								}*/
								ip_fill_proc_id	= (String)FillProcIDForOrderID.get(((String)dispTMP.get(i)).trim());
							}
							if(patient_class.equals("IP") && tabData.get("fill_list")!= null && tabData.get("fill_list").toString().equals("WF")){
							
								pstmt_select_disp_hdr_tmp1.setString(1,(String)tabData.get("patient_id"));
								resultSet1	= pstmt_select_disp_hdr_tmp1.executeQuery() ;
								if(resultSet1!=null && resultSet1.next()){						
						            room_num =   resultSet1.getString("ROOM_NUM");	
								    bed_num =   resultSet1.getString("BED_NUM");	
								    bed_class_code =   resultSet1.getString("BED_CLASS_CODE");	
								    bed_type_code =   resultSet1.getString("BED_TYPE_CODE");	
								}
							}
						}
						else{
							ip_fill_proc_id	="";
						}
						pstmt_insert_disp_hrd_tmp.setString(++count,ip_fill_proc_id);
						pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("ordering_facility_id"));
						pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("ord_date_time"));
						pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("patient_id"));
						pstmt_insert_disp_hrd_tmp.setString(++count,encounter_id);
						pstmt_insert_disp_hrd_tmp.setString(++count,patient_class.trim());	
						pstmt_insert_disp_hrd_tmp.setString(++count,source_type);
						pstmt_insert_disp_hrd_tmp.setString(++count,source_code);
						pstmt_insert_disp_hrd_tmp.setString(++count,"");	// SPECIALITY_CODE
						//pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("performing_pract_id"));//attended_pract_id
						//pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("performing_pract_id"));
						pstmt_insert_disp_hrd_tmp.setString(++count,(String)(order_id_attended_pract_id.get(((String)dispTMP.get(i)).trim())));//pres_physician_id
						pstmt_insert_disp_hrd_tmp.setString(++count,(String)(order_id_attended_pract_id.get(((String)dispTMP.get(i)).trim())));//pres_physician_id
						//pstmt_insert_disp_hrd_tmp.setString(++count,"");
						pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("login_by_id"));
						pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("login_at_ws_no"));
						pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("facility_id"));
						pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("login_by_id"));
						pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("login_at_ws_no"));
						pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("facility_id"));
						pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("FillPersonName"));
						//pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("func_role_id"));
						pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("login_by_id")); // Modified for RUT-SCF-0274 IN039740
						pstmt_insert_disp_hrd_tmp.setString(++count,trx_seq_no);
						pstmt_insert_disp_hrd_tmp.setString(++count,sDailySeqNo);

						if(sTokenYN.equals("Y")){
							//sTokenNo = hmTokenVals.get(((String)dispTMP.get(i)).trim())==null?"":(String)hmTokenVals.get(((String)dispTMP.get(i)).trim());	
							strTokenTemp = ((String)hmTokenVals.get(((String)dispTMP.get(i)))).split("_");//Added for HSA-CRF-0136 [IN:048412]
							sTokenSeriesCode = strTokenTemp[0];//Added for HSA-CRF-0136 [IN:048412]
							sTokenNo = strTokenTemp[1];	//Added for HSA-CRF-0136 [IN:048412]
						}
						pstmt_insert_disp_hrd_tmp.setString(++count,sTokenNo);
						pstmt_insert_disp_hrd_tmp.setString(++count,sTokenSeriesCode);
						pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("DispPeriodForHdr"));
						pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("DispUnitForHdr"));
						if(patient_class.equals("IP") && tabData.get("fill_list")!= null && tabData.get("fill_list").toString().equals("WF")){
							pstmt_insert_disp_hrd_tmp.setString(++count,room_num);
							pstmt_insert_disp_hrd_tmp.setString(++count,bed_num);
							pstmt_insert_disp_hrd_tmp.setString(++count,bed_class_code);
							pstmt_insert_disp_hrd_tmp.setString(++count,bed_type_code);
						}
						else{
							pstmt_insert_disp_hrd_tmp.setString(++count,"");
							pstmt_insert_disp_hrd_tmp.setString(++count,"");
							pstmt_insert_disp_hrd_tmp.setString(++count,"");
							pstmt_insert_disp_hrd_tmp.setString(++count,"");
						}
						pstmt_insert_disp_hrd_tmp.addBatch();					
						//ended.......
				   }
				}
			}
			// Charles ------------- start -----------
			// for BMS of not allocated drugs in header.
			if(alloc_bms_chk != null && alloc_bms_chk.size()>0){
				Set	key_set		=	alloc_bms_chk.keySet();
				Iterator itr	=	key_set.iterator();
				String order_id, order_id_line_num, order_line_num;
				 while(itr.hasNext())  {
					int count		  = 1;
					sTokenNo		  =  "";
					order_id_line_num = (String)itr.next();
					if(alloc_bms_chk.get(order_id_line_num).equals("Y")){
						//String order_id			= (String)order_id_line_num.substring(0,order_id_line_num.length()-1); //commented for ML-BRU-SCF-0390 [IN:034867]
						//String order_line_num	= (String)order_id_line_num.substring(order_id_line_num.length()-1,order_id_line_num.length()); //commented for ML-BRU-SCF-0390 [IN:034867]
						if(order_id_line_num.length()>=15){ //added for ML-BRU-SCF-0390 [IN:034867] - start
							order_id			= (String)order_id_line_num.substring(0,15);
							order_line_num	= (String)order_id_line_num.substring(15,order_id_line_num.length());
						}
						else
							throw new Exception("Wrong OrderId "+order_id_line_num); //added for ML-BRU-SCF-0390 [IN:034867] - end
						if(!unique_key.contains(order_id)) {
							unique_key.add(order_id);
							pstmt_select_disp_hdr_tmp.setString(1,order_id);
							pstmt_select_disp_hdr_tmp.setString(2,(String)tabData.get("disp_locn_code"));
							pstmt_select_disp_hdr_tmp.setString(3,(String)tabData.get("facility_id"));
							if(((String)tabData.get("patient_class")).equals("O"))
								pstmt_select_disp_hdr_tmp.setString(4,order_line_num);
							resultSet	= pstmt_select_disp_hdr_tmp.executeQuery() ;
							if(resultSet!=null && resultSet.next()){						
								sequence_no =   resultSet.getString("DISP_TMP_NO");	
								seq_no.put(order_id,sequence_no);
							}
							else{
								sequence_no = getSequenceNo((String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT33"));
								seq_no.put(order_id,sequence_no);
							}

							if(patient_class.equals("IP")){
								if(patient_class.equals("IP") && tabData.get("fill_list")!= null && tabData.get("fill_list").toString().equals("WF")){
									pstmt_select_disp_hdr_tmp1.setString(1,(String)tabData.get("patient_id"));
									resultSet1	= pstmt_select_disp_hdr_tmp1.executeQuery() ;
									if(resultSet1!=null && resultSet1.next()){						
										room_num =   resultSet1.getString("ROOM_NUM");	
										bed_num =   resultSet1.getString("BED_NUM");	
										bed_class_code =   resultSet1.getString("BED_CLASS_CODE");	
										bed_type_code =   resultSet1.getString("BED_TYPE_CODE");	
								   }
								}
							}
							pstmt_insert_disp_hrd_tmp.setString(count,sequence_no);
							pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("facility_id"));
							pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("disp_locn_code"));
							pstmt_insert_disp_hrd_tmp.setString(++count,order_id);
							pstmt_insert_disp_hrd_tmp.setString(++count,"");
							pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("ordering_facility_id"));
							pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("ord_date_time"));
							pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("patient_id"));
							pstmt_insert_disp_hrd_tmp.setString(++count,encounter_id);
							pstmt_insert_disp_hrd_tmp.setString(++count,patient_class.trim());	
							pstmt_insert_disp_hrd_tmp.setString(++count,source_type);
							pstmt_insert_disp_hrd_tmp.setString(++count,source_code);
							pstmt_insert_disp_hrd_tmp.setString(++count,"");	// SPECIALITY_CODE
							pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("performing_pract_id"));
							pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("performing_pract_id"));
							//pstmt_insert_disp_hrd_tmp.setString(++count,"");
							pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("login_by_id"));
							pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("login_at_ws_no"));
							pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("facility_id"));
							pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("login_by_id"));
							pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("login_at_ws_no"));
							pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("facility_id"));
							pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("FillPersonName"));

							//pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("func_role_id"));	
							pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("login_by_id"));	// Modified for RUT-SCF-0274 IN039740
							pstmt_insert_disp_hrd_tmp.setString(++count,trx_seq_no);										
							pstmt_insert_disp_hrd_tmp.setString(++count,sDailySeqNo);
							if(sTokenYN!=null && sTokenYN.equals("Y")){
								//sTokenNo =  hmTokenVals.get(order_id)==null?"":(String)hmTokenVals.get(order_id);	
								strTokenTemp =  ((String)hmTokenVals.get(order_id)).split("_");//Changed for HSA-CRF-0136 [IN:048412]
								sTokenSeriesCode = strTokenTemp[0];//Added for HSA-CRF-0136 [IN:048412]
								sTokenNo = strTokenTemp[1];	//Added for HSA-CRF-0136 [IN:048412]
							}
							pstmt_insert_disp_hrd_tmp.setString(++count,sTokenNo);
							pstmt_insert_disp_hrd_tmp.setString(++count,sTokenSeriesCode);	
							pstmt_insert_disp_hrd_tmp.setString(++count,"");
							pstmt_insert_disp_hrd_tmp.setString(++count,"");
							if(patient_class.equals("IP") && tabData.get("fill_list")!= null && tabData.get("fill_list").toString().equals("WF")){
								pstmt_insert_disp_hrd_tmp.setString(++count,room_num);
								pstmt_insert_disp_hrd_tmp.setString(++count,bed_num);
								pstmt_insert_disp_hrd_tmp.setString(++count,bed_class_code);
								pstmt_insert_disp_hrd_tmp.setString(++count,bed_type_code);
							}
							else{
								pstmt_insert_disp_hrd_tmp.setString(++count,"");
								pstmt_insert_disp_hrd_tmp.setString(++count,"");
								pstmt_insert_disp_hrd_tmp.setString(++count,"");
								pstmt_insert_disp_hrd_tmp.setString(++count,"");
							}
							pstmt_insert_disp_hrd_tmp.addBatch();					
							//ended.......
						}
					}
				 }
			}
			// Charles ------------- end -----------
			int[] result4	=pstmt_insert_disp_hrd_tmp.executeBatch();
			for (int i=0;i<result4.length ;i++ ){
				if(result4[i]<0  && result4[i] != -2 ){
					pstmt_insert_disp_hrd_tmp.cancel();
					connection.rollback();
					throw new EJBException("Error: Hdr tmp insert Failed");
				}		
			}
		}
		catch(Exception e){
			System.err.println("HDR_TMP INSERTION FAILED tabData="+tabData);
			e.printStackTrace();
			throw new EJBException("Error: HDR_TMP INSERTION FAILED");
		}
		finally{	
			try {
				closeStatement( pstmt_insert_disp_hrd_tmp ) ;
				//closeStatement( pstmt_select_order_line_ph );
				closeStatement(pstmt_select_disp_hdr_tmp1);//added for The PreparedStatement object "pstmt_select_disp_hdr_tmp1" is not closed. from checkstyle
				closeStatement(pstmt_select_disp_hdr_tmp);
				closeStatement(pstmt_select_order_line_cunt); //added for AAKH-SCF-0504
				closeResultSet( resultSet );
				pstmt_insert_disp_hrd_tmp  =null;
				//pstmt_select_order_line_ph =null;
				pstmt_select_disp_hdr_tmp  =null;
				resultSet				   =null;
			}
			catch(Exception es) { 
				es.printStackTrace();
				throw es;
			}
		}
		tabData.remove("FillPersonName");
		return seq_no;
	}

	private HashMap insertDetailTMP(Connection connection, HashMap sqlMap, HashMap tabData,ArrayList dispTMP, HashMap seq_no, HashMap stock_srl) throws Exception{
		PreparedStatement pstmt_insert_disp_dtl_tmp	= null;
		PreparedStatement pstmt_int					= null;
		PreparedStatement pstmt_int_1				= null;
		PreparedStatement pstmt						= null;
		PreparedStatement pstmt_1					= null;  //newly added
		PreparedStatement pstmt1					= null;
		PreparedStatement pstmt_disp_dtl_tmp_select	= null;
		PreparedStatement pstmt_pres_remark_select  = null;
		PreparedStatement pstmt_pres_remark_select_1= null;
		PreparedStatement pstmt_prsc_drug_select	= null;
	    PreparedStatement	pstmt_ind                =null;
	//	PreparedStatement	pstmt_ind_alt                =null;Unused local variable INC63877

		int count						=	 1;
		int jj							=	 1;
		int tmp_no						=	 1;
		int tmp_srl_cnt					=	 1;
		String prev_order_id			=	 "";
		String fillcode					=    "";
		String fillremarks				=    "";
		String delivery_code			=	 "";
		String delivery_remarks			=	 "";
		String allocate_code			=	 "";
		String allocate_remarks			=	 "";
		HashMap	fillingRemarks			=   (HashMap)tabData.get("fillingRemarks");
		HashMap deliveryRemarks			=   (HashMap)tabData.get("deliveryRemarks");
		HashMap allocateRemarks			=   (HashMap)tabData.get("allocatefill_remarks");
		HashMap editLabel				=   (HashMap)tabData.get("editLabel");
		String order_id					=   "";
		String order_line_num			=   "";
		HashMap alloc_bms_chk	        =  (HashMap)tabData.get("alloc_bms_chk");
		String LanguageId				=   (String)tabData.get("LanguageId");	
		ResultSet resultSet				=   null;
		ResultSet resultSet1			=   null;
		ResultSet resultSet2			=   null;
		ArrayList instructions_res		=   new ArrayList();
		ArrayList instructions			=   new ArrayList();
		HashMap bl_reasons				=   (HashMap)tabData.get("BL_REASONS");
		HashMap bl_det					=	new HashMap();
		String bl_override_rason		=	"";	
		String bl_inc_exec				=	"";	
		String patient_id				=	(String)tabData.get("patient_id");
		String billing_interface_yn	    =	(String)tabData.get("billing_interface_yn");
		String pres_remark				=	"";
		ArrayList  lang_ids             = new ArrayList();
		ArrayList	temp                = new ArrayList();
		ArrayList caution				= new ArrayList();
		ArrayList special				= new ArrayList();
		ArrayList pat_int				= new ArrayList();
		String caution_1				= "";	
		String special_1				= "";	
		String patient_int				= "";
		String loc_caution_1			= "";
		String loc_special_1			= "";	
		String loc_patient_int			= "";
		//String label_bms_remarks_code   ="";
		//String cer_res_no			    = "";
		HashMap issue_uom_dtl			= new HashMap();
		HashMap disp_tmp_srl_no			= new HashMap();
		String sDailySeqNo				= (String)tabData.get("DailySeqNo");
		HashMap hmBMSValues				= (HashMap)tabData.get("BMSValues");
		HashMap charge_dtls				= (HashMap)tabData.get("CHARGE_DTLS");
		String  drug_indication="";
		String alt_drugIndication="";
		HashMap editableLabel			= tabData.get("editableLabel")!=null?(HashMap)tabData.get("editableLabel"):null; // Added for Bru-HIMS-CRF-414 [IN:045554]
		String allow_edit_disp_label	= tabData.get("allow_edit_disp_label")!=null?(String)tabData.get("allow_edit_disp_label"):""; 
		//String editableLabelLangId	= tabData.get("editableLabelLangId")!=null?(String)tabData.get("editableLabelLangId"):"en"; //Commented for COMMON-ICN-0048
		HashMap nonPrefernceRemarks =  (HashMap)tabData.get("nonPrefernceRemarks"); //GHL-CRF-0619
		PreparedStatement pstmt_disp_label_select_disp_dtl	= null;
		PreparedStatement pstmt_disp_label_select_count	= null;
		PreparedStatement pstmtDispLabelInsert	= null;
		PreparedStatement pstmtDispLabelUpdate	= null;
		PreparedStatement pstmt_disp_label_dtl_tmp_prev_insert	= null;
		PreparedStatement pstmt_disp_label_delete	= null;
		ResultSet rsDispDtl	= null, rsLablCount=null ;
		List lEditLabelKeys = null;
		String strLblTempKey="", strLabelLangTmp="";
		String non_preferable_remarks = "";//GHL-CRF-0619

		if(allow_edit_disp_label.equals("Y") && editableLabel!=null && editableLabel.size()>0){ //if block Added for Bru-HIMS-CRF-414 [IN:045554]
			pstmt_disp_label_select_disp_dtl	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_LABEL_SELECT_DISP_DTL") ) ;
			pstmt_disp_label_select_count	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_LABEL_SELECT_COUNT") ) ;
			pstmtDispLabelInsert	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_LABEL_INSERT") ) ;
			pstmtDispLabelUpdate	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_LABEL_UPDATE") ) ;
			pstmt_disp_label_dtl_tmp_prev_insert	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_LABEL_DTL_TMP_PREV_INSERT") ) ;
			pstmt_disp_label_delete	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_LABEL_DELETE") ) ; // Added for Bru-HIMS-CRF-414 [IN:045554]
		}
		int insertCount = 0, updateCount=0, icount=1,iLblCount	=0, iPrevLblCount=0;
		ArrayList alLabelDtl = null;
		HashMap hshDispNoOld	=  (HashMap)tabData.get("hshdispno_old");
		String disp_no="", disp_srl_no="", sKey1="", dispQty="", /*oldLblLangId="",*/dispsrlno_old="", tempDisp="",dispno_old="";//removed 'oldLblLangId'="" ,oldKey="" Unused local variable INC63877. //Commented oldLblLangId for COMMON-ICN-0048
		// Added for Bru-HIMS-CRF-414 [IN:045554] -end
		ArrayList edit_result	= null, result=null, essentialReimberse=null;//for inserting cautions and special instructions.....	
		String drugIndication="", cer_res_no="";
		String sql_query ="select DRUG_INDICATION from or_order_line_ph where order_id=? and order_line_num=?"; 

		if(tabData.containsKey("ISSUE_UOM_QTY")){
			 issue_uom_dtl =(HashMap)tabData.get("ISSUE_UOM_QTY");
		 }
		 HashMap approvalNo = (HashMap)tabData.get("approvalNo");//AAKH-CRF-0117
		 String approval_no = ""; //AAKH-CRF-0117

		try {
			pstmt						= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDI_EDIT_INSTRUCTIONS")) ;	
			pstmt_1						= connection.prepareStatement("SELECT B.CAUTION_LABEL_TEXT_ID_1,B.CAUTION_LABEL_TEXT_ID_2, B.SPL_INSTR_LABEL_TEXT_ID,B.SPL_INSTR_LABEL_TEXT_ID1,B.HOW_TO_TAKE_TEXT,B.HOW_TO_TAKE_TEXT_LOCAL,B.DRUG_INDICATION FROM PH_DRUG_LANG_VW B, OR_ORDER_LINE C WHERE B.DRUG_CODE=? AND C.ORDER_ID=? AND C.ORDER_LINE_NUM=?  AND B.LANGUAGE_ID = ?");//Added B.DRUG_INDICATION to display the AlternateDrugIndication in EditLabel
			//pstmt_int					= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDI_EDIT_INT_RESULTS")) ;
			pstmt_int		            = connection.prepareStatement("SELECT LABEL_TEXT_ID, LABEL_TEXT_1, language_id FROM PH_LABEL_TEXT_LANG_VW PH_LABEL_TEXT WHERE LABEL_TEXT_ID=? and rownum<3 "); //LABEL_TEXT_ID added for HSA-CRF-0178/04 All Stages Label [IN:052990]
			pstmt_int_1                 = connection.prepareStatement("select HOW_TO_TAKE_TEXT from ph_drug_lang_vw where drug_code =? and language_id=?");
			pstmt_insert_disp_dtl_tmp= connection.prepareStatement((String)sqlMap.get("SQL_PH_DISP_MEDICATION_DISP_DTL_TMP_INSERT")) ;
			System.out.println("4746 pstmt_insert_disp_dtl_tmp"+pstmt_insert_disp_dtl_tmp);
			pstmt_disp_dtl_tmp_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT150")) ;
			pstmt_pres_remark_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT159"));
			pstmt_pres_remark_select_1  = connection.prepareStatement((String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT160")); 
			pstmt1						= connection.prepareStatement("select language_id  from sm_language where  eff_status='E'  and PRIMARY_LANG_YN ='N' order by seq_no");
			pstmt_prsc_drug_select		= connection.prepareStatement((String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT162")) ;

			int cnt	        = 0;
			int iTotalOrders			= dispTMP.size()/7;	
			int iOrdercount				= 1;

			HashMap hmDailySeqNo		= null;
			String  sDSNReferenceNos	=  null;

			if(tabData.get("fill_list")!= null && tabData.get("fill_list").toString().equals("AF")){
				hmDailySeqNo = tabData.get("hmDailySeqNumbers")!=null?(HashMap)tabData.get("hmDailySeqNumbers"):null;
			}
			String sOrderId				= "", key, key1;
			String sOrderLineNo			= "";
			String cer_res_yn           ="N";
			String alt_drug_remarks="",altdrugKey;
			HashMap hmAltDrugRemarks	=  (HashMap)tabData.get("ALTDRUGREMARKS");
			for(int i=0;i<dispTMP.size();i=i+7){ 
				sOrderId				= dispTMP.get(i).toString().trim();
				sOrderLineNo			= dispTMP.get(i+1).toString().trim();

				sDSNReferenceNos	=  null;
				//code added on 17/4/2004 for Fillings
				key	=	sOrderId+"_"+sOrderLineNo;
				key1	=	sOrderId+"_"+((String)dispTMP.get(i+3)).trim()+"_"+sOrderLineNo;  //newly added for ML-BRU-SCF-0179 [IN:032578]
				altdrugKey = sOrderId+"~"+sOrderLineNo; //Added for  Bru-HIMS-CRF-082 [IN:029948]
				if(hmAltDrugRemarks !=null && hmAltDrugRemarks.containsKey(altdrugKey))
					alt_drug_remarks = (String)hmAltDrugRemarks.get(altdrugKey);
				else
					alt_drug_remarks="";

				if(fillingRemarks.containsKey(key)) {
					result	= (ArrayList)fillingRemarks.get(key);
					fillcode			= (String)result.get(1);
					fillremarks			= (String)result.get(2);
				}
				else{
					fillcode			= "";
					fillremarks			= "";
				}

				if(deliveryRemarks.containsKey(key)) {
					result	= (ArrayList)deliveryRemarks.get(key);
					delivery_code		= (String)result.get(1);
					delivery_remarks	= (String)result.get(2);
				}
				else{
					delivery_code		= "";
					delivery_remarks	= "";
				}
				if(allocateRemarks.containsKey(key)) {
					result	= (ArrayList)allocateRemarks.get(key);
					allocate_code		= (String)result.get(1);
					allocate_remarks	= (String)result.get(2);
				}
				else{
					allocate_code		= "";
					allocate_remarks	= "";
				}//ended...
	//			ArrayList batchDetails	= (ArrayList)dispTMP.get(i+6);
	//			item_code				=	(String)batchDetails.get(0);
				count					= 1;

				if(!prev_order_id.equals(((String)dispTMP.get(i)).trim())){
					pstmt_disp_dtl_tmp_select.setString(1,((String)dispTMP.get(i)).trim());	
					pstmt_disp_dtl_tmp_select.setString(2,(String)seq_no.get(((String)dispTMP.get(i)).trim()));
					
					resultSet	= pstmt_disp_dtl_tmp_select.executeQuery() ;
					if (resultSet!=null && resultSet.next()){
						jj  = (resultSet.getInt("DTL_SERIAL_NUM"))+1;
					}
					else{ 
						jj	=	1;
					}
				}

				prev_order_id			=	((String)dispTMP.get(i)).trim();
				tmp_no					=	(jj++);
				disp_no=(String)seq_no.get(((String)dispTMP.get(i)).trim()); // Added for Bru-HIMS-CRF-414 [IN:045554]
				disp_srl_no =tmp_no+""; // Added for Bru-HIMS-CRF-414 [IN:045554]
				disp_tmp_srl_no.put(prev_order_id,tmp_no+""); // added For alloc_bms_zero charles.
				stock_srl.put(sOrderId+sOrderLineNo,(String)seq_no.get(((String)dispTMP.get(i)).trim())+"~"+tmp_no);//Added for Bru-HIMS-CRF-072.1[IN 049144]
				pstmt_insert_disp_dtl_tmp.setString(count,(String)seq_no.get(((String)dispTMP.get(i)).trim()));	//DISP_TMP_NO
				pstmt_insert_disp_dtl_tmp.setString(++count,tmp_no+"");							//DTL_SERIAL_NUM
				pstmt_insert_disp_dtl_tmp.setString(++count,(String)tabData.get("facility_id"));					//FACILITY_ID
				pstmt_insert_disp_dtl_tmp.setString(++count,(String)tabData.get("disp_locn_code"));				//DISP_LOCN_CODE

				pstmt_insert_disp_dtl_tmp.setString(++count,sOrderId);	//ORDER_ID
				pstmt_insert_disp_dtl_tmp.setString(++count,sOrderLineNo);	//ORDER_LINE_NO

				if(hmDailySeqNo!=null){ // In case of fill against fill list, the old reference number should be replaced
					sDSNReferenceNos =(String) hmDailySeqNo.get(dispTMP.get(i).toString().trim()+"~"+dispTMP.get(i+1).toString().trim());
					if(sDSNReferenceNos!=null)
						sDSNReferenceNos = sDSNReferenceNos.split("~")[1];
				}

				cer_res_yn           ="N";
				 if(getCustomerID(connection).equals("SRR")){
					 essentialReimberse = getEssentialItemYN(connection,((String)dispTMP.get(i+3)).trim());
					if(essentialReimberse!=null && essentialReimberse.size()>1){
						if(((String)essentialReimberse.get(0)).equals("N") && ((String) essentialReimberse.get(1)).equals("Y")){
							if(charge_dtls.containsKey(sOrderId+sOrderLineNo+(String)dispTMP.get(i+3))){
								if((Float.parseFloat((String)charge_dtls.get(sOrderId+sOrderLineNo+(String)dispTMP.get(i+3))))>0){
									if(!tabData.containsKey("CER_RES_NO")){
										cer_res_no = (String)GenerateCerRemNO(connection);
										tabData.put("CER_RES_NO",cer_res_no);
									}
									cer_res_yn           ="Y";
								}
							}
						}
					}
				}

				pstmt_insert_disp_dtl_tmp.setString(++count,((String)dispTMP.get(i+2)).trim());	//PRES_DRUG_CODE
				pstmt_insert_disp_dtl_tmp.setString(++count,(String)tabData.get("ordering_facility_id"));		//ORDERING_FACILITY_ID
				pstmt_insert_disp_dtl_tmp.setString(++count,((String)dispTMP.get(i+3)).trim());	//DISP_DRUG_CODE
				pstmt_insert_disp_dtl_tmp.setString(++count,((String)dispTMP.get(i+4)).trim());	//DISP_QTY
				pstmt_insert_disp_dtl_tmp.setString(++count,((String)dispTMP.get(i+5)).trim());	//DISP_UOM_CODE
				pstmt_insert_disp_dtl_tmp.setString(++count,(String)tabData.get("login_by_id"));
				pstmt_insert_disp_dtl_tmp.setString(++count,(String)tabData.get("login_at_ws_no"));
				pstmt_insert_disp_dtl_tmp.setString(++count,(String)tabData.get("facility_id"));
				pstmt_insert_disp_dtl_tmp.setString(++count,(String)tabData.get("login_by_id"));
				pstmt_insert_disp_dtl_tmp.setString(++count,(String)tabData.get("login_at_ws_no"));
				pstmt_insert_disp_dtl_tmp.setString(++count,(String)tabData.get("facility_id"));
				if(stock_srl.containsKey(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1))+((String)dispTMP.get(i+3)).trim().trim())){
					pstmt_insert_disp_dtl_tmp.setString(++count,(String)stock_srl.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim()));
				}
				else {
					stock_srl.put(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim(),tmp_srl_cnt+"");
					pstmt_insert_disp_dtl_tmp.setString(++count,tmp_srl_cnt+"");
				}//code on 17/4/004 for fillings
				pstmt_insert_disp_dtl_tmp.setString(++count,fillcode);//for filling code and remarks....
				pstmt_insert_disp_dtl_tmp.setString(++count,fillremarks);// filling ended..

				drugIndication="";
				if(editLabel!=null && editLabel.containsKey(key1)) 			//changed key to key1 for ML-BRU-SCF-0179 [IN:032578]	
					edit_result =(ArrayList)editLabel.get(key1); //changed key to key1 for ML-BRU-SCF-0179 [IN:032578]
				//Added for ML-MMOH-SCF-2401 start
				else{
					key1	=	sOrderId+"_"+((String)dispTMP.get(i+2)).trim()+"_"+sOrderLineNo;
					if(editLabel!=null && editLabel.containsKey(key1)){
						edit_result =(ArrayList)editLabel.get(key1);
					}
				}//Added for ML-MMOH-SCF-2401 end
				if(edit_result!=null && edit_result.size()!=0){
					pstmt_insert_disp_dtl_tmp.setString(++count,(String)edit_result.get(0));
					pstmt_insert_disp_dtl_tmp.setString(++count,(String)edit_result.get(1));
					pstmt_insert_disp_dtl_tmp.setString(++count,(String)edit_result.get(2));
					pstmt_insert_disp_dtl_tmp.setString(++count,(String)edit_result.get(3));
					pstmt_insert_disp_dtl_tmp.setString(++count,(String)edit_result.get(4));
					pstmt_insert_disp_dtl_tmp.setString(++count,(String)edit_result.get(5));
					pstmt_insert_disp_dtl_tmp.setString(++count,(String)edit_result.get(6));
					pstmt_insert_disp_dtl_tmp.setString(++count,(String)edit_result.get(7));
					pstmt_insert_disp_dtl_tmp.setString(++count,(String)edit_result.get(8));
					pstmt_insert_disp_dtl_tmp.setString(++count,(String)edit_result.get(9));
					drugIndication = (String)edit_result.get(11);//Added DRUG_INDICATION for  ML-BRU-CRF-072[Inc:29938]
					//pstmt_insert_disp_dtl_tmp.setString(++count,(String)edit_result.get(10));
				} 
				else {
					if(((String)dispTMP.get(i+2)).trim().equals(((String)dispTMP.get(i+3)).trim())){
						pstmt.setString(1,(((String)dispTMP.get(i+3)).trim()));
						pstmt.setString(2,(((String)dispTMP.get(i+3)).trim()));
						pstmt.setString(3,(((String)dispTMP.get(i)).trim()));
						pstmt.setString(4,(((String)dispTMP.get(i+1)).trim()));
						pstmt.setString(5,LanguageId);
						resultSet	= pstmt.executeQuery() ;
					}
					else{
						pstmt_1.setString(1,(((String)dispTMP.get(i+3)).trim()));
						pstmt_1.setString(2,(((String)dispTMP.get(i)).trim()));
						pstmt_1.setString(3,(((String)dispTMP.get(i+1)).trim()));
						pstmt_1.setString(4,LanguageId);
						resultSet	= pstmt_1.executeQuery() ;
					}
					while (resultSet.next()){
						instructions_res.add(resultSet.getString("CAUTION_LABEL_TEXT_ID_1")+"");
						instructions_res.add(resultSet.getString("SPL_INSTR_LABEL_TEXT_ID")+"");
						instructions_res.add(resultSet.getString("HOW_TO_TAKE_TEXT")+"");										
						alt_drugIndication =(resultSet.getString("DRUG_INDICATION")==null?"":resultSet.getString("DRUG_INDICATION")+"");//Added DRUG_INDICATION to display the AlternateDrugIndication in EditLabel
					}
					caution_1				= ".";  
					special_1				= ".";
					patient_int				= ".";//removed . for ARYU-SCF-0176 and reverted for GHL-ICN-0038
					loc_caution_1			= ".";
					loc_special_1			= ".";
					loc_patient_int			= ".";//removed . for ARYU-SCF-0176 and reverted for GHL-ICN-0038
					if(instructions_res.size() > 0){
						for(int k=0;k<2;k++){
							if( (!( (((String)instructions_res.get(k))==null) || ( ((String)instructions_res.get(k)).equals("")  ) ))){	
								resultSet		= null;
								pstmt_int.setString(1,(String)instructions_res.get(k));
								//pstmt_int.setString(2,getLanguageId());
								resultSet	= pstmt_int.executeQuery() ;
								temp			= new ArrayList();
								lang_ids        = new ArrayList();
								while (resultSet.next()){							
									//temp.add((String)resultSet.getString("LABEL_TEXT_1"));//commented for HSA-CRF-0178/04 All Stages Label [IN:052990]	
									temp.add((String)resultSet.getString("LABEL_TEXT_ID"));	// added for HSA-CRF-0178/04 All Stages Label [IN:052990]
									temp.add((String)resultSet.getString("language_id"));	
									temp.add((String)resultSet.getString("LABEL_TEXT_1"));//Moved from index 0 to 2 for HSA-CRF-0178/04 All Stages Label [IN:052990]
									lang_ids.add(resultSet.getString("language_id"));
								}
								instructions.add(temp);
							}
							else{
								temp = new ArrayList();
								instructions.add(temp);
							}              
							//tempString = (String)instructions_res.get(i);
						}
						temp = new ArrayList();
						//pstmt_int		= connection.prepareStatement("select HOW_TO_TAKE_TEXT from ph_drug_lang_vw where drug_code =? and language_id=?");
						if(lang_ids.size() == 0){	
							lang_ids.add(LanguageId);
							 resultSet	= pstmt1.executeQuery() ;
							 if(resultSet.next()){
								lang_ids.add((String)resultSet.getString("language_id"));
							}
						}
						for(int k=0;k<lang_ids.size();k++){				  
							resultSet		= null;
							pstmt_int_1.setString(1,(((String)dispTMP.get(i+3)).trim()));
							pstmt_int_1.setString(2,(String)lang_ids.get(k));
							resultSet	= pstmt_int_1.executeQuery() ;
							while (resultSet.next()){							
								temp.add((String)resultSet.getString("HOW_TO_TAKE_TEXT"));
								temp.add((String)lang_ids.get(k));
							}
						}
						//temp.add(instructions_res.get(2));
						//  temp.add(instructions_res.get(5));
						instructions.add(temp);
						caution	= (ArrayList)instructions.get(0);
						if(caution.size()>0){	
							for(int m=0;m<caution.size();m+=3){ //size increased from 2 to 3 HSA-CRF-0178/04 All Stages Label [IN:052990]
								if(caution.get(m+1).equals("en")){
									 caution_1		= (String)instructions_res.get(0)==null?".":(String)instructions_res.get(0);	// replaced caution.get(m) with instructions_res.get(0)
								}
								else{
									 loc_caution_1	= (String)caution.get(m+2)==null?".":(String)caution.get(m+2); //changed from m to m+2HSA-CRF-0178/04 All Stages Label [IN:052990]
								}
							}
						}
						special			= (ArrayList)instructions.get(1);
						if(special.size()>0){
							for(int m=0;m<special.size();m+=3){ //size increased from 2 to 3 HSA-CRF-0178/04 All Stages Label [IN:052990]
								if(special.get(m+1).equals("en")){
									special_1		= (String)instructions_res.get(1)==null?".":(String)instructions_res.get(1);
									// replaced caution.get(m) with instructions_res.get(1)
								}
								else{
									loc_special_1	= (String)special.get(m+2)==null?".":(String)special.get(m+2); //changed from m to m+2HSA-CRF-0178/04 All Stages Label [IN:052990]
								}
							}
					   }
						pat_int =   (ArrayList)instructions.get(2);
						if(pat_int.size()>0){						  
							for(int m=0;m<pat_int.size();m+=2){
								if(pat_int.get(m+1).equals("en")){
									patient_int		= (String)pat_int.get(m)==null?".":(String)pat_int.get(m);//removed . for ARYU-SCF-0176 and reverted for GHL-ICN-0038
								 }
								 else{
									loc_patient_int	= (String)pat_int.get(m)==null?".":(String)pat_int.get(m);//removed . for ARYU-SCF-0176 and reverted for GHL-ICN-0038
								 }
							}
						}
						 // //Added below code to display the AlternateDrugIndication in EditLabel Start
						if(((String)dispTMP.get(i+2)).trim().equals(((String)dispTMP.get(i+3)).trim())){
							pstmt_ind		= connection.prepareStatement(sql_query) ;
							pstmt_ind.setString(1,sOrderId);
							pstmt_ind.setString(2,sOrderLineNo);
							resultSet			=   pstmt_ind.executeQuery();
							if( resultSet != null && resultSet.next() ) {
								if(resultSet.getString("DRUG_INDICATION")!=null) {
									drug_indication=resultSet.getString("DRUG_INDICATION");
								}
							}
							drugIndication = drug_indication;
						}
						else{
							drugIndication =alt_drugIndication;
						}
					}//Added above code to display the AlternateDrugIndication in EditLabel End
					instructions		= new ArrayList();
					instructions_res 	= new ArrayList();
					pstmt_insert_disp_dtl_tmp.setString(++count,caution_1);
					pstmt_insert_disp_dtl_tmp.setString(++count,"");
					pstmt_insert_disp_dtl_tmp.setString(++count,special_1);
					pstmt_insert_disp_dtl_tmp.setString(++count,"");
					pstmt_insert_disp_dtl_tmp.setString(++count,patient_int);
					pstmt_insert_disp_dtl_tmp.setString(++count,loc_caution_1);
					pstmt_insert_disp_dtl_tmp.setString(++count,"");
					pstmt_insert_disp_dtl_tmp.setString(++count,loc_special_1);
					pstmt_insert_disp_dtl_tmp.setString(++count,"");
					pstmt_insert_disp_dtl_tmp.setString(++count,loc_patient_int);
				}
				pstmt_insert_disp_dtl_tmp.setString(++count,delivery_code);
				pstmt_insert_disp_dtl_tmp.setString(++count,delivery_remarks);
				pstmt_insert_disp_dtl_tmp.setString(++count,allocate_code);
				pstmt_insert_disp_dtl_tmp.setString(++count,allocate_remarks);

				if(billing_interface_yn.equals("Y")){//code added for bl interface
					if(bl_reasons.containsKey(patient_id+((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim())){
						bl_det=(HashMap) bl_reasons.get(patient_id+((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim());
					}
					else{
						bl_det           = new HashMap();	
					}
					if(bl_det.size()>0){
						bl_override_rason =(String)bl_det.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE");
						bl_inc_exec	      =(String)bl_det.get("BL_EXCL_INCL_IND");
					}
				}
				else{
					bl_override_rason ="";
					bl_inc_exec	      ="";
				}
				pstmt_insert_disp_dtl_tmp.setString(++count,bl_inc_exec);
				pstmt_insert_disp_dtl_tmp.setString(++count,bl_override_rason);

				pres_remark    ="";
				if(edit_result!=null && edit_result.size()!=0){
					if(!edit_result.get(10).equals("")){
						pres_remark    =    (String)edit_result.get(10);
				   }
			   }
			   if(pres_remark.equals("")){
					pstmt_pres_remark_select_1.setString(1,((String)dispTMP.get(i+3)).trim());
					pstmt_pres_remark_select_1.setString(2,((String)dispTMP.get(i+3)).trim());
					pstmt_pres_remark_select_1.setString(3,(String)tabData.get("LanguageId"));//Added for ICN:34205
					if (resultSet!=null && resultSet.next()){
						pres_remark = resultSet2.getString("ORDER_LINE_FIELD_VALUE");
					}
				} 
				if(pres_remark.equals("")){  
					pstmt_pres_remark_select.setString(1,((String)dispTMP.get(i+3)).trim());
					resultSet1	= pstmt_pres_remark_select.executeQuery() ;
					if (resultSet!=null && resultSet.next()){
						pres_remark = resultSet1.getString("REMARK_CODE");
					}
					closeResultSet(resultSet1);
			   }
			   pstmt_insert_disp_dtl_tmp.setString(++count,pres_remark);
			   // pstmt_insert_disp_dtl_tmp.setString(++count,(String)tabData.get("DRUG_INDICATION"));//Added DRUG_INDICATION for  ML-BRU-CRF-072[Inc:29938]
			   if(issue_uom_dtl.containsKey(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim()+"_qty")){
					pstmt_insert_disp_dtl_tmp.setString(++count,(String)issue_uom_dtl.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim()+"_qty"));
					pstmt_insert_disp_dtl_tmp.setString(++count,(String)issue_uom_dtl.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim()+"_uom"));
				}
				else{
					pstmt_insert_disp_dtl_tmp.setString(++count,"");	
					pstmt_insert_disp_dtl_tmp.setString(++count,"");	
				}//inserting cautions and special instructions..... ended......

				if(sDSNReferenceNos != null)
					pstmt_insert_disp_dtl_tmp.setString(++count,sDSNReferenceNos);
				else if(!sDailySeqNo.equals(""))
					pstmt_insert_disp_dtl_tmp.setString(++count,iOrdercount+"/"+iTotalOrders);	//Daily Sequence number reference
				else
					pstmt_insert_disp_dtl_tmp.setString(++count,"");

				if(hmBMSValues!=null && hmBMSValues.get(sOrderId+"~"+sOrderLineNo)!=null)
					pstmt_insert_disp_dtl_tmp.setString(++count,(String)hmBMSValues.get(sOrderId+"~"+sOrderLineNo));
				else
					pstmt_insert_disp_dtl_tmp.setString(++count,"0");

				pstmt_insert_disp_dtl_tmp.setString(++count,cer_res_yn);//Certificate for reimbursement YN
				//if(drugIndication ==null && drugIndication.equals(""))
				//drugIndication = (String)tabData.get("DRUG_INDICATION");
				pstmt_insert_disp_dtl_tmp.setString(++count,drugIndication);//Added for  ML-BRU-CRF-072[Inc:29938]
				pstmt_insert_disp_dtl_tmp.setString(++count,alt_drug_remarks);//Added for  Bru-HIMS-CRF-082 [IN:029948]
				//Daily Sequence number reference
				pstmt_insert_disp_dtl_tmp.setString(++count,tabData.get("print_seq_no_tmp").toString());//PRINT_SEQ_NO Added for RUT-CRF-0061
System.err.println("dispTMP====>"+dispTMP+"==dispTMP==>"+dispTMP.get(i+3));
				//AAKH-CRF-0117 - start
				if(approvalNo!=null && approvalNo.size()>0)
					approval_no = (String)approvalNo.get(sOrderId+sOrderLineNo);

				if(approval_no==null)
					approval_no = "";
			//GHL-CRF-0619 - start
				non_preferable_remarks =""; 
				if(nonPrefernceRemarks!=null && nonPrefernceRemarks.size()>0){
				non_preferable_remarks = (String)nonPrefernceRemarks.get(sOrderId+sOrderLineNo+((String)dispTMP.get(i+3)).trim());
				}
				if(non_preferable_remarks==null)
				non_preferable_remarks = "";
			//GHL-CRF-0619 - end
System.err.println("approval_no=====>"+approval_no+"==count===>"+count+"=non_preferable_remarks===>"+non_preferable_remarks);
				pstmt_insert_disp_dtl_tmp.setString(++count,approval_no);
				pstmt_insert_disp_dtl_tmp.setString(++count,non_preferable_remarks);//GHL-CRF-0619
				pstmt_insert_disp_dtl_tmp.addBatch();			
				cnt++;
				tmp_srl_cnt++;
				iOrdercount++;
				if(allow_edit_disp_label.equals("Y") && editableLabel!=null && editableLabel.size()>0){ //if block Added for Bru-HIMS-CRF-414 [IN:045554]
					//sKey1 =	((String)dispTMP.get(i)).trim()+"_"+((String)dispTMP.get(i+3)).trim()+"_"+((String)dispTMP.get(i+1)).trim()+"_"+editableLabelLangId;
					sKey1 =	((String)dispTMP.get(i)).trim()+"_"+((String)dispTMP.get(i+3)).trim()+"_"+((String)dispTMP.get(i+1)).trim();
					lEditLabelKeys = new ArrayList(editableLabel.keySet());
					for(int ilcount=0; ilcount<lEditLabelKeys.size(); ilcount++){
						strLblTempKey= (String)lEditLabelKeys.get(ilcount);
						strLabelLangTmp = strLblTempKey.substring(strLblTempKey.lastIndexOf("_")+1);
						if((strLblTempKey.substring(0,strLblTempKey.lastIndexOf("_"))).equals(sKey1)){
							iLblCount	=	0;
							icount=1;
							if(hshDispNoOld != null && hshDispNoOld.size()>0 && hshDispNoOld.containsKey((String)dispTMP.get(i)+"~"+(String)dispTMP.get(i+1))){
								tempDisp = (String)hshDispNoOld.get((String)dispTMP.get(i)+"~"+(String)dispTMP.get(i+1));
								if(tempDisp!=null && !tempDisp.equals("")){
									icount=1;
									dispno_old = tempDisp.substring(0, tempDisp.indexOf("~"));
									dispsrlno_old = tempDisp.substring(tempDisp.indexOf("~")+1);
									pstmt_disp_label_dtl_tmp_prev_insert.setString(icount++,((String)tabData.get("facility_id")).trim()); 
									pstmt_disp_label_dtl_tmp_prev_insert.setString(icount++, disp_no);
									pstmt_disp_label_dtl_tmp_prev_insert.setString(icount++ ,disp_srl_no);
									pstmt_disp_label_dtl_tmp_prev_insert.setString(icount++,(String)tabData.get("login_by_id"));
									pstmt_disp_label_dtl_tmp_prev_insert.setString(icount++,(String)tabData.get("login_at_ws_no"));
									pstmt_disp_label_dtl_tmp_prev_insert.setString(icount++,(String)tabData.get("facility_id"));
									pstmt_disp_label_dtl_tmp_prev_insert.setString(icount++,(String)tabData.get("login_by_id"));
									pstmt_disp_label_dtl_tmp_prev_insert.setString(icount++,(String)tabData.get("login_at_ws_no"));
									pstmt_disp_label_dtl_tmp_prev_insert.setString(icount++,(String)tabData.get("facility_id"));
									pstmt_disp_label_dtl_tmp_prev_insert.setString(icount++,(String)tabData.get("facility_id"));
									pstmt_disp_label_dtl_tmp_prev_insert.setString(icount++, dispno_old);
									pstmt_disp_label_dtl_tmp_prev_insert.setString(icount++ ,dispsrlno_old);
									pstmt_disp_label_dtl_tmp_prev_insert.setString(icount++ ,((String)dispTMP.get(i+3)).trim());
									pstmt_disp_label_dtl_tmp_prev_insert.setString(icount++ ,strLabelLangTmp);
									pstmt_disp_label_dtl_tmp_prev_insert.addBatch(); 
									iPrevLblCount++;
								}
							}

							if(editableLabel.containsKey(strLblTempKey)){
								pstmt_disp_label_select_count.setString(1,(String)tabData.get("facility_id"));
								pstmt_disp_label_select_count.setString(2, disp_no);
								pstmt_disp_label_select_count.setString(3, disp_srl_no);
								pstmt_disp_label_select_count.setString(4,strLabelLangTmp);
								rsLablCount = pstmt_disp_label_select_count.executeQuery();
								if(rsLablCount!=null && rsLablCount.next()){
									iLblCount = rsLablCount.getInt("LBLCOUNT");
								}
								closeResultSet( rsLablCount ) ;
								alLabelDtl =(ArrayList)editableLabel.get(strLblTempKey);
								if(alLabelDtl!=null && alLabelDtl.size()>0){
									dispQty = alLabelDtl.get(2)==null?"":(String)alLabelDtl.get(2);
									if(dispQty.equals(""))
										dispQty = ((String)dispTMP.get(i+4)).trim();
									if(iLblCount>0){
										icount=1;
										pstmtDispLabelUpdate.setString(icount++,(String)alLabelDtl.get(1));
										pstmtDispLabelUpdate.setString(icount++,dispQty);
										//pstmtDispLabelUpdate.setString(icount++,(String)alLabelDtl.get(3));
										pstmtDispLabelUpdate.setString(icount++,(String)alLabelDtl.get(4));
										pstmtDispLabelUpdate.setString(icount++,(String)alLabelDtl.get(5));
										pstmtDispLabelUpdate.setString(icount++,(String)alLabelDtl.get(6));
										pstmtDispLabelUpdate.setString(icount++,(String)tabData.get("login_by_id"));
										pstmtDispLabelUpdate.setString(icount++,(String)tabData.get("login_at_ws_no"));
										pstmtDispLabelUpdate.setString(icount++,(String)tabData.get("facility_id"));
										pstmtDispLabelUpdate.setString(icount++,(String)tabData.get("facility_id"));
										pstmtDispLabelUpdate.setString(icount++, disp_no);
										pstmtDispLabelUpdate.setString(icount++, disp_srl_no);
										pstmtDispLabelUpdate.setString(icount++,strLabelLangTmp);
										pstmtDispLabelUpdate.addBatch();
										updateCount++;
									}
									else{
										icount=1;
										pstmtDispLabelInsert.setString(icount++,(String)tabData.get("facility_id"));
										pstmtDispLabelInsert.setString(icount++, disp_no);
										pstmtDispLabelInsert.setString(icount++, disp_srl_no);
										pstmtDispLabelInsert.setString(icount++,strLabelLangTmp);
										pstmtDispLabelInsert.setString(icount++,(String)alLabelDtl.get(0));
										pstmtDispLabelInsert.setString(icount++,(String)alLabelDtl.get(1));
										pstmtDispLabelInsert.setString(icount++,dispQty);
										pstmtDispLabelInsert.setString(icount++,((String)dispTMP.get(i+5)).trim());//(String)alLabelDtl.get(3)
										pstmtDispLabelInsert.setString(icount++,(String)alLabelDtl.get(4));
										pstmtDispLabelInsert.setString(icount++,(String)alLabelDtl.get(5));
										pstmtDispLabelInsert.setString(icount++,(String)alLabelDtl.get(6));
										pstmtDispLabelInsert.setString(icount++,(String)tabData.get("login_by_id"));
										pstmtDispLabelInsert.setString(icount++,(String)tabData.get("login_at_ws_no"));
										pstmtDispLabelInsert.setString(icount++,(String)tabData.get("facility_id"));
										pstmtDispLabelInsert.setString(icount++,(String)tabData.get("login_by_id"));
										pstmtDispLabelInsert.setString(icount++,(String)tabData.get("login_at_ws_no"));
										pstmtDispLabelInsert.setString(icount++,(String)tabData.get("facility_id"));
										pstmtDispLabelInsert.addBatch();
										insertCount++;
									}
								}
							}
						}
					}
				}
			}	
			
			//for BMS of not allocated drugs in detail.// Charles ------------- start -----------
			if(alloc_bms_chk != null && alloc_bms_chk.size()>0){
				Set	key_set		=	alloc_bms_chk.keySet();
				Iterator itr	=	key_set.iterator();
				String order_id_line_num =  "";
				String presc_drug_code	 =  "";
				String presc_drug_uom	 =  "";
				prev_order_id			 =  "";
				tmp_no					 =	1;
				while(itr.hasNext())  {
					count		  = 1;
					order_id_line_num = (String)itr.next();

					if(alloc_bms_chk.get(order_id_line_num).equals("Y")){
						//order_id		= (String)order_id_line_num.substring(0,order_id_line_num.length()-1); // commented for ML-BRU-SCF-0390 [IN:034867]
						//order_line_num	= (String)order_id_line_num.substring(order_id_line_num.length()-1,order_id_line_num.length()); //commented ML-BRU-SCF-0390 [IN:034867]
						if(order_id_line_num.length()>=15){ //added for ML-BRU-SCF-0390 [IN:034867] - start
							order_id			= (String)order_id_line_num.substring(0,15);
							order_line_num	= (String)order_id_line_num.substring(15,order_id_line_num.length());
						}
						else
							throw new Exception("Wrong OrderId "+order_id_line_num); //added for ML-BRU-SCF-0390 [IN:034867] - end
					
						if(!disp_tmp_srl_no.containsKey(order_id)){
							if(!prev_order_id.equals(order_id)){

								pstmt_disp_dtl_tmp_select.setString(1,order_id);	
								pstmt_disp_dtl_tmp_select.setString(2,(String)seq_no.get(order_id));
								
								 resultSet	= pstmt_disp_dtl_tmp_select.executeQuery() ;
								if (resultSet!=null && resultSet.next()){
									jj  = (resultSet.getInt("DTL_SERIAL_NUM"))+1;
								}else{ 
									jj	=	1;
								}
							}
						}
						else{
							jj = Integer.parseInt((String)disp_tmp_srl_no.get(order_id))+1;
						}
						prev_order_id			=	order_id;
						tmp_no					=	(jj++);
						disp_tmp_srl_no.put(prev_order_id,tmp_no+"");
						try{
							pstmt_prsc_drug_select.setString(1,order_id);	
							pstmt_prsc_drug_select.setString(2,order_line_num);
							resultSet1	= pstmt_prsc_drug_select.executeQuery() ;
							if (resultSet1!=null && resultSet1.next()){
								presc_drug_code	 = resultSet1.getString("ORDER_CATALOG_CODE");
								presc_drug_uom	 = resultSet1.getString("ORDER_UOM");
							}
							else{ 
								presc_drug_code	 = "";
								presc_drug_uom	 = "";
							}
							closeResultSet(resultSet1);
						}
						catch(Exception ordLineEx){
							System.err.println("Error fetching values from or tabData="+tabData+" order line ---"+ordLineEx.toString());
							ordLineEx.printStackTrace();
						}

						pstmt_insert_disp_dtl_tmp.setString(count,(String)seq_no.get(order_id));	//DISP_TMP_NO
						pstmt_insert_disp_dtl_tmp.setString(++count,tmp_no+"");							//DTL_SERIAL_NUM
						pstmt_insert_disp_dtl_tmp.setString(++count,(String)tabData.get("facility_id"));					//FACILITY_ID
						pstmt_insert_disp_dtl_tmp.setString(++count,(String)tabData.get("disp_locn_code"));				//DISP_LOCN_CODE
						pstmt_insert_disp_dtl_tmp.setString(++count,order_id);	//ORDER_ID
						pstmt_insert_disp_dtl_tmp.setString(++count,order_line_num);	//ORDER_LINE_NO
						pstmt_insert_disp_dtl_tmp.setString(++count,presc_drug_code);	//PRES_DRUG_CODE
						pstmt_insert_disp_dtl_tmp.setString(++count,(String)tabData.get("facility_id"));		//ORDERING_FACILITY_ID
						pstmt_insert_disp_dtl_tmp.setString(++count,presc_drug_code);	//DISP_DRUG_CODE
						pstmt_insert_disp_dtl_tmp.setString(++count,"0");	//DISP_QTY
						pstmt_insert_disp_dtl_tmp.setString(++count,presc_drug_uom);	//DISP_UOM_CODE
						pstmt_insert_disp_dtl_tmp.setString(++count,(String)tabData.get("login_by_id"));
						pstmt_insert_disp_dtl_tmp.setString(++count,(String)tabData.get("login_at_ws_no"));
						pstmt_insert_disp_dtl_tmp.setString(++count,(String)tabData.get("facility_id"));
						pstmt_insert_disp_dtl_tmp.setString(++count,(String)tabData.get("login_by_id"));
						pstmt_insert_disp_dtl_tmp.setString(++count,(String)tabData.get("login_at_ws_no"));
						pstmt_insert_disp_dtl_tmp.setString(++count,(String)tabData.get("facility_id"));

						pstmt_insert_disp_dtl_tmp.setString(++count,tmp_no+"");  //stock_srl_no

						//for filling code and remarks....
						pstmt_insert_disp_dtl_tmp.setString(++count,"");
						pstmt_insert_disp_dtl_tmp.setString(++count,"");
						// filling ended..
						
						pstmt_insert_disp_dtl_tmp.setString(++count,"");
						pstmt_insert_disp_dtl_tmp.setString(++count,"");
						pstmt_insert_disp_dtl_tmp.setString(++count,"");
						pstmt_insert_disp_dtl_tmp.setString(++count,"");
						pstmt_insert_disp_dtl_tmp.setString(++count,"");
						pstmt_insert_disp_dtl_tmp.setString(++count,"");
						pstmt_insert_disp_dtl_tmp.setString(++count,"");
						pstmt_insert_disp_dtl_tmp.setString(++count,"");
						pstmt_insert_disp_dtl_tmp.setString(++count,"");
						pstmt_insert_disp_dtl_tmp.setString(++count,"");

						pstmt_insert_disp_dtl_tmp.setString(++count,"");
						pstmt_insert_disp_dtl_tmp.setString(++count,"");
						pstmt_insert_disp_dtl_tmp.setString(++count,"");
						pstmt_insert_disp_dtl_tmp.setString(++count,"");

						pstmt_insert_disp_dtl_tmp.setString(++count,"");
						pstmt_insert_disp_dtl_tmp.setString(++count,"");
						pstmt_insert_disp_dtl_tmp.setString(++count,"");

						pstmt_insert_disp_dtl_tmp.setString(++count,"");
						pstmt_insert_disp_dtl_tmp.setString(++count,"");
						pstmt_insert_disp_dtl_tmp.setString(++count,"");
	
						if(hmBMSValues!=null && hmBMSValues.get(order_id+"~"+order_line_num)!=null)
							pstmt_insert_disp_dtl_tmp.setString(++count,(String)hmBMSValues.get(order_id+"~"+order_line_num));
						else
							pstmt_insert_disp_dtl_tmp.setString(++count,"0");
						pstmt_insert_disp_dtl_tmp.setString(++count,"");
						pstmt_insert_disp_dtl_tmp.setString(++count,"");//Added DRUG_INDICATION for  ML-BRU-CRF-072[Inc:29938]
						pstmt_insert_disp_dtl_tmp.setString(++count,"");//Added ALT_DRUG_REMARKS Bru-HIMS-CRF-082 [IN:029948]
						pstmt_insert_disp_dtl_tmp.setString(++count,tabData.get("print_seq_no_tmp").toString());//PRINT_SEQ_NO Added for RUT-CRF-0061
						pstmt_insert_disp_dtl_tmp.setString(++count,""); //AAKH-CRF-0117 
						pstmt_insert_disp_dtl_tmp.setString(++count,"");//GHL-CRF-0619
						// pstmt_insert_disp_dtl_tmp.setString(++count,"");//added for JD-CRF-0221
						
						pstmt_insert_disp_dtl_tmp.addBatch();			
					}
				}
			}
			if(allow_edit_disp_label.equals("Y") && editableLabel!=null && editableLabel.size()>0){ //if block Added for Bru-HIMS-CRF-414 [IN:045554]
				if(iPrevLblCount>0){
					int[] resultInsert=pstmt_disp_label_dtl_tmp_prev_insert.executeBatch();
					for (int k=0;k<resultInsert.length ;k++ ){
						if(resultInsert[k]<0  && resultInsert[k] != -2 ){
							pstmt_disp_label_dtl_tmp_prev_insert.cancel();
							connection.rollback();
							throw new EJBException("Insert Dispense Label failed");
						}		
					}
					for(int i=0;i<dispTMP.size();i=i+7){
						if(hshDispNoOld != null && hshDispNoOld.size()>0 && hshDispNoOld.containsKey((String)dispTMP.get(i)+"~"+(String)dispTMP.get(i+1))){
							tempDisp = (String)hshDispNoOld.get((String)dispTMP.get(i)+"~"+(String)dispTMP.get(i+1));
							if(tempDisp!=null && !tempDisp.equals("")){
								pstmt_disp_label_delete.setString(1,((String)tabData.get("facility_id")).trim()); 
								pstmt_disp_label_delete.setString(2, dispno_old);
								pstmt_disp_label_delete.setString(3 ,dispsrlno_old);
								pstmt_disp_label_delete.executeUpdate();
							}
						}
					}
				}
				if(insertCount>0){
					int[] resultInsert=pstmtDispLabelInsert.executeBatch();
					for (int k=0;k<resultInsert.length ;k++ ){
						if(resultInsert[k]<0  && resultInsert[k] != -2 ){
							pstmtDispLabelInsert.cancel();
							connection.rollback();
							throw new EJBException("Insert Dispense Label failed");
						}		
					}
				}
				if(updateCount>0){
					int[] resultUpdate=pstmtDispLabelUpdate.executeBatch();
					for (int k=0;k<resultUpdate.length ;k++ ){
						if(resultUpdate[k]<0  && resultUpdate[k] != -2 ){
							pstmtDispLabelUpdate.cancel();
							connection.rollback();
							throw new EJBException("Update Dispense Label failed");
						}		
					}
				}
			}

			int[] result3=pstmt_insert_disp_dtl_tmp.executeBatch();	
			for (int i=0;i<result3.length ;i++ ){
				if(result3[i]<0  && result3[i] != -2 ){
					pstmt_insert_disp_dtl_tmp.cancel();
					connection.rollback();
					throw new EJBException("Error: Insert Dtl Tmp failed");
				}		
			}
		}
		catch(Exception e){
			System.err.println("DTL_TMP INSERTION FAILED tabData="+tabData);
			e.printStackTrace();
			throw new EJBException("Error: DTL_TMP INSERTION FAILED");
		}
		finally{	
			try {
				closeStatement(pstmt_insert_disp_dtl_tmp ) ;
				closeStatement(pstmt_disp_dtl_tmp_select );
				closeStatement(pstmt_pres_remark_select);
				closeStatement(pstmt_pres_remark_select_1);
				closeStatement(pstmt);
				closeStatement(pstmt_1);//common-icn-0029
				closeStatement(pstmt_int);
				closeStatement(pstmt_int_1);
				closeStatement(pstmt1);
				closeStatement(pstmt_prsc_drug_select);
				closeResultSet( resultSet );
				closeResultSet(resultSet1);
				closeResultSet(resultSet2);
				closeResultSet( rsDispDtl ) ; //Added for Bru-HIMS-CRF-414 [IN:045554]-start
				closeResultSet( rsLablCount ) ;
				closeStatement( pstmt_disp_label_select_disp_dtl ) ;
				closeStatement( pstmt_disp_label_select_count ) ;
				closeStatement( pstmtDispLabelInsert ) ;
				closeStatement( pstmt_disp_label_dtl_tmp_prev_insert ) ;
				closeStatement( pstmt_disp_label_delete ) ;
				closeStatement( pstmtDispLabelUpdate ) ; //Added for Bru-HIMS-CRF-414 [IN:045554] -end
			}
			catch(Exception es) { 
				es.printStackTrace();
				throw es;
			}
		}
		tabData.remove("fillingRemarks");
		tabData.remove("editLabel");
		tabData.remove("editableLabel");//Added for Bru-HIMS-CRF-414 [IN:045554]
		return stock_srl;
	}

	private void insertBatchTMP(Connection connection, HashMap sqlMap, HashMap tabData,ArrayList dispTMP, HashMap seq_no, HashMap stock_srl) throws Exception {
		PreparedStatement pstmt_insert_disp_drug_batch_tmp	= null;
		int count				=	1;
		String drug_code		=	"";
		String item_code		=	"";
		String batch_id			=	""; 
		String expiry_date		=	"";
		String disp_qty			=	"";
		String disp_qty_uom		=	"";
		String trade_id			=	"";	
		String bin_locn_code	=	"";

		try {
			pstmt_insert_disp_drug_batch_tmp	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_DRUG_BATCH_TMP_INSERT") ) ;

			for(int i=0;i<dispTMP.size();i=i+7){
				ArrayList batchDetails = (ArrayList)dispTMP.get(i+6);
				for (int j=0;j<batchDetails.size() ; j=j+10){ //9->10 for MMS-SCF-0040 [IN:041888]
					count			=	1;
					drug_code		= (String)dispTMP.get(i+3);
					item_code		= (String)batchDetails.get(j);
					batch_id		= (String)batchDetails.get(j+1);
					expiry_date		= (String)batchDetails.get(j+2);
					disp_qty		= (String)batchDetails.get(j+3);
					//disp_qty_uom	=(String)batchDetails.get(j+4);
					disp_qty_uom	=(String)batchDetails.get(j+9);//j+4 is changed as j+9 for [IN:049778]
					trade_id		= (String)batchDetails.get(j+6);
					bin_locn_code	= (String)batchDetails.get(j+7);
					pstmt_insert_disp_drug_batch_tmp.setString(count,(String)tabData.get("facility_id"));
					pstmt_insert_disp_drug_batch_tmp.setString(++count,(String)tabData.get("disp_locn_code"));
					pstmt_insert_disp_drug_batch_tmp.setString(++count,((String)dispTMP.get(i)).trim());
					pstmt_insert_disp_drug_batch_tmp.setString(++count,((String)dispTMP.get(i+1)).trim());
					pstmt_insert_disp_drug_batch_tmp.setString(++count,item_code);
					pstmt_insert_disp_drug_batch_tmp.setString(++count,batch_id.trim());
					pstmt_insert_disp_drug_batch_tmp.setString(++count,expiry_date.trim());
					pstmt_insert_disp_drug_batch_tmp.setString(++count,(String)tabData.get("store_code"));
					pstmt_insert_disp_drug_batch_tmp.setString(++count,disp_qty.trim());
					pstmt_insert_disp_drug_batch_tmp.setString(++count,drug_code.trim());
					pstmt_insert_disp_drug_batch_tmp.setString(++count,(String)tabData.get("login_by_id"));
					pstmt_insert_disp_drug_batch_tmp.setString(++count,(String)tabData.get("login_at_ws_no"));
					pstmt_insert_disp_drug_batch_tmp.setString(++count,(String)tabData.get("facility_id"));
					pstmt_insert_disp_drug_batch_tmp.setString(++count,(String)tabData.get("login_by_id"));
					pstmt_insert_disp_drug_batch_tmp.setString(++count,(String)tabData.get("login_at_ws_no"));
					pstmt_insert_disp_drug_batch_tmp.setString(++count,(String)tabData.get("facility_id"));
					pstmt_insert_disp_drug_batch_tmp.setString(++count,disp_qty_uom.trim());
					pstmt_insert_disp_drug_batch_tmp.setString(++count,(String)stock_srl.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim()));
					pstmt_insert_disp_drug_batch_tmp.setString(++count,bin_locn_code);
					pstmt_insert_disp_drug_batch_tmp.setString(++count,trade_id);
					pstmt_insert_disp_drug_batch_tmp.addBatch();
				}
			}
			int[] result14=pstmt_insert_disp_drug_batch_tmp.executeBatch();
			for (int k=0;k<result14.length ;k++ ){
				if(result14[k]<0  && result14[k] != -2 ){
					pstmt_insert_disp_drug_batch_tmp.cancel();
					connection.rollback();
					throw new EJBException("Insert Drug Batch Tmp failed");
				}		
			}
		}
		catch(Exception e){
			System.err.println("DRUG_BATCH_TMP FAILED tabData="+tabData);
			e.printStackTrace();
			throw new EJBException("Error: Insert DRUG_BATCH_TMP FAILED");
		}
		finally{	
			try {
				closeStatement( pstmt_insert_disp_drug_batch_tmp ) ;
				pstmt_insert_disp_drug_batch_tmp=null;

			}
			catch(Exception es) { 
				es.printStackTrace();
				throw es;
			}
		}
	}

	public void callStockUpdate(Connection connection,HashMap tabData,HashMap sqlMap,ArrayList dispTMP,HashMap prev_doc_no,String st_doc_type,HashMap stock_srl) throws Exception{
		try {
			//if block added for SRR20056-SCF-7658.1 
		   if(stock_srl.size() == 0 || stock_srl == null || stock_srl.equals("")){
			  connection.rollback();
			  throw new Exception("APP-PH0902 Record Already In Use - It is used by Other User.Please Try again...");
			} 
			String item_code		=	"";
			String item_cost		=	"";
			String cost_value		=	"";
			String batch_id			=	"";
			String expiry_date		=	"";
			String bin_locn_code	=	"";
			String trade_id			=	"";
			String disp_qty			=	"";
			String order_id			=	"";
			String docno			=	"";
			String fill_list		=	(String)tabData.get("fill_list");
			String disp_stage       =	(String)tabData.get("disp_stage");
			HashMap order_id_attended_pract_id  =  (HashMap)tabData.get("ORDER_ID_ATTENDED_PRACT_ID"); // added for SRR20056-SCF-7373
			String p_overridden_excl_incl_ind = "";
			String p_overridden_action_reason = "";
			if(fill_list==null){
				fill_list="";
			}
			ArrayList orders		 =	new ArrayList();
			HashMap stock_dtls		 =	new HashMap();
			ArrayList insertDetail	 =	new ArrayList();
			ArrayList insertExp		 =	new ArrayList();
			ArrayList updateDetail	 =	new ArrayList();
			ArrayList updateExp		 =	new ArrayList();
			HashMap token_vals       =   (HashMap)tabData.get("token_vals");
			String[] strTokenTemp		= new String[2]; //Added for HSA-CRF-0136 [IN:048412]
			String token_series_code =  "";
			String token_no			 =  "";	
			Hashtable al_stock_update_data		=	new Hashtable();
			Hashtable data_tmp					=	new Hashtable();
			HashMap BaseAndIssueUOMQty			=	new HashMap();
			String store_code					=	(String)tabData.get("store_code");
			String iv_prep_yn					=   "";
			String sDischargedYN				=	"";
			String sTmpValue					=	"";
			float dispQty=0;
			String sDischargeYNForMedicalItem	=	"N";
			ArrayList orderLineData			= (ArrayList)tabData.get("orderLineData");//code ',orderLineData' added for AAKH-SCF-0032[IN038796]
			ArrayList batchDetails = null;
			HashMap hmDetail = null;
			HashMap hmExp = null;
			String deliver_checked =	""; //code added for AAKH-SCF-0032[IN038796] -Start
			HashMap deliverbox_checked  = new HashMap();
			String bl_doc_srl_no = "", doc_srl_no = "";
			String st_no_of_decimals = (String)tabData.get("st_no_of_decimals");// Added for AAKH-SCF-0113[IN:048937]
			String curr_disp_stage    =	tabData.get("curr_disp_stage")==null?"":(String)tabData.get("curr_disp_stage");
			String batch_uom ="";//Added for MMS-DM-SCF-0570
			String barcode_2d_applicable_yn  =tabData.get("barcode_2d_applicable_yn")==null?"":(String)tabData.get("barcode_2d_applicable_yn");//Added for MMS-DM-CRF-0174.5
			HashMap hm2dBarcodes =(HashMap)tabData.get("hm2dBarcode");//Added for MMS-DM-CRF-0174.5
			PreparedStatement pstmt_exp_count		=	null;//Added for MMS-DM-CRF-0174.6
			PreparedStatement pstmt_exp_barcode		=	null;//Added for MMS-DM-CRF-0174.6
			ResultSet resultSet							=	null;//Added for MMS-DM-CRF-0174.6
			   if(hm2dBarcodes ==null)//Added for MMS-DM-CRF-0174.5
				   hm2dBarcodes =new HashMap();//Added for MMS-DM-CRF-0174.5
			boolean site_param = new CommonBean().isSiteSpecific(connection, "PH","FORMULARY_BLG_GRP_APP");//GHL-SCF-1514

			if(tabData.get("st_decimal_restriction")==null)//added  for  MMS-DM-SCF-0210 [IN:059660]
				tabData.put("st_decimal_restriction", "N");//added  for  MMS-DM-SCF-0210 [IN:059660]
			if(orderLineData != null){				
				for(int k=0;k<orderLineData.size();k=k+6){
					deliverbox_checked.put(orderLineData.get(k+3)+"_"+orderLineData.get(k+4),(String)orderLineData.get(k));
					if(curr_disp_stage != null && curr_disp_stage.equals("AS")) {
						k	=	k+3;
					}				
				}				
			} //code added for AAKH-SCF-0032[IN038796]--End
			HashMap hmDisp_nos=	(HashMap)tabData.get("seq_no"); //Added for MMS-SCF-0212 [IN:046496], MMS-SCF-0216 [IN:046529] -Start
			if(hmDisp_nos==null) 
				hmDisp_nos = new HashMap();
			StringBuffer sbRemarksKey = new StringBuffer();
			HashMap approvalNo = (HashMap)tabData.get("approvalNo");//AAKH-CRF-0117
			String approval_no = ""; 
				

			String remarksKey="", disp_no="", disp_srl_no="";//Added for MMS-SCF-0212 [IN:046496], MMS-SCF-0216 [IN:046529] -End
			eST.Common.StSales	stSales		=	new eST.Common.StSales();//added  for  MMS-DM-SCF-0210 [IN:059660]
			int     noOfDecimalsForCost   =  Integer.parseInt(stSales.getNoOfDecimalsCost(connection));//added  for  MMS-DM-SCF-0210 [IN:059660]
			for(int i=0;i<dispTMP.size();i=i+7){
				deliver_checked = (String)deliverbox_checked.get(dispTMP.get(i)+"_"+dispTMP.get(i+1));//code added for AAKH-SCF-0032[IN038796]
				disp_no = hmDisp_nos.get(dispTMP.get(i))==null?"":(String)hmDisp_nos.get(dispTMP.get(i)); //Added for MMS-SCF-0212 [IN:046496], MMS-SCF-0216 [IN:046529] -Start
				disp_srl_no = (String)stock_srl.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim());
				remarksKey = disp_no+"!"+disp_srl_no+"!"+dispTMP.get(i)+"!"+dispTMP.get(i+1); 
				if(sbRemarksKey.length()>0)
					sbRemarksKey.append(":");
				sbRemarksKey.append(remarksKey); //Added for MMS-SCF-0212 [IN:046496], MMS-SCF-0216 [IN:046529] -End
				if(deliver_checked==null || deliver_checked.equals(""))
					deliver_checked = "NN";
				dispQty= Float.parseFloat(dispTMP.get(i+4)==null?"0":(String)dispTMP.get(i+4));
				if(dispQty>0){
					sTmpValue					= getIVPREPYNAndDischargeYN ( connection, (String)dispTMP.get(i));
					iv_prep_yn					= sTmpValue.split("~")[0];
					sDischargedYN				= sTmpValue.split("~")[1];	
					if(	!disp_stage.equals("F")&&!fill_list.equals("AF")&&!disp_stage.equals("A")&& !curr_disp_stage.equals("AS") ){	//this part of code is used for Delivery // !curr_disp_stage.equals("AS") added for  MMS-SCF-0124 [IN:044456]
						p_overridden_excl_incl_ind = "";
						p_overridden_action_reason = "";
						if(sDischargedYN.equals("Y"))
							sDischargeYNForMedicalItem ="Y";
						if(orders.size()!=0 && (!orders.contains(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()))) { //+((String)dispTMP.get(i+1)).trim() added for 35774 - SKR-SCF-0441.1
							updateDetail	=	new ArrayList();
							updateExp		=	new ArrayList();
							order_id		=	"";
							docno			=	"";
						}
						batchDetails = (ArrayList)dispTMP.get(i+6);
						if(batchDetails.size()>0 && (!deliver_checked.equals("NN") || fill_list.equals("DWF"))){ //code '&& !deliver_checked.equals("NN")'  added for AAKH-SCF-0032[IN038796]
							item_code				=	(String)batchDetails.get(0);
							item_cost				=	(String)batchDetails.get(8);
							if(item_cost.equals("")) item_cost	=	"0";
							//cost_value	=	Math.round(Integer.parseInt((String)dispTMP.get(i+4)) * Double.parseDouble(item_cost)*1000)+"";
							//cost_value	=   (Double.parseDouble(cost_value)/1000)+"";
							// Item Detail
							hmDetail	=	new HashMap();
							hmDetail.put("doc_srl_no",(String)stock_srl.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim()));
							hmDetail.put("item_code",item_code);
							hmDetail.put("sal_category","");
							hmDetail.put("hcp_issue_factor","");
			
							//iv_prep_yn =getIVPREPYNAndDischargeIndicator ( connection, (String)dispTMP.get(i));
							if(iv_prep_yn.equals("8")){/*===CODE ADDED TO HANDLE VARIABLE uom=======================*/
								hmDetail.put("item_qty",((String)dispTMP.get(i+4)).trim());
								hmDetail.put("mm_trn_qty",((String)dispTMP.get(i+4)).trim());
								//cost_value	=	Math.round(Double.parseDouble((String)dispTMP.get(i+4)) * Double.parseDouble(item_cost)*1000)+""; //commented for AAKH-SCF-0113 [IN:048937]
								//cost_value	=   (Double.parseDouble(cost_value)/1000)+""; //commented for AAKH-SCF-0113 [IN:048937]
							}
							else{
								BaseAndIssueUOMQty	=	(HashMap)getBaseAndIssueUOMQty( connection,  item_code,  store_code, ((String)dispTMP.get(i+4)).trim(),  ((String)dispTMP.get(i+5)).trim(), sqlMap,st_no_of_decimals);// st_no_of_decimals Added for AAKH-SCF-0113[IN:048937]
								
								if(site_param){//if condition added for GHL-SCF-1514
									hmDetail.put("item_qty",(String)BaseAndIssueUOMQty.get("ISSUE_QTY")); 
									hmDetail.put("mm_trn_qty",(String)BaseAndIssueUOMQty.get("ISSUE_QTY")); 
								}else{
									hmDetail.put("item_qty",(String)BaseAndIssueUOMQty.get("BASE_QTY")); 	//commented for SKR-SCF-0377 [IN:030453] - start
								//hmDetail.put("mm_trn_qty",(String)BaseAndIssueUOMQty.get("BASE_QTY"));
								//cost_value	=	Math.round(Double.parseDouble((String)BaseAndIssueUOMQty.get("ISSUE_QTY")) * Double.parseDouble(item_cost)*1000)+"";	//commented for SKR-SCF-0377 [IN:030453] - end
								//hmDetail.put("item_qty",((String)dispTMP.get(i+4)).trim());	//added for SKR-SCF-0377 [IN:030453] - start
								hmDetail.put("mm_trn_qty",(String)BaseAndIssueUOMQty.get("BASE_QTY")); // ((String)dispTMP.get(i+4)).trim() changed toMMS-DM-SCF-570 (String)BaseAndIssueUOMQty.get("ISSUE_QTY") for ML-BRU-SCF-1799changed Issue_QTY to BASE_QTY for MMS-DM-SCF-570
								//cost_value	=	Math.round(Double.parseDouble(((String)dispTMP.get(i+4)).trim()) * Double.parseDouble(item_cost)*1000)+"";	//added for SKR-SCF-0377 [IN:030453] -end //commented for AAKH-SCF-0113 [IN:048937]
								//cost_value	=   (Double.parseDouble(cost_value)/1000)+""; //commented for AAKH-SCF-0113 [IN:048937]
								}
							}	/*======ENDS HERE============================================*/
							if(tabData.get("st_decimal_restriction").equals("Y"))
							{
							cost_value	=	Double.parseDouble((String)hmDetail.get("item_qty")) * Double.parseDouble(item_cost)+"";	//added  for  MMS-DM-SCF-0210 [IN:059660]
							}
							else{
							cost_value	=  Math.round(Double.parseDouble((String)hmDetail.get("item_qty")) * Double.parseDouble(item_cost)*1000)+"";//Added for AAKH-SCF-0113 [IN:048937]//commented for  MMS-DM-SCF-0210 [IN:059660]
							cost_value	= (Double.parseDouble(cost_value)/1000)+"";//Added for AAKH-SCF-0113 [IN:048937]//commented for  MMS-DM-SCF-0210 [IN:059660]
							}
							//hmDetail.put("item_qty",((String)dispTMP.get(i+4)).trim());
							hmDetail.put("next_due_date","");
							hmDetail.put("stock_item_yn","Y");
							hmDetail.put("remarks",remarksKey); //Added remarksKey for MMS-SCF-0212 [IN:046496], MMS-SCF-0216 [IN:046529] -start
							hmDetail.put("order_id",(String)dispTMP.get(i)); 
							hmDetail.put("order_line_no",(String)dispTMP.get(i+1));
							hmDetail.put("disp_no",disp_no); 
							hmDetail.put("disp_srl_no",disp_srl_no); //Added remarksKey for MMS-SCF-0212 [IN:046496], MMS-SCF-0216 [IN:046529] -end
							hmDetail.put("item_unit_cost",item_cost);
							//hmDetail.put("item_sal_value",cost_value);//Commented for MMS-SCF-0275 [IN:047212]
							//hmDetail.put("item_cost_value",cost_value); //Commented for MMS-SCF-0275 [IN:047212]
							if(tabData.get("st_decimal_restriction").equals("Y")){
							hmDetail.put("item_sal_value",stSales.setNumber(""+cost_value, noOfDecimalsForCost)); //Added for MMS-SCF-0275 [IN:047212] // item_cost changed as cost_value for AAKH-SCF-0113 [IN:048937]//no of decimals added for MMS-DM-SCF-0210 [IN:059660]
							hmDetail.put("item_cost_value",stSales.setNumber(""+cost_value, noOfDecimalsForCost)); //Added for MMS-SCF-0275 [IN:047212] // item_cost changed as cost_value for AAKH-SCF-0113 [IN:048937]//no of decimals added for MMS-DM-SCF-0210 [IN:059660]
							}else{
							hmDetail.put("item_sal_value",cost_value); //Added for MMS-SCF-0275 [IN:047212] // item_cost changed as cost_value for AAKH-SCF-0113 [IN:048937]
							hmDetail.put("item_cost_value",cost_value); //Added for MMS-SCF-0275 [IN:047212] // item_cost changed as cost_value for AAKH-SCF-0113 [IN:048937]
							}
							hmDetail.put("item_unit_price",item_cost);
							hmDetail.put("uom_code",((String)dispTMP.get(i+5)).trim());
							if(curr_disp_stage.equals("AS")) //if block and else added for  MMS-SCF-0124 [IN:044456]
								hmDetail.put("mode","1");
							else
								hmDetail.put("mode",(String)tabData.get("mode"));
							hmDetail.put("p_ord_practitioner_id",(String)(order_id_attended_pract_id.get(((String)dispTMP.get(i)).trim()))); // added for SRR20056-SCF-7373

							String p_overridden_det = getBlInclExclDetail(connection,(String)dispTMP.get(i),(String)dispTMP.get(i+1),sqlMap);
							if(p_overridden_det!=null && !p_overridden_det.equals("")){
								p_overridden_excl_incl_ind = p_overridden_det.substring(0,1);
								p_overridden_action_reason = p_overridden_det.substring(p_overridden_det.indexOf(":")+1);
							}
							hmDetail.put("p_overridden_excl_incl_ind",p_overridden_excl_incl_ind);
							hmDetail.put("p_overridden_action_reason",p_overridden_action_reason);

							hmDetail.put("take_home_yn",sDischargedYN);
							
							//added for SKR-SCF-1315 START
							System.out.println("token vals: "+token_vals.get((String)dispTMP.get(i))); 
							//String orderid=(String)dispTMP.get(i); //Commented for COMMON-ICN-0048 
							if(token_vals!=null && token_vals.size()>0 && token_vals.get((String)dispTMP.get(i))!=null){ 
								/*if(token_vals.containsKey((order_id).trim())) {
									token_series_code = (String)tabData.get("token_series_code");
									token_no		  =	(String)token_vals.get((order_id).trim());
								}*/								
								System.out.println("dispTMP:"+dispTMP.get(i));
								
								strTokenTemp = ((String)token_vals.get(dispTMP.get(i))).split("_");//Changed for HSA-CRF-0136 [IN:048412]
								token_series_code = strTokenTemp[0];//Changed for HSA-CRF-0136 [IN:048412]
								token_no		  =	strTokenTemp[1];//Changed for HSA-CRF-0136 [IN:048412]
							}
							hmDetail.put("token_series_code",token_series_code);
							hmDetail.put("token_serial_no",token_no);
							//added for SKR-SCF-1315 END
							  
							
							//added for AAKH-CRF-0117 - start
							if(approvalNo!=null && approvalNo.size()>0)
								approval_no = (String)approvalNo.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim());
System.err.println("approval_no===>"+approval_no);
								if(approval_no==null)
									approval_no = "";
						hmDetail.put("approval_no",approval_no);
							//added for AAKH-CRF-0117 - end
							if(prev_doc_no.containsKey(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim())){
								if(prev_doc_no.get((String)dispTMP.get(i)+(String)dispTMP.get(i+1))!=null){
									if( !disp_stage.equals("F")&&!fill_list.equals("AF")&&!disp_stage.equals("A") && !curr_disp_stage.equals("AS")){ // !curr_disp_stage.equals("AS") added for  MMS-SCF-0124 [IN:044456]
										 updateDetail.add(hmDetail);
									}
									else{
										insertDetail.add(hmDetail);
									}
								}
								else{
									insertDetail.add(hmDetail);
								}
							}
							else{
								insertDetail.add(hmDetail);
							}
						}
					// Batch Details
					  if(!deliver_checked.equals("NN") || fill_list.equals("DWF")){ //code added for AAKH-SCF-0032[IN038796]
						for (int j=0;j<batchDetails.size() ; j=j+10){ //9->10 for MMS-SCF-0040 [IN:041888]
							batch_id		= (String)batchDetails.get(j+1);
							expiry_date		= (String)batchDetails.get(j+2);
							disp_qty		= (String)batchDetails.get(j+3);
							trade_id		= (String)batchDetails.get(j+6);
							bin_locn_code	= (String)batchDetails.get(j+7);
                            batch_uom       = (String)batchDetails.get(j+9);//Added for MMS-DM-SCF-0570
							p_overridden_excl_incl_ind = "";
							p_overridden_action_reason = "";

							if(prev_doc_no.containsKey(order_id+(String)dispTMP.get(i+1))){
								order_id	=	(String)dispTMP.get(i);
								docno		=	(String)prev_doc_no.get(order_id+(String)dispTMP.get(i+1));
								doc_srl_no = (String)stock_srl.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim());
								bl_doc_srl_no = "";
							}

							hmExp	=	new HashMap();
							hmExp.put("doc_srl_no",(String)stock_srl.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim()));
							hmExp.put("store_code",(String)tabData.get("store_code"));
							hmExp.put("item_code",item_code);
							hmExp.put("batch_id",batch_id.trim()); //trim() added for KAUH-SCF-0344
							hmExp.put("bin_location_code",bin_locn_code);
							hmExp.put("expiry_date_or_receipt_date",expiry_date);
							hmExp.put("trade_id",trade_id);
			
							hmExp.put("sal_item_qty",disp_qty);/*===CODE ADDED TO HANDLE VARIABLE uom=======================*/
							if(iv_prep_yn.equals("8")){
								hmExp.put("sal_item_qty",disp_qty);
							}
							else{
								//System.err.println("getBaseAndIssueUOMQty@@@@5398 item_code======"+item_code+"store_code==="+store_code+"disptemp4===="+disp_qty+"disptemp5====="+((String)dispTMP.get(i+5)).trim());
								BaseAndIssueUOMQty	=	(HashMap)getBaseAndIssueUOMQty( connection,  item_code,  store_code, disp_qty, batch_uom, sqlMap,st_no_of_decimals); // st_no_of_decimals Added for AAKH-SCF-0113[IN:048937]//changed  ((String)dispTMP.get(i+5)).trim() to batch_uom for MMS-DM-SCF-0570
								//System.err.println("ISSUE_QTY@@@5398==="+(String)BaseAndIssueUOMQty.get("ISSUE_QTY")+"BASE_QTY==="+(String)BaseAndIssueUOMQty.get("BASE_QTY"));
						//	 if(dispTMP.get(2)!=dispTMP.get(3)) // if else Added for ML-BRU-SCF-1803, BASE_QTY changed to ISSUE_QTY//Commented for MMS-DM-SCF-0564
								//hmExp.put("sal_item_qty",(String)BaseAndIssueUOMQty.get("ISSUE_QTY")); //Commented for MMS-DM-SCF-0564
							// else//Commented for MMS-DM-SCF-0564
								hmExp.put("sal_item_qty",(String)BaseAndIssueUOMQty.get("ISSUE_QTY"));//chnaged to BASE_QTY to Issue_qty for MMS-DM-SCF-0570
							}	/*======ENDS HERE============================================*/				
							//hmExp.put("sal_item_qty",disp_qty);
							hmExp.put("ret_item_qty","");
						 if(barcode_2d_applicable_yn.equals("Y")){//Added for MMS-DM-CRF-0174.5
							  if(hm2dBarcodes.containsKey(item_code+"~"+batch_id.trim())){
								  hmExp.put("item_2d_barcode",(String)hm2dBarcodes.get(item_code+"~"+batch_id.trim()));
							  }else{
                                   System.err.println("else condition@@========="); 
								   String item_2d_barcode =""; if(prev_doc_no.containsKey(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim())&&!disp_stage.equals("F")&&!fill_list.equals("AF")&&!disp_stage.equals("A") && !curr_disp_stage.equals("AS")){ 
									   docno		=	(String)prev_doc_no.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)));
									   doc_srl_no =  (String)stock_srl.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim());
									   System.err.println("docno==="+docno+"doc_srl_no=="+doc_srl_no+"st_doc_type=="+st_doc_type+"item_code==="+item_code);
									   pstmt_exp_count =connection.prepareStatement("SELECT COUNT(*) COUNT FROM ST_SAL_DTL_EXP  WHERE FACILITY_ID = ?  AND DOC_TYPE_CODE = ?  AND DOC_NO = ?   AND ITEM_CODE= ?  AND DOC_SRL_NO= ?");
                                            
											pstmt_exp_count.setString(1,((String)tabData.get("facility_id")).trim());
					                        pstmt_exp_count.setString(2,st_doc_type);
					                        pstmt_exp_count.setString(3,docno);
											pstmt_exp_count.setString(4,item_code);
											pstmt_exp_count.setString(5,doc_srl_no);
											resultSet = pstmt_exp_count.executeQuery() ;
					
					                       int count	=	0;
				                            	if ( resultSet.next() ) {
						                          count	=	Integer.parseInt(resultSet.getString("COUNT"));
					                            }
								closeResultSet( resultSet ) ;
					            closeStatement( pstmt_exp_count ) ;
				   System.err.println("count@@==="+count);
				                  if( count > 0 ){

									   pstmt_exp_barcode = connection.prepareStatement("SELECT BARCODE_ID FROM ST_SAL_DTL_EXP  WHERE FACILITY_ID = ?  AND DOC_TYPE_CODE = ?  AND DOC_NO = ?   AND ITEM_CODE= ?  AND DOC_SRL_NO= ?");
                                            
											pstmt_exp_barcode.setString(1,((String)tabData.get("facility_id")).trim());
					                        pstmt_exp_barcode.setString(2,st_doc_type);
					                        pstmt_exp_barcode.setString(3,docno);
											pstmt_exp_barcode.setString(4,item_code);
											pstmt_exp_barcode.setString(5,doc_srl_no);
											resultSet = pstmt_exp_barcode.executeQuery() ;

				                            	if ( resultSet.next() ) {
						                          item_2d_barcode	= (String)resultSet.getString("BARCODE_ID");
					                            }
												closeResultSet( resultSet ) ;
					                            closeStatement( pstmt_exp_barcode ) ;
                                       
					                     System.err.println("barcode_idnew for Delivery satge@@@===="+item_2d_barcode);

										 hmExp.put("item_2d_barcode",item_2d_barcode);
				            }
									          
							           }
							  }
						 }//Adding end for MMS-DM-CRF-0174.5
						 if(prev_doc_no.containsKey(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim())&&!disp_stage.equals("F")&&!fill_list.equals("AF")&&!disp_stage.equals("A") && !curr_disp_stage.equals("AS")){ // !curr_disp_stage.equals("AS") added for  MMS-SCF-0124 [IN:044456]
								updateExp.add(hmExp);	
							}
							else{
								insertExp.add(hmExp);
							}
						}
					}	
					if(!orders.contains(((String)dispTMP.get(i)).trim()+ ((String)dispTMP.get(i+1)).trim()) && (!deliver_checked.equals("NN") || fill_list.equals("DWF")) ){ //  added for 35774 - SKR-SCF-0441.1 && code '&& !deliver_checked.equals("NN")' added for AAKH-SCF-0032[IN038796]
						orders.add(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()); // added for 35774 - SKR-SCF-0441.1
						//order_id	=	(String)orders.get(0);
						order_id	=	(String)dispTMP.get(i);
						if(prev_doc_no.containsKey(order_id+(String)dispTMP.get(i+1))){
							docno		=	(String)prev_doc_no.get(order_id+(String)dispTMP.get(i+1));
							data_tmp =new Hashtable();
							
							if(al_stock_update_data.containsKey(docno)){
							   data_tmp =(Hashtable) al_stock_update_data.get(docno);
							   data_tmp.put(docno+(String)stock_srl.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim())+"DTL",updateDetail) ;   
							   data_tmp.put(docno+(String)stock_srl.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim())+"EXP",updateExp);
								al_stock_update_data.put(docno,data_tmp);
							}
							else{
								data_tmp.put(docno+(String)stock_srl.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim())+"DTL",updateDetail) ;                   data_tmp.put(docno+(String)stock_srl.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim())+"EXP",updateExp);
								al_stock_update_data.put(docno,data_tmp);
							}
						}
					}

					if(token_vals!=null && token_vals.size()>0 && token_vals.get(order_id)!=null){
						/*if(token_vals.containsKey((order_id).trim())) {
							token_series_code = (String)tabData.get("token_series_code");
							token_no		  =	(String)token_vals.get((order_id).trim());
						}*/
						strTokenTemp = ((String)token_vals.get(order_id)).split("_");//Changed for HSA-CRF-0136 [IN:048412]
						token_series_code = strTokenTemp[0];//Changed for HSA-CRF-0136 [IN:048412]
						token_no		  =	strTokenTemp[1];//Changed for HSA-CRF-0136 [IN:048412]
					}
				}
				else{		//this part of code is used for allocation and Filling(with filllist ,without fill list)
					p_overridden_excl_incl_ind = "";
					p_overridden_action_reason = "";
					batchDetails = (ArrayList)dispTMP.get(i+6);
					if(batchDetails.size()>0){
						item_code				=	(String)batchDetails.get(0);
						item_cost				=	(String)batchDetails.get(8);
						if(item_cost.equals("")) item_cost	=	"0";
						//cost_value	=	Math.round(Integer.parseInt((String)dispTMP.get(i+4)) * Double.parseDouble(item_cost)*1000)+"";
						//cost_value	=   (Double.parseDouble(cost_value)/1000)+"";
						// Item Detail
						if(prev_doc_no.containsKey(order_id+(String)dispTMP.get(i+1))){
							order_id	=	(String)dispTMP.get(i);
							docno		=	(String)prev_doc_no.get(order_id+(String)dispTMP.get(i+1));
							bl_doc_srl_no = "";
							doc_srl_no =  (String)stock_srl.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim());

						}

						hmDetail	=	new HashMap();
						hmDetail.put("doc_srl_no",(String)stock_srl.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim()));
						hmDetail.put("item_code",item_code);
						hmDetail.put("sal_category","");
						hmDetail.put("hcp_issue_factor","");
		
						String stock_uom = ((String)dispTMP.get(i+5)).trim();/*===CODE ADDED TO HANDLE VARIABLE uom=======================*/
						String base_uom = "";
						if(iv_prep_yn.equals("8")){
							hmDetail.put("item_qty",((String)dispTMP.get(i+4)).trim());
							hmDetail.put("mm_trn_qty",((String)dispTMP.get(i+4)).trim());
							if(tabData.get("st_decimal_restriction").equals("Y")){
								cost_value	=	Double.parseDouble((String)dispTMP.get(i+4)) * Double.parseDouble(item_cost)+"";
							}else{
							cost_value	=  Math.round(Double.parseDouble((String)dispTMP.get(i+4)) * Double.parseDouble(item_cost)*1000)+"";
							cost_value	= (Double.parseDouble(cost_value)/1000)+"";
							}
						}
						else{		
							BaseAndIssueUOMQty	=	(HashMap)getBaseAndIssueUOMQty( connection,  item_code,  store_code, ((String)dispTMP.get(i+4)).trim(),  ((String)dispTMP.get(i+5)).trim(), sqlMap,st_no_of_decimals); // st_no_of_decimals Added for AAKH-SCF-0113[IN:048937]
							
							if(site_param){ //if condition added for GHL-SCF-1514
								hmDetail.put("item_qty",(String)BaseAndIssueUOMQty.get("ISSUE_QTY")); 
								hmDetail.put("mm_trn_qty",(String)BaseAndIssueUOMQty.get("ISSUE_QTY")); 
							}else{
								hmDetail.put("item_qty",(String)BaseAndIssueUOMQty.get("BASE_QTY"));
							
								hmDetail.put("mm_trn_qty",(String)BaseAndIssueUOMQty.get("BASE_QTY")); // BASE_QTY changed to ISSUE_QTY for ML-BRU-SCF-1803 reverted back for MMS-DM-SCF-0567
							}
							if(tabData.get("st_decimal_restriction").equals("Y")){
								cost_value	=	Double.parseDouble((String)BaseAndIssueUOMQty.get("ISSUE_QTY")) * Double.parseDouble(item_cost)+"";//added for  MMS-DM-SCF-0210 [IN:059660]
							}else{
							cost_value	=	Math.round(Double.parseDouble((String)BaseAndIssueUOMQty.get("ISSUE_QTY")) * Double.parseDouble(item_cost)*1000)+"";
							cost_value	=   (Double.parseDouble(cost_value)/1000)+"";
							}
							stock_uom = (String)BaseAndIssueUOMQty.get("DEF_STORE_UOM")==null? stock_uom : (String)BaseAndIssueUOMQty.get("DEF_STORE_UOM");
							base_uom = (String)BaseAndIssueUOMQty.get("BASE_UOM")==null? stock_uom : (String)BaseAndIssueUOMQty.get("BASE_UOM");
						}/*======ENDS HERE============================================*/

						//hmDetail.put("item_qty",((String)dispTMP.get(i+4)).trim());
						hmDetail.put("next_due_date","");
						hmDetail.put("stock_item_yn","Y");
						hmDetail.put("remarks",remarksKey); //Added remarksKey for MMS-SCF-0212 [IN:046496], MMS-SCF-0216 [IN:046529] -start
						hmDetail.put("order_id",(String)dispTMP.get(i)); 
						hmDetail.put("order_line_no",(String)dispTMP.get(i+1));
						hmDetail.put("disp_no",disp_no); 
						hmDetail.put("disp_srl_no",disp_srl_no); //Added remarksKey for MMS-SCF-0212 [IN:046496], MMS-SCF-0216 [IN:046529] -end
						hmDetail.put("item_unit_cost",item_cost);
						//hmDetail.put("item_sal_value",cost_value); //Committed for MMS-SCF-0275 [IN:047212]
						//hmDetail.put("item_cost_value",cost_value); //Committed for MMS-SCF-0275 [IN:047212]
						if(tabData.get("st_decimal_restriction").equals("Y")){
							hmDetail.put("item_sal_value",stSales.setNumber(""+cost_value, noOfDecimalsForCost)); //Added for MMS-SCF-0275 [IN:047212] // item_cost changed to cost_value for AAKH-SCF-0113 [IN:048937]//no of decimals added for  MMS-DM-SCF-0210 [IN:059660]
							hmDetail.put("item_cost_value",stSales.setNumber(""+cost_value, noOfDecimalsForCost)); //Added for MMS-SCF-0275 [IN:047212] // item_cost changed to cost_value for AAKH-SCF-0113 [IN:048937]//no of decimals added for  MMS-DM-SCF-0210 [IN:059660]
						}else{
						hmDetail.put("item_sal_value",cost_value); //Added for MMS-SCF-0275 [IN:047212] // item_cost changed to cost_value for AAKH-SCF-0113 [IN:048937]
						hmDetail.put("item_cost_value",cost_value); //Added for MMS-SCF-0275 [IN:047212] // item_cost changed to cost_value for AAKH-SCF-0113 [IN:048937]
						}
						hmDetail.put("item_unit_price",item_cost);
						hmDetail.put("uom_code",base_uom);//stock_uom
						//hmDetail.put("uom_code",((String)dispTMP.get(i+5)).trim());
						if(curr_disp_stage.equals("AS")) //if block and else added for  MMS-SCF-0124 [IN:044456]
							hmDetail.put("mode","1");
						else
							hmDetail.put("mode",(String)tabData.get("mode"));
						hmDetail.put("p_ord_practitioner_id",(String)(order_id_attended_pract_id.get(((String)dispTMP.get(i)).trim()))); // added for SRR20056-SCF-7373

						String p_overridden_det = getBlInclExclDetail(connection,(String)dispTMP.get(i),(String)dispTMP.get(i+1),sqlMap);
						if(p_overridden_det!=null && !p_overridden_det.equals("")){
							p_overridden_excl_incl_ind = p_overridden_det.substring(0,1);
							p_overridden_action_reason = p_overridden_det.substring(p_overridden_det.indexOf(":")+1);
						}
						hmDetail.put("p_overridden_excl_incl_ind",p_overridden_excl_incl_ind);
						hmDetail.put("p_overridden_action_reason",p_overridden_action_reason);

						hmDetail.put("take_home_yn",sDischargedYN); // For Take Home Flag
						//added for SKR-SCF-1315 START
						//String orderid=(String)dispTMP.get(i); //Commented for COMMON-ICN-0048 
						if(token_vals!=null && token_vals.size()>0 && token_vals.get((String)dispTMP.get(i))!=null){ 
							strTokenTemp = ((String)token_vals.get(dispTMP.get(i))).split("_");//Changed for HSA-CRF-0136 [IN:048412]
							token_series_code = strTokenTemp[0];//Changed for HSA-CRF-0136 [IN:048412]
							token_no		  =	strTokenTemp[1];//Changed for HSA-CRF-0136 [IN:048412]
						}
						hmDetail.put("token_series_code",token_series_code);
						hmDetail.put("token_serial_no",token_no);
						//added for SKR-SCF-1315 END
						if(approvalNo!=null && approvalNo.size()>0)
								approval_no = (String)approvalNo.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim());
System.err.println("approval_no=5616==>"+approval_no);
								if(approval_no==null)
									approval_no = "";
						hmDetail.put("approval_no",approval_no);

						if(prev_doc_no.containsKey(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim())){
							if(prev_doc_no.get((String)dispTMP.get(i)+((String)dispTMP.get(i+1)).trim())!=null){
								if( !disp_stage.equals("F")&&!fill_list.equals("AF")&&!disp_stage.equals("A")&& !curr_disp_stage.equals("AS")){ // !curr_disp_stage.equals("AS") added for  MMS-SCF-0124 [IN:044456]
									 updateDetail.add(hmDetail);
								}
								else{
									insertDetail.add(hmDetail);
								}
							}
							else{
								insertDetail.add(hmDetail);
							}
						}
						else{
							insertDetail.add(hmDetail);
						}
					}

					// Batch Details
					for (int j=0;j<batchDetails.size() ; j=j+10){ //9->10 for MMS-SCF-0040 [IN:041888]
						batch_id		= (String)batchDetails.get(j+1);
						expiry_date		= (String)batchDetails.get(j+2);
						disp_qty		= (String)batchDetails.get(j+3);
						trade_id		= (String)batchDetails.get(j+6);
						bin_locn_code	= (String)batchDetails.get(j+7);
						batch_uom       = (String)batchDetails.get(j+9);//Added for MMS-DM-SCF-0570

						p_overridden_excl_incl_ind = "";
						p_overridden_action_reason = "";

						hmExp	=	new HashMap();
						hmExp.put("doc_srl_no",(String)stock_srl.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim()));
						hmExp.put("store_code",(String)tabData.get("store_code"));
						hmExp.put("item_code",item_code);
						hmExp.put("batch_id",batch_id.trim());//trim() added for KAUH-SCF-0344
						hmExp.put("bin_location_code",bin_locn_code);
						hmExp.put("expiry_date_or_receipt_date",expiry_date);
						hmExp.put("trade_id",trade_id);
		
						if(iv_prep_yn.equals("8")){/*===CODE ADDED TO HANDLE VARIABLE uom=======================*/
							hmExp.put("sal_item_qty",disp_qty);
						}
						else{
							//System.err.println("batchDetails Managerat exp level@@@@==="+batchDetails);
							//System.err.println("getBaseAndIssueUOMQty@@@@5577 item_code======"+item_code+"store_code==="+store_code+"disptemp4===="+disp_qty+"disptemp5====="+((String)dispTMP.get(i+5)).trim()+"Disptemp44444"+((String)dispTMP.get(i+4)).trim());
							BaseAndIssueUOMQty	=	(HashMap)getBaseAndIssueUOMQty( connection,  item_code,  store_code, disp_qty,  batch_uom, sqlMap,st_no_of_decimals); // st_no_of_decimals Added for AAKH-SCF-0113[IN:048937]//changd dispTMP avalue from 5  to 9 for MMS-DM-SCF-0570
							
							 //if(dispTMP.get(2)!=dispTMP.get(3) && !curr_disp_stage.equals("AS")) // if else Added for ML-BRU-SCF-1803, //Commented for MMS-DM-SCF-0564
									//hmExp.put("sal_item_qty",(String)BaseAndIssueUOMQty.get("ISSUE_QTY")); //Commented for MMS-DM-SCF-0564
								// else//Commented for MMS-DM-SCF-0564
							        hmExp.put("sal_item_qty",(String)BaseAndIssueUOMQty.get("ISSUE_QTY"));//changed base_qty to issue_qty for MMS-DM-SCF-0567
						}		/*======ENDS HERE============================================*/	
						//hmExp.put("sal_item_qty",disp_qty);
							hmExp.put("ret_item_qty","");
							if(barcode_2d_applicable_yn.equals("Y")){//Added for MMS-DM-CRF-0174.5
							  if(hm2dBarcodes.containsKey(item_code+"~"+batch_id.trim())){
								  hmExp.put("item_2d_barcode",(String)hm2dBarcodes.get(item_code+"~"+batch_id.trim()));
							  }
						 }//Adding end for MMS-DM-CRF-0174.5
							if(prev_doc_no.containsKey(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim())&&!disp_stage.equals("F")&&!fill_list.equals("AF")&&!disp_stage.equals("A") && !curr_disp_stage.equals("AS")){ // !curr_disp_stage.equals("AS") added for  MMS-SCF-0124 [IN:044456]
								updateExp.add(hmExp);	
							}
							else{
								insertExp.add(hmExp);
							}
						}
						if(!orders.contains(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim())){
							orders.add(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim());
						}
						if(token_vals!=null && token_vals.size()>0 && token_vals.get(((String)dispTMP.get(i)))!=null){
							/*if(token_vals.containsKey(((String)dispTMP.get(i)).trim())) {
								token_series_code = (String)tabData.get("token_series_code");
								token_no		  =	(String)token_vals.get(((String)dispTMP.get(i)).trim());
							}*/
							strTokenTemp = ((String)token_vals.get(((String)dispTMP.get(i)))).split("_");//Changed for HSA-CRF-0136 [IN:048412]
							if(strTokenTemp!=null && strTokenTemp.length>0){
								token_series_code = strTokenTemp[0];//Changed for HSA-CRF-0136 [IN:048412]
								token_no		  =	strTokenTemp[1];//Changed for HSA-CRF-0136 [IN:048412]
							}
						 }
					}
				}
			}
			HashMap hmPPNValues		=  (HashMap)tabData.get("hmPPNValues");
			if(!disp_stage.equals("D")) {    
				if(tabData.containsKey("CONSUMABLES_DET")){
					HashMap cons_dtl       =   new HashMap();
					HashMap Batch_det      =   new HashMap();
					String issued_qty		 =	 "";
					ArrayList  tot_consumables_det =(ArrayList)tabData.get("CONSUMABLES_DET");
					for (int h=0;h<tot_consumables_det.size() ;h++ ){ 
						hmDetail	     =	 new HashMap(); 
						cons_dtl = (HashMap)tot_consumables_det.get(h);
						disp_no = hmDisp_nos.get(cons_dtl.get("ORDER_ID"))==null?"":(String)hmDisp_nos.get(cons_dtl.get("ORDER_ID")); //Added for MMS-SCF-0212 [IN:046496], MMS-SCF-0216 [IN:046529] -Start
						disp_srl_no = (String)cons_dtl.get("BATCH_SRL_NO");
						remarksKey = disp_no+"!"+disp_srl_no+"!"+cons_dtl.get("ORDER_ID")+"!"+cons_dtl.get("ORDER_LINE_NO"); 
						if(sbRemarksKey.length()>0)
							sbRemarksKey.append(":");
						sbRemarksKey.append(remarksKey); //Added for MMS-SCF-0212 [IN:046496], MMS-SCF-0216 [IN:046529] -End
						if(cons_dtl.get("SELECTED_YN").equals("Y")&& !cons_dtl.get("ALLOC_QTY").equals("")){ 
							Batch_det   =   (HashMap)cons_dtl.get("BATCH_DET");
							hmDetail	=	new HashMap();
							item_cost	=	(String)Batch_det.get("ITEM_COST");
							issued_qty  =   (String)cons_dtl.get("ALLOC_QTY");

							if(item_cost.equals("")) item_cost	=	"0";
							if(tabData.get("st_decimal_restriction").equals("Y")){
								 cost_value	=	Double.parseDouble(issued_qty) * Double.parseDouble(item_cost)+"";//added for  MMS-DM-SCF-0210 [IN:059660]
							}else{
							 cost_value	=	Math.round(Double.parseDouble(issued_qty) * Double.parseDouble(item_cost)*1000)+"";
							 cost_value	=   (Double.parseDouble(cost_value)/1000)+"";
							}

							hmDetail.put("doc_srl_no",cons_dtl.get("BATCH_SRL_NO"));
							hmDetail.put("item_code",Batch_det.get("ITEM_CODE"));
							hmDetail.put("sal_category","");
							hmDetail.put("hcp_issue_factor","");
							hmDetail.put("item_qty",issued_qty);
							hmDetail.put("next_due_date","");
							hmDetail.put("stock_item_yn","Y");
							hmDetail.put("remarks",remarksKey); //Added remarksKey for MMS-SCF-0212 [IN:046496], MMS-SCF-0216 [IN:046529] -start
							hmDetail.put("order_id",(String)cons_dtl.get("ORDER_ID"));
							hmDetail.put("order_line_no",(String)cons_dtl.get("ORDER_LINE_NO"));
							hmDetail.put("disp_no",disp_no);
							hmDetail.put("disp_srl_no",disp_srl_no); //Added remarksKey for MMS-SCF-0212 [IN:046496], MMS-SCF-0216 [IN:046529] -end
							hmDetail.put("item_unit_cost",item_cost);
							if(tabData.get("st_decimal_restriction").equals("Y")){
								hmDetail.put("item_sal_value",stSales.setNumber(""+cost_value, noOfDecimalsForCost)); //Added for MMS-SCF-0275 [IN:047212] // item_cost changed to cost_value for AAKH-SCF-0113 [IN:048937]//no of decimals added for  MMS-DM-SCF-0210 [IN:059660]
								hmDetail.put("item_cost_value",stSales.setNumber(""+cost_value, noOfDecimalsForCost)); //Added for MMS-SCF-0275 [IN:047212] //item_cost changed to cost_value for AAKH-SCF-0113 [IN:048937]//no of decimals added for  MMS-DM-SCF-0210 [IN:059660]
							}else{
								hmDetail.put("item_sal_value",cost_value);//Commented for MMS-SCF-0275 [IN:047212]
								hmDetail.put("item_cost_value",cost_value); //Commented for MMS-SCF-0275 [IN:047212]
							}
							hmDetail.put("item_unit_price",item_cost);
							hmDetail.put("uom_code",((String)cons_dtl.get("ORDER_UOM")));
							if(curr_disp_stage.equals("AS")) //if block and else added for  MMS-SCF-0124 [IN:044456]
								hmDetail.put("mode","1");
							else
								hmDetail.put("mode",(String)tabData.get("mode"));
							hmDetail.put("p_overridden_excl_incl_ind","");
							hmDetail.put("p_overridden_action_reason","");
							hmDetail.put("take_home_yn",sDischargeYNForMedicalItem); // For Take Home Flag
							hmDetail.put("p_ord_practitioner_id",((String)cons_dtl.get("ORD_PRACT_ID"))); // added for SRR20056-SCF-7373
							insertDetail.add(hmDetail);
							hmExp	=	new HashMap();
							hmExp.put("doc_srl_no",cons_dtl.get("BATCH_SRL_NO"));
							hmExp.put("store_code",(String)tabData.get("store_code"));
							hmExp.put("item_code",(String)Batch_det.get("ITEM_CODE"));
							hmExp.put("batch_id",((String)Batch_det.get("BATCH_ID")).trim()); //trim() added for KAUH-SCF-0344
							hmExp.put("bin_location_code",(String)Batch_det.get("BIN_LOCN_CODE"));
							hmExp.put("expiry_date_or_receipt_date",(String)Batch_det.get("EXPIRY_DATE"));
							hmExp.put("trade_id",(String)Batch_det.get("TRADE_ID"));
							hmExp.put("sal_item_qty",issued_qty);
							hmExp.put("ret_item_qty","");
							insertExp.add(hmExp);
						}
					}
				}
				if(hmPPNValues != null && hmPPNValues.size()>0){
					item_code				= (String)hmPPNValues.get("itemCode")	;
					item_cost				= (String)hmPPNValues.get("itemCost")	;
					
					if(item_cost.equals("")) 
						item_cost	=	"0";
					disp_no = hmDisp_nos.get(hmPPNValues.get("orderId"))==null?"":(String)hmDisp_nos.get(hmPPNValues.get("orderId")); //Added for MMS-SCF-0212 [IN:046496], MMS-SCF-0216 [IN:046529] -Start
					disp_srl_no = "2";
					remarksKey = disp_no+"!"+disp_srl_no+"!"+hmPPNValues.get("orderId")+"!1";
					if(sbRemarksKey.length()>0)
						sbRemarksKey.append(":");
					sbRemarksKey.append(remarksKey); //Added for MMS-SCF-0212 [IN:046496], MMS-SCF-0216 [IN:046529] -End
					hmDetail	=	new HashMap();
					hmDetail.put("doc_srl_no","2");
					hmDetail.put("item_code",item_code);
					hmDetail.put("sal_category","");
					hmDetail.put("hcp_issue_factor","");

					hmDetail.put("item_qty",(String)hmPPNValues.get("selectedQty"));
					hmDetail.put("mm_trn_qty",(String)hmPPNValues.get("selectedQty"));

					cost_value	=	Math.round(Integer.parseInt((String)hmPPNValues.get("selectedQty")) * Double.parseDouble(item_cost)*1000)+"";
					cost_value	=   (Double.parseDouble(cost_value)/1000)+"";
					hmDetail.put("next_due_date","");
					hmDetail.put("stock_item_yn","Y");
					hmDetail.put("remarks",remarksKey); //Added remarksKey for MMS-SCF-0212 [IN:046496], MMS-SCF-0216 [IN:046529]
					hmDetail.put("order_id",(String)hmPPNValues.get("orderId"));
					hmDetail.put("order_line_no","1");
					hmDetail.put("disp_no",disp_no);
					hmDetail.put("disp_srl_no",disp_srl_no); //Added remarksKey for MMS-SCF-0212 [IN:046496], MMS-SCF-0216 [IN:046529] -end
					hmDetail.put("item_unit_cost",item_cost);
					//hmDetail.put("item_sal_value",cost_value);//commented for MMS-SCF-0275 [IN:047212]
					//hmDetail.put("item_cost_value",cost_value); //commented for MMS-SCF-0275 [IN:047212]
					if(tabData.get("st_decimal_restriction").equals("Y")){
						hmDetail.put("item_sal_value",stSales.setNumber(""+cost_value, noOfDecimalsForCost)); //Added for MMS-SCF-0275 [IN:047212] // item_cost changed as cost_value for AAKH-SCF-0113 [IN:048937]//no of decimals added for  MMS-DM-SCF-0210 [IN:059660]
						hmDetail.put("item_cost_value",stSales.setNumber(""+cost_value, noOfDecimalsForCost)); //Added for MMS-SCF-0275 [IN:047212] // item_cost changed as cost_value for AAKH-SCF-0113 [IN:048937]//no of decimals added for  MMS-DM-SCF-0210 [IN:059660]
					}else{
						hmDetail.put("item_sal_value",cost_value);//commented for MMS-SCF-0275 [IN:047212]
						hmDetail.put("item_cost_value",cost_value); 
					}
					hmDetail.put("item_unit_price",item_cost); 
					hmDetail.put("uom_code",(String)hmPPNValues.get("UOMCode"));
					if(curr_disp_stage.equals("AS")) //if block and else added for  MMS-SCF-0124 [IN:044456]
						hmDetail.put("mode","1");
					else
						hmDetail.put("mode",(String)tabData.get("mode"));
					hmDetail.put("p_ord_practitioner_id",((String)hmPPNValues.get("ORD_PRACT_ID"))); // added for SRR20056-SCF-7373

					String p_overridden_det = getBlInclExclDetail(connection,(String)dispTMP.get(0),(String)dispTMP.get(1),sqlMap);
					if(p_overridden_det!=null && !p_overridden_det.equals("")){
						p_overridden_excl_incl_ind = p_overridden_det.substring(0,1);
						p_overridden_action_reason = p_overridden_det.substring(p_overridden_det.indexOf(":")+1);
					}
					hmDetail.put("p_overridden_excl_incl_ind",p_overridden_excl_incl_ind);
					hmDetail.put("p_overridden_action_reason",p_overridden_action_reason);
					hmDetail.put("take_home_yn",sDischargeYNForMedicalItem); // For Take Home Flag
					insertDetail.add(hmDetail);
					// Batch Details
					batch_id		= (String)hmPPNValues.get("batchId");
					expiry_date		= (String)hmPPNValues.get("expiryDate");
					disp_qty		= (String)hmPPNValues.get("selectedQty");
					trade_id		= (String)hmPPNValues.get("tradeId");
					bin_locn_code	= (String)hmPPNValues.get("binLocation");

					p_overridden_excl_incl_ind = "";
					p_overridden_action_reason = "";

					hmExp	=	new HashMap();
					hmExp.put("doc_srl_no","2");
					hmExp.put("store_code",(String)tabData.get("store_code"));
					hmExp.put("item_code",item_code);
					hmExp.put("batch_id",batch_id.trim());//trim() added for KAUH-SCF-0344
					hmExp.put("bin_location_code",bin_locn_code);
					hmExp.put("expiry_date_or_receipt_date",expiry_date);
					hmExp.put("trade_id",trade_id);
					hmExp.put("sal_item_qty",disp_qty);
					hmExp.put("ret_item_qty","");
					insertExp.add(hmExp);
				}
			}
			else{
				if(tabData.containsKey("CONSUMABLES_DET")){
					HashMap cons_dtl       =   new HashMap();
					HashMap Batch_det      =   new HashMap();
					String issued_qty		 =	 "";
					ArrayList  tot_consumables_det = (ArrayList)tabData.get("CONSUMABLES_DET");
					for (int h=0;h<tot_consumables_det.size() ;h++ ){ 
						cons_dtl = (HashMap)tot_consumables_det.get(h);
						disp_no = hmDisp_nos.get(cons_dtl.get("ORDER_ID"))==null?"":(String)hmDisp_nos.get(cons_dtl.get("ORDER_ID")); //Added for MMS-SCF-0212 [IN:046496], MMS-SCF-0216 [IN:046529] -Start
						disp_srl_no = (String)cons_dtl.get("BATCH_SRL_NO");
						remarksKey = disp_no+"!"+disp_srl_no+"!"+cons_dtl.get("ORDER_ID")+"!"+cons_dtl.get("ORDER_LINE_NO");
						if(sbRemarksKey.length()>0)
							sbRemarksKey.append(":");
						sbRemarksKey.append(remarksKey); //Added for MMS-SCF-0212 [IN:046496], MMS-SCF-0216 [IN:046529] -End
						if(cons_dtl.get("SELECTED_YN").equals("Y")&& !cons_dtl.get("ALLOC_QTY").equals("")){
							updateDetail	=	new ArrayList();
							updateExp		=	new ArrayList();
							Batch_det       =   (HashMap)cons_dtl.get("BATCH_DET");
							hmDetail	    =	new HashMap();
							item_cost	    =	Batch_det.get("ITEM_COST")==null?"":(String)Batch_det.get("ITEM_COST");
							issued_qty      =   cons_dtl.get("ALLOC_QTY")==null?"":(String)cons_dtl.get("ALLOC_QTY");

							if(item_cost.equals("")) 
								item_cost	=	"0";
							cost_value	=	Math.round(Integer.parseInt(issued_qty) * Double.parseDouble(item_cost)*1000)+"";
							cost_value	=   (Double.parseDouble(cost_value)/1000)+"";
							
							hmDetail	=	new HashMap();
							hmDetail.put("doc_srl_no",cons_dtl.get("BATCH_SRL_NO"));
							hmDetail.put("item_code",Batch_det.get("ITEM_CODE"));
							hmDetail.put("sal_category","");
							hmDetail.put("hcp_issue_factor","");
							hmDetail.put("item_qty",issued_qty);
							hmDetail.put("next_due_date","");
							hmDetail.put("stock_item_yn","Y");
							hmDetail.put("remarks",remarksKey); //Added remarksKey for MMS-SCF-0212 [IN:046496], MMS-SCF-0216 [IN:046529]
							hmDetail.put("order_id",(String)cons_dtl.get("ORDER_ID"));
							hmDetail.put("order_line_no",(String)cons_dtl.get("ORDER_LINE_NO"));
							hmDetail.put("disp_no",disp_no);
							hmDetail.put("disp_srl_no",disp_srl_no); //Added remarksKey for MMS-SCF-0212 [IN:046496], MMS-SCF-0216 [IN:046529] -end
							hmDetail.put("item_unit_cost",item_cost);
							//hmDetail.put("item_sal_value",cost_value);//Commented for  MMS-SCF-0275 [IN:047212]
							//hmDetail.put("item_cost_value",cost_value);//Commented for  MMS-SCF-0275 [IN:047212]
							hmDetail.put("item_sal_value",item_cost); //Added for MMS-SCF-0275 [IN:047212]
							hmDetail.put("item_cost_value",item_cost);//Added for  MMS-SCF-0275 [IN:047212]
							hmDetail.put("item_unit_price",item_cost);
							hmDetail.put("uom_code",((String)cons_dtl.get("ORDER_UOM")));
							if(curr_disp_stage.equals("AS")) //if block and else added for  MMS-SCF-0124 [IN:044456]
								hmDetail.put("mode","1");
							else
								hmDetail.put("mode",(String)tabData.get("mode"));
							hmDetail.put("p_overridden_excl_incl_ind","");
							hmDetail.put("p_overridden_action_reason","");

							hmDetail.put("take_home_yn",sDischargeYNForMedicalItem); // For Take Home Flag
							hmDetail.put("p_ord_practitioner_id",((String)cons_dtl.get("ORD_PRACT_ID"))); // added for SRR20056-SCF-7373

							updateDetail.add(hmDetail);

							hmExp	=	new HashMap();
							hmExp.put("doc_srl_no",cons_dtl.get("BATCH_SRL_NO"));
							hmExp.put("store_code",(String)tabData.get("store_code"));
							hmExp.put("item_code",(String)Batch_det.get("ITEM_CODE"));
							hmExp.put("batch_id",((String)Batch_det.get("BATCH_ID")).trim()); //trim() added for KAUH-SCF-0344
							hmExp.put("bin_location_code",(String)Batch_det.get("BIN_LOCN_CODE"));
							hmExp.put("expiry_date_or_receipt_date",(String)Batch_det.get("EXPIRY_DATE"));
							hmExp.put("trade_id",(String)Batch_det.get("TRADE_ID"));
							hmExp.put("sal_item_qty",issued_qty);
							hmExp.put("ret_item_qty","");
							updateExp.add(hmExp);
							docno		=	(String)cons_dtl.get("DOC_NO");
							doc_srl_no  =   (String)cons_dtl.get("BATCH_SRL_NO");
							data_tmp    =    new Hashtable();
							if(al_stock_update_data.containsKey(docno)){
								data_tmp =(Hashtable) al_stock_update_data.get(docno);
								data_tmp.put(docno+doc_srl_no+"DTL",updateDetail) ;   
								data_tmp.put(docno+doc_srl_no+"EXP",updateExp);
								al_stock_update_data.put(docno,data_tmp);
							}
							else{
								data_tmp.put(docno+doc_srl_no+"DTL",updateDetail) ;    
								data_tmp.put(docno+doc_srl_no+"EXP",updateExp);
								al_stock_update_data.put(docno,data_tmp);
							}
						}
					}
				}
				if(hmPPNValues != null && hmPPNValues.size()>0){
					item_code				= (String)hmPPNValues.get("itemCode")	;
					item_cost				= (String)hmPPNValues.get("itemCost")	;
					
					if(item_cost.equals("")) 
						item_cost	=	"0";
					disp_no = hmDisp_nos.get(hmPPNValues.get("orderId"))==null?"":(String)hmDisp_nos.get(hmPPNValues.get("orderId")); //Added for MMS-SCF-0212 [IN:046496], MMS-SCF-0216 [IN:046529] -Start
					disp_srl_no = "2";
					remarksKey = disp_no+"!"+disp_srl_no+"!"+hmPPNValues.get("orderId")+"!1";
					if(sbRemarksKey.length()>0)
						sbRemarksKey.append(":");
					sbRemarksKey.append(remarksKey); //Added for MMS-SCF-0212 [IN:046496], MMS-SCF-0216 [IN:046529] -End
					hmDetail	=	new HashMap();
					hmDetail.put("doc_srl_no","2");
					hmDetail.put("item_code",item_code);
					hmDetail.put("sal_category","");
					hmDetail.put("hcp_issue_factor","");

					hmDetail.put("item_qty",(String)hmPPNValues.get("selectedQty"));
					hmDetail.put("mm_trn_qty",(String)hmPPNValues.get("selectedQty"));

					cost_value	=	Math.round(Integer.parseInt((String)hmPPNValues.get("selectedQty")) * Double.parseDouble(item_cost)*1000)+"";
					cost_value	=   (Double.parseDouble(cost_value)/1000)+"";
					hmDetail.put("next_due_date","");
					hmDetail.put("stock_item_yn","Y");
					hmDetail.put("remarks",remarksKey); //Added remarksKey for MMS-SCF-0212 [IN:046496], MMS-SCF-0216 [IN:046529]
					hmDetail.put("order_id",(String)hmPPNValues.get("orderId"));
					hmDetail.put("order_line_no","1");
					hmDetail.put("disp_no",disp_no);
					hmDetail.put("disp_srl_no",disp_srl_no); //Added remarksKey for MMS-SCF-0212 [IN:046496], MMS-SCF-0216 [IN:046529] -end
					hmDetail.put("item_unit_cost",item_cost);
					//hmDetail.put("item_sal_value",cost_value);//commented for  MMS-SCF-0275 [IN:047212]
					//hmDetail.put("item_cost_value",cost_value);//commented for  MMS-SCF-0275 [IN:047212]
					hmDetail.put("item_sal_value",item_cost); //Added for MMS-SCF-0275 [IN:047212]
					hmDetail.put("item_cost_value",item_cost); //Added for  MMS-SCF-0275 [IN:047212]
					hmDetail.put("item_unit_price",item_cost);
					hmDetail.put("uom_code",(String)hmPPNValues.get("UOMCode"));
					if(curr_disp_stage.equals("AS")) //if block and else added for  MMS-SCF-0124 [IN:044456]
						hmDetail.put("mode","1");
					else
						hmDetail.put("mode",(String)tabData.get("mode"));
					hmDetail.put("p_ord_practitioner_id",((String)hmPPNValues.get("ORD_PRACT_ID"))); // added for SRR20056-SCF-7373

					String p_overridden_det = getBlInclExclDetail(connection,(String)dispTMP.get(0),(String)dispTMP.get(1),sqlMap);
					if(p_overridden_det!=null && !p_overridden_det.equals("")){
						p_overridden_excl_incl_ind = p_overridden_det.substring(0,1);
						p_overridden_action_reason = p_overridden_det.substring(p_overridden_det.indexOf(":")+1);
					}
					hmDetail.put("p_overridden_excl_incl_ind",p_overridden_excl_incl_ind);
					hmDetail.put("p_overridden_action_reason",p_overridden_action_reason);

					hmDetail.put("take_home_yn",sDischargeYNForMedicalItem); // For Take Home Flag

					updateDetail.add(hmDetail);

						// Batch Details
					batch_id		= (String)hmPPNValues.get("batchId");
					expiry_date		= (String)hmPPNValues.get("expiryDate");
					disp_qty		= (String)hmPPNValues.get("selectedQty");
					trade_id		= (String)hmPPNValues.get("tradeId");
					bin_locn_code	= (String)hmPPNValues.get("binLocation");

					p_overridden_excl_incl_ind = "";
					p_overridden_action_reason = "";

					hmExp	=	new HashMap();
					hmExp.put("doc_srl_no","2");
					hmExp.put("store_code",(String)tabData.get("store_code"));
					hmExp.put("item_code",item_code);
					hmExp.put("batch_id",batch_id.trim()); //trim() added for KAUH-SCF-0344
					hmExp.put("bin_location_code",bin_locn_code);
					hmExp.put("expiry_date_or_receipt_date",expiry_date);
					hmExp.put("trade_id",trade_id);
					hmExp.put("sal_item_qty",disp_qty);

					hmExp.put("ret_item_qty","");
					updateExp.add(hmExp);

					doc_srl_no  =   "2";
					data_tmp    =    new Hashtable();
					Iterator iteStocks = al_stock_update_data.keySet().iterator();

					if(iteStocks != null && iteStocks.hasNext()){
						docno = (String) iteStocks.next();

						data_tmp =(Hashtable) al_stock_update_data.get(docno);
						data_tmp.put(docno+doc_srl_no+"DTL",updateDetail) ;   
						data_tmp.put(docno+doc_srl_no+"EXP",updateExp);
						al_stock_update_data.put(docno,data_tmp);
					}
				}
			}
			if(al_stock_update_data.size()>0){
				ArrayList dtl_data =new ArrayList();
				ArrayList exp_data =new ArrayList();
				Enumeration v1=al_stock_update_data.keys();  
				String doc_no ="";
				ArrayList temp = null;
				String key = "";
				Enumeration v2 = null;
				while (v1.hasMoreElements() ) {
                    dtl_data =new ArrayList(); 
                    exp_data =new ArrayList(); 
					doc_no   =((String)v1.nextElement()).trim();
                    data_tmp =(Hashtable)al_stock_update_data.get(doc_no);
					v2=data_tmp.keys(); 
					while (v2.hasMoreElements() ) {
						key =((String)v2.nextElement()).trim();
						if((key.substring(key.length()-3,key.length())).equals("DTL")){
							temp =(ArrayList) data_tmp.get(key);
							for(int m=0;m<temp.size();m++){
								dtl_data.add(temp.get(m));
							}
						}
						else{
							temp =(ArrayList) data_tmp.get(key);
							for(int m=0;m<temp.size();m++){
								exp_data.add(temp.get(m));
							}
						}
					} 

                    stock_dtls		=	new HashMap();
                    stock_dtls.put("insertDetail",insertDetail);
					stock_dtls.put("updateDetail",dtl_data);
					stock_dtls.put("insertExp",insertExp);
					stock_dtls.put("updateExp",exp_data);
					stock_dtls.put("hdrRemarksKey",sbRemarksKey.toString());//Added for MMS-SCF-0212 [IN:046496], MMS-SCF-0216 [IN:046529]
					updateStock(connection,tabData,sqlMap,stock_dtls,orders,doc_no,st_doc_type,token_series_code,token_no);
				}
			}
			else{
				if(insertDetail.size()>0 || updateDetail.size()>0){//if condition is added for incident No:32227
					stock_dtls.put("insertDetail",insertDetail);
					stock_dtls.put("updateDetail",updateDetail);
					stock_dtls.put("insertExp",insertExp);
					stock_dtls.put("updateExp",updateExp);
					stock_dtls.put("hdrRemarksKey",sbRemarksKey.toString());//Added for MMS-SCF-0212 [IN:046496], MMS-SCF-0216 [IN:046529]
					updateStock(connection,tabData,sqlMap,stock_dtls,orders,docno,st_doc_type,token_series_code,token_no);
				}
			}
		}
		catch(Exception e) {
			System.err.println("error while updating stock tabData="+tabData);
			e.printStackTrace();
			throw new EJBException(e.getMessage());
			//throw e;
		}
	}

	public void updateStock(Connection connection,HashMap tabData, HashMap sqlMap, HashMap stock_dtls,ArrayList orders, String prev_doc_no,String  st_doc_type,String token_series_code,String token_no) throws Exception{
	//	Stock Insertion starts
		HashMap hmHeader	    =	new HashMap();
		HashMap hmCommon	    =	new HashMap();
		HashMap hmData		    =	new HashMap();
		ArrayList language_data =   new ArrayList();
		String patient_class_PC	=   "";
		String bl_doc_type_code =   "";
		String bl_doc_no		=   "";
        //ArrayList dispTMP					= (ArrayList)tabData.get("dispTMP"); //Commented for COMMON-ICN-0048
		ArrayList insertDetail	=	(ArrayList)stock_dtls.get("insertDetail");
		ArrayList updateDetail	=	(ArrayList)stock_dtls.get("updateDetail");
		ArrayList insertExp		=	(ArrayList)stock_dtls.get("insertExp");
		ArrayList updateExp		=	(ArrayList)stock_dtls.get("updateExp");
		String hdrRemarksKey	=	(String)stock_dtls.get("hdrRemarksKey");//Added for MMS-SCF-0212 [IN:046496], MMS-SCF-0216 [IN:046529]
		String encounter_id		=	"";
		String LanguageId		=   (String)tabData.get("LanguageId");
		//String iqviaAuthStatusDispData = "";//mohe-crf-0026.1 start //Commented for COMMON-ICN-0048
		String iqviaIntegrationFlag = ""; 
		String postAuthStatusData       ="";
		String authStatusCompleted_yn = ""; 
		String ivPrep_yn = (String)tabData.get("IV_PREP_YN"); 
		authStatusCompleted_yn = (String)tabData.get("authStatusCompleted_yn"); 
		postAuthStatusData = (String)tabData.get("postAuthStatusData");
		iqviaIntegrationFlag = (String)tabData.get("iqviaIntegrationFlag"); //END 
		ArrayList arrInterfaceDet = (ArrayList) tabData.get("arrInterfaceDet"); //END 
	/*	System.out.println("iqviaAuthStatusDispData: "+iqviaAuthStatusDispData);
		System.out.println("iqviaIntegrationFlag: "+iqviaIntegrationFlag);  
		System.out.println("ivPrep_yn: "+ivPrep_yn);  */
		//ArrayList dispTMP		= (ArrayList)tabData.get("dispTMP");
		
		String locn_code				= (String)tabData.get("source_code")==null?"":(String)tabData.get("source_code"); //Added for AMS-CRF-0258
		
		if(token_series_code!=null && !token_series_code.equals("")&&!token_no.equals("")) {
					
			hmHeader.put("token_series_code",token_series_code);
			hmHeader.put("token_serial_no",token_no);
		}

		if(tabData.get("encounter_id")==null || ((String)tabData.get("encounter_id")).equals("") || ((String)tabData.get("encounter_id")).equals("null")|| ((String)tabData.get("encounter_id")).equals("11111")) {
			encounter_id	=	"";
		}
		else {
			encounter_id	=	(String)tabData.get("encounter_id");
		}
	
		PreparedStatement pstmt_update_disp_hdr_tmp	=	null;
		PreparedStatement pstmt_update_disp_hdr  	=	null;
		hmHeader.put("facility_id",(String)tabData.get("facility_id"));
		hmHeader.put("doc_type_code",st_doc_type);
		hmHeader.put("doc_no","");
		//hmHeader.put("doc_date",(String)tabData.get("today"));
		hmHeader.put("doc_date",com.ehis.util.DateUtils.getCurrentDate("DMY","en'"));
		hmHeader.put("doc_ref","");
		hmHeader.put("store_code",(String)tabData.get("store_code"));

		if((( ((String)tabData.get("disp_stage")).equals("A")|| ((String)tabData.get("disp_stage")).equals("F") )&&((String)tabData.get("DispBillingStage")).equals("A"))||   (((String)tabData.get("disp_stage")).equals("D")&&((String)tabData.get("DispBillingStage")).equals("D")) ){
			hmHeader.put("authorized_by_id",(String)tabData.get("login_by_id"));
		}
		else{
			hmHeader.put("authorized_by_id","");
		}

		if(tabData.containsKey("curr_disp_stage")){
			if(((String)tabData.get("curr_disp_stage")).equals("AS")&&!((String)tabData.get("DispBillingStage")).equals("X")){
				  hmHeader.put("authorized_by_id",(String)tabData.get("login_by_id"));
		   }
		   else{
				hmHeader.put("authorized_by_id","");
		   }
	   }

		hmHeader.put("cancelled_by_id","");
		hmHeader.put("cancelled_remarks","");

		if( ((String)tabData.get("disp_stage")).equals("D"))
			hmHeader.put("finalized_yn","Y");
		else
			hmHeader.put("finalized_yn","N");

		hmHeader.put("gl_interfaced_yn","N");
		hmHeader.put("billable_trn_yn","N");
		hmHeader.put("take_home_yn","N");
		hmHeader.put("trn_type","SAL");
		hmHeader.put("add_qty_sal_yn","N");
		hmHeader.put("patient_id",(String)tabData.get("patient_id"));
		hmHeader.put("encounter_id",encounter_id);
		hmHeader.put("sal_trn_type",(String)tabData.get("patient_class"));
		hmHeader.put("remarks",hdrRemarksKey); //Added hdrRemarksKey for MMS-SCF-0212 [IN:046496], MMS-SCF-0216 [IN:046529]
		hmHeader.put("item_class_code","");
		hmHeader.put("module_id","PH");
		hmHeader.put("barcode_2d_applicable_yn",(String)tabData.get("barcode_2d_applicable_yn"));//Added for MMS-DM-CRF-0174.5

//===============code added for BL interface on 4/22/2006==================
		PreparedStatement pstmt_select	=	null;
		ResultSet resultSet			    = null;	
		String bl_interface_yn			=(String)tabData.get("billing_interface_yn");
/*
		try {
			pstmt_select			= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_BL_SELECT2") ) ;
			pstmt_select.setString(1, (String)tabData.get("facility_id"));
			resultSet				= pstmt_select.executeQuery();
			if (resultSet.next() ) {
				bl_interface_yn=resultSet.getString("BL_INTERFACE_YN");
				if(bl_interface_yn==null){
					bl_interface_yn="N";
				}
			}
		}catch ( Exception e ) {
			System.err.println( " tabData="+tabData ) ;
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt_select ) ;
		}
*/
		hmHeader.put("billable_trn_yn",bl_interface_yn);//billable_trn_yn
//		if(bl_interface_yn.equals("Y"))	{

           if(!encounter_id.equals("")){
				PreparedStatement pstmtPC	= null;
				ResultSet resultSetPC		= null;
				try {
					pstmtPC		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_BL_SELECT1") ) ;
					pstmtPC.setString(1,(String)tabData.get("ordering_facility_id"));
					pstmtPC.setString(2,encounter_id);
					pstmtPC.setString(3,(String)tabData.get("patient_id")); //added for [IN:035667] to avaoid duplicate encounter id with 11111 for EXT Prescription
					resultSetPC	= pstmtPC.executeQuery() ;
					if(resultSetPC.next()){
						patient_class_PC = resultSetPC.getString("ENC_PATIENT_CLASS");//I - IP, O-> OP, D->DayCare,E->EM, R->XT
					}else{
						patient_class_PC="R";//added for ML-BRU-SCF-1927
					}
				}
				catch ( Exception e ) {
					e.printStackTrace() ;	
				}
				finally {
					closeResultSet( resultSetPC ) ;
					closeStatement( pstmtPC ) ;
				}
		   }
		   else{
                patient_class_PC="R";
		   }

			hmHeader.put("sal_trn_type",patient_class_PC);
			hmHeader.put("NU_Clinic_code",locn_code); //Added for AMS-CRF-0258
	//	}

//=========BL related interface coding ends here====================
		hmCommon.put("login_by_id",(String)tabData.get("login_by_id"));
		hmCommon.put("login_at_ws_no",(String)tabData.get("login_at_ws_no"));
		hmCommon.put("practitioner_id",(String)tabData.get("performing_pract_id")); // Added for GHL-SCF-1365
		hmCommon.put("login_facility_id",(String)tabData.get("facility_id"));
		hmCommon.put("FACILITY_STR_FOR_BL",(String)tabData.get("ordering_facility_id")+"|"+(String)tabData.get("facility_id"));
		hmCommon.put("DispBillingStage",(String)tabData.get("DispBillingStage"));

		language_data.add(LanguageId);

		hmData.put("HDR_DATA",hmHeader);
		hmData.put("COMMON_DATA",hmCommon);
		hmData.put("LANGUAGE_DATA",language_data);

		String errod_id	="";
	    String message	="";
		String item_code="";
		String drug_desc="";
		try{
			if(insertDetail.size()==0&& updateDetail.size()==0){
				System.err.println("===tabData===="+tabData+"==stock_dtls===="+stock_dtls);
				System.err.println("===prev_doc_no===="+prev_doc_no+"====st_doc_type===="+st_doc_type);
				throw new EJBException("Error: Stock updation failed in Dispensing");
			}
			if(insertDetail.size()!=0){
			/** @ 
					 CRF_SRR20056-CRF-0537.1 
					 For handle the Decimals in QOH, get the Item codes to check ALLOW_DECIMALS_YN begin
			**/
				StringBuffer sbItemCode = new StringBuffer("(");

				for(int insDet = 0 ; insDet<insertDetail.size();insDet++){
					// get HashMap frm "insertDetail" then get "item_code", convert to String and add in StringBuffer
					sbItemCode.append(" '");
					sbItemCode.append(((HashMap)insertDetail.get(insDet)).get("item_code").toString()).append("'");

					if(insertDetail.size()>(insDet+1))
						sbItemCode.append(",");
				}
				sbItemCode.append(")");
				HashMap hmDecimalAllowedYN =  getDecimalAllowedYN(sbItemCode.toString());

				if(hmDecimalAllowedYN != null){
					HashMap hmTmp = null;
					for(int insDet = 0 ; insDet<insertDetail.size();insDet++){
						hmTmp =	(HashMap)insertDetail.get(insDet);
						hmTmp.put("decimal_allowedYN",hmDecimalAllowedYN.get(hmTmp.get("item_code").toString()));		
						insertDetail.set(insDet,hmTmp);
					}
				}

			/** @ 
					 CRF_SRR20056-CRF-0537.1 
					 For handle the Decimals in QOH, get the Item codes to check ALLOW_DECIMALS_YN End
			**/

				hmData.put("DTL_DATA",insertDetail);
				hmData.put("DTL_EXP_DATA",insertExp);
				eST.Common.StSales	stSales		=	new eST.Common.StSales();
				HashMap map							=	stSales.insertSales(connection,hmData);
				if( !(((Boolean) map.get( "result" )).booleanValue()) )	{
					connection.rollback();
					errod_id = (String)map.get("msgid");
					message  = (String)map.get("message");
					if(errod_id.equals(message))
						message="";

					if(errod_id.equals("INSUFFICIENT_BATCH_QTY") || errod_id.equals("BATCH_RECORD_NOT_FOUND")){ //BATCH_RECORD_NOT_FOUND added for MMS-SCF-0306 [IN:047499]
						item_code =(String)map.get("ITEM_CODE");
						drug_desc =getDrugDesc(connection, item_code , LanguageId);
						map.put("DRUG_DESC",drug_desc);
						if(drug_desc!=null && !drug_desc.equals(""))
						   drug_desc = " - "+drug_desc;
					}
					throw new EJBException(errod_id+":-"+message+" : "+item_code+drug_desc);//"insert Sales failed"
				} 
				else {
					String docno				=	(String)map.get("doc_no");
					String doctypecode			=	(String)map.get("doc_type_code");
					if(alSalDocDtls==null) //Added for AMS-CRF-0079 [IN:050762] -start
						alSalDocDtls = new ArrayList();
					if(!alSalDocDtls.contains(doctypecode+"-"+docno))
						alSalDocDtls.add(doctypecode+"-"+docno); //Added for AMS-CRF-0079 [IN:050762] -end
					pstmt_update_disp_hdr_tmp	=	null;

					//pstmt_update_disp_hdr_tmp	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_HRD_TMP_UPDATE") ) ;
					pstmt_update_disp_hdr_tmp	= connection.prepareStatement("UPDATE PH_DISP_HDR_TMP SET DOC_TYPE=?, DOC_NO=?, CERT_REIMB_NO =? WHERE ORDER_ID = ? AND FACILITY_ID= ? and disp_tmp_no = ?" ) ;
					 
					// pstmt_update_disp_hdr		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_HRD_UPDATE") ) ;
					 pstmt_update_disp_hdr		= connection.prepareStatement( "UPDATE PH_DISP_HDR SET DOC_TYPE=?, DOC_NO=?,CERT_REIMB_NO =? WHERE DISP_NO = ? AND FACILITY_ID= ?") ;

					String order_id				= "";
					for(int h=0;h<orders.size();h++){

						order_id=((String)orders.get(h)).trim().substring(0,15);
						pstmt_update_disp_hdr_tmp.setString(1,doctypecode );
						pstmt_update_disp_hdr_tmp.setString(2,docno); 
						if(tabData.containsKey("CER_RES_NO")){
							pstmt_update_disp_hdr_tmp.setString(3,(String)tabData.get("CER_RES_NO"));  
						}
						else{
							pstmt_update_disp_hdr_tmp.setString(3,""); 
						}
						pstmt_update_disp_hdr_tmp.setString(4,order_id);
						pstmt_update_disp_hdr_tmp.setString(5,(String)tabData.get("facility_id"));
						pstmt_update_disp_hdr_tmp.setString(6,(String)((HashMap)tabData.get("seq_no")).get(order_id));
						pstmt_update_disp_hdr_tmp.executeUpdate();

						HashMap hmSeqNo = (HashMap)tabData.get("seq_no");
						if(hmSeqNo!=null && hmSeqNo.containsKey(order_id)){
						//if(((HashMap)tabData.get("seq_no")).containsKey(order_id)){
							pstmt_update_disp_hdr.setString(1,doctypecode );
							pstmt_update_disp_hdr.setString(2,docno);
							if(tabData.containsKey("CER_RES_NO")){
								 pstmt_update_disp_hdr.setString(3,(String)tabData.get("CER_RES_NO"));  
							}
							else{
								 pstmt_update_disp_hdr.setString(3,""); 
							}
							pstmt_update_disp_hdr.setString(4,(String)((HashMap)tabData.get("seq_no")).get(order_id));
							pstmt_update_disp_hdr.setString(5,(String)tabData.get("facility_id"));
							pstmt_update_disp_hdr.executeUpdate();
							bl_doc_type_code = doctypecode;
							bl_doc_no        = docno;
						}
					}
				}
			}

			if(updateDetail.size()!=0) {

				//PreparedStatement pstmt_select1	=	null;
		       // ResultSet resultSet1		    = null;
				//int count =0;

				hmHeader.put("doc_no",prev_doc_no);
				hmHeader.put("doc_type_code",st_doc_type);
/*Commented for SRR20056-SCF-7582, SRR20056-SCF-7212.1, Incident No. 028146 -Start
                pstmt_select1=connection.prepareStatement("select count(*) count from ph_disp_hdr_tmp  where doc_no= ? and DOC_TYPE=? and facility_id=? and disp_locn_code=?");

				pstmt_select1.setString(1,prev_doc_no);
				pstmt_select1.setString(2,st_doc_type);
				pstmt_select1.setString(3,(String)tabData.get("facility_id"));
				pstmt_select1.setString(4,(String)tabData.get("store_code"));
					resultSet1	= pstmt_select1.executeQuery() ;
			

				if(resultSet1.next()){
						count = resultSet1.getInt("count");
				}
				if(count>0){
					hmHeader.put("finalized_yn","N");				
				}
Commented for SRR20056-SCF-7582, SRR20056-SCF-7212.1, Incident No. 028146 -END */
					hmHeader.put("finalized_yn","Y");	//Added for SRR20056-SCF-7582, SRR20056-SCF-7212.1, Incident No. 028146	

				/** @ 
						 CRF_SRR20056-CRF-0537.1 
						 For handle the Decimals in QOH, get the Item codes to check ALLOW_DECIMALS_YN begin
				**/
				StringBuffer sbItemCode = new StringBuffer("(");

				for(int iUpdateDet = 0 ; iUpdateDet<updateDetail.size();iUpdateDet++){
					// get HashMap frm "updateDetail" then get "item_code", convert to String and add in StringBuffer
					sbItemCode.append(" '");
					sbItemCode.append(((HashMap)updateDetail.get(iUpdateDet)).get("item_code").toString()).append("'");

					if(updateDetail.size()>(iUpdateDet+1))
						sbItemCode.append(",");
				}
				sbItemCode.append(")");
				HashMap hmDecimalAllowedYN =  getDecimalAllowedYN(sbItemCode.toString());

				if(hmDecimalAllowedYN != null){
					HashMap hmTmp = null;
					for(int iUpdateDet = 0 ; iUpdateDet<updateDetail.size();iUpdateDet++){
						hmTmp =	(HashMap)updateDetail.get(iUpdateDet);
						hmTmp.put("decimal_allowedYN",hmDecimalAllowedYN.get(hmTmp.get("item_code").toString()));		
						updateDetail.set(iUpdateDet,hmTmp);
					}
				}

				/** @ 
					CRF_SRR20056-CRF-0537.1 
					For handle the Decimals in QOH, get the Item codes to check ALLOW_DECIMALS_YN End
				**/

				hmData.put("HDR_DATA",hmHeader);
				hmData.put("DTL_DATA",updateDetail);
				hmData.put("DTL_EXP_DATA",updateExp);
				eST.Common.StSales	stSales	=	new eST.Common.StSales();
				HashMap map					=	stSales.updateSales(connection,hmData);
				if( !(((Boolean) map.get( "result" )).booleanValue()) )	{
					connection.rollback();
					errod_id=(String)map.get("msgid");
					message = (String)map.get("message");
					errod_id = errod_id.replace("javax.ejb.EJBException:","");
					errod_id = errod_id.replace("java.lang.Exception:","");
					message = message.replace("javax.ejb.EJBException:","");
					message = message.replace("java.lang.Exception:","");
					errod_id = errod_id.trim();
					message = message.trim();
					if(errod_id.equals(message))
						message="";
					if(errod_id.equals("INSUFFICIENT_BATCH_QTY")){
					   item_code =(String)map.get("ITEM_CODE");
					   drug_desc =getDrugDesc(connection, item_code , LanguageId);
					   map.put("DRUG_DESC",drug_desc);
					   if(drug_desc!=null && !drug_desc.equals(""))
						   drug_desc = " - "+drug_desc;
				    }
					if(errod_id.contains("POPULATE_MAT_INTERFACED_RECS-1ORA-00001: unique constraint"))
						message = "APP-PH0900 Record already exists in Patient Charge Folio";
					if(!message.equals(""))
						message = message+" ";

					throw new EJBException(message+item_code+drug_desc+"\n"+errod_id);//"update Sales failed"
				} 
				else {
					//String order_id="";
					bl_doc_type_code = st_doc_type;
					bl_doc_no        = prev_doc_no;
					if(alSalDocDtls==null)//Added for AMS-CRF-0079 [IN:050762] -start
						alSalDocDtls = new ArrayList();
					if(!alSalDocDtls.contains(st_doc_type+"-"+prev_doc_no))
						alSalDocDtls.add(st_doc_type+"-"+prev_doc_no); //Added for AMS-CRF-0079 [IN:050762] -end
				}
			}
			String disp_stage           = (String)tabData.get("disp_stage");  
			String disp_cash_coll_stage = (String)tabData.get("DISP_CASH_COLL_STAGE"); 
			String curr_disp_stage		= tabData.get("curr_disp_stage")==null?"":(String)tabData.get("curr_disp_stage");//added for mms-dm-scf-575
						System.err.println("575===patient_class_PC==6373="+patient_class_PC);//added for MMS-DM-SCF-0575
			System.err.println("===bl_interface_yn==6373="+bl_interface_yn);//added for MMS-DM-SCF-0575
			System.err.println("===disp_cash_coll_stage==6373="+disp_cash_coll_stage);//added for MMS-DM-SCF-0575
			System.err.println("===disp_stage==6373="+disp_stage);//added for MMS-DM-SCF-0575
			String settlement_id="";//MOHE-CRF-0026.1 
			settlement_id= (String)tabData.get("settlement_id");   
		
  			if(iqviaIntegrationFlag==null || iqviaIntegrationFlag.equals("null") ){
				iqviaIntegrationFlag = "N"; 
			}  
			if(patient_class_PC.equals("O") && iqviaIntegrationFlag.equals("Y") && settlement_id.equals("X")){  
			
				if((disp_stage.equals("D")&& disp_cash_coll_stage.equals("D") && (ivPrep_yn==null || ivPrep_yn.equals("") || ivPrep_yn.equals("null")) )|| ( curr_disp_stage.equals("AS") && (ivPrep_yn==null || ivPrep_yn.equals("") || ivPrep_yn.equals("null")) ) ){  
					if(authStatusCompleted_yn!= null && !authStatusCompleted_yn.equals("") && authStatusCompleted_yn.equals("Y")){
						getBillingInsuranceDetails( connection, sqlMap, tabData, bl_doc_type_code, bl_doc_no, arrInterfaceDet);  
					}
					
				}
			}
			if((!patient_class_PC.equals("I") && !patient_class_PC.equals("D") )&&bl_interface_yn.equals("Y")&&( !disp_cash_coll_stage.equals("X"))){
				if((disp_stage.equals("D")&& disp_cash_coll_stage.equals("D"))|| (disp_stage.equals("AS")) ){
					//if(!patient_class_PC.equals("I")){ // if condition commented for SRR20056-SCF-7639 ICN027720
						//billing_det =getBillingDetails( connection, (String)tabData.get("facility_id"), (String)tabData.get("store_code"), bl_doc_type_code, bl_doc_no, (String)tabData.get("login_by_id"),(String)tabData.get("login_at_ws_no") , (String)tabData.get("patient_id") , encounter_id, patient_class_PC );
						billing_det =getBillingDetails( connection, (String)tabData.get("ordering_facility_id"), (String)tabData.get("store_code"), bl_doc_type_code, bl_doc_no, (String)tabData.get("login_by_id"),(String)tabData.get("login_at_ws_no") , (String)tabData.get("patient_id") , encounter_id, patient_class_PC ,(String)tabData.get("facility_id"));//facility-id passing for MOHE-CRF-0060
						System.err.println("===BILLING_DET==6377="+billing_det);//added for MMS-DM-SCF-0575
					//}
				}
			}
			////added for mms-dm-scf-0575
			System.out.println(tabData+"tabData"+disp_stage+"prathyusha curr_disp_stage"+curr_disp_stage);
				if((curr_disp_stage.equals("AS"))){
				getDocSrlNo(connection,bl_doc_no,bl_doc_type_code);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.err.println("===tabData==="+tabData);
			System.err.println("===stock_dtls==="+stock_dtls);
			System.err.println("===prev_doc_no==="+prev_doc_no);
			System.err.println("===st_doc_type==="+st_doc_type);

			/*if(errod_id.equals("BATCH_RECORD_NOT_FOUND")){
				message ="APP-PH0901 Batch record not found";
			}else if(errod_id.equals("NEGATIVE_STOCK")){
				message="APP-PH0902 Insufficient Stock - Try the transaction again.";
			}else if(errod_id.equals("SUSPENDED_BATCH")){
				message="APP-PH0903 Suspended batch -  - Try the transaction again.";
			}else */
			/*if(errod_id.equals("INSUFFICIENT_BATCH_QTY")){
				errod_id="APP-PH0904 Insufficient Batch Quantity For "+drug_desc+ "- Try the transaction again.";
			} */
	/*
			if(errod_id!=null && errod_id.equals("INSUFFICIENT_BATCH_QTY")){
				errod_id="APP-PH0904 Insufficient Batch Quantity For "+drug_desc+ "- Try the transaction again.";
			}
			else if(errod_id!=null && errod_id.equals("RECORD_UPDATED_BY_OTH_USER") || e.getMessage().equals("RECORD_UPDATED_BY_OTH_USER")){			  // SRR20056-SCF-7658.1 (Rawther)
				errod_id ="APP-PH0902 Record Already In Use - It is used by Other User.Please Try again...";
			}
			else if(errod_id!=null && errod_id.equals("NEGATIVE_STOCK")){
				errod_id="APP-PH0903 Insufficient (Negative) Stock - Try the transaction again.";
			}
			else{
			 if(errod_id!=null && (errod_id.toString().contains("java.lang")|| errod_id.toString().contains("java.sql")))
				 errod_id ="Error - "+e.getMessage()+" - "+errod_id;
			 else if (errod_id != null)
				 errod_id = errod_id;
			 else   
				errod_id = "Error - "+e;
			}
			if (errod_id != null)
				 errod_id ="Error - "+e.getMessage()+" - "+errod_id;
			 else   
				errod_id = "Error - "+e;*/

			throw new EJBException("Error - "+e.getMessage());
		}
		finally{
			try{
				closeStatement( pstmt_update_disp_hdr_tmp );
				closeStatement( pstmt_update_disp_hdr );

				pstmt_update_disp_hdr_tmp=null;
				closeResultSet( resultSet ) ;
				closeStatement( pstmt_select ) ;
			}
			catch( Exception e){
				e.printStackTrace();
			}
		}
	}

 // Header table insert method
	private HashMap insertHeader(Connection connection, HashMap sqlMap, HashMap tabData,ArrayList dispTMP ) throws Exception {

		PreparedStatement pstmt_insert_disp_hrd	= null;
		ArrayList unique_key				= new ArrayList();
		String sequence_no					=	"";
		String patient_class				=  "";
		HashMap seq_no						=	new HashMap();
		String token_yn						= (String)tabData.get("token_yn");
		String collected_by					=  "";
		String date_time					=  "";
		String Received_at					=  "";
		String practioner_id				=  "";
		String trx_seq_no					=  "";
		String source_type					=  "";
		String source_code					=  "";
		String encounter_id					=  "";
		HashMap order_id_attended_pract_id  =  (HashMap)tabData.get("ORDER_ID_ATTENDED_PRACT_ID");
		String	sTokenSeriesCode			=  "";//tabData.get("token_series_code")==null?"":(String)tabData.get("token_series_code");//Changed "" for HSA-CRF-0136 [IN:048412]
		String sTokenYN						=  tabData.get("token_yn")==null?"N":(String)tabData.get("token_yn");
		String sTokenNo						=  "";
		HashMap hmTokenVals			 	    =  tabData.get("token_vals")==null?new HashMap():(HashMap)tabData.get("token_vals");
		String[] strTokenTemp		= new String[2];//Added for HSA-CRF-0136 [IN:048412]
	// delivery details
	
		ArrayList delivery_details=new ArrayList();
		delivery_details=(ArrayList)tabData.get("delivery_details");
		
		if(delivery_details!=null){
			if(delivery_details.size()==8 && token_yn.equals("N")){
				collected_by		=(String)delivery_details.get(0);
				//gender				=(String)delivery_details.get(1);
				//nationality			=(String)delivery_details.get(2);
				//dispensed_by		=(String)delivery_details.get(3);
				date_time			=(String)delivery_details.get(4);
				Received_at			=(String)delivery_details.get(5);
			  if(Received_at==null ||Received_at.equals(""))
				   Received_at="P";
				practioner_id		=(String)delivery_details.get(6);
			  if(practioner_id==null ||practioner_id.equals(""))
				  practioner_id="";

		   }
		   else if(delivery_details.size()==9 && token_yn.equals("Y")){
				collected_by			=(String)delivery_details.get(0);
				//gender				=(String)delivery_details.get(1);
				// nationality			=(String)delivery_details.get(2);
				//dispensed_by         =(String)delivery_details.get(3);
				date_time            =(String)delivery_details.get(4);
				//token_series_code    =(String)delivery_details.get(5);
				Received_at          =(String)delivery_details.get(6);
				if(Received_at==null ||Received_at.equals(""))
					Received_at="P";
				practioner_id        =(String)delivery_details.get(7);
				if(practioner_id==null ||practioner_id.equals(""))
					practioner_id="";				   
		   }
			if(collected_by.length()>29)
				collected_by = collected_by.substring(0,29);
		}
		try {
			//pstmt_insert_disp_hrd = connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_HRD_INSERT") ) ;

			pstmt_insert_disp_hrd = connection.prepareStatement( "INSERT INTO PH_DISP_HDR ( FACILITY_ID, DISP_NO, DISP_DATE_TIME, DISP_LOCN_CODE, ORDER_ID, ORD_DATE_TIME, PATIENT_ID, ENCOUNTER_ID, PATIENT_CLASS, LOCN_TYPE, LOCN_CODE, ROOM_TYPE, ROOM_NO, BED_NO, BED_CLASS, BED_TYPE, SPECIALITY_CODE, ATTEND_PRACTITIONER_ID, PRES_PHYSICIAN_ID, DISPENSED_BY, DISPENSED_DATE_TIME, AUTHORIZED_BY, DISP_AUTHORIZED_DATE_TIME, DELIVERED_YN, DELIVERED_BY, DELIVERED_DATE_TIME, COLLECTED_BY, RECEIVED_YN, RECEIVED_BY, RECEIVED_DATE_TIME, REF_DISP_NO_FOR_REISSUE, DISP_REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID ,RECEIVED_AT, COUNTER_CHKD_BY,DISP_TRN_SEQ_NO,TOKEN_SERIAL_NO,TOKEN_SERIES_CODE)  VALUES ( ?,?,TRUNC(SYSDATE), ?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI'), ?,?,?, ?,?,?, ?,?,?, ?,?,?, ?,?,SYSDATE, ?,TO_DATE(?,'DD/MM/YYYY HH24:MI'),?,?, TO_DATE(?,'DD/MM/YYYY HH24:MI'),?,?, ?,TO_DATE(?,'DD/MM/YYYY HH24:MI'), ?,?,?, SYSDATE,?,?, ?,SYSDATE,?, ?,?,?,?,?,? )");

			if(((String)tabData.get("patient_class")).equals("O")){
				patient_class = "OP";
			}
			else {
				patient_class = "IP";
			}

			if(tabData.get("encounter_id")==null || ((String)tabData.get("encounter_id")).equals("") || ((String)tabData.get("encounter_id")).equals("11111")) {
				encounter_id	=	"11111";
				source_code		=	(String)tabData.get("disp_locn_code");
				source_type		=	"C";
				patient_class   =   "XT";
			} 
			else {
				encounter_id	=	(String)tabData.get("encounter_id");
				source_code		=	(String)tabData.get("source_code");
				source_type		=	(String)tabData.get("source_type");
			}

			if(dispTMP.size()>0){
			  trx_seq_no =  getSequenceNo("SELECT PH_DISP_TRN_SEQ.NEXTVAL FROM DUAL");
			}
			tabData.put("TRX_SEQ_NO",trx_seq_no);

			for(int i=0;i<dispTMP.size();i=i+7){
				int count = 1;
				if(!unique_key.contains(((String)dispTMP.get(i)).trim())) {
					unique_key.add(((String)dispTMP.get(i)).trim());
					sequence_no = getSequenceNo((String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT33"));
					seq_no.put(((String)dispTMP.get(i)).trim(),sequence_no);

					pstmt_insert_disp_hrd.setString(count,(String)tabData.get("facility_id"));
					pstmt_insert_disp_hrd.setString(++count,sequence_no);
					pstmt_insert_disp_hrd.setString(++count,(String)tabData.get("disp_locn_code"));
					pstmt_insert_disp_hrd.setString(++count,((String)dispTMP.get(i)).trim());
					pstmt_insert_disp_hrd.setString(++count,(String)tabData.get("ord_date_time"));
					pstmt_insert_disp_hrd.setString(++count,(String)tabData.get("patient_id"));
					pstmt_insert_disp_hrd.setString(++count,encounter_id);
					pstmt_insert_disp_hrd.setString(++count,patient_class);
					pstmt_insert_disp_hrd.setString(++count,source_type);
					pstmt_insert_disp_hrd.setString(++count,source_code);
					pstmt_insert_disp_hrd.setString(++count,"");
					pstmt_insert_disp_hrd.setString(++count,"");
					pstmt_insert_disp_hrd.setString(++count,"");
					pstmt_insert_disp_hrd.setString(++count,"");
					pstmt_insert_disp_hrd.setString(++count,"");
					pstmt_insert_disp_hrd.setString(++count,"");
					//pstmt_insert_disp_hrd.setString(++count,(String)tabData.get("performing_pract_id"));
					//pstmt_insert_disp_hrd.setString(++count,(String)tabData.get("performing_pract_id"));
					pstmt_insert_disp_hrd.setString(++count,(String)(order_id_attended_pract_id.get(((String)dispTMP.get(i)).trim())));//pres_physician_id
					pstmt_insert_disp_hrd.setString(++count,(String)(order_id_attended_pract_id.get(((String)dispTMP.get(i)).trim())));//pres_physician_id
					pstmt_insert_disp_hrd.setString(++count,(String)tabData.get("login_by_id"));
					pstmt_insert_disp_hrd.setString(++count,"");
					pstmt_insert_disp_hrd.setString(++count,"");
					pstmt_insert_disp_hrd.setString(++count,"Y");
					pstmt_insert_disp_hrd.setString(++count,(String)tabData.get("login_by_id"));
					pstmt_insert_disp_hrd.setString(++count,"");
					pstmt_insert_disp_hrd.setString(++count,collected_by);
					pstmt_insert_disp_hrd.setString(++count,"Y");
					pstmt_insert_disp_hrd.setString(++count,"");
					pstmt_insert_disp_hrd.setString(++count,date_time);
					pstmt_insert_disp_hrd.setString(++count,"Y");
					pstmt_insert_disp_hrd.setString(++count,"");
					pstmt_insert_disp_hrd.setString(++count,(String)tabData.get("login_by_id"));
					pstmt_insert_disp_hrd.setString(++count,(String)tabData.get("login_at_ws_no"));
					pstmt_insert_disp_hrd.setString(++count,(String)tabData.get("facility_id"));
					pstmt_insert_disp_hrd.setString(++count,(String)tabData.get("login_by_id"));
					pstmt_insert_disp_hrd.setString(++count,(String)tabData.get("login_at_ws_no"));
					pstmt_insert_disp_hrd.setString(++count,(String)tabData.get("facility_id"));
					pstmt_insert_disp_hrd.setString(++count,Received_at);
					pstmt_insert_disp_hrd.setString(++count,practioner_id); 
					pstmt_insert_disp_hrd.setString(++count,trx_seq_no); 
					if(sTokenYN.equals("Y")){
						//sTokenNo = hmTokenVals.get(((String)dispTMP.get(i)).trim())==null?"":(String)hmTokenVals.get(((String)dispTMP.get(i)).trim());	
						strTokenTemp = (hmTokenVals.get(((String)dispTMP.get(i)).trim())==null?"":(String)hmTokenVals.get(((String)dispTMP.get(i)).trim())).split("_");//Changed for HSA-CRF-0136 [IN:048412]
						sTokenSeriesCode = strTokenTemp[0];//Added for HSA-CRF-0136 [IN:048412]
						sTokenNo = strTokenTemp[1];//Added for HSA-CRF-0136 [IN:048412]
					}
					pstmt_insert_disp_hrd.setString(++count,sTokenNo);
					pstmt_insert_disp_hrd.setString(++count,sTokenSeriesCode);
					pstmt_insert_disp_hrd.addBatch();
				}
			}
			int[] result4	=pstmt_insert_disp_hrd.executeBatch();
			for (int i=0;i<result4.length ;i++ ){
				if(result4[i]<0  && result4[i] != -2 ){
					pstmt_insert_disp_hrd.cancel();
					connection.rollback();
					throw new EJBException("Error: Hdr main insert Failed");
				}		
			}
		}
		catch(Exception e){
			e.printStackTrace();		
			//try {
			connection.rollback();
			throw new EJBException("Error: HDR_MAIN INSERTION FAILED");
			//}catch(Exception es) { es.printStackTrace();}
		}
		finally{	
			try {
				closeStatement( pstmt_insert_disp_hrd ) ;
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return seq_no;
	}
// Detail Table insert
	private HashMap insertDetail(Connection connection, HashMap sqlMap, HashMap tabData,ArrayList dispTMP, HashMap seq_no, HashMap stock_srl) throws Exception{
		PreparedStatement pstmt_insert_disp_dtl			= null;
		PreparedStatement pstmt_int						= null;
		PreparedStatement pstmt_int_1					= null;
		PreparedStatement pstmt_ind						= null;//Added for AlternateDrug
		PreparedStatement pstmt							= null;
		PreparedStatement pstmt1						= null;
		PreparedStatement pstmt_update_ororder			= null;
		PreparedStatement pstmt_pres_remark_select		= null;
		PreparedStatement pstmt_pres_remark_select_1    = null;
		ResultSet resultSet1							= null;
		ResultSet resultSet2							= null;
		String pres_remark				=	"";	
		int count						=	1;
		int jj							=	1;
		int tmp_no						=	1;
		int tmp_srl_cnt					=	 1;
		String prev_order_id			=	"";
		String item_code				=	"";
		String fillcode					=   "";
		String fillremarks				=   "";
		String delivery_code			=	"";
		String delivery_remarks			=	"";
		String allocate_code			=	"";
		String allocate_remarks			=	"";
		String drug_indication			=   "";//Added for MainDrug
		String alt_drugindication		=   "";//Added for AlternateDrug
		ResultSet resultSet				=   null;	

		HashMap	fillingRemarks			=   (HashMap)tabData.get("fillingRemarks");
		HashMap deliveryRemarks			=   (HashMap)tabData.get("deliveryRemarks");
		HashMap allocateRemarks			=   (HashMap)tabData.get("allocatefill_remarks");
		HashMap editLabel				=   (HashMap)tabData.get("editLabel");
		String LanguageId				=   (String)tabData.get("LanguageId");
	//code added for bl interface
		HashMap bl_reasons				=   (HashMap)tabData.get("BL_REASONS");
		HashMap bl_det					=	new HashMap();
		String bl_override_rason		=	"";	
		String bl_inc_exec				=	"";	
		String patient_id				=	(String)tabData.get("patient_id");
		String billing_interface_yn	    =	(String)tabData.get("billing_interface_yn");
		String disp_level               =   (String)tabData.get("DISP_LEVEL"); 
		String cer_res_yn               =   "N"; 
		
		ArrayList  lang_ids             = new ArrayList();
		ArrayList	temp                = new ArrayList();
		ArrayList caution				= new ArrayList();
		ArrayList special				= new ArrayList();
		ArrayList pat_int				= new ArrayList();
		String caution_1				= "";	
		String special_1				= "";	
		String patient_int				= "";
		String loc_caution_1			= "";
		String loc_special_1			= "";	
		String loc_patient_int			= "";
		HashMap issue_uom_dtl			=	new HashMap();
		HashMap charge_dtls				= (HashMap)tabData.get("CHARGE_DTLS");
		HashMap editableLabel			= tabData.get("editableLabel")!=null?(HashMap)tabData.get("editableLabel"):null; // Added for Bru-HIMS-CRF-414 [IN:045554]
		String allow_edit_disp_label	= tabData.get("allow_edit_disp_label")!=null?(String)tabData.get("allow_edit_disp_label"):""; 
		//String editableLabelLangId	= tabData.get("editableLabelLangId")!=null?(String)tabData.get("editableLabelLangId"):"en"; //Commented for COMMON-ICN-0048
		PreparedStatement pstmt_disp_label_select_disp_dtl	= null;
		PreparedStatement pstmt_disp_label_select_count	= null;
		PreparedStatement pstmtDispLabelInsert	= null;
		PreparedStatement pstmtDispLabelUpdate	= null;
		ResultSet rsDispDtl	= null, rsLablCount=null ;
		List lEditLabelKeys = null;
		String strLblTempKey="", strLabelLangTmp="";
		if(allow_edit_disp_label.equals("Y") && editableLabel!=null && editableLabel.size()>0){ //if block Added for Bru-HIMS-CRF-414 [IN:045554]
			pstmt_disp_label_select_disp_dtl	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_LABEL_SELECT_DISP_DTL") ) ;
			pstmt_disp_label_select_count	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_LABEL_SELECT_COUNT") ) ;
			pstmtDispLabelInsert	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_LABEL_INSERT") ) ;
			pstmtDispLabelUpdate	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_LABEL_UPDATE") ) ;
		}
		int insertCount = 0, updateCount=0, icount=1,iLblCount	=	0;
		ArrayList alLabelDtl = null;
		String disp_no="", disp_srl_no="", sKey1="", dispQty=""; // Added for Bru-HIMS-CRF-414 [IN:045554] -end
		if(tabData.containsKey("ISSUE_UOM_QTY")){
			 issue_uom_dtl =(HashMap)tabData.get("ISSUE_UOM_QTY");
		 }
	
		try {
			pstmt					    = connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDI_EDIT_INSTRUCTIONS")) ;
			//pstmt_int				    = connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDI_EDIT_INT_RESULTS")) ;
			pstmt_int		            = connection.prepareStatement("SELECT LABEL_TEXT_ID, LABEL_TEXT_1, language_id FROM PH_LABEL_TEXT_LANG_VW PH_LABEL_TEXT WHERE LABEL_TEXT_ID=? and rownum<3 "); //LABEL_TEXT_ID added for HSA-CRF-0178/04 All Stages Label [IN:052990]
			pstmt_int_1                 = connection.prepareStatement("select HOW_TO_TAKE_TEXT from ph_drug_lang_vw where drug_code =? and language_id=?");
			pstmt1						= connection.prepareStatement("select language_id  from sm_language where  eff_status='E'  and PRIMARY_LANG_YN ='N' order by seq_no");

			//pstmt_insert_disp_dtl	    = connection.prepareStatement((String)sqlMap.get("SQL_PH_DISP_MEDICATION_DISP_DTL_INSERT")) ;
			pstmt_insert_disp_dtl	    = connection.prepareStatement("INSERT INTO PH_DISP_DTL (FACILITY_ID, DISP_NO, SRL_NO, ORDER_ID, ORDER_LINE_NO, PRES_DRUG_CODE, ORDERING_FACILITY_ID, DISP_LOCN_CODE, STORE_CODE, DISP_DRUG_CODE, ITEM_CODE, STK_UOM_CODE, DISP_QTY, DISP_UOM_CODE, RETURNED_QTY, REISSUE_REASON_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,DOC_SRL_NO , FILL_REMARKS_CODE,FILL_TASK_FINDING ,LABEL_CAU_INSTRN1_ENG,LABEL_CAU_INSTRN2_ENG,LABEL_SPL_INSTRN1_ENG,LABEL_SPL_INSTRN2_ENG,LABEL_PAT_INSTRN1_ENG,LABEL_CAU_INSTRN1_LOC,LABEL_CAU_INSTRN2_LOC,LABEL_SPL_INSTRN1_LOC,LABEL_SPL_INSTRN2_LOC,LABEL_PAT_INSTRN1_LOC,DELIVERY_REMARKS_CODE,DELIVERY_TASK_FINDING,ALLOCATE_REMARKS_CODE,ALLOCATE_TASK_FINDING,BL_INCL_EXCL_OVERRIDE_VALUE,BL_INCL_EXCL_OVERRIDE_REASON,PRES_REMARK_CODE,ISSUE_QTY ,ISSUE_UOM_CODE,CERT_REIMB_APPL_YN,DRUG_INDICATION, ALT_DRUG_REMARKS,PRINT_SEQ_NO,APPROVAL_NO)  VALUES ( ?,?, ?, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?,?, SYSDATE,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");//DRUG_INDICATION for  ML-BRU-CRF-072[Inc:29938]//ADDED PRINT_SEQ_NO FOR RUT-CRF-0061
			//approval_no added for AAKH-CRF-0117

			pstmt_pres_remark_select	= connection.prepareStatement((String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT159"));
			pstmt_pres_remark_select_1  = connection.prepareStatement((String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT160")); 
			ArrayList result = null;
			ArrayList batchDetails = null;
			ArrayList essentialReimberse = null;
			String key, key1, cer_res_no;
			ArrayList edit_result	= null;
			ArrayList instructions_res 	=null;
			ArrayList instructions		= null;
			String    drugIndication	= "";
			String sql_query ="select DRUG_INDICATION from or_order_line_ph where order_id=? and order_line_num=?"; 
			String alt_drug_remarks="",altKey;
			HashMap hmAltDrugRemarks	=  (HashMap)tabData.get("ALTDRUGREMARKS");
			String approval_no			= "";//AAKH-CRF-0117
			HashMap approvalNo	=  (HashMap)tabData.get("approvalNo");//AAKH-CRF-0117

			for(int i=0;i<dispTMP.size();i=i+7){//code added on 27/4/2004 for All stages....
				altKey = ((String)dispTMP.get(i)).trim()+"~"+((String)dispTMP.get(i+1)).trim();
				if(hmAltDrugRemarks !=null && hmAltDrugRemarks.containsKey(altKey))
					alt_drug_remarks = (String)hmAltDrugRemarks.get(altKey);
				else
					alt_drug_remarks="";
				key	=	((String)dispTMP.get(i)).trim()+"_"+((String)dispTMP.get(i+1)).trim();
				key1 =	((String)dispTMP.get(i)).trim()+"_"+((String)dispTMP.get(i+3)).trim()+"_"+((String)dispTMP.get(i+1)).trim();
				if(fillingRemarks.containsKey(key)) {
					result	= (ArrayList)fillingRemarks.get(key);
					fillcode			= (String)result.get(1);
					fillremarks			= (String)result.get(2);
				}
				else{
					fillcode			= "";
					fillremarks			= "";
				}

				if(deliveryRemarks.containsKey(key)) {
					result	= (ArrayList)deliveryRemarks.get(key);
					delivery_code		= (String)result.get(1);
					delivery_remarks	= (String)result.get(2);
				}
				else{
					delivery_code		= "";
					delivery_remarks	= "";
				}
				if(allocateRemarks.containsKey(key)) {
					result	= (ArrayList)allocateRemarks.get(key);
					allocate_code		= (String)result.get(1);
					allocate_remarks	= (String)result.get(2);
				}
				else{
					allocate_code		= "";
					allocate_remarks	= "";
				}//ended...

				batchDetails	= (ArrayList)dispTMP.get(i+6);
				item_code				= (String)batchDetails.get(0);
				count					= 1;

				if(!prev_order_id.equals(((String)dispTMP.get(i)).trim()))
					jj	=	1;

				prev_order_id		=	((String)dispTMP.get(i)).trim();
				tmp_no			=	(jj++);
				pstmt_insert_disp_dtl.setString(count,(String)tabData.get("facility_id"));					
				pstmt_insert_disp_dtl.setString(++count,(String)seq_no.get(((String)dispTMP.get(i)).trim()));//DISP_NO
				if(!disp_level.equals("P")){				
					IR_FLAG.put("disp_no",(String)seq_no.get(((String)dispTMP.get(i)).trim()));
					IR_FLAG.put("srl_no",(tmp_no)+"");
				}
				disp_no=(String)seq_no.get(((String)dispTMP.get(i)).trim());// Added for Bru-HIMS-CRF-414 [IN:045554]
				disp_srl_no =tmp_no+""; // Added for Bru-HIMS-CRF-414 [IN:045554]
				pstmt_insert_disp_dtl.setString(++count,(tmp_no)+"");						//SRL_NO
				pstmt_insert_disp_dtl.setString(++count,((String)dispTMP.get(i)).trim());	//ORDER_ID
				pstmt_insert_disp_dtl.setString(++count,((String)dispTMP.get(i+1)).trim());	//ORDER_LINE_NO
				pstmt_insert_disp_dtl.setString(++count,((String)dispTMP.get(i+2)).trim());	//PRES_DRUG_CODE
				pstmt_insert_disp_dtl.setString(++count,(String)tabData.get("ordering_facility_id"));				//ORDERING_FACILITY_ID
				pstmt_insert_disp_dtl.setString(++count,(String)tabData.get("disp_locn_code"));				//DISP_LOCN_CODE
				pstmt_insert_disp_dtl.setString(++count,"");								//STORE_CODE

				/*if(getCustomerID(connection).equals("SRR")){
					if(getEssentialItemYN(connection,((String)dispTMP.get(i+3)).trim()).equals("N")){
						if(!tabData.containsKey("CER_RES_NO")){
							String cer_res_no = (String)GenerateCerRemNO(connection);
							tabData.put("CER_RES_NO",cer_res_no);
						}
						cer_res_yn           ="Y";
					}else{
						cer_res_yn           ="N";
					}
				}*/
				cer_res_yn           ="N";

				if(getCustomerID(connection).equals("SRR")){				 
					//if(getEssentialItemYN(connection,((String)dispTMP.get(i+3)).trim()).equals("N")){
					essentialReimberse = getEssentialItemYN(connection,((String)dispTMP.get(i+3)).trim());
					if(essentialReimberse!=null && essentialReimberse.size()>1){
						if(((String) essentialReimberse.get(0)).equals("N") && ((String) essentialReimberse.get(1)).equals("Y")){
							if(charge_dtls.containsKey((String)dispTMP.get(i)+(String)dispTMP.get(i+1)+(String)dispTMP.get(i+3))){
								if((Float.parseFloat((String)charge_dtls.get((String)dispTMP.get(i)+(String)dispTMP.get(i+1)+(String)dispTMP.get(i+3))))>0){
									if(!tabData.containsKey("CER_RES_NO")){
										cer_res_no = (String)GenerateCerRemNO(connection);
										tabData.put("CER_RES_NO",cer_res_no);
									}
									cer_res_yn           ="Y";
								}
							}
						}
					}
				}

				pstmt_insert_disp_dtl.setString(++count,((String)dispTMP.get(i+3)).trim());	//DISP_DRUG_CODE
				pstmt_insert_disp_dtl.setString(++count,item_code);								//ITEM_CODE
				pstmt_insert_disp_dtl.setString(++count,"");								//STK_UOM_CODE
				pstmt_insert_disp_dtl.setString(++count,((String)dispTMP.get(i+4)).trim());	//DISP_QTY
				pstmt_insert_disp_dtl.setString(++count,((String)dispTMP.get(i+5)).trim());	//DISP_UOM_CODE
				pstmt_insert_disp_dtl.setString(++count,"0");								//RETURNED_QTY
				pstmt_insert_disp_dtl.setString(++count,"");								//REISSUE_REASON_CODE
				pstmt_insert_disp_dtl.setString(++count,(String)tabData.get("login_by_id"));				
				pstmt_insert_disp_dtl.setString(++count,(String)tabData.get("login_at_ws_no"));				
				pstmt_insert_disp_dtl.setString(++count,(String)tabData.get("facility_id"));				
				pstmt_insert_disp_dtl.setString(++count,(String)tabData.get("login_by_id"));
				pstmt_insert_disp_dtl.setString(++count,(String)tabData.get("login_at_ws_no"));
				pstmt_insert_disp_dtl.setString(++count,(String)tabData.get("facility_id"));
				if(stock_srl.containsKey(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1))+((String)dispTMP.get(i+3)).trim().trim())){
					pstmt_insert_disp_dtl.setString(++count,(String)stock_srl.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim()));
				}
				else {
					stock_srl.put(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim(),tmp_srl_cnt+"");
					pstmt_insert_disp_dtl.setString(++count,tmp_srl_cnt+"");
				}

				/*if(!stock_srl.containsKey(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim()) ) {
					stock_srl.put(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim(),tmp_srl_cnt+"");
				}*/
				
				pstmt_insert_disp_dtl.setString(++count,fillcode);//for filling code and remarks....
				pstmt_insert_disp_dtl.setString(++count,fillremarks);// filling ended..
				
				edit_result	= new ArrayList();//for inserting cautions and special instructions.....	
				instructions_res 	= new ArrayList();
				instructions		= new ArrayList();
				drugIndication	= "";
				if(editLabel !=null && editLabel.containsKey(key1)) 			
					edit_result =(ArrayList)editLabel.get(key1);
				if(edit_result!=null && edit_result.size()!=0){
					pstmt_insert_disp_dtl.setString(++count,(String)edit_result.get(0));
					pstmt_insert_disp_dtl.setString(++count,(String)edit_result.get(1));
					pstmt_insert_disp_dtl.setString(++count,(String)edit_result.get(2));
					pstmt_insert_disp_dtl.setString(++count,(String)edit_result.get(3));
					pstmt_insert_disp_dtl.setString(++count,(String)edit_result.get(4));
					pstmt_insert_disp_dtl.setString(++count,(String)edit_result.get(5));
					pstmt_insert_disp_dtl.setString(++count,(String)edit_result.get(6));
					pstmt_insert_disp_dtl.setString(++count,(String)edit_result.get(7));
					pstmt_insert_disp_dtl.setString(++count,(String)edit_result.get(8));
					pstmt_insert_disp_dtl.setString(++count,(String)edit_result.get(9));
					//pstmt_insert_disp_dtl.setString(++count,(String)edit_result.get(10));
					//pstmt_insert_disp_dtl.setString(++count,(String)edit_result.get(11));
					drugIndication = (String)edit_result.get(11);
				} 
				else {	
					pstmt.setString(1,(((String)dispTMP.get(i+3)).trim()));
					pstmt.setString(2,(((String)dispTMP.get(i+3)).trim()));
					pstmt.setString(3,(((String)dispTMP.get(i)).trim()));
					pstmt.setString(4,(((String)dispTMP.get(i+1)).trim()));
					pstmt.setString(5,LanguageId);
					resultSet	= pstmt.executeQuery() ;
					while (resultSet.next()){
						instructions_res.add(resultSet.getString("CAUTION_LABEL_TEXT_ID_1")+"");
						instructions_res.add(resultSet.getString("SPL_INSTR_LABEL_TEXT_ID")+"");
						instructions_res.add(resultSet.getString("HOW_TO_TAKE_TEXT")+"");
						alt_drugindication = (resultSet.getString("HOW_TO_TAKE_TEXT")+"");//Added alt_drugindication display the AlternateDrugIndication in EditLabel
					}
					caution_1				= ".";  
					special_1				= ".";
					patient_int				= ".";//removed . for ARYU-SCF-0176 and reverted for GHL-ICN-0038
					loc_caution_1			= ".";
					loc_special_1			= ".";
					loc_patient_int			= ".";//removed . for ARYU-SCF-0176 and reverted for GHL-ICN-0038
					if(instructions_res.size() > 0){	
						for(int k=0;k<2;k++){					
							temp			= new ArrayList();
							lang_ids        = new ArrayList();
							if( (!( (((String)instructions_res.get(k))==null) || ( ((String)instructions_res.get(k)).equals("")  ) ))){
								resultSet		= null;
								pstmt_int.setString(1,(String)instructions_res.get(k));
								//pstmt_int.setString(2,getLanguageId());

								resultSet	= pstmt_int.executeQuery() ;
								while (resultSet.next()){							
									//temp.add((String)resultSet.getString("LABEL_TEXT_1"));	//commented for HSA-CRF-0178/04 All Stages Label [IN:052990]
									temp.add((String)resultSet.getString("LABEL_TEXT_ID"));	//added for HSA-CRF-0178/04 All Stages Label [IN:052990]
									temp.add((String)resultSet.getString("language_id"));	
									temp.add((String)resultSet.getString("LABEL_TEXT_1"));	//Moved from index 0 to 2 for HSA-CRF-0178/04 All Stages Label [IN:052990]
									lang_ids.add(resultSet.getString("language_id"));
								}
								instructions.add(temp);
							}
							else{
								instructions.add(temp);
							}              
							//tempString = (String)instructions_res.get(i);
						}
						temp = new ArrayList();
						if(lang_ids.size() == 0){	
							lang_ids.add(LanguageId);
							resultSet	= pstmt1.executeQuery() ;
							if(resultSet.next()){
								lang_ids.add((String)resultSet.getString("language_id"));
							}
						}
						
						for(int k=0;k<lang_ids.size();k++) {				  
							resultSet		= null;
							pstmt_int_1.setString(1,(((String)dispTMP.get(i+3)).trim()));
							pstmt_int_1.setString(2,(String)lang_ids.get(k));
							resultSet	= pstmt_int_1.executeQuery() ;
							
							while (resultSet.next()){							
								temp.add((String)resultSet.getString("HOW_TO_TAKE_TEXT"));
								temp.add((String)lang_ids.get(k));
							}
						}
						instructions.add(temp);
						caution	= (ArrayList)instructions.get(0);
						if(caution.size()>0){	
							for(int m=0;m<caution.size();m+=3){  //size increased from 2 to 3 HSA-CRF-0178/04 All Stages Label [IN:052990]
								if(caution.get(m+1).equals("en")){
									 caution_1		= (String)caution.get(m)==null?".":(String)caution.get(m);	
								}
								else{
									 loc_caution_1	= (String)caution.get(m+2)==null?".":(String)caution.get(m+2);	//changed from m to m+2HSA-CRF-0178/04 All Stages Label [IN:052990]
								}
							}
						}
						special			= (ArrayList)instructions.get(1);
						if(special.size()>0){
							for(int m=0;m<special.size();m+=3){  //size increased from 2 to 3 HSA-CRF-0178/04 All Stages Label [IN:052990]
								if(special.get(m+1).equals("en")){
									special_1		= (String)special.get(m)==null?".":(String)special.get(m);
								}
								else{
									loc_special_1	= (String)special.get(m+2)==null?".":(String)special.get(m+2);//changed from m to m+2HSA-CRF-0178/04 All Stages Label [IN:052990]
								}
							}
						}

						pat_int =   (ArrayList)instructions.get(2);
						if(pat_int.size()>0){						  
						   for(int m=0;m<pat_int.size();m+=2){
							  if(pat_int.get(m+1).equals("en")){
								patient_int		= (String)pat_int.get(m)==null?".":(String)pat_int.get(m); //removed . for ARYU-SCF-0176 and reverted for GHL-ICN-0038							 						                   
							  }
							  else{
								loc_patient_int	= (String)pat_int.get(m)==null?".":(String)pat_int.get(m);//removed . for ARYU-SCF-0176 and reverted for GHL-ICN-0038
							  }
						   }
						}
						//Added below code to display the AlternateDrugIndication in EditLabel Start
						 if(((String)dispTMP.get(i+2)).trim().equals(((String)dispTMP.get(i+3)).trim())){
							pstmt_ind		= connection.prepareStatement(sql_query) ;
							pstmt_ind.setString(1,((String)dispTMP.get(i)).trim());
							pstmt_ind.setString(2,((String)dispTMP.get(i+1)).trim());
							resultSet			=   pstmt_ind.executeQuery();
							while( resultSet != null && resultSet.next() ) {
								if(resultSet.getString("DRUG_INDICATION")!=null) {
									drug_indication=resultSet.getString("DRUG_INDICATION");
							   }
							}
							drugIndication = drug_indication;
						}
						else{
							drugIndication =alt_drugindication;
						}//Added above code to display the AlternateDrugIndication in EditLabel End
					}
					instructions		= new ArrayList();
					instructions_res 	= new ArrayList();

					pstmt_insert_disp_dtl.setString(++count,caution_1);
					pstmt_insert_disp_dtl.setString(++count,"");
					pstmt_insert_disp_dtl.setString(++count,special_1);
					pstmt_insert_disp_dtl.setString(++count,"");
					pstmt_insert_disp_dtl.setString(++count,patient_int);
					pstmt_insert_disp_dtl.setString(++count,loc_caution_1);
					pstmt_insert_disp_dtl.setString(++count,"");
					pstmt_insert_disp_dtl.setString(++count,loc_special_1);
					pstmt_insert_disp_dtl.setString(++count,"");
					pstmt_insert_disp_dtl.setString(++count,loc_patient_int);
				}
				pstmt_insert_disp_dtl.setString(++count,delivery_code);
				pstmt_insert_disp_dtl.setString(++count,delivery_remarks);
				pstmt_insert_disp_dtl.setString(++count,allocate_code);
				pstmt_insert_disp_dtl.setString(++count,allocate_remarks);//inserting cautions and special instructions..... ended......
				
				if(billing_interface_yn.equals("Y")){//code added for bl interface
					if(bl_reasons.containsKey(patient_id+((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim())){
						bl_det=(HashMap) bl_reasons.get(patient_id+((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim());
					}
					else{
						bl_det           = new HashMap();	
					}
					if(bl_det.size()>0){
						bl_override_rason =(String)bl_det.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE");
						bl_inc_exec	      =(String)bl_det.get("BL_EXCL_INCL_IND");
					}
				}
				else{
					bl_override_rason ="";
					bl_inc_exec	      ="";
				}

				pstmt_insert_disp_dtl.setString(++count,bl_inc_exec);
				pstmt_insert_disp_dtl.setString(++count,bl_override_rason);

				pres_remark    ="";
				if(edit_result!=null && edit_result.size()!=0){
					if(!edit_result.get(10).equals("")){
						pres_remark    =    (String)edit_result.get(10);
					}
				}
				if(pres_remark.equals("")){
					pstmt_pres_remark_select_1.setString(1,((String)dispTMP.get(i+3)).trim());
					pstmt_pres_remark_select_1.setString(2,((String)dispTMP.get(i+3)).trim());
					pstmt_pres_remark_select_1.setString(3,(String)tabData.get("LanguageId"));//Added for ICN:34205
					if (resultSet!=null && resultSet.next()){
						pres_remark = resultSet2.getString("ORDER_LINE_FIELD_VALUE");
					}
				} 
				if(pres_remark.equals("")){
					pstmt_pres_remark_select.setString(1,((String)dispTMP.get(i+3)).trim());
					resultSet1	= pstmt_pres_remark_select.executeQuery() ;
					while (resultSet1.next()){
						pres_remark = resultSet1.getString("REMARK_CODE");
					}					
					closeResultSet(resultSet1); //Common-ICN-0090
				}
				pstmt_insert_disp_dtl.setString(++count,pres_remark);	
				if(issue_uom_dtl.containsKey(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim()+"_qty")){
					pstmt_insert_disp_dtl.setString(++count,(String)issue_uom_dtl.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim()+"_qty"));
					pstmt_insert_disp_dtl.setString(++count,(String)issue_uom_dtl.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim()+"_uom"));
				}
				else{
					pstmt_insert_disp_dtl.setString(++count,"");	
					pstmt_insert_disp_dtl.setString(++count,"");	
				}
				pstmt_insert_disp_dtl.setString(++count,cer_res_yn);
				pstmt_insert_disp_dtl.setString(++count,drugIndication);
				pstmt_insert_disp_dtl.setString(++count,alt_drug_remarks);
				pstmt_insert_disp_dtl.setString(++count,tabData.get("print_seq_no_tmp").toString());//ADDED PRINT_SEQ_NO FOR RUT-CRF-0061
		//added for AAKH-CRF-0117
				if(approvalNo!=null && approvalNo.size()>0)
				approval_no = (String)approvalNo.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim());

				if(approval_no==null)
				approval_no = "";

				pstmt_insert_disp_dtl.setString( ++count, approval_no);	//added for AAKH-CRF-0117
				pstmt_insert_disp_dtl.addBatch();
				tmp_srl_cnt++;

				if(allow_edit_disp_label.equals("Y") && editableLabel!=null && editableLabel.size()>0){ //if block Added for Bru-HIMS-CRF-414 [IN:045554]
					//sKey1 =	((String)dispTMP.get(i)).trim()+"_"+((String)dispTMP.get(i+3)).trim()+"_"+((String)dispTMP.get(i+1)).trim()+"_"+editableLabelLangId;
					sKey1 =	((String)dispTMP.get(i)).trim()+"_"+((String)dispTMP.get(i+3)).trim()+"_"+((String)dispTMP.get(i+1)).trim();
					lEditLabelKeys = new ArrayList(editableLabel.keySet());
					for(int ilcount=0; ilcount<lEditLabelKeys.size(); ilcount++){
						strLblTempKey= (String)lEditLabelKeys.get(ilcount);
						strLabelLangTmp = strLblTempKey.substring(strLblTempKey.lastIndexOf("_")+1);
						if((strLblTempKey.substring(0,strLblTempKey.lastIndexOf("_"))).equals(sKey1)){
							iLblCount	=	0;
							icount=1;
							if(editableLabel.containsKey(sKey1)){
								pstmt_disp_label_select_count.setString(1,(String)tabData.get("facility_id"));
								pstmt_disp_label_select_count.setString(2, disp_no);
								pstmt_disp_label_select_count.setString(3, disp_srl_no);
								pstmt_disp_label_select_count.setString(4,strLabelLangTmp);
								rsLablCount = pstmt_disp_label_select_count.executeQuery();
								if(rsLablCount!=null && rsLablCount.next()){
									iLblCount = rsLablCount.getInt("LBLCOUNT");
								}
								closeResultSet( rsLablCount ) ;
								if(alLabelDtl!=null && alLabelDtl.size()>0){
									dispQty = alLabelDtl.get(2)==null?"":(String)alLabelDtl.get(2);
									if(dispQty.equals(""))
										dispQty = ((String)dispTMP.get(i+4)).trim();
									if(iLblCount>0){
										icount=1;
										pstmtDispLabelUpdate.setString(icount++,(String)alLabelDtl.get(1));
										pstmtDispLabelUpdate.setString(icount++, dispQty);
										//pstmtDispLabelUpdate.setString(icount++,(String)alLabelDtl.get(3));
										pstmtDispLabelUpdate.setString(icount++,(String)alLabelDtl.get(4));
										pstmtDispLabelUpdate.setString(icount++,(String)alLabelDtl.get(5));
										pstmtDispLabelUpdate.setString(icount++,(String)alLabelDtl.get(6));
										pstmtDispLabelUpdate.setString(icount++,(String)tabData.get("login_by_id"));
										pstmtDispLabelUpdate.setString(icount++,(String)tabData.get("login_at_ws_no"));
										pstmtDispLabelUpdate.setString(icount++,(String)tabData.get("facility_id"));
										pstmtDispLabelUpdate.setString(icount++,(String)tabData.get("facility_id"));
										pstmtDispLabelUpdate.setString(icount++, disp_no);
										pstmtDispLabelUpdate.setString(icount++, disp_srl_no);
										pstmtDispLabelUpdate.setString(icount++,strLabelLangTmp);
										pstmtDispLabelUpdate.addBatch();
										updateCount++;
									}
									else{
										icount=1;
										pstmtDispLabelInsert.setString(icount++,(String)tabData.get("facility_id"));
										pstmtDispLabelInsert.setString(icount++, disp_no);
										pstmtDispLabelInsert.setString(icount++, disp_srl_no);
										pstmtDispLabelInsert.setString(icount++,strLabelLangTmp);
										pstmtDispLabelInsert.setString(icount++,(String)alLabelDtl.get(0));
										pstmtDispLabelInsert.setString(icount++,(String)alLabelDtl.get(1));
										pstmtDispLabelInsert.setString(icount++, dispQty);
										pstmtDispLabelInsert.setString(icount++,((String)dispTMP.get(i+5)).trim());//(String)alLabelDtl.get(3)
										pstmtDispLabelInsert.setString(icount++,(String)alLabelDtl.get(4));
										pstmtDispLabelInsert.setString(icount++,(String)alLabelDtl.get(5));
										pstmtDispLabelInsert.setString(icount++,(String)alLabelDtl.get(6));
										pstmtDispLabelInsert.setString(icount++,(String)tabData.get("login_by_id"));
										pstmtDispLabelInsert.setString(icount++,(String)tabData.get("login_at_ws_no"));
										pstmtDispLabelInsert.setString(icount++,(String)tabData.get("facility_id"));
										pstmtDispLabelInsert.setString(icount++,(String)tabData.get("login_by_id"));
										pstmtDispLabelInsert.setString(icount++,(String)tabData.get("login_at_ws_no"));
										pstmtDispLabelInsert.setString(icount++,(String)tabData.get("facility_id"));
										pstmtDispLabelInsert.addBatch();
										insertCount++;
									}
								}
							}
						}
					}
				}
			}
			if(allow_edit_disp_label.equals("Y") && editableLabel!=null && editableLabel.size()>0){ //if block Added for Bru-HIMS-CRF-414 [IN:045554]
				if(insertCount>0){
					int[] resultInsert=pstmtDispLabelInsert.executeBatch();
					for (int k=0;k<resultInsert.length ;k++ ){
						if(resultInsert[k]<0  && resultInsert[k] != -2 ){
							pstmtDispLabelInsert.cancel();
							connection.rollback();
							throw new EJBException("Insert Dispense Label failed");
						}		
					}
				}
				if(updateCount>0){
					int[] resultUpdate=pstmtDispLabelUpdate.executeBatch();
					for (int k=0;k<resultUpdate.length ;k++ ){
						if(resultUpdate[k]<0  && resultUpdate[k] != -2 ){
							pstmtDispLabelUpdate.cancel();
							connection.rollback();
							throw new EJBException("Update Dispense Label failed");
						}		
					}
				}
			}
			int[] result3=pstmt_insert_disp_dtl.executeBatch();
			for (int i=0;i<result3.length ;i++ ){
				if(result3[i]<0  && result3[i] != -2 ){
					pstmt_insert_disp_dtl.cancel();
					connection.rollback();
					throw new EJBException("Error: Dtl table insertion failed");
				}		
			}
		}
		catch(Exception e){
			System.err.println(" tabData="+tabData);
			e.printStackTrace();
			//try{
			connection.rollback();
			throw new EJBException("Error: Dtl table insertion Failed");
			//}catch(Exception es) { es.printStackTrace();}
		}
		finally{	
			try {
				closeStatement( pstmt_insert_disp_dtl ) ;
				closeStatement(pstmt_int);
				closeStatement(pstmt);
				closeStatement(pstmt_update_ororder);
				closeResultSet(resultSet);
                closeStatement(pstmt_pres_remark_select);			
				closeResultSet(resultSet1);
				closeStatement(pstmt_pres_remark_select_1);			
				closeResultSet(resultSet2);
				closeStatement(pstmt_int_1);			
				closeStatement(pstmt1);			
				closeResultSet( rsDispDtl ) ; //Added for Bru-HIMS-CRF-414 [IN:045554]-start
				closeResultSet( rsLablCount ) ;
				closeStatement( pstmt_disp_label_select_disp_dtl ) ;
				closeStatement( pstmt_disp_label_select_count ) ;
				closeStatement( pstmtDispLabelInsert ) ;
				closeStatement( pstmtDispLabelUpdate ) ; //Added for Bru-HIMS-CRF-414 [IN:045554] -end
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
		return stock_srl;
	}
	// Insert Batch Table --- Main
	private void insertBatch(Connection connection, HashMap sqlMap, HashMap tabData,ArrayList dispAlloc, HashMap seq_no) throws Exception {
		PreparedStatement pstmt_insert_disp_drug_batch	= null;
		int count				=	1;
		int jj					=	1;
		String drug_code		= "";
		String batch_id			= "";
		String expiry_date		= "";
		String disp_qty			= "";
		String disp_qty_uom		= "";
		String trade_id			= "";
		String bin_locn_code	= "";
		String prev_order_id	= "";
		ArrayList batchDetails = null;
		try {
			pstmt_insert_disp_drug_batch	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_DRUG_BATCH_INSERT") ) ;
			for(int i=0;i<dispAlloc.size();i=i+7){
				batchDetails = (ArrayList)dispAlloc.get(i+6);
				if(!prev_order_id.equals(((String)dispAlloc.get(i)).trim()))
				jj	=	1;
				prev_order_id		=	((String)dispAlloc.get(i)).trim();

				int kk = 1;
				for (int j=0;j<batchDetails.size() ; j=j+10){ //9->10 for MMS-SCF-0040 [IN:041888]
					count=1;
					drug_code	 = (String)batchDetails.get(j);
					batch_id	 = (String)batchDetails.get(j+1);
					expiry_date	 = (String)batchDetails.get(j+2);
					disp_qty	 = (String)batchDetails.get(j+3);
					disp_qty_uom = (String)batchDetails.get(j+9); // j+4 changed to j+9 for regression Issue 
					trade_id	 = (String)batchDetails.get(j+6);
					bin_locn_code= (String)batchDetails.get(j+7);

					pstmt_insert_disp_drug_batch.setString(count,(String)tabData.get("facility_id"));
					pstmt_insert_disp_drug_batch.setString(++count,(String)seq_no.get(((String)dispAlloc.get(i)).trim()));
					pstmt_insert_disp_drug_batch.setString(++count,(jj)+"");
					pstmt_insert_disp_drug_batch.setString(++count,(kk++)+"");
					pstmt_insert_disp_drug_batch.setString(++count,(String)tabData.get("disp_locn_code"));
					pstmt_insert_disp_drug_batch.setString(++count,(String)tabData.get("store_code"));
					pstmt_insert_disp_drug_batch.setString(++count,drug_code.trim());
					pstmt_insert_disp_drug_batch.setString(++count,drug_code.trim());
					pstmt_insert_disp_drug_batch.setString(++count,batch_id.trim());
					pstmt_insert_disp_drug_batch.setString(++count,expiry_date.trim());
					pstmt_insert_disp_drug_batch.setString(++count,disp_qty.trim());
					pstmt_insert_disp_drug_batch.setString(++count,"0");
					pstmt_insert_disp_drug_batch.setString(++count,(String)tabData.get("login_by_id"));
					pstmt_insert_disp_drug_batch.setString(++count,(String)tabData.get("login_at_ws_no"));
					pstmt_insert_disp_drug_batch.setString(++count,(String)tabData.get("facility_id"));
					pstmt_insert_disp_drug_batch.setString(++count,(String)tabData.get("login_by_id"));
					pstmt_insert_disp_drug_batch.setString(++count,(String)tabData.get("login_at_ws_no"));
					pstmt_insert_disp_drug_batch.setString(++count,(String)tabData.get("facility_id"));	
					pstmt_insert_disp_drug_batch.setString(++count,bin_locn_code);	
					pstmt_insert_disp_drug_batch.setString(++count,trade_id);
					pstmt_insert_disp_drug_batch.setString(++count,disp_qty_uom);
					pstmt_insert_disp_drug_batch.addBatch();
				}
				jj++;
			}
			int[] result4=pstmt_insert_disp_drug_batch.executeBatch();
			for (int k=0;k<result4.length ;k++ ){
				if(result4[k]<0  && result4[k] != -2 ){
					pstmt_insert_disp_drug_batch.cancel();
					connection.rollback();
					throw new EJBException("Error: Insert Batch Details Failed");
				}		
			}  
		}
		catch(Exception e){
			System.err.println(" tabData="+tabData);
			e.printStackTrace();
			//try {
			connection.rollback();
			throw new EJBException("Error: Insert Batch Details Failed Failed");
			//}catch(Exception es) { es.printStackTrace();}
		}
		finally{	
			try {
				closeStatement( pstmt_insert_disp_drug_batch) ;
				pstmt_insert_disp_drug_batch=null;

			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
	}
/*=====================code for inserting consumables==============================================*/

	private void insertConsumableDeatil(Connection connection, HashMap sqlMap, HashMap tabData) throws Exception {
		PreparedStatement pstmt_insert_cons_drug_dtl	= null;
		int count					=	1;
		String drug_code		    = "";	
		try {
			String disp_stage  =(String)tabData.get("disp_stage");
			String status      ="";
			if(disp_stage.equals("A")){
				status  ="AL";
			}
			else if(disp_stage.equals("F")){
				status  ="FL";
			}
			else if(disp_stage.equals("D")||disp_stage.equals("AS")){
				status  ="DL";
			}

			pstmt_insert_cons_drug_dtl	= connection.prepareStatement( "INSERT INTO PH_DISP_CONS_DTL  (FACILITY_ID,DISP_TRN_SEQ_NO,DISP_NO,SRL_NO,ORDERING_FACILITY_ID,ORDER_ID,ORDER_LINE_NO,DISP_LOCN_CODE,STORE_CODE,ORDER_CONS_CODE,DISP_CONS_CODE,DISP_ITEM_CODE,STK_UOM_CODE,DISP_QTY,DISP_UOM_CODE,BL_INCL_EXCL_OVERRIDE_VALUE,BL_INCL_EXCL_OVERRIDE_REASON,DAILY_DISP_SRL_NO,STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)" ) ;

			ArrayList tot_cons_dtl = (ArrayList)tabData.get("CONSUMABLES_DET");
			HashMap  cons_dtl      =  new HashMap(); 
			//String trx_sequence_no =  "";
			HashMap batchDetails   =  new HashMap(); 
			String sequence_no     = getSequenceNo((String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT33"));
			for(int i=0;i<tot_cons_dtl.size();i++){
				cons_dtl =(HashMap)tot_cons_dtl.get(i);
			    if(cons_dtl.get("SELECTED_YN").equals("Y")&& !cons_dtl.get("ALLOC_QTY").equals("")){           
					count=1;
					batchDetails = (HashMap)cons_dtl.get("BATCH_DET");
					drug_code	 = (String)batchDetails.get("ITEM_CODE");
					cons_dtl.put("DISP_NO",sequence_no);
					cons_dtl.put("DISP_SRL_NO",(i+1)+"");
                    cons_dtl.put("ORDER_STATUS",status);
					pstmt_insert_cons_drug_dtl.setString(count,(String)tabData.get("facility_id"));
                    pstmt_insert_cons_drug_dtl.setString(++count,(String)tabData.get("TRX_SEQ_NO"));
					pstmt_insert_cons_drug_dtl.setString(++count,sequence_no);
					pstmt_insert_cons_drug_dtl.setString(++count,(i+1)+"");
					pstmt_insert_cons_drug_dtl.setString(++count,(String)tabData.get("facility_id"));
					pstmt_insert_cons_drug_dtl.setString(++count,(String)cons_dtl.get("ORDER_ID"));
					pstmt_insert_cons_drug_dtl.setString(++count,(String)cons_dtl.get("ORDER_LINE_NO")); 
					pstmt_insert_cons_drug_dtl.setString(++count,(String)tabData.get("disp_locn_code"));
					pstmt_insert_cons_drug_dtl.setString(++count,(String)tabData.get("store_code"));
					pstmt_insert_cons_drug_dtl.setString(++count,(String)cons_dtl.get("ORDER_CATALOG_CODE"));
					pstmt_insert_cons_drug_dtl.setString(++count,drug_code.trim());
					pstmt_insert_cons_drug_dtl.setString(++count,drug_code.trim());
					pstmt_insert_cons_drug_dtl.setString(++count,(String)cons_dtl.get("ORDER_UOM"));
					pstmt_insert_cons_drug_dtl.setString(++count,(String)cons_dtl.get("ALLOC_QTY"));
					pstmt_insert_cons_drug_dtl.setString(++count,(String)cons_dtl.get("ORDER_UOM"));
					pstmt_insert_cons_drug_dtl.setString(++count,"");
					pstmt_insert_cons_drug_dtl.setString(++count,"");
					pstmt_insert_cons_drug_dtl.setString(++count,"");
					pstmt_insert_cons_drug_dtl.setString(++count,status);
					pstmt_insert_cons_drug_dtl.setString(++count,(String)tabData.get("login_by_id"));
					pstmt_insert_cons_drug_dtl.setString(++count,(String)tabData.get("login_at_ws_no"));
					pstmt_insert_cons_drug_dtl.setString(++count,(String)tabData.get("facility_id"));				
					pstmt_insert_cons_drug_dtl.setString(++count,(String)tabData.get("login_by_id"));
					pstmt_insert_cons_drug_dtl.setString(++count,(String)tabData.get("login_at_ws_no"));
					pstmt_insert_cons_drug_dtl.setString(++count,(String)tabData.get("facility_id"));
					pstmt_insert_cons_drug_dtl.addBatch();
			   }
			}
			int[] result4=pstmt_insert_cons_drug_dtl.executeBatch();
			for (int k=0;k<result4.length ;k++ ){
				if(result4[k]<0  && result4[k] != -2 ){
					pstmt_insert_cons_drug_dtl.cancel();
					connection.rollback();
					throw new EJBException("Error: Insert Consumable Details Failed");
				}		
			}  
		}
		catch(Exception e){
			System.err.println(" tabData="+tabData);
			e.printStackTrace();
			//try {
			connection.rollback();
			throw new EJBException("Error: Insert Consumable  Details Failed");
			//}catch(Exception es) { es.printStackTrace();}
		}
		finally{	
			try {
				closeStatement( pstmt_insert_cons_drug_dtl) ;
				 pstmt_insert_cons_drug_dtl=null;
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
	}

	private void insertConsumableBatch(Connection connection, HashMap sqlMap, HashMap tabData) throws Exception {
		PreparedStatement pstmt_insert_cons_drug_batch	= null;
		int count					=	1;
		//String drug_code		    = "";	
		try {
			pstmt_insert_cons_drug_batch	= connection.prepareStatement( "INSERT INTO PH_DISP_CONS_BATCH(FACILITY_ID,DISP_NO,SRL_NO  ,SRL_NO_BATCH,DISP_LOCN_CODE,STORE_CODE,CONS_CODE,BATCH_ID,EXPIRY_DATE,TRADE_ID,DISP_QTY,DISP_QTY_UOM,BIN_LOCATION_CODE, LOOSE_STOCK_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values(?,?,?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY'),?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");
			ArrayList tot_cons_dtl = (ArrayList)tabData.get("CONSUMABLES_DET");
			HashMap  cons_dtl      =  new HashMap(); 
			HashMap batchDetails   =  new HashMap(); 
			//String trx_sequence_no =  "";
			int batch_srl_no       = 500;   
			for(int i=0;i<tot_cons_dtl.size();i++){
				cons_dtl =(HashMap)tot_cons_dtl.get(i);
				if(cons_dtl.get("SELECTED_YN").equals("Y")&& !cons_dtl.get("ALLOC_QTY").equals("")){           
					count=1;
					batchDetails = (HashMap)cons_dtl.get("BATCH_DET");
					cons_dtl.put("BATCH_SRL_NO",batch_srl_no+"");
					pstmt_insert_cons_drug_batch.setString(count,  (String)tabData.get("facility_id"));
					pstmt_insert_cons_drug_batch.setString(++count,(String)cons_dtl.get("DISP_NO"));
					pstmt_insert_cons_drug_batch.setString(++count,(String)cons_dtl.get("DISP_SRL_NO"));
					pstmt_insert_cons_drug_batch.setString(++count, batch_srl_no+"");
					pstmt_insert_cons_drug_batch.setString(++count,(String)tabData.get("disp_locn_code"));
					pstmt_insert_cons_drug_batch.setString(++count,(String)tabData.get("store_code"));
					pstmt_insert_cons_drug_batch.setString(++count,(String)batchDetails.get("ITEM_CODE"));
					pstmt_insert_cons_drug_batch.setString(++count,(String)batchDetails.get("BATCH_ID"));
					pstmt_insert_cons_drug_batch.setString(++count,(String)batchDetails.get("EXPIRY_DATE"));
					pstmt_insert_cons_drug_batch.setString(++count,(String)batchDetails.get("TRADE_ID"));
					pstmt_insert_cons_drug_batch.setString(++count,(String)cons_dtl.get("ALLOC_QTY"));
					pstmt_insert_cons_drug_batch.setString(++count,(String)cons_dtl.get("ORDER_UOM"));
					pstmt_insert_cons_drug_batch.setString(++count,(String)batchDetails.get("BIN_LOCN_CODE"));
					pstmt_insert_cons_drug_batch.setString(++count,"N");					
					pstmt_insert_cons_drug_batch.setString(++count,(String)tabData.get("login_by_id"));
					pstmt_insert_cons_drug_batch.setString(++count,(String)tabData.get("login_at_ws_no"));
					pstmt_insert_cons_drug_batch.setString(++count,(String)tabData.get("facility_id"));				
					pstmt_insert_cons_drug_batch.setString(++count,(String)tabData.get("login_by_id"));
					pstmt_insert_cons_drug_batch.setString(++count,(String)tabData.get("login_at_ws_no"));
					pstmt_insert_cons_drug_batch.setString(++count,(String)tabData.get("facility_id"));
					pstmt_insert_cons_drug_batch.addBatch();
					batch_srl_no++;
			   }
			}
			int[] result4=pstmt_insert_cons_drug_batch.executeBatch();
			for (int k=0;k<result4.length ;k++ ){
				if(result4[k]<0  && result4[k] != -2 ){
					pstmt_insert_cons_drug_batch.cancel();
					connection.rollback();
					throw new EJBException("Error: Insert Consumable Batch Failed");
				}		
			}  
		}
		catch(Exception e){
			System.err.println(" tabData="+tabData);
			e.printStackTrace();
			//try {
			connection.rollback();
			throw new EJBException("Error: Insert Consumable Batch Failed");
			//}catch(Exception es) { es.printStackTrace();}
		}
		finally{	
			try {
				closeStatement( pstmt_insert_cons_drug_batch) ;
				 pstmt_insert_cons_drug_batch=null;
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
	}

	private void updateDispQueue(Connection connection, HashMap sqlMap, HashMap tabData,ArrayList orderLineData,String stage) throws Exception {
		PreparedStatement pstmt_update_disp_queue		= null;
		PreparedStatement pstmt_update_disp_queue_summ	= null;
		PreparedStatement pstmt_update_ord_disp_queue   = null;//PMG2020-ML-MMOH-CRF-0002
		HashMap token_vals		=	(HashMap)tabData.get("token_vals");
		String[] strTokenTemp		= new String[2];//Added for HSA-CRF-0136 [IN:048412]
		String token_no			=	"",token_series_code="";//Added token_series_code for HSA-CRF-0136 [IN:048412]
		int count				=	1;
		String ord_id			= "";//PMG2020-ML-MMOH-CRF-0002
		String order_line_num	= "";//PMG2020-ML-MMOH-CRF-0002
		Set <String> setTokenSeries = new HashSet<String>();//Added for HSA-CRF-0136 [IN:048412]
		try {

			if(stage.equals("V")) {
				pstmt_update_disp_queue			= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_UPDATE2") ) ;
				//pstmt_update_disp_queue			= connection.prepareStatement("UPDATE PH_DISP_QUEUE SET TOKEN_STATUS = 'VF', VERIFY_DATE_TIME=SYSDATE,MODIFIED_DATE=SYSDATE,MODIFIED_BY_ID=?,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? WHERE FACILITY_ID=? AND DISP_LOCN_CODE=? AND QUEUE_DATE=TO_DATE(?,'DD/MM/YYYY') AND TOKEN_SERIES_CODE=? AND TOKEN_SERIAL_NO=? AND QUEUE_SHIFT='*ALL'" );
				pstmt_update_disp_queue_summ	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_UPDATE7") ) ;			
			}
			else if(stage.equals("F")) {
				pstmt_update_disp_queue			= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_UPDATE3") ) ;
				pstmt_update_disp_queue_summ	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_UPDATE8") ) ;			
			}
			else if(stage.equals("A")) {
				pstmt_update_disp_queue			= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_UPDATE4") ) ;
				pstmt_update_disp_queue_summ	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_UPDATE9") ) ;			
			}
			else if(stage.equals("D")) {
				pstmt_update_disp_queue			= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_UPDATE5") ) ;
				pstmt_update_disp_queue_summ	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_UPDATE10") ) ;			
				pstmt_update_ord_disp_queue = connection.prepareStatement("UPDATE PH_ORD_FOR_DISP_QUEUE SET  TOKEN_LINE_STATUS='DF', MODIFIED_DATE=SYSDATE WHERE FACILITY_ID=? AND  DISP_LOCN_CODE =? AND  QUEUE_DATE=TO_DATE(?,'DD/MM/YYYY') AND QUEUE_SHIFT='*ALL' AND TOKEN_SERIES_CODE=? AND TOKEN_SERIAL_NO=? AND ORDER_ID=? AND ORDER_LINE_NUM=? "); //PMG2020-ML-MMOH-CRF-0002

			}
			else if(stage.equals("AS")) {
				pstmt_update_disp_queue			= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_UPDATE6") ) ;
				pstmt_update_disp_queue_summ	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_UPDATE11") ) ;			
			}
			for(int i=0; i<orderLineData.size(); i+=6) {//Added for HSA-CRF-0136 [IN:048412] start
				if(token_vals.containsKey(((String)orderLineData.get(i+3)).trim()) && token_vals.get(((String)orderLineData.get(i+3)).trim())!=null) {
					strTokenTemp	=	((String)token_vals.get(((String)orderLineData.get(i+3)).trim())).split("_");
					token_series_code = strTokenTemp[0];
					setTokenSeries.add(token_series_code);
				}
				if(stage.equals("AS")) {
					i	=	i	+	3;
				}
			}
			if(setTokenSeries!=null && setTokenSeries.size()>0){
				for(String tokenseries:setTokenSeries){//Added for HSA-CRF-0136 [IN:048412] end
					count = 1;		//Added for [IN:049547]
					pstmt_update_disp_queue_summ.setString(count,(String)tabData.get("login_by_id"));
					pstmt_update_disp_queue_summ.setString(++count,(String)tabData.get("login_at_ws_no"));
					pstmt_update_disp_queue_summ.setString(++count,(String)tabData.get("facility_id"));
					pstmt_update_disp_queue_summ.setString(++count,(String)tabData.get("facility_id"));
					pstmt_update_disp_queue_summ.setString(++count,(String)tabData.get("disp_locn_code"));
					pstmt_update_disp_queue_summ.setString(++count,(String)tabData.get("Token_Queue_date"));
					pstmt_update_disp_queue_summ.setString(++count,tokenseries);//Changed token_series_code for HSA-CRF-0136 [IN:048412]
					pstmt_update_disp_queue_summ.addBatch();//Added for HSA-CRF-0136 [IN:048412]
				}
			}
			//pstmt_update_disp_queue_summ.executeUpdate();//Commented for HSA-CRF-0136 [IN:048412]
			int[] result	=pstmt_update_disp_queue_summ.executeBatch();//Added for HSA-CRF-0136 [IN:048412] start
			for (int i=0;i<result.length ;i++ ){
				if(result[i]<0  && result[i] != -2 ){
					pstmt_update_disp_queue_summ.cancel();
					connection.rollback();
					throw new EJBException("Error: Update Dispense Queue updation Failed");
				}		
			}//Added for HSA-CRF-0136 [IN:048412] end
			// For alloc_bms_chk condition added by charles
			HashMap alloc_bms_chk	=  (HashMap)tabData.get("alloc_bms_chk");
			for(int i=0; i<orderLineData.size(); i+=6) {
				if(((String)orderLineData.get(i)).trim().equals("N") ||( alloc_bms_chk != null && alloc_bms_chk.containsKey(((String)orderLineData.get(i+3)+(String)orderLineData.get(i+4))))){
					count	=	1;           
					pstmt_update_disp_queue.setString(count,(String)tabData.get("login_by_id"));
					pstmt_update_disp_queue.setString(++count,(String)tabData.get("login_at_ws_no"));
					pstmt_update_disp_queue.setString(++count,(String)tabData.get("facility_id"));
					pstmt_update_disp_queue.setString(++count,(String)tabData.get("facility_id"));
					pstmt_update_disp_queue.setString(++count,(String)tabData.get("disp_locn_code"));
					pstmt_update_disp_queue.setString(++count,(String)tabData.get("Token_Queue_date"));
					//pstmt_update_disp_queue.setString(++count,(String)tabData.get("token_series_code"));

					if(token_vals.containsKey(((String)orderLineData.get(i+3)).trim()) && token_vals.get(((String)orderLineData.get(i+3)).trim()) !=null) {
						strTokenTemp	=	((String)token_vals.get(((String)orderLineData.get(i+3)).trim())).split("_");//Changed for HSA-CRF-0136 [IN:048412]
						token_series_code = strTokenTemp[0];//Added for HSA-CRF-0136 [IN:048412]
						token_no	= strTokenTemp[1];//Added for HSA-CRF-0136 [IN:048412]
					}
					pstmt_update_disp_queue.setString(++count,token_series_code);//Moved here for HSA-CRF-0136 [IN:048412]
					pstmt_update_disp_queue.setString(++count,token_no);
					pstmt_update_disp_queue.addBatch();
				}

				if(stage.equals("AS")) {
					i	=	i	+	3;
				}
			}

			int[] result4	=pstmt_update_disp_queue.executeBatch();
			for (int i=0;i<result4.length ;i++ ){
				if(result4[i]<0  && result4[i] != -2 ){
				pstmt_update_disp_queue.cancel();
				connection.rollback();
				throw new EJBException("Error: Update Dispense Queue updation Failed");
				}		
			}
			//PMG2020-ML-MMOH-CRF-0002  - start
			if(stage.equals("D")){
			for(int i=0; i<orderLineData.size(); i+=6) {
			
					if(!((String)orderLineData.get(i)).equals("NN") ){ 
							count	=	1;
							ord_id			= ((String)orderLineData.get(i+3)).trim();
							order_line_num		= ((String)orderLineData.get(i+4)).trim();
							pstmt_update_ord_disp_queue.setString(count,(String)tabData.get("facility_id"));
							pstmt_update_ord_disp_queue.setString(++count,(String)tabData.get("disp_locn_code"));
							pstmt_update_ord_disp_queue.setString(++count,(String)tabData.get("Token_Queue_date"));
							pstmt_update_ord_disp_queue.setString(++count,token_series_code);
							pstmt_update_ord_disp_queue.setString(++count,token_no);
							pstmt_update_ord_disp_queue.setString(++count,ord_id);
							pstmt_update_ord_disp_queue.setString(++count,order_line_num);
							pstmt_update_ord_disp_queue.addBatch();
					}
				}

			

			int[] result5	=pstmt_update_ord_disp_queue.executeBatch();
			for (int i=0;i<result5.length ;i++ ){
				if(result5[i]<0  && result5[i] != -2 ){
				pstmt_update_ord_disp_queue.cancel();
				connection.rollback();
				
				}		
			}
			}
		//PMG2020-ML-MMOH-CRF-0002
		}
		catch(Exception e){
			System.err.println(" tabData="+tabData);
			e.printStackTrace();
			try {
				connection.rollback();
				throw new EJBException("Error: Update Dispense Queue updation Failed");
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
		finally{	
			try {
				closeStatement( pstmt_update_disp_queue ) ;
				closeStatement( pstmt_update_disp_queue_summ ) ;
				closeStatement( pstmt_update_ord_disp_queue);
				pstmt_update_disp_queue		=null;
				pstmt_update_disp_queue_summ=null;
				pstmt_update_ord_disp_queue = null;
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
	}

	public String getUpdateString(ArrayList arr_list){
		String update_string="OS";
		if(arr_list.contains("OS")){
			update_string="OS";
		}
		else if(arr_list.contains("RG")){
			update_string="RG";
		}
		else if(arr_list.contains("HD")){
			update_string="HD";
		}
		else if(arr_list.contains("VF")){
			update_string="VF";
		}
		else if(arr_list.contains("AL")){
			update_string="AL";
		}
		else if(arr_list.contains("IP")){
			update_string="IP";
		}
		else if(arr_list.contains("DP")){
			update_string="DP";
		}
		else if(arr_list.contains("DF")){
			update_string="DF";
		}
		return update_string;
	}

	private void checkBMS(Connection connection, HashMap sqlMap, ArrayList orderLineData) throws Exception {
		PreparedStatement pstmt_select	=	null;
		ResultSet resultSet				=	null;
		double balance					=	0;
		ArrayList  ord_det				=	new ArrayList();

		try{
			pstmt_select	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT88") ) ;
			for(int i=0;i<orderLineData.size();i=i+6){	//Modified for RUT-CRF-0088 [IN036978] 7->6
				// if(!((String)orderLineData.get(i)).equals("NN")&& ((String)orderLineData.get(i+5)).equals("N") && ((String)orderLineData.get(i+6)).equals("N")) { //&& ((String)orderLineData.get(i+6)).equals("N") added for  [IN:036305]
				 if(!((String)orderLineData.get(i)).equals("NN")&& ((String)orderLineData.get(i+5)).equals("N")) { //&& ((String)orderLineData.get(i+6)).equals("N") added for  [IN:036305]  Commented for RUT-CRF-0088 [IN036978]
					resultSet=null;
					pstmt_select.setString(1,((String)orderLineData.get(i+3)).trim());
					pstmt_select.setString(2,((String)orderLineData.get(i+4)).trim());
					resultSet	=	pstmt_select.executeQuery();
					
					if(resultSet.next()) {
						balance	=	Double.parseDouble(resultSet.getString("BALANCE")==null?"0":resultSet.getString("BALANCE"));
						if(balance>0){
							
							ord_det.add(((String)orderLineData.get(i+3)).trim());
							ord_det.add(((String)orderLineData.get(i+4)).trim());
							IR_FLAG.put("IR_FLAG_VALUE","TRUE");
							IR_FLAG.put("order_id",((String)orderLineData.get(i+3)).trim());
							IR_FLAG.put("order_line_no",((String)orderLineData.get(i+4)).trim());
						}
					}
				}
			}
			if(ord_det.size()>0){				
				IR_FLAG.put("ORDER_DETAILS",ord_det);
			}
		}
		catch(Exception e ) {
			e.printStackTrace();
			throw new EJBException("Error: BMS Validation failed");
		}
		finally{	
			try {
				closeStatement( pstmt_select ) ;
				closeResultSet( resultSet );
				pstmt_select=null;
				resultSet=null;
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
	}

// PH_PATIENT_DRUG_PROFILE & OR_ORDER_LINE_PH - DISPENSED DETAIL UPDATE
	private void updateDispensedDetail(Connection connection, HashMap sqlMap, HashMap tabData, ArrayList dispTMP,String curr_stage) throws Exception {
		PreparedStatement pstmt_update		=	null;
		PreparedStatement pstmt_update_2	=	null;
		PreparedStatement pstmt_select		=	null;
		PreparedStatement pstmt_select_1	=   null;
		PreparedStatement pstmt_select_2	=   null;
		ResultSet	rset					=	null;

		String drug_desc					=	"";
		String pack_size					=	"";
		String pres_qty						=	"";
		String order_id						=	"";
		String order_line_num				=	"";
		String bms_qty						=	"";
		String freq_nature					=	"";
		String dosage_type					=	"";

		long disp_qty						=   0;
		String LanguageId					=(String)tabData.get("LanguageId");

		ArrayList order_det					=	new ArrayList();
		StringBuffer disp_drugs				=	new StringBuffer();
		HashMap order_quanties				= (HashMap)tabData.get("order_quanties");
		ArrayList orderLineData			= (ArrayList)tabData.get("orderLineData");//Added for ML-BRU-SCF-1800
		int order_line_date_size = 0;//added for ML-BRU-SCF-1809
	   try {
			pstmt_update	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_UPDATE12") ) ;
			pstmt_update_2	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_UPDATE13") ) ;
			pstmt_select	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT45"));
			pstmt_select_1	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT137"));	

			pstmt_select_2=connection.prepareStatement( "select FREQ_NATURE,dosage_type  from or_order_line a ,or_order_line_ph b ,am_frequency c 	where a.order_id=? and a.ORDER_LINE_NUM =? and a.order_id=b.order_id and a.ORDER_LINE_NUM =b.ORDER_LINE_NUM 	and a.freq_code =c.freq_code ");
			System.out.println("orderLineData"+orderLineData+"orderLineData.size()"+orderLineData.size());//added for ML-BRU-SCF-1800
			System.out.println("dispTMP"+dispTMP+"dispTMP.size()"+dispTMP.size());//added for ML-BRU-SCF-1800
			if(curr_stage.equals("AS")){//Adding start for ML-BRU-SCF-1809
				order_line_date_size=9;
			}else{
				order_line_date_size=6;
			}//addign end-SCF-1809
			
			for(int k=0;k<orderLineData.size();k=k+order_line_date_size){//Added for ML-BRU-SCF-1800 //Replace 6t with order_line_date_size for ML-BRU-SCF-1809
				 if(!((String)orderLineData.get(k)).equals("NN")  || ( ( ((String)orderLineData.get(k+5)).trim()).equals("Y"))) {//Added for ML-BRU-SCF-1800
			      for(int i=0;i<dispTMP.size();i=i+7){
			    	if((((String)orderLineData.get(k+3)).equals((String)dispTMP.get(i))) && (((String)orderLineData.get(k+4)).equals((String)dispTMP.get(i+1))))  {//added for ML-BRU-SCF-1800
					pstmt_select.setString(1,(String)dispTMP.get(i+3));
					pstmt_select.setString(2,LanguageId);
					pstmt_select.setString(3,LanguageId);
					pstmt_select.setString(4,LanguageId);
					pstmt_select.setString(5,LanguageId);
					pstmt_select.setString(6,LanguageId);

					rset	=	pstmt_select.executeQuery();
					if(rset.next()) {
						drug_desc	=	rset.getString("DRUG_DESC");
						pack_size	=	rset.getString("CONTENT_IN_PRES_BASE_UOM");
					}
				closeResultSet( rset );
				if(pack_size==null) pack_size	=	"";
					
				if(pack_size.equals("") ||  pack_size.equals("0")) {
					pack_size		=	"1";
				}

				if(order_det.contains((String)dispTMP.get(i)+(String)dispTMP.get(i+1))) {
					disp_drugs.append(","+drug_desc);
				}
				else {
					disp_drugs	=	new StringBuffer();
					disp_drugs.append(drug_desc);
					order_det.add(((String)dispTMP.get(i)+(String)dispTMP.get(i+1)));
				}

				pstmt_select_2.setString(1,(String)dispTMP.get(i));
				pstmt_select_2.setString(2,(String)dispTMP.get(i+1));
					
				rset	=	pstmt_select_2.executeQuery();
				if(rset.next()) {
					freq_nature	=	rset.getString("FREQ_NATURE");
					dosage_type	=	rset.getString("dosage_type")==null?"A":rset.getString("dosage_type");
				}  
				closeResultSet( rset );

	//==================drug profile updation starts=================
				if(freq_nature.equals("P")||dosage_type.equals("A")){
					pstmt_update.setString(1,(Double.parseDouble((String)dispTMP.get(i+4)) )+"" );	// dispensed qty
				}
				else{
					pstmt_update.setString(1,(Double.parseDouble((String)dispTMP.get(i+4)) * Float.parseFloat(pack_size))+"" );	// dispensed qty
				}
				pstmt_update.setString(2,disp_drugs.toString());	// dispensed drugs
				pstmt_update.setString(3,(String)tabData.get("login_by_id"));		// modified id
				pstmt_update.setString(4,(String)tabData.get("login_at_ws_no"));	// modified work station
				pstmt_update.setString(5,(String)tabData.get("facility_id"));		// modified facility
				pstmt_update.setString(6,(String)dispTMP.get(i));
				pstmt_update.setString(7,(String)dispTMP.get(i+1));
				pstmt_update.addBatch();

	//==================ends here ===================================
	//===========ORDER LINE PH UPDATE==================================
				
				if(!curr_stage.equals("D")){
					order_id						=	(String)dispTMP.get(i);
					order_line_num					=   (String)dispTMP.get(i+1);
					pres_qty = order_quanties.get(order_id+order_line_num)+"";

					pstmt_select_1.setString(1,(String)dispTMP.get(i));
					pstmt_select_1.setString(2,(String)dispTMP.get(i+1));
					rset=pstmt_select_1.executeQuery();
					if(rset.next()) {
						bms_qty	=	rset.getString("bms_qty");
				}

				closeResultSet( rset );
				disp_qty		=	Long.parseLong(pres_qty)-Long.parseLong(bms_qty);

					pstmt_update_2.setString(1,(String)tabData.get("source_type"));	// disp locn type
					pstmt_update_2.setString(2,(String)tabData.get("disp_locn_code"));	// dispense location
					pstmt_update_2.setString(3,(String)tabData.get("disp_locn_code"));	// store code
					pstmt_update_2.setLong(4,disp_qty);	// dispensed qty
					pstmt_update_2.setString(5,bms_qty);	// BMS qty
					pstmt_update_2.setString(6,bms_qty);	// BMS Strength
					pstmt_update_2.setString(7,(String)tabData.get("login_by_id"));		// modified id
					pstmt_update_2.setString(8,(String)tabData.get("login_at_ws_no"));	// modified work station
					pstmt_update_2.setString(9,(String)tabData.get("facility_id"));		// modified facility			
					pstmt_update_2.setString(10,(String)dispTMP.get(i));
					pstmt_update_2.setString(11,(String)dispTMP.get(i+1));
					pstmt_update_2.addBatch();
				}
			      }
			}
		 }//added for ML-BRU-SCF-1800
	}//added for ML-BRU-SCF-1800
	//================================ends here==========================
			int[] result3	=pstmt_update.executeBatch();
			for (int i=0;i<result3.length ;i++ ){
				if(result3[i]<0  && result3[i] != -2 ){
					pstmt_update.cancel();
					connection.rollback();
					throw new EJBException("Error: Update PATIENT DRUG PROFILE UPDATE FAILED");
				}		
			}
			if(!curr_stage.equals("D")){
				int[] result4	=pstmt_update_2.executeBatch();
				for (int i=0;i<result4.length ;i++ ){
					if(result4[i]<0  && result4[i] != -2 ){
						pstmt_update_2.cancel();
						connection.rollback();

						throw new EJBException("Error: Update ORDER LINE PH UPDATE FAILED");
					}		
				}
			}
		}
		catch(Exception e){
			System.err.println(" tabData="+tabData);
			e.printStackTrace();
			connection.rollback();
			throw new EJBException("Error: UPDATE DISPENSE DETAIL FAILED");
		}
		finally{	
			try {
				closeStatement( pstmt_update ) ;
				closeStatement( pstmt_update_2 ) ;
				closeStatement( pstmt_select ) ;
				closeStatement( pstmt_select_1 );
				closeStatement(pstmt_select_2);
				closeResultSet( rset );

				pstmt_update =null;
				pstmt_update_2  =null;
				pstmt_select  =null;
				rset  =null;
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
	}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/


	public HashMap insertRefDetails(HashMap tabData,HashMap sqlMap ) {
		String ref_facility_id			    =	"";
		String ref_location				    =	"";
		String ref_remarks				    =	"";
		String order_id					    =	"";
		String order_id1				    =	"";
		String order_line_num				=	"";
		String modified_facility_id			=	"";    
		String modified_by_id			    =   "";    
		String modified_at_ws_no		    =	"";
		ResultSet 	resultSet				=	null;
		PreparedStatement pstmt_update_1	=	null;
		PreparedStatement pstmt_update_2	=	null;
		PreparedStatement pstmt_select_1	=	null;
		PreparedStatement pstmt_update_3	=	null;
		int count = 0;

		ArrayList referralYnStatus = new ArrayList();
		HashMap	  refYnOrder	= null;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		
		Connection connection	= null ;
		prop					= (Properties)tabData.get( "properties" );	
		ref_facility_id			= (String)tabData.get( "ref_facility_id");
		ref_location			= (String)tabData.get( "ref_location");
		ref_remarks				= (String)tabData.get( "ref_remarks");
		order_id1				= (String)tabData.get( "order_id");
		referralYnStatus		= (ArrayList)tabData.get("refyn_status");
		modified_facility_id	= (String)tabData.get( "facility_id");    
		modified_by_id			= (String)tabData.get( "login_by_id");    
		modified_at_ws_no		= (String)tabData.get( "login_at_ws_no");    
		try{
			connection = getConnection( prop ) ;
			pstmt_update_1	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_REFERRAL_ORDER_UPDATE") );
			pstmt_update_2	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_REFERRAL_ORDER_LINE_UPDATE1") );
			pstmt_select_1	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_OVERRIDE_BMS_SELECT2") );
			pstmt_update_3	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_OVERRIDE_BMS_UPDATE2") );
			pstmt_update_1.setString(1,ref_facility_id); 
			pstmt_update_1.setString(2,ref_location);
			pstmt_update_1.setString(3,ref_remarks);
			pstmt_update_1.setString(4,order_id1);

			int result=pstmt_update_1.executeUpdate();
			if(result > 0){
				if(referralYnStatus.size() != 0){
					for(int i=0;i<referralYnStatus.size();i++){
						refYnOrder	  =	new HashMap();         
						refYnOrder	  =	(HashMap)referralYnStatus.get(i);
						try{
							count		   =	0;
							order_id	   =	(String)refYnOrder.get("order_id");
							order_line_num =(String)refYnOrder.get("order_line_num");
							
							pstmt_update_2.setString(1,order_id);
							pstmt_update_2.setString(2,order_line_num);
							pstmt_update_2.executeUpdate();
							
							pstmt_select_1.setString(1,order_id);
							resultSet=pstmt_select_1.executeQuery();
							while (resultSet.next()){
								count=resultSet.getInt(1);
							}

							if(count == 0)
							{
								pstmt_update_3.setString(1,modified_by_id); 
								pstmt_update_3.setString(2,modified_at_ws_no);
								pstmt_update_3.setString(3,modified_facility_id);
								pstmt_update_3.setString(4,order_id);
								pstmt_update_3.executeUpdate();
							 }
						}catch(Exception e){
							e.printStackTrace();
							connection.rollback();
							map.put( "result", new Boolean( false) ) ;
							map.put("msgid",e.toString());
							throw new EJBException("Error: Error in insertRefDetails.");
						}
					}
				}
			}
			connection.commit();
			map.put( "result", new Boolean( true) ) ;
			map.put("msgid","RECORD_MODIFIED");
		}catch(Exception e){
			e.printStackTrace();		
			map.put( "result", new Boolean( false) ) ;
			map.put("msgid",e.toString());
			throw new EJBException("Error: Error while verification.");
		}finally{
			try{
				connection.rollback();
				closeResultSet(resultSet);
				closeStatement(pstmt_update_1);
				closeStatement(pstmt_update_2);
				closeStatement(pstmt_select_1);
				closeStatement(pstmt_update_3);
				resultSet=null;
				pstmt_update_1=null;
				pstmt_update_2=null;
				pstmt_select_1=null;
				pstmt_update_3=null;

				closeConnection( connection,prop );
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return map;
	}

/*public void updateStatus( Connection connection, HashMap sqlMap,ArrayList orderLineData, HashMap tabData)  throws Exception {
	HashMap orderUpdate							=	new HashMap();
	String result_status						=	"";	
	String result_line_status					=   "";	
	PreparedStatement pstmt_update_order_line	= null;
	String update_string1="";
	try {
		pstmt_update_order_line = connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_ORDER_LINE_UPDATE") ) ;
		ArrayList arr_list_values = null;

		//RESULT_LINE_STATUS		
		for(int i=0;i<orderLineData.size();i=i+6){
				
				if(!orderUpdate.containsKey((String)orderLineData.get(i+3))){
					arr_list_values = new ArrayList();
				}			
			   if(((String)tabData.get("disp_stage")).equals("AS")) {	
				       if(((String)orderLineData.get(i+8)).trim().equals("Y")) {			
						    
							 update_string1="CD";
					  } else {						   
							update_string1="OS";
					  }
				    }else{
				       if(((String)orderLineData.get(i+5)).trim().equals("Y")) {			   
							update_string1="CD";
					    } else {						  
							update_string1="OS";
					    }

				  }	
				arr_list_values.add(update_string1);
				pstmt_update_order_line.setString(1,update_string1);												//ORDER_LINE_STATUS   	
				pstmt_update_order_line.setString(2,"");												//HOLD_PRACT_ID           
				pstmt_update_order_line.setString(3,"");												//HOLD_DATE_TIME          
				pstmt_update_order_line.setString(4,"");												//LAST_ACTION_TYPE        
				pstmt_update_order_line.setString(5,"");

				pstmt_update_order_line.setString(6,(String)tabData.get("login_by_id"));		// modified id
				pstmt_update_order_line.setString(7,(String)tabData.get("facility_id"));		// modified facility
				pstmt_update_order_line.setString(8,(String)tabData.get("login_at_ws_no"));		// modified work station
				pstmt_update_order_line.setString(9,result_line_status.trim());
				pstmt_update_order_line.setString(10,((String)orderLineData.get(i+3)).trim());	//ORDER_ID
				pstmt_update_order_line.setString(11,((String)orderLineData.get(i+4)).trim());	//ORDER_LINE_NUM

				pstmt_update_order_line.addBatch();

				if(((String)tabData.get("disp_stage")).equals("AS")) {
					i	=	i+3;
					orderUpdate.put((String)orderLineData.get(i),arr_list_values);
				}else{
					orderUpdate.put((String)orderLineData.get(i+3),arr_list_values);
				}
			}	
			int result1[]=pstmt_update_order_line.executeBatch();	
			for (int i=0;i<result1.length ;i++ ){
				if(result1[i]<0  && result1[i] != -2 ){
					pstmt_update_order_line.cancel();
					connection.rollback();
					throw new EJBException("Order Line Update Failed");
				}		
			}
	}catch(Exception e){
		e.printStackTrace();
		throw new EJBException("Error: OR_ORDER_LINE UPDATION");
	}finally{	
			try {
			closeStatement( pstmt_update_order_line ) ;
			
			}
			catch(Exception es) { es.printStackTrace();}
	}
	

	
//return orderUpdate;
}*/
// Or order update
	private void updateOrOrderNew(Connection connection, HashMap sqlMap, HashMap tabData,ArrayList orderLineData) throws Exception {
		PreparedStatement pstmt_update_order		= null;
		PreparedStatement pstmt_select				= null;
		ResultSet	rset							= null;
		ArrayList line_status		=	new ArrayList();	
		HashMap order_status		=	new HashMap();
		String least_status			=	"";
		String order_id				=	"";
		String status				=	"";
		//int ord_update				=	0;
		//boolean flag;
		try {
			pstmt_update_order  = connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_ORDER_UPDATE") ) ;
			pstmt_select		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT106") ) ; 

			for(int i=0;i<orderLineData.size();i=i+6){	//Modified for RUT-CRF-0088 [IN036978] 7->6
				
				line_status		=	new ArrayList();
				pstmt_select.setString(1,((String)orderLineData.get(i+3)));
				rset	=	pstmt_select.executeQuery();
				while(rset!=null && rset.next()) {
					line_status.add(rset.getString("ORDER_LINE_STATUS"));
				}
				closeResultSet( rset );//common-icn-0029
				least_status	= getUpdateString(line_status);
				order_status.put(((String)orderLineData.get(i+3)),least_status);
			}

			Set set= order_status.keySet();
			Iterator iterator = set.iterator();

			while (iterator.hasNext()){
				order_id	= (String)iterator.next();
				status		= (String)order_status.get(order_id);
				pstmt_update_order.setString(1,status);
				pstmt_update_order.setString(2,(String)tabData.get("login_by_id"));		// modified id
				pstmt_update_order.setString(3,(String)tabData.get("facility_id"));		// modified facility
				pstmt_update_order.setString(4,(String)tabData.get("login_at_ws_no"));	// modified work station		  			
				pstmt_update_order.setString(5,order_id);
				pstmt_update_order.executeUpdate();
			}
		}
		catch(Exception e){
			System.err.println(" tabData="+tabData);
			e.printStackTrace();
			//if(flag)
			   //throw new EJBException("ORDER_PROC_BY_OTHER_USER");   
			//else
			throw new EJBException("Error: OR_ORDER UPDATE FAILED");
		}
		finally{	
			try{
				closeResultSet( rset );
				closeStatement( pstmt_update_order ) ;
				closeStatement( pstmt_select ) ;
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
	}

//added for consumable deils updation
	private void UpdateConsumableDetails(Connection connection, ArrayList trx_ids) throws Exception {
		PreparedStatement pstmt_update		= null;	
		try {
			pstmt_update  = connection.prepareStatement( "update ph_disp_cons_dtl set STATUS ='DL' where DISP_TRN_SEQ_NO =?") ;		
		
			for (int i=0;i<trx_ids.size();i++){
				pstmt_update.setString(1,(String)trx_ids.get(i));
				pstmt_update.executeUpdate();
			}
		}
		catch(Exception e){
			e.printStackTrace();
			throw new EJBException("Error: UpdateConsumableDetails FAILED");
		}
		finally{	
			try {
				closeStatement( pstmt_update ) ;			
				pstmt_update =null;
			}
			catch(Exception es) { es.printStackTrace();}
		}
	}

	private HashMap getDocValuesForFillDelivery(Connection connection, HashMap sqlMap,String strPatId,ArrayList dispTMP,ArrayList alOrdTmp, HashMap hmOrderLineNumbers, HashMap tabData) throws Exception // new parameter , HashMap hmOrderLineNumbers added for [IN:035186] & [IN:035236]
	{
		HashMap st_doc_vals								=	new HashMap();
		PreparedStatement pstmt_disp_hdr_tmp_docno		=	null;
		PreparedStatement pstmt_select_disp_tmp			=	null;
		PreparedStatement pstEncId						=	null;
		ResultSet resultSet								=	null;
		ResultSet rsEncId								=	null;	
		HashMap	prev_doc_no								=	new HashMap();
		HashMap prev_doc_type							=	new HashMap();
		HashMap srl_no									=	new HashMap();	
		String strEncId									=	"";
		String tmp_srl_no								=	"", order_line="";
		ArrayList alOrderLineNos = null; //  added for [IN:035186] & [IN:035236]

		try {
			pstmt_disp_hdr_tmp_docno	=	connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT58") ) ;
			pstmt_select_disp_tmp		=	connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT67") );
			pstEncId					=	connection.prepareStatement( (String)sqlMap.get("SQL_DISP_MEDN_SEL_ENC_ID"));
			
				//previous doc no and doc type
				for(int nCtr = 0; nCtr < alOrdTmp.size(); nCtr++){
					if((String) alOrdTmp.get(nCtr) != "null" || (String) alOrdTmp.get(nCtr) != null){
						// Getting the Encounter Id
						pstEncId.setString(1,(String) alOrdTmp.get(nCtr));
						pstEncId.setString(2,strPatId);

						rsEncId = pstEncId.executeQuery();

						if( rsEncId.next() ){
							strEncId = rsEncId.getString("ENCOUNTER_ID");
						}
						else{
							strEncId = "";
						}

						closeResultSet(rsEncId);

						tabData.put("encounter_id",strEncId);
						/*pstmt_disp_hdr_tmp_docno.setString(1,((String)alOrdTmp.get(nCtr)).trim());
						resultSet	= pstmt_disp_hdr_tmp_docno.executeQuery() ;*/ //commented for skr-scf-1305
						
						alOrderLineNos = (ArrayList)hmOrderLineNumbers.get(((String)alOrdTmp.get(nCtr)).trim()); //  added for [IN:035186] & [IN:035236]
						for(int p=0;p<alOrderLineNos.size();p++){ //  added for [IN:035186] & [IN:035236]
							//added for SKR-SCF-1305
							pstmt_disp_hdr_tmp_docno.setString(1,((String)alOrdTmp.get(nCtr)).trim());
							resultSet	= pstmt_disp_hdr_tmp_docno.executeQuery() ;
							
							order_line			 = (String)alOrderLineNos.get(p);//  added for [IN:035186] & [IN:035236]
							if (resultSet.next() ){
								prev_doc_no.put(((String)alOrdTmp.get(nCtr)).trim()+order_line,resultSet.getString("DOC_NO")); // +order_line -added for [IN:035186] & [IN:035236]
								prev_doc_type.put(((String)alOrdTmp.get(nCtr)).trim()+order_line,resultSet.getString("DOC_TYPE")); // +order_line - added for [IN:035186] & [IN:035236]
							}
						}
						closeResultSet(resultSet);
						// previous srl no
					    // SRR20056-SCF-7658.1 (Rawther) - if condition added
						if(dispTMP == null){
							throw new Exception("APP-PH0902 Record Already In Use - It is used by Other User.Please Try again...");
						}                       
	                    else{
							for(int i=0;i<dispTMP.size();i+=7){
								pstmt_select_disp_tmp.setString(1,((String)dispTMP.get(i)).trim());
								//pstmt_select_disp_tmp.setString(2,((String)dispTMP.get(i+3)).trim());
								pstmt_select_disp_tmp.setString(2,((String)dispTMP.get(i+1)).trim());
		
								resultSet	=	pstmt_select_disp_tmp.executeQuery();
		
								if(resultSet!=null && resultSet.next()){
									if(resultSet.getString("DOC_SRL_NO")!=null && !(resultSet.getString("DOC_SRL_NO").equals(""))){
										tmp_srl_no	=	resultSet.getString("DOC_SRL_NO");
										srl_no.put(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim(),tmp_srl_no);
										st_doc_vals.put("doc_no",prev_doc_no);
										st_doc_vals.put("doc_type",prev_doc_type);
										st_doc_vals.put("srl_no",srl_no);
									}
								}
								closeResultSet(resultSet);
							}
						}
					}
				}
			}
			catch(Exception e){
				System.err.println("tabData="+tabData);
				e.printStackTrace();
				if(e.getMessage()!= null && !e.getMessage().equals(""))
					throw new EJBException(e.getMessage());			
				else
					throw new EJBException(e);			
		}
		finally{	
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt_disp_hdr_tmp_docno ) ;
				closeStatement( pstmt_select_disp_tmp ) ;
				closeStatement( pstEncId ) ;
				resultSet =null;
				pstmt_disp_hdr_tmp_docno =null;
				pstmt_select_disp_tmp =null;
				pstEncId=null;

			}
			catch(Exception es){ 
				es.printStackTrace();
			}
		}

		return st_doc_vals;
	}
	/*public ArrayList prepareDispTMPDeatils(Connection connection,HashMap sqlMap,HashMap tabData){
	    PreparedStatement pstmt_select  =	null;
	    ResultSet resultSet				=	null;	
		ArrayList unique_key			=	new ArrayList();
		ArrayList dispTMP				=	(ArrayList)tabData.get("dispTMP");
		HashMap   new_stock_srl			=   new  HashMap();
		String order_id					=	"";
		String order_line_no			=	"";
		String pres_drug_code			=	"";
		String disp_drug_code			=	"";
		String disp_qty					=	"";
		String disp_uom_code			=	"";
		String item_code				=	"";
		String batch_id					=	"";
		String trade_id					=	"";
		String expiry_date				=	"";
		String bin_location_code		=	"";
		String eff_date					=	"";
		String item_cost				=	"";
		String store_code				=	"";
		String doc_srl_no				=	"";
		String batch_qty				=   "";
		ArrayList batch_details			=	new ArrayList();
		ArrayList new_dispTMP			=   new ArrayList();
		ArrayList details				=	new ArrayList();


        
       try{
		  
			pstmt_select	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT151") ) ;
			for(int i=0;i<dispTMP.size();i+=7){
				if(!unique_key.contains(((String)dispTMP.get(i)).trim())) {
						unique_key.add(((String)dispTMP.get(i)).trim());
						order_id				=	"";
						order_line_no			=	"";
						pres_drug_code			=	"";
						disp_drug_code			=	"";
						disp_qty				=	"";
						disp_uom_code			=	"";
						item_code				=	"";
						batch_id				=	"";
						trade_id				=	"";
						expiry_date				=	"";
						bin_location_code		=	"";
						eff_date				=	"";
						item_cost				=	"";
						store_code				=	"";
						doc_srl_no				=	"";
						batch_qty				=   "";

						pstmt_select.setString(1,((String)dispTMP.get(i)).trim());
                        resultSet	=	pstmt_select.executeQuery();
						//batch_details =new ArrayList();
						while(resultSet!=null && resultSet.next()) {
							order_id				=	resultSet.getString("order_id");
							order_line_no			=	resultSet.getString("order_line_no");
							pres_drug_code			=	resultSet.getString("pres_drug_code");
							disp_drug_code			=	resultSet.getString("disp_drug_code");
							disp_qty				=	resultSet.getString("disp_qty");
							disp_uom_code			=	resultSet.getString("disp_uom_code");
							item_code				=	resultSet.getString("item_code");
							batch_id				=	resultSet.getString("batch_id");
							expiry_date				=	resultSet.getString("expiry_date");
							trade_id				=	resultSet.getString("trade_id");
							bin_location_code		=	resultSet.getString("bin_location_code");
							store_code				=	resultSet.getString("store_code");
							doc_srl_no				=	resultSet.getString("doc_srl_no");
							batch_qty				=   resultSet.getString("batch_qty");

							eff_date				=   getEndDateTime(connection,order_id,order_line_no, sqlMap ) ;
							item_cost				=	getItemCost(connection,item_code,store_code, disp_qty,eff_date);
				//code for creating batch details		
                             if((new_stock_srl.containsKey(order_id+order_line_no+disp_drug_code))){
									batch_details.add(item_code);
									batch_details.add(batch_id);
									batch_details.add(expiry_date);
									batch_details.add(batch_qty);
									batch_details.add(disp_uom_code);
									batch_details.add("");
									batch_details.add(trade_id);
									batch_details.add(bin_location_code);
									batch_details.add(item_cost);
							 }else{
								    if(new_dispTMP.size()>0)	{	
										if(batch_details.size()>0){
										    new_dispTMP.add(batch_details);	
										}
										batch_details =new ArrayList();
									}
								    batch_details.add(item_code);
									batch_details.add(batch_id);
									batch_details.add(expiry_date);
									batch_details.add(batch_qty);
									batch_details.add(disp_uom_code);
									batch_details.add("");
									batch_details.add(trade_id);
									batch_details.add(bin_location_code);
									batch_details.add(item_cost);

							 }	
						 								

                           if(!(new_stock_srl.containsKey(order_id+order_line_no+disp_drug_code))){							
								    new_stock_srl.put(order_id+order_line_no+item_code,doc_srl_no);	
									new_dispTMP.add(order_id);
									new_dispTMP.add(order_line_no);
									new_dispTMP.add(pres_drug_code);
									new_dispTMP.add(disp_drug_code);
									new_dispTMP.add(disp_qty);
									new_dispTMP.add(disp_uom_code);	
						   }

						}
                         if(new_dispTMP.size()>0)	{
							 if(batch_details.size()>0){
                                new_dispTMP.add(batch_details);
							 }
							batch_details =new ArrayList();

						 }
				}

			
			}
      details.add(new_stock_srl);
	  details.add(new_dispTMP);
	   }catch(Exception e){
				e.printStackTrace() ;


	   }finally{
		   try 
			{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt_select ) ;
			}catch(Exception es){
				es.printStackTrace() ;

			}
	   }
		return details;
	}*/

	public String getEndDateTime(Connection connection,String order_id,String order_line_no,HashMap sqlMap ) throws Exception {

		PreparedStatement pstmt_select  = null;
	    ResultSet resultSet				= null;	
		String end_date_time			= null;

		try{
			pstmt_select	= connection.prepareStatement( (String)sqlMap.get("SQL_DISP_MEDN_GET_PAT_ORDER_ENDDATETIME") ) ;
			pstmt_select.setString(1,order_id);
			pstmt_select.setString(2,order_line_no);
			
            resultSet	=	pstmt_select.executeQuery();
			if(resultSet!=null && resultSet.next()) {
				end_date_time = resultSet.getString("END_DATE_TIME");
			}
		}
		catch(Exception e){
			e.printStackTrace() ;
		}
		finally{			
			closeResultSet( resultSet ) ;
			closeStatement( pstmt_select ) ;
			
		}
		return end_date_time;
	}

	public String getItemCost(Connection connection,String item_code,String store_code, String qty_reqd,String eff_date) throws Exception {
		
		ResultSet resultSet		= null;
		CallableStatement cstmt = null ;
		String item_cost		=	"";
		
		try {
			//connection	= getConnection() ;
			cstmt=connection.prepareCall("{call  st_stock_availability_status (?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString( 1, item_code );
			cstmt.setString( 2, store_code );
			cstmt.setString( 3, qty_reqd );
			cstmt.setString( 4, "N" );
			cstmt.setString( 5, eff_date);
			cstmt.setString( 6, "Y");
			cstmt.setString( 7, "");
			cstmt.registerOutParameter(8, Types.VARCHAR );
			cstmt.registerOutParameter(9, Types.VARCHAR );
			cstmt.registerOutParameter(10, Types.VARCHAR );
			cstmt.registerOutParameter(11, Types.INTEGER );
			cstmt.registerOutParameter(12, Types.VARCHAR );
			cstmt.registerOutParameter(13, Types.VARCHAR );
			cstmt.registerOutParameter(14, Types.VARCHAR );
			cstmt.registerOutParameter(15, Types.VARCHAR );
			cstmt.registerOutParameter(16, Types.VARCHAR );
			cstmt.registerOutParameter(17, Types.VARCHAR );
			cstmt.registerOutParameter(18, Types.VARCHAR );
			cstmt.registerOutParameter(19, Types.VARCHAR );
			
			cstmt.execute() ;		
			item_cost	=	(String)(cstmt.getString(10));
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;					
			closeStatement( cstmt ) ;
		}	
		return item_cost;
	}

	private String getBlInclExclDetail(Connection connection, String order_id, String order_line_no,HashMap sqlMap){
        PreparedStatement pstmt             = null ;
        ResultSet resultSet                 = null ;
		String bl_InclExclDetail            = "";
		String bl_incl_excl_override_val    = "";
		String bl_incl_excl_override_reason = "";
		try{
			pstmt					= connection.prepareStatement((String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT167")) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_no);
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				bl_incl_excl_override_val =resultSet.getString("BL_INCL_EXCL_OVERRIDE_VALUE")==null?"":resultSet.getString("BL_INCL_EXCL_OVERRIDE_VALUE");
				
				bl_incl_excl_override_reason =	resultSet.getString("BL_INCL_EXCL_OVERRIDE_REASON")==null?"":resultSet.getString("BL_INCL_EXCL_OVERRIDE_REASON");
				
				if(!bl_incl_excl_override_val.equals("")&& !bl_incl_excl_override_reason.equals("")){
				         bl_InclExclDetail = bl_incl_excl_override_val + ":"+bl_incl_excl_override_reason;	
				}
			}
			
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				//closeConnection( connection );
            }
			catch(Exception es){
				es.printStackTrace();
			}
        }
		return bl_InclExclDetail;
	}

	private String getBillingDetails(Connection connection,String login_facility_id,String Store_code,String doc_type_code,String doc_no,String login_by_id,String login_at_ws_no,String patient_id ,String encounter_id,String patient_class,String facility_id ){
		  HashMap message_bill  =   new HashMap();
		  String p_charge_amt   =   "99999";
		//  String msg            =   "";
		  String	hmResult	=	"";
		  CallableStatement callableStatement = null;
		  StringBuffer gross_charge_display_str  = new StringBuffer();
		  //dbug added for MMS-DM-SCF-0575
	  System.err.println("===========ST_BL_BILL_GEN===login_facility_id="+login_facility_id+" Store_code="+Store_code+" doc_type_code="+doc_type_code+" doc_no="+doc_no+" login_by_id="+login_by_id+" login_at_ws_no="+login_at_ws_no+" p_charge_amt="+p_charge_amt+" patient_id="+patient_id+" patient_class="+patient_class+" encounter_id="+encounter_id);
		  try{
                callableStatement	= connection.prepareCall("{ call ST_BL_BILL_GEN (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
      			callableStatement.setString(1, login_facility_id); //ordering_facility
      			callableStatement.setString(2, Store_code);
               	callableStatement.setString(3, doc_type_code+"-"+doc_no );
     			callableStatement.setString(4, login_by_id);//login_by_id
     			callableStatement.setString(5, login_at_ws_no);
     			callableStatement.setFloat(6,  Float.parseFloat(p_charge_amt));
         		callableStatement.setString(7, patient_id);
            	callableStatement.setString(8, patient_class);
        		callableStatement.setString(9, encounter_id);	
				callableStatement.registerOutParameter(10, Types.VARCHAR);
				callableStatement.registerOutParameter(11, Types.VARCHAR);
				callableStatement.registerOutParameter(12, Types.VARCHAR);
				callableStatement.registerOutParameter(13, Types.VARCHAR);
				callableStatement.registerOutParameter(14, Types.VARCHAR);
				callableStatement.registerOutParameter(15, Types.VARCHAR);
				callableStatement.setString(16, "PH");
				callableStatement.setString(17,  "Y");
				callableStatement.registerOutParameter(18, Types.VARCHAR);
				callableStatement.setString(19,  facility_id); //added for MOHE-CRF-0060 

				callableStatement.execute();

			    message_bill.put("l_slmt_reqd_yn" , (String)callableStatement.getString(10));
			    message_bill.put("l_bill_doc_type" , (String)callableStatement.getString(11));
			    message_bill.put("l_bill_doc_num" , (String)callableStatement.getString(12));
                message_bill.put("v_blng_group_id" , (String)callableStatement.getString(13));
			    message_bill.put("error_id" , (String)callableStatement.getString(14));
				message_bill.put("p_call_disc_function_yn" , (String)callableStatement.getString(18)==null?"N":(String)callableStatement.getString(18));
				String err_text =(String)callableStatement.getString(15)==null?"":(String)callableStatement.getString(15);				
			   message_bill.put("error_id_txt" , err_text);
			   System.err.println("===message_bill==8496="+message_bill);//added for MMS-DM-SCF-0575
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			callableStatement = null;	
			try{
			   closeStatement(callableStatement);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		gross_charge_display_str.append((String)message_bill.get("l_bill_doc_num")).append(",").append((String)message_bill.get("l_bill_doc_type")).append(",").append((String)message_bill.get("v_blng_group_id")).append(",").append((String)message_bill.get("p_call_disc_function_yn")).append(",").append((String)message_bill.get("l_slmt_reqd_yn")).append(",").append(doc_type_code+"-"+doc_no).append(",").append(patient_id).append(",").append(encounter_id).append(",").append(patient_class).append(",").append((String)message_bill.get("error_id_txt"));
	  System.err.println("===========ST_BL_BILL_GEN==Result=gross_charge_display_str="+gross_charge_display_str);//added for MMS-DM-SCF-0575

		hmResult = gross_charge_display_str.toString();
		return hmResult;	
	}
	/*=======code adeed for handling variable UOM*/
	private HashMap getBaseAndIssueUOMQty(Connection connection, String item_code, String store_code,String disp_qty, String disp_uom,HashMap sqlMap, String st_no_of_decimals){
	  System.err.println("@@@@ getBaseAndIssueUOMQty Starting =========>>>> item_code="+item_code+" store_code="+store_code+" disp_qty="+disp_qty+" disp_uom="+disp_uom); //added for MMS-DM-SCF-0575
        PreparedStatement pstmt             = null ;
        ResultSet resultSet                 = null ;
		PreparedStatement pstmt1             = null ; // Added for ML-BRU-SCF-1880
        ResultSet resultSet1                 = null ; // Added for ML-BRU-SCF-1880
        PreparedStatement pstmt2             = null ; //Added for GHL-ICN-0041
        ResultSet resultSet2                 = null ; //Added for GHL-ICN-0041
		String base_uom						= "";     
		String def_store_uom				= "";
		double  base_to_disp_uom_equl_value	= 0;
		double  base_to_def_uom_equl_value		= 0;
		double  store_to_disp_uom_equl_value =1;   // Added for ML-BRU-SCF-1880
		HashMap BaseAndIssueQTYDetail		= new HashMap();
		double base_qty						= 0;
		double issue_qty					= 0;
		double conv_factor                  = 0; // Added for ML-BRU-SCF-1799
		StringBuilder decimalString = new StringBuilder("#");//Added for AAKH-SCF-0113[IN:048937]
		try{
			pstmt					= connection.prepareStatement("SELECT DEF_ISSUE_UOM,GEN_UOM_CODE FROM ST_ITEM_STORE a, mm_item b WHERE STOCK_ITEM_YN = 'Y' AND a.STORE_CODE = ? AND a.ITEM_CODE = ? AND a.EFF_STATUS = 'E'and b.EFF_STATUS='E' and a.item_code =b.item_code");
			pstmt.setString(1,store_code);
			pstmt.setString(2,item_code);
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
                  base_uom		=	resultSet.getString("GEN_UOM_CODE");
				  def_store_uom	=	resultSet.getString("DEF_ISSUE_UOM");
			}
			/*pstmt1 =connection.prepareStatement("SELECT nvl(EQVL_VALUE,'1') EQVL_VALUE FROM AM_UOM_EQVL WHERE (UOM_CODE =? AND EQVL_UOM_CODE =?) OR (EQVL_UOM_CODE =? AND UOM_CODE = ? )"); // Added for ML-BRU-SCF-1880 - Start

			pstmt1.setString(1,disp_uom);
			pstmt1.setString(2,def_store_uom);
			pstmt1.setString(3,def_store_uom);
			pstmt1.setString(4,disp_uom);
			resultSet1				= pstmt1.executeQuery();
			if(resultSet1!=null && resultSet1.next()){
                 store_to_disp_uom_equl_value = resultSet1.getDouble("EQVL_VALUE");
			} // Added for ML-BRU-SCF-1880 - End   --- Commented for GHL-ICN-0041 */
			
			 pstmt2		= connection.prepareStatement( "select eqvl_value/eqvl_uom_qty EQVL_VALUE from MM_ITEM_UOM_DEFN where ITEM_CODE=? and UOM_CODE =? and EQVL_UOM_CODE=?") ; // Added for GHL-ICN-0041 - Start

			 pstmt2.setString(1,item_code);
			 pstmt2.setString(2,def_store_uom);
			 pstmt2.setString(3,disp_uom);
			 resultSet2	= pstmt2.executeQuery() ;
				
			if (resultSet2.next()){	//Changed resultSet to resultSet2 for ML-MMOH-SCF-2446				
				store_to_disp_uom_equl_value = resultSet2.getDouble("EQVL_VALUE") <= 0 ? 1:resultSet2.getDouble("EQVL_VALUE");	//Changed resultSet to resultSet2 for ML-MMOH-SCF-2446						
			}  			
			else{ 
			 pstmt1 =connection.prepareStatement("SELECT nvl(EQVL_VALUE,'1') EQVL_VALUE FROM AM_UOM_EQVL WHERE (UOM_CODE =? AND EQVL_UOM_CODE =?) OR (EQVL_UOM_CODE =? AND UOM_CODE = ? )"); // Added for ML-BRU-SCF-1880 - Start

			pstmt1.setString(1,disp_uom);
			pstmt1.setString(2,def_store_uom);
			pstmt1.setString(3,def_store_uom);
			pstmt1.setString(4,disp_uom);
			resultSet1				= pstmt1.executeQuery();
			if(resultSet1!=null && resultSet1.next()){
                 store_to_disp_uom_equl_value = resultSet1.getDouble("EQVL_VALUE");
			}
			} // Added for GHL-ICN-0041 - End
			
			//System.err.println("@@@@ getBaseAndIssueUOMQty 7692=========>>>> item_code="+item_code+" store_code="+store_code+" disp_qty="+disp_qty+" disp_uom="+disp_uom+" base_uom="+disp_uom+" def_store_uom="+def_store_uom); 
			base_to_disp_uom_equl_value	=	getEqulValue (connection, item_code, base_uom, disp_uom);
			base_to_def_uom_equl_value	=	getEqulValue (connection, item_code, base_uom, def_store_uom);
			base_qty   =	Double.parseDouble(disp_qty); //Added for MMS-SCF-0040 [IN:041888]
			issue_qty = base_qty;
			//base_qty   =	base_qty*base_to_disp_uom_equl_value;
			if(base_uom.equals(def_store_uom) && base_to_disp_uom_equl_value !=base_to_def_uom_equl_value){ //if condition alone and else block added for MMS-SCF-0040 [IN:041888] // "!disp_uom.equals(def_store_uom) && base_to_disp_uom_equl_value ==base_to_def_uom_equl_value" changed to "base_uom.equals(def_store_uom) && base_to_disp_uom_equl_value !=base_to_def_uom_equl_value" for ML-BRU-SCF-1880
				//base_qty  =	base_qty/base_to_def_uom_equl_value;
				  base_qty  = new Double(Math.ceil(Float.parseFloat(base_qty+"")*base_to_disp_uom_equl_value));
			}else if(!disp_uom.equals(def_store_uom) && base_to_disp_uom_equl_value!=base_to_def_uom_equl_value){
				 base_qty  = new Double(Math.ceil(Float.parseFloat(base_qty+"")/base_to_def_uom_equl_value));
			}else if(!disp_uom.equals(def_store_uom) && base_to_def_uom_equl_value!=store_to_disp_uom_equl_value){ // else if Added for ML-BRU-SCF-1880
				 base_qty  = new Double(Math.ceil(Float.parseFloat(base_qty+"")* store_to_disp_uom_equl_value));
			}
			if(!disp_uom.equals(base_uom)){ // Added for ML-BRU-SCF-1799 -Start
			 if(base_to_disp_uom_equl_value!=base_to_def_uom_equl_value){ 
				conv_factor = new DispMedicationAllStages().lcm( base_to_disp_uom_equl_value,base_to_def_uom_equl_value);
				if(conv_factor == 0)
					conv_factor=1;
				issue_qty  =  new Double(Math.ceil(Float.parseFloat(issue_qty+"")*base_to_disp_uom_equl_value));
				issue_qty  =  new Double(Math.ceil(((Math.ceil(issue_qty/conv_factor))*(conv_factor))/base_to_def_uom_equl_value));
				issue_qty  =  new Float(Math.ceil(issue_qty*base_to_def_uom_equl_value)).doubleValue();
			 }
			 else{
				 if(disp_uom!=base_uom){ 
					 issue_qty  = new Double(Math.ceil(Float.parseFloat(issue_qty+"")*base_to_disp_uom_equl_value));
				}
			 }
			
			}// Added for ML-BRU-SCF-1799 -End
			if(st_no_of_decimals == null || st_no_of_decimals.equals("") || Integer.parseInt(st_no_of_decimals)<=0)//if else Added for AAKH-SCF-0113[IN:048937]
				issue_qty = Math.ceil(issue_qty);
			else{
				int noOfDecimals =  Integer.parseInt(st_no_of_decimals);
				for(int i=0;i <noOfDecimals; i++){
					if(i==0)
						decimalString.append(".#");
					else
						decimalString.append("#");
				}
				DecimalFormat df = new DecimalFormat(decimalString.toString());
				issue_qty = Double.parseDouble(df.format(issue_qty));
			}
		   System.err.println("@@@@ getBaseAndIssueUOMQty 7697 =========>>>> base_to_disp_uom_equl_value="+base_to_disp_uom_equl_value+" base_to_def_uom_equl_value="+base_to_def_uom_equl_value+" base_qty="+base_qty+" issue_qty="+issue_qty+" disp_qty="+disp_qty+" store_code="+store_code+" item_code="+item_code+" base_uom="+base_uom+" disp_uom"+disp_uom+" def_store_uom="+def_store_uom); 

		   BaseAndIssueQTYDetail.put("BASE_QTY",base_qty+"");
		   BaseAndIssueQTYDetail.put("ISSUE_QTY",issue_qty+"");
		   BaseAndIssueQTYDetail.put("BASE_UOM",base_uom);
		   BaseAndIssueQTYDetail.put("DEF_STORE_UOM",def_store_uom);
			
		}
		catch ( Exception e ) {
            e.printStackTrace() ;
		}
		finally {
            try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt1 ) ;
				closeResultSet(resultSet2 ); //common-icn-0029
				closeStatement( pstmt2 ) ; //common-icn-0029
				
				
				//closeConnection( connection );
            }
			catch(Exception es){
				es.printStackTrace();
			}
        }
		return BaseAndIssueQTYDetail;
	}

	public double getEqulValue (Connection connection,String item_code,String uom_code,String equl_uom_code){
		//System.err.println("@@@@ getEqulValue starting=========>>>> item_code="+item_code+" uom_code="+uom_code+" equl_uom_code="+equl_uom_code); 
		//Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		double eqvl_value			= 1;
		try {
          //  pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT161")) ;
		//	pstmt		= connection.prepareStatement( "select EQVL_VALUE from MM_ITEM_UOM_DEFN where ITEM_CODE=? and UOM_CODE =? and EQVL_UOM_CODE=?") ;
			if(uom_code.equals(equl_uom_code)){
					eqvl_value			= 1;
			}
			else{
				//pstmt		= connection.prepareStatement( "select PH_calculate_equl_val(ITEM_CODE,UOM_CODE,EQVL_UOM_CODE,'Y') EQVL_VALUE from MM_ITEM_UOM_DEFN where ITEM_CODE=? and UOM_CODE =? and EQVL_UOM_CODE=?") ;
				pstmt		= connection.prepareStatement( "select eqvl_value/eqvl_uom_qty EQVL_VALUE from MM_ITEM_UOM_DEFN where ITEM_CODE=? and UOM_CODE =? and EQVL_UOM_CODE=?") ;

				pstmt.setString(1,item_code);
				pstmt.setString(2,uom_code);
				pstmt.setString(3,equl_uom_code);
				resultSet	= pstmt.executeQuery() ;
				
				if (resultSet.next()){
					eqvl_value = resultSet.getDouble("EQVL_VALUE") <= 0 ? 1:resultSet.getDouble("EQVL_VALUE");	
					//System.err.println("@@@@ getEqulValue in result=========>>>> eqvl_value="+eqvl_value);
				}
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;			
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return eqvl_value;
	}

	public String getIVPREPYNAndDischargeYN(Connection connection,String order_id){
		//Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String iv_prep_yn		= "";
		String sDischargeYN		= "N";
		try {

          //  pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT161")) ;
			pstmt		= connection.prepareStatement( "select iv_prep_yn,  decode(DISCHARGE_IND,'D','Y','N') DISCHARGE_IND from or_order where order_id =?") ;
			pstmt.setString(1,order_id);
            resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
				iv_prep_yn = resultSet.getString("iv_prep_yn")==null?"N":resultSet.getString("iv_prep_yn");				
				sDischargeYN = resultSet.getString("DISCHARGE_IND");				
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;			
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return iv_prep_yn+"~"+sDischargeYN;
	}

	private HashMap getDailySquNumbersBackUp(ArrayList alOrderLineData , String sSQL){
		Connection oConnection		    = null;
		ResultSet oResultSet			= null;
		Statement oStatement			= null;
		HashMap	hmDailySeqNumbers		= new HashMap();

		StringBuffer sbOrderIds = new StringBuffer("and a.ORDER_ID in ('");
		for(int i=0;i<alOrderLineData.size();i=i+6){	//Modified for RUT-CRF-0088 [IN036978] 7->6
			sbOrderIds.append(alOrderLineData.get(i+3)+"'");
			if(alOrderLineData.size()>(i+6))	//Modified for RUT-CRF-0088 [IN036978] 7->6
				sbOrderIds.append(",'");
		}
		sbOrderIds.append(")");

		try {
			oConnection	= getConnection(prop) ;
			oStatement	= oConnection.createStatement();

			oResultSet	= oStatement.executeQuery(sSQL+" "+ sbOrderIds.toString());

			if(oResultSet!=null){
				while(oResultSet.next()){
					if( oResultSet.getString("DSN_AVAILABLE")!=null && oResultSet.getString("DSN_AVAILABLE").equals("Y"))
						hmDailySeqNumbers.put(oResultSet.getString("ORDER_IDS"),oResultSet.getString("SEQ_NUM"));
				}
			}
		}
		catch ( Exception e ){
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( oResultSet ) ;
				closeStatement( oStatement ) ;
				closeConnection( oConnection,prop ); 
			}
			catch ( Exception e ){
				e.printStackTrace() ;
			}
		}

		return hmDailySeqNumbers.size()==0?null:hmDailySeqNumbers;
	}

	public void	insertToPPNOrders(Connection connection,String sInsertPPNQuery,HashMap tabData,HashMap seq_no) throws Exception {

		PreparedStatement oPreparedStatement	= null;
		HashMap hmPPNValues				= (HashMap)tabData.get("hmPPNValues");
		try {
			oPreparedStatement	= connection.prepareStatement(sInsertPPNQuery) ;

			oPreparedStatement.setString(1,(String)tabData.get("facility_id"));
			oPreparedStatement.setString(2,(String)hmPPNValues.get("itemCode"));
			oPreparedStatement.setString(3,(String)hmPPNValues.get("batchId"));
			oPreparedStatement.setString(4,(String)hmPPNValues.get("selectedQty"));
			oPreparedStatement.setString(5,(String)hmPPNValues.get("tradeId"));
			oPreparedStatement.setString(6,(String)seq_no.get((String)hmPPNValues.get("orderId")));
			oPreparedStatement.setString(7,(String)hmPPNValues.get("UOMCode"));
			oPreparedStatement.setString(8,(String)tabData.get("disp_locn_code"));
			oPreparedStatement.setString(9,(String)hmPPNValues.get("orderId"));
			oPreparedStatement.setString(10,(String)hmPPNValues.get("expiryDate"));
			oPreparedStatement.setString(11,(String)hmPPNValues.get("binLocation"));
			oPreparedStatement.setString(12,(String)hmPPNValues.get("patientId"));
			oPreparedStatement.setString(13,(String)tabData.get("login_by_id"));
			oPreparedStatement.setString(14,(String)tabData.get("login_at_ws_no"));
			oPreparedStatement.setString(15,(String)tabData.get("login_by_id"));
			oPreparedStatement.setString(16,(String)tabData.get("login_at_ws_no"));
			oPreparedStatement.setString(17,(String)tabData.get("facility_id"));
			oPreparedStatement.setString(18,(String)tabData.get("facility_id"));
			
			int iInserted = oPreparedStatement.executeUpdate();
			if(iInserted != 1){
				throw new EJBException("Error: PPN Insertion Failed");
			}
		}
		catch ( Exception e ){
			e.printStackTrace() ;
			throw new EJBException("Error: PPN Insertion Failed");
		}
		finally {
			try{
				closeStatement( oPreparedStatement ) ;
			}
			catch ( Exception e ){
				e.printStackTrace() ;
			}
		}
	}

	public String getSeqNumber(Connection connection, String sFacilityId,String sStoreCode)throws Exception{
		CallableStatement oCalStatement	= null;
		ResultSet oResultSet			= null;
		Statement oStatement			= null;
		int iDailySeqNo					= 0;
		try{
			oStatement	= connection.createStatement();
			oResultSet	= oStatement.executeQuery("SELECT DECODE(ip_dsn_yn,null,'N',ip_dsn_yn) ip_dsn_yn FROM ph_facility_param WHERE facility_id = '"+sFacilityId+"'");

			if(oResultSet!=null && oResultSet.next()){
				if(oResultSet.getString("IP_DSN_YN").equals("Y")){
					oCalStatement=connection.prepareCall("{call PH_GET_DISP_DLY_SEQ_NO(?,?,?)}");
					oCalStatement.setString(1, sFacilityId.trim());
					oCalStatement.setString(2, sStoreCode.trim());
					oCalStatement.registerOutParameter(3,Types.VARCHAR);
					oCalStatement.execute();
					iDailySeqNo = oCalStatement.getInt(3);
				}
			}
		}
		catch ( Exception e ){
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( oResultSet ) ;
			closeStatement( oStatement ) ;
			closeStatement( oCalStatement ) ;
		}
		 if(iDailySeqNo == 0)
			 return "";
		 else
			 return iDailySeqNo+"";		
	}

	public void updateNextCollDate(HashMap tabData,HashMap sqlMap){
		Connection oConnection					= null ;
		PreparedStatement oPreparedStatement	= null;
		try{
			prop		= (Properties)tabData.get("properties");	
			oConnection	= getConnection( prop ) ;
			
			ArrayList alBMSOrderIds =(ArrayList)tabData.get("BMSOrderIds");

			oPreparedStatement = oConnection.prepareStatement((String)sqlMap.get("SQL_ORDER_LINE_PH_NEXT_COL_DATE_UPDATE"));
			if(alBMSOrderIds.size()>0)	{
				for(int i=0;i<alBMSOrderIds.size();i++){
					ArrayList alBMSOrderValues = (ArrayList)alBMSOrderIds.get(i);

					oPreparedStatement.setString(1,(String)tabData.get("NextCollectionDate"));
					oPreparedStatement.setString(2,(String)tabData.get("bmsReasonCode"));
					oPreparedStatement.setString(3,(String)tabData.get("login_by_id"));
					oPreparedStatement.setString(4,(String)tabData.get("facility_id"));
					oPreparedStatement.setString(5,(String)tabData.get("login_at_ws_no"));
					oPreparedStatement.setString(6,(String)alBMSOrderValues.get(0));
					oPreparedStatement.setString(7,(String)alBMSOrderValues.get(1));
					oPreparedStatement.addBatch();
				}
				int result[] = oPreparedStatement.executeBatch();
				boolean	bFlag	= true;

				for (int i=0;i<result.length ;i++ ){
						// A number greater than or equal to zero  indicates success
						// A number -2 indicates that command is successful but number of rows updated is unknow
						// If it won't satisfy any of the above cancel the statement and throw an exception
					if(result[i]<0  && result[i] != -2 ){
						bFlag	= false;
					}		
				}
				if(bFlag)
					oConnection.commit();
				else
					oConnection.rollback();					
			}
		}
		catch (Exception e)	{
			System.err.println("<<< Next Collection Date updateException "+ tabData );
			e.printStackTrace();
			try{
				oConnection.rollback();	
			}
			catch (SQLException sqlE){}
		}
		finally{
			try{
				closeStatement (oPreparedStatement);
				oPreparedStatement	=null;
				closeConnection( oConnection,prop );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
	}
public void updateEditValues(HashMap tabData,HashMap sqlMap){//Added for jd-crf-0221

	Connection oConnection					= null ;
	PreparedStatement oPstmtUpdateDispDtl	= null;
	String sOrderId							= "";
	String sOrderLineNo						= "";
	String Drug_code                        ="";
	
	try{
		prop		= (Properties)tabData.get("properties");	
		oConnection	= getConnection( prop ) ;
		HashMap hmEditLabel			    = (HashMap)tabData.get("editLables");
		ArrayList orderLineData			 = (ArrayList)tabData.get("orderLineData");
		HashMap editableLabel			= tabData.get("editableLabel")!=null?(HashMap)tabData.get("editableLabel"):null; 
		
		System.out.println("updateEditValues editableLabel"+editableLabel);
		
		String sSQL						= "";
	
			sSQL						= "update or_order_line_ph set LABEL_BMS_REMARKS_CODE =? where  order_id = ? and ORDER_LINE_NUM=? ";
		
		if(hmEditLabel!=null && hmEditLabel.size()>0){
			Iterator itrEditLabelKeys = hmEditLabel.keySet().iterator();
			ArrayList edit_result	= new ArrayList();
			String sKey = "";
			oPstmtUpdateDispDtl		= oConnection.prepareStatement(sSQL);
			System.out.println("9447 sSQL"+sSQL);
			int iCount = 0;
			
			while(itrEditLabelKeys.hasNext()){
				iCount	=	0;
				sKey = (String)itrEditLabelKeys.next();
				if(sKey!=null && (sKey.split("_")).length>0 && sKey.split("_")[0] != null){
					sOrderId	 = sKey.split("_")[0];
					Drug_code    = sKey.split("_")[1];//added for  ML-BRU-CRF-072[Inc:29938]
					sOrderLineNo = sKey.split("_")[2];

					edit_result =(ArrayList)hmEditLabel.get(sKey);
					if(edit_result!=null && edit_result.size()>0){ 
						
						oPstmtUpdateDispDtl.setString(++iCount,(String)edit_result.get(13));	
						oPstmtUpdateDispDtl.setString(++iCount,sOrderId.trim());
						
						oPstmtUpdateDispDtl.setString(++iCount,sOrderLineNo.trim());
						}
						
						oPstmtUpdateDispDtl.addBatch();
					}
				}						
			
			if(oPstmtUpdateDispDtl != null){
				int result[] = oPstmtUpdateDispDtl.executeBatch();

				for (int i=0;i<result.length ;i++ ){
						if(result[i]<0  && result[i] != -2 ){
						oPstmtUpdateDispDtl.cancel();
						oConnection.rollback();
						throw new EJBException("Error: Update for bms code or_order_line_ph (Edit label values) failed... ");
					}		
				}
			}
		}
		
		oConnection.commit();
	}
	catch (Exception e){
		System.err.println("<<<updateDTLValuese updateException "+ tabData);
		e.printStackTrace();
		try{
			oConnection.rollback();	
		}
		catch (SQLException sqlE){}
	}
	finally{
		try{
			closeStatement (oPstmtUpdateDispDtl);
			oPstmtUpdateDispDtl	=null;
			closeConnection( oConnection,prop );
		}
		catch(Exception es){
			es.printStackTrace();
		}
	}

}
	public void updateDTLValues(HashMap tabData,HashMap sqlMap){
		Connection oConnection					= null ;
		PreparedStatement oPstmtUpdateDispDtl	= null;
		String sOrderId							= "";
		String sOrderLineNo						= "";
		String Drug_code                        ="";
		String IV_PREP_YN="";// added for ML-MMOH-CRF-1089
		try{
			prop		= (Properties)tabData.get("properties");	
			oConnection	= getConnection( prop ) ;
			boolean siteTpn = new CommonBean().isSiteSpecific(oConnection, "PH","TPN_STD_REGIMEN_LABEL");// added for ML-MMOH-CRF-1089
			boolean siteEditTpn = new CommonBean().isSiteSpecific(oConnection, "PH","BMS_REMAEKS_APP");// added for ML-MMOH-CRF-1089
			
			HashMap hmEditLabel			    = (HashMap)tabData.get("editLables");
			ArrayList orderLineData			 = (ArrayList)tabData.get("orderLineData");// added for ML-MMOH-CRF-1089
			HashMap editableLabel			= tabData.get("editableLabel")!=null?(HashMap)tabData.get("editableLabel"):null; // Added for Bru-HIMS-CRF-414 [IN:045554]
			System.out.println("editableLabel"+editableLabel);
			String allow_edit_disp_label	= tabData.get("allow_edit_disp_label")!=null?(String)tabData.get("allow_edit_disp_label"):""; // Added for Bru-HIMS-CRF-414 [IN:045554]
			
			String sSQL						= "";
			/*if(sqlMap.containsKey("SQL_PH_DISP_DTL_TMP_UPDATE"))
				sSQL						= (String) sqlMap.get("SQL_PH_DISP_DTL_TMP_UPDATE");
			else if(sqlMap.containsKey("SQL_PH_DISP_DTL_UPDATE"))
				sSQL						= (String) sqlMap.get("SQL_PH_DISP_DTL_UPDATE");
			*/
			if(siteEditTpn){
				if(sqlMap.containsKey("SQL_PH_DISP_DTL_TMP_UPDATE"))
					sSQL						= "update ph_disp_dtl_tmp set LABEL_CAU_INSTRN1_ENG =? , LABEL_CAU_INSTRN2_ENG=? , LABEL_SPL_INSTRN1_ENG=? , LABEL_SPL_INSTRN2_ENG=? , LABEL_PAT_INSTRN1_ENG=? , LABEL_CAU_INSTRN1_LOC=? , LABEL_CAU_INSTRN2_LOC=? , LABEL_SPL_INSTRN1_LOC=? , LABEL_SPL_INSTRN2_LOC=? , LABEL_PAT_INSTRN1_LOC=? , PRES_REMARK_CODE = ?,DRUG_INDICATION=?, MODIFIED_DATE=SYSDATE, MODIFIED_BY_ID=?,MODIFIED_FACILITY_ID=?,MODIFIED_AT_WS_NO=?,LABEL_BMS_REMARKS_CODE=? where facility_id = ? AND order_id = ? AND ORDER_LINE_NO =? AND DISP_DRUG_CODE =?";
				else if(sqlMap.containsKey("SQL_PH_DISP_DTL_UPDATE"))
					sSQL						= "update ph_disp_dtl set LABEL_CAU_INSTRN1_ENG =? , LABEL_CAU_INSTRN2_ENG=? , LABEL_SPL_INSTRN1_ENG=? , LABEL_SPL_INSTRN2_ENG=? , LABEL_PAT_INSTRN1_ENG=? , LABEL_CAU_INSTRN1_LOC=? , LABEL_CAU_INSTRN2_LOC=? , LABEL_SPL_INSTRN1_LOC=? , LABEL_SPL_INSTRN2_LOC=? , LABEL_PAT_INSTRN1_LOC=? , PRES_REMARK_CODE = ?, DRUG_INDICATION=?, MODIFIED_DATE=SYSDATE, MODIFIED_BY_ID=?,MODIFIED_FACILITY_ID=?,MODIFIED_AT_WS_NO=?,LABEL_BMS_REMARKS_CODE=? where facility_id = ? AND order_id = ? AND ORDER_LINE_NO =? AND DISP_DRUG_CODE =?";
				
			}
			else{
				if(sqlMap.containsKey("SQL_PH_DISP_DTL_TMP_UPDATE"))
					sSQL						= (String) sqlMap.get("SQL_PH_DISP_DTL_TMP_UPDATE");
				else if(sqlMap.containsKey("SQL_PH_DISP_DTL_UPDATE"))
					sSQL						= (String) sqlMap.get("SQL_PH_DISP_DTL_UPDATE");
				
			}
			// added for ML-MMOH-CRF-1089 start
			String sTmpValue					= getIVPREPYNAndDischargeYN ( oConnection, (String)orderLineData.get(3));
			IV_PREP_YN					= sTmpValue.split("~")[0];
			
			if(siteTpn && IV_PREP_YN.equals("7") )
				sSQL						= "update PH_TPN_STANDARD_REGIMEN set LABEL_CAU_INSTRN1_ENG =? , LABEL_CAU_INSTRN2_ENG=? , LABEL_SPL_INSTRN1_ENG=? , LABEL_SPL_INSTRN2_ENG=? , LABEL_PAT_INSTRN1_ENG=? , LABEL_CAU_INSTRN1_LOC=? , LABEL_CAU_INSTRN2_LOC=? , LABEL_SPL_INSTRN1_LOC=? , LABEL_SPL_INSTRN2_LOC=? , LABEL_PAT_INSTRN1_LOC=? , MODIFIED_DATE=SYSDATE, MODIFIED_BY_ID=?,MODIFIED_FACILITY_ID=?,MODIFIED_AT_WS_NO=? where facility_id = ? AND order_id = ? AND TPN_REGIMEN_CODE =?";
			// added for ML-MMOH-CRF-1089 end
			if(hmEditLabel!=null && hmEditLabel.size()>0){
				Iterator itrEditLabelKeys = hmEditLabel.keySet().iterator();
				ArrayList edit_result	= new ArrayList();
				String sKey = "";
				oPstmtUpdateDispDtl		= oConnection.prepareStatement(sSQL);
				System.out.println("sSQL"+sSQL);
				int iCount = 0;
				
				while(itrEditLabelKeys.hasNext()){
					iCount	=	0;
					sKey = (String)itrEditLabelKeys.next();
					if(sKey!=null && (sKey.split("_")).length>0 && sKey.split("_")[0] != null){
						sOrderId	 = sKey.split("_")[0];
						Drug_code    = sKey.split("_")[1];//added for  ML-BRU-CRF-072[Inc:29938]
						sOrderLineNo = sKey.split("_")[2];

						edit_result =(ArrayList)hmEditLabel.get(sKey);
						//if(edit_result.size()>0 && (edit_result.get(0)!=null && !edit_result.get(0).toString().trim().equals("") || edit_result.get(11)!=null && !edit_result.get(11).toString().trim().equals("")) ){ // Commented for for SKR-SCF-0649[Inc:35278]
						if(edit_result!=null && edit_result.size()>0){ //commneted above condition and added this for SKR-SCF-0649[Inc:35278]
							oPstmtUpdateDispDtl.setString(++iCount,(String)edit_result.get(0));
							oPstmtUpdateDispDtl.setString(++iCount,(String)edit_result.get(1));
							oPstmtUpdateDispDtl.setString(++iCount,(String)edit_result.get(2));
							oPstmtUpdateDispDtl.setString(++iCount,(String)edit_result.get(3));
							oPstmtUpdateDispDtl.setString(++iCount,(String)edit_result.get(4));
							oPstmtUpdateDispDtl.setString(++iCount,(String)edit_result.get(5));
							oPstmtUpdateDispDtl.setString(++iCount,(String)edit_result.get(6));
							oPstmtUpdateDispDtl.setString(++iCount,(String)edit_result.get(7));
							oPstmtUpdateDispDtl.setString(++iCount,(String)edit_result.get(8));
							oPstmtUpdateDispDtl.setString(++iCount,(String)edit_result.get(9));
							// added for ML-MMOH-CRF-1089 start
							if(!(siteTpn &&  IV_PREP_YN.equals("7")) ) //modified for ML-BRU-SCF-1872
							{oPstmtUpdateDispDtl.setString(++iCount,(String)edit_result.get(10));//NOT REQ
							oPstmtUpdateDispDtl.setString(++iCount,(String)edit_result.get(11));//Added for ML-BRU-CRF-072[Inc:29938]//NOT REQ
							}
							// added for ML-MMOH-CRF-1089 end
							oPstmtUpdateDispDtl.setString(++iCount,(String)tabData.get("login_by_id"));
							oPstmtUpdateDispDtl.setString(++iCount,(String)tabData.get("facility_id"));
							oPstmtUpdateDispDtl.setString(++iCount,(String)tabData.get("login_at_ws_no"));
							if(siteEditTpn && !(siteTpn && IV_PREP_YN.equals("7"))) //modified for ML-BRU-SCF-1872
							{
							oPstmtUpdateDispDtl.setString(++iCount,(String)edit_result.get(13));
							}
							
							oPstmtUpdateDispDtl.setString(++iCount,(String)tabData.get("facility_id"));
							oPstmtUpdateDispDtl.setString(++iCount,sOrderId.trim());
							// added for ML-MMOH-CRF-1089 start
							if(!(siteTpn &&  IV_PREP_YN.equals("7")) ) //modified for ML-BRU-SCF-1872
							{
							oPstmtUpdateDispDtl.setString(++iCount,sOrderLineNo.trim());
							}
							//added for ML-MMOH-CRF-1089  END
							oPstmtUpdateDispDtl.setString(++iCount,(String)edit_result.get(12));
							oPstmtUpdateDispDtl.addBatch();
						}
					}						
				}
				if(oPstmtUpdateDispDtl != null){
					int result[] = oPstmtUpdateDispDtl.executeBatch();

					for (int i=0;i<result.length ;i++ ){
							// A number greater than or equal to zero  indicates success
							// A number -2 indicates that command is successful but number of rows updated is unknow
							// If it won't satisfy any of the above cancel the statement and throw an exception
						if(result[i]<0  && result[i] != -2 ){
							oPstmtUpdateDispDtl.cancel();
							oConnection.rollback();
							throw new EJBException("Error: Update PH_DISP_DTL_TMP (Edit label values) failed... ");
						}		
					}
				}
			}
			if(allow_edit_disp_label.equals("Y") && editableLabel!=null && editableLabel.size()>0){ //if block Added for Bru-HIMS-CRF-414 [IN:045554]
				insertUpdateDispLabelDtl(oConnection, sqlMap,tabData, null);
			}
			oConnection.commit();
		}
		catch (Exception e){
			System.err.println("<<<updateDTLValuese updateException "+ tabData);
			e.printStackTrace();
			try{
				oConnection.rollback();	
			}
			catch (SQLException sqlE){}
		}
		finally{
			try{
				closeStatement (oPstmtUpdateDispDtl);
				oPstmtUpdateDispDtl	=null;
				closeConnection( oConnection,prop );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
	}//UpdateConsumableDetails

	private HashMap getDecimalAllowedYN(String sItemCodes) {
		Connection oConnection		    = null;
		ResultSet oResultSet			= null;
		Statement oStatement			= null;
		HashMap	hmDecimalAllowedYN		= new HashMap();

		try{
			oConnection	= getConnection(prop) ;
			oStatement	= oConnection.createStatement();

			oResultSet	= oStatement.executeQuery("select item_code, ALLOW_DECIMALS_YN from st_item where item_code in "+sItemCodes);

			if(oResultSet!=null){
				String sAllowDecimalYN ="N";
				while(oResultSet.next()){
					sAllowDecimalYN = oResultSet.getString("ALLOW_DECIMALS_YN")==null?"N":oResultSet.getString("ALLOW_DECIMALS_YN");
					hmDecimalAllowedYN.put(oResultSet.getString("ITEM_CODE"),sAllowDecimalYN);
				}
			}
		}
		catch ( Exception e ){
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( oResultSet ) ;
				closeStatement( oStatement ) ;
				closeConnection( oConnection,prop ); 
			}
			catch ( Exception e ){
				e.printStackTrace() ;
			}
		}
		return hmDecimalAllowedYN.size()==0?null:hmDecimalAllowedYN;
	}

	public String getCustomerID(Connection connection)throws Exception	{
		
        PreparedStatement pstmt		= null;
        ResultSet rsCustomerID		= null;
		String customer_id			= "";
		try {
			pstmt = connection.prepareStatement("SELECT CUSTOMER_ID FROM SM_SITE_PARAM WHERE SITE_ID = 'DS'");
			rsCustomerID = pstmt.executeQuery();
			if(rsCustomerID.next()){
				customer_id = rsCustomerID.getString("CUSTOMER_ID")==null?"":rsCustomerID.getString("CUSTOMER_ID");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( rsCustomerID ) ;
			closeStatement( pstmt ) ;
		}
		return customer_id;
	}

	public ArrayList getEssentialItemYN(Connection connection,String item_code)throws Exception	{
        PreparedStatement pstmt		= null;
        ResultSet rsCustomerID		= null;
		ArrayList essentialReimberse	= new ArrayList();
		try {
			pstmt = connection.prepareStatement("select ESSENTIAL_ITEM_YN, REIMBURSABLE_ITEM_YN  from mm_item where item_code =?");
			pstmt.setString(1,item_code);

			rsCustomerID = pstmt.executeQuery();
			if(rsCustomerID.next()){
				essentialReimberse.add(rsCustomerID.getString("ESSENTIAL_ITEM_YN")==null?"":rsCustomerID.getString("ESSENTIAL_ITEM_YN"));
				essentialReimberse.add(rsCustomerID.getString("REIMBURSABLE_ITEM_YN")==null?"":rsCustomerID.getString("REIMBURSABLE_ITEM_YN"));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( rsCustomerID ) ;
			closeStatement( pstmt ) ;
		}
		return essentialReimberse;
	}

	public String GenerateCerRemNO (Connection connection)throws Exception	{
        CallableStatement cstmt	    = null;
		String cer_rem_no			= "";
		try {			
			cstmt					= connection.prepareCall("{call ph_gen_cert_reimb_no (?)}");
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.execute();
			cer_rem_no	= cstmt.getString(1);
		}
		catch ( Exception e ) {
				e.printStackTrace() ;
		}
		finally {
			
			closeStatement( cstmt ) ;
		}
		return cer_rem_no;
	}

	public String getDrugDesc(Connection connection,String drug_code ,String language_id)throws Exception	{
        PreparedStatement pstmt		= null;
        ResultSet rsCustomerID		= null;
		String drug_desc			= "";

		try {
			pstmt = connection.prepareStatement("select drug_desc from ph_drug_lang_vw   where DRUG_CODE=? and  LANGUAGE_ID=?");
			pstmt.setString(1,drug_code);
			pstmt.setString(2,language_id);

			rsCustomerID = pstmt.executeQuery();
			if(rsCustomerID.next()){
				drug_desc = rsCustomerID.getString("drug_desc");
			}
		}
		catch ( Exception e ) {
				e.printStackTrace() ;
		}
		finally {
			closeResultSet( rsCustomerID ) ;
			closeStatement( pstmt ) ;
		}
		return drug_desc;
	}
	
	private boolean updateHeaderTMP(Connection connection, HashMap tabData, HashMap sqlMap,ArrayList dispTMP) throws Exception{// Header tmp table insert method
		PreparedStatement pstmt_update_disp_hrd_tmp	 =  null;
		ResultSet resultSet							 =  null;	
		boolean bRecUpdated = false;
		String order_id="";
		int count		  = 1;
		try {
			pstmt_update_disp_hrd_tmp	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_HRD_TMP_UPDATE_FILLEDBY") ) ;
			for(int i=0;i<dispTMP.size();i+=7){
				count		  = 1;
				order_id						=	(String)dispTMP.get(i);
				pstmt_update_disp_hrd_tmp.setString(count,(String)tabData.get("FillPersonName"));
				pstmt_update_disp_hrd_tmp.setString(++count,tabData.get("login_by_id").toString()); // Modified for RUT-SCF-0274 IN039740  
				pstmt_update_disp_hrd_tmp.setString(++count,order_id);
				pstmt_update_disp_hrd_tmp.setString(++count,(String)tabData.get("facility_id"));
				pstmt_update_disp_hrd_tmp.addBatch();					
			}
			int[] result4	=pstmt_update_disp_hrd_tmp.executeBatch();
			for (int i=0;i<result4.length ;i++ ){
				if(result4[i]<0  && result4[i] != -2 ){
					pstmt_update_disp_hrd_tmp.cancel();
					bRecUpdated= false;
					connection.rollback();
					throw new EJBException("Error: Hdr tmp update FilledByName Failed");
				}		
			}
			bRecUpdated = true;
		}
		catch(Exception e){
			System.err.println("HDR_TMP Update FilledByName FAILED tabData="+tabData);
			e.printStackTrace();
			throw new EJBException("Error: HDR_TMP Update FilledByName FAILED");
		}
		finally{	
			try {
				closeStatement( pstmt_update_disp_hrd_tmp ) ;
				closeResultSet( resultSet );
			}
			catch(Exception es) { 
				es.printStackTrace();
				throw es;
			}
		}
		return bRecUpdated;
	}

	private boolean updateDetailTmp(Connection connection, HashMap tabData, HashMap sqlMap,ArrayList dispTMP) throws Exception{ //code added for ML-BRU-SCF-0971[IN042220]-- Start	 //	updateFindingReason method name changed as updateDetailTmp for RUT-CRF-0061 [IN46104]
		PreparedStatement pstmt_update_disp_dtl_tmp	 =  null;
		ResultSet resultSet							 =  null;	
		boolean bRecUpdated	 = false;
		String sOrderId="",sOrderLineNo="",code="",remarks="",key="";
		int count		  = 1;
		String disp_stage = (String)tabData.get("disp_stage");
		HashMap	allocateRemarks = null,fillingRemarks = null;		
		try {
		   if(disp_stage.equals("F"))
				pstmt_update_disp_dtl_tmp	= connection.prepareStatement( "UPDATE  PH_DISP_DTL_TMP SET PRINT_SEQ_NO=?, FILL_REMARKS_CODE=?, FILL_TASK_FINDING=?, FACILITY_ID= ?, MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE ORDER_ID=? AND ORDER_LINE_NO=? " ) ;
		   else if(disp_stage.equals("A"))
				pstmt_update_disp_dtl_tmp	= connection.prepareStatement( "UPDATE  PH_DISP_DTL_TMP SET PRINT_SEQ_NO=?, ALLOCATE_REMARKS_CODE=?, ALLOCATE_TASK_FINDING=?, FACILITY_ID= ?, MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE ORDER_ID=? AND ORDER_LINE_NO=? " ) ;	
				
			for(int i=0;i<dispTMP.size();i+=7){
				count		  = 1;
				sOrderId		= dispTMP.get(i).toString().trim();
				sOrderLineNo	= dispTMP.get(i+1).toString().trim();
				key	=	sOrderId+"_"+sOrderLineNo;
				if(disp_stage.equals("F")){
					fillingRemarks			=   (HashMap)tabData.get("fillingRemarks");
					if(fillingRemarks.containsKey(key)) {
						ArrayList result	= (ArrayList)fillingRemarks.get(key);
						code			= (String)result.get(1);
						remarks			= (String)result.get(2);
					}
					else{
						code			= "";
						remarks			= "";						
					}
				}
				else if(disp_stage.equals("A")){
					allocateRemarks			=   (HashMap)tabData.get("allocatefill_remarks");
					if(allocateRemarks.containsKey(key)) {
						ArrayList result	= (ArrayList)allocateRemarks.get(key);
						code	= (String)result.get(1);
						remarks	= (String)result.get(2);
					}
					else{
						code		= "";
						remarks		= "";
					}
				}	
								
				pstmt_update_disp_dtl_tmp.setString(count,tabData.get("print_seq_no_tmp").toString()); //Added for RUT-CRF-0061 [IN46104]
				pstmt_update_disp_dtl_tmp.setString(++count,code);
				pstmt_update_disp_dtl_tmp.setString(++count,remarks);
				pstmt_update_disp_dtl_tmp.setString(++count,(String)tabData.get("facility_id"));				
				pstmt_update_disp_dtl_tmp.setString(++count,(String)tabData.get("login_by_id"));
				pstmt_update_disp_dtl_tmp.setString(++count,(String)tabData.get("login_at_ws_no"));
				pstmt_update_disp_dtl_tmp.setString(++count,(String)tabData.get("facility_id"));
				pstmt_update_disp_dtl_tmp.setString(++count,sOrderId);
				pstmt_update_disp_dtl_tmp.setString(++count,sOrderLineNo);				
				pstmt_update_disp_dtl_tmp.addBatch();					
			}

			int[] result4	=pstmt_update_disp_dtl_tmp.executeBatch();
			for (int i=0;i<result4.length ;i++ ){
				if(result4[i]<0  && result4[i] != -2 ){
					pstmt_update_disp_dtl_tmp.cancel();
					bRecUpdated= false;
					connection.rollback();
					throw new EJBException("Error: Hdr tmp update FindingReason Failed");
				}		
			}
			bRecUpdated = true;
		}
		catch(Exception e){
			System.err.println("HDR_TMP Update FindingReason FAILED tabData="+tabData);
			e.printStackTrace();
			throw new EJBException("Error: HDR_TMP Update FindingReason FAILED");
		}
		finally{	
			try {
				closeStatement( pstmt_update_disp_dtl_tmp ) ;
				closeResultSet( resultSet );
			}
			catch(Exception es) { 
				es.printStackTrace();
				throw es;
			}
		}
		return bRecUpdated;
	}//code added for ML-BRU-SCF-0971[IN042220]--End
	
	private String insertMedicationPlan(Connection connection, HashMap sqlMap, HashMap tabData, HashMap hshDispNo) throws Exception {//Added for Bru-HIMS-CRF-072.1[IN 049144]
		PreparedStatement pstmt_insert	= null;
		int count =	0;
		String seq_no="";
		String strtemp[] = new String[5];
		boolean insertdone = false,boolmedplan=false,boolmedplanlocal=false;
		try {
			pstmt_insert	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_MEDICATION_PLAN_INSERT")); 
			String disp_stage=(String)tabData.get("disp_stage");
			if(disp_stage.equals("AS"))
				disp_stage="D";
			HashMap hshmedplan = (HashMap)tabData.get("hshmedplan");
			HashMap hshmedplanlocal =  (HashMap)tabData.get("hshmedplanlocal");
			HashMap hshTemp = new HashMap();
			Set <String> hshKeys = new HashSet<String>();
			Set <String> hshlocalKeys = new HashSet<String>();
			hshKeys = hshmedplan.keySet();
			hshlocalKeys = hshmedplanlocal.keySet();
			if((hshKeys!=null && hshKeys.size()>0)||(hshlocalKeys!=null && hshlocalKeys.size()>0)){
				for(String key:hshKeys){
					hshTemp = (HashMap)hshmedplan.get(key);
					if(((String)hshTemp.get("plan_recorded")).equals("Y")){
						boolmedplan = true;
					}
				}
				for(String key:hshlocalKeys){
					hshTemp = (HashMap)hshmedplanlocal.get(key);
					if(((String)hshTemp.get("plan_recorded")).equals("Y")){
						boolmedplanlocal = true;
					}
				}
			}
			if(boolmedplan || boolmedplanlocal)
				seq_no=getSequenceNo((String)sqlMap.get("SQL_PH_MED_PLAN_ID_SEQ"));
			if(boolmedplan){
				for(String key:hshKeys){
					hshTemp = (HashMap)hshmedplan.get(key);
					if(((String)hshTemp.get("plan_recorded")).equals("Y")){           
						count=0;strtemp[3] = ""; strtemp[4] = "";
						strtemp[0] = (String)hshTemp.get("order_id");
						strtemp[1] = (String)hshTemp.get("order_line_no");
						strtemp[2] = (String)hshDispNo.get(strtemp[0]+strtemp[1]);
						if(strtemp[2]!=null){
							strtemp[3] = strtemp[2].substring(0,strtemp[2].indexOf("~"));
							strtemp[4] = strtemp[2].substring(strtemp[2].indexOf("~")+1);
						}
						else{
							strtemp[3] = (String)hshTemp.get("disp_no");
							strtemp[4] = (String)hshTemp.get("disp_srl_no");
						}
						pstmt_insert.setString(++count, seq_no);
						pstmt_insert.setString(++count, (String)hshTemp.get("lang_id"));
						pstmt_insert.setString(++count, (String)tabData.get("facility_id"));
						pstmt_insert.setString(++count, (String)tabData.get("disp_locn_code"));
						pstmt_insert.setString(++count, (String)tabData.get("patient_id"));
						pstmt_insert.setString(++count, (String)tabData.get("encounter_id"));
						pstmt_insert.setString(++count, disp_stage);
						pstmt_insert.setString(++count, (String)hshTemp.get("order_id")); 
						pstmt_insert.setString(++count, (String)hshTemp.get("order_line_no")); 
						pstmt_insert.setString(++count, (String)hshTemp.get("pres_drug_code"));
						pstmt_insert.setString(++count, strtemp[3]);// Disp No
						pstmt_insert.setString(++count, strtemp[4]);// Disp Srl No
						pstmt_insert.setString(++count, (String)hshTemp.get("disp_drug_code"));
						pstmt_insert.setString(++count, (String)hshTemp.get("qty_issue"));
						pstmt_insert.setString(++count, (String)hshTemp.get("howtotake"));
						pstmt_insert.setString(++count, (String)hshTemp.get("impnote"));
						pstmt_insert.setString(++count, (String)hshTemp.get("morning"));
						pstmt_insert.setString(++count, (String)hshTemp.get("afternoon"));
						pstmt_insert.setString(++count, (String)hshTemp.get("evening"));
						pstmt_insert.setString(++count, (String)hshTemp.get("night"));
						pstmt_insert.setString(++count, (String)hshTemp.get("curr_disp_yn"));
						pstmt_insert.setString(++count, (String)hshTemp.get("merge_yn"));
						pstmt_insert.setString(++count, (String)hshTemp.get("merged_med_plan_id"));
						pstmt_insert.setString(++count, (String)hshTemp.get("chkdrug"));
						pstmt_insert.setString(++count, (String)tabData.get("login_by_id"));
						pstmt_insert.setString(++count, (String)tabData.get("login_at_ws_no"));
						pstmt_insert.setString(++count, (String)tabData.get("facility_id"));				
						pstmt_insert.setString(++count, (String)tabData.get("login_by_id"));
						pstmt_insert.setString(++count, (String)tabData.get("login_at_ws_no"));
						pstmt_insert.setString(++count, (String)tabData.get("facility_id"));
						pstmt_insert.addBatch();
				   }
				}
			}	
			if(boolmedplanlocal){	
				for(String key:hshlocalKeys){
					hshTemp = (HashMap)hshmedplanlocal.get(key);
					if(((String)hshTemp.get("plan_recorded")).equals("Y")){           
						count=0;strtemp[3] = ""; strtemp[4] = "";
						strtemp[0] = (String)hshTemp.get("order_id");
						strtemp[1] = (String)hshTemp.get("order_line_no");
						strtemp[2] = (String)hshDispNo.get(strtemp[0]+strtemp[1]);
						if(strtemp[2]!=null){
							strtemp[3] = strtemp[2].substring(0,strtemp[2].indexOf("~"));
							strtemp[4] = strtemp[2].substring(strtemp[2].indexOf("~")+1);
						}
						else{
							strtemp[3] = (String)hshTemp.get("disp_no");
							strtemp[4] = (String)hshTemp.get("disp_srl_no");
						}
						pstmt_insert.setString(++count, seq_no);
						pstmt_insert.setString(++count, (String)hshTemp.get("lang_id"));
						pstmt_insert.setString(++count, (String)tabData.get("facility_id"));
						pstmt_insert.setString(++count, (String)tabData.get("disp_locn_code"));
						pstmt_insert.setString(++count, (String)tabData.get("patient_id"));
						pstmt_insert.setString(++count, (String)tabData.get("encounter_id"));
						pstmt_insert.setString(++count, disp_stage);
						pstmt_insert.setString(++count, (String)hshTemp.get("order_id"));
						pstmt_insert.setString(++count, (String)hshTemp.get("order_line_no"));
						pstmt_insert.setString(++count, (String)hshTemp.get("pres_drug_code"));
						pstmt_insert.setString(++count, strtemp[3]);
						pstmt_insert.setString(++count, strtemp[4]);
						pstmt_insert.setString(++count, (String)hshTemp.get("disp_drug_code"));
						pstmt_insert.setString(++count, (String)hshTemp.get("qty_issuelocal"));
						pstmt_insert.setString(++count, (String)hshTemp.get("howtotakelocal"));
						pstmt_insert.setString(++count, (String)hshTemp.get("impnotelocal"));
						pstmt_insert.setString(++count, (String)hshTemp.get("morninglocal"));
						pstmt_insert.setString(++count, (String)hshTemp.get("afternoonlocal"));
						pstmt_insert.setString(++count, (String)hshTemp.get("eveninglocal"));
						pstmt_insert.setString(++count, (String)hshTemp.get("nightlocal"));
						pstmt_insert.setString(++count, (String)hshTemp.get("curr_disp_yn"));
						pstmt_insert.setString(++count, (String)hshTemp.get("merge_yn"));
						pstmt_insert.setString(++count, (String)hshTemp.get("merged_med_plan_id"));
						pstmt_insert.setString(++count, (String)hshTemp.get("chkdrug"));
						pstmt_insert.setString(++count, (String)tabData.get("login_by_id"));
						pstmt_insert.setString(++count, (String)tabData.get("login_at_ws_no"));
						pstmt_insert.setString(++count, (String)tabData.get("facility_id"));				
						pstmt_insert.setString(++count, (String)tabData.get("login_by_id"));
						pstmt_insert.setString(++count, (String)tabData.get("login_at_ws_no"));
						pstmt_insert.setString(++count, (String)tabData.get("facility_id"));
						pstmt_insert.addBatch();
				   }
				}
			}
			int[] result=pstmt_insert.executeBatch();
			for (int k=0;k<result.length ;k++ ){
				if(result[k]<0  && result[k] != -2 ){
					pstmt_insert.cancel();
					connection.rollback();
					insertdone=false;
					break;
				}
				else
					insertdone=true;
			} 
			if(!insertdone)
				seq_no="";
		}
		catch(Exception e){
			System.err.println(" tabData="+tabData);
			e.printStackTrace();
			connection.rollback();
			throw new EJBException("Error: Insert Medication Plan Failed");
		}
		finally{	
			try {
				closeStatement( pstmt_insert) ;
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
		return seq_no;
	}

	private String updateMedicationPlan(Connection connection, HashMap sqlMap, HashMap tabData) throws Exception{
		PreparedStatement pstmt_insert	= null,ps=null,pstmt_update=null,pstmt_update1=null ;
		ResultSet resultSet		= null,rs=null ;
		int count=0,rowcount=0;
		String strarrKey[] = new String[4];
		String mediplan_seq_no =  (String)tabData.get("mediplan_seq_no");
		boolean boolmedplan=false,boolmedplanlocal=false;
		try{
			HashMap hshmedplan = (HashMap)tabData.get("hshmedplan");
			HashMap hshmedplanlocal =  (HashMap)tabData.get("hshmedplanlocal");
			HashMap hshTemp = new HashMap();
			Set <String> hshKeys = new HashSet<String>();
			Set <String> hshlocalKeys = new HashSet<String>();
			hshKeys = hshmedplan.keySet();
			hshlocalKeys = hshmedplanlocal.keySet();
			String disp_stage=(String)tabData.get("disp_stage");//Unused local variable from check style INC63877  disp_no="" ,disp_srl_no=""
			if(disp_stage.equals("AS"))
				disp_stage="D";
			pstmt_update	= connection.prepareStatement((String)sqlMap.get("SQL_PH_MEDICATION_PLAN_UPDATE"));
			pstmt_insert	= connection.prepareStatement((String)sqlMap.get("SQL_PH_MEDICATION_PLAN_INSERT"));
			pstmt_update1	= connection.prepareStatement((String)sqlMap.get("SQL_PH_MEDICATION_PLAN_UPDATE1"));
			if((hshKeys!=null && hshKeys.size()>0)||(hshlocalKeys!=null && hshlocalKeys.size()>0)){
				for(String key:hshKeys){
					hshTemp = (HashMap)hshmedplan.get(key);
					if(((String)hshTemp.get("plan_recorded")).equals("Y")){
						boolmedplan = true;
					}
				}
				for(String key:hshlocalKeys){
					hshTemp = (HashMap)hshmedplanlocal.get(key);
					if(((String)hshTemp.get("plan_recorded")).equals("Y")){
						boolmedplanlocal = true;
					}
				}
			}
			if(boolmedplan){
				for(String key:hshKeys){
					hshTemp = (HashMap)hshmedplan.get(key);
					if(((String)hshTemp.get("plan_recorded")).equals("Y")){   
						count=0;
						strarrKey = key.split("_");
						ps	= connection.prepareStatement((String)sqlMap.get("SQL_PH_MEDICATION_PLAN_INSERT_CHECK"));
						ps.setString(1, mediplan_seq_no);
						ps.setString(2, strarrKey[3]);
						ps.setString(3, strarrKey[0]);
						ps.setString(4, strarrKey[1]);
						ps.setString(5, strarrKey[2]);
						rs = ps.executeQuery();
						if(rs.next())
							rowcount = rs.getInt(1);
						
						
						closeResultSet( rs ) ;//common-icn-0029
						closeStatement( ps ) ;//common-icn-0029

						if(rowcount>0){
							pstmt_update.setString(++count, disp_stage);
							pstmt_update.setString(++count, (String)hshTemp.get("qty_issue"));
							pstmt_update.setString(++count, (String)hshTemp.get("howtotake"));
							pstmt_update.setString(++count, (String)hshTemp.get("impnote"));
							pstmt_update.setString(++count, (String)hshTemp.get("morning"));
							pstmt_update.setString(++count, (String)hshTemp.get("afternoon"));
							pstmt_update.setString(++count, (String)hshTemp.get("evening"));
							pstmt_update.setString(++count, (String)hshTemp.get("night"));
							pstmt_update.setString(++count, (String)hshTemp.get("chkdrug"));			
							pstmt_update.setString(++count, (String)tabData.get("login_by_id"));
							pstmt_update.setString(++count, (String)tabData.get("login_at_ws_no"));
							pstmt_update.setString(++count, (String)tabData.get("facility_id"));
							pstmt_update.setString(++count, (String)tabData.get("patient_id"));
							pstmt_update.setString(++count, mediplan_seq_no);
							pstmt_update.setString(++count, strarrKey[0]);
							pstmt_update.setString(++count, strarrKey[1]);
							pstmt_update.setString(++count, strarrKey[3]);
							pstmt_update.setString(++count, strarrKey[2]);
							pstmt_update.addBatch();
						}
						else{
							pstmt_insert.setString(++count, mediplan_seq_no);
							pstmt_insert.setString(++count, (String)hshTemp.get("lang_id"));
							pstmt_insert.setString(++count, (String)tabData.get("facility_id"));
							pstmt_insert.setString(++count, (String)tabData.get("disp_locn_code"));
							pstmt_insert.setString(++count, (String)tabData.get("patient_id"));
							pstmt_insert.setString(++count, (String)tabData.get("encounter_id"));
							pstmt_insert.setString(++count, disp_stage);
							pstmt_insert.setString(++count, (String)hshTemp.get("order_id")); 
							pstmt_insert.setString(++count, (String)hshTemp.get("order_line_no")); 
							pstmt_insert.setString(++count, (String)hshTemp.get("pres_drug_code"));
							pstmt_insert.setString(++count, (String)hshTemp.get("disp_no"));
							pstmt_insert.setString(++count, (String)hshTemp.get("disp_srl_no"));
							pstmt_insert.setString(++count, (String)hshTemp.get("disp_drug_code"));
							pstmt_insert.setString(++count, (String)hshTemp.get("qty_issue"));
							pstmt_insert.setString(++count, (String)hshTemp.get("howtotake"));
							pstmt_insert.setString(++count, (String)hshTemp.get("impnote"));
							pstmt_insert.setString(++count, (String)hshTemp.get("morning"));
							pstmt_insert.setString(++count, (String)hshTemp.get("afternoon"));
							pstmt_insert.setString(++count, (String)hshTemp.get("evening"));
							pstmt_insert.setString(++count, (String)hshTemp.get("night"));
							pstmt_insert.setString(++count, (String)hshTemp.get("curr_disp_yn"));
							pstmt_insert.setString(++count, (String)hshTemp.get("merge_yn"));
							pstmt_insert.setString(++count, (String)hshTemp.get("merged_med_plan_id"));
							pstmt_insert.setString(++count, (String)hshTemp.get("chkdrug"));
							pstmt_insert.setString(++count, (String)tabData.get("login_by_id"));
							pstmt_insert.setString(++count, (String)tabData.get("login_at_ws_no"));
							pstmt_insert.setString(++count, (String)tabData.get("facility_id"));				
							pstmt_insert.setString(++count, (String)tabData.get("login_by_id"));
							pstmt_insert.setString(++count, (String)tabData.get("login_at_ws_no"));
							pstmt_insert.setString(++count, (String)tabData.get("facility_id"));
							pstmt_insert.addBatch();
						}	
				   }
					else{// Reason : Insert 2 drugs in english , 2 drugs in local. Then uncheck 2 drugs from local, we have to update eff_status as D
						pstmt_update1.setString(1, (String)hshTemp.get("chkdrug"));			
						pstmt_update1.setString(2, (String)tabData.get("login_by_id"));
						pstmt_update1.setString(3, (String)tabData.get("login_at_ws_no"));
						pstmt_update1.setString(4, (String)tabData.get("facility_id"));
						pstmt_update1.setString(5, (String)tabData.get("patient_id"));
						pstmt_update1.setString(6, mediplan_seq_no);
						pstmt_update1.setString(7, strarrKey[0]);
						pstmt_update1.setString(8, strarrKey[1]);
						pstmt_update1.setString(9, strarrKey[3]);
						pstmt_update1.setString(10,strarrKey[2]);
						pstmt_update1.addBatch();
					}
				}
			}
			
			if(boolmedplanlocal){
				for(String key:hshlocalKeys){
					hshTemp = (HashMap)hshmedplanlocal.get(key);
					if(((String)hshTemp.get("plan_recorded")).equals("Y")){           
						count=0;
						strarrKey = key.split("_");
						ps	= connection.prepareStatement((String)sqlMap.get("SQL_PH_MEDICATION_PLAN_INSERT_CHECK"));
						ps.setString(1, mediplan_seq_no);
						ps.setString(2, strarrKey[3]);
						ps.setString(3, strarrKey[0]);
						ps.setString(4, strarrKey[1]);
						ps.setString(5, strarrKey[2]);
						rs = ps.executeQuery();
						if(rs.next())
							rowcount = rs.getInt(1);

						
						closeResultSet( rs ) ;//common-icn-0029
						closeStatement( ps ) ;//common-icn-0029
						if(rowcount>0){
							pstmt_update.setString(++count, disp_stage);
							pstmt_update.setString(++count, (String)hshTemp.get("qty_issuelocal"));
							pstmt_update.setString(++count, (String)hshTemp.get("howtotakelocal"));
							pstmt_update.setString(++count, (String)hshTemp.get("impnotelocal"));
							pstmt_update.setString(++count, (String)hshTemp.get("morninglocal"));
							pstmt_update.setString(++count, (String)hshTemp.get("afternoonlocal"));
							pstmt_update.setString(++count, (String)hshTemp.get("eveninglocal"));
							pstmt_update.setString(++count, (String)hshTemp.get("nightlocal"));
							pstmt_update.setString(++count, (String)hshTemp.get("chkdrug"));			
							pstmt_update.setString(++count, (String)tabData.get("login_by_id"));
							pstmt_update.setString(++count, (String)tabData.get("login_at_ws_no"));
							pstmt_update.setString(++count, (String)tabData.get("facility_id"));
							pstmt_update.setString(++count, (String)tabData.get("patient_id"));
							pstmt_update.setString(++count, mediplan_seq_no);
							pstmt_update.setString(++count, strarrKey[0]);
							pstmt_update.setString(++count, strarrKey[1]);
							pstmt_update.setString(++count, strarrKey[3]);
							pstmt_update.setString(++count, strarrKey[2]);
							pstmt_update.addBatch();
						}
						else{
							pstmt_insert.setString(++count, mediplan_seq_no);
							pstmt_insert.setString(++count, (String)hshTemp.get("lang_id"));
							pstmt_insert.setString(++count, (String)tabData.get("facility_id"));
							pstmt_insert.setString(++count, (String)tabData.get("disp_locn_code"));
							pstmt_insert.setString(++count, (String)tabData.get("patient_id"));
							pstmt_insert.setString(++count, (String)tabData.get("encounter_id"));
							pstmt_insert.setString(++count, disp_stage);
							pstmt_insert.setString(++count, (String)hshTemp.get("order_id")); 
							pstmt_insert.setString(++count, (String)hshTemp.get("order_line_no")); 
							pstmt_insert.setString(++count, (String)hshTemp.get("pres_drug_code"));
							pstmt_insert.setString(++count, (String)hshTemp.get("disp_no"));
							pstmt_insert.setString(++count, (String)hshTemp.get("disp_srl_no"));
							pstmt_insert.setString(++count, (String)hshTemp.get("disp_drug_code"));
							pstmt_insert.setString(++count, (String)hshTemp.get("qty_issuelocal"));
							pstmt_insert.setString(++count, (String)hshTemp.get("howtotakelocal"));
							pstmt_insert.setString(++count, (String)hshTemp.get("impnotelocal"));
							pstmt_insert.setString(++count, (String)hshTemp.get("morninglocal"));
							pstmt_insert.setString(++count, (String)hshTemp.get("afternoonlocal"));
							pstmt_insert.setString(++count, (String)hshTemp.get("eveninglocal"));
							pstmt_insert.setString(++count, (String)hshTemp.get("nightlocal"));
							pstmt_insert.setString(++count, (String)hshTemp.get("curr_disp_yn"));
							pstmt_insert.setString(++count, (String)hshTemp.get("merge_yn"));
							pstmt_insert.setString(++count, (String)hshTemp.get("merged_med_plan_id"));
							pstmt_insert.setString(++count, (String)hshTemp.get("chkdrug"));
							pstmt_insert.setString(++count, (String)tabData.get("login_by_id"));
							pstmt_insert.setString(++count, (String)tabData.get("login_at_ws_no"));
							pstmt_insert.setString(++count, (String)tabData.get("facility_id"));				
							pstmt_insert.setString(++count, (String)tabData.get("login_by_id"));
							pstmt_insert.setString(++count, (String)tabData.get("login_at_ws_no"));
							pstmt_insert.setString(++count, (String)tabData.get("facility_id"));
							pstmt_insert.addBatch();
						}	
				   }
					else{
						pstmt_update1.setString(1, (String)hshTemp.get("chkdrug"));			
						pstmt_update1.setString(2, (String)tabData.get("login_by_id"));
						pstmt_update1.setString(3, (String)tabData.get("login_at_ws_no"));
						pstmt_update1.setString(4, (String)tabData.get("facility_id"));
						pstmt_update1.setString(5, (String)tabData.get("patient_id"));
						pstmt_update1.setString(6, mediplan_seq_no);
						pstmt_update1.setString(7, strarrKey[0]);
						pstmt_update1.setString(8, strarrKey[1]);
						pstmt_update1.setString(9, strarrKey[3]);
						pstmt_update1.setString(10,strarrKey[2]);
						pstmt_update1.addBatch();
					}
				}
			}
			if(pstmt_update!=null){
				int[] result=pstmt_update.executeBatch();
				for (int k=0;k<result.length ;k++ ){
					if(result[k]<0  && result[k] != -2 ){
						pstmt_update.cancel();
						connection.rollback();
						throw new EJBException("Error: Update Medication Plan Failed");
					}		
				}
			}
			if(pstmt_insert!=null){
				int[] result1=pstmt_insert.executeBatch();
				for (int k=0;k<result1.length ;k++ ){
					if(result1[k]<0  && result1[k] != -2 ){
						pstmt_insert.cancel();
						connection.rollback();
						throw new EJBException("Error: Insert Medication Plan Failed");
					}		
				}
			}
			if(pstmt_update1!=null){
				int[] result=pstmt_update1.executeBatch();
				for (int k=0;k<result.length ;k++ ){
					if(result[k]<0  && result[k] != -2 ){
						pstmt_update1.cancel();
						connection.rollback();
						throw new EJBException("Error: Update1 Medication Plan Failed");
					}		
				}
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		} 
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeResultSet( rs ) ;
				closeStatement( pstmt_insert ) ;
				closeStatement( pstmt_update ) ;
				closeStatement( pstmt_update1 ) ;
				closeStatement( ps ) ;
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return mediplan_seq_no;
	}

	private void deleteMedicationPlan(Connection connection, HashMap sqlMap, HashMap tabData) throws Exception{
		PreparedStatement pstmt_delete=null ;
		StringBuilder sb=new StringBuilder();
		StringBuilder sbQuery=new StringBuilder("DELETE FROM PH_MEDICATION_PLAN WHERE MED_PLAN_ID IN (");
		try{
			ArrayList<String> arrMedPlanSeqNo	= (ArrayList)tabData.get("arrMedPlanSeqNo");
			for(String tmp: arrMedPlanSeqNo)
				sb.append("'"+tmp+"',");
			sbQuery.append(sb.substring(0, sb.length()-1)+")");
			HashMap hshmedplan = (HashMap)tabData.get("hshmedplan");
			HashMap hshmedplanlocal =  (HashMap)tabData.get("hshmedplanlocal");
			HashMap hshTemp = new HashMap();
			Set <String> hshKeys = new HashSet<String>();
			Set <String> hshlocalKeys = new HashSet<String>();
			hshKeys = hshmedplan.keySet();
			hshlocalKeys = hshmedplanlocal.keySet();
			sb=new StringBuilder();
			if((hshKeys!=null && hshKeys.size()>0)||(hshlocalKeys!=null && hshlocalKeys.size()>0)){
				for(String key:hshKeys){
					hshTemp = (HashMap)hshmedplan.get(key);
					if(((String)hshTemp.get("plan_recorded")).equals("Y"))
						sb.append("'"+(String)hshTemp.get("order_id")+"~"+(String)hshTemp.get("order_line_no")+"',");
				}
				for(String key:hshlocalKeys){
					hshTemp = (HashMap)hshmedplanlocal.get(key);
					if(((String)hshTemp.get("plan_recorded")).equals("Y"))
						sb.append("'"+(String)hshTemp.get("order_id")+"~"+(String)hshTemp.get("order_line_no")+"',");
				}
				sbQuery.append("AND ORDER_ID ||'~'||ORDER_LINE_NUM IN ("+sb.substring(0, sb.length()-1)+")");
			}
			pstmt_delete	= connection.prepareStatement(sbQuery.toString()); 
			pstmt_delete.executeUpdate();
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		} 
		finally {
			try{
				closeStatement( pstmt_delete ) ;
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
	}

	private void insertUpdateDispLabelDtl(Connection connection, HashMap sqlMap, HashMap tabData,ArrayList dispTMP) throws Exception { // Added for Bru-HIMS-CRF-414 [IN:045554]
		PreparedStatement pstmt_disp_label_select_disp_dtl	= null;
		PreparedStatement pstmt_disp_label_select_count	= null;
		PreparedStatement pstmtDispLabelInsert	= null;
		PreparedStatement pstmtDispLabelUpdate	= null;
		ResultSet rsDispDtl	= null, rsLablCount=null ;
		int iLblCount	=	0;
		//String editableLabelLangId	= tabData.get("editableLabelLangId")!=null?(String)tabData.get("editableLabelLangId"):"en"; //Commented for COMMON-ICN-0048
		HashMap editableLabel			= tabData.get("editableLabel")!=null?(HashMap)tabData.get("editableLabel"):null;
		ArrayList alLabelDtl = null;
		String disp_no="", disp_srl_no="", sKey1="", dispQty="";
		try {
			pstmt_disp_label_select_disp_dtl	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_LABEL_SELECT_DISP_DTL") ) ;
			pstmt_disp_label_select_count	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_LABEL_SELECT_COUNT") ) ;
			pstmtDispLabelInsert	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_LABEL_INSERT") ) ;
			pstmtDispLabelUpdate	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_LABEL_UPDATE") ) ;
			int insertCount = 0, updateCount=0, icount=1;
			if(dispTMP==null || dispTMP.size() ==0){
				if(editableLabel!=null && editableLabel.size()>0){
					Iterator itrEditLabelKeys = editableLabel.keySet().iterator();
					String sOrderId="", Drug_code="",  sOrderLineNo="", lblLangId="";
					boolean insert_flag = false;//added for ML-BRU-SCF-2034
					while(itrEditLabelKeys.hasNext()){
						icount=1;
						iLblCount	=	0;//added for ML-BRU-SCF-2034
						insert_flag = false; //added for ML-BRU-SCF-2034
						sKey1 = (String)itrEditLabelKeys.next();
						alLabelDtl =(ArrayList)editableLabel.get(sKey1);
						if(sKey1!=null && (sKey1.split("_")).length>0 && sKey1.split("_")[0] != null){
							sOrderId	 = sKey1.split("_")[0];
							Drug_code    = sKey1.split("_")[1];
							sOrderLineNo = sKey1.split("_")[2];
							lblLangId = sKey1.split("_")[3];
						}
						pstmt_disp_label_select_disp_dtl.setString(icount++, (String)tabData.get("facility_id"));
						pstmt_disp_label_select_disp_dtl.setString(icount++, sOrderId);
						pstmt_disp_label_select_disp_dtl.setString(icount++, sOrderLineNo);
						pstmt_disp_label_select_disp_dtl.setString(icount++, Drug_code);
						rsDispDtl = pstmt_disp_label_select_disp_dtl.executeQuery();
						if(rsDispDtl!=null && rsDispDtl.next()){
							
							insert_flag = true; //ML-BRU-SCF-2034
							disp_no = rsDispDtl.getString("DISP_NO");
							disp_srl_no = rsDispDtl.getString("SRL_NO");
							pstmt_disp_label_select_count.setString(1,(String)tabData.get("facility_id"));
							pstmt_disp_label_select_count.setString(2, disp_no);
							pstmt_disp_label_select_count.setString(3, disp_srl_no);
							pstmt_disp_label_select_count.setString(4, lblLangId);
							rsLablCount = pstmt_disp_label_select_count.executeQuery();
							if(rsLablCount!=null && rsLablCount.next()){
								iLblCount = rsLablCount.getInt("LBLCOUNT");
							}
						}
						closeResultSet( rsLablCount ) ;
						if(alLabelDtl!=null && alLabelDtl.size()>0){
							icount=1;
							if(iLblCount>0){
								pstmtDispLabelUpdate.setString(icount++,(String)alLabelDtl.get(1));
								pstmtDispLabelUpdate.setString(icount++,(String)alLabelDtl.get(2));
								//pstmtDispLabelUpdate.setString(icount++,(String)alLabelDtl.get(3));
								pstmtDispLabelUpdate.setString(icount++,(String)alLabelDtl.get(4));
								pstmtDispLabelUpdate.setString(icount++,(String)alLabelDtl.get(5));
								pstmtDispLabelUpdate.setString(icount++,(String)alLabelDtl.get(6));
								pstmtDispLabelUpdate.setString(icount++,(String)tabData.get("login_by_id"));
								pstmtDispLabelUpdate.setString(icount++,(String)tabData.get("login_at_ws_no"));
								pstmtDispLabelUpdate.setString(icount++,(String)tabData.get("facility_id"));
								pstmtDispLabelUpdate.setString(icount++,(String)tabData.get("facility_id"));
								pstmtDispLabelUpdate.setString(icount++, disp_no);
								pstmtDispLabelUpdate.setString(icount++, disp_srl_no);
								pstmtDispLabelUpdate.setString(icount++, lblLangId);
								pstmtDispLabelUpdate.addBatch();
								updateCount++;
							}
							else{
								if(insert_flag){ //added for ML-BRU-SCF-2034
								pstmtDispLabelInsert.setString(icount++,(String)tabData.get("facility_id"));
								pstmtDispLabelInsert.setString(icount++, disp_no);
								pstmtDispLabelInsert.setString(icount++, disp_srl_no);
								pstmtDispLabelInsert.setString(icount++,lblLangId);
								pstmtDispLabelInsert.setString(icount++,(String)alLabelDtl.get(0));
								pstmtDispLabelInsert.setString(icount++,(String)alLabelDtl.get(1));
								pstmtDispLabelInsert.setString(icount++,(String)alLabelDtl.get(2));
								pstmtDispLabelInsert.setString(icount++,(String)alLabelDtl.get(3));
								pstmtDispLabelInsert.setString(icount++,(String)alLabelDtl.get(4));
								pstmtDispLabelInsert.setString(icount++,(String)alLabelDtl.get(5));
								pstmtDispLabelInsert.setString(icount++,(String)alLabelDtl.get(6));
								pstmtDispLabelInsert.setString(icount++,(String)tabData.get("login_by_id"));
								pstmtDispLabelInsert.setString(icount++,(String)tabData.get("login_at_ws_no"));
								pstmtDispLabelInsert.setString(icount++,(String)tabData.get("facility_id"));
								pstmtDispLabelInsert.setString(icount++,(String)tabData.get("login_by_id"));
								pstmtDispLabelInsert.setString(icount++,(String)tabData.get("login_at_ws_no"));
								pstmtDispLabelInsert.setString(icount++,(String)tabData.get("facility_id"));
								pstmtDispLabelInsert.addBatch();
								insertCount++;
								}
							}
						}
					}
				}
			}
			else{
				List lEditLabelKeys = null;
				String strLblTempKey="", strLabelLangTmp="";
				for(int i=0;i<dispTMP.size();i=i+7){
					//sKey1 =	((String)dispTMP.get(i)).trim()+"_"+((String)dispTMP.get(i+3)).trim()+"_"+((String)dispTMP.get(i+1)).trim()+"_"+editableLabelLangId;
					sKey1 =	((String)dispTMP.get(i)).trim()+"_"+((String)dispTMP.get(i+3)).trim()+"_"+((String)dispTMP.get(i+1)).trim();
					lEditLabelKeys = new ArrayList(editableLabel.keySet());
					for(int ilcount=0; ilcount<lEditLabelKeys.size(); ilcount++){
						strLblTempKey= (String)lEditLabelKeys.get(ilcount);
						strLabelLangTmp = strLblTempKey.substring(strLblTempKey.lastIndexOf("_")+1);
						if((strLblTempKey.substring(0,strLblTempKey.lastIndexOf("_"))).equals(sKey1)){
							iLblCount	=	0;
							icount=1;
							if(editableLabel.containsKey(strLblTempKey)){
								alLabelDtl =(ArrayList)editableLabel.get(strLblTempKey);
								pstmt_disp_label_select_disp_dtl.setString(icount++, (String)tabData.get("facility_id"));
								pstmt_disp_label_select_disp_dtl.setString(icount++, ((String)dispTMP.get(i)).trim());
								pstmt_disp_label_select_disp_dtl.setString(icount++,((String)dispTMP.get(i+1)).trim());
								pstmt_disp_label_select_disp_dtl.setString(icount++,((String)dispTMP.get(i+3)).trim());
								rsDispDtl = pstmt_disp_label_select_disp_dtl.executeQuery();
								if(rsDispDtl!=null && rsDispDtl.next()){
									disp_no = rsDispDtl.getString("DISP_NO");
									disp_srl_no = rsDispDtl.getString("SRL_NO");
									pstmt_disp_label_select_count.setString(1,(String)tabData.get("facility_id"));
									pstmt_disp_label_select_count.setString(2, disp_no);
									pstmt_disp_label_select_count.setString(3, disp_srl_no);
									pstmt_disp_label_select_count.setString(4,strLabelLangTmp);
									rsLablCount = pstmt_disp_label_select_count.executeQuery();
									if(rsLablCount!=null && rsLablCount.next()){
										iLblCount = rsLablCount.getInt("LBLCOUNT");
									}
								}
								closeResultSet( rsDispDtl ) ;
								closeResultSet( rsLablCount ) ;
								if(alLabelDtl!=null && alLabelDtl.size()>0){
									dispQty = alLabelDtl.get(2)==null?"":(String)alLabelDtl.get(2);
									if(dispQty.equals(""))
										dispQty = ((String)dispTMP.get(i+4)).trim();
									if(iLblCount>0){
										icount=1;
										pstmtDispLabelUpdate.setString(icount++,(String)alLabelDtl.get(1));
										pstmtDispLabelUpdate.setString(icount++, dispQty);
										//pstmtDispLabelUpdate.setString(icount++,(String)alLabelDtl.get(3));
										pstmtDispLabelUpdate.setString(icount++,(String)alLabelDtl.get(4));
										pstmtDispLabelUpdate.setString(icount++,(String)alLabelDtl.get(5));
										pstmtDispLabelUpdate.setString(icount++,(String)alLabelDtl.get(6));
										pstmtDispLabelUpdate.setString(icount++,(String)tabData.get("login_by_id"));
										pstmtDispLabelUpdate.setString(icount++,(String)tabData.get("login_at_ws_no"));
										pstmtDispLabelUpdate.setString(icount++,(String)tabData.get("facility_id"));
										pstmtDispLabelUpdate.setString(icount++,(String)tabData.get("facility_id"));
										pstmtDispLabelUpdate.setString(icount++, disp_no);
										pstmtDispLabelUpdate.setString(icount++, disp_srl_no);
										pstmtDispLabelUpdate.setString(icount++,strLabelLangTmp);
										pstmtDispLabelUpdate.addBatch();
										updateCount++;
									}
									else{
										icount=1;
										pstmtDispLabelInsert.setString(icount++,(String)tabData.get("facility_id"));
										pstmtDispLabelInsert.setString(icount++, disp_no);
										pstmtDispLabelInsert.setString(icount++, disp_srl_no);
										pstmtDispLabelInsert.setString(icount++,strLabelLangTmp);
										pstmtDispLabelInsert.setString(icount++,(String)alLabelDtl.get(0));
										pstmtDispLabelInsert.setString(icount++,(String)alLabelDtl.get(1));
										pstmtDispLabelInsert.setString(icount++, dispQty);
										pstmtDispLabelInsert.setString(icount++,((String)dispTMP.get(i+5)).trim());//(String)alLabelDtl.get(3)
										pstmtDispLabelInsert.setString(icount++,(String)alLabelDtl.get(4));
										pstmtDispLabelInsert.setString(icount++,(String)alLabelDtl.get(5));
										pstmtDispLabelInsert.setString(icount++,(String)alLabelDtl.get(6));
										pstmtDispLabelInsert.setString(icount++,(String)tabData.get("login_by_id"));
										pstmtDispLabelInsert.setString(icount++,(String)tabData.get("login_at_ws_no"));
										pstmtDispLabelInsert.setString(icount++,(String)tabData.get("facility_id"));
										pstmtDispLabelInsert.setString(icount++,(String)tabData.get("login_by_id"));
										pstmtDispLabelInsert.setString(icount++,(String)tabData.get("login_at_ws_no"));
										pstmtDispLabelInsert.setString(icount++,(String)tabData.get("facility_id"));
										pstmtDispLabelInsert.addBatch();
										insertCount++;
									}
								}
							}
						}
					}
				}
			}
			if(insertCount>0){
				int[] resultInsert=pstmtDispLabelInsert.executeBatch();
				for (int k=0;k<resultInsert.length ;k++ ){
					if(resultInsert[k]<0  && resultInsert[k] != -2 ){
						pstmtDispLabelInsert.cancel();
						connection.rollback();
						throw new EJBException("Insert Dispense Label failed");
					}		
				}
			}
			if(updateCount>0){
				int[] resultUpdate=pstmtDispLabelUpdate.executeBatch();
				for (int k=0;k<resultUpdate.length ;k++ ){
					if(resultUpdate[k]<0  && resultUpdate[k] != -2 ){
						pstmtDispLabelUpdate.cancel();
						connection.rollback();
						throw new EJBException("Update Dispense Label failed");
					}		
				}
			}
		}
		catch(Exception e){
			System.err.println("Dispense Label FAILED tabData="+tabData);
			System.err.println("Dispense Label FAILED tabData="+tabData);
			e.printStackTrace();
			throw new EJBException("Error: Insert/Update Dispense Label FAILED");
		}
		finally{	
			try {
				closeResultSet( rsDispDtl ) ;
				closeResultSet( rsLablCount ) ;
				closeStatement( pstmt_disp_label_select_disp_dtl ) ;
				closeStatement( pstmt_disp_label_select_count ) ;
				closeStatement( pstmtDispLabelInsert ) ;
				closeStatement( pstmtDispLabelUpdate ) ;
			}
			catch(Exception es) { 
				es.printStackTrace();
				throw es;
			}
		}
	}

	private ArrayList updateMediPlan_DispStage(Connection connection, HashMap sqlMap, HashMap tabData) throws Exception{
		PreparedStatement pstmt_update=null,pstmt=null;
		ResultSet rs		= null ;
		int count=0;
		String disp_no="",disp_srl_no="",mediplan_seq_no="";
		//String strarrKey[] = new String[4]; Unused local variable INC63877
		ArrayList<String> arrmediplan_seq_no = new ArrayList<String>();//Added for Bru-HIMS-CRF-072.1[IN 051382]
		try{
			ArrayList<String> dispTMP = (ArrayList)tabData.get("dispTMP");
			String disp_stage=(String)tabData.get("disp_stage");
			//String valuesChanged = (String)tabData.get("ValuesChanged")==null?"":(String)tabData.get("ValuesChanged"); //Commented for COMMON-ICN-0048 
			if(disp_stage.equals("AS"))
				disp_stage="D";
			for(int i=0;i<dispTMP.size();i=i+7){
				pstmt	   = connection.prepareStatement("SELECT DISP_TMP_NO,DTL_SERIAL_NUM FROM PH_DISP_DTL_TMP WHERE ORDER_ID ||'_'||ORDER_LINE_NO IN('"+dispTMP.get(i)+"_"+dispTMP.get(i+1)+"')");
				rs = pstmt.executeQuery();
				if(rs.next()){
					disp_no = rs.getString("DISP_TMP_NO");
					disp_srl_no = rs.getString("DTL_SERIAL_NUM");
					
					closeResultSet( rs ); //common-icn-0029
					closeStatement( pstmt ) ; //common-icn-0029
					
					
					pstmt	   = connection.prepareStatement("SELECT MED_PLAN_ID FROM PH_MEDICATION_PLAN WHERE DISP_NO ||'_'||DISP_SRL_NO IN('"+disp_no+"_"+disp_srl_no+"') AND FACILITY_ID=?");
					pstmt.setString(1, (String)tabData.get("facility_id"));
					rs = pstmt.executeQuery();
					if(rs.next()){
						mediplan_seq_no = rs.getString("MED_PLAN_ID");
						if(mediplan_seq_no!=""){
							if(!arrmediplan_seq_no.contains(mediplan_seq_no))//Added for Bru-HIMS-CRF-072.1[IN 051382]
								arrmediplan_seq_no.add(mediplan_seq_no);
							
						  closeResultSet( rs ); //common-icn-0029
						  closeStatement( pstmt ) ; //common-icn-0029
		   				  

							pstmt = connection.prepareStatement( (String)sqlMap.get("SQL_PH_MED_PLAN_SELECT_CURR_DRUG") ) ;
							pstmt.setString(1,mediplan_seq_no);
							pstmt.setString(2,disp_no);	
							pstmt.setString(3,disp_srl_no);
							rs	=	pstmt.executeQuery();
							if ( rs.next() ) {
								count = rs.getInt("COUNT");
							}
							if(count==0){
								pstmt_update	= connection.prepareStatement((String)sqlMap.get("SQL_PH_MEDICATION_PLAN_UPDATE3"));
								pstmt_update.setString(1, disp_stage);
								pstmt_update.setString(2, (String)tabData.get("login_by_id"));
								pstmt_update.setString(3, (String)tabData.get("login_at_ws_no"));
								pstmt_update.setString(4, (String)tabData.get("facility_id"));
								pstmt_update.setString(5, mediplan_seq_no);
								pstmt_update.executeUpdate();
							}
							else{
								pstmt_update	= connection.prepareStatement((String)sqlMap.get("SQL_PH_MEDICATION_PLAN_UPDATE2"));
								pstmt_update.setString(1, disp_stage);
								pstmt_update.setString(2, (String)tabData.get("login_by_id"));
								pstmt_update.setString(3, (String)tabData.get("login_at_ws_no"));
								pstmt_update.setString(4, (String)tabData.get("facility_id"));
								pstmt_update.setString(5, mediplan_seq_no);
								pstmt_update.setString(6, disp_no);
								pstmt_update.setString(7, disp_srl_no);
								pstmt_update.setString(8, dispTMP.get(i+3));
								pstmt_update.executeUpdate(); //common-icn-0029
							}
							closeStatement( pstmt_update ) ;//common-icn-0029
							closeResultSet( rs );//3/21/2021
							closeStatement( pstmt );//3/21/2021
						}
					}
				}
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		} 
		finally {
			try{
				closeStatement( pstmt_update ) ;
				closeStatement( pstmt ) ;
				closeResultSet( rs );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return arrmediplan_seq_no;//Added for Bru-HIMS-CRF-072.1[IN 051382]
	}
	
	private void updateMedPlanDispNo(Connection connection, HashMap sqlMap, HashMap tabData,ArrayList dispTMP) throws Exception{
		PreparedStatement pstmt = connection.prepareStatement("UPDATE PH_MEDICATION_PLAN SET DISP_NO=?,DISP_SRL_NO=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? WHERE FACILITY_ID=? AND DISP_NO=? AND DISP_SRL_NO=? AND ORDER_ID=? AND ORDER_LINE_NUM=?");
		try{
			HashMap hshDispNoOld = (HashMap)tabData.get("hshdispno_old");
			HashMap hshDispNoNew = (HashMap)tabData.get("hshdispno_new");
			String order_id="",order_line_no="",dispno_new="",dispsrlno_new="",dispno_old="",dispsrlno_old="",temp="";
			int index=0;
			if(hshDispNoOld.size()>0 && hshDispNoNew.size()>0)
			for(int i=0;i<dispTMP.size();i=i+7){
				order_id = (String)dispTMP.get(i);
				order_line_no = (String)dispTMP.get(i+1);
				temp = (String)hshDispNoOld.get(order_id+"~"+order_line_no);
				dispno_old = temp.substring(0, temp.indexOf("~"));
				dispsrlno_old = temp.substring(temp.indexOf("~")+1);
				temp = (String)hshDispNoNew.get(order_id+order_line_no);
				dispno_new = temp.substring(0, temp.indexOf("~"));
				dispsrlno_new = temp.substring(temp.indexOf("~")+1);
				pstmt.setString(++index, dispno_new);	
				pstmt.setString(++index, dispsrlno_new);
				pstmt.setString(++index, (String)tabData.get("login_by_id"));
				pstmt.setString(++index, (String)tabData.get("login_at_ws_no"));
				pstmt.setString(++index, (String)tabData.get("facility_id"));
				pstmt.setString(++index, (String)tabData.get("facility_id"));
				pstmt.setString(++index, dispno_old);
				pstmt.setString(++index, dispsrlno_old);
				pstmt.setString(++index, order_id);
				pstmt.setString(++index, order_line_no);
				pstmt.executeUpdate();
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		} 
		finally {
			try{
				closeStatement( pstmt ) ;
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
	}	

//added for GHL-CRF-453
	public void updatePrintValue(HashMap tabData,HashMap sqlMap){
		Connection oConnection					= null ;
		PreparedStatement oPreparedStatement	= null;
		try{
			prop		= (Properties)tabData.get("properties");	
			oConnection	= getConnection( prop ) ;
			
			ArrayList alOrderIds =(ArrayList)tabData.get("alOrderIds");
			System.err.println("alOrderIds==========9947====>"+alOrderIds);
			oPreparedStatement = oConnection.prepareStatement((String)sqlMap.get("SQL_ORDER_LINE_PH_PRINT_YN_UPDATE"));
			if(alOrderIds.size()>0)	{
				for(int i=0;i<alOrderIds.size();i=i+3){
					

					oPreparedStatement.setString(1,"1");
					oPreparedStatement.setString(2,(String)tabData.get("login_by_id"));
					oPreparedStatement.setString(3,(String)tabData.get("facility_id"));
					oPreparedStatement.setString(4,(String)tabData.get("login_at_ws_no"));
					oPreparedStatement.setString(5,(String)alOrderIds.get(i));
					oPreparedStatement.setString(6,(String)alOrderIds.get(i+1));
					oPreparedStatement.addBatch();
				}
				int result[] = oPreparedStatement.executeBatch();
				boolean	bFlag	= true;

				for (int i=0;i<result.length ;i++ ){
					if(result[i]<0  && result[i] != -2 ){
						bFlag	= false;
					}		
				}
				if(bFlag)
					oConnection.commit();
				else
					oConnection.rollback();					
			}
		}
		catch (Exception e)	{
			System.err.println("<<< Print_yn  updateException "+ tabData );
			e.printStackTrace();
			try{
				oConnection.rollback();	
			}
			catch (SQLException sqlE){}
		}
		finally{
			try{
				closeStatement (oPreparedStatement);
				oPreparedStatement	=null;
				closeConnection( oConnection,prop );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
	}
	public void getDocSrlNo(Connection connection,String doc_no,String doc_type){
		PreparedStatement pstmt_disp_hdr_docno = null;
		ResultSet  resultSet = null;
		String tmp_srl_no = "";
		String bl_doc_no= "";
		String bl_doc_type_code = "";
		String bl_doc_key = "";
		String bl_doc_srl_no = "";
	try{
					pstmt_disp_hdr_docno	=	connection.prepareStatement( "SELECT DOC_SRL_NO FROM  PH_DISP_HDR a, PH_DISP_dtl  b  WHERE b.order_id = a.order_id and a.disp_no = b.disp_no and a.doc_no=? and doc_type=? ") ;
					pstmt_disp_hdr_docno.setString(1,doc_no.trim());
					pstmt_disp_hdr_docno.setString(2,doc_type.trim());
					resultSet	=	pstmt_disp_hdr_docno.executeQuery();
						while(resultSet!=null && resultSet.next()){
						System.err.println("DispMedicationManager.java====doc_srl_no==3419======>"+resultSet.getString("DOC_SRL_NO"));
							if(resultSet.getString("DOC_SRL_NO")!=null && !(resultSet.getString("DOC_SRL_NO").equals(""))){
								tmp_srl_no			=	resultSet.getString("DOC_SRL_NO");
								bl_doc_type_code =doc_type;
									bl_doc_no =doc_no;
									bl_doc_key = bl_doc_type_code +"-"+bl_doc_no;
									if(hmBLDocSrlNo.containsKey(bl_doc_key)){
										bl_doc_srl_no = (String) hmBLDocSrlNo.get(bl_doc_key);
										if(!bl_doc_srl_no.equals(""))
											bl_doc_srl_no+=","+tmp_srl_no;
									}
									else
										bl_doc_srl_no = tmp_srl_no;
									hmBLDocSrlNo.put(bl_doc_key , bl_doc_srl_no);
							}
						}
	}catch(Exception e){
	}	finally{
			try{
				closeStatement (pstmt_disp_hdr_docno);
				pstmt_disp_hdr_docno	=null;
			}
			catch(Exception es){
				es.printStackTrace();
			}
}  
	}

		//added for SKR-SCF-1239 - start
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
			closeResultSet(resultSet1); //Common-ICN-0090
			if(patient_class.equals("I"))
				patient_class = "IP";
			
			if(take_home.equals("")) //Added for SKR-SCF-1614
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
				closeResultSet(resultSet1);
				closeStatement(pstmt_select);
				closeStatement(pstmt_select1);
				
			}
			catch(Exception es) {
				es.printStackTrace() ;
			}
		}
		return perf_deptloc_code;
	}

private void updateOrOrdersLocn(Connection connection,ArrayList orderLineData,String patient_id,String encounter_id,String locn_code,String patient_class,String login_facility_id,String language_id) throws Exception {
		PreparedStatement pstmt_update	=	null;
		String order_id = "";
		String disp_locn_code = "";
		boolean flag = false;

		try{
			pstmt_update	= connection.prepareStatement("UPDATE OR_ORDER SET SOURCE_CODE =?,PERFORMING_DEPTLOC_CODE = ? WHERE ORDER_ID = ?") ;
			for(int i=0;i<orderLineData.size();i=i+6){	
				 if(!((String)orderLineData.get(i)).equals("NN")&& ((String)orderLineData.get(i+5)).equals("N")) { 
					order_id = ((String)orderLineData.get(i+3)).trim();
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
				}
			}
			if(flag){
				pstmt_update.executeBatch();
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

	//added for SKR-SCF-1239 - end
//Adding end for MMS-DM-CRF-0157.1
	public void insertBarcodeScanCount(Connection connection,HashMap tabData){
		ArrayList barcode_remarks =new ArrayList();//Added for MMS-DM-CRF-0157.1
            CallableStatement cs = null;	//Added for MMS-Dm-CRF-0157.1
			HashMap batch_wise_remarks =new HashMap();
			String error_text ="";
     try{
          barcode_remarks= (ArrayList)tabData.get("barcode_remarks");
		  System.err.println("barcode_remarks@@@ Manager==="+barcode_remarks);
		   cs = connection.prepareCall("{call PR_INS_PR_BARCODE_SCAN_DETAILS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,sysdate,?,?,?,sysdate,?,?,?) }");
		  if(barcode_remarks.size()>0){
		  for(int i=0;i<barcode_remarks.size();i++){
                batch_wise_remarks = (HashMap)barcode_remarks.get(i);
				System.err.println("batch_wise_remarks @@@ Manager==="+batch_wise_remarks);

                 	cs.setString(1,((String)tabData.get("facility_id")));
	                cs.setString(2,((String)batch_wise_remarks.get("module_id")));
	                cs.setString(3,((String)batch_wise_remarks.get("menu_id")));
	                cs.setString(4,((String)batch_wise_remarks.get("sub_menu_id")));
	                cs.setString(5,((String)batch_wise_remarks.get("patient_id")));
	                cs.setString(6,((String)batch_wise_remarks.get("encounter_id")));
	                cs.setString(7,"");
                    cs.setString(8,((String)batch_wise_remarks.get("patient_class")));
                    cs.setString(9,((String)batch_wise_remarks.get("order_id")));
                    cs.setString(10,((String)batch_wise_remarks.get("order_line_no")));
	                cs.setString(11,((String)batch_wise_remarks.get("item_code")));
	                cs.setString(12,((String)batch_wise_remarks.get("batch_id")));
	                cs.setString(13,"");
	                cs.setString(14,"");
	                cs.setString(15,((String)batch_wise_remarks.get("entry_type")));
	                cs.setString(16,((String)batch_wise_remarks.get("resone_code")));
	                cs.setString(17,((String)batch_wise_remarks.get("resone_desc")));
	                cs.setString(18,((String)tabData.get("login_by_id")));
	                cs.setString(19,((String)tabData.get("login_at_ws_no")));
	                cs.setString(20,((String)tabData.get("facility_id")));
	                cs.setString(21,((String)tabData.get("login_by_id")));
	                cs.setString(22,((String)tabData.get("login_at_ws_no")));
	                cs.setString(23,((String)tabData.get("facility_id")));
	                cs.registerOutParameter(24,java.sql.Types.VARCHAR);
					
	                cs.execute();
					error_text		= cs.getString(24);
			//		System.err.println("error_text@@@@==="+error_text+"order_id==="+(String)batch_wise_remarks.get("order_id")+"order_line_no==="+(String)batch_wise_remarks.get("order_line_no"));

		  }

		 }

	}catch(Exception e){
	   }	finally{
		    	try{
				  closeStatement (cs);
			   }
			      catch(Exception es){
				  es.printStackTrace();
			}
	   }
	
  }//Adding end for MMS-DM-crf-0157.1
	//MOHE-CRF-0026.1
	private ArrayList setBillingInterfaceDetails(Connection connection, HashMap sqlMap, HashMap tabData, String postAuthStatusData ) throws Exception{
	
		ArrayList arrlistData = new ArrayList(); 
		PreparedStatement pstmt			=	null;
		ResultSet resultSet								=	null; 
	
		String order_id=""; 
		String order_line_no="";
		String item_code ="";
		String p_auth_status = ""; 
		String p_approval_no = ""; 
		//String approval_given_date = "";  //Commented for COMMON-ICN-0048
		String item_approved_qty = "";
		String p_item_approved_amt = ""; 
		String docSrlNo= ""; 
		
		
		try{
			if(postAuthStatusData.contains("#")){
				String[] arrSplit1 = postAuthStatusData.split("#");  
		
				for(int i=0;i<arrSplit1.length;i++){
					String[] arrSplit2 = arrSplit1[i].split("~"); 
					order_id = arrSplit2[2];
					order_line_no = arrSplit2[4];
					item_code = arrSplit2[5];
					p_auth_status = arrSplit2[12];
					if(p_auth_status.equals("E")){
						p_approval_no = "";
						item_approved_qty = "0";
						p_item_approved_amt = "0";
					}else{
						p_approval_no = arrSplit2[13];
						item_approved_qty = arrSplit2[7];
						p_item_approved_amt = arrSplit2[15];
					}//END 
					
					pstmt		=	connection.prepareStatement( "SELECT DOC_SRL_NO FROM  PH_DISP_HDR_TMP a, PH_DISP_dtl_TMP  b  WHERE b.order_id = a.order_id and a.DISP_TMP_NO = b.DISP_TMP_NO and a.ORDER_ID= ? and DISP_DRUG_CODE = ? and ORDER_LINE_NO = ? " );
					pstmt.setString(1,order_id); 
					pstmt.setString(2,item_code);    
					pstmt.setString(3,order_line_no);    			
					resultSet	=	pstmt.executeQuery();
					if(resultSet!=null && resultSet.next()){
						docSrlNo = ((String)resultSet.getString("DOC_SRL_NO"));  
					}
				
					arrlistData.add(order_id);
					arrlistData.add(order_line_no);
					arrlistData.add(item_code);
					arrlistData.add(p_auth_status);
					arrlistData.add(p_approval_no);
					arrlistData.add(item_approved_qty);
					arrlistData.add(p_item_approved_amt); 
					arrlistData.add(docSrlNo); 
					
					closeResultSet(resultSet);	 //Common-ICN-0090
					closeStatement(pstmt); 	//Common-ICN-0090
 
				}
			}else{
				String[] arrSplit = postAuthStatusData.split("~");  								
				order_id = arrSplit[2];
				order_line_no = arrSplit[4];
				item_code = arrSplit[5];
				p_auth_status = arrSplit[12];
				if(p_auth_status.equals("E")){
					p_approval_no = "";
					item_approved_qty = "0";
					p_item_approved_amt = "0";
				}else{
				p_approval_no = arrSplit[13];
				item_approved_qty = arrSplit[7];
					p_item_approved_amt = arrSplit[15];
				}//END 
				pstmt		=	connection.prepareStatement( "SELECT DOC_SRL_NO FROM  PH_DISP_HDR_TMP a, PH_DISP_dtl_TMP  b  WHERE b.order_id = a.order_id and a.DISP_TMP_NO = b.DISP_TMP_NO and a.ORDER_ID= ? and DISP_DRUG_CODE = ? and ORDER_LINE_NO = ? " );
				pstmt.setString(1,order_id); 
				pstmt.setString(2,item_code);    
				pstmt.setString(3,order_line_no);    			
				resultSet	=	pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
					docSrlNo = ((String)resultSet.getString("DOC_SRL_NO"));  
				}

				arrlistData.add(order_id);
				arrlistData.add(order_line_no);
				arrlistData.add(item_code);
				arrlistData.add(p_auth_status);
				arrlistData.add(p_approval_no);
				arrlistData.add(item_approved_qty);
				arrlistData.add(p_item_approved_amt); 
				arrlistData.add(docSrlNo); 
				closeResultSet(resultSet);	 //Common-ICN-0090
				closeStatement(pstmt); 	//Common-ICN-0090
 
			}
		}
		catch(Exception e){
			System.err.println(" tabData="+tabData);
			e.printStackTrace();
			}
		finally{	
			try {
				closeResultSet(resultSet);	
				closeStatement(pstmt);  
			}
			
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
		return arrlistData; 
	}
	//MOHE-CRF-0026.1 
	private void getBillingInsuranceDetails(Connection connection, HashMap sqlMap, HashMap tabData , String bl_doc_type_code,String bl_doc_no,ArrayList arrlistData) throws Exception{
		prop = (Properties)tabData.get( "properties" );	 
		//String disp_stage           = (String)tabData.get("disp_stage");   //commented for COMMON-ICN-00048
		String patient_id				=	(String)tabData.get("patient_id");

		 String session_id =getSessionId(prop); 
		String encounter_id= (String)tabData.get("encounter_id");
		String sal_trn_type = (String)tabData.get("patient_class"); 
		PreparedStatement pstmt			=	null;
		ResultSet resultSet								=	null; 
		/*String doc_srl_no= "";  //Commented for COMMON-ICN-0048 -START
		String order_id=""; 
		String order_line_no="";   
		String item_code ="";
		String p_auth_status = ""; 
		String p_approval_no = ""; 
		String approval_given_date = ""; 
		String item_approved_qty = "";
		String p_item_approved_amt = ""; */ //Commented for COMMON-ICN-0048 -END
		String module_id = "PH"; 
		//String docSrlNo = ""; //Commented for COMMON-ICN-0048
		CallableStatement callableStatement = null;
		String transactionStatus = ""; 
		String msgId = "";
		String msgTxt = ""; 

		try {
			 
			
				for(int i=0;i<arrlistData.size();i=i+8){

					String orderId = (String) arrlistData.get(i);
					String itemCode = (String) arrlistData.get(i+2); 
					String orderLineNo = (String) arrlistData.get(i+1);  
					String AuthStatus =  (String) arrlistData.get(i+3);  
					String approvalNo =  (String) arrlistData.get(i+4); 
					String approvedQty = (String) arrlistData.get(i+5);
					String approvedAmt = (String) arrlistData.get(i+6);
					String docSerialNo = (String) arrlistData.get(i+7);
										
					  if(approvedQty.contains(".")){
						  double d = Double.parseDouble(approvedQty); 
						  int appQty = (int) d;
						  approvedQty = Integer.toString(appQty);  
					  }
					 /* if(approvedAmt.contains(".")){
						  double d = Double.parseDouble(approvedAmt); 
						  int appAmt = (int) d;
						  approvedAmt = Integer.toString(appAmt);  
					  }*/
					 callableStatement	= connection.prepareCall("{ call bl_record_approval.process_record_appr_ph (?,SYSDATE,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");//MOHE-CRF-0026.1 START
					  callableStatement.setString(1, session_id); 
					//  callableStatement.setDate(2, new java.sql.Date(System.currentTimeMillis()));
					  callableStatement.setString(2,(String)tabData.get("ordering_facility_id") );  
					  callableStatement.setString(3, module_id);  
					  callableStatement.setString(4, patient_id);
					  callableStatement.setString(5, encounter_id); 
					  callableStatement.setString(6, sal_trn_type );
					  callableStatement.setString(7,bl_doc_type_code );
					  callableStatement.setInt(8,Integer.parseInt(bl_doc_no));	
					  if(docSerialNo==null || docSerialNo.equals("")){
						  int intDocSrlNo = 0;
						  callableStatement.setInt(9,intDocSrlNo);	   
					  }else{
						  callableStatement.setInt(9,Integer.parseInt(docSerialNo));	
					  }
					    
					  callableStatement.setString(10, orderId);	   
					  callableStatement.setInt(11,Integer.parseInt(orderLineNo));	
					  callableStatement.setString(12, itemCode );	
					  callableStatement.setString(13, AuthStatus);	
					  callableStatement.setString(14, approvalNo);	//pass from interface 
					  callableStatement.setDate(15, new java.sql.Date(System.currentTimeMillis())); 
					  callableStatement.setInt(16, Integer.parseInt(approvedQty));	 
					 callableStatement.setDouble(17,Double.parseDouble(approvedAmt));	 	 
					  callableStatement.setString(18, (String)tabData.get("login_by_id"));	
					  callableStatement.setString(19,(String)tabData.get("login_at_ws_no"));	
					  callableStatement.registerOutParameter(20, Types.VARCHAR);
					  callableStatement.registerOutParameter(21, Types.VARCHAR);
					  callableStatement.registerOutParameter(22, Types.VARCHAR);
					  callableStatement.registerOutParameter(23, Types.VARCHAR);
					  callableStatement.registerOutParameter(24, Types.VARCHAR);
					  callableStatement.registerOutParameter(25, Types.VARCHAR); 
					  callableStatement.execute(); 
					  transactionStatus	=	(String)(callableStatement.getString(23));
					  msgId =(String)(callableStatement.getString(24));
					  msgTxt = (String)(callableStatement.getString(25));//END 
					  
						closeStatement(callableStatement);	//Common-ICN-0090				  
					
				}
			
		}
		catch(Exception e){
			System.err.println(" tabData="+tabData);
			e.printStackTrace();
			}
		finally{	
			try {
				closeResultSet(resultSet);	
				closeStatement(pstmt);  
				 closeStatement(callableStatement);
			}
			
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
		//return insurance_det; 
	}
	public String getSessionId(Properties prop){
		Connection con= null; 
		
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String session_id		= "";
		try {
			con =getConnection(prop);   
			pstmt				= con.prepareStatement(" SELECT USERENV ('SESSIONID') SESSION_ID FROM DUAL"); 
			resultSet	= pstmt.executeQuery();
			if (resultSet != null && resultSet.next()) {
				session_id = resultSet.getString("SESSION_ID")==null?"":resultSet.getString("SESSION_ID");
			 			 
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(con,prop); //MOHE-CRF-0026.1
			}
			catch(Exception es){ 
				es.printStackTrace();
			}
		}
		
		return session_id; 
}//MOHE-CRF-0026.1 END 

  private void updateStorageLocation(Connection connection,String patient_id,String encounter_id,String locn_code) throws Exception {//Adding start for TH-KW-CRF-0020.9
		PreparedStatement pstmt_delete	=	null;

		try{
			pstmt_delete	= connection.prepareStatement("DELETE  PH_DISP_BIN_LOCATION WHERE PATIENT_ID =? AND ENCOUNTER_ID =? AND DISP_LOCN_CODE =?") ;
			System.err.println("inside updateencounter_id@@==="+encounter_id+"patient_id=="+patient_id+"disp_locn_code=="+locn_code);
				pstmt_delete.setString(1,patient_id);
				pstmt_delete.setString(2,encounter_id);
				pstmt_delete.setString(3,locn_code);
                pstmt_delete.executeUpdate();

		}
		catch(Exception e ) {
			e.printStackTrace();
		}
		finally{	
			try {
				closeStatement( pstmt_delete ) ;
				pstmt_delete=null;
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
	}//Adding end for TH-KW-CRF-0020.9
}  
