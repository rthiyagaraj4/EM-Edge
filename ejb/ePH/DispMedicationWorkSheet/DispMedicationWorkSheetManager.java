/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
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
06/02/2020		IN071362                Manickavasagam J                       AAKH-CRF-0117
28/02/2022		29022			Shazana						Common-ICN-0090
---------------------------------------------------------------------------------------------------------------
*/
package ePH.DispMedicationWorkSheet ;
import java.rmi.* ;
import java.util.HashMap ;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Set;
import java.util.Iterator;
import java.sql.* ;
import javax.ejb.* ;
import ePH.Common.PhEJBSessionAdapter ;

/**
*
* @ejb.bean
*	name="DispMedicationWorkSheet"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="DispMedicationWorkSheet"
*	local-jndi-name="DispMedicationWorkSheet"
*	impl-class-name="ePH.DispMedicationWorkSheet.DispMedicationWorkSheetManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.DispMedicationWorkSheet.DispMedicationWorkSheetLocal"
*	remote-class="ePH.DispMedicationWorkSheet.DispMedicationWorkSheetRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.DispMedicationWorkSheet.DispMedicationWorkSheetLocalHome"
*	remote-class="ePH.DispMedicationWorkSheet.DispMedicationWorkSheetHome"
*	generate= "local,remote"
*
*
*/

public class DispMedicationWorkSheetManager extends PhEJBSessionAdapter {

