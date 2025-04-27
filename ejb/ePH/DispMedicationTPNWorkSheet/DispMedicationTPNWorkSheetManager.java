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
22/11/2019      IN070800        PRATHYUSHA                          ML-MMOH-SCF-1303
---------------------------------------------------------------------------------------------------------------
*/
package ePH.DispMedicationTPNWorkSheet ;

import java.rmi.* ;
import java.util.HashMap ;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.sql.* ;
import javax.ejb.* ;
import ePH.Common.PhEJBSessionAdapter ;
/**
*
* @ejb.bean
*	name="DispMedicationTPNWorkSheet"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="DispMedicationTPNWorkSheet"
*	local-jndi-name="DispMedicationTPNWorkSheet"
*	impl-class-name="ePH.DispMedicationTPNWorkSheet.DispMedicationTPNWorkSheetManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.DispMedicationTPNWorkSheet.DispMedicationTPNWorkSheetLocal"
*	remote-class="ePH.DispMedicationTPNWorkSheet.DispMedicationTPNWorkSheetRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.DispMedicationTPNWorkSheet.DispMedicationTPNWorkSheetLocalHome"
*	remote-class="ePH.DispMedicationTPNWorkSheet.DispMedicationTPNWorkSheetHome"
*	generate= "local,remote"
*
*
*/

public class DispMedicationTPNWorkSheetManager extends PhEJBSessionAdapter {

