<!DOCTYPE html>
  <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.text.*, java.net.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" %>
       
<html>  
<title><fmt:message key="Common.AppointmentDetails.label" bundle="${common_labels}"/></title>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eOA/js/AppointmentDetails.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<% 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
		String flag=request.getParameter("flag");
		if(flag == null || flag.equals("undefined")) flag="";

	%>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' >

<%
			String pat_alcn_criteria="";
			String pat_alcn_catg_code="";
			String pat_alcn_catg_code1="";
			String pre_pat_alcn_criteria="";
			String pre_pat_alcn_catg_code="";
			String contactvals="";
			String nationality="";
			String time_tab_val1="";
			String facilityid=(String)session.getValue("facility_id");
			String locale=(String)session.getAttribute("LOCALE");

			PreparedStatement pstmt=null;
			//Statement stmtgrp=null;
			//Statement Stmt_Nat_Id=null;
			//ResultSet Rset_Nat_Id=null;
			//ResultSet rstt=null;
			ResultSet rs1=null;
			ResultSet rsSet=null;
			Statement stMent= null;

			//ResultSet rssd=null;
			//ResultSet rsgrp=null;
			Connection conn = null;
			//Statement stmtsd=null;
			String referral_line="";
			String referral_line1="";
			String book_appt_yn = request.getParameter("book_appt_yn");
			if (book_appt_yn==null) book_appt_yn="";
			String book_appt_wo_pid_yn = request.getParameter("book_appt_wo_pid_yn");
			if (book_appt_wo_pid_yn==null) book_appt_wo_pid_yn="";
			String obook_appt_yn = request.getParameter("obook_appt_yn");
			if (obook_appt_yn==null) obook_appt_yn="";
			String book_appt_across_catg_yn = request.getParameter("book_appt_across_catg_yn");
			if (book_appt_across_catg_yn==null) book_appt_across_catg_yn="";
			String tfr_appt_yn = request.getParameter("tfr_appt_yn");
			if (tfr_appt_yn==null) tfr_appt_yn="";
			String tfr_appt_across_catg_yn = request.getParameter("tfr_appt_across_catg_yn");
			if (tfr_appt_across_catg_yn==null) tfr_appt_across_catg_yn="";
			String canc_appt_yn = request.getParameter("canc_appt_yn");
			if (canc_appt_yn==null) canc_appt_yn="";
			String alcn_criteria = request.getParameter("alcn_criteria");
			if (alcn_criteria==null) alcn_criteria="";
			String alcn_catg_code= request.getParameter("pre_pat_alcn_catg_code");
			if (alcn_catg_code==null) alcn_catg_code="";

			String Forced=request.getParameter("Forced");
			if(Forced==null || Forced.equals("null"))
					Forced="N";

			StringBuffer contactAddress=new StringBuffer();


