<!DOCTYPE html>
<!-- Function for cancelling the Discharge Advice -- 21 July 2001 --->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import= "java.util.*,java.sql.*,java.text.*,com.ehis.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<HTML>
<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
	String locale			= (String)session.getAttribute("LOCALE");
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet prs = null;
	String ReasonValues = "<option value=''>---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---</option>";

	con = ConnectionManager.getConnection(request);
	pstmt = con.prepareStatement(" select Contact_Reason, Contact_Reason_Code from AM_CONTACT_REASON_LANG_VW where LANGUAGE_ID = '"+locale+"' and Cancel_Discharge_Advice_Yn = 'Y' and Eff_Status = 'E' order by 1");
	prs = pstmt.executeQuery();
	if(prs!=null)
	{
		while(prs.next())
		{
			String contact_code = prs.getString("Contact_Reason_Code");
			String contact_desc = prs.getString("Contact_Reason");
			ReasonValues = ReasonValues+"<option value='"+contact_code+"'>"+contact_desc+"</option>"; 
		}
	}
	if (prs != null) prs.close();
	if (pstmt != null) pstmt.close();

%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
<TITLE> <fmt:message key="Common.DischargeAdvice.label" bundle="${common_labels}"/> </TITLE>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script src="../../eCommon/js/dchk.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
	<script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></script>
	<script src="../js/CancelDischargeAdv.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  
</head>
<script>

// Added by Sridhar on 7 AUG 2004
// Function will check for empty values before calling up the common lookup func..
function beforeGetAuthorised(target_id,target)
{
	if(document.forms[0].cancelled_hid.value != document.forms[0].cancelled_by.value)
	{
		if(document.forms[0].cancelled_by.value != "")
			 getAuthoriser(target_id,target);
	}
}

function getAuthoriser(target_id,target) 
{
	var facility_id = document.forms[0].facility_id.value;
	var locale = document.forms[0].locale.value;

	var title = getLabel("Common.authorizedby.label","Common");

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	var sql = "select APPL_USER_ID code, APPL_USER_NAME description from SM_APPL_USER_LANG_VW where language_id='"+locale+"' and EFF_STATUS = 'E' and upper(APPL_USER_ID) like upper(nvl(?,APPL_USER_ID)) and upper(APPL_USER_NAME) like upper(nvl(?,APPL_USER_NAME)) ";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4]="1,2";
	argumentArray[5]=target.value;
	argumentArray[6]=CODE_DESC_LINK;
	argumentArray[7]=CODE_DESC;
			
	var retVal = CommonLookup(title,argumentArray);
	
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].cancelled_hid.value		=	arr[0];		
		document.forms[0].cancelled_by.value	=	arr[1];
		document.forms[0].cancelled_by.focus();
		document.forms[0].cancelled_hid.value		= document.forms[0].cancelled_by.value;
	}
	else
	{
		document.forms[0].cancelled_hid.value		= "";		
		document.forms[0].cancelled_by.value	= "";
	}
}

function CancelDisc(obj)
{
	var fields = new Array();
	var names = new Array();
	var i=0;		

	fields[i]= document.forms[0].cancelled_by;
	names[i] = getLabel("Common.cancelledby.label","Common");
	i++;

	fields[i]= document.forms[0].cancel_date;
	names[i] = getLabel("Common.CancelledDate/Time.label","Common");
	i++;
	
	fields[i]= document.forms[0].ReasonForCancel;
	names[i] = getLabel("eIP.ReasonforCancel.label","IP");
	i++;

	if(checkMandatory(fields, names))
	{
		document.forms[0].submit();
	}
}

function checkMandatory( fields, names)
{
	var errors = "";
	for( var i=0; i<fields.length; i++ ) 
	{
		if(CheckVal(fields[i].value)) 
		{
		}
		else
		{
			errors = errors + getMessage("CAN_NOT_BE_BLANK","Common");
            errors = errors.replace('$',names[i]);
            errors = errors + "\n";
		}	
	}

	if ( errors.length != 0 ) 
	{
		alert(errors);
		return false;
	}
	return true;
}

