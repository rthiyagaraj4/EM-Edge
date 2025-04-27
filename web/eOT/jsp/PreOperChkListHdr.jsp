<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.util.ArrayList,java.util.HashMap,java.sql.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*,eOT.*,eOT.Common.OTRepository,eOT.CheckInBean" contentType=" text/html;charset=UTF-8" %>
<%@ page import = "java.lang.String" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<HTML>
<head>
	<%	
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
	<Script Language="JavaScript" src="../../eOT/js/PreOperCheckIn.js"></Script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script type='text/javascript' src='../../eCommon/js/common.js'></script>
	<script language="javascript" src="../../eOT/js/OTCommon.js"></script>
	<script type='text/javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script type='text/javascript' src='../../eCommon/js/dchk.js'></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<script > var lblPreOperDiag=getLabel("eOT.PreOperativeDiagnosis.Label","OT")	</script>
	<!-- Added by MuthuN against CRF - 011  on 2/7/2013 -->
	<script language="JavaScript" src="../../eOT/js/RecordSurgeon.js"></script>
	<!-- Added by MuthuN against CRF - 011  on 2/7/2013 -->
	<script> 
	// Added by MuthuN against CRF - 011  on 2/7/2013
	var preOperDiagArray = ["surgery_type" , "patient_class" , "patient_id" , "encounter_id" , "SURGEON_DESC" , 
							"SPECIALITY_DESC" , "theatre_desc" , "surgery_date"];
	//Added by MuthuN against CRF - 011  on 2/7/2013
	function clearDesc(){
	var formObj = document.forms[0];
	var pat_id=formObj.patient_id.value;
	if(pat_id=="" || pat_id==null || pat_id=="null" || pat_id=="undefined")

	formObj.patient_name.value="";
	formObj.sex.value="";
	formObj.date_of_birth.value="";
	formObj.encounter_id.value="";
	formObj.episode_id.value="";
	formObj.visit_id.value="";
	formObj.episode_type.value="";
	formObj.nursing_unit.value="";
	formObj.admitting_specialty.value="";
	formObj.source_type.value="";
	formObj.source_code.value="";
	formObj.operation_status.value="";

/*	formObj.patient_name.value="";
	formObj.sex.value="";
	formObj.date_of_birth.value="";
	//Modified ByDhanasekarV agianst CRF- 0859 on 2/12/2010
	formObj.encounter_id.value="";
	formObj.episode_id.value="";
	formObj.visitid.value="";	*/

}
	// Checking Discharge Advice - Rajesh V 10/11/2012 
	function callDischargeChk(){
		var dis_encounter_id = document.getElementById("encounter_id").value;
		var dis_pat_class = document.getElementById("patient_class").value;
		var facilityid = document.PreOperHdr.facility_id.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var param="func_mode=discharge_check&dis_encounter_id="+dis_encounter_id+"&dis_patient_class="+dis_pat_class+"&dis_facility_id="+facilityid;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
		xmlHttp.send(xmlDoc);
		var retVal = localTrimString(xmlHttp.responseText);	
		if(retVal>0){
			alert(getMessage("DIS_ADVICE_ALREAD_EXISIT","IP"));
			var formObj = document.PreOperHdr;
			formObj.patient_id.value = "";
			formObj.patient_name.value="";
			formObj.sex.value="";
			formObj.date_of_birth.value="";
			formObj.encounter_id.value="";
			formObj.episode_id.value="";
			formObj.visit_id.value="";
			formObj.episode_type.value="";
			formObj.nursing_unit.value="";
			formObj.admitting_specialty.value="";
			formObj.source_type.value="";
			formObj.source_code.value="";
			formObj.operation_status.value="";
		}
	}
	// Checking Discharge Advice - Rajesh V 10/11/2012 
	</script>
