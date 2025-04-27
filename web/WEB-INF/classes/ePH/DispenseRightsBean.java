/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH ;

import java.io.Serializable ;
import java.util.* ;
import java.sql.* ;
/*import javax.rmi.PortableRemoteObject ;
import javax.naming.InitialContext ;*/
import ePH.Common.* ;
import eCommon.Common.* ;
import ePH.DispenseRights.*;

public class DispenseRightsBean extends PhAdapter implements Serializable {

	private String locn_code		= "";
	private String user_id			= "";
	private String user_pwd			= "";
	private boolean userExists		= false;
	private Hashtable recordSet		= new Hashtable();
	private String login_user_id		= login_by_id;//added for GDOH-CRF-0086 [IN:058551]
	
	public DispenseRightsBean() {
		try {
			doCommon() ;
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/* Over-ridden Adapter methods start here */
	private void doCommon() throws Exception {
	}

	public void clear() {
		locn_code		= "";
		user_id			= "";
		user_pwd		= "";
		userExists=false; 
	}

	/**
	 * @return the login_user_id//added for GDOH-CRF-0086 [IN:058551]
	 */
	public String getLoginUserId() {
		return login_user_id;
	}

	public void setDispLocnCode(String locn_code) {
		this.locn_code = locn_code;
	}

	public void setUserID(String user_id) {
		this.user_id = user_id;
	}

	public void setPassWord(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getDispLocnCode() {
		return this.locn_code;
	}

	public String getUserID() {
		return this.user_id;
	}

	public String getPassWord() {
		return this.user_pwd;
	}
	public String getLoggedInFacility() {
		return login_facility_id;
	}

	public void setAll( Hashtable recordSet ) {
		/* This function also is called by the controller when apply is pressed recordSet is nothing but a hashtable containing all form values*/
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;
		this.recordSet = recordSet;
	}

	public HashMap validate() throws Exception {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map ;
	}

	/* This  function is called when delete is pressed */
	public HashMap delete() {
		HashMap tabData = new HashMap() ;		
		HashMap sqlMap = new HashMap() ;		
		tabData.put("result",new Boolean(false));
		tabData.put( "properties", getProperties() );
		/* Performing delete operation */
		try {
			sqlMap.put("SQL_PH_DISP_RIGHTS_DELETERIGHTS",PhRepository.getPhKeyValue( "SQL_PH_DISP_RIGHTS_DELETERIGHTS" ));
			sqlMap.put("SQL_QUERY_SELECT_WORKLOAD",PhRepository.getPhKeyValue( "SQL_QUERY_SELECT_WORKLOAD" ));
			sqlMap.put("SQL_PH_DISP_RIGHTS_DELETEUSERS",PhRepository.getPhKeyValue( "SQL_PH_DISP_RIGHTS_DELETEUSERS" ));
			tabData.put("login_facility_id",login_facility_id);
			tabData.put("disp_locn_code",getDispLocnCode());
			tabData.put("user_id",getUserID());
		}
		catch (Exception e) {
			e.printStackTrace();
			return tabData;
		}
		
		return callFunctionEJB( tabData,sqlMap );
	}
	/* This insert function is called when apply is pressed */
	public HashMap insert() {
		/*  All the form values are stored in local variables */
		String general_yn		= "";
		String narcotic_yn		= "";
		String controlled_yn	= "";
		String regn_yn			= "";
		String verify_yn		= "";
		String fill_yn			= "";
		String allocate_yn		= "";
		String bill_receipt_yn	= "";
		String deliver_yn		= "";
		String allow_reprint_yn	= "";
		String no_of_reprints	= "";
		String medn_rtn_yn		= "";
		String ip_verify_yn		= "";
		String ip_allocate_yn	= "";
		String ip_deliver_yn	= "";
		String ip_accept_medn_rtn_yn      = "";
		String change_dose_durn_verify_yn = "";
		String auth_amend_pres_yn = "";//added for ML-MMOH-CRF-0863
		String trade_change_allowed_yn    = "";
		String allow_multi_trade_yn		  = "";	
		String allow_patient_history_yn	  = "";
		String re_route_orders			  ="";
		String op_reissue_medication_yn   ="";
		String ip_reissue_medication_yn   ="";
		String unlock_records_yn		  ="";//Added for CRF-0439
		String dflt_ip_fill				  =""; // Added for ICN-30405
		String dflt_ip_deliver			  =""; // Added for ICN-30405
		String track_outsourcing_yn			  ="N"; //added for Bru-HIMS-CRF-087 [IN:029953]
		String outsourcing_send_yn			  ="N"; //added for Bru-HIMS-CRF-087 [IN:029953]
		String outsourcing_receive_yn			  ="N"; //added for Bru-HIMS-CRF-087 [IN:029953]
		String outsourcing_deliver_yn			  ="N"; //added for Bru-HIMS-CRF-087 [IN:029953]
		String outsourcing_def_action			  =""; //added for Bru-HIMS-CRF-087 [IN:029953]
		String outsourcing_def_facility			  =""; //added for Bru-HIMS-CRF-087 [IN:029953]
		String ip_medn_rtn_after_bill_gen			  =""; //added for JD-CRF-0178 [IN:039208]
		String op_medn_rtn_after_bill_gen			  =""; //added for JD-CRF-0178 [IN:039208]
		String financial_details			 	  =""; //code added for JD-CRF-0156[IN041737]
		String ip_dflt_disp_stage			  =""; //added for [IN:047788]
		String op_dflt_disp_stage			  =""; //added for [IN:047788]
		String dflt_token_series_ind			  =""; //added for HSA-CRF-0136 [IN:048412]
		String sort_token_series_ind			  =""; //added for HSA-CRF-0136 [IN:048412]
		
		HashMap commonData = new HashMap() ;
		ArrayList insertData = new ArrayList() ;
		ArrayList insertData1 = new ArrayList() ;
		if(recordSet.containsKey("TRADE_CHANGE_ALLOWED_YN")) {
			if ( recordSet.get("TRADE_CHANGE_ALLOWED_YN").toString().equals("on") )
				trade_change_allowed_yn = "Y" ;
			else
				trade_change_allowed_yn = "N" ;
		}
		if(recordSet.containsKey("ALLOW_MULTI_TRADE_YN")) {
			if ( recordSet.get("ALLOW_MULTI_TRADE_YN").toString().equals("on") )
				allow_multi_trade_yn = "Y" ;
			else
				allow_multi_trade_yn = "N" ;
		}	
		if(recordSet.containsKey("PATIENT_HISTROY_YN")) {
			if ( recordSet.get("PATIENT_HISTROY_YN").toString().equals("on") )
				allow_patient_history_yn = "Y" ;
			else
				allow_patient_history_yn = "N" ;
		}	
		if(recordSet.containsKey("REROUTE_ORDER_YN")) {
			if ( recordSet.get("REROUTE_ORDER_YN").toString().equals("on") )
				re_route_orders = "Y" ;
			else
				re_route_orders = "N" ;
		}	
		if(recordSet.containsKey("GENERAL_YN")) {
			if ( recordSet.get("GENERAL_YN").toString().equals("on") )
				general_yn = "Y" ;
			else
				general_yn = "N" ;
		}
		if(recordSet.containsKey("NARCOTIC_YN")) {
			if ( recordSet.get("NARCOTIC_YN").toString().equals("on") )
				narcotic_yn = "Y" ;
			else
				narcotic_yn = "N" ;
		}
		if(recordSet.containsKey("CONTROLLED_YN")) {
			if ( recordSet.get("CONTROLLED_YN").toString().equals("on") )
				controlled_yn = "Y" ;
			else
				controlled_yn = "N" ;
		}
		if(recordSet.containsKey("REGN_YN")) {
			if ( recordSet.get("REGN_YN").toString().equals("on") )
				regn_yn = "Y" ;
			else
				regn_yn = "N" ;
		}
		if(recordSet.containsKey("VERIFY_YN")) {
			if ( recordSet.get("VERIFY_YN").toString().equals("on") )
				verify_yn = "Y" ;
			else
				verify_yn = "N" ;
		}
		if(recordSet.containsKey("FILL_YN")) {
			if ( recordSet.get("FILL_YN").toString().equals("on") )
				fill_yn = "Y" ;
			else
				fill_yn = "N" ;
		}
		if(recordSet.containsKey("ALLOCATE_YN")) {
			if ( recordSet.get("ALLOCATE_YN").toString().equals("on") )
				allocate_yn = "Y" ;
			else
				allocate_yn = "N" ;
		}
		if(recordSet.containsKey("BILL_RECEIPT_YN")) {
			if ( recordSet.get("BILL_RECEIPT_YN").toString().equals("on") )
				bill_receipt_yn = "Y" ;
			else
				bill_receipt_yn = "N" ;
		}
		if(recordSet.containsKey("DELIVER_YN")) {
			if ( recordSet.get("DELIVER_YN").toString().equals("on") )
				deliver_yn = "Y" ;
			else
				deliver_yn = "N" ;
		}
		if(recordSet.containsKey("ALLOW_REPRINT_YN")) {
			if ( recordSet.get("ALLOW_REPRINT_YN").toString().equals("on") )
				allow_reprint_yn = "Y" ;
			else
				allow_reprint_yn = "N" ;
		}
		if(recordSet.containsKey("NO_OF_REPRINTS")) {
			no_of_reprints = recordSet.get("NO_OF_REPRINTS").toString() ;
		}
		if(recordSet.containsKey("MEDN_RTN_YN")) {
			if ( recordSet.get("MEDN_RTN_YN").toString().equals("on") )
				medn_rtn_yn = "Y" ;
			else
				medn_rtn_yn = "N" ;
		}
		if(recordSet.containsKey("IP_VERIFY_YN")) {
			if ( recordSet.get("IP_VERIFY_YN").toString().equals("on") )
				ip_verify_yn = "Y" ;
			else
				ip_verify_yn = "N" ;
		}
		if(recordSet.containsKey("IP_ALLOCATE_YN")) {
			if ( recordSet.get("IP_ALLOCATE_YN").toString().equals("on") )
				ip_allocate_yn = "Y" ;
			else
				ip_allocate_yn = "N" ;
		}
		if(recordSet.containsKey("IP_DELIVER_YN")) {
			if ( recordSet.get("IP_DELIVER_YN").toString().equals("on") )
				ip_deliver_yn = "Y" ;
			else
				ip_deliver_yn = "N" ;
		}
		if(recordSet.containsKey("IP_ACCEPT_MEDN_RTN_YN")) {
			if ( recordSet.get("IP_ACCEPT_MEDN_RTN_YN").toString().equals("on") )
				ip_accept_medn_rtn_yn = "Y" ;
			else
				ip_accept_medn_rtn_yn = "N" ;
		}
		if(recordSet.containsKey("CHANGE_DOSE_DURN_VERIFY_YN")) {
			if ( recordSet.get("CHANGE_DOSE_DURN_VERIFY_YN").toString().equals("on") )
				change_dose_durn_verify_yn = "Y" ;
			else
				change_dose_durn_verify_yn = "N" ;
		}
		//ADDED FOR ML-MMOH-CRF-0863 START
		if(recordSet.containsKey("AUTH_AMEND_PRES_YN")) {
			if ( recordSet.get("AUTH_AMEND_PRES_YN").toString().equals("on") )
				auth_amend_pres_yn = "Y" ;
			else
				auth_amend_pres_yn = "N" ;
		}
		//ADDED FOR ML-MMOH-CRF-0863 END
		
		if(recordSet.containsKey("OP_REISSUE_MEDICATION_YN")) {
			if ( recordSet.get("OP_REISSUE_MEDICATION_YN").toString().equals("on") )
				op_reissue_medication_yn= "Y" ;
			else
				op_reissue_medication_yn = "N" ;
		}
		if(recordSet.containsKey("IP_REISSUE_MEDICATION_YN")) {
			if ( recordSet.get("IP_REISSUE_MEDICATION_YN").toString().equals("on") )
				ip_reissue_medication_yn = "Y" ;
			else
				ip_reissue_medication_yn = "N" ;
		}
		//Added for CRF-0439
		if(recordSet.containsKey("UNLOCK_RECORDS_YN")) {
			if ( recordSet.get("UNLOCK_RECORDS_YN").toString().equals("on") )
				unlock_records_yn = "Y" ;
			else
				unlock_records_yn = "N" ;
		}
		// Added for ICN-30405
		 if(recordSet.containsKey("CHK_FILL_LIST")) {
			 if ( (String) recordSet.get("CHK_FILL_LIST")!=null )
			     dflt_ip_fill =  (String) recordSet.get("CHK_FILL_LIST");
			 else
				dflt_ip_fill = "AF" ;
		}
		if(recordSet.containsKey("CHK_DELIVER_FILL_LIST")) {
			 if ( (String) recordSet.get("CHK_DELIVER_FILL_LIST")!=null)
				dflt_ip_deliver =  (String) recordSet.get("CHK_DELIVER_FILL_LIST");
			else
				dflt_ip_deliver = "DWF" ;   
		}  
		/* The local variables are added into array list insertData*/
		//added for Bru-HIMS-CRF-087 [IN:029953] - Start
		 if(recordSet.containsKey("TRACK_OUTSOURCING_YN")) {
			if ( recordSet.get("TRACK_OUTSOURCING_YN").toString().equals("on") )
				track_outsourcing_yn = "Y" ;
			else
				track_outsourcing_yn = "N" ;
		}
		 if(recordSet.containsKey("OUTSOURCING_SEND")) {
			if ( recordSet.get("OUTSOURCING_SEND").toString().equals("on") )
				outsourcing_send_yn = "Y" ;
			else
				outsourcing_send_yn = "N" ;
		}
		 if(recordSet.containsKey("OUTSOURCING_RECEIVE")) {
			if ( recordSet.get("OUTSOURCING_RECEIVE").toString().equals("on") )
				outsourcing_receive_yn = "Y" ;
			else
				outsourcing_receive_yn = "N" ;
		}
		 if(recordSet.containsKey("OUTSOURCING_DELIVER")) {
			if ( recordSet.get("OUTSOURCING_DELIVER").toString().equals("on") )
				outsourcing_deliver_yn = "Y" ;
			else
				outsourcing_deliver_yn = "N" ;
		}
		 if(recordSet.containsKey("OUTSOURCING_DEF_ACTION")) {
		     outsourcing_def_action =  recordSet.get("OUTSOURCING_DEF_ACTION")==null?"":(String) recordSet.get("OUTSOURCING_DEF_ACTION");
		}
		 if(recordSet.containsKey("OUTSOURCING_DEF_FACILITY")) {
		     outsourcing_def_facility =  recordSet.get("OUTSOURCING_DEF_FACILITY")==null?"":(String) recordSet.get("OUTSOURCING_DEF_FACILITY");
		}
		//added for Bru-HIMS-CRF-087 [IN:029953] - End
		 if(recordSet.containsKey("IP_MEDN_RTN_AFTER_BILL_GEN")) { //Added for  JD-CRF-0178 [IN:039208] -Start
		     ip_medn_rtn_after_bill_gen =  recordSet.get("IP_MEDN_RTN_AFTER_BILL_GEN")==null?"":(String) recordSet.get("IP_MEDN_RTN_AFTER_BILL_GEN");
		}
		 if(recordSet.containsKey("OP_MEDN_RTN_AFTER_BILL_GEN")) {
		     op_medn_rtn_after_bill_gen =  recordSet.get("OP_MEDN_RTN_AFTER_BILL_GEN")==null?"":(String) recordSet.get("OP_MEDN_RTN_AFTER_BILL_GEN");
		} //Added for  JD-CRF-0178 [IN:039208] -End
		if(recordSet.containsKey("FINANCIAL_DETAILS_YN")) {//code added for JD-CRF-0156[IN041737]--Start
			if ( recordSet.get("FINANCIAL_DETAILS_YN").toString().equals("on") )
				financial_details = "Y" ;
			else
				financial_details = "N" ;		 	
		}//code added for JD-CRF-0156[IN041737]--End
		if(recordSet.containsKey("IP_DFLT_DISP_STAGE")) { //Added for  //added for [IN:047788] -Start
		     ip_dflt_disp_stage =  checkForNull((String)recordSet.get("IP_DFLT_DISP_STAGE"));
		}
		if(recordSet.containsKey("OP_DFLT_DISP_STAGE")) { 
		     op_dflt_disp_stage =  checkForNull((String)recordSet.get("OP_DFLT_DISP_STAGE"));
		}//added for [IN:047788] -end
		if(recordSet.containsKey("DFLT_TOKEN_SERIES_IND")) { //added for HSA-CRF-0136 [IN:048412]
		     dflt_token_series_ind =  checkForNull((String)recordSet.get("DFLT_TOKEN_SERIES_IND"));
		}
		if(recordSet.containsKey("SORT_TOKEN_SERIES_IND")) { //added for HSA-CRF-0136 [IN:048412]
		     sort_token_series_ind =  checkForNull((String)recordSet.get("SORT_TOKEN_SERIES_IND"));
		}
		commonData.put("login_facility_id",login_facility_id);
		commonData.put("getDispLocnCode",getDispLocnCode());
		commonData.put("getUserID",getUserID());
		commonData.put("general_yn",general_yn);
		commonData.put("narcotic_yn",narcotic_yn);
		commonData.put("controlled_yn",controlled_yn);
		commonData.put("regn_yn",regn_yn);
		commonData.put("verify_yn",verify_yn);
		commonData.put("fill_yn",fill_yn);
		commonData.put("allocate_yn",allocate_yn);
		commonData.put("bill_receipt_yn",bill_receipt_yn);
		commonData.put("deliver_yn",deliver_yn);
		commonData.put("allow_reprint_yn",allow_reprint_yn);
		commonData.put("no_of_reprints",no_of_reprints);
		commonData.put("medn_rtn_yn",medn_rtn_yn);
		commonData.put("ip_verify_yn",ip_verify_yn);
		commonData.put("ip_allocate_yn",ip_allocate_yn);
		commonData.put("ip_deliver_yn",ip_deliver_yn);
		commonData.put("login_by_id",login_by_id);
		commonData.put("lwsno","temp ws no");
		commonData.put("login_facility_id",login_facility_id);
		commonData.put("login_by_id",login_by_id);
		commonData.put("lwsno","temp ws no");
		commonData.put("login_facility_id",login_facility_id);
		commonData.put("ip_accept_medn_rtn_yn",ip_accept_medn_rtn_yn);
		commonData.put("change_dose_durn_verify_yn",change_dose_durn_verify_yn);
		System.out.println("insertData1"+auth_amend_pres_yn);
		commonData.put("auth_amend_pres_yn",auth_amend_pres_yn);//ADDED FOR ML-MMOH-CRF-0863
		commonData.put("trade_change_allowed_yn",trade_change_allowed_yn);
		commonData.put("allow_multi_trade_yn",allow_multi_trade_yn);
		commonData.put("re_route_orders",re_route_orders);
		commonData.put("allow_patient_history_yn",allow_patient_history_yn);
		commonData.put("op_reissue_medication_yn",op_reissue_medication_yn);
		commonData.put("ip_reissue_medication_yn",ip_reissue_medication_yn);
		commonData.put("unlock_records_yn",unlock_records_yn);//Added for CRF-0439

		commonData.put("dflt_ip_fill",dflt_ip_fill);//Added for ICN-30405
		commonData.put("dflt_ip_deliver",dflt_ip_deliver);//Added for ICN-30405
		commonData.put("track_outsourcing_yn",track_outsourcing_yn); //added for Bru-HIMS-CRF-087 [IN:029953] -start
		commonData.put("outsourcing_send_yn",outsourcing_send_yn);
		commonData.put("outsourcing_receive_yn",outsourcing_receive_yn);
		commonData.put("outsourcing_deliver_yn",outsourcing_deliver_yn);
		commonData.put("outsourcing_def_action",outsourcing_def_action);
		commonData.put("outsourcing_def_facility",outsourcing_def_facility);	//added for Bru-HIMS-CRF-087 [IN:029953]- end
		commonData.put("ip_medn_rtn_after_bill_gen",ip_medn_rtn_after_bill_gen);	//Added for JD-CRF-0178 [IN:039208]
		commonData.put("op_medn_rtn_after_bill_gen",op_medn_rtn_after_bill_gen);	//Added for JD-CRF-0178 [IN:039208]
		commonData.put("financial_details",financial_details);//code added for JD-CRF-0156[IN:041737]	
		commonData.put("ip_dflt_disp_stage",ip_dflt_disp_stage);//code added for [IN:047788]	
		commonData.put("op_dflt_disp_stage",op_dflt_disp_stage);//code added for [IN:047788]	
		commonData.put("dflt_token_series_ind",dflt_token_series_ind);//code added for HSA-CRF-0136 [IN:048412]
		commonData.put("sort_token_series_ind",sort_token_series_ind);//code added for HSA-CRF-0136 [IN:048412]
		
		insertData.add(login_facility_id);
		insertData.add(getDispLocnCode());
		insertData.add(getUserID());
		insertData.add(general_yn);
		insertData.add(narcotic_yn);
		insertData.add(controlled_yn);
		insertData.add(regn_yn);
		insertData.add(verify_yn);
		insertData.add(fill_yn);
		insertData.add(allocate_yn);
		insertData.add(bill_receipt_yn);
		insertData.add(deliver_yn);
		insertData.add(allow_reprint_yn);
		insertData.add(no_of_reprints);
		insertData.add(medn_rtn_yn);
		insertData.add(ip_verify_yn);
		insertData.add(ip_allocate_yn);
		insertData.add(ip_deliver_yn);
		insertData.add(login_by_id);
		String lwsno=login_at_ws_no;
		if ((lwsno=="")||(lwsno==null))
			lwsno="temp ws no";

		insertData.add(lwsno);
		insertData.add(login_facility_id);
		insertData.add(login_by_id);
		insertData.add(lwsno);
		insertData.add(login_facility_id);		
		insertData.add(ip_accept_medn_rtn_yn);
		insertData.add(change_dose_durn_verify_yn);
		insertData.add(trade_change_allowed_yn);
		insertData.add(allow_multi_trade_yn);
		insertData.add(re_route_orders);
		insertData.add(allow_patient_history_yn);
		insertData.add(op_reissue_medication_yn);
		insertData.add(ip_reissue_medication_yn);
		insertData.add(unlock_records_yn);//Added for CRF-0439
		insertData.add(auth_amend_pres_yn);//ADDED FOR ML-MMOH-CRF-0863
		/* InsertData and properties are added into tabData which is a hash map*/
		HashMap tabData = new HashMap() ;
		HashMap sqlMap = new HashMap() ;

		tabData.put( "properties", getProperties() );
		tabData.put( "INSERTRIGHTS", insertData ) ;
		tabData.put( "COMMONDATA", commonData ) ;
		tabData.put( "flag","0");
		String encryptedPassword = encryptPass();
		if (userExists) {
			/* If new user profile exists */
			insertData1.add(encryptedPassword);
			insertData1.add(login_by_id);
			insertData1.add(login_at_ws_no);
			insertData1.add(login_facility_id);
			insertData1.add(getUserID());
		}
		else {
			insertData1.add(getUserID());
			insertData1.add(encryptedPassword);
			insertData1.add("E");
			insertData1.add(login_by_id);
			lwsno=login_at_ws_no;
			if ((lwsno=="")||(lwsno==null))
				lwsno="temp ws no";
			insertData1.add(lwsno);
			insertData1.add(login_facility_id);
			insertData1.add(login_by_id);
			lwsno=login_at_ws_no;
			if ((lwsno=="")||(lwsno==null))
				lwsno="temp ws no";
			insertData1.add(lwsno);
			insertData1.add(login_facility_id);
		}

		/* The user details are put into tabData*/
		tabData.put( "INSERTUSERS", insertData1 ) ;
	    tabData.put("result",new Boolean(false));
		try {
			sqlMap.put( "SQLDISPRIGHTS",PhRepository.getPhKeyValue( "SQL_PH_DISP_RIGHTS_USERRIGHTS" ));
			//Modified  for CRF-0439
			//sqlMap.put( "SQL_PH_DISP_RIGHTS_INSERTRIGHTS",PhRepository.getPhKeyValue( "SQL_PH_DISP_RIGHTS_INSERTRIGHTS" ));
		//auth_amend_pres_yn added for ml-mmoh-crf-0863
			sqlMap.put("SQL_PH_DISP_RIGHTS_INSERTRIGHTS","INSERT INTO ph_disp_rights(facility_id, disp_locn_code, appl_user_id,disp_auth_reqd_drug_yn,disp_narcotic_yn,disp_controlled_drug_yn, ack_yn, verify_yn, fill_yn,allocate_yn, bill_receipt_yn, deliver_yn, allow_reprint_yn,no_of_reprints, accept_medn_rtn_yn, ip_verify_yn,ip_allocate_yn, ip_deliver_yn,added_by_id, added_date,added_at_ws_no, added_facility_id, modified_by_id,modified_date, modified_at_ws_no,modified_facility_id,ip_accept_medn_rtn_yn, change_dose_durn_verify_yn,trade_change_allowed_yn, multi_trade_allowed_yn,reroute_order_yn, view_pat_hist_yn, op_reissue_med_yn,ip_reissue_med_yn,unlock_all_records_yn,dflt_ip_fill,dflt_ip_deliver, track_outsourcing_yn, outsourcing_send_yn, outsourcing_receive_yn, outsourcing_deliver_yn, outsourcing_def_action, outsourcing_def_facility, ip_medn_rtn_after_bill_gen, op_medn_rtn_after_bill_gen,CURR_ENC_FINANCIAL_DTL_YN, ip_dflt_disp_stage, op_dflt_disp_stage, dflt_token_series_ind, sort_token_series_ind,auth_amend_pres_yn) VALUES (?, ?, ?,?, ?,?, ?, ?, ?,?,?, ?, ?, ?,?, ?, ?,?, ?, SYSDATE,?, ?,?,SYSDATE,?,?,?, ?,?, ?,?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?, ?, ?, ?,?)"); //ip_medn_rtn_after_bill_gen, op_medn_rtn_after_bill_gen Added for JD-CRF-0178 [IN:039208]

			//new query
			//sqlMap.put( "SQLINSERTRIGHTS","INSERT INTO PH_DISP_RIGHTS(FACILITY_ID, DISP_LOCN_CODE, APPL_USER_ID, DISP_AUTH_REQD_DRUG_YN, DISP_NARCOTIC_YN, DISP_CONTROLLED_DRUG_YN, ACK_YN, VERIFY_YN, FILL_YN, ALLOCATE_YN, BILL_RECEIPT_YN, DELIVER_YN, ALLOW_REPRINT_YN, NO_OF_REPRINTS, ACCEPT_MEDN_RTN_YN, IP_VERIFY_YN, IP_ALLOCATE_YN, IP_DELIVER_YN, ADDED_BY_ID, ADDED_DATE,		ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,IP_ACCEPT_MEDN_RTN_YN, CHANGE_DOSE_DURN_VERIFY_YN,TRADE_CHANGE_ALLOWED_YN,MULTI_TRADE_ALLOWED_YN,REROUTE_ORDER_YN,VIEW_PAT_HIST_YN,OP_REISSUE_MED_YN,IP_REISSUE_MED_YN) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?,?,?,?,?,?,?,?)");
			//sqlMap.put( "SQLINSERTRIGHTS","INSERT INTO ph_disp_rights(facility_id, disp_locn_code, appl_user_id,disp_auth_reqd_drug_yn,disp_narcotic_yn,disp_controlled_drug_yn, ack_yn, verify_yn, fill_yn,allocate_yn, bill_receipt_yn, deliver_yn, allow_reprint_yn,no_of_reprints, accept_medn_rtn_yn, ip_verify_yn,ip_allocate_yn, ip_deliver_yn,added_by_id, added_date,added_at_ws_no, added_facility_id, modified_by_id,modified_date, modified_at_ws_no,modified_facility_id,ip_accept_medn_rtn_yn, change_dose_durn_verify_yn,trade_change_allowed_yn, multi_trade_allowed_yn,reroute_order_yn, view_pat_hist_yn, op_reissue_med_yn,ip_reissue_med_yn) VALUES (?, ?, ?,?, ?,?, ?, ?, ?,?, ?, ?, ?,?, ?, ?,?, ?, ?,SYSDATE,?, ?,?,SYSDATE,?,?,?, ?,?, ?,?, ?, ?,?)");
			
			/* When user password needs to be updated */
		    //tabData.put("message","User exists is"+userExists);
			if (userExists){
				if (!user_pwd.equals("")){
					//	tabData.put("message","Inside user passwor is not null");
					sqlMap.put( "SQLUPDATEUSERS", PhRepository.getPhKeyValue( "SQL_PH_DISP_RIGHTS_UPDATEUSER" ));
				}
			}
			else{
				sqlMap.put( "SQLINSERTUSERS", PhRepository.getPhKeyValue( "SQL_PH_DISP_RIGHTS_INSERTUSER" ));
			}
		}
		catch (Exception e) {
			e.printStackTrace() ;	
		}
		clear();
		return callFunctionEJB( tabData,sqlMap );
	}

	public HashMap modify() {
		String general_yn		= "";
		String narcotic_yn		= "";
		String controlled_yn	= "";
		String regn_yn			= "";
		String verify_yn		= "";
		String fill_yn			= "";
		String allocate_yn		= "";
		String bill_receipt_yn	= "";
		String deliver_yn		= "";
		String allow_reprint_yn	= "";
		String no_of_reprints	= "";
		String medn_rtn_yn		= "";
		String ip_verify_yn		= "";
		String ip_allocate_yn	= "";
		String ip_deliver_yn	= "";//****
		String trade_change_allowed_yn      = "";
		String ip_accept_medn_rtn_yn		= "";
		String change_dose_durn_verify_yn   = "";
		String auth_amend_pres_yn   = "";//ADDED FOR ML-MMOH-CRF-0863
		
		String allow_multi_trade_yn			= "";
		String re_route_orders ="";
		String allow_patient_history_yn			= "";
		String ip_reissue_medication_yn			= "";
		String op_reissue_medication_yn			= "";
		String unlock_records_yn				="";//Added for CRF-0439
		String dflt_ip_fill				  =""; // Added for ICN-30405
		String dflt_ip_deliver			  =""; // Added for ICN-30405
		String track_outsourcing_yn			  ="N"; //added for Bru-HIMS-CRF-087 [IN:029953]
		String outsourcing_send_yn			  ="N"; //added for Bru-HIMS-CRF-087 [IN:029953]
		String outsourcing_receive_yn			  ="N"; //added for Bru-HIMS-CRF-087 [IN:029953]
		String outsourcing_deliver_yn			  ="N"; //added for Bru-HIMS-CRF-087 [IN:029953]
		String outsourcing_def_action			  =""; //added for Bru-HIMS-CRF-087 [IN:029953]
		String outsourcing_def_facility			  =""; //added for Bru-HIMS-CRF-087 [IN:029953]
		String ip_medn_rtn_after_bill_gen ="";	//Added for JD-CRF-0178 [IN:039208]
		String op_medn_rtn_after_bill_gen ="";  //Added for JD-CRF-0178 [IN:039208]
		String financial_details		  =""; //code added for JD-CRF-0156[IN:041737]
		String ip_dflt_disp_stage		  =""; //code added for [IN:047788]
		String op_dflt_disp_stage		  =""; //code added for [IN:047788]
		String dflt_token_series_ind = ""; //added for HSA-CRF-0136 [IN:048412]
		String sort_token_series_ind = ""; //added for HSA-CRF-0136 [IN:048412]
		if(recordSet.containsKey("TRADE_CHANGE_ALLOWED_YN")) {
			if ( recordSet.get("TRADE_CHANGE_ALLOWED_YN").toString().equals("on") )
				trade_change_allowed_yn = "Y" ;
			else
				trade_change_allowed_yn = "N" ;
		}
		if(recordSet.containsKey("ALLOW_MULTI_TRADE_YN")) {
			if ( recordSet.get("ALLOW_MULTI_TRADE_YN").toString().equals("on") )
				allow_multi_trade_yn = "Y" ;
			else
				allow_multi_trade_yn = "N" ;
		}	
		if(recordSet.containsKey("PATIENT_HISTROY_YN")) {
			if ( recordSet.get("PATIENT_HISTROY_YN").toString().equals("on") )
				allow_patient_history_yn = "Y" ;
			else
				allow_patient_history_yn = "N" ;
		}	

		if(recordSet.containsKey("REROUTE_ORDER_YN")) {
			if ( recordSet.get("REROUTE_ORDER_YN").toString().equals("on") )
				re_route_orders = "Y" ;
			else
				re_route_orders = "N" ;
		}	
		if(recordSet.containsKey("GENERAL_YN")) {
			if ( recordSet.get("GENERAL_YN").toString().equals("on") )
				general_yn = "Y" ;
			else
				general_yn = "N" ;
		}
		if(recordSet.containsKey("NARCOTIC_YN")) {
			if ( recordSet.get("NARCOTIC_YN").toString().equals("on") )
				narcotic_yn = "Y" ;
			else
				narcotic_yn = "N" ;
		}
		if(recordSet.containsKey("CONTROLLED_YN")) {
			if ( recordSet.get("CONTROLLED_YN").toString().equals("on") )
				controlled_yn = "Y" ;
			else
				controlled_yn = "N" ;
		}
		if(recordSet.containsKey("REGN_YN")) {
			if ( recordSet.get("REGN_YN").toString().equals("on") )
				regn_yn = "Y" ;
			else
				regn_yn = "N" ;
		}
		if(recordSet.containsKey("VERIFY_YN")) {
			if ( recordSet.get("VERIFY_YN").toString().equals("on") )
				verify_yn = "Y" ;
			else
				verify_yn = "N" ;
		}
		if(recordSet.containsKey("FILL_YN")) {
			if ( recordSet.get("FILL_YN").toString().equals("on") )
				fill_yn = "Y" ;
			else
				fill_yn = "N" ;
		}
		if(recordSet.containsKey("ALLOCATE_YN")) {
			if ( recordSet.get("ALLOCATE_YN").toString().equals("on") )
				allocate_yn = "Y" ;
			else
				allocate_yn = "N" ;
		}
		if(recordSet.containsKey("BILL_RECEIPT_YN")) {
			if ( recordSet.get("BILL_RECEIPT_YN").toString().equals("on") )
				bill_receipt_yn = "Y" ;
			else
				bill_receipt_yn = "N" ;
		}
		if(recordSet.containsKey("DELIVER_YN")) {
			if ( recordSet.get("DELIVER_YN").toString().equals("on") )
				deliver_yn = "Y" ;
			else
				deliver_yn = "N" ;
		}
		if(recordSet.containsKey("ALLOW_REPRINT_YN")) {
			if ( recordSet.get("ALLOW_REPRINT_YN").toString().equals("on") )
				allow_reprint_yn = "Y" ;
			else
				allow_reprint_yn = "N" ;
		}
		if(recordSet.containsKey("NO_OF_REPRINTS")) {
			no_of_reprints = recordSet.get("NO_OF_REPRINTS").toString() ;
		}
		if(recordSet.containsKey("MEDN_RTN_YN")) {
			if ( recordSet.get("MEDN_RTN_YN").toString().equals("on") )
				medn_rtn_yn = "Y" ;
			else
				medn_rtn_yn = "N" ;
		}
		if(recordSet.containsKey("IP_VERIFY_YN")) {
			if ( recordSet.get("IP_VERIFY_YN").toString().equals("on") )
				ip_verify_yn = "Y" ;
			else
				ip_verify_yn = "N" ;
		}
		if(recordSet.containsKey("IP_ALLOCATE_YN")) {
			if ( recordSet.get("IP_ALLOCATE_YN").toString().equals("on") )
				ip_allocate_yn = "Y" ;
			else
				ip_allocate_yn = "N" ;
		}
		if(recordSet.containsKey("IP_DELIVER_YN")) {
			if ( recordSet.get("IP_DELIVER_YN").toString().equals("on") )
				ip_deliver_yn = "Y" ;
			else
				ip_deliver_yn = "N" ;
		}
		if(recordSet.containsKey("IP_ACCEPT_MEDN_RTN_YN")) {
			if ( recordSet.get("IP_ACCEPT_MEDN_RTN_YN").toString().equals("on") )
				ip_accept_medn_rtn_yn = "Y" ;
			else
				ip_accept_medn_rtn_yn = "N" ;
		}
		if(recordSet.containsKey("CHANGE_DOSE_DURN_VERIFY_YN")) {
			if ( recordSet.get("CHANGE_DOSE_DURN_VERIFY_YN").toString().equals("on") )
				change_dose_durn_verify_yn = "Y" ;
			else
				change_dose_durn_verify_yn = "N" ;
		}
		//ADDED FOR ML-MMOH-CRF-0863 START
		
		if(recordSet.containsKey("AUTH_AMEND_PRES_YN")) {
			if ( recordSet.get("AUTH_AMEND_PRES_YN").toString().equals("on") )
				auth_amend_pres_yn = "Y" ;
			else
				auth_amend_pres_yn = "N" ;
		}
		//ADDED FOR ML-MMOH-CRF-0863 END
		if(recordSet.containsKey("OP_REISSUE_MEDICATION_YN")) {
			if ( recordSet.get("OP_REISSUE_MEDICATION_YN").toString().equals("on") )
			op_reissue_medication_yn= "Y" ;
			else
			op_reissue_medication_yn = "N" ;
		}
		if(recordSet.containsKey("IP_REISSUE_MEDICATION_YN")) {
			if ( recordSet.get("IP_REISSUE_MEDICATION_YN").toString().equals("on") )
			ip_reissue_medication_yn = "Y" ;
			else
			ip_reissue_medication_yn = "N" ;
		}
		//Added for CRF-0439
		if(recordSet.containsKey("UNLOCK_RECORDS_YN")) {
			if ( recordSet.get("UNLOCK_RECORDS_YN").toString().equals("on") )
				unlock_records_yn = "Y" ;
			else
				unlock_records_yn = "N" ;
		}		
		 if(recordSet.containsKey("CHK_FILL_LIST")) {// Added for ICN-30405
			 if ( (String) recordSet.get("CHK_FILL_LIST")!=null )
			     dflt_ip_fill =  (String) recordSet.get("CHK_FILL_LIST");
			 else
				dflt_ip_fill = "AF" ;
		}
		if(recordSet.containsKey("CHK_DELIVER_FILL_LIST")) {
			 if ( (String) recordSet.get("CHK_DELIVER_FILL_LIST")!=null)
				dflt_ip_deliver =  (String) recordSet.get("CHK_DELIVER_FILL_LIST");
			else
				dflt_ip_deliver = "DWF" ;   
		}  
		
		if(recordSet.containsKey("TRACK_OUTSOURCING_YN")) {//added for Bru-HIMS-CRF-087 [IN:029953] - Start
			if ( recordSet.get("TRACK_OUTSOURCING_YN").toString().equals("on") )
				track_outsourcing_yn = "Y" ;
			else
				track_outsourcing_yn = "N" ;
		}
		if(recordSet.containsKey("OUTSOURCING_SEND")) {
			if ( recordSet.get("OUTSOURCING_SEND").toString().equals("on") )
				outsourcing_send_yn = "Y" ;
			else
				outsourcing_send_yn = "N" ;
		}
		if(recordSet.containsKey("OUTSOURCING_RECEIVE")) {
			if ( recordSet.get("OUTSOURCING_RECEIVE").toString().equals("on") )
				outsourcing_receive_yn = "Y" ;
			else
				outsourcing_receive_yn = "N" ;
		}
		if(recordSet.containsKey("OUTSOURCING_DELIVER")) {
			if ( recordSet.get("OUTSOURCING_DELIVER").toString().equals("on") )
				outsourcing_deliver_yn = "Y" ;
			else
				outsourcing_deliver_yn = "N" ;
		}
		if(recordSet.containsKey("OUTSOURCING_DEF_ACTION")) {
		     outsourcing_def_action =  recordSet.get("OUTSOURCING_DEF_ACTION")==null?"":(String) recordSet.get("OUTSOURCING_DEF_ACTION");
		}
		if(recordSet.containsKey("OUTSOURCING_DEF_FACILITY")) {
		     outsourcing_def_facility =  recordSet.get("OUTSOURCING_DEF_FACILITY")==null?"":(String) recordSet.get("OUTSOURCING_DEF_FACILITY");
		}	//added for Bru-HIMS-CRF-087 [IN:029953] - End
		if(recordSet.containsKey("IP_MEDN_RTN_AFTER_BILL_GEN")) { // Added for JD-CRF-0178 [IN:039208] -Start
		     ip_medn_rtn_after_bill_gen =  recordSet.get("IP_MEDN_RTN_AFTER_BILL_GEN")==null?"":(String) recordSet.get("IP_MEDN_RTN_AFTER_BILL_GEN");
		}
		if(recordSet.containsKey("OP_MEDN_RTN_AFTER_BILL_GEN")) {
		     op_medn_rtn_after_bill_gen =  recordSet.get("OP_MEDN_RTN_AFTER_BILL_GEN")==null?"":(String) recordSet.get("OP_MEDN_RTN_AFTER_BILL_GEN");
		}	// Added for JD-CRF-0178 [IN:039208] -End
		if(recordSet.containsKey("FINANCIAL_DETAILS_YN")) { //code added for JD-CRF-0156[IN041737] --Start
			if ( recordSet.get("FINANCIAL_DETAILS_YN").toString().equals("on") )
				financial_details = "Y" ;
			else
				financial_details = "N" ;			
		}//code added for JD-CRF-0156[IN041737] --End
		if(recordSet.containsKey("IP_DFLT_DISP_STAGE")) { //Added for  //added for [IN:047788] -Start
		     ip_dflt_disp_stage =  checkForNull((String)recordSet.get("IP_DFLT_DISP_STAGE"));
		}
		if(recordSet.containsKey("OP_DFLT_DISP_STAGE")) { 
		     op_dflt_disp_stage =  checkForNull((String)recordSet.get("OP_DFLT_DISP_STAGE"));
		}//added for [IN:047788] -end
		if(recordSet.containsKey("DFLT_TOKEN_SERIES_IND")) { //added for HSA-CRF-0136 [IN:048412]
		     dflt_token_series_ind =  checkForNull((String)recordSet.get("DFLT_TOKEN_SERIES_IND"));
		}
		if(recordSet.containsKey("SORT_TOKEN_SERIES_IND")) { //added for HSA-CRF-0136 [IN:048412]
		     sort_token_series_ind =  checkForNull((String)recordSet.get("SORT_TOKEN_SERIES_IND"));
		}
		HashMap tabData = new HashMap() ;
		HashMap sqlMap = new HashMap() ;
		tabData.put("result",new Boolean(true));
		tabData.put( "properties", getProperties() );
		
		String oldPassword=recordSet.get("oldPassword").toString();
		boolean updateUser1 = false;

		/* Check if old password and new password matches...and if not update the users */
		if (!user_pwd.equals("")){
			if (!(user_pwd.equals(oldPassword))){
				updateUser1=true;
			}
		}
												
		tabData.put( "general_yn",general_yn) ;
		tabData.put("narcotic_yn", narcotic_yn) ;
		tabData.put( "controlled_yn",controlled_yn) ;
		tabData.put( "regn_yn",regn_yn) ;
		tabData.put( "verify_yn",verify_yn) ;
		tabData.put( "fill_yn",fill_yn) ;
		tabData.put( "allocate_yn",allocate_yn) ;
		tabData.put( "bill_receipt_yn",bill_receipt_yn) ;
		tabData.put( "deliver_yn",deliver_yn) ;
		tabData.put( "allow_reprint_yn",allow_reprint_yn) ;
		tabData.put("no_of_reprints",no_of_reprints) ;
		tabData.put("medn_rtn_yn",medn_rtn_yn) ;
		tabData.put("ip_verify_yn",ip_verify_yn) ;
		tabData.put("ip_allocate_yn",ip_allocate_yn) ;
		tabData.put("ip_deliver_yn",ip_deliver_yn) ;
		tabData.put("login_by_id",login_by_id) ;

		String lwsno=login_at_ws_no;
		if ((lwsno=="")||(lwsno==null)){
			lwsno="temp ws no";
		}
		tabData.put("login_at_ws_no",lwsno) ;
		tabData.put("login_facility_id",login_facility_id) ;
		tabData.put("ip_accept_medn_rtn_yn",ip_accept_medn_rtn_yn) ;
		tabData.put("change_dose_durn_verify_yn",change_dose_durn_verify_yn) ;
		tabData.put("trade_change_allowed_yn",trade_change_allowed_yn) ;
		tabData.put("allow_multi_trade_yn",allow_multi_trade_yn) ;
		tabData.put("login_facility_id",login_facility_id) ;
		tabData.put("disp_locn_code",getDispLocnCode()) ;
		tabData.put("user_id",getUserID()) ;
		tabData.put("newPassword",encryptPass()) ;
		tabData.put("reroute_order_yn",re_route_orders);  
		tabData.put("allow_patient_history_yn",allow_patient_history_yn) ;
		tabData.put("op_reissue_medication_yn",op_reissue_medication_yn) ;
		tabData.put("ip_reissue_medication_yn",ip_reissue_medication_yn) ;
		tabData.put("unlock_records_yn",unlock_records_yn) ;//Added for CRF-0439
		tabData.put("dflt_ip_fill",dflt_ip_fill) ;//Added for ICN-30405
		tabData.put("dflt_ip_deliver",dflt_ip_deliver) ;//Added for ICN-30405
		tabData.put("track_outsourcing_yn",track_outsourcing_yn); //added for Bru-HIMS-CRF-087 [IN:029953] -start
		tabData.put("outsourcing_send_yn",outsourcing_send_yn);
		tabData.put("outsourcing_receive_yn",outsourcing_receive_yn);
		tabData.put("outsourcing_deliver_yn",outsourcing_deliver_yn);
		tabData.put("outsourcing_def_action",outsourcing_def_action);
		tabData.put("outsourcing_def_facility",outsourcing_def_facility);	//added for Bru-HIMS-CRF-087 [IN:029953]- end
		tabData.put("ip_medn_rtn_after_bill_gen",ip_medn_rtn_after_bill_gen);	// Added for JD-CRF-0178 [IN:039208] 
		tabData.put("op_medn_rtn_after_bill_gen",op_medn_rtn_after_bill_gen);	// Added for JD-CRF-0178 [IN:039208] 
		tabData.put("financial_details",financial_details);	//code added for JD-CRF-0156[IN041737]
		tabData.put("ip_dflt_disp_stage",ip_dflt_disp_stage);	//code added for [IN047788]
		tabData.put("op_dflt_disp_stage",op_dflt_disp_stage);	//code added for [IN047788]
		tabData.put("dflt_token_series_ind",dflt_token_series_ind);	//added for HSA-CRF-0136 [IN:048412]
		tabData.put("sort_token_series_ind",sort_token_series_ind);	//added for HSA-CRF-0136 [IN:048412]
		tabData.put("auth_amend_pres_yn",auth_amend_pres_yn) ;//ADDED FOR ML-MMOH-CRF-0863
		// Anyway rights have to be updated
    	try{
			//Modified  for CRF-0439
			//sqlMap.put("SQL_PH_DISP_RIGHTS_UPDATERIGHTS",PhRepository.getPhKeyValue( "SQL_PH_DISP_RIGHTS_UPDATERIGHTS" ));
				//auth_amend_pres_yn added for ml-mmoh-crf-0863
			sqlMap.put("SQL_PH_DISP_RIGHTS_UPDATERIGHTS","update PH_DISP_RIGHTS  set DISP_AUTH_REQD_DRUG_YN=?, DISP_NARCOTIC_YN=?, DISP_CONTROLLED_DRUG_YN=?,  ACK_YN=?, VERIFY_YN=?, FILL_YN=?,ALLOCATE_YN=?, BILL_RECEIPT_YN=?, DELIVER_YN=?, ALLOW_REPRINT_YN=?, NO_OF_REPRINTS=?, ACCEPT_MEDN_RTN_YN=?,  IP_VERIFY_YN=?,IP_ALLOCATE_YN=?,IP_DELIVER_YN=?, MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,IP_ACCEPT_MEDN_RTN_YN=?, CHANGE_DOSE_DURN_VERIFY_YN=?,TRADE_CHANGE_ALLOWED_YN = ?,MULTI_TRADE_ALLOWED_YN= ? ,REROUTE_ORDER_YN = ? ,VIEW_PAT_HIST_YN=? ,OP_REISSUE_MED_YN=?,IP_REISSUE_MED_YN=?,UNLOCK_ALL_RECORDS_YN=?, DFLT_IP_FILL = ?, DFLT_IP_DELIVER = ? , track_outsourcing_yn =?, outsourcing_send_yn =?, outsourcing_receive_yn =?, outsourcing_deliver_yn =?, outsourcing_def_action =?, outsourcing_def_facility =? , ip_medn_rtn_after_bill_gen=?, op_medn_rtn_after_bill_gen=?,CURR_ENC_FINANCIAL_DTL_YN =?, ip_dflt_disp_stage=?, op_dflt_disp_stage=?, dflt_token_series_ind=?, sort_token_series_ind=? ,AUTH_AMEND_PRES_YN =? WHERE FACILITY_ID=? AND DISP_LOCN_CODE=? AND APPL_USER_ID=?"); //ip_dflt_disp_stage=?, op_dflt_disp_stage=?  added for [IN047788]
			if (updateUser1){
				sqlMap.put("SQL_PH_DISP_RIGHTS_UPDATEUSER" ,PhRepository.getPhKeyValue( "SQL_PH_DISP_RIGHTS_UPDATEUSER" ));
			}
		}
		catch(Exception e){
			tabData.put("msgid","Failed to call EJB!! Modify Failed"); 
			System.err.println("UPDATE FAILED: tabData===========>"+tabData);
			e.printStackTrace();
			return tabData;
		}
		clear();
		return callFunctionEJB( tabData,sqlMap );
	}

	/* Over-ridden Adapter methods end here */
	/* This fucntion encrypts the bean password and returns it */
	private String encryptPass() {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String encPass = "";

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISP_RIGHTS_SELECT7" )) ;
			pstmt.setString(1, getPassWord()) ;
			resultSet = pstmt.executeQuery() ;

			while (resultSet.next()) {
				encPass = resultSet.getString("ENCR_PASSWD");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
    			es.printStackTrace();
			}
		}
		return encPass;
	}

	/* This is called from the insert function...contains data to be inserted and the qry */
	private HashMap callFunctionEJB( HashMap tabData , HashMap sqlMap ) {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
	  
		/*DispenseRightsHome home = null;
		DispenseRightsRemote remote = null;*/
		try {

			/*InitialContext context = new InitialContext() ;
			Object object = context.lookup( PhRepository.getPhKeyValue( "JNDI_PH_DISP_RIGHTS" ) ) ;
			home  = (DispenseRightsHome) PortableRemoteObject.narrow( object, DispenseRightsHome.class ) ;
			remote = home.create() ;

			if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) )  )
				map = remote.insert( tabData, sqlMap ) ;
			else if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) )
					map = remote.modify( tabData, sqlMap ) ;
			else if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_DELETE" ) )  )
					map = remote.delete( tabData, sqlMap ) ;*/
		
			Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue("JNDI_PH_DISP_RIGHTS"),DispenseRightsHome.class,getLocalEJB());
			Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]=new Object[2];
			argArray[0]=tabData;
			argArray[1]=sqlMap;

			Class[] paramArray=new Class[2];
			paramArray[0]=tabData.getClass();
			paramArray[1]=sqlMap.getClass();

			if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) )  )
				map=(HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			else if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) )
				map=(HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			else if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_DELETE" ) )  )
				map=(HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			if( ((Boolean) map.get( "result" )).booleanValue() )
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
			else
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH")) ;
		}
		catch(Exception e) {
			map.put( "message", e.getMessage()) ;
			e.printStackTrace() ;
		}
		/*finally {
			try {
				if( remote != null )
					remote.remove() ;
			}
			catch( Exception ee ) {
					map.put( "message", ee.getMessage() ) ;  ee.printStackTrace();
			}
		}*/
		return map;
	}

	public ArrayList getDispLocns() {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList dispLocns = new ArrayList();
		//System.err.println("dispLocns in bean 770---->" +dispLocns);
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISP_RIGHTS_SELECT2" )) ;
			pstmt.setString(1, login_facility_id) ;
			pstmt.setString(2, getLanguageId());
			resultSet = pstmt.executeQuery() ;
			//System.err.println("resultSet in bean 779---->" +resultSet);
			while (resultSet.next()) {
				dispLocns.add(resultSet.getString("DISP_LOCN_CODE"));
				dispLocns.add(resultSet.getString("SHORT_DESC"));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return dispLocns;
	}

	public String getUserPass(String user_id) {
		/* This function returns the old password for the user*/
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String password = "" ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISP_RIGHTS_SELECT4" )) ;
			pstmt.setString(1, user_id) ;
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				password	= resultSet.getString("PASSWORD");
				userExists	= true;
			}
		}
		catch ( Exception e ) {
				e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){ 
				es.printStackTrace();
			}
		}
		return password;
	}
	
	public String getUserPassForLoginUser() {//added for GDOH-CRF-0086 [IN:058551]
		/* This function returns the login password for the user*/
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String password = "" ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( "SELECT APP_PASSWORD.DECRYPT(A.APPL_USER_PASSWORD) PASSWORD FROM sm_appl_user A WHERE A.APPL_USER_ID=?") ;
			pstmt.setString(1, login_by_id) ;
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				password	= resultSet.getString("PASSWORD");
		//		userExists	= true;
			}
		}
		catch ( Exception e ) {
				e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){ 
				es.printStackTrace();
			}
		}
		return password;
	}

	public ArrayList getLocnDetails() {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList locnDetails = new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISP_RIGHTS_SELECT3" )) ;
			pstmt.setString(1, login_facility_id) ;
			pstmt.setString(2, getDispLocnCode()) ;
			pstmt.setString(3, getLanguageId());
			resultSet = pstmt.executeQuery() ;

			while (resultSet.next()) {
				locnDetails.add(checkForNull(resultSet.getString("DISP_GENL_DRUG_YN"), "N")); //0
				locnDetails.add(checkForNull(resultSet.getString("DISP_NARCOTICS_DRUG_YN"), "N"));
				locnDetails.add(checkForNull(resultSet.getString("DISP_CONTROLLED_DRUG_YN"), "N"));
				locnDetails.add(checkForNull(resultSet.getString("DISP_REGN_REQD_YN"), "N"));
				locnDetails.add(checkForNull(resultSet.getString("DISP_FLNG_REQD_YN"), "N"));
				locnDetails.add(checkForNull(resultSet.getString("DISP_CASH_COLL_STAGE"), "N")); //5
				locnDetails.add(checkForNull(resultSet.getString("DISP_DELV_REQD_YN"), "N"));
				locnDetails.add(checkForNull(resultSet.getString("ALLOW_DRUG_RETURN_YN"), "N"));
				locnDetails.add(checkForNull(resultSet.getString("IP_VERF_YN"), "N"));
				locnDetails.add(checkForNull(resultSet.getString("IP_ALLOC_YN"), "N"));
				locnDetails.add(checkForNull(resultSet.getString("IP_DELV_REQD_YN"), "N")); //10
				locnDetails.add(checkForNull(resultSet.getString("DISP_VERF_STAGE"), "N"));
				locnDetails.add(checkForNull(resultSet.getString("IP_ALLOW_DRUG_RETURN_YN"),"N"));
				locnDetails.add(checkForNull(resultSet.getString("ISSUE_TOKEN_ON_REGN_YN"),"N")); //13
				locnDetails.add(checkForNull(resultSet.getString("GENERATE_ACTUAL_TOKEN_YN"),"N")); //14
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){ 
				es.printStackTrace();
			}
		}
		return locnDetails;
	}

	public ArrayList getLocnDtlsForModify() {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList locnDetailsForMod = new ArrayList();

		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISP_RIGHTS_SELECT6" )) ;
			//pstmt = connection.prepareStatement("SELECT B.DISP_GENL_DRUG_YN GEN, A.DISP_AUTH_REQD_DRUG_YN GEN1, B.DISP_NARCOTICS_DRUG_YN NARC, A.DISP_NARCOTIC_YN NARC1, B.DISP_CONTROLLED_DRUG_YN CONT, A.DISP_CONTROLLED_DRUG_YN CONT1, B.DISP_REGN_REQD_YN REGN, A.ACK_YN REGN1, A.VERIFY_YN VERFN1, B.DISP_FLNG_REQD_YN FILL, A.FILL_YN FILL1, A.ALLOCATE_YN ALLOC1, B.DISP_CASH_COLL_STAGE BILL, A.BILL_RECEIPT_YN BILL1, B.DISP_DELV_REQD_YN DELVY, A.DELIVER_YN DELVY1, A.ALLOW_REPRINT_YN PRINT1, A.NO_OF_REPRINTS COPIES1, B.ALLOW_DRUG_RETURN_YN MEDRET, A.ACCEPT_MEDN_RTN_YN MEDRET1, B.IP_VERF_YN IPVERF, A.IP_VERIFY_YN IPVERF1, B.IP_ALLOC_YN IPALLOC, A.IP_ALLOCATE_YN IPALLOC1, B.IP_DELV_REQD_YN IPDELVY, A.IP_DELIVER_YN IPDELVY1,IP_ACCEPT_MEDN_RTN_YN, CHANGE_DOSE_DURN_VERIFY_YN,TRADE_CHANGE_ALLOWED_YN,MULTI_TRADE_ALLOWED_YN,REROUTE_ORDER_YN,VIEW_PAT_HIST_YN FROM PH_DISP_RIGHTS A, PH_DISP_LOCN_LANG_VW B WHERE A.FACILITY_ID=B.FACILITY_ID AND A.DISP_LOCN_CODE=B.DISP_LOCN_CODE AND A.FACILITY_ID=UPPER(?) AND UPPER(A.DISP_LOCN_CODE)=UPPER(?) AND UPPER(A.APPL_USER_ID)=UPPER(?) AND B.LANGUAGE_ID = ?") ;
           //		//auth_amend_pres_yn added for ml-mmoh-crf-0863
			pstmt = connection.prepareStatement("SELECT B.DISP_GENL_DRUG_YN GEN, A.DISP_AUTH_REQD_DRUG_YN GEN1, B.DISP_NARCOTICS_DRUG_YN NARC, A.DISP_NARCOTIC_YN NARC1, B.DISP_CONTROLLED_DRUG_YN CONT, A.DISP_CONTROLLED_DRUG_YN CONT1, B.DISP_REGN_REQD_YN REGN, A.ACK_YN REGN1, A.VERIFY_YN VERFN1, B.DISP_FLNG_REQD_YN FILL, A.FILL_YN FILL1, A.ALLOCATE_YN ALLOC1, B.DISP_CASH_COLL_STAGE BILL, A.BILL_RECEIPT_YN BILL1, B.DISP_DELV_REQD_YN DELVY, A.DELIVER_YN DELVY1, A.ALLOW_REPRINT_YN PRINT1, A.NO_OF_REPRINTS COPIES1, B.ALLOW_DRUG_RETURN_YN MEDRET, A.ACCEPT_MEDN_RTN_YN MEDRET1, B.IP_VERF_YN IPVERF, A.IP_VERIFY_YN IPVERF1, B.IP_ALLOC_YN IPALLOC, A.IP_ALLOCATE_YN IPALLOC1, B.IP_DELV_REQD_YN IPDELVY, A.IP_DELIVER_YN IPDELVY1,IP_ACCEPT_MEDN_RTN_YN,CHANGE_DOSE_DURN_VERIFY_YN,TRADE_CHANGE_ALLOWED_YN,MULTI_TRADE_ALLOWED_YN,REROUTE_ORDER_YN,VIEW_PAT_HIST_YN,OP_REISSUE_MED_YN,IP_REISSUE_MED_YN,UNLOCK_ALL_RECORDS_YN,DFLT_IP_FILL,DFLT_IP_DELIVER, track_outsourcing_yn, outsourcing_send_yn, outsourcing_receive_yn, outsourcing_deliver_yn, outsourcing_def_action, outsourcing_def_facility, ip_medn_rtn_after_bill_gen, op_medn_rtn_after_bill_gen,CURR_ENC_FINANCIAL_DTL_YN, ip_dflt_disp_stage, op_dflt_disp_stage, dflt_token_series_ind, sort_token_series_ind,auth_amend_pres_yn FROM PH_DISP_RIGHTS A, PH_DISP_LOCN_LANG_VW B WHERE A.FACILITY_ID=B.FACILITY_ID AND A.DISP_LOCN_CODE=B.DISP_LOCN_CODE AND A.FACILITY_ID=UPPER(?) AND UPPER(A.DISP_LOCN_CODE)=UPPER(?) AND UPPER(A.APPL_USER_ID)=UPPER(?) AND B.LANGUAGE_ID = ?") ;
			pstmt.setString(1, login_facility_id.trim()) ;
			pstmt.setString(2, getDispLocnCode().trim()) ;
			pstmt.setString(3, getUserID().trim()) ;
			pstmt.setString(4, getLanguageId());

			resultSet = pstmt.executeQuery() ;

			while (resultSet.next()) {
				locnDetailsForMod.add(checkForNull(resultSet.getString("GEN"), "N")); //0
				locnDetailsForMod.add(checkForNull(resultSet.getString("NARC"), "N"));
				locnDetailsForMod.add(checkForNull(resultSet.getString("CONT"), "N"));
				locnDetailsForMod.add(checkForNull(resultSet.getString("GEN1"), "N"));
				locnDetailsForMod.add(checkForNull(resultSet.getString("NARC1"), "N"));
				locnDetailsForMod.add(checkForNull(resultSet.getString("CONT1"), "N"));
				locnDetailsForMod.add(checkForNull(resultSet.getString("REGN"), "N"));
				locnDetailsForMod.add(checkForNull(resultSet.getString("REGN1"), "N"));
				locnDetailsForMod.add(checkForNull(resultSet.getString("VERFN1"), "N"));
				locnDetailsForMod.add(checkForNull(resultSet.getString("FILL"), "N"));//9
				locnDetailsForMod.add(checkForNull(resultSet.getString("FILL1"), "N")); //10
				locnDetailsForMod.add(checkForNull(resultSet.getString("ALLOC1"), "N"));
				locnDetailsForMod.add(checkForNull(resultSet.getString("BILL"), "N"));
				locnDetailsForMod.add(checkForNull(resultSet.getString("BILL1"), "N"));
				locnDetailsForMod.add(checkForNull(resultSet.getString("DELVY"), "N"));
				locnDetailsForMod.add(checkForNull(resultSet.getString("DELVY1"), "N"));
				locnDetailsForMod.add(checkForNull(resultSet.getString("PRINT1"), "N"));
				locnDetailsForMod.add(checkForNull(resultSet.getString("COPIES1"), ""));
				locnDetailsForMod.add(checkForNull(resultSet.getString("MEDRET"), "N"));
				locnDetailsForMod.add(checkForNull(resultSet.getString("MEDRET1"), "N"));//19
				locnDetailsForMod.add(checkForNull(resultSet.getString("IPVERF"), "N"));//20
				locnDetailsForMod.add(checkForNull(resultSet.getString("IPVERF1"), "N"));
				locnDetailsForMod.add(checkForNull(resultSet.getString("IPALLOC"), "N"));
				locnDetailsForMod.add(checkForNull(resultSet.getString("IPALLOC1"), "N"));
				locnDetailsForMod.add(checkForNull(resultSet.getString("IPDELVY"), "N"));
				locnDetailsForMod.add(checkForNull(resultSet.getString("IPDELVY1"), "N"));
				locnDetailsForMod.add(checkForNull(resultSet.getString("IP_ACCEPT_MEDN_RTN_YN"), "N"));
				locnDetailsForMod.add(checkForNull(resultSet.getString("CHANGE_DOSE_DURN_VERIFY_YN"), "N"));
				
				locnDetailsForMod.add(checkForNull(resultSet.getString("TRADE_CHANGE_ALLOWED_YN"), "N"));
				locnDetailsForMod.add(checkForNull(resultSet.getString("MULTI_TRADE_ALLOWED_YN"), "N"));
				locnDetailsForMod.add(checkForNull(resultSet.getString("REROUTE_ORDER_YN"),"N"));//30
				locnDetailsForMod.add(checkForNull(resultSet.getString("VIEW_PAT_HIST_YN"),"N"));
				locnDetailsForMod.add(checkForNull(resultSet.getString("OP_REISSUE_MED_YN"),"N"));
				locnDetailsForMod.add(checkForNull(resultSet.getString("IP_REISSUE_MED_YN"),"N"));
				locnDetailsForMod.add(checkForNull(resultSet.getString("UNLOCK_ALL_RECORDS_YN"),"N"));//Added for CRF0439
				locnDetailsForMod.add(checkForNull(resultSet.getString("DFLT_IP_FILL"),"AF"));//Added for ICN-30405
				locnDetailsForMod.add(checkForNull(resultSet.getString("DFLT_IP_DELIVER"),"DWF"));//Added for ICN-30405 //36

				locnDetailsForMod.add(checkForNull(resultSet.getString("TRACK_OUTSOURCING_YN"),"N"));//added for Bru-HIMS-CRF-087 [IN:029953] 
				locnDetailsForMod.add(checkForNull(resultSet.getString("OUTSOURCING_SEND_YN"),"N"));//added for Bru-HIMS-CRF-087 [IN:029953]
				locnDetailsForMod.add(checkForNull(resultSet.getString("OUTSOURCING_RECEIVE_YN"),"N"));//added for Bru-HIMS-CRF-087 [IN:029953]
				locnDetailsForMod.add(checkForNull(resultSet.getString("OUTSOURCING_DELIVER_YN"),"N"));//added for Bru-HIMS-CRF-087 [IN:029953] //40
				locnDetailsForMod.add(checkForNull(resultSet.getString("OUTSOURCING_DEF_ACTION"),"N"));//added for Bru-HIMS-CRF-087 [IN:029953] 
				locnDetailsForMod.add(checkForNull(resultSet.getString("OUTSOURCING_DEF_FACILITY"),"N"));//added for Bru-HIMS-CRF-087 [IN:029953] 
				locnDetailsForMod.add(checkForNull(resultSet.getString("IP_MEDN_RTN_AFTER_BILL_GEN"),""));//added for  JD-CRF-0178 [IN:039208]//43
				locnDetailsForMod.add(checkForNull(resultSet.getString("OP_MEDN_RTN_AFTER_BILL_GEN"),""));//added for  JD-CRF-0178 [IN:039208] //44
				locnDetailsForMod.add(checkForNull(resultSet.getString("CURR_ENC_FINANCIAL_DTL_YN"),"N"));//code added for JD-CRF-0156[IN:041737]//45
				locnDetailsForMod.add(checkForNull(resultSet.getString("IP_DFLT_DISP_STAGE"),""));//code added for [IN:047788] //46
				locnDetailsForMod.add(checkForNull(resultSet.getString("OP_DFLT_DISP_STAGE"),""));//code added for J[IN:047788] //47
				locnDetailsForMod.add(checkForNull(resultSet.getString("DFLT_TOKEN_SERIES_IND"),"W"));//code added for HSA-CRF-0136 [IN:048412] //48 
				locnDetailsForMod.add(checkForNull(resultSet.getString("sort_token_series_ind"),"O"));//code added for HSA-CRF-0136 [IN:048412] //48 
				locnDetailsForMod.add(checkForNull(resultSet.getString("auth_amend_pres_yn"),"N"));//code added for ml-mmoh-crf-0863
				
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return locnDetailsForMod;
	}

	/*private String checkForNull(String inputString, String defaultValue) {
		return (inputString==null) ? defaultValue : inputString;
	}*/

	private HashMap localModify( HashMap tabData , HashMap sqlMap ) {
		HashMap result=new HashMap();
		result.put( "result", new Boolean( false ) ) ;
		result.put( "flag", "0" ) ;
		result.put( "msgid", "here" ) ;
		Connection connection=null;
		PreparedStatement pstmt_update_users=null;
		PreparedStatement pstmt_rights=null;
		ResultSet resultSet=null;
		String str="jj";
		
    	try{
			connection=getConnection();
			pstmt_rights = connection.prepareStatement((String) sqlMap.get( "SQL_PH_DISP_RIGHTS_UPDATERIGHTS" )) ;
			pstmt_rights.setString(1,(String)tabData.get("general_yn")) ;
			pstmt_rights.setString(2,(String) tabData.get("narcotic_yn")) ;
			pstmt_rights.setString(3,(String)tabData.get("controlled_yn")) ;
			pstmt_rights.setString(4,(String)tabData.get("regn_yn")) ;
			pstmt_rights.setString(5,(String)tabData.get("verify_yn")) ;
			pstmt_rights.setString(6,(String)tabData.get("fill_yn")) ;
			pstmt_rights.setString(7,(String)tabData.get("allocate_yn")) ;
			pstmt_rights.setString(8,(String)tabData.get("bill_receipt_yn")) ;
			pstmt_rights.setString(9,(String) tabData.get("deliver_yn")) ;
			pstmt_rights.setString(10,(String)tabData.get("allow_reprint_yn")) ;
			pstmt_rights.setString(11,(String)tabData.get("no_of_reprints")) ;
			pstmt_rights.setString(12,(String)tabData.get("medn_rtn_yn")) ;
			pstmt_rights.setString(13,(String)tabData.get("ip_verify_yn")) ;
			pstmt_rights.setString(14,(String) tabData.get("ip_allocate_yn")) ;
			pstmt_rights.setString(15,(String) tabData.get("ip_deliver_yn")) ;
			pstmt_rights.setString(16,(String)tabData.get("login_by_id")) ;
			pstmt_rights.setString(17,(String)tabData.get("login_at_ws_no")) ;
			pstmt_rights.setString(18,(String)tabData.get("login_facility_id")) ;
			pstmt_rights.setString(19,(String)tabData.get("login_facility_id")) ;
			pstmt_rights.setString(20,(String) tabData.get("disp_locn_code")) ;
			pstmt_rights.setString(21,(String)tabData.get("user_id")) ;

			resultSet = pstmt_rights.executeQuery() ;

			if (sqlMap.containsKey("SQL_PH_DISP_RIGHTS_UPDATEUSER")){
				pstmt_update_users = connection.prepareStatement((String) sqlMap.get( "SQL_PH_DISP_RIGHTS_UPDATEUSER" )) ;
				pstmt_update_users.setString(1,(String)tabData.get("newPassword"));
				pstmt_update_users.setString(2,(String)tabData.get("user_id")) ;
				pstmt_update_users.executeQuery();
				closeStatement(pstmt_update_users);
			}
		   connection.commit();
		   result.put("msgid","Operation completed Successfully!!!");
    	}
		catch (Exception e){
			e.printStackTrace();
			result.put("msgid","vvv"+str);
			try{
				connection.rollback();
			}
			catch (Exception e1){
				result.put("msgid","Error during Update!!! Transaction Rolled Back"); e1.printStackTrace();
			}
		}
		finally{
			try{
				closeResultSet(resultSet);
				closeStatement(pstmt_update_users);
				closeStatement(pstmt_rights);
				closeConnection(connection);
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}

	public HashMap localDelete(HashMap tabData , HashMap sqlMap){
		HashMap result = new HashMap() ;		
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		//		int delrows=0;
		//		int delusers=0;
		result.put("result",new Boolean(false));
		/* Performing delete operation */
		try {
			connection = getConnection() ;
			//this query deletes rights for the user
			pstmt = connection.prepareStatement( (String)sqlMap.get( "SQL_PH_DISP_RIGHTS_DELETERIGHTS" )) ;
			pstmt.setString(1,(String)tabData.get("login_facility_id"));
			pstmt.setString(2,(String)tabData.get("disp_locn_code"));
			pstmt.setString(3,(String)tabData.get("user_id"));
			//delrows = 
			pstmt.executeUpdate() ;
			closeStatement(pstmt);
			pstmt = connection.prepareStatement((String)sqlMap.get("SQL_PH_DISP_RIGHTS_DELETEUSERS" )) ;
			//delusers=
			pstmt.executeUpdate();
			connection.commit();
			//	result.put("msgid","Operation Completed Successfully!!!");
			result.put("msgid",getMessage(getLanguageId(), "RECORD_DELETED" ,"PH"));
		}
		catch (Exception e) {
			e.printStackTrace();
			try	{
				connection.rollback();
				result.put("msgid",getMessage(getLanguageId(), "TRANSACTION_FAILED","PH") );
				return tabData;
			}
			catch (Exception e1){
				result.put("message",getMessage(getLanguageId(),"TRANSACTION_FAILED" ,"PH") ); 
				e1.printStackTrace();
			}
		}
		finally{
			try{
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch (Exception ex){
				System.err.println("Error while closing statements and resultsets"+ex.toString());  
				ex.printStackTrace();
			}
		}
		return result;
	}
	/* Called from callejb fucntion to perform the actual insert into the table */
	private HashMap localInsert( HashMap tabData , HashMap sqlMap ){
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		map.put( "msgid", "" ) ;
		Connection connection					= null ;
		PreparedStatement pstmt_rights			= null ;
		PreparedStatement pstmt_update_users	= null ;
		PreparedStatement pstmt_insert_users	= null ;
		PreparedStatement pstmt_rights_exist=null;

		boolean continue_flag = false;
		int count=0;
		ResultSet resultSet = null ;
		try {
			ArrayList insertData	= (ArrayList)tabData.get( "INSERTRIGHTS" );
			ArrayList insertData1	= (ArrayList)tabData.get( "INSERTUSERS" ) ;
			connection	= getConnection() ;
			/* We check if for the same user,displocncode,facility combination a record already exists in the PH_DISP_RIGHTs table*/
			pstmt_rights_exist=connection.prepareStatement((String) sqlMap.get( "SQLDISPRIGHTS"));
			pstmt_rights_exist.setString(1,(String)insertData.get(0));
			pstmt_rights_exist.setString(2,(String)insertData.get(1));
			pstmt_rights_exist.setString(3,(String)insertData.get(2));
			resultSet =pstmt_rights_exist.executeQuery() ;
			while (resultSet.next()) {
				count=resultSet.getInt("COUNT1");
			}
			if (count!=0) {
				//map.put( "msgid", "Dispense Rights already exists for this Dispense Location!!!" );
				map.put( "msgid", getMessage(getLanguageId(),(String) map.get( "RECORD_EXISTS" ),"Common") );
				return map;
			}
			/* IF no records exist in ph_disp_rights continue with the insertion process */
			
			pstmt_rights	= connection.prepareStatement( (String) sqlMap.get( "SQLINSERTRIGHTS" ) ) ;
			if (sqlMap.containsKey( "SQLINSERTUSERS" )) {
				pstmt_insert_users	= connection.prepareStatement( (String) sqlMap.get( "SQLINSERTUSERS" ) ) ;
			}//end of if sqlinsertusers
			else if (sqlMap.containsKey( "SQLUPDATEUSERS" )) {
				pstmt_update_users	= connection.prepareStatement( (String) sqlMap.get( "SQLUPDATEUSERS" ) ) ;
			}//end of sql update users
			pstmt_rights.setString(1,	(String)insertData.get(0));
			pstmt_rights.setString(2,	(String)insertData.get(1));
			pstmt_rights.setString(3,	(String)insertData.get(2));
			pstmt_rights.setString(4,	(String)insertData.get(3));
			pstmt_rights.setString(5,	(String)insertData.get(4));
			pstmt_rights.setString(6,	(String)insertData.get(5));
			pstmt_rights.setString(7,	(String)insertData.get(6));
			pstmt_rights.setString(8,	(String)insertData.get(7));
			pstmt_rights.setString(9,	(String)insertData.get(8));
			pstmt_rights.setString(10,	(String)insertData.get(9));
			pstmt_rights.setString(11,	(String)insertData.get(10));
			pstmt_rights.setString(12,	(String)insertData.get(11));
			pstmt_rights.setString(13,	(String)insertData.get(12));
			pstmt_rights.setString(14,	(String)insertData.get(13));
			pstmt_rights.setString(15,	(String)insertData.get(14));
			pstmt_rights.setString(16,	(String)insertData.get(15));
			pstmt_rights.setString(17,	(String)insertData.get(16));
			pstmt_rights.setString(18,	(String)insertData.get(17));
			pstmt_rights.setString(19,	(String)insertData.get(18));
			pstmt_rights.setString(20,	(String)insertData.get(19));
			pstmt_rights.setString(21,	(String)insertData.get(20));
			pstmt_rights.setString(22,	(String)insertData.get(21));
			pstmt_rights.setString(23,	(String)insertData.get(22));
			pstmt_rights.setString(24,	(String)insertData.get(23));
			int result = pstmt_rights.executeUpdate() ;
			if ( result<1 ) {
				connection.rollback();
				map.put( "msgid", "Insert Failed!!!Transaction rolled back!!!" ) ;
			}
			else {
				continue_flag = true ;
			}
			if (continue_flag) {
				int result1 = 1;
				if (pstmt_insert_users != null ) {
					pstmt_insert_users.setString(1,	(String)insertData1.get(0));
					pstmt_insert_users.setString(2,	(String)insertData1.get(1));
					pstmt_insert_users.setString(3,	(String)insertData1.get(2));
					pstmt_insert_users.setString(4,	(String)insertData1.get(3));
					pstmt_insert_users.setString(5,	(String)insertData1.get(4));
					pstmt_insert_users.setString(6,	(String)insertData1.get(5));
					pstmt_insert_users.setString(7,	(String)insertData1.get(6));
					pstmt_insert_users.setString(8,	(String)insertData1.get(7));
					pstmt_insert_users.setString(9,	(String)insertData1.get(8));
					result1 = pstmt_insert_users.executeUpdate() ;
				}
				else if (pstmt_update_users != null) {
					pstmt_update_users.setString(1,	(String)insertData1.get(0));
					pstmt_update_users.setString(2,	(String)insertData1.get(1));
					result1 = pstmt_update_users.executeUpdate() ;
				}
				if ( result1<1 ) {
					connection.rollback();
				//	map.put( "msgid", "Insert Failed!!!Transaction rolled back" ) ;
					map.put( "msgid",getMessage(getLanguageId(),(String) map.get( "TRANSACTION_FAILED" ),"PH") ) ;
					
					//throw new EJBException("Insert Failed");
				}
				else {
					map.put( "result", new Boolean( true ) ) ;
					//map.put( "msgid", "Operation Completed Successfully!!!" ) ;
					map.put( "msgid", getMessage(getLanguageId(),(String) map.get( "RECORD_INSERTED" ),"PH") ) ;
					connection.commit();
				}
			}
			else {
				map.put( "result", new Boolean( true ) ) ;
			//	map.put( "msgid", "Operation Completed Successfully!!!" ) ;
				map.put( "msgid", getMessage(getLanguageId(),(String) map.get( "RECORD_INSERTED" ),"PH") ) ;
				connection.commit();
			}
		}//end of try
		catch( Exception e ) {
			//map.put( "msgid", "Exception in EJB : " +e.getMessage() ) ;
			map.put( "msgid", getMessage(getLanguageId(),(String) map.get( "EXCEPTION_OCCURED_WHILE_INSERTION" ),"PH") ) ;
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement( pstmt_rights ) ;
				closeStatement( pstmt_update_users ) ;
				closeStatement( pstmt_insert_users ) ;
				closeStatement( pstmt_rights_exist ) ;
				closeConnection( connection );
			}
			catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}
		return map ;
	}

	// Raghunath
	// We are getting the Dispense Stages from PH_PARAM Table....
	public Hashtable getLegendsFromParam()throws Exception{
		Hashtable param_legends = new Hashtable();
		Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT35") ) ;
			pstmt.setString(1, getLanguageId());
			resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				param_legends.put("V",resultSet.getString("VERIFY_STAGE_PROMPT"));
				param_legends.put("A",resultSet.getString("ALLOCATE_STAGE_PROMPT"));
				param_legends.put("F",resultSet.getString("FILL_STAGE_PROMPT"));
				param_legends.put("B",resultSet.getString("BILL_RECEIPT_STAGE_PROMPT"));
				param_legends.put("D",resultSet.getString("DELIVER_STAGE_PROMPT"));
				param_legends.put("R",resultSet.getString("REGN_STAGE_PROMPT"));
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
                closeConnection( connection );
            }
            catch(Exception es) { 
				es.printStackTrace();
			}
        }		
		return param_legends;
	}

	public String getDispLocnCategory() {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String result="";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISP_RIGHTS_SELECT8" )) ;
			pstmt.setString(1, getDispLocnCode()) ;
			resultSet = pstmt.executeQuery() ;
			if (resultSet.next()) {
				result = resultSet.getString("DISP_LOCN_CATEGORY");
			}
			//System.err.println("resultSet in getDispLocnCategory in bean 1309---->" +result);
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return result;
	}
	////added for Bru-HIMS-CRF-087 [IN:029953] - start
	public ArrayList getReferralFacilities() {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList referralFcy = new ArrayList();
		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ORDER_ROUTING_SELECT1A" )) ;
			
			pstmt.setString(1,login_facility_id.trim());
			pstmt.setString(2,getLanguageId());
			resultSet = pstmt.executeQuery() ;			

			while (resultSet.next()) {
				referralFcy.add(resultSet.getString("FACILITY_ID"));
				referralFcy.add(resultSet.getString("FACILITY_NAME"));
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
				es.printStackTrace() ;
			}
		}
		return referralFcy;
	}
	////added for Bru-HIMS-CRF-087 [IN:029953] - end
}//end of class
