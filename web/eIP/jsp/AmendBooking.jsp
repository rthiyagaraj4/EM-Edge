<!DOCTYPE html>

<%@ page import ="webbeans.eCommon.*,java.sql.*, java.util.*,com.ehis.util.*,eCommon.Common.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String locale				= (String)session.getAttribute("LOCALE");
	String facility_id			= (String)session.getAttribute("facility_id");
	String oper_stn_id			= request.getParameter("oper_stn_id");
	String revise_booking_yn	= request.getParameter("revise_booking_yn");
	if(revise_booking_yn == null) revise_booking_yn = "";

	String cancel_booking_yn	= request.getParameter("cancel_booking_yn");
	if(cancel_booking_yn == null) cancel_booking_yn = "";

	String confirm_booking_yn	= request.getParameter("confirm_booking_yn");
	if(confirm_booking_yn == null) confirm_booking_yn = "";

	String create_booking_with_conf_yn = request.getParameter("create_booking_with_conf_yn");
	if(create_booking_with_conf_yn == null) create_booking_with_conf_yn = "";

	String create_booking_yn	= request.getParameter("create_booking_yn");
	if(create_booking_yn == null) create_booking_yn = "";

	String bl_interfaced_yn		= request.getParameter("bl_interfaced_yn");
	if(bl_interfaced_yn == null) bl_interfaced_yn = "N";

	String capture_fin_dtls_yn	= request.getParameter("capture_fin_dtls_yn");
	if(capture_fin_dtls_yn == null) capture_fin_dtls_yn = "N";
	String calling				= checkForNull(request.getParameter("calling"));
//out.println("<script>alert(\"bl_interfaced_yn : "+bl_interfaced_yn+"\");</script>");
//out.println("<script>alert(\"bl_interfaced_yn : "+capture_fin_dtls_yn+"\");</script>");
%>

<html>
<head>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eIP/js/AmendBooking.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 <!-- Included for the CRF - RUT-CRF013 - 23396 -->
<title> <fmt:message key="Common.Cancellation.label" bundle="${common_labels}"/> </title>
<script>

async function displayDetails()
{
	
	var contactdetails = document.forms[0].contactvals.value;

	var retVal		 = 	new String();
	var dialogHeight = "300px" ;
	var dialogWidth	 = "420px" ;
	
	//Below line added for ML-MMOH-CRF-0860.2
	if(document.forms[0].increasedaddressLength && document.forms[0].increasedaddressLength.value =="true") dialogWidth = "35";
	//End ML-MMOH-CRF-0860.2
	
	var status		 = "no";
	var features	 = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no;status:" + status;
	var arguments	 = document.forms[0].contactvals;

	var url="../jsp/BookAppointmentContact.jsp?FromQuery=Y&contactdetails="+escape(contactdetails);
	retVal = await window.showModalDialog(url,arguments,features);
}

function confirmBooking(bkg_lst_ref_no)
{
	var callFrom = "Confirm";
	showModal(bkg_lst_ref_no,callFrom);
}

function callRevise(bkg_lst_ref_no)
{
	/*
	if(confirm(getMessage('RELEASE_BED_BOOKING','IP')))
	{
		var callFrom = "Revise";
		showModal(bkg_lst_ref_no,callFrom);	
	}
	else
	{
	}
	*/
	/*Monday, July 20, 2009 IN012449*/
	var bed_no = document.forms[0].bed_no.value;
	var callFrom = "Revise";
	if(bed_no != "")
	{
		if(confirm(getMessage('RELEASE_BED_BOOKING','IP')))
		{
			showModal(bkg_lst_ref_no,callFrom);	
		}
		else
		{
		}
	}
	else
	{
		showModal(bkg_lst_ref_no,callFrom);	
	}
	

}

async function showModal(obj,callFrom)
{
	var dialogHeight= "1000px";
	var dialogWidth = "1200px";
	var dialogTop	= "87";

	if(document.forms[0].booking_valid.value == '1' || callFrom == "Confirm")
	{
		bkg_lst_ref_no		= obj.value
		var retVal			= 	new String();
		if(callFrom == "Revise")
		{

			function_name	= "Revise%20Booking";
		}
		else
		{	
			function_name	= "Confirm%20Booking";
		}

		var center			= "1" ;
		var status			="no";
		var features		= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop ;
		var arguments		= "" ;

		retVal = await window.showModalDialog("../jsp/Booking.jsp?module_id=IP&bkg_lst_ref_no="+bkg_lst_ref_no+"&function_id=BOOKING&oper_stn_id=<%=oper_stn_id%>&revise_booking_yn=<%=revise_booking_yn%>&confirm_booking_yn=<%=confirm_booking_yn%>&create_booking_yn=<%=create_booking_yn%>&create_booking_with_conf_yn=<%=create_booking_with_conf_yn%>&function_name="+function_name+"&function_type=F&callFrom="+callFrom+"&access=NYNNN",arguments,features);

		if(retVal != null)
		{
			//parent.window.close();
		let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = retVal;
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 
		}	

	}
	else if (callFrom != "Confirm")
	{
	   alert(getMessage("BKG_GRACE_PERIOD_EXCEEDED",'IP'));
	}
}

function exitwin() 
{
	var u="close";
	//parent.window.returnValue=u;
	//parent.window.close();
	
	let dialogBody = top.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = u;
    
    const dialogTag = top.document.getElementById("dialog_tag");    
    dialogTag.close();
}

function sh_focus() 
{
	
	document.getElementById("allbuttons").style.visibility="visible";
	document.getElementById("turndowntxt").style.visibility="hidden";		
	document.getElementById("revisetxt").style.visibility="hidden";

	document.getElementById("cancelbuttons").style.visibility="hidden";
	if(document.getElementById("NUInstsExist")){
		document.getElementById("NUInstsExist").style.visibility='hidden';
	}
	document.getElementById("revisebuttons").style.visibility="hidden";
	if(document.getElementById("transferbuttons"))
	{
		document.getElementById("transferbuttons").style.visibility="hidden";
	}
	document.getElementById("turndownbuttons").style.visibility="hidden";
	
}

function sh_layer() {

	if(document.forms[0].cancelappt)
	{
		document.forms[0].reason_for_revision.value="";
	}
	document.getElementById("allbuttons").style.visibility="hidden";
	document.getElementById("revisetxt").style.visibility="visible";
	document.getElementById("cancelbuttons").style.visibility="visible";
	checkPatInstns();
}

function cancel_layer() {

	document.getElementById("allbuttons").style.visibility="visible";
	document.getElementById("revisetxt").style.visibility="hidden";
	document.getElementById("cancelbuttons").style.visibility="hidden";
}

function tdopen() {
	document.getElementById("allbuttons").style.visibility="hidden";
	document.getElementById("turndowntxt").style.visibility="visible";
	document.getElementById("turndownbuttons").style.visibility="visible";
	document.getElementById("reason_for_turndown").focus();
}	

function cancel_text_area() {
	document.getElementById("allbuttons").style.visibility="visible";
	document.getElementById("turndowntxt").style.visibility="hidden";
	document.getElementById("turndownbuttons").style.visibility="hidden";
}


function valcheck1(Obj) 
{
	if(document.forms[0].reason_for_revision.value=="") 
	{
		alert(getMessage("CANCEL_REAS_NOT_BLNK",'IP'));
		document.forms[0].reason_for_revision.focus();
	}
	else
	{
		document.forms[0].submit();
	}
}

function valcheck10(Obj) 
{
	if(document.forms[0].reason_for_turndown.value=="") {
		alert(getMessage("TURNDOWN_REAS_NOT_BLNK",'IP'));
	document.forms[0].reason_for_turndown.focus();	
}
else{
	document.forms[0].submit();
	}
}

