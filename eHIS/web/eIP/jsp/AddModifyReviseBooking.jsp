<!DOCTYPE html>
<!--***** Function to Revise the Booking -- *******---> 
<%@ page import= " java.util.HashMap, java.util.ArrayList, webbeans.eCommon.ConnectionManager,java.util.*,java.sql.*,com.ehis.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<script src='../../eIP/js/IPPractitionerComponent.js' language='javascript'></script>
<!--Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013-->
<!--Start-->
<script src='../../eIP/js/Booking.js' language='javascript'></script>
<!--End-->
<script>
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
   // if (strCheck.indexOf(key) == -1) return true;  // Not a valid key
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
<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");

	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String locale				= (String)session.getAttribute("LOCALE");
	String sqlsd1				= "";
	String booking_ref_no		= "";
	String Sdate 				= "";
	String modifiedDate			= "";
	String facilityID			= (String)session.getValue("facility_id");
	String	loginUser				= (String)session.getAttribute("login_user");
	boolean isBlInterfaced		= false;
	String bl_operational		= "";
	String capture_fin_dtls_yn	= "";
	String bl_interfaced_yn		= "";
	String pre_op_days			= "";


	Connection	con		= null;
	Statement	stmt	= null;
    Statement	stmt1	= null;
	Statement	stmt2	= null;
	PreparedStatement pstmt = null;
	ResultSet	rs		= null;
    ResultSet	rs1		= null;
    ResultSet	rs2		= null;
	ResultSet   prs		= null;
	//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 24/01/2013
	//Start
	ResultSet rset			= null;
	Statement rstmt			= null;
	//End
	String queryString	= (String) session.getValue( "queryString" ) ;
	queryString			= checkForNull(queryString);
	session.removeAttribute("ipPatInstructionsMap");
	try
	{
		con			= ConnectionManager.getConnection(request);
		stmt		= con.createStatement();
		stmt1		= con.createStatement();
		stmt2		= con.createStatement();

		String DayVal				= ""; 
		String med_service_grp		= "";
		String preferred_date		= "";
		String nameprefix			= "";
		String firstname			= "";
		String secondname			= "";
		String thirdname			= "";
		String familyname			= "";
		String namesuffix			= "";
		String patientname			= "";
		String gender				= "";
		String specialty_code		= "";
		String date_of_birth		= "";
		String Practitioner_id		= "";
		String override_yn			= "";
		String ot_date_time			= "";
		String res_tel_no			= "";
		String email_id				= "";
		String national_id_no		= "";
		String alt_id1_no			= "";		
		String alt_id2_no			= "";
		String alt_id3_no			= "";		
		String alt_id4_no			= "";
		String alt_id1_exp_dt		= "";		
		String alt_id2_exp_dt		= "";
		String alt_id3_exp_dt		= "";		
		String alt_id4_exp_dt		= "";
		String oth_alt_id_no		= "";		
		String oth_alt_id_type		= "";
		String res_addr_line1		= "";
		String res_addr_line2		= "";
		String res_addr_line3		= "";
		String res_addr_line4		= "";
		String res_town_code		= "";		
		String res_town_desc		= "";
		String res_area_code		= "";		
		String res_area_desc		= "";
		String res_region_code		= "";		
		String res_region_desc		= "";
		String mail_addr_line1		= "";
		String mail_addr_line2		= "";
		String mail_addr_line3		= "";
		String mail_addr_line4		= "";
		String mail_town_code		= "";		
		String mail_town_desc		= "";
		String mail_area_code		= "";		
		String mail_area_desc		= "";
		String mail_region_code		= "";		
		String mail_region_desc		= ""; 
		String mail_postal_code		= "";
		String mail_postal_code_desc= "";
		String mail_country_code	= "";		
		String mail_country_desc	= "";
		String postal_code			= "";
		String postal_code_desc		= "";
		String country_code			= "";		
		String country_desc			= "";
		String other_tel_no			= "";
		String patient_id			= "";
		String pract_name			= "";
		String spl_name				= "";
		String medsershortdesc		= "";
		String chief_complaint		= "";
		String reason_revise		= "";
		String comp_desc			= "";
		String rev_desc				= "";
		String patientclasscode		= "";
		String team_code			= "";
		String nationality			= "";
		String nationality_desc		= "";
		String alt_id1_exp_date		= "";
		String exp_days_of_stay		= "";
		String referral_id			= "";
		String priority				= "";
		String booking_date_time	= "";
		String eth_grp				= "";
		String race_desc			= "";
		String race_code			= "";
		String birth_place_code		= "";		
		String birth_place_desc		= "";
		String citizen_yn			= "";		
		String legal_yn				= "";
		String ethic_desc			= "";
		String name_prefix_loc_lang	= "";
		String first_name_loc_lang	= "";
		String second_name_loc_lang	= "";
		String third_name_loc_lang	= "";
		String family_name_loc_lang	= "";
		String name_suffix_loc_lang	= "";
		String patient_name_loc_lang= "";
		String booking_date_time_converted = "";
		String preferred_date_converted = "";
		String date_of_birth_converted = "";
		String expected_discharge_date = "";
		String nursing_unit_code	= "";
		String nurs_unit_sdesc		= "";
		String bed_no				= "";
		String roomno				= "";
		String bed_type_code		= "";
		String bed_class_code		= "";
		String bed_class_desc		= "";
		String bed_type_desc		= "";
		String service_code			= "";
		String booking_remarks      = "";
		String booking_type_code    = "";
		//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 09/01/2013
		//Start
		String order_id="";
		String order_line_no="";
		String oper_code="";
		String oper_desc="";
		String pref_surg_date="";
		String disable_surg="";
		//End
		/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
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
		/*End*/
		ArrayList bookingtype_list	= new ArrayList();

		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
		java.util.Date dt=new java.util.Date();
		Sdate = dateFormat.format( dt ) ;
		Sdate=Sdate + " "+String.valueOf(dt.getHours())+":"+String.valueOf(dt.getMinutes());
		String bkg_lst_ref_no = checkForNull(request.getParameter("bkg_lst_ref_no"));
		String multi_book_pat_yn = checkForNull(request.getParameter("multi_book_pat_yn"));
		bl_interfaced_yn			= checkForNull(request.getParameter("bl_interfaced_yn"));	
		capture_fin_dtls_yn		= checkForNull(request.getParameter("capture_fin_dtls_yn"));	
		bl_operational			= (String)session.getValue("bl_operational");
		String p_oper_stn_id			= checkForNull(request.getParameter("oper_stn_id"));
        String chk_booking_limit_by		= checkForNull(request.getParameter("chk_booking_limit_by"));// code added  by  munisekhar for [IN:048232] 
		String block_bed_based_on	= checkForNull(request.getParameter("block_bed_based_on"));
		String deactivate_pseudo_bed_yn	= checkForNull(request.getParameter("deactivate_pseudo_bed_yn"),"N");

		String overdueCHk			= "";
		String max_patient_age		= "";
		int DAYS					= 0;
		int	MONTHS					= 0;
		int	AGE						= 0;		
		if(bl_interfaced_yn.equals("Y"))
			isBlInterfaced = true;
		else 
			isBlInterfaced = false;
		
		try
		{
			StringBuffer PatVal = new StringBuffer();
			// Changed By Vinod - 6/23/2006 11:39 AM
			PatVal.append("SELECT" );
			PatVal.append("  bkg_lst_ref_no" );
			PatVal.append("  , room_no" );
			PatVal.append("  , bed_no" );
			PatVal.append("  , med_ser_grp_code" );
			PatVal.append("  , exp_days_of_stay" );
			PatVal.append("  , priority_ind" );
			PatVal.append("  , ip_get_desc.IP_MEDICAL_SERVICE_GROUP (facility_id, MED_SER_GRP_CODE, '"+locale+"', 2) med_ser_short_desc" );
			PatVal.append("  , am_get_desc.am_speciality(specialty_code, '"+locale+"', 2) specialty_short_desc" );
			PatVal.append("  , am_get_desc.am_practitioner(practitioner_id, '"+locale+"', 1) practitioner_name" );
			PatVal.append("  , TO_CHAR(preferred_date,'dd/mm/rrrr hh24:mi') preferred_date" );
			PatVal.append("  , patient_id" );
			PatVal.append("  , name_prefix" );
			PatVal.append("  , first_name" );
			PatVal.append("  , second_name" );
			PatVal.append("  , third_name" );
			PatVal.append("  , family_name" );
			PatVal.append("  , name_suffix" );
			PatVal.append("  , patient_name" );
			PatVal.append("  , gender" );
			PatVal.append("  , TO_CHAR(date_of_birth, 'dd/mm/rrrr')date_of_birth" );
			PatVal.append("  , res_tel_no" );
			PatVal.append("  , oth_contact_no" );
			PatVal.append("  , email_id" );
			PatVal.append("  , national_id_no" );
			PatVal.append("  , alt_id1_no" );
			PatVal.append("  , ALT_ID2_NO" );
			PatVal.append("  , ALT_ID3_NO" );
			PatVal.append("  , ALT_ID4_NO" );
			PatVal.append("  , OTH_ALT_ID_TYPE" );
			PatVal.append("  , OTH_ALT_ID_NO" );
			PatVal.append("  , TO_CHAR(ALT_ID1_EXP_DATE,'dd/mm/rrrr') ALT_ID1_EXP_DATE" );
			PatVal.append("  , TO_CHAR(ALT_ID2_EXP_DATE,'dd/mm/rrrr') ALT_ID2_EXP_DATE" );
			PatVal.append("  , TO_CHAR(ALT_ID3_EXP_DATE,'dd/mm/rrrr') ALT_ID3_EXP_DATE" );
			PatVal.append("  , TO_CHAR(ALT_ID4_EXP_DATE,'dd/mm/rrrr') ALT_ID4_EXP_DATE" );
			PatVal.append("  , res_addr_line1" );
			PatVal.append("  , res_addr_line2" );
			PatVal.append("  , res_addr_line3" );
			PatVal.append("  , res_addr_line4" );
			PatVal.append("  , postal_code" );
			PatVal.append("  , mp_get_desc.mp_postal_code(postal_code,'"+locale+"',2)postal_code_desc " );
			PatVal.append("  , country_code" );
			PatVal.append("  , patient_class_code" );
			PatVal.append("  , specialty_code" );
			PatVal.append("  , practitioner_id" );
			PatVal.append("  , chief_complaint" );
			PatVal.append("  , am_get_desc.am_complaint (chief_complaint,'"+locale+"', '1'  ) complaint_desc" );
			PatVal.append("  , reason_for_revision_code" );
			PatVal.append("  , am_get_desc.am_contact_reason (reason_for_revision_code,'"+locale+"', '1'  ) contact_reason " );
			PatVal.append("  , citizen_yn" );
			PatVal.append("  , LEGAL_ILLEGAL_YN" );
			PatVal.append("  , TO_CHAR(ot_date_time,'dd/mm/rrrr hh24:mi') ot_date_time" );
			PatVal.append("  , override_yn" );
			PatVal.append("  , bed_class_code" );
			PatVal.append("  , ip_get_desc.ip_bed_class(bed_class_code, '"+locale+"', 2) bed_class_short_desc ");
			PatVal.append("  , bed_type_code" );
			PatVal.append("  , ip_get_desc.ip_bed_type(bed_type_code,'"+locale+"',2)bed_type_short_desc" );
			PatVal.append("  , nursing_unit_code" );
			PatVal.append("  , ip_get_desc.ip_nursing_unit(facility_id, nursing_unit_code, '"+locale+"', 2) nursing_unit_short_desc" );
			PatVal.append("  , nursing_unit_type_code" );
			PatVal.append("  , TO_CHAR(booking_date_time,'dd/mm/rrrr hh24:mi') booking_date_time" );
			PatVal.append("  , team_id" );
			PatVal.append("  , nationality_code" );
			PatVal.append("  , mp_get_desc.mp_country(nationality_code, '"+locale+"', 1) NATIONALITY_LONG_DESC" );
			PatVal.append("  , TO_CHAR(alt_id1_exp_date,'dd/mm/rrrr') alt_id1_exp_date" );
			PatVal.append("  , service_code" );
			PatVal.append("  , alt_id1_type" );
			PatVal.append("  , modified_date modified_date" );
			PatVal.append("  , RES_TOWN_CODE" );
			PatVal.append("  , RES_AREA_CODE" );
			PatVal.append("  , RES_REGION_CODE" );
			PatVal.append("  , MAIL_ADDR_LINE1" );
			PatVal.append("  , MAIL_ADDR_LINE2" );
			PatVal.append("  , MAIL_ADDR_LINE3" );
			PatVal.append("  , MAIL_ADDR_LINE4" );
			PatVal.append("  , MAIL_TOWN_CODE" );
			PatVal.append("  , MAIL_AREA_CODE" );
			PatVal.append("  , MAIL_REGION_CODE" );
			PatVal.append("  , MAIL_POSTAL_CODE" );
			PatVal.append("  , mp_get_desc.mp_postal_code(MAIL_POSTAL_CODE,'"+locale+"',2)mail_postal_code_desc" );
			PatVal.append("  , MAIL_COUNTRY_CODE" );
			PatVal.append("  , ETHNIC_GRP_CODE" );
			PatVal.append("  , mp_get_desc.mp_ethnic_group(ethnic_grp_code, '"+locale+"', 1) ETHNIC_GROUP_DESC" );
			PatVal.append("  , RACE_CODE" );
			PatVal.append("  , mp_get_desc.mp_race(race_code, '"+locale+"', 1) RACE_DESC" );
			PatVal.append("  , mp_get_desc.mp_res_town(res_town_code, '"+locale+"',1) RES_TOWN_DESC" );
			PatVal.append("  , mp_get_desc.mp_res_area(res_area_code, '"+locale+"',1) RES_AREA_DESC" );
			PatVal.append("  , mp_get_desc.mp_region(res_region_code, '"+locale+"',1) RES_REGION_DESC" );
			PatVal.append("  , mp_get_desc.mp_country(country_code, '"+locale+"', 1) RES_COUNTRY_NAME" );
			PatVal.append("  , mp_get_desc.mp_res_town(mail_town_code, '"+locale+"',1) MAIL_TOWN_DESC" );
			PatVal.append("  , mp_get_desc.mp_res_area(mail_area_code, '"+locale+"',1) MAIL_AREA_DESC" );
			PatVal.append("  , mp_get_desc.mp_region(mail_region_code, '"+locale+"',1) MAIL_REGION_DESC" );
			PatVal.append("  , mp_get_desc.mp_country(mail_country_code, '"+locale+"', 1) MAIL_COUNTRY_DESC" );
			PatVal.append("  , referral_id" );
			PatVal.append("  , BIRTH_PLACE_CODE" );
			PatVal.append("  , mp_get_desc.mp_birth_place(birth_place_code, '"+locale+"', 1) BIRTH_PLACE_DESC" );
			PatVal.append("  ,TO_CHAR(sysdate,'dd/mm/rrrr ') sdate " );
			PatVal.append("  , NAME_PREFIX_LOC_LANG ");
			PatVal.append("  , FIRST_NAME_LOC_LANG ");
			PatVal.append("  , SECOND_NAME_LOC_LANG ");
			PatVal.append("  , THIRD_NAME_LOC_LANG ");
			PatVal.append("  , FAMILY_NAME_LOC_LANG ");
			PatVal.append("  , NAME_SUFFIX_LOC_LANG ");
			PatVal.append("  , PATIENT_NAME_LOC_LANG ");
			PatVal.append("  , TO_CHAR(EXPECTED_DISCHARGE_DATE,'dd/mm/rrrr hh24:mi') EXPECTED_DISCHARGE_DATE ");
			PatVal.append("  ,round(ot_date_time-preferred_date) pre_op_days ");
			PatVal.append("  ,DIAGNOSIS_REMARKS ");
			PatVal.append("  ,booking_type_code ");
			/*Wednesday, June 23, 2010,IN022062*/
			PatVal.append("  ,(select max_patient_age from mp_param where module_id = 'MP') max_patient_age ");
			PatVal.append("  , calculate_age(TO_CHAR(date_of_birth,'dd/mm/rrrr'),1) Years" );
			PatVal.append("  , calculate_age(TO_CHAR(date_of_birth,'dd/mm/rrrr'),2) Months" );
			PatVal.append("  , calculate_age(TO_CHAR(date_of_birth,'dd/mm/rrrr'),3) Days" );
			/**/
			//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 09/01/2013
			//Start
			PatVal.append("  , order_id order_id,order_line_no order_line_no,oper_code oper_code,oper_short_desc oper_desc, TO_CHAR (pref_surg_date, 'dd/mm/yyyy') pref_surg_date  " );
			//End
			/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
			PatVal.append("  , alt_addr_line1" );
			PatVal.append("  , alt_addr_line2" );
			PatVal.append("  , alt_addr_line3" );
			PatVal.append("  , alt_addr_line4" );
			PatVal.append("  , alt_town_code" );
			PatVal.append("  , mp_get_desc.MP_RES_TOWN(alt_town_code,'"+locale+"','1') alt_town_desc" );
			PatVal.append("  , alt_area_code" );
			PatVal.append("  , mp_get_desc.MP_RES_AREA(alt_area_code,'"+locale+"','1') alt_area_desc" );
			PatVal.append("  , alt_region_code" );
			PatVal.append("  , mp_get_desc.MP_REGION(alt_region_code,'"+locale+"','1') alt_region_desc" );
			PatVal.append("  , alt_postal_code" );
			PatVal.append("  , mp_get_desc.MP_POSTAL_CODE(alt_postal_code,'"+locale+"',2) alt_postal_desc" );
			PatVal.append("  , alt_country_code" );
			PatVal.append("  , mp_get_desc.MP_COUNTRY(alt_country_code,'"+locale+"','1') alt_country_desc" );
			/*End*/
			PatVal.append(" FROM " );
			PatVal.append("  IP_BOOKING_LIST " );
			/*Monday, April 26, 2010 , commented for PE since mp_param is not used in the query to get data*/
			//PatVal.append("  , MP_PARAM " );
			PatVal.append("WHERE facility_id = '"+facilityID+"' " );
			PatVal.append("  AND bkg_lst_ref_no = '"+bkg_lst_ref_no+"'" );
			stmt = con.createStatement();
			rs= stmt.executeQuery(PatVal.toString());



		}catch(Exception e){
			//out.println("error"+ e.toString());
			e.printStackTrace();}
		while (rs.next())
		{		
			nameprefix				= checkForNull(rs.getString("name_prefix"));
			firstname				= checkForNull(rs.getString("first_name"));
			secondname				= checkForNull(rs.getString("second_name"));
			thirdname				= checkForNull(rs.getString("third_name"));
			familyname				= checkForNull(rs.getString("family_name"));
			namesuffix				= checkForNull(rs.getString("name_suffix"));
			patientname				= checkForNull(rs.getString("patient_name"));
			gender					= checkForNull(rs.getString("gender"));
			med_service_grp			= checkForNull(rs.getString("med_ser_grp_code"));
			medsershortdesc			= checkForNull(rs.getString("med_ser_short_desc"));
			preferred_date			= checkForNull(rs.getString("preferred_date"));
			if(!(preferred_date==null || preferred_date.equals("")))
				preferred_date_converted = DateUtils.convertDate(preferred_date,"DMYHM","en",locale);		
			exp_days_of_stay		= checkForNull(rs.getString("exp_days_of_stay"));
			referral_id				= checkForNull(rs.getString("referral_id"));
			priority				= checkForNull(rs.getString("priority_ind"));
			booking_ref_no			= checkForNull(rs.getString("bkg_lst_ref_no"));
			date_of_birth			= checkForNull(rs.getString("date_of_birth"));
			if(!(date_of_birth==null || date_of_birth.equals("")))
				date_of_birth_converted = DateUtils.convertDate(date_of_birth,"DMY","en",locale);		
			Practitioner_id			= checkForNull(rs.getString("Practitioner_id"));
			pract_name				= checkForNull(rs.getString("practitioner_name"));
			specialty_code			= checkForNull(rs.getString("specialty_code"));
			spl_name				= checkForNull(rs.getString("specialty_short_desc"));
			ot_date_time			= checkForNull(rs.getString("ot_date_time"));
			if(!(ot_date_time==null || ot_date_time.equals("")))
				ot_date_time = DateUtils.convertDate(ot_date_time,"DMYHM","en",locale);	
			res_tel_no				= checkForNull(rs.getString("res_tel_no"));
			other_tel_no			= checkForNull(rs.getString("oth_contact_no"));
			email_id				= checkForNull(rs.getString("email_id"));
			national_id_no			= checkForNull(rs.getString("national_id_no"));
			alt_id1_no				= checkForNull(rs.getString("alt_id1_no"));
			alt_id2_no				= checkForNull(rs.getString("alt_id2_no"));
			alt_id3_no				= checkForNull(rs.getString("alt_id3_no"));
			alt_id4_no				= checkForNull(rs.getString("alt_id4_no"));

			alt_id1_exp_dt			= checkForNull(rs.getString("ALT_ID1_EXP_DATE"));
			alt_id2_exp_dt			= checkForNull(rs.getString("ALT_ID2_EXP_DATE"));
			alt_id3_exp_dt			= checkForNull(rs.getString("ALT_ID3_EXP_DATE"));
			alt_id4_exp_dt			= checkForNull(rs.getString("ALT_ID4_EXP_DATE"));
			//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 09/01/2013
			//Start
			order_id=checkForNull(rs.getString("order_id"));
			order_line_no=checkForNull(rs.getString("order_line_no"));
			oper_code=checkForNull(rs.getString("oper_code"));
			oper_desc=checkForNull(rs.getString("oper_desc"));		
			pref_surg_date=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("pref_surg_date"),"DMY","en",locale));	
			//End	
			if(!(alt_id1_exp_dt==null || alt_id1_exp_dt.equals("")))
				alt_id1_exp_dt = DateUtils.convertDate(alt_id1_exp_dt,"DMY","en",locale);	

			if(!(alt_id2_exp_dt==null || alt_id2_exp_dt.equals("")))
				alt_id2_exp_dt = DateUtils.convertDate(alt_id2_exp_dt,"DMY","en",locale);	

			if(!(alt_id3_exp_dt==null || alt_id3_exp_dt.equals("")))
				alt_id3_exp_dt = DateUtils.convertDate(alt_id3_exp_dt,"DMY","en",locale);
				
			if(!(alt_id4_exp_dt==null || alt_id4_exp_dt.equals("")))
				alt_id4_exp_dt = DateUtils.convertDate(alt_id4_exp_dt,"DMY","en",locale);

			oth_alt_id_no			= checkForNull(rs.getString("OTH_ALT_ID_NO"));
			oth_alt_id_type			= checkForNull(rs.getString("OTH_ALT_ID_TYPE"));
			res_addr_line1			= checkForNull(rs.getString("res_addr_line1"));
			res_addr_line2			= checkForNull(rs.getString("res_addr_line2"));
			res_addr_line3			= checkForNull(rs.getString("res_addr_line3"));
			res_addr_line4			= checkForNull(rs.getString("res_addr_line4"));
			postal_code				= checkForNull(rs.getString("postal_code"));
			postal_code_desc		= checkForNull(rs.getString("postal_code_desc"));
			country_code			= checkForNull(rs.getString("country_code"));
			country_desc			= checkForNull(rs.getString("RES_COUNTRY_NAME")); 
			patient_id				= checkForNull(rs.getString("patient_id"));
			chief_complaint			= checkForNull(rs.getString("chief_complaint"));
			comp_desc				= checkForNull(rs.getString("complaint_desc"));
			reason_revise			= checkForNull(rs.getString("reason_for_revision_code"));
			rev_desc				= checkForNull(rs.getString("contact_reason"));
			patientclasscode		= checkForNull(rs.getString("patient_class_code"));
			team_code				= checkForNull(rs.getString("team_id"));     
			nationality				= checkForNull(rs.getString("nationality_code"));
			nationality_desc		= checkForNull(rs.getString("NATIONALITY_LONG_DESC"));
			alt_id1_exp_date		= checkForNull(rs.getString("alt_id1_exp_date"));
			booking_date_time		= checkForNull(rs.getString("booking_date_time"));
			if(!(booking_date_time==null || booking_date_time.equals("")))
				booking_date_time_converted = DateUtils.convertDate(booking_date_time,"DMYHM","en",locale);

			modifiedDate			= checkForNull(rs.getString("modified_date"));
			res_town_code			= checkForNull(rs.getString("RES_TOWN_CODE"));
			res_town_desc			= checkForNull(rs.getString("RES_TOWN_DESC"));
			res_area_code			= checkForNull(rs.getString("RES_AREA_CODE"));
			res_area_desc			= checkForNull(rs.getString("RES_AREA_DESC"));
			res_region_code			= checkForNull(rs.getString("RES_REGION_CODE"));
			res_region_desc			= checkForNull(rs.getString("RES_REGION_DESC"));	
			mail_addr_line1			= checkForNull(rs.getString("MAIL_ADDR_LINE1"));
			mail_addr_line2			= checkForNull(rs.getString("MAIL_ADDR_LINE2"));
			mail_addr_line3			= checkForNull(rs.getString("MAIL_ADDR_LINE3"));
			mail_addr_line4			= checkForNull(rs.getString("MAIL_ADDR_LINE4"));
			mail_town_code			= checkForNull(rs.getString("MAIL_TOWN_CODE"));
			mail_town_desc			= checkForNull(rs.getString("MAIL_TOWN_DESC"));
			mail_area_code			= checkForNull(rs.getString("MAIL_AREA_CODE"));
			mail_area_desc			= checkForNull(rs.getString("MAIL_AREA_DESC"));
			mail_region_code		= checkForNull(rs.getString("MAIL_REGION_CODE"));
			mail_region_desc		= checkForNull(rs.getString("MAIL_REGION_DESC"));
			mail_postal_code		= checkForNull(rs.getString("MAIL_POSTAL_CODE"));
			mail_postal_code_desc	= checkForNull(rs.getString("mail_postal_code_desc"));
			mail_country_code		= checkForNull(rs.getString("MAIL_COUNTRY_CODE"));
			mail_country_desc		= checkForNull(rs.getString("MAIL_COUNTRY_DESC"));
			eth_grp					= checkForNull(rs.getString("ETHNIC_GRP_CODE"));
			ethic_desc				= checkForNull(rs.getString("ETHNIC_GROUP_DESC"));
			race_code				= checkForNull(rs.getString("RACE_CODE"));
			race_desc				= checkForNull(rs.getString("RACE_DESC"));
			birth_place_code		= checkForNull(rs.getString("BIRTH_PLACE_CODE"));
			birth_place_desc		= checkForNull(rs.getString("BIRTH_PLACE_DESC"));
			citizen_yn				= checkForNull(rs.getString("CITIZEN_YN"));
			legal_yn				= checkForNull(rs.getString("LEGAL_ILLEGAL_YN"));
			sqlsd1					= checkForNull(rs.getString("sdate"));		
			name_prefix_loc_lang	= checkForNull(rs.getString("name_prefix_loc_lang"));
			first_name_loc_lang		= checkForNull(rs.getString("first_name_loc_lang"));
			second_name_loc_lang	= checkForNull(rs.getString("second_name_loc_lang"));
			third_name_loc_lang		= checkForNull(rs.getString("third_name_loc_lang"));
			family_name_loc_lang	= checkForNull(rs.getString("family_name_loc_lang"));
			name_suffix_loc_lang	= checkForNull(rs.getString("name_suffix_loc_lang"));
			patient_name_loc_lang	= checkForNull(rs.getString("patient_name_loc_lang"));
			nursing_unit_code		= checkForNull(rs.getString("nursing_unit_code"));
			nurs_unit_sdesc			= checkForNull(rs.getString("nursing_unit_short_desc"));
			roomno					= checkForNull(rs.getString("room_no"));
			bed_no					= checkForNull(rs.getString("bed_no"));
			bed_type_code		    = checkForNull(rs.getString("bed_type_code")); 
			bed_class_code			= checkForNull(rs.getString("bed_class_code"));
			bed_class_desc			= checkForNull(rs.getString("bed_class_short_desc"));
			bed_type_desc		    = checkForNull(rs.getString("BED_TYPE_SHORT_DESC")); 
			service_code			= checkForNull(rs.getString("service_code"));					
			expected_discharge_date	= checkForNull(rs.getString("EXPECTED_DISCHARGE_DATE"));
			if(!(expected_discharge_date==null || expected_discharge_date.equals("")))
				expected_discharge_date = DateUtils.convertDate(expected_discharge_date,"DMYHM","en",locale);
			/*Wednesday, June 23, 2010,IN022062*/
			max_patient_age			= rs.getString("max_patient_age");
			AGE						= rs.getInt("Years");
			MONTHS					= rs.getInt("Months");
			DAYS					= rs.getInt("Days");
			/**/
			pre_op_days				= checkForNull(rs.getString("pre_op_days"));
			
			if(pre_op_days==null || pre_op_days.equals(""))
				pre_op_days = "0";

			booking_remarks         = checkForNull(rs.getString("DIAGNOSIS_REMARKS"));
			booking_type_code       = checkForNull(rs.getString("booking_type_code"));
			/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
			alt_addr_line1		= checkForNull(rs.getString("alt_addr_line1"));
			alt_addr_line2		= checkForNull(rs.getString("alt_addr_line2"));
			alt_addr_line3		= checkForNull(rs.getString("alt_addr_line3"));
			alt_addr_line4		= checkForNull(rs.getString("alt_addr_line4"));
			alt_area_code		= checkForNull(rs.getString("alt_area_code"));
			alt_area_desc		= checkForNull(rs.getString("alt_area_desc"));
			alt_town_code		= checkForNull(rs.getString("alt_town_code"));
			alt_town_desc		= checkForNull(rs.getString("alt_town_desc"));
			alt_region_code		= checkForNull(rs.getString("alt_region_code"));
			alt_region_desc		= checkForNull(rs.getString("alt_region_desc"));
			alt_postal_code		= checkForNull(rs.getString("alt_postal_code"));
			alt_postal_desc		= checkForNull(rs.getString("alt_postal_desc"));
			alt_country_code	= checkForNull(rs.getString("alt_country_code"));
			alt_country_desc	= checkForNull(rs.getString("alt_country_desc"));
			/*End*/
		}



		if (rs!=null) rs.close();
		if (stmt!=null) stmt.close();
		/*
		StringBuffer sqlsb = new StringBuffer();
		sqlsb.append("select complaint_code ,complaint_desc from ");
		sqlsb.append("am_complaint_lang_vw where language_id='"+locale+"' and eff_status ='E' and ");
		sqlsb.append("complaint_code = '"+chief_complaint+"'");
		rs.close();
		stmt.close();
		stmt = con.createStatement();
		rs= stmt.executeQuery(sqlsb.toString());
		
		if (rs.next())
		{
			comp_desc = rs.getString("complaint_desc");
		}	
		if (rs!=null) rs.close();
		if (stmt!=null) stmt.close();
		//This query is used for populating the revise reason
		StringBuffer sqlrevise = new StringBuffer();
		sqlrevise.append("select CONTACT_REASON_CODE, CONTACT_REASON ");
		sqlrevise.append("from AM_CONTACT_REASON_LANG_VW where language_id='"+locale+"' and ");
		sqlrevise.append(" REASON_FOR_REVISE_BKG_YN = 'Y' and "); 
		sqlrevise.append(" CONTACT_REASON_CODE = '"+reason_revise+"'"); 
		rs.close();
		stmt.close();
		stmt = con.createStatement();
		rs= stmt.executeQuery(sqlrevise.toString());
		
		if (rs.next())
		{
			rev_desc = rs.getString("CONTACT_REASON");
		}	
		if (rs!=null) rs.close();
		if (stmt!=null) stmt.close();
		*/

		try
		{
			StringBuffer sqlsb = new StringBuffer();
			if(sqlsb.length() > 0) sqlsb.delete(0,sqlsb.length());
			sqlsb.append("select booking_type_code,ip_get_desc.ip_booking_type(booking_type_code,?,'2')short_desc from ip_booking_type where eff_status = 'E' order by 2");
			pstmt =   con.prepareStatement(sqlsb.toString());	
			pstmt.setString(1,locale);
			rs   = pstmt.executeQuery();

			if(rs != null)
			{
				while(rs.next())
				{
					bookingtype_list.add(checkForNull(rs.getString(1)));
					bookingtype_list.add(checkForNull(rs.getString(2)));
				}
			}
				if(rs != null)	rs.close();
				if(pstmt != null) pstmt.close();
		}catch(Exception e)
		{
				

				e.printStackTrace();
		}

		// Below code add for the for this incident 17333

		if(bed_no.equals(""))
			  overdueCHk="disabled";
		else
			overdueCHk="";
			//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 24/01/2013
	//Start
	try
		{
		//Maheshwaran K modified  for the Inci No : RUT-SCF-0258 [IN:039356] as on 15/04/2013
		String ot_sql="SELECT  a.order_id order_id,c.order_line_no order_line_no,b.oper_code oper_code,b.short_desc oper_desc, TO_CHAR (a.pref_surg_date, 'dd/mm/yyyy') pref_surg_date  FROM ot_pending_orders_vw a, ot_oper_mast_lang_vw b , ot_pending_order_line c WHERE a.language_id = '"+locale+"'  AND b.language_id = '"+locale+"' AND a.performing_facility_id = '"+facilityID+"' and b.order_catalog_code=c.order_catalog_code  and a.order_id=c.order_id  AND b.order_catalog_code IN (SELECT order_catalog_code   FROM ot_pending_order_line WHERE order_id = a.order_id AND ROWNUM = 1)  AND a.pref_surg_date BETWEEN TO_DATE (NVL (to_char(SYSDATE,'DD/MM/YYYY'), '01/01/1900') || '00:00','DD/MM/YYYY HH24:MI') AND TO_DATE (NVL ('', '01/01/3000') || '23:59','DD/MM/YYYY HH24:MI') and a.patient_id='"+patient_id+"' and a.order_id in (select order_id from ip_booking_list where patient_id='"+patient_id+"' and facility_id='"+facilityID+"'and order_id is not null and bkg_lst_ref_no='"+bkg_lst_ref_no+"') and a.patient_id = (SELECT  x.patient_id FROM ot_pending_orders_vw x, ot_oper_mast_lang_vw y ,ot_pending_order_line z WHERE x.language_id = '"+locale+"'  AND y.language_id = '"+locale+"' AND x.performing_facility_id = '"+facilityID+"' AND y.order_catalog_code = z.order_catalog_code  AND x.order_id = z.order_id AND y.order_catalog_code IN (SELECT order_catalog_code   FROM ot_pending_order_line WHERE order_id = x.order_id AND ROWNUM = 1)  AND x.pref_surg_date BETWEEN TO_DATE (NVL (to_char(SYSDATE,'DD/MM/YYYY'), '01/01/1900') || '00:00','DD/MM/YYYY HH24:MI') AND TO_DATE (NVL ('', '01/01/3000') || '23:59','DD/MM/YYYY HH24:MI') and x.patient_id='"+patient_id+"' group by x.patient_id having count(x.patient_id)=1) ";
		rstmt=con.createStatement();
		rset=rstmt.executeQuery(ot_sql);
		}
	catch(SQLException e)	
		{
		//System.out.println("Exception occurred while executing the query to get Surgery Order Details : "+e);
		e.printStackTrace();
		}
	try
		{
		if(order_id.equals(""))
			{
			if(rset!=null)
				{
				if(rset.next())
					{
					order_id=checkForNull(rset.getString("order_id"));
					order_line_no=checkForNull(rset.getString("order_line_no"));
					oper_code=checkForNull(rset.getString("oper_code"));
					oper_desc=checkForNull(rset.getString("oper_desc"));		
					pref_surg_date=checkForNull(com.ehis.util.DateUtils.convertDate(rset.getString("pref_surg_date"),"DMY","en",locale));	
				//	disable_surg="disabled";//Maheshwaran K commented for the Inci No : RUT-SCF-0258 [IN:039356] as on 15/04/2013
					}
				//else//Maheshwaran K commented for the Inci No : RUT-SCF-0258 [IN:039356] as on 15/04/2013
					//{
					//disable_surg="";
				//	}
				}
			}	
		rstmt.close();
		rset.close();
		}
	catch(SQLException e)	
		{
		//System.out.println("Exception occurred while getting the Surgery Order Details  : "+e);
		e.printStackTrace();
		}	
	finally
		{
		try
			{if(rstmt!=null)
			rstmt.close();
			}
		catch(Exception e)	
			{
				e.printStackTrace();
			}
		}
	//End
