<!DOCTYPE html>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import= "webbeans.eCommon.*,java.util.*,java.text.*, java.sql.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="obj" scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script src="../../eCommon/js/dchk.js" language="javaScript"></script>
<script src="../../eIP/js/Booking.js" language="JavaScript"></script>
<script src="../../eIP/js/Booking1.js" language="JavaScript"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script language='javascript' src='../../eIP/js/IPPractitionerComponent.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style type="text/css">
ul {
    display: block;
    list-style-type: disc;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    padding-inline-start: 0px;
    unicode-bidi: isolate;
}
</style>


<TITLE><fmt:message key="eIP.BookingAdmissionDetails.label" bundle="${ip_labels}"/> </TITLE>
</HEAD>
<% 
	String	loginUser				= (String)session.getAttribute("login_user");
	StringBuffer sql				= new StringBuffer();
	String	sqlsd2					= "";
	String	DayVal					= ""; 
	String	generatenumyn			= "";
	String	bed_no					= "";
	String	service_code			= "";
	String  service_desc			= "";
	String	old_nursing_unit		= "";
	String	nursing_unit_code		= "";
	String	nursing_unit_short_desc = "";
	String  bed_class_desc			= "";
	String  bed_class_code			= "";
	String  bed_type_desc			= "";
	String  bed_type_code			= "";
	String checkBoxAttribute		= "";
	String medservdesc				= "";
	String medservcode				= "";
	String app_pat_class			= "";
	String sqlsd1					= "";
	String booking_ref_no			= "";
	String  Patient_Id	            = "";
	String  medical_service	        = "";
	String  booking_date_time	    = "";
	String  medical_speciality_desc	= "";
	String  medical_speciality_code	= "";
	String  physician_desc      	= "";
	String  physician_code	        = "";
	String	oper_room_code			= "";
	String oper_room_desc			= "";
	String patient_class			= "";
	String override_yn				= "N";
	String confirm_bkg_auth			= "N";
	String speciality_code			= "";
	String patientid				= "";
	String pref_date				= "";
	String spl_desc					= "";
	String pract_id					= "";
	String pract_name				= "";
	String national_id				= "";
	String name_prfx				= "";
	String patient_name				= "";
	String gender					= "";
	//String date_of_birth			= "";
	String country_code				= "";
	String race_desc				= "";
	String race_code				= "";
	String ethic_code				= "";
	String ethic_desc				= "";
	String birth_place				= "";
	String family_name				= "";
	String name_sufx				= "";
	String locale					= (String)session.getAttribute("LOCALE");
	String facilityID				= (String)session.getAttribute("facility_id");
	String queryString				= (String) session.getAttribute( "queryString" ) ;
	String disabledAttrib			= "disabled";
	String med_hid_val				= "disabled";
	String referral_id				= checkForNull(request.getParameter("referral_id"));
	String is_ca_yn					= checkForNull(request.getParameter("is_ca_yn"));
	String ca_patient_id			= checkForNull(request.getParameter("ca_patient_id"));
	String call_function			= request.getParameter("call_function");
	String oa_patient_id			= request.getParameter("oa_patient_id");
	String is_oa_yn					= checkForNull(request.getParameter("is_oa_yn"));
	String wait_ref_no				= checkForNull(request.getParameter("oa_wait_ref_no"));
	String oa_pref_date				= checkForNull(request.getParameter("oa_pref_date_time"));
	String p_oper_stn_id			= checkForNull(request.getParameter("oper_stn_id"));
	String allowed_booking_type		= checkForNull(request.getParameter("allowed_booking_type"));
	String multi_book_pat_yn		= checkForNull(request.getParameter("multi_book_pat_yn"));
	String chk_booking_limit_by		= checkForNull(request.getParameter("chk_booking_limit_by"));
	String Unregpatbkgyn			= checkForNull(request.getParameter("unregistered_patients_bkg_yn"));
	String bl_interfaced_yn			= checkForNull(request.getParameter("bl_interfaced_yn"));	
	String capture_fin_dtls_yn		= checkForNull(request.getParameter("capture_fin_dtls_yn"));	
	String bl_operational			= (String)session.getValue("bl_operational");
	String block_bed_based_on		= checkForNull(request.getParameter("block_bed_based_on"));	
	String is_op_pending_referral_booking = checkForNull(request.getParameter("is_op_pending_referral_booking"));
	String deactivate_pseudo_bed_yn = checkForNull(request.getParameter("deactivate_pseudo_bed_yn"),"N");
	String create_booking_with_conf_yn = checkForNull(request.getParameter("create_booking_with_conf_yn"),"N");
	String bkg_grace_period			= checkForNull(request.getParameter("bkg_grace_period"));
	sqlsd2							= checkForNull(request.getParameter("sqlsd2"));
	sqlsd1							= sqlsd2.substring(0,10);
	
	String	oa_alt_id1				= "";
	String	oa_alt_id1_exp_date		= "";
	String	oa_alt_id2				= "";
	String	oa_alt_id2_exp_date		= "";
	String	oa_alt_id3				= "";
	String	oa_alt_id3_exp_date		= "";
	String	oa_alt_id4				= "";
	String	oa_alt_id4_exp_date		= "";
	String	oa_oth_alt_id			= ""; 
	String	oa_first_name			= "";
	String	oa_second_name			= "";
	String	oa_third_name			= "";
	String	oa_name_prefix_loc_lang	= "";
	String	oa_first_name_loc_lang	= "";
	String	oa_second_name_loc_lang	= "";
	String	oa_third_name_loc_lang	= "";
	String	oa_family_name_loc_lang	= "";
	String	oa_name_suffix_loc_lang	= "";
	String	oa_date_of_birth		= "";
	String	oa_oth_alt_id_type		= "";
	String	oa_years				= "";
	String	oa_months				= "";
	String	oa_days					= "";
	String	oa_patient_name_loc_lang	= "";
	String	oa_addr_line1			= "";
	String	oa_addr_line2			= "";
	String	oa_addr_line3			= "";
	String	oa_addr_line4			= "";
	String	oa_res_area_code		= "";
	String	oa_res_area_desc		= "";
	String	oa_res_reg_code			= "";
	String	oa_res_reg_desc			= "";
	String	oa_res_town_code		= "";
	String	oa_res_town_desc		= "";
	String	oa_res_country_code		= "";
	String	oa_res_country_name		= "";
	String	oa_res_postal_code		= "";
	String	oa_email_id				= "";
	String	oa_res_tel_no			= "";
	String	oa_oth_contact_no		= "";
	String	oa_res_postal_desc		= "";
	String	oa_mail_postal_desc		= "";
	String	oa_mail_addr_line1			= "";
	String	oa_mail_addr_line2			= "";
	String	oa_mail_addr_line3			= "";
	String	oa_mail_addr_line4			= "";
	String	oa_mail_res_area_code		= "";
	String	oa_mail_res_area_desc		= "";
	String	oa_mail_res_reg_code			= "";
	String	oa_mail_res_reg_desc			= "";
	String	oa_mail_res_town_code		= "";
	String	oa_mail_res_town_desc		= "";
	String	oa_mail_res_country_code		= "";
	String	oa_mail_res_country_name		= "";
	String oa_mail_res_postal_code			= "";
	String max_patient_age					= "";
	String PreOpPreparationDays				= "";
	//String booking_type_code				= "";
	//String booking_long_desc				= "";
	/*modification for SRR20056-CRF-0506*/
	ArrayList bookingtype_list				= new ArrayList();	
	//Included for the CRF RUT-CRF-013
	TreeMap patInstructionsMap=(java.util.TreeMap)session.getAttribute("ipPatInstructionsMap");			
	if(patInstructionsMap != null)
	{
		patInstructionsMap.clear();	
		session.setAttribute("ipPatInstructionsMap",patInstructionsMap);
	}

	boolean isBlInterfaced = false;

	if(bl_interfaced_yn.equals("Y"))
		isBlInterfaced = true;
	else 
		isBlInterfaced = false;

	if(call_function==null || call_function.equals("")) 
		call_function="IP_Booking";

	boolean isReviseBkgAftrConfrmAppl = false;

	Connection			con 		= null;
	Statement			stmt		= null;
	PreparedStatement	pstmt		= null;
	ResultSet			rs 			= null;
	ResultSet			prs			= null;
	con		= ConnectionManager.getConnection(request);
	if(call_function.equals("OT"))
	{

		Patient_Id				= checkForNull(request.getParameter("Patient_Id"));
		medical_service			= checkForNull(request.getParameter("medical_service"));
		booking_date_time		= checkForNull(request.getParameter("booking_date_time"));
		medical_speciality_desc	= checkForNull(request.getParameter("medical_speciality_desc"));
		medical_speciality_code	= checkForNull(request.getParameter("medical_speciality_code"));
		physician_desc			= checkForNull(request.getParameter("physician_desc"));
		physician_code			= checkForNull(request.getParameter("physician_code"));
		oper_room_code			= checkForNull(request.getParameter("oper_room_code"));
		patient_class			= checkForNull(request.getParameter("patient_class"));
		oper_room_desc			= checkForNull(request.getParameter("oper_room_desc"));
		PreOpPreparationDays	= checkForNull(request.getParameter("PreOpPreparationDays"),"0");
		/*Saturday, June 13, 2009 modified for IN010922 */
		if(patient_class!=null && patient_class.equals("IP"))
		{
			nursing_unit_code		= checkForNull(request.getParameter("nursing_unit_code"));
			//nursing_unit_short_desc	= checkForNull(request.getParameter("nursing_unit_desc"));


			String OT_SQL="select a.nursing_unit_code code,a.short_desc description from ip_nursing_unit_lang_vw a, am_os_user_locn_access_vw b where a.language_id=? and a.facility_id=? and a.patient_class='IP' and a.facility_id=b.facility_id and a.EFF_STATUS = 'E' and a.nursing_unit_code=b.locn_code and a.locn_type=b.locn_type and b.locn_type = 'N'  and b.appl_user_id=?  and  a.nursing_unit_code = ? ";


/* 			stmt	= con.createStatement();
			rs		= stmt.executeQuery(OT_SQL.toString()); */
			
			pstmt = con.prepareStatement(OT_SQL);
			pstmt.setString(1, locale);
			pstmt.setString(2, facilityID);
			pstmt.setString(3, loginUser);
			pstmt.setString(4, nursing_unit_code);
			
			rs = pstmt.executeQuery();
        
			if(rs.next())
			{
				nursing_unit_short_desc= checkForNull(rs.getString("description"));			
			} 	

			if(rs	 != null)   rs.close();
			if(pstmt	 != null)   pstmt.close();
	
		}
	
			
	
		

		if(patient_class!=null && patient_class.equals("IP"))
			patient_class = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
		else if(patient_class!=null && patient_class.equals("DC"))
			patient_class = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
		else if(patient_class!=null && patient_class.equals("EM"))
			patient_class = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
		else if(patient_class!=null && patient_class.equals("OP"))
			patient_class = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
		else 
			patient_class = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels");





	}
 
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" );
	java.util.Date dt	= new java.util.Date();
	String Sdate		= dateFormat.format( dt ) ;
	Sdate				=	Sdate + " "+String.valueOf(dt.getHours())+":"+String.valueOf(dt.getMinutes());
	
	//sql.append("select to_char(sysdate,'dd/mm/rrrr hh24:mi') sdate from dual");
	
	try
	{ 

		isReviseBkgAftrConfrmAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "IP","REVISE_BKG_AFTR_CONFIRM");//Added by Thamizh selvi on 22nd May 2018 against ML-MMOH-CRF-0622

		/*
		stmt	= con.createStatement();
		rs		= stmt.executeQuery(sql.toString());
        
		if(rs.next())
		{
			sqlsd2= checkForNull(rs.getString("sdate"));			
		} 	

		if(rs	 != null)   rs.close();
		if(stmt	 != null)   stmt.close();
		*/
		
		// This query is used for checking whether this operator station have confirmation booking or not..
		/*
		StringBuffer confSql = new StringBuffer();
		confSql.append(" select CREATE_BOOKING_WITH_CONF_YN from AM_OPER_STN where FACILITY_ID = '");
		confSql.append(facilityID);
		confSql.append("' and OPER_STN_ID = '");
		confSql.append(p_oper_stn_id);
		confSql.append("'");
		stmt	= con.createStatement();
		rs = stmt.executeQuery(confSql.toString());
		if (rs.next())
		{
			confirm_bkg_auth = rs.getString("CREATE_BOOKING_WITH_CONF_YN");
		}
		
		if(rs	 != null)   rs.close(); 
		if(stmt	 != null)   stmt.close();
		*/
		if(is_oa_yn.equals("Y"))
		{
			StringBuffer ref_sql = new StringBuffer();
			if(rs	 != null)   rs.close();
			if(stmt	 != null)   stmt.close();
			
			if(ref_sql.length() > 0) ref_sql.delete(0,ref_sql.length());
			
			ref_sql.append("select SPECIALTY_CODE, PATIENT_ID, SPECIALITY_DESC, BOOKING_REF_NO, PRACTITIONER_ID , PRACTITIONER_FULL_NAME, NATIONAL_ID_NO, NAME_SUFFIX, NAME_PREFIX, patient_name, patient_name_loc_lang, GENDER, BIRTH_PLACE_DESC, RES_COUNTRY_CODE, RACE_DESC, RACE_CODE, ETHNIC_GROUP_CODE, ETHNIC_GROUP_DESC, FAMILY_NAME, to_char(preferred_date_time,'dd/mm/rrrr hh24:mi') preferred_date_time, to_char(date_of_birth,'dd/mm/rrrr') date_of_birth ");
			ref_sql.append(" ,calculate_age(to_char(DATE_OF_BIRTH,'dd/mm/rrrr'),1) years,calculate_age(to_char(DATE_OF_BIRTH,'dd/mm/rrrr'),2) months,calculate_age(to_char(DATE_OF_BIRTH,'dd/mm/rrrr'),3) days");
			ref_sql.append(" ,ALT_ID1_NO, to_char(ALT_ID1_EXP_DATE,'dd/mm/rrrr') ALT_ID1_EXP_DATE,ALT_ID2_NO, to_char(ALT_ID2_EXP_DATE,'dd/mm/rrrr') ALT_ID2_EXP_DATE,ALT_ID3_NO, to_char(ALT_ID3_EXP_DATE,'dd/mm/rrrr') ALT_ID3_EXP_DATE,ALT_ID4_NO,  to_char(ALT_ID4_EXP_DATE,'dd/mm/rrrr') ALT_ID4_EXP_DATE,OTH_ALT_ID_NO, OTH_ALT_ID_TYPE"); 		
			ref_sql.append(" ,FIRST_NAME,SECOND_NAME, THIRD_NAME, NAME_PREFIX_LOC_LANG, FIRST_NAME_LOC_LANG, SECOND_NAME_LOC_LANG, THIRD_NAME_LOC_LANG, FAMILY_NAME_LOC_LANG, NAME_SUFFIX_LOC_LANG "); 		

			ref_sql.append(" ,RES_ADDR_LINE1,RES_ADDR_LINE2, RES_ADDR_LINE3, RES_ADDR_LINE4, RES_AREA_CODE, RES_AREA_DESC, RES_REGION_CODE, RES_REGION_DESC, RES_TOWN_CODE, RES_TOWN_DESC,RES_COUNTRY_CODE,RES_COUNTRY_NAME,RES_POSTAL_CODE,	 MAIL_ADDR_LINE1,MAIL_ADDR_LINE2, MAIL_ADDR_LINE3, MAIL_ADDR_LINE4, MAIL_AREA_CODE, MAIL_AREA_DESC, MAIL_REGION_CODE, MAIL_REGION_DESC, MAIL_TOWN_CODE , MAIL_TOWN_DESC,MAIL_COUNTRY_CODE,MAIL_COUNTRY_NAME,MAIL_POSTAL_CODE,EMAIL_ID, RES_TEL_NO, OTH_CONTACT_NO ,MP_GET_DESC.MP_POSTAL_CODE(RES_POSTAL_CODE,?,'2') POSTAL_DESC, MP_GET_DESC.MP_POSTAL_CODE(MAIL_POSTAL_CODE,?,'2') MAIL_POSTAL_DESC ");
      		
			ref_sql.append(" from PR_WAIT_LIST_VW where facility_id = ? and  wait_list_no=?");

			//out.println("<script>alert(\""+ref_sql.toString()+"\");</script>");

/* 			stmt = con.createStatement();
			rs	 = stmt.executeQuery(ref_sql.toString()); */

			pstmt = con.prepareStatement(ref_sql.toString());
			pstmt.setString(1, localeName);
			pstmt.setString(2, localeName);
			pstmt.setString(3, facilityID);
			pstmt.setString(4, wait_ref_no);
			
			rs = pstmt.executeQuery();
			
			if (rs.next())
			{
				speciality_code	= checkForNull(rs.getString("SPECIALTY_CODE"));
				patientid		= checkForNull(rs.getString("PATIENT_ID"));
				spl_desc		= checkForNull(rs.getString("SPECIALITY_DESC"));
				booking_ref_no	= checkForNull(rs.getString("BOOKING_REF_NO"));
				pract_id		= checkForNull(rs.getString("PRACTITIONER_ID"));
				pract_name		= checkForNull(rs.getString("PRACTITIONER_FULL_NAME"));
				national_id		= checkForNull(rs.getString("NATIONAL_ID_NO"));
				name_sufx		= checkForNull(rs.getString("NAME_SUFFIX"));
				name_prfx		= checkForNull(rs.getString("NAME_PREFIX"));
				patient_name	= checkForNull(rs.getString("PATIENT_NAME"));
				oa_patient_name_loc_lang	= checkForNull(rs.getString("PATIENT_NAME_LOC_LANG"));
				
				gender			= checkForNull(rs.getString("GENDER"));
				birth_place		= checkForNull(rs.getString("BIRTH_PLACE_DESC"));
				country_code	= checkForNull(rs.getString("RES_COUNTRY_CODE"));
				race_desc		= checkForNull(rs.getString("RACE_DESC"));
				race_code		= checkForNull(rs.getString("RACE_CODE"));
				ethic_code		= checkForNull(rs.getString("ETHNIC_GROUP_CODE"));
				ethic_desc		= checkForNull(rs.getString("ETHNIC_GROUP_DESC"));
				family_name		= checkForNull(rs.getString("FAMILY_NAME"));
				oa_date_of_birth= checkForNull(rs.getString("date_of_birth"));
				if(!(oa_date_of_birth==null && oa_date_of_birth.equals("")))
					oa_date_of_birth	=	DateUtils.convertDate(oa_date_of_birth,"DMY","en",locale);
				oa_alt_id1				= checkForNull(rs.getString("ALT_ID1_NO"));
				oa_alt_id1_exp_date		= checkForNull(rs.getString("ALT_ID1_EXP_DATE"));
				if(!(oa_alt_id1_exp_date==null && oa_alt_id1_exp_date.equals("")))
					oa_alt_id1_exp_date	=	DateUtils.convertDate(oa_alt_id1_exp_date,"DMY","en",locale);	
				oa_alt_id2		= checkForNull(rs.getString("ALT_ID2_NO"));
				oa_alt_id2_exp_date		= checkForNull(rs.getString("ALT_ID2_EXP_DATE"));
				if(!(oa_alt_id2_exp_date==null && oa_alt_id2_exp_date.equals("")))
					oa_alt_id2_exp_date	=	DateUtils.convertDate(oa_alt_id2_exp_date,"DMY","en",locale);			
				oa_alt_id3		= checkForNull(rs.getString("ALT_ID3_NO"));
				oa_alt_id3_exp_date		= checkForNull(rs.getString("ALT_ID3_EXP_DATE"));
				if(!(oa_alt_id3_exp_date==null && oa_alt_id3_exp_date.equals("")))
					oa_alt_id3_exp_date	=	DateUtils.convertDate(oa_alt_id3_exp_date,"DMY","en",locale);			
				oa_alt_id4		= checkForNull(rs.getString("ALT_ID4_NO"));
				oa_alt_id4_exp_date		= checkForNull(rs.getString("ALT_ID4_EXP_DATE"));
				if(!(oa_alt_id4_exp_date==null && oa_alt_id4_exp_date.equals("")))
					oa_alt_id4_exp_date	=	DateUtils.convertDate(oa_alt_id4_exp_date,"DMY","en",locale);			
				oa_oth_alt_id			= checkForNull(rs.getString("OTH_ALT_ID_NO")); 
				
				oa_first_name			= checkForNull(rs.getString("FIRST_NAME"));
				oa_second_name			= checkForNull(rs.getString("SECOND_NAME"));
				oa_third_name			= checkForNull(rs.getString("THIRD_NAME"));
				oa_name_prefix_loc_lang	= checkForNull(rs.getString("NAME_PREFIX_LOC_LANG"));
				oa_first_name_loc_lang	= checkForNull(rs.getString("FIRST_NAME_LOC_LANG"));
				oa_second_name_loc_lang	= checkForNull(rs.getString("SECOND_NAME_LOC_LANG"));
				oa_third_name_loc_lang	= checkForNull(rs.getString("THIRD_NAME_LOC_LANG"));
				oa_family_name_loc_lang	= checkForNull(rs.getString("FAMILY_NAME_LOC_LANG"));
				oa_name_suffix_loc_lang	= checkForNull(rs.getString("NAME_SUFFIX_LOC_LANG"));
				oa_oth_alt_id_type		= checkForNull(rs.getString("OTH_ALT_ID_TYPE"));				
				oa_years				= checkForNull(rs.getString("years"));
				oa_months				= checkForNull(rs.getString("months"));
				oa_days					= checkForNull(rs.getString("days")); 
				oa_addr_line1			= checkForNull(rs.getString("RES_ADDR_LINE1"));
				oa_addr_line2			= checkForNull(rs.getString("RES_ADDR_LINE2"));
				oa_addr_line3			= checkForNull(rs.getString("RES_ADDR_LINE3"));
				oa_addr_line4			= checkForNull(rs.getString("RES_ADDR_LINE4"));
				oa_res_area_code		= checkForNull(rs.getString("RES_AREA_CODE"));
				oa_res_area_desc		= checkForNull(rs.getString("RES_AREA_DESC"));
				oa_res_reg_code			= checkForNull(rs.getString("RES_REGION_CODE"));
				oa_res_reg_desc			= checkForNull(rs.getString("RES_REGION_DESC"));
				oa_res_town_code		= checkForNull(rs.getString("RES_TOWN_CODE"));
				oa_res_town_desc		= checkForNull(rs.getString("RES_TOWN_DESC"));
				oa_res_country_code		= checkForNull(rs.getString("RES_COUNTRY_CODE"));
				oa_res_country_name		= checkForNull(rs.getString("RES_COUNTRY_NAME"));
				oa_res_postal_code		= checkForNull(rs.getString("RES_POSTAL_CODE"));
				oa_res_postal_desc		= checkForNull(rs.getString("POSTAL_DESC"));  			
				oa_mail_addr_line1			= checkForNull(rs.getString("MAIL_ADDR_LINE1"));
				oa_mail_addr_line2			= checkForNull(rs.getString("MAIL_ADDR_LINE2"));
				oa_mail_addr_line3			= checkForNull(rs.getString("MAIL_ADDR_LINE3"));
				oa_mail_addr_line4			= checkForNull(rs.getString("MAIL_ADDR_LINE4"));
				oa_mail_res_area_code		= checkForNull(rs.getString("MAIL_AREA_CODE"));
				oa_mail_res_area_desc		= checkForNull(rs.getString("MAIL_AREA_DESC"));
				oa_mail_res_reg_code			= checkForNull(rs.getString("MAIL_REGION_CODE"));
				oa_mail_res_reg_desc			= checkForNull(rs.getString("MAIL_REGION_DESC"));
				oa_mail_res_town_code		= checkForNull(rs.getString("MAIL_TOWN_CODE"));
				oa_mail_res_town_desc		= checkForNull(rs.getString("MAIL_TOWN_DESC"));
				oa_mail_res_country_code		= checkForNull(rs.getString("MAIL_COUNTRY_CODE"));
				oa_mail_res_country_name		= checkForNull(rs.getString("MAIL_COUNTRY_NAME"));
				oa_mail_res_postal_code		= checkForNull(rs.getString("MAIL_POSTAL_CODE"));  
				oa_mail_postal_desc		= checkForNull(rs.getString("MAIL_POSTAL_DESC"));  
				oa_email_id				= checkForNull(rs.getString("EMAIL_ID"));  
				oa_res_tel_no			= checkForNull(rs.getString("RES_TEL_NO"));  
				oa_oth_contact_no		= checkForNull(rs.getString("OTH_CONTACT_NO")); 
					
				
				
			}
			if(rs	 != null)   rs.close();
			if(pstmt	 != null)   pstmt.close();
		}
		
    	/*Added Below Line code for this incident [23474] */
			String language_direction="";
			try{
			int count=0;
		   /*  stmt=con.createStatement(); */
			//preparedStatement pstmt1 = con.prepareStatement( "select count(*) as total from sm_language where language_direction='R' and eff_status='E'" ) ;
			
/* 		    rs = stmt.executeQuery("" ) ; */
			
		    pstmt = con.prepareStatement("select count(*) as total from sm_language where language_direction='R' and eff_status='E' and LANGUAGE_ID=?");
		    
			pstmt.setString(1, locale);
			rs = pstmt.executeQuery();
			 if ( rs != null && rs.next() ) 
			 {
			 count = rs.getInt("total");
			 }

			if ( count==1 ) 
			{
				 language_direction = "RTL" ;
			}else
			{
				 language_direction = "LTR" ;
			}
			
			if (rs!=null) rs.close();
			if (pstmt!=null) pstmt.close();
			
	
	}catch(Exception e1){
	 e1.printStackTrace();
	}
	/*Added Above Line code for incident [23474] */
		
	
		
		

	if(call_function.equals("OA_IP_Booking") && allowed_booking_type.equals("R") && referral_id.equals(""))
	{
		out.println("<script>alert(getMessage('BOOKING_NOT_ALLOWED','IP'));parent.window.close();</script>");
	}

	/*modification for SRR20056-CRF-0506*/
	
	try{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("select booking_type_code,ip_get_desc.ip_booking_type(booking_type_code,?,'2')short_desc,(select max_patient_age from mp_param where module_id = 'MP') max_patient_age from ip_booking_type where eff_status = 'E' order by 2");

				pstmt =   con.prepareStatement(sql.toString());	
				pstmt.setString(1,localeName);
				rs   = pstmt.executeQuery();

				if(rs != null)
				{
					while(rs.next())
					{
						bookingtype_list.add(checkForNull(rs.getString(1)));
						bookingtype_list.add(checkForNull(rs.getString(2)));
						max_patient_age = rs.getString("max_patient_age");
					}
				}
				if(rs != null)	rs.close();
				if(pstmt != null) pstmt.close();
			}catch(Exception e)
			{
				
				e.printStackTrace();
			}

		
