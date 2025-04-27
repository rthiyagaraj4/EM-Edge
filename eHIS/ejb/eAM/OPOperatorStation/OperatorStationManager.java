/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM.OPOperatorStation ;

import java.rmi.* ;
import javax.ejb.* ;

import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
//import java.util.Properties;




/**
*
* @ejb.bean
*	name="OPOperatorStation"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="OPOperatorStation"
*	local-jndi-name="OPOperatorStation"
*	impl-class-name="eAM.OPOperatorStation.OperatorStationManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eAM.OPOperatorStation.OperatorStationLocal"
*	remote-class="eAM.OPOperatorStation.OperatorStationRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eAM.OPOperatorStation.OperatorStationLocalHome"
*	remote-class="eAM.OPOperatorStation.OperatorStationHome"
*	generate= "local,remote"
*
*
*/





public class OperatorStationManager implements SessionBean{

	Connection con ;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public final String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS" ;
	public final String RECORD_INSERTED = "RECORD_INSERTED" ;
	public final String RECORD_MODIFIED = "RECORD_MODIFIED" ;
	public final String RECORD_DELETED = "RECORD_DELETED" ;
	//SessionContext ctx;

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) 
	{
		context=context;//for avoiding PMD violation
	}
/**
* @ejb.interface-method
*	 view-type="both"
*/
	public java.util.HashMap insertOPOperatorStation(java.util.HashMap hashmap){
			java.util.HashMap results = new java.util.HashMap() ;

	try{
		java.util.Properties p						=(java.util.Properties) hashmap.get("p");
		String facilityId					=(String)hashmap.get("facility_id");
	//	String effectiveDateFrom			=(String)hashmap.get("effectiveDateFrom");
	//	String effectiveDateTo				=(String)hashmap.get("effectiveDateTo");
		String effectiveStatus				=(String)hashmap.get("effectiveStatus");
		String client_ip_address			=(String)hashmap.get("client_ip_address");
		String oper_stn_id					=(String)hashmap.get("oper_stn_id");
		
		String long_desc				 	=(String)hashmap.get("long_desc");
		String short_desc					=(String)hashmap.get("short_desc");
		String nurs_unit_code				=(String)hashmap.get("nurs_unit_code");
		String shift_operated_yn			=(String)hashmap.get("shift_operated_yn");
		String shift_group					=(String)hashmap.get("shift_group");
		String ws_no						=(String)hashmap.get("ws_no");
		String book_appt_yn					=(String)hashmap.get("book_appt_yn");
		String book_appt_wo_pid_yn			=(String)hashmap.get("book_appt_wo_pid_yn");
		String obook_appt_yn				=(String)hashmap.get("obook_appt_yn");
		String book_appt_across_catg_yn		=(String)hashmap.get("book_appt_across_catg_yn");
		String tfr_appt_yn					=(String)hashmap.get("tfr_appt_yn");
		String tfr_appt_across_catg_yn		=(String)hashmap.get("tfr_appt_across_catg_yn");
		String CONFIRM_BOOKING_YN			=(String)hashmap.get("CONFIRM_BOOKING_YN");
		String CREATE_BOOKING_WITH_CONF_YN	=(String)hashmap.get("CREATE_BOOKING_WITH_CONF_YN");
		String canc_appt_yn					=(String)hashmap.get("canc_appt_yn");
		String register_visit_yn			=(String)hashmap.get("register_visit_yn");
		String register_pat_yn				=(String)hashmap.get("register_pat_yn");
		String cancel_visit_yn				=(String)hashmap.get("cancel_visit_yn");
		String revise_visit_yn				=(String)hashmap.get("revise_visit_yn");
		String manage_queue_yn				=(String)hashmap.get("manage_queue_yn");
		String checkout_pat_yn				=(String)hashmap.get("checkout_pat_yn");
		String oper_stn_type				=(String)hashmap.get("oper_stn_type");
		String create_booking_yn			=(String)hashmap.get("create_booking_yn");
		String revise_booking_yn			=(String)hashmap.get("revise_booking_yn");
		String canc_booking_yn				=(String)hashmap.get("canc_booking_yn");
		String reject_admission_yn			=(String)hashmap.get("reject_admission_yn");
		String admit_pat_yn					=(String)hashmap.get("admit_pat_yn");
		String register_pat_in_admn_yn		=(String)hashmap.get("register_pat_in_admn_yn");
		String assign_bed_yn				=(String)hashmap.get("assign_bed_yn");
		String assign_treat_pract_yn		=(String)hashmap.get("assign_treat_pract_yn");
		String canc_admission_yn			=(String)hashmap.get("canc_admission_yn");
		String emergency_tfr_yn				=(String)hashmap.get("emergency_tfr_yn");
		String routine_tfr_yn				=(String)hashmap.get("routine_tfr_yn");
		String discharge_pat_yn				=(String)hashmap.get("discharge_pat_yn");
		String revise_leave_yn				=(String)hashmap.get("revise_leave_yn");
		String check_lodger_yn				=(String)hashmap.get("check_lodger_yn");
		String block_bed_yn					=(String)hashmap.get("block_bed_yn");
		String release_bed_yn				=(String)hashmap.get("release_bed_yn");
		String register_visit_walkin_yn		=(String)hashmap.get("register_visit_walkin_yn");
		String register_visit_referral_yn	=(String)hashmap.get("register_visit_referral_yn");
		String SWAP_BED_YN					=(String)hashmap.get("SWAP_BED_YN");
		String TRANSFER_OUT_PATIENT_YN		=(String)hashmap.get("TRANSFER_OUT_PATIENT_YN");
		String TRANSFER_IN_PATIENT_YN		=(String)hashmap.get("TRANSFER_IN_PATIENT_YN");
		String CHG_NURS_UNIT_IN_ASSIGN_BED_YN=(String)hashmap.get("CHG_NURS_UNIT_IN_ASSIGN_BED_YN");
		String ADMIT_PATIENT_WITH_BED_YN	=(String)hashmap.get("ADMIT_PATIENT_WITH_BED_YN");
		String FORCED_BOOK_APPT_YN			=(String)hashmap.get("FORCED_BOOK_APPT_YN");
		String GLOBAL_BOOK_APPT_YN			=(String)hashmap.get("GLOBAL_BOOK_APPT_YN");
		String canc_req_yn					=(String)hashmap.get("canc_req_yn");
		String cfrm_req_yn					=(String)hashmap.get("cfrm_req_yn");
		String can_tfr_out_yn				=(String)hashmap.get("can_tfr_out_yn");
		String pract_tfr_yn					=(String)hashmap.get("pract_tfr_yn");
		//9/16/2008 get the value from hsah map
		String cancel_reBeds_yn					=(String)hashmap.get("CANCEL_RESERVE_BED_YN");

		String dchrg_adv_yn					=(String)hashmap.get("dchrg_adv_yn");
		String BED_CLASS_CHANGE_YN			=(String)hashmap.get("BED_CLASS_CHANGE_YN");
		String BACKDATED_ADMISSION_YN		=(String)hashmap.get("BACKDATED_ADMISSION_YN");
        String create_wait_list_yn			=(String)hashmap.get("create_wait_list_yn");
		String modify_wait_list_yn			=(String)hashmap.get("modify_wait_list_yn");
		String cancel_wait_list_yn			=(String)hashmap.get("cancel_wait_list_yn");
		String LINK_BABY_TO_MOTHER_YN		=(String)hashmap.get("LINK_BABY_TO_MOTHER_YN");
		String REG_NEWBORN_FOR_IP_YN		=(String)hashmap.get("REG_NEWBORN_FOR_IP_YN");
		String DISCHARGE_CHECKLIST_YN		=(String)hashmap.get("DISCHARGE_CHECKLIST_YN");
		String RESERVE_BED_BAY_YN			=(String)hashmap.get("RESERVE_BED_BAY_YN");
		String RELEASE_BED_BAY_YN			=(String)hashmap.get("RELEASE_BED_BAY_YN");
		
		String REG_IP_REFERRAL_YN			=(String)hashmap.get("REG_IP_REFERRAL_YN");
		String CONFIRM_BEDSIDE_REFERRAL_YN			=(String)hashmap.get("CONFIRM_BEDSIDE_REFERRAL_YN");
		String CANCEL_DISCHARGE_YN			=(String)hashmap.get("CANCEL_DISCHARGE_YN");

		String OVERRIDE_WALKIN_YN			=(String)hashmap.get("OVERRIDE_WALKIN_YN");

		String CANCEL_CHECKOUT_YN			=(String)hashmap.get("CANCEL_CHECKOUT_YN");

	    String DIAG_PROC_RECODE_FOR_IP_YN			=(String)hashmap.get("DIAG_PROC_RECODE_FOR_IP_YN");
        String DIAG_PROC_RECODE_FOR_OP_YN			=(String)hashmap.get("DIAG_PROC_RECODE_FOR_OP_YN");
        String emergency_transfer_yn			    =(String)hashmap.get("emergency_transfer_yn");
        String MAINTAIN_DEATH_REGISTER_YN			    =(String)hashmap.get("MAINTAIN_DEATH_REGISTER_YN");
		String revise_admission_yn		=(String)hashmap.get("revise_admission_yn");
		
		/*Below line Added for this CRF Bru-HIMS-CRF-261*/
		String quick_admission_yn			    =(String)hashmap.get("quick_admission_yn"); 
		

		boolean result = false ;
		boolean insertable = true ;	
		StringBuffer sb = new StringBuffer( "" ) ;
		String addedById = p.getProperty( "login_user" ) ;
		String addedDate = dateFormat.format( new java.util.Date() ) ;
		String modifiedById = addedById ;
		String modifiedDate = addedDate ;
		String modifiedFacilityId = facilityId ;
		String addedAtWorkstation=client_ip_address;
		String modifiedAtWorkstation = addedAtWorkstation ;
		Date added_date = Date.valueOf( addedDate ) ;
		Date modified_date = Date.valueOf( modifiedDate ) ;
		String locale="";
		locale= p.getProperty("LOCALE"); 
		hashmap.clear();

		try {
			con=ConnectionManager.getConnection(p);
			final String duplicateSql = "select 1 from  am_oper_stn where facility_id = ? and oper_stn_id = ?" ;
			pstmt = con.prepareStatement(duplicateSql ) ;
			pstmt.setString( 1, facilityId ) ;
			pstmt.setString( 2, oper_stn_id ) ;
			rs = pstmt.executeQuery() ;
			if ( rs.next() ){
				insertable = false ;
				java.util.Hashtable message = MessageManager.getMessage( locale, CODE_ALREADY_EXISTS ,"Common") ;
				sb.append( (String) message.get("message") ) ;
				message.clear();
				con.commit();
			}
		} 
		catch ( Exception e )
			{

			insertable = false ;
			sb.append( e.getMessage() + "<br>" ) ;
			e.printStackTrace() ;
			if (con != null){
					try { con.rollback(); } 
		catch (Exception ee) 
			{
			ee.printStackTrace();
		    }
		   }
		}
		if ( insertable ) {
			try {
				String eff_status=effectiveStatus;
				nurs_unit_code="N";
				String sql = "insert into am_oper_stn(facility_id,oper_stn_id,long_desc,short_desc,nurs_unit_code,shift_operated_yn,shift_group,ws_no,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,eff_status,book_appt_yn,book_appt_wo_pid_yn,obook_appt_yn,book_appt_across_catg_yn,tfr_appt_yn,tfr_appt_across_catg_yn,CONFIRM_BOOKING_YN,CREATE_BOOKING_WITH_CONF_YN,canc_appt_yn,register_visit_yn,register_pat_yn,cancel_visit_yn,revise_visit_yn,manage_queue_yn,checkout_pat_yn,oper_stn_type,create_booking_yn,revise_booking_yn,canc_booking_yn,reject_admission_yn,admit_pat_yn,register_pat_in_admn_yn,assign_bed_yn,assign_treat_pract_yn,canc_admission_yn,emergency_tfr_yn,routine_tfr_yn,discharge_pat_yn,revise_leave_yn,check_lodger_yn,block_bed_yn,release_bed_yn,register_visit_walkin_yn,register_visit_referral_yn,SWAP_BED_YN,TRANSFER_OUT_PATIENT_YN,TRANSFER_IN_PATIENT_YN,CHG_NURS_UNIT_IN_ASSIGN_BED_YN,ADMIT_PATIENT_WITH_BED_YN,FORCED_BOOK_APPT_YN,GLOBAL_BOOK_APPT_YN, CANCEL_REQUEST_YN,CONFIRM_REQUEST_YN,CANCEL_TRANSFER_OUT_YN,PRACT_TRANSFER_YN,DISCHARGE_ADVICE_YN,BED_CLASS_CHANGE_YN,BACKDATED_ADMISSION_YN,CREATE_WAIT_LIST_YN,MODIFY_WAIT_LIST_YN, CANCEL_WAIT_LIST_YN,LINK_BABY_TO_MOTHER_YN,REG_NEWBORN_FOR_IP_YN,DISCHARGE_CHECKLIST_YN,RESERVE_BED_BAY_YN,RELEASE_BED_BAY_YN,DIAG_PROC_RECODE_FOR_OP_YN,REG_IP_REFERRAL_YN,CONFIRM_BEDSIDE_REFERRAL_YN,DIAG_PROC_RECODE_FOR_IP_YN,CANCEL_DISCHARGE_YN,OVERRIDE_WALKIN_YN,CANCEL_CHECKOUT_YN,CANCEL_RESERVE_BED_YN,emergency_transfer_yn,revise_admission_yn,MAINTAIN_DEATH_REGISTER_YN,quick_admission_yn) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" ;
		
				pstmt = con.prepareStatement( sql );
				pstmt.setString	(1,facilityId) ;
				pstmt.setString	(2,oper_stn_id) ;
				pstmt.setString	(3,long_desc) ;
				pstmt.setString	(4,short_desc) ;
				pstmt.setString	(5,nurs_unit_code) ;
				pstmt.setString	(6,shift_operated_yn) ;
				pstmt.setString (7,shift_group);
				pstmt.setString	(8,ws_no) ;
				pstmt.setString	(9,addedById) ;
				pstmt.setDate	(10,added_date) ;
				pstmt.setString	(11,addedAtWorkstation) ;
				pstmt.setString	(12,facilityId) ;
				pstmt.setString	(13,modifiedById) ;
				pstmt.setDate	(14,modified_date) ;
				pstmt.setString	(15,modifiedAtWorkstation) ;
				pstmt.setString	(16,modifiedFacilityId) ;
				pstmt.setString	(17,eff_status);
				pstmt.setString	(18,book_appt_yn);
				pstmt.setString	(19,book_appt_wo_pid_yn);
				pstmt.setString	(20,obook_appt_yn);
				pstmt.setString	(21,book_appt_across_catg_yn);
				pstmt.setString	(22,tfr_appt_yn);
				pstmt.setString	(23,tfr_appt_across_catg_yn);
				pstmt.setString	(24,CONFIRM_BOOKING_YN);
				pstmt.setString	(25,CREATE_BOOKING_WITH_CONF_YN);
				pstmt.setString	(26,canc_appt_yn);
				pstmt.setString	(27,register_visit_yn);
				pstmt.setString	(28,register_pat_yn);
				pstmt.setString	(29,cancel_visit_yn);
				pstmt.setString	(30,revise_visit_yn);
				pstmt.setString	(31,manage_queue_yn);
				pstmt.setString	(32,checkout_pat_yn);
				pstmt.setString	(33,oper_stn_type);
				pstmt.setString	(34,create_booking_yn);
				pstmt.setString	(35,revise_booking_yn);
				pstmt.setString	(36,canc_booking_yn);
				pstmt.setString	(37,reject_admission_yn);
				pstmt.setString	(38,admit_pat_yn);
				pstmt.setString	(39,register_pat_in_admn_yn);
				pstmt.setString	(40,assign_bed_yn);
				pstmt.setString	(41,assign_treat_pract_yn);
				pstmt.setString	(42,canc_admission_yn);
				pstmt.setString	(43,emergency_tfr_yn);
				pstmt.setString	(44,routine_tfr_yn);
				pstmt.setString	(45,discharge_pat_yn);
				pstmt.setString	(46,revise_leave_yn);
				pstmt.setString	(47,check_lodger_yn);
				pstmt.setString	(48,block_bed_yn);
				pstmt.setString	(49,release_bed_yn);
				pstmt.setString	(50,register_visit_walkin_yn);
				pstmt.setString	(51,register_visit_referral_yn);
				pstmt.setString	(52,SWAP_BED_YN);
				pstmt.setString	(53,TRANSFER_OUT_PATIENT_YN);
				pstmt.setString	(54,TRANSFER_IN_PATIENT_YN);
				pstmt.setString	(55,CHG_NURS_UNIT_IN_ASSIGN_BED_YN);
				pstmt.setString	(56,ADMIT_PATIENT_WITH_BED_YN);
				pstmt.setString	(57,FORCED_BOOK_APPT_YN);
				pstmt.setString	(58,GLOBAL_BOOK_APPT_YN);
				pstmt.setString	(59,canc_req_yn);
				pstmt.setString	(60,cfrm_req_yn);
				pstmt.setString	(61,can_tfr_out_yn);
				pstmt.setString	(62,pract_tfr_yn);
				pstmt.setString	(63,dchrg_adv_yn);
				pstmt.setString	(64,BED_CLASS_CHANGE_YN);
				pstmt.setString	(65,BACKDATED_ADMISSION_YN);
				pstmt.setString	(66,create_wait_list_yn);
				pstmt.setString	(67,modify_wait_list_yn);
				pstmt.setString	(68,cancel_wait_list_yn);
				pstmt.setString	(69,LINK_BABY_TO_MOTHER_YN);
				pstmt.setString	(70,REG_NEWBORN_FOR_IP_YN);
				pstmt.setString	(71,DISCHARGE_CHECKLIST_YN);
				pstmt.setString	(72,RESERVE_BED_BAY_YN);
				pstmt.setString	(73,RELEASE_BED_BAY_YN);
				pstmt.setString	(74,DIAG_PROC_RECODE_FOR_OP_YN);
				pstmt.setString	(75,REG_IP_REFERRAL_YN);
				pstmt.setString	(76,CONFIRM_BEDSIDE_REFERRAL_YN);
				pstmt.setString	(77,DIAG_PROC_RECODE_FOR_IP_YN);
				pstmt.setString	(78,CANCEL_DISCHARGE_YN);
				pstmt.setString	(79,OVERRIDE_WALKIN_YN);
				pstmt.setString	(80,CANCEL_CHECKOUT_YN);
				//9/16/2008 cancel_reBeds_yn set the string 
				pstmt.setString	(81,cancel_reBeds_yn);
				pstmt.setString	(82,emergency_transfer_yn);
				pstmt.setString	(83,revise_admission_yn);
				pstmt.setString	(84,MAINTAIN_DEATH_REGISTER_YN);
                pstmt.setString	(85,quick_admission_yn); //this line Added for this CRF Bru-HIMS-CRF-261
				

				int res = pstmt.executeUpdate() ;

				if ( res != 0 ) {
					result = true ;
					java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_INSERTED,"SM" ) ;
					sb.append( (String) message.get("message") ) ;
					message.clear();
					con.commit();
				}

				 if(rs !=null) rs.close();
				 if(pstmt !=null) pstmt.close();
			} 
			catch ( Exception e ) 
			{
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;
				try 
					{ 
					con.rollback(); 
					} 
				catch (Exception ee) 
					{
					ee.printStackTrace();
				    }
			}
			finally
			{
			 if(pstmt !=null) pstmt.close();
			  if (con != null)
				 ConnectionManager.returnConnection(con,p);
			}
		}
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
	}
	catch(Exception e)
		{
			e.printStackTrace();
		}
		return results ;
	}