%>

<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
	<script src="../../eCommon/js/dchk.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src="../../eIP/js/ReviseBooking.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<TITLE><fmt:message key="eIP.ReviseBookingDetails.label" bundle="${ip_labels}"/></TITLE>
</HEAD>
<BODY onLoad ="DisHome('N');PatDetDisab();Control_NursingUnit();checkPatInstns();" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='revisebooking_form' id='revisebooking_form' action='../../servlet/eIP.ReviseBookingServlet' method='post' target='messageFrame'> 
<%
		if(bl_operational.equals("Y") && capture_fin_dtls_yn.equals("Y"))
		{ %>
		
		<a name='tab1' id='tab1'></a>
		<ul id='tablist' class='tablist' style="padding-left:0px;">
			<li class='tablistitem' title='Booking Details'>
				<a class='tabClicked' id="booking_tab"  onclick="tab_click('booking_tab')">
					<span class='tabSpanclicked'><fmt:message key="Common.booking.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<li class='tablistitem' title='Financial Details'>
				<a class='tabA' id="findtl_tab" onclick="tab_click('findtl_tab')">
					<span class='tabASpan'><fmt:message key="Common.financialdetails.label" bundle="${common_labels}"/></span>
				</a>
			</li>
		</ul>
			
		<%}
	%>