%>

<script>

	function LoadBookingDetails()
	{
		if(document.forms[0].call_function.value == "OT")
		{	
			/*Tuesday, December 21, 2010 , commented for  MO-GN-5329 [IN:025559] , pref_adm_date date calculation will be done by pre_op_days value passed from OT */
			//document.forms[0].pref_adm_date.value = convertDate('<%--=booking_date_time--%>',"DMYHM","en",localeName);
			document.forms[0].ot_date_time.value  = convertDate('<%=booking_date_time%>',"DMYHM","en",localeName);
			calcPrefDateForPreparationDay();
			dateCal(document.forms[0].pref_adm_date);
			/*Tuesday, December 21, 2010 , commented for  MO-GN-5329 [IN:025559]*/
			if(document.forms[0].ot_date_time.value == '' )
			{
				document.forms[0].ot_date_time.disabled		= false;
				document.getElementById("otdt").disabled					= false;
			}
			else
			{
				document.forms[0].ot_date_time.disabled		= true;
				document.getElementById("otdt").disabled					= true;
			}
			document.forms[0].pre_op_days.value					= "<%=PreOpPreparationDays%>";
			if(document.forms[0].pre_op_days.value == null || document.forms[0].pre_op_days.value == '')
				document.forms[0].pre_op_days.value			= '0';
			document.forms[0].exp_days_of_stay.value			= "<%=PreOpPreparationDays%>";
			if(document.forms[0].exp_days_of_stay.value == null || document.forms[0].exp_days_of_stay.value == '')
				document.forms[0].exp_days_of_stay.value			= '1';
			/**/
			if(document.forms[0].exp_days_of_stay.value != '' && document.forms[0].pref_adm_date.value != '')
			{
				
				var expdischargeDate = plusDate(document.forms[0].pref_adm_date.value,'DMYHM',localeName,document.forms[0].exp_days_of_stay.value,'d');
				document.forms[0].exp_discharge_date.value	= expdischargeDate;			
	
			}
			calcPrefDateForPreparationDay1();

			if(document.forms[0].med_service_grp.value == '' )
				document.forms[0].med_service_grp.disabled = false;
			else
				document.forms[0].med_service_grp.disabled = true;

			document.forms[0].Splcode_desc.value		= "<%=medical_speciality_desc%>";
			document.forms[0].Splcode.value				= "<%=medical_speciality_code%>";
			document.forms[0].practid_desc.value		= "<%=physician_desc%>";
			document.forms[0].practid.value				= "<%=physician_code%>";
			
			var physician_code="<%=physician_code%>";
			var specialty_code="<%=medical_speciality_code%>";
			var nursing_unit_code="<%=nursing_unit_code%>";
			var medical_service="<%=medical_service%>";

			// code added for  this incident: 18350
			var xmlDoc = ""
			var xmlHttp = new XMLHttpRequest()
			xmlStr ="<root><SEARCH step='six'  medical_service=\""+medical_service+"\"   nursing_unit_code=\""+nursing_unit_code+"\"/></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","BookingGetExpDaysDate.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			responseText= trimString(responseText)
           var arr1 = responseText.split("||");	

			if(arr1[0]=='N')
			{
				alert(getMessage("INVALID_MSG_NUT_RIGHTS","IP"));
				document.forms[0].nursing_unit_desc.value	= "";	
				 document.forms[0].nursing_unit.value		= "";	
				document.forms[0].nurs_unit_desc_hid.value	= "";	

			}
			else
			{
					/*
					end here 18350

					code developed for incident:18206
					*/
					var xmlDoc = ""
					var xmlHttp = new XMLHttpRequest()
					xmlStr ="<root><SEARCH step='five'  practitioner_id=\""+physician_code+"\"  specialty_code=\""+specialty_code+"\"  nursing_unit_code=\""+nursing_unit_code+"\"/></root>"
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
					xmlHttp.open("POST","BookingGetExpDaysDate.jsp",false)
					xmlHttp.send(xmlDoc)
					responseText=xmlHttp.responseText
					responseText= trimString(responseText)
				   var arr = responseText.split("||");	
					
				  
					if(arr[0]!=''&&arr[1]!='') 
					{
							var practCount=arr[0];
							var spltCount=arr[1];
							
							if(practCount==0&&spltCount==0)
							{
								alert(getMessage("PRACT_ADMN_RIGHTS_DENIED","IP")+"\n"+getMessage("SPLTY_ADMN_RIGHTS_DENIED","IP"))
									document.forms[0].nursing_unit_desc.value	= "";	
								 document.forms[0].nursing_unit.value		= "";	
								  document.forms[0].nurs_unit_desc_hid.value	= "";	
							}
							else
							{
									if(practCount==0||spltCount==0)
									{
										if(practCount==0)
											alert(getMessage("PRACT_ADMN_RIGHTS_DENIED","IP"))
											else if(spltCount==0)
											alert(getMessage("SPLTY_ADMN_RIGHTS_DENIED","IP"))

											document.forms[0].nursing_unit_desc.value	= "";	
										   document.forms[0].nursing_unit.value		= "";	
											document.forms[0].nurs_unit_desc_hid.value	= "";	
											
									}
									else
									{
										  document.forms[0].nursing_unit_desc.value	= "<%=nursing_unit_short_desc%>";	
										   document.forms[0].nursing_unit.value		= "<%=nursing_unit_code%>";	
										   document.forms[0].nurs_unit_desc_hid.value	= "<%=nursing_unit_short_desc%>";	
									}

							}
							
					}
					else
					{
						
						document.forms[0].nursing_unit_desc.value	= "<%=nursing_unit_short_desc%>";	
					   document.forms[0].nursing_unit.value		= "<%=nursing_unit_code%>";	
					   document.forms[0].nurs_unit_desc_hid.value	= "<%=nursing_unit_short_desc%>";	
					   
					}
			}
			

			/*
			code end here
			*/

			


			
			
			/* Saturday, June 13, 2009 modified for IN010922 
			
			if(document.forms[0].Splcode_desc.value!='')
			{
				document.forms[0].Splcode_desc.disabled		=	true;
				document.forms[0].Splcode_lookup.disabled	=	true;
			}
			else
			{
				document.forms[0].Splcode_desc.disabled		=	false;
				document.forms[0].Splcode_lookup.disabled	=	false;				
			}
			
			
			if(document.forms[0].practid_desc.value!='')
			{
				document.forms[0].practid_desc.disabled		=	true;
				document.forms[0].pract_id_search.disabled	=	true;
			}
			else
			{
				document.forms[0].practid_desc.disabled		=	false;
				document.forms[0].pract_id_search.disabled	=	false;				
			}
			
			if(document.forms[0].nursing_unit_desc.value!='')
			{
				document.forms[0].nursing_unit_desc.disabled		=	true;
				document.forms[0].nursing_unit_lookup.disabled		=	true;
				
			}
			else
			{
				document.forms[0].nursing_unit_desc.disabled		=	false;
				document.forms[0].nursing_unit_lookup.disabled		=	false;		
			}
			*/
			//document.forms[0].practid_desc.disabled		= false;
			//document.forms[0].pract_id_search.disabled	= false;
			document.forms[0].referral_id.disabled		= true;
			document.forms[0].referral_details.disabled = false;
			document.forms[0].pref_adm_date.readOnly	= false;
			document.getElementById("prefdt").disabled				= false;
			setTimeout('populatepatDetails()',1000);

			ChangeVal(parent.frames[1].document.forms[0].med_service_grp);
			
			//document.forms[0].exp_days_of_stay.onblur();

			

			
			/*if(document.forms[0].Splcode.value!='' && document.forms[0].nursing_unit.value!='' && document.forms[0].practid.value!='')
			{
					validateNursingUnitSplCodePractID(document.forms[0].Splcode.value,document.forms[0].nursing_unit.value,document.forms[0].practid.value);
			}*/
			/*else
			{
				ChangeVal(parent.frames[1].document.forms[0].med_service_grp);
				document.forms[0].exp_days_of_stay.onblur();
			}*/
			
			//alert('start');
			/*ChangeVal(parent.frames[1].document.forms[0].med_service_grp);
			*/
			//alert('end');
			//
			
		}	
	}


	function setFocus() 
	{
		if( document.forms[0].pref_adm_date.readOnly == false && document.forms[0].pref_adm_date.disabled == false )
		{
			document.forms[0].pref_adm_date.focus();
		}
	}