function CheckVal(inString)
{
	var startPos;
	var ch;
	startPos = 0;
	strlength = inString.length;

	for(var i=0;i<=strlength;i++) {
		ch = inString.charAt(startPos);
		if((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
			startPos++;
		}
	}
	if(startPos == inString.length) return false;
	else return true;
}

</script>
<%
	Statement stmt=null;
	ResultSet rs =null;
	Statement stmt1		= null;
	StringBuffer SqlSB = new StringBuffer();
	try
	{
		stmt = con.createStatement();
		String facilityID =(String)session.getValue("facility_id");
		String encounterID=request.getParameter("EncounterId");

		String adm_date_display			= "";
		String admissiondatetime		= "";
		String admissiontypedesc		= "";
		String auth_pract_name			= "";
		String bedclassshortdesc		= "";
		String bedno					= "";
		String bedtypeshortdesc			= "";
		String dis_adv_srl_no			= "";
		String expected_discharge_date	= "";
		String ref_to_coroner_yn		= "";
		String gender					= "";
		String meddesc 					= "";
		String nursingunitshortdesc		= "";
		String patient_id				= "";
		String patienttype				= "";
		String practitionerid			= "";
		String practitionername			= "";
		String roomno					= "";
		String serviceshortdesc			= "";
		String short_desc				= "";
		String specialtyshortdesc		= "";

		SqlSB.append(" SELECT a.Room_num Room_No,");
		SqlSB.append(" ip_get_desc.IP_BED_CLASS(a.Bed_Class_Code,'"+locale+"',2) Bed_Class_Short_desc,");
		SqlSB.append(" am_get_desc.AM_PRACTITIONER(a.Attend_Practitioner_Id,'"+locale+"','1') practitioner_name,");
		SqlSB.append(" ip_get_desc.IP_BED_TYPE(a.Bed_Type_Code,'"+locale+"',2) Bed_Type_Short_desc,");
		SqlSB.append(" ip_get_desc.IP_ADMISSION_TYPE(a.admission_type,'"+locale+"','2') admission_short_desc, ");
		SqlSB.append(" To_char(a.Admission_Date_Time,'dd/mm/rrrr hh24:mi') admission_date_time,");
		SqlSB.append(" b.Sex Gender,");
		SqlSB.append(" Am_Get_desc.Am_speciality(a.Specialty_Code,'"+locale+"',2) Specialty_Short_desc,");
		SqlSB.append(" a.nurSing_Unit_Code,");
		SqlSB.append(" Am_Get_desc.Am_practitioner(a.Attend_Practitioner_Id,'"+locale+"',1) Practitioner_Short_Name,");
		SqlSB.append(" a.Encounter_Id,");
		SqlSB.append(" a.Patient_Id,");
		SqlSB.append(" To_char(b.Date_Of_Birth,'dd/mm/rrrr hh24:mi') Date_Of_Birth,");
		SqlSB.append(" decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) Patient_Name,");
		SqlSB.append(" ip_Get_desc.Ip_nursing_unit(a.Facility_Id,a.nurSing_Unit_Code,'"+locale+"',2)nurSing_Unit_Short_desc,");
		SqlSB.append(" a.Bed_num Bed_No,");
		SqlSB.append(" a.Attend_Practitioner_Id Practitioner_Id,");
		SqlSB.append(" NULL patient_type_short_desc,");
		SqlSB.append(" AM_GET_DESC.AM_SERVICE(a.service_code,'"+locale+"','2') service_short_desc,");
		SqlSB.append(" DECODE(Pat_Curr_Locn_Type,'N',ip_Get_desc.Ip_nursing_unit(a.Facility_Id, a.Pat_Curr_Locn_Code,'"+locale+"',2),");
		SqlSB.append("                                  'R', a.Pat_Curr_Locn_Code,");
		SqlSB.append(" op_Get_desc.Op_clinic(a.Facility_Id, a.Pat_Curr_Locn_Code,'"+locale+"',1)) Location_desc,");
		SqlSB.append(" a.patient_class, AM_GET_DESC.AM_MEDICAL_TEAM(a.facility_id, a.team_id, '"+locale+"','2') team_short_desc,");
		SqlSB.append(" to_char(d.expected_discharge_date,'dd/mm/rrrr hh24:mi') expected_discharge_date, d.dis_adv_srl_no, d.ref_to_coroner_yn, ");
		SqlSB.append(" ip_get_desc.ip_discharge_type(d.discharge_type_code, '"+locale+"', '2') b.short_desc, ");
		SqlSB.append(" am_get_desc.AM_PRACTITIONER(d.auth_practitioner_id, '"+locale+"', '1') auth_pract_name ");
		SqlSB.append(" FROM   IP_OPEN_ENCOUNTER a,");
		SqlSB.append("        MP_PATIENT b, IP_DISCHARGE_ADVICE d");
		SqlSB.append(" WHERE  a.facility_id = '"+facilityID+"'");
		SqlSB.append("        AND a.encounter_id = '"+encounterID+"'");
		SqlSB.append("        AND a.patient_id = b.patient_id");
		SqlSB.append("		  AND a.facility_id = d.facility_id");
		SqlSB.append("        AND a.encounter_id = d.encounter_id");
		SqlSB.append("        AND a.dis_adv_status='0'");



		rs=stmt.executeQuery(SqlSB.toString());
		if(rs.next())
		{
			admissiondatetime 		= checkForNull(rs.getString("admission_date_time"));
			adm_date_display		= DateUtils.convertDate(admissiondatetime,"DMYHM","en",locale);
			admissiontypedesc 		= checkForNull(rs.getString("admission_short_desc"));
			specialtyshortdesc 		= checkForNull(rs.getString("specialty_short_desc"));
			practitionername 		= checkForNull(rs.getString("practitioner_name"));
			patienttype 			= checkForNull(rs.getString("patient_type_short_desc"));
			nursingunitshortdesc 	= checkForNull(rs.getString("Nursing_unit_short_desc"));
			serviceshortdesc 		= checkForNull(rs.getString("service_short_desc"));
			bedno 					= checkForNull(rs.getString("bed_no"));
			roomno 					= checkForNull(rs.getString("room_no"));
			bedclassshortdesc 		= checkForNull(rs.getString("bed_class_short_desc"));
			bedtypeshortdesc 		= checkForNull(rs.getString("bed_type_short_desc"));
			gender					= checkForNull(rs.getString("gender"));
			encounterID	 			= checkForNull(rs.getString("encounter_id"));
			practitionerid			= checkForNull(rs.getString("practitioner_id"));
			patient_id				= checkForNull(rs.getString("patient_id"));
			meddesc					= checkForNull(rs.getString("team_short_desc"));
			auth_pract_name			= checkForNull(rs.getString("auth_pract_name"));			
			dis_adv_srl_no			= checkForNull(rs.getString("dis_adv_srl_no"));
			expected_discharge_date = checkForNull(rs.getString("expected_discharge_date"));
			short_desc				= checkForNull(rs.getString("short_desc"),"&nbsp;");
			ref_to_coroner_yn		= checkForNull(rs.getString("ref_to_coroner_yn"));
		}
		if(rs !=null) rs.close();
		
/* Merged with ip_open_encounter query for PE - 11/05/2010
		if (SqlSB.length() > 0)	SqlSB.delete(0, SqlSB.length());
		SqlSB.append(" Select to_char(d.expected_discharge_date,'dd/mm/rrrr hh24:mi') expected_discharge_date, d.dis_adv_srl_no, b.short_desc, c.practitioner_name auth_pract_name, d.ref_to_coroner_yn ");
		SqlSB.append(" from IP_DISCHARGE_ADVICE a , IP_DISCHARGE_TYPE_LANG_VW b, AM_PRACTITIONER_LANG_VW c ");
		SqlSB.append(" where a.facility_id = '"+facilityID+"' and b.language_id = '"+locale+"' and b.language_id = c.language_id and encounter_id = '"+encounterID+"' and a.dis_adv_status='0' ");
		SqlSB.append(" and a.discharge_type_code = b.discharge_type_code and a.auth_practitioner_id = c.practitioner_id ");
		rs = stmt.executeQuery(SqlSB.toString());
		if(rs.next())
		{
			auth_pract_name			= checkForNull(rs.getString("auth_pract_name"));			
			dis_adv_srl_no			= checkForNull(rs.getString("dis_adv_srl_no"));
			expected_discharge_date = checkForNull(rs.getString("expected_discharge_date"));
			short_desc				= checkForNull(rs.getString("short_desc"),"&nbsp;");
			ref_to_coroner_yn		= checkForNull(rs.getString("ref_to_coroner_yn"));
		}
		if(rs!=null) rs.close();	

		if (SqlSB.length() > 0)	SqlSB.delete(0, SqlSB.length());
		SqlSB.append(" Select AM_GET_DESC.AM_MEDICAL_TEAM(facility_id,team_id, '"+locale+"','2') team_short_desc from AM_PRACT_FOR_TEAM ");
		SqlSB.append(" where facility_id = '"+facilityID+"' and (FACILITY_ID, TEAM_ID) in (select facility_id, to_pract_team_id from IP_ADT_TRN ");
		SqlSB.append(" where facility_id = '"+facilityID+"' and to_practitioner_id='"+practitionerid+"' and ");
		SqlSB.append(" trn_type = 'A' and encounter_id='"+encounterID+"' ) ");
		if(rs !=null) rs.close();
		stmt1 = con.createStatement();
		rs = stmt1.executeQuery(SqlSB.toString());
		if(rs!= null)
		{
			while(rs.next())
			{				
				meddesc = rs.getString("team_short_desc");										
			}			
		}	
		if(rs !=null) rs.close();
*/
	%>

	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name='canceldischarge_form' id='canceldischarge_form' action='../../servlet/eIP.CancelDischargeAdviceServlet' method='post' target='messageFrame'>
	<table border='0' cellpadding='4' cellspacing='0' width='100%' align='center'>
	<tr><td colspan='4' class='COLUMNHEADER'><fmt:message key="Common.encounterdetails.label" bundle="${common_labels}"/></td></tr>
	<tr>
		  <td class='label' width='25%'><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td>
		  <td class='QUERYDATA' width='25%'><%=adm_date_display%><input type='hidden' name='admissiondatetime' id='admissiondatetime' value="<%=admissiondatetime%>"></td>
		  <td class='label' nowrap  width='25%'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		  <td class='QUERYDATA' width='25%'><%=encounterID%><input type='hidden' name='encounterID' id='encounterID' value="<%=encounterID%>"></td>
	</tr>
	<tr>
		  <td class='label' ><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/></td>
		  <td class='QUERYDATA' ><%=admissiontypedesc%><input type='hidden' name='admissiontypedesc' id='admissiontypedesc' value="<%=admissiontypedesc%>"></td>
		  <td class='label' >&nbsp;</td>
		  <td class='QUERYDATA' >&nbsp;<input type='hidden' name='patienttype' id='patienttype' value="<%=patienttype%>"></td>	  
	</tr>
	<tr>  
		  <td class='label' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
		  <td class='QUERYDATA' ><%=specialtyshortdesc%><input type='hidden' name='specialtyshortdesc' id='specialtyshortdesc' ></td>
		  <td class='label' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
		  <td class='QUERYDATA' ><%=practitionername%><input type='hidden' name='practitionername' id='practitionername'></td>
	</tr>
		  <td class='label' ><fmt:message key="Common.medicalteam.label" bundle="${common_labels}"/></td>
		  <td class='QUERYDATA' colspan='3'><%=meddesc%></td>
	<tr>
 </tr>
	  
	 <td colspan='4' class='COLUMNHEADER'><fmt:message key="Common.NursingUnitDetails.label" bundle="${common_labels}"/></td>
		 <tr>
			  <td class='label'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA'><%=nursingunitshortdesc%><input type='hidden' name='nursingunitshortdesc' id='nursingunitshortdesc' value="<%=nursingunitshortdesc%>"></td>
			  <td class='label'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA'><%=serviceshortdesc%><input type='hidden' name='serviceshortdesc' id='serviceshortdesc'></td>
		</tr>
		<tr>
			  <td class='label'><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA'><%=bedno%><input type='hidden' name='bedno' id='bedno' value="<%=bedno%>"></td>
			  
			  <td class='label'><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA'><%=roomno%><input type='hidden' name='roomno' id='roomno' value="<%=roomno%>"></td>
		</tr>
		<tr>
			  <td class='label'><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA'><%=bedclassshortdesc%><input type='hidden' name='bedclassshortdesc' id='bedclassshortdesc'></td>
			  <td class='label'><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA'><%=bedtypeshortdesc%><input type='hidden' name='bedtypeshortdesc' id='bedtypeshortdesc'></td>
	   </tr>
		 <td colspan='4' class='COLUMNHEADER'><fmt:message key="eIP.DischargeDetails.label" bundle="${ip_labels}"/></td>
	 <tr>
	<%
		String expected_discharge_date_display = "";
		if(expected_discharge_date == "" || expected_discharge_date.equals("null"))
			expected_discharge_date_display = "&nbsp;";
		else
			expected_discharge_date_display = DateUtils.convertDate(expected_discharge_date,"DMYHM","en",locale);
	%>
		  <td class='label' ><fmt:message key="eIP.ExpectedDischargeDateTime.label" bundle="${ip_labels}"/></td>
		  <td class='QUERYDATA' ><%=expected_discharge_date_display%><input type='hidden' name='expected_discharge_date' id='expected_discharge_date' value="<%=expected_discharge_date%>"></td>
		  <td class='label' ><fmt:message key="Common.dischargetype.label" bundle="${common_labels}"/></td>
		  <td class='QUERYDATA' ><%=short_desc%></td>
	 </tr>
	 <tr><td colspan=4></td></tr>
	 <tr>
		  <td class='label'><fmt:message key="eIP.AuthorizedPractitioner.label" bundle="${ip_labels}"/></td>
		  <td class='QUERYDATA'><%=auth_pract_name%></td>
		  <td class='label'><fmt:message key="eIP.PostMortemRequested.label" bundle="${ip_labels}"/></td>
		  <td class='QUERYDATA'>
	  <%	if(ref_to_coroner_yn.equals("Y"))
			{ %>
				<img src='../../eCommon/images/enabled.gif'align='center'></img>
	  <%	}
			else
			{	%>
				<img src='../../eCommon/images/RRnwd.gif'align='center'></img>
	  <%	}	%>
			</td>
		</tr>
		<tr>
			<td class="label" ><fmt:message key="Common.cancelledby.label" bundle="${common_labels}"/></td>
			<td class='fields' ><input type="text" name="cancelled_by" id="cancelled_by" maxlength="16" size="16" value="" onBlur='beforeGetAuthorised(document.forms[0].cancelled_hid,this);'><input type=button class='button' name='search_Authorised' id='search_Authorised' value='?' onclick="getAuthoriser(document.forms[0].cancelled_hid,document.forms[0].cancelled_by)"><img src='../../eCommon/images/mandatory.gif'align='center'></img><input type=hidden name="cancelled_hid" id="cancelled_hid" value=''></td>
			<td class="label" nowrap><fmt:message key="Common.CancelledDate/Time.label" bundle="${common_labels}"/></td> 
			<td class='fields' ><input type="text" id='cancelDate' name="cancel_date" id="cancel_date" maxlength=16 size=16 onblur="" onKeyPress='return(ChkNumberIP(this,event,2))' value=""><input type="image" src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].cancel_date.focus();return showCalendar('cancelDate',null,'hh:mm');" ></td>
		</tr>
		<%	
		String sqlReasonForCancel = " Select Contact_Reason_Code, Contact_reason from AM_CONTACT_REASON where eff_status = 'E' and cancel_discharge_yn = 'Y' ";

		pstmt = con.prepareStatement(sqlReasonForCancel);
		prs = pstmt.executeQuery();
		%>
		<tr>
			<td  class="label" width="15%"  align='right' ><fmt:message key="eIP.ReasonforCancel.label" bundle="${ip_labels}"/>&nbsp;&nbsp;</td>
			<td width="15%" colspan='3'>
				<select name='ReasonForCancel' id='ReasonForCancel' > 
				<option>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
				<%
				if(prs != null)
				{
					while(prs.next())
					{	%>
						<option value='<%=prs.getString("Contact_Reason_Code")%>'><%=prs.getString("Contact_reason")%></option>
				<%	}
				}	%>
			</select>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></td>
		</tr>
	</table>
	<table border='0' cellpadding='4' cellspacing='0' width='100%' align='center'>
 		<tr> 
			<td class='label' height='5' width='75%'></td>
			<td class='button'><input type=button class='button' name = 'cancel_discharge' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.CancelDischargePatient.label","ip_labels")%>' align = 'left' onClick='CancelDisc(this)'></td>
			<td class='button' width='5%'><input type=button class='button' name = 'close' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' align='left'  onClick='CloseWin(this)'></td>
		</tr>
		<input type ='hidden' name= 'dis_adv_srl_no' value="<%=dis_adv_srl_no%>">
		<input type ='hidden' name= 'patient_id' value="<%=patient_id%>">	
		<input type ='hidden' name= 'facility_id' value="<%=facilityID%>">	
		<input type ='hidden' name= 'locale' value="<%=locale%>">	
	</table>
	</BODY>
	<%
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		if (stmt1 != null) stmt1.close();
		if (pstmt != null) pstmt.close();
		
	}catch(Exception e) 
	{
/* 		out.println(e.toString()); */
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
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

