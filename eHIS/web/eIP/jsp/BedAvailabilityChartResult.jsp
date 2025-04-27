<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,eCommon.Common.*,java.sql.*, java.util.*, java.text.*,java.net.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>
<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eIP/js/BedAvailChart.js' language='javascript'></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
	input[type="button"]
	{
		margin:1px;
	}
</style>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String locale				= (String)session.getAttribute("LOCALE");
	String facility_id			= (String)session.getValue("facility_id");
	String loginUser			= (String)session.getValue("login_user");
	String bl_operational		= (String)session.getValue("bl_operational");
	String call_function		= checkForNull(request.getParameter("call_function"));
	String call_func			= checkForNull(request.getParameter("call_func"));
	String disable_field 		= checkForNull(request.getParameter("disable_field"));
	String bedClass_dis_yn 		= checkForNull(request.getParameter("bedClass_dis_yn"));
	String ipparam_bed_yn		= checkForNull(request.getParameter("ipparam_bed_yn"));
	String wherecondn			= checkForNull(request.getParameter("wherecondn"));	
	String current_patient_id	= checkForNull(request.getParameter("patient_id"));	
	String reserve_bed_selectable= checkForNull(request.getParameter("reserve_bed_selectable"));	
	String exp_dis_date			= "";
	/*Added By Dharma on 04th Oct 2014 against HSA-CRF-0180 [IN:049539] Start*/
	String isPatientOccupiedDeparted	= "N";
	String pat_curr_locn_desc			= "";
	String movementReason				= "";
	String pat_curr_locn_type_desc		= "";
	String movement_reason				= "";
	/*Added By Dharma on 04th Oct 2014 against HSA-CRF-0180 [IN:049539] End*/
%>
<script>
//Pls note.. This function is not moved to BedAvailChart.js as Java variables are directly used in this function...
function resetValues()
{
	parent.processBar.document.location.href = "../../eCommon/html/blank.html";
	var disable_field = "<%=disable_field%>";
	var bed_yn='<%=ipparam_bed_yn%>';
	
	parent.criteria0.document.forms[0].Splcode.disabled = false;
	parent.criteria0.document.BedAvailabilityChart_Form0.bed_type_code.disabled=false;
	parent.criteria0.document.BedAvailabilityChart_Form0.Bedcode.disabled=false;
	parent.criteria0.document.BedAvailabilityChart_Form0.nursing_unit.disabled	= false;

	parent.criteria0.document.forms[0].bed_classification.disabled = false;
	parent.criteria0.document.forms[0].gender.disabled = false;
	parent.criteria0.document.forms[0].age_value.disabled = false;
	parent.criteria0.document.forms[0].age.disabled = false;
	parent.criteria0.document.forms[0].release_hrs.disabled = false;
	parent.criteria0.document.forms[0].search_by_beds.disabled = false;
	parent.criteria0.document.forms[0].search_butt.disabled = false;
	parent.criteria0.document.forms[0].clear_butt.disabled = false;
	if(parent.criteria0.document.forms[0].cancel_butt)
		parent.criteria0.document.forms[0].cancel_butt.disabled = false;
	parent.criteria0.document.forms[0].BedListinOrder1.disabled = false;
	if(parent.criteria0.document.forms[0].BedListinOrder2.value != "")
		parent.criteria0.document.forms[0].BedListinOrder2.disabled = false;
	if(parent.criteria0.document.forms[0].BedListinOrder3.value != "")
		parent.criteria0.document.forms[0].BedListinOrder3.disabled = false;
	parent.criteria0.document.forms[0].privacy_level.disabled = false;

	/// Added by Sridhar R on 13 JULY 2004
	///	This fuunction will default Bed Classification as "Pseudo Bed" & Disable the field, if the parameter bedClass_dis_yn value is "Y"...
	var bedClass_dis_yn = "<%=bedClass_dis_yn%>";
	if(bedClass_dis_yn == "Y")
	{
		parent.criteria0.document.BedAvailabilityChart_Form0.bed_classification.disabled	=true;
	}
	parent.criteria0.document.forms[0].pract_id_search.disabled = false;

	if (disable_field == "NursingUnit")
	{
		parent.criteria0.document.BedAvailabilityChart_Form0.nursing_unit.disabled	= true;
	}
	else if (disable_field == "NursingUnitSpecialty")
	{
		parent.criteria0.document.forms[0].nursing_unit.disabled = true;
		parent.criteria0.document.forms[0].Splcode.disabled = true;
	}
	else if (disable_field == "specialty")
	{
		parent.criteria0.document.BedAvailabilityChart_Form0.Splcode.disabled		= true;
	}
	else if (disable_field == "NuBcBt")
	{
		parent.criteria0.document.BedAvailabilityChart_Form0.nursing_unit.disabled	= true;
		parent.criteria0.document.BedAvailabilityChart_Form0.bed_type_code.disabled=true;
		parent.criteria0.document.BedAvailabilityChart_Form0.Bedcode.disabled=true;
	}
	else if (disable_field == "NuSyBcBt")
	{
		parent.criteria0.document.BedAvailabilityChart_Form0.nursing_unit.disabled	= true;
		parent.criteria0.document.BedAvailabilityChart_Form0.Splcode.disabled		= true;
		parent.criteria0.document.BedAvailabilityChart_Form0.bed_type_code.disabled=true;
		parent.criteria0.document.BedAvailabilityChart_Form0.Bedcode.disabled=true;
	}
	else if (disable_field == "SyBcBt")
	{
		parent.criteria0.document.BedAvailabilityChart_Form0.Splcode.disabled		= true;
		parent.criteria0.document.BedAvailabilityChart_Form0.bed_type_code.disabled=true;
		parent.criteria0.document.BedAvailabilityChart_Form0.Bedcode.disabled=true;
	}
	else if (disable_field == "BcBt")
	{
		parent.criteria0.document.BedAvailabilityChart_Form0.bed_type_code.disabled=true;
		parent.criteria0.document.BedAvailabilityChart_Form0.Bedcode.disabled=true;
	}/*Friday, February 12, 2010 IN000242(emergency release),Nursing unit list item getting enable from Bed for Nursing Unit function*/
	else if (disable_field == "Nursing")
	{
		parent.criteria0.document.BedAvailabilityChart_Form0.nursing_unit.disabled	= true;
	}
	else 
	{
		parent.criteria0.document.forms[0].nursing_unit.disabled = false;

		if("<%=wherecondn%>" == "CREATE_BOOKING_YN")
			parent.criteria0.document.forms[0].Splcode.disabled = true;
		else
			parent.criteria0.document.forms[0].Splcode.disabled = false;
	}
/*	
	if(bed_yn=="Y")
	{
		parent.criteria0.document.forms[0].Bedcode.disabled = true;
		parent.criteria0.document.forms[0].bed_type_code.disabled = true;
	}
	else
	{
		parent.criteria0.document.forms[0].Bedcode.disabled = false;
		parent.criteria0.document.forms[0].bed_type_code.disabled = false;
	}
*/
}

</script>
<%
Connection con			= null;
Statement stmt			= null;
ResultSet rs			= null;
Statement param_stmt	= null;
ResultSet param_rs		= null;
Statement stmt_cnt		= null;
ResultSet rs_cnt		= null;
PreparedStatement dispstmt		= null;
ResultSet disrs		= null;
PreparedStatement pstmt = null;

String gend					= "";
String age					= "";
String bg_gend				= "";
String bg_age				= "";
String BedClassification	= "";
String deactivate_pseudoBed	= "";
String group1				= "";
String group2				= "";
String group3				= "";
String group4				= "";
String nursing_unit_code	= "";
String p_nursing_unit_desc	= "";
String pat_curr_locn_code	= "";
String prev_group			= "";
String prev_group1			= "";
String prev_group2			= "";
String prev_group3			= "";
String prev_group4			= "";
String pseudo_bed_yn		= "";
String splty_code			= "";
String splty_desc			= "";
//String patient_name_loc_lang= "";
//String bg_patient_name_loc_lang= "";
String bbed					= "&nbsp;";
String nonoverridable		= "&nbsp;";
String occupied				= "&nbsp;";
String overridable			= "&nbsp;";
String total				= "&nbsp;";
String vacant				= "&nbsp;";

String oper_stn_id				= checkForNull(request.getParameter( "oper_stn_id"));
String bed_available_date_yn	= checkForNull(request.getParameter( "bed_available_date_yn"));
String main_bed_no				= checkForNull(request.getParameter( "main_bed_no"));
String bed_classification		= checkForNull(request.getParameter( "bed_classification" ) );
String bed_type_code			= checkForNull(request.getParameter( "bed_type_code" ) );
String gender1					= checkForNull(request.getParameter( "gender"));
String pracitioner_id			= checkForNull(request.getParameter( "practid" ));
String speciality_code			= checkForNull(request.getParameter( "Splcode" ));
String age_value				= checkForNull(request.getParameter( "age_value" ));
String AGE						= checkForNull(request.getParameter( "age" ));
String privacy_level			= checkForNull(request.getParameter( "privacy_level" ) );
String BedListinOrder1			= checkForNull(request.getParameter( "BedListinOrder1"));
String BedListinOrder2			= checkForNull(request.getParameter( "BedListinOrder2"));
String BedListinOrder3			= checkForNull(request.getParameter( "BedListinOrder3"));
String BedListinOrder4			= checkForNull(request.getParameter( "BedListinOrder4"));
String patient_class			= checkForNull(request.getParameter( "patient_class"));

String room_no_code 			= checkForNull(request.getParameter( "room_no_code"));
String query_gender_type		= checkForNull(request.getParameter( "query_gender_type"));
String search_by_beds			= checkForNull(request.getParameter( "search_by_beds" ));
String available_nursing_unit	= checkForNull(request.getParameter("available_nursing_unit"));

String	allow_booking_without_edd_yn = "";
String	allow_booking_with_edd_yn    = "";

String future_booking_for_boc_yn     = "";

String consider_edd_stop_for_boc_yn	 = "";
String action_for_boc				 = "";

String future_booking_for_bou_yn	 = "";

String consider_edd_stop_for_bou_yn  = "";
String action_for_bou				 = "";

String future_booking_for_bnc_yn	 = "";

String consider_edd_stop_for_bnc_yn  = "";
String action_for_bnc                = "";

String future_booking_for_bnu_yn	 = "";

String consider_edd_stop_for_bnu_yn  = "";
String action_for_bnu				 = "";

String expected_discharge_date		 = "";

nursing_unit_code=available_nursing_unit;
if (nursing_unit_code.equals(""))
	nursing_unit_code = request.getParameter("nursing_unit");
if (nursing_unit_code==null || nursing_unit_code.equals(""))  nursing_unit_code= "";
if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
nursing_unit_code = specialCharacter(nursing_unit_code);

String bed_class_code	=  checkForNull(request.getParameter( "Bedcode" ) );
if (bed_class_code==null || bed_class_code.equals(""))  bed_class_code= "";

String release_hrs=request.getParameter("release_hrs");
if (release_hrs==null || release_hrs.equals("")) release_hrs="";

String from_date_truncated  = "";
String to_date_truncated    = "";

String from_date			= checkForNull(request.getParameter( "from_date_converted"));
String to_date				= checkForNull(request.getParameter( "to_date_converted"));
if(!from_date.equals(""))
{
	  from_date_truncated =from_date.substring(0,from_date.lastIndexOf(" "));
	//to_date_truncated =to_date.substring(0,to_date.lastIndexOf(" ")); //commented by  Munisekhar against [IN:050300] 
}
//code added by Munisekhar  against [IN:050300]  
if(!to_date.equals(""))
{
to_date_truncated =to_date.substring(0,to_date.lastIndexOf(" "));
}
int	bed_col_num	= 1;
int no_of_record	= 0;
%>
<body  id="b" onMouseDown="CodeArrest()" onKeyDown="lockKey()"><%

StringBuffer sql = new StringBuffer();
StringBuffer where_clause = new StringBuffer();

sql.append("select ");
where_clause.append("");
	