function checkMaxLimit1(obj,maxSize)
{	
   if(makeValidString(obj)==false)
	   return false
   else
	{
		if ( obj.value.length >= maxSize )
		{
			alert(getMessage("CANT_XCEED_500_CHARS",'IP'));	
			obj.focus();obj.select();
		}
	}
}
async function showRemarks(viewremarks)
{
			var retVal1;
			var calling_from			= "BookingReferenceLookupResult";
			var arguments				= "";
			var facilityid				= '<%=facility_id%>';
			var dialogHeight			= "12" ;
			var dialogWidth				= "23" ;
			var dialogTop				= "330";
			var dialogLeft				= "430";
				var features			= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
			retVal1						= await window.showModalDialog("../../eIP/jsp/remarks.jsp?remarks="+calling_from+"&facilityid="+facilityid+"&bookingremarks="+encodeURIComponent(viewremarks)+" ",arguments,features);
}
function callMouseOverRemarks(obj,viewremarks)
{
				
		var Remarks = getLabel("Common.remarks.label","Common");
		
		var tabdata = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><body><table class='grid' cellpadding=0 cellspacing=0 border=1><tr><td class=columnHeadercenter nowrap>"+Remarks+"</td></tr><tr><td>"+viewremarks+"</td></tr></table></body></html>";

		document.getElementById("details").innerHTML = tabdata;

		var wdth 	  = obj.offsetWidth;
		var hght1 	  = obj.offsetHeight;

		var wdth1 = getPos(obj).x - wdth;
		var hght = getPos(obj).y + hght1;
				
		document.getElementById("details").style.posTop  = hght;
		document.getElementById("details").style.posLeft  = wdth1;
		document.getElementById("details").style.visibility = 'visible' ;
					

}
function callOnMouseOutRemarks(obj)
{
	document.getElementById("details").style.visibility='hidden' ;
}
function getPos(inputElement)
{
	var coords =  new Object();
	coords.x = 0;
	coords.y = 0;
	try
	{
		targetElement = inputElement;
		if(targetElement.x && targetElement.y)
		{
			coords.x = targetElement.x;
			coords.y = targetElement.y;
		}
		else
		{
			if(targetElement.offsetParent)
			{
				coords.x += targetElement.offsetLeft;
				coords.y += targetElement.offsetTop;
				while(targetElement = targetElement.offsetParent)
				{
					coords.x += targetElement.offsetLeft;
					coords.y += targetElement.offsetTop;
				}
			}
			
		}
			return coords;
	}
	catch(error)
	{
		return coords;
	}
}
</script>
	
</head>

<body onLoad='sh_focus()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" style="overflow-x: hidden;">

<%
		Connection	con		= null;
		Statement	stmt	= null;
		PreparedStatement	stmt2	= null;
		Statement	PrStmt	= null;
		ResultSet	rs		= null;
		ResultSet	rset2	= null;
		ResultSet	PrRs	= null;

		String bookingRefNo			= request.getParameter("bookingRefNo");
