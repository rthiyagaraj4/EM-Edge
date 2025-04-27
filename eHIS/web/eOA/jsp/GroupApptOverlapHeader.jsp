<!DOCTYPE html>

 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*" %>

<html>
<head>
<title><fmt:message key="eOA.OverlapDetails.label" bundle="${oa_labels}"/></title>
	
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
			<tr height='100%'>
			<td class='COLUMNHEADER' nowrap style='cursor:pointer' width='15%' height='70%' ><fmt:message key="Common.apptno.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER'  width='20%' style='cursor:pointer' nowrap height='70%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER'  width='20%' style='cursor:pointer' nowrap height='70%'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER'  width='10%' style='cursor:pointer' nowrap height='70%'><b><fmt:message key="Common.fromtime.label" bundle="${common_labels}"/></b></td>
			<td class='COLUMNHEADER'  width='10%' style='cursor:pointer' nowrap height='70%'><b><fmt:message key="Common.totime.label" bundle="${common_labels}"/></b></td>
			<!--<td class='columnheader'  width='15%' style='cursor:pointer' nowrap height='70%'><b><fmt:message key="eOA.AppointmentSlips.label" bundle="${oa_labels}"/></b></td>-->
	       </tr>
		</table>
			
</body>
</html> 