	Properties prop=null;
	HashMap stock_srl=new HashMap();
	HashMap stock_srl1=new HashMap();
	String worksheet_id	="";	
	String disp_locn_code="";	
	boolean bDecimalAllowedParamYN = false;
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
	// insert method ends here
	
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

   
    /**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap modify( HashMap tabData, HashMap sqlMap )  {

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;	
		alSalDocDtls = new ArrayList(); //Added for AMS-CRF-0079 [IN:050762]
		String disp_stage = (String)tabData.get("disp_stage");  
		try{
			if(disp_stage.equals("A")){
				map = completeAllocation(tabData,sqlMap);
			}else if(disp_stage.equals("F")){
				map = completeFilling(tabData,sqlMap);
			}
			else if(disp_stage.equals("D")){
				
				map = completeTPNDelivery(tabData,sqlMap);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return map;
		}
		map.put("SAL_DOC_DTLS", alSalDocDtls); //Added for AMS-CRF-0079 [IN:050762]
		return map;
	}


	public HashMap completeAllocation(HashMap tabData,HashMap sqlMap ) throws Exception{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;

		final String SQL_PH_DISP_MEDICATION_ORDER_LINE_UPDATE_FOR_WS		    = (String) sqlMap.get( "SQL_PH_DISP_MEDICATION_ORDER_LINE_UPDATE_FOR_WS" );
		final String SQL_PH_DISP_MEDICATION_PATIENT_DRUG_PROFILE_UPDATE_FOR_WS  = (String)sqlMap.get("SQL_PH_DISP_MEDICATION_PATIENT_DRUG_PROFILE_UPDATE_FOR_WS");
		final String SQL_PH_DISP_MEDICATION_ORDER_UPDATE						= (String)sqlMap.get("SQL_PH_DISP_MEDICATION_ORDER_UPDATE");
		final String SQL_PH_WORKSHEET_TPN_HDR_INSERT							= (String)sqlMap.get("SQL_PH_WORKSHEET_TPN_HDR_INSERT");
		final String SQL_PH_TPN_WORKSHEET_ID_COUNT								= (String)sqlMap.get("SQL_PH_TPN_WORKSHEET_ID_COUNT");
		final String SQL_PH_DISP_MEDICATION_DTL_COUNT							= (String)sqlMap.get("SQL_PH_DISP_MEDICATION_DTL_COUNT");
		final String SQL_PH_DISP_MEDICATION_HDR_DELETE1							= (String)sqlMap.get("SQL_PH_DISP_MEDICATION_HDR_DELETE1");
		final String SQL_PH_DISP_MEDICATION_DTL_DELETE1							= (String)sqlMap.get("SQL_PH_DISP_MEDICATION_DTL_DELETE1");
		final String SQL_PH_WORKSHEET_TPN_DTL_INSERT1							= (String)sqlMap.get("SQL_PH_WORKSHEET_TPN_DTL_INSERT1");
		final String SQL_PH_TPN_WORKSHEET_HDR_SELECT							= (String)sqlMap.get("SQL_PH_TPN_WORKSHEET_HDR_SELECT");
		final String SQL_PH_DISP_MEDICATION_PATIENT_DRUG_PROFILE_UPDATE_FOR_TPN_WS	= (String)sqlMap.get("SQL_PH_DISP_MEDICATION_PATIENT_DRUG_PROFILE_UPDATE_FOR_TPN_WS");
		
		prop  = (Properties)tabData.get( "properties" );		
		
		ArrayList orderLineData1		= (ArrayList)tabData.get("orderLineData1");
		String dateTime					= (String)tabData.get("dateTime");
		String facility_id				= (String)tabData.get("facility_id");
		String login_by_id				= (String)tabData.get("login_by_id");
		String login_at_ws_no			= (String)tabData.get("login_at_ws_no");
		 disp_locn_code					= (String)tabData.get("disp_locn_code");
		String patient_class			= (String)tabData.get("patient_class");
		String delivery_applicable		= (String)tabData.get("delivery_applicable");
		String ws_type					= (String)tabData.get("ws_type");
		String ws_status				= (String)tabData.get("ws_status");
		ArrayList orderLineData			= (ArrayList)tabData.get("orderLineData");
		ArrayList patientDrugProfileData= (ArrayList)tabData.get("patientDrugProfileData");
		ArrayList dispTMP				= (ArrayList)tabData.get("dispTMP");
		ArrayList TPNDetails			= (ArrayList)tabData.get("TPNDetails");
		ArrayList mfg_unit_details		= (ArrayList)tabData.get("mfg_unit_details");
		String overage_volume			= (String)tabData.get("overage_volume");
		if(overage_volume == null){overage_volume = "";}
		String overage_volume_uom		= (String)tabData.get("overage_volume_uom");
		if(overage_volume_uom == null){overage_volume_uom = "";}
		String osmolarity_volume		= (String)tabData.get("osmolarity_volume");
		String approval_no = "";//AAKH-CRF-0117
		HashMap approvalNo	=  (HashMap)tabData.get("approvalNo");//AAKH-CRF-0117
		if(osmolarity_volume == null){osmolarity_volume = "";}
		
		Connection connection			= null ;
		PreparedStatement pstmt_update_order_line   = null,pstmt_update_patient_drug_profile=null,pstmt_update_order=null ;
		PreparedStatement pstmt_insert_disp_hrd_tmp = null,pstmt_insert_disp_drug_batch_tmp=null,pstmt_insert_disp_dtl_tmp=null;
		PreparedStatement pstmt_disp_dtl_ws		= null,pstmt_disp_hdr_delete=null,pstmt_disp_dtl_delete		=	null;
		PreparedStatement pstmt_disp_batch_delete	= null;
		PreparedStatement pstmt_worksheet_tpn_hdr_insert= null,pstmt_worksheet_tpn_hdr_select= null,pstmt_worksheet_tpn_dtls_insert=null;
		ResultSet resultSet = null;
		ResultSet ResultSet1= null;
		boolean orderUpdate				= true;
		String update_string			= "";	
		String error_id="";
		
		String disp_stage = (String)tabData.get("disp_stage");  
		if(disp_stage.equals("A") )
			update_string	=	"AL";
		else if(disp_stage.equals("F") )
			update_string	=	"IP";
			
		HashMap complte_order_reasons = (HashMap)tabData.get("complte_order_reason"); // Added below condition for CRF-PH- Bru-HIMS-CRF-087/12 -TPN  IN#38706  
		if(complte_order_reasons.size()>0)
			update_string = "DF";
		if(((String)orderLineData.get(0)).equals("Y")){	
				update_string = "HD";
		}

		try{
			connection = getConnection( prop ) ;
			setDecimalAllowedParamYN(connection);
			
			// Update the table or_order_line
			pstmt_update_order_line = connection.prepareStatement( SQL_PH_DISP_MEDICATION_ORDER_LINE_UPDATE_FOR_WS ) ;
			if(((String)orderLineData.get(0)).equals("Y")){	// If prescription is on hold.
				pstmt_update_order_line.setString(1,"HD");											//ORDER_LINE_STATUS       
				pstmt_update_order_line.setString(2,(String)orderLineData.get(1));					//HOLD_PRACT_ID           
				pstmt_update_order_line.setString(3,dateTime.trim());								//HOLD_DATE_TIME          
				pstmt_update_order_line.setString(4,"HD");											//LAST_ACTION_TYPE        
				pstmt_update_order_line.setString(5,((String)orderLineData.get(2)).trim());			//LAST_ACTION_REASON_DESC 
				pstmt_update_order_line.setString(6,((String)orderLineData.get(2)).trim());			//CAN_LINE_REASON added newly for the ML-BRU-SCF-0184 by SureshKumar T on 07/06/2012
				orderUpdate = false;
			}
			else if(((String)orderLineData.get(0)).equals("N")){		// If prescription is Allocated.
				pstmt_update_order_line.setString(1,update_string);									//ORDER_LINE_STATUS       
				pstmt_update_order_line.setString(2,"");											//HOLD_PRACT_ID           
				pstmt_update_order_line.setString(3,"");											//HOLD_DATE_TIME          
				pstmt_update_order_line.setString(4,"");											//LAST_ACTION_TYPE        
				pstmt_update_order_line.setString(5,"");											//LAST_ACTION_REASON_DESC 
				pstmt_update_order_line.setString(6,"");											//CAN_LINE_REASON added newly for the ML-BRU-SCF-0184 by SureshKumar T on 07/06/2012
			}

			pstmt_update_order_line.setString(7,login_by_id);							// modified id
			pstmt_update_order_line.setString(8,facility_id);							// modified facility
			pstmt_update_order_line.setString(9,login_at_ws_no);						// modified work station
			pstmt_update_order_line.setString(10,((String)orderLineData.get(3)).trim());	//ORDER_ID
			pstmt_update_order_line.executeUpdate();

			pstmt_disp_dtl_ws	= connection.prepareStatement( SQL_PH_DISP_MEDICATION_DTL_COUNT ) ;
			pstmt_disp_dtl_ws.setString(1,((String)orderLineData.get(3)).trim());
			pstmt_disp_dtl_ws.setString(2,"1");
			
			resultSet = pstmt_disp_dtl_ws.executeQuery() ; 
			String Ws_Id	=	"";
			String doc_no="";
			String doc_type="";
	        if ( resultSet.next() ) {
				Ws_Id	=	resultSet.getString("TPN_WORKSHEET_ID");
			}
			if(Ws_Id==null) 
				Ws_Id="";
		
			if(!Ws_Id.equals("")) {
				pstmt_disp_hdr_delete				= connection.prepareStatement( SQL_PH_DISP_MEDICATION_HDR_DELETE1 ) ;
				pstmt_disp_dtl_delete				= connection.prepareStatement( SQL_PH_DISP_MEDICATION_DTL_DELETE1 ) ;
				pstmt_worksheet_tpn_hdr_select		= connection.prepareStatement( SQL_PH_TPN_WORKSHEET_HDR_SELECT ) ;
				pstmt_worksheet_tpn_hdr_select.setString(1,Ws_Id);
				pstmt_worksheet_tpn_hdr_select.setString(2,facility_id);
				pstmt_worksheet_tpn_hdr_select.setString(3,disp_locn_code);
				ResultSet1=pstmt_worksheet_tpn_hdr_select.executeQuery() ; 
				if(ResultSet1.next()){
					doc_no=ResultSet1.getString("doc_no");
					doc_type=ResultSet1.getString("doc_type");
				}
				if(doc_no==null) 
					doc_no	="";
				if(doc_type==null) 
					doc_type="";
			
				pstmt_disp_dtl_delete.setString(1,facility_id);
				pstmt_disp_dtl_delete.setString(2,disp_locn_code	);
				pstmt_disp_dtl_delete.setString(3,Ws_Id);
				pstmt_disp_dtl_delete.setString(4,((String)orderLineData.get(3)).trim());
				pstmt_disp_dtl_delete.setString(5,"1");
				pstmt_disp_dtl_delete.executeUpdate();
				
				pstmt_disp_hdr_delete.setString(1,Ws_Id);
				pstmt_disp_hdr_delete.setString(2,facility_id);
				pstmt_disp_hdr_delete.setString(3,disp_locn_code	);
                pstmt_disp_hdr_delete.executeUpdate();
			
			
				HashMap hmPKData	=	new HashMap();
				HashMap hmCommon	=	new HashMap();
				HashMap hmData		=	new HashMap();
				hmCommon.put("login_by_id",(String)tabData.get("login_by_id"));
				hmCommon.put("login_at_ws_no",(String)tabData.get("login_at_ws_no"));
				hmCommon.put("login_facility_id",(String)tabData.get("facility_id"));
				hmCommon.put("FACILITY_STR_FOR_BL",(String)tabData.get("ordering_facility_id")+"|"+(String)tabData.get("facility_id"));
				hmPKData.put("facility_id",(String)tabData.get("facility_id"));
				hmPKData.put("doc_no",doc_no);
				hmPKData.put("doc_type_code",doc_type);	
				hmData.put("COMMON_DATA",hmCommon);			
				hmData.put("DATA",hmPKData);
		
				eST.Common.StSales	stSales	=	new eST.Common.StSales();
				HashMap map1				=	stSales.deleteSales(connection,hmData);

				if( !(((Boolean) map1.get( "result" )).booleanValue()) )	{
					connection.rollback();
					if(map1.get("message").toString().contains("ORA-00054")){
						//ORA-00054
						error_id ="Sales Error: Record Already In Use - It is used by Other User.Please Try again...";//RECORD_UPDATED_BY_OTH_USER
					}
					else{  
						error_id="Sales Error: " + map1.get("message");
					}
					throw new Exception(error_id);
					//throw new Exception("delete Sales failed");
				}	
				worksheet_id			        = Ws_Id;
			}
			else{
				worksheet_id			        = getWorkSheetID(connection, SQL_PH_TPN_WORKSHEET_ID_COUNT,facility_id,disp_locn_code);
			}

			// Update the ph_patient_drug_profile
			pstmt_update_patient_drug_profile = connection.prepareStatement( SQL_PH_DISP_MEDICATION_PATIENT_DRUG_PROFILE_UPDATE_FOR_WS ) ;
			if(((String)patientDrugProfileData.get(0)).equals("Y")){
				pstmt_update_patient_drug_profile.setString(1,dateTime.trim());									// ON_HOLD_DATE_TIME    
				pstmt_update_patient_drug_profile.setString(2,(String)patientDrugProfileData.get(1));			// ON_HOLD_BY_ID        
				pstmt_update_patient_drug_profile.setString(3,(String)patientDrugProfileData.get(2));			// ON_HOLD_REASON_CODE  
			}
			else {	// If prescription is allocated
				pstmt_update_patient_drug_profile.setString(1,"");												// ON_HOLD_DATE_TIME    
				pstmt_update_patient_drug_profile.setString(2,"");												// ON_HOLD_BY_ID        
				pstmt_update_patient_drug_profile.setString(3,"");												// ON_HOLD_REASON_CODE  
			}
			pstmt_update_patient_drug_profile.setString(4,login_by_id);		// modified id
			pstmt_update_patient_drug_profile.setString(5,facility_id);		// modified facility
			pstmt_update_patient_drug_profile.setString(6,login_at_ws_no);		// modified work station
			pstmt_update_patient_drug_profile.setString(7,((String)patientDrugProfileData.get(3)).trim());	// PATIENT_ID          
			pstmt_update_patient_drug_profile.setString(8,((String)patientDrugProfileData.get(4)).trim());	// ORIG_ORDER_ID       
			pstmt_update_patient_drug_profile.setString(9,facility_id.trim());									// FACILITY_ID         

			if(!ws_status.equals("I")){
				pstmt_update_patient_drug_profile.executeUpdate();
			}
            closeStatement( pstmt_update_patient_drug_profile ) ;  
			pstmt_update_patient_drug_profile=null;

			if(ws_status.equals("C")){
					// Update the table or_order
				pstmt_update_order = connection.prepareStatement( SQL_PH_DISP_MEDICATION_ORDER_UPDATE ) ;
				pstmt_update_order.setString(1,update_string);
				pstmt_update_order.setString(2,login_by_id);		// modified id
				pstmt_update_order.setString(3,facility_id);		// modified facility
				pstmt_update_order.setString(4,login_at_ws_no);		// modified work station
				pstmt_update_order.setString(5,((String)orderLineData.get(3)).trim());
				pstmt_update_order.executeUpdate();
			}
			else if(orderUpdate == false && (((String)orderLineData.get(0)).equals("Y"))){
					// Update the table or_order
				pstmt_update_order = connection.prepareStatement( SQL_PH_DISP_MEDICATION_ORDER_UPDATE ) ;
				pstmt_update_order.setString(1,"HD");
				pstmt_update_order.setString(2,login_by_id);		// modified id
				pstmt_update_order.setString(3,facility_id);		// modified facility
				pstmt_update_order.setString(4,login_at_ws_no);		// modified work station
				pstmt_update_order.setString(5,((String)orderLineData.get(3)).trim());
				pstmt_update_order.executeUpdate();
			}
			
			/*
				insert into disp_hrd_tmp table if delivery stage is applicable
				insert into disp_hrd table if delivery stage is not applicable
			*/
		