/**
* @ejb.interface-method
*	 view-type="both"
*/
	public java.util.HashMap updateOPOperatorStation(java.util.HashMap hashmap)
	{
		java.util.HashMap results = new java.util.HashMap() ;
		try{
		
		java.util.Properties p				=(java.util.Properties) hashmap.get("p");
		String locale="";
		locale= p.getProperty("LOCALE"); 
		String facilityId					=(String)hashmap.get("facility_id");
		//String effectiveDateFrom			=(String)hashmap.get("effectiveDateFrom");
	//	String effectiveDateTo				=(String)hashmap.get("effectiveDateTo");
		String effectiveStatus				=(String)hashmap.get("effectiveStatus");
		String client_ip_address			=(String)hashmap.get("client_ip_address");
		String oper_stn_id					=(String)hashmap.get("oper_stn_id");
		String long_desc					=(String)hashmap.get("long_desc");
		String short_desc					=(String)hashmap.get("short_desc");
		//String nurs_unit_code				=(String)hashmap.get("nurs_unit_code");
	//	String shift_operated_yn			=(String)hashmap.get("shift_operated_yn");
	//	String shift_group					=(String)hashmap.get("shift_group");
		//String ws_no						=(String)hashmap.get("ws_no");
		String book_appt_yn					=(String)hashmap.get("book_appt_yn");
		String book_appt_wo_pid_yn			=(String)hashmap.get("book_appt_wo_pid_yn");
		String obook_appt_yn				=(String)hashmap.get("obook_appt_yn");
		String book_appt_across_catg_yn		=(String)hashmap.get("book_appt_across_catg_yn");
		String tfr_appt_yn					=(String)hashmap.get("tfr_appt_yn");
		String tfr_appt_across_catg_yn		=(String)hashmap.get("tfr_appt_across_catg_yn");
		String CONFIRM_BOOKING_YN			=(String)hashmap.get("CONFIRM_BOOKING_YN");
		String CREATE_BOOKING_WITH_CONF_YN	=(String)hashmap.get("CREATE_BOOKING_WITH_CONF_YN");
		String canc_appt_yn					=(String)hashmap.get("canc_appt_yn");
		String register_visit_yn			=(String)hashmap.get("register_visit_yn");
		String register_pat_yn				=(String)hashmap.get("register_pat_yn");
		String cancel_visit_yn				=(String)hashmap.get("cancel_visit_yn");
		String revise_visit_yn				=(String)hashmap.get("revise_visit_yn");
		String manage_queue_yn				=(String)hashmap.get("manage_queue_yn");
		String checkout_pat_yn				=(String)hashmap.get("checkout_pat_yn");
	//	String oper_stn_type				=(String)hashmap.get("oper_stn_type");
		String create_booking_yn			=(String)hashmap.get("create_booking_yn");
		String revise_booking_yn			=(String)hashmap.get("revise_booking_yn");
		String canc_booking_yn				=(String)hashmap.get("canc_booking_yn");
		String reject_admission_yn			=(String)hashmap.get("reject_admission_yn");
		String admit_pat_yn					=(String)hashmap.get("admit_pat_yn");
		String register_pat_in_admn_yn		=(String)hashmap.get("register_pat_in_admn_yn");
		String assign_bed_yn				=(String)hashmap.get("assign_bed_yn");
		String assign_treat_pract_yn		=(String)hashmap.get("assign_treat_pract_yn");
		String canc_admission_yn			=(String)hashmap.get("canc_admission_yn");
		String emergency_tfr_yn				=(String)hashmap.get("emergency_tfr_yn");
		String routine_tfr_yn				=(String)hashmap.get("routine_tfr_yn");
		String discharge_pat_yn				=(String)hashmap.get("discharge_pat_yn");
		String revise_leave_yn				=(String)hashmap.get("revise_leave_yn");
		String check_lodger_yn				=(String)hashmap.get("check_lodger_yn");
		String block_bed_yn					=(String)hashmap.get("block_bed_yn");
		String release_bed_yn				=(String)hashmap.get("release_bed_yn");
		String register_visit_walkin_yn		=(String)hashmap.get("register_visit_walkin_yn");
		String register_visit_referral_yn	=(String)hashmap.get("register_visit_referral_yn");
		String SWAP_BED_YN					=(String)hashmap.get("SWAP_BED_YN");
		String TRANSFER_OUT_PATIENT_YN		=(String)hashmap.get("TRANSFER_OUT_PATIENT_YN");
		String TRANSFER_IN_PATIENT_YN		=(String)hashmap.get("TRANSFER_IN_PATIENT_YN");
		String CHG_NURS_UNIT_IN_ASSIGN_BED_YN=(String)hashmap.get("CHG_NURS_UNIT_IN_ASSIGN_BED_YN");
		String ADMIT_PATIENT_WITH_BED_YN	=(String)hashmap.get("ADMIT_PATIENT_WITH_BED_YN");
		String FORCED_BOOK_APPT_YN			=(String)hashmap.get("FORCED_BOOK_APPT_YN");
		String GLOBAL_BOOK_APPT_YN			=(String)hashmap.get("GLOBAL_BOOK_APPT_YN");
		String canc_req_yn					=(String)hashmap.get("canc_req_yn");
		String cfrm_req_yn					=(String)hashmap.get("cfrm_req_yn");
		String can_tfr_out_yn				=(String)hashmap.get("can_tfr_out_yn");
		String pract_tfr_yn					=(String)hashmap.get("pract_tfr_yn");
		String dchrg_adv_yn					=(String)hashmap.get("dchrg_adv_yn");
		String BED_CLASS_CHANGE_YN			=(String)hashmap.get("BED_CLASS_CHANGE_YN");
		String BACKDATED_ADMISSION_YN		=(String)hashmap.get("BACKDATED_ADMISSION_YN");
		String create_wait_list_yn			=(String)hashmap.get("create_wait_list_yn");
		String modify_wait_list_yn			=(String)hashmap.get("modify_wait_list_yn");
		String cancel_wait_list_yn			=(String)hashmap.get("cancel_wait_list_yn");
		String LINK_BABY_TO_MOTHER_YN		=(String)hashmap.get("LINK_BABY_TO_MOTHER_YN");
		String REG_NEWBORN_FOR_IP_YN		=(String)hashmap.get("REG_NEWBORN_FOR_IP_YN");
		String DISCHARGE_CHECKLIST_YN		=(String)hashmap.get("DISCHARGE_CHECKLIST_YN");
		String RESERVE_BED_BAY_YN			=(String)hashmap.get("RESERVE_BED_BAY_YN");
		String RELEASE_BED_BAY_YN			=(String)hashmap.get("RELEASE_BED_BAY_YN");
		
		String REG_IP_REFERRAL_YN			=(String)hashmap.get("REG_IP_REFERRAL_YN");
		String CONFIRM_BEDSIDE_REFERRAL_YN  =(String)hashmap.get("CONFIRM_BEDSIDE_REFERRAL_YN");

		String CANCEL_DISCHARGE_YN			=(String)hashmap.get("CANCEL_DISCHARGE_YN");

		String OVERRIDE_WALKIN_YN			=(String)hashmap.get("OVERRIDE_WALKIN_YN");	
		String CANCEL_CHECKOUT_YN			=(String)hashmap.get("CANCEL_CHECKOUT_YN");	

		//9/16/2008 get the value from hsah map
		String cancel_reBeds_yn					=(String)hashmap.get("CANCEL_RESERVE_BED_YN");
        String DIAG_PROC_RECODE_FOR_IP_YN			=(String)hashmap.get("DIAG_PROC_RECODE_FOR_IP_YN");
        String DIAG_PROC_RECODE_FOR_OP_YN			=(String)hashmap.get("DIAG_PROC_RECODE_FOR_OP_YN");
        String emergency_transfer_yn			    =(String)hashmap.get("emergency_transfer_yn");
        String MAINTAIN_DEATH_REGISTER_YN			    =(String)hashmap.get("MAINTAIN_DEATH_REGISTER_YN");
        String revise_admission_yn			    =(String)hashmap.get("revise_admission_yn");
		
		/*Below line Added for this CRF Bru-HIMS-CRF-261*/
		String quick_admission_yn			    =(String)hashmap.get("quick_admission_yn"); 
		

		
		
		boolean result = false ;
		boolean updatable = true ;
		StringBuffer sb = new StringBuffer( "" ) ;
		String modifiedById = p.getProperty( "login_user" ) ;
		String modifiedDate = dateFormat.format( new java.util.Date() ) ;
		String addedAtWorkstation=client_ip_address;
		String modifiedAtWorkstation = addedAtWorkstation ;
	
		Date modified_date = Date.valueOf( modifiedDate ) ;

		hashmap.clear();
		/*Below query modified for this CRF Bru-HIMS-CRF-261*/
		String sql =    "update am_oper_stn set " +
						"long_desc = ?,  " +
						"short_desc = ?,  " +
						" modified_by_id	= ?,  " +
						" modified_date		= ?,  " +
						" modified_facility_id = ?, "+
						" modified_at_ws_no = ? ,	"+
						" book_appt_yn= ? ,	"+
			            " book_appt_wo_pid_yn= ? ,"+
						" obook_appt_yn=  ? ,	"+
						" book_appt_across_catg_yn= ? ,	"+
						" tfr_appt_yn= ? ,	"+
						" tfr_appt_across_catg_yn= ? ,	"+
						" CONFIRM_BOOKING_YN= ? ,	"+
						" CREATE_BOOKING_WITH_CONF_YN= ? ,	"+
						" canc_appt_yn= ? ,	"+
						" register_visit_yn= ? ,	"+
						" register_pat_yn= ? ,	"+
						" cancel_visit_yn= ? ,	"+
						" revise_visit_yn= ? ,	"+
						" manage_queue_yn= ? ,	"+
						" checkout_pat_yn= ? ,	"+
						" create_booking_yn= ? ,	"+
						" revise_booking_yn= ? ,	"+
						" canc_booking_yn= ? ,	"+
						" reject_admission_yn= ? ,	"+
						" admit_pat_yn= ? ,	"+
						" register_pat_in_admn_yn= ? ,	"+
						" assign_bed_yn= ? ,	"+
						" assign_treat_pract_yn= ? ,	"+
						" canc_admission_yn= ? ,	"+
						" emergency_tfr_yn= ? ,	"+
						" routine_tfr_yn= ? ,	"+
						" discharge_pat_yn= ? ,	"+
						" revise_leave_yn= ? ,	"+
						" check_lodger_yn=? , "+
						" block_bed_yn=? , "+
						" release_bed_yn=?,"+
						" SWAP_BED_YN= ? ,	"+
						" CONFIRM_REQUEST_YN= ? ,	"+
						" CANCEL_REQUEST_YN= ? ,	"+
						" CANCEL_TRANSFER_OUT_YN= ? ,	"+
						" PRACT_TRANSFER_YN= ? ,	"+
						" DISCHARGE_ADVICE_YN= ? ,	"+
						" TRANSFER_OUT_PATIENT_YN= ? ,	"+
						" TRANSFER_IN_PATIENT_YN= ? ,	"+
						" CHG_NURS_UNIT_IN_ASSIGN_BED_YN= ? ,	"+
						" ADMIT_PATIENT_WITH_BED_YN= ? ,	"+
						" FORCED_BOOK_APPT_YN= ? ,	"+
						" GLOBAL_BOOK_APPT_YN= ? ,	"+
			            " DIAG_PROC_RECODE_FOR_OP_YN= ? ,	"+
						"register_visit_walkin_yn=?,"+
						"BED_CLASS_CHANGE_YN=?,"+
						"BACKDATED_ADMISSION_YN=?,"+
						"register_visit_referral_yn =?,eff_status=?, "+
			            "CREATE_WAIT_LIST_YN=?,MODIFY_WAIT_LIST_YN=?, CANCEL_WAIT_LIST_YN = ?,"+
						"LINK_BABY_TO_MOTHER_YN=?,REG_NEWBORN_FOR_IP_YN=?, DISCHARGE_CHECKLIST_YN = ?,"+
						"RESERVE_BED_BAY_YN=?,RELEASE_BED_BAY_YN=?,"+
						"REG_IP_REFERRAL_YN=?,CONFIRM_BEDSIDE_REFERRAL_YN=?,"+
						"DIAG_PROC_RECODE_FOR_IP_YN=?,"+
						"CANCEL_DISCHARGE_YN=?,OVERRIDE_WALKIN_YN = ?,"+
			            "CANCEL_CHECKOUT_YN=?,"+"CANCEL_RESERVE_BED_YN=?,"+"emergency_transfer_yn=?,"+"revise_admission_yn=?,"+
						" MAINTAIN_DEATH_REGISTER_YN = ?,"+"quick_admission_yn = ? "+ 
						" where	facility_id = ? "+
						" and oper_stn_id = ?	";

		
		if ( updatable )
		{
			try {
			    con=ConnectionManager.getConnection(p);
				pstmt = con.prepareStatement( sql );
				pstmt.setString	( 1, long_desc ) ;
				pstmt.setString	( 2, short_desc ) ;
				pstmt.setString	( 3, modifiedById ) ;
				pstmt.setDate	( 4, modified_date ) ;
				pstmt.setString	( 5, facilityId ) ;
				pstmt.setString	( 6, modifiedAtWorkstation ) ;
				pstmt.setString	( 7,book_appt_yn);
				pstmt.setString	( 8,book_appt_wo_pid_yn);
				pstmt.setString	( 9,obook_appt_yn);
				pstmt.setString	( 10,book_appt_across_catg_yn);
				pstmt.setString	( 11,tfr_appt_yn);
				pstmt.setString	( 12,tfr_appt_across_catg_yn);
				pstmt.setString	( 13,CONFIRM_BOOKING_YN);
				pstmt.setString	( 14,CREATE_BOOKING_WITH_CONF_YN);
				pstmt.setString	( 15,canc_appt_yn);
				pstmt.setString	( 16,register_visit_yn);
				pstmt.setString	( 17,register_pat_yn);
				pstmt.setString	( 18,cancel_visit_yn);
				pstmt.setString	( 19,revise_visit_yn);
				pstmt.setString	( 20,manage_queue_yn);
				pstmt.setString	( 21,checkout_pat_yn);
				pstmt.setString	( 22, create_booking_yn ) ;
				pstmt.setString	( 23, revise_booking_yn ) ;
				pstmt.setString	( 24, canc_booking_yn ) ;
				pstmt.setString	( 25, reject_admission_yn ) ;
				pstmt.setString	( 26, admit_pat_yn ) ;
				pstmt.setString	( 27, register_pat_in_admn_yn ) ;
				pstmt.setString	( 28, assign_bed_yn ) ;
				pstmt.setString	( 29, assign_treat_pract_yn ) ;
				pstmt.setString	( 30, canc_admission_yn ) ;
				pstmt.setString	( 31, emergency_tfr_yn ) ;
				pstmt.setString	( 32, routine_tfr_yn ) ;
				pstmt.setString	( 33, discharge_pat_yn ) ;
				pstmt.setString	( 34, revise_leave_yn ) ;
				pstmt.setString	( 35, check_lodger_yn ) ;
				pstmt.setString	( 36, block_bed_yn ) ;
				pstmt.setString	( 37, release_bed_yn ) ;
				pstmt.setString	( 38, SWAP_BED_YN ) ;
				pstmt.setString	( 39, cfrm_req_yn ) ;
				pstmt.setString	( 40, canc_req_yn ) ;
				pstmt.setString	( 41, can_tfr_out_yn ) ;
				pstmt.setString	( 42, pract_tfr_yn ) ;
				pstmt.setString	( 43, dchrg_adv_yn ) ;
				pstmt.setString	( 44, TRANSFER_OUT_PATIENT_YN ) ;
				pstmt.setString	( 45, TRANSFER_IN_PATIENT_YN ) ;
				pstmt.setString	( 46, CHG_NURS_UNIT_IN_ASSIGN_BED_YN ) ;
				pstmt.setString	( 47, ADMIT_PATIENT_WITH_BED_YN ) ;
				pstmt.setString	( 48, FORCED_BOOK_APPT_YN ) ;
				pstmt.setString	( 49, GLOBAL_BOOK_APPT_YN ) ;
				pstmt.setString	( 50, DIAG_PROC_RECODE_FOR_OP_YN ) ;
				pstmt.setString	( 51, register_visit_walkin_yn ) ;
				pstmt.setString	( 52, BED_CLASS_CHANGE_YN ) ;
				pstmt.setString	( 53, BACKDATED_ADMISSION_YN ) ;
				pstmt.setString	( 54, register_visit_referral_yn ) ;
				pstmt.setString	( 55, effectiveStatus);
				pstmt.setString	( 56, create_wait_list_yn);
				pstmt.setString	( 57, modify_wait_list_yn);
				pstmt.setString	( 58, cancel_wait_list_yn);
				pstmt.setString	( 59, LINK_BABY_TO_MOTHER_YN);
				pstmt.setString	( 60, REG_NEWBORN_FOR_IP_YN);
				pstmt.setString	( 61, DISCHARGE_CHECKLIST_YN);
				pstmt.setString	( 62, RESERVE_BED_BAY_YN ) ;
				pstmt.setString	( 63, RELEASE_BED_BAY_YN ) ;
				pstmt.setString	( 64, REG_IP_REFERRAL_YN ) ;
				pstmt.setString	( 65, CONFIRM_BEDSIDE_REFERRAL_YN ) ;
				pstmt.setString	( 66, DIAG_PROC_RECODE_FOR_IP_YN ) ;
				pstmt.setString	( 67, CANCEL_DISCHARGE_YN ) ;				
				pstmt.setString	( 68, OVERRIDE_WALKIN_YN ) ;	
				pstmt.setString	( 69, CANCEL_CHECKOUT_YN ) ;
				pstmt.setString	( 70, cancel_reBeds_yn ) ;
				pstmt.setString	( 71, emergency_transfer_yn ) ;
				pstmt.setString	( 72, revise_admission_yn ) ;
				pstmt.setString	( 73, MAINTAIN_DEATH_REGISTER_YN ) ;
				pstmt.setString	( 74, quick_admission_yn ) ; //This line Added for this CRF Bru-HIMS-CRF-261
				pstmt.setString	( 75, facilityId ) ;
				pstmt.setString	( 76, oper_stn_id ) ;
				
                int res = pstmt.executeUpdate() ;
				/*try{
				
				int res = pstmt.executeUpdate() ;
				}catch(Exception ex99){
					ex99.printStackTrace();
				}*/


				if(pstmt!=null) pstmt.close();
		
		        //Below line modified for this CRF Bru-HIMS-CRF-261

							StringBuffer am_rstrn_sql =   new StringBuffer("update am_restrn_for_oper_stn set ");
				am_rstrn_sql.append("modified_by_id		= ?,	");
				am_rstrn_sql.append(" modified_date			= ?,	");
				am_rstrn_sql.append(" modified_facility_id 	= ?, 	");
				am_rstrn_sql.append(" modified_at_ws_no 	= ?,	");
				am_rstrn_sql.append(" book_appt_yn 			= ?,	");
				am_rstrn_sql.append(" book_appt_wo_pid_yn	= ?, 	");
				am_rstrn_sql.append(" obook_appt_yn			= ?, 	");
				am_rstrn_sql.append(" book_appt_across_catg_yn= ?,  ");
				am_rstrn_sql.append(" tfr_appt_yn			=?,  	");
				am_rstrn_sql.append(" tfr_appt_across_catg_yn = ?,  ");
				am_rstrn_sql.append(" CONFIRM_BOOKING_YN = ?,  ");
				am_rstrn_sql.append(" CREATE_BOOKING_WITH_CONF_YN = ?,  ");
				am_rstrn_sql.append(" canc_appt_yn		  =?,		");
				am_rstrn_sql.append(" register_visit_yn = ?,    	");
				am_rstrn_sql.append(" register_pat_yn = ?,	    	");
				am_rstrn_sql.append(" cancel_visit_yn = ?,			");
				am_rstrn_sql.append(" revise_visit_yn = ?,			");
				am_rstrn_sql.append(" manage_queue_yn = ?,	    	");
				am_rstrn_sql.append(" checkout_pat_yn =?,			");
				am_rstrn_sql.append(" block_bed_yn =?,			");
				am_rstrn_sql.append(" release_bed_yn =?	,		");
				am_rstrn_sql.append(" SWAP_BED_YN= ? ,	");
				am_rstrn_sql.append(" CONFIRM_REQUEST_YN= ? ,	");
				am_rstrn_sql.append(" CANCEL_REQUEST_YN= ? ,	");
				am_rstrn_sql.append(" CANCEL_TRANSFER_OUT_YN= ? ,	");
				am_rstrn_sql.append(" PRACT_TRANSFER_YN= ? ,	");
				am_rstrn_sql.append(" DISCHARGE_ADVICE_YN= ? ,	");
				am_rstrn_sql.append(" TRANSFER_OUT_PATIENT_YN= ? ,	");
				am_rstrn_sql.append(" TRANSFER_IN_PATIENT_YN= ? ,	");
				am_rstrn_sql.append(" CHG_NURS_UNIT_IN_ASSIGN_BED_YN= ? ,	");
				am_rstrn_sql.append(" ADMIT_PATIENT_WITH_BED_YN= ? ,	");
				am_rstrn_sql.append(" FORCED_BOOK_APPT_YN= ? ,	");
				am_rstrn_sql.append(" GLOBAL_BOOK_APPT_YN= ? ,	");	
				am_rstrn_sql.append(" BED_CLASS_CHANGE_YN= ? ,	");	
				am_rstrn_sql.append(" BACKDATED_ADMISSION_YN= ? ,	" );
				am_rstrn_sql.append(" create_wait_list_yn= ? 	," );
				am_rstrn_sql.append(" modify_wait_list_yn= ? ,	" );
				am_rstrn_sql.append(" cancel_wait_list_yn= ? 	," );
				am_rstrn_sql.append(" LINK_BABY_TO_MOTHER_YN= ? 	," );
				am_rstrn_sql.append(" REG_NEWBORN_FOR_IP_YN= ? ,	" );
				am_rstrn_sql.append(" DISCHARGE_CHECKLIST_YN= ? ," );
				am_rstrn_sql.append(" RESERVE_BED_BAY_YN= ? 	,");
				am_rstrn_sql.append(" RELEASE_BED_BAY_YN= ? ,");
				am_rstrn_sql.append("REG_IP_REFERRAL_YN=?,");
				am_rstrn_sql.append("CONFIRM_BEDSIDE_REFERRAL_YN=?,");
				am_rstrn_sql.append("CANCEL_DISCHARGE_YN=?,OVERRIDE_WALKIN_YN=?,");
				am_rstrn_sql.append("CANCEL_CHECKOUT_YN=?,CANCEL_RESERVE_BED_YN=?,DIAG_PROC_RECODE_FOR_IP_YN=?,DIAG_PROC_RECODE_FOR_OP_YN=? ");	
				am_rstrn_sql.append(",emergency_transfer_yn = ?");
				am_rstrn_sql.append(",MAINTAIN_DEATH_REGISTER_YN = ?");
                am_rstrn_sql.append(",quick_admission_yn = ?"); 				
				am_rstrn_sql.append(" where	facility_id 	= ? 	");
				am_rstrn_sql.append(" and oper_stn_id = ?");

				pstmt = con.prepareStatement( am_rstrn_sql.toString() );
				pstmt.setString	( 1, modifiedById ) ;
				pstmt.setDate	( 2, modified_date ) ;
				pstmt.setString	( 3, facilityId ) ;
				pstmt.setString	( 4, modifiedAtWorkstation ) ;
				pstmt.setString	( 5, book_appt_yn);
				pstmt.setString	( 6, book_appt_wo_pid_yn);
				pstmt.setString	( 7, obook_appt_yn);
				pstmt.setString	( 8, book_appt_across_catg_yn);
				pstmt.setString	( 9, tfr_appt_yn);
				pstmt.setString	( 10,tfr_appt_across_catg_yn);
				pstmt.setString	( 11,CONFIRM_BOOKING_YN);
				pstmt.setString	( 12,CREATE_BOOKING_WITH_CONF_YN);
				pstmt.setString	( 13,canc_appt_yn);
				pstmt.setString	( 14,register_visit_yn);
				pstmt.setString	( 15,register_pat_yn);
				pstmt.setString	( 16,cancel_visit_yn);
				pstmt.setString	( 17,revise_visit_yn);
				pstmt.setString	( 18,manage_queue_yn);
				pstmt.setString	( 19,checkout_pat_yn);
				pstmt.setString	( 20,block_bed_yn);
				pstmt.setString	( 21,release_bed_yn);
				pstmt.setString	( 22,SWAP_BED_YN);
				pstmt.setString	( 23,cfrm_req_yn ) ;
				pstmt.setString	( 24,canc_req_yn ) ;
				pstmt.setString	( 25,can_tfr_out_yn ) ;
				pstmt.setString	( 26,pract_tfr_yn ) ;
				pstmt.setString	( 27,dchrg_adv_yn ) ;
				pstmt.setString	( 28,TRANSFER_OUT_PATIENT_YN);
				pstmt.setString	( 29,TRANSFER_IN_PATIENT_YN);
				pstmt.setString	( 30,CHG_NURS_UNIT_IN_ASSIGN_BED_YN);
				pstmt.setString	( 31,ADMIT_PATIENT_WITH_BED_YN);
				pstmt.setString	( 32,FORCED_BOOK_APPT_YN);
				pstmt.setString	( 33,GLOBAL_BOOK_APPT_YN);
				pstmt.setString	( 34,BED_CLASS_CHANGE_YN);
				pstmt.setString	( 35,BACKDATED_ADMISSION_YN);
				pstmt.setString	( 36,create_wait_list_yn);
				pstmt.setString	( 37,modify_wait_list_yn);
				pstmt.setString	( 38,cancel_wait_list_yn);
				pstmt.setString	( 39,LINK_BABY_TO_MOTHER_YN);
				pstmt.setString	( 40,REG_NEWBORN_FOR_IP_YN);
				pstmt.setString	( 41,DISCHARGE_CHECKLIST_YN);
				pstmt.setString	( 42,RESERVE_BED_BAY_YN);
				pstmt.setString	( 43,RELEASE_BED_BAY_YN);
				pstmt.setString	( 44, REG_IP_REFERRAL_YN ) ;
				pstmt.setString	( 45, CONFIRM_BEDSIDE_REFERRAL_YN ) ;
				pstmt.setString	( 46, CANCEL_DISCHARGE_YN ) ;
				pstmt.setString	( 47, OVERRIDE_WALKIN_YN ) ;
				pstmt.setString	( 48, CANCEL_CHECKOUT_YN ) ;
				pstmt.setString	( 49, cancel_reBeds_yn ) ;
				pstmt.setString	( 50, DIAG_PROC_RECODE_FOR_IP_YN ) ;
				pstmt.setString	( 51, DIAG_PROC_RECODE_FOR_OP_YN ) ;
				pstmt.setString	( 52, emergency_transfer_yn ) ;
				pstmt.setString	( 53, MAINTAIN_DEATH_REGISTER_YN ) ;
				pstmt.setString	( 54, quick_admission_yn ) ; //this line Added for this CRF Bru-HIMS-CRF-261
				pstmt.setString	( 55, facilityId ) ;
				pstmt.setString	( 56, oper_stn_id ) ;
				

				int res1 = pstmt.executeUpdate() ;

				if ( res != 0 || res1 != 0 ) {
					result = true ;
				
					java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_MODIFIED,"SM" ) ;
					sb.append( (String) message.get("message") ) ;
					message.clear();
					con.commit();
				}
//				else{			}

				if(rs !=null) rs.close();
				 if(pstmt !=null) pstmt.close();
	
			} catch ( Exception e ) {
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;
				try { con.rollback(); } 
				catch (Exception ee) {ee.printStackTrace();}
			}finally {
				  if (con != null){
					 ConnectionManager.returnConnection(con,p);		
			      }
			}
	}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}

		return results ;
	}

