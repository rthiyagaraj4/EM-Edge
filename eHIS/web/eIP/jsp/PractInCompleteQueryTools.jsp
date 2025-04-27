<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<HTML>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eIP/js/PractInComplete.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<%
    request.setCharacterEncoding("UTF-8");
	String IPval				= request.getParameter("IPval");	
	String Nursing_Unit_Code	= request.getParameter("NursingUnitCode");
	if (Nursing_Unit_Code==null) Nursing_Unit_Code = "";
%>

</head>
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<form name="PractInCompleteButton_form" id="PractInCompleteButton_form" action="../../servlet/eIP.AddPractInCompleteVisitServlet" method="post" target="messageFrame">
 <%	
 	if (IPval.equals("ip"))
 	{ 	
 %>	
	 
	<center>
	<table width='100%' border='0' cellspacing='0' cellpadding='0'>
	<tr>
	 <td align='right'><input type='button'  name='record' id='record' onClick='recordThisIP(this)' class='button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>"><input type='button'  name='clear' id='clear'  onClick="clearForm1()" class='button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>"><input type='button' name='cancel' id='cancel' onClick="cancelForm1()"      class='button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>">
	</td>
	</tr>
	</table>
<%
	}
	else
	{
%>	
	<tr>
	 <td align='right'><input type='button'  name='record' id='record' onClick='recordThis(this)' class='button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>" style='font-size:9;font-weight=bolder;'>
	<input type='button'  name='clear' id='clear'  onClick="clearForm()" class='button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>" style='font-size:9;font-weight=bolder;'>
	<input type='button'  name='cancel' id='cancel' onClick="cancelForm()" class='button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" style='font-size:9;font-weight=bolder;'></td>
<%
	}
%>	
	<input type='hidden' value='' name='practitioner_role' id='practitioner_role'>
	<input type='hidden' value='' name='practitioner_id' id='practitioner_id'>
	<input type='hidden' value='' name='speciality_code' id='speciality_code'>
	<input type='hidden' value='' name='Remarks' id='Remarks'>
	<input type='hidden' value='<%=IPval%>' name='IPval'>
	<input type='hidden' value='' name='consulting' id='consulting'>
	<input type='hidden' value='' name='Assisting' id='Assisting'>
	<input type='hidden' value='' name='functionmod' id='functionmod'>
	<input type='hidden' name='encounter_id' id='encounter_id' value=''>
	<input type='hidden' value='' name='RoleStartTime' id='RoleStartTime'>
	<input type='hidden' value='' name='RoleEndTime' id='RoleEndTime'>
	<input type='hidden' value='' name='SRL_NO' id='SRL_NO'>
	<input type='hidden' value='' name='hddNursingUnitCode' id='hddNursingUnitCode'>
</form>
</BODY>
</HTML>

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