//		String loginUser			= (String)session.getValue("login_user");
		String pref_adm_date_desc	= "";
		String med_ser_short_desc	= ""; 
		String bkg_lst_ref_no		= "";     
		String patient_id			= "";         
		String patient_name			= "";       
		String national_id_no		= "";     
		String alt_id1_no			= "";         
		String gender				= "";             
		String date_of_birth		= ""; 
		String bed_class_desc		= "";
		String bed_type_short_desc	= "";
		String birth_place_desc		= "";
		String citizen_yn			= "";
		String ethnic_grp_desc		= "";
		String legal_yn				= "";
		String race_desc			= "";
		String res_tel_no			= "";         
		String oth_contact_no		= "";     
		String email_id				= "";           
		String practitioner_name	= "";
		String specialty_short_desc	= "";
		String exp_days_of_stay		= "";
		String expected_discharge_date = "";
		String nursing_unit_short_desc ="";
		String nursing_unit ="";// Included for the CRF - RUT-CRF013 - 23396 
		String room_no				= "";            
		String bed_no				= "";  
		String age					= "";
		String med_ser_grp_code		= "";
		String nationality			= "";
		String nat_id_prompt		= "";
		String contact_email		= "";
		String postal_code			= "";
		String country_code			= "";
		String addr_line_1			= "";
		String addr_line_2			= "";
		String addr_line_3			= "";
		String addr_line_4			= "";										  
		StringBuffer contact_vals	= new StringBuffer();
		String booking_date_time	= "";
		String booking_status		= "";
		int valid_booking			= 0;
		String medteamdesc			= "";
		String turn_down_reason		= ""; 
		String calling_func			= "";
		String ALT_ID1_TYPE_SHORT_DESC ="";
		String bkg_type				= "";
		String pref_adm_date_desc_converted = "";
		String bl_operational		= "";
		String proc_surg_date		= "";
		String pre_op_days			= "";
		String booking_reason		= "";
		String revision_reason		= "";
		String booking_remarks		= "";
		String contact_reason		= "";
		String booking_type_desc	= "";
		String DAYS					= "";
		String MONTHS				= "";
		String AGE					= "";
		String override_yn			= "N";
		//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013
		//Start
		String surgery_order="";
		String surgery_date="";
		//End
		//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
		String smartCardFunc ="";
		String biometric_reason="";
		//Ends
		
		//Below line added for this ML-MMOH-CRF-0860.2
		Boolean increasedaddressLength = false;	

		Boolean isReviseBkgAftrConfrmAppl = false; //Added by Thamizh selvi on 22nd May 2018 against ML-MMOH-CRF-0622
					
			try
			{
			con = ConnectionManager.getConnection(request);
			//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023	
			smartCardFunc	= isSiteSpecificforBiometric(con);
			if(smartCardFunc.equals("01")) {
			biometric_reason = (String) session.getValue( "biometric_reason" ) ;
			
			session.removeAttribute("biometric_reason");
			}
			//Ends	
			//added for ML-MMOH-CRF-0860.2
			increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");

			isReviseBkgAftrConfrmAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "IP","REVISE_BKG_AFTR_CONFIRM");//Added by Thamizh selvi on 22nd May 2018 against ML-MMOH-CRF-0622
						
			bl_operational		= (String)session.getValue("bl_operational");

			calling_func		= request.getParameter("call_function");			

			if(calling_func == null || calling_func.equals("null")) calling_func = "";
			bkg_type	= request.getParameter("bkg_type");
			if(bkg_type == null || bkg_type.equals("null")) bkg_type = "";
			StringBuffer sql = new StringBuffer();
			/*Monday, April 26, 2010 , commented for PE , getting these values from AmendBookingLookup.jsp*/
			/*
			sql.append("select bl_interfaced_yn,capture_fin_dtls_yn from ip_param where facility_id='"+facility_id+"'"); 

			stmt	=	con.createStatement();
			rs		=	stmt.executeQuery(sql.toString());
			
			if( rs.next())
			{
				bl_interfaced_yn			= checkForNull(rs.getString("BL_INTERFACED_YN"));
				capture_fin_dtls_yn			= checkForNull(rs.getString("CAPTURE_FIN_DTLS_YN"));
			}			
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			*/
						
			if(bkg_type.equals("D"))
			{
				if(sql.length() > 0) sql.delete(0,sql.length());

				sql.append("SELECT" );
				sql.append("  a.appt_time" );
				sql.append("  , TO_CHAR(a.appt_time,'DD/MM/rrrr HH24:MI Day ') pref_adm_date_desc" );
				sql.append("  , a.appt_ref_no bkg_lst_ref_no" );
				sql.append("  , a.patient_id" );
				sql.append("  , decode('"+locale+"','en',A.patient_name, nvl(A.patient_name_loc_lang, A.patient_name))patient_name" );
				sql.append("  , a.national_id_no" );
				sql.append("  , a.alt_id1_no" );
				sql.append("  , mp_get_desc.mp_alternate_id_type(a.alt_id1_type, '"+locale+"', 1) alt_id1_type_short_desc " );
				sql.append("  , a.gender" );
				sql.append("  , get_age(a.date_of_birth)age" );
				sql.append("  , TO_CHAR(a.date_of_birth,'dd/mm/rrrr') date_of_birth" );
				/*Monday, April 26, 2010 , added for PE*/
				sql.append("  , calculate_age(TO_CHAR(a.date_of_birth,'dd/mm/rrrr'),1) Years" );
				sql.append("  , calculate_age(TO_CHAR(a.date_of_birth,'dd/mm/rrrr'),2) Months" );
				sql.append("  , calculate_age(TO_CHAR(a.date_of_birth,'dd/mm/rrrr'),3) Days" );
				/**/
				sql.append("  , a.res_tel_no" );
				sql.append("  , a.oth_contact_no" );
				sql.append("  , a.email_id contact_email" );
				sql.append("  , a.res_addr_line1" );
				sql.append("  , a.res_addr_line2" );
				sql.append("  , a.res_addr_line3" );
				sql.append("  , a.res_addr_line4" );
				sql.append("  , a.postal_code" );
				sql.append("  , a.country_code" );
				sql.append("  , a.practitioner_id" );
				sql.append("  , am_get_desc.am_practitioner(a.practitioner_id, '"+locale+"', 1) practitioner_name" );
				sql.append("  , b.speciality_code specialty_code" );
				sql.append("  , am_get_desc.am_speciality(b.speciality_code, '"+locale+"', 2) specialty_short_desc" );
				sql.append("  , mp_get_desc.mp_country(a.country_code, '"+locale+"', 1) nationality_long_desc" );
				sql.append("  , am_get_desc.am_medical_team(a.facility_id, a.team_id, '"+locale+"', 2) team_short_desc" );
				sql.append("  , TO_CHAR(a.appt_time,'dd/mm/rrrr hh24:mi') booking_date_time" );
				sql.append("  , a.appt_status booking_status" );
				sql.append("  , substr(a.email_id,1,24)|| '\n'||substr(a.email_id,25,50) email_id" );
				sql.append("  , mp_get_desc.mp_birth_place(a.birth_place_code, '"+locale+"', 1) birth_place_desc" );
				sql.append("  , a.citizen_yn" );
				sql.append("  , mp_get_desc.mp_ethnic_group(a.ethnic_group_code, '"+locale+"', 1) ethnic_group_desc" );
				sql.append("  , a.legal_yn legal_illegal_yn" );
				sql.append("  , mp_get_desc.mp_race(a.race_code, '"+locale+"', 1) race_desc" );
				sql.append("  , am_get_desc.am_service(b.service_code, '"+locale+"', 2) service_short_desc" );
				sql.append("  , (" );
				sql.append("  SELECT" );
				sql.append("    nat_id_prompt " );
				sql.append("  FROM" );
				sql.append("    mp_param " );
				sql.append("  WHERE module_id ='MP'" );
				sql.append("  ) nat_id_prompt " );
				/*Monday, April 26, 2010 , added for PE*/
				sql.append("  , (SELECT SIGN((TO_DATE(TO_CHAR(a.appt_time,'dd/mm/rrrr hh24:mi'),'dd/mm/rrrr hh24:mi')+NVL(bkg_grace_period,0) - sysdate))valid_flag FROM ip_param WHERE facility_id='"+facility_id+"') valid_flag ");
				/**/
				sql.append("FROM" );
				sql.append("  oa_appt a" );
				sql.append("  , op_clinic b " );
				sql.append("WHERE a.facility_id = '"+facility_id+"' " );
				sql.append("  AND a.appt_ref_no = '"+bookingRefNo+"' " );
				sql.append("  AND a.facility_id = b.facility_id " );
				sql.append("  AND a.clinic_code = b.clinic_code " );
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" SELECT" );
				sql.append(" preferred_date" );
				sql.append("  , TO_CHAR(preferred_date,'DD/MM/rrrr HH24:MI Day ') pref_adm_date_desc" );
				sql.append("  , ip_get_desc.ip_medical_service_group (facility_id, med_ser_grp_code, '"+locale+"', 2) med_ser_short_desc" );
				sql.append("  , bkg_lst_ref_no" );
				sql.append("  , patient_id" );
				sql.append("  , decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name))patient_name" );
				sql.append("  , national_id_no" );
				sql.append("  , alt_id1_no" );
				sql.append("  , mp_get_desc.mp_alternate_id_type(alt_id1_type, '"+locale+"', 1) alt_id1_type_short_desc" );
				sql.append("  , gender" );
				sql.append("  , get_age(date_of_birth)age " );
				sql.append("  , TO_CHAR(date_of_birth,'dd/mm/rrrr') date_of_birth" );
				/*Monday, April 26, 2010 , added for PE*/
				sql.append("  , calculate_age(TO_CHAR(date_of_birth,'dd/mm/rrrr'),1) Years" );
				sql.append("  , calculate_age(TO_CHAR(date_of_birth,'dd/mm/rrrr'),2) Months" );
				sql.append("  , calculate_age(TO_CHAR(date_of_birth,'dd/mm/rrrr'),3) Days" );
				/**/
				sql.append("  , res_tel_no" );
				sql.append("  , oth_contact_no" );
				sql.append("  , email_id contact_email" );
				sql.append("  , res_addr_line1" );
				sql.append("  , res_addr_line2" );
				sql.append("  , res_addr_line3" );
				sql.append("  , res_addr_line4" );
				sql.append("  , postal_code" );
				sql.append("  , country_code" );
				sql.append("  , practitioner_id" );
				sql.append("  , am_get_desc.am_practitioner(practitioner_id, '"+locale+"', 1) practitioner_name" );
				sql.append("  , specialty_code" );
				sql.append("  , am_get_desc.am_speciality(specialty_code, '"+locale+"', 2) specialty_short_desc" );
				sql.append("  , nursing_unit_code" );
				sql.append("  , ip_get_desc.ip_nursing_unit(facility_id, nursing_unit_code, '"+locale+"', 2) nursing_unit_short_desc" );
				sql.append("  , room_no" );
				sql.append("  , bed_no" );
				sql.append("  , med_ser_grp_code" );
				sql.append("  , turn_down_reason" );
				sql.append("  , mp_get_desc.mp_country(nationality_code, '"+locale+"', 1) nationality_long_desc" );
				sql.append("  , am_get_desc.am_medical_team(facility_id, team_id, '"+locale+"', 2) team_short_desc" );
				sql.append("  , TO_CHAR(booking_date_time,'dd/mm/rrrr hh24:mi') booking_date_time" );
				sql.append("  , booking_status" );
				sql.append("  , substr(email_id,1,24)|| '\n'||substr(email_id,25,50) email_id" );
				sql.append("  , ip_get_desc.IP_BED_CLASS(bed_class_code, '"+locale+"', 2) bed_class_short_desc" );
				sql.append("  , ip_get_desc.IP_BED_TYPE(bed_type_code,'"+locale+"','2') bed_type_short_desc ");
				sql.append("  , mp_get_desc.mp_birth_place(birth_place_code, '"+locale+"', 1) birth_place_desc" );
				sql.append("  , citizen_yn" );
				sql.append("  , mp_get_desc.mp_ethnic_group(ethnic_grp_code, '"+locale+"', 1) ethnic_group_desc" );
				sql.append("  , legal_illegal_yn" );
				//sql.append("  , ot_date_time" );
				sql.append("  , TO_CHAR(ot_date_time,'dd/mm/rrrr hh24:mi') ot_date_time" );
				sql.append("  , patient_type_code" );
				sql.append("  , mp_get_desc.mp_race(race_code, '"+locale+"', 1) race_desc" );
				sql.append("  , am_get_desc.am_service(service_code, '"+locale+"', 2) service_short_desc" );
				sql.append("  , exp_days_of_stay" );
				sql.append("  , TO_CHAR(expected_discharge_date,'dd/mm/rrrr hh24:mi') expected_discharge_date" );
				sql.append("  ,round(ot_date_time-preferred_date) pre_op_days ");
				sql.append("  , (" );
				sql.append("  SELECT" );
				sql.append("    nat_id_prompt ");
				sql.append("  FROM" );
				sql.append("    MP_PARAM ");
				sql.append("  WHERE module_id ='MP' ");
				sql.append("  ) nat_id_prompt ");
				sql.append("  , am_get_desc.am_complaint (chief_complaint,'"+locale+"', '1'  ) booking_reason " );
				sql.append("  , am_get_desc.am_contact_reason (reason_for_revision_code,'"+locale+"', '1'  ) revision_reason" );
				sql.append("  ,am_get_desc.am_contact_reason(decode(booking_status,'9',CANCEL_REASON_CODE),'"+locale+"',1)contact_reason" );
				sql.append("  , diagnosis_remarks booking_remarks" );
				sql.append("  , ip_get_desc.ip_booking_type(booking_type_code,'"+locale+"','2') booking_type_desc" );
				sql.append("  , diagnosis_remarks booking_remarks" );
				sql.append("  , override_yn " );
				/*Monday, April 26, 2010 , added for PE*/
				sql.append("  , (SELECT SIGN((TO_DATE(TO_CHAR(booking_date_time,'dd/mm/rrrr hh24:mi'),'dd/mm/rrrr hh24:mi')+NVL(bkg_grace_period,0)- sysdate))valid_flag FROM ip_param WHERE facility_id='"+facility_id+"') valid_flag ");
				/**/
				//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013
				//Start 
				sql.append("  ,oper_short_desc surgery_order,TO_CHAR(pref_surg_date,'DD/MM/YYYY') surgery_date");
				//End
				sql.append(" FROM " );
				sql.append("  IP_BOOKING_LIST ");
				sql.append(" WHERE facility_id ='"+facility_id+"' ");
				sql.append("  AND bkg_lst_ref_no='"+bookingRefNo+"' ");
			}



			stmt	=	con.createStatement();
			rs		=	stmt.executeQuery(sql.toString());
			
			if(rs!=null)
			{
				if(rs.next())
				{
					pref_adm_date_desc			= checkForNull(rs.getString("pref_adm_date_desc")); 
					if(pref_adm_date_desc!=null)
					{
						pref_adm_date_desc = pref_adm_date_desc.trim();
						int dateLength=pref_adm_date_desc.length();
						
						String pref_adm_date_time="";
						String pref_adm_day="";
						if(dateLength > 16)
						{
							 pref_adm_date_time= pref_adm_date_desc.substring(0,16).trim();
							 pref_adm_day=pref_adm_date_desc.substring(17,dateLength).trim();
							 if(!(pref_adm_day==null || pref_adm_day.equals("")))
							{
								 if(pref_adm_day.equalsIgnoreCase("Sunday"))
									pref_adm_day = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								 else if(pref_adm_day.equalsIgnoreCase("Monday"))
									pref_adm_day = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								 else if(pref_adm_day.equalsIgnoreCase("Tuesday"))
									pref_adm_day = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								else if(pref_adm_day.equalsIgnoreCase("Wednesday"))
									pref_adm_day = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								else if(pref_adm_day.equalsIgnoreCase("Thursday"))
									pref_adm_day = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								else if(pref_adm_day.equalsIgnoreCase("Friday"))
									pref_adm_day = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								else if(pref_adm_day.equalsIgnoreCase("Saturday"))
									pref_adm_day = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
							}
						}
						
						if(!(pref_adm_date_time==null || pref_adm_date_time.equals("")))
							pref_adm_date_desc_converted = DateUtils.convertDate(pref_adm_date_time,"DMYHM","en",locale);
						pref_adm_date_desc_converted = pref_adm_date_desc_converted+" "+pref_adm_day;
					}


					bkg_lst_ref_no				= checkForNull(rs.getString("bkg_lst_ref_no"));  
					nursing_unit = checkForNull(rs.getString("nursing_unit_code"));// Included for the CRF - RUT-CRF013 - 23396 
					patient_id					= checkForNull(rs.getString("patient_id"));        
					patient_name				= checkForNull(rs.getString("patient_name"));    
					national_id_no				= checkForNull(rs.getString("national_id_no"));   
					alt_id1_no					= checkForNull(rs.getString("alt_id1_no"));
					ALT_ID1_TYPE_SHORT_DESC		= checkForNull(rs.getString("alt_id1_type_short_desc"));
					gender						= checkForNull(rs.getString("gender"));      
					if (gender.equals("M"))
						gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
					else if (gender.equals("F"))
						gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					else 
						gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

					date_of_birth				= checkForNull(rs.getString("date_of_birth")); 
					if(!date_of_birth.equals(""))
						date_of_birth			= DateUtils.convertDate(date_of_birth,"DMY","en",locale); 
					/*Monday, April 26, 2010 , added for PE*/
					AGE							= checkForNull(rs.getString("Years"));
					MONTHS						= checkForNull(rs.getString("Months"));
					DAYS						= checkForNull(rs.getString("Days"));
					valid_booking				= rs.getInt("valid_flag");
					/**/
					res_tel_no					= checkForNull(rs.getString("res_tel_no"));
					oth_contact_no				= checkForNull(rs.getString("oth_contact_no")); 
					email_id					= checkForNull(rs.getString("email_id"));  
					contact_email				= checkForNull(rs.getString("CONTACT_EMAIL"));
					postal_code					= checkForNull(rs.getString("POSTAL_CODE"));
					country_code				= checkForNull(rs.getString("COUNTRY_CODE"));
					addr_line_1					= checkForNull(rs.getString("RES_ADDR_LINE1"));
					addr_line_2					= checkForNull(rs.getString("RES_ADDR_LINE2"));
					addr_line_3					= checkForNull(rs.getString("RES_ADDR_LINE3"));
					addr_line_4					= checkForNull(rs.getString("RES_ADDR_LINE4"));
					practitioner_name			= checkForNull(rs.getString("practitioner_name"));
 					specialty_short_desc		= checkForNull(rs.getString("specialty_short_desc"));
					if(!bkg_type.equals("D"))
					{
						med_ser_short_desc		= checkForNull(rs.getString("med_ser_short_desc"));
						nursing_unit_short_desc	= checkForNull(rs.getString("nursing_unit_short_desc"));
						room_no					= checkForNull(rs.getString("room_no"));     
						bed_no					= checkForNull(rs.getString("bed_no")); 
						med_ser_grp_code		= checkForNull(rs.getString("med_ser_grp_code"));
						turn_down_reason		= checkForNull(rs.getString("turn_down_reason"));
						bed_class_desc			= checkForNull(rs.getString("bed_class_short_desc"));
						bed_type_short_desc		= checkForNull(rs.getString("bed_type_short_desc"));
						proc_surg_date			= checkForNull(rs.getString("ot_date_time"));
						if(!proc_surg_date.equals(""))
							proc_surg_date		= DateUtils.convertDate(proc_surg_date,"DMYHM","en",locale); 

						pre_op_days				= checkForNull(rs.getString("pre_op_days"));			
						if(pre_op_days==null || pre_op_days.equals(""))
							pre_op_days = "0";
				
					}
					exp_days_of_stay		= checkForNull(rs.getString("exp_days_of_stay"));
					expected_discharge_date	= checkForNull(rs.getString("expected_discharge_date"));
					if(!expected_discharge_date.equals(""))
						expected_discharge_date		= DateUtils.convertDate(expected_discharge_date,"DMYHM","en",locale); 
					age							= checkForNull(rs.getString("age"));				
					nationality					= checkForNull(rs.getString("nationality_long_desc"));
					medteamdesc					= checkForNull(rs.getString("team_short_desc"));
					
					booking_date_time			= checkForNull(rs.getString("booking_date_time"));
					if(!booking_date_time.equals(""))
						booking_date_time		= DateUtils.convertDate(booking_date_time,"DMYHM","en",locale); 

					booking_status				= checkForNull(rs.getString("booking_status"));
					
					birth_place_desc			= checkForNull(rs.getString("birth_place_desc"));
					citizen_yn					= checkForNull(rs.getString("citizen_yn"));
					ethnic_grp_desc				= checkForNull(rs.getString("ethnic_group_desc"));
					legal_yn					= checkForNull(rs.getString("legal_illegal_yn"));
					race_desc					= checkForNull(rs.getString("race_desc"));
					nat_id_prompt				= checkForNull(rs.getString("nat_id_prompt"));
					booking_reason				= checkForNull(rs.getString("booking_reason"));
					revision_reason				= checkForNull(rs.getString("revision_reason"));
					booking_remarks				= checkForNull(rs.getString("booking_remarks"));
					contact_reason				= checkForNull(rs.getString("contact_reason"));
					booking_type_desc			= checkForNull(rs.getString("booking_type_desc"));
					override_yn					= checkForNull(rs.getString("override_yn"),"N");
					//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013
					//Start
					surgery_order					= checkForNull(rs.getString("surgery_order"),"");
					surgery_date = checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("surgery_date"),"DMY","en",locale));	
					//End
						
									
					if(legal_yn.equals("Y")) 
						legal_yn = "Legal";
					else
						legal_yn = "Illegal";
					if(citizen_yn.equals("Y")) 
						citizen_yn = "Citizen";
					else
						citizen_yn = "Non-Citizen";
					contact_vals.append(res_tel_no+"||");
					contact_vals.append(oth_contact_no+"||");
					contact_vals.append(contact_email+"||");
					contact_vals.append(postal_code+"||");
					contact_vals.append(country_code+"||");
					contact_vals.append(addr_line_1+"||");
					contact_vals.append(addr_line_2+"||");
					contact_vals.append(addr_line_3+"||");
					contact_vals.append(addr_line_4);
				}
			}	
		
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
//out.println("<script>alert(\"booking_remarks : "+booking_remarks.length()+"\");</script>");	
		/*Monday, April 26, 2010 commented for for PE and added in main query*/
		/*
		StringBuffer Check_val = new StringBuffer();
		Check_val.append("SELECT SIGN((TO_DATE('");
		Check_val.append(booking_date_time);
		Check_val.append("','dd/mm/rrrr hh24:mi')+NVL(bkg_grace_period,0)- sysdate))");
		Check_val.append(" valid_flag FROM ip_param WHERE facility_id='");
		Check_val.append(facility_id);
		Check_val.append("'");
		stmt = con.createStatement();		
		rs = stmt.executeQuery(Check_val.toString());
		if(rs != null)
		{
			while(rs.next())
			{
				 valid_booking = rs.getInt("valid_flag");
			}
		}
		if (rs != null) rs.close();
		//if (stmt != null) stmt.close(); 
		
		String DAYS,MONTHS,AGE;
		String age_sql = "select calculate_age('"+date_of_birth+"',1) from dual";
		rs = stmt.executeQuery(age_sql);
		rs.next();
		AGE = rs.getString(1);
		if (rs != null) rs.close();

		String MONTHS_sql = "select calculate_age('"+date_of_birth+"',2) from dual";
				
		rs = stmt.executeQuery(MONTHS_sql);
		rs.next();
		MONTHS = rs.getString(1);
		if (rs != null) rs.close();

		String DAYS_sql = "select calculate_age('"+date_of_birth+"',3) from dual";
				
		rs = stmt.executeQuery(DAYS_sql);
		rs.next();
		DAYS = rs.getString(1);
//out.println("AGE"+AGE);
//out.println("MONTHS"+MONTHS);
//out.println("DAYS"+DAYS);
		if (rs != null) rs.close();
		if (stmt != null) stmt.close(); 
		*/
		
