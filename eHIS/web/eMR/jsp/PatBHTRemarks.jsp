<!DOCTYPE html>
<!--
CRF Reference No     :  ML-MMOH-CRF-1959
Detected Release  No      :  SEPTEMBER 2023 Release 
File prepared by          :  SANTHOSH KUMAR N
File prepared date        :  1-07-2023
Purpose of the Change   :  As a MR user, In MR Module, I should be able to have a new function Receive BHT where the discharged records of all patient types can be changed to overdue, Delivered, returned or received.
Script Applicable for   :  Beta/Production/Both(Beta and Production)  - Applicable to All ML Sites    
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,com.ehis.util.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<%
String remarks		=	(String)request.getParameter("remarks")==null?"":(String)request.getParameter("remarks");
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language='javascript' src="../js/PatientBHT.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<title><fmt:message key="eMR.EnterRemarks.label" bundle="${mr_labels}"/></title>
<body>
<form name="BHTRemarks" id="BHTRemarks">
<table border='0' cellpadding='2' cellspacing='0' width='90%' align='center'>
<tr>
		<td  colspan="1">&nbsp;</td>	  </tr>
	  <tr>
		<td>
			&nbsp;&nbsp;
			<textarea name="remarks" rows="8" cols="90" onKeyPress='CheckForSpecCharsValidation1(event)' onBlur='makeValidString(this);CheckSplCharsValidation(this);return(CheckMaxLimit(this,"Remarks",100));'><%=remarks%></textarea>&nbsp;
			&nbsp;
		</td>
	  </tr>
	  <tr>
		<td  colspan="2" align="right"><input type="button" class="button" name="ok" id="ok" value='Ok' onClick="updateRemarks(remarks);"></td>
	  </tr>
</table>
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