try
{
		conn = ConnectionManager.getConnection(request);

		String clinic_code="";
		String practitioner_id="";

		clinic_code=request.getParameter("i_clinic_code");
		practitioner_id=request.getParameter("i_practitioner_id");
		String apptrefno=request.getParameter("i_appt_ref_no");
		if(apptrefno == null || apptrefno.equals("undefined")) apptrefno="";
		String disp_fromtime="";
		String disp_totime="";
		String transfer=request.getParameter("transfer");
		if(transfer == null) transfer="";
		String i_from_time=request.getParameter("i_from_time");
		if(i_from_time == null) i_from_time="";
		String i_to_time=request.getParameter("i_to_time");
		if(i_to_time == null) i_to_time="";
		String value13=request.getParameter("value13");
		if(value13 == null) value13="";
		String i_appt_date=request.getParameter("i_appt_date");
		String over_booked=request.getParameter("over_booked");
		if(over_booked == null) over_booked="";
		String i_time_table_type=request.getParameter("i_time_table_type");
		if(i_time_table_type == null) i_time_table_type="";
		String old_date=(String)request.getParameter("old_date");
		if(old_date  == null || old_date.equals("null")) old_date="";
		if(apptrefno.equals("hjjh")) { apptrefno=value13; }
		String old_from_time = request.getParameter("old_from_time");
		if( old_from_time == null) old_from_time="";
		String old_to_time = request.getParameter("old_to_time");
		if( old_to_time == null) old_to_time="";

		String clinic_type=request.getParameter("clinic_type");
		String res_type=request.getParameter("res_type");
		if (clinic_type==null) clinic_type = "C";
		if (res_type==null) res_type = "P";

		String care_locn_ind_desc="";
		
if(clinic_type.equals("C")){
	care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
}else if(clinic_type.equals("E")){
	care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
}else if(clinic_type.equals("D")){
	care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
}
		String res_class_desc="";
	
if(res_type.equals("P")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
}else if(res_type.equals("E")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
}else if(res_type.equals("R")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
}else if(res_type.equals("O")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
}else if(res_type.equals("B")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Bed.label","common_labels");
}

		String apptrefno1="";
		String clinicshortdesc="";
		String practitionerid="";
		String practname="";
		String apptdate="";
		String appttime="";
		String apptslabfmtime="";
		String apptslabtotime="";
		String apptduration="";
		String patientid="";
		String prefix="";
		String firstname="";
		String secondname="";
		String thirdname="";
		String familyname="";
		String suffix="";
		String patientname="";
		String gender="";
		String genderdesc="";
		String dateofbirth="";
		String agey="";
		String agem="";
		String aged="";
		String restelno="";
		String othtelno="";
		String emailid="";
		String nationalid="";
		String nat_id_prompt="";
		String alternateid="";
		String resaddrl1="";
		String resaddrl2="";
		String resaddrl3="";
		String resaddrl4="";
		String postalcode="";
		String countrycode="";
		String appttypecode="";
		String overbookedyn="";
		String referralcode="";
		String mode="";
		String modedesc="";
		String reasoncode="";
		String reasondesc="";
		String apptremarks="";
		String visitshortdesc="";
		String appt_date1="";
		String visitind="";
		String referral_id="";
		String user_name="";
		String record_date="";
		String team_id="";
		String ETHNIC_GROUP_DESC="";
		String RACE_DESC="";
		String CITIZEN_YN="";
		String LEGAL_YN="";
		String BIRTH_PLACE_DESC="";
		String receiving_date_time="";
		String RES_AREA_CODE="";
		String RES_AREA_DESC="";
		String RES_TOWN_CODE="";
		String RES_TOWN_DESC="";
		String RES_REGION_CODE="";
		String RES_REGION_DESC="";
		String RES_COUNTRY_CODE="";
		String RES_COUNTRY_NAME="";
		String MAIL_ADDR_LINE1="";
		String MAIL_ADDR_LINE2="";
		String MAIL_ADDR_LINE3="";
		String MAIL_ADDR_LINE4="";
		String MAIL_AREA_CODE="";
		String MAIL_AREA_DESC="";
		String MAIL_TOWN_CODE="";
		String MAIL_TOWN_DESC="";
		String MAIL_REGION_CODE="";
		String MAIL_REGION_DESC="";
		String MAIL_POSTAL_CODE="";
		String MAIL_COUNTRY_CODE="";
		String MAIL_COUNTRY_NAME="";
		String ALT_ID1_TYPE="";
		String ALT_ID1_NO="";
		String ALT_ID1_EXP_DATE="";
		String ALT_ID2_TYPE="";
		String ALT_ID2_NO="";
		String ALT_ID2_EXP_DATE="";
		String ALT_ID3_TYPE="";
		String ALT_ID3_NO="";
		String ALT_ID3_EXP_DATE="";
		String ALT_ID4_TYPE="";
		String ALT_ID4_NO="";
		String ALT_ID4_EXP_DATE="";
		String ALT_ID1_EXP_DATE_display="";
		String ALT_ID2_EXP_DATE_display="";
		String ALT_ID3_EXP_DATE_display="";
		String ALT_ID4_EXP_DATE_display="";
		String OTH_ALT_ID_TYPE="";
		String OTH_ALT_ID_NO="";
		String ALT_ID1_Desc="";
		String ALT_ID2_Desc="";
		String ALT_ID3_Desc="";
		String ALT_ID4_Desc="";
		String alt_type_desc="";
		String no_of_slots="";
		String str13="";
		String str14="";
		String postal_desc="";
		String mail_postal_desc="";
		/*Added by Thamizh selvi on 5th Feb 2018 against ML-MMOH-CRF-0601 Start*/
		String alt_addr_line1	= "";
		String alt_addr_line2	= "";
		String alt_addr_line3	= "";
		String alt_addr_line4	= "";
		String alt_postal_code  = "";
		String alt_postal_desc  = "";
		String alt_country_code = "";
		String alt_country_desc = "";
		String alt_area_code	= "";
		String alt_area_desc	= "";
		String alt_town_code	= "";
		String alt_town_desc	= "";
		String alt_region_code	= "";
		String alt_region_desc	= "";
		boolean isAlternateAddressAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "MP","ALTERNATE_ADDRESS_APPLICABLE");
		/*End*/
	
		if(rs1 !=null) rs1.close();

		 //String sql="select sm_get_desc.sm_appl_user(added_by_id, '"+locale+"', '1') appl_user_name,to_char(added_date,'dd/mm/yyyy hh24:mi') added_date,to_char(appt_slab_to_time,'hh24:mi') appt_slab_to_time, facility_id, appt_ref_no, clinic_code, OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,'"+locale+"','1') CLINIC_SHORT_DESC,practitioner_id,decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) practitioner_short_name,OP_GET_DESC.OP_VISIT_TYPE(FACILITY_ID, APPT_TYPE_CODE,'"+locale+"','2') visit_type_short_desc, appt_date, to_char(appt_time,'hh24:mi') appt_time, to_char(appt_slab_from_time,'hh24:mi') appt_slab_from_time, to_char(appt_slab_to_time,'hh24:mi') appt_slab_to_time, to_char(appt_duration,'hh24:mi') appt_duration, appt_slots, patient_id, name_prefix, first_name, second_name, third_name,family_name, name_suffix, decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name, gender, date_of_birth, res_tel_no res_tel_no,oth_contact_no, national_id_no, res_addr_line1, res_addr_line2, res_addr_line3,  res_addr_line4, postal_code, country_code, appt_type_code, (SELECT visit_type_ind  FROM op_visit_type b WHERE b.visit_type_code = appt_type_code AND b.facility_id = facility_id) VISIT_TYPE_IND,overbooked_yn,referral_id, mode_of_contact,contact_reason_code, AM_GET_DESC.AM_CONTACT_REASON(CONTACT_REASON_CODE,'"+locale+"','1') CONTACT_REASON,appt_remarks, appt_status, inpatient_yn, encounter_id,email_id,alcn_criteria,calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),1) year1,calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),2) month1,calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),3) day1 ,alcn_catg_code,referral_id,MP_GET_DESC.MP_COUNTRY(COUNTRY_CODE,'"+locale+"','1') nationality,team_id,alcn_criteria,pat_alcn_catg_code,MP_GET_DESC.MP_ETHNIC_GROUP(ETHNIC_GROUP_CODE,'"+locale+"','1') ETHNIC_GROUP_DESC,MP_GET_DESC.MP_RACE(RACE_CODE,'"+locale+"','1') RACE_DESC,CITIZEN_YN,LEGAL_YN,MP_GET_DESC.MP_BIRTH_PLACE(BIRTH_PLACE_CODE,'"+locale+"','1') BIRTH_PLACE_DESC,to_char(receiving_date_time,'dd/mm/yyyy HH24:mi') receiving_date_time,RES_AREA_CODE,MP_GET_DESC.MP_RES_AREA(RES_AREA_CODE,'"+locale+"','1') RES_AREA_DESC,RES_TOWN_CODE,MP_GET_DESC.MP_RES_TOWN(RES_TOWN_CODE,'"+locale+"','1') RES_TOWN_DESC,RES_REGION_CODE,MP_GET_DESC.MP_REGION(RES_REGION_CODE,'"+locale+"','1') RES_REGION_DESC,RES_COUNTRY_CODE,MP_GET_DESC.MP_COUNTRY(RES_COUNTRY_CODE,'"+locale+"','1') RES_COUNTRY_NAME,MAIL_ADDR_LINE1,MAIL_ADDR_LINE2,MAIL_ADDR_LINE3,MAIL_ADDR_LINE4,MAIL_AREA_CODE,MP_GET_DESC.MP_RES_AREA(MAIL_AREA_CODE,'"+locale+"','1') MAIL_AREA_DESC,MAIL_TOWN_CODE,MP_GET_DESC.MP_RES_TOWN(MAIL_TOWN_CODE,'"+locale+"','1') MAIL_TOWN_DESC,MAIL_REGION_CODE,MP_GET_DESC.MP_REGION(MAIL_REGION_CODE,'"+locale+"','1') MAIL_REGION_DESC,MAIL_POSTAL_CODE,MAIL_COUNTRY_CODE,MP_GET_DESC.MP_COUNTRY(MAIL_COUNTRY_CODE,'"+locale+"','1') MAIL_COUNTRY_NAME,ALT_ID1_TYPE,ALT_ID1_NO,to_char(ALT_ID1_EXP_DATE,'dd/mm/yyyy') ALT_ID1_EXP_DATE ,ALT_ID2_TYPE,ALT_ID2_NO,to_char(ALT_ID2_EXP_DATE,'dd/mm/yyyy') ALT_ID2_EXP_DATE,ALT_ID3_TYPE,ALT_ID3_NO,to_char(ALT_ID3_EXP_DATE,'dd/mm/yyyy') ALT_ID3_EXP_DATE,ALT_ID4_TYPE,ALT_ID4_NO,to_char(ALT_ID4_EXP_DATE,'dd/mm/yyyy') ALT_ID4_EXP_DATE,OTH_ALT_ID_NO,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(OTH_ALT_ID_TYPE,'"+locale+"','2') alt_type_desc,OTH_ALT_ID_TYPE,OTH_ALT_ID_NO,no_of_slots ,MP_GET_DESC.mp_postal_code(POSTAL_CODE,'"+locale+"','1') postal_desc , MP_GET_DESC.mp_postal_code(MAIL_POSTAL_CODE,'"+locale+"','1') mail_postal_desc from oa_appt  where  facility_id='"+facilityid+"' and appt_ref_no='"+apptrefno+"' ";
		
		String sql="select sm_get_desc.sm_appl_user(added_by_id, ?, '1') appl_user_name,to_char(added_date,'dd/mm/yyyy hh24:mi') added_date,to_char(appt_slab_to_time,'hh24:mi') appt_slab_to_time, facility_id, appt_ref_no, clinic_code, OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,?,'1') CLINIC_SHORT_DESC,practitioner_id,decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,'1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,?,'2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,?,'2')) practitioner_short_name,OP_GET_DESC.OP_VISIT_TYPE(FACILITY_ID, APPT_TYPE_CODE,?,'2') visit_type_short_desc, appt_date, to_char(appt_time,'hh24:mi') appt_time, to_char(appt_slab_from_time,'hh24:mi') appt_slab_from_time, to_char(appt_slab_to_time,'hh24:mi') appt_slab_to_time, to_char(appt_duration,'hh24:mi') appt_duration, appt_slots, patient_id, name_prefix, first_name, second_name, third_name,family_name, name_suffix, decode(?,'en',patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name, gender, date_of_birth, res_tel_no res_tel_no,oth_contact_no, national_id_no, res_addr_line1, res_addr_line2, res_addr_line3,  res_addr_line4, postal_code, country_code, appt_type_code, (SELECT visit_type_ind  FROM op_visit_type b WHERE b.visit_type_code = a.appt_type_code AND b.facility_id = a.facility_id) VISIT_TYPE_IND,overbooked_yn,referral_id, mode_of_contact,contact_reason_code, AM_GET_DESC.AM_CONTACT_REASON(CONTACT_REASON_CODE,?,'1') CONTACT_REASON,appt_remarks, appt_status, inpatient_yn, encounter_id,email_id,alcn_criteria,calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),1) year1,calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),2) month1,calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),3) day1 ,alcn_catg_code,referral_id,MP_GET_DESC.MP_COUNTRY(COUNTRY_CODE,?,'1') nationality,team_id,alcn_criteria,pat_alcn_catg_code,MP_GET_DESC.MP_ETHNIC_GROUP(ETHNIC_GROUP_CODE,?,'1') ETHNIC_GROUP_DESC,MP_GET_DESC.MP_RACE(RACE_CODE,?,'1') RACE_DESC,CITIZEN_YN,LEGAL_YN,MP_GET_DESC.MP_BIRTH_PLACE(BIRTH_PLACE_CODE,?,'1') BIRTH_PLACE_DESC,to_char(receiving_date_time,'dd/mm/yyyy HH24:mi') receiving_date_time,RES_AREA_CODE,MP_GET_DESC.MP_RES_AREA(RES_AREA_CODE,?,'1') RES_AREA_DESC,RES_TOWN_CODE,MP_GET_DESC.MP_RES_TOWN(RES_TOWN_CODE,?,'1') RES_TOWN_DESC,RES_REGION_CODE,MP_GET_DESC.MP_REGION(RES_REGION_CODE,?,'1') RES_REGION_DESC,RES_COUNTRY_CODE,MP_GET_DESC.MP_COUNTRY(RES_COUNTRY_CODE,?,'1') RES_COUNTRY_NAME,MAIL_ADDR_LINE1,MAIL_ADDR_LINE2,MAIL_ADDR_LINE3,MAIL_ADDR_LINE4,MAIL_AREA_CODE,MP_GET_DESC.MP_RES_AREA(MAIL_AREA_CODE,?,'1') MAIL_AREA_DESC,MAIL_TOWN_CODE,MP_GET_DESC.MP_RES_TOWN(MAIL_TOWN_CODE,?,'1') MAIL_TOWN_DESC,MAIL_REGION_CODE,MP_GET_DESC.MP_REGION(MAIL_REGION_CODE,?,'1') MAIL_REGION_DESC,MAIL_POSTAL_CODE,MAIL_COUNTRY_CODE,MP_GET_DESC.MP_COUNTRY(MAIL_COUNTRY_CODE,?,'1') MAIL_COUNTRY_NAME, a.alt_addr_line1, a.alt_addr_line2, a.alt_addr_line3, a.alt_addr_line4, a.alt_area_code, MP_GET_DESC.MP_RES_AREA(a.alt_area_code,'"+locale+"','1') alt_area_desc, a.alt_town_code, MP_GET_DESC.MP_RES_TOWN(a.alt_town_code,'"+locale+"','1') alt_town_desc, a.alt_region_code, MP_GET_DESC.MP_REGION(a.alt_region_code,'"+locale+"','1') alt_region_desc, a.alt_postal_code, MP_GET_DESC.mp_postal_code(a.alt_postal_code,'"+locale+"','2') alt_postal_desc, a.alt_country_code, MP_GET_DESC.MP_COUNTRY(a.alt_country_code,'"+locale+"','1') alt_country_desc,ALT_ID1_TYPE,ALT_ID1_NO,to_char(ALT_ID1_EXP_DATE,'dd/mm/yyyy') ALT_ID1_EXP_DATE ,ALT_ID2_TYPE,ALT_ID2_NO,to_char(ALT_ID2_EXP_DATE,'dd/mm/yyyy') ALT_ID2_EXP_DATE,ALT_ID3_TYPE,ALT_ID3_NO,to_char(ALT_ID3_EXP_DATE,'dd/mm/yyyy') ALT_ID3_EXP_DATE,ALT_ID4_TYPE,ALT_ID4_NO,to_char(ALT_ID4_EXP_DATE,'dd/mm/yyyy') ALT_ID4_EXP_DATE,OTH_ALT_ID_NO,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(OTH_ALT_ID_TYPE,?,'2') alt_type_desc,OTH_ALT_ID_TYPE,OTH_ALT_ID_NO,no_of_slots ,MP_GET_DESC.mp_postal_code(POSTAL_CODE,?,'1') postal_desc , MP_GET_DESC.mp_postal_code(MAIL_POSTAL_CODE,?,'1') mail_postal_desc,TIME_TABLE_TYPE, to_char(sysdate,'dd/mm/yyyy')sys_date ,to_char(sysdate,'hh24:mi')sys_time from oa_appt a where facility_id=? and appt_ref_no=? ";//Modified by Thamizh selvi on 5th Feb 2018 against ML-MMOH-CRF-0601

		 pstmt=conn.prepareStatement(sql);

		 pstmt.setString(1,locale);
		 pstmt.setString(2,locale);
		 pstmt.setString(3,locale);
		 pstmt.setString(4,locale);
		 pstmt.setString(5,locale);
		 pstmt.setString(6,locale);
		 pstmt.setString(7,locale);
		 pstmt.setString(8,locale);
		 pstmt.setString(9,locale);
		 pstmt.setString(10,locale);
		 pstmt.setString(11,locale);
		 pstmt.setString(12,locale);
		 pstmt.setString(13,locale);
		 pstmt.setString(14,locale);
		 pstmt.setString(15,locale);
		 pstmt.setString(16,locale);
		 pstmt.setString(17,locale);
		 pstmt.setString(18,locale);
		 pstmt.setString(19,locale);
		 pstmt.setString(20,locale);
		 pstmt.setString(21,locale);
		 pstmt.setString(22,locale);
		 pstmt.setString(23,locale);
		 pstmt.setString(24,facilityid);
		 pstmt.setString(25,apptrefno);
		


		 rs1=pstmt.executeQuery();

		 
		if(rs1 != null) 
		{
			if(rs1.next())
			{
				  no_of_slots=rs1.getString("no_of_slots");
				  if(no_of_slots==null)no_of_slots="0";
				  team_id=rs1.getString("team_id");
				  if(team_id==null)team_id="";
				  user_name=rs1.getString("appl_user_name");
				  if(user_name==null)user_name="";
				  record_date=rs1.getString("added_date");
				  if(record_date==null)record_date="";
				  referral_id=rs1.getString("referral_id");
				  if(referral_id==null)referral_id="";
				  nationality=rs1.getString("nationality");
				  i_to_time=rs1.getString("appt_slab_to_time");
				  if(nationality==null)nationality="";
				  agey=rs1.getString("year1");
				  if(agey==null)agey="";
				  agem=rs1.getString("month1");
				  if(agem==null)agem="";
				  aged=rs1.getString("day1");	  
				  if(aged==null)aged="";
				 apptrefno1=rs1.getString("appt_ref_no");
				 if(apptrefno1 == null )apptrefno1="";
				 clinicshortdesc=rs1.getString("clinic_short_desc");
				 if(clinicshortdesc == null) clinicshortdesc="";
				 practitionerid=rs1.getString("practitioner_id");
				 if(practitionerid == null)practitionerid="";
				 practname=rs1.getString("practitioner_short_name");
				 if(practname == null) practname="";
				 visitshortdesc=rs1.getString("visit_type_short_desc");
				 if(visitshortdesc == null) visitshortdesc="";
				 appt_date1=rs1.getString("appt_date");
				 if(appt_date1 == null) appt_date1="";
				 visitind=rs1.getString("VISIT_TYPE_IND");
				 if(visitind == null) visitind="";
				 java.util.Date dateapd=rs1.getDate("appt_date");
				 SimpleDateFormat formatterapd = new SimpleDateFormat("dd/MM/yyyy");
				 apptdate=formatterapd.format(dateapd);
				 formatterapd = null;
				 appttime=rs1.getString("appt_time");
				 if(appttime == null) appttime="";
				 apptslabfmtime=rs1.getString("appt_slab_from_time");
				 if(apptslabfmtime == null) apptslabfmtime="";
				 apptslabtotime=rs1.getString("appt_slab_to_time");
				 if(apptslabtotime == null) apptslabtotime="";
				 disp_fromtime=apptslabfmtime;
				 disp_totime=apptslabtotime;
				 apptduration=rs1.getString("appt_duration");
				 if(apptduration == null) apptduration="";
				 patientid=rs1.getString("patient_id");
				 if(patientid == null) patientid="";
				 prefix=rs1.getString("name_prefix");
				 if( prefix == null) prefix="";
				 firstname=rs1.getString("first_name");
				 if(firstname== null) firstname="";
				 secondname=rs1.getString("second_name");
				 if(secondname == null) secondname="";
				 thirdname=rs1.getString("third_name");
				 if(thirdname == null) thirdname="";
				 familyname=rs1.getString("family_name");
				 if(familyname == null) familyname="";
				 suffix=rs1.getString("name_suffix");
				 if(suffix == null) suffix="";
				 patientname=rs1.getString("patient_name");
				 if(patientname == null) patientname="";
				ETHNIC_GROUP_DESC=rs1.getString("ETHNIC_GROUP_DESC");
				 if(ETHNIC_GROUP_DESC == null) ETHNIC_GROUP_DESC="";
				RACE_DESC=rs1.getString("RACE_DESC");
				 if(RACE_DESC == null) RACE_DESC="";
				CITIZEN_YN=rs1.getString("CITIZEN_YN");
				 if(CITIZEN_YN == null) CITIZEN_YN="";
				LEGAL_YN=rs1.getString("LEGAL_YN");
				 if(LEGAL_YN == null) LEGAL_YN="";
				BIRTH_PLACE_DESC=rs1.getString("BIRTH_PLACE_DESC");
				 if(BIRTH_PLACE_DESC == null) BIRTH_PLACE_DESC="";
				
				RES_AREA_CODE=rs1.getString("RES_AREA_CODE");
				 if(RES_AREA_CODE == null) RES_AREA_CODE="";
				RES_AREA_DESC=rs1.getString("RES_AREA_DESC");
				 if(RES_AREA_DESC == null) RES_AREA_DESC="";
				RES_TOWN_CODE=rs1.getString("RES_TOWN_CODE");
				 if(RES_TOWN_CODE == null) RES_TOWN_CODE="";
				RES_TOWN_DESC=rs1.getString("RES_TOWN_DESC");
				 if(RES_TOWN_DESC == null) RES_TOWN_DESC="";
				RES_REGION_CODE=rs1.getString("RES_REGION_CODE");
				 if(RES_REGION_CODE == null) RES_REGION_CODE="";
				RES_REGION_DESC=rs1.getString("RES_REGION_DESC");
				 if(RES_REGION_DESC == null) RES_REGION_DESC="";
				RES_COUNTRY_CODE=rs1.getString("RES_COUNTRY_CODE");
				 if(RES_COUNTRY_CODE == null) RES_COUNTRY_CODE="";
				RES_COUNTRY_NAME=rs1.getString("RES_COUNTRY_NAME");
				 if(RES_COUNTRY_NAME == null) RES_COUNTRY_NAME="";
				MAIL_ADDR_LINE1=rs1.getString("MAIL_ADDR_LINE1");
				 if(MAIL_ADDR_LINE1 == null) MAIL_ADDR_LINE1="";
				MAIL_ADDR_LINE2=rs1.getString("MAIL_ADDR_LINE2");
				 if(MAIL_ADDR_LINE2 == null) MAIL_ADDR_LINE2="";
				MAIL_ADDR_LINE3=rs1.getString("MAIL_ADDR_LINE3");
				 if(MAIL_ADDR_LINE3 == null) MAIL_ADDR_LINE3="";
				MAIL_ADDR_LINE4=rs1.getString("MAIL_ADDR_LINE4");
				 if(MAIL_ADDR_LINE4 == null) MAIL_ADDR_LINE4="";
				MAIL_AREA_CODE=rs1.getString("MAIL_AREA_CODE");
				 if(MAIL_AREA_CODE == null) MAIL_AREA_CODE="";
				MAIL_AREA_DESC=rs1.getString("MAIL_AREA_DESC");
				 if(MAIL_AREA_DESC == null) MAIL_AREA_DESC="";
				MAIL_TOWN_CODE=rs1.getString("MAIL_TOWN_CODE");
				 if(MAIL_TOWN_CODE == null) MAIL_TOWN_CODE="";
				MAIL_TOWN_DESC=rs1.getString("MAIL_TOWN_DESC");
				 if(MAIL_TOWN_DESC == null) MAIL_TOWN_DESC="";
				MAIL_REGION_CODE=rs1.getString("MAIL_REGION_CODE");
				 if(MAIL_REGION_CODE == null) MAIL_REGION_CODE="";
				MAIL_REGION_DESC=rs1.getString("MAIL_REGION_DESC");
				 if(MAIL_REGION_DESC == null) MAIL_REGION_DESC="";
				MAIL_POSTAL_CODE=rs1.getString("MAIL_POSTAL_CODE");
				 if(MAIL_POSTAL_CODE == null) MAIL_POSTAL_CODE="";
				MAIL_COUNTRY_CODE=rs1.getString("MAIL_COUNTRY_CODE");
				 if(MAIL_COUNTRY_CODE == null) MAIL_COUNTRY_CODE="";
				MAIL_COUNTRY_NAME=rs1.getString("MAIL_COUNTRY_NAME");
				 if(MAIL_COUNTRY_NAME == null) MAIL_COUNTRY_NAME="";
				ALT_ID1_TYPE=rs1.getString("ALT_ID1_TYPE");
				 if(ALT_ID1_TYPE == null) ALT_ID1_TYPE="";
				ALT_ID1_NO=rs1.getString("ALT_ID1_NO");
				 if(ALT_ID1_NO == null) ALT_ID1_NO="";
				ALT_ID1_EXP_DATE=rs1.getString("ALT_ID1_EXP_DATE");
				 if(ALT_ID1_EXP_DATE == null) ALT_ID1_EXP_DATE="";
				ALT_ID2_TYPE=rs1.getString("ALT_ID2_TYPE");
				 if(ALT_ID2_TYPE == null) ALT_ID2_TYPE="";
				ALT_ID2_NO=rs1.getString("ALT_ID2_NO");
				 if(ALT_ID2_NO == null) ALT_ID2_NO="";
				ALT_ID2_EXP_DATE=rs1.getString("ALT_ID2_EXP_DATE");
				 if(ALT_ID2_EXP_DATE == null) ALT_ID2_EXP_DATE="";
				ALT_ID3_TYPE=rs1.getString("ALT_ID3_TYPE");
				 if(ALT_ID3_TYPE == null) ALT_ID3_TYPE="";
				ALT_ID3_NO=rs1.getString("ALT_ID3_NO");
				 if(ALT_ID3_NO == null) ALT_ID3_NO="";
				ALT_ID3_EXP_DATE=rs1.getString("ALT_ID3_EXP_DATE");
				 if(ALT_ID3_EXP_DATE == null) ALT_ID3_EXP_DATE="";
				ALT_ID4_TYPE=rs1.getString("ALT_ID4_TYPE");
				 if(ALT_ID4_TYPE == null) ALT_ID4_TYPE="";
				ALT_ID4_NO=rs1.getString("ALT_ID4_NO");
				 if(ALT_ID4_NO == null) ALT_ID4_NO="";
				ALT_ID4_EXP_DATE=rs1.getString("ALT_ID4_EXP_DATE");
				 if(ALT_ID4_EXP_DATE == null) ALT_ID4_EXP_DATE="";
				OTH_ALT_ID_TYPE=rs1.getString("OTH_ALT_ID_TYPE");
				 if(OTH_ALT_ID_TYPE == null) OTH_ALT_ID_TYPE="";
				OTH_ALT_ID_NO=rs1.getString("OTH_ALT_ID_NO");
				 if(OTH_ALT_ID_NO == null) OTH_ALT_ID_NO="";
				alt_type_desc=rs1.getString("alt_type_desc");

				/*Added by Thamizh selvi on 5th Feb 2018 against ML-MMOH-CRF-0601 Start*/
				alt_addr_line1		= checkForNull(rs1.getString("alt_addr_line1"));
				alt_addr_line2		= checkForNull(rs1.getString("alt_addr_line2"));
				alt_addr_line3		= checkForNull(rs1.getString("alt_addr_line3"));
				alt_addr_line4		= checkForNull(rs1.getString("alt_addr_line4"));
				alt_area_code		= checkForNull(rs1.getString("alt_area_code"));
				alt_area_desc		= checkForNull(rs1.getString("alt_area_desc"));
				alt_town_code		= checkForNull(rs1.getString("alt_town_code"));
				alt_town_desc		= checkForNull(rs1.getString("alt_town_desc"));
				alt_region_code		= checkForNull(rs1.getString("alt_region_code"));
				alt_region_desc		= checkForNull(rs1.getString("alt_region_desc"));
				alt_postal_code		= checkForNull(rs1.getString("alt_postal_code"));
				alt_postal_desc		= checkForNull(rs1.getString("alt_postal_desc"));
				alt_country_code	= checkForNull(rs1.getString("alt_country_code"));
				alt_country_desc	= checkForNull(rs1.getString("alt_country_desc"));
				/*End*/

				time_tab_val1=rs1.getString("TIME_TABLE_TYPE");
				 if(time_tab_val1 == null) time_tab_val1="";
				str13=rs1.getString("sys_date");
				 if(str13 == null) str13="";
				str14=rs1.getString("sys_time");
				 if(str14 == null) str14="";

		 if(alt_type_desc == null) alt_type_desc="";
	
				receiving_date_time=rs1.getString("receiving_date_time");
				 if(receiving_date_time == null) receiving_date_time="";

				 gender=rs1.getString("gender");
			if(gender.equals("M")) 
				{
				genderdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				}
				else if(gender.equals("F")) {
				genderdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				}
				else if(gender.equals("U")) {
				genderdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
				}
			 java.util.Date date1 = rs1.getDate("date_of_birth");
			 if(date1 != null )
			{
				 SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
				 dateofbirth=formatter1.format(date1);
				 formatter1 = null;
			 }
			 else
				 dateofbirth="";

				restelno=rs1.getString("res_tel_no");
				if (restelno==null)
				restelno="";
				othtelno=rs1.getString("oth_contact_no");
				if(othtelno==null)
				othtelno="";
				emailid=rs1.getString("email_id");
				if(emailid==null)
				emailid="";
				nationalid=rs1.getString("national_id_no");
				if(nationalid == null) nationalid="";
				alternateid=rs1.getString("alt_id1_no");
				if(alternateid == null) alternateid="";
				resaddrl1=rs1.getString("res_addr_line1");
				if(resaddrl1 == null) resaddrl1="";
				resaddrl2=rs1.getString("res_addr_line2");
				if(resaddrl2 == null) resaddrl2="";
				resaddrl3=rs1.getString("res_addr_line3");
				if(resaddrl3 == null) resaddrl3="";
				resaddrl4=rs1.getString("res_addr_line4");
				if(resaddrl4 == null) resaddrl4="";
				postalcode=rs1.getString("postal_code");
				if(postalcode == null) postalcode="";
				postal_desc=rs1.getString("postal_desc");
				if(postal_desc == null) postal_desc="";
				mail_postal_desc=rs1.getString("mail_postal_desc");
				if(mail_postal_desc == null) mail_postal_desc="";


				contactAddress.append(""+"^^");
				contactAddress.append(resaddrl1+"^^");
				contactAddress.append(resaddrl2+"^^");
				contactAddress.append(resaddrl3+"^^");
				contactAddress.append(resaddrl4+"^^");
				contactAddress.append(RES_TOWN_CODE+"^^");
				contactAddress.append(RES_AREA_CODE+"^^");
				contactAddress.append(postalcode+"^^");
				contactAddress.append(RES_REGION_CODE+"^^");
				contactAddress.append(RES_COUNTRY_CODE+"^^");
				contactAddress.append(""+"^^");
				contactAddress.append(""+"^^");
				contactAddress.append(""+"^^");
				contactAddress.append(MAIL_ADDR_LINE1+"^^");
				contactAddress.append(MAIL_ADDR_LINE2+"^^");
				contactAddress.append(MAIL_ADDR_LINE3+"^^");
				contactAddress.append(MAIL_ADDR_LINE4+"^^");
				contactAddress.append(MAIL_TOWN_CODE+"^^");
				contactAddress.append(MAIL_AREA_CODE+"^^");
				contactAddress.append(MAIL_POSTAL_CODE+"^^");
				contactAddress.append(MAIL_REGION_CODE+"^^");
				contactAddress.append(MAIL_COUNTRY_CODE+"^^");
				contactAddress.append(""+"^^");
				contactAddress.append(""+"^^");
				contactAddress.append(restelno+"^^");
				contactAddress.append(othtelno+"^^");
				contactAddress.append(emailid+"^^");
				contactAddress.append(""+"^^");
				contactAddress.append(RES_TOWN_DESC+"^^");
				contactAddress.append(RES_AREA_DESC+"^^");
				contactAddress.append(RES_REGION_DESC+"^^");
				contactAddress.append(MAIL_TOWN_DESC+"^^");
				contactAddress.append(MAIL_AREA_DESC+"^^");
				contactAddress.append(MAIL_REGION_DESC+"^^");
				contactAddress.append(MAIL_COUNTRY_NAME+"^^");
				contactAddress.append(RES_COUNTRY_NAME+"^^");
				contactAddress.append(postal_desc+"^^");
				contactAddress.append(mail_postal_desc+"^^");
				/*Added by Thamizh selvi on 5th Feb 2018 against ML-MMOH-CRF-0601 Start*/
				contactAddress.append(alt_addr_line1+"^^");
				contactAddress.append(alt_addr_line2+"^^");
				contactAddress.append(alt_addr_line3+"^^");
				contactAddress.append(alt_addr_line4+"^^");
				contactAddress.append(alt_town_code+"^^");
				contactAddress.append(alt_area_code+"^^");
				contactAddress.append(alt_postal_code+"^^");
				contactAddress.append(alt_region_code+"^^");
				contactAddress.append(alt_country_code+"^^");
				contactAddress.append(alt_town_desc+"^^");
				contactAddress.append(alt_area_desc+"^^");
				contactAddress.append(alt_postal_desc+"^^");
				contactAddress.append(alt_region_desc+"^^");
				contactAddress.append(alt_country_desc);
				/*End*/

				countrycode=rs1.getString("country_code");
				if(countrycode == null) countrycode="";
				contactvals=resaddrl1+"^"+resaddrl2+"^"+resaddrl3+"^"+resaddrl4+"^"+postalcode+"^"+countrycode;
				appttypecode=rs1.getString("appt_type_code");
				if(appttypecode == null) appttypecode="";
				overbookedyn=rs1.getString("overbooked_yn");
				if(overbookedyn == null) overbookedyn="";
				referralcode=rs1.getString("referral_id");
				if(referralcode == null) referralcode="";
				pat_alcn_catg_code1=rs1.getString("alcn_catg_code");
			    if(pat_alcn_catg_code1 == null)pat_alcn_catg_code1="";
			    mode=rs1.getString("mode_of_contact");
				if(mode==null) 
				{
					mode="";
				}
				else 
				{
					if(mode.equals("E")) {
						modedesc="E-mail";
				}
				else if(mode.equals("T")) {
					modedesc="Telephone";
				}
				else if(mode.equals("F")) {
					modedesc="Fax";
				}
				else if(mode.equals("I")) {
					modedesc="In person";
				}
				else if(mode.equals("W")) {
					modedesc="Web";
				}
				else if(mode.equals("O")) {
					modedesc="Other";
				}
			}

				reasoncode=rs1.getString("contact_reason_code");
				if(reasoncode == null) reasoncode="";
				reasondesc=rs1.getString("contact_reason");
				if(reasondesc == null) reasondesc="";
				apptremarks=rs1.getString("appt_remarks");
				if(apptremarks==null)
				apptremarks="";
				pat_alcn_criteria=rs1.getString("alcn_criteria");
				pat_alcn_catg_code=rs1.getString("pat_alcn_catg_code");
	
		} // end of if rs.next()
	} // end if if rs != null 
	
		 if(rs1 !=null) rs1.close();
		 if(pat_alcn_criteria==null) pat_alcn_criteria="";
		 if(pat_alcn_catg_code==null) pat_alcn_catg_code="";
		 if(pre_pat_alcn_criteria.equals("")){
		 pre_pat_alcn_criteria=pat_alcn_criteria;
		 }
		 if(pre_pat_alcn_catg_code.equals("")){
		 pre_pat_alcn_catg_code=pat_alcn_catg_code;
		 }
	
			 //stmtsd=conn.createStatement();

			//String time_tab_type="select a.TIME_TABLE_TYPE,b.nat_id_prompt from oa_clinic_schedule_slot_slab a, mp_param b  where a.facility_id='"+facilityid+"' and  a.pri_appt_ref_no='"+apptrefno+"'  and  a.resource_class='"+res_type+"' and  a.clinic_code='"+clinic_code+"' and  a.care_locn_type_ind='"+clinic_type+"' and trunc( a.clinic_date)=to_date('"+i_appt_date+"','dd/mm/yyyy') and  a.facility_id= b.added_facility_id";

			/*String time_tab_type="select a.TIME_TABLE_TYPE, to_char(sysdate,'dd/mm/yyyy')sys_date ,        to_char(sysdate,'hh24:mi')sys_time from oa_clinic_schedule_slot_slab a   where a.facility_id='"+facilityid+"' and  a.pri_appt_ref_no='"+apptrefno+"'  and         a.resource_class='"+res_type+"' and  a.clinic_code='"+clinic_code+"' and         a.care_locn_type_ind='"+clinic_type+"' and trunc( a.clinic_date)=to_date('"+i_appt_date+"','dd/mm/yyyy')       ";
			
			rstt=stmtsd.executeQuery(time_tab_type);
			if(rstt !=null && rstt.next())
			{
					time_tab_val1=rstt.getString("TIME_TABLE_TYPE");
					str13=rstt.getString("sys_date");
					str14=rstt.getString("sys_time");
			}

			if(rstt !=null) rstt.close();
			*/
		 if(!(referral_id.equals(""))){
	 		stMent=conn.createStatement();

			 String sql_refral="select substr(get_referral_detail_line('"+referral_id+"','FROM','"+locale+"'),3,70) ref_line1,substr(get_referral_detail_line('"+referral_id+"','FROM','"+locale+"'),73)ref_line2 from dual";
			 rsSet=stMent.executeQuery(sql_refral);
			 rsSet.next();
			 referral_line=rsSet.getString("ref_line1");
			 referral_line1=rsSet.getString("ref_line2");
			 if(referral_line1 ==null) referral_line1="";
	 		 if(rsSet!=null) rsSet.close();
			 if(stMent!=null) stMent.close();

		 }





		
		stMent=conn.createStatement();
	
		rsSet=stMent.executeQuery("select MP_GET_DESC.MP_ALTERNATE_ID_TYPE(ALT_ID1_TYPE,'"+locale+"','1') alt_id1_desc, MP_GET_DESC.MP_ALTERNATE_ID_TYPE(ALT_ID2_TYPE,'"+locale+"','1') alt_id2_desc, MP_GET_DESC.MP_ALTERNATE_ID_TYPE(ALT_ID3_TYPE,'"+locale+"','1') alt_id3_desc, MP_GET_DESC.MP_ALTERNATE_ID_TYPE(ALT_ID4_TYPE,'"+locale+"','1') alt_id4_desc,nat_id_prompt FROM mp_param where module_id = 'MP'");
		if (rsSet!=null)
		{
			if(rsSet.next())
			{
				 ALT_ID1_Desc=rsSet.getString("alt_id1_desc");
				 ALT_ID2_Desc=rsSet.getString("alt_id2_desc");
				 ALT_ID3_Desc=rsSet.getString("alt_id3_desc");
				 ALT_ID4_Desc=rsSet.getString("alt_id4_desc");
				nat_id_prompt=rsSet.getString("nat_id_prompt");
				if (nat_id_prompt == null) nat_id_prompt="National Id No.";

				 if (ALT_ID1_Desc==null) ALT_ID1_Desc="";
				 if (ALT_ID2_Desc==null) ALT_ID2_Desc="";
				 if (ALT_ID3_Desc==null) ALT_ID3_Desc="";
				 if (ALT_ID4_Desc==null) ALT_ID4_Desc="";
				 ALT_ID1_Desc=ALT_ID1_Desc.trim();
				 ALT_ID2_Desc=ALT_ID2_Desc.trim();
				 ALT_ID3_Desc=ALT_ID3_Desc.trim();
				 ALT_ID4_Desc=ALT_ID4_Desc.trim();
	 		}
		}