%>
<form name='amend_booking' id='amend_booking' action='../../servlet/eIP.AmendBookingServlet' method='post' target='messageFrame'>

<TABLE border='0' cellpadding='0' cellspacing='0' width='100%'>

	<tr>
		<TD class='label' width='25%' nowrap><fmt:message key="eIP.ProcedureSurgeryDateTime.label" bundle="${ip_labels}"/></TD>
		<TD class='QUERYDATA' width='25%' nowrap><%=proc_surg_date%></TD>
		<td  class='label' width='25%' nowrap><fmt:message key="eIP.PreOpPreparationDays.label" bundle="${ip_labels}"/></td>
		<td class='QUERYDATA' width='25%' nowrap><%=pre_op_days%></td>
	</TR>
	<tr>
		<td colspan='4'>&nbsp;</td>
	</tr>
	<tr>
		<TD class='label' width='25%' nowrap><fmt:message key="eIP.PrefAdmDateTime.label" bundle="${ip_labels}"/></TD>
		<TD class='QUERYDATA' width='25%' nowrap><%=pref_adm_date_desc_converted%></TD>
		<TD class='label'  width='25%' nowrap><fmt:message key="eIP.MedicalServiceGroup.label" bundle="${ip_labels}"/></TD>
		<TD class='QUERYDATA' nowrap width='25%'><%=med_ser_short_desc%> <input type='hidden' name='med_ser_grp_code' id='med_ser_grp_code' value='<%=med_ser_grp_code%>'></TD>
	</TR>
	
	<tr>
		<td colspan='4'>&nbsp;</td>
	</tr>
	<TR>
		<TD class='label' width='25%' nowrap><fmt:message key="eIP.ExpdaysofStay.label" bundle="${ip_labels}"/></TD>
		<TD class='QUERYDATA'  nowrap width='25%'><%=exp_days_of_stay%></TD>
		<TD class='label'  nowrap width='25%'><fmt:message key="eIP.ExpectedDischargeDateTime.label" bundle="${ip_labels}"/></TD>
		<TD class='QUERYDATA'  nowrap width='25%'><%=expected_discharge_date%></TD>
	</TR>
	<tr>
		<td colspan='4'>&nbsp;</td>
	</tr>
	<tr>
		<td class="COLUMNHEADER" colspan='4'><b><fmt:message key="eIP.BookingDetails.label" bundle="${ip_labels}"/></b></td>
	</tr>
	<tr>
		<td colspan='4'>&nbsp;</td>
	</tr>
	<TR>
		<TD class='label' width='25%' nowrap><fmt:message key="eIP.BookingDateTime.label" bundle="${ip_labels}"/></TD>
		<TD class='QUERYDATA'  nowrap width='25%'><%=booking_date_time%></TD>
		<TD class='label'  nowrap width='25%'><fmt:message key="Common.BookingRefNo.label" bundle="${common_labels}"/></TD>
		<TD class='QUERYDATA'  nowrap width='25%'><%=bkg_lst_ref_no%><input type='hidden' name='bkg_lst_ref_no' id='bkg_lst_ref_no' value='<%=bkg_lst_ref_no%>'></TD>
	</TR>
	<tr>
		<td colspan='4'>&nbsp;</td>
	</tr>
	<% if(!calling_func.equals("CB")){
		%>
	<TR>
		<TD class='label' width='25%' nowrap><fmt:message key="eIP.Reasonforbooking.label" bundle="${ip_labels}"/></TD>
		<%if(booking_reason != null && !booking_reason.equals("")) {%>
		<td class='QUERYDATA' width='25%' style = 'word-break:break-all;'><%=booking_reason%></td><%}else{%> <td class='QUERYDATA'  nowrap width='25%'>&nbsp;</td><%}%>


		<TD class='label'  nowrap width='25%'><fmt:message key="eIP.Reasonforrevision.label" bundle="${ip_labels}"/></TD>
		<TD class='QUERYDATA'  style = 'word-break:break-all;' width='25%'><%=revision_reason%></TD>
	</TR>
	<tr>
		<td colspan='4'>&nbsp;</td>
	</tr>

	<TR>
		<TD class='label' width='25%' nowrap><fmt:message key="Common.booking.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></TD>
		<%if(booking_remarks != null && !booking_remarks.equals("")) {%>
		<td class='QUERYDATA' width='25%'  style = 'word-break:break-all;'><%=booking_remarks%></td><%}else{%> <td class='QUERYDATA'  nowrap width='25%'>&nbsp;</td><%}%>
		<TD class='label'  nowrap width='25%'><!--/*modification for SRR20056-CRF-0506*/--><fmt:message key="eIP.BookingType.label" bundle="${ip_labels}"/></TD>
		<TD class='QUERYDATA'  nowrap style = 'word-break:break-all;' width='25%'><%=booking_type_desc%></TD>
	</TR>
	<tr>
		<td colspan='4'>&nbsp;</td>
	</tr>
	<%}  if(calling_func.equals("CB")) {
			 if(booking_status.equals("9")) {%>
			<TR>
		<TD class='label' width='25%' nowrap><fmt:message key="Common.ReasonforCancellation.label" bundle="${common_labels}"/></TD>
		<TD class='QUERYDATA'  style = 'word-break:break-all;' width='25%'><%=contact_reason%></TD>
		<TD class='label'  nowrap width='25%'><!--/*modification for SRR20056-CRF-0506*/--><fmt:message key="eIP.BookingType.label" bundle="${ip_labels}"/></TD>
			<TD class='QUERYDATA'  nowrap width='25%' style = 'word-break:break-all;'><%=booking_type_desc%></TD>
	</TR>
	<tr>
		<td colspan='4'>&nbsp;</td>
	</tr>
	<%} else  if(booking_status.equals("1")) { %>
		<TR>
				 <TD class='label' width='25%' nowrap><fmt:message key="eIP.Reasonforbooking.label" bundle="${ip_labels}"/></TD>
		        <TD class='QUERYDATA'  style = 'word-break:break-all;' width='25%'><%=booking_reason%></TD>
				<TD class='label' width='25%' nowrap><fmt:message key="eIP.Reasonforrevision.label" bundle="${ip_labels}"/></TD>
		         <TD class='QUERYDATA'  style = 'word-break:break-all;' width='25%'><%=revision_reason%></TD>
		</TR>
		<tr>
			<td colspan='4'>&nbsp;</td>
		</tr>
		<tr>
				<TD class='label' width='25%' nowrap><fmt:message key="Common.booking.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></TD>
			<!--<TD class='QUERYDATA'  nowrap width='25%'><%if(booking_remarks != null) {%><a href="javascript:showRemarks('<%=booking_remarks%>')"><fmt:message key="Common.view.label" bundle="${common_labels}"/></a><%}%></TD>-->
			<%if(booking_remarks != null && !booking_remarks.equals("")) {%>
			<td class='QUERYDATA'  style = 'word-break:break-all;' width='25%'><%=booking_remarks%></td><%}else{%> <td class='QUERYDATA'  nowrap width='25%'>&nbsp;</td><%}%>
			<TD class='label'  nowrap width='25%'><!--/*modification for SRR20056-CRF-0506*/--><fmt:message key="eIP.BookingType.label" bundle="${ip_labels}"/></TD>
			<TD class='QUERYDATA'  nowrap width='25%' style = 'word-break:break-all;'><%=booking_type_desc%></TD>
		</tr>
	<tr>
		<td colspan='4'>&nbsp;</td>
	</tr>

	<%	} }%>
	<tr>
		<td class="COLUMNHEADER" colspan='4'><b><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></b></td>
	</tr>
	<TR>
		<TD class='label' colspan ='4'>&nbsp;</TD>
	</TR>
	<tr>
		<TD class='label'  width='25%' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></TD>
		<TD class='QUERYDATA'  nowrap width='25%'><%=patient_id%></TD>
		<TD class='label'   width='25%'  style = 'word-break:break-all;'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></TD>
		<TD class='QUERYDATA'  width='25%' style = 'word-break:break-all;'><%=patient_name%></TD>
	</TR>
	<tr>
		<td colspan='4'>&nbsp;</td>
	</tr>
	<TR>
		<TD class='label'  width='25%' nowrap><%=nat_id_prompt%></TD>
		<TD class='QUERYDATA'  nowrap width='25%'><%=national_id_no%></TD>
		<TD class='label'  nowrap width='25%'><%=ALT_ID1_TYPE_SHORT_DESC%></TD>
		<TD class='QUERYDATA'  nowrap width='25%'><%=alt_id1_no%></TD>
	</TR>
	<tr>
		<td colspan='4'>&nbsp;</td>
	</tr>
	<TR>
		<TD class='label'  width='25%' nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></TD>
		<TD class='QUERYDATA'  width='25%' nowrap><%=gender%><input type='hidden' name='gender' id='gender' value="<%=gender%>"></TD>
		<TD class='label'  width='25%' nowrap><fmt:message key="Common.age.label" bundle="${common_labels}"/></TD>
		<TD class='QUERYDATA'  width='25%' nowrap><%=AGE%>Y/<%=MONTHS%>M/<%=DAYS%>D </TD>
	</TR>
	<tr>
		<td colspan='4'>&nbsp;</td>
	</tr>
	<TR>
		<TD class='label'  nowrap ><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></TD>
		<TD class='QUERYDATA'  ><%=date_of_birth%></TD>
		<TD class='label'  >&nbsp;</TD>
		<TD class='label' >&nbsp;</TD>
	</TR>
	<tr>
		<td colspan='4'>&nbsp;</td>
	</tr>
	<TR>
		<TD class='label'  nowrap width='25%'><fmt:message key="Common.birthPlace.label" bundle="${common_labels}"/></TD>
		<TD class='QUERYDATA'  nowrap width='25%'><%= birth_place_desc%></TD>
		<TD class='label'  width='25%' ><fmt:message key="Common.residency.label" bundle="${common_labels}"/></TD>
		<TD class='QUERYDATA'  width='25%'><%=citizen_yn%></TD>
		
	</TR>
	<tr>
		<td colspan='4'>&nbsp;</td>
	</tr>
	<TR>
		<TD class='label'  nowrap width='25%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></TD>
		<TD class='QUERYDATA'  nowrap width='25%'><%=legal_yn%></TD>
		<TD class='label'  width='25%' ><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></TD>
		<TD class='QUERYDATA'  width='25%'><%=nationality%></TD>
	</TR>
	<tr>
		<td colspan='4'>&nbsp;</td>
	</tr>
	<TR>
		<TD class='label'  nowrap width='25%'><fmt:message key="Common.race.label" bundle="${common_labels}"/></TD>
		<TD class='QUERYDATA'  nowrap width='25%'><%=race_desc%></TD>
		<TD class='label'  width='25%' ><fmt:message key="eMP.ethnicity.label" bundle="${mp_labels}"/></TD>
		<TD class='QUERYDATA'  width='25%'><%=ethnic_grp_desc%></TD>
	</TR>
	<tr>
		<td colspan='4'>&nbsp;</td>
	</tr>
	<TR>
		<TD class='label'  width='25%' nowrap><fmt:message key="eMP.telephoneres.label" bundle="${mp_labels}"/></TD>
		<TD class='QUERYDATA'  nowrap width='25%'><%=res_tel_no%></TD>
		<TD class='label'  width='25%'><fmt:message key="Common.othertelno.label" bundle="${common_labels}"/></TD>
		<TD class='QUERYDATA'  nowrap width='25%'><%=oth_contact_no%></TD>
	</TR>
	<tr>
		<td colspan='4'>&nbsp;</td>
	</tr>
	<TR>
		<TD class='label'  width='25%' ><fmt:message key="Common.email.label" bundle="${common_labels}"/></TD>
		<TD class='QUERYDATA'  width='25%' colspan='3'><%=email_id%></TD>
	</TR>
