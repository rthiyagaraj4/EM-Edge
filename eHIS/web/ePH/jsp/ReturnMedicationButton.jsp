<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.* " %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
		
		<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../ePH/js/ReturnMedication.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../js/PHMessages.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/PHReports.js"></SCRIPT>
	<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/dchk.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




</head>
<!--<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">-->
<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">
<%
	String mode	= CommonRepository.getCommonKeyValue("MODE_MODIFY"); 
	java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
	String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
	String bean_id		= "ReturnMedicationBean"+login_at_ws_no ; ;
    String bean_name	= "ePH.ReturnMedicationBean";
    String count		= request.getParameter("countRows");

	%>
			<table width="100%" border="0">
<TR>
<td align="left" style="background-color:#CC9999" width="20%"><b><fmt:message key="ePH.Re-issuedMedication.label" bundle="${ph_labels}"/></b></td>
<TD align="right">
<%if (count.equals("0")) {%>
			<INPUT TYPE="button"  class="button" name="Return" id="Return" value='<fmt:message key="Common.Return.label" bundle="${common_labels}"/>' onClick="apply()" disabled>	
			<%}
			else
			{
				%>
			<INPUT TYPE="button"  class="button" name="Return" id="Return" value='<fmt:message key="Common.Return.label" bundle="${common_labels}"/>' onClick="apply()">	
					<%}%>
			<INPUT TYPE="button" class="button" name="Cancel" id="Cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="cancelAction()">	
			</TD></TR>
	</TABLE>
			

<INPUT TYPE="hidden" name="mode" id="mode" VALUE="<%= mode %>">
<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">

</body>
</html>