function checkMaxLimitOfRemark(obj)
	{
		if ( obj.value.length > 250 )
		{
			var error = getMessage("REMARKS_CANNOT_EXCEED","common");
			var remarks = getLabel("Common.booking.label","common") + " " + getLabel("Common.remarks.label","common");
			error = error.replace("$",remarks);
			error = error.replace("#","250")
			alert(error);
			obj.select();
			return false;
		}
		else
			return true;
	}
	function CheckForSpecChars_Remarks(event){
	
    //var strCheck = '"+%?@#$~\'<>';
    var strCheck ='~`!@#$%^&*()-_=+{[}]|:;",./?\<>';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    //if (strCheck.indexOf(key) == -1) return true;  // Not a valid key
	if (strCheck.indexOf(key) == -1 && whichCode != 92) return true; // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return false ;
}
function imposeMaxLength(obj)
{
 var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
}
</script>
<body onLoad="gifpop();<%if(is_oa_yn.equals("Y")){%>getWaitlist();<%}%>Control_NursingUnit();LoadBookingDetails();" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='booking_form' id='booking_form' action='../../servlet/eIP.BookingServlet' method='post' target='messageFrame'> 
	<%
		if(bl_operational.equals("Y") && capture_fin_dtls_yn.equals("Y"))
		{ %>

		<a name='tab1' id='tab1'></a>
		<ul id="tablist" class="tablist">
			<li class="tablistitem" title="Booking Details">
				<a onclick="tab_click('booking_tab')" class="tabClicked" id="booking_tab" >
					<span class="tabSpanclicked" id=""><fmt:message key="Common.booking.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title="Financial Details">
				<a onclick="tab_click('findtl_tab')" class="tabA" id="findtl_tab" >
					<span class="tabAspan" id=""><fmt:message key="Common.financialdetails.label" bundle="${common_labels}"/></span>
				</a>
			</li>
		</ul>
			
		<%}
	%>
