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
05/09/2019      70982   		Manickavasagam j      SKR-SCF-1253
07/07/2021      20374   		Manickavasagam j      SKR-SCF-1612
  
---------------------------------------------------------------------------------------------------------------
*/
package ePH.MedicationAdministrationFT ;

import java.rmi.* ;
import java.text.* ;
import java.util.*;
import java.sql.* ;
import javax.ejb.* ;
import ePH.Common.PhEJBSessionAdapter ;
import com.ehis.util.*;
import webbeans.eCommon.*; 

/**
*
* @ejb.bean
*	name="MedicationAdministrationFT"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="MedicationAdministrationFT"
*	local-jndi-name="MedicationAdministrationFT"
*	impl-class-name="ePH.MedicationAdministrationFT.MedicationAdministrationFTManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.MedicationAdministrationFT.MedicationAdministrationFTLocal"
*	remote-class="ePH.MedicationAdministrationFT.MedicationAdministrationFTRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.MedicationAdministrationFT.MedicationAdministrationFTLocalHome"
*	remote-class="ePH.MedicationAdministrationFT.MedicationAdministrationFTHome"
*	generate= "local,remote"
*
*
*/



public class MedicationAdministrationFTManager extends PhEJBSessionAdapter {

	Properties prop=null;
	String SQL_PH_MED_ADMIN_FT_SELECT9="";
	String SQL_PH_ADMIN_OR_ORDER_SELECT		="";
	
