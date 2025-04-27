<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";

	String auth = checkForNull(request.getParameter("auth"));
	String mode = checkForNull(request.getParameter("mode"));
	String totalDisabled = "";
	if(("modify".equals(mode)) && (!("Y".equals(auth)))){
		totalDisabled = "disabled";
	}
	
	String calledForm = checkForNull(request.getParameter("calledForm"));//Added V191017-Aravindh/NMC-JD-CRF-0010.2
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eBL/js/PolicyAddTable.js"></script>
<script language="javascript" src="../../eBL/js/PolicyDefinition.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<form>
<table width='95%'>
<tr>
<td width='74vw'>
&nbsp;
</td>
<% if("policyApproval".equals(calledForm)) { %><!-- Added V191017-Aravindh/NMC-JD-CRF-0010.2 -->
	<td align='right' width='6vw'>
		<input type='button' class="BUTTON" value='Save' onClick='apply();' />&nbsp;&nbsp;&nbsp;
		<input type='button' class="BUTTON" value='Close' onClick='closeWindow();' />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</td>
<% } %>
<td align='right' width='6%'>
<%if("modify".equals(mode)){ %>
<input type='button' class="BUTTON" value='Lookup'  onClick='fnShowPolicyDetailReport();'>
<%}else{ %>
&nbsp;
<%} %>
</td>
<td align='right' width='8%'>
<input type='button' class='BUTTON' value='Add' <%=totalDisabled %> onclick='addRowNew()'></td>
<td width='2%'>
&nbsp;
</td>
<td align='left'  width='10%'>
<input type='button' class='BUTTON' value='Remove' <%=totalDisabled %> onclick='removeSelectedRow()'></td>
</tr>
</table>
<input type='hidden' name='auth' id='auth' value='<%=auth%>'>
</form>
<%!
     private String checkForNull(String inputString) {
 		return (inputString == null) ? "" : inputString;
 	}
%>
</body>
</html>