<table border="0" cellpadding="2" cellspacing="0" width="100%" align='center'>
		<tr>
		<td  class='label' width='20%'><fmt:message key="eIP.ProcedureSurgeryDateTime.label" bundle="${ip_labels}"/></td>
		<td class='fields' width='20%' ><input type=text  name='ot_date_time' id='ot_date_time'  onBlur="doOTDateTimeChk2(this);" size="16" maxlength="16"  <%if(call_function.equals("OT")){%>value="<%=pref_date%>" <%}else{%> value="" <%}%> ><img name='otdt' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('ot_date_time',null,'hh:mm');document.forms[0].ot_date_time.select();"/><%if(call_function.equals("OT")){%><img src='../../eCommon/images/mandatory.gif'align='center'></img><%}%></td>
		<td width='10%' class='label'></td>
		<td  class='label' width='20%'><fmt:message key="eIP.PreOpPreparationDays.label" bundle="${ip_labels}"/></td>
		<td class='fields' width='20%' ><INPUT TYPE='text' value="0" name='pre_op_days' id='pre_op_days' size="3" maxlength="3"  onKeyPress='return(ChkNumberInput(this,event,0))'  onBlur="CheckNum(this);displayDefaultValue(this);calcPrefDateForPreparationDay1();"></td>
		</tr>
		<tr>
		<td  width='20%' class='label' ><fmt:message key="eIP.PrefAdmDateTime.label" bundle="${ip_labels}"/></td>
		<td  width='20%' class='field' ><input type="hidden" name ="sdate" <%if(is_oa_yn.equals("Y")){%> value="<%=pref_date%>" <%}else{%>
		value="<%=sqlsd1%>"<%}%>>
	    <INPUT TYPE="text" name="pref_adm_date" id="pref_adm_date"   <%if(is_oa_yn.equals("Y")){%>value="<%=pref_date%>" <%}else{%> value="" <%}%> size="16" maxlength="16"  onBlur="Allfunc(this,document.forms[0].sdate2);calcDate(this);" onKeyPress='return(ChkNumberInput1(this,event,2))'><img name='prefdt' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('pref_adm_date',null,'hh:mm');document.forms[0].pref_adm_date.focus();"/><img src='../../eCommon/images/mandatory.gif'align='center'></img><input type='hidden' name='hdnBlur' id='hdnBlur' value=''>
		</td> 
	   <td width='10%' id="DayVal" class="label" align="left"><%=DayVal%></td>	 
	   <td width='20%' class='label'  nowrap><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></td>
   	   <td width='20%' class='field'>
<%		if(call_function.equals("OA_IP_Booking"))
		{	%>
			<input type="text" size ="14" maxlength="14" name='referral_id' id='referral_id' value="" disabled><input type='button' class ='button' Value ='?' name='referral_details' id='referral_details' disabled>&nbsp;<img src='../../eCommon/images/mandatory.gif' id='ref_img' style="visibility:hidden"></img>
<%		}
		else
		{	%>
			<input type="text" size ="14" maxlength="14" name='referral_id' id='referral_id' <%if(is_op_pending_referral_booking.equals("Y")){%> value="<%=referral_id%>"<%}else{%> value="" <%}%>onBlur="ChangeUpperCase(this);referralDetails(this,'N');movtab();" onKeyPress='return CheckForSpecChars(event)' ><input type='button' class ='button' Value ='?' name='referral_details' id='referral_details' onClick='PopRefDetails()'><img src='../../eCommon/images/mandatory.gif' id='ref_img' style="visibility:hidden"></img>
<%		}	%>

		</td>
   	</tr>
	<tr>
		<td  width='20%' class='label'   ><fmt:message key="eIP.MedicalServiceGroup.label" bundle="${ip_labels}"/></td>
		<td  width='20%' class='fields' ><SELECT name="med_service_grp" id="med_service_grp" onBlur="" onChange="ChangeVal(this)"><option value='' selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
<%  
			//This query is used for populating the medical service group
			try
			{
			StringBuffer sqlmedserv = new StringBuffer();
			if(sqlmedserv.length() > 0) sqlmedserv.delete(0,sqlmedserv.length());
			sqlmedserv.append(" select distinct IP_GET_DESC.IP_MEDICAL_SERVICE_GROUP(FACILITY_ID,med_ser_grp_code,?,'2') med_ser_grp_short_desc, med_ser_grp_code, generate_num_yn FROM IP_MED_SER_GRP_NURS_UT_TYPE_VW where facility_id = ? and nursing_unit_type_code IN(SELECT DISTINCT nursing_unit_type_code FROM IP_NURSING_UNIT a, am_os_user_locn_access_vw b WHERE a.facility_id = ? AND a.facility_id=b.facility_id AND a.nursing_unit_code=b.locn_code AND b.oper_stn_id = ? AND b.appl_user_id = ? AND b.admit_pat_yn='Y' and a.locn_type=b.locn_type AND 	A.EFF_STATUS='E') AND eff_status = 'E' order by med_ser_grp_short_desc" );
			pstmt	=   con.prepareStatement(sqlmedserv.toString());	
			pstmt.setString(1,locale);
			pstmt.setString(2,facilityID);
			pstmt.setString(3,facilityID);
			pstmt.setString(4,p_oper_stn_id);
			pstmt.setString(5,loginUser);
			rs = pstmt.executeQuery();

			String sel ="";
			if(call_function.equals("OT"))
			{
				while( rs.next() )
				{
					medservdesc   = checkForNull(rs.getString(1));
					medservcode   = checkForNull(rs.getString(2));	
					generatenumyn = checkForNull(rs.getString(3));  
					if(medical_service.equals(medservcode))
			         sel="selected";
					else
					 sel="";

					med_hid_val = medservcode+'#'+generatenumyn+'#'+app_pat_class;
					%>
					<OPTION VALUE="<%=medservcode+'#'+generatenumyn+'#'+app_pat_class%>" <%=sel%> ><%=medservdesc%>
		<%		}
			}
			else
			{
				if( rs != null )
				{
					while( rs.next() )
					{
						medservdesc   = checkForNull(rs.getString(1));
						medservcode   = checkForNull(rs.getString(2));	
						generatenumyn = checkForNull(rs.getString(3));  
						%>
						<OPTION VALUE="<%= medservcode+'#'+generatenumyn+'#'+app_pat_class %>" ><%= medservdesc %>
		<% 	        }
				}
			}
			if(pstmt	 != null)   pstmt.close();
			if(rs	 != null)   rs.close();
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
			}
			%>	     
	   	</SELECT>
      	<input type='hidden' name='generatenumyn' id='generatenumyn' value=''><img src='../../eCommon/images/mandatory.gif'align='center'></img><input type='hidden' name='app_pat_class' id='app_pat_class' value=''></td> 
		<td  width='10%' ></td>
		<td width='20%' class='label' nowrap  ><fmt:message key="Common.BookingRefNo.label" bundle="${common_labels}"/></td>
   		<td width='20%' class='fields'><INPUT TYPE='text' value="<%=booking_ref_no%>" name='booking_ref_no' id='booking_ref_no' size="12" maxlength="12" onKeyPress='return CheckForSpecChars(event)' onBlur="specialChar(this,'Char');"><img id = "gifpop" src='../../eCommon/images/mandatory.gif' align='center'></td>   	   
	</tr>
	<tr>
   	   <td width='20%' class='label' ><fmt:message key="eIP.ExpdaysofStay.label" bundle="${ip_labels}"/></td>
   	   <!--<td class='fields' colspan='2'><INPUT TYPE='text' value="1" name='exp_days_of_stay' id='exp_days_of_stay' size="4" maxlength="3" onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="CheckNum(this);CheckZeroVal(this);displayDefaultValue(this);CheckProcDtTime(this);calcDate(this);"></td>
	    <td class="label" ><fmt:message key="eIP.ExpectedDischargeDateTime.label" bundle="${ip_labels}"/></td>	  
		<td  class='fields' ><input type='text' name='exp_discharge_date' id='exp_discharge_date' id='exp_discharge_date_id' value="" size='16' maxlength='16' readonly></td>-->
		<td width='20%'class='fields'><INPUT TYPE='text' value="1" name='exp_days_of_stay' id='exp_days_of_stay' size="4" maxlength="3" onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="CheckNum(this);CheckZeroVal(this);displayDefaultValue(this);calcDateForExpDisc(this);"></td>
			<td  width='10%'></td>
	    <td width='20%' class="label" ><fmt:message key="eIP.ExpectedDischargeDateTime.label" bundle="${ip_labels}"/></td>	  
		<td width='20%' class='fields' ><input type='text' name='exp_discharge_date' id='exp_discharge_date' id='exp_discharge_date_id' value="" size='16' maxlength='16' readonly></td>
	</tr>
	<tr>
   		<td class = 'label'  width='20%'><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td class='field' colspan='4'><SELECT name ='priority_ind'><option value ='N'><fmt:message key="Common.nonurgent.label" bundle="${common_labels}"/></option><option value ='U'><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option></SELECT></td>
  	</tr>