/*******************************************************************************************************/
%>


<center>
<form name='sec_link_form' id='sec_link_form' action='../../servlet/eOA.BookAppointmentServlet' method='post' target='dummyFrame'>
<input type='hidden' name='help_function_id' id='help_function_id' value='CANCEL_APPOINTMENT'>
<%
			out.println("<input type='hidden' name='appt_ref_no' id='appt_ref_no' value='" + apptrefno +"'>");
%>
 <table border='0' cellpadding='3' cellspacing='0' width='98%' align='center' valign='top' >
				
		<tr>
				<td class='COLUMNHEADER' colspan ='2'><fmt:message key="Common.AppointmentDetails.label" bundle="${common_labels}"/></td>

				<%if(overbookedyn.equals("Y")) {%>
				
				<td class='COLUMNHEADER'  nowrap colspan='2'><fmt:message key="eOA.overbooking.label" bundle="${oa_labels}"/></td>
			
				<%}else{%>
		
				<td  class='COLUMNHEADER'  nowrap colspan='2'>&nbsp;</td>						
			
				<%}%>
		</tr>
			

		<tr>
				<td class='label' nowrap><fmt:message key="Common.apptno.label" bundle="${common_labels}"/></td>
					
				<td class='QUERYDATA' nowrap><%=apptrefno1%></td>
				<%
					String apptdate_display=DateUtils.convertDate(apptdate,"DMY","en",locale);
					
				%>
				<td class='label' nowrap><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/>/<fmt:message key="Common.appttime.label" bundle="${common_labels}"/></td>
					
				<td class='QUERYDATA' nowrap><%=apptdate_display%> <%=apptslabfmtime%> - <%=apptslabtotime%></td>
		</tr>			

		<tr>
				<td class='label'  nowrap><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
		
				<td class='QUERYDATA' nowrap><%=care_locn_ind_desc%></td>

				<td class='label' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
						
				<td class='QUERYDATA' nowrap><%=clinicshortdesc%></td>

		</tr>

		<tr>
						
				<td class='label'  nowrap><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>
				
				<td class='QUERYDATA' nowrap><%=res_class_desc%></td>
				
				<td class='label' nowrap><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
						
				<td class='QUERYDATA' nowrap><%=practname%></td>
						
		</tr>
					
		<tr>
						
				<td class='label' nowrap><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></td>
						
				<td class='QUERYDATA' nowrap><%=visitshortdesc%></td>

				<td  class='label'  nowrap colspan='2'>&nbsp;</td>	
						
										
		</tr>
	

