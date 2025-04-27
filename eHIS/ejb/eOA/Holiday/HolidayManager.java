/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOA.Holiday;

import java.rmi.* ;
import javax.ejb.* ;

import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import java.util.StringTokenizer;
import webbeans.eCommon.*;
import com.ehis.util.*;
/**
*
* @ejb.bean
*	name="Holiday"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="Holiday"
*	local-jndi-name="Holiday"
*	impl-class-name="eOA.Holiday.HolidayManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOA.Holiday.HolidayManagerLocal"
*	remote-class="eOA.Holiday.HolidayManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOA.Holiday.HolidayManagerLocalHome"
*	remote-class="eOA.Holiday.HolidayManagerHome"
*	generate= "local,remote"
*
*
*/
public class HolidayManager implements SessionBean {
		Connection con =null;
	PreparedStatement pstmt1 =null,dupPstmt=null,dup_pstmt =null,pstmt =null;
	ResultSet rs = null,dup_res = null, rs1 = null;
	public final String CODE_ALREADY_EXISTS = "HOLIDAY_EXISTS" ;
	//public final String RECORD_MODIFIED = "RECORD_MODIFIED" ;
	//public final String RECORD_DELETED = "RECORD_DELETED" ;
	SessionContext ctx;
	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) {this.ctx=context;}