	// insert method starts here

/**
* @ejb.interface-method
*	 view-type="both"
*/
    public HashMap insert( HashMap tabData, HashMap sqlMap ){
		String only_update_stock=tabData.get("ONLY_STOCK_UPDATE")==null?"N":(String)tabData.get("ONLY_STOCK_UPDATE");
		if(only_update_stock.equals("Y")){
			SQL_PH_ADMIN_OR_ORDER_SELECT				=	(String)sqlMap.get("SQL_PH_ADMIN_OR_ORDER_SELECT");
			return updateMFRStock(tabData, sqlMap);
		}
        StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "msgid", messages.toString() ) ;
		map.put( "flag","0");
		HashMap COMMON_VALUES   = (HashMap)tabData.get("COMMON_VALUES");
		Connection connection = null ;
		String language_id  = (String)tabData.get("language_id");
		String admin_mode = COMMON_VALUES.get("admin_mode")==null?"":(String)COMMON_VALUES.get("admin_mode");
		try{
			prop = (Properties)tabData.get("properties");
			connection = getConnection( prop ) ;
			HashMap barcode_remarks =new HashMap();//Added for MMS-DM-CRF-0157.2
            CallableStatement cs = null;	//Added for MMS-Dm-CRF-0157.2
			if(admin_mode.equals("MS") ){
				HashMap NON_IV_DRUGS    = (HashMap)tabData.get("NON_IV_DRUGS");
				HashMap ALTERNATE_DRUGS = (HashMap)tabData.get("ALTERNATE_DRUGS");
				HashMap NEW_NON_IV_DRUGS= (HashMap)tabData.get("NEW_NON_IV_DRUGS");
				HashMap IV_DRUGS	    =  (HashMap)tabData.get("IV_DRUGS");
				ArrayList sel_drug_codes= (ArrayList)tabData.get("TIME_DETAILS");
				
				ArrayList non_iv_record     = null;
				HashMap alt_non_iv_record   = null;
				ArrayList new_non_iv_record = null; 
				ArrayList iv_record			= null; 
				HashMap new_tab_data		= null;	 
				for(int i=0;i<sel_drug_codes.size();i++){
					non_iv_record     = new ArrayList();
					alt_non_iv_record = new HashMap();
					new_non_iv_record = new ArrayList();
					iv_record         = new ArrayList();						
					if(NON_IV_DRUGS.get((String)sel_drug_codes.get(i)) != null){
						non_iv_record = (ArrayList)NON_IV_DRUGS.get((String)sel_drug_codes.get(i));
					}
					if(IV_DRUGS.get((String)sel_drug_codes.get(i)) != null){
						iv_record	  = (ArrayList)IV_DRUGS.get((String)sel_drug_codes.get(i));						
					}						
					if(ALTERNATE_DRUGS.get((String)sel_drug_codes.get(i)) != null){
						alt_non_iv_record = (HashMap)ALTERNATE_DRUGS.get((String)sel_drug_codes.get(i));
					}
					if(NEW_NON_IV_DRUGS.get((String)sel_drug_codes.get(i)) != null && i==(sel_drug_codes.size()-1)){
						new_non_iv_record	  = (ArrayList)NEW_NON_IV_DRUGS.get((String)sel_drug_codes.get(i));						
					}
				
					new_tab_data = new HashMap();
					new_tab_data.put("properties",prop);
					new_tab_data.put("NON_IV_DRUGS",non_iv_record);
					new_tab_data.put("ALTERNATE_DRUGS",alt_non_iv_record);
					new_tab_data.put("NEW_NON_IV_DRUGS",new_non_iv_record);
					new_tab_data.put("IV_DRUGS",iv_record);
					new_tab_data.put("COMMON_VALUES",COMMON_VALUES);

					if(!(non_iv_record.size()==0 && alt_non_iv_record.size()==0 && new_non_iv_record.size()==0 && iv_record.size()==0)){
						map = insertAdminDetails(connection, new_tab_data,sqlMap,language_id);											
					}
				}
			}
			else if(admin_mode.equals("POSTADMINDTLS") || admin_mode.equals("CDNOTADMIN") ||admin_mode.equals("HOLD") ||admin_mode.equals("DISCONT")){
				map.put( "result", new Boolean( true) ) ;
			}
			else if(admin_mode.equals("IVADMINSCH") ){
				map = insertIVAdminDetailsSCH(connection, tabData,sqlMap,language_id);
			}
			else{
				map = insertAdminDetails(connection, tabData,sqlMap,language_id);
			}	
//	System.err.println("===admin_mode="+admin_mode+"====map===>"+map);
			if(((Boolean) map.get( "result" )).booleanValue() )  {
				boolean blnresult=true;
				if(admin_mode.equals("CDNOTADMIN"))
					blnresult = recordCouldNotAdmin(tabData,sqlMap);
				else if(admin_mode.equals("HOLD"))
					blnresult = recordHold(tabData,sqlMap);
				else if(admin_mode.equals("DISCONT"))
					blnresult = recordDiscontinue(tabData,sqlMap);
				else
					blnresult = updateADRDetails(tabData,sqlMap);
				//commented by uthra as it updats the remarks for the 2nd row insertion in ph_mend_admin
				//updateRemarks(tabData,sqlMap);
				//Adding start for MMS-DM-CRF-0157.2
	if(blnresult){
            barcode_remarks =(HashMap)tabData.get("barcode_remarks");



           if(barcode_remarks != null){
			   cs = connection.prepareCall("{call PR_INS_PR_BARCODE_SCAN_DETAILS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,sysdate,?,?,?) }");
                 	cs.setString(1,((String)COMMON_VALUES.get("facility_id")));
	                cs.setString(2,((String)barcode_remarks.get("module_id")));
	                cs.setString(3,((String)barcode_remarks.get("menu_id")));
	                cs.setString(4,((String)barcode_remarks.get("sub_menu_id")));
	                cs.setString(5,((String)COMMON_VALUES.get("patient_id")));
	                cs.setString(6,((String)barcode_remarks.get("encounter_id")));
	                cs.setString(7,"");
                    cs.setString(8,((String)barcode_remarks.get("patient_class")));
                    cs.setString(9,"");
                    cs.setString(10,"");
	                cs.setString(11,"");
	                cs.setString(12,"");
	                cs.setString(13,"");
	                cs.setString(14,"");
	                cs.setString(15,((String)barcode_remarks.get("entry_type")));
	                cs.setString(16,((String)barcode_remarks.get("resone_code")));
	                cs.setString(17,((String)barcode_remarks.get("resone_desc")));
	                cs.setString(18,((String)COMMON_VALUES.get("login_by_id")));
	                cs.setString(19,((String)COMMON_VALUES.get("login_at_ws_no")));
	                cs.setString(20,((String)COMMON_VALUES.get("facility_id")));
	                cs.setString(21,((String)COMMON_VALUES.get("login_by_id")));
	                cs.setString(22,((String)COMMON_VALUES.get("login_at_ws_no")));
	                cs.setString(23,((String)COMMON_VALUES.get("facility_id")));
	                cs.registerOutParameter(24,java.sql.Types.VARCHAR);
	                cs.execute();

					closeStatement( cs );

		   }//Adding end for MMS-DM-CRF-0157.2

		}
				if(blnresult){
					map.put( "result", new Boolean( true) ) ;
					map.put("msgid","RECORD_INSERTED");	
				}
				else{
					map.put( "result", new Boolean( false) ) ;
					map.put("msgid","TRANSACTION_FAILED");	
				}
			}
		}
		catch(Exception e){
			map.put( "msgid", "Exception in EJB : " + e.getMessage() ) ;
			e.printStackTrace();
		}
		finally{
			try{
				closeConnection(connection,prop );
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return map;
	}
	// insert method ends here

	public boolean updateADRDetails(HashMap tabData,HashMap sqlMap) {
		Connection connection						= null ;
		PreparedStatement pstmt_update_medn_admin	= null;
		final String SQL_PH_MEDN_ADMIN_UPDATE2		= (String)sqlMap.get("SQL_PH_MEDN_ADMIN_UPDATE2");
		HashMap reason			= (HashMap)tabData.get("ADR_REASON"); 
		ArrayList all_vals		= (ArrayList)tabData.get("ADR_ALL_VALUES");
		
		HashMap commonValues	= (HashMap)tabData.get("COMMON_VALUES");
		String facility_id		= (String)commonValues.get("facility_id");
		String added_by			=(String)commonValues.get("added_by");
		String ws_no			=(String)commonValues.get("ws_no");
		String language_id  = (String)tabData.get("language_id");

		String order_id			=	"";
		String encounter_id		=	"";
		String sch_date			=	"";
		String drug				=	"";
		ArrayList adr_vals		=	null;
		boolean blnresult = true;
		try{		   
			connection				= getConnection( (Properties)tabData.get("properties") ) ;
			if(all_vals != null && all_vals.size()>0){
				pstmt_update_medn_admin = connection.prepareStatement( SQL_PH_MEDN_ADMIN_UPDATE2) ;
				for(int i=0; i<all_vals.size(); i+=5) {
					order_id		=	(String)all_vals.get(i+1);
					encounter_id	=	(String)all_vals.get(i+2);
					drug			=	(String)all_vals.get(i+3);
					sch_date		=	(String)all_vals.get(i+4);
					
					if(reason.containsKey(facility_id+"_"+order_id+"_"+encounter_id+"_"+drug+"_"+sch_date)) {
						adr_vals	=	(ArrayList)(reason.get(facility_id+"_"+order_id+"_"+encounter_id+"_"+drug+"_"+sch_date));
						if(adr_vals.size() >=5) {
							
							pstmt_update_medn_admin.setString(1,DateUtils.convertDate((String)adr_vals.get(0), "DMYHM",language_id,"en"));
							pstmt_update_medn_admin.setString(2,(String)adr_vals.get(1));
							pstmt_update_medn_admin.setString(3,(String)adr_vals.get(3));
							pstmt_update_medn_admin.setString(4,DateUtils.convertDate((String)adr_vals.get(2), "DMYHM",language_id,"en"));
							pstmt_update_medn_admin.setString(5,(String)adr_vals.get(4));
							pstmt_update_medn_admin.setString(6,added_by);
							pstmt_update_medn_admin.setString(7,ws_no);
							pstmt_update_medn_admin.setString(8,facility_id);
							pstmt_update_medn_admin.setString(9,facility_id);
							pstmt_update_medn_admin.setString(10,encounter_id);
							pstmt_update_medn_admin.setString(11,DateUtils.convertDate(sch_date, "DMYHM",language_id,"en"));
							pstmt_update_medn_admin.setString(12,drug);
							pstmt_update_medn_admin.setString(13,order_id);
							int te=pstmt_update_medn_admin.executeUpdate();
							if(te == 1){
								connection.commit();
								blnresult = true;
							}
						}
					}
			   }
			}
		}
		catch(Exception e){
			e.printStackTrace();
			blnresult = false;
		}
		finally{
			try{					
				closeStatement( pstmt_update_medn_admin ) ;
				closeConnection( connection,prop );
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return blnresult;
	}

	public void updateRemarks(HashMap tabData,HashMap sqlMap){
		Connection connection						= null ;
		PreparedStatement pstmt_update	= null;
		prop = (Properties)tabData.get("properties");
		final String SQL_PH_MEDN_ADMIN_FT_IV_UPDATE1		= (String)sqlMap.get("SQL_PH_MEDN_ADMIN_FT_IV_UPDATE1");
		ArrayList update_remarks = (ArrayList)tabData.get("update_remarks"); 
		HashMap commonValues	= (HashMap)tabData.get("COMMON_VALUES");
		String facility_id		= (String)commonValues.get("facility_id");
		String added_by			=(String)commonValues.get("added_by");
		String ws_no			=(String)commonValues.get("ws_no");

		try{
			if(update_remarks != null && update_remarks.size() > 0){
			   	connection		= getConnection( prop ) ;
				pstmt_update = connection.prepareStatement(SQL_PH_MEDN_ADMIN_FT_IV_UPDATE1) ;
			   	pstmt_update.setString(1,(String)update_remarks.get(1));
				pstmt_update.setString(2,(String)update_remarks.get(2));
				pstmt_update.setString(3,(String)update_remarks.get(3));
				pstmt_update.setString(4,added_by);
				pstmt_update.setString(5,ws_no);    
				pstmt_update.setString(6,facility_id);
				pstmt_update.setString(7,(String)update_remarks.get(6));
				pstmt_update.setString(8,(String)update_remarks.get(7));
				pstmt_update.setString(9,(String)update_remarks.get(8));
				int te=pstmt_update.executeUpdate();
				if(te == 1){
					connection.commit();
				}
			}	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{					
				closeStatement( pstmt_update) ;
				closeConnection( connection,prop );
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	public HashMap insertAdminDetails(Connection connection, HashMap tabData, HashMap sqlMap, String language_id) throws Exception{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		prop						= (Properties)tabData.get("properties");
		ArrayList non_iv_drugs		= (ArrayList)tabData.get("NON_IV_DRUGS");
		HashMap alt_drug_details	= (HashMap)tabData.get("ALTERNATE_DRUGS");
		ArrayList iv_drugs			= (ArrayList)tabData.get("IV_DRUGS");
		HashMap commonValues		= (HashMap)tabData.get("COMMON_VALUES");
		ArrayList dispTMP			= (ArrayList)tabData.get("DISP_DTLS");
		HashMap adr_values			= (HashMap)tabData.get("ADR_VALUES");
		HashMap stock_srl		=(HashMap)tabData.get("stock_srl");
		HashMap hmAddedTaperSch		=(HashMap)tabData.get("AddedTaperSch");
					
		//final String SQL_PH_MEDN_ADMIN_FT_UPDATE					= (String)sqlMap.get("SQL_PH_MEDN_ADMIN_FT_UPDATE");
		final String SQL_PH_MEDN_ADMIN_FT_UPDATE					= "UPDATE PH_MEDN_ADMIN SET ADMIN_NURSING_UNIT_CODE=?, ADMIN_BED_NO=?, ADMIN_BY = ? , ADMIN_REMARKS=?, NON_ADMIN_REMARKS=?,ADMIN_RECORDED_YN=?, ADMIN_RECORDED_DATE_TIME=SYSDATE,  ADMIN_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'), ADMINISTERED_YN=? ,MODIFIED_FACILITY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_BY_ID=?, MODIFIED_AT_WS_NO=?,ADMIN_CODE = nvl(?, ADMIN_CODE) ,NON_ADMIN_CODE = nvl(?, NON_ADMIN_CODE),ADMIN_RECORDED_BY  = ? ,ADMIN_AUTHORIZED_BY = ?,AGAINST_SCHDOSE_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'), ADR_REASON_CODE=?, ADR_REMARKS=?, ADR_RECORDED_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'), ADR_RECORDED_BY=?, SLIDING_SCALE_YN=?, SLIDING_SCALE_ADM_UNIT=?, SLIDING_SCALE_ADM_UOM=?, SLIDING_SCALE_RANGE_UNIT=?, SLIDING_SCALE_RANGE_UOM=? , MEDN_BROUGHT_BY_PATIENT_YN = ?, ADMN_DOSE_CHNG_REMARKS=?, ADMIN_BY_TYPE=?, SELF_ADMIN_BY=? WHERE   FACILITY_ID=? AND ENCOUNTER_ID=? AND SCH_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI') AND ORD_DRUG_CODE=? AND DOSAGE_SEQ_NO=? and order_id=?";
		final String SQL_PH_MEDN_ADMIN_DTL_FT_INSERT				= (String)sqlMap.get("SQL_PH_MEDN_ADMIN_DTL_FT_INSERT");
		final String SQL_PH_MEDN_ADMIN_PAT_DRUG_PROFILE_FT_UPDATE	= (String)sqlMap.get("SQL_PH_MEDN_ADMIN_PAT_DRUG_PROFILE_FT_UPDATE");
		final String SQL_PH_MEDN_ADMIN_PAT_DRUG_PROFILE_FT_UPDATE1	= (String)sqlMap.get("SQL_PH_MEDN_ADMIN_PAT_DRUG_PROFILE_FT_UPDATE1");

		//final String SQL_PH_MEDN_ADMIN_FT_INSERT					= (String)sqlMap.get("SQL_PH_MEDN_ADMIN_FT_INSERT");
		SQL_PH_MED_ADMIN_FT_SELECT9					= (String)sqlMap.get("SQL_PH_MED_ADMIN_FT_SELECT9");
		//final String SQL_PH_MEDN_ADMIN_FT_IV_UPDATE					= (String)sqlMap.get("SQL_PH_MEDN_ADMIN_FT_IV_UPDATE");
		final String SQL_PH_MEDN_ADMIN_FT_IV_UPDATE	=	"UPDATE PH_MEDN_ADMIN SET ADMIN_NURSING_UNIT_CODE=?, ADMIN_BED_NO=?, ADMIN_BY = ? , ADMIN_REMARKS=?, NON_ADMIN_REMARKS=?,ADMIN_RECORDED_YN=?, ADMIN_RECORDED_DATE_TIME=SYSDATE,  ADMIN_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'), ADMINISTERED_YN=? ,MODIFIED_FACILITY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_BY_ID=?, MODIFIED_AT_WS_NO=? ,SCH_INFUSION_RATE=?, SCH_INFUSION_VOL_STR_UNIT=?, SCH_INFUSION_PER_UNIT=?, SCH_INFUSION_PERIOD=?, SCH_INFUSION_PERIOD_UNIT=? ,ADMIN_CODE=? ,NON_ADMIN_CODE = ?,ADMIN_RECORDED_BY  = ? ,ADMIN_AUTHORIZED_BY = ?,AGAINST_SCHDOSE_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'), ADR_REASON_CODE=?, ADR_REMARKS=?, ADR_RECORDED_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'), ADR_RECORDED_BY=?,ADMN_DOSE_CHNG_REMARKS=?, ACT_END_DATE_TIME=nvl( ACT_END_DATE_TIME ,?) WHERE FACILITY_ID=? AND ENCOUNTER_ID=? AND SCH_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI') AND ORD_DRUG_CODE=? AND DOSAGE_SEQ_NO=? and order_id =?";
		final String SQL_PH_MED_ADMIN_DOSAGE_SEQ_NO					= (String)sqlMap.get("SQL_PH_MED_ADMIN_DOSAGE_SEQ_NO");
		//final String SQL_PH_MED_ADMIN_MEDN_ADMIN_VALUES				= (String)sqlMap.get("SQL_PH_MED_ADMIN_MEDN_ADMIN_VALUES");
		//final String SQL_PH_MED_ADMIN_MEDN_ADMIN_FREQ_NATURE		= (String)sqlMap.get("SQL_PH_MED_ADMIN_MEDN_ADMIN_FREQ_NATURE");
		//final String SQL_PH_MED_ADMIN_FT_SELECT_DOSES				= (String)sqlMap.get("SQL_PH_MED_ADMIN_FT_SELECT_DOSES");
		SQL_PH_ADMIN_OR_ORDER_SELECT				=	(String)sqlMap.get("SQL_PH_ADMIN_OR_ORDER_SELECT");
		final String SQL_PH_MEDN_ADMIN_FT_INSERT1	=	(String)sqlMap.get("SQL_PH_MEDN_ADMIN_FT_INSERT1");
		final String SQL_PH_MED_ADMIN_FT_SELECT17	=	(String)sqlMap.get("SQL_PH_MED_ADMIN_FT_SELECT17");
		//final String SQL_PH_MEDN_ADMIN_FT_INSERT2	=	(String)sqlMap.get("SQL_PH_MEDN_ADMIN_FT_INSERT2");
		final String SQL_PH_MED_ADMIN_FT_SELECT18	=	(String)sqlMap.get("SQL_PH_MED_ADMIN_FT_SELECT18");
		final String SQL_PH_MED_ADMIN_FT_SELECT19	=	(String)sqlMap.get("SQL_PH_MED_ADMIN_FT_SELECT19");
		final String SQL_PH_PRESCRIPTION_SELECT86	=	(String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT86");
		final String SQL_PH_PRESCRIPTION_SELECT1	=	(String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT1");
		final String SQL_PH_MED_ADMIN_FT_SELECT27	=	(String)sqlMap.get("SQL_PH_MED_ADMIN_FT_SELECT27");
		//final String SQL_PH_MEDN_ADMIN_OR_ORDER_LINE_PH_UPDATE	=	(String)sqlMap.get("SQL_PH_MEDN_ADMIN_OR_ORDER_LINE_PH_UPDATE"); //Commented for COMMON-ICN-0048

		String facility_id		=(String)commonValues.get("facility_id");
		String admin_by			=(String)commonValues.get("admin_by");
		String added_by			=(String)commonValues.get("added_by");
		String ws_no			=(String)commonValues.get("ws_no");
		String encounter_id		=(String)commonValues.get("encounter_id");
		String assign_bed_num	=(String)commonValues.get("assign_bed_num");
		String nursing_unit		=(String)commonValues.get("nursing_unit");
		String patient_id		=(String)commonValues.get("patient_id");
        commonValues.put("disp_locn_code_MAR",(String)tabData.get("disp_locn_code_MAR"));
		//if((String)tabData.get("disp_locn_code_MAR").equals(""))
		// commonValues.put("disp_locn_code_MAR",(String)tabData.get("disp_locn_code"));

		
		//Connection connection = null ;
		PreparedStatement pstmt_update_medn_admin = null,pstmt_insert_medn_admin=null,pstmt_insert_medn_admin_dtl=null,pstmt_update_patient_drug_profile=null,pstmt_insert_patient_drug_profile=null;//,pstmt_update_or_order_line_ph=null;//COMMENTED pstmt_update_or_order_line_ph FOR COMMON-ICN-0048
		PreparedStatement pstmt_select	=	null;
		PreparedStatement pstmt_select_cancel_yn	=	null;//added for jd-crf-0200
		PreparedStatement pstmt_select_cancel_yn_update=null;//added for jd-crf-0200
		PreparedStatement pstmt_MFRYN	=	null;
		PreparedStatement pstmt_unit	=	null;
		PreparedStatement pstmt_select1	=	null;
		PreparedStatement pstmt_select2	=	null;
		PreparedStatement pstmt_select2A=	null;
		PreparedStatement pstmt_select3	=	null;
		ResultSet resultSet				=	null;
		ResultSet resultSet_cancel_yn				=	null;//added for jd-crf-0200
		int cancelCnt = 0;//added for jd-crf-0200
		ResultSet resultSetunit			=	null;
		ResultSet resultSet1			=	null;
		ResultSet resultSet2A			=	null;
		ResultSet resultSet_MFRYN		=	null;
		String freq_nat					=	"";
		String Auto_admin		="", administered_yn="";
		boolean blnAddedTaperSch = false;
		String nextDosageSeqNo = "", currDosageSeqNo;
		String key="", tapScheDateTime="";
		int count=1;
		try{
			//connection = getConnection( prop ) ;
			
			/***************************************************
							FOR SCHEDULED DRUGS
			****************************************************/
			pstmt_select1			= connection.prepareStatement( SQL_PH_MED_ADMIN_FT_SELECT18 ) ;					
			pstmt_select3	=	connection.prepareStatement( SQL_PH_PRESCRIPTION_SELECT1 ) ;
			for(int i=0;i<non_iv_drugs.size();i=i+50){//Changed 45 to 46 //Modified from 44 to 45 for HSA-CRF-0090,code 'i=i+43' is replaced by 'i=i+44' for CRF-PH- RUT-CRF-0088[IN043881] // 46 changed to 50 for GHL-CRF-0482
				key = facility_id+"~"+encounter_id+"~"+((String)non_iv_drugs.get(i+14)).trim()+"~"+((String)non_iv_drugs.get(i)).trim()+"~"+((String)non_iv_drugs.get(i+3)).trim(); //facility_id+"~"+encounter_id+"~"+order_id+"~"+drug_code+"~"+sch_date_time
				if(hmAddedTaperSch!=null && hmAddedTaperSch.containsKey(key)){
					blnAddedTaperSch = true;
					nextDosageSeqNo = getDosageSeqNo(((String)non_iv_drugs.get(i+14)).trim(),facility_id, encounter_id, ((String)non_iv_drugs.get(i+3)).trim(), ((String)non_iv_drugs.get(i)).trim(), SQL_PH_MED_ADMIN_DOSAGE_SEQ_NO);
					hmAddedTaperSch.put(key, (String)non_iv_drugs.get(i+1) ); //Old seq_no
					non_iv_drugs.set(i+1, nextDosageSeqNo+"");
				}
			}
			if(isCurentRowAdministeredByOtherUser(connection,non_iv_drugs,iv_drugs,facility_id,encounter_id)){
				connection.rollback();
				map.put( "result", new Boolean( false) ) ;
				map.put("msgid","ADMIN_BY_OTHERS");	
				return map;
			}
			String function_from = (String)tabData.get("function_from");
			if(non_iv_drugs.size()>0){
				
				pstmt_select			= connection.prepareStatement( SQL_PH_MED_ADMIN_FT_SELECT17 ) ;	
				//pstmt_select			= connection.prepareStatement( "SELECT ceil(((NVL(A.ORDER_QTY,0)*C.CONTENT_IN_PRES_BASE_UOM)-(NVL(B.TOT_ADMINISTERED_QTY,0)+?))/C.CONTENT_IN_PRES_BASE_UOM) DIFF_QTY FROM OR_ORDER_LINE A,PH_PATIENT_DRUG_PROFILE B,PH_DRUG C WHERE A.ORDER_ID=B.ORIG_ORDER_ID  AND A.ORDER_LINE_NUM=B.ORIG_ORDER_LINE_NO AND A.ORDER_ID=? AND A.ORDER_LINE_NUM=? AND A.ORDER_CATALOG_CODE = C.DRUG_CODE" ) ;	
				//pstmt_insert_medn_admin	= connection.prepareStatement( SQL_PH_MEDN_ADMIN_FT_INSERT2 ) ;		
				//pstmt_insert_medn_admin	= connection.prepareStatement( "INSERT INTO PH_MEDN_ADMIN (FACILITY_ID,ENCOUNTER_ID,SCH_DATE_TIME,ORD_DRUG_CODE,DOSAGE_SEQ_NO,ORDER_ID,ORDER_LINE_NUM,PATIENT_ID,PRACT_ID,SCH_DOSAGE_QTY,SCH_DOSAGE_UOM_CODE,SCH_STRENGTH,SCH_STRENGTH_UOM,SCH_ROUTE_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,VERIFY_REQD_YN,ADMINISTERED_YN) (SELECT FACILITY_ID,ENCOUNTER_ID,TO_DATE(TO_CHAR((SYSDATE+1/1440),'DD/MM/YYYY HH24:MI'),'DD/MM/YYYY HH24:MI') SDATE,ORD_DRUG_CODE,(DOSAGE_SEQ_NO)+1,ORDER_ID,ORDER_LINE_NUM,PATIENT_ID,PRACT_ID,?,SCH_DOSAGE_UOM_CODE,?,?,SCH_ROUTE_CODE,?,SYSDATE,?,?,?,SYSDATE,?,?,VERIFY_REQD_YN,'N' FROM PH_MEDN_ADMIN WHERE FACILITY_ID=? AND ENCOUNTER_ID=? AND SCH_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI') AND ORD_DRUG_CODE=? AND ORDER_ID=? AND ORDER_LINE_NUM=?)" ) ;	

				//pstmt_insert_medn_admin	= connection.prepareStatement( "INSERT INTO PH_MEDN_ADMIN (FACILITY_ID,ENCOUNTER_ID,SCH_DATE_TIME,ORD_DRUG_CODE,DOSAGE_SEQ_NO,ORDER_ID,ORDER_LINE_NUM,PATIENT_ID,PRACT_ID,SCH_DOSAGE_QTY,SCH_DOSAGE_UOM_CODE,SCH_STRENGTH,SCH_STRENGTH_UOM,SCH_ROUTE_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,VERIFY_REQD_YN,ADMINISTERED_YN,ADMN_DOSE_CHNG_REMARKS) (SELECT FACILITY_ID,ENCOUNTER_ID,(CASE WHEN (TO_DATE (TO_CHAR ((SYSDATE + 1 / 1440), 'DD/MM/YYYY HH24:MI'), 'DD/MM/YYYY HH24:MI' ) ) =(SELECT sch_date_time FROM ph_medn_admin  WHERE facility_id = ? AND encounter_id = ? AND sch_date_time = TO_DATE (?, 'DD/MM/YYYY HH24:MI')  AND ord_drug_code = ? AND order_id = ? AND order_line_num = ?) THEN TO_DATE (TO_CHAR ((SYSDATE + 2 / 1440),'DD/MM/YYYY HH24:MI' ),'DD/MM/YYYY HH24:MI' )  ELSE TO_DATE(TO_CHAR ((SYSDATE + 1 / 1440), 'DD/MM/YYYY HH24:MI'  ), 'DD/MM/YYYY HH24:MI'  ) END           ) SDATE,ORD_DRUG_CODE,(DOSAGE_SEQ_NO)+1,ORDER_ID,ORDER_LINE_NUM,PATIENT_ID,PRACT_ID,?,SCH_DOSAGE_UOM_CODE,?,?,SCH_ROUTE_CODE,?,SYSDATE,?,?,?,SYSDATE,?,?,VERIFY_REQD_YN,'N',? FROM PH_MEDN_ADMIN WHERE FACILITY_ID=? AND ENCOUNTER_ID=? AND SCH_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI') AND ORD_DRUG_CODE=? AND ORDER_ID=? AND ORDER_LINE_NUM=?)" ) ;	
				pstmt_insert_medn_admin	= connection.prepareStatement( "INSERT INTO PH_MEDN_ADMIN (FACILITY_ID,ENCOUNTER_ID,SCH_DATE_TIME,ORD_DRUG_CODE,DOSAGE_SEQ_NO,ORDER_ID,ORDER_LINE_NUM,PATIENT_ID,PRACT_ID,SCH_DOSAGE_QTY,SCH_DOSAGE_UOM_CODE,SCH_STRENGTH,SCH_STRENGTH_UOM,SCH_ROUTE_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,VERIFY_REQD_YN,ADMINISTERED_YN,ADMN_DOSE_CHNG_REMARKS) (SELECT FACILITY_ID,ENCOUNTER_ID, decode(?, null, (CASE WHEN (TO_DATE (TO_CHAR (((case when sysdate>to_date(?,'dd/mm/yyyy hh24:mi') then sysdate else to_date(?,'dd/mm/yyyy hh24:mi') end) + 1 / 1440), 'DD/MM/YYYY HH24:MI'), 'DD/MM/YYYY HH24:MI' ) ) =(SELECT sch_date_time FROM ph_medn_admin  WHERE facility_id = ? AND encounter_id = ? AND sch_date_time = TO_DATE (?, 'DD/MM/YYYY HH24:MI')  AND ord_drug_code = ? AND order_id = ? AND order_line_num = ?) THEN TO_DATE (TO_CHAR (((case when sysdate>to_date(?,'dd/mm/yyyy hh24:mi') then sysdate else to_date(?,'dd/mm/yyyy hh24:mi') end) + 2 / 1440),'DD/MM/YYYY HH24:MI' ),'DD/MM/YYYY HH24:MI' )  ELSE TO_DATE(TO_CHAR (((case when sysdate>to_date(?,'dd/mm/yyyy hh24:mi') then sysdate else to_date(?,'dd/mm/yyyy hh24:mi') end) + 1 / 1440), 'DD/MM/YYYY HH24:MI'  ), 'DD/MM/YYYY HH24:MI' ) END ), TO_DATE (?,'dd/mm/yyyy hh24:mi')) SDATE,ORD_DRUG_CODE, decode(?,null, (DOSAGE_SEQ_NO)+1 , ?), ORDER_ID,ORDER_LINE_NUM,PATIENT_ID,PRACT_ID,?,SCH_DOSAGE_UOM_CODE,decode(?,null,SCH_STRENGTH,?),decode(?, null, SCH_STRENGTH_UOM,?), SCH_ROUTE_CODE,?,SYSDATE,?,?,?,SYSDATE,?,?,VERIFY_REQD_YN,'N',? FROM PH_MEDN_ADMIN WHERE FACILITY_ID=? AND ENCOUNTER_ID=? AND SCH_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI') AND ORD_DRUG_CODE=? AND ORDER_ID=? AND ORDER_LINE_NUM=? and DOSAGE_SEQ_NO = ?)" ) ;	

				float diff_qty	=	0.0f;
				//code modified i+23 to i+24 
				for(int i=0;i<non_iv_drugs.size();i=i+50){//Changed 45 to 46 //Modified from 44 to 45 for HSA-CRF-0090,code 'i=i+43' is replaced by 'i=i+44' for CRF-PH- RUT-CRF-0088[IN043881] // 46 changed to 50 for GHL-CRF-0482
					Auto_admin				=(String)non_iv_drugs.get(i+39);
				//for(int i=0;i<non_iv_drugs.size();i=i+37){			
					pstmt_select1.setString(1,(String)non_iv_drugs.get(i+14));
					pstmt_select1.setString(2,(String)non_iv_drugs.get(i+15));

					resultSet1	=	pstmt_select1.executeQuery();
					if(resultSet1.next()){
						freq_nat	=	resultSet1.getString("FREQ_NATURE");
					}
					blnAddedTaperSch = false;
					nextDosageSeqNo="";
					tapScheDateTime="";
					key = facility_id+"~"+encounter_id+"~"+((String)non_iv_drugs.get(i+14)).trim()+"~"+((String)non_iv_drugs.get(i)).trim()+"~"+((String)non_iv_drugs.get(i+3)).trim(); //facility_id+"~"+encounter_id+"~"+order_id+"~"+drug_code+"~"+sch_date_time
					currDosageSeqNo = (String)non_iv_drugs.get(i+1);
					if(hmAddedTaperSch!=null && hmAddedTaperSch.containsKey(key)){
						blnAddedTaperSch = true;
						nextDosageSeqNo = currDosageSeqNo;
						diff_qty = Float.parseFloat(non_iv_drugs.get(i+8)==null?"1":(String)non_iv_drugs.get(i+8));
						tapScheDateTime = ((String)non_iv_drugs.get(i+3)).trim();
						currDosageSeqNo =(String) hmAddedTaperSch.get(key);
					}
					if((freq_nat.equals("P") || blnAddedTaperSch) && !function_from.equals("SCH")){ //adding new schedule record for PRN freqency on administer of a PRN schedule
						if(!blnAddedTaperSch){
							pstmt_select.setString(1,(String)non_iv_drugs.get(i+8));
							pstmt_select.setString(2,(String)non_iv_drugs.get(i+14));
							pstmt_select.setString(3,(String)non_iv_drugs.get(i+15));
							resultSet	=	pstmt_select.executeQuery();
							if(resultSet.next()){
								diff_qty	= resultSet.getFloat("DIFF_QTY");
							}
							//added for jd-crf-0200 start
						
							pstmt_select_cancel_yn	=	connection.prepareStatement( "select count(*) count from ph_medn_admin where   sch_date_time = TO_DATE (?, 'DD/MM/YYYY HH24:MI') AND dosage_seq_no = ? AND order_id = ? AND order_line_num = ? and CANCEL_RECORDED_YN='Y'" ) ;	
							
							 pstmt_select_cancel_yn.setString(1,((String)non_iv_drugs.get(i+3)).trim());
							// if(nextDosageSeqNo == "")
							 pstmt_select_cancel_yn.setString(2,currDosageSeqNo);
							 //else
								// pstmt_select_cancel_yn.setString(2,nextDosageSeqNo);
							 
							 pstmt_select_cancel_yn.setString(3,(String)non_iv_drugs.get(i+14));
							 pstmt_select_cancel_yn.setString(4,(String)non_iv_drugs.get(i+15));
							 resultSet_cancel_yn=pstmt_select_cancel_yn.executeQuery();
							while(resultSet_cancel_yn.next()){
							 cancelCnt=Integer.parseInt((String)resultSet_cancel_yn.getString("count")==null?"":(String)resultSet_cancel_yn.getString("count") );
							}
							resultSet_cancel_yn.close();
							pstmt_select_cancel_yn.close();
							
							
							////added for jd-crf-0200 end
							if((diff_qty>0 || blnAddedTaperSch ) && cancelCnt >0 && freq_nat.equals("P") ){
								
								
								 pstmt_select_cancel_yn_update	=	connection.prepareStatement("UPDATE ph_medn_admin SET SCH_DOSAGE_QTY =?  WHERE ORDER_ID= ? AND ORDER_LINE_NUM=? AND ADMINISTERED_YN <>'Y'");
								 pstmt_select_cancel_yn_update.setString(1,diff_qty+"");
									 
								 pstmt_select_cancel_yn_update.setString(2,(String)non_iv_drugs.get(i+14));
								 pstmt_select_cancel_yn_update.setString(3,(String)non_iv_drugs.get(i+15));
								 pstmt_select_cancel_yn_update.executeUpdate();
								 pstmt_select_cancel_yn_update.close();
							
							}
							}
						if((diff_qty>0 || blnAddedTaperSch ) && cancelCnt == 0){
							count = 1;
							pstmt_insert_medn_admin.setString(count++,tapScheDateTime); //1
							pstmt_insert_medn_admin.setString(count++,((String)non_iv_drugs.get(i+3)).trim());
							pstmt_insert_medn_admin.setString(count++,((String)non_iv_drugs.get(i+3)).trim());
							pstmt_insert_medn_admin.setString(count++,facility_id);
							pstmt_insert_medn_admin.setString(count++,encounter_id); //5
							pstmt_insert_medn_admin.setString(count++,((String)non_iv_drugs.get(i+3)).trim()); //sch_date_time
							pstmt_insert_medn_admin.setString(count++,((String)non_iv_drugs.get(i)).trim());  // ord drug code
							pstmt_insert_medn_admin.setString(count++,(String)non_iv_drugs.get(i+14));   // order id
							pstmt_insert_medn_admin.setString(count++,(String)non_iv_drugs.get(i+15));   // order line no
							pstmt_insert_medn_admin.setString(count++,((String)non_iv_drugs.get(i+3)).trim()); //10
							pstmt_insert_medn_admin.setString(count++,((String)non_iv_drugs.get(i+3)).trim());
							pstmt_insert_medn_admin.setString(count++,((String)non_iv_drugs.get(i+3)).trim());
							pstmt_insert_medn_admin.setString(count++,((String)non_iv_drugs.get(i+3)).trim());
							pstmt_insert_medn_admin.setString(count++,tapScheDateTime); //14
							pstmt_insert_medn_admin.setString(count++,nextDosageSeqNo);
							pstmt_insert_medn_admin.setString(count++,nextDosageSeqNo);
							pstmt_insert_medn_admin.setString(count++,diff_qty+"");
							pstmt_insert_medn_admin.setString(count++,((String)non_iv_drugs.get(i+32)).trim());
							pstmt_insert_medn_admin.setString(count++,((String)non_iv_drugs.get(i+32)).trim());
							pstmt_insert_medn_admin.setString(count++,((String)non_iv_drugs.get(i+33)).trim());
							pstmt_insert_medn_admin.setString(count++,((String)non_iv_drugs.get(i+33)).trim());
							pstmt_insert_medn_admin.setString(count++,added_by); //20
							pstmt_insert_medn_admin.setString(count++,ws_no);
							pstmt_insert_medn_admin.setString(count++,facility_id);
							pstmt_insert_medn_admin.setString(count++,added_by);
							pstmt_insert_medn_admin.setString(count++,ws_no);
							pstmt_insert_medn_admin.setString(count++,facility_id); //25
							pstmt_insert_medn_admin.setString(count++,(String)non_iv_drugs.get(i+35));   // admin_chng_reason_code
							pstmt_insert_medn_admin.setString(count++,facility_id);
							pstmt_insert_medn_admin.setString(count++,encounter_id);	
							pstmt_insert_medn_admin.setString(count++,((String)non_iv_drugs.get(i+3)).trim()); //sch_date_time
							pstmt_insert_medn_admin.setString(count++,((String)non_iv_drugs.get(i)).trim());  // ord drug code //30
							pstmt_insert_medn_admin.setString(count++,(String)non_iv_drugs.get(i+14));   // order id
							pstmt_insert_medn_admin.setString(count++,(String)non_iv_drugs.get(i+15));   // order line no //32
							pstmt_insert_medn_admin.setString(count++,currDosageSeqNo);   // dosage_seq_no //33
							pstmt_insert_medn_admin.addBatch();
						}
						
						int result[]=pstmt_insert_medn_admin.executeBatch();
						for (int k=0;k<result.length ;k++ ){
							
							// A number greater than or equal to zero  indicates success
							// A number -2 indicates that command is successful but number of rows updated is unknow
							// If it won't satisfy any of the above cancel the statement and throw an exception
							if(result[k]<0  && result[k] != -2 ){
								pstmt_insert_medn_admin.cancel();
								connection.rollback();
								System.err.println("Failed while inserting PH_MEDN_ADMIN Table");				
								throw new EJBException("Insertion Failed.........");
							}
						}
					}
				}
				closeStatement(pstmt_insert_medn_admin);
			}
			PreparedStatement psAuditLog = null;// Added for AAKH-CRF-0024 [IN:038260]
			if(non_iv_drugs.size()>0){	// update ph_med_admin 
				pstmt_update_medn_admin = connection.prepareStatement( SQL_PH_MEDN_ADMIN_FT_UPDATE ) ;
				for(int i=0;i<non_iv_drugs.size();i=i+50){//Changed 45 to 46 //Modified from 44 to 45 for HSA-CRF-0090,code 'i=i+43' is replaced by 'i=i+44' for CRF-PH- RUT-CRF-0088[IN043881] // 46 changed to 50 for GHL-CRF-0482
				//for(int i=0;i<non_iv_drugs.size();i=i+37){
					count=1;
					administered_yn = non_iv_drugs.get(i+4)==null?"":(String)non_iv_drugs.get(i+4);
					pstmt_update_medn_admin.setString(count,nursing_unit);						//ADMIN_NURSING_UNIT_CODE
					pstmt_update_medn_admin.setString(++count,assign_bed_num);					//ADMIN_BED_NO
					pstmt_update_medn_admin.setString(++count,admin_by);						//ADMIN_BY //admin_by
					pstmt_update_medn_admin.setString(++count,(String)non_iv_drugs.get(i+6));	//ADMIN_REMARKS
					pstmt_update_medn_admin.setString(++count,(String)non_iv_drugs.get(i+7));	//NON_ADMIN_REMARKS
					pstmt_update_medn_admin.setString(++count,(String)non_iv_drugs.get(i+5));	//ADMIN_RECORDED_YN
					pstmt_update_medn_admin.setString(++count,(String)non_iv_drugs.get(i+2));	//ADMIN_DATE_TIME
					pstmt_update_medn_admin.setString(++count,(String)non_iv_drugs.get(i+4));	//ADMINISTERED_YN
					pstmt_update_medn_admin.setString(++count,facility_id);						//MODIFIED_FACILITY_ID
					pstmt_update_medn_admin.setString(++count,added_by);						//MODIFIED_BY_ID
					pstmt_update_medn_admin.setString(++count,ws_no);							//MODIFIED_AT_WS_NO
					
					if(administered_yn.equals("Y")) 
						pstmt_update_medn_admin.setString(++count,(String)non_iv_drugs.get(i+16));	// ADMIN_CODE added for mms-kh-crf-0010
					else
						pstmt_update_medn_admin.setString(++count,"");	//ADMIN_CODE added for mms-kh-crf-0010
					if(!administered_yn.equals("Y")) 
						pstmt_update_medn_admin.setString(++count,(String)non_iv_drugs.get(i+16));	// NON_ADMIN_CODE
					else
						pstmt_update_medn_admin.setString(++count,"");	// NON_ADMIN_CODE
					if(((String)non_iv_drugs.get(i+17)).equals("")) {
						pstmt_update_medn_admin.setString(++count,admin_by);	// ADMIN_RECORDED_BY
					}
					else {
						pstmt_update_medn_admin.setString(++count,(String)non_iv_drugs.get(i+17));	// ADMIN_RECORDED_BY
					}
					pstmt_update_medn_admin.setString(++count,(String)non_iv_drugs.get(i+18));	// ADMIN_AUTHORIZED_BY
					if(adr_values!=null && adr_values.containsKey((String)non_iv_drugs.get(i)+"-"+(String)non_iv_drugs.get(i+3))){
						
						ArrayList arr_list =(ArrayList) adr_values.get((String)non_iv_drugs.get(i)+"-"+(String)non_iv_drugs.get(i+3));

						pstmt_update_medn_admin.setString(++count,(String)arr_list.get(0));	//	// AGAINST_SCHDOSE_DATE_TIME   					
						pstmt_update_medn_admin.setString(++count,(String)arr_list.get(1));	//	// ADR_REASON_CODE             					
						pstmt_update_medn_admin.setString(++count,(String)arr_list.get(3));	//	// ADR_REMARKS                 					
						pstmt_update_medn_admin.setString(++count,(String)arr_list.get(2));	//	// ADR_RECORDED_DATE_TIME      					
						pstmt_update_medn_admin.setString(++count,(String)arr_list.get(4));	//	// ADR_RECORDED_BY             		
					}
					else{
						pstmt_update_medn_admin.setString(++count,"");	//	// AGAINST_SCHDOSE_DATE_TIME   					
						pstmt_update_medn_admin.setString(++count,"");	//	// ADR_REASON_CODE             					
						pstmt_update_medn_admin.setString(++count,"");	//	// ADR_REMARKS                 					
						pstmt_update_medn_admin.setString(++count,"");	//	// ADR_RECORDED_DATE_TIME      					
						pstmt_update_medn_admin.setString(++count,"");	//	// ADR_RECORDED_BY             					
					}
					pstmt_update_medn_admin.setString(++count,((String)non_iv_drugs.get(i+27)).trim()); //SLIDING_SCALE_YN
					pstmt_update_medn_admin.setString(++count,((String)non_iv_drugs.get(i+28)).trim());	//SLIDING_SCALE_ADMIN_UNIT			
					pstmt_update_medn_admin.setString(++count,((String)non_iv_drugs.get(i+29)).trim()); //SLIDING_SCALE_ADMIN_UOM
					pstmt_update_medn_admin.setString(++count,((String)non_iv_drugs.get(i+30)).trim()); //SLIDING_SCALE_RANGE_UNIT
					pstmt_update_medn_admin.setString(++count,((String)non_iv_drugs.get(i+31)).trim()); //SLIDING_SCALE_RANGE_UOM					
					pstmt_update_medn_admin.setString(++count,((String)non_iv_drugs.get(i+34)).trim()); //MEDN_BROUGHT_BY_PATIENT_YN					
					pstmt_update_medn_admin.setString(++count,((String)non_iv_drugs.get(i+35)).trim()); //ADMN_DOSE_CHNG_REASON
					pstmt_update_medn_admin.setString(++count,((String)non_iv_drugs.get(i+41)).trim()); //ADMIN_BY_TYPE
					pstmt_update_medn_admin.setString(++count,((String)non_iv_drugs.get(i+42)).trim()); //SELF_ADMIN_BY
					pstmt_update_medn_admin.setString(++count,facility_id.trim());						//FACILITY_ID
					pstmt_update_medn_admin.setString(++count,encounter_id.trim());						//ENCOUNTER_ID
					pstmt_update_medn_admin.setString(++count,((String)non_iv_drugs.get(i+3)).trim());	//SCH_DATE_TIME
					pstmt_update_medn_admin.setString(++count,((String)non_iv_drugs.get(i)).trim());	//ORD_DRUG_CODE
					pstmt_update_medn_admin.setString(++count,((String)non_iv_drugs.get(i+1)).trim());	//DOSAGE_SEQ_NO						
					pstmt_update_medn_admin.setString(++count,((String)non_iv_drugs.get(i+14)).trim());	//ORDER_ID		
					pstmt_update_medn_admin.addBatch();
					insertAuditlogNonIV(connection, non_iv_drugs, facility_id, added_by, encounter_id,i);//added for AAKH-CRF-0024 [IN:038260]
				}

				//int insertAuditLog[]=psAuditLog.executeBatch();//added for AAKH-CRF-0024 [IN:038260]
				int result1[]=pstmt_update_medn_admin.executeBatch();
				for (int i=0;i<result1.length ;i++ ){
					// A number greater than or equal to zero  indicates success
					// A number -2 indicates that command is successful but number of rows updated is unknow
					// If it won't satisfy any of the above cancel the statement and throw an exception
					if(result1[i]<0  && result1[i] != -2 ){
						pstmt_update_medn_admin.cancel();
						connection.rollback();
						System.err.println("Failed while updating PH_MEDN_ADMIN Table==393====");
						throw new EJBException("Updation Failed.........");
					}
				}			
				closeStatement(pstmt_select);
				closeStatement(psAuditLog);//added for AAKH-CRF-0024 [IN:038260]
				// insert into PH_MEDN_ADMIN_DTL
				pstmt_insert_medn_admin_dtl = connection.prepareStatement( SQL_PH_MEDN_ADMIN_DTL_FT_INSERT ) ;				
				pstmt_select	=	null;
				pstmt_select	=	connection.prepareStatement( SQL_PH_MED_ADMIN_FT_SELECT19 ) ;
				int srl_no		=	1;
				int medn_admin_dtl_count = 0; //Added for AAKH-CRF-0024 [IN:038260]
				//code modified ... loop 23 has been changed to 26 ..as previous batch_id,exp_date,trade_id is added..
				for(int i=0;i<non_iv_drugs.size();i=i+50){//Changed 45 to 46 //Modified from 44 to 45 for HSA-CRF-0090,code 'i=i+43' is replaced by 'i=i+44' for CRF-PH- RUT-CRF-0088[IN043881] // 46 changed to 50 for GHL-CRF-0482
				//for(int i=0;i<non_iv_drugs.size();i=i+37){	//	added for IN23952 --23/11/2010-- priya
					administered_yn = non_iv_drugs.get(i+4)==null?"":(String)non_iv_drugs.get(i+4);  //Added for  SKR-CRF-0037 [IN:037656]
					pstmt_select1.setString(1,(String)non_iv_drugs.get(i+14));
					pstmt_select1.setString(2,(String)non_iv_drugs.get(i+15));

					resultSet1	=	pstmt_select1.executeQuery();
					if(resultSet1.next()){
						freq_nat	=	resultSet1.getString("FREQ_NATURE");
					}

					count=1;
					pstmt_select.setString(1,facility_id);
					pstmt_select.setString(2,encounter_id);
					pstmt_select.setString(3,(String)non_iv_drugs.get(i+3));
					pstmt_select.setString(4,(String)non_iv_drugs.get(i));
					pstmt_select.setString(5,(String)non_iv_drugs.get(i+1));
					pstmt_select.setString(6,(String)non_iv_drugs.get(i+14));

					resultSet	=	pstmt_select.executeQuery();
		
					if(resultSet.next()) {
						srl_no	=	resultSet.getInt("NXT_SRL_NO");
					}
					closeResultSet( resultSet );
					if((!"Y".equals((String)non_iv_drugs.get(i+5)) && !"N".equals((String)non_iv_drugs.get(i+4))) || ("Y".equals((String)non_iv_drugs.get(i+5)) && "Y".equals((String)non_iv_drugs.get(i+4))) ){ //if condition Added for AAKH-CRF-0024 [IN:038260]
						medn_admin_dtl_count ++;//Added for 
						pstmt_insert_medn_admin_dtl.setString(count,facility_id);//	FACILITY_ID							
						pstmt_insert_medn_admin_dtl.setString(++count,encounter_id);//	ENCOUNTER_ID						
						pstmt_insert_medn_admin_dtl.setString(++count,(String)non_iv_drugs.get(i+3));	//	SCH_DATE_TIME	
						pstmt_insert_medn_admin_dtl.setString(++count,(String)non_iv_drugs.get(i));	//	ORD_DRUG_CODE		
						pstmt_insert_medn_admin_dtl.setString(++count,(String)non_iv_drugs.get(i+1));	//	DOSAGE_SEQ_NO	
						pstmt_insert_medn_admin_dtl.setString(++count,srl_no+"");	//	SRL_NO								
						//pstmt_insert_medn_admin_dtl.setString(++count,(String)non_iv_drugs.get(i));			//	ADMIN_DRUG_CODE
						pstmt_insert_medn_admin_dtl.setString(++count,(String)non_iv_drugs.get(i+45));			//	ADMIN_DRUG_CODE
						String admin_qty = ""; //AAKH-SCF-0500
						if(freq_nat.equals("P")   || ((String)non_iv_drugs.get(i+43)).equals("S")){////code '|| ((String)non_iv_drugs.get(i+43)).equals("S")'  is added for CRF-PH- RUT-CRF-0088[IN043881] 
							if( non_iv_drugs.get(i+32)!=null && ! ((String)non_iv_drugs.get(i+32)).equals("")){//if condition and else block for  [IN:045329] Verbal order by Strength
								//added for AAKH-SCF-0500 - start
								admin_qty = (String)non_iv_drugs.get(i+32)==null?"1":(String)non_iv_drugs.get(i+32);
								if(admin_qty!=null && (admin_qty.equals("0") || admin_qty.equals("0.0")))
									admin_qty = "1";
								//added for AAKH-SCF-0500-end
								pstmt_insert_medn_admin_dtl.setString(++count,admin_qty);
								pstmt_insert_medn_admin_dtl.setString(++count,(String)non_iv_drugs.get(i+33));
							}
							else{
							//added for AAKH-SCF-0500-start
								admin_qty = (String)non_iv_drugs.get(i+8)==null?"1":(String)non_iv_drugs.get(i+8);
								if(admin_qty!=null && (admin_qty.equals("0") || admin_qty.equals("0.0")))
									admin_qty = "1";
								//added for AAKH-SCF-0500 - end

								pstmt_insert_medn_admin_dtl.setString(++count,admin_qty);
								pstmt_insert_medn_admin_dtl.setString(++count,(String)non_iv_drugs.get(i+13));
							}
						}
						else{
							//added for AAKH-SCF-0500
								admin_qty = (String)non_iv_drugs.get(i+8)==null?"1":(String)non_iv_drugs.get(i+8);
								if(admin_qty!=null && (admin_qty.equals("0") || admin_qty.equals("0.0")))
									admin_qty = "1";

							pstmt_insert_medn_admin_dtl.setString(++count,admin_qty);		//	ADMIN_DOSAGE_QTY and modified for AAKH-SCF-0500			
							pstmt_insert_medn_admin_dtl.setString(++count,(String)non_iv_drugs.get(i+13));		//	ADMIN_DOSAGE_UOM_CODE
						}
						pstmt_insert_medn_admin_dtl.setString(++count,"");			//	ADMIN_STRENGTH
						pstmt_insert_medn_admin_dtl.setString(++count,"");			//	ADMIN_STRENGTH_UNIT
						pstmt_insert_medn_admin_dtl.setString(++count,"");			//	ADMIN_INFUSION_RATE
						pstmt_insert_medn_admin_dtl.setString(++count,"");			//	ADMIN_INFUSION_VOL_STR_UNIT
						pstmt_insert_medn_admin_dtl.setString(++count,"");			//	ADMIN_INFUSION_PER_UNIT
						pstmt_insert_medn_admin_dtl.setString(++count,admin_by);	//	ADMIN_BY //admin_by
						pstmt_insert_medn_admin_dtl.setString(++count,admin_by);	//	ADDED_BY_ID
						pstmt_insert_medn_admin_dtl.setString(++count,ws_no);		//	ADDED_AT_WS_NO
						pstmt_insert_medn_admin_dtl.setString(++count,facility_id);	//	ADDED_FACILITY_ID
						pstmt_insert_medn_admin_dtl.setString(++count,admin_by);	//	MODIFIED_BY_ID
						pstmt_insert_medn_admin_dtl.setString(++count,ws_no);		//	MODIFIED_AT_WS_NO
						pstmt_insert_medn_admin_dtl.setString(++count,facility_id);	//	MODIFIED_FACILITY_ID
						pstmt_insert_medn_admin_dtl.setString(++count,(String)non_iv_drugs.get(i+12));		//	ITEM_CODE
						pstmt_insert_medn_admin_dtl.setString(++count,(String)non_iv_drugs.get(i+9));		//  BATCH_ID
						pstmt_insert_medn_admin_dtl.setString(++count,(String)non_iv_drugs.get(i+10));		//  EXPIRY_DATE
						pstmt_insert_medn_admin_dtl.setString(++count,(String)non_iv_drugs.get(i+10));		//  EXPIRY_DATE
						pstmt_insert_medn_admin_dtl.setString(++count,(String)non_iv_drugs.get(i+11));		//	TRADE_ID
						//code added for inserting batch_id in ph_medn_admin_dtl
						pstmt_insert_medn_admin_dtl.setString(++count,(String)non_iv_drugs.get(i+23));			//	PREVIOUS_BATCH_ID
						pstmt_insert_medn_admin_dtl.setString(++count,(String)non_iv_drugs.get(i+24));			//	PREVIOUS_expiry_dt
						pstmt_insert_medn_admin_dtl.setString(++count,(String)non_iv_drugs.get(i+25));			//	PREVIOUS_trade_id
						pstmt_insert_medn_admin_dtl.setString(++count,(String)non_iv_drugs.get(i+14));					
						pstmt_insert_medn_admin_dtl.setString(++count,(String)non_iv_drugs.get(i+37));		//Linked Vaccine Code					
						pstmt_insert_medn_admin_dtl.setString(++count,(String)non_iv_drugs.get(i+41));		//ADMIN_BY_TYPE					
						pstmt_insert_medn_admin_dtl.setString(++count,(String)non_iv_drugs.get(i+42));		//SELF_ADMIN_BY		
						if(administered_yn.equals("Y")) //Added for  SKR-CRF-0037 [IN:037656]
							pstmt_insert_medn_admin_dtl.setString(++count,(String)non_iv_drugs.get(i+16));		//ADMIN_REASON_CODE					
						else
							pstmt_insert_medn_admin_dtl.setString(++count,"");		//ADMIN_REASON_CODE	
						
						pstmt_insert_medn_admin_dtl.setString(++count,(String)non_iv_drugs.get(i+46));		// EARLY_OR_LATE_ADMIN  Added for GLH-CRF-0482
						pstmt_insert_medn_admin_dtl.setString(++count,(String)non_iv_drugs.get(i+48));//GHL-CRF-0482
						pstmt_insert_medn_admin_dtl.setString(++count,((String)non_iv_drugs.get(i+49)).trim());//GHL-CRF-0482
						
						pstmt_insert_medn_admin_dtl.addBatch();			
					}
				}//Added for AAKH-CRF-0024 [IN:038260]
				int result2[] = null;
				if(medn_admin_dtl_count > 0){
				result2=pstmt_insert_medn_admin_dtl.executeBatch();
				}
				if(result2!=null){
				for (int i=0;i<result2.length ;i++ ){
					// A number greater than or equal to zero  indicates success
					// A number -2 indicates that command is successful but number of rows updated is unknow
					// If it won't satisfy any of the above cancel the statement and throw an exception
					if(result2[i]<0  && result2[i] != -2 ){
						pstmt_insert_medn_admin_dtl.cancel();
						connection.rollback();
						System.err.println("Failed while inserting into PH_MEDN_ADMIN_DTL Table==474====");
						throw new EJBException("Insertion Failed.........");
					}		
					}		
				}
				//Update PH_PATIENT_DRUG_PROFILE
				closeStatement(pstmt_select);
				pstmt_select	=	null;
//				pstmt_update_patient_drug_profile = connection.prepareStatement( SQL_PH_MEDN_ADMIN_PAT_DRUG_PROFILE_FT_UPDATE ) ;
				pstmt_update_patient_drug_profile = connection.prepareStatement("UPDATE PH_PATIENT_DRUG_PROFILE SET ADMINISTERED_DRUGS=?,TOT_ADMINISTERED_QTY=(NVL(TOT_ADMINISTERED_QTY,0)+?),MODIFIED_DATE=SYSDATE,MODIFIED_BY_ID=?, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,SLIDING_SCALE_YN=?,SLIDING_SCALE_ADM_UNIT=(NVL(SLIDING_SCALE_ADM_UNIT,0)+?), SLIDING_SCALE_ADM_UOM=?,PATIENT_STOCK_COMPLETED=?  WHERE PATIENT_ID=? AND ORIG_ORDER_ID=? AND ORIG_ORDER_LINE_NO=?");
				pstmt_select	=	connection.prepareStatement( SQL_PH_PRESCRIPTION_SELECT86 ) ;	
				pstmt_select2A	=	connection.prepareStatement( SQL_PH_MED_ADMIN_FT_SELECT27 ) ;
				
				float div_value	=	0;
				float adm_qty	=	0;
				String pres_mode	=	"";
				String strength		=	"";
				String strength_per_value_pres	=	"";
				String strength_per_pres		=	"";
				String iv_prep_yn	=	"";
				//code modified i+23 to i+24
			
				for(int i=0;i<non_iv_drugs.size();i=i+50){//Changed 45 to 46 //Modified from 44 to 45 for HSA-CRF-0090,code 'i=i+43' is replaced by 'i=i+44' for CRF-PH- RUT-CRF-0088[IN043881] // 46 changed to 50 for GHL-CRF-0482
				//for(int i=0;i<non_iv_drugs.size();i=i+37){	
					count=1;
					div_value	=	1;	
					iv_prep_yn	=	"";
					pstmt_select2A.setString(1,(String)non_iv_drugs.get(i+14));
					resultSet2A	= pstmt_select2A.executeQuery() ;

					if (resultSet2A!=null && resultSet2A.next()){
						iv_prep_yn		=	resultSet2A.getString("iv_prep_yn");				
					}
					if(iv_prep_yn==null) 
						iv_prep_yn="";
					closeResultSet(resultSet2A);
					if(!(iv_prep_yn.equals("6")||iv_prep_yn.equals("0"))){
						pstmt_select.setString(1,(String)non_iv_drugs.get(i+14)); // order_id
						pstmt_select.setString(2,(String)non_iv_drugs.get(i+15)); // order_line
						resultSet	=	pstmt_select.executeQuery();

						pstmt_select1.setString(1,(String)non_iv_drugs.get(i+14));
						pstmt_select1.setString(2,(String)non_iv_drugs.get(i+15));
						resultSet1	=	pstmt_select1.executeQuery();
						if(resultSet1.next()){
							freq_nat	=	resultSet1.getString("FREQ_NATURE");
						}
						closeResultSet( resultSet1) ;

						pstmt_select3.setString(1,(String)non_iv_drugs.get(i));
						pstmt_select3.setString(2, language_id);
						pstmt_select3.setString(3, language_id);
						pstmt_select3.setString(4, language_id);
						pstmt_select3.setString(5, language_id);
						pstmt_select3.setString(6, language_id);

						resultSet1	=	pstmt_select3.executeQuery();
						if(resultSet1!=null && resultSet1.next()) {
							strength_per_pres		= resultSet1.getString("STRENGTH_PER_PRES_UOM");
							strength_per_value_pres	= resultSet1.getString("STRENGTH_PER_VALUE_PRES_UOM");
						}
						closeResultSet( resultSet1);
						if(strength_per_pres==null || strength_per_pres.equals("") || strength_per_pres.equals("0"))
							strength_per_pres		=	"1";
						if(strength_per_value_pres==null || strength_per_value_pres.equals("") || strength_per_value_pres.equals("0"))
							strength_per_value_pres	=	"1";
					
						if(resultSet!=null && resultSet.next()) {
							pres_mode	=	resultSet.getString("PRESCRIBED_MODE");
							strength	=	resultSet.getString("STRENGTH");
							if(pres_mode == null){
								pres_mode="";
							}
							if(pres_mode.equals("S") && !freq_nat.equals("P") ) {
								div_value	=	Float.parseFloat(strength);
								if(div_value == 0)
									div_value=1;
								adm_qty	=	Float.parseFloat((String)non_iv_drugs.get(i+8))*Float.parseFloat(strength_per_value_pres)/div_value;
							}
							else {
								adm_qty	= Float.parseFloat((String)non_iv_drugs.get(i+8));
							}
						}
					}
					else{
						adm_qty	= Float.parseFloat((String)non_iv_drugs.get(i+8));
					}
					pstmt_update_patient_drug_profile.setString(count,(String)non_iv_drugs.get(i));
					pstmt_update_patient_drug_profile.setString(++count,adm_qty+"");
					pstmt_update_patient_drug_profile.setString(++count,admin_by);
					pstmt_update_patient_drug_profile.setString(++count,ws_no);
					pstmt_update_patient_drug_profile.setString(++count,facility_id);
					pstmt_update_patient_drug_profile.setString(++count,((String)non_iv_drugs.get(i+27)).trim()); //sliding_scale_yn
					if(((String)non_iv_drugs.get(i+27)).equals("Y")){						
						pstmt_update_patient_drug_profile.setString(++count,((String)non_iv_drugs.get(i+28)).trim()); //sliding_scale_admin_unit
						pstmt_update_patient_drug_profile.setString(++count,((String)non_iv_drugs.get(i+29)).trim()); //sliding_scale_admin_uom
					}
					else{
						pstmt_update_patient_drug_profile.setString(++count,""); //sliding_scale_admin_unit
						pstmt_update_patient_drug_profile.setString(++count,""); //sliding_scale_admin_uom
					}
					pstmt_update_patient_drug_profile.setString(++count,((String)non_iv_drugs.get(i+47)).trim());//added for GHL-CRF-0482
					pstmt_update_patient_drug_profile.setString(++count,patient_id);
					pstmt_update_patient_drug_profile.setString(++count,(String)non_iv_drugs.get(i+14));	// ORIG_ORDER_ID
					pstmt_update_patient_drug_profile.setString(++count,(String)non_iv_drugs.get(i+15));	// ORIG_ORDER_LINE_NO

					pstmt_update_patient_drug_profile.addBatch();				
				}

				int result3[]=pstmt_update_patient_drug_profile.executeBatch();			
				for (int i=0;i<result3.length ;i++ ){
					// A number greater than or equal to zero  indicates success
					// A number -2 indicates that command is successful but number of rows updated is unknow
					// If it won't satisfy any of the above cancel the statement and throw an exception
					if(result3[i]<0  && result3[i] != -2 ){
						pstmt_update_patient_drug_profile.cancel();
						connection.rollback();
						System.err.println("Failed while inserting into PH_MEDN_ADMIN_DTL Table==553===");
						throw new EJBException("Insertion Failed.........");
					}		
				}
			}

			/* if(iv_drugs.size()>0){
				closeStatement( pstmt_insert_medn_admin ) ;
				//	INSERT INTO PH_DISP_MEDN_ADMIN
				pstmt_insert_medn_admin	= connection.prepareStatement( SQL_PH_MEDN_ADMIN_FT_INSERT ) ;
				String dosage_seq_no = "";
				String freq_nature = "";
				HashMap medn_admin_values = new HashMap();
              
				//code modified i+29 to i+30
				for(int i=0;i<iv_drugs.size();i=i+32){
					count=1;
					if(iv_drugs.get(i+27)!=null && !((String)iv_drugs.get(i+27)).equals("")){										
						pstmt_insert_medn_admin.setString(1,(String)iv_drugs.get(i+5));  // sch_dosage_qty
						pstmt_insert_medn_admin.setString(2,added_by);
						pstmt_insert_medn_admin.setString(3,ws_no);
						pstmt_insert_medn_admin.setString(4,facility_id);
						pstmt_insert_medn_admin.setString(5,added_by);
						pstmt_insert_medn_admin.setString(6,ws_no);
						pstmt_insert_medn_admin.setString(7,facility_id);
						pstmt_insert_medn_admin.setString(8,facility_id);
						pstmt_insert_medn_admin.setString(9,encounter_id);
						pstmt_insert_medn_admin.setString(10,(String)iv_drugs.get(i+27)); //sch_date_time
						pstmt_insert_medn_admin.setString(11,(String)iv_drugs.get(i+1));  // ord drug code
						pstmt_insert_medn_admin.setString(12,(String)iv_drugs.get(i+3));   // order id
						pstmt_insert_medn_admin.setString(13,(String)iv_drugs.get(i+4));   // order line no

						if(freq_nature!=null && freq_nature.equals("C")){
							pstmt_insert_medn_admin.addBatch();		
						}					
					
					}
				}
				int result_insert_new_admin[]=pstmt_insert_medn_admin.executeBatch();			
				for (int i=0;i<result_insert_new_admin.length ;i++ ){
				
					// A number greater than or equal to zero  indicates success
					// A number -2 indicates that command is successful but number of rows updated is unknow
					
					if(result_insert_new_admin[i]<0  && result_insert_new_admin[i] != -2 ){
						pstmt_insert_medn_admin.cancel();
						connection.rollback();
						throw new EJBException("Insertion Failed.........");
					}		
				}				
			} */

			/***************************************************
							FOR IV ADMINISTERED DRUGS
			****************************************************/
			//PreparedStatement insertAuditLogIV = null; //Added for AAKH-CRF-0024 [IN:038260]
			if(iv_drugs.size()>0){			
				closeStatement( pstmt_update_medn_admin ) ;
				closeStatement( pstmt_insert_medn_admin_dtl ) ;
				closeStatement( pstmt_update_patient_drug_profile ) ;

				// update ph_med_admin 
				pstmt_update_medn_admin = connection.prepareStatement( SQL_PH_MEDN_ADMIN_FT_IV_UPDATE ) ;
				pstmt_select2			= connection.prepareStatement( SQL_PH_MED_ADMIN_FT_SELECT27 ) ;
				
				String iv_prep_yn			=	"";				
				String ord_drug_code		=   null;
				ArrayList arr_list  = null;
				String admin_yn="", admin_rec_yn="", end_date="";
				for(int i=0;i<iv_drugs.size();i=i+42){//Changed 40 to 41 //Modified from 39 to 40 for HSA-CRF-0090//Size changed from 38 to 39 for AAKH-CRF-0024 [IN:038260] and changed 41 to 42 for SKR-SCF-1240
					administered_yn = iv_drugs.get(i+17)==null?"":(String)iv_drugs.get(i+17);  //Added for  SKR-CRF-0037 [IN:037656]
					count=1;
					admin_yn= (String)iv_drugs.get(i+17);
					admin_rec_yn= (String)iv_drugs.get(i+18);
					end_date = "";
					if(admin_yn.equals("Y") && admin_rec_yn.equals(""))
						end_date = (String)iv_drugs.get(i+28);
					pstmt_update_medn_admin.setString(count,nursing_unit);					//ADMIN_NURSING_UNIT_CODE
					pstmt_update_medn_admin.setString(++count,assign_bed_num);				//ADMIN_BED_NO
					pstmt_update_medn_admin.setString(++count,admin_by);					//ADMIN_BY
					pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i+15));	//ADMIN_REMARKS
					pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i+16));	//NON_ADMIN_REMARKS
					pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i+18));	//ADMIN_RECORDED_YN
					pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i+6));	//ADMIN_DATE_TIME
					pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i+17));	//ADMINISTERED_YN
					pstmt_update_medn_admin.setString(++count,facility_id);					//MODIFIED_FACILITY_ID
					pstmt_update_medn_admin.setString(++count,added_by);					//MODIFIED_BY_ID
					pstmt_update_medn_admin.setString(++count,ws_no);						//MODIFIED_AT_WS_NO
					pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i+7));	//SCH_INFUSION_RATE		
					pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i+8));	//SCH_INFUSION_VOL_STR_UNIT		
					pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i+9));	//SCH_INFUSION_PER_UNIT		
					pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i+10));	//SCH_INFUSION_PERIOD				
					pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i+11));	//SCH_INFUSION_PERIOD_UNIT	
					if(administered_yn.equals("Y")) 
						pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i+22));	//NON_ADMIN_CODE
					else
						pstmt_update_medn_admin.setString(++count,"");	//ADMIN_CODE added for mms-kh-crf-0010
					if(!administered_yn.equals("Y"))// if condition and else blok Added for  SKR-CRF-0037 [IN:037656]
						pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i+22));	//NON_ADMIN_CODE
					else
						pstmt_update_medn_admin.setString(++count,"");	//NON_ADMIN_CODE//modified for mms-kh-crf-0010
					
					if( ((String)iv_drugs.get(i+23)).equals("")){
						pstmt_update_medn_admin.setString(++count,admin_by);				//ADMIN_RECORDED_BY
					}
					else {
						pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i+23));	//ADMIN_RECORDED_BY		
					}
					pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i+24));	//ADMIN_AUTHORIZED_BY		
					
					if(adr_values!=null && adr_values.containsKey((String)iv_drugs.get(i)+"-"+(String)iv_drugs.get(i+3))){
						arr_list = (ArrayList)adr_values.get((String)iv_drugs.get(i)+"-"+(String)iv_drugs.get(i+3));
						pstmt_update_medn_admin.setString(++count,(String)arr_list.get(0));	//	// AGAINST_SCHDOSE_DATE_TIME   					
						pstmt_update_medn_admin.setString(++count,(String)arr_list.get(1));	//	// ADR_REASON_CODE             					
						pstmt_update_medn_admin.setString(++count,(String)arr_list.get(3));	//	// ADR_REMARKS                 					
						pstmt_update_medn_admin.setString(++count,(String)arr_list.get(2));	//	// ADR_RECORDED_DATE_TIME      					
						pstmt_update_medn_admin.setString(++count,(String)arr_list.get(4));	//	// ADR_RECORDED_BY             		
					}
					else{
						pstmt_update_medn_admin.setString(++count,"");	//	// AGAINST_SCHDOSE_DATE_TIME   					
						pstmt_update_medn_admin.setString(++count,"");	//	// ADR_REASON_CODE             					
						pstmt_update_medn_admin.setString(++count,"");	//	// ADR_REMARKS                 					
						pstmt_update_medn_admin.setString(++count,"");	//	// ADR_RECORDED_DATE_TIME      					
						pstmt_update_medn_admin.setString(++count,"");	//	// ADR_RECORDED_BY             					
					}
					pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i+19)); // ADMN_DOSE_CHNG_REASON_CODE
					pstmt_update_medn_admin.setString(++count,end_date); // ACT_END_DATE_TIME
					pstmt_update_medn_admin.setString(++count,facility_id);					//FACILITY_ID
					pstmt_update_medn_admin.setString(++count,encounter_id);				//ENCOUNTER_ID
					pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i+20));	//SCH_DATE_TIME
					pstmt_select2.setString(1,(String)iv_drugs.get(i+3));
					resultSet	= pstmt_select2.executeQuery() ;
					if (resultSet!=null && resultSet.next()){
						iv_prep_yn		=	resultSet.getString("iv_prep_yn");				
					}										
                    if(iv_prep_yn.equals("2")||iv_prep_yn.equals("4")){
						ord_drug_code="FINAL PRODUCT";
					}
					else{
                        ord_drug_code=(String)iv_drugs.get(i+1);
					} 

					pstmt_update_medn_admin.setString(++count,ord_drug_code);	//ORD_DRUG_CODE
					pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i));		//DOSAGE_SEQ_NO	
					pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i+3));		//ORDER_ID
					pstmt_update_medn_admin.addBatch();
					
					//added for AAKH-CRF-0024 [IN:038260] START
					if("1".equals((String)iv_drugs.get(i+4))){
						insertAuditlogIV(connection, iv_drugs, facility_id, added_by, encounter_id,ord_drug_code,i);//added for AAKH-CRF-0024 [IN:038260]
					}
					//added for AAKH-CRF-0024 [IN:038260] ENDS
				}
				//insertAuditLogIV.executeBatch();//Added for AAKH-CRF-0024 [IN:038260]
				int result_iv_1[]=pstmt_update_medn_admin.executeBatch();	
				for (int i=0;i<result_iv_1.length ;i++ ){					
					// A number greater than or equal to zero  indicates success
					// A number -2 indicates that command is successful but number of rows updated is unknow
					// If it won't satisfy any of the above cancel the statement and throw an exception
					if(result_iv_1[i]<0  && result_iv_1[i] != -2 ){
						pstmt_update_medn_admin.cancel();
						connection.rollback();
						System.err.println("Failed while updating PH_MEDN_ADMIN Table==1=1==");
						throw new EJBException("Updation Failed.........");
					}		
				}	
				closeStatement(pstmt_update_medn_admin);
				closeResultSet( resultSet );
				closeStatement(pstmt_select);
				closeStatement(pstmt_select2);
				pstmt_select	=	null;
				// insert into PH_MEDN_ADMIN_DTL
				
				pstmt_insert_medn_admin_dtl = connection.prepareStatement( SQL_PH_MEDN_ADMIN_DTL_FT_INSERT ) ;				
				pstmt_MFRYN					= connection.prepareStatement( "select MFR_YN from OR_ORDER_LINE_PH where order_id=?" ) ;
				
				pstmt_unit					= connection.prepareStatement( "SELECT INFUSE_OVER_UNIT from OR_ORDER_LINE_PH WHERE ORDER_ID=? AND ORDER_LINE_NUM=?" );
				//pstmt_select				= connection.prepareStatement( SQL_PH_MED_ADMIN_FT_SELECT_DOSES );
				pstmt_select				= connection.prepareStatement( "SELECT CEIL(TOT_INFUSION_OVER/ORIG_INFUSE_OVER*?) NO_OF_DOSES FROM OR_ORDER_LINE_PH WHERE ORDER_ID=? AND ORDER_LINE_NUM=?" );				
				pstmt_insert_medn_admin		= connection.prepareStatement( SQL_PH_MEDN_ADMIN_FT_INSERT1 );				
				pstmt_select2				= connection.prepareStatement( SQL_PH_MED_ADMIN_FT_SELECT27 ) ;
				iv_prep_yn					=	"";
				String MFR_YN				=	"N";
				//loop modified from 30 to 33...has previous batch_id is added to the list
				int med_admin_dtl_count_iv = 0;//Added for AAKH-CRF-0024 [IN:038260]
				for(int i=0;i<iv_drugs.size();i=i+42){//Changed 40 to 41 //Modified from 39 to 40 for HSA-CRF-0090//Size changed from 38 to 39  for AAKH-CRF-0024 [IN:038260]	 and changed 41 to 42 for SKR-SCF-1240
				//for(int i=0;i<iv_drugs.size();i=i+34){		
					administered_yn = iv_drugs.get(i+17)==null?"":(String)iv_drugs.get(i+17);  //Added for  SKR-CRF-0037 [IN:037656]
					pstmt_select2.setString(1,(String)iv_drugs.get(i+3));
					resultSet	= pstmt_select2.executeQuery() ;
					if (resultSet!=null && resultSet.next()){
						iv_prep_yn		=	resultSet.getString("iv_prep_yn");				
					}
					closeResultSet( resultSet ) ;

					pstmt_MFRYN.setString(1,(String)iv_drugs.get(i+3));
					resultSet_MFRYN	= pstmt_MFRYN.executeQuery() ;
					if (resultSet_MFRYN!=null && resultSet_MFRYN.next()){
						MFR_YN		=	resultSet_MFRYN.getString("MFR_YN")==null?"":resultSet_MFRYN.getString("MFR_YN");				
					}
					closeResultSet(resultSet_MFRYN ) ;		
					count=1;
					int doseunit=1;
					if((!"Y".equals((String)iv_drugs.get(i+18)) && !"N".equals((String)iv_drugs.get(i+17))) || ("Y".equals((String)iv_drugs.get(i+18)) && "Y".equals((String)iv_drugs.get(i+17))) ){//if condition added for AAKH-CRF-0024 [IN:038260]
						med_admin_dtl_count_iv++;//Added for AAKH-CRF-0024 [IN:038260]
						pstmt_insert_medn_admin_dtl.setString(count,facility_id);			//	FACILITY_ID
						pstmt_insert_medn_admin_dtl.setString(++count,encounter_id);		//	ENCOUNTER_ID
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+20));	//	SCH_DATE_TIME
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+1));	//	ORD_DRUG_CODE
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i));		//	DOSAGE_SEQ_NO
						pstmt_insert_medn_admin_dtl.setString(++count,"1");							//	SRL_NO
						//pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+1));	//	ADMIN_DRUG_CODE
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+40));	//	ADMIN_DRUG_CODE
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+5));	//	ADMIN_DOSAGE_QTY
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+41));	//	ADMIN_DOSAGE_UOM_CODE and changed 8 to 41 for SKR-SCF-1240
						pstmt_insert_medn_admin_dtl.setString(++count,"");							//	ADMIN_STRENGTH
						pstmt_insert_medn_admin_dtl.setString(++count,"");							//	ADMIN_STRENGTH_UNIT
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+7));	//	ADMIN_INFUSION_RATE
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+8));	//	ADMIN_INFUSION_VOL_STR_UNIT
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+9));	//	ADMIN_INFUSION_PER_UNIT
						pstmt_insert_medn_admin_dtl.setString(++count,admin_by);	//	ADMIN_BY
						pstmt_insert_medn_admin_dtl.setString(++count,admin_by);	//	ADDED_BY_ID
						pstmt_insert_medn_admin_dtl.setString(++count,ws_no);		//	ADDED_AT_WS_NO
						pstmt_insert_medn_admin_dtl.setString(++count,facility_id);	//	ADDED_FACILITY_ID
						pstmt_insert_medn_admin_dtl.setString(++count,admin_by);	//	MODIFIED_BY_ID
						pstmt_insert_medn_admin_dtl.setString(++count,ws_no);		//	MODIFIED_AT_WS_NO
						pstmt_insert_medn_admin_dtl.setString(++count,facility_id);	//	MODIFIED_FACILITY_ID
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+2));		//	ITEM_CODE
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+12));		//  BATCH_ID
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+13));		//  EXPIRY_DATE
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+13));		//  EXPIRY_DATE
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+14));		//	TRADE_ID
						//code added for inserting previous batch_id in ph_medn_admin_dtl
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+30));		//	PREVIOUS_BATCH_ID
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+31));		//	PREVIOUS_EXP_DT
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+32));		//	PREVIOUS_TRADE_ID
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+3));		//	ORDER_ID
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+34));		//	Linked Vaccine Code
						pstmt_insert_medn_admin_dtl.setString(++count,"U"); //ADMIN_BY_TYPE
						pstmt_insert_medn_admin_dtl.setString(++count,"");	//SELF_ADMIN_BY
						if(administered_yn.equals("Y")) //Added for  SKR-CRF-0037 [IN:037656]
							pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+22));	//ADMIN_REASON_CODE
						else
							pstmt_insert_medn_admin_dtl.setString(++count,"");	//ADMIN_REASON_CODE
						
						pstmt_insert_medn_admin_dtl.setString(++count,"");	// EARLY_OR_LATE_ADMIN Added for GLH-CRF-0482
						pstmt_insert_medn_admin_dtl.setString(++count,"");//GHL-CRF-0482	
						pstmt_insert_medn_admin_dtl.setString(++count,"");//GHL-CRF-0482	
						
						pstmt_insert_medn_admin_dtl.addBatch();	
					}//Added for AAKH-CRF-0024 [IN:038260]
					if(!MFR_YN.equals("Y")){
						pstmt_unit.setString(1,(String)iv_drugs.get(i+3));
						pstmt_unit.setString(2,(String)iv_drugs.get(i+4));
						resultSetunit	=	pstmt_unit.executeQuery();
						if(resultSetunit!=null && resultSetunit.next()){
							if((resultSetunit.getString("INFUSE_OVER_UNIT").trim()).equals("M")){
								doseunit=60;
							}
						}
						closeResultSet( resultSetunit);
						pstmt_select.setInt(1,doseunit);
						pstmt_select.setString(2,(String)iv_drugs.get(i+3));
						pstmt_select.setString(3,(String)iv_drugs.get(i+4));					
						resultSet	=	pstmt_select.executeQuery();
						
						
					
						if(resultSet!=null && resultSet.next()) {//added for jd-crf-0200
							if((resultSet.getInt("NO_OF_DOSES") - (Integer.parseInt((String)iv_drugs.get(i))+1))>=0){
								pstmt_select_cancel_yn	=	connection.prepareStatement( "select count(*) count from ph_medn_admin where   sch_date_time = TO_DATE (?, 'DD/MM/YYYY HH24:MI') AND order_id = ? and ORDER_LINE_NUM =? and dosage_seq_no=? " ) ;	
								
								 pstmt_select_cancel_yn.setString(1,(String)iv_drugs.get(i+28));
								 pstmt_select_cancel_yn.setString(2,(String)iv_drugs.get(i+3));
								 pstmt_select_cancel_yn.setString(3,(String)iv_drugs.get(i+4));
								 pstmt_select_cancel_yn.setString(4,""+(Integer.parseInt((String)iv_drugs.get(i))+1));
								 resultSet_cancel_yn=pstmt_select_cancel_yn.executeQuery();
								while(resultSet_cancel_yn.next()){
								 cancelCnt=Integer.parseInt((String)resultSet_cancel_yn.getString("count")==null?"":(String)resultSet_cancel_yn.getString("count") );
								}
								resultSet_cancel_yn.close();
								pstmt_select_cancel_yn.close();
							}
							if( !(iv_prep_yn).equals("3") && !(iv_prep_yn).equals("4") && (resultSet.getInt("NO_OF_DOSES") - Integer.parseInt((String)iv_drugs.get(i)))>0) {
								if(!"Y".equals((String)iv_drugs.get(i+38)) && cancelCnt ==0){//if condition aded for AAKH-CRF-0024 [IN:038260]
									//pstmt_insert_medn_admin.setString(1,(String)iv_drugs.get(i+28));//NEXT SCHEDULE DATE taking 
									pstmt_insert_medn_admin.setString(1,(String)iv_drugs.get(i+28));//NEXT SCHEDULE DATE
									pstmt_insert_medn_admin.setString(2,facility_id);//FACILITY_ID					
									pstmt_insert_medn_admin.setString(3,encounter_id);//ENCOUNTER_ID		
									pstmt_insert_medn_admin.setString(4,(String)iv_drugs.get(i+20));	//SCH_DATE_TIME
									pstmt_insert_medn_admin.setString(5,(String)iv_drugs.get(i+1));	//ORD_DRUG_CODE
									pstmt_insert_medn_admin.setString(6,(String)iv_drugs.get(i+3));	//ORDER_ID
									pstmt_insert_medn_admin.setString(7,(String)iv_drugs.get(i+4));	//ORDER_LINE_NUM		
									pstmt_insert_medn_admin.executeUpdate();															
								}
							}
						} //Added for AAKH-CRF-0024 [IN:038260]
						closeResultSet( resultSet);
					}
				}
				int result_iv_2[] = null; //Added for AAKH-CRF-0024 [IN:038260]
				if(med_admin_dtl_count_iv>0){ //Added for AAKH-CRF-0024 [IN:038260]
					result_iv_2 = pstmt_insert_medn_admin_dtl.executeBatch();
				}
				
				if(null!=result_iv_2){ //Added for AAKH-CRF-0024 [IN:038260]
					for (int i=0;i<result_iv_2.length ;i++ ){
						// A number greater than or equal to zero  indicates success
						// A number -2 indicates that command is successful but number of rows updated is unknow
						// If it won't satisfy any of the above cancel the statement and throw an exception
						if(result_iv_2[i]<0  && result_iv_2[i] != -2 ){
							pstmt_insert_medn_admin_dtl.cancel();
							connection.rollback();
							System.err.println("Failed3 while inserting into PH_MEDN_ADMIN_DTL Table===794=====");
							throw new EJBException("Insertion Failed.........");
						}		
					}	
				} //Added for AAKH-CRF-0024 [IN:038260]
				closeStatement(pstmt_insert_medn_admin_dtl);
				closeStatement(pstmt_unit);
				closeStatement(pstmt_select);
				closeStatement(pstmt_MFRYN);
				pstmt_select	=	null;

				//Update PH_PATIENT_DRUG_PROFILE
				pstmt_update_patient_drug_profile = connection.prepareStatement( SQL_PH_MEDN_ADMIN_PAT_DRUG_PROFILE_FT_UPDATE1 ) ;
				pstmt_select	=	connection.prepareStatement( SQL_PH_PRESCRIPTION_SELECT86 ) ;	

				//code modified i+29 to i+30 as arraylist
				String tot_admin_quantity		 =	"";
				String strength_per_value_pres_iv=	"";
				String strength_iv				 =	"";
				String pres_mode_iv				 =	"";
				float div_value_iv				 =	0;
				for(int i=0;i<iv_drugs.size();i=i+42){//Changed 40 to 41//Modified from 39 to 40 for HSA-CRF-0090//Size chnaged from 38 to 39 for AAKH-CRF-0024 [IN:038260] and changed 41 to 42 for SKR-SCF-1240
				//for(int i=0;i<iv_drugs.size();i=i+34){
					tot_admin_quantity			="";
					freq_nat					="";
					strength_per_value_pres_iv	="";
					strength_iv					="";
					pres_mode_iv				="";
					count						=1;
					div_value_iv				=0;

					pstmt_select2.setString(1,(String)iv_drugs.get(i+3));  //order_id
					resultSet	= pstmt_select2.executeQuery() ;
					if (resultSet!=null && resultSet.next()){
						iv_prep_yn		=	resultSet.getString("iv_prep_yn");	
					}
					closeResultSet( resultSet ) ;
					if(iv_prep_yn.equals("1")||iv_prep_yn.equals("3")){

						pstmt_select1.setString(1,(String)iv_drugs.get(i+3));  //order_id
						pstmt_select1.setString(2,(String)iv_drugs.get(i+4));  //order_line_no
						resultSet1	=	pstmt_select1.executeQuery();
						if(resultSet1.next())	{
							freq_nat	=	resultSet1.getString("FREQ_NATURE");
						}
						closeResultSet( resultSet1) ;
						resultSet1	=	null;

						pstmt_select3.setString(1,(String)iv_drugs.get(i+1));  //Drug Code
						pstmt_select3.setString(2, language_id);
						pstmt_select3.setString(3, language_id);
						pstmt_select3.setString(4, language_id);
						pstmt_select3.setString(5, language_id);
						pstmt_select3.setString(6, language_id);
						resultSet1	=	pstmt_select3.executeQuery();
						if(resultSet1!=null && resultSet1.next()) {
							strength_per_value_pres_iv	= resultSet1.getString("STRENGTH_PER_VALUE_PRES_UOM");
						}
						if(strength_per_value_pres_iv==null || strength_per_value_pres_iv.equals("") || strength_per_value_pres_iv.equals("0")){
							strength_per_value_pres_iv	=	"1";
						}
						closeResultSet( resultSet1);							
						resultSet1	=	null;

						pstmt_select.setString(1,(String)iv_drugs.get(i+3)); // order_id
						pstmt_select.setString(2,(String)iv_drugs.get(i+4)); // order_line_no
						resultSet1	=	pstmt_select.executeQuery();
						if(resultSet1!=null && resultSet1.next()) {
						pres_mode_iv	=	resultSet1.getString("PRESCRIBED_MODE");
						strength_iv		=	resultSet1.getString("STRENGTH");
						if(pres_mode_iv == null){
							pres_mode_iv="";
						}
                  		if(pres_mode_iv.equals("S") && !freq_nat.equals("P") ) {
							div_value_iv	=	Float.parseFloat(strength_iv);
						}
						else {
							div_value_iv	=	1;
						}
						if(div_value_iv == 0)
							div_value_iv=1;
						}
						closeResultSet( resultSet1);	
						tot_admin_quantity	=(Float.parseFloat((String)iv_drugs.get(i+5))*Float.parseFloat(strength_per_value_pres_iv)/div_value_iv)+"";//Removed Math.ceil() for SKR-SCF-1187
					}
					else{
                        tot_admin_quantity=(String)iv_drugs.get(i+5);
					} 
					if(((String)iv_drugs.get(i+18)).equals("Y")&& ((String)iv_drugs.get(i+17)).equals("N")) //if condition added for SKR-SCF-1253
						tot_admin_quantity = "0";
				
					pstmt_update_patient_drug_profile.setString(count  ,(String)iv_drugs.get(i+1));		//ADMINISTERED_DRUGS				
					pstmt_update_patient_drug_profile.setString(++count,tot_admin_quantity);		//TOT_ADMINISTERED_QTY
					//pstmt_update_patient_drug_profile.setString(++count,(String)iv_drugs.get(i+7));
					//INFUSION_RATE //commented for skr-scf-1612
					//pstmt_update_patient_drug_profile.setString(++count,(String)iv_drugs.get(i+10));
					//INFUSE_OVER
					pstmt_update_patient_drug_profile.setString(++count, admin_by);
					pstmt_update_patient_drug_profile.setString(++count, ws_no);
					pstmt_update_patient_drug_profile.setString(++count, facility_id);
					pstmt_update_patient_drug_profile.setString(++count, patient_id);					//PATIENT_ID
					pstmt_update_patient_drug_profile.setString(++count,(String)iv_drugs.get(i+3));		//ORIG_ORDER_ID
					pstmt_update_patient_drug_profile.setString(++count,(String)iv_drugs.get(i+4));		//ORIG_ORDER_LINE_NO
                 
					pstmt_update_patient_drug_profile.addBatch();
				}
				int  result_iv_3[]=pstmt_update_patient_drug_profile.executeBatch();
				for (int i=0;i<result_iv_3.length ;i++ ){
					// A number greater than or equal to zero  indicates success
					// A number -2 indicates that command is successful but number of rows updated is unknow
					// If it won't satisfy any of the above cancel the statement and throw an exception
					if(result_iv_3[i]<0  && result_iv_3[i] != -2 ){
						pstmt_update_patient_drug_profile.cancel();
						connection.rollback();
						System.err.println("Failed4 while updating drug profile");
						throw new EJBException("Insertion Failed.........");
					}		
				}
				//Update OR_ORDER_LINE_PH
				//commented for skr-scf-1612
				/*pstmt_update_or_order_line_ph = connection.prepareStatement( SQL_PH_MEDN_ADMIN_OR_ORDER_LINE_PH_UPDATE ) ;
				for(int i=0;i<iv_drugs.size();i=i+42){//Changed 40 to 41 //Modified from 39 to 40 for HSA-CRF-0090//Size chnaged from 38 to 39 for AAKH-CRF-0024 [IN:038260] and changed 41 to 42 for SKR-SCF-1240
				//for(int i=0;i<iv_drugs.size();i=i+34){	
					count		=	1;
					//div_value	=	1;		
					
					pstmt_update_or_order_line_ph.setString(count,(String)iv_drugs.get(i+10));
					//INFUSE_OVER
					pstmt_update_or_order_line_ph.setString(++count,(String)iv_drugs.get(i+7));//IN33153 - SKR-SCF-0543- Removed 'infusion_rate' updation on or_order_line_ph.
					//INFUSION_RATE
					pstmt_update_or_order_line_ph.setString(++count, admin_by);
					pstmt_update_or_order_line_ph.setString(++count, ws_no);
					pstmt_update_or_order_line_ph.setString(++count, facility_id);
					pstmt_update_or_order_line_ph.setString(++count,(String)iv_drugs.get(i+3));		//ORDER_ID
					pstmt_update_or_order_line_ph.setString(++count,(String)iv_drugs.get(i+4));		//ORDER_LINE_NUM
					pstmt_update_or_order_line_ph.addBatch();
				}

				int  result_iv_4[]=pstmt_update_or_order_line_ph.executeBatch();
				for (int i=0;i<result_iv_4.length ;i++ ){
					// A number greater than or equal to zero  indicates success
					// A number -2 indicates that command is successful but number of rows updated is unknow
					// If it won't satisfy any of the above cancel the statement and throw an exception
					if(result_iv_4[i]<0  && result_iv_4[i] != -2 ){
						pstmt_update_patient_drug_profile.cancel();
						connection.rollback();
						System.err.println("Failed4 while inserting into OR_ORDER_LINE_PH Table");
						throw new EJBException("Insertion Failed.........");
					}		
				} */
				closeStatement(pstmt_update_patient_drug_profile);
			}
			
			/***************************************************
							FOR ALTERNATE DRUGS
			****************************************************/
			if(alt_drug_details.size()>0){
				pstmt_insert_medn_admin_dtl		  = connection.prepareStatement( SQL_PH_MEDN_ADMIN_DTL_FT_INSERT ) ;
				pstmt_update_medn_admin			  = connection.prepareStatement( SQL_PH_MEDN_ADMIN_FT_UPDATE ) ;
				pstmt_update_patient_drug_profile = connection.prepareStatement( SQL_PH_MEDN_ADMIN_PAT_DRUG_PROFILE_FT_UPDATE ) ;
				String administered_drugs	=	"";
				ArrayList alt_drugs = null;
				int srl_no = 1;
				Set alt_set = null;
				Iterator alt_iterator	= null;
				ArrayList arr_list =null;
				int medn_admin_dtl_cnt_altdrug = 0; //Added for AAKH-CRF-0024 [IN:038260]
				for(int i=0;i<alt_drug_details.size();i++){
					alt_set = alt_drug_details.keySet();
					alt_iterator	= alt_set.iterator();
					while (alt_iterator.hasNext()){
						alt_drugs = (ArrayList)alt_drug_details.get((String)alt_iterator.next());
						srl_no = 1;
						administered_drugs	=	"";
						for (int j=0;j<alt_drugs.size() ;j=j+26 ){							
							//if(j<17){
							administered_yn = alt_drugs.get(i+13)==null?"":(String)alt_drugs.get(i+13);  //Added for SKR-CRF-0037 [IN:037656]			
							if(j<21){// update ph_med_admin 
								count = 1;
								//pstmt_update_medn_admin = connection.prepareStatement( SQL_PH_MEDN_ADMIN_FT_UPDATE ) ;
								pstmt_update_medn_admin.setString(count,nursing_unit);						//ADMIN_NURSING_UNIT_CODE
								pstmt_update_medn_admin.setString(++count,assign_bed_num);					//ADMIN_BED_NO
								pstmt_update_medn_admin.setString(++count,admin_by);						//ADMIN_BY
								pstmt_update_medn_admin.setString(++count,(String)alt_drugs.get(j+15));	//ADMIN_REMARKS
								pstmt_update_medn_admin.setString(++count,(String)alt_drugs.get(j+16));	//NON_ADMIN_REMARKS
								pstmt_update_medn_admin.setString(++count,(String)alt_drugs.get(j+14));	//ADMIN_RECORDED_YN
								pstmt_update_medn_admin.setString(++count,(String)alt_drugs.get(j+9));	//ADMIN_DATE_TIME
								pstmt_update_medn_admin.setString(++count,(String)alt_drugs.get(j+13));	//ADMINISTERED_YN
								pstmt_update_medn_admin.setString(++count,facility_id);						//MODIFIED_FACILITY_ID
								pstmt_update_medn_admin.setString(++count,added_by);						//MODIFIED_BY_ID
								pstmt_update_medn_admin.setString(++count,ws_no);							//MODIFIED_AT_WS_NO
								if(administered_yn.equals("Y")) 
									pstmt_update_medn_admin.setString(++count,(String)alt_drugs.get(j+17));	// ADMIN_CODE added for mms-kh-crf-0010
								else
									pstmt_update_medn_admin.setString(++count,"");	//ADMIN_CODE added for mms-kh-crf-0010
								if(!administered_yn.equals("Y")) //if condition and else block Added for SKR-CRF-0037 [IN:037656]
									pstmt_update_medn_admin.setString(++count,(String)alt_drugs.get(j+17));	 // // NON_ADMIN_CODE  
								else
									pstmt_update_medn_admin.setString(++count,"");	 // // NON_ADMIN_CODE  
								pstmt_update_medn_admin.setString(++count,(String)alt_drugs.get(j+18));	//ADMIN_RECORDED_BY
								pstmt_update_medn_admin.setString(++count,(String)alt_drugs.get(j+19));	//ADMIN_AUTHORIZED_BY
								
								if(adr_values!=null && adr_values.containsKey((String)alt_drugs.get(i)+"-"+(String)alt_drugs.get(i+3))){
									arr_list = (ArrayList)adr_values.get((String)alt_drugs.get(i)+"-"+(String)alt_drugs.get(i+3));
									pstmt_update_medn_admin.setString(++count,(String)arr_list.get(0));	//	// AGAINST_SCHDOSE_DATE_TIME   					
									pstmt_update_medn_admin.setString(++count,(String)arr_list.get(1));	//	// ADR_REASON_CODE             					
									pstmt_update_medn_admin.setString(++count,(String)arr_list.get(3));	//	// ADR_REMARKS                 					
									pstmt_update_medn_admin.setString(++count,(String)arr_list.get(2));	//	// ADR_RECORDED_DATE_TIME      					
									pstmt_update_medn_admin.setString(++count,(String)arr_list.get(4));	//	// ADR_RECORDED_BY             		
								}
								else{
									pstmt_update_medn_admin.setString(++count,"");	//	// AGAINST_SCHDOSE_DATE_TIME   					
									pstmt_update_medn_admin.setString(++count,"");	//	// ADR_REASON_CODE             					
									pstmt_update_medn_admin.setString(++count,"");	//	// ADR_REMARKS                 					
									pstmt_update_medn_admin.setString(++count,"");	//	// ADR_RECORDED_DATE_TIME      					
									pstmt_update_medn_admin.setString(++count,"");	//	// ADR_RECORDED_BY             					
								}

								pstmt_update_medn_admin.setString(++count,facility_id.trim());						//FACILITY_ID
								pstmt_update_medn_admin.setString(++count,encounter_id.trim());					//ENCOUNTER_ID
								pstmt_update_medn_admin.setString(++count,((String)alt_drugs.get(j+8)).trim());	//SCH_DATE_TIME
								pstmt_update_medn_admin.setString(++count,((String)alt_drugs.get(j+1)).trim());	//ORD_DRUG_CODE
								pstmt_update_medn_admin.setString(++count,((String)alt_drugs.get(j+2)).trim());	//DOSAGE_SEQ_NO						
								pstmt_update_medn_admin.setString(++count,((String)alt_drugs.get(j+4)).trim());	//ORDER_ID						
								pstmt_update_medn_admin.addBatch();	
								//pstmt_update_medn_admin.executeUpdate();			
							}						
								//closeStatement( pstmt_update_medn_admin ) ;
							// insert into PH_MEDN_ADMIN_DTL
							administered_drugs = administered_drugs + (((String)alt_drugs.get(j))+":"+((String)alt_drugs.get(j+6)));
							count=1;
							if(!"Y".equals((String)alt_drugs.get(j+13)) && !"N".equals((String)alt_drugs.get(j+12))){ //if condition added for AAKH-CRF-0024 [IN:038260]
								medn_admin_dtl_cnt_altdrug++;	//Added for AAKH-CRF-0024 [IN:038260]
								pstmt_insert_medn_admin_dtl.setString(count,facility_id);					//	FACILITY_ID
								pstmt_insert_medn_admin_dtl.setString(++count,encounter_id);				//	ENCOUNTER_ID
								pstmt_insert_medn_admin_dtl.setString(++count,(String)alt_drugs.get(j+8));	//	SCH_DATE_TIME
								pstmt_insert_medn_admin_dtl.setString(++count,(String)alt_drugs.get(j+1));	//	ORD_DRUG_CODE
								pstmt_insert_medn_admin_dtl.setString(++count,(String)alt_drugs.get(j+2));	//	DOSAGE_SEQ_NO
								pstmt_insert_medn_admin_dtl.setString(++count,srl_no+"");						//	SRL_NO
								pstmt_insert_medn_admin_dtl.setString(++count,(String)alt_drugs.get(j));	//	ADMIN_DRUG_CODE
								pstmt_insert_medn_admin_dtl.setString(++count,(String)alt_drugs.get(j+6));		//	ADMIN_DOSAGE_QTY
								pstmt_insert_medn_admin_dtl.setString(++count,(String)alt_drugs.get(j+7));		//	ADMIN_DOSAGE_UOM_CODE
								pstmt_insert_medn_admin_dtl.setString(++count,"");			//	ADMIN_STRENGTH
								pstmt_insert_medn_admin_dtl.setString(++count,"");			//	ADMIN_STRENGTH_UNIT
								pstmt_insert_medn_admin_dtl.setString(++count,"");			//	ADMIN_INFUSION_RATE
								pstmt_insert_medn_admin_dtl.setString(++count,"");			//	ADMIN_INFUSION_VOL_STR_UNIT
								pstmt_insert_medn_admin_dtl.setString(++count,"");			//	ADMIN_INFUSION_PER_UNIT
								pstmt_insert_medn_admin_dtl.setString(++count,admin_by);	//	ADMIN_BY
								pstmt_insert_medn_admin_dtl.setString(++count,admin_by);	//	ADDED_BY_ID
								pstmt_insert_medn_admin_dtl.setString(++count,ws_no);		//	ADDED_AT_WS_NO
								pstmt_insert_medn_admin_dtl.setString(++count,facility_id);	//	ADDED_FACILITY_ID
								pstmt_insert_medn_admin_dtl.setString(++count,admin_by);	//	MODIFIED_BY_ID
								pstmt_insert_medn_admin_dtl.setString(++count,ws_no);		//	MODIFIED_AT_WS_NO
								pstmt_insert_medn_admin_dtl.setString(++count,facility_id);	//	MODIFIED_FACILITY_ID
								pstmt_insert_medn_admin_dtl.setString(++count,(String)alt_drugs.get(j+3));		//	ITEM_CODE
								pstmt_insert_medn_admin_dtl.setString(++count,(String)alt_drugs.get(j+10));		//  BATCH_ID
								pstmt_insert_medn_admin_dtl.setString(++count,(String)alt_drugs.get(j+11));		//  EXPIRY_DATE
								pstmt_insert_medn_admin_dtl.setString(++count,(String)alt_drugs.get(j+11));		//  EXPIRY_DATE
								pstmt_insert_medn_admin_dtl.setString(++count,(String)alt_drugs.get(j+12));		//	TRADE_ID
								pstmt_insert_medn_admin_dtl.setString(++count,(String)alt_drugs.get(j+4));		//	ORDER_ID
								//code added for inserting batch_id in ph_medn_admin_dtl
								pstmt_insert_medn_admin_dtl.setString(++count,(String)non_iv_drugs.get(i+23));			//	PREVIOUS_BATCH_ID
								pstmt_insert_medn_admin_dtl.setString(++count,(String)non_iv_drugs.get(i+24));			//	PREVIOUS_expiry_dt
								pstmt_insert_medn_admin_dtl.setString(++count,(String)non_iv_drugs.get(i+25));			//	PREVIOUS_trade_id
								pstmt_insert_medn_admin_dtl.setString(++count,(String)non_iv_drugs.get(i+14));					
								pstmt_insert_medn_admin_dtl.setString(++count,(String)non_iv_drugs.get(i+37));		//Linked Vaccine Code					
								pstmt_insert_medn_admin_dtl.setString(++count,(String)non_iv_drugs.get(i+41));		//ADMIN_BY_TYPE					
								pstmt_insert_medn_admin_dtl.setString(++count,(String)non_iv_drugs.get(i+42));		//SELF_ADMIN_BY
								if(administered_yn.equals("Y"))
									pstmt_insert_medn_admin_dtl.setString(++count,(String)non_iv_drugs.get(i+17));	//ADMIN_REASON_CODE	
								else
									pstmt_insert_medn_admin_dtl.setString(++count,"");	//ADMIN_REASON_CODE
								
								pstmt_insert_medn_admin_dtl.setString(++count,"");	// EARLY_OR_LATE_ADMIN  Added for GHL-CRF-0482
								pstmt_insert_medn_admin_dtl.setString(++count,""); // Added for AAKH-SCF-0398
								pstmt_insert_medn_admin_dtl.setString(++count,""); // Added for AAKH-SCF-0398
								
								pstmt_insert_medn_admin_dtl.addBatch();			
								srl_no++;
							}
						} //Added for AAKH-CRF-0024 [IN:038260]
					/*	int result_alt_dtl_insert[]=pstmt_insert_medn_admin_dtl.executeBatch();			
						for (int k=0;k<result_alt_dtl_insert.length ;k++ ){
							// A number greater than or equal to zero  indicates success
							// A number -2 indicates that command is successful but number of rows updated is unknow
							// If it won't satisfy any of the above cancel the statement and throw an exception
							if(result_alt_dtl_insert[k]<0  && result_alt_dtl_insert[k] != -2 ){
								pstmt_insert_medn_admin_dtl.cancel();
								connection.rollback();
								throw new EJBException("Insertion Failed.........");
							}		
						}*/
						//closeStatement(pstmt_insert_medn_admin_dtl);
						//Update PH_PATIENT_DRUG_PROFILE
						//pstmt_update_patient_drug_profile = connection.prepareStatement( SQL_PH_MEDN_ADMIN_PAT_DRUG_PROFILE_FT_UPDATE ) ;
						count=1;
						pstmt_update_patient_drug_profile.setString(count,administered_drugs);	//administered_drugs
						pstmt_update_patient_drug_profile.setString(++count,"0");				// qty
						pstmt_update_patient_drug_profile.setString(++count,admin_by);
						pstmt_update_patient_drug_profile.setString(++count,ws_no);
						pstmt_update_patient_drug_profile.setString(++count,facility_id);
						pstmt_update_patient_drug_profile.setString(++count,patient_id);
						pstmt_update_patient_drug_profile.setString(++count,(String)alt_drugs.get(4));					//order_id
						pstmt_update_patient_drug_profile.setString(++count,(String)alt_drugs.get(5));					//order_line_num
	
						//pstmt_update_patient_drug_profile.executeUpdate();
						pstmt_update_patient_drug_profile.addBatch();	
					}
					//closeStatement(pstmt_update_patient_drug_profile);
				}
//for header table insertion
				int result_alt_hdr_insert[]=pstmt_update_medn_admin.executeBatch();	
				for (int k=0;k<result_alt_hdr_insert.length ;k++ ){
					// A number greater than or equal to zero  indicates success
					// A number -2 indicates that command is successful but number of rows updated is unknow
					// If it won't satisfy any of the above cancel the statement and throw an exception
					if(result_alt_hdr_insert[k]<0  && result_alt_hdr_insert[k] != -2 ){
						pstmt_update_medn_admin.cancel();
						connection.rollback();
						throw new EJBException("dispmedication insertion failed.........");
					}		
				}
//for detail table insertion
				int result_alt_dtl_insert[]=null;//added for AAKH-CRF-0024 [IN:038260]
				//added for AAKH-CRF-0024 [IN:038260] Starts
				if(medn_admin_dtl_cnt_altdrug>0)
				{	
					result_alt_dtl_insert=pstmt_insert_medn_admin_dtl.executeBatch();
				}
				//added for AAKH-CRF-0024 [IN:038260] Ends
				for (int k=0;k<result_alt_dtl_insert.length ;k++ ){
					// A number greater than or equal to zero  indicates success
					// A number -2 indicates that command is successful but number of rows updated is unknow
					// If it won't satisfy any of the above cancel the statement and throw an exception
					if(result_alt_dtl_insert[k]<0  && result_alt_dtl_insert[k] != -2 ){
						pstmt_insert_medn_admin_dtl.cancel();
						connection.rollback();
						throw new EJBException("dispmedication detail failed.........");
					}		
				}
//for drug profile update

				int result_drug_profile_update[]=pstmt_update_patient_drug_profile.executeBatch();
				for (int k=0;k<result_drug_profile_update.length ;k++ ){
					// A number greater than or equal to zero  indicates success
					// A number -2 indicates that command is successful but number of rows updated is unknow
					// If it won't satisfy any of the above cancel the statement and throw an exception
					if(result_drug_profile_update[k]<0  && result_drug_profile_update[k] != -2 ){
						pstmt_update_patient_drug_profile.cancel();
						connection.rollback();
						throw new EJBException("drug profile updation failed.........");
					}		
				}
			}
			
			//String Auto_admin		="";
			facility_id	=(String)commonValues.get("facility_id");
			//Auto_admin	=tabData.get("Auto_admin")==null?"N":(String)tabData.get("Auto_admin");
			HashMap prev_doc_no		=new HashMap();
			String patient_class=((String)tabData.get("patient_class")).trim();
		
			if(Auto_admin.equals("Y")){
			// Get the Stock Doc Type 
				if(dispTMP !=null){
					ArrayList dis = null;
					HashMap seq_no = null;
					HashMap batch	    =   null;
					String st_doc_type	=	getStockDocType(connection,sqlMap,patient_class,facility_id);
					for(int k=0;k<dispTMP.size();k=k+12){//9 to 12 for [IN:040149]
						dis=new ArrayList();
						dis.add(dispTMP.get(k));
						dis.add(dispTMP.get(k+1));
						dis.add(dispTMP.get(k+2));
						dis.add(dispTMP.get(k+3));
						dis.add(dispTMP.get(k+4));
						dis.add(dispTMP.get(k+5));
						dis.add(dispTMP.get(k+6));
						//ArrayList batchDetails = (ArrayList)dispTMP.get(k+7);
						dis.add(dispTMP.get(k+7));
						dis.add(dispTMP.get(k+9)); //Added for [IN:040149]-Start
						dis.add(dispTMP.get(k+10));
						dis.add(dispTMP.get(k+11)); //9 to 12 for [IN:040149] -End
						if(!(((String)dispTMP.get(k+8)).equals("Y"))){
							seq_no	=	insertHeader(connection,sqlMap,tabData,dis);

							if( seq_no.containsKey( "result" )){
								connection.rollback();
								map.put( "result", new Boolean( false) ) ;
								map.put("msgid",seq_no.get("msgid"));	
								return map;
							} 
							stock_srl	    =   new HashMap();
					
							stock_srl		=	insertDetail(connection,sqlMap,tabData,dis,seq_no,stock_srl);
							if(  stock_srl.containsKey( "result" )){
								connection.rollback();
								map.put( "result", new Boolean( false) ) ;
								map.put("msgid",stock_srl.get("msgid"));	
								return map;
					
							} 
							batch=insertBatch(connection, sqlMap,tabData,dis,seq_no);
							if(  batch.containsKey( "result" )){
								connection.rollback();
								map.put( "result", new Boolean( false) ) ;
								map.put("msgid",batch.get("msgid"));	
								return map;
					
							} 
							commonValues.put("seq_no",seq_no);
							callStockUpdate(connection,commonValues,sqlMap,dis,prev_doc_no,st_doc_type,stock_srl);										
							updateDrugProfile(connection, sqlMap, tabData,dis);
						}
					}
				}
			}
			connection.commit();
			map.put( "result", new Boolean( true) ) ;
			map.put("msgid","RECORD_INSERTED");			
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("in catch the record is not inserted tabData="+tabData );
			connection.rollback();
			map.put( "result", new Boolean( false) ) ;
			map.put("msgid",e.toString());	
		}
		finally{
			try{					
				closeStatement( pstmt_insert_medn_admin_dtl ) ;		
				closeStatement( pstmt_insert_medn_admin ) ;	
				closeStatement( pstmt_insert_patient_drug_profile );
				//closeStatement( pstmt_update_or_order_line_ph );
				closeStatement( pstmt_update_medn_admin ) ;
				closeStatement( pstmt_update_patient_drug_profile ) ;
				closeStatement( pstmt_select );
				closeStatement( pstmt_select1 );
				closeStatement( pstmt_select2 );
				closeStatement( pstmt_select3 );
				closeStatement(pstmt_select2A);//Close statement based on checkstyle on ICN63833
				closeResultSet( resultSet1);
				//closeConnection( connection,prop );
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return map;
	}
	public HashMap insertIVAdminDetailsSCH(Connection connection, HashMap tabData, HashMap sqlMap, String language_id) throws Exception{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		prop						= (Properties)tabData.get("properties");
		ArrayList non_iv_drugs		= (ArrayList)tabData.get("NON_IV_DRUGS");
		//HashMap alt_drug_details	= (HashMap)tabData.get("ALTERNATE_DRUGS"); unused local variable 63877
		ArrayList iv_drugs			= (ArrayList)tabData.get("IV_DRUGS");
		HashMap commonValues		= (HashMap)tabData.get("COMMON_VALUES");
		ArrayList dispTMP			= (ArrayList)tabData.get("DISP_DTLS");
		HashMap adr_values			= (HashMap)tabData.get("ADR_VALUES");
		HashMap stock_srl		=(HashMap)tabData.get("stock_srl");
		//HashMap hmAddedTaperSch		=(HashMap)tabData.get("AddedTaperSch"); unused local variable 63877
		final String SQL_PH_MEDN_ADMIN_DTL_FT_INSERT				= (String)sqlMap.get("SQL_PH_MEDN_ADMIN_DTL_FT_INSERT");
		final String SQL_PH_MEDN_ADMIN_PAT_DRUG_PROFILE_FT_UPDATE1	= (String)sqlMap.get("SQL_PH_MEDN_ADMIN_PAT_DRUG_PROFILE_FT_UPDATE1");

		final String SQL_PH_MEDN_ADMIN_FT_IV_UPDATE	=	(String)sqlMap.get("SQL_PH_MEDN_ADMIN_FT_IV_UPDATE");
		final String SQL_PH_PRESCRIPTION_SELECT1	=	(String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT1");
		final String SQL_PH_MEDN_ADMIN_FT_INSERT1	=	(String)sqlMap.get("SQL_PH_MEDN_ADMIN_FT_INSERT1");
		final String SQL_PH_MED_ADMIN_FT_SELECT18	=	(String)sqlMap.get("SQL_PH_MED_ADMIN_FT_SELECT18");
		final String SQL_PH_PRESCRIPTION_SELECT86	=	(String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT86");
		final String SQL_PH_MED_ADMIN_FT_SELECT27	=	(String)sqlMap.get("SQL_PH_MED_ADMIN_FT_SELECT27");
		//final String SQL_PH_MEDN_ADMIN_OR_ORDER_LINE_PH_UPDATE	=	(String)sqlMap.get("SQL_PH_MEDN_ADMIN_OR_ORDER_LINE_PH_UPDATE"); //COMMENTED FOR COMMON-ICN-0048

		String facility_id		=(String)commonValues.get("facility_id");
		String admin_by			=(String)commonValues.get("admin_by");
		String added_by			=(String)commonValues.get("added_by");
		String ws_no			=(String)commonValues.get("ws_no");
		String encounter_id		=(String)commonValues.get("encounter_id");
		String assign_bed_num	=(String)commonValues.get("assign_bed_num");
		String nursing_unit		=(String)commonValues.get("nursing_unit");
		String patient_id		=(String)commonValues.get("patient_id");
        commonValues.put("disp_locn_code_MAR",(String)tabData.get("disp_locn_code_MAR"));

		PreparedStatement pstmt_update_medn_admin = null,pstmt_insert_medn_admin=null,pstmt_insert_medn_admin_dtl=null,pstmt_update_patient_drug_profile=null,pstmt_insert_patient_drug_profile=null;//,pstmt_update_or_order_line_ph=null; //COMMENTED FOR COMMON-ICN-0048
		PreparedStatement pstmt_select	=	null;
		PreparedStatement pstmt_MFRYN	=	null;
		PreparedStatement pstmt_unit	=	null;
		PreparedStatement pstmt_select1	=	null;
		PreparedStatement pstmt_select2	=	null;
		//PreparedStatement pstmt_select2A=	null; Unused local variable INC63877
		PreparedStatement pstmt_select3	=	null;
		ResultSet resultSet				=	null;
		ResultSet resultSetunit			=	null;
		ResultSet resultSet1			=	null;
		//ResultSet resultSet2A			=	null; Unused local variable INC63877
		ResultSet resultSet_MFRYN		=	null;
		String freq_nat					=	"";
		String Auto_admin		="";
		//boolean blnAddedTaperSch = false; Unused local variable INC63877
		//String nextDosageSeqNo = "", currDosageSeqNo; Unused local variable INC63877
		String /*key="", tapScheDateTime="", Unused local variable INC63877*/ administered_yn="";
		int count=1;
		try{
			pstmt_select1			= connection.prepareStatement( SQL_PH_MED_ADMIN_FT_SELECT18 ) ;					
			pstmt_select3	=	connection.prepareStatement( SQL_PH_PRESCRIPTION_SELECT1 ) ;
			if(isCurentRowAdministeredByOtherUser(connection,non_iv_drugs,iv_drugs,facility_id,encounter_id)){
				connection.rollback();
				map.put( "result", new Boolean( false) ) ;
				map.put("msgid","ADMIN_BY_OTHERS");	
				return map;
			}
		//	PreparedStatement psAuditLog = null;// Added for AAKH-CRF-0024 [IN:038260] Unused local variable INC63877

			/***************************************************
							FOR IV ADMINISTERED DRUGS
			****************************************************/
			if(iv_drugs.size()>0){			
				pstmt_update_medn_admin = connection.prepareStatement( SQL_PH_MEDN_ADMIN_FT_IV_UPDATE ) ;
				pstmt_select2			= connection.prepareStatement( SQL_PH_MED_ADMIN_FT_SELECT27 ) ;
				
				String iv_prep_yn			=	"";				
				String ord_drug_code		=   null;
				ArrayList arr_list  = null;
				for(int i=0;i<iv_drugs.size();i=i+42){//Changed 40 to 41 //Modified from 39 to 40 for HSA-CRF-0090//Size changed from 38 to 39 for AAKH-CRF-0024 [IN:038260] and changed 41 to 42 for SKR-SCF-1240
					administered_yn = iv_drugs.get(i+17)==null?"":(String)iv_drugs.get(i+17);  //Added for SKR-CRF-0037 [IN:037656]
					count=1;
					pstmt_update_medn_admin.setString(count,nursing_unit);					//ADMIN_NURSING_UNIT_CODE
					pstmt_update_medn_admin.setString(++count,assign_bed_num);				//ADMIN_BED_NO
					pstmt_update_medn_admin.setString(++count,admin_by);					//ADMIN_BY
					pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i+15));	//ADMIN_REMARKS
					pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i+16));	//NON_ADMIN_REMARKS
					pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i+18));	//ADMIN_RECORDED_YN
					pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i+6));	//ADMIN_DATE_TIME
					pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i+17));	//ADMINISTERED_YN
					pstmt_update_medn_admin.setString(++count,facility_id);					//MODIFIED_FACILITY_ID
					pstmt_update_medn_admin.setString(++count,added_by);					//MODIFIED_BY_ID
					pstmt_update_medn_admin.setString(++count,ws_no);						//MODIFIED_AT_WS_NO
					pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i+7));	//SCH_INFUSION_RATE		
					pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i+8));	//SCH_INFUSION_VOL_STR_UNIT		
					pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i+9));	//SCH_INFUSION_PER_UNIT		
					pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i+10));	//SCH_INFUSION_PERIOD				
					pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i+11));	//SCH_INFUSION_PERIOD_UNIT		
					if(administered_yn.equals("Y")) 
						pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i+22));	// ADMIN_CODE added for mms-kh-crf-0010
					else
						pstmt_update_medn_admin.setString(++count,"");	//ADMIN_CODE added for mms-kh-crf-0010
					if(!administered_yn.equals("")) // if condition and else block added for SKR-CRF-0037 [IN:037656]	
						pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i+22));	//NON_ADMIN_CODE
					else
						pstmt_update_medn_admin.setString(++count,"");	//NON_ADMIN_CODE
					
					if( ((String)iv_drugs.get(i+23)).equals("")){
						pstmt_update_medn_admin.setString(++count,admin_by);				//ADMIN_RECORDED_BY
					}
					else {
						pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i+23));	//ADMIN_RECORDED_BY		
					}
					pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i+24));	//ADMIN_AUTHORIZED_BY		
					
					if(adr_values!=null && adr_values.containsKey((String)iv_drugs.get(i)+"-"+(String)iv_drugs.get(i+3))){
						arr_list = (ArrayList)adr_values.get((String)iv_drugs.get(i)+"-"+(String)iv_drugs.get(i+3));
						pstmt_update_medn_admin.setString(++count,(String)arr_list.get(0));	//	// AGAINST_SCHDOSE_DATE_TIME   					
						pstmt_update_medn_admin.setString(++count,(String)arr_list.get(1));	//	// ADR_REASON_CODE             					
						pstmt_update_medn_admin.setString(++count,(String)arr_list.get(3));	//	// ADR_REMARKS                 					
						pstmt_update_medn_admin.setString(++count,(String)arr_list.get(2));	//	// ADR_RECORDED_DATE_TIME      					
						pstmt_update_medn_admin.setString(++count,(String)arr_list.get(4));	//	// ADR_RECORDED_BY             		
					}
					else{
						pstmt_update_medn_admin.setString(++count,"");	//	// AGAINST_SCHDOSE_DATE_TIME   					
						pstmt_update_medn_admin.setString(++count,"");	//	// ADR_REASON_CODE             					
						pstmt_update_medn_admin.setString(++count,"");	//	// ADR_REMARKS                 					
						pstmt_update_medn_admin.setString(++count,"");	//	// ADR_RECORDED_DATE_TIME      					
						pstmt_update_medn_admin.setString(++count,"");	//	// ADR_RECORDED_BY             					
					}
					pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i+19)); // ADMN_DOSE_CHNG_REASON_CODE
					pstmt_update_medn_admin.setString(++count,facility_id);					//FACILITY_ID
					pstmt_update_medn_admin.setString(++count,encounter_id);				//ENCOUNTER_ID
					pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i+20));	//SCH_DATE_TIME
					pstmt_select2.setString(1,(String)iv_drugs.get(i+3));
					resultSet	= pstmt_select2.executeQuery() ;
					if (resultSet!=null && resultSet.next()){
						iv_prep_yn		=	resultSet.getString("iv_prep_yn");				
					}										
                    if(iv_prep_yn.equals("2")||iv_prep_yn.equals("4")){
						ord_drug_code="FINAL PRODUCT";
					}
					else{
                        ord_drug_code=(String)iv_drugs.get(i+1);
					} 

					pstmt_update_medn_admin.setString(++count,ord_drug_code);	//ORD_DRUG_CODE
					pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i));		//DOSAGE_SEQ_NO	
					pstmt_update_medn_admin.setString(++count,(String)iv_drugs.get(i+3));		//ORDER_ID
					pstmt_update_medn_admin.addBatch();
					
