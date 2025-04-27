<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eAE/js/AEManagePatient.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown = 'lockKey()'>
<center>
<br>
<form name='AEMPAssgnTmtAreaForm' id='AEMPAssgnTmtAreaForm' method='POST' >
<table border='0' cellpadding='5' cellspacing='0' width='90%'>
<%

	String	clinic_type				=	"",		clinic_code				=	"";
	String	queue_date				=	"",		encounter_id			=	"";
	String	treatment_area_code		=	"",		practitioner_id			=	"";
	String  treatment_area_desc		=	"",		practitioner_desc		=	"" ;
	String assign_tmt_area_time		=	"";
	String locale			= (String)session.getAttribute("LOCALE");


	try
	{
		request.setCharacterEncoding("UTF-8");
		 request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
		response.setContentType("text/html;charset=UTF-8");
		clinic_code				=	 checkForNull(request.getParameter("clinic_code"));
		clinic_type				=	 checkForNull(request.getParameter("clinic_type"));
		queue_date				=	 checkForNull(request.getParameter("queue_date"));
		encounter_id			=	 checkForNull(request.getParameter("encounter_id"));
		treatment_area_code		=	 checkForNull(request.getParameter("treatment_area_code"));
		practitioner_id			=	 checkForNull(request.getParameter("practitioner_id"));
		treatment_area_desc		=	 checkForNull(request.getParameter("treatment_area_desc"));
		practitioner_desc		=	 checkForNull(request.getParameter("practitioner_name"));
		assign_tmt_area_time	=	 checkForNull(request.getParameter("assign_tmt_area_time"));
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
%>
	<tr>
		<td class=label width='22%' ><fmt:message key="eAE.AssignTreatmentArea.label" bundle="${ae_labels}"/></td><td width='25%' class='QueryData'><%=treatment_area_desc%></td>
	</tr>
	<tr>
		<td class=label width='20%' ><fmt:message key="eAE.AssignedPractitioner.label" bundle="${ae_labels}"/></td><td width='25%'  class='QueryData'><%=practitioner_desc%></td>
	</tr>

	<tr>
		<td class=label width='20%' ><fmt:message key="eAE.AssignedDateTime.label" bundle="${ae_labels}"/></td><td width='25%' class='QueryData'><%=DateUtils.convertDate(assign_tmt_area_time,"DMYHM","en",locale)%></td>
	</tr>
</table>
<p>
		<input type='button' class='BUTTON' name='ok' id='ok' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onClick='startConsultation()'>&nbsp;
		<input type='button' class='BUTTON' name='cancel' id='cancel' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' onClick='cancelOperation()'>
<br>
<input type='hidden' name='clinic_code' id='clinic_code' value='<%=clinic_code%>'>
<input type='hidden' name='clinic_type' id='clinic_type' value='<%=clinic_type%>'>
<input type='hidden' name='queue_date' id='queue_date'	value='<%=queue_date%>'>
<input type='hidden' name='encounter_id' id='encounter_id' value='<%=encounter_id%>'>
<input type='hidden' name='treatment_area_code' id='treatment_area_code' value='<%=treatment_area_code%>'>
<input type='hidden' name='practitioner_id' id='practitioner_id' value='<%=practitioner_id%>'>
<input type='hidden' name='operation_mode' id='operation_mode' value='StartConsultation'>
</table>

</form>
</center>
</body>
<%!
public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}
%>
</html>

