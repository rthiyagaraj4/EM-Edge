<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src='../../eBL/js/PkgUtilization.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();">
	
<form name='frmPkgPatIdHeader' id='frmPkgPatIdHeader' >
	<table border='0' cellpadding='1' cellspacing='1' align='center' width='100%'>
	<tr>		
		<td class="label" width="25%"><b><fmt:message key="Common.patientId.label"   bundle="${common_labels}"/></b>
		<!--Modified by lakshmi against the issue IN:029406-->
		<INPUT TYPE="TEXT"  name="patientId" id="patientId" SIZE="10" maxlength='20' VALUE=''  onKeyPress='changeToUpper();' onBlur="callPackageDetails(this);" ><input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return getPatID()" tabindex='2'><img src='../../eCommon/images/mandatory.gif'></td>
	</tr>
</table>
</form>
</body>
</html>
<%
%>
<%!	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}
	
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>