				if(delivery_applicable.equals("Y")){
					pstmt_worksheet_tpn_hdr_insert = connection.prepareStatement( SQL_PH_WORKSHEET_TPN_HDR_INSERT );
				//			pstmt_worksheet_tpn_hdr_insert = connection.prepareStatement( "INSERT INTO PH_TPN_WORKSHEET_HDR(FACILITY_ID, DISP_LOCN_CODE, TPN_WORKSHEET_ID, MFG_UNIT, WS_PREP_BY, PREP_DATE_TIME, WS_TYPE, WS_STATUS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, BATCH_ID, EXPIRY_DATE, QTY_VOLUME, QTY_UOM,ORDER_ID,ADMIN_INSTRUCTION,FINALIZED_YN,INFUSION_LINE,OVERAGE_VOLUME,OVERAGE_VOLUME_UOM) VALUES (?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,TO_DATE(?,'DD/MM/YYYY hh24:mi'),?,?,?,?,?,?,?,?)" );
					String admx_prep_charge_units	="";	
					if(tabData.containsKey("admx_prep_charge_units")){
						admx_prep_charge_units = (String)tabData.get("admx_prep_charge_units");
					}

					String admx_prep_charge_item_code	="";	
					if(tabData.containsKey("admx_prep_charge_item_code")){
						admx_prep_charge_item_code = (String)tabData.get("admx_prep_charge_item_code");
					}

					
					if(dispTMP.size()>0){
						int count = 1;
						ArrayList batchDetails =new ArrayList();
					
						for(int i=0;i<dispTMP.size();i=i+7){
							 batchDetails = (ArrayList)dispTMP.get(i+6);
						int number=1;		
						for (int j=0;j<batchDetails.size() ; j=j+10){ //9->10 for MMS-SCF-0040 [IN:041888]
							stock_srl.put(((String)dispTMP.get(0)).trim()+((String)batchDetails.get(j)).trim(),number+"");
							number++;
						}				
																				
						pstmt_worksheet_tpn_hdr_insert.setString(count,facility_id);	// FACILITY_ID     
						pstmt_worksheet_tpn_hdr_insert.setString(++count,disp_locn_code);	// DISP_LOCN 
						pstmt_worksheet_tpn_hdr_insert.setString(++count,worksheet_id);	// WORKSHEET_ID    
						pstmt_worksheet_tpn_hdr_insert.setString(++count,(((String)mfg_unit_details.get(0)).trim())==null?"":(((String)mfg_unit_details.get(0)).trim()));	// MFG_UNIT        
						pstmt_worksheet_tpn_hdr_insert.setString(++count,login_by_id);	// WS_PREP_BY 
						pstmt_worksheet_tpn_hdr_insert.setString(++count,ws_type);	// WS_TYPE             
						pstmt_worksheet_tpn_hdr_insert.setString(++count,ws_status);// WS_STATUS           
						pstmt_worksheet_tpn_hdr_insert.setString(++count,login_by_id);// ADDED_BY_ID       
						pstmt_worksheet_tpn_hdr_insert.setString(++count,login_at_ws_no);// ADDED_AT_WS_NO 
						pstmt_worksheet_tpn_hdr_insert.setString(++count,facility_id);// ADDED_FACILITY_ID 
						pstmt_worksheet_tpn_hdr_insert.setString(++count,login_by_id);// MODIFIED_BY_ID			
						pstmt_worksheet_tpn_hdr_insert.setString(++count,login_at_ws_no);// MODIFIED_AT_WS_NO      
						pstmt_worksheet_tpn_hdr_insert.setString(++count,facility_id);// MODIFIED_FACILITY_ID
						pstmt_worksheet_tpn_hdr_insert.setString(++count,((String)mfg_unit_details.get(1)).trim());	// BATCH_ID
						pstmt_worksheet_tpn_hdr_insert.setString(++count,((String)mfg_unit_details.get(2)).trim());// EXPIRY_DATE
						pstmt_worksheet_tpn_hdr_insert.setString(++count,((String)mfg_unit_details.get(3)).trim());	// QTY_VOLUME
						pstmt_worksheet_tpn_hdr_insert.setString(++count,((String)mfg_unit_details.get(4)).trim());	// QTY_UOM
						pstmt_worksheet_tpn_hdr_insert.setString(++count,((String)TPNDetails.get(i)).trim());	// ORDER_ID
						pstmt_worksheet_tpn_hdr_insert.setString(++count,((String)mfg_unit_details.get(5)).trim());	// ADMIN_INSTRUCTION
						pstmt_worksheet_tpn_hdr_insert.setString(++count,((String)mfg_unit_details.get(6)).trim());	// FINALIZED_YN
						pstmt_worksheet_tpn_hdr_insert.setString(++count,((String)mfg_unit_details.get(7)).trim());	// INFUSION_LINE
						pstmt_worksheet_tpn_hdr_insert.setString(++count,overage_volume); // OVERAGE_VOLUME
						pstmt_worksheet_tpn_hdr_insert.setString(++count,overage_volume_uom); // OVERAGE_VOLUME_UOM
						pstmt_worksheet_tpn_hdr_insert.setString(++count,osmolarity_volume); // OVERAGE_VOLUME_UOM

						pstmt_worksheet_tpn_hdr_insert.setString(++count,admx_prep_charge_item_code); // ADMX_PREP_CHARGE_ITEM_CODE
						pstmt_worksheet_tpn_hdr_insert.setString(++count,admx_prep_charge_units); // ADMX_PREP_CHARGE_UNITS
						//AAKH-CRF-0117 - start
						if(approvalNo!=null && approvalNo.size()>0)
						approval_no = (String)approvalNo.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim());

						if(approval_no==null)
						 approval_no = "";

						pstmt_worksheet_tpn_hdr_insert.setString(++count,approval_no);
						//AAKH-CRF-0117 - end
						pstmt_worksheet_tpn_hdr_insert.addBatch();																	
							//}
					}
				}
				int res[]=pstmt_worksheet_tpn_hdr_insert.executeBatch();
			
				for (int i=0;i<res.length ;i++ ){
					if(res[i]<0  && res[i] != -2 ){
					pstmt_worksheet_tpn_hdr_insert.cancel();
					connection.rollback();
					throw new EJBException("TPN worksheet updation  Failed");
					}
				}
						