</table>

<table border='0' cellpadding='2' cellspacing='0' width='100%' align='center'>
		<tr>
			<td class="COLUMNHEADER" colspan='5' ><b><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></b></td></tr>
	    
		<tr>	   
		<td  colspan='5' class='fields' >
		<%	if(call_function.equals("CA_Task_IP_Booking"))
			{	%>
				<jsp:include page="../../eMP/jsp/natAltIDComponent.jsp" ><jsp:param name="flush" value="true" /><jsp:param name='patient_id' value='<%=ca_patient_id%>' /></jsp:include>
		<%	}else if(call_function.equals("OA_IP_Booking"))
			{	%>
				<jsp:include page="../../eMP/jsp/natAltIDComponent.jsp" ><jsp:param name="flush" value="true" /><jsp:param name='patient_id' value='<%=oa_patient_id%>' /></jsp:include>
		<%	}else if(call_function.equals("OT"))
			{	%>
				<jsp:include page="../../eMP/jsp/natAltIDComponent.jsp" ><jsp:param name="flush" value="true" /><jsp:param name='patient_id' value='<%=Patient_Id%>'/><jsp:param name='call_function' value='OT'/><jsp:param name ="op_call" value= "IP_BOOKING"/></jsp:include>
		<%	}else{	%>
	<!--Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 24/01/2013-->
				<jsp:include page="../../eMP/jsp/natAltIDComponent.jsp" ><jsp:param name="flush" value="true" /><jsp:param name='patient_id' value=''/><jsp:param name ="op_call" value= "IP_BOOKING"/></jsp:include>
		<%	}	%>
	   </td>
	</tr>
</table>		
<table border="0" cellpadding="2" cellspacing="0" width="100%" align='center'>
	<tr><td class="COLUMNHEADER" colspan='5' ><b><fmt:message key="eIP.BookingDetails.label" bundle="${ip_labels}"/></b></td></tr>
	<%if(call_function.equals("OT")){%>
		<tr><td colspan=5 class='label' height='5' ></td></tr>
		<tr>
			<td class='label' width='20%' ><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></td>
			<td  class='fields' width='20%'><b><%=physician_desc%><b></td>
			<td  width='10%' ></td>
			<td  class='label' width='20%'><fmt:message key="Common.OperatingRoom.label" bundle="${common_labels}"/></td>
			<td class='fields' width='20%'><b><%=oper_room_desc%><b></td>
			
		</tr>
		<tr><td colspan=5 class='label' height='5' ></td></tr>
		<tr>
			<td class='label' width='20%' ><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
			<td  class='fields' width='20%'><b><%=patient_class%><b></td>
			<td  class='label' colspan='3' ></td>
		</tr>
		<tr><td colspan=5 class='label' height='5' ></td></tr>
	<%}%>
	<tr><td  class='label'  colspan = '3'></td>
	<td  class='label' id='OpenBooking' colspan = '2'></td></tr>
	<tr>
		<td class='label'  width='20%' ><fmt:message key="eIP.ReasonforAdmissionBooking.label" bundle="${ip_labels}"/></td>
		<td class='fileds' width='20%' ><input type="text" name='chief_complaint' id='chief_complaint' size="30"  maxLength="200" onChange="ReasonLookupBlur();"><input type=hidden name='complaintcode' id='complaintcode' ><input type=hidden name='chief_complaint_hid' id='chief_complaint_hid'><input type=button name='chfcomp_lookup' id='chfcomp_lookup' value='?' class=button onClick="if(document.forms[0].chief_complaint.value == '')ReasonLookup();"></td>		
		<!--/*modification for SRR20056-CRF-0506*/-->
		<td  width='10%' ></td>
		<td class='label' width='20%' ><fmt:message key="eIP.BookingType.label" bundle="${ip_labels}"/></td>
		<td  class='fileds' width='20%'><SELECT name="booking_Type" id="booking_Type" onBlur="" ><option value='' selected>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----
		<%
			for(int i=0;i<bookingtype_list.size();i+=2){
		%>
			<option value=<%=bookingtype_list.get(i)%>><%=bookingtype_list.get(i+1)%></option>
		<%}%>	
		</select></td>
		
	</tr>
	<tr>
		<td class='label' width='20%' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
		<td  class='fileds' width='20%'><input type="text" name='Splcode_desc' id='Splcode_desc' maxlength="15" size="15" onBlur="SpecialtyLookupBlur();"><input type='hidden' name='Splcode' id='Splcode' ><input type=button name='Splcode_lookup' id='Splcode_lookup' value='?' class=button onClick="if(document.forms[0].Splcode_desc.value == '')SpecialtyLookup();"><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
		<td  width='10%' ></td>
		<td  class='label' width='20%'><fmt:message key="eIP.AdmittingPractitioner.label" bundle="${ip_labels}"/></td>
		<td class='fileds' width='20%'><input type='text' name='practid_desc' id='practid_desc' value="" size="20" maxlength="30" onBlur="getPractIDBlur(document.forms[0].pract_id_search,practid_desc);"><input type='hidden' name='practid' id='practid' value=""><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button' onClick="if(document.forms[0].practid_desc.value  == '') getPractID(this,practid_desc);"><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
	</tr>
	<tr>
		<td  class='label' width='20%'><fmt:message key="Common.medicalteam.label" bundle="${common_labels}"/></td>
		<td class='fileds' width='20%'><select name="team_id" id="team_id" disabled><option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</select></td>
		<!--<td class='label' colspan='2'></td>-->
		<!--<td  class='label' width='25%'><fmt:message key="eIP.ProcedureSurgeryDateTime.label" bundle="${ip_labels}"/></td>
		<td class='fileds' width='25%' ><input type=text  name='ot_date_time' id='ot_date_time' id="otdatetime" onBlur="doOTDateTimeChk2(this);" size="15" maxlength="16"  value="" ><input type='image' name='otdt' id='otdt' src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].ot_date_time.select();return showCalendar('otdatetime',null,'hh:mm');"></td>-->
		<td  width='10%' ></td>
		<td class='label' width='20%'><fmt:message key="Common.booking.label" bundle="${common_labels}"/>&nbsp<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td class='fileds' width='20%'><textarea style='resize: none' name="booking_remarks" rows="2"  maxlength='250'   onBlur="makeValidString(this);checkMaxLimitOfRemark(this);" onKeyPress="/*return CheckForSpecChars_Remarks(event);*/" onkeyup="return imposeMaxLength(this);"></textarea></td>
	</tr>
	<tr>
		<td width='20%' class='label' ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
		<td width='20%' class='fields' ><input type=text name="nursing_unit_desc" id="nursing_unit_desc" maxlength=15 size=15 value="<%=nursing_unit_short_desc%>" onblur="NursingUnitLookupBlur('<%=facilityID%>','<%=loginUser%>','<%=p_oper_stn_id%>'),setdefault();removePatInsSession();" ><input type=button class=button name=nursing_unit_lookup value='?' onClick="if(document.forms[0].nursing_unit_desc.value == '')NursingUnitLookup('<%=facilityID%>','<%=loginUser%>','<%=p_oper_stn_id%>');removePatInsSession();" ><input type=hidden name="nurs_unit_desc_hid" id="nurs_unit_desc_hid"  value="<%=nursing_unit_short_desc%>"></td>
		<td  width='10%' ></td>
		<td width='20%' class='label' ><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
		<td class='fields' width='20%'><select name="service_desc" id="service_desc" onChange='' style="width:115"><option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</select><input type='hidden' name="service_desc_hid" id="service_desc_hid" value="<%=service_desc%>">
		</td>
		<input type='hidden' name="nursing_unit" id="nursing_unit"  value="<%=nursing_unit_code%>">
		<input type='hidden' name="service_code" id="service_code"  value="<%=service_code%>">
	</tr>
<!--
</table>
<table border='0' cellpadding='0' cellspacing='0' width='114%' align='center' id ='bed_detail' >
-->
<%if(create_booking_with_conf_yn.equals("Y")){
 /*modified below line code for this incident [23474] */
%>
      
		<input type = 'hidden' value = "<%=old_nursing_unit %>" name = 'old_nursing_unit'>  
		<tr>
		<td  class='label' width='20%'><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></td>
		<td  class='fields' width='20%'><select name="bed_class_desc" id="bed_class_desc" style="width:115" onChange='clearBedValues();populateBedType(this.value)' dir='<%=language_direction%>'><option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option></select><input type=hidden name="bed_class_code" id="bed_class_code"  value="<%=bed_class_code%>"><input type=hidden name="bed_class_desc_hid" id="bed_class_desc_hid" value="<%=bed_class_desc%>"></td>
		<td  width='10%' ></td>
		<td  class='label' width='20%'><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/></td>
		<td  class='fields' width='20%'><select name="bed_type_desc" id="bed_type_desc"  onChange='clearBedValues();'><option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</select><input type=hidden name="bedtypecode" id="bedtypecode"  value="<%=bed_type_code%>"><input type=hidden name="bed_type_desc_hid" id="bed_type_desc_hid" value="<%=bed_type_desc%>"></td>
		
	</tr>
	<tr>
		<td  class='label' width='20%'><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>
		<td  class='fields' width='20%'><input type='text' id ='bed_no' name='bed_no' id='bed_no'  value="<%=bed_no%>" size="8" maxlength = "8" onBlur='getRoomNo(this),ChangeVal(this);'  onKeyPress='return CheckForSpecChars(event)' readonly><input type='hidden' name='old_bed_no' id='old_bed_no' value="<%=bed_no%>"><input type='button' name='bed_avail_chart' id='bed_avail_chart' onClick="openBedChart();" value='?'class='button' ></td>
		<td  width='10%' ></td>
		<td  class='label' width='20%'><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/></td>
		<td  class='fields' width='20%'><input type='text' name='room_no' id='room_no' onKeyPress='return CheckForSpecChars(event)' value="" size="10" maxlength="10" readonly>&nbsp;</td>
		
	</tr>
	<tr>
		<td class='label' width='20%' ><fmt:message key="Common.override.label" bundle="${common_labels}"/></td>
		<td class='fields' width='20%'><input type='checkbox' name ='override' <%=checkBoxAttribute%> <%=disabledAttrib%> onClick="changeOVRVal(this)" disabled>&nbsp;</td>
		<!--Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 09/01/2013-->
		<!--Start-->
		<td  colspan=3></td>
	</tr>
		

<%}%>
<!--Included for the CRF - RUT CRF 013 23396 -->
	<tr>
	
		<td  class='label'><a href='javascript:PatInsModalWindow()'><fmt:message key="eAM.PatInstructions.label" bundle="${am_labels}"/></a><img src='../../eCommon/images/InfoAlert.PNG' id='NUInstsExist' style='visibility:hidden'/></td>	
		<!--Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 09/01/2013-->
		<!--Start-->
		<td  colspan=2></td>
		<td width='20%' class='label' ><fmt:message key="eIP.SurgeryOrder.label" bundle="${ip_labels}"/></td>
		<td width='20%' class='fields'><input name="surgery_order" id="surgery_order" type="text" value="" onblur="if(this .value!=''){ GetSurgeryOrder(document.forms[0].patient_id.value,'');} else { GetSurgeryOrder_blank(document.forms[0].patient_id.value,'');}"><input type='button' name='surgery_order_name' id='surgery_order_name' onClick="GetSurgeryOrder(document.forms[0].patient_id.value,'');" value='?'class='button' ></td><input name="surgery_order_code" id="surgery_order_code" type="hidden" value=""><input name="surgery_order_id" id="surgery_order_id" type="hidden" value=""><input name="surgery_order_line_no" id="surgery_order_line_no" type="hidden" value="">
		</td>
		
		</tr>
		<tr>
		<td  colspan=3></td>
		<td width='20%' class='label' ><fmt:message key="eIP.SurgeryDate.label" bundle="${ip_labels}"/></td>
		<td width='20%' class='QUERYDATA' id='surgery_order_dt_id'></td><input name="surgery_order_date" id="surgery_order_date" type="hidden" value="">
		</tr>
		<!--End-->
		
