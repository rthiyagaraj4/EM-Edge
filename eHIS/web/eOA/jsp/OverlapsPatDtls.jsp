<!DOCTYPE html>

 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*" %>

<html>
<head>

	
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
 <table border='1' cellpadding='0' cellspacing='0' width='100%' align='center' >
			<tr>
			<td class='COLUMNHEADER' nowrap style='cursor:pointer' width='15%' height='25'><fmt:message key="Common.apptno.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER'  width='20%' style='cursor:pointer' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER'  width='20%' style='cursor:pointer' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER'  width='10%' style='cursor:pointer' nowrap><b><fmt:message key="Common.fromtime.label" bundle="${common_labels}"/></b></td>
			<td class='COLUMNHEADER'  width='10%' style='cursor:pointer' nowrap><b><fmt:message key="Common.totime.label" bundle="${common_labels}"/></b></td>
	       </tr>
		
</table>
</body>
</html> 