<%
	if(calling_func.equals("AB")) { %>
	<tr>
		<td colspan='4'  class='fileds'><input type='button' class='button' name='contact_dtls' id='contact_dtls' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ContactDetails.label","common_labels")%>'  onClick='displayDetails();'></td>
	</tr>
<% } %>

	<tr>
		<td class="COLUMNHEADER" colspan='4'><b><fmt:message key="Common.NursingUnitDetails.label" bundle="${common_labels}"/></b></td></tr>
	</tr>
	<TR>
		<TD class='label' colspan ='4'>&nbsp;</TD>
	</TR>
	<TR>
		<TD class='label'  nowrap width='25%'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></TD>
		<TD class='QUERYDATA'  nowrap width='25%'><%=nursing_unit_short_desc%></TD>
		<TD class='label'  width='25%' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></TD>
		<TD class='QUERYDATA'  nowrap width='25%' ><%=specialty_short_desc%></TD>
	</TR>
	<tr>
		<td class="label" colspan='4'>&nbsp;</td>
	</tr>
	<TR>
		<TD class='label'  width='25%' nowrap><fmt:message key="eIP.AdmittingPractitioner.label" bundle="${ip_labels}"/></TD>
		<TD class='QUERYDATA'  nowrap width='25%'><%=practitioner_name%></TD>
		<TD class='label'  width='25%' nowrap><fmt:message key="Common.medicalteam.label" bundle="${common_labels}"/></TD>
		<TD class='QUERYDATA'  nowrap width='25%' ><%=medteamdesc%></TD>
	</TR>
	<TR>
		<TD class='label' colspan ='4'>&nbsp;</TD>
	</TR>
	<!--