</table> 
	<input type='hidden' name ='confirm_yn' value ="<%=create_booking_with_conf_yn%>" >
	<input type='hidden' name ='override_yn' value ="<%=override_yn%>" >
	<input type='hidden' name='currdate' id='currdate' value="<%=Sdate%>">
	<input type='hidden' name='is_ca_yn' id='is_ca_yn' value="<%=is_ca_yn%>">
	<input type='hidden' name='call_function' id='call_function' value="<%=call_function%>">
	<input type='hidden' name='ca_patient_id' id='ca_patient_id' value="<%=ca_patient_id%>">
	<input type='hidden' name='p_oper_stn_id' id='p_oper_stn_id' value="<%=p_oper_stn_id%>">
	<input type='hidden' name='loginUser' id='loginUser' value="<%=loginUser%>">
	<input type='hidden' name='qryString' id='qryString' value="<%=queryString%>">
	<input type='hidden' name='Unregpatbkgyn' id='Unregpatbkgyn' value="<%=Unregpatbkgyn%>">
	<input type='hidden' name='Splcode_desc_hid' id='Splcode_desc_hid' value=''>
	<input type='hidden' name='surgery_order_desc_hid' id='surgery_order_desc_hid' value=''><!--Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013-->
	<input type='hidden' name='practid_desc_hid' id='practid_desc_hid' value=''>
	<input type='hidden' name='faclity_id' id='faclity_id' value="<%=facilityID%>">
	<!--<input type='hidden' name='name_prefix_prompt' id='name_prefix_prompt' value="">-->
	<input type='hidden' name='appt_ref' id='appt_ref' value="">
	<input type='hidden' name='hid_pref_dt' id='hid_pref_dt' value="<%=oa_pref_date%>">
	<!--added by kishore on 8/12/2004-->
	<input type='hidden' name='is_oa_yn' id='is_oa_yn' value="<%=is_oa_yn%>">
	<input type='hidden' name='wait_list_ref_no' id='wait_list_ref_no' value="<%=wait_ref_no%>">
	<input type='hidden' name='oa_patient_id' id='oa_patient_id' value="<%=patientid%>">
	<input type='hidden' name='oa_patient_name' id='oa_patient_name' value="<%=patient_name%>">
	<input type='hidden' name='oa_patient_name_loc_lang' id='oa_patient_name_loc_lang' value="<%=oa_patient_name_loc_lang%>">
	<input type='hidden' name='oa_spl_code' id='oa_spl_code' value="<%=speciality_code%>">
	<input type='hidden' name='oa_spl_desc' id='oa_spl_desc' value="<%=spl_desc%>">
	<input type='hidden' name='oa_prct_id' id='oa_prct_id' value="<%=pract_id%>">
	<input type='hidden' name='oa_prct_desc' id='oa_prct_desc' value="<%=pract_name%>">
	<input type='hidden' name='oa_date_of_birth' id='oa_date_of_birth' value="<%=oa_date_of_birth%>">
	<input type='hidden' name='oa_birth_plc' id='oa_birth_plc' value="<%=birth_place%>">
	<input type='hidden' name='oa_race_code' id='oa_race_code' value="<%=race_code%>">
	<input type='hidden' name='oa_race_desc' id='oa_race_desc' value="<%=race_desc%>">
	<input type='hidden' name='oa_name_prfx' id='oa_name_prfx' value="<%=name_prfx%>">	
	<input type='hidden' name='oa_gendar' id='oa_gendar' value="<%=gender%>">
	<input type='hidden' name='oa_conutry_code' id='oa_conutry_code' value="<%=country_code%>">
	<input type='hidden' name='oa_nationality' id='oa_nationality' value="<%=national_id%>">
	<input type='hidden' name='oa_ethic_code' id='oa_ethic_code' value="<%=ethic_code%>">
	<input type='hidden' name='oa_ethic_desc' id='oa_ethic_desc' value="<%=ethic_desc%>">
	<input type='hidden' name='oa_family_name' id='oa_family_name' value="<%=family_name%>">
	<input type='hidden' name='oa_name_sufx' id='oa_name_sufx' value="<%=name_sufx%>">
	<input type='hidden' name='allowed_booking_type' id='allowed_booking_type' value="<%=allowed_booking_type%>">
	<input type='hidden' name='multi_book_pat_yn' id='multi_book_pat_yn' value="<%=multi_book_pat_yn%>">
	<input type='hidden' name='Bedcode' id='Bedcode' value="">
	<!--Additional Fields -->
	<input type='hidden' name='oa_alt_id1' id='oa_alt_id1' value="<%=oa_alt_id1%>">
	<input type='hidden' name='oa_alt_id1_exp_date' id='oa_alt_id1_exp_date' value="<%=oa_alt_id1_exp_date%>">
	<input type='hidden' name='oa_alt_id2' id='oa_alt_id2' value="<%=oa_alt_id2%>">
	<input type='hidden' name='oa_alt_id2_exp_date' id='oa_alt_id2_exp_date' value="<%=oa_alt_id2_exp_date%>">
	<input type='hidden' name='oa_alt_id3' id='oa_alt_id3' value="<%=oa_alt_id3%>">
	<input type='hidden' name='oa_alt_id3_exp_date' id='oa_alt_id3_exp_date' value="<%=oa_alt_id3_exp_date%>">
	<input type='hidden' name='oa_alt_id4' id='oa_alt_id4' value="<%=oa_alt_id4%>">
	<input type='hidden' name='oa_alt_id4_exp_date' id='oa_alt_id4_exp_date' value="<%=oa_alt_id4_exp_date%>">
	<input type='hidden' name='oa_oth_alt_id' id='oa_oth_alt_id' value="<%=oa_oth_alt_id%>">
	<input type='hidden' name='oa_first_name' id='oa_first_name' value="<%=oa_first_name%>">
	<input type='hidden' name='oa_second_name' id='oa_second_name' value="<%=oa_second_name%>">
	<input type='hidden' name='oa_third_name' id='oa_third_name' value="<%=oa_third_name%>">
	<input type='hidden' name='oa_name_prefix_loc_lang' id='oa_name_prefix_loc_lang' value="<%=oa_name_prefix_loc_lang%>">
	<input type='hidden' name='oa_first_name_loc_lang' id='oa_first_name_loc_lang' value="<%=oa_first_name_loc_lang%>">
	<input type='hidden' name='oa_second_name_loc_lang' id='oa_second_name_loc_lang' value="<%=oa_second_name_loc_lang%>">
	<input type='hidden' name='oa_third_name_loc_lang' id='oa_third_name_loc_lang' value="<%=oa_third_name_loc_lang%>">
	<input type='hidden' name='oa_family_name_loc_lang' id='oa_family_name_loc_lang' value="<%=oa_family_name_loc_lang%>">
	<input type='hidden' name='oa_name_suffix_loc_lang' id='oa_name_suffix_loc_lang' value="<%=oa_name_suffix_loc_lang%>">	
	<input type='hidden' name='oa_oth_alt_id_type' id='oa_oth_alt_id_type' value="<%=oa_oth_alt_id_type%>">		
	<input type='hidden' name='oa_years' id='oa_years' value="<%=oa_years%>">		
	<input type='hidden' name='oa_months' id='oa_months' value="<%=oa_months%>">		
	<input type='hidden' name='oa_days' id='oa_days' value="<%=oa_days%>">	
	<input type='hidden' name='oa_addr_line1' id='oa_addr_line1' value="<%=oa_addr_line1%>">	
	<input type='hidden' name='oa_addr_line2' id='oa_addr_line2' value="<%=oa_addr_line2%>">	
	<input type='hidden' name='oa_addr_line3' id='oa_addr_line3' value="<%=oa_addr_line3%>">	
	<input type='hidden' name='oa_addr_line4' id='oa_addr_line4' value="<%=oa_addr_line4%>">	
	<input type='hidden' name='oa_res_area_code' id='oa_res_area_code' value="<%=oa_res_area_code%>">	
	<input type='hidden' name='oa_res_area_desc' id='oa_res_area_desc' value="<%=oa_res_area_desc%>">	
	<input type='hidden' name='oa_res_reg_code' id='oa_res_reg_code' value="<%=oa_res_reg_code%>">	
	<input type='hidden' name='oa_res_reg_desc' id='oa_res_reg_desc' value="<%=oa_res_reg_desc%>">	
	<input type='hidden' name='oa_res_town_code' id='oa_res_town_code' value="<%=oa_res_town_code%>">	
	<input type='hidden' name='oa_res_town_desc' id='oa_res_town_desc' value="<%=oa_res_town_desc%>">	
	<input type='hidden' name='oa_res_country_code' id='oa_res_country_code' value="<%=oa_res_country_code%>">	
	<input type='hidden' name='oa_res_country_name' id='oa_res_country_name' value="<%=oa_res_country_name%>">	
	<input type='hidden' name='oa_res_postal_code' id='oa_res_postal_code' value="<%=oa_res_postal_code%>">	
	<input type='hidden' name='oa_email_id' id='oa_email_id' value="<%=oa_email_id%>">
	<input type='hidden' name='oa_res_tel_no' id='oa_res_tel_no' value="<%=oa_res_tel_no%>">	
	<input type='hidden' name='oa_oth_contact_no' id='oa_oth_contact_no' value="<%=oa_oth_contact_no%>">
	<input type='hidden' name='oa_res_postal_desc' id='oa_res_postal_desc' value="<%=oa_res_postal_desc%>">	
	<input type='hidden' name='oa_mail_postal_desc' id='oa_mail_postal_desc' value="<%=oa_mail_postal_desc%>">
	<input type='hidden' name='oa_mail_addr_line1' id='oa_mail_addr_line1' value="<%=oa_mail_addr_line1%>">	
	<input type='hidden' name='oa_mail_addr_line2' id='oa_mail_addr_line2' value="<%=oa_mail_addr_line2%>">	
	<input type='hidden' name='oa_mail_addr_line3' id='oa_mail_addr_line3' value="<%=oa_mail_addr_line3%>">	
	<input type='hidden' name='oa_mail_addr_line4' id='oa_mail_addr_line4' value="<%=oa_mail_addr_line4%>">	
	<input type='hidden' name='oa_mail_res_area_code' id='oa_mail_res_area_code' value="<%=oa_mail_res_area_code%>">	
	<input type='hidden' name='oa_mail_res_area_desc' id='oa_mail_res_area_desc' value="<%=oa_mail_res_area_desc%>">	
	<input type='hidden' name='oa_mail_res_reg_code' id='oa_mail_res_reg_code' value="<%=oa_mail_res_reg_code%>">	
	<input type='hidden' name='oa_mail_res_reg_desc' id='oa_mail_res_reg_desc' value="<%=oa_mail_res_reg_desc%>">	
	<input type='hidden' name='oa_mail_res_town_code' id='oa_mail_res_town_code' value="<%=oa_mail_res_town_code%>">	
	<input type='hidden' name='oa_mail_res_town_desc' id='oa_mail_res_town_desc' value="<%=oa_mail_res_town_desc%>">	
	<input type='hidden' name='oa_mail_res_country_code' id='oa_mail_res_country_code' value="<%=oa_mail_res_country_code%>">	
	<input type='hidden' name='oa_mail_res_country_name' id='oa_mail_res_country_name' value="<%=oa_mail_res_country_name%>">	
	<input type='hidden' name='oa_mail_res_postal_code' id='oa_mail_res_postal_code' value="<%=oa_mail_res_postal_code%>">	
	<input type='hidden' name='bkg_grace_period' id='bkg_grace_period' value="<%=bkg_grace_period%>">	
	<input type='hidden' name='maxPatAge' id='maxPatAge' value="<%=max_patient_age%>" > 
	
	<script>
		if('<%=call_function%>' == 'CA_Task_IP_Booking')
		{

			document.forms[0].referral_id.readOnly= true;
			document.forms[0].referral_details.disabled= false;
			checkPatient(document.forms[0].patient_id);
			
			if(document.forms[0].patient_id.value != "")
				document.forms[0].patient_id.disabled= true;
		}

		if('<%=call_function%>' == 'OA_IP_Booking')
		{
			checkPatient(document.forms[0].patient_id);
		}
		/*
		if('<%=confirm_bkg_auth%>' == 'N')
		{
			document.getElementById("bed_detail").style.visibility="hidden";
		}
		
	*/
		if('<%=Unregpatbkgyn%>' == 'N')
		{
			document.forms[0].patgif.style.visibility="visible";
		}

		if('<%=allowed_booking_type%>' == 'R')
			document.forms[0].ref_img.style.visibility="visible";
		else
			document.forms[0].ref_img.style.visibility="hidden";
	</script>