	Properties prop=null;
	ArrayList alSalDocDtls = null; //Added for AMS-CRF-0079 [IN:050762]
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
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap modify( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;	
		alSalDocDtls = new ArrayList(); //Added for AMS-CRF-0079 [IN:050762]
		String disp_stage      = (String)tabData.get("disp_stage");  
		String filling_status  = "";
		String disp_locn_catg  = (String)tabData.get("patient_class");
		try{
			if(disp_stage.equals("A")){		//	Allocation
			  filling_status = (String)tabData.get("filling_status");
				
				if((disp_stage.equals("F") && (filling_status.equals("A")  ))|| (disp_stage.equals("A") && (filling_status.equals("B")  )) ){
					  map = completeAllocation1(tabData,sqlMap);
				}else{
				     map = completeAllocation(tabData,sqlMap);
				}

			}else if(disp_stage.equals("F")){	// Filling
			    filling_status = (String)tabData.get("filling_status");
			    if(((disp_stage.equals("F") && (filling_status.equals("A")  ))|| (disp_stage.equals("A") && (filling_status.equals("B")  )))&&(disp_locn_catg.equals("O")) ){
                      map = completeAllocation1(tabData,sqlMap);
				}else{
				      map = completeFilling(tabData,sqlMap);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		map.put("SAL_DOC_DTLS", alSalDocDtls); //Added for AMS-CRF-0079 [IN:050762]
		return map;
	}
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

	/*
		Update OR_ORDER,OR_ORDER_LINE,PATIENT DRUG PROFILE
			insert into TMP tables  (PH_DISP_DTL_TMP, PH_DISP_HDR_TMP,PH_DISP_DRUG_BATCH_TMP)
			insert into PH_WORKSHEET_DTL, PH_WORKSHEET_HDR			
	*/

	public HashMap completeAllocation(HashMap tabData,HashMap sqlMap ) throws Exception{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		
		Connection connection					     = null ;
		PreparedStatement pstmt_update_order_line    = null,pstmt_update_patient_drug_profile=null,pstmt_update_order=null ;
		PreparedStatement pstmt_insert_disp_hrd_tmp  = null,pstmt_insert_disp_drug_batch_tmp=null,pstmt_insert_disp_dtl_tmp=null;
		PreparedStatement pstmt_disp_hdr_count		 = null,pstmt_disp_hdr_delete=null,pstmt_disp_dtl_delete		=	null;
		PreparedStatement pstmt_disp_batch_delete	 = null;
		PreparedStatement pstmt_worksheet_hdr_insert = null,pstmt_worksheet_dtls_insert=null;
		String[] strTokenTemp					  = new String[2];//Added for HSA-CRF-0136 [IN:048412]

		try{
			final String SQL_PH_WS_DISP_MEDICATION_HRD_TMP_INSERT		= (String)sqlMap.get("SQL_PH_WS_DISP_MEDICATION_HRD_TMP_INSERT");
			final String SQL_PH_DISP_MEDICATION_DRUG_BATCH_TMP_INSERT	= (String)sqlMap.get("SQL_PH_DISP_MEDICATION_DRUG_BATCH_TMP_INSERT");
			final String SQL_PH_DISP_MEDICATION_DISP_DTL_TMP_INSERT		= (String)sqlMap.get("SQL_PH_DISP_MEDICATION_DISP_DTL_TMP_INSERT");
			final String SQL_PH_DISP_MEDICATION_SELECT33				= (String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT33");
			final String SQL_PH_WORKSHEET_HDR_INSERT					= (String)sqlMap.get("SQL_PH_WORKSHEET_HDR_INSERT");
			final String SQL_PH_WORKSHEET_DTL_INSERT					= (String)sqlMap.get("SQL_PH_WORKSHEET_DTL_INSERT");
			final String SQL_PH_WORKSHEET_ID_COUNT						= (String)sqlMap.get("SQL_PH_WORKSHEET_ID_COUNT");

			prop  = (Properties)tabData.get( "properties" );		

			String facility_id				= (String)tabData.get("facility_id");
			String login_by_id				= (String)tabData.get("login_by_id");
			String login_at_ws_no			= (String)tabData.get("login_at_ws_no");
			String disp_locn_code			= (String)tabData.get("disp_locn_code");
			String patient_class			= (String)tabData.get("patient_class");
			String source_code				= (String)tabData.get("source_code");
			String source_type				= (String)tabData.get("source_type");
			String ordering_facility_id		= (String)tabData.get("ordering_facility_id");
			String ord_date_time			= (String)tabData.get("ord_date_time");
			//String performing_pract_id		= (String)tabData.get("performing_pract_id");
			String patient_id				= (String)tabData.get("patient_id");
			String encounter_id				= (String)tabData.get("encounter_id");
			String delivery_applicable		= (String)tabData.get("delivery_applicable");
			String ws_type					= (String)tabData.get("ws_type");
			if(Integer.parseInt(ws_type) <= 5 && Integer.parseInt(ws_type) >=1 ) {
				ws_type = "I";
			}
			else if(Integer.parseInt(ws_type)==9 ||Integer.parseInt(ws_type)==0){
				ws_type = "C";
			}
			else if(Integer.parseInt(ws_type)==6){
				ws_type = "M";
			}

			String ws_status						= (String)tabData.get("ws_status");
			ArrayList orderLineData					= (ArrayList)tabData.get("orderLineData");
			ArrayList orderLineData1				= (ArrayList)tabData.get("orderLineData1");
			ArrayList patientDrugProfileData		= (ArrayList)tabData.get("patientDrugProfileData");
			ArrayList dispTMP						= (ArrayList)tabData.get("dispTMP");
	//		String stock_installed					= (String)tabData.get("stock");
			String store_code						= (String)tabData.get("store_code");
			Hashtable worksheetDtlsData				= (Hashtable)tabData.get("worksheetDtlsData");
			Hashtable addedDrugs					= (Hashtable)tabData.get("addedDrugs");
			String tot_rec							= (String)tabData.get("tot_rec");
			ArrayList mfg_unit_details				= (ArrayList)tabData.get("mfg_unit_details"); 
			ArrayList spill_qty_dtls				=  new ArrayList();   
			Hashtable ht_ws_fluid_allocate_batches  = (Hashtable)tabData.get("ht_ws_fluid_allocate_batches");
			String finalise_yn						= (String)tabData.get("finalized_yn");
			HashMap complte_order_reason			= (HashMap)tabData.get("complte_order_reason");
			HashMap order_id_attended_pract_id		=  (HashMap)tabData.get("ORDER_ID_ATTENDED_PRACT_ID");
			String worksheet_id						= "";
			connection = getConnection( prop ) ;
			if((patient_class.equals("O")&& ((String)tabData.get("worksheet_id")).equals(""))||(patient_class.equals("I")&&finalise_yn.equals("Y"))){
				  worksheet_id				= getWorkSheetID(SQL_PH_WORKSHEET_ID_COUNT,facility_id,disp_locn_code);
			}
			else{
				 worksheet_id				= (String)tabData.get("worksheet_id");
				 deleteworksheettables(connection,sqlMap,worksheet_id,disp_locn_code,facility_id);
			}		
		
			String admx_prep_charge_units	="";	
			if(tabData.containsKey("admx_prep_charge_units")){
				admx_prep_charge_units = (String)tabData.get("admx_prep_charge_units");
			}

			String admx_prep_charge_item_code	="";	
			if(tabData.containsKey("admx_prep_charge_item_code")){
				admx_prep_charge_item_code = (String)tabData.get("admx_prep_charge_item_code");
			}
			String charge_pat_for_spill_qty_yn="";
			if(tabData.containsKey("charge_pat_for_spill_qty_yn")){
				charge_pat_for_spill_qty_yn = (String)tabData.get("charge_pat_for_spill_qty_yn");
			}

			String update_string		=	"";
			String st_doc_type			=	"";
			HashMap orderUpdate			=	new HashMap();
			HashMap	stock_srl			=	new HashMap();
			HashMap prev_doc_no			=	new HashMap();
			HashMap seq_no				=	new HashMap();
			
			HashMap approvalNo			=  (HashMap)tabData.get("approvalNo");//AAKH-CRF-0117
			String disp_stage = (String)tabData.get("disp_stage");  
			if((disp_stage.equals("A"))&&(ws_status.equals("C")) )
				update_string	=	"AL";		// Allocated
			else if((disp_stage.equals("F"))&&(ws_status.equals("C")) )
				update_string	=	"IP";		//	Inprocess
				
			if(((String)orderLineData.get(0)).equals("Y")){	
					update_string = "HD";		// Hold
			}
				// Get the Stock Doc Type 
				st_doc_type	=	getStockDocType(connection,sqlMap,patient_class,facility_id);

				// Update the table or_order_line
				orderUpdate	=	updateOrOrderLine(connection, sqlMap,orderLineData,tabData,update_string );
				
				// Get the line status
	//				ord_line_status	=	getOrderLineStatus(connection,sqlMap,orderLineData,tabData);

				// Get the previous docno and doctype
					HashMap stock_vals		=	getDocValues(connection,sqlMap,orderLineData,dispTMP,tabData);
					if(stock_vals.size() > 1 ) {
						prev_doc_no		= (HashMap)stock_vals.get("doc_no");
	//					prev_doc_type	= (HashMap)stock_vals.get("doc_type");
						stock_srl		= (HashMap)stock_vals.get("srl_no");
					}

				//To generate Daily SEQ Number
			   if(patient_class.equals("I")){	
				    tabData.put("DailySeqNo",getSeqNumber(connection,tabData.get("facility_id").toString(),tabData.get("store_code").toString()));
			   }
			   else{
					tabData.put("DailySeqNo","");
			   }
				// Delete tmp tables
				deleteTMPTables(connection,sqlMap,orderLineData,tabData);
		
				// Update the ph_patient_drug_profile
				updatePatientDrugProfile(connection,sqlMap,tabData,patientDrugProfileData);

				// Update or_order
				updateOrOrder(connection,sqlMap,tabData,orderLineData,orderUpdate,update_string);
				
				String sequence_no = "",  trx_seq_no="";
				/*
					insert into disp_hrd_tmp table if delivery stage is applicable
					insert into disp_hrd table if delivery stage is not applicable
				*/
				HashMap token_vals		=	(HashMap)tabData.get("token_vals");
				if(delivery_applicable.equals("Y")){
					pstmt_insert_disp_hrd_tmp  = connection.prepareStatement( SQL_PH_WS_DISP_MEDICATION_HRD_TMP_INSERT ) ;
					pstmt_worksheet_hdr_insert = connection.prepareStatement( SQL_PH_WORKSHEET_HDR_INSERT );
					if(dispTMP.size()>0){
						trx_seq_no =  getSequenceNo("SELECT PH_DISP_TRN_SEQ.NEXTVAL FROM DUAL");
				        tabData.put("TRX_SEQ_NO",trx_seq_no);
						int count = 1;
						sequence_no = getSequenceNo(SQL_PH_DISP_MEDICATION_SELECT33);
						seq_no.put(((String)dispTMP.get(0)).trim(),sequence_no);
						pstmt_insert_disp_hrd_tmp.setString(count,sequence_no);					
						pstmt_insert_disp_hrd_tmp.setString(++count,facility_id);
						pstmt_insert_disp_hrd_tmp.setString(++count,disp_locn_code);
						pstmt_insert_disp_hrd_tmp.setString(++count,((String)dispTMP.get(0)).trim());
						pstmt_insert_disp_hrd_tmp.setString(++count,"");
						pstmt_insert_disp_hrd_tmp.setString(++count,ordering_facility_id.trim());
						pstmt_insert_disp_hrd_tmp.setString(++count,ord_date_time.trim());
						pstmt_insert_disp_hrd_tmp.setString(++count,patient_id.trim());
						pstmt_insert_disp_hrd_tmp.setString(++count,encounter_id.trim());
						if(patient_class.equals("O")){
							patient_class = "OP";
						}
						else if(patient_class.equals("I")){
							patient_class = "IP";
						}
						pstmt_insert_disp_hrd_tmp.setString(++count,patient_class.trim());
						pstmt_insert_disp_hrd_tmp.setString(++count,source_type.trim());
						pstmt_insert_disp_hrd_tmp.setString(++count,source_code.trim());
						pstmt_insert_disp_hrd_tmp.setString(++count,"");	// SPECIALITY_CODE
						pstmt_insert_disp_hrd_tmp.setString(++count,(String)(order_id_attended_pract_id.get(((String)dispTMP.get(0)).trim())));//pres_physician_id
						pstmt_insert_disp_hrd_tmp.setString(++count,(String)(order_id_attended_pract_id.get(((String)dispTMP.get(0)).trim())));//pres_physician_id
					//	pstmt_insert_disp_hrd_tmp.setString(++count,performing_pract_id.trim());
					//	pstmt_insert_disp_hrd_tmp.setString(++count,performing_pract_id.trim());
						pstmt_insert_disp_hrd_tmp.setString(++count,login_at_ws_no);
						pstmt_insert_disp_hrd_tmp.setString(++count,facility_id);
						pstmt_insert_disp_hrd_tmp.setString(++count,login_at_ws_no);
						pstmt_insert_disp_hrd_tmp.setString(++count,facility_id);
						pstmt_insert_disp_hrd_tmp.setString(++count,worksheet_id);
						pstmt_insert_disp_hrd_tmp.setString(++count, trx_seq_no); //DISP_TRN_SEQ_NO
						pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("DailySeqNo")); //DAILY_SEQ_NUM
						//pstmt_insert_disp_hrd_tmp.setString(++count,(String)tabData.get("token_series_code")); //token series code
						//pstmt_insert_disp_hrd_tmp.setString(++count,(String)token_vals.get(((String)dispTMP.get(0)).trim())); //token
						if(token_vals!=null && token_vals.size()>0){ //Added if and else block added for HSA-CRF-0136 [IN:048412]
							strTokenTemp = ((String)token_vals.get(((String)dispTMP.get(0)).trim())).split("_");
							pstmt_insert_disp_hrd_tmp.setString(++count,strTokenTemp[0]); //token series code
							pstmt_insert_disp_hrd_tmp.setString(++count,strTokenTemp[1]); //token
						}
						else{ //else block Added for [IN:049206]
							pstmt_insert_disp_hrd_tmp.setString(++count,""); //token series code
							pstmt_insert_disp_hrd_tmp.setString(++count,""); //token
						}
						pstmt_insert_disp_hrd_tmp.executeUpdate();
						count=1;

						ArrayList arr_list_dtls_1 = (ArrayList)worksheetDtlsData.get(1+"");
						pstmt_worksheet_hdr_insert.setString(count,facility_id);				// FACILITY_ID         
						pstmt_worksheet_hdr_insert.setString(++count,disp_locn_code);			// DISP_LOCN           
						pstmt_worksheet_hdr_insert.setString(++count,worksheet_id);				// WORKSHEET_ID        
						pstmt_worksheet_hdr_insert.setString(++count,((String)mfg_unit_details.get(0)).trim());	// MFG_UNIT            
						pstmt_worksheet_hdr_insert.setString(++count,login_by_id);				// WS_PREP_BY          
						pstmt_worksheet_hdr_insert.setString(++count,ws_type);					// WS_TYPE             
						pstmt_worksheet_hdr_insert.setString(++count,ws_status);				// WS_STATUS           
						pstmt_worksheet_hdr_insert.setString(++count,login_by_id);				// ADDED_BY_ID         
						pstmt_worksheet_hdr_insert.setString(++count,login_at_ws_no);			// ADDED_AT_WS_NO      
						pstmt_worksheet_hdr_insert.setString(++count,facility_id);				// ADDED_FACILITY_ID   
						pstmt_worksheet_hdr_insert.setString(++count,login_by_id);				// MODIFIED_BY_ID			
						pstmt_worksheet_hdr_insert.setString(++count,login_at_ws_no);			// MODIFIED_AT_WS_NO      
						pstmt_worksheet_hdr_insert.setString(++count,facility_id);				// MODIFIED_FACILITY_ID
						pstmt_worksheet_hdr_insert.setString(++count,((String)mfg_unit_details.get(1)).trim());	// BATCH_ID
						pstmt_worksheet_hdr_insert.setString(++count,((String)mfg_unit_details.get(2)).trim());	// EXPIRY_DATE
						pstmt_worksheet_hdr_insert.setString(++count,((String)mfg_unit_details.get(3)).trim());	// QTY_VOLUME
						pstmt_worksheet_hdr_insert.setString(++count,((String)mfg_unit_details.get(4)).trim());	// QTY_UOM
						pstmt_worksheet_hdr_insert.setString(++count,((String)arr_list_dtls_1.get(0)).trim());	// ORDER_ID
						pstmt_worksheet_hdr_insert.setString(++count,((String)mfg_unit_details.get(5)).trim());	// ADMIN_INSTRUCTION
						pstmt_worksheet_hdr_insert.setString(++count,((String)mfg_unit_details.get(6)).trim());	// FINALIZED_YN
						pstmt_worksheet_hdr_insert.setString(++count,admx_prep_charge_item_code);	// ADMX_PREP_CHARGE_ITEM_CODE
						pstmt_worksheet_hdr_insert.setString(++count,admx_prep_charge_units);	// ADMX_PREP_CHARGE_UNITS
						//pstmt_worksheet_hdr_insert.setString(++count,((String)mfg_unit_details.get(8)).trim());	// PRODUCT_CODE
						pstmt_worksheet_hdr_insert.executeUpdate();																	
					}
					
					pstmt_worksheet_dtls_insert = connection.prepareStatement( SQL_PH_WORKSHEET_DTL_INSERT ) ;
					int rec_count=1;
					String spill_qty_used    = "";
					String used_qty          ="";
					String sRFluidItemCode	 = null;
					for (int i=1;i<=Integer.parseInt(tot_rec.trim()) ;i++ ){	
						sRFluidItemCode	 = "";						
						if(worksheetDtlsData.get(i+"") != null){
							ArrayList arr_list_dtls = (ArrayList)worksheetDtlsData.get(i+"");
							ArrayList arr_list_drug_dtls=(ArrayList)addedDrugs.get(i+"");
							ArrayList arr_list_fluid_dtls=(ArrayList)ht_ws_fluid_allocate_batches.get(i+"");

							if(arr_list_drug_dtls==null)
								arr_list_drug_dtls=new ArrayList();
							String physical_form="L";
							if(arr_list_drug_dtls.size()==10){
								physical_form="P";
							}	
							double total_qty_dispensed = Double.parseDouble((String)arr_list_dtls.get(5));
							ArrayList arr_list_batch_dtls = (ArrayList)arr_list_dtls.get(6);

							for (int j=0;j<arr_list_drug_dtls.size() ; j=j+5){	
								String disp_drug_code = "";
								if(j==5){
									physical_form ="F";	
									if (arr_list_fluid_dtls!=null && arr_list_fluid_dtls.size()>0)
									{
										sRFluidItemCode = arr_list_fluid_dtls.get(0) != null ? arr_list_fluid_dtls.get(0).toString():"";
									}

								}
								disp_drug_code = (String)arr_list_dtls.get(3);

								if(arr_list_drug_dtls.size()==10 && j >=5 ){
									disp_drug_code = (String)arr_list_drug_dtls.get(5);
								}
								int count=1;
								pstmt_worksheet_dtls_insert.setString(  count,facility_id );		// FACILITY_ID 
								pstmt_worksheet_dtls_insert.setString(++count,disp_locn_code);		// DISP_LOCN 
								pstmt_worksheet_dtls_insert.setString(++count,worksheet_id.trim());	// WORKSHEET_ID 
								pstmt_worksheet_dtls_insert.setString(++count,rec_count+"");		// WS_SRL_NO               
								pstmt_worksheet_dtls_insert.setString(++count,((String)arr_list_dtls.get(0)).trim());		// ORDER_ID       
								pstmt_worksheet_dtls_insert.setString(++count,((String)arr_list_dtls.get(1)).trim());		// ORDER_LINE_NUM 
								pstmt_worksheet_dtls_insert.setString(++count,disp_drug_code);		// DISP_DRUG_CODE 
								pstmt_worksheet_dtls_insert.setString(++count,physical_form);						// PHYSICAL_FORM
								pstmt_worksheet_dtls_insert.setString(++count,(String)arr_list_dtls.get(4));		// DISP_DRUG_BASE_UNIT 
								spill_qty_used  = (String)arr_list_drug_dtls.get(j+3);
								pstmt_worksheet_dtls_insert.setString(++count,spill_qty_used);	// SPIL_QTY_AVAIL 
								
								if(charge_pat_for_spill_qty_yn.equals("Y")){
									if(!spill_qty_used.equals("")){
										if(Double.parseDouble(spill_qty_used)>0){                        
											  spill_qty_dtls.add(rec_count+"");
											  spill_qty_dtls.add(disp_drug_code);
											  spill_qty_dtls.add(spill_qty_used);
											  spill_qty_dtls.add((String)arr_list_batch_dtls.get(7));//trade_id
											  spill_qty_dtls.add((String)arr_list_batch_dtls.get(1));//batch_id
											  spill_qty_dtls.add((String)arr_list_batch_dtls.get(2));//exp_date
											  spill_qty_dtls.add((String)arr_list_batch_dtls.get(6));//bin_loc_code
										}
									}
								}
								
								pstmt_worksheet_dtls_insert.setString(++count,sRFluidItemCode);									// DISP_ITEM_CODE      
								pstmt_worksheet_dtls_insert.setString(++count,(String)arr_list_dtls.get(4));		// STOCK_UNIT    
								//pstmt_worksheet_dtls_insert.setString(++count,(String)arr_list_drug_dtls.get(j+4));	// QTY_USED_FROM_STOCK  
								//pstmt_worksheet_dtls_insert.setString(++count,(String)arr_list_drug_dtls.get(j+2));	// USED_QTY   
								pstmt_worksheet_dtls_insert.setString(++count,total_qty_dispensed+"");	// QTY_USED_FROM_STOCK 
								used_qty = (total_qty_dispensed+Double.parseDouble(spill_qty_used))+"";
								pstmt_worksheet_dtls_insert.setString(++count,used_qty);	// USED_QTY   
								pstmt_worksheet_dtls_insert.setString(++count,"0");		// DISP_QTY_IN_STOCK_UNIT  
								String batch_id1="",batch_id2="",batch_id3="";	 
								String expiry_date1="",expiry_date2="",expiry_date3="";
								String bin_locn_code1="",bin_locn_code2="",bin_locn_code3="";
								String trade_id1="",trade_id2="",trade_id3="";	 

								if(physical_form.equals("F")){
									
									if(arr_list_fluid_dtls==null)
										arr_list_fluid_dtls= new ArrayList();
									if(arr_list_fluid_dtls.size()==16){
										 batch_id1		= (String)arr_list_fluid_dtls.get(1);
										 expiry_date1	= (String)arr_list_fluid_dtls.get(7);
										 bin_locn_code1	= (String)arr_list_fluid_dtls.get(8);
										 trade_id1		= (String)arr_list_fluid_dtls.get(10);
	//									 disp_qty1	    = (String)arr_list_fluid_dtls.get(15);
									}
									else if(arr_list_fluid_dtls.size()==32){
										 batch_id1		= (String)arr_list_fluid_dtls.get(1);
										 expiry_date1	= (String)arr_list_fluid_dtls.get(7);
										 bin_locn_code1	= (String)arr_list_fluid_dtls.get(8);
										 trade_id1		= (String)arr_list_fluid_dtls.get(10);
	//									 disp_qty1	    = (String)arr_list_fluid_dtls.get(15);								
										 batch_id2		= (String)arr_list_fluid_dtls.get(17);
										 expiry_date2	= (String)arr_list_fluid_dtls.get(23);
										 bin_locn_code2	= (String)arr_list_fluid_dtls.get(24);
										 trade_id2		= (String)arr_list_fluid_dtls.get(26);
	//									 disp_qty2	    = (String)arr_list_fluid_dtls.get(31);	
									}
									else if(arr_list_fluid_dtls.size()==48){
										 batch_id1	    = (String)arr_list_fluid_dtls.get(1);
										 expiry_date1   = (String)arr_list_fluid_dtls.get(7);
										 bin_locn_code1 = (String)arr_list_fluid_dtls.get(8);
										 trade_id1	    = (String)arr_list_fluid_dtls.get(10);
	//									 disp_qty1	    = (String)arr_list_fluid_dtls.get(15);
										 batch_id2	    = (String)arr_list_fluid_dtls.get(17);
										 expiry_date2   = (String)arr_list_fluid_dtls.get(23);
										 bin_locn_code2 = (String)arr_list_fluid_dtls.get(24);
										 trade_id2	    = (String)arr_list_fluid_dtls.get(26);
	//									 disp_qty2	    = (String)arr_list_fluid_dtls.get(31);
										 batch_id3	    = (String)arr_list_fluid_dtls.get(33);
										 expiry_date3   = (String)arr_list_fluid_dtls.get(39);
										 bin_locn_code3 = (String)arr_list_fluid_dtls.get(40);
										 trade_id3	    = (String)arr_list_fluid_dtls.get(42);
	// 									 disp_qty3	    = (String)arr_list_fluid_dtls.get(31);
									}
								}
								else{							
									if(arr_list_batch_dtls.size()==9){
										 batch_id1	   = (String)arr_list_batch_dtls.get(1);
										 expiry_date1  = (String)arr_list_batch_dtls.get(2);
	//									 disp_qty1	   = (String)arr_list_batch_dtls.get(3);
										 bin_locn_code1= (String)arr_list_batch_dtls.get(6);
										 trade_id1	   = (String)arr_list_batch_dtls.get(7);
									}
									else if(arr_list_batch_dtls.size()==18){
										 batch_id1	   = (String)arr_list_batch_dtls.get(1);
										 expiry_date1  = (String)arr_list_batch_dtls.get(2);
	//									 disp_qty1	   = (String)arr_list_batch_dtls.get(3);
										 bin_locn_code1= (String)arr_list_batch_dtls.get(6);
										 trade_id1	   = (String)arr_list_batch_dtls.get(7);								
										 batch_id2	   = (String)arr_list_batch_dtls.get(10);
										 expiry_date2  = (String)arr_list_batch_dtls.get(11);
	//									 disp_qty2	   = (String)arr_list_batch_dtls.get(11);
										 bin_locn_code2= (String)arr_list_batch_dtls.get(15);
										 trade_id2	   = (String)arr_list_batch_dtls.get(16);
									}
									else if(arr_list_batch_dtls.size()==27){
										 batch_id1	    = (String)arr_list_batch_dtls.get(1);
										 expiry_date1   = (String)arr_list_batch_dtls.get(2);
	//									 disp_qty1		= (String)arr_list_batch_dtls.get(3);
										 bin_locn_code1 = (String)arr_list_batch_dtls.get(6);
										 trade_id1	    = (String)arr_list_batch_dtls.get(7);

										 batch_id2	    = (String)arr_list_batch_dtls.get(10);
										 expiry_date2   = (String)arr_list_batch_dtls.get(11);
	//									 disp_qty2		= (String)arr_list_batch_dtls.get(11);
										 bin_locn_code2 = (String)arr_list_batch_dtls.get(15);
										 trade_id2	    = (String)arr_list_batch_dtls.get(16);

										 batch_id3	    = (String)arr_list_batch_dtls.get(19);
										 expiry_date3   = (String)arr_list_batch_dtls.get(20);
	//									 disp_qty3	   = (String)arr_list_batch_dtls.get(19);
										 bin_locn_code3 = (String)arr_list_batch_dtls.get(24);
										 trade_id3	    = (String)arr_list_batch_dtls.get(25);
									}
								}
								pstmt_worksheet_dtls_insert.setString(++count,batch_id1);		// BATCH_ID1 
								pstmt_worksheet_dtls_insert.setString(++count,expiry_date1);	// EXPIRY_DATE1            
								pstmt_worksheet_dtls_insert.setString(++count,bin_locn_code1);	// BIN_LOCN_CODE1 
								pstmt_worksheet_dtls_insert.setString(++count,trade_id1);		// TRADE_ID1 
								pstmt_worksheet_dtls_insert.setString(++count,batch_id2);		// BATCH_ID2  
								pstmt_worksheet_dtls_insert.setString(++count,expiry_date2);	// EXPIRY_DATE2  
								pstmt_worksheet_dtls_insert.setString(++count,bin_locn_code2);	// BIN_LOCN_CODE2  
								pstmt_worksheet_dtls_insert.setString(++count,trade_id2);		// TRADE_ID2  
								pstmt_worksheet_dtls_insert.setString(++count,batch_id3);		// BATCH_ID3   
								pstmt_worksheet_dtls_insert.setString(++count,expiry_date3);	// EXPIRY_DATE3 
								pstmt_worksheet_dtls_insert.setString(++count,bin_locn_code3);	// BATCH_ID3 
								pstmt_worksheet_dtls_insert.setString(++count,trade_id3);		// EXPIRY_DATE3   
							
							//	int bal_qty = Integer.parseInt((String)arr_list_drug_dtls.get(1))- total_qty_dispensed;
								double bal_qty = Double.parseDouble((String)arr_list_drug_dtls.get(1))-Double.parseDouble( used_qty);

								pstmt_worksheet_dtls_insert.setString(++count,bal_qty+"");		// BAL_QTY                 
								pstmt_worksheet_dtls_insert.setString(++count,"0");		// SAL_QTY                 
								pstmt_worksheet_dtls_insert.setString(++count,"");		// SAL_UNIT                
								pstmt_worksheet_dtls_insert.setString(++count,login_by_id);		// ADDED_BY_ID             
								pstmt_worksheet_dtls_insert.setString(++count,login_at_ws_no);	// ADDED_AT_WS_NO          
								pstmt_worksheet_dtls_insert.setString(++count,facility_id);		// ADDED_FACILITY_ID       
								pstmt_worksheet_dtls_insert.setString(++count,login_by_id);		// MODIFIED_BY_ID          
								pstmt_worksheet_dtls_insert.setString(++count,login_at_ws_no);	// MODIFIED_AT_WS_NO       
								pstmt_worksheet_dtls_insert.setString(++count,facility_id);		// MODIFIED_FACILITY_ID    
								pstmt_worksheet_dtls_insert.addBatch();

								rec_count++;
							}						
						}
					}
					int[] worksheet_dtls_result=pstmt_worksheet_dtls_insert.executeBatch();
					for (int i=0;i<worksheet_dtls_result.length ;i++ ){
						// A number greater than or equal to zero  indicates success
						// A number -2 indicates that command is successful but number of rows updated is unknow
						// If it won't satisfy any of the above cancel the statement and throw an exception
						if(worksheet_dtls_result[i]<0  && worksheet_dtls_result[i] != -2 ){
							pstmt_worksheet_dtls_insert.cancel();
							connection.rollback();
							throw new EJBException("Delete Failed");
						}		
					}

					// Insert in to PH_DISP_DTL_TMP
					pstmt_insert_disp_dtl_tmp = connection.prepareStatement( SQL_PH_DISP_MEDICATION_DISP_DTL_TMP_INSERT ) ;

					int jj					=	1;
					int tmp_no				=	1;
					String prev_order_id	=	"";
					int iTotalOrders			= dispTMP.size()/7;	
					int iOrdercount				= 1;
					String cer_res_yn           ="N";
					String approval_no			= ""; //AAKH-CRF-0117
					for(int i=0;i<dispTMP.size();i=i+7){
						int count = 1;
						if(!prev_order_id.equals(((String)dispTMP.get(i)).trim()))
							jj	=	1;

						prev_order_id		=	((String)dispTMP.get(i)).trim();

						tmp_no			=	(jj++);
						approval_no     = "";//AAKH-CRF-0117
						pstmt_insert_disp_dtl_tmp.setString(count,sequence_no);							//DISP_TMP_NO
						pstmt_insert_disp_dtl_tmp.setString(++count,(tmp_no)+"");							//DTL_SERIAL_NUM
						pstmt_insert_disp_dtl_tmp.setString(++count,facility_id.trim());					//FACILITY_ID
						pstmt_insert_disp_dtl_tmp.setString(++count,disp_locn_code.trim());				//DISP_LOCN_CODE
						pstmt_insert_disp_dtl_tmp.setString(++count,((String)dispTMP.get(i)).trim());	//ORDER_ID
						pstmt_insert_disp_dtl_tmp.setString(++count,((String)dispTMP.get(i+1)).trim());	//ORDER_LINE_NO
						pstmt_insert_disp_dtl_tmp.setString(++count,((String)dispTMP.get(i+2)).trim());	//PRES_DRUG_CODE
						pstmt_insert_disp_dtl_tmp.setString(++count,facility_id.trim());				//ORDERING_FACILITY_ID

                        if(getCustomerID(connection).equals("SRR")){
							if(getEssentialItemYN(connection,((String)dispTMP.get(i+3)).trim()).equals("N")){
								if(!tabData.containsKey("CER_RES_NO")){
									String cer_res_no = (String)GenerateCerRemNO(connection);
									tabData.put("CER_RES_NO",cer_res_no);
								}
								cer_res_yn           ="Y";
							}
							else{
								cer_res_yn           ="N";
							}
						}

						pstmt_insert_disp_dtl_tmp.setString(++count,((String)dispTMP.get(i+3)).trim());	//DISP_DRUG_CODE
						pstmt_insert_disp_dtl_tmp.setString(++count,((String)dispTMP.get(i+4)).trim());	//DISP_QTY
						pstmt_insert_disp_dtl_tmp.setString(++count,((String)dispTMP.get(i+5)).trim());	//DISP_UOM_CODE
						pstmt_insert_disp_dtl_tmp.setString(++count,login_by_id.trim());
						pstmt_insert_disp_dtl_tmp.setString(++count,login_at_ws_no.trim());
						pstmt_insert_disp_dtl_tmp.setString(++count,facility_id.trim());
						pstmt_insert_disp_dtl_tmp.setString(++count,login_by_id.trim());
						pstmt_insert_disp_dtl_tmp.setString(++count,login_at_ws_no.trim());
						pstmt_insert_disp_dtl_tmp.setString(++count,facility_id.trim());
						if(stock_srl.containsKey(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+3)).trim())) {
							pstmt_insert_disp_dtl_tmp.setString(++count,(String)stock_srl.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+3)).trim()));
						}
						else {
							stock_srl.put(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+3)).trim(),(tmp_no)+"");
							pstmt_insert_disp_dtl_tmp.setString(++count,(tmp_no)+"");
						}
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
						if(tabData.get("DailySeqNo") != null && !tabData.get("DailySeqNo").toString().equals(""))
							pstmt_insert_disp_dtl_tmp.setString(++count,iOrdercount+"/"+iTotalOrders); //DSN_REFERENCE
						else
							pstmt_insert_disp_dtl_tmp.setString(++count,""); //DSN_REFERENCE
						pstmt_insert_disp_dtl_tmp.setString(++count,cer_res_yn); //cer_rem _n0
						pstmt_insert_disp_dtl_tmp.setString(++count,""); //drug Indication
					System.err.println("approvalNo==631==>"+approvalNo);
						//added for AAKH-CRF-0117
						if(approvalNo!=null && approvalNo.size()>0)
						approval_no = (String)approvalNo.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim());

						if(approval_no==null)
						approval_no = "";
						pstmt_insert_disp_dtl_tmp.setString(++count,approval_no); //Approval No
						pstmt_insert_disp_dtl_tmp.addBatch();
						iOrdercount++;
					}
					int[] result3=pstmt_insert_disp_dtl_tmp.executeBatch();
					for (int i=0;i<result3.length ;i++ ){
						// A number greater than or equal to zero  indicates success
						// A number -2 indicates that command is successful but number of rows updated is unknow
						// If it won't satisfy any of the above cancel the statement and throw an exception
						if(result3[i]<0  && result3[i] != -2 ){
							pstmt_insert_disp_dtl_tmp.cancel();
							connection.rollback();
							throw new EJBException("Delete Failed");
						}		
					}
					// Insert in to PH_DISP_DRUG_BATCH_TMP
					String drug_code	=	"";
					String item_code	=	"";
					String batch_id		=	"";
					String expiry_date	=	"";
					String disp_qty		=	"";	
					String disp_qty_uom =	"";
					String bin_locn_code=	"";
					String trade_id		=	"";

					pstmt_insert_disp_drug_batch_tmp	= connection.prepareStatement( SQL_PH_DISP_MEDICATION_DRUG_BATCH_TMP_INSERT ) ;
		
					for(int i=0;i<dispTMP.size();i=i+7){
						ArrayList batchDetails = (ArrayList)dispTMP.get(i+6);
						for (int j=0;j<batchDetails.size() ; j=j+10){ //9->10 for MMS-SCF-0040 [IN:041888]
							int count=1;
							drug_code		= (String)dispTMP.get(i+3);
							item_code		= (String)batchDetails.get(j);
							batch_id		= (String)batchDetails.get(j+1);
							expiry_date		= (String)batchDetails.get(j+2);
							disp_qty		= (String)batchDetails.get(j+3);
							disp_qty_uom	= (String)batchDetails.get(j+4);
							bin_locn_code	= (String)batchDetails.get(j+6);
							trade_id		= (String)batchDetails.get(j+7);

							pstmt_insert_disp_drug_batch_tmp.setString(count,facility_id.trim());
							pstmt_insert_disp_drug_batch_tmp.setString(++count,disp_locn_code.trim());
							pstmt_insert_disp_drug_batch_tmp.setString(++count,((String)dispTMP.get(i)).trim());
							pstmt_insert_disp_drug_batch_tmp.setString(++count,((String)dispTMP.get(i+1)).trim());
							pstmt_insert_disp_drug_batch_tmp.setString(++count,item_code);
							pstmt_insert_disp_drug_batch_tmp.setString(++count,batch_id.trim());
							pstmt_insert_disp_drug_batch_tmp.setString(++count,expiry_date.trim());
							pstmt_insert_disp_drug_batch_tmp.setString(++count,store_code.trim());
							pstmt_insert_disp_drug_batch_tmp.setString(++count,disp_qty.trim());
							pstmt_insert_disp_drug_batch_tmp.setString(++count,drug_code.trim());
							pstmt_insert_disp_drug_batch_tmp.setString(++count,login_by_id.trim());
							pstmt_insert_disp_drug_batch_tmp.setString(++count,login_at_ws_no.trim());
							pstmt_insert_disp_drug_batch_tmp.setString(++count,facility_id.trim());
							pstmt_insert_disp_drug_batch_tmp.setString(++count,login_by_id.trim());
							pstmt_insert_disp_drug_batch_tmp.setString(++count,login_at_ws_no.trim());
							pstmt_insert_disp_drug_batch_tmp.setString(++count,facility_id.trim());
							pstmt_insert_disp_drug_batch_tmp.setString(++count,disp_qty_uom.trim());
							pstmt_insert_disp_drug_batch_tmp.setString(++count,(String)stock_srl.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+3)).trim()));
							pstmt_insert_disp_drug_batch_tmp.setString(++count,bin_locn_code);
							pstmt_insert_disp_drug_batch_tmp.setString(++count,trade_id);
							pstmt_insert_disp_drug_batch_tmp.addBatch();
						}					
					}
					int[] result4=pstmt_insert_disp_drug_batch_tmp.executeBatch();
					for (int k=0;k<result4.length ;k++ ){
						// A number greater than or equal to zero  indicates success
						// A number -2 indicates that command is successful but number of rows updated is unknow
						// If it won't satisfy any of the above cancel the statement and throw an exception
						if(result4[k]<0  && result4[k] != -2 ){
							pstmt_insert_disp_drug_batch_tmp.cancel();
							connection.rollback();
							throw new EJBException("Delete Failed");
						}		
					}
				}			
				tabData.put("seq_no",seq_no);
				updateOrOrderLinePh(connection,sqlMap,tabData,orderLineData,orderLineData1,complte_order_reason);
				String token_yn					 = (String)tabData.get("token_yn");
				if(token_yn.equals("Y")) {
					  updateDispQueue(connection, sqlMap, tabData,orderLineData,disp_stage.trim(),update_string);
				}
				//code for inserting PH_DISP_CONS_DTL
				insertConsumableDeatil(connection,sqlMap,tabData);
				//code for inserting PH_DISP_CONS_BATCH
				insertConsumableBatch(connection,sqlMap,tabData);
				//deletesales(connection,tabData,dispTMP,prev_doc_no,st_doc_type,sqlMap,stock_srl);
				if(dispTMP.size()>0){
				    callStockUpdate(connection,tabData,sqlMap,dispTMP,prev_doc_no,st_doc_type,stock_srl,spill_qty_dtls);
				}
				connection.commit();
				map.put("result", new Boolean( true) ) ;
				map.put("msgid","RECORD_MODIFIED");
				if(((String)orderLineData.get(0)).equals("Y") || (worksheetDtlsData.size()==0)){	
					map.put("flag","0");
				}
				else{
					map.put("flag",worksheet_id);
				}
		}
		catch(Exception e){
			System.err.println("====completeAllocation==========tabData==============>"+tabData);
			e.printStackTrace();
			connection.rollback();
			//map.put("flag","0");
			map.put( "result", new Boolean( false) ) ;
			map.put("msgid",e.toString());
			map.put("flag",e.toString());
			return map;
		}
		finally{
			try{
				closeStatement( pstmt_update_order_line ) ;
				closeStatement( pstmt_update_patient_drug_profile ) ;
				closeStatement( pstmt_update_order );
				closeStatement( pstmt_insert_disp_hrd_tmp );
				closeStatement( pstmt_insert_disp_dtl_tmp );
				closeStatement( pstmt_insert_disp_drug_batch_tmp );
				closeStatement( pstmt_worksheet_hdr_insert );
				closeStatement( pstmt_worksheet_dtls_insert );
				closeStatement( pstmt_disp_hdr_count );
				closeStatement( pstmt_disp_hdr_delete );
				closeStatement( pstmt_disp_dtl_delete );
				closeStatement( pstmt_disp_batch_delete );
				closeConnection( connection,prop );
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return map;
	}

	public HashMap completeAllocation1(HashMap tabData,HashMap sqlMap ) throws Exception{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		
		Connection connection = null ;
		PreparedStatement pstmt_update_order_line   = null,pstmt_update_patient_drug_profile=null,pstmt_update_order=null ;
		PreparedStatement pstmt_insert_disp_hrd_tmp = null,pstmt_insert_disp_drug_batch_tmp=null,pstmt_insert_disp_dtl_tmp=null;
		/*PreparedStatement pstmt_disp_hdr_count		= null,pstmt_disp_hdr_delete=null,pstmt_disp_dtl_delete		=	null;Unused local variable INC63877
		PreparedStatement pstmt_disp_batch_delete	= null;*/
		//PreparedStatement pstmt_worksheet_hdr_insert= null,pstmt_worksheet_dtls_insert=null;
		try{
			//final String SQL_PH_WS_DISP_MEDICATION_HRD_TMP_INSERT		= (String)sqlMap.get("SQL_PH_WS_DISP_MEDICATION_HRD_TMP_INSERT");
			//final String SQL_PH_DISP_MEDICATION_DRUG_BATCH_TMP_INSERT	= (String)sqlMap.get("SQL_PH_DISP_MEDICATION_DRUG_BATCH_TMP_INSERT");
			//final String SQL_PH_DISP_MEDICATION_DISP_DTL_TMP_INSERT		= (String)sqlMap.get("SQL_PH_DISP_MEDICATION_DISP_DTL_TMP_INSERT");
			//final String SQL_PH_DISP_MEDICATION_SELECT33				= (String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT33");
			//final String SQL_PH_WORKSHEET_HDR_INSERT					= (String)sqlMap.get("SQL_PH_WORKSHEET_HDR_INSERT");
			//final String SQL_PH_WORKSHEET_DTL_INSERT					= (String)sqlMap.get("SQL_PH_WORKSHEET_DTL_INSERT");
			//final String SQL_PH_WORKSHEET_ID_COUNT						= (String)sqlMap.get("SQL_PH_WORKSHEET_ID_COUNT");
			prop  = (Properties)tabData.get( "properties" );		
			String facility_id				= (String)tabData.get("facility_id");
			//String login_by_id				= (String)tabData.get("login_by_id");
			//String login_at_ws_no			= (String)tabData.get("login_at_ws_no");
			String disp_locn_code			= (String)tabData.get("disp_locn_code");
			//String patient_class			= (String)tabData.get("patient_class");
			//String source_code				= (String)tabData.get("source_code");
			//String source_type				= (String)tabData.get("source_type");
			//String ordering_facility_id		= (String)tabData.get("ordering_facility_id");
			//String ord_date_time			= (String)tabData.get("ord_date_time");
			//String performing_pract_id		= (String)tabData.get("performing_pract_id");
			//String patient_id				= (String)tabData.get("patient_id");
			String encounter_id				= (String)tabData.get("encounter_id");
			//String delivery_applicable		= (String)tabData.get("delivery_applicable");
			String ws_type					= (String)tabData.get("ws_type");
			if(Integer.parseInt(ws_type) <= 5 && Integer.parseInt(ws_type) >=1 ) {
				ws_type = "I";
			}
			else if(Integer.parseInt(ws_type)==9 ||Integer.parseInt(ws_type)==0){
				ws_type = "C";
			}
			else if(Integer.parseInt(ws_type)==6){
				ws_type = "M";
			}
			String ws_status				= (String)tabData.get("ws_status");

			ArrayList orderLineData			= (ArrayList)tabData.get("orderLineData");
			ArrayList orderLineData1		= (ArrayList)tabData.get("orderLineData1");
			ArrayList patientDrugProfileData= (ArrayList)tabData.get("patientDrugProfileData");
			//ArrayList dispTMP				= (ArrayList)tabData.get("dispTMP");
			//String stock_installed			= (String)tabData.get("stock");
			//String store_code				= (String)tabData.get("store_code");
			Hashtable worksheetDtlsData     = (Hashtable)tabData.get("worksheetDtlsData");
			//Hashtable addedDrugs			= (Hashtable)tabData.get("addedDrugs");
			//String tot_rec					= (String)tabData.get("tot_rec");
			//ArrayList mfg_unit_details		= (ArrayList)tabData.get("mfg_unit_details");
			HashMap complte_order_reason	= (HashMap)tabData.get("complte_order_reason");
			//ArrayList spill_qty_dtls		=  new ArrayList();   
		 
			//Hashtable ht_ws_fluid_allocate_batches= (Hashtable)tabData.get("ht_ws_fluid_allocate_batches");
			//String finalise_yn				= (String)tabData.get("finalized_yn");
			String worksheet_id				="";
			connection = getConnection( prop ) ;
			String admx_prep_charge_units="";

			if(tabData.containsKey("admx_prep_charge_units")){
				admx_prep_charge_units = (String)tabData.get("admx_prep_charge_units");
			}
			worksheet_id				= (String)tabData.get("worksheet_id");
			String update_string		=	"";
			//String st_doc_type			=	"";
			HashMap orderUpdate			=	new HashMap();
			//HashMap	stock_srl			=	new HashMap();
			//HashMap prev_doc_no			=	new HashMap();
			//HashMap seq_no				=	new HashMap();

			String disp_stage = (String)tabData.get("disp_stage");  
			if((disp_stage.equals("A"))&&(ws_status.equals("C")) )
				update_string	=	"AL";		// Allocated
			else if((disp_stage.equals("F"))&&(ws_status.equals("C")) )
				update_string	=	"IP";		//	Inprocess
				
			if(((String)orderLineData.get(0)).equals("Y")){	
					update_string = "HD";		// Hold
			}
			// Update the table or_order_line
			orderUpdate	=	updateOrOrderLine(connection, sqlMap,orderLineData,tabData,update_string );
			// Update the ph_patient_drug_profile
			updatePatientDrugProfile(connection,sqlMap,tabData,patientDrugProfileData);
			// Update or_order
			updateOrOrder(connection,sqlMap,tabData,orderLineData,orderUpdate,update_string);
			updateOrOrderLinePh(connection,sqlMap,tabData,orderLineData,orderLineData1,complte_order_reason);
            String token_yn					 = (String)tabData.get("token_yn");
			if(token_yn.equals("Y")) {
			      updateDispQueue(connection, sqlMap, tabData,orderLineData,disp_stage.trim(),update_string);
		    }	
			if(tabData.containsKey("admx_prep_charge_units")){
				admx_prep_charge_units = (String)tabData.get("admx_prep_charge_units");
				updateWorksheetHdr(connection,admx_prep_charge_units,worksheet_id,facility_id,disp_locn_code);

			}
			String admx_prep_charges_appl_yn  =(String)tabData.get("admx_prep_charges_appl_yn")==null?"":(String)tabData.get("admx_prep_charges_appl_yn");
			if(admx_prep_charges_appl_yn.equals("Y")){
				String old_mark_up_down				=  (String)tabData.get("old_mark_up_down")==null?"":(String)tabData.get("old_mark_up_down");//Added For ML-BRU-CRF-072[Inc:29938]	
				admx_prep_charge_units		=	"";	
				if(tabData.containsKey("admx_prep_charge_units")){
					admx_prep_charge_units = (String)tabData.get("admx_prep_charge_units")==null?"":(String)tabData.get("admx_prep_charge_units");//Added For ML-BRU-CRF-072[Inc:29938]
				}
				if(!old_mark_up_down.equals(admx_prep_charge_units)){
					PreparedStatement pstmtPC	= null;
					ResultSet resultSetPC		= null;
					String  patient_class_PC	= "";
					try {
						pstmtPC		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_BL_SELECT1") ) ;
						pstmtPC.setString(1,(String)tabData.get("ordering_facility_id"));
						pstmtPC.setString(2,encounter_id);
						pstmtPC.setString(3,(String)tabData.get("patient_id")); //added for [IN:035667] to avaoid duplicate encounter id with 11111 for EXT Prescription
						resultSetPC	= pstmtPC.executeQuery() ; 
						if(resultSetPC.next()){
							patient_class_PC = resultSetPC.getString("ENC_PATIENT_CLASS");
						}
					}
					catch ( Exception e ) {
						e.printStackTrace() ;
					}
					finally {
						closeResultSet( resultSetPC ) ;
						closeStatement( pstmtPC ) ;
					}
					PreparedStatement pstmtPC1	= null;
					ResultSet resultSetPC1		= null;
					String  doc_no	            = "";
					String  doc_type_code        = "";
					String  order_id             = "";
					try {
						pstmtPC1		= connection.prepareStatement( "select DOC_TYPE, DOC_NO,order_id  from ph_disp_hdr_tmp where FACILITY_ID=? and DISP_LOCN_code =? and  WORKSHEET_ID=?" ) ;
						pstmtPC1.setString(1,facility_id);
						pstmtPC1.setString(2,disp_locn_code);
						pstmtPC1.setString(3,worksheet_id);
						resultSetPC1	= pstmtPC1.executeQuery() ;
						if(resultSetPC1.next()){
							doc_no			= resultSetPC1.getString("DOC_NO");
							doc_type_code	= resultSetPC1.getString("DOC_TYPE");
							order_id		= resultSetPC1.getString("order_id");
						}
					}
					catch ( Exception e ) {
						e.printStackTrace() ;
					}
					finally {
						closeResultSet( resultSetPC1 ) ;
						closeStatement( pstmtPC1 ) ;
					}
					String admx_prep_charge_item_code	="";	
					if(tabData.containsKey("admx_prep_charge_item_code")){
						admx_prep_charge_item_code = (String)tabData.get("admx_prep_charge_item_code");
					}
					//delete   
					//if(!old_mark_up_down.equals(admx_prep_charge_units)){
					insertPreprationChargeDet(connection,tabData,patient_class_PC,doc_type_code,doc_no,order_id,200,"Y","200",old_mark_up_down,";",admx_prep_charge_item_code);
					//re-insert	
					insertPreprationChargeDet(connection,tabData,patient_class_PC,doc_type_code,doc_no,order_id,201,"N","",admx_prep_charge_units,";",admx_prep_charge_item_code);
				}
			}
			connection.commit();
			map.put("result", new Boolean( true) ) ;
			map.put("msgid","RECORD_MODIFIED");
			if(((String)orderLineData.get(0)).equals("Y") || (worksheetDtlsData.size()==0)){	
				map.put("flag","0");
			}
			else{
				map.put("flag",worksheet_id);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			connection.rollback();
			map.put( "result", new Boolean( false) ) ;
			map.put("msgid",e.toString());
			map.put("flag",e.toString());
			return map;
		}
		finally{
			try{
				closeStatement( pstmt_update_order_line ) ;
				closeStatement( pstmt_update_patient_drug_profile ) ;
				closeStatement( pstmt_update_order );
				closeStatement( pstmt_insert_disp_hrd_tmp );
				closeStatement( pstmt_insert_disp_dtl_tmp );
				closeStatement( pstmt_insert_disp_drug_batch_tmp );
				//closeStatement( pstmt_worksheet_hdr_insert );
				//closeStatement( pstmt_worksheet_dtls_insert );
				//closeStatement( pstmt_disp_hdr_count );
				//closeStatement( pstmt_disp_hdr_delete );
				//closeStatement( pstmt_disp_dtl_delete );
				//closeStatement( pstmt_disp_batch_delete );

				pstmt_update_order_line				=null;
				pstmt_update_patient_drug_profile	=null;
				pstmt_update_order					=null;
				pstmt_insert_disp_hrd_tmp			=null;
				pstmt_insert_disp_dtl_tmp			=null;
				pstmt_insert_disp_drug_batch_tmp	=null;
				//pstmt_worksheet_hdr_insert			=null;
				//pstmt_worksheet_dtls_insert			=null;
			//	pstmt_disp_hdr_count				=null;
				//pstmt_disp_hdr_delete				=null;
				//pstmt_disp_dtl_delete				=null;
				//pstmt_disp_batch_delete				=null;
				closeConnection( connection,prop );
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return map;
	}

	private void updateDispQueue(Connection connection, HashMap sqlMap, HashMap tabData,ArrayList orderLineData,String stage,String update_string) throws Exception {
		PreparedStatement pstmt_update_disp_queue		= null;
		PreparedStatement pstmt_update_disp_queue_summ	= null;
		PreparedStatement pstmt_update_ord_for_disp_queue = null;//PMG2020-ML-MMOH-CRF-0002

		HashMap token_vals		=	(HashMap)tabData.get("token_vals");
		//String token_no			=	"";Unused local variable INC63877
		int count				=	1;
		int count1				=	1;
		String[] strTokenTemp		= new String[2];//Added for HSA-CRF-0136 [IN:048412]
		String token_series_code="";//Added token_series_code for HSA-CRF-0136 [IN:048412]
		String token_no = "";//added for PMG2020-ML-MMOH-CRF-0002

		Set <String> setTokenSeries = new HashSet<String>();//Added for HSA-CRF-0136 [IN:048412]
		try {
			 if(stage.equals("F")) {
				pstmt_update_disp_queue			= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_UPDATE3A") ) ;
				pstmt_update_disp_queue_summ	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_UPDATE8") ) ;			
			}
			else if(stage.equals("A")) {
				pstmt_update_disp_queue			= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_UPDATE4A") ) ;
				pstmt_update_disp_queue_summ	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_UPDATE9") ) ;			
			}
			pstmt_update_ord_for_disp_queue = connection.prepareStatement("UPDATE PH_ORD_FOR_DISP_QUEUE SET TOKEN_LINE_STATUS= ? WHERE FACILITY_ID=? AND  DISP_LOCN_CODE =? AND  QUEUE_DATE=TO_DATE(?,'DD/MM/YYYY') AND QUEUE_SHIFT='*ALL' AND TOKEN_SERIES_CODE=? AND TOKEN_SERIAL_NO=? AND ORDER_ID=? AND ORDER_LINE_NUM=?"); //added for PMG2020-ML-MMOH-CRF-0002


			for(int i=0; i<orderLineData.size(); i+=6) {//Added for HSA-CRF-0136 [IN:048412] start
				if(token_vals.containsKey(((String)orderLineData.get(i+3)).trim())) {
					strTokenTemp	=	((String)token_vals.get(((String)orderLineData.get(i+3)).trim())).split("_");
					token_series_code = strTokenTemp[0];
					setTokenSeries.add(token_series_code);
				}
				if(stage.equals("AS")) {
					i	=	i	+	3;
				}
			}
			if(setTokenSeries!=null && setTokenSeries.size()>0){
				for(int k=0; k<setTokenSeries.size(); k++){//Added for HSA-CRF-0136 [IN:048412] end
					pstmt_update_disp_queue_summ.setString(count,(String)tabData.get("login_by_id"));
					pstmt_update_disp_queue_summ.setString(++count,(String)tabData.get("login_at_ws_no"));
					pstmt_update_disp_queue_summ.setString(++count,(String)tabData.get("facility_id"));
					pstmt_update_disp_queue_summ.setString(++count,(String)tabData.get("facility_id"));
					pstmt_update_disp_queue_summ.setString(++count,(String)tabData.get("disp_locn_code"));
					pstmt_update_disp_queue_summ.setString(++count,(String)tabData.get("Token_Queue_date"));
					//pstmt_update_disp_queue_summ.setString(++count,(String)tabData.get("token_series_code"));
					//pstmt_update_disp_queue_summ.executeUpdate();
					pstmt_update_disp_queue_summ.setString(++count,token_series_code);//Changed token_series_code for HSA-CRF-0136 [IN:048412]
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
			for(int i=0; i<orderLineData.size(); i+=6) {
				if(((String)orderLineData.get(i)).trim().equals("N")){
					count	=	1; 
					count1  = 1;
					pstmt_update_disp_queue.setString(count,update_string);
					pstmt_update_disp_queue.setString(++count,(String)tabData.get("login_by_id"));
					pstmt_update_disp_queue.setString(++count,(String)tabData.get("login_at_ws_no"));
					pstmt_update_disp_queue.setString(++count,(String)tabData.get("facility_id"));
					pstmt_update_disp_queue.setString(++count,(String)tabData.get("facility_id"));
					pstmt_update_disp_queue.setString(++count,(String)tabData.get("disp_locn_code"));
					pstmt_update_disp_queue.setString(++count,(String)tabData.get("Token_Queue_date"));
					/*pstmt_update_disp_queue.setString(++count,(String)tabData.get("token_series_code"));
					if(token_vals.containsKey(((String)orderLineData.get(i+3)).trim())) {
						token_no	=	(String)token_vals.get(((String)orderLineData.get(i+3)).trim());
					}
					pstmt_update_disp_queue.setString(++count,token_no);*/
					if(token_vals!=null && token_vals.size()>0){ //Added if and else block added for HSA-CRF-0136 [IN:048412]
						strTokenTemp	=	((String)token_vals.get(((String)orderLineData.get(i+3)).trim())).split("_");//Changed for HSA-CRF-0136 [IN:048412]
						pstmt_update_disp_queue.setString(++count,strTokenTemp[0]); //token series code
						pstmt_update_disp_queue.setString(++count,strTokenTemp[1]); //token
						token_series_code = strTokenTemp[0];  //PMG2020-ML-MMOH-CRF-0002
						token_no		  = strTokenTemp[1]; //PMG2020-ML-MMOH-CRF-0002
					}
					else{ //else block Added for [IN:049206]
						pstmt_update_disp_queue.setString(++count,""); //token series code
						pstmt_update_disp_queue.setString(++count,""); //token
					}
						pstmt_update_disp_queue.addBatch();
						
				//added for PMG2020-ML-MMOH-CRF-0002 - start
							pstmt_update_ord_for_disp_queue.setString(count1,update_string);
							pstmt_update_ord_for_disp_queue.setString(++count1,(String)tabData.get("facility_id"));
							pstmt_update_ord_for_disp_queue.setString(++count1,(String)tabData.get("disp_locn_code"));
							pstmt_update_ord_for_disp_queue.setString(++count1,(String)tabData.get("Token_Queue_date"));
					  	    pstmt_update_ord_for_disp_queue.setString(++count1,token_series_code);
							pstmt_update_ord_for_disp_queue.setString(++count1,token_no);
							pstmt_update_ord_for_disp_queue.setString(++count1,orderLineData.get(i+3).toString().trim());
							pstmt_update_ord_for_disp_queue.setString(++count1,orderLineData.get(i+4).toString().trim());
							pstmt_update_ord_for_disp_queue.addBatch();
//added for PMG2020-ML-MMOH-CRF-0002 - end

				}
				if(stage.equals("AS")) {
					i	=	i	+	3;
				}
			}

			int[] result4	=pstmt_update_disp_queue.executeBatch();
			int[] result5	=pstmt_update_ord_for_disp_queue.executeBatch();
			
			for (int i=0;i<result4.length ;i++ ){
				if(result4[i]<0  && result4[i] != -2 ){
				pstmt_update_disp_queue.cancel();
				connection.rollback();
				throw new EJBException("Dispense Queue updation Failed");
				}		
			}
			for (int i=0;i<result5.length ;i++ ){
				if(result5[i]<0  && result5[i] != -2 ){
				pstmt_update_ord_for_disp_queue.cancel();
				connection.rollback();
				throw new EJBException("Dispense Queue For Order updation Failed");
				}		
			}

		}
		catch(Exception e){
			e.printStackTrace();
			try {
				connection.rollback();
				throw new EJBException("Dispense Queue updation Failed");
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
		finally{	
			try {
				closeStatement( pstmt_update_disp_queue ) ;
				closeStatement( pstmt_update_disp_queue_summ ) ;
				closeStatement(pstmt_update_ord_for_disp_queue);//3/21/2021
				pstmt_update_disp_queue		=null;
				pstmt_update_disp_queue_summ=null;
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
	}
	public HashMap completeFilling(HashMap tabData,HashMap sqlMap ) throws Exception{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		map = completeAllocation(tabData,sqlMap);
		return map;
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
			throw e ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection,prop );
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return result;
	}	

	public String getWorkSheetID(String SQL_PH_WORKSHEET_ID_COUNT,String facility_id,String disp_locn_code)throws Exception{
		String result = "";
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null;
		try {
			connection = getConnection(prop) ;
			pstmt = connection.prepareStatement( SQL_PH_WORKSHEET_ID_COUNT ) ;
			pstmt.setString(1,facility_id.trim());
			pstmt.setString(2,disp_locn_code.trim());
			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next() ) {
				result = resultSet.getString("WORKSHEET_ID");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				resultSet=null;
				pstmt	 =null;
				closeConnection( connection,prop );
			}
			catch(Exception es) { es.printStackTrace();}
		}
		return result;
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
	
		}
		catch(Exception e){
				e.printStackTrace();
		}
		finally{	
			try {
				closeResultSet( resSet ) ;
				closeStatement( pstmt_st_doc_type ) ;
				resSet=null;
				pstmt_st_doc_type=null;
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
		return st_doc_type;
	}

	// Order line update 
	private HashMap updateOrOrderLine(Connection connection, HashMap sqlMap,ArrayList orderLineData, HashMap tabData, String update_string) throws Exception{
		HashMap orderUpdate							=	new HashMap();
		
		PreparedStatement pstmt_update_order_line	= null;
		try {
			pstmt_update_order_line = connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_ORDER_LINE_UPDATE") ) ;
			ArrayList arr_list_values = null;
			for(int i=0;i<orderLineData.size();i=i+6){
				if(!orderUpdate.containsKey((String)orderLineData.get(i+3))){
					arr_list_values = new ArrayList();
				}
				if(((String)orderLineData.get(i+5)).trim().equals("Y")) {	
                     update_string	=	"DF"; 
				 } 

				if(((String)orderLineData.get(i)).equals("Y")){				// If prescription is on hold.
					pstmt_update_order_line.setString(1,"HD");												//ORDER_LINE_STATUS       
					pstmt_update_order_line.setString(2,(String)orderLineData.get(i+1));					//HOLD_PRACT_ID           
					pstmt_update_order_line.setString(3,((String)tabData.get("dateTime")).trim());									//HOLD_DATE_TIME          
					pstmt_update_order_line.setString(4,"HD");												//LAST_ACTION_TYPE        
					pstmt_update_order_line.setString(5,((String)orderLineData.get(i+2)).trim());			//LAST_ACTION_REASON_DESC 
					pstmt_update_order_line.setString(6,((String)orderLineData.get(i+2)).trim());			//CAN_LINE_REASON added newly for the ML-BRU-SCF-0184 by SureshKumar T on 07/06/2012 
					arr_list_values.add("HD");
				}
				else if(((String)orderLineData.get(i)).equals("N")){		// If prescription is Allocated.
					pstmt_update_order_line.setString(1,update_string);												//ORDER_LINE_STATUS       
					pstmt_update_order_line.setString(2,"");												//HOLD_PRACT_ID           
					pstmt_update_order_line.setString(3,"");												//HOLD_DATE_TIME          
					pstmt_update_order_line.setString(4,"");												//LAST_ACTION_TYPE        
					pstmt_update_order_line.setString(5,"");												//LAST_ACTION_REASON_DESC 
					pstmt_update_order_line.setString(6,"");												//CAN_LINE_REASON added newly for the ML-BRU-SCF-0184 by SureshKumar T on 07/06/2012
					arr_list_values.add(update_string);
				}
					else if(((String)orderLineData.get(i)).equals("NN")){		// If prescription is not on hold,allocated.
					arr_list_values.add("OS");
					continue;
				}
				pstmt_update_order_line.setString(7,(String)tabData.get("login_by_id"));		// modified id
				pstmt_update_order_line.setString(8,(String)tabData.get("facility_id"));		// modified facility
				pstmt_update_order_line.setString(9,(String)tabData.get("login_at_ws_no"));		// modified work station
			
				pstmt_update_order_line.setString(10, "");		// RESULT LINE STATUS
				pstmt_update_order_line.setString(11,((String)orderLineData.get(i+3)).trim());	//ORDER_ID
				pstmt_update_order_line.setString(12,((String)orderLineData.get(i+4)).trim());	//ORDER_LINE_NUM
				pstmt_update_order_line.addBatch();

				orderUpdate.put((String)orderLineData.get(i+3),arr_list_values);
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
				pstmt_update_order_line=null;
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
			
			for(int i=0;i<orderLineData.size();i=i+6){
				pstmt_ord_line_status.setString(1,((String)orderLineData.get(i+3)).trim());
				pstmt_ord_line_status.setString(2,((String)orderLineData.get(i+4)).trim());
				resultSet = pstmt_ord_line_status.executeQuery() ;
				if ( resultSet != null && resultSet.next() ) {
					line_status.put(((String)orderLineData.get(i+3)).trim()+((String)orderLineData.get(i+4)).trim(),resultSet.getString("ORDER_LINE_STATUS"));
				}
			
				if(((String)tabData.get("disp_stage")).equals("AS")) {
					i	=	i+3;
				}
				closeResultSet( resultSet ) ;//3/21/2021
			}
		}
		catch(Exception e){
			e.printStackTrace();
			throw new EJBException("Error: OR_ORDER_LINE_STATUS UPDATION");
		}
		finally{	
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt_ord_line_status ) ;
				resultSet=null;
				pstmt_ord_line_status=null;
			}catch(Exception es) { 
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

		try {
			pstmt_disp_hdr_tmp_docno	=	connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT58") ) ;
			pstmt_select_disp_tmp		=	connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT67") );
			
			//previous doc no and doc type
			for(int i=0;i<orderLineData.size();i=i+6){
				pstmt_disp_hdr_tmp_docno.setString(1,((String)orderLineData.get(i+3)).trim());
				resultSet	= pstmt_disp_hdr_tmp_docno.executeQuery() ;

				if (resultSet.next() ) {
					prev_doc_no.put(((String)orderLineData.get(i+3)).trim(),resultSet.getString("DOC_NO"));
					prev_doc_type.put(((String)orderLineData.get(i+3)).trim(),resultSet.getString("DOC_TYPE"));
				}
				if(((String)tabData.get("disp_stage")).equals("AS")) {
							i	=	i+3;
				}
				closeResultSet( resultSet ) ; //Common-ICN-0090
			}

			// previous srl no

			closeResultSet( resultSet ) ; //resultSet	=	null; //modified for Common-icn-0060
			for(int i=0;i<dispTMP.size();i+=7){
				pstmt_select_disp_tmp.setString(1,((String)dispTMP.get(i)).trim());
				pstmt_select_disp_tmp.setString(2,((String)dispTMP.get(i+1)).trim());

				resultSet	=	pstmt_select_disp_tmp.executeQuery();
				/*if(resultSet!=null && resultSet.next()) {
					if(resultSet.getString("DOC_SRL_NO")!=null && !(resultSet.getString("DOC_SRL_NO").equals(""))) {
						tmp_srl_no	=	resultSet.getString("DOC_SRL_NO");
						srl_no.put(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+3)).trim(),tmp_srl_no);
					}
				}*/
				if(resultSet!=null && resultSet.next()){
					while(true) {
						if(resultSet.getString("DOC_SRL_NO")!=null && !(resultSet.getString("DOC_SRL_NO").equals(""))) {
							tmp_srl_no	=	resultSet.getString("DOC_SRL_NO");
							srl_no.put(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim()+((String)dispTMP.get(i+3)).trim(),tmp_srl_no);
							if(resultSet.next())
								i+=7;
							else
								break;
						}
					}
				}
				closeResultSet( resultSet ) ; //Common-ICN-0090
			}
			st_doc_vals.put("doc_no",prev_doc_no);
			st_doc_vals.put("doc_type",prev_doc_type);
			st_doc_vals.put("srl_no",srl_no);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{	
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt_disp_hdr_tmp_docno ) ;
				closeStatement( pstmt_select_disp_tmp ) ;
				resultSet				=null;
                pstmt_disp_hdr_tmp_docno=null;
				pstmt_select_disp_tmp	=null;
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
		PreparedStatement pstmt_disp_hdr_delete		=	null;
		PreparedStatement pstmt_disp_dtl_delete		=	null;
		PreparedStatement pstmt_disp_batch_delete	=	null;
		ResultSet resultSet							=	null;
		int tot_count								=	0;
		try {
			pstmt_disp_hdr_count		= connection.prepareStatement((String)sqlMap.get("SQL_PH_DISP_MEDICATION_HDR_COUNT")) ;
			pstmt_disp_hdr_delete		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_HDR_DELETE") ) ;
			pstmt_disp_dtl_delete		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_DTL_DELETE") ) ;
			pstmt_disp_batch_delete		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_BATCH_DELETE") ) ;

			for(int i=0;i<orderLineData.size();i=i+6){
				pstmt_disp_hdr_count.setString(1,((String)orderLineData.get(i+3)).trim());
				pstmt_disp_hdr_count.setString(2,((String)tabData.get("disp_locn_code")).trim());
				pstmt_disp_hdr_count.setString(3,((String)tabData.get("facility_id")).trim());
				resultSet = pstmt_disp_hdr_count.executeQuery() ;

				tot_count	=	0;
				if ( resultSet.next() ) {
					tot_count	=	Integer.parseInt(resultSet.getString("COUNT"));
				}

				if(tot_count > 0 ) {
					pstmt_disp_hdr_delete.setString(1,((String)orderLineData.get(i+3)).trim());
					pstmt_disp_hdr_delete.executeUpdate();

					pstmt_disp_dtl_delete.setString(1,((String)orderLineData.get(i+3)).trim());
					pstmt_disp_dtl_delete.executeUpdate();

					pstmt_disp_batch_delete.setString(1,((String)orderLineData.get(i+3)).trim());
					pstmt_disp_batch_delete.executeUpdate();
				}

				if(((String)tabData.get("disp_stage")).equals("AS")) {
					i	=	i+3;
				}
			}
			closeResultSet( resultSet ) ;
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

			resultSet				 =null;
			pstmt_disp_hdr_count     =null;
			pstmt_disp_hdr_delete    =null;
			pstmt_disp_dtl_delete    =null;
			pstmt_disp_batch_delete  =null;
			}catch(Exception es) {
				es.printStackTrace();
			}
		}
	}

	private void deleteworksheettables(Connection connection, HashMap sqlMap,String worksheet_id,String store_code,String facility_id) throws Exception{
		PreparedStatement pstmt_disp_worksheet_hdr_delete		=	null;
		PreparedStatement pstmt_disp_worksheet_dtl_delete		=	null;
		//int tot_count								=	0;
		try {
			pstmt_disp_worksheet_hdr_delete		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_DELETE4") ) ;
			pstmt_disp_worksheet_dtl_delete		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_DELETE5") ) ;
			

			pstmt_disp_worksheet_dtl_delete.setString(1,worksheet_id);
			pstmt_disp_worksheet_dtl_delete.setString(2,facility_id);
			pstmt_disp_worksheet_dtl_delete.setString(3,store_code);
			pstmt_disp_worksheet_dtl_delete.executeUpdate();
	
			pstmt_disp_worksheet_hdr_delete.setString(1,worksheet_id);
			pstmt_disp_worksheet_hdr_delete.setString(2,facility_id);
			pstmt_disp_worksheet_hdr_delete.setString(3,store_code);
			pstmt_disp_worksheet_hdr_delete.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
			throw new EJBException("Error: DELETING worksheet TABLES");
		}
		finally{	
			try {
			closeStatement( pstmt_disp_worksheet_hdr_delete ) ;
			closeStatement( pstmt_disp_worksheet_dtl_delete ) ;
			pstmt_disp_worksheet_hdr_delete     =null;
			pstmt_disp_worksheet_dtl_delete    =null;
			
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
	}
// Patient drug profile update
	private void updatePatientDrugProfile(Connection connection, HashMap sqlMap,HashMap tabData,ArrayList patientDrugProfileData) throws Exception{
		PreparedStatement pstmt_update_patient_drug_profile		=	null;
		try {
			pstmt_update_patient_drug_profile = connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_PATIENT_DRUG_PROFILE_UPDATE") ) ;
			String alt_drug_remarks="",key;
			HashMap hmAltDrugRemarks	=  (HashMap)tabData.get("ALTDRUGREMARKS");

			for(int i=0;i<patientDrugProfileData.size();i=i+6){					// If prescription is on hold
				key = ((String)patientDrugProfileData.get(i+4)).trim()+"~"+((String)patientDrugProfileData.get(i+5)).trim();
				if(hmAltDrugRemarks !=null && hmAltDrugRemarks.containsKey(key))
					alt_drug_remarks = (String)hmAltDrugRemarks.get(key);
				else
					alt_drug_remarks="";
				if(((String)patientDrugProfileData.get(i)).equals("Y")){
					pstmt_update_patient_drug_profile.setString(1,((String)tabData.get("dateTime")).trim());									// ON_HOLD_DATE_TIME    
					pstmt_update_patient_drug_profile.setString(2,(String)patientDrugProfileData.get(i+1));			// ON_HOLD_BY_ID        
					pstmt_update_patient_drug_profile.setString(3,(String)patientDrugProfileData.get(i+2));			// ON_HOLD_REASON_CODE  
				}
				else if(((String)patientDrugProfileData.get(i)).equals("N")){	// If prescription is allocated
					pstmt_update_patient_drug_profile.setString(1,"");												// ON_HOLD_DATE_TIME    
					pstmt_update_patient_drug_profile.setString(2,"");												// ON_HOLD_BY_ID        
					pstmt_update_patient_drug_profile.setString(3,"");												// ON_HOLD_REASON_CODE  
				}
				else if(((String)patientDrugProfileData.get(i)).equals("NN")){	// If prescription is not on hold and not allocated
					continue;
				}
				pstmt_update_patient_drug_profile.setString(4,(String)tabData.get("login_by_id"));		// modified id
				pstmt_update_patient_drug_profile.setString(5,(String)tabData.get("facility_id"));		// modified facility
				pstmt_update_patient_drug_profile.setString(6,(String)tabData.get("login_at_ws_no"));		// modified work station
				pstmt_update_patient_drug_profile.setString(7,alt_drug_remarks);		// alt_drug_remarks 
				pstmt_update_patient_drug_profile.setString(8,((String)patientDrugProfileData.get(i+3)).trim());	// PATIENT_ID          
				pstmt_update_patient_drug_profile.setString(9,((String)patientDrugProfileData.get(i+4)).trim());	// ORIG_ORDER_ID       
				pstmt_update_patient_drug_profile.setString(10,((String)patientDrugProfileData.get(i+5)).trim());	// ORIG_ORDER_LINE_NO  
				pstmt_update_patient_drug_profile.setString(11,(String)tabData.get("facility_id"));									// FACILITY_ID         
				pstmt_update_patient_drug_profile.addBatch();
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
				pstmt_update_patient_drug_profile=null;
			}catch(Exception es) {
				es.printStackTrace();
			}
		}
	}

// Or order update
	private void updateOrOrder(Connection connection, HashMap sqlMap, HashMap tabData,ArrayList orderLineData, HashMap  orderUpdate, String update_string) throws Exception {
		PreparedStatement pstmt_update_order		= null;
		PreparedStatement pstmt_update_disp_queue	= null;
		ArrayList order_id_to_update				= new ArrayList();
		int ord_update								= 0;

		try {

			pstmt_update_order = connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_ORDER_UPDATE1") ) ;

			Set set						= orderUpdate.keySet();
			Iterator iterator			= set.iterator();
			HashMap order_id_order_date = (HashMap)tabData.get("ORDER_ID_ORDER_DATE");

			while (iterator.hasNext()){
				String order_id		= (String)iterator.next();
				ArrayList arr_list	= (ArrayList)orderUpdate.get(order_id);
				String us			= getUpdateString(arr_list);

				order_id_to_update.add(order_id);
				order_id_to_update.add(us);	
				order_id_to_update.add(order_id_order_date.get(order_id));	
			}


			for(int i=0;i<order_id_to_update.size();i=i+3){
				pstmt_update_order.setString(1,((String)order_id_to_update.get(i+1)).trim());
				pstmt_update_order.setString(2,(String)tabData.get("login_by_id"));				// modified id
				pstmt_update_order.setString(3,(String)tabData.get("facility_id"));				// modified facility
				pstmt_update_order.setString(4,(String)tabData.get("login_at_ws_no"));			// modified work station
				pstmt_update_order.setString(5,((String)order_id_to_update.get(i)).trim());     // Order ID
				pstmt_update_order.setString(6,((String)order_id_to_update.get(i+2)).trim());	// or order's modified date	

				//pstmt_update_order.addBatch();
				ord_update = pstmt_update_order.executeUpdate();
			}
			if(ord_update < 0){
				connection.rollback();
				closeStatement( pstmt_update_order ) ;
				pstmt_update_order		=null;
				throw new EJBException();				
			}
			else if( ord_update == 0){
				connection.rollback();
				closeStatement( pstmt_update_order ) ;
				pstmt_update_order		=null;				
				throw new EJBException("ORDER_PROC_BY_OTHER_USER");
			}

		/*	int[] result3	=pstmt_update_order.executeBatch();
			for (int i=0;i<result3.length ;i++ ){
				if(result3[i]<0  && result3[i] != -2 ){
					pstmt_update_order.cancel();
					connection.rollback();
					throw new EJBException("Or Order update Failed");
				}		
			}
			*/
		}
		catch(Exception e){
			e.printStackTrace();
			throw new EJBException(e.toString().substring(24,(e.toString().length())));
		}
		finally{	
			try {
				closeStatement( pstmt_update_order ) ;
				closeStatement( pstmt_update_disp_queue ) ;
				pstmt_update_order		=null;
				pstmt_update_disp_queue =null;
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
		return update_string;
	}

	public void callStockUpdate(Connection connection,HashMap tabData,HashMap sqlMap,ArrayList dispTMP,HashMap prev_doc_no,String st_doc_type,HashMap stock_srl,ArrayList spill_qty_dtls) throws Exception{
		try {
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
			ArrayList orders		=	new ArrayList();
			HashMap stock_dtls		=	new HashMap();
			ArrayList insertDetail	=	new ArrayList();
			ArrayList insertExp		=	new ArrayList();
			ArrayList updateDetail	=	new ArrayList();
			ArrayList updateExp		=	new ArrayList();
			//String finalise_yn		=(String)tabData.get("finalized_yn");
			String disp_stage		=  (String)tabData.get("disp_stage");
			String p_overridden_excl_incl_ind   = "";
			String p_overridden_action_reason   = "";
			String sDischargedYN				= "";
			HashMap BaseAndIssueUOMQty			= new HashMap();
			ArrayList batchDetails = null;
			//HashMap hmDetai = null; Unused local variable INC63877
			String p_overridden_det = "";
			HashMap hmExp = null;
			ArrayList alMfgUnitDetails = null;
			HashMap hmDetail	   =	null;
			HashMap cons_dtl       =  null;
			HashMap Batch_det      =  null;
			String issued_qty	 =	 "";
			ArrayList  tot_consumables_det = null;
			boolean	bFinalizedOnScreen				= false;
			
			HashMap approvalNo = (HashMap)tabData.get("approvalNo");//AAKH-CRF-0117
			String approval_no = ""; //AAKH-CRF-0117

			for(int i=0;i<dispTMP.size();i=i+7){
				p_overridden_excl_incl_ind = "";
				p_overridden_action_reason = "";

				sDischargedYN				= getDischargeYN ( connection, (String)dispTMP.get(i));
				if(orders.size()!=0 && (!orders.contains(((String)dispTMP.get(i)).trim()))) {
					stock_dtls.put("insertDetail",insertDetail);
					stock_dtls.put("updateDetail",updateDetail);
					stock_dtls.put("insertExp",insertExp);
					stock_dtls.put("updateExp",updateExp);				

					updateStock(connection,tabData,sqlMap,stock_dtls,order_id,docno,st_doc_type,spill_qty_dtls);

					stock_dtls		=	new HashMap();
					insertDetail	=	new ArrayList();
					insertExp		=	new ArrayList();
					updateDetail	=	new ArrayList();
					updateExp		=	new ArrayList();
					orders			=	new ArrayList();
					order_id		=	"";
					docno			=	"";
				}

				batchDetails = (ArrayList)dispTMP.get(i+6);
				item_code				=	(String)batchDetails.get(0);
				item_cost				=	(String)batchDetails.get(8);
				if(item_cost.equals("")) item_cost	=	"0";

				//cost_value	=(Integer.parseInt((String)dispTMP.get(i+4)) * Math.abs(Float.parseFloat(item_cost)))+"";
				//cost_value	=	Math.round(Double.parseDouble((String)dispTMP.get(i+4)) * Double.parseDouble(item_cost)*1000)+"";

				//cost_value	= (Double.parseDouble(cost_value)/1000)+"";

				// Item Detail
				hmDetail	=	new HashMap();
				hmDetail.put("doc_srl_no",(String)stock_srl.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+3)).trim()));
				hmDetail.put("item_code",item_code);
				hmDetail.put("sal_category","");
				hmDetail.put("hcp_issue_factor","");
				//hmDetail.put("item_qty",((String)dispTMP.get(i+4)).trim());
				//done for 551.3 CRF
				BaseAndIssueUOMQty	=	(HashMap)getBaseAndIssueUOMQty( connection,  item_code,  (String)tabData.get("store_code"), ((String)dispTMP.get(i+4)).trim(),  ((String)dispTMP.get(i+5)).trim() );
				hmDetail.put("item_qty",(String)BaseAndIssueUOMQty.get("ISSUE_QTY"));
				hmDetail.put("mm_trn_qty",(String)BaseAndIssueUOMQty.get("BASE_QTY"));

				cost_value	=	Math.round(Double.parseDouble((String)BaseAndIssueUOMQty.get("ISSUE_QTY")) * Double.parseDouble(item_cost)*1000)+"";
				cost_value	=   (Double.parseDouble(cost_value)/1000)+"";

				hmDetail.put("item_sal_value",cost_value);
				hmDetail.put("next_due_date","");
				hmDetail.put("stock_item_yn","Y");
				hmDetail.put("remarks","");
				hmDetail.put("item_unit_cost",item_cost);
				hmDetail.put("item_cost_value",cost_value);
				hmDetail.put("item_unit_price",item_cost);
				hmDetail.put("uom_code",((String)dispTMP.get(i+5)).trim());
				hmDetail.put("mode",(String)tabData.get("mode"));

				hmDetail.put("take_home_yn",sDischargedYN);
				//added for AAKH-CRF-0117 - start
				if(approvalNo!=null && approvalNo.size()>0)
					approval_no = (String)approvalNo.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim());
System.err.println("approval_no===>"+approval_no);
								if(approval_no==null)
									approval_no = "";
						hmDetail.put("approval_no",approval_no);
			//added for AAKH-CRF-0117 - end
				p_overridden_det = getBlInclExclDetail(connection,(String)dispTMP.get(i),(String)dispTMP.get(i+1),sqlMap);
				if(p_overridden_det!=null && !p_overridden_det.equals("")){
					p_overridden_excl_incl_ind = p_overridden_det.substring(0,1);
					p_overridden_action_reason = p_overridden_det.substring(p_overridden_det.indexOf(":")+1);
				}
				hmDetail.put("p_overridden_excl_incl_ind",p_overridden_excl_incl_ind);
				hmDetail.put("p_overridden_action_reason",p_overridden_action_reason);

				if(prev_doc_no.containsKey(((String)dispTMP.get(i)).trim())&& disp_stage.equals("D")) 
					updateDetail.add(hmDetail);
				else
					insertDetail.add(hmDetail);

				// Batch Details
				for (int j=0;j<batchDetails.size() ; j=j+10){ //9->10 for MMS-SCF-0040 [IN:041888]
					batch_id		= (String)batchDetails.get(j+1);
					expiry_date		= (String)batchDetails.get(j+2);
					disp_qty		= (String)batchDetails.get(j+3);
					trade_id		= (String)batchDetails.get(j+7);
					bin_locn_code	= (String)batchDetails.get(j+6);
					hmExp	=	new HashMap();
					hmExp.put("doc_srl_no",(String)stock_srl.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+3)).trim()));
					hmExp.put("store_code",(String)tabData.get("store_code"));
					hmExp.put("item_code",item_code);
					hmExp.put("batch_id",batch_id);
					hmExp.put("bin_location_code",bin_locn_code);
					hmExp.put("expiry_date_or_receipt_date",expiry_date);
					hmExp.put("trade_id",trade_id);
					//	hmExp.put("sal_item_qty",disp_qty);
					//done for 551.3 CRF
					BaseAndIssueUOMQty	=	(HashMap)getBaseAndIssueUOMQty( connection,  item_code,  (String)tabData.get("store_code"), disp_qty,  ((String)dispTMP.get(i+5)).trim());
					hmExp.put("sal_item_qty",(String)BaseAndIssueUOMQty.get("BASE_QTY"));

					hmExp.put("ret_item_qty","");

					if(prev_doc_no.containsKey(((String)dispTMP.get(i)).trim())&& disp_stage.equals("D")) 
						updateExp.add(hmExp);	
					else
						insertExp.add(hmExp);
				}

				if(!orders.contains(((String)dispTMP.get(i)).trim())) {
					orders.add(((String)dispTMP.get(i)).trim());
					order_id	=	(String)orders.get(0);
					if(prev_doc_no.containsKey(order_id))
						docno		=	(String)prev_doc_no.get(order_id);
				}
			}

			alMfgUnitDetails				= (ArrayList)tabData.get("mfg_unit_details"); 
			bFinalizedOnScreen				= false;
			if(alMfgUnitDetails!= null && alMfgUnitDetails.size()>0){
				bFinalizedOnScreen = alMfgUnitDetails.get(6).toString().trim().equals("Y")?true:false; //FINALIZED_YN
			}

			if(tabData.containsKey("CONSUMABLES_DET") && bFinalizedOnScreen){
				hmDetail	     =	 new HashMap();
				cons_dtl       =   new HashMap();
				Batch_det      =   new HashMap();
				issued_qty		 =	 "";
				hmExp	         =	new HashMap();

				tot_consumables_det =(ArrayList)tabData.get("CONSUMABLES_DET");
				for (int h=0;h<tot_consumables_det.size() ;h++ ){ 
					hmDetail	     =	 new HashMap(); 
					cons_dtl = (HashMap)tot_consumables_det.get(h);
					if(cons_dtl.get("SELECTED_YN").equals("Y")&& !cons_dtl.get("ALLOC_QTY").equals("")){ 

						Batch_det   =   (HashMap)cons_dtl.get("BATCH_DET");
						hmDetail	=	new HashMap();
						item_cost	=	(String)Batch_det.get("ITEM_COST");
						issued_qty  =   (String)cons_dtl.get("ALLOC_QTY");

						if(item_cost.equals("")) item_cost	=	"0";
						cost_value	=	Math.round(Double.parseDouble(issued_qty) * Double.parseDouble(item_cost)*1000)+"";
						cost_value	=   (Double.parseDouble(cost_value)/1000)+"";

						hmDetail.put("doc_srl_no",cons_dtl.get("BATCH_SRL_NO"));
						hmDetail.put("item_code",Batch_det.get("ITEM_CODE"));
						hmDetail.put("sal_category","");
						hmDetail.put("hcp_issue_factor","");
						hmDetail.put("item_qty",issued_qty);
						hmDetail.put("item_sal_value",cost_value);
						hmDetail.put("next_due_date","");
						hmDetail.put("stock_item_yn","Y");
						hmDetail.put("remarks","");
						hmDetail.put("item_unit_cost",item_cost);
						hmDetail.put("item_cost_value",cost_value);
						hmDetail.put("item_unit_price",item_cost);
						hmDetail.put("uom_code",((String)cons_dtl.get("ORDER_UOM")));
						hmDetail.put("mode","1");
						hmDetail.put("p_overridden_excl_incl_ind","");
						hmDetail.put("p_overridden_action_reason","");

						hmDetail.put("take_home_yn",sDischargedYN); // For Take Home Flag
						insertDetail.add(hmDetail);
						hmExp	=	new HashMap();
						hmExp.put("doc_srl_no",cons_dtl.get("BATCH_SRL_NO"));
						hmExp.put("store_code",(String)tabData.get("store_code"));
						hmExp.put("item_code",(String)Batch_det.get("ITEM_CODE"));
						hmExp.put("batch_id",(String)Batch_det.get("BATCH_ID"));
						hmExp.put("bin_location_code",(String)Batch_det.get("BIN_LOCN_CODE"));
						hmExp.put("expiry_date_or_receipt_date",(String)Batch_det.get("EXPIRY_DATE"));
						hmExp.put("trade_id",(String)Batch_det.get("TRADE_ID"));
						hmExp.put("sal_item_qty",issued_qty);
						hmExp.put("ret_item_qty","");
						insertExp.add(hmExp);
					}
				}
			}
			stock_dtls.put("insertDetail",insertDetail);
			stock_dtls.put("updateDetail",updateDetail);
			stock_dtls.put("insertExp",insertExp);
			stock_dtls.put("updateExp",updateExp);

			updateStock(connection,tabData,sqlMap,stock_dtls,order_id,docno,st_doc_type,spill_qty_dtls);
		} 
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void updateStock(Connection connection,HashMap tabData, HashMap sqlMap, HashMap stock_dtls,String order_id, String prev_doc_no,String  st_doc_type,ArrayList spill_qty_dtls) throws Exception{

	//	Stock Insertion starts
		HashMap hmHeader	=	new HashMap();
		HashMap hmCommon	=	new HashMap();
		HashMap hmData		=	new HashMap();
		ArrayList language_data =  new ArrayList();
		String LanguageId	    =  (String)tabData.get("LanguageId");
		String encounter_id	    =   "";
		String patient_class_PC		= "";
        ArrayList mfg_unit_details	= (ArrayList)tabData.get("mfg_unit_details");
		String finalised_yn			= ((String)mfg_unit_details.get(6)).trim();
		ArrayList insertDetail	=	(ArrayList)stock_dtls.get("insertDetail");
		ArrayList updateDetail	=	(ArrayList)stock_dtls.get("updateDetail");
		ArrayList insertExp		=	(ArrayList)stock_dtls.get("insertExp");
		ArrayList updateExp		=	(ArrayList)stock_dtls.get("updateExp");
		PreparedStatement pstmt_update_disp_hdr_tmp	=	null;
		String errod_id	="";
		try{
			hmHeader.put("facility_id",(String)tabData.get("facility_id"));
			hmHeader.put("doc_type_code",st_doc_type);
			hmHeader.put("doc_no","");
			hmHeader.put("doc_date",(String)tabData.get("today"));
			hmHeader.put("doc_ref","");
			hmHeader.put("store_code",(String)tabData.get("store_code"));
			hmHeader.put("authorized_by_id","");
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
			hmHeader.put("encounter_id",(String)tabData.get("encounter_id"));
			hmHeader.put("sal_trn_type",(String)tabData.get("patient_class"));
			hmHeader.put("remarks","");
			hmHeader.put("item_class_code","");
			hmHeader.put("module_id","PH");

	  //===============code  for BL interface ==================
			if(tabData.get("encounter_id")==null || ((String)tabData.get("encounter_id")).equals("") || ((String)tabData.get("encounter_id")).equals("null")) {
					encounter_id	=	"11111";
			}
			else {
					encounter_id	=	(String)tabData.get("encounter_id");
			}
			HashMap token_vals      =   (HashMap)tabData.get("token_vals");
			String token_series_code =  "";//Added for HSA-CRF-0136 [IN:048412]
			String token_no			 =  "";	//Added for HSA-CRF-0136 [IN:048412]
			String[] strTokenTemp		= new String[2]; //Added for HSA-CRF-0136 [IN:048412]
			if(token_vals.containsKey((order_id).trim())) {
				//hmHeader.put("token_series_code",(String)tabData.get("token_series_code"));
				//hmHeader.put("token_serial_no",(String)token_vals.get((order_id).trim()));
				if(token_vals!=null && token_vals.size()>0){
					strTokenTemp = ((String)token_vals.get(order_id)).split("_");//Changed for HSA-CRF-0136 [IN:048412]
					token_series_code = strTokenTemp[0];//Changed for HSA-CRF-0136 [IN:048412]
					token_no		  =	strTokenTemp[1];//Changed for HSA-CRF-0136 [IN:048412]
				}
				hmHeader.put("token_series_code",token_series_code);
				hmHeader.put("token_serial_no",token_no);
			}

			if((( ((String)tabData.get("disp_stage")).equals("A")|| ((String)tabData.get("disp_stage")).equals("F") )&&((((String)tabData.get("DispBillingStage")).equals("A") )&& finalised_yn.equals("Y") ))||   (((String)tabData.get("disp_stage")).equals("D")&&((String)tabData.get("DispBillingStage")).equals("D")) ){
				 hmHeader.put("authorized_by_id",(String)tabData.get("login_by_id"));
			}
			else{
				hmHeader.put("authorized_by_id","");
			}
		 
			PreparedStatement pstmt_select	=	null;
			ResultSet resultSet			    = null;	
			String bl_interface_yn			="N";
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
			}
			catch ( Exception e ) {
				e.printStackTrace() ;
			}
			finally {
			  closeResultSet( resultSet ) ;
			  closeStatement( pstmt_select ) ;
			}

			hmHeader.put("billable_trn_yn",bl_interface_yn);//billable_trn_yn
			//if(bl_interface_yn.equals("Y")&& finalised_yn.equals("Y"))	{
			PreparedStatement pstmtPC	= null;
			ResultSet resultSetPC		= null;
				  patient_class_PC		= "";
			try {
				pstmtPC		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_BL_SELECT1") ) ;
				pstmtPC.setString(1,(String)tabData.get("ordering_facility_id"));
				pstmtPC.setString(2,encounter_id);
				pstmtPC.setString(3,(String)tabData.get("patient_id")); //added for [IN:035667] to avaoid duplicate encounter id with 11111 for EXT Prescription
				resultSetPC	= pstmtPC.executeQuery() ;
				if(resultSetPC.next()){
					patient_class_PC = resultSetPC.getString("ENC_PATIENT_CLASS");
				}
			}
			catch ( Exception e ) {
				e.printStackTrace() ;
			}
			finally {
				closeResultSet( resultSetPC ) ;
				closeStatement( pstmtPC ) ;
			}
			hmHeader.put("sal_trn_type",patient_class_PC);
			//}
			//=========BL related interface coding ends here====================
			hmCommon.put("login_by_id",(String)tabData.get("login_by_id"));
			hmCommon.put("login_at_ws_no",(String)tabData.get("login_at_ws_no"));
			hmCommon.put("login_facility_id",(String)tabData.get("facility_id"));
			hmCommon.put("FACILITY_STR_FOR_BL",(String)tabData.get("ordering_facility_id")+"|"+(String)tabData.get("facility_id"));

		   language_data.add(LanguageId);

			hmData.put("HDR_DATA",hmHeader);
			hmData.put("COMMON_DATA",hmCommon);
			hmData.put("LANGUAGE_DATA",language_data);
			
			//String finalise_yn				=(String)tabData.get("finalized_yn");
			if(insertDetail.size()==0&& updateDetail.size()==0){
				System.err.println("===tabData===="+tabData);
				System.err.println("===stock_dtls===="+stock_dtls);
				System.err.println("===order_id===="+order_id);
				System.err.println("===prev_doc_no===="+prev_doc_no);
				System.err.println("====st_doc_type===="+st_doc_type);
				throw new EJBException("Stock updation failed in Dispensing");
			}
			if(insertDetail.size()!=0) {
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
					errod_id=(String)map.get("msgid");
					throw new EJBException("insert Sales failed");
				}
				else {
					String docno				=	(String)map.get("doc_no");
					String doctypecode			=	(String)map.get("doc_type_code");
					if(alSalDocDtls==null) //Added for AMS-CRF-0079 [IN:050762] -start
						alSalDocDtls = new ArrayList();
					if(!alSalDocDtls.contains(doctypecode+"-"+docno))
						alSalDocDtls.add(doctypecode+"-"+docno); //Added for AMS-CRF-0079 [IN:050762] -end
					pstmt_update_disp_hdr_tmp		=	null;
					//pstmt_update_disp_hdr_tmp		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_HRD_TMP_UPDATE") ) ;
					pstmt_update_disp_hdr_tmp	= connection.prepareStatement("UPDATE PH_DISP_HDR_TMP SET DOC_TYPE=?, DOC_NO=?, CERT_REIMB_NO =?WHERE ORDER_ID = ? AND FACILITY_ID= ?" ) ;
					 
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
					pstmt_update_disp_hdr_tmp.executeUpdate();
					if(((HashMap)tabData.get("seq_no")).containsKey(order_id)) {

						pstmt_update_disp_hdr_tmp		=	null;
						//pstmt_update_disp_hdr_tmp		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_HRD_UPDATE") ) ;
						pstmt_update_disp_hdr_tmp		= connection.prepareStatement( "UPDATE PH_DISP_HDR SET DOC_TYPE=?, DOC_NO=?,CERT_REIMB_NO =? WHERE DISP_NO = ? AND FACILITY_ID= ?") ;
						pstmt_update_disp_hdr_tmp.setString(1,doctypecode );
						pstmt_update_disp_hdr_tmp.setString(2,docno);  
						if(tabData.containsKey("CER_RES_NO")){
							 pstmt_update_disp_hdr_tmp.setString(3,(String)tabData.get("CER_RES_NO"));  
						}
						else{
							 pstmt_update_disp_hdr_tmp.setString(3,""); 
						}
						pstmt_update_disp_hdr_tmp.setString(4,(String)((HashMap)tabData.get("seq_no")).get(order_id));
						pstmt_update_disp_hdr_tmp.setString(5,(String)tabData.get("facility_id"));
						pstmt_update_disp_hdr_tmp.executeUpdate();
					}
					if(bl_interface_yn.equals("Y")&& finalised_yn.equals("Y")){
					   String admx_prep_charges_appl_yn  =(String)tabData.get("admx_prep_charges_appl_yn");
					   String admx_prep_charge_units	="";	
						if(tabData.containsKey("admx_prep_charge_units")){
							admx_prep_charge_units = (String)tabData.get("admx_prep_charge_units");
						}			

						String admx_prep_charge_item_code	="";	
						if(tabData.containsKey("admx_prep_charge_item_code")){
							admx_prep_charge_item_code = (String)tabData.get("admx_prep_charge_item_code");
						}

						if(admx_prep_charges_appl_yn.equals("Y")){
						insertPreprationChargeDet(connection,tabData,patient_class_PC,doctypecode,docno,order_id,200,"N","",admx_prep_charge_units,";",admx_prep_charge_item_code);

						}
					  int doc_srl_no   = 0;
					  StringBuffer batch_str	 = new StringBuffer();
					  for(int n=0;n< spill_qty_dtls.size();n=n+7){
						  batch_str        = new StringBuffer();
						  doc_srl_no = 200+Integer.parseInt((String)spill_qty_dtls.get(n));

						/*spill_qty_dtls.add(rec_count+"");
						  spill_qty_dtls.add(disp_drug_code);
						  spill_qty_dtls.add(spill_qty_used);
						  spill_qty_dtls.add((String)arr_list_batch_dtls.get(7));//trade_id
						  spill_qty_dtls.add((String)arr_list_batch_dtls.get(1));//batch_id
						  spill_qty_dtls.add((String)arr_list_batch_dtls.get(2));//exp_date
						  spill_qty_dtls.add((String)arr_list_batch_dtls.get(6));//bin_loc_code
						 */	
						  batch_str.append(spill_qty_dtls.get(n+3)).append(";").append(spill_qty_dtls.get(n+4)).append(";").append(spill_qty_dtls.get(n+5)).append(";").append(spill_qty_dtls.get(n+6)).append(";").append(spill_qty_dtls.get(n+2)).append(";");
						  insertPreprationChargeDet(connection,tabData,patient_class_PC,doctypecode,docno,order_id,doc_srl_no,"N","",(String)spill_qty_dtls.get(n+2),batch_str.toString(),(String)spill_qty_dtls.get(n+1));
			
						}
					}
				}
			}
			if(updateDetail.size()!=0) {
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

				hmHeader.put("doc_no",prev_doc_no);
				hmHeader.put("doc_type_code",st_doc_type);
				hmData.put("HDR_DATA",hmHeader);
				hmData.put("DTL_DATA",updateDetail);
				hmData.put("DTL_EXP_DATA",updateExp);
				eST.Common.StSales	stSales	=	new eST.Common.StSales();
				HashMap map					=	stSales.updateSales(connection,hmData);

				if( !(((Boolean) map.get( "result" )).booleanValue()) )	{
					connection.rollback();
					errod_id=(String)map.get("msgid");
					throw new EJBException("update Sales failed");
				} 
				else {
					if(alSalDocDtls==null)//Added for AMS-CRF-0079 [IN:050762] -start
						alSalDocDtls = new ArrayList();
					if(!alSalDocDtls.contains(st_doc_type+"-"+prev_doc_no))
						alSalDocDtls.add(st_doc_type+"-"+prev_doc_no); //Added for AMS-CRF-0079 [IN:050762] -end
					pstmt_update_disp_hdr_tmp		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_HRD_TMP_UPDATE") ) ;
					pstmt_update_disp_hdr_tmp.setString(1,st_doc_type);
					pstmt_update_disp_hdr_tmp.setString(2,prev_doc_no);
					pstmt_update_disp_hdr_tmp.setString(3,order_id);
					pstmt_update_disp_hdr_tmp.setString(4,(String)tabData.get("facility_id"));
					pstmt_update_disp_hdr_tmp.executeUpdate();
					// uncomment the foll code while doing allocate-fill-thru all stages
					/*
					if(((HashMap)tabData.get("seq_no")).containsKey(order_id)) {
						pstmt_update_disp_hdr_tmp		=	null;
						pstmt_update_disp_hdr_tmp		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_HRD_UPDATE") ) ;
						pstmt_update_disp_hdr_tmp.setString(1,st_doc_type );
						pstmt_update_disp_hdr_tmp.setString(2,prev_doc_no);  
						pstmt_update_disp_hdr_tmp.setString(3,((HashMap)tabData.get("seq_no")).get(order_id));
						pstmt_update_disp_hdr_tmp.setString(4,(String)tabData.get("facility_id"));
						pstmt_update_disp_hdr_tmp.executeUpdate();
					}*/
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			//throw new EJBException("Stock updation failed in Dispensing");
			throw new EJBException(errod_id);
		}
		finally{
			try{
				closeStatement(pstmt_update_disp_hdr_tmp);
				pstmt_update_disp_hdr_tmp=null;
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}

//this function is used to insert data into bl_patient_charges_folio for prepration charge details

	private void insertPreprationChargeDet(Connection connection,HashMap tabData,String sal_trn_type,String doc_type_code,String docno,String order_id,int doc_srl_no,String delete_sales_yn,String old_srl_no,String req_qty,String Batch_str,String item_code) throws Exception{
		CallableStatement callableStatement = null;					
		try {
			String token_series_code="";
			String token_serial_no  ="";
			HashMap token_vals      =   (HashMap)tabData.get("token_vals");
			String[] strTokenTemp					  = new String[2];//Added for HSA-CRF-0136 [IN:048412]
			if(token_vals.containsKey((order_id).trim())) {
				//token_series_code= (String)tabData.get("token_series_code");
				//token_serial_no  =(String)token_vals.get((order_id).trim());
				strTokenTemp = ((String)token_vals.get((order_id).trim())).split("_");//Changed for HSA-CRF-0136 [IN:048412]
				token_series_code = strTokenTemp[0];//Changed for HSA-CRF-0136 [IN:048412]
				token_serial_no	  =	strTokenTemp[1];//Changed for HSA-CRF-0136 [IN:048412]
			}
			callableStatement	= connection.prepareCall("{ call ST_SAL_BL_POST_CHARGES_FOLIO (?,?,?,?,?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");

			callableStatement.setString(1, (String)tabData.get("facility_id"));
			callableStatement.setString(2, (String)tabData.get("patient_id"));
			callableStatement.setString(3, "PH");
			callableStatement.setString(4, (String)tabData.get("encounter_id"));
			callableStatement.setString(5, sal_trn_type);
			callableStatement.setString(6, doc_type_code);
			callableStatement.setInt(7, Integer.parseInt(docno) );
			callableStatement.setInt(8, doc_srl_no);
			callableStatement.setString(9, (String)tabData.get("today"));
			callableStatement.setString(10, item_code);
			callableStatement.setString(11, (String)tabData.get("store_code"));
			if(delete_sales_yn.equals("Y")){
				callableStatement.setFloat(12,(-1)* Float.parseFloat(req_qty) );
			}else{
				 callableStatement.setFloat(12, Float.parseFloat(req_qty) );
			}
			callableStatement.setString(13,Batch_str);
			callableStatement.setString(14,(String)tabData.get("login_at_ws_no"));						
			callableStatement.setString(15,"");						
			callableStatement.setString(16,"");// Overidden excl incl ind this is the defaulted value						
			callableStatement.setString(17,"");// this is a defaltuted value for the action reason code
			callableStatement.setString(18,token_series_code);	// these are being added for the Dispence Medication  from pH	
			callableStatement.setString(19,token_serial_no);// these are being added for the Dispence Medication  from pH		
			callableStatement.setString(20,(String)tabData.get("store_code"));// these are being added for the Dispence Medication  from pH					
			if(delete_sales_yn.equals("Y")){
				callableStatement.setString(21, doc_type_code);					
				callableStatement.setString(22, docno);		
				callableStatement.setString(23, old_srl_no);
				callableStatement.setString(24, "Y");//Internal Adjustment
			}
			else{
				callableStatement.setString(21,null);
				callableStatement.setString(22,null);
				callableStatement.setString(23,null);
				callableStatement.setString(24,"N");//Internal Adjustment
			}					
			callableStatement.setString(25,getDischargeYN( connection, order_id));//Internal Adjustment
			callableStatement.registerOutParameter(26, Types.VARCHAR);
			callableStatement.registerOutParameter(27, Types.VARCHAR);
			callableStatement.registerOutParameter(28, Types.VARCHAR);
			callableStatement.setString(29,"");	
			if(delete_sales_yn.equals("Y")){
				 callableStatement.setString(30, "Y");//For delete sales
			}
			else{
				 callableStatement.setString(30, "N");
			}
			callableStatement.execute();

		}
		catch(Exception e){
			e.printStackTrace();
			throw new EJBException("Error: insert Preparation charge into Billing folio failed");
	   }
	   finally{	
			try {
			   closeStatement( callableStatement );
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
	}

	/*private void deletesales(Connection connection,HashMap tabData,ArrayList dispTMP,HashMap prev_doc_no,String st_doc_type,HashMap stock_srl) throws Exception{
		try {
			HashMap hmPKData		=	new HashMap();
			HashMap hmCommon		=	new HashMap();
			HashMap hmData			=	new HashMap();
			String order_id			=	null;
			String docno			=	null;
			String old_oreder_id	=	"";	
			hmCommon.put("login_by_id",(String)tabData.get("login_by_id"));
			hmCommon.put("login_at_ws_no",(String)tabData.get("login_at_ws_no"));
			hmCommon.put("login_facility_id",(String)tabData.get("facility_id"));
			for(int i=0;i<dispTMP.size();i=i+7){
				order_id	   =(String)dispTMP.get(i);
					ArrayList batchDetails = (ArrayList)dispTMP.get(i+6);
					if(batchDetails.size()>0){						

						if(prev_doc_no.containsKey(order_id)){
							if(!old_oreder_id.equals(order_id)){
							docno		=	(String)prev_doc_no.get(order_id);
						    hmPKData	=	new HashMap();

							hmPKData.put("facility_id",(String)tabData.get("facility_id"));
							hmPKData.put("doc_no",docno);
							hmPKData.put("doc_type_code",st_doc_type);					
							
							hmData.put("COMMON_DATA",hmCommon);			
							hmData.put("DATA",hmPKData);
							eST.Common.StSales	stSales	=	new eST.Common.StSales();
							HashMap map					=	stSales.deleteSales(connection,hmData);
							if( !(((Boolean) map.get( "result" )).booleanValue()) )	{
							   connection.rollback();
							   throw new Exception("delete Sales failed");
							}
						}
						}
					  }
					old_oreder_id=	order_id;
					order_id="";
			  }
			}catch(Exception e){
			e.printStackTrace();
			throw new EJBException("Error: DELETING sales failed");
		}finally{	
				try {
				}
				catch(Exception es) {
					es.printStackTrace();
				}
		}
	}*/
	private void deletesales(Connection connection,HashMap tabData,ArrayList dispTMP,HashMap prev_doc_no,String st_doc_type, HashMap sqlMap,HashMap stock_srl) throws Exception{
		try {
			HashMap hmPKData		=	new HashMap();
			HashMap hmCommon		=	new HashMap();
			HashMap hmData			=	new HashMap();
			HashMap bl_Detail		=	new HashMap();
			String order_id			=	null;
			String order_line_num	=	null;
			String docno			=	null;
			String old_oreder_id	=	"";	
			String p_overridden_det = "";
			String p_overridden_excl_incl_ind = "";
			String p_overridden_action_reason = "";
			hmCommon.put("login_by_id",(String)tabData.get("login_by_id"));
			hmCommon.put("login_at_ws_no",(String)tabData.get("login_at_ws_no"));
			hmCommon.put("login_facility_id",(String)tabData.get("facility_id"));
			hmCommon.put("FACILITY_STR_FOR_BL",(String)tabData.get("ordering_facility_id")+"|"+(String)tabData.get("facility_id"));
		    HashMap token_vals       =   (HashMap)tabData.get("token_vals");
            HashMap al_bl_data	     =	 new HashMap();	
			String[] strTokenTemp					  = new String[2];//Added for HSA-CRF-0136 [IN:048412]
		    //String doc_srl_no		 =	 "";

           if(dispTMP.size()>0){
				for(int i=0;i<dispTMP.size();i=i+7){
					p_overridden_excl_incl_ind = "";
					p_overridden_action_reason = "";
					order_id	               = (String)dispTMP.get(i);			
					order_line_num	    =(String)dispTMP.get(i+1);
					p_overridden_det = getBlInclExclDetail(connection, order_id, order_line_num,sqlMap);
					if(p_overridden_det!=null && !p_overridden_det.equals("")){
						p_overridden_excl_incl_ind = p_overridden_det.substring(0,1);
						p_overridden_action_reason = p_overridden_det.substring(p_overridden_det.indexOf(":")+1);
					}                
					ArrayList batchDetails = (ArrayList)dispTMP.get(i+6);
					if(batchDetails.size()>0){						
						if(prev_doc_no.containsKey(order_id)){
							docno		=	(String)prev_doc_no.get(order_id);
							bl_Detail	=	new HashMap();
						   
							bl_Detail.put("disp_item_code",(String)dispTMP.get(i+3));
							bl_Detail.put("p_overridden_excl_incl_ind",p_overridden_excl_incl_ind);
							bl_Detail.put("p_overridden_action_reason",p_overridden_action_reason);
							//bl_Detail.put("token_series_code",(String)tabData.get("token_series_code"));
							//bl_Detail.put("token_serial_no",(String)token_vals.get((order_id).trim()));	
							if(token_vals!=null && token_vals.size()>0){ //Added if condition and else block for [IN:049206]
								strTokenTemp = ((String)token_vals.get(order_id)).split("_");//Added for HSA-CRF-0136 [IN:048412]
								bl_Detail.put("token_series_code",strTokenTemp[0]);//Changed for HSA-CRF-0136 [IN:048412]
								bl_Detail.put("token_serial_no",strTokenTemp[1]);	//Changed for HSA-CRF-0136 [IN:048412]
							}
							else{ //else block Added for [IN:049206]
								bl_Detail.put("token_series_code","");
								bl_Detail.put("token_serial_no","");
							}
							al_bl_data.put(docno+stock_srl.get(order_id+((String)dispTMP.get(i+3)).trim()),bl_Detail);		
						}
					}					
				}
				for(int i=0;i<dispTMP.size();i=i+7){
					p_overridden_excl_incl_ind = "";
					p_overridden_action_reason = "";
					order_id	        =(String)dispTMP.get(i);
					order_line_num	    =(String)dispTMP.get(i+1);
					/*p_overridden_det = getBlInclExclDetail(connection, order_id, order_line_num,sqlMap);
					if(p_overridden_det!=null && !p_overridden_det.equals(":")){
						p_overridden_excl_incl_ind = p_overridden_det.substring(0,p_overridden_det.indexOf(":")-1);
						p_overridden_action_reason = p_overridden_det.substring(p_overridden_det.indexOf(":")+1);
					}   */             
					ArrayList batchDetails = (ArrayList)dispTMP.get(i+6);
					if(batchDetails.size()>0){						
						if(prev_doc_no.containsKey(order_id)){
							if(!old_oreder_id.equals(order_id)){
								docno		=	(String)prev_doc_no.get(order_id);
								hmPKData	=	new HashMap();
								//bl_Detail	=	new HashMap();
								hmPKData.put("facility_id",(String)tabData.get("facility_id"));
								hmPKData.put("doc_no",docno);
								hmPKData.put("doc_type_code",st_doc_type);	
								/*bl_Detail.put("disp_item_code",(String)dispTMP.get(i+3));
								bl_Detail.put("p_overridden_excl_incl_ind",p_overridden_excl_incl_ind);
								bl_Detail.put("p_overridden_action_reason",p_overridden_action_reason);
								bl_Detail.put("token_series_code",(String)tabData.get("token_series_code"));
								bl_Detail.put("token_serial_no",(String)token_vals.get((order_id).trim()));	*/
								//bl_Detail  =(HashMap)al_bl_data.get(order_id+((String)dispTMP.get(i+3)).trim());
								hmData.put("COMMON_DATA",hmCommon);			
								hmData.put("DATA",hmPKData);
								hmData.put("BL_DETAIL",al_bl_data);
								eST.Common.StSales	stSales	=	new eST.Common.StSales();
								HashMap map					=	stSales.deleteSales(connection,hmData);
								if( !(((Boolean) map.get( "result" )).booleanValue()) )	{
								   connection.rollback();
								   throw new Exception("delete Sales failed");
								}
							}
						}
					}
					old_oreder_id =	order_id;
					order_id = "";
				}
				order_id	=(String)dispTMP.get(0);
				docno		=(String)prev_doc_no.get(order_id); 

				String billing_interface_yn = (String)tabData.get("billing_interface_yn");
				ArrayList mfg_unit_details  = (ArrayList)tabData.get("mfg_unit_details");
				String finalised_yn		  = ((String)mfg_unit_details.get(6)).trim();
				String patient_class =(String)tabData.get("patient_class");

				if(prev_doc_no.containsKey(order_id) && billing_interface_yn.equals("Y")&&finalised_yn.equals("Y")&&patient_class.equals("O")){
					 String admx_prep_charges_appl_yn  =(String)tabData.get("admx_prep_charges_appl_yn");
					 if(admx_prep_charges_appl_yn.equals("Y")){
						 String old_mark_up_down           =(String)tabData.get("old_mark_up_down");					
						 String admx_prep_charge_item_code	="";	
						 if(tabData.containsKey("admx_prep_charge_item_code")){
							admx_prep_charge_item_code = (String)tabData.get("admx_prep_charge_item_code");
						 }
						 insertPreprationChargeDet(connection,tabData,(String)tabData.get("bl_patient_class"),st_doc_type,docno,order_id,300,"Y","200",old_mark_up_down,";",admx_prep_charge_item_code);
					}
					//in BL_PATIENT_CHARGES_INTERFACE  table for reversal entries srl_no starts from 300 and prepration charges,spillage entries srl_no starts from 200
					 String charge_pat_for_spill_qty_yn="";
					if(tabData.containsKey("charge_pat_for_spill_qty_yn")){
						charge_pat_for_spill_qty_yn = (String)tabData.get("charge_pat_for_spill_qty_yn");
					}
		   
					if(!tabData.get("worksheet_id").equals("")&&charge_pat_for_spill_qty_yn.equals("Y")){
						ArrayList spill_qty_dtls =(ArrayList)getSpillQtyDtls(connection,sqlMap,tabData);
						StringBuffer batch_str	  = new StringBuffer();

						for(int n=0;n< spill_qty_dtls.size();n=n+7){
							batch_str        = new StringBuffer();
							/*spill_qty_dtls.add(rec_count+"");
							spill_qty_dtls.add(disp_drug_code);
							spill_qty_dtls.add(spill_qty_used);
							spill_qty_dtls.add((String)arr_list_batch_dtls.get(7));//trade_id
							spill_qty_dtls.add((String)arr_list_batch_dtls.get(1));//batch_id
							spill_qty_dtls.add((String)arr_list_batch_dtls.get(2));//exp_date
							spill_qty_dtls.add((String)arr_list_batch_dtls.get(6));//bin_loc_code */	
							batch_str.append(spill_qty_dtls.get(n+3)).append(";").append(spill_qty_dtls.get(n+4)).append(";").append(spill_qty_dtls.get(n+5)).append(";").append(spill_qty_dtls.get(n+6)).append(";").append(spill_qty_dtls.get(n+2)).append(";");
							insertPreprationChargeDet(connection,tabData,(String)tabData.get("bl_patient_class"),st_doc_type,docno,order_id,Integer.parseInt((String)spill_qty_dtls.get(n))+300,"Y",(Integer.parseInt((String)spill_qty_dtls.get(n))+200)+"",(String)spill_qty_dtls.get(n+2),batch_str.toString(),(String)spill_qty_dtls.get(n+1));
						}
					}
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
			throw new EJBException("Error: DELETING sales failed");
		}
	}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap modifyManufacturLabel(HashMap tabData,HashMap sqlMap ) {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		final String SQL_PH_DISP_MEDICATION_MFCTR_UPDATE1		    = (String) sqlMap.get( "SQL_PH_DISP_MEDICATION_MFCTR_UPDATE1" );
		final String SQL_PH_TPN_WORKSHEET_HDR_UPDATE1				= (String) sqlMap.get( "SQL_PH_TPN_WORKSHEET_HDR_UPDATE1" );
		prop					= (Properties)tabData.get( "properties" );		
		String facility_id			= (String)tabData.get("facility_id");
		String disp_locn			= (String)tabData.get("disp_locn");
		String worksheet_id			= (String)tabData.get("worksheet_id");
		String mfg_unit				= (String)tabData.get("mfg_unit");
		String batch_id			    = (String)tabData.get("batch_id");
		String expiry_date			= (String)tabData.get("expiry_date");
		String qty_volume			= (String)tabData.get("qty_volume");
		String qty_uom				= (String)tabData.get("qty_uom");
		String ord_type				= (String)tabData.get("ord_type");
		if(ord_type==null) ord_type="";
        String Admin_Inst			= (String)tabData.get("Admin_Instruction");
		String infusion_line		="";
		HashMap approvalNo          = (HashMap)tabData.get("approvalNo");//AAKH-CRF-0117
		String approval_no  = ""; //AAKH-CRF-0117
		if(ord_type.equals("TA")){
			 infusion_line			= (String)tabData.get("infusion_line");
		}
		Connection connection		= null ;
		PreparedStatement pstmt_update_ph_worksheet_hdr   = null;
		ResultSet	resultSet							  = null;

		try{
			connection = getConnection( prop ) ;
			if(ord_type.equals("TA")){
				pstmt_update_ph_worksheet_hdr  = connection.prepareStatement( SQL_PH_TPN_WORKSHEET_HDR_UPDATE1 ) ;
			}
			else {
				pstmt_update_ph_worksheet_hdr  = connection.prepareStatement( SQL_PH_DISP_MEDICATION_MFCTR_UPDATE1 ) ;
			}
			int count = 1;
			pstmt_update_ph_worksheet_hdr.setString(count,mfg_unit);	
			pstmt_update_ph_worksheet_hdr.setString(++count,batch_id);
			pstmt_update_ph_worksheet_hdr.setString(++count,expiry_date);
			pstmt_update_ph_worksheet_hdr.setString(++count,qty_volume);
			pstmt_update_ph_worksheet_hdr.setString(++count,qty_uom);
			pstmt_update_ph_worksheet_hdr.setString(++count,(String)tabData.get("login_by_id"));
			pstmt_update_ph_worksheet_hdr.setString(++count,(String)tabData.get("login_at_ws_no"));
			pstmt_update_ph_worksheet_hdr.setString(++count,(String)tabData.get("login_facility_id"));
            pstmt_update_ph_worksheet_hdr.setString(++count,Admin_Inst);
			if(ord_type.equals("TA")){
				pstmt_update_ph_worksheet_hdr.setString(++count,infusion_line);
			}
			pstmt_update_ph_worksheet_hdr.setString(++count,facility_id);
			pstmt_update_ph_worksheet_hdr.setString(++count,disp_locn);
			pstmt_update_ph_worksheet_hdr.setString(++count,worksheet_id);
			if(ord_type.equals("TA")){   //added for AAKH-CRF-0117 - start
				
				if(approvalNo!=null && approvalNo.size()>0)
					approval_no = (String)approvalNo.get((String)tabData.get("order_id"));
System.err.println("approval_no====2568==>"+approval_no);
					if(approval_no==null)
						approval_no = "";
				pstmt_update_ph_worksheet_hdr.setString(++count,approval_no);
				 //added for AAKH-CRF-0117 - end
			}
			int ph_worksheet_hdr_result=pstmt_update_ph_worksheet_hdr.executeUpdate();
			if(ph_worksheet_hdr_result < 0){
				throw new EJBException("Insert Failed");
			}
			connection.commit();
			map.put("result", new Boolean( true) ) ;
			map.put("msgid","RECORD_MODIFIED");
			map.put("flag","1");
		
		}
		catch(Exception e){
			e.printStackTrace();
			map.put("flag","0");
		}
		finally{
			try{
				connection.rollback();
				closeResultSet( resultSet ) ;
				closeStatement( pstmt_update_ph_worksheet_hdr ) ;
				resultSet=null;
				pstmt_update_ph_worksheet_hdr=null;
				closeConnection( connection,prop );
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return map;
	}

	//update or_order_line_ph
	private void updateOrOrderLinePh(Connection connection, HashMap sqlMap, HashMap tabData,ArrayList orderLineData, ArrayList orderLineData1,HashMap complte_order_reasons ) throws Exception {
		PreparedStatement pstmt_update_order_line_ph  =	null;
		PreparedStatement pstmt_update_order_line_ph_2=	null;
		
		try {
			pstmt_update_order_line_ph  = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_LINE_PH_UPDATE") ) ;	
			pstmt_update_order_line_ph_2= connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_LINE_PH_UPDATE2") ) ;
			for(int i=0;i<orderLineData1.size();i=i+3){
				pstmt_update_order_line_ph.setString(1,(String)orderLineData1.get(i)==""?null:(String)orderLineData1.get(i));	
				pstmt_update_order_line_ph.setString(2,((String)orderLineData1.get(i+1)).trim());	
				pstmt_update_order_line_ph.setString(3,((String)orderLineData1.get(i+2)).trim());	
				pstmt_update_order_line_ph.addBatch();
				
			}			
			try{
				int[] result1=pstmt_update_order_line_ph.executeBatch();
				for (int i=0;i<result1.length ;i++ ){
					if(result1[i]<0  && result1[i] != -2 ){
						pstmt_update_order_line_ph.cancel();
						connection.rollback();
						throw new EJBException("order line PH update Failed");
					}	
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
				
			String complete_order_reason   =  "", key="";	 
		    for(int i=0;i<orderLineData.size();i=i+6){						
				key = ((String)orderLineData.get(i+3)).trim()+((String)orderLineData.get(i+4)).trim();
				if( complte_order_reasons.containsKey(key)){							 
					complete_order_reason   =  (String) complte_order_reasons.get(key);
				}
				else{
					complete_order_reason   =  "";
				}
				pstmt_update_order_line_ph_2.setString(1,complete_order_reason);							
				pstmt_update_order_line_ph_2.setString(2,((String)orderLineData.get(i+3)).trim());	
				pstmt_update_order_line_ph_2.setString(3,((String)orderLineData.get(i+4)).trim());	
				pstmt_update_order_line_ph_2.addBatch();  
			}
		   if(pstmt_update_order_line_ph_2 != null){
				int result[] = pstmt_update_order_line_ph_2.executeBatch();
				for (int i=0;i<result.length ;i++ ){		// A number greater than or equal to zero  indicates success
						// A number -2 indicates that command is successful but number of rows updated is unknow
						// If it won't satisfy any of the above cancel the statement and throw an exception
					if(result[i]<0  && result[i] != -2 ){
						pstmt_update_order_line_ph_2.cancel();
						connection.rollback();
						throw new EJBException(" work sheet Update completeorder reason  :OR_ORDER_LINE_PH failed");
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
				closeStatement( pstmt_update_order_line_ph ) ;
				closeStatement(pstmt_update_order_line_ph_2);
			}
			catch(Exception es) {
				es.printStackTrace();
			}
	   }
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
		}
		catch ( Exception e ) {
            e.printStackTrace() ;
		}
		finally {
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

	private ArrayList getSpillQtyDtls(Connection connection, HashMap sqlMap,HashMap tabData){
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		ArrayList spill_qty_dtls    = new ArrayList();
		
		try{
			pstmt					= connection.prepareStatement((String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT169")) ;
			pstmt.setString(1,(String)tabData.get("facility_id"));
			pstmt.setString(2,(String)tabData.get("disp_locn_code"));
			pstmt.setString(3,(String)tabData.get("worksheet_id"));
			resultSet				= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ){
				spill_qty_dtls.add(resultSet.getString("WS_SRL_NO"));
				spill_qty_dtls.add(resultSet.getString("DISP_DRUG_CODE"));
				spill_qty_dtls.add(resultSet.getString("SPIL_QTY_AVAIL"));
				spill_qty_dtls.add(resultSet.getString("TRADE_ID1"));//trade_id
				spill_qty_dtls.add(resultSet.getString("BATCH_ID1"));//batch_id
				spill_qty_dtls.add(resultSet.getString("EXPIRY_DATE1"));//exp_date
				spill_qty_dtls.add(resultSet.getString("BIN_LOCATION_CODE1"));//bin_loc_code
			}
		}
		catch ( Exception e ) {
            e.printStackTrace() ;
		}
		finally {
            try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				//closeConnection( connection );
            }
			catch(Exception es){
				es.printStackTrace();
			}
        }
		return spill_qty_dtls;
	}

	public String getDischargeYN(Connection connection,String order_id){
		//Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String sDischargeYN		= "N";
		try {
          //  pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT161")) ;
			pstmt		= connection.prepareStatement( "select decode(DISCHARGE_IND,'D','Y','N') DISCHARGE_IND from or_order where order_id =?") ;
			pstmt.setString(1,order_id);
            resultSet	= pstmt.executeQuery() ;
			
			if (resultSet.next()){
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
		return sDischargeYN;
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
		catch ( Exception e ) {
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

	private HashMap getDecimalAllowedYN(String sItemCodes){
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
			catch ( Exception e ) {
				e.printStackTrace() ;
			}
		}
		return hmDecimalAllowedYN.size()==0?null:hmDecimalAllowedYN;
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
			pstmt_insert_cons_drug_dtl	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_INSERT_PH_DISP_CONS_DTL") ) ;

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
					throw new EJBException("Consumable Details Failed");
				}		
			}  
		}
		catch(Exception e){
			e.printStackTrace();
			//try {
			connection.rollback();
			throw new EJBException("Consumable  Details Failed");
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
			pstmt_insert_cons_drug_batch	= connection.prepareStatement((String)sqlMap.get("SQL_PH_INSERT_DISP_CONS_BATCH") );
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
					throw new EJBException("Consumable Batch Failed");
				}		
			}  
		}
		catch(Exception e){
			e.printStackTrace();
			//try {
			connection.rollback();
			throw new EJBException("Consumable Batch Failed");
			//}catch(Exception es) { es.printStackTrace();}
		}
		finally{	
			try {
				closeStatement( pstmt_insert_cons_drug_batch) ;
				 pstmt_insert_cons_drug_batch=null;

			}catch(Exception es) { 
				es.printStackTrace();
			}
		}
	}/*==============================================ends here===============================*/

	private HashMap getBaseAndIssueUOMQty(Connection connection, String item_code, String store_code,String disp_qty, String disp_uom){/*=======code adeed for handling variable UOM===============*/
		PreparedStatement pstmt             = null ;
		ResultSet resultSet                 = null ;
		String base_uom						= "";
		String def_store_uom				= "";
		double  base_to_disp_uom_equl_value	= 0;
		double  base_to_def_uom_equl_value		= 0;
		HashMap BaseAndIssueQTYDetail		= new HashMap();
		double base_qty						= 0;
		double issue_qty					= 0;
		try{
			pstmt					= connection.prepareStatement("SELECT DEF_ISSUE_UOM,GEN_UOM_CODE FROM ST_ITEM_STORE a, mm_item b WHERE STOCK_ITEM_YN = 'Y' AND a.STORE_CODE = ? AND a.ITEM_CODE = ? AND a.EFF_STATUS = 'E'and b.EFF_STATUS='E' and a.item_code =b.item_code");
			pstmt.setString(1,store_code);
			pstmt.setString(2,item_code);
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				  base_uom		=	resultSet.getString("GEN_UOM_CODE");
				  def_store_uom	=	resultSet.getString("DEF_ISSUE_UOM");
			}
			base_to_disp_uom_equl_value	=	getEqulValue (connection, item_code, base_uom, disp_uom);
			base_to_def_uom_equl_value	=	getEqulValue (connection, item_code, base_uom, def_store_uom);
			base_qty   =	Double.parseDouble(disp_qty)*(base_to_disp_uom_equl_value);
			issue_qty  =	base_qty/base_to_def_uom_equl_value;
			BaseAndIssueQTYDetail.put("BASE_QTY",base_qty+"");
			BaseAndIssueQTYDetail.put("ISSUE_QTY",issue_qty+"");
		}
		catch ( Exception e ) {
            e.printStackTrace() ;
		}
		finally {
            try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			//closeConnection( connection );
            }
			catch(Exception es){
				es.printStackTrace();
			}
        }
		return BaseAndIssueQTYDetail;
	}

	public double getEqulValue (Connection connection,String item_code,String uom_code,String equl_uom_code){
		//Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		double eqvl_value			= 1;
		try {
            //pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT161")) ;
			//pstmt		= connection.prepareStatement( "select EQVL_VALUE from MM_ITEM_UOM_DEFN where ITEM_CODE=? and UOM_CODE =? and EQVL_UOM_CODE=?") ;
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
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return eqvl_value;
	}

	public String getCustomerID(Connection connection)throws Exception	{
        PreparedStatement pstmt		= null;
        ResultSet rsCustomerID		= null;
		String customer_id			= "";
		try {
			
			pstmt = connection.prepareStatement("SELECT CUSTOMER_ID FROM SM_SITE_PARAM WHERE SITE_ID = 'DS'");
			rsCustomerID = pstmt.executeQuery();
			if(rsCustomerID.next()){
				customer_id = rsCustomerID.getString("CUSTOMER_ID");
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

	public String getEssentialItemYN(Connection connection,String item_code)throws Exception	{
        PreparedStatement pstmt		= null;
        ResultSet rsCustomerID		= null;
		String essential_item_yn			= "";
		try {
			
			pstmt = connection.prepareStatement("select ESSENTIAL_ITEM_YN  from mm_item where item_code =?");
			pstmt.setString(1,item_code);

			rsCustomerID = pstmt.executeQuery();
			if(rsCustomerID.next()){
				essential_item_yn = rsCustomerID.getString("ESSENTIAL_ITEM_YN");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( rsCustomerID ) ;
			closeStatement( pstmt ) ;
		}
		return essential_item_yn;
	}

	public String GenerateCerRemNO (Connection connection)throws Exception	{
        CallableStatement cstmt	    = null;
       // ResultSet rsCustomerID		= null; Unused local variable 'rsCustomerID' from checkstyle INC63877
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

	private void updateWorksheetHdr(Connection connection ,String admx_prep_charge_units,String worksheet_id, String facility_id,String disp_locn_code) throws Exception {
		PreparedStatement pstmt_update_order_line_ph  =	null;
		try {
			pstmt_update_order_line_ph  = connection.prepareStatement( "update ph_worksheet_hdr set ADMX_PREP_CHARGE_UNITS =? where worksheet_id =? and DISP_LOCN =? and FACILITY_ID =?") ;	
			pstmt_update_order_line_ph.setString(1,admx_prep_charge_units);	
			pstmt_update_order_line_ph.setString(2,worksheet_id);	
			pstmt_update_order_line_ph.setString(3,disp_locn_code);	
			pstmt_update_order_line_ph.setString(4,facility_id);	
			pstmt_update_order_line_ph.executeUpdate();					
		}
		catch(Exception e){
			e.printStackTrace();
			throw new EJBException("Error: Worksheet Header updation failed");
	    }
		finally{	
			try {
				closeStatement( pstmt_update_order_line_ph ) ;
				
			}
			catch(Exception es) {
				es.printStackTrace();
			}
	   }
	}
}
