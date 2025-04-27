/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOA.TransferClinicSch;


import java.rmi.* ;
import javax.ejb.* ;

import java.sql.* ;
import java.util.* ;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
/**
*
* @ejb.bean
*	name="TransferClinicSch"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="TransferClinicSch"
*	local-jndi-name="TransferClinicSch"
*	impl-class-name="eOA.TransferClinicSch.TransferClinicSchManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOA.TransferClinicSch.TransferClinicSchManagerLocal"
*	remote-class="eOA.TransferClinicSch.TransferClinicSchManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOA.TransferClinicSch.TransferClinicSchManagerLocalHome"
*	remote-class="eOA.TransferClinicSch.TransferClinicSchManagerHome"
*	generate= "local,remote"
*
*
*/

public class TransferClinicSchManager implements SessionBean {

	Connection con =null;
	PreparedStatement pstmt =null;
	PreparedStatement pstmt_3 =null;

	PreparedStatement pstmt7_new =null;
	PreparedStatement pstmt5_new =null;
	PreparedStatement pstmt1_new =null;
	PreparedStatement pstmt3_new1 =null;
	PreparedStatement pstmt3_new2 =null;
	PreparedStatement pstmt2_new =null;
	
	PreparedStatement pstmt1 =null;
	PreparedStatement pstmt2 =null;
	PreparedStatement pstmt3 =null;
	PreparedStatement pstmt4 =null;
	PreparedStatement pstmt5 =null;
	PreparedStatement pstmt6 =null;
	PreparedStatement pstmt6_sel =null;
	PreparedStatement pstmt6_sel2 =null;
	PreparedStatement pstmt6_del =null;
	PreparedStatement pstmt6_ins =null;

	PreparedStatement pstmt7 =null;
	PreparedStatement pstmt8 =null;
	PreparedStatement pstmt9 =null;
	PreparedStatement pstmt10 =null;
	PreparedStatement pstmt20 =null;
	PreparedStatement pstmt21 =null;
	PreparedStatement pstmt11 =null;
	PreparedStatement pstmt12=null;
	PreparedStatement pstmt13=null;
	PreparedStatement pstmt14=null;
	PreparedStatement pstmt15=null;
	PreparedStatement pstmt16=null;
	PreparedStatement pstmt17=null;
	Statement stmt=null;
	ResultSet rs ,rs2,res,rs3,rs20,rssrlno,rs4,rssrlno1,rs5,rssrlno2,rs7,rset,rsds,rsds_duty_roster3= null;
	SessionContext ctx;
	String sql20 ;
	String sql21;
	String updateQuery="";
	String locn = "";
	String pract ="";
	String curdat = "";
	//String curdayno = "";
	String transdat="";
	String str="";
	boolean sql_operation=false;