<tr><td class='COLUMNHEADER'colspan = 4  ><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/> </td>
		</tr>
		
		<tr>
			<td  class='label' nowrap> <fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
			</td>
			<td   class='QUERYDATA' nowrap><%=patientid%>
			</td>
			<td  class='label' nowrap><fmt:message key="Common.name.label" bundle="${common_labels}"/>
			</td>
			<td class='QUERYDATA' nowrap><%=patientname%>
			</td>
		</tr>
			



<tr>

	<td class='label' nowrap ><%=nat_id_prompt%></td>
	<td  class='QUERYDATA' ><%=nationalid%></td>
	<td class='label' nowrap ><fmt:message key="Common.nationality.label" bundle="${common_labels}"/> </td>
	<td  class='QUERYDATA' ><%=nationality%></td>

</tr>

<%
	if(!ALT_ID1_EXP_DATE.equals(""))
	{
	 ALT_ID1_EXP_DATE_display=DateUtils.convertDate(ALT_ID1_EXP_DATE,"DMY","en",locale);
	}
	if(!ALT_ID2_EXP_DATE.equals(""))
	{
	 ALT_ID2_EXP_DATE_display=DateUtils.convertDate(ALT_ID2_EXP_DATE,"DMY","en",locale);
	}
	if(!ALT_ID3_EXP_DATE.equals(""))
	{
	 ALT_ID3_EXP_DATE_display=DateUtils.convertDate(ALT_ID3_EXP_DATE,"DMY","en",locale);
	}
	if(!ALT_ID4_EXP_DATE.equals(""))
	{
	 ALT_ID4_EXP_DATE_display=DateUtils.convertDate(ALT_ID4_EXP_DATE,"DMY","en",locale);
	}
