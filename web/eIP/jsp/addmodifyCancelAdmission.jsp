<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,blipin.*,com.ehis.util.*, eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<HTML>
<HEAD>
<TITLE> <fmt:message key="Common.CancelAdmission.label" bundle="${common_labels}"/> </TITLE>
    <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <script src="../../eCommon/js/dchk.js" language="JavaScript"></Script>
    <script src="../js/CancelAdmission.js" language="JavaScript"></Script>
    <script src='../../eCommon/js/common.js' language='javascript'></script>
    <script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<font id='Processing'><td class='columnheader'><h4><fmt:message key="Common.processing.label" bundle="${common_labels}"/><h4></td></font>
<%  
    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String locale		= (String)session.getAttribute("LOCALE");
	Connection con		= null;
    Statement stmt		= null;
    PreparedStatement pstmt = null;
    ResultSet rs		= null;
    String facilityID	= (String)session.getValue("facility_id");
    String encounterID	= request.getParameter("encounter_id");
	String episode_id	= encounterID;
    String patientId	= request.getParameter("patientId");
    String pat_check_yn	= "";
    String install_yn	= "N";
	// ========= Query string changed by ranjani to retreive back the billing details ==========
    String admissiondatetime	= "";
    String admissiontypedesc	= "";
    String specialtyshortdesc	= "";
    String practitionername		= "";
    String patienttype			= "";
    String nursingunitshortdesc = "";
    String serviceshortdesc		= "";
    String bedno				= "";
    String roomno				= "";
    String bedclassshortdesc	= "";
    String bedtypeshortdesc		= "";
    String gender				= "";
    String nursingunitcode		= "";
    String cancel_disable		= "";
    String practitionerid		= "";
    String meddesc				= "";
	String bill_error			= ""; 
	String charged_service		= "";
	String unprocessed_service	= "";
	String adm_deposit			= "";
	String blocked_bed_no		= "";
	String adt_status			= "";
	String patient_class		= "";
	String admissiondatetime_converted = "";
	StringBuffer sqlQuery		= new StringBuffer();
	String sub_pkg_chk="0";
	String bl_package_enabled_yn="N";
	
    try
    {
	    con		= ConnectionManager.getConnection(request);	

		String allowCancelAdm = checkForNull(request.getParameter("allowCancelAdmsn"),"N");//Added by Thamizh selvi on 20th Feb 2017 against MMS-QH-CRF-0182

		install_yn =(String)session.getValue("bl_operational");
		stmt	=	con.createStatement();
		if(rs != null)	rs.close();
		if(install_yn.equals("Y") )
		{
			/****************ADDED FOR PACKAGE BILLING**********************************************/	
		try{	
			PreparedStatement pstmt1=con.prepareStatement("select bl_package_enabled_yn(?) from dual");
			pstmt1.setString(1, facilityID);
			ResultSet rs2 = pstmt1.executeQuery();	
			if( rs2 != null ) 
			{
				if( rs2.next() )
				{			
					bl_package_enabled_yn  =  rs2.getString(1);	
				}
			}
			if(bl_package_enabled_yn == null) bl_package_enabled_yn="N";			
			pstmt1.close();
			if(rs2!=null) rs2.close();	
			if(bl_package_enabled_yn.equals("Y"))
			{
			String pat_pkg_sub_yn= " SELECT COUNT(*) FROM BL_PACKAGE_ENCOUNTER_DTLS WHERE ENCOUNTER_ID =? AND patient_id = ? AND PACKAGE_SEQ_NO IN (SELECT PACKAGE_SEQ_NO FROM BL_PACKAGE_SUB_HDR  WHERE patient_id = ? AND status = 'O')";
			if(rs!=null) rs.close();
/* 			if(stmt!=null) stmt.close();
			stmt	= con.createStatement(); */
			pstmt = con.prepareStatement(pat_pkg_sub_yn);
			pstmt.setString(1, episode_id);
			pstmt.setString(2, patientId);
			pstmt.setString(3, patientId);
			rs = pstmt.executeQuery();
			
/* 			rs=stmt.executeQuery(pat_pkg_sub_yn); */
			if(rs.next())
			{
				sub_pkg_chk = rs.getString(1);
			}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			//sub_pkg_chk="0";			
			if(sub_pkg_chk.equals("1"))
			{				
				bill_error = "BL8674";
			}
			}
}catch(Exception e){
				e.printStackTrace();
			}
/**************************ENDS PACKAGE BILLING*********************************************/
			sqlQuery.append("Select BL_IP_DETAILS.BL_CHECK_SERVICE_EXISTS(?, ");
			sqlQuery.append("?, 'I',?) p_service_charged_yn  from dual");
			
			pstmt	= 	con.prepareStatement(sqlQuery.toString());
			pstmt.setString(1, facilityID);
			pstmt.setString(2, patientId);
			pstmt.setString(3, encounterID);
			rs 		= 	pstmt.executeQuery();
			
/* 			stmt	=	con.createStatement();
			rs = stmt.executeQuery(sqlQuery.toString()); */
		
			if(rs.next())
			{
				 charged_service = checkForNull(rs.getString("p_service_charged_yn"));
			}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
				
			if(charged_service.equals("Y"))
			{
				bill_error = "BL9316";
			}
			else
			{
				if(sqlQuery.length() > 0) sqlQuery.delete(0,sqlQuery.length());
				sqlQuery.append("Select  BL_IP_DETAILS.BL_CHECK_UNPROCESSED_EXISTS (?, ?,'I',"+encounterID+")  P_UNPROCESSED_SERVICE_YN  from dual");
				pstmt = con.prepareStatement(sqlQuery.toString());
				pstmt.setString(1, facilityID);
				pstmt.setString(2, patientId);
				/* stmt	=	con.createStatement();
				rs = stmt.executeQuery(sqlQuery.toString()); */
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					unprocessed_service = checkForNull(rs.getString("P_UNPROCESSED_SERVICE_YN"));
				}
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(unprocessed_service.equals("Y"))
				{
					bill_error = "BL9317";
				}
				else
				{
					if(sqlQuery.length() > 0) sqlQuery.delete(0,sqlQuery.length());
					sqlQuery.append("Select  bl_ip_details.BL_CHECK_ADM_DEPOSIT_EXISTS(?, "+encounterID+")   P_ADM_DEPOSIT_YN  from dual");
					pstmt	= 	con.prepareStatement(sqlQuery.toString());
					pstmt.setString(1, facilityID);
					rs		= 	pstmt.executeQuery();
/* 					stmt	=	con.createStatement();
					rs = stmt.executeQuery(sqlQuery.toString()); */ 
					if(rs.next())
					{
						adm_deposit = checkForNull(rs.getString("P_ADM_DEPOSIT_YN"));
					}
				   if(rs!=null) rs.close();
					if(pstmt != null) pstmt.close();
					if(adm_deposit.equals("Y"))
					{
						bill_error = "BL9318";
					}
				}
			}
		}
		String cancel_allowed_yn ="";
		String Admmission = ""; 

		if(bill_error.equals(""))
		{
		/*Wednesday, May 26, 2010 , commented for PE Merged in main query*/
		/*
		if(sqlQuery.length() > 0) sqlQuery.delete(0,sqlQuery.length());
		sqlQuery.append("select IP_ADMIN_CANCEL_ALLOWED_YN('"+facilityID+"',"+encounterID+",'"+patientId+"') from dual");
		stmt = con.createStatement();
		rs = stmt.executeQuery(sqlQuery.toString());
		if (rs!=null && rs.next())
			cancel_allowed_yn = rs.getString(1);
		if(rs!=null)rs.close(); 
		if(stmt!=null)stmt.close();
		int len	= cancel_allowed_yn.length();
		if(len	>= 2)
		{
			Admmission		 = cancel_allowed_yn.substring(2,len);
			cancel_allowed_yn= cancel_allowed_yn.substring(0,cancel_allowed_yn.indexOf("|"));
		}*/
//out.println("<script>alert(\""+cancel_allowed_yn+"\");</script>");
	try
	{
		if(sqlQuery.length() > 0) sqlQuery.delete(0,sqlQuery.length());
		sqlQuery.append("SELECT TO_CHAR(a.admission_date_time,  'dd/mm/rrrr HH24:mi')  admission_date_time,  b.sex gender,  a.encounter_id,  a.nursing_unit_code, IP_GET_DESC.IP_ADMISSION_TYPE(a.ADMISSION_TYPE,?,'2') admission_short_desc,  AM_GET_DESC.AM_SPECIALITY(a.specialty_code,?,'2') specialty_short_desc,  a.patient_class, AM_GET_DESC.AM_PRACTITIONER(a.ATTEND_PRACTITIONER_ID,?,'1') practitioner_name, NULL patient_type_short_desc, IP_GET_DESC.IP_NURSING_UNIT(a.FACILITY_ID, a.NURSING_UNIT_CODE,?,'2') nursing_unit_short_desc, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2') service_short_desc, a.BED_NUM bed_no, a.blocked_bed_no, a.adt_status, A.ROOM_NUM room_no, A.ATTEND_PRACTITIONER_ID practitioner_id, IP_GET_DESC.IP_BED_TYPE(a.bed_type_code,?,'2') bed_type_short_desc, IP_GET_DESC.IP_BED_CLASS(a.bed_class_code,?,'2') bed_class_short_desc, a.team_id, am_get_desc.AM_MEDICAL_TEAM(a.FACILITY_ID,a.TEAM_ID,?,2) team_short_desc");
		/*Wednesday, May 26, 2010 , added for PE*/
		sqlQuery.append(",(select pat_check_in_allowed_yn from IP_PARAM where facility_id = a.facility_id) pat_check_in_allowed_yn ");
		sqlQuery.append(",IP_ADMIN_CANCEL_ALLOWED_YN(a.facility_id,a.encounter_id,a.patient_id)cancel_allowed_yn ");
		sqlQuery.append(" FROM IP_OPEN_ENCOUNTER a, MP_PATIENT b where a.facility_id = ? and a.encounter_id= ? and a.patient_id = b.patient_id");
    	/* stmt = con.createStatement();    
		rs=stmt.executeQuery(sqlQuery.toString()); */
		
		pstmt = con.prepareStatement(sqlQuery.toString());
		pstmt.setString(1, locale);
		pstmt.setString(2, locale);
		pstmt.setString(3, locale);
		pstmt.setString(4, locale);
		pstmt.setString(5, locale);
		pstmt.setString(6, locale);
		pstmt.setString(7, locale);
		pstmt.setString(8, locale);
		pstmt.setString(9, facilityID);
		pstmt.setString(10, encounterID);
		
		rs = pstmt.executeQuery();
		
		if(rs!=null && rs.next())
		{
			admissiondatetime   = checkForNull(rs.getString("admission_date_time"));
			if(!(admissiondatetime==null || admissiondatetime.equals("")))
				admissiondatetime_converted = DateUtils.convertDate(admissiondatetime,"DMYHM","en",locale);
			admissiontypedesc   = checkForNull(rs.getString("admission_short_desc"));      
			specialtyshortdesc  = checkForNull(rs.getString("specialty_short_desc"));   
			practitionername    = checkForNull(rs.getString("practitioner_name"));
			patienttype         = checkForNull(rs.getString("patient_type_short_desc"));
			nursingunitshortdesc= checkForNull(rs.getString("nursing_unit_short_desc"));   
			serviceshortdesc    = checkForNull(rs.getString("service_short_desc"));
			roomno				= checkForNull(rs.getString("room_no"));
			bedclassshortdesc   = checkForNull(rs.getString("bed_class_short_desc"));
			bedtypeshortdesc	= checkForNull(rs.getString("bed_type_short_desc"));
			gender				= checkForNull(rs.getString("gender"));   
			adt_status			= checkForNull(rs.getString("adt_status"));
			blocked_bed_no		= checkForNull(rs.getString("blocked_bed_no"));
			bedno				= checkForNull(rs.getString("bed_no"));
			patient_class		= checkForNull(rs.getString("patient_class"));
			encounterID			= checkForNull(rs.getString("encounter_id"));
			nursingunitcode     = checkForNull(rs.getString("nursing_unit_code"));
			practitionerid		= checkForNull(rs.getString("practitioner_id"));
            meddesc             = checkForNull(rs.getString("team_short_desc"));
            pat_check_yn        = checkForNull(rs.getString("pat_check_in_allowed_yn"),"N");
			cancel_allowed_yn	= checkForNull(rs.getString("cancel_allowed_yn"),"N");
			int len				= cancel_allowed_yn.length();
			if(len	>= 2)
			{
				Admmission		 = cancel_allowed_yn.substring(2,len);
				cancel_allowed_yn= cancel_allowed_yn.substring(0,cancel_allowed_yn.indexOf("|"));
			}
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
        if(sqlQuery.length() > 0) sqlQuery.delete(0,sqlQuery.length());
		}catch(Exception ex) {
			//out.println("error in cancel admission in main: "+ex.toString());
			ex.printStackTrace();
		}
			{
			}
		}
		//Wednesday, May 26, 2010 , modified for PE
		/*
		String pat_check_yn_Sql= " select pat_check_in_allowed_yn from IP_PARAM where facility_id = '"+facilityID+"' ";
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		stmt	= con.createStatement();
		rs=stmt.executeQuery(pat_check_yn_Sql);
		if(rs.next())
		{
			pat_check_yn = rs.getString("pat_check_in_allowed_yn");
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		*/

%> 

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='canceladmission_form' id='canceladmission_form' action='../../servlet/eIP.CancelAdmissionServlet' method='post' target='messageFrame'> 
<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
<tr><td class='columnheader' colspan='4' ><fmt:message key="Common.encounterdetails.label" bundle="${common_labels}"/></td></tr>
<tr><!-- 17956 Thursday, January 07, 2010 -->
	<td class='label' width='25%'><fmt:message key="Common.AdmissionDateTime.label" bundle="${common_labels}"/></td>
	<td class='QUERYDATA'  width='25%'><%=admissiondatetime_converted%><input type='hidden' name='admissiondatetime' id='admissiondatetime' value="<%=admissiondatetime%>"></td> 
	<td class='label' width='25%'><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/></td>
	<td class='QUERYDATA'  width='25%' ><%=admissiontypedesc%><input type='hidden' name='admissiontypedesc' id='admissiontypedesc' value="<%=admissiontypedesc%>"></td>
</tr>
<tr>		  
    <td class='label' ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
      <td class='QUERYDATA'   ><%=encounterID%>
        <input type='hidden' name='encounterID' id='encounterID' value="<%=encounterID%>">
      </td>
	<td class='label'>&nbsp;</td>
	<td class='label'>&nbsp;</td>
 </tr>
  <tr>
      <td class='label' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
      <td class='QUERYDATA'   ><%=specialtyshortdesc%>
        <input type='hidden' name='specialtyshortdesc' id='specialtyshortdesc' >
      </td> 
		<td class='label' width='10%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
      <td class='QUERYDATA'   ><%=practitionername%>
        <input type='hidden' name='practitionername' id='practitionername'>
      </td> 

        
 </tr>
  <tr>
      <td class='label' width='10%'><fmt:message key="Common.patienttype.label" bundle="${common_labels}"/></td>
      <td class='QUERYDATA'   ><%=patienttype%>
        <input type='hidden' name='patienttype' id='patienttype'>
      </td>   
      <td class='label' ><fmt:message key="Common.medicalteam.label" bundle="${common_labels}"/></td>
      <td class='QUERYDATA'   ><%=meddesc%>
        <input type='hidden' name='medicalteam' id='medicalteam'>
      </td>     
  </tr>
 
 <td class='columnheader' colspan='4'  ><fmt:message key="Common.NursingUnitDetails.label" bundle="${common_labels}"/></td>
 <tr>
      <td class='label' ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
      <td class='QUERYDATA'   ><%=nursingunitshortdesc%>
        <input type='hidden' name='nursingunitcode' id='nursingunitcode' value="<%=nursingunitcode%>">
      </td> 
      <td class='label'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
      <td class='QUERYDATA'   ><%=serviceshortdesc%>
        <input type='hidden' name='serviceshortdesc' id='serviceshortdesc'>
      </td> 
</tr>
<tr>
      <td class='label' ><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>


		<%
		if(adt_status.equals("00") && pat_check_yn.equals("Y"))
		{%>
			<td class='QUERYDATA'   ><%=blocked_bed_no%>
			<input type='hidden' name='blocked_bed_no' id='blocked_bed_no' value="<%=blocked_bed_no%>">
	<%	}
		else
		{%>
			<td class='QUERYDATA'   ><%=bedno%>
			<input type='hidden' name='bedno' id='bedno' value="<%=bedno%>">
		<%} %>
	    <td class='label' width='10%'><fmt:message key="Common.roomno.label" bundle="${common_labels}"/></td>
        <td class='QUERYDATA'   ><%=roomno%>
        <input type='hidden' name='roomno' id='roomno' value="<%=roomno%>">
      </td> 

      </td>         
 </tr>
 <tr>
      
      <td class='label'><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></td>
      <td class='QUERYDATA'  ><%=bedclassshortdesc%>
        <input type='hidden' name='bedclassshortdesc' id='bedclassshortdesc'>
      </td> 
	   <td class='label'><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/></td>
      <td class='QUERYDATA'  ><%=bedtypeshortdesc%>
        <input type='hidden' name='bedtypeshortdesc' id='bedtypeshortdesc'>
      </td> 
 </tr>
 
</table>
		
	<tr><td class='label' width='1%' nowrap>
 <table border='0' cellpadding='3' cellspacing='0' width='100%' id='u' align='center' style='visibility:hidden'> 
 <tr>
			<td class='label' width='25%' nowrap><fmt:message key="Common.ReasonforCancellation.label" bundle="${common_labels}"/>
			</td>
			<td nowrap colspan=3 class="fields">
			<select name="reason_for_cancellation" id="reason_for_cancellation">
			<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
			if(sqlQuery.length() > 0) sqlQuery.delete(0,sqlQuery.length());
			//sqlQuery.append("Select Contact_Reason, Contact_Reason_Code from AM_CONTACT_REASON_lang_vw where	language_id='"+locale+"' and Cancel_Admission_Yn = 'Y' and Eff_Status = 'E' order by 1");
			sqlQuery.append("Select am_get_desc.am_contact_reason(contact_reason_code,?,1)Contact_Reason, Contact_Reason_Code from AM_CONTACT_REASON where Cancel_Admission_Yn = 'Y' and Eff_Status = 'E' order by 1");
/* 			stmt	= con.createStatement();
			rs		= stmt.executeQuery(sqlQuery.toString()); */
			
			pstmt = con.prepareStatement(sqlQuery.toString());
			pstmt.setString(1, locale);
			rs = pstmt.executeQuery();
			
			if(rs != null)
			{
				while(rs.next())
				{
					String CDesc = rs.getString("Contact_Reason");
					String CCode = rs.getString("Contact_Reason_Code");
					out.println("<option value=\""+CCode+"\" >"+CDesc+"</option>");
				}			
			}
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
%>
			</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			</td>
	<td class='label' width='25%'>&nbsp;</td>
	<td class='label' width='25%'>&nbsp;</td>

 </tr>  
 </table>
   </td></tr>		  
 <table border='0' cellpadding='3' cellspacing='0' width="100%" > 

 <tr> 
 <!--  /* =========== commented by ranjani to revert back the billing details ============= -->
	<td class='label' width='25%'>&nbsp;</td>
	<td class='label' width='25%'>&nbsp;</td>
	<td class='label' width='25%'>&nbsp;</td>
	<td class="fields" nowrap width='25%'><input type=button class='button' name = 'cancel_admission' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelAdmission.label","common_labels")%>' onClick='CancelAdm(this)' <%=cancel_disable%> ><input type=button class='button' name = 'close' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onClick='CloseWin(this)'></td> 
 </tr> 

 </table>
<input type='hidden' name='gender' id='gender' value="<%=gender%>" >
<input type='hidden' name='bl_install' id='bl_install' value="<%=install_yn%>" >
<input type='hidden' name='episode_id' id='episode_id' value="<%=episode_id%>" >
<input type='hidden' name='patient_id' id='patient_id' value="<%=patientId%>" >	
<input type='hidden' name='patient_class' id='patient_class' value="<%=patient_class%>" >	
<input type='hidden' name='pat_check_yn' id='pat_check_yn' value="<%=pat_check_yn%>" >	
	
<%if(install_yn.equals("Y")){%>
<jsp:include page="../../eBL/jsp/BLFinDetHiddenFlds.jsp" flush="true">
<jsp:param name="patient_id" value="<%=patientId%>" />
</jsp:include>
<%}
	/*Added by Thamizh selvi on 20th Feb 2017 against MMS-QH-CRF-0182 Start*/
	if(allowCancelAdm.equals("true"))
	{
		if(cancel_allowed_yn.equals("N"))
		{	
		
			if(Admmission.equals("IP_ADT_TRN")) 
			{%>
				<script>
					document.getElementById("Processing").innerHTML="";
					var error = getMessage("TRF_EXIST_CONT_CANCEL_ADM",'IP');
					if(!confirm(error)){
						window.close();
					}
				</script>
			<%}
			else if( Admmission.equals("IP_TRANSFER_REQUEST") )
			{%>
				<script>
					document.getElementById("Processing").innerHTML="";
					var error = getMessage("TRF_REQ_EXIST_CONT_CANCEL_ADM",'IP');
					if(!confirm(error)){
						window.close();
					}
				</script>
			<%}
			else if( Admmission.equals("IP_BED_CLASS_REQUEST") )
			{%>
				<script>
					document.getElementById("Processing").innerHTML="";
					var error = getMessage("UNCONF_BED_CLASS_REQ_EXIST",'IP');
					if(!confirm(error)){
						window.close();
					}
				</script>
			<%}
			else if(Admmission.equals("OR_ORDER"))
			{%>
				<script>
					document.getElementById("Processing").innerHTML="";
					var error = getMessage("ORD_EXIST_CANT_CANCEL_ADM",'IP');
					alert(error)
					window.close();
				</script>
			<%}
			else if(Admmission.equals("IP_DISCHARGE_ADVICE"))
			{%>
				<script>
					document.getElementById("Processing").innerHTML="";
					var error = getMessage("DISCH_ADV_EXIST_CANT_CANCEL_ADM",'IP');
					alert(error)
					window.close();
				</script>
			<%}
			else if(Admmission.equals("CA_ENCNTR_DISCR_MSR"))
			{%>
				<script>
					document.getElementById("Processing").innerHTML="";
					var error = getMessage("DISCR_MSR_EXIST_CANT_CANCEL_ADM",'IP');
					alert(error)
					window.close();
				</script>
			<%}
			else if(Admmission.equals("CA_ENCNTR_NOTE"))
			{%>
				<script>
					document.getElementById("Processing").innerHTML="";
					var error = getMessage("ENC_NOTE_EXIST_CANT_CANCEL_ADM",'IP');
					alert(error)
					window.close();
				</script>
			<%}
		}
		else if(!(cancel_allowed_yn.equals("Y")))
			{	
				if(!bill_error.equals(""))
				{
			%>
					<script>
						document.getElementById("Processing").innerHTML="";
						alert(getMessage('<%=bill_error%>','BL'));
						window.close();
					</script>
			<%	}else{%>
					<script>
					alert("<%=cancel_allowed_yn%>");
					window.close();
					</script>
			<%}%>
		<%	} 
	}/*End*/
	else{
		if(cancel_allowed_yn.equals("N"))
		{%>
			<script>
				document.getElementById("Processing").innerHTML="";
				var error = getMessage("ADMIN_CANCEL_NOT_ALLOWED",'IP');
				var error = error + ' - ' + '<%=Admmission%>';
				alert(error)
				window.close();
			</script>
		<%}
		else if(!(cancel_allowed_yn.equals("Y")))
			{	
				if(!bill_error.equals("")) //modified on 25/08/2008 for SCR 5175 
				{
			%>
					<script>
						document.getElementById("Processing").innerHTML="";
						alert(getMessage('<%=bill_error%>','BL'));
						window.close();
					</script>
			<%	}else{%>
					<script>
					alert("<%=cancel_allowed_yn%>");
					window.close();
					</script>
			<%}%>
		<%	} 
	}

		if (rs != null) rs.close();
        if (stmt != null) stmt.close();

}catch(Exception e) {
	//out.println("error in cancel admission in main: "+e.toString());
	e.printStackTrace();}
    finally
    {
        ConnectionManager.returnConnection(con,request); 
    }
%>

<script>
document.getElementById("Processing").innerHTML="";
</script>
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