<%
	if(is_op_pending_referral_booking.equals("Y"))
		{
	%>
			<script>
			document.forms[0].referral_id.onblur();
			document.forms[0].referral_details.disabled = true;
			document.forms[0].referral_id.disabled = true;
			</script>
	<%
		}
if(allowed_booking_type.equals("R"))
{	%>
	<script>
		document.booking_form.patient_id.disabled = true;
		document.booking_form.search.disabled = true;

		if(document.booking_form.name_prefix1)
			document.booking_form.name_prefix1.disabled = true;

		if(document.booking_form.name_prefix)
			document.booking_form.name_prefix.disabled = true;


		if(document.booking_form.family_name)
			document.booking_form.family_name.disabled = true;

		if(document.booking_form.first_name)
			document.booking_form.first_name.disabled = true;

		if(document.booking_form.second_name)
			document.booking_form.second_name.disabled = true;

		if(document.booking_form.third_name)
			document.booking_form.third_name.disabled = true;

		if(document.booking_form.name_suffix1)
			document.booking_form.name_suffix1.disabled = true;

		if(document.booking_form.name_suffix)
			document.booking_form.name_suffix.disabled = true;

		document.booking_form.sex.disabled = true;

		if(document.booking_form.b_birth)
			document.booking_form.b_birth.disabled = true;

		document.booking_form.b_age.disabled = true;
		document.booking_form.b_months.disabled = true;
		document.booking_form.b_days.disabled = true;
		document.booking_form.date_of_birth.disabled = true;
		document.getElementById("dob").disabled = true;
		document.booking_form.national_id_no.disabled =true;
		document.booking_form.nationality_desc.disabled= true;
		document.booking_form.nationality_id.disabled = true;
		document.booking_form.birth_place.disabled	= true;
		document.booking_form.place_of_birth.disabled	= true;
		//document.booking_form.race_code.disabled = true;
		if(document.booking_form.race_desc) {
			document.booking_form.race_desc.disabled = true;
			document.booking_form.race_desc_id.disabled = true;
		}
		document.booking_form.ethnic_group.disabled = true;
		document.booking_form.citizen_yn[0].disabled = true;		
		document.booking_form.citizen_yn[1].disabled = true;		
		document.booking_form.legal_yn[0].disabled = true;		
		document.booking_form.legal_yn[1].disabled = true;		

		if(document.booking_form.alt_id1_no)
			document.booking_form.alt_id1_no.disabled = true;

		if(document.booking_form.alt_id2_no)
			document.booking_form.alt_id2_no.disabled = true;

		if(document.booking_form.alt_id3_no)
			document.booking_form.alt_id3_no.disabled = true;

		if(document.booking_form.alt_id4_no)
			document.booking_form.alt_id4_no.disabled = true;
			
		if(document.booking_form.alt_id1_exp_date)
			document.booking_form.alt_id1_exp_date.disabled = true;

		if(document.booking_form.alt_id2_exp_date)
			document.booking_form.alt_id2_exp_date.disabled = true;

		if(document.booking_form.alt_id3_exp_date)
			document.booking_form.alt_id3_exp_date.disabled = true;

		if(document.booking_form.alt_id4_exp_date)
			document.booking_form.alt_id4_exp_date.disabled = true;

		if(document.booking_form.other_alt_type)
			document.booking_form.other_alt_type.disabled = true;

		if(document.booking_form.other_alt_Id)
			document.booking_form.other_alt_Id.disabled = true;

		document.booking_form.addr_line1.disabled = true;
		document.booking_form.addr_line2.disabled = true;
		document.booking_form.addr_line3.disabled = true;
		document.booking_form.addr_line4.disabled = true;
		document.booking_form.mail_addr_line1.disabled = true;
		document.booking_form.mail_addr_line2.disabled = true;
		document.booking_form.mail_addr_line3.disabled = true;
		document.booking_form.mail_addr_line4.disabled = true;
		document.booking_form.mail_region_desc.readOnly = true; 




	if(document.booking_form.name_prefix_oth != null)
	{
		document.booking_form.name_prefix_oth_lang.disabled = true;
	}


	if(document.booking_form.first_oth_name_reqd_yn != null)
	{
		document.booking_form.first_name_oth_lang.disabled = true;
	}

	if(document.booking_form.second_oth_name_reqd_yn != null)
	{
		document.booking_form.second_name_oth_lang.disabled = true;
	}

	if(document.booking_form.third_oth_name_reqd_yn != null)
	{
		document.booking_form.third_name_oth_lang.disabled = true;
	}

	if(document.booking_form.family_oth_name_reqd_yn != null)
	{
		document.booking_form.family_name_oth_lang.disabled = true;
	}


	if(document.booking_form.name_suffix_oth != null)
	{
		document.booking_form.name_suffix_oth_lang.disabled = true;
	}



	</script>
<% }

	if (rs != null) rs.close();
	if (stmt != null) stmt.close();
	if (prs != null)  prs.close();
	if (pstmt != null) pstmt.close();
	/*modification for SRR20056-CRF-0506*/
	if ( bookingtype_list != null) bookingtype_list.clear();
}catch(Exception e) 
{
/* 	out.println(e.toString()); */
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
	   <input type='hidden' name='chk_booking_limit_by' id='chk_booking_limit_by' value="<%=chk_booking_limit_by%>" >
	   <input type='hidden' name='sStyle' id='sStyle' value="<%=sStyle%>" >
	   <input type='hidden' name='sdate2' id='sdate2' value="<%=sqlsd2%>" >
	   <input type='hidden' name='gifval' id='gifval' value="<%=Unregpatbkgyn%>" >
	   <input type='hidden' name='pref_adm_date_hid' id='pref_adm_date_hid' value="<%=booking_date_time%>" >
	   <input type='hidden' name='unregisteredpatientsbkgyn' id='unregisteredpatientsbkgyn' value="<%=Unregpatbkgyn%>"> 
	   <input type='hidden' name='contactvals' id='contactvals' value=''>
	   <input type='hidden' name='source_type' id='source_type' value=''>
	   <input type='hidden' name='source' id='source' value=''>
	   <input type='hidden' name='medsergrpcode_hid' id='medsergrpcode_hid' value="<%=med_hid_val%>">
	   <input type='hidden' name='locale1' id='locale1' value="<%=locale%>">
	   <input type='hidden' name='block_bed_based_on' id='block_bed_based_on' value="<%=block_bed_based_on%>" >
	   <input type='hidden' name='is_op_pending_referral_booking' id='is_op_pending_referral_booking' value="<%=is_op_pending_referral_booking%>">
	   <input type='hidden' name='physician_code' id='physician_code' value='<%=physician_code%>'>
	   <input type='hidden' name='physician_desc' id='physician_desc' value='<%=physician_desc%>'>
	   <input type='hidden' name='ot_medical_service' id='ot_medical_service' value='<%=medical_service%>'>
	   <input type='hidden' name='ot_nursing_unit_code' id='ot_nursing_unit_code' value='<%=nursing_unit_code%>'>
	   <input type='hidden' name='ot_nursing_unit_short_desc' id='ot_nursing_unit_short_desc' value='<%=nursing_unit_short_desc%>'>
	   <!--  billing related variables -->
	   <input type='hidden' name='package_flag' id='package_flag' value='N'>
	   <input type='hidden' name='bl_operation' id='bl_operation' value=''>
	   <input type='hidden' name='billing_mode' id='billing_mode' value='Add'>
	   <input type='hidden' name='billing_group' id='billing_group' value=''>
	   <input type='hidden' name='pkg_bill_type' id='pkg_bill_type' value=''>
	   <input type='hidden' name='pkg_bill_no' id='pkg_bill_no' value=''>
	   <input type="hidden" name="patient_class_id" id="patient_class_id" value="IP">
	   <input type='hidden' name='health_card_expired_yn' id='health_card_expired_yn' value=''>
	   <input type='hidden' name='Chg_to_Visitor_Grp' id='Chg_to_Visitor_Grp' value='N'>
	   <input type='hidden' name='bl_interface_yn' id='bl_interface_yn' value="<%=isBlInterfaced%>"> 
	   <input type='hidden' name='bl_future_admn_YN' id='bl_future_admn_YN' value=''>
	   <input type='hidden' name='financial_detail_ref_id' id='financial_detail_ref_id' value=''>
	   <input type='hidden' name='org_type_ind' id='org_type_ind' value=''>
	   <input type='hidden' name='att_practid' id='att_practid' value="">
	   <input type='hidden' name='isBlInstalled' id='isBlInstalled' value='<%=bl_operational%>'>
	   <input type='hidden' name='bl_success' id='bl_success' value='N'>
	   <input type='hidden' name='insTrackDtlsExists' id='insTrackDtlsExists' value=''>
	   <input type='hidden' name='isBlInterfaced' id='isBlInterfaced' value='<%=isBlInterfaced%>'>
	   <input type='hidden' name='iscapture_fin_dtls_yn' id='iscapture_fin_dtls_yn' value='<%=capture_fin_dtls_yn%>'>
	   <input type='hidden' name='deactivate_pseudo_bed_yn' id='deactivate_pseudo_bed_yn' value='<%=deactivate_pseudo_bed_yn%>'>
	   <input type='hidden' name='create_booking_with_conf_yn' id='create_booking_with_conf_yn' value='<%=create_booking_with_conf_yn%>'>
	   <input type='hidden' name='removePatInstruction' id='removePatInstruction' value=''>
	   <input type='hidden' name='isReviseBkgAftrConfrmAppl' id='isReviseBkgAftrConfrmAppl' value='<%=isReviseBkgAftrConfrmAppl%>'><!--Added by Thamizh selvi on 22nd May 2018 against ML-MMOH-CRF-0622-->
	   
	 	</form>
	</BODY>
</HTML>

	<%if(call_function.equals("OT"))
		{
	%>
		<script>
		

		parent.frames[0].document.forms[0].reset.disabled = true;
	
		</script>
	<% } %>
<%!

// This method is checking for the null values
private String checkForNull(String inputString)
{
	return ((inputString==null) || (inputString.equals("null")) || (inputString.equals("")))	?	""	:	inputString;
}

// This method is used for populating the contact details
public StringBuffer getContactDetails(String from,String P_fromValue,String appt_ref_no,HttpServletRequest request,JspWriter out,Connection con, String locale, String facilityID) throws Exception
{
	
	PreparedStatement		pstmt			= null ;
	ResultSet				resultSet		= null ;
	String                  fromValue		= P_fromValue;

	String a_res_addr_line1		= "";
	String a_res_addr_line2		= "";
	String a_res_addr_line3		= "";
	String a_res_addr_line4		= "";
	String a_country_code		= "";
	String a_postal_code		= "";
	String a_res_area			= "";
	String a_res_area_code		= "";
	String a_res_town2_code		= "";
	String a_res_town2_desc		= "";
	String a_res_region_code	= "";
	String a_res_region_desc	= "" ;
	String m_res_addr_line1		= "";
	String m_res_addr_line2		= "";
	String m_res_addr_line3		= "";
	String m_res_addr_line4		= "";
	String m_postal_code		= "";
	String m_country_code		= "";
	String m_res_area_code		= "";
	String m_res_area_desc		= "";
	String m_res_town2_code		= "";
	String m_res_town2_desc		= "";
	String m_res_region_code	= "";
	String m_res_region_desc	= "";
	String 	strPrimaryResNo		= "";
	String 	strOtherResNo		= "";
	String 	strEmail			= "";
	StringBuffer contactAddress = new StringBuffer();
	StringBuffer sqlContact		= new StringBuffer();

	if(!appt_ref_no.equals(""))
	{
		//thai - oa_appt
		if(sqlContact.length() > 0) sqlContact.delete(0,sqlContact.length());
		sqlContact.append(" select res_addr_line1 addr1_line1, res_addr_line2 addr1_line2, res_addr_line3 addr1_line3, res_addr_line4 addr1_line4, res_town_code, MP_GET_DESC.MP_RES_TOWN(RES_TOWN_CODE,'"+locale+"','1') res_town, res_area_code, MP_GET_DESC.MP_RES_AREA(RES_AREA_CODE,'"+locale+"','1')  res_area, res_region_code region_code, MP_GET_DESC.MP_REGION(RES_REGION_CODE,'"+locale+"','2') region, country_code country1_code, postal_code postal1_code, mail_addr_line1 addr2_line1, mail_addr_line2 addr2_line2, mail_addr_line3 addr2_line3, mail_addr_line4 addr2_line4, mail_town_code res_town2_code, MP_GET_DESC.MP_RES_TOWN(MAIL_TOWN_CODE,'"+locale+"','2') res_town2, mail_area_code res_area2_code, MP_GET_DESC.MP_RES_AREA(MAIL_AREA_CODE,'"+locale+"','2') res_area2, mail_region_code region2_code, MP_GET_DESC.MP_REGION(MAIL_REGION_CODE,'"+locale+"','2') region2_desc, mail_country_code country2_code, mail_postal_code postal2_code, res_tel_no contact1_no, oth_contact_no contact2_no, email_id from OA_APPT WHERE facility_id='"+facilityID+"' and appt_ref_no = ? ");
		fromValue = appt_ref_no;
	}
	else // If its from refferal id then it will search the contact details from pr_refferal_register
	{
		if(from.equals("referral_id"))
		{
			//thai -  chk for address - rest done
			if(sqlContact.length() > 0) sqlContact.delete(0,sqlContact.length());
			sqlContact.append(" select addr_line1 addr1_line1, addr_line2 addr1_line2, addr_line3 ddr1_line3, addr_line4 addr1_line4, res_town_code, MP_GET_DESC.MP_RES_TOWN(RES_TOWN_CODE,'"+locale+"','1') res_town, res_area_code, MP_GET_DESC.MP_RES_AREA(RES_AREA_CODE,'"+locale+"','1') res_area, region_code,  MP_GET_DESC.MP_REGION(region_code,'"+locale+"','2') region, country_code country1_code, postal_code postal1_code, mail_addr_line1 addr2_line1, mail_addr_line2 addr2_line2, mail_addr_line3 addr2_line3, mail_addr_line4 addr2_line4, mail_res_town_code res_town2_code, MP_GET_DESC.MP_RES_TOWN(MAIL_RES_TOWN_CODE,'"+locale+"','2') res_town2, mail_res_area_code res_area2_code, MP_GET_DESC.MP_RES_AREA(MAIL_RES_AREA_CODE,'"+locale+"','2') res_area2, mail_region_code region2_code, MP_GET_DESC.MP_REGION(MAIL_REGION_CODE,'"+locale+"','2') region2_desc, mail_country_code country2_code, mail_postal_code postal2_code, contact1_no, contact2_no, email_id FROM PR_REFERRAL_REGISTER where referral_id = ? ");
		}

		// If its from patient id then it will search the contact details from mp_patient and mp_pat_addresses
		if(from.equals("patient_id"))
		{
			 //thai - chk for address - rest done
			if(sqlContact.length() > 0) sqlContact.delete(0,sqlContact.length());
		 	sqlContact.append(" select a.addr1_type, a.addr1_line1, a.addr1_line2, a.addr1_line3, a.addr1_line4, a.postal1_code, a.country1_code, a.contact1_name, a.invalid1_yn, MP_GET_DESC.MP_RES_AREA(b.RES_AREA_CODE,'"+locale+"','1') res_area, b.res_area_code, MP_GET_DESC.MP_RES_TOWN(b.RES_TOWN_CODE,'"+locale+"','2') res_town, b.res_town_code, MP_GET_DESC.MP_REGION(b.REGION_CODE,'"+locale+"','2') region, b.region_code, a.addr2_type, a.addr2_line1, a.addr2_line2, a.addr2_line3, a.addr2_line4, a.postal2_code, a.country2_code, a.contact2_name, a.invalid2_yn, MP_GET_DESC.MP_RES_AREA(a.res_area2_code,'"+locale+"','2')  res_area2, a.res_area2_code, MP_GET_DESC.MP_RES_TOWN(a.res_town2_code,'"+locale+"','2') res_town2, a.res_town2_code, MP_GET_DESC.MP_REGION(a.region2_code,'"+locale+"','2') region2_desc, a.region2_code, b.contact1_no, b.contact2_no, b.email_id from MP_PAT_ADDRESSES a, MP_PATIENT b where b.patient_id = a.patient_id and  b.patient_id = ? ");
		}
	} 

	try 
	{
		con					= ConnectionManager.getConnection(request);
		pstmt               = con.prepareStatement(sqlContact.toString()) ;
		pstmt.setString( 1, fromValue);
		resultSet			= pstmt.executeQuery() ;
		// adition to contact details pop starts here on 2/17/2004...
		if(resultSet != null)
		{
			while(resultSet.next())
			{
				a_res_addr_line1		= checkForNull(resultSet.getString("addr1_line1"));
				a_res_addr_line2		= checkForNull(resultSet.getString("addr1_line2"));
				a_res_addr_line3		= checkForNull(resultSet.getString("addr1_line3"));
				a_res_addr_line4		= checkForNull(resultSet.getString("addr1_line4"));
				a_country_code			= checkForNull(resultSet.getString("country1_code"));
				a_postal_code			= checkForNull(resultSet.getString("postal1_code"));
				a_res_area_code			= checkForNull(resultSet.getString("res_area_code"));
				a_res_area				= checkForNull(resultSet.getString("res_area"));			
				a_res_town2_code		= checkForNull(resultSet.getString("res_town_code"));
				a_res_town2_desc		= checkForNull(resultSet.getString("res_town"));
				a_res_region_code		= checkForNull(resultSet.getString("region_code"));
				a_res_region_desc		= checkForNull(resultSet.getString("region"));			
				m_res_addr_line1		= checkForNull(resultSet.getString("addr2_line1"));
				m_res_addr_line2		= checkForNull(resultSet.getString("addr2_line2"));
				m_res_addr_line3		= checkForNull(resultSet.getString("addr2_line3"));
				m_res_addr_line4		= checkForNull(resultSet.getString("addr2_line4"));
				m_postal_code			= checkForNull(resultSet.getString("postal2_code"));
				m_country_code			= checkForNull(resultSet.getString("country2_code"));
				m_res_area_code			= checkForNull(resultSet.getString("res_area2_code"));
				m_res_area_desc			= checkForNull(resultSet.getString("res_area2"));
				m_res_town2_code		= checkForNull(resultSet.getString("res_town2_code"));
				m_res_town2_desc		= checkForNull(resultSet.getString("res_town2"));
				m_res_region_code		= checkForNull(resultSet.getString("region2_code"));
				m_res_region_desc		= checkForNull(resultSet.getString("region2_desc"));
				strPrimaryResNo			= checkForNull(resultSet.getString("CONTACT1_NO"));
				strOtherResNo			= checkForNull(resultSet.getString("CONTACT2_NO"));
				strEmail				= checkForNull(resultSet.getString("EMAIL_ID"));	
			}
		}
		contactAddress.append(""+"^^");
		contactAddress.append(a_res_addr_line1+"^^");
		contactAddress.append(a_res_addr_line2+"^^");
		contactAddress.append(a_res_addr_line3+"^^");
		contactAddress.append(a_res_addr_line4+"^^");
		contactAddress.append(a_res_town2_code+"^^");
		contactAddress.append(a_res_area_code+"^^");
		contactAddress.append(a_postal_code+"^^");
		contactAddress.append(a_res_region_code+"^^");
		contactAddress.append(a_country_code+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(m_res_addr_line1+"^^");
		contactAddress.append(m_res_addr_line2+"^^");
		contactAddress.append(m_res_addr_line3+"^^");
		contactAddress.append(m_res_addr_line4+"^^");
		contactAddress.append(m_res_town2_code+"^^");
		contactAddress.append(m_res_area_code+"^^");
		contactAddress.append(m_postal_code+"^^");
		contactAddress.append(m_res_region_code+"^^");
		contactAddress.append(m_country_code+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(strPrimaryResNo+"^^");
		contactAddress.append(strOtherResNo+"^^");
		contactAddress.append(strEmail+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(a_res_town2_desc+"^^");
		contactAddress.append(a_res_area+"^^");
		contactAddress.append(a_res_region_desc+"^^");
		contactAddress.append(m_res_town2_desc+"^^");
		contactAddress.append(m_res_area_desc+"^^");
		contactAddress.append(m_res_region_desc);

	if(pstmt!=null)         pstmt.close();
	if(resultSet!=null)     resultSet.close();

	}catch ( Exception e )
	{
		
		e.printStackTrace() ;
				out.println(e.toString());   
	}
	finally
	{
			ConnectionManager.returnConnection(con,request);
	}
 	return contactAddress;
}	
%>

<%!
	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString==null) || (inputString.equals("null")) ? defaultValue : inputString);
	}
%>