</head>
<%

	String login_user_id = (String)session.getValue("login_user");
	String mode	= request.getParameter("mode") ;
	mode = CommonRepository.getCommonKeyValue("MODE_INSERT");
	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
  //bean initialization........	 
  String bean_id		= "CheckInBean";
  String bean_name		= "eOT.CheckInBean";
  CheckInBean chk_bean  =  (CheckInBean)mh.getBeanObject( bean_id, request, bean_name );
  String facility_id		=	(String) session.getAttribute("facility_id");
  String surgery_type = checkForNull(request.getParameter("surgery_type"));
  String patient_class = checkForNull(request.getParameter("patient_class"),"IP");
  String patient_id = checkForNull(request.getParameter("patient_id"));
  String called_from = checkForNull(request.getParameter("called_from"));
  //Added by MuthuN against CRF - 011  on 2/7/2013
  String diag_code_scheme ="";
  String practitioner_type ="";
  //Added by MuthuN against CRF - 011  on 2/7/2013
  String check_for_check_list_compl = chk_bean.getCheckListReqdYNFlag("01");  
  String check_in_time					 = chk_bean.getSysDateTime();
  //Added by Sanjay
  check_in_time = DateUtils.convertDate(check_in_time,"DMYHM","en",locale);
  String current_date_format = check_in_time.substring(6,10);
  String booking_no = checkForNull(request.getParameter("booking_no"));//Added by lakshmi against date field requirement in check in page

  //identifiers used..........
  String visit_id = "";
  String order_id = "";
  String waitListNo	= "";
  String surgeryDate = "";
  String bookingNo = "";
  String surgeon_code = "";
  String surgeon_desc = "";
  String anesthetistCode = "";
  String anesthetistDesc = "";
  String anaesthesiaCode = "";
  String anaesthesiaDesc = "";
  String operationStatus = "";
  String surgery_type_desc = "";
  String shortName = "";
  String wardDesc = "";
  String nature_code = "";
  String nature_type = "";
  String dateOfBirth = "";
  String sex = "";
  String episodeType = "";
  String episode_id	= "";
  String order_date_time = "";
  String enable_disable_flag = "";
  String operating_speciality_code = "";
  String operating_speciality_desc = "";
  String admitting_speciality_code = "";
  String admitting_speciality_desc = "";
  String source_code = "";
  String source_type = "";
  String theatre_desc = "";
  String diagnosis = "";
  String asst_surgeon_desc= "";
  String asst_surgeon_code= "";
  String asst_surgeon_desc_2= ""; // Newly added by rajesh on 25/08
  String asst_surgeon_code_2= ""; //newly added by rajesh on 25/08
  String encounterId = "";
  String oper_room_code	= "";
  String order_type_code = "";
  String tab_name = "";
  String verify_checklist_codes = "";	
  String PatIDLen="";
  ArrayList patient_dtl_list = null;
  ArrayList checkin_dtls = null;
  String checkin_backdate_limit="";
  String multi_check_in_yn="";//PMG2016-KDAH-CRF-0001
  String Chk_Date="";
  PreparedStatement pstmt_chk_bak_limit  = null;
  PreparedStatement pstmt_chk_date  = null;
  PreparedStatement pstmt_waitlist  = null;
  ResultSet rs_chk_bak_limit = null;
  ResultSet rs_chk_date = null;
  ResultSet rs_waitlist = null;
	String no_of_verifications = "1";
	String role_id_1 = "";
	String role_id_2 = "";
	String role_id_3 = "";
	String role_id_4 = "";
	String	old_checklist_user_id = "";
	String	checklist_completed_yn = "N";
	int strAnesReqYNPending = 0;

	//Added by lakshmi against date field requirement in check in page starts here
	//String Function_Name= request.getParameter("function_name");
	String Function_Name= checkForNull(request.getParameter("function_name"));//Modified against IN34520

	String bookingDate = "";
	PreparedStatement pstmt2=null;
    ResultSet rs2=null;
    //Added by lakshmi against date field requirement in check in page ends here
	//Added by Sanjay against date field requirement in check in page Emergency case STARTS here
	String orderDateTime = "";
	PreparedStatement pstmt3=null;
    ResultSet rs3=null;	
	//Added by Sanjay against date field requirement in check in page Emergency case ENDS here
	String anaes_review1 = "A";//Added by sanjay for Anaesthesia Required Checkbox against IN032063
	String url_desc = checkForNull(request.getParameter("url_desc"));//Added by lakshmi against RUT-CRF-0032
	
  Connection con = null;
  //Added by MuthuN against CRF - 011  on 2/7/2013
  PreparedStatement stmt=null;
  ResultSet rs_diag=null;
  //Added by MuthuN against CRF - 011  on 2/7/2013
  try
  {
  con = ConnectionManager.getConnection(request);
    //Added by lakshmi against date field requirement in check in page starts here
		pstmt2=con.prepareCall("SELECT to_char(BOOKING_DATE,'dd/mm/yyyy')  BOOKING_START_TIME1 FROM OT_BOOKING_HDR WHERE PATIENT_ID = '"+patient_id+"' and OPERATING_FACILITY_ID = '"+facility_id+"' and BOOKING_NUM = '"+booking_no+"' ");
		rs2=pstmt2.executeQuery();

		if(rs2!=null &&rs2.next()==true)
		{
			bookingDate = DateUtils.convertDate(rs2.getString("BOOKING_START_TIME1"),"DMY","en",locale)+ " 00:00";
			//bookingDate= rs2.getString("BOOKING_START_TIME1")+" 00:00";
		}
		if(rs2!=null)		rs2.close();
		if(pstmt2 !=null) pstmt2.close();
	//Added by lakshmi against date field requirement in check in page ends here
	
	//Added by Sanjay against date field requirement in check in page Emergency case STARTS here
	order_id			= checkForNull(request.getParameter("order_id"));
	pstmt3=con.prepareCall("SELECT to_char(ORDER_DATE_TIME,'dd/mm/yyyy hh24:mi') ORDER_DATE_TIME from ot_pending_order where ORDER_ID = '"+order_id+"' ");
		rs3=pstmt3.executeQuery();
		if(rs3!=null &&rs3.next()==true)
		{
			orderDateTime = DateUtils.convertDate(rs3.getString("ORDER_DATE_TIME"),"DMYHM","en",locale);
			//bookingDate= rs2.getString("BOOKING_START_TIME1")+" 00:00";
		}
		if(rs3!=null)		rs3.close();
		if(pstmt3 !=null) pstmt3.close();
	//Added by Sanjay against date field requirement in check in page Emergency case ENDS here
		if (order_id.length() > 0) {
// To check whether Anesthesia Review is checked when it was ordered in CA. For Pending Orders screen
String sqlAnesReq = "SELECT COUNT(*) FROM AT_PENDING_ORDERS WHERE SOURCE_ORDER_ID = ?";
pstmt3 = con.prepareStatement(sqlAnesReq);
pstmt3.setString(1, order_id);
rs3 = pstmt3.executeQuery();
if (rs3.next() == true) {
	strAnesReqYNPending = rs3.getInt(1);
}
if (rs3 != null)
	rs3.close();
pstmt3.close();
//System.out.println("PreoperChkListHdr strAnesReqYNPending:"	+ strAnesReqYNPending);//Sanjay
/*Added by Sanjay for Anaesthesia Required Checkbox agaisnt IN032063 ENDS here*/
		}
//PMG2016-KDAH-CRF-0001
  String sql_chk_bak_limit = "SELECT CHECKIN_BACKDATE_LIMIT,MULTI_CHECK_IN_YN FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID='"+facility_id+"'";
	
	
		pstmt_chk_bak_limit = con.prepareStatement(sql_chk_bak_limit);
		rs_chk_bak_limit = pstmt_chk_bak_limit.executeQuery();
		while(rs_chk_bak_limit.next()){
			checkin_backdate_limit=checkForNull(rs_chk_bak_limit.getString(1));
			multi_check_in_yn=checkForNull(rs_chk_bak_limit.getString(2));//PMG2016-KDAH-CRF-0001
		}
  
  if(checkin_backdate_limit != "")
  {
	   
		String sql_chk_date = "SELECT TO_CHAR(SYSDATE-'"+checkin_backdate_limit+"','DD/MM/YYYY') FROM DUAL";
		pstmt_chk_date = con.prepareStatement(sql_chk_date);
		rs_chk_date = pstmt_chk_date.executeQuery();
		if(rs_chk_date.next()){
			Chk_Date = rs_chk_date.getString(1);
		}
	
 }
  
//OT-MENU -  DIRECT-CHECK-IN
 if(called_from.equalsIgnoreCase("OT_MENU"))
 {
		enable_disable_flag = "";
  }else if(called_from.equalsIgnoreCase("OT_SLATE")|| called_from.equalsIgnoreCase("BOOKING")){
	// disable the fields and do not allow the user to enter the values
	enable_disable_flag = "disabled";
	if(called_from.equalsIgnoreCase("OT_SLATE"))
		tab_name = checkForNull(request.getParameter("tab_name"));
	if(tab_name.equals("UNSCHEDULED"))
		called_from = "BOOKING";
	// tab_name can be SCHEDULED, UNSCHEDULED, WAITLIST, RESCHEDULED
  }

if(!called_from.equals("OT_MENU")){
	 if(!patient_id.equals("")){
		 patient_dtl_list = chk_bean.getPatientDtls(patient_id);
		 if(patient_dtl_list!=null && patient_dtl_list.size()>0){
			 shortName=(String)patient_dtl_list.get(0);
			 dateOfBirth=(String)patient_dtl_list.get(1);
			 sex =(String)patient_dtl_list.get(2);
		}
	 }
}


//BOOKING-PENDING_ORDERS

 if(called_from.equalsIgnoreCase("BOOKING"))
{
   bookingNo		= checkForNull(request.getParameter("booking_num"),"");
   order_id			= checkForNull(request.getParameter("order_id"));
   surgeon_code		= checkForNull(request.getParameter("surgeon_code"));
	//surgeon_desc = checkForNull(request.getParameter("surgeon_name"));
	surgeon_desc = chk_bean.getSurgeonDesc(surgeon_code); //IN050700
   checkin_dtls		= chk_bean.getCheckInDtlsBasedOnOrder(order_id);
   if(checkin_dtls.size()>0)
	{
	   order_type_code		= (String)checkin_dtls.get(1);
	   episodeType			= checkForNull((String)checkin_dtls.get(3));
	   patient_class		= checkForNull((String)checkin_dtls.get(4));
	   episode_id			= checkForNull((String)checkin_dtls.get(5));
	   encounterId			= checkForNull((String)checkin_dtls.get(6));
	   visit_id				= checkForNull((String)checkin_dtls.get(7));
	   order_date_time		= checkForNull((String)checkin_dtls.get(8));
	   nature_type			= checkForNull((String)checkin_dtls.get(9));
	   nature_code			= checkForNull((String)checkin_dtls.get(10));
	   surgery_type			= nature_code+"::"+nature_type;
	   source_type			= checkForNull((String)checkin_dtls.get(11));
	   source_code			= checkForNull((String)checkin_dtls.get(12));
	   wardDesc = chk_bean.getWardDesc(source_code);
	   surgeryDate = chk_bean.getSysDate();
	   anesthetistCode = checkForNull((String)checkin_dtls.get(13));
	   if(!anesthetistCode.equals(""))
		   anesthetistDesc=chk_bean.getAnaesthetistDesc(anesthetistCode);
	   anaesthesiaCode=checkForNull((String)checkin_dtls.get(14));
	   if(!anaesthesiaCode.equals(""))
		   anaesthesiaDesc=chk_bean.getAnaesthesiaDesc(anaesthesiaCode);
	  admitting_speciality_code = chk_bean.getSpecialtyCode(patient_id,encounterId);
	  admitting_speciality_desc = chk_bean.getSpecialityDesc(admitting_speciality_code);
	   operating_speciality_code =  checkForNull( (String)checkin_dtls.get(15) );
	   if(operating_speciality_code.equals(""))
		   operating_speciality_code = chk_bean.getSpecialityCodeWhenNull(order_type_code);
		   operating_speciality_desc = chk_bean.getSpecialityDesc(operating_speciality_code);
		diagnosis = chk_bean.getPreOperativeDiagnosis(order_id);
	   if(surgeon_code.equals(""))
		{
			surgeon_code = checkForNull((String)checkin_dtls.get(17));
			surgeon_desc = chk_bean.getSurgeonDesc(surgeon_code);
	   }
 }
}
  if(called_from.equalsIgnoreCase("OT_SLATE"))
	{
	 bookingNo = checkForNull(request.getParameter("booking_num"));
	 order_id = checkForNull(request.getParameter("order_id"),"");
	 checkin_dtls = chk_bean.getCheckInDtlsBasedOnBooking(bookingNo); 
	 String sql_waitlist_num="Select WAITLIST_NUM from ot_waitlisting where OPERATING_FACILITY_ID='"+facility_id+"' and ORDER_ID='"+order_id+"'";
		pstmt_waitlist = con.prepareStatement(sql_waitlist_num);
		rs_waitlist = pstmt_waitlist.executeQuery();
		if(rs_waitlist !=null && rs_waitlist.next())
			waitListNo=rs_waitlist.getString("WAITLIST_NUM");
	if(checkin_dtls.size()>0)
	{
		order_type_code = checkForNull((String)checkin_dtls.get(18));	// ORDER_TYPE_CODE
		surgeryDate = chk_bean.getSysDate();
		order_id	= checkForNull((String)checkin_dtls.get(3),"");  // ORDER_ID
		nature_code = checkForNull((String)checkin_dtls.get(4));	// NATURE_CODE
		nature_type = checkForNull((String)checkin_dtls.get(5));	// NATURE_TYPE
		patient_class = checkForNull((String)checkin_dtls.get(6));	// PATIENT_CLASS
		episodeType = checkForNull((String)checkin_dtls.get(7));	// EPISODE_TYPE
		encounterId	= checkForNull((String)checkin_dtls.get(8));	// ENCOUNTER_ID
		admitting_speciality_code = chk_bean.getSpecialtyCode(patient_id,encounterId);
		admitting_speciality_desc = chk_bean.getSpecialityDesc(admitting_speciality_code);
		episode_id = checkForNull((String)checkin_dtls.get(9));	// EPISODE_ID
		visit_id = checkForNull((String)checkin_dtls.get(10));		// VISIT_ID
		surgery_type = checkForNull((String)checkin_dtls.get(4))+"::"+checkForNull((String)checkin_dtls.get(5));
		surgery_type_desc = ""; //to be checked
		surgeon_code = checkForNull((String)checkin_dtls.get(11));// TEAM_DOCTOR_CODE
		
		if(!surgeon_code.equals(""))
			surgeon_desc =chk_bean.getSurgeonDesc(surgeon_code);  
		anaesthesiaCode=checkForNull((String)checkin_dtls.get(12));		// ANAESTHESIA_CODE
		anaesthesiaDesc=chk_bean.getAnaesthesiaDesc(anaesthesiaCode);
		anesthetistCode = checkForNull((String)checkin_dtls.get(13));
		// ANAESTHETIST1_CODE
		anesthetistDesc = chk_bean.getAnaesthetistDesc(anesthetistCode);
		anesthetistDesc=checkForNull(anesthetistDesc);
		operating_speciality_code = checkForNull((String)checkin_dtls.get(14));	// SPECIALITY_CODE
	    if(operating_speciality_code.equals(""))
		   operating_speciality_code = chk_bean.getSpecialityCodeWhenNull(order_type_code);
	    operating_speciality_desc = chk_bean.getSpecialityDesc(operating_speciality_code);
		source_code  = checkForNull((String)checkin_dtls.get(15));
		source_type = checkForNull((String)checkin_dtls.get(16));
		if(!source_code.equals(""))
		wardDesc = chk_bean.getWardDesc(source_code);
		oper_room_code=checkForNull((String)checkin_dtls.get(17));
		theatre_desc = chk_bean.getTheatreDesc(oper_room_code);
		order_type_code=checkForNull((String)checkin_dtls.get(18));
		//patient_id = checkForNull((String)checkin_dtls.get(19));
		diagnosis = checkForNull((String)checkin_dtls.get(20));
		
		asst_surgeon_desc = checkForNull((String)checkin_dtls.get(21));
		asst_surgeon_code = checkForNull((String)checkin_dtls.get(22));
		asst_surgeon_desc_2 = checkForNull((String)checkin_dtls.get(23));
		asst_surgeon_code_2 = checkForNull((String)checkin_dtls.get(24));
	}
  }
	else if(called_from.equalsIgnoreCase("OT_MENU"))
	{
     surgeryDate = chk_bean.getSysDate();
  }
// to compare the user who already entered the data with the current user


	ArrayList verify_checklist_arr = chk_bean.getOperChecklists(bookingNo,"",operating_speciality_code,order_id); 
	if(verify_checklist_arr.size()>0){
		verify_checklist_codes=(String)verify_checklist_arr.get(0);

		no_of_verifications = (String)verify_checklist_arr.get(1);
		role_id_1 = (String)verify_checklist_arr.get(2);
		role_id_2 = (String)verify_checklist_arr.get(3);
		role_id_3 = (String)verify_checklist_arr.get(4);
		role_id_4 = (String)verify_checklist_arr.get(5);
	}
	ArrayList user_info_arr = (ArrayList)chk_bean.getUserInfo(bookingNo,"","2",order_id);


	if(user_info_arr.size()>0){
		old_checklist_user_id = (String)user_info_arr.get(0);
		checklist_completed_yn = (String)user_info_arr.get(1);
	}

// till here
 %>

<body onLoad="AssignDBValue();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='PreOperHdr' id='PreOperHdr'>
<table border='0' cellpadding=3  cellspacing='0' width='100%' align='center'>
<%
	if(called_from.equalsIgnoreCase("OT_MENU"))
	{
	// Patient Line should not be hidden
%>
<tr>
	<td class="label"  width='25%' >
		<fmt:message key="eOT.SurgeryDate.Label" bundle="${ot_labels}"/>
	</td> 
	<%if(("").equals(checkin_backdate_limit)||("0").equals(checkin_backdate_limit)){%>
	<td class="fields" width='25%' >
		<input type='text' class="fields" name='surgery_date' id='surgery_date' size='8'  value='<%=surgeryDate%>'>
		<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('surgery_date');"><img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<%}else{%>
	<td class="fields" width='25%' >
		<input type='text' class="fields" name='surgery_date' id='surgery_date' size='8' maxlength='10' value='<%=surgeryDate%>' onBlur="ValidateSurgeryDate('<%=checkin_backdate_limit%>','<%=surgeryDate%>','<%=Chk_Date%>',this);surgery_date_change()" <%=enable_disable_flag%> onkeypress="return checkForSpecCharsforID(event);">
		<% //if(called_from.equals("OT_MENU")) { %>
		<!--<image src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('surgery_date');">-->
		<%// } %>
		<input type='image' id='cal' src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('surgery_date'); ">
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<%}%>

	<td class="label" width='25%' >
		<fmt:message key="eOT.BookingNO.Label" bundle="${ot_labels}"/> </td> 
	<td class="fields" width='25%' >
		<input type='text' class="fields" name='booking_no' id='booking_no' size='15'  value='<%=bookingNo%>' disabled>
	</td>
</tr>

<tr><td class="label" width='25%' >
		<fmt:message key="eOT.WaitListNO.Label" bundle="${ot_labels}"/> </td>
	
	<td class="fields" width='25%' >
		<input type='text' class="fields" name='waitlist_no' id='waitlist_no' size='14'  readonly value='<%=waitListNo%>' >
	</td>
	<td class="label" width='25%' >
		<fmt:message key="Common.OrderID.label" bundle="${common_labels}"/> </td>
	<td class="fields" width='25%' > 
		<input type='text' class="fields" name='order_id' id='order_id' size='15' disabled
		value='<%=order_id%>'>
	</td>
</tr>

<tr>
	<td class="label" width='25%' ><fmt:message key="Common.SurgeryType.label" bundle="${common_labels}"/></td>
	<td  width='25%' class="fields" >
		<select name='surgery_type' id='surgery_type' onChange='funAssingnValues(this);showPreOperDiagLink();' <%=enable_disable_flag%>>
			<option value='' ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
			<%
					HashMap surgeryDtls = chk_bean.getSurgeryTypeDtls();
					HashMap tempmap = new HashMap();
					int size = surgeryDtls.size();
					String surgery_type_sel = "";
					String surgery_type_val = "";
					String nature_type_temp = "";
					String nature_code_temp = "";
					for(int i=1;i<=size;i++){
						tempmap =(HashMap) surgeryDtls.get(""+i);
						surgery_type_desc=""+tempmap.get("short_desc");
						nature_code_temp=""+tempmap.get("nature_code");
						nature_type_temp=""+tempmap.get("nature_type");
						surgery_type_val = nature_code_temp+"::"+nature_type_temp;
						if(surgery_type.equals(surgery_type_val))
							surgery_type_sel = "selected";
						else
							surgery_type_sel = "";
		%>
		<option value='<%=surgery_type_val%>' <%=surgery_type_sel%>><%=surgery_type_desc%> </option>
		<% } %>
		</select><img src='../../eCommon/images/mandatory.gif'></img>
	</td>
<td class="label" width='25%' ><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/>  </td>
<td class="fields" width='25%' >
<select name='patient_class' id='patient_class'  value='' <%=enable_disable_flag%> onChange="clearFlds();showPreOperDiagLink();" >
<% 
	 
    String selected = "";
	String sql = "SELECT PATIENT_CLASS,SHORT_DESC FROM AM_PATIENT_CLASS_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND PATIENT_CLASS NOT IN ('XT') ORDER BY 1";
	//Connection con = null;
	PreparedStatement pstmt  = null;
	ResultSet rs = null;
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()){
		selected = patient_class.equals( rs.getString(1) )?"selected":"";
%>
<option value='<%=rs.getString(1)%>' <%=selected%> > <%=rs.getString(2)%></option>			
		
<%}
	
  %>
</select>
<img src='..\..\eCommon/images/mandatory.gif'></img>
</td>
</tr>
<%  
		String sqlLen ="SELECT PATIENT_ID_LENGTH FROM MP_PARAM ";
		pstmt=con.prepareStatement(sqlLen);
		rs=pstmt.executeQuery();
		while(rs.next() && rs!=null)
		{
		PatIDLen   = (rs.getString("PATIENT_ID_LENGTH")==null)?"0":rs.getString("PATIENT_ID_LENGTH");
		}
		
	 
  
 %>

<tr>
	<td class="label" width='25%'  readonly>
		<fmt:message key="Common.patientId.label" bundle="${common_labels}"/> </td>
	<td class="fields" width='25%'>
		<!-- Checking Discharge Advice - Rajesh V 10/11/2012  -->
		<!-- Commented the below function calls after fixing the issue-->
		
		<!--<input type='text' class="fields" name='patient_id' id='patient_id' maxlength='<%=PatIDLen%>' size='<%=PatIDLen%>' value='<%=patient_id%>' <%=enable_disable_flag%> onBlur='if(this.value!=""){callPatientSearch(); callDischargeChk();} else{ clearDesc();}' onkeypress="return CheckForSpecChars(event)">
		 <input type='button' class='button' name='patientLookUp' id='patientLookUp' value='?' onClick='callPatientSearch();callDischargeChk();' <%=enable_disable_flag%>> -->

		 <input type='text' class="fields" name='patient_id' id='patient_id' maxlength='<%=PatIDLen%>' size='<%=PatIDLen%>' value='<%=patient_id%>' <%=enable_disable_flag%> onBlur='if(this.value!=""){callPatientSearch();} else{ clearDesc();}' onkeypress="return CheckForSpecChars(event)">
		 <input type='button' class='button' name='patientLookUp' id='patientLookUp' value='?' onClick='callPatientSearch();' <%=enable_disable_flag%>>

		 	<!-- Checking Discharge Advice - Rajesh V 10/11/2012  -->	
		 <img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<td class="label" width='25%'  readonly>
		<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/> </td>
	<td class="fields" width='25%'>
		<input type='text' class="fields" name='patient_name' id='patient_name' size='30'   value='<%=shortName%>' disabled>
	</td>

</tr>


<tr>
<td class="label" width='25%' >
		<fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>  </td>
	<td class="fields" width='25%' >
		<input type='text' class="fields" name='encounter_id' id='encounter_id' size='12' value='<%=encounterId%>' disabled>
		<!-- Checking Discharge Advice - Rajesh V 10/11/2012  -->
		<!-- Commented the below function calls after fixing the issue-->
		<!-- <input type='button' class='button' name='encounterLookUp' id='encounterLookUp' value='?' onClick='callEncounterSearch();callDischargeChk();' > -->
		<input type='button' class='button' name='encounterLookUp' id='encounterLookUp' value='?' onClick='callEncounterSearch();' >
		<!-- Checking Discharge Advice - Rajesh V 10/11/2012  -->
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<td class="label" width='25%' >
		<fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
	<td class="fields" width='25%' >
		<select name='sex' id='sex' DB_VALUE='<%=sex%>' disabled>
		<option value=''><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
		<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
		<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
		<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
		</select>
	</td>
</tr>

<tr>
	<td class="label" width='25%' >
		<fmt:message key="Common.DateofBirth.label" bundle="${common_labels}"/></td>
	<td ><input type='text' class="fields" name='date_of_birth' id='date_of_birth' size='15' value='<%=dateOfBirth%>' disabled>
	</td>
	<td class='label' width='25%' ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>  </td>
	<td class="fields" width='25%' >
	<!-- ML-MMOH-CRF-0752.3-US001 -->
		<input type='text' class="fields" name='nursing_unit' id='nursing_unit' size='36' value='<%=wardDesc%>' disabled>
	</td>
</tr>

<tr>
	<td class="label" width='25%' >
		<fmt:message key="eOT.AdmittingSpeciality.Label" bundle="${ot_labels}"/>   </td> 
	<td class="fields" width='25%' >
		<input type='text' class="fields" name='admitting_specialty' id='admitting_specialty' size='15'   disabled 		value='<%=admitting_speciality_desc%>' >
	</td>
	<td class="label" width='25%' > <fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/> </td> 
	<td  width='25%'>
		<input type='hidden' name='surgeon_code' id='surgeon_code' value='<%=surgeon_code%>'>
		<input type='text' class="fields" name='SURGEON_DESC' id='SURGEON_DESC' size='15'   value='<%=surgeon_desc%>' onBlur="if(this.value!='')searchsurgeon(surgeon_code,SURGEON_DESC);" >
		<input type='button' class='button' name='surgeon_lookup' id='surgeon_lookup' value='?' onClick='searchsurgeon(surgeon_code,SURGEON_DESC)' <%=enable_disable_flag%>>
		<img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
</tr>



<tr>
<td class="label" width='25%' > <fmt:message key="eOT.OperatingSpeciality.Label" bundle="${ot_labels}"/> </td>
	<td width='25%' >
		<input type='hidden' name='speciality_code' id='speciality_code' value="<%=operating_speciality_code%>">
		<!-- Modified by Sanjay for Anaesthesia Required Checkbox CRF against IN032063 STARTS here -->
		<input type='text' class="fields" name='SPECIALITY_DESC' id='SPECIALITY_DESC' size='15' value='<%=operating_speciality_desc%>' onBlur="if(this.value!='')searchSpecialty(speciality_code,SPECIALITY_DESC); else speciality_code.value=''; clearSpeciality_Code(this); anesthesiaRequiredYN();" <%=enable_disable_flag%>>
		<input type='button' class='Button' name='operating_speciality_lookup' id='operating_speciality_lookup' value='?' onClick='searchSpecialty(speciality_code,SPECIALITY_DESC); anesthesiaRequiredYN(SPECIALITY_DESC);' <%=enable_disable_flag%>>
		<!-- Modified by Sanjay for Anaesthesia Required Checkbox CRF against IN032063 ENDS here --> 
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>

<% if(called_from.equals("OT_MENU") || called_from.equals("BOOKING") )  { %>

	<td class="label" width='25%' ><fmt:message key="Common.Theatre.label" bundle="${common_labels}"/> </td>
	<td width='25%' >
		<input type='hidden' name='oper_room_code' id='oper_room_code' >
		<input type='text' class="fields" name='theatre_desc' id='theatre_desc' size='15' onBlur="if(this.value!='')searchTheatre(oper_room_code,theatre_desc,'<%=multi_check_in_yn %>');" > <!--Added For PMG2016-KDAH-CRF-0001-->
		<input type='button' class='button' name='TheatreLookUp' id='TheatreLookUp' size='15' value="?" OnClick="searchTheatre(oper_room_code,theatre_desc,'<%=multi_check_in_yn %>');"> <img src='../../eCommon/images/mandatory.gif'></img><!--Added For PMG2016-KDAH-CRF-0001-->
	</td>

<% } else if(called_from.equals("OT_SLATE")) {%>

	<td class="label" width='25%' ><fmt:message key="Common.Theatre.label" bundle="${common_labels}"/> </td>
	<td class="fields" width='25%' >
		<input type='hidden' name='oper_room_code' id='oper_room_code' value="<%=oper_room_code%>" >
		<input type='text' class="fields" name='theatre_desc' id='theatre_desc' size='15'  value='<%=theatre_desc%>'
		disabled> 
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
<% } %>
</tr>

<tr>
	<!-- Modified by Sanjay for Anaesthesia Required Checkbox CRF against IN032063 STARTS here -->
	<td class='label' width='25%'><fmt:message key="eOT.AnaesthesiaReviewRequired.Label" bundle="${ot_labels}" />
	</td>
<!-- Sanjay comment
	<td class='fields' width='25%'><input type='checkbox'
		name='anaes_review' id='anaes_review' value='' onclick= "checkAnesReq(this);" disabled ></td>
-->
<td class='fields' width='25%'><input type='checkbox'
		name='anaes_review' id='anaes_review' value='' disabled ></td>


	<!-- Modified by Sanjay for Anaesthesia Required Checkbox CRF against IN032063 ENDS here -->
	
	
	<td class="label"  width='20%' > <fmt:message key="eOT.AnaesthesiaType.Label" bundle="${ot_labels}"/> </td>
	<td class="fields" width='25%' >
		<input type='hidden' name='anaesthesia_code' id='anaesthesia_code' value='<%=anaesthesiaCode%>'>
		<input type='text' class="fields" name='ANAESTHESIA_DESC' id='ANAESTHESIA_DESC' size='15'   value='<%=anaesthesiaDesc%>' onBlur="if(this.value!='')searchAnaesthesia(anaesthesia_code,ANAESTHESIA_DESC);clearAnaesthesia_Code(this);" <%=enable_disable_flag%>>
		<input type='button' class='button' name='anesthesia_type_lookup' id='anesthesia_type_lookup' value='?' onClick='searchAnaesthesia(anaesthesia_code,ANAESTHESIA_DESC);' <%=enable_disable_flag%>>
		<!-- Sanjay for showing mandatory symbol when Anesthesia Review Checkbox is Checked against IN032063 -->
		<!--
		<img id="anes_check" src='../../eCommon/images/mandatory.gif' style='visibility:hidden'></img>
		-->
	</td>
</tr>
<tr>
<!-- Commented by Sanjay STARTS here
<% if( called_from.equals("OT_MENU") ){ %>
	<td width='25%' ></td>
	<td width='25%' >
		<a class='gridLink' href="javascript:openNewDialogWindow1(lblPreOperDiag,document.forms[0].diagnosis,'500','');">
			<fmt:message key="eOT.PreOperativeDiagnosis.Label" bundle="${ot_labels}"/> </a>
	</td>
<%}else{%><td width='25%' ></td>
	<td width='25%' > 
Commented by Sanjay ENDS here	-->
		<!--  <a class='gridLink'  href="javascript:openDialogWindow(lblPreOperDiag,document.forms[0].diagnosis);"> -->
<!-- Commented by Sanjay STARTS here
		 <a class='gridLink'  href="javascript:openDialogWindow(lblPreOperDiag,document.forms[0].diagnosis,'500');">
			 <fmt:message key="eOT`OperativeDiagnosis.Label" bundle="${ot_labels}"/></a></td>
	 </td>
<% } %>
Commented by Sanjay ENDS here-->

<!--Block Added by Sanjay STARTS here -->
<table>	 
	 <!--Added by lakshmi against date field requirement in check in page starts here-->
	 <%if((Function_Name.equals("Check-In")) && (called_from.equals("OT_MENU") )){ %>
	 <tr>
	<td class='label' width='25%'><fmt:message key="eOT.CheckedInDateTime.Label" bundle="${ot_labels}"/>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
	<!-- Added by Rajesh V 06/11/2012 -->
	<%if(("").equals(checkin_backdate_limit)||("0").equals(checkin_backdate_limit)){%>
	<td class="fields" width='25%' >
		<input type='text' class="fields" name='checked_in_date_time' id='checked_in_date_time' size='15'  value='<%=check_in_time%>'>
		<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('checked_in_date_time');">
	</td>
	<%}else{%>
	<!-- Added by Rajesh V 06/11/2012 -->
	<td class='fields' width='25%'>
		 <input type='text' class='fields' name='checked_in_date_time' id='checked_in_date_time' maxlength='16' size='15'  value='<%=check_in_time%>'>
		 <img class='fields' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('checked_in_date_time','DD/MM/YYYY HH24:MI');" > 
		 </td>
	<%}%>
	<!-- <td width='25%' ></td> -->
<!-- Commented by Sanjay for Anaesthesia Required Checkbox CRF against IN032063 -->
	<td class="label" width='25%' > <fmt:message key="Common.Anaesthetist.label" bundle="${common_labels}"/> </td>
	 <td  width='25%'> <input type='hidden' name='anesthetist_code' id='anesthetist_code' value='<%=anesthetistCode%>'>
		<input type='text' class="fields" name='ANESTHETIST_DESC' id='ANESTHETIST_DESC' size='12' 	value='<%=anesthetistDesc%>' onBlur="if(this.value!='')searchAnesthetist(anesthetist_code,ANESTHETIST_DESC);">
		<input type='button' class='button' name='anesthetist_lookup' id='anesthetist_lookup' value='?' onClick='searchAnesthetist(anesthetist_code,ANESTHETIST_DESC)' <%=enable_disable_flag%>>
	</td>
	<tr>
	<td width='25%' ></td>
	<td width='25%'>		
		<a class='gridLink' href="javascript:openNewDialogWindow1(lblPreOperDiag,document.forms[0].diagnosis,'500','');"><fmt:message key="eOT.PreOperativeDiagnosis.Label" bundle="${ot_labels}"/> </a>		
	</td>
	<!-- Added for IN:049189 -->
	<td width='25%'>
		<div id='showPreOperDiagDiv' style='display:none'>
			<a class='gridLink' href="javascript:callPreOPDiagnosis_1();">
				<fmt:message key="eOT.PreOperativeDiagnosisNew.Label" bundle="${ot_labels}"/></a>
		</div>	
	</td>
	</tr>
	<!-- Added by MuthuN against CRF - 011 on 2/7/2013  -->
	<!-- Commented for IN:049189 -->
	<!--tr>
	<td width='25%' ></td>
	<td width='25%'>
		<div id='showPreOperDiagDiv' style='display:none'>
			<a class='gridLink' href="javascript:callPreOPDiagnosis_1();">
				<fmt:message key="eOT.PreOperativeDiagnosisNew.Label" bundle="${ot_labels}"/></a>
		</div>	
	</td>
	</tr -->
	<!-- Added by MuthuN against CRF - 011  on 2/7/2013 -->	
	
	<%}else{%><td width='25%' ></td>	
	<td width='25%' > 
		<!--  <a class='gridLink'  href="javascript:openDialogWindow(lblPreOperDiag,document.forms[0].diagnosis);"> -->
		 <a class='gridLink'  href="javascript:openDialogWindow(lblPreOperDiag,document.forms[0].diagnosis,'500');">
			 <fmt:message key="eOT`OperativeDiagnosis.Label" bundle="${ot_labels}"/></a></td>
	 </td>
<% } %>	
</tr>
</table>
<!--Block Added by Sanjay ENDS here -->


	<%if(called_from.equalsIgnoreCase("OT_MENU")){%>
			<td width='25%' ></td>
			<td width='25%' >
	 <!-- <a class='gridLink' href="javascript:funsubmitCheckInDtls('<%=verify_checklist_codes%>')"> 
	 <fmt:message key="eOT.VerifyCheckList.Label" bundle="${ot_labels}"/></a> -->
			</td>
	<%}else{%>
			<td class="label" width='25%' > <fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/> </td> 
			<td  width='25%'>
				<input type='hidden' name='surgeon_code' id='surgeon_code' value='<%=surgeon_code%>'>
				<input type='text' class="fields" name='SURGEON_DESC' id='SURGEON_DESC' size='15'   value='<%=surgeon_desc%>' onBlur="if(this.value!='')searchsurgeon(surgeon_code,SURGEON_DESC);" >
		<input type='button' class='button' name='surgeon_lookup' id='surgeon_lookup' value='?' onClick='searchsurgeon(surgeon_code,SURGEON_DESC)' <%=enable_disable_flag%>>
	 </td>
			<td width='25%' >
 <a class='gridLink' href="javascript:funsubmitCheckInDtls('<%=verify_checklist_codes%>')">
			 <fmt:message key="eOT.VerifyCheckList.Label" bundle="${ot_labels}"/></a>
			</td>
	<%
		}
	%>
</tr>
<%
	}
	else
	{
	// The below code is changed for Patient Line changes. The Patient Line fields should be hidden
	// and the respective columns/legends/rows are to be deleted.
%>
<script language='javascript'>
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>


        
	<input type='hidden'  name='surgery_date' id='surgery_date' size='8'  value='<%=surgeryDate%>'  disabled>
	<input type='hidden'  name='booking_no' id='booking_no' size='15'  value='<%=bookingNo%>' disabled>
	<input type='hidden'  name='order_id' id='order_id' size='15' disabled 	value='<%=order_id%>' >
	<input type='hidden' name="patient_class" id="patient_class" value="<%=patient_class%>">
	<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>' <%=enable_disable_flag%> readonly>
	<input type='hidden'  name='patient_name' id='patient_name' size='30'   value='<%=shortName%>' disabled>
	<input type='hidden'  name='encounter_id' id='encounter_id' size='12' value='<%=encounterId%>' disabled>
	<input type='hidden'  name='date_of_birth' id='date_of_birth' size='15' value='<%=dateOfBirth%>' disabled>
	<input type='hidden'  name='nursing_unit' id='nursing_unit' size='15' value='<%=wardDesc%>' disabled>
	<input type='hidden'  name='ASST_SURGEON_CODE' id='ASST_SURGEON_CODE' size='15'   value='<%=asst_surgeon_code%>' >
	<input type='hidden' name='sex' id='sex' value='<%=sex%>'>

<tr>
	<td  class="label" width='25%' >
		<fmt:message key="Common.waitlistno.label" bundle="${common_labels}"/> </td>
	<td class="fields" width='25%' >
		<input type='text' class="fields" name='waitlist_no' id='waitlist_no' size='14'  readonly value='<%=waitListNo%>' >
	</td>
	<td class="label" width='25%' >
		<fmt:message key="Common.SurgeryType.label" bundle="${common_labels}"/></td>
	<td  width='25%' class="fields" >
		<select name='surgery_type' id='surgery_type' onChange='funAssingnValues(this)' <%=enable_disable_flag%>>
			<option value='' ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
			<%
					HashMap surgeryDtls = chk_bean.getSurgeryTypeDtls();
					HashMap tempmap = new HashMap();
					int size = surgeryDtls.size();
					String surgery_type_sel = "";
					String surgery_type_val = "";
					String nature_type_temp = "";
					String nature_code_temp = "";
					for(int i=1;i<=size;i++)
					{
						tempmap =(HashMap) surgeryDtls.get(""+i);
						surgery_type_desc=""+tempmap.get("short_desc");
						nature_code_temp=""+tempmap.get("nature_code");
						nature_type_temp=""+tempmap.get("nature_type");
						surgery_type_val = nature_code_temp+"::"+nature_type_temp;
						if(surgery_type.equals(surgery_type_val))
							surgery_type_sel = "selected";
						else
							surgery_type_sel = "";
		%>
		<option value='<%=surgery_type_val%>' <%=surgery_type_sel%>><%=surgery_type_desc%> </option>
		<% } %>
		</select><img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<tr>
	<td class="label" width='25%' >
		<fmt:message key="eOT.AdmittingSpeciality.Label" bundle="${ot_labels}"/>   </td> 
	<td class="fields" width='25%' >
		<input type='text' class="fields" name='admitting_specialty' id='admitting_specialty' size='15'   disabled 		value='<%=admitting_speciality_desc%>' >
	</td>
	<td class="label" width='25%' > <fmt:message key="Common.Anaesthetist.label" bundle="${common_labels}"/> </td>
	 <td  width='25%'> <input type='hidden' name='anesthetist_code' id='anesthetist_code' value='<%=anesthetistCode%>' >
		<input type='text' class="fields" name='ANESTHETIST_DESC' id='ANESTHETIST_DESC' size='12' 	value='<%=anesthetistDesc%>' <%=enable_disable_flag%>>
		<input type='button' class='button' name='anesthetist_lookup' id='anesthetist_lookup' value='?' onClick='searchAnesthetist(anesthetist_code,ANESTHETIST_DESC)' <%=enable_disable_flag%>>
	</td>
</tr>
<tr>
	<td class="label"  width='20%' > <fmt:message key="eOT.AnaesthesiaType.Label" bundle="${ot_labels}"/> </td>
	<td class="fields" width='25%' >
		<input type='hidden' name='anaesthesia_code' id='anaesthesia_code' value='<%=anaesthesiaCode%>'>
		<input type='text' class="fields" name='ANAESTHESIA_DESC' id='ANAESTHESIA_DESC' size='15'   value='<%=anaesthesiaDesc%>' <%=enable_disable_flag%> >
		<input type='button' class='button' name='anesthesia_type_lookup' id='anesthesia_type_lookup' value='?' onClick='searchAnaesthesia(anaesthesia_code,ANAESTHESIA_DESC);' <%=enable_disable_flag%>>
	</td>
	<td class="label" width='25%' > <fmt:message key="eOT.OperatingSpeciality.Label" bundle="${ot_labels}"/> </td>
	<td width='25%' >
		<input type='hidden' name='speciality_code' id='speciality_code' value="<%=operating_speciality_code%>">
		<input type='text' class="fields" name='SPECIALITY_DESC' id='SPECIALITY_DESC' size='15' value='<%=operating_speciality_desc%>' <%=enable_disable_flag%>>
		<input type='button' class='Button' name='operating_speciality_lookup' id='operating_speciality_lookup' value='?' onClick='searchSpecialty(speciality_code,SPECIALITY_DESC)' <%=enable_disable_flag%>> 
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>

<tr>
<%	
	if(called_from.equals("OT_MENU") || called_from.equals("BOOKING") )  
	{
%>

	<td class="label" width='25%' ><fmt:message key="Common.Theatre.label" bundle="${common_labels}"/> </td>
	<td width='25%' class="fields">
		<input type='hidden' name='oper_room_code' id='oper_room_code' >
		<input type='text' class="fields" name='theatre_desc' id='theatre_desc' size='15'  onBlur="if(this.value!='')searchTheatre(oper_room_code,theatre_desc,'<%=multi_check_in_yn %>');"> <!--Added For PMG2016-KDAH-CRF-0001-->
		<input type='button' class='button' name='TheatreLookUp' id='TheatreLookUp' size='15' value="?" OnClick="searchTheatre(oper_room_code,theatre_desc,'<%=multi_check_in_yn %>');"> <img src='../../eCommon/images/mandatory.gif'></img><!--Added For PMG2016-KDAH-CRF-0001-->
	</td>
	<%
		if(called_from.equals("BOOKING") )
		{
		    surgeon_code=surgeon_code==null?"":surgeon_code;
		    surgeon_code=surgeon_code.equals("null")?"":surgeon_code;
		    surgeon_code=surgeon_code.equals("*ALL")?"":surgeon_code;
			String enable_surg = (!"".equals(surgeon_code))?"disabled":"";
	%>
		<td class="label" width='25%' > <fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/> </td> 
		<td  width='25%'>
			<input type='hidden' name='surgeon_code' id='surgeon_code' value='<%=surgeon_code%>'>
			<input type='text' class="fields" name='SURGEON_DESC' id='SURGEON_DESC' size='15'   value='<%=surgeon_desc%>' onBlur="if(this.value!='')searchsurgeon(surgeon_code,SURGEON_DESC);"  <%=enable_surg%> >
			<input type='button' class='button' name='surgeon_lookup' id='surgeon_lookup' value='?' onClick='searchsurgeon(surgeon_code,SURGEON_DESC)' <%=enable_surg%> ><img src='../../eCommon/images/mandatory.gif'></img>
		 </td>
<% 
		}
	}
	else if(called_from.equals("OT_SLATE")) 
	{
%>

	<td class="label" width='25%' ><fmt:message key="Common.Theatre.label" bundle="${common_labels}"/> </td>
	<td width='25%' class="fields">
		<input type='hidden' name='oper_room_code' id='oper_room_code' value="<%=oper_room_code%>" >
		<input type='text' class="fields" name='theatre_desc' id='theatre_desc' size='15'  value='<%=theatre_desc%>'
		disabled> 
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
<%
		    surgeon_code=surgeon_code==null?"":surgeon_code;
		    surgeon_code=surgeon_code.equals("null")?"":surgeon_code;
		    surgeon_code=surgeon_code.equals("*ALL")?"":surgeon_code;
			String enable_surg = (!"".equals(surgeon_code))?"disabled":"";
%>
	<td class="label" width='25%' > <fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/> </td> 
	<td  width='25%'>
		<input type='hidden' name='surgeon_code' id='surgeon_code' value='<%=surgeon_code%>'>
		<input type='text' class="fields" name='SURGEON_DESC' id='SURGEON_DESC' size='15'   value='<%=surgeon_desc%>' onBlur="if(this.value!='')searchsurgeon(surgeon_code,SURGEON_DESC);"  <%=enable_surg%> >
		<input type='button' class='button' name='surgeon_lookup' id='surgeon_lookup' value='?' onClick='searchsurgeon(surgeon_code,SURGEON_DESC)' <%=enable_surg%> ><img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
<% } %>
	 
</tr>
<%
		if(called_from.equals("BOOKING") )
		{
%>
	
<tr>
	 <td class='label' width='25%' >
	 		<fmt:message key="eOT.AsstSurgeon.Label" bundle="${ot_labels}"/> &nbsp1
	 </td>
	<td class="fields" width="25%">
			<input type='hidden' name='asst_surgeon_code1' id='asst_surgeon_code1' value="" > 
			<input type='text' name='asst_surgeon_name1' id='asst_surgeon_name1' size='20' value= "<%=asst_surgeon_desc%>" onblur="if(this.value!='') searchAsstSurgeon(asst_surgeon_name1,asst_surgeon_code1); else asst_surgeon_code1.value='' ">
			<input type='button' class='button' value='?' name='btnAsstSurg1' id='btnAsstSurg1' onClick="searchAsstSurgeon(asst_surgeon_name1,asst_surgeon_code1);">
	</td>
  <td class='label' width='25%' >
	 		<fmt:message key="eOT.AsstSurgeon.Label" bundle="${ot_labels}"/> &nbsp2
	 </td>
	 <td class="fields" width="25%" colspan="3">
			<input type='hidden' name='asst_surgeon_code2' id='asst_surgeon_code2' maxlength='15' size='15'  value= "<%=asst_surgeon_code_2%>" >
			<input type='text' name='asst_surgeon_name2' id='asst_surgeon_name2' size='20' value= "<%=asst_surgeon_desc_2%>" onblur="if(this.value!='') searchAsstSurgeon(asst_surgeon_name2,asst_surgeon_code2); else asst_surgeon_code2.value='' ">
			<input type='button' class='button' value='?' name='btnAsstSurg2' id='btnAsstSurg2' onClick="searchAsstSurgeon(asst_surgeon_name2,asst_surgeon_code2);">
	</td>
	
</tr> 
<!--Added by Sanjay STARTS here against date field requirement in check in page-->

 <tr>
<!--	IN050700
	<td class='label' width='25%'><fmt:message key="eOT.CheckedInDateTime.Label" bundle="${ot_labels}"/>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
	
	
	<td class='fields' width='25%'>
		 <input type='text' class='fields' name='checked_in_date_time' id='checked_in_date_time' maxlength='16' size='15'  value='<%=check_in_time%>'>
		 <img class='fields' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('checked_in_date_time','DD/MM/YYYY HH24:MI');" > 
		 </td>

		  Modified by Sanjay for Anaesthesia Required Checkbox CRF against IN032063 STARTS here -->
		<%
if (strAnesReqYNPending > 0) {
		%>
		<td   class='label' width='25%'>
<fmt:message key="eOT.AnaesthesiaReviewRequired.Label" bundle="${ot_labels}"/>
		</td>
		<td class='fields' width='25%'>

<input type='checkbox' name='anaes_review' id='anaes_review' value='' disabled checked>


		</td>
		<%
} else {
		%>
		<td   class='label' width='25%'>
<fmt:message key="eOT.AnaesthesiaReviewRequired.Label" bundle="${ot_labels}"/>
		</td>
		<td class='fields' width='25%'>

<input type='checkbox' name='anaes_review' id='anaes_review' value='' disabled>


		</td>
		<%
}
		%>
		<!-- Modified by Sanjay for Anaesthesia Required Checkbox CRF against IN032063 ENDS here -->
		 
		 
 </tr>
<!--Added by Sanjay ENDS here against date field requirement in check in page-->

<%} else if(called_from.equals("OT_SLATE")){%>
	<tr>
	 <td class='label' width='25%' >
	 		<fmt:message key="eOT.AsstSurgeon.Label" bundle="${ot_labels}"/> &nbsp1
	 </td>
		<td class="fields" width='25%' > 
		<input type='hidden'  name='asst_surgeon_code1' id='asst_surgeon_code1' size='15'   value='<%=asst_surgeon_code%>' >
		<input type='text' class="fields" name='asst_surgeon_desc' id='asst_surgeon_desc' size='15' value='<%=asst_surgeon_desc%>' disabled>
	</td>	
  <td class='label' width='25%' >
	 		<fmt:message key="eOT.AsstSurgeon.Label" bundle="${ot_labels}"/> &nbsp2
	 </td>
	 <td class="fields" width="25%" colspan="3">
			<input type='hidden' name='asst_surgeon_code2' id='asst_surgeon_code2' maxlength='15' size='15'  value= "<%=asst_surgeon_code_2 %>" >
				<input type='text' class="fields" name='asst_surgeon_desc_2' id='asst_surgeon_desc_2' size='15' value='<%=asst_surgeon_desc_2%>' disabled>
	</td>
	
</tr>
<%}%>
<!-- <tr> Sanjay-->
<!-- <table> Sanjay-->
	 <!--Added by lakshmi against date field requirement in check in page starts here--> 
	 <%if(Function_Name.equals("Check-In") || (called_from.equals("BOOKING") ))  //IN050700
		{
%>
	  <tr> 
	
	<td class='label' width='25%'><fmt:message key="eOT.CheckedInDateTime.Label" bundle="${ot_labels}"/>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
	<td class='fields' width='25%'>
		 <input type='text' class='fields' name='checked_in_date_time' id='checked_in_date_time' maxlength='16' size='15'  value='<%=check_in_time%>'>
		 <img class='fields' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('checked_in_date_time','DD/MM/YYYY HH24:MI');" > 
		 </td>		
		
	<%}%>	
	 <!--Added by lakshmi against date field requirement in check in page ends here-->
	 <td width='25%' > </td>
	 <td width='25%' >
		 <!-- <a class='gridLink' href="javascript:openDialogWindow(lblPreOperDiag,document.forms[0].diagnosis);"> -->

		 <a class='gridLink' href="javascript:openDialogWindow1(lblPreOperDiag,document.forms[0].diagnosis,'500');">		 <fmt:message key="eOT.PreOperativeDiagnosis.Label" bundle="${ot_labels}"/></a> &nbsp;&nbsp;&nbsp; 
		 <a class='gridLink' href="javascript:funsubmitCheckInDtls('<%=verify_checklist_codes%>')"><fmt:message key="eOT.VerifyCheckList.Label" bundle="${ot_labels}"/></a>

	</td>
	 
	
	<!-- </tr> Sanjay-->
 </tr> 
<!-- </table> Sanjay-->
<%
	} // end of else block for Patient Line fields