				int counter=0;
				if(TPNDetails.size() >0) {
					int k=0;
					double tot_disp_qty =0;
					pstmt_insert_disp_hrd_tmp  = connection.prepareStatement( SQL_PH_WORKSHEET_TPN_DTL_INSERT1 ) ;
			//				pstmt_insert_disp_hrd_tmp  = connection.prepareStatement( "INSERT INTO PH_TPN_WORKSHEET_DTL(FACILITY_ID, DISP_LOCN, TPN_WORKSHEET_ID, CONST_GENERIC_CODE, WS_SRL_NO, ORDER_ID, ORDER_LINE_NUM, CONST_QTY, CONST_QTY_UNIT, DISP_ITEM_CODE, DISP_QTY, STOCK_UNIT, BATCH_ID1, EXPIRY_DATE1, BATCH1_QTY, BIN_LOCATION_CODE1, TRADE_ID1, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,DISP_QTY_UOM)Values(?,?,?,?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY'),?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)" ) ;

					int srl_no=1;
					double batch_qty = 0;
					for(int i=0;i<TPNDetails.size();i=i+14){
						counter=1;
						batch_qty = 0;
						pstmt_insert_disp_hrd_tmp.setString(counter,facility_id);	// FACILITY_ID         
						pstmt_insert_disp_hrd_tmp.setString(++counter,disp_locn_code);// DISP_LOCN    
						pstmt_insert_disp_hrd_tmp.setString(++counter,worksheet_id);//TPN_WORKSHEET_ID
						pstmt_insert_disp_hrd_tmp.setString(++counter,((String)TPNDetails.get(i+2)).trim());// CONST_GENERIC_CODE
						pstmt_insert_disp_hrd_tmp.setString(++counter,(srl_no)+"");	//ws_srl_no
						pstmt_insert_disp_hrd_tmp.setString(++counter,((String)TPNDetails.get(i)).trim());	//ORDER_ID
						pstmt_insert_disp_hrd_tmp.setString(++counter,((String)TPNDetails.get(i+1)).trim());// ORDER_LINE_NUM 
						pstmt_insert_disp_hrd_tmp.setString(++counter,((String)TPNDetails.get(i+3)).trim());// CONST_QTY          
						pstmt_insert_disp_hrd_tmp.setString(++counter,((String)TPNDetails.get(i+4)).trim());// CONST_QTY_UNIT    
						pstmt_insert_disp_hrd_tmp.setString(++counter,((String)TPNDetails.get(i+5)).trim());//DISP_ITEM_CODE         
						pstmt_insert_disp_hrd_tmp.setString(++counter,((String)TPNDetails.get(i+12)).trim());// DISP_QTY   
						
						if(!TPNDetails.get(i+6).equals(""))
						{
							if(getDecimalAllowedYN(connection, (String)TPNDetails.get(i+5)).equals("Y") && bDecimalAllowedParamYN)
								batch_qty = new Float(Float.parseFloat((String)TPNDetails.get(i+6))).doubleValue();
							else
								batch_qty = new Float(Math.ceil(Float.parseFloat((String)TPNDetails.get(i+6)))).doubleValue();

							tot_disp_qty  = tot_disp_qty + batch_qty;
						}

						pstmt_insert_disp_hrd_tmp.setString(++counter,((String)TPNDetails.get(i+13)).trim());// STOCK_UNIT         
						pstmt_insert_disp_hrd_tmp.setString(++counter,((String)TPNDetails.get(i+8)).trim());//BATCH_ID1      
						pstmt_insert_disp_hrd_tmp.setString(++counter,((String)TPNDetails.get(i+9)).trim());// EXPIRY_DATE1 
						pstmt_insert_disp_hrd_tmp.setString(++counter,batch_qty+"");//BATCH1_QTY
						pstmt_insert_disp_hrd_tmp.setString(++counter,((String)TPNDetails.get(i+11)).trim());//BIN_LOCATION_CODE1 		
						pstmt_insert_disp_hrd_tmp.setString(++counter,((String)TPNDetails.get(i+10)).trim());// TRADE_ID      
						pstmt_insert_disp_hrd_tmp.setString(++counter,login_by_id);//ADDED_BY_ID
						pstmt_insert_disp_hrd_tmp.setString(++counter,login_at_ws_no);	//ADDED_AT_WS_NO
						pstmt_insert_disp_hrd_tmp.setString(++counter,facility_id);	//ADDED_FACILITY_ID, 
						pstmt_insert_disp_hrd_tmp.setString(++counter,login_by_id);	//MODIFIED_BY_ID, 
						pstmt_insert_disp_hrd_tmp.setString(++counter,login_at_ws_no);	// MODIFIED_AT_WS_NO, 
						pstmt_insert_disp_hrd_tmp.setString(++counter,facility_id);	// MODIFIED_FACILITY_ID
						pstmt_insert_disp_hrd_tmp.setString(++counter,((String)TPNDetails.get(i+7)).trim());// Disp qty uom         
						
						pstmt_insert_disp_hrd_tmp.addBatch();
						stock_srl1.put(((String)TPNDetails.get(0)).trim()+((String)TPNDetails.get(k+5)).trim(),srl_no+"");
						
						srl_no++;
						k=k+12;
					}

				   pstmt_update_patient_drug_profile = connection.prepareStatement( SQL_PH_DISP_MEDICATION_PATIENT_DRUG_PROFILE_UPDATE_FOR_TPN_WS ) ;
				   pstmt_update_patient_drug_profile.setDouble(1,tot_disp_qty);	// TOT_ISSUED_QTY
				   pstmt_update_patient_drug_profile.setString(2,((String)patientDrugProfileData.get(3)).trim());	// PATIENT_ID          
				   pstmt_update_patient_drug_profile.setString(3,((String)patientDrugProfileData.get(4)).trim());	// ORIG_ORDER_ID       
				   pstmt_update_patient_drug_profile.setString(4,facility_id.trim());								// FACILITY_ID 
				   pstmt_update_patient_drug_profile.executeUpdate(); 
				}
			}
			
			int res1[]=pstmt_insert_disp_hrd_tmp.executeBatch();
			for (int k=0;k<res1.length ;k++ ){
			if(res1[k]<0  && res1[k] != -2 ){
				pstmt_insert_disp_hrd_tmp.cancel();
				connection.rollback();
				throw new EJBException("TPN updation  Failed");
				}
			}