	String ethnic_grp_cd="";
	String ethnic_subgrp_cd="";
	String citizen_yn="";
	String legal_yn="";
	String birth_place_code="";
	String forced_appt_yn="";
	String global_appt_yn="";
	String res_town="";
	String res_area="";
	String res_region="";
	String res_country="";
	String mail_addr1="";
	String mail_addr2="";
	String mail_addr3="";
	String mail_addr4="";
	String mail_town="";
	String mail_area="";
	String mail_postal="";
	String mail_region="";
	String mail_country="";
	int duty_roster_cnt,duty_roster_cnt1,duty_roster_cnt2,duty_roster_cnt3=0;
		

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public final String RECORD_INSERTED = "RECORD_INSERTED" ;

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) { this.ctx=context;}
/**
* @ejb.interface-method
*	 view-type="both"
*/
public java.util.HashMap UpdateSch(
		java.util.Properties p,
		java.util.HashMap passObjects

	) 
{
	//Integer nbigInt=(Integer) passObjects.get("nBigInt");
	//Integer sbigInt=(Integer) passObjects.get("sBigInt");
	String finalvals=(String) passObjects.get("finalvals1");
	//String efffrom=(String) passObjects.get("efffrom");
	//String effto=(String) passObjects.get("effto");
	String reason=(String) passObjects.get("reason");
	String curdayno=(String) passObjects.get("curdayno");
	String transdayno=(String) passObjects.get("transdayno");
	//String dateday=(String) passObjects.get("dateday");
	String fid=(String) passObjects.get("fid");
	String facilityId=(String) passObjects.get("facilityId");
	String addedAtWorkstation=(String) passObjects.get("client_ip_address");
	String locationType=(String) passObjects.get("locationType");
	String resourceType=(String) passObjects.get("resourceType");

	String other_remarks = (String) passObjects.get("other_remarks"); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114

	String locale = p.getProperty("LOCALE");
	java.util.HashMap results = new java.util.HashMap() ;
	//int n=nbigInt.intValue();
	//int s=sbigInt.intValue();
	boolean result = false ;
	String facility ;
	String apptrefno ;
	String cliniccode ;
	String practitionerid ;
	String appttime ;
	String apptslabfromtime ;
	String apptslabtotime ;
	String apptduration ;
	String apptslots;
	String patientid ;
	String nameprefix ;
	String firstname ;
	String secondname;
	String thirdname ;
	String familyname;
	String namesuffix ;
	String patientname ;
	String gender ;
	String dateofbirth ;
	String restelno ;
	String othcontactno ;
	String emailid ;
	String nationalidno ;
	String altid1no ;
	String resaddrline1;
	String resaddrline2;
	String resaddrline3;
	String resaddrline4;
	String postalcode ;
	String countrycode ;
	String appttypecode ;
	String overbookedyn;
	String referralId;
	String contactreasoncode;
	String modeofcontact;
	String apptremarks;
	String inpatientyn ;
	String encounterid;
	String primary_yn;
	String noofappts;
	String speciality_code="";
	String sl = "";
	String name_prefix_loc_lang ="";
	String	first_name_loc_lang="";
	String	second_name_loc_lang="";
	String	third_name_loc_lang="";
	String	name_suffix_loc_lang="";
	String	family_name_loc_lang="";
	String	patient_name_loc_lang="";
	String sec_res_id="";
	String appt_ref_no="";
	String service_code="";
	int srlno3;
	int srlno4;
	int srlno5;
	int srlno7;
	String sn="";
	int srl;
	String sn1="";
	int srl1;
	String sn2="";
	int srl2;
	int res3 = 0;
	int sec_1 = 0;
	int sec_2 = 0;
	int sec_3 = 0;
	String X_appt_status="T";
	StringBuffer sb = new StringBuffer( "" );
	String trans_exceed_reason_code="";
	/*Added by Thamizh selvi on 24th May 2017 for ML-MMOH-CRF-0610 Start*/
	String  appt_added_by_id="";
	String  appt_added_date="";
	/*End*/
	try{
		con = ConnectionManager.getConnection(p);
		con.setAutoCommit( false );
		String addedDate = dateFormat.format( new java.util.Date());
		String modifiedById = p.getProperty( "login_user" ) ;
		String modifiedDate = dateFormat.format( new java.util.Date());
		java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate);
		String modifiedAtWorkstation = addedAtWorkstation ;
		java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
		StringTokenizer st = new StringTokenizer(finalvals,"-");
		String sql =  " select facility_id, appt_ref_no, clinic_code, practitioner_id,to_char(appt_date,'dd/mm/yyyy') appt_date,   to_char(appt_time,'dd/mm/yyyy HH24:MI') appt_time,  to_char(appt_slab_from_time,'dd/mm/yyyy hh24:mi') appt_slab_from_time,to_char(appt_slab_to_time,'dd/mm/yyyy hh24:mi') appt_slab_to_time,  to_char(appt_duration,'dd/mm/yyyy hh24:mi') appt_duration, appt_slots, patient_id,name_prefix, first_name, second_name,third_name,family_name, name_suffix, patient_name, gender,to_char(date_of_birth,'dd/mm/yyyy') date_of_birth, res_tel_no,oth_contact_no, email_id,national_id_no, alt_id1_no, res_addr_line1, res_addr_line2,res_addr_line3,res_addr_line4, postal_code,country_code, appt_type_code, overbooked_yn, referral_id,contact_reason_code,mode_of_contact, appt_remarks, appt_status, inpatient_yn,  encounter_id,ETHNIC_GROUP_CODE,FORCED_APPT_YN,CITIZEN_YN,LEGAL_YN,BIRTH_PLACE_CODE,RACE_CODE,GLOBAL_APPT_YN,RES_AREA_CODE,RES_TOWN_CODE,RES_REGION_CODE,RES_COUNTRY_CODE,MAIL_ADDR_LINE1,MAIL_ADDR_LINE2,MAIL_ADDR_LINE3,MAIL_ADDR_LINE4,MAIL_AREA_CODE,MAIL_TOWN_CODE,MAIL_REGION_CODE,MAIL_POSTAL_CODE,MAIL_COUNTRY_CODE,NAME_PREFIX_LOC_LANG,FIRST_NAME_LOC_LANG,SECOND_NAME_LOC_LANG,THIRD_NAME_LOC_LANG,FAMILY_NAME_LOC_LANG,NAME_SUFFIX_LOC_LANG,PATIENT_NAME_LOC_LANG,speciality_code,service_code,trans_exceed_reason_code,added_by_id,to_char (added_date,'dd/mm/yyyy hh24:mi:ss') added_date  from oa_appt where facility_id = ? and clinic_code = ? and nvl(practitioner_id,'X') =nvl(?,'X')  and appt_date=to_date(?,'dd/mm/yyyy') and care_locn_type_ind=? and resource_class=?";//Modified by Thamizh selvi on 24th May 2017 for ML-MMOH-CRF-0610 --added_by_id & added_date
		pstmt = con.prepareStatement( sql ) ;
		String sql2="select holiday_date from  oa_holiday where holiday_date=to_date(?,'dd/mm/yyyy') and locn_code=? and care_locn_type_ind =? and FACILITY_ID=?";
		pstmt2 = con.prepareStatement( sql2) ;
		String sql3 = "select NVL(MAX(SRLNO),0)+1 maxno from oa_appt_del_tr where facility_id = ? and appt_ref_no = ? " ;
		pstmt_3 = con.prepareStatement( sql3 ) ;
		String sql1 = " insert into oa_appt_del_tr (FACILITY_ID, APPT_REF_NO, SRLNO,CLINIC_CODE, PRACTITIONER_ID, APPT_DATE, APPT_TR_DATE, APPT_TIME, APPT_SLAB_FROM_TIME, APPT_SLAB_TO_TIME, APPT_DURATION, APPT_SLOTS, PATIENT_ID, NAME_PREFIX, FIRST_NAME, SECOND_NAME, THIRD_NAME, FAMILY_NAME, NAME_SUFFIX, PATIENT_NAME, GENDER, DATE_OF_BIRTH, RES_TEL_NO, OTH_CONTACT_NO, EMAIL_ID, NATIONAL_ID_NO, ALT_ID1_NO, RES_ADDR_LINE1, RES_ADDR_LINE2, RES_ADDR_LINE3, RES_ADDR_LINE4, POSTAL_CODE, COUNTRY_CODE, APPT_TYPE_CODE,  OVERBOOKED_YN, REFERRAL_ID, CONTACT_REASON_CODE, MODE_OF_CONTACT, APPT_REMARKS, APPT_STATUS, INPATIENT_YN, ENCOUNTER_ID, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, REASON_FOR_CANCEL,ETHNIC_GROUP_CODE,FORCED_APPT_YN,CITIZEN_YN,LEGAL_YN,BIRTH_PLACE_CODE,RACE_CODE,GLOBAL_APPT_YN,RES_AREA_CODE,RES_TOWN_CODE,RES_REGION_CODE,MAIL_ADDR_LINE1,MAIL_ADDR_LINE2,MAIL_ADDR_LINE3,MAIL_ADDR_LINE4,MAIL_AREA_CODE,MAIL_TOWN_CODE,MAIL_REGION_CODE,MAIL_POSTAL_CODE,MAIL_COUNTRY_CODE,RES_COUNTRY_CODE,care_locn_type_ind,resource_class,NAME_PREFIX_LOC_LANG,FIRST_NAME_LOC_LANG,SECOND_NAME_LOC_LANG,THIRD_NAME_LOC_LANG,FAMILY_NAME_LOC_LANG,NAME_SUFFIX_LOC_LANG,PATIENT_NAME_LOC_LANG,SPECIALITY_CODE,service_code,trans_exceed_reason_code,appt_booked_by_id,appt_booked_date,LOC_RESCHEDULE_REMARKS ) values(?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),to_number(?),?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_number(?),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi:ss'),?)";//Modified by Thamizh selvi on 24th May 2017 for ML-MMOH-CRF-0610 --appt_booked_by_id,appt_booked_date //LOC_RESCHEDULE_REMARKS Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
		pstmt1 = con.prepareStatement( sql1 ) ;
		String sql2_new = " update oa_appt set appt_date=to_date(?,'dd/mm/yyyy'),MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate,  MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? where facility_id = ? and clinic_code = ? and nvl(practitioner_id,'X') =nvl(?,'X') and appt_date =to_date(?,'dd/mm/yyyy') and care_locn_type_ind = ? and resource_class = ? " ;
		pstmt2_new = con.prepareStatement( sql2_new) ;
		String sql3_new1 = " Select nvl(max(srl_no),0)+1 max from oa_clinic_schedule where facility_id=? and clinic_code=? and clinic_date=to_date(?,'dd/mm/yyyy') " ;
		pstmt3_new1 = con.prepareStatement( sql3_new1) ;
		String sql3_new2 = " update oa_clinic_schedule set clinic_date=to_date(?,'dd/mm/yyyy'), srl_no = ?,MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? where facility_id = ? and clinic_code = ? and nvl(practitioner_id,'X') =nvl(?,'X') and clinic_date = to_date(?,'dd/mm/yyyy') and care_locn_type_ind = ? and resource_class = ?" ;
		pstmt3_new2 = con.prepareStatement( sql3_new2) ;

		/*sql20 = "select alcn_criteria  from oa_clinic_schedule_dtl where facility_id=? and clinic_code=? and nvl(practitioner_id,'X') =nvl(?,'X') and clinic_date = to_date(?,'dd/mm/yyyy') and care_locn_type_ind=? and resource_class=? ";
					
		pstmt20 = con.prepareStatement(sql20);

		sql21 = " update  oa_clinic_schedule_dtl set clinic_date=to_date(?,'dd/mm/yyyy'),MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? where facility_id = ? and clinic_code = ? and nvl(practitioner_id,'X') =nvl(?,'X') and clinic_date = to_date(?,'dd/mm/yyyy')  and care_locn_type_ind = ? and resource_class = ? ";

		pstmt21 = con.prepareStatement( sql21) ;*/
		String sqlsrlno = " Select srl_no from oa_clinic_schedule_break where facility_id=? and clinic_code=? and clinic_date=to_date(?,'dd/mm/yyyy') and nvl(practitioner_id,'X') =nvl(?,'X')" ;
		pstmt8 = con.prepareStatement( sqlsrlno) ;
		String sql4 = " update oa_clinic_schedule_break set clinic_date=to_date(?,'dd/mm/yyyy'),srl_no = ? ,day_no=?,MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? where facility_id = ? and clinic_code = ? and clinic_date =to_date(?,'dd/mm/yyyy') and srl_no=? and nvl(practitioner_id,'X') =nvl(?,'X') and   care_locn_type_ind = ? and resource_class =?";
		pstmt4 = con.prepareStatement( sql4) ;
		String sqlsrlno1 = " Select srl_no from oa_block_appt where facility_id=? and clinic_code=? and block_date=to_date(?,'dd/mm/yyyy') and nvl(practitioner_id,'X') =nvl(?,'X')" ;
		pstmt10 = con.prepareStatement( sqlsrlno1) ;
		String sql5 = " Select nvl(max(srl_no),0)+1 max from oa_block_appt where facility_id=? and clinic_code=? " ;
		pstmt5 = con.prepareStatement( sql5) ;
		String sql5_new = " update oa_block_appt  set block_date=to_date(?,'dd/mm/yyyy'), srl_no=?, MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? where facility_id = ? and clinic_code = ? and nvl(practitioner_id,'X') =nvl(?,'X') and block_date =to_date(?,'dd/mm/yyyy') and care_locn_type_ind= ? and resource_class = ? and srl_no=?" ;
		pstmt5_new = con.prepareStatement( sql5_new) ;
		String sql6_del="delete from oa_roster_for_pract where facility_id=? and clinic_code=? and nvl(practitioner_id,'X')=nvl(?,'X') and on_duty_date=to_date(?,'dd/mm/yyyy') and care_locn_type_ind =? and resource_class=?";
		pstmt6_del=con.prepareStatement(sql6_del);
		String sql6_ins="insert into oa_roster_for_pract (facility_id,practitioner_id,clinic_code,on_duty_date,added_by_id,added_date,ADDED_AT_WS_NO,added_facility_id,modified_by_id,modified_date,MODIFIED_AT_WS_NO,modified_facility_id,care_locn_type_ind,resource_class)values(?,?,?,to_date(?,'dd/mm/yyyy'),?,to_date(?,'dd/mm/yyyy'),?,?,?,sysdate,?,?,?,?)";
		pstmt6_ins=con.prepareStatement(sql6_ins);
		String sqlsrlno2 = " Select srl_no from oa_clinic_schedule_validity  where facility_id=? and clinic_code=? and day_no=? and nvl(practitioner_id,'X') =nvl(?,'X')" ;
		pstmt11 = con.prepareStatement( sqlsrlno2) ;
		String sql7 = " Select nvl(max(srl_no),0)+1 max from oa_clinic_schedule_validity where facility_id=? and clinic_code=? and day_no=?" ;
		pstmt7 = con.prepareStatement(sql7) ;
		String sql7_new = " update oa_clinic_schedule_validity set day_no=to_number(?), srl_no = ? ,MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate,MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? where facility_id = ? and clinic_code = ? and nvl(practitioner_id,'X') =nvl(?,'X') and day_no =to_number(?) and care_locn_type_ind = ? and resource_class = ? and  srl_no=?" ;
		pstmt7_new = con.prepareStatement( sql7_new) ;
		updateQuery = " update OA_CLINIC_SCHEDULE_SLOT_SLAB set clinic_date=to_date(?,'dd/mm/yyyy'), MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? where facility_id = ? and clinic_code = ? and nvl(practitioner_id,'X') =nvl(?,'X') and clinic_date = to_date(?,'dd/mm/yyyy') and care_locn_type_ind = ? and resource_class = ?" ;
		pstmt12 = con.prepareStatement( updateQuery) ;
		stmt=con.createStatement();
		String sql1_new = " Insert into oa_trans_record (facility_id,srl_no,trans_code,trans_date_time, trans_eff_by_id,  from_date_entered,to_date_entered, clinic_code,from_practitioner_id,from_day_no,to_day_no, remarks,care_locn_type_ind,resource_class) values (?,?,?,sysdate,'"+fid+"',to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?) " ;
		pstmt1_new = con.prepareStatement( sql1_new );
		String sql4_new = " Select nvl(max(srl_no),0)+1 max from oa_clinic_schedule_break where facility_id=? and clinic_code=? and clinic_date=to_date(?,'dd/mm/yyyy') " ;
		pstmt9 = con.prepareStatement( sql4_new) ;
		String sql_sec_oa_resource_for_appt="Update oa_resource_for_appt set appt_date=to_date (?,'dd/mm/yyyy'),MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate,  MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? Where facility_id = ? and  APPT_REF_NO=? and nvl(resource_id,'X') =nvl (?,'X') and appt_date =to_date(?,'dd/mm/yyyy')";
		pstmt13 = con.prepareStatement( sql_sec_oa_resource_for_appt) ;
		String sql_sec_oa_clinic_schedule="update oa_clinic_schedule set clinic_date=to_date(?,'dd/mm/yyyy'), srl_no = ?,MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? where facility_id = ? and clinic_code = ? and nvl(practitioner_id,'X') =nvl(?,'X') and clinic_date = to_date(?,'dd/mm/yyyy') ";
		pstmt14 = con.prepareStatement( sql_sec_oa_clinic_schedule) ;	
		String sql_sec_oa_clinic_schedule_break="update oa_clinic_schedule_break set clinic_date=to_date(?,'dd/mm/yyyy'),srl_no = ? ,day_no=?,MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? where facility_id = ? and clinic_code = ? and clinic_date =to_date(?,'dd/mm/yyyy') and srl_no=? and nvl(practitioner_id,'X') =nvl(?,'X')";
		pstmt15 = con.prepareStatement( sql_sec_oa_clinic_schedule_break) ;
		String sql_sec_oa_clinic_schedule_slot_slab="update OA_CLINIC_SCHEDULE_SLOT_SLAB set clinic_date=to_date(?,'dd/mm/yyyy'), MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? where facility_id = ? and clinic_code = ? and nvl(practitioner_id,'X') =nvl(?,'X') and clinic_date = to_date(?,'dd/mm/yyyy') ";
		pstmt16 = con.prepareStatement( sql_sec_oa_clinic_schedule_slot_slab) ;
		while(st.hasMoreTokens()){
			str = st.nextToken();
			StringTokenizer st1 = new StringTokenizer(str,"|");
			while(st1.hasMoreTokens()){
				locn = st1.nextToken();
				pract = st1.nextToken();
				if (pract.equals("~")) pract="";
				curdat = st1.nextToken();
				transdat = st1.nextToken();
				primary_yn=st1.nextToken();
				noofappts=st1.nextToken();
				String prisecappt="select RESOURCE_ID , appt_ref_no from oa_resource_for_appt where facility_id='"+facilityId+"' AND appt_ref_no in (select pri_appt_ref_no from oa_clinic_schedule_slot_slab where facility_id='"+facilityId+"' and CLINIC_CODE='"+locn+"' and  CLINIC_DATE=to_date('"+curdat+"','dd/mm/yyyy') and nvl(PRACTITIONER_ID,'X')=nvl('"+pract+"','X'))";
				rs=stmt.executeQuery(prisecappt);
				if(rs !=null){
					while (rs.next()){
						sec_res_id = rs.getString("RESOURCE_ID");
						if(sec_res_id ==null) sec_res_id="";
						appt_ref_no= rs.getString("appt_ref_no");
						if(appt_ref_no ==null) appt_ref_no="";
						if(!sec_res_id.equals("")){
							pstmt13.setString( 1, transdat ) ;
							pstmt13.setString( 2, modifiedById ) ;
							pstmt13.setString( 3, modifiedAtWorkstation ) ;
							pstmt13.setString( 4, facilityId ) ;
							pstmt13.setString( 5, facilityId ) ;
							pstmt13.setString( 6, appt_ref_no ) ;
							pstmt13.setString( 7, sec_res_id ) ;
							pstmt13.setString( 8, curdat ) ;				
							sec_1= pstmt13.executeUpdate() ;
							pstmt3_new1.setString(1,facilityId);
							pstmt3_new1.setString(2,locn);
							pstmt3_new1.setString(3,transdat);
							rs3 = pstmt3_new1.executeQuery() ;
							if(rs3.next())
								sl  = rs3.getString("max");
							if(rs3 !=null) rs3.close();
							srlno3 = Integer.parseInt(sl);
							pstmt14.setString( 1, transdat ) ;
							pstmt14.setInt( 2, srlno3 ) ;
							pstmt14.setString( 3, modifiedById ) ;
							pstmt14.setString( 4, modifiedAtWorkstation ) ;
							pstmt14.setString( 5, facilityId ) ;
							pstmt14.setString( 6, facilityId ) ;
							pstmt14.setString( 7, locn ) ;
							pstmt14.setString( 8, sec_res_id ) ;
							pstmt14.setString( 9, curdat ) ;								   
							res3 = pstmt14.executeUpdate() ;
							pstmt8.setString( 1, facilityId ) ;
							pstmt8.setString( 2, locn ) ;
							pstmt8.setString( 3, curdat ) ;
							pstmt8.setString( 4, sec_res_id);
							rssrlno = pstmt8.executeQuery() ;
							if(rssrlno != null){
								while(rssrlno.next()){
									sn = rssrlno.getString("srl_no");
									srl = Integer.parseInt(sn);
									pstmt9.setString(1,facilityId);
									pstmt9.setString(2,locn);
									pstmt9.setString(3,transdat);
									rs4 = pstmt9.executeQuery() ;
									if(rs4.next())
										sl  = rs4.getString("max");
									if (rs4 !=null) rs4.close();
									srlno4 = Integer.parseInt(sl);
									pstmt15.setString( 1, transdat ) ;
									pstmt15.setInt( 2,srlno4) ;
									pstmt15.setString( 3,transdayno);
									pstmt15.setString( 4, modifiedById ) ;
									pstmt15.setString( 5, modifiedAtWorkstation ) ;
									pstmt15.setString( 6, facilityId ) ;
									pstmt15.setString( 7, facilityId ) ;
									pstmt15.setString( 8, locn ) ;
									pstmt15.setString( 9, curdat ) ;
									pstmt15.setInt( 10, srl ) ;
									pstmt15.setString( 11, sec_res_id ) ;
									sec_2=pstmt15.executeUpdate() ;
								} // while
							} // if
							pstmt16.setString( 1, transdat ) ;
							pstmt16.setString( 2, modifiedById ) ;
							pstmt16.setString( 3, modifiedAtWorkstation ) ;
							pstmt16.setString( 4, facilityId ) ;
							pstmt16.setString( 5, facilityId ) ;
							pstmt16.setString( 6, locn ) ;
							pstmt16.setString( 7, sec_res_id ) ;
							pstmt16.setString( 8, curdat ) ;
							sec_3=pstmt16.executeUpdate();
						}
					}
				}
				pstmt.setString( 1, facilityId ) ;
				pstmt.setString( 2, locn ) ;
				pstmt.setString( 3, pract ) ;
				pstmt.setString( 4, curdat ) ;
				pstmt.setString( 5, locationType);
				pstmt.setString( 6, resourceType);
				rs = pstmt.executeQuery() ;
				if(rs != null){ 
					while(rs.next()){
						pstmt2.setString(1,curdat);
						pstmt2.setString(2,locn);
						pstmt2.setString(3,locationType);
						pstmt2.setString(4,facilityId);
						rs2 = pstmt2.executeQuery() ;
						if(rs2.next())
							X_appt_status = "H";
						else
							X_appt_status = "T";
						if(rs2 !=null) rs2.close();
						facility = rs.getString("facility_id");
						apptrefno = rs.getString("appt_ref_no");
						cliniccode = rs.getString("clinic_code");
						practitionerid = rs.getString("practitioner_id");
						if(practitionerid == null || practitionerid.equals(""))
							practitionerid = "";
						appttime = rs.getString("appt_time");
						if(appttime == null || appttime.equals(""))
							appttime = "";
						apptslabfromtime = rs.getString("appt_slab_from_time");
						if(apptslabfromtime == null || apptslabfromtime.equals(""))
							apptslabfromtime = "";
						apptslabtotime = rs.getString("appt_slab_to_time");
						if(apptslabtotime == null || apptslabtotime.equals(""))
										apptslabtotime = "";
						apptduration = rs.getString("appt_duration");
						if(apptduration == null || apptduration.equals(""))
										apptduration = "";
						apptslots = rs.getString("appt_slots");
						if(apptslots == null || apptslots.equals(""))
										apptslots = "";
						patientid = rs.getString("patient_id");
						if(patientid == null || patientid.equals(""))
										patientid = "";
						nameprefix = rs.getString("name_prefix");
						if(nameprefix == null || nameprefix.equals(""))
										nameprefix = "";
						firstname = rs.getString("first_name");
						if(firstname == null || firstname.equals(""))
										firstname = "";
						secondname = rs.getString("second_name");
						if(secondname == null || secondname.equals(""))
										secondname = "";
						thirdname = rs.getString("third_name");
						if(thirdname == null || thirdname.equals(""))
										thirdname = "";
						familyname = rs.getString("family_name");
						if(familyname == null || familyname.equals(""))
										familyname = "";
						namesuffix = rs.getString("name_suffix");
						if(namesuffix == null || namesuffix.equals(""))
										namesuffix = "";
						patientname = rs.getString("patient_name");
						gender = rs.getString("gender");
						dateofbirth = rs.getString("date_of_birth");
						if(dateofbirth == null || dateofbirth.equals(""))
							dateofbirth = "";
						restelno = rs.getString("res_tel_no");
						if(restelno == null || restelno.equals(""))
							restelno = "";
						othcontactno = rs.getString("oth_contact_no");
						if(othcontactno == null || othcontactno.equals(""))
							othcontactno = "";
						emailid = rs.getString("email_id");
						if(emailid == null || emailid.equals(""))
							emailid = "";
						nationalidno = rs.getString("national_id_no");
						if(nationalidno == null || nationalidno.equals(""))
							nationalidno = "";
						altid1no = rs.getString("alt_id1_no");
						if(altid1no == null || altid1no.equals(""))
							altid1no = "";
						resaddrline1 = rs.getString("res_addr_line1");
						if(resaddrline1 == null || resaddrline1.equals(""))
							resaddrline1 = "";
						resaddrline2 = rs.getString("res_addr_line2");
						if(resaddrline2 == null || resaddrline2.equals(""))
							resaddrline2 = "";
						resaddrline3 = rs.getString("res_addr_line3");
						if(resaddrline3 == null || resaddrline3.equals(""))
							resaddrline3 = "";
						resaddrline4 = rs.getString("res_addr_line4");
						if(resaddrline4 == null || resaddrline4.equals(""))
							resaddrline4 = "";
						postalcode = rs.getString("postal_code");
						if(postalcode == null || postalcode.equals(""))
							postalcode = "";
						countrycode = rs.getString("country_code");
						if(countrycode == null || countrycode.equals(""))
							countrycode = "";
						appttypecode = rs.getString("appt_type_code");
						overbookedyn= rs.getString("overbooked_yn");
						referralId = rs.getString("referral_id");
						if(referralId == null || referralId.equals(""))
							referralId = "";
						contactreasoncode = rs.getString("contact_reason_code");
						modeofcontact = rs.getString("mode_of_contact");
						if(modeofcontact == null || modeofcontact.equals(""))
							modeofcontact = "";
						apptremarks = rs.getString("appt_remarks");
						if(apptremarks == null || apptremarks.equals(""))
							apptremarks = "";
						inpatientyn = rs.getString("inpatient_yn");
						encounterid = rs.getString("encounter_id");
						if(encounterid == null || encounterid.equals(""))
							encounterid = "";
						ethnic_grp_cd=rs.getString("ETHNIC_GROUP_CODE");
							if(ethnic_grp_cd==null) ethnic_grp_cd="";
						ethnic_subgrp_cd=rs.getString("RACE_CODE");
							if(ethnic_subgrp_cd==null) ethnic_subgrp_cd="";
						citizen_yn=rs.getString("CITIZEN_YN");
							if(citizen_yn==null) citizen_yn="N";
						legal_yn=rs.getString("LEGAL_YN");
							if(legal_yn==null) legal_yn="N";
						birth_place_code=rs.getString("BIRTH_PLACE_CODE");
							if(birth_place_code==null) birth_place_code="";
						forced_appt_yn=rs.getString("FORCED_APPT_YN");
							if(forced_appt_yn==null) forced_appt_yn="N";
						global_appt_yn=rs.getString("GLOBAL_APPT_YN");
							if(global_appt_yn==null) global_appt_yn="N";
						res_town=rs.getString("RES_TOWN_CODE");
						if(res_town==null) res_town="";
						res_area=rs.getString("RES_AREA_CODE");
						if(res_area==null) res_area="";
						res_region=rs.getString("RES_REGION_CODE");
						if(res_region==null) res_region="";

						res_country=rs.getString("RES_COUNTRY_CODE");
						if(res_country==null) res_country="";
						mail_addr1=rs.getString("MAIL_ADDR_LINE1");
						if(mail_addr1==null) mail_addr1="";
						mail_addr2=rs.getString("MAIL_ADDR_LINE2");
						if(mail_addr2==null) mail_addr2="";
						mail_addr3=rs.getString("MAIL_ADDR_LINE3");
						if(mail_addr3==null) mail_addr3="";
						mail_addr4=rs.getString("MAIL_ADDR_LINE4");
						if(mail_addr4==null) mail_addr4="";
						mail_town=rs.getString("MAIL_TOWN_CODE");
						if(mail_town==null) mail_town="";
						mail_area=rs.getString("MAIL_AREA_CODE");
						if(mail_area==null) mail_area="";
						mail_postal=rs.getString("MAIL_POSTAL_CODE");
						if(mail_postal==null) mail_postal="";
						mail_region=rs.getString("MAIL_REGION_CODE");
						if(mail_region==null) mail_region="";
						mail_country=rs.getString("MAIL_COUNTRY_CODE");
						if(mail_country==null) mail_country="";
						speciality_code=rs.getString("speciality_code");
						if(speciality_code==null) speciality_code="";
						service_code=rs.getString("service_code");
						if(service_code==null) service_code="";
						name_prefix_loc_lang=rs.getString("NAME_PREFIX_LOC_LANG")==null?"":rs.getString("NAME_PREFIX_LOC_LANG");
						first_name_loc_lang=rs.getString("FIRST_NAME_LOC_LANG")==null?"":rs.getString("FIRST_NAME_LOC_LANG");
						second_name_loc_lang=rs.getString("SECOND_NAME_LOC_LANG")==null?"":rs.getString("SECOND_NAME_LOC_LANG");
						third_name_loc_lang=rs.getString("THIRD_NAME_LOC_LANG")==null?"":rs.getString("THIRD_NAME_LOC_LANG");
						name_suffix_loc_lang=rs.getString("NAME_SUFFIX_LOC_LANG")==null?"":rs.getString("NAME_SUFFIX_LOC_LANG");
						family_name_loc_lang=rs.getString("FAMILY_NAME_LOC_LANG")==null?"":rs.getString("FAMILY_NAME_LOC_LANG");
						patient_name_loc_lang=rs.getString("PATIENT_NAME_LOC_LANG")==null?"":rs.getString("PATIENT_NAME_LOC_LANG");
						trans_exceed_reason_code=rs.getString("trans_exceed_reason_code")==null?"":rs.getString("trans_exceed_reason_code");
						/*Added by Thamizh selvi on 24th May 2017 for ML-MMOH-CRF-0610 Start*/
						appt_added_by_id=rs.getString("added_by_id")==null?"":rs.getString("added_by_id");
						appt_added_date=rs.getString("added_date")==null?"":rs.getString("added_date");
						/*End*/
						int srl_no = 0;					
						pstmt_3.setString(1,facility);
						pstmt_3.setString(2,apptrefno);
						res = pstmt_3.executeQuery() ;
						if(res.next()){
						  srl_no = res.getInt("maxno");
						}
						if(res !=null)res.close();
						pstmt1.setString( 1, facility ) ;
						pstmt1.setString( 2, apptrefno  ) ;
						pstmt1.setInt( 3, srl_no  ) ;
						pstmt1.setString( 4, cliniccode  ) ;
						pstmt1.setString( 5, practitionerid  ) ;
						pstmt1.setString( 6, curdat  ) ;
						pstmt1.setString( 7, transdat  ) ;
						pstmt1.setString( 8, appttime  ) ;
						pstmt1.setString( 9, apptslabfromtime  ) ;
						pstmt1.setString( 10, apptslabtotime  ) ;
						pstmt1.setString( 11, apptduration  ) ;
						pstmt1.setString( 12, apptslots  ) ;
						pstmt1.setString( 13, patientid  ) ;
						pstmt1.setString( 14, nameprefix  ) ;
						pstmt1.setString( 15, firstname  ) ;
						pstmt1.setString( 16, secondname  ) ;
						pstmt1.setString( 17, thirdname  ) ;
						pstmt1.setString( 18, familyname  ) ;
						pstmt1.setString( 19, namesuffix  ) ;
						pstmt1.setString( 20, patientname  ) ;
						pstmt1.setString( 21, gender  ) ;
						pstmt1.setString( 22, dateofbirth  ) ;
						pstmt1.setString( 23, restelno  ) ;
						pstmt1.setString( 24, othcontactno  ) ;
						pstmt1.setString( 25, emailid  ) ;
						pstmt1.setString( 26, nationalidno  ) ;
						pstmt1.setString( 27, altid1no  ) ;
						pstmt1.setString( 28, resaddrline1  ) ;
						pstmt1.setString( 29, resaddrline2  ) ;
						pstmt1.setString( 30, resaddrline3  ) ;
						pstmt1.setString( 31, resaddrline4  ) ;
						pstmt1.setString( 32, postalcode  ) ;
						pstmt1.setString( 33, countrycode  ) ;
						pstmt1.setString( 34, appttypecode  ) ;
						pstmt1.setString( 35, overbookedyn  ) ;
						pstmt1.setString( 36, referralId ) ;
						pstmt1.setString( 37, contactreasoncode  ) ;
						pstmt1.setString( 38, modeofcontact  ) ;
						pstmt1.setString( 39, apptremarks  ) ;
						pstmt1.setString( 40, X_appt_status ) ;
						pstmt1.setString( 41, inpatientyn  ) ;
						pstmt1.setString( 42, encounterid ) ;
						pstmt1.setString( 43, modifiedById ) ;
						pstmt1.setDate( 44, added_date ) ;
						pstmt1.setString( 45, addedAtWorkstation ) ;
						pstmt1.setString( 46, facilityId ) ;
						pstmt1.setString( 47, modifiedById ) ;
						pstmt1.setDate( 48,  modified_date) ;
						pstmt1.setString( 49, modifiedAtWorkstation ) ;
						pstmt1.setString( 50, facilityId ) ;
						pstmt1.setString( 51, reason ) ;
						pstmt1.setString	( 52, ethnic_grp_cd ) ;
						pstmt1.setString	( 53, forced_appt_yn ) ;
						pstmt1.setString	( 54, citizen_yn ) ;
						pstmt1.setString	( 55, legal_yn ) ;
						pstmt1.setString	( 56, birth_place_code ) ;
						pstmt1.setString	( 57, ethnic_subgrp_cd ) ;
						pstmt1.setString	( 58, global_appt_yn ) ;
						pstmt1.setString	( 59, res_area ) ;
						pstmt1.setString	( 60, res_town ) ;
						pstmt1.setString	( 61, res_region ) ;
						pstmt1.setString	( 62, mail_addr1 ) ;
						pstmt1.setString	( 63, mail_addr2 ) ;
						pstmt1.setString	( 64, mail_addr3 ) ;
						pstmt1.setString	( 65, mail_addr4 ) ;
						pstmt1.setString	( 66, mail_area ) ;
						pstmt1.setString	( 67, mail_town ) ;
						pstmt1.setString	( 68, mail_region ) ;
						pstmt1.setString	( 69, mail_postal ) ;
						pstmt1.setString	( 70, mail_country ) ;
						pstmt1.setString	( 71, res_country ) ;
						pstmt1.setString	( 72, locationType);
						pstmt1.setString    ( 73, resourceType);
						pstmt1.setString	( 74, name_prefix_loc_lang ) ;
						pstmt1.setString	( 75, first_name_loc_lang ) ;
						pstmt1.setString	( 76, second_name_loc_lang ) ;
						pstmt1.setString	( 77, third_name_loc_lang ) ;
						pstmt1.setString	( 78, name_suffix_loc_lang ) ;
						pstmt1.setString	( 79, family_name_loc_lang ) ;
						pstmt1.setString	( 80, patient_name_loc_lang ) ;
						pstmt1.setString	( 81, speciality_code ) ;
						pstmt1.setString	( 82, service_code ) ;
						pstmt1.setString	( 83, trans_exceed_reason_code ) ;
						/*Added by Thamizh selvi on 24th May 2017 for ML-MMOH-CRF-0610 Start*/
						pstmt1.setString	( 84, appt_added_by_id ) ;
						pstmt1.setString	( 85, appt_added_date ) ;
						/*End*/
						pstmt1.setString	( 86, other_remarks ) ; //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
						pstmt1.executeUpdate();					
					}  // End of While
				} // End of if
				if(rs!= null) rs.close() ; 
				if((primary_yn.equals("Y") || primary_yn=="Y") &&  Integer.parseInt(noofappts)>0 ) {
					pstmt2_new.setString( 1, transdat ) ;
					pstmt2_new.setString( 2, modifiedById ) ;
					pstmt2_new.setString( 3, modifiedAtWorkstation ) ;
					pstmt2_new.setString( 4, facilityId ) ;
					pstmt2_new.setString( 5, facilityId ) ;
					pstmt2_new.setString( 6, locn ) ;
					pstmt2_new.setString( 7, pract ) ;
					pstmt2_new.setString( 8, curdat ) ;
					pstmt2_new.setString( 9, locationType);
					pstmt2_new.setString( 10, resourceType);
					pstmt2_new.executeUpdate() ;
				}            
				pstmt3_new1.setString(1,facilityId);
				pstmt3_new1.setString(2,locn);
				pstmt3_new1.setString(3,transdat);
				rs3 = pstmt3_new1.executeQuery() ;
				if(rs3.next())
					sl  = rs3.getString("max");
				if(rs3 !=null) rs3.close();
				srlno3 = Integer.parseInt(sl);
				pstmt3_new2.setString( 1, transdat ) ;
				pstmt3_new2.setInt( 2, srlno3 ) ;
				pstmt3_new2.setString( 3, modifiedById ) ;
				pstmt3_new2.setString( 4, modifiedAtWorkstation ) ;
				pstmt3_new2.setString( 5, facilityId ) ;
				pstmt3_new2.setString( 6, facilityId ) ;
				pstmt3_new2.setString( 7, locn ) ;
				pstmt3_new2.setString( 8, pract ) ;
				pstmt3_new2.setString( 9, curdat ) ;
				pstmt3_new2.setString(10, locationType);
				pstmt3_new2.setString(11, resourceType);                   
				res3 = pstmt3_new2.executeUpdate() ;
				pstmt8.setString( 1, facilityId ) ;
				pstmt8.setString( 2, locn ) ;
				pstmt8.setString( 3, curdat ) ;
				pstmt8.setString( 4, pract);
				rssrlno = pstmt8.executeQuery() ;
				if(rssrlno != null){
					while(rssrlno.next()){
						sn = rssrlno.getString("srl_no");
						srl = Integer.parseInt(sn);
						pstmt9.setString(1,facilityId);
						pstmt9.setString(2,locn);
						pstmt9.setString(3,transdat);
						rs4 = pstmt9.executeQuery() ;
						if(rs4.next())
							sl  = rs4.getString("max");
						if (rs4 !=null) rs4.close();					
						srlno4 = Integer.parseInt(sl);					
						pstmt4.setString( 1, transdat ) ;
						pstmt4.setInt( 2,srlno4) ;
						pstmt4.setString( 3,transdayno);
						pstmt4.setString( 4, modifiedById ) ;
						pstmt4.setString( 5, modifiedAtWorkstation ) ;
						pstmt4.setString( 6, facilityId ) ;
						pstmt4.setString( 7, facilityId ) ;
						pstmt4.setString( 8, locn ) ;
						pstmt4.setString( 9, curdat ) ;
						pstmt4.setInt( 10, srl ) ;
						pstmt4.setString( 11, pract ) ;
						pstmt4.setString( 12, locationType);
						pstmt4.setString( 13, resourceType);
						pstmt4.executeUpdate() ;
						//con.commit();				
					} // while
				} // if
				if(rssrlno !=null) rssrlno.close();
				pstmt10.setString( 1, facilityId ) ;
				pstmt10.setString( 2,locn) ;
				pstmt10.setString( 3,curdat);
				pstmt10.setString( 4, pract ) ;
				rssrlno1 = pstmt10.executeQuery() ;
				if(rssrlno1 != null){
					while(rssrlno1.next()){
						sn1 = rssrlno1.getString("srl_no");
						srl1 = Integer.parseInt(sn1);
						pstmt5.setString( 1, facilityId ) ;
						pstmt5.setString( 2,locn) ;
						rs5 = pstmt5.executeQuery() ;
						if(rs5.next())
							sl  = rs5.getString("max");
						if(rs5 !=null) rs5.close();
						srlno5 = Integer.parseInt(sl);
						pstmt5_new.setString( 1, transdat ) ;
						pstmt5_new.setInt( 2, srlno5 ) ;
						pstmt5_new.setString( 3, modifiedById ) ;
						pstmt5_new.setString( 4, modifiedAtWorkstation ) ;
						pstmt5_new.setString( 5, facilityId ) ;
						pstmt5_new.setString( 6, facilityId ) ;
						pstmt5_new.setString( 7, locn ) ;
						pstmt5_new.setString(8, pract ) ;
						pstmt5_new.setString( 9, curdat ) ;
						pstmt5_new.setString(10, locationType);
						pstmt5_new.setString(11, resourceType);
						pstmt5_new.setInt(12, srl1);
						pstmt5_new.executeUpdate() ;						
					}
				}
				if(rssrlno1 !=null) rssrlno1.close();
				int cnt1=0;
				int cnt2=0;
				String sql6_sel="select count(*) from oa_roster_for_pract where facility_id='"+facilityId+"' and clinic_code='"+locn+"' and nvl(practitioner_id,'X')=nvl('"+pract+"','X') and on_duty_date=to_date('"+curdat+"','dd/mm/yyyy') and care_locn_type_ind ='"+locationType+"' and resource_class='"+resourceType+"'";
				rsds=stmt.executeQuery(sql6_sel);
				if(rsds !=null && rsds.next()){
					cnt1=rsds.getInt(1);
				}
				if (rsds !=null) rsds.close();
				if(cnt1 >0){
					pstmt6_del.setString( 1, facilityId ) ;
					pstmt6_del.setString( 2, locn ) ;
					pstmt6_del.setString(3, pract ) ;
					pstmt6_del.setString( 4, curdat ) ;
					pstmt6_del.setString(5, locationType);
					pstmt6_del.setString(6, resourceType);
					duty_roster_cnt1=pstmt6_del.executeUpdate();
					String sql6_sel2="select count(*) from oa_roster_for_pract where facility_id='"+facilityId+"' and clinic_code='"+locn+"' and nvl(practitioner_id,'X')=nvl('"+pract+"','X') and on_duty_date=to_date('"+transdat+"','dd/mm/yyyy') and care_locn_type_ind ='"+locationType+"' and resource_class='"+resourceType+"'";
					rsds_duty_roster3=stmt.executeQuery(sql6_sel2);
					if(rsds_duty_roster3 !=null && rsds_duty_roster3.next()){
						cnt2=rsds_duty_roster3.getInt(1);
					}
					if (rsds_duty_roster3 !=null) rsds_duty_roster3.close();
					if(!(cnt2 >0)){
						pstmt6_ins.setString( 1, facilityId ) ;
						pstmt6_ins.setString( 2, pract ) ;
						pstmt6_ins.setString( 3, locn ) ;
						pstmt6_ins.setString( 4,  transdat) ;
						pstmt6_ins.setString( 5, modifiedById ) ;
						pstmt6_ins.setDate( 6, added_date ) ;
						pstmt6_ins.setString(7, addedAtWorkstation ) ;
						pstmt6_ins.setString( 8, facilityId ) ;
						pstmt6_ins.setString(9, modifiedById);
						pstmt6_ins.setString( 10, modifiedAtWorkstation ) ;
						pstmt6_ins.setString(11, facilityId);
						pstmt6_ins.setString(12, locationType);
						pstmt6_ins.setString(13, resourceType);
						duty_roster_cnt2=pstmt6_ins.executeUpdate();
					}
				}
				pstmt11.setString( 1, facilityId ) ;
				pstmt11.setString( 2, locn ) ;
				pstmt11.setString( 3, curdayno ) ;
				pstmt11.setString( 4, pract );
				rssrlno2 = pstmt11.executeQuery();
				if(rssrlno2 != null){
					while(rssrlno2.next()){
						sn2 = rssrlno2.getString("srl_no");
						srl2 = Integer.parseInt(sn2);
						pstmt7.setString( 1, facilityId ) ;
						pstmt7.setString( 2, locn ) ;
						pstmt7.setString( 3, transdayno ) ;
						rs7 = pstmt7.executeQuery() ;
						if(rs7.next()){
							sl  = rs7.getString("max");
						}
						srlno7 = Integer.parseInt(sl);
						if (rs7 !=null) rs7.close();					
						pstmt7_new.setString( 1, transdayno ) ;
						pstmt7_new.setInt( 2,srlno7) ;
						pstmt7_new.setString( 3, modifiedById ) ;
						pstmt7_new.setString( 4, modifiedAtWorkstation ) ;
						pstmt7_new.setString( 5, facilityId ) ;
						pstmt7_new.setString( 6, facilityId ) ;
						pstmt7_new.setString( 7, locn ) ;
						pstmt7_new.setString( 8, pract ) ;
						pstmt7_new.setString( 9, curdayno ) ;
						pstmt7_new.setString(10,locationType);
						pstmt7_new.setString(11,resourceType);
						pstmt7_new.setInt(12,srl2);
						pstmt7_new.executeUpdate() ;
					}
				}
				if (rssrlno2 !=null) rssrlno2.close();
				pstmt12.setString( 1, transdat ) ;
				pstmt12.setString( 2, modifiedById ) ;
				pstmt12.setString( 3, modifiedAtWorkstation ) ;
				pstmt12.setString( 4, facilityId ) ;
				pstmt12.setString( 5, facilityId ) ;
				pstmt12.setString( 6, locn ) ;
				pstmt12.setString( 7, pract ) ;
				pstmt12.setString( 8, curdat ) ;
				pstmt12.setString(9, locationType);
				pstmt12.setString(10, resourceType);
				pstmt12.executeUpdate();
				//if(n > s){
					int srlno = 0;
					sql  = " Select nvl(max(srl_no),0)+1 max from oa_trans_record where facility_id='"+facilityId+"' ";
					rset=stmt.executeQuery(sql);
					if(rset.next())
						sl = rset.getString("max");
					srlno = Integer.parseInt(sl);				
					if (rset !=null) rset.close();
					pstmt1_new.setString(1, facilityId);
					pstmt1_new.setInt	( 2, srlno ) ;
					pstmt1_new.setString	( 3, "ST" ) ;
					pstmt1_new.setString	( 4, curdat ) ;
					pstmt1_new.setString (5,transdat);
					pstmt1_new.setString( 6, locn ) ;
					pstmt1_new.setString( 7, pract ) ;
					pstmt1_new.setString( 8, curdayno ) ;
					pstmt1_new.setString( 9, transdayno ) ;
					pstmt1_new.setString( 10, reason ) ;
					pstmt1_new.setString(11, locationType);
					pstmt1_new.setString(12, resourceType);
					pstmt1_new.executeUpdate() ;
				//}		
				if(res3 != 0 ){
					sql_operation = true ;
				}else{
					sql_operation = true ;
				}			
			}//inner while
		}//outer while
		if(sql_operation){
			result=true;
			java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_INSERTED","SM" ) ;
			sb.append( (String) message.get("message") ) ;
			con.commit();
			message.clear();
		}else{
			con.rollback();
			result=false;
			sb.append( "Error encountered while transfer 1120:" ) ;
		}
		if(rs!= null) rs.close() ;
		if(res!= null) res.close() ;
		if(rs3!= null) rs3.close() ;
		if(rssrlno!= null) rssrlno.close() ;
		if(rs4!= null) rs4.close() ;
		if(rssrlno1!= null) rssrlno1.close() ;
		if(rs5!= null) rs5.close() ;
		if(rssrlno2!= null) rssrlno2.close() ;
		if(rs7!= null) rs7.close() ;
		if(rset!= null) rset.close() ;
		if (rs2 !=null) rs2.close();
		if (rs20 !=null) rs20.close();
		if (rsds !=null) rsds.close();
		if (rsds_duty_roster3 !=null) rsds_duty_roster3.close();
		if (pstmt_3 !=null) pstmt_3.close();
		if (pstmt2_new !=null) pstmt2_new.close();
		if (pstmt3_new1 !=null) pstmt3_new1.close();
		if (pstmt3_new2 !=null) pstmt3_new2.close();		
		if(pstmt!= null) pstmt.close() ;
		if(pstmt1!= null) pstmt1.close() ;
		if(pstmt2!= null) pstmt2.close() ;
		if(pstmt3!= null) pstmt3.close() ;
		if(pstmt4!= null) pstmt4.close() ;
		if(pstmt5!= null) pstmt5.close() ;
		if(pstmt6!= null) pstmt6.close() ;
		if(pstmt7!= null) pstmt7.close() ;
		if(pstmt8!= null) pstmt8.close() ;
		if(pstmt9!= null) pstmt9.close() ;
		if(pstmt10!= null) pstmt10.close() ;
		if(pstmt14!= null) pstmt14.close() ;
		if(pstmt15!= null) pstmt15.close() ;
		if(pstmt16!= null) pstmt16.close() ;
		if (pstmt6_sel !=null) pstmt6_sel.close();
		if (pstmt6_sel2 !=null) pstmt6_sel2.close();
		if (pstmt6_del !=null) pstmt6_del.close();
		if (pstmt6_ins !=null) pstmt6_ins.close();
		if(pstmt11!= null) pstmt11.close() ;
		if (pstmt20 !=null) pstmt20.close();
		if (pstmt21 !=null) pstmt21.close();
		if (pstmt5_new !=null) pstmt5_new.close();
		if (pstmt7_new !=null) pstmt7_new.close();
		if (pstmt12 !=null) pstmt12.close();
		if (pstmt1_new !=null) pstmt1_new.close();
		if(stmt!= null) stmt.close() ;
		passObjects.clear();
	}catch (Exception ce){
		ce.printStackTrace();
		try{
			con.rollback();
			result=false;
			sb.append( "Error encountered while transfer 1177:"+ ce ) ;

		}catch(Exception ess){
			ess.printStackTrace();
		}

	}finally{	
		if (con != null) ConnectionManager.returnConnection(con,p);	       		
	}
	results.put( "status", new Boolean(result) ) ;
	results.put( "error", sb.toString() ) ;
	sb.setLength(0);
	return results ;
} //method