/**
* @ejb.interface-method
*	 view-type="both"
*/
public java.util.HashMap insertHoliday(java.util.Properties p,java.util.HashMap passObjects){
	String facilityId=(String) passObjects.get("facilityId");
	String addedAtWorkstation=(String) passObjects.get("client_ip_address");
	String careLocnTypeInd=(String) passObjects.get("careLocnTypeInd");
	String clinic_code=(String) passObjects.get("clinic_code");
	String fromDate=(String) passObjects.get("fromDate");
	String toDate=(String) passObjects.get("toDate");
	String holiday_reason=(String) passObjects.get("reason_for_holiday");
	int totalCount	=0;
	String service_code="";
	if(!clinic_code.equals("*A")){
		Integer totCount				= (Integer)passObjects.get("totCount");
		totalCount					= totCount.intValue();
	}
	boolean sql_operation=false;		
	java.util.HashMap results = new java.util.HashMap() ;
	boolean result = false,insertable = true  ;
	StringBuffer sb = new StringBuffer( "" ) ;
	String addedById = p.getProperty( "login_user" ) ;
	int result_val=0;
	int Totalres=0;
	int srlno = 0,sel_del_1=0,sel_del_2=0,sel_del_3=0,sel_del_4=0,sel_del_5=0;
	Statement stmt=null;
	PreparedStatement a_pstmt=null,b_pstmt=null,c_pstmt=null,d_pstmt=null,e_pstmt=null,f_pstmt=null,g_pstmt=null,h_pstmt=null,i_pstmt=null,j_pstmt=null,k_pstmt=null,l_pstmt=null,r_pstmt=null,dt_pstmt=null,cl_pstmt=null,op_pstmt=null;
	PreparedStatement pstmt=null,pstmt2=null,pstmt3=null,pstmt4=null,pstmt5=null,pstmt7=null,pstmt9=null,all_pstmt=null;
	ResultSet a_rs=null,b_rs=null,c_rs=null,rSsrl=null,rs_srl=null,rset2=null,rset=null,dt_rset=null,cl_rset=null;
	String facility="",apptrefno="",cliniccode="",practitionerid="",apptdate="",appttime="",apptslabfromtime="",apptslabtotime="",apptduration="",apptslots="",patientid="",nameprefix="",firstname="",secondname="",thirdname="",familyname="",namesuffix="",patientname="",gender="",dateofbirth="",restelno="",othcontactno="",emailid="",nationalidno="",altid1no="",resaddrline1="",resaddrline2="",resaddrline3="",resaddrline4="",postalcode="",countrycode="",appttypecode="",overbookedyn="",referralId="",contactreasoncode="",modeofcontact="",apptremarks="",inpatientyn="",encounterid="";
	String pract ="",day="",ethnic_grp_cd="",ethnic_subgrp_cd="",citizen_yn="",legal_yn="",birth_place_code="",forced_appt_yn="",global_appt_yn="",res_town="",res_area="",res_region="",res_country="",mail_addr1="",mail_addr2="",mail_addr3="",mail_addr4="",mail_town="",mail_area="",mail_postal="",mail_region="",mail_country="",sl = "",speciality_code="";
	String name_prefix_loc_lang ="";
	String	first_name_loc_lang="";
	String	second_name_loc_lang="";
	String	third_name_loc_lang="";
	String	name_suffix_loc_lang="";
	String	family_name_loc_lang="";
	String	patient_name_loc_lang="";
	String  sec_res_id="";
	String  appt_ref_no="";
	String location_Type="C";
	
	String resource_Type="P";
	
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
	String trans_exceed_reason_code="";
	/*Added by Thamizh selvi on 25th May 2017 for ML-MMOH-CRF-0610 Start*/
	String  appt_added_by_id="";
	String  appt_added_date="";
	/*End*/
	try{
		con = ConnectionManager.getConnection(p);
		stmt=con.createStatement();
		String locale = p.getProperty("LOCALE");
		String addedDate = dateFormat.format( new java.util.Date() ) ;
		String modifiedById = p.getProperty( "login_user" ) ;
		String modifiedDate = dateFormat.format( new java.util.Date() ) ;
		java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;
		String modifiedAtWorkstation = addedAtWorkstation ;
		java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
		String sql_oa_trans_record  = " Select nvl(max(srl_no),0)+1 max from oa_trans_record where facility_id=? ";
		pstmt9 = con.prepareStatement(sql_oa_trans_record);
		String sql_ins_oa_trans_record = " Insert into oa_trans_record (facility_id,srl_no,trans_code,trans_date_time, trans_eff_by_id,  from_date_entered,to_date_entered,  clinic_code,from_practitioner_id,from_day_no,remarks,reason_code,care_locn_type_ind,resource_class)  values (?,?,?,sysdate,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?) " ;
		j_pstmt = con.prepareStatement( sql_ins_oa_trans_record );

		if(!clinic_code.equals("*A")){
			String sql_oa_appt_vw = "  select appt_ref_no,VISIT_TYPE_IND  from oa_appt,op_visit_type where oa_appt.facility_id = ? and clinic_code = ? and appt_date = to_date(?,'dd/mm/yyyy') and oa_appt.APPT_TYPE_CODE=op_visit_type.VISIT_TYPE_CODE and oa_appt.FACILITY_ID=op_visit_type.FACILITY_ID";
			a_pstmt = con.prepareStatement( sql_oa_appt_vw ) ;

			String SqlSt_oa_resource_for_appt ="select facility_id,appt_ref_no,resource_class,resource_id,resource_type,to_char(appt_date,'dd/mm/yyyy') appt_date ,to_char(appt_time,'dd/mm/yyyy HH24:mi') appt_time,to_char(appt_slab_from_time,'dd/mm/yyyy HH24:mi') appt_slab_from_time,to_char(appt_slab_to_time,'dd/mm/yyyy HH24:mi') appt_slab_to_time,to_char(appt_duration,'dd/mm/yyyy HH24:mi') appt_duration,appt_slots,booking_type from oa_resource_for_appt where facility_id=? and appt_ref_no =? ";
			b_pstmt=con.prepareStatement(SqlSt_oa_resource_for_appt);
           // modified by N Munisekhar on 19-April-2013 against ML-BRU-SCF-0802[IN:039338] 
			String SqlUp_oa_clinic_schedule="update oa_clinic_schedule set  total_slots_booked  = nvl(total_slots_booked,0)-''+1+'',total_first_visit=nvl(total_first_visit,0)-decode(?,'F',''+1+'',0), TOTAL_FIRST_VISIT_SLOTS_BOOKED=nvl(TOTAL_FIRST_VISIT_SLOTS_BOOKED,0)-decode(?,'F',''+1+'',0),total_follow_up=nvl(total_follow_up,0)-decode(?,'L',''+1+'',0),total_routine=nvl(total_routine,0)-decode(?,'R',''+1+'',0),total_series=nvl(total_series,0)-decode('''+1+''','S',''+1+'',0),total_consult=nvl(total_consult,0)-decode(?,'C',''+1+'',0),total_emergency=nvl(total_emergency,0)-decode(?,'E',''+1+'',0) where facility_id = ? and clinic_code=?  and trunc(clinic_date)= to_date(?,'DD/MM/YYYY')  and resource_class=? and primary_resource_yn=? ";
			c_pstmt= con.prepareStatement(SqlUp_oa_clinic_schedule);

			String SQl_oa_resource_for_appt_del_tr = "select nvl(max(srl_no),0)+1 maxno from oa_resource_for_appt_del_tr where facility_id=? and appt_ref_no = ?";
			d_pstmt = con.prepareStatement( SQl_oa_resource_for_appt_del_tr );

			String sql_oa_resource_for_appt_del_tr ="insert into oa_resource_for_appt_del_tr (facility_id,appt_ref_no,srl_no,resource_class,resource_id,resource_type,appt_date,appt_time,appt_slab_from_time,appt_slab_to_time,appt_duration,appt_slots,booking_type,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id) values (?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),?,?, ?, sysdate, ?, ?, ?, sysdate,?,?)";
			e_pstmt = con.prepareStatement( sql_oa_resource_for_appt_del_tr );

			String sqldel_oa_resource_for_appt="delete from oa_resource_for_appt where facility_id=? and appt_ref_no=?";
			f_pstmt = con.prepareStatement(sqldel_oa_resource_for_appt);

			String sql_oa_appt =  " select facility_id, appt_ref_no, clinic_code, practitioner_id, to_char(appt_date,'dd/mm/yyyy') appt_date,  to_char(appt_time,'dd/mm/yyyy HH24:MI') appt_time,  to_char(appt_slab_from_time,'dd/mm/yyyy hh24:mi') appt_slab_from_time,to_char(appt_slab_to_time,'dd/mm/yyyy hh24:mi') appt_slab_to_time,  to_char(appt_duration,'dd/mm/yyyy hh24:mi') appt_duration, appt_slots, patient_id,name_prefix, first_name, second_name,third_name,family_name, name_suffix, patient_name, gender,to_char(date_of_birth,'dd/mm/yyyy') date_of_birth, res_tel_no,oth_contact_no, email_id,national_id_no, alt_id1_no, res_addr_line1, res_addr_line2,res_addr_line3,res_addr_line4, postal_code,country_code, appt_type_code, overbooked_yn,referral_id, contact_reason_code, mode_of_contact, appt_remarks, appt_status, inpatient_yn,  encounter_id,ETHNIC_GROUP_CODE,FORCED_APPT_YN,CITIZEN_YN,LEGAL_YN,BIRTH_PLACE_CODE,RACE_CODE,GLOBAL_APPT_YN,RES_AREA_CODE,RES_TOWN_CODE,RES_REGION_CODE,RES_COUNTRY_CODE,MAIL_ADDR_LINE1,MAIL_ADDR_LINE2,MAIL_ADDR_LINE3,MAIL_ADDR_LINE4,MAIL_AREA_CODE,MAIL_TOWN_CODE,MAIL_REGION_CODE,MAIL_POSTAL_CODE,MAIL_COUNTRY_CODE,NAME_PREFIX_LOC_LANG,FIRST_NAME_LOC_LANG,SECOND_NAME_LOC_LANG,THIRD_NAME_LOC_LANG,FAMILY_NAME_LOC_LANG,NAME_SUFFIX_LOC_LANG,PATIENT_NAME_LOC_LANG,SERVICE_CODE,trans_exceed_reason_code,added_by_id,to_char (added_date,'dd/mm/yyyy hh24:mi:ss') added_date,resource_class from oa_appt where facility_id = ? and clinic_code = ? and appt_date=to_date(?,'dd/mm/yyyy') ";//Modified by Thamizh selvi on 25th May 2017 for ML-MMOH-CRF-0610 --added_by_id, added_date & resource_class
			g_pstmt = con.prepareStatement( sql_oa_appt ) ;

			final String sql2_max_srl_no ="select nvl(max(srlno),0)+1 maxno from oa_appt_del_tr where facility_id=? and appt_ref_no=?";
			h_pstmt =con.prepareStatement(sql2_max_srl_no);
			
			String sql_op_clinic  = "select speciality_code from op_clinic where  facility_id= '"+facilityId+"' and clinic_code=?";
			op_pstmt = con.prepareStatement(sql_op_clinic) ;

			String sqlins_oa_appt_del_tr = " insert into oa_appt_del_tr( facility_id,appt_ref_no ,srlno,clinic_code ,practitioner_id ,appt_date ,appt_tr_date,appt_time ,appt_slab_from_time ,appt_slab_to_time,appt_duration,appt_slots ,patient_id  ,name_prefix,first_name  ,second_name,third_name,family_name,name_suffix ,patient_name ,gender ,date_of_birth ,res_tel_no,oth_contact_no ,email_id ,national_id_no  ,alt_id1_no,res_addr_line1 ,res_addr_line2 ,res_addr_line3,res_addr_line4 ,postal_code   ,country_code,appt_type_code,overbooked_yn,referral_id,contact_reason_code,mode_of_contact   ,appt_remarks,appt_status,inpatient_yn,encounter_id  ,added_by_id ,added_date,added_at_ws_no,added_facility_id ,modified_by_id,modified_date,modified_at_ws_no   ,modified_facility_id,ETHNIC_GROUP_CODE,FORCED_APPT_YN,CITIZEN_YN,LEGAL_YN,BIRTH_PLACE_CODE,RACE_CODE,GLOBAL_APPT_YN,RES_AREA_CODE,RES_TOWN_CODE,RES_REGION_CODE,MAIL_ADDR_LINE1,MAIL_ADDR_LINE2,MAIL_ADDR_LINE3,MAIL_ADDR_LINE4,MAIL_AREA_CODE,MAIL_TOWN_CODE,MAIL_REGION_CODE,MAIL_POSTAL_CODE,MAIL_COUNTRY_CODE,RES_COUNTRY_CODE,care_locn_type_ind,resource_class,NAME_PREFIX_LOC_LANG,FIRST_NAME_LOC_LANG,SECOND_NAME_LOC_LANG,THIRD_NAME_LOC_LANG,FAMILY_NAME_LOC_LANG,NAME_SUFFIX_LOC_LANG,PATIENT_NAME_LOC_LANG,SPECIALITY_CODE,SERVICE_CODE,trans_exceed_reason_code,appt_booked_by_id,appt_booked_date) values(?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),to_number(?),?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_number(?),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi:ss'))";//Modified by Thamizh selvi on 25th May 2017 for ML-MMOH-CRF-0610 --appt_booked_by_id,appt_booked_date
			i_pstmt = con.prepareStatement( sqlins_oa_appt_del_tr ) ;

			String sqlsel_oa_appt = "select APPT_REF_NO  from oa_appt where facility_id = ? and clinic_code =? and appt_date = to_date(?,'dd/mm/yyyy') and care_locn_type_ind= ? and resource_class =?  ";
			r_pstmt = con.prepareStatement(sqlsel_oa_appt);

			String sqldel_oa_resource_for_appt1 = "delete from oa_resource_for_appt where facility_id = ? and APPT_REF_NO =? ";
			k_pstmt= con.prepareStatement( sqldel_oa_resource_for_appt1) ;

			String sqldel_oa_clinic_schedule_slot_slab = "Update oa_clinic_schedule_slot_slab set PRI_APPT_REF_NO ='',SCHEDULE_STATUS='' where facility_id = ?  and PRI_APPT_REF_NO = ? " ;
			l_pstmt = con.prepareStatement( sqldel_oa_clinic_schedule_slot_slab) ;

			String sql2_oa_appt = " delete from oa_appt where facility_id = ?  and clinic_code = ?  and appt_date =to_date(?,'dd/mm/yyyy') /*and care_locn_type_ind= ? and resource_class = ?*/ " ; //commented care_locn_type_ind and resource_class since irrespective of both, appts for the clinic on the particular date should be deleted if declared holiday --ML-MMOH-CRF-0610
			pstmt2 = con.prepareStatement(sql2_oa_appt) ;

			String sqldel_oa_clinic_slot_slab = "delete from OA_CLINIC_SCHEDULE_SLOT_SLAB where facility_id = ? and clinic_code = ? and clinic_date = to_date(?,'dd/mm/yyyy') ";
			pstmt7  =con.prepareStatement(sqldel_oa_clinic_slot_slab);

			String sql3_del_oa_clinic_schedule = " delete from oa_clinic_schedule where facility_id = ? and clinic_code = ? and clinic_date = to_date(?,'dd/mm/yyyy')" ;
			pstmt3 = con.prepareStatement( sql3_del_oa_clinic_schedule) ;

			String sqldel_oa_clinic_schedule_break = " delete from oa_clinic_schedule_break where facility_id = ? and clinic_code = ? and clinic_date =to_date(?,'dd/mm/yyyy')  " ;
			pstmt4 = con.prepareStatement( sqldel_oa_clinic_schedule_break) ;

			String sql_del_oa_block_appt = " delete from oa_block_appt where facility_id = ? and clinic_code = ?  and  block_date =to_date(?,'dd/mm/yyyy')  " ;
			pstmt5 = con.prepareStatement( sql_del_oa_block_appt) ;
		
			String sql = "insert into 	oa_holiday(FACILITY_ID,HOLIDAY_DATE,REASON_FOR_HOLIDAY,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,CARE_LOCN_TYPE_IND,LOCN_CODE) values (?, to_date(?,'dd/mm/yyyy'), ?, ?, sysdate, ?, ?, ?, sysdate, ?,?,?,?)" ;
			pstmt = con.prepareStatement( sql );

			for(int k=0; k<totalCount; k++){
				String reason_val		=	(String)passObjects.get("chk_val"+k);
				StringTokenizer token1=new StringTokenizer(reason_val,"|");
				while(token1.hasMoreTokens()){
					String clinic1=token1.nextToken();
					String holiday_date=token1.nextToken();
					String sch_exists=token1.nextToken();
					String reason_for_holiday=token1.nextToken();

					if(sch_exists.equals("S")){
						a_pstmt.setString( 1, facilityId ) ;
						a_pstmt.setString( 2, clinic1 ) ;
						a_pstmt.setString( 3, holiday_date ) ;					
						a_rs = a_pstmt.executeQuery() ;
						String appt_ref_nos="";
						String visitind="";							
						if(a_rs != null){
							while(a_rs.next()){
								appt_ref_nos=a_rs.getString("appt_ref_no");
								visitind=a_rs.getString("VISIT_TYPE_IND");
								if(appt_ref_nos==null) appt_ref_nos="";
								if(visitind==null) visitind="";							
								if(! appt_ref_nos.equals("")){
									b_pstmt.setString( 1, facilityId ) ;
									b_pstmt.setString( 2, appt_ref_nos ) ;
									b_rs=b_pstmt.executeQuery();
									if(b_rs != null ) {
										int srl_no = 0;
										while (b_rs.next()) {
											String sec_facility_id1=b_rs.getString("facility_id");
											String sec_resource_class1=b_rs.getString("resource_class");
											String sec_resource_id1=b_rs.getString("resource_id");
											if(sec_resource_id1==null) sec_resource_id1="";
											String sec_resource_type1=b_rs.getString("resource_type");
											if(sec_resource_type1==null) sec_resource_type1="";
											String sec_appt_date1=b_rs.getString("appt_date");
											String sec_appt_time1=b_rs.getString("appt_time");
											String sec_appt_slab_from_time1=b_rs.getString("appt_slab_from_time");
											String sec_appt_slab_to_time1=b_rs.getString("appt_slab_to_time");
											String sec_appt_duration1=b_rs.getString("appt_duration");
											String sec_appt_slots1=b_rs.getString("appt_slots");
											String sec_booking_type1=b_rs.getString("booking_type");
											if(sec_appt_slots1==null) sec_appt_slots1="";
											c_pstmt.setString( 1, visitind ) ;
											c_pstmt.setString( 2, visitind ) ;
											c_pstmt.setString( 3, visitind ) ;
											c_pstmt.setString( 4, visitind ) ;
											c_pstmt.setString( 5, visitind ) ;
											c_pstmt.setString( 6, visitind ) ;	
											c_pstmt.setString( 7, facilityId ) ;
											c_pstmt.setString( 8, clinic1 ) ;
											c_pstmt.setString( 9, sec_appt_date1 ) ;
											c_pstmt.setString( 10, sec_resource_class1 ) ;
											c_pstmt.setString( 11, "N" ) ;
											c_pstmt.executeUpdate();
											srl_no = 0;
											//ResultSet rSsrl=null;
											d_pstmt.setString	( 1, facilityId ) ;
											d_pstmt.setString	( 2, appt_ref_nos ) ;
											rSsrl = d_pstmt.executeQuery();
											if(rSsrl!=null&&rSsrl.next()){
												srl_no = rSsrl.getInt("maxno");
											}										
											if (rSsrl!=null) rSsrl.close();
											e_pstmt.setString( 1, sec_facility_id1 ) ;
											e_pstmt.setString( 2, appt_ref_nos ) ;
											e_pstmt.setInt( 3, srl_no ) ;
											e_pstmt.setString( 4, sec_resource_class1 ) ;
											e_pstmt.setString( 5, sec_resource_id1 ) ;
											e_pstmt.setString( 6, sec_resource_type1 ) ;	
											e_pstmt.setString( 7, sec_appt_date1 ) ;
											e_pstmt.setString( 8, sec_appt_time1 ) ;
											e_pstmt.setString( 9, sec_appt_slab_from_time1 ) ;
											e_pstmt.setString( 10, sec_appt_slab_to_time1 ) ;
											e_pstmt.setString( 11, sec_appt_duration1 ) ;
											e_pstmt.setString( 12, sec_appt_slots1 ) ;
											e_pstmt.setString( 13, sec_booking_type1) ;
											e_pstmt.setString( 14, modifiedById ) ;
											e_pstmt.setString( 15, addedAtWorkstation ) ;
											e_pstmt.setString( 16, facilityId ) ;
											e_pstmt.setString( 17, modifiedById) ;
											e_pstmt.setString( 18, addedAtWorkstation ) ;
											e_pstmt.setString( 19, facilityId ) ;
											e_pstmt.executeUpdate() ;
										} // while
									} // if null
								} // null appt ref no
							} // loop appt ref
						}/// null apptref rs						
						g_pstmt.setString( 1, facilityId ) ;
						g_pstmt.setString( 2, clinic1 ) ;
						g_pstmt.setString( 3, holiday_date ) ;
						c_rs = g_pstmt.executeQuery() ;				
						if(c_rs != null){
							while(c_rs.next()){
								facility = c_rs.getString("facility_id");
								apptrefno = c_rs.getString("appt_ref_no");
								cliniccode = c_rs.getString("clinic_code");
								practitionerid = c_rs.getString("practitioner_id");
								if(practitionerid == null || practitionerid.equals("")) practitionerid = "";
									apptdate = c_rs.getString("appt_date");
									appttime = c_rs.getString("appt_time");
								if(appttime == null || appttime.equals("")) appttime = "";

								apptslabfromtime = c_rs.getString("appt_slab_from_time");
								if(apptslabfromtime == null || apptslabfromtime.equals("")) apptslabfromtime = "";
								apptslabtotime = c_rs.getString("appt_slab_to_time");
								if(apptslabtotime == null || apptslabtotime.equals("")) apptslabtotime = "";
								apptduration = c_rs.getString("appt_duration");
								if(apptduration == null || apptduration.equals("")) apptduration = "";
								apptslots = c_rs.getString("appt_slots");
								if(apptslots == null || apptslots.equals("")) apptslots = "";
								patientid = c_rs.getString("patient_id");
								if(patientid == null || patientid.equals(""))
									patientid = "";
								nameprefix = c_rs.getString("name_prefix");
								if(nameprefix == null || nameprefix.equals(""))
												nameprefix = "";

							firstname = c_rs.getString("first_name");
							if(firstname == null || firstname.equals(""))
											firstname = "";

							secondname = c_rs.getString("second_name");
							if(secondname == null || secondname.equals(""))
											secondname = "";

							thirdname = c_rs.getString("third_name");
							if(thirdname == null || thirdname.equals(""))
											thirdname = "";

						familyname = c_rs.getString("family_name");
						if(familyname == null || familyname.equals(""))
										familyname = "";

						namesuffix = c_rs.getString("name_suffix");
						if(namesuffix == null || namesuffix.equals(""))
										namesuffix = "";

						patientname = c_rs.getString("patient_name");
						gender = c_rs.getString("gender");
						dateofbirth = c_rs.getString("date_of_birth");
						if(dateofbirth == null || dateofbirth.equals(""))
													dateofbirth = "";

						restelno = c_rs.getString("res_tel_no");
						if(restelno == null || restelno.equals(""))
													restelno = "";

						othcontactno = c_rs.getString("oth_contact_no");
						if(othcontactno == null || othcontactno.equals(""))
													othcontactno = "";

						emailid = c_rs.getString("email_id");
						if(emailid == null || emailid.equals(""))
													emailid = "";

						nationalidno = c_rs.getString("national_id_no");
						if(nationalidno == null || nationalidno.equals(""))
													nationalidno = "";

						altid1no = c_rs.getString("alt_id1_no");
						if(altid1no == null || altid1no.equals(""))
													altid1no = "";

						resaddrline1 = c_rs.getString("res_addr_line1");
						if(resaddrline1 == null || resaddrline1.equals(""))
													resaddrline1 = "";

						resaddrline2 = c_rs.getString("res_addr_line2");
						if(resaddrline2 == null || resaddrline2.equals(""))
													resaddrline2 = "";

						resaddrline3 = c_rs.getString("res_addr_line3");
						if(resaddrline3 == null || resaddrline3.equals(""))
													resaddrline3 = "";

						resaddrline4 = c_rs.getString("res_addr_line4");
						if(resaddrline4 == null || resaddrline4.equals(""))
													resaddrline4 = "";

						postalcode = c_rs.getString("postal_code");
						if(postalcode == null || postalcode.equals(""))
													postalcode = "";

						countrycode = c_rs.getString("country_code");
						if(countrycode == null || countrycode.equals(""))
													countrycode = "";

						appttypecode = c_rs.getString("appt_type_code");
						overbookedyn= c_rs.getString("overbooked_yn");

						referralId= c_rs.getString("referral_id");
						if(referralId == null || referralId.equals(""))
																referralId = "";

						contactreasoncode = c_rs.getString("contact_reason_code");
						modeofcontact = c_rs.getString("mode_of_contact");
						if(modeofcontact == null || modeofcontact.equals(""))
																modeofcontact = "";

						apptremarks = c_rs.getString("appt_remarks");
						if(apptremarks == null || apptremarks.equals(""))
																apptremarks = "";

						inpatientyn = c_rs.getString("inpatient_yn");
						encounterid = c_rs.getString("encounter_id");
						if(encounterid == null || encounterid.equals(""))
																encounterid = "";

									ethnic_grp_cd=c_rs.getString("ETHNIC_GROUP_CODE");
							if(ethnic_grp_cd==null) ethnic_grp_cd="";
						ethnic_subgrp_cd=c_rs.getString("RACE_CODE");
							if(ethnic_subgrp_cd==null) ethnic_subgrp_cd="";
						citizen_yn=c_rs.getString("CITIZEN_YN");
							if(citizen_yn==null) citizen_yn="N";
						legal_yn=c_rs.getString("LEGAL_YN");
							if(legal_yn==null) legal_yn="N";
						birth_place_code=c_rs.getString("BIRTH_PLACE_CODE");
							if(birth_place_code==null) birth_place_code="";

						forced_appt_yn=c_rs.getString("FORCED_APPT_YN");
							if(forced_appt_yn==null) forced_appt_yn="N";
						global_appt_yn=c_rs.getString("GLOBAL_APPT_YN");
							if(global_appt_yn==null) global_appt_yn="N";

						res_town=c_rs.getString("RES_TOWN_CODE");
						if(res_town==null) res_town="";
						res_area=c_rs.getString("RES_AREA_CODE");
						if(res_area==null) res_area="";
						res_region=c_rs.getString("RES_REGION_CODE");
						if(res_region==null) res_region="";
						res_country=c_rs.getString("RES_COUNTRY_CODE");
						if(res_country==null) res_country="";
						mail_addr1=c_rs.getString("MAIL_ADDR_LINE1");
						if(mail_addr1==null) mail_addr1="";
						mail_addr2=c_rs.getString("MAIL_ADDR_LINE2");
						if(mail_addr2==null) mail_addr2="";
						mail_addr3=c_rs.getString("MAIL_ADDR_LINE3");
						if(mail_addr3==null) mail_addr3="";
						mail_addr4=c_rs.getString("MAIL_ADDR_LINE4");
						if(mail_addr4==null) mail_addr4="";
						mail_town=c_rs.getString("MAIL_TOWN_CODE");
						if(mail_town==null) mail_town="";
						mail_area=c_rs.getString("MAIL_AREA_CODE");
						if(mail_area==null) mail_area="";
						mail_postal=c_rs.getString("MAIL_POSTAL_CODE");
						if(mail_postal==null) mail_postal="";
						mail_region=c_rs.getString("MAIL_REGION_CODE");
						if(mail_region==null) mail_region="";
						mail_country=c_rs.getString("MAIL_COUNTRY_CODE");
						if(mail_country==null) mail_country="";
						service_code=c_rs.getString("SERVICE_CODE");
						if(service_code==null) service_code="";
						name_prefix_loc_lang=c_rs.getString("NAME_PREFIX_LOC_LANG")==null?"":c_rs.getString("NAME_PREFIX_LOC_LANG");
						

						first_name_loc_lang=c_rs.getString("FIRST_NAME_LOC_LANG")==null?"":c_rs.getString("FIRST_NAME_LOC_LANG");
						

						second_name_loc_lang=c_rs.getString("SECOND_NAME_LOC_LANG")==null?"":c_rs.getString("SECOND_NAME_LOC_LANG");
					

						third_name_loc_lang=c_rs.getString("THIRD_NAME_LOC_LANG")==null?"":c_rs.getString("THIRD_NAME_LOC_LANG");
						

						name_suffix_loc_lang=c_rs.getString("NAME_SUFFIX_LOC_LANG")==null?"":c_rs.getString("NAME_SUFFIX_LOC_LANG");
						family_name_loc_lang=c_rs.getString("FAMILY_NAME_LOC_LANG")==null?"":c_rs.getString("FAMILY_NAME_LOC_LANG");
						patient_name_loc_lang=c_rs.getString("PATIENT_NAME_LOC_LANG")==null?"":c_rs.getString("PATIENT_NAME_LOC_LANG");	
						trans_exceed_reason_code=c_rs.getString("trans_exceed_reason_code")==null?"":c_rs.getString("trans_exceed_reason_code");	
						/*Added by Thamizh selvi on 25th May 2017 for ML-MMOH-CRF-0610 Start*/
						appt_added_by_id=c_rs.getString("added_by_id")==null?"":c_rs.getString("added_by_id");
						appt_added_date=c_rs.getString("added_date")==null?"":c_rs.getString("added_date");
						resource_Type=c_rs.getString("resource_class")==null?"":c_rs.getString("resource_class");
						/*End*/


						int srl_no = 0;
						h_pstmt.setString(1, facility) ;
						h_pstmt.setString(2, apptrefno);
						rs_srl=h_pstmt.executeQuery();
						if (rs_srl.next() && rs_srl != null ) {
						srl_no=rs_srl.getInt("maxno");
						}  
						//if(rs_srl!=null)rs_srl.cose() //checklist
						op_pstmt.setString( 1, cliniccode  ) ;
					rs   = op_pstmt.executeQuery();
					if(rs!=null && rs.next())
						{
						speciality_code=rs.getString("speciality_code");
						if(speciality_code ==null) speciality_code="";
						}
						

						i_pstmt.setString( 1, facility ) ;
						i_pstmt.setString( 2, apptrefno  ) ;
						i_pstmt.setInt( 3, srl_no  ) ;
						i_pstmt.setString( 4, cliniccode  ) ;
						i_pstmt.setString( 5, practitionerid  ) ;
						i_pstmt.setString( 6, apptdate  ) ;
						i_pstmt.setString( 7, ""  ) ;
						i_pstmt.setString( 8, appttime  ) ;
						i_pstmt.setString( 9, apptslabfromtime  ) ;
						i_pstmt.setString( 10, apptslabtotime  ) ;
						i_pstmt.setString( 11, apptduration  ) ;
						i_pstmt.setString( 12, apptslots  ) ;
						i_pstmt.setString( 13, patientid  ) ;
						i_pstmt.setString( 14, nameprefix  ) ;
						i_pstmt.setString( 15, firstname  ) ;
						i_pstmt.setString( 16, secondname  ) ;
						i_pstmt.setString( 17, thirdname  ) ;
						i_pstmt.setString( 18, familyname  ) ;
						i_pstmt.setString( 19, namesuffix  ) ;
						i_pstmt.setString( 20, patientname  ) ;
						i_pstmt.setString( 21, gender  ) ;
						i_pstmt.setString( 22, dateofbirth  ) ;
						i_pstmt.setString( 23, restelno  ) ;
						i_pstmt.setString( 24, othcontactno  ) ;
						i_pstmt.setString( 25, emailid  ) ;
						i_pstmt.setString( 26, nationalidno  ) ;
						i_pstmt.setString( 27, altid1no  ) ;
						i_pstmt.setString( 28, resaddrline1  ) ;
						i_pstmt.setString( 29, resaddrline2  ) ;
						i_pstmt.setString( 30, resaddrline3  ) ;
						i_pstmt.setString( 31, resaddrline4  ) ;
						i_pstmt.setString( 32, postalcode  ) ;
						i_pstmt.setString( 33, countrycode  ) ;
						i_pstmt.setString( 34, appttypecode  ) ;
						i_pstmt.setString( 35, overbookedyn  ) ;
						i_pstmt.setString( 36, referralId  ) ;
						i_pstmt.setString( 37, contactreasoncode  ) ;
						i_pstmt.setString( 38, modeofcontact  ) ;
						i_pstmt.setString( 39, apptremarks  ) ;
						i_pstmt.setString( 40, "S" ) ;
						i_pstmt.setString( 41, inpatientyn  ) ;
						i_pstmt.setString( 42, encounterid ) ;
						i_pstmt.setString( 43, modifiedById ) ;
						i_pstmt.setDate( 44, added_date ) ;
						i_pstmt.setString( 45, addedAtWorkstation ) ;
						i_pstmt.setString( 46, facilityId ) ;
						i_pstmt.setString( 47, modifiedById ) ;
						i_pstmt.setDate( 48,  modified_date) ;
						i_pstmt.setString( 49, modifiedAtWorkstation ) ;
						i_pstmt.setString( 50, facilityId ) ;
						i_pstmt.setString	( 51, ethnic_grp_cd ) ;
						i_pstmt.setString	( 52, forced_appt_yn ) ;
						i_pstmt.setString	( 53, citizen_yn ) ;
						i_pstmt.setString	( 54, legal_yn ) ;
						i_pstmt.setString	( 55, birth_place_code ) ;
						i_pstmt.setString	( 56, ethnic_subgrp_cd ) ;
						i_pstmt.setString	( 57, global_appt_yn ) ;
						i_pstmt.setString	( 58, res_area ) ;
						i_pstmt.setString	( 59, res_town ) ;
						i_pstmt.setString	( 60, res_region ) ;
						i_pstmt.setString	( 61, mail_addr1 ) ;
						i_pstmt.setString	( 62, mail_addr2 ) ;
						i_pstmt.setString	( 63, mail_addr3 ) ;
						i_pstmt.setString	( 64, mail_addr4 ) ;
						i_pstmt.setString	( 65, mail_area ) ;
						i_pstmt.setString	( 66, mail_town ) ;
						i_pstmt.setString	( 67, mail_region ) ;
						i_pstmt.setString	( 68, mail_postal ) ;
						i_pstmt.setString	( 69, mail_country ) ;
						i_pstmt.setString	( 70, res_country ) ;
						i_pstmt.setString	( 71, location_Type ) ;
						i_pstmt.setString	( 72, resource_Type ) ;
						i_pstmt.setString	( 73, name_prefix_loc_lang ) ;
						i_pstmt.setString	( 74, first_name_loc_lang ) ;
						i_pstmt.setString	( 75, second_name_loc_lang ) ;
						i_pstmt.setString	( 76, third_name_loc_lang ) ;
						i_pstmt.setString	( 77, name_suffix_loc_lang ) ;
						i_pstmt.setString	( 78, family_name_loc_lang ) ;
						i_pstmt.setString	( 79, patient_name_loc_lang ) ;
						i_pstmt.setString	( 80, speciality_code ) ;
						i_pstmt.setString	( 81, service_code ) ;
						i_pstmt.setString	( 82, trans_exceed_reason_code ) ;
						/*Added by Thamizh selvi on 25th May 2017 for ML-MMOH-CRF-0610 Start*/
						i_pstmt.setString	( 83, appt_added_by_id ) ;
						i_pstmt.setString	( 84, appt_added_date ) ;
						/*End*/
						i_pstmt.executeUpdate() ;

					}
				}if(c_rs!=null)c_rs.close();
				if(rs!=null) rs.close(); //checklist


			String prisecappt="select RESOURCE_ID , appt_ref_no from oa_resource_for_appt where facility_id='"+facilityId+"' AND appt_ref_no in (select pri_appt_ref_no from oa_clinic_schedule_slot_slab where facility_id='"+facilityId+"' and CLINIC_CODE='"+clinic1+"' and  CLINIC_DATE=to_date('"+holiday_date+"','dd/mm/yyyy'))";
			
			rs=stmt.executeQuery(prisecappt);
			

			if(rs !=null) {
			while (rs.next())
			{
				sec_res_id = rs.getString("RESOURCE_ID");
				if(sec_res_id ==null) sec_res_id="";
				appt_ref_no= rs.getString("appt_ref_no");
				if(appt_ref_no ==null) appt_ref_no="";
			

		if(!sec_res_id.equals(""))
			{
			

		pstmt3.setString(1,facilityId);
		pstmt3.setString(2,clinic1);
		pstmt3.setString(3,holiday_date);
		
		sel_del_1= pstmt3.executeUpdate();


		pstmt4.setString(1,facilityId);
		pstmt4.setString(2,clinic1);
		pstmt4.setString(3,holiday_date);
		
		sel_del_2= pstmt4.executeUpdate();



		pstmt5.setString(1,facilityId);
		pstmt5.setString(2,clinic1);
		pstmt5.setString(3,holiday_date);
		
		sel_del_3= pstmt5.executeUpdate();

		pstmt7.setString(1,facilityId);
		pstmt7.setString(2,clinic1);
		pstmt7.setString(3,holiday_date);

		sel_del_4= pstmt7.executeUpdate();


		f_pstmt.setString( 1, facilityId ) ;
		f_pstmt.setString( 2, appt_ref_no ) ;
		sel_del_5= f_pstmt.executeUpdate() ;

			}
			}if(rs!=null) rs.close(); //checklist

		}
				r_pstmt.setString	( 1, facilityId ) ;
				r_pstmt.setString	( 2, clinic1 ) ;
				r_pstmt.setString	( 3, holiday_date ) ;
				r_pstmt.setString	( 4, location_Type ) ;
				r_pstmt.setString	( 5, resource_Type ) ;
				rset2 =r_pstmt.executeQuery();
				
				String apptno = "";
			if(rset2 !=null){
				while(rset2.next()){
						apptno = rset2.getString("APPT_REF_NO");
						k_pstmt.setString( 1, facilityId ) ;
						k_pstmt.setString( 2, apptno ) ;
						k_pstmt.executeUpdate() ;
						l_pstmt.setString( 1, facilityId ) ;
						l_pstmt.setString( 2, apptno ) ;
						l_pstmt.executeUpdate() ;
					}
					if(rset2!=null) rset2.close();
				}
				pstmt2.setString( 1, facilityId ) ;
				pstmt2.setString( 2, clinic1 ) ;
				pstmt2.setString( 3, holiday_date ) ;
				//pstmt2.setString( 4, location_Type ) ;
				//pstmt2.setString( 5, resource_Type ) ;	
				pstmt2.executeUpdate() ;
					
				pstmt7.setString(1 , facilityId);
				pstmt7.setString(2 , clinic1);
				pstmt7.setString(3 , holiday_date);
			
				pstmt7.executeUpdate() ;

				pstmt3.setString( 1, facilityId ) ;
				pstmt3.setString( 2, clinic1 ) ;
				pstmt3.setString( 3, holiday_date ) ;
				pstmt3.executeUpdate() ;

				/*m_pstmt.setString( 1, facilityId ) ;
				m_pstmt.setString( 2, clinic1 ) ;
				m_pstmt.setString( 3, pract ) ;
				m_pstmt.setString( 4, holiday_date ) ;
				m_pstmt.setString( 5, location_Type ) ;
				m_pstmt.setString( 6, resource_Type ) ;
				m_pstmt.executeUpdate() ;*/

				pstmt4.setString( 1, facilityId ) ;
				pstmt4.setString( 2, clinic1 ) ;
				pstmt4.setString( 3, holiday_date ) ;
				pstmt4.executeUpdate() ;

				pstmt5.setString( 1, facilityId ) ;
				pstmt5.setString( 2, clinic1 ) ;
				pstmt5.setString( 3, holiday_date ) ;
				
				int res5 = pstmt5.executeUpdate() ;
				
				//String fid="";
				//int n=1;
				//int s=1;
					//if(n > s){
					//String sl = "";
					//int srlno = 0;
					/*pstmt9.setString( 1, facilityId ) ;
					rset=pstmt9.executeQuery();
					if(rset.next())
						sl = rset.getString("max");
					srlno = Integer.parseInt(sl);

					sql_ins_oa_trans_record = " Insert into oa_trans_record (facility_id,srl_no,trans_code,trans_date_time, trans_eff_by_id,  from_date_entered,to_date_entered,  clinic_code,from_practitioner_id,from_day_no,remarks,reason_code,care_locn_type_ind,resource_class)  values (?,?,?,sysdate,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?) " ;
					j_pstmt.setString(1, facilityId);
					j_pstmt.setInt	( 2, srlno ) ;
					//j_pstmt.setString	( 3, "SC" ) ;
					j_pstmt.setString	( 3, "HC" ) ;
					j_pstmt.setString	( 4,fid );
					j_pstmt.setString	( 5, holiday_date ) ;
					j_pstmt.setString (6,holiday_date);
					j_pstmt.setString( 7, clinic1 ) ;
					j_pstmt.setString( 8, pract ) ;
					j_pstmt.setString( 9, day ) ;
					j_pstmt.setString( 10, "" ) ;
					j_pstmt.setString( 11, reason_for_holiday ) ;
					j_pstmt.setString( 12, location_Type ) ;
					j_pstmt.setString( 13, resource_Type ) ;
				    j_pstmt.executeUpdate() ;*/
				//}
				
				if ( res5 != 0 ){
					sql_operation = true ;
				}else{
					sql_operation = true ;
				}


				}

					//holiday_date=DateUtils.convertDate(holiday_date,"DMY",locale,"en");
					
					
					pstmt.setString	(1,	facilityId );
					pstmt.setString	(2,	holiday_date );
					pstmt.setString	(3,	reason_for_holiday );
					pstmt.setString	(4, addedById );
					pstmt.setString	(5, addedAtWorkstation );
					pstmt.setString	(6, facilityId );
					pstmt.setString	(7, addedById );
					pstmt.setString	(8, addedAtWorkstation );
					pstmt.setString	(9, facilityId );
					pstmt.setString	(10,careLocnTypeInd );
					pstmt.setString	(11,clinic1 );
					result_val	= pstmt.executeUpdate() ;
					Totalres+=result_val;
					pstmt9.setString( 1, facilityId ) ;
					rset=pstmt9.executeQuery();

					if(rset.next())
						sl = rset.getString("max");
					srlno = Integer.parseInt(sl);

					j_pstmt.setString(1, facilityId);
					j_pstmt.setInt	( 2, srlno ) ;
					//j_pstmt.setString	( 3, "SC" ) ;
					j_pstmt.setString	( 3, "HC" ) ;
					j_pstmt.setString	( 4,addedById);
					j_pstmt.setString	( 5, holiday_date ) ;
					j_pstmt.setString (6,holiday_date);
					j_pstmt.setString( 7, clinic1 ) ;
					j_pstmt.setString( 8, pract ) ;
					j_pstmt.setString( 9, day ) ;
					j_pstmt.setString( 10, reason_for_holiday ) ;
					//j_pstmt.setString( 11, reason_for_holiday ) ;
					j_pstmt.setString( 11, "" ) ;
					j_pstmt.setString( 12, location_Type ) ;
					j_pstmt.setString( 13, resource_Type ) ;
				    j_pstmt.executeUpdate() ;
					
					if(rset!=null)rset.close();//checklist
			}
			
			}
	if(pstmt2!=null)pstmt2.close();//checklist		
	}else
	{
	       //Added for this CRF  HSA-CRF-0184 linked incident IN054284 
	        String location_type="";
			if(careLocnTypeInd.equals("D")){
			  location_type="Y";
			}else{
			  location_type=careLocnTypeInd;
			}
			//End this CRF  HSA-CRF-0184linked incident IN054284 
		
			String insert_sql = "insert into 	oa_holiday(FACILITY_ID,HOLIDAY_DATE,REASON_FOR_HOLIDAY,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,CARE_LOCN_TYPE_IND,LOCN_CODE) values (?, to_date(?,'dd/mm/yyyy'), ?, ?, sysdate, ?, ?, ?, sysdate, ?,?,?,?)" ;

			String date_sql="select to_char(date_value,'dd/mm/yyyy')sqldate    from (select to_date('"+fromDate+"','dd/mm/yyyy')-1+rownum date_value from dual connect by rownum-1<=(Trunc(to_date('"+toDate+"','dd/mm/yyyy'))-Trunc(to_date('"+fromDate+"','dd/mm/yyyy'))))";
            //Below query modified for this CRF  HSA-CRF-0184 linked incident IN054284 
			String clinic_sql="Select a.clinic_code clinic_code,care_locn_type_ind,primary_resource_class from op_clinic_lang_vw a  where    LANGUAGE_ID = '"+locale+"'  AND a.clinic_code not in (select locn_code   from oa_holiday where facility_id='"+facilityId+"' )    and a.facility_id='"+facilityId+"' and a.EFF_STATUS='E'    and a.level_of_care_ind = 'A'   and a.ALLOW_APPT_YN='Y' and a.level_of_care_ind = 'A' AND a.clinic_type='"+location_type+"' AND a.CARE_LOCN_TYPE_IND='"+careLocnTypeInd+"'";
						
			cl_pstmt = con.prepareStatement( clinic_sql );
			
			
			
			String clinic_sql_all="";
			String date_sql_all="";
			String care_locn_type_ind="";
			String primary_resource_class="";
			int holidaycount=0;
			all_pstmt = con.prepareStatement( insert_sql );	//Added for this incident [54556]

			cl_rset=cl_pstmt.executeQuery() ;			
			while(cl_rset!=null && cl_rset.next()){
				clinic_sql_all=cl_rset.getString("clinic_code");
				care_locn_type_ind=cl_rset.getString("care_locn_type_ind");
				primary_resource_class=cl_rset.getString("primary_resource_class");
			
				dt_pstmt = con.prepareStatement( date_sql );
				dt_rset  = dt_pstmt.executeQuery() ;
				while(dt_rset!=null && dt_rset.next()){ 
						date_sql_all=dt_rset.getString("sqldate");  
						//all_pstmt = con.prepareStatement( insert_sql );	//commented incident [54556]				
						all_pstmt.setString	(1,	facilityId );
						all_pstmt.setString	(2,	date_sql_all );
						all_pstmt.setString	(3,	holiday_reason );
						all_pstmt.setString	(4, addedById );
						all_pstmt.setString	(5, addedAtWorkstation );
						all_pstmt.setString	(6, facilityId );
						all_pstmt.setString	(7, addedById );
						all_pstmt.setString	(8, addedAtWorkstation );
						all_pstmt.setString	(9, facilityId );
						all_pstmt.setString	(10,careLocnTypeInd );
						all_pstmt.setString	(11,clinic_sql_all );
						all_pstmt.addBatch();  
						//below line commented above line Added for this incident [54556]						
						/*result_val	= all_pstmt.executeUpdate() ;
						Totalres+=result_val;*/
						
						
						//int n=1;
						//int s=1;
						//String fid="";
						//sql_ins_oa_trans_record = " Insert into oa_trans_record (facility_id,srl_no,trans_code,trans_date_time, trans_eff_by_id,  from_date_entered,to_date_entered,  clinic_code,from_practitioner_id,from_day_no,remarks,reason_code,care_locn_type_ind,resource_class)  values (?,?,?,sysdate,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?) " ;
						pstmt9.setString( 1, facilityId ) ;
						rset=pstmt9.executeQuery();
						if(rset.next()){ 
						sl = rset.getString("max");
						srlno = Integer.parseInt(sl);
						j_pstmt.setString(1, facilityId);
						j_pstmt.setInt	( 2, srlno ) ;
						//j_pstmt.setString	( 3, "SC" ) ;
						j_pstmt.setString	( 3, "HC" ) ;
						j_pstmt.setString	( 4,addedById );
						j_pstmt.setString	( 5, date_sql_all ) ;
						j_pstmt.setString (6,date_sql_all);
						j_pstmt.setString( 7, clinic_sql_all ) ;
						j_pstmt.setString( 8, "" ) ;
						j_pstmt.setString( 9, "" ) ;
						j_pstmt.setString( 10, holiday_reason ) ;
						j_pstmt.setString( 11, "" ) ;
						j_pstmt.setString( 12, care_locn_type_ind ) ;
						j_pstmt.setString( 13, primary_resource_class ) ;
						j_pstmt.executeUpdate() ;
					}if(rset!=null) rset.close(); //checklist
					
				  holidaycount++;
				} 
				
				if(dt_rset!=null)dt_rset.close();
				//if(rset!=null) rset.close(); //checklist
				if(dt_pstmt!=null)dt_pstmt.close();//checklist
				
				
			}
			//Added for this incident [54556]
				int[] resultsholday=all_pstmt.executeBatch(); 				
				if(holidaycount == resultsholday.length&&resultsholday.length>0)Totalres=resultsholday.length;
							
				
			//End incident [54556]
			
			if(all_pstmt!=null) all_pstmt.close();

			if(dt_pstmt!=null)
				dt_pstmt.close();
			if(cl_rset!=null)
				cl_rset.close();
			if(cl_pstmt!=null)
				cl_pstmt.close();

	}
		if (Totalres > 0){
					insertable=true;
				}else{
					insertable=false;
				}
			if ( insertable )	{
				result = true ;
				java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_MODIFIED","SM" ) ;
				sb.append( (String) message.get("message") ) ;
				con.commit();
				message.clear();
			}else
			{
				con.rollback();
			}
		
	
	if(pstmt!= null) pstmt.close() ;
	passObjects.clear();
  }catch(Exception ex){	
		sb.append( "Transaction failed " + ex ) ;
		ex.printStackTrace();
	 }finally{
		 try{
		     
             
			
		     if(pstmt9!=null)pstmt9.close(); //checklist
             if(j_pstmt!=null)j_pstmt.close();	
             if(op_pstmt!=null)op_pstmt.close();
             if(i_pstmt!=null)i_pstmt.close(); 
			 if(r_pstmt!=null)r_pstmt.close();
			 if(k_pstmt!=null)k_pstmt.close();
			 if(l_pstmt!=null)l_pstmt.close();
			 if(pstmt7!=null)pstmt7.close(); 
			 if(pstmt3!=null)pstmt3.close();
			 if(pstmt4!=null)pstmt4.close();
			 if(pstmt5!=null)pstmt5.close();
			 
			 if(stmt!=null)stmt.close();
			 if(a_pstmt!=null)a_pstmt.close();
			 if(b_pstmt!=null)b_pstmt.close();
			 if(c_pstmt!=null)c_pstmt.close();
			 if(d_pstmt!=null)d_pstmt.close();
			 if(e_pstmt!=null)e_pstmt.close();
			 if(f_pstmt!=null)f_pstmt.close();
			 if(g_pstmt!=null)g_pstmt.close();
			 if(h_pstmt!=null)h_pstmt.close();
		 }catch(Exception exception){
			 exception.printStackTrace();
		 }
		if(con!=null) ConnectionManager.returnConnection(con,p);
	}
	results.put( "status", new Boolean(result) ) ;
	results.put( "error", sb.toString() ) ;
	sb.setLength(0);
	return results;
} 
/**
* @ejb.interface-method
*	 view-type="both"
*/
public java.util.HashMap insertlocntypeHoliday(java.util.Properties p,
java.util.HashMap passObjects
) 
{
		String facilityId=(String) passObjects.get("facilityId");
		String addedAtWorkstation=(String) passObjects.get("client_ip_address");
		String careLocnTypeInd=(String) passObjects.get("careLocnTypeInd");
		String reason_for_holiday=(String) passObjects.get("reason_for_holiday");
		String clinic_code=(String) passObjects.get("clinic_code");
		String fromDate=(String) passObjects.get("fromDate");
		String toDate=(String) passObjects.get("toDate");


		int totalCount=0;
	    /*Integer totCount				= (Integer)passObjects.get("totCount");
		 int totalCount					= totCount.intValue();*/
		String locale = p.getProperty("LOCALE");
		boolean sql_operation=false;
		java.util.HashMap results = new java.util.HashMap() ;
		boolean result = false,insertable = true  ;
		StringBuffer sb = new StringBuffer( "" ) ;
		String addedById = p.getProperty( "login_user" ) ;
		int result_val=0;
		int Totalres=0;
		int srlno = 0,sel_del_1=0,sel_del_2=0,sel_del_3=0,sel_del_4=0,sel_del_5=0;
	Statement stmt=null;
	PreparedStatement a_pstmt=null,b_pstmt=null,c_pstmt=null,d_pstmt=null,e_pstmt=null,f_pstmt=null,g_pstmt=null,h_pstmt=null,i_pstmt=null,j_pstmt=null,k_pstmt=null,l_pstmt=null,r_pstmt=null;
	PreparedStatement pstmt=null,pstmt2=null,pstmt3=null,pstmt4=null,pstmt5=null,pstmt7=null,pstmt9=null,cl_pstmt=null,all_pstmt=null,op_pstmt=null;
	ResultSet a_rs=null,b_rs=null,c_rs=null,rSsrl=null,rs_srl=null,rset2=null,rset=null,cl_rset=null,op_rs=null;
	String facility="",apptrefno="",cliniccode="",practitionerid="",apptdate="",appttime="",apptslabfromtime="",apptslabtotime="",apptduration="",apptslots="",patientid="",nameprefix="",firstname="",secondname="",thirdname="",familyname="",namesuffix="",patientname="",gender="",dateofbirth="",restelno="",othcontactno="",emailid="",nationalidno="",altid1no="",resaddrline1="",resaddrline2="",resaddrline3="",resaddrline4="",postalcode="",countrycode="",appttypecode="",overbookedyn="",referralId="",contactreasoncode="",modeofcontact="",apptremarks="",inpatientyn="",encounterid="",speciality_code="";
	String pract ="",day="",ethnic_grp_cd="",ethnic_subgrp_cd="",citizen_yn="",legal_yn="",birth_place_code="",forced_appt_yn="",global_appt_yn="",res_town="",res_area="",res_region="",res_country="",mail_addr1="",mail_addr2="",mail_addr3="",mail_addr4="",mail_town="",mail_area="",mail_postal="",mail_region="",mail_country="",sl = "";
	String name_prefix_loc_lang ="";
	String	first_name_loc_lang="";
	String	second_name_loc_lang="";
	String	third_name_loc_lang="";
	String	name_suffix_loc_lang="";
	String	family_name_loc_lang="";
	String	patient_name_loc_lang="";
	String  sec_res_id="";
	String  appt_ref_no="";
	String location_Type="C";

	String resource_Type="P";
	
	String service_code="";
	String trans_exceed_reason_code="";
	/*Added by Thamizh selvi on 24th May 2017 for ML-MMOH-CRF-0610 Start*/
	String  appt_added_by_id="";
	String  appt_added_date="";
	/*End*/
	//StringBuffer sb = new StringBuffer( "" ) ;

	if(!clinic_code.equals("*A")){
	    Integer totCount				= (Integer)passObjects.get("totCount");
		  totalCount					= totCount.intValue();
	}
java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
	try{
			con = ConnectionManager.getConnection(p);
			//stmt=con.createStatement(); //checklist
		String addedDate = dateFormat.format( new java.util.Date() ) ;
		String modifiedById = p.getProperty( "login_user" ) ;
		String modifiedDate = dateFormat.format( new java.util.Date() ) ;
		java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;
		String modifiedAtWorkstation = addedAtWorkstation ;
		java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;

		String sql_oa_trans_record  = " Select nvl(max(srl_no),0)+1 max from oa_trans_record where facility_id=? ";
		//pstmt9 = con.prepareStatement(sql_oa_trans_record); //checklist commented

		String sql_ins_oa_trans_record = " Insert into oa_trans_record (facility_id,srl_no,trans_code,trans_date_time, trans_eff_by_id,  from_date_entered,to_date_entered,  clinic_code,from_practitioner_id,from_day_no,remarks,reason_code,care_locn_type_ind,resource_class)  values (?,?,?,sysdate,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?) " ;
		//j_pstmt = con.prepareStatement( sql_ins_oa_trans_record ); //checklist commented

		if(!clinic_code.equals("*A")){
		String sql_oa_appt_vw = "  select appt_ref_no,VISIT_TYPE_IND  from oa_appt,op_visit_type where oa_appt.facility_id = ? and clinic_code = ? and appt_date = to_date(?,'dd/mm/yyyy') and oa_appt.APPT_TYPE_CODE=op_visit_type.VISIT_TYPE_CODE and oa_appt.FACILITY_ID=op_visit_type.FACILITY_ID";
		a_pstmt = con.prepareStatement( sql_oa_appt_vw ) ; 

		String SqlSt_oa_resource_for_appt ="select facility_id,appt_ref_no,resource_class,resource_id,resource_type,to_char(appt_date,'dd/mm/yyyy') appt_date ,to_char(appt_time,'dd/mm/yyyy HH24:mi') appt_time,to_char(appt_slab_from_time,'dd/mm/yyyy HH24:mi') appt_slab_from_time,to_char(appt_slab_to_time,'dd/mm/yyyy HH24:mi') appt_slab_to_time,to_char(appt_duration,'dd/mm/yyyy HH24:mi') appt_duration,appt_slots,booking_type from oa_resource_for_appt where facility_id=? and appt_ref_no =? ";
		b_pstmt=con.prepareStatement(SqlSt_oa_resource_for_appt); 
         // modified by N Munisekhar on 19-April-2013 against ML-BRU-SCF-0802[IN:039338] 
		String SqlUp_oa_clinic_schedule="update oa_clinic_schedule set  total_slots_booked  = nvl(total_slots_booked,0)-''+1+'',total_first_visit=nvl(total_first_visit,0)-decode(?,'F',''+1+'',0), TOTAL_FIRST_VISIT_SLOTS_BOOKED=nvl(TOTAL_FIRST_VISIT_SLOTS_BOOKED,0)-decode(?,'F',''+1+'',0),total_follow_up=nvl(total_follow_up,0)-decode(?,'L',''+1+'',0),total_routine=nvl(total_routine,0)-decode(?,'R',''+1+'',0),total_series=nvl(total_series,0)-decode('''+1+''','S',''+1+'',0),total_consult=nvl(total_consult,0)-decode(?,'C',''+1+'',0),total_emergency=nvl(total_emergency,0)-decode(?,'E',''+1+'',0) where facility_id = ? and clinic_code=?  and trunc(clinic_date)= to_date(?,'DD/MM/YYYY')  and resource_class=? and primary_resource_yn=? ";
		c_pstmt= con.prepareStatement(SqlUp_oa_clinic_schedule); 

		String SQl_oa_resource_for_appt_del_tr = "select nvl(max(srl_no),0)+1 maxno from oa_resource_for_appt_del_tr where facility_id=? and appt_ref_no = ?";
		d_pstmt = con.prepareStatement( SQl_oa_resource_for_appt_del_tr );  

		String sql_oa_resource_for_appt_del_tr ="insert into oa_resource_for_appt_del_tr (facility_id,appt_ref_no,srl_no,resource_class,resource_id,resource_type,appt_date,appt_time,appt_slab_from_time,appt_slab_to_time,appt_duration,appt_slots,booking_type,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id) values (?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),?,?, ?, sysdate, ?, ?, ?, sysdate,?,?)";
		e_pstmt = con.prepareStatement( sql_oa_resource_for_appt_del_tr ); 

		String sqldel_oa_resource_for_appt="delete from oa_resource_for_appt where facility_id=? and appt_ref_no=?";
		f_pstmt = con.prepareStatement(sqldel_oa_resource_for_appt); 


		String sql_oa_appt =  " select facility_id, appt_ref_no, clinic_code, practitioner_id, to_char(appt_date,'dd/mm/yyyy') appt_date,  to_char(appt_time,'dd/mm/yyyy HH24:MI') appt_time,  to_char(appt_slab_from_time,'dd/mm/yyyy hh24:mi') appt_slab_from_time,to_char(appt_slab_to_time,'dd/mm/yyyy hh24:mi') appt_slab_to_time,  to_char(appt_duration,'dd/mm/yyyy hh24:mi') appt_duration, appt_slots, patient_id,name_prefix, first_name, second_name,third_name,family_name, name_suffix, patient_name, gender,to_char(date_of_birth,'dd/mm/yyyy') date_of_birth, res_tel_no,oth_contact_no, email_id,national_id_no, alt_id1_no, res_addr_line1, res_addr_line2,res_addr_line3,res_addr_line4, postal_code,country_code, appt_type_code, overbooked_yn,referral_id, contact_reason_code, mode_of_contact, appt_remarks, appt_status, inpatient_yn,  encounter_id,ETHNIC_GROUP_CODE,FORCED_APPT_YN,CITIZEN_YN,LEGAL_YN,BIRTH_PLACE_CODE,RACE_CODE,GLOBAL_APPT_YN,RES_AREA_CODE,RES_TOWN_CODE,RES_REGION_CODE,RES_COUNTRY_CODE,MAIL_ADDR_LINE1,MAIL_ADDR_LINE2,MAIL_ADDR_LINE3,MAIL_ADDR_LINE4,MAIL_AREA_CODE,MAIL_TOWN_CODE,MAIL_REGION_CODE,MAIL_POSTAL_CODE,MAIL_COUNTRY_CODE,NAME_PREFIX_LOC_LANG,FIRST_NAME_LOC_LANG,SECOND_NAME_LOC_LANG,THIRD_NAME_LOC_LANG,FAMILY_NAME_LOC_LANG,NAME_SUFFIX_LOC_LANG,PATIENT_NAME_LOC_LANG,SERVICE_CODE,trans_exceed_reason_code,added_by_id,to_char (added_date,'dd/mm/yyyy hh24:mi:ss') added_date, resource_class  from oa_appt where facility_id = ? and clinic_code = ? and appt_date=to_date(?,'dd/mm/yyyy') ";//Modified by Thamizh selvi on 24th May 2017 for ML-MMOH-CRF-0610 --added_by_id, added_date & resource_class
		g_pstmt = con.prepareStatement( sql_oa_appt ) ;

		final String sql2_max_srl_no ="select nvl(max(srlno),0)+1 maxno from oa_appt_del_tr where facility_id=? and appt_ref_no=?";
		h_pstmt =con.prepareStatement(sql2_max_srl_no); 

		String sql_op_clinic  = "select speciality_code from op_clinic where  facility_id= '"+facilityId+"' and clinic_code=?";
		op_pstmt = con.prepareStatement(sql_op_clinic) ;  
		
		String sqlins_oa_appt_del_tr = " insert into oa_appt_del_tr( facility_id,appt_ref_no ,srlno,clinic_code ,practitioner_id ,appt_date ,appt_tr_date,appt_time ,appt_slab_from_time ,appt_slab_to_time,appt_duration,appt_slots ,patient_id  ,name_prefix,first_name  ,second_name,third_name,family_name,name_suffix ,patient_name ,gender ,date_of_birth ,res_tel_no,oth_contact_no ,email_id ,national_id_no  ,alt_id1_no,res_addr_line1 ,res_addr_line2 ,res_addr_line3,res_addr_line4 ,postal_code   ,country_code,appt_type_code,overbooked_yn,referral_id,contact_reason_code,mode_of_contact   ,appt_remarks,appt_status,inpatient_yn,encounter_id  ,added_by_id ,added_date,added_at_ws_no,added_facility_id ,modified_by_id,modified_date,modified_at_ws_no   ,modified_facility_id,ETHNIC_GROUP_CODE,FORCED_APPT_YN,CITIZEN_YN,LEGAL_YN,BIRTH_PLACE_CODE,RACE_CODE,GLOBAL_APPT_YN,RES_AREA_CODE,RES_TOWN_CODE,RES_REGION_CODE,MAIL_ADDR_LINE1,MAIL_ADDR_LINE2,MAIL_ADDR_LINE3,MAIL_ADDR_LINE4,MAIL_AREA_CODE,MAIL_TOWN_CODE,MAIL_REGION_CODE,MAIL_POSTAL_CODE,MAIL_COUNTRY_CODE,RES_COUNTRY_CODE,care_locn_type_ind,resource_class,NAME_PREFIX_LOC_LANG,FIRST_NAME_LOC_LANG,SECOND_NAME_LOC_LANG,THIRD_NAME_LOC_LANG,FAMILY_NAME_LOC_LANG,NAME_SUFFIX_LOC_LANG,PATIENT_NAME_LOC_LANG,SPECIALITY_CODE,SERVICE_CODE,trans_exceed_reason_code,appt_booked_by_id,appt_booked_date) values(?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),to_number(?),?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_number(?),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi:ss'))";//Modified by Thamizh selvi on 24th May 2017 for ML-MMOH-CRF-0610 --appt_booked_by_id,appt_booked_date
		i_pstmt = con.prepareStatement( sqlins_oa_appt_del_tr ) ;


		String sqlsel_oa_appt = "select APPT_REF_NO  from oa_appt where facility_id = ? and clinic_code =? and appt_date = to_date(?,'dd/mm/yyyy') and care_locn_type_ind= ? and resource_class =?  ";
		r_pstmt = con.prepareStatement(sqlsel_oa_appt); 

		String sqldel_oa_resource_for_appt1 = "delete from oa_resource_for_appt where facility_id = ? and APPT_REF_NO =? ";
		k_pstmt= con.prepareStatement( sqldel_oa_resource_for_appt1) ; 

		String sqldel_oa_clinic_schedule_slot_slab = "Update oa_clinic_schedule_slot_slab set PRI_APPT_REF_NO ='',SCHEDULE_STATUS='' where facility_id = ?  and PRI_APPT_REF_NO = ? " ;
		l_pstmt = con.prepareStatement( sqldel_oa_clinic_schedule_slot_slab) ; 

		String sql2_oa_appt = " delete from oa_appt where facility_id = ?  and clinic_code = ?  and appt_date =to_date(?,'dd/mm/yyyy') /*and care_locn_type_ind= ? and resource_class = ?*/ " ; //commented care_locn_type_ind and resource_class since irrespective of both, appts for the clinic on the particular date should be deleted if declared holiday --ML-MMOH-CRF-0610
		pstmt2 = con.prepareStatement(sql2_oa_appt) ;  

		String sqldel_oa_clinic_slot_slab = "delete from OA_CLINIC_SCHEDULE_SLOT_SLAB where facility_id = ? and clinic_code = ? and clinic_date = to_date(?,'dd/mm/yyyy') ";
		pstmt7  =con.prepareStatement(sqldel_oa_clinic_slot_slab);  


		String sql3_del_oa_clinic_schedule = " delete from oa_clinic_schedule where facility_id = ? and clinic_code = ? and clinic_date = to_date(?,'dd/mm/yyyy')" ;
		pstmt3 = con.prepareStatement( sql3_del_oa_clinic_schedule) ; 

		String sqldel_oa_clinic_schedule_break = " delete from oa_clinic_schedule_break where facility_id = ? and clinic_code = ? and clinic_date =to_date(?,'dd/mm/yyyy')  " ;
		pstmt4 = con.prepareStatement( sqldel_oa_clinic_schedule_break) ; 

		String sql_del_oa_block_appt = " delete from oa_block_appt where facility_id = ? and clinic_code = ?  and  block_date =to_date(?,'dd/mm/yyyy')  " ;
		pstmt5 = con.prepareStatement( sql_del_oa_block_appt) ;	


		


			try
			{

			String sql = "insert into 	oa_holiday(FACILITY_ID,HOLIDAY_DATE,REASON_FOR_HOLIDAY,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,CARE_LOCN_TYPE_IND,LOCN_CODE) values (?, to_date(?,'dd/mm/yyyy'), ?, ?, sysdate, ?, ?, ?, sysdate, ?,?,?,?)" ;
			pstmt = con.prepareStatement( sql );
			
			for(int k=0; k<totalCount; k++)
			{
				String reason_val		=	(String)passObjects.get("chk_val"+k);
				

			StringTokenizer token1=new StringTokenizer(reason_val,"|");
			while(token1.hasMoreTokens()){
					String locn=token1.nextToken();
					String dat=token1.nextToken();
					String sch_exists=token1.nextToken();

			
				if(sch_exists.equals("S"))
				{
				   	a_pstmt.setString( 1, facilityId ) ;
					a_pstmt.setString( 2, locn ) ;
					a_pstmt.setString( 3, dat ) ;
					a_rs = a_pstmt.executeQuery() ;
					String appt_ref_nos="";
					String visitind="";
					//Below line commented by N Munisekhar on 15-April-2013 against ML-BRU-SCF-0802[IN:039338] 
                   // if(a_pstmt!=null) a_pstmt.close();
					
					if(a_rs != null){ 
						while(a_rs.next()){
							appt_ref_nos=a_rs.getString("appt_ref_no");
							visitind=a_rs.getString("VISIT_TYPE_IND");
							if(appt_ref_nos==null) appt_ref_nos="";
							if(visitind==null) visitind=""; 	
							if(! appt_ref_nos.equals("")){
								b_pstmt.setString( 1, facilityId ) ;
								b_pstmt.setString( 2, appt_ref_nos ) ;
								b_rs=b_pstmt.executeQuery();
								if(b_rs != null ) {
									int srl_no = 0;
									while (b_rs.next()) {
										String sec_facility_id1=b_rs.getString("facility_id");
										String sec_resource_class1=b_rs.getString("resource_class");
										String sec_resource_id1=b_rs.getString("resource_id");
										if(sec_resource_id1==null) sec_resource_id1="";
										String sec_resource_type1=b_rs.getString("resource_type");
										if(sec_resource_type1==null) sec_resource_type1="";
										String sec_appt_date1=b_rs.getString("appt_date");
										String sec_appt_time1=b_rs.getString("appt_time");
										String sec_appt_slab_from_time1=b_rs.getString("appt_slab_from_time");
										String sec_appt_slab_to_time1=b_rs.getString("appt_slab_to_time");
										String sec_appt_duration1=b_rs.getString("appt_duration");
										String sec_appt_slots1=b_rs.getString("appt_slots");
										String sec_booking_type1=b_rs.getString("booking_type");
										if(sec_appt_slots1==null) sec_appt_slots1="";
										c_pstmt.setString( 1, visitind ) ;
										c_pstmt.setString( 2, visitind ) ;
										c_pstmt.setString( 3, visitind ) ;
										c_pstmt.setString( 4, visitind ) ;
										c_pstmt.setString( 5, visitind ) ;
										c_pstmt.setString( 6, visitind ) ;	
										c_pstmt.setString( 7, facilityId ) ;
										c_pstmt.setString( 8, locn ) ;
										c_pstmt.setString( 9, sec_appt_date1 ) ;
										c_pstmt.setString( 10, sec_resource_class1 ) ;
										c_pstmt.setString( 11, "N" ) ;
										c_pstmt.executeUpdate();
										srl_no = 0;
										//ResultSet rSsrl=null;
										d_pstmt.setString	( 1, facilityId ) ;
										d_pstmt.setString	( 2, appt_ref_nos ) ;
										rSsrl = d_pstmt.executeQuery();
										if(rSsrl!=null&&rSsrl.next()){
										 srl_no = rSsrl.getInt("maxno");
										}
										//commented by N Munisekhar on 19-April-2013 against ML-BRU-SCF-0802[IN:039338]
										//if (rSsrl!=null) rSsrl.close();
										//if (d_pstmt!=null) d_pstmt.close();  //checklist
										e_pstmt.setString( 1, sec_facility_id1 ) ;
										e_pstmt.setString( 2, appt_ref_nos ) ;
										e_pstmt.setInt( 3, srl_no ) ;
										e_pstmt.setString( 4, sec_resource_class1 ) ;
										e_pstmt.setString( 5, sec_resource_id1 ) ;
										e_pstmt.setString( 6, sec_resource_type1 ) ;	
										e_pstmt.setString( 7, sec_appt_date1 ) ;
										e_pstmt.setString( 8, sec_appt_time1 ) ;
										e_pstmt.setString( 9, sec_appt_slab_from_time1 ) ;
										e_pstmt.setString( 10, sec_appt_slab_to_time1 ) ;
										e_pstmt.setString( 11, sec_appt_duration1 ) ;
										e_pstmt.setString( 12, sec_appt_slots1 ) ;
										e_pstmt.setString( 13, sec_booking_type1) ;
										e_pstmt.setString( 14, modifiedById ) ;
										e_pstmt.setString( 15, addedAtWorkstation ) ;
										e_pstmt.setString( 16, facilityId ) ;
										e_pstmt.setString( 17, modifiedById) ;
										e_pstmt.setString( 18, addedAtWorkstation ) ;
										e_pstmt.setString( 19, facilityId ) ;
										e_pstmt.executeUpdate() ;
									} // while
									// commented by N Munisekhar on 19-April-2013 against ML-BRU-SCF-0802[IN:039338] 
									//if(e_pstmt!=null) e_pstmt.close();
									//if(c_pstmt !=null)c_pstmt.close();
								} // if null
								// commented by N Munisekhar on 19-April-2013 against ML-BRU-SCF-0802[IN:039338] 
								//if(b_rs!=null)b_rs.close();
								//if(b_pstmt !=null)b_pstmt.close();

							} // null appt ref no
						} // loop appt ref
						//if(a_rs!=null)a_rs.close(); //checklist	
					}/// null apptref rs
					// added by N Munisekhar on 19-April-2013 against ML-BRU-SCF-0802[IN:039338] 
					if(a_rs!=null)a_rs.close();	
					if(b_rs!=null)b_rs.close();
					if (rSsrl!=null) rSsrl.close();
					
					
				g_pstmt.setString( 1, facilityId ) ;
				g_pstmt.setString( 2, locn ) ;
				g_pstmt.setString( 3, dat ) ;
				c_rs = g_pstmt.executeQuery() ;
if(c_rs != null){
					while(c_rs.next()){

						facility = c_rs.getString("facility_id");
						apptrefno = c_rs.getString("appt_ref_no");
						cliniccode = c_rs.getString("clinic_code");
						practitionerid = c_rs.getString("practitioner_id");
					if(practitionerid == null || practitionerid.equals("")) practitionerid = "";
						apptdate = c_rs.getString("appt_date");
						appttime = c_rs.getString("appt_time");
					if(appttime == null || appttime.equals("")) appttime = "";

						apptslabfromtime = c_rs.getString("appt_slab_from_time");
					if(apptslabfromtime == null || apptslabfromtime.equals("")) apptslabfromtime = "";
							apptslabtotime = c_rs.getString("appt_slab_to_time");
					if(apptslabtotime == null || apptslabtotime.equals("")) apptslabtotime = "";
						apptduration = c_rs.getString("appt_duration");
					if(apptduration == null || apptduration.equals("")) apptduration = "";
						apptslots = c_rs.getString("appt_slots");
					if(apptslots == null || apptslots.equals("")) apptslots = "";
					patientid = c_rs.getString("patient_id");
						if(patientid == null || patientid.equals(""))
										patientid = "";
						nameprefix = c_rs.getString("name_prefix");
						if(nameprefix == null || nameprefix.equals(""))
										nameprefix = "";

						firstname = c_rs.getString("first_name");
						if(firstname == null || firstname.equals(""))
										firstname = "";

						secondname = c_rs.getString("second_name");
						if(secondname == null || secondname.equals(""))
										secondname = "";

						thirdname = c_rs.getString("third_name");
						if(thirdname == null || thirdname.equals(""))
										thirdname = "";

						familyname = c_rs.getString("family_name");
						if(familyname == null || familyname.equals(""))
										familyname = "";

						namesuffix = c_rs.getString("name_suffix");
						if(namesuffix == null || namesuffix.equals(""))
										namesuffix = "";

						patientname = c_rs.getString("patient_name");
						gender = c_rs.getString("gender");
						dateofbirth = c_rs.getString("date_of_birth");
						if(dateofbirth == null || dateofbirth.equals(""))
													dateofbirth = "";

						restelno = c_rs.getString("res_tel_no");
						if(restelno == null || restelno.equals(""))
													restelno = "";

						othcontactno = c_rs.getString("oth_contact_no");
						if(othcontactno == null || othcontactno.equals(""))
													othcontactno = "";

						emailid = c_rs.getString("email_id");
						if(emailid == null || emailid.equals(""))
													emailid = "";

						nationalidno = c_rs.getString("national_id_no");
						if(nationalidno == null || nationalidno.equals(""))
													nationalidno = "";

						altid1no = c_rs.getString("alt_id1_no");
						if(altid1no == null || altid1no.equals(""))
													altid1no = "";

						resaddrline1 = c_rs.getString("res_addr_line1");
						if(resaddrline1 == null || resaddrline1.equals(""))
													resaddrline1 = "";

						resaddrline2 = c_rs.getString("res_addr_line2");
						if(resaddrline2 == null || resaddrline2.equals(""))
													resaddrline2 = "";

						resaddrline3 = c_rs.getString("res_addr_line3");
						if(resaddrline3 == null || resaddrline3.equals(""))
													resaddrline3 = "";

						resaddrline4 = c_rs.getString("res_addr_line4");
						if(resaddrline4 == null || resaddrline4.equals(""))
													resaddrline4 = "";

						postalcode = c_rs.getString("postal_code");
						if(postalcode == null || postalcode.equals(""))
													postalcode = "";

						countrycode = c_rs.getString("country_code");
						if(countrycode == null || countrycode.equals(""))
													countrycode = "";

						appttypecode = c_rs.getString("appt_type_code");
						overbookedyn= c_rs.getString("overbooked_yn");

						referralId= c_rs.getString("referral_id");
						if(referralId == null || referralId.equals(""))
																referralId = "";

						contactreasoncode = c_rs.getString("contact_reason_code");
						modeofcontact = c_rs.getString("mode_of_contact");
						if(modeofcontact == null || modeofcontact.equals(""))
																modeofcontact = "";

						apptremarks = c_rs.getString("appt_remarks");
						if(apptremarks == null || apptremarks.equals(""))
																apptremarks = "";

						inpatientyn = c_rs.getString("inpatient_yn");
						encounterid = c_rs.getString("encounter_id");
						if(encounterid == null || encounterid.equals(""))
																encounterid = "";

									ethnic_grp_cd=c_rs.getString("ETHNIC_GROUP_CODE");
							if(ethnic_grp_cd==null) ethnic_grp_cd="";
						ethnic_subgrp_cd=c_rs.getString("RACE_CODE");
							if(ethnic_subgrp_cd==null) ethnic_subgrp_cd="";
						citizen_yn=c_rs.getString("CITIZEN_YN");
							if(citizen_yn==null) citizen_yn="N";
						legal_yn=c_rs.getString("LEGAL_YN");
							if(legal_yn==null) legal_yn="N";
						birth_place_code=c_rs.getString("BIRTH_PLACE_CODE");
							if(birth_place_code==null) birth_place_code="";

						forced_appt_yn=c_rs.getString("FORCED_APPT_YN");
							if(forced_appt_yn==null) forced_appt_yn="N";
						global_appt_yn=c_rs.getString("GLOBAL_APPT_YN");
							if(global_appt_yn==null) global_appt_yn="N";

						res_town=c_rs.getString("RES_TOWN_CODE");
						if(res_town==null) res_town="";
						res_area=c_rs.getString("RES_AREA_CODE");
						if(res_area==null) res_area="";
						res_region=c_rs.getString("RES_REGION_CODE");
						if(res_region==null) res_region="";
						res_country=c_rs.getString("RES_COUNTRY_CODE");
						if(res_country==null) res_country="";
						mail_addr1=c_rs.getString("MAIL_ADDR_LINE1");
						if(mail_addr1==null) mail_addr1="";
						mail_addr2=c_rs.getString("MAIL_ADDR_LINE2");
						if(mail_addr2==null) mail_addr2="";
						mail_addr3=c_rs.getString("MAIL_ADDR_LINE3");
						if(mail_addr3==null) mail_addr3="";
						mail_addr4=c_rs.getString("MAIL_ADDR_LINE4");
						if(mail_addr4==null) mail_addr4="";
						mail_town=c_rs.getString("MAIL_TOWN_CODE");
						if(mail_town==null) mail_town="";
						mail_area=c_rs.getString("MAIL_AREA_CODE");
						if(mail_area==null) mail_area="";
						mail_postal=c_rs.getString("MAIL_POSTAL_CODE");
						if(mail_postal==null) mail_postal="";
						mail_region=c_rs.getString("MAIL_REGION_CODE");
						if(mail_region==null) mail_region="";
						mail_country=c_rs.getString("MAIL_COUNTRY_CODE");
						if(mail_country==null) mail_country="";
						service_code=c_rs.getString("SERVICE_CODE");
						if(service_code==null) service_code="";
						name_prefix_loc_lang=c_rs.getString("NAME_PREFIX_LOC_LANG")==null?"":c_rs.getString("NAME_PREFIX_LOC_LANG");
						

						first_name_loc_lang=c_rs.getString("FIRST_NAME_LOC_LANG")==null?"":c_rs.getString("FIRST_NAME_LOC_LANG");
						

						second_name_loc_lang=c_rs.getString("SECOND_NAME_LOC_LANG")==null?"":c_rs.getString("SECOND_NAME_LOC_LANG");
					

						third_name_loc_lang=c_rs.getString("THIRD_NAME_LOC_LANG")==null?"":c_rs.getString("THIRD_NAME_LOC_LANG");
						

						name_suffix_loc_lang=c_rs.getString("NAME_SUFFIX_LOC_LANG")==null?"":c_rs.getString("NAME_SUFFIX_LOC_LANG");
						family_name_loc_lang=c_rs.getString("FAMILY_NAME_LOC_LANG")==null?"":c_rs.getString("FAMILY_NAME_LOC_LANG");
						patient_name_loc_lang=c_rs.getString("PATIENT_NAME_LOC_LANG")==null?"":c_rs.getString("PATIENT_NAME_LOC_LANG");	
						trans_exceed_reason_code=c_rs.getString("trans_exceed_reason_code")==null?"":c_rs.getString("trans_exceed_reason_code");	
						/*Added by Thamizh selvi on 24th May 2017 for ML-MMOH-CRF-0610 Start*/
						appt_added_by_id=c_rs.getString("added_by_id")==null?"":c_rs.getString("added_by_id");
						appt_added_date=c_rs.getString("added_date")==null?"":c_rs.getString("added_date");
						resource_Type=c_rs.getString("resource_class")==null?"":c_rs.getString("resource_class");
						/*End*/


						int srl_no = 0;
						h_pstmt.setString(1, facility) ;
						h_pstmt.setString(2, apptrefno);
						rs_srl=h_pstmt.executeQuery();
						if (rs_srl.next() && rs_srl != null ) {
						srl_no=rs_srl.getInt("maxno");
						}
						if(rs_srl!=null) rs_srl.close(); //checklist
						// commented by N Munisekhar on 19-April-2013 against ML-BRU-SCF-0802[IN:039338] 
						//if(h_pstmt!=null) h_pstmt.close(); //checklist 

						op_pstmt.setString( 1, cliniccode  ) ;
						op_rs   = op_pstmt.executeQuery();
						if(op_rs!=null && op_rs.next())
						{
						speciality_code=op_rs.getString("speciality_code");
						if(speciality_code ==null) speciality_code="";
						}
                        if(op_rs!=null) op_rs.close(); //checklist 
						i_pstmt.setString( 1, facility ) ;
						i_pstmt.setString( 2, apptrefno  ) ;
						i_pstmt.setInt( 3, srl_no  ) ;
						i_pstmt.setString( 4, cliniccode  ) ;
						i_pstmt.setString( 5, practitionerid  ) ;
						i_pstmt.setString( 6, apptdate  ) ;
						i_pstmt.setString( 7, ""  ) ;
						i_pstmt.setString( 8, appttime  ) ;
						i_pstmt.setString( 9, apptslabfromtime  ) ;
						i_pstmt.setString( 10, apptslabtotime  ) ;
						i_pstmt.setString( 11, apptduration  ) ;
						i_pstmt.setString( 12, apptslots  ) ;
						i_pstmt.setString( 13, patientid  ) ;
						i_pstmt.setString( 14, nameprefix  ) ;
						i_pstmt.setString( 15, firstname  ) ;
						i_pstmt.setString( 16, secondname  ) ;
						i_pstmt.setString( 17, thirdname  ) ;
						i_pstmt.setString( 18, familyname  ) ;
						i_pstmt.setString( 19, namesuffix  ) ;
						i_pstmt.setString( 20, patientname  ) ;
						i_pstmt.setString( 21, gender  ) ;
						i_pstmt.setString( 22, dateofbirth  ) ;
						i_pstmt.setString( 23, restelno  ) ;
						i_pstmt.setString( 24, othcontactno  ) ;
						i_pstmt.setString( 25, emailid  ) ;
						i_pstmt.setString( 26, nationalidno  ) ;
						i_pstmt.setString( 27, altid1no  ) ;
						i_pstmt.setString( 28, resaddrline1  ) ;
						i_pstmt.setString( 29, resaddrline2  ) ;
						i_pstmt.setString( 30, resaddrline3  ) ;
						i_pstmt.setString( 31, resaddrline4  ) ;
						i_pstmt.setString( 32, postalcode  ) ;
						i_pstmt.setString( 33, countrycode  ) ;
						i_pstmt.setString( 34, appttypecode  ) ;
						i_pstmt.setString( 35, overbookedyn  ) ;
						i_pstmt.setString( 36, referralId  ) ;
						i_pstmt.setString( 37, contactreasoncode  ) ;
						i_pstmt.setString( 38, modeofcontact  ) ;
						i_pstmt.setString( 39, apptremarks  ) ;
						i_pstmt.setString( 40, "S" ) ;
						i_pstmt.setString( 41, inpatientyn  ) ;
						i_pstmt.setString( 42, encounterid ) ;
						i_pstmt.setString( 43, modifiedById ) ;
						i_pstmt.setDate( 44, added_date ) ;
						i_pstmt.setString( 45, addedAtWorkstation ) ;
						i_pstmt.setString( 46, facilityId ) ;
						i_pstmt.setString( 47, modifiedById ) ;
						i_pstmt.setDate( 48,  modified_date) ;
						i_pstmt.setString( 49, modifiedAtWorkstation ) ;
						i_pstmt.setString( 50, facilityId ) ;
						i_pstmt.setString	( 51, ethnic_grp_cd ) ;
						i_pstmt.setString	( 52, forced_appt_yn ) ;
						i_pstmt.setString	( 53, citizen_yn ) ;
						i_pstmt.setString	( 54, legal_yn ) ;
						i_pstmt.setString	( 55, birth_place_code ) ;
						i_pstmt.setString	( 56, ethnic_subgrp_cd ) ;
						i_pstmt.setString	( 57, global_appt_yn ) ;
						i_pstmt.setString	( 58, res_area ) ;
						i_pstmt.setString	( 59, res_town ) ;
						i_pstmt.setString	( 60, res_region ) ;
						i_pstmt.setString	( 61, mail_addr1 ) ;
						i_pstmt.setString	( 62, mail_addr2 ) ;
						i_pstmt.setString	( 63, mail_addr3 ) ;
						i_pstmt.setString	( 64, mail_addr4 ) ;
						i_pstmt.setString	( 65, mail_area ) ;
						i_pstmt.setString	( 66, mail_town ) ;
						i_pstmt.setString	( 67, mail_region ) ;
						i_pstmt.setString	( 68, mail_postal ) ;
						i_pstmt.setString	( 69, mail_country ) ;
						i_pstmt.setString	( 70, res_country ) ;
						i_pstmt.setString	( 71, location_Type ) ;
						i_pstmt.setString	( 72, resource_Type ) ;
						i_pstmt.setString	( 73, name_prefix_loc_lang ) ;
						i_pstmt.setString	( 74, first_name_loc_lang ) ;
						i_pstmt.setString	( 75, second_name_loc_lang ) ;
						i_pstmt.setString	( 76, third_name_loc_lang ) ;
						i_pstmt.setString	( 77, name_suffix_loc_lang ) ;
						i_pstmt.setString	( 78, family_name_loc_lang ) ;
						i_pstmt.setString	( 79, patient_name_loc_lang ) ;
						i_pstmt.setString	( 80, speciality_code ) ;
						i_pstmt.setString	( 81, service_code ) ;
						i_pstmt.setString	( 82, trans_exceed_reason_code ) ;
						/*Added by Thamizh selvi on 24th May 2017 for ML-MMOH-CRF-0610 Start*/
						i_pstmt.setString	( 83, appt_added_by_id ) ;
						i_pstmt.setString	( 84, appt_added_date ) ;
						/*End*/
						i_pstmt.executeUpdate() ;
					} 
				}
				// commented by N Munisekhar on 19-April-2013 against ML-BRU-SCF-0802[IN:039338]
				//if(a_pstmt!=null)a_pstmt.close(); //checklist	
				if(c_rs!=null)c_rs.close(); //checklist
				//if(stmt!=null)stmt.close();//checklist
				//if(g_pstmt!=null) g_pstmt.close(); //checklist
				//if(op_pstmt!=null) op_pstmt.close(); //checklist
				//if(i_pstmt!=null) i_pstmt.close(); //checklist
				

			String prisecappt="select RESOURCE_ID , appt_ref_no from oa_resource_for_appt where facility_id='"+facilityId+"' AND appt_ref_no in (select pri_appt_ref_no from oa_clinic_schedule_slot_slab where facility_id='"+facilityId+"' and CLINIC_CODE='"+locn+"' and  CLINIC_DATE=to_date('"+dat+"','dd/mm/yyyy'))";
			stmt=con.createStatement();
			rs=stmt.executeQuery(prisecappt);
              
			if(rs !=null) {
			while (rs.next())
			{
				sec_res_id = rs.getString("RESOURCE_ID");
				if(sec_res_id ==null) sec_res_id="";
				appt_ref_no= rs.getString("appt_ref_no");
				if(appt_ref_no ==null) appt_ref_no="";
			
		if(!sec_res_id.equals(""))
			{
			

		pstmt3.setString(1,facilityId);
		pstmt3.setString(2,locn);
		pstmt3.setString(3,dat);
		
		sel_del_1= pstmt3.executeUpdate();


		pstmt4.setString(1,facilityId);
		pstmt4.setString(2,locn);
		pstmt4.setString(3,dat);
		
		sel_del_2= pstmt4.executeUpdate();



		pstmt5.setString(1,facilityId);
		pstmt5.setString(2,locn);
		pstmt5.setString(3,dat);
		
		sel_del_3= pstmt5.executeUpdate();

		pstmt7.setString(1,facilityId);
		pstmt7.setString(2,locn);
		pstmt7.setString(3,dat);

		sel_del_4= pstmt7.executeUpdate();


		f_pstmt.setString( 1, facilityId ) ;
		f_pstmt.setString( 2, appt_ref_no ) ;
		sel_del_5= f_pstmt.executeUpdate() ;

			}
			}
			// commented by N Munisekhar on 19-April-2013 against ML-BRU-SCF-0802[IN:039338] 
			//if(f_pstmt!=null)f_pstmt.close(); //checklist
			if(stmt!=null)stmt.close(); //checklist
			if(rs!=null) rs.close();
			
		}
				r_pstmt.setString	( 1, facilityId ) ;
				r_pstmt.setString	( 2, locn ) ;
				r_pstmt.setString	( 3, dat ) ;
				r_pstmt.setString	( 4, location_Type ) ;
				r_pstmt.setString	( 5, resource_Type ) ;
				rset2 =r_pstmt.executeQuery();
				String apptno = "";
			if(rset2 !=null){
				while(rset2.next()){
						apptno = rset2.getString("APPT_REF_NO");
						k_pstmt.setString( 1, facilityId ) ;
						k_pstmt.setString( 2, apptno ) ;
						k_pstmt.executeUpdate() ;
						l_pstmt.setString( 1, facilityId ) ;
						l_pstmt.setString( 2, apptno ) ;
						l_pstmt.executeUpdate() ;
					}
					if(rset2!=null) rset2.close(); //checklist
				}
				pstmt2.setString( 1, facilityId ) ;
				pstmt2.setString( 2, locn ) ;
				pstmt2.setString( 3, dat ) ;
				//pstmt2.setString( 4, location_Type ) ;
				//pstmt2.setString( 5, resource_Type ) ;	
				pstmt2.executeUpdate() ;
					
				pstmt7.setString(1 , facilityId);
				pstmt7.setString(2 , locn);
				pstmt7.setString(3 , dat);
			
				pstmt7.executeUpdate() ;

				pstmt3.setString( 1, facilityId ) ;
				pstmt3.setString( 2, locn ) ;
				pstmt3.setString( 3, dat ) ;
				pstmt3.executeUpdate() ;

				/*m_pstmt.setString( 1, facilityId ) ;
				m_pstmt.setString( 2, locn ) ;
				m_pstmt.setString( 3, pract ) ;
				m_pstmt.setString( 4, dat ) ;
				m_pstmt.setString( 5, location_Type ) ;
				m_pstmt.setString( 6, resource_Type ) ;
				m_pstmt.executeUpdate() ;*/

				pstmt4.setString( 1, facilityId ) ;
				pstmt4.setString( 2, locn ) ;
				pstmt4.setString( 3, dat ) ;
				pstmt4.executeUpdate() ;

				pstmt5.setString( 1, facilityId ) ;
				pstmt5.setString( 2, locn ) ;
				pstmt5.setString( 3, dat ) ;
				
				int res5 = pstmt5.executeUpdate() ;

				if ( res5 != 0 ){
					sql_operation = true ;
				}else{
					sql_operation = true ;
				}


				
				}
					//holiday_date=DateUtils.convertDate(holiday_date,"DMY",locale,"en");

					pstmt.setString	(1,	facilityId );					
					pstmt.setString	(2,	dat );
					pstmt.setString	(3,	reason_for_holiday );
					pstmt.setString	(4, addedById );
					pstmt.setString	(5, addedAtWorkstation );
					pstmt.setString	(6, facilityId );
					pstmt.setString	(7, addedById );
					pstmt.setString	(8, addedAtWorkstation );
					pstmt.setString	(9, facilityId );
					pstmt.setString	(10,careLocnTypeInd );
					pstmt.setString	(11,locn );
					result_val	= pstmt.executeUpdate() ;
					Totalres+=result_val;

					//int n=1;
					//int s=1;
					//String fid="";
					//if(n > s){
						//String sl = "";
						//int srlno = 0;
						j_pstmt = con.prepareStatement( sql_ins_oa_trans_record );
					    pstmt9 = con.prepareStatement(sql_oa_trans_record);	
						pstmt9.setString( 1, facilityId ) ;
						rset=pstmt9.executeQuery();
						if(rset.next())
						sl = rset.getString("max");
						srlno = Integer.parseInt(sl);
                      
						j_pstmt.setString(1, facilityId);
						j_pstmt.setInt	( 2, srlno ) ;
						//j_pstmt.setString	( 3, "SC" ) ;
						j_pstmt.setString	( 3, "HC" ) ;
						j_pstmt.setString	( 4,addedById );
						j_pstmt.setString	( 5, dat ) ;
						j_pstmt.setString (6,dat);
						j_pstmt.setString( 7, locn ) ;
						j_pstmt.setString( 8, pract ) ;
						j_pstmt.setString( 9, day ) ;
						j_pstmt.setString( 10, reason_for_holiday ) ;
						j_pstmt.setString( 11, "" ) ;
						j_pstmt.setString( 12, location_Type ) ;
						j_pstmt.setString( 13, resource_Type ) ;
						j_pstmt.executeUpdate() ;
					//}
					
					/*if(pstmt9!=null) pstmt9.close(); //Checklist Added
					if(j_pstmt!=null) j_pstmt.close(); //Checklist Added
					if(r_pstmt!=null) r_pstmt.close(); //Checklist Added
					if(k_pstmt!=null) k_pstmt.close(); //checklist 
					if(l_pstmt!=null) k_pstmt.close(); //checklist 
					if(pstmt2!=null) pstmt2.close(); //checklist
					if(pstmt7!=null) pstmt7.close(); //checklist
					if(pstmt3!=null) pstmt3.close(); //checklist
					if(pstmt4!=null) pstmt4.close(); //checklist
					if(pstmt5!=null) pstmt5 .close(); //checklist*/
				}
				
				
			//	operation_ins_count	= pstmt_ins.executeUpdate() ;
			}
			// commented by N Munisekhar on 19-April-2013 against ML-BRU-SCF-0802[IN:039338] 
			//if(pstmt2!=null) pstmt2.close(); //checklist
			}
			catch (Exception e)
			{
				
				e.printStackTrace();
			}
			
		}else{

			String insert_sql = "insert into 	oa_holiday(FACILITY_ID,HOLIDAY_DATE,REASON_FOR_HOLIDAY,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,CARE_LOCN_TYPE_IND,LOCN_CODE) values (?, to_date(?,'dd/mm/yyyy'), ?, ?, sysdate, ?, ?, ?, sysdate, ?,?,?,?)" ;
			
			//String date_sql="select to_char(date_value,'dd/mm/yyyy')sqldate    from (select to_date('"+fromDate+"','dd/mm/yyyy')-1+rownum date_value from dual connect by rownum-1<=(Trunc(to_date('"+toDate+"','dd/mm/yyyy'))-Trunc(to_date('"+fromDate+"','dd/mm/yyyy'))))";
           //Above query Checklist Commented
			//String clinic_sql="SELECT clinic_code FROM (Select a.clinic_code clinic_code  from op_clinic_lang_vw a WHERE a.clinic_code  IN (SELECT locn_code FROM oa_holiday where facility_id='"+facilityId+"')  and a.facility_id='"+facilityId+"'  and language_id='"+locale+"' and a.level_of_care_ind = 'A' and a.ALLOW_APPT_YN='Y' AND a.clinic_type='"+careLocnTypeInd+"' AND a.CARE_LOCN_TYPE_IND='"+careLocnTypeInd+"' )";
			//Above query Checklist Commented
			String clinic_sql_local="select PRIMARY_RESOURCE_CLASS from op_clinic_lang_vw where facility_id=? and language_id=? and clinic_code=?";
			PreparedStatement	clinic_pstmt	= con.prepareStatement(clinic_sql_local);
			ResultSet			local_rs		= null;

			//Added for this CRF  HSA-CRF-0184 linked incident IN054433
	        String location_type="";
			if(careLocnTypeInd.equals("D")){
			  location_type="Y";
			}else{
			  location_type=careLocnTypeInd;
			}
		





			//String inesert_hol_exist="select a.clinic_code, a.long_desc clinic_desc, to_char(b.holiday_date,'dd/mm/yyyy') holiday_date from op_clinic_lang_vw a ,(select to_date('"+fromDate+"','dd/mm/yyyy')+rownum-1 holiday_date from sm_function where rownum <=to_date('"+toDate+"','dd/mm/yyyy')-to_date('"+fromDate+"','dd/mm/yyyy')+1) b where a.language_id='"+locale+"' and a.facility_id='"+facilityId+"' and a.ALLOW_APPT_YN='Y'and a.level_of_care_ind = 'A' and not exists(select 1 from oa_holiday where facility_id=a.facility_id and locn_code=a.clinic_code AND holiday_date = b.holiday_date ) and a.clinic_type='"+careLocnTypeInd+"' minus select a.clinic_code, a.long_desc clinic_desc, to_char(b.holiday_date,'dd/mm/yyyy') holiday_date from op_clinic_lang_vw a ,(select to_date('"+fromDate+"','dd/mm/yyyy')+rownum-1 holiday_date from sm_function where rownum <=to_date('"+toDate+"','dd/mm/yyyy')-to_date('"+fromDate+"','dd/mm/yyyy')+1) b where a.language_id='"+locale+"' and a.facility_id='"+facilityId+"' and a.ALLOW_APPT_YN='Y'and a.level_of_care_ind = 'A' and not exists(select 1 from oa_holiday where facility_id=a.facility_id and locn_code=a.clinic_code ) and a.clinic_type='"+careLocnTypeInd+"' ORDER BY 3,2 ";

			String inesert_hol_exist="select a.clinic_code, a.long_desc clinic_desc, to_char(b.holiday_date,'dd/mm/yyyy') holiday_date from op_clinic_lang_vw a ,(select to_date('"+fromDate+"','dd/mm/yyyy')+rownum-1 holiday_date from sm_function where rownum <=to_date('"+toDate+"','dd/mm/yyyy')-to_date('"+fromDate+"','dd/mm/yyyy')+1) b where a.language_id='"+locale+"' and a.facility_id='"+facilityId+"' and a.ALLOW_APPT_YN='Y'and a.level_of_care_ind = 'A' and not exists(select 1 from oa_holiday where facility_id=a.facility_id and locn_code=a.clinic_code AND holiday_date = b.holiday_date ) and a.clinic_type='"+location_type+"' minus select a.clinic_code, a.long_desc clinic_desc, to_char(b.holiday_date,'dd/mm/yyyy') holiday_date from op_clinic_lang_vw a ,(select to_date('"+fromDate+"','dd/mm/yyyy')+rownum-1 holiday_date from sm_function where rownum <=to_date('"+toDate+"','dd/mm/yyyy')-to_date('"+fromDate+"','dd/mm/yyyy')+1) b where a.language_id='"+locale+"' and a.facility_id='"+facilityId+"' and a.ALLOW_APPT_YN='Y'and a.level_of_care_ind = 'A' and not exists(select 1 from oa_holiday where facility_id=a.facility_id and locn_code=a.clinic_code ) and a.clinic_type='"+location_type+"' ORDER BY 3,2 ";
			cl_pstmt = con.prepareStatement( inesert_hol_exist );
			//End this CRF  HSA-CRF-0184linked incident IN054433 
			
			

			String clinic_sql_all="";
			String date_sql_all="";
			String local_resource_type="";
			int holidaycount=0;
			all_pstmt = con.prepareStatement( insert_sql );  //commented for this incident [54556]						
			//System.err.println("inesert_hol_exist===>"+inesert_hol_exist);
			
			cl_rset=cl_pstmt.executeQuery() ;	
			while(cl_rset!=null && cl_rset.next()){
				//String locn_type="";
				clinic_sql_all=cl_rset.getString("clinic_code");
				date_sql_all=cl_rset.getString("holiday_date");
				//locn_type=cl_rset.getString("locn_type");
				//resource_Type=cl_rset.getString("resource_Type");
				//all_pstmt = con.prepareStatement( insert_sql );  //commented for this incident [54556]
				all_pstmt.setString	(1,	facilityId );
				all_pstmt.setString	(2,	date_sql_all );
				all_pstmt.setString	(3,	reason_for_holiday );
				all_pstmt.setString	(4, addedById );
				all_pstmt.setString	(5, addedAtWorkstation );
				all_pstmt.setString	(6, facilityId );
				all_pstmt.setString	(7, addedById );
				all_pstmt.setString	(8, addedAtWorkstation );
				all_pstmt.setString	(9, facilityId );
				all_pstmt.setString	(10,careLocnTypeInd );
				all_pstmt.setString	(11,clinic_sql_all );
				all_pstmt.addBatch(); 
				/*below line commented and above line added for this incident [54556]*/
				/*result_val	= all_pstmt.executeUpdate() ;
				Totalres+=result_val;*/
				
								
				clinic_pstmt.setString(1,facilityId);
				clinic_pstmt.setString(2,locale);
				clinic_pstmt.setString(3,clinic_sql_all);
				local_rs=clinic_pstmt.executeQuery() ;
				while(local_rs!=null && local_rs.next()){
					local_resource_type=local_rs.getString("PRIMARY_RESOURCE_CLASS");
				}
				if(local_rs!=null)local_rs.close();
				
				//if(all_pstmt!=null) all_pstmt.close(); //chcklist

				//int n=1;
				//int s=1;
				//String fid="";
				//if(n > s){
					//String sl = "";
					//int srlno = 0;
					//sql_ins_oa_trans_record = " Insert into oa_trans_record (facility_id,srl_no,trans_code,trans_date_time, trans_eff_by_id,  from_date_entered,to_date_entered,  clinic_code,from_practitioner_id,from_day_no,remarks,reason_code,care_locn_type_ind,resource_class)  values (?,?,?,sysdate,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?) " ;
					j_pstmt = con.prepareStatement( sql_ins_oa_trans_record ); //checklist Added here
					pstmt9 = con.prepareStatement(sql_oa_trans_record); //checklist error Added here
					pstmt9.setString( 1, facilityId ) ;
					rset=pstmt9.executeQuery();
					if(rset.next())
					sl = rset.getString("max");
					srlno = Integer.parseInt(sl);
					j_pstmt.setString(1, facilityId);
					j_pstmt.setInt	( 2, srlno ) ;
					//j_pstmt.setString	( 3, "SC" ) ;
					j_pstmt.setString	( 3, "HC" ) ;
					j_pstmt.setString	( 4,addedById );
					j_pstmt.setString	( 5, date_sql_all ) ;
					j_pstmt.setString (6,date_sql_all);
					j_pstmt.setString( 7, clinic_sql_all ) ;
					j_pstmt.setString( 8, "" ) ;
					j_pstmt.setString( 9, "" ) ;
					j_pstmt.setString( 10, reason_for_holiday ) ;
					j_pstmt.setString( 11, "" ) ;
					j_pstmt.setString( 12, careLocnTypeInd ) ;
					j_pstmt.setString( 13, local_resource_type ) ;
					j_pstmt.executeUpdate() ;
				//}
				if(pstmt9!=null)pstmt9.close(); //chcklist
				if(j_pstmt!=null)j_pstmt.close(); //chcklist
				
			 holidaycount++;	
			} 
	             //Added for this incident [54556]
				int[] resultsholday=all_pstmt.executeBatch();		
				if(holidaycount == resultsholday.length&&resultsholday.length>0)Totalres=resultsholday.length;
								
				//End incident [54556]
			if(all_pstmt!=null) all_pstmt.close(); //chcklist
			if(cl_rset!=null)cl_rset.close();
			if(cl_pstmt!=null)cl_pstmt.close();
			if(clinic_pstmt!=null)clinic_pstmt.close();
			
		}
		if (Totalres > 0){
			insertable=true;
		}else{
			insertable=false;
		}
		if(insertable){
			result = true ;
			java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_MODIFIED","SM" ) ;
			sb.append( (String) message.get("message") ) ;
			con.commit();			
		}else{
			con.rollback();
		}
		if(pstmt!= null) pstmt.close() ;
	}catch (Exception e){

		e.printStackTrace();
	}finally{
	      try{ if(a_pstmt!=null) a_pstmt.close();
			  if(b_pstmt!=null) b_pstmt.close();
			  if(c_pstmt!=null) c_pstmt.close();
			  if(d_pstmt!=null) d_pstmt.close();
			  if(e_pstmt!=null) e_pstmt.close();
			  if(f_pstmt!=null) f_pstmt.close();
			  if(g_pstmt!=null) g_pstmt.close();
			  if(h_pstmt!=null) h_pstmt.close();
			  if(i_pstmt!=null) i_pstmt.close();
			  if(r_pstmt!=null) r_pstmt.close();
			  if(op_pstmt!=null) op_pstmt.close();
			  if(k_pstmt!=null) k_pstmt.close();
			  if(l_pstmt!=null) l_pstmt.close();			
			  if(pstmt7!=null) pstmt7.close();
			  // added by N Munisekhar on 19-April-2013 against ML-BRU-SCF-0802[IN:039338] 
			  if(pstmt2!=null) pstmt2.close();	
			  if(pstmt3!=null) pstmt3.close();
			  if(pstmt4!=null) pstmt4.close();
			  if(pstmt5!=null) pstmt5.close();
			  if(all_pstmt!=null) all_pstmt.close();
			  if(op_rs!=null) op_rs.close();
			  if(rs!=null) rs.close();
			  if(rset2!=null) rset2.close();
			  if(rset!=null) rset.close();	
			}
			catch(Exception e){
				e.printStackTrace();
			}
			  
			  if(con!=null) ConnectionManager.returnConnection(con,p);
	}
	results.put( "status", new Boolean(result) ) ;
	results.put( "error", sb.toString() ) ;
	sb.setLength(0);
	return results;
}
/**
* @ejb.interface-method
*	 view-type="both"
*/
	public java.util.HashMap updateHoliday(java.util.Properties p,
						java.util.HashMap passObjects
						) 
			{
			String	holidaydate=(String) passObjects.get("holidaydate");
			String reasonforholiday=(String) passObjects.get("reasonforholiday");
			String facilityId=(String) passObjects.get("facilityId");
			String	addedAtWorkstation=(String) passObjects.get("client_ip_address");
			String careLocnTypeInd=(String) passObjects.get("careLocnTypeInd");
			String clinic=(String) passObjects.get("clinics");
			String locale = p.getProperty("LOCALE");
			
			java.util.HashMap results = new java.util.HashMap() ;
			boolean result = false ;
			boolean updatable = true ;
			StringBuffer sb = new StringBuffer( "" ) ;
			String sql = "update oa_holiday set reason_for_holiday=?, modified_by_id=?,modified_date	= sysdate,  modified_at_ws_no= ?, MODIFIED_FACILITY_ID =? where holiday_date= to_date('"+holidaydate+"','dd/mm/yyyy') and facility_id = ? and care_locn_type_ind=? and locn_code=?";
			String modifiedById = p.getProperty( "login_user" ) ;
			
			String modifiedAtWorkstation = addedAtWorkstation ;
		
			try {
				con = ConnectionManager.getConnection(p);
				if ( updatable ) {
					pstmt = con.prepareStatement( sql );
					pstmt.setString ( 1,reasonforholiday ) ;
					pstmt.setString	( 2, modifiedById ) ;
					pstmt.setString	( 3, modifiedAtWorkstation ) ;
					pstmt.setString (4,facilityId);
					//pstmt.setDate ( 5,holiday_date ) ;
					pstmt.setString ( 5,facilityId);
					pstmt.setString (6,careLocnTypeInd);
					pstmt.setString (7,clinic);
					int res = pstmt.executeUpdate() ;
					if ( res != 0 ) {
						result = true ;
						java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_MODIFIED","SM" ) ;
						sb.append( (String) message.get("message") ) ;
						con.commit();
						message.clear();
					}
					pstmt.close() ;
				}
				if(rs!= null) rs.close() ;
				if(pstmt!= null) pstmt.close() ;
				

			}catch ( Exception e ) {
				e.printStackTrace();
				try {
					con.rollback() ;
				} catch ( Exception ce ) {

							ce.printStackTrace();
				}
				sb.append( e.getMessage() + "<br>" ) ;
			}finally{
			   	if(con!=null) ConnectionManager.returnConnection(con,p);
			 }
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		sb.setLength(0);
		passObjects.clear();
		return results ;
	}
	/**
* @ejb.interface-method
*	 view-type="both"
*/
public java.util.HashMap deleteHoliday(	java.util.Properties p,
										java.util.HashMap passObjects) 
{
	String	holidaydate=(String) passObjects.get("holidaydate");
	String facilityId=(String) passObjects.get("facilityId");
	String careLocnTypeInd=(String) passObjects.get("careLocnTypeInd");
	String clinic=(String) passObjects.get("clinics");
	String locale = p.getProperty("LOCALE");

	java.util.HashMap results = new java.util.HashMap() ;
	boolean result = false ;
	StringBuffer sb = new StringBuffer( "" ) ;
	String sl	= "";
	int srlno	= 0;
	ResultSet rset=null;

	String addedById = p.getProperty( "login_user" ) ;

	String sql_oa_trans_record  = " Select nvl(max(srl_no),0)+1 max from oa_trans_record where facility_id='"+facilityId+"' ";

	String sql_ins_oa_trans_record = " Insert into oa_trans_record (facility_id,srl_no,trans_code,trans_date_time, trans_eff_by_id,  from_date_entered,to_date_entered,  clinic_code,from_practitioner_id,from_day_no,remarks,reason_code,care_locn_type_ind,resource_class)  values (?,?,?,sysdate,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?) " ;
	try{
		String sql = "delete from oa_holiday where holiday_date = to_date(?,'dd/mm/yyyy') and facility_id =? and care_locn_type_ind=? and locn_code=?";
		con = ConnectionManager.getConnection(p);
		//java.sql.Date holiday_date = java.sql.Date.valueOf(holidaydate); Friday, March 12, 2010 19959.
		pstmt = con.prepareStatement( sql );
		pstmt.setString	( 1, holidaydate ) ;
		pstmt.setString	( 2, facilityId) ;
		pstmt.setString ( 3, careLocnTypeInd);
		pstmt.setString ( 4, clinic);
		int res = pstmt.executeUpdate() ;
		if ( res != 0 ){
		    if(pstmt!=null)pstmt.close(); //checklist
			pstmt = con.prepareStatement(sql_oa_trans_record);
			rset=pstmt.executeQuery();
			if(rset!=null && rset.next()){
				sl = rset.getString("max");
			}
			if(rset!=null)rset.close();
			if(pstmt!=null)pstmt.close(); //checklist
			srlno = Integer.parseInt(sl);
			pstmt = con.prepareStatement("select PRIMARY_RESOURCE_CLASS from op_clinic_lang_vw where facility_id=? and clinic_code=? and language_id=? ");
			pstmt.setString	( 1, facilityId) ;
			pstmt.setString	( 2, clinic) ;
			pstmt.setString	( 3, locale) ;
			rset=pstmt.executeQuery();
			String resouce_class="";
			if(rset!=null && rset.next()){
				resouce_class=rset.getString("PRIMARY_RESOURCE_CLASS");
			}
			if(rset!=null)rset.close();
			if(pstmt!=null)pstmt.close(); //checklist
			pstmt = con.prepareStatement(sql_ins_oa_trans_record);
			pstmt.setString ( 1, facilityId);
			pstmt.setInt	( 2, srlno ) ;
			pstmt.setString	( 3, "HD" ) ;
			pstmt.setString	( 4, addedById );
			pstmt.setString	( 5, holidaydate ) ;
			pstmt.setString ( 6, holidaydate);
			pstmt.setString ( 7, clinic ) ;
			pstmt.setString ( 8, "" ) ;
			pstmt.setString ( 9, "" ) ;
			pstmt.setString ( 10, "" ) ;
			pstmt.setString ( 11, "" ) ;
			pstmt.setString ( 12, careLocnTypeInd ) ;
			pstmt.setString ( 13, resouce_class ) ;
			pstmt.executeUpdate() ;
			result = true ;
			java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_DELETED","SM" ) ;
			sb.append( (String) message.get("message") ) ;
			con.commit();
			message.clear();
	}
		
		
	}catch ( Exception e ){
		e.printStackTrace();
	try {
		con.rollback() ;
	}catch ( Exception ce ) {

		ce.printStackTrace();
	}
	sb.append( e.getMessage() + "<br>" ) ;
	e.printStackTrace() ;
	}finally{
	   try{ if(pstmt!=null) pstmt.close() ; //checklist
	   }
	   catch(Exception e){
	   e.printStackTrace();
	   }
		if(con!=null) ConnectionManager.returnConnection(con,p);
	}
	results.put( "status", new Boolean(result) ) ;
	results.put( "error", sb.toString() ) ;
	sb.setLength(0);
	passObjects.clear();
	return results ;
}	