%>
<tr>
	<td width='25%' class='CAGROUPHEADING' colspan="4"> 
		<B><fmt:message key="eOT.OperationsProcedures.Label" bundle="${ot_labels}"/>	</B> 
	</td>
</tr>

</table>
<%}catch(Exception e)
{
	e.printStackTrace();
	System.err.println("Exception in PreOperChkListHdr.jsp:" +e); 
}finally
{
	if(con!=null)  ConnectionManager.returnConnection(con, request);
}%>
	<input type='hidden' name="diagnosis" id="diagnosis" value="<%=diagnosis%>">
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type='hidden' name='bean_id' id='bean_id' value="<%=bean_id%>" >
	<input type='hidden' name='bean_name' id='bean_name' value="<%=bean_name%>" >
	<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>" >
	<input type='hidden' name='nature_code' id='nature_code' value="<%=nature_code%>">
	<input type='hidden' name='nature_type' id='nature_type' value="<%=nature_type%>">
	<input type='hidden' name='visit_id' id='visit_id' value="<%=visit_id%>" >
	<input type='hidden' name='episode_id' id='episode_id' value="<%=episode_id%>">
	<input type='hidden' name='episode_type' id='episode_type' value="<%=episodeType%>" >
	<input type='hidden' name='order_type_code' id='order_type_code' value="<%=order_type_code%>" >
	<input type='hidden' name='operation_status' id='operation_status' value="<%=operationStatus%>">
	<input type='hidden' name="admitting_speciality_code" id="admitting_speciality_code" value="<%=admitting_speciality_code%>">
	<input type='hidden' name="operating_speciality_code" id="operating_speciality_code" value="<%=operating_speciality_code%>">
	<input type='hidden' name="called_from" id="called_from" value="<%=called_from%>">
	<input type='hidden' name="slate_user_id" id="slate_user_id" value="<%=request.getParameter("slate_user_id")%>">
	<input type='hidden' name="no_of_verifications" id="no_of_verifications" value="<%=no_of_verifications%>">
	<input type='hidden' name="role_id_1" id="role_id_1" value="<%=role_id_1%>">
	<input type='hidden' name="role_id_2" id="role_id_2" value="<%=role_id_2%>">
	<input type='hidden' name="role_id_3" id="role_id_3" value="<%=role_id_3%>">
	<input type='hidden' name="role_id_4" id="role_id_4" value="<%=role_id_4%>">
	<input type='hidden' name="old_checklist_user_id" id="old_checklist_user_id" value="<%=old_checklist_user_id%>">
	<input type='hidden' name="checklist_completed_yn" id="checklist_completed_yn" value="<%=checklist_completed_yn%>">
	<input type='hidden' name="tab_name" id="tab_name" value="<%=tab_name%>">