%>


		<tr>
			<td  class='label'nowrap><%=ALT_ID1_Desc%></td>
			<td   class='QUERYDATA' nowrap><%=ALT_ID1_NO%>
			<td  class='label'  nowrap><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
			<td class='QUERYDATA' nowrap ><%=ALT_ID1_EXP_DATE_display%>
		
		</tr>



		<tr>
			<td class='label' nowrap><%=ALT_ID2_Desc%></td>
			<td  class='QUERYDATA' nowrap><%=ALT_ID2_NO%>
			<td class='label'  nowrap><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
			<td  class='QUERYDATA' nowrap ><%=ALT_ID2_EXP_DATE_display%>
			
		</tr>

		<tr>
			<td  class='label'  nowrap><%=ALT_ID3_Desc%></td>
			<td  class='QUERYDATA' nowrap><%=ALT_ID3_NO%>

			<td  class='label'nowrap><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
			<td class='QUERYDATA' nowrap ><%=ALT_ID3_EXP_DATE_display%>


		</tr>

		<tr>
			<td class='label' nowrap><%=ALT_ID4_Desc%></td>
			<td  class='QUERYDATA' nowrap><%=ALT_ID4_NO%>
			<td class='label'  nowrap><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
			<td  class='QUERYDATA' nowrap ><%=ALT_ID4_EXP_DATE_display%>
	
		</tr>


		<tr>	
			<td class='label'  nowrap><fmt:message key="Common.OtherAltType.label" bundle="${common_labels}"/></td>
				
				<td  class='QUERYDATA' nowrap ><%=alt_type_desc%></td>

				<td class='label'  nowrap><fmt:message key="Common.otheraltid.label" bundle="${common_labels}"/></td>
				
				<td  class='QUERYDATA' nowrap ><%=OTH_ALT_ID_NO%></td>
	</tr>