</TABLE>
<TABLE border='0' cellpadding='0' cellspacing='0' width='100%' id= 'bed_details'> -->
<div id = 'bed_details'>
	<tr>
		<td class="COLUMNHEADER" colspan='4'><b><fmt:message key="eIP.BedDetails.label" bundle="${ip_labels}"/></b></td>
	</tr>
	<tr>
		<td class="label" colspan='4'>&nbsp;</td>
	</tr>
	<TR>
		<TD class='label' nowrap width='25%'><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></TD>
		<TD class='QUERYDATA' nowrap width='25%'><%=bed_class_desc%></TD>
		<TD class='label'  nowrap width='25%'><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/></TD>
		<TD class='QUERYDATA'  nowrap width='30%'><%=bed_type_short_desc%> </TD>
		
	</TR>
	<tr>
		<td class="label" colspan='4'>&nbsp;</td>
	</tr>
	<TR>
		<TD class='label'   nowrap width='25%'><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></TD>
		<TD class='QUERYDATA'   nowrap width='25%'><%=bed_no%></TD>
		<TD class='label'   nowrap width='25%'><fmt:message key="Common.roomno.label" bundle="${common_labels}"/></TD>
		<TD class='QUERYDATA'  nowrap width='25%'><%=room_no%></TD>
	</TR>
	<tr>
		<td class="label" colspan='4'>&nbsp;</td>
	</tr>
	<!--Tuesday, February 15, 2011,SRR20056-SCF-6436 [IN:025877]-->
	<%if(!bed_no.equals("")){%>
	<tr>
		<TD class='label'   nowrap width='25%'><fmt:message key="Common.override.label" bundle="${common_labels}"/></TD>
		<TD class='QUERYDATA'   nowrap width='25%'>
		<%if(override_yn.equals("Y"))
			{ %>
				<img src='../../eCommon/images/enabled.gif'align='center'></img>
		<%	}
			else
			{	%>
				<img src='../../eCommon/images/RRnwd.gif'align='center'></img>
		<%	}	%>
		</TD>
		<TD class='label'   nowrap width='25%'><fmt:message key="eIP.SurgeryOrder.label" bundle="${ip_labels}"/></TD>
		<TD class='QUERYDATA'  nowrap width='25%'><%=surgery_order%></TD>
	</tr>
	<%}%><!--SRR20056-SCF-6436 [IN:025877] end-->
	<!--Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 09/01/2013
	Start-->
	<%if(bed_no.equals("")){%>
	
	<TR>
		<TD class='label'   nowrap width='25%'></TD>
		<TD class='QUERYDATA'   nowrap width='25%'></TD>
		<TD class='label'   nowrap width='25%'><fmt:message key="eIP.SurgeryOrder.label" bundle="${ip_labels}"/></TD>
		<TD class='QUERYDATA'  nowrap width='25%'><%=surgery_order%></TD>
	</TR>
	<tr>
		<td class="label" colspan='4'>&nbsp;</td>
	</tr>
	<TR>
		<TD class='label'   nowrap width='25%'></TD>
		<TD class='QUERYDATA'   nowrap width='25%'></TD>
		<TD class='label'   nowrap width='25%'><fmt:message key="eIP.SurgeryDate.label" bundle="${ip_labels}"/></TD>
		<TD class='QUERYDATA'  nowrap width='25%'><%=surgery_date%></TD>
	</TR>
		<%}
		
		else
			{
			%>
			<tr>
		<td class="label" colspan='4'>&nbsp;</td>
	</tr>
	<TR>
		<TD class='label'   nowrap width='25%'></TD>
		<TD class='QUERYDATA'   nowrap width='25%'></TD>
		<TD class='label'   nowrap width='25%'><fmt:message key="eIP.SurgeryDate.label" bundle="${ip_labels}"/></TD>
		<TD class='QUERYDATA'  nowrap width='25%'><%=surgery_date%></TD>
	</TR>
			<%
			}
			%>
		
	
	<!--End-->
	</div>