/**
* @ejb.interface-method
*	 view-type="both"
*/
	public java.util.HashMap deleteOperatorStation(java.util.HashMap hashmap){
		java.util.Properties p						=(java.util.Properties) hashmap.get("p");
		String oper_stn_id		=(String)hashmap.get("oper_stn_id");
		String oper_stn_type	=(String)hashmap.get("oper_stn_type");
		String facilityid		=(String)hashmap.get("facility_id");
			java.util.HashMap results = new java.util.HashMap() ;
String locale="";
		locale= p.getProperty("LOCALE"); 
          hashmap.clear();
		try{
		
	
		try{

		boolean result = false ;
		boolean deletable = true ;

		StringBuffer sb = new StringBuffer( "" ) ;
		try{
			con=ConnectionManager.getConnection(p);

			final String CheckOperStnLocnsExistSQL = "Select  count(*) from am_locn_for_oper_stn where facility_id =? and OPER_STN_ID = ?" ;
			pstmt = con.prepareStatement( CheckOperStnLocnsExistSQL ) ;

			pstmt.setString( 1, facilityid ) ;
			pstmt.setString( 2, oper_stn_id ) ;
			int cnt=0;
			rs = pstmt.executeQuery() ;
			if(rs!=null){
				while(rs.next()){
					cnt=rs.getInt(1);
				}
			}
			if(rs!=null)rs.close();               
			if(pstmt!=null)pstmt.close();
			if ( cnt != 0 )
			{
				deletable = false ;
				java.util.Hashtable message = MessageManager.getMessage( locale, "OS_CANNOT_DELETED_LOCN_EXIST" ,"AM") ;
				sb.append( (String) message.get("message") ) ;
				message.clear();
			}

			// added by sheelvant on 08/06/2002
			final String CheckOperStnUsersExistSQL = "Select  count(*) from am_user_for_oper_stn where facility_id =? and OPER_STN_ID = ?" ;
			pstmt = con.prepareStatement( CheckOperStnUsersExistSQL ) ;

			pstmt.setString( 1, facilityid ) ;
			pstmt.setString( 2, oper_stn_id ) ;
			cnt=0;
			rs = pstmt.executeQuery() ;
			if(rs!=null){
				while(rs.next()){
					cnt=rs.getInt(1);
				}
			}
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if ( cnt>0 ){
				deletable = false ;
				java.util.Hashtable message = MessageManager.getMessage( locale, "OS_CANNOT_DELETED_USER_EXIST","AM" ) ;
				sb.append( (String) message.get("message") ) ;
				message.clear();
			}

			final String CheckOperStnRstrnExistSQL = "Select  count(*) from am_restrn_for_oper_stn where facility_id =? and OPER_STN_ID = ?" ;
			pstmt = con.prepareStatement( CheckOperStnRstrnExistSQL ) ;

			pstmt.setString( 1, facilityid ) ;
			pstmt.setString( 2, oper_stn_id ) ;
			cnt=0;
			rs = pstmt.executeQuery() ;
			if(rs!=null){
				while(rs.next()){
					cnt=rs.getInt(1);
				}
			}

			if ( cnt>0 )
			{
				deletable = false ;
				java.util.Hashtable message = MessageManager.getMessage( locale, "OS_CANNOT_DELETED_RSTRN_EXIST" ,"AM") ;
				sb.append( (String) message.get("message") ) ;
			    message.clear();
			}
			if(pstmt!=null)pstmt.close();
		}catch ( Exception e ){

			deletable = false ;
			sb.append( e.getMessage() + "<br>" ) ;
			e.printStackTrace() ;
			if (con != null)
			{
				try {
					con.rollback() ;
				}catch (Exception ce) {
					sb.append( ce.getMessage() + "<br>" ) ;
					ce.printStackTrace() ;
				}
				ConnectionManager.returnConnection(con,p);
			}			
		}
		try{
			if(deletable){
				String sql = "delete from am_oper_stn where facility_id = ? and oper_stn_id = ? and oper_stn_type = ?";

				pstmt = con.prepareStatement( sql );
				pstmt.setString	( 1, facilityid ) ;
				pstmt.setString	( 2, oper_stn_id) ;
				pstmt.setString	( 3, oper_stn_type) ;
				int res = pstmt.executeUpdate() ;

				if ( res != 0 ){
				result = true ;
				java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_DELETED ,"SM") ;
				sb.append( (String) message.get("message") ) ;
				message.clear();
				con.commit();
				}else{
					result=false;
				}
			}else{
				result=false;
			}
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
		}catch ( Exception e1 ){

			sb.append( e1.getMessage() + "<br>" ) ;
			e1.printStackTrace() ;
			try { con.rollback(); } catch (Exception ee) {}
		}finally{
			if (con != null)
				ConnectionManager.returnConnection(con,p);
		}
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return results ;
	}
}