// stock transaction starts

			HashMap prev_doc_no=new HashMap();
			updateOrOrderLinePh(connection,sqlMap,tabData,orderLineData,orderLineData1);
			String st_doc_type=  getStockDocType(connection, sqlMap, patient_class, facility_id) ;
			//Added Below if Condition for ICN-35047[ReOpen]
			if(dispTMP.size()>0){
			callStockUpdate(connection,tabData,sqlMap,dispTMP, prev_doc_no,st_doc_type, stock_srl);		
			}				
			
			connection.commit();
			map.put("result", new Boolean( true) ) ;
			map.put("msgid","RECORD_MODIFIED");			
			map.put("flag",worksheet_id);
		}
		catch(Exception e){
			System.err.println(e);
			e.printStackTrace();
			connection.rollback();
			map.put( "result", new Boolean( false) ) ;
			map.put("msgid",e.toString());
			map.put("flag",e.toString());
			System.err.println("Error: Error while TPN Allocation");
			return map;
		}finally{
			try{
				closeResultSet( resultSet ) ;
				closeResultSet( ResultSet1 ) ;
				closeStatement( pstmt_update_order_line ) ;
				closeStatement( pstmt_update_patient_drug_profile ) ;
				closeStatement( pstmt_update_order );
				closeStatement( pstmt_insert_disp_hrd_tmp );
				closeStatement( pstmt_insert_disp_dtl_tmp );
				closeStatement( pstmt_insert_disp_drug_batch_tmp );
				closeStatement( pstmt_worksheet_tpn_hdr_insert );
				closeStatement( pstmt_worksheet_tpn_dtls_insert );
				closeStatement( pstmt_disp_dtl_ws );
				closeStatement( pstmt_disp_hdr_delete );
				closeStatement( pstmt_disp_dtl_delete );
				closeStatement( pstmt_disp_batch_delete );
				closeStatement( pstmt_worksheet_tpn_hdr_select );
				 resultSet =null;
				 ResultSet1=null;
				 pstmt_update_order_line =null;
				 pstmt_update_patient_drug_profile =null;
				 pstmt_update_order =null;
				 pstmt_insert_disp_hrd_tmp =null;
				 pstmt_insert_disp_dtl_tmp =null;
				 pstmt_insert_disp_drug_batch_tmp=null;
				 pstmt_worksheet_tpn_hdr_insert =null;
				 pstmt_worksheet_tpn_dtls_insert =null;
				 pstmt_disp_dtl_ws =null;
				 pstmt_disp_hdr_delete =null;
				 pstmt_disp_dtl_delete =null;
				 pstmt_disp_batch_delete =null;
				 pstmt_worksheet_tpn_hdr_select =null;
				closeConnection( connection,prop );
			}
			catch(Exception e){
				System.err.println("DispMedicationTPNWorkSheet EJB completeAllocation tabData==========>"+tabData);
				e.printStackTrace();
			}
		}
		return map;
	}


	public HashMap completeTPNDelivery(HashMap tabData,HashMap sqlMap ) throws Exception{

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		int res					=0;

		Connection connection						= null;
		CallableStatement cstmt						= null;
		ResultSet		  resultSet					= null;
		PreparedStatement pstmt_update_order_line	= null;
		PreparedStatement pstmt_update_order		= null;
		final String SQL_PH_DISP_MEDICATION_ORDER_LINE_UPDATE_FOR_WS    = (String) sqlMap.get( "SQL_PH_DISP_MEDICATION_ORDER_LINE_UPDATE_FOR_WS" );
		final String SQL_PH_DISP_MEDICATION_ORDER_UPDATE                = (String)sqlMap.get("SQL_PH_DISP_MEDICATION_ORDER_UPDATE");
		
		prop						= (Properties)tabData.get( "properties" );	
		String login_by_id			= (String)tabData.get("login_by_id");
		String order_id				= (String)tabData.get("order_id");
		String patient_id			= (String)tabData.get("patient_id");
		String login_at_ws_no		= (String)tabData.get("login_at_ws_no");
		String facility_id			= (String)tabData.get("facility_id");
		String patient_class		= (String)tabData.get( "patient_class");
		HashMap stock_srl			= (HashMap)tabData.get( "stock_srl");
		ArrayList    dispTMP		= (ArrayList) tabData.get( "dispTMP" );
		ArrayList   orderLineData1	= (ArrayList) tabData.get( "orderLineData1" );
		ArrayList   orderLineData	= (ArrayList) tabData.get( "orderLineData" );
		String st_doc_type			=	"";
    //added for ml-mmoh-scf-1303 start
		float bms_qty=(Float) tabData.get( "bms_qty");
		String order_line_status_code="";
		if(bms_qty >0){
			order_line_status_code="DP";
		}
		else{
			order_line_status_code="DF";
		}
    //added for ml-mmoh-scf-1303 end
		try{
			connection			= getConnection(prop) ;
			HashMap prev_doc_no=new HashMap();
			st_doc_type=  getStockDocType(connection, sqlMap, patient_class, facility_id) ;
			callStockUpdate(connection,tabData,sqlMap,dispTMP, prev_doc_no,st_doc_type, stock_srl);	
			updateOrOrderLinePh(connection,sqlMap,tabData,orderLineData,orderLineData1);

			callUpdatePhMednAdmin(connection,sqlMap,tabData,orderLineData,patient_id,order_id);		

			pstmt_update_order_line = connection.prepareStatement( SQL_PH_DISP_MEDICATION_ORDER_LINE_UPDATE_FOR_WS ) ;
			pstmt_update_order_line.setString(1,order_line_status_code);	//modified for ml-mmoh-scf-1303										       
			pstmt_update_order_line.setString(2,"");	
			pstmt_update_order_line.setString(3,"");	
			pstmt_update_order_line.setString(4,"");												
			pstmt_update_order_line.setString(5,"");		
			pstmt_update_order_line.setString(6,"");//added newly for the ML-BRU-SCF-0184 by SureshKumar T on 07/06/2012					
			pstmt_update_order_line.setString(7,login_by_id);	
			pstmt_update_order_line.setString(8,facility_id);	
			pstmt_update_order_line.setString(9,login_at_ws_no);		
			pstmt_update_order_line.setString(10,order_id);	
		    res	=	pstmt_update_order_line.executeUpdate();

			pstmt_update_order = connection.prepareStatement( SQL_PH_DISP_MEDICATION_ORDER_UPDATE ) ;
			pstmt_update_order.setString(1,order_line_status_code);//modified for ml-mmoh-scf-1303
			pstmt_update_order.setString(2,login_by_id);		// modified id
			pstmt_update_order.setString(3,facility_id);		// modified facility
			pstmt_update_order.setString(4,login_at_ws_no);		// modified work station
			pstmt_update_order.setString(5,order_id);
			pstmt_update_order.executeUpdate();

			if(res!=0 && res!=0){
				connection.commit();
				map.put( "result", new Boolean( true) ) ;
				map.put("msgid","RECORD_MODIFIED");
			}
			else{
				connection.rollback();
				map.put("flag","0");
			}	
		}
		catch(Exception e){
			System.err.println("Error: During TPN Delivery===tabData="+tabData);
			e.printStackTrace();
			connection.rollback();
			map.put( "result", new Boolean( false) ) ;
			map.put("msgid",e.toString());
			map.put("flag",e.toString());
			return map;
			//throw new EJBException("Error: During Delivery");
		}
		finally{
			try{
				closeResultSet( resultSet ) ;
				closeStatement( cstmt );
				closeStatement( pstmt_update_order );
				closeStatement( pstmt_update_order_line );
				resultSet =null;
				cstmt =null;
				pstmt_update_order =null;
				pstmt_update_order_line =null;
				closeConnection( connection,prop );
			}
			catch(Exception es){
				es.printStackTrace();
				connection.rollback();
			}
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
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				resultSet=null;
				pstmt=null;

				closeConnection( connection,prop );
			}
			catch(Exception es) { es.printStackTrace(); }
		}
		return result;
	}
	
	public String getWorkSheetID(Connection connection, String SQL_PH_TPN_WORKSHEET_ID_COUNT,String facility_id,String disp_locn_code)throws Exception{
		String result = "";
		//Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null;
		try {
			//connection = getConnection(prop) ;
			pstmt = connection.prepareStatement( SQL_PH_TPN_WORKSHEET_ID_COUNT ) ;
			pstmt.setString(1,facility_id.trim());
			pstmt.setString(2,disp_locn_code.trim());
			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next() ) {
				result = resultSet.getString("WORKSHEET_ID");
			}
		}
		catch ( Exception e ) {
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				resultSet=null;
				pstmt=null;
			//	closeConnection( connection,prop );
			}
			catch(Exception es) { es.printStackTrace();}
		}
		return result;
	}

	public void callStockUpdate(Connection connection,HashMap tabData,HashMap sqlMap,ArrayList dispTMP,HashMap prev_doc_no,String st_doc_type,HashMap stock_srl) throws Exception{
		PreparedStatement pstmt_st_doc_vals	= null;
	    ResultSet resSet					= null;
	
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
			//String finalise_yn		=   (String)tabData.get("finalized_yn");
			String disp_stage		=   (String)tabData.get("disp_stage");

			int counter=1;
			pstmt_st_doc_vals	=   connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT144") ) ;
			String st_doc_no	=	"";
			HashMap approvalNo = (HashMap)tabData.get("approvalNo");//AAKH-CRF-0117
			String approval_no = "";  //AAKH-CRF-0117

			 
			for(int i=0;i<dispTMP.size();i=i+7){

				pstmt_st_doc_vals.setString(1,(String)dispTMP.get(i));
				resSet				= pstmt_st_doc_vals.executeQuery() ;
				if(resSet.next()) {
					st_doc_no	=	(String)resSet.getString("doc_no");
					if(st_doc_no!=null&&!st_doc_no.equals("")){
						prev_doc_no.put(((String)dispTMP.get(i)).trim(),st_doc_no);
					}
				}
				closeResultSet( resSet ) ;

				if(orders.size()!=0 && (!orders.contains(((String)dispTMP.get(i)).trim()))) {
					stock_dtls.put("insertDetail",insertDetail);
					stock_dtls.put("updateDetail",updateDetail);
					stock_dtls.put("insertExp",insertExp);
					stock_dtls.put("updateExp",updateExp);

					updateStock(connection,tabData,sqlMap,stock_dtls,order_id,docno,st_doc_type);
					
					stock_dtls		=	new HashMap();
					insertDetail	=	new ArrayList();
					insertExp		=	new ArrayList();
					updateDetail	=	new ArrayList();
					updateExp		=	new ArrayList();
					orders			=	new ArrayList();
					order_id		=	"";
					docno			=	"";
				}
			
				ArrayList batchDetails = (ArrayList)dispTMP.get(i+6);

				counter=1;
				String actual_issue_qty  = "";
				String sDecimalAllowed = "N";
				for (int j=0;j<batchDetails.size() ; j=j+10){ //9->10 for MMS-SCF-0040 [IN:041888]
					item_code				=	(String)batchDetails.get(j);

					item_cost				=	(String)batchDetails.get(j+8);
					if(item_cost.equals(""))
						item_cost	=	"0";

					sDecimalAllowed = getDecimalAllowedYN(connection, item_code);

					if(bDecimalAllowedParamYN && sDecimalAllowed.equals("Y"))
						actual_issue_qty  = new Float(Float.parseFloat((String)batchDetails.get(j+3)))+"";
					else
						actual_issue_qty  = new Float(Math.ceil(Float.parseFloat((String)batchDetails.get(j+3))))+"";
					
					cost_value	=	Math.round(Double.parseDouble((String)dispTMP.get(i+4)) * Double.parseDouble(item_cost)*1000)+"";
					cost_value	= (Double.parseDouble(cost_value)/1000)+"";
				
					HashMap hmDetail	=	new HashMap();		
					hmDetail.put("doc_srl_no",counter+"");
					hmDetail.put("item_code",item_code);
					hmDetail.put("sal_category","");
					hmDetail.put("hcp_issue_factor","");
					hmDetail.put("item_qty",actual_issue_qty);
					hmDetail.put("item_sal_value",cost_value);
					hmDetail.put("next_due_date","");
					hmDetail.put("stock_item_yn","Y");
					hmDetail.put("remarks","");
					hmDetail.put("item_unit_cost",item_cost);
					hmDetail.put("item_cost_value",cost_value);
					hmDetail.put("item_unit_price",item_cost);
					hmDetail.put("uom_code",((String)batchDetails.get(j+4)).trim());
					hmDetail.put("mode",(String)tabData.get("mode"));
					hmDetail.put("decimal_allowedYN",sDecimalAllowed);	

					//added for AAKH-CRF-0117 - start
						if(approvalNo!=null && approvalNo.size()>0)
							approval_no = (String)approvalNo.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+1)).trim());
							if(approval_no==null)
								approval_no = "";
					hmDetail.put("approval_no",approval_no);

					hmDetail.put("take_home_yn","N"); // For Take Home Flag
					if(prev_doc_no.containsKey(((String)dispTMP.get(i)).trim()) && disp_stage.equals("D")) 
					{
						updateDetail.add(hmDetail);
					}
					else
					{
						insertDetail.add(hmDetail);
					}
					
					batch_id		= ((String)batchDetails.get(j+1)).trim();
					expiry_date		= ((String)batchDetails.get(j+2)).trim();
					disp_qty		= actual_issue_qty;
					trade_id		= ((String)batchDetails.get(j+6)).trim();
					bin_locn_code	= ((String)batchDetails.get(j+7)).trim();

					HashMap hmExp	=	new HashMap();
					hmExp.put("doc_srl_no",counter+"");
					hmExp.put("store_code",(String)tabData.get("store_code"));
					hmExp.put("item_code",item_code);
					hmExp.put("batch_id",batch_id);
					hmExp.put("bin_location_code",bin_locn_code);
					hmExp.put("expiry_date_or_receipt_date",expiry_date);
					hmExp.put("trade_id",trade_id);
					hmExp.put("sal_item_qty",disp_qty);
					hmExp.put("ret_item_qty","");

					if(prev_doc_no.containsKey(((String)dispTMP.get(i)).trim()) && disp_stage.equals("D")) 
					{
						updateExp.add(hmExp);	
					}
					else
					{
						insertExp.add(hmExp);
					}
					counter++;
				}

				if(!orders.contains(((String)dispTMP.get(i)).trim())) 
				{
					orders.add(((String)dispTMP.get(i)).trim());
					order_id	=	(String)orders.get(0);

					if(prev_doc_no.containsKey(order_id))
						docno		=	(String)prev_doc_no.get(order_id);
				}		
			}
			//Added Below if Condition for ICN-35047[ReOpen]
			if(insertDetail.size()>0 || updateDetail.size()>0){
			stock_dtls.put("insertDetail",insertDetail);
			stock_dtls.put("updateDetail",updateDetail);
			stock_dtls.put("insertExp",insertExp);
			stock_dtls.put("updateExp",updateExp);
			updateStock(connection,tabData,sqlMap,stock_dtls,order_id,docno,st_doc_type);
			}
		} 
		catch(Exception e) {
			System.err.println("error while updating stock");
			throw e;
		}finally{	
			try {
				closeResultSet( resSet ) ;
				closeStatement( pstmt_st_doc_vals ) ;
			}catch(Exception es) {
				es.printStackTrace();
			}
		}
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
				System.err.println(e);
				e.printStackTrace();
		}finally{	
			try {
				closeResultSet( resSet ) ;
				closeStatement( pstmt_st_doc_type ) ;
				resSet=null;
				pstmt_st_doc_type=null;
			}catch(Exception es) {
				es.printStackTrace();
			}
		}
		return st_doc_type;
	}

	public void updateStock(Connection connection,HashMap tabData, HashMap sqlMap, HashMap stock_dtls,String order_id, String prev_doc_no,String  st_doc_type) throws Exception{

		HashMap hmHeader		=	new HashMap();
		HashMap hmCommon		=	new HashMap();
		HashMap hmData			=	new HashMap();
		String patient_class_PC	=   "";
		String encounter_id	    =   "";
        ArrayList language_data =   new ArrayList();
		String LanguageId	    =  (String)tabData.get("LanguageId");
		String finalised_yn	    =  "";
		String insert_bl_det_yn =  "N";
		String 	  errod_id = "", message  = "";

         if(!((String)tabData.get("disp_stage")).equals("D")){
			ArrayList mfg_unit_details	= (ArrayList)tabData.get("mfg_unit_details");
			finalised_yn			= ((String)mfg_unit_details.get(6)).trim();//to check whether worksheet is finalised or not
         }
		 else{
			finalised_yn			="Y";
		 }


		ArrayList insertDetail	=	(ArrayList)stock_dtls.get("insertDetail");
		ArrayList updateDetail	=	(ArrayList)stock_dtls.get("updateDetail");
		ArrayList insertExp		=	(ArrayList)stock_dtls.get("insertExp");
		ArrayList updateExp		=	(ArrayList)stock_dtls.get("updateExp");
		PreparedStatement pstmt_update_disp_hdr_tmp	=	null;
		hmHeader.put("facility_id",(String)tabData.get("facility_id"));
		hmHeader.put("doc_type_code",st_doc_type);
		hmHeader.put("doc_no","");
		hmHeader.put("doc_date",(String)tabData.get("today"));
		hmHeader.put("doc_ref","");
		hmHeader.put("store_code",((String)tabData.get("store_code")).trim());
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

       if((( ((String)tabData.get("disp_stage")).equals("A")|| ((String)tabData.get("disp_stage")).equals("F") )&&((((String)tabData.get("DispBillingStage")).equals("A") )&& finalised_yn.equals("Y") ))||   (((String)tabData.get("disp_stage")).equals("D")&&((String)tabData.get("DispBillingStage")).equals("D")) ){
			hmHeader.put("authorized_by_id",(String)tabData.get("login_by_id"));
			insert_bl_det_yn =  "Y";
	   }
	   else{
			hmHeader.put("authorized_by_id","");
			insert_bl_det_yn =  "N";
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
		}catch ( Exception e ) {
			System.err.println( e ) ;
			e.printStackTrace() ;
		}
		finally {
		  closeResultSet( resultSet ) ;
		  closeStatement( pstmt_select ) ;
		}

		hmHeader.put("billable_trn_yn",bl_interface_yn);//billable_trn_yn
		if(bl_interface_yn.equals("Y")&& finalised_yn.equals("Y"))	{
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
			}catch ( Exception e ) {
				System.err.println( e ) ;
				e.printStackTrace() ;
			}
			finally {
				closeResultSet( resultSetPC ) ;
				closeStatement( pstmtPC ) ;
			}
			hmHeader.put("sal_trn_type",patient_class_PC);
		}