<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
		<tr>
		<td  class='label' width='20%' ><fmt:message key="eIP.ProcedureSurgeryDateTime.label" bundle="${ip_labels}"/></td>
			<td class='field' width='20%'>
			<input type=text  id =otdatetime name='ot_date_time' id='ot_date_time'  onBlur='doOTDateTimeChk2(this);' size="16" maxlength='16'  value='<%=ot_date_time%>' ><img name ="ambul" src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].ot_date_time.focus();return showCalendar('otdatetime',null,'hh:mm');" ></img> 
			</td>
			<td width='10%' class='label'></td>
			<td  class='label' width='20%'><fmt:message key="eIP.PreOpPreparationDays.label" bundle="${ip_labels}"/></td>
			<td class='fields' width='20%' ><INPUT TYPE='text' value='<%=pre_op_days%>' name='pre_op_days' size="3" maxlength="3"  onKeyPress='return(ChkNumberInput(this,event,0))'  onBlur="CheckNum(this);displayDefaultValue(this);calcPrefDateForPreparationDay1();"></td>
			</tr>
	<tr>
			<td  class='label' width='20%'><fmt:message key="eIP.PrefAdmDateTime.label" bundle="${ip_labels}"/></td>
			<td  class='field' width='20%'><input type="hidden" name ="sdate" value='<%=sqlsd1%>'><INPUT TYPE="text"  id =prefadmdate name="pref_adm_date" id="pref_adm_date" value="" size="16" maxlength='16'  onBlur='Allfunc(this,document.forms[0].sdate2);calcDate(this);'  onKeyPress='return(ChkNumberInput1(this,event,2))'><img name ="ambul" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('prefadmdate',null,'hh:mm');" ></img><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
			<td  width='10%' id="DayVal" class="Querydata" ><%=DayVal%></td>
			<%	if(referral_id != "") 
			{	%>
				<td class='label' width='20%' ><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></td>  
				<td class='QUERYDATA' width='20%' ><%=referral_id%></td>
		<%	}else{	%>
				<td class='label'  width='20%' ></td>   	
				<td class='label' width='20%'></td>		
		<% } %>
			
			
			<!--<td width='15' class='label'></td>				
			<td class='label' width='15%' ><fmt:message key="eIP.ExpdaysofStay.label" bundle="${ip_labels}"/></td>

			<td  width='15%' class='field'><input type='text' name='exp_days_of_stay' id='exp_days_of_stay' value='<%=exp_days_of_stay%>' size='3' maxlength='3' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="CheckNum(this);CheckZeroVal(this);displayDefaultValue(this);calcDate(this);"></td>-->
	</tr>
	<!--<tr>
		<%	if(referral_id != "") 
			{	%>
				<td class='label' ><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></td>  
				<td class='QUERYDATA'  ><%=referral_id%></td>
				<td class='label'   >&nbsp;</td>   	
				<td class='label'>&nbsp;</td>		
				<td class='QUERYDATA'  >&nbsp;</td>
				<td class='QUERYDATA'  >&nbsp;</td>
		<%	}	%>
	</tr>-->
	<tr>
			<td  class='label' width='20%'><fmt:message key="eIP.MedicalServiceGroup.label" bundle="${ip_labels}"/></td>
			<td  class='QUERYDATA' width='20%'><%=medsershortdesc%><input type = 'hidden' value = "<%=med_service_grp%>" name = 'med_service_grp'></td>
			<td class='label' width='10%'></td>
			 <!--<td class="label" ><fmt:message key="eIP.ExpectedDischargeDateTime.label" bundle="${ip_labels}"/></td>	  
			<td  class='field' ><input type='text' name='exp_discharge_date' id='exp_discharge_date' id='exp_discharge_date_id' value="<%=expected_discharge_date%>" size='16' maxlength='16' readonly></td>	-->
			<td class='label'   width='20%'><fmt:message key="eIP.BookingRef.label" bundle="${ip_labels}"/></td>
			<td class = 'QUERYDATA'  width='20%'><%=booking_ref_no%></td>
			<input type= 'hidden' value="<%=booking_ref_no%>" name = 'booking_ref_no'>
	 </tr>
	 <tr>
			<td class='label' width='20%'><fmt:message key="eIP.ExpdaysofStay.label" bundle="${ip_labels}"/></td>
			<td  class='field' width='20%'><input type='text' name='exp_days_of_stay' id='exp_days_of_stay' value='<%=exp_days_of_stay%>' size='3' maxlength='3' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="CheckNum(this);CheckZeroVal(this);displayDefaultValue(this);calcDate(this);"></td>
			<td class='label' width='10%'></td>
			<td class="label" width='20%'><fmt:message key="eIP.ExpectedDischargeDateTime.label" bundle="${ip_labels}"/></td>	  
			<td  class='field' width='20%'><input type='text' name='exp_discharge_date' id='exp_discharge_date' id='exp_discharge_date_id' value="<%=expected_discharge_date%>" size='16' maxlength='16' readonly></td>	 
	 </tr>
	 <tr>
			<td  class='label'  width='20%'><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
			<td  class='field'  width='20%'><select name="priority" id="priority">
			<%  if(priority.equals("U")) {		%>
					<option value="N"><fmt:message key="Common.nonurgent.label" bundle="${common_labels}"/>  </option>
					<option value="U" selected><fmt:message key="Common.urgent.label" bundle="${common_labels}"/>  </option>
			<%	} if(priority.equals("N"))	{	%>
					<option value="N" selected><fmt:message key="Common.nonurgent.label" bundle="${common_labels}"/>  </option>
					<option value="U"><fmt:message key="Common.urgent.label" bundle="${common_labels}"/>  </option>
			<%		}	%>	   
			</td>
			<td class='label'  width='10%'></td>	
			<td class='label'  width='20%'><fmt:message key="eIP.BookingDateTime.label" bundle="${ip_labels}"/></td>  
			<td   class = 'QUERYDATA'  width='20%'><%=booking_date_time_converted%> </td>
	</tr>
 </table>
	
