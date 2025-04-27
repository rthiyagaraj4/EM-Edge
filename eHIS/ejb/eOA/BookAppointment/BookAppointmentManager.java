/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOA.BookAppointment;


import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import blbkin.*;



/**
*
* @ejb.bean
*	name="BookAppointment"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="BookAppointment"
*	local-jndi-name="BookAppointment"
*	impl-class-name="eOA.BookAppointment.BookAppointmentManager"
*
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject"
*	local-class="eOA.BookAppointment.BookAppointmentLocal"
*	remote-class="eOA.BookAppointment.BookAppointmentRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome"
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOA.BookAppointment.BookAppointmentLocalHome"
*	remote-class="eOA.BookAppointment.BookAppointmentHome"
*	generate= "local,remote"
*
*
*/

public class BookAppointmentManager implements SessionBean
{
	SessionContext ctx;
	public void ejbCreate() {}
    public void ejbRemove() {}
    public void ejbActivate() {}
    public void ejbPassivate() {}
    public void setSessionContext( SessionContext context ) { this.ctx=context;}
/**
* @ejb.interface-method
*	 view-type="both"
*/
	public java.util.HashMap insertBookAppointment(java.util.Properties p,java.util.HashMap passObjects){
		
		// class level variables are moved. Changed @UAT-3 By Sudhakar Starts
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;    
		CallableStatement cstmt = null;
		PreparedStatement pstmt = null;
		Connection con=null;
		PreparedStatement pstmt_sql_sec_rstyp1=null;
		PreparedStatement pstmt_sql_sec_rstyp2=null;
		PreparedStatement pstmt_sql_sec_rstyp3=null;
		PreparedStatement pstmt_ins_secondary_res=null;
		PreparedStatement pstmt_sql_sec_stat=null;
		PreparedStatement pstmt_sql_upop_1=null;
		PreparedStatement pstmt_sql_upop_2=null;
		PreparedStatement pstmt_sqldssec=null;
		PreparedStatement pstmtMR = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmtOR = null;
		PreparedStatement pstmtOR1 = null;
		PreparedStatement pstmtOR2 = null;
		PreparedStatement pstmt_oa_cl_sch_dtl= null;
	    PreparedStatement pstmtgrp =null;
	    ResultSet rsgrp =null;
		ResultSet rsds=null;
		Statement Stmt2 = null;
		Statement Stmt = null;
		ResultSet rso= null;
		ResultSet rs=null;
		ResultSet rsor= null;
		CallableStatement clblstmt=null;
		CallableStatement clblstmt1=null;
		// class level variables are moved. Changed @UAT-3 By Sudhakar Ends
		String facilityId=(String) passObjects.get("addedFacilityId");
		String cliniccode=(String) passObjects.get("cliniccode");
		String practitionerid=(String) passObjects.get("practitionerid");
		String ordPractId=(String) passObjects.get("ordPractId");
		String appttime=(String) passObjects.get("appttime");
		String apptslabfmtime=(String) passObjects.get("apptslabfmtime");
		String apptslabtotime=(String) passObjects.get("apptslabtotime");
		String apptdate=(String) passObjects.get("apptdate");
		String patientid=(String) passObjects.get("patientid");
		String prefix=(String) passObjects.get("prefix");
		String firstname=(String) passObjects.get("firstname");
		String secondname=(String) passObjects.get("secondname");
		String thirdname=(String) passObjects.get("thirdname");
		String familyname=(String) passObjects.get("familyname");
		String suffix=(String) passObjects.get("suffix");
		String patientname=(String) passObjects.get("patientname");
		//String upt_contact_dtls_mp=""; //Commented for checkstyle
		String patient_name_long=(String)passObjects.get("patient_name_long");
		String patient_name_loc_lang_long=(String)passObjects.get("patient_name_loc_lang_long");

		//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
		Boolean isSlotStartMidEndAppl = false;
		Boolean isVirtualConsultation = false;//Added by Ajay Hatwate for ML-MMOH-CRF-1930
		Boolean isVisitTypeVirtual	  = false;//Added by Ajay Hatwate for ML-MMOH-CRF-1930
			
		String gender=(String) passObjects.get("gender");
		String dateofbirth=(String) passObjects.get("dateofbirth");
		String nationalidno=(String) passObjects.get("nationalidno");
		String altid1no=(String) passObjects.get("altid1no");
		String apptcode=(String) passObjects.get("apptcode");
		String visitind=(String) passObjects.get("visitind");
		String overbooked=(String) passObjects.get("overbooked");
		String refcode=(String) passObjects.get("refcode");
		String contactreason=(String) passObjects.get("contactreason");
		String contactmode=(String) passObjects.get("contactmode");
		String apptrem=(String) passObjects.get("apptrem");
		String restelno=(String) passObjects.get("restelno");
		String othtelno=(String) passObjects.get("othtelno");
		String emailid=(String) passObjects.get("emailid");
		String timetabletype=(String) passObjects.get("timetabletype");
		String alcn_criteria=(String) passObjects.get("alcn_criteria");
		String pat_cat=(String) passObjects.get("pat_cat");
		String nationality_code=(String) passObjects.get("nationality_code");
		String addedFacilityId=(String) passObjects.get("addedFacilityId");
		String addedAtWorkstation=(String) passObjects.get("addedAtWorkstation");
		String ref_priority=(String) passObjects.get("ref_priority");
		String no_slots=(String) passObjects.get("no_slots");
		String team_id=(String) passObjects.get("team_id");
		String inpatient_yn=(String) passObjects.get("inpatient_yn");
		String altid1typ=(String) passObjects.get("altid1typ");
		String altid1expdt=(String) passObjects.get("altid1expdt");
		String altid2no=(String) passObjects.get("altid2no");
		String altid2typ=(String) passObjects.get("altid2typ");
		String altid2expdt=(String) passObjects.get("altid2expdt");
		String altid3no=(String) passObjects.get("altid3no");
		String altid3typ=(String) passObjects.get("altid3typ");
		String altid3expdt=(String) passObjects.get("altid3expdt");
		String altid4no=(String) passObjects.get("altid4no");
		String altid4typ=(String) passObjects.get("altid4typ");
		String altid4expdt=(String) passObjects.get("altid4expdt");
		String Othaltid1=(String) passObjects.get("Othaltid1");
		String Othaltid1typ=(String) passObjects.get("Othaltid1typ");
		String ethnicGrp=(String) passObjects.get("ethnicGrp");
		String receivingDtTme=(String) passObjects.get("receivingDtTme");
		String forced=(String) passObjects.get("forced");
		String birthPlace=(String) passObjects.get("birthPlace");
		String residency=(String) passObjects.get("residency");
		String status=(String) passObjects.get("status");  
		String ethnicSbGrp=(String) passObjects.get("ethnicSbGrp");
		String global=(String) passObjects.get("global");
		String res_addr1=(String) passObjects.get("res_addr1");
		String res_addr2=(String) passObjects.get("res_addr2");
		String res_addr3=(String) passObjects.get("res_addr3");
		String res_addr4=(String) passObjects.get("res_addr4");
		String res_town=(String) passObjects.get("res_town");
		String res_area=(String) passObjects.get("res_area");
		String res_postal=(String) passObjects.get("res_postal");
		String res_region=(String) passObjects.get("res_region");
		String res_country=(String) passObjects.get("res_country");
		String mail_addr1=(String) passObjects.get("mail_addr1");
		String mail_addr2=(String) passObjects.get("mail_addr2");
		String mail_addr3=(String) passObjects.get("mail_addr3");
		String mail_addr4=(String) passObjects.get("mail_addr4");
		String mail_town=(String) passObjects.get("mail_town");
		String mail_area=(String) passObjects.get("mail_area");
		String mail_postal=(String) passObjects.get("mail_postal");
		String mail_region=(String) passObjects.get("mail_region");
		String mail_country=(String) passObjects.get("mail_country");
		String birthPlace_desc=(String) passObjects.get("birthPlace_desc");
		String clinic_type=(String) passObjects.get("clinic_type");
		String res_class=(String) passObjects.get("res_class");
		String canldapptrefno=(String) passObjects.get("canldapptrefno");
		java.util.ArrayList sec_resources=(java.util.ArrayList) passObjects.get("sec_reourses");
		String speciality_code=(String) passObjects.get("speciality_code");
		String pref_date=(String) passObjects.get("pref_date");
		String priority=(String) passObjects.get("priority");
		//String order_catalog_criteria=(String) passObjects.get("order_catalog_criteria");
		String pre_admit_order_catalog_code=(String) passObjects.get("pre_admit_order_catalog_code");
		//String or_order_date=(String) passObjects.get("or_order_date");
		String recurringdays=(String) passObjects.get("recurringdays");
		String order_id=(String) passObjects.get("order_id");
		String order_line_num=(String) passObjects.get("order_line_num");
		String or_catalogue_code=(String) passObjects.get("or_catalogue_code");
		if(or_catalogue_code ==null) or_catalogue_code="";
		String order_catalog_code=(String) passObjects.get("order_catalog_code");
		String req_id=(String) passObjects.get("req_id");
		String name_prefix_oth_lang=(String) passObjects.get("name_prefix_oth_lang");
		String first_name_oth_lang=(String) passObjects.get("first_name_oth_lang");
		String second_name_oth_lang=(String) passObjects.get("second_name_oth_lang");
		String third_name_oth_lang=(String) passObjects.get("third_name_oth_lang");
		String family_name_oth_lang=(String) passObjects.get("family_name_oth_lang");
		String name_suffix_oth_lang=(String) passObjects.get("name_suffix_oth_lang");
		String patient_name_local_lang=(String) passObjects.get("patient_name_local_lang");
		//String Function_id=(String) passObjects.get("Function_id");
		String P_EPISODE_TYPE=(String) passObjects.get("P_EPISODE_TYPE");
		//String P_MODE=(String) passObjects.get("P_MODE");
		String capture_fin_dtls_yn=(String) passObjects.get("capture_fin_dtls_yn");
		String billing_group=(String) passObjects.get("billing_group");
		String bl_operational=(String) passObjects.get("bl_operational");
		String from_page=(String) passObjects.get("from_page");
		String sel_service_code=(String) passObjects.get("sel_service_code");
		String from_facility_id=(String) passObjects.get("from_facility_id");
		String from_encounter_id=(String) passObjects.get("from_encounter_id");
		String send_email_yn=(String) passObjects.get("send_email_yn");
		String alcn_category=(String) passObjects.get("alcn_category");
		HashMap patInstructionsMap=(HashMap) passObjects.get("patInstructionsMap");
		HashMap prcInstructionMap=(HashMap) passObjects.get("prcInstructionMap");
		String patCnclCount	=(String) passObjects.get("patCnclCount");//changes for BruHIMS-CRF 169
		String trans_exceed_reason_code	=(String) passObjects.get("trans_exceed_reason_code");
		String upt_contact_dtls_mp_yn=(String) passObjects.get("upt_contact_dtls_mp_yn");//added changes for HSA-CRF-0226 [IN:050599]
		String upd_pat_dtls_referral_yn=(String) passObjects.get("upd_pat_dtls_referral_yn");//Added by Dharma  on Apr 13th 2016 against HSA-CRF-0303 [IN:054572]
		/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
		String altAddrLine1		= checkForNull((String)passObjects.get("altAddrLine1"));
		String altAddrLine2		= checkForNull((String)passObjects.get("altAddrLine2"));
		String altAddrLine3		= checkForNull((String)passObjects.get("altAddrLine3"));
		String altAddrLine4		= checkForNull((String)passObjects.get("altAddrLine4"));
		String altAreaCode		= checkForNull((String)passObjects.get("altAreaCode"));
		String altTownCode		= checkForNull((String)passObjects.get("altTownCode"));
		String altPostalCode	= checkForNull((String)passObjects.get("altPostalCode"));
		String altRegionCode	= checkForNull((String)passObjects.get("altRegionCode"));
		String altCountryCode	= checkForNull((String)passObjects.get("altCountryCode"));
		/*End*/
		//Added by Ajay Hatwate for ML-MMOH-CRF-1930
		String ccNxtOfKinNo = checkForNull((String)passObjects.get("ccNxtOfKinNo"));
		String nxtOfKinNo = checkForNull((String)passObjects.get("nxtOfKinNo"));
		String patCountryCode = checkForNull((String)passObjects.get("patCountryCode"));
		String patTelCode = checkForNull((String)passObjects.get("patTelCode"));
		//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
		String smartCardFunc = checkForNull((String)passObjects.get("smartCardFunc"));
		String biometric_reason = checkForNull((String)passObjects.get("biometric_reason"));
		//Ends
		
		String group_id				= "";
		if(alcn_category==null)
			alcn_category="";
		String frm_facility_id="";
		String from_enc_id="";
		String reason_for_modify="";
		//long time1=0;
		//long time2=0;
		HashMap	fin_dtls  = (HashMap)passObjects.get("fin_dtls");
		String locale = p.getProperty("LOCALE");
		String strFunctionId		= "BOOKING";
		java.util.HashMap results = new java.util.HashMap() ;
		int res_up=0;
		int resu=0;
		int res2=0;
		int res3=0;
		int max_pat_per_slab=0;
		int Max_OB_possible=0;
		int tot_slot_ob=0;
		int tot_slbfrf_ob=0;
		boolean result = false ;
	    boolean insertable = true ;
		StringBuffer sb = new StringBuffer( "" ) ;
		java.lang.StringBuffer strbfrsql=new java.lang.StringBuffer("");
	    String addedById = p.getProperty( "login_user" ) ;
	    String modifiedById = p.getProperty( "login_user" ) ;
		addedFacilityId=facilityId;
	    String modifiedFacilityId = addedFacilityId ;
	    String modifiedAtWorkstation = addedAtWorkstation ;
		String time="";
		String act_alcn_catg_code=alcn_category;
		if(act_alcn_catg_code==null)act_alcn_catg_code="";
		String disp_appt_ref_no="";
		String slot_appt_ctrl = "";
		String sql_MR="";
		String errmsg="";
		String OR_VAL_CHK="";
		if(forced.equals("Y"))
			overbooked="N";
		int totaloverbooked=0;
		int totalslotsoverbooked=0;
		if (no_slots==""||no_slots.equals("")) no_slots="0";
		int no_slots_value=Integer.parseInt(no_slots);
		OR_VAL_CHK = (String) passObjects.get("or_install_yn");
		slot_appt_ctrl = (String) passObjects.get("slot_appt_ctrl");
		if(OR_VAL_CHK == null || OR_VAL_CHK.equals("null")){
			OR_VAL_CHK="";
		}
		String rule_based_tr		= (String)passObjects.get("rule_based_tr");
		String language_id			= (String)passObjects.get("language_id");
		String pract_override_reason	= (String)passObjects.get("pract_override_reason");
		String patient_cat_code = (String)passObjects.get("patient_cat_code");			
		String term_set_id = (String)passObjects.get("term_set_id");
		String term_code = (String)passObjects.get("term_code");
		String rd_appt_yn = (String)passObjects.get("rd_appt_yn");
		String multi_speciality_yn = (String)passObjects.get("multi_speciality_yn");//Added for the CRF - Bru-HIMS-CRF-198
		String appt_category = "";
		//if(rule_based_tr.equals("Y") && (forced.equals("N") && overbooked.equals("N"))){
		if(res_class.equals("P")){
			if(rule_based_tr !=null && rule_based_tr.equals("Y")){
				if(!patientid.equals("")){
					appt_category = "3"; //Old Patient and practitioner Not Specified
				}else{
					appt_category = "4"; //New Patient and practitioner Not Specified
				}
			}else{
				//}else if(forced.equals("N") && overbooked.equals("N")){
				if(!patientid.equals("")){
					appt_category = "1"; //Old Patient and practitioner Specified
				}else{
					appt_category = "2"; //New Patient and practitioner Specified
				}
			}
		}else{
			appt_category = "5"; //For Non-practitioners
		}
		if(language_id == null)language_id="";
		if(pract_override_reason == null)pract_override_reason="";
		
	    try{
			String nextsrlno1="";
			String sql4="";
			if(from_page.equals("")){
				con = ConnectionManager.getConnection(p);
				//con1 = ConnectionManager.getConnection(p);
				con.setAutoCommit( false );
				//con1.setAutoCommit( false );

				isSlotStartMidEndAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA", "BRU_HEALTH_INTG");//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
				isVirtualConsultation = eCommon.Common.CommonBean.isSiteSpecific(con, "OP", "VIRTUAL_CONSULTATION");//Added by Ajay Hatwate for ML-MMOH-CRF-1930
				
				if(isVirtualConsultation){

					String isVC = "";
					String checkIsVisitTypeVirtualSql = "select VIRTUAL_CONSULTATION from op_visit_type where visit_type_code = ? and facility_id = ? ";
					pstmt = con.prepareStatement(checkIsVisitTypeVirtualSql);
					pstmt.setString(1,apptcode);
					pstmt.setString(2,facilityId);
					rs = pstmt.executeQuery();
					rs.next();
					isVC = checkForNull(rs.getString("VIRTUAL_CONSULTATION"));

					if(isVC.equals("E")){
						isVisitTypeVirtual = true;
					}

					if(pstmt!=null) pstmt.close();
					if(rs!=null) rs.close();

				}


				if(OR_VAL_CHK.equals("")){
					String OR_oper_stat="select OPERATIONAL_YN from sm_modules_facility where module_id='OR' and facility_id= '"+addedFacilityId+"' ";
					Stmt2 = con.createStatement();
					rsor=Stmt2.executeQuery(OR_oper_stat);
					if(rsor !=null && rsor.next()){
						OR_VAL_CHK=rsor.getString("OPERATIONAL_YN");
						if(OR_VAL_CHK == null) OR_VAL_CHK="";
					}
				}
				// Checking for the Overlapping ie concurrency part
				//String sql_O="select total_overbooked,total_slots_overbooked,nvl(Max_patients_Per_Slab,0) Max_patients_Per_Slab,nvl(max_over_booking,0) max_over_booking  from oa_clinic_schedule where facility_id=? and clinic_code=? and trunc(clinic_date)=to_date(?,'dd/mm/yyyy') and nvl(practitioner_id,'X')=nvl(?,'X') and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_class+"' and primary_resource_yn='Y'"; Modified for tuning
				String sql_O="";
				if(practitionerid.equals("")){
					sql_O="select total_overbooked,total_slots_overbooked,nvl(Max_patients_Per_Slab,0) Max_patients_Per_Slab,nvl(max_over_booking,0) max_over_booking  from oa_clinic_schedule where facility_id=? and clinic_code=? and clinic_date=to_date(?,'dd/mm/yyyy')and care_locn_type_ind=? and resource_class=? and primary_resource_yn='Y'  and practitioner_id is null ";
				}else{
					sql_O="select total_overbooked,total_slots_overbooked,nvl(Max_patients_Per_Slab,0) Max_patients_Per_Slab,nvl(max_over_booking,0) max_over_booking  from oa_clinic_schedule where facility_id=? and clinic_code=? and clinic_date=to_date(?,'dd/mm/yyyy') and care_locn_type_ind=? and resource_class=? and primary_resource_yn='Y'  and practitioner_id=?";
				}
				if (pstmt1!=null) pstmt1.close();
				if (rso!=null) rso.close();
				pstmt1=con.prepareStatement(sql_O);
				pstmt1.setString(1, addedFacilityId);
				pstmt1.setString(2, cliniccode);
				pstmt1.setString(3, apptdate);
				pstmt1.setString(4, clinic_type);
				pstmt1.setString(5, res_class);
				if(!practitionerid.equals("")){
					pstmt1.setString(6, practitionerid);
				}
				rso=pstmt1.executeQuery();
				if(rso !=null && rso.next()){
					totaloverbooked=rso.getInt("total_overbooked");
					totalslotsoverbooked=rso.getInt("total_slots_overbooked");
					max_pat_per_slab = rso.getInt("Max_patients_Per_Slab");
					Max_OB_possible=rso.getInt("max_over_booking");
				}
				if(rso !=null) rso.close();
				tot_slot_ob=totalslotsoverbooked;
				tot_slbfrf_ob=totaloverbooked;
				totaloverbooked=totaloverbooked+1;
				totalslotsoverbooked=totalslotsoverbooked+1;
				if(! overbooked.equals("Y")) { // Normal Booking
					if(! timetabletype.equals("2")){ // Added for slots concurrence
						StringBuffer sql1 = new StringBuffer();
						sql1.append("select '1' from oa_appt where ((to_date(?,'HH24:mi')  +(1/(60*24)) between to_date(to_char(appt_slab_from_time,'HH24:mi'),'HH24:mi')+(1/(60*24)) and to_date(to_char(appt_slab_to_time,'HH24:mi'),'HH24:mi')) or (to_date(?,'HH24:mi')between to_date(to_char(appt_slab_from_time,'HH24:mi'),'HH24:mi')+(1/(60*24))       		and to_date(to_char(appt_slab_to_time,'HH24:mi'),'HH24:mi')) or	(to_date(to_char(APPT_SLAB_FROM_TIME,'hh24:miss'),'hh24:miss') > to_date(?,'hh24:miss') and	to_date(to_char(APPT_SLAB_FROM_TIME,'hh24:miss'),'hh24:miss')< to_date(?,'hh24:miss') 	) ) ");

						sql1.append(" and clinic_code=?	and facility_id=? and appt_date=to_date(?,'dd/mm/yyyy') and RESOURCE_CLASS=? and care_locn_type_ind='"+clinic_type+"'");
						if(practitionerid.equals("")){
							sql1.append(" and practitioner_id is null ");
						}else{
							sql1.append(" and practitioner_id =? ");
						}
						if(!forced.equals("N")){
							sql1.append("and forced_appt_YN='Y' ");
						}
						pstmt=con.prepareStatement(sql1.toString());
						pstmt.setString(1, apptslabfmtime);
						pstmt.setString(2, apptslabtotime);
						pstmt.setString(3, apptslabfmtime);
						pstmt.setString(4, apptslabtotime);
						pstmt.setString(5, cliniccode);
						pstmt.setString(6, addedFacilityId);
						pstmt.setString(7, apptdate);
						pstmt.setString(8, res_class);
						if(!practitionerid.equals("")){
							pstmt.setString(9, practitionerid) ;
						}
						if(rs!=null)rs.close();
						rs=pstmt.executeQuery();
						sql1.setLength(0);
						if (rs.next() && rs != null ) {
							insertable = false;
							java.util.Hashtable message = MessageManager.getMessage( locale,"APPT_OVERLAP","OA" ) ;
							sb.append( (String) message.get("message") ) ;
							message.clear();
						}else{
							insertable = true;
						}
						if (pstmt!=null) pstmt.close();
						if(rs!=null)rs.close();
					}else{ // Added for slabs concurrency
						StringBuffer s66= new StringBuffer("");
						s66.append("select count(appt_ref_no) from oa_appt where to_date(to_char(appt_slab_from_time,'HH24:mi'),'HH24:mi') = to_date(?,'HH24:mi') and to_date(to_char(appt_slab_to_time,'HH24:mi'),'HH24:mi') = to_date(?,'HH24:mi') and clinic_code = ? and appt_date = to_date(?,'dd/mm/yyyy') and facility_id = ? and care_locn_type_ind=? and resource_class=? ");
						if(!forced.equals("N")){
							s66.append(" and forced_appt_YN='Y' ");
						}
						if(practitionerid.equals("")){
							s66.append(" and practitioner_id is null ");
						}else{
							s66.append(" and practitioner_id =? ");
						}
						if (pstmt!=null) pstmt.close();
						if (rs!=null) rs.close();

						pstmt = con.prepareStatement(s66.toString());
						pstmt.setString(1, apptslabfmtime);
						pstmt.setString(2, apptslabtotime);
						pstmt.setString(3, cliniccode);
						pstmt.setString(4, apptdate);
						pstmt.setString(5, addedFacilityId);
						pstmt.setString(6, clinic_type);
						pstmt.setString(7, res_class);
						if(!practitionerid.equals("")){
							pstmt.setString(8, practitionerid);
						}
						rs = pstmt.executeQuery();
						s66.setLength(0);
						int i3=0;
						if(rs.next() && rs != null){
							i3 = rs.getInt(1);
							if(forced.equals("N")){
								if(i3 < max_pat_per_slab){
									insertable = true;
								}else{
									insertable = false;
									java.util.Hashtable message = MessageManager.getMessage( locale,"APPT_OVERLAP","OA" ) ;
									sb.append( (String) message.get("message") ) ;
									message.clear();
								}
							}else{
								if(i3>0){
									insertable = false;
									java.util.Hashtable message = MessageManager.getMessage( locale,"APPT_OVERLAP","OA") ;
									sb.append( (String) message.get("message") ) ;
									message.clear();
								}else{
									insertable = true;
								}
							}
						}
						if (pstmt!=null) pstmt.close();
						if (rs!=null) rs.close();

						if(insertable){
							//Concurrency check for a particular patient ie to chk if he/she has an appt on the same date and same time elsewhere
							if(!patientid.equals("")){
								Stmt = con.createStatement();
								String chk_overlap1= "select '1'  from oa_appt where facility_id='"+addedFacilityId+"' and ((to_date('"+apptslabfmtime+"','HH24:mi')  +(1/(60*24)) between to_date(to_char(appt_slab_from_time,'HH24:mi'),'HH24:mi')+(1/(60*24)) and to_date(to_char(appt_slab_to_time,'HH24:mi'),'HH24:mi')) or 	(to_date('"+apptslabtotime+"','HH24:mi') between  		to_date(to_char(appt_slab_from_time,'HH24:mi'),'HH24:mi')+(1/(60*24)) and to_date(to_char(appt_slab_to_time,'HH24:mi'),'HH24:mi')) or 	(to_date(to_char(APPT_SLAB_FROM_TIME,'hh24:miss'),'hh24:miss') > to_date('"+apptslabfmtime+"','hh24:miss')  and	to_date(to_char(APPT_SLAB_FROM_TIME,'hh24:miss'),'hh24:miss') < to_date('"+apptslabtotime+"','hh24:miss'))) and appt_date = to_date('"+apptdate+"','dd/mm/yyyy') and patient_id='"+patientid+"'	and CARE_LOCN_TYPE_IND='"+clinic_type+"'";
								if (rs!=null) rs.close();
								rs = Stmt.executeQuery(chk_overlap1) ;
								if(rs !=null){
									if(rs.next()){
										insertable = false;
										java.util.Hashtable message = MessageManager.getMessage( locale,"APPT_OVERLAP","OA") ;
										sb.append( (String) message.get("message") ) ;
										message.clear();
									}else{
										insertable = true;
									}
								}
								if(rs!=null)rs.close();
								if(insertable){
									String chk_over_pat_locn= "select '1'  from oa_appt where facility_id='"+addedFacilityId+"' and ((to_date('"+apptslabfmtime+"','HH24:mi')  +(1/(60*24)) between to_date(to_char(appt_slab_from_time,'HH24:mi'),'HH24:mi')+(1/(60*24)) and to_date(to_char(appt_slab_to_time,'HH24:mi'),'HH24:mi')) or 	(to_date('"+apptslabtotime+"','HH24:mi') between  to_date(to_char(appt_slab_from_time,'HH24:mi'),'HH24:mi')+(1/(60*24)) and to_date(to_char(appt_slab_to_time,'HH24:mi'),'HH24:mi')) or 	(to_date(to_char(APPT_SLAB_FROM_TIME,'hh24:miss'),'hh24:miss') > to_date('"+apptslabfmtime+"','hh24:miss')  and	to_date(to_char(APPT_SLAB_FROM_TIME,'hh24:miss'),'hh24:miss') < to_date('"+apptslabtotime+"','hh24:miss'))) and appt_date = to_date('"+apptdate+"','dd/mm/yyyy') and patient_id='"+patientid+"'	and CARE_LOCN_TYPE_IND='"+clinic_type+"' and clinic_code='"+cliniccode+"' ";
									if (rs!=null) rs.close();
									rs = Stmt.executeQuery(chk_over_pat_locn) ;

									if(rs !=null){
										if(rs.next()){
											insertable = false;
											java.util.Hashtable message = MessageManager.getMessage( con, 	"APPT_OVERLAP" ) ;
											sb.append( (String) message.get("message") ) ;
											message.clear();
										}else{
											insertable = true;
										}
									}
									if(rs!=null)rs.close();
								}
							}
						}// end insertable
					}
				}else{// Added for overbooking concurrency
					if(timetabletype.equals("1")){
						if(tot_slot_ob>=Max_OB_possible){
							insertable = false;
							java.util.Hashtable message = MessageManager.getMessage( locale,"APPT_OVERLAP","OA") ;
							sb.append( (String) message.get("message") ) ;
							message.clear();
						}
					}else{
						if(tot_slbfrf_ob>=Max_OB_possible){
							insertable = false;
							java.util.Hashtable message = MessageManager.getMessage( locale,"APPT_OVERLAP","OA" ) ;
							sb.append( (String) message.get("message") ) ;
							message.clear();
						}
					}
				}
				//Here its been checked for the referral id wht is the status and if its 'C' then error message is alerted and will not proceed further..
				if(!(refcode.equals(""))){
					final String sql2 ="select status  from pr_referral_register where referral_id = ? ";
					if (pstmt!=null) pstmt.close();
					if (rs!=null) rs.close();
					pstmt=con.prepareStatement(sql2);
					pstmt.setString(1, refcode) ;
					rs=pstmt.executeQuery();
					if (rs.next() && rs != null )
					{
						if (rs.getString(1).equals("C"))
						{
							insertable = false;
							java.util.Hashtable message = MessageManager.getMessage( locale,"APPT_BOOKED_FOR_REFERRAL","OA") ;
							sb.append( (String) message.get("message") ) ;
							message.clear();
						}else
						{
							insertable = true;
						}
					}
					if(rs!=null)rs.close();
				   if (pstmt!=null) pstmt.close(); //Checkstyle violation 
				}
				//	OA_GENERATE_APPT_ID Procedure being called where chk for the max serial num chk is done and updation of the OA_APPT_SRL_NO is done
				try{
					//cstmt=con1.prepareCall("{call OA_GENERATE_APPT_ID(?,?,?,?,?,?)}");
					cstmt=con.prepareCall("{call OA_GENERATE_APPT_ID(?,?,?,?,?,?)}");
					cstmt.setString(1,addedFacilityId);
					cstmt.setString(2,addedById);
					cstmt.setString(3,addedAtWorkstation);
					cstmt.registerOutParameter(4,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(5,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
					
					cstmt.execute();
					
					errmsg=cstmt.getString(6);
					//con1.commit();
					if(errmsg == null) errmsg="";
					if(errmsg.equals("")){
						nextsrlno1=cstmt.getString(4);
						disp_appt_ref_no=String.valueOf(nextsrlno1);
						insertable=true;
					}else{
						insertable=false;
						sb.append(errmsg);
					}
					try{
					}catch(Exception con1ex){
						con1ex.printStackTrace();
					}
					if(cstmt != null) cstmt.close();
				}catch(Exception e){
					e.printStackTrace();
					insertable=false;
				}
				if(timetabletype.equals("2")){
				//	String sqlgrp	=  "SELECT GROUP_ID FROM oa_group_dtls WHERE patient_id = ? AND GROUP_ID IN (SELECT DISTINCT (GROUP_ID) FROM oa_appt WHERE clinic_code = ? AND FACILITY_ID = ?) AND GROUP_ID NOT IN ( SELECT GROUP_ID FROM oa_appt WHERE clinic_code = ? AND TO_CHAR (appt_slab_from_time, 'hh24:mi') = ? AND TO_CHAR (appt_slab_to_time, 'hh24:mi') = ?  AND appt_date = TO_DATE (?, 'dd/mm/yyyy') AND patient_id = ? AND FACILITY_ID = ? ) AND ADDED_FACILITY_ID=?";
					String sqlgrp	=  "SELECT GROUP_ID  FROM oa_group_dtls WHERE patient_id = ? AND GROUP_ID IN (SELECT DISTINCT (GROUP_ID) FROM oa_appt                    WHERE clinic_code = ? AND facility_id = ?  AND TO_CHAR (appt_slab_from_time, 'hh24:mi') >= ? AND TO_CHAR (appt_slab_to_time, 'hh24:mi') <= ?                      AND appt_date = TO_DATE (?, 'dd/mm/yyyy')) AND added_facility_id = ? AND GROUP_ID NOT IN (SELECT GROUP_ID FROM oa_appt WHERE clinic_code = ?             AND TO_CHAR (appt_slab_from_time, 'hh24:mi') >= ? AND TO_CHAR (appt_slab_to_time, 'hh24:mi') <= ? AND appt_date = TO_DATE (?, 'dd/mm/yyyy') AND patient_id = ?  AND facility_id = ?)";
					pstmtgrp=con.prepareStatement(sqlgrp.toString());
					pstmtgrp.setString(1, patientid);
					pstmtgrp.setString(2, cliniccode);
					pstmtgrp.setString(3, addedFacilityId);					
					pstmtgrp.setString(4, apptslabfmtime);
					pstmtgrp.setString(5, apptslabtotime);
					pstmtgrp.setString(6, apptdate);
					pstmtgrp.setString(7, addedFacilityId);
					pstmtgrp.setString(8, cliniccode);
					pstmtgrp.setString(9, apptslabfmtime);
					pstmtgrp.setString(10, apptslabtotime);
					pstmtgrp.setString(11, apptdate);
					pstmtgrp.setString(12, patientid);
					pstmtgrp.setString(13, addedFacilityId);					
					rsgrp=pstmtgrp.executeQuery();
					if (rsgrp.next() && rsgrp != null ) {
						group_id = rsgrp.getString("GROUP_ID")==null?"":rsgrp.getString("GROUP_ID");
					}

					if (pstmtgrp!=null) pstmtgrp.close();
					if (rsgrp!=null) rsgrp.close();
				}
				
				strbfrsql.append(" insert into  oa_appt(facility_id,appt_ref_no, clinic_code,practitioner_id, appt_date,appt_time,appt_slab_from_time,appt_slab_to_time,appt_duration,appt_slots,patient_id,name_prefix,first_name,second_name,third_name,family_name,name_suffix, patient_name,gender,date_of_birth,res_tel_no, oth_contact_no,email_id,national_id_no, alt_id1_no,res_addr_line1, res_addr_line2,res_addr_line3, res_addr_line4,postal_code, country_code,alcn_criteria,alcn_catg_code,appt_type_code, overbooked_yn,referral_id, contact_reason_code, mode_of_contact, appt_remarks,appt_status, inpatient_yn,added_by_id,  added_date,added_facility_id, added_at_ws_no,modified_by_id,  modified_date,modified_facility_id, modified_at_ws_no, pat_alcn_catg_code,referral_priority,NO_OF_SLOTS,team_id");
				if(!altid1expdt.equals("N"))
					strbfrsql.append(",ALT_ID1_EXP_DATE");
				if(!altid2expdt.equals("N"))
					strbfrsql.append(",ALT_ID2_EXP_DATE");
				if(!altid3expdt.equals("N"))
					strbfrsql.append(",ALT_ID3_EXP_DATE");
				if(!altid4expdt.equals("N"))
					strbfrsql.append(",ALT_ID4_EXP_DATE");
				if(!receivingDtTme.equals("N"))
					strbfrsql.append(",RECEIVING_DATE_TIME");
				strbfrsql.append(",ALT_ID1_TYPE,ALT_ID2_NO,ALT_ID2_TYPE,ALT_ID3_NO,ALT_ID3_TYPE,ALT_ID4_NO,ALT_ID4_TYPE,OTH_ALT_ID_NO,OTH_ALT_ID_TYPE,ETHNIC_GROUP_CODE,FORCED_APPT_YN,BIRTH_PLACE_CODE,CITIZEN_YN,LEGAL_YN,RACE_CODE,GLOBAL_APPT_YN,RES_AREA_CODE,RES_TOWN_CODE,RES_REGION_CODE,MAIL_ADDR_LINE1,MAIL_ADDR_LINE2,MAIL_ADDR_LINE3,MAIL_ADDR_LINE4,MAIL_AREA_CODE,MAIL_TOWN_CODE,MAIL_REGION_CODE,MAIL_POSTAL_CODE,MAIL_COUNTRY_CODE,RES_COUNTRY_CODE,BIRTH_PLACE_DESC,CARE_LOCN_TYPE_IND,RESOURCE_CLASS,NAME_PREFIX_LOC_LANG,FIRST_NAME_LOC_LANG,SECOND_NAME_LOC_LANG,THIRD_NAME_LOC_LANG,FAMILY_NAME_LOC_LANG,NAME_SUFFIX_LOC_LANG,PATIENT_NAME_LOC_LANG,TIME_TABLE_TYPE,speciality_code,PATIENT_LONG_NAME,PATIENT_LONG_NAME_LOC_LANG,alt_addr_line1,alt_addr_line2,alt_addr_line3,alt_addr_line4,alt_area_code,alt_town_code,alt_region_code,alt_postal_code,alt_country_code,FROM_FACILITY_ID,FROM_ENCOUNTER_ID");//Modified by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601
				if(!or_catalogue_code.equals(""))
					strbfrsql.append(",ORDER_CATALOG_CODE");
				if(!req_id.equals(""))
					strbfrsql.append(",MR_REQUEST_ID");
				if(!sel_service_code.equals(""))
					strbfrsql.append(",SERVICE_CODE");
				strbfrsql.append(",PRACT_OVERRIDE_REASON");
				strbfrsql.append(",LANGUAGE_ID");
				strbfrsql.append(",APPT_CATEGORY,PATIENT_CAT_CODE,TERM_SET_ID,TERM_CODE,rd_appt_yn,trans_exceed_reason_code,multi_speciality_yn");	
				if(!group_id.equals(""))
					strbfrsql.append(",group_id");
				if(isVirtualConsultation){
					strbfrsql.append(", CONTACT1_MOB_COUNTRY_CODE, CONTACT1_MOB_TEL_NO, APPT_TYPE,contact2_telephone_code, contact2_country_code");
				}
				strbfrsql.append(" ) values (?,?,?,?,to_date('"+apptdate+"','dd/mm/yyyy'),to_date('"+appttime+"','hh24:mi'),to_date('"+apptslabfmtime+"','hh24:mi'),to_date('"+apptslabtotime+"','hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),?,?, ?, ?, ?, ?, ?, ?,?,?, to_date('"+dateofbirth+"','dd/mm/yyyy'),?, ?, ?,?, ?,?, ?, ?, ?, ?, ?, ?,?,?,?,?,?, ?, ?, ?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?");
				if(!altid1expdt.equals("N"))
					strbfrsql.append(",to_date('"+altid1expdt+"','dd/mm/yyyy') ");
				if(!altid2expdt.equals("N"))
					strbfrsql.append(",to_date('"+altid2expdt+"','dd/mm/yyyy') ");
				if(!altid3expdt.equals("N"))
					strbfrsql.append(",to_date('"+altid3expdt+"','dd/mm/yyyy') ");
				if(!altid4expdt.equals("N"))
					strbfrsql.append(",to_date('"+altid4expdt+"','dd/mm/yyyy') ");
				if(!receivingDtTme.equals("N"))
					strbfrsql.append(",to_date('"+receivingDtTme+"','dd/mm/yyyy hh24:mi') ");
				strbfrsql.append(",?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'"+from_facility_id+"','"+from_encounter_id +"'");//Modified by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601
				if(!or_catalogue_code.equals(""))
					strbfrsql.append(",'"+or_catalogue_code+"'");
				if(!req_id.equals(""))
					strbfrsql.append(",'"+req_id+"'");
				if(!sel_service_code.equals(""))
					strbfrsql.append(",'"+sel_service_code+"'");
				strbfrsql.append(",'"+pract_override_reason+"'");
				strbfrsql.append(",'"+language_id+"'");
				strbfrsql.append(",'"+appt_category+"'");	
				strbfrsql.append(",'"+patient_cat_code+"'");
				strbfrsql.append(",'"+term_set_id+"'");
				strbfrsql.append(",'"+term_code+"'");
				strbfrsql.append(",'"+rd_appt_yn+"'");
				strbfrsql.append(",'"+trans_exceed_reason_code+"'");
				strbfrsql.append(",'"+multi_speciality_yn+"'");//Added for the CRF - Bru-HIMS-CRF-198
				if(!group_id.equals(""))					
				strbfrsql.append(",'"+group_id+"'");//Added for the CRF - Bru-HIMS-CRF-191

				if(isVirtualConsultation){
					strbfrsql.append(",'"+ccNxtOfKinNo+"','"+nxtOfKinNo+"' ");
					if(isVisitTypeVirtual){
						strbfrsql.append(", 'Virtual' ");
					}else{
						strbfrsql.append(", 'Direct' ");
					}
					strbfrsql.append(", '"+patTelCode+"', '"+patCountryCode+"'  ");
				}
				//strbfrsql.append(",'"+patient_name_long+"'");				
				//strbfrsql.append(",'"+patient_name_loc_lang_long+"'");				
				strbfrsql.append(")") ;
					if(pstmt2 !=null) pstmt2.close();
				final String sqlds="select get_time_between(to_date('"+apptdate+" "+apptslabtotime+"',' dd/mm/yyyy hh24:mi'),to_date('"+apptdate+" "+apptslabfmtime+"','dd/mm/yyyy hh24:mi')) from dual ";

				pstmt1=con.prepareStatement(sqlds);
				
				rsds=pstmt1.executeQuery();
				
				if(rsds !=null && rsds.next()){
					time=rsds.getString(1);
					time=apptdate+" "+time;
				}
				if (rsds !=null) rsds.close();
				if (pstmt1!=null) pstmt1.close();
				/*String sqlo="select slot_appt_ctrl from oa_param where module_id='OA'";

				pstmt1=con.prepareStatement(sqlo);
				rso=pstmt1.executeQuery();
				if (rso!=null && rso.next())
					slot_appt_ctrl=rso.getString("slot_appt_ctrl");
				if (rso!=null) rso.close();
				if (pstmt1!=null) pstmt1.close();*/
				if(practitionerid==null) practitionerid="";
				if ( insertable ) {
					if (pstmt!=null) pstmt.close();
					pstmt = con.prepareStatement( strbfrsql.toString() );
					
					pstmt.setString	( 1,  addedFacilityId ) ;
					pstmt.setString	( 2,  nextsrlno1 ) ;
					pstmt.setString	( 3,  cliniccode ) ;
					pstmt.setString	( 4,  practitionerid ) ;
					pstmt.setString	( 5,  time ) ;
					pstmt.setString ( 6,  null);
					pstmt.setString	( 7,  patientid ) ;
					pstmt.setString	( 8,  prefix ) ;
					pstmt.setString	( 9,  firstname ) ;
					pstmt.setString	( 10, secondname ) ;
					pstmt.setString	( 11, thirdname ) ;
					pstmt.setString	( 12, familyname ) ;
					pstmt.setString ( 13, suffix ) ;
					pstmt.setString	( 14, patientname ) ;
					pstmt.setString ( 15, gender );
					pstmt.setString ( 16, restelno);
					pstmt.setString ( 17, othtelno);
					pstmt.setString ( 18, emailid);
					pstmt.setString	( 19, nationalidno ) ;
					pstmt.setString	( 20, altid1no ) ;
					pstmt.setString ( 21, res_addr1);
					pstmt.setString ( 22, res_addr2);
					pstmt.setString ( 23, res_addr3);
					pstmt.setString ( 24, res_addr4);
					if(res_postal.equals(" ") || res_postal== null || res_postal.equals("") || res_postal.equals("null"))
					pstmt.setString ( 25, "");
					else
					pstmt.setString ( 25, res_postal);

					if(nationality_code.equals(" ") || nationality_code== null || nationality_code.equals("") || nationality_code.equals("null")  )
					pstmt.setString ( 26, "");
					else
					pstmt.setString ( 26, nationality_code);
					pstmt.setString ( 27, alcn_criteria);
					if(overbooked.equals("N") || (forced!=null && forced.equals("N"))){
						pstmt.setString ( 28, act_alcn_catg_code);
					}else{
						pstmt.setString ( 28, "");
					}
					pstmt.setString	( 29, apptcode ) ;
					pstmt.setString ( 30, overbooked );
					pstmt.setString	( 31, refcode ) ;
					pstmt.setString	( 32, contactreason ) ;
					pstmt.setString	( 33, contactmode ) ;
					pstmt.setString	( 34, apptrem  ) ;
					pstmt.setString	( 35, "1" ) ;
					pstmt.setString ( 36, inpatient_yn );
					pstmt.setString ( 37, addedById );
					pstmt.setString	( 38, addedFacilityId ) ;
					pstmt.setString	( 39, addedAtWorkstation  ) ;
					pstmt.setString	( 40, modifiedById ) ;
					pstmt.setString ( 41, modifiedFacilityId );
					pstmt.setString	( 42, modifiedAtWorkstation ) ;
					pstmt.setString	( 43, pat_cat ) ;
					pstmt.setString	( 44, ref_priority ) ;
					pstmt.setInt	( 45, no_slots_value ) ;
					pstmt.setString	( 46, team_id ) ;
					pstmt.setString	( 47, altid1typ ) ;
					pstmt.setString	( 48, altid2no ) ;
					pstmt.setString	( 49, altid2typ ) ;
					pstmt.setString	( 50, altid3no ) ;
					pstmt.setString	( 51, altid3typ ) ;
					pstmt.setString	( 52, altid4no ) ;
					pstmt.setString	( 53, altid4typ ) ;
					pstmt.setString	( 54, Othaltid1 ) ;
					pstmt.setString	( 55, Othaltid1typ ) ;
					pstmt.setString	( 56, ethnicGrp ) ;
					pstmt.setString	( 57, forced ) ;
					pstmt.setString	( 58, birthPlace ) ;
					pstmt.setString	( 59, residency ) ;
					pstmt.setString	( 60, status ) ;
					pstmt.setString	( 61, ethnicSbGrp ) ;
					pstmt.setString	( 62, global ) ;
					pstmt.setString	( 63, res_area ) ;
					pstmt.setString	( 64, res_town ) ;
					pstmt.setString	( 65, res_region ) ;
					pstmt.setString	( 66, mail_addr1 ) ;
					pstmt.setString	( 67, mail_addr2 ) ;
					pstmt.setString	( 68, mail_addr3 ) ;
					pstmt.setString	( 69, mail_addr4 ) ;
					pstmt.setString	( 70, mail_area ) ;
					pstmt.setString	( 71, mail_town ) ;
					pstmt.setString	( 72, mail_region ) ;
					pstmt.setString	( 73, mail_postal ) ;
					pstmt.setString	( 74, mail_country ) ;
					pstmt.setString	( 75, res_country ) ;
					pstmt.setString	( 76, birthPlace_desc ) ;
					pstmt.setString	( 77, clinic_type ) ;
					pstmt.setString	( 78, res_class ) ;
					pstmt.setString ( 79, name_prefix_oth_lang);
					pstmt.setString ( 80, first_name_oth_lang);
					pstmt.setString ( 81, second_name_oth_lang);
					pstmt.setString ( 82, third_name_oth_lang);
					pstmt.setString ( 83, family_name_oth_lang);
					pstmt.setString ( 84, name_suffix_oth_lang);
					pstmt.setString ( 85, patient_name_local_lang);
					pstmt.setString ( 86, timetabletype);
					pstmt.setString ( 87, speciality_code);
					pstmt.setString ( 88, patient_name_long);
					pstmt.setString ( 89, patient_name_loc_lang_long);
					/*Added by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601 Start*/
					pstmt.setString (90, altAddrLine1);
					pstmt.setString (91, altAddrLine2);
					pstmt.setString (92, altAddrLine3);
					pstmt.setString (93, altAddrLine4);
					pstmt.setString (94, altAreaCode);
					pstmt.setString (95, altTownCode);
					pstmt.setString (96, altRegionCode);
					pstmt.setString (97, altPostalCode);
					pstmt.setString (98, altCountryCode);
					/*End*/
					
					resu = pstmt.executeUpdate() ;
					
					strbfrsql.setLength(0);
					result=false;
					//Below  code added FOR HSA-CRF-0226 [IN:050599]
					if(upt_contact_dtls_mp_yn.equals("Y")){
					cstmt = con.prepareCall("{call MP_AUDIT_FUNCTION.ASSIGN_VALUE('SCH_APPT')}");
					 cstmt.execute();
					 if (cstmt !=null) cstmt.close();
					String update_contact_dtl= "update MP_PAT_ADDRESSES set addr1_line1='"+res_addr1.replaceAll("'","''")+"',addr1_line2='"+res_addr2.replaceAll("'","''")+"',addr1_line3='"+res_addr3.replaceAll("'","''")+"',addr1_line4='"+res_addr4.replaceAll("'","''")+"',postal1_code='"+res_postal+"' ,country1_code='"+res_country+"',addr2_line1='"+mail_addr1.replaceAll("'","''")+"',addr2_line2='"+mail_addr2.replaceAll("'","''")+"',addr2_line3='"+mail_addr3.replaceAll("'","''")+"',addr2_line4='"+mail_addr4.replaceAll("'","''")+"',postal2_code='"+mail_postal+"',country2_code='"+mail_country+"',modified_by_id='"+modifiedById+"',modified_date=sysdate,modified_at_ws_no='"+modifiedAtWorkstation+"',modified_facility_id='"+modifiedFacilityId+"',res_area2_code='"+mail_area+"',res_town2_code='"+mail_town+"',region2_code='"+mail_region+"',res_area1_code='"+res_area+"',res_town1_code='"+res_town+"',region1_code='"+res_region+"',alt_addr_line1='"+altAddrLine1.replaceAll("'","''")+"',alt_addr_line2='"+altAddrLine2.replaceAll("'","''")+"',alt_addr_line3='"+altAddrLine3.replaceAll("'","''")+"',alt_addr_line4='"+altAddrLine4.replaceAll("'","''")+"',alt_area_code='"+altAreaCode+"',alt_town_code='"+altTownCode+"',alt_region_code='"+altRegionCode+"',alt_postal_code='"+altPostalCode+"',alt_country_code='"+altCountryCode+"' where patient_id='"+patientid+"'";//Modified by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601

					pstmt1=con.prepareStatement(update_contact_dtl);
					pstmt1.executeUpdate();
					if (rsds !=null) rsds.close();
					if (pstmt1!=null) pstmt1.close();
					String update_contact_dtl1= "update MP_PATIENT set EMAIL_ID='"+emailid+"',CONTACT1_NO='"+restelno+"',CONTACT2_NO='"+othtelno+"',modified_by_id='"+modifiedById+"',modified_date=sysdate,modified_at_ws_no='"+modifiedAtWorkstation+"',modified_facility_id='"+modifiedFacilityId+"',RES_AREA_CODE='"+res_area+"',RES_TOWN_CODE='"+res_town+"',REGION_CODE='"+res_region+"', contact2_telephone_code='"+patTelCode+"', contact2_country_code='"+patCountryCode+"' where patient_id='"+patientid+"'";
					pstmt1=con.prepareStatement(update_contact_dtl1);
					pstmt1.executeUpdate();
					if (rsds !=null) rsds.close();
					if (pstmt1!=null) pstmt1.close();
					String  appt_count="select count(*)apt_cnt from oa_appt where patient_id='"+patientid+"' and APPT_DATE>= to_date(sysdate,'DD MM YY')";
					pstmt1 = con.prepareStatement(appt_count);
            	    rsds=pstmt1.executeQuery();
				    int apt_cnt=0;
				    if(rsds != null && rsds.next()){
				    apt_cnt=rsds.getInt("apt_cnt");
				       }
					if(apt_cnt > 1){
					String update_app_contact_dtl="update oa_appt set res_tel_no='"+restelno+"', oth_contact_no='"+othtelno+"',email_id='"+emailid+"', res_addr_line1='"+res_addr1.replaceAll("'","''")+"', res_addr_line2='"+res_addr2.replaceAll("'","''")+"',res_addr_line3='"+res_addr3.replaceAll("'","''")+"', res_addr_line4='"+res_addr4.replaceAll("'","''")+"',postal_code='"+res_postal+"',modified_date=sysdate,modified_facility_id='"+modifiedFacilityId+"',modified_by_id='"+modifiedById+"', modified_at_ws_no='"+modifiedAtWorkstation+"',RES_AREA_CODE='"+res_area+"',RES_TOWN_CODE='"+res_town+"',RES_REGION_CODE='"+res_region+"',MAIL_ADDR_LINE1='"+mail_addr1.replaceAll("'","''")+"',MAIL_ADDR_LINE2='"+mail_addr2.replaceAll("'","''")+"',MAIL_ADDR_LINE3='"+mail_addr3.replaceAll("'","''")+"',MAIL_ADDR_LINE4='"+mail_addr4.replaceAll("'","''")+"',MAIL_AREA_CODE='"+mail_area+"',MAIL_TOWN_CODE='"+mail_town+"',MAIL_REGION_CODE='"+mail_region+"',MAIL_POSTAL_CODE='"+mail_postal+"',MAIL_COUNTRY_CODE='"+mail_country+"',RES_COUNTRY_CODE='"+res_country+"',alt_addr_line1='"+altAddrLine1.replaceAll("'","''")+"',alt_addr_line2='"+altAddrLine2.replaceAll("'","''")+"',alt_addr_line3='"+altAddrLine3.replaceAll("'","''")+"',alt_addr_line4='"+altAddrLine4.replaceAll("'","''")+"',alt_area_code='"+altAreaCode+"',alt_town_code='"+altTownCode+"',alt_region_code='"+altRegionCode+"',alt_postal_code='"+altPostalCode+"',alt_country_code='"+altCountryCode+"', CONTACT1_MOB_TEL_NO='"+nxtOfKinNo+"', CONTACT1_MOB_COUNTRY_CODE = '"+ccNxtOfKinNo+"'  where patient_id='"+patientid+"' and APPT_DATE>= to_date(sysdate,'DD MM YY')";//Modified by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601
					pstmt1=con.prepareStatement(update_app_contact_dtl);
					pstmt1.executeUpdate();
					if (rsds !=null) rsds.close();
					if (pstmt1!=null) pstmt1.close();
					}
					}
					//end  of HSA-CRF-0226 [IN:050599]
					//Added by Ajay Hatwate for ML-MMOH-CRF-1930
					if(isVirtualConsultation){
						if(pstmt1!=null) pstmt1.close();
							String updateVirtualDet1= "update mp_patient set EMAIL_ID='"+emailid+"',CONTACT1_NO='"+restelno+"',CONTACT2_NO='"+othtelno+"',modified_by_id='"+modifiedById+"',modified_date=sysdate,modified_at_ws_no='"+modifiedAtWorkstation+"',modified_facility_id='"+modifiedFacilityId+"', contact2_telephone_code='"+patTelCode+"', contact2_country_code='"+patCountryCode+"' where patient_id='"+patientid+"'";
						pstmt1=con.prepareStatement(updateVirtualDet1);
						pstmt1.executeUpdate();
						if(pstmt1!=null) pstmt1.close();
							String updateVirtualDet2= "update MP_PAT_REL_CONTACTS set contact1_mob_tel_no='"+nxtOfKinNo+"', CONTACT1_MOB_COUNTRY_CODE='"+ccNxtOfKinNo+"', modified_by_id='"+modifiedById+"', modified_date=sysdate, modified_at_ws_no='"+modifiedAtWorkstation+"', modified_facility_id='"+modifiedFacilityId+"' where patient_id='"+patientid+"'";
						pstmt1=con.prepareStatement(updateVirtualDet2);
						pstmt1.executeUpdate();
						if(pstmt1!=null)pstmt1.close();					
					}
					/* Added by Dharma  on Apr 13th 2016 against HSA-CRF-0303 [IN:054572] Start*/

					if(upd_pat_dtls_referral_yn.equals("Y")){
						String  referralCountQry="select count(*) referralCount from pr_referral_register where patient_id='"+patientid+"'";
						if(rsds!=null) rsds.close();
						if(pstmt1!=null) pstmt1.close();
						pstmt1 = con.prepareStatement(referralCountQry);
						rsds=pstmt1.executeQuery();
						int referralCount=0;
						if(rsds != null && rsds.next()){
							referralCount=rsds.getInt("referralCount");
						} 
						if(rsds!=null) rsds.close();
						if(pstmt1!=null) pstmt1.close();
						if(referralCount > 0){
							String referralUpdateQry	= "update PR_REFERRAL_REGISTER set CONTACT1_NO='"+restelno+"', CONTACT2_NO='"+othtelno+"',EMAIL_ID='"+emailid+"', ADDR_LINE1='"+res_addr1.replaceAll("'","''")+"', ADDR_LINE2='"+res_addr2.replaceAll("'","''")+"',ADDR_LINE3='"+res_addr3.replaceAll("'","''")+"', ADDR_LINE4='"+res_addr4.replaceAll("'","''")+"',POSTAL_CODE='"+res_postal+"',MODIFIED_DATE=sysdate,MODIFIED_FACILITY_ID='"+modifiedFacilityId+"',MODIFIED_BY_ID='"+modifiedById+"', MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"',RES_AREA_CODE='"+res_area+"',RES_TOWN_CODE='"+res_town+"',REGION_CODE='"+res_region+"',MAIL_ADDR_LINE1='"+mail_addr1.replaceAll("'","''")+"',MAIL_ADDR_LINE2='"+mail_addr2.replaceAll("'","''")+"',MAIL_ADDR_LINE3='"+mail_addr3.replaceAll("'","''")+"',MAIL_ADDR_LINE4='"+mail_addr4.replaceAll("'","''")+"',MAIL_RES_AREA_CODE='"+mail_area+"',MAIL_RES_TOWN_CODE='"+mail_town+"',MAIL_REGION_CODE='"+mail_region+"',MAIL_POSTAL_CODE='"+mail_postal+"',MAIL_COUNTRY_CODE='"+mail_country+"',COUNTRY_CODE='"+res_country+"',alt_addr_line1='"+altAddrLine1.replaceAll("'","''")+"',alt_addr_line2='"+altAddrLine2.replaceAll("'","''")+"',alt_addr_line3='"+altAddrLine3.replaceAll("'","''")+"',alt_addr_line4='"+altAddrLine4.replaceAll("'","''")+"',alt_area_code='"+altAreaCode+"',alt_town_code='"+altTownCode+"',alt_region_code='"+altRegionCode+"',alt_postal_code='"+altPostalCode+"',alt_country_code='"+altCountryCode+"' where patient_id='"+patientid+"'";//Modified by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601
							if(pstmt1!=null)pstmt1.close();
							pstmt1 = con.prepareStatement(referralUpdateQry);
							pstmt1.executeUpdate();
						}
					}

					/* Added by Dharma  on Apr 13th 2016 against HSA-CRF-0303 [IN:054572] End*/

					//Bru-HIMS-CRF 169 changes
					if(resu!=0 && patientid != null && !(patientid.equals(""))){//to update the count in oa_pat_cncl_appt_summary only when  the appointment has a patient id.
						//CALL THE update method
						updateOAPatCnclSummary(con,patientid,addedFacilityId,patCnclCount,addedById,addedAtWorkstation);
					}
					if(!(overbooked.equals("Y") || forced.equals("Y"))){
						if(!act_alcn_catg_code.equals("")){
							//String alcn_slq_update="update  oa_clinic_schedule_dtl set TOTAL_BOOKED_PATIENTS=nvl(TOTAL_BOOKED_PATIENTS,0)+"+no_slots_value+" where clinic_date=to_date('"+apptdate+"','dd/mm/yyyy') and facility_id='"+addedFacilityId+"' and clinic_code='"+cliniccode+"' and nvl(practitioner_id,'X')=nvl('"+practitionerid+"','X') and alcn_catg_code='"+act_alcn_catg_code+"'"; modified for tuning
							String alcn_slq_update="";
							if(practitionerid.equals("")){
								alcn_slq_update="update  oa_clinic_schedule_dtl set TOTAL_BOOKED_PATIENTS=nvl(TOTAL_BOOKED_PATIENTS,0)+"+no_slots_value+",MODIFIED_BY_ID='"+modifiedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where clinic_date=to_date('"+apptdate+"','dd/mm/yyyy') and facility_id='"+addedFacilityId+"' and clinic_code='"+cliniccode+"' and practitioner_id is null and alcn_catg_code='"+act_alcn_catg_code+"'";
							}else{
								alcn_slq_update="update  oa_clinic_schedule_dtl set TOTAL_BOOKED_PATIENTS=nvl(TOTAL_BOOKED_PATIENTS,0)+"+no_slots_value+",MODIFIED_BY_ID='"+modifiedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where clinic_date=to_date('"+apptdate+"','dd/mm/yyyy') and facility_id='"+addedFacilityId+"' and clinic_code='"+cliniccode+"' and practitioner_id = '"+practitionerid+"' and alcn_catg_code='"+act_alcn_catg_code+"'";
							}
							pstmt_oa_cl_sch_dtl=con.prepareStatement(alcn_slq_update);
							
							resu=pstmt_oa_cl_sch_dtl.executeUpdate() ;
							
						}
					}
					if(resu != 0){
						if(!(patInstructionsMap.isEmpty())){
						    if(pstmt!=null) pstmt.close();
							String oa_pat_ins="insert into oa_appt_pat_instructions(facility_id, appt_ref_no, instruction_id, instruction_desc, display_order, added_by_id, added_date,added_facility_id, added_at_ws_no, modified_by_id, modified_date,modified_facility_id, modified_at_ws_no)values(?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
							pstmt = con.prepareStatement( oa_pat_ins);
							int recCount=patInstructionsMap.size();

							int executableCount=0;
							
							for(int cnt=1;cnt<=recCount;cnt++){
								Integer integer=new Integer(cnt);
								String instId="";
								//int instorder=cnt;
								String instDesc="";
								String checkYN="";
								String mapValue=(String)patInstructionsMap.get(integer.toString());
								String[] tokens=mapValue.split("\\|~");
								instId=tokens[0];
								instDesc=tokens[1];
								checkYN=tokens[2];
								if(instDesc.equals("*!*")){
									instDesc="";
								}
								//StringTokenizer token1=new StringTokenizer(mapValue, "|~");
								/*Above line Commented by Senthil on 25-Oct-2011*/
								/*StringTokenizer token1=new StringTokenizer(mapValue, "||");
								
								while (token1.hasMoreTokens()){
									instId=token1.nextToken();
									instDesc=token1.nextToken();
									if(instDesc.equals("*!*")){
										instDesc="";
									}
									checkYN=token1.nextToken();
								}*/
								if(checkYN.equals("Y")){
									executableCount=executableCount+1;
									pstmt.setString	( 1, addedFacilityId ) ;
									pstmt.setString	( 2, nextsrlno1 ) ;
									pstmt.setString	( 3, instId ) ;
									pstmt.setString	( 4, instDesc ) ;
									pstmt.setInt	( 5, executableCount ) ;
									pstmt.setString ( 6, addedById );
									pstmt.setString	( 7, addedFacilityId ) ;
									pstmt.setString	( 8, addedAtWorkstation  ) ;
									pstmt.setString	( 9, modifiedById ) ;
									pstmt.setString ( 10, modifiedFacilityId );
									pstmt.setString	( 11, modifiedAtWorkstation ) ;
									pstmt.addBatch();
								}
							}
							if(executableCount >0){
								int resultArr[]=pstmt.executeBatch();
								resu=resultArr.length;

							}
						}if(pstmt!=null) pstmt.close(); //checkstyle violation
						if(!(prcInstructionMap.isEmpty())){
							String oa_prc_ins="insert into OA_APPT_PROC_INSTRUCTIONS(INSTRN_SRL_NO,facility_id, appt_ref_no, instruction_desc,added_by_id, added_date,added_facility_id, added_at_ws_no, modified_by_id, modified_date,modified_facility_id, modified_at_ws_no)values(1,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
							String checked=(String)prcInstructionMap.get("checked");
							String prcDesc=(String)prcInstructionMap.get("prcIns");
							if(checked!=null && checked.equals("Y")){
								pstmt = con.prepareStatement( oa_prc_ins);
								pstmt.setString	( 1,  addedFacilityId ) ;
								pstmt.setString	( 2,  nextsrlno1 ) ;
								pstmt.setString	( 3,  prcDesc ) ;
								pstmt.setString ( 4, addedById );
								pstmt.setString	( 5, addedFacilityId ) ;
								pstmt.setString	( 6, addedAtWorkstation  ) ;
								pstmt.setString	( 7, modifiedById ) ;
								pstmt.setString ( 8, modifiedFacilityId );
								pstmt.setString	( 9, modifiedAtWorkstation ) ;
								
								resu=pstmt.executeUpdate() ;
								
							}
						}
						if(or_catalogue_code ==null) or_catalogue_code="";
						pre_admit_order_catalog_code =null;
						//Called if the order catalog code is entered in schedule Appt exists
						//if(OR_VAL_CHK.equals("Y")){
						if( OR_VAL_CHK.equals("Y") && ( ("Y".equalsIgnoreCase(rd_appt_yn) && !("".equalsIgnoreCase(patientid))) || ("N".equalsIgnoreCase(rd_appt_yn)) ) ){ // Modified against PMG20089-CRF-0885.3
							if((!or_catalogue_code.equals("") || or_catalogue_code !="null" || !or_catalogue_code.equals("null") || or_catalogue_code!="") && order_id.equals("")){
								order_catalog_code=or_catalogue_code;
								clblstmt1=con.prepareCall("{call OR_INSERT_ORDER_OTH_MODULE ( to_char(sysdate,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
								//clblstmt1.setString( 1, or_order_date);
								//clblstmt1.setString( 1, );
								//clblstmt1.setString( 2, pre_admit_order_catalog_code);
								clblstmt1.setString( 1, or_catalogue_code);
								clblstmt1.setString( 2, "OA");
								clblstmt1.setString( 3, addedFacilityId);
								clblstmt1.setString( 4, patientid);
								clblstmt1.setString( 5, "OP");
								clblstmt1.setString( 6, "");
								clblstmt1.setString( 7, "");
								clblstmt1.setString( 8, "");
								clblstmt1.setString( 9, clinic_type);
								clblstmt1.setString( 10, cliniccode);
								//clblstmt1.setString( 11, practitionerid);
								clblstmt1.setString( 11, ordPractId);
								clblstmt1.setString( 12, addedById);
								clblstmt1.setString( 13, addedAtWorkstation);
								clblstmt1.registerOutParameter(14 ,Types.VARCHAR );
								clblstmt1.registerOutParameter(15 ,Types.VARCHAR );
								clblstmt1.registerOutParameter(16 ,Types.VARCHAR );
								clblstmt1.registerOutParameter(17 ,Types.VARCHAR );
								
								clblstmt1.execute() ;
								
								String p_out_order_id="";
								String p_out_order_line_num="";
								String p_err_message="";
								p_out_order_id=clblstmt1.getString( 14 );
								if(p_out_order_id ==null) p_out_order_id="";
								p_out_order_line_num=clblstmt1.getString( 15 );
								if(p_out_order_line_num ==null) p_out_order_line_num="";
								order_id=p_out_order_id;
								order_line_num=p_out_order_line_num;
								p_err_message=clblstmt1.getString( 17 );
								if(p_err_message==null) p_err_message="";
								if(p_err_message.equals("")){
									/*String sql_upd_order=" update oa_appt set ORDER_ID='"+p_out_order_id+"',ORDER_LINE_NUM='"+p_out_order_line_num+"' where appt_ref_no='"+nextsrlno1+"' and facility_id='"+addedFacilityId+"'";

									pstmt3 = con.prepareStatement( sql_upd_order );
									int res_order_upd=0;
									res_order_upd =pstmt3.executeUpdate();

									if(res_order_upd==0)
									{
										resu=0;
										result=false;
										sb.append("Updation failed in oa_appt after order generation ");
										con.rollback();
									}*/
								}else{
									resu=0;
									result=false;
									sb.append("Transaction Failed while order generation ");
									con.rollback();
								}
							}//end of if condition to chk if or_catalogue_code is null or not
						}
					} //end of  result if
					if(resu != 0){
						result=true;
						String err_message="";
						String addedDate = dateFormat.format( new java.util.Date() ) ;
						// INSERT_PR_WAIT_LIST Procedure being called only if preferred date and priority is entered in Book Appt screen.Generation of wait list takes place
						if(!pref_date.equals("")){
							clblstmt=con.prepareCall("{call INSERT_PR_WAIT_LIST( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
							String tmpp1="";
							String tmpp2="";
							String tmpp3="";
							String tmpp4="";
							if(altid1expdt.equals("N"))
								tmpp1="";
							else
								tmpp1=altid1expdt;

							if(altid2expdt.equals("N"))
								tmpp2="";
							else
								tmpp2=altid2expdt;

							if(altid3expdt.equals("N"))
								tmpp3="";
							else
								tmpp3=altid3expdt;

							if(altid4expdt.equals("N"))
								tmpp4="";
							else
								tmpp4=altid4expdt;
							if(or_catalogue_code ==null) or_catalogue_code="";

							clblstmt.setString( 1, facilityId);
							clblstmt.setString( 2, pref_date);
							clblstmt.setString( 3, priority);
							clblstmt.setString( 4, speciality_code);
							clblstmt.setString( 5, cliniccode);
							clblstmt.setString( 6, res_class);
							clblstmt.setString( 7, practitionerid);
							clblstmt.setString( 8, nextsrlno1);
							clblstmt.setString( 9, patientid);
							clblstmt.setString( 10, nationalidno);
							clblstmt.setString( 11, altid1typ);
							clblstmt.setString( 12, altid1no);
							clblstmt.setString( 13, tmpp1);
							clblstmt.setString( 14, altid2typ);
							clblstmt.setString( 15, altid2no);
							clblstmt.setString( 16, tmpp2);
							clblstmt.setString( 17, altid3typ);
							clblstmt.setString( 18, altid3no);
							clblstmt.setString( 19, tmpp3);
							clblstmt.setString( 20, altid4typ);
							clblstmt.setString( 21, altid4no);
							clblstmt.setString( 22, tmpp4);
							clblstmt.setString( 23, Othaltid1typ);
							clblstmt.setString( 24, Othaltid1);
							clblstmt.setString( 25, prefix);
							clblstmt.setString( 26, firstname);
							clblstmt.setString( 27, secondname);
							clblstmt.setString( 28, thirdname);
							clblstmt.setString( 29, familyname);
							clblstmt.setString( 30, suffix);
							clblstmt.setString( 31, patientname);
							clblstmt.setString( 32, gender);
							clblstmt.setString( 33, dateofbirth);
							clblstmt.setString( 34, nationality_code);
							clblstmt.setString( 35, ethnicSbGrp);
							clblstmt.setString( 36, ethnicGrp);
							clblstmt.setString( 37, residency);
							clblstmt.setString( 38, status);
							clblstmt.setString( 39, res_addr1);
							clblstmt.setString( 40, res_addr2);
							clblstmt.setString( 41, res_addr3);
							clblstmt.setString( 42, res_addr4);
							clblstmt.setString( 43, res_area);
							clblstmt.setString( 44, res_town);
							clblstmt.setString( 45, res_region);
							clblstmt.setString( 46, res_postal);
							clblstmt.setString( 47, res_country);
							clblstmt.setString( 48, restelno);
							clblstmt.setString( 49, othtelno);
							clblstmt.setString( 50, emailid);
							clblstmt.setString( 51, mail_addr1);
							clblstmt.setString( 52, mail_addr2);
							clblstmt.setString( 53, mail_addr3);
							clblstmt.setString( 54, mail_addr4);
							clblstmt.setString( 55, mail_area);
							clblstmt.setString( 56, mail_town);
							clblstmt.setString( 57, mail_region);
							clblstmt.setString( 58, mail_postal);
							clblstmt.setString( 59, mail_country);
							clblstmt.setString( 60, "O");
							clblstmt.setString( 61, addedById);
							clblstmt.setString( 62, addedDate);
							clblstmt.setString( 63, addedAtWorkstation);
							clblstmt.setString( 64, facilityId);
							clblstmt.setString( 65, addedById);
							clblstmt.setString( 66, addedDate);
							clblstmt.setString( 67, addedAtWorkstation);
							clblstmt.setString( 68, facilityId);
							clblstmt.setString( 69, clinic_type);
							clblstmt.setString( 70, birthPlace);
							clblstmt.setString( 71, birthPlace_desc);
							clblstmt.setString( 72,or_catalogue_code);
							clblstmt.setString( 73,"");
							clblstmt.setString ( 74, name_prefix_oth_lang);
							clblstmt.setString ( 75, first_name_oth_lang);
							clblstmt.setString ( 76, second_name_oth_lang);
							clblstmt.setString ( 77, third_name_oth_lang);
							clblstmt.setString ( 78, family_name_oth_lang);
							clblstmt.setString ( 79, name_suffix_oth_lang);
							clblstmt.setString ( 80, patient_name_local_lang);
							clblstmt.setString ( 81, reason_for_modify);
							clblstmt.setString ( 82, frm_facility_id);
							clblstmt.setString ( 83, from_enc_id);
							clblstmt.setString ( 84, "");
							clblstmt.setString ( 85,patient_name_loc_lang_long);
							clblstmt.setString ( 86,patient_name_long );
							clblstmt.setString ( 87,rd_appt_yn );
							clblstmt.setString ( 88,multi_speciality_yn );
							/*Added by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601 Start*/
							clblstmt.setString (89, altAddrLine1);
							clblstmt.setString (90, altAddrLine2);
							clblstmt.setString (91, altAddrLine3);
							clblstmt.setString (92, altAddrLine4);
							clblstmt.setString (93, altTownCode);
							clblstmt.setString (94, altAreaCode);
							clblstmt.setString (95, altRegionCode);
							clblstmt.setString (96, altPostalCode);
							clblstmt.setString (97, altCountryCode);
							/*End*/
						
							clblstmt.registerOutParameter(98 ,Types.VARCHAR );
							clblstmt.registerOutParameter(99 ,Types.VARCHAR );
							//clblstmt.setString( 87,"N");
							
							clblstmt.execute() ;
							
							err_message=clblstmt.getString( 98 );
							if(err_message==null) err_message="";
						} // end of if pref_date
						if(err_message.equals("")){
							result=true;
						}else{
							result=false;
							sb.append("Transaction Failed PR_WAIT_LIST ");
							con.rollback();
						}

					}else{ // IF NOT RESULT
						result=false;
					}
					if ( result ){
					
						if(forced.equals("N") && overbooked.equals("N")){
							if(! timetabletype.equals("3")){  // freeformat check
								String srl_nos="";
								String sttt="";
								String sttt1="";
								//String srl_nosofpr="select srl_no,to_char(slot_slab_start_time,'hh24:mi') stt from oa_clinic_schedule_slot_slab where clinic_code='"+cliniccode+"' and facility_id= '"+addedFacilityId+"' and nvl(practitioner_id,'x')=nvl('"+practitionerid+"','x') and trunc(clinic_date)=to_date('"+apptdate+"','dd/mm/yyyy') and SCHEDULE_STATUS is null  and to_date(to_char(slot_slab_start_time,'hh24:mi'),'hh24:mi') >=to_date('"+apptslabfmtime+"','hh24:mi') and to_date(to_char(slot_slab_end_time,'hh24:mi'),'hh24:mi')<=to_date('"+apptslabtotime+"','hh24:mi') order by srl_no";
								StringBuffer srl_nosofpr=new StringBuffer("select srl_no,to_char(slot_slab_start_time,'hh24:mi') stt from oa_clinic_schedule_slot_slab where clinic_code='"+cliniccode+"' and facility_id= '"+addedFacilityId+"'");
								if(!practitionerid.equals("")){
									srl_nosofpr.append(" and practitioner_id = '"+practitionerid+"'");
								}else{
									srl_nosofpr.append(" and practitioner_id is null ");
								}

								//Modified by Ashwini on 03-Aug-2021 for KDAH-CRF-0579.1  - put the Code back. failure when same slab booked. Trigger retained
								if(isSlotStartMidEndAppl && timetabletype.equals("2") && max_pat_per_slab > 1)
								{
									srl_nosofpr.append(" and clinic_date=to_date('"+apptdate+"','dd/mm/yyyy') and SCHEDULE_STATUS is null and resource_class='"+res_class+"' and to_date(to_char(slot_slab_start_time,'hh24:mi'),'hh24:mi') >=to_date('"+apptslabfmtime+"','hh24:mi') and to_date(to_char(slot_slab_end_time,'hh24:mi'),'hh24:mi')<=to_date('"+apptslabtotime+"','hh24:mi') and (ext_slot_yn <> 'Y'or ext_slot_yn is null) order by srl_no");
								}else
								{
									srl_nosofpr.append(" and clinic_date=to_date('"+apptdate+"','dd/mm/yyyy') and SCHEDULE_STATUS is null and resource_class='"+res_class+"' and to_date(to_char(slot_slab_start_time,'hh24:mi'),'hh24:mi') >=to_date('"+apptslabfmtime+"','hh24:mi') and to_date(to_char(slot_slab_end_time,'hh24:mi'),'hh24:mi')<=to_date('"+apptslabtotime+"','hh24:mi') order by srl_no");
								}

								/*srl_nosofpr.append(" and clinic_date=to_date('"+apptdate+"','dd/mm/yyyy') and resource_class='"+res_class+"' and to_date(to_char(slot_slab_start_time,'hh24:mi'),'hh24:mi') >=to_date('"+apptslabfmtime+"','hh24:mi') and to_date(to_char(slot_slab_end_time,'hh24:mi'),'hh24:mi')<=to_date('"+apptslabtotime+"','hh24:mi') order by srl_no");*/

								if (pstmt!=null) pstmt.close();
								if (rs!=null) rs.close();
								
								pstmt=con.prepareStatement(srl_nosofpr.toString());
								srl_nosofpr.setLength(0);
								rs=pstmt.executeQuery();
								boolean srl_nbr_no_err=false;
								if(rs !=null){
									while (rs.next()){
									
										srl_nbr_no_err=true;
										sttt1=rs.getString("stt");
										
										if(!sttt.equals(sttt1)){
											srl_nos=srl_nos+"'"+rs.getString("srl_no")+"',";
											sttt=sttt1;
											
										}
										
									
									}
								}else{
									srl_nbr_no_err=false;
									result = false ;
                                  
									con.rollback();
								}
								if(rs!=null)rs.close();
                                  

								if(srl_nbr_no_err){
									if(srl_nos !=null){
										srl_nos=srl_nos.substring(0,srl_nos.length() -1);
										
									}
									//	String sql_up11=" update oa_clinic_schedule_slot_slab set schedule_status='1',pri_appt_ref_no='"+nextsrlno1+"' where clinic_code='"+cliniccode+"' and facility_id= '"+addedFacilityId+"' and nvl(practitioner_id,'x')=nvl('"+practitionerid+"','x') and trunc(clinic_date)=to_date('"+apptdate+"','dd/mm/yyyy') and resource_class='"+res_class+"' and care_locn_type_ind='"+clinic_type+"' and to_date(to_char(slot_slab_start_time,'hh24:mi'),'hh24:mi') >=to_date('"+apptslabfmtime+"','hh24:mi') and to_date(to_char(slot_slab_end_time,'hh24:mi'),'hh24:mi')<=to_date('"+apptslabtotime+"','hh24:mi')  and schedule_status is  null ";
									StringBuffer sql_up11=new StringBuffer(" update oa_clinic_schedule_slot_slab set schedule_status='1',pri_appt_ref_no='"+nextsrlno1+"' ,MODIFIED_BY_ID='"+modifiedById+"',MODIFIED_DATE =sysdate,MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"',MODIFIED_FACILITY_ID ='"+modifiedFacilityId+"' where clinic_code='"+cliniccode+"' and facility_id= '"+addedFacilityId+"'and clinic_date=to_date('"+apptdate+"','dd/mm/yyyy') and resource_class='"+res_class+"' and care_locn_type_ind='"+clinic_type+"' and srl_no in ("+srl_nos+") ");
									if(!practitionerid.equals("")){
										sql_up11.append(" and practitioner_id = '"+practitionerid+"'");
									}else{
										sql_up11.append(" and practitioner_id is null ");
									}
									if (pstmt3!=null) pstmt3.close();
									pstmt3 = con.prepareStatement( sql_up11.toString() );
									
									res_up =pstmt3.executeUpdate();
									
									sql_up11.setLength(0);
									if(res_up != 0){
										result = true ;
									}else{
										result = false ;
										sb.append("Transaction Failed oa_clinic_schedule_slot_slab for Primary Resources ");
										con.rollback();
									}
								}else{
									result = false ;
									sb.append("The selected slot is unavailable. Please try again.");
									con.rollback();
								}

								/*	String sql_upd_oaclinic_sch="	UPDATE  OA_CLINIC_SCHEDULE A SET  (MIN_SLOT_SLAB_START_TIME,MIN_SLOT_SLAB_END_TIME) = (SELECT MIN(SLOT_SLAB_START_TIME),MIN(SLOT_SLAB_END_TIME) FROM OA_CLINIC_SCHEDULE_SLOT_SLAB WHERE  FACILITY_ID = '"+addedFacilityId+"' AND    CLINIC_CODE = '"+cliniccode+"' AND    CLINIC_DATE = to_date('"+apptdate+"','dd/mm/yyyy') AND    (PRACTITIONER_ID = '"+practitionerid+"' or (PRACTITIONER_ID is null and '"+practitionerid+"' is null)) AND  SCHEDULE_STATUS IS NULL) WHERE	FACILITY_ID = '"+addedFacilityId+"' AND    CLINIC_CODE = '"+cliniccode+"' AND    CLINIC_DATE =to_date('"+apptdate+"','dd/mm/yyyy') AND    (PRACTITIONER_ID = '"+practitionerid+"' or (PRACTITIONER_ID is null and '"+practitionerid+"' is null))";



										pstmt_oa_clinic_sch = con.prepareStatement( sql_upd_oaclinic_sch );
										res_up =pstmt_oa_clinic_sch.executeUpdate();



										if(res_up != 0){
											result = true ;
										}else{
											result = false ;
											sb.append("Transaction Failed oa_clinic_schedule_slot_slab for Primary Resources ");
											con.rollback();
								}*/
							} // freeformat check

						}// forced check

						//This is called from OR only if order_id and order_line_num exists
						if(order_id ==null )order_id="";
						if(order_line_num ==null )order_line_num="";
						if(order_catalog_code ==null) order_catalog_code="";
						
						if(OR_VAL_CHK.equals("Y")){
							if(!order_id.equals("")  && !order_line_num.equals("")){
								int or_update2_val=0;
								int or_update2_val2=0;
								//Updating audit columns::
								String OR_UPDATE0="update oa_appt set ORDER_ID='"+order_id+"', ORDER_LINE_NUM='"+order_line_num+"' ,ORDER_CATALOG_CODE='"+order_catalog_code+"', MODIFIED_BY_ID='"+modifiedById+"', MODIFIED_DATE=sysdate ,MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+addedFacilityId+"' where appt_ref_no='"+nextsrlno1+"' and facility_id='"+addedFacilityId+"'";
								String OR_UPDATE1="update or_order set MODIFIED_BY_ID='"+modifiedById+"', MODIFIED_DATE=sysdate ,MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+addedFacilityId+"', order_status = (select order_status_code from or_order_status_code where order_status_type='15') where order_id= '"+order_id+"' and exists(select 1 from or_order_status_code where order_status_type='10' and order_status_code=or_order.order_status)";
								String OR_UPDATE2=" update or_order_line set appt_ref_num ='"+nextsrlno1+"',  	  appt_date_time=to_date('"+apptdate+" "+apptslabfmtime+"','DD/MM/YYYY hh24:mi'), MODIFIED_BY_ID='"+modifiedById+"' , MODIFIED_DATE=sysdate  , MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"' , MODIFIED_FACILITY_ID='"+addedFacilityId+"', order_line_status= (select order_status_code from or_order_status_code where order_status_type = '15') where order_id = '"+order_id+"' and order_line_num= '"+order_line_num+"' and exists(select 1 from or_order_status_code where order_status_type='10' and order_status_code=or_order_line.order_line_status) ";
								
								
								pstmtOR2 =  con.prepareStatement( OR_UPDATE0 );
							
								pstmtOR = con.prepareStatement( OR_UPDATE1 );

								pstmtOR1 = con.prepareStatement( OR_UPDATE2 );
								
								
								
								pstmtOR.executeUpdate();
								or_update2_val=	pstmtOR1.executeUpdate();
								pstmtOR2.executeUpdate();
								if(pstmtOR1!=null)pstmtOR1.close();
								if(or_update2_val<=0){
									OR_UPDATE2=" update or_order_line set appt_ref_num ='"+nextsrlno1+"',  	  appt_date_time=to_date('"+apptdate+" "+apptslabfmtime+"','DD/MM/YYYY hh24:mi'), MODIFIED_BY_ID='"+modifiedById+"' , MODIFIED_DATE=sysdate  , MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"' , MODIFIED_FACILITY_ID='"+addedFacilityId+"' where order_id = '"+order_id+"' and order_line_num= '"+order_line_num+"'";
                                 
									pstmtOR1 = con.prepareStatement( OR_UPDATE2 );
									
									or_update2_val2=pstmtOR1.executeUpdate();
									
									if(pstmtOR1!=null)pstmtOR1.close();
								}
							}// END OF ORDER_ID AND ORDER_LINE_NUM
						} //END OF OR_VAL_CHK
						// This is called from MR only if Request id exists
						if(!req_id.equals("")){
							sql_MR="update MR_REPORT_REQUEST_HDR  set APPT_REF_NO='"+nextsrlno1+"' , REQUEST_STATUS='5',MODIFIED_BY_ID='"+modifiedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where REQUEST_ID ='"+req_id+"' and facility_id='"+addedFacilityId+"'";

							pstmtMR =con.prepareStatement(sql_MR);
							pstmtMR.executeUpdate();
						}
						// This is called only if secondary resources is greater than zero
						if(sec_resources.size()>0){
							String sql_sec_rstyp1="";
							String sql_sec_rstyp2="";
							String sql_sec_rstyp3="";
							int sec_srl_n0=0;
							final String sqlmaxSec="select nvl(max(srl_no),1) from oa_resource_for_appt where facility_id='"+addedFacilityId+"' and appt_ref_no='"+nextsrlno1+"'";

							if (pstmt1!=null) pstmt1.close();
							if (rsds!=null) rsds.close();
							pstmt1=con.prepareStatement(sqlmaxSec);
							rsds=pstmt1.executeQuery();
							if(rsds !=null && rsds.next()){
								sec_srl_n0=rsds.getInt(1);
							}
							if (rsds!=null) rsds.close();
							final String sqldssec="select get_time_between(to_date(?,' dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi')) tmsc from dual ";

							pstmt_sqldssec = con.prepareStatement( sqldssec );
							sql_sec_rstyp1  = "select pract_type res_type from am_practitioner where practitioner_id = ?" ;

							sql_sec_rstyp2  = "select room_type res_type from am_facility_room where room_num = ?  and OPERATING_FACILITY_ID =?" ;

							sql_sec_rstyp3  = "select resource_type res_type from am_resource where  resource_id = ? and facility_id= ? and resource_Class=?" ;
							pstmt_sql_sec_rstyp1 = con.prepareStatement( sql_sec_rstyp1 );
							pstmt_sql_sec_rstyp2 = con.prepareStatement( sql_sec_rstyp2 );
							pstmt_sql_sec_rstyp3 = con.prepareStatement( sql_sec_rstyp3 );
							String ins_secondary_res=" insert into oa_resource_for_appt (facility_id,appt_ref_no,resource_class,resource_id,resource_type,appt_date,appt_time,appt_slab_from_time,appt_slab_to_time,appt_duration,appt_slots,booking_type,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,srl_no) values (?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'hh24:mi'),to_date(?,'hh24:mi'),to_date(?,'hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),'','N', ?, sysdate, ?, ?, ?, sysdate,?,?,?)";
							pstmt_ins_secondary_res = con.prepareStatement( ins_secondary_res );
							String sql_upop_1=" update oa_clinic_schedule_slot_slab set schedule_status='1',pri_appt_ref_no=?,MODIFIED_BY_ID=?,MODIFIED_DATE =sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID =? where clinic_code=? and facility_id=? and practitioner_id=? and clinic_date=to_date(?,'dd/mm/yyyy') and resource_class=? and care_locn_type_ind=? and srl_no =?";
							String sql_upop_2=" update oa_clinic_schedule_slot_slab set schedule_status='1',pri_appt_ref_no=?,MODIFIED_BY_ID=?,MODIFIED_DATE =sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID =? where clinic_code=? and facility_id=? and practitioner_id is null and clinic_date=to_date(?,'dd/mm/yyyy') and resource_class=? and care_locn_type_ind=? and srl_no =?";
							pstmt_sql_upop_1 = con.prepareStatement( sql_upop_1 );
							pstmt_sql_upop_2 = con.prepareStatement( sql_upop_2 );
							/*String sql_upd_oaclinic_sch1="	UPDATE  OA_CLINIC_SCHEDULE A SET  (MIN_SLOT_SLAB_START_TIME,MIN_SLOT_SLAB_END_TIME) = (SELECT MIN(SLOT_SLAB_START_TIME),MIN(SLOT_SLAB_END_TIME) FROM OA_CLINIC_SCHEDULE_SLOT_SLAB WHERE  FACILITY_ID = ? AND    CLINIC_CODE = ? AND    CLINIC_DATE = to_date(?,'dd/mm/yyyy') AND    (PRACTITIONER_ID = ? or (PRACTITIONER_ID is null and ? is null)) AND  SCHEDULE_STATUS IS NULL) WHERE	FACILITY_ID = ? AND    CLINIC_CODE = ? AND    CLINIC_DATE = to_date(?,'dd/mm/yyyy') AND (PRACTITIONER_ID = ? or (PRACTITIONER_ID is null and ? is null)) ";
							pstmt_oa_clinic_sch = con.prepareStatement( sql_upd_oaclinic_sch1 );				
							*/
							for(int xyz=0;xyz<sec_resources.size();xyz+=9){
								String sec_clinic_cd=(String) sec_resources.get(xyz);
								String sec_pract_id=(String) sec_resources.get(xyz+2);
								String sec_appt_dt=(String) sec_resources.get(xyz+3);
								String sec_res_class=(String) sec_resources.get(xyz+4);
								String sec_from_tm=(String) sec_resources.get(xyz+5);
								String sec_to_tm=(String) sec_resources.get(xyz+6);
								String sec_srl_no=(String) sec_resources.get(xyz+8);
								String timesec="";
								pstmt_sqldssec.setString(1,sec_appt_dt+" " +sec_from_tm);
								pstmt_sqldssec.setString(2,sec_appt_dt+" "+sec_to_tm);

								if (rsds!=null) rsds.close();
								rsds=pstmt_sqldssec.executeQuery();
								if(rsds !=null && rsds.next() ){
									timesec=rsds.getString("tmsc");
								}
								timesec=sec_appt_dt+" "+timesec;
								if (rsds!=null) rsds.close();
								if(sec_res_class.equals("P")){
									pstmt_sql_sec_rstyp1.setString(1,sec_pract_id);
									if (rsds!=null) rsds.close();
									rsds=pstmt_sql_sec_rstyp1.executeQuery();

								}else if(sec_res_class.equals("R")){
									pstmt_sql_sec_rstyp2.setString(1,sec_pract_id);
									pstmt_sql_sec_rstyp2.setString(2,addedFacilityId);
									if (rsds!=null) rsds.close();
									rsds=pstmt_sql_sec_rstyp2.executeQuery();
								}else{
									pstmt_sql_sec_rstyp3.setString(1,sec_pract_id);
									pstmt_sql_sec_rstyp3.setString(2,addedFacilityId);
									pstmt_sql_sec_rstyp3.setString(3,sec_res_class);
									if (rsds!=null) rsds.close();
									rsds=pstmt_sql_sec_rstyp3.executeQuery();
								}
								String sec_res_type="";
								if(rsds !=null && rsds.next()){
									sec_res_type = rsds.getString("res_type") ;
								}
								if (rsds!=null) rsds.close();
								pstmt_ins_secondary_res.setString(1,addedFacilityId);
								pstmt_ins_secondary_res.setString(2,nextsrlno1);
								pstmt_ins_secondary_res.setString(3,sec_res_class);
								pstmt_ins_secondary_res.setString(4,sec_pract_id);
								pstmt_ins_secondary_res.setString(5,sec_res_type);
								pstmt_ins_secondary_res.setString(6,sec_appt_dt);
								pstmt_ins_secondary_res.setString(7,sec_from_tm);
								pstmt_ins_secondary_res.setString(8,sec_from_tm);
								pstmt_ins_secondary_res.setString(9,sec_to_tm);
								pstmt_ins_secondary_res.setString(10,timesec);
								pstmt_ins_secondary_res.setString(11,addedById);
								pstmt_ins_secondary_res.setString(12,addedAtWorkstation);
								pstmt_ins_secondary_res.setString(13,addedFacilityId);
								pstmt_ins_secondary_res.setString(14,modifiedById);
								pstmt_ins_secondary_res.setString(15,modifiedAtWorkstation);
								pstmt_ins_secondary_res.setString(16,modifiedFacilityId);
								pstmt_ins_secondary_res.setInt(17,sec_srl_n0);
								
								resu =pstmt_ins_secondary_res.executeUpdate() ;
								
								if(resu != 0){
									result=true;
								}else{
									result=false;
								}
								if(result){
									String sql_sec_stat="";
									if(sec_pract_id.equals("")){
										sql_sec_stat=" update oa_clinic_schedule set total_slots_booked  = nvl(total_slots_booked,0)+1,total_first_visit=nvl(total_first_visit,0)+decode(?,'F',1,0), TOTAL_FIRST_VISIT_SLOTS_BOOKED=nvl(TOTAL_FIRST_VISIT_SLOTS_BOOKED,0)+decode(?,'F',1,0),total_follow_up=nvl(total_follow_up,0)+decode(?,'L',1,0),total_routine=nvl(total_routine,0)+decode(?,'R',1,0),total_series=nvl(total_series,0)+decode(?,'S',1,0),total_consult=nvl(total_consult,0)+decode(?,'C',1,0),total_emergency=nvl(total_emergency,0)+decode(?,'E',1,0),MODIFIED_BY_ID=?,MODIFIED_DATE =sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID =? where facility_id = ? and clinic_code=? and clinic_date= to_date(?,'DD/MM/YYYY') and care_locn_type_ind=? and resource_class=? and primary_resource_yn='N'  and practitioner_id is null";
									}else{
										sql_sec_stat=" update oa_clinic_schedule set total_slots_booked  = nvl(total_slots_booked,0)+1,total_first_visit=nvl(total_first_visit,0)+decode(?,'F',1,0), TOTAL_FIRST_VISIT_SLOTS_BOOKED=nvl(TOTAL_FIRST_VISIT_SLOTS_BOOKED,0)+decode(?,'F',1,0),total_follow_up=nvl(total_follow_up,0)+decode(?,'L',1,0),total_routine=nvl(total_routine,0)+decode(?,'R',1,0),total_series=nvl(total_series,0)+decode(?,'S',1,0),total_consult=nvl(total_consult,0)+decode(?,'C',1,0),total_emergency=nvl(total_emergency,0)+decode(?,'E',1,0),MODIFIED_BY_ID=?,MODIFIED_DATE =sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID =? where facility_id = ? and clinic_code=? and clinic_date= to_date(?,'DD/MM/YYYY') and care_locn_type_ind=? and resource_class=? and primary_resource_yn='N'  and practitioner_id = ?";
									}
									pstmt_sql_sec_stat = con.prepareStatement( sql_sec_stat );
									pstmt_sql_sec_stat.setString(1,visitind);
									pstmt_sql_sec_stat.setString(2,visitind);
									pstmt_sql_sec_stat.setString(3,visitind);
									pstmt_sql_sec_stat.setString(4,visitind);
									pstmt_sql_sec_stat.setString(5,visitind);
									pstmt_sql_sec_stat.setString(6,visitind);
									pstmt_sql_sec_stat.setString(7,visitind);
									pstmt_sql_sec_stat.setString(8,modifiedById);
									pstmt_sql_sec_stat.setString(9,modifiedAtWorkstation);
									pstmt_sql_sec_stat.setString(10,modifiedFacilityId);
									pstmt_sql_sec_stat.setString(11,addedFacilityId);
									pstmt_sql_sec_stat.setString(12,sec_clinic_cd);
									pstmt_sql_sec_stat.setString(13,sec_appt_dt);									
									pstmt_sql_sec_stat.setString(14,clinic_type);
									pstmt_sql_sec_stat.setString(15,sec_res_class);
									if(!sec_pract_id.equals("")){
										pstmt_sql_sec_stat.setString(16,sec_pract_id);
									}
									
									res_up =pstmt_sql_sec_stat.executeUpdate();
									
									if(pstmt_sql_sec_stat!=null) pstmt_sql_sec_stat.close(); //checkstyle violation
															
																		
									if(sec_pract_id!=null && !sec_pract_id.equals("")){   //Modified the condtion for the incident [051421]
										pstmt_sql_upop_1.setString(1,nextsrlno1);
										pstmt_sql_upop_1.setString(2,modifiedById);
										pstmt_sql_upop_1.setString(3,modifiedAtWorkstation);
										pstmt_sql_upop_1.setString(4,modifiedFacilityId);
										pstmt_sql_upop_1.setString(5,sec_clinic_cd);
										pstmt_sql_upop_1.setString(6,addedFacilityId);
										pstmt_sql_upop_1.setString(7,sec_pract_id);
										pstmt_sql_upop_1.setString(8,sec_appt_dt);
										pstmt_sql_upop_1.setString(9,sec_res_class);
										pstmt_sql_upop_1.setString(10,clinic_type);
										pstmt_sql_upop_1.setString(11,sec_srl_no);
										
										res_up =pstmt_sql_upop_1.executeUpdate();
										
									}else{
										pstmt_sql_upop_2.setString(1,nextsrlno1);
										pstmt_sql_upop_2.setString(2,modifiedById);
										pstmt_sql_upop_2.setString(3,modifiedAtWorkstation);
										pstmt_sql_upop_2.setString(4,modifiedFacilityId);
										pstmt_sql_upop_2.setString(5,sec_clinic_cd);
										pstmt_sql_upop_2.setString(6,addedFacilityId);
										pstmt_sql_upop_2.setString(7,sec_appt_dt);
										pstmt_sql_upop_2.setString(8,sec_res_class);
										pstmt_sql_upop_2.setString(9,clinic_type);
										pstmt_sql_upop_2.setString(10,sec_srl_no);
										
										res_up =pstmt_sql_upop_2.executeUpdate();
										
									}
									
									if ( res_up != 0 ) {
										result = true ;
									}else{
										con.rollback();
										sb.append("Transaction Failed in Secondary Resources ");
									}

									/*pstmt_oa_clinic_sch.setString(1,addedFacilityId);
									pstmt_oa_clinic_sch.setString(2,sec_clinic_cd);
									pstmt_oa_clinic_sch.setString(3,sec_appt_dt);
									pstmt_oa_clinic_sch.setString(4,sec_pract_id);
									pstmt_oa_clinic_sch.setString(5,sec_pract_id);
									pstmt_oa_clinic_sch.setString(6,addedFacilityId);
									pstmt_oa_clinic_sch.setString(7,sec_clinic_cd);
									pstmt_oa_clinic_sch.setString(8,sec_appt_dt);
									pstmt_oa_clinic_sch.setString(9,sec_pract_id);
									pstmt_oa_clinic_sch.setString(10,sec_pract_id);
									res_up =pstmt_oa_clinic_sch.executeUpdate();



									if(res_up != 0){
										result = true ;
									}else{
										result = false ;
										sb.append("Transaction Failed oa_clinic_schedule_slot_slab for Primary Resources ");
										con.rollback();
									}*/

								}else{
									sb.append("Transaction Failed in Secondary Resources inner");
									con.rollback();
								}
								sec_srl_n0=sec_srl_n0+1;
							} // for loop
						}// if check
						if(result){
						
							if(overbooked.equals("Y")){
								if(forced.equals("N")){
									StringBuffer sql5= new StringBuffer();
									sql5.append(" update oa_clinic_schedule set total_overbooked = ?, ");
									if(!global.equals("N")){
										sql5.append(" TOTAL_GLOBAL_BOOKED=nvl(TOTAL_GLOBAL_BOOKED,0) +1 ,");
									}
									//sql5.append(" total_slots_overbooked = ? where facility_id = ? and clinic_code=? and trunc(clinic_date)= to_date(?,'DD/MM/YYYY') and nvl(practitioner_id,'X')=nvl(?,'X') and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_class+"' and primary_resource_yn='Y'"); modified for tuning
									sql5.append(" total_slots_overbooked = ?,MODIFIED_BY_ID=?,MODIFIED_DATE =sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID =? where facility_id = ? and clinic_code=? and clinic_date= to_date(?,'DD/MM/YYYY') and care_locn_type_ind=? and resource_class=? and primary_resource_yn='Y'");
									if(practitionerid.equals("")){
										sql5.append(" and practitioner_id is null ");
									}else{
										sql5.append(" and practitioner_id =? ");
									}
									if (pstmt3!=null) pstmt3.close();
									pstmt3 = con.prepareStatement( sql5.toString() );
									
									pstmt3.setInt	( 1, totaloverbooked ) ;
									pstmt3.setInt	( 2, totalslotsoverbooked ) ;
									pstmt3.setString( 3, modifiedById);
									pstmt3.setString( 4, modifiedAtWorkstation);
									pstmt3.setString( 5, modifiedFacilityId);
									pstmt3.setString( 6, addedFacilityId ) ;
									pstmt3.setString( 7, cliniccode ) ;
									pstmt3.setString( 8, apptdate ) ;
									pstmt3.setString( 9, clinic_type ) ;
									pstmt3.setString( 10, res_class ) ;
									if(!practitionerid.equals("")){
										pstmt3.setString	( 11, practitionerid ) ;
									}
									res2 =0;
									
									res2 =pstmt3.executeUpdate();
									
									sql5.setLength(0);
								}else{
									//sql4=" update oa_clinic_schedule set TOTAL_FORCED_IN_BOOKED=nvl(TOTAL_FORCED_IN_BOOKED,0) +1 where facility_id = ? and clinic_code=? and trunc(clinic_date)= to_date(?,'DD/MM/YYYY') and nvl(practitioner_id,'X')=nvl(?,'X') and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_class+"' and primary_resource_yn='Y'"; Modified for tuning
									if(practitionerid.equals("")){
										sql4=" update oa_clinic_schedule set TOTAL_FORCED_IN_BOOKED=nvl(TOTAL_FORCED_IN_BOOKED,0) +1,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where facility_id = ? and clinic_code=? and clinic_date= to_date(?,'DD/MM/YYYY') and care_locn_type_ind=? and resource_class=? and primary_resource_yn='Y'  and practitioner_id is null";
									}else{
										sql4=" update oa_clinic_schedule set TOTAL_FORCED_IN_BOOKED=nvl(TOTAL_FORCED_IN_BOOKED,0) +1,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where facility_id = ? and clinic_code=? and clinic_date= to_date(?,'DD/MM/YYYY') and care_locn_type_ind=? and resource_class=? and primary_resource_yn='Y'  and practitioner_id = ?";
									}
									if (pstmt3!=null) pstmt3.close();
									pstmt3 = con.prepareStatement( sql4 );
									pstmt3.setString( 1, modifiedById ) ;
									pstmt3.setString( 2, modifiedAtWorkstation ) ;
									pstmt3.setString( 3, modifiedFacilityId ) ;
									pstmt3.setString( 4, addedFacilityId ) ;
									pstmt3.setString( 5, cliniccode ) ;
									pstmt3.setString( 6, apptdate ) ;
									pstmt3.setString( 7, clinic_type ) ;
									pstmt3.setString( 8, res_class ) ;
									if(!practitionerid.equals("")){
										pstmt3.setString	( 9, practitionerid ) ;
									}
									res2 =0;
									
									res2 =pstmt3.executeUpdate();
								}
							}else{
							
								if (no_slots_value>1 && slot_appt_ctrl.equals("S")){
									if(forced.equals("N")){
										StringBuffer sql5= new StringBuffer();
										sql5.append(" update oa_clinic_schedule set  total_slots_booked  = nvl(total_slots_booked,0)+"+no_slots_value+",");
										if(!global.equals("N")){
											sql5.append("TOTAL_GLOBAL_BOOKED=nvl(TOTAL_GLOBAL_BOOKED,0) +1 , ");
										}
										//sql5.append("total_first_visit=nvl(total_first_visit,0)+decode('"+visitind+"','F',"+no_slots_value+",0),total_first_visit_slots_booked=nvl(total_first_visit_slots_booked,0)+decode('"+visitind+"','F',"+no_slots_value+",0),total_follow_up=nvl(total_follow_up,0)+decode('"+visitind+"','L',"+no_slots_value+",0),total_routine=nvl(total_routine,0)+decode('"+visitind+"','R',"+no_slots_value+",0),total_series=nvl(total_series,0)+decode('"+visitind+"','S',"+no_slots_value+",0),total_consult=nvl(total_consult,0)+decode('"+visitind+"','C',"+no_slots_value+",0),total_emergency=nvl(total_emergency,0)+decode('"+visitind+"','E',"+no_slots_value+",0) where facility_id = ? and clinic_code=? and trunc(clinic_date)= to_date(?,'DD/MM/YYYY') and nvl(practitioner_id,'X')=nvl(?,'X') and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_class+"' and primary_resource_yn='Y'"); modified for tuning
										sql5.append("total_first_visit=nvl(total_first_visit,0)+decode('"+visitind+"','F',"+no_slots_value+",0),total_first_visit_slots_booked=nvl(total_first_visit_slots_booked,0)+decode('"+visitind+"','F',"+no_slots_value+",0),total_follow_up=nvl(total_follow_up,0)+decode('"+visitind+"','L',"+no_slots_value+",0),total_routine=nvl(total_routine,0)+decode('"+visitind+"','R',"+no_slots_value+",0),total_series=nvl(total_series,0)+decode('"+visitind+"','S',"+no_slots_value+",0),total_consult=nvl(total_consult,0)+decode('"+visitind+"','C',"+no_slots_value+",0),total_emergency=nvl(total_emergency,0)+decode('"+visitind+"','E',"+no_slots_value+",0),MODIFIED_BY_ID='"+modifiedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where facility_id = ? and clinic_code=? and clinic_date= to_date(?,'DD/MM/YYYY') and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_class+"' and primary_resource_yn='Y' ");
										if(practitionerid.equals("")){
											sql5.append(" and practitioner_id is null ");
										}else{
											sql5.append(" and practitioner_id =? ");
										}
										if (pstmt3!=null) pstmt3.close();
										pstmt3 = con.prepareStatement( sql5.toString() );
										pstmt3.setString	( 1, addedFacilityId ) ;
										pstmt3.setString	( 2, cliniccode ) ;
										pstmt3.setString	( 3, apptdate ) ;
										if(!practitionerid.equals("")){
											pstmt3.setString	( 4, practitionerid ) ;
										}
										res2 =0;
										
										res2 =pstmt3.executeUpdate();
										
									}else{
										//sql4=" update oa_clinic_schedule set TOTAL_FORCED_IN_BOOKED=nvl(TOTAL_FORCED_IN_BOOKED,0)+1 	where facility_id = ? and clinic_code=? and trunc(clinic_date)= to_date(?,'DD/MM/YYYY') and nvl(practitioner_id,'X')=nvl(?,'X') and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_class+"' and primary_resource_yn='Y'"; modified for tuning
										if(practitionerid.equals("")){
											sql4=" update oa_clinic_schedule set TOTAL_FORCED_IN_BOOKED=nvl(TOTAL_FORCED_IN_BOOKED,0)+1,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? 	where facility_id = ? and clinic_code=? and clinic_date= to_date(?,'DD/MM/YYYY') and and practitioner_id is null and care_locn_type_ind=? and resource_class=? and primary_resource_yn='Y'";
										}else{
											sql4=" update oa_clinic_schedule set TOTAL_FORCED_IN_BOOKED=nvl(TOTAL_FORCED_IN_BOOKED,0)+1,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? 	where facility_id = ? and clinic_code=? and clinic_date= to_date(?,'DD/MM/YYYY') and practitioner_id = ? and care_locn_type_ind=? and resource_class=? and primary_resource_yn='Y'";
										}
										if (pstmt3!=null) pstmt3.close();
										pstmt3 = con.prepareStatement( sql4 );
										pstmt3.setString	( 1, modifiedById ) ;
										pstmt3.setString	( 2, modifiedAtWorkstation ) ;
										pstmt3.setString	( 3, modifiedFacilityId ) ;
										pstmt3.setString	( 4, addedFacilityId ) ;
										pstmt3.setString	( 5, cliniccode ) ;
										pstmt3.setString	( 6, apptdate ) ;
										pstmt3.setString	( 7, clinic_type ) ;
										pstmt3.setString	( 8, res_class ) ;
										if(!practitionerid.equals("")){
											pstmt3.setString	( 9, practitionerid ) ;
										}
										res2 =0;
										
										res2 =pstmt3.executeUpdate();
										
									}
								}else{
								   
									if(forced.equals("N")){
										StringBuffer sql5= new StringBuffer();
										sql5.append(" update oa_clinic_schedule set  total_slots_booked  = nvl(total_slots_booked,0)+1,");
										if(!global.equals("N")){
											sql5.append("TOTAL_GLOBAL_BOOKED=nvl(TOTAL_GLOBAL_BOOKED,0) +1 , ");
										}
										//sql5.append("total_first_visit=nvl(total_first_visit,0)+decode('"+visitind+"','F',1,0), TOTAL_FIRST_VISIT_SLOTS_BOOKED=nvl(TOTAL_FIRST_VISIT_SLOTS_BOOKED,0)+decode('"+visitind+"','F',1,0),total_follow_up=nvl(total_follow_up,0)+decode('"+visitind+"','L',1,0),total_routine=nvl(total_routine,0)+decode('"+visitind+"','R',1,0),total_series=nvl(total_series,0)+decode('"+visitind+"','S',1,0),total_consult=nvl(total_consult,0)+decode('"+visitind+"','C',1,0),total_emergency=nvl(total_emergency,0)+decode('"+visitind+"','E',1,0) where facility_id = ? and clinic_code=? and trunc(clinic_date)= to_date(?,'DD/MM/YYYY') and nvl(practitioner_id,'X')=nvl(?,'X') and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_class+"' and primary_resource_yn='Y' "); modified for tuning
										//sql5.append("total_first_visit=nvl(total_first_visit,0)+decode('"+visitind+"','F',1,0), TOTAL_FIRST_VISIT_SLOTS_BOOKED=nvl(TOTAL_FIRST_VISIT_SLOTS_BOOKED,0)+decode('"+visitind+"','F',1,0),total_follow_up=nvl(total_follow_up,0)+decode('"+visitind+"','L',1,0),total_routine=nvl(total_routine,0)+decode('"+visitind+"','R',1,0),total_series=nvl(total_series,0)+decode('"+visitind+"','S',1,0),total_consult=nvl(total_consult,0)+decode('"+visitind+"','C',1,0),total_emergency=nvl(total_emergency,0)+decode('"+visitind+"','E',1,0) where facility_id = ? and clinic_code=? and clinic_date= to_date(?,'DD/MM/YYYY') and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_class+"' and primary_resource_yn='Y' ");
										sql5.append("total_first_visit=nvl(total_first_visit,0)+decode(?,'F',1,0), TOTAL_FIRST_VISIT_SLOTS_BOOKED=nvl(TOTAL_FIRST_VISIT_SLOTS_BOOKED,0)+decode(?,'F',1,0),total_follow_up=nvl(total_follow_up,0)+decode(?,'L',1,0),total_routine=nvl(total_routine,0)+decode(?,'R',1,0),total_series=nvl(total_series,0)+decode(?,'S',1,0),total_consult=nvl(total_consult,0)+decode(?,'C',1,0),total_emergency=nvl(total_emergency,0)+decode(?,'E',1,0),MODIFIED_BY_ID=?,MODIFIED_DATE =sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID =? where facility_id = ? and clinic_code=? and clinic_date= to_date(?,'DD/MM/YYYY') and care_locn_type_ind=? and resource_class=? and primary_resource_yn='Y' ");
										if(practitionerid.equals("")){
											sql5.append(" and practitioner_id is null ");
										}else{
											sql5.append(" and practitioner_id =? ");
										}
										if (pstmt3!=null) pstmt3.close();
										pstmt3 = con.prepareStatement( sql5.toString() );
										pstmt3.setString	( 1, visitind ) ;
										pstmt3.setString	( 2, visitind ) ;
										pstmt3.setString	( 3, visitind ) ;
										pstmt3.setString	( 4, visitind ) ;
										pstmt3.setString	( 5, visitind ) ;
										pstmt3.setString	( 6, visitind ) ;
										pstmt3.setString	( 7, visitind ) ;
										pstmt3.setString	( 8, modifiedById ) ;
										pstmt3.setString	( 9, modifiedAtWorkstation ) ;
										pstmt3.setString	( 10, modifiedFacilityId ) ;
										pstmt3.setString	( 11, addedFacilityId ) ;
										pstmt3.setString	( 12, cliniccode ) ;
										pstmt3.setString	( 13, apptdate ) ;
										pstmt3.setString	( 14, clinic_type ) ;
										pstmt3.setString	( 15, res_class ) ;
										if(!practitionerid.equals("")){
											pstmt3.setString	( 16, practitionerid ) ;
										}
										res2 =0;
										
										res2 =pstmt3.executeUpdate();
									}else{
										//sql4=" update oa_clinic_schedule set  TOTAL_FORCED_IN_BOOKED=nvl(TOTAL_FORCED_IN_BOOKED,0)+1  					where facility_id = ? and clinic_code=? and trunc(clinic_date)= to_date(?,'DD/MM/YYYY') and nvl(practitioner_id,'X')=nvl(?,'X') and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_class+"' and primary_resource_yn='Y' ";modified for tuning
										if(practitionerid.equals("")){
											sql4=" update oa_clinic_schedule set  TOTAL_FORCED_IN_BOOKED=nvl(TOTAL_FORCED_IN_BOOKED,0)+1,MODIFIED_BY_ID=?,MODIFIED_DATE =sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID =? where facility_id = ? and clinic_code=? and clinic_date= to_date(?,'DD/MM/YYYY') and care_locn_type_ind=? and resource_class=? and primary_resource_yn='Y' and practitioner_id is null";
										}else{
											sql4=" update oa_clinic_schedule set  TOTAL_FORCED_IN_BOOKED=nvl(TOTAL_FORCED_IN_BOOKED,0)+1,MODIFIED_BY_ID=?,MODIFIED_DATE =sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID =? where facility_id = ? and clinic_code=? and clinic_date= to_date(?,'DD/MM/YYYY') and care_locn_type_ind=? and resource_class=? and primary_resource_yn='Y' and practitioner_id=?";
										}
										if (pstmt3!=null) pstmt3.close();
										pstmt3 = con.prepareStatement( sql4 );
										pstmt3.setString	( 1, modifiedById ) ;
										pstmt3.setString	( 2, modifiedAtWorkstation ) ;
										pstmt3.setString	( 3, modifiedFacilityId ) ;
										pstmt3.setString	( 4, addedFacilityId ) ;
										pstmt3.setString	( 5, cliniccode ) ;
										pstmt3.setString	( 6, apptdate ) ;
										pstmt3.setString	( 7, clinic_type ) ;
										pstmt3.setString	( 8, res_class ) ;
										if(!practitionerid.equals("")){
											pstmt3.setString	( 9, practitionerid ) ;
										}
										res2 =0;
										
										res2 =pstmt3.executeUpdate();
									}
								}
							}//end of else
							if ( res2 != 0 ) {
								result = true ;
							}else{
								sb.append("Transaction Failed in oa_clinic_schedule update query");
								con.rollback();
								result = false ;
							}
						}
						//Updation of status in  pr_referral_register as 'C' if refcode exists
						if(result){
							if(!(refcode.equals(""))){
								sql4=" update  pr_referral_register set status = 'C' , referred_in_func = 1,MODIFIED_BY_ID=?,MODIFIED_DATE =sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID =? where referral_id = ? ";
								if (pstmt3!=null) pstmt3.close();
								pstmt3 = con.prepareStatement( sql4 );
								pstmt3.setString( 1, modifiedById) ;
								pstmt3.setString( 2, modifiedAtWorkstation) ;
								pstmt3.setString( 3, modifiedFacilityId) ;
								pstmt3.setString( 4, refcode) ;
								res3 =0;
								res3 =pstmt3.executeUpdate();
								if ( res3 != 0 ) {
									result = true ;
								}else{
									sb.append("Transaction Failed in pr_referral_register update query");
									con.rollback();
									result = false ;
								}
							}  // end of if refcode
						} // end of if result
						//added for bru-crf chnages by sudhakar
						if(canldapptrefno!=null && !canldapptrefno.equals("")){
							//Updating audit columns::
							sql4=" update  oa_appt_del_tr set NEW_APPT_REF_NO = ?, MODIFIED_BY_ID= ? , MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO= ?, MODIFIED_FACILITY_ID=? where facility_id=? and appt_ref_no=? and APPT_STATUS = 'C' ";
							if (pstmt3!=null) pstmt3.close();
							pstmt3 = con.prepareStatement( sql4 );
							pstmt3.setString( 1, disp_appt_ref_no) ;
							pstmt3.setString( 2, addedById) ;
							pstmt3.setString( 3, addedAtWorkstation) ;
							pstmt3.setString( 4, addedFacilityId) ;
							
							pstmt3.setString( 5, addedFacilityId) ;
							pstmt3.setString( 6, canldapptrefno) ;
							res3 =pstmt3.executeUpdate();
							if ( res3 != 0 ) {
								result = true ;
							}else{
								sb.append("Transaction Failed in pr_referral_register update query");
								con.rollback();
								result = false ;
							}
						}
						/* Added for Billing Interface */
						if(bl_operational.equals("Y") && capture_fin_dtls_yn.equals("Y") && result &&  !(billing_group == null || billing_group.equals(""))){
							try{
								Hashtable hashtableBill = new Hashtable();
								hashtableBill.put("facilityId",addedFacilityId+"");
								hashtableBill.put("bookingrefno",nextsrlno1+"");
								hashtableBill.put("admissiondate",apptdate+"");
								hashtableBill.put("addedAtWorkstation",addedAtWorkstation+"");
								hashtableBill.put("P_MODE","I");
								hashtableBill.put("P_PATIENT_ID",patientid+"");
								hashtableBill.put("fin_dtls",fin_dtls);
								hashtableBill.put("P_EPISODE_TYPE",P_EPISODE_TYPE+"");
								hashtableBill.put("addedById",addedById+"");
								hashtableBill.put("function_id",strFunctionId+"");
								hashtableBill.put("locale",locale);
								BLBooking blbkBookPat = new BLBooking();
								Hashtable resultsBL = blbkBookPat.billPatientService(p, con,hashtableBill);
								boolean boolRes = ((Boolean)(resultsBL.get("status"))).booleanValue();
								result = boolRes;
								String strBLMessage = "";
								if (boolRes == false){
									result = false;
									strBLMessage = (String) resultsBL.get("error");
									if (strBLMessage != null ){
										if (!strBLMessage.equalsIgnoreCase("null")){
											if(strBLMessage.indexOf("<br>")!=-1){
												strBLMessage = strBLMessage.substring(strBLMessage.indexOf("<br>")+4);
												sb.append(strBLMessage);
											}else
												sb.append("<u>"+strBLMessage+"</u><br>");
										}
									}
								}
								if (boolRes == true){
									/*strBLMessage = (String) resultsBL.get("message");
									if (strBLMessage != null )
									{
										if (!strBLMessage.equalsIgnoreCase("null"))
										{
											sb.append("<u>"+strBLMessage+"</u><br>");
										}
									}*/
								}
							}catch (Exception exceptionBL){
								result = false;
								sb.append("BILLING UPDATION :"+exceptionBL.toString());
								exceptionBL.printStackTrace();
							}
						}// End of Billing Interface
						
						if(!recurringdays.equals("")){
							//HashMap hmap=recurringBookAppointment(p,passObjects,con,con1);
							HashMap hmap=recurringBookAppointment(p,passObjects,con);
							result=((Boolean)hmap.get("status")).booleanValue();
							
							if(result){
								java.util.Hashtable message = MessageManager.getMessage( locale,"OA_APPT_BOOKED","OA") ;
								String message1 =(String) message.get("message")  ;
								sb.append( message1.substring(0,message1.length()-4)+disp_appt_ref_no);
								message.clear();
								con.commit();
								//con.rollback();
							}else{
								sb.append("Transaction Failed. Pls try again");
								con.rollback();
							}
							//recurringBookAppointment(p,passObjects);
						}else{
							if(result){
								java.util.Hashtable message = MessageManager.getMessage(locale,"OA_APPT_BOOKED" ,"OA") ;
								String message1 =(String) message.get("message")  ;
								sb.append( message1+disp_appt_ref_no);
								message.clear();
								con.commit();
								//con.rollback();
							}else{
								sb.append("Transaction Failed");
								con.rollback();
							}
						}
						if(send_email_yn.equals("Y") && result){
							try{
								cstmt=con.prepareCall("{call OA_SEND_APPT_MAIL(?,?,?,?,?,?,?,?,?)}");
								cstmt.setString(1,addedFacilityId);
								cstmt.setString(2,"OA");
								cstmt.setString(3,"OAEBKAPPT");
								cstmt.setString(4,"P");
								cstmt.setString(5,patientid);
								cstmt.setString(6,"");
								cstmt.setString(7,disp_appt_ref_no);
								cstmt.setString(8,"en");
								cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
								cstmt.execute();
								String mailerror=cstmt.getString(9);
								if(mailerror == null) mailerror="";
								if(mailerror.equals("")){
									result=true;
								}else{
									result=false;
								}
							}catch(Exception mailex){
									mailex.printStackTrace();
									result=false;
									sb.append("MAIL ID UPDATION Excepiton:"+mailex.toString());
							}
						}
					}else{
						sb.append("Transaction Failed in oa_appt insert query");
						con.rollback();
					}
					
					//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
						//Starts
						try 
							{
								
							if(result && smartCardFunc.equals("01") && !biometric_reason.equals(""))
								{
								String status1=eCommon.Common.CommonBean.insertReasonforBiometric(con,addedFacilityId,"OA_APPT",patientid,nextsrlno1,cliniccode,biometric_reason,addedAtWorkstation,addedById);
								
								if(status1.equals("S"))
									{
									result	= true;	
									}
								else {
									result	= false;
									}	
								} 
							}
						catch(Exception e)
							{
							result	= false;
							e.printStackTrace();
							}
						//Ends	
					
				}//if ( insertable )
			}else{
				result=true;
				ModifyAppointment(p,passObjects);
			}
			//arrLstrecc.clear();
			//tabdata1.clear();
		}catch ( Exception e ){
			e.printStackTrace();
			result=false;
			sb.append("ERROR  :"+e.toString());
			try{
				 if(con != null){
					 con.rollback();
				 }
			}catch(Exception es){
				es.printStackTrace();
			}
		}finally{
	      if(con != null){
	         ConnectionManager.returnConnection(con,p);
			}
			/*if (con1 != null){
	         ConnectionManager.returnConnection(con1,p);
			}*/
			try{
				passObjects.clear();
				sec_resources.clear();
				if(Stmt!= null) Stmt.close() ;
				if(pstmt!= null) pstmt.close() ;
				if(pstmt_sql_sec_rstyp1!= null) pstmt_sql_sec_rstyp1.close() ;
				if(pstmt_sql_sec_rstyp2!= null) pstmt_sql_sec_rstyp2.close() ;
				if(pstmt_sql_sec_rstyp3!= null) pstmt_sql_sec_rstyp3.close() ;
				if(pstmt_ins_secondary_res!= null) pstmt_ins_secondary_res.close() ;
				if(pstmt_sql_sec_stat!= null) pstmt_sql_sec_stat.close() ;
				if(pstmt_sql_upop_1!= null) pstmt_sql_upop_1.close() ;
				if(pstmt_sql_upop_2!= null) pstmt_sql_upop_2.close() ;
				if(pstmt_sqldssec!= null) pstmt_sqldssec.close() ;
				if(pstmtMR!= null) pstmtMR.close() ;
				if(pstmt1!= null) pstmt1.close() ;
				if(pstmt2!= null) pstmt2.close() ;
				if(pstmt3!= null) pstmt3.close() ;
				if(pstmtOR!= null) pstmtOR.close() ;
				if(pstmtOR1!= null) pstmtOR1.close() ;
				if(pstmtOR2!= null) pstmtOR2.close() ;
				if(pstmt_oa_cl_sch_dtl!= null) pstmt_oa_cl_sch_dtl.close() ;
				if(rsds!= null) rsds.close() ;
				if(Stmt2!= null) Stmt2.close() ;
				if(Stmt!= null) Stmt.close() ;
				if(rso!= null) rso.close() ;
				if(rs!= null) rs.close() ;
				if(rsor!= null) rsor.close() ;
				if(clblstmt!= null) clblstmt.close();
				if(clblstmt1!= null) clblstmt1.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}//finally
		results.put( "status", new Boolean(result) ) ;
		results.put( "apptrefno",disp_appt_ref_no ) ;

		String error_msg = sb.toString();

		if(error_msg.contains("Selected slot already booked for a different appointment"))
		{
			java.util.Hashtable message = MessageManager.getMessage(locale,"BOOKED_FOR_DIFF_APPT","OA") ;
			error_msg = (String) message.get("message");
			message.clear();
		}

		results.put( "error", error_msg ) ;
		return results ;
	}//method

/**
* @ejb.interface-method
*	 view-type="both"
*/
public java.util.HashMap insertGroupAppointment(java.util.Properties p,java.util.HashMap passObjects){
   
		Connection con =null;
	    PreparedStatement pstmt =null;
		CallableStatement callablestatement=null;
		String locale = p.getProperty("LOCALE");
		boolean result = false ;
		StringBuffer resultMessage = new StringBuffer( "" ) ;
		
		java.util.HashMap results = new java.util.HashMap() ;
		String cliniccode = (String) passObjects.get("cliniccode");					
		String p_care_locn_type_ind = (String) passObjects.get("p_care_locn_type_ind");
		String p_resource_class = (String) passObjects.get("p_resource_class");			
		String practitionerid = (String) passObjects.get("practitionerid");			
		String appt_date = (String) passObjects.get("appt_date");					
		String appttime = (String) passObjects.get("appttime");					
		String apptslabfmtime = (String) passObjects.get("apptslabfmtime");				
		String apptslabtotime = (String) passObjects.get("apptslabtotime");	
		String p_appt_duration	= (String) passObjects.get("p_appt_duration");
		String p_speciality_code= (String) passObjects.get("p_speciality_code");			
		String sel_service_code= (String) passObjects.get("sel_service_code");			
		String p_time_table_type= (String) passObjects.get("p_time_table_type");
		String p_facility_id= (String) passObjects.get("p_facility_id");
		String p_contact_reason_code= (String) passObjects.get("p_contact_reason_code");		
		String p_mode_of_contact= (String) passObjects.get("p_mode_of_contact");			
		String p_appt_remarks = (String) passObjects.get("p_appt_remarks");				
		String receivingDtTme= (String) passObjects.get("receivingDtTme");				
		String p_appt_type_code= (String) passObjects.get("p_appt_type_code");			
		String p_added_at_ws_no= (String) passObjects.get("p_added_at_ws_no");			
		String p_added_facility_id= (String) passObjects.get("p_added_facility_id");
		String p_ws_no= (String) passObjects.get("p_modified_at_ws_no");		
		String p_modified_facility_id= (String) passObjects.get("p_modified_facility_id");		
		String p_clinic_date= (String) passObjects.get("p_clinic_date");				
		String group_id= (String) passObjects.get("group_id");
		String p_visit_id= (String) passObjects.get("p_visit_id");				
		String p_user_id= (String) passObjects.get("p_user_id"); 
		

		try{
			con = ConnectionManager.getConnection(p);
			con.setAutoCommit( false );
			
			callablestatement = con.prepareCall("{call oa_group_appointment(?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'hh24:mi'),to_date(?,'hh24:mi'),to_date(?,' hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?)}");
			//callablestatement = con.prepareCall("{call oa_group_appointment(?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'hh24:mi'),?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?)}");
			callablestatement.setString(1,cliniccode);
			callablestatement.setString(2,p_care_locn_type_ind);
			callablestatement.setString(3,p_resource_class);
			callablestatement.setString(4,practitionerid);		
			callablestatement.setString(5,appt_date);				
			callablestatement.setString(6,appttime);					
			callablestatement.setString(7,apptslabfmtime);
			callablestatement.setString(8,apptslabtotime);	
			callablestatement.setString(9,p_appt_duration);
			callablestatement.setString(10,p_speciality_code);			
			callablestatement.setString(11,sel_service_code);			
			callablestatement.setString(12,p_time_table_type);
			callablestatement.setString(13,p_facility_id);
			callablestatement.setString(14,p_contact_reason_code);
			callablestatement.setString(15,p_mode_of_contact);
			callablestatement.setString(16,p_appt_remarks);
			callablestatement.setString(17,receivingDtTme);
			callablestatement.setString(18,p_appt_type_code);
			callablestatement.setString(19,p_ws_no);					
			callablestatement.setString(20,p_clinic_date);
			callablestatement.setString(21,group_id);
			callablestatement.setString(22,p_visit_id);
			callablestatement.setString(23,p_user_id);			
			callablestatement.setString(24,apptslabfmtime);
			callablestatement.setString(25,apptslabtotime);	
			callablestatement.registerOutParameter(26,Types.VARCHAR);
			callablestatement.registerOutParameter(27,Types.VARCHAR);
			callablestatement.execute();		
			String result_proc	= callablestatement.getString(27);
			if(result_proc!=null && result_proc.equals("SUCCESS")) {
				result=true;
				java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_INSERTED","SM" ) ;
				resultMessage.append( (String) message.get("message") ) ;
				con.commit();
				message.clear();
			}else{
				  result=false;
				  con.rollback();
				  resultMessage.append(result_proc);
			}
			if(callablestatement!=null) callablestatement.close();	

			passObjects.clear();
		}catch(Exception exception){
			resultMessage.append("Error from EJB  :"+exception.toString());
			exception.printStackTrace();
		}
		finally
		{
		   	ConnectionManager.returnConnection(con,p);
		}
		results.put( "status", new Boolean(result) ) ;
	    results.put( "error", resultMessage.toString() ) ;
	    resultMessage.setLength(0);
	    return results ;
	
	}//method

	public java.util.HashMap ModifyAppointment(java.util.Properties p,
			java.util.HashMap passObjects)
	{
		// class level variables are moved. Changed @UAT-3 By Sudhakar Starts
		Connection con=null;
		Statement Stmt = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt3 = null;
		CallableStatement cstmt = null;
		ResultSet rsds=null;
		// class level variables are moved. Changed @UAT-3 By Sudhakar Ends
		//Added by Ajay Hatwate for ML-MMOH-CRF-1930
		Boolean isVirtualConsultation = false;
	//	isVirtualConsultation = eCommon.Common.CommonBean.isSiteSpecific(con, "OP", "VIRTUAL_CONSULTATION");
		String ccNxtOfKinNo = checkForNull((String)passObjects.get("ccNxtOfKinNo"));
		String nxtOfKinNo = checkForNull((String)passObjects.get("nxtOfKinNo"));
		String patCountryCode = checkForNull((String)passObjects.get("patCountryCode"));
		String patTelCode = checkForNull((String)passObjects.get("patTelCode"));
		//End of ML-MMOH-CRF-1930
		HashSet tabdata1;
		tabdata1 = new HashSet();
		String facilityId=(String) passObjects.get("addedFacilityId");
		//String cliniccode=(String) passObjects.get("cliniccode");
		//String practitionerid=(String) passObjects.get("practitionerid");
		//String appttime=(String) passObjects.get("appttime");
		String apptdate=(String) passObjects.get("apptdate");
		String patientid=(String) passObjects.get("patientid");
		String prefix=(String) passObjects.get("prefix");
		String firstname=(String) passObjects.get("firstname");
		String secondname=(String) passObjects.get("secondname");
		String thirdname=(String) passObjects.get("thirdname");
		String familyname=(String) passObjects.get("familyname");
		String suffix=(String) passObjects.get("suffix");
		String patientname=(String) passObjects.get("patientname");
		String patient_name_long=(String)passObjects.get("patient_name_long");
		String patient_name_loc_lang_long=(String)passObjects.get("patient_name_loc_lang_long");
		String gender=(String) passObjects.get("gender");
		String dateofbirth=(String) passObjects.get("dateofbirth");
		String nationalidno=(String) passObjects.get("nationalidno");
		String altid1no=(String) passObjects.get("altid1no");
		//String apptcode=(String) passObjects.get("apptcode");
		//String visitind=(String) passObjects.get("visitind");
		//String overbooked=(String) passObjects.get("overbooked");
		String contactreason=(String) passObjects.get("contactreason");
		String contactmode=(String) passObjects.get("contactmode");
		String apptrem=(String) passObjects.get("apptrem");
		String restelno=(String) passObjects.get("restelno");
		String othtelno=(String) passObjects.get("othtelno");
		String emailid=(String) passObjects.get("emailid");
		String timetabletype=(String) passObjects.get("timetabletype");
		//String alcn_criteria=(String) passObjects.get("alcn_criteria");
		//String pat_cat=(String) passObjects.get("pat_cat");
		String nationality_code=(String) passObjects.get("nationality_code");
		String addedFacilityId=(String) passObjects.get("addedFacilityId");
		String addedAtWorkstation=(String) passObjects.get("addedAtWorkstation");
		//String ref_priority=(String) passObjects.get("ref_priority");
		//String team_id=(String) passObjects.get("team_id");
		//String inpatient_yn=(String) passObjects.get("inpatient_yn");
		String altid1typ=(String) passObjects.get("altid1typ");
		String altid1expdt=(String) passObjects.get("altid1expdt");
		String altid2no=(String) passObjects.get("altid2no");
		String altid2typ=(String) passObjects.get("altid2typ");
		String altid2expdt=(String) passObjects.get("altid2expdt");
		String altid3no=(String) passObjects.get("altid3no");
		String altid3typ=(String) passObjects.get("altid3typ");
		String altid3expdt=(String) passObjects.get("altid3expdt");
		String altid4no=(String) passObjects.get("altid4no");
		String altid4typ=(String) passObjects.get("altid4typ");
		String altid4expdt=(String) passObjects.get("altid4expdt");
		String Othaltid1=(String) passObjects.get("Othaltid1");
		String Othaltid1typ=(String) passObjects.get("Othaltid1typ");
		String ethnicGrp=(String) passObjects.get("ethnicGrp");
		String receivingDtTme=(String) passObjects.get("receivingDtTme");
		//String forced=(String) passObjects.get("forced");
		String birthPlace=(String) passObjects.get("birthPlace");
		String residency=(String) passObjects.get("residency");
		String status=(String) passObjects.get("status"); 
		String ethnicSbGrp=(String) passObjects.get("ethnicSbGrp");
		//String global=(String) passObjects.get("global");
		String res_addr1=(String) passObjects.get("res_addr1");
		String res_addr2=(String) passObjects.get("res_addr2");
		String res_addr3=(String) passObjects.get("res_addr3");
		String res_addr4=(String) passObjects.get("res_addr4");
		String res_town=(String) passObjects.get("res_town");
		String res_area=(String) passObjects.get("res_area");
		String res_postal=(String) passObjects.get("res_postal");
		String res_region=(String) passObjects.get("res_region");
		String res_country=(String) passObjects.get("res_country");
		String mail_addr1=(String) passObjects.get("mail_addr1");
		String mail_addr2=(String) passObjects.get("mail_addr2");
		String mail_addr3=(String) passObjects.get("mail_addr3");
		String mail_addr4=(String) passObjects.get("mail_addr4");
		String mail_town=(String) passObjects.get("mail_town");
		String mail_area=(String) passObjects.get("mail_area");
		String mail_postal=(String) passObjects.get("mail_postal");
		String mail_region=(String) passObjects.get("mail_region");
		String mail_country=(String) passObjects.get("mail_country");
		//String birthPlace_desc=(String) passObjects.get("birthPlace_desc");
		//String clinic_type=(String) passObjects.get("clinic_type");
		//String res_class=(String) passObjects.get("res_class");
		//String or_catalogue_code=(String) passObjects.get("or_catalogue_code");
		//String recurringdays=(String) passObjects.get("recurringdays");
		String name_prefix_oth_lang=(String) passObjects.get("name_prefix_oth_lang");
		String first_name_oth_lang=(String) passObjects.get("first_name_oth_lang");
		String second_name_oth_lang=(String) passObjects.get("second_name_oth_lang");
		String third_name_oth_lang=(String) passObjects.get("third_name_oth_lang");
		String family_name_oth_lang=(String) passObjects.get("family_name_oth_lang");
		String name_suffix_oth_lang=(String) passObjects.get("name_suffix_oth_lang");
		String patient_name_local_lang=(String) passObjects.get("patient_name_local_lang");
		String capture_fin_dtls_yn=(String) passObjects.get("capture_fin_dtls_yn");
		String billing_group=(String) passObjects.get("billing_group");
		String bl_operational=(String) passObjects.get("bl_operational");
		String P_EPISODE_TYPE=(String) passObjects.get("P_EPISODE_TYPE");
		String strFunctionId		= "BOOKING";
		String apptrefnum=(String) passObjects.get("apptrefnum");
		String refcode=(String) passObjects.get("refcode");
		String referral_id_old=(String) passObjects.get("referral_id_old");
		if(referral_id_old==null)referral_id_old="";
		HashMap	fin_dtls  = (HashMap)passObjects.get("fin_dtls");
		String locale = p.getProperty("LOCALE");
		java.util.HashMap results = new java.util.HashMap() ;
		//java.util.ArrayList arrLstrecc=new java.util.ArrayList();
		boolean result = false ;
		StringBuffer sb = new StringBuffer( "" ) ;
		String sel_service_code=(String) passObjects.get("sel_service_code");
		if(sel_service_code==null)sel_service_code="";		
		String apptslabtotime=(String) passObjects.get("apptslabtotime");
		String apptslabfmtime=(String) passObjects.get("apptslabfmtime");
		String time="";
		HashMap patInstructionsMap=(HashMap) passObjects.get("patInstructionsMap");
		HashMap prcInstructionMap=(HashMap) passObjects.get("prcInstructionMap");
		String patient_cat_code = (String)passObjects.get("patient_cat_code");
		String language_id			= (String)passObjects.get("language_id");		
		String patCnclCount	=(String) passObjects.get("patCnclCount");//changes for BruHIMS-CRF 169
		String trans_exceed_reason_code	=(String) passObjects.get("trans_exceed_reason_code");
		String upt_contact_dtls_mp_yn=(String) passObjects.get("upt_contact_dtls_mp_yn");;//added changes for HSA-CRF-0226 [IN:050599]
		/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
		String altAddrLine1		= checkForNull((String)passObjects.get("altAddrLine1"));
		String altAddrLine2		= checkForNull((String)passObjects.get("altAddrLine2"));
		String altAddrLine3		= checkForNull((String)passObjects.get("altAddrLine3"));
		String altAddrLine4		= checkForNull((String)passObjects.get("altAddrLine4"));
		String altAreaCode		= checkForNull((String)passObjects.get("altAreaCode"));
		String altTownCode		= checkForNull((String)passObjects.get("altTownCode"));
		String altPostalCode	= checkForNull((String)passObjects.get("altPostalCode"));
		String altRegionCode	= checkForNull((String)passObjects.get("altRegionCode"));
		String altCountryCode	= checkForNull((String)passObjects.get("altCountryCode"));
		/*End*/
		try{
			con = ConnectionManager.getConnection(p);
			con.setAutoCommit( false );
			isVirtualConsultation = eCommon.Common.CommonBean.isSiteSpecific(con, "OP", "VIRTUAL_CONSULTATION");
			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = p.getProperty( "login_user" ) ;		
			addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String modifiedAtWorkstation = addedAtWorkstation ;
			StringBuffer sql_modify=new StringBuffer ();
			StringBuffer sql_modify2=new StringBuffer ();
			//String disp_appt_ref_no="";
			Stmt = con.createStatement();
			int res_up=0;
			//adding to update modified appt time for free format Starts Here
			final String sqlds="select get_time_between(to_date('"+apptdate+" "+apptslabtotime+"',' dd/mm/yyyy hh24:mi'),to_date('"+apptdate+" "+apptslabfmtime+"','dd/mm/yyyy hh24:mi')) from dual ";
			pstmt1=con.prepareStatement(sqlds);

			rsds=pstmt1.executeQuery();
			if(rsds !=null && rsds.next()){
				time=rsds.getString(1);
				time=apptdate+" "+time;
			}
			//adding to update modified appt time for free format Starts Here
			if(!patientid.equals("") || !refcode.equals("")){
				sql_modify.append("update oa_appt set res_tel_no='"+restelno+"', referral_id='"+refcode+"', oth_contact_no='"+othtelno+"',email_id='"+emailid+"', res_addr_line1='"+res_addr1.replaceAll("'","''")+"', res_addr_line2='"+res_addr2.replaceAll("'","''")+"',res_addr_line3='"+res_addr3.replaceAll("'","''")+"', res_addr_line4='"+res_addr4.replaceAll("'","''")+"',postal_code='"+res_postal+"',contact_reason_code='"+contactreason+"', mode_of_contact='"+contactmode+"',COUNTRY_CODE='"+nationality_code+"' ,appt_remarks='"+apptrem.replaceAll("'","''")+"',modified_date=sysdate,modified_facility_id='"+modifiedFacilityId+"',modified_by_id='"+modifiedById+"', modified_at_ws_no='"+modifiedAtWorkstation+"',RES_AREA_CODE='"+res_area+"',RES_TOWN_CODE='"+res_town+"',RES_REGION_CODE='"+res_region+"',MAIL_ADDR_LINE1='"+mail_addr1.replaceAll("'","''")+"',MAIL_ADDR_LINE2='"+mail_addr2.replaceAll("'","''")+"',MAIL_ADDR_LINE3='"+mail_addr3.replaceAll("'","''")+"',MAIL_ADDR_LINE4='"+mail_addr4.replaceAll("'","''")+"',MAIL_AREA_CODE='"+mail_area+"',MAIL_TOWN_CODE='"+mail_town+"',MAIL_REGION_CODE='"+mail_region+"',MAIL_POSTAL_CODE='"+mail_postal+"',MAIL_COUNTRY_CODE='"+mail_country+"',RES_COUNTRY_CODE='"+res_country+"',SERVICE_CODE='"+sel_service_code+"',language_id = '"+language_id+"', alt_addr_line1='"+altAddrLine1.replaceAll("'","''")+"',alt_addr_line2='"+altAddrLine2.replaceAll("'","''")+"',alt_addr_line3='"+altAddrLine3.replaceAll("'","''")+"',alt_addr_line4='"+altAddrLine4.replaceAll("'","''")+"',alt_area_code='"+altAreaCode+"',alt_town_code='"+altTownCode+"',alt_region_code='"+altRegionCode+"',alt_postal_code='"+altPostalCode+"',alt_country_code='"+altCountryCode+"' ");//Modified by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601
				if(!receivingDtTme.equals("N"))
					sql_modify.append(",RECEIVING_DATE_TIME=to_date('"+receivingDtTme+"','dd/mm/yyyy hh24:mi')");
				if(timetabletype.equals("3")){

					sql_modify.append(",appt_slab_from_time=to_date('"+apptslabfmtime+"','hh24:mi'),appt_slab_to_time=to_date('"+apptslabtotime+"','hh24:mi'),appt_duration=to_date('"+time+"','dd/mm/yyyy hh24:mi') ");
				}
				sql_modify.append(",PATIENT_CAT_CODE='"+patient_cat_code+"',patient_long_name=?,patient_long_name_loc_lang=?,trans_exceed_reason_code='"+trans_exceed_reason_code+"' ");
				//Added by Ajay Hatwate for ML-MMOH-CRF-1930
				if(isVirtualConsultation){
					sql_modify.append(", CONTACT1_MOB_TEL_NO='"+nxtOfKinNo+"', CONTACT1_MOB_COUNTRY_CODE = '"+ccNxtOfKinNo+"', contact2_telephone_code='"+patTelCode+"', contact2_country_code = '"+patCountryCode+"' ");
				}
				sql_modify.append(" where facility_id='"+facilityId+"' and APPT_REF_NO='"+apptrefnum+"'");
				pstmt=con.prepareStatement(sql_modify.toString());
				pstmt.setString(1,patient_name_long);				
				pstmt.setString(2,patient_name_loc_lang_long);
				res_up =pstmt.executeUpdate();
				//Added for ML-MMOH-CRF-1930
				if(isVirtualConsultation){
					if(pstmt1!=null) pstmt1.close();
							String updateVirtualDet1= "update mp_patient set EMAIL_ID='"+emailid+"',CONTACT1_NO='"+restelno+"',CONTACT2_NO='"+othtelno+"',modified_by_id='"+modifiedById+"',modified_date=sysdate,modified_at_ws_no='"+modifiedAtWorkstation+"',modified_facility_id='"+modifiedFacilityId+"', contact2_telephone_code='"+patTelCode+"', contact2_country_code='"+patCountryCode+"' where patient_id='"+patientid+"'";
						pstmt1=con.prepareStatement(updateVirtualDet1);
						pstmt1.executeUpdate();
						if(pstmt1!=null) pstmt1.close();
							String updateVirtualDet2= "update MP_PAT_REL_CONTACTS set contact1_mob_tel_no='"+nxtOfKinNo+"', CONTACT1_MOB_COUNTRY_CODE='"+ccNxtOfKinNo+"', modified_by_id='"+modifiedById+"', modified_date=sysdate, modified_at_ws_no='"+modifiedAtWorkstation+"', modified_facility_id='"+modifiedFacilityId+"' where patient_id='"+patientid+"'";
						pstmt1=con.prepareStatement(updateVirtualDet2);
						pstmt1.executeUpdate();
						if(pstmt1!=null)pstmt1.close();					
					}
				//End of ML-MMOH-CRF-1930
			}else{
			     
				
			
				sql_modify2.append("update oa_appt set res_tel_no='"+restelno+"', referral_id='"+refcode+"',  oth_contact_no='"+othtelno+"',email_id='"+emailid+"', res_addr_line1='"+res_addr1.replaceAll("'","''")+"', res_addr_line2='"+res_addr2.replaceAll("'","''")+"',res_addr_line3='"+res_addr3.replaceAll("'","''")+"', res_addr_line4='"+res_addr4.replaceAll("'","''")+"',postal_code='"+res_postal+"', country_code='"+nationality_code+"',contact_reason_code='"+contactreason+"', mode_of_contact='"+contactmode+"', appt_remarks='"+apptrem.replaceAll("'","''")+"',modified_date=sysdate,modified_facility_id='"+modifiedFacilityId+"',modified_by_id='"+modifiedById+"', modified_at_ws_no='"+modifiedAtWorkstation+"',RES_AREA_CODE='"+res_area+"',RES_TOWN_CODE='"+res_town+"',RES_REGION_CODE='"+res_region+"',MAIL_ADDR_LINE1='"+mail_addr1.replaceAll("'","''")+"',MAIL_ADDR_LINE2='"+mail_addr2.replaceAll("'","''")+"',MAIL_ADDR_LINE3='"+mail_addr3.replaceAll("'","''")+"',MAIL_ADDR_LINE4='"+mail_addr4.replaceAll("'","''")+"',MAIL_AREA_CODE='"+mail_area+"',MAIL_TOWN_CODE='"+mail_town+"',MAIL_REGION_CODE='"+mail_region+"',MAIL_POSTAL_CODE='"+mail_postal+"',MAIL_COUNTRY_CODE='"+mail_country+"',RES_COUNTRY_CODE='"+res_country+"',name_prefix=?,first_name=?,second_name=?,third_name=?,family_name=?,name_suffix=?,patient_name=?,gender='"+gender+"',date_of_birth=to_date('"+dateofbirth+"','dd/mm/yyyy'),NATIONAL_ID_NO='"+nationalidno+"',ALT_ID1_NO='"+altid1no+"',ALT_ID1_TYPE='"+altid1typ+"',ALT_ID2_NO='"+altid2no+"',ALT_ID2_TYPE='"+altid2typ+"',ALT_ID3_NO='"+altid3no+"',ALT_ID3_TYPE='"+altid3typ+"',ALT_ID4_NO='"+altid4no+"',ALT_ID4_TYPE='"+altid4typ+"',OTH_ALT_ID_NO='"+Othaltid1+"',OTH_ALT_ID_TYPE='"+Othaltid1typ+"',ETHNIC_GROUP_CODE='"+ethnicGrp+"',BIRTH_PLACE_CODE='"+birthPlace+"',CITIZEN_YN='"+residency+"',LEGAL_YN='"+status+"',RACE_CODE='"+ethnicSbGrp+"',NAME_PREFIX_LOC_LANG=?,FIRST_NAME_LOC_LANG=?,SECOND_NAME_LOC_LANG=?,THIRD_NAME_LOC_LANG=?,FAMILY_NAME_LOC_LANG=?,NAME_SUFFIX_LOC_LANG=?,PATIENT_NAME_LOC_LANG=?,PATIENT_LONG_NAME=?,PATIENT_LONG_NAME_LOC_LANG=?,alt_addr_line1=?,alt_addr_line2=?,alt_addr_line3=?,alt_addr_line4=?,alt_area_code=?,alt_town_code=?,alt_region_code=?,alt_postal_code=?,alt_country_code=?, SERVICE_CODE='"+sel_service_code+"',LANGUAGE_ID = '"+language_id+"'");
				if(timetabletype.equals("3")){					
					sql_modify2.append(",appt_slab_from_time=to_date('"+apptslabfmtime+"','hh24:mi'),appt_slab_to_time=to_date('"+apptslabtotime+"','hh24:mi'),appt_duration=to_date('"+time+"','dd/mm/yyyy hh24:mi') ");
				}
				if(!altid1expdt.equals("N"))
					sql_modify2.append(",ALT_ID1_EXP_DATE=to_date('"+altid1expdt+"','dd/mm/yyyy')");
				if(!altid2expdt.equals("N"))
					sql_modify2.append(",ALT_ID2_EXP_DATE=to_date('"+altid2expdt+"','dd/mm/yyyy')");
				if(!altid3expdt.equals("N"))
					sql_modify2.append(",ALT_ID3_EXP_DATE=to_date('"+altid3expdt+"','dd/mm/yyyy')");
				if(!altid4expdt.equals("N"))
					sql_modify2.append(",ALT_ID4_EXP_DATE=to_date('"+altid4expdt+"','dd/mm/yyyy')");
				if(!receivingDtTme.equals("N"))
					sql_modify2.append(",RECEIVING_DATE_TIME=to_date('"+receivingDtTme+"','dd/mm/yyyy hh24:mi')");
				sql_modify2.append(",PATIENT_CAT_CODE='"+patient_cat_code+"',trans_exceed_reason_code='"+trans_exceed_reason_code+"' ");
				//Added by Ajay Hatwate for ML-MMOH-CRF-1930
				if(isVirtualConsultation){
					sql_modify.append(", CONTACT1_MOB_TEL_NO='"+nxtOfKinNo+"', CONTACT1_MOB_COUNTRY_CODE = '"+ccNxtOfKinNo+"',contact2_telephone_code='"+patTelCode+"', contact2_country_code = '"+patCountryCode+"' ");
				}
				sql_modify2.append("where facility_id='"+facilityId+"' and APPT_REF_NO='"+apptrefnum+"'");
				//System.out.println("SQL @EJB:"+sql_modify2.toString());
				pstmt=con.prepareStatement(sql_modify2.toString());
				pstmt.setString(1,prefix);
				pstmt.setString(2,firstname);
				pstmt.setString(3,secondname);
				pstmt.setString(4,thirdname);
				pstmt.setString(5,familyname);
				pstmt.setString(6,suffix);
				pstmt.setString(7,patientname);
				pstmt.setString(8,name_prefix_oth_lang);
				pstmt.setString(9,first_name_oth_lang);
				pstmt.setString(10,second_name_oth_lang);
				pstmt.setString(11,third_name_oth_lang);
				pstmt.setString(12,family_name_oth_lang);
				pstmt.setString(13,name_suffix_oth_lang);
				pstmt.setString(14,patient_name_local_lang);				
				pstmt.setString(15,patient_name_long);				
				pstmt.setString(16,patient_name_loc_lang_long);
				pstmt.setString(17,altAddrLine1.replaceAll("'","''"));	
				pstmt.setString(18,altAddrLine2.replaceAll("'","''"));	
				pstmt.setString(19,altAddrLine3.replaceAll("'","''"));	
				pstmt.setString(20,altAddrLine4.replaceAll("'","''"));	
				pstmt.setString(21,altAreaCode);	
				pstmt.setString(22,altTownCode);	
				pstmt.setString(23,altRegionCode);	
				pstmt.setString(24,altPostalCode);	
				pstmt.setString(25,altCountryCode);	
				res_up =pstmt.executeUpdate();
				//ML-MMOH-CRF-1930
				if(isVirtualConsultation){
					if(pstmt1!=null) pstmt1.close();
							String updateVirtualDet1= "update mp_patient set EMAIL_ID='"+emailid+"',CONTACT1_NO='"+restelno+"',CONTACT2_NO='"+othtelno+"',modified_by_id='"+modifiedById+"',modified_date=sysdate,modified_at_ws_no='"+modifiedAtWorkstation+"',modified_facility_id='"+modifiedFacilityId+"',contact2_telephone_code='"+patTelCode+"', contact2_country_code='"+patCountryCode+"', contact2_telephone_code='"+patTelCode+"', contact2_country_code='"+patCountryCode+"' where patient_id='"+patientid+"'";
						pstmt1=con.prepareStatement(updateVirtualDet1);
						pstmt1.executeUpdate();
						if(pstmt1!=null) pstmt1.close();
							String updateVirtualDet2= "update MP_PAT_REL_CONTACTS set contact1_mob_tel_no='"+nxtOfKinNo+"', CONTACT1_MOB_COUNTRY_CODE='"+ccNxtOfKinNo+"', modified_by_id='"+modifiedById+"', modified_date=sysdate, modified_at_ws_no='"+modifiedAtWorkstation+"', modified_facility_id='"+modifiedFacilityId+"' where patient_id='"+patientid+"'";
						pstmt1=con.prepareStatement(updateVirtualDet2);
						pstmt1.executeUpdate();
						if(pstmt1!=null)pstmt1.close();					
					}
				//End of ML-MMOH-CRF-1930
			}
			if(res_up !=0){
				result=true;
				//Below  code added FOR HSA-CRF-0226 [IN:050599]
					if(upt_contact_dtls_mp_yn.equals("Y")){
					cstmt = con.prepareCall("{call MP_AUDIT_FUNCTION.ASSIGN_VALUE('SCH_APPT')}");
					 cstmt.execute();
					 if (cstmt !=null) cstmt.close();
					String update_contact_dtl= "update MP_PAT_ADDRESSES set addr1_line1='"+res_addr1+"',addr1_line2='"+res_addr2+"',addr1_line3='"+res_addr3+"',addr1_line4='"+res_addr4+"',postal1_code='"+res_postal+"' ,country1_code='"+res_country+"',addr2_line1='"+mail_addr1+"',addr2_line2='"+mail_addr2+"',addr2_line3='"+mail_addr3+"',addr2_line4='"+mail_addr4+"',postal2_code='"+mail_postal+"',country2_code='"+mail_country+"',modified_by_id='"+modifiedById+"',modified_date=sysdate,modified_at_ws_no='"+modifiedAtWorkstation+"',modified_facility_id='"+modifiedFacilityId+"',res_area2_code='"+mail_area+"',res_town2_code='"+mail_town+"',region2_code='"+mail_region+"',res_area1_code='"+res_area+"',res_town1_code='"+res_town+"',region1_code='"+res_region+"',alt_addr_line1='"+altAddrLine1+"',alt_addr_line2='"+altAddrLine2+"',alt_addr_line3='"+altAddrLine3+"',alt_addr_line4='"+altAddrLine4+"',alt_area_code='"+altAreaCode+"',alt_town_code='"+altTownCode+"',alt_region_code='"+altRegionCode+"',alt_postal_code='"+altPostalCode+"',alt_country_code='"+altCountryCode+"' where patient_id='"+patientid+"'";//Modified by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601
					pstmt1=con.prepareStatement(update_contact_dtl);
					pstmt1.executeUpdate();
					if (rsds !=null) rsds.close();
					if (pstmt1!=null) pstmt1.close();
					String update_contact_dtl1= "update mp_patient set EMAIL_ID='"+emailid+"',CONTACT1_NO='"+restelno+"',CONTACT2_NO='"+othtelno+"',modified_by_id='"+modifiedById+"',modified_date=sysdate,modified_at_ws_no='"+modifiedAtWorkstation+"',modified_facility_id='"+modifiedFacilityId+"',RES_AREA_CODE='"+res_area+"',RES_TOWN_CODE='"+res_town+"',REGION_CODE='"+res_region+"' where patient_id='"+patientid+"'";
					pstmt1=con.prepareStatement(update_contact_dtl1);
					pstmt1.executeUpdate();
					if (rsds !=null) rsds.close();
					if (pstmt1!=null) pstmt1.close();
					String  appt_count="select count(*)apt_cnt from oa_appt where patient_id='"+patientid+"' and APPT_DATE>= to_date(sysdate,'DD MM YY')";
					pstmt1 = con.prepareStatement(appt_count);
            	    rsds=pstmt1.executeQuery();
				    int apt_cnt=0;
				    if(rsds != null && rsds.next()){
				    apt_cnt=rsds.getInt("apt_cnt");
				       }
					if(apt_cnt > 1){
					String update_app_contact_dtl="update oa_appt set res_tel_no='"+restelno+"', oth_contact_no='"+othtelno+"',email_id='"+emailid+"', res_addr_line1='"+res_addr1+"', res_addr_line2='"+res_addr2+"',res_addr_line3='"+res_addr3+"', res_addr_line4='"+res_addr4+"',postal_code='"+res_postal+"',modified_date=sysdate,modified_facility_id='"+modifiedFacilityId+"',modified_by_id='"+modifiedById+"', modified_at_ws_no='"+modifiedAtWorkstation+"',RES_AREA_CODE='"+res_area+"',RES_TOWN_CODE='"+res_town+"',RES_REGION_CODE='"+res_region+"',MAIL_ADDR_LINE1='"+mail_addr1+"',MAIL_ADDR_LINE2='"+mail_addr2+"',MAIL_ADDR_LINE3='"+mail_addr3+"',MAIL_ADDR_LINE4='"+mail_addr4+"',MAIL_AREA_CODE='"+mail_area+"',MAIL_TOWN_CODE='"+mail_town+"',MAIL_REGION_CODE='"+mail_region+"',MAIL_POSTAL_CODE='"+mail_postal+"',MAIL_COUNTRY_CODE='"+mail_country+"',RES_COUNTRY_CODE='"+res_country+"',alt_addr_line1='"+altAddrLine1+"',alt_addr_line2='"+altAddrLine2+"',alt_addr_line3='"+altAddrLine3+"',alt_addr_line4='"+altAddrLine4+"',alt_area_code='"+altAreaCode+"',alt_town_code='"+altTownCode+"',alt_region_code='"+altRegionCode+"',alt_postal_code='"+altPostalCode+"',alt_country_code='"+altCountryCode+"' where patient_id='"+patientid+"' and APPT_DATE>= to_date(sysdate,'DD MM YY')";//Modified by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601
					pstmt1=con.prepareStatement(update_app_contact_dtl);
					pstmt1.executeUpdate();
					if (rsds !=null) rsds.close();
					if (pstmt1!=null) pstmt1.close();
					}
					}
					//end  of HSA-CRF-0226 [IN:050599]
			}else{
				result=false;
			}if(pstmt!=null) pstmt.close();  //checkstyle violation
			//Bru-HIMS CRF 169 changes start
			if(result && patientid != null && !(patientid.equals(""))){//to update the count in oa_pat_cncl_appt_summary only when  the appointment has a patient id.
				//CALL THE update method
				result=updateOAPatCnclSummary(con,patientid,facilityId,patCnclCount,addedById,addedAtWorkstation);
			}//Bru-HIMS-CRf 169  changes end
			if(result){
				if(patInstructionsMap!=null && !(patInstructionsMap.isEmpty())){
					String deletePatInstructions="delete FROM oa_appt_pat_instructions WHERE facility_id='"+facilityId+"' and APPT_REF_NO='"+apptrefnum+"'";
					pstmt = con.prepareStatement(deletePatInstructions);
					//res_up =pstmt.executeUpdate();
					pstmt.executeUpdate();
					String oa_pat_ins="insert into oa_appt_pat_instructions(facility_id, appt_ref_no, instruction_id, instruction_desc, display_order, added_by_id, added_date,added_facility_id, added_at_ws_no, modified_by_id, modified_date,modified_facility_id, modified_at_ws_no)values(?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
					if(pstmt!=null) pstmt.close();  //checkstyle violation
					pstmt = con.prepareStatement( oa_pat_ins);
					int recCount=patInstructionsMap.size();
					int executableCount=0;
					for(int cnt=1;cnt<=recCount;cnt++){
						Integer integer=new Integer(cnt);
						String instId="";
						//int instorder=cnt;
						String instDesc="";
						String checkYN="";
						String mapValue=(String)patInstructionsMap.get(integer.toString());
						String[] tokens=mapValue.split("\\|~");
						instId=tokens[0];
						instDesc=tokens[1];
						checkYN=tokens[2];
						if(instDesc.equals("*!*")){
							instDesc="";
						}
						
						//StringTokenizer token1=new StringTokenizer(mapValue, "|~");
						/*Above Line Commented by Senthil on 25-Oct-2011 */
						/*StringTokenizer token1=new StringTokenizer(mapValue, "||");
						while (token1.hasMoreTokens()){
							instId=token1.nextToken();
							instDesc=token1.nextToken();
						
							checkYN=token1.nextToken();
						}*/
						if(checkYN.equals("Y")){
							executableCount=executableCount+1;
							pstmt.setString	( 1,  addedFacilityId ) ;
							pstmt.setString	( 2,  apptrefnum ) ;
							pstmt.setString	( 3,  instId ) ;
							pstmt.setString	( 4,  instDesc ) ;
							pstmt.setInt	( 5,  executableCount ) ;
							pstmt.setString ( 6, p.getProperty( "login_user" ) );
							pstmt.setString	( 7, modifiedFacilityId ) ;
							pstmt.setString	( 8, modifiedAtWorkstation  ) ;
							pstmt.setString	( 9, p.getProperty( "login_user" ) ) ;
							pstmt.setString ( 10, modifiedFacilityId );
							pstmt.setString	( 11, modifiedAtWorkstation ) ;
							pstmt.addBatch();
						}
					}
					if(executableCount >0){
						int resultArr[]=pstmt.executeBatch();

						if(resultArr.length!=0){
							result=true;
						}else{
							result=false;
						}
					}
				}
			if(pstmt!=null) pstmt.close();  //checkstyle violation	
			}
			if(result){
				if(prcInstructionMap!=null && !(prcInstructionMap.isEmpty())){
					String deletePrcInstructions="delete FROM oa_appt_proc_instructions WHERE facility_id='"+facilityId+"' and APPT_REF_NO='"+apptrefnum+"'";
					pstmt = con.prepareStatement( deletePrcInstructions);
					//res_up =pstmt.executeUpdate();
					pstmt.executeUpdate();
					String oa_prc_ins="insert into OA_APPT_PROC_INSTRUCTIONS(INSTRN_SRL_NO,facility_id, appt_ref_no, instruction_desc,added_by_id, added_date,added_facility_id, added_at_ws_no, modified_by_id, modified_date,modified_facility_id, modified_at_ws_no)values(1,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
					String checked=(String)prcInstructionMap.get("checked");
					String prcDesc=(String)prcInstructionMap.get("prcIns");
					if(checked!=null && checked.equals("Y")){
						pstmt = con.prepareStatement( oa_prc_ins);
						pstmt.setString	( 1,  addedFacilityId ) ;
						pstmt.setString	( 2,  apptrefnum ) ;
						pstmt.setString	( 3,  prcDesc ) ;
						pstmt.setString ( 4, p.getProperty( "login_user" ) );
						pstmt.setString	( 5, modifiedFacilityId ) ;
						pstmt.setString	( 6, modifiedAtWorkstation  ) ;
						pstmt.setString	( 7, p.getProperty( "login_user" ) ) ;
						pstmt.setString ( 8, modifiedFacilityId );
						pstmt.setString	( 9, modifiedAtWorkstation ) ;
						//res_up=pstmt.executeUpdate() ;
						pstmt.executeUpdate() ;
					}
				}
				if(pstmt!=null) pstmt.close();  //checkstyle violation	
			}
			//Updation of status in  pr_referral_register as 'C' if refcode exists
			if(result){							
					 if(!(referral_id_old.equals("")) && (refcode!=referral_id_old)){
						 if (pstmt3!=null) pstmt3.close();
						pstmt3 = con.prepareStatement( " update  pr_referral_register set status = 'O' , referred_in_func=null,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where referral_id = ? " );
						pstmt3.setString( 1, p.getProperty( "login_user" )) ;
						pstmt3.setString( 2, modifiedAtWorkstation) ;
						pstmt3.setString( 3, modifiedFacilityId) ;
						pstmt3.setString( 4, referral_id_old) ;
						int ref_cnt =0;
						ref_cnt =pstmt3.executeUpdate();
						if ( ref_cnt != 0 ) {
							result = true ;
						}else{
							sb.append("Transaction Failed in pr_referral_register while updating status as 'O' ");
							con.rollback();
							result = false ;
						}
				 }
				if(!(refcode.equals(""))){
					String refSql=" update  pr_referral_register set status = 'C' , referred_in_func = 1,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where referral_id = ? ";
					if (pstmt3!=null) pstmt3.close();
					pstmt3 = con.prepareStatement( refSql );
					pstmt3.setString( 1, p.getProperty( "login_user" )) ;
					pstmt3.setString( 2, modifiedAtWorkstation) ;
					pstmt3.setString( 3, modifiedFacilityId) ;
					pstmt3.setString( 4, refcode) ;
					int resu1 =0;
					resu1 =pstmt3.executeUpdate();
					if ( resu1 != 0 ) {
						result = true ;
					}else{
						sb.append("Transaction Failed in pr_referral_register update query");
						con.rollback();
						result = false ;
					}
				}  // end of if refcode
			} // end of if result
			/* Added for Billing Interface */
			if(bl_operational.equals("Y") && capture_fin_dtls_yn.equals("Y") && result &&  !(billing_group == null || billing_group.equals(""))){
				try{
					Hashtable hashtableBill = new Hashtable();
					hashtableBill.put("facilityId",addedFacilityId+"");
					hashtableBill.put("bookingrefno",apptrefnum+"");
					hashtableBill.put("admissiondate",apptdate+"");
					hashtableBill.put("addedAtWorkstation",addedAtWorkstation+"");
					hashtableBill.put("P_MODE","I");
					hashtableBill.put("P_PATIENT_ID",patientid+"");
					hashtableBill.put("fin_dtls",fin_dtls);
					hashtableBill.put("P_EPISODE_TYPE",P_EPISODE_TYPE+"");
					hashtableBill.put("addedById",addedById+"");
					hashtableBill.put("function_id",strFunctionId+"");
					hashtableBill.put("locale",locale);
					BLBooking blbkBookPat = new BLBooking();
					Hashtable resultsBL = blbkBookPat.billPatientService(p, con,hashtableBill);
					boolean boolRes = ((Boolean)(resultsBL.get("status"))).booleanValue();
					result = boolRes;
					String strBLMessage = "";
					if (boolRes == false){
						//result  = false;
						result = false;
						strBLMessage = (String) resultsBL.get("error");
						if (strBLMessage != null ){
							if (!strBLMessage.equalsIgnoreCase("null")){
								if(strBLMessage.indexOf("<br>")!=-1){
									strBLMessage = strBLMessage.substring(strBLMessage.indexOf("<br>")+4);
									sb.append(strBLMessage);
								}else{
									sb.append("<u>"+strBLMessage+"</u><br>");
								}
							}
						}
					}
					if (boolRes == true){
						/*strBLMessage = (String) resultsBL.get("message");
						if (strBLMessage != null )
						{
							if (!strBLMessage.equalsIgnoreCase("null"))
							{
								sb.append("<u>"+strBLMessage+"</u><br>");
							}
						}*/
					}
				}catch (Exception exceptionBL){
					result = false;
					//result	  = false;
					sb.append("BILLING UPDATION :"+exceptionBL.toString());
					exceptionBL.printStackTrace();
				}
			}// End of Billing Interface
			if(emailid!=null && !emailid.equals("")){
				try{
					cstmt=con.prepareCall("{call OA_SEND_APPT_MAIL(?,?,?,?,?,?,?,?,?)}");
					cstmt.setString(1,facilityId);
					cstmt.setString(2,"OA");
					cstmt.setString(3,"OAETFAPPT");
					cstmt.setString(4,"P");
					cstmt.setString(5,"");
					cstmt.setString(6,"");
					cstmt.setString(7,apptrefnum);
					cstmt.setString(8,"en");
					cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
					cstmt.execute();
					String mailerror=cstmt.getString(9);
					if(mailerror == null) mailerror="";
					if(mailerror.equals("")){
						result=true;
					}else{
						result=false;
						sb.append("MAIL ID UPDATION :"+mailerror.toString());					}
				}catch(Exception mailex){
						mailex.printStackTrace();
						result=false;
						sb.append("MAIL ID UPDATION :"+mailex.toString());
				}
			}
			if(res_up !=0){
				java.util.Hashtable message = MessageManager.getMessage(locale,"OA_APPT_BOOKED" ,"OA") ;
				String message1 =(String) message.get("message")  ;
				sb.append( message1);
				message.clear();
				result = true ;
				//con.rollback();
				con.commit();
			}else{
				con.rollback();
			}
			// added for checkstyle audit. 
			if(pstmt1 != null) pstmt1.close();
		}catch (Exception e){
			result=false;
			sb.append("ERROR  :"+e.toString());
			e.printStackTrace();
			try{
				con.rollback();
			}catch(Exception es){
				es.printStackTrace();
			}
		}finally{
		  if (con != null){
				 ConnectionManager.returnConnection(con,p);
			}
			try{
				if(Stmt!= null) Stmt.close() ;
				if(pstmt!= null) pstmt.close() ;
				if(pstmt1!= null) pstmt1.close() ;
				if(pstmt3!= null) pstmt3.close() ;
				if(cstmt!= null) cstmt.close() ;
				if(rsds!= null) rsds.close() ;
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}

		String error_msg = sb.toString();

		if(error_msg.contains("Selected slot already booked for a different appointment"))
		{
			java.util.Hashtable message = MessageManager.getMessage(locale,"BOOKED_FOR_DIFF_APPT","OA") ;
			error_msg = (String) message.get("message");
			message.clear();
		}

		results.put( "status", new Boolean(result) ) ;
		// Modified by Muthu on 12/03/2010 Issue :- Records are not getting saved during modify appointment 
		results.put( "error", error_msg) ;
		// End of comment
		return results ;
	}

	//public java.util.HashMap recurringBookAppointment(java.util.Properties p,java.util.HashMap passObjects,Connection con,Connection con1){
	public java.util.HashMap recurringBookAppointment(java.util.Properties p,java.util.HashMap passObjects,Connection con){
		// class level variables are moved. Changed @UAT-3 By Sudhakar Starts
		CallableStatement cstmt = null;
		Statement Stmt = null;
		PreparedStatement pstmt_sql_up11_oa=null;
		PreparedStatement pstmt_sqlds1=null;
		PreparedStatement pstmt_sqlo_one=null;
		PreparedStatement pstmt_sql1_oa_appt=null;
		PreparedStatement pstmt_sql4_oa_clinic_schedule_four=null;
		PreparedStatement pstmt_s66_oa_appt=null;
		PreparedStatement pstmt_chk_overlap1=null;		
		PreparedStatement pstmtrecurr=null;

		//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
		Boolean isSlotStartMidEndAppl = false;
		//Added by Ajay Hatwate for ML-MMOH-CRF-1930
		Boolean isVirtualConsultation = false;
		isVirtualConsultation = eCommon.Common.CommonBean.isSiteSpecific(con, "OP", "VIRTUAL_CONSULTATION");
		String ccNxtOfKinNo = checkForNull((String)passObjects.get("ccNxtOfKinNo"));
		String nxtOfKinNo = checkForNull((String)passObjects.get("nxtOfKinNo"));
		String patCountryCode = checkForNull((String)passObjects.get("patCountryCode"));
		String patTelCode = checkForNull((String)passObjects.get("patTelCode"));
		//End of ML-MMOH-CRF-1930
		
		ResultSet rsds=null;		
		ResultSet rso= null;
		ResultSet rs=null;
		// class level variables are moved. Changed @UAT-3 By Sudhakar Ends
		HashSet tabdata1;
		tabdata1 = new HashSet();
		String facilityId=(String) passObjects.get("addedFacilityId");
		String cliniccode=(String) passObjects.get("cliniccode");
		String practitionerid=(String) passObjects.get("practitionerid");
		String appttime=(String) passObjects.get("appttime");
		String apptdate=(String) passObjects.get("apptdate");
		String patientid=(String) passObjects.get("patientid");
		String prefix=(String) passObjects.get("prefix");
		String firstname=(String) passObjects.get("firstname");
		String secondname=(String) passObjects.get("secondname");
		String thirdname=(String) passObjects.get("thirdname");
		String familyname=(String) passObjects.get("familyname");
		String suffix=(String) passObjects.get("suffix");
		String patientname=(String) passObjects.get("patientname");
		String gender=(String) passObjects.get("gender");
		String dateofbirth=(String) passObjects.get("dateofbirth");
		String nationalidno=(String) passObjects.get("nationalidno");
		String altid1no=(String) passObjects.get("altid1no");
		String apptcode=(String) passObjects.get("apptcode");
		String visitind=(String) passObjects.get("visitind");
		String overbooked=(String) passObjects.get("overbooked");
		String refcode="";
		String contactreason=(String) passObjects.get("contactreason");
		String contactmode=(String) passObjects.get("contactmode");
		String apptrem=(String) passObjects.get("apptrem");
		String restelno=(String) passObjects.get("restelno");
		String othtelno=(String) passObjects.get("othtelno");
		String emailid=(String) passObjects.get("emailid");
		String timetabletype=(String) passObjects.get("timetabletype");
		String alcn_criteria=(String) passObjects.get("alcn_criteria");
		String pat_cat=(String) passObjects.get("pat_cat");
		String nationality_code=(String) passObjects.get("nationality_code");
		String addedFacilityId=(String) passObjects.get("addedFacilityId");
		String addedAtWorkstation=(String) passObjects.get("addedAtWorkstation");
		String ref_priority=(String) passObjects.get("ref_priority");
		String team_id=(String) passObjects.get("team_id");
		String inpatient_yn=(String) passObjects.get("inpatient_yn");
		String altid1typ=(String) passObjects.get("altid1typ");
		String altid1expdt=(String) passObjects.get("altid1expdt");
		String altid2no=(String) passObjects.get("altid2no");
		String altid2typ=(String) passObjects.get("altid2typ");
		String altid2expdt=(String) passObjects.get("altid2expdt");
		String altid3no=(String) passObjects.get("altid3no");
		String altid3typ=(String) passObjects.get("altid3typ");
		String altid3expdt=(String) passObjects.get("altid3expdt");
		String altid4no=(String) passObjects.get("altid4no");
		String altid4typ=(String) passObjects.get("altid4typ");
		String altid4expdt=(String) passObjects.get("altid4expdt");
		String Othaltid1=(String) passObjects.get("Othaltid1");
		String Othaltid1typ=(String) passObjects.get("Othaltid1typ");
		String ethnicGrp=(String) passObjects.get("ethnicGrp");
		String receivingDtTme=(String) passObjects.get("receivingDtTme");
		String forced=(String) passObjects.get("forced");
		String birthPlace=(String) passObjects.get("birthPlace");
		String residency=(String) passObjects.get("residency");
		String status=(String) passObjects.get("status"); 
		String ethnicSbGrp=(String) passObjects.get("ethnicSbGrp");
		String global=(String) passObjects.get("global");
		String res_addr1=(String) passObjects.get("res_addr1");
		String res_addr2=(String) passObjects.get("res_addr2");
		String res_addr3=(String) passObjects.get("res_addr3");
		String res_addr4=(String) passObjects.get("res_addr4");
		String res_town=(String) passObjects.get("res_town");
		String res_area=(String) passObjects.get("res_area");
		String res_postal=(String) passObjects.get("res_postal");
		String res_region=(String) passObjects.get("res_region");
		String res_country=(String) passObjects.get("res_country");
		String mail_addr1=(String) passObjects.get("mail_addr1");
		String mail_addr2=(String) passObjects.get("mail_addr2");
		String mail_addr3=(String) passObjects.get("mail_addr3");
		String mail_addr4=(String) passObjects.get("mail_addr4");
		String mail_town=(String) passObjects.get("mail_town");
		String mail_area=(String) passObjects.get("mail_area");
		String mail_postal=(String) passObjects.get("mail_postal");
		String mail_region=(String) passObjects.get("mail_region");
		String mail_country=(String) passObjects.get("mail_country");
		String birthPlace_desc=(String) passObjects.get("birthPlace_desc");
		String clinic_type=(String) passObjects.get("clinic_type");
		String res_class=(String) passObjects.get("res_class");
		String or_catalogue_code=(String) passObjects.get("or_catalogue_code");
		String recurringdays=(String) passObjects.get("recurringdays");
		String name_prefix_oth_lang=(String) passObjects.get("name_prefix_oth_lang");
		String first_name_oth_lang=(String) passObjects.get("first_name_oth_lang");
		String second_name_oth_lang=(String) passObjects.get("second_name_oth_lang");
		String third_name_oth_lang=(String) passObjects.get("third_name_oth_lang");
		String family_name_oth_lang=(String) passObjects.get("family_name_oth_lang");
		String name_suffix_oth_lang=(String) passObjects.get("name_suffix_oth_lang");
		String patient_name_local_lang=(String) passObjects.get("patient_name_local_lang");
		String capture_fin_dtls_yn=(String) passObjects.get("capture_fin_dtls_yn");
		String billing_group=(String) passObjects.get("billing_group");
		String bl_operational=(String) passObjects.get("bl_operational");
		String P_EPISODE_TYPE=(String) passObjects.get("P_EPISODE_TYPE");
		String sel_service_code=(String) passObjects.get("sel_service_code");
		String speciality_code=(String) passObjects.get("speciality_code");
		String strFunctionId		= "BOOKING";
		/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
		String altAddrLine1		= checkForNull((String)passObjects.get("altAddrLine1"));
		String altAddrLine2		= checkForNull((String)passObjects.get("altAddrLine2"));
		String altAddrLine3		= checkForNull((String)passObjects.get("altAddrLine3"));
		String altAddrLine4		= checkForNull((String)passObjects.get("altAddrLine4"));
		String altAreaCode		= checkForNull((String)passObjects.get("altAreaCode"));
		String altTownCode		= checkForNull((String)passObjects.get("altTownCode"));
		String altPostalCode	= checkForNull((String)passObjects.get("altPostalCode"));
		String altRegionCode	= checkForNull((String)passObjects.get("altRegionCode"));
		String altCountryCode	= checkForNull((String)passObjects.get("altCountryCode"));
		/*End*/
		HashMap	fin_dtls  = (HashMap)passObjects.get("fin_dtls");
		String locale = p.getProperty("LOCALE");
		java.util.HashMap results = new java.util.HashMap() ;
		java.util.ArrayList arrLstrecc=new java.util.ArrayList();
		String recur_wo_sec_res="",resource_criteria="";
		String apptdaterecc="";
		String apptslabfmtimerecc="";
		String apptslabtotimerecc="";
		String no_slotsrecc="";
		String time="";
		//String slot_appt_ctrl =(String) passObjects.get("slot_appt_ctrl"); //Checklist violation
		String errmsg="";
		String newnext_srl_no_str1="";
		String act_alcn_catg_code="";
		boolean result = false ;
		boolean insertable = true ;
		StringBuffer sb = new StringBuffer( "" ) ;
		StringBuffer strbfrsqlrecur= new StringBuffer( "" ) ;
		int max_pat_per_slab=0;
		int Max_OB_possible=0;
		int res2=0;
		int tot_slot_ob=0;
		int tot_slbfrf_ob=0;
		int totaloverbooked=0;
		int totalslotsoverbooked=0;
		// changes start for ML-BRU-SCF-0428 [IN:035167]
		ResultSet rs_recurr=null;
		PreparedStatement pstmt_srl_nosofpr1=null;
		int rec_srl_no=0;
		//end for  35167
		try{
			//con = ConnectionManager.getConnection(p);
			//con.setAutoCommit( false );

			isSlotStartMidEndAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA", "BRU_HEALTH_INTG");//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1

			java.util.StringTokenizer strtkrecc=new java.util.StringTokenizer(recurringdays,"*");
			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = p.getProperty( "login_user" ) ;
			addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String modifiedAtWorkstation = addedAtWorkstation ;
			Stmt = con.createStatement();
			String sql_sec_req  = "select resource_class,resource_type,resource_criteria from op_resource_type_for_appt where facility_id='"+facilityId+"' and visit_type_code='"+apptcode+"' and resource_class !='"+res_class+"'  order by resource_class ";
			
			rs = Stmt.executeQuery(sql_sec_req);
			if(rs !=null ){
				while(rs.next()){
					resource_criteria=rs.getString("resource_criteria");
					if(resource_criteria==null) resource_criteria="N";
					tabdata1.add(resource_criteria);
				}
				
			}if (rs!=null) rs.close();  //Checklist Violation
			if(tabdata1.contains("Y")){
				recur_wo_sec_res="Y";
			}else{
				recur_wo_sec_res="";
			}
			while (strtkrecc.hasMoreElements()){
				String Stringtk1recc=(String) strtkrecc.nextElement();
				java.util.StringTokenizer strtk1recc=new java.util.StringTokenizer(Stringtk1recc,"@");
				String frst_tkn="";
				frst_tkn=(String) strtk1recc.nextElement();
				if(! frst_tkn.equals("N")){
					arrLstrecc.add(frst_tkn );
					Stringtk1recc=(String) strtk1recc.nextElement();
					strtk1recc=new java.util.StringTokenizer(Stringtk1recc," - ");
					arrLstrecc.add((String) strtk1recc.nextElement() );
					arrLstrecc.add((String) strtk1recc.nextElement() );
					arrLstrecc.add((String) strtk1recc.nextElement() );
				}else{
					strtk1recc.nextElement();
				}
			}
			// to get time (execution at 1408)
			final String sqlds1="select get_time_between(to_date(?,' dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi')) tmsc from dual ";
			pstmt_sqlds1=con.prepareStatement(sqlds1);
			// to get Slot_appt_ctrl from oa_param(execution at 1415)
			//String sqlo1="select slot_appt_ctrl from oa_param where module_id='OA'";
			//pstmt_sqlo1=con.prepareStatement(sqlo1);
			// to get total_overbooked,max patient per slab,max over booking (execution at 1434)
			String sqlo_one="";
			if(practitionerid.equals("")){
				sqlo_one="select total_overbooked,total_slots_overbooked,nvl(Max_patients_Per_Slab,0) Max_patients_Per_Slab,nvl(max_over_booking,0) max_over_booking  from oa_clinic_schedule where facility_id=? and clinic_code=? and clinic_date=to_date(?,'dd/mm/yyyy') and practitioner_id is null and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_class+"' and primary_resource_yn='Y'";
			}else{
				sqlo_one="select total_overbooked,total_slots_overbooked,nvl(Max_patients_Per_Slab,0) Max_patients_Per_Slab,nvl(max_over_booking,0) max_over_booking  from oa_clinic_schedule where facility_id=? and clinic_code=? and clinic_date=to_date(?,'dd/mm/yyyy') and practitioner_id =? and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_class+"' and primary_resource_yn='Y'";
			}
			pstmt_sqlo_one=con.prepareStatement(sqlo_one);
			// to check slots concurrency (execution at 1573)
			StringBuffer sql1_oa_appt= new StringBuffer();
			sql1_oa_appt.append("select '1' from oa_appt where ((to_date(?,'HH24:mi')  +(1/(60*24)) between 		to_date(to_char(appt_slab_from_time,'HH24:mi'),'HH24:mi')+(1/(60*24)) and to_date(to_char(appt_slab_to_time,'HH24:mi'),'HH24:mi')) or  	(to_date(?,'HH24:mi')between to_date(to_char(appt_slab_from_time,'HH24:mi'),'HH24:mi')+(1/(60*24))       		and to_date(to_char(appt_slab_to_time,'HH24:mi'),'HH24:mi')) or	(to_date(to_char(APPT_SLAB_FROM_TIME,'hh24:miss'),'hh24:miss') > to_date(?,'hh24:miss') and	to_date(to_char(APPT_SLAB_FROM_TIME,'hh24:miss'),'hh24:miss')< to_date(?,'hh24:miss') 	) ) and practitioner_id=? and clinic_code=?	and facility_id=? and appt_date=to_date(?,'dd/mm/yyyy') and RESOURCE_CLASS='"+res_class+"' and care_locn_type_ind='"+clinic_type+"'");
			pstmt_sql1_oa_appt=con.prepareStatement(sql1_oa_appt.toString());
			// to check slabs concurrency ( execution at 1611)
			StringBuffer s66_oa_appt= new StringBuffer();
			s66_oa_appt.append("select count(appt_ref_no) from oa_appt where to_date(to_char(appt_slab_from_time,'HH24:mi'),'HH24:mi') = to_date(?,'HH24:mi') and to_date(to_char(appt_slab_to_time,'HH24:mi'),'HH24:mi') = to_date(?,'HH24:mi') and clinic_code = ? and appt_date = to_date(?,'dd/mm/yyyy') and nvl(practitioner_id,'x') =nvl(?,'x') and facility_id = ? and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_class+"' ");

			pstmt_s66_oa_appt = con.prepareStatement(s66_oa_appt.toString());
			// to check concurrency for a particular patient id (ie to chk if he has an appt on the same date at same time (execution at 1651)
			String chk_overlap1= "select '1'  from oa_appt where facility_id='"+addedFacilityId+"' and ((to_date(?,'HH24:mi')  +(1/(60*24)) between to_date(to_char(appt_slab_from_time,'HH24:mi'),'HH24:mi')+(1/(60*24)) and to_date(to_char(appt_slab_to_time,'HH24:mi'),'HH24:mi')) or(to_date(?,'HH24:mi') between  		to_date(to_char(appt_slab_from_time,'HH24:mi'),'HH24:mi')+(1/(60*24)) and to_date(to_char(appt_slab_to_time,'HH24:mi'),'HH24:mi')) or 			(to_date(to_char(APPT_SLAB_FROM_TIME,'hh24:miss'),'hh24:miss') > to_date(?,'hh24:miss')  and	to_date(to_char(APPT_SLAB_FROM_TIME,'hh24:miss'),'hh24:miss') < to_date(?,'hh24:miss'))) and appt_date = to_date(?,'dd/mm/yyyy') 	and patient_id='"+patientid+"'	and CARE_LOCN_TYPE_IND='"+clinic_type+"'";

			pstmt_chk_overlap1 = con.prepareStatement(chk_overlap1);
			// Insertion of values into oa_appt table(execution at 1651)
			strbfrsqlrecur.append(" insert into  oa_appt(facility_id,appt_ref_no, clinic_code,practitioner_id,appt_date,appt_time,appt_slab_from_time,appt_slab_to_time,appt_duration,appt_slots,patient_id,name_prefix,first_name,second_name,third_name,family_name,name_suffix, patient_name,gender,date_of_birth,res_tel_no, oth_contact_no,email_id,national_id_no, alt_id1_no,res_addr_line1, res_addr_line2,res_addr_line3, res_addr_line4,postal_code, country_code,alcn_criteria,alcn_catg_code,appt_type_code, overbooked_yn,referral_id, contact_reason_code, mode_of_contact, appt_remarks,appt_status, inpatient_yn,added_by_id,  added_date,added_facility_id, added_at_ws_no,modified_by_id,  modified_date,modified_facility_id, modified_at_ws_no, pat_alcn_catg_code,referral_priority,NO_OF_SLOTS,team_id,speciality_code");
			if(!altid1expdt.equals("N"))
			strbfrsqlrecur.append(",ALT_ID1_EXP_DATE");
			if(!altid2expdt.equals("N"))
			strbfrsqlrecur.append(",ALT_ID2_EXP_DATE");
			if(!altid3expdt.equals("N"))
			strbfrsqlrecur.append(",ALT_ID3_EXP_DATE");
			if(!altid4expdt.equals("N"))
			strbfrsqlrecur.append(",ALT_ID4_EXP_DATE");
			if(!receivingDtTme.equals("N"))
			strbfrsqlrecur.append(",RECEIVING_DATE_TIME");
			strbfrsqlrecur.append(",ALT_ID1_TYPE,ALT_ID2_NO,ALT_ID2_TYPE,ALT_ID3_NO,ALT_ID3_TYPE,ALT_ID4_NO,ALT_ID4_TYPE,OTH_ALT_ID_NO,OTH_ALT_ID_TYPE,ETHNIC_GROUP_CODE,FORCED_APPT_YN,BIRTH_PLACE_CODE,CITIZEN_YN,LEGAL_YN,RACE_CODE,GLOBAL_APPT_YN,RES_AREA_CODE,RES_TOWN_CODE,RES_REGION_CODE,MAIL_ADDR_LINE1,MAIL_ADDR_LINE2,MAIL_ADDR_LINE3,MAIL_ADDR_LINE4,MAIL_AREA_CODE,MAIL_TOWN_CODE,MAIL_REGION_CODE,MAIL_POSTAL_CODE,MAIL_COUNTRY_CODE,RES_COUNTRY_CODE,alt_addr_line1,alt_addr_line2,alt_addr_line3,alt_addr_line4,alt_area_code,alt_town_code,alt_region_code,alt_postal_code,alt_country_code,BIRTH_PLACE_DESC,CARE_LOCN_TYPE_IND,RESOURCE_CLASS,NAME_PREFIX_LOC_LANG,FIRST_NAME_LOC_LANG,SECOND_NAME_LOC_LANG,THIRD_NAME_LOC_LANG,FAMILY_NAME_LOC_LANG,NAME_SUFFIX_LOC_LANG,PATIENT_NAME_LOC_LANG");//Modified by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601
			if(!or_catalogue_code.equals(""))
			strbfrsqlrecur.append(",ORDER_CATALOG_CODE");
			if(!recur_wo_sec_res.equals(""))
			strbfrsqlrecur.append(",recur_wo_sec_res");
			if(!sel_service_code.equals(""))
			strbfrsqlrecur.append(",service_code");
			strbfrsqlrecur.append(",TIME_TABLE_TYPE");
			if(res_postal== null ) res_postal="";
			if(nationality_code== null ) nationality_code="";
		if(isVirtualConsultation){
			strbfrsqlrecur.append(", CONTACT1_MOB_TEL_NO, CONTACT1_MOB_COUNTRY_CODE, contact2_telephone_code, contact2_country_code ");
		}
			strbfrsqlrecur.append(" ) values ('"+addedFacilityId+"',?,'"+cliniccode+"','"+practitionerid+"',to_date(?,'dd/mm/yyyy'),to_date('"+appttime+"','hh24:mi'),to_date(?,'hh24:mi'),to_date(?,'hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),'','"+patientid+"', ?, ?, ?,?,?, ?,?,'"+gender+"', to_date('"+dateofbirth+"','dd/mm/yyyy'),'"+restelno+"', '"+othtelno+"', '"+emailid+"','"+nationalidno+"', '"+altid1no+"','"+res_addr1+"', '"+res_addr2+"', '"+res_addr3+"', '"+res_addr4+"', '"+res_postal+"', '"+nationality_code+"', '"+alcn_criteria+"','"+act_alcn_catg_code+"','"+apptcode+"','"+overbooked+"','"+refcode+"','"+contactreason+"', '"+contactmode+"', '"+apptrem+"', '1','"+inpatient_yn+"','"+addedById+"',sysdate,'"+addedFacilityId+"','"+addedAtWorkstation+"','"+modifiedById+"',sysdate,'"+modifiedFacilityId+"','"+modifiedAtWorkstation+"','"+pat_cat+"','"+ref_priority+"',?,'"+team_id+"','"+speciality_code+"'");
			if(!altid1expdt.equals("N"))
			strbfrsqlrecur.append(",to_date('"+altid1expdt+"','dd/mm/yyyy') ");
			if(!altid2expdt.equals("N"))
			strbfrsqlrecur.append(",to_date('"+altid2expdt+"','dd/mm/yyyy') ");
			if(!altid3expdt.equals("N"))
			strbfrsqlrecur.append(",to_date('"+altid3expdt+"','dd/mm/yyyy') ");
			if(!altid4expdt.equals("N"))
			strbfrsqlrecur.append(",to_date('"+altid4expdt+"','dd/mm/yyyy') ");
			if(!receivingDtTme.equals("N"))
			strbfrsqlrecur.append(",to_date('"+receivingDtTme+"','dd/mm/yyyy hh24:mi') ");
			strbfrsqlrecur.append(",'"+altid1typ+"','"+altid2no+"','"+altid2typ+"','"+altid3no+"','"+altid3typ+"','"+altid4no+"','"+altid4typ+"','"+Othaltid1+"','"+Othaltid1typ+"','"+ethnicGrp+"','"+forced+"','"+birthPlace+"','"+residency+"','"+status+"','"+ethnicSbGrp+"','"+global+"','"+res_area+"','"+res_town+"','"+res_region+"','"+mail_addr1+"','"+mail_addr2+"','"+mail_addr3+"','"+mail_addr4+"','"+mail_area+"','"+mail_town+"','"+mail_region+"','"+mail_postal+"','"+mail_country+"','"+res_country+"','"+altAddrLine1+"','"+altAddrLine2+"','"+altAddrLine3+"','"+altAddrLine4+"','"+altAreaCode+"','"+altTownCode+"','"+altRegionCode+"','"+altPostalCode+"','"+altCountryCode+"','"+birthPlace_desc+"','"+clinic_type+"','"+res_class+"',?,?,?,?,?,?,?");//Modified by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601
			if(!or_catalogue_code.equals(""))
			strbfrsqlrecur.append(",'"+or_catalogue_code+"'");
			if(!recur_wo_sec_res.equals(""))
			strbfrsqlrecur.append(",'"+recur_wo_sec_res+"'");
			if(!sel_service_code.equals(""))
			strbfrsqlrecur.append(",'"+sel_service_code+"'");
			strbfrsqlrecur.append(",?") ;
			if(isVirtualConsultation){
				strbfrsqlrecur.append(",'"+nxtOfKinNo+"', '"+ccNxtOfKinNo+"', '"+patTelCode+"', '"+patCountryCode+"' )") ;	
			}else{
				strbfrsqlrecur.append(")");
			}
			pstmtrecurr = con.prepareStatement( strbfrsqlrecur.toString() );
			// changes start for ML-BRU-SCF-0428 [IN:035167]
			
			//Modified by Ashwini on 03-Aug-2021 for KDAH-CRF-0579.1  -- put old status change back. failure in a slab for same slot
			StringBuffer srl_nosofpr1 = new StringBuffer();

			if(isSlotStartMidEndAppl && timetabletype.equals("2") && max_pat_per_slab > 1)
			{
				srl_nosofpr1.append("select srl_no,to_char(slot_slab_start_time,'hh24:mi') stt from oa_clinic_schedule_slot_slab where clinic_code='"+cliniccode+"' and facility_id='"+addedFacilityId+"' and nvl(practitioner_id,'x')=nvl('"+practitionerid+"','x') and trunc(clinic_date)=to_date(?,'dd/mm/yyyy') and schedule_status is null and resource_class='"+res_class+"' and care_locn_type_ind='"+clinic_type+"' and to_date(to_char(slot_slab_start_time,'hh24:mi'),'hh24:mi') >=to_date(?,'hh24:mi') and to_date(to_char(slot_slab_end_time,'hh24:mi'),'hh24:mi')<=to_date(?,'hh24:mi') and (ext_slot_yn <> 'Y'or ext_slot_yn is null) order by srl_no");
			}else
			{
				srl_nosofpr1.append("select srl_no,to_char(slot_slab_start_time,'hh24:mi') stt from oa_clinic_schedule_slot_slab where clinic_code='"+cliniccode+"' and facility_id='"+addedFacilityId+"' and nvl(practitioner_id,'x')=nvl('"+practitionerid+"','x') and trunc(clinic_date)=to_date(?,'dd/mm/yyyy') and schedule_status is null and resource_class='"+res_class+"' and care_locn_type_ind='"+clinic_type+"' and to_date(to_char(slot_slab_start_time,'hh24:mi'),'hh24:mi') >=to_date(?,'hh24:mi') and to_date(to_char(slot_slab_end_time,'hh24:mi'),'hh24:mi')<=to_date(?,'hh24:mi') order by srl_no");
			}

			/*StringBuffer srl_nosofpr1=new StringBuffer("select srl_no,to_char(slot_slab_start_time,'hh24:mi') stt from oa_clinic_schedule_slot_slab where clinic_code='"+cliniccode+"' and facility_id='"+addedFacilityId+"' and nvl(practitioner_id,'x')=nvl('"+practitionerid+"','x') and trunc(clinic_date)=to_date(?,'dd/mm/yyyy') and resource_class='"+res_class+"' and care_locn_type_ind='"+clinic_type+"' and to_date(to_char(slot_slab_start_time,'hh24:mi'),'hh24:mi') >=to_date(?,'hh24:mi') and to_date(to_char(slot_slab_end_time,'hh24:mi'),'hh24:mi')<=to_date(?,'hh24:mi') order by srl_no");*/

			pstmt_srl_nosofpr1=con.prepareStatement(srl_nosofpr1.toString());
			srl_nosofpr1.setLength(0);
          // end for 35167
			StringBuffer sql_up11_oa=new StringBuffer("update oa_clinic_schedule_slot_slab set schedule_status='1',pri_appt_ref_no=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where clinic_code='"+cliniccode+"' and facility_id= '"+addedFacilityId+"' ");
			if(practitionerid.equals("")){
				sql_up11_oa.append("and practitioner_id is null ");
			}else{
				sql_up11_oa.append(" and practitioner_id like upper('"+practitionerid+"') ");
			}
			sql_up11_oa.append(" and clinic_date=to_date(?,'dd/mm/yyyy') and resource_class='"+res_class+"' and care_locn_type_ind='"+clinic_type+"'  and to_date(to_char(slot_slab_start_time,'hh24:mi'),'hh24:mi') >=to_date(?,'hh24:mi') and to_date(to_char(slot_slab_end_time,'hh24:mi'),'hh24:mi')<=to_date(?,'hh24:mi') and srl_no=? "); //modified for 35167
			pstmt_sql_up11_oa = con.prepareStatement(sql_up11_oa.toString());
			sql_up11_oa.setLength(0);
			// updation of oa_clinic_schedule
			StringBuffer sql4_oa_clinic_schedule_four =new StringBuffer();
			sql4_oa_clinic_schedule_four.append(" update oa_clinic_schedule set  total_slots_booked  = nvl(total_slots_booked,0)+1,");
			if(!global.equals("N")){
				sql4_oa_clinic_schedule_four.append("TOTAL_GLOBAL_BOOKED=nvl(TOTAL_GLOBAL_BOOKED,0) +1 , ");
			}
			sql4_oa_clinic_schedule_four.append("total_first_visit=nvl(total_first_visit,0)+decode('"+visitind+"','F',1,0),total_first_visit_slots_booked=nvl(total_first_visit_slots_booked,0)+decode('"+visitind+"','F',1,0),total_follow_up=nvl(total_follow_up,0)+decode('"+visitind+"','L',1,0),total_routine=nvl(total_routine,0)+decode('"+visitind+"','R',1,0),total_series=nvl(total_series,0)+decode('"+visitind+"','S',1,0),total_consult=nvl(total_consult,0)+decode('"+visitind+"','C',1,0),total_emergency=nvl(total_emergency,0)+decode('"+visitind+"','E',1,0),MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where facility_id = ? and clinic_code=? and clinic_date= to_date(?,'DD/MM/YYYY') and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_class+"' and primary_resource_yn='Y'");
			if(practitionerid.equals("")){
				sql4_oa_clinic_schedule_four.append(" and practitioner_id is null ");
			}else{
				sql4_oa_clinic_schedule_four.append(" and practitioner_id = ? ");
			}
			pstmt_sql4_oa_clinic_schedule_four = con.prepareStatement( sql4_oa_clinic_schedule_four.toString() );
			
			//recurloop: for (int varLstCntr=0;varLstCntr<arrLstrecc.size() ;varLstCntr+=4 ){
				int cnt=0;
			for (int varLstCntr=0;varLstCntr<arrLstrecc.size() ;varLstCntr+=4 ){
				cnt++;
				apptdaterecc=(String) arrLstrecc.get(varLstCntr);
				apptslabfmtimerecc=(String) arrLstrecc.get(varLstCntr+1);
				apptslabtotimerecc=(String) arrLstrecc.get(varLstCntr+2);
				no_slotsrecc=(String) arrLstrecc.get(varLstCntr+3);
				//newnext_srl_no_str1=String.valueOf(newnext_srl_no);
				if(forced.equals("Y"))
				overbooked="N";
				totaloverbooked=0;
				totalslotsoverbooked=0;
				if (no_slotsrecc==""||no_slotsrecc.equals("")) no_slotsrecc="0";
				int no_slots_value_recc=Integer.parseInt(no_slotsrecc);
				// to get time
				pstmt_sqlds1.setString(1, apptdaterecc+" "+apptslabtotimerecc);
				pstmt_sqlds1.setString(2, apptdaterecc+" "+apptslabfmtimerecc);
				rsds=pstmt_sqlds1.executeQuery();
				if(rsds !=null && rsds.next()){
					time=rsds.getString("tmsc");
					time=apptdate+" "+time;
				}
				//if (rsds!=null) rsds.close();
				// to get Slot_appt_ctrl from oa_param
				/*rso=pstmt_sqlo1.executeQuery();
				if (rso!=null && rso.next()){
					slot_appt_ctrl=rso.getString("slot_appt_ctrl");
				}*/
				max_pat_per_slab=0;
				Max_OB_possible=0;
				tot_slot_ob=0;
				tot_slbfrf_ob=0;
				// to get total_overbooked,max patient per slab,max over booking
				pstmt_sqlo_one.setString(1, addedFacilityId);
				pstmt_sqlo_one.setString(2, cliniccode);
				pstmt_sqlo_one.setString(3, apptdaterecc);
				if(!practitionerid.equals("")){
					pstmt_sqlo_one.setString(4, practitionerid);
				}
				rso=pstmt_sqlo_one.executeQuery();
				if(rso !=null && rso.next()){
					totaloverbooked=rso.getInt("total_overbooked");
					totalslotsoverbooked=rso.getInt("total_slots_overbooked");
					max_pat_per_slab = rso.getInt("Max_patients_Per_Slab");
					Max_OB_possible=rso.getInt("max_over_booking");
				}if(rso!=null) rso.close();  //Checklist Violation
				tot_slot_ob=totalslotsoverbooked;
				tot_slbfrf_ob=totaloverbooked;
				totaloverbooked=totaloverbooked+1;
				totalslotsoverbooked=totalslotsoverbooked+1;
				result=false;
				if(! overbooked.equals("Y")){
					// checking for slot concurrency
					if(! timetabletype.equals("2")){
						pstmt_sql1_oa_appt.setString(1, apptslabfmtimerecc) ;
						pstmt_sql1_oa_appt.setString(2, apptslabtotimerecc);
						pstmt_sql1_oa_appt.setString(3, apptslabfmtimerecc) ;
						pstmt_sql1_oa_appt.setString(4, apptslabtotimerecc);
						pstmt_sql1_oa_appt.setString(5, practitionerid);
						pstmt_sql1_oa_appt.setString(6, cliniccode) ;
						pstmt_sql1_oa_appt.setString(7, addedFacilityId);
						pstmt_sql1_oa_appt.setString(8, apptdaterecc) ;

						rs=pstmt_sql1_oa_appt.executeQuery();
						sql1_oa_appt.setLength(0);
						if (rs.next() && rs != null){
							insertable = false;
							java.util.Hashtable message = MessageManager.getMessage( locale,"APPT_OVERLAP","OA") ;
							sb.append( (String) message.get("message") ) ;
							message.clear();
							//con.rollback();
							//break recurloop;
							break;
						}else{
							insertable = true;
						}
					if(rs!=null) rs.close(); //checklist violation	
					}else{ // to check slabs concurrency
						pstmt_s66_oa_appt.setString(1, apptslabfmtimerecc);
						pstmt_s66_oa_appt.setString(2, apptslabtotimerecc);
						pstmt_s66_oa_appt.setString(3, cliniccode);
						pstmt_s66_oa_appt.setString(4, apptdaterecc);
						pstmt_s66_oa_appt.setString(5, practitionerid);
						pstmt_s66_oa_appt.setString(6, addedFacilityId);

						rs = pstmt_s66_oa_appt.executeQuery();
						s66_oa_appt.setLength(0);
						int i3=0;
						if(rs.next() && rs != null){
							i3 = rs.getInt(1);
							if(i3 < max_pat_per_slab){
								insertable = true;
							}else{
								insertable = false;
								java.util.Hashtable message = MessageManager.getMessage( locale,"APPT_OVERLAP","OA" ) ;
								sb.append( (String) message.get("message") ) ;
								message.clear();
								//con.rollback();
								//break recurloop;
								break;
							}
						}
						if(insertable){
							// to check concurrency for a  particular patient
							if(!patientid.equals("")){
								pstmt_chk_overlap1.setString(1,apptslabfmtimerecc);
								pstmt_chk_overlap1.setString(2,apptslabtotimerecc);
								pstmt_chk_overlap1.setString(3,apptslabfmtimerecc);
								pstmt_chk_overlap1.setString(4,apptslabtotimerecc);
								pstmt_chk_overlap1.setString(5,apptdaterecc);
								rs = pstmt_chk_overlap1.executeQuery() ;
								if(rs !=null){
									if(rs.next()){
										insertable = false;
										java.util.Hashtable message = MessageManager.getMessage( locale,"APPT_OVERLAP","OA") ;
										sb.append( (String) message.get("message") ) ;
										message.clear();
										//con.rollback();
										//break recurloop;
										break;
									}else{
										insertable = true;
									}
								}
							}// end if patient id
						} // end if insertable
					} //end of slabs concurrency
				}
				//	OA_GENERATE_APPT_ID Procedure being called where chk for the max serial num chk is done and updation of the OA_APPT_SRL_NO is done
				try{
					//cstmt=con1.prepareCall("{call OA_GENERATE_APPT_ID(?,?,?,?,?,?)}");
					cstmt=con.prepareCall("{call OA_GENERATE_APPT_ID(?,?,?,?,?,?)}");
					cstmt.setString(1,addedFacilityId);
					cstmt.setString(2,addedById);
					cstmt.setString(3,addedAtWorkstation);
					cstmt.registerOutParameter(4,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(5,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
					cstmt.execute();
					errmsg=cstmt.getString(6);
					//con1.commit();
					if(errmsg == null) errmsg="";
					if(errmsg.equals("")){
						newnext_srl_no_str1=cstmt.getString(4);
						insertable=true;
					 }else{
						 insertable=false;
						 sb.append(errmsg);
					 }
					if(cstmt != null) cstmt.close();
				}catch(Exception e){
					 insertable=false;
					 e.printStackTrace();
				}
				if ( insertable ){
					//OA_APPT table insertion
					pstmtrecurr.setString(1,newnext_srl_no_str1);
					pstmtrecurr.setString(2,apptdaterecc);
					pstmtrecurr.setString(3,apptslabfmtimerecc);
					pstmtrecurr.setString(4,apptslabtotimerecc);
					pstmtrecurr.setString(5,time);
					pstmtrecurr.setString(6,prefix);
					pstmtrecurr.setString(7,firstname);
					pstmtrecurr.setString(8,secondname);
					pstmtrecurr.setString(9,thirdname);
					pstmtrecurr.setString(10,familyname);
					pstmtrecurr.setString(11,suffix);
					pstmtrecurr.setString(12,patientname);
					pstmtrecurr.setInt(13,no_slots_value_recc);
					pstmtrecurr.setString( 14, name_prefix_oth_lang);
					pstmtrecurr.setString( 15, first_name_oth_lang);
					pstmtrecurr.setString( 16, second_name_oth_lang);
					pstmtrecurr.setString( 17, third_name_oth_lang);
					pstmtrecurr.setString( 18, family_name_oth_lang);
					pstmtrecurr.setString( 19, name_suffix_oth_lang);
					pstmtrecurr.setString( 20, patient_name_local_lang);
					pstmtrecurr.setString( 21, timetabletype);
					int resu_reccr=0;
					resu_reccr = pstmtrecurr.executeUpdate() ;
					strbfrsqlrecur.setLength(0);
					if(resu_reccr>0){
						result=true;
					}else{
						result=false;
						sb.append("Transaction Failed recurring");
						//con.rollback();
					}
					// srl no and start time is taken from oa_clinic_schedule_slot_slab and later used in the where clause of the updation of the same table
					//	String srl_nos="";
					if ( result ){
						if(forced.equals("N") && overbooked.equals("N")){
						   // Added for ML-BRU-SCF-0428 [IN:035167]
							pstmt_srl_nosofpr1.setString(1,apptdaterecc);
							pstmt_srl_nosofpr1.setString(2,apptslabfmtimerecc);
							pstmt_srl_nosofpr1.setString(3,apptslabtotimerecc);

							rs_recurr=pstmt_srl_nosofpr1.executeQuery();
							rec_srl_no=0;
							if(rs_recurr !=null && rs_recurr.next()){
								rec_srl_no=rs_recurr.getInt("srl_no");
								
							} // end 35167
							pstmt_sql_up11_oa.setString(1,newnext_srl_no_str1);
							pstmt_sql_up11_oa.setString(2,modifiedById);
							pstmt_sql_up11_oa.setString(3,modifiedAtWorkstation);
							pstmt_sql_up11_oa.setString(4,modifiedFacilityId);
							pstmt_sql_up11_oa.setString(5,apptdaterecc);
							pstmt_sql_up11_oa.setString(6,apptslabfmtimerecc);
							pstmt_sql_up11_oa.setString(7,apptslabtotimerecc);
							pstmt_sql_up11_oa.setInt(8,rec_srl_no);   // Added for ML-BRU-SCF-0428 [IN:035167]
							int	res_up1=0;
							res_up1 =pstmt_sql_up11_oa.executeUpdate();
							if(res_up1 > 0){
								result = true ;
							}else{
								result = false ;
								sb.append("Transaction Failed oa_clinic_schedule_slot_slab for Primary Resources ");
								//con.rollback();
								//break recurloop;
								break;
							}
						} // freeformat check
					}// forced check
					//Updation of oa_clinic_schedule
					if(result){
						if(overbooked.equals("N") && forced.equals("N")){
							pstmt_sql4_oa_clinic_schedule_four.setString( 1,modifiedById);
							pstmt_sql4_oa_clinic_schedule_four.setString( 2,modifiedAtWorkstation);
							pstmt_sql4_oa_clinic_schedule_four.setString( 3,modifiedFacilityId);
							pstmt_sql4_oa_clinic_schedule_four.setString( 4,addedFacilityId ) ;
							pstmt_sql4_oa_clinic_schedule_four.setString( 5,cliniccode ) ;
							pstmt_sql4_oa_clinic_schedule_four.setString( 6,apptdaterecc ) ;
							if(!practitionerid.equals("")){
								pstmt_sql4_oa_clinic_schedule_four.setString( 7, practitionerid ) ;
							}
							res2=0;
							res2 =pstmt_sql4_oa_clinic_schedule_four.executeUpdate();
						}
						if ( res2 != 0 ) {
							result = true ;
						}else{
							sb.append("Transaction Failed in oa_clinic_schedule update query");
							//con.rollback();
							result = false ;
							//break recurloop;
							break;
						}
					}
					if(bl_operational.equals("Y") && capture_fin_dtls_yn.equals("Y") && result &&  !(billing_group == null || billing_group.equals(""))){
						try{

							Hashtable hashtableBill = new Hashtable();
							hashtableBill.put("facilityId",addedFacilityId+"");
							hashtableBill.put("bookingrefno",newnext_srl_no_str1+"");
							hashtableBill.put("admissiondate",apptdaterecc+"");
							hashtableBill.put("addedAtWorkstation",addedAtWorkstation+"");
							hashtableBill.put("P_MODE","I");
							hashtableBill.put("P_PATIENT_ID",patientid+"");
							hashtableBill.put("fin_dtls",fin_dtls);
							hashtableBill.put("P_EPISODE_TYPE",P_EPISODE_TYPE+"");
							hashtableBill.put("addedById",addedById+"");
							hashtableBill.put("function_id",strFunctionId+"");
							hashtableBill.put("locale",locale);
							BLBooking blbkBookPat = new BLBooking();
							Hashtable resultsBL = blbkBookPat.billPatientService(p, con,hashtableBill);
							boolean boolRes = ((Boolean)(resultsBL.get("status"))).booleanValue();
							result = boolRes;
							String strBLMessage = "";
							if (boolRes == false){
								//result  = false;
								result = false;
								strBLMessage = (String) resultsBL.get("error");
								if (strBLMessage != null ){
									if (!strBLMessage.equalsIgnoreCase("null")){
										if(strBLMessage.indexOf("<br>")!=-1){
											strBLMessage = strBLMessage.substring(strBLMessage.indexOf("<br>")+4);
											sb.append(strBLMessage);
										}else{
											sb.append("<u>"+strBLMessage+"</u><br>");
										}
									}
								}
							}

							if (boolRes == true){
								/*strBLMessage = (String) resultsBL.get("message");
								if (strBLMessage != null )
								{
									if (!strBLMessage.equalsIgnoreCase("null"))
									{
										sb.append("<u>"+strBLMessage+"</u><br>");
									}
								}*/
							}
							 /* CheckStyle correction  added by Munisekhar */
						if(rs_recurr != null) rs_recurr.close();	
						}catch (Exception exceptionBL){
							result = false;
							//result	  = false;
							sb.append("BILLING UPDATION :"+exceptionBL.toString());
							exceptionBL.printStackTrace();
						}
					}// End of Billing Interface
					if(!result){
						result=false;
						sb.append("Transaction Failed");
						//con.rollback();
						//break recurloop;
						break;
					}
				}else{ // else part of insertable
					result=false;
					sb.append("Transaction Failed in oa_appt insert query");
					//con.rollback();
					//break recurloop;
					break;
				}
			}
			if(result){
				//con.commit();
			}else{
				sb.append("Transaction Failed");
				//con.rollback();
			}
			arrLstrecc.clear();
			tabdata1.clear();
		}catch (Exception e){
			e.printStackTrace();
			result=false;
			sb.append("ERROR  :"+e.toString());
			try{
			//con.rollback();
			}catch(Exception es){
				es.printStackTrace();
			}
		}finally{
			/*if (con1 != null){
				ConnectionManager.returnConnection(con1,p);
			}*/
			try{
				if(cstmt!= null) cstmt.close() ;
				if(Stmt!= null) Stmt.close() ;
				if(pstmt_sql_up11_oa!= null) pstmt_sql_up11_oa.close() ;
				if(pstmt_sqlds1!= null) pstmt_sqlds1.close() ;
				if(pstmt_sqlo_one!= null) pstmt_sqlo_one.close() ;
				if(pstmt_sql1_oa_appt!= null) pstmt_sql1_oa_appt.close() ;
				if(pstmt_sql4_oa_clinic_schedule_four!= null) pstmt_sql4_oa_clinic_schedule_four.close() ;
				if(pstmt_s66_oa_appt!= null) pstmt_s66_oa_appt.close() ;
				if(pstmt_chk_overlap1!= null) pstmt_chk_overlap1.close() ;
				if(pstmtrecurr!= null) pstmtrecurr.close() ;
				if(rsds!= null) rsds.close() ;				
				if(rso!= null) rso.close() ;
				if(rs!= null) rs.close() ;
				// Added for ML-BRU-SCF-0428 [IN:035167]
				if (rs_recurr !=null) rs_recurr.close();
				if (pstmt_srl_nosofpr1!=null) pstmt_srl_nosofpr1.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		results.put( "status", new Boolean(result) ) ;
		return results ;
	}

/**
* @ejb.interface-method
*	 view-type="both"
*/
	public java.util.HashMap linkSecAppointment(java.util.Properties p,java.util.HashMap passObjects){
		// class level variables are moved. Changed @UAT-3 By Sudhakar Starts
		PreparedStatement pstmt3= null;
		Connection con=null;
		ResultSet rsds=null;
		PreparedStatement pstmt_sqlmaxSec=null,pstmt1_sqldssec_rec=null,pstmt1_sql_sec_stat_rec=null,pstmt1_sql_upop_rec=null,pstmt1_sql_upop_rec_2=null,pstmt1_sql_sec_rstyp1 =null,pstmt1_sql_sec_rstyp2 =null,pstmt1_sql_sec_rstyp3 =null,pstmt_oa_resource_for_appt_1=null;
		// class level variables are moved. Changed @UAT-3 By Sudhakar Ends
		String addedAtWorkstation=(String) passObjects.get("addedAtWorkstation");
		String facilityId=(String) passObjects.get("addedFacilityId");
		String appt_ref_no=(String) passObjects.get("rec_appt_ref_no");
		String visitind=(String) passObjects.get("visitind");
		String clinic_type=(String) passObjects.get("clinic_type_pr");
		java.util.ArrayList sec_resources=(java.util.ArrayList) passObjects.get("sec_reourses");
		java.util.HashMap results = new java.util.HashMap() ;
		String addedById = p.getProperty( "login_user" ) ;
		String modifiedById = p.getProperty( "login_user" ) ;
		String addedFacilityId=facilityId;
		String modifiedFacilityId = addedFacilityId ;
		String modifiedAtWorkstation = addedAtWorkstation ;
		String locale = p.getProperty("LOCALE");
		String disp_appt_ref_no="";
		int res_up=0,resu=0;		
		con = ConnectionManager.getConnection(p);
		boolean result = false ;
		StringBuffer sb = new StringBuffer( "" ) ;
		try{
			con.setAutoCommit( false );
			final String sqlmaxSec="select nvl(max(srl_no),1) srl_no from oa_resource_for_appt where facility_id=? and appt_ref_no=?";
			pstmt_sqlmaxSec=con.prepareStatement(sqlmaxSec);
			final String sqldssec_rec="select get_time_between(to_date(?,' dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi')) tmsc from dual ";
			pstmt1_sqldssec_rec=con.prepareStatement(sqldssec_rec);
			String sql_sec_rstyp1="",sql_sec_rstyp2="",sql_sec_rstyp3="";
			sql_sec_rstyp1="select pract_type res_type from am_practitioner where nvl(practitioner_id,'x')=nvl(?,'x')";
			sql_sec_rstyp2="select room_type res_type from am_facility_room where nvl(room_num,'x')=nvl(?,'x') and OPERATING_FACILITY_ID='"+addedFacilityId+"'" ;
			sql_sec_rstyp3="select resource_type res_type from am_resource where nvl(resource_id,'x')=nvl(?,'x') and facility_id= '"+addedFacilityId+"' and resource_Class=?" ;
			pstmt1_sql_sec_rstyp1 = con.prepareStatement(sql_sec_rstyp1 );
			pstmt1_sql_sec_rstyp2 = con.prepareStatement(sql_sec_rstyp2 );
			pstmt1_sql_sec_rstyp3 = con.prepareStatement(sql_sec_rstyp3 );
			/*String sql_upd_oaclinic_sch1="	UPDATE  OA_CLINIC_SCHEDULE A SET  (MIN_SLOT_SLAB_START_TIME,MIN_SLOT_SLAB_END_TIME) = (SELECT MIN(SLOT_SLAB_START_TIME),MIN(SLOT_SLAB_END_TIME) FROM OA_CLINIC_SCHEDULE_SLOT_SLAB WHERE  FACILITY_ID = ? AND    CLINIC_CODE = ? AND    CLINIC_DATE = to_date(?,'DD/MM/YYYY') AND    (PRACTITIONER_ID = ? or (PRACTITIONER_ID is null and ? is null)) AND  SCHEDULE_STATUS IS NULL) WHERE	FACILITY_ID = ? AND   CLINIC_CODE = ? AND    CLINIC_DATE = to_date(?,'DD/MM/YYYY') AND (PRACTITIONER_ID = ? or (PRACTITIONER_ID is null and ? is null)) ";
			pstmt1_sql_upd_oaclinic_sch1=con.prepareStatement(sql_upd_oaclinic_sch1);
			*/
			String sql_upop_rec=" update oa_clinic_schedule_slot_slab set schedule_status='1',pri_appt_ref_no=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where clinic_code=? and facility_id=? and clinic_date=to_date(?,'dd/mm/yyyy') and practitioner_id =? and resource_class=? and care_locn_type_ind=? and srl_no =? ";
			String sql_upop_rec_2=" update oa_clinic_schedule_slot_slab set schedule_status='1',pri_appt_ref_no=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where clinic_code=? and facility_id=? and practitioner_id is null and clinic_date=to_date(?,'dd/mm/yyyy') and resource_class=? and care_locn_type_ind=? and srl_no =? ";
			pstmt1_sql_upop_rec=con.prepareStatement(sql_upop_rec);
			pstmt1_sql_upop_rec_2=con.prepareStatement(sql_upop_rec_2);
			String oa_resource_for_appt_1="insert into oa_resource_for_appt (facility_id,appt_ref_no,resource_class,resource_id,resource_type,appt_date,appt_time,appt_slab_from_time,appt_slab_to_time,appt_duration,appt_slots,booking_type,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,srl_no) values (?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'hh24:mi'),to_date(?,'hh24:mi'),to_date(?,'hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),'','N', ?, sysdate, ?, ?,?, sysdate,?,?,?)";
			pstmt_oa_resource_for_appt_1 = con.prepareStatement(oa_resource_for_appt_1);
			if(sec_resources.size()>0){
				int sec_srl_n0=0;
				pstmt_sqlmaxSec.setString(1,addedFacilityId);
				pstmt_sqlmaxSec.setString(2,appt_ref_no);
				rsds=pstmt_sqlmaxSec.executeQuery();
				if(rsds !=null && rsds.next()){
					sec_srl_n0=rsds.getInt("srl_no");
				}
				if (rsds !=null) rsds.close();
				for(int xyz=0;xyz<sec_resources.size();xyz+=9){
					String sec_clinic_cd=(String) sec_resources.get(xyz);
					String sec_pract_id=(String) sec_resources.get(xyz+2);
					String sec_appt_dt=(String) sec_resources.get(xyz+3);
					String sec_res_class=(String) sec_resources.get(xyz+4);
					String sec_from_tm=(String) sec_resources.get(xyz+5);
					String sec_to_tm=(String) sec_resources.get(xyz+6);
					String sec_srl_no=(String) sec_resources.get(xyz+8);
					if(sec_pract_id ==null) sec_pract_id="";
					String timesec="";
					pstmt1_sqldssec_rec.setString(1,sec_appt_dt+" "+sec_from_tm);
					pstmt1_sqldssec_rec.setString(2,sec_appt_dt+" "+sec_to_tm);
					rsds=pstmt1_sqldssec_rec.executeQuery();
					if(rsds!=null && rsds.next()){
						timesec=rsds.getString("tmsc");
						timesec=sec_appt_dt+" "+timesec;
					}
					//if (rsds !=null) rsds.close();
					if(sec_res_class.equals("P")){
						pstmt1_sql_sec_rstyp1.setString(1,sec_pract_id);
						pstmt1_sql_sec_rstyp1.executeQuery();
					}else if(sec_res_class.equals("R")){
						
						pstmt1_sql_sec_rstyp2.setString(1,sec_pract_id);
						pstmt1_sql_sec_rstyp2.executeQuery();
					}else{
						pstmt1_sql_sec_rstyp3.setString(1,sec_pract_id);
						pstmt1_sql_sec_rstyp3.setString(2,sec_res_class);
						pstmt1_sql_sec_rstyp3.executeQuery();
					}
					String sec_res_type="";
					if(rsds!=null && rsds.next()){
						sec_res_type = rsds.getString("res_type") ;
						if(sec_res_type ==null || sec_res_type.equals("null")){
							sec_res_type="";
						}
					}
					if (rsds !=null) rsds.close();							
					pstmt_oa_resource_for_appt_1.setString(1,addedFacilityId);
					pstmt_oa_resource_for_appt_1.setString(2,appt_ref_no);
					pstmt_oa_resource_for_appt_1.setString(3,sec_res_class);
					pstmt_oa_resource_for_appt_1.setString(4,sec_pract_id);
					pstmt_oa_resource_for_appt_1.setString(5,sec_res_type);
					pstmt_oa_resource_for_appt_1.setString(6,sec_appt_dt);
					pstmt_oa_resource_for_appt_1.setString(7,sec_from_tm);
					pstmt_oa_resource_for_appt_1.setString(8,sec_from_tm);
					pstmt_oa_resource_for_appt_1.setString(9,sec_to_tm);
					pstmt_oa_resource_for_appt_1.setString(10,timesec);
					pstmt_oa_resource_for_appt_1.setString(11,addedById);
					pstmt_oa_resource_for_appt_1.setString(12,addedAtWorkstation);
					pstmt_oa_resource_for_appt_1.setString(13,addedFacilityId);
					pstmt_oa_resource_for_appt_1.setString(14,modifiedById);
					pstmt_oa_resource_for_appt_1.setString(15,modifiedAtWorkstation);
					pstmt_oa_resource_for_appt_1.setString(16,modifiedFacilityId);
					pstmt_oa_resource_for_appt_1.setInt(17,sec_srl_n0);
					resu = pstmt_oa_resource_for_appt_1.executeUpdate() ;
					if(resu != 0){
						result=true;
					}else{
						result=false;
					}
					if(result){
						String sql_sec_stat_rec="";
						if(sec_pract_id.equals("")){
							sql_sec_stat_rec=" update oa_clinic_schedule set total_slots_booked  = nvl(total_slots_booked,0)+1,total_first_visit=nvl(total_first_visit,0)+decode(?,'F',1,0),TOTAL_FIRST_VISIT_SLOTS_BOOKED=nvl(TOTAL_FIRST_VISIT_SLOTS_BOOKED,0)+decode(?,'F',1,0),total_follow_up=nvl(total_follow_up,0)+decode(?,'L',1,0),total_routine=nvl(total_routine,0)+decode(?,'R',1,0),total_series=nvl(total_series,0)+decode(?,'S',1,0),total_consult=nvl(total_consult,0)+decode(?,'C',1,0),total_emergency=nvl(total_emergency,0)+decode(?,'E',1,0),MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where facility_id = ? and clinic_code=? and clinic_date= to_date(?,'DD/MM/YYYY') and care_locn_type_ind=? and resource_class=? and primary_resource_yn='N' and practitioner_id is null ";
						}else{
							sql_sec_stat_rec=" update oa_clinic_schedule set total_slots_booked  = nvl(total_slots_booked,0)+1,total_first_visit=nvl(total_first_visit,0)+decode(?,'F',1,0),TOTAL_FIRST_VISIT_SLOTS_BOOKED=nvl(TOTAL_FIRST_VISIT_SLOTS_BOOKED,0)+decode(?,'F',1,0),total_follow_up=nvl(total_follow_up,0)+decode(?,'L',1,0),total_routine=nvl(total_routine,0)+decode(?,'R',1,0),total_series=nvl(total_series,0)+decode(?,'S',1,0),total_consult=nvl(total_consult,0)+decode(?,'C',1,0),total_emergency=nvl(total_emergency,0)+decode(?,'E',1,0),MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where facility_id = ? and clinic_code=? and clinic_date= to_date(?,'DD/MM/YYYY') and care_locn_type_ind=? and resource_class=? and primary_resource_yn='N' and practitioner_id =? ";
						}
						pstmt1_sql_sec_stat_rec=con.prepareStatement(sql_sec_stat_rec);
						pstmt1_sql_sec_stat_rec.setString(1,visitind);
						pstmt1_sql_sec_stat_rec.setString(2,visitind);
						pstmt1_sql_sec_stat_rec.setString(3,visitind);
						pstmt1_sql_sec_stat_rec.setString(4,visitind);
						pstmt1_sql_sec_stat_rec.setString(5,visitind);
						pstmt1_sql_sec_stat_rec.setString(6,visitind);
						pstmt1_sql_sec_stat_rec.setString(7,visitind);
						pstmt1_sql_sec_stat_rec.setString(8,modifiedById);
						pstmt1_sql_sec_stat_rec.setString(9,modifiedAtWorkstation);
						pstmt1_sql_sec_stat_rec.setString(10,modifiedFacilityId);
						pstmt1_sql_sec_stat_rec.setString(11,addedFacilityId);
						pstmt1_sql_sec_stat_rec.setString(12,sec_clinic_cd);
						pstmt1_sql_sec_stat_rec.setString(13,sec_appt_dt);
						pstmt1_sql_sec_stat_rec.setString(14,clinic_type);
						pstmt1_sql_sec_stat_rec.setString(15,sec_res_class);
						if(!sec_pract_id.equals("")){
							pstmt1_sql_sec_stat_rec.setString(16,sec_pract_id);
						}
						res_up =pstmt1_sql_sec_stat_rec.executeUpdate();
						/*pstmt1_sql_upd_oaclinic_sch1.setString(1,addedFacilityId);
						pstmt1_sql_upd_oaclinic_sch1.setString(2,sec_clinic_cd);
						pstmt1_sql_upd_oaclinic_sch1.setString(3,sec_appt_dt);
						pstmt1_sql_upd_oaclinic_sch1.setString(4,sec_pract_id);
						pstmt1_sql_upd_oaclinic_sch1.setString(5,sec_pract_id);
						pstmt1_sql_upd_oaclinic_sch1.setString(6,addedFacilityId);
						pstmt1_sql_upd_oaclinic_sch1.setString(7,sec_clinic_cd);
						pstmt1_sql_upd_oaclinic_sch1.setString(8,sec_appt_dt);
						pstmt1_sql_upd_oaclinic_sch1.setString(9,sec_pract_id);
						pstmt1_sql_upd_oaclinic_sch1.setString(10,sec_pract_id);
						res_up =pstmt1_sql_upd_oaclinic_sch1.executeUpdate();*/
						if(sec_pract_id != null && !sec_pract_id.equals("")){
							pstmt1_sql_upop_rec.setString(1,appt_ref_no);
							pstmt1_sql_upop_rec.setString(2,modifiedById);
							pstmt1_sql_upop_rec.setString(3,modifiedAtWorkstation);
							pstmt1_sql_upop_rec.setString(4,modifiedFacilityId);
							pstmt1_sql_upop_rec.setString(5,sec_clinic_cd);
							pstmt1_sql_upop_rec.setString(6,addedFacilityId);
							pstmt1_sql_upop_rec.setString(7,sec_appt_dt);
							pstmt1_sql_upop_rec.setString(8,sec_pract_id);	
							pstmt1_sql_upop_rec.setString(9,sec_res_class);
							pstmt1_sql_upop_rec.setString(10,clinic_type);
							pstmt1_sql_upop_rec.setString(11,sec_srl_no);
							res_up =pstmt1_sql_upop_rec.executeUpdate();
						}else{
							pstmt1_sql_upop_rec_2.setString(1,appt_ref_no);
							pstmt1_sql_upop_rec_2.setString(2,modifiedById);
							pstmt1_sql_upop_rec_2.setString(3,modifiedAtWorkstation);
							pstmt1_sql_upop_rec_2.setString(4,modifiedFacilityId);
							pstmt1_sql_upop_rec_2.setString(5,sec_clinic_cd);
							pstmt1_sql_upop_rec_2.setString(6,addedFacilityId);
							pstmt1_sql_upop_rec_2.setString(7,sec_appt_dt);
							pstmt1_sql_upop_rec_2.setString(8,sec_res_class);
							pstmt1_sql_upop_rec_2.setString(9,clinic_type);
							pstmt1_sql_upop_rec_2.setString(10,sec_srl_no);
							res_up =pstmt1_sql_upop_rec_2.executeUpdate();
						} 
						if ( res_up != 0 ) {
							result = true ;
						}else{
							con.rollback();
						}
					if(pstmt1_sql_sec_stat_rec!=null) pstmt1_sql_sec_stat_rec.close();  //checklist violation	
					}else{
						sb.append("Transaction Failed in Secondary Resources inner");
						con.rollback();
					}
					sec_srl_n0=sec_srl_n0+1;
				} // for loop
				if(result){
					String sql_upop1=" update oa_appt set recur_wo_sec_res='',MODIFIED_BY_ID='"+modifiedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where appt_ref_no='"+appt_ref_no+"' and facility_id= '"+addedFacilityId+"'";
					pstmt3 = con.prepareStatement( sql_upop1 );
					res_up =pstmt3.executeUpdate();
					if ( res_up != 0 ) {
						result = true ;
						con.commit();
						java.util.Hashtable message = MessageManager.getMessage( locale,"APPT_BOOKED_FOR_REFERRAL","OA" ) ;
						sb.append( (String) message.get("message") ) ;
						message.clear();
					}else{
						con.rollback();
						sb.append("Transaction Failed in updation of primary");
					}
				}
			}
			passObjects.clear();
			sec_resources.clear();
		}catch ( Exception e ){
			e.printStackTrace();
			result=false;
			sb.append("ERROR  :"+e.toString());
			try{
				con.rollback();
			}catch (Exception e1){
				e1.printStackTrace();
			}
		}finally{
			if (con != null){
				ConnectionManager.returnConnection(con,p);
			}
			try{
				if(pstmt3!= null) pstmt3.close() ;
				if(rsds!= null) rsds.close() ;
				if(pstmt_sqlmaxSec!= null) pstmt_sqlmaxSec.close() ;
				if(pstmt1_sqldssec_rec!= null) pstmt1_sqldssec_rec.close() ;
				if(pstmt1_sql_sec_stat_rec!= null) pstmt1_sql_sec_stat_rec.close() ;
				if(pstmt1_sql_upop_rec!= null) pstmt1_sql_upop_rec.close() ;
				if(pstmt1_sql_upop_rec_2!= null) pstmt1_sql_upop_rec_2.close() ;
				if(pstmt1_sql_sec_rstyp1!= null) pstmt1_sql_sec_rstyp1.close() ;
				if(pstmt1_sql_sec_rstyp2!= null) pstmt1_sql_sec_rstyp2.close() ;
				if(pstmt1_sql_sec_rstyp3!= null) pstmt1_sql_sec_rstyp3.close() ;
				if(pstmt_oa_resource_for_appt_1!= null) pstmt_oa_resource_for_appt_1.close() ;
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}//finally
		results.put( "status", new Boolean(result) ) ;
		results.put( "apptrefno",disp_appt_ref_no ) ;
		results.put( "error", sb.toString() ) ;
		sb.setLength(0);
		return results ;
	} // method
	// Bru-HIMS-CRF 169 changes
	boolean updateOAPatCnclSummary(Connection con, String patientid,String facilityId, String patCnclCount,String addedById,String addedAtWorkstation){
	boolean result=true;

	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{	
		if(patCnclCount.equals("0")){
			// Updating audit columns
			String updatePatCnclApptSql="update OA_PAT_CNCL_APPT_SUMMARY set APPT_CANCELLED_COUNT=?,LAST_RESET_USER=?,LAST_RESET_DATE=sysdate,Last_reset_work_station=?,Last_reset_FACILITY_ID=? where patient_id=? and facility_id=?";
			pstmt=con.prepareStatement(updatePatCnclApptSql);
			int field_count=1;
			pstmt.setString(field_count++,patCnclCount);
			pstmt.setString(field_count++,addedById);
			pstmt.setString(field_count++,addedAtWorkstation);
			pstmt.setString(field_count++,facilityId);
			pstmt.setString(field_count++,patientid);
			pstmt.setString(field_count++,facilityId);
			pstmt.executeUpdate();
		}
		if(pstmt!=null) pstmt.close();
		if(rs != null) rs.close();
	}catch(Exception ex){
		result=false;
		ex.printStackTrace();
	}
	finally{
	}
	return result;
 }//method for Bru-HIMS-CRF-169

 public static String checkForNull(String inputString){
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
 }
}//class