//System.err.println("===facility_id====>"+facility_id+" encounter_id="+encounter_id+" ===iv_drugs.get(i+20)==="+iv_drugs.get(i+20)+" ==iv_drugs.get(i+3)="+iv_drugs.get(i+3)+"==ord_drug_code="+ord_drug_code+" iv_drugs.get(i)="+iv_drugs.get(i)+"==iv_drugs.get(i+3)="+iv_drugs.get(i+3)+"===iv_drugs.get(i+4)=="+iv_drugs.get(i+4));
					if("1".equals((String)iv_drugs.get(i+4))){
						insertAuditlogIV(connection, iv_drugs, facility_id, added_by, encounter_id,ord_drug_code,i);//added for AAKH-CRF-0024 [IN:038260]
					}
				}
				int result_iv_1[]=pstmt_update_medn_admin.executeBatch();	
				for (int i=0;i<result_iv_1.length ;i++ ){	
//System.err.println("===result_iv_1[i]====>"+result_iv_1[i]);					
					if(result_iv_1[i]<0  && result_iv_1[i] != -2 ){
						pstmt_update_medn_admin.cancel();
						connection.rollback();
						System.err.println("Failed while updating PH_MEDN_ADMIN Table==1=1==");
						throw new EJBException("Updation Failed.........");
					}		
				}	
				closeStatement(pstmt_update_medn_admin);
				closeResultSet( resultSet );
				closeStatement(pstmt_select);
				closeStatement(pstmt_select2);
				
				pstmt_insert_medn_admin_dtl = connection.prepareStatement( SQL_PH_MEDN_ADMIN_DTL_FT_INSERT ) ;				
				pstmt_MFRYN					= connection.prepareStatement( "select MFR_YN from OR_ORDER_LINE_PH where order_id=?" ) ;
				pstmt_unit					= connection.prepareStatement( "SELECT INFUSE_OVER_UNIT from OR_ORDER_LINE_PH WHERE ORDER_ID=? AND ORDER_LINE_NUM=?" );
				pstmt_select				= connection.prepareStatement( "SELECT CEIL(TOT_INFUSION_OVER/ORIG_INFUSE_OVER*?) NO_OF_DOSES FROM OR_ORDER_LINE_PH WHERE ORDER_ID=? AND ORDER_LINE_NUM=?" );				
				
				pstmt_insert_medn_admin		= connection.prepareStatement( SQL_PH_MEDN_ADMIN_FT_INSERT1 );				
				pstmt_select2				= connection.prepareStatement( SQL_PH_MED_ADMIN_FT_SELECT27 ) ;
				iv_prep_yn					=	"";
				String MFR_YN				=	"N";
				int med_admin_dtl_count_iv = 0;//Added for AAKH-CRF-0024 [IN:038260]
				for(int i=0;i<iv_drugs.size();i=i+42){//Changed 40 to 41//Modified from 39 to 40 for HSA-CRF-0090//Size changed from 38 to 39  for AAKH-CRF-0024 [IN:038260]	 and changed 41 to 42 for SKR-SCF-1240
					pstmt_select2.setString(1,(String)iv_drugs.get(i+3));
					resultSet	= pstmt_select2.executeQuery() ;
					if (resultSet!=null && resultSet.next()){
						iv_prep_yn		=	resultSet.getString("iv_prep_yn");				
					}
					closeResultSet( resultSet ) ;

					pstmt_MFRYN.setString(1,(String)iv_drugs.get(i+3));
					resultSet_MFRYN	= pstmt_MFRYN.executeQuery() ;
					if (resultSet_MFRYN!=null && resultSet_MFRYN.next()){
						MFR_YN		=	resultSet_MFRYN.getString("MFR_YN")==null?"":resultSet_MFRYN.getString("MFR_YN");				
					}
					closeResultSet(resultSet_MFRYN ) ;		
					count=1;
					int doseunit=1;
					administered_yn = iv_drugs.get(i+17)==null?"":(String)iv_drugs.get(i+17);  //Added for SKR-CRF-0037 [IN:037656]
					if((!"Y".equals((String)iv_drugs.get(i+18)) && !"N".equals((String)iv_drugs.get(i+17))) || ("Y".equals((String)iv_drugs.get(i+18)) && "Y".equals((String)iv_drugs.get(i+17))) ){//if condition added for AAKH-CRF-0024 [IN:038260]
						med_admin_dtl_count_iv++;//Added for AAKH-CRF-0024 [IN:038260]
						pstmt_insert_medn_admin_dtl.setString(count,facility_id);			//	FACILITY_ID
						pstmt_insert_medn_admin_dtl.setString(++count,encounter_id);		//	ENCOUNTER_ID
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+20));	//	SCH_DATE_TIME
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+1));	//	ORD_DRUG_CODE
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i));		//	DOSAGE_SEQ_NO
						pstmt_insert_medn_admin_dtl.setString(++count,"1");							//	SRL_NO
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+1));	//	ADMIN_DRUG_CODE
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+5));	//	ADMIN_DOSAGE_QTY
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+41));	//	ADMIN_DOSAGE_UOM_CODE and changed 8 to 41 for SKR-SCF-1240
						pstmt_insert_medn_admin_dtl.setString(++count,"");							//	ADMIN_STRENGTH //10
						pstmt_insert_medn_admin_dtl.setString(++count,"");							//	ADMIN_STRENGTH_UNIT
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+7));	//	ADMIN_INFUSION_RATE
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+8));	//	ADMIN_INFUSION_VOL_STR_UNIT
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+9));	//	ADMIN_INFUSION_PER_UNIT
						pstmt_insert_medn_admin_dtl.setString(++count,admin_by);	//	ADMIN_BY
						pstmt_insert_medn_admin_dtl.setString(++count,admin_by);	//	ADDED_BY_ID
						pstmt_insert_medn_admin_dtl.setString(++count,ws_no);		//	ADDED_AT_WS_NO
						pstmt_insert_medn_admin_dtl.setString(++count,facility_id);	//	ADDED_FACILITY_ID
						pstmt_insert_medn_admin_dtl.setString(++count,admin_by);	//	MODIFIED_BY_ID
						pstmt_insert_medn_admin_dtl.setString(++count,ws_no);		//	MODIFIED_AT_WS_NO //20
						pstmt_insert_medn_admin_dtl.setString(++count,facility_id);	//	MODIFIED_FACILITY_ID
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+2));		//	ITEM_CODE
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+12));		//  BATCH_ID
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+13));		//  EXPIRY_DATE 
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+13));		//  EXPIRY_DATE
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+14));		//	TRADE_ID
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+30));		//	PREVIOUS_BATCH_ID
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+31));		//	PREVIOUS_EXP_DT
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+32));		//	PREVIOUS_TRADE_ID
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+3));		//	ORDER_ID  //30
						pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+34));		//	Linked Vaccine Code//31
						pstmt_insert_medn_admin_dtl.setString(++count,"U"); //ADMIN_BY_TYPE
						pstmt_insert_medn_admin_dtl.setString(++count,"");	//SELF_ADMIN_BY
						if(administered_yn.equals("Y")) //Added for SKR-CRF-0037 [IN:037656]
							pstmt_insert_medn_admin_dtl.setString(++count,(String)iv_drugs.get(i+22));	//ADMIN_REASON_CODE
						else
							pstmt_insert_medn_admin_dtl.setString(++count,"");	//ADMIN_REASON_CODE
						
						pstmt_insert_medn_admin_dtl.setString(++count,"");	// EARLY_OR_LATE_ADMIN  Added for GHL-CRF-0482
						pstmt_insert_medn_admin_dtl.setString(++count,""); // Added for AAKH-SCF-0398
						pstmt_insert_medn_admin_dtl.setString(++count,""); // Added for AAKH-SCF-0398
						 
						pstmt_insert_medn_admin_dtl.addBatch();	
					}
					if(!MFR_YN.equals("Y")){
						pstmt_unit.setString(1,(String)iv_drugs.get(i+3));
						pstmt_unit.setString(2,(String)iv_drugs.get(i+4));
						resultSetunit	=	pstmt_unit.executeQuery();
						if(resultSetunit!=null && resultSetunit.next()){
							if((resultSetunit.getString("INFUSE_OVER_UNIT").trim()).equals("M")){
								doseunit=60;
							}
						}
						closeResultSet( resultSetunit);
						pstmt_select.setInt(1,doseunit);
						pstmt_select.setString(2,(String)iv_drugs.get(i+3));
						pstmt_select.setString(3,(String)iv_drugs.get(i+4));					
						resultSet	=	pstmt_select.executeQuery();
						if(resultSet!=null && resultSet.next()) {
							if( !(iv_prep_yn).equals("3") && !(iv_prep_yn).equals("4") && (resultSet.getInt("NO_OF_DOSES") - Integer.parseInt((String)iv_drugs.get(i)))>0) {
								if(!"Y".equals((String)iv_drugs.get(i+38))){//if condition aded for AAKH-CRF-0024 [IN:038260]
									//pstmt_insert_medn_admin.setString(1,(String)iv_drugs.get(i+28));//NEXT SCHEDULE DATE taking 
									pstmt_insert_medn_admin.setString(1,(String)iv_drugs.get(i+28));//NEXT SCHEDULE DATE
									pstmt_insert_medn_admin.setString(2,facility_id);//FACILITY_ID					
									pstmt_insert_medn_admin.setString(3,encounter_id);//ENCOUNTER_ID		
									pstmt_insert_medn_admin.setString(4,(String)iv_drugs.get(i+20));	//SCH_DATE_TIME
									pstmt_insert_medn_admin.setString(5,(String)iv_drugs.get(i+1));	//ORD_DRUG_CODE
									pstmt_insert_medn_admin.setString(6,(String)iv_drugs.get(i+3));	//ORDER_ID
									pstmt_insert_medn_admin.setString(7,(String)iv_drugs.get(i+4));	//ORDER_LINE_NUM		
									pstmt_insert_medn_admin.executeUpdate();															
								}
							}
						} //Added for AAKH-CRF-0024 [IN:038260]
						closeResultSet( resultSet);
					}
				}
				int result_iv_2[] = null; 
				if(med_admin_dtl_count_iv>0){ 
					result_iv_2 = pstmt_insert_medn_admin_dtl.executeBatch();
				}
				
				if(null!=result_iv_2){ 
					for (int i=0;i<result_iv_2.length ;i++ ){
						if(result_iv_2[i]<0  && result_iv_2[i] != -2 ){
							pstmt_insert_medn_admin_dtl.cancel();
							connection.rollback();
							System.err.println("Failed3 while inserting into PH_MEDN_ADMIN_DTL Table===794=====");
							throw new EJBException("Insertion Failed.........");
						}		
					}	
				} 
				closeStatement(pstmt_insert_medn_admin_dtl);
				closeStatement(pstmt_unit);
				closeStatement(pstmt_select);
				closeStatement(pstmt_MFRYN);
				pstmt_select	=	null;

				pstmt_update_patient_drug_profile = connection.prepareStatement( SQL_PH_MEDN_ADMIN_PAT_DRUG_PROFILE_FT_UPDATE1 ) ;
				pstmt_select	=	connection.prepareStatement( SQL_PH_PRESCRIPTION_SELECT86 ) ;	

				String tot_admin_quantity		 =	"";
				String strength_per_value_pres_iv=	"";
				String strength_iv				 =	"";
				String pres_mode_iv				 =	"";
				float div_value_iv				 =	0;
				for(int i=0;i<iv_drugs.size();i=i+42){//Changed 40 to 41//Modified from 39 to 40 for HSA-CRF-0090 and changed 41 to 42 for SKR-SCF-1240
					tot_admin_quantity			="";
					freq_nat					="";
					strength_per_value_pres_iv	="";
					strength_iv					="";
					pres_mode_iv				="";
					count						=1;
					div_value_iv				=0;

					pstmt_select2.setString(1,(String)iv_drugs.get(i+3));  //order_id
					resultSet	= pstmt_select2.executeQuery() ;
					if (resultSet!=null && resultSet.next()){
						iv_prep_yn		=	resultSet.getString("iv_prep_yn");	
					}
					closeResultSet( resultSet ) ;
					if(iv_prep_yn.equals("1")||iv_prep_yn.equals("3")){

						pstmt_select1.setString(1,(String)iv_drugs.get(i+3));  //order_id
						pstmt_select1.setString(2,(String)iv_drugs.get(i+4));  //order_line_no
						resultSet1	=	pstmt_select1.executeQuery();
						if(resultSet1.next())	{
							freq_nat	=	resultSet1.getString("FREQ_NATURE");
						}
						closeResultSet( resultSet1) ;
						resultSet1	=	null;

						pstmt_select3.setString(1,(String)iv_drugs.get(i+1));  //Drug Code
						pstmt_select3.setString(2, language_id);
						pstmt_select3.setString(3, language_id);
						pstmt_select3.setString(4, language_id);
						pstmt_select3.setString(5, language_id);
						pstmt_select3.setString(6, language_id);
						resultSet1	=	pstmt_select3.executeQuery();
						if(resultSet1!=null && resultSet1.next()) {
							strength_per_value_pres_iv	= resultSet1.getString("STRENGTH_PER_VALUE_PRES_UOM");
						}
						if(strength_per_value_pres_iv==null || strength_per_value_pres_iv.equals("") || strength_per_value_pres_iv.equals("0")){
							strength_per_value_pres_iv	=	"1";
						}
						closeResultSet( resultSet1);							
						resultSet1	=	null;

						pstmt_select.setString(1,(String)iv_drugs.get(i+3)); // order_id
						pstmt_select.setString(2,(String)iv_drugs.get(i+4)); // order_line_no
						resultSet1	=	pstmt_select.executeQuery();
						if(resultSet1!=null && resultSet1.next()) {
						pres_mode_iv	=	resultSet1.getString("PRESCRIBED_MODE");
						strength_iv		=	resultSet1.getString("STRENGTH");
						if(pres_mode_iv == null){
							pres_mode_iv="";
						}
                  		if(pres_mode_iv.equals("S") && !freq_nat.equals("P") ) {
							div_value_iv	=	Float.parseFloat(strength_iv);
						}
						else {
							div_value_iv	=	1;
						}
						if(div_value_iv == 0)
							div_value_iv=1;
						}
						closeResultSet( resultSet1);	
						tot_admin_quantity	=(Float.parseFloat((String)iv_drugs.get(i+5))*Float.parseFloat(strength_per_value_pres_iv)/div_value_iv)+"";//Removed Math.ceil() for SKR-SCF-1187					
					}
					else{
                        tot_admin_quantity=(String)iv_drugs.get(i+5);
					} 
				
					pstmt_update_patient_drug_profile.setString(count  ,(String)iv_drugs.get(i+1));		//ADMINISTERED_DRUGS				
					pstmt_update_patient_drug_profile.setString(++count,tot_admin_quantity);		//TOT_ADMINISTERED_QTY
					//pstmt_update_patient_drug_profile.setString(++count,(String)iv_drugs.get(i+7));			//INFUSION_RATE //commented for skr-scf-1612
					//pstmt_update_patient_drug_profile.setString(++count,(String)iv_drugs.get(i+10));			//INFUSE_OVER //commented for skr-scf-1612
					pstmt_update_patient_drug_profile.setString(++count, admin_by);
					pstmt_update_patient_drug_profile.setString(++count, ws_no);
					pstmt_update_patient_drug_profile.setString(++count, facility_id);
					pstmt_update_patient_drug_profile.setString(++count, patient_id);					//PATIENT_ID
					pstmt_update_patient_drug_profile.setString(++count,(String)iv_drugs.get(i+3));		//ORIG_ORDER_ID
					pstmt_update_patient_drug_profile.setString(++count,(String)iv_drugs.get(i+4));		//ORIG_ORDER_LINE_NO
                 
					pstmt_update_patient_drug_profile.addBatch();
				}
				int  result_iv_3[]=pstmt_update_patient_drug_profile.executeBatch();
				for (int i=0;i<result_iv_3.length ;i++ ){
					if(result_iv_3[i]<0  && result_iv_3[i] != -2 ){
						pstmt_update_patient_drug_profile.cancel();
						connection.rollback();
						System.err.println("Failed4 while updating drug profile");
						throw new EJBException("Insertion Failed.........");
					}		
				}
				//Update OR_ORDER_LINE_PH
				//commented for skr-scf-1612
				/*pstmt_update_or_order_line_ph = connection.prepareStatement( SQL_PH_MEDN_ADMIN_OR_ORDER_LINE_PH_UPDATE ) ;
				for(int i=0;i<iv_drugs.size();i=i+42){//Changed 40 to 41 //Modified from 39 to 40 for HSA-CRF-0090 and changed 41 to 42 for SKR-SCF-1240
					count		=	1;
				
					pstmt_update_or_order_line_ph.setString(count,(String)iv_drugs.get(i+10));//INFUSE_OVER
					pstmt_update_or_order_line_ph.setString(++count,(String)iv_drugs.get(i+7));//IN33153 - SKR-SCF-0543- Removed 'infusion_rate' updation on or_order_line_ph. //INFUSION_RATE
					pstmt_update_or_order_line_ph.setString(++count, admin_by);
					pstmt_update_or_order_line_ph.setString(++count, ws_no);
					pstmt_update_or_order_line_ph.setString(++count, facility_id);
					pstmt_update_or_order_line_ph.setString(++count,(String)iv_drugs.get(i+3));		//ORDER_ID
					pstmt_update_or_order_line_ph.setString(++count,(String)iv_drugs.get(i+4));		//ORDER_LINE_NUM
					pstmt_update_or_order_line_ph.addBatch();
				} 

				int  result_iv_4[]=pstmt_update_or_order_line_ph.executeBatch();
				for (int i=0;i<result_iv_4.length ;i++ ){
					if(result_iv_4[i]<0  && result_iv_4[i] != -2 ){
						pstmt_update_patient_drug_profile.cancel();
						connection.rollback();
						System.err.println("Failed4 while inserting into OR_ORDER_LINE_PH Table");
						throw new EJBException("Insertion Failed.........");
					}		
				} */
				closeStatement(pstmt_update_patient_drug_profile);
			}
			
			facility_id			=(String)commonValues.get("facility_id");
			if(Auto_admin==null) Auto_admin="N";
			HashMap prev_doc_no		=new HashMap();
			String patient_class=((String)tabData.get("patient_class")).trim();
		
			if(Auto_admin.equals("Y")){
				if(dispTMP !=null){
					ArrayList dis = null;
					HashMap seq_no = null;
					HashMap batch	    =   null;
					String st_doc_type	=	getStockDocType(connection,sqlMap,patient_class,facility_id);
					for(int k=0;k<dispTMP.size();k=k+12){//9 to 12 for [IN:040149]
						dis=new ArrayList();
						dis.add(dispTMP.get(k));
						dis.add(dispTMP.get(k+1));
						dis.add(dispTMP.get(k+2));
						dis.add(dispTMP.get(k+3));
						dis.add(dispTMP.get(k+4));
						dis.add(dispTMP.get(k+5));
						dis.add(dispTMP.get(k+6));
						dis.add(dispTMP.get(k+7));
						dis.add(dispTMP.get(k+9)); //Added for [IN:040149]-Start
						dis.add(dispTMP.get(k+10));
						dis.add(dispTMP.get(k+11)); //9 to 12 for [IN:040149] -End
						if(!(((String)dispTMP.get(k+8)).equals("Y"))){
							seq_no	=	insertHeader(connection,sqlMap,tabData,dis);

							if( seq_no.containsKey( "result" )){
								connection.rollback();
								map.put( "result", new Boolean( false) ) ;
								map.put("msgid",seq_no.get("msgid"));	
								return map;
							} 
							stock_srl	    =   new HashMap();
					
							stock_srl		=	insertDetail(connection,sqlMap,tabData,dis,seq_no,stock_srl);
							if(  stock_srl.containsKey( "result" )){
								connection.rollback();
								map.put( "result", new Boolean( false) ) ;
								map.put("msgid",stock_srl.get("msgid"));	
								return map;
					
							} 
							batch=insertBatch(connection, sqlMap,tabData,dis,seq_no);
							if(  batch.containsKey( "result" )){
								connection.rollback();
								map.put( "result", new Boolean( false) ) ;
								map.put("msgid",batch.get("msgid"));	
								return map;
					
							} 
							commonValues.put("seq_no",seq_no);
							callStockUpdate(connection,commonValues,sqlMap,dis,prev_doc_no,st_doc_type,stock_srl);										
							updateDrugProfile(connection, sqlMap, tabData,dis);
						}
					}
				}
			}
			connection.commit();
			map.put( "result", new Boolean( true) ) ;
			map.put("msgid","RECORD_INSERTED");			