<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
	<tr>
			<td class="COLUMNHEADER" colspan='5'><b><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></b></td>
	</tr>
	<tr>
			<td  colspan='5' class='fields'><jsp:include page="../../eMP/jsp/natAltIDComponent.jsp" ><jsp:param name="flush" value="true" /></jsp:include></td>
	</tr>
</table>

<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
	<tr>
			<td class="COLUMNHEADER" colspan='5'><b><fmt:message key="eIP.BookingDetails.label" bundle="${ip_labels}"/></b></td>
	</tr>
	<tr>
			<td  class='label'  width='20%' ><fmt:message key="eIP.ReasonforAdmissionBooking.label" bundle="${ip_labels}"/></td>
			<td  class='QUERYDATA'  width='20%' style = 'word-break:break-all;'><input type=hidden name='complaintcode' id='complaintcode' ><%= comp_desc%></td>
			<td class='label'  width='10%'></td>
			<td  class='label'  width='20%' ><fmt:message key="Common.ReasonforRevision.label" bundle="${common_labels}"/></td>
			<td   width='20%' class='fields'><input type="text" name='rev_txt' id='rev_txt' size="17"  maxLength="200"  onBlur="RevisionLookupBlur();"><input type=button name='rev_btn' id='rev_btn' value='?' class=button onClick="if(document.forms[0].rev_txt.value == '')RevisionLookup();"><input type=hidden name='rev_txt_hid' id='rev_txt_hid'><input type=hidden name='rev_hid' id='rev_hid' ><img  src='../../eCommon/images/mandatory.gif' align='center'></img></td>
	</tr>
	<tr>
			<td  class='label'  width='20%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td  class= 'QUERYDATA'  width='20%'><input type="text" name='Splcode_desc' id='Splcode_desc' value = '<%=spl_name%>' maxlength="15" size="15" onBlur="SpecialtyLookupBlur();"><input type=button name='Splcode_lookup' id='Splcode_lookup' value='?' class=button onClick="if(document.forms[0].Splcode_desc.value == '') SpecialtyLookup();"><img  src='../../eCommon/images/mandatory.gif' align='center'></img>	
			<input type="hidden" name="Splcode1" id="Splcode1" value="<%=specialty_code%>">  
			<input type="hidden" name="Splcode_desc_hid" id="Splcode_desc_hid" value="<%=spl_name%>"> 
			</td>
			<td class='label'  width='10%'></td>
			<td  class='label'  width='20%'><fmt:message key="eIP.AdmittingPractitioner.label" bundle="${ip_labels}"/></td>
			<td  class='QUERYDATA'   width='20%'>
			<input type='text' name='practid_desc' id='practid_desc' value="<%=pract_name%>" size="25" maxlength="30" onblur="getPractIDBlur(document.forms[0].pract_id_search,practid_desc);"><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button' onClick=" if(document.forms[0].practid_desc.value == '') getPractID(this,practid_desc);"><img  src='../../eCommon/images/mandatory.gif' align='center'></img>
			<input type="hidden" name="practid1" id="practid1" value="<%=Practitioner_id%>">
			<input type="hidden" name="practid_desc_hid" id="practid_desc_hid" value="<%=pract_name%>">
			</td>

	</tr>
	<tr>
			<td  class='label'  width='20%'><fmt:message key="Common.medicalteam.label" bundle="${common_labels}"/></td>
			<td class='QUERYDATA'   width='20%'>
			<select name="team_id" id="team_id"  ><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
			<%

			StringBuffer teamsql = new StringBuffer();
			teamsql.append("Select AM_GET_DESC.AM_MEDICAL_TEAM(facility_id,team_id,?,'2') TEAM_SHORT_DESC ,TEAM_ID from am_pract_for_team_vw"); 
			teamsql.append(" where facility_id = ? and ");
			teamsql.append("practitioner_id = ? and ");
			teamsql.append("appl_for_ip_yn = 'Y' ");
			teamsql.append("and speciality_code = ? order by 1");



			pstmt = con.prepareStatement(teamsql.toString());
			pstmt.setString(1,locale);
			pstmt.setString(2,facilityID);
			pstmt.setString(3,Practitioner_id);
			pstmt.setString(4,specialty_code);
			rs2 = pstmt.executeQuery();
			if(rs2 != null)
			{
				while(rs2.next())
				{
					String TeamCode = rs2.getString("TEAM_ID");	
					String TeamDesc = rs2.getString("TEAM_SHORT_DESC");	

					if(team_code.equals(TeamCode)){ %>
						<option value='<%=TeamCode%>' Selected><%=TeamDesc%></option>
					<%}else { %>
						<option value='<%=TeamCode%>'><%=TeamDesc%></option>
				<% }
				}
			}
			if(rs2 != null) rs2.close();
			if(pstmt != null) pstmt.close();
			
		%>
			</select>	
			</td>
			<td class='label' width='10%'></td>
			<!--<td  class='label' ><fmt:message key="eIP.ProcedureSurgeryDateTime.label" bundle="${ip_labels}"/></td>
			<td class='fields'>
			<input type=text  id =otdatetime name='ot_date_time' id='ot_date_time'  onBlur='doOTDateTimeChk2(this);' size="15" maxlength='16'  value="" ><img name ="ambul" src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].ot_date_time.focus();return showCalendar('otdatetime',null,'hh:mm');" ></img> 
			</td>-->
			<td class='label' width='20%'><fmt:message key="Common.booking.label" bundle="${common_labels}"/>&nbsp<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			<td class='fileds'  width='20%'><textarea name="booking_remarks" rows="2"  maxlength='250'   onBlur="makeValidString(this);checkMaxLimitOfRemark(this);" onKeyPress="/*return CheckForSpecChars_Remarks(event);*/" onkeyup="return imposeMaxLength(this);"><%=booking_remarks%></textarea></td>
			
	</tr>
	<tr>
		<!--/*modification for SRR20056-CRF-0506*/-->
		<td class='label' width='20%' ><fmt:message key="eIP.BookingType.label" bundle="${ip_labels}"/></td>
		<td  class='fileds' width='20%'><SELECT name="booking_Type_Code" id="booking_Type_Code" onBlur=""><option value='' selected>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----
		<%
			for(int i=0;i<bookingtype_list.size();i+=2){
			if(booking_type_code.equals(bookingtype_list.get(i)))
			{
			%>
				<option value=<%=bookingtype_list.get(i)%> selected><%=bookingtype_list.get(i+1)%></option>
			<%}else
				{
		%>
			<option value=<%=bookingtype_list.get(i)%>><%=bookingtype_list.get(i+1)%></option>
		<%}}%>	
		</select></td>
		<td class='label' width='10%'></td>
		<td class='label' width='20%'></td>
		<td class='fields' width='20%'></td>
	</tr>
	<tr>
			<td class="COLUMNHEADER" colspan='5'><fmt:message key="Common.NursingUnitDetails.label" bundle="${common_labels}"/></td>
	</tr>
	<tr>
		<td width='20%' class='label' ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
		<td width='20%' class='fields' ><input type=text name="nursing_unit_desc" id="nursing_unit_desc" maxlength=15 size=15  onblur="NursingUnitLookupBlur('<%=facilityID%>','<%=loginUser%>','<%=p_oper_stn_id%>');removePatInsSession();" value = "<%=nurs_unit_sdesc%>"><input type=button class=button name=nursing_unit_lookup id=nursing_unit_lookup value='?' onClick="if(document.forms[0].nursing_unit_desc.value == '')NursingUnitLookup('<%=facilityID%>','<%=loginUser%>','<%=p_oper_stn_id%>')">
		<input type=hidden name="nursing_unit" id="nursing_unit" width="15" value = "<%=nursing_unit_code%>" >
		<input type=hidden name="nursing_unit_old" id="nursing_unit_old" width="15" value = "<%=nursing_unit_code%>" >
		<input type=hidden name="nurs_unit_desc_hid" id="nurs_unit_desc_hid" width="15" value="<%=nurs_unit_sdesc%>" >
		<td class='label' width='10%'></td>
		<td width='20%' class='label' ><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
		<td class='fields' width='20%'>
		<select name="service_desc" id="service_desc" onChange='' >
	
		<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
		<%	
		if(!nursing_unit_code.equals(""))
		{
		// This query is used for populating the services for selected nursing unit
		StringBuffer sqlservice = new StringBuffer();
		sqlservice.append("Select service_code,am_get_desc.am_service(service_code,'"+locale+"','2') service_short_desc ");
		sqlservice.append("from ip_nurs_unit_for_service where ");
		sqlservice.append("facility_id = ? and nursing_unit_code = ? ");
		sqlservice.append("union select service_code, am_get_desc.am_service(service_code,'"+locale+"','2') service_short_desc ");
		sqlservice.append("from ip_nursing_unit where facility_id = ? ");
		sqlservice.append("and nursing_unit_code = ? order by 2 ");
		pstmt = con.prepareStatement(sqlservice.toString());
		pstmt.setString(1,facilityID);
		pstmt.setString(2,nursing_unit_code);
		pstmt.setString(3,facilityID);
		pstmt.setString(4,nursing_unit_code);
		prs = pstmt.executeQuery();

		if(prs != null)
		{
			while(prs.next())
			{
				
				if(service_code.equals(prs.getString(1))){
					%>
					<option value='<%=prs.getString(1)%>' selected><%=prs.getString(2)%></option>
				<%}	else {%>
						<option value='<%=prs.getString(1)%>'><%=prs.getString(2)%></option>
	<%          }
			}	
		}
	}
	%>
		</select>
		</td>
		
		<input type='hidden' name="service_code" id="service_code"  >		
	</tr>
	<tr>
		<td  class='label' width='20%'><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></td>
		<td  class='fields' width='20%'><select name="bed_class_desc" id="bed_class_desc"  onChange='clearBedValues();populateBedType(this.value)'><option value="" selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
		<%
		if(!bed_class_code.equals(""))
		{
			if((bed_class_code!=null))
		%>
			<OPTION VALUE="<%=bed_class_code%>" selected ><%=bed_class_desc%>
		<%	
		}
		%>
		</select><input type=hidden name="bed_class_code" id="bed_class_code" VALUE="<%=bed_class_code%>"><input type=hidden name="bed_class_desc_hid" id="bed_class_desc_hid" value = "<%=bed_class_desc%>"></td>
		<td class='label' width='10%'></td>
		<td  class='label' width='20%'><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/></td>
		<td  class='fields'   width='20%' nowrap><select name="bed_type_desc" id="bed_type_desc" onChange='clearBedValues();' ><option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
		<%
		if(!bed_type_code.equals(""))
		{
			if((bed_type_code!=null))
		%>
			<OPTION VALUE="<%=bed_type_code%>" selected ><%=bed_type_desc%>
		<%	
		}
		%>
		</select><input type=hidden name="bedtypecode" id="bedtypecode" VALUE="<%=bed_type_code%>" ><input type=hidden name="bed_type_desc_hid" id="bed_type_desc_hid" value = "<%=bed_type_desc%>"></td>
	</tr>
	<tr>
		<td  class='label' width='20%' nowrap><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>
		<td  class='fields' width='20%' nowrap><input type='text' id ='bed_no' name='bed_no' id='bed_no'  size="8" maxlength = "8"   readonly   onBlur='getRoomNo(this),ChangeVal(this);'  onKeyPress='return CheckForSpecChars(event)' ><input type='hidden' name='old_bed_no' id='old_bed_no' value="<%=bed_no%>"><input type='button' name='bed_avail_chart' id='bed_avail_chart' value='?'class='button' onClick="openBedChart();"></td>
		<td class='label' width='10%'></td>
		<td  class='label' width='20%' nowrap><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/></td>
		<td  class='fields' width='20%' nowrap><input type='text' name='room_no' id='room_no' value="" size="10" maxlength="10" readonly   onKeyPress='return CheckForSpecChars(event)' >&nbsp;</td>
	</tr>
	<tr>
		<td class='label' width='20%' ><fmt:message key="Common.override.label" bundle="${common_labels}"/></td>
		<td class='fields' width='20%'><input type='checkbox' name ='override' value="" <%=overdueCHk%>  onClick="changeOVRVal(this)" >&nbsp;</td>
		 <!--Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013-->
		 <!--Maheshwaran K modified for the Inci No : RUT-SCF-0258 [IN:039356] as on 15/04/2013-->
		<!--Start-->
		<td  colspan=1></td>
		<td class='label' nowrap ><fmt:message key="eIP.SurgeryOrder.label" bundle="${ip_labels}"/></td>
		<td class='fields' ><input name="surgery_order" id="surgery_order" type="text" value="<%=oper_desc%>" onblur="if(this .value!=''){GetSurgeryOrder(document.forms[0].patient_id.value,'<%=bkg_lst_ref_no%>');} else { GetSurgeryOrder_blank(document.forms[0].patient_id.value,'');}"><input type='button' name='surgery_order_name' id='surgery_order_name' onClick="GetSurgeryOrder(document.forms[0].patient_id.value,'<%=bkg_lst_ref_no%>');" value='?'class='button' ></td><input name="surgery_order_code" id="surgery_order_code" type="hidden" value="<%=oper_code%>"><input name="surgery_order_id" id="surgery_order_id" type="hidden" value="<%=order_id%>"><input name="surgery_order_line_no" id="surgery_order_line_no" type="hidden" value="<%=order_line_no%>">&nbsp;</td>
		<!--End-->
	</tr>
	<!-- Included for the CRF - RUT-CRF013 - 23396 -->
	<tr>
		<td  class='label'><a href='javascript:PatInsModalWindow()'><fmt:message key="eAM.PatInstructions.label" bundle="${am_labels}"/></a>
		<img src='../../eCommon/images/InfoAlert.PNG' id='NUInstsExist' style='visibility:hidden'/></td>	
		<td  colspan=2></td>	
		<!--Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013-->
		<!--Start-->
		<td class='label' nowrap ><fmt:message key="eIP.SurgeryDate.label" bundle="${ip_labels}"/></td>
		<%
		if(pref_surg_date!=null)
			{%>
			<td class='QUERYDATA' id='surgery_order_dt_id' >&nbsp;<%=pref_surg_date%></td><input name="surgery_order_date" id="surgery_order_date" type="hidden" value="<%=pref_surg_date%>">
			<%
			}
		else
			{
			%>
			<td class='fields' id='surgery_order_dt_id' >&nbsp;</td><input name="surgery_order_date" id="surgery_order_date" type="hidden" value="">
			<%}%>
		<!--End-->
		</tr>
		<tr>
			
				<td colspan='4' class='label'>&nbsp;</td>
				<td  class='fields' width='20%'>
				<input type='button' name='revise' id='revise' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.revise.label","common_labels")%>' class='button' onclick='apply();'><input type='button' name='Close' id='Close' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' class='button' onclick='parent.window.close();'></td>
	</tr>