/**
* @ejb.interface-method
*	 view-type="both"
*/
public java.util.HashMap OAtransRec(
				java.util.Properties p,
				java.util.HashMap passObjects
			 )
{



		//Integer nbigInt=(Integer) passObjects.get("nBigInt");
		//Integer sbigInt=(Integer) passObjects.get("sBigInt");
		//String finalvals=(String) passObjects.get("finalvals1");
		String efffrom=(String) passObjects.get("efffrom");
		String effto=(String) passObjects.get("effto");
		String reason=(String) passObjects.get("reason");
		String curdayno=(String) passObjects.get("curdayno");
		String transdayno=(String) passObjects.get("transdayno");
		String fid=(String) passObjects.get("fid");
		String facilityId=(String) passObjects.get("facilityId");
		//String addedAtWorkstation=(String) passObjects.get("client_ip_address");


		//int n=nbigInt.intValue();
		//int s=sbigInt.intValue();
		StringBuffer sb = new StringBuffer( "" ) ;
		String locale = p.getProperty("LOCALE");
		

		java.util.HashMap results = new java.util.HashMap() ;

		boolean result = false ;
		
		String transcode = " ";

		try
		{
			
			con = ConnectionManager.getConnection(p);


			transcode = "ST";

			String sl = "";
			int srlno = 0;

			String sql  = " Select nvl(max(srl_no),0)+1 max from oa_trans_record where facility_id='"+facilityId+"' ";
			stmt=con.createStatement();

			rset=stmt.executeQuery(sql);
			if(rset.next())
				sl = rset.getString("max");

			srlno = Integer.parseInt(sl);

			String sql1 = " Insert into oa_trans_record (facility_id,srl_no,trans_code,trans_date_time, trans_eff_by_id, from_date_entered,to_date_entered,clinic_code,from_practitioner_id,from_day_no,to_day_no,remarks) values (?,?,?,sysdate,'"+fid+"',to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?) " ;

			pstmt1 = con.prepareStatement( sql1 );
			pstmt1.setString(1, facilityId);
			pstmt1.setInt	( 2, srlno ) ;
			pstmt1.setString	( 3, transcode ) ;
			pstmt1.setString	( 4, efffrom ) ;
			pstmt1.setString (5,effto);
			pstmt1.setString( 6, locn ) ;
			pstmt1.setString( 7, pract ) ;
			pstmt1.setString( 8, curdayno ) ;
			pstmt1.setString( 9, transdayno ) ;
			pstmt1.setString( 10, reason ) ;

			int res1 = pstmt1.executeUpdate() ;

			if ( res1!= 0 ){
				result = true ;
				java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_INSERTED","SM" ) ;
				sb.append( (String) message.get("message") ) ;
				con.rollback();
				message.clear();
			}else{
				result = false ;
				sb.append("transction failed" ) ;
				con.rollback();
			}

			if(rs!= null) rs.close() ;
			if(res!= null) res.close() ;
			
			if(rssrlno!= null) rssrlno.close() ;
			if(rs4!= null) rs4.close() ;
			if(rssrlno1!= null) rssrlno1.close() ;
			if(rs5!= null) rs5.close() ;
			if(rssrlno2!= null) rssrlno2.close() ;
			if(rs7!= null) rs7.close() ;
			if(rset!= null) rset.close() ;

			if(pstmt!= null) pstmt.close() ;
			if(pstmt1!= null) pstmt1.close() ;
			if(pstmt2!= null) pstmt2.close() ;
			if(pstmt3!= null) pstmt3.close() ;
			if(pstmt4!= null) pstmt4.close() ;
			if(pstmt5!= null) pstmt5.close() ;
			if(pstmt6!= null) pstmt6.close() ;
			if(pstmt7!= null) pstmt7.close() ;
			if(pstmt8!= null) pstmt8.close() ;
			if(pstmt9!= null) pstmt9.close() ;
			if(pstmt10!= null) pstmt10.close() ;
			if(pstmt11!= null) pstmt11.close() ;
			if(pstmt12!= null) pstmt12.close() ;
			if(pstmt13!= null) pstmt13.close() ;
			if(stmt!= null) stmt.close() ;
passObjects.clear();
		}catch ( Exception e ) {
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;
				try{
					con.rollback();
				}catch (Exception ce){
					ce.printStackTrace();
				}

		}  finally{

			  if (con != null) ConnectionManager.returnConnection(con,p);
		       		
		}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		sb.setLength(0);
		return results ;
	}
}