try
{
	/// added by Sridhar R 
	con= ConnectionManager.getConnection(request);
	String param_sql = "select deactivate_pseudo_bed_yn,allow_booking_without_edd_yn,allow_booking_with_edd_yn,future_booking_for_boc_yn,no_of_days_before_for_boc,consider_edd_stop_for_boc_yn,action_for_boc,future_booking_for_bou_yn,no_of_days_before_for_bou,consider_edd_stop_for_bou_yn,action_for_bou,future_booking_for_bnc_yn,no_of_days_before_for_bnc,consider_edd_stop_for_bnc_yn,action_for_bnc,future_booking_for_bnu_yn,no_of_days_before_for_bnu,consider_edd_stop_for_bnu_yn,action_for_bnu from IP_PARAM where facility_id = '"+facility_id+"' ";

	param_stmt = con.createStatement();
	param_rs = param_stmt.executeQuery( param_sql ) ;

	if( param_rs != null )
	{
		if(param_rs.next())
		{
			deactivate_pseudoBed = param_rs.getString("deactivate_pseudo_bed_yn") ;
			allow_booking_without_edd_yn=param_rs.getString("allow_booking_without_edd_yn");
			allow_booking_with_edd_yn=param_rs.getString("allow_booking_with_edd_yn");
			future_booking_for_boc_yn=param_rs.getString("future_booking_for_boc_yn");
			future_booking_for_bou_yn=param_rs.getString("future_booking_for_bou_yn");
			future_booking_for_bnc_yn=param_rs.getString("future_booking_for_bnc_yn");
			future_booking_for_bnu_yn=param_rs.getString("future_booking_for_bnu_yn");
			consider_edd_stop_for_boc_yn=param_rs.getString("consider_edd_stop_for_boc_yn");
			consider_edd_stop_for_bou_yn=param_rs.getString("consider_edd_stop_for_bou_yn");
			consider_edd_stop_for_bnc_yn=param_rs.getString("consider_edd_stop_for_bnc_yn");
			consider_edd_stop_for_bnu_yn=param_rs.getString("consider_edd_stop_for_bnu_yn");
			action_for_boc=param_rs.getString("action_for_boc");
			action_for_bou=param_rs.getString("action_for_bou");
			action_for_bnc=param_rs.getString("action_for_bnc");
			action_for_bnu=param_rs.getString("action_for_bnu");
		}
	}
	
	/// Added by Sridhar R  on 7 OCT 2004 for Billing Module...
	String Financial_classification  ="";
	String Bkg_Financial_classification  ="";
			if(bed_available_date_yn.equals("Y")){

			sql.append("(select (case	when booking_status = '1' and override_yn = 'Y' then 'BOC' when booking_status = '0' and override_yn = 'Y' then 'BOU' when booking_status = '1' and override_yn = 'N' then 'BNC' when booking_status = '0' and override_yn = 'N' then 'BNU' else	'N' end) from ip_bed_booking where  req_bed_no = a.bed_no and  req_room_no = a.room_no and req_bed_class_code = a.bed_class_code and req_bed_type_code = a.bed_type_code and req_nursing_unit_code = a.nursing_unit_code and ( trunc(blocked_from_date_time) >= to_date('"+from_date+"','dd/mm/yyyy hh24:mi') and ((trunc(blocked_from_date_time) <= to_date ('"+from_date+"','dd/mm/yyyy hh24:mi') + f.no_of_days_before_for_boc and booking_status = '1' and override_yn = 'Y') or (trunc(blocked_from_date_time) <= to_date ('"+from_date+"','dd/mm/yyyy hh24:mi') + f.no_of_days_before_for_bou and booking_status = '0' and override_yn = 'Y') or (trunc(blocked_from_date_time) <= to_date ('"+from_date+"','dd/mm/yyyy hh24:mi') + f.no_of_days_before_for_bnc and booking_status = '1' and override_yn = 'N')	or (trunc(blocked_from_date_time) <= to_date ('"+from_date+"','dd/mm/yyyy hh24:mi') + f.no_of_days_before_for_bnu and booking_status = '0' and override_yn = 'N')))	and rownum=1) days_before_status, (SELECT COUNT (*) no_of_record FROM ip_bed_booking WHERE booking_status IN ('0', '1') AND facility_id = a.facility_id AND req_nursing_unit_code = a.nursing_unit_code AND req_bed_no = a.bed_no AND blocked_from_date_time > SYSDATE AND (   (blocked_from_date_time BETWEEN TO_DATE ('"+from_date+"','DD/MM/YYYY HH24:MI' ) AND TO_DATE ('"+to_date+"','DD/MM/YYYY HH24:MI')) OR (blocked_until_date_time BETWEEN TO_DATE ('"+from_date+"','DD/MM/YYYY HH24:MI') AND TO_DATE ('"+to_date+"','DD/MM/YYYY HH24:MI' ) ) OR (    blocked_from_date_time <= TO_DATE ('"+from_date+"', 'DD/MM/YYYY HH24:MI') AND blocked_until_date_time >= TO_DATE ('"+to_date+"', 'DD/MM/YYYY HH24:MI'))))no_of_record, ");
			}else{

				sql.append("(select (case	when booking_status = '1' and override_yn = 'Y' then 'BOC' when booking_status = '0' and override_yn = 'Y' then 'BOU' when booking_status = '1' and override_yn = 'N' then 'BNC' when booking_status = '0' and override_yn = 'N' then 'BNU' else	'N' end)from ip_bed_booking where  req_bed_no = a.bed_no and  req_room_no = a.room_no and req_bed_class_code = a.bed_class_code and req_bed_type_code = a.bed_type_code and req_nursing_unit_code = a.nursing_unit_code and ( trunc(blocked_from_date_time) >= sysdate and ((trunc(blocked_from_date_time) <= sysdate + f.no_of_days_before_for_boc and booking_status = '1' and override_yn = 'Y') or (trunc(blocked_from_date_time) <= sysdate + f.no_of_days_before_for_bou and booking_status = '0' and override_yn = 'Y') or (trunc(blocked_from_date_time) <= sysdate + f.no_of_days_before_for_bnc and booking_status = '1' and override_yn = 'N')	or (trunc(blocked_from_date_time) <= sysdate + f.no_of_days_before_for_bnu and booking_status = '0' and override_yn = 'N')))	and rownum=1) days_before_status,  ");
			}
			/**/
	if(BedListinOrder1 !=null && !BedListinOrder1.equals("") )
	{
		BedListinOrder1 = specialCharacter(BedListinOrder1);
		if(BedListinOrder1.equals("specialty_short_desc"))
			sql.append("Am_Get_desc.AM_SPECIALITY(a.Specialty_Code,'"+locale+"','2') group1, ");
		else if(BedListinOrder1.equals("bed_type_short_desc"))
			sql.append(" ip_Get_desc.IP_BED_TYPE(a.Bed_Type_Code,'"+locale+"','2') group1, ");
		else if(BedListinOrder1.equals("room_long_desc"))
			sql.append(" am_get_desc.AM_FACILITY_ROOM(a.facility_id, a.room_no,'"+locale+"','1')group1, ");
		else if(BedListinOrder1.equals("admission_type"))
			sql.append(" ip_get_desc.IP_ADMISSION_TYPE(c.admission_type,'"+locale+"', '2') group1, ");
	}

	if( BedListinOrder2 !=null && !BedListinOrder2.equals("") )
	{
		BedListinOrder2 = specialCharacter(BedListinOrder2);
		if(BedListinOrder2.equals("specialty_short_desc"))
			sql.append("Am_Get_desc.Am_speciality(a.Specialty_Code,'"+locale+"','2') group2,");
		else if(BedListinOrder2.equals("bed_type_short_desc"))
			sql.append(" ip_Get_desc.Ip_bed_type(a.Bed_Type_Code,'"+locale+"','2') group2, ");
		else if(BedListinOrder2.equals("room_long_desc"))
			sql.append(" am_get_desc.am_facility_room (a.facility_id, a.room_no,'"+locale+"','1')group2,");
		else if(BedListinOrder2.equals("admission_type"))
			sql.append(" ip_get_desc.IP_ADMISSION_TYPE(c.admission_type,'"+locale+"', '2') group2, ");
	}

	if( BedListinOrder3 !=null && !BedListinOrder3.equals("") )
	{
		BedListinOrder3 = specialCharacter(BedListinOrder3);
		if(BedListinOrder3.equals("specialty_short_desc"))
			sql.append("Am_Get_desc.Am_speciality(a.Specialty_Code,'"+locale+"','2') group3,");
		else if(BedListinOrder3.equals("bed_type_short_desc"))
			sql.append(" ip_Get_desc.Ip_bed_type(a.Bed_Type_Code,'"+locale+"','2') group3, ");
		else if(BedListinOrder3.equals("room_long_desc"))
			sql.append(" am_get_desc.am_facility_room (a.facility_id, a.room_no,'"+locale+"','1')group3,");
		else if(BedListinOrder3.equals("admission_type"))
			sql.append(" ip_get_desc.IP_ADMISSION_TYPE(c.admission_type,'"+locale+"', '2') group3, ");
	}
	
	if( BedListinOrder4 !=null && !BedListinOrder4.equals("") )
	{
		BedListinOrder4 = specialCharacter(BedListinOrder4);
		if(BedListinOrder4.equals("specialty_short_desc"))
			sql.append("Am_Get_desc.Am_speciality(a.Specialty_Code,'"+locale+"','2') group4,");
		else if(BedListinOrder4.equals("bed_type_short_desc"))
			sql.append(" ip_Get_desc.Ip_bed_type(a.Bed_Type_Code,'"+locale+"','2') group4, ");
		else if(BedListinOrder4.equals("room_long_desc"))
			sql.append(" am_get_desc.am_facility_room (a.facility_id, a.room_no,'"+locale+"','1')group4,");
		else if(BedListinOrder4.equals("admission_type"))
			sql.append(" ip_get_desc.IP_ADMISSION_TYPE(c.admission_type,'"+locale+"', '2') group4, ");
	}	

	sql.append(" bkg_patient_id, booking_type,CASE WHEN c.admission_type IS NOT NULL THEN ip_get_desc.ip_admission_type (c.admission_type,'"+locale+"', '2'  ) WHEN c.admission_type IS NULL THEN (SELECT ip_get_desc.ip_admission_type (i.admission_type, '"+locale+"',  '2' ) admission_type FROM ip_open_encounter i  WHERE (i.facility_id, i.encounter_id) IN (  SELECT max(o.facility_id), max(o.encounter_id)  FROM ip_reserved_bed_dtl o WHERE o.facility_id = '"+facility_id+"' AND o.encounter_id = NVL (c.encounter_id, b.encounter_id))) END ADMISSION_TYPE, b.referral_id, pseudo_bed_yn, a.nursing_unit_code, c.pat_curr_locn_code, ");
	/*Added By Dharma on 04th Oct 2014 against HSA-CRF-0180 [IN:049539] Start*/
	/*Modified by Ashwini on 07-Jun-2019 for AMRI-SCF-0551*/
	sql.append(" c.facility_id,c.pat_curr_locn_type,DECODE(c.pat_curr_locn_type,'W', get_desc ('"+locale+"', 'rd_clinic_lang_vw', 'SHORT_DESC', 'CLINIC_CODE', c.pat_curr_locn_code),'O', get_desc ('"+locale+"', 'ot_oper_room_lang_vw', 'SHORT_DESC', 'OPER_ROOM_CODE', c.pat_curr_locn_code),0, get_desc ('"+locale+"', 'ot_holding_areas_lang_vw', 'HOLDING_AREA_DESC', 'HOLDING_AREA_CODE', c.pat_curr_locn_code),1, get_desc ('"+locale+"', 'ot_recovery_room_lang_vw', 'RECOVERY_ROOM_DESC', 'RECOVERY_ROOM_CODE', c.pat_curr_locn_code),'N',IP_GET_DESC.IP_NURSING_UNIT(c.facility_id,c.pat_curr_locn_code,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(c.facility_id,c.pat_curr_locn_code,'"+locale+"','2'), OP_GET_DESC.OP_CLINIC(c.facility_id,c.pat_curr_locn_code,'"+locale+"','1')) pat_curr_locn_desc,CASE WHEN C.PAT_CURR_LOCN_TYPE IN ('0','1') THEN 'OT' else AM_GET_DESC.AM_CARE_LOCN_TYPE(c.PAT_CURR_LOCN_TYPE,'"+locale+"' ,'2') end pat_curr_locn_type_desc,");	
	/*Added By Dharma on 04th Oct 2014 against HSA-CRF-0180 [IN:049539] End*/
	sql.append(" a.bed_no, a.main_bed_no, a.bed_no || decode( a.sex_spec_ind, null, '' ) bed_no_label,"); 
	sql.append(" a.bed_type_code, a.bed_class_code,");
	sql.append(" ip_Get_desc.Ip_nursing_unit(a.Facility_Id,a.nurSing_Unit_Code,'"+locale+"','2')");
	sql.append(" nursing_unit_short_desc, a.room_no, ");
	sql.append(" ip_Get_desc.Ip_bed_class(a.Bed_Class_Code,'"+locale+"','2') Bed_Class_Short_desc,");
	sql.append(" b.override_yn,");
	sql.append(" ip_Get_desc.Ip_bed_type(a.Bed_Type_Code,'"+locale+"','2')bed_type_short_desc, ");
	sql.append(" (CASE WHEN a.Specialty_Code IS NOT NULL  THEN (Am_Get_desc.Am_speciality(a.Specialty_Code,'"+locale+"','2')) ELSE '*All SPLTY*' END) specialty_short_desc, ");
	//sql.append(" a.specialty_code, NVL (a.occupying_patient_id, b.bkg_patient_id) patient_id, ");
	sql.append(" a.specialty_code, a.occupying_patient_id patient_id, ");
	//sql.append(" b.bkg_patient_id bkg_patient_id, ");
	sql.append(" nvl(c.encounter_id, b.encounter_id) encounter_id, ");
	/*sql.append(" nvl(d.patient_name, nvl(b.bkg_patient_name, b.patient_name)) patient_name, ");
	sql.append(" nvl(d.sex, b.bkg_gender) gender, d.nationality_code, e.appl_patient_class, ");*/
	sql.append(" d.patient_name patient_name , nvl(d.patient_name_loc_lang,d.patient_name) patient_name_loc_lang , nvl(b.bkg_patient_name, b.patient_name) bg_patient_name , nvl(b.patient_name_loc_lang,d.patient_name_loc_lang) bg_patient_name_loc_lang , ");
	sql.append(" d.sex gender,b.bkg_gender bkg_gender, d.nationality_code, e.appl_patient_class, ");
	sql.append(" mp_Get_desc.Mp_country(d.Nationality_Code,'"+locale+"','1') nationality_long_desc, ");
	//sql.append(" get_age(nvl(d.date_of_birth, b.bgk_date_of_birth)) age, ");
	sql.append(" get_age(d.date_of_birth) age,get_age(b.bgk_date_of_birth)bkg_age, ");
	/*
	sql.append(" to_char(c.admission_date_time, 'dd/mm/rrrr hh24:mi') admission_date_time, ") ;
	sql.append(" to_char(c.exp_discharge_date_time,'dd/mm/rrrr hh24:mi') exp_discharge_date_time, ");
	*/
	sql.append(" CASE WHEN c.admission_date_time IS NOT NULL THEN TO_CHAR (c.admission_date_time,'dd/mm/rrrr hh24:mi') WHEN c.admission_date_time IS NULL THEN (SELECT TO_CHAR (i.admission_date_time,'dd/mm/rrrr hh24:mi' ) FROM ip_open_encounter i  WHERE (i.facility_id, i.encounter_id) IN ( SELECT max(o.facility_id), max(o.encounter_id)  FROM ip_reserved_bed_dtl o  WHERE o.facility_id = '"+facility_id+"' AND o.encounter_id = NVL (c.encounter_id, b.encounter_id))) END admission_date_time, ") ;
	sql.append(" CASE WHEN c.exp_discharge_date_time IS NOT NULL THEN TO_CHAR (c.exp_discharge_date_time,'dd/mm/rrrr hh24:mi') WHEN c.exp_discharge_date_time IS NULL THEN (SELECT TO_CHAR (i.exp_discharge_date_time,'dd/mm/rrrr hh24:mi' ) FROM ip_open_encounter i  WHERE (i.facility_id, i.encounter_id) IN ( SELECT max(o.facility_id), max(o.encounter_id)  FROM ip_reserved_bed_dtl o  WHERE o.facility_id = '"+facility_id+"' AND o.encounter_id = NVL (c.encounter_id, b.encounter_id))) END exp_discharge_date_time, ") ;
	sql.append(" to_char(b.expected_discharge_date,'dd/mm/rrrr hh24:mi') bkg_exp_discharge_date_time, ");

	sql.append(" (case when a.occupied_until_date_time > sysdate then ROUND (TO_CHAR (a.occupied_until_date_time - SYSDATE)) end) exp_no_of_days, ");
	sql.append(" b.blocking_type_short_desc, ");
	sql.append(" b.exp_days_of_stay, ");
//	sql.append(" decode(nvl(a.occupying_patient_id,'X'),'X',nvl(b.booking_type,'N'),'O') bed_status,");
	sql.append(" ( CASE  ");
	sql.append(" WHEN a.occupying_patient_id IS NOT NULL THEN 'O' ");
	sql.append(" WHEN b.booking_type IS NULL THEN 'A' ");
	sql.append(" WHEN b.booking_type in ('N','B','L','T','D') THEN 'B' ");
	sql.append(" END ) bed_status, ");
	sql.append(" to_char(b.blocked_from, 'dd/mm/rrrr hh24:mi') blocked_from,");
	sql.append(" to_char(b.blocked_until,'dd/mm/rrrr hh24:mi') blocked_until,");
	/*sql.append(" Nvl(b.Practitioner_Name, ");
	sql.append(" Am_Get_desc.AM_PRACTITIONER(c.Attend_Practitioner_Id,'"+locale+"','1')) practitioner_name,");*/
	sql.append(" b.Practitioner_Name bkg_Practitioner_Name, ");
	sql.append(" Am_Get_desc.AM_PRACTITIONER(c.Attend_Practitioner_Id,'"+locale+"','1') practitioner_name,");
	sql.append(" b.bed_booking_ref_no, b.booking_date_time, b.blocking_type_code, b.blocking_remarks,");
	sql.append(" c.service_code service_code, ");
	sql.append(" Am_Get_desc.Am_service(c.Service_Code,'"+locale+"','2') service_desc, ");
	sql.append(" (CASE WHEN c.Service_Code IS NOT NULL  THEN (SELECT Ancillary_yn FROM Am_Service WHERE  Service_Code = c.Service_Code) END) Ancillary_yn,");
	sql.append("  null dly_charge, (CASE WHEN d.Pat_Cat_Code IS NOT NULL  THEN (mp_Get_desc.Mp_pat_category(d.Pat_Cat_Code,'"+locale+"','2')) END) Pat_Cat_Short_desc, ");
	sql.append(" oth_adt_status, a.psuedo_bed_status, a.main_bed_no, ");
	sql.append(" b.booking_status, b.booking_remarks, ");
	//sql.append(" am_get_desc.AM_COMPLAINT(c.CHIEF_COMPLAINT,'"+locale+"','1')admission_reason ");
	sql.append(" CASE WHEN c.CHIEF_COMPLAINT IS NOT NULL THEN am_get_desc.AM_COMPLAINT (c.CHIEF_COMPLAINT,'"+locale+"', '1'  ) WHEN c.CHIEF_COMPLAINT IS NULL THEN (SELECT am_get_desc.AM_COMPLAINT (i.CHIEF_COMPLAINT, '"+locale+"',  '1' ) admission_reason FROM ip_open_encounter i  WHERE (i.facility_id, i.encounter_id) IN (  SELECT max(o.facility_id), max(o.encounter_id)  FROM ip_reserved_bed_dtl o WHERE o.facility_id = '"+facility_id+"' AND o.encounter_id = NVL (c.encounter_id, b.encounter_id))) END admission_reason ");
	sql.append(" , am_get_desc.AM_COMPLAINT(b.CHIEF_COMPLAINT,'"+locale+"','1')booking_reason  ");
	/*Thursday, April 22, 2010 , added for performance tuining*/
	if(bl_operational.equals("Y"))
	{
		sql.append(",(SELECT bl.short_desc financial_classification FROM bl_episode_fin_dtls a, bl_blng_grp_lang_vw bl WHERE bl.language_id = '"+locale+"' and a.blng_grp_id = bl.blng_grp_id  AND a.operating_facility_id = c.facility_id AND a.episode_id = c.encounter_id AND a.patient_id = c.patient_id) financial_classification ");
		/*Friday, June 25, 2010 , added to get financial details for IP Booking*/
		sql.append(",(SELECT bl.short_desc financial_classification FROM bl_booking_fin_dtls a,  bl_blng_grp bl WHERE a.blng_grp_id = bl.blng_grp_id AND a.operating_facility_id = b.facility_id AND a.appt_book_ref_num = b.bed_booking_ref_no and b.booking_type = 'L')bkg_financial_classification  ");
	}
	/*Added By Dharma on 18th Nov 2014 against HSA-CRF-0180 [IN:049539] Start*/
	sql.append(",(SELECT am_get_desc.am_contact_reason (movement_reason_code,  '"+locale+"',  '1' ) FROM pr_patient_movement WHERE patient_id = c.patient_id  AND to_locn_code = c.pat_curr_locn_code  AND to_locn_type = c.pat_curr_locn_type  AND movement_type = 'D'  AND srl_no IN ( SELECT MAX (to_number(srl_no)) FROM pr_patient_movement WHERE patient_id = c.patient_id  AND to_locn_code = c.pat_curr_locn_code  AND to_locn_type = c.pat_curr_locn_type  AND movement_type = 'D')) movement_reason ");
	/*Added By Dharma on 18th Nov 2014 against HSA-CRF-0180 [IN:049539] End*/

	/**/
	// Building of where clause which is common for both queries
	where_clause.append(" FROM ");
	where_clause.append(" IP_NURSING_UNIT_BED a ");
	where_clause.append(" ,IP_OPEN_ENCOUNTER c ");
	where_clause.append(" ,MP_PATIENT d ");
	where_clause.append(" ,IP_NURSING_UNIT e ");
	where_clause.append(" , ip_param f ");

	if ( privacy_level !=null && !privacy_level.equals(""))
	{
		where_clause.append(" ,AM_FACILITY_ROOM fcty_room ");
	}

	if(!call_func.equals("QUERY_BED_AVAIL")) 			
		where_clause.append(" ,AM_OS_USER_LOCN_ACCESS_VW oper_restrn ");

	where_clause.append(" ,(select ");
	where_clause.append(" bkglst.exp_days_of_stay, bkg.override_yn, Nvl(bkglst.Patient_Name,Pat.Patient_Name) Patient_Name, Nvl(bkglst.patient_name_loc_lang,Pat.patient_name_loc_lang) patient_name_loc_lang,bkg.encounter_id, bkg.facility_id, bkg.booking_type, bkg.bed_booking_ref_no,");
	where_clause.append(" bkg.req_nursing_unit_code, bkg.req_bed_no,");
	where_clause.append(" bkg.blocking_type_code,"); 
	where_clause.append(" ip_Get_desc.Ip_blocking_type(bkg.BlockIng_Type_Code,'"+locale+"','2') BlockIng_Type_Short_desc,");
	where_clause.append(" bkg.blocking_remarks,");
	where_clause.append(" bkg.blocked_from_date_time blocked_from,"); 
	where_clause.append(" bkg.blocked_until_date_time blocked_until,");
	where_clause.append(" nvl(bkglst.patient_id , bkg.patient_id) bkg_patient_id,");
	where_clause.append(" decode(bkglst.patient_id, null , pat.patient_name, bkglst.patient_name) bkg_patient_name,"); 
	where_clause.append(" NVL (bkglst.gender, pat.sex) bkg_gender,");
	where_clause.append(" bkglst.referral_id,");
	where_clause.append(" Nvl(bkglst.Date_Of_Birth,Pat.Date_Of_Birth) bgk_Date_Of_Birth,");
	where_clause.append(" NVL(bkglst.expected_discharge_date,bkg.blocked_until_date_time) expected_discharge_date, ");
	where_clause.append(" (CASE WHEN bkglst.Practitioner_Id IS NULL  THEN (Am_Get_desc.Am_practitioner(bkg.req_Practitioner_Id,'"+locale+"','1')) ELSE (Am_Get_desc.Am_practitioner(bkglst.Practitioner_Id,'"+locale+"','1')) END) Practitioner_Name, ");
	where_clause.append(" to_char(bkglst.booking_date_time,'dd/mm/rrrr hh24:mi') booking_date_time,");
	where_clause.append(" nvl(bkglst.booking_status,bkg.booking_status)booking_status, bkglst.booking_remarks,bkg.patient_id,bkglst.chief_complaint  ");
	where_clause.append(" FROM ");
	where_clause.append(" IP_BED_BOOKING bkg,");
	where_clause.append(" IP_BOOKING_LIST bkglst,");
	where_clause.append(" MP_PATIENT pat ");
	
	where_clause.append(" WHERE ");
	
	if(search_by_beds.equals("R"))
		where_clause.append(" bkg.booking_status='1' ");
	else 
		where_clause.append(" bkg.booking_status in ('0','1') ");

	if(bed_available_date_yn.equals("Y"))
	{
		// Modified by Muthu on 17/03/2010 for WalkThrough Issue - Reserved bed should be shown as reserved in bed chart if the from date entered in bed avilable date is less than EDD. 
		where_clause.append(" AND ( blocked_from_date_time BETWEEN TO_DATE('"+from_date+"','DD/MM/YYYY HH24:MI') AND TO_DATE('"+to_date+"','DD/MM/YYYY HH24:MI') OR blocked_until_date_time BETWEEN TO_DATE('"+from_date+"','DD/MM/YYYY HH24:MI') AND TO_DATE('"+to_date+"','DD/MM/YYYY HH24:MI') OR ( blocked_from_date_time <= TO_DATE('"+from_date+"','DD/MM/YYYY HH24:MI') and blocked_until_date_time >= TO_DATE('"+to_date+"','DD/MM/YYYY HH24:MI') ) OR blocked_until_date_time is null ) ");
		// End of comment
	}
	else
	{
		where_clause.append(" and sysdate between blocked_from_date_time and nvl(blocked_until_date_time,to_date('01/01/9999','dd/mm/yyyy')) ");
	}
	
	if(call_function!=null && call_function.equals("IP_Booking"))
	{
		//where_clause.append(" AND  0=(CASE WHEN (select Count(*) from ip_bed_booking where booking_status  in ('0','1')  and facility_id = bkg.facility_id and req_nursing_unit_code = bkg.req_nursing_unit_code and req_bed_no = bkg.req_bed_no AND blocked_from_date_time > SYSDATE AND (blocked_from_date_time BETWEEN TO_DATE('"+from_date+"', 'DD/MM/YYYY HH24:MI') AND TO_DATE('"+to_date+"', 'DD/MM/YYYY HH24:MI') OR blocked_until_date_time BETWEEN TO_DATE('"+from_date+"', 'DD/MM/YYYY HH24:MI') AND TO_DATE('"+to_date+"', 'DD/MM/YYYY HH24:MI')))=0 THEN 0 ELSE 1 END)");

		//where_clause.append(" AND  0=(CASE WHEN (select Count(*) from ip_bed_booking where booking_status  in ('0','1')  and facility_id = bkg.facility_id and req_nursing_unit_code = bkg.req_nursing_unit_code and req_bed_no = bkg.req_bed_no AND blocked_from_date_time > SYSDATE AND (  (TO_DATE('"+from_date+"', 'DD/MM/YYYY HH24:MI') <=blocked_from_date_time AND TO_DATE('"+to_date+"', 'DD/MM/YYYY HH24:MI') <= BLOCKED_UNTIL_DATE_TIME ) OR (TO_DATE('"+from_date+"', 'DD/MM/YYYY HH24:MI') >= BLOCKED_FROM_DATE_TIME AND TO_DATE('"+to_date+"', 'DD/MM/YYYY HH24:MI') <=BLOCKED_UNTIL_DATE_TIME) or (TO_DATE('"+from_date+"', 'DD/MM/YYYY HH24:MI') >= BLOCKED_FROM_DATE_TIME AND   TO_DATE('"+to_date+"', 'DD/MM/YYYY HH24:MI')  >= BLOCKED_UNTIL_DATE_TIME)))=0 THEN 0 ELSE 1 END)");
	}

	where_clause.append(" and bkg.booking_date_time=(select max (booking_date_time) ");
	where_clause.append(" from IP_BED_BOOKING where facility_id = bkg.facility_id ");
	where_clause.append(" and req_nursing_unit_code = bkg.req_nursing_unit_code ");
	where_clause.append(" and req_bed_no = bkg.req_bed_no ");
	if(search_by_beds.equals("R"))
		where_clause.append(" and booking_status = '1' ");
	else 
		where_clause.append(" and booking_status in ('0','1') ");

	///*SCR 4020 FDPMG20089CRF0119IP 
	if(bed_available_date_yn.equals("Y"))
	{
		// Modified by Muthu on 17/03/2010 for WalkThrough Issue - Reserved bed should be shown as reserved in bed chart if the from date entered in bed avilable date is less than EDD. 

		where_clause.append(" AND ( blocked_from_date_time BETWEEN TO_DATE('"+from_date+"','DD/MM/YYYY HH24:MI') AND TO_DATE('"+to_date+"','DD/MM/YYYY HH24:MI') OR blocked_until_date_time BETWEEN TO_DATE('"+from_date+"','DD/MM/YYYY HH24:MI') AND TO_DATE('"+to_date+"','DD/MM/YYYY HH24:MI') OR ( blocked_from_date_time <= TO_DATE('"+from_date+"','DD/MM/YYYY HH24:MI') and blocked_until_date_time >= TO_DATE('"+to_date+"','DD/MM/YYYY HH24:MI') ) OR blocked_until_date_time is null ) ");

		//where_clause.append("AND (booking_type = 'N' and blocked_until_date_time >= TO_DATE ('"+from_date+"','DD/MM/YYYY HH24:MI')  or (booking_type != 'N' and not exists(select 1 FROM ip_bed_booking WHERE facility_id = bkg.facility_id AND req_nursing_unit_code = bkg.req_nursing_unit_code AND req_bed_no = bkg.req_bed_no AND booking_status IN ('0', '1') AND ( blocked_from_date_time BETWEEN TO_DATE ('"+from_date+"','DD/MM/YYYY HH24:MI') AND TO_DATE ('"+to_date+"','DD/MM/YYYY HH24:MI') OR blocked_until_date_time      BETWEEN TO_DATE ('"+from_date+"','DD/MM/YYYY HH24:MI') AND TO_DATE ('"+to_date+"', 'DD/MM/YYYY HH24:MI') OR (    blocked_from_date_time <= TO_DATE ('"+from_date+"','DD/MM/YYYY HH24:MI') AND blocked_until_date_time >= TO_DATE ('"+to_date+"','DD/MM/YYYY HH24:MI')) OR blocked_until_date_time IS NULL) AND booking_type = 'N' and blocked_until_date_time >= TO_DATE ('"+from_date+"','DD/MM/YYYY HH24:MI'))))");			
		
		where_clause.append("AND (booking_type = 'N' or (booking_type != 'N' and not exists(select 1 FROM ip_bed_booking WHERE facility_id = bkg.facility_id AND req_nursing_unit_code = bkg.req_nursing_unit_code AND req_bed_no = bkg.req_bed_no AND booking_status IN ('0', '1') AND ( blocked_from_date_time BETWEEN TO_DATE ('"+from_date+"','DD/MM/YYYY HH24:MI') AND TO_DATE ('"+to_date+"','DD/MM/YYYY HH24:MI') OR blocked_until_date_time      BETWEEN TO_DATE ('"+from_date+"','DD/MM/YYYY HH24:MI') AND TO_DATE ('"+to_date+"', 'DD/MM/YYYY HH24:MI') OR (    blocked_from_date_time <= TO_DATE ('"+from_date+"','DD/MM/YYYY HH24:MI') AND blocked_until_date_time >= TO_DATE ('"+to_date+"','DD/MM/YYYY HH24:MI')) OR blocked_until_date_time IS NULL) AND booking_type = 'N')))");	
		// End of Comment
		where_clause.append(" ) "); 
	}
	else
	{
		where_clause.append(" and sysdate between blocked_from_date_time and nvl(blocked_until_date_time,to_date('01/01/9999','dd/mm/yyyy'))) ");
		//where_clause.append(" ) "); 
	}
	//*/
	
	where_clause.append(" and bkglst.facility_id(+) = bkg.facility_id ");
	where_clause.append(" and bkglst.bkg_lst_ref_no(+) = bkg.bed_booking_ref_no ");
	/*
	if(search_by_beds.equals("R"))
	{
		where_clause.append(" and pat.patient_id(+) = bkg.patient_id ) b ");
	}
	else
	{
		where_clause.append(" and pat.patient_id(+) = bkglst.patient_id ) b ");
		
	}
	*/

	where_clause.append(" and pat.patient_id(+) = bkg.patient_id ) b ");
	where_clause.append(" WHERE ") ;
	where_clause.append(" a.nursing_unit_code = e.nursing_unit_code ");
	if(nursing_unit_code !=null && nursing_unit_code != "")
	{
		where_clause.append(" and a.nursing_unit_code='"+nursing_unit_code+"' ") ;
	}

	where_clause.append("  AND a.bed_no LIKE '%%' ");
    where_clause.append(" and a.facility_id = '"+ facility_id +"' ");
	where_clause.append(" and a.eff_status = 'E' ");
	where_clause.append(" and e.eff_status = 'E' ");

	/// Added by Sridhar R on 15 SEP 2004
	/// This Condition will chk for the status fron IP_param & filter the beds based on th setup..
	if(search_by_beds.equals("R"))
	{
		where_clause.append(" and b.booking_type ='N' ");
		
		if(deactivate_pseudoBed.equals("Y") && bed_classification.equalsIgnoreCase("P"))
		where_clause.append(" and PSUEDO_BED_STATUS = 'U' ");

		if(!call_function.equals("NEW_BORN_REGN") &&
		!call_function.equals("Transfer_Patient") && !bed_classification.equalsIgnoreCase("BB") && !bed_classification.equalsIgnoreCase("B"))
		{
			where_clause.append(" and a.MAIN_BED_NO is null ");
		}
		else if(!main_bed_no.equals(""))
		{
			where_clause.append(" and a.MAIN_BED_NO = '"+main_bed_no+"' ");
		}
		//where_clause.append(" and blocked_until is null ");
		//Modified for IP-ICN-6903_Reopen
		where_clause.append(" and (blocked_until is null or blocked_until > sysdate) ");
	}
	else if (search_by_beds.equals("B"))
	{
		where_clause.append(" and (decode(nvl(c.patient_id,'X'), 'X', nvl(b.booking_type,'A'), 'O' ) in ('O','B','L','T','D') and nvl(b.override_yn,'N') in ('N','Y')) ");

		if(deactivate_pseudoBed.equals("Y") && bed_classification.equalsIgnoreCase("P"))
		where_clause.append(" and psuedo_bed_status = 'U' ");

		if(!call_function.equals("NEW_BORN_REGN") &&
		!call_function.equals("Transfer_Patient") && !bed_classification.equalsIgnoreCase("BB") && !bed_classification.equalsIgnoreCase("B"))
		{
			where_clause.append(" and a.main_bed_no is null ");
		}
		else if(!main_bed_no.equals(""))
		{
			where_clause.append(" and a.main_bed_no = '"+main_bed_no+"' ");
		}
		where_clause.append(" and b.booking_status IS NOT null ");
	}
	else if (search_by_beds.equals("V"))
	{
		
		where_clause.append(" and (decode(nvl(a.occupying_patient_id,'X'), 'X', nvl(b.booking_type,'A'), 'O' ) in ('A','B','L','T') and nvl(b.override_yn,'Y')='Y') ");
		
		if(deactivate_pseudoBed.equals("Y") && bed_classification.equalsIgnoreCase("P"))
		where_clause.append(" and PSUEDO_BED_STATUS = 'N' ");
		
		if(!call_function.equals("NEW_BORN_REGN") && !call_function.equals("Transfer_Patient") && !bed_classification.equalsIgnoreCase("BB") && !bed_classification.equalsIgnoreCase("B"))
		{
			where_clause.append(" and a.MAIN_BED_NO is null ");
		}
		else if(!main_bed_no.equals(""))
		{
			where_clause.append(" and a.MAIN_BED_NO = '"+main_bed_no+"' ");
		}
		//s_beds=search_by_beds;
	}
	else if(search_by_beds.equals("O"))
	{
		where_clause.append(" and (CASE WHEN a.occupying_patient_id IS NOT NULL THEN 'O' WHEN b.booking_type IS NULL THEN 'A' WHEN b.booking_type ='N' THEN NULL END ) in ('O','B','L','T','D') ");

		if(deactivate_pseudoBed.equals("Y") && bed_classification.equalsIgnoreCase("P"))
			where_clause.append(" and psuedo_bed_status = 'U' ");

		if(!call_function.equals("NEW_BORN_REGN") &&
		!call_function.equals("Transfer_Patient") && !bed_classification.equalsIgnoreCase("BB") && !bed_classification.equalsIgnoreCase("B"))
		{
			where_clause.append(" and a.main_bed_no is null ");
		}
		else if(!main_bed_no.equals(""))
		{
			where_clause.append(" and a.main_bed_no = '"+main_bed_no+"' ");
		}
	}
	else if(search_by_beds.equals(""))
	{
		if(bed_classification.equalsIgnoreCase("P") && deactivate_pseudoBed.equals("Y"))
			where_clause.append(" and psuedo_bed_status != 'C' ");
		else if(bed_classification.equalsIgnoreCase("BB") && deactivate_pseudoBed.equals("Y"))
			where_clause.append(" and a.main_bed_no is not null ");

		if(!call_function.equals("NEW_BORN_REGN") && !bed_classification.equalsIgnoreCase("BB") && !bed_classification.equalsIgnoreCase("B"))
		{
			where_clause.append(" and a.main_bed_no is null ");
		}
		else if(!main_bed_no.equals(""))
		{
			where_clause.append(" and a.main_bed_no = '"+main_bed_no+"' ");
		}
	}
	
	/// End of addition by Sridhar R 
/*	if(nursing_unit_code !=null && nursing_unit_code != "")
	{
		where_clause.append(" and a.nursing_unit_code='"+nursing_unit_code+"' ") ;
	} */

	if(!pracitioner_id.equals(""))
	{
		where_clause.append(" and exists ( select '1' from IP_NURSING_UNIT_FOR_PRACT b where facility_id = '"+facility_id+"'  ");
		where_clause.append("  and b.nursing_unit_code = a.nursing_unit_code and b.practitioner_id = '"+ pracitioner_id +"' ");
		where_clause.append("  and b.practitioner_id = c.attend_practitioner_id ) ");
	}

	if(!speciality_code.equals(""))
	{
		/*
			where_clause.append(" and ( a.specialty_code = '"+ speciality_code +"' ");
			if(nursing_unit_code !=null && nursing_unit_code != "")
			{
				where_clause.append(" or a.specialty_code is null ");
			}
			where_clause.append(" and exists (select 1 from ip_nurs_unit_for_specialty where facility_id = a.facility_id and nursing_unit_code = a.nursing_unit_code and specialty_code = '"+speciality_code+"'))"); 
		*/
		
		where_clause.append(" AND ( a.specialty_code = '"+speciality_code+"' OR ( a.specialty_code IS null AND exists ( SELECT 1 FROM IP_NURS_UNIT_FOR_SPECIALTY WHERE facility_id = a.facility_id AND nursing_unit_code = a.nursing_unit_code AND specialty_code = '"+speciality_code+"' ) ) ) ");
	}

	if((!bed_class_code.equals("")) ||(!bed_type_code.equals("")))
	{
		where_clause.append(" and exists ( select '1' from ip_nursing_unit_bed d where d.facility_id = '"+ facility_id +"'  ");
		where_clause.append(" and d.nursing_unit_code = a.nursing_unit_code  ");
		where_clause.append(" and d.bed_class_code = nvl( '"+bed_class_code+"', bed_class_code ) ");
		where_clause.append(" and d.bed_type_code = nvl( '"+bed_type_code+"', bed_type_code ) and rownum<2 ) ");
	}
	if ( !gender1.equals("") || !age_value.equals("") )
	{
		where_clause.append(" and  (( e.age_group_code is null ) or   ((e.age_group_code is not null ) and  ");
		where_clause.append(" exists ( select age_group_code from am_age_group  ");
		where_clause.append(" where age_group_code = e.age_group_code  ");
		if( !gender1. equals("") )
		{
			where_clause.append(" and nvl( gender, '"+ gender1 +"' ) = '"+ gender1 +"' ") ;
		}
		if( !age_value.equals("") )
		{
			where_clause.append(" and decode('"+AGE+"', 'Y', 365, 'M', 30, 1 ) * "+ age_value + "  ");
			where_clause.append(" between decode ( age_unit, 'Y', 365, 'M', 30, 1 ) * min_age and decode( age_unit, 'Y', 365, 'M', 30, 1 ) * max_age "); 
		}
		where_clause.append("))) ") ;
	}
	if ( bed_class_code !=null && bed_class_code != "")
	{
		bed_class_code = specialCharacter(bed_class_code);
		where_clause.append(" and a.bed_class_code = '"+ bed_class_code +"'  ");
	}

	if( bed_type_code !=null && bed_type_code != "" && bed_type_code.length()!=0 )
	{
		bed_type_code = specialCharacter(bed_type_code);
		where_clause.append(" and a.bed_type_code = '"+ bed_type_code +"'  ");
	}

	where_clause.append(" AND b.facility_id(+) = a.facility_id ");
	where_clause.append(" AND b.req_nursing_unit_code (+) = a.nursing_unit_code ");
	where_clause.append(" AND b.req_bed_no(+) = a.bed_no  "); 
	where_clause.append(" AND a.Facility_Id = e.Facility_Id "); 
	where_clause.append(" AND a.Facility_Id = c.Facility_Id (+) "); 
	where_clause.append(" AND a.OccupyIng_Patient_Id = c.Patient_Id (+) "); 
	where_clause.append(" AND a.OccupyIng_Patient_Id = d.Patient_Id (+) "); 
//	where_clause.append(" AND a.nursing_unit_code = e.nursing_unit_code "); 

	if (gender1!=null && !gender1.equals(""))
	{
		gender1 = specialCharacter(gender1);
		if(query_gender_type.equalsIgnoreCase("1"))
			where_clause.append(" and nvl(d.sex, b.bkg_gender) = '"+gender1+"' ");
		else if(query_gender_type.equalsIgnoreCase("2"))
			where_clause.append(" and a.sex_spec_ind = '"+gender1+"' ");
	}	
	
	if ( privacy_level !=null && !privacy_level.equals(""))
	{
		privacy_level = specialCharacter(privacy_level);
		where_clause.append(" and fcty_room.privacy_level(+) = '"+ privacy_level +"' ") ; 
		where_clause.append(" and fcty_room.operating_facility_id = a.facility_id "); 
		where_clause.append(" and fcty_room.room_num(+) = a.room_no ") ; 
	}

	//Operator Restriction added for displaying in the result
	if(!call_func.equals("QUERY_BED_AVAIL")) 
	{
		where_clause.append(" and a.facility_id = oper_restrn.facility_id ");
		where_clause.append(" and a.nursing_unit_code = oper_restrn.locn_code ");
		where_clause.append(" and oper_restrn.locn_type = 'N' ");
		where_clause.append(" and oper_restrn.oper_stn_id = '"+oper_stn_id+"' ");
		where_clause.append(" and oper_restrn.appl_user_id = '"+loginUser+"' ");
	}

	if(!call_func.equals("QUERY_BED_AVAIL")) 
		where_clause.append(" and ");

	if(wherecondn.equals(""))
	{
		where_clause.append(" ");
	}
	
	else if(wherecondn.equals("CREATE_BOOKING_YN"))
	{
		where_clause.append(" (oper_restrn.create_booking_yn = 'Y' or oper_restrn.create_booking_with_conf_yn = 'Y') and e.appl_patient_class = 'IP' ");
	}
	else if(wherecondn.equals("ASSIGN_BED_YN"))
	{
		where_clause.append(" oper_restrn.assign_bed_yn ='Y' and e.appl_patient_class = '");
		where_clause.append(patient_class);
		where_clause.append("' ");
	}/*Wednesday, March 03, 2010 ,IN019731 , to filter nursing unit if change nursing unit in assign bed is unchecked in AM->operator station restriction function*/
	else if(wherecondn.equals("CHG_NURS_UNIT_IN_ASSIGN_BED_YN"))
	{
		where_clause.append(" oper_restrn.assign_bed_yn ='Y' and e.appl_patient_class = '");
		where_clause.append(patient_class);
		where_clause.append("' ");
		where_clause.append("and oper_restrn.chg_nurs_unit_in_assign_bed_yn ='Y' ");
	}
	else if(wherecondn.equals("ADMIT_PAT_YN") && !patient_class.equals(""))
	{
		where_clause.append(" oper_restrn.admit_pat_yn ='Y' and e.appl_patient_class = '");
		where_clause.append(patient_class);
		where_clause.append("' ");
		/*Wednesday, March 03, 2010 ,IN019731 , to filter nursing unit if admit patient with bed is unchecked in AM->operator station restriction function*/
		where_clause.append("and oper_restrn.admit_patient_with_bed_yn ='Y' ");
	}
	else
		where_clause.append(" oper_restrn."+wherecondn+" = 'Y' ");

	if(release_hrs!="")
	{
		where_clause.append(" and decode(a.current_status,'O', nvl(a.occupied_until_date_time,sysdate+30)-("+release_hrs+"/24),decode(nvl(override_yn,'Y'),'N',nvl(b.blocked_until,sysdate-100)-("+release_hrs+"/24),sysdate-100)) < sysdate ");
	}
	
	// ADDED ON O2/07/2002 
	if(bed_classification!=null && bed_classification.equalsIgnoreCase("P"))
		where_clause.append(" and a.pseudo_bed_yn = 'Y' and a.main_bed_no is null ") ;
	else if(bed_classification!=null && bed_classification.equalsIgnoreCase("N"))
		where_clause.append(" and a.pseudo_bed_yn = 'N' ");
	if( bed_classification != null && (!bed_classification.equals("N")) && (wherecondn.equals("CREATE_BOOKING_YN") || wherecondn.equals("REVISE_BOOKING_YN")))
	{
		where_clause.append(" and a.pseudo_bed_yn != 'Y' ");
	}
	
	// for bed classification
	if( bed_classification != null && bed_classification.equalsIgnoreCase("BB"))
		where_clause.append(" and a.pseudo_bed_yn = 'Y' and a.main_bed_no is not null ") ;

	/// Added by Sridhar R on 1 Sep 2004 ..
	/// The query will be fetched based on Room No
	if ( room_no_code !=null && !room_no_code.equals(""))
	{	
		where_clause.append(" and a.room_no='"+room_no_code+"' ") ;
	}
	if(deactivate_pseudoBed.equalsIgnoreCase("Y"))                  
	{
		where_clause.append(" and a.psuedo_bed_status != 'C'");
	}

	String curdate = "";
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy hh:mm" );
	java.util.Date dt=new java.util.Date();
	curdate = dateFormat.format( dt ) ;
	if(bed_available_date_yn.equals("Y"))
	{
		if(from_date.equals(curdate) && to_date.equals(curdate))
			where_clause.append(" and a.occupying_patient_id IS NULL ");

		/*where_clause.append(" AND ( ");
		where_clause.append("		( nvl(c.exp_discharge_date_time,b.expected_discharge_date) < to_date('"+from_date+"','DD/MM/YYYY HH24:MI') ");
		where_clause.append("		OR ");
		where_clause.append("	 trunc(nvl(c.exp_discharge_date_time,b.expected_discharge_date)) is null ");
		where_clause.append("		)");
		where_clause.append("	  )");*/
	}

	int max_count = 0;
	/*
	String sqlCount = " Select count(1) "+where_clause.toString();
	
	pstmt = con.prepareStatement(sqlCount);
	rs = pstmt.executeQuery();
	if(rs.next())
	{
		max_count = rs.getInt(1);
	}
	*/

	//where_clause.append(" and a.facility_id = f.facility_id AND a.bed_no like '%%' ");
where_clause.append(" and a.facility_id = f.facility_id ");
	/*
	if(bed_available_date_yn.equals("Y"))
	{
		where_clause.append("      AND NOT EXISTS (SELECT 'X' FROM ip_reserved_bed_dtl z WHERE a.bed_no = z.reserved_bed_no and a.nursing_unit_code = z.reserved_nursing_unit_code AND z.reserved_to_time IS NULL ) ");
	}
	*/

	where_clause.append(" order by ");

	if(BedListinOrder1 !=null && !BedListinOrder1.equals(""))
	{
		where_clause.append(" nursing_unit_short_desc,  ");
		where_clause.append(" group1, ");
	}

	if(BedListinOrder2 !=null &&  !BedListinOrder2.equals(""))
		where_clause.append(" group2, ");

	if (BedListinOrder3 !=null &&  !BedListinOrder3.equals(""))
		where_clause.append(" group3, ");

	if (BedListinOrder4 !=null &&  !BedListinOrder4.equals(""))
		where_clause.append(" group4, ");

		where_clause.append(" bed_no ");

	sql.append(where_clause.toString());
	/*
	if(max_count == 0)
	{	*/%>
		<!--<script> 
			resetValues(); 
			alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common')); 
		</script>-->
<%	/*}
	else
	{*/
		stmt = con.createStatement() ;
		rs	= stmt.executeQuery(sql.toString()) ;
		int count_buttn = 0 ;
		StringBuffer TableStr = new StringBuffer();

		TableStr.append(" <table cellspacing=0 cellpadding=0 align=left border=0 width='10%'><tr> ");

		if( rs != null )
		{	
			TableStr.append( "<form name = query_form>");
			String nursingunitcode	= "";
			while(rs.next())
			{
				isPatientOccupiedDeparted	= "N";

				if(!nursingunitcode.equals(rs.getString("nursing_unit_code")))
				{
					String p_pseudo_bed_yn = "";
					nursingunitcode = rs.getString("nursing_unit_code");
					if((wherecondn.equalsIgnoreCase("CREATE_BOOKING_YN") || wherecondn.equalsIgnoreCase("REVISE_BOOKING_YN")))
					{
						p_pseudo_bed_yn="N";
					}
					else
					{
						if (bed_classification.equals("N"))
						{
							p_pseudo_bed_yn="N";
						}
						else if (bed_classification.equals("P") || bed_classification.equals("BB") )
						{
							p_pseudo_bed_yn="Y";
						}
						else if (bed_classification.equals("B"))
						{
							p_pseudo_bed_yn = "X" ;
						}
					}			
					String nororpseudo	= "";
					String deactpseudo	= "";
					String sqlCnt		= "";
					String sqlCnt1		= "";

					//sqlCnt = " SELECT sum(d.num_of_beds) total, sum(d.num_of_beds_occupied) occupied, sum(blocked_count) blocked_count, sum(non_overridable_count) non_overridable_count FROM IP_NURSING_UNIT a, ( SELECT COUNT(DISTINCT req_bed_no) non_overridable_count FROM IP_BED_BOOKING_VW WHERE booking_status in ('0','1') AND override_yn = 'N' AND SYSDATE BETWEEN blocked_from_date_time AND nvl(blocked_until_date_time,to_date('01/01/9999','dd/mm/yyyy')) AND facility_id='"+facility_id+"' AND req_nursing_unit_code='"+nursingunitcode+"') b, (SELECT COUNT(DISTINCT req_bed_no) blocked_count FROM IP_BED_BOOKING_VW WHERE booking_status in('0','1')  AND facility_id='"+facility_id+"' AND REQ_nursing_unit_code='"+nursingunitcode+"' AND SYSDATE BETWEEN blocked_from_date_time AND nvl(blocked_until_date_time,to_date('01/01/9999','dd/mm/yyyy') ) ) c, (SELECT COUNT(g.bed_no) num_of_beds,SUM(DECODE(LTRIM(RTRIM(g.patient_id)),NULL,0,1)) num_of_beds_occupied FROM IP_NURSING_UNIT_BED_LOOKUP_VW g WHERE g.facility_id ='"+facility_id+"' AND g.nursing_unit_code='"+nursingunitcode+"' AND g.pseudo_bed_yn = decode('"+p_pseudo_bed_yn+"','X',g.pseudo_bed_yn,'"+p_pseudo_bed_yn+"') AND g.eff_status = 'E' ";
					sqlCnt = "select * from  (SELECT COUNT (DISTINCT req_bed_no) blocked_count,  COUNT (DISTINCT (case when override_yn = 'N' then req_bed_no end)) non_overridable_count FROM ip_bed_booking WHERE booking_status IN ('0', '1')  AND facility_id = ?  AND req_nursing_unit_code = ?  AND SYSDATE BETWEEN blocked_from_date_time  AND NVL (blocked_until_date_time, SYSDATE+1)) b,  (SELECT COUNT (g.bed_no) total,  COUNT (g.occupying_patient_id) occupied  FROM ip_nursing_unit_bed g  WHERE g.facility_id = ? AND g.nursing_unit_code = ?   AND g.pseudo_bed_yn = DECODE (?, 'X', g.pseudo_bed_yn, ?)  AND g.eff_status = 'E'  ";
					
					if(deactivate_pseudoBed.equalsIgnoreCase("Y"))                  
					{
						deactpseudo= "and g.PSUEDO_BED_STATUS != 'C'";
						sqlCnt = sqlCnt + deactpseudo;
					}
					if(bed_classification.equalsIgnoreCase("P"))
					{
							nororpseudo="and g.MAIN_BED_NO is null";
							sqlCnt = sqlCnt + nororpseudo ;
					}
					if(bed_classification.equalsIgnoreCase("BB"))
					{
						nororpseudo="and g.MAIN_BED_NO is not null";
						sqlCnt = sqlCnt + nororpseudo ;
					}

					sqlCnt1 = ") d ";

					sqlCnt = sqlCnt + sqlCnt1;

				/*	else if(!speciality_code.equals(""))
					{
						sqlCnt = " SELECT AM_GET_DESC.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"','1') SPECIALITY_DESC, sum(d.num_of_beds) total, sum(d.num_of_beds_occupied) occupied, sum(blocked_count) blocked_count, sum(non_overridable_count) non_overridable_count FROM IP_NURS_UNIT_FOR_SPECIALTY a, ( SELECT COUNT(DISTINCT req_bed_no) non_overridable_count FROM IP_BED_BOOKING WHERE booking_status='0' AND override_yn='N' AND SYSDATE BETWEEN blocked_from_date_time AND blocked_until_date_time AND facility_id='"+facility_id+"' AND REQ_SPECIALTY_CODE='"+speciality_code+"') b, (SELECT COUNT(DISTINCT req_bed_no) blocked_count FROM IP_BED_BOOKING WHERE booking_status='0' AND facility_id='"+facility_id+"' AND REQ_SPECIALTY_CODE='"+speciality_code+"' AND SYSDATE BETWEEN blocked_from_date_time AND blocked_until_date_time) c, (SELECT COUNT(g.bed_no) num_of_beds, SUM(DECODE(LTRIM(RTRIM(g.patient_id)),NULL,0,1)) num_of_beds_occupied FROM IP_NURSING_UNIT_BED_LOOKUP_VW g WHERE g.facility_id ='"+facility_id+"' AND g.SPECIALTY_CODE='"+speciality_code+"' AND g.pseudo_bed_yn=DECODE('N','X',g.pseudo_bed_yn,'N') AND g.EFF_STATUS='E' "; 
						if(deactivate_pseudoBed.equalsIgnoreCase("Y"))                  
						{
							deactpseudo= "and g.PSUEDO_BED_STATUS != 'C'";
							sqlCnt = sqlCnt + deactpseudo;
						}
						if(bed_classification.equalsIgnoreCase("P"))
						{
							nororpseudo="and g.MAIN_BED_NO is null";
							sqlCnt = sqlCnt + nororpseudo ;
						}
						if(bed_classification.equalsIgnoreCase("BB"))
						{
							nororpseudo="and g.MAIN_BED_NO is not null";
							sqlCnt = sqlCnt + nororpseudo ;
						}
						sqlCnt1 = ") d WHERE A.facility_id='"+facility_id+"' AND A.SPECIALTY_CODE='"+speciality_code+"' group by a.SPECIALTY_CODE ";
						sqlCnt = sqlCnt + sqlCnt1;
					}
*/		
					/*stmt_cnt = con.createStatement();
					rs_cnt = stmt_cnt.executeQuery( sqlCnt );*/
					pstmt	= con.prepareStatement(sqlCnt);
					pstmt.setString(1,facility_id);
					pstmt.setString(2,nursingunitcode);
					pstmt.setString(3,facility_id);
					pstmt.setString(4,nursingunitcode);
					pstmt.setString(5,p_pseudo_bed_yn);
					pstmt.setString(6,p_pseudo_bed_yn);

					rs_cnt = pstmt.executeQuery();
					if(rs_cnt!=null)
					{
						if( rs_cnt.next() )
						{
							total			= String.valueOf(rs_cnt.getInt("total")); 
							occupied		= String.valueOf(rs_cnt.getInt("occupied")); 
							vacant			= String.valueOf(rs_cnt.getInt("total") - rs_cnt.getInt("occupied") - rs_cnt.getInt("blocked_count")); 
							/*4/1/2009 IN009426*/
							vacant          = Integer.parseInt(vacant) < 0 ? "0"  : vacant ;
							/**/
							bbed			= String.valueOf(rs_cnt.getInt("blocked_count")); 
							overridable		= String.valueOf(rs_cnt.getInt("blocked_count") - rs_cnt.getInt("non_overridable_count")); 
							nonoverridable	= String.valueOf(rs_cnt.getInt("non_overridable_count"));
						}
					}
					//if (rs_cnt != null) rs_cnt.close();
					//if (stmt_cnt != null) stmt_cnt.close();
				}
				
				String bed_no		= checkForNull(rs.getString("bed_no_label"));
				bed_type_code		= checkForNull(rs.getString("bed_type_code"));
				bed_class_code		= checkForNull(rs.getString("bed_class_code"));
				String bed_status	= checkForNull(rs.getString("bed_status"));
				String booking_type	    = checkForNull(rs.getString("booking_type"));

			//Commented by Muthu on 01/03/2010 for Siriraj Walkthrough changes 
				//if(bed_available_date_yn.equals("Y"))
					//bed_status	= "A";	
				//End of comments  
				
				// Added by Muthu on 01/03/2010 for Siriraj Walkthrough changes
				// When Bed Availability Date is entered as one of the criteria in bed availabiliy queyry function then those beds which have expected discharge date should be displayed as the occupied till the expected discharge date afterwards it should be displayed as vacant beds 
				
				if(bed_available_date_yn.equals("Y")) {
					exp_dis_date = rs.getString("exp_discharge_date_time") == null?"":rs.getString("exp_discharge_date_time");
					no_of_record = rs.getInt("no_of_record");
					if(!exp_dis_date.equals("")) {						
						if(!(DateUtils.isAfter(exp_dis_date, from_date, "DMYHM", "en")))
							bed_status	= "A";
					} else {
						//if(!(bed_status.equals("B") && booking_type.equals("N")))
						if(!bed_status.equals("B"))
						bed_status	= "A";
					}					
				}
				
				// End of changes
				String room_no 		    = checkForNull(rs.getString("room_no"));
				String placeholder	    = "";
				StringBuffer tip	    = new StringBuffer();
				StringBuffer tip_vacant	= new StringBuffer();
				StringBuffer tip_booked	= new StringBuffer();

				p_nursing_unit_desc = checkForNull(rs.getString("nursing_unit_short_desc"));
				splty_code	= checkForNull(rs.getString("specialty_code"));
				splty_desc = checkForNull(rs.getString("specialty_short_desc"));
				if(rs.getString( "nursing_unit_short_desc" )!=null)
				{
					placeholder = "";
					placeholder = specialCharacter(rs.getString( "nursing_unit_short_desc" ));
				}	
				tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")	+"^^"+placeholder+"<br>" );
				tip_vacant.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")	+"^^"+placeholder+"<br>" );
				tip_booked.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")	+"^^"+placeholder+"<br>" );
		
				if( bed_status.equals("B") || bed_status.equals("T") || bed_status.equals("D"))
				{
					placeholder = "";
					if(rs.getString("patient_id")!=null)
					{
						placeholder = checkForNull(rs.getString("patient_id"));
						tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")	+" ^^ "+placeholder +"<br>");
						
					}
					if(rs.getString("bkg_patient_id")!=null)
					{
						placeholder = specialCharacter(rs.getString("bkg_patient_id"));
						tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")	+" ^^ "+placeholder +"<br>");
						tip_booked.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+" ^^"+checkForNull(rs.getString("bkg_patient_id"))+"<br>");
					}
				}
				if( bed_status.equals("O") ||  bed_status.equals("L")  )
				{
					placeholder = "";
					if(rs.getString("patient_id")!=null)
					{
						placeholder = checkForNull(rs.getString("patient_id"));
					tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+" ^^ "+placeholder +"<br>") ;
					}
					if(rs.getString("bkg_patient_id")!=null)
					{
						placeholder = specialCharacter(rs.getString("bkg_patient_id"));
					tip_booked.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+" ^^"+checkForNull(rs.getString("bkg_patient_id"))+"<br>");
					}
					if(rs.getString("referral_id")!=null)
					{
						placeholder = "";
						placeholder = rs.getString("referral_id");
						tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referralid.label","common_labels")	+" ^^ "+placeholder+"<br>");
					}
				}
				if( bed_status.equals("A") && booking_type.equals("L") )
				{
					placeholder = "";
					
					if(rs.getString("patient_id")!=null)
					{
						placeholder = checkForNull(rs.getString("patient_id"));
						tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")	+" ^^ "+placeholder +"<br>");
					}
					if(rs.getString("bkg_patient_id")!=null)
					{
						placeholder = specialCharacter(rs.getString("bkg_patient_id"));
						tip_booked.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+" ^^"+checkForNull(rs.getString("bkg_patient_id"))+"<br>");
					}
				}
				
				placeholder="";
				if(rs.getString( "room_no" )!=null)
					placeholder = specialCharacter(rs.getString( "room_no" ));
				tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomno.label","common_labels")+ "^^" +placeholder+"<br>");
				tip_vacant.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomno.label","common_labels")+ "^^" +placeholder+"<br>");
				tip_booked.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomno.label","common_labels")+ "^^" +placeholder+"<br>");

				if( bed_status.equals("B") || bed_status.equals("T") || bed_status.equals("D") )
				{
					placeholder = "";
					if(rs.getString("patient_name")!=null)
					{
						//placeholder = specialCharacter(rs.getString("patient_name"));
						placeholder = rs.getString("patient_name");
						tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")	+" ^^"+ placeholder+"<br>") ;
					}
					if(rs.getString("bg_patient_name")!=null)
					{
						//placeholder = specialCharacter(rs.getString("bg_patient_name"));
						  placeholder =rs.getString("bg_patient_name");
					tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")	+" ^^"+ placeholder+"<br>") ;
					tip_booked.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")	+" ^^"+ placeholder+"<br>") ;
					}
				}

				if( bed_status.equals("O") || bed_status.equals("L") )
				{
					placeholder = "";
					if(locale.equals("en"))
					{
						if(rs.getString("patient_name")!=null)
						{
							// placeholder = specialCharacter(rs.getString("patient_name"));
							  placeholder = rs.getString("patient_name");
							tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+" ^^"+ placeholder+"<br>");
						}
					}
					else
					{
						if(rs.getString("patient_name_loc_lang")!=null)
						{
							//placeholder = specialCharacter(rs.getString("patient_name_loc_lang"));
							placeholder = rs.getString("patient_name_loc_lang");
							tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+" ^^"+ placeholder+"<br>");
						}
						
					}
					if(locale.equals("en"))
					{
						if(rs.getString("bg_patient_name")!=null)
						{
							placeholder = specialCharacter(rs.getString("bg_patient_name"));
							placeholder = rs.getString("bg_patient_name");
							tip_booked.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+" ^^"+rs.getString("bg_patient_name")+"<br>");
						}
					}
					else
					{
						if(rs.getString("bg_patient_name_loc_lang")!=null)
						{
							//placeholder = specialCharacter(rs.getString("bg_patient_name_loc_lang"));
							placeholder = rs.getString("bg_patient_name_loc_lang");
							tip_booked.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+" ^^"+rs.getString("bg_patient_name")+"<br>");
						}
					
					}
					
				}

				if( bed_status.equals("A") && booking_type.equals("L") )
				{
					placeholder = "";
					if(locale.equals("en"))
					{
						if(rs.getString("patient_name")!=null)
						{
							//placeholder = specialCharacter(rs.getString("patient_name"));
							placeholder = rs.getString("patient_name");
							tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+" ^^"+ placeholder+"<br>");
						}
					}
					else
					{
						if(rs.getString("patient_name_loc_lang")!=null)
						{
							//placeholder = specialCharacter(rs.getString("patient_name_loc_lang"));
							placeholder = rs.getString("patient_name_loc_lang");
							tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+" ^^"+ placeholder+"<br>");
						}
					
					}
					if(locale.equals("en"))
					{
						if(rs.getString("bg_patient_name")!=null)
						{
							//placeholder = specialCharacter(rs.getString("bg_patient_name"));
							placeholder = rs.getString("bg_patient_name");
							tip_booked.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+" ^^"+rs.getString("bg_patient_name")+"<br>");
						}
					}
					else
					{
						if(rs.getString("bg_patient_name_loc_lang")!=null)
						{
							//placeholder = specialCharacter(rs.getString("bg_patient_name_loc_lang"));
							placeholder = rs.getString("bg_patient_name_loc_lang");
							tip_booked.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+" ^^"+rs.getString("bg_patient_name")+"<br>");
						}
					}
				}
				tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels")+" ^^"+rs.getString("bed_no")+"<br>");
				tip_vacant.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels")+" ^^"+rs.getString("bed_no")+"<br>");
				tip_booked.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels")+" ^^"+rs.getString("bed_no")+"<br>");

				if(rs.getString("main_bed_no") != null)
				{
					placeholder = specialCharacter(rs.getString("main_bed_no"));
					tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.MotherBedNo.label","i_labels")	+" ^^"+ placeholder+"<br>") ;
				}
				if(rs.getString("gender") ==null)
					gend = "";
				else
					gend = rs.getString("gender");

				if(rs.getString("bkg_gender") ==null)
					bg_gend  = "";
				else
					bg_gend  = rs.getString("bkg_gender");

				if(gend.equals("M"))
					gend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				else if (gend.equals("F"))
					gend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				else if (gend.equals("U"))
					gend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

				if(bg_gend.equals("M"))
					bg_gend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				else if (bg_gend.equals("F"))
					bg_gend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				else if (gend.equals("U"))
					bg_gend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

				if(rs.getString("age") ==null)
					age = "";
				else
					age = rs.getString("age");

				if(rs.getString("bkg_age") ==null)
					bg_age = "";
				else
					bg_age = rs.getString("bkg_age");

				if( bed_status.equals("O") || bed_status.equals("L") )
				{
					placeholder = "";
					if(!age.equals(""))
					{
						placeholder = specialCharacter(age);

						if(!gend.equals(""))
						{
							tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AgeGender.label","ip_labels")+" ^^"	+placeholder+" / "+gend+"<br>");
						}
						else
						{
							tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AgeGender.label","ip_labels")+" ^^"	+placeholder+"<br>");
							
						}
					}

					if(!bg_age.equals(""))
						placeholder = specialCharacter(bg_age);
					{
						if(!bg_gend.equals(""))
						{
							tip_booked.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AgeGender.label","ip_labels")+" ^^"	+placeholder+" / "+bg_gend+"<br>");
						}
						else
						{
							tip_booked.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AgeGender.label","ip_labels")+" ^^"	+placeholder+"<br>");
						}
					}
				}

				if( bed_status.equals("B") || bed_status.equals("T")|| bed_status.equals("D") )
				{
					placeholder = "";
					if(!age.equals(""))
					{
						placeholder = specialCharacter(age);

						if(!gend.equals(""))
						{
							tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AgeGender.label","ip_labels")+" ^^"	+placeholder+" / "+gend+"<br>");
							
						}
						else
						{
							tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AgeGender.label","ip_labels")+" ^^"	+placeholder+"<br>");
							
						}
					}

					if(!bg_age.equals(""))
					{
						placeholder = specialCharacter(bg_age);
						if(!bg_gend.equals(""))
						{
							tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AgeGender.label","ip_labels")+" ^^"	+placeholder+" / "+bg_gend+"<br>");
							tip_booked.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AgeGender.label","ip_labels")+" ^^"	+placeholder+" / "+bg_gend+"<br>");
						}
						else
						{
							tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AgeGender.label","ip_labels")+" ^^"	+placeholder+"<br>");
							tip_booked.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AgeGender.label","ip_labels")+" ^^"	+placeholder+"<br>");
						}
					}
				}
				
				if(bed_status.equals("A") && booking_type.equals("L"))
				{
					placeholder = "";

					if(!age.equals(""))
					{
						placeholder = specialCharacter(age);

						if(!gend.equals(""))
						{
							tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AgeGender.label","ip_labels")+" ^^"	+placeholder+" / "+gend+"<br>");
							
						}
						else
						{
							tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AgeGender.label","ip_labels")+" ^^"	+placeholder+"<br>");
							
						}
					}

					if(!bg_age.equals(""))
					{
						placeholder = specialCharacter(bg_age);

						if(!bg_gend.equals(""))
						{
							tip_booked.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AgeGender.label","ip_labels")+" ^^"	+placeholder+" / "+bg_gend+"<br>");
						}
						else
						{
							tip_booked.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AgeGender.label","ip_labels")+" ^^"	+placeholder+"<br>");
						}
					}
				}
				placeholder="";
				if(rs.getString( "bed_class_short_desc" )!=null)
					placeholder = specialCharacter(rs.getString( "bed_class_short_desc" ));
				tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BedClass.label","common_labels")+" ^^"	+placeholder+"<br>" );
				tip_vacant.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BedClass.label","common_labels")+" ^^"	+placeholder+"<br>" );
				tip_booked.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BedClass.label","common_labels")+" ^^"	+placeholder+"<br>" );

				if( !bed_status.equals("A") && !bed_status.equals("B") && !bed_status.equals("O") && !bed_status.equals("T") && !bed_status.equals("D"))
				{
					placeholder=" ";
					if(rs.getString( "bed_booking_ref_no" )!=null)
						placeholder = specialCharacter(rs.getString( "bed_booking_ref_no" ));
					tip_booked.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BookingRefNo.label","common_labels")+" ^^"+placeholder+"<br>" );
				}


				if( bed_status.equals("D") ||bed_status.equals("B")|| bed_status.equals("T"))
				{
					if( String.valueOf( rs.getLong("encounter_id") ) == null || String.valueOf( rs.getLong("encounter_id") ).equals("0") )
						placeholder = " ";
					else
						placeholder = String.valueOf( rs.getLong("encounter_id") ) ;
					if(rs.getString("patient_id")!=null || rs.getString("bkg_patient_id")!=null)
					{
						placeholder = specialCharacter(placeholder);
						tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounterid.label","common_labels")	+" ^^ "+ placeholder+"<br>" );
					}
				}
	//			System.out.println("bed_status---->"+bed_status);
				String enc_id = "";
				String disc_bill_exists = "N";
				String disSql = "";
				if( bed_status.equals("O"))
				{
					if( String.valueOf(rs.getLong("encounter_id")) == null || String.valueOf(rs.getLong("encounter_id")).equals("0"))
						placeholder = " ";
					else
						placeholder = String.valueOf( rs.getLong("encounter_id"));

					if(rs.getString("encounter_id")!=null)
						placeholder = specialCharacter(placeholder);
					tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounterid.label","common_labels")+" ^^ "+placeholder+"<br>" );
		// Following code added by Suresh M on 06/07/2011 for FD-CRF-SKR-PAS-003-IP
					enc_id = rs.getString("encounter_id")==null?"":rs.getString("encounter_id");
							
					if(!enc_id.equals("")){					 
					 try{						 
						  disSql = " SELECT BL_IP_DETAILS.GET_DISCHARGE_BILL_EXIST(?,?) disc_bill_exists FROM dual ";
						  dispstmt= con.prepareStatement(disSql);
						  dispstmt.setString(1,facility_id);							 
						  dispstmt.setString(2,enc_id);
						  disrs	= dispstmt.executeQuery();
						  if(disrs.next() && disrs != null){							
							disc_bill_exists = disrs.getString("disc_bill_exists");
							if(disc_bill_exists == null) 
								disc_bill_exists = "";							
						  }
		//				  System.out.println("disc_bill_exists---->"+disc_bill_exists);
						}catch (Exception e){
							//out.println("Exception in disql BedAvailabilityChartResult.jsp : "+e);
							e.printStackTrace();
						}
						if (disrs != null) disrs.close();
						if (dispstmt != null) dispstmt.close();
					 }
				//Ends FD-CRF-SKR-PAS-003-IP
					}

				placeholder="";
				if(rs.getString( "bed_type_short_desc" )!=null)
					placeholder = specialCharacter(rs.getString( "bed_type_short_desc" ));
				tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedtype.label","common_labels")+" ^^ "+placeholder );	
				tip_vacant.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedtype.label","common_labels")+" ^^ "+placeholder );	
				tip_booked.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedtype.label","common_labels")+" ^^ "+placeholder );	

				if( bed_status.equals("B")|| bed_status.equals("T") ||bed_status.equals("D"))
				{
					if(rs.getString("admission_date_time") ==null)
						placeholder = " ";
					else
					{
						//placeholder = rs.getString("admission_date_time");
						placeholder = DateUtils.convertDate(rs.getString("admission_date_time"),"DMYHM","en",locale);
					}
					if(rs.getString("patient_id") !=null && (!booking_type.equals("N")))
					{	
						placeholder = specialCharacter(placeholder);
						tip.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AdmittedDate.label","ip_labels")+" ^^ "+ placeholder );
					}
				}

				if( bed_status.equals("O") )
				{
					if(rs.getString("admission_date_time") ==null)
						placeholder = " ";
					else
					{
						//placeholder = rs.getString("admission_date_time");
						placeholder = DateUtils.convertDate(rs.getString("admission_date_time"),"DMYHM","en",locale);
					}
					if(rs.getString("admission_date_time") !=null)
					{
						placeholder = specialCharacter(placeholder);
					tip.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AdmittedDate.label","ip_labels")+" ^^ "+ placeholder );
					}
				}
				if( bed_status.equals("B") )
				{
					if(rs.getString("admission_date_time") ==null)
						placeholder = " ";
					else
					{
						//placeholder = rs.getString("admission_date_time");
						placeholder = DateUtils.convertDate(rs.getString("admission_date_time"),"DMYHM","en",locale);
					}
					if(rs.getString("admission_date_time") !=null)
					{
						placeholder = specialCharacter(placeholder);
					tip.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AdmittedDate.label","ip_labels")+" ^^ "+ placeholder );
					}
				}

				if(bed_status.equals("L"))
				{
					if(rs.getString("blocked_from") ==null)
						placeholder = "";
					else
						placeholder = rs.getString("blocked_from");
					if(placeholder!=null)
					placeholder = specialCharacter(placeholder);
					tip_booked.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BookedFrom.label","ip_labels")+" ^^ "+ placeholder);
				}

				if(rs.getString("pseudo_bed_yn") ==null)
					pseudo_bed_yn = " ";
				else 
					pseudo_bed_yn = rs.getString("pseudo_bed_yn");

				if(pseudo_bed_yn!=null)
				pseudo_bed_yn = specialCharacter(pseudo_bed_yn);


				main_bed_no=rs.getString("main_bed_no");
				if(main_bed_no==null) main_bed_no="";

				
				if(pseudo_bed_yn.equals("Y") && !main_bed_no.equals("") )
				{
					BedClassification = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BabiesBeds.label","ip_labels");
				}
				else if(pseudo_bed_yn.equals("Y") && main_bed_no.equals("") )
				{
					BedClassification = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.PseudoBed.label","ip_labels");
				}
				else 
				{
					BedClassification = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NormalBeds.label","ip_labels");
				}
				tip.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BedClassification.label","ip_labels")+" ^^"+ BedClassification);
				tip_vacant.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BedClassification.label","ip_labels")+" ^^"+ BedClassification);
				tip_booked.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BedClassification.label","ip_labels")+" ^^"+ BedClassification);
				
				/**/
				// SCR 4020 FDPMG20089CRF0119IP --08/12/2008 Start
				/*Friday, November 26, 2010 , commented for SRR20056-SCF-6089 [IN:025232] EDD disply added at line no 1505 */
				/*if((wherecondn.equals("CREATE_BOOKING_YN") && bed_status.equals("A")) ||  	(wherecondn.equals("REVISE_BOOKING_YN") && bed_status.equals("A")) || (wherecondn.equals("CONFIRM_BOOKING_YN") && bed_status.equals("A"))) 			
				{
						if(rs.getString("exp_discharge_date_time") ==null)
						placeholder = " ";
					else
					{
						//placeholder = rs.getString("exp_discharge_date_time");
						placeholder = DateUtils.convertDate(rs.getString("exp_discharge_date_time"),"DMYHM","en",locale);
					}
					if(rs.getString("bkg_exp_discharge_date_time") ==null)
						placeholder = " ";
					else
					{
						//placeholder = rs.getString("bkg_exp_discharge_date_time");
						placeholder = DateUtils.convertDate(rs.getString("bkg_exp_discharge_date_time"),"DMYHM","en",locale);
					}
					if(rs.getString("exp_discharge_date_time")!=null){	
						placeholder = specialCharacter(placeholder);
						tip.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ExpectedDischargeDateTime.label","ip_labels")+"^^"+placeholder );
						
						//Friday, February 05, 2010 , IN018903 EDD painted twice in Booking->BAC screen for occupied booked beds .
						//tip_booked.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ExpectedDischargeDateTime.label","ip_labels")+"^^"+placeholder );
					}
					expected_discharge_date=placeholder+"";
					expected_discharge_date=expected_discharge_date.trim();

					if(rs.getString("bkg_exp_discharge_date_time")!=null){	
						placeholder = specialCharacter(placeholder);
						
						tip_booked.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ExpectedDischargeDateTime.label","ip_labels")+"^^"+placeholder );
					}
					bkg_expected_discharge_date=placeholder+"";
					bkg_expected_discharge_date=bkg_expected_discharge_date.trim();
				}*/
				

				if(bed_status.equals("B") || bed_status.equals("T") || bed_status.equals("D") || bed_status.equals("O") || bed_status.equals("A"))
				{
					if(rs.getString("exp_discharge_date_time") ==null)
						placeholder = " ";
					else
					{
						//placeholder = rs.getString("exp_discharge_date_time").trim();
						placeholder = DateUtils.convertDate(rs.getString("exp_discharge_date_time").trim(),"DMYHM","en",locale);
					}

					if(rs.getString("exp_discharge_date_time")!=null)
					{	
						placeholder = specialCharacter(placeholder);
						tip.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ExpectedDischargeDateTime.label","ip_labels")+"^^"+placeholder );
						
					}

					if(rs.getString("bkg_exp_discharge_date_time") ==null)
						placeholder = " ";
					else
					{
						//placeholder = rs.getString("bkg_exp_discharge_date_time").trim();
						placeholder = DateUtils.convertDate(rs.getString("bkg_exp_discharge_date_time").trim(),"DMYHM","en",locale);
					}

					if(rs.getString("bkg_exp_discharge_date_time")!=null)
					{	
						placeholder = specialCharacter(placeholder);
						tip_booked.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ExpectedDischargeDateTime.label","ip_labels")+"^^"+placeholder );
					}
				}

				String booking_status = checkForNull(rs.getString("booking_status"));
				String override = checkForNull(rs.getString("override_yn"),"N");
				String days_before_status = checkForNull(rs.getString("DAYS_BEFORE_STATUS"));

				//ASSIGNING COLORS FOR BED BUTTON 
				String butt_color 		= "IP_GreenButton";//vacant
				//String butt_color 		= "";//vacant
				/*SCR 4020 FDPMG20089CRF0119IP*/
				if((days_before_status.equals("BOC") && future_booking_for_boc_yn.equals("Y")) || (days_before_status.equals("BOU") && future_booking_for_bou_yn.equals("Y")) || (days_before_status.equals("BNC") && future_booking_for_bnc_yn.equals("Y")) || (days_before_status.equals("BNU") && future_booking_for_bnu_yn.equals("Y"))){
					butt_color 		= "IP_GreenButton_B";
				}
				/**/
				String butt_color_1 	= "";
				String butt_color_2 	= "";
				String butt_color_3 	= "";
				String butt_color_4 	= "";

				/*SCR 4020 FDPMG20089CRF0119IP*/
				if(bed_status.equals("A")){
					if(override.equals("N") && booking_status.equals("1") && booking_type.equals("L"))
					butt_color_1 = "IP_PurpleButton";
					else if(override.equals("N") && booking_status.equals("0") && booking_type.equals("L"))
					butt_color_2 = "IP_LpurpleButton";
					else if(override.equals("Y") && booking_status.equals("1") && booking_type.equals("L"))
					butt_color_3 = "IP_WoodButton";
					else if(override.equals("Y") && booking_status.equals("0") && booking_type.equals("L"))
					butt_color_4 = "IP_LWoodButton";
				}
	
				if( ( bed_status.equals("O") || bed_status.equals("L") || bed_status.equals("T")) && !pseudo_bed_yn.equals("Y")  ){
					butt_color = "IP_RedButton";//occupied
					if(days_before_status.equals("BOC") || days_before_status.equals("BOU") || days_before_status.equals("BNC") || days_before_status.equals("BNU")){
					 if (future_booking_for_bnc_yn.equals("Y")) 
						butt_color 		= "IP_RedButton_B";
					 else if (future_booking_for_bnu_yn.equals("Y")) 
						butt_color 		= "IP_RedButton_B";
					 else if (future_booking_for_boc_yn.equals("Y")) 
						butt_color 		= "IP_RedButton_B";
					 else if (future_booking_for_bou_yn.equals("Y")) 
						butt_color 		= "IP_RedButton_B";
					}
					if(override.equals("N") && booking_status.equals("1") && booking_type.equals("L"))
					butt_color_1 = "IP_PurpleButton";
					else if(override.equals("N") && booking_status.equals("0") && booking_type.equals("L"))
					butt_color_2 = "IP_LpurpleButton";
					else if(override.equals("Y") && booking_status.equals("1") && booking_type.equals("L"))
					butt_color_3 = "IP_WoodButton";
					else if(override.equals("Y") && booking_status.equals("0") && booking_type.equals("L"))
					butt_color_4 = "IP_LWoodButton";
				}
				/**/
				if(pseudo_bed_yn.equals("Y")) // baby/pseudo
				{
					if(bed_status.equals("O"))
						butt_color = "IP_LPinkButton";
					else
						butt_color = "IP_LGreenButton";
				}
					if(override.equals("Y") && pseudo_bed_yn.equals("N"))
					{
						if(bed_status.equals("T") || bed_status.equals("B") || bed_status.equals("L") || bed_status.equals("D") || booking_type.equals("B"))
							butt_color	= "IP_YellowButton";
					}
					else if(override.equals("N") && pseudo_bed_yn.equals("N"))
					{
						if(bed_status.equals("T") || bed_status.equals("B") || bed_status.equals("L") || bed_status.equals("D") || booking_type.equals("B"))
							butt_color	= "IP_BrownButton";
					}
				if(bed_status.equals("O"))
				{
					nursingunitcode = rs.getString("nursing_unit_code");
					if(nursingunitcode == null)nursingunitcode ="";
						pat_curr_locn_code = rs.getString("pat_curr_locn_code");

					if(pat_curr_locn_code != null)
					{
						if(!nursingunitcode.equals(pat_curr_locn_code))
						{
							butt_color	= "IP_newButton";
							/*Added By Dharma on 04th Oct 2014 against HSA-CRF-0180 [IN:049539] Start*/
							isPatientOccupiedDeparted	= "Y";
							pat_curr_locn_type_desc		= checkForNull(rs.getString("pat_curr_locn_type_desc"));
							pat_curr_locn_desc			= checkForNull(rs.getString("pat_curr_locn_desc"));
							movement_reason				= checkForNull(rs.getString("movement_reason"));
							
							/*Added By Dharma on 04th Oct 2014 against HSA-CRF-0180 [IN:049539] End*/
						}
					}
				}
				/*SCR 4020 FDPMG20089CRF0119IP*/
				if(bed_status.equals("B") && override.equals("Y") && booking_status.equals("1") && booking_type.equals("L")){
					butt_color		= "IP_GreenButton";
					if((days_before_status.equals("BOC") && future_booking_for_boc_yn.equals("Y")) || (days_before_status.equals("BOU") && future_booking_for_bou_yn.equals("Y")) || (days_before_status.equals("BNC") && future_booking_for_bnc_yn.equals("Y")) || (days_before_status.equals("BNU") && future_booking_for_bnu_yn.equals("Y"))){
						butt_color 		= "IP_GreenButton_B";
				}
					butt_color_3	= "IP_WoodButton";
				}
				if(bed_status.equals("B") && override.equals("Y") && booking_status.equals("0") && booking_type.equals("L")){
					butt_color		= "IP_GreenButton";
					if((days_before_status.equals("BOC") && future_booking_for_boc_yn.equals("Y")) || (days_before_status.equals("BOU") && future_booking_for_bou_yn.equals("Y")) || (days_before_status.equals("BNC") && future_booking_for_bnc_yn.equals("Y")) || (days_before_status.equals("BNU") && future_booking_for_bnu_yn.equals("Y"))){
						butt_color 		= "IP_GreenButton_B";
				}
					butt_color_4	= "IP_LWoodButton";
				}
				if(bed_status.equals("B") && override.equals("N") && booking_status.equals("1") && booking_type.equals("L")){
				butt_color		= "IP_GreenButton";
					if((days_before_status.equals("BOC") && future_booking_for_boc_yn.equals("Y")) || (days_before_status.equals("BOU") && future_booking_for_bou_yn.equals("Y")) || (days_before_status.equals("BNC") && future_booking_for_bnc_yn.equals("Y")) || (days_before_status.equals("BNU") && future_booking_for_bnu_yn.equals("Y"))){
						butt_color 		= "IP_GreenButton_B";
				}
					butt_color_1	= "IP_PurpleButton";
				}
				if(bed_status.equals("B") && override.equals("N") && booking_status.equals("0") && booking_type.equals("L")){
					butt_color		= "IP_GreenButton";
					if((days_before_status.equals("BOC") && future_booking_for_boc_yn.equals("Y")) || (days_before_status.equals("BOU") && future_booking_for_bou_yn.equals("Y")) || (days_before_status.equals("BNC") && future_booking_for_bnc_yn.equals("Y")) || (days_before_status.equals("BNU") && future_booking_for_bnu_yn.equals("Y"))){
						butt_color 		= "IP_GreenButton_B";
				}
					butt_color_2	= "IP_LpurpleButton";
				}
				/**/
				
				//if(booking_type.equals("N"))
				if(booking_type.equals("N") && bed_status.equals("B"))
				{
						butt_color	= "IP_violetButton";
						/*if(override.equals("N") && booking_status.equals("1") )
							butt_color_1 = "IP_PurpleButton";
						else if(override.equals("N") && booking_status.equals("0") )
							butt_color_2 = "IP_LpurpleButton";
						else if(override.equals("Y") && booking_status.equals("1"))
							butt_color_3 = "IP_WoodButton";
						else if(override.equals("Y") && booking_status.equals("0") )
							butt_color_4 = "IP_LWoodButton";*/						
				}
	// Following code added by Suresh M on 06/07/2011 for FD-CRF-SKR-PAS-003-IP
				if(bed_status.equals("O") && !enc_id.equals("") && disc_bill_exists.equals("Y")){
					butt_color	= "IP_RedButton_D";
				}
	//Ends FD-CRF-SKR-PAS-003-IP
				if(reserve_bed_selectable.equals("Y"))
				{
					//if(current_patient_id.equals(checkForNull(rs.getString("bkg_patient_id"))) && checkForNull(rs.getString("blocked_until")).equals("") )
						/* 
						Modified for IP-ICN-6903_Reopen since reserved bed can have rs.getString("blocked_until") value.
						*/
						/*
						ICN:18866
						Date:Thursday, February 04, 2010
						added &&(booking_type.equals("N"))
						*/
					if(current_patient_id.equals(checkForNull(rs.getString("bkg_patient_id")))&&(booking_type.equals("N")))
					{
						butt_color	= "IP_selectableReserveBed";
					}
				}
				///E.O. ASSIGNING COLORS... 

				if( bed_status.equals("B") || bed_status.equals("T") || bed_status.equals("D") )
				{
					if(rs.getString("blocking_type_code") ==null)
						placeholder = " ";
					else
						placeholder = rs.getString("blocking_type_short_desc");

					if(placeholder!=null && !placeholder.equals(" "))
					{
						placeholder = specialCharacter(placeholder);
					if(booking_type.equals("N"))	
						{
							tip.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ReasonforReserveBed.label","ip_labels")+" ^^ "+placeholder );
							tip_booked.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ReasonforReserveBed.label","ip_labels")+" ^^ "+placeholder );
						}else
						{
							tip.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BlockedType.label","ip_labels")+" ^^ "+placeholder );
							tip_booked.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BlockedType.label","ip_labels")+" ^^ "+placeholder );
						}
					}

					if(rs.getString("blocked_from") ==null)
						placeholder = " ";
					else
					{
						//placeholder = rs.getString("blocked_from");
						placeholder = DateUtils.convertDate(rs.getString("blocked_from"),"DMYHM","en",locale);
					}
					
					if(placeholder!=null)
					{
						placeholder = specialCharacter(placeholder);
						tip.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BlockedFromDate.label","ip_labels")+" ^^"+ placeholder );
						tip_booked.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BlockedFromDate.label","ip_labels")+" ^^"+ placeholder );
					}

					if(rs.getString("blocking_remarks") == null)
						placeholder = " ";
					else
						placeholder = rs.getString("blocking_remarks");
			
					if(placeholder!=null && !placeholder.equals(" "))
					{
						placeholder = specialCharacter(placeholder);
						tip.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BlockedRemarks.label","ip_labels")+"^^"+ placeholder );
						tip_booked.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BlockedRemarks.label","ip_labels")+"^^"+ placeholder );
					}

											
					if(!booking_type.equals("N"))
					{
						if(rs.getString("blocked_until") ==null)
							placeholder = " ";
						else 
						{
							//placeholder = rs.getString("blocked_until");
							 placeholder = DateUtils.convertDate(rs.getString("blocked_until"),"DMYHM","en",locale);
						}
					
						if(placeholder != null && !placeholder.equals(" "))
						{
							placeholder = specialCharacter(placeholder);
							tip.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BedBlockleduntil.label","ip_labels")+"^^"+ placeholder);
							tip_booked.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BedBlockleduntil.label","ip_labels")+"^^"+ placeholder);
						}
					}
					
				}
				/// Added by SRIDHAR R on 09 AUG 20047
				if(booking_type.equals("L"))
				{
					/*Friday, November 26, 2010 , SRR20056-SCF-6089 [IN:025232]*/
					if(bed_status.equals("O") || bed_status.equals("A")) 
					{
						if(rs.getString("blocked_from") ==null)
						placeholder = " ";
						else
						{
							//placeholder = rs.getString("blocked_from");
							placeholder = DateUtils.convertDate(rs.getString("blocked_from"),"DMYHM","en",locale);
						}
						if(placeholder!=null)
						{
							placeholder = specialCharacter(placeholder);
							tip_booked.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BlockedFromDate.label","ip_labels")+" ^^"+ placeholder );
						}

						if(rs.getString("blocked_until") ==null)
							placeholder = " ";
						else 
						{
							//placeholder = rs.getString("blocked_until");
							 placeholder = DateUtils.convertDate(rs.getString("blocked_until"),"DMYHM","en",locale);
						}
					
						if(placeholder != null && !placeholder.equals(" "))
						{
							placeholder = specialCharacter(placeholder);
							tip_booked.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BedBlockleduntil.label","ip_labels")+"^^"+ placeholder);
						}
					}
					if(rs.getString("blocked_until") ==null)
						placeholder = "";
					else
					{
						//placeholder = rs.getString("blocked_until");
						 placeholder = DateUtils.convertDate(rs.getString("blocked_until"),"DMYHM","en",locale);
					}

					if(placeholder!=null)
						placeholder = specialCharacter(placeholder);
					
					tip_booked.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BookedUntil.label","ip_labels")+" ^^ "+ placeholder);

				}

				if(rs.getString("exp_days_of_stay") == null)
					placeholder = " ";
				else
				{
					placeholder = rs.getString("exp_days_of_stay");

					placeholder = specialCharacter(placeholder);
					
					tip_booked.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ExpdaysofStay.label","ip_labels")+"^^"+placeholder );
				}



				if(bed_status.equals("B") || bed_status.equals("O") || bed_status.equals("L") )
				{
					placeholder = "";
					if(rs.getString("practitioner_name") !=null)
					{
						placeholder = specialCharacter(rs.getString("practitioner_name"));
						tip.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")	+" ^^"+placeholder );
					}
					if(rs.getString("bkg_Practitioner_Name") !=null)
					{	
					
						placeholder = specialCharacter(rs.getString("bkg_Practitioner_Name"));
						
						if(booking_type.equals("N"))
						{
						tip.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")	+" ^^"+placeholder );
						}
						tip_booked.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")	+" ^^"+placeholder );
					}
				}
				if(bed_status.equals("A") && booking_type.equals("L"))
				{
					if(rs.getString("practitioner_name") !=null)
						placeholder = " ";
					else
						placeholder = checkForNull(rs.getString("practitioner_name"));
					
					
					if(rs.getString("practitioner_name") !=null)
					{	
						placeholder = specialCharacter(placeholder);
						tip.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")	+" ^^"+placeholder );
						
					}
					if(rs.getString("bkg_Practitioner_Name") ==null)
						placeholder = " ";
					else
						placeholder = checkForNull(rs.getString("bkg_Practitioner_Name"));
					if(rs.getString("bkg_Practitioner_Name") !=null)
					{	
						placeholder = specialCharacter(placeholder);
						tip_booked.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")	+" ^^"+placeholder );
					}
				}
				if(bed_status.equals("O") || bed_status.equals("L"))
				{
					if(rs.getString("PAT_CAT_SHORT_DESC") ==null)
						placeholder = " ";
					else
						placeholder = checkForNull(rs.getString("PAT_CAT_SHORT_DESC"));
	
					if(rs.getString("PAT_CAT_SHORT_DESC") !=null )
					{
						placeholder = specialCharacter(placeholder);
					tip.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.category.label","common_labels")+"^^"+placeholder );
					}
				}

				if( bed_status.equals("B"))
				{
					if(rs.getString("PAT_CAT_SHORT_DESC") ==null)
						placeholder = " ";
					else
						placeholder = checkForNull(rs.getString("PAT_CAT_SHORT_DESC"));
					if(rs.getString("patient_id") !=null)
					{	
						placeholder = specialCharacter(placeholder);
						tip.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.category.label","common_labels")+" ^^"+placeholder );
					}
				}

				if(!bed_status.equals("O") && !bed_status.equals("A") &&  !bed_status.equals("B") && !bed_status.equals("T") && !bed_status.equals("D") && !bed_status.equals("L"))
				{
					if(rs.getString("blocking_type_short_desc") ==null)
						placeholder = " ";
					else
						placeholder = rs.getString("blocking_type_short_desc");
			
					if(placeholder!=null && !placeholder.equals(" "))
					{
						placeholder = specialCharacter(placeholder);
						
						if(booking_type.equals("N"))	
						{
							tip.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ReasonforReserveBed.label","ip_labels")+" ^^"+ placeholder);
							tip_booked.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ReasonforReserveBed.label","ip_labels")+" ^^"+ placeholder);
						}else
						{
							tip.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BlockedType.label","ip_labels")+" ^^"+ placeholder);
							tip_booked.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BlockedType.label","ip_labels")+" ^^"+ placeholder);
							
						}
					}

					if(rs.getString("blocking_remarks") ==null)
						placeholder = " ";
					else
						placeholder = rs.getString("blocking_remarks");
			
					if(placeholder!=null && !placeholder.equals(" "))
					{
						placeholder = specialCharacter(placeholder);
						tip.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BlockedRemarks.label","ip_labels")+"^^"+ placeholder );
						tip_booked.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BlockedRemarks.label","ip_labels")+"^^"+ placeholder );
					}

				}

				//added new code here
				if(bed_status.equals("O"))
				{
					if(rs.getString("ADMISSION_TYPE") !=null)
						placeholder = rs.getString("ADMISSION_TYPE");
					else
						placeholder = " ";

					if(placeholder!=null && !placeholder.equals(" "))
					{
						placeholder = specialCharacter(placeholder);
					tip.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admissiontype.label","common_labels")	+" ^^"+placeholder );
					}
					
					/*Added By Dharma on 04th Oct 2014 against HSA-CRF-0180 [IN:049539] Start*/
					if(isPatientOccupiedDeparted.equals("Y")){
						tip.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MovementLocation.label","common_labels")	+" ^^"+pat_curr_locn_type_desc+"/ "+pat_curr_locn_desc);
						tip.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ReasonForMovement.label","op_labels")	+" ^^"+movement_reason);
					}
					/*Added By Dharma on 04th Oct 2014 against HSA-CRF-0180 [IN:049539] End*/


				}	

				if(bed_status.equals("B"))
				{
					if(rs.getString("ADMISSION_TYPE") !=null)
						placeholder = rs.getString("ADMISSION_TYPE");
					else
						placeholder = " ";

					if(placeholder!=null && !placeholder.equals(" "))
					{
						placeholder = specialCharacter(placeholder);
					tip.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admissiontype.label","common_labels")	+" ^^"+placeholder );
					}
				}	

				if(bed_status.equals("O") || bed_status.equals("L") || bed_status.equals("B")  || booking_type.equals("L"))
				{
					placeholder = "";
					
					if(rs.getString("admission_reason")!=null)
					{
						placeholder = specialCharacter(rs.getString("admission_reason"));
					tip.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ReasonforAdmissionBooking.label","ip_labels")+"^^"+checkForNull(rs.getString("admission_reason")));

					}

					if(rs.getString("booking_reason")!=null)
					{
						placeholder = checkForNull(rs.getString("booking_reason"));
					tip_booked.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ReasonforAdmissionBooking.label","ip_labels")+"^^"+checkForNull(rs.getString("booking_reason")) ) ;

					}
				}	

				String placestate = "";
				if(rs.getString("OTH_ADT_STATUS") == null)
				{
					placestate = "";
					placeholder = "";
				}
				else if(checkForNull(rs.getString("OTH_ADT_STATUS")).equals("4"))
				{
					placestate = checkForNull(rs.getString("OTH_ADT_STATUS"));
					placeholder = "OTH_ADT_STATUS_DESC";
				}

				if(!bed_status.equals("O"))
				{
					if(placeholder!=null && !placeholder.equals(""))
						placeholder =	specialCharacter(placeholder);
					if(placestate.equals("4"))
					{
						tip.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")+"^^"+ placeholder);
						tip_booked.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")+"^^"+ placeholder);
					}
				}

		
				/*Friday, June 25, 2010 , condition added for SRR20056-SCF-4739-IN022361 since reserved & blocked beds also displays booking status*/
				//if(!booking_status.equals(""))
				if(!booking_status.equals("") && booking_type.equals("L"))
				{
					placeholder = specialCharacter(booking_status);

					if(booking_status.equals("0"))
					{
						
						/*Friday, June 25, 2010 , commented for SRR20056-SCF-4739-IN022361 since occupied beds also displays booking status*/
						//tip.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BookingStatus.label","common_labels")+"^^"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.UnConfirmed.label","ip_labels"));
						tip_booked.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BookingStatus.label","common_labels")+"^^"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.UnConfirmed.label","ip_labels"));
					}
					else if(booking_status.equals("1"))
					{
						/*Friday, June 25, 2010 , commented for SRR20056-SCF-4739-IN022361 since occupied beds also displays booking status*/
						//tip.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BookingStatus.label","common_labels")+"^^"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.confirmed.label","common_labels") );
						tip_booked.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BookingStatus.label","common_labels")+"^^"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.confirmed.label","common_labels") );
					}
				}
				/**/
				if(bl_operational.equals("Y"))
				{
					Financial_classification = rs.getString("Financial_classification");
					if(Financial_classification == null) 
						Financial_classification = "";
					
					if(Financial_classification!="")
					{
						tip.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.FinancialClassification.label","ip_labels")+" ^^ "+Financial_classification);
						
						/*Friday, June 25, 2010 , commented since financial details captured for encounter is displayed for booking case.*/
						//tip_booked.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.FinancialClassification.label","ip_labels")+" ^^ "+Financial_classification);
					}
					/*Friday, June 25, 2010 , added to display financial details captured during IP Booking*/
					Bkg_Financial_classification = rs.getString("bkg_financial_classification");
					if(Bkg_Financial_classification == null) 
						Bkg_Financial_classification = "";

					if(Bkg_Financial_classification!="")
					{
						tip_booked.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.FinancialClassification.label","ip_labels")+" ^^ "+Bkg_Financial_classification);
					}
				}
				/**/
				/*Thursday, April 22, 2010 commented and query moved to main query for performance tuning */
				/*
				try
				{
					if(bl_operational.equals("Y"))
					{
						String pat_id = rs.getString("patient_id");
						String bkg_pat_id = rs.getString("bkg_patient_id");
						if(bkg_pat_id == null) bkg_pat_id = "";
						if(pat_id == null) pat_id = bkg_pat_id;
						String enc_id = rs.getString("encounter_id")==null?"":rs.getString("encounter_id");

						if(!pat_id.equals(""))
						{
							String Fin_sql = "SELECT a.blng_grp_id, b.SHORT_DESC Financial_classification FROM bl_episode_fin_dtls a, BL_BLNG_GRP b WHERE a.operating_facility_id = ? and a.patient_id = ? and a.episode_id = ? and a.BLNG_GRP_ID = b.BLNG_GRP_ID";
							Fin_pstmt= con.prepareStatement(Fin_sql);
							Fin_pstmt.setString(1,facility_id);
							Fin_pstmt.setString(2,pat_id);
							Fin_pstmt.setString(3,enc_id);
							Fin_Rs	= Fin_pstmt.executeQuery();
							if(Fin_Rs.next() && Fin_Rs != null)
							{
								Financial_classification = Fin_Rs.getString("Financial_classification");
								if(Financial_classification == null) 
								Financial_classification = "";
								tip.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.FinancialClassification.label","ip_labels")+" ^^ "+Financial_classification);
								tip_booked.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.FinancialClassification.label","ip_labels")+" ^^ "+Financial_classification);
							}
						}
					}
				
					if(Fin_Rs!=null)   Fin_Rs.close();
					if(Fin_pstmt!=null) Fin_pstmt.close();
				
				}catch(Exception e)
				{
					//out.print("ERROR at bl_episode_fin_dtls :"+e);
					e.printStackTrace() ;
				}*/
				//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 29/01/2013
				//Start
					String patid=checkForNull(rs.getString("bkg_patient_id"));
					if(patid.equals(""))
					patid=checkForNull(rs.getString("patient_id"));
					if(!patid.equals(""))
						{
						StringBuffer surg_sql= new StringBuffer();
						PreparedStatement surg_pstmt=null;
						if(!enc_id.equals(""))
							{
							surg_sql.append("select oper_short_desc ,to_char(pref_surg_date,'dd/mm/yyyy') from ip_booking_list  where BKG_LST_REF_NO =(select booking_ref_no from ip_open_encounter where patient_id=? and encounter_id=?)");
							surg_pstmt= con.prepareStatement(surg_sql.toString());
							surg_pstmt.setString(1,patid);
							surg_pstmt.setString(2,enc_id);
							}
						else
							{
						surg_sql.append("select oper_short_desc ,to_char(pref_surg_date,'dd/mm/yyyy') from ip_booking_list where bed_no=? and  patient_id =? and FACILITY_ID =  ? ");
						if(!nursingunitcode.equals(""))
							{
							surg_sql.append(" and nursing_unit_code = ?  ");
							}
						if(!speciality_code.equals(""))
							{
							surg_sql.append(" and SPECIALTY_CODE = ?  ");
							}
							
						surg_pstmt= con.prepareStatement(surg_sql.toString());
						surg_pstmt.setString(1,bed_no);
						surg_pstmt.setString(2,patid);
						surg_pstmt.setString(3,facility_id);
						
						if((!nursingunitcode.equals(""))&&(speciality_code.equals("")))
							{
							surg_pstmt.setString(4,nursingunitcode);
							}
						if((!speciality_code.equals(""))&&(nursingunitcode.equals("")))
							{
							surg_pstmt.setString(4,speciality_code);
							}	
						if((!speciality_code.equals(""))&&(!nursingunitcode.equals("")))
							{
							surg_pstmt.setString(4,nursingunitcode);
							surg_pstmt.setString(5,speciality_code);
							}					
						}
						ResultSet surg_Rs	= surg_pstmt.executeQuery();
						if(surg_Rs.next() && surg_Rs != null)
							{
							if(!(checkForNull(surg_Rs.getString(1)).equals(""))&&(!checkForNull(surg_Rs.getString(2)).equals("")))
								{
								if(!checkForNull(rs.getString("bkg_patient_id")).equals(""))
									{
									tip_booked.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SurgeryOrder.label","ip_labels")+" ^^ "+checkForNull(surg_Rs.getString(1)));
									tip_booked.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SurgeryDate.label","ip_labels")+" ^^ "+checkForNull(com.ehis.util.DateUtils.convertDate(surg_Rs.getString(2),"DMY","en",locale)));
									if((rs.getString("bkg_patient_id").equals(rs.getString("patient_id")))||
									(!checkForNull(rs.getString("bkg_patient_id")).equals("")))
										{
										tip.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SurgeryOrder.label","ip_labels")+" ^^ "+checkForNull(surg_Rs.getString(1)));
										tip.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SurgeryDate.label","ip_labels")+" ^^ "+checkForNull(com.ehis.util.DateUtils.convertDate(surg_Rs.getString(2),"DMY","en",locale)));
										}
									}
								else{	
								tip.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SurgeryOrder.label","ip_labels")+" ^^ "+checkForNull(surg_Rs.getString(1)));
								tip.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SurgeryDate.label","ip_labels")+" ^^ "+checkForNull(com.ehis.util.DateUtils.convertDate(surg_Rs.getString(2),"DMY","en",locale)));
								}
								}
							}
						if(surg_Rs!=null)   surg_Rs.close();
						if(surg_pstmt!=null) surg_pstmt.close();
						surg_sql.delete(0, surg_sql.length());
						}
					//End RUT-CRF-0012 (23395) 
				/// END of Addition by Sridhar R

				if( BedListinOrder1 !=null && !BedListinOrder1.equals("") )
				{
					group1  = rs.getString( "group1" ) ; 
					if( group1 == null )
						group1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AllSPLTY.label","ip_labels");
				}

				if( BedListinOrder2 !=null && !BedListinOrder2.equals("") )
					group2  = checkForNull(rs.getString( "group2" ));

				if( BedListinOrder3 !=null && !BedListinOrder3.equals("") )
					group3  = checkForNull(rs.getString( "group3" ));

				if( BedListinOrder4 !=null && !BedListinOrder4.equals("") )
					group4  = checkForNull(rs.getString( "group4" ));


				if (!prev_group.equals(p_nursing_unit_desc))
				{							
					String header = "" ;
					header =  p_nursing_unit_desc; 						
					prev_group = p_nursing_unit_desc;

					if(!nursingunitcode.equals("") && speciality_code.equals(""))
					{
						TableStr.append(" </tr><tr><table width='100%'><td class='HEADERCOMMON' align='left'>"+header+"</td> ");
					}

					else if(!speciality_code.equals(""))
					{
						TableStr.append(" </tr><tr><table width='100%'><td class='HEADERCOMMON' align='left'>"+header+"</td>");
					}

					TableStr.append(" <td class='HEADERCOMMON' align='left'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.total.label","common_labels")+"&nbsp;:&nbsp;"+total+"&nbsp;&nbsp;&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Occupied.label","common_labels")+"&nbsp;:&nbsp;"+occupied+"&nbsp;&nbsp;&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Vacant.label","common_labels")+"&nbsp;:&nbsp;"+vacant+"&nbsp;&nbsp;&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BookedBlocked.label","ip_labels")+"&nbsp;:&nbsp;"+bbed+"&nbsp;&nbsp;[&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.Overrideable.label","ip_labels")+"&nbsp;:&nbsp;"+overridable+"&nbsp;&nbsp;&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.Nonoverrideable.label","ip_labels")+"&nbsp;:&nbsp;"+nonoverridable+"&nbsp;]</td></table></tr><tr> ");

					bed_col_num = 1;
				}

							
				if( ( BedListinOrder1 !=null || !BedListinOrder1.equals("") ) && ( !prev_group1.equals(group1) ) || ( BedListinOrder2 !=null || !BedListinOrder2.equals("") ) && ( !prev_group2.equals(group2) ) || ( BedListinOrder3 !=null || !BedListinOrder3.equals("") ) && ( !prev_group3.equals(group3) ) || ( BedListinOrder4 !=null || !BedListinOrder4.equals("") ) && ( !prev_group4.equals(group4) ) )
				{
					
					String header = "" ;
					prev_group1 = group1 ; 
					header = group1 ;

					if( BedListinOrder2  != null && !BedListinOrder2.equals( "" ) )
					{
						prev_group2 = group2 ; 
						if(!(group2==null || group2.equals("")))
							header = header+"/"+group2 ;
					}

					if( BedListinOrder3  != null && !BedListinOrder3.equals( "" ) )
					{
						prev_group3 = group3 ; 
						if(!(group3==null || group3.equals("")))
							header = header+"/"+group3 ;
					}

					if( BedListinOrder4  != null && !BedListinOrder4.equals( "" ) )
					{
						prev_group4 = group4 ; 
						if(!(group4==null || group4.equals("")))
							header = header+"/"+group4 ;
					}
					
					TableStr.append("</tr><tr><table width='100%'><th class='GROUPING' align='left'>"+header+"</th></table></tr><tr>");

					bed_col_num = 1;								
				}
				/// retVal Modified & Added on 26 OCT 2004 by SRIDHAR R
				String nursingunit_code = checkForNull(rs.getString("nursing_unit_code"));
				String bedno			= checkForNull(rs.getString("bed_no"));
				String servicecode		= checkForNull(rs.getString("service_code"));
				String servicedesc		= checkForNull(rs.getString("service_desc"));
				String ancillaryYN		= checkForNull(rs.getString("ancillary_yn"));
				String dlycharge		= checkForNull(rs.getString("dly_charge"));
				String bedclassshortdesc= checkForNull(rs.getString("bed_class_short_desc"));
				String bedtypeshortdesc = checkForNull(rs.getString("bed_type_short_desc"));
				String pseudobedYN		= checkForNull(rs.getString("pseudo_bed_yn"));
				String appl_patient_class= checkForNull(rs.getString("appl_patient_class"));
				String bedstatus		= checkForNull(rs.getString("bed_status"));
				expected_discharge_date = checkForNull(rs.getString("exp_discharge_date_time"));
				String bed_booking_ref_no= checkForNull(rs.getString("bed_booking_ref_no"));
				String occupying_patient_id		= checkForNull(rs.getString("patient_id"));

				//	String retVal = nursingunit_code+"^"+bedno+"^"+bed_type_code+"^"+bed_class_code+"^"+room_no+"^"+servicecode+"^"+servicedesc+"^"+ancillaryYN+"^"+dlycharge+"^"+p_nursing_unit_desc+"^"+splty_code+"^"+splty_desc+"^"+bedclassshortdesc+"^"+bedtypeshortdesc+"^"+pseudobedYN+"^"+appl_patient_class;

			//	SCR 4020 FDPMG20089CRF0119IP --08/12/2008 Start
				String retVal = nursingunit_code+"^"+bedno+"^"+bed_type_code+"^"+bed_class_code+"^"+room_no+"^"+servicecode+"^"+servicedesc+"^"+ancillaryYN+"^"+dlycharge+"^"+p_nursing_unit_desc+"^"+splty_code+"^"+splty_desc+"^"+bedclassshortdesc+"^"+bedtypeshortdesc+"^"+pseudobedYN+"^"+appl_patient_class+"^"+expected_discharge_date+"^"+allow_booking_without_edd_yn+"^"+allow_booking_with_edd_yn+"^"+wherecondn+"^"+consider_edd_stop_for_boc_yn+"^"+consider_edd_stop_for_bou_yn+"^"+consider_edd_stop_for_bnc_yn+"^"+consider_edd_stop_for_bnu_yn+"^"+action_for_boc+"^"+action_for_bou+"^"+action_for_bnc+"^"+action_for_bnu+"^"+bedstatus+"^"+days_before_status+"^"+bed_booking_ref_no+"^"+no_of_record+"^"+occupying_patient_id;

				if(butt_color.equals("IP_GreenButton"))
					TableStr.append(" <script>var tips"+count_buttn+" = escape(\""+tip_vacant.toString()+"\");var retVal"+count_buttn+" = escape(\""+retVal+"\"); </script> ");
				else if(butt_color.equals("IP_RedButton"))
					TableStr.append(" <script>var tips"+count_buttn+" = escape(\""+tip.toString()+"\");var retVal"+count_buttn+" = escape(\""+retVal+"\"); </script> ");
				else if(butt_color.equals("IP_GreenButton_B")) // Thursday, February 11, 2010 19163
					TableStr.append(" <script>var tips"+count_buttn+" = escape(\""+tip_vacant.toString()+"\");var retVal"+count_buttn+" = escape(\""+retVal+"\"); </script> ");
				else 
					TableStr.append(" <script>var tips"+count_buttn+" = escape(\""+tip.toString()+"\");var retVal"+count_buttn+" = escape(\""+retVal+"\"); </script> ");

				if(butt_color_1.equals("IP_PurpleButton") || butt_color_2.equals("IP_LpurpleButton") || butt_color_3.equals("IP_WoodButton") || butt_color_4.equals("IP_LWoodButton"))
					TableStr.append(" <script>var tipb"+count_buttn+" = escape(\""+tip_booked.toString()+"\");var retVal"+count_buttn+" = escape(\""+retVal+"\"); </script> "); 
				//SCR 4020 FDPMG20089CRF0119IP --08/12/2008
			    if(booking_status.equals("")){
		
				TableStr.append(" <td width='2%' bordercolor='black' border='1'><input type='button' value=\""+bed_no+"\" onMouseOver=\"displayToolTip(tips"+count_buttn+",this)\" class='"+butt_color+"' onMouseOut ='hideToolTip()' style='width:6vw;border-style:ridge' onclick='closeWin(unescape(retVal"+count_buttn+"),\""+butt_color+"\",\""+main_bed_no+"\")'> </td> ");
				}
				if(override.equals("N") && booking_status.equals("1") && booking_type.equals("L")){
				//if(override.equals("N") && booking_status.equals("1") && (booking_type.equals("L") || booking_type.equals("N"))){
				if (future_booking_for_bnc_yn.equals("Y")) {
						
							TableStr.append(" <td width='2%' bordercolor='black' border='1' style='border-style: ridge'><input type='button' value=\""+bed_no+"\"  onMouseOver=\"displayToolTip(tips"+count_buttn+",this)\"  class='"+butt_color+"' onMouseOut ='hideToolTip()' style='width:6vw;background-image:url('../../eIP/images/future.gif');' onclick='closeWin(unescape(retVal"+count_buttn+"),\""+butt_color+"\",\""+butt_color_1+"\",\""+main_bed_no+"\")'></td><td width='2%'  bordercolor='black' border='1'><input type='button'   class='"+butt_color_1+"' onMouseOver=\"displayToolTip(tipb"+count_buttn+",this)\"  onMouseOut ='hideToolTip()' style='width:12;'></td> ");
						}else
						{
							if(!butt_color_1.equals(""))
							{
									TableStr.append(" <td width='2%' bordercolor='black' border='1'><input type='button' value=\""+bed_no+"\" onMouseOver=\"displayToolTip(tips"+count_buttn+",this)\"  class='"+butt_color+"' onMouseOut ='hideToolTip()' style='width:6vw;' onclick='closeWin(unescape(retVal"+count_buttn+"),\""+butt_color+"\",\""+butt_color_1+"\",\""+main_bed_no+"\")'></td><td width='2%'  bordercolor='black' border='1'><input type='button'   class='"+butt_color_1+"' style='width:12;' onMouseOver=\"displayToolTip(tipb"+count_buttn+",this)\"  onMouseOut ='hideToolTip()'></td> ");
							}else{
									TableStr.append(" <td width='2%' bordercolor='black' border='1'><input type='button' value=\""+bed_no+"\" onMouseOver=\"displayToolTip(tips"+count_buttn+",this)\"  class='"+butt_color+"' onMouseOut ='hideToolTip()' style='width:6vw;' onclick='closeWin(unescape(retVal"+count_buttn+"),\""+butt_color+"\",\""+main_bed_no+"\")'></td><td width='2%'  bordercolor='black' border='1'></td> ");
								}
						}
						
						}else if(override.equals("N") && booking_status.equals("0") && booking_type.equals("L")){
						if(future_booking_for_bnu_yn.equals("Y")){
						
							TableStr.append(" <td width='2%' bordercolor='black' border='1'><input type='button' value=\""+bed_no+"\" onMouseOver=\"displayToolTip(tips"+count_buttn+",this)\"  class='"+butt_color+"' onMouseOut ='hideToolTip()' style='width:6vw;' onclick='closeWin(unescape(retVal"+count_buttn+"),\""+butt_color+"\",\""+butt_color_2+"\",\""+main_bed_no+"\")'></td><td width='2%'  bordercolor='black' border='1'><input type='button'   class='"+butt_color_2+"' style='width:12;' onMouseOver=\"displayToolTip(tipb"+count_buttn+",this)\"  onMouseOut ='hideToolTip()'></td> ");
						}else{
							if(!butt_color_2.equals(""))
							{
									TableStr.append(" <td width='2%' bordercolor='black' border='1'><input type='button' value=\""+bed_no+"\" onMouseOver=\"displayToolTip(tips"+count_buttn+",this)\"  class='"+butt_color+"' onMouseOut ='hideToolTip()' style='width:6vw;' onclick='closeWin(unescape(retVal"+count_buttn+"),\""+butt_color+"\",\""+butt_color_2+"\",\""+main_bed_no+"\")'></td><td width='2%'  bordercolor='black' border='1'><input type='button'   class='"+butt_color_2+"' style='width:12;' onMouseOver=\"displayToolTip(tipb"+count_buttn+",this)\"  onMouseOut ='hideToolTip()'></td> ");
							}else{
									TableStr.append(" <td width='2%' bordercolor='black' border='1'><input type='button' value=\""+bed_no+"\" onMouseOver=\"displayToolTip(tips"+count_buttn+",this)\"  class='"+butt_color+"' onMouseOut ='hideToolTip()' style='width:6vw;' onclick='closeWin(unescape(retVal"+count_buttn+"),\""+butt_color+"\",\""+main_bed_no+"\")'></td><td width='2%'  bordercolor='black' border='1'></td> ");
								}
						}
						
					}else if(override.equals("Y") && booking_status.equals("1") && booking_type.equals("L")){
						if(future_booking_for_boc_yn.equals("Y")){
						
							TableStr.append(" <td width='2%' bordercolor='black' border='1'><input type='button' value=\""+bed_no+"\" onMouseOver=\"displayToolTip(tips"+count_buttn+",this)\"  class='"+butt_color+"' onMouseOut ='hideToolTip()' style='width:6vw;' onclick='closeWin(unescape(retVal"+count_buttn+"),\""+butt_color+"\",\""+butt_color_3+"\",\""+main_bed_no+"\")'></td><td width='2%'  bordercolor='black' border='1'><input type='button'   class='"+butt_color_3+"' style='width:12;' onMouseOver=\"displayToolTip(tipb"+count_buttn+",this)\"  onMouseOut ='hideToolTip()'></td> ");
						}else{
							
							if(!butt_color_3.equals(""))
							{
									TableStr.append(" <td width='2%' bordercolor='black' border='1'><input type='button' value=\""+bed_no+"\" onMouseOver=\"displayToolTip(tips"+count_buttn+",this)\"  class='"+butt_color+"' onMouseOut ='hideToolTip()' style='width:6vw;' onclick='closeWin(unescape(retVal"+count_buttn+"),\""+butt_color+"\",\""+butt_color_3+"\",\""+main_bed_no+"\")'></td><td width='2%'  bordercolor='black' border='1'><input type='button'   class='"+butt_color_3+"' style='width:12;' onMouseOver=\"displayToolTip(tipb"+count_buttn+",this)\"  onMouseOut ='hideToolTip()'></td> ");
							}else{
									TableStr.append(" <td width='2%' bordercolor='black' border='1'><input type='button' value=\""+bed_no+"\" onMouseOver=\"displayToolTip(tips"+count_buttn+",this)\"  class='"+butt_color+"' onMouseOut ='hideToolTip()' style='width:6vw;' onclick='closeWin(unescape(retVal"+count_buttn+"),\""+butt_color+"\",\""+main_bed_no+"\")'></td><td width='2%'  bordercolor='black' border='1'></td> ");
								}
						}
					
					}else if(override.equals("Y") && booking_status.equals("0") && booking_type.equals("L")){
						if(future_booking_for_bou_yn.equals("Y")){
						
							TableStr.append(" <td width='2%' bordercolor='black' border='1'><input type='button' value=\""+bed_no+"\" onMouseOver=\"displayToolTip(tips"+count_buttn+",this)\"  class='"+butt_color+"' onMouseOut ='hideToolTip()' style='width:6vw;' onclick='closeWin(unescape(retVal"+count_buttn+"),\""+butt_color+"\",\""+butt_color_4+"\",\""+main_bed_no+"\")'></td><td width='2%'  bordercolor='black' border='1'><input type='button'   class='"+butt_color_4+"' style='width:12;' onMouseOver=\"displayToolTip(tipb"+count_buttn+",this)\"  onMouseOut ='hideToolTip()'></td> ");
						}else{
							
							if(!butt_color_4.equals(""))
							{
									TableStr.append(" <td width='2%' bordercolor='black' border='1'><input type='button' value=\""+bed_no+"\" onMouseOver=\"displayToolTip(tips"+count_buttn+",this)\"  class='"+butt_color+"' onMouseOut ='hideToolTip()' style='width:6vw;' onclick='closeWin(unescape(retVal"+count_buttn+"),\""+butt_color+"\",\""+butt_color_4+"\",\""+main_bed_no+"\")'></td><td width='2%'  bordercolor='black' border='1'><input type='button'   class='"+butt_color_4+"' style='width:12;' onMouseOver=\"displayToolTip(tipb"+count_buttn+",this)\"  onMouseOut ='hideToolTip()'></td> ");
							}else{
									TableStr.append(" <td width='2%' bordercolor='black' border='1'><input type='button' value=\""+bed_no+"\" onMouseOver=\"displayToolTip(tips"+count_buttn+",this)\"  class='"+butt_color+"' onMouseOut ='hideToolTip()' style='width:6vw;' onclick='closeWin(unescape(retVal"+count_buttn+"),\""+butt_color+"\",\""+main_bed_no+"\")'></td><td width='2%'  bordercolor='black' border='1'></td> ");
								}
						}
						
					}
					else if(override.equals("N") && booking_status.equals("1") && booking_type.equals("N"))
					{
						TableStr.append(" <td width='2%' bordercolor='black' border='1'><input type='button' value=\""+bed_no+"\" onMouseOver=\"displayToolTip(tips"+count_buttn+",this)\" class='"+butt_color+"' onMouseOut ='hideToolTip()' style='width:6vw;border-style: ridge' onclick='closeWin(unescape(retVal"+count_buttn+"),\""+butt_color+"\",\""+main_bed_no+"\")'> </td> ");
					}else if((override.equals("N") || override.equals("Y")) && booking_status.equals("0") && ( booking_type.equals("T") || booking_type.equals("D")) ){
						TableStr.append(" <td width='2%' bordercolor='black' border='1'><input type='button' value=\""+bed_no+"\" onMouseOver=\"displayToolTip(tips"+count_buttn+",this)\"  class='"+butt_color+"' onMouseOut ='hideToolTip()' style='width:6vw;' onclick='closeWin(unescape(retVal"+count_buttn+"),\""+butt_color+"\",\""+main_bed_no+"\")'></td><td width='2%'  bordercolor='black' border='1'></td> ");
					}
					else if((override.equals("N")||override.equals("Y")) && booking_status.equals("0") && booking_type.equals("B")){
						TableStr.append(" <td width='2%' bordercolor='black' border='1'><input type='button' value=\""+bed_no+"\" onMouseOver=\"displayToolTip(tips"+count_buttn+",this)\"  class='"+butt_color+"' onMouseOut ='hideToolTip()' style='width:6vw;' onclick='closeWin(unescape(retVal"+count_buttn+"),\""+butt_color+"\",\""+main_bed_no+"\")'></td><td width='2%'  bordercolor='black' border='1'></td> ");
					}
				
				if ( bed_col_num == 9)
				{
					bed_col_num = 0;
					TableStr.append("</tr><tr>");
				}

				bed_col_num++ ;
				count_buttn++ ;
				max_count ++ ;
			}
		}
		if(max_count == 0)
		{	%>
		<script> 
			resetValues(); 
			alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common')); 
		</script>
		<%	
		}
		//Maheshwaran K added for the HSA-CRF-0180.1 
		Boolean reason_for_movement_inline = CommonBean.isSiteSpecific(con, "IP","QUERY_BED_AVAIL");
	 
	%>	<input type='hidden' name='reason_for_movement_inline' id='reason_for_movement_inline' value='<%=reason_for_movement_inline%>'><!--Maheshwaran K added for the HSA-CRF-0180.1 -->
		<input type='hidden' name='consider_edd_stop_for_boc_yn' id='consider_edd_stop_for_boc_yn' value='<%=consider_edd_stop_for_boc_yn%>'>
		<input type='hidden' name='consider_edd_stop_for_bou_yn' id='consider_edd_stop_for_bou_yn' value='<%=consider_edd_stop_for_bou_yn%>'>
		<input type='hidden' name='consider_edd_stop_for_bnc_yn' id='consider_edd_stop_for_bnc_yn' value='<%=consider_edd_stop_for_bnc_yn%>'>
		<input type='hidden' name='consider_edd_stop_for_bnu_yn' id='consider_edd_stop_for_bnu_yn' value='<%=consider_edd_stop_for_bnu_yn%>'>
		<input type='hidden' name='action_for_boc' id='action_for_boc' value='<%=action_for_boc%>'>
		<input type='hidden' name='action_for_bou' id='action_for_bou' value='<%=action_for_bou%>'>
		<input type='hidden' name='action_for_bnc' id='action_for_bnc' value='<%=action_for_bnc%>'>
		<input type='hidden' name='action_for_bnu' id='action_for_bnu' value='<%=action_for_bnu%>'>
		<input type='hidden' name='future_booking_for_bnc_yn' id='future_booking_for_bnc_yn' value='<%=future_booking_for_bnc_yn%>'>
		<input type='hidden' name='future_booking_for_bnu_yn' id='future_booking_for_bnu_yn' value='<%=future_booking_for_bnu_yn%>'>
		<input type='hidden' name='future_booking_for_boc_yn' id='future_booking_for_boc_yn' value='<%=future_booking_for_boc_yn%>'>
		<input type='hidden' name='future_booking_for_bou_yn' id='future_booking_for_bou_yn' value='<%=future_booking_for_bou_yn%>'>
		
	<%	
		TableStr.append("</form></tr>");
		out.print(TableStr.toString());
	//	System.out.print("TableStr.toString()--->"+TableStr.toString());
		out.println("<script> resetValues(); </script>");

	if (rs != null) rs.close();
	if (rs_cnt != null) rs_cnt.close();
	if (disrs != null) disrs.close();
	if (dispstmt != null) dispstmt.close();
	if (param_rs != null) param_rs.close();
	if (stmt != null) stmt.close();	 
	if (stmt_cnt != null) stmt_cnt.close();
	if (pstmt != null) pstmt.close();
	if (param_stmt != null) param_stmt.close();

}catch(Exception e) {
	//out.println(e.toString());
	e.printStackTrace();}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
</table>
	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>
		<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
			<tr>
				<td width='100%' id='t'></td>
			</tr>
		</table>
	</div>
</body>
</html>
<%!  
	public String specialCharacter(String single)
	{
		/*
		int i=0;
		StringBuffer sb = new StringBuffer(single);
		for(int j = 0; single.indexOf('\'',i) != -1; j++)
		{
			i = single.indexOf('\'', i);
			sb.insert(i + j, "'");
			i++;
		}
		return (sb.toString());
		*/
		if(single == null) single = "";
		return single.replaceAll("'","''");
	}	
%>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