</table>
	<%
	//if(bl_operational.equals("Y") && !patient_id.equals(""))
		//{
			if(bl_operational.equals("Y") && capture_fin_dtls_yn.equals("Y"))
		{
			%>
						<jsp:include page="../../eBL/jsp/BLFinDetHiddenFlds.jsp" ><jsp:param name="flush" value="true" />
							<jsp:param name="patient_id" value="<%=patient_id%>" />
							<jsp:param name="calling_module" value="IP" />
							<jsp:param name="calling_function_id" value="REVISEBOOKING" />
							<jsp:param name="episode_type" value= "I" />
							<jsp:param name="bookingrefno" value= "<%=booking_ref_no%>" />
						</jsp:include>
		<%
		}
			//}
	//else
		//{
			%>
		<!--	
		   <input type='hidden' name='billing_group' id='billing_group' value=''>
		   <input type='hidden' name='bl_future_admn_YN' id='bl_future_admn_YN' value=''>
		   <input type='hidden' name='bl_operation' id='bl_operation' value=''>-->
		<%
		//}

	%>
	<input type='hidden' name='block_bed_based_on' id='block_bed_based_on' value='<%=block_bed_based_on%>' >
	<input type='hidden' name='facility_id' id='facility_id' value='<%=facilityID%>'>
	<input type ='hidden'name='patientclasscode' value = "<%=patientclasscode%>"> 	
	<input type='hidden' name='currdate' id='currdate' value='<%=Sdate%>'>
	<input type='hidden' name='old_pref_adm_date' id='old_pref_adm_date' value='<%=preferred_date%>'>
	<input type='hidden' name='bkg_lst_ref_no' id='bkg_lst_ref_no' value='<%=bkg_lst_ref_no%>'>	
	<input type='hidden' name='multi_book_pat_yn' id='multi_book_pat_yn' value='<%=multi_book_pat_yn%>'>	
	<input type="hidden" name="hddCitizen" id="hddCitizen" value='<%=citizen_yn%>'>
	<input type="hidden" name="hddLegal" id="hddLegal" value='<%=legal_yn%>'>
	<!--Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013-->
	<input type='hidden' name='surgery_order_desc_hid' id='surgery_order_desc_hid' value=<%=oper_desc%>>
	<script>
		
		document.revisebooking_form.patient_id.value 	= "<%=patient_id%>";
		document.revisebooking_form.patient_id.disabled = true;
		document.revisebooking_form.search.disabled = true;
		document.revisebooking_form.pref_adm_date.value = "<%=preferred_date_converted%>";
		
		document.getElementById('patient_name1').innerHTML = "<%=patientname%>";
		document.revisebooking_form.patient_name.value 	= "<%=patientname%>";
		document.revisebooking_form.patient_name.disabled = true;
		/*if(document.revisebooking_form.name_prefix1)
		{
			document.revisebooking_form.name_prefix1.value 	= "<%=nameprefix%>";
			document.revisebooking_form.name_prefix1.disabled = true;
		}*/
		if(document.revisebooking_form.name_prefix)
		{
			document.revisebooking_form.name_prefix.value 	= "<%=nameprefix%>";
			document.revisebooking_form.name_prefix.disabled = true;
		}
		/*if(document.revisebooking_form.name_suffix1)
		{
			document.revisebooking_form.name_suffix1.value 	= "<%=namesuffix%>";
			document.revisebooking_form.name_suffix1.disabled = true;
		}*/
		if(document.revisebooking_form.name_suffix)
		{
			document.revisebooking_form.name_suffix.value 	= "<%=namesuffix%>";
			document.revisebooking_form.name_suffix.disabled = true;
		}
		
		if(document.revisebooking_form.first_name)
		{
			document.revisebooking_form.first_name.value 	= "<%=firstname%>";
			document.revisebooking_form.first_name.disabled = true;
		}
		if(document.revisebooking_form.second_name)
		{
			document.revisebooking_form.second_name.value 	= "<%=secondname%>";
			document.revisebooking_form.second_name.disabled = true;
		}
		if(document.revisebooking_form.third_name)
		{
			document.revisebooking_form.third_name.value 	= "<%=thirdname%>";
			document.revisebooking_form.third_name.disabled = true;
		}
		if(document.revisebooking_form.family_name)
		{
			document.revisebooking_form.family_name.value 	= "<%=familyname%>";
			document.revisebooking_form.family_name.disabled = true;
		}






		if(document.revisebooking_form.name_prefix_oth_lang)
	    {
			document.revisebooking_form.name_prefix_oth_lang.value 	= "<%=name_prefix_loc_lang%>";
			document.revisebooking_form.name_prefix_oth_lang.disabled = true;
		}

		if(document.revisebooking_form.first_name_oth_lang)
	    {
			document.revisebooking_form.first_name_oth_lang.value 	= "<%=first_name_loc_lang%>";
			document.revisebooking_form.first_name_oth_lang.disabled = true;
		}

		if(document.revisebooking_form.second_name_oth_lang)
	    {
			document.revisebooking_form.second_name_oth_lang.value 	= "<%=second_name_loc_lang%>";
			document.revisebooking_form.second_name_oth_lang.disabled = true;
		}

		if(document.revisebooking_form.third_name_oth_lang)
	    {
			document.revisebooking_form.third_name_oth_lang.value 	= "<%=third_name_loc_lang%>";
			document.revisebooking_form.third_name_oth_lang.disabled = true;
		}

		if(document.revisebooking_form.family_name_oth_lang)
	    {
			document.revisebooking_form.family_name_oth_lang.value 	= "<%=family_name_loc_lang%>";
			document.revisebooking_form.family_name_oth_lang.disabled = true;
		}

		if(document.revisebooking_form.name_suffix_oth_lang)
	    {
			document.revisebooking_form.name_suffix_oth_lang.value 	= "<%=name_suffix_loc_lang%>";
			document.revisebooking_form.name_suffix_oth_lang.disabled = true;
		}


		document.getElementById('patient_name_local_lang1').innerText 	= "<%=patient_name_loc_lang%>";
		document.revisebooking_form.patient_name_local_lang.value 	= "<%=patient_name_loc_lang%>";

		document.revisebooking_form.sex.value 	= "<%=gender%>";
		document.revisebooking_form.sex.disabled = true;
		document.revisebooking_form.date_of_birth.value = "<%=date_of_birth_converted%>";
		//document.revisebooking_form.date_of_birth.onblur();
		/*Wednesday, June 23, 2010,IN022062*/
		var maxAge = '<%=max_patient_age%>';
		var age	   = '<%=AGE%>';
		var months	   = '<%=MONTHS%>';
		var days	   = '<%=DAYS%>';
		if(parseInt(maxAge) < parseInt(age))
		{
			msg = getMessage('MAX_PATIENT_AGE','MP');
			msg = msg.replace('#', '$');
			msg = msg+' '+maxAge+' '+ getLabel('Common.Years.label','common');
			alert(msg);
			window.close();
		}else if((parseInt(age) == parseInt(maxAge)) && ((parseInt(months) > 0) ||  (parseInt(days) > 0)))
		{
			msg = getMessage('MAX_PATIENT_AGE','MP');
			msg = msg.replace('#', '$');
			msg = msg+' '+maxAge+' '+ getLabel('Common.Years.label','common');	
			alert(msg);
			window.close();
		}
		
		document.revisebooking_form.date_of_birth.disabled = true;
		document.getElementById('dob').disabled=true;
		/*Wednesday, January 12, 2011 , IN025850*/
		document.revisebooking_form.b_age.value = "<%=AGE%>";
		document.revisebooking_form.b_months.value = "<%=MONTHS%>";
		document.revisebooking_form.b_days.value = "<%=DAYS%>";
		/**/
		document.revisebooking_form.b_age.disabled = true;
		document.revisebooking_form.b_months.disabled = true;
		document.revisebooking_form.b_days.disabled = true;

		document.revisebooking_form.complaintcode.value =
		"<%=chief_complaint%>";	
		document.revisebooking_form.rev_hid.value =
		"<%=reason_revise%>";
		document.revisebooking_form.rev_txt.value =
		"<%=rev_desc%>";

		var override_yn = "<%=override_yn%>";	

		document.revisebooking_form.Birth_place_code.value 	= "<%=birth_place_code%>";
	
		if((document.revisebooking_form.Birth_place_code.value == null) || (document.revisebooking_form.Birth_place_code.value == ""))
		{	
			document.revisebooking_form.place_of_birth.value = "<%= birth_place_desc%>";
		}else
		document.revisebooking_form.birth_place.value = "<%= birth_place_desc%>";

		document.revisebooking_form.birth_place.disabled= true;
		document.revisebooking_form.place_of_birth.disabled= true;
		document.revisebooking_form.b_birth.disabled= true;

		document.revisebooking_form.nationality_code1.value 	= "<%=nationality%>";
		document.revisebooking_form.nationality_desc.value = "<%= nationality_desc%>";
		document.revisebooking_form.nationality_desc.disabled= true;
		document.revisebooking_form.nationality_id.disabled= true;
		document.revisebooking_form.national_id_no.value 	= "<%=national_id_no%>";
		document.revisebooking_form.national_id_no.disabled =true;
		if(document.revisebooking_form.alt_id1_no)
		{
			document.revisebooking_form.alt_id1_no.value 	= "<%=alt_id1_no%>";
			document.revisebooking_form.alt_id1_no.disabled = true;
		}
		if(document.revisebooking_form.alt_id2_no)
		{
			document.revisebooking_form.alt_id2_no.value 	= "<%=alt_id2_no%>";
			document.revisebooking_form.alt_id2_no.disabled = true;
		}
		if(document.revisebooking_form.alt_id3_no)
		{
			document.revisebooking_form.alt_id3_no.value 	= "<%=alt_id3_no%>";
			document.revisebooking_form.alt_id3_no.disabled = true;
		}
		if(document.revisebooking_form.alt_id4_no)
		{
			document.revisebooking_form.alt_id4_no.value 	= "<%=alt_id4_no%>";
			document.revisebooking_form.alt_id4_no.disabled = true;
		}
		if(document.revisebooking_form.alt_id1_exp_date)
		{
			document.revisebooking_form.alt_id1_exp_date.value 	= "<%=alt_id1_exp_dt%>";
			document.revisebooking_form.alt_id1_exp_date.disabled = true;
		}
		if(document.revisebooking_form.alt_id2_exp_date)
		{
			document.revisebooking_form.alt_id2_exp_date.value 	= "<%=alt_id2_exp_dt%>";
			document.revisebooking_form.alt_id2_exp_date.disabled = true;
		}
		if(document.revisebooking_form.alt_id3_exp_date)
		{
			document.revisebooking_form.alt_id3_exp_date.value 	= "<%=alt_id3_exp_dt%>";
			document.revisebooking_form.alt_id3_exp_date.disabled = true;
		}
		if(document.revisebooking_form.alt_id4_exp_date)
		{
			document.revisebooking_form.alt_id4_exp_date.value 	= "<%=alt_id4_exp_dt%>";
			document.revisebooking_form.alt_id4_exp_date.disabled = true;
		}

		if(document.revisebooking_form.other_alt_type)
		{
			document.revisebooking_form.other_alt_type.value = "<%=oth_alt_id_type%>";
			document.revisebooking_form.other_alt_type.disabled = true;
		}

		if(document.revisebooking_form.other_alt_Id)
		{
			document.revisebooking_form.other_alt_Id.value = "<%=oth_alt_id_no%>";
			document.revisebooking_form.other_alt_Id.disabled = true;
		}
		/*
		var obj =document.forms[0].race_code;
		var length  = obj.length;
		var opt= document.createElement('Option');
		opt.text="<%=race_desc%>"; 
		opt.value="<%=race_code%>"; 

		obj.add(opt)
		opt.selected = true;
		*/

		document.forms[0].race_code.value="<%=race_code%>";
		if(document.forms[0].race_desc) {
			document.forms[0].race_desc.value="<%=race_desc%>";
		}

		var obj1 =document.forms[0].ethnic_group;
		var length1  = obj1.length;
		var opt1= document.createElement('Option');
		opt1.text="<%=ethic_desc%>"; opt1.value="<%=eth_grp%>"; 

		obj1.add(opt1)
		opt1.selected = true;

		//document.revisebooking_form.race_code.disabled = true;
		if(document.revisebooking_form.race_desc.value!="") {
			document.revisebooking_form.race_desc.disabled = true;
			document.revisebooking_form.race_desc_id.disabled = true;
		}
		else//For 17676 
		{
			document.revisebooking_form.race_desc.disabled = false;
			document.revisebooking_form.race_desc_id.disabled = false;
		}
		document.revisebooking_form.ethnic_group.disabled = true;

	if(document.revisebooking_form.hddCitizen.value == "Y")
		document.revisebooking_form.citizen_yn[0].checked = true;
	else
		document.revisebooking_form.citizen_yn[1].checked = true;

		document.revisebooking_form.citizen_yn[0].disabled = true;		
		document.revisebooking_form.citizen_yn[1].disabled = true;

	if(document.revisebooking_form.hddLegal.value == "Y")
		document.revisebooking_form.legal_yn[0].checked = true;
	else
		document.revisebooking_form.legal_yn[1].checked = true;

		document.revisebooking_form.legal_yn[0].disabled = true;
		document.revisebooking_form.legal_yn[1].disabled = true;