//System.err.println("==insertIVAdminDetailsSCH=======RETURN===map======>"+map);					
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("in catch the record is not inserted tabData="+tabData );
			connection.rollback();
			map.put( "result", new Boolean( false) ) ;
			map.put("msgid",e.toString());	
		}
		finally{
			try{					
				closeStatement( pstmt_insert_medn_admin_dtl ) ;		
				closeStatement( pstmt_insert_medn_admin ) ;	
				closeStatement( pstmt_insert_patient_drug_profile );
				//closeStatement( pstmt_update_or_order_line_ph );
				closeStatement( pstmt_update_medn_admin ) ;
				closeStatement( pstmt_update_patient_drug_profile ) ;
				closeStatement( pstmt_select );
				closeStatement( pstmt_select1 );
				closeStatement( pstmt_select2 );
				closeStatement( pstmt_select3 ); 
				closeResultSet( resultSet1);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return map;
	}

	//added for AAKH-CRF-0024 [IN:038260] Start
	private void insertAuditlogIV(Connection connection,
		ArrayList iv_drugs, String facility_id, String added_by,
		String encounter_id,String ord_drug_code,int i) throws SQLException {
		
		PreparedStatement pstmt_select;
		StringBuilder builderOrderAction = new StringBuilder();
		StringBuilder builderActionSeq = new StringBuilder();
		StringBuilder builderSql = new StringBuilder();
		builderOrderAction.append("INSERT INTO OR_ORDER_ACTION (	ORDER_ID,ORDER_LINE_NUM,ACTION_SEQ_NUM,ACTION_USER_ID,ACTION_DATE_TIME,ACTION_FACILITY_ID,FIELD_MNEMONIC,FIELD_VALUE_OLD,FIELD_VALUE_NEW,FIELD_VALUE_TXT)");
		builderOrderAction.append("VALUES (?,?,?,?,SYSDATE,?,?,?,?,?)");
		builderActionSeq.append("SELECT NVL(MAX(ACTION_SEQ_NUM),0)+1  FROM OR_ORDER_ACTION  WHERE ORDER_ID = ? ");
		builderSql.append("SELECT NON_ADMIN_REMARKS , NON_ADMIN_CODE FROM PH_MEDN_ADMIN WHERE   FACILITY_ID=? AND ENCOUNTER_ID=? AND SCH_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI') AND ORD_DRUG_CODE=? AND DOSAGE_SEQ_NO=? and order_id=? ");
		pstmt_select	=	null;
		ResultSet resultSet2 = null;
		String non_adm_remarks = "";
		String non_adm_code = "";
		int action_seq_num=0;
		PreparedStatement actionSeqPS = connection.prepareStatement(builderActionSeq.toString());
		PreparedStatement psMedAdmin = connection.prepareStatement(builderSql.toString());
		ResultSet rsMedAdmin =null;
		int insertCnt=0;
		pstmt_select = connection.prepareStatement(builderOrderAction.toString() ) ;
		try{
				psMedAdmin.setString(1, facility_id);
				psMedAdmin.setString(2, encounter_id);
				psMedAdmin.setString(3, (String)iv_drugs.get(i+20));//sch_date_time
				psMedAdmin.setString(4, ord_drug_code);//drug code
				psMedAdmin.setString(5, (String)iv_drugs.get(i));//drug seq
				psMedAdmin.setString(6, (String)iv_drugs.get(i+3));//order_id
				rsMedAdmin = psMedAdmin.executeQuery();
				while(rsMedAdmin.next()){
					non_adm_remarks= rsMedAdmin.getString("NON_ADMIN_REMARKS");
					non_adm_code = rsMedAdmin.getString("NON_ADMIN_CODE");
					
				}
				if((null!=non_adm_remarks && null!=non_adm_code && "Y".equals((String)iv_drugs.get(i+18)) && "Y".equals((String)iv_drugs.get(i+17)) ) || ("Y".equals((String)iv_drugs.get(i+18)) && "N".equals((String)iv_drugs.get(i+17)))){
					actionSeqPS.setString(1,(String)iv_drugs.get(i+3));
					//actionSeqPS.setString(2,(String)iv_drugs.get(i+4));
					resultSet2 = actionSeqPS.executeQuery();
					
					while (resultSet2.next()) {
						action_seq_num = resultSet2.getInt(1);
					}
					pstmt_select.setString(1,(String)iv_drugs.get(i+3)); // order_id
					pstmt_select.setString(2,(String)iv_drugs.get(i+4)); // order_line
					pstmt_select.setInt(3,action_seq_num); 
					//pstmt_select.setString(4,added_by); // added by user id 
					if( iv_drugs.get(i+23)==null || ((String)iv_drugs.get(i+23)).equals("")){
						pstmt_select.setString(4,added_by);				//ADMIN_RECORDED_BY
					}
					else {
						pstmt_select.setString(4,(String)iv_drugs.get(i+23));	//ADMIN_RECORDED_BY		
					}
				
					pstmt_select.setString(5,facility_id); // facility
					pstmt_select.setString(6,"Medication_Admin"); // field mnemonic
					if(null!=non_adm_remarks && null!=non_adm_code && "Y".equals((String)iv_drugs.get(i+18)) && "Y".equals((String)iv_drugs.get(i+17)) ){
						pstmt_select.setString(7,"Could Not Administer"); // old text
					}
					else{
						pstmt_select.setString(7,""); //  old text
					}
					if("Y".equals((String)iv_drugs.get(i+18)) && "N".equals((String)iv_drugs.get(i+17))){
						pstmt_select.setString(8,"Could Not Administer"); // added by user id
					}
					else{
						pstmt_select.setString(8,"Administered"); // added by user id
					}
					if(null!=non_adm_remarks && null!=non_adm_code && "Y".equals((String)iv_drugs.get(i+18)) && "Y".equals((String)iv_drugs.get(i+17)) ){
						pstmt_select.setString(9,(String)iv_drugs.get(i+15)+"  Scheduled Date:"+(String)iv_drugs.get(i+20)); // ADMIN_REMARKS
					}
					else{
						pstmt_select.setString(9,(String)iv_drugs.get(i+16)+"  Scheduled Date:"+(String)iv_drugs.get(i+20)); // NON_ADMIN_REMARKS
					}
					
					insertCnt = pstmt_select.executeUpdate();
					
					if(insertCnt==0){
						pstmt_select.cancel();
						connection.rollback();
						System.err.println("Failed while updating OR_ORDER_ACTION");
						throw new EJBException("Updation Failed.........");
					}	
				}	
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new EJBException("Updation Failed.........");
		}
		finally{
			
		try {
		//close connection based on checkstyle - ICN63833  - start
			pstmt_select.close();
			closeStatement( actionSeqPS );
			closeStatement(psMedAdmin);
			closeResultSet( rsMedAdmin);
			closeResultSet(resultSet2);
	//close connection based on checkstyle - ICN63833  -end

			}
			catch(Exception es) { 
				es.printStackTrace();
			}
	
		}
		
	}
	
	private void insertAuditlogNonIV(Connection connection, ArrayList non_iv_drugs, String facility_id, String added_by, String encounter_id,int i) throws SQLException {
		PreparedStatement pstmt_select;
		StringBuilder builderOrderAction = new StringBuilder();
		StringBuilder builderActionSeq = new StringBuilder();
		StringBuilder builderSql = new StringBuilder();
		builderOrderAction.append("INSERT INTO OR_ORDER_ACTION (	ORDER_ID,ORDER_LINE_NUM,ACTION_SEQ_NUM,ACTION_USER_ID,ACTION_DATE_TIME,ACTION_FACILITY_ID,FIELD_MNEMONIC,FIELD_VALUE_OLD,FIELD_VALUE_NEW,FIELD_VALUE_TXT) VALUES (?,?,?,?,SYSDATE,?,?,?,?,?)");
		builderActionSeq.append("SELECT NVL(MAX(ACTION_SEQ_NUM),0)+1  FROM OR_ORDER_ACTION  WHERE ORDER_ID = ? and order_line_num=?");
		builderSql.append("SELECT NON_ADMIN_REMARKS , NON_ADMIN_CODE FROM PH_MEDN_ADMIN WHERE   FACILITY_ID=? AND ENCOUNTER_ID=? AND SCH_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI') AND ORD_DRUG_CODE=? AND DOSAGE_SEQ_NO=? and order_id=? ");
		pstmt_select	=	null;
		ResultSet resultSet2 = null;
		String non_adm_remarks = "";
		String non_adm_code = "";
		int action_seq_num=0;
		PreparedStatement actionSeqPS = connection.prepareStatement(builderActionSeq.toString());
		PreparedStatement psMedAdmin = connection.prepareStatement(builderSql.toString()); 
		ResultSet rsMedAdmin =null;
		int insertCnt=0;
		pstmt_select = connection.prepareStatement(builderOrderAction.toString() ) ;
		try{
			psMedAdmin.setString(1, facility_id);
			psMedAdmin.setString(2, encounter_id);
			psMedAdmin.setString(3, (String)non_iv_drugs.get(i+3));
			psMedAdmin.setString(4, (String)non_iv_drugs.get(i));
			psMedAdmin.setString(5, (String)non_iv_drugs.get(i+1));
			psMedAdmin.setString(6, (String)non_iv_drugs.get(i+14));
			rsMedAdmin = psMedAdmin.executeQuery();
			while(rsMedAdmin.next()){
				non_adm_remarks= rsMedAdmin.getString("NON_ADMIN_REMARKS")==null?"":rsMedAdmin.getString("NON_ADMIN_REMARKS");
				non_adm_code = rsMedAdmin.getString("NON_ADMIN_CODE")==null?"":rsMedAdmin.getString("NON_ADMIN_CODE");
			}
			if((!non_adm_remarks.equals("") && !non_adm_code.equals("") && "Y".equals((String)non_iv_drugs.get(i+5)) && "Y".equals((String)non_iv_drugs.get(i+4)) ) || ("Y".equals((String)non_iv_drugs.get(i+5)) && "N".equals((String)non_iv_drugs.get(i+4)))){
				actionSeqPS.setString(1,(String)non_iv_drugs.get(i+14));
				actionSeqPS.setString(2,(String)non_iv_drugs.get(i+15));
				resultSet2 = actionSeqPS.executeQuery();
				
				while (resultSet2.next()) {
					action_seq_num = resultSet2.getInt(1);
				}
				pstmt_select.setString(1,(String)non_iv_drugs.get(i+14)); // order_id
				pstmt_select.setString(2,(String)non_iv_drugs.get(i+15)); // order_line
				pstmt_select.setInt(3,action_seq_num); // order_line
				//pstmt_select.setString(4,added_by); // added by user id
				if( non_iv_drugs.get(i+17)==null || ((String)non_iv_drugs.get(i+17)).equals("")){
					pstmt_select.setString(4,added_by);				//ADMIN_RECORDED_BY
				}
				else {
					pstmt_select.setString(4,(String)non_iv_drugs.get(i+17));	//ADMIN_RECORDED_BY		
				}
			
				pstmt_select.setString(5,facility_id); // facilty
				pstmt_select.setString(6,"Medication_Admin"); // added by user id
				if(null!=non_adm_remarks && null!=non_adm_code && "Y".equals((String)non_iv_drugs.get(i+5)) && "Y".equals((String)non_iv_drugs.get(i+4)) ){
					pstmt_select.setString(7,"Could Not Administer"); // old text
				}
				else{
					pstmt_select.setString(7," "); 
				}
				if("Y".equals((String)non_iv_drugs.get(i+5)) && "N".equals((String)non_iv_drugs.get(i+4))){
					pstmt_select.setString(8,"Could Not Administer"); //old text
				}
				else{
					pstmt_select.setString(8,"Administered"); // added by user id
				}
				if(null!=non_adm_remarks && null!=non_adm_code && "Y".equals((String)non_iv_drugs.get(i+5)) && "Y".equals((String)non_iv_drugs.get(i+4)) ){
					pstmt_select.setString(9,(String)non_iv_drugs.get(i+6)+"Scheduled Date:"+(String)non_iv_drugs.get(i+3)); // ADMIN_REMARKS
				}
				else{
					pstmt_select.setString(9,(String)non_iv_drugs.get(i+7)+"Scheduled Date:"+(String)non_iv_drugs.get(i+3)); // NON_ADMIN_REMARKS
				}
				 insertCnt=pstmt_select.executeUpdate();
				 if(insertCnt==0){
					 pstmt_select.cancel();
					 connection.rollback();
					 System.err.println("Failed while updating OR_ORDER_ACTION==non_iv_drugs==>"+non_iv_drugs);
					 throw new EJBException("Updation Failed.........");
				 }
			}	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			
			try{
			pstmt_select.close();
			//close connection based on checkstyle - ICN63833  - start
			closeStatement( actionSeqPS );  
			closeStatement(psMedAdmin);
			closeResultSet( rsMedAdmin);
			closeResultSet(resultSet2);
//close connection based on checkstyle - ICN63833  -end
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
	}
	//added for AAKH-CRF-0024 [IN:038260] Ends

//  modify method starts here
/**
* @ejb.interface-method
*	 view-type="both"
*/
	public HashMap modify( HashMap tabData, HashMap sqlMap )  {

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;	
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
	public Hashtable getDrugProperties(String drug_code) throws Exception{
		
		Hashtable drug_properties = new Hashtable();
		Connection connection	  = null ;
        PreparedStatement pstmt   = null ;
        ResultSet resultSet       = null;
        try {
			connection = getConnection(prop) ;
		    pstmt = connection.prepareStatement( SQL_PH_MED_ADMIN_FT_SELECT9 ) ;
			pstmt.setString(1,drug_code.trim());				
			resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				drug_properties.put("GENERIC_ID",resultSet.getString("GENERIC_ID"));
				drug_properties.put("ROUTE_CODE",resultSet.getString("ROUTE_CODE"));
				drug_properties.put("FORM_CODE",resultSet.getString("FORM_CODE"));
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
            catch(Exception es) { es.printStackTrace();}
        }		
		return drug_properties;
	}


	 // Header table insert method
/**
* @ejb.interface-method
*	 view-type="both"
*/	
	private HashMap insertHeader(Connection connection, HashMap sqlMap, HashMap commonValues,ArrayList dispTMP ) throws Exception {
		PreparedStatement pstmt_insert_disp_hrd	= null;
		ArrayList unique_key	= new ArrayList();
		String sequence_no		=	"";

		HashMap seq_no			=	new HashMap();
		HashMap common			=	new HashMap();
		
		common					=(HashMap)commonValues.get("COMMON_VALUES");
		String facility_id		=(String)commonValues.get("facility_id");
		String added_by			=(String)common.get("added_by");
		// String admin_by			=(String)common.get("admin_by"); //Commented for Check Style Report.
		String ws_no			=(String)common.get("ws_no");

		try {
			//	pstmt_insert_disp_hrd = connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_HRD_INSERT") ) ;
			pstmt_insert_disp_hrd = connection.prepareStatement("INSERT INTO PH_DISP_HDR ( FACILITY_ID, DISP_NO, DISP_DATE_TIME, DISP_LOCN_CODE, ORDER_ID, ORD_DATE_TIME, PATIENT_ID, ENCOUNTER_ID, PATIENT_CLASS, LOCN_TYPE, LOCN_CODE, ROOM_TYPE, ROOM_NO, BED_NO, BED_CLASS, BED_TYPE, SPECIALITY_CODE, ATTEND_PRACTITIONER_ID, PRES_PHYSICIAN_ID, DISPENSED_BY, DISPENSED_DATE_TIME, AUTHORIZED_BY, DISP_AUTHORIZED_DATE_TIME, DELIVERED_YN, DELIVERED_BY, DELIVERED_DATE_TIME, COLLECTED_BY, RECEIVED_YN, RECEIVED_BY, RECEIVED_DATE_TIME, REF_DISP_NO_FOR_REISSUE, DISP_REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID ,RECEIVED_AT, COUNTER_CHKD_BY,DISP_TYPE)  VALUES ( ?,?,TRUNC(SYSDATE), ?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI'), ?,?,?, ?,?,?, ?,?,?, ?,?,?, ?,?,SYSDATE, ?,TO_DATE(?,'DD/MM/YYYY HH24:MI'),?,?, TO_DATE(?,'DD/MM/YYYY HH24:MI'),?,?, ?,TO_DATE(?,'DD/MM/YYYY HH24:MI'), ?,?,?, SYSDATE,?,?, ?,SYSDATE,?, ?,?,?,'M' )");

			String patient_class="";
			for(int i=0;i<dispTMP.size();i+=12){ //9 to 12 for [IN:040149]
				int count = 1;
				if(!unique_key.contains(((String)dispTMP.get(i)).trim())) {
					unique_key.add(((String)dispTMP.get(i)).trim());
					sequence_no = getSequenceNo((String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT33"));
					seq_no.put(((String)dispTMP.get(i)).trim(),sequence_no);
				
					pstmt_insert_disp_hrd.setString(count,facility_id);
					pstmt_insert_disp_hrd.setString(++count,sequence_no);
					pstmt_insert_disp_hrd.setString(++count,((String)dispTMP.get(i+6)).trim()); // disp locn  modified by kri dispTMP.get(i+3) 
					patient_class=(String)commonValues.get("patient_class");
					if(patient_class.equals("I") || patient_class.equals("D"))
						patient_class="IP";
					else
						patient_class="OP";
					pstmt_insert_disp_hrd.setString(++count,((String)dispTMP.get(i)).trim());   // order id
					pstmt_insert_disp_hrd.setString(++count,(String)commonValues.get("ord_date_time")); //ord date time
					pstmt_insert_disp_hrd.setString(++count,(String)commonValues.get("patient_id"));
					pstmt_insert_disp_hrd.setString(++count,(String)commonValues.get("encounter_id"));
					pstmt_insert_disp_hrd.setString(++count,patient_class); // patient class
					pstmt_insert_disp_hrd.setString(++count,(String)commonValues.get("source_type"));  // source type
					pstmt_insert_disp_hrd.setString(++count,(String)common.get("nursing_unit"));
					pstmt_insert_disp_hrd.setString(++count,"");
					pstmt_insert_disp_hrd.setString(++count,"");
					pstmt_insert_disp_hrd.setString(++count,"");
					pstmt_insert_disp_hrd.setString(++count,"");
					pstmt_insert_disp_hrd.setString(++count,"");
					pstmt_insert_disp_hrd.setString(++count,"");
					pstmt_insert_disp_hrd.setString(++count,((String)dispTMP.get(i+9)).trim()); //value changed for [IN:040149]
					pstmt_insert_disp_hrd.setString(++count,((String)dispTMP.get(i+8)).trim()); //value changed for [IN:040149]
					pstmt_insert_disp_hrd.setString(++count,added_by); 
					pstmt_insert_disp_hrd.setString(++count,((String)dispTMP.get(i+10)).trim()); //value changed for [IN:040149]
					pstmt_insert_disp_hrd.setString(++count,"");
					pstmt_insert_disp_hrd.setString(++count,"Y");
					pstmt_insert_disp_hrd.setString(++count,added_by); 
					pstmt_insert_disp_hrd.setString(++count,"");
					pstmt_insert_disp_hrd.setString(++count,"");
					pstmt_insert_disp_hrd.setString(++count,"Y");
					pstmt_insert_disp_hrd.setString(++count,"");
					pstmt_insert_disp_hrd.setString(++count,"");
					pstmt_insert_disp_hrd.setString(++count,"Y");
					pstmt_insert_disp_hrd.setString(++count,"");
					pstmt_insert_disp_hrd.setString(++count,added_by);
					pstmt_insert_disp_hrd.setString(++count,ws_no);
					pstmt_insert_disp_hrd.setString(++count,facility_id);
					pstmt_insert_disp_hrd.setString(++count,added_by);
					pstmt_insert_disp_hrd.setString(++count,ws_no);
					pstmt_insert_disp_hrd.setString(++count,facility_id);
					pstmt_insert_disp_hrd.setString(++count,"P"); //RECEIVED_AT 
					pstmt_insert_disp_hrd.setString(++count,"");  //COUNTER_CHKD_BY 
					pstmt_insert_disp_hrd.addBatch();
				}
			}
			int[] result4	=pstmt_insert_disp_hrd.executeBatch();
			for (int i=0;i<result4.length ;i++ ){
				if(result4[i]<0  && result4[i] != -2 ){
					pstmt_insert_disp_hrd.cancel();
					connection.rollback();
					throw new EJBException("1332 Hdr main insert Failed");
				}		
			}
		}
		catch(Exception e){
			e.printStackTrace();
			try {
				seq_no.put( "result", new Boolean( false) ) ;
				seq_no.put("msgid","Exception in EJB : " + e.getMessage());			
				connection.rollback();
				return seq_no;
				//throw new EJBException(" 1341 Hdr main insert Failed");
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
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
		PreparedStatement pstmt_insert_disp_dtl	= null;
		PreparedStatement pstmt_ph_drug_select	= null;
		ResultSet rs_ph_drug	=null;
		int count				=	1;
		int jj					=	1;
		int tmp_no				=	1;
		String prev_order_id	=	"";
		String item_code		=	"";
		HashMap common			=	new HashMap();
	
		common					=(HashMap)tabData.get("COMMON_VALUES");
		String facility_id		=(String)tabData.get("facility_id");
		String added_by			=(String)common.get("added_by");
		String ws_no			=(String)common.get("ws_no");
		String label_cau_instrn1_eng="";
		String label_spl_instrn1_eng="";
		String label_pat_instrn1_eng="";
		String p_overridden_excl_incl_ind = "";
		String p_overridden_action_reason = "";
		try {
			pstmt_insert_disp_dtl = connection.prepareStatement((String)sqlMap.get("SQL_PH_DISP_MEDICATION_DISP_DTL_INSERT")) ;
			
			for(int i=0;i<dispTMP.size();i+=12){ //9 to 12 for [IN:040149]
				ArrayList batchDetails	= (ArrayList)dispTMP.get(i+7);
				item_code				= (String)batchDetails.get(0);
				count					= 1;

				if(!prev_order_id.equals(((String)dispTMP.get(i)).trim()))
				jj	=	1;
				prev_order_id		=	((String)dispTMP.get(i)).trim();
				tmp_no			=	(jj++);
				pstmt_ph_drug_select=connection.prepareStatement((String)sqlMap.get("SQL_PH_MED_ADMIN_LABEL_CAU_SELECT33")) ;
				pstmt_ph_drug_select.setString(1,(String)dispTMP.get(i+3));
				rs_ph_drug=pstmt_ph_drug_select.executeQuery();
				while(rs_ph_drug.next()){
					label_cau_instrn1_eng=rs_ph_drug.getString("CAUTION_LABEL_TEXT_ID_1")==null ? "":rs_ph_drug.getString("CAUTION_LABEL_TEXT_ID_1");
					label_spl_instrn1_eng=rs_ph_drug.getString("SPL_INSTR_LABEL_TEXT_ID")==null ? "":rs_ph_drug.getString("SPL_INSTR_LABEL_TEXT_ID");
					label_pat_instrn1_eng=rs_ph_drug.getString("HOW_TO_TAKE_TEXT")==null ? "":rs_ph_drug.getString("HOW_TO_TAKE_TEXT");
				}
				closeStatement( pstmt_ph_drug_select ) ;
				closeResultSet( rs_ph_drug ) ;
				pstmt_insert_disp_dtl.setString(count,facility_id);					
				pstmt_insert_disp_dtl.setString(++count,(String)seq_no.get(((String)dispTMP.get(i)).trim()));						//DISP_NO
				pstmt_insert_disp_dtl.setString(++count,(tmp_no)+"");						//SRL_NO
				pstmt_insert_disp_dtl.setString(++count,((String)dispTMP.get(i)).trim());	//ORDER_ID
				pstmt_insert_disp_dtl.setString(++count,((String)dispTMP.get(i+1)).trim());	//ORDER_LINE_NO
				pstmt_insert_disp_dtl.setString(++count,((String)dispTMP.get(i+2)).trim());	//PRES_DRUG_CODE
				pstmt_insert_disp_dtl.setString(++count,(String)tabData.get("facility_id"));//ORDERING_FACILITY_ID
				pstmt_insert_disp_dtl.setString(++count,((String)dispTMP.get(i+6)).trim());	//DISP_LOCN_CODE  i+3
				pstmt_insert_disp_dtl.setString(++count,((String)dispTMP.get(i+6)).trim());	//STORE_CODE    i+3
				pstmt_insert_disp_dtl.setString(++count,((String)dispTMP.get(i+3)).trim());	//DISP_DRUG_CODE i+4
				pstmt_insert_disp_dtl.setString(++count,item_code);								//ITEM_CODE
				pstmt_insert_disp_dtl.setString(++count,"");								//STK_UOM_CODE
				pstmt_insert_disp_dtl.setString(++count,((String)dispTMP.get(i+4)).trim());	//DISP_QTY  i+5
				pstmt_insert_disp_dtl.setString(++count,((String)dispTMP.get(i+5)).trim());	//DISP_UOM_CODE i+6
				pstmt_insert_disp_dtl.setString(++count,"0");								//RETURNED_QTY
				pstmt_insert_disp_dtl.setString(++count,"");								//REISSUE_REASON_CODE
				pstmt_insert_disp_dtl.setString(++count,added_by);				
				pstmt_insert_disp_dtl.setString(++count,ws_no);				
				pstmt_insert_disp_dtl.setString(++count,facility_id);				
				pstmt_insert_disp_dtl.setString(++count,added_by);
				pstmt_insert_disp_dtl.setString(++count,ws_no);
				pstmt_insert_disp_dtl.setString(++count,facility_id);

				if(!stock_srl.containsKey(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+4)).trim()) ) {
					stock_srl.put(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+4)).trim(),tmp_no+"");
				}

				pstmt_insert_disp_dtl.setString(++count,""); // fill code
				pstmt_insert_disp_dtl.setString(++count,""); //fillremarks
				pstmt_insert_disp_dtl.setString(++count,label_cau_instrn1_eng);  //LABEL_CAU_INSTRN1_ENG
				pstmt_insert_disp_dtl.setString(++count,"");
				pstmt_insert_disp_dtl.setString(++count,label_spl_instrn1_eng);  //LABEL_SPL_INSTRN1_ENG
				pstmt_insert_disp_dtl.setString(++count,"");
				pstmt_insert_disp_dtl.setString(++count,label_pat_instrn1_eng);  //LABEL_PAT_INSTRN1_ENG
				pstmt_insert_disp_dtl.setString(++count,"");
				pstmt_insert_disp_dtl.setString(++count,"");
				pstmt_insert_disp_dtl.setString(++count,"");
				pstmt_insert_disp_dtl.setString(++count,"");
				pstmt_insert_disp_dtl.setString(++count,"");
				pstmt_insert_disp_dtl.setString(++count,"");
				pstmt_insert_disp_dtl.setString(++count,"");
				pstmt_insert_disp_dtl.setString(++count,"");
				pstmt_insert_disp_dtl.setString(++count,"");
				String p_overridden_det = getBlInclExclDetail(connection,(String)dispTMP.get(i),(String)dispTMP.get(i+1),sqlMap);
				if(p_overridden_det!=null && !p_overridden_det.equals("")){
					p_overridden_excl_incl_ind = p_overridden_det.substring(0,1);
					p_overridden_action_reason = p_overridden_det.substring(p_overridden_det.indexOf(":")+1);
				}
				pstmt_insert_disp_dtl.setString(++count,p_overridden_excl_incl_ind);
				pstmt_insert_disp_dtl.setString(++count,p_overridden_action_reason);
				pstmt_insert_disp_dtl.setString(++count,"");
				pstmt_insert_disp_dtl.addBatch();
			}
			int[] result3=pstmt_insert_disp_dtl.executeBatch();
			for (int i=0;i<result3.length ;i++ ){
				if(result3[i]<0  && result3[i] != -2 ){
					pstmt_insert_disp_dtl.cancel();
					connection.rollback();
					throw new EJBException("Dtl table insertion failed");
				}		
			}
		}
		catch(Exception e){
			e.printStackTrace();
			try{
				stock_srl.put( "result", new Boolean( false) ) ;
				stock_srl.put("msgid","Exception in EJB : " + e.getMessage());			
				connection.rollback();
				return stock_srl;
			
				
			}
			catch(Exception es) { es.printStackTrace();}
		}
		finally{	
			try {
				closeStatement( pstmt_insert_disp_dtl ) ;
				closeStatement( pstmt_ph_drug_select ) ;
				closeResultSet( rs_ph_drug ) ;
				
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}

		return stock_srl;
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
			catch(Exception es) { es.printStackTrace();}
		}
		return result;
	}	

// Insert Batch Table --- Main
	private HashMap insertBatch(Connection connection, HashMap sqlMap, HashMap tabData,ArrayList dispAlloc, HashMap seq_no) throws Exception{
		HashMap batch=new HashMap();
		PreparedStatement pstmt_insert_disp_drug_batch	= null;
		int count				=	1;
		int jj					=	1;
		String drug_code		= "";
		String batch_id			= "";
		String expiry_date		= "";
		String disp_qty			= "";
		String bin_locn_code	= "";
		String trade_id			= "";
		String prev_order_id	= "", disp_qty_uom="";
		HashMap common			=	new HashMap();
		common					=(HashMap)tabData.get("COMMON_VALUES");
		String facility_id		=(String)tabData.get("facility_id");
		String added_by			=(String)common.get("added_by");
		String ws_no			=(String)common.get("ws_no");
		ArrayList batchDetails =null;
		try {
			pstmt_insert_disp_drug_batch	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_DRUG_BATCH_INSERT") ) ;
			for(int i=0;i<dispAlloc.size();i+=12){
				batchDetails = (ArrayList)dispAlloc.get(i+7);
				if(!prev_order_id.equals(((String)dispAlloc.get(i)).trim()))
				jj	=	1;
				prev_order_id		=	((String)dispAlloc.get(i)).trim();
				int kk = 1;
				for (int j=0;j<batchDetails.size() ; j=j+10){ //Modified from 9 to 10 for HSA-CRF-0090 //j+8
					count=1;
					drug_code	 = (String)batchDetails.get(j);
					batch_id	 = (String)batchDetails.get(j+1);
					expiry_date	 = (String)batchDetails.get(j+2);
					disp_qty	 = (String)batchDetails.get(j+3);
					disp_qty_uom = (String)batchDetails.get(j+4);
					trade_id	 = (String)batchDetails.get(j+6);//
					
					bin_locn_code= (String)batchDetails.get(j+7);//6
					
					pstmt_insert_disp_drug_batch.setString(count,(String)tabData.get("facility_id"));
					pstmt_insert_disp_drug_batch.setString(++count,(String)seq_no.get(((String)dispAlloc.get(i)).trim()));
					pstmt_insert_disp_drug_batch.setString(++count,(jj)+"");
					pstmt_insert_disp_drug_batch.setString(++count,(kk++)+"");
					pstmt_insert_disp_drug_batch.setString(++count,((String)dispAlloc.get(i+6)).trim());//i+3
					pstmt_insert_disp_drug_batch.setString(++count,((String)dispAlloc.get(i+6)).trim());//i+3
					pstmt_insert_disp_drug_batch.setString(++count,drug_code.trim());
					pstmt_insert_disp_drug_batch.setString(++count,drug_code.trim());
					pstmt_insert_disp_drug_batch.setString(++count,batch_id.trim());
					pstmt_insert_disp_drug_batch.setString(++count,expiry_date.trim());
					pstmt_insert_disp_drug_batch.setString(++count,disp_qty.trim());
					pstmt_insert_disp_drug_batch.setString(++count,"0");
					pstmt_insert_disp_drug_batch.setString(++count,added_by);
					pstmt_insert_disp_drug_batch.setString(++count,ws_no);
					pstmt_insert_disp_drug_batch.setString(++count,facility_id);
					pstmt_insert_disp_drug_batch.setString(++count,added_by);
					pstmt_insert_disp_drug_batch.setString(++count,ws_no);
					pstmt_insert_disp_drug_batch.setString(++count,facility_id);	
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
					throw new EJBException("Batch Details Failed");
				}		
			}  
		}
		catch(Exception e){
			e.printStackTrace();
			try {
				batch.put( "result", new Boolean( false) ) ;
				batch.put("msgid","Exception in EJB : " + e.getMessage());			
				connection.rollback();
				return batch;
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
		finally{	
			try {
				closeStatement( pstmt_insert_disp_drug_batch) ;
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
		return batch;
	}

	public void callStockUpdate(Connection connection,HashMap tabData,HashMap sqlMap,ArrayList dispTMP,HashMap prev_doc_no,String st_doc_type,HashMap stock_srl) throws Exception{
		
		try {
			String item_code	=	"";
			String item_cost	=	"";
			String cost_value	=	"";
			String batch_id		=	"";
			String expiry_date	=	"";
			String bin_locn_code =	"";
			String trade_id		=	"";
			String disp_qty		=	"";
			String order_id		=	"";
			String docno		=	"";
			String order_id1	=	"";
			String shared_drug	=	"";//Added for HSA-CRF-0090
			String p_overridden_excl_incl_ind = "";
			String p_overridden_action_reason = "";

			//Connection connection = null ;
			ArrayList orders	=	new ArrayList();
			HashMap stock_dtls	=	new HashMap();
			ArrayList insertDetail	=	new ArrayList();
			ArrayList insertExp		=	new ArrayList();
			ArrayList updateDetail	=	new ArrayList();
			ArrayList updateExp		=	new ArrayList();
			//connection = getConnection(prop) ;
			String dis_loc="";
			HashMap BaseAndIssueUOMQty			= new HashMap();
			int noOfDecimals= getNumberOfDecimals(connection);
			for(int i=0;i<dispTMP.size();i+=12){  //7 //9 to 12 for [IN:040149]

				if(orders.size()!=0 && (!orders.contains(((String)dispTMP.get(i)).trim()))) {
					stock_dtls.put("insertDetail",insertDetail);
					stock_dtls.put("updateDetail",updateDetail);
					stock_dtls.put("insertExp",insertExp);
					stock_dtls.put("updateExp",updateExp);
					dis_loc=(String)dispTMP.get(6);

					updateStock(connection,tabData,sqlMap,stock_dtls,order_id,docno,st_doc_type,dis_loc);
					
					stock_dtls		=	new HashMap();
					insertDetail	=	new ArrayList();
					insertExp		=	new ArrayList();
					updateDetail	=	new ArrayList();
					updateExp		=	new ArrayList();
					orders			=	new ArrayList();
					order_id		=	"";
					docno			=	"";
				}
				dis_loc=(String)dispTMP.get(6);
				order_id1=((String)dispTMP.get(i)).trim();
				order_id1=getStoreLocnCode(connection, order_id1);
				if(order_id1==null) 
					order_id1="";
				tabData.remove("disp_locn_code");
				tabData.put("disp_locn_code",order_id1);
				ArrayList batchDetails = (ArrayList)dispTMP.get(i+7);  //6

				item_code				=	(String)batchDetails.get(0);
				item_cost				=	(String)batchDetails.get(8);
				shared_drug				= (String)batchDetails.get(9);//Added for HSA-CRF-0090
				if(shared_drug==null || shared_drug.equals(""))//Added for HSA-CRF-0090
					shared_drug="N";//Added for HSA-CRF-0090
				if(item_cost.equals(""))
					item_cost	=	"0";

				//cost_value	=(Integer.parseInt((String)dispTMP.get(i+4)) * Math.abs(Float.parseFloat(item_cost)))+"";
				/*cost_value	=	Math.round(Integer.parseInt((String)dispTMP.get(i+4)) * Double.parseDouble(item_cost)*1000)+"";
				cost_value	= (Double.parseDouble(cost_value)/1000)+"";*/

				// Item Detail
				HashMap hmDetail	=	new HashMap();
				
				if(!shared_drug.equals("Y")){//Added for HSA-CRF-0090
					hmDetail.put("doc_srl_no",(String)stock_srl.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+4)).trim())); //i+1
					hmDetail.put("item_code",item_code);
					hmDetail.put("sal_category","");
					hmDetail.put("hcp_issue_factor","");
					//hmDetail.put("item_qty",((String)dispTMP.get(i+4)).trim());
				
					BaseAndIssueUOMQty	=	(HashMap)getBaseAndIssueUOMQty( connection,  item_code,  (String)dispTMP.get(6), ((String)dispTMP.get(i+4)).trim(),  ((String)dispTMP.get(i+5)).trim(),noOfDecimals);
					hmDetail.put("item_qty",(String)BaseAndIssueUOMQty.get("ISSUE_QTY"));
					hmDetail.put("mm_trn_qty",(String)BaseAndIssueUOMQty.get("BASE_QTY"));
					cost_value	=	Math.round(Double.parseDouble((String)BaseAndIssueUOMQty.get("ISSUE_QTY")) * Double.parseDouble(item_cost)*1000)+"";
					cost_value	=   (Double.parseDouble(cost_value)/1000)+"";

					hmDetail.put("next_due_date","");
					hmDetail.put("stock_item_yn","Y");
					hmDetail.put("remarks","");
					hmDetail.put("item_unit_cost",item_cost);
					hmDetail.put("item_sal_value",item_cost); //Changed from cost_value to item_cost for MMS-SCF-0275 [IN:047212]
					hmDetail.put("item_cost_value",item_cost); //Changed from cost_value to item_cost for MMS-SCF-0275 [IN:047212]
					hmDetail.put("item_unit_price",item_cost);
					hmDetail.put("uom_code",((String)dispTMP.get(i+5)).trim());
					hmDetail.put("mode",(String)tabData.get("mode"));
					String p_overridden_det = getBlInclExclDetail(connection,(String)dispTMP.get(i),(String)dispTMP.get(i+1),sqlMap);
					if(p_overridden_det!=null && !p_overridden_det.equals("")){
						p_overridden_excl_incl_ind = p_overridden_det.substring(0,1);
						p_overridden_action_reason = p_overridden_det.substring(p_overridden_det.indexOf(":")+1);
					}
					hmDetail.put("p_overridden_excl_incl_ind",p_overridden_excl_incl_ind);
					hmDetail.put("p_overridden_action_reason",p_overridden_action_reason);
					insertDetail.add(hmDetail);
				}//Added for HSA-CRF-0090
					
				HashMap hmExp	=	null;
					// Batch Details
				for (int j=0;j<batchDetails.size() ; j=j+10){//Modified from 9 t0 10 for HSA-CRF-0090
					batch_id		= (String)batchDetails.get(j+1);
					expiry_date		= (String)batchDetails.get(j+2);
					disp_qty		= (String)batchDetails.get(j+3);
					trade_id		= (String)batchDetails.get(j+6);
					bin_locn_code	= (String)batchDetails.get(j+7);
					hmExp	=	new HashMap();
					if(!shared_drug.equals("Y")){//Added for HSA-CRF-0090
						hmExp.put("doc_srl_no",(String)stock_srl.get(((String)dispTMP.get(i)).trim()+((String)dispTMP.get(i+4)).trim()));
					
					//	hmExp.put("store_code",(String)tabData.get("disp_locn_code_MAR"));
					//	if(((String)tabData.get("disp_locn_code_MAR")).equals(""))
					//	hmExp.put("store_code",(String)tabData.get("disp_locn_code"));
						hmExp.put("store_code",(String)dispTMP.get(6));
					
						hmExp.put("item_code",item_code);
						hmExp.put("batch_id",batch_id);
						hmExp.put("bin_location_code",bin_locn_code);
						hmExp.put("expiry_date_or_receipt_date",expiry_date);
						hmExp.put("trade_id",trade_id);
						BaseAndIssueUOMQty	=	(HashMap)getBaseAndIssueUOMQty( connection,  item_code,  (String)dispTMP.get(6), disp_qty,  ((String)dispTMP.get(i+5)).trim(),noOfDecimals);
						hmExp.put("sal_item_qty",(String)BaseAndIssueUOMQty.get("BASE_QTY"));
						//hmExp.put("sal_item_qty",disp_qty);
						hmExp.put("ret_item_qty","");
						insertExp.add(hmExp);
					}
				}//Added for HSA-CRF-0090
				if(!orders.contains(((String)dispTMP.get(i)).trim())){
					orders.add(((String)dispTMP.get(i)).trim());
					order_id	=	(String)orders.get(0);

					if(prev_doc_no.containsKey(order_id))
						docno		=	(String)prev_doc_no.get(order_id);
				}
			}
			stock_dtls.put("insertDetail",insertDetail);
			stock_dtls.put("updateDetail",updateDetail);
			stock_dtls.put("insertExp",insertExp);
			stock_dtls.put("updateExp",updateExp);
			updateStock(connection,tabData,sqlMap,stock_dtls,order_id,docno,st_doc_type,dis_loc);
		} 
		catch(Exception e) {
			e.printStackTrace();
			System.err.println("error while updating stock callStockUpdate tabData="+tabData+" dispTMP="+dispTMP+" prev_doc_no="+prev_doc_no+" st_doc_type="+st_doc_type+" stock_srl="+stock_srl);
			throw e;
		}
	}

	public void updateStock(Connection connection,HashMap tabData, HashMap sqlMap, HashMap stock_dtls,String order_id, String prev_doc_no,String  st_doc_type,String doc_loc) throws Exception{

		HashMap hmHeader	=	new HashMap();
		HashMap hmCommon	=	new HashMap();
		HashMap hmData		=	new HashMap();
		String order_id1	=	"";
		ArrayList insertDetail	=	(ArrayList)stock_dtls.get("insertDetail");

		ArrayList insertExp		=	(ArrayList)stock_dtls.get("insertExp");
		ArrayList language_data =  new ArrayList();
		String language_id  = (String)tabData.get("language_id");
		String encounter_id		=	"";
		if(tabData.get("encounter_id")==null || ((String)tabData.get("encounter_id")).equals("") || ((String)tabData.get("encounter_id")).equals("null")) {
			encounter_id	=	"11111";
		}
		else {
			encounter_id	=	(String)tabData.get("encounter_id");
		}
		if(!order_id.equals("") && order_id!=null){
			order_id1=getStoreLocnCode(connection, order_id);
			if(order_id1==null) 
				order_id1="";
			tabData.remove("disp_locn_code");
			tabData.put("disp_locn_code",order_id1);
		}
		
		PreparedStatement pstmt_update_disp_hdr_tmp	=	null;
		hmHeader.put("facility_id",(String)tabData.get("facility_id"));
		hmHeader.put("doc_type_code",st_doc_type);
		hmHeader.put("doc_no","");
		hmHeader.put("doc_date",(String)tabData.get("today"));
		hmHeader.put("doc_ref","");
		//hmHeader.put("store_code",(String)tabData.get("disp_locn_code_MAR"));
		//	if(((String)tabData.get("disp_locn_code_MAR")).equals(""))
			//	hmHeader.put("store_code",(String)tabData.get("disp_locn_code"));

		hmHeader.put("store_code",doc_loc);
		hmHeader.put("cancelled_by_id","");
		hmHeader.put("cancelled_remarks","");

		if( ((String)tabData.get("disp_stage")).equals("D"))
			hmHeader.put("finalized_yn","Y");
		else
			hmHeader.put("finalized_yn","N");

		hmHeader.put("gl_interfaced_yn","N");
		
		hmHeader.put("take_home_yn","N");
		hmHeader.put("trn_type","SAL");
		hmHeader.put("add_qty_sal_yn","N");
		hmHeader.put("patient_id",(String)tabData.get("patient_id"));
		hmHeader.put("encounter_id",encounter_id);
		
		hmHeader.put("remarks","");
		hmHeader.put("item_class_code","");
		hmHeader.put("module_id","PH");

		//	hmHeader.put("authorized_by_id","");
		//hmHeader.put("sal_trn_type",(String)tabData.get("patient_class"));
		//	hmHeader.put("billable_trn_yn","N");
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
		if(bl_interface_yn.equals("Y"))	{
			hmHeader.put("authorized_by_id",(String)tabData.get("login_by_id"));

		    if(bl_interface_yn.equals("Y"))	{
				PreparedStatement pstmtPC	= null;
				ResultSet resultSetPC		= null;
				String      patient_class_PC		= "";
				try {
					pstmtPC		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_BL_SELECT1") ) ;
					pstmtPC.setString(1,(String)tabData.get("facility_id"));
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
			}
		}
		else{
			hmHeader.put("authorized_by_id","");
			hmHeader.put("sal_trn_type",(String)tabData.get("patient_class"));
		}

		hmCommon.put("login_by_id",(String)tabData.get("login_by_id"));
		hmCommon.put("login_at_ws_no",(String)tabData.get("login_at_ws_no"));
		hmCommon.put("login_facility_id",(String)tabData.get("facility_id"));
		language_data.add(language_id);

		hmData.put("HDR_DATA",hmHeader);
		hmData.put("COMMON_DATA",hmCommon);
		hmData.put("LANGUAGE_DATA",language_data);
		HashMap map		=null;
		try{
	
			if(insertDetail.size()!=0)	{
				hmData.put("DTL_DATA",insertDetail);
				hmData.put("DTL_EXP_DATA",insertExp);
				eST.Common.StSales	stSales		=	new eST.Common.StSales();
				map	=	stSales.insertSales(connection,hmData);

				if( !(((Boolean) map.get( "result" )).booleanValue()) ){
					connection.rollback();
					
					throw new EJBException("insert Sales failed");
				} 
				else{ // open commented start
					String docno				=	(String)map.get("doc_no");
					String doctypecode			=	(String)map.get("doc_type_code");
					pstmt_update_disp_hdr_tmp		=	null;
					pstmt_update_disp_hdr_tmp		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_HRD_TMP_UPDATE") ) ;

					pstmt_update_disp_hdr_tmp.setString(1,doctypecode );
					pstmt_update_disp_hdr_tmp.setString(2,docno);  
					pstmt_update_disp_hdr_tmp.setString(3,order_id);
					pstmt_update_disp_hdr_tmp.setString(4,(String)tabData.get("facility_id"));
					pstmt_update_disp_hdr_tmp.executeUpdate();

					if(((HashMap)tabData.get("seq_no")).containsKey(order_id)){
						pstmt_update_disp_hdr_tmp		=	null;
						pstmt_update_disp_hdr_tmp		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_HRD_UPDATE") ) ;
						pstmt_update_disp_hdr_tmp.setString(1,doctypecode );
						pstmt_update_disp_hdr_tmp.setString(2,docno);  
						pstmt_update_disp_hdr_tmp.setString(3,(String)((HashMap)tabData.get("seq_no")).get(order_id));
						pstmt_update_disp_hdr_tmp.setString(4,(String)tabData.get("facility_id"));
						pstmt_update_disp_hdr_tmp.executeUpdate();
					}
				} //commented end
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new EJBException((String)map.get("msgid"));
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
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{	
			try {
				closeResultSet( resSet ) ;
				closeStatement( pstmt_st_doc_type ) ;
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return st_doc_type;
	}

	public String getDosageSeqNo(String order_id,String facility_id,String encounter_id, String sch_date_time, String ord_drug_code, String SQL_PH_MED_ADMIN_DOSAGE_SEQ_NO){
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		String dosage_seq_no	= "";
		try{
			connection = getConnection(prop) ;
			pstmt			= connection.prepareStatement(SQL_PH_MED_ADMIN_DOSAGE_SEQ_NO) ;
			pstmt.setString(1,facility_id);
			pstmt.setString(2,encounter_id);
			pstmt.setString(3,order_id);
			pstmt.setString(4,sch_date_time);
			pstmt.setString(5,ord_drug_code);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				dosage_seq_no = resultSet.getString("DOSAGE_SEQ_NO");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ,prop);
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return dosage_seq_no;
	}

	public HashMap getMednAdminValues(String order_id,String facility_id,String encounter_id,String SQL_PH_MED_ADMIN_MEDN_ADMIN_VALUES){
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		HashMap medn_admin_values	= new HashMap();
		try{
			connection = getConnection(prop) ;
			pstmt			= connection.prepareStatement(SQL_PH_MED_ADMIN_MEDN_ADMIN_VALUES) ;
			
			pstmt.setString(1,facility_id);
			pstmt.setString(2,encounter_id);
			pstmt.setString(3,order_id);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				medn_admin_values.put("SCH_STRENGTH",resultSet.getString("SCH_STRENGTH"));
				medn_admin_values.put("SCH_STRENGTH_UOM",resultSet.getString("SCH_STRENGTH_UOM"));
				medn_admin_values.put("SCH_ROUTE_CODE",resultSet.getString("SCH_ROUTE_CODE"));
				medn_admin_values.put("SCH_INFUSION_PERIOD",resultSet.getString("SCH_INFUSION_PERIOD"));
				medn_admin_values.put("SCH_INFUSION_PERIOD_UNIT",resultSet.getString("SCH_INFUSION_PERIOD_UNIT"));
				medn_admin_values.put("IV_INGREDIANTS",resultSet.getString("IV_INGREDIANTS"));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		} 
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ,prop);
			}
			catch(Exception es){es.printStackTrace();}
		}
		return medn_admin_values;
	}
	
	public String getMednAdminFreqNature(String order_id,String order_line_num,String SQL_PH_MED_ADMIN_MEDN_ADMIN_FREQ_NATURE){
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		String result	= "";
		try{
			connection = getConnection(prop) ;
			pstmt			= connection.prepareStatement(SQL_PH_MED_ADMIN_MEDN_ADMIN_FREQ_NATURE) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_num);

			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				result = resultSet.getString("FREQ_NATURE");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ,prop);
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return result;
	}
	public String  getStoreLocnCode(Connection connection, String order_id ) throws Exception{
		if(order_id==null)order_id="";
		String result = "";
	//	Connection connection = null ;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

		try {
		//	connection = getConnection(prop) ;
			pstmt			= connection.prepareStatement(SQL_PH_ADMIN_OR_ORDER_SELECT) ;
			pstmt.setString(1,order_id.trim());
			resultSet = pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				result=resultSet.getString("PERFORMING_DEPTLOC_CODE");
				if(result==null)
					result="";
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
               // closeConnection( connection,prop );
            }
            catch(Exception es) { es.printStackTrace();}
        }
		return result;
	}

private void updateDrugProfile(Connection connection, HashMap sqlMap, HashMap tabData, ArrayList dispTMP) throws Exception {
	PreparedStatement pstmt_update		=	null;
	PreparedStatement pstmt_update_2	=	null;
	PreparedStatement pstmt_select		=	null;
	PreparedStatement pstmt_select_1	=   null;
	PreparedStatement pstmt_pres_qty	=   null;
	PreparedStatement pstmt_order_line_update	=   null;
	
	ResultSet	rset					=	null;
	String drug_desc					=	"";
	String pack_size					=	"";
	String pres_qty						=	"";
	String order_id						=	"";
	String order_line_num				=	"";
	String bms_qty						=	"";
	long disp_qty						=   0;
	HashMap common						=	new HashMap();
	common								=	(HashMap)tabData.get("COMMON_VALUES");
	String facility_id					=	(String)tabData.get("facility_id");
	String added_by						=	(String)common.get("added_by");
	String ws_no						=	(String)common.get("ws_no");
	String LanguageId					=	(String)tabData.get("language_id");

	ArrayList order_det					=	new ArrayList();
	StringBuffer disp_drugs				=	new StringBuffer();
	String status						=	"DP";
   try {
		pstmt_update	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_UPDATE12") ) ;
		pstmt_update_2	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_UPDATE13A") ) ;
		pstmt_select	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_PRESCRIPTION_SELECT45"));
		pstmt_select_1	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT137"));
		pstmt_pres_qty	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_MED_ADMIN_ORDER_QTY_SELECT32"));
		pstmt_order_line_update	= connection.prepareStatement( (String)sqlMap.get("SQL_PH_MED_ADMIN_OR_ORDER_LINE_STATUS_UPDATE"));
		for(int i=0;i<dispTMP.size();i+=12){	 //9 to 12 for [IN:040149]		
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
//==================drug profile updation starts=================

			pstmt_update.setString(1,(Integer.parseInt((String)dispTMP.get(i+4)) * Float.parseFloat(pack_size))+"" );	// dispensed qty
			pstmt_update.setString(2,disp_drugs.toString());	// dispensed drugs
			pstmt_update.setString(3,added_by);		// modified id
			pstmt_update.setString(4,ws_no);	// modified work station
			pstmt_update.setString(5,facility_id);		// modified facility
			pstmt_update.setString(6,(String)dispTMP.get(i));
			pstmt_update.setString(7,(String)dispTMP.get(i+1));
			pstmt_update.addBatch();

//==================ends here ===================================
//===========ORDER LINE PH UPDATE==================================
			order_id						=	(String)dispTMP.get(i);
			order_line_num					=   (String)dispTMP.get(i+1);
			pstmt_pres_qty.setString(1,order_id);
			pstmt_pres_qty.setString(2,order_line_num);
		    rset	=	pstmt_pres_qty.executeQuery();
			while(rset.next()){
				pres_qty=rset.getString("ORDER_QTY");
			}
			
			closeResultSet( rset );
			
			//pres_qty = order_quanties.get(order_id+order_line_num)+"";

			pstmt_select_1.setString(1,(String)dispTMP.get(i));
			pstmt_select_1.setString(2,(String)dispTMP.get(i+1));
			rset=pstmt_select_1.executeQuery();
			if(rset.next()) {
				bms_qty	=	rset.getString("bms_qty");
			}

			closeResultSet( rset );
			
			disp_qty		=	Long.parseLong(pres_qty)-Long.parseLong(bms_qty);
			pstmt_update_2.setString(1,(String)tabData.get("source_type"));	// disp locn type
			pstmt_update_2.setString(2,(String)dispTMP.get(i+6));	// dispense location
			pstmt_update_2.setString(3,(String)dispTMP.get(i+6));	// store code
			pstmt_update_2.setLong(4,disp_qty);	// dispensed qty
			pstmt_update_2.setString(5,bms_qty);	// BMS qty
			pstmt_update_2.setString(6,bms_qty);	// BMS Strength
			pstmt_update_2.setString(7,added_by);		// modified id
			pstmt_update_2.setString(8,ws_no);	// modified work station
			pstmt_update_2.setString(9,facility_id);		// modified facility			
			pstmt_update_2.setString(10,(String)dispTMP.get(i));
			pstmt_update_2.setString(11,(String)dispTMP.get(i+1));
			pstmt_update_2.addBatch();

			if(Long.parseLong(bms_qty)==0)
				status="DF";

			pstmt_order_line_update.setString(1,status);
			pstmt_order_line_update.setString(2,added_by);
			pstmt_order_line_update.setString(3,ws_no);
			pstmt_order_line_update.setString(4,facility_id);
			pstmt_order_line_update.setString(5,order_id);
			pstmt_order_line_update.setString(6,order_line_num);

			pstmt_order_line_update.executeUpdate();
		}
		int[] result3	=pstmt_update.executeBatch();
		for (int i=0;i<result3.length ;i++ ){
			if(result3[i]<0  && result3[i] != -2 ){
				pstmt_update.cancel();
				connection.rollback();
				throw new EJBException("PATIENT DRUG PROFILE UPDATE FAILED");
			}		
		}
		
			int[] result4	=pstmt_update_2.executeBatch();
			for (int i=0;i<result4.length ;i++ ){
				if(result4[i]<0  && result4[i] != -2 ){
					pstmt_update_2.cancel();
					connection.rollback();
					throw new EJBException("ORDER LINE PH UPDATE FAILED");
				}		
			}
			for(int i=0;i<dispTMP.size();i+=12){ //9 to 12 for [IN:040149]
				order_id						=	(String)dispTMP.get(i);
				order_line_num					=   (String)dispTMP.get(i+1);
				updateOrOrderNew(connection, sqlMap,tabData,order_id,order_line_num);	
			}
		}
		catch(Exception e){
			e.printStackTrace();
			connection.rollback();
			throw new EJBException("UPDATE DrugProfile FAILED");
		}
		finally{	
			try {
				closeStatement( pstmt_update ) ;
				closeStatement( pstmt_update_2 ) ;
				closeStatement( pstmt_select ) ;
				closeStatement( pstmt_select_1 );
				closeStatement( pstmt_pres_qty );
				closeStatement(pstmt_order_line_update);
				closeResultSet( rset );

				pstmt_update =null;
				pstmt_update_2  =null;
				pstmt_select  =null;
				rset  =null;
				pstmt_pres_qty=null;
				
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
            }
			catch(Exception es){
				es.printStackTrace();
			}
        }
		return bl_InclExclDetail;
	}

	private void updateOrOrderNew(Connection connection, HashMap sqlMap, HashMap tabData,String order_id,String order_line_num) throws Exception {
	
		PreparedStatement pstmt_update_order			= null;
		PreparedStatement pstmt_select					= null;
		ResultSet	rset								= null;
		PreparedStatement pstmt_update_order_line_ph	= null;
		ArrayList line_status		=	new ArrayList();	
		String least_status			=	"";
		HashMap common			=	new HashMap();

		try {
			
			pstmt_update_order  = connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_ORDER_UPDATE") ) ;
			pstmt_select		= connection.prepareStatement( (String)sqlMap.get("SQL_PH_DISP_MEDICATION_SELECT106") ) ; 

			//for(int i=0;i<orderLineData.size();i=i+6){
			
			line_status		=	new ArrayList();

			pstmt_select.setString(1,order_id);
			rset	=	pstmt_select.executeQuery();
			while(rset!=null && rset.next()) {
				line_status.add(rset.getString("ORDER_LINE_STATUS"));
			}
			
			least_status	= getUpdateString(line_status);

			common					=(HashMap)tabData.get("COMMON_VALUES");
			String facility_id		=(String)tabData.get("facility_id");
			String added_by			=(String)common.get("added_by");
			String ws_no			=(String)common.get("ws_no");
		
			pstmt_update_order.setString(1,least_status);
			pstmt_update_order.setString(2,added_by);		// modified id
			pstmt_update_order.setString(3,facility_id);		// modified facility
			pstmt_update_order.setString(4,ws_no);	// modified work station		  			
			pstmt_update_order.setString(5,order_id);
			pstmt_update_order.executeUpdate();
			String patient_class=(String)tabData.get("patient_class");
		
			if(patient_class.equals("I") || patient_class.equals("D"))
				pstmt_update_order_line_ph= connection.prepareStatement("update or_order_line_ph set NEXT_FILL_DATE=SYSDATE where  ORDER_ID=? and ORDER_LINE_NUM=?");
			else
				pstmt_update_order_line_ph= connection.prepareStatement("update or_order_line_ph set NEXT_COLLECTION_DATE=SYSDATE where  ORDER_ID=? and ORDER_LINE_NUM=?");
			pstmt_update_order_line_ph.setString(1,order_id);
			pstmt_update_order_line_ph.setString(2,order_line_num);
			pstmt_update_order_line_ph.executeUpdate();	
	}
	catch(Exception e){
		e.printStackTrace();
		throw new EJBException("Error: OR_ORDER UPDATE FAILED");
	}
	finally{	
		try {
			closeResultSet( rset );
			closeStatement( pstmt_update_order ) ;
			closeStatement( pstmt_select ) ;
			closeStatement(pstmt_update_order_line_ph);
			rset =null;
			pstmt_update_order =null;
			pstmt_select =null;
			common=null;	
		}
		catch(Exception es) { es.printStackTrace();}
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
	private HashMap getBaseAndIssueUOMQty(Connection connection, String item_code, String store_code,String disp_qty, String disp_uom,int noOfDecimals){
        PreparedStatement pstmt             = null ;
        PreparedStatement pstmt1            = null ;
        ResultSet resultSet                 = null ;
        ResultSet resultSet1                = null ;
		String base_uom						= "";
		String def_store_uom				= "";
		String decimalsAllowedYN			= "N";
		double  base_to_disp_uom_equl_value	= 0;
		double  base_to_def_uom_equl_value		= 0;
		HashMap BaseAndIssueQTYDetail		= new HashMap();
		double base_qty						= 0;
		double issue_qty					= 0;
		String str_base_qty					= "";
		String str_issue_qty				= "";
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
			pstmt1					= connection.prepareStatement("select ALLOW_DECIMALS_YN from st_item where item_code=?");
			pstmt1.setString(1,item_code);
			resultSet1				= pstmt1.executeQuery();
			if(resultSet1!=null && resultSet1.next()){
				decimalsAllowedYN=resultSet1.getString("ALLOW_DECIMALS_YN")==null?"N":resultSet1.getString("ALLOW_DECIMALS_YN");
			}			
			if(decimalsAllowedYN.equals("Y")){
				StringBuffer formatString=new StringBuffer("#.");
				for(int bu=0;bu<noOfDecimals;bu++){
					formatString.append("#");
				}
				DecimalFormat df = new DecimalFormat(formatString.toString());
				str_base_qty=df.format(base_qty);
				str_issue_qty=df.format(issue_qty);
			}
			else{
				str_base_qty=Math.ceil(base_qty)+"";
				str_issue_qty=Math.ceil(issue_qty)+"";
			}
			BaseAndIssueQTYDetail.put("BASE_QTY",str_base_qty);
			BaseAndIssueQTYDetail.put("ISSUE_QTY",str_issue_qty);
		}
		catch ( Exception e ) {
            e.printStackTrace() ;
		}
		finally {
            try{
				closeResultSet( resultSet ) ;
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt ) ;
				closeStatement( pstmt1 ) ;
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
			if(uom_code.equals(equl_uom_code)){
				eqvl_value			= 1;
			}
			else{					
				pstmt	= connection.prepareStatement( "select eqvl_value/eqvl_uom_qty EQVL_VALUE from MM_ITEM_UOM_DEFN where ITEM_CODE=? and UOM_CODE =? and EQVL_UOM_CODE=?") ;
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

	public int getNumberOfDecimals(Connection connection){
		PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		int numberOfDecimals	=0;
		String qry="select NO_OF_DECIMALS from st_acc_entity_param";
		try{
			pstmt=connection.prepareStatement(qry);
			resultSet=pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				numberOfDecimals=resultSet.getString("NO_OF_DECIMALS")==null?0:Integer.parseInt(resultSet.getString("NO_OF_DECIMALS"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
			try{
				closeStatement(pstmt);
				closeResultSet(resultSet);
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return numberOfDecimals;
	}
	public boolean isCurentRowAdministeredByOtherUser(Connection con,ArrayList non_iv_drugs,ArrayList iv_drugs,String facility_id,String encounter_id){
		String prev_modified_date="";
		String curr_modified_date="";
		String iv_prep_yn="";
		String ord_drug_code="";
		PreparedStatement pstmt=null;
		PreparedStatement pstmt3=null;
		ResultSet resultSet=null;
		ResultSet resultSet2=null;
		ResultSet resultSet3=null;
		boolean administrationDoneByOtherUser=false;
		boolean nonIVAdministrationDoneByOtherUser=false;
		boolean ivAdministrationDoneByOtherUser=false;
		String query="SELECT TO_CHAR (MODIFIED_DATE, 'DD/MM/YYYY HH24:MI') MODIFIED_DATE FROM PH_MEDN_ADMIN WHERE FACILITY_ID=? AND ENCOUNTER_ID=? AND SCH_DATE_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI') AND ORD_DRUG_CODE=? AND DOSAGE_SEQ_NO=? AND ORDER_ID=?";	
		String query2="SELECT IV_PREP_YN FROM OR_ORDER WHERE ORDER_ID=?";
		try{			
			pstmt=con.prepareStatement(query);
			pstmt3=con.prepareStatement(query2);
			if(non_iv_drugs!=null && non_iv_drugs.size()>0){
				for(int rowno=0;rowno<non_iv_drugs.size();rowno=rowno+50){//Changed 45 to 46//Modified from 44 to 45 for HSA-CRF-0090//code 'rowno=rowno+43' is replaced by 'rowno=rowno+44'  for CRF-PH- RUT-CRF-0088[IN043881] // 46 changed to 50 for GHL-CRF-0482
					prev_modified_date=(String)non_iv_drugs.get(rowno+38);				
					pstmt.setString(1,facility_id.trim());
					pstmt.setString(2,encounter_id.trim());
					pstmt.setString(3,((String)non_iv_drugs.get(rowno+3)).trim());
					pstmt.setString(4,((String)non_iv_drugs.get(rowno)).trim());
					pstmt.setString(5,((String)non_iv_drugs.get(rowno+1)).trim());
					pstmt.setString(6,((String)non_iv_drugs.get(rowno+14)).trim());
					resultSet=pstmt.executeQuery();
					if(resultSet!=null && resultSet.next()){
						curr_modified_date=resultSet.getString("MODIFIED_DATE")==null?"":(String)resultSet.getString("MODIFIED_DATE");
					}
					else
						curr_modified_date="";
					closeResultSet(resultSet);

					if(curr_modified_date.equals("") || curr_modified_date.equals(prev_modified_date)){
						nonIVAdministrationDoneByOtherUser=false;
					}
					else{
						nonIVAdministrationDoneByOtherUser=true;
						break;
					}				
				}
			}
			curr_modified_date="";
			prev_modified_date="";			
			if(iv_drugs.size()>0){
				for(int i=0;i<iv_drugs.size();i=i+42){//Changed 40 to 41//Modified from 39 to 40 for HSA-CRF-0090//Niji and changed 41 to 42 for SKR-SCF-1240
				
					prev_modified_date=(String)iv_drugs.get(i+35);		
					pstmt.setString(1,facility_id.trim());
					pstmt.setString(2,encounter_id.trim());
					pstmt.setString(3,(String)iv_drugs.get(i+20));	
					
					pstmt3.setString(1,(String)iv_drugs.get(i+3));
					resultSet3=pstmt3.executeQuery();
					if (resultSet3!=null && resultSet3.next()){
						iv_prep_yn		=	resultSet3.getString("IV_PREP_YN");				
					}	
					closeResultSet(resultSet3);
					if(iv_prep_yn.equals("2")||iv_prep_yn.equals("4")){
						ord_drug_code="FINAL PRODUCT";
					}
					else{
						ord_drug_code=(String)iv_drugs.get(i+1);
					} 

					pstmt.setString(4,ord_drug_code);
					pstmt.setString(5,(String)iv_drugs.get(i));
					pstmt.setString(6,(String)iv_drugs.get(i+3));
					resultSet2=pstmt.executeQuery();
					if(resultSet2!=null && resultSet2.next()){
						curr_modified_date=resultSet2.getString("MODIFIED_DATE")==null?"":(String)resultSet2.getString("MODIFIED_DATE");
					}
					else
						curr_modified_date="";
					closeResultSet(resultSet2);
					if(curr_modified_date.equals(prev_modified_date)){
						ivAdministrationDoneByOtherUser=false;
					}
					else{
						ivAdministrationDoneByOtherUser=true;
						break;
					}
					
				}
			}
			if(nonIVAdministrationDoneByOtherUser || ivAdministrationDoneByOtherUser)
				administrationDoneByOtherUser=true;
			else
				administrationDoneByOtherUser=false;
		}
		catch (Exception ex){
			ex.printStackTrace();
			try{
				closeStatement(pstmt);
				closeStatement(pstmt3);
				closeResultSet(resultSet);
				closeResultSet(resultSet2);
				closeResultSet(resultSet3);
			}
			catch(Exception ext){
				ext.printStackTrace();
			}
		}
		return administrationDoneByOtherUser;
	}
/**
* @ejb.interface-method
*	 view-type="both"
*/
	public HashMap updateMFRStock(HashMap tabData, HashMap sqlMap){		
		HashMap commonValues	= (HashMap)tabData.get("COMMON_VALUES");
		//HashMap sqlMap			= (HashMap)tabData.get("sqlMap");
		ArrayList dispTMP		= (ArrayList)tabData.get("DISP_DTLS");
		Properties prop			= (Properties)tabData.get("properties");
		String Auto_admin		= (String)tabData.get("Auto_admin");
		String facility_id		= (String)commonValues.get("facility_id");
		HashMap prev_doc_no		= new HashMap();
		HashMap map				= new HashMap();
		String patient_class    = ((String)tabData.get("patient_class")).trim();
		Connection connection	= null;
		try{
			 connection	= getConnection( prop ) ;					
			if(Auto_admin==null)
				Auto_admin="N";
					
			if(Auto_admin.equals("Y")){		
				if(dispTMP !=null){
					ArrayList dis = null;
					HashMap seq_no = null;
					HashMap stock_srl = null;
					HashMap batch = null;
					// Get the Stock Doc Type 
					String st_doc_type	=	getStockDocType(connection,sqlMap,patient_class,facility_id);
					for(int k=0;k<dispTMP.size();k=k+12){	 //9 to 12 for [IN:040149]						
						dis=new ArrayList();
						dis.add(dispTMP.get(k));
						dis.add(dispTMP.get(k+1));
						dis.add(dispTMP.get(k+2));
						dis.add(dispTMP.get(k+3));
						dis.add(dispTMP.get(k+4));
						dis.add(dispTMP.get(k+5));
						dis.add(dispTMP.get(k+6));
						dis.add(dispTMP.get(k+7));
						dis.add(dispTMP.get(k+9));
						dis.add(dispTMP.get(k+10));
						dis.add(dispTMP.get(k+11));
						if(!(((String)dispTMP.get(k+8)).equals("Y"))){
							seq_no	=	insertHeader(connection,sqlMap,tabData,dis);
							if( seq_no.containsKey( "result" )){
								connection.rollback();
								map.put( "result", new Boolean( false) ) ;
								map.put("msgid",seq_no.get("msgid"));	
								return map;
							} 

							stock_srl =	insertDetail(connection,sqlMap,tabData,dis,seq_no,stock_srl);
							if(  stock_srl.containsKey( "result" )){
								connection.rollback();
								map.put( "result", new Boolean( false) ) ;
								map.put("msgid",stock_srl.get("msgid"));	
								return map;					
							} 

							batch=insertBatch(connection, sqlMap,tabData,dis,seq_no);
							if(  batch.containsKey( "result" )){
								connection.rollback();
								map.put( "result", new Boolean( false) ) ;
								map.put("msgid",batch.get("msgid"));	
								return map;				
							} 
							commonValues.put("seq_no",seq_no);							
							callStockUpdate(connection,commonValues,sqlMap,dis,prev_doc_no,st_doc_type,stock_srl);										
							updateDrugProfile(connection, sqlMap, tabData,dis);
						}
					}
				}
			}
			connection.commit();
			map.put( "result", new Boolean( true) ) ;
			map.put("msgid","RECORD_INSERTED");	
		}
		catch(Exception except){
			except.printStackTrace();
		}finally {
			try{
				closeConnection( connection ,prop);//close connection based on checkstyle - ICN63833 
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return map;
	}

	public boolean recordCouldNotAdmin(HashMap tabData,HashMap sqlMap){
		Connection connection						= null ;
		PreparedStatement pstmt_update	= null;
		PreparedStatement psAuditLog = null;// Added for AAKH-CRF-0024 [IN:038260]
		PreparedStatement psAuditLogAccSeqNo = null;// Added for AAKH-CRF-0024 [IN:038260]
		ResultSet rsAuditLogAccSeqNo = null;// Added for AAKH-CRF-0024 [IN:038260]
		prop = (Properties)tabData.get("properties");
		final String SQL_PH_MEDN_ADMIN_COULD_NOT_ADMIN		= (String)sqlMap.get("SQL_PH_MEDN_ADMIN_COULD_NOT_ADMIN");
		final String SQL_PH_MEDN_ADMIN_COULD_NOT_ADMIN_AUDIT		= (String)sqlMap.get("SQL_PH_MEDN_ADMIN_COULD_NOT_ADMIN_AUDIT");
		final String SQL_PH_MEDN_ADMIN_COULD_NOT_ADMIN_AUDIT_INSERT		= (String)sqlMap.get("SQL_PH_MEDN_ADMIN_COULD_NOT_ADMIN_AUDIT_INSERT");
		ArrayList notAdminDtls = (ArrayList)tabData.get("NOTADMINDTLS"); 
		HashMap commonValues	= (HashMap)tabData.get("COMMON_VALUES");
		String facility_id		= (String)commonValues.get("facility_id");
		String added_by			=(String)commonValues.get("added_by");
		String ws_no			=(String)commonValues.get("ws_no");
		String auditLogRemarks="";
		int action_seq_num=1;
		boolean blnresult = false;
		try{
//System.err.println("======recordCouldNotAdmin========notAdminDtls=================="+notAdminDtls);
			if(notAdminDtls != null && notAdminDtls.size() > 0){
			   	connection		= getConnection( prop ) ;
				pstmt_update = connection.prepareStatement(SQL_PH_MEDN_ADMIN_COULD_NOT_ADMIN) ;
			   	pstmt_update.setString(1,(String)notAdminDtls.get(8));//admin_nursing_unit_code
				pstmt_update.setString(2,(String)notAdminDtls.get(7));//admin_bed_no
				pstmt_update.setString(3,"Y");//admin_recorded_yn
				pstmt_update.setString(4,(String)notAdminDtls.get(0));//non_admin_code
				pstmt_update.setString(5,(String)notAdminDtls.get(1));    //non_admin_remarks
				pstmt_update.setString(6,added_by);//admin_recorded_by
				pstmt_update.setString(7,"N");//administered_yn
				pstmt_update.setString(8,(String)notAdminDtls.get(2));//admin_by
				pstmt_update.setString(9,(String)notAdminDtls.get(3));//ADMIN_AUTHORIZED_BY
				pstmt_update.setString(10,facility_id);//modified_facility_id
				pstmt_update.setString(11,added_by);//modified_by_id
				pstmt_update.setString(12,ws_no);//modified_at_ws_no
				pstmt_update.setString(13,facility_id);//facility_id
				pstmt_update.setString(14,(String)notAdminDtls.get(13));//encounter_id
				pstmt_update.setString(15,(String)notAdminDtls.get(15));//sch_date_time
				pstmt_update.setString(16,(String)notAdminDtls.get(10));//ord_drug_code
				pstmt_update.setString(17,(String)notAdminDtls.get(14));//dosage_seq_no
				pstmt_update.setString(18,(String)notAdminDtls.get(11));//order_id
				int te=pstmt_update.executeUpdate();
//System.err.println("======recordCouldNotAdmin========te=================="+te);
				
				if(te == 1){
					te = 0;
					auditLogRemarks = (String)notAdminDtls.get(1)+" Scheduled Date:"+(String)notAdminDtls.get(15);
					psAuditLogAccSeqNo = connection.prepareStatement(SQL_PH_MEDN_ADMIN_COULD_NOT_ADMIN_AUDIT) ;
					psAuditLogAccSeqNo.setString(1,(String)notAdminDtls.get(11));
					psAuditLogAccSeqNo.setString(2,(String)notAdminDtls.get(12));
					rsAuditLogAccSeqNo = psAuditLogAccSeqNo.executeQuery();
					
					if (rsAuditLogAccSeqNo!=null && rsAuditLogAccSeqNo.next()) {
						action_seq_num = rsAuditLogAccSeqNo.getInt(1);
					}

					psAuditLog = connection.prepareStatement(SQL_PH_MEDN_ADMIN_COULD_NOT_ADMIN_AUDIT_INSERT) ;
		
					psAuditLog.setString(1,((String)notAdminDtls.get(11))); // order_id
					psAuditLog.setString(2,(String)notAdminDtls.get(12)); // order_line
					psAuditLog.setInt(3,action_seq_num); // order_line
					psAuditLog.setString(4,(String)notAdminDtls.get(2) ); // added by user id added_by
				
					psAuditLog.setString(5,facility_id); // facilty
					psAuditLog.setString(6,"Medication_Admin");
					psAuditLog.setString(7,""); // old text
					psAuditLog.setString(8,"Could Not Administer"); 
					psAuditLog.setString(9,auditLogRemarks); 
					te=psAuditLog.executeUpdate();
//System.err.println("======recordCouldNotAdmin====Auditlog====te=================="+te);
				}
				if(te == 1){
					connection.commit();
					blnresult= true;
				}
				else{
					connection.rollback();
					blnresult= false;
				}
			}	
		}
		catch(Exception e){
			e.printStackTrace();
			blnresult = false;
			try{					
				connection.rollback();
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		finally{
			try{					
				closeStatement( pstmt_update) ;
//close connection based on checkstyle - ICN63833  - start
			closeStatement( psAuditLogAccSeqNo );  
			closeResultSet( rsAuditLogAccSeqNo);
//close connection based on checkstyle - ICN63833  -end
				closeConnection( connection,prop );
				closeStatement(psAuditLog);//added for AAKH-CRF-0024 [IN:038260]
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return blnresult;
	}

	public boolean recordHold(HashMap tabData,HashMap sqlMap){
		Connection connection						= null ;
		//inc SKR-SCF-0840 starts
		PreparedStatement pstmt	= null;
		PreparedStatement pstmt_update_order	= null;
		PreparedStatement pstmt_update_order_hdr	= null;
		PreparedStatement pstmtupd	= null;
		//inc SKR-SCF-0840 ends
		PreparedStatement pstmt_update_order_line	= null;
		PreparedStatement pstmt_update_patient_drug_profile	= null;
		prop = (Properties)tabData.get("properties");
		final String SQL_PH_ORDER_LINE_UPDATE_HOLD		= (String)sqlMap.get("SQL_PH_ORDER_LINE_UPDATE_HOLD");
		final String SQL_PH_PATIENT_DRUG_PROFILE_UPDATE_HOLD		= (String)sqlMap.get("SQL_PH_PATIENT_DRUG_PROFILE_UPDATE_HOLD");
		//inc SKR-SCF-0840 Starts
		final String SQL_PH_ORDER_UPDATE_DISCONT		= (String)sqlMap.get("SQL_PH_ORDER_UPDATE_DISCONT");
		final String SQL_OR_ORDER_STATUS_SELECT		= (String)sqlMap.get("SQL_OR_ORDER_STATUS_SELECT");
		final String SQL_PH_ORDER_UPDATE_HDR		= (String)sqlMap.get("SQL_PH_ORDER_UPDATE_HDR");
		final String SQL_PH_UPDATE_PREV_ORDER_STATUS		= (String)sqlMap.get("SQL_PH_UPDATE_PREV_ORDER_STATUS");
		//inc SKR-SCF-0840 Ends

		ArrayList holdDetails = (ArrayList)tabData.get("HOLD_DETAILS"); 
		HashMap commonValues	= (HashMap)tabData.get("COMMON_VALUES");
		String facility_id		= (String)commonValues.get("facility_id");
		String added_by			=(String)commonValues.get("added_by");
		String ws_no			=(String)commonValues.get("ws_no");
		boolean blnresult = true;
		int result=0, count=1;
		String hdr_code="";//inc SKR-SCF-0840
		try{
			if(holdDetails != null && holdDetails.size() > 0){
			   	connection		= getConnection( prop ) ;
			   	pstmt=connection.prepareStatement(SQL_OR_ORDER_STATUS_SELECT);//inc SKR-SCF-0840
			   	pstmt_update_order = connection.prepareStatement(SQL_PH_ORDER_UPDATE_DISCONT);//inc SKR-SCF-0840
				pstmt_update_order_line				= connection.prepareStatement( SQL_PH_ORDER_LINE_UPDATE_HOLD ) ;
				pstmt_update_patient_drug_profile	= connection.prepareStatement( SQL_PH_PATIENT_DRUG_PROFILE_UPDATE_HOLD ) ;
				//inc SKR-SCF-0840 starts
				pstmtupd = connection.prepareStatement(SQL_PH_UPDATE_PREV_ORDER_STATUS);
				pstmtupd.setString(1, ((String)holdDetails.get(3)).trim()) ;
				pstmtupd.executeUpdate();
				closeStatement(pstmtupd);
				//inc SKR-SCF-0840 ends
				pstmt_update_order_line.setString(count,"HD");											//ORDER_LINE_STATUS
				pstmt_update_order_line.setString(++count,added_by);				//HOLD_PRACT_ID fetched for userid(passed), 
				pstmt_update_order_line.setString(++count,((String)holdDetails.get(6)).trim());		//HOLD_TIME - updated with Scheduled date time
				pstmt_update_order_line.setString(++count,((String)holdDetails.get(0)).trim());		//LAST_ACTION_TYPE
				pstmt_update_order_line.setString(++count,((String)holdDetails.get(2)).trim());		//LAST_ACTION_REASON_DESC
				//pstmt_update_order_line.setString(++count,((String)holdDetails.get(1)).trim());//CAN_LINE_REASON added newly for the ML-BRU-SCF-0184 by SureshKumar T on 07/06/2012
				pstmt_update_order_line.setString(++count,((String)holdDetails.get(2)).trim());// index 1 points to code, thus changed to index 2
				pstmt_update_order_line.setString(++count,added_by);		// modified id
				pstmt_update_order_line.setString(++count,facility_id);		// modified facility
				pstmt_update_order_line.setString(++count,ws_no);		// modified work station
				pstmt_update_order_line.setString(++count,((String)holdDetails.get(3)).trim());		//ORDER_ID
				pstmt_update_order_line.setString(++count,((String)holdDetails.get(4)).trim());		//ORDER_LINE_NUM
				result=pstmt_update_order_line.executeUpdate();
				//inc SKR-SCF-0840 Starts 
				if(result>0){
					count=1;
					pstmt.setString(count, ((String)holdDetails.get(3)).trim());
					pstmt.setString(++count,((String)holdDetails.get(4)).trim());
					ResultSet rs = pstmt.executeQuery();
					while(rs.next()){
						hdr_code = rs.getString("order_line_status");
					}
					closeResultSet( rs); //close connection based on checkstyle - ICN63833
				}
				if(!hdr_code.equals("") && result>0){
					count=1;
					pstmt_update_order.setString(count, "HD");
					pstmt_update_order.setString(++count,added_by);
					pstmt_update_order.setString(++count,ws_no);	
					pstmt_update_order.setString(++count,facility_id);		
					pstmt_update_order.setString(++count,((String)holdDetails.get(3)).trim());	
					result=pstmt_update_order_line.executeUpdate();	
				}
				else
				{
					pstmt_update_order_hdr = connection.prepareStatement( SQL_PH_ORDER_UPDATE_HDR) ;

					pstmt_update_order_hdr.setString( 1, "50") ; // hold code
					pstmt_update_order_hdr.setString( 2, added_by ) ;
					pstmt_update_order_hdr.setString( 3, ws_no ) ;
					pstmt_update_order_hdr.setString( 4, facility_id ) ;
					pstmt_update_order_hdr.setString( 5, ((String)holdDetails.get(3)).trim() ) ;
					result = pstmt_update_order_hdr.executeUpdate();	
				}
				//inc SKR-SCF-0840 ends
				if(result>0){
					count=1;
					pstmt_update_patient_drug_profile.setString(count,((String)holdDetails.get(6)).trim());		//ON_HOLD_DATE_TIME - updated with Scheduled date time
					pstmt_update_patient_drug_profile.setString(++count,added_by);							// ON_HOLD_BY_ID
					pstmt_update_patient_drug_profile.setString(++count,((String)holdDetails.get(1)).trim());	// ON_HOLD_REASON_CODE
					pstmt_update_patient_drug_profile.setString(++count,added_by);		// modified id
					pstmt_update_patient_drug_profile.setString(++count,facility_id);		// modified facility
					pstmt_update_patient_drug_profile.setString(++count,ws_no);		// modified work station
					pstmt_update_patient_drug_profile.setString(++count,"");		// alt_drug_remarks 
					pstmt_update_patient_drug_profile.setString(++count,((String)holdDetails.get(5)).trim());	// PATIENT_ID
					pstmt_update_patient_drug_profile.setString(++count,((String)holdDetails.get(3)).trim());	// ORIG_ORDER_ID
					pstmt_update_patient_drug_profile.setString(++count,((String)holdDetails.get(4)).trim());	// ORIG_ORDER_LINE_NO
					pstmt_update_patient_drug_profile.setString(++count,facility_id);					// FACILITY_ID
					result=pstmt_update_order_line.executeUpdate();
				}
				if(result > 0){
					connection.commit();
					blnresult= true;
				}
			}	
		}
		catch(Exception e){
			e.printStackTrace();
			blnresult = false;
		}
		finally{
			try{					
				closeStatement( pstmt_update_order_line) ;
				closeStatement( pstmt_update_patient_drug_profile) ;
				//inc SKR-SCF-0840 starts
				closeStatement( pstmt) ;
				closeStatement( pstmt_update_order) ;
				closeStatement( pstmt_update_order_hdr) ;
				//inc SKR-SCF-0840 ends
				
				closeConnection( connection,prop );
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return blnresult;
	}

	public boolean recordDiscontinue(HashMap tabData,HashMap sqlMap){
		Connection connection						= null ;
		PreparedStatement pstmt_update_order_line	= null;
		PreparedStatement pstmt_update_patient_drug_profile	= null;
		prop = (Properties)tabData.get("properties");
		final String SQL_PH_ORDER_LINE_UPDATE_DISCONT		= (String)sqlMap.get("SQL_PH_ORDER_LINE_UPDATE_DISCONT");
		final String SQL_PH_PATIENT_DRUG_PROFILE_UPDATE_DISCONT		= (String)sqlMap.get("SQL_PH_PATIENT_DRUG_PROFILE_UPDATE_DISCONT");
		
		PreparedStatement pstmt	= null;//Added for  SKR-SCF-0902 [IN:044632] Starts
		PreparedStatement pstmt_update_order	= null;
		PreparedStatement pstmt_update_order_hdr	= null;
		final String SQL_PH_ORDER_UPDATE_DISCONT		= (String)sqlMap.get("SQL_PH_ORDER_UPDATE_DISCONT");
		final String SQL_OR_ORDER_STATUS_SELECT		= (String)sqlMap.get("SQL_OR_ORDER_STATUS_SELECT");
		final String SQL_PH_ORDER_UPDATE_HDR		= (String)sqlMap.get("SQL_PH_ORDER_UPDATE_HDR");		//Added for SKR-SCF-0902 [IN:044632] Ends
		ArrayList discontDetails = (ArrayList)tabData.get("DISCONT_DETAILS"); 
		HashMap commonValues	= (HashMap)tabData.get("COMMON_VALUES");
		String facility_id		= (String)commonValues.get("facility_id");
		String added_by			=(String)commonValues.get("added_by");
		String ws_no			=(String)commonValues.get("ws_no");
		boolean blnresult = true;
		int result=0, count=1;
		String hdr_code="";
		try{
			if(discontDetails != null && discontDetails.size() > 0){
			   	connection		= getConnection( prop ) ;
			   	pstmt=connection.prepareStatement(SQL_OR_ORDER_STATUS_SELECT);//Added for SKR-SCF-0902 [IN:044632]
				pstmt_update_order_line				= connection.prepareStatement( SQL_PH_ORDER_LINE_UPDATE_DISCONT ) ;
				pstmt_update_order = connection.prepareStatement(SQL_PH_ORDER_UPDATE_DISCONT);//Added for SKR-SCF-0902 [IN:044632]
				pstmt_update_patient_drug_profile	= connection.prepareStatement( SQL_PH_PATIENT_DRUG_PROFILE_UPDATE_DISCONT ) ;

				pstmt_update_order_line.setString(count,"DC");				//ORDER_LINE_STATUS
				pstmt_update_order_line.setString(++count,added_by);				//DISC_PRACT_ID fetched for userid(passed), 
				pstmt_update_order_line.setString(++count,((String)discontDetails.get(6)).trim());		//DISCONT_DATE_TIME - updated with Scheduled date time
				pstmt_update_order_line.setString(++count,((String)discontDetails.get(0)).trim());		//LAST_ACTION_TYPE
				pstmt_update_order_line.setString(++count,((String)discontDetails.get(2)).trim());		//LAST_ACTION_REASON_DESC
				//pstmt_update_order_line.setString(++count,((String)discontDetails.get(1)).trim());//CAN_LINE_REASON added newly for the ML-BRU-SCF-0184 by SureshKumar T on 07/06/2012
				pstmt_update_order_line.setString(++count,((String)discontDetails.get(2)).trim());// index 1 points to code, thus changed to index 2
				pstmt_update_order_line.setString(++count,added_by);		// modified id
				pstmt_update_order_line.setString(++count,facility_id);		// modified facility
				pstmt_update_order_line.setString(++count,ws_no);		// modified work station
				pstmt_update_order_line.setString(++count,((String)discontDetails.get(3)).trim());		//ORDER_ID
				pstmt_update_order_line.setString(++count,((String)discontDetails.get(4)).trim());		//ORDER_LINE_NUM
				result=pstmt_update_order_line.executeUpdate();

				if(result>0){//Added for SKR-SCF-0902 [IN:044632] Starts 
					count=1;
					pstmt.setString(count, ((String)discontDetails.get(3)).trim());
					pstmt.setString(++count,((String)discontDetails.get(4)).trim());
					ResultSet rs = pstmt.executeQuery();
					while(rs.next()){
						hdr_code = rs.getString("order_line_status");
					}
					closeResultSet( rs ) ;//checkstyle
				}
				if(!hdr_code.equals("") && result>0){
					count=1;
					pstmt_update_order.setString(count, "DC");
					pstmt_update_order.setString(++count,added_by);
					pstmt_update_order.setString(++count,ws_no);	
					pstmt_update_order.setString(++count,facility_id);		// modified facility
					pstmt_update_order.setString(++count,((String)discontDetails.get(3)).trim());		//ORDER_ID
					result=pstmt_update_order_line.executeUpdate();	
				}
				else{
					pstmt_update_order_hdr = connection.prepareStatement( SQL_PH_ORDER_UPDATE_HDR) ;
					
					pstmt_update_order_hdr.setString( 1, "93") ; // discontinue code
					pstmt_update_order_hdr.setString( 2, added_by ) ;
					pstmt_update_order_hdr.setString( 3, ws_no ) ;
					pstmt_update_order_hdr.setString( 4, facility_id ) ;
					pstmt_update_order_hdr.setString( 5, ((String)discontDetails.get(3)).trim() ) ;
					result = pstmt_update_order_hdr.executeUpdate();
				}	//Added for SKR-SCF-0902 [IN:044632] Ends

				if(result>0){
					count=1;
					pstmt_update_patient_drug_profile.setString(count,((String)discontDetails.get(6)).trim());		//DISCONT_DATE_TIME - updated with Scheduled date time
					pstmt_update_patient_drug_profile.setString(++count,added_by);							// DISCONT_BY_ID
					pstmt_update_patient_drug_profile.setString(++count,((String)discontDetails.get(1)).trim());	// DISCONT_REASON_CODE
					pstmt_update_patient_drug_profile.setString(++count,added_by);		// modified id
					pstmt_update_patient_drug_profile.setString(++count,facility_id);		// modified facility
					pstmt_update_patient_drug_profile.setString(++count,ws_no);		// modified work station
					pstmt_update_patient_drug_profile.setString(++count,((String)discontDetails.get(5)).trim());	// PATIENT_ID
					pstmt_update_patient_drug_profile.setString(++count,((String)discontDetails.get(3)).trim());	// ORIG_ORDER_ID
					pstmt_update_patient_drug_profile.setString(++count,((String)discontDetails.get(4)).trim());	// ORIG_ORDER_LINE_NO
					pstmt_update_patient_drug_profile.setString(++count,facility_id);					// FACILITY_ID
					result=pstmt_update_order_line.executeUpdate();
				}
				if(result > 0){
					connection.commit();
					blnresult= true;
				}
			}	
		}
		catch(Exception e){
			e.printStackTrace();
			blnresult = false;
		}
		finally{
			try{					
				closeStatement( pstmt_update_order_line) ;
				closeStatement( pstmt_update_patient_drug_profile) ;
				closeStatement( pstmt) ;//Added for SKR-SCF-0902 [IN:044632] Starts
				closeStatement( pstmt_update_order) ;
				closeStatement( pstmt_update_order_hdr) ;//Added for SKR-SCF-0902 [IN:044632] Ends
				closeConnection( connection,prop );
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return blnresult;
	}
}