/**
* @ejb.interface-method
*	 view-type="both"
*/

public java.util.HashMap deleteMultipleHolidays(java.util.Properties p,java.util.HashMap passObjects){
	PreparedStatement pstmt =null;
	PreparedStatement pstmt2 =null;
	PreparedStatement pstmt3 =null;
	PreparedStatement clinic_pstmt =null;
	ResultSet rset=null;
	ResultSet local_rs=null;
	String sl=null;
	String local_resource_type=null;
	int srlno=0;
	String facilityId=(String) passObjects.get("facilityId");
	java.util.ArrayList selectedHolidays=(java.util.ArrayList) passObjects.get("selectedHolidays");
	java.util.HashMap results = new java.util.HashMap() ;
	boolean result = false ;
	StringBuffer sb = new StringBuffer( "" ) ;
	int size=selectedHolidays.size();
	String selValues="";
	int totalResult=0;
	String locale = p.getProperty("LOCALE");
	String addedById = p.getProperty( "login_user" ) ;
	String sql_oa_trans_record  = " Select nvl(max(srl_no),0)+1 max from oa_trans_record where facility_id=? ";
	String sql_ins_oa_trans_record = " Insert into oa_trans_record (facility_id,srl_no,trans_code,trans_date_time, trans_eff_by_id,  from_date_entered,to_date_entered,  clinic_code,from_practitioner_id,from_day_no,remarks,reason_code,care_locn_type_ind,resource_class)  values (?,?,?,sysdate,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?) " ;
	String clinic_sql_local="select PRIMARY_RESOURCE_CLASS from op_clinic_lang_vw where facility_id=? and language_id=? and clinic_code=?";
	try{
		String sql	= "delete from oa_holiday where holiday_date = to_date(?,'dd/mm/yyyy') and facility_id =? and care_locn_type_ind=? and locn_code=?";
		con			= ConnectionManager.getConnection(p);
		pstmt		= con.prepareStatement( sql );
		pstmt2		= con.prepareStatement(sql_oa_trans_record);
		pstmt3		= con.prepareStatement( sql_ins_oa_trans_record );
		clinic_pstmt= con.prepareStatement( clinic_sql_local );
		for (int i=0;i < size;i++){
			selValues=(String)selectedHolidays.get(i);
			StringTokenizer st= new StringTokenizer(selValues,"|");
			while (st.hasMoreTokens()){
				String token=st.nextToken();
				StringTokenizer st1=new StringTokenizer(token,"$");
				String locnType=st1.nextToken();
				String clinic=st1.nextToken();
				String holidayDate=st1.nextToken();
				pstmt.setString	( 1, holidayDate ) ;
				pstmt.setString	( 2, facilityId) ;
				pstmt.setString ( 3, locnType);
				pstmt.setString ( 4, clinic);
				int res = pstmt.executeUpdate() ;
				totalResult+=res;

				pstmt2.setString( 1, facilityId ) ;
				rset=pstmt2.executeQuery();
				if(rset.next()){
					sl = rset.getString("max");
					srlno = Integer.parseInt(sl);
				}
				clinic_pstmt.setString(1,facilityId);
				clinic_pstmt.setString(2,locale);
				clinic_pstmt.setString(3,clinic);
				local_rs=clinic_pstmt.executeQuery() ;
				while(local_rs!=null && local_rs.next()){
					local_resource_type=local_rs.getString("PRIMARY_RESOURCE_CLASS");
				}
				if(rset!=null)rset.close();
				if(local_rs!=null)local_rs.close();
				pstmt3.setString (1, facilityId);
				pstmt3.setInt	 ( 2, srlno ) ;
				pstmt3.setString (3, "HD" ) ;
				pstmt3.setString (4, addedById );
				pstmt3.setString (5, holidayDate ) ;
				pstmt3.setString (6, holidayDate);
				pstmt3.setString (7, clinic ) ;
				pstmt3.setString (8, "" ) ;
				pstmt3.setString (9, "" ) ;
				pstmt3.setString (10, "" ) ;
				pstmt3.setString (11, "" ) ;
				pstmt3.setString (12, locnType ) ;
				pstmt3.setString (13, local_resource_type ) ;
				pstmt3.executeUpdate() ;
			} //while loop
		}//for loop
		if ( totalResult != 0 ) {
			result = true ;
			java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_DELETED","SM" ) ;
			sb.append( (String) message.get("message") ) ;
		 	con.commit();
			message.clear();
		}
		if(pstmt!=null) pstmt.close() ;
		if(pstmt2!=null) pstmt2.close() ;
        if(pstmt3!=null) pstmt3.close() ;
        if(clinic_pstmt!=null) clinic_pstmt.close() ;
		
	}catch ( Exception e ){
		e.printStackTrace();
		try {
			con.rollback() ;
		}catch ( Exception ce ) {
			
			ce.printStackTrace();
		}
		sb.append( e.getMessage() + "<br>" ) ;
	}finally{
		if(con!=null) ConnectionManager.returnConnection(con,p);
	}
	results.put( "status", new Boolean(result) ) ;
	results.put( "error", sb.toString() ) ;
	sb.setLength(0);
	passObjects.clear();
	selectedHolidays.clear();
	return results ;
	}
}