// ======= Patient contact details popup ================ 

		document.revisebooking_form.change_address.value='';
		document.revisebooking_form.concat_address_hidden.value='';			
		document.revisebooking_form.concat_NatIdDetails_hidden.value='';		
		document.revisebooking_form.addr1_type.value='';
		document.revisebooking_form.addr_line1.value="<%=res_addr_line1%>";
		document.revisebooking_form.addr_line2.value="<%=res_addr_line2%>";
		document.revisebooking_form.addr_line3.value="<%=res_addr_line3%>";
		document.revisebooking_form.addr_line4.value="<%=res_addr_line4%>";
		document.revisebooking_form.res_town_code.value="<%=res_town_code%>";
		document.revisebooking_form.res_town_desc.value="<%=res_town_desc%>";

		document.revisebooking_form.res_area_code.value="<%=res_area_code%>";
		document.revisebooking_form.res_area_desc.value="<%=res_area_desc%>";

		document.revisebooking_form.postal_code.value="<%=postal_code%>";
		document.revisebooking_form.r_postal_code_desc.value="<%=postal_code_desc%>";
	
		document.revisebooking_form.region_code.value="<%=res_region_code%>";
		document.revisebooking_form.region_desc.value="<%=res_region_desc%>";
		document.revisebooking_form.country_code.value="<%=country_code%>";
		document.revisebooking_form.country_desc.value="<%=country_desc%>";
		document.revisebooking_form.contact1_name.value='';
		document.revisebooking_form.invalid1_yn.value='';

		document.revisebooking_form.addr2_type.value='';
		
		document.revisebooking_form.mail_addr_line1.value="<%=mail_addr_line1%>";
		document.revisebooking_form.mail_addr_line2.value="<%=mail_addr_line2%>";
		document.revisebooking_form.mail_addr_line3.value="<%=mail_addr_line3%>";
		document.revisebooking_form.mail_addr_line4.value="<%=mail_addr_line4%>";		
		document.revisebooking_form.mail_res_town_code.value="<%=mail_town_code%>";
		document.revisebooking_form.mail_res_town_desc.value="<%=mail_town_desc%>";

		document.revisebooking_form.mail_res_area_code.value="<%=mail_area_code%>";
		document.revisebooking_form.mail_res_area_desc.value="<%=mail_area_desc%>";
		document.revisebooking_form.mail_postal_code.value="<%=mail_postal_code%>";
		document.revisebooking_form.m_postal_code_desc.value="<%=mail_postal_code_desc%>";

		document.revisebooking_form.mail_region_code.value="<%=mail_region_code%>";
		document.revisebooking_form.mail_region_desc.value="<%=mail_region_desc%>";
		document.revisebooking_form.mail_country_code.value="<%=mail_country_code%>";
		document.revisebooking_form.mail_country_desc.value="<%=mail_country_desc%>";
		document.revisebooking_form.contact2_name.value='';
		document.revisebooking_form.invalid2_yn.value='';

		document.revisebooking_form.contact1_no.value="<%=res_tel_no%>";
		document.revisebooking_form.contact2_no.value="<%=other_tel_no%>";
		document.revisebooking_form.email.value="<%=email_id%>";
		/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
		document.revisebooking_form.alt_addr_line1.value	= "<%=alt_addr_line1%>";
		document.revisebooking_form.alt_addr_line2.value	= "<%=alt_addr_line2%>";
		document.revisebooking_form.alt_addr_line3.value	= "<%=alt_addr_line3%>";
		document.revisebooking_form.alt_addr_line4.value	= "<%=alt_addr_line4%>";
		document.revisebooking_form.alt_town_code.value		= "<%=alt_town_code%>";
		document.revisebooking_form.alt_town_desc.value		= "<%=alt_town_desc%>";
		document.revisebooking_form.alt_area_code.value		= "<%=alt_area_code%>";
		document.revisebooking_form.alt_area_desc.value		= "<%=alt_area_desc%>";
		document.revisebooking_form.alt_postal_desc.value	= "<%=alt_postal_desc%>";
		document.revisebooking_form.alt_postal_code.value	= "<%=alt_postal_code%>";
		document.revisebooking_form.alt_region_code.value	= "<%=alt_region_code%>";
		document.revisebooking_form.alt_region_desc.value	= "<%=alt_region_desc%>";
		document.revisebooking_form.alt_country_code.value	= "<%=alt_country_code%>";
		document.revisebooking_form.alt_country_desc.value	= "<%=alt_country_desc%>";
		/*End*/
		<%-- if("<%=alt_id1_exp_date%>" != "") --%>
	</script>

	<input type ='hidden' name = 'old_nursing_unit' value = ""> 
	<input type ='hidden' name = 'PatClass' 	value = "<%=patientclasscode%>"> 	
	<input type='hidden' name ='override_yn' 	value ="<%=override_yn%>" >
	<input type='hidden' name='deactivate_pseudo_bed_yn' id='deactivate_pseudo_bed_yn' value="<%=deactivate_pseudo_bed_yn%>">
	<input type='hidden' name='chk_booking_limit_by' id='chk_booking_limit_by' value="<%=chk_booking_limit_by%>" ><!-- code added  by  munisekhar for [IN:048232] -->