<tr>
	<td  class='label'  nowrap ><fmt:message key="Common.birthPlace.label" bundle="${common_labels}"/></td>
	<td  class='QUERYDATA' ><%=BIRTH_PLACE_DESC%></td>

	<td   class="label"  nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
		<td  class='QUERYDATA' nowrap><%=genderdesc%></td>


</tr>



		<tr>
			
			<td class='label'  nowrap><fmt:message key="Common.age.label" bundle="${common_labels}"/></td>
			<td  class='QUERYDATA' nowrap><%=agey%>Y&nbsp;<%=agem%>M&nbsp;<%=aged%>D&nbsp;</td>

<%
String dateofbirth_display=DateUtils.convertDate(dateofbirth,"DMY","en",locale);	
%>
			<td class='label' nowrap><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></td>
			<td  class='QUERYDATA' nowrap><%=dateofbirth_display%></td>
		</tr>

<tr>
<td  class='label'  nowrap ><fmt:message key="Common.residency.label" bundle="${common_labels}"/></td>
	<td class='QUERYDATA' >
	<%if(CITIZEN_YN.equals("Y")){%>
		<fmt:message key="Common.citizen.label" bundle="${common_labels}"/>
	<%}else{%>
		<fmt:message key="Common.noncitizen.label" bundle="${common_labels}"/>
	<%}%>
	</td>
	<td  class='label'  nowrap ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
	<td  class='QUERYDATA' >
	<%if(LEGAL_YN.equals("Y")){%>
		<fmt:message key="Common.legal.label" bundle="${common_labels}"/>
	<%}else{%>
	<fmt:message key="Common.illegal.label" bundle="${common_labels}"/>	
	<%}%>	
	</td>