//=========BL related interface coding ends here====================
		hmCommon.put("login_by_id",(String)tabData.get("login_by_id"));
		hmCommon.put("login_at_ws_no",(String)tabData.get("login_at_ws_no"));
		hmCommon.put("login_facility_id",(String)tabData.get("facility_id"));
		hmCommon.put("FACILITY_STR_FOR_BL",(String)tabData.get("ordering_facility_id")+"|"+(String)tabData.get("facility_id"));

        language_data.add(LanguageId);

		hmData.put("HDR_DATA",hmHeader);
		hmData.put("COMMON_DATA",hmCommon);
		hmData.put("LANGUAGE_DATA",language_data);

		try{
			if(insertDetail.size()==0&& updateDetail.size()==0){
				System.err.println("===tabData===="+tabData+"===stock_dtls===="+stock_dtls);
				System.err.println("===order_id===="+order_id+"===prev_doc_no===="+prev_doc_no);
				System.err.println("====st_doc_type===="+st_doc_type);
				throw new EJBException("Stock updation failed in Dispensing");
			}
		
			if(insertDetail.size()!=0){
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
					throw new EJBException(errod_id+":-"+message);//"insert Sales failed"
				}
				else {
					String docno				=	(String)map.get("doc_no");
					String doctypecode			=	(String)map.get("doc_type_code");
					if(alSalDocDtls==null) //Added for AMS-CRF-0079 [IN:050762] -start
						alSalDocDtls = new ArrayList();
					if(!alSalDocDtls.contains(doctypecode+"-"+docno))
						alSalDocDtls.add(doctypecode+"-"+docno); //Added for AMS-CRF-0079 [IN:050762] -end
					
					try {
						pstmt_update_disp_hdr_tmp		=	null;
						pstmt_update_disp_hdr_tmp		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_WORKSHEET_UPDATE1") ) ;
						pstmt_update_disp_hdr_tmp.setString(1,doctypecode);
						pstmt_update_disp_hdr_tmp.setString(2,docno);

						pstmt_update_disp_hdr_tmp.setString(3,disp_locn_code );
						pstmt_update_disp_hdr_tmp.setString(4,(String)tabData.get("facility_id"));  
						pstmt_update_disp_hdr_tmp.setString(5,worksheet_id);  	
						pstmt_update_disp_hdr_tmp.executeUpdate();		
					}
					catch ( Exception e ) {
						e.printStackTrace() ;
					}
					finally {
						closeStatement( pstmt_update_disp_hdr_tmp ) ;
					}

					if(bl_interface_yn.equals("Y")&& insert_bl_det_yn.equals("Y")){
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
						   insertPreprationChargeDet(connection,tabData,patient_class_PC,doctypecode,docno,200,admx_prep_charge_units,";",admx_prep_charge_item_code);
						}
					}
				}
			}

			if(updateDetail.size()!=0) {
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
					message = (String)map.get("message");
					errod_id = errod_id.replace("javax.ejb.EJBException:","");
					errod_id = errod_id.replace("java.lang.Exception:","");
					message = message.replace("javax.ejb.EJBException:","");
					message = message.replace("java.lang.Exception:","");
					errod_id = errod_id.trim();
					message = message.trim();
					if(errod_id.equals(message))
						message="";
					if(errod_id.contains("POPULATE_MAT_INTERFACED_RECS-1ORA-00001: unique constraint"))
						message = "APP-PH0900 Record already exists in Patient Charge Folio";
					if(!message.equals(""))
						message = message+" ";
					throw new EJBException(message+"\n"+errod_id);//"update Sales failed"
				}
				else {
					if(alSalDocDtls==null)//Added for AMS-CRF-0079 [IN:050762] -start
						alSalDocDtls = new ArrayList();
					if(!alSalDocDtls.contains(st_doc_type+"-"+prev_doc_no))
						alSalDocDtls.add(st_doc_type+"-"+prev_doc_no); //Added for AMS-CRF-0079 [IN:050762] -end
					try {
						pstmt_update_disp_hdr_tmp		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_HRD_TMP_UPDATE") ) ;
						pstmt_update_disp_hdr_tmp.setString(1,st_doc_type);
						pstmt_update_disp_hdr_tmp.setString(2,prev_doc_no);
						pstmt_update_disp_hdr_tmp.setString(3,order_id);
						pstmt_update_disp_hdr_tmp.setString(4,(String)tabData.get("facility_id"));
						pstmt_update_disp_hdr_tmp.executeUpdate();
					}
					catch ( Exception e ) {
						e.printStackTrace() ;
					}
					finally {
						closeStatement( pstmt_update_disp_hdr_tmp ) ;
					}

					if(bl_interface_yn.equals("Y")&& insert_bl_det_yn.equals("Y")){
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
						   insertPreprationChargeDet(connection,tabData,patient_class_PC,st_doc_type,prev_doc_no,200,admx_prep_charge_units,";",admx_prep_charge_item_code);

						}
					}

				}
			}
		}
		catch(Exception e) {
			System.err.println("Exception at 1664"+stock_dtls);
			e.printStackTrace();
			throw new EJBException("Error - "+e.getMessage()); //"Stock updation failed in Dispensing"
		}
		finally{
			try{
				closeStatement(pstmt_update_disp_hdr_tmp);	
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}


	private void updateOrOrderLinePh(Connection connection, HashMap sqlMap, HashMap tabData,ArrayList orderLineData, ArrayList orderLineData1) throws Exception {

		PreparedStatement pstmt_update_order_line_ph_1	=	null;
		PreparedStatement pstmt_update_order_line_ph	=	null;
		
		try {
			//ResultSet resSet								=	null; commended dor Unused local variable 'resSet' checkstyle INC63877
			HashMap complte_order_reasons = (HashMap)tabData.get("complte_order_reason");
			//String filling_status = tabData.get("filling_status")==null?"":(String)tabData.get("filling_status"); //Commented for COMMON-ICN-0048
			String complete_order_reason		=    "", key;
			String disp_stage=tabData.get("disp_stage").toString();  // Added for IN038706 - TPN-Admixture - Send to external facility
			int count=0;
			if (!disp_stage.equals("D")){	// Condition added for IN038706
			
			if(disp_stage.equals("AS")) {
			   pstmt_update_order_line_ph_1=connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_LINE_PH_UPDATE2A") ) ;
			}
			else{
			   pstmt_update_order_line_ph_1=connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_LINE_PH_UPDATE2") ) ;
			}

			for(int i=0;i<orderLineData.size();i=i+7){
				key = ((String)orderLineData.get(i+3)).trim();
				key+=orderLineData.get(i+4).toString();
				if( complte_order_reasons.containsKey(key)){
					complete_order_reason   =  (String) complte_order_reasons.get(key);
				}
				else{
					complete_order_reason   =  "";
				}
				if(complete_order_reason!=null && !complete_order_reason.equals("")){
					pstmt_update_order_line_ph_1.setString(1,complete_order_reason);
					if(disp_stage.equals("AS")) {
						pstmt_update_order_line_ph_1.setString(2,(String)tabData.get("dateTime"));
						pstmt_update_order_line_ph_1.setString(3,((String)orderLineData.get(i+3)).trim());	
						pstmt_update_order_line_ph_1.setString(4,((String)orderLineData.get(i+4)).trim());	
					}
					else{
						pstmt_update_order_line_ph_1.setString(2,((String)orderLineData.get(i+3)).trim());	
						pstmt_update_order_line_ph_1.setString(3,((String)orderLineData.get(i+4)).trim());	
					}
					pstmt_update_order_line_ph_1.addBatch(); 
					count++;
				}
				if(disp_stage.equals("AS")) {
					i	=	i+3;
				}
			}
			if( count>0){
				if(pstmt_update_order_line_ph_1 != null ){
					int result[] = pstmt_update_order_line_ph_1.executeBatch();
					for (int i=0;i<result.length ;i++ ){		// A number greater than or equal to zero  indicates success // A number -2 indicates that command is successful but number of rows updated is unknow
																// If it won't satisfy any of the above cancel the statement and throw an exception
						if(result[i]<0  && result[i] != -2 ){
							pstmt_update_order_line_ph_1.cancel();
							connection.rollback();
							throw new EJBException("Update completeorder reason  :OR_ORDER_LINE_PH failed");
						}		
					}
				}// Added below condition for CRF-PH- Bru-HIMS-CRF-087/12 -TPN  IN#38706   -- end
			}
		}
			pstmt_update_order_line_ph = connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDER_LINE_PH_UPDATE") ) ;
			count = 0;
			for(int i=0;i<orderLineData1.size();i=i+3){
				pstmt_update_order_line_ph.setString(1,(String)orderLineData1.get(i)==""?null:(String)orderLineData1.get(i));	
				pstmt_update_order_line_ph.setString(2,((String)orderLineData1.get(i+1)).trim());	
				pstmt_update_order_line_ph.setString(3,((String)orderLineData1.get(i+2)).trim());	
				pstmt_update_order_line_ph.addBatch(); 
				count++;
				
			}

			if( (disp_stage.equals("A") || disp_stage.equals("F") && count>0) || (disp_stage.equals("D") &&count==0)){
				if(pstmt_update_order_line_ph != null ){
					int result[] = pstmt_update_order_line_ph.executeBatch();
					for (int i=0;i<result.length ;i++ ){		// A number greater than or equal to zero  indicates success // A number -2 indicates that command is successful but number of rows updated is unknow
																// If it won't satisfy any of the above cancel the statement and throw an exception
						if(result[i]<0  && result[i] != -2 ){
							pstmt_update_order_line_ph.cancel();
							connection.rollback();
							throw new EJBException("Update completeorder reason  :OR_ORDER_LINE_PH failed");
						}		
					}
				}// Added below condition for CRF-PH- Bru-HIMS-CRF-087/12 -TPN  IN#38706   -- end
			}
		}
		catch(Exception e){
			System.err.println("========orderLineData===========>"+orderLineData);
			e.printStackTrace();
			throw new EJBException("Error: OR_ORDER_LINE_PH FAILED");
		}
		finally{	
			try {
				closeStatement( pstmt_update_order_line_ph ) ;
				closeStatement( pstmt_update_order_line_ph_1 ) ;
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
	}

	public void callUpdatePhMednAdmin(Connection connection, HashMap sqlMap, HashMap tabData,ArrayList orderLineData,String patient_id,String order_id1)throws Exception{
	
		String encounter_id="",ORD_DRUG_CODE="", SCH_ROOUTE_CODE= "",PRACT_ID="";
		String SCH_INFUSION_RATE="",SCH_INFUSION_VOL_STR_UNIT="",SCH_INFUSION_PER_UNIT="", durations="", SCH_INFUSION_PERIOD="";

		String start_date_time	 =	"";
		String qty_unit			 =	"";
		String qty_value		 =	"";
		PreparedStatement pstmt5 = null ;
		PreparedStatement pstmt1 = null ;
		PreparedStatement pstmt2 = null ;		
		ResultSet resultSet1	 = null;
		ResultSet resultSet2	 = null;
		
		String login_by_id		 = (String)tabData.get("login_by_id");
		String login_at_ws_no	 = (String)tabData.get("login_at_ws_no");
		String FACILITY_ID		 = "";
		final String SQL_PH_TPN_STD_REGIMEN_INSERT6 = (String)sqlMap.get("SQL_PH_TPN_STD_REGIMEN_INSERT6");
		final String SQL_PH_DISP_MEDICATION_OR_ORDER_LINE_TPN_SELECT2 = (String)sqlMap.get("SQL_PH_DISP_MEDICATION_OR_ORDER_LINE_TPN_SELECT2");
		final String SQL_PH_DISP_MEDICATION_PH_PATIENT_DRUG_PROFILE_TPN_SELECT1 = (String)sqlMap.get("SQL_PH_DISP_MEDICATION_PH_PATIENT_DRUG_PROFILE_TPN_SELECT1");

		try {
					
			pstmt1 = connection.prepareStatement(SQL_PH_DISP_MEDICATION_OR_ORDER_LINE_TPN_SELECT2); 
			pstmt1.setString(1,order_id1);
			resultSet1 = pstmt1.executeQuery() ;
			while ( resultSet1 != null && resultSet1.next() ) {
				encounter_id	= resultSet1.getString("encounter_id");
				ORD_DRUG_CODE	= resultSet1.getString("ORD_DRUG_CODE");
				SCH_ROOUTE_CODE = resultSet1.getString("SCH_ROOUTE_CODE");
				PRACT_ID		= resultSet1.getString("PRACT_ID");
				start_date_time	= resultSet1.getString("start_date_time");
				qty_value		= resultSet1.getString("qty_value");
				qty_unit		= resultSet1.getString("qty_unit");
				if(encounter_id==null)
					encounter_id="";
				if(ORD_DRUG_CODE==null)
					ORD_DRUG_CODE="";
				if(SCH_ROOUTE_CODE==null)
					SCH_ROOUTE_CODE="";
				if(PRACT_ID==null)PRACT_ID="";
				if(start_date_time==null)
					start_date_time="";
				if(qty_value==null)
					qty_value="";
				if(qty_unit==null)
					qty_unit="";
			}
			pstmt2 = connection.prepareStatement(SQL_PH_DISP_MEDICATION_PH_PATIENT_DRUG_PROFILE_TPN_SELECT1); 
			pstmt2.setString(1,order_id1);
			resultSet2 = pstmt2.executeQuery() ;
			while ( resultSet2 != null && resultSet2.next() ) {
				FACILITY_ID=resultSet2.getString("FACILITY_ID");
				SCH_INFUSION_RATE			= resultSet2.getString("SCH_INFUSION_RATE");
				SCH_INFUSION_VOL_STR_UNIT	= resultSet2.getString("SCH_INFUSION_VOL_STR_UNIT");
				SCH_INFUSION_PER_UNIT		= resultSet2.getString("SCH_INFUSION_PER_UNIT");
				SCH_INFUSION_PERIOD			= resultSet2.getString("SCH_INFUSION_PERIOD");
				durations					= resultSet2.getString("durations");				
		
				if(FACILITY_ID==null)
					FACILITY_ID="";
				if(SCH_INFUSION_RATE==null)
					SCH_INFUSION_RATE="";
				if(SCH_INFUSION_VOL_STR_UNIT==null)
					SCH_INFUSION_VOL_STR_UNIT="";
				if(SCH_INFUSION_PER_UNIT==null)
					SCH_INFUSION_PER_UNIT="";
				if(SCH_INFUSION_PERIOD==null)
					SCH_INFUSION_PERIOD="";
				if(durations==null)
					durations="";
			}
			pstmt5 = connection.prepareStatement(SQL_PH_TPN_STD_REGIMEN_INSERT6); 
			pstmt5.setString(1,FACILITY_ID);
			pstmt5.setString(2,encounter_id);
			pstmt5.setString(3,start_date_time);
			pstmt5.setString(4,"FINAL PRODUCT");
			pstmt5.setString(5,"1");
			pstmt5.setString(6,order_id1);
			pstmt5.setString(7,"1");
			pstmt5.setString(8,patient_id);
			pstmt5.setString(9,PRACT_ID);
			pstmt5.setString(10,qty_value);
			pstmt5.setString(11,qty_unit);
			pstmt5.setString(12,SCH_ROOUTE_CODE); //SCH_ROUTE_CODE
			pstmt5.setString(13,login_by_id);
			pstmt5.setString(14,login_at_ws_no);
			pstmt5.setString(15,FACILITY_ID);
			pstmt5.setString(16,login_by_id);
			pstmt5.setString(17,login_at_ws_no);
			pstmt5.setString(18,FACILITY_ID);
			pstmt5.setString(19,"N") ;//VERIFY_REQD_YN
			pstmt5.executeUpdate() ;
		}
		catch ( Exception e ) {
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try {
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt1 ) ;
				closeResultSet( resultSet2 ) ;
				closeStatement( pstmt2 ) ;				
				closeStatement( pstmt5 ) ;	
				resultSet1	=null;
				pstmt1 		=null;
				resultSet2	=null;
				pstmt2 		=null;
				pstmt5 		=null;

			
			}
			catch(Exception es) {
             es.printStackTrace() ;
			}
		}		
	}
	//this function is used to insert data into bl_patient_charges_folio for prepration charge details

	private void insertPreprationChargeDet(Connection connection,HashMap tabData,String sal_trn_type,String doc_type_code,String docno,int doc_srl_no,String req_qty,String Batch_str,String item_code) throws Exception{
		CallableStatement callableStatement = null;					
		try {
			String token_series_code="";
			String token_serial_no  ="";
			callableStatement	= connection.prepareCall("{ call ST_SAL_BL_POST_CHARGES_FOLIO (?,?,?,?,?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
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
		   /* if(delete_sales_yn.equals("Y")){
				callableStatement.setInt(12,(-1)*Integer.parseInt(req_qty) );
			}else{*/
			callableStatement.setFloat(12, Float.parseFloat(req_qty) );
			//}
			callableStatement.setString(13,Batch_str);
			callableStatement.setString(14,(String)tabData.get("login_at_ws_no"));						
			callableStatement.setString(15,"");						
			callableStatement.setString(16,"");// Overidden excl incl ind this is the defaulted value						
			callableStatement.setString(17,"");// this is a defaltuted value for the action reason code
			callableStatement.setString(18,token_series_code);	// these are being added for the Dispence Medication  from pH	
			callableStatement.setString(19,token_serial_no);// these are being added for the Dispence Medication  from pH		
			callableStatement.setString(20,(String)tabData.get("store_code"));// these are being added for the Dispence Medication  from pH					
			/*if(delete_sales_yn.equals("Y")){
				callableStatement.setString(21, doc_type_code);					
				callableStatement.setString(22, docno);		
				callableStatement.setString(23, old_srl_no);
				callableStatement.setString(24, "Y");//Internal Adjustment
			}else{*/
			callableStatement.setString(21,null);
			callableStatement.setString(22,null);
			callableStatement.setString(23,null);
			callableStatement.setString(24,"N");//Internal Adjustment
			callableStatement.setString(25,"N");//Take home yn

			//}	


			callableStatement.registerOutParameter(26, Types.VARCHAR);
			callableStatement.registerOutParameter(27, Types.VARCHAR);
			callableStatement.registerOutParameter(28, Types.VARCHAR);
			callableStatement.setString(29,"");
			callableStatement.execute();
		}
		catch(Exception e){
			System.err.println(e);
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

	private void setDecimalAllowedParamYN(Connection connection) 
	{
		//Connection oConnection		    = null;
		ResultSet oResultSet			= null;
		Statement oStatement			= null;
		boolean bDecimalAllowed			= false;
		try {
			//oConnection	= getConnection(prop) ;
			oStatement	= connection.createStatement();

			oResultSet	= oStatement.executeQuery("select DISP_DECIMAL_DTLS_YN from st_acc_entity_param");

			if(oResultSet!=null && oResultSet.next()){
				bDecimalAllowed = oResultSet.getString("DISP_DECIMAL_DTLS_YN")!=null?(oResultSet.getString("DISP_DECIMAL_DTLS_YN").equals("Y")?true:false):false;
			}
		}
		catch ( Exception e ){
			e.printStackTrace() ;
		}
		finally {
			try	{
				closeResultSet( oResultSet ) ;
				closeStatement( oStatement ) ;
				//closeConnection( oConnection, prop); 
			}
			catch ( Exception e ) {
				e.printStackTrace() ;
			}
		}
		bDecimalAllowedParamYN = bDecimalAllowed; 
	}


	private String getDecimalAllowedYN(Connection connection, String sItemCode){
		//Connection oConnection		    = null;
		ResultSet oResultSet			= null;
		Statement oStatement			= null;
		String sDecimalAllowed			= "N";
		try {
			//oConnection	= getConnection( prop );
			oStatement	= connection.createStatement();
			oResultSet	= oStatement.executeQuery("select item_code, ALLOW_DECIMALS_YN from st_item where item_code = '"+sItemCode+"'");
			if(oResultSet!=null && oResultSet.next()){
				sDecimalAllowed = oResultSet.getString("ALLOW_DECIMALS_YN")!=null?(oResultSet.getString("ALLOW_DECIMALS_YN").equals("Y")?"Y":"N"):"N";
			}
		}
		catch ( Exception e ){
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( oResultSet ) ;
				closeStatement( oStatement ) ;
				//closeConnection( oConnection, prop ); 
			}
			catch ( Exception e ) {
				e.printStackTrace() ;
			}
		}
		return sDecimalAllowed;
	}


}
