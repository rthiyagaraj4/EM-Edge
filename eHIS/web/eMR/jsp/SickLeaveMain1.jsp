<!DOCTYPE html>
<%@ page import="java.sql.Connection,java.sql.ResultSet,java.sql.Statement,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String locale			= (String)session.getAttribute("LOCALE");
Connection con = ConnectionManager.getConnection(request);
Statement stmt      = null;
ResultSet rs		= null;
String FacilityId  	= (String) session.getValue( "facility_id" );
String EncounterId  = checkForNull(request.getParameter("EncounterId"));
String PatientId    = request.getParameter("PatientId");
String PractId1     = request.getParameter("PractId");
String call_from		=checkForNull(request.getParameter("call_from"));
String SickLeaveDetails	= request.getParameter("SickLeaveDetails");
String pat_id_length= "";
String SystemDate ="";

		try
		{
			stmt = con.createStatement();
			rs	=	stmt.executeQuery("select patient_id_length, to_char(sysdate,'dd/mm/yyyy')SystemDate from mp_param");
			if (rs.next() && rs != null)
			{
				pat_id_length = rs.getString(1);
				SystemDate = rs.getString(2);
			}
			if(stmt!=null)stmt.close();
			if(rs!=null)rs.close();
		}catch(Exception e) 
		{
			//out.println("Exception in Sysdate : "+e.toString());
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
			if(stmt!=null)stmt.close();
			ConnectionManager.returnConnection(con,request);
		}

%>
<html>
<head>
<title><fmt:message key="Common.certificate.label" bundle="${common_labels}"/></title>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eMR/js/SickLeave.js' language='javascript'></script>
<script src='../../eMR/js/MRPractitionerComponent.js' language='javascript'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




<script>

</script>
</head>
<%if(!EncounterId.equals("")){%>
	<body onLoad='FocusFirstElement();' onMouseDown="CodeArrest();" onKeyDown ='lockKey()'>
<% }else{ %>
	<body onLoad='FocusFirstElement();' onMouseDown="CodeArrest();" onKeyDown ='lockKey()'>
<% } %>
<form name="SickLeaveForm" id="SickLeaveForm" action="../../servlet/eMR.SickLeaveServlet"  method="post" target="dummy">
<table width='100%' border='0' cellpadding='2' cellspacing='0' >
<tr>

		

		<td class='LABEL' width='15%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td class='field'  width='20%'><input type='text' name='patient_id' id='patient_id' tabindex=1 onKeyPress="return CheckForSpecChars(event)" value="" size='20' maxlength='<%=pat_id_length%>' onBlur="PatValidations(document.forms[0].patient_id);" >
		<input type='button' class='BUTTON' value='?' name='patient_search' id='patient_search' onClick = 'return callPatientSearch()'><img src='../../eCommon/images/mandatory.gif' align='center' id='patID_img' style="visibility:visible"></td>

		 <td class='LABEL'  width='15%'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td class='field'  width='10%'><input type='text' name='encounter_id' id='encounter_id' value='' tabindex=3 size='13' maxlength='12' onKeyPress='return(ChkNumberInput(this,event,0));' onBlur="PatEncounterValidations(document.forms[0].encounter_id);"><input type='button' class='BUTTON' value='?' name='encounter_search' id='encounter_search' onClick ='callSearchScreen()'></td>
		
		<td class='field'  width='10%' align='right'><input type="button" class="button" name="patient_search" id="patient_search" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Continue.label","common_labels")%>" onclick="callNotifiableNotes();"> </td>
		<td class='field'  width='10%'><input type="button" class="button" name="clear" id="clear" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>" onclick="Clear_vals()"> </td>
</tr>
</table>
<input type='hidden' name='call_from' id='call_from' value='<%=call_from%>'>
<input type='hidden' name='visit_adm_date' id='visit_adm_date' value=''>
<input type='hidden' name='facility_id' id='facility_id' value='<%=FacilityId%>'>
</form>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