</tr>



		<tr>
					<%if(!(nationalid.equals(""))){%>
					
						<td  class='label' nowrap ><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
						<td class='QUERYDATA' ><%=nationality%></td>

						<td class='label'  nowrap ><fmt:message key="Common.race.label" bundle="${common_labels}"/></td>
						<td  class='QUERYDATA' ><%=RACE_DESC%></td>
					<%}else{%>
						<td  class='label' nowrap ><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
						<td   class='QUERYDATA' ><%=nationality%></td>
						
						<td class='label'  nowrap ><fmt:message key="Common.race.label" bundle="${common_labels}"/></td>
						<td  class='QUERYDATA' ><%=RACE_DESC%></td>
					<%}%>   
			</tr>
	<tr>
		<td  class='label'  nowrap><fmt:message key="eMP.ethnicity.label" bundle="${mp_labels}"/></td>
		<td  class='QUERYDATA'  nowrap><%=ETHNIC_GROUP_DESC%></td>

	<td class='button' colspan='2'><input type='button' name='ContactDetails' id='ContactDetails' value='<fmt:message key="Common.ContactDetails.label" bundle="${common_labels}"/>' onClick='Modal_Contact_Details()' class="BUTTON" >
				</td>
    </tr>

	<tr><td  class='COLUMNHEADER' colspan =4 ><fmt:message key="Common.otherDetails.label" bundle="${common_labels}"/> </td>
			</tr>
			
			<tr>
			   <td  class='label'  nowrap><fmt:message key="Common.ContactReason.label" bundle="${common_labels}"/>
				</td>

				<td  class='QUERYDATA' nowrap colspan = 3><%=reasondesc%>
				</td>
			</tr>
			


			<tr>
				<td class='label' nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>
				</td>
				<td class='QUERYDATA' colspan =3><%=apptremarks%>
				</td>
			</tr>
		

			<tr>
				<td  class='label'  nowrap><fmt:message key="Common.contactmode.label" bundle="${common_labels}"/>
				</td>
				<td  class='QUERYDATA' nowrap><%=modedesc%>
				</td>
<%
		String receiving_date_time_display=DateUtils.convertDate(receiving_date_time,"DMYHM","en",locale);
%>
				<td  class='label' nowrap><fmt:message key="Common.ReceivingDateTime.label" bundle="${common_labels}"/>
				</td>
				<td class='QUERYDATA'  nowrap><%=receiving_date_time_display%>
				</td>
			</tr>
		


			<tr>
				<td  class='label'  nowrap><fmt:message key="Common.RecordedBy.label" bundle="${common_labels}"/>
				</td>
				<td  class='QUERYDATA'   nowrap><%=user_name%>
				</td>
				<%
		String record_date_display=DateUtils.convertDate(record_date,"DMYHM","en",locale);
%>
				<td  class='label'  nowrap><fmt:message key="Common.RecordedOn.label" bundle="${common_labels}"/>
				</td>
				<td  class='QUERYDATA'nowrap><%=record_date_display%>						
				</td>
			</tr>	
			
			
			
	<%
	if((referral_line!=null && !(referral_line.equals(""))) || (referral_line1 !=null && !(referral_line1.equals("")))){
	%>
			
	
	<td class='COLUMNHEADER' colspan =4 nowrap><fmt:message key="Common.referraldetails.label" bundle="${common_labels}"/></td>




	<tr><td class='QUERYDATA' nowrap colspan =4><%=referral_line%></td></tr>	
		<tr><td  class='QUERYDATA' nowrap colspan =4><%=referral_line1%></td></tr>	
	<%
	}
	%>

	
	</table>

	<%

		String sec_resources="";
		if(!overbookedyn.equals("Y"))
		{
			//String secsql="select resource_class,resource_criteria from op_resource_type_for_appt where facility_id='"+facilityid+"' and visit_type_code='"+appttypecode+"' and resource_class !='"+res_type+"'  order by resource_class ";
			String secsql="select resource_class,resource_criteria from op_resource_type_for_appt where facility_id=? and visit_type_code=? and resource_class !=?  order by resource_class ";

			if(pstmt !=null) pstmt.close();
			pstmt=conn.prepareStatement(secsql);
			pstmt.setString(1,facilityid);
			pstmt.setString(2,appttypecode);
			pstmt.setString(3,res_type);



			rs1 = pstmt.executeQuery();

			while(rs1!=null && rs1.next())
			{
				 sec_resources=sec_resources+rs1.getString("resource_class");
				 sec_resources=sec_resources+"*"+rs1.getString("resource_criteria")+"-";
			}
			 
			 if(sec_resources.length()>1)
			 sec_resources=sec_resources.substring(0,sec_resources.length()-1);
			 if(rs1 !=null) rs1.close();
	   }