<%
			if (rs != null)		rs.close();
			if (stmt != null)	stmt.close();
			if (rs1 != null)	rs1.close();
			if (stmt1 != null)	stmt1.close();
			if (rs2 != null)	rs2.close();
			if (prs != null)	prs.close();
			if (stmt2 != null)	stmt2.close();
			if (pstmt != null)	pstmt.close();

	}catch(Exception e) {
		//out.println(e.toString());
		e.printStackTrace();}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}

%>
   <input type = 'hidden' value='<%=sStyle%>' name = 'sStyle'> 
   <input type = 'hidden' value='<%=Sdate%>' name = 'sdate2'> 
   <input type = 'hidden' value='Revise_Booking' name = 'call_function'> 
   <input type = 'hidden' value='<%=queryString%>' name = 'queryString'> 
   <input type='hidden'  name='bclasscode' id='bclasscode' value="">
   <input type='hidden'  name='bno' id='bno' value="">
   <input type='hidden'  name='rno' id='rno' value="">
   <input type='hidden'  name='nunitcode' id='nunitcode' value="">   
   <input type='hidden' name='modifiedDate' id='modifiedDate' value='<%= modifiedDate%>' >
   <input type='hidden' name='locale' id='locale' value='<%=locale%>' >
    <input type='hidden' name='pre_op_days_hidden' id='pre_op_days_hidden' value='<%=pre_op_days%>' >
  
      

			<!--  billing related variables -->
		   <input type='hidden' name='package_flag' id='package_flag' value='N'>
		   <!--<input type='hidden' name='billing_mode' id='billing_mode' value='Add'>-->
		   <input type='hidden' name='pkg_bill_type' id='pkg_bill_type' value=''>
		   <input type='hidden' name='pkg_bill_no' id='pkg_bill_no' value=''>
		   <input type="hidden" name="patient_class_id" id="patient_class_id" value="IP">
		   <input type='hidden' name='health_card_expired_yn' id='health_card_expired_yn' value=''>
		   <input type='hidden' name='Chg_to_Visitor_Grp' id='Chg_to_Visitor_Grp' value='N'>
		   <input type='hidden' name='bl_interface_yn' id='bl_interface_yn' value="<%=isBlInterfaced%>"> 
		   <input type='hidden' name='financial_detail_ref_id' id='financial_detail_ref_id' value=''>
		   <input type='hidden' name='org_type_ind' id='org_type_ind' value=''>
		   <input type='hidden' name='att_practid' id='att_practid' value="">
		   <input type='hidden' name='isBlInstalled' id='isBlInstalled' value='<%=bl_operational%>'>
		   <input type='hidden' name='bl_success' id='bl_success' value='N'>
		   <input type='hidden' name='insTrackDtlsExists' id='insTrackDtlsExists' value=''>
		   <input type='hidden' name='isBlInterfaced' id='isBlInterfaced' value='<%=isBlInterfaced%>'>
		   <input type='hidden' name='iscapture_fin_dtls_yn' id='iscapture_fin_dtls_yn' value='<%=capture_fin_dtls_yn%>'>
		   <input type='hidden' name='billing_group_operation' id='billing_group_operation' value=''>
		   <input type='hidden' name='removePatInstruction' id='removePatInstruction' value=''>
		  

		   <script>
			if ( (document.forms[0].billing_group) && (document.forms[0].billing_group.value != '') ) 
			document.forms[0].bl_success.value = 'Y';
		   </script>
           
</form>
</BODY>
</HTML>
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