</TABLE>
<TABLE border='0' cellpadding='0' cellspacing='0' width='100%' id='revisetxt'>
	<tr>
		<td class="label" colspan='4'>&nbsp;</td>
	</tr>
	<tr>
		<td  class='label' width='25%' nowrap><fmt:message key="Common.ReasonforCancellation.label" bundle="${common_labels}"/></td>
		<td  nowrap width='75%' class='fileds'><select name="reason_for_revision" id="reason_for_revision">
		<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
		<%
			StringBuffer  sqlreason = new StringBuffer();
			/*sqlreason.append("Select Contact_Reason, Contact_Reason_Code from AM_CONTACT_REASON_LANG_VW ");
			sqlreason.append(" where language_id='"+locale+"' and Cancel_Booking_Yn = 'Y' and Eff_Status = 'E' order by 1");*/
			if(calling.equals("") && !calling_func.equals("AB"))
			{
				sqlreason.append("Select am_get_desc.am_contact_reason(Contact_Reason_code,?,1)Contact_Reason, Contact_Reason_Code from AM_CONTACT_REASON ");
				sqlreason.append(" where Cancel_Booking_Yn = 'Y' and Eff_Status = 'E' order by 1");

				stmt2 = con.prepareStatement(sqlreason.toString());
				stmt2.setString(1,locale);
				rset2 = stmt2.executeQuery();
				if(rset2 != null)
				{
					while(rset2.next())
					{
						String CDesc = rset2.getString("Contact_Reason");
						String CCode = rset2.getString("Contact_Reason_Code"); %>
						<option value='<%=CCode%>'><%=CDesc%></option>
				<%	}			
				}	
			}%>
			</select>
		<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
	</tr>
	<tr>&nbsp;
	</tr>
	<!-- Included for the CRF - RUT-CRF013 - 23396 -->
	<tr>
		<td  class='label'><a href='javascript:PatInsModalWindow()'><fmt:message key="eAM.PatInstructions.label" bundle="${am_labels}"/></a>
		<img src='../../eCommon/images/InfoAlert.PNG' id='NUInstsExist' style='visibility:hidden'/></td>	
		<td  colspan=3></td>
	</tr>
</TABLE>
<table border='0' cellpadding='0' cellspacing='0' width='98%' id='turndowntxt' >
	<tr>
		<td  class='label' width='30%' ><fmt:message key="eIP.ReasonforTurnDownAdmission.label" bundle="${ip_labels}"/></td>
		<td  nowrap class='fileds'><textarea name='reason_for_turndown' rows=2 cols='60' onBlur='checkMaxLimit1(this,500)'><%=turn_down_reason%></textarea>
		<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
	</tr>