%>
<table border='0' cellpadding='0' cellspacing='0' width='5%' align='right' id='allbuttons'>

<tr>

<%if(! sec_resources.equals("")){%>
	<td  align='right'>
	<input type='button' name='secres' id='secres' value='<fmt:message key="eOA.SecondaryResources.label" bundle="${oa_labels}"/>' class="BUTTON" onclick="show_second1()"></td>

<%}	%>
<td  align='right'><input type='button' name='Apply' id='Apply' value='<fmt:message key="Common.apply.label" bundle="${common_labels}"/>'  class="BUTTON" onclick='valcheck2()'></td>


<td  align='right'><input type='button' name='close' id='close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'  class="BUTTON" onclick='exitwin_normal()'>
<input type='hidden' name='cancelappt' id='cancelappt' value=''>
<input type='hidden' name='revappt' id='revappt' value=''>
</td>
</tr>
</table>

<BR>
	<% 

%>
		<input type="hidden" name="sec_resources" id="sec_resources" value="<%=sec_resources%>">
		<input type="hidden" name="sec_sel" id="sec_sel" value="">
		<input type="hidden" name="sec_sel222" id="sec_sel222" value="">
		<input type="hidden" name="appttypecode" id="appttypecode" value="<%=appttypecode%>">
		<input type='hidden' name='no_of_slots' id='no_of_slots' value='<%=no_of_slots%>' >
		<input type='hidden' name='function_name' id='function_name' value='Link' >
		<input type='hidden' name='function1' id='function1' value=''>
		<input type='hidden' name='function_name' id='function_name' value='insert'>
		<input type='hidden' name='transfer' id='transfer' value=<%= transfer %> >
		<input type='hidden' name='value13' id='value13' value=<%= value13 %> >
		<input type='hidden' name='new_from_time' id='new_from_time' value=<%=i_from_time %> >
		<input type='hidden' name='new_to_time' id='new_to_time' value=<%=i_to_time %> >
		<input type='hidden' name='appt_date' id='appt_date'  value=<%=i_appt_date%> >
		<input type='hidden' name='clinic_code' id='clinic_code' value=<%=clinic_code%> >
		<input type='hidden' name='practitioner_id' id='practitioner_id' value=<%=practitioner_id%> >
		<input type='hidden' name='dateapd' id='dateapd' value=<%=apptdate%> >
		<input type='hidden' name='over_booked' id='over_booked' value=<%=over_booked%> >
		<input type='hidden' name='overbooked_yn' id='overbooked_yn' value=<%=overbookedyn %> >
		<input type='hidden' name='ServerDate' id='ServerDate' value='<%=str13%>'>
		<input type='hidden' name='ServerTime' id='ServerTime' value='<%=str14%>' >
		<input type='hidden' name='old_date' id='old_date' value='<%=old_date%>'>
		<input type='hidden' name='visitind' id='visitind' value='<%=visitind%>' >
		<input type='hidden' name='patientid' id='patientid' value='<%=patientid%>' >
		<input type='hidden' name='old_from_time' id='old_from_time' value='<%=old_from_time%>' >
		<input type='hidden' name='old_to_time' id='old_to_time' value='<%=old_to_time%>' >
		<input type='hidden' name='pre_pat_alcn_criteria' id='pre_pat_alcn_criteria' value='<%=pre_pat_alcn_criteria%>' >
		<input type='hidden' name='alcn_criteria' id='alcn_criteria' value='<%=alcn_criteria%>' >
		<input type='hidden' name='pre_pat_alcn_catg_code' id='pre_pat_alcn_catg_code' value='<%=pre_pat_alcn_catg_code%>' >
		<input type='hidden' name='alcn_catg_code' id='alcn_catg_code' value='<%=alcn_catg_code%>' >
		<input type='hidden' name='disp_date' id='disp_date' value='<%=apptdate%>' >
		<input type='hidden' name='contactvals' id='contactvals' value="<%=contactvals%>" >
		<input type='hidden' name='disp_fromtime' id='disp_fromtime' value='<%=disp_fromtime%>' >
		<input type='hidden' name='disp_totime' id='disp_totime' value='<%=disp_totime%>' >
		<input type='hidden' name='i_time_table_type' id='i_time_table_type' value='<%=time_tab_val1%>' >
		<input type='hidden' name='tfr_appt_across_catg_yn' id='tfr_appt_across_catg_yn' value='<%=tfr_appt_across_catg_yn%>' >
		<input type='hidden' name='obook_appt_yn' id='obook_appt_yn' value='<%=obook_appt_yn%>' >
		<input type='hidden' name='team_id' id='team_id' value='<%=team_id%>' >
		<input type='hidden' name='cancel_flag' id='cancel_flag' value="">
		<input type='hidden' name='flag' id='flag' value="<%=flag%>">
		<input type='hidden' name='Forced' id='Forced' value="<%=Forced%>">
		<input type="hidden" name="clinic_type" id="clinic_type" value="<%=clinic_type%>">
		<input type="hidden" name="res_type" id="res_type" value="<%=res_type%>">
		<input type='hidden' name='concat_address_hidden' id='concat_address_hidden' value='<%=contactAddress.toString()%>'>	
		<input type='hidden' name='facilityid' id='facilityid' value='<%=facilityid%>'>		
		<input type='hidden' name='sec_value_count' id='sec_value_count' value=''>
		<input type='hidden' name='clinic_name_sec' id='clinic_name_sec' value='<%=clinicshortdesc%>'>
		<input type='hidden' name='care_locn_desc_sec' id='care_locn_desc_sec' value='<%=care_locn_ind_desc%>'>
		<input type='hidden' name='res_pri_class_desc' id='res_pri_class_desc' value='<%=res_class_desc%>'>
		<input type='hidden' name='pract_name_pri' id='pract_name_pri' value='<%=practname%>'>
		<input type='hidden' name='visitshortdesc' id='visitshortdesc' value='<%=visitshortdesc%>'>
		<input type='hidden' name='isAlternateAddressAppl' id='isAlternateAddressAppl' value="<%=isAlternateAddressAppl%>"><!--Added by Thamizh selvi on 5th Feb 2018 against ML-MMOH-CRF-0601-->
	
	
	</form>
	<%
	if (rs1 != null) rs1.close();
	//if (rssd !=null) rssd.close();
	if(rsSet !=null)rsSet.close();
	//if (Rset_Nat_Id!= null) Rset_Nat_Id.close();
	//if (rsgrp !=null) rsgrp.close();
	//if (rstt !=null) rstt.close();
	//if (stmtgrp!=null) stmtgrp.close();	
	if(stMent !=null)stMent.close();
	//if (stmtsd!=null) stmtsd.close();				
	if (pstmt != null) pstmt.close();
	//if (Stmt_Nat_Id !=null) Stmt_Nat_Id.close();
 }catch(Exception e) { 
	 e.printStackTrace();
 }
	finally
	{
		if(conn != null) ConnectionManager.returnConnection(conn,request);
	}
%>
<%!
public static String checkForNull(String inputString)
{
	return ( ((inputString == null) || (inputString.equals("null"))) ? "" : inputString );
}
%>
</body>
</html>