<input type='hidden' name="source_code" id="source_code" value='<%=source_code%>'>
<input type='hidden' name="source_type" id="source_type" value='<%=source_type%>' >
<input type='hidden' name="login_user_id" id="login_user_id" value='<%=login_user_id%>' >
<input type='hidden' name="check_for_check_list_compl" id="check_for_check_list_compl" value='<%=check_for_check_list_compl%>' >
<input type='hidden' name="check_in_time" id="check_in_time" value='<%=check_in_time%>'>
<input type='hidden' name="all_speciality_code" id="all_speciality_code" value='' >
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='params' id='params' value="<%=request.getQueryString()%>">
<!--Added by lakshmi against date field requirement in check in page-->
<input type='hidden' name='booking_date' id='booking_date' value="<%=bookingDate%>">
<input type='hidden' name='order_DateTime' id='order_DateTime' value="<%=orderDateTime%>">
<!-- Modified by Sanjay for Anaesthesia Required Checkbox CRF against IN032063 -->
<input type="hidden" name="anaes_review1" id="anaes_review1" value="<%=anaes_review1%>">
<input type='hidden' name='url_desc' id='url_desc' value="<%=url_desc%>">
<!-- Added by Rajesh V 06/11/2012 -->
<input type='hidden' name='checkin_backdate_limit' id='checkin_backdate_limit' value="<%=checkin_backdate_limit%>">
<!-- Added by Rajesh V 06/11/2012 -->
<!-- Added by MuthuN against 37688 on 2/7/2013 -->
<input type='hidden' name="check_in_time1" id="check_in_time1" value='<%=check_in_time%>'>
<input type='hidden' name="current_date_format" id="current_date_format" value='<%=current_date_format%>'>
<!-- Added by MuthuN against 37688 on 2/7/2013 -->
<input type="hidden" name="multi_check_in_yn" id="multi_check_in_yn" id="multi_check_in_yn" value="<%=multi_check_in_yn%>"><!--PMG2016-KDAH-CRF-0001-->
</form>
</body>
</html>