</table>	
<table border='0' cellpadding='0' cellspacing='0' id='allbuttons' align='right' >
	<tr>
	<%
		if(calling.equals("") && !calling_func.equals("AB"))
		{
			if(!booking_status.equals("1"))
			{	
		%>
		<td  class='fileds'><input type='button' name='conappt' id='conappt' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ConfirmBooking.label","common_labels")%>' class="BUTTON" onclick="confirmBooking(bkg_lst_ref_no)"></td>
		<%
			}	
			if(!calling_func.equals("AB")) 
			{	
				/*Added by Thamizh selvi on 22nd May 2018 against ML-MMOH-CRF-0622 Start*/
				if(isReviseBkgAftrConfrmAppl){
					%>
					<td  class='fileds'><input type='button' name='revappt' id='revappt' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.revisebooking.label","common_labels")%>' class="BUTTON" onclick="callRevise(bkg_lst_ref_no)"></td>
					<%
				}else{/*End*/
					 if(!booking_status.equals("1"))
					{
						%>
						<td  class='fileds'><input type='button' name='revappt' id='revappt' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.revisebooking.label","common_labels")%>' class="BUTTON" onclick="callRevise(bkg_lst_ref_no)"></td>
						<%
					}
				}
				%>
				<td class='fileds'><input type='button' name='cancelappt' id='cancelappt' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelBooking.label","common_labels")%>'  class="BUTTON" onclick='sh_layer()'></td>
				<%
			}
			
		}
		%>	<input type='hidden' name="booking_valid" id="booking_valid" value="<%=valid_booking%>">	
		<td class='fileds'><input type='button' name='close' id='close' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>'  class="BUTTON" onclick="exitwin()"></td>
	</tr>
</table>
<table border='0' cellpadding='0' cellspacing='0' width='100%' align='right' id='cancelbuttons'>
	<tr>		
		<td class='white' width='75%' align='right'></td>
		<td class='fileds'class='white'><input type='button' name='confcancel' id='confcancel' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ConfirmCancellation.label","ip_labels")%>' class="BUTTON" onclick='valcheck1(this)'></td>
		<td  class='fileds' class='white' ><input type='button' name='abcancel' id='abcancel' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AbortCancellation.label","ip_labels")%>'  class="BUTTON" onclick='sh_focus()'></td>
		<td  class='fileds' class='white'><input type='button' name='cancelclose' id='cancelclose' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>'  class="BUTTON" onclick='cancel_layer();exitwin()'></td>
	</tr>
</table>
<table border='0' cellpadding='0' cellspacing='0' width='100%' id='turndownbuttons'>
	<tr>		
		<td></td>
		<td   class='fileds'><input type='button' name='cancel' id='cancel' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abort.label","common_labels")%>' class="BUTTON" onclick='cancel_text_area();'></td>
		<td   class='fileds'><input type='button' name='confcancel' id='confcancel' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.TurnDown.label","ip_labels")%>' class="BUTTON" onclick='valcheck10(this)'></td>
		<td  class='fileds'><input type='button' name='cancelclose' id='cancelclose' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>'  class="BUTTON" onclick='exitwin()'></td>
	</tr>
</table>	
<table border='0' cellpadding='0' cellspacing='0' width='100%' id='revisebuttons' >
	<tr>
		<td></td>
		<td  class='fileds'><input type='button' name='confrevise' id='confrevise' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ConfirmRevision.label","common_labels")%>' class="BUTTON" onclick='valcheck2(this)'></td>
		<td    class='fileds'><input type='button' name='abrevise' id='abrevise' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AbortRevision.label","ip_labels")%>'  class="BUTTON" onclick='sh_focus()'></td>
		<td  class='fileds'><input type='button' name='reviseclose' id='reviseclose' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>'  class="BUTTON" onclick='exitwin()'></td>
	</tr>
</table>
<table border='0' cellpadding='0' cellspacing='0' width='100%' id='transferbuttons'>
	<tr>
		<td></td>
		<td></td>
		<td  class='fileds'><input type='button' name='abort_revision' id='abort_revision' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AbortRevision.label","ip_labels")%>'  class="BUTTON" onclick='abortwin()'></td>
		<td class='fileds'><input type='button' name='reviseclose' id='reviseclose' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>'  class="BUTTON" onclick='exitwin()'></td>
	</tr>
</table>
<input type='hidden' name="contactvals" id="contactvals" value="<%=contact_vals%>">
<input type='hidden' name='iscapture_fin_dtls_yn' id='iscapture_fin_dtls_yn' value='<%=capture_fin_dtls_yn%>'>
<input type='hidden' name='isBlInstalled' id='isBlInstalled' value='<%=bl_operational%>'>
<input type='hidden' name='bed_no' id='bed_no' value='<%=bed_no%>'>
<!-- Included for the CRF - RUT-CRF013 - 23396 -->
<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
<input type='hidden' name='nursing_unit' id='nursing_unit' value='<%=nursing_unit%>'>
<!--//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023	-->
<input type='hidden' name='smartCardFunc' id='smartCardFunc' value='<%=smartCardFunc%>'>
<input type='hidden' name='biometric_reason' id='biometric_reason' value='<%=biometric_reason%>'>
<!--Ends-->
<!--Below line added for ML-MMOH-CRF-0860.2-->
<input type='hidden' name='increasedaddressLength' id='increasedaddressLength' value='<%=increasedaddressLength%>'>

</form>
<%
	}catch(Exception e) 
	{
		//out.println("err"+e);
		e.printStackTrace();
	}
	finally
	{
		try
		{
			if (rs != null)		rs.close();
			if (stmt2 != null)	stmt2.close();
			if (stmt != null)	stmt.close();
			if (rset2 != null)	rset2.close();
			if (PrRs != null)	PrRs.close();
			if (PrStmt != null) PrStmt.close();
		}
		catch(Exception e) {out.println("err"+e);}
		ConnectionManager.returnConnection(con,request);
	}

if(revise_booking_yn.equals("Y")) {
%>
	<script>if(document.forms[0].revappt) document.forms[0].revappt.enabled = 'true' </script>	
<% } else if	(revise_booking_yn.equals("N")) { %>
	<script>if(document.forms[0].revappt) document.forms[0].revappt.disabled = 'false' </script>

<% } if(confirm_booking_yn.equals("Y")) {%>
	<script>if(document.forms[0].conappt) document.forms[0].conappt.enabled = 'true' </script>
<% } else if	(confirm_booking_yn.equals("N")) { %>
	<script>if(document.forms[0].conappt) document.forms[0].conappt.disabled = 'false' </script>

<% } if(cancel_booking_yn.equals("Y")) {%>
	<script>if(document.forms[0].cancelappt) document.forms[0].cancelappt.enabled = 'true'</script>	
<% } else if	(cancel_booking_yn.equals("N")) { %>
	<script>if(document.forms[0].cancelappt) document.forms[0].cancelappt.disabled = 'false'</script>	
	
<%} if(booking_status.equals("1"))
{ %>
	<script>if(document.forms[0].conappt) document.forms[0].conappt.enabled = 'false'</script>	
<%}
else {%>
	<script>if(document.forms[0].conappt) document.forms[0].conappt.enabled = 'true'</script>	
<%}

	if(calling_func.equals("AT") || calling_func.equals("AB") || calling_func.equals("RCB") || calling_func.equals("Booking_Admission")) 
		out.println("<script>document.getElementById('bed_details').style.visibility='visible';</script>");
	else		
		out.println("<script>document.getElementById('bed_details').style.visibility='hidden';</script>");
%>
</body>
</html>
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

	public static String isSiteSpecificforBiometric(Connection con)
	 {
	 	String function_name="";
	 	PreparedStatement pstmt		= null;
	 	ResultSet rs 				= null;
	 	try
	 	{
	 	String siteSpecificSQL="select nvl(VALUE_2,'00') VALUE_2 from sm_function_control a,SM_SITE_PARAM b  where module_id='MP' and FUNCTIONALITY_ID='SMART_CARD_INTG' and a.SITE_ID=B.CUSTOMER_ID";
	 	pstmt= con.prepareStatement(siteSpecificSQL);
	     rs= pstmt.executeQuery();
	     if(rs!=null && rs.next())
	 	{
	 	function_name=rs.getString("VALUE_2");
	 	}	
	 	}catch(Exception esql)
	 	{
	 		esql.printStackTrace();
	 	}finally
	 	{
	 		try{
	 	 if(pstmt != null)pstmt.close();
	 	 if(rs != null)rs.close();
	 		}catch(Exception fe){
	 			
	 		}
	 	}
	 	return function_name;
}

%>

